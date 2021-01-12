/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
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
/*     */ public class IslandToo
/*     */   extends EntityAnimal
/*     */ {
/*  24 */   private int dir = 0;
/*  25 */   private float speed = 0.1F;
/*  26 */   private int width = 5;
/*  27 */   private int depth = 3;
/*  28 */   private int length = 10;
/*  29 */   private int timer = 42;
/*  30 */   private int just_spawned = 1;
/*  31 */   private int ticker = 0;
/*  32 */   private int once = 1;
/*     */   private double myX;
/*  34 */   private int dirchange = 0; private double myY; private double myZ;
/*  35 */   private int blocktype = 0;
/*     */ 
/*     */   
/*     */   public IslandToo(World par1World) {
/*  39 */     super(par1World);
/*  40 */     setSize(0.5F, 0.5F);
/*  41 */     this.ticker = par1World.rand.nextInt(50);
/*  42 */     this.dirchange = this.worldObj.rand.nextInt(5000);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  50 */     super.onUpdate();
/*  51 */     this.motionX = this.motionY = this.motionZ = 0.0D;
/*  52 */     if (this.worldObj.isRemote)
/*     */       return; 
/*  54 */     if (this.once != 0) {
/*  55 */       this.myX = this.posX;
/*  56 */       this.myY = this.posY;
/*  57 */       this.myZ = this.posZ;
/*  58 */       this.once = 0;
/*     */     } 
/*  60 */     if (this.just_spawned != 0) {
/*  61 */       this.dir = this.worldObj.rand.nextInt(4);
/*     */       
/*  63 */       if (this.worldObj.rand.nextInt(40) != 1) {
/*  64 */         this.width = 1 + this.worldObj.rand.nextInt(5 * OreSpawnMain.IslandSizeFactor);
/*  65 */         this.length = this.width;
/*  66 */         this.depth = 1 + this.worldObj.rand.nextInt(4);
/*  67 */         this.speed = this.worldObj.rand.nextFloat() / 40.0F * OreSpawnMain.IslandSpeedFactor;
/*  68 */         if (this.length * this.width * this.depth <= 64) this.speed *= 2.0F; 
/*  69 */         if (this.length * this.width * this.depth <= 32) this.speed *= 2.0F; 
/*     */       } else {
/*  71 */         this.width = 5 + this.worldObj.rand.nextInt(8 * OreSpawnMain.IslandSizeFactor);
/*  72 */         this.length = this.width;
/*  73 */         this.depth = 3 + this.worldObj.rand.nextInt(6);
/*  74 */         this.speed = this.worldObj.rand.nextFloat() / 150.0F * OreSpawnMain.IslandSpeedFactor;
/*     */       } 
/*     */       
/*  77 */       create_island();
/*  78 */       this.ticker = this.worldObj.rand.nextInt(50);
/*  79 */       this.dirchange = this.worldObj.rand.nextInt(10000);
/*     */     } 
/*     */     
/*  82 */     this.ticker++;
/*  83 */     if (this.ticker >= this.timer) {
/*  84 */       update_island();
/*  85 */       this.ticker = 0;
/*     */     } 
/*  87 */     this.dirchange--;
/*  88 */     if (this.dirchange <= 0) {
/*  89 */       this.dirchange = this.worldObj.rand.nextInt(5000);
/*  90 */       this.dir = this.worldObj.rand.nextInt(4);
/*     */     } 
/*     */     
/*  93 */     this.just_spawned = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/*  98 */     if (this.worldObj.isRemote) {
/*  99 */       super.onLivingUpdate();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITick() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 126 */     super.readEntityFromNBT(par1NBTTagCompound);
/* 127 */     this.just_spawned = par1NBTTagCompound.getInteger("JustSpawned");
/* 128 */     this.width = par1NBTTagCompound.getInteger("Iwidth");
/* 129 */     this.depth = par1NBTTagCompound.getInteger("Idepth");
/* 130 */     this.length = par1NBTTagCompound.getInteger("Ilength");
/*     */     
/* 132 */     this.speed = par1NBTTagCompound.getFloat("Ispeed");
/* 133 */     this.dir = par1NBTTagCompound.getInteger("Idir");
/* 134 */     this.blocktype = par1NBTTagCompound.getInteger("Iblocktype");
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 139 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 140 */     par1NBTTagCompound.setInteger("JustSpawned", this.just_spawned);
/* 141 */     par1NBTTagCompound.setInteger("Iwidth", this.width);
/* 142 */     par1NBTTagCompound.setInteger("Idepth", this.depth);
/* 143 */     par1NBTTagCompound.setInteger("Ilength", this.length);
/*     */     
/* 145 */     par1NBTTagCompound.setFloat("Ispeed", this.speed);
/* 146 */     par1NBTTagCompound.setInteger("Idir", this.dir);
/* 147 */     par1NBTTagCompound.setInteger("Iblocktype", this.blocktype);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 153 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 162 */     boolean ret = false;
/* 163 */     int xoff = 0;
/* 164 */     int zoff = 0;
/*     */     
/* 166 */     int ix = (int)this.posX, iz = (int)this.posZ;
/* 167 */     if (ix < 0) {
/* 168 */       xoff = 1;
/* 169 */       this.posX = ix;
/* 170 */       this.posX -= 0.5D;
/*     */     } else {
/* 172 */       this.posX = ix;
/* 173 */       this.posX += 0.5D;
/*     */     } 
/*     */     
/* 176 */     if (iz < 0) {
/* 177 */       zoff = 1;
/* 178 */       this.posZ = iz;
/* 179 */       this.posZ -= 0.5D;
/*     */     } else {
/* 181 */       this.posZ = iz;
/* 182 */       this.posZ += 0.5D;
/*     */     } 
/*     */ 
/*     */     
/* 186 */     super.attackEntityFrom(par1DamageSource, par2);
/* 187 */     return ret;
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
/*     */   private void create_island() {
/* 201 */     int xoff = 0;
/* 202 */     int zoff = 0;
/* 203 */     if (this.posX < 0.0D) xoff = 1; 
/* 204 */     if (this.posZ < 0.0D) zoff = 1;
/*     */     
/* 206 */     for (int k = 0; k <= this.depth; k++) {
/* 207 */       int il = this.length / (this.depth - k + 1);
/* 208 */       if (il < 1) il = 1; 
/* 209 */       for (int i = -il; i <= il; i++) {
/* 210 */         for (int j = -il; j <= il; j++) {
/* 211 */           int ix = (int)this.posX + j - xoff;
/* 212 */           int iz = (int)this.posZ + i - zoff;
/* 213 */           if (k == this.depth) {
/* 214 */             Block bid; if ((bid = this.worldObj.getBlock(ix, (int)this.posY + k, iz)) == Blocks.air) {
/* 215 */               if (this.worldObj.rand.nextInt(5000) == 1) {
/* 216 */                 this.worldObj.setBlock(ix, (int)this.posY + k, iz, Blocks.water);
/*     */               } else {
/* 218 */                 FastSetBlock(ix, (int)this.posY + k, iz, (Block)Blocks.grass);
/* 219 */                 if (this.worldObj.rand.nextInt(30) == 1) {
/* 220 */                   if (this.worldObj.getBlock(ix, (int)this.posY + k + 1, iz) == Blocks.air) {
/* 221 */                     if (this.worldObj.rand.nextInt(2) == 1) {
/* 222 */                       this.worldObj.setBlock(ix, (int)this.posY + k + 1, iz, OreSpawnMain.MyFlowerPinkBlock);
/*     */                     } else {
/* 224 */                       this.worldObj.setBlock(ix, (int)this.posY + k + 1, iz, OreSpawnMain.MyFlowerBlueBlock);
/*     */                     } 
/*     */                   }
/* 227 */                 } else if (this.worldObj.rand.nextInt(100) == 1 && 
/* 228 */                   this.worldObj.getBlock(ix, (int)this.posY + k + 1, iz) == Blocks.air) {
/* 229 */                   OreSpawnMain.OreSpawnTrees.SmallTree(this.worldObj, ix, (int)this.posY + k + 1, iz);
/*     */                 }
/*     */               
/*     */               }
/*     */             
/* 234 */             } else if (bid == Blocks.bedrock) {
/* 235 */               setDead();
/*     */               
/*     */               return;
/*     */             } 
/*     */           } else {
/* 240 */             mySetBlock(ix, (int)this.posY + k, iz);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 248 */     this.worldObj.setBlock((int)this.posX - xoff, (int)this.posY, (int)this.posZ - zoff, Blocks.air);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void mySetBlock(int ix, int iy, int iz) {
/* 254 */     Block bid = Blocks.stone;
/* 255 */     if (this.blocktype == 0) this.blocktype = 1 + this.worldObj.rand.nextInt(8); 
/* 256 */     if (this.blocktype == 1 && this.worldObj.rand.nextInt(5) == 1) bid = Blocks.coal_ore; 
/* 257 */     if (this.blocktype == 2 && this.worldObj.rand.nextInt(10) == 1) bid = Blocks.iron_ore; 
/* 258 */     if (this.blocktype == 3 && this.worldObj.rand.nextInt(20) == 1) bid = Blocks.emerald_ore; 
/* 259 */     if (this.blocktype == 4 && this.worldObj.rand.nextInt(30) == 1) bid = OreSpawnMain.MyOreTitaniumBlock; 
/* 260 */     if (this.blocktype == 5 && this.worldObj.rand.nextInt(30) == 1) bid = OreSpawnMain.MyOreUraniumBlock; 
/* 261 */     if (this.blocktype == 6 && this.worldObj.rand.nextInt(30) == 1) bid = OreSpawnMain.MyOreRubyBlock; 
/* 262 */     if (this.blocktype == 7 && this.worldObj.rand.nextInt(30) == 1) bid = OreSpawnMain.MyOreAmethystBlock; 
/* 263 */     if (this.blocktype == 8 && this.worldObj.rand.nextInt(20) == 1) bid = Blocks.gold_ore; 
/* 264 */     if (bid == Blocks.stone) {
/* 265 */       if (this.worldObj.rand.nextInt(3000) == 1) bid = OreSpawnMain.MyEnderPearlBlock; 
/* 266 */       if (this.worldObj.rand.nextInt(3000) == 2) bid = OreSpawnMain.MyEyeOfEnderBlock; 
/* 267 */       if (this.worldObj.rand.nextInt(3000) == 3) bid = OreSpawnMain.MyBlockAmethystBlock; 
/* 268 */       if (this.worldObj.rand.nextInt(3000) == 4) bid = OreSpawnMain.MyBlockRubyBlock; 
/* 269 */       if (this.worldObj.rand.nextInt(3000) == 5) bid = OreSpawnMain.MyBlockUraniumBlock; 
/* 270 */       if (this.worldObj.rand.nextInt(3000) == 6) bid = OreSpawnMain.MyBlockTitaniumBlock; 
/* 271 */       if (this.worldObj.rand.nextInt(3000) == 7) bid = Blocks.gold_block; 
/* 272 */       if (this.worldObj.rand.nextInt(3000) == 8) bid = Blocks.diamond_block; 
/*     */     } 
/* 274 */     FastSetBlock(ix, iy, iz, bid);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void update_island() {
/* 284 */     int xoff = 0;
/* 285 */     int zoff = 0;
/*     */     
/* 287 */     if (this.dir == 0) {
/* 288 */       this.myZ -= this.speed;
/* 289 */     } else if (this.dir == 1) {
/* 290 */       this.myZ += this.speed;
/* 291 */     } else if (this.dir == 2) {
/* 292 */       this.myX += this.speed;
/*     */     } else {
/* 294 */       this.myX -= this.speed;
/*     */     } 
/*     */     
/* 297 */     int ke = 0, ks = ke, je = ks, js = je;
/*     */     
/* 299 */     int mx = (int)this.myX, mz = (int)this.myZ;
/* 300 */     int px = (int)this.posX, pz = (int)this.posZ;
/* 301 */     if (mx != px || mz != pz) {
/* 302 */       if (this.dir == 0) {
/* 303 */         js = 1;
/* 304 */         je = 1;
/* 305 */         ks = -1;
/* 306 */         ke = 1;
/* 307 */       } else if (this.dir == 1) {
/* 308 */         js = -1;
/* 309 */         je = -1;
/* 310 */         ks = -1;
/* 311 */         ke = 1;
/* 312 */       } else if (this.dir == 2) {
/* 313 */         js = -1;
/* 314 */         je = 1;
/* 315 */         ks = -1;
/* 316 */         ke = -1;
/*     */       } else {
/* 318 */         js = -1;
/* 319 */         je = 1;
/* 320 */         ks = 1;
/* 321 */         ke = 1;
/*     */       } 
/*     */       
/* 324 */       if (this.posX < 0.0D) xoff = 1; 
/* 325 */       if (this.posZ < 0.0D) zoff = 1;  int i;
/* 326 */       for (i = 0; i <= this.depth; i++) {
/* 327 */         int il = this.length / (this.depth - i + 1);
/* 328 */         if (il < 1) il = 1; 
/* 329 */         for (int j = js * il; j <= je * il; j++) {
/* 330 */           for (int k = ks * il; k <= ke * il; k++) {
/* 331 */             int ix = (int)this.posX + k - xoff;
/* 332 */             int iz = (int)this.posZ + j - zoff;
/*     */ 
/*     */ 
/*     */             
/* 336 */             if (i == this.depth) {
/*     */               
/* 338 */               Block bid = this.worldObj.getBlock(ix, (int)this.posY + i + 1, iz);
/* 339 */               if (bid == OreSpawnMain.MyFlowerPinkBlock || bid == OreSpawnMain.MyFlowerBlueBlock || bid == OreSpawnMain.MyFlowerBlackBlock || bid == OreSpawnMain.MyFlowerScaryBlock)
/*     */               {
/* 341 */                 FastSetBlock(ix, (int)this.posY + i + 1, iz, Blocks.air);
/*     */               }
/* 343 */               if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 344 */                 this.worldObj.setBlock(ix, (int)this.posY + i, iz, Blocks.air);
/*     */               }
/* 346 */               if (bid == OreSpawnMain.MySkyTreeLog) {
/* 347 */                 this.worldObj.setBlock(ix, (int)this.posY + i + 1, iz, Blocks.air);
/* 348 */                 bid = this.worldObj.getBlock(ix, (int)this.posY + i + 2, iz);
/* 349 */                 if (bid == OreSpawnMain.MySkyTreeLog) {
/* 350 */                   this.worldObj.setBlock(ix, (int)this.posY + i + 2, iz, Blocks.air);
/* 351 */                   bid = this.worldObj.getBlock(ix, (int)this.posY + i + 3, iz);
/* 352 */                   if (bid == OreSpawnMain.MySkyTreeLog) {
/* 353 */                     this.worldObj.setBlock(ix, (int)this.posY + i + 3, iz, Blocks.air);
/*     */                   }
/*     */                 } 
/*     */               } 
/* 357 */               bid = this.worldObj.getBlock(ix, (int)this.posY + i, iz);
/* 358 */               if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 359 */                 this.worldObj.setBlock(ix, (int)this.posY + i, iz, Blocks.air);
/*     */               }
/*     */             } 
/*     */             
/* 363 */             FastSetBlock(ix, (int)this.posY + i, iz, Blocks.air);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 369 */       mySetBlock((int)this.posX - xoff, (int)this.posY, (int)this.posZ - zoff);
/*     */ 
/*     */       
/* 372 */       this.posX = mx;
/* 373 */       if (this.myX < 0.0D) {
/* 374 */         this.posX -= 0.5D;
/*     */       } else {
/* 376 */         this.posX += 0.5D;
/*     */       } 
/* 378 */       this.posZ = mz;
/* 379 */       if (this.myZ < 0.0D) {
/* 380 */         this.posZ -= 0.5D;
/*     */       } else {
/* 382 */         this.posZ += 0.5D;
/*     */       } 
/* 384 */       if (this.dir == 0) {
/* 385 */         js = -1;
/* 386 */         je = -1;
/* 387 */         ks = -1;
/* 388 */         ke = 1;
/* 389 */       } else if (this.dir == 1) {
/* 390 */         js = 1;
/* 391 */         je = 1;
/* 392 */         ks = -1;
/* 393 */         ke = 1;
/* 394 */       } else if (this.dir == 2) {
/* 395 */         js = -1;
/* 396 */         je = 1;
/* 397 */         ks = 1;
/* 398 */         ke = 1;
/*     */       } else {
/* 400 */         js = -1;
/* 401 */         je = 1;
/* 402 */         ks = -1;
/* 403 */         ke = -1;
/*     */       } 
/* 405 */       xoff = zoff = 0;
/* 406 */       if (this.posX < 0.0D) xoff = 1; 
/* 407 */       if (this.posZ < 0.0D) zoff = 1;
/*     */       
/* 409 */       this.worldObj.setBlock((int)this.posX - xoff, (int)this.posY, (int)this.posZ - zoff, Blocks.air);
/*     */       
/* 411 */       for (i = 0; i <= this.depth; i++) {
/* 412 */         int il = this.length / (this.depth - i + 1);
/* 413 */         if (il < 1) il = 1; 
/* 414 */         for (int j = js * il; j <= je * il; j++) {
/* 415 */           for (int k = ks * il; k <= ke * il; k++) {
/* 416 */             int ix = (int)this.posX + k - xoff;
/* 417 */             int iz = (int)this.posZ + j - zoff;
/* 418 */             if (i == this.depth) {
/* 419 */               Block bid; if ((bid = this.worldObj.getBlock(ix, (int)this.posY + i, iz)) == Blocks.air) {
/* 420 */                 if (this.worldObj.rand.nextInt(5000) == 1) {
/* 421 */                   this.worldObj.setBlock(ix, (int)this.posY + i, iz, Blocks.water);
/*     */                 } else {
/* 423 */                   FastSetBlock(ix, (int)this.posY + i, iz, (Block)Blocks.grass);
/* 424 */                   if (this.worldObj.rand.nextInt(30) == 1) {
/* 425 */                     if (this.worldObj.getBlock(ix, (int)this.posY + i + 1, iz) == Blocks.air) {
/* 426 */                       if (this.worldObj.rand.nextInt(2) == 1) {
/* 427 */                         this.worldObj.setBlock(ix, (int)this.posY + i + 1, iz, OreSpawnMain.MyFlowerPinkBlock);
/*     */                       } else {
/* 429 */                         this.worldObj.setBlock(ix, (int)this.posY + i + 1, iz, OreSpawnMain.MyFlowerBlueBlock);
/*     */                       } 
/*     */                     }
/* 432 */                   } else if (this.worldObj.rand.nextInt(100) == 1 && 
/* 433 */                     this.worldObj.getBlock(ix, (int)this.posY + i + 1, iz) == Blocks.air) {
/* 434 */                     OreSpawnMain.OreSpawnTrees.SmallTree(this.worldObj, ix, (int)this.posY + i + 1, iz);
/*     */                   }
/*     */                 
/*     */                 }
/*     */               
/* 439 */               } else if (bid == Blocks.bedrock) {
/* 440 */                 setDead();
/*     */                 
/*     */                 return;
/*     */               } 
/*     */             } else {
/* 445 */               Block bid = this.worldObj.getBlock(ix, (int)this.posY + i, iz);
/* 446 */               if (bid == Blocks.end_stone) {
/* 447 */                 if (!this.worldObj.isRemote) this.worldObj.createExplosion((Entity)this, ix, this.posY + i, iz, 5.0F, true);
/*     */               
/*     */               } else {
/*     */                 
/* 451 */                 mySetBlock(ix, (int)this.posY + i, iz);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 458 */       this.worldObj.setBlock((int)this.posX - xoff, (int)this.posY, (int)this.posZ - zoff, Blocks.air);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 466 */     return Item.getItemFromBlock(OreSpawnMain.MyIslandBlock);
/*     */   }
/*     */ 
/*     */   
/*     */   public void FastSetBlock(int ix, int iy, int iz, Block id) {
/* 471 */     OreSpawnMain.setBlockFast(this.worldObj, ix, iy, iz, id, 0, 3);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\IslandToo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */