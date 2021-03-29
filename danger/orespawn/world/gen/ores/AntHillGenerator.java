/*    */ package danger.orespawn.world.gen.ores;
/*    */ 
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import java.util.Random;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AntHillGenerator
/*    */   extends WorldGenerator
/*    */ {
/*    */   public boolean generate(World worldIn, Random rand, BlockPos position) {
/* 20 */     position = position.down();
/* 21 */     if (worldIn.getBlockState(position).getBlock() == Blocks.GRASS) {
/* 22 */       worldIn.setBlockState(position, ModBlocks.ANT_BLOCK.getDefaultState(), 2);
/*    */     }
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void decorate(DecorateBiomeEvent.Decorate event) {
/* 29 */     World world = event.getWorld();
/* 30 */     Random rand = event.getRand();
/* 31 */     if (event.getType() == DecorateBiomeEvent.Decorate.EventType.GRASS) {
/* 32 */       if (rand.nextDouble() > 0.04D)
/* 33 */         return;  int x = rand.nextInt(16) + 8;
/* 34 */       int z = rand.nextInt(16) + 8;
/* 35 */       AntHillGenerator gen = new AntHillGenerator();
/* 36 */       gen.generate(world, rand, world.getHeight(event.getPos().add(x, 0, z)));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\world\gen\ores\AntHillGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */