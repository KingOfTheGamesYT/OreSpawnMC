/*    */ package danger.orespawn.items.armor;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import danger.orespawn.util.IHasModel;
/*    */ import java.util.Map;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.EntityEquipmentSlot;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArmorBase
/*    */   extends ItemArmor
/*    */   implements IHasModel
/*    */ {
/*    */   OrespawnArmorMaterial material;
/*    */   boolean enchanted;
/*    */   private boolean Enchanted;
/*    */   
/*    */   public ArmorBase(String name, OrespawnArmorMaterial material, EntityEquipmentSlot equipmentSlot) {
/* 29 */     super(material.Material, 1, equipmentSlot);
/* 30 */     setUnlocalizedName(name);
/* 31 */     setRegistryName(name);
/* 32 */     setCreativeTab(CreativeTabs.COMBAT);
/* 33 */     ModItems.ITEMS.add(this);
/* 34 */     this.material = material;
/* 35 */     this.enchanted = false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 41 */     OreSpawnMain.proxy.registerItemRenderer((Item)this, 0, "inventory");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onCreated(ItemStack stack, World world, EntityPlayer player) {
/* 47 */     if (!this.Enchanted) {
/*    */       
/* 49 */       Enchant(stack);
/* 50 */       this.Enchanted = true;
/*    */     } 
/*    */     
/* 53 */     super.onCreated(stack, world, player);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onUpdate(ItemStack stack, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
/* 59 */     if (!this.Enchanted) {
/*    */       
/* 61 */       Enchant(stack);
/* 62 */       this.Enchanted = true;
/*    */     } 
/*    */     
/* 65 */     super.onUpdate(stack, p_77663_2_, p_77663_3_, p_77663_4_, p_77663_5_);
/*    */   }
/*    */ 
/*    */   
/*    */   private void Enchant(ItemStack stack) {
/* 70 */     Map<Enchantment, Integer> enchantments = this.material.EnchantmentLevels.getMap();
/* 71 */     for (Map.Entry<Enchantment, Integer> o : enchantments.entrySet()) {
/*    */       
/* 73 */       Map.Entry<Enchantment, Integer> e = o;
/* 74 */       stack.addEnchantment(e.getKey(), ((Integer)e.getValue()).intValue());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\items\armor\ArmorBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */