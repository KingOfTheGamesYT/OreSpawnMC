/*    */ package danger.orespawn.world;
/*    */ 
/*    */ import danger.orespawn.blocks.BlockButterflyPlant;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.properties.IProperty;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.biome.Biome;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ 
/*    */ public class ButterflyPlantGenerator
/*    */   extends WorldGenerator
/*    */ {
/* 18 */   private BlockButterflyPlant plant = (BlockButterflyPlant)ModBlocks.BUTTERFLY_PLANT;
/* 19 */   private IBlockState state = this.plant.getDefaultState();
/*    */   
/*    */   public boolean generate(World worldIn, Random rand, BlockPos position) {
/* 22 */     for (int i = 0; i < 32; i++) {
/* 23 */       BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
/* 24 */       if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && this.plant.canBlockStay(worldIn, blockpos, this.state) && 
/* 25 */         worldIn.getBlockState(new BlockPos(position.getX(), position.getY() - 1, position.getZ())).getBlock() != ModBlocks.BUTTERFLY_PLANT) {
/* 26 */         worldIn.setBlockState(blockpos, this.state.withProperty((IProperty)BlockButterflyPlant.AGE, Integer.valueOf(7)), 2);
/*    */       }
/*    */     } 
/*    */     
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void decorate(DecorateBiomeEvent.Decorate event) {
/* 35 */     World world = event.getWorld();
/* 36 */     Biome biome = world.getBiomeForCoordsBody(event.getPos());
/* 37 */     Random rand = event.getRand();
/* 38 */     if (event.getType() == DecorateBiomeEvent.Decorate.EventType.GRASS) {
/* 39 */       if (rand.nextDouble() > 0.05D)
/* 40 */         return;  int x = rand.nextInt(16) + 8;
/* 41 */       int y = rand.nextInt(16) + 8;
/* 42 */       ButterflyPlantGenerator gen = new ButterflyPlantGenerator();
/* 43 */       gen.generate(world, rand, world.getHeight(event.getPos().add(x, 0, y)));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespawn\world\ButterflyPlantGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */