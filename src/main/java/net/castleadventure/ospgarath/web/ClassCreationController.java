package net.castleadventure.ospgarath.web;

import net.castleadventure.ospgarath.model.characterClass.ClassType;
import net.castleadventure.ospgarath.model.characterClass.ClassDescription;
import net.castleadventure.ospgarath.model.monster.StatResolver;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value =  "/class" )
public class ClassController {

    @RequestMapping(value = "/classList", method = RequestMethod.GET)
    public List<String> getClassList() {
        List<String> classList = ClassType.getAllClassNamesWithCombos();
        classList.add(0, "");
        return classList;
    }

    @RequestMapping(value = "/classDescription/{className}", method = RequestMethod.GET)
    public String getClassDescription(
            @PathVariable ("className") String className) {
        return ClassDescription.getClassDescription(className);
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
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
