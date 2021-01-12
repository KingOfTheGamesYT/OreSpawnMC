/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityList;
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
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RubberDucky
/*     */   extends EntityTameable
/*     */ {
/*  73 */   private GenericTargetSorter TargetSorter = null;
/*     */   public boolean should_despawn = true;
/*  75 */   private EntityLivingBase buddy = null;
/*  76 */   private float moveSpeed = 0.22F;
/*  77 */   private int killcount = 0;
/*  78 */   private int died = 0;
/*  79 */   private RenderInfo renderdata = new RenderInfo();
/*     */   private int closest;
/*     */   private int tx;
/*     */   private int ty;
/*  83 */   private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage); getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D); } protected void entityInit() { super.entityInit(); this.dataWatcher.addObject(23, Byte.valueOf((byte)0)); this.dataWatcher.addObject(22, Byte.valueOf((byte)0)); setSitting(false); if (getGrowingAge() < 0) setGrowingAge(-getGrowingAge());  if (this.renderdata == null) this.renderdata = new RenderInfo();  this.renderdata.rf1 = 0.0F; this.renderdata.rf2 = 0.0F; this.renderdata.rf3 = 0.0F; this.renderdata.rf4 = 0.0F; this.renderdata.ri1 = 0; this.renderdata.ri2 = 0; this.renderdata.ri3 = 0; this.renderdata.ri4 = 0; } public RenderInfo getRenderInfo() { return this.renderdata; } public void setRenderInfo(RenderInfo r) { this.renderdata.rf1 = r.rf1; this.renderdata.rf2 = r.rf2; this.renderdata.rf3 = r.rf3; this.renderdata.rf4 = r.rf4; this.renderdata.ri1 = r.ri1; this.renderdata.ri2 = r.ri2; this.renderdata.ri3 = r.ri3; this.renderdata.ri4 = r.ri4; } public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onUpdate(); if (isInWater()) { this.motionY += 0.10000000149011612D; if (this.motionY < -0.05000000074505806D) this.motionY = -0.05000000074505806D;  }  } public RubberDucky(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 413 */     this.closest = 99999;
/* 414 */     this.tx = 0; this.ty = 0; this.tz = 0; this.moveSpeed = 0.22F; setSize(0.33F, 0.5F); getNavigator().setAvoidsWater(false); this.experienceValue = 15; this.fireResistance = 3; this.isImmuneToFire = false; this.renderdata = new RenderInfo(); this.TargetSorter = new GenericTargetSorter((Entity)this); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D)); this.tasks.addTask(1, new MyEntityAIFollowOwner(this, 2.0F, 10.0F, 2.0F)); this.tasks.addTask(2, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D)); this.tasks.addTask(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.fish, false)); this.tasks.addTask(4, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D)); this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 6.0F)); this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false)); }
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { boolean ret = false; Entity w = null; w = par1DamageSource.getEntity(); ret = super.attackEntityFrom(par1DamageSource, par2); setSitting(false); if (!this.worldObj.isRemote && w != null && w instanceof EntityPlayer && (this.isDead || getHealth() <= 0.0F) && this.died == 0) { this.died = 1; this.killcount++; setKillCount(this.killcount); if (this.killcount < 10) for (int m = 0; m < 20; m++) { int i = this.worldObj.rand.nextInt(3); if (this.worldObj.rand.nextInt(2) == 1) i = -i;  int k = this.worldObj.rand.nextInt(3); if (this.worldObj.rand.nextInt(2) == 1)
/*     */             k = -k;  for (int j = 3; j > -3; j--) { if (this.worldObj.getBlock((int)this.posX + i, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air && this.worldObj.getBlock((int)this.posX + i, (int)this.posY + j, (int)this.posZ + k) != Blocks.air) { Entity e = spawnCreature(this.worldObj, "Rubber Ducky", ((int)this.posX + i + 1), ((int)this.posY + j + 1), ((int)this.posZ + k)); if (e != null) { RubberDucky d = (RubberDucky)e; d.setKillCount(this.killcount); }  return ret; }  }  }   }  return ret; }
/*     */   public int mygetMaxHealth() { return 5; }
/* 418 */   public int getTotalArmorValue() { return 1; } protected void fall(float par1) {} private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 423 */     for (i = -dy; i <= dy; i++) {
/* 424 */       for (int j = -dz; j <= dz; j++) {
/* 425 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 426 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 427 */           int d = dx * dx + j * j + i * i;
/* 428 */           if (d < this.closest) {
/* 429 */             this.closest = d;
/* 430 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 431 */             found++;
/*     */           } 
/*     */         } 
/* 434 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 435 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 436 */           int d = dx * dx + j * j + i * i;
/* 437 */           if (d < this.closest) {
/* 438 */             this.closest = d;
/* 439 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 440 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 446 */     for (i = -dx; i <= dx; i++) {
/* 447 */       for (int j = -dz; j <= dz; j++) {
/* 448 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 449 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 450 */           int d = dy * dy + j * j + i * i;
/* 451 */           if (d < this.closest) {
/* 452 */             this.closest = d;
/* 453 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 454 */             found++;
/*     */           } 
/*     */         } 
/* 457 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 458 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 459 */           int d = dy * dy + j * j + i * i;
/* 460 */           if (d < this.closest) {
/* 461 */             this.closest = d;
/* 462 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 463 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 469 */     for (i = -dx; i <= dx; i++) {
/* 470 */       for (int j = -dy; j <= dy; j++) {
/* 471 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 472 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 473 */           int d = dz * dz + j * j + i * i;
/* 474 */           if (d < this.closest) {
/* 475 */             this.closest = d;
/* 476 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 477 */             found++;
/*     */           } 
/*     */         } 
/* 480 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 481 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 482 */           int d = dz * dz + j * j + i * i;
/* 483 */           if (d < this.closest) {
/* 484 */             this.closest = d;
/* 485 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 486 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 492 */     if (found != 0) return true; 
/* 493 */     return false; } protected void updateFallState(double par1, boolean par3) {} protected boolean isAIEnabled() { return true; } public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) { Entity var8 = null; var8 = EntityList.createEntityByName(par1, par0World); if (var8 != null) { var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F); par0World.spawnEntityInWorld(var8); ((EntityLiving)var8).playLivingSound(); }  return var8; } protected String getLivingSound() { if (this.worldObj.rand.nextInt(10) == 1) return "orespawn:duck_hurt";  return null; }
/*     */   protected String getHurtSound() { return "orespawn:duck_hurt"; }
/*     */   protected String getDeathSound() { return "orespawn:duck_hurt"; }
/*     */   protected float getSoundVolume() { return 0.8F; }
/*     */   protected float getSoundPitch() { return 1.2F; }
/*     */   protected Item getDropItem() { if (this.worldObj.rand.nextInt(2) == 1) return Items.feather;  if (this.worldObj.rand.nextInt(2) == 1) return OreSpawnMain.RubberDuckyEgg;  return null; }
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) { ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem(); if (var2 != null) if (var2.stackSize <= 0) { par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null); var2 = null; }   if (super.interact(par1EntityPlayer)) return true;  if (var2 != null && var2.getItem() == Items.fish && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) { if (!isTamed()) { if (!this.worldObj.isRemote) if (this.rand.nextInt(2) == 0) { setTamed(true); func_152115_b(par1EntityPlayer.getUniqueID().toString()); playTameEffect(true); this.worldObj.setEntityState((Entity)this, (byte)7); heal(mygetMaxHealth() - getHealth()); } else { playTameEffect(false); this.worldObj.setEntityState((Entity)this, (byte)6); }   } else if (isOwner((EntityLivingBase)par1EntityPlayer)) { if (this.worldObj.isRemote) { playTameEffect(true); this.worldObj.setEntityState((Entity)this, (byte)7); }  if (mygetMaxHealth() > getHealth()) heal(mygetMaxHealth() - getHealth());  }  if (!par1EntityPlayer.capabilities.isCreativeMode) { var2.stackSize--; if (var2.stackSize <= 0) par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);  }  return true; }  if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) { if (!this.worldObj.isRemote) { setTamed(false); func_152115_b(""); playTameEffect(false); this.worldObj.setEntityState((Entity)this, (byte)6); }  if (!par1EntityPlayer.capabilities.isCreativeMode) { var2.stackSize--; if (var2.stackSize <= 0) par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);  }  return true; }  if (isTamed() && isOwner((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) { if (!isSitting() && getKillCount() < 5) { setSitting(true); } else { setSitting(false); }  return true; }  return true; }
/* 500 */   protected void updateAITasks() { if (this.isDead)
/* 501 */       return;  super.updateAITasks();
/*     */ 
/*     */ 
/*     */     
/* 505 */     if (!isInWater() && this.worldObj.rand.nextInt(50) == 0) {
/*     */ 
/*     */       
/* 508 */       this.closest = 99999;
/* 509 */       this.tx = this.ty = this.tz = 0;
/* 510 */       for (int i = 1; i < 14; i++) {
/* 511 */         int j = i;
/* 512 */         if (j > 5) j = 5; 
/* 513 */         if (scan_it((int)this.posX, (int)this.posY - 1, (int)this.posZ, i, j, i) == true)
/* 514 */           break;  if (i >= 5) i++;
/*     */       
/*     */       } 
/* 517 */       if (this.closest < 99999) {
/* 518 */         getNavigator().tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.33D);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 523 */     if (this.killcount > 0 && 
/* 524 */       this.worldObj.rand.nextInt(200) == 1) {
/* 525 */       this.killcount--;
/* 526 */       setKillCount(this.killcount);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 531 */     if (getHealth() < mygetMaxHealth() && this.worldObj.rand.nextInt(300) == 1) {
/* 532 */       heal(1.0F);
/*     */     }
/*     */ 
/*     */     
/* 536 */     if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(5) == 1) {
/* 537 */       EntityLivingBase e = findSomethingToAttack();
/* 538 */       if (e != null) {
/*     */         
/* 540 */         if (getDistanceSqToEntity((Entity)e) < 12.0D) {
/* 541 */           setAttacking(1);
/*     */           
/* 543 */           if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1)
/*     */           {
/* 545 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 548 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */         } 
/*     */       } else {
/*     */         
/* 552 */         if (this.buddy != null && !this.buddy.isDead && this.worldObj.rand.nextInt(15) == 1) {
/* 553 */           getNavigator().tryMoveToEntityLiving((Entity)this.buddy, 1.0D);
/*     */         }
/* 555 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 560 */     if (this.buddy != null && !this.buddy.isDead && this.worldObj.rand.nextInt(20) == 1) {
/* 561 */       getNavigator().tryMoveToEntityLiving((Entity)this.buddy, 1.0D);
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 567 */     float i = 1.0F;
/*     */     
/* 569 */     if (getKillCount() >= 5) i = 2.0F; 
/* 570 */     boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), i);
/*     */     
/* 572 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 582 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*     */     
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
/* 601 */     if (par1EntityLiving instanceof AttackSquid)
/*     */     {
/* 603 */       return true;
/*     */     }
/* 605 */     if (par1EntityLiving instanceof net.minecraft.entity.passive.EntitySquid)
/*     */     {
/* 607 */       return true;
/*     */     }
/*     */     
/* 610 */     if (par1EntityLiving instanceof RubberDucky)
/*     */     {
/*     */       
/* 613 */       if (this.worldObj.rand.nextInt(10) == 1) this.buddy = par1EntityLiving;
/*     */     
/*     */     }
/* 616 */     if (getKillCount() >= 5 && 
/* 617 */       par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 619 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 620 */       if (p.capabilities.isCreativeMode == true) {
/* 621 */         return false;
/*     */       }
/* 623 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 627 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 632 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 633 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(8.0D, 4.0D, 8.0D));
/* 634 */     Collections.sort(var5, this.TargetSorter);
/* 635 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 637 */     Entity var3 = null;
/* 638 */     EntityLivingBase var4 = null;
/*     */     
/* 640 */     EntityLivingBase e = getAttackTarget();
/* 641 */     if (e != null && e.isEntityAlive()) {
/* 642 */       return e;
/*     */     }
/* 644 */     setAttackTarget(null);
/*     */ 
/*     */     
/* 647 */     this.buddy = null;
/* 648 */     while (var2.hasNext()) {
/*     */       
/* 650 */       var3 = (Entity)var2.next();
/* 651 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 653 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 655 */         return var4;
/*     */       }
/*     */     } 
/* 658 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 666 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 667 */     par1NBTTagCompound.setInteger("Killcount", this.killcount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 675 */     super.readEntityFromNBT(par1NBTTagCompound);
/* 676 */     this.killcount = par1NBTTagCompound.getInteger("Killcount");
/* 677 */     setKillCount(this.killcount);
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
/* 688 */     return this.dataWatcher.getWatchableObjectByte(23);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 693 */     this.dataWatcher.updateObject(23, Byte.valueOf((byte)par1));
/*     */   }
/*     */   
/*     */   public final int getKillCount() {
/* 697 */     return this.dataWatcher.getWatchableObjectByte(22);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setKillCount(int par1) {
/* 702 */     this.dataWatcher.updateObject(22, Byte.valueOf((byte)par1));
/* 703 */     this.killcount = par1;
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
/* 715 */     for (int k = -3; k < 3; k++) {
/*     */       
/* 717 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 719 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 721 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 722 */           if (bid == Blocks.mob_spawner) {
/* 723 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 724 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 725 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 726 */             if (s != null && 
/* 727 */               s.equals("Rubber Ducky")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 733 */     if (this.posY < 50.0D) return false; 
/* 734 */     if (!this.worldObj.isDaytime()) return false; 
/* 735 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 744 */     if (isChild()) {
/* 745 */       enablePersistence();
/* 746 */       return false;
/*     */     } 
/* 748 */     if (isNoDespawnRequired()) return false; 
/* 749 */     if (isTamed()) return false; 
/* 750 */     return this.should_despawn;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 755 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RubberDucky spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 761 */     return new RubberDucky(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 769 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.fish);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 778 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RubberDucky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */