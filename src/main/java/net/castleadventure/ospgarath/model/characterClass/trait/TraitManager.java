package net.castleadventure.ospgarath.model.characterClass.trait;

import net.castleadventure.ospgarath.model.characterClass.trait.classTraits.*;

import java.util.List;

public class TraitManager {

    public static List<String> getClassTraits(String className) {
        switch (className) {
            case "Champion":
                return ChampionTraits.getTraitList();
            case "Barbarian":
                return BarbarianTraits.getTraitList();
            case "Outrider":
                return OutriderTraits.getTraitList();
            case "Skinchanger":
                return SkinchangerTraits.getTraitList();
            case "Weapon Master":
                return WeaponMasterTraits.getTraitList();
            case "Paladin":
                return PaladinTraits.getTraitList();
            case "Ranger":
                return RangerTraits.getTraitList();
            case "Brawler":
                return BrawlerTraits.getTraitList();
            case "Bowman":
                return BowmanTraits.getTraitList();
            case "Burglar":
                return BurglarTraits.getTraitList();
            case "Hunter":
                return HunterTraits.getTraitList();
            case "Assassin":
                return AssassinTraits.getTraitList();
            case "Mage":
                return MageTraits.getTraitList();
            case "Necromancer":
                return NecromancerTraits.getTraitList();
            case "Sorcerer":
                return SorcererTraits.getTraitList();
            case "Alchemist":
                return AlchemistTraits.getTraitList();
            case "Conjurer":
                return ConjurerTraits.getTraitList();
            case "Healer":
                return HealerTraits.getTraitList();
            case "Captain":
                return CaptainTraits.getTraitList();
            case "Mariner":
                return MarinerTraits.getTraitList();
            case "Sovereign":
                return SovereignTraits.getTraitList();
            case "Shepherd":
                return ShepherdTraits.getTraitList();
            case "Scholar":
                return ScholarTraits.getTraitList();
            default:
                return BardTraits.getTraitList();
        }
    }
}
