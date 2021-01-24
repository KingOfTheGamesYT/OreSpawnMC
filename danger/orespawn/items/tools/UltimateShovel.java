/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import javax.annotation.ParametersAreNonnullByDefault;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.init.Enchantments;
/*    */ import net.minecraft.item.ItemSpade;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class UltimateShovel
/*    */   extends ItemSpade {
/*    */   public UltimateShovel() {
/* 15 */     super(OrespawnToolMaterial.UltimateTools.Material);
/* 16 */     setUnlocalizedName("ultimate_shovel");
/* 17 */     setRegistryName("ultimate_shovel");
/* 18 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 19 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   @ParametersAreNonnullByDefault
/*    */   public void onUpdate(ItemStack stack, World world, Entity player, int itemSlot, boolean isSelected) {
/* 25 */     if (!stack.isItemEnchanted()) {
/* 26 */       stack.addEnchantment(Enchantments.EFFICIENCY, 5);
/*    */     }
/* 28 */     super.onUpdate(stack, world, player, itemSlot, isSelected);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\items\tools\UltimateShovel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */