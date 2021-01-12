/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityList;
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
/*     */ public class CaterKiller
/*     */   extends EntityMob
/*     */ {
/*  53 */   private GenericTargetSorter TargetSorter = null;
/*  54 */   private float moveSpeed = 0.35F;
/*  55 */   int foundmob = 0;
/*  56 */   int ticker = 0; private int closest; private int tx;
/*     */   private int ty;
/*     */   private int tz;
/*     */   
/*  60 */   public CaterKiller(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 387 */     this.closest = 99999;
/* 388 */     this.tx = 0; this.ty = 0; this.tz = 0; if (OreSpawnMain.PlayNicely == 0) { setSize(2.9F, 4.6F); } else { setSize(1.45F, 2.3F); }  getNavigator().setAvoidsWater(true); this.experienceValue = 200; this.fireResistance = 100; this.TargetSorter = new GenericTargetSorter((Entity)this); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false)); this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D)); this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F)); this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false)); } protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.CaterKiller_stats.attack); } protected void entityInit() { super.entityInit(); this.dataWatcher.addObject(20, Byte.valueOf((byte)0)); this.dataWatcher.addObject(21, Integer.valueOf(OreSpawnMain.PlayNicely)); } public int getPlayNicely() { return this.dataWatcher.getWatchableObjectInt(21); } protected boolean canDespawn() { if (isNoDespawnRequired()) return false;  return true; } public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { Entity e = null; Boolean ret = Boolean.valueOf(super.attackEntityFrom(par1DamageSource, par2)); e = par1DamageSource.getEntity(); if (e != null && e instanceof EntityLiving) setAttackTarget((EntityLivingBase)e);  return ret.booleanValue(); } public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onUpdate(); } public int mygetMaxHealth() { return OreSpawnMain.CaterKiller_stats.health; } public int getTotalArmorValue() { return OreSpawnMain.CaterKiller_stats.defense; } protected boolean isAIEnabled() { return true; }
/*     */   public void onLivingUpdate() { super.onLivingUpdate(); }
/*     */   protected String getLivingSound() { if (this.rand.nextInt(3) == 0) return "orespawn:caterkiller_living";  return null; }
/* 391 */   private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 396 */     for (i = -dy; i <= dy; i++) {
/* 397 */       for (int j = -dz; j <= dz; j++) {
/* 398 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 399 */         if (bid == Blocks.leaves || bid == Blocks.vine || bid == Blocks.log || bid == OreSpawnMain.MyDT || bid == Blocks.log2 || bid == Blocks.leaves2 || bid == OreSpawnMain.MyAppleLeaves || bid == OreSpawnMain.MyExperienceLeaves || bid == OreSpawnMain.MyScaryLeaves || bid == OreSpawnMain.MyPeachLeaves || bid == OreSpawnMain.MyCherryLeaves) {
/*     */ 
/*     */           
/* 402 */           int d = dx * dx + j * j + i * i;
/* 403 */           if (d < this.closest) {
/* 404 */             this.closest = d;
/* 405 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 406 */             found++;
/*     */           } 
/*     */         } 
/* 409 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 410 */         if (bid == Blocks.leaves || bid == Blocks.vine || bid == Blocks.log || bid == OreSpawnMain.MyDT || bid == Blocks.log2 || bid == Blocks.leaves2 || bid == OreSpawnMain.MyAppleLeaves || bid == OreSpawnMain.MyExperienceLeaves || bid == OreSpawnMain.MyScaryLeaves || bid == OreSpawnMain.MyPeachLeaves || bid == OreSpawnMain.MyCherryLeaves) {
/*     */ 
/*     */           
/* 413 */           int d = dx * dx + j * j + i * i;
/* 414 */           if (d < this.closest) {
/* 415 */             this.closest = d;
/* 416 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 417 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 423 */     for (i = -dx; i <= dx; i++) {
/* 424 */       for (int j = -dz; j <= dz; j++) {
/* 425 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 426 */         if (bid == Blocks.leaves || bid == Blocks.vine || bid == Blocks.log || bid == OreSpawnMain.MyDT || bid == Blocks.log2 || bid == Blocks.leaves2 || bid == OreSpawnMain.MyAppleLeaves || bid == OreSpawnMain.MyExperienceLeaves || bid == OreSpawnMain.MyScaryLeaves || bid == OreSpawnMain.MyPeachLeaves || bid == OreSpawnMain.MyCherryLeaves) {
/*     */ 
/*     */           
/* 429 */           int d = dy * dy + j * j + i * i;
/* 430 */           if (d < this.closest) {
/* 431 */             this.closest = d;
/* 432 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 433 */             found++;
/*     */           } 
/*     */         } 
/* 436 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 437 */         if (bid == Blocks.leaves || bid == Blocks.vine || bid == Blocks.log || bid == OreSpawnMain.MyDT || bid == Blocks.log2 || bid == Blocks.leaves2 || bid == OreSpawnMain.MyAppleLeaves || bid == OreSpawnMain.MyExperienceLeaves || bid == OreSpawnMain.MyScaryLeaves || bid == OreSpawnMain.MyPeachLeaves || bid == OreSpawnMain.MyCherryLeaves) {
/*     */ 
/*     */           
/* 440 */           int d = dy * dy + j * j + i * i;
/* 441 */           if (d < this.closest) {
/* 442 */             this.closest = d;
/* 443 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 444 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 450 */     for (i = -dx; i <= dx; i++) {
/* 451 */       for (int j = -dy; j <= dy; j++) {
/* 452 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 453 */         if (bid == Blocks.leaves || bid == Blocks.vine || bid == Blocks.log || bid == OreSpawnMain.MyDT || bid == Blocks.log2 || bid == Blocks.leaves2 || bid == OreSpawnMain.MyAppleLeaves || bid == OreSpawnMain.MyExperienceLeaves || bid == OreSpawnMain.MyScaryLeaves || bid == OreSpawnMain.MyPeachLeaves || bid == OreSpawnMain.MyCherryLeaves) {
/*     */ 
/*     */           
/* 456 */           int d = dz * dz + j * j + i * i;
/* 457 */           if (d < this.closest) {
/* 458 */             this.closest = d;
/* 459 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 460 */             found++;
/*     */           } 
/*     */         } 
/* 463 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 464 */         if (bid == Blocks.leaves || bid == Blocks.vine || bid == Blocks.log || bid == OreSpawnMain.MyDT || bid == Blocks.log2 || bid == Blocks.leaves2 || bid == OreSpawnMain.MyAppleLeaves || bid == OreSpawnMain.MyExperienceLeaves || bid == OreSpawnMain.MyScaryLeaves || bid == OreSpawnMain.MyPeachLeaves || bid == OreSpawnMain.MyCherryLeaves) {
/*     */ 
/*     */           
/* 467 */           int d = dz * dz + j * j + i * i;
/* 468 */           if (d < this.closest) {
/* 469 */             this.closest = d;
/* 470 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 471 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 477 */     if (found != 0) return true; 
/* 478 */     return false; }
/*     */   protected String getHurtSound() { return "orespawn:caterkiller_hit"; }
/*     */   protected String getDeathSound() { return "orespawn:caterkiller_death"; }
/*     */   protected float getSoundVolume() { return 1.5F; }
/*     */   protected float getSoundPitch() { return 1.0F; }
/*     */   protected Item getDropItem() { return Items.beef; }
/*     */   private ItemStack dropItemRand(Item index, int par1) { EntityItem var3 = null; ItemStack is = new ItemStack(index, par1, 0); var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), is); if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3);  return is; }
/*     */   protected void dropFewItems(boolean par1, int par2) { ItemStack is = null; dropItemRand(OreSpawnMain.CaterKillerJaw, 1); dropItemRand(Items.item_frame, 1); int var4; for (var4 = 0; var4 < 10; var4++) dropItemRand(Items.leather, 1);  for (var4 = 0; var4 < 6; var4++) dropItemRand(Items.beef, 1);  int i = 1 + this.worldObj.rand.nextInt(5); for (var4 = 0; var4 < i; var4++) { int var3 = this.worldObj.rand.nextInt(20); switch (var3) { case 0: is = dropItemRand(OreSpawnMain.MyUltimateSword, 1); break;case 1: is = dropItemRand(OreSpawnMain.MyRuby, 1); break;case 2: is = dropItemRand(Item.getItemFromBlock(Blocks.diamond_block), 1); break;case 3: is = dropItemRand(OreSpawnMain.MyRubySword, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));  break;case 4: is = dropItemRand(OreSpawnMain.MyRubyShovel, 1); if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));  break;case 5: is = dropItemRand(OreSpawnMain.MyRubyPickaxe, 1); if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));  break;case 6: is = dropItemRand(OreSpawnMain.MyRubyAxe, 1); if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));  break;case 7: is = dropItemRand(OreSpawnMain.MyRubyHoe, 1); if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));  break;case 8: is = dropItemRand((Item)OreSpawnMain.RubyHelmet, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));  break;case 9: is = dropItemRand((Item)OreSpawnMain.RubyBody, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  break;case 10: is = dropItemRand((Item)OreSpawnMain.RubyLegs, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  break;case 11: is = dropItemRand((Item)OreSpawnMain.RubyBoots, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  break;case 12: is = dropItemRand(OreSpawnMain.MyUltimateBow, 1); break; }  }  for (var4 = 0; var4 < 25; var4++)
/* 486 */       spawnCreature(this.worldObj, "Butterfly", this.posX, this.posY + 1.0D, this.posZ);  } protected void updateAITasks() { if (this.isDead)
/* 487 */       return;  super.updateAITasks();
/* 488 */     this.dataWatcher.updateObject(21, Integer.valueOf(OreSpawnMain.PlayNicely));
/*     */     
/* 490 */     if (getHealth() + 1.0F < getMaxHealth()) {
/* 491 */       this.ticker++;
/* 492 */       if (this.ticker > 2400) {
/* 493 */         spawnCreature(this.worldObj, "Brutalfly", this.posX, this.posY + 4.0D, this.posZ);
/* 494 */         playSound("random.explode", 1.0F, this.worldObj.rand.nextFloat() * 0.2F + 0.9F);
/* 495 */         for (int i = 0; i < 10; i++) {
/* 496 */           spawnCreature(this.worldObj, "Butterfly", this.posX, this.posY + 1.0D + this.worldObj.rand.nextInt(4), this.posZ);
/*     */         }
/* 498 */         setDead();
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 503 */     if (this.isInWeb) {
/* 504 */       for (int i = -2; i <= 2; i++) {
/* 505 */         for (int j = -1; j < 5; j++) {
/* 506 */           for (int k = -2; k <= 2; k++) {
/* 507 */             if (this.worldObj.getBlock((int)this.posX + i, (int)this.posY + j, (int)this.posZ + k) == Blocks.web) {
/* 508 */               this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j, (int)this.posZ + k, Blocks.air);
/* 509 */               this.worldObj.setBlockMetadataWithNotify((int)this.posX + i, (int)this.posY + j, (int)this.posZ + k, 0, 3);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 514 */       this.isInWeb = false;
/*     */     } 
/* 516 */     if (this.worldObj.rand.nextInt(4) == 0) {
/*     */       
/* 518 */       EntityLivingBase e = getAttackTarget();
/* 519 */       if (e != null && !e.isEntityAlive()) {
/* 520 */         setAttackTarget(null);
/* 521 */         e = null;
/*     */       } 
/* 523 */       if (this.worldObj.rand.nextInt(200) == 0) {
/* 524 */         setAttackTarget(null);
/*     */       }
/* 526 */       if (e == null) {
/* 527 */         e = findSomethingToAttack();
/*     */       }
/* 529 */       if (e != null) {
/* 530 */         this.foundmob = 1;
/* 531 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 532 */         if (getDistanceSqToEntity((Entity)e) < ((5.0F + e.width / 2.0F) * (5.0F + e.width / 2.0F))) {
/* 533 */           setAttacking(1);
/*     */           
/* 535 */           if (this.worldObj.rand.nextInt(3) == 0 || this.worldObj.rand.nextInt(4) == 1)
/*     */           {
/* 537 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 540 */           setAttacking(0);
/* 541 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/* 542 */           if (this.worldObj.rand.nextInt(4) == 0) {
/* 543 */             double dx = e.posX;
/* 544 */             double dz = e.posZ;
/* 545 */             dx += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0D;
/* 546 */             dz += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0D;
/* 547 */             for (int i = 2; i > -2; i--) {
/* 548 */               if (this.worldObj.getBlock((int)dx, (int)e.posY + i + 1, (int)dz) == Blocks.air && 
/* 549 */                 this.worldObj.getBlock((int)dx, (int)e.posY + i, (int)dz) != Blocks.air) {
/* 550 */                 this.worldObj.setBlock((int)dx, (int)e.posY + i + 1, (int)dz, Blocks.web);
/*     */ 
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } else {
/* 559 */         setAttacking(0);
/* 560 */         this.foundmob = 0;
/*     */       } 
/*     */     } 
/* 563 */     if ((this.worldObj.rand.nextInt(8) == 0 && getHealth() < mygetMaxHealth()) || this.worldObj.rand.nextInt(30) == 0)
/*     */     {
/*     */ 
/*     */       
/* 567 */       if (OreSpawnMain.PlayNicely == 0) {
/* 568 */         this.closest = 99999;
/* 569 */         this.tx = this.ty = this.tz = 0;
/* 570 */         for (int i = 1; i < 13; i++) {
/* 571 */           int j = i;
/* 572 */           if (j > 9) j = 9; 
/* 573 */           if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i) == true)
/* 574 */             break;  if (i >= 9) i++;
/*     */         
/*     */         } 
/* 577 */         if (this.closest < 99999) {
/*     */           
/* 579 */           if (this.foundmob == 0) getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D); 
/* 580 */           if (this.closest < 81) {
/*     */             
/* 582 */             if (this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2); 
/* 583 */             heal(2.0F);
/* 584 */             if (this.worldObj.rand.nextInt(20) == 1) playSound("random.burp", 1.0F, this.worldObj.rand.nextFloat() * 0.2F + 0.9F); 
/*     */           } 
/*     */         } 
/*     */       }  }  } public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/*     */     Entity var8 = null;
/*     */     if (par0World == null)
/*     */       return null; 
/*     */     var8 = EntityList.createEntityByName(par1, par0World);
/*     */     if (var8 != null) {
/*     */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */       par0World.spawnEntityInWorld(var8);
/*     */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     return var8;
/*     */   } private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 599 */     if (par1EntityLiving == null)
/*     */     {
/* 601 */       return false;
/*     */     }
/* 603 */     if (par1EntityLiving == this)
/*     */     {
/* 605 */       return false;
/*     */     }
/* 607 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 609 */       return false;
/*     */     }
/*     */     
/* 612 */     if (!MyCanSee(par1EntityLiving))
/*     */     {
/*     */       
/* 615 */       return false;
/*     */     }
/*     */     
/* 618 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 620 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 621 */       if (p.capabilities.isCreativeMode == true) {
/* 622 */         return false;
/*     */       }
/* 624 */       return true;
/*     */     } 
/* 626 */     if (par1EntityLiving instanceof CaterKiller)
/*     */     {
/* 628 */       return false;
/*     */     }
/*     */     
/* 631 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 633 */       return true;
/*     */     }
/*     */     
/* 636 */     if (MyUtils.isAttackableNonMob(par1EntityLiving)) {
/* 637 */       return true;
/*     */     }
/*     */     
/* 640 */     return false; } public void initCreature() {} public boolean interact(EntityPlayer par1EntityPlayer) { return false; }
/*     */   public boolean attackEntityAsMob(Entity par1Entity) { if (super.attackEntityAsMob(par1Entity)) { if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         double ks = 1.2D; double inair = 0.1D; float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX); if (par1Entity.isDead || par1Entity instanceof EntityPlayer)
/*     */           inair *= 2.0D;  par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       }  return true; }
/*     */      return false; }
/* 646 */   private EntityLivingBase findSomethingToAttack() { if (OreSpawnMain.PlayNicely != 0) return null; 
/* 647 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(20.0D, 8.0D, 20.0D));
/* 648 */     Collections.sort(var5, this.TargetSorter);
/* 649 */     Iterator<?> var2 = var5.iterator();
/* 650 */     Entity var3 = null;
/* 651 */     EntityLivingBase var4 = null;
/*     */     
/* 653 */     while (var2.hasNext()) {
/*     */       
/* 655 */       var3 = (Entity)var2.next();
/* 656 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 658 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 660 */         return var4;
/*     */       }
/*     */     } 
/* 663 */     return null; }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 668 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 673 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
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
/* 685 */     for (k = -3; k < 3; k++) {
/*     */       
/* 687 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 689 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 691 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 692 */           if (bid == Blocks.mob_spawner) {
/* 693 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 694 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 695 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 696 */             if (s != null && 
/* 697 */               s.equals("CaterKiller")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 704 */     if (this.posY < 50.0D) return false; 
/* 705 */     if (this.worldObj.rand.nextInt(10) != 0) return false; 
/* 706 */     if (!this.worldObj.isDaytime()) return false;
/*     */ 
/*     */ 
/*     */     
/* 710 */     for (k = -1; k < 2; k++) {
/*     */       
/* 712 */       for (int j = -1; j < 2; j++) {
/*     */         
/* 714 */         for (int i = 1; i < 5; i++) {
/*     */           
/* 716 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 717 */           if (bid != Blocks.air && bid != Blocks.leaves && bid != Blocks.leaves2 && bid != Blocks.log && bid != Blocks.log2) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 723 */     CaterKiller target = null;
/* 724 */     target = (CaterKiller)this.worldObj.findNearestEntityWithinAABB(CaterKiller.class, this.boundingBox.expand(48.0D, 16.0D, 48.0D), (Entity)this);
/* 725 */     if (target != null)
/*     */     {
/* 727 */       return false;
/*     */     }
/* 729 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean MyCanSee(EntityLivingBase e) {
/* 740 */     double xzoff = 2.5D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 747 */     int nblks = 10;
/*     */     
/* 749 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 750 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/* 751 */     float startx = (float)cx;
/* 752 */     float starty = (float)(this.posY + 3.0D);
/* 753 */     float startz = (float)cz;
/* 754 */     float dx = (float)((e.posX - startx) / 10.0D);
/* 755 */     float dy = (float)((e.posY + (e.height / 2.0F) - starty) / 10.0D);
/* 756 */     float dz = (float)((e.posZ - startz) / 10.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 761 */     if (Math.abs(dx) > 1.0D) {
/* 762 */       dy /= Math.abs(dx);
/* 763 */       dz /= Math.abs(dx);
/* 764 */       nblks = (int)(nblks * Math.abs(dx));
/* 765 */       if (dx > 1.0F) dx = 1.0F; 
/* 766 */       if (dx < -1.0F) dx = -1.0F; 
/*     */     } 
/* 768 */     if (Math.abs(dy) > 1.0D) {
/* 769 */       dx /= Math.abs(dy);
/* 770 */       dz /= Math.abs(dy);
/* 771 */       nblks = (int)(nblks * Math.abs(dy));
/* 772 */       if (dy > 1.0F) dy = 1.0F; 
/* 773 */       if (dy < -1.0F) dy = -1.0F; 
/*     */     } 
/* 775 */     if (Math.abs(dz) > 1.0D) {
/* 776 */       dy /= Math.abs(dz);
/* 777 */       dx /= Math.abs(dz);
/* 778 */       nblks = (int)(nblks * Math.abs(dz));
/* 779 */       if (dz > 1.0F) dz = 1.0F; 
/* 780 */       if (dz < -1.0F) dz = -1.0F;
/*     */     
/*     */     } 
/*     */ 
/*     */     
/* 785 */     for (int i = 0; i < nblks; ) {
/* 786 */       startx += dx;
/* 787 */       starty += dy;
/* 788 */       startz += dz;
/* 789 */       Block bid = this.worldObj.getBlock((int)startx, (int)starty, (int)startz);
/* 790 */       if (bid == Blocks.air || 
/* 791 */         bid == Blocks.web || 
/* 792 */         bid == Blocks.tallgrass || 
/* 793 */         bid == Blocks.leaves) { i++; continue; }
/* 794 */        return false;
/*     */     } 
/*     */ 
/*     */     
/* 798 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CaterKiller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */