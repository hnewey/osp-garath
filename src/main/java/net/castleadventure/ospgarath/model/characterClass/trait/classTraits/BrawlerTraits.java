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

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (BrawlerTraitDescription trait : BrawlerTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
