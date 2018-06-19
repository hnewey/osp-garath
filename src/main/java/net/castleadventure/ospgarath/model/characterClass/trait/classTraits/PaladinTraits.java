package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class PaladinTraits {

    private enum PaladinTraitDescription {
        TRAIT_1("Armor penalties do not apply to the Paladin"),
        TRAIT_2("Shields grant an extra +1 to defense when equipped"),
        TRAIT_3("May treat an equipped shield as a 1 handed weapon if no other weapons are equipped. The shield grants no bonuses to critical attacks when used in this way, and reduces the paladin\'s damage range by 1"),
        TRAIT_4("Rolls made to detect lies or deceptions are made as though determined");

        private String description;

        PaladinTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private enum PaladinRestrictions {
        RESTRICTION_1("When equipping two weapons, cannot use powers, and rolls attacks as though hampered"),
        RESTRICTION_2("Cannot use stealth or steal, or make an L roll in conversation with an NPC to lie or deceive");

        private String restriction;

        PaladinRestrictions(String restriction) {
            this.restriction = restriction;
        }

        public String getRestriction() {
            return restriction;
        }
    }

    public static List<String> getRestrictionList() {
        List<String> restrictionList = new ArrayList<>();
        for (PaladinRestrictions restriction : PaladinRestrictions.values()) {
            restrictionList.add(restriction.getRestriction());
        }
        return restrictionList;
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (PaladinTraitDescription trait : PaladinTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
