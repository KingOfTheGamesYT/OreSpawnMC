/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFalling;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.entity.passive.EntityHorse;
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
/*     */ import net.minecraft.world.gen.structure.MapGenMineshaft;
/*     */ import net.minecraft.world.gen.structure.MapGenScatteredFeature;
/*     */ import net.minecraft.world.gen.structure.MapGenStronghold;
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
/*     */ public class ChunkProviderOreSpawn
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
/*  83 */   private double[] stoneNoise = new double[256];
/*  84 */   private MapGenBase caveGenerator = (MapGenBase)new MapGenCaves();
/*  85 */   private ArrayList MyAmbientList = null;
/*  86 */   private ArrayList MyCritterList = null;
/*     */ 
/*     */ 
/*     */   
/*  90 */   private MapGenStronghold strongholdGenerator = new MapGenStronghold();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
/*  99 */   private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
/*     */ 
/*     */ 
/*     */   
/* 103 */   private MapGenBase ravineGenerator = (MapGenBase)new MapGenRavine();
/*     */   
/*     */   private BiomeGenBase[] biomesForGeneration;
/*     */   
/*     */   double[] field_147427_d;
/*     */   
/*     */   double[] field_147428_e;
/*     */   double[] field_147425_f;
/*     */   double[] field_147426_g;
/* 112 */   int[][] field_73219_j = new int[32][32];
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000396";
/*     */ 
/*     */   
/*     */   public ChunkProviderOreSpawn(World par1World, long par2, boolean par4) {
/* 119 */     this.worldObj = par1World;
/* 120 */     this.mapFeaturesEnabled = par4;
/* 121 */     this.field_147435_p = par1World.getWorldInfo().getTerrainType();
/* 122 */     this.rand = new Random(par2);
/* 123 */     this.field_147431_j = new NoiseGeneratorOctaves(this.rand, 16);
/* 124 */     this.field_147432_k = new NoiseGeneratorOctaves(this.rand, 16);
/* 125 */     this.field_147429_l = new NoiseGeneratorOctaves(this.rand, 8);
/* 126 */     this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
/* 127 */     this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
/* 128 */     this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
/* 129 */     this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
/* 130 */     this.field_147434_q = new double[825];
/* 131 */     this.parabolicField = new float[25];
/*     */     
/* 133 */     for (int j = -2; j <= 2; j++) {
/*     */       
/* 135 */       for (int k = -2; k <= 2; k++) {
/*     */         
/* 137 */         float f = 10.0F / MathHelper.sqrt_float((j * j + k * k) + 0.2F);
/* 138 */         this.parabolicField[j + 2 + (k + 2) * 5] = f;
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     NoiseGenerator[] noiseGens = { (NoiseGenerator)this.field_147431_j, (NoiseGenerator)this.field_147432_k, (NoiseGenerator)this.field_147429_l, (NoiseGenerator)this.field_147430_m, (NoiseGenerator)this.noiseGen5, (NoiseGenerator)this.noiseGen6, (NoiseGenerator)this.mobSpawnerNoise };
/* 143 */     noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.rand, noiseGens);
/* 144 */     this.field_147431_j = (NoiseGeneratorOctaves)noiseGens[0];
/* 145 */     this.field_147432_k = (NoiseGeneratorOctaves)noiseGens[1];
/* 146 */     this.field_147429_l = (NoiseGeneratorOctaves)noiseGens[2];
/* 147 */     this.field_147430_m = (NoiseGeneratorPerlin)noiseGens[3];
/* 148 */     this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
/* 149 */     this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
/* 150 */     this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147424_a(int p_147424_1_, int p_147424_2_, Block[] p_147424_3_) {
/* 155 */     byte b0 = 63;
/* 156 */     this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, p_147424_1_ * 4 - 2, p_147424_2_ * 4 - 2, 10, 10);
/* 157 */     func_147423_a(p_147424_1_ * 4, 0, p_147424_2_ * 4);
/*     */     
/* 159 */     for (int k = 0; k < 4; k++) {
/*     */       
/* 161 */       int l = k * 5;
/* 162 */       int i1 = (k + 1) * 5;
/*     */       
/* 164 */       for (int j1 = 0; j1 < 4; j1++) {
/*     */         
/* 166 */         int k1 = (l + j1) * 33;
/* 167 */         int l1 = (l + j1 + 1) * 33;
/* 168 */         int i2 = (i1 + j1) * 33;
/* 169 */         int j2 = (i1 + j1 + 1) * 33;
/*     */         
/* 171 */         for (int k2 = 0; k2 < 32; k2++) {
/*     */           
/* 173 */           double d0 = 0.125D;
/* 174 */           double d1 = this.field_147434_q[k1 + k2];
/* 175 */           double d2 = this.field_147434_q[l1 + k2];
/* 176 */           double d3 = this.field_147434_q[i2 + k2];
/* 177 */           double d4 = this.field_147434_q[j2 + k2];
/* 178 */           double d5 = (this.field_147434_q[k1 + k2 + 1] - d1) * d0;
/* 179 */           double d6 = (this.field_147434_q[l1 + k2 + 1] - d2) * d0;
/* 180 */           double d7 = (this.field_147434_q[i2 + k2 + 1] - d3) * d0;
/* 181 */           double d8 = (this.field_147434_q[j2 + k2 + 1] - d4) * d0;
/*     */           
/* 183 */           for (int l2 = 0; l2 < 8; l2++) {
/*     */             
/* 185 */             double d9 = 0.25D;
/* 186 */             double d10 = d1;
/* 187 */             double d11 = d2;
/* 188 */             double d12 = (d3 - d1) * d9;
/* 189 */             double d13 = (d4 - d2) * d9;
/*     */             
/* 191 */             for (int i3 = 0; i3 < 4; i3++) {
/*     */               
/* 193 */               int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
/* 194 */               short short1 = 256;
/* 195 */               j3 -= short1;
/* 196 */               double d14 = 0.25D;
/* 197 */               double d16 = (d11 - d10) * d14;
/* 198 */               double d15 = d10 - d16;
/*     */               
/* 200 */               for (int k3 = 0; k3 < 4; k3++) {
/*     */                 
/* 202 */                 if ((d15 += d16) > 0.0D) {
/*     */                   
/* 204 */                   p_147424_3_[j3 += short1] = Blocks.stone;
/*     */                 }
/* 206 */                 else if (k2 * 8 + l2 < b0) {
/*     */                   
/* 208 */                   p_147424_3_[j3 += short1] = Blocks.water;
/*     */                 }
/*     */                 else {
/*     */                   
/* 212 */                   p_147424_3_[j3 += short1] = null;
/*     */                 } 
/*     */               } 
/*     */               
/* 216 */               d10 += d12;
/* 217 */               d11 += d13;
/*     */             } 
/*     */             
/* 220 */             d1 += d5;
/* 221 */             d2 += d6;
/* 222 */             d3 += d7;
/* 223 */             d4 += d8;
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
/* 236 */     double d0 = 0.03125D;
/* 237 */     this.stoneNoise = this.field_147430_m.getRegion(this.stoneNoise, (p_147422_1_ * 16), (p_147422_2_ * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
/*     */     
/* 239 */     for (int k = 0; k < 16; k++) {
/*     */       
/* 241 */       for (int l = 0; l < 16; l++) {
/*     */         
/* 243 */         BiomeGenBase biomegenbase = p_147422_5_[l + k * 16];
/* 244 */         biomegenbase.genTerrainBlocks(this.worldObj, this.rand, p_147422_3_, p_147422_4_, p_147422_1_ * 16 + k, p_147422_2_ * 16 + l, this.stoneNoise[l + k * 16]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk loadChunk(int par1, int par2) {
/* 254 */     return provideChunk(par1, par2);
/*     */   }
/*     */ 
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
/*     */     
/* 271 */     this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/* 272 */     this.ravineGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 282 */     Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
/*     */     
/* 284 */     OreSpawnMain.Chunker.generateOresInChunk(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 289 */     chunk.generateSkylightMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 295 */     return chunk;
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_147423_a(int p_147423_1_, int p_147423_2_, int p_147423_3_) {
/* 300 */     double d0 = 684.412D;
/* 301 */     double d1 = 684.412D;
/* 302 */     double d2 = 512.0D;
/* 303 */     double d3 = 512.0D;
/* 304 */     this.field_147426_g = this.noiseGen6.generateNoiseOctaves(this.field_147426_g, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D);
/* 305 */     this.field_147427_d = this.field_147429_l.generateNoiseOctaves(this.field_147427_d, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
/* 306 */     this.field_147428_e = this.field_147431_j.generateNoiseOctaves(this.field_147428_e, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 307 */     this.field_147425_f = this.field_147432_k.generateNoiseOctaves(this.field_147425_f, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 308 */     boolean flag1 = false;
/* 309 */     boolean flag = false;
/* 310 */     int l = 0;
/* 311 */     int i1 = 0;
/* 312 */     double d4 = 8.5D;
/*     */     
/* 314 */     for (int j1 = 0; j1 < 5; j1++) {
/*     */       
/* 316 */       for (int k1 = 0; k1 < 5; k1++) {
/*     */         
/* 318 */         float f = 0.0F;
/* 319 */         float f1 = 0.0F;
/* 320 */         float f2 = 0.0F;
/* 321 */         byte b0 = 2;
/* 322 */         BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
/*     */         
/* 324 */         for (int l1 = -b0; l1 <= b0; l1++) {
/*     */           
/* 326 */           for (int i2 = -b0; i2 <= b0; i2++) {
/*     */             
/* 328 */             BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
/* 329 */             float f3 = biomegenbase1.rootHeight;
/* 330 */             float f4 = biomegenbase1.heightVariation;
/*     */             
/* 332 */             if (this.field_147435_p == WorldType.AMPLIFIED && f3 > 0.0F) {
/*     */               
/* 334 */               f3 = 1.0F + f3 * 2.0F;
/* 335 */               f4 = 1.0F + f4 * 4.0F;
/*     */             } 
/*     */             
/* 338 */             float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);
/*     */             
/* 340 */             if (biomegenbase1.rootHeight > biomegenbase.rootHeight)
/*     */             {
/* 342 */               f5 /= 2.0F;
/*     */             }
/*     */             
/* 345 */             f += f4 * f5;
/* 346 */             f1 += f3 * f5;
/* 347 */             f2 += f5;
/*     */           } 
/*     */         } 
/*     */         
/* 351 */         f /= f2;
/* 352 */         f1 /= f2;
/* 353 */         f = f * 0.9F + 0.1F;
/* 354 */         f1 = (f1 * 4.0F - 1.0F) / 8.0F;
/* 355 */         double d13 = this.field_147426_g[i1] / 8000.0D;
/*     */         
/* 357 */         if (d13 < 0.0D)
/*     */         {
/* 359 */           d13 = -d13 * 0.3D;
/*     */         }
/*     */         
/* 362 */         d13 = d13 * 3.0D - 2.0D;
/*     */         
/* 364 */         if (d13 < 0.0D) {
/*     */           
/* 366 */           d13 /= 2.0D;
/*     */           
/* 368 */           if (d13 < -1.0D)
/*     */           {
/* 370 */             d13 = -1.0D;
/*     */           }
/*     */           
/* 373 */           d13 /= 1.4D;
/* 374 */           d13 /= 2.0D;
/*     */         }
/*     */         else {
/*     */           
/* 378 */           if (d13 > 1.0D)
/*     */           {
/* 380 */             d13 = 1.0D;
/*     */           }
/*     */           
/* 383 */           d13 /= 8.0D;
/*     */         } 
/*     */         
/* 386 */         i1++;
/* 387 */         double d12 = f1;
/* 388 */         double d14 = f;
/* 389 */         d12 += d13 * 0.2D;
/* 390 */         d12 = d12 * 8.5D / 8.0D;
/* 391 */         double d5 = 8.5D + d12 * 4.0D;
/*     */         
/* 393 */         for (int j2 = 0; j2 < 33; j2++) {
/*     */           
/* 395 */           double d6 = (j2 - d5) * 12.0D * 128.0D / 256.0D / d14;
/*     */           
/* 397 */           if (d6 < 0.0D)
/*     */           {
/* 399 */             d6 *= 4.0D;
/*     */           }
/*     */           
/* 402 */           double d7 = this.field_147428_e[l] / 512.0D;
/* 403 */           double d8 = this.field_147425_f[l] / 512.0D;
/* 404 */           double d9 = (this.field_147427_d[l] / 10.0D + 1.0D) / 2.0D;
/* 405 */           double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;
/*     */           
/* 407 */           if (j2 > 29) {
/*     */             
/* 409 */             double d11 = ((j2 - 29) / 3.0F);
/* 410 */             d10 = d10 * (1.0D - d11) + -10.0D * d11;
/*     */           } 
/*     */           
/* 413 */           this.field_147434_q[l] = d10;
/* 414 */           l++;
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
/* 425 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
/* 434 */     BlockFalling.fallInstantly = false;
/* 435 */     int k = par2 * 16;
/* 436 */     int l = par3 * 16;
/* 437 */     BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
/* 438 */     this.rand.setSeed(this.worldObj.getSeed());
/* 439 */     long i1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 440 */     long j1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 441 */     this.rand.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.getSeed());
/* 442 */     boolean flag = false;
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
/* 490 */     biomegenbase.decorate(this.worldObj, this.rand, k, l);
/*     */ 
/*     */     
/* 493 */     SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
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
/* 532 */     BlockFalling.fallInstantly = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate) {
/* 543 */     return true;
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
/* 557 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSave() {
/* 565 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String makeString() {
/* 573 */     return "UtopiaDimension";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
/* 581 */     List<BiomeGenBase.SpawnListEntry> l = null;
/* 582 */     List<BiomeGenBase.SpawnListEntry> m = null;
/* 583 */     Iterator<BiomeGenBase.SpawnListEntry> var2 = null;
/* 584 */     BiomeGenBase.SpawnListEntry var3 = null;
/* 585 */     BiomeGenBase var5 = null;
/*     */     
/* 587 */     var5 = this.worldObj.getBiomeGenForCoords(par2, par4);
/*     */     
/* 589 */     if (var5 == null) return null;
/*     */     
/* 591 */     l = var5.getSpawnableList(par1EnumCreatureType);
/* 592 */     if (l == null) return null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 598 */     if (par1EnumCreatureType == EnumCreatureType.monster) return null;
/*     */ 
/*     */     
/* 601 */     if (par1EnumCreatureType == EnumCreatureType.ambient) {
/* 602 */       if (this.MyAmbientList == null) {
/*     */         
/* 604 */         this.MyAmbientList = new ArrayList();
/*     */         
/* 606 */         var2 = l.iterator();
/* 607 */         if (var2 == null) return null;
/*     */         
/* 609 */         while (var2.hasNext()) {
/*     */           
/* 611 */           var3 = var2.next();
/* 612 */           if (var3.entityClass == EntityHorse.class) {
/*     */             continue;
/*     */           }
/*     */           
/* 616 */           this.MyAmbientList.add(var3);
/*     */         } 
/*     */       } 
/* 619 */       return this.MyAmbientList;
/*     */     } 
/*     */ 
/*     */     
/* 623 */     var2 = l.iterator();
/* 624 */     if (var2 == null) return null;
/*     */     
/* 626 */     m = new ArrayList();
/* 627 */     var3 = null;
/* 628 */     while (var2.hasNext()) {
/*     */       
/* 630 */       var3 = var2.next();
/* 631 */       if (var3 != null && var3.entityClass != EntityHorse.class) {
/* 632 */         m.add(var3);
/*     */       }
/*     */     } 
/* 635 */     return m;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
/* 640 */     return ("Stronghold".equals(p_147416_2_) && this.strongholdGenerator != null) ? this.strongholdGenerator.func_151545_a(p_147416_1_, p_147416_3_, p_147416_4_, p_147416_5_) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLoadedChunkCount() {
/* 645 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void recreateStructures(int par1, int par2) {
/* 650 */     if (this.mapFeaturesEnabled) {
/*     */       
/* 652 */       this.mineshaftGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[])null);
/*     */       
/* 654 */       this.strongholdGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[])null);
/* 655 */       this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[])null);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ChunkProviderOreSpawn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */