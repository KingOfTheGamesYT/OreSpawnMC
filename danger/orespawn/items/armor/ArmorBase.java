/*    */ package danger.orespawn.items.armor;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import java.util.Map;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.EntityEquipmentSlot;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ArmorBase
/*    */   extends ItemArmor
/*    */ {
/*    */   OrespawnArmorMaterial material;
/*    */   boolean enchanted;
/*    */   private boolean Enchanted;
/*    */   
/*    */   public ArmorBase(String name, OrespawnArmorMaterial material, EntityEquipmentSlot equipmentSlot) {
/* 22 */     super(material.Material, 1, equipmentSlot);
/* 23 */     setUnlocalizedName(name);
/* 24 */     setRegistryName(name);
/* 25 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 26 */     ModItems.ITEMS.add(this);
/* 27 */     this.material = material;
/* 28 */     this.enchanted = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onCreated(ItemStack stack, World world, EntityPlayer player) {
/* 33 */     if (!this.Enchanted) {
/* 34 */       Enchant(stack);
/* 35 */       this.Enchanted = true;
/*    */     } 
/*    */     
/* 38 */     super.onCreated(stack, world, player);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onUpdate(ItemStack stack, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
/* 44 */     if (!this.Enchanted) {
/* 45 */       Enchant(stack);
/* 46 */       this.Enchanted = true;
/*    */     } 
/*    */     
/* 49 */     super.onUpdate(stack, p_77663_2_, p_77663_3_, p_77663_4_, p_77663_5_);
/*    */   }
/*    */   
/*    */   private void Enchant(ItemStack stack) {
/* 53 */     Map<Enchantment, Integer> enchantments = this.material.EnchantmentLevels.getMap();
/* 54 */     for (Map.Entry<Enchantment, Integer> o : enchantments.entrySet()) {
/* 55 */       Map.Entry<Enchantment, Integer> e = o;
/* 56 */       stack.addEnchantment(e.getKey(), ((Integer)e.getValue()).intValue());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\items\armor\ArmorBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */