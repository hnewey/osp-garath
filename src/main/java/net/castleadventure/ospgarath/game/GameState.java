package net.castleadventure.ospgarath.game;

import net.castleadventure.ospgarath.model.action.ActionManager;
import net.castleadventure.ospgarath.model.item.PlayerEquippedItems;
import net.castleadventure.ospgarath.model.item.PlayerInventory;
import net.castleadventure.ospgarath.model.character.monster.Monster;
import net.castleadventure.ospgarath.model.room.EntryRoom;
import net.castleadventure.ospgarath.model.room.Room;
import net.castleadventure.ospgarath.model.room.TowerIntro;
import net.castleadventure.ospgarath.model.character.Character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class GameState implements Serializable{

    private static final Integer MAX_DIFFICULTY_ADJUSTMENT = 5;

    private Float difficulty;
    private Integer floor;
    private Integer roomNum;
    private List<String> mistakesMade;
    private List<Character> enemies;
    private Character playerCharacter;

    private List<String> quickActions;
    private List<String> standardActions;

    //singletons
    private ActionManager actionManager = ActionManager.getInstance();
    private Board board;

    private Room currentRoom;
    private Room previousRoom;

    private Boolean finalChallengeUnlocked = false;

    //eager singleton instantiation
    private static GameState instance = new GameState();

    private GameState() {
        this.difficulty = 0.0f;
        this.floor = 1;
        this.roomNum = 0;
        this.mistakesMade = new ArrayList<>();
        this.enemies = new ArrayList<>();
//        this.currentRoom = new EntryRoom();
    }

    public static GameState getInstance() {
        return instance;
    }

    public void enterNextRoom(Integer roomIndex) {
        try {
            previousRoom = currentRoom;
            currentRoom = currentRoom.getConnectingRooms().get(roomIndex);
        } catch (Exception e) {
            System.err.println("Error generating new room");
        }
        roomNum++;
        currentRoom.initializeRoom();
    }

    public void enterPreviousRoom() {
        currentRoom = previousRoom;
        previousRoom = null;
    }

    public void endCharacterTurn() {
        playerCharacter.endTurn();

        //take turn for each current enemy
        for (Character enemy : enemies) {
            enemy.startTurn();
        }
    }

    private List<String> updateQuickActions(Character character) {
        //todo: this only needs to be DISPLAYED to the player character but should be used for the AI as well
        return actionManager.getQuickActions();
    }

    private List<String> updateStandardActions(Character character) {
        //todo: this only needs to be DISPLAYED to the player character but should be used for the AI as well
        return actionManager.getStandardActions();
    }

    public void characterAttack(Space space) {
        //TODO: We need a way to return what happened as a result of the action to display to the user
        for (Character enemy : enemies) {
            if (enemy.getPosition().equals(space)) {
//                if (this.character.basicAttack() >= enemy.getQuickness()) {
                    //cause enemy to take damage
//                    enemy.takeDamage
//                }
            }
        }
    }



    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    //---------------------------------------------------------------------------------------------

    //different from getInstance in that it updates necessary fields to give most up-to-date state
//    public GameState getGameState() {
//        this.quickActions = updateQuickActions(playerCharacter);
//        this.standardActions = updateStandardActions(playerCharacter);
//
//        return this;
//    }

    public Character getPlayerCharacter() {
        return playerCharacter;
    }
    public void setPlayerCharacter(Character character) {
        this.playerCharacter = character;
    }

    public List<String> getQuickActions() {
        return updateQuickActions(playerCharacter);
    }
    public void setQuickActions(List<String> quickActions) {
        this.quickActions = quickActions;
    }

    public List<String> getStandardActions() {
        return updateStandardActions(playerCharacter);
    }
    public void setStandardActions(List<String> standardActions) {
        this.standardActions = standardActions;
    }

    public Board getBoard() {
        return board;
    }
    public void initBoard() {
        this.board = Board.getInstance();
    }

    public int getDifficultyAdjustment() {
        return (int) (difficulty * MAX_DIFFICULTY_ADJUSTMENT);
    }
    public Float getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(Float difficulty) {
        this.difficulty = difficulty;
    }
    public void increaseDifficulty(Float increase) {
        this.difficulty += increase;
    }

    public Integer getFloor() {
        return floor;
    }
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getRoomNum() {
        return roomNum;
    }
    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<String> getMistakesMade() {
        return mistakesMade;
    }
    public void setMistakesMade(List<String> mistakesMade) {
        this.mistakesMade = mistakesMade;
    }
    public void addMistakeMade(String mistake) {
        if (this.mistakesMade == null) {
            mistakesMade = new ArrayList<>();
        }
        mistakesMade.add(mistake);
    }

    public Boolean getFinalChallengeUnlocked() {
        return finalChallengeUnlocked;
    }
    public void setFinalChallengeUnlocked(Boolean finalChallengeUnlocked) {
        this.finalChallengeUnlocked = finalChallengeUnlocked;
    }

    public void printState() {
        System.out.println("\n\n" +
                "Player Class: " + playerCharacter.getCharacterClass() + '\n' +
                "Floor: " + floor + '\n' +
                "Room Number: " + roomNum + '\n' +
                "Mistakes: " + mistakesMade.size() + '\n' +
                "Difficulty Adjustment: " + getDifficultyAdjustment() + '\n' +
                "Final Challenged Unlocked: " + finalChallengeUnlocked + "\n\n");
    }

    public void printRoomInfo() {
        System.out.println(currentRoom.toString());
    }

    public void printMessage(String message) {
        System.out.println("\n" + message);
    }
}
