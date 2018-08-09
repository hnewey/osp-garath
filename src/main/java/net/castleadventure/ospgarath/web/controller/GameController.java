package net.castleadventure.ospgarath.web.controller;

import net.castleadventure.ospgarath.game.Board;
import net.castleadventure.ospgarath.model.character.Space;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping (value = "game")
public class GameController {

    @RequestMapping (value = "/board/spaces", method = RequestMethod.GET)
    public List<Space> getBoardSpaces() {
        return Board.getInstance().getSpacesAsList();
    }
}
