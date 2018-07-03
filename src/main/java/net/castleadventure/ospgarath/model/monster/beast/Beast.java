package net.castleadventure.ospgarath.model.monster.beast;

import net.castleadventure.ospgarath.model.ability.power.Power;

import java.util.ArrayList;
import java.util.List;

public abstract class Beast {

    protected String name;
    protected String type = this.getClass().getSimpleName();
    protected Boolean canSpecialAttack = true;
    protected Boolean canRidePlayer = false;
    protected Boolean untamed = false;
    protected Boolean mount = false;
    protected Integer strength;
    protected Integer quickness;
    protected Integer intelligence;
    protected Integer leadership;
    protected Integer endurance;
    protected Integer speed;
    protected Integer damage;

    protected List<Power> powers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Boolean getMount() {
        return mount;
    }

    public Boolean getCanSpecialAttack() {
        return canSpecialAttack;
    }

    public Boolean getCanRidePlayer() {
        return canRidePlayer;
    }

    public Boolean getUntamed() {
        return untamed;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getQuickness() {
        return quickness;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public Integer getLeadership() {
        return leadership;
    }

    public Integer getEndurance() {
        return endurance;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getDamage() {
        return damage;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void addPower(Power power) {
        powers.add(power);
    }
}
