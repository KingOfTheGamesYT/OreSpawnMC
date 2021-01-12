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
/*     */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
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
/*     */ public class Alien
/*     */   extends EntityMob
/*     */ {
/*  57 */   private GenericTargetSorter TargetSorter = null;
/*  58 */   private RenderInfo renderdata = new RenderInfo();
/*  59 */   private int hurt_timer = 0;
/*  60 */   private double moveSpeed = 0.65D;
/*     */   private int closest;
/*     */   private int tx;
/*     */   private int ty;
/*  64 */   private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Alien_stats.attack); } protected void entityInit() { super.entityInit(); this.dataWatcher.addObject(20, Byte.valueOf((byte)0)); if (this.renderdata == null) this.renderdata = new RenderInfo();  this.renderdata.rf1 = 0.0F; this.renderdata.rf2 = 0.0F; this.renderdata.rf3 = 0.0F; this.renderdata.rf4 = 0.0F; this.renderdata.ri1 = 0; this.renderdata.ri2 = 0; this.renderdata.ri3 = 0; this.renderdata.ri4 = 0; } protected boolean canDespawn() { if (isNoDespawnRequired()) return false;  return true; } public int mygetMaxHealth() { return OreSpawnMain.Alien_stats.health; } protected void jump() { super.jump(); this.motionY += 0.25D; } public RenderInfo getRenderInfo() { return this.renderdata; } public Alien(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 364 */     this.closest = 99999;
/* 365 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(1.1F, 3.25F); getNavigator().setAvoidsWater(true); getNavigator().setBreakDoors(true); this.experienceValue = 100; this.fireResistance = 30; this.isImmuneToFire = false; this.jumpMovementFactor = 0.6F; this.TargetSorter = new GenericTargetSorter((Entity)this); this.renderdata = new RenderInfo(); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false)); this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D)); this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F)); this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false)); }
/*     */   public void setRenderInfo(RenderInfo r) { this.renderdata.rf1 = r.rf1; this.renderdata.rf2 = r.rf2; this.renderdata.rf3 = r.rf3; this.renderdata.rf4 = r.rf4; this.renderdata.ri1 = r.ri1; this.renderdata.ri2 = r.ri2; this.renderdata.ri3 = r.ri3; this.renderdata.ri4 = r.ri4; }
/*     */   public int getTotalArmorValue() { return OreSpawnMain.Alien_stats.defense; }
/* 368 */   protected boolean isAIEnabled() { return true; } public void onLivingUpdate() { super.onLivingUpdate(); if (this.worldObj.isRemote) { float f = 1.7F + Math.abs(this.worldObj.rand.nextFloat() * 0.75F); if (this.worldObj.rand.nextInt(20) == 1) this.worldObj.spawnParticle("dripLava", this.posX - f * Math.sin(Math.toRadians(this.rotationYawHead)), this.posY + 1.6D, this.posZ + f * Math.cos(Math.toRadians(this.rotationYawHead)), 0.0D, 0.0D, 0.0D);  }  } public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onUpdate(); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 373 */     for (i = -dy; i <= dy; i++) {
/* 374 */       for (int j = -dz; j <= dz; j++) {
/* 375 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 376 */         if (bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) {
/* 377 */           int d = dx * dx + j * j + i * i;
/* 378 */           if (d < this.closest) {
/* 379 */             this.closest = d;
/* 380 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 381 */             found++;
/*     */           } 
/*     */         } 
/* 384 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 385 */         if (bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) {
/* 386 */           int d = dx * dx + j * j + i * i;
/* 387 */           if (d < this.closest) {
/* 388 */             this.closest = d;
/* 389 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 390 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 396 */     for (i = -dx; i <= dx; i++) {
/* 397 */       for (int j = -dz; j <= dz; j++) {
/* 398 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 399 */         if (bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) {
/* 400 */           int d = dy * dy + j * j + i * i;
/* 401 */           if (d < this.closest) {
/* 402 */             this.closest = d;
/* 403 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 404 */             found++;
/*     */           } 
/*     */         } 
/* 407 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 408 */         if (bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) {
/* 409 */           int d = dy * dy + j * j + i * i;
/* 410 */           if (d < this.closest) {
/* 411 */             this.closest = d;
/* 412 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 413 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 419 */     for (i = -dx; i <= dx; i++) {
/* 420 */       for (int j = -dy; j <= dy; j++) {
/* 421 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 422 */         if (bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) {
/* 423 */           int d = dz * dz + j * j + i * i;
/* 424 */           if (d < this.closest) {
/* 425 */             this.closest = d;
/* 426 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 427 */             found++;
/*     */           } 
/*     */         } 
/* 430 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 431 */         if (bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) {
/* 432 */           int d = dz * dz + j * j + i * i;
/* 433 */           if (d < this.closest) {
/* 434 */             this.closest = d;
/* 435 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 436 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 442 */     if (found != 0) return true; 
/* 443 */     return false; } public int getAlienHealth() { return (int)getHealth(); } protected String getLivingSound() { if (this.worldObj.rand.nextInt(4) == 0) return "orespawn:alien_living";  return null; } protected String getHurtSound() { return "orespawn:alien_hurt"; } protected String getDeathSound() { return "orespawn:alien_death"; } protected float getSoundVolume() { return 1.0F; } protected float getSoundPitch() { return 1.0F; } protected Item getDropItem() { return Items.spider_eye; }
/*     */   private void dropItemRand(Item index, int par1) { EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0)); this.worldObj.spawnEntityInWorld((Entity)var3); }
/*     */   protected void dropFewItems(boolean par1, int par2) { int var5 = 5 + this.worldObj.rand.nextInt(6); int var4; for (var4 = 0; var4 < var5; var4++) dropItemRand(Items.spider_eye, 1);  var5 = 5 + this.worldObj.rand.nextInt(6); for (var4 = 0; var4 < var5; var4++) dropItemRand(Items.flint, 1);  dropItemRand((Item)Items.map, 1); dropItemRand(Items.clock, 1); dropItemRand(Items.compass, 1); }
/*     */   public void initCreature() {}
/*     */   public boolean attackEntityAsMob(Entity par1Entity) { if (super.attackEntityAsMob(par1Entity)) { if (par1Entity != null && par1Entity instanceof EntityLivingBase) { int var2 = 6; if (this.worldObj.difficultySetting == EnumDifficulty.EASY) { var2 = 8; if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) { var2 = 10; } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) { var2 = 12; }  }  if (par1Entity instanceof EntityLivingBase && this.worldObj.rand.nextInt(5) == 1) ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, var2 * 5, 0));  double ks = 1.1D; double inair = 0.1D; float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX); if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D;  par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks); }  return true; }  return false; }
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { boolean ret = false; if (par1DamageSource.getDamageType().equals("cactus")) return false;  if (this.hurt_timer <= 0) ret = super.attackEntityFrom(par1DamageSource, par2);  Entity e = par1DamageSource.getEntity(); if (e != null && e instanceof EntityLiving) { setAttackTarget((EntityLivingBase)e); setTarget(e); getNavigator().tryMoveToEntityLiving(e, 1.2D); ret = true; }  return ret; }
/* 449 */   protected void updateAITasks() { if (this.isDead)
/* 450 */       return;  super.updateAITasks();
/* 451 */     if (this.hurt_timer > 0) this.hurt_timer--; 
/* 452 */     if (this.worldObj.rand.nextInt(8) == 0) {
/* 453 */       EntityLivingBase e = findSomethingToAttack();
/* 454 */       if (e != null) {
/* 455 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 456 */         if (getDistanceSqToEntity((Entity)e) < 16.0D) {
/* 457 */           setAttacking(1);
/*     */           
/* 459 */           if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1)
/*     */           {
/* 461 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } 
/* 464 */         getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */       } else {
/*     */         
/* 467 */         setAttacking(0);
/*     */       }
/*     */     
/* 470 */     } else if (this.rand.nextInt(30) == 0 && OreSpawnMain.PlayNicely == 0) {
/*     */       
/* 472 */       this.closest = 99999;
/* 473 */       this.tx = this.ty = this.tz = 0;
/*     */       
/* 475 */       for (int i = 2; i < 15 && 
/* 476 */         scan_it((int)this.posX, (int)this.posY, (int)this.posZ, i, i, i) != true; i++) {
/* 477 */         if (i >= 10) i++;
/*     */       
/*     */       } 
/* 480 */       if (this.closest < 99999) {
/* 481 */         getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 482 */         if (this.closest < 27 && 
/* 483 */           this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2);
/*     */       
/*     */       } 
/*     */     } 
/*     */     
/* 488 */     if (this.worldObj.rand.nextInt(40) == 1 && 
/* 489 */       getHealth() < mygetMaxHealth())
/*     */     {
/* 491 */       heal(1.0F);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase var4, boolean par2) {
/* 505 */     if (var4 == null)
/*     */     {
/* 507 */       return false;
/*     */     }
/* 509 */     if (var4 == this)
/*     */     {
/* 511 */       return false;
/*     */     }
/* 513 */     if (!var4.isEntityAlive())
/*     */     {
/* 515 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 522 */     if (var4 instanceof EntityPlayer) {
/*     */       
/* 524 */       EntityPlayer p = (EntityPlayer)var4;
/* 525 */       if (p.capabilities.isCreativeMode == true) {
/* 526 */         return false;
/*     */       }
/*     */       
/* 529 */       return true;
/*     */     } 
/* 531 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 536 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 537 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 4.0D, 12.0D));
/* 538 */     Collections.sort(var5, this.TargetSorter);
/* 539 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 541 */     Entity var3 = null;
/* 542 */     EntityLivingBase var4 = null;
/*     */     
/* 544 */     EntityLivingBase e = getAttackTarget();
/* 545 */     if (e != null && e.isEntityAlive()) {
/* 546 */       return e;
/*     */     }
/* 548 */     setAttackTarget(null);
/*     */ 
/*     */     
/* 551 */     while (var2.hasNext()) {
/*     */       
/* 553 */       var3 = (Entity)var2.next();
/* 554 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 556 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 558 */         return var4;
/*     */       }
/*     */     } 
/* 561 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 566 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 571 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/*     */     int k;
/* 582 */     for (k = -3; k < 3; k++) {
/*     */       
/* 584 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 586 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 588 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 589 */           if (bid == Blocks.mob_spawner) {
/* 590 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 591 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 592 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 593 */             if (s != null && 
/* 594 */               s.equals("Alien")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 601 */     if (!isValidLightLevel()) return false; 
/* 602 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) return true; 
/* 603 */     if (this.posY > 50.0D) return false;
/*     */ 
/*     */     
/* 606 */     for (k = -1; k < 2; k++) {
/*     */       
/* 608 */       for (int j = -1; j < 2; j++) {
/*     */         
/* 610 */         for (int i = 1; i < 4; i++) {
/*     */           
/* 612 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 613 */           if (bid != Blocks.air) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 625 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Alien.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */