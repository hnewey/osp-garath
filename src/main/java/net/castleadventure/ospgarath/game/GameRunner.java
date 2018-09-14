package net.castleadventure.ospgarath.game;

import net.castleadventure.ospgarath.model.room.EntryRoom;

import java.io.IOException;

public class GameRunner {

    private static GameRunner gameRunner;

    private GameRunner() {

    }

    public static void start() throws IOException {
        gameRunner = new GameRunner();
        GameState gameState = GameState.getInstance();
        gameState.setCurrentRoom(new EntryRoom());
        gameState.initBoard();
        gameState.printState();
        gameState.printRoomInfo();

//        while(true) {
//
//            Integer nextRoom = Integer.valueOf(gameState.getInput());
//            if (nextRoom == 0) {
//                gameState.enterPreviousRoom();
//            }
//            else {
//                gameState.enterNextRoom(nextRoom - 1);
//            }
//        }
    }
}
