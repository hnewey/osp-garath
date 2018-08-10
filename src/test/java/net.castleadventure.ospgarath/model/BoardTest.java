package net.castleadventure.ospgarath.model;

import net.castleadventure.ospgarath.game.Board;
import net.castleadventure.ospgarath.game.Space;
import org.junit.Test;

public class BoardTest {

    @Test
    public void getSpace_valid() {
        Board board = Board.getInstance();
        Space space = board.getSpace(0, 0);
        assert(space.getX() == 0);
        assert(space.getY() == 0);
    }

    @Test
    public void getSpace_invalid() {
        Board board = Board.getInstance();
        Space space = board.getSpace(-6, -6);
        assert(space == null);
    }
}
