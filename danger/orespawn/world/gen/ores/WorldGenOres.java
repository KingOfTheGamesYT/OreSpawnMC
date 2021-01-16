/*    */ package danger.orespawn.world.gen.ores;
/*    */ 
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ import net.minecraft.world.gen.IChunkGenerator;
/*    */ import net.minecraft.world.gen.feature.WorldGenMinable;
/*    */ import net.minecraftforge.fml.common.IWorldGenerator;
/*    */ 
/*    */ 
/*    */ public class WorldGenOres
/*    */   implements IWorldGenerator
/*    */ {
/*    */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
/* 18 */     generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
/*    */   }
/*    */   
/*    */   private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
/* 22 */     generateOre(ModBlocks.URANIUM_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 3, 20, random.nextInt(5) + 9, 4);
/* 23 */     generateOre(ModBlocks.TITANIUM_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 3, 20, random.nextInt(5) + 9, 4);
/*    */   }
/*    */ 
/*    */   
/*    */   private void generateOre(IBlockState blockState, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
/* 28 */     int deltaY = maxY - minY;
/*    */     
/* 30 */     for (int i = 0; i < chances; i++) {
/* 31 */       BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
/*    */       
/* 33 */       WorldGenMinable generator = new WorldGenMinable(blockState, size);
/* 34 */       generator.generate(world, random, pos);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\world\gen\ores\WorldGenOres.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */