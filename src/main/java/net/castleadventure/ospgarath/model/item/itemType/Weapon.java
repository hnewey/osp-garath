package net.castleadventure.ospgarath.model.item.itemType;

import net.castleadventure.ospgarath.model.item.Item;

import java.util.Random;

public class Weapon extends Item {

    private enum WeaponType {
        SWORD, MACE, AXE, HAMMER, POLEARM, BOW, THROWN_WEAPON, DAGGER
    }

    private enum WeaponClass {
        ONE_HANDED, TWO_HANDED
    }

    private WeaponType weaponType;
    private WeaponClass weaponClass;

    public Weapon() {
        this.weaponType = WeaponType.values()[new Random().nextInt(WeaponType.values().length)];
        if (this.weaponType != WeaponType.THROWN_WEAPON && this.weaponType != WeaponType.DAGGER) {
            this.weaponClass = WeaponClass.values()[new Random().nextInt(WeaponClass.values().length)];
        }
        else {
            this.weaponClass = WeaponClass.ONE_HANDED;
        }
        setItemInfo(ItemType.WEAPON, false, true, null, this.toString());
    }

    @Override
    protected void use() {

    }

    @Override
    protected void equip() {

    }

    @Override
    protected void unequip() {

    }

    @Override
    protected void doEffect() {

    }

    @Override
    protected void endEffect() {

    }

    @Override
    public String toString() {
        return this.weaponClass.toString() + " " + this.weaponType.toString();
    }
}
