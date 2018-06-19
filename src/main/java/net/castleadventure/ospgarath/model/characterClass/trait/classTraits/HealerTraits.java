package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class HealerTraits {

    private enum HealerTraitDescription {
        TRAIT_1("All heal related rolls are made as though determined, other than amount of E points healed. This does not apply to teammates when you are helping them heal from a disease"),
        TRAIT_2("+5 to rolls to heal self or resist negative conditions"),
        TRAIT_3("-5 to all attack rolls"),
        TRAIT_4("+1 to movement");

        private String description;

        HealerTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private enum HealerRestrictions {
        RESTRICTION_1("Must have one hand unequipped and free to use any powers"),
        RESTRICTION_2("May not willfully cause the death of another creature or else loses powers and class traits for rest of the game");

        private String restriction;

        HealerRestrictions(String restriction) {
            this.restriction = restriction;
        }

        public String getRestriction() {
            return restriction;
        }
    }

    public static List<String> getRestrictionList() {
        List<String> restrictionList = new ArrayList<>();
        for (HealerRestrictions restriction : HealerRestrictions.values()) {
            restrictionList.add(restriction.getRestriction());
        }
        return restrictionList;
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (HealerTraitDescription trait : HealerTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
