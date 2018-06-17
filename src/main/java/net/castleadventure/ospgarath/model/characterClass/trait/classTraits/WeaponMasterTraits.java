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

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (WeaponMasterTraitDescription trait : WeaponMasterTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
