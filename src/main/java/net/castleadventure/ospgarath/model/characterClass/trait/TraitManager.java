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

    public static List<String> getClassRestrictions(String className) {
        switch (className) {
            case "Champion":
                return ChampionTraits.getRestrictionList();
            case "Barbarian":
                return BarbarianTraits.getRestrictionList();
            case "Outrider":
                return OutriderTraits.getRestrictionList();
            case "Skinchanger":
                return SkinchangerTraits.getRestrictionList();
            case "Weapon Master":
                return WeaponMasterTraits.getRestrictionList();
            case "Paladin":
                return PaladinTraits.getRestrictionList();
            case "Ranger":
                return RangerTraits.getRestrictionList();
            case "Brawler":
                return BrawlerTraits.getRestrictionList();
            case "Bowman":
                return BowmanTraits.getRestrictionList();
            case "Burglar":
                return BurglarTraits.getRestrictionList();
            case "Hunter":
                return HunterTraits.getRestrictionList();
            case "Assassin":
                return AssassinTraits.getRestrictionList();
            case "Mage":
                return MageTraits.getRestrictionList();
            case "Necromancer":
                return NecromancerTraits.getRestrictionList();
            case "Sorcerer":
                return SorcererTraits.getRestrictionList();
            case "Alchemist":
                return AlchemistTraits.getRestrictionList();
            case "Conjurer":
                return ConjurerTraits.getRestrictionList();
            case "Healer":
                return HealerTraits.getRestrictionList();
            case "Captain":
                return CaptainTraits.getRestrictionList();
            case "Mariner":
                return MarinerTraits.getRestrictionList();
            case "Sovereign":
                return SovereignTraits.getRestrictionList();
            case "Shepherd":
                return ShepherdTraits.getRestrictionList();
            case "Scholar":
                return ScholarTraits.getRestrictionList();
            default:
                return BardTraits.getRestrictionList();
        }
    }

    public static Boolean validateRaceAndClass(String race, String className) {
        switch (className) {
            case "Barbarian":
                return !race.equalsIgnoreCase("High Elf");
            case "Outrider":
                return !race.equalsIgnoreCase("Dwarf");
            case "Skinchanger":
                return race.equalsIgnoreCase("Human") || race.equalsIgnoreCase("Orc");
            case "Ranger":
                return !race.equalsIgnoreCase("Half-orc");
            case "Brawler":
                return !race.equalsIgnoreCase("Wood Elf");
            case "Burglar":
                return !race.equalsIgnoreCase("High Elf");
            case "Hunter":
                return !(race.equalsIgnoreCase("Half-elf") || race.equalsIgnoreCase("Half-orc"));
            case "Assassin":
                return !race.equalsIgnoreCase("Orc");
            case "Mage":
                return !race.equalsIgnoreCase("Hobbit");
            case "Necromancer":
                return !race.equalsIgnoreCase("Wood Elf");
            case "Sorcerer":
                return !race.equalsIgnoreCase("Human");
            case "Mariner":
                return !race.equalsIgnoreCase("Dwarf");
            case "Sovereign":
                return !race.equalsIgnoreCase("Hobbit");
            case "Scholar":
                return !race.equalsIgnoreCase("Orc");
            default:
                return true;
        }
    }

}
