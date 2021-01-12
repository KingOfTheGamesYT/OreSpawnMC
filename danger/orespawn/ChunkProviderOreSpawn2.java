/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ public class ChunkProviderOreSpawn2
/*     */   implements IChunkProvider
/*     */ {
/*     */   private Random rand;
/*  58 */   private ArrayList MyMobList = null;
/*  59 */   private ArrayList MyCritterList = null;
/*  60 */   private ArrayList MyAmbientList = null;
/*     */   
/*     */   private NoiseGeneratorOctaves field_147431_j;
/*     */   
/*     */   private NoiseGeneratorOctaves field_147432_k;
/*     */   
/*     */   private NoiseGeneratorOctaves field_147429_l;
/*     */   
/*     */   private NoiseGeneratorPerlin field_147430_m;
/*     */   
/*     */   public NoiseGeneratorOctaves noiseGen5;
/*     */   
/*     */   public NoiseGeneratorOctaves noiseGen6;
/*     */   
/*     */   public NoiseGeneratorOctaves mobSpawnerNoise;
/*     */   
/*     */   private World worldObj;
/*     */   
/*     */   private final boolean mapFeaturesEnabled;
/*     */   
/*     */   private WorldType field_147435_p;
/*     */   
/*     */   private final double[] field_147434_q;
/*     */   
/*     */   private final float[] parabolicField;
/*     */   
/*  86 */   private double[] stoneNoise = new double[256];
/*  87 */   private MapGenBase caveGenerator = (MapGenBase)new MapGenCaves();
/*     */ 
/*     */ 
/*     */   
/*  91 */   private MapGenStronghold strongholdGenerator = new MapGenStronghold();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
/* 100 */   private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
/*     */ 
/*     */ 
/*     */   
/* 104 */   private MapGenBase ravineGenerator = (MapGenBase)new MapGenRavine();
/*     */   
/*     */   private BiomeGenBase[] biomesForGeneration;
/*     */   
/*     */   double[] field_147427_d;
/*     */   
/*     */   double[] field_147428_e;
/*     */   double[] field_147425_f;
/*     */   double[] field_147426_g;
/* 113 */   int[][] field_73219_j = new int[32][32];
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000396";
/*     */ 
/*     */   
/*     */   public ChunkProviderOreSpawn2(World par1World, long par2, boolean par4) {
/* 120 */     this.worldObj = par1World;
/* 121 */     this.mapFeaturesEnabled = par4;
/* 122 */     this.field_147435_p = par1World.getWorldInfo().getTerrainType();
/* 123 */     this.rand = new Random(par2);
/* 124 */     this.field_147431_j = new NoiseGeneratorOctaves(this.rand, 16);
/* 125 */     this.field_147432_k = new NoiseGeneratorOctaves(this.rand, 16);
/* 126 */     this.field_147429_l = new NoiseGeneratorOctaves(this.rand, 8);
/* 127 */     this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
/* 128 */     this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
/* 129 */     this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
/* 130 */     this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
/* 131 */     this.field_147434_q = new double[825];
/* 132 */     this.parabolicField = new float[25];
/*     */     
/* 134 */     for (int j = -2; j <= 2; j++) {
/*     */       
/* 136 */       for (int k = -2; k <= 2; k++) {
/*     */         
/* 138 */         float f = 10.0F / MathHelper.sqrt_float((j * j + k * k) + 0.2F);
/* 139 */         this.parabolicField[j + 2 + (k + 2) * 5] = f;
/*     */       } 
/*     */     } 
/*     */     
/* 143 */     NoiseGenerator[] noiseGens = { (NoiseGenerator)this.field_147431_j, (NoiseGenerator)this.field_147432_k, (NoiseGenerator)this.field_147429_l, (NoiseGenerator)this.field_147430_m, (NoiseGenerator)this.noiseGen5, (NoiseGenerator)this.noiseGen6, (NoiseGenerator)this.mobSpawnerNoise };
/* 144 */     noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.rand, noiseGens);
/* 145 */     this.field_147431_j = (NoiseGeneratorOctaves)noiseGens[0];
/* 146 */     this.field_147432_k = (NoiseGeneratorOctaves)noiseGens[1];
/* 147 */     this.field_147429_l = (NoiseGeneratorOctaves)noiseGens[2];
/* 148 */     this.field_147430_m = (NoiseGeneratorPerlin)noiseGens[3];
/* 149 */     this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
/* 150 */     this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
/* 151 */     this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147424_a(int p_147424_1_, int p_147424_2_, Block[] p_147424_3_) {
/* 156 */     byte b0 = 63;
/* 157 */     this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, p_147424_1_ * 4 - 2, p_147424_2_ * 4 - 2, 10, 10);
/* 158 */     func_147423_a(p_147424_1_ * 4, 0, p_147424_2_ * 4);
/*     */     
/* 160 */     for (int k = 0; k < 4; k++) {
/*     */       
/* 162 */       int l = k * 5;
/* 163 */       int i1 = (k + 1) * 5;
/*     */       
/* 165 */       for (int j1 = 0; j1 < 4; j1++) {
/*     */         
/* 167 */         int k1 = (l + j1) * 33;
/* 168 */         int l1 = (l + j1 + 1) * 33;
/* 169 */         int i2 = (i1 + j1) * 33;
/* 170 */         int j2 = (i1 + j1 + 1) * 33;
/*     */         
/* 172 */         for (int k2 = 0; k2 < 32; k2++) {
/*     */           
/* 174 */           double d0 = 0.125D;
/* 175 */           double d1 = this.field_147434_q[k1 + k2];
/* 176 */           double d2 = this.field_147434_q[l1 + k2];
/* 177 */           double d3 = this.field_147434_q[i2 + k2];
/* 178 */           double d4 = this.field_147434_q[j2 + k2];
/* 179 */           double d5 = (this.field_147434_q[k1 + k2 + 1] - d1) * d0;
/* 180 */           double d6 = (this.field_147434_q[l1 + k2 + 1] - d2) * d0;
/* 181 */           double d7 = (this.field_147434_q[i2 + k2 + 1] - d3) * d0;
/* 182 */           double d8 = (this.field_147434_q[j2 + k2 + 1] - d4) * d0;
/*     */           
/* 184 */           for (int l2 = 0; l2 < 8; l2++) {
/*     */             
/* 186 */             double d9 = 0.25D;
/* 187 */             double d10 = d1;
/* 188 */             double d11 = d2;
/* 189 */             double d12 = (d3 - d1) * d9;
/* 190 */             double d13 = (d4 - d2) * d9;
/*     */             
/* 192 */             for (int i3 = 0; i3 < 4; i3++) {
/*     */               
/* 194 */               int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
/* 195 */               short short1 = 256;
/* 196 */               j3 -= short1;
/* 197 */               double d14 = 0.25D;
/* 198 */               double d16 = (d11 - d10) * d14;
/* 199 */               double d15 = d10 - d16;
/*     */               
/* 201 */               for (int k3 = 0; k3 < 4; k3++) {
/*     */                 
/* 203 */                 if ((d15 += d16) > 0.0D) {
/*     */                   
/* 205 */                   p_147424_3_[j3 += short1] = Blocks.stone;
/*     */                 }
/* 207 */                 else if (k2 * 8 + l2 < b0) {
/*     */                   
/* 209 */                   p_147424_3_[j3 += short1] = Blocks.water;
/*     */                 }
/*     */                 else {
/*     */                   
/* 213 */                   p_147424_3_[j3 += short1] = null;
/*     */                 } 
/*     */               } 
/*     */               
/* 217 */               d10 += d12;
/* 218 */               d11 += d13;
/*     */             } 
/*     */             
/* 221 */             d1 += d5;
/* 222 */             d2 += d6;
/* 223 */             d3 += d7;
/* 224 */             d4 += d8;
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
/* 237 */     double d0 = 0.03125D;
/* 238 */     this.stoneNoise = this.field_147430_m.getRegion(this.stoneNoise, (p_147422_1_ * 16), (p_147422_2_ * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
/*     */     
/* 240 */     for (int k = 0; k < 16; k++) {
/*     */       
/* 242 */       for (int l = 0; l < 16; l++) {
/*     */         
/* 244 */         BiomeGenBase biomegenbase = p_147422_5_[l + k * 16];
/* 245 */         biomegenbase.genTerrainBlocks(this.worldObj, this.rand, p_147422_3_, p_147422_4_, p_147422_1_ * 16 + k, p_147422_2_ * 16 + l, this.stoneNoise[l + k * 16]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk loadChunk(int par1, int par2) {
/* 255 */     return provideChunk(par1, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk provideChunk(int par1, int par2) {
/* 264 */     this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
/* 265 */     Block[] ablock = new Block[65536];
/* 266 */     byte[] abyte = new byte[65536];
/* 267 */     func_147424_a(par1, par2, ablock);
/* 268 */     this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
/* 269 */     replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
/* 270 */     this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/* 271 */     this.ravineGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 281 */     Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
/*     */     
/* 283 */     OreSpawnMain.Chunker.generateOresInChunk(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
/* 284 */     if (OreSpawnMain.LessOre == 0) {
/* 285 */       OreSpawnMain.Chunker.generateOresInChunk(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
/* 286 */       OreSpawnMain.Chunker.generateOresInChunk(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
/*     */     } 
/*     */     
/* 289 */     chunk.generateSkylightMap();
/* 290 */     return chunk;
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_147423_a(int p_147423_1_, int p_147423_2_, int p_147423_3_) {
/* 295 */     double d0 = 684.412D;
/* 296 */     double d1 = 684.412D;
/* 297 */     double d2 = 512.0D;
/* 298 */     double d3 = 512.0D;
/* 299 */     this.field_147426_g = this.noiseGen6.generateNoiseOctaves(this.field_147426_g, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D);
/* 300 */     this.field_147427_d = this.field_147429_l.generateNoiseOctaves(this.field_147427_d, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
/* 301 */     this.field_147428_e = this.field_147431_j.generateNoiseOctaves(this.field_147428_e, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 302 */     this.field_147425_f = this.field_147432_k.generateNoiseOctaves(this.field_147425_f, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 303 */     boolean flag1 = false;
/* 304 */     boolean flag = false;
/* 305 */     int l = 0;
/* 306 */     int i1 = 0;
/* 307 */     double d4 = 8.5D;
/*     */     
/* 309 */     for (int j1 = 0; j1 < 5; j1++) {
/*     */       
/* 311 */       for (int k1 = 0; k1 < 5; k1++) {
/*     */         
/* 313 */         float f = 0.0F;
/* 314 */         float f1 = 0.0F;
/* 315 */         float f2 = 0.0F;
/* 316 */         byte b0 = 2;
/* 317 */         BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
/*     */         
/* 319 */         for (int l1 = -b0; l1 <= b0; l1++) {
/*     */           
/* 321 */           for (int i2 = -b0; i2 <= b0; i2++) {
/*     */             
/* 323 */             BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
/* 324 */             float f3 = biomegenbase1.rootHeight;
/* 325 */             float f4 = biomegenbase1.heightVariation;
/*     */             
/* 327 */             if (this.field_147435_p == WorldType.AMPLIFIED && f3 > 0.0F) {
/*     */               
/* 329 */               f3 = 1.0F + f3 * 2.0F;
/* 330 */               f4 = 1.0F + f4 * 4.0F;
/*     */             } 
/*     */             
/* 333 */             float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);
/*     */             
/* 335 */             if (biomegenbase1.rootHeight > biomegenbase.rootHeight)
/*     */             {
/* 337 */               f5 /= 2.0F;
/*     */             }
/*     */             
/* 340 */             f += f4 * f5;
/* 341 */             f1 += f3 * f5;
/* 342 */             f2 += f5;
/*     */           } 
/*     */         } 
/*     */         
/* 346 */         f /= f2;
/* 347 */         f1 /= f2;
/* 348 */         f = f * 0.9F + 0.1F;
/* 349 */         f1 = (f1 * 4.0F - 1.0F) / 8.0F;
/* 350 */         double d13 = this.field_147426_g[i1] / 8000.0D;
/*     */         
/* 352 */         if (d13 < 0.0D)
/*     */         {
/* 354 */           d13 = -d13 * 0.3D;
/*     */         }
/*     */         
/* 357 */         d13 = d13 * 3.0D - 2.0D;
/*     */         
/* 359 */         if (d13 < 0.0D) {
/*     */           
/* 361 */           d13 /= 2.0D;
/*     */           
/* 363 */           if (d13 < -1.0D)
/*     */           {
/* 365 */             d13 = -1.0D;
/*     */           }
/*     */           
/* 368 */           d13 /= 1.4D;
/* 369 */           d13 /= 2.0D;
/*     */         }
/*     */         else {
/*     */           
/* 373 */           if (d13 > 1.0D)
/*     */           {
/* 375 */             d13 = 1.0D;
/*     */           }
/*     */           
/* 378 */           d13 /= 8.0D;
/*     */         } 
/*     */         
/* 381 */         i1++;
/* 382 */         double d12 = f1;
/* 383 */         double d14 = f;
/* 384 */         d12 += d13 * 0.2D;
/* 385 */         d12 = d12 * 8.5D / 8.0D;
/* 386 */         double d5 = 8.5D + d12 * 4.0D;
/*     */         
/* 388 */         for (int j2 = 0; j2 < 33; j2++) {
/*     */           
/* 390 */           double d6 = (j2 - d5) * 12.0D * 128.0D / 256.0D / d14;
/*     */           
/* 392 */           if (d6 < 0.0D)
/*     */           {
/* 394 */             d6 *= 4.0D;
/*     */           }
/*     */           
/* 397 */           double d7 = this.field_147428_e[l] / 512.0D;
/* 398 */           double d8 = this.field_147425_f[l] / 512.0D;
/* 399 */           double d9 = (this.field_147427_d[l] / 10.0D + 1.0D) / 2.0D;
/* 400 */           double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;
/*     */           
/* 402 */           if (j2 > 29) {
/*     */             
/* 404 */             double d11 = ((j2 - 29) / 3.0F);
/* 405 */             d10 = d10 * (1.0D - d11) + -10.0D * d11;
/*     */           } 
/*     */           
/* 408 */           this.field_147434_q[l] = d10;
/* 409 */           l++;
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
/* 420 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
/* 428 */     BlockFalling.fallInstantly = true;
/* 429 */     int k = par2 * 16;
/* 430 */     int l = par3 * 16;
/* 431 */     BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
/* 432 */     this.rand.setSeed(this.worldObj.getSeed());
/* 433 */     long i1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 434 */     long j1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 435 */     this.rand.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.getSeed());
/* 436 */     boolean flag = false;
/*     */ 
/*     */ 
/*     */     
/* 440 */     if (this.mapFeaturesEnabled) {
/*     */       
/* 442 */       this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
/*     */       
/* 444 */       this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
/* 445 */       this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 452 */     if (biomegenbase != BiomeGenBase.desert && biomegenbase != BiomeGenBase.desertHills && !flag && this.rand.nextInt(4) == 0 && TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.LAKE)) {
/*     */ 
/*     */       
/* 455 */       int i = k + this.rand.nextInt(16) + 8;
/* 456 */       int l1 = this.rand.nextInt(256);
/* 457 */       int i2 = l + this.rand.nextInt(16) + 8;
/* 458 */       (new WorldGenLakes(Blocks.water)).generate(this.worldObj, this.rand, i, l1, i2);
/*     */     } 
/*     */     
/* 461 */     if (TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.LAVA) && !flag && this.rand.nextInt(8) == 0) {
/*     */       
/* 463 */       int i = k + this.rand.nextInt(16) + 8;
/* 464 */       int l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
/* 465 */       int i2 = l + this.rand.nextInt(16) + 8;
/*     */       
/* 467 */       if (l1 < 63 || this.rand.nextInt(10) == 0)
/*     */       {
/* 469 */         (new WorldGenLakes(Blocks.lava)).generate(this.worldObj, this.rand, i, l1, i2);
/*     */       }
/*     */     } 
/*     */     
/* 473 */     boolean doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.DUNGEON); int k1;
/* 474 */     for (k1 = 0; doGen && k1 < 8; k1++) {
/*     */       
/* 476 */       int l1 = k + this.rand.nextInt(16) + 8;
/* 477 */       int i2 = this.rand.nextInt(256);
/* 478 */       int j2 = l + this.rand.nextInt(16) + 8;
/* 479 */       (new WorldGenDungeons()).generate(this.worldObj, this.rand, l1, i2, j2);
/*     */     } 
/*     */     
/* 482 */     biomegenbase.decorate(this.worldObj, this.rand, k, l);
/* 483 */     SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
/* 484 */     k += 8;
/* 485 */     l += 8;
/*     */     
/* 487 */     doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.ICE);
/* 488 */     for (k1 = 0; doGen && k1 < 16; k1++) {
/*     */       
/* 490 */       for (int l1 = 0; l1 < 16; l1++) {
/*     */         
/* 492 */         int i2 = this.worldObj.getPrecipitationHeight(k + k1, l + l1);
/*     */         
/* 494 */         if (this.worldObj.isBlockFreezable(k1 + k, i2 - 1, l1 + l))
/*     */         {
/* 496 */           this.worldObj.setBlock(k1 + k, i2 - 1, l1 + l, Blocks.ice, 0, 2);
/*     */         }
/*     */         
/* 499 */         if (this.worldObj.func_147478_e(k1 + k, i2, l1 + l, true))
/*     */         {
/* 501 */           this.worldObj.setBlock(k1 + k, i2, l1 + l, Blocks.snow_layer, 0, 2);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 508 */     BlockFalling.fallInstantly = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate) {
/* 517 */     return true;
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
/* 531 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSave() {
/* 539 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String makeString() {
/* 547 */     return "VillageDimension";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
/* 558 */     BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(par2, par4);
/* 559 */     List l = null;
/* 560 */     if (var5 != null) {
/* 561 */       l = var5.getSpawnableList(par1EnumCreatureType);
/* 562 */       if (par1EnumCreatureType == EnumCreatureType.monster) {
/* 563 */         if (this.MyMobList == null) {
/* 564 */           this.MyMobList = new ArrayList();
/* 565 */           if (OreSpawnMain.AlosaurusEnable != 0) {
/* 566 */             this.MyMobList.add(new BiomeGenBase.SpawnListEntry(Alosaurus.class, 8, 1, 2));
/*     */           }
/* 568 */           if (OreSpawnMain.TRexEnable != 0) {
/* 569 */             this.MyMobList.add(new BiomeGenBase.SpawnListEntry(TRex.class, 6, 1, 2));
/*     */           }
/* 571 */           if (OreSpawnMain.NastysaurusEnable != 0) {
/* 572 */             this.MyMobList.add(new BiomeGenBase.SpawnListEntry(Nastysaurus.class, 6, 1, 2));
/*     */           }
/* 574 */           if (OreSpawnMain.PointysaurusEnable != 0) {
/* 575 */             this.MyMobList.add(new BiomeGenBase.SpawnListEntry(Pointysaurus.class, 10, 4, 8));
/*     */           }
/* 577 */           if (OreSpawnMain.GammaMetroidEnable != 0) {
/* 578 */             this.MyMobList.add(new BiomeGenBase.SpawnListEntry(GammaMetroid.class, 35, 4, 7));
/*     */           }
/* 580 */           if (OreSpawnMain.AlienEnable != 0) {
/* 581 */             this.MyMobList.add(new BiomeGenBase.SpawnListEntry(Alien.class, 35, 2, 3));
/*     */           }
/* 583 */           if (OreSpawnMain.CaveFisherEnable != 0) {
/* 584 */             this.MyMobList.add(new BiomeGenBase.SpawnListEntry(CaveFisher.class, 35, 4, 8));
/*     */           }
/* 586 */           if (OreSpawnMain.CryolophosaurusEnable != 0) {
/* 587 */             this.MyMobList.add(new BiomeGenBase.SpawnListEntry(Cryolophosaurus.class, 26, 4, 7));
/*     */           }
/* 589 */           if (OreSpawnMain.SpyroEnable != 0) {
/* 590 */             this.MyMobList.add(new BiomeGenBase.SpawnListEntry(Spyro.class, 5, 1, 2));
/*     */           }
/* 592 */           Iterator<BiomeGenBase.SpawnListEntry> var2 = l.iterator();
/* 593 */           while (var2.hasNext()) {
/*     */             
/* 595 */             BiomeGenBase.SpawnListEntry var3 = var2.next();
/* 596 */             this.MyMobList.add(var3);
/*     */           } 
/*     */         } 
/* 599 */         return this.MyMobList;
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 626 */       if (par1EnumCreatureType == EnumCreatureType.ambient) {
/* 627 */         if (this.MyAmbientList == null) {
/* 628 */           this.MyAmbientList = new ArrayList();
/* 629 */           if (OreSpawnMain.VelocityRaptorEnable != 0) {
/* 630 */             this.MyAmbientList.add(new BiomeGenBase.SpawnListEntry(VelocityRaptor.class, 1, 2, 4));
/*     */           }
/* 632 */           if (OreSpawnMain.DragonflyEnable != 0) {
/* 633 */             this.MyAmbientList.add(new BiomeGenBase.SpawnListEntry(Dragonfly.class, 2, 1, 3));
/*     */           }
/* 635 */           if (OreSpawnMain.CamarasaurusEnable != 0) {
/* 636 */             this.MyAmbientList.add(new BiomeGenBase.SpawnListEntry(Camarasaurus.class, 1, 2, 4));
/*     */           }
/* 638 */           if (OreSpawnMain.BaryonyxEnable != 0) {
/* 639 */             this.MyAmbientList.add(new BiomeGenBase.SpawnListEntry(Baryonyx.class, 2, 4, 8));
/*     */           }
/* 641 */           Iterator<BiomeGenBase.SpawnListEntry> var2 = l.iterator();
/* 642 */           while (var2.hasNext()) {
/*     */             
/* 644 */             BiomeGenBase.SpawnListEntry var3 = var2.next();
/* 645 */             this.MyAmbientList.add(var3);
/*     */           } 
/*     */         } 
/* 648 */         return this.MyAmbientList;
/*     */       } 
/*     */     } 
/* 651 */     return l;
/*     */   }
/*     */   
/*     */   public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
/* 655 */     return ("Stronghold".equals(p_147416_2_) && this.strongholdGenerator != null) ? this.strongholdGenerator.func_151545_a(p_147416_1_, p_147416_3_, p_147416_4_, p_147416_5_) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLoadedChunkCount() {
/* 660 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void recreateStructures(int par1, int par2) {
/* 665 */     if (this.mapFeaturesEnabled) {
/*     */       
/* 667 */       this.mineshaftGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[])null);
/*     */       
/* 669 */       this.strongholdGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[])null);
/* 670 */       this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[])null);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ChunkProviderOreSpawn2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */