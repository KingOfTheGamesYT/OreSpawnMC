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
/*     */ public class RubyBirdDungeon
/*     */ {
/*  14 */   private final WeightedRandomChestContent[] chestContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(OreSpawnMain.CageEmpty, 0, 3, 10, 20), new WeightedRandomChestContent(OreSpawnMain.MyRuby, 0, 2, 8, 15), new WeightedRandomChestContent(OreSpawnMain.MyBacon, 0, 6, 12, 20), new WeightedRandomChestContent(OreSpawnMain.MyButterCandy, 0, 6, 12, 20), new WeightedRandomChestContent(OreSpawnMain.MyRubyPickaxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyRubyShovel, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyRubyHoe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyRubyAxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyRubySword, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.RubyBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.RubyLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.RubyHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.RubyBoots, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyThunderStaff, 0, 1, 1, 5) };
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
/*  33 */     if (world.rand.nextInt(20) == 1) {
/*  34 */       FastSetBlock(world, cposx, cposy, cposz, OreSpawnMain.MyOreRubyBlock);
/*  35 */     } else if (world.rand.nextInt(2) == 1) {
/*  36 */       FastSetBlock(world, cposx, cposy, cposz, Blocks.mossy_cobblestone);
/*     */     } else {
/*  38 */       FastSetBlock(world, cposx, cposy, cposz, Blocks.cobblestone);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void makeDungeon(World world, int cposx, int cposy, int cposz) {
/*  45 */     int width = 10;
/*  46 */     int height = 5;
/*     */     
/*     */     int i;
/*  49 */     for (i = 0; i < width; i++) {
/*  50 */       for (int j = 0; j < height; j++) {
/*  51 */         for (int m = 0; m < width; m++) {
/*  52 */           FastSetBlock(world, cposx + i, cposy + j, cposz + m, Blocks.air);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  58 */     for (i = 0; i < width; i++) {
/*  59 */       int j = 0;
/*  60 */       for (int m = 0; m < width; m++) {
/*  61 */         FastSetBlock(world, cposx + i, cposy + j, cposz + m, Blocks.mossy_cobblestone);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  66 */     for (i = 0; i < width; i++) {
/*  67 */       int j = height - 1;
/*  68 */       for (int m = 0; m < width; m++) {
/*  69 */         setThisBlock(world, cposx + i, cposy + j, cposz + m);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  74 */     for (i = 0; i < width; i++) {
/*  75 */       for (int j = 0; j < height; j++) {
/*  76 */         int m = 0;
/*  77 */         setThisBlock(world, cposx + i, cposy + j, cposz + m);
/*  78 */         m = width - 1;
/*  79 */         setThisBlock(world, cposx + i, cposy + j, cposz + m);
/*     */       } 
/*     */     } 
/*     */     
/*  83 */     for (int k = 0; k < width; k++) {
/*  84 */       for (int j = 0; j < height; j++) {
/*  85 */         i = 0;
/*  86 */         setThisBlock(world, cposx + i, cposy + j, cposz + k);
/*  87 */         i = width - 1;
/*  88 */         setThisBlock(world, cposx + i, cposy + j, cposz + k);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  94 */     world.setBlock(cposx + width / 2, cposy + 1, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/*  95 */     TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(cposx + width / 2, cposy + 1, cposz + width / 2);
/*     */     
/*  97 */     if (tileentitymobspawner != null)
/*     */     {
/*  99 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ruby Bird");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 104 */     TileEntityChest chest = null;
/*     */     
/* 106 */     world.setBlock(cposx + width / 2, cposy + 1, cposz + 1, (Block)Blocks.chest, 0, 2);
/* 107 */     chest = (TileEntityChest)world.getTileEntity(cposx + width / 2, cposy + 1, cposz + 1);
/* 108 */     if (chest != null)
/*     */     {
/*     */       
/* 111 */       WeightedRandomChestContent.generateChestContents(world.rand, this.chestContentsList, (IInventory)chest, 4 + world.rand.nextInt(7));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void FastSetBlock(World world, int ix, int iy, int iz, Block id) {
/* 118 */     OreSpawnMain.setBlockFast(world, ix, iy, iz, id, 0, 2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RubyBirdDungeon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */