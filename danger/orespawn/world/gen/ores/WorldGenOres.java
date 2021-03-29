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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenOres
/*    */   implements IWorldGenerator
/*    */ {
/*    */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
/* 21 */     generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
/*    */   }
/*    */   
/*    */   private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
/* 25 */     generateOre(ModBlocks.URANIUM_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 3, 20, random.nextInt(5) + 5, 3);
/* 26 */     generateOre(ModBlocks.TITANIUM_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 3, 20, random.nextInt(5) + 5, 3);
/*    */     
/* 28 */     generateOre(ModBlocks.ALOSAURUS_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 29 */     generateOre(ModBlocks.BARYONYX_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 30 */     generateOre(ModBlocks.CAMARASAURUS_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 31 */     generateOre(ModBlocks.CRYOLOPHOSAURUS_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 32 */     generateOre(ModBlocks.POINTYSAURUS_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 33 */     generateOre(ModBlocks.TREX_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 34 */     generateOre(ModBlocks.BIRD_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/*    */     
/* 36 */     generateOre(ModBlocks.COW_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 37 */     generateOre(ModBlocks.CREEPER_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 38 */     generateOre(ModBlocks.GHAST_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 39 */     generateOre(ModBlocks.HORSE_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 40 */     generateOre(ModBlocks.PIG_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 41 */     generateOre(ModBlocks.ZOMBIE_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/*    */     
/* 43 */     generateOre(ModBlocks.ALIEN_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 44 */     generateOre(ModBlocks.CAVEFISHER_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 45 */     generateOre(ModBlocks.NASTYSAURUS_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 46 */     generateOre(ModBlocks.VELOCITYRAPTOR_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 47 */     generateOre(ModBlocks.WTF_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 48 */     generateOre(ModBlocks.SPYRO_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 49 */     generateOre(ModBlocks.DRAGONFLY_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/*    */     
/* 51 */     generateOre(ModBlocks.BEAVER_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 52 */     generateOre(ModBlocks.BRUTALFLY_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 53 */     generateOre(ModBlocks.MOTHRA_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 54 */     generateOre(ModBlocks.MANTIS_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 55 */     generateOre(ModBlocks.KYUUBI_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/*    */     
/* 57 */     generateOre(ModBlocks.CASSOWARY_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 58 */     generateOre(ModBlocks.REDCOW_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 59 */     generateOre(ModBlocks.STINKBUG_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 40, 80, random.nextInt(5) + 5, 3);
/* 60 */     generateOre(ModBlocks.AMETHYST_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 3, 15, random.nextInt(4) + 4, 1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void generateOre(IBlockState blockState, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
/* 66 */     int deltaY = maxY - minY;
/*    */     
/* 68 */     for (int i = 0; i < chances; i++) {
/* 69 */       BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
/*    */       
/* 71 */       WorldGenMinable generator = new WorldGenMinable(blockState, size);
/* 72 */       generator.generate(world, random, pos);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\world\gen\ores\WorldGenOres.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */