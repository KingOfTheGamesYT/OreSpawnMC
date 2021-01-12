/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.tileentity.TileEntityChest;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.WeightedRandomChestContent;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class NightmareDungeon
/*     */ {
/*  14 */   private final WeightedRandomChestContent[] chestContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(OreSpawnMain.CageEmpty, 0, 3, 10, 20), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceBody, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceLegs, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceHelmet, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceBoots, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyExperienceSword, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateBody, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateLegs, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateHelmet, 0, 1, 1, 25), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateBoots, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateSword, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimatePickaxe, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateShovel, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateHoe, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateAxe, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateBow, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyBertha, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MySlice, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.MyAmethyst, 0, 2, 8, 15), new WeightedRandomChestContent(OreSpawnMain.MyBacon, 0, 6, 12, 20), new WeightedRandomChestContent(OreSpawnMain.MyButterCandy, 0, 6, 12, 20), new WeightedRandomChestContent(OreSpawnMain.MyAmethystPickaxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystShovel, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystHoe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystAxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystSword, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystBoots, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyThunderStaff, 0, 1, 1, 5) };
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
/*     */   private void setThisBlock(World world, int cposx, int cposy, int cposz) {
/*  51 */     if (world.rand.nextInt(2) == 1) {
/*  52 */       FastSetBlock(world, cposx, cposy, cposz, Blocks.bedrock);
/*     */     } else {
/*  54 */       FastSetBlock(world, cposx, cposy, cposz, Blocks.obsidian);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void makeDungeon(World world, int cposx, int cposy, int cposz) {
/*  61 */     int width = 25;
/*  62 */     int height = 12;
/*     */     
/*     */     int i;
/*  65 */     for (i = 0; i < width; i++) {
/*  66 */       for (int j = 0; j < height; j++) {
/*  67 */         for (int m = 0; m < width; m++) {
/*  68 */           FastSetBlock(world, cposx + i, cposy + j, cposz + m, Blocks.air);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  74 */     for (i = 0; i < width; i++) {
/*  75 */       int j = 0;
/*  76 */       for (int m = 0; m < width; m++) {
/*  77 */         FastSetBlock(world, cposx + i, cposy + j, cposz + m, OreSpawnMain.MyRTPBlock);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  82 */     for (i = 0; i < width; i++) {
/*  83 */       int j = height - 1;
/*  84 */       for (int m = 0; m < width; m++) {
/*  85 */         FastSetBlock(world, cposx + i, cposy + j, cposz + m, Blocks.bedrock);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  90 */     for (i = 0; i < width; i++) {
/*  91 */       for (int j = 0; j < height; j++) {
/*  92 */         int m = 0;
/*  93 */         setThisBlock(world, cposx + i, cposy + j, cposz + m);
/*  94 */         m = width - 1;
/*  95 */         setThisBlock(world, cposx + i, cposy + j, cposz + m);
/*     */       } 
/*     */     } 
/*     */     
/*  99 */     for (int k = 0; k < width; k++) {
/* 100 */       for (int j = 0; j < height; j++) {
/* 101 */         i = 0;
/* 102 */         setThisBlock(world, cposx + i, cposy + j, cposz + k);
/* 103 */         i = width - 1;
/* 104 */         setThisBlock(world, cposx + i, cposy + j, cposz + k);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 110 */     world.setBlock(cposx + width / 2, cposy + 1, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 111 */     TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(cposx + width / 2, cposy + 1, cposz + width / 2);
/*     */     
/* 113 */     if (tileentitymobspawner != null)
/*     */     {
/* 115 */       if (world.rand.nextInt(2) == 1) {
/* 116 */         tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Emperor Scorpion");
/*     */       } else {
/* 118 */         tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Nightmare");
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 124 */     TileEntityChest chest = null;
/*     */     
/* 126 */     world.setBlock(cposx + width / 2 + 1, cposy + 1, cposz + width / 2 + 1, (Block)Blocks.chest, 0, 2);
/* 127 */     chest = (TileEntityChest)world.getTileEntity(cposx + width / 2 + 1, cposy + 1, cposz + width / 2 + 1);
/* 128 */     if (chest != null)
/*     */     {
/*     */       
/* 131 */       WeightedRandomChestContent.generateChestContents(world.rand, this.chestContentsList, (IInventory)chest, 4 + world.rand.nextInt(7));
/*     */     }
/* 133 */     world.setBlock(cposx + width / 2 - 1, cposy + 1, cposz + width / 2 - 1, (Block)Blocks.chest, 0, 2);
/* 134 */     chest = (TileEntityChest)world.getTileEntity(cposx + width / 2 - 1, cposy + 1, cposz + width / 2 - 1);
/* 135 */     if (chest != null)
/*     */     {
/*     */       
/* 138 */       WeightedRandomChestContent.generateChestContents(world.rand, this.chestContentsList, (IInventory)chest, 4 + world.rand.nextInt(7));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void FastSetBlock(World world, int ix, int iy, int iz, Block id) {
/* 145 */     OreSpawnMain.setBlockFast(world, ix, iy, iz, id, 0, 3);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\NightmareDungeon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */