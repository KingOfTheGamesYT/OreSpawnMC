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
/*    */ public class ItemMosquitoSeed
/*    */   extends Item
/*    */   implements IPlantable {
/*    */   public ItemMosquitoSeed() {
/* 23 */     setUnlocalizedName("mosquito_seed");
/* 24 */     setRegistryName("mosquito_seed");
/* 25 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 26 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/* 31 */     ItemStack stack = player.getHeldItem(hand);
/* 32 */     IBlockState state = worldIn.getBlockState(pos);
/* 33 */     if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, stack) && state.getBlock().canSustainPlant(state, (IBlockAccess)worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up())) {
/* 34 */       worldIn.setBlockState(pos.up(), ModBlocks.MOSQUITO_PLANT.getDefaultState());
/* 35 */       if (!player.capabilities.isCreativeMode && !worldIn.isRemote) {
/* 36 */         stack.shrink(1);
/*    */       }
/* 38 */       return EnumActionResult.SUCCESS;
/*    */     } 
/* 40 */     return EnumActionResult.FAIL;
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
/* 45 */     return EnumPlantType.Crop;
/*    */   }
/*    */ 
/*    */   
/*    */   public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
/* 50 */     return ModBlocks.MOSQUITO_PLANT.getDefaultState();
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\items\ItemMosquitoSeed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */