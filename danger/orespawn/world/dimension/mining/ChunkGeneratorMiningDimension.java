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
/*  55 */   private double[] depthBuffer = new double[256];
/*     */   private Biome[] biomesForGeneration;
/*     */   double[] mainNoiseRegion;
/*     */   double[] minLimitRegion;
/*     */   double[] maxLimitRegion;
/*     */   double[] depthRegion;
/*     */   
/*     */   public ChunkGeneratorMiningDimension(World worldIn, long seed, BiomeProvider bp) {
/*  63 */     this.world = worldIn;
/*  64 */     this.terrainType = worldIn.getWorldInfo().getTerrainType();
/*  65 */     this.rand = new Random(seed);
/*  66 */     this.stoneNoise = new double[256];
/*  67 */     this.biomeProvider = bp;
/*     */     
/*  69 */     this.scale = new NoiseGeneratorOctaves(this.rand, 10);
/*  70 */     this.depth = new NoiseGeneratorOctaves(this.rand, 16);
/*  71 */     this.forest = new NoiseGeneratorOctaves(this.rand, 8);
/*  72 */     this.minLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
/*  73 */     this.maxLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
/*  74 */     this.mainPerlinNoise = new NoiseGeneratorOctaves(this.rand, 8);
/*  75 */     this.height = new NoiseGeneratorPerlin(this.rand, 4);
/*     */     
/*  77 */     this.heightMap = new double[825];
/*  78 */     this.parabolicField = new float[25];
/*     */     
/*  80 */     this.caveGenerator = TerrainGen.getModdedMapGen((MapGenBase)new MapGenCaves(), InitMapGenEvent.EventType.CAVE);
/*     */     
/*  82 */     for (int i = -2; i <= 2; i++) {
/*  83 */       for (int j = -2; j <= 2; j++) {
/*  84 */         float f = 10.0F / MathHelper.sqrt((i * i + j * j) + 0.2F);
/*  85 */         this.parabolicField[i + 2 + (j + 2) * 5] = f;
/*     */       } 
/*     */     } 
/*  88 */     InitNoiseGensEvent.ContextOverworld ctx = new InitNoiseGensEvent.ContextOverworld(this.minLimitPerlinNoise, this.maxLimitPerlinNoise, this.mainPerlinNoise, this.height, this.scale, this.depth, this.forest);
/*  89 */     ctx = (InitNoiseGensEvent.ContextOverworld)TerrainGen.getModdedNoiseGenerators(worldIn, this.rand, (InitNoiseGensEvent.Context)ctx);
/*     */     
/*  91 */     this.minLimitPerlinNoise = ctx.getLPerlin1();
/*  92 */     this.maxLimitPerlinNoise = ctx.getLPerlin2();
/*  93 */     this.mainPerlinNoise = ctx.getPerlin();
/*  94 */     this.height = ctx.getHeight();
/*  95 */     this.scale = ctx.getScale();
/*  96 */     this.depth = ctx.getDepth();
/*  97 */     this.forest = ctx.getForest();
/*     */   }
/*     */ 
/*     */   
/*     */   public Chunk generateChunk(int x, int z) {
/* 102 */     this.rand.setSeed(x * 341873128712L + z * 132897987541L);
/* 103 */     ChunkPrimer chunkPrimer = new ChunkPrimer();
/* 104 */     setBlocksInChunk(x, z, chunkPrimer);
/*     */     
/* 106 */     this.biomesForGeneration = this.biomeProvider.getBiomes(this.biomesForGeneration, x * 16, z * 16, 16, 16);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     replaceBiomeBlocks(x, z, chunkPrimer, this.biomesForGeneration);
/*     */     
/* 114 */     this.caveGenerator.generate(this.world, x, z, chunkPrimer);
/* 115 */     Chunk chunk = new Chunk(this.world, chunkPrimer, x, z);
/*     */     
/* 117 */     byte[] abyte = chunk.getBiomeArray();
/* 118 */     for (int i = 0; i < abyte.length; i++) {
/* 119 */       abyte[i] = (byte)Biome.getIdForBiome(this.biomesForGeneration[i]);
/*     */     }
/*     */     
/* 122 */     chunk.generateSkylightMap();
/* 123 */     return chunk;
/*     */   }
/*     */   
/*     */   private void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn) {
/* 127 */     if (!ForgeEventFactory.onReplaceBiomeBlocks(this, x, z, primer, this.world))
/*     */       return; 
/* 129 */     double d0 = 0.03125D;
/* 130 */     this.depthBuffer = this.height.getRegion(this.depthBuffer, (x * 16), (z * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
/*     */     
/* 132 */     for (int i = 0; i < 16; i++) {
/* 133 */       for (int j = 0; j < 16; j++) {
/* 134 */         Biome biome = biomesIn[j + i * 16];
/* 135 */         generateBiomeTerrain(this.world, this.rand, primer, x * 16 + i, z * 16 + j, this.depthBuffer[j + i * 16], biome);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void generateBiomeTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal, Biome biome) {
/* 142 */     int seaLevel = 63;
/*     */     
/* 144 */     IBlockState topBlock = biome.topBlock;
/* 145 */     IBlockState fillerBlock = biome.fillerBlock;
/* 146 */     int j = -1;
/* 147 */     int k = (int)(noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
/* 148 */     int l = x & 0xF;
/* 149 */     int i1 = z & 0xF;
/*     */     
/* 151 */     BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
/* 152 */     for (int y = 255; y >= 0; y--) {
/* 153 */       if (y == 0) {
/* 154 */         chunkPrimerIn.setBlockState(i1, y, l, Blocks.BEDROCK.getDefaultState());
/*     */       } else {
/* 156 */         IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, y, l);
/* 157 */         if (iblockstate2.getMaterial() == Material.AIR) {
/* 158 */           j = -1;
/* 159 */         } else if (iblockstate2.getBlock() == Blocks.STONE) {
/* 160 */           if (j == -1) {
/* 161 */             if (k <= 0) {
/* 162 */               topBlock = Blocks.AIR.getDefaultState();
/* 163 */               fillerBlock = Blocks.STONE.getDefaultState();
/* 164 */             } else if (y >= seaLevel - 4 && y <= seaLevel + 1) {
/* 165 */               topBlock = biome.topBlock;
/* 166 */               fillerBlock = biome.fillerBlock;
/*     */             } 
/* 168 */             if (y < seaLevel && (topBlock == null || topBlock.getMaterial() == Material.AIR)) {
/* 169 */               fillerBlock = Blocks.WATER.getDefaultState();
/*     */             }
/* 171 */             j = k;
/* 172 */             if (y >= seaLevel - 1) {
/* 173 */               chunkPrimerIn.setBlockState(i1, y, l, topBlock);
/* 174 */             } else if (y < seaLevel - 7 - k) {
/* 175 */               topBlock = Blocks.AIR.getDefaultState();
/* 176 */               fillerBlock = Blocks.STONE.getDefaultState();
/* 177 */               chunkPrimerIn.setBlockState(i1, y, l, Blocks.GRAVEL.getDefaultState());
/*     */             } else {
/* 179 */               chunkPrimerIn.setBlockState(i1, y, l, fillerBlock);
/*     */             } 
/* 181 */           } else if (j > 0) {
/* 182 */             j--;
/* 183 */             chunkPrimerIn.setBlockState(i1, y, l, fillerBlock);
/* 184 */             if (j == 0 && fillerBlock.getBlock() == Blocks.SAND) {
/* 185 */               j = rand.nextInt(4);
/* 186 */               fillerBlock = Blocks.STONE.getDefaultState();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setBlocksInChunk(int x, int z, ChunkPrimer chunkPrimer) {
/* 195 */     this.biomesForGeneration = this.biomeProvider.getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
/*     */ 
/*     */ 
/*     */     
/* 199 */     generateHeightmap(x * 4, 0, z * 4);
/* 200 */     for (int i = 0; i < 4; i++) {
/* 201 */       int j = i * 5;
/* 202 */       int k = (i + 1) * 5;
/* 203 */       for (int l = 0; l < 4; l++) {
/* 204 */         int i1 = (j + l) * 33;
/* 205 */         int j1 = (j + l + 1) * 33;
/* 206 */         int k1 = (k + l) * 33;
/* 207 */         int l1 = (k + l + 1) * 33;
/*     */         
/* 209 */         for (int i2 = 0; i2 < 32; i2++) {
/* 210 */           double d0 = 0.125D;
/* 211 */           double d1 = this.heightMap[i1 + i2];
/* 212 */           double d2 = this.heightMap[j1 + i2];
/* 213 */           double d3 = this.heightMap[k1 + i2];
/* 214 */           double d4 = this.heightMap[l1 + i2];
/* 215 */           double d5 = (this.heightMap[i1 + i2 + 1] - d1) * 0.125D;
/* 216 */           double d6 = (this.heightMap[j1 + i2 + 1] - d2) * 0.125D;
/* 217 */           double d7 = (this.heightMap[k1 + i2 + 1] - d3) * 0.125D;
/* 218 */           double d8 = (this.heightMap[l1 + i2 + 1] - d4) * 0.125D;
/* 219 */           for (int j2 = 0; j2 < 8; j2++) {
/* 220 */             double d9 = 0.25D;
/* 221 */             double d10 = d1;
/* 222 */             double d11 = d2;
/* 223 */             double d12 = (d3 - d1) * 0.25D;
/* 224 */             double d13 = (d4 - d2) * 0.25D;
/*     */             
/* 226 */             for (int k2 = 0; k2 < 4; k2++) {
/* 227 */               double d14 = 0.25D;
/* 228 */               double d16 = (d11 - d10) * 0.25D;
/* 229 */               double lvt_45_1_ = d10 - d16;
/*     */               
/* 231 */               for (int l2 = 0; l2 < 4; l2++) {
/* 232 */                 if ((lvt_45_1_ += d16) > 0.0D) {
/* 233 */                   chunkPrimer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, Blocks.STONE.getDefaultState());
/* 234 */                 } else if (i2 * 8 + j2 < 63) {
/* 235 */                   chunkPrimer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, Blocks.WATER.getDefaultState());
/*     */                 } 
/*     */               } 
/*     */               
/* 239 */               d10 += d12;
/* 240 */               d11 += d13;
/*     */             } 
/*     */             
/* 243 */             d1 += d5;
/* 244 */             d2 += d6;
/* 245 */             d3 += d7;
/* 246 */             d4 += d8;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateHeightmap(int x, int y, int z) {
/* 256 */     this.depthRegion = this.depth.generateNoiseOctaves(this.depthRegion, x, z, 5, 5, 200.0D, 200.0D, 0.5D);
/* 257 */     float coordScale = 684.412F;
/* 258 */     float heightScale = 684.412F;
/* 259 */     this.mainNoiseRegion = this.mainPerlinNoise.generateNoiseOctaves(this.mainNoiseRegion, x, y, z, 5, 33, 5, 8.55515D, 4.277575D, 8.55515D);
/* 260 */     this.minLimitRegion = this.minLimitPerlinNoise.generateNoiseOctaves(this.minLimitRegion, x, y, z, 5, 33, 5, coordScale, heightScale, coordScale);
/* 261 */     this.maxLimitRegion = this.maxLimitPerlinNoise.generateNoiseOctaves(this.maxLimitRegion, x, y, z, 5, 33, 5, coordScale, heightScale, coordScale);
/*     */     
/* 263 */     int i = 0;
/* 264 */     int j = 0;
/* 265 */     for (int k = 0; k < 5; k++) {
/* 266 */       for (int l = 0; l < 5; l++) {
/* 267 */         float f2 = 0.0F;
/* 268 */         float f3 = 0.0F;
/* 269 */         float f4 = 0.0F;
/* 270 */         int i1 = 2;
/*     */         
/* 272 */         Biome surroundingBiome = this.biomesForGeneration[k + 2 + (l + 2) * 10];
/*     */         
/* 274 */         for (int j1 = -i1; j1 < i1; j1++) {
/* 275 */           for (int k1 = -i1; k1 <= i1; k1++) {
/* 276 */             Biome biome = this.biomesForGeneration[k + j1 + 2 + (l + k1 + 2) * 10];
/*     */             
/* 278 */             float baseHeight = biome.getBaseHeight();
/* 279 */             float heightVariation = biome.getHeightVariation();
/* 280 */             float f7 = this.parabolicField[j1 + 2 + (k1 + 2) * 5] / (baseHeight + 2.0F);
/* 281 */             if (biome.getBaseHeight() > surroundingBiome.getBaseHeight()) {
/* 282 */               f7 /= 2.0F;
/*     */             }
/*     */             
/* 285 */             f2 += heightVariation * f7;
/* 286 */             f3 += baseHeight * f7;
/* 287 */             f4 += f7;
/*     */           } 
/*     */         } 
/* 290 */         f2 /= f4;
/* 291 */         f3 /= f4;
/*     */         
/* 293 */         f2 = f2 * 0.9F + 0.1F;
/* 294 */         f3 = (f3 * 4.0F - 1.0F) / 8.0F;
/* 295 */         double d7 = this.depthRegion[j] / 8000.0D;
/* 296 */         if (d7 < 0.0D) {
/* 297 */           d7 = -d7 * 0.3D;
/*     */         }
/*     */         
/* 300 */         if (d7 < 0.0D) {
/* 301 */           d7 /= 2.0D;
/* 302 */           if (d7 < -1.0D) {
/* 303 */             d7 = -1.0D;
/*     */           }
/* 305 */           d7 /= 1.4D;
/* 306 */           d7 /= 2.0D;
/*     */         } else {
/* 308 */           if (d7 > 1.0D) {
/* 309 */             d7 = 1.0D;
/*     */           }
/* 311 */           d7 /= 8.0D;
/*     */         } 
/* 313 */         j++;
/*     */         
/* 315 */         double d8 = f3;
/* 316 */         double d9 = f2;
/* 317 */         d8 += d7 * 0.2D;
/* 318 */         d8 = d8 * 8.5D / 8.0D;
/* 319 */         double d0 = 8.5D + d8 * 4.0D;
/* 320 */         for (int l1 = 0; l1 < 33; l1++) {
/* 321 */           double d1 = (l1 - d0) * 12.0D * 128.0D / 256.0D / d9;
/* 322 */           if (d1 < 0.0D) {
/* 323 */             d1 *= 4.0D;
/*     */           }
/* 325 */           double d2 = this.minLimitRegion[i] / 512.0D;
/* 326 */           double d3 = this.maxLimitRegion[i] / 512.0D;
/* 327 */           double d4 = (this.mainNoiseRegion[i] / 10.0D + 1.0D) / 2.0D;
/* 328 */           double d5 = MathHelper.clampedLerp(d2, d3, d4) - d1;
/* 329 */           if (l1 > 29) {
/* 330 */             double d6 = ((l1 - 29) / 3.0F);
/* 331 */             d5 = d5 * (1.0D - d6) + -10.0D * d6;
/*     */           } 
/* 333 */           this.heightMap[i] = d5;
/* 334 */           i++;
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
/* 346 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockPos getNearestStructurePos(World arg0, String arg1, BlockPos arg2, boolean arg3) {
/* 353 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
/* 359 */     Biome biome = this.world.getBiome(pos);
/*     */     
/* 361 */     return biome.getSpawnableList(creatureType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInsideStructure(World arg0, String arg1, BlockPos arg2) {
/* 368 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void populate(int x, int z) {
/* 374 */     BlockFalling.fallInstantly = true;
/* 375 */     int i = x * 16;
/* 376 */     int j = z * 16;
/* 377 */     BlockPos blockpos = new BlockPos(i, 0, j);
/* 378 */     Biome biome = this.world.getBiome(blockpos.add(16, 0, 16));
/*     */     
/* 380 */     ForgeEventFactory.onChunkPopulate(true, this, this.world, this.rand, x, z, false);
/*     */     
/* 382 */     biome.decorate(this.world, this.rand, blockpos);
/*     */ 
/*     */     
/* 385 */     ForgeEventFactory.onChunkPopulate(false, this, this.world, this.rand, x, z, false);
/*     */     
/* 387 */     BlockFalling.fallInstantly = false;
/*     */   }
/*     */   
/*     */   public void recreateStructures(Chunk arg0, int arg1, int arg2) {}
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\world\dimension\mining\ChunkGeneratorMiningDimension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */