/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.init.ModBlocks;
/*     */ import danger.orespawn.util.ai.MyEntityAIWanderALot;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.annotation.Nullable;
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
/*     */ import net.minecraft.init.MobEffects;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.datasync.DataParameter;
/*     */ import net.minecraft.network.datasync.DataSerializers;
/*     */ import net.minecraft.network.datasync.EntityDataManager;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
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
/*     */ public class Alien
/*     */   extends EntityMob
/*     */ {
/*  68 */   protected static final DataParameter<Byte> ATTACKING = EntityDataManager.createKey(Alosaurus.class, DataSerializers.BYTE);
/*     */   private GenericTargetSorter TargetSorter;
/*     */   private RenderInfo renderdata;
/*  71 */   private int hurt_timer = 0;
/*  72 */   private double moveSpeed = 0.65D;
/*     */   private int closest;
/*     */   private int tx;
/*     */   private int ty;
/*  76 */   private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed); getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D); } protected void entityInit() { super.entityInit(); this.dataManager.register(ATTACKING, Byte.valueOf((byte)0)); if (this.renderdata == null) this.renderdata = new RenderInfo();  this.renderdata.rf1 = 0.0F; this.renderdata.rf2 = 0.0F; this.renderdata.rf3 = 0.0F; this.renderdata.rf4 = 0.0F; this.renderdata.ri1 = 0; this.renderdata.ri2 = 0; this.renderdata.ri3 = 0; this.renderdata.ri4 = 0; } protected boolean canDespawn() { if (isNoDespawnRequired()) return false;  return true; } public int mygetMaxHealth() { return 100; } protected void jump() { super.jump(); this.motionY += 0.25D; } public Alien(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 365 */     this.closest = 99999;
/* 366 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(1.1F, 3.25F); this.experienceValue = 100; this.isImmuneToFire = false; this.jumpMovementFactor = 0.6F; this.TargetSorter = new GenericTargetSorter((Entity)this); this.renderdata = new RenderInfo(); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false)); this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D)); this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F)); this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0])); }
/*     */   public RenderInfo getRenderInfo() { return this.renderdata; }
/*     */   public void setRenderInfo(RenderInfo r) { this.renderdata.rf1 = r.rf1; this.renderdata.rf2 = r.rf2; this.renderdata.rf3 = r.rf3; this.renderdata.rf4 = r.rf4; this.renderdata.ri1 = r.ri1; this.renderdata.ri2 = r.ri2; this.renderdata.ri3 = r.ri3; this.renderdata.ri4 = r.ri4; }
/* 369 */   public int getTotalArmorValue() { return 8; } public boolean isAIDisabled() { return false; } public void onLivingUpdate() { super.onLivingUpdate(); if (this.world.isRemote) { float f = 1.7F + Math.abs(this.world.rand.nextFloat() * 0.75F); if (this.world.rand.nextInt(20) == 1) this.world.spawnParticle(EnumParticleTypes.DRIP_LAVA, this.posX - f * Math.sin(Math.toRadians(this.rotationYawHead)), this.posY + 1.6D, this.posZ + f * Math.cos(Math.toRadians(this.rotationYawHead)), 0.0D, 0.0D, 0.0D, new int[0]);  }  } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 374 */     for (i = -dy; i <= dy; i++) {
/* 375 */       for (int j = -dz; j <= dz; j++) {
/* 376 */         Block bid = this.world.getBlockState(new BlockPos(x + dx, y + i, z + j)).getBlock();
/*     */         
/* 378 */         if (bid == Blocks.TORCH || bid == ModBlocks.EXTREME_TORCH) {
/* 379 */           int d = dx * dx + j * j + i * i;
/* 380 */           if (d < this.closest) {
/* 381 */             this.closest = d;
/* 382 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 383 */             found++;
/*     */           } 
/*     */         } 
/* 386 */         bid = this.world.getBlockState(new BlockPos(x - dx, y + i, z + j)).getBlock();
/*     */         
/* 388 */         if (bid == Blocks.TORCH || bid == ModBlocks.EXTREME_TORCH) {
/* 389 */           int d = dx * dx + j * j + i * i;
/* 390 */           if (d < this.closest) {
/* 391 */             this.closest = d;
/* 392 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 393 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 399 */     for (i = -dx; i <= dx; i++) {
/* 400 */       for (int j = -dz; j <= dz; j++) {
/* 401 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + dy, z + j)).getBlock();
/*     */         
/* 403 */         if (bid == Blocks.TORCH || bid == ModBlocks.EXTREME_TORCH) {
/* 404 */           int d = dy * dy + j * j + i * i;
/* 405 */           if (d < this.closest) {
/* 406 */             this.closest = d;
/* 407 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 408 */             found++;
/*     */           } 
/*     */         } 
/* 411 */         bid = this.world.getBlockState(new BlockPos(x + i, y - dy, z + j)).getBlock();
/*     */         
/* 413 */         if (bid == Blocks.TORCH || bid == ModBlocks.EXTREME_TORCH) {
/* 414 */           int d = dy * dy + j * j + i * i;
/* 415 */           if (d < this.closest) {
/* 416 */             this.closest = d;
/* 417 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 418 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 424 */     for (i = -dx; i <= dx; i++) {
/* 425 */       for (int j = -dy; j <= dy; j++) {
/* 426 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + j, z + dz)).getBlock();
/*     */         
/* 428 */         if (bid == Blocks.TORCH) {
/* 429 */           int d = dz * dz + j * j + i * i;
/* 430 */           if (d < this.closest) {
/* 431 */             this.closest = d;
/* 432 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 433 */             found++;
/*     */           } 
/*     */         } 
/* 436 */         bid = this.world.getBlockState(new BlockPos(x + i, y + j, z - dz)).getBlock();
/*     */         
/* 438 */         if (bid == Blocks.TORCH) {
/* 439 */           int d = dz * dz + j * j + i * i;
/* 440 */           if (d < this.closest) {
/* 441 */             this.closest = d;
/* 442 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 443 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 449 */     if (found != 0) return true; 
/* 450 */     return false; } public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed); super.onUpdate(); }
/*     */   public int getAlienHealth() { return (int)getHealth(); }
/*     */   @Nullable protected SoundEvent getAmbientSound() { if (this.world.rand.nextInt(4) == 0)
/*     */       return SoundsHandler.ENTITY_ALIEN_LIVING;  return null; }
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundsHandler.ENTITY_ALIEN_HURT; }
/*     */   protected float getSoundVolume() { return 1.0F; }
/* 456 */   protected void updateAITasks() { if (this.isDead)
/* 457 */       return;  super.updateAITasks();
/* 458 */     if (this.hurt_timer > 0) this.hurt_timer--; 
/* 459 */     if (this.world.rand.nextInt(8) == 0) {
/* 460 */       EntityLivingBase e = findSomethingToAttack();
/* 461 */       if (e != null) {
/* 462 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 463 */         if (getDistanceSq((Entity)e) < 16.0D) {
/* 464 */           setAttacking(1);
/*     */           
/* 466 */           if (this.world.rand.nextInt(4) == 0 || this.world.rand.nextInt(5) == 1)
/*     */           {
/* 468 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } 
/* 471 */         getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */       } else {
/*     */         
/* 474 */         setAttacking(0);
/*     */       }
/*     */     
/* 477 */     } else if (this.rand.nextInt(30) == 0 && OreSpawnMain.PlayNicely == 0) {
/*     */       
/* 479 */       this.closest = 99999;
/* 480 */       this.tx = this.ty = this.tz = 0;
/*     */       
/* 482 */       for (int i = 2; i < 15 && 
/* 483 */         !scan_it((int)this.posX, (int)this.posY, (int)this.posZ, i, i, i); i++) {
/* 484 */         if (i >= 10) i++;
/*     */       
/*     */       } 
/* 487 */       if (this.closest < 99999) {
/* 488 */         getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 489 */         if (this.closest < 27 && 
/* 490 */           this.world.getGameRules().getBoolean("mobGriefing")) this.world.setBlockState(new BlockPos(this.tx, this.ty, this.tz), Blocks.AIR.getDefaultState());
/*     */       
/*     */       } 
/*     */     } 
/*     */     
/* 495 */     if (this.world.rand.nextInt(40) == 1 && 
/* 496 */       getHealth() < mygetMaxHealth())
/*     */     {
/* 498 */       heal(1.0F); }  } protected float getSoundPitch() { return 1.0F; }
/*     */   protected Item getDropItem() { return Items.SPIDER_EYE; }
/*     */   private void dropItemRand(Item index, int par1) { EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0)); this.world.spawnEntity((Entity)var3); }
/*     */   protected void dropFewItems(boolean par1, int par2) { int var5 = 5 + this.world.rand.nextInt(6); int var4; for (var4 = 0; var4 < var5; var4++)
/*     */       dropItemRand(Items.SPIDER_EYE, 1);  var5 = 5 + this.world.rand.nextInt(6); for (var4 = 0; var4 < var5; var4++)
/*     */       dropItemRand(Items.FLINT, 1);  dropItemRand((Item)Items.MAP, 1); dropItemRand(Items.CLOCK, 1); dropItemRand(Items.COMPASS, 1); }
/*     */   public boolean attackEntityAsMob(Entity par1Entity) { if (super.attackEntityAsMob(par1Entity)) { if (par1Entity != null && par1Entity instanceof EntityLivingBase) { int var2 = 6; if (this.world.getDifficulty() == EnumDifficulty.EASY) { var2 = 8; if (this.world.getDifficulty() == EnumDifficulty.NORMAL) { var2 = 10; } else if (this.world.getDifficulty() == EnumDifficulty.HARD) { var2 = 12; }  }  if (par1Entity instanceof EntityLivingBase && this.world.rand.nextInt(5) == 1)
/*     */           ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(MobEffects.POISON, var2 * 5, 0));  double ks = 1.1D; double inair = 0.1D; float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX); if (par1Entity.isDead || par1Entity instanceof EntityPlayer)
/*     */           inair *= 2.0D;  par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks); }  return true; }
/*     */      return false; }
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { boolean ret = false; if (par1DamageSource.getDamageType().equals("cactus"))
/*     */       return false;  if (this.hurt_timer <= 0)
/*     */       ret = super.attackEntityFrom(par1DamageSource, par2);  Entity e = par1DamageSource.getTrueSource(); if (e != null && e instanceof EntityLiving) { setAttackTarget((EntityLivingBase)e); getNavigator().tryMoveToEntityLiving(e, 1.2D); ret = true; }
/*     */      return ret; }
/* 512 */   private boolean isSuitableTarget(EntityLivingBase var4, boolean par2) { if (var4 == null)
/*     */     {
/* 514 */       return false;
/*     */     }
/* 516 */     if (var4 == this)
/*     */     {
/* 518 */       return false;
/*     */     }
/* 520 */     if (!var4.isEntityAlive())
/*     */     {
/* 522 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 529 */     if (var4 instanceof EntityPlayer) {
/*     */       
/* 531 */       EntityPlayer p = (EntityPlayer)var4;
/* 532 */       if (p.capabilities.isCreativeMode == true) {
/* 533 */         return false;
/*     */       }
/*     */       
/* 536 */       return true;
/*     */     } 
/* 538 */     return false; }
/*     */ 
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 543 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 544 */     List<?> var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(12.0D, 4.0D, 12.0D));
/* 545 */     Collections.sort(var5, this.TargetSorter);
/* 546 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 548 */     Entity var3 = null;
/* 549 */     EntityLivingBase var4 = null;
/*     */     
/* 551 */     EntityLivingBase e = getAttackTarget();
/* 552 */     if (e != null && e.isEntityAlive()) {
/* 553 */       return e;
/*     */     }
/* 555 */     setAttackTarget(null);
/*     */ 
/*     */     
/* 558 */     while (var2.hasNext()) {
/*     */       
/* 560 */       var3 = (Entity)var2.next();
/* 561 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 563 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 565 */         return var4;
/*     */       }
/*     */     } 
/* 568 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 573 */     return ((Byte)this.dataManager.get(ATTACKING)).byteValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 579 */     this.dataManager.set(ATTACKING, Byte.valueOf((byte)par1));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 612 */     if (!isValidLightLevel()) return false;
/*     */     
/* 614 */     if (this.posY > 50.0D) return false;
/*     */ 
/*     */     
/* 617 */     for (int k = -1; k < 2; k++) {
/*     */       
/* 619 */       for (int j = -1; j < 2; j++) {
/*     */         
/* 621 */         for (int i = 1; i < 4; i++) {
/*     */           
/* 623 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/*     */           
/* 625 */           if (bid != Blocks.AIR) return false;
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
/* 637 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\Alien.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */