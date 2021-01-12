/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFalling;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.IProgressUpdate;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ import net.minecraft.world.SpawnerAnimals;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.gen.MapGenBase;
/*     */ import net.minecraft.world.gen.MapGenCaves;
/*     */ import net.minecraft.world.gen.MapGenRavine;
/*     */ import net.minecraft.world.gen.NoiseGenerator;
/*     */ import net.minecraft.world.gen.NoiseGeneratorOctaves;
/*     */ import net.minecraft.world.gen.NoiseGeneratorPerlin;
/*     */ import net.minecraft.world.gen.feature.WorldGenDungeons;
/*     */ import net.minecraft.world.gen.feature.WorldGenLakes;
/*     */ import net.minecraft.world.gen.structure.MapGenMineshaft;
/*     */ import net.minecraft.world.gen.structure.MapGenScatteredFeature;
/*     */ import net.minecraft.world.gen.structure.MapGenStronghold;
/*     */ import net.minecraftforge.event.terraingen.PopulateChunkEvent;
/*     */ import net.minecraftforge.event.terraingen.TerrainGen;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChunkProviderOreSpawn3
/*     */   implements IChunkProvider
/*     */ {
/*     */   private Random rand;
/*     */   private NoiseGeneratorOctaves field_147431_j;
/*     */   private NoiseGeneratorOctaves field_147432_k;
/*     */   private NoiseGeneratorOctaves field_147429_l;
/*     */   private NoiseGeneratorPerlin field_147430_m;
/*     */   public NoiseGeneratorOctaves noiseGen5;
/*     */   public NoiseGeneratorOctaves noiseGen6;
/*     */   public NoiseGeneratorOctaves mobSpawnerNoise;
/*     */   private World worldObj;
/*     */   private final boolean mapFeaturesEnabled;
/*     */   private WorldType field_147435_p;
/*     */   private final double[] field_147434_q;
/*     */   private final float[] parabolicField;
/*  67 */   private double[] stoneNoise = new double[256];
/*  68 */   private MapGenBase caveGenerator = (MapGenBase)new MapGenCaves();
/*     */ 
/*     */ 
/*     */   
/*  72 */   private MapGenStronghold strongholdGenerator = new MapGenStronghold();
/*     */ 
/*     */ 
/*     */   
/*  76 */   private MapGenMoreVillages villageGenerator = new MapGenMoreVillages();
/*     */ 
/*     */ 
/*     */   
/*  80 */   private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
/*  81 */   private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
/*     */ 
/*     */ 
/*     */   
/*  85 */   private MapGenBase ravineGenerator = (MapGenBase)new MapGenRavine();
/*     */   
/*     */   private BiomeGenBase[] biomesForGeneration;
/*     */   
/*     */   double[] field_147427_d;
/*     */   
/*     */   double[] field_147428_e;
/*     */   double[] field_147425_f;
/*     */   double[] field_147426_g;
/*  94 */   int[][] field_73219_j = new int[32][32];
/*     */ 
/*     */   
/*     */   public ChunkProviderOreSpawn3(World par1World, long par2, boolean par4) {
/*  98 */     this.worldObj = par1World;
/*  99 */     this.mapFeaturesEnabled = par4;
/* 100 */     this.field_147435_p = par1World.getWorldInfo().getTerrainType();
/* 101 */     this.rand = new Random(par2);
/* 102 */     this.field_147431_j = new NoiseGeneratorOctaves(this.rand, 16);
/* 103 */     this.field_147432_k = new NoiseGeneratorOctaves(this.rand, 16);
/* 104 */     this.field_147429_l = new NoiseGeneratorOctaves(this.rand, 8);
/* 105 */     this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
/* 106 */     this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
/* 107 */     this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
/* 108 */     this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
/* 109 */     this.field_147434_q = new double[825];
/* 110 */     this.parabolicField = new float[25];
/*     */     
/* 112 */     for (int j = -2; j <= 2; j++) {
/*     */       
/* 114 */       for (int k = -2; k <= 2; k++) {
/*     */         
/* 116 */         float f = 10.0F / MathHelper.sqrt_float((j * j + k * k) + 0.2F);
/* 117 */         this.parabolicField[j + 2 + (k + 2) * 5] = f;
/*     */       } 
/*     */     } 
/*     */     
/* 121 */     NoiseGenerator[] noiseGens = { (NoiseGenerator)this.field_147431_j, (NoiseGenerator)this.field_147432_k, (NoiseGenerator)this.field_147429_l, (NoiseGenerator)this.field_147430_m, (NoiseGenerator)this.noiseGen5, (NoiseGenerator)this.noiseGen6, (NoiseGenerator)this.mobSpawnerNoise };
/* 122 */     noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.rand, noiseGens);
/* 123 */     this.field_147431_j = (NoiseGeneratorOctaves)noiseGens[0];
/* 124 */     this.field_147432_k = (NoiseGeneratorOctaves)noiseGens[1];
/* 125 */     this.field_147429_l = (NoiseGeneratorOctaves)noiseGens[2];
/* 126 */     this.field_147430_m = (NoiseGeneratorPerlin)noiseGens[3];
/* 127 */     this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
/* 128 */     this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
/* 129 */     this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147424_a(int p_147424_1_, int p_147424_2_, Block[] p_147424_3_) {
/* 134 */     byte b0 = 63;
/* 135 */     this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, p_147424_1_ * 4 - 2, p_147424_2_ * 4 - 2, 10, 10);
/* 136 */     func_147423_a(p_147424_1_ * 4, 0, p_147424_2_ * 4);
/*     */     
/* 138 */     for (int k = 0; k < 4; k++) {
/*     */       
/* 140 */       int l = k * 5;
/* 141 */       int i1 = (k + 1) * 5;
/*     */       
/* 143 */       for (int j1 = 0; j1 < 4; j1++) {
/*     */         
/* 145 */         int k1 = (l + j1) * 33;
/* 146 */         int l1 = (l + j1 + 1) * 33;
/* 147 */         int i2 = (i1 + j1) * 33;
/* 148 */         int j2 = (i1 + j1 + 1) * 33;
/*     */         
/* 150 */         for (int k2 = 0; k2 < 32; k2++) {
/*     */           
/* 152 */           double d0 = 0.125D;
/* 153 */           double d1 = this.field_147434_q[k1 + k2];
/* 154 */           double d2 = this.field_147434_q[l1 + k2];
/* 155 */           double d3 = this.field_147434_q[i2 + k2];
/* 156 */           double d4 = this.field_147434_q[j2 + k2];
/* 157 */           double d5 = (this.field_147434_q[k1 + k2 + 1] - d1) * d0;
/* 158 */           double d6 = (this.field_147434_q[l1 + k2 + 1] - d2) * d0;
/* 159 */           double d7 = (this.field_147434_q[i2 + k2 + 1] - d3) * d0;
/* 160 */           double d8 = (this.field_147434_q[j2 + k2 + 1] - d4) * d0;
/*     */           
/* 162 */           for (int l2 = 0; l2 < 8; l2++) {
/*     */             
/* 164 */             double d9 = 0.25D;
/* 165 */             double d10 = d1;
/* 166 */             double d11 = d2;
/* 167 */             double d12 = (d3 - d1) * d9;
/* 168 */             double d13 = (d4 - d2) * d9;
/*     */             
/* 170 */             for (int i3 = 0; i3 < 4; i3++) {
/*     */               
/* 172 */               int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
/* 173 */               short short1 = 256;
/* 174 */               j3 -= short1;
/* 175 */               double d14 = 0.25D;
/* 176 */               double d16 = (d11 - d10) * d14;
/* 177 */               double d15 = d10 - d16;
/*     */               
/* 179 */               for (int k3 = 0; k3 < 4; k3++) {
/*     */                 
/* 181 */                 if ((d15 += d16) > 0.0D) {
/*     */                   
/* 183 */                   p_147424_3_[j3 += short1] = Blocks.stone;
/*     */                 }
/* 185 */                 else if (k2 * 8 + l2 < b0) {
/*     */                   
/* 187 */                   p_147424_3_[j3 += short1] = Blocks.water;
/*     */                 }
/*     */                 else {
/*     */                   
/* 191 */                   p_147424_3_[j3 += short1] = null;
/*     */                 } 
/*     */               } 
/*     */               
/* 195 */               d10 += d12;
/* 196 */               d11 += d13;
/*     */             } 
/*     */             
/* 199 */             d1 += d5;
/* 200 */             d2 += d6;
/* 201 */             d3 += d7;
/* 202 */             d4 += d8;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void replaceBlocksForBiome(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_, byte[] p_147422_4_, BiomeGenBase[] p_147422_5_) {
/* 215 */     double d0 = 0.03125D;
/* 216 */     this.stoneNoise = this.field_147430_m.getRegion(this.stoneNoise, (p_147422_1_ * 16), (p_147422_2_ * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
/*     */     
/* 218 */     for (int k = 0; k < 16; k++) {
/*     */       
/* 220 */       for (int l = 0; l < 16; l++) {
/*     */         
/* 222 */         BiomeGenBase biomegenbase = p_147422_5_[l + k * 16];
/* 223 */         biomegenbase.genTerrainBlocks(this.worldObj, this.rand, p_147422_3_, p_147422_4_, p_147422_1_ * 16 + k, p_147422_2_ * 16 + l, this.stoneNoise[l + k * 16]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk loadChunk(int par1, int par2) {
/* 233 */     return provideChunk(par1, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk provideChunk(int par1, int par2) {
/* 242 */     this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
/* 243 */     Block[] ablock = new Block[65536];
/* 244 */     byte[] abyte = new byte[65536];
/* 245 */     func_147424_a(par1, par2, ablock);
/* 246 */     this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
/* 247 */     replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
/* 248 */     this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/* 249 */     this.ravineGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/*     */     
/* 251 */     if (this.mapFeaturesEnabled) {
/*     */ 
/*     */       
/* 254 */       this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/*     */       
/* 256 */       this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/*     */     } 
/*     */     
/* 259 */     Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
/*     */     
/* 261 */     OreSpawnMain.Chunker.generateOresInChunk(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
/*     */     
/* 263 */     chunk.generateSkylightMap();
/* 264 */     return chunk;
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_147423_a(int p_147423_1_, int p_147423_2_, int p_147423_3_) {
/* 269 */     double d0 = 684.412D;
/* 270 */     double d1 = 684.412D;
/* 271 */     double d2 = 512.0D;
/* 272 */     double d3 = 512.0D;
/* 273 */     this.field_147426_g = this.noiseGen6.generateNoiseOctaves(this.field_147426_g, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D);
/* 274 */     this.field_147427_d = this.field_147429_l.generateNoiseOctaves(this.field_147427_d, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
/* 275 */     this.field_147428_e = this.field_147431_j.generateNoiseOctaves(this.field_147428_e, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 276 */     this.field_147425_f = this.field_147432_k.generateNoiseOctaves(this.field_147425_f, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 277 */     boolean flag1 = false;
/* 278 */     boolean flag = false;
/* 279 */     int l = 0;
/* 280 */     int i1 = 0;
/* 281 */     double d4 = 8.5D;
/*     */     
/* 283 */     for (int j1 = 0; j1 < 5; j1++) {
/*     */       
/* 285 */       for (int k1 = 0; k1 < 5; k1++) {
/*     */         
/* 287 */         float f = 0.0F;
/* 288 */         float f1 = 0.0F;
/* 289 */         float f2 = 0.0F;
/* 290 */         byte b0 = 2;
/* 291 */         BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
/*     */         
/* 293 */         for (int l1 = -b0; l1 <= b0; l1++) {
/*     */           
/* 295 */           for (int i2 = -b0; i2 <= b0; i2++) {
/*     */             
/* 297 */             BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
/* 298 */             float f3 = biomegenbase1.rootHeight;
/* 299 */             float f4 = biomegenbase1.heightVariation;
/*     */             
/* 301 */             if (this.field_147435_p == WorldType.AMPLIFIED && f3 > 0.0F) {
/*     */               
/* 303 */               f3 = 1.0F + f3 * 2.0F;
/* 304 */               f4 = 1.0F + f4 * 4.0F;
/*     */             } 
/*     */             
/* 307 */             float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);
/*     */             
/* 309 */             if (biomegenbase1.rootHeight > biomegenbase.rootHeight)
/*     */             {
/* 311 */               f5 /= 2.0F;
/*     */             }
/*     */             
/* 314 */             f += f4 * f5;
/* 315 */             f1 += f3 * f5;
/* 316 */             f2 += f5;
/*     */           } 
/*     */         } 
/*     */         
/* 320 */         f /= f2;
/* 321 */         f1 /= f2;
/* 322 */         f = f * 0.9F + 0.1F;
/* 323 */         f1 = (f1 * 4.0F - 1.0F) / 8.0F;
/* 324 */         double d13 = this.field_147426_g[i1] / 8000.0D;
/*     */         
/* 326 */         if (d13 < 0.0D)
/*     */         {
/* 328 */           d13 = -d13 * 0.3D;
/*     */         }
/*     */         
/* 331 */         d13 = d13 * 3.0D - 2.0D;
/*     */         
/* 333 */         if (d13 < 0.0D) {
/*     */           
/* 335 */           d13 /= 2.0D;
/*     */           
/* 337 */           if (d13 < -1.0D)
/*     */           {
/* 339 */             d13 = -1.0D;
/*     */           }
/*     */           
/* 342 */           d13 /= 1.4D;
/* 343 */           d13 /= 2.0D;
/*     */         }
/*     */         else {
/*     */           
/* 347 */           if (d13 > 1.0D)
/*     */           {
/* 349 */             d13 = 1.0D;
/*     */           }
/*     */           
/* 352 */           d13 /= 8.0D;
/*     */         } 
/*     */         
/* 355 */         i1++;
/* 356 */         double d12 = f1;
/* 357 */         double d14 = f;
/* 358 */         d12 += d13 * 0.2D;
/* 359 */         d12 = d12 * 8.5D / 8.0D;
/* 360 */         double d5 = 8.5D + d12 * 4.0D;
/*     */         
/* 362 */         for (int j2 = 0; j2 < 33; j2++) {
/*     */           
/* 364 */           double d6 = (j2 - d5) * 12.0D * 128.0D / 256.0D / d14;
/*     */           
/* 366 */           if (d6 < 0.0D)
/*     */           {
/* 368 */             d6 *= 4.0D;
/*     */           }
/*     */           
/* 371 */           double d7 = this.field_147428_e[l] / 512.0D;
/* 372 */           double d8 = this.field_147425_f[l] / 512.0D;
/* 373 */           double d9 = (this.field_147427_d[l] / 10.0D + 1.0D) / 2.0D;
/* 374 */           double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;
/*     */           
/* 376 */           if (j2 > 29) {
/*     */             
/* 378 */             double d11 = ((j2 - 29) / 3.0F);
/* 379 */             d10 = d10 * (1.0D - d11) + -10.0D * d11;
/*     */           } 
/*     */           
/* 382 */           this.field_147434_q[l] = d10;
/* 383 */           l++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean chunkExists(int par1, int par2) {
/* 394 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
/* 402 */     BlockFalling.fallInstantly = true;
/* 403 */     int k = par2 * 16;
/* 404 */     int l = par3 * 16;
/* 405 */     BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
/* 406 */     this.rand.setSeed(this.worldObj.getSeed());
/* 407 */     long i1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 408 */     long j1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 409 */     this.rand.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.getSeed());
/* 410 */     boolean flag = false;
/*     */ 
/*     */ 
/*     */     
/* 414 */     if (this.mapFeaturesEnabled) {
/*     */       
/* 416 */       this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
/* 417 */       flag = this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
/* 418 */       this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
/* 419 */       this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 426 */     if (biomegenbase != BiomeGenBase.desert && biomegenbase != BiomeGenBase.desertHills && !flag && this.rand.nextInt(4) == 0 && TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.LAKE)) {
/*     */ 
/*     */       
/* 429 */       int i = k + this.rand.nextInt(16) + 8;
/* 430 */       int l1 = this.rand.nextInt(256);
/* 431 */       int i2 = l + this.rand.nextInt(16) + 8;
/* 432 */       (new WorldGenLakes(Blocks.water)).generate(this.worldObj, this.rand, i, l1, i2);
/*     */     } 
/*     */     
/* 435 */     if (TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.LAVA) && !flag && this.rand.nextInt(8) == 0) {
/*     */       
/* 437 */       int i = k + this.rand.nextInt(16) + 8;
/* 438 */       int l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
/* 439 */       int i2 = l + this.rand.nextInt(16) + 8;
/*     */       
/* 441 */       if (l1 < 63 || this.rand.nextInt(10) == 0)
/*     */       {
/* 443 */         (new WorldGenLakes(Blocks.lava)).generate(this.worldObj, this.rand, i, l1, i2);
/*     */       }
/*     */     } 
/*     */     
/* 447 */     boolean doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.DUNGEON); int k1;
/* 448 */     for (k1 = 0; doGen && k1 < 8; k1++) {
/*     */       
/* 450 */       int l1 = k + this.rand.nextInt(16) + 8;
/* 451 */       int i2 = this.rand.nextInt(256);
/* 452 */       int j2 = l + this.rand.nextInt(16) + 8;
/* 453 */       (new WorldGenDungeons()).generate(this.worldObj, this.rand, l1, i2, j2);
/*     */     } 
/*     */     
/* 456 */     biomegenbase.decorate(this.worldObj, this.rand, k, l);
/* 457 */     SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
/* 458 */     k += 8;
/* 459 */     l += 8;
/*     */     
/* 461 */     doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.ICE);
/* 462 */     for (k1 = 0; doGen && k1 < 16; k1++) {
/*     */       
/* 464 */       for (int l1 = 0; l1 < 16; l1++) {
/*     */         
/* 466 */         int i2 = this.worldObj.getPrecipitationHeight(k + k1, l + l1);
/*     */         
/* 468 */         if (this.worldObj.isBlockFreezable(k1 + k, i2 - 1, l1 + l))
/*     */         {
/* 470 */           this.worldObj.setBlock(k1 + k, i2 - 1, l1 + l, Blocks.ice, 0, 2);
/*     */         }
/*     */         
/* 473 */         if (this.worldObj.func_147478_e(k1 + k, i2, l1 + l, true))
/*     */         {
/* 475 */           this.worldObj.setBlock(k1 + k, i2, l1 + l, Blocks.snow_layer, 0, 2);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 482 */     BlockFalling.fallInstantly = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate) {
/* 491 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveExtraData() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unloadQueuedChunks() {
/* 505 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSave() {
/* 513 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String makeString() {
/* 521 */     return "MiningDimension";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
/* 529 */     BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(par2, par4);
/* 530 */     return (par1EnumCreatureType == EnumCreatureType.monster && this.scatteredFeatureGenerator.func_143030_a(par2, par3, par4)) ? this.scatteredFeatureGenerator.getScatteredFeatureSpawnList() : biomegenbase.getSpawnableList(par1EnumCreatureType);
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
/* 535 */     return ("Stronghold".equals(p_147416_2_) && this.strongholdGenerator != null) ? this.strongholdGenerator.func_151545_a(p_147416_1_, p_147416_3_, p_147416_4_, p_147416_5_) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLoadedChunkCount() {
/* 540 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void recreateStructures(int par1, int par2) {
/* 545 */     if (this.mapFeaturesEnabled) {
/*     */       
/* 547 */       this.mineshaftGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[])null);
/* 548 */       this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[])null);
/* 549 */       this.strongholdGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[])null);
/* 550 */       this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[])null);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ChunkProviderOreSpawn3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */