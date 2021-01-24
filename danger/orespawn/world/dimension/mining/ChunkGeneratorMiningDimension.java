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
/* 118 */     for (int i = 0; i < abyte.length; i++)
/*     */     {
/* 120 */       abyte[i] = (byte)Biome.getIdForBiome(this.biomesForGeneration[i]);
/*     */     }
/*     */     
/* 123 */     chunk.generateSkylightMap();
/* 124 */     return chunk;
/*     */   }
/*     */   
/*     */   private void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn) {
/* 128 */     if (!ForgeEventFactory.onReplaceBiomeBlocks(this, x, z, primer, this.world))
/*     */       return; 
/* 130 */     double d0 = 0.03125D;
/* 131 */     this.depthBuffer = this.height.getRegion(this.depthBuffer, (x * 16), (z * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
/*     */     
/* 133 */     for (int i = 0; i < 16; i++) {
/* 134 */       for (int j = 0; j < 16; j++) {
/* 135 */         Biome biome = biomesIn[j + i * 16];
/* 136 */         generateBiomeTerrain(this.world, this.rand, primer, x * 16 + i, z * 16 + j, this.depthBuffer[j + i * 16], biome);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateBiomeTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal, Biome biome) {
/* 144 */     int seaLevel = 63;
/*     */     
/* 146 */     IBlockState topBlock = biome.topBlock;
/* 147 */     IBlockState fillerBlock = biome.fillerBlock;
/* 148 */     int j = -1;
/* 149 */     int k = (int)(noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
/* 150 */     int l = x & 0xF;
/* 151 */     int i1 = z & 0xF;
/*     */     
/* 153 */     BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
/* 154 */     for (int y = 255; y >= 0; y--) {
/*     */       
/* 156 */       if (y == 0) {
/*     */         
/* 158 */         chunkPrimerIn.setBlockState(i1, y, l, Blocks.BEDROCK.getDefaultState());
/*     */       } else {
/* 160 */         IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, y, l);
/* 161 */         if (iblockstate2.getMaterial() == Material.AIR) {
/* 162 */           j = -1;
/* 163 */         } else if (iblockstate2.getBlock() == Blocks.STONE) {
/* 164 */           if (j == -1) {
/* 165 */             if (k <= 0) {
/* 166 */               topBlock = Blocks.AIR.getDefaultState();
/* 167 */               fillerBlock = Blocks.STONE.getDefaultState();
/* 168 */             } else if (y >= seaLevel - 4 && y <= seaLevel + 1) {
/* 169 */               topBlock = biome.topBlock;
/* 170 */               fillerBlock = biome.fillerBlock;
/*     */             } 
/* 172 */             if (y < seaLevel && (topBlock == null || topBlock.getMaterial() == Material.AIR)) {
/* 173 */               fillerBlock = Blocks.WATER.getDefaultState();
/*     */             }
/* 175 */             j = k;
/* 176 */             if (y >= seaLevel - 1) {
/* 177 */               chunkPrimerIn.setBlockState(i1, y, l, topBlock);
/* 178 */             } else if (y < seaLevel - 7 - k) {
/* 179 */               topBlock = Blocks.AIR.getDefaultState();
/* 180 */               fillerBlock = Blocks.STONE.getDefaultState();
/* 181 */               chunkPrimerIn.setBlockState(i1, y, l, Blocks.GRAVEL.getDefaultState());
/*     */             } else {
/* 183 */               chunkPrimerIn.setBlockState(i1, y, l, fillerBlock);
/*     */             } 
/* 185 */           } else if (j > 0) {
/* 186 */             j--;
/* 187 */             chunkPrimerIn.setBlockState(i1, y, l, fillerBlock);
/* 188 */             if (j == 0 && fillerBlock.getBlock() == Blocks.SAND) {
/* 189 */               j = rand.nextInt(4);
/* 190 */               fillerBlock = Blocks.STONE.getDefaultState();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setBlocksInChunk(int x, int z, ChunkPrimer chunkPrimer) {
/* 200 */     this.biomesForGeneration = this.biomeProvider.getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
/*     */ 
/*     */ 
/*     */     
/* 204 */     generateHeightmap(x * 4, 0, z * 4);
/* 205 */     for (int i = 0; i < 4; i++) {
/*     */       
/* 207 */       int j = i * 5;
/* 208 */       int k = (i + 1) * 5;
/* 209 */       for (int l = 0; l < 4; l++) {
/*     */         
/* 211 */         int i1 = (j + l) * 33;
/* 212 */         int j1 = (j + l + 1) * 33;
/* 213 */         int k1 = (k + l) * 33;
/* 214 */         int l1 = (k + l + 1) * 33;
/*     */         
/* 216 */         for (int i2 = 0; i2 < 32; i2++) {
/*     */           
/* 218 */           double d0 = 0.125D;
/* 219 */           double d1 = this.heightMap[i1 + i2];
/* 220 */           double d2 = this.heightMap[j1 + i2];
/* 221 */           double d3 = this.heightMap[k1 + i2];
/* 222 */           double d4 = this.heightMap[l1 + i2];
/* 223 */           double d5 = (this.heightMap[i1 + i2 + 1] - d1) * 0.125D;
/* 224 */           double d6 = (this.heightMap[j1 + i2 + 1] - d2) * 0.125D;
/* 225 */           double d7 = (this.heightMap[k1 + i2 + 1] - d3) * 0.125D;
/* 226 */           double d8 = (this.heightMap[l1 + i2 + 1] - d4) * 0.125D;
/* 227 */           for (int j2 = 0; j2 < 8; j2++) {
/*     */             
/* 229 */             double d9 = 0.25D;
/* 230 */             double d10 = d1;
/* 231 */             double d11 = d2;
/* 232 */             double d12 = (d3 - d1) * 0.25D;
/* 233 */             double d13 = (d4 - d2) * 0.25D;
/*     */             
/* 235 */             for (int k2 = 0; k2 < 4; k2++) {
/*     */               
/* 237 */               double d14 = 0.25D;
/* 238 */               double d16 = (d11 - d10) * 0.25D;
/* 239 */               double lvt_45_1_ = d10 - d16;
/*     */               
/* 241 */               for (int l2 = 0; l2 < 4; l2++) {
/*     */                 
/* 243 */                 if ((lvt_45_1_ += d16) > 0.0D) {
/*     */                   
/* 245 */                   chunkPrimer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, Blocks.STONE.getDefaultState());
/*     */                 }
/* 247 */                 else if (i2 * 8 + j2 < 63) {
/*     */                   
/* 249 */                   chunkPrimer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, Blocks.WATER.getDefaultState());
/*     */                 } 
/*     */               } 
/*     */               
/* 253 */               d10 += d12;
/* 254 */               d11 += d13;
/*     */             } 
/*     */             
/* 257 */             d1 += d5;
/* 258 */             d2 += d6;
/* 259 */             d3 += d7;
/* 260 */             d4 += d8;
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
/* 271 */     this.depthRegion = this.depth.generateNoiseOctaves(this.depthRegion, x, z, 5, 5, 200.0D, 200.0D, 0.5D);
/* 272 */     float coordScale = 684.412F;
/* 273 */     float heightScale = 684.412F;
/* 274 */     this.mainNoiseRegion = this.mainPerlinNoise.generateNoiseOctaves(this.mainNoiseRegion, x, y, z, 5, 33, 5, 8.55515D, 4.277575D, 8.55515D);
/* 275 */     this.minLimitRegion = this.minLimitPerlinNoise.generateNoiseOctaves(this.minLimitRegion, x, y, z, 5, 33, 5, coordScale, heightScale, coordScale);
/* 276 */     this.maxLimitRegion = this.maxLimitPerlinNoise.generateNoiseOctaves(this.maxLimitRegion, x, y, z, 5, 33, 5, coordScale, heightScale, coordScale);
/*     */     
/* 278 */     int i = 0;
/* 279 */     int j = 0;
/* 280 */     for (int k = 0; k < 5; k++) {
/*     */       
/* 282 */       for (int l = 0; l < 5; l++) {
/*     */         
/* 284 */         float f2 = 0.0F;
/* 285 */         float f3 = 0.0F;
/* 286 */         float f4 = 0.0F;
/* 287 */         int i1 = 2;
/*     */         
/* 289 */         Biome surroundingBiome = this.biomesForGeneration[k + 2 + (l + 2) * 10];
/*     */         
/* 291 */         for (int j1 = -i1; j1 < i1; j1++) {
/*     */           
/* 293 */           for (int k1 = -i1; k1 <= i1; k1++) {
/*     */             
/* 295 */             Biome biome = this.biomesForGeneration[k + j1 + 2 + (l + k1 + 2) * 10];
/*     */             
/* 297 */             float baseHeight = biome.getBaseHeight();
/* 298 */             float heightVariation = biome.getHeightVariation();
/* 299 */             float f7 = this.parabolicField[j1 + 2 + (k1 + 2) * 5] / (baseHeight + 2.0F);
/* 300 */             if (biome.getBaseHeight() > surroundingBiome.getBaseHeight())
/*     */             {
/* 302 */               f7 /= 2.0F;
/*     */             }
/*     */             
/* 305 */             f2 += heightVariation * f7;
/* 306 */             f3 += baseHeight * f7;
/* 307 */             f4 += f7;
/*     */           } 
/*     */         } 
/* 310 */         f2 /= f4;
/* 311 */         f3 /= f4;
/*     */         
/* 313 */         f2 = f2 * 0.9F + 0.1F;
/* 314 */         f3 = (f3 * 4.0F - 1.0F) / 8.0F;
/* 315 */         double d7 = this.depthRegion[j] / 8000.0D;
/* 316 */         if (d7 < 0.0D)
/*     */         {
/* 318 */           d7 = -d7 * 0.3D;
/*     */         }
/*     */         
/* 321 */         if (d7 < 0.0D) {
/*     */           
/* 323 */           d7 /= 2.0D;
/* 324 */           if (d7 < -1.0D)
/*     */           {
/* 326 */             d7 = -1.0D;
/*     */           }
/* 328 */           d7 /= 1.4D;
/* 329 */           d7 /= 2.0D;
/*     */         }
/*     */         else {
/*     */           
/* 333 */           if (d7 > 1.0D)
/*     */           {
/* 335 */             d7 = 1.0D;
/*     */           }
/* 337 */           d7 /= 8.0D;
/*     */         } 
/* 339 */         j++;
/*     */         
/* 341 */         double d8 = f3;
/* 342 */         double d9 = f2;
/* 343 */         d8 += d7 * 0.2D;
/* 344 */         d8 = d8 * 8.5D / 8.0D;
/* 345 */         double d0 = 8.5D + d8 * 4.0D;
/* 346 */         for (int l1 = 0; l1 < 33; l1++) {
/* 347 */           double d1 = (l1 - d0) * 12.0D * 128.0D / 256.0D / d9;
/* 348 */           if (d1 < 0.0D) {
/* 349 */             d1 *= 4.0D;
/*     */           }
/* 351 */           double d2 = this.minLimitRegion[i] / 512.0D;
/* 352 */           double d3 = this.maxLimitRegion[i] / 512.0D;
/* 353 */           double d4 = (this.mainNoiseRegion[i] / 10.0D + 1.0D) / 2.0D;
/* 354 */           double d5 = MathHelper.clampedLerp(d2, d3, d4) - d1;
/* 355 */           if (l1 > 29) {
/* 356 */             double d6 = ((l1 - 29) / 3.0F);
/* 357 */             d5 = d5 * (1.0D - d6) + -10.0D * d6;
/*     */           } 
/* 359 */           this.heightMap[i] = d5;
/* 360 */           i++;
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
/* 372 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockPos getNearestStructurePos(World arg0, String arg1, BlockPos arg2, boolean arg3) {
/* 379 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
/* 385 */     Biome biome = this.world.getBiome(pos);
/*     */     
/* 387 */     return biome.getSpawnableList(creatureType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInsideStructure(World arg0, String arg1, BlockPos arg2) {
/* 394 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void populate(int x, int z) {
/* 400 */     BlockFalling.fallInstantly = true;
/* 401 */     int i = x * 16;
/* 402 */     int j = z * 16;
/* 403 */     BlockPos blockpos = new BlockPos(i, 0, j);
/* 404 */     Biome biome = this.world.getBiome(blockpos.add(16, 0, 16));
/*     */     
/* 406 */     ForgeEventFactory.onChunkPopulate(true, this, this.world, this.rand, x, z, false);
/*     */     
/* 408 */     biome.decorate(this.world, this.rand, blockpos);
/*     */ 
/*     */     
/* 411 */     ForgeEventFactory.onChunkPopulate(false, this, this.world, this.rand, x, z, false);
/*     */     
/* 413 */     BlockFalling.fallInstantly = false;
/*     */   }
/*     */   
/*     */   public void recreateStructures(Chunk arg0, int arg1, int arg2) {}
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\world\dimension\mining\ChunkGeneratorMiningDimension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */