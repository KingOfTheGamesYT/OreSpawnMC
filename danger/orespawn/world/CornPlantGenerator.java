/*    */ package danger.orespawn.world;
/*    */ 
/*    */ import danger.orespawn.blocks.BlockCornPlant;
/*    */ import danger.orespawn.blocks.TileEntityPlant;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.properties.IProperty;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.biome.Biome;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ 
/*    */ public class CornPlantGenerator
/*    */   extends WorldGenerator {
/* 19 */   private BlockCornPlant plant = (BlockCornPlant)ModBlocks.CORN_PLANT;
/* 20 */   private IBlockState state = this.plant.getDefaultState();
/*    */ 
/*    */   
/*    */   public boolean generate(World worldIn, Random rand, BlockPos position) {
/* 24 */     for (int i = 0; i < 32; i++) {
/* 25 */       BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
/* 26 */       if (!worldIn.provider.isNether() && worldIn.isAirBlock(blockpos) && 
/* 27 */         !this.plant.isBlockUnderCorn(worldIn, blockpos) && !this.plant.isBlockUnderAir(worldIn, blockpos) && this.plant.isBlockUnderGrass(worldIn, blockpos)) {
/*    */         
/* 29 */         int height = 0;
/* 30 */         int maxHeight = 21;
/*    */         
/* 32 */         while (height < maxHeight && (worldIn.isAirBlock(blockpos) || worldIn.getBlockState(blockpos).getBlock() == Blocks.TALLGRASS) && blockpos.getY() < 255 && this.plant.canBlockStay(worldIn, blockpos)) {
/* 33 */           worldIn.setBlockState(blockpos, this.state.withProperty((IProperty)BlockCornPlant.STAGE, Integer.valueOf(3)), 2);
/* 34 */           TileEntityPlant tileEntityPlant = (TileEntityPlant)worldIn.getTileEntity(blockpos);
/* 35 */           int heightContribution = tileEntityPlant.getHeightContribution();
/* 36 */           height += heightContribution;
/* 37 */           blockpos = new BlockPos(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
/*    */         } 
/* 39 */         worldIn.setBlockState(blockpos, this.state, 2);
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void decorate(DecorateBiomeEvent.Decorate event) {
/* 49 */     World world = event.getWorld();
/* 50 */     Biome biome = world.getBiomeForCoordsBody(event.getPos());
/* 51 */     Random rand = event.getRand();
/* 52 */     if (event.getType() == DecorateBiomeEvent.Decorate.EventType.GRASS) {
/* 53 */       if (rand.nextDouble() > 0.01D)
/* 54 */         return;  int x = rand.nextInt(16) + 8;
/* 55 */       int y = rand.nextInt(16) + 8;
/* 56 */       CornPlantGenerator gen = new CornPlantGenerator();
/* 57 */       gen.generate(world, rand, world.getHeight(event.getPos().add(x, 0, y)));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\world\CornPlantGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */