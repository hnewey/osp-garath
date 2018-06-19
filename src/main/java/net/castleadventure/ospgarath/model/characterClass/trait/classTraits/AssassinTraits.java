package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class AssassinTraits {

    private enum AssassinTraitDescription {
        TRAIT_1("Daggers do not affect the assassin\'s damage range, and yield an additional damage roll on a critical attack"),
        TRAIT_2("All rolls (other than damage) made against Strength based classes, or monsters/villains whose highest ability is Strength, add an additional dice to the roll result equal in size to the target\'s Strength modifier"),
        TRAIT_4("All stealth rolls are made as though determined");

        private String description;

        AssassinTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private enum AssassinRestrictions {
        RESTRICTION_1("Cannot use any powers when equipping heavy armor or a shield"),
        RESTRICTION_2("Cannot be orc");

        private String restriction;

        AssassinRestrictions(String restriction) {
            this.restriction = restriction;
        }

        public String getRestriction() {
            return restriction;
        }
    }

    public static List<String> getRestrictionList() {
        List<String> restrictionList = new ArrayList<>();
        for (AssassinRestrictions restriction : AssassinRestrictions.values()) {
            restrictionList.add(restriction.getRestriction());
        }
        return restrictionList;
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (AssassinTraitDescription trait : AssassinTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
