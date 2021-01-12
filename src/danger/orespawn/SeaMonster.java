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
/*     */ public class SeaMonster
/*     */   extends EntityMob
/*     */ {
/*  67 */   private GenericTargetSorter TargetSorter = null;
/*  68 */   private RenderInfo renderdata = new RenderInfo();
/*  69 */   private int hurt_timer = 0;
/*  70 */   private float moveSpeed = 0.25F; private int closest; private int tx;
/*     */   private int ty;
/*     */   private int tz;
/*     */   
/*  74 */   public SeaMonster(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 427 */     this.closest = 99999;
/* 428 */     this.tx = 0; this.ty = 0; this.tz = 0; this.moveSpeed = 0.25F; setSize(1.25F, 2.5F); getNavigator().setAvoidsWater(false); this.experienceValue = 150; this.fireResistance = 30; this.isImmuneToFire = false; this.TargetSorter = new GenericTargetSorter((Entity)this); this.renderdata = new RenderInfo(); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F)); this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 8.0F)); this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false)); } protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.SeaMonster_stats.attack); } protected void entityInit() { super.entityInit(); this.dataWatcher.addObject(20, Byte.valueOf((byte)0)); if (this.renderdata == null) this.renderdata = new RenderInfo();  this.renderdata.rf1 = 0.0F; this.renderdata.rf2 = 0.0F; this.renderdata.rf3 = 0.0F; this.renderdata.rf4 = 0.0F; this.renderdata.ri1 = 0; this.renderdata.ri2 = 0; this.renderdata.ri3 = 0; this.renderdata.ri4 = 0; } protected boolean canDespawn() { if (isNoDespawnRequired()) return false;  return true; } public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onUpdate(); } public int mygetMaxHealth() { return OreSpawnMain.SeaMonster_stats.health; } public RenderInfo getRenderInfo() { return this.renderdata; } public void setRenderInfo(RenderInfo r) { this.renderdata.rf1 = r.rf1; this.renderdata.rf2 = r.rf2; this.renderdata.rf3 = r.rf3; this.renderdata.rf4 = r.rf4; this.renderdata.ri1 = r.ri1; this.renderdata.ri2 = r.ri2; this.renderdata.ri3 = r.ri3; this.renderdata.ri4 = r.ri4; } public int getTotalArmorValue() { return OreSpawnMain.SeaMonster_stats.defense; }
/*     */   protected boolean isAIEnabled() { return true; }
/*     */   public void onLivingUpdate() { super.onLivingUpdate(); if (isInWater()) { this.moveSpeed = 0.55F; } else { this.moveSpeed = 0.25F; }  }
/*     */   public int getSeaMonsterHealth() { return (int)getHealth(); }
/* 432 */   private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 437 */     for (i = -dy; i <= dy; i++) {
/* 438 */       for (int j = -dz; j <= dz; j++) {
/* 439 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 440 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 441 */           int d = dx * dx + j * j + i * i;
/* 442 */           if (d < this.closest) {
/* 443 */             this.closest = d;
/* 444 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 445 */             found++;
/*     */           } 
/*     */         } 
/* 448 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 449 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 450 */           int d = dx * dx + j * j + i * i;
/* 451 */           if (d < this.closest) {
/* 452 */             this.closest = d;
/* 453 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 454 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 460 */     for (i = -dx; i <= dx; i++) {
/* 461 */       for (int j = -dz; j <= dz; j++) {
/* 462 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 463 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 464 */           int d = dy * dy + j * j + i * i;
/* 465 */           if (d < this.closest) {
/* 466 */             this.closest = d;
/* 467 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 468 */             found++;
/*     */           } 
/*     */         } 
/* 471 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 472 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 473 */           int d = dy * dy + j * j + i * i;
/* 474 */           if (d < this.closest) {
/* 475 */             this.closest = d;
/* 476 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 477 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 483 */     for (i = -dx; i <= dx; i++) {
/* 484 */       for (int j = -dy; j <= dy; j++) {
/* 485 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 486 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 487 */           int d = dz * dz + j * j + i * i;
/* 488 */           if (d < this.closest) {
/* 489 */             this.closest = d;
/* 490 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 491 */             found++;
/*     */           } 
/*     */         } 
/* 494 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 495 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 496 */           int d = dz * dz + j * j + i * i;
/* 497 */           if (d < this.closest) {
/* 498 */             this.closest = d;
/* 499 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 500 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 506 */     if (found != 0) return true; 
/* 507 */     return false; }
/*     */   protected String getLivingSound() { if (this.rand.nextInt(3) == 0) return "orespawn:seamonster_living";  return null; }
/*     */   protected String getHurtSound() { return "orespawn:seamonster_hit"; }
/*     */   protected String getDeathSound() { return "orespawn:seamonster_death"; }
/*     */   protected float getSoundVolume() { return 1.0F; }
/*     */   protected float getSoundPitch() { return 1.0F; }
/*     */   protected Item getDropItem() { return Items.fish; }
/* 514 */   private ItemStack dropItemRand(Item index, int par1) { EntityItem var3 = null; ItemStack is = new ItemStack(index, par1, 0); var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is); if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3);  return is; } protected void dropFewItems(boolean par1, int par2) { ItemStack is = null; dropItemRand(OreSpawnMain.SeaMonsterScale, 1); dropItemRand(Items.item_frame, 1); int var5 = 9 + this.worldObj.rand.nextInt(6); int var4; for (var4 = 0; var4 < var5; var4++) dropItemRand(Items.fish, 1);  var4 = this.worldObj.rand.nextInt(20); switch (var4) { case 1: is = dropItemRand(Items.iron_ingot, 1); break;case 3: is = dropItemRand(Items.iron_sword, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));  break;case 4: is = dropItemRand(Items.iron_shovel, 1); if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));  break;case 5: is = dropItemRand(Items.iron_pickaxe, 1); if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));  break;case 6: is = dropItemRand(Items.iron_axe, 1); if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));  break;case 7: is = dropItemRand(Items.iron_hoe, 1); if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));  break;case 8: is = dropItemRand((Item)Items.iron_helmet, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));  break;case 9: is = dropItemRand((Item)Items.iron_chestplate, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  break;case 10: is = dropItemRand((Item)Items.iron_leggings, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  break;case 11: is = dropItemRand((Item)Items.iron_boots, 1); if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));  if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));  break;case 13: dropItemRand(Item.getItemFromBlock(Blocks.iron_block), 1); break; }  } protected void updateAITasks() { if (this.isDead)
/* 515 */       return;  super.updateAITasks();
/* 516 */     if (this.hurt_timer > 0) this.hurt_timer--;
/*     */     
/* 518 */     if (!isInWater() && this.worldObj.rand.nextInt(25) == 0) {
/*     */ 
/*     */       
/* 521 */       this.closest = 99999;
/* 522 */       this.tx = this.ty = this.tz = 0;
/* 523 */       for (int i = 1; i < 12; i++) {
/* 524 */         int j = i;
/* 525 */         if (j > 10) j = 10; 
/* 526 */         if (scan_it((int)this.posX, (int)this.posY - 1, (int)this.posZ, i, j, i) == true)
/* 527 */           break;  if (i >= 5) i++;
/*     */       
/*     */       } 
/* 530 */       if (this.closest < 99999) {
/* 531 */         getNavigator().tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.33D);
/*     */       } else {
/* 533 */         if (this.worldObj.rand.nextInt(40) == 1)
/* 534 */           heal(-1.0F); 
/* 535 */         if (getHealth() <= 0.0F) {
/* 536 */           setDead();
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 543 */     if (this.worldObj.rand.nextInt(5) == 1) {
/* 544 */       EntityLivingBase e = findSomethingToAttack();
/* 545 */       if (e != null) {
/* 546 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 547 */         if (getDistanceSqToEntity((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 548 */           setAttacking(1);
/*     */           
/* 550 */           if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1)
/*     */           {
/* 552 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 555 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.0D);
/*     */         } 
/*     */       } else {
/* 558 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 563 */     if (this.worldObj.rand.nextInt(120) == 1 && isInWater() && 
/* 564 */       getHealth() < mygetMaxHealth()) {
/* 565 */       playSound("splash", 1.5F, this.worldObj.rand.nextFloat() * 0.2F + 0.9F);
/*     */       
/* 567 */       heal(1.0F);
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
/* 584 */     if (par1EntityLiving == null)
/*     */     {
/* 586 */       return false;
/*     */     }
/* 588 */     if (par1EntityLiving == this)
/*     */     {
/* 590 */       return false;
/*     */     }
/* 592 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 594 */       return false;
/*     */     }
/* 596 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 599 */       return false;
/*     */     }
/* 601 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 603 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 604 */       if (p.capabilities.isCreativeMode == true) {
/* 605 */         return false;
/*     */       }
/* 607 */       return true;
/*     */     } 
/* 609 */     if (par1EntityLiving instanceof SeaMonster)
/*     */     {
/* 611 */       return false;
/*     */     }
/* 613 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 615 */       return true;
/*     */     }
/* 617 */     if (MyUtils.isAttackableNonMob(par1EntityLiving)) {
/* 618 */       return true;
/*     */     }
/*     */     
/* 621 */     return false; } public boolean interact(EntityPlayer par1EntityPlayer) { return false; }
/*     */   public boolean attackEntityAsMob(Entity par1Entity) { if (super.attackEntityAsMob(par1Entity)) { if (par1Entity != null && par1Entity instanceof EntityLivingBase) { double ks = 0.6D; double inair = 0.1D; float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX); if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D;  par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks); }  return true; }  return false; }
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { boolean ret = false; if (par1DamageSource.getDamageType().equals("cactus"))
/*     */       return false;  Entity e = par1DamageSource.getEntity(); if (this.hurt_timer <= 0) { ret = super.attackEntityFrom(par1DamageSource, par2); this.hurt_timer = 8; }  if (e != null && e instanceof EntityLiving) { if (e instanceof SeaMonster)
/*     */         return false;  setAttackTarget((EntityLivingBase)e); setTarget(e); getNavigator().tryMoveToEntityLiving(e, 1.2D); }  return ret; }
/* 626 */   private EntityLivingBase findSomethingToAttack() { if (OreSpawnMain.PlayNicely != 0) return null; 
/* 627 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0D, 4.0D, 16.0D));
/* 628 */     Collections.sort(var5, this.TargetSorter);
/* 629 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 631 */     Entity var3 = null;
/* 632 */     EntityLivingBase var4 = null;
/*     */     
/* 634 */     EntityLivingBase e = getAttackTarget();
/* 635 */     if (e != null && e.isEntityAlive()) {
/* 636 */       return e;
/*     */     }
/* 638 */     setAttackTarget(null);
/*     */ 
/*     */     
/* 641 */     while (var2.hasNext()) {
/*     */       
/* 643 */       var3 = (Entity)var2.next();
/* 644 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 646 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 648 */         return var4;
/*     */       }
/*     */     } 
/* 651 */     return null; }
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
/* 662 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 667 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 676 */     SeaMonster target = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 681 */     for (int k = -3; k < 3; k++) {
/*     */       
/* 683 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 685 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 687 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 688 */           if (bid == Blocks.mob_spawner) {
/* 689 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 690 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 691 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 692 */             if (s != null && 
/* 693 */               s.equals("Sea Monster")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 700 */     if (this.posY < 50.0D) return false;
/*     */     
/* 702 */     if (this.worldObj.isDaytime()) return false; 
/* 703 */     if (!isValidLightLevel()) return false; 
/* 704 */     target = (SeaMonster)this.worldObj.findNearestEntityWithinAABB(SeaMonster.class, this.boundingBox.expand(16.0D, 5.0D, 16.0D), (Entity)this);
/* 705 */     if (target != null)
/*     */     {
/* 707 */       return false;
/*     */     }
/* 709 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 715 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\SeaMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */