/*    */ package danger.orespawn.world.gen;
/*    */ 
/*    */ import danger.orespawn.init.ModDimensions;
/*    */ import danger.orespawn.world.structures.GenericDungeon;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ import net.minecraft.world.gen.IChunkGenerator;
/*    */ import net.minecraftforge.fml.common.IWorldGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StructureGenerator
/*    */   implements IWorldGenerator
/*    */ {
/*    */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
/* 26 */     GenericDungeon dungeon = new GenericDungeon();
/* 27 */     int x = chunkX * 16 + random.nextInt(16);
/* 28 */     int z = chunkZ * 16 + random.nextInt(16);
/* 29 */     int y = 5 + random.nextInt(40);
/*    */ 
/*    */     
/* 32 */     if (world.provider.getDimensionType() == ModDimensions.MINING && 
/* 33 */       random.nextInt(16) == 0) {
/* 34 */       dungeon.makeDungeon(world, x, y, z);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static int calculateGenerationHeight(World world, int x, int z, Block topBlock) {
/* 56 */     int y = world.getHeight();
/* 57 */     boolean foundGround = false;
/* 58 */     while (!foundGround && y-- >= 0) {
/* 59 */       Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
/* 60 */       foundGround = (block == topBlock);
/*    */     } 
/* 62 */     return y;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\world\gen\StructureGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */