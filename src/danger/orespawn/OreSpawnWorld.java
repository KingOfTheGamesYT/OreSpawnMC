/*      */ package danger.orespawn;
/*      */ 
/*      */ import cpw.mods.fml.common.IWorldGenerator;
/*      */ import java.util.Random;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.BlockLeaves;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityList;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.inventory.IInventory;
/*      */ import net.minecraft.tileentity.TileEntityChest;
/*      */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*      */ import net.minecraft.util.WeightedRandomChestContent;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.biome.BiomeGenBase;
/*      */ import net.minecraft.world.chunk.Chunk;
/*      */ import net.minecraft.world.chunk.IChunkProvider;
/*      */ import net.minecraft.world.gen.feature.WorldGenMinable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class OreSpawnWorld
/*      */   implements IWorldGenerator
/*      */ {
/*   29 */   public static int recently_placed = 50;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
/*   40 */     if (world.isRemote)
/*      */       return; 
/*   42 */     Chunk chunk = world.getChunkFromChunkCoords(chunkX, chunkZ);
/*      */     
/*   44 */     if (recently_placed > 0) {
/*   45 */       recently_placed--;
/*      */     }
/*      */ 
/*      */     
/*   49 */     if (world.provider.dimensionId == OreSpawnMain.DimensionID) {
/*      */ 
/*      */ 
/*      */       
/*   53 */       generateSurface(world, random, chunkX * 16, chunkZ * 16);
/*      */ 
/*      */       
/*   56 */       if (false == addHugeTree(world, random, chunkX * 16, chunkZ * 16, chunk)) {
/*      */         
/*   58 */         if (false == addAppleTrees(world, random, chunkX * 16, chunkZ * 16, chunk))
/*      */         {
/*   60 */           if (false == addOtherTrees(world, random, chunkX * 16, chunkZ * 16) && 
/*   61 */             recently_placed == 0) addKingAltar(world, random, chunkX * 16, chunkZ * 16);
/*      */         
/*      */         }
/*      */         
/*   65 */         addVeggies(world, random, chunkX * 16, chunkZ * 16);
/*      */       } 
/*      */       
/*   68 */       boolean rbd = false;
/*   69 */       rbd = addRubyDungeon(world, random, chunkX * 16, chunkZ * 16);
/*   70 */       if (!rbd) {
/*   71 */         addGenericDungeon(world, random, chunkX * 16, chunkZ * 16);
/*      */       }
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*   78 */     if (world.provider.dimensionId == OreSpawnMain.DimensionID2) {
/*      */ 
/*      */       
/*   81 */       generateRuby(world, random, chunkX * 16, chunkZ * 16);
/*      */       
/*   83 */       if (OreSpawnMain.LessOre == 0) {
/*      */ 
/*      */         
/*   86 */         generateRuby(world, random, chunkX * 16, chunkZ * 16);
/*   87 */         generateRuby(world, random, chunkX * 16, chunkZ * 16);
/*      */         
/*      */         int i;
/*   90 */         for (i = 0; i < 45; i++) {
/*   91 */           int randPosX = chunkX * 16 + random.nextInt(16);
/*   92 */           int randPosY = random.nextInt(128);
/*   93 */           int randPosZ = chunkZ * 16 + random.nextInt(16);
/*   94 */           if (randPosY < 50) {
/*   95 */             (new WorldGenMinable(Blocks.lapis_ore, 7)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */           }
/*      */         } 
/*   98 */         for (i = 0; i < 25; i++) {
/*   99 */           int randPosX = chunkX * 16 + random.nextInt(16);
/*  100 */           int randPosY = random.nextInt(128);
/*  101 */           int randPosZ = chunkZ * 16 + random.nextInt(16);
/*  102 */           if (randPosY < 50) {
/*  103 */             (new WorldGenMinable(Blocks.lapis_ore, 4)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */           }
/*      */         } 
/*      */       } 
/*  107 */       if (recently_placed == 0 && random.nextInt(95) == 1) {
/*      */         
/*  109 */         int i = random.nextInt(7);
/*  110 */         if (i == 0) addBasiliskMaze(world, random, chunkX * 16, chunkZ * 16); 
/*  111 */         if (i == 1) addKyuubiDungeon(world, random, chunkX * 16, chunkZ * 16); 
/*  112 */         if (i == 2) addBeeHive(world, random, chunkX * 16, chunkZ * 16); 
/*  113 */         if (i == 3) addShadowDungeon(world, random, chunkX * 16, chunkZ * 16); 
/*  114 */         if (i == 4) addAlienWTF(world, random, chunkX * 16, chunkZ * 16); 
/*  115 */         if (i == 5) addEnderKnight(world, random, chunkX * 16, chunkZ * 16); 
/*  116 */         if (i == 6) addLeonNest(world, random, chunkX * 16, chunkZ * 16);
/*      */       
/*      */       } else {
/*  119 */         addGenericDungeon(world, random, chunkX * 16, chunkZ * 16);
/*      */       } 
/*      */ 
/*      */       
/*  123 */       addLavaAndWater(world, random, chunkX * 16, chunkZ * 16);
/*      */       
/*  125 */       addAnts(world, random, chunkX * 16, chunkZ * 16, 2);
/*  126 */       addAnts(world, random, chunkX * 16, chunkZ * 16, 2);
/*      */ 
/*      */       
/*  129 */       addMosquitos(world, random, chunkX * 16, chunkZ * 16);
/*  130 */       addMosquitos(world, random, chunkX * 16, chunkZ * 16);
/*      */ 
/*      */       
/*  133 */       addVeggies(world, random, chunkX * 16, chunkZ * 16);
/*  134 */       addRocks(world, random, chunkX * 16, chunkZ * 16);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  140 */     if (world.provider.dimensionId == OreSpawnMain.DimensionID3) {
/*      */ 
/*      */       
/*  143 */       if (OreSpawnMain.MosquitoEnable != 0) {
/*  144 */         addMosquitos(world, random, chunkX, chunkZ);
/*      */       }
/*  146 */       addAnts(world, random, chunkX * 16, chunkZ * 16, 4);
/*  147 */       addAppleTrees(world, random, chunkX * 16, chunkZ * 16, chunk);
/*  148 */       addGenericDungeon(world, random, chunkX * 16, chunkZ * 16);
/*      */       
/*  150 */       if (recently_placed == 0) addDamselInDistress(world, random, chunkX * 16, chunkZ * 16); 
/*  151 */       if (recently_placed == 0) addSpiderHangout(world, random, chunkX * 16, chunkZ * 16); 
/*  152 */       if (recently_placed == 0) addRedAntHangout(world, random, chunkX * 16, chunkZ * 16);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  158 */     if (world.provider.dimensionId == OreSpawnMain.DimensionID4) {
/*      */ 
/*      */       
/*  161 */       if (recently_placed == 0 && random.nextInt(100) == 0 && 
/*  162 */         D4BigSpaceCheck(world, chunkX * 16, 7, chunkZ * 16) == true) {
/*  163 */         int j = random.nextInt(19);
/*  164 */         if (j < 3) {
/*  165 */           addD4Castle(world, random, chunkX * 16, chunkZ * 16);
/*  166 */         } else if (j < 7) {
/*  167 */           addD4GenericDungeon(world, random, chunkX * 16, chunkZ * 16);
/*      */         } else {
/*  169 */           if (j == 7) addD4EnderCastle(world, random, chunkX * 16, chunkZ * 16); 
/*  170 */           if (j == 8) addD4IncaPyramid(world, random, chunkX * 16, chunkZ * 16); 
/*  171 */           if (j == 9) addD4RobotLab(world, random, chunkX * 16, chunkZ * 16); 
/*  172 */           if (j == 10) addD4Mini(world, random, chunkX * 16, chunkZ * 16); 
/*  173 */           if (j == 11) addD4RubyDungeon(world, random, chunkX * 16, chunkZ * 16); 
/*  174 */           if (j == 12) addD4CephadromeAltar(world, random, chunkX * 16, chunkZ * 16); 
/*  175 */           if (j == 13) addD4Greenhouse(world, random, chunkX * 16, chunkZ * 16); 
/*  176 */           if (j == 14) addD4NightmareRookery(world, random, chunkX * 16, chunkZ * 16); 
/*  177 */           if (j == 15) addD4StinkyHouse(world, random, chunkX * 16, chunkZ * 16); 
/*  178 */           if (j == 16) addD4WhiteHouse(world, random, chunkX * 16, chunkZ * 16); 
/*  179 */           if (j == 17) addPumpkin(world, random, chunkX * 16, chunkZ * 16); 
/*  180 */           if (j == 18) addD4Rainbow(world, random, chunkX * 16, chunkZ * 16);
/*      */         
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  186 */       int i = random.nextInt(300);
/*  187 */       if (i == 0) addD4CloudShark(world, random, chunkX * 16, chunkZ * 16); 
/*  188 */       addUnstableAnts(world, random, chunkX * 16, chunkZ * 16);
/*  189 */       addIslands(world, random, chunkX * 16, chunkZ * 16);
/*  190 */       addD4Rocks(world, random, chunkX * 16, chunkZ * 16);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  196 */     if (world.provider.dimensionId == OreSpawnMain.DimensionID5) {
/*      */       
/*  198 */       if (!addFairyTree(world, random, chunkX * 16, chunkZ * 16)) {
/*  199 */         addCrystalTermites(world, random, chunkX * 16, chunkZ * 16);
/*  200 */         if (recently_placed == 0) {
/*  201 */           if (!addRotatorStation(world, random, chunkX * 16, chunkZ * 16) && 
/*  202 */             !addUrchinSpawner(world, random, chunkX * 16, chunkZ * 16) && 
/*  203 */             !addCrystalHauntedHouse(world, random, chunkX * 16, chunkZ * 16) && 
/*  204 */             !addRoundRotator(world, random, chunkX * 16, chunkZ * 16)) {
/*  205 */             addCrystalBattleTower(world, random, chunkX * 16, chunkZ * 16);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*  210 */           addIrukandji(world, random, chunkX * 16, chunkZ * 16);
/*      */         } 
/*      */       } 
/*  213 */       addCrystalChestsAndSpawners(world, random, chunkX * 16, chunkZ * 16);
/*  214 */       if (world.rand.nextInt(4) == 1) addRocks(world, random, chunkX * 16, chunkZ * 16);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*  219 */     if (world.provider.dimensionId == OreSpawnMain.DimensionID6) {
/*  220 */       addButterfliesAndMoths(world, random, chunkX * 16, chunkZ * 16);
/*  221 */       addVeggies(world, random, chunkX * 16, chunkZ * 16);
/*  222 */       addAnts(world, random, chunkX * 16, chunkZ * 16, 2);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  228 */     switch (world.provider.dimensionId) {
/*      */       case -1:
/*  230 */         generateNether(world, random, chunkX * 16, chunkZ * 16);
/*      */         break;
/*      */       case 0:
/*  233 */         generateSurface(world, random, chunkX * 16, chunkZ * 16);
/*      */ 
/*      */ 
/*      */         
/*  237 */         generateOres(world, random, chunkX * 16, chunkZ * 16);
/*      */         break;
/*      */       case 1:
/*  240 */         generateEnd(world, random, chunkX * 16, chunkZ * 16);
/*      */         break;
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
/*      */   
/*      */   private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
/*  256 */     addEndAnts(world, random, chunkX, chunkZ);
/*  257 */     int i = world.rand.nextInt(4);
/*  258 */     if (i == 0) addEndKnights(world, random, chunkX, chunkZ); 
/*  259 */     if (i == 1) addEndReapers(world, random, chunkX, chunkZ); 
/*  260 */     if (i == 2) addHospital(world, random, chunkX, chunkZ); 
/*  261 */     if (i == 3) addEnderCastle(world, random, chunkX, chunkZ);
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void generateNether(World world, Random random, int chunkX, int chunkZ) {
/*  270 */     if (OreSpawnMain.MosquitoEnable != 0) {
/*  271 */       addNetherMosquitos(world, random, chunkX, chunkZ);
/*      */     }
/*  273 */     addNetherAnts(world, random, chunkX, chunkZ);
/*      */     
/*  275 */     int patchy = 15 + random.nextInt(10);
/*  276 */     if (OreSpawnMain.LessOre != 0) patchy /= 3;  int i;
/*  277 */     for (i = 0; i < patchy; i++) {
/*  278 */       int randPosX = 3 + chunkX + random.nextInt(13);
/*  279 */       int randPosY = random.nextInt(108) + 10;
/*  280 */       int randPosZ = 3 + chunkZ + random.nextInt(13);
/*  281 */       (new WorldGenMinable(OreSpawnMain.MyLavafoamBlock, 6, Blocks.netherrack)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */     } 
/*      */ 
/*      */     
/*  285 */     patchy = 5 + random.nextInt(5);
/*  286 */     if (OreSpawnMain.LessOre != 0) patchy /= 3; 
/*  287 */     for (i = 0; i < patchy; i++) {
/*  288 */       int randPosX = 3 + chunkX + random.nextInt(13);
/*  289 */       int randPosY = random.nextInt(108) + 10;
/*  290 */       int randPosZ = 3 + chunkZ + random.nextInt(13);
/*  291 */       (new WorldGenMinable(OreSpawnMain.MyOreRubyBlock, 2, Blocks.netherrack)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
/*  298 */     boolean ahh = false;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  303 */     addStrawberries(world, random, chunkX, chunkZ);
/*  304 */     addCorn(world, random, chunkX, chunkZ);
/*  305 */     addTomatoes(world, random, chunkX, chunkZ);
/*  306 */     addVeggies(world, random, chunkX, chunkZ);
/*      */ 
/*      */ 
/*      */     
/*  310 */     addButterfliesAndMoths(world, random, chunkX, chunkZ);
/*  311 */     if (OreSpawnMain.MosquitoEnable != 0) {
/*  312 */       addMosquitos(world, random, chunkX, chunkZ);
/*      */     }
/*      */     
/*  315 */     if (OreSpawnMain.DisableOverworldDungeons == 0 && world.provider.dimensionId == 0 && 
/*  316 */       recently_placed == 0) {
/*  317 */       int i = world.rand.nextInt(6);
/*  318 */       if (i == 0) addPlayPool(world, random, chunkX, chunkZ); 
/*  319 */       if (i == 1) addWaterDragonLair(world, random, chunkX, chunkZ); 
/*  320 */       if (i == 2) addGoldFishBowl(world, random, chunkX, chunkZ); 
/*  321 */       if (i == 3) addGirlfriendIsland(world, random, chunkX, chunkZ); 
/*  322 */       if (i == 4) addMonsterIsland(world, random, chunkX, chunkZ); 
/*  323 */       if (i == 5) addFrogPond(world, random, chunkX, chunkZ);
/*      */       
/*  325 */       ahh = addANest(world, random, chunkX, chunkZ);
/*  326 */       if (!ahh) ahh = addHauntedHouse(world, random, chunkX, chunkZ); 
/*  327 */       if (!ahh) ahh = addLeafMonster(world, random, chunkX, chunkZ); 
/*  328 */       if (!ahh) ahh = addSpitBug(world, random, chunkX, chunkZ); 
/*  329 */       if (!ahh) ahh = addIgloo(world, random, chunkX, chunkZ); 
/*  330 */       if (!ahh) ahh = addBouncyCastle(world, random, chunkX, chunkZ); 
/*  331 */       if (!ahh) ahh = addRubberDuckyPond(world, random, chunkX, chunkZ);
/*      */     
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  337 */     addAnts(world, random, chunkX, chunkZ, 4);
/*      */     
/*  339 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/*  340 */     if (b.biomeName.equals("River") || b.biomeName.equals("Extreme Hills") || b.biomeName.equals("Desert")) {
/*  341 */       addRocks(world, random, chunkX, chunkZ);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void generateRuby(World world, Random random, int chunkX, int chunkZ) {
/*  350 */     if (OreSpawnMain.Ruby_stats.rate <= 0) {
/*      */       return;
/*      */     }
/*  353 */     int patchy = OreSpawnMain.Ruby_stats.rate + random.nextInt(7);
/*  354 */     for (int i = 0; i < patchy; i++) {
/*  355 */       int randPosX = 3 + chunkX + random.nextInt(10);
/*  356 */       int randPosY = random.nextInt(128);
/*  357 */       int randPosZ = 3 + chunkZ + random.nextInt(10);
/*      */ 
/*      */       
/*  360 */       if (randPosY <= OreSpawnMain.Ruby_stats.maxdepth && randPosY >= OreSpawnMain.Ruby_stats.mindepth) {
/*  361 */         for (int m = randPosY; m > 5; m--) {
/*  362 */           Block bid = world.getBlock(randPosX, m, randPosZ);
/*  363 */           if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
/*  364 */             bid = world.getBlock(randPosX, m - 1, randPosZ);
/*  365 */             if (bid == Blocks.stone) {
/*  366 */               OreSpawnMain.setBlockFast(world, randPosX, m - 1, randPosZ, OreSpawnMain.MyOreRubyBlock, 0, 2);
/*      */               break;
/*      */             } 
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
/*      */ 
/*      */   
/*      */   public void generateOres(World world, Random random, int chunkX, int chunkZ) {
/*  383 */     if (OreSpawnMain.SpawnOres_stats.rate > 0) {
/*      */       
/*  385 */       int j = OreSpawnMain.SpawnOres_stats.rate + random.nextInt(20);
/*  386 */       if (random.nextInt(20) == 0) {
/*  387 */         j += 30;
/*      */       }
/*  389 */       if (OreSpawnMain.LessOre != 0) j /= 3;
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
/*  406 */       for (int k = 0; k < j; k++) {
/*  407 */         int randPosX = 3 + chunkX + random.nextInt(10);
/*  408 */         int randPosY = random.nextInt(128);
/*  409 */         int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  410 */         if (randPosY <= OreSpawnMain.SpawnOres_stats.maxdepth && randPosY >= OreSpawnMain.SpawnOres_stats.mindepth) {
/*  411 */           if (random.nextInt(104) < 7) {
/*  412 */             int m = random.nextInt(7);
/*  413 */             Block b = Blocks.air;
/*  414 */             switch (m) { case 0:
/*  415 */                 b = OreSpawnMain.MyBrutalflySpawnBlock; break;
/*  416 */               case 1: b = OreSpawnMain.MyNastysaurusSpawnBlock; break;
/*  417 */               case 2: b = OreSpawnMain.MyPointysaurusSpawnBlock; break;
/*  418 */               case 3: b = OreSpawnMain.MyCricketSpawnBlock; break;
/*  419 */               case 4: b = OreSpawnMain.MyFrogSpawnBlock; break;
/*  420 */               case 5: b = OreSpawnMain.MySpiderDriverSpawnBlock; break;
/*  421 */               case 6: b = OreSpawnMain.MyCrabSpawnBlock;
/*      */                 break; }
/*      */             
/*  424 */             (new WorldGenMinable(b, OreSpawnMain.SpawnOres_stats.clumpsize)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */           } else {
/*      */             
/*  427 */             int m = random.nextInt(98);
/*  428 */             Block b = Blocks.air;
/*  429 */             switch (m) { case 0:
/*  430 */                 b = OreSpawnMain.MySpiderSpawnBlock; break;
/*  431 */               case 1: b = OreSpawnMain.MyBatSpawnBlock; break;
/*  432 */               case 2: b = OreSpawnMain.MyCowSpawnBlock; break;
/*  433 */               case 3: b = OreSpawnMain.MyPigSpawnBlock; break;
/*  434 */               case 4: b = OreSpawnMain.MySquidSpawnBlock; break;
/*  435 */               case 5: b = OreSpawnMain.MyChickenSpawnBlock; break;
/*  436 */               case 6: b = OreSpawnMain.MyCreeperSpawnBlock; break;
/*  437 */               case 7: b = OreSpawnMain.MySkeletonSpawnBlock; break;
/*  438 */               case 8: b = OreSpawnMain.MyZombieSpawnBlock; break;
/*  439 */               case 9: b = OreSpawnMain.MySlimeSpawnBlock; break;
/*  440 */               case 10: b = OreSpawnMain.MyGhastSpawnBlock; break;
/*  441 */               case 11: b = OreSpawnMain.MyZombiePigmanSpawnBlock; break;
/*  442 */               case 12: b = OreSpawnMain.MyEndermanSpawnBlock; break;
/*  443 */               case 13: b = OreSpawnMain.MyCaveSpiderSpawnBlock; break;
/*  444 */               case 14: b = OreSpawnMain.MySilverfishSpawnBlock; break;
/*  445 */               case 15: b = OreSpawnMain.MyMagmaCubeSpawnBlock; break;
/*  446 */               case 16: b = OreSpawnMain.MyWitchSpawnBlock; break;
/*  447 */               case 17: b = OreSpawnMain.MySheepSpawnBlock; break;
/*  448 */               case 18: b = OreSpawnMain.MyWolfSpawnBlock; break;
/*  449 */               case 19: b = OreSpawnMain.MyMooshroomSpawnBlock; break;
/*  450 */               case 20: b = OreSpawnMain.MyOcelotSpawnBlock; break;
/*  451 */               case 21: b = OreSpawnMain.MyBlazeSpawnBlock; break;
/*  452 */               case 22: b = OreSpawnMain.MyWitherSkeletonSpawnBlock; break;
/*  453 */               case 23: b = OreSpawnMain.MyEnderDragonSpawnBlock; break;
/*  454 */               case 24: b = OreSpawnMain.MySnowGolemSpawnBlock; break;
/*  455 */               case 25: b = OreSpawnMain.MyIronGolemSpawnBlock; break;
/*  456 */               case 26: b = OreSpawnMain.MyWitherBossSpawnBlock; break;
/*  457 */               case 27: b = OreSpawnMain.MyGirlfriendSpawnBlock; break;
/*  458 */               case 28: b = OreSpawnMain.MyRedCowSpawnBlock; break;
/*  459 */               case 29: b = OreSpawnMain.MyGoldCowSpawnBlock; break;
/*  460 */               case 30: b = OreSpawnMain.MyEnchantedCowSpawnBlock; break;
/*  461 */               case 31: b = OreSpawnMain.MyMOTHRASpawnBlock; break;
/*  462 */               case 32: b = OreSpawnMain.MyAloSpawnBlock; break;
/*  463 */               case 33: b = OreSpawnMain.MyCryoSpawnBlock; break;
/*  464 */               case 34: b = OreSpawnMain.MyCamaSpawnBlock; break;
/*  465 */               case 35: b = OreSpawnMain.MyVeloSpawnBlock; break;
/*  466 */               case 36: b = OreSpawnMain.MyHydroSpawnBlock; break;
/*  467 */               case 37: b = OreSpawnMain.MyBasilSpawnBlock; break;
/*  468 */               case 38: b = OreSpawnMain.MyDragonflySpawnBlock; break;
/*  469 */               case 39: b = OreSpawnMain.MyEmperorScorpionSpawnBlock; break;
/*  470 */               case 40: b = OreSpawnMain.MyScorpionSpawnBlock; break;
/*  471 */               case 41: b = OreSpawnMain.MyCaveFisherSpawnBlock; break;
/*  472 */               case 42: b = OreSpawnMain.MySpyroSpawnBlock; break;
/*  473 */               case 43: b = OreSpawnMain.MyBaryonyxSpawnBlock; break;
/*  474 */               case 44: b = OreSpawnMain.MyGammaMetroidSpawnBlock; break;
/*  475 */               case 45: b = OreSpawnMain.MyCockateilSpawnBlock; break;
/*  476 */               case 46: b = OreSpawnMain.MyKyuubiSpawnBlock; break;
/*  477 */               case 47: b = OreSpawnMain.MyAlienSpawnBlock; break;
/*  478 */               case 48: b = OreSpawnMain.MyAttackSquidSpawnBlock; break;
/*  479 */               case 49: b = OreSpawnMain.MyWaterDragonSpawnBlock; break;
/*  480 */               case 50: b = OreSpawnMain.MyKrakenSpawnBlock; break;
/*  481 */               case 51: b = OreSpawnMain.MyLizardSpawnBlock; break;
/*  482 */               case 52: b = OreSpawnMain.MyCephadromeSpawnBlock; break;
/*  483 */               case 53: b = OreSpawnMain.MyDragonSpawnBlock; break;
/*  484 */               case 54: b = OreSpawnMain.MyBeeSpawnBlock; break;
/*  485 */               case 55: b = OreSpawnMain.MyHorseSpawnBlock; break;
/*  486 */               case 56: b = OreSpawnMain.MyTrooperBugSpawnBlock; break;
/*  487 */               case 57: b = OreSpawnMain.MySpitBugSpawnBlock; break;
/*  488 */               case 58: b = OreSpawnMain.MyStinkBugSpawnBlock; break;
/*  489 */               case 59: b = OreSpawnMain.MyOstrichSpawnBlock; break;
/*  490 */               case 60: b = OreSpawnMain.MyGazelleSpawnBlock; break;
/*  491 */               case 61: b = OreSpawnMain.MyChipmunkSpawnBlock; break;
/*  492 */               case 62: b = OreSpawnMain.MyCreepingHorrorSpawnBlock; break;
/*  493 */               case 63: b = OreSpawnMain.MyTerribleTerrorSpawnBlock; break;
/*  494 */               case 64: b = OreSpawnMain.MyCliffRacerSpawnBlock; break;
/*  495 */               case 65: b = OreSpawnMain.MyTriffidSpawnBlock; break;
/*  496 */               case 66: b = OreSpawnMain.MyPitchBlackSpawnBlock; break;
/*  497 */               case 67: b = OreSpawnMain.MyLurkingTerrorSpawnBlock; break;
/*  498 */               case 68: b = OreSpawnMain.MyGodzillaPartSpawnBlock; break;
/*  499 */               case 69: b = OreSpawnMain.MyGodzillaSpawnBlock; break;
/*  500 */               case 70: b = OreSpawnMain.MySmallWormSpawnBlock; break;
/*  501 */               case 71: b = OreSpawnMain.MyMediumWormSpawnBlock; break;
/*  502 */               case 72: b = OreSpawnMain.MyLargeWormSpawnBlock; break;
/*  503 */               case 73: b = OreSpawnMain.MyCassowarySpawnBlock; break;
/*  504 */               case 74: b = OreSpawnMain.MyCloudSharkSpawnBlock; break;
/*  505 */               case 75: b = OreSpawnMain.MyGoldFishSpawnBlock; break;
/*  506 */               case 76: b = OreSpawnMain.MyLeafMonsterSpawnBlock; break;
/*  507 */               case 77: b = OreSpawnMain.MyTshirtSpawnBlock; break;
/*  508 */               case 78: b = OreSpawnMain.MyEnderKnightSpawnBlock; break;
/*  509 */               case 79: b = OreSpawnMain.MyEnderReaperSpawnBlock; break;
/*  510 */               case 80: b = OreSpawnMain.MyBeaverSpawnBlock; break;
/*  511 */               case 81: b = OreSpawnMain.MyTRexSpawnBlock; break;
/*  512 */               case 82: b = OreSpawnMain.MyHerculesSpawnBlock; break;
/*  513 */               case 83: b = OreSpawnMain.MyMantisSpawnBlock; break;
/*  514 */               case 84: b = OreSpawnMain.MyStinkySpawnBlock; break;
/*  515 */               case 85: b = OreSpawnMain.MyBoyfriendSpawnBlock; break;
/*  516 */               case 86: b = OreSpawnMain.MyTheKingPartSpawnBlock; break;
/*  517 */               case 87: b = OreSpawnMain.MyEasterBunnySpawnBlock; break;
/*  518 */               case 88: b = OreSpawnMain.MyCaterKillerSpawnBlock; break;
/*  519 */               case 89: b = OreSpawnMain.MyMolenoidSpawnBlock; break;
/*  520 */               case 90: b = OreSpawnMain.MySeaMonsterSpawnBlock; break;
/*  521 */               case 91: b = OreSpawnMain.MySeaViperSpawnBlock; break;
/*  522 */               case 92: b = OreSpawnMain.MyLeonSpawnBlock; break;
/*  523 */               case 93: b = OreSpawnMain.MyHammerheadSpawnBlock; break;
/*  524 */               case 94: b = OreSpawnMain.MyRubberDuckySpawnBlock; break;
/*  525 */               case 95: b = OreSpawnMain.MyVillagerSpawnBlock; break;
/*  526 */               case 96: b = OreSpawnMain.MyCriminalSpawnBlock; break;
/*  527 */               case 97: b = OreSpawnMain.MyTheQueenPartSpawnBlock;
/*      */                 break; }
/*      */             
/*  530 */             (new WorldGenMinable(b, OreSpawnMain.SpawnOres_stats.clumpsize)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  542 */     if (OreSpawnMain.Uranium_stats.rate > 0) {
/*  543 */       int j = OreSpawnMain.Uranium_stats.rate + random.nextInt(9);
/*  544 */       if (OreSpawnMain.LessOre != 0) j /= 3; 
/*  545 */       for (int k = 0; k < j; k++) {
/*  546 */         int randPosX = 3 + chunkX + random.nextInt(10);
/*  547 */         int randPosY = random.nextInt(128);
/*  548 */         int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  549 */         if (randPosY <= OreSpawnMain.Uranium_stats.maxdepth && randPosY >= OreSpawnMain.Uranium_stats.mindepth) {
/*  550 */           (new WorldGenMinable(OreSpawnMain.MyOreUraniumBlock, OreSpawnMain.Uranium_stats.clumpsize)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  556 */     if (OreSpawnMain.Titanium_stats.rate > 0) {
/*  557 */       int j = OreSpawnMain.Titanium_stats.rate + random.nextInt(9);
/*  558 */       if (OreSpawnMain.LessOre != 0) j /= 3; 
/*  559 */       for (int k = 0; k < j; k++) {
/*  560 */         int randPosX = 3 + chunkX + random.nextInt(10);
/*  561 */         int randPosY = random.nextInt(128);
/*  562 */         int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  563 */         if (randPosY <= OreSpawnMain.Titanium_stats.maxdepth && randPosY >= OreSpawnMain.Titanium_stats.mindepth) {
/*  564 */           (new WorldGenMinable(OreSpawnMain.MyOreTitaniumBlock, OreSpawnMain.Titanium_stats.clumpsize)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  570 */     if (OreSpawnMain.Amethyst_stats.rate > 0) {
/*  571 */       int j = OreSpawnMain.Amethyst_stats.rate + random.nextInt(12);
/*  572 */       if (OreSpawnMain.LessOre != 0) j /= 3; 
/*  573 */       for (int k = 0; k < j; k++) {
/*  574 */         int randPosX = 3 + chunkX + random.nextInt(10);
/*  575 */         int randPosY = random.nextInt(128);
/*  576 */         int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  577 */         if (randPosY <= OreSpawnMain.Amethyst_stats.maxdepth && randPosY >= OreSpawnMain.Amethyst_stats.mindepth) {
/*  578 */           (new WorldGenMinable(OreSpawnMain.MyOreAmethystBlock, OreSpawnMain.Amethyst_stats.clumpsize)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  584 */     if (OreSpawnMain.Salt_stats.rate > 0) {
/*  585 */       int j = OreSpawnMain.Salt_stats.rate + random.nextInt(9);
/*  586 */       if (OreSpawnMain.LessOre != 0) j /= 3; 
/*  587 */       for (int k = 0; k < j; k++) {
/*  588 */         int randPosX = 3 + chunkX + random.nextInt(10);
/*  589 */         int randPosY = random.nextInt(128);
/*  590 */         int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  591 */         if (randPosY <= OreSpawnMain.Salt_stats.maxdepth && randPosY >= OreSpawnMain.Salt_stats.mindepth) {
/*  592 */           (new WorldGenMinable(OreSpawnMain.MyOreSaltBlock, OreSpawnMain.Salt_stats.clumpsize)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  597 */     int patchy = 4 + random.nextInt(4);
/*  598 */     if (OreSpawnMain.LessOre != 0) patchy /= 2;  int i;
/*  599 */     for (i = 0; i < patchy; i++) {
/*  600 */       int randPosX = 3 + chunkX + random.nextInt(10);
/*  601 */       int randPosY = random.nextInt(128);
/*  602 */       int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  603 */       if (randPosY <= 50 && randPosY >= 5) {
/*  604 */         (new WorldGenMinable(OreSpawnMain.RedAntTroll, 4)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */       }
/*      */     } 
/*      */     
/*  608 */     patchy = 4 + random.nextInt(4);
/*  609 */     if (OreSpawnMain.LessOre != 0) patchy /= 2; 
/*  610 */     for (i = 0; i < patchy; i++) {
/*  611 */       int randPosX = 3 + chunkX + random.nextInt(10);
/*  612 */       int randPosY = random.nextInt(128);
/*  613 */       int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  614 */       if (randPosY <= 50 && randPosY >= 5) {
/*  615 */         (new WorldGenMinable(OreSpawnMain.TermiteTroll, 4)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  621 */     if (OreSpawnMain.Ruby_stats.rate > 0) {
/*  622 */       patchy = OreSpawnMain.Ruby_stats.rate + random.nextInt(5);
/*  623 */       for (i = 0; i < patchy; i++) {
/*  624 */         int randPosX = 3 + chunkX + random.nextInt(10);
/*  625 */         int randPosY = random.nextInt(128);
/*  626 */         int randPosZ = 3 + chunkZ + random.nextInt(10);
/*      */ 
/*      */         
/*  629 */         if (randPosY <= OreSpawnMain.Ruby_stats.maxdepth && randPosY >= OreSpawnMain.Ruby_stats.mindepth) {
/*  630 */           for (int m = randPosY; m > 5; m--) {
/*  631 */             Block bid = world.getBlock(randPosX, m, randPosZ);
/*  632 */             if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
/*  633 */               bid = world.getBlock(randPosX, m - 1, randPosZ);
/*  634 */               if (bid == Blocks.stone) {
/*  635 */                 OreSpawnMain.setBlockFast(world, randPosX, m - 1, randPosZ, OreSpawnMain.MyOreRubyBlock, 0, 2);
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  645 */     if (OreSpawnMain.LessOre == 0) {
/*      */ 
/*      */       
/*  648 */       if (OreSpawnMain.Diamond_stats.rate > 0) {
/*  649 */         for (i = 0; i < OreSpawnMain.Diamond_stats.rate; i++) {
/*  650 */           int randPosX = 3 + chunkX + random.nextInt(10);
/*  651 */           int randPosY = random.nextInt(128);
/*  652 */           int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  653 */           if (randPosY <= OreSpawnMain.Diamond_stats.maxdepth && randPosY >= OreSpawnMain.Diamond_stats.mindepth) {
/*  654 */             (new WorldGenMinable(Blocks.diamond_ore, OreSpawnMain.Diamond_stats.clumpsize)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */           }
/*      */         } 
/*      */       }
/*      */       
/*  659 */       if (OreSpawnMain.BlkDiamond_stats.rate > 0) {
/*  660 */         for (i = 0; i < OreSpawnMain.BlkDiamond_stats.rate; i++) {
/*  661 */           int randPosX = 3 + chunkX + random.nextInt(10);
/*  662 */           int randPosY = random.nextInt(128);
/*  663 */           int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  664 */           if (randPosY <= OreSpawnMain.BlkDiamond_stats.maxdepth && randPosY >= OreSpawnMain.BlkDiamond_stats.mindepth) {
/*  665 */             (new WorldGenMinable(Blocks.diamond_block, OreSpawnMain.BlkDiamond_stats.clumpsize)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  671 */       if (OreSpawnMain.Emerald_stats.rate > 0) {
/*  672 */         for (i = 0; i < OreSpawnMain.Emerald_stats.rate; i++) {
/*  673 */           int randPosX = 3 + chunkX + random.nextInt(10);
/*  674 */           int randPosY = random.nextInt(128);
/*  675 */           int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  676 */           if (randPosY <= OreSpawnMain.Emerald_stats.maxdepth && randPosY >= OreSpawnMain.Emerald_stats.mindepth) {
/*  677 */             (new WorldGenMinable(Blocks.emerald_ore, OreSpawnMain.Emerald_stats.clumpsize)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */           }
/*      */         } 
/*      */       }
/*      */       
/*  682 */       if (OreSpawnMain.BlkEmerald_stats.rate > 0) {
/*  683 */         for (i = 0; i < OreSpawnMain.BlkEmerald_stats.rate; i++) {
/*  684 */           int randPosX = 3 + chunkX + random.nextInt(10);
/*  685 */           int randPosY = random.nextInt(128);
/*  686 */           int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  687 */           if (randPosY <= OreSpawnMain.BlkEmerald_stats.maxdepth && randPosY >= OreSpawnMain.BlkEmerald_stats.mindepth) {
/*  688 */             (new WorldGenMinable(Blocks.emerald_block, OreSpawnMain.BlkEmerald_stats.clumpsize)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  694 */       if (OreSpawnMain.Gold_stats.rate > 0) {
/*  695 */         for (i = 0; i < OreSpawnMain.Gold_stats.rate; i++) {
/*  696 */           int randPosX = 3 + chunkX + random.nextInt(10);
/*  697 */           int randPosY = random.nextInt(128);
/*  698 */           int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  699 */           if (randPosY <= OreSpawnMain.Gold_stats.maxdepth && randPosY >= OreSpawnMain.Gold_stats.mindepth) {
/*  700 */             (new WorldGenMinable(Blocks.gold_ore, OreSpawnMain.Gold_stats.clumpsize)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */           }
/*      */         } 
/*      */       }
/*      */       
/*  705 */       if (OreSpawnMain.BlkGold_stats.rate > 0) {
/*  706 */         for (i = 0; i < OreSpawnMain.BlkGold_stats.rate; i++) {
/*  707 */           int randPosX = 3 + chunkX + random.nextInt(10);
/*  708 */           int randPosY = random.nextInt(128);
/*  709 */           int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  710 */           if (randPosY <= OreSpawnMain.BlkGold_stats.maxdepth && randPosY >= OreSpawnMain.BlkGold_stats.mindepth) {
/*  711 */             (new WorldGenMinable(Blocks.gold_block, OreSpawnMain.BlkGold_stats.clumpsize)).generate(world, random, randPosX, randPosY, randPosZ);
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  718 */       if (OreSpawnMain.BlkRuby_stats.rate > 0) {
/*  719 */         for (i = 0; i < OreSpawnMain.BlkRuby_stats.rate; i++) {
/*  720 */           int randPosX = 3 + chunkX + random.nextInt(10);
/*  721 */           int randPosY = random.nextInt(128);
/*  722 */           int randPosZ = 3 + chunkZ + random.nextInt(10);
/*  723 */           if (randPosY <= OreSpawnMain.BlkRuby_stats.maxdepth && randPosY >= OreSpawnMain.BlkRuby_stats.mindepth) {
/*  724 */             (new WorldGenMinable(OreSpawnMain.MyBlockRubyBlock, OreSpawnMain.BlkRuby_stats.clumpsize)).generate(world, random, randPosX, randPosY, randPosZ);
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
/*      */ 
/*      */   
/*      */   public void addStrawberries(World world, Random random, int chunkX, int chunkZ) {
/*  739 */     if (random.nextInt(20) != 0) {
/*      */       return;
/*      */     }
/*  742 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/*  743 */     if (world.provider.dimensionId == OreSpawnMain.DimensionID || b.biomeName.equals("Forest") || b.biomeName.equals("ForestHills") || b.biomeName.equals("Birch Forest Hills") || b.biomeName.equals("Birch Forest"))
/*      */     {
/*  745 */       for (int i = 0; i < 5; i++) {
/*  746 */         int posX = chunkX + random.nextInt(16);
/*  747 */         int posZ = chunkZ + random.nextInt(16);
/*  748 */         for (int posY = 100; posY > 40;) {
/*      */ 
/*      */           
/*  751 */           if (world.isAirBlock(posX, posY, posZ)) {
/*  752 */             if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/*      */ 
/*      */               
/*  755 */               OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyStrawberryPlant, 0, 2);
/*      */               break;
/*      */             } 
/*      */             posY--;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addHauntedHouse(World world, Random random, int chunkX, int chunkZ) {
/*  769 */     if (random.nextInt(285) != 0) return false;
/*      */ 
/*      */     
/*  772 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/*  773 */     if (b.biomeName.equals("Plains") || b.biomeName.equals("Taiga") || b.biomeName.equals("Swampland"))
/*      */     {
/*  775 */       for (int i = 0; i < 5; i++) {
/*  776 */         int posX = chunkX + random.nextInt(16);
/*  777 */         int posZ = chunkZ + random.nextInt(16);
/*  778 */         for (int posY = 100; posY > 40;) {
/*      */ 
/*      */           
/*  781 */           if (world.isAirBlock(posX, posY, posZ)) {
/*  782 */             if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/*      */               
/*  784 */               OreSpawnMain.MyDungeon.makeHauntedHouse(world, posX, posY, posZ);
/*  785 */               recently_placed = 50;
/*  786 */               return true;
/*      */             } 
/*      */             
/*      */             posY--;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*  794 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addANest(World world, Random random, int chunkX, int chunkZ) {
/*  800 */     if (random.nextInt(230) != 0) return false;
/*      */ 
/*      */     
/*  803 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/*  804 */     if (b.biomeName.equals("Forest") || b.biomeName.equals("ForestHills") || b.biomeName.equals("Jungle") || b.biomeName.equals("JungleHills") || b.biomeName.equals("Birch Forest") || b.biomeName.equals("Birch Forest Hills"))
/*      */     {
/*      */       
/*  807 */       for (int i = 0; i < 5; i++) {
/*  808 */         int posX = chunkX + random.nextInt(16);
/*  809 */         int posZ = chunkZ + random.nextInt(16);
/*  810 */         for (int posY = 128; posY > 40;) {
/*      */ 
/*      */           
/*  813 */           if (world.isAirBlock(posX, posY, posZ)) {
/*  814 */             if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/*      */               
/*  816 */               if (random.nextInt(2) == 0) {
/*  817 */                 OreSpawnMain.MyDungeon.makeSmallBeeHive(world, posX, posY, posZ);
/*      */               } else {
/*  819 */                 OreSpawnMain.MyDungeon.makeMantisHive(world, posX, posY, posZ);
/*      */               } 
/*  821 */               recently_placed = 50;
/*  822 */               return true;
/*      */             } 
/*      */             
/*      */             posY--;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*  831 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addCorn(World world, Random random, int chunkX, int chunkZ) {
/*  841 */     int is_all_air = 1;
/*      */     
/*  843 */     int nc = 6;
/*      */     
/*  845 */     if (random.nextInt(35) != 1)
/*      */       return; 
/*  847 */     if (OreSpawnMain.LessLag == 1) {
/*  848 */       nc = 5;
/*      */     }
/*  850 */     if (OreSpawnMain.LessLag == 2) {
/*  851 */       nc = 3;
/*      */     }
/*      */     
/*  854 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/*  855 */     if (world.provider.dimensionId == OreSpawnMain.DimensionID || world.provider.dimensionId == OreSpawnMain.DimensionID3 || b.biomeName.equals("Plains"))
/*      */     {
/*  857 */       for (int j = 0; j < nc; j++) {
/*  858 */         int posX = chunkX + random.nextInt(16);
/*  859 */         int posZ = chunkZ + random.nextInt(16);
/*  860 */         is_all_air = 1;
/*  861 */         for (int posY = 100; posY > 40;) {
/*      */ 
/*      */           
/*  864 */           if (world.isAirBlock(posX, posY, posZ)) {
/*  865 */             if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/*      */               int i;
/*      */               
/*  868 */               for (i = 1; i < 10; i++) {
/*  869 */                 if (!world.isAirBlock(posX, posY + i, posZ)) is_all_air = 0; 
/*      */               } 
/*  871 */               if (is_all_air != 0) {
/*      */                 
/*  873 */                 int corn_height = random.nextInt(5);
/*  874 */                 corn_height++;
/*      */                 
/*  876 */                 if (corn_height == 1)
/*      */                 {
/*  878 */                   OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyCornPlant1, 0, 2);
/*      */                 }
/*      */                 
/*  881 */                 if (corn_height == 2) {
/*      */                   
/*  883 */                   OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyCornPlant2, 0, 2);
/*  884 */                   OreSpawnMain.setBlockFast(world, posX, posY + 1, posZ, OreSpawnMain.MyCornPlant1, 0, 2);
/*      */                 } 
/*      */                 
/*  887 */                 if (corn_height > 2) {
/*      */                   
/*  889 */                   OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyCornPlant2, 0, 2);
/*  890 */                   for (i = 1; i < corn_height; i++)
/*      */                   {
/*  892 */                     OreSpawnMain.setBlockFast(world, posX, posY + i, posZ, OreSpawnMain.MyCornPlant4, 0, 2);
/*      */                   }
/*  894 */                   OreSpawnMain.setBlockFast(world, posX, posY + corn_height, posZ, OreSpawnMain.MyCornPlant1, 0, 2);
/*      */                 } 
/*      */               } 
/*      */               break;
/*      */             } 
/*      */             posY--;
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
/*      */ 
/*      */   
/*      */   public void addTomatoes(World world, Random random, int chunkX, int chunkZ) {
/*  914 */     int is_all_air = 1;
/*      */ 
/*      */     
/*  917 */     if (random.nextInt(70) != 1)
/*      */       return; 
/*  919 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/*  920 */     if (world.provider.dimensionId == OreSpawnMain.DimensionID || world.provider.dimensionId == OreSpawnMain.DimensionID3 || b.biomeName.equals("Plains"))
/*      */     {
/*  922 */       for (int j = 0; j < 5; j++) {
/*  923 */         int posX = chunkX + random.nextInt(16);
/*  924 */         int posZ = chunkZ + random.nextInt(16);
/*  925 */         is_all_air = 1;
/*  926 */         for (int posY = 100; posY > 40;) {
/*      */ 
/*      */           
/*  929 */           if (world.isAirBlock(posX, posY, posZ)) {
/*  930 */             if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/*      */               int i;
/*      */               
/*  933 */               for (i = 1; i < 10; i++) {
/*  934 */                 if (!world.isAirBlock(posX, posY + i, posZ)) is_all_air = 0; 
/*      */               } 
/*  936 */               if (is_all_air != 0) {
/*      */                 
/*  938 */                 int corn_height = random.nextInt(3);
/*  939 */                 corn_height++;
/*      */                 
/*  941 */                 if (corn_height == 1)
/*      */                 {
/*  943 */                   OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyTomatoPlant1, 0, 2);
/*      */                 }
/*      */                 
/*  946 */                 if (corn_height == 2) {
/*      */                   
/*  948 */                   OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyTomatoPlant2, 0, 2);
/*  949 */                   OreSpawnMain.setBlockFast(world, posX, posY + 1, posZ, OreSpawnMain.MyTomatoPlant1, 0, 2);
/*      */                 } 
/*      */                 
/*  952 */                 if (corn_height > 2) {
/*      */                   
/*  954 */                   OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyTomatoPlant3, 0, 2);
/*  955 */                   for (i = 1; i < corn_height; i++)
/*      */                   {
/*  957 */                     OreSpawnMain.setBlockFast(world, posX, posY + i, posZ, OreSpawnMain.MyTomatoPlant4, 0, 2);
/*      */                   }
/*  959 */                   OreSpawnMain.setBlockFast(world, posX, posY + corn_height, posZ, OreSpawnMain.MyTomatoPlant1, 0, 2);
/*      */                 } 
/*      */               } 
/*      */               break;
/*      */             } 
/*      */             posY--;
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
/*      */   public void addButterfliesAndMoths(World world, Random random, int chunkX, int chunkZ) {
/*  976 */     if (random.nextInt(10 + OreSpawnMain.LessLag * 2) != 0) {
/*      */       return;
/*      */     }
/*  979 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/*  980 */     if (world.provider.dimensionId == OreSpawnMain.DimensionID || world.provider.dimensionId == OreSpawnMain.DimensionID6 || b.biomeName.equals("Forest") || b.biomeName.equals("ForestHills") || b.biomeName.equals("River") || b.biomeName.equals("Jungle") || b.biomeName.equals("JungleHills") || b.biomeName.equals("Swampland") || b.biomeName.equals("Birch Forest") || b.biomeName.equals("Birch Forest Hills") || b.biomeName.equals("Roofed Forest"))
/*      */     {
/*      */ 
/*      */       
/*  984 */       for (int i = 0; i < 4; i++) {
/*  985 */         int posX = chunkX + random.nextInt(16);
/*  986 */         int posZ = chunkZ + random.nextInt(16);
/*  987 */         int which = 0;
/*  988 */         for (int posY = 100; posY > 40;) {
/*      */ 
/*      */           
/*  991 */           if (world.isAirBlock(posX, posY, posZ)) {
/*  992 */             if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/*  993 */               which = random.nextInt(3);
/*  994 */               if (which == 0) {
/*  995 */                 OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyButterflyPlant, 0, 2); break;
/*  996 */               }  if (which == 1) {
/*  997 */                 OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyMothPlant, 0, 2); break;
/*      */               } 
/*  999 */               OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyFireflyPlant, 0, 2);
/*      */               break;
/*      */             } 
/*      */             posY--;
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
/*      */   public void addPlayPool(World world, Random random, int chunkX, int chunkZ) {
/* 1014 */     if (random.nextInt(350) != 0) {
/*      */       return;
/*      */     }
/* 1017 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/* 1018 */     if (b.biomeName.equals("Ocean"))
/*      */     {
/* 1020 */       for (int i = 0; i < 4; i++) {
/* 1021 */         int posX = chunkX + random.nextInt(16);
/* 1022 */         int posZ = chunkZ + random.nextInt(16);
/* 1023 */         int which = 0;
/* 1024 */         for (int posY = 100; posY > 40; posY--) {
/*      */ 
/*      */           
/* 1027 */           if (world.getBlock(posX, posY, posZ) == Blocks.air && world.getBlock(posX, posY - 1, posZ) == Blocks.water) {
/*      */             
/* 1029 */             OreSpawnMain.MyDungeon.makePlayPool(world, posX, posY, posZ);
/* 1030 */             recently_placed = 50;
/*      */             return;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addFrogPond(World world, Random random, int chunkX, int chunkZ) {
/* 1041 */     if (random.nextInt(350) != 0) {
/*      */       return;
/*      */     }
/* 1044 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/* 1045 */     if (b.biomeName.equals("Plains"))
/*      */     {
/* 1047 */       for (int i = 0; i < 4; i++) {
/* 1048 */         int posX = chunkX + random.nextInt(16);
/* 1049 */         int posZ = chunkZ + random.nextInt(16);
/* 1050 */         int which = 0;
/* 1051 */         for (int posY = 100; posY > 40; posY--) {
/*      */ 
/*      */           
/* 1054 */           if (world.getBlock(posX, posY, posZ) == Blocks.air && world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/*      */             
/* 1056 */             OreSpawnMain.MyDungeon.makeFrogPond(world, posX, posY - 1, posZ);
/* 1057 */             recently_placed = 50;
/*      */             return;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addGoldFishBowl(World world, Random random, int chunkX, int chunkZ) {
/* 1068 */     if (random.nextInt(350) != 0) {
/*      */       return;
/*      */     }
/* 1071 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/* 1072 */     if (b.biomeName.equals("Ocean"))
/*      */     {
/* 1074 */       for (int i = 0; i < 4; i++) {
/* 1075 */         int posX = chunkX + random.nextInt(16);
/* 1076 */         int posZ = chunkZ + random.nextInt(16);
/* 1077 */         int which = 0;
/* 1078 */         for (int posY = 100; posY > 40; posY--) {
/*      */ 
/*      */           
/* 1081 */           if (world.getBlock(posX, posY, posZ) == Blocks.air && world.getBlock(posX, posY - 1, posZ) == Blocks.water) {
/*      */             
/* 1083 */             OreSpawnMain.MyDungeon.makeGoldFishBowl(world, posX, posY - 1, posZ);
/* 1084 */             recently_placed = 50;
/*      */             return;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addLeafMonster(World world, Random random, int chunkX, int chunkZ) {
/* 1095 */     if (random.nextInt(275) != 0) return false;
/*      */ 
/*      */     
/* 1098 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/* 1099 */     if (b.biomeName.equals("Plains"))
/*      */     {
/* 1101 */       for (int i = 0; i < 4; i++) {
/* 1102 */         int posX = chunkX + random.nextInt(16);
/* 1103 */         int posZ = chunkZ + random.nextInt(16);
/* 1104 */         int which = 0;
/* 1105 */         for (int posY = 100; posY > 40; posY--) {
/*      */ 
/*      */           
/* 1108 */           if (world.getBlock(posX, posY, posZ) == Blocks.air && world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/*      */             
/* 1110 */             OreSpawnMain.MyDungeon.makeLeafMonsterDungeon(world, posX, posY, posZ);
/* 1111 */             recently_placed = 50;
/* 1112 */             return true;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/* 1117 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addRubberDuckyPond(World world, Random random, int chunkX, int chunkZ) {
/* 1123 */     if (random.nextInt(275) != 0) return false;
/*      */ 
/*      */     
/* 1126 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/* 1127 */     if (b.biomeName.equals("Plains"))
/*      */     {
/* 1129 */       for (int i = 0; i < 4; i++) {
/* 1130 */         int posX = chunkX + random.nextInt(16);
/* 1131 */         int posZ = chunkZ + random.nextInt(16);
/* 1132 */         int which = 0;
/* 1133 */         for (int posY = 100; posY > 40; posY--) {
/*      */ 
/*      */           
/* 1136 */           if (world.getBlock(posX, posY, posZ) == Blocks.air && world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/*      */             
/* 1138 */             OreSpawnMain.MyDungeon.makeRubberDuckyPond(world, posX, posY, posZ);
/* 1139 */             recently_placed = 50;
/* 1140 */             return true;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/* 1145 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addSpitBug(World world, Random random, int chunkX, int chunkZ) {
/* 1151 */     if (random.nextInt(190) != 0) return false;
/*      */ 
/*      */     
/* 1154 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/* 1155 */     if (b.biomeName.equals("Swampland"))
/*      */     {
/* 1157 */       for (int i = 0; i < 4; i++) {
/* 1158 */         int posX = chunkX + random.nextInt(16);
/* 1159 */         int posZ = chunkZ + random.nextInt(16);
/* 1160 */         int which = 0;
/* 1161 */         for (int posY = 100; posY > 40; posY--) {
/*      */ 
/*      */           
/* 1164 */           if (world.getBlock(posX, posY, posZ) == Blocks.air && world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/*      */             
/* 1166 */             OreSpawnMain.MyDungeon.makeSpitBugLair(world, posX, posY, posZ);
/* 1167 */             recently_placed = 50;
/* 1168 */             return true;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/* 1173 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addIgloo(World world, Random random, int chunkX, int chunkZ) {
/* 1179 */     if (random.nextInt(220) != 0) return false;
/*      */ 
/*      */     
/* 1182 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/* 1183 */     if (b.biomeName.equals("Ice Plains"))
/*      */     {
/* 1185 */       for (int i = 0; i < 4; i++) {
/* 1186 */         int posX = chunkX + random.nextInt(16);
/* 1187 */         int posZ = chunkZ + random.nextInt(16);
/* 1188 */         int which = 0;
/* 1189 */         for (int posY = 100; posY > 40; posY--) {
/*      */ 
/*      */           
/* 1192 */           if (world.getBlock(posX, posY, posZ) == Blocks.air && world.getBlock(posX, posY - 1, posZ) == Blocks.snow) {
/*      */             
/* 1194 */             OreSpawnMain.MyDungeon.makeIgloo(world, posX, posY - 2, posZ);
/* 1195 */             recently_placed = 50;
/* 1196 */             return true;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/* 1201 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addBouncyCastle(World world, Random random, int chunkX, int chunkZ) {
/* 1207 */     if (random.nextInt(230) != 0) return false;
/*      */ 
/*      */     
/* 1210 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/* 1211 */     if (b.biomeName.equals("Desert"))
/*      */     {
/* 1213 */       for (int i = 0; i < 4; i++) {
/* 1214 */         int posX = chunkX + random.nextInt(16);
/* 1215 */         int posZ = chunkZ + random.nextInt(16);
/* 1216 */         int which = 0;
/* 1217 */         for (int posY = 100; posY > 40; posY--) {
/*      */ 
/*      */           
/* 1220 */           if (world.getBlock(posX, posY, posZ) == Blocks.air && world.getBlock(posX, posY - 1, posZ) == Blocks.sand) {
/*      */             
/* 1222 */             OreSpawnMain.MyDungeon.makeBouncyCastle(world, posX, posY - 1, posZ);
/* 1223 */             recently_placed = 50;
/* 1224 */             return true;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/* 1229 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addDamselInDistress(World world, Random random, int chunkX, int chunkZ) {
/* 1235 */     if (random.nextInt(250) != 0) return false;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1240 */     for (int i = 0; i < 4; i++) {
/* 1241 */       int posX = chunkX + random.nextInt(16);
/* 1242 */       int posZ = chunkZ + random.nextInt(16);
/* 1243 */       int which = 0;
/* 1244 */       for (int posY = 100; posY > 40; posY--) {
/*      */ 
/*      */         
/* 1247 */         if (world.getBlock(posX, posY, posZ) == Blocks.air && world.getBlock(posX, posY - 1, posZ) == Blocks.grass)
/*      */         {
/* 1249 */           if (quickSpaceCheck(world, posX, posY - 1, posZ)) {
/* 1250 */             OreSpawnMain.MyDungeon.makeDamselInDistress(world, posX, posY - 1, posZ);
/* 1251 */             recently_placed = 50;
/* 1252 */             return true;
/*      */           }  } 
/*      */       } 
/*      */     } 
/* 1256 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addSpiderHangout(World world, Random random, int chunkX, int chunkZ) {
/* 1262 */     if (random.nextInt(350) != 0) return false; 
/* 1263 */     if (OreSpawnMain.SpiderDriverEnable == 0) return false;
/*      */ 
/*      */ 
/*      */     
/* 1267 */     for (int i = 0; i < 4; i++) {
/* 1268 */       int posX = chunkX + random.nextInt(16);
/* 1269 */       int posZ = chunkZ + random.nextInt(16);
/* 1270 */       int which = 0;
/* 1271 */       for (int posY = 100; posY > 40; posY--) {
/*      */ 
/*      */         
/* 1274 */         if (world.getBlock(posX, posY, posZ) == Blocks.air && world.getBlock(posX, posY - 1, posZ) == Blocks.grass)
/*      */         {
/* 1276 */           if (quickSpaceCheck(world, posX, posY - 1, posZ)) {
/* 1277 */             OreSpawnMain.MyDungeon.makeSpiderHangout(world, posX, posY - 1, posZ);
/* 1278 */             recently_placed = 50;
/* 1279 */             return true;
/*      */           }  } 
/*      */       } 
/*      */     } 
/* 1283 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addRedAntHangout(World world, Random random, int chunkX, int chunkZ) {
/* 1289 */     if (random.nextInt(250) != 0) return false;
/*      */ 
/*      */ 
/*      */     
/* 1293 */     for (int i = 0; i < 4; i++) {
/* 1294 */       int posX = chunkX + random.nextInt(16);
/* 1295 */       int posZ = chunkZ + random.nextInt(16);
/* 1296 */       int which = 0;
/* 1297 */       for (int posY = 100; posY > 40; posY--) {
/*      */ 
/*      */         
/* 1300 */         if (world.getBlock(posX, posY, posZ) == Blocks.air && world.getBlock(posX, posY - 1, posZ) == Blocks.grass)
/*      */         {
/* 1302 */           if (quickSpaceCheck(world, posX, posY - 1, posZ)) {
/* 1303 */             OreSpawnMain.MyDungeon.makeRedAntHangout(world, posX, posY - 1, posZ);
/* 1304 */             recently_placed = 50;
/* 1305 */             return true;
/*      */           }  } 
/*      */       } 
/*      */     } 
/* 1309 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addWaterDragonLair(World world, Random random, int chunkX, int chunkZ) {
/* 1315 */     if (random.nextInt(350) != 0) {
/*      */       return;
/*      */     }
/* 1318 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/* 1319 */     if (b.biomeName.equals("Ocean"))
/*      */     {
/* 1321 */       for (int i = 0; i < 4; i++) {
/* 1322 */         int posX = chunkX + random.nextInt(16);
/* 1323 */         int posZ = chunkZ + random.nextInt(16);
/* 1324 */         int which = 0;
/* 1325 */         for (int posY = 100; posY > 40; posY--) {
/*      */ 
/*      */           
/* 1328 */           if (world.getBlock(posX, posY, posZ) == Blocks.air && world.getBlock(posX, posY - 1, posZ) == Blocks.water) {
/*      */             
/* 1330 */             OreSpawnMain.MyDungeon.makeWaterDragonLair(world, posX, posY - 1, posZ);
/* 1331 */             recently_placed = 50;
/*      */             return;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addGirlfriendIsland(World world, Random random, int chunkX, int chunkZ) {
/* 1342 */     if (random.nextInt(300) != 0) {
/*      */       return;
/*      */     }
/* 1345 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/* 1346 */     if (b.biomeName.equals("Ocean"))
/*      */     {
/* 1348 */       for (int i = 0; i < 4; i++) {
/* 1349 */         int posX = chunkX + random.nextInt(16);
/* 1350 */         int posZ = chunkZ + random.nextInt(16);
/* 1351 */         int which = 0;
/* 1352 */         for (int posY = 100; posY > 40; posY--) {
/*      */ 
/*      */           
/* 1355 */           if (world.getBlock(posX, posY, posZ) == Blocks.air && world.getBlock(posX, posY - 1, posZ) == Blocks.water) {
/*      */             
/* 1357 */             OreSpawnMain.MyDungeon.makeGirlfriendIsland(world, posX, posY - 1, posZ);
/* 1358 */             recently_placed = 50;
/*      */             return;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addMonsterIsland(World world, Random random, int chunkX, int chunkZ) {
/* 1369 */     if (random.nextInt(300) != 0) {
/*      */       return;
/*      */     }
/* 1372 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/* 1373 */     if (b.biomeName.equals("Ocean"))
/*      */     {
/* 1375 */       for (int i = 0; i < 4; i++) {
/* 1376 */         int posX = chunkX + random.nextInt(16);
/* 1377 */         int posZ = chunkZ + random.nextInt(16);
/* 1378 */         int which = 0;
/* 1379 */         for (int posY = 100; posY > 40; posY--) {
/*      */ 
/*      */           
/* 1382 */           if (world.getBlock(posX, posY, posZ) == Blocks.air && world.getBlock(posX, posY - 1, posZ) == Blocks.water) {
/*      */             
/* 1384 */             OreSpawnMain.MyDungeon.makeMonsterIsland(world, posX, posY - 1, posZ);
/* 1385 */             recently_placed = 50;
/*      */             return;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addMosquitos(World world, Random random, int chunkX, int chunkZ) {
/* 1397 */     if (random.nextInt(25 + OreSpawnMain.LessLag * 2) != 0)
/*      */       return; 
/* 1399 */     if ((world.provider.dimensionId == OreSpawnMain.DimensionID || world.provider.dimensionId == OreSpawnMain.DimensionID3) && 
/* 1400 */       random.nextInt(3) != 0) {
/*      */       return;
/*      */     }
/* 1403 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/* 1404 */     if (world.provider.dimensionId == OreSpawnMain.DimensionID || world.provider.dimensionId == OreSpawnMain.DimensionID2 || world.provider.dimensionId == OreSpawnMain.DimensionID3 || b.biomeName.equals("Jungle") || b.biomeName.equals("Swampland"))
/*      */     {
/* 1406 */       for (int i = 0; i < 2; i++) {
/* 1407 */         int posX = chunkX + random.nextInt(16);
/* 1408 */         int posZ = chunkZ + random.nextInt(16);
/* 1409 */         for (int posY = 100; posY > 40;) {
/*      */ 
/*      */           
/* 1412 */           if (world.isAirBlock(posX, posY, posZ)) {
/* 1413 */             if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/* 1414 */               OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyMosquitoPlant, 0, 2);
/*      */               break;
/*      */             } 
/*      */             posY--;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addNetherMosquitos(World world, Random random, int chunkX, int chunkZ) {
/* 1428 */     if (random.nextInt(25) != 0)
/*      */       return; 
/* 1430 */     for (int i = 0; i < 3; i++) {
/* 1431 */       int posX = chunkX + random.nextInt(16);
/* 1432 */       int posZ = chunkZ + random.nextInt(16);
/* 1433 */       for (int posY = 90; posY > 20; posY--) {
/*      */ 
/*      */         
/* 1436 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.netherrack) {
/*      */           
/* 1438 */           OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyMosquitoPlant, 0, 2);
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addNetherAnts(World world, Random random, int chunkX, int chunkZ) {
/* 1447 */     if (OreSpawnMain.RedAntEnable == 0) {
/*      */       return;
/*      */     }
/* 1450 */     if (random.nextInt(25) != 0)
/*      */       return; 
/* 1452 */     for (int i = 0; i < 3; i++) {
/* 1453 */       int posX = chunkX + random.nextInt(16);
/* 1454 */       int posZ = chunkZ + random.nextInt(16);
/* 1455 */       for (int posY = 90; posY > 20; posY--) {
/*      */ 
/*      */         
/* 1458 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.netherrack) {
/*      */           
/* 1460 */           OreSpawnMain.setBlockFast(world, posX, posY - 1, posZ, OreSpawnMain.MyRedAntBlock, 0, 2);
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
/*      */   public void addAnts(World world, Random random, int chunkX, int chunkZ, int redfreq) {
/* 1473 */     if (OreSpawnMain.RedAntEnable == 0 && OreSpawnMain.BlackAntEnable == 0 && OreSpawnMain.RainbowAntEnable == 0 && OreSpawnMain.UnstableAntEnable == 0)
/* 1474 */       return;  if (redfreq < 2) redfreq = 2;
/*      */     
/* 1476 */     if (random.nextInt(30 + OreSpawnMain.LessLag * 4) != 0)
/*      */       return; 
/* 1478 */     for (int i = 0; i < 4; i++) {
/* 1479 */       int posX = chunkX + random.nextInt(16);
/* 1480 */       int posZ = chunkZ + random.nextInt(16);
/* 1481 */       for (int posY = 100; posY > 40;) {
/*      */ 
/*      */         
/* 1484 */         if (world.isAirBlock(posX, posY, posZ)) {
/* 1485 */           if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/* 1486 */             if (random.nextInt(redfreq) == 0) {
/* 1487 */               int which = random.nextInt(4);
/* 1488 */               if (which == 0 && 
/* 1489 */                 OreSpawnMain.RedAntEnable != 0) {
/* 1490 */                 OreSpawnMain.setBlockFast(world, posX, posY - 1, posZ, OreSpawnMain.MyRedAntBlock, 0, 2);
/*      */               }
/* 1492 */               if (which == 1 && 
/* 1493 */                 OreSpawnMain.RainbowAntEnable != 0) {
/* 1494 */                 OreSpawnMain.setBlockFast(world, posX, posY - 1, posZ, OreSpawnMain.MyRainbowAntBlock, 0, 2);
/*      */               }
/* 1496 */               if (which == 2 && 
/* 1497 */                 OreSpawnMain.UnstableAntEnable != 0) {
/* 1498 */                 OreSpawnMain.setBlockFast(world, posX, posY - 1, posZ, OreSpawnMain.MyUnstableAntBlock, 0, 2);
/*      */               }
/* 1500 */               if (which == 3 && 
/* 1501 */                 OreSpawnMain.TermiteEnable != 0)
/* 1502 */                 OreSpawnMain.setBlockFast(world, posX, posY - 1, posZ, OreSpawnMain.TermiteBlock, 0, 2); 
/*      */               break;
/*      */             } 
/* 1505 */             if (OreSpawnMain.BlackAntEnable != 0) {
/* 1506 */               OreSpawnMain.setBlockFast(world, posX, posY - 1, posZ, OreSpawnMain.MyAntBlock, 0, 2);
/*      */             }
/*      */             break;
/*      */           } 
/*      */           posY--;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addEndAnts(World world, Random random, int chunkX, int chunkZ) {}
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
/*      */   public void addEndKnights(World world, Random random, int chunkX, int chunkZ) {
/* 1549 */     if (random.nextInt(25) != 0)
/*      */       return; 
/* 1551 */     for (int i = 0; i < 3; i++) {
/* 1552 */       int posX = chunkX + random.nextInt(16);
/* 1553 */       int posZ = chunkZ + random.nextInt(16);
/* 1554 */       for (int posY = 90; posY > 10; posY--) {
/*      */ 
/*      */         
/* 1557 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.end_stone)
/*      */         {
/* 1559 */           if (quickSpaceCheck(world, posX, posY, posZ)) {
/* 1560 */             OreSpawnMain.MyDungeon.makeEnderKnightDungeon(world, posX, posY, posZ);
/*      */             return;
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addEndReapers(World world, Random random, int chunkX, int chunkZ) {
/* 1571 */     if (random.nextInt(25) != 0)
/*      */       return; 
/* 1573 */     for (int i = 0; i < 3; i++) {
/* 1574 */       int posX = chunkX + random.nextInt(16);
/* 1575 */       int posZ = chunkZ + random.nextInt(16);
/* 1576 */       for (int posY = 90; posY > 10; posY--) {
/*      */ 
/*      */         
/* 1579 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.end_stone)
/*      */         {
/* 1581 */           if (quickSpaceCheck(world, posX, posY, posZ)) {
/* 1582 */             OreSpawnMain.MyDungeon.makeEnderReaperGraveyard(world, posX, posY, posZ);
/*      */             return;
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addHospital(World world, Random random, int chunkX, int chunkZ) {
/* 1593 */     if (random.nextInt(25) != 0)
/*      */       return; 
/* 1595 */     for (int i = 0; i < 3; i++) {
/* 1596 */       int posX = chunkX + random.nextInt(16);
/* 1597 */       int posZ = chunkZ + random.nextInt(16);
/* 1598 */       for (int posY = 90; posY > 10; posY--) {
/*      */ 
/*      */         
/* 1601 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.end_stone)
/*      */         {
/* 1603 */           if (quickSpaceCheck(world, posX, posY, posZ)) {
/* 1604 */             OreSpawnMain.MyDungeon.makeEnderDragonHospital(world, posX, posY, posZ);
/*      */             return;
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addEnderCastle(World world, Random random, int chunkX, int chunkZ) {
/* 1615 */     if (random.nextInt(50) != 0)
/*      */       return; 
/* 1617 */     for (int i = 0; i < 3; i++) {
/* 1618 */       int posX = chunkX + random.nextInt(16);
/* 1619 */       int posZ = chunkZ + random.nextInt(16);
/* 1620 */       for (int posY = 90; posY > 10; posY--) {
/*      */ 
/*      */         
/* 1623 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.end_stone)
/*      */         {
/* 1625 */           if (quickBigSpaceCheck(world, posX, posY, posZ)) {
/* 1626 */             OreSpawnMain.MyDungeon.makeEnderCastle(world, posX, posY, posZ);
/*      */             return;
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addUnstableAnts(World world, Random random, int chunkX, int chunkZ) {
/* 1638 */     if (OreSpawnMain.UnstableAntEnable == 0) {
/*      */       return;
/*      */     }
/* 1641 */     if (random.nextInt(30) != 0)
/*      */       return; 
/* 1643 */     for (int i = 0; i < 3; i++) {
/* 1644 */       int posX = chunkX + random.nextInt(16);
/* 1645 */       int posZ = chunkZ + random.nextInt(16);
/* 1646 */       for (int posY = 20; posY > 2;) {
/*      */         
/* 1648 */         if (world.isAirBlock(posX, posY, posZ)) {
/* 1649 */           if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/* 1650 */             OreSpawnMain.setBlockFast(world, posX, posY - 1, posZ, OreSpawnMain.MyUnstableAntBlock, 0, 2);
/*      */             break;
/*      */           } 
/*      */           posY--;
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
/*      */   public void addCrystalTermites(World world, Random random, int chunkX, int chunkZ) {
/* 1665 */     if (OreSpawnMain.TermiteEnable == 0) {
/*      */       return;
/*      */     }
/* 1668 */     if (random.nextInt(40) != 0)
/*      */       return; 
/* 1670 */     for (int i = 0; i < 3; i++) {
/* 1671 */       int posX = chunkX + random.nextInt(16);
/* 1672 */       int posZ = chunkZ + random.nextInt(16);
/* 1673 */       for (int posY = 100; posY > 50; posY--) {
/*      */         
/* 1675 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == OreSpawnMain.CrystalGrass) {
/*      */           
/* 1677 */           OreSpawnMain.setBlockFast(world, posX, posY - 1, posZ, OreSpawnMain.CrystalTermiteBlock, 0, 2);
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean addRotatorStation(World world, Random random, int chunkX, int chunkZ) {
/* 1686 */     if (OreSpawnMain.RotatorEnable == 0) return false;
/*      */ 
/*      */     
/* 1689 */     if (random.nextInt(150) != 0) return false;
/*      */ 
/*      */     
/* 1692 */     for (int i = 0; i < 3; i++) {
/* 1693 */       int posX = chunkX + random.nextInt(16);
/* 1694 */       int posZ = chunkZ + random.nextInt(16);
/* 1695 */       for (int posY = 100; posY > 50; posY--) {
/*      */         
/* 1697 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == OreSpawnMain.CrystalGrass) {
/*      */           
/* 1699 */           OreSpawnMain.MyDungeon.makeRotatorStation(world, posX, posY, posZ);
/* 1700 */           recently_placed = 50;
/* 1701 */           return true;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1705 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean addRoundRotator(World world, Random random, int chunkX, int chunkZ) {
/* 1710 */     if (OreSpawnMain.RotatorEnable == 0) return false;
/*      */ 
/*      */     
/* 1713 */     if (random.nextInt(150) != 0) return false;
/*      */ 
/*      */     
/* 1716 */     for (int i = 0; i < 3; i++) {
/* 1717 */       int posX = chunkX + random.nextInt(16);
/* 1718 */       int posZ = chunkZ + random.nextInt(16);
/* 1719 */       for (int posY = 100; posY > 50; posY--) {
/*      */         
/* 1721 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == OreSpawnMain.CrystalGrass) {
/*      */           
/* 1723 */           OreSpawnMain.MyDungeon.makeRoundRotator(world, posX, posY, posZ);
/* 1724 */           recently_placed = 50;
/* 1725 */           return true;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1729 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean addUrchinSpawner(World world, Random random, int chunkX, int chunkZ) {
/* 1734 */     if (OreSpawnMain.UrchinEnable == 0) return false;
/*      */ 
/*      */     
/* 1737 */     if (random.nextInt(180) != 0) return false;
/*      */ 
/*      */     
/* 1740 */     for (int i = 0; i < 3; i++) {
/* 1741 */       int posX = chunkX + random.nextInt(16);
/* 1742 */       int posZ = chunkZ + random.nextInt(16);
/* 1743 */       for (int posY = 100; posY > 50; posY--) {
/*      */         
/* 1745 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == OreSpawnMain.CrystalGrass) {
/*      */           
/* 1747 */           OreSpawnMain.MyDungeon.makeUrchinSpawner(world, posX, posY, posZ);
/* 1748 */           recently_placed = 50;
/* 1749 */           return true;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1753 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addCrystalHauntedHouse(World world, Random random, int chunkX, int chunkZ) {
/* 1760 */     if (random.nextInt(230) != 0) return false;
/*      */ 
/*      */     
/* 1763 */     for (int i = 0; i < 3; i++) {
/* 1764 */       int posX = chunkX + random.nextInt(16);
/* 1765 */       int posZ = chunkZ + random.nextInt(16);
/* 1766 */       for (int posY = 100; posY > 50; posY--) {
/*      */         
/* 1768 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == OreSpawnMain.CrystalGrass) {
/*      */           
/* 1770 */           OreSpawnMain.MyDungeon.makeCrystalHauntedHouse(world, posX, posY, posZ);
/* 1771 */           recently_placed = 50;
/* 1772 */           return true;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1776 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addCrystalBattleTower(World world, Random random, int chunkX, int chunkZ) {
/* 1783 */     if (random.nextInt(280) != 0) return false;
/*      */ 
/*      */     
/* 1786 */     for (int i = 0; i < 3; i++) {
/* 1787 */       int posX = chunkX + random.nextInt(16);
/* 1788 */       int posZ = chunkZ + random.nextInt(16);
/* 1789 */       for (int posY = 100; posY > 50; posY--) {
/*      */         
/* 1791 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == OreSpawnMain.CrystalGrass) {
/*      */           
/* 1793 */           OreSpawnMain.MyDungeon.makeCrystalBattleTower(world, posX, posY, posZ);
/* 1794 */           recently_placed = 50;
/* 1795 */           return true;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1799 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void addIrukandji(World world, Random random, int chunkX, int chunkZ) {
/* 1804 */     if (OreSpawnMain.IrukandjiEnable == 0) {
/*      */       return;
/*      */     }
/* 1807 */     if (random.nextInt(80) != 0) {
/*      */       return;
/*      */     }
/* 1810 */     for (int i = 0; i < 3; i++) {
/* 1811 */       int posX = chunkX + random.nextInt(16);
/* 1812 */       int posZ = chunkZ + random.nextInt(16);
/* 1813 */       for (int posY = 100; posY > 50; posY--) {
/*      */         
/* 1815 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.water) {
/*      */           
/* 1817 */           OreSpawnMain.setBlockFast(world, posX, posY, posZ, Blocks.mob_spawner, 0, 2);
/* 1818 */           TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(posX, posY, posZ);
/*      */           
/* 1820 */           if (tileentitymobspawner != null)
/*      */           {
/* 1822 */             tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Irukandji");
/*      */           }
/*      */           return;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addCrystalChestsAndSpawners(World world, Random random, int chunkX, int chunkZ) {
/* 1834 */     Block bid = Blocks.air;
/*      */     
/* 1836 */     for (int i = 0; i < 3; i++) {
/* 1837 */       int posX = 1 + chunkX + random.nextInt(14);
/* 1838 */       int posZ = 1 + chunkZ + random.nextInt(14);
/* 1839 */       int posY = 25;
/*      */       
/* 1841 */       if (world.isAirBlock(posX, posY, posZ)) {
/*      */         
/* 1843 */         bid = world.getBlock(posX, posY, posZ);
/* 1844 */         if (bid == Blocks.air) {
/* 1845 */           bid = world.getBlock(posX + 1, posY, posZ);
/* 1846 */           if (bid == Blocks.air) {
/* 1847 */             addCrystalChest(world, posX, posY, posZ, 5); break;
/*      */           } 
/* 1849 */           bid = world.getBlock(posX - 1, posY, posZ);
/* 1850 */           if (bid == Blocks.air) {
/* 1851 */             addCrystalChest(world, posX, posY, posZ, 4); break;
/*      */           } 
/* 1853 */           bid = world.getBlock(posX, posY, posZ + 1);
/* 1854 */           if (bid == Blocks.air) {
/* 1855 */             addCrystalChest(world, posX, posY, posZ, 2); break;
/*      */           } 
/* 1857 */           bid = world.getBlock(posX, posY, posZ - 1);
/* 1858 */           if (bid == Blocks.air) {
/* 1859 */             addCrystalChest(world, posX, posY, posZ, 3);
/*      */           }
/*      */         } 
/*      */         break;
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
/*      */   public void addCrystalChest(World world, int x, int y, int z, int dir) {
/* 1875 */     int i = world.rand.nextInt(3);
/*      */     
/* 1877 */     if (i == 0) {
/* 1878 */       OreSpawnMain.setBlockFast(world, x, y, z, (Block)Blocks.chest, 0, 2);
/* 1879 */       world.setBlockMetadataWithNotify(x, y, z, dir, 3);
/* 1880 */       TileEntityChest chest = (TileEntityChest)world.getTileEntity(x, y, z);
/* 1881 */       if (chest != null)
/*      */       {
/*      */         
/* 1884 */         WeightedRandomChestContent.generateChestContents(world.rand, Trees.CrystalChestContentsList, (IInventory)chest, 1 + world.rand.nextInt(3));
/*      */       }
/*      */     } else {
/*      */       
/* 1888 */       OreSpawnMain.setBlockFast(world, x, y, z, Blocks.mob_spawner, 0, 2);
/* 1889 */       TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(x, y, z);
/*      */       
/* 1891 */       if (tileentitymobspawner != null) {
/*      */         
/* 1893 */         int t = world.rand.nextInt(2);
/* 1894 */         if (t == 0) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Dungeon Beast"); 
/* 1895 */         if (t == 1) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rat");
/*      */       
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addIslands(World world, Random random, int chunkX, int chunkZ) {
/* 1904 */     int posX = 2 + chunkX + random.nextInt(12);
/* 1905 */     int posZ = 2 + chunkZ + random.nextInt(12);
/*      */     
/* 1907 */     if (random.nextInt(10 + OreSpawnMain.LessLag * 2) != 1) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1915 */     for (int posY = 20; posY > 2;) {
/*      */ 
/*      */       
/* 1918 */       if (world.isAirBlock(posX, posY, posZ)) {
/* 1919 */         if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/* 1920 */           OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyIslandBlock, 0, 2);
/*      */           break;
/*      */         } 
/*      */         posY--;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addAppleTrees(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
/* 1931 */     int freq = Math.abs(chunkX / 16) + Math.abs(chunkZ / 16);
/* 1932 */     int howmany = 2;
/* 1933 */     int which = 0;
/* 1934 */     boolean added = false;
/* 1935 */     freq %= 15;
/* 1936 */     howmany += random.nextInt(2 + (15 - freq) / 2);
/* 1937 */     which = random.nextInt(10);
/*      */     
/* 1939 */     if (random.nextInt(15 + freq) != 0) return false; 
/* 1940 */     if (OreSpawnMain.LessLag == 1) {
/* 1941 */       howmany /= 2;
/*      */     }
/* 1943 */     if (OreSpawnMain.LessLag == 2) {
/* 1944 */       howmany /= 4;
/* 1945 */       if (howmany < 1) return false;
/*      */     
/*      */     } 
/* 1948 */     for (int i = 0; i < howmany; i++) {
/* 1949 */       int posX = 2 + chunkX + random.nextInt(12);
/* 1950 */       int posZ = 2 + chunkZ + random.nextInt(12);
/* 1951 */       for (int posY = 100; posY > 50;) {
/*      */ 
/*      */         
/* 1954 */         if (world.isAirBlock(posX, posY, posZ)) {
/* 1955 */           if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/* 1956 */             ItemAppleSeed a = (ItemAppleSeed)OreSpawnMain.MyAppleSeed;
/*      */             
/* 1958 */             if (which < 8) a.makeTree(world, posX, posY - 1, posZ, OreSpawnMain.MyAppleLeaves, chunk); 
/* 1959 */             if (which == 8) a.makeTree(world, posX, posY - 1, posZ, OreSpawnMain.MyCherryLeaves, chunk); 
/* 1960 */             if (which == 9) a.makeTree(world, posX, posY - 1, posZ, OreSpawnMain.MyPeachLeaves, chunk); 
/* 1961 */             added = true;
/*      */             
/*      */             break;
/*      */           } 
/*      */           posY--;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1969 */     return added;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean addHugeTree(World world, Random random, int chunkX, int chunkZ, Chunk chunk) {
/* 1974 */     int made_one = 0;
/*      */     
/* 1976 */     if (random.nextInt(50) != 0) return false; 
/* 1977 */     if (OreSpawnMain.LessLag == 1 && 
/* 1978 */       random.nextInt(2) != 0) return false;
/*      */     
/* 1980 */     if (OreSpawnMain.LessLag == 2 && 
/* 1981 */       random.nextInt(4) != 0) return false;
/*      */ 
/*      */     
/* 1984 */     for (int i = 0; i < 3 && made_one == 0; i++) {
/* 1985 */       int posX = 4 + chunkX + random.nextInt(8);
/* 1986 */       int posZ = 4 + chunkZ + random.nextInt(8);
/* 1987 */       for (int posY = 127; posY > 50 && made_one == 0; posY--) {
/*      */ 
/*      */         
/* 1990 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/*      */           Block block;
/*      */           
/* 1993 */           ItemMagicApple a = (ItemMagicApple)OreSpawnMain.MagicApple;
/*      */ 
/*      */           
/* 1996 */           int tree_type = random.nextInt(4);
/* 1997 */           int tree_radius = 6 - random.nextInt(2);
/* 1998 */           boolean no_critters = false;
/* 1999 */           BlockLeaves blockLeaves = Blocks.leaves;
/*      */           
/* 2001 */           if (random.nextInt(100) > 25) {
/* 2002 */             no_critters = true;
/*      */           }
/* 2004 */           int rand_treetype = random.nextInt(100);
/* 2005 */           if (rand_treetype > 75) {
/* 2006 */             if (tree_type != 3 && random.nextInt(20) == 0) block = OreSpawnMain.MyAppleLeaves; 
/* 2007 */             a.MakeBigSquareTree(world, posX, posY - 1, posZ, Blocks.log, block, Blocks.mossy_cobblestone, tree_type, tree_radius, no_critters, chunk);
/* 2008 */           } else if (rand_treetype == 0) {
/* 2009 */             tree_radius = 6;
/* 2010 */             no_critters = true;
/* 2011 */             if (random.nextInt(2) == 0) {
/* 2012 */               a.MakeBigSquareTree(world, posX, posY - 1, posZ, Blocks.gold_block, Blocks.emerald_block, Blocks.diamond_block, -1, tree_radius, no_critters, chunk);
/*      */             } else {
/* 2014 */               a.MakeBigSquareTree(world, posX, posY - 1, posZ, Blocks.obsidian, OreSpawnMain.MyBlockRubyBlock, OreSpawnMain.MyBlockAmethystBlock, -1, tree_radius, no_critters, chunk);
/*      */             }
/*      */           
/* 2017 */           } else if (rand_treetype > 15) {
/* 2018 */             tree_radius = 6 - random.nextInt(3);
/* 2019 */             a.MakeBigCircularTree(world, posX, posY - 1, posZ, Blocks.log, block, Blocks.mossy_cobblestone, tree_type, tree_radius, no_critters, chunk);
/*      */           } else {
/* 2021 */             tree_radius = 6 - random.nextInt(3);
/* 2022 */             a.MakeBigRoundTree(world, posX, posY - 1, posZ, Blocks.log, block, Blocks.mossy_cobblestone, tree_type, tree_radius, chunk);
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 2027 */           made_one = 1;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/* 2033 */     if (made_one != 0) return true; 
/* 2034 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addVeggies(World world, Random random, int chunkX, int chunkZ) {
/* 2041 */     if (random.nextInt(15) != 0) {
/*      */       return;
/*      */     }
/* 2044 */     BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
/* 2045 */     if (world.provider.dimensionId == OreSpawnMain.DimensionID || world.provider.dimensionId == OreSpawnMain.DimensionID2 || world.provider.dimensionId == OreSpawnMain.DimensionID6 || b.biomeName.equals("River") || b.biomeName.equals("Swampland"))
/*      */     {
/* 2047 */       for (int i = 0; i < 8; i++) {
/* 2048 */         int posX = chunkX + random.nextInt(16);
/* 2049 */         int posZ = chunkZ + random.nextInt(16);
/* 2050 */         for (int posY = 100; posY > 40;) {
/*      */ 
/*      */           
/* 2053 */           if (world.isAirBlock(posX, posY, posZ)) {
/* 2054 */             if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/* 2055 */               int what = random.nextInt(6);
/* 2056 */               if (what == 0) {
/* 2057 */                 OreSpawnMain.setBlockFast(world, posX, posY, posZ, Blocks.carrots, 0, 2); break;
/* 2058 */               }  if (what == 1) {
/* 2059 */                 OreSpawnMain.setBlockFast(world, posX, posY, posZ, Blocks.potatoes, 0, 2); break;
/* 2060 */               }  if (what == 2) {
/* 2061 */                 OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyRadishPlant, 0, 2); break;
/* 2062 */               }  if (what == 3) {
/* 2063 */                 OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyLettucePlant1, 0, 2); break;
/* 2064 */               }  if (what == 4) {
/* 2065 */                 if (random.nextInt(10) == 0)
/* 2066 */                   OreSpawnMain.setBlockFast(world, posX, posY, posZ, Blocks.melon_stem, 0, 2); 
/*      */                 break;
/*      */               } 
/* 2069 */               if (random.nextInt(50) == 1)
/*      */               {
/* 2071 */                 if (OreSpawnMain.enableduplicatortree != 0) {
/* 2072 */                   OreSpawnMain.setBlockFast(world, posX, posY, posZ, OreSpawnMain.MyDT, 0, 2);
/*      */                 }
/*      */               }
/*      */               break;
/*      */             } 
/*      */             posY--;
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
/*      */   public void addRocks(World world, Random random, int chunkX, int chunkZ) {
/* 2089 */     if (random.nextInt(5) != 0)
/* 2090 */       return;  if (OreSpawnMain.RockEnable == 0)
/* 2091 */       return;  int howmany = 3 + random.nextInt(10);
/*      */ 
/*      */ 
/*      */     
/* 2095 */     for (int i = 0; i < howmany; i++) {
/* 2096 */       int posX = chunkX + random.nextInt(16);
/* 2097 */       int posZ = chunkZ + random.nextInt(16);
/* 2098 */       for (int posY = 110; posY > 40;) {
/*      */ 
/*      */         
/* 2101 */         if (world.getBlock(posX, posY, posZ) == Blocks.air) {
/* 2102 */           Block bid = world.getBlock(posX, posY - 1, posZ);
/* 2103 */           if (bid == Blocks.grass || bid == Blocks.sand || bid == OreSpawnMain.CrystalGrass) {
/* 2104 */             spawnCreature(world, "Rock", posX, posY, posZ);
/*      */             break;
/*      */           } 
/*      */           posY--;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addD4Rocks(World world, Random random, int chunkX, int chunkZ) {
/* 2118 */     if (random.nextInt(7) != 0)
/* 2119 */       return;  if (OreSpawnMain.RockEnable == 0)
/* 2120 */       return;  int howmany = 3 + random.nextInt(10);
/*      */ 
/*      */     
/* 2123 */     for (int i = 0; i < howmany; i++) {
/* 2124 */       int posX = chunkX + random.nextInt(16);
/* 2125 */       int posZ = chunkZ + random.nextInt(16);
/* 2126 */       for (int posY = 20; posY > 5;) {
/*      */ 
/*      */         
/* 2129 */         if (world.getBlock(posX, posY, posZ) == Blocks.air) {
/* 2130 */           if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/* 2131 */             spawnCreature(world, "Rock", posX, posY, posZ);
/*      */             break;
/*      */           } 
/*      */           posY--;
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
/*      */   public boolean addFairyTree(World world, Random random, int chunkX, int chunkZ) {
/* 2146 */     int posX = chunkX + 8;
/* 2147 */     int posZ = chunkZ + 8;
/*      */ 
/*      */ 
/*      */     
/* 2151 */     if (random.nextInt(5) != 0) return false;
/*      */     
/* 2153 */     for (int posY = 128; posY > 40; posY--) {
/*      */ 
/*      */       
/* 2156 */       if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == OreSpawnMain.CrystalGrass) {
/*      */         int i;
/*      */         
/* 2159 */         for (i = -8; i <= 8; i++) {
/* 2160 */           for (int j = -8; j <= 8; j++) {
/* 2161 */             Block bid = world.getBlock(posX + i, posY, posZ + j);
/* 2162 */             if (bid != Blocks.air) return false;
/*      */           
/*      */           } 
/*      */         } 
/* 2166 */         for (i = -2; i <= 2; i++) {
/* 2167 */           for (int j = -2; j <= 2; j++) {
/* 2168 */             Block bid = world.getBlock(posX + i, posY - 1, posZ + j);
/* 2169 */             if (bid != OreSpawnMain.CrystalGrass) return false;
/*      */           
/*      */           } 
/*      */         } 
/* 2173 */         if (random.nextInt(5) != 1) {
/* 2174 */           OreSpawnMain.OreSpawnTrees.FairyTree(world, posX, posY - 1, posZ);
/*      */         } else {
/* 2176 */           OreSpawnMain.OreSpawnTrees.FairyCastleTree(world, posX, posY, posZ);
/*      */         } 
/* 2178 */         recently_placed = 50;
/*      */         break;
/*      */       } 
/*      */     } 
/* 2182 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addRubyDungeon(World world, Random random, int chunkX, int chunkZ) {
/* 2188 */     if (random.nextInt(15) != 0) return false;
/*      */     
/* 2190 */     for (int i = 0; i < 8; i++) {
/* 2191 */       int posX = chunkX + random.nextInt(8);
/* 2192 */       int posZ = chunkZ + random.nextInt(8);
/* 2193 */       for (int posY = 50; posY > 5; posY--) {
/*      */ 
/*      */         
/* 2196 */         if (world.getBlock(posX, posY, posZ) == Blocks.lava) {
/*      */ 
/*      */ 
/*      */           
/* 2200 */           OreSpawnMain.RubyDungeon.makeDungeon(world, posX, posY, posZ);
/* 2201 */           return true;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 2206 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addGenericDungeon(World world, Random random, int chunkX, int chunkZ) {
/* 2212 */     if (random.nextInt(16) != 0) return false;
/*      */     
/* 2214 */     if (OreSpawnMain.LessLag == 1 && 
/* 2215 */       random.nextInt(2) != 0) return false;
/*      */     
/* 2217 */     if (OreSpawnMain.LessLag == 2 && 
/* 2218 */       random.nextInt(4) != 0) return false;
/*      */ 
/*      */     
/* 2221 */     int posX = chunkX + random.nextInt(4);
/* 2222 */     int posZ = chunkZ + random.nextInt(4);
/* 2223 */     int posY = 5 + random.nextInt(40);
/*      */ 
/*      */ 
/*      */     
/* 2227 */     OreSpawnMain.MyDungeon.makeDungeon(world, posX, posY, posZ);
/* 2228 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addBeeHive(World world, Random random, int chunkX, int chunkZ) {
/* 2235 */     int lowestY = 128;
/* 2236 */     int lowestX = chunkX;
/* 2237 */     int lowestZ = chunkZ;
/* 2238 */     int found = 0;
/*      */ 
/*      */     
/* 2241 */     for (int i = 0; i < 16; i += 3) {
/* 2242 */       for (int j = 0; j < 16; j += 3) {
/* 2243 */         int posX = chunkX + i;
/* 2244 */         int posZ = chunkZ + j;
/* 2245 */         for (int posY = 128; posY > 30; posY--) {
/*      */           
/* 2247 */           if (world.getBlock(posX, posY + 1, posZ) == Blocks.air && world.getBlock(posX, posY, posZ) == Blocks.grass) {
/*      */             
/* 2249 */             if (posY < lowestY) {
/* 2250 */               lowestY = posY;
/* 2251 */               lowestX = posX;
/* 2252 */               lowestZ = posZ;
/* 2253 */               found = 1;
/*      */             } 
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 2261 */     if (found != 0 && lowestY > 40) {
/* 2262 */       OreSpawnMain.MyDungeon.makeBeeHive(world, lowestX, lowestY + 3, lowestZ);
/* 2263 */       recently_placed = 50;
/* 2264 */       return true;
/*      */     } 
/* 2266 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean addAlienWTF(World world, Random random, int chunkX, int chunkZ) {
/* 2271 */     int lowestY = 128;
/* 2272 */     int lowestX = chunkX;
/* 2273 */     int lowestZ = chunkZ;
/* 2274 */     int found = 0;
/*      */ 
/*      */     
/* 2277 */     for (int i = 0; i < 16; i += 3) {
/* 2278 */       for (int j = 0; j < 16; j += 3) {
/* 2279 */         int posX = chunkX + i;
/* 2280 */         int posZ = chunkZ + j;
/* 2281 */         for (int posY = 128; posY > 30; posY--) {
/*      */           
/* 2283 */           if (world.getBlock(posX, posY + 1, posZ) == Blocks.air && world.getBlock(posX, posY, posZ) == Blocks.grass) {
/*      */             
/* 2285 */             if (posY < lowestY) {
/* 2286 */               lowestY = posY;
/* 2287 */               lowestX = posX;
/* 2288 */               lowestZ = posZ;
/* 2289 */               found = 1;
/*      */             } 
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 2297 */     if (found != 0 && lowestY > 40) {
/* 2298 */       OreSpawnMain.MyDungeon.makeAlienWTFDungeon(world, lowestX, lowestY, lowestZ);
/* 2299 */       recently_placed = 50;
/* 2300 */       return true;
/*      */     } 
/* 2302 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean addEnderKnight(World world, Random random, int chunkX, int chunkZ) {
/* 2307 */     int lowestY = 128;
/* 2308 */     int lowestX = chunkX;
/* 2309 */     int lowestZ = chunkZ;
/* 2310 */     int found = 0;
/*      */ 
/*      */     
/* 2313 */     for (int i = 0; i < 16; i += 3) {
/* 2314 */       for (int j = 0; j < 16; j += 3) {
/* 2315 */         int posX = chunkX + i;
/* 2316 */         int posZ = chunkZ + j;
/* 2317 */         for (int posY = 128; posY > 30; posY--) {
/*      */           
/* 2319 */           if (world.getBlock(posX, posY + 1, posZ) == Blocks.air && world.getBlock(posX, posY, posZ) == Blocks.grass) {
/*      */             
/* 2321 */             if (posY < lowestY) {
/* 2322 */               lowestY = posY;
/* 2323 */               lowestX = posX;
/* 2324 */               lowestZ = posZ;
/* 2325 */               found = 1;
/*      */             } 
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 2333 */     if (found != 0 && lowestY > 40) {
/* 2334 */       OreSpawnMain.MyDungeon.makeEnderKnightDungeon(world, lowestX, lowestY, lowestZ);
/* 2335 */       recently_placed = 50;
/* 2336 */       return true;
/*      */     } 
/* 2338 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean addLeonNest(World world, Random random, int chunkX, int chunkZ) {
/* 2343 */     int highestY = 30;
/* 2344 */     int highestX = chunkX;
/* 2345 */     int highestZ = chunkZ;
/* 2346 */     int found = 0;
/*      */ 
/*      */     
/* 2349 */     for (int i = 0; i < 16; i += 3) {
/* 2350 */       for (int j = 0; j < 16; j += 3) {
/* 2351 */         int posX = chunkX + i;
/* 2352 */         int posZ = chunkZ + j;
/* 2353 */         for (int posY = 128; posY > 80; posY--) {
/*      */           
/* 2355 */           if (world.getBlock(posX, posY + 1, posZ) == Blocks.air && world.getBlock(posX, posY, posZ) == Blocks.grass) {
/*      */             
/* 2357 */             if (posY > highestY) {
/* 2358 */               highestY = posY + 1;
/* 2359 */               highestX = posX;
/* 2360 */               highestZ = posZ;
/* 2361 */               found = 1;
/*      */             } 
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 2369 */     if (found != 0 && highestY > 80) {
/* 2370 */       OreSpawnMain.MyDungeon.makeLeonNest(world, highestX, highestY, highestZ);
/* 2371 */       recently_placed = 50;
/* 2372 */       return true;
/*      */     } 
/* 2374 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addShadowDungeon(World world, Random random, int chunkX, int chunkZ) {
/* 2382 */     int lowestY = 128;
/* 2383 */     int lowestX = chunkX;
/* 2384 */     int lowestZ = chunkZ;
/* 2385 */     int found = 0;
/*      */ 
/*      */     
/* 2388 */     for (int i = 0; i < 16; i += 3) {
/* 2389 */       for (int j = 0; j < 16; j += 3) {
/* 2390 */         int posX = chunkX + i;
/* 2391 */         int posZ = chunkZ + j;
/* 2392 */         for (int posY = 128; posY > 30; posY--) {
/*      */           
/* 2394 */           if (world.getBlock(posX, posY + 1, posZ) == Blocks.air && world.getBlock(posX, posY, posZ) == Blocks.grass) {
/*      */             
/* 2396 */             if (posY < lowestY) {
/* 2397 */               lowestY = posY;
/* 2398 */               lowestX = posX;
/* 2399 */               lowestZ = posZ;
/* 2400 */               found = 1;
/*      */             } 
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 2408 */     if (found != 0 && lowestY > 40) {
/* 2409 */       OreSpawnMain.MyDungeon.makeShadowDungeon(world, lowestX, lowestY, lowestZ);
/* 2410 */       recently_placed = 50;
/* 2411 */       return true;
/*      */     } 
/* 2413 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addD4RubyDungeon(World world, Random random, int chunkX, int chunkZ) {
/* 2420 */     if (OreSpawnMain.LessLag != 0 && 
/* 2421 */       random.nextInt(2) != 0) return false;
/*      */ 
/*      */     
/* 2424 */     int posX = chunkX + random.nextInt(8);
/* 2425 */     int posZ = chunkZ + random.nextInt(8);
/*      */     
/* 2427 */     for (int posY = 20; posY > 4; posY--) {
/*      */       
/* 2429 */       Block bid = world.getBlock(posX, posY, posZ);
/* 2430 */       if (bid == Blocks.grass) {
/*      */ 
/*      */ 
/*      */         
/* 2434 */         OreSpawnMain.RubyDungeon.makeDungeon(world, posX, posY, posZ);
/* 2435 */         recently_placed = 50;
/* 2436 */         return true;
/*      */       } 
/*      */     } 
/* 2439 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addD4CephadromeAltar(World world, Random random, int chunkX, int chunkZ) {
/* 2445 */     if (OreSpawnMain.LessLag != 0 && 
/* 2446 */       random.nextInt(2) != 0) return false;
/*      */ 
/*      */     
/* 2449 */     int posX = chunkX + random.nextInt(8);
/* 2450 */     int posZ = chunkZ + random.nextInt(8);
/*      */     
/* 2452 */     for (int posY = 20; posY > 4; posY--) {
/*      */       
/* 2454 */       Block bid = world.getBlock(posX, posY, posZ);
/* 2455 */       if (bid == Blocks.grass) {
/*      */ 
/*      */ 
/*      */         
/* 2459 */         OreSpawnMain.MyDungeon.makeCephadromeAltar(world, posX, posY, posZ);
/* 2460 */         recently_placed = 50;
/* 2461 */         return true;
/*      */       } 
/*      */     } 
/* 2464 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addD4Castle(World world, Random random, int chunkX, int chunkZ) {
/* 2470 */     if (OreSpawnMain.LessLag != 0 && 
/* 2471 */       random.nextInt(2) != 0) return false;
/*      */ 
/*      */ 
/*      */     
/* 2475 */     int posX = chunkX + random.nextInt(8);
/* 2476 */     int posZ = chunkZ + random.nextInt(8);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2481 */     for (int posY = 20; posY > 4; posY--) {
/*      */       
/* 2483 */       Block bid = world.getBlock(posX, posY, posZ);
/* 2484 */       if (bid == Blocks.grass) {
/*      */ 
/*      */ 
/*      */         
/* 2488 */         for (int x = -20; x < 33; x++) {
/* 2489 */           for (int z = -4; z < 33; z++) {
/* 2490 */             bid = world.getBlock(posX + x, posY + 18, posZ + z);
/* 2491 */             if (bid != Blocks.air) return false; 
/*      */           } 
/*      */         } 
/* 2494 */         if (random.nextInt(2) == 1) {
/* 2495 */           OreSpawnMain.MyDungeon.makeEnormousCastle(world, posX, posY, posZ);
/*      */         } else {
/* 2497 */           OreSpawnMain.MyDungeon.makeEnormousCastleQ(world, posX, posY, posZ);
/*      */         } 
/* 2499 */         recently_placed = 50;
/* 2500 */         return true;
/*      */       } 
/*      */     } 
/* 2503 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addD4Greenhouse(World world, Random random, int chunkX, int chunkZ) {
/* 2509 */     if (OreSpawnMain.LessLag != 0 && 
/* 2510 */       random.nextInt(2) != 0) return false;
/*      */ 
/*      */ 
/*      */     
/* 2514 */     int posX = chunkX + random.nextInt(8);
/* 2515 */     int posZ = chunkZ + random.nextInt(8);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2520 */     for (int posY = 20; posY > 4; posY--) {
/*      */       
/* 2522 */       Block bid = world.getBlock(posX, posY, posZ);
/* 2523 */       if (bid == Blocks.grass) {
/*      */ 
/*      */ 
/*      */         
/* 2527 */         for (int x = -2; x < 25; x++) {
/* 2528 */           for (int z = -4; z < 25; z++) {
/* 2529 */             bid = world.getBlock(posX + x, posY + 18, posZ + z);
/* 2530 */             if (bid != Blocks.air) return false; 
/*      */           } 
/*      */         } 
/* 2533 */         OreSpawnMain.MyDungeon.makeGreenhouseDungeon(world, posX, posY, posZ);
/* 2534 */         recently_placed = 50;
/* 2535 */         return true;
/*      */       } 
/*      */     } 
/* 2538 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addD4NightmareRookery(World world, Random random, int chunkX, int chunkZ) {
/* 2544 */     if (OreSpawnMain.LessLag != 0 && 
/* 2545 */       random.nextInt(2) != 0) return false;
/*      */ 
/*      */     
/* 2548 */     int posX = chunkX + random.nextInt(8);
/* 2549 */     int posZ = chunkZ + random.nextInt(8);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2554 */     for (int posY = 20; posY > 4; posY--) {
/*      */       
/* 2556 */       Block bid = world.getBlock(posX, posY, posZ);
/* 2557 */       if (bid == Blocks.grass) {
/*      */ 
/*      */ 
/*      */         
/* 2561 */         for (int x = -5; x < 25; x++) {
/* 2562 */           for (int z = -4; z < 5; z++) {
/* 2563 */             bid = world.getBlock(posX + x, posY + 18, posZ + z);
/* 2564 */             if (bid != Blocks.air) return false; 
/*      */           } 
/*      */         } 
/* 2567 */         OreSpawnMain.MyDungeon.makeNightmareRookery(world, posX, posY, posZ);
/* 2568 */         recently_placed = 50;
/* 2569 */         return true;
/*      */       } 
/*      */     } 
/* 2572 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addD4StinkyHouse(World world, Random random, int chunkX, int chunkZ) {
/* 2578 */     if (OreSpawnMain.LessLag != 0 && 
/* 2579 */       random.nextInt(2) != 0) return false;
/*      */ 
/*      */     
/* 2582 */     int posX = chunkX + random.nextInt(8);
/* 2583 */     int posZ = chunkZ + random.nextInt(8);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2588 */     for (int posY = 20; posY > 4; posY--) {
/*      */       
/* 2590 */       Block bid = world.getBlock(posX, posY, posZ);
/* 2591 */       if (bid == Blocks.grass) {
/*      */ 
/*      */ 
/*      */         
/* 2595 */         for (int x = -8; x < 20; x++) {
/* 2596 */           for (int z = -8; z < 20; z++) {
/* 2597 */             bid = world.getBlock(posX + x, posY + 18, posZ + z);
/* 2598 */             if (bid != Blocks.air) return false; 
/*      */           } 
/*      */         } 
/* 2601 */         OreSpawnMain.MyDungeon.makeStinkyHouse(world, posX, posY, posZ);
/* 2602 */         recently_placed = 50;
/* 2603 */         return true;
/*      */       } 
/*      */     } 
/* 2606 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addD4WhiteHouse(World world, Random random, int chunkX, int chunkZ) {
/* 2612 */     if (OreSpawnMain.LessLag != 0 && 
/* 2613 */       random.nextInt(2) != 0) return false;
/*      */ 
/*      */     
/* 2616 */     int posX = chunkX + random.nextInt(8);
/* 2617 */     int posZ = chunkZ + random.nextInt(8);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2622 */     for (int posY = 20; posY > 4; posY--) {
/*      */       
/* 2624 */       Block bid = world.getBlock(posX, posY, posZ);
/* 2625 */       if (bid == Blocks.grass) {
/*      */ 
/*      */ 
/*      */         
/* 2629 */         for (int x = -20; x < 30; x++) {
/* 2630 */           for (int z = -20; z < 300; z++) {
/* 2631 */             bid = world.getBlock(posX + x, posY + 18, posZ + z);
/* 2632 */             if (bid != Blocks.air) return false; 
/*      */           } 
/*      */         } 
/* 2635 */         OreSpawnMain.MyDungeon.makeWhiteHouse(world, posX, posY, posZ);
/* 2636 */         recently_placed = 50;
/* 2637 */         return true;
/*      */       } 
/*      */     } 
/* 2640 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addD4EnderCastle(World world, Random random, int chunkX, int chunkZ) {
/* 2646 */     if (OreSpawnMain.LessLag != 0 && 
/* 2647 */       random.nextInt(2) != 0) return false;
/*      */ 
/*      */ 
/*      */     
/* 2651 */     int posX = chunkX + random.nextInt(8);
/* 2652 */     int posZ = chunkZ + random.nextInt(8);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2657 */     for (int posY = 20; posY > 4; posY--) {
/*      */       
/* 2659 */       Block bid = world.getBlock(posX, posY, posZ);
/* 2660 */       if (bid == Blocks.grass) {
/*      */ 
/*      */ 
/*      */         
/* 2664 */         for (int x = -5; x < 25; x++) {
/* 2665 */           for (int z = -5; z < 25; z++) {
/* 2666 */             bid = world.getBlock(posX + x, posY + 18, posZ + z);
/* 2667 */             if (bid != Blocks.air) return false; 
/*      */           } 
/*      */         } 
/* 2670 */         OreSpawnMain.MyDungeon.makeEnderCastle(world, posX, posY, posZ);
/* 2671 */         recently_placed = 50;
/* 2672 */         return true;
/*      */       } 
/*      */     } 
/* 2675 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addD4IncaPyramid(World world, Random random, int chunkX, int chunkZ) {
/* 2681 */     if (OreSpawnMain.LessLag != 0 && 
/* 2682 */       random.nextInt(2) != 0) return false;
/*      */ 
/*      */ 
/*      */     
/* 2686 */     int posX = chunkX + random.nextInt(8);
/* 2687 */     int posZ = chunkZ + random.nextInt(8);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2692 */     for (int posY = 20; posY > 4; posY--) {
/*      */       
/* 2694 */       Block bid = world.getBlock(posX, posY, posZ);
/* 2695 */       if (bid == Blocks.grass) {
/*      */ 
/*      */ 
/*      */         
/* 2699 */         for (int x = -10; x < 50; x++) {
/* 2700 */           for (int z = -10; z < 40; z++) {
/* 2701 */             bid = world.getBlock(posX + x, posY + 18, posZ + z);
/* 2702 */             if (bid != Blocks.air) return false; 
/*      */           } 
/*      */         } 
/* 2705 */         OreSpawnMain.MyDungeon.makeIncaPyramid(world, posX, posY, posZ);
/* 2706 */         recently_placed = 50;
/* 2707 */         return true;
/*      */       } 
/*      */     } 
/* 2710 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addD4RobotLab(World world, Random random, int chunkX, int chunkZ) {
/* 2716 */     if (OreSpawnMain.LessLag != 0 && 
/* 2717 */       random.nextInt(2) != 0) return false;
/*      */ 
/*      */ 
/*      */     
/* 2721 */     int posX = chunkX + random.nextInt(8);
/* 2722 */     int posZ = chunkZ + random.nextInt(8);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2727 */     for (int posY = 20; posY > 4; posY--) {
/*      */       
/* 2729 */       Block bid = world.getBlock(posX, posY, posZ);
/* 2730 */       if (bid == Blocks.grass) {
/*      */ 
/*      */ 
/*      */         
/* 2734 */         for (int x = -5; x < 60; x++) {
/* 2735 */           for (int z = -5; z < 70; z++) {
/* 2736 */             bid = world.getBlock(posX + x, posY + 4, posZ + z);
/* 2737 */             if (bid != Blocks.air && 
/* 2738 */               bid != Blocks.log && 
/* 2739 */               bid != OreSpawnMain.MyAppleLeaves && 
/* 2740 */               bid != OreSpawnMain.MyScaryLeaves && 
/* 2741 */               bid != Blocks.air) return false; 
/*      */           } 
/*      */         } 
/* 2744 */         OreSpawnMain.MyDungeon.makeRobotLab(world, posX, posY, posZ);
/* 2745 */         recently_placed = 50;
/* 2746 */         return true;
/*      */       } 
/*      */     } 
/* 2749 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addD4Mini(World world, Random random, int chunkX, int chunkZ) {
/* 2755 */     if (OreSpawnMain.LessLag != 0 && 
/* 2756 */       random.nextInt(2) != 0) return false;
/*      */ 
/*      */ 
/*      */     
/* 2760 */     int posX = chunkX + random.nextInt(8);
/* 2761 */     int posZ = chunkZ + random.nextInt(8);
/*      */     
/* 2763 */     for (int posY = 20; posY > 4; posY--) {
/*      */       
/* 2765 */       Block bid = world.getBlock(posX, posY, posZ);
/* 2766 */       if (bid == Blocks.grass) {
/*      */ 
/*      */ 
/*      */         
/* 2770 */         OreSpawnMain.MyDungeon.makeMiniDungeon(world, posX, posY, posZ);
/* 2771 */         recently_placed = 50;
/* 2772 */         return true;
/*      */       } 
/*      */     } 
/* 2775 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addPumpkin(World world, Random random, int chunkX, int chunkZ) {
/* 2781 */     if (OreSpawnMain.LessLag != 0 && 
/* 2782 */       random.nextInt(2) != 0) return false;
/*      */ 
/*      */ 
/*      */     
/* 2786 */     int posX = chunkX + random.nextInt(8);
/* 2787 */     int posZ = chunkZ + random.nextInt(8);
/*      */     
/* 2789 */     for (int posY = 20; posY > 4; posY--) {
/*      */       
/* 2791 */       Block bid = world.getBlock(posX, posY, posZ);
/* 2792 */       if (bid == Blocks.grass) {
/*      */ 
/*      */ 
/*      */         
/* 2796 */         OreSpawnMain.MyDungeon.makePumpkin(world, posX, posY + 1, posZ);
/* 2797 */         recently_placed = 50;
/* 2798 */         return true;
/*      */       } 
/*      */     } 
/* 2801 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addD4CloudShark(World world, Random random, int chunkX, int chunkZ) {
/* 2808 */     int posX = 4 + chunkX + random.nextInt(8);
/* 2809 */     int posZ = 4 + chunkZ + random.nextInt(8);
/*      */ 
/*      */ 
/*      */     
/* 2813 */     OreSpawnMain.MyDungeon.makeCloudSharkDungeon(world, posX, 150 + world.rand.nextInt(10), posZ);
/* 2814 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addD4Rainbow(World world, Random random, int chunkX, int chunkZ) {
/* 2821 */     int posX = 4 + chunkX + random.nextInt(8);
/* 2822 */     int posZ = 4 + chunkZ + random.nextInt(8);
/*      */ 
/*      */ 
/*      */     
/* 2826 */     OreSpawnMain.MyDungeon.makeRainbow(world, posX, 70 + world.rand.nextInt(20), posZ);
/* 2827 */     recently_placed = 50;
/* 2828 */     return true;
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
/*      */   public boolean addD4GenericDungeon(World world, Random random, int chunkX, int chunkZ) {
/* 2858 */     if (OreSpawnMain.LessLag != 0 && 
/* 2859 */       random.nextInt(4) != 0) return false;
/*      */ 
/*      */     
/* 2862 */     int posX = chunkX + random.nextInt(8);
/* 2863 */     int posZ = chunkZ + random.nextInt(8);
/*      */     
/* 2865 */     for (int posY = 20; posY > 4; posY--) {
/*      */       
/* 2867 */       Block bid = world.getBlock(posX, posY, posZ);
/* 2868 */       if (bid == Blocks.grass) {
/*      */ 
/*      */ 
/*      */         
/* 2872 */         OreSpawnMain.MyDungeon.makeDungeon(world, posX, posY, posZ);
/* 2873 */         recently_placed = 50;
/* 2874 */         return true;
/*      */       } 
/*      */     } 
/* 2877 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addLavaAndWater(World world, Random random, int chunkX, int chunkZ) {
/* 2883 */     if (random.nextInt(5) != 0) {
/*      */       return;
/*      */     }
/* 2886 */     for (int i = 0; i < 6; i++) {
/* 2887 */       int posX = chunkX + random.nextInt(16);
/* 2888 */       int posZ = chunkZ + random.nextInt(16);
/* 2889 */       for (int posY = 128; posY > 75;) {
/*      */ 
/*      */         
/* 2892 */         if (world.isAirBlock(posX, posY, posZ)) {
/* 2893 */           if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/*      */             
/* 2895 */             Block bid = world.getBlock(posX, posY - 2, posZ);
/* 2896 */             if (bid == Blocks.dirt || bid == Blocks.stone) {
/*      */ 
/*      */ 
/*      */               
/* 2900 */               int air = 0;
/* 2901 */               int non_air = 0;
/* 2902 */               bid = world.getBlock(posX + 1, posY - 1, posZ);
/* 2903 */               if (bid == Blocks.air) air++; 
/* 2904 */               if (bid == Blocks.dirt || bid == Blocks.stone || bid == Blocks.grass) non_air++; 
/* 2905 */               bid = world.getBlock(posX - 1, posY - 1, posZ);
/* 2906 */               if (bid == Blocks.air) air++; 
/* 2907 */               if (bid == Blocks.dirt || bid == Blocks.stone || bid == Blocks.grass) non_air++; 
/* 2908 */               bid = world.getBlock(posX, posY - 1, posZ + 1);
/* 2909 */               if (bid == Blocks.air) air++; 
/* 2910 */               if (bid == Blocks.dirt || bid == Blocks.stone || bid == Blocks.grass) non_air++; 
/* 2911 */               bid = world.getBlock(posX, posY - 1, posZ - 1);
/* 2912 */               if (bid == Blocks.air) air++; 
/* 2913 */               if (bid == Blocks.dirt || bid == Blocks.stone || bid == Blocks.grass) non_air++; 
/* 2914 */               if (air != 0 && non_air != 0) {
/*      */ 
/*      */                 
/* 2917 */                 int what = random.nextInt(2);
/* 2918 */                 if (what == 0) {
/* 2919 */                   OreSpawnMain.setBlockFast(world, posX, posY, posZ, (Block)Blocks.flowing_water, 0, 3);
/* 2920 */                   OreSpawnMain.setBlockFast(world, posX, posY - 1, posZ, Blocks.water, 0, 3);
/* 2921 */                   OreSpawnMain.setBlockFast(world, posX, posY - 2, posZ, Blocks.water, 0, 3);
/*      */                 } else {
/*      */                   
/* 2924 */                   OreSpawnMain.setBlockFast(world, posX, posY, posZ, (Block)Blocks.flowing_lava, 0, 3);
/* 2925 */                   OreSpawnMain.setBlockFast(world, posX, posY - 1, posZ, Blocks.lava, 0, 3);
/* 2926 */                   OreSpawnMain.setBlockFast(world, posX, posY - 2, posZ, Blocks.lava, 0, 3);
/*      */                 } 
/*      */                 return;
/*      */               } 
/*      */             } 
/*      */             break;
/*      */           } 
/*      */           posY--;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addOtherTrees(World world, Random random, int chunkX, int chunkZ) {
/* 2944 */     int nc = 5;
/* 2945 */     int count = 0;
/*      */     
/* 2947 */     if (random.nextInt(30) != 0) return false; 
/* 2948 */     if (OreSpawnMain.LessLag == 1) {
/* 2949 */       if (random.nextInt(2) != 0) return false; 
/* 2950 */       nc = 4;
/*      */     } 
/* 2952 */     if (OreSpawnMain.LessLag == 2) {
/* 2953 */       if (random.nextInt(4) != 0) return false; 
/* 2954 */       nc = 3;
/*      */     } 
/*      */     
/* 2957 */     if (world.provider.dimensionId == OreSpawnMain.DimensionID) {
/*      */ 
/*      */       
/* 2960 */       int dir = 0;
/* 2961 */       int what = random.nextInt(2);
/*      */       
/* 2963 */       for (int i = 0; i < nc; i++) {
/* 2964 */         int posX = 3 + chunkX + random.nextInt(10);
/* 2965 */         int posZ = 3 + chunkZ + random.nextInt(10);
/* 2966 */         for (int posY = 100; posY > 50;) {
/*      */ 
/*      */           
/* 2969 */           if (world.isAirBlock(posX, posY, posZ)) {
/* 2970 */             if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/*      */               
/* 2972 */               count++;
/* 2973 */               if (what == 0) {
/* 2974 */                 OreSpawnMain.OreSpawnTrees.WindTree(world, posX, posY - 1, posZ, dir);
/* 2975 */                 if (count >= 4) return true;  break;
/*      */               } 
/* 2977 */               OreSpawnMain.OreSpawnTrees.SkyTree(world, posX, posY - 1, posZ);
/* 2978 */               if (count >= 3) return true;
/*      */ 
/*      */               
/*      */               break;
/*      */             } 
/*      */             posY--;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 2988 */     if (count > 0) return true; 
/* 2989 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addKingAltar(World world, Random random, int chunkX, int chunkZ) {
/* 2996 */     if (random.nextInt(2000) != 1) return false;
/*      */     
/* 2998 */     for (int i = 0; i < 8; i++) {
/* 2999 */       int posX = 3 + chunkX + random.nextInt(10);
/* 3000 */       int posZ = 3 + chunkZ + random.nextInt(10);
/* 3001 */       for (int posY = 100; posY > 50; posY--) {
/*      */ 
/*      */         
/* 3004 */         if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
/*      */ 
/*      */           
/* 3007 */           if (!quickReallyBigSpaceCheck(world, posX, posY - 1, posZ)) return false; 
/* 3008 */           if (random.nextInt(2) == 0) {
/* 3009 */             OreSpawnMain.MyDungeon.makeKingAltar(world, posX, posY - 1, posZ);
/*      */           } else {
/* 3011 */             OreSpawnMain.MyDungeon.makeQueenAltar(world, posX, posY - 1, posZ);
/*      */           } 
/* 3013 */           recently_placed = 100;
/* 3014 */           return true;
/*      */         } 
/*      */       } 
/*      */     } 
/* 3018 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void addBasiliskMaze(World world, Random random, int chunkX, int chunkZ) {
/* 3023 */     int lowestY = 128;
/* 3024 */     int lowestX = chunkX;
/* 3025 */     int lowestZ = chunkZ;
/* 3026 */     int found = 0;
/*      */     
/* 3028 */     for (int i = 0; i < 16; i += 3) {
/* 3029 */       for (int j = 0; j < 16; j += 3) {
/* 3030 */         int posX = chunkX + i;
/* 3031 */         int posZ = chunkZ + j;
/* 3032 */         for (int posY = 128; posY > 30; posY--) {
/*      */           
/* 3034 */           if (world.getBlock(posX, posY + 1, posZ) == Blocks.air && world.getBlock(posX, posY, posZ) != Blocks.air) {
/*      */             
/* 3036 */             if (posY < lowestY) {
/* 3037 */               lowestY = posY;
/* 3038 */               lowestX = posX;
/* 3039 */               lowestZ = posZ;
/* 3040 */               found = 1;
/*      */             } 
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 3048 */     if (found != 0 && lowestY > 40) {
/* 3049 */       OreSpawnMain.BMaze.buildBasiliskMaze(world, lowestX, lowestY - 2, lowestZ);
/* 3050 */       recently_placed = 50;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addKyuubiDungeon(World world, Random random, int chunkX, int chunkZ) {
/* 3056 */     int lowestY = 128;
/* 3057 */     int lowestX = chunkX;
/* 3058 */     int lowestZ = chunkZ;
/* 3059 */     int found = 0;
/*      */     
/* 3061 */     for (int i = 0; i < 16; i += 3) {
/* 3062 */       for (int j = 0; j < 16; j += 3) {
/* 3063 */         int posX = chunkX + i;
/* 3064 */         int posZ = chunkZ + j;
/* 3065 */         for (int posY = 128; posY > 30; posY--) {
/*      */           
/* 3067 */           if (world.getBlock(posX, posY + 1, posZ) == Blocks.air && world.getBlock(posX, posY, posZ) != Blocks.air) {
/*      */             
/* 3069 */             if (posY < lowestY) {
/* 3070 */               lowestY = posY;
/* 3071 */               lowestX = posX;
/* 3072 */               lowestZ = posZ;
/* 3073 */               found = 1;
/*      */             } 
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 3081 */     if (found != 0 && lowestY > 40) {
/* 3082 */       OreSpawnMain.MyDungeon.makeKyuubiDungeon(world, lowestX, lowestY - 2, lowestZ);
/* 3083 */       recently_placed = 50;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean quickSpaceCheck(World world, int posX, int posY, int posZ) {
/* 3091 */     for (int i = -2; i < 10; i++) {
/* 3092 */       for (int k = -2; k < 10; k++) {
/* 3093 */         if (world.getBlock(posX + i, posY + 4, posZ + k) != Blocks.air) return false;
/*      */       
/*      */       } 
/*      */     } 
/* 3097 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean quickBigSpaceCheck(World world, int posX, int posY, int posZ) {
/* 3104 */     for (int i = -5; i < 25; i++) {
/* 3105 */       for (int k = -5; k < 25; k++) {
/* 3106 */         if (world.getBlock(posX + i, posY + 8, posZ + k) != Blocks.air) return false;
/*      */       
/*      */       } 
/*      */     } 
/* 3110 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean quickReallyBigSpaceCheck(World world, int posX, int posY, int posZ) {
/* 3117 */     for (int i = -5; i < 55; i++) {
/* 3118 */       for (int k = -5; k < 55; k++) {
/* 3119 */         if (world.getBlock(posX + i, posY + 8, posZ + k) != Blocks.air) return false;
/*      */       
/*      */       } 
/*      */     } 
/* 3123 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean D4BigSpaceCheck(World world, int posX, int posY, int posZ) {
/* 3131 */     for (int i = -25; i < 40; i++) {
/* 3132 */       for (int k = -25; k < 30; ) {
/* 3133 */         Block bid = world.getBlock(posX + i, posY + 4, posZ + k);
/* 3134 */         if (bid == Blocks.air || 
/* 3135 */           bid == Blocks.log || 
/* 3136 */           bid == OreSpawnMain.MyAppleLeaves || 
/* 3137 */           bid == OreSpawnMain.MyScaryLeaves) { k++; continue; }
/* 3138 */          return false;
/*      */       } 
/*      */     } 
/*      */     
/* 3142 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 3147 */     Entity var8 = null;
/*      */ 
/*      */     
/* 3150 */     var8 = EntityList.createEntityByName(par1, par0World);
/*      */     
/* 3152 */     if (var8 != null) {
/*      */ 
/*      */       
/* 3155 */       if (par2 > 0.0D) par2 += 0.5D; 
/* 3156 */       if (par2 < 0.0D) par2 -= 0.5D; 
/* 3157 */       if (par6 > 0.0D) par6 += 0.5D; 
/* 3158 */       if (par6 < 0.0D) par6 -= 0.5D; 
/* 3159 */       var8.setLocationAndAngles(par2, par4 + 0.01D, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*      */ 
/*      */       
/* 3162 */       par0World.spawnEntityInWorld(var8);
/*      */       
/* 3164 */       ((EntityLiving)var8).playLivingSound();
/*      */     } 
/*      */     
/* 3167 */     return var8;
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\OreSpawnWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */