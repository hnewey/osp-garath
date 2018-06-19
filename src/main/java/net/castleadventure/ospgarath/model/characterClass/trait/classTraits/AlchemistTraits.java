package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class AlchemistTraits {

    private enum AlchemistTraitDescription {
        TRAIT_1("Can instantly identify any potion in his possession"),
        TRAIT_2("Starts each game with a new random relic potion which can carry over to new games if unused"),
        TRAIT_4("Rolls to resist poison are made as though determined");

        private String description;

        AlchemistTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private enum AlchemistRestrictions {
        RESTRICTION_1("Must have at least one hand unequipped and free to use any powers, unless appropriate potion is equipped");

        private String restriction;

        AlchemistRestrictions(String restriction) {
            this.restriction = restriction;
        }

        public String getRestriction() {
            return restriction;
        }
    }

    public static List<String> getRestrictionList() {
        List<String> restrictionList = new ArrayList<>();
        for (AlchemistRestrictions restriction : AlchemistRestrictions.values()) {
            restrictionList.add(restriction.getRestriction());
        }
        return restrictionList;
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (AlchemistTraitDescription trait : AlchemistTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
