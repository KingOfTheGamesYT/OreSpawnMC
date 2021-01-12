/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.enchantment.Enchantment;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SeaViper
/*     */   extends EntityMob
/*     */ {
/*  68 */   private GenericTargetSorter TargetSorter = null;
/*  69 */   private RenderInfo renderdata = new RenderInfo();
/*  70 */   private int stream_count = 0;
/*  71 */   private int hurt_timer = 0;
/*  72 */   private float moveSpeed = 0.25F; private int closest; private int tx;
/*     */   private int ty;
/*     */   private int tz;
/*     */   
/*  76 */   public SeaViper(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 447 */     this.closest = 99999;
/* 448 */     this.tx = 0; this.ty = 0; this.tz = 0; this.moveSpeed = 0.35F; setSize(1.5F, 2.5F); getNavigator().setAvoidsWater(false); this.experienceValue = 120; this.fireResistance = 30; this.isImmuneToFire = false; this.TargetSorter = new GenericTargetSorter((Entity)this); this.renderdata = new RenderInfo(); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F)); this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 8.0F)); this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false)); } protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.SeaViper_stats.attack); } protected void entityInit() { super.entityInit(); this.dataWatcher.addObject(20, Byte.valueOf((byte)0)); if (this.renderdata == null) this.renderdata = new RenderInfo();  this.renderdata.rf1 = 0.0F; this.renderdata.rf2 = 0.0F; this.renderdata.rf3 = 0.0F; this.renderdata.rf4 = 0.0F; this.renderdata.ri1 = 0; this.renderdata.ri2 = 0; this.renderdata.ri3 = 0; this.renderdata.ri4 = 0; } protected boolean canDespawn() { if (isNoDespawnRequired()) return false;  return true; } public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onUpdate(); } public int mygetMaxHealth() { return OreSpawnMain.SeaViper_stats.health; } public RenderInfo getRenderInfo() { return this.renderdata; } public void setRenderInfo(RenderInfo r) { this.renderdata.rf1 = r.rf1; this.renderdata.rf2 = r.rf2; this.renderdata.rf3 = r.rf3; this.renderdata.rf4 = r.rf4; this.renderdata.ri1 = r.ri1; this.renderdata.ri2 = r.ri2; this.renderdata.ri3 = r.ri3; this.renderdata.ri4 = r.ri4; } public int getTotalArmorValue() { return OreSpawnMain.SeaViper_stats.defense; }
/*     */   protected boolean isAIEnabled() { return true; }
/*     */   public void onLivingUpdate() { super.onLivingUpdate(); if (isInWater()) { this.moveSpeed = 0.75F; } else { this.moveSpeed = 0.25F; }  }
/*     */   public int getSeaViperHealth() { return (int)getHealth(); }
/* 452 */   private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 457 */     for (i = -dy; i <= dy; i++) {
/* 458 */       for (int j = -dz; j <= dz; j++) {
/* 459 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 460 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 461 */           int d = dx * dx + j * j + i * i;
/* 462 */           if (d < this.closest) {
/* 463 */             this.closest = d;
/* 464 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 465 */             found++;
/*     */           } 
/*     */         } 
/* 468 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 469 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 470 */           int d = dx * dx + j * j + i * i;
/* 471 */           if (d < this.closest) {
/* 472 */             this.closest = d;
/* 473 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 474 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 480 */     for (i = -dx; i <= dx; i++) {
/* 481 */       for (int j = -dz; j <= dz; j++) {
/* 482 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 483 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 484 */           int d = dy * dy + j * j + i * i;
/* 485 */           if (d < this.closest) {
/* 486 */             this.closest = d;
/* 487 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 488 */             found++;
/*     */           } 
/*     */         } 
/* 491 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 492 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 493 */           int d = dy * dy + j * j + i * i;
/* 494 */           if (d < this.closest) {
/* 495 */             this.closest = d;
/* 496 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 497 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 503 */     for (i = -dx; i <= dx; i++) {
/* 504 */       for (int j = -dy; j <= dy; j++) {
/* 505 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 506 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 507 */           int d = dz * dz + j * j + i * i;
/* 508 */           if (d < this.closest) {
/* 509 */             this.closest = d;
/* 510 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 511 */             found++;
/*     */           } 
/*     */         } 
/* 514 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 515 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 516 */           int d = dz * dz + j * j + i * i;
/* 517 */           if (d < this.closest) {
/* 518 */             this.closest = d;
/* 519 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 520 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 526 */     if (found != 0) return true; 
/* 527 */     return false; }
/*     */   protected String getLivingSound() { if (this.rand.nextInt(2) == 0) return "orespawn:seaviper_living";  return null; }
/*     */   protected String getHurtSound() { return "orespawn:seaviper_hit"; }
/*     */   protected String getDeathSound() { return "orespawn:seaviper_death"; }
/*     */   protected float getSoundVolume() { return 1.0F; }
/*     */   protected float getSoundPitch() { return 1.0F; }
/*     */   protected Item getDropItem() { return Items.chicken; }
/* 534 */   private ItemStack dropItemRand(Item index, int par1) { EntityItem var3 = null; ItemStack is = new ItemStack(index, par1, 0); var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is); if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3);  return is; } protected void dropFewItems(boolean par1, int par2) { ItemStack is = null; dropItemRand(OreSpawnMain.SeaViperTongue, 1); dropItemRand(Items.item_frame, 1); int var5 = 9 + this.worldObj.rand.nextInt(6); int var4; for (var4 = 0; var4 < var5; var4++) { dropItemRand(Items.fish, 1); dropItemRand(Items.chicken, 1); }  var4 = this.worldObj.rand.nextInt(20); switch (var4) { case 1: is = dropItemRand(Items.iron_ingot, 1); break;case 3: is = dropItemRand(Items.iron_sword, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));  break;case 4: is = dropItemRand(Items.iron_shovel, 1); if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));  break;case 5: is = dropItemRand(Items.iron_pickaxe, 1); if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));  break;case 6: is = dropItemRand(Items.iron_axe, 1); if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));  break;case 7: is = dropItemRand(Items.iron_hoe, 1); if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));  break;case 8: is = dropItemRand((Item)Items.iron_helmet, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));  break;case 9: is = dropItemRand((Item)Items.iron_chestplate, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  break;case 10: is = dropItemRand((Item)Items.iron_leggings, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  break;case 11: is = dropItemRand((Item)Items.iron_boots, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  break;case 13: dropItemRand(Item.getItemFromBlock(Blocks.iron_block), 1); break; }  } protected void updateAITasks() { if (this.isDead)
/* 535 */       return;  super.updateAITasks();
/* 536 */     if (this.hurt_timer > 0) this.hurt_timer--;
/*     */     
/* 538 */     if (!isInWater() && this.worldObj.rand.nextInt(25) == 0) {
/*     */ 
/*     */       
/* 541 */       this.closest = 99999;
/* 542 */       this.tx = this.ty = this.tz = 0;
/* 543 */       for (int i = 1; i < 12; i++) {
/* 544 */         int j = i;
/* 545 */         if (j > 10) j = 10; 
/* 546 */         if (scan_it((int)this.posX, (int)this.posY - 1, (int)this.posZ, i, j, i) == true)
/* 547 */           break;  if (i >= 5) i++;
/*     */       
/*     */       } 
/* 550 */       if (this.closest < 99999) {
/* 551 */         getNavigator().tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.33D);
/*     */       } else {
/* 553 */         if (this.worldObj.rand.nextInt(150) == 1)
/* 554 */           heal(-1.0F); 
/* 555 */         if (getHealth() <= 0.0F) {
/* 556 */           setDead();
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 563 */     if (this.worldObj.rand.nextInt(5) == 1) {
/* 564 */       EntityLivingBase e = findSomethingToAttack();
/* 565 */       if (e != null) {
/* 566 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 567 */         if (getDistanceSqToEntity((Entity)e) < ((4.5F + e.width / 2.0F) * (4.5F + e.width / 2.0F))) {
/* 568 */           setAttacking(1);
/*     */           
/* 570 */           if (this.worldObj.rand.nextInt(2) == 0 || this.worldObj.rand.nextInt(4) == 1)
/*     */           {
/* 572 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 575 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.5D);
/*     */         } 
/*     */       } else {
/* 578 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 583 */     if (this.worldObj.rand.nextInt(100) == 1 && isInWater() && 
/* 584 */       getHealth() < mygetMaxHealth()) {
/* 585 */       playSound("splash", 1.5F, this.worldObj.rand.nextFloat() * 0.2F + 0.9F);
/*     */       
/* 587 */       heal(1.0F);
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 604 */     if (par1EntityLiving == null)
/*     */     {
/* 606 */       return false;
/*     */     }
/* 608 */     if (par1EntityLiving == this)
/*     */     {
/* 610 */       return false;
/*     */     }
/* 612 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 614 */       return false;
/*     */     }
/* 616 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 619 */       return false;
/*     */     }
/* 621 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 623 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 624 */       if (p.capabilities.isCreativeMode == true) {
/* 625 */         return false;
/*     */       }
/* 627 */       return true;
/*     */     } 
/* 629 */     if (par1EntityLiving instanceof SeaViper)
/*     */     {
/* 631 */       return false;
/*     */     }
/*     */     
/* 634 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 636 */       return true;
/*     */     }
/* 638 */     if (MyUtils.isAttackableNonMob(par1EntityLiving)) {
/* 639 */       return true;
/*     */     }
/*     */     
/* 642 */     return false; } public boolean interact(EntityPlayer par1EntityPlayer) { return false; }
/*     */   public boolean attackEntityAsMob(Entity par1Entity) { int var2 = 6; if (super.attackEntityAsMob(par1Entity)) { if (par1Entity != null && par1Entity instanceof EntityLivingBase) { double ks = 0.8D; double inair = 0.14D; float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX); if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D;  par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks); if (this.worldObj.difficultySetting == EnumDifficulty.EASY) { var2 = 8; if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) { var2 = 10; } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) { var2 = 12; }  }  if (this.worldObj.rand.nextInt(2) == 1) ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, var2 * 20, 0));  }  return true; }  return false; }
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { boolean ret = false; if (par1DamageSource.getDamageType().equals("cactus"))
/*     */       return false;  Entity e = par1DamageSource.getEntity(); if (this.hurt_timer <= 0) { ret = super.attackEntityFrom(par1DamageSource, par2); this.hurt_timer = 5; }  if (e != null && e instanceof EntityLiving) { if (e instanceof SeaViper)
/*     */         return false;  setAttackTarget((EntityLivingBase)e); setTarget(e); getNavigator().tryMoveToEntityLiving(e, 1.2D); }  return ret; }
/* 647 */   private EntityLivingBase findSomethingToAttack() { if (OreSpawnMain.PlayNicely != 0) return null; 
/* 648 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(18.0D, 4.0D, 18.0D));
/* 649 */     Collections.sort(var5, this.TargetSorter);
/* 650 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 652 */     Entity var3 = null;
/* 653 */     EntityLivingBase var4 = null;
/*     */     
/* 655 */     EntityLivingBase e = getAttackTarget();
/* 656 */     if (e != null && e.isEntityAlive()) {
/* 657 */       return e;
/*     */     }
/* 659 */     setAttackTarget(null);
/*     */ 
/*     */     
/* 662 */     while (var2.hasNext()) {
/*     */       
/* 664 */       var3 = (Entity)var2.next();
/* 665 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 667 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 669 */         return var4;
/*     */       }
/*     */     } 
/* 672 */     return null; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 683 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 688 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 697 */     SeaViper target = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 703 */     for (int k = -3; k < 3; k++) {
/*     */       
/* 705 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 707 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 709 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 710 */           if (bid == Blocks.mob_spawner) {
/* 711 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 712 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 713 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 714 */             if (s != null && 
/* 715 */               s.equals("Sea Viper")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 721 */     if (this.posY < 50.0D) return false;
/*     */     
/* 723 */     if (!this.worldObj.isDaytime()) return false; 
/* 724 */     target = (SeaViper)this.worldObj.findNearestEntityWithinAABB(SeaViper.class, this.boundingBox.expand(16.0D, 5.0D, 16.0D), (Entity)this);
/* 725 */     if (target != null)
/*     */     {
/* 727 */       return false;
/*     */     }
/* 729 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 735 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\SeaViper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */