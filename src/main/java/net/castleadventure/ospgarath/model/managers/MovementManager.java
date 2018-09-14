package net.castleadventure.ospgarath.model.managers;

import net.castleadventure.ospgarath.game.Board;
import net.castleadventure.ospgarath.game.SpaceInfo;
import net.castleadventure.ospgarath.game.Space;

import java.util.ArrayList;
import java.util.List;

public class MovementManager {

    //Character information
    private Space characterPosition;


    private List<Space> possibleMovements = new ArrayList<>();
    private List<Space> blockedMovements = new ArrayList<>();
    private Space startingPosition;
    private Board board;

    public MovementManager() {
    }

    public List<Space> possibleMovements(Space startingPosition, int movementSpeed) {
        this.board = Board.getInstance();
        this.possibleMovements = new ArrayList<>();
        this.blockedMovements = new ArrayList<>();
        this.startingPosition = startingPosition;
        buildMovementTree(startingPosition, movementSpeed);
        return this.possibleMovements;
    }

    //blocked movements only make sense in the context of possibleMovements
    // so this is only refreshed when possible movements is refreshed
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
        if (!position.getSpaceInfo().equals(SpaceInfo.FREE) && !position.getSpaceInfo().equals(SpaceInfo.DOOR)) {
            if (!blockedMovements.contains(position)) {
                blockedMovements.add(position);
            }
            return false; //don't traverse routes blocked by obstacles or other characters
        }
        if (!possibleMovements.contains(position)) {
            possibleMovements.add(position);
        }
        return true;
    }
}
