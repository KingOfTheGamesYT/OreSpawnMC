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
/*     */ import net.minecraft.init.Items;
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
/*     */ public class Skate
/*     */   extends EntityMob
/*     */ {
/*  64 */   private GenericTargetSorter TargetSorter = null;
/*  65 */   private EntityLivingBase buddy = null;
/*  66 */   private float moveSpeed = 0.25F;
/*     */   private int closest;
/*     */   private int tx;
/*     */   private int ty;
/*  70 */   private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Skate_stats.attack); } protected void entityInit() { super.entityInit(); this.dataWatcher.addObject(20, Byte.valueOf((byte)0)); } protected boolean canDespawn() { if (isNoDespawnRequired()) return false;  return true; } public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onUpdate(); } public int mygetMaxHealth() { return OreSpawnMain.Skate_stats.health; } public Skate(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 247 */     this.closest = 99999;
/* 248 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.75F, 0.25F); getNavigator().setAvoidsWater(false); this.experienceValue = 10; this.fireResistance = 3; this.isImmuneToFire = false; this.TargetSorter = new GenericTargetSorter((Entity)this); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, new MyEntityAIWander((EntityCreature)this, 1.0F)); this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F)); this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false)); }
/*     */   public boolean canBreatheUnderwater() { return true; }
/*     */   public int getTotalArmorValue() { return OreSpawnMain.Skate_stats.defense; }
/*     */   protected boolean isAIEnabled() { return true; }
/* 252 */   public void onLivingUpdate() { super.onLivingUpdate(); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 257 */     for (i = -dy; i <= dy; i++) {
/* 258 */       for (int j = -dz; j <= dz; j++) {
/* 259 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 260 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 261 */           int d = dx * dx + j * j + i * i;
/* 262 */           if (d < this.closest) {
/* 263 */             this.closest = d;
/* 264 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 265 */             found++;
/*     */           } 
/*     */         } 
/* 268 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 269 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 270 */           int d = dx * dx + j * j + i * i;
/* 271 */           if (d < this.closest) {
/* 272 */             this.closest = d;
/* 273 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 274 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 280 */     for (i = -dx; i <= dx; i++) {
/* 281 */       for (int j = -dz; j <= dz; j++) {
/* 282 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 283 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 284 */           int d = dy * dy + j * j + i * i;
/* 285 */           if (d < this.closest) {
/* 286 */             this.closest = d;
/* 287 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 288 */             found++;
/*     */           } 
/*     */         } 
/* 291 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 292 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 293 */           int d = dy * dy + j * j + i * i;
/* 294 */           if (d < this.closest) {
/* 295 */             this.closest = d;
/* 296 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 297 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 303 */     for (i = -dx; i <= dx; i++) {
/* 304 */       for (int j = -dy; j <= dy; j++) {
/* 305 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 306 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 307 */           int d = dz * dz + j * j + i * i;
/* 308 */           if (d < this.closest) {
/* 309 */             this.closest = d;
/* 310 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 311 */             found++;
/*     */           } 
/*     */         } 
/* 314 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 315 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 316 */           int d = dz * dz + j * j + i * i;
/* 317 */           if (d < this.closest) {
/* 318 */             this.closest = d;
/* 319 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 320 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 326 */     if (found != 0) return true; 
/* 327 */     return false; } public int getAttackStrength(Entity par1Entity) { int var2 = 4; return var2; } protected String getLivingSound() { return null; } protected String getHurtSound() { return null; }
/*     */   protected String getDeathSound() { return "orespawn:ratdead"; }
/*     */   protected float getSoundVolume() { return 0.33F; }
/*     */   protected float getSoundPitch() { return 1.75F; }
/*     */   protected Item getDropItem() { return Items.string; }
/*     */   public void initCreature() {}
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { boolean ret = false; if (this.isDead) return false;  Entity e = par1DamageSource.getEntity(); if (e != null && e instanceof Skate) return false;  if (e != null && e instanceof EntityLiving) { if (e instanceof Skate) return false;  setAttackTarget((EntityLivingBase)e); setTarget(e); getNavigator().tryMoveToEntityLiving(e, 1.2D); ret = true; }  ret = super.attackEntityFrom(par1DamageSource, par2); return ret; }
/* 334 */   protected void updateAITasks() { if (this.isDead)
/* 335 */       return;  super.updateAITasks();
/*     */ 
/*     */     
/* 338 */     if (!isInWater() && this.worldObj.rand.nextInt(10) == 0) {
/*     */ 
/*     */       
/* 341 */       this.closest = 99999;
/* 342 */       this.tx = this.ty = this.tz = 0;
/* 343 */       for (int i = 1; i < 12; i++) {
/* 344 */         int j = i;
/* 345 */         if (j > 5) j = 5; 
/* 346 */         if (scan_it((int)this.posX, (int)this.posY - 1, (int)this.posZ, i, j, i) == true)
/* 347 */           break;  if (i >= 5) i++;
/*     */       
/*     */       } 
/* 350 */       if (this.closest < 99999) {
/* 351 */         getNavigator().tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.33D);
/*     */       } else {
/* 353 */         if (this.worldObj.rand.nextInt(25) == 1)
/* 354 */           heal(-1.0F); 
/* 355 */         if (getHealth() <= 0.0F) {
/* 356 */           setDead();
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 363 */     if (this.worldObj.rand.nextInt(8) == 1) {
/* 364 */       EntityLivingBase e = findSomethingToAttack();
/* 365 */       if (e != null) {
/* 366 */         if (getDistanceSqToEntity((Entity)e) < 4.0D) {
/* 367 */           setAttacking(1);
/*     */           
/* 369 */           if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1)
/*     */           {
/* 371 */             attackEntityAsMob((Entity)e);
/*     */ 
/*     */           
/*     */           }
/*     */ 
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */           
/* 381 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */         } 
/*     */       } else {
/* 384 */         setAttacking(0);
/*     */       } 
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 402 */     if (par1EntityLiving == null)
/*     */     {
/* 404 */       return false;
/*     */     }
/* 406 */     if (par1EntityLiving == this)
/*     */     {
/* 408 */       return false;
/*     */     }
/* 410 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 412 */       return false;
/*     */     }
/* 414 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 417 */       return false;
/*     */     }
/* 419 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 421 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 422 */       if (p.capabilities.isCreativeMode == true) {
/* 423 */         return false;
/*     */       }
/* 425 */       return true;
/*     */     } 
/*     */     
/* 428 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 433 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 434 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0D, 4.0D, 10.0D));
/* 435 */     Collections.sort(var5, this.TargetSorter);
/* 436 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 438 */     Entity var3 = null;
/* 439 */     EntityLivingBase var4 = null;
/*     */     
/* 441 */     EntityLivingBase e = getAttackTarget();
/* 442 */     if (e != null && e.isEntityAlive()) {
/* 443 */       return e;
/*     */     }
/* 445 */     setAttackTarget(null);
/*     */ 
/*     */     
/* 448 */     while (var2.hasNext()) {
/*     */       
/* 450 */       var3 = (Entity)var2.next();
/* 451 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 453 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 455 */         return var4;
/*     */       }
/*     */     } 
/* 458 */     return null;
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
/* 469 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 474 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 479 */     List var5 = this.worldObj.getEntitiesWithinAABB(Skate.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D));
/* 480 */     return var5.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 489 */     if (this.posY < 50.0D) return false; 
/* 490 */     if (!this.worldObj.isDaytime()) return false; 
/* 491 */     if (this.worldObj.rand.nextInt(30) != 1) return false; 
/* 492 */     if (findBuddies() > 6) return false;
/*     */     
/* 494 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Skate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */