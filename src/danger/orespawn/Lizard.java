/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITempt;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Lizard
/*     */   extends EntityCannonFodder
/*     */ {
/*  70 */   private GenericTargetSorter TargetSorter = null;
/*     */   public boolean should_despawn = true;
/*  72 */   private EntityLivingBase buddy = null;
/*  73 */   private int follow_time = 0;
/*  74 */   private float moveSpeed = 0.3F;
/*     */   private int closest;
/*     */   private int tx;
/*     */   private int ty;
/*  78 */   private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage); getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D); } protected void entityInit() { super.entityInit(); this.dataWatcher.addObject(23, Byte.valueOf((byte)0)); } public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onUpdate(); } public int mygetMaxHealth() { return 30; } public Lizard(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 271 */     this.closest = 99999;
/* 272 */     this.tx = 0; this.ty = 0; this.tz = 0; this.moveSpeed = 0.3F; setSize(1.5F, 1.25F); getNavigator().setAvoidsWater(false); this.experienceValue = 15; this.fireResistance = 3; this.isImmuneToFire = false; this.TargetSorter = new GenericTargetSorter((Entity)this); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, new MyEntityAIFollowOwner(this, 2.0F, 10.0F, 2.0F)); this.tasks.addTask(2, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D)); this.tasks.addTask(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.dye, false)); this.tasks.addTask(4, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D)); this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F)); this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false)); }
/*     */   public int getTotalArmorValue() { return 5; }
/*     */   protected boolean isAIEnabled() { return true; }
/* 276 */   public void onLivingUpdate() { super.onLivingUpdate(); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 281 */     for (i = -dy; i <= dy; i++) {
/* 282 */       for (int j = -dz; j <= dz; j++) {
/* 283 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 284 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 285 */           int d = dx * dx + j * j + i * i;
/* 286 */           if (d < this.closest) {
/* 287 */             this.closest = d;
/* 288 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 289 */             found++;
/*     */           } 
/*     */         } 
/* 292 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 293 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 294 */           int d = dx * dx + j * j + i * i;
/* 295 */           if (d < this.closest) {
/* 296 */             this.closest = d;
/* 297 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 298 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 304 */     for (i = -dx; i <= dx; i++) {
/* 305 */       for (int j = -dz; j <= dz; j++) {
/* 306 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 307 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 308 */           int d = dy * dy + j * j + i * i;
/* 309 */           if (d < this.closest) {
/* 310 */             this.closest = d;
/* 311 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 312 */             found++;
/*     */           } 
/*     */         } 
/* 315 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 316 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 317 */           int d = dy * dy + j * j + i * i;
/* 318 */           if (d < this.closest) {
/* 319 */             this.closest = d;
/* 320 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 321 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 327 */     for (i = -dx; i <= dx; i++) {
/* 328 */       for (int j = -dy; j <= dy; j++) {
/* 329 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 330 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 331 */           int d = dz * dz + j * j + i * i;
/* 332 */           if (d < this.closest) {
/* 333 */             this.closest = d;
/* 334 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 335 */             found++;
/*     */           } 
/*     */         } 
/* 338 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 339 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 340 */           int d = dz * dz + j * j + i * i;
/* 341 */           if (d < this.closest) {
/* 342 */             this.closest = d;
/* 343 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 344 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 350 */     if (found != 0) return true; 
/* 351 */     return false; } public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { boolean ret = false; Entity e = par1DamageSource.getEntity(); if (!par1DamageSource.getDamageType().equals("cactus")) {
/*     */       ret = super.attackEntityFrom(par1DamageSource, par2); if (e != null && e instanceof EntityLivingBase)
/*     */         setAttackTarget((EntityLivingBase)e); 
/*     */     }  this.follow_time = 0; return ret; }
/*     */   protected String getLivingSound() { return null; }
/*     */   protected String getHurtSound() { return "orespawn:alo_hurt"; }
/*     */   protected String getDeathSound() { return "orespawn:alo_death"; }
/* 358 */   protected void updateAITasks() { if (this.isDead)
/* 359 */       return;  super.updateAITasks();
/*     */     
/* 361 */     if (this.follow_time > 0) {
/* 362 */       this.follow_time--;
/* 363 */       this.should_despawn = false;
/*     */     } else {
/* 365 */       this.should_despawn = true;
/*     */     } 
/*     */ 
/*     */     
/* 369 */     if (!isInWater() && this.worldObj.rand.nextInt(100) == 0) {
/*     */ 
/*     */       
/* 372 */       this.closest = 99999;
/* 373 */       this.tx = this.ty = this.tz = 0;
/* 374 */       for (int i = 1; i < 14; i++) {
/* 375 */         int j = i;
/* 376 */         if (j > 5) j = 5; 
/* 377 */         if (scan_it((int)this.posX, (int)this.posY - 1, (int)this.posZ, i, j, i) == true)
/* 378 */           break;  if (i >= 5) i++;
/*     */       
/*     */       } 
/* 381 */       if (this.closest < 99999) {
/* 382 */         getNavigator().tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.33D);
/*     */       }
/*     */     } 
/*     */     
/* 386 */     if (getHealth() < mygetMaxHealth() && this.worldObj.rand.nextInt(300) == 1) {
/* 387 */       heal(1.0F);
/*     */     }
/*     */ 
/*     */     
/* 391 */     if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(10) == 1) {
/* 392 */       EntityLivingBase e = findSomethingToAttack();
/* 393 */       if (e != null) {
/* 394 */         this.follow_time = 0;
/* 395 */         if (getDistanceSqToEntity((Entity)e) < 12.0D) {
/* 396 */           setAttacking(1);
/*     */           
/* 398 */           if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1)
/*     */           {
/* 400 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 403 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */         } 
/*     */       } else {
/*     */         
/* 407 */         if (this.buddy != null && !this.buddy.isDead && this.worldObj.rand.nextInt(15) == 1) {
/* 408 */           getNavigator().tryMoveToEntityLiving((Entity)this.buddy, 1.0D);
/*     */         }
/* 410 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 415 */     if (this.buddy != null && !this.buddy.isDead && this.follow_time > 0 && this.worldObj.rand.nextInt(20) == 1)
/* 416 */       getNavigator().tryMoveToEntityLiving((Entity)this.buddy, 1.0D);  } protected float getSoundVolume() { return 1.0F; }
/*     */   protected float getSoundPitch() { return 1.0F; }
/*     */   protected Item getDropItem() { return null; }
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) { ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem(); if (var2 != null) if (var2.stackSize <= 0) { par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null); var2 = null; }   if (super.interact(par1EntityPlayer))
/*     */       return true;  if (var2 != null && var2.getItem() == Items.dye && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) { if (!this.worldObj.isRemote) { this.buddy = (EntityLivingBase)par1EntityPlayer; this.follow_time = 3000 + this.worldObj.rand.nextInt(2000); }  playTameEffect(true); if (!par1EntityPlayer.capabilities.isCreativeMode) { var2.stackSize--; if (var2.stackSize <= 0)
/*     */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);  }  return true; }  if (!this.worldObj.isRemote) { this.buddy = null; this.follow_time = 0; }  playTameEffect(false); return true; }
/* 422 */   public boolean attackEntityAsMob(Entity par1Entity) { float i = 6.0F;
/*     */     
/* 424 */     boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), i);
/*     */     
/* 426 */     return flag; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 436 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*     */     
/* 438 */     if (par1EntityLiving == null)
/*     */     {
/* 440 */       return false;
/*     */     }
/* 442 */     if (par1EntityLiving == this)
/*     */     {
/* 444 */       return false;
/*     */     }
/* 446 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 448 */       return false;
/*     */     }
/* 450 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 453 */       return false;
/*     */     }
/* 455 */     if (par1EntityLiving instanceof AttackSquid)
/*     */     {
/* 457 */       return true;
/*     */     }
/* 459 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntitySpider)
/*     */     {
/* 461 */       return true;
/*     */     }
/* 463 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCaveSpider)
/*     */     {
/* 465 */       return true;
/*     */     }
/* 467 */     if (par1EntityLiving instanceof net.minecraft.entity.passive.EntityChicken)
/*     */     {
/* 469 */       return true;
/*     */     }
/* 471 */     if (par1EntityLiving instanceof Lizard)
/*     */     {
/*     */       
/* 474 */       if (this.worldObj.rand.nextInt(10) == 1 && this.follow_time <= 0) this.buddy = par1EntityLiving;
/*     */     
/*     */     }
/* 477 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 482 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 483 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 4.0D, 12.0D));
/* 484 */     Collections.sort(var5, this.TargetSorter);
/* 485 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 487 */     Entity var3 = null;
/* 488 */     EntityLivingBase var4 = null;
/*     */     
/* 490 */     if (this.worldObj.rand.nextInt(100) == 0) setAttackTarget(null); 
/* 491 */     EntityLivingBase e = getAttackTarget();
/* 492 */     if (e != null && e.isEntityAlive()) {
/* 493 */       return e;
/*     */     }
/* 495 */     setAttackTarget(null);
/*     */ 
/*     */     
/* 498 */     while (var2.hasNext()) {
/*     */       
/* 500 */       var3 = (Entity)var2.next();
/* 501 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 503 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 505 */         return var4;
/*     */       }
/*     */     } 
/* 508 */     return null;
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
/* 519 */     return this.dataWatcher.getWatchableObjectByte(23);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 524 */     this.dataWatcher.updateObject(23, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 532 */     if (this.posY < 50.0D) return false;
/*     */     
/* 534 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 543 */     if (isChild()) {
/* 544 */       enablePersistence();
/* 545 */       return false;
/*     */     } 
/* 547 */     if (isNoDespawnRequired()) return false; 
/* 548 */     if (isTamed()) return false; 
/* 549 */     return this.should_despawn;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 554 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Lizard spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 560 */     return new Lizard(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 568 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.apple);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 577 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Lizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */