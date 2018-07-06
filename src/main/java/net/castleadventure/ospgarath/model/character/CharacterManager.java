package net.castleadventure.ospgarath.model.character;

import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.model.ability.power.PowerManager;
import net.castleadventure.ospgarath.model.character.race.Race;
import net.castleadventure.ospgarath.model.characterClass.ClassType;

public class CharacterManager {

    public static Character createRandomSteward() {
        ClassType classType = ClassType.getClassType(Dice.d24());
        Integer[] abilityValues = new Integer[] {12, 10, 8, 6};
        Integer strength=0, quickness=0, intelligence=0, leadership = 0;
        for (int i=0; i<classType.getClassCombo().length(); i++) {
            switch (classType.getClassCombo().charAt(i)) {
                case 'S':
                    strength = abilityValues[i];
                    break;
                case 'Q':
                    quickness = abilityValues[i];
                    break;
                case 'I':
                    intelligence = abilityValues[i];
                    break;
                case 'L':
                    leadership = abilityValues[i];
                    break;
            }
        }
        Character steward = new Character(strength, quickness, intelligence, leadership, 3+Dice.d3());

        PowerManager manager = PowerManager.getPowerManager(classType.getClassName());
        Integer powerIndex = Dice.dynamic(manager.getClassPowers().size());
        steward.addPower(manager.getClassPowers().get(powerIndex));
        steward.setCharacterRace(Race.getRace(Dice.dynamic(Race.values().length-1)));
        return steward;
    }
}
