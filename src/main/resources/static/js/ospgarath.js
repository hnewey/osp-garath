

































//----------Arrow button movement functions-----------//
document.addEventListener('keydown', function(event) {
    hidePossibleMovements();
    //left
    if (event.keyCode === 37) {
        moveCharacter("left");
    }
    //up
    if (event.keyCode === 38) {
        moveCharacter("up");
    }
    //right
    if (event.keyCode === 39) {
        moveCharacter("right");
    }
    //down
    if (event.keyCode === 40) {
        moveCharacter("down");
    }
});

document.addEventListener('keyup', function(event) {
    //left
    if (event.keyCode === 37) {
        arrow_button_up("left");
    }
    //up
    if (event.keyCode === 38) {
        arrow_button_up("up");
    }
    //right
    if (event.keyCode === 39) {
        arrow_button_up("right");
    }
    //down
    if (event.keyCode === 40) {
        arrow_button_up("down");
    }

});

function canMoveLeft() {
    if (!checkObstacles(CHAR_X-1, CHAR_Y))
        return false;
    if (!movementSpeedRemaining(CHAR_X-1, CHAR_Y))
        return false;
    if (CHAR_X === -6)
        return false;
    if (CHAR_X === -5 && Math.abs(CHAR_Y) === 4)
        return false;
    if (CHAR_X === -4 && Math.abs(CHAR_Y) === 5)
        return false;
    if (CHAR_X === -3 && Math.abs(CHAR_Y) === 6)
        return false;
    return true;
}

function canMoveRight() {
    if (!checkObstacles(CHAR_X+1, CHAR_Y))
        return false;
    if (!movementSpeedRemaining(CHAR_X+1, CHAR_Y))
        return false;
    if (CHAR_X === 6)
        return false;
    if (CHAR_X === 5 && Math.abs(CHAR_Y) === 4)
        return false;
    if (CHAR_X === 4 && Math.abs(CHAR_Y) === 5)
        return false;
    if (CHAR_X === 3 && Math.abs(CHAR_Y) === 6)
        return false;
    return true;
}

function canMoveUp() {
    if (!checkObstacles(CHAR_X, CHAR_Y+1))
        return false;
    if (!movementSpeedRemaining(CHAR_X, CHAR_Y+1))
        return false;
    if (CHAR_Y === 6)
        return false;
    if (CHAR_Y === 5 && Math.abs(CHAR_X) === 4)
        return false;
    if (CHAR_Y === 4 && Math.abs(CHAR_X) === 5)
        return false;
    if (CHAR_Y === 3 && Math.abs(CHAR_X) === 6)
        return false;
    return true;
}

function canMoveDown() {
    if (!checkObstacles(CHAR_X, CHAR_Y-1))
        return false;
    if (!movementSpeedRemaining(CHAR_X, CHAR_Y-1))
        return false;
    if (CHAR_Y === -6)
        return false;
    if (CHAR_Y === -5 && Math.abs(CHAR_X) === 4)
        return false;
    if (CHAR_Y === -4 && Math.abs(CHAR_X) === 5)
        return false;
    if (CHAR_Y === -3 && Math.abs(CHAR_X) === 6)
        return false;
    return true;
}

function movementSpeedRemaining(possible_x, possible_y) {
    var vert = Math.abs(possible_y - START_Y);
    var hor = Math.abs(possible_x - START_X);
    return ((vert+hor) <= MOVEMENT);
}

function movementSpeedRemainingPlusOne(possible_x, possible_y) {
    var vert = Math.abs(possible_y - START_Y);
    var hor = Math.abs(possible_x - START_X);
    return ((vert+hor) <= MOVEMENT+1);
}

function movementRemaining() {
    var vert = Math.abs(CHAR_Y - START_Y);
    var hor = Math.abs(CHAR_X - START_X);
    return MOVEMENT - (vert+hor);
}

function moveCharacter(direction) {
    switch (direction) {
        case "left":
            if (!canMoveLeft()) {
                return;
            }
            CHAR_X--;
            break;
        case "up":
            if (!canMoveUp()) {
                return;
            }
            CHAR_Y++;
            break;
        case "right":
            if (!canMoveRight()) {
                return;
            }
            CHAR_X++;
            break;
        case "down":
            if (!canMoveDown()) {
                return;
            }
            CHAR_Y--;
            break;
    }
    placeCharacter(CHAR_X, CHAR_Y);
    clearActiveTooltipsters();
    arrow_button_down(direction);
    updateMovementRemaining();
}

function arrow_button_down(direction) {
    var arrow_button = document.getElementById(direction + "_arrow");
    arrow_button.src = "img/" + direction + "_button_pressed.jpg";
}

function arrow_button_up(direction) {
    var arrow_button = document.getElementById(direction + "_arrow");
    arrow_button.src = "img/" + direction + "_button.jpg";
}

function arrow_clicked(direction) {
    if (CLICK_TO_MOVE) {
        hidePossibleMovements();
        CLICK_TO_MOVE = false;
    }
    moveCharacter(direction);
}

function arrow_released(direction) {
    arrow_button_up(direction);
}

function updateMovementRemaining() {
    document.getElementById("movement_remaining").innerText = movementRemaining();
}

//----------Arrow keys div------------//
// <div id="movement_arrows">
//     <table>
//     <tr>
//     <td></td>
//     <td><img id="up_arrow" class="arrows" draggable="false" src="img/up_button.jpg" onmousedown="arrow_clicked('up')" onmouseup="arrow_released('up')"> </td>
//     <td></td>
//     </tr>
//     <tr>
//     <td><img id="left_arrow" class="arrows" draggable="false" src="img/left_button.jpg" onmousedown="arrow_clicked('left')" onmouseup="arrow_released('left')"></td>
//     <td><img id="down_arrow" class="arrows" draggable="false" src="img/down_button.jpg" onmousedown="arrow_clicked('down')" onmouseup="arrow_released('down')"></td>
//     <td><img id="right_arrow" class="arrows" draggable="false" src="img/right_button.jpg" onmousedown="arrow_clicked('right')" onmouseup="arrow_released('right')"></td>
//     </tr>
//     </table>
//</div>
