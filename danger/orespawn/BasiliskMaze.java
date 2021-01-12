/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.awt.Point;
/*     */ import java.util.Vector;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.tileentity.TileEntityChest;
/*     */ import net.minecraft.util.WeightedRandomChestContent;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasiliskMaze
/*     */ {
/*     */   public static final int WTOP = 1;
/*     */   public static final int WRGT = 2;
/*     */   public static final int WBOT = 4;
/*     */   public static final int WLFT = 8;
/*     */   
/*     */   public void buildBasiliskMaze(World world, int x, int y, int z) {
/*  27 */     int depth = 20 + world.rand.nextInt(10);
/*  28 */     clearArea(world, x + 3, y - depth - 4, z - 20);
/*  29 */     makeMaze(world, x + 3, y - depth - 3, z - 20, 10, 10, 3, 0);
/*  30 */     openMaze(world, x + 3, y - depth - 3, z - 20, 10, 10, 3);
/*  31 */     buildCastle(world, x + 3, y - depth - 4, z - 20);
/*  32 */     makeEntrance(world, x, y, z, depth);
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
/*     */ 
/*     */ 
/*     */   
/*     */   private void makeMaze(World world, int xx, int yy, int zz, int xw, int zw, int csz, int b) {
/*  48 */     int gridw = xw;
/*  49 */     int gridh = zw;
/*  50 */     int cellsize = csz;
/*  51 */     if (cellsize < 3) cellsize = 3;
/*     */     
/*  53 */     int[][] cells = new int[gridw][gridh];
/*     */ 
/*     */ 
/*     */     
/*  57 */     int full = 15; int x;
/*  58 */     for (x = 0; x < gridw; x++) {
/*  59 */       for (int i = 0; i < gridh; i++) {
/*  60 */         cells[x][i] = full;
/*     */       }
/*     */     } 
/*  63 */     int left = 128;
/*  64 */     int right = 32; int y;
/*  65 */     for (y = 0; y < gridh; y++) {
/*     */       
/*  67 */       cells[0][y] = cells[0][y] | left;
/*  68 */       cells[gridw - 1][y] = cells[gridw - 1][y] | right;
/*     */     } 
/*  70 */     int top = 16;
/*  71 */     int bottom = 64;
/*  72 */     for (x = 0; x < gridw; x++) {
/*     */       
/*  74 */       cells[x][0] = cells[x][0] | top;
/*  75 */       cells[x][gridh - 1] = cells[x][gridh - 1] | bottom;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  81 */     Vector<Point> outlist = new Vector(gridw * gridh);
/*  82 */     Vector<Point> inlist = new Vector(10, 10);
/*  83 */     Vector frontlist = new Vector(10, 10);
/*  84 */     for (x = 0; x < gridw; x++) {
/*  85 */       for (y = 0; y < gridh; y++)
/*  86 */         outlist.addElement(new Point(x, y)); 
/*  87 */     }  Point current_cell = (Point)rndElement(outlist);
/*  88 */     inlist.addElement(current_cell);
/*  89 */     moveNbrs(current_cell, cells, outlist, frontlist);
/*     */     
/*  91 */     while (!frontlist.isEmpty()) {
/*     */       
/*  93 */       current_cell = (Point)rndElement(frontlist);
/*  94 */       inlist.addElement(current_cell);
/*  95 */       moveNbrs(current_cell, cells, outlist, frontlist);
/*  96 */       int dir = findInNbr(current_cell, cells, inlist);
/*  97 */       removeWall(current_cell, dir, cells);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 102 */     current_cell = null;
/*     */ 
/*     */ 
/*     */     
/* 106 */     for (x = 0; x < gridw; x++) {
/* 107 */       for (y = 0; y < gridh; y++) {
/*     */         
/* 109 */         int val = cells[x][y];
/* 110 */         if ((val & 0x1) != 0) {
/* 111 */           drawSide(world, x * cellsize, y * cellsize, (x + 1) * cellsize, y * cellsize, xx, yy, zz, cellsize, gridh, gridw, b);
/*     */         }
/*     */         
/* 114 */         if ((val & 0x2) != 0) {
/* 115 */           drawSide(world, (x + 1) * cellsize - 1, y * cellsize, (x + 1) * cellsize - 1, (y + 1) * cellsize, xx, yy, zz, cellsize, gridh, gridw, b);
/*     */         }
/*     */         
/* 118 */         if ((val & 0x4) != 0) {
/* 119 */           drawSide(world, x * cellsize, (y + 1) * cellsize - 1, (x + 1) * cellsize, (y + 1) * cellsize - 1, xx, yy, zz, cellsize, gridh, gridw, b);
/*     */         }
/*     */         
/* 122 */         if ((val & 0x8) != 0) {
/* 123 */           drawSide(world, x * cellsize, y * cellsize, x * cellsize, (y + 1) * cellsize, xx, yy, zz, cellsize, gridh, gridw, b);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawSide(World world, int fromx, int fromz, int tox, int toz, int x, int y, int z, int cellsize, int gridh, int gridw, int bb) {
/* 131 */     Block blk = Blocks.obsidian;
/* 132 */     if (bb != 0) blk = Blocks.bedrock; 
/* 133 */     if (fromx > tox) {
/* 134 */       int i = fromx;
/* 135 */       fromx = tox;
/* 136 */       tox = i;
/*     */     } 
/* 138 */     if (fromz > toz) {
/* 139 */       int i = fromz;
/* 140 */       fromz = toz;
/* 141 */       toz = i;
/*     */     } 
/* 143 */     if (fromx == tox) {
/* 144 */       int i = fromx;
/* 145 */       for (int j = fromz; j <= toz; j++) {
/* 146 */         if (j < cellsize * gridh) {
/* 147 */           OreSpawnMain.setBlockFast(world, i + x, y, j + z, blk, 0, 2);
/* 148 */           OreSpawnMain.setBlockFast(world, i + x, y + 1, j + z, blk, 0, 2);
/* 149 */           OreSpawnMain.setBlockFast(world, i + x, y + 2, j + z, blk, 0, 2);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 153 */       int j = fromz;
/* 154 */       for (int i = fromx; i <= tox; i++) {
/* 155 */         if (i < cellsize * gridw) {
/* 156 */           OreSpawnMain.setBlockFast(world, i + x, y, j + z, blk, 0, 2);
/* 157 */           OreSpawnMain.setBlockFast(world, i + x, y + 1, j + z, blk, 0, 2);
/* 158 */           OreSpawnMain.setBlockFast(world, i + x, y + 2, j + z, blk, 0, 2);
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
/*     */   private int findInNbr(Point p, int[][] cells, Vector inlist) {
/* 174 */     int d = rnd(4) - 1;
/* 175 */     int k = 0;
/* 176 */     while (k < 4) {
/*     */       
/* 178 */       switch (d) {
/*     */         
/*     */         case 0:
/* 181 */           if ((cells[p.x][p.y] & 0x10) == 0 && 
/* 182 */             inlist.indexOf(new Point(p.x, p.y - 1)) >= 0)
/* 183 */             return 1; 
/*     */           break;
/*     */         case 1:
/* 186 */           if ((cells[p.x][p.y] & 0x20) == 0 && 
/* 187 */             inlist.indexOf(new Point(p.x + 1, p.y)) >= 0)
/* 188 */             return 2; 
/*     */           break;
/*     */         case 2:
/* 191 */           if ((cells[p.x][p.y] & 0x40) == 0 && 
/* 192 */             inlist.indexOf(new Point(p.x, p.y + 1)) >= 0)
/* 193 */             return 4; 
/*     */           break;
/*     */         case 3:
/* 196 */           if ((cells[p.x][p.y] & 0x80) == 0 && 
/* 197 */             inlist.indexOf(new Point(p.x - 1, p.y)) >= 0)
/* 198 */             return 8; 
/*     */           break;
/*     */       } 
/* 201 */       d = (d + 1) % 4;
/* 202 */       k++;
/*     */     } 
/* 204 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void moveNbrs(Point p, int[][] cells, Vector outlist, Vector frontlist) {
/* 215 */     if ((cells[p.x][p.y] & 0x10) == 0) {
/*     */       
/* 217 */       Point s = new Point(p.x, p.y - 1);
/* 218 */       movePoint(s, outlist, frontlist);
/*     */     } 
/* 220 */     if ((cells[p.x][p.y] & 0x20) == 0) {
/*     */       
/* 222 */       Point s = new Point(p.x + 1, p.y);
/* 223 */       movePoint(s, outlist, frontlist);
/*     */     } 
/* 225 */     if ((cells[p.x][p.y] & 0x40) == 0) {
/*     */       
/* 227 */       Point s = new Point(p.x, p.y + 1);
/* 228 */       movePoint(s, outlist, frontlist);
/*     */     } 
/* 230 */     if ((cells[p.x][p.y] & 0x80) == 0) {
/*     */       
/* 232 */       Point s = new Point(p.x - 1, p.y);
/* 233 */       movePoint(s, outlist, frontlist);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void movePoint(Point p, Vector v, Vector<Point> w) {
/* 242 */     int i = v.indexOf(p);
/* 243 */     if (i >= 0) {
/*     */       
/* 245 */       v.removeElementAt(i);
/* 246 */       w.addElement(p);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeWall(Point p, int d, int[][] cells) {
/* 254 */     cells[p.x][p.y] = cells[p.x][p.y] ^ d;
/*     */ 
/*     */ 
/*     */     
/* 258 */     switch (d) {
/*     */       case 1:
/* 260 */         cells[p.x][p.y - 1] = cells[p.x][p.y - 1] ^ 0x4; break;
/*     */       case 2:
/* 262 */         cells[p.x + 1][p.y] = cells[p.x + 1][p.y] ^ 0x8; break;
/*     */       case 4:
/* 264 */         cells[p.x][p.y + 1] = cells[p.x][p.y + 1] ^ 0x1; break;
/*     */       case 8:
/* 266 */         cells[p.x - 1][p.y] = cells[p.x - 1][p.y] ^ 0x2;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int rnd(int n) {
/* 274 */     return (int)(Math.random() * n + 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   private Object rndElement(Vector v) {
/* 279 */     int i = rnd(v.size()) - 1;
/* 280 */     Object s = v.elementAt(i);
/* 281 */     v.removeElementAt(i);
/* 282 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   private Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 287 */     Entity var8 = null;
/*     */ 
/*     */     
/* 290 */     var8 = EntityList.createEntityByName(par1, par0World);
/*     */     
/* 292 */     if (var8 != null) {
/*     */ 
/*     */       
/* 295 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 298 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 300 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     
/* 303 */     return var8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void clearArea(World world, int x, int y, int z) {
/*     */     int i;
/* 312 */     for (i = 0; i < 60; i++) {
/* 313 */       int hi = 5;
/* 314 */       if (i >= 30) hi = 7; 
/* 315 */       for (int j = 0; j < hi; j++) {
/* 316 */         for (int k = 0; k < 30; k++) {
/* 317 */           OreSpawnMain.setBlockFast(world, x + i, y + j, z + k, Blocks.air, 0, 2);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 322 */     for (i = 0; i < 5; i++) {
/* 323 */       for (int j = 0; j < 6; j++) {
/* 324 */         for (int k = 0; k < 30; k++)
/* 325 */           OreSpawnMain.setBlockFast(world, x - i, y + j, z + k, Blocks.air, 0, 2); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void openMaze(World world, int xx, int yy, int zz, int xw, int zw, int csz) {
/*     */     int i;
/* 332 */     for (i = 0; i < zw * csz; i++) {
/* 333 */       Block bid = world.getBlock(xx + 1, yy, zz + i);
/* 334 */       if (bid == Blocks.air) {
/* 335 */         OreSpawnMain.setBlockFast(world, xx, yy, zz + i, Blocks.air, 0, 2);
/* 336 */         OreSpawnMain.setBlockFast(world, xx, yy + 1, zz + i, Blocks.air, 0, 2);
/* 337 */         OreSpawnMain.setBlockFast(world, xx, yy + 2, zz + i, Blocks.air, 0, 2);
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 342 */     for (i = zw * csz - 1; i >= 0; i--) {
/* 343 */       Block bid = world.getBlock(xx + xw * csz - 2, yy, zz + i);
/* 344 */       if (bid == Blocks.air) {
/* 345 */         OreSpawnMain.setBlockFast(world, xx + xw * csz - 1, yy, zz + i, Blocks.air, 0, 2);
/* 346 */         OreSpawnMain.setBlockFast(world, xx + xw * csz - 1, yy + 1, zz + i, Blocks.air, 0, 2);
/* 347 */         OreSpawnMain.setBlockFast(world, xx + xw * csz - 1, yy + 2, zz + i, Blocks.air, 0, 2);
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 354 */   private final WeightedRandomChestContent[] chestContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.ender_pearl, 0, 3, 6, 15), new WeightedRandomChestContent(Items.diamond, 0, 15, 25, 20), new WeightedRandomChestContent(Items.blaze_rod, 0, 4, 12, 15), new WeightedRandomChestContent(OreSpawnMain.CageEmpty, 0, 3, 10, 20), new WeightedRandomChestContent(OreSpawnMain.CagedGirlfriend, 0, 2, 4, 15), new WeightedRandomChestContent(Items.iron_ingot, 0, 2, 20, 20), new WeightedRandomChestContent(Items.gold_ingot, 0, 4, 16, 20), new WeightedRandomChestContent(OreSpawnMain.MyIngotUranium, 0, 2, 8, 20), new WeightedRandomChestContent(OreSpawnMain.MyIngotTitanium, 0, 2, 6, 20), new WeightedRandomChestContent(OreSpawnMain.MySunFish, 0, 2, 8, 20), new WeightedRandomChestContent(OreSpawnMain.MyFireFish, 0, 3, 8, 20), new WeightedRandomChestContent(OreSpawnMain.MyLavaEel, 0, 5, 24, 20), new WeightedRandomChestContent(OreSpawnMain.MyCornDog, 0, 6, 12, 20), new WeightedRandomChestContent(Items.diamond_pickaxe, 0, 1, 1, 15), new WeightedRandomChestContent(Items.diamond_sword, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyUltimatePickaxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyUltimateSword, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyUltimateFishingRod, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyUltimateBow, 0, 1, 1, 15), new WeightedRandomChestContent((Item)Items.diamond_chestplate, 0, 1, 1, 15), new WeightedRandomChestContent((Item)Items.diamond_helmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)Items.diamond_leggings, 0, 1, 1, 15), new WeightedRandomChestContent((Item)Items.diamond_boots, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateBoots, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyRuby, 0, 1, 1, 5), new WeightedRandomChestContent(OreSpawnMain.MyThunderStaff, 0, 1, 1, 5), new WeightedRandomChestContent(OreSpawnMain.MagicApple, 0, 1, 1, 15), new WeightedRandomChestContent(Items.golden_apple, 0, 2, 4, 15) };
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
/*     */   private void buildCastle(World world, int x, int y, int z) {
/*     */     int i;
/* 393 */     for (i = 0; i < 60; i++) {
/* 394 */       for (int j = 0; j < 30; j++) {
/* 395 */         OreSpawnMain.setBlockFast(world, x + i, y, z + j, Blocks.obsidian, 0, 2);
/*     */       }
/*     */     } 
/* 398 */     for (i = 0; i < 80; i++) {
/* 399 */       OreSpawnMain.setBlockFast(world, x + world.rand.nextInt(28) + 1, y, z + world.rand.nextInt(28) + 1, Blocks.lava, 0, 2);
/*     */     }
/*     */ 
/*     */     
/* 403 */     for (i = 0; i < 20; i++) {
/* 404 */       OreSpawnMain.setBlockFast(world, x + 30 + world.rand.nextInt(28) + 1, y, z + world.rand.nextInt(28) + 1, OreSpawnMain.MyRTPBlock, 0, 2);
/*     */     }
/*     */ 
/*     */     
/* 408 */     for (i = 0; i < 30; i++) {
/* 409 */       for (int j = 0; j < 30; j++) {
/* 410 */         OreSpawnMain.setBlockFast(world, x + i, y + 4, z + j, Blocks.bedrock, 0, 2);
/*     */       }
/*     */     } 
/* 413 */     for (i = 0; i < 30; i++) {
/* 414 */       for (int j = 0; j < 30; j++) {
/* 415 */         OreSpawnMain.setBlockFast(world, x + i + 30, y + 6, z + j, Blocks.bedrock, 0, 2);
/*     */       }
/*     */     } 
/* 418 */     for (i = 0; i < 30; i++) {
/* 419 */       for (int j = 0; j < 5; j++) {
/* 420 */         OreSpawnMain.setBlockFast(world, x + 59, y + j + 1, z + i, Blocks.obsidian, 0, 2);
/* 421 */         OreSpawnMain.setBlockFast(world, x + 60, y + j + 1, z + i, Blocks.bedrock, 0, 2);
/* 422 */         OreSpawnMain.setBlockFast(world, x + 61, y + j + 1, z + i, Blocks.bedrock, 0, 2);
/*     */       } 
/* 424 */     }  for (i = 0; i < 30; i++) {
/* 425 */       for (int j = 0; j < 5; j++) {
/* 426 */         OreSpawnMain.setBlockFast(world, x + 30 + i, y + j + 1, z, Blocks.obsidian, 0, 2);
/* 427 */         OreSpawnMain.setBlockFast(world, x + 30 + i, y + j + 1, z - 1, Blocks.bedrock, 0, 2);
/* 428 */         OreSpawnMain.setBlockFast(world, x + 30 + i, y + j + 1, z - 2, Blocks.bedrock, 0, 2);
/*     */       } 
/* 430 */     }  for (i = 0; i < 30; i++) {
/* 431 */       for (int j = 0; j < 5; j++) {
/* 432 */         OreSpawnMain.setBlockFast(world, x + 30 + i, y + j + 1, z + 29, Blocks.obsidian, 0, 2);
/* 433 */         OreSpawnMain.setBlockFast(world, x + 30 + i, y + j + 1, z + 30, Blocks.bedrock, 0, 2);
/* 434 */         OreSpawnMain.setBlockFast(world, x + 30 + i, y + j + 1, z + 31, Blocks.bedrock, 0, 2);
/*     */       } 
/*     */     } 
/* 437 */     for (i = 0; i < 30; i++) {
/* 438 */       OreSpawnMain.setBlockFast(world, x + 30, y + 5, z + i, Blocks.obsidian, 0, 2);
/*     */     }
/*     */     
/* 441 */     for (i = 0; i < 30; i++) {
/* 442 */       for (int j = 0; j < 4; j++)
/* 443 */         OreSpawnMain.setBlockFast(world, x - 4 + j, y, z + i, Blocks.sandstone, 0, 2); 
/*     */     } 
/* 445 */     for (i = 0; i < 30; i++) {
/* 446 */       for (int j = 0; j < 4; j++)
/* 447 */         OreSpawnMain.setBlockFast(world, x - 4 + j, y + 5, z + i, Blocks.obsidian, 0, 2); 
/*     */     } 
/* 449 */     for (i = 0; i < 30; i++) {
/* 450 */       for (int j = 1; j < 5; j++)
/* 451 */         OreSpawnMain.setBlockFast(world, x - 5, y + j, z + i, Blocks.iron_ore, 0, 2); 
/* 452 */     }  for (i = 0; i < 5; i++) {
/* 453 */       for (int j = 1; j < 5; j++)
/* 454 */         OreSpawnMain.setBlockFast(world, x - 4 + i, y + j, z - 1, Blocks.iron_ore, 0, 2); 
/* 455 */     }  for (i = 0; i < 5; i++) {
/* 456 */       for (int j = 1; j < 5; j++) {
/* 457 */         OreSpawnMain.setBlockFast(world, x - 4 + i, y + j, z + 30, Blocks.iron_ore, 0, 2);
/*     */       }
/*     */     } 
/*     */     int k;
/* 461 */     for (k = 0; k < 4; k++)
/* 462 */       OreSpawnMain.setBlockFast(world, x - 4, y + 1 + k, z, Blocks.sandstone, 0, 2); 
/* 463 */     for (k = 0; k < 4; k++)
/* 464 */       OreSpawnMain.setBlockFast(world, x - 4, y + 1 + k, z + 15, Blocks.sandstone, 0, 2); 
/* 465 */     for (k = 0; k < 4; k++) {
/* 466 */       OreSpawnMain.setBlockFast(world, x - 4, y + 1 + k, z + 29, Blocks.sandstone, 0, 2);
/*     */     }
/* 468 */     OreSpawnMain.setBlockFast(world, x - 3, y + 3, z, OreSpawnMain.ExtremeTorch, 0, 2);
/* 469 */     OreSpawnMain.setBlockFast(world, x - 3, y + 3, z + 15, OreSpawnMain.ExtremeTorch, 0, 2);
/* 470 */     OreSpawnMain.setBlockFast(world, x - 3, y + 3, z + 29, OreSpawnMain.ExtremeTorch, 0, 2);
/*     */     
/* 472 */     OreSpawnMain.setBlockFast(world, x + 30, y + 4, z + 2, Blocks.redstone_torch, 0, 2);
/* 473 */     OreSpawnMain.setBlockFast(world, x + 30, y + 4, z + 15, Blocks.redstone_torch, 0, 2);
/* 474 */     OreSpawnMain.setBlockFast(world, x + 30, y + 4, z + 27, Blocks.redstone_torch, 0, 2);
/*     */ 
/*     */     
/* 477 */     TileEntityChest chest = null;
/* 478 */     i = 2 + world.rand.nextInt(3);
/* 479 */     for (k = 0; k < i; k++) {
/* 480 */       OreSpawnMain.setBlockFast(world, x + 58, y + 4, z + 2 + k * 2, Blocks.torch, 0, 2);
/* 481 */       OreSpawnMain.setBlockFast(world, x + 58, y + 1, z + 2 + k * 2, (Block)Blocks.chest, 0, 2);
/* 482 */       chest = (TileEntityChest)world.getTileEntity(x + 58, y + 1, z + 2 + k * 2);
/* 483 */       if (chest != null)
/*     */       {
/*     */         
/* 486 */         WeightedRandomChestContent.generateChestContents(world.rand, this.chestContentsList, (IInventory)chest, 5 + world.rand.nextInt(6));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 492 */     Entity ent = null;
/* 493 */     ent = spawnCreature(world, "Basilisk", x + 45.0D, y + 1.01D, z + 15.0D);
/* 494 */     if (ent != null) {
/* 495 */       Basilisk b = (Basilisk)ent;
/* 496 */       b.enablePersistence();
/*     */     } 
/* 498 */     ent = spawnCreature(world, "Basilisk", x + 46.0D, y + 1.01D, z + 15.0D);
/* 499 */     if (ent != null) {
/* 500 */       Basilisk b = (Basilisk)ent;
/* 501 */       b.enablePersistence();
/*     */     } 
/* 503 */     ent = spawnCreature(world, "Basilisk", x + 47.0D, y + 1.01D, z + 15.0D);
/* 504 */     if (ent != null) {
/* 505 */       Basilisk b = (Basilisk)ent;
/* 506 */       b.enablePersistence();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void makeEntrance(World world, int x, int y, int z, int depth) {
/* 514 */     int width = 8;
/*     */     int j;
/* 516 */     for (j = width; j >= 0; j--) {
/* 517 */       for (int i = 0; i < j * 2 + 4; i++) {
/* 518 */         OreSpawnMain.setBlockFast(world, x + i - j, y + width - j, z - j, Blocks.sandstone, 0, 2);
/* 519 */         OreSpawnMain.setBlockFast(world, x + i - j, y + width - j, z + j + 3, Blocks.sandstone, 0, 2);
/* 520 */         OreSpawnMain.setBlockFast(world, x - j, y + width - j, z + i - j, Blocks.sandstone, 0, 2);
/* 521 */         OreSpawnMain.setBlockFast(world, x + j + 3, y + width - j, z + i - j, Blocks.sandstone, 0, 2);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 526 */     int k = 0;
/* 527 */     for (j = width; j > -depth; j--) {
/* 528 */       for (int i = 0; i < 4; i++) {
/* 529 */         OreSpawnMain.setBlockFast(world, x + i, y + j, z, Blocks.bedrock, 0, 2);
/* 530 */         OreSpawnMain.setBlockFast(world, x + i, y + j, z + 3, Blocks.bedrock, 0, 2);
/* 531 */         OreSpawnMain.setBlockFast(world, x, y + j, z + i, Blocks.bedrock, 0, 2);
/* 532 */         OreSpawnMain.setBlockFast(world, x + 3, y + j, z + i, Blocks.bedrock, 0, 2);
/*     */       } 
/*     */ 
/*     */       
/* 536 */       for (int l = 0; l < 2; l++) {
/* 537 */         for (int m = 0; m < 2; m++) {
/* 538 */           OreSpawnMain.setBlockFast(world, x + 1 + l, y + j, z + 1 + m, Blocks.air, 0, 2);
/*     */         }
/*     */       } 
/* 541 */       switch (k) {
/*     */         case 0:
/* 543 */           OreSpawnMain.setBlockFast(world, x + 1, y + j, z + 1, Blocks.obsidian, 0, 2);
/*     */           break;
/*     */         case 1:
/* 546 */           OreSpawnMain.setBlockFast(world, x + 2, y + j, z + 1, Blocks.obsidian, 0, 2);
/*     */           break;
/*     */         case 2:
/* 549 */           OreSpawnMain.setBlockFast(world, x + 2, y + j, z + 2, Blocks.obsidian, 0, 2);
/*     */           break;
/*     */         default:
/* 552 */           OreSpawnMain.setBlockFast(world, x + 1, y + j, z + 2, Blocks.obsidian, 0, 2);
/*     */           break;
/*     */       } 
/* 555 */       k++;
/* 556 */       if (k > 3) k = 0; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BasiliskMaze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */