package net.castleadventure.ospgarath.model.character;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.game.Space;
import net.castleadventure.ospgarath.model.ability.power.Power;
import net.castleadventure.ospgarath.model.ability.power.PowerManager;
import net.castleadventure.ospgarath.model.character.condition.*;
import net.castleadventure.ospgarath.model.character.race.Race;
import net.castleadventure.ospgarath.model.characterClass.ClassType;
import net.castleadventure.ospgarath.model.item.PlayerEquippedItems;
import net.castleadventure.ospgarath.model.item.PlayerInventory;
import net.castleadventure.ospgarath.model.managers.ActionManager;
import net.castleadventure.ospgarath.model.managers.ConditionManager;
import net.castleadventure.ospgarath.model.managers.EquipmentManager;
import net.castleadventure.ospgarath.model.managers.MovementManager;
import net.castleadventure.ospgarath.model.character.monster.StatResolver;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {

    protected Stat strength;
    protected Stat quickness;
    protected Stat intelligence;
    protected Stat leadership;

    protected Stat endurance;
    protected Stat movement;
    protected Stat defense;

    protected Integer maxDamage;
    protected Integer damageTaken = 0;
    protected Integer attackDice = 1;

    protected Boolean conscious = true;

    protected ClassType characterClass;
    protected Race characterRace;
    protected Gender gender;

    protected String name;

    protected List<Power> powers = new ArrayList<>();

    private Space position;

    private MovementManager movementManager = new MovementManager();
    private ActionManager actionManager = new ActionManager();
    private ConditionManager conditionManager = new ConditionManager();
    private EquipmentManager equipmentManager = new EquipmentManager();

    @JsonIgnore
    protected PlayerEquippedItems playerEquippedItems = new PlayerEquippedItems();
    @JsonIgnore
    protected PlayerInventory playerInventory = new PlayerInventory();

    protected List<PositiveCondition> positiveConditions = new ArrayList<>();
    protected List<NegativeCondition> negativeConditions = new ArrayList<>();


    //--------------------------------------
    //Constructors
    //--------------------------------------

    public Character() {
    }

    public Character(Integer s, Integer q, Integer i, Integer l, Integer e, Integer m) {
        strength = new Stat(s);
        quickness = new Stat(q);
        intelligence = new Stat(i);
        leadership = new Stat(l);
        endurance = new Stat(e);
        movement = new Stat(m);
        defense = new Stat(q);

        position = new Space(0, -6);
        movementManager.possibleMovements(position, movement.getValue());
        maxDamage = calcMaxDamage();

        characterClass = StatResolver.getClass(s, q, i, l);
        powers = new ArrayList<>();
    }

    //--------------------------------------
    //Generalized Character methods
    //--------------------------------------

    public abstract void startTurn();

    public abstract void endTurn();

    public void sustainCondition(Integer index) {
        Condition condition = positiveConditions.get(index);
        if (Dice.d20() < condition.getRollRequired()) {
            condition.endEffect();
            positiveConditions.remove(index.intValue());
        }
    }

    public void resistCondition(Integer index) {
        Condition condition = negativeConditions.get(index);
        if (Dice.d20() >= condition.getRollRequired()) {
            condition.endEffect();
            negativeConditions.remove(index.intValue());
        }
    }

    public Integer basicAttack(Character target) {
        Integer attackRoll = null;
        if (isDetermined()) {
            for (int i = 0; i < attackDice; i++) {
                Integer attack = Dice.d20();
                if (attackRoll == null) {
                    attackRoll = attack;
                }
                if (attack > attackRoll) {
                    attackRoll = attack;
                }
            }
        }
        else {
            attackRoll = Dice.d20();
        }
        attackRoll += strength.getRollModifier();

        if (attackRoll >= target.getDefense().getValue()) {
            target.takeDamage(rollDamage());
        }
        return attackRoll;
    }

    public Integer rollDamage() {
        return Dice.dynamic(maxDamage);
    }

    public void takeDamage(Integer damage) {
        this.damageTaken += damage;
        if (damageTaken >= endurance.getValue()) {
            conscious = false;
        }
    }

    private boolean isDetermined() {
        int positive = 0;
        int negative = 0;
        for (Condition condition : positiveConditions) {
            if (condition instanceof Determined) {
                positive++;
            }
        }
        for (Condition condition : negativeConditions) {
            if (condition instanceof Hampered) {
                negative++;
            }
        }
        return positive > negative;
    }

    private Integer calcMaxDamage() {
        if (strength.getValue() > 20)
            return 5;
        if (strength.getValue() >= 16)
            return 4;
        if (strength.getValue() >= 11)
            return 3;
        if (strength.getValue() >= 6)
            return 2;
        if (strength.getValue() >= 1)
            return 1;
        else
            return 0;
    }

    public List<String> getQuickActions() {
        return ActionManager.getQuickActions(this.position);
    }

    public List<String> getStandardActions() {
        return ActionManager.getStandardActions(this.position);
    }

    public Stat getHighestStat() {
        String sequence = characterClass.getClassCombo();
        switch (sequence.charAt(0)) {
            case 'S':
                return strength;
            case 'Q':
                return quickness;
            case 'I':
                return intelligence;
            default:
                return leadership;
        }
    }

    public List<Space> getPossibleMovements() {
        return movementManager.possibleMovements(this.position, this.movement.getValue());
    }

    public List<Space> getBlockedMovements() {
        return movementManager.blockedMovements();
    }



    //--------------------------------------
    //Abstract Methods
    //--------------------------------------
    public abstract String getPlayerName();
    public abstract void setPlayerName(String playerName);


    //--------------------------------------
    //Getters and Setters
    //--------------------------------------

    public Stat getStrength() {
        return strength;
    }
    public void setStrength(Stat strength) {
        this.strength = strength;
    }
    public void modifyStat(StatType stat, Integer change, String reason) {
        switch (stat) {
            case STRENGTH:
                strength.addModifier(change, reason);
                break;
            case QUICKNESS:
                quickness.addModifier(change, reason);
                break;
            case INTELLIGENCE:
                intelligence.addModifier(change, reason);
                break;
            case LEADERSHIP:
                leadership.addModifier(change, reason);
                break;
            case MOVEMENT:
                movement.addModifier(change, reason);
                break;
            case ENDURANCE:
                endurance.addModifier(change, reason);
                break;
            case DEFENSE:
                defense.addModifier(change, reason);
        }
    }

    public Stat getQuickness() {
        return quickness;
    }
    public void setQuickness(Stat quickness) {
        this.quickness = quickness;
    }

    public Stat getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(Stat intelligence) {
        this.intelligence = intelligence;
    }

    public Stat getLeadership() {
        return leadership;
    }
    public void setLeadership(Stat leadership) {
        this.leadership = leadership;
    }

    public Stat getEndurance() {
        return endurance;
    }
    public void setEndurance(Stat endurance) {
        this.endurance = endurance;
    }

    public Stat getMovement() {
        return movement;
    }
    public void setMovement(Stat movement) {
        this.movement = movement;
    }
    public void halfMovement(String change) {
        modifyStat(StatType.MOVEMENT, movement.getValue()/2, change);
    }
    public void resetMovement() {
        movement.clearModifiers();
    }

    public Stat getDefense() {
        return defense;
    }
    public void setDefense(Stat defense) {
        this.defense = defense;
    }

    public Integer getMaxDamage() {
        return maxDamage;
    }
    public void setMaxDamage(Integer maxDamage) {
        this.maxDamage = maxDamage;
    }
    public void changeMaxDamage(Integer change) {
        this.maxDamage += change;
    }

    public ClassType getCharacterClass() {
        return characterClass;
    }
    public void setCharacterClass(ClassType characterClass) {
        this.characterClass = characterClass;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getDamageTaken() {
        return damageTaken;
    }
    public void setDamageTaken(Integer damageTaken) {
        this.damageTaken = damageTaken;
    }

    public Integer getAttackDice() {
        return attackDice;
    }
    public void setAttackDice(Integer attackDice) {
        this.attackDice = attackDice;
    }
    public void changeAttackDice(Integer change) {
        this.attackDice += change;
    }

    public Boolean getIsConscious() {
        return conscious;
    }
    public void setConscious(Boolean conscious) {
        this.conscious = conscious;
    }

    public Race getCharacterRace() {
        return characterRace;
    }
    public void setCharacterRace(Race characterRace) {
        this.characterRace = characterRace;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Power> getPowers() {
        return powers;
    }
    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }
    public void addPower(Power power) {
        this.powers.add(power);
    }

    public PlayerEquippedItems getPlayerEquippedItems() {
        return playerEquippedItems;
    }
    public void setPlayerEquippedItems(PlayerEquippedItems playerEquippedItems) {
        this.playerEquippedItems = playerEquippedItems;
    }

    public PlayerInventory getPlayerInventory() {
        return playerInventory;
    }
    public void setPlayerInventory(PlayerInventory playerInventory) {
        this.playerInventory = playerInventory;
    }

    public List<PositiveCondition> getPositiveConditions() {
        return positiveConditions;
    }
    public void setPositiveConditions(List<PositiveCondition> positiveConditions) {
        this.positiveConditions = positiveConditions;
    }

    public List<NegativeCondition> getNegativeConditions() {
        return negativeConditions;
    }
    public void setNegativeConditions(List<NegativeCondition> negativeConditions) {
        this.negativeConditions = negativeConditions;
    }

    public Space getPosition() {
        return position;
    }
    public void setPosition(Space position) {
        this.position = position;
        movementManager.possibleMovements(this.position, this.movement.getValue());
    }

}
