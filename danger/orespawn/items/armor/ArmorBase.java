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
/*    */ 
/*    */ 
/*    */ public class ArmorBase
/*    */   extends ItemArmor
/*    */ {
/*    */   OrespawnArmorMaterial material;
/*    */   boolean enchanted;
/*    */   private boolean Enchanted;
/*    */   
/*    */   public ArmorBase(String name, OrespawnArmorMaterial material, EntityEquipmentSlot equipmentSlot) {
/* 24 */     super(material.Material, 1, equipmentSlot);
/* 25 */     setUnlocalizedName(name);
/* 26 */     setRegistryName(name);
/* 27 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 28 */     ModItems.ITEMS.add(this);
/* 29 */     this.material = material;
/* 30 */     this.enchanted = false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onCreated(ItemStack stack, World world, EntityPlayer player) {
/* 36 */     if (!this.Enchanted) {
/*    */       
/* 38 */       Enchant(stack);
/* 39 */       this.Enchanted = true;
/*    */     } 
/*    */     
/* 42 */     super.onCreated(stack, world, player);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onUpdate(ItemStack stack, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
/* 48 */     if (!this.Enchanted) {
/*    */       
/* 50 */       Enchant(stack);
/* 51 */       this.Enchanted = true;
/*    */     } 
/*    */     
/* 54 */     super.onUpdate(stack, p_77663_2_, p_77663_3_, p_77663_4_, p_77663_5_);
/*    */   }
/*    */ 
/*    */   
/*    */   private void Enchant(ItemStack stack) {
/* 59 */     Map<Enchantment, Integer> enchantments = this.material.EnchantmentLevels.getMap();
/* 60 */     for (Map.Entry<Enchantment, Integer> o : enchantments.entrySet()) {
/*    */       
/* 62 */       Map.Entry<Enchantment, Integer> e = o;
/* 63 */       stack.addEnchantment(e.getKey(), ((Integer)e.getValue()).intValue());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespawn\items\armor\ArmorBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */