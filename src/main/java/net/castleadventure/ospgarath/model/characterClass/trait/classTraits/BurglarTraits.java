package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class BurglarTraits {

    private enum BurglarTraitDescription {
        TRAIT_1("All rolls to stealth, steal, avoid traps, or disarm traps are made as though determined"),
        TRAIT_2("Does not provoke free attack for performing a search in combat or picking up items from the ground"),
        TRAIT_3("Daggers do not affect the burglar\'s damage range, and yield an additional damage roll on a critical attack"),
        TRAIT_4("May immediately make a free action pickpocket roll against any creature that has just performed a grapple maneuver against him. It provokes no free attack"),
        TRAIT_5("May take identified relics and identified relic potions from fallen teammates"),
        TRAIT_6("+1 to movement");

        private String description;

        BurglarTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private enum BurglarRestrictions {
        RESTRICTION_1("Cannot be high elf"),
        RESTRICTION_2("Cannot wear heavy armor");

        private String restriction;

        BurglarRestrictions(String restriction) {
            this.restriction = restriction;
        }

        public String getRestriction() {
            return restriction;
        }
    }

    public static List<String> getRestrictionList() {
        List<String> restrictionList = new ArrayList<>();
        for (BurglarRestrictions restriction : BurglarRestrictions.values()) {
            restrictionList.add(restriction.getRestriction());
        }
        return restrictionList;
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (BurglarTraitDescription trait : BurglarTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
