/*    */ package danger.orespawn.items;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumActionResult;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.EnumHand;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.EnumPlantType;
/*    */ import net.minecraftforge.common.IPlantable;
/*    */ 
/*    */ public class ItemButterflySeed
/*    */   extends Item
/*    */   implements IPlantable
/*    */ {
/*    */   public ItemButterflySeed() {
/* 24 */     setUnlocalizedName("butterfly_seed");
/* 25 */     setRegistryName("butterfly_seed");
/* 26 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 27 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/* 32 */     ItemStack stack = player.getHeldItem(hand);
/* 33 */     IBlockState state = worldIn.getBlockState(pos);
/* 34 */     if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, stack) && state.getBlock().canSustainPlant(state, (IBlockAccess)worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up())) {
/* 35 */       worldIn.setBlockState(pos.up(), ModBlocks.BUTTERFLY_PLANT.getDefaultState());
/* 36 */       if (!player.capabilities.isCreativeMode && !worldIn.isRemote) {
/* 37 */         stack.shrink(1);
/*    */       }
/* 39 */       return EnumActionResult.SUCCESS;
/*    */     } 
/* 41 */     return EnumActionResult.FAIL;
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
/* 46 */     return EnumPlantType.Crop;
/*    */   }
/*    */ 
/*    */   
/*    */   public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
/* 51 */     return ModBlocks.BUTTERFLY_PLANT.getDefaultState();
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\items\ItemButterflySeed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */