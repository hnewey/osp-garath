package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class MarinerTraits {

    private enum MarinerTraitDescription {
        TRAIT_1("All rolls (other than damage) are made as though determined against leadership based classes, or monsters/villains whose highest ability is leadership"),
        TRAIT_2("Leadership based classes and creatures may not take free attacks against the mariner"),
        TRAIT_3("May make free attacks using a Leadership roll"),
        TRAIT_4("May double movement speed when using the \"Rank Breaker\" power"),
        TRAIT_5("+1 to defense when wielding only a 1H weapon");

        private String description;

        MarinerTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private enum MarinerRestrictions {
        RESTRICTION_1("Cannot be dwarf");

        private String restriction;

        MarinerRestrictions(String restriction) {
            this.restriction = restriction;
        }

        public String getRestriction() {
            return restriction;
        }
    }

    public static List<String> getRestrictionList() {
        List<String> restrictionList = new ArrayList<>();
        for (MarinerRestrictions restriction : MarinerRestrictions.values()) {
            restrictionList.add(restriction.getRestriction());
        }
        return restrictionList;
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (MarinerTraitDescription trait : MarinerTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
