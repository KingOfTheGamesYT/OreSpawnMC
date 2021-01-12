/*     */ package danger.orespawn.world.dimension.mining;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.BlockFalling;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.biome.Biome;
/*     */ import net.minecraft.world.biome.BiomeProvider;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.ChunkPrimer;
/*     */ import net.minecraft.world.gen.IChunkGenerator;
/*     */ import net.minecraft.world.gen.MapGenBase;
/*     */ import net.minecraft.world.gen.MapGenCaves;
/*     */ import net.minecraft.world.gen.NoiseGeneratorOctaves;
/*     */ import net.minecraft.world.gen.NoiseGeneratorPerlin;
/*     */ import net.minecraftforge.event.ForgeEventFactory;
/*     */ import net.minecraftforge.event.terraingen.InitMapGenEvent;
/*     */ import net.minecraftforge.event.terraingen.InitNoiseGensEvent;
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
/*     */ public class ChunkGeneratorMiningDimension
/*     */   implements IChunkGenerator
/*     */ {
/*     */   private Random rand;
/*     */   private World world;
/*     */   private final BiomeProvider biomeProvider;
/*     */   private final WorldType terrainType;
/*     */   private final double[] heightMap;
/*     */   private final float[] parabolicField;
/*     */   public NoiseGeneratorOctaves scale;
/*     */   public NoiseGeneratorOctaves depth;
/*     */   public NoiseGeneratorOctaves forest;
/*     */   private NoiseGeneratorOctaves minLimitPerlinNoise;
/*     */   private NoiseGeneratorOctaves maxLimitPerlinNoise;
/*     */   private NoiseGeneratorOctaves mainPerlinNoise;
/*     */   private NoiseGeneratorPerlin height;
/*     */   private MapGenBase caveGenerator;
/*     */   private double[] stoneNoise;
/*  62 */   private double[] depthBuffer = new double[256];
/*     */   private Biome[] biomesForGeneration;
/*     */   double[] mainNoiseRegion;
/*     */   double[] minLimitRegion;
/*     */   double[] maxLimitRegion;
/*     */   double[] depthRegion;
/*     */   
/*     */   public ChunkGeneratorMiningDimension(World worldIn, long seed, BiomeProvider bp) {
/*  70 */     this.world = worldIn;
/*  71 */     this.terrainType = worldIn.getWorldInfo().getTerrainType();
/*  72 */     this.rand = new Random(seed);
/*  73 */     this.stoneNoise = new double[256];
/*  74 */     this.biomeProvider = bp;
/*     */     
/*  76 */     this.scale = new NoiseGeneratorOctaves(this.rand, 10);
/*  77 */     this.depth = new NoiseGeneratorOctaves(this.rand, 16);
/*  78 */     this.forest = new NoiseGeneratorOctaves(this.rand, 8);
/*  79 */     this.minLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
/*  80 */     this.maxLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
/*  81 */     this.mainPerlinNoise = new NoiseGeneratorOctaves(this.rand, 8);
/*  82 */     this.height = new NoiseGeneratorPerlin(this.rand, 4);
/*     */     
/*  84 */     this.heightMap = new double[825];
/*  85 */     this.parabolicField = new float[25];
/*     */     
/*  87 */     this.caveGenerator = TerrainGen.getModdedMapGen((MapGenBase)new MapGenCaves(), InitMapGenEvent.EventType.CAVE);
/*     */     
/*  89 */     for (int i = -2; i <= 2; i++) {
/*  90 */       for (int j = -2; j <= 2; j++) {
/*  91 */         float f = 10.0F / MathHelper.sqrt((i * i + j * j) + 0.2F);
/*  92 */         this.parabolicField[i + 2 + (j + 2) * 5] = f;
/*     */       } 
/*     */     } 
/*  95 */     InitNoiseGensEvent.ContextOverworld ctx = new InitNoiseGensEvent.ContextOverworld(this.minLimitPerlinNoise, this.maxLimitPerlinNoise, this.mainPerlinNoise, this.height, this.scale, this.depth, this.forest);
/*  96 */     ctx = (InitNoiseGensEvent.ContextOverworld)TerrainGen.getModdedNoiseGenerators(worldIn, this.rand, (InitNoiseGensEvent.Context)ctx);
/*     */     
/*  98 */     this.minLimitPerlinNoise = ctx.getLPerlin1();
/*  99 */     this.maxLimitPerlinNoise = ctx.getLPerlin2();
/* 100 */     this.mainPerlinNoise = ctx.getPerlin();
/* 101 */     this.height = ctx.getHeight();
/* 102 */     this.scale = ctx.getScale();
/* 103 */     this.depth = ctx.getDepth();
/* 104 */     this.forest = ctx.getForest();
/*     */   }
/*     */ 
/*     */   
/*     */   public Chunk generateChunk(int x, int z) {
/* 109 */     this.rand.setSeed(x * 341873128712L + z * 132897987541L);
/* 110 */     ChunkPrimer chunkPrimer = new ChunkPrimer();
/* 111 */     setBlocksInChunk(x, z, chunkPrimer);
/*     */     
/* 113 */     this.biomesForGeneration = this.biomeProvider.getBiomes(this.biomesForGeneration, x * 16, z * 16, 16, 16);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 119 */     replaceBiomeBlocks(x, z, chunkPrimer, this.biomesForGeneration);
/*     */     
/* 121 */     this.caveGenerator.generate(this.world, x, z, chunkPrimer);
/* 122 */     Chunk chunk = new Chunk(this.world, chunkPrimer, x, z);
/*     */     
/* 124 */     byte[] abyte = chunk.getBiomeArray();
/* 125 */     for (int i = 0; i < abyte.length; i++)
/*     */     {
/* 127 */       abyte[i] = (byte)Biome.getIdForBiome(this.biomesForGeneration[i]);
/*     */     }
/*     */     
/* 130 */     chunk.generateSkylightMap();
/* 131 */     return chunk;
/*     */   }
/*     */   
/*     */   private void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn) {
/* 135 */     if (!ForgeEventFactory.onReplaceBiomeBlocks(this, x, z, primer, this.world))
/*     */       return; 
/* 137 */     double d0 = 0.03125D;
/* 138 */     this.depthBuffer = this.height.getRegion(this.depthBuffer, (x * 16), (z * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
/*     */     
/* 140 */     for (int i = 0; i < 16; i++) {
/* 141 */       for (int j = 0; j < 16; j++) {
/* 142 */         Biome biome = biomesIn[j + i * 16];
/* 143 */         generateBiomeTerrain(this.world, this.rand, primer, x * 16 + i, z * 16 + j, this.depthBuffer[j + i * 16], biome);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateBiomeTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal, Biome biome) {
/* 151 */     int seaLevel = 63;
/*     */     
/* 153 */     IBlockState topBlock = biome.topBlock;
/* 154 */     IBlockState fillerBlock = biome.fillerBlock;
/* 155 */     int j = -1;
/* 156 */     int k = (int)(noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
/* 157 */     int l = x & 0xF;
/* 158 */     int i1 = z & 0xF;
/*     */     
/* 160 */     BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
/* 161 */     for (int y = 255; y >= 0; y--) {
/*     */       
/* 163 */       if (y == 0) {
/*     */         
/* 165 */         chunkPrimerIn.setBlockState(i1, y, l, Blocks.BEDROCK.getDefaultState());
/*     */       } else {
/* 167 */         IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, y, l);
/* 168 */         if (iblockstate2.getMaterial() == Material.AIR) {
/* 169 */           j = -1;
/* 170 */         } else if (iblockstate2.getBlock() == Blocks.STONE) {
/* 171 */           if (j == -1) {
/* 172 */             if (k <= 0) {
/* 173 */               topBlock = Blocks.AIR.getDefaultState();
/* 174 */               fillerBlock = Blocks.STONE.getDefaultState();
/* 175 */             } else if (y >= seaLevel - 4 && y <= seaLevel + 1) {
/* 176 */               topBlock = biome.topBlock;
/* 177 */               fillerBlock = biome.fillerBlock;
/*     */             } 
/* 179 */             if (y < seaLevel && (topBlock == null || topBlock.getMaterial() == Material.AIR)) {
/* 180 */               fillerBlock = Blocks.WATER.getDefaultState();
/*     */             }
/* 182 */             j = k;
/* 183 */             if (y >= seaLevel - 1) {
/* 184 */               chunkPrimerIn.setBlockState(i1, y, l, topBlock);
/* 185 */             } else if (y < seaLevel - 7 - k) {
/* 186 */               topBlock = Blocks.AIR.getDefaultState();
/* 187 */               fillerBlock = Blocks.STONE.getDefaultState();
/* 188 */               chunkPrimerIn.setBlockState(i1, y, l, Blocks.GRAVEL.getDefaultState());
/*     */             } else {
/* 190 */               chunkPrimerIn.setBlockState(i1, y, l, fillerBlock);
/*     */             } 
/* 192 */           } else if (j > 0) {
/* 193 */             j--;
/* 194 */             chunkPrimerIn.setBlockState(i1, y, l, fillerBlock);
/* 195 */             if (j == 0 && fillerBlock.getBlock() == Blocks.SAND) {
/* 196 */               j = rand.nextInt(4);
/* 197 */               fillerBlock = Blocks.STONE.getDefaultState();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setBlocksInChunk(int x, int z, ChunkPrimer chunkPrimer) {
/* 207 */     this.biomesForGeneration = this.biomeProvider.getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
/*     */ 
/*     */ 
/*     */     
/* 211 */     generateHeightmap(x * 4, 0, z * 4);
/* 212 */     for (int i = 0; i < 4; i++) {
/*     */       
/* 214 */       int j = i * 5;
/* 215 */       int k = (i + 1) * 5;
/* 216 */       for (int l = 0; l < 4; l++) {
/*     */         
/* 218 */         int i1 = (j + l) * 33;
/* 219 */         int j1 = (j + l + 1) * 33;
/* 220 */         int k1 = (k + l) * 33;
/* 221 */         int l1 = (k + l + 1) * 33;
/*     */         
/* 223 */         for (int i2 = 0; i2 < 32; i2++) {
/*     */           
/* 225 */           double d0 = 0.125D;
/* 226 */           double d1 = this.heightMap[i1 + i2];
/* 227 */           double d2 = this.heightMap[j1 + i2];
/* 228 */           double d3 = this.heightMap[k1 + i2];
/* 229 */           double d4 = this.heightMap[l1 + i2];
/* 230 */           double d5 = (this.heightMap[i1 + i2 + 1] - d1) * 0.125D;
/* 231 */           double d6 = (this.heightMap[j1 + i2 + 1] - d2) * 0.125D;
/* 232 */           double d7 = (this.heightMap[k1 + i2 + 1] - d3) * 0.125D;
/* 233 */           double d8 = (this.heightMap[l1 + i2 + 1] - d4) * 0.125D;
/* 234 */           for (int j2 = 0; j2 < 8; j2++) {
/*     */             
/* 236 */             double d9 = 0.25D;
/* 237 */             double d10 = d1;
/* 238 */             double d11 = d2;
/* 239 */             double d12 = (d3 - d1) * 0.25D;
/* 240 */             double d13 = (d4 - d2) * 0.25D;
/*     */             
/* 242 */             for (int k2 = 0; k2 < 4; k2++) {
/*     */               
/* 244 */               double d14 = 0.25D;
/* 245 */               double d16 = (d11 - d10) * 0.25D;
/* 246 */               double lvt_45_1_ = d10 - d16;
/*     */               
/* 248 */               for (int l2 = 0; l2 < 4; l2++) {
/*     */                 
/* 250 */                 if ((lvt_45_1_ += d16) > 0.0D) {
/*     */                   
/* 252 */                   chunkPrimer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, Blocks.STONE.getDefaultState());
/*     */                 }
/* 254 */                 else if (i2 * 8 + j2 < 63) {
/*     */                   
/* 256 */                   chunkPrimer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, Blocks.WATER.getDefaultState());
/*     */                 } 
/*     */               } 
/*     */               
/* 260 */               d10 += d12;
/* 261 */               d11 += d13;
/*     */             } 
/*     */             
/* 264 */             d1 += d5;
/* 265 */             d2 += d6;
/* 266 */             d3 += d7;
/* 267 */             d4 += d8;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateHeightmap(int x, int y, int z) {
/* 278 */     this.depthRegion = this.depth.generateNoiseOctaves(this.depthRegion, x, z, 5, 5, 200.0D, 200.0D, 0.5D);
/* 279 */     float coordScale = 684.412F;
/* 280 */     float heightScale = 684.412F;
/* 281 */     this.mainNoiseRegion = this.mainPerlinNoise.generateNoiseOctaves(this.mainNoiseRegion, x, y, z, 5, 33, 5, 8.55515D, 4.277575D, 8.55515D);
/* 282 */     this.minLimitRegion = this.minLimitPerlinNoise.generateNoiseOctaves(this.minLimitRegion, x, y, z, 5, 33, 5, coordScale, heightScale, coordScale);
/* 283 */     this.maxLimitRegion = this.maxLimitPerlinNoise.generateNoiseOctaves(this.maxLimitRegion, x, y, z, 5, 33, 5, coordScale, heightScale, coordScale);
/*     */     
/* 285 */     int i = 0;
/* 286 */     int j = 0;
/* 287 */     for (int k = 0; k < 5; k++) {
/*     */       
/* 289 */       for (int l = 0; l < 5; l++) {
/*     */         
/* 291 */         float f2 = 0.0F;
/* 292 */         float f3 = 0.0F;
/* 293 */         float f4 = 0.0F;
/* 294 */         int i1 = 2;
/*     */         
/* 296 */         Biome surroundingBiome = this.biomesForGeneration[k + 2 + (l + 2) * 10];
/*     */         
/* 298 */         for (int j1 = -i1; j1 < i1; j1++) {
/*     */           
/* 300 */           for (int k1 = -i1; k1 <= i1; k1++) {
/*     */             
/* 302 */             Biome biome = this.biomesForGeneration[k + j1 + 2 + (l + k1 + 2) * 10];
/*     */             
/* 304 */             float baseHeight = biome.getBaseHeight();
/* 305 */             float heightVariation = biome.getHeightVariation();
/* 306 */             float f7 = this.parabolicField[j1 + 2 + (k1 + 2) * 5] / (baseHeight + 2.0F);
/* 307 */             if (biome.getBaseHeight() > surroundingBiome.getBaseHeight())
/*     */             {
/* 309 */               f7 /= 2.0F;
/*     */             }
/*     */             
/* 312 */             f2 += heightVariation * f7;
/* 313 */             f3 += baseHeight * f7;
/* 314 */             f4 += f7;
/*     */           } 
/*     */         } 
/* 317 */         f2 /= f4;
/* 318 */         f3 /= f4;
/*     */         
/* 320 */         f2 = f2 * 0.9F + 0.1F;
/* 321 */         f3 = (f3 * 4.0F - 1.0F) / 8.0F;
/* 322 */         double d7 = this.depthRegion[j] / 8000.0D;
/* 323 */         if (d7 < 0.0D)
/*     */         {
/* 325 */           d7 = -d7 * 0.3D;
/*     */         }
/*     */         
/* 328 */         if (d7 < 0.0D) {
/*     */           
/* 330 */           d7 /= 2.0D;
/* 331 */           if (d7 < -1.0D)
/*     */           {
/* 333 */             d7 = -1.0D;
/*     */           }
/* 335 */           d7 /= 1.4D;
/* 336 */           d7 /= 2.0D;
/*     */         }
/*     */         else {
/*     */           
/* 340 */           if (d7 > 1.0D)
/*     */           {
/* 342 */             d7 = 1.0D;
/*     */           }
/* 344 */           d7 /= 8.0D;
/*     */         } 
/* 346 */         j++;
/*     */         
/* 348 */         double d8 = f3;
/* 349 */         double d9 = f2;
/* 350 */         d8 += d7 * 0.2D;
/* 351 */         d8 = d8 * 8.5D / 8.0D;
/* 352 */         double d0 = 8.5D + d8 * 4.0D;
/* 353 */         for (int l1 = 0; l1 < 33; l1++) {
/* 354 */           double d1 = (l1 - d0) * 12.0D * 128.0D / 256.0D / d9;
/* 355 */           if (d1 < 0.0D) {
/* 356 */             d1 *= 4.0D;
/*     */           }
/* 358 */           double d2 = this.minLimitRegion[i] / 512.0D;
/* 359 */           double d3 = this.maxLimitRegion[i] / 512.0D;
/* 360 */           double d4 = (this.mainNoiseRegion[i] / 10.0D + 1.0D) / 2.0D;
/* 361 */           double d5 = MathHelper.clampedLerp(d2, d3, d4) - d1;
/* 362 */           if (l1 > 29) {
/* 363 */             double d6 = ((l1 - 29) / 3.0F);
/* 364 */             d5 = d5 * (1.0D - d6) + -10.0D * d6;
/*     */           } 
/* 366 */           this.heightMap[i] = d5;
/* 367 */           i++;
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
/*     */   public boolean generateStructures(Chunk arg0, int arg1, int arg2) {
/* 379 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockPos getNearestStructurePos(World arg0, String arg1, BlockPos arg2, boolean arg3) {
/* 386 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
/* 392 */     Biome biome = this.world.getBiome(pos);
/* 393 */     return biome.getSpawnableList(creatureType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInsideStructure(World arg0, String arg1, BlockPos arg2) {
/* 400 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void populate(int x, int z) {
/* 406 */     BlockFalling.fallInstantly = true;
/* 407 */     int i = x * 16;
/* 408 */     int j = z * 16;
/* 409 */     BlockPos blockpos = new BlockPos(i, 0, j);
/* 410 */     Biome biome = this.world.getBiome(blockpos.add(16, 0, 16));
/*     */     
/* 412 */     ForgeEventFactory.onChunkPopulate(true, this, this.world, this.rand, x, z, false);
/*     */     
/* 414 */     biome.decorate(this.world, this.rand, blockpos);
/*     */ 
/*     */     
/* 417 */     ForgeEventFactory.onChunkPopulate(false, this, this.world, this.rand, x, z, false);
/*     */     
/* 419 */     BlockFalling.fallInstantly = false;
/*     */   }
/*     */   
/*     */   public void recreateStructures(Chunk arg0, int arg1, int arg2) {}
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespawn\world\dimension\mining\ChunkGeneratorMiningDimension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */