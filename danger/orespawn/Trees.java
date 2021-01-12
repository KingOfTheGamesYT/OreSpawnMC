/*      */ package danger.orespawn;
/*      */ 
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.inventory.IInventory;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.tileentity.TileEntityChest;
/*      */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*      */ import net.minecraft.util.WeightedRandomChestContent;
/*      */ import net.minecraft.world.World;
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
/*      */ public class Trees
/*      */ {
/*      */   private void WindTreeBranch(World world, int x, int y, int z, int length, int dirx, int dirz) {
/*   25 */     for (int i = 1; i <= length; i++) {
/*   26 */       OreSpawnMain.setBlockFast(world, x + i * dirx, y, z + i * dirz, Blocks.log, 0, 2);
/*      */       
/*   28 */       if (Blocks.air == world.getBlock(x + i * dirx, y + 1, z + i * dirz)) {
/*   29 */         OreSpawnMain.setBlockFast(world, x + i * dirx, y + 1, z + i * dirz, (Block)Blocks.leaves, 0, 2);
/*      */       }
/*   31 */       if (i < length / 3 && 
/*   32 */         Blocks.air == world.getBlock(x + i * dirx, y + 2, z + i * dirz)) {
/*   33 */         OreSpawnMain.setBlockFast(world, x + i * dirx, y + 2, z + i * dirz, (Block)Blocks.leaves, 0, 2);
/*      */       }
/*      */       
/*   36 */       if (i > length / 3) {
/*      */         
/*   38 */         if (Blocks.air == world.getBlock(x + i * dirx + dirz, y, z + i * dirz + dirx)) {
/*   39 */           OreSpawnMain.setBlockFast(world, x + i * dirx + dirz, y, z + i * dirz + dirx, (Block)Blocks.leaves, 0, 2);
/*      */         }
/*   41 */         if (Blocks.air == world.getBlock(x + i * dirx - dirz, y, z + i * dirz - dirx)) {
/*   42 */           OreSpawnMain.setBlockFast(world, x + i * dirx - dirz, y, z + i * dirz - dirx, (Block)Blocks.leaves, 0, 2);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*   48 */     if (Blocks.air == world.getBlock(x + (length + 1) * dirx, y, z + (length + 1) * dirz)) {
/*   49 */       OreSpawnMain.setBlockFast(world, x + (length + 1) * dirx, y, z + (length + 1) * dirz, (Block)Blocks.leaves, 0, 2);
/*      */     }
/*   51 */     if (Blocks.air == world.getBlock(x + (length + 2) * dirx, y, z + (length + 2) * dirz)) {
/*   52 */       OreSpawnMain.setBlockFast(world, x + (length + 2) * dirx, y, z + (length + 2) * dirz, (Block)Blocks.leaves, 0, 2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void WindTree(World world, int x, int y, int z, int dir) {
/*   62 */     if (dir < 0 || dir > 3)
/*   63 */       return;  int dirx = 1, dirz = 0;
/*   64 */     if (dir == 1) {
/*   65 */       dirx = -1; dirz = 0;
/*      */     } 
/*   67 */     if (dir == 2) {
/*   68 */       dirx = 0; dirz = 1;
/*      */     } 
/*   70 */     if (dir == 3) {
/*   71 */       dirx = 0; dirz = -1;
/*      */     } 
/*      */ 
/*      */     
/*   75 */     Block bid = world.getBlock(x, y, z);
/*   76 */     if (bid != Blocks.grass && bid != Blocks.dirt) {
/*      */       return;
/*      */     }
/*      */     
/*   80 */     int height = world.rand.nextInt(8) + 40;
/*   81 */     int width = world.rand.nextInt(4) + 8;
/*      */ 
/*      */     
/*   84 */     for (int j = 0; j < height; j++) {
/*   85 */       OreSpawnMain.setBlockFast(world, x, j + y, z, Blocks.log, 0, 2);
/*   86 */       if (j > height / 5) {
/*      */         
/*   88 */         OreSpawnMain.setBlockFast(world, x + dirx, j + y, z + dirz, (Block)Blocks.leaves, 0, 2);
/*   89 */         if (j > height / 4 && j % 4 == 0)
/*      */         {
/*   91 */           WindTreeBranch(world, x, j + y, z, height - j, dirx, dirz);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*   97 */     OreSpawnMain.setBlockFast(world, x, y + height, z, (Block)Blocks.leaves, 0, 2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void SkyTreeBranch(World world, int x, int y, int z, int length, int dirx, int dirz) {
/*  104 */     for (int i = 1; i < length; i++) {
/*  105 */       OreSpawnMain.setBlockFast(world, x + i * dirx, y, z + i * dirz, OreSpawnMain.MySkyTreeLog, 0, 2);
/*      */       
/*  107 */       if (Blocks.air == world.getBlock(x + i * dirx, y + 1, z + i * dirz)) {
/*  108 */         OreSpawnMain.setBlockFast(world, x + i * dirx, y + 1, z + i * dirz, (Block)Blocks.leaves, 0, 2);
/*      */       }
/*      */       
/*  111 */       if (Blocks.air == world.getBlock(x + i * dirx + dirz, y, z + i * dirz + dirx)) {
/*  112 */         OreSpawnMain.setBlockFast(world, x + i * dirx + dirz, y, z + i * dirz + dirx, (Block)Blocks.leaves, 0, 2);
/*      */       }
/*  114 */       if (Blocks.air == world.getBlock(x + i * dirx - dirz, y, z + i * dirz - dirx)) {
/*  115 */         OreSpawnMain.setBlockFast(world, x + i * dirx - dirz, y, z + i * dirz - dirx, (Block)Blocks.leaves, 0, 2);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  120 */     if (Blocks.air == world.getBlock(x + length * dirx, y, z + length * dirz)) {
/*  121 */       OreSpawnMain.setBlockFast(world, x + length * dirx, y, z + length * dirz, (Block)Blocks.leaves, 0, 2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void SkyTree(World world, int x, int y, int z) {
/*  131 */     Block bid = world.getBlock(x, y, z);
/*  132 */     if (bid != Blocks.grass && bid != Blocks.dirt) {
/*      */       return;
/*      */     }
/*      */     
/*  136 */     int height = world.rand.nextInt(15) + 190;
/*      */     
/*  138 */     if (height - y < 20)
/*      */       return; 
/*  140 */     int width = world.rand.nextInt(10) + 25;
/*      */ 
/*      */     
/*  143 */     for (int j = y; j <= height; j++) {
/*  144 */       OreSpawnMain.setBlockFast(world, x, j, z, OreSpawnMain.MySkyTreeLog, 0, 2);
/*      */     }
/*  146 */     OreSpawnMain.setBlockFast(world, x, height + 1, z, (Block)Blocks.leaves, 0, 2);
/*      */ 
/*      */     
/*  149 */     SkyTreeBranch(world, x, height, z, width, 1, 0);
/*  150 */     SkyTreeBranch(world, x, height, z, width, -1, 0);
/*  151 */     SkyTreeBranch(world, x, height, z, width, 0, 1);
/*  152 */     SkyTreeBranch(world, x, height, z, width, 0, -1);
/*      */ 
/*      */     
/*  155 */     height -= 5;
/*  156 */     height -= world.rand.nextInt(4);
/*  157 */     width /= 3;
/*  158 */     SkyTreeBranch(world, x, height, z, width, 1, 0);
/*  159 */     SkyTreeBranch(world, x, height, z, width, -1, 0);
/*  160 */     SkyTreeBranch(world, x, height, z, width, 0, 1);
/*  161 */     SkyTreeBranch(world, x, height, z, width, 0, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void DuplicatorTree(World world, int x, int y, int z) {
/*  168 */     int realy = y;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  175 */     Block bid = world.getBlock(x, y - 1, z);
/*  176 */     if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
/*  177 */       bid = world.getBlock(x, y - 2, z);
/*  178 */       if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
/*  179 */         bid = world.getBlock(x, y - 3, z);
/*  180 */         if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
/*      */           return;
/*      */         }
/*      */ 
/*      */         
/*  185 */         realy = y - 3;
/*      */       } else {
/*      */         
/*  188 */         realy = y - 2;
/*      */       } 
/*      */       return;
/*      */     } 
/*  192 */     realy = y - 1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  197 */     bid = world.getBlock(x, realy + 1, z);
/*  198 */     if (bid != OreSpawnMain.MyDT) {
/*  199 */       OreSpawnMain.setBlockFast(world, x, realy + 1, z, OreSpawnMain.MyDT, 0, 2);
/*      */       return;
/*      */     } 
/*  202 */     bid = world.getBlock(x, realy + 2, z);
/*  203 */     if (bid != OreSpawnMain.MyDT) {
/*  204 */       OreSpawnMain.setBlockFast(world, x, realy + 2, z, OreSpawnMain.MyDT, 0, 2);
/*      */       return;
/*      */     } 
/*  207 */     bid = world.getBlock(x, realy + 3, z);
/*  208 */     if (bid != OreSpawnMain.MyDT) {
/*  209 */       OreSpawnMain.setBlockFast(world, x, realy + 3, z, OreSpawnMain.MyDT, 0, 2);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  214 */     bid = world.getBlock(x, realy + 4, z);
/*  215 */     if (bid != OreSpawnMain.MyAppleLeaves) {
/*  216 */       OreSpawnMain.setBlockFast(world, x, realy + 4, z, OreSpawnMain.MyAppleLeaves, 0, 2); return;
/*      */     } 
/*      */     int i;
/*  219 */     for (i = -1; i <= 1; i++) {
/*  220 */       for (int j = -1; j <= 1; j++) {
/*  221 */         if (j != 0 || i != 0) {
/*  222 */           bid = world.getBlock(x + i, realy + 3, z + j);
/*  223 */           if (bid != OreSpawnMain.MyAppleLeaves) {
/*  224 */             OreSpawnMain.setBlockFast(world, x + i, realy + 3, z + j, OreSpawnMain.MyAppleLeaves, 0, 2);
/*      */             
/*      */             return;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  231 */     Block bidm = Blocks.air;
/*  232 */     for (int tries = 0; tries < 20 && (bidm == Blocks.air || bidm == OreSpawnMain.MyDT); tries++) {
/*  233 */       i = world.rand.nextInt(5) - 2;
/*  234 */       int j = world.rand.nextInt(5) - 2;
/*  235 */       bidm = world.getBlock(x + i, realy + 1, z + j);
/*  236 */       int meta = world.getBlockMetadata(x + i, realy + 1, z + j);
/*  237 */       if (bidm != Blocks.air && bidm != OreSpawnMain.MyDT)
/*      */       {
/*  239 */         for (int k = 0; k < 20; k++) {
/*  240 */           i = world.rand.nextInt(5) - 2;
/*  241 */           j = world.rand.nextInt(5) - 2;
/*  242 */           bid = world.getBlock(x + i, realy + 1, z + j);
/*  243 */           if (bid == Blocks.air) {
/*      */             
/*  245 */             world.setBlock(x + i, realy + 1, z + j, bidm, meta, 2);
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
/*      */ 
/*      */ 
/*      */   
/*      */   private void make_leaves(World world, int x, int y, int z) {
/*  260 */     for (int l1 = -3; l1 <= 3; l1++) {
/*  261 */       for (int l2 = -3; l2 <= 3; l2++) {
/*  262 */         for (int l3 = 0; l3 <= 2; l3++) {
/*  263 */           Block bid = world.getBlock(x + l1, y + l3, z + l2);
/*  264 */           if (bid == Blocks.air) OreSpawnMain.setBlockFast(world, x + l1, y + l3, z + l2, OreSpawnMain.MyExperienceLeaves, 0, 2);
/*      */         
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void grow_small_branch(World world, int x, int y, int z, int xdir, int zdir, int xxdir, int zzdir) {
/*  272 */     int i2 = 0, k2 = 0, j2 = 0;
/*      */ 
/*      */     
/*  275 */     int i = x;
/*  276 */     int j = y;
/*  277 */     int k = z;
/*  278 */     int grow = 4 + world.rand.nextInt(2); int n;
/*  279 */     for (n = 0; n < grow; n++) {
/*  280 */       OreSpawnMain.setBlockFast(world, i, j, k, Blocks.log, 0, 2);
/*  281 */       make_leaves(world, i, j, k);
/*  282 */       j++;
/*  283 */       i += xdir;
/*  284 */       k += zdir;
/*  285 */       i2 = i;
/*  286 */       k2 = k;
/*      */     } 
/*  288 */     grow = 4 + world.rand.nextInt(3);
/*  289 */     for (n = 0; n < grow; n++) {
/*  290 */       OreSpawnMain.setBlockFast(world, i, j, k, Blocks.log, 0, 2);
/*  291 */       make_leaves(world, i, j, k);
/*  292 */       i += xdir;
/*  293 */       k += zdir;
/*      */     } 
/*  295 */     grow = 4 + world.rand.nextInt(3);
/*  296 */     for (n = 0; n < grow; n++) {
/*  297 */       OreSpawnMain.setBlockFast(world, i2, j, k2, Blocks.log, 0, 2);
/*  298 */       make_leaves(world, i2, j, k2);
/*  299 */       i2 += xxdir;
/*  300 */       k2 += zzdir;
/*      */     } 
/*      */     
/*  303 */     j2 = --j;
/*  304 */     grow = 3 + world.rand.nextInt(3);
/*  305 */     for (n = 0; n < grow; n++) {
/*  306 */       OreSpawnMain.setBlockFast(world, i, j, k, Blocks.log, 0, 2);
/*  307 */       make_leaves(world, i, j, k);
/*  308 */       i += xdir;
/*  309 */       k += zdir;
/*  310 */       j--;
/*      */     } 
/*  312 */     grow = 3 + world.rand.nextInt(3);
/*  313 */     for (n = 0; n < grow; n++) {
/*  314 */       OreSpawnMain.setBlockFast(world, i2, j2, k2, Blocks.log, 0, 2);
/*  315 */       make_leaves(world, i2, j2, k2);
/*  316 */       i2 += xxdir;
/*  317 */       k2 += zzdir;
/*  318 */       j2--;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void grow_branch(World world, int x, int y, int z, int xdir, int zdir, int xxdir, int zzdir) {
/*  325 */     int i2 = 0, k2 = 0, j2 = 0;
/*      */ 
/*      */     
/*  328 */     int i = x;
/*  329 */     int j = y;
/*  330 */     int k = z;
/*      */     
/*  332 */     int grow = 5 + world.rand.nextInt(4); int n;
/*  333 */     for (n = 0; n < grow; n++) {
/*  334 */       OreSpawnMain.setBlockFast(world, i, j, k, Blocks.log, 0, 2);
/*  335 */       make_leaves(world, i, j, k);
/*  336 */       j++;
/*  337 */       i += xdir;
/*  338 */       k += zdir;
/*  339 */       i2 = i;
/*  340 */       k2 = k;
/*      */     } 
/*  342 */     grow = 6 + world.rand.nextInt(5);
/*  343 */     for (n = 0; n < grow; n++) {
/*  344 */       OreSpawnMain.setBlockFast(world, i, j, k, Blocks.log, 0, 2);
/*  345 */       make_leaves(world, i, j, k);
/*  346 */       i += xdir;
/*  347 */       k += zdir;
/*      */     } 
/*  349 */     grow = 6 + world.rand.nextInt(5);
/*  350 */     for (n = 0; n < grow; n++) {
/*  351 */       OreSpawnMain.setBlockFast(world, i2, j, k2, Blocks.log, 0, 2);
/*  352 */       make_leaves(world, i2, j, k2);
/*  353 */       i2 += xxdir;
/*  354 */       k2 += zzdir;
/*      */     } 
/*      */     
/*  357 */     j2 = --j;
/*  358 */     grow = 4 + world.rand.nextInt(4);
/*  359 */     for (n = 0; n < grow; n++) {
/*  360 */       OreSpawnMain.setBlockFast(world, i, j, k, Blocks.log, 0, 2);
/*  361 */       make_leaves(world, i, j, k);
/*  362 */       i += xdir;
/*  363 */       k += zdir;
/*  364 */       j--;
/*      */     } 
/*  366 */     grow = 4 + world.rand.nextInt(4);
/*  367 */     for (n = 0; n < grow; n++) {
/*  368 */       OreSpawnMain.setBlockFast(world, i2, j2, k2, Blocks.log, 0, 2);
/*  369 */       make_leaves(world, i2, j2, k2);
/*  370 */       i2 += xxdir;
/*  371 */       k2 += zzdir;
/*  372 */       j2--;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ExperienceTree(World world, int x, int y, int z) {
/*  382 */     Block bid = world.getBlock(x, y, z);
/*  383 */     if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
/*      */       return;
/*      */     }
/*      */     
/*      */     int j;
/*  388 */     for (j = 1; j < 6; j++) {
/*  389 */       for (int i = 0; i < 2; i++) {
/*  390 */         for (int k = 0; k < 2; k++) {
/*  391 */           OreSpawnMain.setBlockFast(world, x + i, y + j, z + k, Blocks.log, 0, 2);
/*      */         }
/*      */       } 
/*      */     } 
/*  395 */     grow_branch(world, x, y + 6, z, 0, 1, 1, 1);
/*  396 */     grow_branch(world, x + 1, y + 6, z, 1, 0, 1, -1);
/*  397 */     grow_branch(world, x, y + 6, z + 1, -1, 0, -1, 1);
/*  398 */     grow_branch(world, x + 1, y + 6, z + 1, 0, -1, -1, -1);
/*      */ 
/*      */     
/*  401 */     for (j = 7; j < 19; j++) {
/*  402 */       for (int i = 0; i < 2; i++) {
/*  403 */         for (int k = 0; k < 2; k++) {
/*  404 */           OreSpawnMain.setBlockFast(world, x + i, y + j, z + k, Blocks.log, 0, 2);
/*      */         }
/*      */       } 
/*      */     } 
/*  408 */     grow_small_branch(world, x, y + 19, z, 0, 1, -1, 1);
/*  409 */     grow_small_branch(world, x + 1, y + 19, z, 1, 0, 1, 1);
/*  410 */     grow_small_branch(world, x, y + 19, z + 1, -1, 0, -1, -1);
/*  411 */     grow_small_branch(world, x + 1, y + 19, z + 1, 0, -1, 1, -1);
/*      */ 
/*      */     
/*  414 */     int grow = 5 + world.rand.nextInt(6);
/*  415 */     for (j = 19; j < 19 + grow; j++) {
/*  416 */       for (int i = 0; i < 2; i++) {
/*  417 */         for (int k = 0; k < 2; k++) {
/*  418 */           OreSpawnMain.setBlockFast(world, x + i, y + j, z + k, Blocks.log, 0, 2);
/*  419 */           make_leaves(world, x + i, y + j, z + k);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void SmallTree(World world, int x, int y, int z) {
/*  427 */     int realy = y;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  433 */     Block bid = world.getBlock(x, y - 1, z);
/*  434 */     if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
/*  435 */       bid = world.getBlock(x, y - 2, z);
/*  436 */       if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
/*  437 */         bid = world.getBlock(x, y - 3, z);
/*  438 */         if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
/*      */           
/*  440 */           OreSpawnMain.setBlockFast(world, x, y, z, Blocks.air, 0, 2);
/*      */           return;
/*      */         } 
/*  443 */         realy = y - 3;
/*      */       } else {
/*      */         
/*  446 */         realy = y - 2;
/*      */       } 
/*      */       return;
/*      */     } 
/*  450 */     realy = y - 1;
/*      */ 
/*      */ 
/*      */     
/*  454 */     bid = world.getBlock(x, realy + 1, z);
/*  455 */     if (bid == Blocks.air) {
/*  456 */       OreSpawnMain.setBlockFast(world, x, realy + 1, z, OreSpawnMain.MySkyTreeLog, 0, 2);
/*      */     }
/*  458 */     if (world.rand.nextInt(2) == 1) {
/*  459 */       bid = world.getBlock(x, realy + 2, z);
/*  460 */       if (bid == Blocks.air) {
/*  461 */         OreSpawnMain.setBlockFast(world, x, realy + 2, z, OreSpawnMain.MySkyTreeLog, 0, 2);
/*      */       }
/*  463 */       if (world.rand.nextInt(2) == 1) {
/*  464 */         bid = world.getBlock(x, realy + 3, z);
/*  465 */         if (bid == Blocks.air) {
/*  466 */           OreSpawnMain.setBlockFast(world, x, realy + 3, z, OreSpawnMain.MySkyTreeLog, 0, 2);
/*      */         }
/*      */       } else {
/*  469 */         realy--;
/*      */       } 
/*      */     } else {
/*  472 */       realy -= 2;
/*      */     } 
/*      */ 
/*      */     
/*  476 */     bid = world.getBlock(x, realy + 4, z);
/*  477 */     if (bid == Blocks.air) {
/*  478 */       OreSpawnMain.setBlockFast(world, x, realy + 4, z, OreSpawnMain.MyAppleLeaves, 0, 2);
/*      */     }
/*  480 */     for (int i = -1; i <= 1; i++) {
/*  481 */       for (int j = -1; j <= 1; j++) {
/*  482 */         bid = world.getBlock(x + i, realy + 3, z + j);
/*  483 */         if (bid == Blocks.air) {
/*  484 */           OreSpawnMain.setBlockFast(world, x + i, realy + 3, z + j, OreSpawnMain.MyAppleLeaves, 0, 2);
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
/*      */   public void makeScragglyBranch(World world, int x, int y, int z, int len, int biasx, int biasz) {
/*  500 */     for (int k = 0; k < len; k++) {
/*  501 */       int ix = world.rand.nextInt(2) - world.rand.nextInt(2) + biasx;
/*  502 */       int iz = world.rand.nextInt(2) - world.rand.nextInt(2) + biasz;
/*  503 */       if (ix > 1) ix = 1; 
/*  504 */       if (ix < -1) ix = -1; 
/*  505 */       if (iz > 1) iz = 1; 
/*  506 */       if (iz < -1) iz = -1; 
/*  507 */       int iy = (world.rand.nextInt(3) > 0) ? 1 : 0;
/*  508 */       x += ix;
/*  509 */       z += iz;
/*  510 */       y += iy;
/*  511 */       Block bid = world.getBlock(x, y, z);
/*  512 */       if (bid != Blocks.air && bid != Blocks.log && bid != OreSpawnMain.MyAppleLeaves) {
/*      */         return;
/*      */       }
/*  515 */       OreSpawnMain.setBlockFast(world, x, y, z, Blocks.log, 0, 2);
/*      */       
/*  517 */       for (int m = -1; m < 2; m++) {
/*  518 */         for (int n = -1; n < 2; n++) {
/*  519 */           if (world.rand.nextInt(2) == 1) {
/*  520 */             bid = world.getBlock(x + m, y, z + n);
/*  521 */             if (bid == Blocks.air) {
/*  522 */               OreSpawnMain.setBlockFast(world, x + m, y, z + n, OreSpawnMain.MyAppleLeaves, 0, 2);
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*  527 */       if (world.rand.nextInt(2) == 1) {
/*  528 */         bid = world.getBlock(x, y + 1, z);
/*  529 */         if (bid == Blocks.air) {
/*  530 */           OreSpawnMain.setBlockFast(world, x, y + 1, z, OreSpawnMain.MyAppleLeaves, 0, 2);
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
/*      */   public void ScragglyTreeWithBranches(World world, int x, int y, int z) {
/*  546 */     int i = 1 + world.rand.nextInt(3);
/*  547 */     int j = i + world.rand.nextInt(12);
/*      */     int k;
/*  549 */     for (k = 0; k < i; k++) {
/*  550 */       Block bid = world.getBlock(x, y + k, z);
/*  551 */       if (k >= 1 && bid != Blocks.air && bid != Blocks.log && bid != OreSpawnMain.MyAppleLeaves) {
/*      */         return;
/*      */       }
/*  554 */       OreSpawnMain.setBlockFast(world, x, y + k, z, Blocks.log, 0, 2);
/*      */     } 
/*  556 */     y += i - 1;
/*      */     
/*  558 */     for (k = i; k < j; k++) {
/*  559 */       int ix = world.rand.nextInt(2) - world.rand.nextInt(2);
/*  560 */       int iz = world.rand.nextInt(2) - world.rand.nextInt(2);
/*  561 */       int iy = (world.rand.nextInt(4) > 0) ? 1 : 0;
/*  562 */       x += ix;
/*  563 */       z += iz;
/*  564 */       y += iy;
/*  565 */       Block bid = world.getBlock(x, y, z);
/*  566 */       if (bid != Blocks.air && bid != Blocks.log && bid != OreSpawnMain.MyAppleLeaves) {
/*      */         break;
/*      */       }
/*  569 */       OreSpawnMain.setBlockFast(world, x, y, z, Blocks.log, 0, 2);
/*  570 */       if (world.rand.nextInt(4) == 1) {
/*  571 */         makeScragglyBranch(world, x, y, z, world.rand.nextInt(1 + j - k), world.rand.nextInt(2) - world.rand.nextInt(2), world.rand.nextInt(2) - world.rand.nextInt(2));
/*      */       }
/*      */       
/*  574 */       for (int m = -1; m < 2; m++) {
/*  575 */         for (int n = -1; n < 2; n++) {
/*  576 */           if (world.rand.nextInt(2) == 1) {
/*  577 */             bid = world.getBlock(x + m, y, z + n);
/*  578 */             if (bid == Blocks.air) {
/*  579 */               OreSpawnMain.setBlockFast(world, x + m, y, z + n, OreSpawnMain.MyAppleLeaves, 0, 2);
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*  584 */       if (world.rand.nextInt(2) == 1) {
/*  585 */         bid = world.getBlock(x, y + 1, z);
/*  586 */         if (bid == Blocks.air) {
/*  587 */           OreSpawnMain.setBlockFast(world, x, y + 1, z, OreSpawnMain.MyAppleLeaves, 0, 2);
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
/*  598 */   public static final WeightedRandomChestContent[] CrystalChestContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalTermiteBlock), 0, 1, 5, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalFlowerRedBlock), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalFlowerBlueBlock), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalFlowerGreenBlock), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalFlowerYellowBlock), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalPlanksBlock), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalWorkbenchBlock), 0, 1, 1, 10), new WeightedRandomChestContent(Item.getItemFromBlock((Block)OreSpawnMain.CrystalFurnaceBlock), 0, 1, 1, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyTigersEyeBlock), 0, 1, 10, 5), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalStone), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalRat), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalFairy), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalCoal), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalGrass), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalCrystal), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalTorch), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyCrystalLeaves), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyCrystalLeaves2), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyCrystalLeaves3), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyCrystalTreeLog), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.TigersEye), 0, 1, 10, 5), new WeightedRandomChestContent(OreSpawnMain.MyCrystalWoodSword, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalWoodAxe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalWoodShovel, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalWoodPickaxe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalWoodHoe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalPinkSword, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalPinkAxe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalPinkShovel, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalPinkPickaxe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalPinkHoe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyTigersEyeSword, 0, 1, 1, 5), new WeightedRandomChestContent(OreSpawnMain.MyTigersEyeAxe, 0, 1, 1, 5), new WeightedRandomChestContent(OreSpawnMain.MyTigersEyeShovel, 0, 1, 1, 5), new WeightedRandomChestContent(OreSpawnMain.MyTigersEyePickaxe, 0, 1, 1, 5), new WeightedRandomChestContent(OreSpawnMain.MyTigersEyeHoe, 0, 1, 1, 5), new WeightedRandomChestContent(OreSpawnMain.MyCrystalStoneSword, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalStoneAxe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalStoneShovel, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalStonePickaxe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalStoneHoe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyTigersEyeIngot, 0, 1, 5, 5), new WeightedRandomChestContent(OreSpawnMain.MyCrystalPinkIngot, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalApple, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.MyPeacockFeather, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.MyPeacock, 0, 1, 10, 20), new WeightedRandomChestContent(OreSpawnMain.MyRawPeacock, 0, 1, 10, 20), new WeightedRandomChestContent(OreSpawnMain.MyRice, 0, 1, 10, 20), new WeightedRandomChestContent(OreSpawnMain.MyQuinoa, 0, 1, 10, 20), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkHelmet, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkBody, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkLegs, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkBoots, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeHelmet, 0, 1, 1, 5), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeBody, 0, 1, 1, 5), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeLegs, 0, 1, 1, 5), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeBoots, 0, 1, 1, 5), new WeightedRandomChestContent((Item)OreSpawnMain.PeacockFeatherHelmet, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.PeacockFeatherBody, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.PeacockFeatherLegs, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.PeacockFeatherBoots, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.RotatorEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.VortexEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.PeacockEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.DungeonBeastEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.FairyEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.RatEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.FlounderEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.WhaleEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.IrukandjiEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.SkateEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.UrchinEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.GhostEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.GhostSkellyEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.MySkateBow, 0, 1, 1, 2), new WeightedRandomChestContent(OreSpawnMain.MyIrukandjiArrow, 0, 5, 10, 2), new WeightedRandomChestContent(OreSpawnMain.MyIrukandji, 0, 2, 8, 5), new WeightedRandomChestContent(OreSpawnMain.MyUltimateBow, 0, 1, 1, 2), new WeightedRandomChestContent(OreSpawnMain.MyUltimateSword, 0, 1, 1, 2), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 4, 10), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.log), 0, 1, 4, 10), new WeightedRandomChestContent(Items.golden_apple, 0, 1, 5, 2) };
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
/*      */   public void FairyTree(World world, int x, int y, int z) {
/*      */     int j;
/*  702 */     for (j = 1; j < 6; j++) {
/*  703 */       for (int i = 0; i < 2; i++) {
/*  704 */         for (int k = 0; k < 2; k++) {
/*  705 */           OreSpawnMain.setBlockFast(world, x + i, y + j, z + k, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  710 */     grow_crystal_branch(world, x, y + 5, z, 0, 1, 1, 1, -1);
/*  711 */     grow_crystal_branch(world, x + 1, y + 5, z, 1, 0, 1, -1, -1);
/*  712 */     grow_crystal_branch(world, x, y + 5, z + 1, -1, 0, -1, 1, -1);
/*  713 */     grow_crystal_branch(world, x + 1, y + 5, z + 1, 0, -1, -1, -1, -1);
/*      */     
/*  715 */     grow_crystal_branch(world, x, y + 6, z, 0, 1, -1, 1, -1);
/*  716 */     grow_crystal_branch(world, x + 1, y + 6, z, 1, 0, 1, 1, -1);
/*  717 */     grow_crystal_branch(world, x, y + 6, z + 1, -1, 0, -1, -1, -1);
/*  718 */     grow_crystal_branch(world, x + 1, y + 6, z + 1, 0, -1, 1, -1, -1);
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
/*  732 */     int grow = 5 + world.rand.nextInt(5);
/*  733 */     for (j = 6; j < 6 + grow; j++) {
/*  734 */       for (int i = 0; i < 2; i++) {
/*  735 */         for (int k = 0; k < 2; k++) {
/*  736 */           OreSpawnMain.setBlockFast(world, x + i, y + j, z + k, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/*  737 */           make_crystal_leaves(world, x + i, y + j, z + k);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  743 */     world.setBlock(x - 1, y + 1, z, Blocks.mob_spawner, 0, 2);
/*  744 */     TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(x - 1, y + 1, z);
/*  745 */     if (tileentitymobspawner != null)
/*      */     {
/*  747 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Fairy");
/*      */     }
/*  749 */     world.setBlock(x + 2, y + 1, z, (Block)Blocks.chest, 0, 2);
/*  750 */     TileEntityChest chest = (TileEntityChest)world.getTileEntity(x + 2, y + 1, z);
/*  751 */     if (chest != null) {
/*      */ 
/*      */       
/*  754 */       this; WeightedRandomChestContent.generateChestContents(world.rand, CrystalChestContentsList, (IInventory)chest, 1 + world.rand.nextInt(5));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void make_crystal_leaves(World world, int x, int y, int z) {
/*  765 */     for (int l1 = -2; l1 <= 2; l1++) {
/*  766 */       for (int l2 = -2; l2 <= 2; l2++) {
/*  767 */         for (int l3 = 0; l3 <= 1; l3++) {
/*  768 */           Block bid = world.getBlock(x + l1, y + l3, z + l2);
/*  769 */           if (bid == Blocks.air) OreSpawnMain.setBlockFast(world, x + l1, y + l3, z + l2, OreSpawnMain.MyCrystalLeaves3, 0, 2);
/*      */         
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void make_crystal_castle_leaves(World world, int x, int y, int z) {
/*  779 */     for (int l1 = -1; l1 <= 1; l1++) {
/*  780 */       for (int l2 = -1; l2 <= 1; l2++) {
/*  781 */         for (int l3 = 0; l3 <= 1; l3++) {
/*  782 */           Block bid = world.getBlock(x + l1, y + l3, z + l2);
/*  783 */           if (bid == Blocks.air) {
/*  784 */             if (l3 != 0) {
/*  785 */               OreSpawnMain.setBlockFast(world, x + l1, y + l3, z + l2, OreSpawnMain.MyCrystalLeaves3, 0, 2);
/*      */             } else {
/*  787 */               OreSpawnMain.setBlockFast(world, x + l1, y + l3, z + l2, OreSpawnMain.MyCrystalLeaves2, 0, 2);
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
/*      */   private void grow_crystal_branch(World world, int x, int y, int z, int xdir, int zdir, int xxdir, int zzdir, int ydir) {
/*  799 */     int i2 = 0, k2 = 0, j2 = 0;
/*      */ 
/*      */     
/*  802 */     int i = x;
/*  803 */     int j = y;
/*  804 */     int k = z;
/*      */     
/*  806 */     int grow = 4 + world.rand.nextInt(4);
/*  807 */     if (OreSpawnMain.LessLag == 1) {
/*  808 */       grow--;
/*      */     }
/*  810 */     if (OreSpawnMain.LessLag == 2)
/*  811 */       grow -= 2; 
/*      */     int n;
/*  813 */     for (n = 0; n < grow; n++) {
/*  814 */       OreSpawnMain.setBlockFast(world, i, j, k, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/*  815 */       make_crystal_leaves(world, i, j, k);
/*  816 */       j++;
/*  817 */       i += xdir;
/*  818 */       k += zdir;
/*  819 */       i2 = i;
/*  820 */       k2 = k;
/*      */     } 
/*  822 */     grow = 5 + world.rand.nextInt(5);
/*  823 */     if (OreSpawnMain.LessLag == 1) {
/*  824 */       grow--;
/*      */     }
/*  826 */     if (OreSpawnMain.LessLag == 2) {
/*  827 */       grow -= 2;
/*      */     }
/*  829 */     for (n = 0; n < grow; n++) {
/*  830 */       OreSpawnMain.setBlockFast(world, i, j, k, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/*  831 */       make_crystal_leaves(world, i, j, k);
/*  832 */       i += xdir;
/*  833 */       k += zdir;
/*      */     } 
/*  835 */     grow = 5 + world.rand.nextInt(5);
/*  836 */     if (OreSpawnMain.LessLag == 1) {
/*  837 */       grow--;
/*      */     }
/*  839 */     if (OreSpawnMain.LessLag == 2) {
/*  840 */       grow -= 2;
/*      */     }
/*  842 */     for (n = 0; n < grow; n++) {
/*  843 */       OreSpawnMain.setBlockFast(world, i2, j, k2, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/*  844 */       make_crystal_leaves(world, i2, j, k2);
/*  845 */       i2 += xxdir;
/*  846 */       k2 += zzdir;
/*      */     } 
/*      */     
/*  849 */     j2 = --j;
/*  850 */     grow = 4 + world.rand.nextInt(4);
/*  851 */     if (OreSpawnMain.LessLag == 1) {
/*  852 */       grow--;
/*      */     }
/*  854 */     if (OreSpawnMain.LessLag == 2) {
/*  855 */       grow -= 2;
/*      */     }
/*  857 */     for (n = 0; n < grow; n++) {
/*  858 */       OreSpawnMain.setBlockFast(world, i, j, k, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/*  859 */       make_crystal_leaves(world, i, j, k);
/*  860 */       i += xdir;
/*  861 */       k += zdir;
/*  862 */       j += ydir;
/*      */     } 
/*  864 */     grow = 4 + world.rand.nextInt(4);
/*  865 */     if (OreSpawnMain.LessLag == 1) {
/*  866 */       grow--;
/*      */     }
/*  868 */     if (OreSpawnMain.LessLag == 2) {
/*  869 */       grow -= 2;
/*      */     }
/*  871 */     for (n = 0; n < grow; n++) {
/*  872 */       OreSpawnMain.setBlockFast(world, i2, j2, k2, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/*  873 */       make_crystal_leaves(world, i2, j2, k2);
/*  874 */       i2 += xxdir;
/*  875 */       k2 += zzdir;
/*  876 */       j2 += ydir;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addSomething(World world, int x, int y, int z) {
/*  883 */     int i = world.rand.nextInt(3);
/*      */     
/*  885 */     if (i == 1) {
/*      */       
/*  887 */       world.setBlock(x, y + 1, z, Blocks.mob_spawner, 0, 2);
/*  888 */       TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(x, y + 1, z);
/*  889 */       if (tileentitymobspawner != null)
/*      */       {
/*  891 */         tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Fairy");
/*      */       }
/*      */     } 
/*  894 */     if (i == 2) {
/*  895 */       world.setBlock(x, y + 1, z, (Block)Blocks.chest, 0, 2);
/*  896 */       TileEntityChest chest = (TileEntityChest)world.getTileEntity(x, y + 1, z);
/*  897 */       if (chest != null) {
/*      */ 
/*      */         
/*  900 */         this; WeightedRandomChestContent.generateChestContents(world.rand, CrystalChestContentsList, (IInventory)chest, 1 + world.rand.nextInt(5));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void FairyCastleTree(World world, int x, int y, int z) {
/*  909 */     int nc = 6;
/*      */ 
/*      */     
/*  912 */     if (OreSpawnMain.LessLag == 1) {
/*  913 */       nc--;
/*      */     }
/*  915 */     if (OreSpawnMain.LessLag == 2) {
/*  916 */       nc -= 2;
/*      */     }
/*  918 */     int j = 3 + world.rand.nextInt(3);
/*  919 */     int spread = 0;
/*      */     
/*  921 */     for (int iter = 0; iter < nc; iter++) {
/*  922 */       int grow = 4 + world.rand.nextInt(3);
/*  923 */       int width = 1 + world.rand.nextInt(3);
/*  924 */       int randy = world.rand.nextInt(3) - 1; int i;
/*  925 */       for (i = -width; i <= width; i++) {
/*  926 */         for (int k = -width; k <= width; k++) {
/*  927 */           OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy, z + k, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/*  928 */           if (i == -width || i == width || k == -width || k == width) make_crystal_castle_leaves(world, x + i + spread, y + j + randy, z + k); 
/*  929 */           if (iter != 0 && i == 0 && k == 0) addSomething(world, x + i + spread, y + j + randy, z + k); 
/*  930 */           if (i == -width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy + 1, z + k, OreSpawnMain.CrystalTorch, 0, 2); 
/*  931 */           if (i == width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy + 1, z + k, OreSpawnMain.CrystalTorch, 0, 2); 
/*      */         } 
/*      */       } 
/*  934 */       if (iter != 0) {
/*  935 */         width = 1 + world.rand.nextInt(3 + iter);
/*  936 */         randy = world.rand.nextInt(3) - 1;
/*  937 */         for (i = -width; i <= width; i++) {
/*  938 */           for (int k = -width; k <= width; k++) {
/*  939 */             OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy, z + k, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/*  940 */             if (i == -width || i == width || k == -width || k == width) make_crystal_castle_leaves(world, x + i - spread, y + j + randy, z + k); 
/*  941 */             if (i == 0 && k == 0) addSomething(world, x + i - spread, y + j + randy, z + k); 
/*  942 */             if (i == -width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy + 1, z + k, OreSpawnMain.CrystalTorch, 0, 2); 
/*  943 */             if (i == width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy + 1, z + k, OreSpawnMain.CrystalTorch, 0, 2); 
/*      */           } 
/*      */         } 
/*  946 */         width = 1 + world.rand.nextInt(3 + iter);
/*  947 */         randy = world.rand.nextInt(3) - 1;
/*  948 */         for (i = -width; i <= width; i++) {
/*  949 */           for (int k = -width; k <= width; k++) {
/*  950 */             OreSpawnMain.setBlockFast(world, x + i, y + j + randy, z + k + spread, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/*  951 */             if (i == -width || i == width || k == -width || k == width) make_crystal_castle_leaves(world, x + i, y + j + randy, z + k + spread); 
/*  952 */             if (i == 0 && k == 0) addSomething(world, x + i, y + j + randy, z + k + spread); 
/*  953 */             if (i == -width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i, y + j + randy + 1, z + k + spread, OreSpawnMain.CrystalTorch, 0, 2); 
/*  954 */             if (i == width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i, y + j + randy + 1, z + k + spread, OreSpawnMain.CrystalTorch, 0, 2); 
/*      */           } 
/*      */         } 
/*  957 */         width = 1 + world.rand.nextInt(3 + iter);
/*  958 */         randy = world.rand.nextInt(3) - 1;
/*  959 */         for (i = -width; i <= width; i++) {
/*  960 */           for (int k = -width; k <= width; k++) {
/*  961 */             OreSpawnMain.setBlockFast(world, x + i, y + j + randy, z + k - spread, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/*  962 */             if (i == -width || i == width || k == -width || k == width) make_crystal_castle_leaves(world, x + i, y + j + randy, z + k - spread); 
/*  963 */             if (i == 0 && k == 0) addSomething(world, x + i, y + j + randy, z + k - spread); 
/*  964 */             if (i == -width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i, y + j + randy + 1, z + k - spread, OreSpawnMain.CrystalTorch, 0, 2); 
/*  965 */             if (i == width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i, y + j + randy + 1, z + k - spread, OreSpawnMain.CrystalTorch, 0, 2); 
/*      */           } 
/*      */         } 
/*      */       } 
/*  969 */       if (iter >= 2) {
/*  970 */         width = 1 + world.rand.nextInt(3 + iter);
/*  971 */         randy = world.rand.nextInt(3) - 1;
/*  972 */         for (i = -width; i <= width; i++) {
/*  973 */           for (int k = -width; k <= width; k++) {
/*  974 */             OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy, z + k + spread, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/*  975 */             if (i == -width || i == width || k == -width || k == width) make_crystal_castle_leaves(world, x + i + spread, y + j + randy, z + k + spread); 
/*  976 */             if (i == 0 && k == 0) addSomething(world, x + i + spread, y + j + randy, z + k + spread); 
/*  977 */             if (i == -width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy + 1, z + k + spread, OreSpawnMain.CrystalTorch, 0, 2); 
/*  978 */             if (i == width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy + 1, z + k + spread, OreSpawnMain.CrystalTorch, 0, 2); 
/*      */           } 
/*      */         } 
/*  981 */         width = 1 + world.rand.nextInt(3 + iter);
/*  982 */         randy = world.rand.nextInt(3) - 1;
/*  983 */         for (i = -width; i <= width; i++) {
/*  984 */           for (int k = -width; k <= width; k++) {
/*  985 */             OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy, z + k - spread, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/*  986 */             if (i == -width || i == width || k == -width || k == width) make_crystal_castle_leaves(world, x + i - spread, y + j + randy, z + k - spread); 
/*  987 */             if (i == 0 && k == 0) addSomething(world, x + i - spread, y + j + randy, z + k - spread); 
/*  988 */             if (i == -width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy + 1, z + k - spread, OreSpawnMain.CrystalTorch, 0, 2); 
/*  989 */             if (i == width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy + 1, z + k - spread, OreSpawnMain.CrystalTorch, 0, 2); 
/*      */           } 
/*      */         } 
/*  992 */         width = 1 + world.rand.nextInt(3 + iter);
/*  993 */         randy = world.rand.nextInt(3) - 1;
/*  994 */         for (i = -width; i <= width; i++) {
/*  995 */           for (int k = -width; k <= width; k++) {
/*  996 */             OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy, z + k + spread, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/*  997 */             if (i == -width || i == width || k == -width || k == width) make_crystal_castle_leaves(world, x + i - spread, y + j + randy, z + k + spread); 
/*  998 */             if (i == 0 && k == 0) addSomething(world, x + i - spread, y + j + randy, z + k + spread); 
/*  999 */             if (i == -width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy + 1, z + k + spread, OreSpawnMain.CrystalTorch, 0, 2); 
/* 1000 */             if (i == width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy + 1, z + k + spread, OreSpawnMain.CrystalTorch, 0, 2); 
/*      */           } 
/*      */         } 
/* 1003 */         width = 1 + world.rand.nextInt(3 + iter);
/* 1004 */         randy = world.rand.nextInt(3) - 1;
/* 1005 */         for (i = -width; i <= width; i++) {
/* 1006 */           for (int k = -width; k <= width; k++) {
/* 1007 */             OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy, z + k - spread, OreSpawnMain.MyCrystalTreeLog, 0, 2);
/* 1008 */             if (i == -width || i == width || k == -width || k == width) make_crystal_castle_leaves(world, x + i + spread, y + j + randy, z + k - spread); 
/* 1009 */             if (i == 0 && k == 0) addSomething(world, x + i + spread, y + j + randy, z + k - spread); 
/* 1010 */             if (i == -width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy + 1, z + k - spread, OreSpawnMain.CrystalTorch, 0, 2); 
/* 1011 */             if (i == width && (k == -width || k == width)) OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy + 1, z + k - spread, OreSpawnMain.CrystalTorch, 0, 2); 
/*      */           } 
/*      */         } 
/*      */       } 
/* 1015 */       j += grow;
/* 1016 */       if (iter == 0) spread = 3; 
/* 1017 */       spread += grow;
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Trees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */