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
/*     */ import net.minecraft.entity.monster.EntityMob;
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
/*     */ 
/*     */ public class Brutalfly
/*     */   extends EntityMob
/*     */ {
/*  50 */   private ChunkCoordinates currentFlightTarget = null;
/*  51 */   private int lastX = 0, lastZ = 0, lastY = 0;
/*  52 */   private int stuck_count = 0;
/*  53 */   private int wing_sound = 0;
/*  54 */   private int health_ticker = 100;
/*  55 */   private GenericTargetSorter TargetSorter = null;
/*  56 */   private float moveSpeed = 0.35F;
/*     */   
/*     */   public Brutalfly(World par1World) {
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
/*  74 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Brutalfly_stats.attack);
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
/*  99 */     return OreSpawnMain.Brutalfly_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBrutalflyHealth() {
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
/* 156 */     return OreSpawnMain.Brutalfly_stats.health;
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
/* 186 */       this.health_ticker = 100;
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
/* 204 */     int keep_trying = 30;
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
/* 228 */     if (this.stuck_count > 30 || this.worldObj.rand.nextInt(200) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 9.0F) {
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
/* 250 */         if (this.worldObj.rand.nextInt(2) == 0) xdir = -1; 
/* 251 */         if (this.worldObj.rand.nextInt(2) == 0) zdir = -1; 
/* 252 */         int newz = this.rand.nextInt(20) + 8;
/* 253 */         newz *= zdir;
/* 254 */         int newx = this.rand.nextInt(20) + 8;
/* 255 */         newx *= xdir;
/* 256 */         this.currentFlightTarget.set((int)this.posX + newx, (int)this.posY + this.worldObj.rand.nextInt(7) - 1 - down, (int)this.posZ + newz);
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
/*     */     
/* 268 */     if (this.worldObj.rand.nextInt(6) == 0) {
/*     */       
/* 270 */       EntityPlayer target = null;
/*     */       
/* 272 */       target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(30.0D, 20.0D, 30.0D), (Entity)this);
/* 273 */       if (target != null)
/*     */       {
/* 275 */         if (!target.capabilities.isCreativeMode) {
/*     */           
/* 277 */           if (getEntitySenses().canSee((Entity)target)) {
/*     */             
/* 279 */             this.currentFlightTarget.set((int)target.posX, (int)target.posY + 4, (int)target.posZ);
/* 280 */             if (this.rand.nextInt(shoot) == 0)
/* 281 */               attackWithSomething((EntityLivingBase)target); 
/*     */           } 
/*     */         } else {
/* 284 */           target = null;
/*     */         } 
/*     */       }
/*     */       
/* 288 */       if (target == null && this.worldObj.rand.nextInt(3) == 0) {
/* 289 */         EntityLivingBase e = null;
/* 290 */         e = findSomethingToAttack();
/* 291 */         if (e != null) {
/*     */ 
/*     */           
/* 294 */           this.currentFlightTarget.set((int)e.posX, (int)e.posY + 5, (int)e.posZ);
/* 295 */           if (getDistanceSqToEntity((Entity)e) > 25.0D) {
/* 296 */             if (this.worldObj.rand.nextInt(shoot) == 0) {
/* 297 */               attackWithSomething(e);
/*     */             }
/*     */           } else {
/* 300 */             attackEntityAsMob((Entity)e);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 306 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 307 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 308 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 309 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.30001D;
/* 310 */     this.motionY += (Math.signum(var3) * 0.7D - this.motionY) * 0.20001D;
/* 311 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.30001D;
/* 312 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 313 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 314 */     this.moveForward = 1.0F;
/* 315 */     this.rotationYaw += var8 / 8.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 324 */     return false;
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
/* 342 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 350 */     boolean ret = false;
/* 351 */     Entity e = par1DamageSource.getEntity();
/*     */     
/* 353 */     if (e != null && e instanceof Brutalfly) {
/* 354 */       return false;
/*     */     }
/* 356 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 358 */     if (e != null && this.currentFlightTarget != null)
/*     */     {
/*     */       
/* 361 */       this.currentFlightTarget.set((int)e.posX, (int)e.posY + 2, (int)e.posZ);
/*     */     }
/* 363 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 372 */     super.readEntityFromNBT(par1NBTTagCompound);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 380 */     super.writeEntityToNBT(par1NBTTagCompound);
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
/* 393 */     for (k = -2; k <= 2; k++) {
/*     */       
/* 395 */       for (int j = -2; j <= 2; j++) {
/*     */         
/* 397 */         for (int i = 1; i < 4; i++) {
/*     */           
/* 399 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 400 */           if (bid == Blocks.mob_spawner) {
/* 401 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 402 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 403 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 404 */             if (s != null && 
/* 405 */               s.equals("Brutalfly")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 412 */     if (this.posY < 70.0D) return false;
/*     */     
/* 414 */     if (!isValidLightLevel()) return false; 
/* 415 */     if (this.worldObj.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 419 */     for (k = -4; k < 4; k++) {
/*     */       
/* 421 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 423 */         for (int i = 1; i < 10; i++) {
/*     */           
/* 425 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 426 */           if (bid != Blocks.air) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 434 */     Brutalfly target = null;
/* 435 */     target = (Brutalfly)this.worldObj.findNearestEntityWithinAABB(Brutalfly.class, this.boundingBox.expand(64.0D, 32.0D, 64.0D), (Entity)this);
/* 436 */     if (target != null)
/*     */     {
/* 438 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 442 */     return true;
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
/* 454 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), new ItemStack(index, par1, 0));
/*     */     
/* 456 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 463 */     for (int i = 0; i < 20; i++) {
/* 464 */       float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
/* 465 */       float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
/* 466 */       float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
/* 467 */       this.worldObj.spawnParticle("largeexplode", this.posX + var1, this.posY + 2.0D + var2, this.posZ + var3, 0.0D, 0.0D, 0.0D);
/*     */     } 
/*     */     int var4;
/* 470 */     for (var4 = 0; var4 < 53; var4++) {
/* 471 */       dropItemRand(Items.gold_nugget, 1);
/*     */     }
/*     */     
/* 474 */     for (var4 = 0; var4 < 20; var4++) {
/* 475 */       spawnCreature(this.worldObj, "Butterfly", this.posX + 0.5D, this.posY + 1.0D, this.posZ + 0.5D);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 486 */     Entity var8 = null;
/*     */     
/* 488 */     if (par0World == null) return null;
/*     */ 
/*     */     
/* 491 */     var8 = EntityList.createEntityByName(par1, par0World);
/*     */     
/* 493 */     if (var8 != null) {
/*     */ 
/*     */       
/* 496 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 499 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 501 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     
/* 504 */     return var8;
/*     */   }
/*     */   
/*     */   private void attackWithSomething(EntityLivingBase par1) {
/* 508 */     double xzoff = 2.25D;
/*     */     
/* 510 */     double yoff = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 518 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 519 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*     */     
/* 521 */     if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
/* 522 */       EntitySmallFireball sf = new EntitySmallFireball(this.worldObj, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 523 */       sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 524 */       sf.setPosition(cx, this.posY + yoff, cz);
/* 525 */       this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 526 */       this.worldObj.spawnEntityInWorld((Entity)sf);
/* 527 */     } else if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
/* 528 */       if (this.worldObj.rand.nextInt(2) == 0) {
/* 529 */         EntitySmallFireball sf = new EntitySmallFireball(this.worldObj, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 530 */         sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 531 */         sf.setPosition(cx, this.posY + yoff, cz);
/* 532 */         this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 533 */         this.worldObj.spawnEntityInWorld((Entity)sf);
/*     */       } else {
/* 535 */         BetterFireball bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 536 */         bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 537 */         bf.setPosition(cx, this.posY + yoff, cz);
/* 538 */         bf.setNotMe();
/* 539 */         this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 540 */         this.worldObj.spawnEntityInWorld((Entity)bf);
/*     */       } 
/*     */     } else {
/* 543 */       BetterFireball bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 544 */       bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 545 */       bf.setPosition(cx, this.posY + yoff, cz);
/* 546 */       bf.setNotMe();
/* 547 */       this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 548 */       this.worldObj.spawnEntityInWorld((Entity)bf);
/*     */     } 
/* 550 */     if (getHealth() < mygetMaxHealth()) {
/* 551 */       heal(1.0F);
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
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 563 */     if (par1EntityLiving == null)
/*     */     {
/* 565 */       return false;
/*     */     }
/* 567 */     if (par1EntityLiving == this)
/*     */     {
/* 569 */       return false;
/*     */     }
/* 571 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 573 */       return false;
/*     */     }
/*     */     
/* 576 */     if (par1EntityLiving instanceof Brutalfly)
/*     */     {
/* 578 */       return false;
/*     */     }
/* 580 */     if (par1EntityLiving instanceof Mothra)
/*     */     {
/* 582 */       return false;
/*     */     }
/* 584 */     if (par1EntityLiving instanceof Vortex)
/*     */     {
/* 586 */       return false;
/*     */     }
/*     */     
/* 589 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 591 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/* 593 */       return false;
/*     */     }
/*     */     
/* 596 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 598 */       return true;
/*     */     }
/*     */     
/* 601 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 603 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 604 */       if (p.capabilities.isCreativeMode == true) {
/* 605 */         return false;
/*     */       }
/* 607 */       return true;
/*     */     } 
/* 609 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 614 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 615 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(25.0D, 20.0D, 25.0D));
/* 616 */     Collections.sort(var5, this.TargetSorter);
/* 617 */     Iterator<?> var2 = var5.iterator();
/* 618 */     Entity var3 = null;
/* 619 */     EntityLivingBase var4 = null;
/*     */     
/* 621 */     while (var2.hasNext()) {
/*     */       
/* 623 */       var3 = (Entity)var2.next();
/* 624 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 626 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 628 */         return var4;
/*     */       }
/*     */     } 
/* 631 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Brutalfly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */