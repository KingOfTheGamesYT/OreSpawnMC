/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAIMoveIndoors;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITempt;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ public class Ostrich
/*     */   extends EntityCannonFodder
/*     */ {
/*  48 */   private float moveSpeed = 0.2F;
/*  49 */   private RenderInfo renderdata = new RenderInfo();
/*     */   
/*     */   private int boatPosRotationIncrements;
/*     */   
/*     */   private double boatX;
/*     */   private double boatY;
/*     */   private double boatZ;
/*     */   private double boatYaw;
/*     */   private double boatPitch;
/*     */   private double boatYawHead;
/*     */   private double velocityX;
/*     */   private double velocityY;
/*     */   private double velocityZ;
/*  62 */   float deltasmooth = 0.0F;
/*  63 */   private int didjump = 0;
/*     */ 
/*     */   
/*     */   public Ostrich(World par1World) {
/*  67 */     super(par1World);
/*     */     
/*  69 */     setSize(0.85F, 2.1F);
/*  70 */     this.moveSpeed = 0.38F;
/*  71 */     this.fireResistance = 100;
/*  72 */     getNavigator().setAvoidsWater(true);
/*  73 */     setSitting(false);
/*  74 */     this.experienceValue = 10;
/*  75 */     this.renderdata = new RenderInfo();
/*  76 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  77 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D));
/*  78 */     this.tasks.addTask(2, new MyEntityAIFollowOwner(this, 2.0F, 10.0F, 2.0F));
/*  79 */     this.tasks.addTask(3, new MyEntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.899999976158142D));
/*  80 */     this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, Items.apple, false));
/*  81 */     this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D));
/*  82 */     this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*  83 */     this.tasks.addTask(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 5.0F));
/*  84 */     this.tasks.addTask(8, new MyEntityAIWander((EntityCreature)this, 1.0F));
/*  85 */     this.tasks.addTask(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  86 */     this.tasks.addTask(10, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  91 */     super.applyEntityAttributes();
/*  92 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  93 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  94 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  95 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/* 101 */     super.entityInit();
/* 102 */     setSitting(false);
/* 103 */     if (this.renderdata == null) {
/* 104 */       this.renderdata = new RenderInfo();
/*     */     }
/* 106 */     this.renderdata.rf1 = 0.0F;
/* 107 */     this.renderdata.rf2 = 0.0F;
/* 108 */     this.renderdata.rf3 = 0.0F;
/* 109 */     this.renderdata.rf4 = 0.0F;
/* 110 */     this.renderdata.ri1 = 0;
/* 111 */     this.renderdata.ri2 = 0;
/* 112 */     this.renderdata.ri3 = 0;
/* 113 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 120 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 125 */     this.renderdata.rf1 = r.rf1;
/* 126 */     this.renderdata.rf2 = r.rf2;
/* 127 */     this.renderdata.rf3 = r.rf3;
/* 128 */     this.renderdata.rf4 = r.rf4;
/* 129 */     this.renderdata.ri1 = r.ri1;
/* 130 */     this.renderdata.ri2 = r.ri2;
/* 131 */     this.renderdata.ri3 = r.ri3;
/* 132 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 140 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 141 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 150 */     super.writeEntityToNBT(par1NBTTagCompound);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 158 */     super.readEntityFromNBT(par1NBTTagCompound);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 166 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 167 */       super.attackEntityFrom(par1DamageSource, par2);
/*     */     }
/* 169 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITick() {
/* 179 */     if (this.isDead)
/* 180 */       return;  if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 181 */     if (this.worldObj.rand.nextInt(250) == 0)
/*     */     {
/* 183 */       heal(1.0F);
/*     */     }
/*     */     
/* 186 */     if (this.riddenByEntity != null)
/* 187 */       return;  super.updateAITick();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAIEnabled() {
/* 196 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 202 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 207 */     return 25;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOstrichHealth() {
/* 214 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 222 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*     */     
/* 224 */     if (var2 != null)
/*     */     {
/* 226 */       if (var2.stackSize <= 0) {
/*     */         
/* 228 */         par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 229 */         var2 = null;
/*     */       } 
/*     */     }
/*     */     
/* 233 */     if (super.interact(par1EntityPlayer)) {
/* 234 */       return true;
/*     */     }
/*     */     
/* 237 */     if (var2 != null && var2.getItem() == Items.apple && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*     */       
/* 239 */       if (!isTamed()) {
/*     */         
/* 241 */         if (!this.worldObj.isRemote)
/*     */         {
/* 243 */           if (this.rand.nextInt(2) == 0)
/*     */           {
/* 245 */             setTamed(true);
/* 246 */             func_152115_b(par1EntityPlayer.getUniqueID().toString());
/* 247 */             playTameEffect(true);
/* 248 */             this.worldObj.setEntityState((Entity)this, (byte)7);
/* 249 */             heal(mygetMaxHealth() - getHealth());
/*     */           
/*     */           }
/*     */           else
/*     */           {
/* 254 */             playTameEffect(false);
/* 255 */             this.worldObj.setEntityState((Entity)this, (byte)6);
/*     */           }
/*     */         
/*     */         }
/*     */       }
/* 260 */       else if (isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */         
/* 262 */         if (this.worldObj.isRemote) {
/* 263 */           playTameEffect(true);
/* 264 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*     */         } 
/*     */         
/* 267 */         if (mygetMaxHealth() > getHealth()) {
/* 268 */           heal(mygetMaxHealth() - getHealth());
/*     */         }
/*     */       } 
/*     */       
/* 272 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 274 */         var2.stackSize--;
/* 275 */         if (var2.stackSize <= 0)
/*     */         {
/* 277 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 280 */       return true;
/* 281 */     }  if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */ 
/*     */       
/* 284 */       if (!this.worldObj.isRemote) {
/*     */         
/* 286 */         setTamed(false);
/* 287 */         func_152115_b("");
/* 288 */         playTameEffect(false);
/* 289 */         this.worldObj.setEntityState((Entity)this, (byte)6);
/*     */       } 
/* 291 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 293 */         var2.stackSize--;
/* 294 */         if (var2.stackSize <= 0)
/*     */         {
/* 296 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 299 */       return true;
/*     */     } 
/*     */     
/* 302 */     if (var2 != null && isTamed() && isOwner((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*     */       
/* 304 */       if (!this.worldObj.isRemote)
/*     */       {
/* 306 */         if (!isSitting()) {
/*     */           
/* 308 */           Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ);
/* 309 */           if (bid == Blocks.sand || bid == Blocks.gravel || bid == Blocks.dirt || bid == Blocks.farmland || bid == Blocks.grass) {
/* 310 */             setSitting(true);
/*     */           }
/*     */         } else {
/* 313 */           setSitting(false);
/*     */         } 
/*     */       }
/* 316 */       return true;
/* 317 */     }  if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */       
/* 319 */       setCustomNameTag(var2.getDisplayName());
/* 320 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 322 */         var2.stackSize--;
/* 323 */         if (var2.stackSize <= 0)
/*     */         {
/* 325 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 328 */       return true;
/*     */     } 
/* 330 */     if (var2 == null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/* 331 */       if (!this.worldObj.isRemote) {
/*     */         
/* 333 */         par1EntityPlayer.mountEntity((Entity)this);
/*     */         
/* 335 */         setSitting(false);
/*     */       } 
/* 337 */       return true;
/*     */     } 
/*     */     
/* 340 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 349 */     if (isSitting())
/*     */     {
/* 351 */       return null;
/*     */     }
/* 353 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 361 */     return "orespawn:cryo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 369 */     return "orespawn:cryo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 377 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 385 */     return Items.feather;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 393 */     int var3 = 0;
/*     */     
/* 395 */     if (isTamed()) {
/*     */       
/* 397 */       var3 = this.rand.nextInt(5);
/* 398 */       var3 += 2;
/* 399 */       for (int var4 = 0; var4 < var3; var4++)
/*     */       {
/* 401 */         dropItem(Item.getItemFromBlock((Block)Blocks.red_flower), 1);
/*     */       }
/*     */     } else {
/* 404 */       super.dropFewItems(par1, par2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 415 */     return isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.5F) : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRiderSit() {
/* 425 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTrackingRange() {
/* 430 */     return 128;
/*     */   }
/*     */   
/*     */   public int getUpdateFrequency() {
/* 434 */     return 10;
/*     */   }
/*     */   
/*     */   public boolean sendsVelocityUpdates() {
/* 438 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void jump() {
/* 444 */     this.motionY += 0.25D;
/* 445 */     super.jump();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMountedYOffset() {
/* 453 */     return 1.4D;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 458 */     if (this.posY < 50.0D) return false; 
/* 459 */     if (!this.worldObj.isDaytime()) return false; 
/* 460 */     if (this.worldObj.rand.nextInt(4) != 1) return false; 
/* 461 */     Ostrich target = null;
/* 462 */     target = (Ostrich)this.worldObj.findNearestEntityWithinAABB(Ostrich.class, this.boundingBox.expand(16.0D, 6.0D, 16.0D), (Entity)this);
/* 463 */     if (target != null)
/*     */     {
/* 465 */       return false;
/*     */     }
/* 467 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 479 */     this.boatPosRotationIncrements = 10;
/*     */ 
/*     */     
/* 482 */     this.boatX = par1;
/* 483 */     this.boatY = par3;
/* 484 */     this.boatZ = par5;
/* 485 */     this.boatYaw = par7;
/* 486 */     this.boatPitch = par8;
/* 487 */     this.boatYawHead = par9;
/* 488 */     this.motionX = this.velocityX;
/* 489 */     this.motionY = this.velocityY;
/* 490 */     this.motionZ = this.velocityZ;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setVelocity(double par1, double par3, double par5) {
/* 501 */     this.velocityX = this.motionX = par1;
/* 502 */     this.velocityY = this.motionY = par3;
/* 503 */     this.velocityZ = this.motionZ = par5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 512 */     List list = null;
/* 513 */     Entity listEntity = null;
/*     */ 
/*     */ 
/*     */     
/* 517 */     double d6 = (this.rand.nextFloat() * 2.0F - 1.0F);
/* 518 */     double d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 524 */     double obstruction_factor = 0.0D;
/*     */     
/* 526 */     double relative_g = 0.0D;
/*     */     
/* 528 */     double max_speed = 0.75D;
/* 529 */     double gh = 1.0D;
/*     */ 
/*     */ 
/*     */     
/* 533 */     double rt = 0.0D;
/*     */     
/* 535 */     double pi = 3.1415926545D;
/* 536 */     double deltav = 0.0D;
/*     */ 
/*     */     
/* 539 */     int dist = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 544 */     if (this.riddenByEntity == null && !this.worldObj.isRemote) {
/* 545 */       super.onLivingUpdate();
/*     */       
/*     */       return;
/*     */     } 
/* 549 */     if (this.isDead) {
/*     */       return;
/*     */     }
/* 552 */     if (this.riddenByEntity == null) {
/* 553 */       float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 554 */       float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 555 */       this.rotationYaw += var8 / 5.0F;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 561 */     if (this.worldObj.isRemote) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 566 */       if (this.boatPosRotationIncrements > 0)
/*     */       {
/* 568 */         double d4 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
/* 569 */         double d5 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
/* 570 */         double d11 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
/* 571 */         setPosition(d4, d5, d11);
/*     */         
/* 573 */         this.rotationPitch = (float)(this.rotationPitch + (this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
/* 574 */         double d10 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
/* 575 */         if (this.riddenByEntity != null) d10 = MathHelper.wrapAngleTo180_double(this.riddenByEntity.rotationYaw - this.rotationYaw); 
/* 576 */         this.rotationYaw = (float)(this.rotationYaw + d10 / this.boatPosRotationIncrements);
/* 577 */         setRotation(this.rotationYaw, this.rotationPitch);
/*     */ 
/*     */         
/* 580 */         this.boatPosRotationIncrements--;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 591 */     else if (this.riddenByEntity != null) {
/* 592 */       EntityPlayer pp = (EntityPlayer)this.riddenByEntity;
/*     */ 
/*     */ 
/*     */       
/* 596 */       if (this.motionX < -2.0D) this.motionX = -2.0D; 
/* 597 */       if (this.motionX > 2.0D) this.motionX = 2.0D; 
/* 598 */       if (this.motionZ < -2.0D) this.motionZ = -2.0D; 
/* 599 */       if (this.motionZ > 2.0D) this.motionZ = 2.0D; 
/* 600 */       double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 606 */       obstruction_factor = 0.0D;
/* 607 */       dist = 1 + (int)(velocity * 10.0D);
/*     */       
/* 609 */       for (int k = 0; k < dist; k++) {
/* 610 */         for (int i = 1; i < dist * 2; i++) {
/* 611 */           double dx = i * Math.cos(Math.toRadians((this.rotationYaw + 90.0F)));
/* 612 */           double dz = i * Math.sin(Math.toRadians((this.rotationYaw + 90.0F)));
/* 613 */           Block bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - 1 + k, (int)(this.posZ + dz));
/* 614 */           if (bid != Blocks.air) {
/* 615 */             obstruction_factor += 0.075D;
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 622 */       this.motionY += obstruction_factor;
/* 623 */       this.posY += obstruction_factor;
/* 624 */       if (this.motionY > 4.0D) this.motionY = 4.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 630 */       double d4 = this.riddenByEntity.rotationYaw;
/* 631 */       d4 %= 360.0D;
/* 632 */       for (; d4 < 0.0D; d4 += 360.0D);
/* 633 */       double d5 = this.rotationYaw;
/* 634 */       d5 %= 360.0D;
/* 635 */       for (; d5 < 0.0D; d5 += 360.0D);
/* 636 */       relative_g = (d4 - d5) % 180.0D;
/* 637 */       for (; relative_g < 0.0D; relative_g += 180.0D);
/* 638 */       if (relative_g > 90.0D) relative_g -= 180.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 645 */       if (velocity > 0.01D) {
/*     */         
/* 647 */         d4 = 1.85D - velocity;
/* 648 */         d4 = Math.abs(d4);
/* 649 */         if (d4 < 0.01D) d4 = 0.01D; 
/* 650 */         if (d4 > 0.9D) d4 = 0.9D; 
/* 651 */         this.rotationYaw = this.riddenByEntity.rotationYaw + (float)(relative_g * d4);
/*     */       } else {
/*     */         
/* 654 */         this.rotationYaw = this.riddenByEntity.rotationYaw;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 660 */       this.rotationPitch = 2.0F * (float)velocity;
/* 661 */       setRotation(this.rotationYaw, this.rotationPitch);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 667 */       double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 675 */       double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
/* 676 */       double rhm = Math.atan2(this.motionZ, this.motionX);
/* 677 */       double rhdir = Math.toRadians(((this.riddenByEntity.rotationYaw + 90.0F) % 360.0F));
/* 678 */       rt = 0.0D;
/* 679 */       pi = 3.1415926545D;
/* 680 */       deltav = 0.0D;
/* 681 */       float im = pp.moveForward;
/*     */ 
/*     */       
/* 684 */       if (OreSpawnMain.flyup_keystate != 0)
/* 685 */       { if (this.didjump == 0) {
/* 686 */           this.motionY++;
/* 687 */           this.motionY += velocity * 6.0D;
/* 688 */           this.didjump = 20;
/*     */         }
/*     */          }
/* 691 */       else if (this.didjump > 0) { this.didjump--; }
/*     */ 
/*     */ 
/*     */       
/* 695 */       double rdv = Math.abs(rhm - rhdir) % pi * 2.0D;
/* 696 */       if (rdv > pi) rdv -= pi * 2.0D; 
/* 697 */       rdv = Math.abs(rdv);
/* 698 */       if (Math.abs(newvelocity) < 0.01D) rdv = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 706 */       if (rdv > 1.5D) newvelocity = -newvelocity;
/*     */       
/* 708 */       if (Math.abs(im) > 0.001F) {
/* 709 */         if (im > 0.0F) {
/* 710 */           deltav = 0.045D;
/* 711 */           if (this.deltasmooth < 0.0F) this.deltasmooth = 0.0F; 
/* 712 */           this.deltasmooth = (float)(this.deltasmooth + deltav / 10.0D);
/* 713 */           if (this.deltasmooth > deltav) this.deltasmooth = (float)deltav;
/*     */         
/*     */         } else {
/* 716 */           max_speed = 0.25D;
/* 717 */           deltav = -0.03D;
/* 718 */           if (this.deltasmooth > 0.0F) this.deltasmooth = 0.0F; 
/* 719 */           this.deltasmooth = (float)(this.deltasmooth + deltav / 10.0D);
/* 720 */           if (this.deltasmooth < deltav) this.deltasmooth = (float)deltav; 
/*     */         } 
/* 722 */         newvelocity += this.deltasmooth;
/* 723 */         if (newvelocity >= 0.0D) {
/* 724 */           if (newvelocity > max_speed) newvelocity = max_speed; 
/* 725 */           this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 726 */           this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*     */         } else {
/* 728 */           if (newvelocity < -max_speed) newvelocity = -max_speed; 
/* 729 */           newvelocity = -newvelocity;
/* 730 */           this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/* 731 */           this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/*     */         }
/*     */       
/*     */       }
/* 735 */       else if (newvelocity >= 0.0D) {
/* 736 */         this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 737 */         this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*     */       } else {
/* 739 */         this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/* 740 */         this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 747 */       moveEntity(this.motionX, this.motionY, this.motionZ);
/*     */ 
/*     */       
/* 750 */       this.motionY -= 0.25D;
/* 751 */       this.motionX *= 0.95D;
/* 752 */       this.motionY *= 0.85D;
/* 753 */       this.motionZ *= 0.95D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 780 */       if (this.riddenByEntity != null && this.riddenByEntity.isDead)
/*     */       {
/* 782 */         this.riddenByEntity = null;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateRiderPosition() {
/* 790 */     if (this.riddenByEntity != null) {
/*     */ 
/*     */ 
/*     */       
/* 794 */       float f = -0.15F;
/* 795 */       this.riddenByEntity.setPosition(this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void playTameEffect(boolean par1) {
/* 807 */     String s = "heart";
/*     */     
/* 809 */     if (!par1)
/*     */     {
/* 811 */       s = "smoke";
/*     */     }
/*     */     
/* 814 */     for (int i = 0; i < 20; i++) {
/*     */       
/* 816 */       double d0 = this.rand.nextGaussian() * 0.08D;
/* 817 */       double d1 = this.rand.nextGaussian() * 0.08D;
/* 818 */       double d2 = this.rand.nextGaussian() * 0.08D;
/* 819 */       this.worldObj.spawnParticle(s, this.posX + ((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5F), this.posY + 0.5D + this.rand.nextFloat() * 1.5D, this.posZ + ((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5F), d0, d1, d2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFallState(double par1, boolean par3) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 841 */     if (isChild()) {
/* 842 */       enablePersistence();
/* 843 */       return false;
/*     */     } 
/* 845 */     if (this.riddenByEntity != null) {
/* 846 */       return false;
/*     */     }
/* 848 */     if (isNoDespawnRequired()) return false; 
/* 849 */     if (isTamed()) return false; 
/* 850 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 855 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Ostrich spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 861 */     return new Ostrich(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 869 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.apple);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 878 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Ostrich.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */