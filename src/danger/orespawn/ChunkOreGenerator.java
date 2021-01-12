/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChunkOreGenerator
/*     */ {
/*     */   public void generateOresInChunk(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
/*  19 */     if (OreSpawnMain.SpawnOres_stats.rate > 0) {
/*     */       
/*  21 */       int j = OreSpawnMain.SpawnOres_stats.rate + random.nextInt(30);
/*  22 */       if (random.nextInt(20) == 0) {
/*  23 */         j += 30;
/*     */       }
/*  25 */       if (OreSpawnMain.LessOre != 0) j /= 3; 
/*  26 */       for (int k = 0; k < j; k++) {
/*  27 */         int randPosX = 3 + chunkX + random.nextInt(10);
/*  28 */         int randPosY = random.nextInt(128);
/*  29 */         int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  30 */         if (randPosY <= OreSpawnMain.SpawnOres_stats.maxdepth && randPosY >= OreSpawnMain.SpawnOres_stats.mindepth) {
/*  31 */           if (random.nextInt(104) < 7) {
/*  32 */             int m = random.nextInt(7);
/*  33 */             Block b = Blocks.air;
/*  34 */             switch (m) { case 0:
/*  35 */                 b = OreSpawnMain.MyBrutalflySpawnBlock; break;
/*  36 */               case 1: b = OreSpawnMain.MyNastysaurusSpawnBlock; break;
/*  37 */               case 2: b = OreSpawnMain.MyPointysaurusSpawnBlock; break;
/*  38 */               case 3: b = OreSpawnMain.MyCricketSpawnBlock; break;
/*  39 */               case 4: b = OreSpawnMain.MyFrogSpawnBlock; break;
/*  40 */               case 5: b = OreSpawnMain.MySpiderDriverSpawnBlock; break;
/*  41 */               case 6: b = OreSpawnMain.MyCrabSpawnBlock;
/*     */                 break; }
/*     */             
/*  44 */             generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, b, OreSpawnMain.SpawnOres_stats.clumpsize);
/*     */           } else {
/*  46 */             int m = random.nextInt(98);
/*  47 */             Block b = Blocks.air;
/*  48 */             switch (m) { case 0:
/*  49 */                 b = OreSpawnMain.MySpiderSpawnBlock; break;
/*  50 */               case 1: b = OreSpawnMain.MyBatSpawnBlock; break;
/*  51 */               case 2: b = OreSpawnMain.MyCowSpawnBlock; break;
/*  52 */               case 3: b = OreSpawnMain.MyPigSpawnBlock; break;
/*  53 */               case 4: b = OreSpawnMain.MySquidSpawnBlock; break;
/*  54 */               case 5: b = OreSpawnMain.MyChickenSpawnBlock; break;
/*  55 */               case 6: b = OreSpawnMain.MyCreeperSpawnBlock; break;
/*  56 */               case 7: b = OreSpawnMain.MySkeletonSpawnBlock; break;
/*  57 */               case 8: b = OreSpawnMain.MyZombieSpawnBlock; break;
/*  58 */               case 9: b = OreSpawnMain.MySlimeSpawnBlock; break;
/*  59 */               case 10: b = OreSpawnMain.MyGhastSpawnBlock; break;
/*  60 */               case 11: b = OreSpawnMain.MyZombiePigmanSpawnBlock; break;
/*  61 */               case 12: b = OreSpawnMain.MyEndermanSpawnBlock; break;
/*  62 */               case 13: b = OreSpawnMain.MyCaveSpiderSpawnBlock; break;
/*  63 */               case 14: b = OreSpawnMain.MySilverfishSpawnBlock; break;
/*  64 */               case 15: b = OreSpawnMain.MyMagmaCubeSpawnBlock; break;
/*  65 */               case 16: b = OreSpawnMain.MyWitchSpawnBlock; break;
/*  66 */               case 17: b = OreSpawnMain.MySheepSpawnBlock; break;
/*  67 */               case 18: b = OreSpawnMain.MyWolfSpawnBlock; break;
/*  68 */               case 19: b = OreSpawnMain.MyMooshroomSpawnBlock; break;
/*  69 */               case 20: b = OreSpawnMain.MyOcelotSpawnBlock; break;
/*  70 */               case 21: b = OreSpawnMain.MyBlazeSpawnBlock; break;
/*  71 */               case 22: b = OreSpawnMain.MyWitherSkeletonSpawnBlock; break;
/*  72 */               case 23: b = OreSpawnMain.MyEnderDragonSpawnBlock; break;
/*  73 */               case 24: b = OreSpawnMain.MySnowGolemSpawnBlock; break;
/*  74 */               case 25: b = OreSpawnMain.MyIronGolemSpawnBlock; break;
/*  75 */               case 26: b = OreSpawnMain.MyWitherBossSpawnBlock; break;
/*  76 */               case 27: b = OreSpawnMain.MyGirlfriendSpawnBlock; break;
/*  77 */               case 28: b = OreSpawnMain.MyRedCowSpawnBlock; break;
/*  78 */               case 29: b = OreSpawnMain.MyGoldCowSpawnBlock; break;
/*  79 */               case 30: b = OreSpawnMain.MyEnchantedCowSpawnBlock; break;
/*  80 */               case 31: b = OreSpawnMain.MyMOTHRASpawnBlock; break;
/*  81 */               case 32: b = OreSpawnMain.MyAloSpawnBlock; break;
/*  82 */               case 33: b = OreSpawnMain.MyCryoSpawnBlock; break;
/*  83 */               case 34: b = OreSpawnMain.MyCamaSpawnBlock; break;
/*  84 */               case 35: b = OreSpawnMain.MyVeloSpawnBlock; break;
/*  85 */               case 36: b = OreSpawnMain.MyHydroSpawnBlock; break;
/*  86 */               case 37: b = OreSpawnMain.MyBasilSpawnBlock; break;
/*  87 */               case 38: b = OreSpawnMain.MyDragonflySpawnBlock; break;
/*  88 */               case 39: b = OreSpawnMain.MyEmperorScorpionSpawnBlock; break;
/*  89 */               case 40: b = OreSpawnMain.MyScorpionSpawnBlock; break;
/*  90 */               case 41: b = OreSpawnMain.MyCaveFisherSpawnBlock; break;
/*  91 */               case 42: b = OreSpawnMain.MySpyroSpawnBlock; break;
/*  92 */               case 43: b = OreSpawnMain.MyBaryonyxSpawnBlock; break;
/*  93 */               case 44: b = OreSpawnMain.MyGammaMetroidSpawnBlock; break;
/*  94 */               case 45: b = OreSpawnMain.MyCockateilSpawnBlock; break;
/*  95 */               case 46: b = OreSpawnMain.MyKyuubiSpawnBlock; break;
/*  96 */               case 47: b = OreSpawnMain.MyAlienSpawnBlock; break;
/*  97 */               case 48: b = OreSpawnMain.MyAttackSquidSpawnBlock; break;
/*  98 */               case 49: b = OreSpawnMain.MyWaterDragonSpawnBlock; break;
/*  99 */               case 50: b = OreSpawnMain.MyKrakenSpawnBlock; break;
/* 100 */               case 51: b = OreSpawnMain.MyLizardSpawnBlock; break;
/* 101 */               case 52: b = OreSpawnMain.MyCephadromeSpawnBlock; break;
/* 102 */               case 53: b = OreSpawnMain.MyDragonSpawnBlock; break;
/* 103 */               case 54: b = OreSpawnMain.MyBeeSpawnBlock; break;
/* 104 */               case 55: b = OreSpawnMain.MyHorseSpawnBlock; break;
/* 105 */               case 56: b = OreSpawnMain.MyTrooperBugSpawnBlock; break;
/* 106 */               case 57: b = OreSpawnMain.MySpitBugSpawnBlock; break;
/* 107 */               case 58: b = OreSpawnMain.MyStinkBugSpawnBlock; break;
/* 108 */               case 59: b = OreSpawnMain.MyOstrichSpawnBlock; break;
/* 109 */               case 60: b = OreSpawnMain.MyGazelleSpawnBlock; break;
/* 110 */               case 61: b = OreSpawnMain.MyChipmunkSpawnBlock; break;
/* 111 */               case 62: b = OreSpawnMain.MyCreepingHorrorSpawnBlock; break;
/* 112 */               case 63: b = OreSpawnMain.MyTerribleTerrorSpawnBlock; break;
/* 113 */               case 64: b = OreSpawnMain.MyCliffRacerSpawnBlock; break;
/* 114 */               case 65: b = OreSpawnMain.MyTriffidSpawnBlock; break;
/* 115 */               case 66: b = OreSpawnMain.MyPitchBlackSpawnBlock; break;
/* 116 */               case 67: b = OreSpawnMain.MyLurkingTerrorSpawnBlock; break;
/* 117 */               case 68: b = OreSpawnMain.MyGodzillaPartSpawnBlock; break;
/* 118 */               case 69: b = OreSpawnMain.MyGodzillaSpawnBlock; break;
/* 119 */               case 70: b = OreSpawnMain.MySmallWormSpawnBlock; break;
/* 120 */               case 71: b = OreSpawnMain.MyMediumWormSpawnBlock; break;
/* 121 */               case 72: b = OreSpawnMain.MyLargeWormSpawnBlock; break;
/* 122 */               case 73: b = OreSpawnMain.MyCassowarySpawnBlock; break;
/* 123 */               case 74: b = OreSpawnMain.MyCloudSharkSpawnBlock; break;
/* 124 */               case 75: b = OreSpawnMain.MyGoldFishSpawnBlock; break;
/* 125 */               case 76: b = OreSpawnMain.MyLeafMonsterSpawnBlock; break;
/* 126 */               case 77: b = OreSpawnMain.MyTshirtSpawnBlock; break;
/* 127 */               case 78: b = OreSpawnMain.MyEnderKnightSpawnBlock; break;
/* 128 */               case 79: b = OreSpawnMain.MyEnderReaperSpawnBlock; break;
/* 129 */               case 80: b = OreSpawnMain.MyBeaverSpawnBlock; break;
/* 130 */               case 81: b = OreSpawnMain.MyTRexSpawnBlock; break;
/* 131 */               case 82: b = OreSpawnMain.MyHerculesSpawnBlock; break;
/* 132 */               case 83: b = OreSpawnMain.MyMantisSpawnBlock; break;
/* 133 */               case 84: b = OreSpawnMain.MyStinkySpawnBlock; break;
/* 134 */               case 85: b = OreSpawnMain.MyBoyfriendSpawnBlock; break;
/* 135 */               case 86: b = OreSpawnMain.MyTheKingPartSpawnBlock; break;
/* 136 */               case 87: b = OreSpawnMain.MyEasterBunnySpawnBlock; break;
/* 137 */               case 88: b = OreSpawnMain.MyCaterKillerSpawnBlock; break;
/* 138 */               case 89: b = OreSpawnMain.MyMolenoidSpawnBlock; break;
/* 139 */               case 90: b = OreSpawnMain.MySeaMonsterSpawnBlock; break;
/* 140 */               case 91: b = OreSpawnMain.MySeaViperSpawnBlock; break;
/* 141 */               case 92: b = OreSpawnMain.MyLeonSpawnBlock; break;
/* 142 */               case 93: b = OreSpawnMain.MyHammerheadSpawnBlock; break;
/* 143 */               case 94: b = OreSpawnMain.MyRubberDuckySpawnBlock; break;
/* 144 */               case 95: b = OreSpawnMain.MyVillagerSpawnBlock; break;
/* 145 */               case 96: b = OreSpawnMain.MyCriminalSpawnBlock; break;
/* 146 */               case 97: b = OreSpawnMain.MyTheQueenPartSpawnBlock;
/*     */                 break; }
/*     */             
/* 149 */             generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, b, OreSpawnMain.SpawnOres_stats.clumpsize);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     if (OreSpawnMain.Uranium_stats.rate > 0) {
/* 159 */       int j = OreSpawnMain.Uranium_stats.rate + random.nextInt(9);
/* 160 */       if (OreSpawnMain.LessOre != 0) j /= 3; 
/* 161 */       for (int k = 0; k < j; k++) {
/* 162 */         int randPosX = 3 + chunkX + random.nextInt(10);
/* 163 */         int randPosY = random.nextInt(128);
/* 164 */         int randPosZ = 3 + chunkZ + random.nextInt(10);
/* 165 */         if (randPosY <= OreSpawnMain.Uranium_stats.maxdepth && randPosY >= OreSpawnMain.Uranium_stats.mindepth) {
/* 166 */           generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.MyOreUraniumBlock, OreSpawnMain.Uranium_stats.clumpsize);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 172 */     if (OreSpawnMain.Titanium_stats.rate > 0) {
/* 173 */       int j = OreSpawnMain.Titanium_stats.rate + random.nextInt(9);
/* 174 */       if (OreSpawnMain.LessOre != 0) j /= 3; 
/* 175 */       for (int k = 0; k < j; k++) {
/* 176 */         int randPosX = 3 + chunkX + random.nextInt(10);
/* 177 */         int randPosY = random.nextInt(128);
/* 178 */         int randPosZ = 3 + chunkZ + random.nextInt(10);
/* 179 */         if (randPosY <= OreSpawnMain.Titanium_stats.maxdepth && randPosY >= OreSpawnMain.Titanium_stats.mindepth) {
/* 180 */           generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.MyOreTitaniumBlock, OreSpawnMain.Titanium_stats.clumpsize);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 186 */     if (OreSpawnMain.Amethyst_stats.rate > 0) {
/* 187 */       int j = OreSpawnMain.Amethyst_stats.rate + random.nextInt(12);
/* 188 */       if (OreSpawnMain.LessOre != 0) j /= 3; 
/* 189 */       for (int k = 0; k < j; k++) {
/* 190 */         int randPosX = 3 + chunkX + random.nextInt(10);
/* 191 */         int randPosY = random.nextInt(128);
/* 192 */         int randPosZ = 3 + chunkZ + random.nextInt(10);
/* 193 */         if (randPosY <= OreSpawnMain.Amethyst_stats.maxdepth && randPosY >= OreSpawnMain.Amethyst_stats.mindepth) {
/* 194 */           generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.MyOreAmethystBlock, OreSpawnMain.Amethyst_stats.clumpsize);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 200 */     if (OreSpawnMain.Salt_stats.rate > 0) {
/* 201 */       int j = OreSpawnMain.Salt_stats.rate + random.nextInt(9);
/* 202 */       if (OreSpawnMain.LessOre != 0) j /= 3; 
/* 203 */       for (int k = 0; k < j; k++) {
/* 204 */         int randPosX = 3 + chunkX + random.nextInt(10);
/* 205 */         int randPosY = random.nextInt(128);
/* 206 */         int randPosZ = 3 + chunkZ + random.nextInt(10);
/* 207 */         if (randPosY <= OreSpawnMain.Salt_stats.maxdepth && randPosY >= OreSpawnMain.Salt_stats.mindepth) {
/* 208 */           generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.MyOreSaltBlock, OreSpawnMain.Salt_stats.clumpsize);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 213 */     int patchy = 4 + random.nextInt(4);
/* 214 */     if (OreSpawnMain.LessOre != 0) patchy /= 2;  int i;
/* 215 */     for (i = 0; i < patchy; i++) {
/* 216 */       int randPosX = 3 + chunkX + random.nextInt(10);
/* 217 */       int randPosY = random.nextInt(128);
/* 218 */       int randPosZ = 3 + chunkZ + random.nextInt(10);
/* 219 */       if (randPosY <= 50 && randPosY >= 5) {
/* 220 */         generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.RedAntTroll, 4);
/*     */       }
/*     */     } 
/*     */     
/* 224 */     patchy = 4 + random.nextInt(4);
/* 225 */     if (OreSpawnMain.LessOre != 0) patchy /= 2; 
/* 226 */     for (i = 0; i < patchy; i++) {
/* 227 */       int randPosX = 3 + chunkX + random.nextInt(10);
/* 228 */       int randPosY = random.nextInt(128);
/* 229 */       int randPosZ = 3 + chunkZ + random.nextInt(10);
/* 230 */       if (randPosY <= 50 && randPosY >= 5) {
/* 231 */         generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.TermiteTroll, 4);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 237 */     if (OreSpawnMain.LessOre == 0) {
/*     */ 
/*     */       
/* 240 */       if (OreSpawnMain.Diamond_stats.rate > 0) {
/* 241 */         for (i = 0; i < OreSpawnMain.Diamond_stats.rate; i++) {
/* 242 */           int randPosX = 3 + chunkX + random.nextInt(10);
/* 243 */           int randPosY = random.nextInt(128);
/* 244 */           int randPosZ = 3 + chunkZ + random.nextInt(10);
/* 245 */           if (randPosY <= OreSpawnMain.Diamond_stats.maxdepth && randPosY >= OreSpawnMain.Diamond_stats.mindepth) {
/* 246 */             generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, Blocks.diamond_ore, OreSpawnMain.Diamond_stats.clumpsize);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 251 */       if (OreSpawnMain.BlkDiamond_stats.rate > 0) {
/* 252 */         for (i = 0; i < OreSpawnMain.BlkDiamond_stats.rate; i++) {
/* 253 */           int randPosX = 3 + chunkX + random.nextInt(10);
/* 254 */           int randPosY = random.nextInt(128);
/* 255 */           int randPosZ = 3 + chunkZ + random.nextInt(10);
/* 256 */           if (randPosY <= OreSpawnMain.BlkDiamond_stats.maxdepth && randPosY >= OreSpawnMain.BlkDiamond_stats.mindepth) {
/* 257 */             generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, Blocks.diamond_block, OreSpawnMain.BlkDiamond_stats.clumpsize);
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 263 */       if (OreSpawnMain.Emerald_stats.rate > 0) {
/* 264 */         for (i = 0; i < OreSpawnMain.Emerald_stats.rate; i++) {
/* 265 */           int randPosX = 3 + chunkX + random.nextInt(10);
/* 266 */           int randPosY = random.nextInt(128);
/* 267 */           int randPosZ = 3 + chunkZ + random.nextInt(10);
/* 268 */           if (randPosY <= OreSpawnMain.Emerald_stats.maxdepth && randPosY >= OreSpawnMain.Emerald_stats.mindepth) {
/* 269 */             generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, Blocks.emerald_ore, OreSpawnMain.Emerald_stats.clumpsize);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 274 */       if (OreSpawnMain.BlkEmerald_stats.rate > 0) {
/* 275 */         for (i = 0; i < OreSpawnMain.BlkEmerald_stats.rate; i++) {
/* 276 */           int randPosX = 3 + chunkX + random.nextInt(10);
/* 277 */           int randPosY = random.nextInt(128);
/* 278 */           int randPosZ = 3 + chunkZ + random.nextInt(10);
/* 279 */           if (randPosY <= OreSpawnMain.BlkEmerald_stats.maxdepth && randPosY >= OreSpawnMain.BlkEmerald_stats.mindepth) {
/* 280 */             generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, Blocks.emerald_block, OreSpawnMain.BlkEmerald_stats.clumpsize);
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 286 */       if (OreSpawnMain.Gold_stats.rate > 0) {
/* 287 */         for (i = 0; i < OreSpawnMain.Gold_stats.rate; i++) {
/* 288 */           int randPosX = 3 + chunkX + random.nextInt(10);
/* 289 */           int randPosY = random.nextInt(128);
/* 290 */           int randPosZ = 3 + chunkZ + random.nextInt(10);
/* 291 */           if (randPosY <= OreSpawnMain.Gold_stats.maxdepth && randPosY >= OreSpawnMain.Gold_stats.mindepth) {
/* 292 */             generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, Blocks.gold_ore, OreSpawnMain.Gold_stats.clumpsize);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 297 */       if (OreSpawnMain.BlkGold_stats.rate > 0) {
/* 298 */         for (i = 0; i < OreSpawnMain.BlkGold_stats.rate; i++) {
/* 299 */           int randPosX = 3 + chunkX + random.nextInt(10);
/* 300 */           int randPosY = random.nextInt(128);
/* 301 */           int randPosZ = 3 + chunkZ + random.nextInt(10);
/* 302 */           if (randPosY <= OreSpawnMain.BlkGold_stats.maxdepth && randPosY >= OreSpawnMain.BlkGold_stats.mindepth) {
/* 303 */             generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, Blocks.gold_block, OreSpawnMain.BlkGold_stats.clumpsize);
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 310 */       if (OreSpawnMain.BlkRuby_stats.rate > 0) {
/* 311 */         for (i = 0; i < OreSpawnMain.BlkRuby_stats.rate; i++) {
/* 312 */           int randPosX = 3 + chunkX + random.nextInt(10);
/* 313 */           int randPosY = random.nextInt(128);
/* 314 */           int randPosZ = 3 + chunkZ + random.nextInt(10);
/* 315 */           if (randPosY <= OreSpawnMain.BlkRuby_stats.maxdepth && randPosY >= OreSpawnMain.BlkRuby_stats.mindepth) {
/* 316 */             generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.MyBlockRubyBlock, OreSpawnMain.BlkRuby_stats.clumpsize);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean generateBlockOre(World par1World, Random par2Random, int par3, int par4, int par5, Chunk chunk, Block newbid, int numberOfBlocks) {
/* 325 */     float f = par2Random.nextFloat() * 3.1415927F;
/* 326 */     double d0 = ((par3 + 8) + MathHelper.sin(f) * numberOfBlocks / 8.0F);
/* 327 */     double d1 = ((par3 + 8) - MathHelper.sin(f) * numberOfBlocks / 8.0F);
/* 328 */     double d2 = ((par5 + 8) + MathHelper.cos(f) * numberOfBlocks / 8.0F);
/* 329 */     double d3 = ((par5 + 8) - MathHelper.cos(f) * numberOfBlocks / 8.0F);
/* 330 */     double d4 = (par4 + par2Random.nextInt(3) - 2);
/* 331 */     double d5 = (par4 + par2Random.nextInt(3) - 2);
/*     */     
/* 333 */     for (int l = 0; l <= numberOfBlocks; l++) {
/*     */       
/* 335 */       double d6 = d0 + (d1 - d0) * l / numberOfBlocks;
/* 336 */       double d7 = d4 + (d5 - d4) * l / numberOfBlocks;
/* 337 */       double d8 = d2 + (d3 - d2) * l / numberOfBlocks;
/* 338 */       double d9 = par2Random.nextDouble() * numberOfBlocks / 16.0D;
/* 339 */       double d10 = (MathHelper.sin(l * 3.1415927F / numberOfBlocks) + 1.0F) * d9 + 1.0D;
/* 340 */       double d11 = (MathHelper.sin(l * 3.1415927F / numberOfBlocks) + 1.0F) * d9 + 1.0D;
/* 341 */       int i1 = MathHelper.floor_double(d6 - d10 / 2.0D);
/* 342 */       int j1 = MathHelper.floor_double(d7 - d11 / 2.0D);
/* 343 */       int k1 = MathHelper.floor_double(d8 - d10 / 2.0D);
/* 344 */       int l1 = MathHelper.floor_double(d6 + d10 / 2.0D);
/* 345 */       int i2 = MathHelper.floor_double(d7 + d11 / 2.0D);
/* 346 */       int j2 = MathHelper.floor_double(d8 + d10 / 2.0D);
/*     */       
/* 348 */       for (int k2 = i1; k2 <= l1; k2++) {
/*     */         
/* 350 */         double d12 = (k2 + 0.5D - d6) / d10 / 2.0D;
/*     */         
/* 352 */         if (d12 * d12 < 1.0D)
/*     */         {
/* 354 */           for (int l2 = j1; l2 <= i2; l2++) {
/*     */             
/* 356 */             double d13 = (l2 + 0.5D - d7) / d11 / 2.0D;
/*     */             
/* 358 */             if (d12 * d12 + d13 * d13 < 1.0D)
/*     */             {
/* 360 */               for (int i3 = k1; i3 <= j2; i3++) {
/*     */                 
/* 362 */                 double d14 = (i3 + 0.5D - d8) / d10 / 2.0D;
/*     */                 
/* 364 */                 Block bid = OreSpawnMain.getBlockIDInChunk(chunk, k2, l2, i3);
/*     */                 
/* 366 */                 if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && bid == Blocks.stone)
/*     */                 {
/* 368 */                   OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, k2, l2, i3, newbid, 0);
/*     */                 }
/*     */               } 
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 377 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ChunkOreGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */