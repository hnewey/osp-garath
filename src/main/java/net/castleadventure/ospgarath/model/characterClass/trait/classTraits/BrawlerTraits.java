package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class BrawlerTraits {

    private enum BrawlerTraitDescription {
        TRAIT_1("Damage rolls from unarmed attacks use melee attack range instead of max 1"),
        TRAIT_2("Unarmed critical attacks result in an additional damage roll and one negative condition of the brawler\'s choosing other than \"paralyzed\""),
        TRAIT_3("Takes no unarmed penalties, or free attacks, for failing an unarmed attack"),
        TRAIT_4("Makes grapple maneuver rolls as though determined");

        private String description;

        BrawlerTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private enum BrawlerRestrictions {
        RESTRICTION_1("Cannot be wood elf"),
        RESTRICTION_2("When equipping bows, 2-handed weapons or shields, cannot use powers and all rolls are made as though as though hampered");

        private String restriction;

        BrawlerRestrictions(String restriction) {
            this.restriction = restriction;
        }

        public String getRestriction() {
            return restriction;
        }
    }

    public static List<String> getRestrictionList() {
        List<String> restrictionList = new ArrayList<>();
        for (BrawlerRestrictions restriction : BrawlerRestrictions.values()) {
            restrictionList.add(restriction.getRestriction());
        }
        return restrictionList;
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (BrawlerTraitDescription trait : BrawlerTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
