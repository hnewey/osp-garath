package net.castleadventure.ospgarath.model.monster;

import net.castleadventure.ospgarath.model.ability.Power;
import net.castleadventure.ospgarath.model.character.ClassType;
import net.castleadventure.ospgarath.model.item.Item;
import net.castleadventure.ospgarath.game.GameState;

import java.util.List;
import java.util.Random;

public abstract class Monster {

    //TODO: add name and potentially a background portion

    protected int strength;
    protected int quickness;
    protected int intelligence;
    protected int leadership;
    protected int endurance;

    protected int damageMin;
    protected int damageMax;
    protected int damageRolls;

    protected int statBoostMin;
    protected int statBoostMax;

    protected Monster baseMonster;
    protected MonsterLevel level;
    protected ClassType classType;

    protected List<Power> abilities;

    protected List<Item> equippedItems;
    protected List<Item> inventory;

    protected GameState gameState;

    public Monster() {
        gameState = GameState.getInstance();
    }

    protected void copyStats(Monster monsterToCopy) {
        this.strength = monsterToCopy.strength;
        this.quickness = monsterToCopy.quickness;
        this.intelligence = monsterToCopy.intelligence;
        this.leadership = monsterToCopy.leadership;
        this.endurance = monsterToCopy.endurance;
        this.abilities = monsterToCopy.abilities;
        this.equippedItems = monsterToCopy.equippedItems;
        this.inventory = monsterToCopy.inventory;
    }

    public void adjustStats() {
        Random random = new Random();

        strength += random.nextInt(statBoostMax) + statBoostMin + gameState.getDifficultyAdjustment();
        quickness += random.nextInt(statBoostMax) + statBoostMin + gameState.getDifficultyAdjustment();
        intelligence += random.nextInt(statBoostMax) + statBoostMin + gameState.getDifficultyAdjustment();
        leadership += random.nextInt(statBoostMax) + statBoostMin + gameState.getDifficultyAdjustment();
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public int getStrength() {
        return strength;
    }

    public int getQuickness() {
        return quickness;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getLeadership() {
        return leadership;
    }

    public int getEndurance() {
        return endurance;
    }

    @Override
    public String toString() {
        return "Monster: \n" +
                "Strength: " + strength + '\n' +
                "Quickness: " + quickness + '\n' +
                "Intelligence: " + intelligence + '\n' +
                "Leadership: " + leadership + '\n';
    }
}
