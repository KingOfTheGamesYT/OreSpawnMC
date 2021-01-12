/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFalling;
/*     */ import net.minecraft.block.BlockGrass;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.IProgressUpdate;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ import net.minecraft.world.SpawnerAnimals;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.gen.NoiseGenerator;
/*     */ import net.minecraft.world.gen.NoiseGeneratorOctaves;
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
/*     */ public class ChunkProviderOreSpawn6
/*     */   implements IChunkProvider
/*     */ {
/*     */   private Random hellRNG;
/*     */   private Random random;
/*     */   private NoiseGeneratorOctaves netherNoiseGen1;
/*     */   private NoiseGeneratorOctaves netherNoiseGen2;
/*     */   private NoiseGeneratorOctaves netherNoiseGen3;
/*     */   private NoiseGeneratorOctaves slowsandGravelNoiseGen;
/*     */   private NoiseGeneratorOctaves netherrackExculsivityNoiseGen;
/*     */   public NoiseGeneratorOctaves netherNoiseGen6;
/*     */   public NoiseGeneratorOctaves netherNoiseGen7;
/*     */   private World worldObj;
/*     */   private double[] noiseField;
/*  54 */   private double[] slowsandNoise = new double[256];
/*  55 */   private double[] gravelNoise = new double[256];
/*     */   
/*  57 */   private double[] netherrackExclusivityNoise = new double[256];
/*     */   
/*     */   double[] noiseData1;
/*     */   
/*     */   double[] noiseData2;
/*     */   
/*     */   double[] noiseData3;
/*     */   
/*     */   double[] noiseData4;
/*     */   double[] noiseData5;
/*     */   private static final String __OBFID = "CL_00000392";
/*     */   
/*     */   public ChunkProviderOreSpawn6(World p_i2005_1_, long p_i2005_2_) {
/*  70 */     this.worldObj = p_i2005_1_;
/*  71 */     this.hellRNG = new Random(p_i2005_2_);
/*  72 */     this.random = new Random(p_i2005_2_);
/*  73 */     this.netherNoiseGen1 = new NoiseGeneratorOctaves(this.hellRNG, 16);
/*  74 */     this.netherNoiseGen2 = new NoiseGeneratorOctaves(this.hellRNG, 16);
/*  75 */     this.netherNoiseGen3 = new NoiseGeneratorOctaves(this.hellRNG, 8);
/*  76 */     this.slowsandGravelNoiseGen = new NoiseGeneratorOctaves(this.hellRNG, 4);
/*  77 */     this.netherrackExculsivityNoiseGen = new NoiseGeneratorOctaves(this.hellRNG, 4);
/*  78 */     this.netherNoiseGen6 = new NoiseGeneratorOctaves(this.hellRNG, 10);
/*  79 */     this.netherNoiseGen7 = new NoiseGeneratorOctaves(this.hellRNG, 16);
/*     */     
/*  81 */     NoiseGenerator[] noiseGens = { (NoiseGenerator)this.netherNoiseGen1, (NoiseGenerator)this.netherNoiseGen2, (NoiseGenerator)this.netherNoiseGen3, (NoiseGenerator)this.slowsandGravelNoiseGen, (NoiseGenerator)this.netherrackExculsivityNoiseGen, (NoiseGenerator)this.netherNoiseGen6, (NoiseGenerator)this.netherNoiseGen7 };
/*  82 */     noiseGens = TerrainGen.getModdedNoiseGenerators(p_i2005_1_, this.hellRNG, noiseGens);
/*  83 */     this.netherNoiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
/*  84 */     this.netherNoiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
/*  85 */     this.netherNoiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
/*  86 */     this.slowsandGravelNoiseGen = (NoiseGeneratorOctaves)noiseGens[3];
/*  87 */     this.netherrackExculsivityNoiseGen = (NoiseGeneratorOctaves)noiseGens[4];
/*  88 */     this.netherNoiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
/*  89 */     this.netherNoiseGen7 = (NoiseGeneratorOctaves)noiseGens[6];
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147419_a(int p_147419_1_, int p_147419_2_, Block[] p_147419_3_) {
/*  94 */     byte b0 = 4;
/*  95 */     byte b1 = 32;
/*  96 */     int k = b0 + 1;
/*  97 */     byte b2 = 17;
/*  98 */     int l = b0 + 1;
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
/* 119 */     Block block = Blocks.stone;
/*     */     
/* 121 */     this.noiseField = initializeNoiseField(this.noiseField, p_147419_1_ * b0, 0, p_147419_2_ * b0, k, b2, l);
/*     */     
/* 123 */     for (int i1 = 0; i1 < b0; i1++) {
/*     */       
/* 125 */       for (int j1 = 0; j1 < b0; j1++) {
/*     */         
/* 127 */         for (int k1 = 0; k1 < 16; k1++) {
/*     */           
/* 129 */           double d0 = 0.125D;
/* 130 */           double d1 = this.noiseField[((i1 + 0) * l + j1 + 0) * b2 + k1 + 0];
/* 131 */           double d2 = this.noiseField[((i1 + 0) * l + j1 + 1) * b2 + k1 + 0];
/* 132 */           double d3 = this.noiseField[((i1 + 1) * l + j1 + 0) * b2 + k1 + 0];
/* 133 */           double d4 = this.noiseField[((i1 + 1) * l + j1 + 1) * b2 + k1 + 0];
/* 134 */           double d5 = (this.noiseField[((i1 + 0) * l + j1 + 0) * b2 + k1 + 1] - d1) * d0;
/* 135 */           double d6 = (this.noiseField[((i1 + 0) * l + j1 + 1) * b2 + k1 + 1] - d2) * d0;
/* 136 */           double d7 = (this.noiseField[((i1 + 1) * l + j1 + 0) * b2 + k1 + 1] - d3) * d0;
/* 137 */           double d8 = (this.noiseField[((i1 + 1) * l + j1 + 1) * b2 + k1 + 1] - d4) * d0;
/*     */           
/* 139 */           for (int l1 = 0; l1 < 8; l1++) {
/*     */             
/* 141 */             double d9 = 0.25D;
/* 142 */             double d10 = d1;
/* 143 */             double d11 = d2;
/* 144 */             double d12 = (d3 - d1) * d9;
/* 145 */             double d13 = (d4 - d2) * d9;
/*     */             
/* 147 */             for (int i2 = 0; i2 < 4; i2++) {
/*     */               
/* 149 */               int j2 = i2 + i1 * 4 << 11 | 0 + j1 * 4 << 7 | k1 * 8 + l1;
/* 150 */               short short1 = 128;
/* 151 */               double d14 = 0.25D;
/* 152 */               double d15 = d10;
/* 153 */               double d16 = (d11 - d10) * d14;
/*     */               
/* 155 */               for (int k2 = 0; k2 < 4; k2++) {
/*     */                 
/* 157 */                 block = Blocks.stone;
/*     */ 
/*     */                 
/* 160 */                 if (d15 > 0.0D)
/*     */                 {
/* 162 */                   block = null;
/*     */                 }
/*     */                 
/* 165 */                 p_147419_3_[j2] = block;
/* 166 */                 j2 += short1;
/* 167 */                 d15 += d16;
/*     */               } 
/*     */               
/* 170 */               d10 += d12;
/* 171 */               d11 += d13;
/*     */             } 
/*     */             
/* 174 */             d1 += d5;
/* 175 */             d2 += d6;
/* 176 */             d3 += d7;
/* 177 */             d4 += d8;
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
/*     */   public void replaceBiomeBlocks(int p_147418_1_, int p_147418_2_, Block[] p_147418_3_, byte[] meta, BiomeGenBase[] biomes) {
/* 189 */     byte b0 = 64;
/* 190 */     double d0 = 0.03125D;
/* 191 */     this.slowsandNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.slowsandNoise, p_147418_1_ * 16, p_147418_2_ * 16, 0, 16, 16, 1, d0, d0, 1.0D);
/* 192 */     this.gravelNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.gravelNoise, p_147418_1_ * 16, 109, p_147418_2_ * 16, 16, 1, 16, d0, 1.0D, d0);
/* 193 */     this.netherrackExclusivityNoise = this.netherrackExculsivityNoiseGen.generateNoiseOctaves(this.netherrackExclusivityNoise, p_147418_1_ * 16, p_147418_2_ * 16, 0, 16, 16, 1, d0 * 2.0D, d0 * 2.0D, d0 * 2.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 202 */     for (int k = 0; k < 16; k++) {
/*     */       
/* 204 */       for (int l = 0; l < 16; l++) {
/*     */         
/* 206 */         boolean flag = (this.slowsandNoise[k + l * 16] + this.hellRNG.nextDouble() * 0.2D > 0.0D);
/* 207 */         boolean flag1 = (this.gravelNoise[k + l * 16] + this.hellRNG.nextDouble() * 0.2D > 0.0D);
/* 208 */         int i1 = (int)(this.netherrackExclusivityNoise[k + l * 16] / 3.0D + 3.0D + this.hellRNG.nextDouble() * 0.25D);
/* 209 */         int j1 = -1;
/* 210 */         BlockGrass blockGrass = Blocks.grass;
/* 211 */         Block block1 = Blocks.dirt;
/*     */         
/* 213 */         for (int k1 = 127; k1 >= 0; k1--) {
/*     */           
/* 215 */           int l1 = (l * 16 + k) * 128 + k1;
/*     */           
/* 217 */           if (k1 < 127 - this.hellRNG.nextInt(5) && k1 > 0 + this.hellRNG.nextInt(5)) {
/*     */             
/* 219 */             Block block2 = p_147418_3_[l1];
/*     */             
/* 221 */             if (block2 != null && block2.getMaterial() != Material.air) {
/*     */               
/* 223 */               if (block2 == Blocks.stone)
/*     */               {
/* 225 */                 if (j1 == -1) {
/*     */                   BlockGrass blockGrass1; Block block;
/* 227 */                   if (i1 <= 0) {
/*     */                     
/* 229 */                     blockGrass = null;
/* 230 */                     block1 = Blocks.stone;
/*     */                   }
/* 232 */                   else if (k1 >= b0 - 4 && k1 <= b0 + 1) {
/*     */                     
/* 234 */                     block = Blocks.stone;
/* 235 */                     block1 = Blocks.stone;
/*     */                     
/* 237 */                     if (flag1) {
/*     */                       
/* 239 */                       blockGrass1 = Blocks.grass;
/* 240 */                       block1 = Blocks.dirt;
/*     */                     } 
/*     */                     
/* 243 */                     if (flag) {
/*     */                       
/* 245 */                       blockGrass1 = Blocks.grass;
/* 246 */                       block1 = Blocks.dirt;
/*     */                     } 
/*     */                   } 
/*     */                   
/* 250 */                   if (k1 < b0 && blockGrass1 == Blocks.air)
/*     */                   {
/* 252 */                     block = Blocks.water;
/*     */                   }
/*     */                   
/* 255 */                   j1 = i1;
/*     */                   
/* 257 */                   if (k1 >= b0 - 1)
/*     */                   {
/* 259 */                     p_147418_3_[l1] = block;
/*     */                   }
/*     */                   else
/*     */                   {
/* 263 */                     p_147418_3_[l1] = block1;
/*     */                   }
/*     */                 
/* 266 */                 } else if (j1 > 0) {
/*     */                   
/* 268 */                   j1--;
/* 269 */                   p_147418_3_[l1] = block1;
/*     */                 }
/*     */               
/*     */               }
/*     */             } else {
/*     */               
/* 275 */               j1 = -1;
/*     */             }
/*     */           
/*     */           } else {
/*     */             
/* 280 */             p_147418_3_[l1] = null;
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
/*     */   public Chunk loadChunk(int p_73158_1_, int p_73158_2_) {
/* 292 */     return provideChunk(p_73158_1_, p_73158_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk provideChunk(int p_73154_1_, int p_73154_2_) {
/* 301 */     this.hellRNG.setSeed(p_73154_1_ * 341873128712L + p_73154_2_ * 132897987541L);
/* 302 */     Block[] ablock = new Block[32768];
/* 303 */     byte[] meta = new byte[ablock.length];
/*     */     
/* 305 */     func_147419_a(p_73154_1_, p_73154_2_, ablock);
/* 306 */     replaceBiomeBlocks(p_73154_1_, p_73154_2_, ablock, meta, null);
/*     */     
/* 308 */     Chunk chunk = new Chunk(this.worldObj, ablock, meta, p_73154_1_, p_73154_2_);
/*     */     
/* 310 */     OreSpawnMain.Chunker.generateOresInChunk(this.worldObj, this.worldObj.rand, p_73154_1_ * 16, p_73154_2_ * 16, chunk);
/* 311 */     addScragglyTrees(this.worldObj, p_73154_1_ * 16, p_73154_2_ * 16, chunk);
/*     */     
/* 313 */     chunk.generateSkylightMap();
/* 314 */     return chunk;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double[] initializeNoiseField(double[] p_73164_1_, int p_73164_2_, int p_73164_3_, int p_73164_4_, int p_73164_5_, int p_73164_6_, int p_73164_7_) {
/* 325 */     int k1 = 0;
/* 326 */     int l1 = 0;
/* 327 */     double[] adouble1 = new double[p_73164_6_];
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
/* 341 */     if (p_73164_1_ == null)
/*     */     {
/* 343 */       p_73164_1_ = new double[p_73164_5_ * p_73164_6_ * p_73164_7_];
/*     */     }
/*     */     
/* 346 */     double d0 = 684.412D;
/* 347 */     double d1 = 2053.236D;
/* 348 */     this.noiseData4 = this.netherNoiseGen6.generateNoiseOctaves(this.noiseData4, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, 1, p_73164_7_, 1.0D, 0.0D, 1.0D);
/* 349 */     this.noiseData5 = this.netherNoiseGen7.generateNoiseOctaves(this.noiseData5, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, 1, p_73164_7_, 100.0D, 0.0D, 100.0D);
/* 350 */     this.noiseData1 = this.netherNoiseGen3.generateNoiseOctaves(this.noiseData1, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d0 / 80.0D, d1 / 60.0D, d0 / 80.0D);
/* 351 */     this.noiseData2 = this.netherNoiseGen1.generateNoiseOctaves(this.noiseData2, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d0, d1, d0);
/* 352 */     this.noiseData3 = this.netherNoiseGen2.generateNoiseOctaves(this.noiseData3, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d0, d1, d0);
/*     */     
/*     */     int i2;
/* 355 */     for (i2 = 0; i2 < p_73164_6_; i2++) {
/*     */       
/* 357 */       adouble1[i2] = Math.cos(i2 * Math.PI * 6.0D / p_73164_6_) * 2.0D;
/* 358 */       double d2 = i2;
/*     */       
/* 360 */       if (i2 > p_73164_6_ / 2)
/*     */       {
/* 362 */         d2 = (p_73164_6_ - 1 - i2);
/*     */       }
/*     */       
/* 365 */       if (d2 < 4.0D) {
/*     */         
/* 367 */         d2 = 4.0D - d2;
/* 368 */         adouble1[i2] = adouble1[i2] - d2 * d2 * d2 * 10.0D;
/*     */       } 
/*     */     } 
/*     */     
/* 372 */     for (i2 = 0; i2 < p_73164_5_; i2++) {
/*     */       
/* 374 */       for (int k2 = 0; k2 < p_73164_7_; k2++) {
/*     */         
/* 376 */         double d3 = (this.noiseData4[l1] + 256.0D) / 512.0D;
/*     */         
/* 378 */         if (d3 > 1.0D)
/*     */         {
/* 380 */           d3 = 1.0D;
/*     */         }
/*     */         
/* 383 */         double d4 = 0.0D;
/* 384 */         double d5 = this.noiseData5[l1] / 8000.0D;
/*     */         
/* 386 */         if (d5 < 0.0D)
/*     */         {
/* 388 */           d5 = -d5;
/*     */         }
/*     */         
/* 391 */         d5 = d5 * 3.0D - 3.0D;
/*     */         
/* 393 */         if (d5 < 0.0D) {
/*     */           
/* 395 */           d5 /= 2.0D;
/*     */           
/* 397 */           if (d5 < -1.0D)
/*     */           {
/* 399 */             d5 = -1.0D;
/*     */           }
/*     */           
/* 402 */           d5 /= 1.4D;
/* 403 */           d5 /= 2.0D;
/* 404 */           d3 = 0.0D;
/*     */         }
/*     */         else {
/*     */           
/* 408 */           if (d5 > 1.0D)
/*     */           {
/* 410 */             d5 = 1.0D;
/*     */           }
/*     */           
/* 413 */           d5 /= 6.0D;
/*     */         } 
/*     */         
/* 416 */         d3 += 0.5D;
/* 417 */         d5 = d5 * p_73164_6_ / 16.0D;
/* 418 */         l1++;
/*     */         
/* 420 */         for (int j2 = 0; j2 < p_73164_6_; j2++) {
/*     */           
/* 422 */           double d6 = 0.0D;
/* 423 */           double d7 = adouble1[j2];
/* 424 */           double d8 = this.noiseData2[k1] / 512.0D;
/* 425 */           double d9 = this.noiseData3[k1] / 512.0D;
/* 426 */           double d10 = (this.noiseData1[k1] / 10.0D + 1.0D) / 2.0D;
/*     */           
/* 428 */           if (d10 < 0.0D) {
/*     */             
/* 430 */             d6 = d8;
/*     */           }
/* 432 */           else if (d10 > 1.0D) {
/*     */             
/* 434 */             d6 = d9;
/*     */           }
/*     */           else {
/*     */             
/* 438 */             d6 = d8 + (d9 - d8) * d10;
/*     */           } 
/*     */           
/* 441 */           d6 -= d7;
/*     */ 
/*     */           
/* 444 */           if (j2 > p_73164_6_ - 4) {
/*     */             
/* 446 */             double d11 = ((j2 - p_73164_6_ - 4) / 3.0F);
/* 447 */             d6 = d6 * (1.0D - d11) + -10.0D * d11;
/*     */           } 
/*     */           
/* 450 */           if (j2 < d4) {
/*     */             
/* 452 */             double d11 = (d4 - j2) / 4.0D;
/*     */             
/* 454 */             if (d11 < 0.0D)
/*     */             {
/* 456 */               d11 = 0.0D;
/*     */             }
/*     */             
/* 459 */             if (d11 > 1.0D)
/*     */             {
/* 461 */               d11 = 1.0D;
/*     */             }
/*     */             
/* 464 */             d6 = d6 * (1.0D - d11) + -10.0D * d11;
/*     */           } 
/*     */           
/* 467 */           p_73164_1_[k1] = d6;
/* 468 */           k1++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 473 */     return p_73164_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean chunkExists(int p_73149_1_, int p_73149_2_) {
/* 481 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void populate(IChunkProvider p_73153_1_, int par2, int par3) {
/* 489 */     BlockFalling.fallInstantly = false;
/*     */ 
/*     */     
/* 492 */     int var4 = par2 * 16;
/* 493 */     int var5 = par3 * 16;
/* 494 */     BiomeGenBase var6 = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
/*     */     
/* 496 */     var6.decorate(this.worldObj, this.worldObj.rand, var4, var5);
/*     */     
/* 498 */     SpawnerAnimals.performWorldGenSpawning(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.worldObj.rand);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
/* 509 */     return true;
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
/* 523 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSave() {
/* 531 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String makeString() {
/* 539 */     return "ChaosDimension";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List getPossibleCreatures(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
/* 547 */     BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(p_73155_2_, p_73155_4_);
/* 548 */     return biomegenbase.getSpawnableList(p_73155_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
/* 553 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLoadedChunkCount() {
/* 558 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void recreateStructures(int p_82695_1_, int p_82695_2_) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addScragglyTrees(World world, int chunkX, int chunkZ, Chunk chunk) {
/* 570 */     int howmany = 1 + world.rand.nextInt(5);
/* 571 */     if (world.rand.nextInt(4) != 0) {
/*     */       return;
/*     */     }
/*     */     
/* 575 */     if (OreSpawnMain.LessLag == 1) {
/* 576 */       howmany /= 2;
/*     */     }
/* 578 */     if (OreSpawnMain.LessLag == 2) {
/* 579 */       howmany /= 4;
/*     */     }
/* 581 */     if (howmany == 0)
/*     */       return; 
/* 583 */     for (int i = 0; i < howmany; i++) {
/* 584 */       int posX = 2 + chunkX + this.random.nextInt(12);
/* 585 */       int posZ = 2 + chunkZ + this.random.nextInt(12);
/* 586 */       for (int posY = 120; posY > 50; posY--) {
/*     */         
/* 588 */         if (OreSpawnMain.getBlockIDInChunk(chunk, posX, posY - 1, posZ) == Blocks.grass) {
/*     */           
/* 590 */           ScragglyTreeWithBranches(world, posX, posY, posZ, chunk);
/*     */           break;
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
/*     */   public void makeScragglyBranch(World world, int x, int y, int z, int len, int biasx, int biasz, Chunk chunk) {
/* 603 */     for (int k = 0; k < len; k++) {
/* 604 */       int ix = this.random.nextInt(2) - this.random.nextInt(2) + biasx;
/* 605 */       int iz = this.random.nextInt(2) - this.random.nextInt(2) + biasz;
/* 606 */       if (ix > 1) ix = 1; 
/* 607 */       if (ix < -1) ix = -1; 
/* 608 */       if (iz > 1) iz = 1; 
/* 609 */       if (iz < -1) iz = -1; 
/* 610 */       int iy = (this.random.nextInt(3) > 0) ? 1 : 0;
/* 611 */       x += ix;
/* 612 */       z += iz;
/* 613 */       y += iy;
/* 614 */       Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y, z);
/* 615 */       if (bid != Blocks.air && bid != Blocks.log && bid != OreSpawnMain.MyAppleLeaves) {
/*     */         return;
/*     */       }
/* 618 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y, z, Blocks.log, 0);
/*     */       
/* 620 */       for (int m = -1; m < 2; m++) {
/* 621 */         for (int n = -1; n < 2; n++) {
/* 622 */           if (this.random.nextInt(2) == 1) {
/* 623 */             bid = OreSpawnMain.getBlockIDInChunk(chunk, x + m, y, z + n);
/* 624 */             if (bid == Blocks.air) {
/* 625 */               OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, OreSpawnMain.MyAppleLeaves, 0);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 630 */       if (this.random.nextInt(2) == 1) {
/* 631 */         bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y + 1, z);
/* 632 */         if (bid == Blocks.air) {
/* 633 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y + 1, z, OreSpawnMain.MyAppleLeaves, 0);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ScragglyTreeWithBranches(World world, int x, int y, int z, Chunk chunk) {
/* 649 */     int i = 1 + this.random.nextInt(3);
/* 650 */     int j = i + this.random.nextInt(12);
/*     */     int k;
/* 652 */     for (k = 0; k < i; k++) {
/* 653 */       Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y + k, z);
/* 654 */       if (k >= 1 && bid != Blocks.air && bid != Blocks.log && bid != OreSpawnMain.MyAppleLeaves) {
/*     */         return;
/*     */       }
/* 657 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y + k, z, Blocks.log, 0);
/*     */     } 
/* 659 */     y += i - 1;
/*     */     
/* 661 */     for (k = i; k < j; k++) {
/* 662 */       int ix = this.random.nextInt(2) - this.random.nextInt(2);
/* 663 */       int iz = this.random.nextInt(2) - this.random.nextInt(2);
/* 664 */       int iy = (this.random.nextInt(4) > 0) ? 1 : 0;
/* 665 */       x += ix;
/* 666 */       z += iz;
/* 667 */       y += iy;
/* 668 */       Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y, z);
/* 669 */       if (bid != Blocks.air && bid != Blocks.log && bid != OreSpawnMain.MyAppleLeaves) {
/*     */         break;
/*     */       }
/* 672 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y, z, Blocks.log, 0);
/* 673 */       if (this.random.nextInt(4) == 1) {
/* 674 */         makeScragglyBranch(world, x, y, z, this.random.nextInt(1 + j - k), this.random.nextInt(2) - this.random.nextInt(2), this.random.nextInt(2) - this.random.nextInt(2), chunk);
/*     */       }
/*     */       
/* 677 */       for (int m = -1; m < 2; m++) {
/* 678 */         for (int n = -1; n < 2; n++) {
/* 679 */           if (this.random.nextInt(2) == 1) {
/* 680 */             bid = OreSpawnMain.getBlockIDInChunk(chunk, x + m, y, z + n);
/* 681 */             if (bid == Blocks.air) {
/* 682 */               OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, OreSpawnMain.MyAppleLeaves, 0);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 687 */       if (this.random.nextInt(2) == 1) {
/* 688 */         bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y + 1, z);
/* 689 */         if (bid == Blocks.air)
/* 690 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y + 1, z, OreSpawnMain.MyAppleLeaves, 0); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ChunkProviderOreSpawn6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */