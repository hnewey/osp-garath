package net.castleadventure.ospgarath.model.ability.power;

import net.castleadventure.ospgarath.model.ability.power.alchemist.AlchemistManager;
import net.castleadventure.ospgarath.model.ability.power.assassin.AssassinManager;
import net.castleadventure.ospgarath.model.ability.power.barbarian.BarbarianManager;
import net.castleadventure.ospgarath.model.ability.power.bard.BardManager;
import net.castleadventure.ospgarath.model.ability.power.bowman.BowmanManager;
import net.castleadventure.ospgarath.model.ability.power.brawler.BrawlerManager;
import net.castleadventure.ospgarath.model.ability.power.burglar.BurglarManager;
import net.castleadventure.ospgarath.model.ability.power.captain.CaptainManager;
import net.castleadventure.ospgarath.model.ability.power.champion.ChampionManager;
import net.castleadventure.ospgarath.model.ability.power.conjurer.ConjurerManager;
import net.castleadventure.ospgarath.model.ability.power.healer.HealerManager;
import net.castleadventure.ospgarath.model.ability.power.hunter.HunterManager;
import net.castleadventure.ospgarath.model.ability.power.mage.MageManager;
import net.castleadventure.ospgarath.model.ability.power.mariner.MarinerManager;
import net.castleadventure.ospgarath.model.ability.power.necromancer.NecromancerManager;
import net.castleadventure.ospgarath.model.ability.power.outrider.OutriderManager;
import net.castleadventure.ospgarath.model.ability.power.paladin.PaladinManager;
import net.castleadventure.ospgarath.model.ability.power.racialPowers.RacialPowersManager;
import net.castleadventure.ospgarath.model.ability.power.ranger.RangerManager;
import net.castleadventure.ospgarath.model.ability.power.scholar.ScholarManager;
import net.castleadventure.ospgarath.model.ability.power.shepherd.ShepherdManager;
import net.castleadventure.ospgarath.model.ability.power.skinchanger.SkinchangerManager;
import net.castleadventure.ospgarath.model.ability.power.sorcerer.SorcererManager;
import net.castleadventure.ospgarath.model.ability.power.sovereign.SovereignManager;
import net.castleadventure.ospgarath.model.ability.power.weaponmaster.WeaponMasterManager;

import java.util.ArrayList;
import java.util.List;

public class PowerManager {

    protected List<Power> classPowers = new ArrayList<>();

    public List<Power> getClassPowers() {
        return classPowers;
    }

    public List<String> getClassPowerDescriptions() {
        List<String> powerDescriptions = new ArrayList<>();
        for (Power power : classPowers) {
            powerDescriptions.add(power.toString());
        }
        return powerDescriptions;
    }

    public static Power getClassPower(String className, String powerName) throws Exception {
        PowerManager manager = getPowerManager(className);
        RacialPowersManager racialPowers = new RacialPowersManager();
        for (Power power : manager.getClassPowers()) {
            if (power.getName().equalsIgnoreCase(powerName)) {
                return power;
            }
        }
        for (Power power : racialPowers.getRacialPowers()) {
            if (power.getName().equalsIgnoreCase(powerName)) {
                return power;
            }
        }
        throw new Exception(String.format("Invalid power name provided: %s", powerName));
    }

    public static PowerManager getPowerManager(String className) {
        switch (className) {
            case "Champion":
                return new ChampionManager();
            case "Barbarian":
                return new BarbarianManager();
            case "Outrider":
                return new OutriderManager();
            case "Skinchanger":
                return new SkinchangerManager();
            case "Weapon Master":
                return new WeaponMasterManager();
            case "Paladin":
                return new PaladinManager();
            case "Ranger":
                return new RangerManager();
            case "Brawler":
                return new BrawlerManager();
            case "Bowman":
                return new BowmanManager();
            case "Burglar":
                return new BurglarManager();
            case "Hunter":
                return new HunterManager();
            case "Assassin":
                return new AssassinManager();
            case "Mage":
                return new MageManager();
            case "Necromancer":
                return new NecromancerManager();
            case "Sorcerer":
                return new SorcererManager();
            case "Alchemist":
                return new AlchemistManager();
            case "Conjurer":
                return new ConjurerManager();
            case "Healer":
                return new HealerManager();
            case "Captain":
                return new CaptainManager();
            case "Mariner":
                return new MarinerManager();
            case "Sovereign":
                return new SovereignManager();
            case "Shepherd":
                return new ShepherdManager();
            case "Scholar":
                return new ScholarManager();
            default:
                return new BardManager();
        }
    }
}
