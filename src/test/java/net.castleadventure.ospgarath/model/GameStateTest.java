package net.castleadventure.ospgarath.model;

import net.castleadventure.ospgarath.game.GameState;
import org.junit.Test;

public class GameStateTest {

    @Test
    public void getDifficultyAdjustment() {
        GameState gameState = GameState.getInstance();

        assert (gameState.getDifficultyAdjustment() == 0);

        gameState.setDifficulty(0.2f);
        assert (gameState.getDifficultyAdjustment() == 1);

        gameState.setDifficulty(0.25f);
        assert (gameState.getDifficultyAdjustment() == 1);

        gameState.setDifficulty(0.4f);
        assert (gameState.getDifficultyAdjustment() == 2);

        gameState.setDifficulty(0.8f);
        assert (gameState.getDifficultyAdjustment() == 4);

        gameState.setDifficulty(2.0f);
        assert (gameState.getDifficultyAdjustment() == 10);
    }
}
