package net.castleadventure.ospgarath.model;

import net.castleadventure.ospgarath.model.character.Character;
import net.castleadventure.ospgarath.model.character.CharacterManager;
import org.junit.Test;

public class CharacterManagerTest {

    @Test
    public void getStewardTest() {
        Character steward = CharacterManager.createRandomSteward();
        System.out.println(steward.toString());
    }
}
