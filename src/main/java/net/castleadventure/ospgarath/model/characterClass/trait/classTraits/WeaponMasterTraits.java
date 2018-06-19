package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class WeaponMasterTraits {

    private enum WeaponMasterTraitDescription {
        TRAIT_1("Designate a permanent weapon type of your choice, and then choose one weapon of that type as weapon of choice. Get +1 to attack rolls with that specific weapon. The specific weapon itself may change at the beginning of each game, but must be of the same selected weapon type."),
        TRAIT_2("+1 to max damage when using weapon of choice"),
        TRAIT_3("May use weapon of choice to perform ranged attack with S roll instead of Q roll. Damage is rolled as though it were a melee attack");

        private String description;

        WeaponMasterTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private enum WeaponMasterRestrictions {
        RESTRICTION_1("Equipping a shield grants no defensive bonus to the weapon master"),
        RESTRICTION_2("-5 to rolls to heal others"),
        RESTRICTION_3("Cannot use any class powers if weapon of choice is not equipped, and all attack rolls take a -8 penalty");

        private String restriction;

        WeaponMasterRestrictions(String restriction) {
            this.restriction = restriction;
        }

        public String getRestriction() {
            return restriction;
        }
    }

    public static List<String> getRestrictionList() {
        List<String> restrictionList = new ArrayList<>();
        for (WeaponMasterRestrictions restriction : WeaponMasterRestrictions.values()) {
            restrictionList.add(restriction.getRestriction());
        }
        return restrictionList;
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (WeaponMasterTraitDescription trait : WeaponMasterTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
