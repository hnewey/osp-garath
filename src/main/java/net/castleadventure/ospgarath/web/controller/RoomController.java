package net.castleadventure.ospgarath.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @RequestMapping(method = RequestMethod.GET)
    public String getRoom() {
        return "<h1>This is a test</h1>";
    }
}
