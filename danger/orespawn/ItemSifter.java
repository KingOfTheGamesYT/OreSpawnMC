/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
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
/*     */ public class ItemSifter
/*     */   extends Item
/*     */ {
/*     */   public ItemSifter(int i) {
/*  33 */     this.maxStackSize = 1;
/*  34 */     setCreativeTab(CreativeTabs.tabDecorations);
/*  35 */     setMaxDamage(600);
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1, World world, int x, int y, int z) {
/*  40 */     EntityItem var3 = new EntityItem(world, (x + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2)) + 0.5D, y + 1.1D, (z + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2)) + 0.5D, new ItemStack(index, par1, 0));
/*     */     
/*  42 */     world.spawnEntityInWorld((Entity)var3);
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
/*     */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/*  56 */     if (par3World.isRemote)
/*     */     {
/*  58 */       return true;
/*     */     }
/*  60 */     Block bid = par3World.getBlock(par4, par5, par6);
/*  61 */     Block bid2 = par3World.getBlock(par4, par5 + 1, par6);
/*  62 */     if (bid2 == Blocks.flowing_water) bid = Blocks.water; 
/*  63 */     if (bid2 == Blocks.water) bid = Blocks.water;
/*     */     
/*  65 */     if (bid == Blocks.water) {
/*  66 */       int i = par3World.rand.nextInt(160);
/*  67 */       switch (i) {
/*     */         case 0:
/*  69 */           dropItemRand(Items.fish, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 1:
/*  72 */           dropItemRand(OreSpawnMain.MyGreenFish, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 2:
/*  75 */           dropItemRand(OreSpawnMain.MyBlueFish, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 3:
/*  78 */           dropItemRand(OreSpawnMain.MyPinkFish, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 4:
/*  81 */           dropItemRand(OreSpawnMain.MyRockFish, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 5:
/*  84 */           dropItemRand(OreSpawnMain.MyWoodFish, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 6:
/*  87 */           dropItemRand(OreSpawnMain.MyGreyFish, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 7:
/*  90 */           dropItemRand(Items.glass_bottle, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 8:
/*  93 */           dropItemRand(Items.iron_ingot, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 9:
/*  96 */           dropItemRand(Items.gold_nugget, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 10:
/*  99 */           dropItemRand(OreSpawnMain.MyItemShoes, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 11:
/* 102 */           dropItemRand(OreSpawnMain.MyItemShoes_1, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 12:
/* 105 */           dropItemRand(OreSpawnMain.MyItemShoes_2, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 13:
/* 108 */           dropItemRand(OreSpawnMain.MyItemShoes_3, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 14:
/* 111 */           dropItemRand(Items.glass_bottle, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 15:
/* 114 */           dropItemRand(Items.bone, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 16:
/* 117 */           dropItemRand(Item.getItemFromBlock(Blocks.stone), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 17:
/* 120 */           dropItemRand(Items.bucket, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 18:
/* 123 */           dropItemRand(Items.water_bucket, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 19:
/* 126 */           if (par3World.rand.nextInt(3) == 1) {
/* 127 */             dropItemRand(Items.emerald, 1, par3World, par4, par5, par6); break;
/*     */           } 
/* 129 */           dropItemRand(Item.getItemFromBlock(Blocks.gravel), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 20:
/* 132 */           if (par3World.rand.nextInt(3) == 1) {
/* 133 */             dropItemRand(OreSpawnMain.MyRuby, 1, par3World, par4, par5, par6); break;
/*     */           } 
/* 135 */           dropItemRand(Item.getItemFromBlock(Blocks.gravel), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 21:
/* 138 */           if (par3World.rand.nextInt(3) == 1) {
/* 139 */             dropItemRand(OreSpawnMain.MyAmethyst, 1, par3World, par4, par5, par6); break;
/*     */           } 
/* 141 */           dropItemRand(Item.getItemFromBlock(Blocks.gravel), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 22:
/* 144 */           dropItemRand(OreSpawnMain.MyMothScale, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 23:
/* 147 */           dropItemRand(OreSpawnMain.UraniumNugget, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 24:
/* 150 */           dropItemRand(OreSpawnMain.TitaniumNugget, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 25:
/* 153 */           if (par3World.rand.nextInt(2) == 1) {
/* 154 */             dropItemRand(Items.diamond, 1, par3World, par4, par5, par6); break;
/*     */           } 
/* 156 */           dropItemRand(Item.getItemFromBlock(Blocks.gravel), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 26:
/* 159 */           dropItemRand(Items.iron_ingot, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 27:
/* 162 */           dropItemRand(Items.gold_nugget, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 28:
/* 165 */           dropItemRand(Items.redstone, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 29:
/* 168 */           dropItemRand(Items.coal, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 30:
/* 171 */           dropItemRand(OreSpawnMain.MyItemShoes, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 31:
/* 174 */           dropItemRand(OreSpawnMain.MyItemShoes_1, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 32:
/* 177 */           dropItemRand(OreSpawnMain.MyItemShoes_2, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 33:
/* 180 */           dropItemRand(OreSpawnMain.MyItemShoes_3, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 34:
/* 183 */           dropItemRand(Items.fish, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 35:
/* 186 */           dropItemRand(Items.glass_bottle, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 36:
/* 189 */           dropItemRand(Items.bone, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 37:
/* 192 */           dropItemRand(Item.getItemFromBlock(Blocks.stone), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 38:
/* 195 */           dropItemRand(Item.getItemFromBlock(Blocks.stone_button), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 39:
/* 198 */           dropItemRand(Items.bucket, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 40:
/* 201 */           dropItemRand(Items.water_bucket, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 208 */     if (bid == Blocks.sand) {
/* 209 */       int i = par3World.rand.nextInt(60);
/* 210 */       switch (i) {
/*     */         case 0:
/* 212 */           dropItemRand(Items.iron_horse_armor, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 1:
/* 215 */           dropItemRand((Item)Items.shears, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 2:
/* 218 */           dropItemRand(Items.carrot_on_a_stick, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 3:
/* 221 */           dropItemRand(Items.poisonous_potato, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 4:
/* 224 */           dropItemRand(Items.item_frame, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 5:
/* 227 */           dropItemRand(Items.bone, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 6:
/* 230 */           dropItemRand(Items.compass, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 7:
/* 233 */           dropItemRand(Items.glass_bottle, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 8:
/* 236 */           dropItemRand(Items.saddle, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 9:
/* 239 */           dropItemRand((Item)Items.iron_helmet, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 10:
/* 242 */           dropItemRand((Item)Items.iron_chestplate, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 11:
/* 245 */           dropItemRand((Item)Items.iron_leggings, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 12:
/* 248 */           dropItemRand((Item)Items.iron_boots, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 13:
/* 251 */           dropItemRand(Item.getItemFromBlock((Block)Blocks.sand), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 258 */     if (bid == Blocks.gravel) {
/* 259 */       int i = par3World.rand.nextInt(60);
/* 260 */       switch (i) {
/*     */         case 0:
/* 262 */           dropItemRand(Items.flint, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 1:
/* 265 */           dropItemRand(OreSpawnMain.MySalt, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 2:
/* 268 */           dropItemRand(Items.flint_and_steel, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 3:
/* 271 */           dropItemRand(Items.spider_eye, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 4:
/* 274 */           dropItemRand(Items.item_frame, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 5:
/* 277 */           dropItemRand(Items.feather, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 6:
/* 280 */           dropItemRand(Items.string, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 7:
/* 283 */           dropItemRand(Items.glass_bottle, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 8:
/* 286 */           dropItemRand(Items.lead, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 9:
/* 289 */           dropItemRand(Items.name_tag, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 10:
/* 292 */           dropItemRand(Item.getItemFromBlock((Block)Blocks.sand), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 11:
/* 295 */           dropItemRand(Item.getItemFromBlock(Blocks.gravel), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 302 */     if (bid == Blocks.dirt) {
/* 303 */       int i = par3World.rand.nextInt(60);
/* 304 */       switch (i) {
/*     */         case 0:
/* 306 */           dropItemRand(Items.string, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 1:
/* 309 */           dropItemRand(OreSpawnMain.MySalt, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 2:
/* 312 */           dropItemRand((Item)Items.shears, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 3:
/* 315 */           dropItemRand(Items.stick, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 4:
/* 318 */           dropItemRand(Items.bowl, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 5:
/* 321 */           dropItemRand(Items.flower_pot, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 6:
/* 324 */           dropItemRand(Items.sign, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 7:
/* 327 */           dropItemRand(Items.brick, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 8:
/* 330 */           dropItemRand(Items.paper, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 9:
/* 333 */           dropItemRand(Items.bone, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 10:
/* 336 */           dropItemRand(Items.glass_bottle, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 11:
/* 339 */           dropItemRand(Item.getItemFromBlock((Block)Blocks.sand), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 12:
/* 342 */           dropItemRand(Item.getItemFromBlock(Blocks.gravel), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 13:
/* 345 */           dropItemRand(Item.getItemFromBlock(Blocks.dirt), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 352 */     if (bid == Blocks.grass) {
/* 353 */       int i = par3World.rand.nextInt(60);
/* 354 */       switch (i) {
/*     */         case 0:
/* 356 */           dropItemRand(Item.getItemFromBlock((Block)Blocks.yellow_flower), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 1:
/* 359 */           dropItemRand(Item.getItemFromBlock((Block)Blocks.red_flower), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 2:
/* 362 */           dropItemRand(Item.getItemFromBlock(OreSpawnMain.MyFlowerPinkBlock), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 3:
/* 365 */           dropItemRand(Item.getItemFromBlock(OreSpawnMain.MyFlowerBlueBlock), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 4:
/* 368 */           dropItemRand(Item.getItemFromBlock(OreSpawnMain.MyFlowerBlackBlock), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 5:
/* 371 */           dropItemRand(Item.getItemFromBlock(OreSpawnMain.MyFlowerScaryBlock), 1, par3World, par4, par5, par6);
/*     */         case 6:
/* 373 */           dropItemRand(Items.wheat, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 7:
/* 376 */           dropItemRand(Items.pumpkin_seeds, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 8:
/* 379 */           dropItemRand(Items.melon_seeds, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 9:
/* 382 */           dropItemRand(Items.carrot, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 10:
/* 385 */           dropItemRand(Items.potato, 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 11:
/* 388 */           dropItemRand(Item.getItemFromBlock((Block)Blocks.deadbush), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 12:
/* 391 */           dropItemRand(Item.getItemFromBlock(Blocks.gravel), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 13:
/* 394 */           dropItemRand(Item.getItemFromBlock(Blocks.dirt), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */         case 14:
/* 397 */           dropItemRand(Item.getItemFromBlock((Block)Blocks.grass), 1, par3World, par4, par5, par6);
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 404 */     par1ItemStack.damageItem(1, (EntityLivingBase)par2EntityPlayer);
/*     */     
/* 406 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMaterialName() {
/* 415 */     return "Unknown";
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 421 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemSifter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */