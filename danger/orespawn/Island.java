/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
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
/*     */ public class Island
/*     */   extends EntityAnimal
/*     */ {
/*  29 */   private float dir = 0.0F;
/*  30 */   private float speed = 0.1F;
/*  31 */   private int radius = 5;
/*  32 */   private int depth = 3;
/*  33 */   private int timer = 73;
/*  34 */   private int just_spawned = 1;
/*  35 */   private int ticker = 0;
/*  36 */   private int once = 1;
/*     */   
/*     */   private double myX;
/*     */   private double myY;
/*     */   
/*     */   public Island(World par1World) {
/*  42 */     super(par1World);
/*  43 */     setSize(0.5F, 0.5F);
/*  44 */     this.ticker = par1World.rand.nextInt(50);
/*  45 */     this.dirchange = this.worldObj.rand.nextInt(2500);
/*     */   }
/*     */ 
/*     */   
/*     */   private double myZ;
/*     */   private int dirchange;
/*     */   
/*     */   public void onUpdate() {
/*  53 */     super.onUpdate();
/*  54 */     this.motionX = this.motionY = this.motionZ = 0.0D;
/*  55 */     if (this.worldObj.isRemote)
/*     */       return; 
/*  57 */     if (this.once != 0) {
/*  58 */       this.myX = this.posX;
/*  59 */       this.myY = this.posY;
/*  60 */       this.myZ = this.posZ;
/*  61 */       this.once = 0;
/*     */     } 
/*  63 */     if (this.just_spawned != 0) {
/*  64 */       this.dir = this.worldObj.rand.nextFloat() * 3.1415927F;
/*  65 */       if (this.worldObj.rand.nextInt(2) == 1) this.dir *= -1.0F;
/*     */       
/*  67 */       if (this.worldObj.rand.nextInt(40) != 1) {
/*  68 */         this.radius = 3 + this.worldObj.rand.nextInt(4);
/*  69 */         this.depth = 2 + this.worldObj.rand.nextInt(3);
/*  70 */         this.speed = this.worldObj.rand.nextFloat() / 50.0F * OreSpawnMain.IslandSpeedFactor;
/*     */       } else {
/*  72 */         this.radius = 6 + this.worldObj.rand.nextInt(5);
/*  73 */         this.depth = 3 + this.worldObj.rand.nextInt(4);
/*  74 */         this.speed = this.worldObj.rand.nextFloat() / 200.0F * OreSpawnMain.IslandSpeedFactor;
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
/*  90 */       this.dir = this.worldObj.rand.nextFloat() * 3.1415927F;
/*  91 */       if (this.worldObj.rand.nextInt(2) == 1) this.dir *= -1.0F;
/*     */     
/*     */     } 
/*  94 */     this.just_spawned = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/*  99 */     if (this.worldObj.isRemote) {
/* 100 */       super.onLivingUpdate();
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
/* 120 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 127 */     super.readEntityFromNBT(par1NBTTagCompound);
/* 128 */     this.just_spawned = par1NBTTagCompound.getInteger("JustSpawned");
/*     */     
/* 130 */     this.depth = par1NBTTagCompound.getInteger("Idepth");
/* 131 */     this.radius = par1NBTTagCompound.getInteger("Iradius");
/*     */     
/* 133 */     this.speed = par1NBTTagCompound.getFloat("Ispeed");
/* 134 */     this.dir = par1NBTTagCompound.getFloat("Idir");
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 139 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 140 */     par1NBTTagCompound.setInteger("JustSpawned", this.just_spawned);
/*     */     
/* 142 */     par1NBTTagCompound.setInteger("Idepth", this.depth);
/* 143 */     par1NBTTagCompound.setInteger("Iradius", this.radius);
/*     */     
/* 145 */     par1NBTTagCompound.setFloat("Ispeed", this.speed);
/* 146 */     par1NBTTagCompound.setFloat("Idir", this.dir);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 152 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void create_island() {
/* 161 */     double deltadir = 0.10471975333333333D;
/* 162 */     double deltamag = 0.3499999940395355D;
/*     */ 
/*     */ 
/*     */     
/* 166 */     int ixlast = 0, izlast = 0;
/* 167 */     int xoff = 0;
/* 168 */     int zoff = 0;
/*     */ 
/*     */ 
/*     */     
/* 172 */     for (int i = 0; i < this.depth; i++) {
/* 173 */       ixlast = izlast = 0; double curdir;
/* 174 */       for (curdir = -3.1415926D; curdir < 3.1415926D; curdir += deltadir) {
/* 175 */         double tradius = this.radius;
/* 176 */         tradius /= (i + 1);
/*     */         double h;
/* 178 */         for (h = 0.75D; h < tradius; h += deltamag) {
/* 179 */           int ix = (int)(this.posX + Math.cos(curdir + this.dir) * h);
/* 180 */           int iz = (int)(this.posZ + Math.sin(curdir + this.dir) * h);
/* 181 */           if (ix != ixlast || iz != izlast) {
/* 182 */             ixlast = ix;
/* 183 */             izlast = iz;
/* 184 */             if (i == 0) {
/* 185 */               Block bid; if ((bid = this.worldObj.getBlock(ix, (int)this.posY - i + 1, iz)) == Blocks.air) {
/* 186 */                 if (this.worldObj.rand.nextInt(5000) == 1) {
/* 187 */                   this.worldObj.setBlock(ix, (int)this.posY - i + 1, iz, Blocks.lava);
/*     */                 } else {
/* 189 */                   FastSetBlock(ix, (int)this.posY - i + 1, iz, (Block)Blocks.mycelium);
/* 190 */                   if (this.worldObj.rand.nextInt(20) == 1 && 
/* 191 */                     this.worldObj.getBlock(ix, (int)this.posY - i + 2, iz) == Blocks.air) {
/* 192 */                     if (this.worldObj.rand.nextInt(2) == 1) {
/* 193 */                       this.worldObj.setBlock(ix, (int)this.posY - i + 2, iz, (Block)Blocks.brown_mushroom);
/*     */                     } else {
/* 195 */                       this.worldObj.setBlock(ix, (int)this.posY - i + 2, iz, (Block)Blocks.red_mushroom);
/*     */                     }
/*     */                   
/*     */                   }
/*     */                 }
/*     */               
/* 201 */               } else if (bid == Blocks.bedrock) {
/* 202 */                 setDead();
/*     */ 
/*     */                 
/*     */                 return;
/*     */               } 
/* 207 */             } else if (this.worldObj.rand.nextInt(10) == 1) {
/* 208 */               FastSetBlock(ix, (int)this.posY - i + 1, iz, Blocks.diamond_ore);
/*     */             } else {
/* 210 */               FastSetBlock(ix, (int)this.posY - i + 1, iz, Blocks.end_stone);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 218 */     if (this.posX < 0.0D) xoff = -1; 
/* 219 */     if (this.posZ < 0.0D) zoff = -1; 
/* 220 */     this.worldObj.setBlock((int)this.posX + xoff, (int)this.posY, (int)this.posZ + zoff, Blocks.air);
/* 221 */     FastSetBlock((int)this.posX + xoff, (int)this.posY, (int)this.posZ + zoff, Blocks.air);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void update_island() {
/* 229 */     double deltadir = 0.10471975333333333D;
/* 230 */     double deltamag = 0.3499999940395355D;
/*     */     
/* 232 */     double pi2 = 1.57079632675D;
/*     */ 
/*     */     
/* 235 */     int ixlast = 0, izlast = 0;
/* 236 */     int xoff = 0;
/* 237 */     int zoff = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 242 */     this.myX += this.speed * Math.cos(this.dir);
/* 243 */     this.myZ += this.speed * Math.sin(this.dir);
/*     */     
/* 245 */     int mx = (int)this.myX, mz = (int)this.myZ;
/* 246 */     int px = (int)this.posX, pz = (int)this.posZ;
/* 247 */     if (mx != px || mz != pz) {
/*     */       int i;
/*     */       
/* 250 */       for (i = 0; i < this.depth; i++) {
/* 251 */         ixlast = izlast = 0; double curdir;
/* 252 */         for (curdir = -3.3D; curdir < 3.3D; curdir += deltadir / 2.0D) {
/*     */           
/* 254 */           double tradius = this.radius;
/* 255 */           tradius /= (i + 1);
/*     */           double h;
/* 257 */           for (h = 0.75D; h < tradius;) {
/* 258 */             h += deltamag;
/*     */           }
/* 260 */           h -= deltamag;
/* 261 */           if (h < 0.75D) h = 0.75D; 
/* 262 */           for (; h < tradius + deltamag; h += deltamag / 2.0D) {
/* 263 */             int ix = (int)(this.posX + Math.cos(curdir + this.dir) * h);
/* 264 */             int iz = (int)(this.posZ + Math.sin(curdir + this.dir) * h);
/* 265 */             if (ix != ixlast || iz != izlast) {
/* 266 */               ixlast = ix;
/* 267 */               izlast = iz;
/*     */ 
/*     */               
/* 270 */               if (i == 0) {
/*     */                 
/* 272 */                 Block bid = this.worldObj.getBlock(ix, (int)this.posY + 1 + 1, iz);
/* 273 */                 if (bid == Blocks.red_mushroom || bid == Blocks.brown_mushroom) {
/* 274 */                   FastSetBlock(ix, (int)this.posY + 1 + 1, iz, Blocks.air);
/*     */                 }
/*     */               } 
/* 277 */               FastSetBlock(ix, (int)this.posY - i + 1, iz, Blocks.air);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 283 */       if (this.posX < 0.0D) xoff = -1; 
/* 284 */       if (this.posZ < 0.0D) zoff = -1; 
/* 285 */       this.worldObj.setBlock((int)this.posX + xoff, (int)this.posY, (int)this.posZ + zoff, Blocks.end_stone);
/*     */       
/* 287 */       this.posX = (int)this.myX;
/* 288 */       if (this.myX < 0.0D) {
/* 289 */         this.posX -= 0.5D;
/*     */       } else {
/* 291 */         this.posX += 0.5D;
/*     */       } 
/* 293 */       this.posZ = (int)this.myZ;
/* 294 */       if (this.myZ < 0.0D) {
/* 295 */         this.posZ -= 0.5D;
/*     */       } else {
/* 297 */         this.posZ += 0.5D;
/*     */       } 
/*     */ 
/*     */       
/* 301 */       for (i = 0; i < this.depth; i++) {
/* 302 */         ixlast = izlast = 0; double curdir;
/* 303 */         for (curdir = -3.1415926D; curdir < 3.1415926D; curdir += deltadir) {
/*     */           
/* 305 */           double tradius = this.radius;
/* 306 */           tradius /= (i + 1);
/*     */           double h;
/* 308 */           for (h = 0.75D; h < tradius;) {
/* 309 */             h += deltamag;
/*     */           }
/* 311 */           h -= deltamag * 3.0D;
/* 312 */           if (h < 0.75D) h = 0.75D; 
/* 313 */           for (; h < tradius; h += deltamag) {
/* 314 */             int ix = (int)(this.posX + Math.cos(curdir + this.dir) * h);
/* 315 */             int iz = (int)(this.posZ + Math.sin(curdir + this.dir) * h);
/* 316 */             if (ix != ixlast || iz != izlast) {
/* 317 */               ixlast = ix;
/* 318 */               izlast = iz;
/* 319 */               if (i == 0) {
/* 320 */                 Block bid; if ((bid = this.worldObj.getBlock(ix, (int)this.posY - i + 1, iz)) == Blocks.air) {
/* 321 */                   if (this.worldObj.rand.nextInt(5000) == 1) {
/* 322 */                     this.worldObj.setBlock(ix, (int)this.posY - i + 1, iz, Blocks.lava);
/*     */                   } else {
/* 324 */                     FastSetBlock(ix, (int)this.posY - i + 1, iz, (Block)Blocks.mycelium);
/* 325 */                     if (this.worldObj.rand.nextInt(20) == 1 && 
/* 326 */                       this.worldObj.getBlock(ix, (int)this.posY - i + 2, iz) == Blocks.air) {
/* 327 */                       if (this.worldObj.rand.nextInt(2) == 1) {
/* 328 */                         this.worldObj.setBlock(ix, (int)this.posY - i + 2, iz, (Block)Blocks.brown_mushroom);
/*     */                       } else {
/* 330 */                         this.worldObj.setBlock(ix, (int)this.posY - i + 2, iz, (Block)Blocks.red_mushroom);
/*     */                       }
/*     */                     
/*     */                     }
/*     */                   }
/*     */                 
/* 336 */                 } else if (bid == Blocks.bedrock) {
/* 337 */                   setDead();
/*     */                   
/*     */                   return;
/*     */                 } 
/*     */               } else {
/* 342 */                 Block bid = this.worldObj.getBlock(ix, (int)this.posY - i + 1, iz);
/* 343 */                 if (bid == Blocks.stone) {
/* 344 */                   if (!this.worldObj.isRemote) this.worldObj.createExplosion((Entity)this, ix, this.posY - i + 1.0D, iz, 5.0F, true);
/*     */                 
/*     */                 }
/* 347 */                 else if (this.worldObj.rand.nextInt(10) == 1) {
/* 348 */                   FastSetBlock(ix, (int)this.posY - i + 1, iz, Blocks.diamond_ore);
/*     */                 } else {
/* 350 */                   FastSetBlock(ix, (int)this.posY - i + 1, iz, Blocks.end_stone);
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 357 */       xoff = 0;
/* 358 */       if (this.posX < 0.0D) xoff = -1; 
/* 359 */       zoff = 0;
/* 360 */       if (this.posZ < 0.0D) zoff = -1; 
/* 361 */       this.worldObj.setBlock((int)this.posX + xoff, (int)this.posY, (int)this.posZ + zoff, Blocks.air);
/* 362 */       FastSetBlock((int)this.posX + xoff, (int)this.posY, (int)this.posZ + zoff, Blocks.air);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 368 */     if (this.worldObj.rand.nextInt(2 + 2000 / this.timer) == 1) {
/* 369 */       AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(this.posX - 10.0D, this.posY - 5.0D, this.posZ - 10.0D, this.posX + 10.0D, this.posY + 5.0D, this.posZ + 10.0D);
/* 370 */       List var5 = this.worldObj.getEntitiesWithinAABB(Triffid.class, bb);
/* 371 */       Iterator var2 = var5.iterator();
/* 372 */       if (!var2.hasNext())
/*     */       {
/*     */         
/* 375 */         EntityCreature newent = (EntityCreature)spawnCreature(this.worldObj, "Triffid", this.posX, this.posY + 2.01D, this.posZ);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 382 */     Entity var8 = null;
/* 383 */     var8 = EntityList.createEntityByName(par1, par0World);
/* 384 */     if (var8 != null) {
/*     */ 
/*     */       
/* 387 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 390 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 392 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/* 394 */     return var8;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 399 */     return Item.getItemFromBlock(OreSpawnMain.MyIslandBlock);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void FastSetBlock(int ix, int iy, int iz, Block id) {
/* 406 */     OreSpawnMain.setBlockFast(this.worldObj, ix, iy, iz, id, 0, 3);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Island.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */