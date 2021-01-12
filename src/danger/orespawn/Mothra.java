/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.IMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntitySmallFireball;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.EnumDifficulty;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Mothra
/*     */   extends EntityButterfly
/*     */   implements IMob
/*     */ {
/*  50 */   private ChunkCoordinates currentFlightTarget = null;
/*  51 */   private int lastX = 0, lastZ = 0, lastY = 0;
/*  52 */   private int stuck_count = 0;
/*  53 */   private int wing_sound = 0;
/*  54 */   private int health_ticker = 100;
/*  55 */   private GenericTargetSorter TargetSorter = null;
/*  56 */   private float moveSpeed = 0.35F;
/*     */   
/*     */   public Mothra(World par1World) {
/*  59 */     super(par1World);
/*  60 */     setSize(5.0F, 2.0F);
/*  61 */     getNavigator().setAvoidsWater(true);
/*  62 */     this.experienceValue = 100;
/*  63 */     this.isImmuneToFire = true;
/*  64 */     this.fireResistance = 500;
/*  65 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  71 */     super.applyEntityAttributes();
/*  72 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  73 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  74 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Mothra_stats.attack);
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  78 */     if (isNoDespawnRequired()) return false; 
/*  79 */     return true;
/*     */   }
/*     */   
/*     */   protected void entityInit() {
/*  83 */     super.entityInit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/*  91 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/*  99 */     return OreSpawnMain.Mothra_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMothraHealth() {
/* 106 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 113 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 120 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 127 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 134 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 141 */     return "random.explode";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 148 */     return true;
/*     */   }
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   protected void collideWithNearbyEntities() {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 156 */     return OreSpawnMain.Mothra_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 163 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 171 */     super.onUpdate();
/*     */     
/* 173 */     this.motionY *= 0.6D;
/*     */     
/* 175 */     this.wing_sound++;
/* 176 */     if (this.wing_sound > 30) {
/*     */       
/* 178 */       if (!this.worldObj.isRemote) this.worldObj.playSoundAtEntity((Entity)this, "orespawn:MothraWings", 1.0F, 1.0F); 
/* 179 */       this.wing_sound = 0;
/*     */     } 
/*     */     
/* 182 */     this.health_ticker--;
/* 183 */     if (this.health_ticker <= 0) {
/* 184 */       if (getHealth() < mygetMaxHealth())
/* 185 */         heal(1.0F); 
/* 186 */       this.health_ticker = 200;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 195 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 201 */     int xdir = 1;
/* 202 */     int zdir = 1;
/*     */     
/* 204 */     int keep_trying = 50;
/*     */     
/* 206 */     int shoot = 3;
/*     */     
/* 208 */     if (this.isDead)
/* 209 */       return;  super.updateAITasks();
/*     */     
/* 211 */     if (this.lastX == (int)this.posX && this.lastY == (int)this.posY && this.lastZ == (int)this.posZ) {
/*     */       
/* 213 */       this.stuck_count++;
/*     */     } else {
/* 215 */       this.stuck_count = 0;
/* 216 */       this.lastX = (int)this.posX;
/* 217 */       this.lastY = (int)this.posY;
/* 218 */       this.lastZ = (int)this.posZ;
/*     */     } 
/*     */     
/* 221 */     if (this.worldObj.difficultySetting == EnumDifficulty.HARD) shoot = 2;
/*     */ 
/*     */     
/* 224 */     if (this.currentFlightTarget == null) {
/* 225 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */     
/* 228 */     if (this.stuck_count > 50 || this.worldObj.rand.nextInt(300) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 9.0F) {
/*     */ 
/*     */       
/* 231 */       int down = 0;
/*     */       
/* 233 */       int dist = 20;
/* 234 */       for (int i = -5; i <= 5; i += 5) {
/* 235 */         for (int j = -5; j <= 5; j += 5) {
/* 236 */           for (int k = 1; k < 20; k++) {
/* 237 */             Block block = this.worldObj.getBlock((int)this.posX + j, (int)this.posY - k, (int)this.posZ + i);
/* 238 */             if (block != Blocks.air) {
/* 239 */               if (k < dist) dist = k; 
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 245 */       if (dist > 10) down = dist - 10 + 1;
/*     */       
/* 247 */       Block bid = Blocks.stone;
/* 248 */       while (bid != Blocks.air && keep_trying != 0) {
/* 249 */         xdir = 1; zdir = 1;
/* 250 */         if (this.rand.nextInt(2) == 0) xdir = -1; 
/* 251 */         if (this.rand.nextInt(2) == 0) zdir = -1; 
/* 252 */         int newz = this.rand.nextInt(20) + 8;
/* 253 */         newz *= zdir;
/* 254 */         int newx = this.rand.nextInt(20) + 8;
/* 255 */         newx *= xdir;
/* 256 */         this.currentFlightTarget.set((int)this.posX + newx, (int)this.posY + this.rand.nextInt(7) - 1 - down, (int)this.posZ + newz);
/* 257 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 258 */         if (bid == Blocks.air && 
/* 259 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 260 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 263 */         keep_trying--;
/*     */       } 
/* 265 */       this.stuck_count = 0;
/*     */     }
/* 267 */     else if (this.worldObj.rand.nextInt(10) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && OreSpawnMain.MothraPeaceful == 0) {
/*     */       
/* 269 */       EntityPlayer target = null;
/*     */       
/* 271 */       target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(25.0D, 20.0D, 25.0D), (Entity)this);
/* 272 */       if (target != null)
/*     */       {
/* 274 */         if (!target.capabilities.isCreativeMode) {
/*     */           
/* 276 */           if (getEntitySenses().canSee((Entity)target)) {
/*     */             
/* 278 */             this.currentFlightTarget.set((int)target.posX, (int)target.posY + 4, (int)target.posZ);
/* 279 */             if (this.rand.nextInt(shoot) == 0)
/* 280 */               attackWithSomething((EntityLivingBase)target); 
/*     */           } 
/*     */         } else {
/* 283 */           target = null;
/*     */         } 
/*     */       }
/*     */       
/* 287 */       if (target == null && this.worldObj.rand.nextInt(3) == 0) {
/* 288 */         EntityLivingBase e = null;
/* 289 */         e = findSomethingToAttack();
/* 290 */         if (e != null) {
/*     */ 
/*     */           
/* 293 */           this.currentFlightTarget.set((int)e.posX, (int)e.posY + 5, (int)e.posZ);
/* 294 */           if (this.worldObj.rand.nextInt(shoot) == 0) {
/* 295 */             attackWithSomething(e);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 301 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 302 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 303 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 304 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.30001D;
/* 305 */     this.motionY += (Math.signum(var3) * 0.7D - this.motionY) * 0.20001D;
/* 306 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.30001D;
/* 307 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 308 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 309 */     this.moveForward = 1.0F;
/* 310 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 319 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFallState(double par1, boolean par3) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 337 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 345 */     boolean ret = false;
/* 346 */     Entity e = par1DamageSource.getEntity();
/*     */     
/* 348 */     if (e != null && e instanceof Mothra) {
/* 349 */       return false;
/*     */     }
/* 351 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 353 */     if (e != null && this.currentFlightTarget != null)
/*     */     {
/*     */       
/* 356 */       this.currentFlightTarget.set((int)e.posX, (int)e.posY + 2, (int)e.posZ);
/*     */     }
/* 358 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 367 */     super.readEntityFromNBT(par1NBTTagCompound);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 375 */     super.writeEntityToNBT(par1NBTTagCompound);
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
/*     */   public boolean getCanSpawnHere() {
/*     */     int k;
/* 388 */     for (k = -2; k <= 2; k++) {
/*     */       
/* 390 */       for (int j = -2; j <= 2; j++) {
/*     */         
/* 392 */         for (int i = 1; i < 4; i++) {
/*     */           
/* 394 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 395 */           if (bid == Blocks.mob_spawner) {
/* 396 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 397 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 398 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 399 */             if (s != null && 
/* 400 */               s.equals("Mothra")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 407 */     if (this.posY < 70.0D) return false;
/*     */ 
/*     */     
/* 410 */     if (this.worldObj.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 414 */     for (k = -4; k < 4; k++) {
/*     */       
/* 416 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 418 */         for (int i = 1; i < 10; i++) {
/*     */           
/* 420 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 421 */           if (bid != Blocks.air) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 429 */     Mothra target = null;
/* 430 */     target = (Mothra)this.worldObj.findNearestEntityWithinAABB(Mothra.class, this.boundingBox.expand(64.0D, 32.0D, 64.0D), (Entity)this);
/* 431 */     if (target != null)
/*     */     {
/* 433 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 437 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 449 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), new ItemStack(index, par1, 0));
/*     */     
/* 451 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 458 */     dropItemRand(Items.item_frame, 1);
/*     */     
/* 460 */     for (int i = 0; i < 20; i++) {
/* 461 */       float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
/* 462 */       float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
/* 463 */       float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
/* 464 */       this.worldObj.spawnParticle("largeexplode", this.posX + var1, this.posY + 2.0D + var2, this.posZ + var3, 0.0D, 0.0D, 0.0D);
/*     */     } 
/*     */     int var4;
/* 467 */     for (var4 = 0; var4 < 53; var4++) {
/* 468 */       dropItemRand(Items.gold_nugget, 1);
/*     */     }
/*     */     
/* 471 */     for (var4 = 0; var4 < 25; var4++) {
/* 472 */       dropItemRand(OreSpawnMain.MyMothScale, 1);
/*     */     }
/*     */     
/* 475 */     for (var4 = 0; var4 < 3; var4++) {
/* 476 */       dropItemRand(Items.blaze_rod, 1);
/*     */     }
/*     */     
/* 479 */     dropItemRand(Items.nether_star, 1);
/*     */     
/* 481 */     for (var4 = 0; var4 < 20; var4++) {
/* 482 */       spawnCreature(this.worldObj, "Moth", this.posX + 0.5D, this.posY + 1.0D, this.posZ + 0.5D);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 501 */     Entity var8 = null;
/*     */     
/* 503 */     if (par0World == null) return null;
/*     */ 
/*     */     
/* 506 */     var8 = EntityList.createEntityByName(par1, par0World);
/*     */     
/* 508 */     if (var8 != null) {
/*     */ 
/*     */       
/* 511 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 514 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 516 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     
/* 519 */     return var8;
/*     */   }
/*     */   
/*     */   private void attackWithSomething(EntityLivingBase par1) {
/* 523 */     double xzoff = 2.25D;
/*     */     
/* 525 */     double yoff = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 530 */     if (OreSpawnMain.MothraPeaceful != 0)
/* 531 */       return;  if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL)
/*     */       return; 
/* 533 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 534 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*     */     
/* 536 */     if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
/* 537 */       EntitySmallFireball sf = new EntitySmallFireball(this.worldObj, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 538 */       sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 539 */       sf.setPosition(cx, this.posY + yoff, cz);
/* 540 */       this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 541 */       this.worldObj.spawnEntityInWorld((Entity)sf);
/* 542 */     } else if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
/* 543 */       if (this.worldObj.rand.nextInt(2) == 0) {
/* 544 */         EntitySmallFireball sf = new EntitySmallFireball(this.worldObj, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 545 */         sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 546 */         sf.setPosition(cx, this.posY + yoff, cz);
/* 547 */         this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 548 */         this.worldObj.spawnEntityInWorld((Entity)sf);
/*     */       } else {
/* 550 */         BetterFireball bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 551 */         bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 552 */         bf.setPosition(cx, this.posY + yoff, cz);
/* 553 */         bf.setNotMe();
/* 554 */         this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 555 */         this.worldObj.spawnEntityInWorld((Entity)bf);
/*     */       } 
/*     */     } else {
/* 558 */       BetterFireball bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 559 */       bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 560 */       bf.setPosition(cx, this.posY + yoff, cz);
/* 561 */       bf.setNotMe();
/* 562 */       this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 563 */       this.worldObj.spawnEntityInWorld((Entity)bf);
/*     */     } 
/* 565 */     if (getHealth() < mygetMaxHealth()) {
/* 566 */       heal(1.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 576 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*     */     
/* 578 */     if (par1EntityLiving == null)
/*     */     {
/* 580 */       return false;
/*     */     }
/* 582 */     if (par1EntityLiving == this)
/*     */     {
/* 584 */       return false;
/*     */     }
/* 586 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 588 */       return false;
/*     */     }
/*     */     
/* 591 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 593 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/* 595 */       return false;
/*     */     }
/* 597 */     if (par1EntityLiving instanceof Mothra)
/*     */     {
/* 599 */       return false;
/*     */     }
/* 601 */     if (par1EntityLiving instanceof Brutalfly)
/*     */     {
/* 603 */       return false;
/*     */     }
/* 605 */     if (par1EntityLiving instanceof Vortex)
/*     */     {
/* 607 */       return false;
/*     */     }
/*     */     
/* 610 */     if (par1EntityLiving instanceof VelocityRaptor)
/*     */     {
/* 612 */       return false;
/*     */     }
/* 614 */     if (par1EntityLiving instanceof Cryolophosaurus)
/*     */     {
/* 616 */       return false;
/*     */     }
/*     */     
/* 619 */     if (par1EntityLiving instanceof TerribleTerror)
/*     */     {
/* 621 */       return false;
/*     */     }
/* 623 */     if (par1EntityLiving instanceof LurkingTerror)
/*     */     {
/* 625 */       return false;
/*     */     }
/* 627 */     if (par1EntityLiving instanceof CloudShark)
/*     */     {
/* 629 */       return false;
/*     */     }
/* 631 */     if (par1EntityLiving instanceof Rotator)
/*     */     {
/* 633 */       return false;
/*     */     }
/* 635 */     if (par1EntityLiving instanceof Bee)
/*     */     {
/* 637 */       return false;
/*     */     }
/* 639 */     if (par1EntityLiving instanceof Mantis)
/*     */     {
/* 641 */       return false;
/*     */     }
/*     */     
/* 644 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 646 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 647 */       if (p.capabilities.isCreativeMode == true) {
/* 648 */         return false;
/*     */       }
/*     */     } 
/* 651 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 656 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 657 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(15.0D, 20.0D, 15.0D));
/* 658 */     Collections.sort(var5, this.TargetSorter);
/* 659 */     Iterator<?> var2 = var5.iterator();
/* 660 */     Entity var3 = null;
/* 661 */     EntityLivingBase var4 = null;
/*     */     
/* 663 */     while (var2.hasNext()) {
/*     */       
/* 665 */       var3 = (Entity)var2.next();
/* 666 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 668 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 670 */         return var4;
/*     */       }
/*     */     } 
/* 673 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Mothra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */