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
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.EnumSkyBlock;
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
/*     */ public class GammaMetroid
/*     */   extends EntityTameable
/*     */ {
/*  57 */   private GenericTargetSorter TargetSorter = null;
/*  58 */   private float moveSpeed = 0.15F;
/*     */   private int closest;
/*     */   private int tx;
/*  61 */   private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage); getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.GammaMetroid_stats.attack); } protected boolean canDespawn() { if (isChild()) { enablePersistence(); return false; }  if (isTamed()) return false;  if (isNoDespawnRequired()) return false;  return true; } public boolean attackEntityAsMob(Entity par1Entity) { boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), OreSpawnMain.GammaMetroid_stats.attack); return var4; } public boolean interact(EntityPlayer par1EntityPlayer) { ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem(); if (var2 != null) if (var2.stackSize <= 0) { par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null); var2 = null; }   if (super.interact(par1EntityPlayer)) return true;  if (var2 != null && var2.getItem() == Items.iron_ingot && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) { if (!isTamed()) { if (!this.worldObj.isRemote) if (this.rand.nextInt(3) == 0) { setTamed(true); func_152115_b(par1EntityPlayer.getUniqueID().toString()); playTameEffect(true); this.worldObj.setEntityState((Entity)this, (byte)7); heal(mygetMaxHealth() - getHealth()); } else { playTameEffect(false); this.worldObj.setEntityState((Entity)this, (byte)6); }   } else if (isOwner((EntityLivingBase)par1EntityPlayer)) { if (this.worldObj.isRemote) { playTameEffect(true); this.worldObj.setEntityState((Entity)this, (byte)7); }  if (mygetMaxHealth() > getHealth()) heal(mygetMaxHealth() - getHealth());  }  if (!par1EntityPlayer.capabilities.isCreativeMode) { var2.stackSize--; if (var2.stackSize <= 0) par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);  }  return true; }  if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D && isOwner((EntityLivingBase)par1EntityPlayer)) { if (!this.worldObj.isRemote) { setTamed(false); func_152115_b(""); playTameEffect(false); this.worldObj.setEntityState((Entity)this, (byte)6); }  if (!par1EntityPlayer.capabilities.isCreativeMode) { var2.stackSize--; if (var2.stackSize <= 0) par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);  }  return true; }  if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) { setCustomNameTag(var2.getDisplayName()); if (!par1EntityPlayer.capabilities.isCreativeMode) { var2.stackSize--; if (var2.stackSize <= 0) par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);  }  return true; }  if (isTamed() && isOwner((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) { if (!isSitting()) { setSitting(true); } else { setSitting(false); }  return true; }  return false; } public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onUpdate(); } public int mygetMaxHealth() { return OreSpawnMain.GammaMetroid_stats.health; } public GammaMetroid(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 496 */     this.closest = 99999;
/* 497 */     this.tx = 0; this.ty = 0; this.tz = 0; this.moveSpeed = 0.15F; setSize(1.5F, 1.5F); getNavigator().setAvoidsWater(true); this.experienceValue = 20; this.fireResistance = 1000; this.TargetSorter = new GenericTargetSorter((Entity)this); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D)); this.tasks.addTask(2, new MyEntityAIFollowOwner(this, 2.0F, 10.0F, 2.0F)); this.tasks.addTask(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, Items.iron_ingot, false)); this.tasks.addTask(4, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D)); this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F)); this.tasks.addTask(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false)); }
/*     */   public int getTotalArmorValue() { return OreSpawnMain.GammaMetroid_stats.defense; }
/*     */   protected boolean isAIEnabled() { return true; }
/* 500 */   public void onLivingUpdate() { super.onLivingUpdate(); } protected String getLivingSound() { if (this.worldObj.rand.nextInt(5) == 1) return "orespawn:wtf_living";  return null; } protected String getHurtSound() { return "orespawn:duck_hurt"; } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 505 */     for (i = -dy; i <= dy; i++) {
/* 506 */       for (int j = -dz; j <= dz; j++) {
/* 507 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 508 */         if (bid == Blocks.stone) {
/* 509 */           int d = dx * dx + j * j + i * i;
/* 510 */           if (d < this.closest) {
/* 511 */             this.closest = d;
/* 512 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 513 */             found++;
/*     */           } 
/*     */         } 
/* 516 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 517 */         if (bid == Blocks.stone) {
/* 518 */           int d = dx * dx + j * j + i * i;
/* 519 */           if (d < this.closest) {
/* 520 */             this.closest = d;
/* 521 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 522 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 528 */     for (i = -dx; i <= dx; i++) {
/* 529 */       for (int j = -dz; j <= dz; j++) {
/* 530 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 531 */         if (bid == Blocks.stone) {
/* 532 */           int d = dy * dy + j * j + i * i;
/* 533 */           if (d < this.closest) {
/* 534 */             this.closest = d;
/* 535 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 536 */             found++;
/*     */           } 
/*     */         } 
/* 539 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 540 */         if (bid == Blocks.stone) {
/* 541 */           int d = dy * dy + j * j + i * i;
/* 542 */           if (d < this.closest) {
/* 543 */             this.closest = d;
/* 544 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 545 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 551 */     for (i = -dx; i <= dx; i++) {
/* 552 */       for (int j = -dy; j <= dy; j++) {
/* 553 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 554 */         if (bid == Blocks.stone) {
/* 555 */           int d = dz * dz + j * j + i * i;
/* 556 */           if (d < this.closest) {
/* 557 */             this.closest = d;
/* 558 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 559 */             found++;
/*     */           } 
/*     */         } 
/* 562 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 563 */         if (bid == Blocks.stone) {
/* 564 */           int d = dz * dz + j * j + i * i;
/* 565 */           if (d < this.closest) {
/* 566 */             this.closest = d;
/* 567 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 568 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 574 */     if (found != 0) return true; 
/* 575 */     return false; } protected String getDeathSound() { return "orespawn:alo_death"; } protected float getSoundVolume() { return 1.5F; }
/*     */   protected float getSoundPitch() { return 1.0F; }
/*     */   protected Item getDropItem() { return Items.iron_ingot; }
/*     */   private void dropItemRand(Item index, int par1) { EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0)); this.worldObj.spawnEntityInWorld((Entity)var3); }
/*     */   protected void dropFewItems(boolean par1, int par2) { int i = 5 + OreSpawnMain.OreSpawnRand.nextInt(10); int var4; for (var4 = 0; var4 < i; var4++) dropItemRand(Items.gold_nugget, 1);  i = 6 + OreSpawnMain.OreSpawnRand.nextInt(10); for (var4 = 0; var4 < i; var4++) dropItemRand(Items.iron_ingot, 1);  }
/*     */   protected void updateAITasks() { if (this.isDead) return;  super.updateAITasks(); if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(5) == 0) { EntityLivingBase e = findSomethingToAttack(); if (e != null) { faceEntity((Entity)e, 10.0F, 10.0F); if (getDistanceSqToEntity((Entity)e) <= 9.0D) { if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1) attackEntityAsMob((Entity)e);  } else { getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D); }  }  }  }
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) { if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;  if (par1EntityLiving == null) return false;  if (par1EntityLiving == this) return false;  if (!par1EntityLiving.isEntityAlive()) return false;  if (MyUtils.isIgnoreable(par1EntityLiving)) return false;  if (!getEntitySenses().canSee((Entity)par1EntityLiving)) return false;  if (par1EntityLiving instanceof GammaMetroid) return false;  if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityMob) return false;  if (isTamed()) return false;  if (par1EntityLiving instanceof EntityPlayer) { EntityPlayer p = (EntityPlayer)par1EntityLiving; if (p.capabilities.isCreativeMode == true) return false;  }  return true; }
/*     */   private EntityLivingBase findSomethingToAttack() { if (OreSpawnMain.PlayNicely != 0) return null;  if (isChild()) return null;  List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0D, 3.0D, 10.0D)); Collections.sort(var5, this.TargetSorter); Iterator<?> var2 = var5.iterator(); Entity var3 = null; EntityLivingBase var4 = null; while (var2.hasNext()) { var3 = (Entity)var2.next(); var4 = (EntityLivingBase)var3; if (isSuitableTarget(var4, false)) return var4;  }  return null; }
/*     */   protected boolean isValidLightLevel() { int i = MathHelper.floor_double(this.posX); int j = MathHelper.floor_double(this.boundingBox.minY); int k = MathHelper.floor_double(this.posZ); if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > this.rand.nextInt(32)) return false;  int l = this.worldObj.getBlockLightValue(i, j, k); if (this.worldObj.isThundering()) { int i1 = this.worldObj.skylightSubtracted; this.worldObj.skylightSubtracted = 10; l = this.worldObj.getBlockLightValue(i, j, k); this.worldObj.skylightSubtracted = i1; }  return (l <= this.rand.nextInt(8)); }
/*     */   public boolean getCanSpawnHere() { int k; for (k = -3; k < 3; k++) { for (int j = -3; j < 3; j++) { for (int i = 0; i < 5; i++) { Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k); if (bid == Blocks.mob_spawner) { TileEntityMobSpawner tileentitymobspawner = null; tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k); String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn(); if (s != null && s.equals("WTF?")) return true;  }  }  }  }  if (!isValidLightLevel()) return false;  if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) return true;  if (this.posY > 50.0D) return false;  for (k = -1; k < 1; k++) { for (int j = -1; j < 1; j++) { for (int i = 1; i < 4; i++) { Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k); if (bid != Blocks.air) return false;  }  }  }  return true; }
/* 585 */   protected void updateAITick() { if (this.isDead)
/* 586 */       return;  super.updateAITick();
/*     */     
/* 588 */     if ((this.worldObj.rand.nextInt(20) == 0 && getHealth() < mygetMaxHealth()) || this.worldObj.rand.nextInt(100) == 0)
/*     */     {
/*     */ 
/*     */       
/* 592 */       if (OreSpawnMain.PlayNicely == 0 && !isSitting()) {
/* 593 */         this.closest = 99999;
/* 594 */         this.tx = this.ty = this.tz = 0;
/* 595 */         for (int i = 1; i < 6; i++) {
/* 596 */           int j = i;
/* 597 */           if (j > 2) j = 2; 
/* 598 */           if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i) == true)
/* 599 */             break;  if (i >= 4) i++;
/*     */         
/*     */         } 
/* 602 */         if (this.closest < 99999) {
/*     */           
/* 604 */           getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 605 */           if (this.closest < 12) {
/*     */             
/* 607 */             if (this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2); 
/* 608 */             heal(1.0F);
/* 609 */             playSound("random.burp", 0.5F, this.worldObj.rand.nextFloat() * 0.2F + 1.5F);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 617 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GammaMetroid spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 623 */     GammaMetroid w = new GammaMetroid(this.worldObj);
/* 624 */     if (isTamed()) {
/*     */       
/* 626 */       func_152115_b(func_152113_b());
/* 627 */       w.setTamed(true);
/*     */     } 
/* 629 */     return w;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 637 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.iron_ingot);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 646 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\GammaMetroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */