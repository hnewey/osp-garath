package net.castleadventure.ospgarath.model.character.race;

import java.util.ArrayList;
import java.util.List;

public enum Race {

    DWARF("Dwarf", "A careful and stoic folk, dwarves are often mistrusting of outsiders. They are capable melee fighters, and their sturdy build lets them naturally shrug off pain. However, their commitment to the art of combat often leaves them lacking in wits."),
    HALF_ELF("Half-Elf", "More than just the combination of two races, half elves alone are given the choice to face the fate of men or elves. Because they must specialize in certain abilities to survive, half-elves often face weaknesses in specific areas as well."),
    HALF_ORC("Half-Orc", "Often considered the unholy product of two conflicting races, half-orcs are usually raised among orcs to serve in specific roles needed by their gruff civilizations. Because of this, they tend to focus on one particular ability while neglecting most others."),
    HIGH_ELF("High Elf", "Perhaps more refined than their woodland relatives, high elves are natural leaders, inspiring awe and confidence in other races. They are agile, calculating, and deadly on the battlefield, and staunch defenders of their friends and allies."),
    HOBBIT("Hobbit", "Inhabiting peaceful lands far from the borders of the wild, hobbits rarely take to a life of adventuring. Those that do however, are often found to be brave, resilient, and uncommonly lucky, though they must rely on their cunning to survive."),
    HUMAN("Human", "Once the fragile and sickly race of “second people,” the race of men has since grown and spread to dominate the civilized lands. Humans are diverse and varied in their abilities and pursuits, but share a common competition to survive and thrive."),
    ORC("Orc", "Belligerent, savage, and often reclusive, orcs are the least understood of the free races. While they seem to value strength and power above all else, some are nevertheless skilled artisans and craftsman. Their ferocity in battle is unmatched."),
    WOOD_ELF("Wood Elf", "Crafty and often unpredictable, the elves of the silvan realms are among the wisest of the free folk. Gifted as both warriors and scholars, wood elves are skilled if somewhat fragile adventurers. Their trust is not easily earned, nor is it quickly abandoned.");

    private String race;
    private String description;

    Race(String race, String description) {
        this.race = race;
        this.description = description;
    }

    public String getRace() {
        return race;
    }

    public static List<String> getRaces() {
        List<String> races = new ArrayList<>();
        for (Race race : Race.values()) {
            races.add(race.getRace());
        }
        return races;
    }

    public static String getRaceDescription(String race) {
        for (Race r : Race.values()) {
            if (r.race.equalsIgnoreCase(race)) {
                return r.description;
            }
        }
        throw new IllegalArgumentException();
    }
}
