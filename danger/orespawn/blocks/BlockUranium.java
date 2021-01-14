/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.util.EnumParticleTypes;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class BlockUranium
/*    */   extends Block
/*    */ {
/*    */   static final int tickRate = 100;
/*    */   
/*    */   public BlockUranium() {
/* 25 */     super(Material.IRON);
/* 26 */     setUnlocalizedName("uranium_block");
/* 27 */     setRegistryName("uranium_block");
/* 28 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 29 */     setHardness(5.0F);
/* 30 */     setResistance(5.0F);
/* 31 */     setHarvestLevel("pickaxe", 2);
/* 32 */     setLightLevel(0.2F);
/*    */     
/* 34 */     ModBlocks.BLOCKS.add(this);
/* 35 */     ModItems.ITEMS.add((new ItemBlock(this)).setRegistryName(Objects.<ResourceLocation>requireNonNull(getRegistryName())));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
/* 43 */     if (rand.nextInt(20) == 0) {
/* 44 */       sparkle(stateIn, worldIn, pos);
/*    */     }
/*    */   }
/*    */   
/*    */   private void sparkle(IBlockState stateIn, World worldIn, BlockPos pos) {
/* 49 */     int par2 = pos.getX();
/* 50 */     int par3 = pos.getY();
/* 51 */     int par4 = pos.getZ();
/* 52 */     Random var5 = worldIn.rand;
/* 53 */     double var6 = 0.0625D;
/*    */ 
/*    */     
/* 56 */     for (int var8 = 0; var8 < 6; var8++) {
/*    */       
/* 58 */       double var9 = (par2 + var5.nextFloat());
/* 59 */       double var11 = (par3 + var5.nextFloat());
/* 60 */       double var13 = (par4 + var5.nextFloat());
/* 61 */       if (var8 == 0 && !worldIn.getBlockState(new BlockPos(par2, par3 + 1, par4)).isOpaqueCube()) {
/* 62 */         var11 = (par3 + 1) + var6;
/*    */       }
/* 64 */       if (var8 == 1 && !worldIn.getBlockState(new BlockPos(par2, par3 - 1, par4)).isOpaqueCube()) {
/* 65 */         var11 = (par3 + 0) - var6;
/*    */       }
/* 67 */       if (var8 == 2 && !worldIn.getBlockState(new BlockPos(par2, par3, par4 - 1)).isOpaqueCube()) {
/* 68 */         var13 = (par4 + 1) + var6;
/*    */       }
/* 70 */       if (var8 == 3 && !worldIn.getBlockState(new BlockPos(par2, par3, par4 - 1)).isOpaqueCube()) {
/* 71 */         var13 = (par4 + 0) - var6;
/*    */       }
/* 73 */       if (var8 == 4 && !worldIn.getBlockState(new BlockPos(par2 + 1, par3, par4)).isOpaqueCube()) {
/* 74 */         var9 = (par2 + 1) + var6;
/*    */       }
/* 76 */       if (var8 == 5 && !worldIn.getBlockState(new BlockPos(par2 - 1, par3, par4)).isOpaqueCube()) {
/* 77 */         var9 = (par2 + 0) - var6;
/*    */       }
/*    */       
/* 80 */       if (var9 < par2 || var9 > (par2 + 1) || var11 < 0.0D || var11 > (par3 + 1) || var13 < par4 || var13 > (par4 + 1)) {
/* 81 */         int which = var5.nextInt(3);
/* 82 */         if (which == 0) worldIn.spawnParticle(EnumParticleTypes.FLAME, var9, var11, var13, 0.0D, 0.0D, 0.0D, new int[0]); 
/* 83 */         if (which == 1) worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, var9, var11, var13, 0.0D, 0.0D, 0.0D, new int[0]); 
/* 84 */         if (which == 2) worldIn.spawnParticle(EnumParticleTypes.REDSTONE, var9, var11, var13, 0.0D, 0.0D, 0.0D, new int[0]); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespawn\blocks\BlockUranium.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */