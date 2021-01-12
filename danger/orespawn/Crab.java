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
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Crab
/*     */   extends EntityMob
/*     */ {
/*  90 */   private GenericTargetSorter TargetSorter = null;
/*  91 */   private int hurt_timer = 0;
/*  92 */   private float moveSpeed = 0.55F;
/*     */   private int closest;
/*     */   private int tx;
/*     */   private int ty;
/*  96 */   private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((this.moveSpeed * getCrabScale())); getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((OreSpawnMain.Crab_stats.attack * getCrabScale())); } protected void entityInit() { super.entityInit(); this.dataWatcher.addObject(20, Byte.valueOf((byte)0)); this.dataWatcher.addObject(21, Integer.valueOf(0)); float t = 0.25F; if (this.worldObj != null) { if (this.worldObj.rand.nextInt(4) == 1) t = 0.5F;  if (this.worldObj.rand.nextInt(8) == 2) t = 1.0F;  } else { if (OreSpawnMain.OreSpawnRand.nextInt(4) == 1) t = 0.5F;  if (OreSpawnMain.OreSpawnRand.nextInt(8) == 2) t = 1.0F;  }  setCrabScale(t); this.experienceValue = (int)(400.0F * t); this.fireResistance = (int)(10.0F * t); setSize(3.75F * getCrabScale(), 3.5F * getCrabScale()); } public float getCrabScale() { int i = this.dataWatcher.getWatchableObjectInt(21); float f = i; return f / 100.0F; } public void setCrabScale(float par1) { float f = par1 * 100.0F; int i = (int)f; this.dataWatcher.updateObject(21, Integer.valueOf(i)); } public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) { super.readEntityFromNBT(par1NBTTagCompound); setCrabScale(par1NBTTagCompound.getFloat("Fscale")); setSize(3.75F * getCrabScale(), 3.5F * getCrabScale()); this.experienceValue = (int)(400.0F * getCrabScale()); this.fireResistance = (int)(10.0F * getCrabScale()); } public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) { super.writeEntityToNBT(par1NBTTagCompound); par1NBTTagCompound.setFloat("Fscale", getCrabScale()); } public Crab(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 374 */     this.closest = 99999;
/* 375 */     this.tx = 0; this.ty = 0; this.tz = 0; this.moveSpeed = 0.55F; setSize(1.25F, 2.5F); getNavigator().setAvoidsWater(false); this.experienceValue = 150; this.fireResistance = 30; this.isImmuneToFire = false; this.TargetSorter = new GenericTargetSorter((Entity)this); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F)); this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 8.0F)); this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false)); }
/*     */   protected boolean canDespawn() { if (isNoDespawnRequired()) return false;  return true; }
/*     */   public void onUpdate() { if (isInWater()) { this.moveSpeed = 0.95F; } else { this.moveSpeed = 0.55F; }  getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((this.moveSpeed * getCrabScale())); super.onUpdate(); setSize(2.5F * getCrabScale(), 3.5F * getCrabScale()); }
/*     */   public int mygetMaxHealth() { return (int)(OreSpawnMain.PitchBlack_stats.health * getCrabScale()); }
/* 379 */   public int getTotalArmorValue() { return OreSpawnMain.Crab_stats.defense + (int)(2.0F * getCrabScale()); } protected boolean isAIEnabled() { return true; } public void onLivingUpdate() { super.onLivingUpdate(); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 384 */     for (i = -dy; i <= dy; i++) {
/* 385 */       for (int j = -dz; j <= dz; j++) {
/* 386 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 387 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 388 */           int d = dx * dx + j * j + i * i;
/* 389 */           if (d < this.closest) {
/* 390 */             this.closest = d;
/* 391 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 392 */             found++;
/*     */           } 
/*     */         } 
/* 395 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 396 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 397 */           int d = dx * dx + j * j + i * i;
/* 398 */           if (d < this.closest) {
/* 399 */             this.closest = d;
/* 400 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 401 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 407 */     for (i = -dx; i <= dx; i++) {
/* 408 */       for (int j = -dz; j <= dz; j++) {
/* 409 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 410 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 411 */           int d = dy * dy + j * j + i * i;
/* 412 */           if (d < this.closest) {
/* 413 */             this.closest = d;
/* 414 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 415 */             found++;
/*     */           } 
/*     */         } 
/* 418 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 419 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 420 */           int d = dy * dy + j * j + i * i;
/* 421 */           if (d < this.closest) {
/* 422 */             this.closest = d;
/* 423 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 424 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 430 */     for (i = -dx; i <= dx; i++) {
/* 431 */       for (int j = -dy; j <= dy; j++) {
/* 432 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 433 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 434 */           int d = dz * dz + j * j + i * i;
/* 435 */           if (d < this.closest) {
/* 436 */             this.closest = d;
/* 437 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 438 */             found++;
/*     */           } 
/*     */         } 
/* 441 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 442 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 443 */           int d = dz * dz + j * j + i * i;
/* 444 */           if (d < this.closest) {
/* 445 */             this.closest = d;
/* 446 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 447 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 453 */     if (found != 0) return true; 
/* 454 */     return false; } public int getCrabHealth() { return (int)getHealth(); } protected String getLivingSound() { return null; } protected String getHurtSound() { return "orespawn:leaves_hit"; } protected String getDeathSound() { return null; } protected float getSoundVolume() { return 0.75F; } protected float getSoundPitch() { return 2.0F - 0.3F * 1.0F / getCrabScale(); } protected Item getDropItem() { return Items.fish; }
/*     */   private ItemStack dropItemRand(Item index, int par1) { EntityItem var3 = null; ItemStack is = new ItemStack(index, par1, 0); var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is); if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3);  return is; }
/*     */   protected void dropFewItems(boolean par1, int par2) { ItemStack is = null; int var5 = 4 + this.worldObj.rand.nextInt(8); var5 = (int)(var5 * getCrabScale()); if (var5 < 1) var5 = 1;  for (int var4 = 0; var4 < var5; var4++) dropItemRand(OreSpawnMain.MyRawCrabMeat, 1);  }
/*     */   public void initCreature() {}
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) { return false; }
/*     */   public boolean attackEntityAsMob(Entity par1Entity) { boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), OreSpawnMain.Crab_stats.attack * getCrabScale()); if (var4 && par1Entity != null && par1Entity instanceof EntityLivingBase) { double ks = 1.15D * getCrabScale(); double inair = 0.48D * getCrabScale(); float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX); if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D;  par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks); }  return var4; }
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { boolean ret = false; if (par1DamageSource.getDamageType().equals("cactus")) return false;  Entity e = par1DamageSource.getEntity(); if (this.hurt_timer <= 0) { ret = super.attackEntityFrom(par1DamageSource, par2); this.hurt_timer = 8; }  if (e != null && e instanceof EntityLiving) { if (e instanceof Crab) return false;  setAttackTarget((EntityLivingBase)e); setTarget(e); getNavigator().tryMoveToEntityLiving(e, 1.2D); }  return ret; }
/* 461 */   protected void updateAITasks() { if (this.isDead)
/* 462 */       return;  super.updateAITasks();
/* 463 */     if (this.hurt_timer > 0) this.hurt_timer--;
/*     */     
/* 465 */     if (!isInWater() && this.worldObj.rand.nextInt(25) == 0) {
/*     */ 
/*     */       
/* 468 */       this.closest = 99999;
/* 469 */       this.tx = this.ty = this.tz = 0;
/* 470 */       for (int i = 1; i < 12; i++) {
/* 471 */         int j = i;
/* 472 */         if (j > 10) j = 10; 
/* 473 */         if (scan_it((int)this.posX, (int)this.posY - 1, (int)this.posZ, i, j, i) == true)
/* 474 */           break;  if (i >= 5) i++;
/*     */       
/*     */       } 
/* 477 */       if (this.closest < 99999) {
/* 478 */         getNavigator().tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.33D);
/*     */       } else {
/* 480 */         if (this.worldObj.rand.nextInt(100) == 1)
/* 481 */           heal(-1.0F * getCrabScale()); 
/* 482 */         if (getHealth() <= 0.0F) {
/* 483 */           setDead();
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 490 */     if (this.worldObj.rand.nextInt(5) == 1) {
/* 491 */       EntityLivingBase e = null;
/* 492 */       if (this.worldObj.rand.nextInt(100) == 1) setAttackTarget(null); 
/* 493 */       e = getAttackTarget();
/* 494 */       if (e != null && !e.isEntityAlive()) {
/* 495 */         setAttackTarget(null);
/* 496 */         e = null;
/*     */       } 
/* 498 */       if (e == null) {
/* 499 */         e = findSomethingToAttack();
/*     */       }
/* 501 */       if (e != null) {
/* 502 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 503 */         if (getDistanceSqToEntity((Entity)e) < ((6.0F + e.width / 2.0F) * (6.0F + e.width / 2.0F) * getCrabScale())) {
/* 504 */           setAttacking(1);
/*     */           
/* 506 */           if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1) {
/*     */             
/* 508 */             attackEntityAsMob((Entity)e);
/* 509 */             if (!this.worldObj.isRemote) {
/* 510 */               if (this.worldObj.rand.nextInt(3) == 1) {
/* 511 */                 this.worldObj.playSoundAtEntity((Entity)e, "orespawn:scorpion_attack", 0.75F, 1.5F);
/*     */               } else {
/* 513 */                 this.worldObj.playSoundAtEntity((Entity)e, "orespawn:scorpion_living", 0.75F, 1.5F);
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } else {
/* 518 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.0D);
/*     */         } 
/*     */       } else {
/* 521 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 526 */     if (this.worldObj.rand.nextInt(120) == 1 && isInWater() && 
/* 527 */       getHealth() < mygetMaxHealth()) {
/* 528 */       playSound("splash", 1.5F, this.worldObj.rand.nextFloat() * 0.2F + 0.9F);
/*     */       
/* 530 */       heal(4.0F * getCrabScale());
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
/* 547 */     if (par1EntityLiving == null)
/*     */     {
/* 549 */       return false;
/*     */     }
/* 551 */     if (par1EntityLiving == this)
/*     */     {
/* 553 */       return false;
/*     */     }
/* 555 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 557 */       return false;
/*     */     }
/* 559 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 562 */       return false;
/*     */     }
/* 564 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 566 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 567 */       if (p.capabilities.isCreativeMode == true) {
/* 568 */         return false;
/*     */       }
/* 570 */       return true;
/*     */     } 
/* 572 */     if (par1EntityLiving instanceof Crab)
/*     */     {
/* 574 */       return false;
/*     */     }
/* 576 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 578 */       return true;
/*     */     }
/* 580 */     if (par1EntityLiving instanceof Lizard)
/*     */     {
/* 582 */       return true;
/*     */     }
/* 584 */     if (par1EntityLiving instanceof RubberDucky)
/*     */     {
/* 586 */       return true;
/*     */     }
/* 588 */     if (par1EntityLiving instanceof net.minecraft.entity.passive.EntityVillager)
/*     */     {
/* 590 */       return true;
/*     */     }
/* 592 */     if (par1EntityLiving instanceof Girlfriend)
/*     */     {
/* 594 */       return true;
/*     */     }
/* 596 */     if (par1EntityLiving instanceof Boyfriend)
/*     */     {
/* 598 */       return true;
/*     */     }
/* 600 */     if (MyUtils.isAttackableNonMob(par1EntityLiving)) {
/* 601 */       return true;
/*     */     }
/*     */     
/* 604 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 609 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 610 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0D, 6.0D, 16.0D));
/* 611 */     Collections.sort(var5, this.TargetSorter);
/* 612 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 614 */     Entity var3 = null;
/* 615 */     EntityLivingBase var4 = null;
/*     */     
/* 617 */     EntityLivingBase e = getAttackTarget();
/* 618 */     if (e != null && e.isEntityAlive()) {
/* 619 */       return e;
/*     */     }
/* 621 */     setAttackTarget(null);
/*     */ 
/*     */     
/* 624 */     while (var2.hasNext()) {
/*     */       
/* 626 */       var3 = (Entity)var2.next();
/* 627 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 629 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 631 */         return var4;
/*     */       }
/*     */     } 
/* 634 */     return null;
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
/* 645 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 650 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 655 */     List var5 = this.worldObj.getEntitiesWithinAABB(Crab.class, this.boundingBox.expand(24.0D, 8.0D, 24.0D));
/* 656 */     return var5.size();
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
/* 668 */     for (int k = -3; k < 3; k++) {
/*     */       
/* 670 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 672 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 674 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 675 */           if (bid == Blocks.mob_spawner) {
/* 676 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 677 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 678 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 679 */             if (s != null && 
/* 680 */               s.equals("Crab")) {
/* 681 */               setCrabScale(0.35F);
/* 682 */               return true;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 690 */     if (this.posY < 50.0D) return false;
/*     */     
/* 692 */     if (!this.worldObj.isDaytime()) return false;
/*     */     
/* 694 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID5) {
/* 695 */       if (this.worldObj.rand.nextInt(40) != 1) return false; 
/* 696 */       if (findBuddies() > 3) return false;
/*     */     
/*     */     } 
/* 699 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 705 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Crab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */