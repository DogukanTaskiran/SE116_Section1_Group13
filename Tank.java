package CannonFodder;

import java.security.SecureRandom;
import java.util.ArrayList;
public class Tank extends AllyBaseClasses {
    SecureRandom random=new SecureRandom();
    SecureRandom randomStat=new SecureRandom();

    Items items=new Items();
    Weapons weapons=new Weapons() {
        @Override
        public void itemInfo() {
            super.itemInfo();
        }
    };
    Swords swords=new Swords(items.name, items.rareLevel, items.rarity, items.attack, items.vitality,
            items.intelligence, (int) items.weight, items.actionSpeed);
    Shields shields=new Shields(items.name, items.rareLevel, items.rarity, items.attack, items.vitality,
            items.intelligence, (int) items.weight, items.actionSpeed);
    Wands wands=new Wands(items.name, items.rareLevel, items.rarity, items.attack, items.vitality,
            items.intelligence, (int) items.weight, items.actionSpeed);
    Armor armor=new Armor() {
        @Override
        public void itemInfo() {
            super.itemInfo();
        }
    };
    HeavyArmor heavyArmor=new HeavyArmor(items.name, items.rareLevel, items.rarity, items.attack, items.vitality,
            items.intelligence, (int) items.weight, items.actionSpeed);
    public int tWeapon;

    public Tank(String name, long hp, int strength, int vitality, int intelligence, Items[] equipment,
                ArrayList<Items> inventory){
        super.setName(name);
        super.setHp(Math.round((0.7*vitality) + (0.2*strength) + (0.1*intelligence)));
        super.setStrength((randomStat.nextInt(5)+1)+ weapons.getAttack()+ armor.getAttack());
        super.setVitality((randomStat.nextInt(5)+6)+ weapons.getAttack()+ armor.getAttack());
        super.setIntelligence((randomStat.nextInt(5)+3)+ weapons.getAttack()+ armor.getAttack());
        tWeapon=random.nextInt(9);
        if (tWeapon<7){
            super.equipment[0]=shields;
            super.equipment[1]=heavyArmor;
        }
        if (tWeapon==7){
            super.equipment[0]=swords;
            super.equipment[1]=heavyArmor;
        }
        if (tWeapon==8){
            super.equipment[0]=wands;
            super.equipment[1]=heavyArmor;
        }
        super.setInventory(inventory);
    }

    @Override
    public void attack(){
        setAttack(super.getVitality());
        System.out.println("Dealt " + getAttack() + " damage.");
    }

    @Override
    public void specialAction(){
        System.out.println("The target is stunned.");
    }

    @Override
    public void pick(){
        super.pick();
    }

    @Override
    public void wield(){
        super.wield();
    }

    @Override
    public void wear(){
        super.wear();
    }

    @Override
    public void examine(){
        super.examine();
    }

    @Override
    public void listInventory(){
        super.listInventory();
    }
}
