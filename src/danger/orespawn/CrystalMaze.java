/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.awt.Point;
/*     */ import java.util.Vector;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.Chunk;
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
/*     */ public class CrystalMaze
/*     */ {
/*     */   public static final int WTOP = 1;
/*     */   public static final int WRGT = 2;
/*     */   public static final int WBOT = 4;
/*     */   public static final int WLFT = 8;
/*     */   
/*     */   public void buildCrystalMaze(World world, int x, int y, int z, Chunk chunk) {
/*  30 */     for (int i = 0; i < 16; i++) {
/*  31 */       for (int j = 0; j < 16; j++) {
/*  32 */         for (int k = 0; k < 3; k++) {
/*  33 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x + j, y + k, z + i, Blocks.air, 0);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  38 */     makeMaze(world, x, y, z, 4, 4, 4, 1, chunk);
/*     */     
/*  40 */     openCrystalMaze(world, x, y, z, 4, 4, 4, chunk);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void openCrystalMaze(World world, int xx, int yy, int zz, int xw, int zw, int csz, Chunk chunk) {
/*     */     int i;
/*  47 */     for (i = 0; i < zw * csz; i++) {
/*  48 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx, yy, zz + i, Blocks.air, 0);
/*  49 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx, yy + 1, zz + i, Blocks.air, 0);
/*  50 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx, yy + 2, zz + i, Blocks.air, 0);
/*  51 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + i, yy, zz, Blocks.air, 0);
/*  52 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + i, yy + 1, zz, Blocks.air, 0);
/*  53 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + i, yy + 2, zz, Blocks.air, 0);
/*  54 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + zw * csz - 1, yy, zz + i, Blocks.air, 0);
/*  55 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + zw * csz - 1, yy + 1, zz + i, Blocks.air, 0);
/*  56 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + zw * csz - 1, yy + 2, zz + i, Blocks.air, 0);
/*  57 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + i, yy, zz + zw * csz - 1, Blocks.air, 0);
/*  58 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + i, yy + 1, zz + zw * csz - 1, Blocks.air, 0);
/*  59 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + i, yy + 2, zz + zw * csz - 1, Blocks.air, 0);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  64 */     for (i = 0; i < zw * csz; i++) {
/*  65 */       for (int m = 0; m < zw * csz; m++) {
/*  66 */         OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + m, yy - 1, zz + i, Blocks.bedrock, 0);
/*  67 */         OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + m, yy + 3, zz + i, Blocks.bedrock, 0);
/*     */       } 
/*     */     } 
/*     */     
/*  71 */     for (int k = 0; k < 4; k++) {
/*  72 */       i = world.rand.nextInt(zw * csz);
/*  73 */       int m = world.rand.nextInt(zw * csz);
/*  74 */       OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + m, yy + 3, zz + i, OreSpawnMain.CrystalStone, 0);
/*     */     } 
/*  76 */     i = world.rand.nextInt(zw * csz);
/*  77 */     int j = world.rand.nextInt(zw * csz);
/*  78 */     OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + j, yy - 1, zz + i, OreSpawnMain.CrystalStone, 0);
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
/*     */   private void makeMaze(World world, int xx, int yy, int zz, int xw, int zw, int csz, int b, Chunk chunk) {
/*  92 */     int gridw = xw;
/*  93 */     int gridh = zw;
/*  94 */     int cellsize = csz;
/*  95 */     if (cellsize < 3) cellsize = 3;
/*     */     
/*  97 */     int[][] cells = new int[gridw][gridh];
/*     */ 
/*     */ 
/*     */     
/* 101 */     int full = 15; int x;
/* 102 */     for (x = 0; x < gridw; x++) {
/* 103 */       for (int i = 0; i < gridh; i++) {
/* 104 */         cells[x][i] = full;
/*     */       }
/*     */     } 
/* 107 */     int left = 128;
/* 108 */     int right = 32; int y;
/* 109 */     for (y = 0; y < gridh; y++) {
/*     */       
/* 111 */       cells[0][y] = cells[0][y] | left;
/* 112 */       cells[gridw - 1][y] = cells[gridw - 1][y] | right;
/*     */     } 
/* 114 */     int top = 16;
/* 115 */     int bottom = 64;
/* 116 */     for (x = 0; x < gridw; x++) {
/*     */       
/* 118 */       cells[x][0] = cells[x][0] | top;
/* 119 */       cells[x][gridh - 1] = cells[x][gridh - 1] | bottom;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 125 */     Vector<Point> outlist = new Vector(gridw * gridh);
/* 126 */     Vector<Point> inlist = new Vector(10, 10);
/* 127 */     Vector frontlist = new Vector(10, 10);
/* 128 */     for (x = 0; x < gridw; x++) {
/* 129 */       for (y = 0; y < gridh; y++)
/* 130 */         outlist.addElement(new Point(x, y)); 
/* 131 */     }  Point current_cell = (Point)rndElement(outlist);
/* 132 */     inlist.addElement(current_cell);
/* 133 */     moveNbrs(current_cell, cells, outlist, frontlist);
/*     */     
/* 135 */     while (!frontlist.isEmpty()) {
/*     */       
/* 137 */       current_cell = (Point)rndElement(frontlist);
/* 138 */       inlist.addElement(current_cell);
/* 139 */       moveNbrs(current_cell, cells, outlist, frontlist);
/* 140 */       int dir = findInNbr(current_cell, cells, inlist);
/* 141 */       removeWall(current_cell, dir, cells);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 146 */     current_cell = null;
/*     */ 
/*     */ 
/*     */     
/* 150 */     for (x = 0; x < gridw; x++) {
/* 151 */       for (y = 0; y < gridh; y++) {
/*     */         
/* 153 */         int val = cells[x][y];
/* 154 */         if ((val & 0x1) != 0) {
/* 155 */           drawSide(world, x * cellsize, y * cellsize, (x + 1) * cellsize, y * cellsize, xx, yy, zz, cellsize, gridh, gridw, b, chunk);
/*     */         }
/*     */         
/* 158 */         if ((val & 0x2) != 0) {
/* 159 */           drawSide(world, (x + 1) * cellsize - 1, y * cellsize, (x + 1) * cellsize - 1, (y + 1) * cellsize, xx, yy, zz, cellsize, gridh, gridw, b, chunk);
/*     */         }
/*     */         
/* 162 */         if ((val & 0x4) != 0) {
/* 163 */           drawSide(world, x * cellsize, (y + 1) * cellsize - 1, (x + 1) * cellsize, (y + 1) * cellsize - 1, xx, yy, zz, cellsize, gridh, gridw, b, chunk);
/*     */         }
/*     */         
/* 166 */         if ((val & 0x8) != 0) {
/* 167 */           drawSide(world, x * cellsize, y * cellsize, x * cellsize, (y + 1) * cellsize, xx, yy, zz, cellsize, gridh, gridw, b, chunk);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawSide(World world, int fromx, int fromz, int tox, int toz, int x, int y, int z, int cellsize, int gridh, int gridw, int bb, Chunk chunk) {
/* 175 */     Block blk = Blocks.obsidian;
/* 176 */     if (bb != 0) blk = Blocks.bedrock; 
/* 177 */     if (fromx > tox) {
/* 178 */       int i = fromx;
/* 179 */       fromx = tox;
/* 180 */       tox = i;
/*     */     } 
/* 182 */     if (fromz > toz) {
/* 183 */       int i = fromz;
/* 184 */       fromz = toz;
/* 185 */       toz = i;
/*     */     } 
/* 187 */     if (fromx == tox) {
/* 188 */       int i = fromx;
/* 189 */       for (int j = fromz; j <= toz; j++) {
/* 190 */         if (j < cellsize * gridh) {
/* 191 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, i + x, y, j + z, blk, 0);
/* 192 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, i + x, y + 1, j + z, blk, 0);
/* 193 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, i + x, y + 2, j + z, blk, 0);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 197 */       int j = fromz;
/* 198 */       for (int i = fromx; i <= tox; i++) {
/* 199 */         if (i < cellsize * gridw) {
/* 200 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, i + x, y, j + z, blk, 0);
/* 201 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, i + x, y + 1, j + z, blk, 0);
/* 202 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, i + x, y + 2, j + z, blk, 0);
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
/* 218 */     int d = rnd(4) - 1;
/* 219 */     int k = 0;
/* 220 */     while (k < 4) {
/*     */       
/* 222 */       switch (d) {
/*     */         
/*     */         case 0:
/* 225 */           if ((cells[p.x][p.y] & 0x10) == 0 && 
/* 226 */             inlist.indexOf(new Point(p.x, p.y - 1)) >= 0)
/* 227 */             return 1; 
/*     */           break;
/*     */         case 1:
/* 230 */           if ((cells[p.x][p.y] & 0x20) == 0 && 
/* 231 */             inlist.indexOf(new Point(p.x + 1, p.y)) >= 0)
/* 232 */             return 2; 
/*     */           break;
/*     */         case 2:
/* 235 */           if ((cells[p.x][p.y] & 0x40) == 0 && 
/* 236 */             inlist.indexOf(new Point(p.x, p.y + 1)) >= 0)
/* 237 */             return 4; 
/*     */           break;
/*     */         case 3:
/* 240 */           if ((cells[p.x][p.y] & 0x80) == 0 && 
/* 241 */             inlist.indexOf(new Point(p.x - 1, p.y)) >= 0)
/* 242 */             return 8; 
/*     */           break;
/*     */       } 
/* 245 */       d = (d + 1) % 4;
/* 246 */       k++;
/*     */     } 
/* 248 */     return 0;
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
/* 259 */     if ((cells[p.x][p.y] & 0x10) == 0) {
/*     */       
/* 261 */       Point s = new Point(p.x, p.y - 1);
/* 262 */       movePoint(s, outlist, frontlist);
/*     */     } 
/* 264 */     if ((cells[p.x][p.y] & 0x20) == 0) {
/*     */       
/* 266 */       Point s = new Point(p.x + 1, p.y);
/* 267 */       movePoint(s, outlist, frontlist);
/*     */     } 
/* 269 */     if ((cells[p.x][p.y] & 0x40) == 0) {
/*     */       
/* 271 */       Point s = new Point(p.x, p.y + 1);
/* 272 */       movePoint(s, outlist, frontlist);
/*     */     } 
/* 274 */     if ((cells[p.x][p.y] & 0x80) == 0) {
/*     */       
/* 276 */       Point s = new Point(p.x - 1, p.y);
/* 277 */       movePoint(s, outlist, frontlist);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void movePoint(Point p, Vector v, Vector<Point> w) {
/* 286 */     int i = v.indexOf(p);
/* 287 */     if (i >= 0) {
/*     */       
/* 289 */       v.removeElementAt(i);
/* 290 */       w.addElement(p);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeWall(Point p, int d, int[][] cells) {
/* 298 */     cells[p.x][p.y] = cells[p.x][p.y] ^ d;
/*     */ 
/*     */ 
/*     */     
/* 302 */     switch (d) {
/*     */       case 1:
/* 304 */         cells[p.x][p.y - 1] = cells[p.x][p.y - 1] ^ 0x4; break;
/*     */       case 2:
/* 306 */         cells[p.x + 1][p.y] = cells[p.x + 1][p.y] ^ 0x8; break;
/*     */       case 4:
/* 308 */         cells[p.x][p.y + 1] = cells[p.x][p.y + 1] ^ 0x1; break;
/*     */       case 8:
/* 310 */         cells[p.x - 1][p.y] = cells[p.x - 1][p.y] ^ 0x2;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int rnd(int n) {
/* 318 */     return (int)(Math.random() * n + 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   private Object rndElement(Vector v) {
/* 323 */     int i = rnd(v.size()) - 1;
/* 324 */     Object s = v.elementAt(i);
/* 325 */     v.removeElementAt(i);
/* 326 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void clearArea(World world, int x, int y, int z, Chunk chunk) {
/*     */     int i;
/* 336 */     for (i = 0; i < 60; i++) {
/* 337 */       int hi = 5;
/* 338 */       if (i >= 30) hi = 7; 
/* 339 */       for (int j = 0; j < hi; j++) {
/* 340 */         for (int k = 0; k < 30; k++) {
/* 341 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x + i, y + j, z + k, Blocks.air, 0);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 346 */     for (i = 0; i < 5; i++) {
/* 347 */       for (int j = 0; j < 6; j++) {
/* 348 */         for (int k = 0; k < 30; k++)
/* 349 */           OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x - i, y + j, z + k, Blocks.air, 0); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CrystalMaze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */