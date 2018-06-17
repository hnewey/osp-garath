package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class RangerTraits {

    private enum RangerTraitDescription {
        TRAIT_1("+5 to rolls to heal conditions of others"),
        TRAIT_2("+5 to rolls to evaluate enemies"),
        TRAIT_3("+5 to rolls to hunt, forage food, gather firewood, or hide campfire on overmap"),
        TRAIT_4("+1 movement if no armor or shield is equipped"),
        TRAIT_5("Starts with non-mount animal companion of choice. Gets a new one at start of next game if animal companion is lost or killed"),
        TRAIT_6("Animal companion may take movement in place of the ranger");

        private String description;

        RangerTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (RangerTraitDescription trait : RangerTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
