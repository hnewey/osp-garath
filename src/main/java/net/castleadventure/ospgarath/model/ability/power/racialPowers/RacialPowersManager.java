package net.castleadventure.ospgarath.model.ability.power.racialPowers;

import net.castleadventure.ospgarath.model.ability.power.Power;
import net.castleadventure.ospgarath.model.ability.power.PowerManager;

import java.util.ArrayList;
import java.util.List;

public class RacialPowersManager extends PowerManager {

    private List<Power> racialPowers = new ArrayList<>();

    public RacialPowersManager() {
        racialPowers.add(new Bloodlust());
        racialPowers.add(new HalfElfChoice());
        racialPowers.add(new HighFortune());
        racialPowers.add(new HobbitLuck());
        racialPowers.add(new MansResolve());
        racialPowers.add(new SavageResilience());
        racialPowers.add(new SilvanAccuracy());
        racialPowers.add(new StoutAndSturdy());
    }

    public List<Power> getRacialPowers() {
        return racialPowers;
    }
}
