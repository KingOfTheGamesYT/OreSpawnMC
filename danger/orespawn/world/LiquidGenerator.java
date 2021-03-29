/*    */ package danger.orespawn.world;
/*    */ 
/*    */ import danger.orespawn.init.ModBiomes;
/*    */ import java.util.Random;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.biome.Biome;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LiquidGenerator
/*    */   extends WorldGenerator
/*    */ {
/*    */   public boolean generate(World worldIn, Random rand, BlockPos position) {
/* 23 */     if (!worldIn.provider.isNether() && worldIn.isAirBlock(position)) {
/* 24 */       if (Math.random() < 0.5D) {
/* 25 */         worldIn.setBlockState(position, Blocks.FLOWING_WATER.getDefaultState());
/*    */       } else {
/* 27 */         worldIn.setBlockState(position, Blocks.FLOWING_LAVA.getDefaultState());
/*    */       } 
/*    */     }
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void decorate(DecorateBiomeEvent.Decorate event) {
/* 35 */     World world = event.getWorld();
/* 36 */     Biome biome = world.getBiomeForCoordsBody(event.getPos());
/* 37 */     Random rand = event.getRand();
/* 38 */     if (biome == ModBiomes.MINING_BIOME && event.getType() == DecorateBiomeEvent.Decorate.EventType.GRASS) {
/* 39 */       if (rand.nextDouble() > 0.1D)
/* 40 */         return;  int x = rand.nextInt(16) + 8;
/* 41 */       int y = rand.nextInt(16) + 8;
/* 42 */       LiquidGenerator gen = new LiquidGenerator();
/* 43 */       gen.generate(world, rand, world.getHeight(event.getPos().add(x, 0, y)));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\world\LiquidGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */