package vespi.lostcity.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ModItemTiers implements IItemTier {


    ARTIFACT(4.0f,14,2400,4,12,null);


    private float ATTACK_DAMAGE, EFFICIENCY;
    private int DURABILITY, HARVESTLEVEL, ENCHANTABILITY;
    private Ingredient REPAIR_MATERIAL;


    private ModItemTiers(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Ingredient repairMaterial)
    {
        this.ATTACK_DAMAGE= attackDamage;
        this.EFFICIENCY = efficiency;
        this.DURABILITY  = durability;
        this.ENCHANTABILITY = enchantability;
        this.REPAIR_MATERIAL = repairMaterial;
        this.HARVESTLEVEL = harvestLevel;
    }


    @Override
    public int getMaxUses() {
        return this.DURABILITY;
    }

    @Override
    public float getEfficiency() {
        return this.EFFICIENCY;
    }

    @Override
    public float getAttackDamage() {
        return this.ATTACK_DAMAGE;
    }

    @Override
    public int getHarvestLevel() {
        return this.HARVESTLEVEL;
    }

    @Override
    public int getEnchantability() {
        return this.ENCHANTABILITY;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.REPAIR_MATERIAL;
    }
}
