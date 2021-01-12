/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
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
/*     */ public class BiomeGenUtopianPlains
/*     */   extends BiomeGenBase
/*     */ {
/*     */   protected BiomeGenUtopianPlains(int par1) {
/*  20 */     super(par1);
/*     */ 
/*     */ 
/*     */     
/*  24 */     if (OreSpawnMain.GazelleEnable != 0) {
/*  25 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(Gazelle.class, 10, 2, 4));
/*     */     }
/*  27 */     if (OreSpawnMain.FireflyEnable != 0) {
/*  28 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Firefly.class, 15, 3, 6));
/*     */     }
/*  30 */     if (OreSpawnMain.GirlfriendEnable != 0) {
/*  31 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(Girlfriend.class, 5, 2, 3));
/*     */     }
/*  33 */     if (OreSpawnMain.BoyfriendEnable != 0) {
/*  34 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(Boyfriend.class, 5, 2, 3));
/*     */     }
/*  36 */     if (OreSpawnMain.CowEnable != 0) {
/*     */       
/*  38 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(RedCow.class, 10, 4, 8));
/*     */       
/*  40 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldCow.class, 8, 2, 6));
/*     */       
/*  42 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EnchantedCow.class, 5, 2, 4));
/*     */     } 
/*  44 */     if (OreSpawnMain.ButterflyEnable != 0) {
/*  45 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityButterfly.class, 20, 3, 6));
/*     */     }
/*  47 */     if (OreSpawnMain.MothEnable != 0) {
/*  48 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityLunaMoth.class, 10, 1, 5));
/*     */     }
/*  50 */     if (OreSpawnMain.ChipmunkEnable != 0) {
/*  51 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Chipmunk.class, 3, 1, 2));
/*     */     }
/*  53 */     if (OreSpawnMain.CockateilEnable != 0) {
/*  54 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Cockateil.class, 10, 2, 4));
/*     */     }
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
/*  74 */     if (OreSpawnMain.GoldFishEnable != 0) {
/*  75 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldFish.class, 1, 1, 1));
/*     */     }
/*  77 */     if (OreSpawnMain.WhaleEnable != 0) {
/*  78 */       this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Whale.class, 1, 1, 1));
/*     */     }
/*  80 */     if (OreSpawnMain.FlounderEnable != 0) {
/*  81 */       this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Flounder.class, 2, 2, 4));
/*     */     }
/*  83 */     if (OreSpawnMain.CoinEnable != 0) {
/*  84 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Coin.class, 2, 1, 1));
/*     */     }
/*  86 */     if (OreSpawnMain.CricketEnable != 0) {
/*  87 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Cricket.class, 5, 4, 6));
/*     */     }
/*  89 */     if (OreSpawnMain.FrogEnable != 0) {
/*  90 */       this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Frog.class, 5, 4, 6));
/*     */     }
/*  92 */     this.theBiomeDecorator.treesPerChunk = -999;
/*  93 */     this.theBiomeDecorator.flowersPerChunk = 4;
/*  94 */     this.theBiomeDecorator.grassPerChunk = 6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIslandCreatures() {
/* 103 */     this.spawnableCreatureList = null;
/* 104 */     this.spawnableMonsterList = null;
/* 105 */     this.spawnableWaterCreatureList = null;
/* 106 */     this.spawnableCaveCreatureList = null;
/* 107 */     this.spawnableCreatureList = new ArrayList();
/* 108 */     this.spawnableMonsterList = new ArrayList();
/* 109 */     this.spawnableWaterCreatureList = new ArrayList();
/* 110 */     this.spawnableCaveCreatureList = new ArrayList();
/*     */ 
/*     */     
/* 113 */     if (OreSpawnMain.ButterflyEnable != 0) {
/* 114 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityButterfly.class, 5, 2, 6));
/*     */     }
/* 116 */     if (OreSpawnMain.CockateilEnable != 0) {
/* 117 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Cockateil.class, 4, 1, 2));
/*     */     }
/* 119 */     if (OreSpawnMain.MothEnable != 0) {
/* 120 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityLunaMoth.class, 5, 2, 4));
/*     */     }
/* 122 */     if (OreSpawnMain.FireflyEnable != 0) {
/* 123 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Firefly.class, 10, 4, 8));
/*     */     }
/* 125 */     if (OreSpawnMain.DragonEnable != 0) {
/* 126 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Dragon.class, 1, 1, 2));
/*     */     }
/* 128 */     if (OreSpawnMain.StinkyEnable != 0) {
/* 129 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Stinky.class, 2, 1, 2));
/*     */     }
/* 131 */     if (OreSpawnMain.CliffRacerEnable != 0) {
/* 132 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CliffRacer.class, 20, 3, 6));
/*     */     }
/* 134 */     if (OreSpawnMain.CloudSharkEnable != 0) {
/* 135 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CloudShark.class, 1, 1, 1));
/*     */     }
/* 137 */     if (OreSpawnMain.GoldFishEnable != 0) {
/* 138 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldFish.class, 5, 2, 4));
/*     */     }
/* 140 */     if (OreSpawnMain.CreepingHorrorEnable != 0) {
/* 141 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(CreepingHorror.class, 60, 4, 8));
/*     */     }
/* 143 */     if (OreSpawnMain.TerribleTerrorEnable != 0) {
/* 144 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(TerribleTerror.class, 25, 3, 6));
/*     */     }
/* 146 */     if (OreSpawnMain.LurkingTerrorEnable != 0) {
/* 147 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LurkingTerror.class, 1, 1, 1));
/*     */     }
/* 149 */     if (OreSpawnMain.PitchBlackEnable != 0) {
/* 150 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(PitchBlack.class, 15, 3, 6));
/*     */     }
/* 152 */     if (OreSpawnMain.LeafMonsterEnable != 0) {
/* 153 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LeafMonster.class, 35, 2, 4));
/*     */     }
/* 155 */     if (OreSpawnMain.EnderReaperEnable != 0) {
/* 156 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EnderReaper.class, 25, 2, 4));
/*     */     }
/* 158 */     if (OreSpawnMain.HerculesBeetleEnable != 0) {
/* 159 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(HerculesBeetle.class, 5, 1, 2));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCrystalCreatures() {
/* 169 */     this.spawnableCreatureList = null;
/* 170 */     this.spawnableMonsterList = null;
/* 171 */     this.spawnableWaterCreatureList = null;
/* 172 */     this.spawnableCaveCreatureList = null;
/* 173 */     this.spawnableCreatureList = new ArrayList();
/* 174 */     this.spawnableMonsterList = new ArrayList();
/* 175 */     this.spawnableWaterCreatureList = new ArrayList();
/* 176 */     this.spawnableCaveCreatureList = new ArrayList();
/*     */ 
/*     */     
/* 179 */     if (OreSpawnMain.CowEnable != 0) {
/* 180 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(CrystalCow.class, 1, 1, 4));
/*     */     }
/* 182 */     if (OreSpawnMain.FairyEnable != 0) {
/* 183 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Fairy.class, 10, 4, 8));
/*     */     }
/* 185 */     if (OreSpawnMain.PeacockEnable != 0) {
/* 186 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Peacock.class, 5, 4, 8));
/*     */     }
/* 188 */     if (OreSpawnMain.MantisEnable != 0) {
/* 189 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Mantis.class, 1, 1, 1));
/*     */     }
/* 191 */     if (OreSpawnMain.RotatorEnable != 0) {
/* 192 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Rotator.class, 4, 1, 2));
/*     */     }
/* 194 */     if (OreSpawnMain.VortexEnable != 0) {
/* 195 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Vortex.class, 3, 1, 2));
/*     */     }
/* 197 */     if (OreSpawnMain.UrchinEnable != 0) {
/* 198 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Urchin.class, 15, 2, 4));
/*     */     }
/* 200 */     if (OreSpawnMain.DungeonBeastEnable != 0) {
/* 201 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(DungeonBeast.class, 30, 4, 6));
/*     */     }
/* 203 */     if (OreSpawnMain.RatEnable != 0) {
/* 204 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Rat.class, 40, 4, 6));
/*     */     }
/* 206 */     if (OreSpawnMain.ButterflyEnable != 0) {
/* 207 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityButterfly.class, 10, 2, 4));
/*     */     }
/* 209 */     if (OreSpawnMain.CockateilEnable != 0) {
/* 210 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Cockateil.class, 4, 1, 2));
/*     */     }
/* 212 */     if (OreSpawnMain.MothEnable != 0) {
/* 213 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityLunaMoth.class, 4, 1, 2));
/*     */     }
/* 215 */     if (OreSpawnMain.WhaleEnable != 0) {
/* 216 */       this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Whale.class, 1, 1, 2));
/*     */     }
/* 218 */     if (OreSpawnMain.CrabEnable != 0) {
/* 219 */       this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Crab.class, 1, 1, 2));
/*     */     }
/* 221 */     if (OreSpawnMain.FlounderEnable != 0) {
/* 222 */       this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Flounder.class, 5, 6, 8));
/*     */     }
/* 224 */     if (OreSpawnMain.IrukandjiEnable != 0) {
/* 225 */       this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Irukandji.class, 4, 2, 3));
/*     */     }
/* 227 */     if (OreSpawnMain.SkateEnable != 0) {
/* 228 */       this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Skate.class, 2, 3, 6));
/*     */     }
/* 230 */     if (OreSpawnMain.FrogEnable != 0) {
/* 231 */       this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Frog.class, 1, 3, 5));
/*     */     }
/*     */     
/* 234 */     this.theBiomeDecorator.flowersPerChunk = -999;
/* 235 */     this.theBiomeDecorator.grassPerChunk = -999;
/* 236 */     this.theBiomeDecorator.treesPerChunk = -999;
/* 237 */     this.theBiomeDecorator.bigMushroomsPerChunk = -999;
/* 238 */     this.theBiomeDecorator.mushroomsPerChunk = -999;
/* 239 */     this.theBiomeDecorator.reedsPerChunk = -999;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVillageCreatures() {
/* 249 */     if (OreSpawnMain.Robot1Enable != 0) {
/* 250 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot1.class, 25, 4, 8));
/*     */     }
/* 252 */     if (OreSpawnMain.Robot2Enable != 0) {
/* 253 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot2.class, 16, 2, 8));
/*     */     }
/* 255 */     if (OreSpawnMain.Robot3Enable != 0) {
/* 256 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot3.class, 12, 2, 4));
/*     */     }
/* 258 */     if (OreSpawnMain.Robot4Enable != 0) {
/* 259 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot4.class, 8, 1, 2));
/*     */     }
/* 261 */     if (OreSpawnMain.Robot5Enable != 0) {
/* 262 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot5.class, 20, 4, 8));
/*     */     }
/* 264 */     if (OreSpawnMain.JefferyEnable != 0) {
/* 265 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(GiantRobot.class, 8, 1, 2));
/*     */     }
/* 267 */     if (OreSpawnMain.SpiderDriverEnable != 0) {
/* 268 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(SpiderDriver.class, 20, 3, 5));
/*     */     }
/* 270 */     if (OreSpawnMain.GodzillaEnable != 0) {
/* 271 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Godzilla.class, 2, 1, 1));
/*     */     }
/*     */     
/* 274 */     if (OreSpawnMain.FireflyEnable != 0) {
/* 275 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Firefly.class, 10, 3, 6));
/*     */     }
/* 277 */     if (OreSpawnMain.GirlfriendEnable != 0) {
/* 278 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(Girlfriend.class, 1, 2, 3));
/*     */     }
/* 280 */     if (OreSpawnMain.BoyfriendEnable != 0) {
/* 281 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(Boyfriend.class, 1, 2, 3));
/*     */     }
/* 283 */     if (OreSpawnMain.CowEnable != 0) {
/*     */       
/* 285 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(RedCow.class, 8, 4, 8));
/*     */       
/* 287 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldCow.class, 6, 2, 6));
/*     */       
/* 289 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EnchantedCow.class, 4, 2, 4));
/*     */     } 
/* 291 */     if (OreSpawnMain.ButterflyEnable != 0) {
/* 292 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityButterfly.class, 25, 3, 6));
/*     */     }
/* 294 */     if (OreSpawnMain.MothEnable != 0) {
/* 295 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityLunaMoth.class, 20, 1, 5));
/*     */     }
/* 297 */     if (OreSpawnMain.ChipmunkEnable != 0) {
/* 298 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Chipmunk.class, 5, 1, 2));
/*     */     }
/* 300 */     if (OreSpawnMain.CockateilEnable != 0) {
/* 301 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Cockateil.class, 15, 2, 4));
/*     */     }
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
/* 326 */     if (OreSpawnMain.TshirtEnable != 0) {
/* 327 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Tshirt.class, 2, 1, 1));
/*     */     }
/* 329 */     if (OreSpawnMain.CoinEnable != 0) {
/* 330 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Coin.class, 2, 1, 1));
/*     */     }
/* 332 */     if (OreSpawnMain.CriminalEnable != 0) {
/* 333 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(BandP.class, 15, 1, 2));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChaosCreatures() {
/* 343 */     this.spawnableCreatureList = null;
/* 344 */     this.spawnableMonsterList = null;
/* 345 */     this.spawnableWaterCreatureList = null;
/* 346 */     this.spawnableCaveCreatureList = null;
/* 347 */     this.spawnableCreatureList = new ArrayList();
/* 348 */     this.spawnableMonsterList = new ArrayList();
/* 349 */     this.spawnableWaterCreatureList = new ArrayList();
/* 350 */     this.spawnableCaveCreatureList = new ArrayList();
/*     */     
/* 352 */     this.theBiomeDecorator.flowersPerChunk = 2;
/* 353 */     this.theBiomeDecorator.grassPerChunk = 4;
/* 354 */     this.theBiomeDecorator.treesPerChunk = 1;
/* 355 */     this.theBiomeDecorator.bigMushroomsPerChunk = -999;
/* 356 */     this.theBiomeDecorator.mushroomsPerChunk = -999;
/* 357 */     this.theBiomeDecorator.reedsPerChunk = -999;
/*     */ 
/*     */     
/* 360 */     if (OreSpawnMain.ButterflyEnable != 0) {
/* 361 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityButterfly.class, 20, 3, 6));
/*     */     }
/* 363 */     if (OreSpawnMain.MothEnable != 0) {
/* 364 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityLunaMoth.class, 10, 1, 5));
/*     */     }
/* 366 */     if (OreSpawnMain.CockateilEnable != 0) {
/* 367 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Cockateil.class, 10, 2, 4));
/*     */     }
/* 369 */     if (OreSpawnMain.FireflyEnable != 0) {
/* 370 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Firefly.class, 15, 3, 6));
/*     */     }
/* 372 */     if (OreSpawnMain.CliffRacerEnable != 0) {
/* 373 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CliffRacer.class, 30, 3, 6));
/*     */     }
/* 375 */     if (OreSpawnMain.CloudSharkEnable != 0) {
/* 376 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CloudShark.class, 2, 1, 1));
/*     */     }
/* 378 */     if (OreSpawnMain.GoldFishEnable != 0) {
/* 379 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldFish.class, 10, 2, 4));
/*     */     }
/* 381 */     if (OreSpawnMain.FairyEnable != 0) {
/* 382 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Fairy.class, 5, 2, 4));
/*     */     }
/* 384 */     if (OreSpawnMain.BaryonyxEnable != 0) {
/* 385 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Baryonyx.class, 2, 2, 4));
/*     */     }
/* 387 */     if (OreSpawnMain.BeeEnable != 0) {
/* 388 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Bee.class, 2, 2, 4));
/*     */     }
/* 390 */     if (OreSpawnMain.CassowaryEnable != 0) {
/* 391 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Cassowary.class, 2, 2, 4));
/*     */     }
/* 393 */     if (OreSpawnMain.DragonflyEnable != 0) {
/* 394 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Dragonfly.class, 2, 2, 4));
/*     */     }
/* 396 */     if (OreSpawnMain.PeacockEnable != 0) {
/* 397 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Peacock.class, 2, 2, 4));
/*     */     }
/* 399 */     if (OreSpawnMain.StinkBugEnable != 0) {
/* 400 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(StinkBug.class, 3, 2, 4));
/*     */     }
/* 402 */     if (OreSpawnMain.OstrichEnable != 0) {
/* 403 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Ostrich.class, 1, 1, 2));
/*     */     }
/* 405 */     if (OreSpawnMain.ChipmunkEnable != 0) {
/* 406 */       this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Chipmunk.class, 1, 1, 2));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 412 */     if (OreSpawnMain.BeaverEnable != 0) {
/* 413 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(Beaver.class, 1, 1, 2));
/*     */     }
/* 415 */     if (OreSpawnMain.CowEnable != 0) {
/*     */       
/* 417 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(RedCow.class, 3, 2, 4));
/*     */       
/* 419 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldCow.class, 2, 2, 4));
/*     */       
/* 421 */       this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EnchantedCow.class, 1, 2, 4));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 428 */     if (OreSpawnMain.VortexEnable != 0) {
/* 429 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Vortex.class, 1, 1, 2));
/*     */     }
/* 431 */     if (OreSpawnMain.PitchBlackEnable != 0) {
/* 432 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(PitchBlack.class, 1, 1, 2));
/*     */     }
/* 434 */     if (OreSpawnMain.TerribleTerrorEnable != 0) {
/* 435 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(TerribleTerror.class, 4, 2, 6));
/*     */     }
/* 437 */     if (OreSpawnMain.AlosaurusEnable != 0) {
/* 438 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Alosaurus.class, 1, 1, 1));
/*     */     }
/* 440 */     if (OreSpawnMain.BasiliskEnable != 0) {
/* 441 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Basilisk.class, 1, 1, 1));
/*     */     }
/* 443 */     if (OreSpawnMain.Robot1Enable != 0) {
/* 444 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot1.class, 5, 2, 8));
/*     */     }
/* 446 */     if (OreSpawnMain.Robot2Enable != 0) {
/* 447 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot2.class, 2, 1, 4));
/*     */     }
/* 449 */     if (OreSpawnMain.Robot3Enable != 0) {
/* 450 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot3.class, 2, 1, 4));
/*     */     }
/* 452 */     if (OreSpawnMain.Robot4Enable != 0) {
/* 453 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot4.class, 1, 1, 2));
/*     */     }
/* 455 */     if (OreSpawnMain.Robot5Enable != 0) {
/* 456 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot5.class, 2, 3, 5));
/*     */     }
/* 458 */     if (OreSpawnMain.CaterKillerEnable != 0) {
/* 459 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(CaterKiller.class, 1, 1, 1));
/*     */     }
/* 461 */     if (OreSpawnMain.CaveFisherEnable != 0) {
/* 462 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(CaveFisher.class, 5, 1, 5));
/*     */     }
/* 464 */     if (OreSpawnMain.CreepingHorrorEnable != 0) {
/* 465 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(CreepingHorror.class, 5, 1, 5));
/*     */     }
/* 467 */     if (OreSpawnMain.CryolophosaurusEnable != 0) {
/* 468 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Cryolophosaurus.class, 5, 1, 5));
/*     */     }
/* 470 */     if (OreSpawnMain.UrchinEnable != 0) {
/* 471 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Urchin.class, 2, 1, 5));
/*     */     }
/* 473 */     if (OreSpawnMain.DungeonBeastEnable != 0) {
/* 474 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(DungeonBeast.class, 2, 1, 5));
/*     */     }
/* 476 */     if (OreSpawnMain.EmperorScorpionEnable != 0) {
/* 477 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EmperorScorpion.class, 1, 1, 1));
/*     */     }
/* 479 */     if (OreSpawnMain.EnderKnightEnable != 0) {
/* 480 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EnderKnight.class, 2, 1, 2));
/*     */     }
/* 482 */     if (OreSpawnMain.EnderReaperEnable != 0) {
/* 483 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EnderReaper.class, 1, 1, 1));
/*     */     }
/* 485 */     if (OreSpawnMain.HammerheadEnable != 0) {
/* 486 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Hammerhead.class, 1, 1, 1));
/*     */     }
/* 488 */     if (OreSpawnMain.HerculesBeetleEnable != 0) {
/* 489 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(HerculesBeetle.class, 1, 1, 1));
/*     */     }
/* 491 */     if (OreSpawnMain.TrooperBugEnable != 0) {
/* 492 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(TrooperBug.class, 1, 1, 1));
/*     */     }
/* 494 */     if (OreSpawnMain.MolenoidEnable != 0) {
/* 495 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Molenoid.class, 1, 1, 1));
/*     */     }
/* 497 */     if (OreSpawnMain.MothraEnable != 0) {
/* 498 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Mothra.class, 1, 1, 1));
/*     */     }
/* 500 */     if (OreSpawnMain.BrutalflyEnable != 0) {
/* 501 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Brutalfly.class, 1, 1, 1));
/*     */     }
/* 503 */     if (OreSpawnMain.RatEnable != 0) {
/* 504 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Rat.class, 10, 1, 10));
/*     */     }
/* 506 */     if (OreSpawnMain.RotatorEnable != 0) {
/* 507 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Rotator.class, 1, 1, 3));
/*     */     }
/* 509 */     if (OreSpawnMain.ScorpionEnable != 0) {
/* 510 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Scorpion.class, 2, 1, 3));
/*     */     }
/* 512 */     if (OreSpawnMain.SpitBugEnable != 0) {
/* 513 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(SpitBug.class, 2, 1, 3));
/*     */     }
/* 515 */     if (OreSpawnMain.NastysaurusEnable != 0) {
/* 516 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Nastysaurus.class, 1, 1, 1));
/*     */     }
/* 518 */     if (OreSpawnMain.TRexEnable != 0) {
/* 519 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(TRex.class, 1, 1, 1));
/*     */     }
/* 521 */     if (OreSpawnMain.LeafMonsterEnable != 0) {
/* 522 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LeafMonster.class, 2, 1, 4));
/*     */     }
/* 524 */     if (OreSpawnMain.PointysaurusEnable != 0) {
/* 525 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Pointysaurus.class, 2, 1, 4));
/*     */     }
/* 527 */     if (OreSpawnMain.LeonEnable != 0) {
/* 528 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Leon.class, 1, 1, 1));
/*     */     }
/* 530 */     if (OreSpawnMain.MantisEnable != 0) {
/* 531 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Mantis.class, 1, 1, 1));
/*     */     }
/* 533 */     if (OreSpawnMain.LurkingTerrorEnable != 0) {
/* 534 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LurkingTerror.class, 1, 1, 1));
/*     */     }
/* 536 */     if (OreSpawnMain.GammaMetroidEnable != 0)
/* 537 */       this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(GammaMetroid.class, 1, 1, 1)); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BiomeGenUtopianPlains.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */