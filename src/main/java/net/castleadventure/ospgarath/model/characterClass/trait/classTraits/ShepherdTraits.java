package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class ShepherdTraits {

    private enum ShepherdTraitDescription {
        TRAIT_1("Begins with 3 animal companions, and may split movements and actions with them on his turn. If killed or lost, these are replaced at the start of a new game"),
        TRAIT_2("Designates one animal companion as a trusted pet. This animal understands any command given to it by the shepherd and receives an extra d4 roll for 3 abilities, which may include Endurance. It can also choose one extra power from other animal companion types, and if adjacent to the shepherd, can take the damage from an attack that would otherwise render the shepherd unconscious or dead. This kills the trusted pet, and reduces the shepherd to 1 E point."),
        TRAIT_3("May communicate automatically with trusted pet, and may converse in a limited sense with other animals, if successful on a I v L roll");

        private String description;

        ShepherdTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private enum ShepherdRestrictions {
        RESTRICTION_1("If the Shepherd\'s trusted pet is killed, the Shepherd gains the shaken condition until the end of the current game. Additionally, the Shepherd also takes -2 to movement and cannot regain health from campfires until the end of the current game.");

        private String restriction;

        ShepherdRestrictions(String restriction) {
            this.restriction = restriction;
        }

        public String getRestriction() {
            return restriction;
        }
    }

    public static List<String> getRestrictionList() {
        List<String> restrictionList = new ArrayList<>();
        for (ShepherdRestrictions restriction : ShepherdRestrictions.values()) {
            restrictionList.add(restriction.getRestriction());
        }
        return restrictionList;
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (ShepherdTraitDescription trait : ShepherdTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
