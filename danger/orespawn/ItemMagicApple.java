/*      */ package danger.orespawn;
/*      */ 
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.Random;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.BlockLeaves;
/*      */ import net.minecraft.client.renderer.texture.IIconRegister;
/*      */ import net.minecraft.creativetab.CreativeTabs;
/*      */ import net.minecraft.enchantment.Enchantment;
/*      */ import net.minecraft.enchantment.EnchantmentHelper;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityList;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.inventory.IInventory;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.tileentity.TileEntityChest;
/*      */ import net.minecraft.util.WeightedRandomChestContent;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.chunk.Chunk;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ItemMagicApple
/*      */   extends Item
/*      */ {
/*   31 */   public int tree_radius = 6;
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean no_critters = false;
/*      */ 
/*      */   
/*   38 */   Random rand = OreSpawnMain.OreSpawnRand;
/*      */   
/*   40 */   private final WeightedRandomChestContent[] chestContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.ender_pearl, 0, 1, 2, 3), new WeightedRandomChestContent(Items.diamond, 0, 1, 5, 15), new WeightedRandomChestContent(Items.blaze_rod, 0, 1, 3, 10), new WeightedRandomChestContent(OreSpawnMain.CageEmpty, 0, 1, 10, 7), new WeightedRandomChestContent(OreSpawnMain.CagedGirlfriend, 0, 1, 2, 6), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 10, 16), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 6, 16), new WeightedRandomChestContent(OreSpawnMain.UraniumNugget, 0, 1, 6, 6), new WeightedRandomChestContent(OreSpawnMain.TitaniumNugget, 0, 1, 4, 6), new WeightedRandomChestContent(Items.bread, 0, 1, 8, 20), new WeightedRandomChestContent(Items.apple, 0, 1, 8, 20), new WeightedRandomChestContent(Items.cookie, 0, 1, 16, 20), new WeightedRandomChestContent(Items.cooked_beef, 0, 1, 8, 20), new WeightedRandomChestContent(Items.cooked_chicken, 0, 1, 8, 20), new WeightedRandomChestContent(Items.cooked_fished, 0, 1, 8, 20), new WeightedRandomChestContent(Items.cooked_porkchop, 0, 1, 8, 20), new WeightedRandomChestContent(Items.pumpkin_pie, 0, 1, 4, 20), new WeightedRandomChestContent(Items.carrot, 0, 1, 16, 20), new WeightedRandomChestContent(Items.potato, 0, 1, 16, 20), new WeightedRandomChestContent(OreSpawnMain.MySunFish, 0, 1, 4, 6), new WeightedRandomChestContent(OreSpawnMain.MyFireFish, 0, 1, 8, 6), new WeightedRandomChestContent(OreSpawnMain.MyPopcornBag, 0, 1, 4, 16), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 20), new WeightedRandomChestContent(Items.iron_sword, 0, 1, 1, 20), new WeightedRandomChestContent(Items.diamond_pickaxe, 0, 1, 1, 5), new WeightedRandomChestContent(Items.diamond_sword, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.bow, 0, 1, 1, 20), new WeightedRandomChestContent(Items.arrow, 0, 1, 64, 20), new WeightedRandomChestContent(OreSpawnMain.MyUltimatePickaxe, 0, 1, 1, 2), new WeightedRandomChestContent(OreSpawnMain.MyUltimateSword, 0, 1, 1, 1), new WeightedRandomChestContent(OreSpawnMain.MyUltimateFishingRod, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.iron_chestplate, 0, 1, 1, 20), new WeightedRandomChestContent((Item)Items.iron_helmet, 0, 1, 1, 20), new WeightedRandomChestContent((Item)Items.iron_leggings, 0, 1, 1, 20), new WeightedRandomChestContent((Item)Items.iron_boots, 0, 1, 1, 20), new WeightedRandomChestContent((Item)Items.diamond_chestplate, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.diamond_helmet, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.diamond_leggings, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.diamond_boots, 0, 1, 1, 5), new WeightedRandomChestContent(Items.golden_apple, 0, 1, 1, 5) };
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
/*      */   public ItemMagicApple(int i) {
/*   91 */     this.maxStackSize = 1;
/*   92 */     setCreativeTab(CreativeTabs.tabDecorations);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*   98 */     par1ItemStack.addEnchantment(Enchantment.fortune, 2);
/*      */   }
/*      */ 
/*      */   
/*      */   private Entity spawnCreature(World par0World, int par1, double par2, double par4, double par6) {
/*  103 */     Entity var8 = null;
/*      */ 
/*      */     
/*  106 */     var8 = EntityList.createEntityByID(par1, par0World);
/*      */     
/*  108 */     if (var8 != null) {
/*      */ 
/*      */       
/*  111 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*      */ 
/*      */       
/*  114 */       par0World.spawnEntityInWorld(var8);
/*      */       
/*  116 */       ((EntityLiving)var8).playLivingSound();
/*      */     } 
/*      */     
/*  119 */     return var8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
/*  130 */     int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, stack);
/*  131 */     if (lvl <= 0) {
/*  132 */       stack.addEnchantment(Enchantment.fortune, 2);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
/*  137 */     onUsingTick(stack, (EntityPlayer)null, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Boolean isBoringBlock(World world, int x, int y, int z) {
/*  145 */     Block var1 = world.getBlock(x, y, z);
/*      */     
/*  147 */     if (var1 == Blocks.tallgrass)
/*  148 */       return Boolean.valueOf(true); 
/*  149 */     if (var1 == Blocks.cactus)
/*  150 */       return Boolean.valueOf(true); 
/*  151 */     if (var1 == Blocks.red_flower)
/*  152 */       return Boolean.valueOf(true); 
/*  153 */     if (var1 == Blocks.yellow_flower)
/*  154 */       return Boolean.valueOf(true); 
/*  155 */     if (var1 == Blocks.leaves)
/*  156 */       return Boolean.valueOf(true); 
/*  157 */     if (var1 == Blocks.snow)
/*  158 */       return Boolean.valueOf(true); 
/*  159 */     if (var1 == OreSpawnMain.MyStrawberryPlant)
/*  160 */       return Boolean.valueOf(true); 
/*  161 */     if (var1 == OreSpawnMain.MyAppleLeaves) {
/*  162 */       return Boolean.valueOf(true);
/*      */     }
/*  164 */     if (world.isAirBlock(x, y, z) == true) {
/*  165 */       return Boolean.valueOf(true);
/*      */     }
/*  167 */     if (var1 == null) {
/*  168 */       return Boolean.valueOf(true);
/*      */     }
/*  170 */     return Boolean.valueOf(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Boolean isBoringBaseBlock(World world, int x, int y, int z) {
/*  177 */     if (world.isAirBlock(x, y, z) == true)
/*  178 */       return Boolean.valueOf(true); 
/*  179 */     Block var1 = world.getBlock(x, y, z);
/*  180 */     if (var1 == Blocks.stone)
/*  181 */       return Boolean.valueOf(false); 
/*  182 */     if (var1 == Blocks.bedrock) {
/*  183 */       return Boolean.valueOf(false);
/*      */     }
/*  185 */     return Boolean.valueOf(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void growVines(World world, int par2, int par3, int par4, int par5, int par6, Chunk chunk) {
/*  193 */     if (world.getBlock(par2, par3, par4) != Blocks.air) {
/*      */       return;
/*      */     }
/*      */     
/*  197 */     FastSetBlock(world, par2, par3, par4, Blocks.vine, par5, 2, chunk);
/*  198 */     while (par6 > 0) {
/*      */       
/*  200 */       par3--;
/*  201 */       if (world.getBlock(par2, par3, par4) != Blocks.air) {
/*      */         return;
/*      */       }
/*      */       
/*  205 */       FastSetBlock(world, par2, par3, par4, Blocks.vine, par5, 2, chunk);
/*  206 */       par6--;
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
/*      */   private void make_branch(World world, int x, int y, int z, int this_width, int dirx, int dirz, Block ID, Block leafID, int tree_type, int t_radius, boolean bad_critters, Chunk chunk) {
/*  218 */     int current_width = this_width;
/*      */ 
/*      */     
/*  221 */     int last_branch = 0;
/*  222 */     int branch_side = 1;
/*      */ 
/*      */     
/*  225 */     int leaf_depth = 0;
/*  226 */     int leaf_width = 0;
/*      */ 
/*      */     
/*  229 */     int xaccum = dirx;
/*  230 */     int zaccum = dirz;
/*      */     
/*  232 */     if (this.rand.nextInt(2) == 0) branch_side = -1;
/*      */ 
/*      */     
/*  235 */     while (current_width >= 0) {
/*      */       
/*  237 */       int length = this_width * 3 + this.rand.nextInt(this_width + 3);
/*      */       
/*  239 */       for (int i = 0; i < length; i++) {
/*      */         int j;
/*      */         
/*  242 */         for (j = -current_width; j <= current_width; j++) {
/*  243 */           int realx = x + j * dirz + xaccum;
/*  244 */           int realz = z + j * dirx + zaccum;
/*  245 */           if (isBoringBlock(world, realx, y, realz).booleanValue())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  252 */             if (tree_type >= 0) {
/*  253 */               FastSetBlock(world, realx, y, realz, ID, tree_type, 2, chunk);
/*      */             } else {
/*  255 */               FastSetBlock(world, realx, y, realz, ID, 0, 2, chunk);
/*      */             } 
/*      */           }
/*  258 */           if (i > 0 && j == 0 && current_width >= 3)
/*      */           {
/*  260 */             if ((tree_type >= 0 && this.rand.nextInt(75) == 0) || (tree_type < 0 && this.rand.nextInt(50) == 0)) {
/*      */               
/*  262 */               if (!bad_critters && world.isAirBlock(realx, y + 1, realz))
/*      */               {
/*  264 */                 FastSetBlock(world, realx, y + 1, realz, (Block)Blocks.chest, 0, 2, chunk);
/*  265 */                 TileEntityChest chest = (TileEntityChest)world.getTileEntity(realx, y + 1, realz);
/*  266 */                 if (chest != null)
/*      */                 {
/*      */                   
/*  269 */                   WeightedRandomChestContent.generateChestContents(this.rand, this.chestContentsList, (IInventory)chest, 1 + this.rand.nextInt(8));
/*      */                 }
/*      */               }
/*      */             
/*  273 */             } else if (this.rand.nextInt(50) == 0) {
/*      */ 
/*      */               
/*  276 */               if (!bad_critters && world.isAirBlock(realx, y + 1, realz) && world.isAirBlock(realx, y + 2, realz) && world.isAirBlock(realx, y + 3, realz)) {
/*      */ 
/*      */                 
/*  279 */                 Entity ent = null;
/*  280 */                 ent = spawnCreature(world, 99, realx + 0.5D, y + 1.01D, realz + 0.5D);
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } 
/*      */ 
/*      */         
/*  287 */         if (current_width < 3 || this_width <= 1) {
/*  288 */           leaf_depth = 2 + this.rand.nextInt(2);
/*  289 */           leaf_width = 2 + this.rand.nextInt(3);
/*      */           
/*  291 */           for (int n = 0; n < leaf_depth; n++) {
/*  292 */             int lw = current_width + leaf_width - n;
/*  293 */             if (current_width == 0 && 
/*  294 */               length - i <= 2 && 
/*  295 */               lw >= length - i) lw = length - i - 1;
/*      */ 
/*      */             
/*  298 */             if (lw < 0) lw = 0; 
/*  299 */             for (j = -lw; j <= lw; j++) {
/*  300 */               int realx = x + j * Math.abs(dirz) + xaccum + dirx;
/*  301 */               int realz = z + j * Math.abs(dirx) + zaccum + dirz;
/*  302 */               if (isBoringBlock(world, realx, y + n, realz).booleanValue()) {
/*  303 */                 if (tree_type >= 0) {
/*      */                   
/*  305 */                   FastSetBlock(world, realx, y + n, realz, leafID, tree_type, 2, chunk);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  310 */                   if (n == 0 && tree_type == 3 && lw != 0 && (j == lw || j == -lw) && this.rand.nextInt(5) == 0)
/*      */                   {
/*  312 */                     if (dirx == 0) {
/*  313 */                       if (j == lw) {
/*  314 */                         growVines(world, realx + 1, y, realz, 2, this.rand.nextInt(10), chunk);
/*      */                       } else {
/*  316 */                         growVines(world, realx - 1, y, realz, 8, this.rand.nextInt(10), chunk);
/*      */                       } 
/*  318 */                     } else if (j == lw) {
/*  319 */                       growVines(world, realx, y, realz + 1, 4, this.rand.nextInt(10), chunk);
/*      */                     } else {
/*  321 */                       growVines(world, realx, y, realz - 1, 1, this.rand.nextInt(10), chunk);
/*      */                     }
/*      */                   
/*      */                   }
/*      */                 }
/*      */                 else {
/*      */                   
/*  328 */                   Block local_leaf_type = leafID;
/*  329 */                   if (this.rand.nextInt(20) == 1)
/*  330 */                     if (this.rand.nextInt(3) != 0) {
/*  331 */                       local_leaf_type = Blocks.redstone_block;
/*      */                     } else {
/*  333 */                       int ilt = this.rand.nextInt(4);
/*  334 */                       if (ilt == 0) local_leaf_type = OreSpawnMain.MyBlockUraniumBlock; 
/*  335 */                       if (ilt == 1) local_leaf_type = OreSpawnMain.MyBlockTitaniumBlock; 
/*  336 */                       if (ilt == 2) local_leaf_type = OreSpawnMain.MyBlockRubyBlock; 
/*  337 */                       if (ilt == 3) local_leaf_type = OreSpawnMain.MyBlockAmethystBlock;
/*      */                     
/*      */                     }  
/*  340 */                   FastSetBlock(world, realx, y + n, realz, local_leaf_type, 0, 2, chunk);
/*      */                 } 
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/*  348 */         if (current_width > 0 && last_branch > current_width && current_width != this_width && 
/*  349 */           this.rand.nextInt(current_width + 1) == 0) {
/*  350 */           int subdirx = branch_side;
/*  351 */           int subdirz = 0;
/*  352 */           if (dirx != 0) {
/*      */             
/*  354 */             subdirx = 0;
/*  355 */             subdirz = branch_side;
/*      */           } 
/*      */ 
/*      */           
/*  359 */           make_branch(world, x + xaccum + current_width * subdirx, y, z + zaccum + current_width * subdirz, current_width - 1, subdirx, subdirz, ID, leafID, tree_type, t_radius, bad_critters, chunk);
/*  360 */           last_branch = 0;
/*      */           
/*  362 */           if (branch_side < 0) {
/*  363 */             branch_side = 1;
/*      */           } else {
/*  365 */             branch_side = -1;
/*      */           } 
/*      */         } 
/*  368 */         xaccum += dirx;
/*  369 */         zaccum += dirz;
/*  370 */         last_branch++;
/*      */       } 
/*  372 */       current_width--;
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
/*      */   public void MakeBigSquareTree(World world, int x, int y, int z, Block ID, Block leafID, Block stepID, int tree_type, int t_radius, boolean bad_critters, Chunk chunk) {
/*  385 */     int this_height = t_radius + this.rand.nextInt(t_radius);
/*  386 */     int this_width = t_radius;
/*  387 */     int base_height = t_radius * 3;
/*  388 */     int spiral = 0;
/*  389 */     int current_y = 0;
/*  390 */     int branch = 0;
/*  391 */     int do_floor = 0;
/*  392 */     int platform_looper = 1;
/*  393 */     int last = -1, last_last = -1;
/*      */     
/*      */     int i;
/*      */     
/*  397 */     for (i = -t_radius; i <= t_radius; i++) {
/*      */       
/*  399 */       if (isBoringBaseBlock(world, x + i, y, z - t_radius).booleanValue())
/*  400 */         for (int j = 0; j < 20; j++) {
/*  401 */           if (y - j > 0)
/*  402 */             if (isBoringBaseBlock(world, x + i, y - j, z - t_radius).booleanValue()) {
/*  403 */               if (tree_type >= 0) {
/*  404 */                 FastSetBlock(world, x + i, y - j, z - t_radius, ID, tree_type, 2, chunk);
/*      */               } else {
/*  406 */                 FastSetBlock(world, x + i, y - j, z - t_radius, ID, 0, 2, chunk);
/*      */               } 
/*      */             } else {
/*      */               break;
/*      */             }  
/*      */         }  
/*  412 */       if (isBoringBaseBlock(world, x + i, y, z + t_radius).booleanValue())
/*  413 */         for (int j = 0; j < 20; j++) {
/*  414 */           if (y - j > 0)
/*  415 */             if (isBoringBaseBlock(world, x + i, y - j, z + t_radius).booleanValue()) {
/*  416 */               if (tree_type >= 0) {
/*  417 */                 FastSetBlock(world, x + i, y - j, z + t_radius, ID, tree_type, 2, chunk);
/*      */               } else {
/*  419 */                 FastSetBlock(world, x + i, y - j, z + t_radius, ID, 0, 2, chunk);
/*      */               } 
/*      */             } else {
/*      */               break;
/*      */             }  
/*      */         }  
/*  425 */       if (isBoringBaseBlock(world, x - t_radius, y, z + i).booleanValue())
/*  426 */         for (int j = 0; j < 20; j++) {
/*  427 */           if (y - j > 0)
/*  428 */             if (isBoringBaseBlock(world, x - t_radius, y - j, z + i).booleanValue()) {
/*  429 */               if (tree_type >= 0) {
/*  430 */                 FastSetBlock(world, x - t_radius, y - j, z + i, ID, tree_type, 2, chunk);
/*      */               } else {
/*  432 */                 FastSetBlock(world, x - t_radius, y - j, z + i, ID, 0, 2, chunk);
/*      */               } 
/*      */             } else {
/*      */               break;
/*      */             }  
/*      */         }  
/*  438 */       if (isBoringBaseBlock(world, x + t_radius, y, z + i).booleanValue()) {
/*  439 */         for (int j = 0; j < 20; j++) {
/*  440 */           if (y - j > 0) {
/*  441 */             if (isBoringBaseBlock(world, x + t_radius, y - j, z + i).booleanValue()) {
/*  442 */               if (tree_type >= 0) {
/*  443 */                 FastSetBlock(world, x + t_radius, y - j, z + i, ID, tree_type, 2, chunk);
/*      */               } else {
/*  445 */                 FastSetBlock(world, x + t_radius, y - j, z + i, ID, 0, 2, chunk);
/*      */               } 
/*      */             } else {
/*      */               break;
/*      */             } 
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  455 */     current_y = y;
/*  456 */     do_floor = 0;
/*  457 */     spiral = -this_width;
/*  458 */     while (this_width >= 0) {
/*  459 */       if (this_width != t_radius) base_height = 0;
/*      */       
/*  461 */       for (int j = 0; j < this_height + base_height; j++) {
/*      */         
/*  463 */         do_floor = 0;
/*      */ 
/*      */         
/*  466 */         for (i = -this_width; i <= this_width; i++) {
/*      */           
/*  468 */           if (isBoringBaseBlock(world, x + i, current_y, z - this_width).booleanValue())
/*  469 */             if (tree_type >= 0) {
/*  470 */               FastSetBlock(world, x + i, current_y, z - this_width, ID, tree_type, 2, chunk);
/*      */             } else {
/*  472 */               FastSetBlock(world, x + i, current_y, z - this_width, ID, 0, 2, chunk);
/*      */             }  
/*  474 */           if (isBoringBaseBlock(world, x + i, current_y, z + this_width).booleanValue())
/*  475 */             if (tree_type >= 0) {
/*  476 */               FastSetBlock(world, x + i, current_y, z + this_width, ID, tree_type, 2, chunk);
/*      */             } else {
/*  478 */               FastSetBlock(world, x + i, current_y, z + this_width, ID, 0, 2, chunk);
/*      */             }  
/*  480 */           if (isBoringBaseBlock(world, x - this_width, current_y, z + i).booleanValue())
/*  481 */             if (tree_type >= 0) {
/*  482 */               FastSetBlock(world, x - this_width, current_y, z + i, ID, tree_type, 2, chunk);
/*      */             } else {
/*  484 */               FastSetBlock(world, x - this_width, current_y, z + i, ID, 0, 2, chunk);
/*      */             }  
/*  486 */           if (isBoringBaseBlock(world, x + this_width, current_y, z + i).booleanValue()) {
/*  487 */             if (tree_type >= 0) {
/*  488 */               FastSetBlock(world, x + this_width, current_y, z + i, ID, tree_type, 2, chunk);
/*      */             } else {
/*  490 */               FastSetBlock(world, x + this_width, current_y, z + i, ID, 0, 2, chunk);
/*      */             } 
/*      */           }
/*      */         } 
/*  494 */         if (this_width != 0 || j < this_height / 2) {
/*      */           
/*  496 */           platform_looper = 1;
/*      */ 
/*      */           
/*  499 */           if ((spiral == 0 && this_width >= 2) || spiral == this_width || (spiral == this_width - 1 && j == this_height + base_height - 1)) {
/*      */             
/*  501 */             platform_looper++;
/*  502 */             if (spiral != 0 && this_width >= 3) platform_looper++; 
/*  503 */             if (spiral == 0) do_floor = 1;
/*      */           
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  510 */           for (int k = 0; k < platform_looper; k++) {
/*      */             
/*  512 */             if (isBoringBlock(world, x - spiral, current_y, z - this_width - 1).booleanValue()) {
/*  513 */               FastSetBlock(world, x - spiral, current_y, z - this_width - 1, stepID, 0, 2, chunk);
/*      */             }
/*  515 */             if (isBoringBlock(world, x + spiral, current_y, z + this_width + 1).booleanValue()) {
/*  516 */               FastSetBlock(world, x + spiral, current_y, z + this_width + 1, stepID, 0, 2, chunk);
/*      */             }
/*  518 */             if (isBoringBlock(world, x - this_width - 1, current_y, z + spiral).booleanValue()) {
/*  519 */               FastSetBlock(world, x - this_width - 1, current_y, z + spiral, stepID, 0, 2, chunk);
/*      */             }
/*  521 */             if (isBoringBlock(world, x + this_width + 1, current_y, z - spiral).booleanValue()) {
/*  522 */               FastSetBlock(world, x + this_width + 1, current_y, z - spiral, stepID, 0, 2, chunk);
/*      */             }
/*  524 */             if (this_width >= 3) {
/*  525 */               if (isBoringBlock(world, x - spiral, current_y, z - this_width - 2).booleanValue()) {
/*  526 */                 FastSetBlock(world, x - spiral, current_y, z - this_width - 2, stepID, 0, 2, chunk);
/*      */               }
/*  528 */               if (isBoringBlock(world, x + spiral, current_y, z + this_width + 2).booleanValue()) {
/*  529 */                 FastSetBlock(world, x + spiral, current_y, z + this_width + 2, stepID, 0, 2, chunk);
/*      */               }
/*  531 */               if (isBoringBlock(world, x - this_width - 2, current_y, z + spiral).booleanValue()) {
/*  532 */                 FastSetBlock(world, x - this_width - 2, current_y, z + spiral, stepID, 0, 2, chunk);
/*      */               }
/*  534 */               if (isBoringBlock(world, x + this_width + 2, current_y, z - spiral).booleanValue()) {
/*  535 */                 FastSetBlock(world, x + this_width + 2, current_y, z - spiral, stepID, 0, 2, chunk);
/*      */               }
/*      */             } 
/*  538 */             if (platform_looper != 1) spiral++;
/*      */           
/*      */           } 
/*      */           
/*  542 */           if (do_floor != 0)
/*      */           {
/*  544 */             for (int m = -this_width; m <= this_width; m++) {
/*      */               
/*  546 */               for (int n = -this_width; n <= this_width; n++) {
/*      */                 
/*  548 */                 if (isBoringBlock(world, x + m, current_y, z + n).booleanValue()) {
/*  549 */                   if (tree_type >= 0) {
/*  550 */                     FastSetBlock(world, x + m, current_y, z + n, ID, tree_type, 2, chunk);
/*      */                   } else {
/*  552 */                     FastSetBlock(world, x + m, current_y, z + n, ID, 0, 2, chunk);
/*  553 */                   }  if (m == 0 && n == 0)
/*      */                   {
/*      */ 
/*      */                     
/*  557 */                     if (this.rand.nextInt(2) == 0)
/*      */                     {
/*  559 */                       if (!bad_critters && world.isAirBlock(x, current_y + 1, z)) {
/*      */                         
/*  561 */                         FastSetBlock(world, x, current_y + 1, z, (Block)Blocks.chest, 0, 2, chunk);
/*  562 */                         TileEntityChest chest = (TileEntityChest)world.getTileEntity(x, current_y + 1, z);
/*  563 */                         if (chest != null)
/*      */                         {
/*      */                           
/*  566 */                           WeightedRandomChestContent.generateChestContents(this.rand, this.chestContentsList, (IInventory)chest, t_radius - this_width + this.rand.nextInt(10));
/*      */                         }
/*      */                       } 
/*      */                     }
/*      */                   }
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } 
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
/*  606 */         if (this_width != t_radius) {
/*  607 */           int next = this.rand.nextInt(4 + this_width);
/*  608 */           while (next == last || next == last_last) {
/*  609 */             next = this.rand.nextInt(4 + this_width);
/*      */           }
/*  611 */           if (next < 4) {
/*  612 */             last_last = last;
/*  613 */             last = next;
/*      */           } 
/*  615 */           switch (next) {
/*      */             case 0:
/*  617 */               make_branch(world, x + this_width, current_y, z, this_width, 1, 0, ID, leafID, tree_type, t_radius, bad_critters, chunk);
/*      */               break;
/*      */             case 1:
/*  620 */               make_branch(world, x - this_width, current_y, z, this_width, -1, 0, ID, leafID, tree_type, t_radius, bad_critters, chunk);
/*      */               break;
/*      */             case 2:
/*  623 */               make_branch(world, x, current_y, z + this_width, this_width, 0, 1, ID, leafID, tree_type, t_radius, bad_critters, chunk);
/*      */               break;
/*      */             case 3:
/*  626 */               make_branch(world, x, current_y, z - this_width, this_width, 0, -1, ID, leafID, tree_type, t_radius, bad_critters, chunk);
/*      */               break;
/*      */           } 
/*      */ 
/*      */ 
/*      */         
/*      */         } 
/*  633 */         current_y++;
/*  634 */         if (do_floor == 0) spiral++; 
/*  635 */         if (spiral > this_width) spiral = -this_width;
/*      */       
/*      */       } 
/*      */       
/*  639 */       this_width--;
/*      */       
/*  641 */       if (Math.abs(spiral) > this_width) spiral = -this_width;
/*      */       
/*  643 */       this_height += this.rand.nextInt(t_radius);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  648 */     if (isBoringBaseBlock(world, x, current_y, z).booleanValue()) {
/*  649 */       FastSetBlock(world, x, current_y, z, Blocks.emerald_block, 0, 2, chunk);
/*  650 */       FastSetBlock(world, x, current_y + 1, z, Blocks.emerald_block, 0, 2, chunk);
/*      */       
/*  652 */       if (stepID == Blocks.diamond_block) {
/*      */         
/*  654 */         Entity var8 = null;
/*      */ 
/*      */         
/*  657 */         var8 = EntityList.createEntityByName("The King", world);
/*      */         
/*  659 */         if (var8 != null) {
/*      */ 
/*      */           
/*  662 */           var8.setLocationAndAngles(x, (current_y + 4), z, world.rand.nextFloat() * 360.0F, 0.0F);
/*      */ 
/*      */           
/*  665 */           world.spawnEntityInWorld(var8);
/*      */           
/*  667 */           ((EntityLiving)var8).playLivingSound();
/*  668 */           ((TheKing)var8).setGuardMode(1);
/*      */         } 
/*      */       } 
/*  671 */       if (stepID == OreSpawnMain.MyBlockAmethystBlock) {
/*      */         
/*  673 */         Entity var8 = null;
/*      */ 
/*      */         
/*  676 */         var8 = EntityList.createEntityByName("The Queen", world);
/*      */         
/*  678 */         if (var8 != null) {
/*      */ 
/*      */           
/*  681 */           var8.setLocationAndAngles(x, (current_y + 4), z, world.rand.nextFloat() * 360.0F, 0.0F);
/*      */ 
/*      */           
/*  684 */           world.spawnEntityInWorld(var8);
/*      */           
/*  686 */           ((EntityLiving)var8).playLivingSound();
/*  687 */           ((TheQueen)var8).setGuardMode(1);
/*  688 */           ((TheQueen)var8).setBadMood(1);
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
/*      */   private void MakeCirclularBranch(World world, int iangle, int branchlen, int width, int startx, int starty, int startz, int twist, Block ID, Block leafID, int tree_type, Chunk chunk) {
/*  703 */     double curlen = 0.0D;
/*  704 */     int curangle = iangle;
/*  705 */     double curx = startx;
/*  706 */     double curz = startz;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  715 */     for (curlen = 0.0D; curlen < branchlen; curlen += 0.5D) {
/*      */ 
/*      */       
/*  718 */       curx += 0.5D * Math.sin(Math.toRadians(curangle));
/*  719 */       curz += 0.5D * Math.cos(Math.toRadians(curangle));
/*      */ 
/*      */ 
/*      */       
/*  723 */       double tw = width - width * curlen / branchlen; double wd;
/*  724 */       for (wd = 0.0D; wd <= tw; wd += 0.5D) {
/*      */ 
/*      */         
/*  727 */         Block id = leafID;
/*  728 */         if (wd < tw / 2.0D) id = ID; 
/*  729 */         if (tw < 0.9D) id = leafID;
/*      */         
/*  731 */         int ta = curangle + 90;
/*  732 */         if (ta > 360) ta -= 360; 
/*  733 */         double wx = curx + wd * Math.sin(Math.toRadians(ta));
/*  734 */         double wz = curz + wd * Math.cos(Math.toRadians(ta));
/*  735 */         if (isBoringBlock(world, (int)wx, starty, (int)wz).booleanValue())
/*      */         {
/*  737 */           if (tree_type >= 0) {
/*  738 */             FastSetBlock(world, (int)wx, starty, (int)wz, id, tree_type, 2, chunk);
/*      */           } else {
/*  740 */             FastSetBlock(world, (int)wx, starty, (int)wz, id, 0, 2, chunk);
/*      */           } 
/*      */         }
/*  743 */         if (id == ID)
/*      */         {
/*  745 */           if (isBoringBlock(world, (int)wx, starty + 1, (int)wz).booleanValue())
/*      */           {
/*  747 */             if (tree_type >= 0) {
/*  748 */               FastSetBlock(world, (int)wx, starty + 1, (int)wz, leafID, tree_type, 2, chunk);
/*      */             } else {
/*  750 */               FastSetBlock(world, (int)wx, starty + 1, (int)wz, leafID, 0, 2, chunk);
/*      */             } 
/*      */           }
/*      */         }
/*      */         
/*  755 */         ta = curangle - 90;
/*  756 */         if (ta < 0) ta += 360; 
/*  757 */         wx = curx + wd * Math.sin(Math.toRadians(ta));
/*  758 */         wz = curz + wd * Math.cos(Math.toRadians(ta));
/*  759 */         if (isBoringBlock(world, (int)wx, starty, (int)wz).booleanValue())
/*      */         {
/*  761 */           if (tree_type >= 0) {
/*  762 */             FastSetBlock(world, (int)wx, starty, (int)wz, id, tree_type, 2, chunk);
/*      */           } else {
/*  764 */             FastSetBlock(world, (int)wx, starty, (int)wz, id, 0, 2, chunk);
/*      */           }  } 
/*  766 */         if (id == ID)
/*      */         {
/*  768 */           if (isBoringBlock(world, (int)wx, starty + 1, (int)wz).booleanValue())
/*      */           {
/*  770 */             if (tree_type >= 0) {
/*  771 */               FastSetBlock(world, (int)wx, starty + 1, (int)wz, leafID, tree_type, 2, chunk);
/*      */             } else {
/*  773 */               FastSetBlock(world, (int)wx, starty + 1, (int)wz, leafID, 0, 2, chunk);
/*      */             } 
/*      */           }
/*      */         }
/*      */       } 
/*      */       
/*  779 */       curangle += twist;
/*  780 */       if (curangle < 0) curangle += 360; 
/*  781 */       if (curangle >= 360) curangle -= 360;
/*      */     
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
/*      */   public void MakeBigCircularTree(World world, int x, int y, int z, Block ID, Block leafID, Block stepID, int tree_type, int t_radius, boolean bad_critters, Chunk chunk) {
/*  794 */     double rad = t_radius;
/*  795 */     int curx = 0, cury = 0, curz = 0;
/*      */     
/*  797 */     int stepindex = this.rand.nextInt(360);
/*  798 */     int ibranch = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  803 */     cury = y; int i;
/*  804 */     for (i = 0; i < 360; i++) {
/*      */       
/*  806 */       double dt = rad * Math.sin(Math.toRadians(i)) + 0.5D;
/*  807 */       curx = (int)dt;
/*  808 */       dt = rad * Math.cos(Math.toRadians(i)) + 0.5D;
/*  809 */       curz = (int)dt;
/*  810 */       if (isBoringBaseBlock(world, x + curx, cury, z + curz).booleanValue()) {
/*  811 */         for (int j = 0; j < 20; j++) {
/*  812 */           if (cury - j > 0) {
/*  813 */             if (isBoringBaseBlock(world, x + curx, cury - j, z + curz).booleanValue()) {
/*  814 */               if (tree_type >= 0) {
/*  815 */                 FastSetBlock(world, x + curx, cury - j, z + curz, ID, tree_type, 2, chunk);
/*      */               } else {
/*  817 */                 FastSetBlock(world, x + curx, cury - j, z + curz, ID, 0, 2, chunk);
/*      */               } 
/*      */             } else {
/*      */               break;
/*      */             } 
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*  826 */     cury = 1;
/*  827 */     while (rad > 0.0D) {
/*  828 */       for (i = 0; i < 360; i++) {
/*      */         
/*  830 */         double dt = rad * Math.sin(Math.toRadians(i)) + 0.5D;
/*  831 */         curx = (int)dt;
/*  832 */         dt = rad * Math.cos(Math.toRadians(i)) + 0.5D;
/*  833 */         curz = (int)dt;
/*  834 */         if (isBoringBaseBlock(world, x + curx, y + cury, z + curz).booleanValue()) {
/*  835 */           if (tree_type >= 0) {
/*  836 */             FastSetBlock(world, x + curx, y + cury, z + curz, ID, tree_type, 2, chunk);
/*      */           } else {
/*  838 */             FastSetBlock(world, x + curx, y + cury, z + curz, ID, 0, 2, chunk);
/*      */           } 
/*      */         }
/*      */         
/*  842 */         if (i >= stepindex - 1 && i <= stepindex + 1 && rad > 1.0D) {
/*      */           
/*  844 */           dt = (rad + 1.9D) * Math.sin(Math.toRadians(i)) + 0.5D;
/*  845 */           curx = (int)dt;
/*  846 */           dt = (rad + 1.9D) * Math.cos(Math.toRadians(i)) + 0.5D;
/*  847 */           curz = (int)dt;
/*      */           
/*  849 */           for (int m = -1; m <= 1; m++) {
/*  850 */             for (int n = -1; n <= 1; n++) {
/*  851 */               if (isBoringBaseBlock(world, x + curx + m, y + cury, z + curz + n).booleanValue())
/*  852 */                 FastSetBlock(world, x + curx + m, y + cury, z + curz + n, stepID, 0, 2, chunk); 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*  857 */       if (cury > (int)rad) {
/*      */         
/*  859 */         ibranch += 80 + this.rand.nextInt(80);
/*  860 */         if (ibranch > 360) ibranch -= 360; 
/*  861 */         int ibranchlen = (int)(rad * 5.0D) + this.rand.nextInt((int)rad + 2);
/*  862 */         double dt = rad * Math.sin(Math.toRadians(ibranch)) + 0.5D;
/*  863 */         curx = (int)dt;
/*  864 */         dt = rad * Math.cos(Math.toRadians(ibranch)) + 0.5D;
/*  865 */         curz = (int)dt;
/*      */         
/*  867 */         MakeCirclularBranch(world, ibranch, ibranchlen, (int)rad + 1, x + curx, y + cury, z + curz, this.rand.nextInt(2) * ((this.rand.nextInt(2) == 0) ? -1 : 1), ID, leafID, tree_type, chunk);
/*      */       } 
/*      */ 
/*      */       
/*  871 */       if (cury % 6 == 0 && rad > 3.0D) {
/*      */         
/*  873 */         double dr = rad - 0.25D;
/*      */         
/*  875 */         while (dr > 0.0D) {
/*  876 */           for (i = 0; i < 360; i++) {
/*      */             
/*  878 */             double dt = dr * Math.sin(Math.toRadians(i)) + 0.5D;
/*  879 */             curx = (int)dt;
/*  880 */             dt = dr * Math.cos(Math.toRadians(i)) + 0.5D;
/*  881 */             curz = (int)dt;
/*  882 */             if (isBoringBaseBlock(world, x + curx, y + cury, z + curz).booleanValue())
/*  883 */               if (tree_type >= 0) {
/*  884 */                 FastSetBlock(world, x + curx, y + cury, z + curz, ID, tree_type, 2, chunk);
/*      */               } else {
/*  886 */                 FastSetBlock(world, x + curx, y + cury, z + curz, ID, 0, 2, chunk);
/*      */               }  
/*      */           } 
/*  889 */           dr -= 0.25D;
/*      */         } 
/*      */ 
/*      */         
/*  893 */         if (this.rand.nextInt(2) == 0)
/*      */         {
/*  895 */           if (!bad_critters && world.isAirBlock(x, y + cury + 1, z)) {
/*      */             
/*  897 */             FastSetBlock(world, x, y + cury + 1, z, (Block)Blocks.chest, 0, 2, chunk);
/*  898 */             TileEntityChest chest = (TileEntityChest)world.getTileEntity(x, y + cury + 1, z);
/*  899 */             if (chest != null)
/*      */             {
/*      */               
/*  902 */               WeightedRandomChestContent.generateChestContents(this.rand, this.chestContentsList, (IInventory)chest, t_radius - (int)rad + this.rand.nextInt(10));
/*      */             }
/*      */           } 
/*      */         }
/*      */       } 
/*      */       
/*  908 */       stepindex += 15 + (int)((t_radius - rad) * 3.0D);
/*  909 */       if (stepindex > 360) stepindex -= 360; 
/*  910 */       cury++;
/*  911 */       rad -= 0.01D * this.rand.nextInt(15);
/*  912 */       if (rad <= 0.0D)
/*      */       {
/*      */ 
/*      */         
/*  916 */         if (isBoringBaseBlock(world, x, y + cury, z).booleanValue()) {
/*  917 */           FastSetBlock(world, x, y + cury, z, Blocks.diamond_block, 0, 2, chunk);
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
/*      */   public void MakeBigRoundTree(World world, int inx, int y, int inz, Block ID, Block leafID, Block stepID, int tree_type, int t_radius, Chunk chunk) {
/*  932 */     double rad = t_radius;
/*  933 */     int cury = 0;
/*      */     
/*  935 */     int ibranch = 0;
/*      */ 
/*      */ 
/*      */     
/*  939 */     float fx = inx;
/*  940 */     fx += 0.5F;
/*  941 */     float fz = inz;
/*  942 */     fz += 0.5F;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  947 */     cury = y; int i;
/*  948 */     for (i = 0; i < 360; i++) {
/*      */       
/*  950 */       double dt = rad * Math.sin(Math.toRadians(i));
/*  951 */       float fcurx = (float)dt;
/*  952 */       dt = rad * Math.cos(Math.toRadians(i));
/*  953 */       float fcurz = (float)dt;
/*  954 */       if (isBoringBaseBlock(world, (int)(fx + fcurx), cury, (int)(fz + fcurz)).booleanValue()) {
/*  955 */         for (int j = 0; j < 20; j++) {
/*  956 */           if (cury - j > 0) {
/*  957 */             if (isBoringBaseBlock(world, (int)(fx + fcurx), cury - j, (int)(fz + fcurz)).booleanValue()) {
/*  958 */               if (tree_type >= 0) {
/*  959 */                 FastSetBlock(world, (int)(fx + fcurx), cury - j, (int)(fz + fcurz), ID, tree_type, 2, chunk);
/*      */               } else {
/*  961 */                 FastSetBlock(world, (int)(fx + fcurx), cury - j, (int)(fz + fcurz), ID, 0, 2, chunk);
/*      */               } 
/*      */             } else {
/*      */               break;
/*      */             } 
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*  970 */     cury = 1;
/*  971 */     while (rad > 0.0D) {
/*  972 */       for (i = 0; i < 360; i++) {
/*      */         
/*  974 */         double dt = rad * Math.sin(Math.toRadians(i));
/*  975 */         float fcurx = (float)dt;
/*  976 */         dt = rad * Math.cos(Math.toRadians(i));
/*  977 */         float fcurz = (float)dt;
/*  978 */         if (isBoringBaseBlock(world, (int)(fx + fcurx), y + cury, (int)(fz + fcurz)).booleanValue()) {
/*  979 */           if (tree_type >= 0) {
/*  980 */             FastSetBlock(world, (int)(fx + fcurx), y + cury, (int)(fz + fcurz), ID, tree_type, 2, chunk);
/*      */           } else {
/*  982 */             FastSetBlock(world, (int)(fx + fcurx), y + cury, (int)(fz + fcurz), ID, 0, 2, chunk);
/*      */           } 
/*      */         }
/*      */       } 
/*      */       
/*  987 */       if (cury > (int)rad) {
/*      */         
/*  989 */         ibranch += 80 + world.rand.nextInt(80);
/*  990 */         if (ibranch > 360) ibranch -= 360; 
/*  991 */         int ibranchlen = (int)(rad * 5.0D) + world.rand.nextInt((int)rad + 2);
/*  992 */         double dt = rad * Math.sin(Math.toRadians(ibranch));
/*  993 */         float fcurx = (float)dt;
/*  994 */         dt = rad * Math.cos(Math.toRadians(ibranch));
/*  995 */         float fcurz = (float)dt;
/*      */         
/*  997 */         MakeRoundBranch(world, ibranch, ibranchlen, (int)rad + 1, fx + fcurx, y + cury, fz + fcurz, ID, leafID, tree_type, chunk);
/*      */       } 
/*      */ 
/*      */       
/* 1001 */       if (cury % 6 == 0 && rad > 3.0D) {
/*      */         
/* 1003 */         double dr = rad - 0.25D;
/*      */         
/* 1005 */         while (dr > 0.0D) {
/* 1006 */           for (i = 0; i < 360; i++) {
/*      */             
/* 1008 */             double dt = dr * Math.sin(Math.toRadians(i));
/* 1009 */             float fcurx = (float)dt;
/* 1010 */             dt = dr * Math.cos(Math.toRadians(i));
/* 1011 */             float fcurz = (float)dt;
/* 1012 */             if (isBoringBaseBlock(world, (int)(fx + fcurx), y + cury, (int)(fz + fcurz)).booleanValue())
/* 1013 */               if (tree_type >= 0) {
/* 1014 */                 FastSetBlock(world, (int)(fx + fcurx), y + cury, (int)(fz + fcurz), ID, tree_type, 2, chunk);
/*      */               } else {
/* 1016 */                 FastSetBlock(world, (int)(fx + fcurx), y + cury, (int)(fz + fcurz), ID, 0, 2, chunk);
/*      */               }  
/*      */           } 
/* 1019 */           dr -= 0.25D;
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1024 */       cury++;
/* 1025 */       rad -= 0.01D * world.rand.nextInt(15);
/* 1026 */       if (rad <= 0.0D)
/*      */       {
/*      */ 
/*      */         
/* 1030 */         if (isBoringBaseBlock(world, (int)fx, y + cury, (int)fz).booleanValue()) {
/* 1031 */           FastSetBlock(world, (int)fx, y + cury, (int)fz, Blocks.diamond_block, 0, 2, chunk);
/*      */         }
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void MakeRoundBranch(World world, int iangle, int branchlen, int width, float startx, int starty, float startz, Block ID, Block leafID, int tree_type, Chunk chunk) {
/* 1039 */     double deltadir = 0.06283185200000001D;
/* 1040 */     double deltamag = 0.3499999940395355D;
/*      */ 
/*      */ 
/*      */     
/* 1044 */     int ixlast = 0, izlast = 0;
/* 1045 */     int xoff = 0;
/* 1046 */     int zoff = 0;
/* 1047 */     int radius = branchlen / 2;
/*      */ 
/*      */     
/* 1050 */     float centerx = (float)(startx + radius * Math.sin(Math.toRadians(iangle)));
/* 1051 */     float centerz = (float)(startz + radius * Math.cos(Math.toRadians(iangle)));
/*      */ 
/*      */ 
/*      */     
/* 1055 */     ixlast = izlast = 0; double curdir;
/* 1056 */     for (curdir = -3.1415926D; curdir < 3.1415926D; curdir += deltadir) {
/*      */       double h;
/* 1058 */       for (h = 0.75D; h < radius; h += deltamag) {
/* 1059 */         int ix = (int)(centerx + Math.cos(curdir) * h);
/* 1060 */         int iz = (int)(centerz + Math.sin(curdir) * h);
/* 1061 */         if (ix != ixlast || iz != izlast) {
/* 1062 */           ixlast = ix;
/* 1063 */           izlast = iz;
/*      */           
/* 1065 */           Block id = ID;
/* 1066 */           if (radius - h < 2.0D) id = leafID; 
/* 1067 */           if (isBoringBlock(world, ix, starty, iz).booleanValue()) {
/* 1068 */             FastSetBlock(world, ix, starty, iz, id, tree_type, 2, chunk);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void FastSetBlock(World world, int ix, int iy, int iz, Block id, int im, int iflg, Chunk chunk) {
/* 1077 */     OreSpawnMain.setBlockSuperFast(world, ix, iy, iz, id, im, 2, chunk);
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
/*      */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int clickedX, int clickedY, int clickedZ, int par7, float par8, float par9, float par10) {
/* 1095 */     Block var1 = world.getBlock(clickedX, clickedY, clickedZ);
/* 1096 */     if (var1 != Blocks.grass && var1 != Blocks.farmland && var1 != Blocks.dirt) {
/* 1097 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1101 */     int tree_type = this.rand.nextInt(4);
/*      */     
/* 1103 */     BlockLeaves blockLeaves = Blocks.leaves;
/*      */ 
/*      */     
/* 1106 */     this.no_critters = true;
/* 1107 */     if (this.rand.nextInt(2) == 1) this.no_critters = false;
/*      */ 
/*      */ 
/*      */     
/* 1111 */     if (!world.isRemote) {
/* 1112 */       world.setBlock(clickedX, clickedY, clickedZ, Blocks.gold_block, 0, 2);
/*      */     }
/* 1114 */     for (int var3 = 0; var3 < 6; var3++) {
/*      */       
/* 1116 */       par2EntityPlayer.worldObj.spawnParticle("largesmoke", (clickedX + 0.5F), ((clickedY + 1) + 0.25F), (clickedZ + 0.5F), 0.0D, 0.0D, 0.0D);
/* 1117 */       par2EntityPlayer.worldObj.spawnParticle("largeexplode", (clickedX + 0.5F), ((clickedY + 1) + 0.25F), (clickedZ + 0.5F), 0.0D, 0.0D, 0.0D);
/* 1118 */       par2EntityPlayer.worldObj.spawnParticle("reddust", (clickedX + 0.5F), ((clickedY + 1) + 0.25F), (clickedZ + 0.5F), 0.0D, 0.0D, 0.0D);
/*      */     } 
/*      */     
/* 1121 */     par2EntityPlayer.worldObj.playSoundAtEntity((Entity)par2EntityPlayer, "random.explode", 2.8F, 1.5F);
/*      */     
/* 1123 */     if (!world.isRemote) {
/*      */       Block block;
/* 1125 */       int rand_treetype = this.rand.nextInt(100);
/*      */       
/* 1127 */       if (rand_treetype >= 20) {
/* 1128 */         if (rand_treetype >= 40) {
/* 1129 */           if (tree_type != 3 && this.rand.nextInt(10) == 1) block = OreSpawnMain.MyAppleLeaves; 
/* 1130 */           MakeBigSquareTree(world, clickedX, clickedY, clickedZ, Blocks.log, block, Blocks.mossy_cobblestone, tree_type, this.tree_radius, this.no_critters, (Chunk)null);
/*      */         } else {
/* 1132 */           MakeBigRoundTree(world, clickedX, clickedY, clickedZ, Blocks.log, block, Blocks.mossy_cobblestone, tree_type, this.tree_radius, (Chunk)null);
/*      */         } 
/* 1134 */       } else if (rand_treetype == 1) {
/* 1135 */         if (OreSpawnMain.GinormousEmeraldTreeEnable != 0) {
/* 1136 */           if (this.rand.nextInt(2) == 0) {
/* 1137 */             MakeBigSquareTree(world, clickedX, clickedY, clickedZ, Blocks.gold_block, Blocks.emerald_block, Blocks.diamond_block, -1, this.tree_radius, true, (Chunk)null);
/*      */           } else {
/* 1139 */             MakeBigSquareTree(world, clickedX, clickedY, clickedZ, Blocks.obsidian, OreSpawnMain.MyBlockRubyBlock, OreSpawnMain.MyBlockAmethystBlock, -1, this.tree_radius, true, (Chunk)null);
/*      */           } 
/*      */         } else {
/* 1142 */           MakeBigSquareTree(world, clickedX, clickedY, clickedZ, Blocks.log, block, Blocks.iron_ore, tree_type, this.tree_radius, this.no_critters, (Chunk)null);
/*      */         } 
/*      */       } else {
/* 1145 */         MakeBigCircularTree(world, clickedX, clickedY, clickedZ, Blocks.log, block, Blocks.mossy_cobblestone, tree_type, this.tree_radius, this.no_critters, (Chunk)null);
/*      */       } 
/*      */     } 
/*      */     
/* 1149 */     if (!par2EntityPlayer.capabilities.isCreativeMode)
/*      */     {
/* 1151 */       par1ItemStack.stackSize--;
/*      */     }
/*      */     
/* 1154 */     return true;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void registerIcons(IIconRegister iconRegister) {
/* 1159 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemMagicApple.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */