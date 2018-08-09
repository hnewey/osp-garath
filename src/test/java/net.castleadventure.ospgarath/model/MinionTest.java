package net.castleadventure.ospgarath.model;

import net.castleadventure.ospgarath.model.monster.Monster;
import net.castleadventure.ospgarath.model.monster.monsterTypes.Minion;
import org.junit.Test;

public class MinionTest {

    @Test
    public void minionCreationTest() {
        Monster minion = new Minion();
        assert (minion.getStrength() == 8);
    }
}
