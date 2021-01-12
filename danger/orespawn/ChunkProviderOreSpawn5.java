/*      */ package danger.orespawn;
/*      */ 
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.BlockFalling;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.entity.EnumCreatureType;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.util.IProgressUpdate;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.world.ChunkPosition;
/*      */ import net.minecraft.world.SpawnerAnimals;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.WorldType;
/*      */ import net.minecraft.world.biome.BiomeGenBase;
/*      */ import net.minecraft.world.chunk.Chunk;
/*      */ import net.minecraft.world.chunk.IChunkProvider;
/*      */ import net.minecraft.world.gen.NoiseGenerator;
/*      */ import net.minecraft.world.gen.NoiseGeneratorOctaves;
/*      */ import net.minecraft.world.gen.NoiseGeneratorPerlin;
/*      */ import net.minecraftforge.event.terraingen.TerrainGen;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ChunkProviderOreSpawn5
/*      */   implements IChunkProvider
/*      */ {
/*      */   private Random rand;
/*      */   private NoiseGeneratorOctaves field_147431_j;
/*      */   private NoiseGeneratorOctaves field_147432_k;
/*      */   private NoiseGeneratorOctaves field_147429_l;
/*      */   private NoiseGeneratorPerlin field_147430_m;
/*      */   public NoiseGeneratorOctaves noiseGen5;
/*      */   public NoiseGeneratorOctaves noiseGen6;
/*      */   public NoiseGeneratorOctaves mobSpawnerNoise;
/*      */   private World worldObj;
/*      */   private final boolean mapFeaturesEnabled;
/*      */   private WorldType field_147435_p;
/*      */   private final double[] field_147434_q;
/*      */   private final float[] parabolicField;
/*   65 */   private double[] stoneNoise = new double[256];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BiomeGenBase[] biomesForGeneration;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   double[] field_147427_d;
/*      */ 
/*      */ 
/*      */   
/*      */   double[] field_147428_e;
/*      */ 
/*      */ 
/*      */   
/*      */   double[] field_147425_f;
/*      */ 
/*      */ 
/*      */   
/*      */   double[] field_147426_g;
/*      */ 
/*      */ 
/*      */   
/*   91 */   int[][] field_73219_j = new int[32][32];
/*      */ 
/*      */ 
/*      */   
/*      */   public ChunkProviderOreSpawn5(World par1World, long par2, boolean par4) {
/*   96 */     this.worldObj = par1World;
/*   97 */     this.mapFeaturesEnabled = par4;
/*   98 */     this.field_147435_p = par1World.getWorldInfo().getTerrainType();
/*   99 */     this.rand = new Random(par2);
/*  100 */     this.field_147431_j = new NoiseGeneratorOctaves(this.rand, 16);
/*  101 */     this.field_147432_k = new NoiseGeneratorOctaves(this.rand, 16);
/*  102 */     this.field_147429_l = new NoiseGeneratorOctaves(this.rand, 8);
/*  103 */     this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
/*  104 */     this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
/*  105 */     this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
/*  106 */     this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
/*  107 */     this.field_147434_q = new double[825];
/*  108 */     this.parabolicField = new float[25];
/*      */     
/*  110 */     for (int j = -2; j <= 2; j++) {
/*      */       
/*  112 */       for (int k = -2; k <= 2; k++) {
/*      */         
/*  114 */         float f = 10.0F / MathHelper.sqrt_float((j * j + k * k) + 0.2F);
/*  115 */         this.parabolicField[j + 2 + (k + 2) * 5] = f;
/*      */       } 
/*      */     } 
/*      */     
/*  119 */     NoiseGenerator[] noiseGens = { (NoiseGenerator)this.field_147431_j, (NoiseGenerator)this.field_147432_k, (NoiseGenerator)this.field_147429_l, (NoiseGenerator)this.field_147430_m, (NoiseGenerator)this.noiseGen5, (NoiseGenerator)this.noiseGen6, (NoiseGenerator)this.mobSpawnerNoise };
/*  120 */     noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.rand, noiseGens);
/*  121 */     this.field_147431_j = (NoiseGeneratorOctaves)noiseGens[0];
/*  122 */     this.field_147432_k = (NoiseGeneratorOctaves)noiseGens[1];
/*  123 */     this.field_147429_l = (NoiseGeneratorOctaves)noiseGens[2];
/*  124 */     this.field_147430_m = (NoiseGeneratorPerlin)noiseGens[3];
/*  125 */     this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
/*  126 */     this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
/*  127 */     this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147424_a(int p_147424_1_, int p_147424_2_, Block[] p_147424_3_) {
/*  132 */     byte b0 = 63;
/*  133 */     this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, p_147424_1_ * 4 - 2, p_147424_2_ * 4 - 2, 10, 10);
/*  134 */     func_147423_a(p_147424_1_ * 4, 0, p_147424_2_ * 4);
/*      */     
/*  136 */     for (int k = 0; k < 4; k++) {
/*      */       
/*  138 */       int l = k * 5;
/*  139 */       int i1 = (k + 1) * 5;
/*      */       
/*  141 */       for (int j1 = 0; j1 < 4; j1++) {
/*      */         
/*  143 */         int k1 = (l + j1) * 33;
/*  144 */         int l1 = (l + j1 + 1) * 33;
/*  145 */         int i2 = (i1 + j1) * 33;
/*  146 */         int j2 = (i1 + j1 + 1) * 33;
/*      */         
/*  148 */         for (int k2 = 0; k2 < 32; k2++) {
/*      */           
/*  150 */           double d0 = 0.125D;
/*  151 */           double d1 = this.field_147434_q[k1 + k2];
/*  152 */           double d2 = this.field_147434_q[l1 + k2];
/*  153 */           double d3 = this.field_147434_q[i2 + k2];
/*  154 */           double d4 = this.field_147434_q[j2 + k2];
/*  155 */           double d5 = (this.field_147434_q[k1 + k2 + 1] - d1) * d0;
/*  156 */           double d6 = (this.field_147434_q[l1 + k2 + 1] - d2) * d0;
/*  157 */           double d7 = (this.field_147434_q[i2 + k2 + 1] - d3) * d0;
/*  158 */           double d8 = (this.field_147434_q[j2 + k2 + 1] - d4) * d0;
/*      */           
/*  160 */           for (int l2 = 0; l2 < 8; l2++) {
/*      */             
/*  162 */             double d9 = 0.25D;
/*  163 */             double d10 = d1;
/*  164 */             double d11 = d2;
/*  165 */             double d12 = (d3 - d1) * d9;
/*  166 */             double d13 = (d4 - d2) * d9;
/*      */             
/*  168 */             for (int i3 = 0; i3 < 4; i3++) {
/*      */               
/*  170 */               int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
/*  171 */               short short1 = 256;
/*  172 */               j3 -= short1;
/*  173 */               double d14 = 0.25D;
/*  174 */               double d16 = (d11 - d10) * d14;
/*  175 */               double d15 = d10 - d16;
/*      */               
/*  177 */               for (int k3 = 0; k3 < 4; k3++) {
/*      */                 
/*  179 */                 if ((d15 += d16) > 0.0D) {
/*      */                   
/*  181 */                   p_147424_3_[j3 += short1] = OreSpawnMain.CrystalStone;
/*      */                 }
/*  183 */                 else if (k2 * 8 + l2 < b0) {
/*      */                   
/*  185 */                   p_147424_3_[j3 += short1] = Blocks.water;
/*      */                 }
/*      */                 else {
/*      */                   
/*  189 */                   p_147424_3_[j3 += short1] = null;
/*      */                 } 
/*      */               } 
/*      */               
/*  193 */               d10 += d12;
/*  194 */               d11 += d13;
/*      */             } 
/*      */             
/*  197 */             d1 += d5;
/*  198 */             d2 += d6;
/*  199 */             d3 += d7;
/*  200 */             d4 += d8;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void replaceBlocksForBiome(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_, byte[] p_147422_4_, BiomeGenBase[] p_147422_5_) {
/*  213 */     double d0 = 0.03125D;
/*  214 */     this.stoneNoise = this.field_147430_m.getRegion(this.stoneNoise, (p_147422_1_ * 16), (p_147422_2_ * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
/*      */     
/*  216 */     for (int k = 0; k < 16; k++) {
/*      */       
/*  218 */       for (int l = 0; l < 16; l++)
/*      */       {
/*  220 */         MygenTerrainBlocks(this.worldObj, this.rand, p_147422_3_, p_147422_4_, p_147422_1_ * 16 + k, p_147422_2_ * 16 + l, this.stoneNoise[l + k * 16]);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void MygenTerrainBlocks(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
/*  227 */     MygenBiomeTerrain(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
/*      */   }
/*      */ 
/*      */   
/*      */   private final void MygenBiomeTerrain(World p_150560_1_, Random p_150560_2_, Block[] p_150560_3_, byte[] p_150560_4_, int p_150560_5_, int p_150560_6_, double p_150560_7_) {
/*  232 */     boolean flag = true;
/*  233 */     Block block = OreSpawnMain.CrystalGrass;
/*  234 */     byte b0 = 0;
/*  235 */     Block block1 = OreSpawnMain.CrystalStone;
/*  236 */     int k = -1;
/*  237 */     int l = (int)(p_150560_7_ / 3.0D + 3.0D + p_150560_2_.nextDouble() * 0.25D);
/*  238 */     int i1 = p_150560_5_ & 0xF;
/*  239 */     int j1 = p_150560_6_ & 0xF;
/*  240 */     int k1 = p_150560_3_.length / 256;
/*      */     
/*  242 */     for (int l1 = 255; l1 >= 0; l1--) {
/*      */       
/*  244 */       int i2 = (j1 * 16 + i1) * k1 + l1;
/*      */       
/*  246 */       if (l1 <= 0 + p_150560_2_.nextInt(5)) {
/*      */         
/*  248 */         p_150560_3_[i2] = Blocks.bedrock;
/*      */       }
/*      */       else {
/*      */         
/*  252 */         Block block2 = p_150560_3_[i2];
/*      */         
/*  254 */         if (block2 != null && block2.getMaterial() != Material.air) {
/*      */           
/*  256 */           if (block2 == OreSpawnMain.CrystalStone)
/*      */           {
/*  258 */             if (k == -1) {
/*      */               
/*  260 */               if (l <= 0) {
/*      */                 
/*  262 */                 block = null;
/*  263 */                 b0 = 0;
/*  264 */                 block1 = OreSpawnMain.CrystalStone;
/*      */               }
/*  266 */               else if (l1 >= 59 && l1 <= 64) {
/*      */                 
/*  268 */                 block = OreSpawnMain.CrystalGrass;
/*  269 */                 b0 = 0;
/*  270 */                 block1 = OreSpawnMain.CrystalStone;
/*      */               } 
/*      */               
/*  273 */               if (l1 < 63 && (block == null || block.getMaterial() == Material.air)) {
/*      */ 
/*      */                 
/*  276 */                 block = Blocks.water;
/*  277 */                 b0 = 0;
/*      */               } 
/*      */ 
/*      */               
/*  281 */               k = l;
/*      */               
/*  283 */               if (l1 >= 62)
/*      */               {
/*  285 */                 p_150560_3_[i2] = block;
/*  286 */                 p_150560_4_[i2] = b0;
/*      */               
/*      */               }
/*      */               else
/*      */               {
/*  291 */                 p_150560_3_[i2] = block1;
/*      */               }
/*      */             
/*  294 */             } else if (k > 0) {
/*      */               
/*  296 */               k--;
/*  297 */               p_150560_3_[i2] = block1;
/*      */             }
/*      */           
/*      */           }
/*      */         }
/*      */         else {
/*      */           
/*  304 */           k = -1;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Chunk loadChunk(int par1, int par2) {
/*  315 */     return provideChunk(par1, par2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Chunk provideChunk(int par1, int par2) {
/*  324 */     this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
/*  325 */     Block[] ablock = new Block[65536];
/*  326 */     byte[] abyte = new byte[65536];
/*  327 */     func_147424_a(par1, par2, ablock);
/*  328 */     this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
/*  329 */     replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
/*      */     
/*  331 */     Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
/*  332 */     CrystalMaze cm = new CrystalMaze();
/*  333 */     cm.buildCrystalMaze(this.worldObj, par1 * 16, 25, par2 * 16, chunk);
/*      */     
/*  335 */     generateCrystals(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
/*  336 */     addCrystalTrees(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
/*  337 */     generateCrystalOres(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
/*  338 */     addCrystalFlowers(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
/*  339 */     addRice(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
/*  340 */     addQuinoa(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
/*      */     
/*  342 */     chunk.generateSkylightMap();
/*  343 */     return chunk;
/*      */   }
/*      */ 
/*      */   
/*      */   private void func_147423_a(int p_147423_1_, int p_147423_2_, int p_147423_3_) {
/*  348 */     double d0 = 684.412D;
/*  349 */     double d1 = 684.412D;
/*  350 */     double d2 = 512.0D;
/*  351 */     double d3 = 512.0D;
/*  352 */     this.field_147426_g = this.noiseGen6.generateNoiseOctaves(this.field_147426_g, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D);
/*  353 */     this.field_147427_d = this.field_147429_l.generateNoiseOctaves(this.field_147427_d, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
/*  354 */     this.field_147428_e = this.field_147431_j.generateNoiseOctaves(this.field_147428_e, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/*  355 */     this.field_147425_f = this.field_147432_k.generateNoiseOctaves(this.field_147425_f, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/*  356 */     boolean flag1 = false;
/*  357 */     boolean flag = false;
/*  358 */     int l = 0;
/*  359 */     int i1 = 0;
/*  360 */     double d4 = 8.5D;
/*      */     
/*  362 */     for (int j1 = 0; j1 < 5; j1++) {
/*      */       
/*  364 */       for (int k1 = 0; k1 < 5; k1++) {
/*      */         
/*  366 */         float f = 0.0F;
/*  367 */         float f1 = 0.0F;
/*  368 */         float f2 = 0.0F;
/*  369 */         byte b0 = 2;
/*  370 */         BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
/*      */         
/*  372 */         for (int l1 = -b0; l1 <= b0; l1++) {
/*      */           
/*  374 */           for (int i2 = -b0; i2 <= b0; i2++) {
/*      */             
/*  376 */             BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
/*  377 */             float f3 = biomegenbase1.rootHeight;
/*  378 */             float f4 = biomegenbase1.heightVariation;
/*      */             
/*  380 */             if (this.field_147435_p == WorldType.AMPLIFIED && f3 > 0.0F) {
/*      */               
/*  382 */               f3 = 1.0F + f3 * 2.0F;
/*  383 */               f4 = 1.0F + f4 * 4.0F;
/*      */             } 
/*      */             
/*  386 */             float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);
/*      */             
/*  388 */             if (biomegenbase1.rootHeight > biomegenbase.rootHeight)
/*      */             {
/*  390 */               f5 /= 2.0F;
/*      */             }
/*      */             
/*  393 */             f += f4 * f5;
/*  394 */             f1 += f3 * f5;
/*  395 */             f2 += f5;
/*      */           } 
/*      */         } 
/*      */         
/*  399 */         f /= f2;
/*  400 */         f1 /= f2;
/*  401 */         f = f * 0.9F + 0.1F;
/*  402 */         f1 = (f1 * 4.0F - 1.0F) / 8.0F;
/*  403 */         double d13 = this.field_147426_g[i1] / 8000.0D;
/*      */         
/*  405 */         if (d13 < 0.0D)
/*      */         {
/*  407 */           d13 = -d13 * 0.3D;
/*      */         }
/*      */         
/*  410 */         d13 = d13 * 3.0D - 2.0D;
/*      */         
/*  412 */         if (d13 < 0.0D) {
/*      */           
/*  414 */           d13 /= 2.0D;
/*      */           
/*  416 */           if (d13 < -1.0D)
/*      */           {
/*  418 */             d13 = -1.0D;
/*      */           }
/*      */           
/*  421 */           d13 /= 1.4D;
/*  422 */           d13 /= 2.0D;
/*      */         }
/*      */         else {
/*      */           
/*  426 */           if (d13 > 1.0D)
/*      */           {
/*  428 */             d13 = 1.0D;
/*      */           }
/*      */           
/*  431 */           d13 /= 8.0D;
/*      */         } 
/*      */         
/*  434 */         i1++;
/*  435 */         double d12 = f1;
/*  436 */         double d14 = f;
/*  437 */         d12 += d13 * 0.2D;
/*  438 */         d12 = d12 * 8.5D / 8.0D;
/*  439 */         double d5 = 8.5D + d12 * 4.0D;
/*      */         
/*  441 */         for (int j2 = 0; j2 < 33; j2++) {
/*      */           
/*  443 */           double d6 = (j2 - d5) * 12.0D * 128.0D / 256.0D / d14;
/*      */           
/*  445 */           if (d6 < 0.0D)
/*      */           {
/*  447 */             d6 *= 4.0D;
/*      */           }
/*      */           
/*  450 */           double d7 = this.field_147428_e[l] / 512.0D;
/*  451 */           double d8 = this.field_147425_f[l] / 512.0D;
/*  452 */           double d9 = (this.field_147427_d[l] / 10.0D + 1.0D) / 2.0D;
/*  453 */           double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;
/*      */           
/*  455 */           if (j2 > 29) {
/*      */             
/*  457 */             double d11 = ((j2 - 29) / 3.0F);
/*  458 */             d10 = d10 * (1.0D - d11) + -10.0D * d11;
/*      */           } 
/*      */           
/*  461 */           this.field_147434_q[l] = d10;
/*  462 */           l++;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean chunkExists(int par1, int par2) {
/*  473 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
/*  481 */     BlockFalling.fallInstantly = true;
/*  482 */     int k = par2 * 16;
/*  483 */     int l = par3 * 16;
/*  484 */     BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
/*  485 */     this.rand.setSeed(this.worldObj.getSeed());
/*  486 */     long i1 = this.rand.nextLong() / 2L * 2L + 1L;
/*  487 */     long j1 = this.rand.nextLong() / 2L * 2L + 1L;
/*  488 */     this.rand.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.getSeed());
/*  489 */     boolean flag = false;
/*      */ 
/*      */ 
/*      */     
/*  493 */     biomegenbase.decorate(this.worldObj, this.rand, k, l);
/*  494 */     SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
/*      */ 
/*      */ 
/*      */     
/*  498 */     BlockFalling.fallInstantly = false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate) {
/*  507 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void saveExtraData() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean unloadQueuedChunks() {
/*  521 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canSave() {
/*  529 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String makeString() {
/*  537 */     return "CrystalDimension";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
/*  545 */     BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(par2, par4);
/*  546 */     return biomegenbase.getSpawnableList(par1EnumCreatureType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getLoadedChunkCount() {
/*  553 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void recreateStructures(int par1, int par2) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void generateCrystals(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
/*  564 */     addPinkTourmaline(world, random, chunkX, chunkZ, chunk);
/*  565 */     addTigersEye(world, random, chunkX, chunkZ, chunk);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addPinkTourmaline(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
/*  577 */     if (random.nextInt(30) != 1)
/*      */       return; 
/*  579 */     int randPosX = 3 + chunkX + random.nextInt(10);
/*  580 */     int randPosY = 30 + random.nextInt(5);
/*  581 */     int randPosZ = 3 + chunkZ + random.nextInt(10);
/*      */     
/*  583 */     int patchy = 1 + random.nextInt(10);
/*      */     
/*  585 */     for (int i = 0; i < patchy; i++) {
/*  586 */       float dx = random.nextFloat() - random.nextFloat();
/*  587 */       float dz = random.nextFloat() - random.nextFloat();
/*  588 */       float dy = 0.5F + random.nextFloat() / 2.0F;
/*  589 */       int width = random.nextInt(2);
/*  590 */       int length = 1 + width * 3 + random.nextInt(15);
/*  591 */       float rx = randPosX;
/*  592 */       float ry = randPosY;
/*  593 */       float rz = randPosZ;
/*  594 */       for (int iy = 0; iy <= length; iy++) {
/*  595 */         for (int ix = 0; ix <= width; ix++) {
/*  596 */           for (int iz = 0; iz <= width; iz++) {
/*  597 */             OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, (int)(rx + ix), (int)ry, (int)(rz + iz), OreSpawnMain.CrystalCrystal, 0);
/*      */           }
/*      */         } 
/*  600 */         ry += dy;
/*  601 */         rx += dx;
/*  602 */         rz += dz;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addTigersEye(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
/*  616 */     if (random.nextInt(30) != 1)
/*      */       return; 
/*  618 */     int randPosX = 3 + chunkX + random.nextInt(10);
/*  619 */     int randPosY = 5 + random.nextInt(5);
/*  620 */     int randPosZ = 3 + chunkZ + random.nextInt(10);
/*      */     
/*  622 */     int patchy = 1 + random.nextInt(5);
/*      */     
/*  624 */     for (int i = 0; i < patchy; i++) {
/*  625 */       float dx = random.nextFloat() - random.nextFloat();
/*  626 */       float dz = random.nextFloat() - random.nextFloat();
/*  627 */       float dy = 0.5F + random.nextFloat() / 2.0F;
/*  628 */       int width = 0;
/*  629 */       int length = width * 3 + random.nextInt(6);
/*  630 */       float rx = randPosX;
/*  631 */       float ry = randPosY;
/*  632 */       float rz = randPosZ;
/*  633 */       for (int iy = 0; iy <= length; iy++) {
/*  634 */         for (int ix = 0; ix <= width; ix++) {
/*  635 */           for (int iz = 0; iz <= width; iz++) {
/*  636 */             OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, (int)(rx + ix), (int)ry, (int)(rz + iz), OreSpawnMain.TigersEye, 0);
/*      */           }
/*      */         } 
/*  639 */         ry += dy;
/*  640 */         rx += dx;
/*  641 */         rz += dz;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addCrystalTrees(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
/*  650 */     if (random.nextInt(5) != 0)
/*      */       return; 
/*  652 */     int howmany = 0;
/*  653 */     int what = random.nextInt(5);
/*  654 */     howmany = random.nextInt(8);
/*      */     
/*  656 */     if (what != 0) howmany *= 2;
/*      */ 
/*      */     
/*  659 */     for (int i = 0; i < howmany; i++) {
/*  660 */       int posX = 4 + chunkX + random.nextInt(8);
/*  661 */       int posZ = 4 + chunkZ + random.nextInt(8);
/*  662 */       for (int posY = 128; posY > 40; posY--) {
/*      */ 
/*      */         
/*  665 */         if (OreSpawnMain.getBlockIDInChunk(chunk, posX, posY, posZ) == Blocks.air && OreSpawnMain.getBlockIDInChunk(chunk, posX, posY - 1, posZ) == OreSpawnMain.CrystalGrass) {
/*      */           
/*  667 */           if (what == 0) {
/*  668 */             TallCrystalTree(world, posX, posY, posZ, chunk); break;
/*      */           } 
/*  670 */           ScragglyCrystalTreeWithBranches(world, posX, posY, posZ, chunk);
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeScragglyCrystalBranch(World world, int x, int y, int z, int len, int biasx, int biasz, Chunk chunk) {
/*  685 */     for (int k = 0; k < len; k++) {
/*  686 */       int ix = world.rand.nextInt(2) - world.rand.nextInt(2) + biasx;
/*  687 */       int iz = world.rand.nextInt(2) - world.rand.nextInt(2) + biasz;
/*  688 */       if (ix > 1) ix = 1; 
/*  689 */       if (ix < -1) ix = -1; 
/*  690 */       if (iz > 1) iz = 1; 
/*  691 */       if (iz < -1) iz = -1; 
/*  692 */       int iy = (world.rand.nextInt(3) > 0) ? 1 : 0;
/*  693 */       x += ix;
/*  694 */       z += iz;
/*  695 */       y += iy;
/*  696 */       Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y, z);
/*  697 */       if (bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves2) {
/*      */         return;
/*      */       }
/*  700 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y, z, OreSpawnMain.MyCrystalTreeLog, 0);
/*      */       
/*  702 */       for (int m = -1; m < 2; m++) {
/*  703 */         for (int n = -1; n < 2; n++) {
/*  704 */           if (world.rand.nextInt(2) == 1) {
/*  705 */             bid = OreSpawnMain.getBlockIDInChunk(chunk, x + m, y, z + n);
/*  706 */             if (bid == Blocks.air) {
/*  707 */               OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, OreSpawnMain.MyCrystalLeaves2, 0);
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*  712 */       if (world.rand.nextInt(2) == 1) {
/*  713 */         bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y + 1, z);
/*  714 */         if (bid == Blocks.air) {
/*  715 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y + 1, z, OreSpawnMain.MyCrystalLeaves2, 0);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ScragglyCrystalTreeWithBranches(World world, int x, int y, int z, Chunk chunk) {
/*  731 */     int i = 1 + world.rand.nextInt(2);
/*  732 */     int j = i + world.rand.nextInt(8);
/*      */     int k;
/*  734 */     for (k = 0; k < i; k++) {
/*  735 */       Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y + k, z);
/*  736 */       if (k >= 1 && bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves2) {
/*      */         return;
/*      */       }
/*  739 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y + k, z, OreSpawnMain.MyCrystalTreeLog, 0);
/*      */     } 
/*  741 */     y += i - 1;
/*      */     
/*  743 */     for (k = i; k < j; k++) {
/*  744 */       int ix = world.rand.nextInt(2) - world.rand.nextInt(2);
/*  745 */       int iz = world.rand.nextInt(2) - world.rand.nextInt(2);
/*  746 */       int iy = (world.rand.nextInt(4) > 0) ? 1 : 0;
/*  747 */       x += ix;
/*  748 */       z += iz;
/*  749 */       y += iy;
/*  750 */       Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y, z);
/*  751 */       if (bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves2) {
/*      */         break;
/*      */       }
/*  754 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y, z, OreSpawnMain.MyCrystalTreeLog, 0);
/*  755 */       if (world.rand.nextInt(4) == 1) {
/*  756 */         makeScragglyCrystalBranch(world, x, y, z, world.rand.nextInt(1 + j - k), world.rand.nextInt(2) - world.rand.nextInt(2), world.rand.nextInt(2) - world.rand.nextInt(2), chunk);
/*      */       }
/*      */       
/*  759 */       for (int m = -1; m < 2; m++) {
/*  760 */         for (int n = -1; n < 2; n++) {
/*  761 */           if (world.rand.nextInt(2) == 1) {
/*  762 */             bid = OreSpawnMain.getBlockIDInChunk(chunk, x + m, y, z + n);
/*  763 */             if (bid == Blocks.air) {
/*  764 */               OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, OreSpawnMain.MyCrystalLeaves2, 0);
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*  769 */       if (world.rand.nextInt(2) == 1) {
/*  770 */         bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y + 1, z);
/*  771 */         if (bid == Blocks.air) {
/*  772 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y + 1, z, OreSpawnMain.MyCrystalLeaves2, 0);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void TallCrystalTree(World world, int x, int y, int z, Chunk chunk) {
/*  788 */     int i = 10 + world.rand.nextInt(12);
/*  789 */     if (OreSpawnMain.LessLag == 1) {
/*  790 */       i -= 2;
/*      */     }
/*  792 */     if (OreSpawnMain.LessLag == 2) {
/*  793 */       i -= 4;
/*      */     }
/*  795 */     int j = i + world.rand.nextInt(18 - OreSpawnMain.LessLag * 2);
/*      */     int k;
/*  797 */     for (k = 0; k < i; k++) {
/*  798 */       Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y + k, z);
/*  799 */       if (k >= 1 && bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves) {
/*      */         return;
/*      */       }
/*  802 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y + k, z, OreSpawnMain.MyCrystalTreeLog, 0);
/*      */     } 
/*  804 */     y += i - 1;
/*      */     
/*  806 */     for (k = i; k < j; k++) {
/*  807 */       y++;
/*  808 */       Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y, z);
/*  809 */       if (bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves) {
/*      */         break;
/*      */       }
/*  812 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y, z, OreSpawnMain.MyCrystalTreeLog, 0);
/*      */       
/*  814 */       if (k % 4 == 0) {
/*  815 */         for (int n = -1; n < 2; n++) {
/*  816 */           for (int i1 = -1; i1 < 2; i1++) {
/*  817 */             if (world.rand.nextInt(2) == 1) {
/*  818 */               bid = OreSpawnMain.getBlockIDInChunk(chunk, x + n, y, z + i1);
/*  819 */               if (bid == Blocks.air) {
/*  820 */                 OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x + n, y, z + i1, OreSpawnMain.MyCrystalLeaves, 0);
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  828 */     y++; int m;
/*  829 */     for (m = -1; m < 2; m++) {
/*  830 */       for (int n = -1; n < 2; n++) {
/*  831 */         if (world.rand.nextInt(2) == 1) {
/*  832 */           Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x + m, y, z + n);
/*  833 */           if (bid == Blocks.air) {
/*  834 */             OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, OreSpawnMain.MyCrystalTreeLog, 0);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*  839 */     for (m = -3; m < 4; m++) {
/*  840 */       for (int n = -3; n < 4; n++) {
/*  841 */         Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x + m, y, z + n);
/*  842 */         if (bid == Blocks.air) {
/*  843 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, OreSpawnMain.MyCrystalLeaves, 0);
/*      */         }
/*      */       } 
/*      */     } 
/*  847 */     y++;
/*  848 */     for (m = -1; m < 2; m++) {
/*  849 */       for (int n = -1; n < 2; n++) {
/*  850 */         Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x + m, y, z + n);
/*  851 */         if (bid == Blocks.air) {
/*  852 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, OreSpawnMain.MyCrystalLeaves, 0);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void generateCrystalOres(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
/*  863 */     int patchy = 25 + random.nextInt(30);
/*  864 */     if (random.nextInt(20) == 0) {
/*  865 */       patchy += 30;
/*      */     }
/*      */     int i;
/*  868 */     for (i = 0; i < patchy; i++) {
/*  869 */       int randPosX = 2 + chunkX + random.nextInt(12);
/*  870 */       int randPosY = random.nextInt(128);
/*  871 */       int randPosZ = 2 + chunkZ + random.nextInt(12);
/*  872 */       if (randPosY > 45) {
/*      */ 
/*      */ 
/*      */         
/*  876 */         int j = random.nextInt(11);
/*  877 */         Block b = Blocks.air;
/*  878 */         switch (j) { case 0:
/*  879 */             b = OreSpawnMain.MyUrchinSpawnBlock; break;
/*  880 */           case 1: b = OreSpawnMain.MyFlounderSpawnBlock; break;
/*  881 */           case 2: b = OreSpawnMain.MySkateSpawnBlock; break;
/*  882 */           case 3: b = OreSpawnMain.MyRotatorSpawnBlock; break;
/*  883 */           case 4: b = OreSpawnMain.MyPeacockSpawnBlock; break;
/*  884 */           case 5: b = OreSpawnMain.MyFairySpawnBlock; break;
/*  885 */           case 6: b = OreSpawnMain.MyDungeonBeastSpawnBlock; break;
/*  886 */           case 7: b = OreSpawnMain.MyVortexSpawnBlock; break;
/*  887 */           case 8: b = OreSpawnMain.MyRatSpawnBlock; break;
/*  888 */           case 9: b = OreSpawnMain.MyWhaleSpawnBlock; break;
/*  889 */           case 10: b = OreSpawnMain.MyIrukandjiSpawnBlock;
/*      */             break; }
/*      */ 
/*      */         
/*  893 */         generateOre(world, random, randPosX, randPosY, randPosZ, chunk, b, 4, OreSpawnMain.CrystalStone);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  898 */     patchy = 3 + random.nextInt(8);
/*  899 */     for (i = 0; i < patchy; i++) {
/*  900 */       int randPosX = 2 + chunkX + random.nextInt(12);
/*  901 */       int randPosY = random.nextInt(128);
/*  902 */       int randPosZ = 2 + chunkZ + random.nextInt(12);
/*  903 */       generateOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.CrystalCoal, 6, OreSpawnMain.CrystalStone);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  908 */     patchy = 15 + random.nextInt(20);
/*  909 */     for (i = 0; i < patchy; i++) {
/*  910 */       int randPosX = 2 + chunkX + random.nextInt(12);
/*  911 */       int randPosY = random.nextInt(128);
/*  912 */       int randPosZ = 2 + chunkZ + random.nextInt(12);
/*  913 */       if (randPosY < 25) {
/*  914 */         generateOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.CrystalRat, 6, OreSpawnMain.CrystalStone);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  920 */     patchy = 12 + random.nextInt(20);
/*  921 */     for (i = 0; i < patchy; i++) {
/*  922 */       int randPosX = 2 + chunkX + random.nextInt(12);
/*  923 */       int randPosY = random.nextInt(128);
/*  924 */       int randPosZ = 2 + chunkZ + random.nextInt(12);
/*  925 */       if (randPosY < 25) {
/*  926 */         generateOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.CrystalFairy, 6, OreSpawnMain.CrystalStone);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean generateOre(World par1World, Random par2Random, int par3, int par4, int par5, Chunk chunk, Block newbid, int numberOfBlocks, Block oldbid) {
/*  936 */     float f = par2Random.nextFloat() * 3.1415927F;
/*  937 */     double d0 = ((par3 + 8) + MathHelper.sin(f) * numberOfBlocks / 8.0F);
/*  938 */     double d1 = ((par3 + 8) - MathHelper.sin(f) * numberOfBlocks / 8.0F);
/*  939 */     double d2 = ((par5 + 8) + MathHelper.cos(f) * numberOfBlocks / 8.0F);
/*  940 */     double d3 = ((par5 + 8) - MathHelper.cos(f) * numberOfBlocks / 8.0F);
/*  941 */     double d4 = (par4 + par2Random.nextInt(3) - 2);
/*  942 */     double d5 = (par4 + par2Random.nextInt(3) - 2);
/*      */     
/*  944 */     for (int l = 0; l <= numberOfBlocks; l++) {
/*      */       
/*  946 */       double d6 = d0 + (d1 - d0) * l / numberOfBlocks;
/*  947 */       double d7 = d4 + (d5 - d4) * l / numberOfBlocks;
/*  948 */       double d8 = d2 + (d3 - d2) * l / numberOfBlocks;
/*  949 */       double d9 = par2Random.nextDouble() * numberOfBlocks / 16.0D;
/*  950 */       double d10 = (MathHelper.sin(l * 3.1415927F / numberOfBlocks) + 1.0F) * d9 + 1.0D;
/*  951 */       double d11 = (MathHelper.sin(l * 3.1415927F / numberOfBlocks) + 1.0F) * d9 + 1.0D;
/*  952 */       int i1 = MathHelper.floor_double(d6 - d10 / 2.0D);
/*  953 */       int j1 = MathHelper.floor_double(d7 - d11 / 2.0D);
/*  954 */       int k1 = MathHelper.floor_double(d8 - d10 / 2.0D);
/*  955 */       int l1 = MathHelper.floor_double(d6 + d10 / 2.0D);
/*  956 */       int i2 = MathHelper.floor_double(d7 + d11 / 2.0D);
/*  957 */       int j2 = MathHelper.floor_double(d8 + d10 / 2.0D);
/*      */       
/*  959 */       for (int k2 = i1; k2 <= l1; k2++) {
/*      */         
/*  961 */         double d12 = (k2 + 0.5D - d6) / d10 / 2.0D;
/*      */         
/*  963 */         if (d12 * d12 < 1.0D)
/*      */         {
/*  965 */           for (int l2 = j1; l2 <= i2; l2++) {
/*      */             
/*  967 */             double d13 = (l2 + 0.5D - d7) / d11 / 2.0D;
/*      */             
/*  969 */             if (d12 * d12 + d13 * d13 < 1.0D)
/*      */             {
/*  971 */               for (int i3 = k1; i3 <= j2; i3++) {
/*      */                 
/*  973 */                 double d14 = (i3 + 0.5D - d8) / d10 / 2.0D;
/*      */                 
/*  975 */                 Block bid = OreSpawnMain.getBlockIDInChunk(chunk, k2, l2, i3);
/*      */                 
/*  977 */                 if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && bid == oldbid)
/*      */                 {
/*  979 */                   OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, k2, l2, i3, newbid, 0);
/*      */                 }
/*      */               } 
/*      */             }
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  988 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addRice(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
/*  994 */     if (random.nextInt(10) != 0)
/*      */       return; 
/*  996 */     for (int i = 0; i < 5; i++) {
/*  997 */       int posX = chunkX + random.nextInt(16);
/*  998 */       int posZ = chunkZ + random.nextInt(16);
/*  999 */       for (int posY = 128; posY > 40; posY--) {
/*      */ 
/*      */         
/* 1002 */         if (OreSpawnMain.getBlockIDInChunk(chunk, posX, posY, posZ) == Blocks.air && OreSpawnMain.getBlockIDInChunk(chunk, posX, posY - 1, posZ) == OreSpawnMain.CrystalGrass) {
/*      */           
/* 1004 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, posX, posY, posZ, OreSpawnMain.MyRicePlant, 0);
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addQuinoa(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
/* 1013 */     if (random.nextInt(20) != 0)
/*      */       return; 
/* 1015 */     for (int i = 0; i < 5; i++) {
/* 1016 */       int posX = chunkX + random.nextInt(16);
/* 1017 */       int posZ = chunkZ + random.nextInt(16);
/* 1018 */       for (int posY = 128; posY > 40; posY--) {
/*      */ 
/*      */         
/* 1021 */         if (OreSpawnMain.getBlockIDInChunk(chunk, posX, posY, posZ) == Blocks.air && OreSpawnMain.getBlockIDInChunk(chunk, posX, posY - 1, posZ) == OreSpawnMain.CrystalGrass) {
/*      */           
/* 1023 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, posX, posY, posZ, OreSpawnMain.MyQuinoaPlant1, 0);
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addCrystalFlowers(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
/* 1034 */     if (random.nextInt(3) != 0)
/*      */       return; 
/* 1036 */     int howmany = 0;
/* 1037 */     howmany = 1 + random.nextInt(13);
/*      */     
/* 1039 */     int what = random.nextInt(4);
/*      */     
/* 1041 */     for (int i = 0; i < howmany; i++) {
/* 1042 */       int posX = chunkX + random.nextInt(16);
/* 1043 */       int posZ = chunkZ + random.nextInt(16);
/* 1044 */       for (int posY = 128; posY > 40; posY--) {
/*      */ 
/*      */         
/* 1047 */         if (OreSpawnMain.getBlockIDInChunk(chunk, posX, posY, posZ) == Blocks.air && OreSpawnMain.getBlockIDInChunk(chunk, posX, posY - 1, posZ) == OreSpawnMain.CrystalGrass) {
/*      */           
/* 1049 */           if (what == 0) {
/* 1050 */             OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, posX, posY, posZ, OreSpawnMain.CrystalFlowerRedBlock, 0); break;
/* 1051 */           }  if (what == 1) {
/* 1052 */             OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, posX, posY, posZ, OreSpawnMain.CrystalFlowerGreenBlock, 0); break;
/* 1053 */           }  if (what == 2) {
/* 1054 */             OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, posX, posY, posZ, OreSpawnMain.CrystalFlowerBlueBlock, 0); break;
/* 1055 */           }  if (what == 3) {
/* 1056 */             OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, posX, posY, posZ, OreSpawnMain.CrystalFlowerYellowBlock, 0);
/*      */           }
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ChunkPosition func_147416_a(World var1, String var2, int var3, int var4, int var5) {
/* 1069 */     return null;
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ChunkProviderOreSpawn5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */