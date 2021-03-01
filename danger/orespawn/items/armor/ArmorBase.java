/*    */ package danger.orespawn.items.armor;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import java.util.Map;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.inventory.EntityEquipmentSlot;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class ArmorBase
/*    */   extends ItemArmor
/*    */ {
/*    */   OrespawnArmorMaterial material;
/*    */   boolean enchanted;
/*    */   
/*    */   public ArmorBase(String name, OrespawnArmorMaterial material, EntityEquipmentSlot equipmentSlot) {
/* 21 */     super(material.Material, 1, equipmentSlot);
/* 22 */     setUnlocalizedName(name);
/* 23 */     setRegistryName(name);
/* 24 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 25 */     ModItems.ITEMS.add(this);
/* 26 */     this.material = material;
/* 27 */     this.enchanted = false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onUpdate(ItemStack stack, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
/* 33 */     if (!this.enchanted) {
/* 34 */       enchant(stack);
/* 35 */       this.enchanted = true;
/*    */     } 
/* 37 */     super.onUpdate(stack, p_77663_2_, p_77663_3_, p_77663_4_, p_77663_5_);
/*    */   }
/*    */   
/*    */   private void enchant(ItemStack stack) {
/* 41 */     Map<Enchantment, Integer> enchantments = this.material.EnchantmentLevels.getMap();
/* 42 */     for (Map.Entry<Enchantment, Integer> o : enchantments.entrySet()) {
/* 43 */       Map.Entry<Enchantment, Integer> e = o;
/* 44 */       stack.addEnchantment(e.getKey(), ((Integer)e.getValue()).intValue());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\items\armor\ArmorBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */