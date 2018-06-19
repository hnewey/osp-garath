package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class SovereignTraits {

    private enum SovereignTraitDescription {
        TRAIT_1("Begins with an additional 7 GP at character creation"),
        TRAIT_2("Begins with a \"Steward\" follower at character creation, with whom he may split movements and actions. Gets a new Steward at start of next game if he currently has no followers of this type."),
        TRAIT_3("The sovereign may have a number of Steward followers up to the amount of his base Leadership bonus");

        private String description;

        SovereignTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private enum SovereignRestrictions {
        RESTRICTION_1("Cannot be hobbit"),
        RESTRICTION_2("While the sovereign is unconscious, all followers gain the hampered and staggered conditions until revived");

        private String restriction;

        SovereignRestrictions(String restriction) {
            this.restriction = restriction;
        }

        public String getRestriction() {
            return restriction;
        }
    }

    public static List<String> getRestrictionList() {
        List<String> restrictionList = new ArrayList<>();
        for (SovereignRestrictions restriction : SovereignRestrictions.values()) {
            restrictionList.add(restriction.getRestriction());
        }
        return restrictionList;
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (SovereignTraitDescription trait : SovereignTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
