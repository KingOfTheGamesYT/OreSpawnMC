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
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
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
/*     */ public class Irukandji
/*     */   extends EntityMob
/*     */ {
/*  65 */   private GenericTargetSorter TargetSorter = null;
/*  66 */   private EntityLivingBase buddy = null;
/*  67 */   private float moveSpeed = 0.15F;
/*     */   private int closest;
/*     */   private int tx;
/*     */   private int ty;
/*  71 */   private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Irukandji_stats.attack); } protected void entityInit() { super.entityInit(); this.dataWatcher.addObject(20, Byte.valueOf((byte)0)); } protected boolean canDespawn() { if (isNoDespawnRequired()) return false;  return true; } public boolean canBreatheUnderwater() { return true; } public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onUpdate(); } public Irukandji(World par1World) { super(par1World);
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
/* 263 */     this.closest = 99999;
/* 264 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.25F, 0.25F); getNavigator().setAvoidsWater(false); this.experienceValue = 50; this.fireResistance = 1; this.isImmuneToFire = false; this.TargetSorter = new GenericTargetSorter((Entity)this); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, new MyEntityAIWander((EntityCreature)this, 1.0F)); this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F)); this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false)); }
/*     */   public int mygetMaxHealth() { return OreSpawnMain.Irukandji_stats.health; }
/*     */   public int getTotalArmorValue() { return OreSpawnMain.Irukandji_stats.defense; }
/*     */   protected boolean isAIEnabled() { return true; }
/* 268 */   public void onLivingUpdate() { super.onLivingUpdate(); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 273 */     for (i = -dy; i <= dy; i++) {
/* 274 */       for (int j = -dz; j <= dz; j++) {
/* 275 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 276 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 277 */           int d = dx * dx + j * j + i * i;
/* 278 */           if (d < this.closest) {
/* 279 */             this.closest = d;
/* 280 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 281 */             found++;
/*     */           } 
/*     */         } 
/* 284 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 285 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 286 */           int d = dx * dx + j * j + i * i;
/* 287 */           if (d < this.closest) {
/* 288 */             this.closest = d;
/* 289 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 290 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 296 */     for (i = -dx; i <= dx; i++) {
/* 297 */       for (int j = -dz; j <= dz; j++) {
/* 298 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 299 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 300 */           int d = dy * dy + j * j + i * i;
/* 301 */           if (d < this.closest) {
/* 302 */             this.closest = d;
/* 303 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 304 */             found++;
/*     */           } 
/*     */         } 
/* 307 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 308 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 309 */           int d = dy * dy + j * j + i * i;
/* 310 */           if (d < this.closest) {
/* 311 */             this.closest = d;
/* 312 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 313 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 319 */     for (i = -dx; i <= dx; i++) {
/* 320 */       for (int j = -dy; j <= dy; j++) {
/* 321 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 322 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 323 */           int d = dz * dz + j * j + i * i;
/* 324 */           if (d < this.closest) {
/* 325 */             this.closest = d;
/* 326 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 327 */             found++;
/*     */           } 
/*     */         } 
/* 330 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 331 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 332 */           int d = dz * dz + j * j + i * i;
/* 333 */           if (d < this.closest) {
/* 334 */             this.closest = d;
/* 335 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 336 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 342 */     if (found != 0) return true; 
/* 343 */     return false; }
/*     */   public int getAttackStrength(Entity par1Entity) { int var2 = 2;
/*     */     return var2; }
/*     */   protected String getLivingSound() { return null; }
/*     */   protected String getHurtSound() { return "orespawn:little_splt"; }
/*     */   protected String getDeathSound() { return "orespawn:ratdead"; }
/*     */   protected float getSoundVolume() { return 0.25F; }
/* 350 */   protected void updateAITasks() { if (this.isDead)
/* 351 */       return;  super.updateAITasks();
/*     */ 
/*     */     
/* 354 */     if (!isInWater() && this.worldObj.rand.nextInt(10) == 0) {
/*     */ 
/*     */       
/* 357 */       this.closest = 99999;
/* 358 */       this.tx = this.ty = this.tz = 0;
/* 359 */       for (int i = 1; i < 12; i++) {
/* 360 */         int j = i;
/* 361 */         if (j > 5) j = 5; 
/* 362 */         if (scan_it((int)this.posX, (int)this.posY - 1, (int)this.posZ, i, j, i) == true)
/* 363 */           break;  if (i >= 5) i++;
/*     */       
/*     */       } 
/* 366 */       if (this.closest < 99999) {
/* 367 */         getNavigator().tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.33D);
/*     */       } else {
/* 369 */         if (this.worldObj.rand.nextInt(25) == 1)
/* 370 */           heal(-1.0F); 
/* 371 */         if (getHealth() <= 0.0F) {
/* 372 */           setDead();
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 379 */     if (this.worldObj.rand.nextInt(8) == 1) {
/* 380 */       EntityLivingBase e = findSomethingToAttack();
/* 381 */       if (e != null) {
/* 382 */         if (getDistanceSqToEntity((Entity)e) < 3.0D) {
/* 383 */           setAttacking(1);
/*     */           
/* 385 */           if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1)
/*     */           {
/* 387 */             attackEntityAsMob((Entity)e);
/*     */ 
/*     */           
/*     */           }
/*     */ 
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */           
/* 397 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */         } 
/*     */       } else {
/* 400 */         setAttacking(0);
/*     */       } 
/*     */     }  } protected float getSoundPitch() { return 2.0F; } protected Item getDropItem() { return OreSpawnMain.MyIrukandji; }
/*     */   public void initCreature() {}
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) { if (par1EntityPlayer != null && par1EntityPlayer.getCurrentEquippedItem() == null)
/*     */       par1EntityPlayer.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 200.0F);  return false; }
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { boolean ret = false; if (this.isDead)
/*     */       return false;  Entity e = par1DamageSource.getEntity(); if (e != null && e instanceof EntityPlayer) {
/*     */       EntityPlayer p = (EntityPlayer)e; if (p.getCurrentEquippedItem() == null) {
/*     */         p.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 200.0F); return false;
/*     */       } 
/*     */     }  if (e != null && e instanceof EntityLiving) {
/*     */       if (e instanceof Irukandji)
/*     */         return false;  setAttackTarget((EntityLivingBase)e); setTarget(e); getNavigator().tryMoveToEntityLiving(e, 1.2D);
/*     */       ret = true;
/*     */     } 
/*     */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     return ret; }
/* 418 */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) { if (par1EntityLiving == null)
/*     */     {
/* 420 */       return false;
/*     */     }
/* 422 */     if (par1EntityLiving == this)
/*     */     {
/* 424 */       return false;
/*     */     }
/* 426 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 428 */       return false;
/*     */     }
/* 430 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 433 */       return false;
/*     */     }
/* 435 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 437 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 438 */       if (p.capabilities.isCreativeMode == true) {
/* 439 */         return false;
/*     */       }
/* 441 */       return true;
/*     */     } 
/*     */     
/* 444 */     return false; }
/*     */ 
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 449 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 450 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(6.0D, 4.0D, 6.0D));
/* 451 */     Collections.sort(var5, this.TargetSorter);
/* 452 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 454 */     Entity var3 = null;
/* 455 */     EntityLivingBase var4 = null;
/*     */     
/* 457 */     EntityLivingBase e = getAttackTarget();
/* 458 */     if (e != null && e.isEntityAlive()) {
/* 459 */       return e;
/*     */     }
/* 461 */     setAttackTarget(null);
/*     */ 
/*     */     
/* 464 */     while (var2.hasNext()) {
/*     */       
/* 466 */       var3 = (Entity)var2.next();
/* 467 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 469 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 471 */         return var4;
/*     */       }
/*     */     } 
/* 474 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 485 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 490 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 495 */     List var5 = this.worldObj.getEntitiesWithinAABB(Irukandji.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D));
/* 496 */     return var5.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 504 */     if (this.posY < 50.0D) return false; 
/* 505 */     if (!this.worldObj.isDaytime()) return false; 
/* 506 */     if (this.worldObj.rand.nextInt(60) != 1) return false; 
/* 507 */     if (findBuddies() > 2) return false; 
/* 508 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Irukandji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */