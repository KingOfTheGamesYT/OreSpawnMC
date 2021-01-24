/*    */ package danger.orespawn.items.food;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import mcp.MethodsReturnNonnullByDefault;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.ItemSeedFood;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MethodsReturnNonnullByDefault
/*    */ public class ItemCorn
/*    */   extends ItemSeedFood
/*    */ {
/*    */   public ItemCorn() {
/* 24 */     super(1, 1.0F, ModBlocks.CORN_PLANT, Blocks.FARMLAND);
/* 25 */     setUnlocalizedName("corn");
/* 26 */     setRegistryName("corn");
/* 27 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 28 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
/* 33 */     return ModBlocks.CORN_PLANT.getDefaultState();
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\items\food\ItemCorn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */