/*     */ package danger.orespawn.items.tools;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.init.ModItems;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.annotation.ParametersAreNonnullByDefault;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFarmland;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Enchantments;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.ItemHoe;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumActionResult;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.SoundCategory;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.event.ForgeEventFactory;
/*     */ 
/*     */ public class UltimateHoe
/*     */   extends ItemHoe {
/*     */   public UltimateHoe() {
/*  30 */     super(OrespawnToolMaterial.UltimateTools.Material);
/*  31 */     setUnlocalizedName("ultimate_hoe");
/*  32 */     setRegistryName("ultimate_hoe");
/*  33 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/*  34 */     ModItems.ITEMS.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   @ParametersAreNonnullByDefault
/*     */   public void onUpdate(ItemStack stack, World world, Entity player, int itemSlot, boolean isSelected) {
/*  40 */     if (!stack.isItemEnchanted()) {
/*  41 */       stack.addEnchantment(Enchantments.EFFICIENCY, 2);
/*     */     }
/*  43 */     super.onUpdate(stack, world, player, itemSlot, isSelected);
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/*  48 */     ItemStack itemstack = player.getHeldItem(hand);
/*     */     
/*  50 */     if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack)) {
/*  51 */       return EnumActionResult.FAIL;
/*     */     }
/*  53 */     int hook = ForgeEventFactory.onHoeUse(itemstack, player, worldIn, pos);
/*  54 */     if (hook != 0) return (hook > 0) ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
/*     */     
/*  56 */     IBlockState iblockstate = worldIn.getBlockState(pos);
/*  57 */     Block original = iblockstate.getBlock();
/*     */     
/*  59 */     if (facing == EnumFacing.DOWN || !worldIn.isAirBlock(pos.up())) {
/*  60 */       return EnumActionResult.PASS;
/*     */     }
/*  62 */     if (original != Blocks.DIRT && original != Blocks.GRASS) {
/*  63 */       return EnumActionResult.PASS;
/*     */     }
/*  65 */     worldIn.setBlockState(pos, Blocks.FARMLAND.getDefaultState().withProperty((IProperty)BlockFarmland.MOISTURE, Integer.valueOf(7)));
/*     */     
/*  67 */     List<BlockPos> blockPositions = new ArrayList<>();
/*  68 */     blockPositions.add(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()));
/*  69 */     blockPositions.add(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1));
/*  70 */     blockPositions.add(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1));
/*  71 */     blockPositions.add(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()));
/*  72 */     blockPositions.add(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 1));
/*  73 */     blockPositions.add(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1));
/*  74 */     blockPositions.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1));
/*  75 */     blockPositions.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1));
/*     */ 
/*     */     
/*  78 */     for (BlockPos blockPosition : blockPositions) {
/*  79 */       if (worldIn.getBlockState(blockPosition).getBlock() == Blocks.GRASS || worldIn
/*  80 */         .getBlockState(blockPosition).getBlock() == Blocks.DIRT) {
/*  81 */         BlockPos abovePos = new BlockPos(blockPosition.getX(), blockPosition.getY() + 1, blockPosition.getZ());
/*  82 */         Block blockAbove = worldIn.getBlockState(abovePos).getBlock();
/*  83 */         if (blockAbove == Blocks.AIR) {
/*  84 */           worldIn.setBlockState(blockPosition, Blocks.FARMLAND.getDefaultState().withProperty((IProperty)BlockFarmland.MOISTURE, Integer.valueOf(7))); continue;
/*  85 */         }  if (blockAbove == Blocks.GRASS || blockAbove == Blocks.DIRT) {
/*  86 */           BlockPos abovePos2 = new BlockPos(abovePos.getX(), abovePos.getY() + 1, abovePos.getZ());
/*  87 */           Block blockAbove2 = worldIn.getBlockState(abovePos2).getBlock();
/*  88 */           if (blockAbove2 == Blocks.AIR)
/*  89 */             worldIn.setBlockState(abovePos, Blocks.FARMLAND.getDefaultState().withProperty((IProperty)BlockFarmland.MOISTURE, Integer.valueOf(7))); 
/*     */         }  continue;
/*     */       } 
/*  92 */       if (worldIn.getBlockState(blockPosition).getBlock() == Blocks.AIR) {
/*  93 */         BlockPos underPos = new BlockPos(blockPosition.getX(), blockPosition.getY() - 1, blockPosition.getZ());
/*  94 */         Block blockUnder = worldIn.getBlockState(underPos).getBlock();
/*  95 */         if (worldIn.getBlockState(underPos).getBlock() == Blocks.DIRT || worldIn
/*  96 */           .getBlockState(underPos).getBlock() == Blocks.GRASS) {
/*  97 */           worldIn.setBlockState(underPos, Blocks.FARMLAND.getDefaultState().withProperty((IProperty)BlockFarmland.MOISTURE, Integer.valueOf(7)));
/*     */         }
/*     */       } 
/*     */     } 
/* 101 */     worldIn.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
/* 102 */     return EnumActionResult.SUCCESS;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\items\tools\UltimateHoe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */