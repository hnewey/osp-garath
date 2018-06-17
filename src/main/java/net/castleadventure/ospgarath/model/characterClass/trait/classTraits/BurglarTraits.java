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

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (BurglarTraitDescription trait : BurglarTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
