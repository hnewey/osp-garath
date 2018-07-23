package net.castleadventure.ospgarath.model.character;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.model.ability.power.Power;
import net.castleadventure.ospgarath.model.ability.power.PowerManager;
import net.castleadventure.ospgarath.model.character.condition.*;
import net.castleadventure.ospgarath.model.character.race.Race;
import net.castleadventure.ospgarath.model.characterClass.ClassType;
import net.castleadventure.ospgarath.model.item.PlayerEquippedItems;
import net.castleadventure.ospgarath.model.item.PlayerInventory;
import net.castleadventure.ospgarath.model.monster.StatResolver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.DefaultValue;
import java.util.ArrayList;
import java.util.List;

public class Character {

    private Stat strength;
    private Stat quickness;
    private Stat intelligence;
    private Stat leadership;

    private Integer endurance;
    private Integer movement;
    private Integer defense;

    private Integer damageTaken;
    private Integer maxDamage;
    private Integer attackDice;

    private Boolean conscious;

    private ClassType characterClass;
    private Race characterRace;
    private Gender gender;

    private String name;

    private List<Power> powers;

    @JsonIgnore
    private PlayerEquippedItems playerEquippedItems;
    @JsonIgnore
    private PlayerInventory playerInventory;

    private List<PositiveCondition> positiveConditions;
    private List<NegativeCondition> negativeConditions;

    public Character() {
        damageTaken = 0;
        attackDice = 1;
        conscious = true;
        playerEquippedItems = new PlayerEquippedItems();
        playerInventory = new PlayerInventory();
        powers = new ArrayList<>();
    }

    public Character(Integer s, Integer q, Integer i, Integer l, Integer e, Integer m) {
        strength = new Stat(s);
        quickness = new Stat(q);
        intelligence = new Stat(i);
        leadership = new Stat(l);
        endurance = e;
        movement = m;
        defense = q;

        damageTaken = 0;
        maxDamage = calcMaxDamage();
        attackDice = 1;

        conscious = true;

        playerEquippedItems = new PlayerEquippedItems();
        playerInventory = new PlayerInventory();

        characterClass = StatResolver.getClass(s, q, i, l);
        powers = new ArrayList<>();
    }

    public void setDefaultValues() {
        defense = quickness.getValue();
        damageTaken = 0;
        maxDamage = calcMaxDamage();
        attackDice = 1;
        conscious = true;
        playerEquippedItems = new PlayerEquippedItems();
        playerInventory = new PlayerInventory();
        characterClass = StatResolver.getClass(strength.getValue(), quickness.getValue(), intelligence.getValue(), leadership.getValue());
        powers = new ArrayList<>();
    }

    public static Character createFromJson(net.minidev.json.JSONObject json) throws Exception {
        JSONObject newJson = new JSONObject(json.toString());
        JSONObject abilities = newJson.getJSONObject("abilities");
        Integer s = abilities.getInt("strength"), q = abilities.getInt("quickness"), i = abilities.getInt("intelligence"),
                l = abilities.getInt("leadership"), e = abilities.getInt("endurance"), m = abilities.getInt("movement");
        Character character = new Character(s, q, i, l, e, m);
        character.setCharacterClass(ClassType.getClassByName(abilities.getString("class")));
        character.setCharacterRace(Race.getRace(abilities.getString("race")));

        String[] powers = newJson.getJSONArray("powers").getString(0).split(",");
        String className = character.getCharacterClass().getClassName();
        for (String power : powers) {
            character.addPower(PowerManager.getClassPower(className, power.trim()));
        }
        return character;
    }

    public void startTurn() {
        List<PositiveCondition> tempConditions = positiveConditions;
        for (PositiveCondition condition : tempConditions) {
            condition.startTurn();
        }
    }

    public void endTurn() {
        for (NegativeCondition condition : negativeConditions) {
            condition.endTurn();
        }
    }

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

    public Integer basicAttack() {
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
            for (int i = 0; i < attackDice; i++) {
                Integer attack = Dice.d20();
                if (attackRoll == null) {
                    attackRoll = attack;
                }
                if (attack < attackRoll) {
                    attackRoll = attack;
                }
            }
        }
        attackRoll += strength.getCurrentModifier();
        return attackRoll;
    }

    public void takeDamage(Integer damage) {
        this.damageTaken += damage;
        if (damageTaken >= endurance) {
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


    //-----------------------------------------------------------
    // Getters
    //-----------------------------------------------------------


    public Stat getStrength() {
        return strength;
    }

    public Stat getQuickness() {
        return quickness;
    }

    public Stat getIntelligence() {
        return intelligence;
    }

    public Stat getLeadership() {
        return leadership;
    }

    public Integer getEndurance() {
        return endurance;
    }

    public Integer getMovement() {
        return movement;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getMaxDamage() {
        return maxDamage;
    }

    public ClassType getCharacterClass() {
        return characterClass;
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

    public String getName() {
        return name;
    }

    public Integer getDamageTaken() {
        return damageTaken;
    }

    public Integer getAttackDice() {
        return attackDice;
    }

    public Boolean getConscious() {
        return conscious;
    }

    public Race getCharacterRace() {
        return characterRace;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public PlayerEquippedItems getPlayerEquippedItems() {
        return playerEquippedItems;
    }

    public PlayerInventory getPlayerInventory() {
        return playerInventory;
    }

    public List<PositiveCondition> getPositiveConditions() {
        return positiveConditions;
    }

    public List<NegativeCondition> getNegativeConditions() {
        return negativeConditions;
    }

    //-----------------------------------------------------------
    // Setters
    //-----------------------------------------------------------

    public void updateStats() {
        strength.setCurrentValue(strength.getBaseValue());
        quickness.setCurrentValue(quickness.getBaseValue());
        intelligence.setCurrentValue(intelligence.getBaseValue());
        leadership.setCurrentValue(leadership.getBaseValue());
        playerEquippedItems.addEffects();
        for (Condition condition : positiveConditions) {
            condition.doEffect();
        }
        for (Condition condition : negativeConditions) {
            condition.doEffect();
        }
    }

    public void changeStatPermanent(Stat stat, Integer value) {
        stat.changePermanent(value);
        stat.resetBaseModifier();
    }

    public void changeStatTemp(Stat stat, Integer value) {
        stat.changeTemp(value);
        stat.resetCurrentModifier();
    }

    public void changeEndurance(Integer change) {
        endurance += change;
    }

    public void changeMovement(Integer change) {
        movement += change;
    }

    public void changeDefense(Integer change) {
        defense += change;
    }

    public void changeMaxDamage(Integer change) {
        this.maxDamage += change;
    }

    public void changeAttackDice(Integer change) {
        this.attackDice += change;
    }

    public void halfMovement() {
        this.movement /= 2;
    }

    public void resetMovement() {
        this.movement = 6;
    }

    public void setMovement(Integer movement) {
        this.movement = movement;
    }

    public void setCharacterRace(Race characterRace) {
        this.characterRace = characterRace;
    }

    public void addPower(Power power) {
        this.powers.add(power);
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharacterClass(ClassType characterClass) {
        this.characterClass = characterClass;
    }
}
