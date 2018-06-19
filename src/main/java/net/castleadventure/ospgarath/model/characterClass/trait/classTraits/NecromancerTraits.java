package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class NecromancerTraits {

    private enum NecromancerTraitDescription {
        TRAIT_1("May use 2 handed weapon with no defense penalty"),
        TRAIT_2("Attack or evaluate rolls against any creatures of the race of wraith or wight are made as though determined"),
        TRAIT_3("At time of level up, may choose to add in place of a necromancer class power the conjurer\'s \"Counterspell\" power, or any powers listed in the conjurer\'s right side column"),
        TRAIT_4("May acquire a number of Shadow Servants equal to your base Intelligence bonus"),
        TRAIT_5("+2 to Endurance");

        private String description;

        NecromancerTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private enum NecromancerRestrictions {
        RESTRICTION_1("May not be wood elf"),
        RESTRICTION_2("Cannot regain Endurance points as a result of a power, trait, or item with the word “heal” in its title or description."),
        RESTRICTION_3("Cannot heal others");

        private String restriction;

        NecromancerRestrictions(String restriction) {
            this.restriction = restriction;
        }

        public String getRestriction() {
            return restriction;
        }
    }

    public static List<String> getRestrictionList() {
        List<String> restrictionList = new ArrayList<>();
        for (NecromancerRestrictions restriction : NecromancerRestrictions.values()) {
            restrictionList.add(restriction.getRestriction());
        }
        return restrictionList;
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (NecromancerTraitDescription trait : NecromancerTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
