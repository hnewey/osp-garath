package net.castleadventure.ospgarath.model.character.monster;

import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.game.Space;
import net.castleadventure.ospgarath.model.ability.power.Power;
import net.castleadventure.ospgarath.model.character.Character;
import net.castleadventure.ospgarath.model.character.Stat;
import net.castleadventure.ospgarath.model.managers.MovementManager;
import net.castleadventure.ospgarath.model.character.condition.NegativeCondition;
import net.castleadventure.ospgarath.model.character.condition.PositiveCondition;
import net.castleadventure.ospgarath.model.characterClass.ClassType;
import net.castleadventure.ospgarath.model.item.Item;
import net.castleadventure.ospgarath.game.GameState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Monster extends Character{

    //TODO: potentially add a background portion

    protected int statBoostMin;
    protected int statBoostMax;

    protected MonsterLevel level;

    public Monster() {
    }

    public void startTurn() {
        //TODO: Here's where the magical AI will work

        //for now, they just end their turn immediately
        endTurn();
    }

    public void endTurn() {
//        for (NegativeCondition condition : negativeConditions) {
//            condition.endTurn();
//        }
    }

    protected void copyStats(Monster monsterToCopy) {
        this.strength = monsterToCopy.strength;
        this.quickness = monsterToCopy.quickness;
        this.intelligence = monsterToCopy.intelligence;
        this.leadership = monsterToCopy.leadership;
        this.endurance = monsterToCopy.endurance;
        this.powers = monsterToCopy.powers;
        this.playerEquippedItems = monsterToCopy.playerEquippedItems;
        this.playerInventory = monsterToCopy.playerInventory;
    }

    public void adjustStats() {
        Integer difficultyAdj = GameState.getInstance().getDifficultyAdjustment();

        strength = new Stat(strength.getValue() + Dice.dRange(statBoostMin, statBoostMax) + difficultyAdj);
        quickness = new Stat(quickness.getValue() + Dice.dRange(statBoostMin, statBoostMax) + difficultyAdj);
        intelligence = new Stat(intelligence.getValue() + Dice.dRange(statBoostMin, statBoostMax) + difficultyAdj);
        leadership = new Stat(leadership.getValue() + Dice.dRange(statBoostMin, statBoostMax) + difficultyAdj);
        defense = new Stat(quickness.getValue());
    }

    public void setClassType(ClassType classType) {
        super.setCharacterClass(classType);
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
