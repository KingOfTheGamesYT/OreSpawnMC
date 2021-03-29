/*    */ package danger.orespawn.world;
/*    */ 
/*    */ import danger.orespawn.blocks.BlockButterflyPlant;
/*    */ import danger.orespawn.blocks.BlockFireflyPlant;
/*    */ import danger.orespawn.blocks.BlockMosquitoPlant;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.properties.IProperty;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlantGenerator
/*    */   extends WorldGenerator
/*    */ {
/* 22 */   private BlockButterflyPlant butterflyPlant = (BlockButterflyPlant)ModBlocks.BUTTERFLY_PLANT;
/* 23 */   private BlockMosquitoPlant mosquitoPlant = (BlockMosquitoPlant)ModBlocks.MOSQUITO_PLANT;
/* 24 */   private BlockFireflyPlant fireflyPlant = (BlockFireflyPlant)ModBlocks.FIREFLY_PLANT;
/*    */ 
/*    */   
/*    */   public boolean generate(World worldIn, Random rand, BlockPos position) {
/*    */     BlockButterflyPlant blockButterflyPlant;
/*    */     BlockMosquitoPlant blockMosquitoPlant;
/*    */     BlockFireflyPlant blockFireflyPlant;
/* 31 */     switch (rand.nextInt(3)) {
/*    */       case 0:
/* 33 */         blockButterflyPlant = this.butterflyPlant;
/*    */         break;
/*    */       case 1:
/* 36 */         blockMosquitoPlant = this.mosquitoPlant;
/*    */         break;
/*    */       default:
/* 39 */         blockFireflyPlant = this.fireflyPlant;
/*    */         break;
/*    */     } 
/* 42 */     IBlockState state = blockFireflyPlant.getDefaultState();
/* 43 */     for (int i = 0; i < 12; i++) {
/* 44 */       BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
/* 45 */       if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && blockFireflyPlant.canBlockStay(worldIn, blockpos, state) && 
/* 46 */         worldIn.getBlockState(new BlockPos(position.getX(), position.getY() - 1, position.getZ())).getBlock() != blockFireflyPlant) {
/* 47 */         worldIn.setBlockState(blockpos, state.withProperty((IProperty)BlockButterflyPlant.AGE, Integer.valueOf(7)), 2);
/*    */       }
/*    */     } 
/*    */     
/* 51 */     return true;
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void decorate(DecorateBiomeEvent.Decorate event) {
/* 56 */     World world = event.getWorld();
/* 57 */     Random rand = event.getRand();
/* 58 */     if (event.getType() == DecorateBiomeEvent.Decorate.EventType.GRASS) {
/* 59 */       if (rand.nextDouble() > 0.01D)
/* 60 */         return;  int x = rand.nextInt(16) + 8;
/* 61 */       int y = rand.nextInt(16) + 8;
/* 62 */       PlantGenerator gen = new PlantGenerator();
/* 63 */       gen.generate(world, rand, world.getHeight(event.getPos().add(x, 0, y)));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\world\PlantGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */