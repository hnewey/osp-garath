package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class BardTraits {

    private enum BardTraitDescription {
        TRAIT_1("+1 to game secrets prior to game"),
        TRAIT_2("Identify rolls are made as though determined"),
        TRAIT_3("If able to succeed on a L 15 roll in a tavern or public meeting place, may bestow a surname on another character"),
        TRAIT_4("Rolls made in conversation with NPCs are made as though determined"),
        TRAIT_5("Bards can steal dice by using powers, and may have a number of saved dice in their dice pool equal to their base L Bonus");

        private String description;

        BardTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (BardTraitDescription trait : BardTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
