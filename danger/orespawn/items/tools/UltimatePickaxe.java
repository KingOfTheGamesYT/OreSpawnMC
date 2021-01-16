/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import javax.annotation.ParametersAreNonnullByDefault;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.init.Enchantments;
/*    */ import net.minecraft.item.ItemPickaxe;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class UltimatePickaxe
/*    */   extends ItemPickaxe {
/*    */   public UltimatePickaxe() {
/* 15 */     super(OrespawnToolMaterial.UltimateTools.Material);
/* 16 */     setUnlocalizedName("ultimate_pickaxe");
/* 17 */     setRegistryName("ultimate_pickaxe");
/* 18 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 19 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   @ParametersAreNonnullByDefault
/*    */   public void onUpdate(ItemStack stack, World world, Entity player, int itemSlot, boolean isSelected) {
/* 25 */     if (!stack.isItemEnchanted()) {
/* 26 */       stack.addEnchantment(Enchantments.EFFICIENCY, 5);
/* 27 */       stack.addEnchantment(Enchantments.FORTUNE, 5);
/*    */     } 
/* 29 */     super.onUpdate(stack, world, player, itemSlot, isSelected);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\items\tools\UltimatePickaxe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */