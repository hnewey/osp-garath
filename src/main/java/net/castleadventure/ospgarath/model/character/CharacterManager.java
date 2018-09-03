package net.castleadventure.ospgarath.model.character;

import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.model.ability.power.PowerManager;
import net.castleadventure.ospgarath.model.character.race.Race;
import net.castleadventure.ospgarath.model.characterClass.ClassType;
import net.castleadventure.ospgarath.model.characterClass.NPCName;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {

    public static Character createRandomSteward() throws Exception {
        ClassType classType;
        do {
            classType = ClassType.getClassType(Dice.d24());
        } while (classType.equals(ClassType.SOVEREIGN)); //Don't allow sovereign followers
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
        Character steward = new FollowerCharacter(strength, quickness, intelligence, leadership, 3+Dice.d3(), 6);

        PowerManager manager = PowerManager.getPowerManager(classType.getClassName());
        Integer powerIndex = Dice.dynamic(manager.getClassPowers().size());
        steward.addPower(manager.getClassPowers().get(powerIndex-1));
        steward.setCharacterRace(Race.getRace(Dice.dynamic(Race.values().length-1)));
        steward.setGender(new Gender(Dice.d2() == 1));
        steward.setName(NPCName.getRandom().toString());
        return steward;
    }

    public static List<Character> createRandomStewards(Integer amount) throws Exception {
        List<Character> stewards = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            stewards.add(createRandomSteward());
        }
        return stewards;
    }
}
