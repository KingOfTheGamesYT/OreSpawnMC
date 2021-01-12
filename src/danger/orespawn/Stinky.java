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
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMoveIndoors;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITempt;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
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
/*     */ public class Stinky
/*     */   extends EntityTameable
/*     */ {
/*     */   private ChunkCoordinates currentFlightTarget;
/*  58 */   private GenericTargetSorter TargetSorter = null;
/*  59 */   public int activity = 1;
/*  60 */   private int owner_flying = 0;
/*     */   
/*  62 */   private float moveSpeed = 0.3F;
/*  63 */   private int skin_color = -1;
/*  64 */   private int syncit = 0;
/*     */   private int closest;
/*     */   private int tx;
/*     */   private int ty;
/*  68 */   private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage); getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D); } protected void entityInit() { super.entityInit(); this.activity = 1; this.dataWatcher.addObject(22, Integer.valueOf(0)); this.dataWatcher.addObject(21, Integer.valueOf(this.activity)); this.dataWatcher.addObject(20, Integer.valueOf(1)); setSitting(false); setTamed(false); } public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) { super.writeEntityToNBT(par1NBTTagCompound); par1NBTTagCompound.setInteger("SpyroActivity", this.dataWatcher.getWatchableObjectInt(21)); par1NBTTagCompound.setInteger("SpyroFire", this.dataWatcher.getWatchableObjectInt(20)); par1NBTTagCompound.setInteger("StinkySkin", this.dataWatcher.getWatchableObjectInt(22)); } public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) { super.readEntityFromNBT(par1NBTTagCompound); this.activity = par1NBTTagCompound.getInteger("SpyroActivity"); this.dataWatcher.updateObject(21, Integer.valueOf(this.activity)); this.dataWatcher.updateObject(20, Integer.valueOf(par1NBTTagCompound.getInteger("SpyroFire"))); this.skin_color = par1NBTTagCompound.getInteger("StinkySkin"); this.dataWatcher.updateObject(22, Integer.valueOf(this.skin_color)); } public int getActivity() { int i = this.dataWatcher.getWatchableObjectInt(21); this.activity = i; return i; } public void setActivity(int par1) { this.activity = par1; this.dataWatcher.updateObject(21, Integer.valueOf(par1)); } public int getSpyroFire() { return this.dataWatcher.getWatchableObjectInt(20); } public void setSpyroFire(int par1) { this.dataWatcher.updateObject(20, Integer.valueOf(par1)); } public int getSkin() { int i = this.dataWatcher.getWatchableObjectInt(22); this.skin_color = i; return i; } public void setSkin(int par1) { this.skin_color = par1; this.dataWatcher.updateObject(22, Integer.valueOf(0)); this.dataWatcher.updateObject(22, Integer.valueOf(par1)); } public Stinky(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 578 */     this.closest = 99999;
/* 579 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.75F, 0.75F); this.moveSpeed = 0.3F; this.fireResistance = 1000; this.isImmuneToFire = true; getNavigator().setAvoidsWater(true); setSitting(false); this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 0.30000001192092896D, 0.4000000059604645D)); this.tasks.addTask(3, new MyEntityAIFollowOwner(this, 1.15F, 12.0F, 2.0F)); this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.beef, false)); this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F)); this.tasks.addTask(7, new MyEntityAIWander((EntityCreature)this, 0.75F)); this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.tasks.addTask(9, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this)); this.TargetSorter = new GenericTargetSorter((Entity)this); this.experienceValue = 35; }
/*     */   public boolean isAIEnabled() { return true; }
/*     */   public boolean canBreatheUnderwater() { return true; }
/* 582 */   public int mygetMaxHealth() { return 100; } public boolean interact(EntityPlayer par1EntityPlayer) { ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem(); if (var2 != null) if (var2.stackSize <= 0) { par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null); var2 = null; }   if (var2 != null && var2.getItem() == Items.beef && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) { if (!isTamed()) { if (!this.worldObj.isRemote) if (this.worldObj.rand.nextInt(2) == 1) { setTamed(true); func_152115_b(par1EntityPlayer.getUniqueID().toString()); playTameEffect(true); this.worldObj.setEntityState((Entity)this, (byte)7); heal(mygetMaxHealth() - getHealth()); } else { playTameEffect(false); this.worldObj.setEntityState((Entity)this, (byte)6); }   } else if (isOwner((EntityLivingBase)par1EntityPlayer)) { if (this.worldObj.isRemote) { playTameEffect(true); this.worldObj.setEntityState((Entity)this, (byte)7); }  if (mygetMaxHealth() > getHealth()) heal(mygetMaxHealth() - getHealth());  }  if (!par1EntityPlayer.capabilities.isCreativeMode) { var2.stackSize--; if (var2.stackSize <= 0) par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);  }  return true; }  if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) { if (!this.worldObj.isRemote) { setTamed(false); setHealth(mygetMaxHealth()); func_152115_b(""); playTameEffect(false); this.worldObj.setEntityState((Entity)this, (byte)6); }  if (!par1EntityPlayer.capabilities.isCreativeMode) { var2.stackSize--; if (var2.stackSize <= 0) par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);  }  return true; }  if (isTamed() && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) { if (!isSitting()) { setSitting(true); setActivity(1); } else { setSitting(false); }  return true; }  return super.interact(par1EntityPlayer); } public boolean isWheat(ItemStack par1ItemStack) { return (par1ItemStack != null && par1ItemStack.getItem() == Items.beef); } protected boolean canDespawn() { if (isNoDespawnRequired()) return false;  if (isTamed()) return false;  return true; } protected String getLivingSound() { return null; } protected String getHurtSound() { return "orespawn:duck_hurt"; } protected String getDeathSound() { return "orespawn:cryo_death"; } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 587 */     for (i = -dy; i <= dy; i++) {
/* 588 */       for (int j = -dz; j <= dz; j++) {
/* 589 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 590 */         if (bid == Blocks.coal_ore) {
/* 591 */           int d = dx * dx + j * j + i * i;
/* 592 */           if (d < this.closest) {
/* 593 */             this.closest = d;
/* 594 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 595 */             found++;
/*     */           } 
/*     */         } 
/* 598 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 599 */         if (bid == Blocks.coal_ore) {
/* 600 */           int d = dx * dx + j * j + i * i;
/* 601 */           if (d < this.closest) {
/* 602 */             this.closest = d;
/* 603 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 604 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 610 */     for (i = -dx; i <= dx; i++) {
/* 611 */       for (int j = -dz; j <= dz; j++) {
/* 612 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 613 */         if (bid == Blocks.coal_ore) {
/* 614 */           int d = dy * dy + j * j + i * i;
/* 615 */           if (d < this.closest) {
/* 616 */             this.closest = d;
/* 617 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 618 */             found++;
/*     */           } 
/*     */         } 
/* 621 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 622 */         if (bid == Blocks.coal_ore) {
/* 623 */           int d = dy * dy + j * j + i * i;
/* 624 */           if (d < this.closest) {
/* 625 */             this.closest = d;
/* 626 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 627 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 633 */     for (i = -dx; i <= dx; i++) {
/* 634 */       for (int j = -dy; j <= dy; j++) {
/* 635 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 636 */         if (bid == Blocks.coal_ore) {
/* 637 */           int d = dz * dz + j * j + i * i;
/* 638 */           if (d < this.closest) {
/* 639 */             this.closest = d;
/* 640 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 641 */             found++;
/*     */           } 
/*     */         } 
/* 644 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 645 */         if (bid == Blocks.coal_ore) {
/* 646 */           int d = dz * dz + j * j + i * i;
/* 647 */           if (d < this.closest) {
/* 648 */             this.closest = d;
/* 649 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 650 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 656 */     if (found != 0) return true; 
/* 657 */     return false; } protected float getSoundVolume() { return 0.6F; } public int getTotalArmorValue() { return 6; } protected Item getDropItem() { return Items.beef; } protected void dropFewItems(boolean par1, int par2) { int var3 = 0; if (isTamed()) { var3 = this.worldObj.rand.nextInt(4); var3++; for (int var4 = 0; var4 < var3; var4++) dropItem(Items.beef, 1);  }  } protected float getSoundPitch() { return isChild() ? ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.1F + 1.5F) : ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.1F + 1.0F); } protected boolean canTriggerWalking() { return true; } protected void fall(float par1) {} protected void updateFallState(double par1, boolean par3) {} public boolean doesEntityNotTriggerPressurePlate() { return false; } public boolean getCanSpawnHere() { if (!this.worldObj.isDaytime()) return false;  if (findBuddies() > 2) return false;  return true; } public EntityAgeable createChild(EntityAgeable var1) { return null; } public float getAttackStrength(Entity par1Entity) { return 10.0F; } public boolean attackEntityAsMob(Entity par1Entity) { float var2 = getAttackStrength(par1Entity); boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2); return var4; } public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) { boolean ret = false; if (!par1DamageSource.getDamageType().equals("cactus")) { ret = super.attackEntityFrom(par1DamageSource, par2); setSitting(false); setActivity(2); }  return ret; }
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) { return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null); }
/*     */   private void dropItemFront(Item index, int par1) { float f = 0.75F + Math.abs(this.worldObj.rand.nextFloat() * 0.75F); EntityItem var3 = new EntityItem(this.worldObj, this.posX - f * Math.sin(Math.toRadians(this.rotationYawHead)), this.posY + 0.9D, this.posZ + f * Math.cos(Math.toRadians(this.rotationYawHead)), new ItemStack(index, par1, 0)); this.worldObj.spawnEntityInWorld((Entity)var3); }
/*     */   private void dropItemRear(Item index, int par1) { float f = 0.55F + Math.abs(this.worldObj.rand.nextFloat() * 0.55F); EntityItem var3 = new EntityItem(this.worldObj, this.posX + f * Math.sin(Math.toRadians(this.rotationYawHead)), this.posY + 0.25D, this.posZ - f * Math.cos(Math.toRadians(this.rotationYawHead)), new ItemStack(index, par1, 0)); this.worldObj.spawnEntityInWorld((Entity)var3); }
/*     */   public void onUpdate() { super.onUpdate(); if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(1750) == 1) { playSound("random.burp", 1.0F, 1.0F); dropItemFront(Items.coal, 1); }  if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(2000) == 2) { playSound("orespawn:fart", 1.0F, 1.5F); if (this.skin_color == 0) dropItemRear(Items.blaze_powder, 1);  if (this.skin_color == 1) dropItemRear(Items.rotten_flesh, 1);  if (this.skin_color == 2) dropItemRear(Items.melon_seeds, 1);  if (this.skin_color == 3) dropItemRear(OreSpawnMain.UraniumNugget, 1);  if (this.skin_color == 4) dropItemRear(Items.wheat, 1);  if (this.skin_color == 5) dropItemRear(Items.brick, 1);  if (this.skin_color == 6) dropItemRear(Item.getItemFromBlock(Blocks.torch), 1);  if (this.skin_color == 7) dropItemRear(Items.emerald, 1);  if (this.skin_color == 8) dropItemRear(Items.gold_ingot, 1);  if (this.skin_color == 9) dropItemRear(Item.getItemFromBlock((Block)Blocks.leaves), 1);  if (this.skin_color == 10) dropItemRear(OreSpawnMain.TitaniumNugget, 1);  if (this.skin_color == 11) dropItemRear(OreSpawnMain.MyAppleSeed, 1);  if (this.skin_color == 12) dropItemRear(Items.diamond, 1);  if (this.skin_color == 13) dropItemRear(Item.getItemFromBlock((Block)Blocks.sand), 1);  if (this.skin_color == 14) dropItemRear(Item.getItemFromBlock(Blocks.cobblestone), 1);  if (this.skin_color == 15) dropItemRear(Items.bone, 1);  if (this.skin_color == 16) dropItemRear(Items.string, 1);  if (this.skin_color == 17) dropItemRear(OreSpawnMain.MyCherrySeed, 1);  if (this.skin_color == 18) dropItemRear(OreSpawnMain.MyPeachSeed, 1);  }  }
/*     */   public void onLivingUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onLivingUpdate(); if (isInWater()) this.motionY += 0.07D;  if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(2000) == 1) { int i = this.worldObj.rand.nextInt(19); setSkin(i); }  if (this.currentFlightTarget == null) this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);  if (this.skin_color < 0) this.skin_color = this.worldObj.rand.nextInt(19);  this.syncit++; if (this.syncit > 20) { this.syncit = 0; if (this.worldObj.isRemote) { getActivity(); getSkin(); } else { int j = this.activity; setActivity(j); j = this.skin_color; setSkin(j); }  }  if (this.activity == 2) this.motionY *= 0.6D;  }
/* 663 */   protected void updateAITasks() { if (this.isDead)
/*     */       return; 
/* 665 */     if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null);
/*     */     
/* 667 */     if (this.activity != 2) {
/* 668 */       super.updateAITasks();
/*     */     }
/*     */ 
/*     */     
/* 672 */     if (this.worldObj.rand.nextInt(100) == 1 && 
/* 673 */       getHealth() < mygetMaxHealth()) {
/* 674 */       heal(1.0F);
/*     */     }
/*     */ 
/*     */     
/* 678 */     if (!isSitting()) {
/* 679 */       if (this.activity == 0) {
/* 680 */         setActivity(1);
/*     */       }
/*     */       
/* 683 */       if (this.worldObj.rand.nextInt(100) == 1) {
/* 684 */         if (this.worldObj.rand.nextInt(20) == 1) {
/* 685 */           setActivity(2);
/*     */         } else {
/* 687 */           setActivity(1);
/*     */         } 
/*     */       }
/*     */       
/* 691 */       this.owner_flying = 0;
/* 692 */       if (isTamed() && getOwner() != null) {
/* 693 */         EntityPlayer e = (EntityPlayer)getOwner();
/*     */         
/* 695 */         if (e.capabilities.isFlying) {
/* 696 */           this.owner_flying = 1;
/* 697 */           setActivity(2);
/*     */         } 
/*     */       } 
/*     */       
/* 701 */       if (this.activity == 1 && isTamed() && getOwner() != null) {
/* 702 */         EntityLivingBase e = getOwner();
/*     */         
/* 704 */         if (getDistanceSqToEntity((Entity)e) > 256.0D)
/*     */         {
/* 706 */           setActivity(2);
/*     */         }
/*     */       } 
/*     */       
/* 710 */       do_movement();
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void do_movement() {
/* 718 */     int xdir = 1;
/* 719 */     int zdir = 1;
/*     */     
/* 721 */     int keep_trying = 50;
/*     */ 
/*     */     
/* 724 */     int do_new = 0;
/* 725 */     double ox = 0.0D, oy = 0.0D, oz = 0.0D;
/*     */     
/* 727 */     int has_owner = 0;
/* 728 */     EntityLivingBase e = null;
/*     */ 
/*     */     
/* 731 */     if (this.currentFlightTarget == null) {
/* 732 */       do_new = 1;
/* 733 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 739 */     if (this.activity == 2 && this.worldObj.rand.nextInt(300) == 0) do_new = 1;
/*     */ 
/*     */     
/* 742 */     if (isTamed() && getOwner() != null) {
/* 743 */       e = getOwner();
/* 744 */       has_owner = 1;
/* 745 */       ox = e.posX;
/* 746 */       oy = e.posY;
/* 747 */       oz = e.posZ;
/*     */       
/* 749 */       if (getDistanceSqToEntity((Entity)e) > 100.0D) {
/* 750 */         do_new = 1;
/*     */       }
/* 752 */       if (this.owner_flying != 0 && 
/* 753 */         getDistanceSqToEntity((Entity)e) > 36.0D) {
/* 754 */         do_new = 1;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 760 */     if (this.worldObj.rand.nextInt(7) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
/*     */ 
/*     */ 
/*     */       
/* 764 */       e = findSomethingToAttack();
/* 765 */       if (e != null)
/*     */       {
/* 767 */         if (isTamed() && getHealth() / mygetMaxHealth() < 0.25F) {
/* 768 */           setActivity(2);
/* 769 */           do_new = 0;
/* 770 */           this.currentFlightTarget.set((int)(this.posX + this.posX - e.posX), (int)(this.posY + 1.0D), (int)(this.posZ + this.posZ - e.posZ));
/*     */         } else {
/*     */           
/* 773 */           setActivity(2);
/* 774 */           this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0D), (int)e.posZ);
/* 775 */           do_new = 0;
/* 776 */           if (getDistanceSqToEntity((Entity)e) < ((3.0F + e.width / 2.0F) * (3.0F + e.width / 2.0F))) {
/* 777 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 783 */     if (this.activity == 1) {
/*     */       
/* 785 */       if (this.worldObj.rand.nextInt(50) == 0 && OreSpawnMain.PlayNicely == 0) {
/*     */ 
/*     */ 
/*     */         
/* 789 */         this.closest = 99999;
/* 790 */         this.tx = this.ty = this.tz = 0;
/* 791 */         for (int i = 1; i < 9; i++) {
/* 792 */           int j = i;
/* 793 */           if (j > 2) j = 2; 
/* 794 */           if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i) == true)
/* 795 */             break;  if (i >= 4) i++;
/*     */         
/*     */         } 
/* 798 */         if (this.closest < 99999) {
/*     */           
/* 800 */           getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.25D);
/* 801 */           if (this.closest < 12) {
/*     */             
/* 803 */             this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2);
/* 804 */             heal(1.0F);
/* 805 */             playSound("random.burp", 0.5F, this.worldObj.rand.nextFloat() * 0.2F + 1.5F);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 813 */     if (this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/* 814 */       do_new = 1;
/*     */     }
/*     */ 
/*     */     
/* 818 */     if (do_new != 0) {
/*     */       
/* 820 */       Block bid = Blocks.stone;
/* 821 */       while (bid != Blocks.air && keep_trying != 0) {
/* 822 */         int gox = (int)this.posX;
/* 823 */         int goy = (int)this.posY;
/* 824 */         int goz = (int)this.posZ;
/* 825 */         if (has_owner == 1) {
/* 826 */           gox = (int)ox;
/* 827 */           goy = (int)oy;
/* 828 */           goz = (int)oz;
/* 829 */           if (this.owner_flying == 0) {
/* 830 */             zdir = this.worldObj.rand.nextInt(4) + 6;
/* 831 */             xdir = this.worldObj.rand.nextInt(4) + 6;
/*     */           } else {
/* 833 */             zdir = this.worldObj.rand.nextInt(8);
/* 834 */             xdir = this.worldObj.rand.nextInt(8);
/*     */           } 
/*     */         } else {
/* 837 */           zdir = this.worldObj.rand.nextInt(5) + 6;
/* 838 */           xdir = this.worldObj.rand.nextInt(5) + 6;
/*     */         } 
/* 840 */         if (this.worldObj.rand.nextInt(2) == 0) zdir = -zdir; 
/* 841 */         if (this.worldObj.rand.nextInt(2) == 0) xdir = -xdir; 
/* 842 */         this.currentFlightTarget.set(gox + xdir, goy + this.worldObj.rand.nextInt(6 + this.owner_flying * 2) - 2, goz + zdir);
/* 843 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 844 */         if (bid == Blocks.air && 
/* 845 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 846 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 849 */         keep_trying--;
/*     */       } 
/*     */     } 
/*     */     
/* 853 */     double speed_factor = 1.0D;
/* 854 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 855 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 856 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 857 */     if (this.owner_flying != 0) {
/* 858 */       speed_factor = 1.75D;
/* 859 */       if (isTamed() && getOwner() != null) {
/* 860 */         e = getOwner();
/* 861 */         if (getDistanceSqToEntity((Entity)e) > 49.0D) {
/* 862 */           speed_factor = 3.5D;
/*     */         }
/*     */       } 
/*     */     } 
/* 866 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.15D * speed_factor;
/* 867 */     this.motionY += (Math.signum(var3) * 0.7D - this.motionY) * 0.21D * speed_factor;
/* 868 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.15D * speed_factor;
/* 869 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 870 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 871 */     this.moveForward = (float)(0.75D * speed_factor);
/*     */     
/* 873 */     this.rotationYaw += var8 / 3.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 881 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*     */     
/* 883 */     if (par1EntityLiving == null)
/*     */     {
/* 885 */       return false;
/*     */     }
/* 887 */     if (par1EntityLiving == this)
/*     */     {
/* 889 */       return false;
/*     */     }
/* 891 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 893 */       return false;
/*     */     }
/* 895 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 898 */       return false;
/*     */     }
/*     */     
/* 901 */     if (par1EntityLiving instanceof Mothra)
/*     */     {
/* 903 */       return true;
/*     */     }
/*     */     
/* 906 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 908 */       return true;
/*     */     }
/*     */     
/* 911 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 916 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 917 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 6.0D, 12.0D));
/* 918 */     Collections.sort(var5, this.TargetSorter);
/* 919 */     Iterator<?> var2 = var5.iterator();
/* 920 */     Entity var3 = null;
/* 921 */     EntityLivingBase var4 = null;
/*     */     
/* 923 */     while (var2.hasNext()) {
/*     */       
/* 925 */       var3 = (Entity)var2.next();
/* 926 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 928 */       if (isSuitableTarget(var4, false) && canSeeTarget(var4.posX, var4.posY, var4.posZ))
/*     */       {
/* 930 */         return var4;
/*     */       }
/*     */     } 
/* 933 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 938 */     List var5 = this.worldObj.getEntitiesWithinAABB(Stinky.class, this.boundingBox.expand(20.0D, 10.0D, 20.0D));
/* 939 */     return var5.size();
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Stinky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */