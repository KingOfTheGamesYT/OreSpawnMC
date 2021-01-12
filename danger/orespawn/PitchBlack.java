/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.boss.EntityDragon;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
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
/*     */ public class PitchBlack
/*     */   extends EntityMob
/*     */ {
/*  64 */   private ChunkCoordinates currentFlightTarget = null;
/*  65 */   private GenericTargetSorter TargetSorter = null;
/*  66 */   private RenderInfo renderdata = new RenderInfo();
/*  67 */   private float MyMoveSpeed = 0.2F;
/*  68 */   private int damage_ticker = 0;
/*  69 */   private int wing_sound = 0;
/*     */   
/*     */   public PitchBlack(World par1World) {
/*  72 */     super(par1World);
/*  73 */     setSize(2.0F, 3.0F);
/*  74 */     getNavigator().setAvoidsWater(false);
/*  75 */     this.experienceValue = 200;
/*  76 */     this.isImmuneToFire = false;
/*  77 */     this.fireResistance = 25;
/*  78 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  79 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  80 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  81 */     this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  82 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F));
/*  83 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  89 */     super.applyEntityAttributes();
/*  90 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  91 */     this.MyMoveSpeed = 0.2F;
/*  92 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((this.MyMoveSpeed + 0.1F * getPitchBlackScale()));
/*  93 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((getPitchBlackScale() * OreSpawnMain.PitchBlack_stats.attack));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  99 */     super.entityInit();
/* 100 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/* 101 */     this.dataWatcher.addObject(21, Byte.valueOf((byte)0));
/* 102 */     this.dataWatcher.addObject(22, Integer.valueOf(0));
/* 103 */     if (this.renderdata == null) {
/* 104 */       this.renderdata = new RenderInfo();
/*     */     }
/* 106 */     this.renderdata.rf1 = 0.0F;
/* 107 */     this.renderdata.rf2 = 0.0F;
/* 108 */     this.renderdata.rf3 = 0.0F;
/* 109 */     this.renderdata.rf4 = 0.0F;
/* 110 */     this.renderdata.ri1 = 0;
/* 111 */     this.renderdata.ri2 = 0;
/* 112 */     this.renderdata.ri3 = 0;
/* 113 */     this.renderdata.ri4 = 0;
/* 114 */     float t = 0.5F;
/* 115 */     if (this.worldObj != null) {
/* 116 */       if (this.worldObj.rand.nextInt(4) == 1) t = 1.0F; 
/* 117 */       if (this.worldObj.rand.nextInt(8) == 2) t = 2.0F; 
/* 118 */       if (this.worldObj.rand.nextInt(32) == 3) t = 3.0F; 
/* 119 */       if (this.worldObj.rand.nextInt(64) == 4) t = 4.0F; 
/*     */     } else {
/* 121 */       if (OreSpawnMain.OreSpawnRand.nextInt(4) == 1) t = 1.0F; 
/* 122 */       if (OreSpawnMain.OreSpawnRand.nextInt(8) == 2) t = 2.0F; 
/* 123 */       if (OreSpawnMain.OreSpawnRand.nextInt(32) == 3) t = 3.0F; 
/* 124 */       if (OreSpawnMain.OreSpawnRand.nextInt(64) == 4) t = 4.0F; 
/*     */     } 
/* 126 */     if (OreSpawnMain.NightmareSize == 1) t = 0.5F; 
/* 127 */     if (OreSpawnMain.NightmareSize == 2) t = 1.0F; 
/* 128 */     if (OreSpawnMain.NightmareSize == 3) t = 2.0F; 
/* 129 */     if (OreSpawnMain.NightmareSize == 4) t = 3.0F; 
/* 130 */     if (OreSpawnMain.NightmareSize == 5) t = 4.0F; 
/* 131 */     setPitchBlackScale(t);
/* 132 */     this.experienceValue = (int)(100.0F * t);
/* 133 */     this.fireResistance = (int)(25.0F * t);
/* 134 */     setSize(2.5F * getPitchBlackScale(), 3.5F * getPitchBlackScale());
/*     */   }
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 139 */     super.readEntityFromNBT(par1NBTTagCompound);
/* 140 */     setPitchBlackScale(par1NBTTagCompound.getFloat("Fscale"));
/* 141 */     setSize(2.5F * getPitchBlackScale(), 3.5F * getPitchBlackScale());
/* 142 */     this.experienceValue = (int)(100.0F * getPitchBlackScale());
/* 143 */     this.fireResistance = (int)(25.0F * getPitchBlackScale());
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 148 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 149 */     par1NBTTagCompound.setFloat("Fscale", getPitchBlackScale());
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 154 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 159 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getActivity() {
/* 164 */     return this.dataWatcher.getWatchableObjectByte(21);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setActivity(int par1) {
/* 169 */     this.dataWatcher.updateObject(21, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getPitchBlackScale() {
/* 175 */     int i = this.dataWatcher.getWatchableObjectInt(22);
/* 176 */     float f = i;
/* 177 */     return f / 10.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPitchBlackScale(float par1) {
/* 182 */     float f = par1 * 10.0001F;
/* 183 */     int i = (int)f;
/* 184 */     this.dataWatcher.updateObject(22, Integer.valueOf(i));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 192 */     return OreSpawnMain.PitchBlack_stats.defense + (int)(2.0F * getPitchBlackScale());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 199 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 204 */     this.renderdata.rf1 = r.rf1;
/* 205 */     this.renderdata.rf2 = r.rf2;
/* 206 */     this.renderdata.rf3 = r.rf3;
/* 207 */     this.renderdata.rf4 = r.rf4;
/* 208 */     this.renderdata.ri1 = r.ri1;
/* 209 */     this.renderdata.ri2 = r.ri2;
/* 210 */     this.renderdata.ri3 = r.ri3;
/* 211 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 216 */     if (isNoDespawnRequired()) return false; 
/* 217 */     if (!this.worldObj.isDaytime()) return false; 
/* 218 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 225 */     return 0.75F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 232 */     return 1.0F - 0.7F * 4.0F / getPitchBlackScale();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 239 */     if (this.worldObj.rand.nextInt(5) != 2) return null; 
/* 240 */     return "orespawn:pitchblack_living";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 247 */     return "orespawn:pitchblack_hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 254 */     return "orespawn:pitchblack_dead";
/*     */   }
/*     */   
/*     */   public int mygetMaxHealth() {
/* 258 */     return (int)(OreSpawnMain.PitchBlack_stats.health * getPitchBlackScale());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 265 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 273 */     this.MyMoveSpeed = 0.2F;
/* 274 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((this.MyMoveSpeed + 0.1F * getPitchBlackScale()));
/* 275 */     super.onUpdate();
/* 276 */     setSize(2.5F * getPitchBlackScale(), 3.5F * getPitchBlackScale());
/*     */     
/* 278 */     this.wing_sound++;
/* 279 */     if (this.wing_sound > 20) {
/*     */       
/* 281 */       if (!this.worldObj.isRemote) this.worldObj.playSoundAtEntity((Entity)this, "orespawn:MothraWings", 1.0F, 1.0F); 
/* 282 */       this.wing_sound = 0;
/*     */     } 
/*     */     
/* 285 */     this.motionY *= 0.6D;
/* 286 */     if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(250) == 1) {
/* 287 */       heal(1.0F + getPitchBlackScale());
/* 288 */       if (this.worldObj.rand.nextInt(5) == 0) {
/*     */ 
/*     */         
/* 291 */         Block bid = Blocks.air;
/* 292 */         if (this.posY > 10.0D)
/* 293 */         { for (int i = 0; i < 10; i++) {
/* 294 */             bid = this.worldObj.getBlock((int)this.posX, (int)this.posY - i, (int)this.posZ);
/* 295 */             if (bid != Blocks.air)
/*     */               break; 
/*     */           }  }
/* 298 */         else { bid = Blocks.stone; }
/*     */         
/* 300 */         if (bid != Blocks.air) {
/*     */           
/* 302 */           Entity e = null;
/* 303 */           e = findSomethingToAttack();
/* 304 */           if (e == null) {
/* 305 */             setActivity(0);
/*     */           }
/*     */         } 
/*     */       } else {
/* 309 */         setActivity(1);
/* 310 */         getNavigator().setPath(null, 0.0D);
/*     */       } 
/*     */     } 
/*     */     
/* 314 */     if (getActivity() == 0 && this.worldObj.rand.nextInt(10) == 1) {
/* 315 */       Entity e = null;
/* 316 */       e = findSomethingToAttack();
/* 317 */       if (e != null) {
/* 318 */         setActivity(1);
/* 319 */         getNavigator().setPath(null, 0.0D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 327 */     boolean var4 = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 333 */     if (par1Entity != null && par1Entity instanceof EntityDragon) {
/* 334 */       EntityDragon dr = (EntityDragon)par1Entity;
/* 335 */       DamageSource var21 = null;
/* 336 */       var21 = DamageSource.setExplosionSource(null);
/* 337 */       var21.setExplosion();
/* 338 */       if (this.worldObj.rand.nextInt(8) == 1) {
/* 339 */         dr.attackEntityFromPart(dr.dragonPartHead, var21, OreSpawnMain.PitchBlack_stats.attack * getPitchBlackScale());
/*     */       } else {
/* 341 */         dr.attackEntityFromPart(dr.dragonPartBody, var21, OreSpawnMain.PitchBlack_stats.attack * getPitchBlackScale());
/*     */       } 
/* 343 */       var4 = true;
/*     */     } else {
/* 345 */       var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), OreSpawnMain.PitchBlack_stats.attack * getPitchBlackScale());
/* 346 */       if (var4 && par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 348 */         double ks = 1.15D * getPitchBlackScale();
/* 349 */         double inair = 0.08D * getPitchBlackScale();
/* 350 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 351 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 352 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/*     */     } 
/* 355 */     return var4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 363 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 369 */     int xdir = 1;
/* 370 */     int zdir = 1;
/*     */     
/* 372 */     int keep_trying = 50;
/*     */ 
/*     */ 
/*     */     
/* 376 */     if (this.damage_ticker > 0) this.damage_ticker--;
/*     */     
/* 378 */     if (getActivity() == 0) {
/* 379 */       super.updateAITasks();
/*     */       return;
/*     */     } 
/* 382 */     if (this.isDead) {
/*     */       return;
/*     */     }
/* 385 */     if (this.currentFlightTarget == null) {
/* 386 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/* 388 */     if (getActivity() == 0) {
/*     */       return;
/*     */     }
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
/* 401 */     if (this.rand.nextInt(150) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*     */       
/* 403 */       Block bid = Blocks.stone;
/* 404 */       while (bid != Blocks.air && keep_trying > 0) {
/* 405 */         zdir = this.rand.nextInt(20) + 5 * (int)getPitchBlackScale();
/* 406 */         xdir = this.rand.nextInt(20) + 5 * (int)getPitchBlackScale();
/* 407 */         if (this.rand.nextInt(2) == 0) zdir = -zdir; 
/* 408 */         if (this.rand.nextInt(2) == 0) xdir = -xdir; 
/* 409 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(11) - 5, (int)this.posZ + zdir);
/* 410 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 411 */         if (bid == Blocks.air && 
/* 412 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 413 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 416 */         keep_trying--;
/*     */       }
/*     */     
/* 419 */     } else if (this.rand.nextInt(8) == 0) {
/*     */ 
/*     */       
/* 422 */       Entity e = null;
/*     */       
/* 424 */       e = findSomethingToAttack();
/* 425 */       if (e != null) {
/*     */         
/* 427 */         double d1 = 5.0D + (e.width / 2.0F);
/* 428 */         d1 += getPitchBlackScale();
/* 429 */         d1 *= d1;
/* 430 */         setAttacking(1);
/*     */         
/* 432 */         if (e instanceof EntityDragon && 
/* 433 */           d1 < 100.0D) d1 = 100.0D;
/*     */ 
/*     */         
/* 436 */         if (e instanceof Godzilla && 
/* 437 */           d1 < 100.0D) d1 = 100.0D;
/*     */ 
/*     */         
/* 440 */         if (e instanceof GodzillaHead && 
/* 441 */           d1 < 100.0D) d1 = 100.0D;
/*     */ 
/*     */         
/* 444 */         this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 2.0D), (int)e.posZ);
/* 445 */         if (getDistanceSqToEntity(e) < d1) {
/* 446 */           attackEntityAsMob(e);
/*     */         }
/*     */       } else {
/*     */         
/* 450 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */     
/* 454 */     double var1 = this.currentFlightTarget.posX + 0.4D - this.posX;
/* 455 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 456 */     double var5 = this.currentFlightTarget.posZ + 0.4D - this.posZ;
/* 457 */     double myspeed = (0.5F + getPitchBlackScale() / 10.0F);
/* 458 */     this.motionX += (Math.signum(var1) * myspeed - this.motionX) * 0.33D;
/* 459 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.20000000149011612D;
/* 460 */     this.motionZ += (Math.signum(var5) * myspeed - this.motionZ) * 0.33D;
/* 461 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 462 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 463 */     this.moveForward = 0.1F + (float)myspeed;
/* 464 */     this.rotationYaw += var8 / 5.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 473 */     return true;
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
/* 491 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 499 */     boolean ret = false;
/*     */     
/* 501 */     if (this.damage_ticker > 0) return ret; 
/* 502 */     this.damage_ticker = 20;
/* 503 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/* 504 */     Entity e = par1DamageSource.getEntity();
/* 505 */     if (e != null && this.currentFlightTarget != null)
/*     */     {
/* 507 */       this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 2.0D), (int)e.posZ);
/*     */     }
/* 509 */     setActivity(1);
/* 510 */     getNavigator().setPath(null, 0.0D);
/* 511 */     return ret;
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
/* 524 */     for (k = -3; k < 3; k++) {
/*     */       
/* 526 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 528 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 530 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 531 */           if (bid == Blocks.mob_spawner) {
/* 532 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 533 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 534 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 535 */             if (s != null && 
/* 536 */               s.equals("Nightmare")) {
/* 537 */               Float t = Float.valueOf(getPitchBlackScale());
/* 538 */               if (t.floatValue() > 1.0F) t = Float.valueOf(1.0F); 
/* 539 */               setPitchBlackScale(t.floatValue());
/* 540 */               return true;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 547 */     if (!isValidLightLevel()) return false; 
/* 548 */     if (this.worldObj.isDaytime()) return false;
/*     */     
/* 550 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID6) {
/* 551 */       PitchBlack target = null;
/* 552 */       target = (PitchBlack)this.worldObj.findNearestEntityWithinAABB(PitchBlack.class, this.boundingBox.expand(16.0D, 16.0D, 16.0D), (Entity)this);
/* 553 */       if (target != null)
/*     */       {
/* 555 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 560 */     if (getPitchBlackScale() < 1.1F) return true; 
/* 561 */     int ix = 1;
/* 562 */     if (getPitchBlackScale() > 3.1F) ix = 2; 
/* 563 */     int iy = ix * 3;
/* 564 */     for (k = -ix; k <= ix; k++) {
/*     */       
/* 566 */       for (int j = -ix; j <= ix; j++) {
/*     */         
/* 568 */         for (int i = 1; i <= iy; i++) {
/*     */           
/* 570 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 571 */           if (bid != Blocks.air) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 575 */     return true;
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
/* 586 */     if (par1EntityLiving == null)
/*     */     {
/* 588 */       return false;
/*     */     }
/* 590 */     if (par1EntityLiving == this)
/*     */     {
/* 592 */       return false;
/*     */     }
/* 594 */     if (!(par1EntityLiving instanceof EntityLivingBase))
/*     */     {
/* 596 */       return false;
/*     */     }
/* 598 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 601 */       return false;
/*     */     }
/*     */     
/* 604 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 606 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 609 */       return false;
/*     */     }
/* 611 */     if (par1EntityLiving instanceof PitchBlack)
/*     */     {
/* 613 */       return false;
/*     */     }
/*     */     
/* 616 */     if (par1EntityLiving instanceof EnderReaper)
/*     */     {
/* 618 */       return false;
/*     */     }
/* 620 */     if (par1EntityLiving instanceof LeafMonster)
/*     */     {
/* 622 */       return false;
/*     */     }
/* 624 */     if (par1EntityLiving instanceof TerribleTerror)
/*     */     {
/* 626 */       return false;
/*     */     }
/* 628 */     if (par1EntityLiving instanceof LurkingTerror)
/*     */     {
/* 630 */       return false;
/*     */     }
/* 632 */     if (par1EntityLiving instanceof CreepingHorror)
/*     */     {
/* 634 */       return false;
/*     */     }
/*     */     
/* 637 */     if (par1EntityLiving instanceof Island)
/*     */     {
/* 639 */       return false;
/*     */     }
/* 641 */     if (par1EntityLiving instanceof IslandToo)
/*     */     {
/* 643 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 647 */     if (par1EntityLiving instanceof Triffid)
/*     */     {
/* 649 */       return false;
/*     */     }
/* 651 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 653 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 654 */       if (p.capabilities.isCreativeMode == true) {
/* 655 */         return false;
/*     */       }
/*     */     } 
/* 658 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private Entity findSomethingToAttack() {
/* 663 */     if (OreSpawnMain.PlayNicely != 0) return null;
/*     */     
/* 665 */     double d1 = 16.0D + (getPitchBlackScale() * 6.0F);
/* 666 */     double d2 = 10.0D + (getPitchBlackScale() * 4.0F);
/* 667 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(d1, d2, d1));
/* 668 */     Collections.sort(var5, this.TargetSorter);
/* 669 */     Iterator<?> var2 = var5.iterator();
/* 670 */     EntityLivingBase var3 = null;
/*     */     
/* 672 */     while (var2.hasNext()) {
/*     */       
/* 674 */       var3 = (EntityLivingBase)var2.next();
/*     */       
/* 676 */       if (isSuitableTarget(var3, false))
/*     */       {
/* 678 */         return (Entity)var3;
/*     */       }
/*     */     } 
/* 681 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 692 */     return OreSpawnMain.MyNightmareScale;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 697 */     EntityItem var3 = null;
/* 698 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 700 */     var3 = new EntityItem(this.worldObj, this.posX + (OreSpawnMain.OreSpawnRand.nextInt(5) * getPitchBlackScale()) - (OreSpawnMain.OreSpawnRand.nextInt(5) * getPitchBlackScale()), this.posY + 1.0D, this.posZ + (OreSpawnMain.OreSpawnRand.nextInt(5) * getPitchBlackScale()) - (OreSpawnMain.OreSpawnRand.nextInt(5) * getPitchBlackScale()), is);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 705 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 706 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 714 */     int i = 3 + this.worldObj.rand.nextInt(2 + (int)(5.0F * getPitchBlackScale())); int var4;
/* 715 */     for (var4 = 0; var4 < i; var4++) {
/* 716 */       dropItemRand(Items.rotten_flesh, 1);
/* 717 */       int j = this.worldObj.rand.nextInt(10);
/* 718 */       if (j == 0) dropItemRand(Items.feather, 1); 
/* 719 */       if (j == 1) dropItemRand(Items.string, 1); 
/* 720 */       if (j == 2) dropItemRand(Items.flint, 1); 
/* 721 */       if (j == 3) dropItemRand(Items.beef, 1);
/*     */     
/*     */     } 
/* 724 */     dropItemRand(OreSpawnMain.MyNightmareScale, 1);
/* 725 */     dropItemRand(Items.item_frame, 1);
/*     */     
/* 727 */     i = 2 + (int)getPitchBlackScale() + this.worldObj.rand.nextInt(2 + (int)(5.0F * getPitchBlackScale()));
/* 728 */     for (var4 = 0; var4 < i; var4++)
/* 729 */       dropItemRand(OreSpawnMain.ZooKeeper, 1); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\PitchBlack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */