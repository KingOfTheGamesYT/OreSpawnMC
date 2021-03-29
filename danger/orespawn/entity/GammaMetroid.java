/*     */ package danger.orespawn.entity;
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.util.ai.MyEntityAIFollowOwner;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
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
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class GammaMetroid extends EntityTameable {
/*  41 */   private GenericTargetSorter TargetSorter = null;
/*  42 */   private float moveSpeed = 0.15F;
/*     */   private int closest;
/*     */   private int tx;
/*  45 */   private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed); getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE); getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D); } protected boolean canDespawn() { if (isChild()) return false;  if (isTamed()) return false;  if (isNoDespawnRequired()) return false;  return true; } public boolean attackEntityAsMob(Entity entityIn) { return entityIn.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 10.0F); } public boolean processInteract(EntityPlayer player, EnumHand hand) { ItemStack item = player.inventory.getCurrentItem(); if (super.processInteract(player, hand)) return true;  if (item.getItem() == Items.IRON_INGOT && player.getDistance((Entity)this) < 25.0D && !isTamed() && !this.world.isRemote) if (this.rand.nextInt(3) == 0) { setTamed(true); playTameEffect(true); this.world.setEntityState((Entity)this, (byte)7); heal(mygetMaxHealth() - getHealth()); } else { playTameEffect(false); this.world.setEntityState((Entity)this, (byte)6); }   return false; } private int mygetMaxHealth() { return 100; } public GammaMetroid(World worldIn) { super(worldIn);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 345 */     this.closest = 99999;
/* 346 */     this.tx = 0; this.ty = 0; this.tz = 0; this.moveSpeed = 0.15F; setSize(1.5F, 1.5F); this.experienceValue = 20; this.TargetSorter = new GenericTargetSorter((Entity)this); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new MyEntityAIFollowOwner(this, 2.0F, 10.0F, 2.0F)); this.tasks.addTask(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, Items.IRON_INGOT, false)); this.tasks.addTask(4, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D)); this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F)); this.tasks.addTask(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0])); }
/*     */   public int getTotalArmorValue() { return super.getTotalArmorValue(); }
/*     */   public boolean isAIDisabled() { return false; }
/* 349 */   @Nullable protected SoundEvent getAmbientSound() { if (this.world.rand.nextInt(5) == 1) return SoundsHandler.ENTITY_GAMMAMETROID_LIVING;  return null; } @Nullable protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundsHandler.ENTITY_DUCK_HURT; } private boolean scanIt(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 354 */     for (i = -dy; i <= dy; i++) {
/* 355 */       for (int j = -dz; j <= dz; j++) {
/* 356 */         BlockPos pos = new BlockPos(x + dx, y + i, z + j);
/* 357 */         Block bid = this.world.getBlockState(pos).getBlock();
/* 358 */         if (bid == Blocks.STONE) {
/* 359 */           int d = dx * dx + j * j + i * i;
/* 360 */           if (d < this.closest) {
/* 361 */             this.closest = d;
/* 362 */             this.tx = x + dx;
/* 363 */             this.ty = y + i;
/* 364 */             this.tz = z + j;
/* 365 */             found++;
/*     */           } 
/*     */         } 
/* 368 */         pos = new BlockPos(x - dx, y + i, z + j);
/* 369 */         bid = this.world.getBlockState(pos).getBlock();
/* 370 */         if (bid == Blocks.STONE) {
/* 371 */           int d = dx * dx + j * j + i * i;
/* 372 */           if (d < this.closest) {
/* 373 */             this.closest = d;
/* 374 */             this.tx = x - dx;
/* 375 */             this.ty = y + i;
/* 376 */             this.tz = z + j;
/* 377 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 383 */     for (i = -dx; i <= dx; i++) {
/* 384 */       for (int j = -dz; j <= dz; j++) {
/* 385 */         BlockPos pos = new BlockPos(x + i, y + dy, z + j);
/* 386 */         Block bid = this.world.getBlockState(pos).getBlock();
/* 387 */         if (bid == Blocks.STONE) {
/* 388 */           int d = dy * dy + j * j + i * i;
/* 389 */           if (d < this.closest) {
/* 390 */             this.closest = d;
/* 391 */             this.tx = x + i;
/* 392 */             this.ty = y + dy;
/* 393 */             this.tz = z + j;
/* 394 */             found++;
/*     */           } 
/*     */         } 
/* 397 */         pos = new BlockPos(x + i, y - dy, z + j);
/* 398 */         bid = this.world.getBlockState(pos).getBlock();
/* 399 */         if (bid == Blocks.STONE) {
/* 400 */           int d = dy * dy + j * j + i * i;
/* 401 */           if (d < this.closest) {
/* 402 */             this.closest = d;
/* 403 */             this.tx = x + i;
/* 404 */             this.ty = y - dy;
/* 405 */             this.tz = z + j;
/* 406 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 412 */     for (i = -dx; i <= dx; i++) {
/* 413 */       for (int j = -dy; j <= dy; j++) {
/* 414 */         BlockPos pos = new BlockPos(x + i, y + j, z + dz);
/* 415 */         Block bid = this.world.getBlockState(pos).getBlock();
/* 416 */         if (bid == Blocks.STONE) {
/* 417 */           int d = dz * dz + j * j + i * i;
/* 418 */           if (d < this.closest) {
/* 419 */             this.closest = d;
/* 420 */             this.tx = x + i;
/* 421 */             this.ty = y + j;
/* 422 */             this.tz = z + dz;
/* 423 */             found++;
/*     */           } 
/*     */         } 
/* 426 */         pos = new BlockPos(x + i, y + j, z - dz);
/* 427 */         bid = this.world.getBlockState(pos).getBlock();
/* 428 */         if (bid == Blocks.STONE) {
/* 429 */           int d = dz * dz + j * j + i * i;
/* 430 */           if (d < this.closest) {
/* 431 */             this.closest = d;
/* 432 */             this.tx = x + i;
/* 433 */             this.ty = y + j;
/* 434 */             this.tz = z - dz;
/* 435 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 441 */     if (found != 0) return true; 
/* 442 */     return false; } @Nullable protected SoundEvent getDeathSound() { return SoundsHandler.ENTITY_ALOSAURUS_DEATH; }
/*     */   protected float getSoundVolume() { return 1.5F; }
/*     */   protected float getSoundPitch() { return 1.0F; }
/*     */   @Nullable protected Item getDropItem() { return Items.IRON_INGOT; }
/*     */   private void dropItemRand(Item item, int par1) { EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(item, par1, 0));
/*     */     this.world.spawnEntity((Entity)var3); }
/* 448 */   public void onUpdate() { if (this.isDead)
/* 449 */       return;  getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/* 450 */     super.onUpdate();
/*     */     
/* 452 */     if (((this.world.rand.nextInt(20) == 0 && getHealth() < mygetMaxHealth()) || this.world.rand.nextInt(100) == 0) && 
/* 453 */       OreSpawnMain.PlayNicely == 0 && !isSitting())
/* 454 */     { this.closest = 99999;
/* 455 */       this.tx = this.ty = this.tz = 0;
/* 456 */       for (int i = 1; i < 6; i++) {
/* 457 */         int j = i;
/* 458 */         if (j > 2) j = 2; 
/* 459 */         if (scanIt((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i))
/* 460 */           break;  if (i >= 4) i++;
/*     */       
/*     */       } 
/* 463 */       if (this.closest < 99999)
/* 464 */       { getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 465 */         if (this.closest < 12)
/* 466 */         { BlockPos pos = new BlockPos(this.tx, this.ty, this.tz);
/* 467 */           if (this.world.getGameRules().getBoolean("mobGriefing") && isServerWorld())
/* 468 */           { this.world.setBlockToAir(pos);
/* 469 */             heal(1.0F);
/* 470 */             playSound(SoundEvents.ENTITY_PLAYER_BURP, 0.5F, this.world.rand.nextFloat() * 0.2F + 1.5F); }  }  }  }  } protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) { int i = 5 + OreSpawnMain.OreSpawnRand.nextInt(10); int var4; for (var4 = 0; var4 < i; var4++) dropItemRand(Items.GOLD_NUGGET, 1);  i = 6 + OreSpawnMain.OreSpawnRand.nextInt(10); for (var4 = 0; var4 < i; var4++) dropItemRand(Items.IRON_INGOT, 1);  }
/*     */   protected void updateAITasks() { if (this.isDead) return;  super.updateAITasks(); if (this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.world.rand.nextInt(5) == 0) { EntityLivingBase e = findSomethingToAttack(); if (e != null) { faceEntity((Entity)e, 10.0F, 10.0F); if (getDistance((Entity)e) <= 9.0F) { if (this.world.rand.nextInt(4) == 0 || this.world.rand.nextInt(5) == 1) attackEntityAsMob((Entity)e);  } else { getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D); }  }  }  }
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) { if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL) return false;  if (par1EntityLiving == null) return false;  if (par1EntityLiving == this) return false;  if (!par1EntityLiving.isEntityAlive()) return false;  if (!getEntitySenses().canSee((Entity)par1EntityLiving)) return false;  if (par1EntityLiving instanceof GammaMetroid) return false;  if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityMob) return false;  if (isTamed()) return false;  if (par1EntityLiving instanceof EntityPlayer) { EntityPlayer p = (EntityPlayer)par1EntityLiving; if (p.capabilities.isCreativeMode == true)
/*     */         return false;  }  return true; }
/*     */   private EntityLivingBase findSomethingToAttack() { if (OreSpawnMain.PlayNicely != 0)
/*     */       return null;  if (isChild())
/*     */       return null;  List<?> var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(10.0D, 3.0D, 10.0D)); Collections.sort(var5, this.TargetSorter); Iterator<?> var2 = var5.iterator(); Entity var3 = null; EntityLivingBase var4 = null; while (var2.hasNext()) { var3 = (Entity)var2.next(); var4 = (EntityLivingBase)var3; if (isSuitableTarget(var4, false))
/*     */         return var4;  }  return null; }
/*     */   public boolean getCanSpawnHere() { if (this.posY > 50.0D)
/*     */       return false;  return true; }
/* 480 */   private boolean canPlaceBlock(World p_188518_1_, BlockPos p_188518_2_, Block p_188518_3_, IBlockState p_188518_4_, IBlockState p_188518_5_) { if (!p_188518_3_.canPlaceBlockAt(p_188518_1_, p_188518_2_))
/*     */     {
/* 482 */       return false;
/*     */     }
/* 484 */     if (p_188518_4_.getMaterial() != Material.AIR)
/*     */     {
/* 486 */       return false;
/*     */     }
/* 488 */     if (p_188518_5_.getMaterial() == Material.AIR)
/*     */     {
/* 490 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 494 */     return p_188518_5_.isFullCube(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public EntityAgeable createChild(EntityAgeable ageable) {
/* 501 */     return (EntityAgeable)spawnBabyAnimal(ageable);
/*     */   }
/*     */   
/*     */   private GammaMetroid spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 505 */     GammaMetroid w = new GammaMetroid(this.world);
/* 506 */     if (isTamed()) {
/* 507 */       w.setTamed(true);
/*     */     }
/* 509 */     return w;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInLove(@Nullable EntityPlayer player) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack stack) {
/* 524 */     return (stack.getItem() == Items.IRON_INGOT);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/* 529 */     super.entityInit();
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\GammaMetroid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */