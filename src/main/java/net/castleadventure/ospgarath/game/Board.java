package net.castleadventure.ospgarath.game;

import net.castleadventure.ospgarath.model.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static Board board;
    private Room currentRoom;

    private static final int WIDTH = 13;
    private static final int HEIGHT = 13;

    //space information is treated like an xy-graph so we need to adjust x and y when creating a new space
    private static final int XY_ADJ = 6;

    private Space[][] spaces = new Space[WIDTH][HEIGHT];

    private Board(Room currentRoom) {
        this.currentRoom = currentRoom;
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                //only create spaces within the board
                if (Math.abs(x-XY_ADJ) + Math.abs(y-XY_ADJ) > 9) {
                    continue;
                }
                spaces[x][y] = (new Space(x-XY_ADJ, y-XY_ADJ));

                if (currentRoom.getSpaceInfos()[x][y] != null) {
                    spaces[x][y].setSpaceInfo(currentRoom.getSpaceInfos()[x][y]);
                }
            }
        }
    }

    public static Board getInstance() {
        if (board == null) {
            try {
                board = new Board(GameState.getInstance().getCurrentRoom());
            } catch (Exception e) {
                System.err.println("Error creating board");
            }
        }
        return board;
    }

    public static void regenerateBoard(Room currentRoom) {
        board = new Board(currentRoom);
    }

    public Space getSpace(int x, int y) {
        try {
            return spaces[x + XY_ADJ][y + XY_ADJ];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public SpaceInfo getSpaceInfo(int x, int y) {
        try {
            return spaces[x + XY_ADJ][y + XY_ADJ].getSpaceInfo();
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public void updateSpace(Space space) {
        spaces[space.getX()+XY_ADJ][space.getY()+XY_ADJ] = space;
    }

    public Space[][] getSpaces() {
        return spaces;
    }

    public List<Space> getSpacesAsList () {
        List<Space> spacesList = new ArrayList<>();

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (spaces[x][y] == null) {
                    continue;
                }
                spacesList.add(spaces[x][y]);
            }
        }
        return spacesList;
    }
}
