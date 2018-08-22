package net.castleadventure.ospgarath.web.controller;

import net.castleadventure.ospgarath.game.Board;
import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.game.SpaceInfo;
import net.castleadventure.ospgarath.model.character.Character;
import net.castleadventure.ospgarath.game.Space;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (value = "game")
public class GameController {

    @RequestMapping (value = "/board/spaces", method = RequestMethod.GET)
    public List<Space> getBoardSpaces() {
        return Board.getInstance().getSpacesAsList();
    }

    @RequestMapping (value = "/state", method = RequestMethod.GET)
    public GameState getState() {
        GameState instance = GameState.getInstance();
        return GameState.getInstance();
    }

    @RequestMapping (value = "/character", method = RequestMethod.GET)
    public Character getCharacter() {
        return GameState.getInstance().getCharacter();
    }

    @RequestMapping (value = "/character", method = RequestMethod.POST)
    public void updateCharacter(@RequestBody Character character) {
        GameState.getInstance().setCharacter(character);
    }

    @RequestMapping (value = "/endTurn", method = RequestMethod.POST)
    public ResponseEntity endTurn(@RequestBody Character character) {
        GameState.getInstance().setCharacter(character);
        GameState.getInstance().endCharacterTurn();
//        character.endTurn();
        return ResponseEntity.noContent().build();
    }

    @RequestMapping (value = "/move", method = RequestMethod.POST)
    public ResponseEntity moveCharacter(@RequestBody JSONObject jsonObject) throws Exception {
        Integer x = jsonObject.optInt("x");
        Integer y = jsonObject.optInt("y");
        Space space = new Space(x, y);

        GameState.getInstance().getCharacter().setPosition(space);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping (value = "/quickActions", method = RequestMethod.POST)
    public List<String> getQuickActions(@RequestBody Character character) {
        return character.getQuickActions();
    }

    @RequestMapping (value = "/standardActions", method = RequestMethod.POST)
    public List<String> getStandardActions(@RequestBody Character character) {
        return character.getStandardActions();
    }

    @RequestMapping (value = "/attack", method = RequestMethod.POST)
    public ResponseEntity attack(@RequestBody JSONObject jsonObject) throws Exception {
        Integer x = jsonObject.optInt("x");
        Integer y = jsonObject.optInt("y");
        Space space = Board.getInstance().getSpace(x, y);

        switch(space.getSpaceInfo()) {
            case FREE:
                return ResponseEntity.noContent().build();
            case OBSTACLE:
                //chance to break obstacle
                break;
            case OCCUPIED:
                //look up who occupies space, execute attack against them
                GameState.getInstance().characterAttack(space);
                break;
            case INTERACTION:
                //see if the interaction is initiated through an attack
                break;
        }
        if (space.getSpaceInfo().equals(SpaceInfo.FREE)) {
            return ResponseEntity.noContent().build();
        }



        return ResponseEntity.noContent().build();
    }

}
