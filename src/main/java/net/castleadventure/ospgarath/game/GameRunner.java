package net.castleadventure.ospgarath.game;

import java.io.IOException;

public class GameRunner {

    private static GameRunner gameRunner;

    private GameRunner() {

    }

    public static void start() throws IOException {
        gameRunner = new GameRunner();
        GameState gameState = GameState.getInstance();

        while(true) {
            gameState.printState();
            gameState.printRoomInfo();

            Integer nextRoom = Integer.valueOf(gameState.getInput());
            if (nextRoom == 0) {
                gameState.enterPreviousRoom();
            }
            else {
                gameState.enterNextRoom(nextRoom - 1);
            }
        }
    }
}
