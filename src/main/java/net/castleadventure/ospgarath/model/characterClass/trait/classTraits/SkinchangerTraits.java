package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class SkinchangerTraits {

    private enum SkinchangerTraitDescription {
        TRAIT_1("Starts with non-mount animal companion of choice. Gets a new one at start of next game if animal companion is lost or killed"),
        TRAIT_2("Can take full turn to enter/exit beast form. Once in beast form, takes no unarmed penalty, gets a +2 to endurance, and movement, but cannot speak with others except beasts, give or receive items, or make rolls to identify, evaluate, heal, or assist"),
        TRAIT_3("May automatically speak to animal companions"),
        TRAIT_4("Animal companion may take movement in place of the skinchanger");

        private String description;

        SkinchangerTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (SkinchangerTraitDescription trait : SkinchangerTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
