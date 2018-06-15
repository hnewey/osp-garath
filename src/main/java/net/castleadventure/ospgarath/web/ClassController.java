package net.castleadventure.ospgarath.web;

import net.castleadventure.ospgarath.model.character.ClassType;
import net.castleadventure.ospgarath.model.monster.StatResolver;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( value =  "/class" )
public class ClassController {

    @RequestMapping(value = "/classList")
    public List<ClassType> getClassList() {
        return ClassType.getAllClasses();
    }

    @RequestMapping(value = "/validate")
    public Boolean isClassValid(
            @RequestBody String classSequence,
            @RequestBody Integer strength,
            @RequestBody Integer quickness,
            @RequestBody Integer intelligence,
            @RequestBody Integer leadership) {

        ClassType selectedClass = ClassType.getClassType(classSequence);
        List<ClassType> possibleClasses = StatResolver.getPossibleClasses(strength, quickness, intelligence, leadership);

        return possibleClasses.contains(selectedClass);
    }
}
