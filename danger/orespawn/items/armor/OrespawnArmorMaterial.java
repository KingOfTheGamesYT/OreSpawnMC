/*    */ package danger.orespawn.items.armor;
/*    */ 
/*    */ import danger.orespawn.util.ItemEnchantments;
/*    */ import net.minecraft.init.Enchantments;
/*    */ import net.minecraft.init.SoundEvents;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ import net.minecraftforge.common.util.EnumHelper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OrespawnArmorMaterial
/*    */ {
/*    */   public final String Name;
/*    */   public final int Durability;
/*    */   public final int[] Protections;
/*    */   public final int Enchantability;
/*    */   public final float Toughness;
/*    */   public final ItemEnchantments EnchantmentLevels;
/*    */   public final ItemArmor.ArmorMaterial Material;
/*    */   
/*    */   public OrespawnArmorMaterial(String name, int durability, int[] protections, int enchantability, float toughness, ItemEnchantments enchantments) {
/* 23 */     this.Name = name;
/* 24 */     this.Durability = durability;
/* 25 */     this.Protections = protections;
/* 26 */     this.Enchantability = enchantability;
/* 27 */     this.Toughness = toughness;
/* 28 */     this.EnchantmentLevels = enchantments;
/*    */     
/* 30 */     this.Material = EnumHelper.addArmorMaterial(this.Name, "orespawn:" + this.Name, this.Durability, this.Protections, this.Enchantability, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, this.Toughness);
/*    */   }
/*    */ 
/*    */   
/* 34 */   public static final OrespawnArmorMaterial UltimateArmor = new OrespawnArmorMaterial("ultimate", 200, new int[] { 6, 12, 10, 6 }, 100, 3.0F, (new ItemEnchantments())
/* 35 */       .addEnchantment(Enchantments.RESPIRATION, 2).addEnchantment(Enchantments.AQUA_AFFINITY, 2).addEnchantment(Enchantments.PROTECTION, 5)
/* 36 */       .addEnchantment(Enchantments.FIRE_PROTECTION, 5).addEnchantment(Enchantments.PROJECTILE_PROTECTION, 5).addEnchantment(Enchantments.UNBREAKING, 0)
/* 37 */       .addEnchantment(Enchantments.FEATHER_FALLING, 3));
/*    */   
/* 39 */   public static final OrespawnArmorMaterial EmeraldArmor = new OrespawnArmorMaterial("emerald", 100, new int[] { 6, 12, 10, 6 }, 12, 3.0F, new ItemEnchantments());
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\items\armor\OrespawnArmorMaterial.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */