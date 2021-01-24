/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import javax.annotation.ParametersAreNonnullByDefault;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.init.Enchantments;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.ItemSword;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class UltimateSword
/*    */   extends ItemSword
/*    */ {
/*    */   public UltimateSword() {
/* 16 */     super(OrespawnToolMaterial.UltimateTools.Material);
/* 17 */     setUnlocalizedName("ultimate_sword");
/* 18 */     setRegistryName("ultimate_sword");
/* 19 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 20 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   @ParametersAreNonnullByDefault
/*    */   public void onUpdate(ItemStack stack, World world, Entity player, int itemSlot, boolean isSelected) {
/* 26 */     if (!stack.isItemEnchanted()) {
/* 27 */       stack.addEnchantment(Enchantments.LOOTING, 6);
/* 28 */       stack.addEnchantment(Enchantments.UNBREAKING, 6);
/*    */     } 
/* 30 */     super.onUpdate(stack, world, player, itemSlot, isSelected);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\items\tools\UltimateSword.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */