package net.castleadventure.ospgarath.model.character.race;

import net.castleadventure.ospgarath.game.Board;
import net.castleadventure.ospgarath.game.SpaceInfo;
import net.castleadventure.ospgarath.model.character.Space;

import java.util.ArrayList;
import java.util.List;

public class MovementManager {

    private static MovementManager instance;
    private List<Space> possibleMovements;
    private List<Space> blockedMovements;
    private Space startingPosition;
    private Board board;

    private MovementManager() {
        this.board = Board.getInstance();
    }

    public static MovementManager getInstance() {
        if (instance == null) {
            instance = new MovementManager();
        }
        return instance;
    }

    public List<Space> possibleMovements(Space startingPosition, int movementSpeed) {
        this.possibleMovements = new ArrayList<>();
        this.blockedMovements = new ArrayList<>();
        this.startingPosition = startingPosition;
        buildMovementTree(startingPosition, movementSpeed);
        return this.possibleMovements;
    }

    public List<Space> blockedMovements() {
        return this.blockedMovements;
    }

    private void buildMovementTree(Space currentPosition, int movementRemaining) {
        if (movementRemaining == 0 || currentPosition == null) {
            return;
        }
        //get four surrounding spaces as possible movements
        int x = currentPosition.getX();
        int y = currentPosition.getY();

        Space left, right, up, down;
        left = board.getSpace(x-1, y);
        right = board.getSpace(x+1, y);
        up = board.getSpace(x, y+1);
        down = board.getSpace(x, y-1);

        if (addPosition(left))
            buildMovementTree(left, movementRemaining-1);
        if (addPosition(right))
            buildMovementTree(right, movementRemaining-1);
        if (addPosition(up))
            buildMovementTree(up, movementRemaining-1);
        if (addPosition(down))
            buildMovementTree(down, movementRemaining-1);
    }

    private boolean addPosition(Space position) {
        if (position == null) {
            return false; //position will be null when trying to get an invalid space
        }
        if (!position.getSpaceInfo().equals(SpaceInfo.FREE)) {
            if (!blockedMovements.contains(position)) {
                blockedMovements.add(position);
            }
            return false; //don't traverse routes blocked by obstacles or other characters
        }
        if (position.equals(this.startingPosition)) {
            return false; //don't include starting position as a viable movement
        }
        if (!possibleMovements.contains(position)) {
            possibleMovements.add(position);
        }
        return true;
    }
}
