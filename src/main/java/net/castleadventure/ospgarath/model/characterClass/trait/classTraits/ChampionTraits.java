package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class ChampionTraits {

    private enum ChampionTraitDescription {
        TRAIT_1("All attack rolls vs. known Villains are made as though determined"),
        TRAIT_2("+1 to damage rolls vs Villains and Captains. This does not include player characters"),
        TRAIT_3("Enemies get -2 to Special Attack rolls against the Champion"),
        TRAIT_4("+2 to L rolls made in conversation with NPCs");

        private String description;

        ChampionTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private enum ChampionRestrictions {
        RESTRICTION_1("-5 to all heal related rolls");

        private String restriction;

        ChampionRestrictions(String restriction) {
            this.restriction = restriction;
        }

        public String getRestriction() {
            return restriction;
        }
    }

    public static List<String> getRestrictionList() {
        List<String> restrictionList = new ArrayList<>();
        for (ChampionRestrictions restriction : ChampionRestrictions.values()) {
            restrictionList.add(restriction.getRestriction());
        }
        return restrictionList;
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (ChampionTraitDescription trait : ChampionTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }
}
