/*      */ package danger.orespawn;
/*      */ 
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityAgeable;
/*      */ import net.minecraft.entity.EntityCreature;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*      */ import net.minecraft.entity.ai.EntityAILookIdle;
/*      */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*      */ import net.minecraft.entity.ai.EntityAISwimming;
/*      */ import net.minecraft.entity.ai.EntityAITempt;
/*      */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*      */ import net.minecraft.entity.boss.EntityDragon;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.monster.IMob;
/*      */ import net.minecraft.entity.passive.EntityTameable;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*      */ import net.minecraft.util.ChunkCoordinates;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.EnumDifficulty;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Leon
/*      */   extends EntityTameable
/*      */ {
/*      */   private int boatPosRotationIncrements;
/*      */   private double boatX;
/*      */   private double boatY;
/*      */   private double boatZ;
/*      */   private double boatYaw;
/*      */   private double boatPitch;
/*      */   private double boatYawHead;
/*      */   private double velocityX;
/*      */   private double velocityY;
/*      */   private double velocityZ;
/*   82 */   private GenericTargetSorter TargetSorter = null;
/*   83 */   private RenderInfo renderdata = new RenderInfo();
/*   84 */   private int hurt_timer = 0;
/*   85 */   private int wing_sound = 0;
/*   86 */   private ChunkCoordinates currentFlightTarget = null;
/*      */   private boolean target_in_sight = false;
/*   88 */   private int owner_flying = 0;
/*   89 */   private int flyaway = 0;
/*   90 */   private int stuck_count = 0;
/*   91 */   private int lastX = 0;
/*   92 */   private int lastZ = 0;
/*   93 */   private int unstick_timer = 0;
/*   94 */   private float moveSpeed = 0.25F;
/*   95 */   private float deltasmooth = 0.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Leon(World par1World) {
/*  103 */     super(par1World);
/*      */     
/*  105 */     setSize(3.5F, 8.25F);
/*  106 */     getNavigator().setAvoidsWater(true);
/*  107 */     this.experienceValue = 300;
/*  108 */     this.fireResistance = 10;
/*  109 */     this.isImmuneToFire = false;
/*  110 */     setSitting(false);
/*  111 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  112 */     this.tasks.addTask(1, new MyEntityAIFollowOwner(this, 1.1F, 16.0F, 2.0F));
/*  113 */     this.tasks.addTask(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.beef, false));
/*  114 */     this.tasks.addTask(3, new MyEntityAIWander((EntityCreature)this, 0.75F));
/*  115 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 9.0F));
/*  116 */     this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  117 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityLiving.class, 0, true, false, IMob.mobSelector)); 
/*  118 */     this.targetTasks.addTask(2, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*  119 */     this.riddenByEntity = null;
/*  120 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  121 */     this.renderdata = new RenderInfo();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Leon(World par1World, double par2, double par4, double par6) {
/*  127 */     this(par1World);
/*  128 */     setPosition(par2, par4 + this.yOffset, par6);
/*  129 */     this.motionX = 0.0D;
/*  130 */     this.motionY = 0.0D;
/*  131 */     this.motionZ = 0.0D;
/*  132 */     this.prevPosX = par2;
/*  133 */     this.prevPosY = par4;
/*  134 */     this.prevPosZ = par6;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void applyEntityAttributes() {
/*  139 */     super.applyEntityAttributes();
/*  140 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  141 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  142 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  143 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(55.0D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean shouldRiderSit() {
/*  152 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTrackingRange() {
/*  157 */     return 64;
/*      */   }
/*      */   
/*      */   public int getUpdateFrequency() {
/*  161 */     return 10;
/*      */   }
/*      */   
/*      */   public boolean sendsVelocityUpdates() {
/*  165 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void fall(float par1) {}
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateFallState(double par1, boolean par3) {}
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canTriggerWalking() {
/*  179 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void entityInit() {
/*  184 */     super.entityInit();
/*  185 */     this.dataWatcher.addObject(20, Integer.valueOf(0));
/*  186 */     this.dataWatcher.addObject(21, Integer.valueOf(0));
/*  187 */     this.dataWatcher.addObject(22, Integer.valueOf(0));
/*      */     
/*  189 */     setActivity(0);
/*  190 */     setAttacking(0);
/*  191 */     setBeingRidden(0);
/*  192 */     setTamed(false);
/*      */     
/*  194 */     if (this.renderdata == null) {
/*  195 */       this.renderdata = new RenderInfo();
/*      */     }
/*  197 */     this.renderdata.rf1 = 0.0F;
/*  198 */     this.renderdata.rf2 = 0.0F;
/*  199 */     this.renderdata.rf3 = 0.0F;
/*  200 */     this.renderdata.rf4 = 0.0F;
/*  201 */     this.renderdata.ri1 = 0;
/*  202 */     this.renderdata.ri2 = 0;
/*  203 */     this.renderdata.ri3 = 0;
/*  204 */     this.renderdata.ri4 = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int mygetMaxHealth() {
/*  211 */     return 250;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getLeonHealth() {
/*  218 */     return (int)getHealth();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RenderInfo getRenderInfo() {
/*  225 */     return this.renderdata;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRenderInfo(RenderInfo r) {
/*  230 */     this.renderdata.rf1 = r.rf1;
/*  231 */     this.renderdata.rf2 = r.rf2;
/*  232 */     this.renderdata.rf3 = r.rf3;
/*  233 */     this.renderdata.rf4 = r.rf4;
/*  234 */     this.renderdata.ri1 = r.ri1;
/*  235 */     this.renderdata.ri2 = r.ri2;
/*  236 */     this.renderdata.ri3 = r.ri3;
/*  237 */     this.renderdata.ri4 = r.ri4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  245 */     return 16;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void jump() {
/*  251 */     super.jump();
/*  252 */     this.motionY += 0.25D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAIEnabled() {
/*  260 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBreatheUnderwater() {
/*  269 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLivingSound() {
/*  277 */     if (isSitting())
/*      */     {
/*  279 */       return null;
/*      */     }
/*  281 */     if (getActivity() == 1 && this.riddenByEntity == null) {
/*  282 */       return "orespawn:leon_living";
/*      */     }
/*      */     
/*  285 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getHurtSound() {
/*  293 */     return "orespawn:leon_hit";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDeathSound() {
/*  301 */     return "orespawn:leon_death";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundVolume() {
/*  308 */     return 1.75F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getSoundPitch() {
/*  315 */     return 0.85F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBePushed() {
/*  324 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getMountedYOffset() {
/*  332 */     return 3.75D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/*  340 */     return Items.beef;
/*      */   }
/*      */ 
/*      */   
/*      */   private ItemStack dropItemRand(Item index, int par1) {
/*  345 */     EntityItem var3 = null;
/*  346 */     ItemStack is = new ItemStack(index, par1, 0);
/*      */     
/*  348 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 2.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), is);
/*      */     
/*  350 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/*  351 */     return is;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/*  359 */     int i = 4 + this.worldObj.rand.nextInt(6); int var4;
/*  360 */     for (var4 = 0; var4 < i; var4++) {
/*  361 */       dropItemRand(Items.chicken, 1);
/*      */     }
/*  363 */     i = 16 + this.worldObj.rand.nextInt(6);
/*  364 */     for (var4 = 0; var4 < i; var4++) {
/*  365 */       dropItemRand(Items.feather, 1);
/*      */     }
/*  367 */     i = 2 + this.worldObj.rand.nextInt(6);
/*  368 */     for (var4 = 0; var4 < i; var4++) {
/*  369 */       dropItemRand(Item.getItemFromBlock(OreSpawnMain.KrakenRepellent), 1);
/*      */     }
/*  371 */     if (this.worldObj.rand.nextInt(5) == 1) dropItemRand(OreSpawnMain.MyBattleAxe, 1);
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  380 */     double ks = 1.25D;
/*  381 */     double inair = 0.15D;
/*  382 */     float iskraken = 1.0F;
/*  383 */     if (par1Entity != null && par1Entity instanceof EntityDragon) {
/*  384 */       EntityDragon dr = (EntityDragon)par1Entity;
/*  385 */       DamageSource var21 = null;
/*  386 */       var21 = DamageSource.setExplosionSource(null);
/*  387 */       var21.setExplosion();
/*  388 */       if (this.worldObj.rand.nextInt(6) == 1) {
/*  389 */         dr.attackEntityFromPart(dr.dragonPartHead, var21, 55.0F);
/*      */       } else {
/*  391 */         dr.attackEntityFromPart(dr.dragonPartBody, var21, 55.0F);
/*      */       }
/*      */     
/*  394 */     } else if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*      */       
/*  396 */       if (par1Entity instanceof Kraken) iskraken = 4.0F; 
/*  397 */       par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), iskraken * 55.0F);
/*      */       
/*  399 */       float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/*  400 */       if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/*  401 */       par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*      */     } 
/*      */     
/*  404 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  412 */     boolean ret = false;
/*  413 */     Entity e = null;
/*      */     
/*  415 */     if (this.hurt_timer > 0) return false;
/*      */ 
/*      */     
/*  418 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/*  419 */       return ret;
/*      */     }
/*      */     
/*  422 */     if (!this.worldObj.isRemote) setSitting(false); 
/*  423 */     if (!this.worldObj.isRemote) setActivity(1);
/*      */     
/*  425 */     e = par1DamageSource.getEntity();
/*      */ 
/*      */     
/*  428 */     if (e != null && e instanceof Leon) {
/*  429 */       return false;
/*      */     }
/*      */     
/*  432 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*  433 */     this.hurt_timer = 15;
/*      */     
/*  435 */     if (e != null && e instanceof EntityLivingBase && !this.worldObj.isRemote) {
/*      */       
/*  437 */       if (isTamed() && 
/*  438 */         e instanceof EntityPlayer) {
/*  439 */         return false;
/*      */       }
/*      */ 
/*      */       
/*  443 */       setAttackTarget((EntityLivingBase)e);
/*  444 */       setTarget(e);
/*  445 */       getNavigator().tryMoveToEntityLiving(e, 1.2D);
/*  446 */       ret = true;
/*      */     } 
/*      */     
/*  449 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateAITasks() {
/*  456 */     if (this.worldObj.isRemote)
/*  457 */       return;  super.updateAITasks();
/*  458 */     if (this.worldObj.rand.nextInt(200) == 1) setAttackTarget(null);
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fly_with_rider() {
/*  466 */     EntityLivingBase e = null;
/*  467 */     int freq = 7;
/*      */ 
/*      */ 
/*      */     
/*  471 */     if (this.isDead)
/*      */       return; 
/*  473 */     if (isSitting())
/*  474 */       return;  if (this.worldObj.isRemote)
/*      */       return; 
/*  476 */     if (this.worldObj.rand.nextInt(freq) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
/*      */       
/*  478 */       e = getAttackTarget();
/*  479 */       if (e != null && !e.isEntityAlive()) {
/*  480 */         setAttackTarget(null);
/*  481 */         e = null;
/*      */       } 
/*  483 */       if (e == null) {
/*  484 */         e = findSomethingToAttack();
/*      */       }
/*  486 */       if (e != null) {
/*      */         
/*  488 */         setAttacking(1);
/*      */         
/*  490 */         if (getDistanceSqToEntity((Entity)e) < ((9.0F + e.width / 2.0F) * (9.0F + e.width / 2.0F)))
/*      */         {
/*  492 */           attackEntityAsMob((Entity)e);
/*      */         }
/*      */         
/*      */         return;
/*      */       } 
/*  497 */       setAttacking(0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateAITick() {
/*  508 */     if (this.riddenByEntity != null)
/*  509 */       return;  if (this.worldObj.isRemote)
/*  510 */       return;  super.updateAITick();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/*  518 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false; 
/*  519 */     if (OreSpawnMain.PlayNicely != 0) return false;
/*      */     
/*  521 */     if (par1EntityLiving == null)
/*      */     {
/*  523 */       return false;
/*      */     }
/*  525 */     if (par1EntityLiving == this)
/*      */     {
/*  527 */       return false;
/*      */     }
/*  529 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/*      */       
/*  532 */       return false;
/*      */     }
/*      */     
/*  535 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*      */     
/*  537 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*      */       
/*  540 */       return false;
/*      */     }
/*      */     
/*  543 */     if (par1EntityLiving instanceof Leon)
/*      */     {
/*  545 */       return false;
/*      */     }
/*  547 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityMob)
/*      */     {
/*  549 */       return true;
/*      */     }
/*      */     
/*  552 */     if (par1EntityLiving instanceof EntityPlayer) {
/*      */       
/*  554 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/*  555 */       if (p.capabilities.isCreativeMode == true) {
/*  556 */         return false;
/*      */       }
/*  558 */       if (isTamed()) {
/*  559 */         return false;
/*      */       }
/*  561 */       return true;
/*      */     } 
/*      */     
/*  564 */     if (!isTamed()) {
/*  565 */       if (MyUtils.isAttackableNonMob(par1EntityLiving)) {
/*  566 */         return true;
/*      */       }
/*      */     }
/*      */     
/*  570 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private EntityLivingBase findSomethingToAttack() {
/*  575 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/*  576 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(20.0D, 20.0D, 20.0D));
/*  577 */     Collections.sort(var5, this.TargetSorter);
/*  578 */     Iterator<?> var2 = var5.iterator();
/*  579 */     Entity var3 = null;
/*  580 */     EntityLivingBase var4 = null;
/*      */     
/*  582 */     while (var2.hasNext()) {
/*      */       
/*  584 */       var3 = (Entity)var2.next();
/*  585 */       var4 = (EntityLivingBase)var3;
/*      */       
/*  587 */       if (isSuitableTarget(var4, false))
/*      */       {
/*  589 */         return var4;
/*      */       }
/*      */     } 
/*  592 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean doesEntityNotTriggerPressurePlate() {
/*  599 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanSpawnHere() {
/*  611 */     for (int k = -3; k < 3; k++) {
/*      */       
/*  613 */       for (int j = -3; j < 3; j++) {
/*      */         
/*  615 */         for (int i = 0; i < 5; i++) {
/*      */           
/*  617 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/*  618 */           if (bid == Blocks.mob_spawner) {
/*  619 */             TileEntityMobSpawner tileentitymobspawner = null;
/*  620 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/*  621 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/*  622 */             if (s != null && 
/*  623 */               s.equals("Leonopteryx")) return true;
/*      */           
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  629 */     if (this.worldObj.rand.nextInt(16) != 0) return false; 
/*  630 */     Leon target = null;
/*  631 */     if (!this.worldObj.isDaytime()) return false; 
/*  632 */     target = (Leon)this.worldObj.findNearestEntityWithinAABB(Leon.class, this.boundingBox.expand(48.0D, 16.0D, 48.0D), (Entity)this);
/*  633 */     if (target != null)
/*      */     {
/*  635 */       return false;
/*      */     }
/*  637 */     if (this.posY < 50.0D) return false; 
/*  638 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/*  646 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
/*  657 */     super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
/*  658 */     this.boatPosRotationIncrements = par9;
/*      */     
/*  660 */     this.boatX = par1;
/*  661 */     this.boatY = par3;
/*  662 */     this.boatZ = par5;
/*  663 */     this.boatYaw = par7;
/*  664 */     this.boatPitch = par8;
/*  665 */     this.boatYawHead = par7;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void setVelocity(double par1, double par3, double par5) {
/*  675 */     super.setVelocity(par1, par3, par5);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate() {
/*  681 */     EntityLivingBase e = null;
/*  682 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  683 */     super.onUpdate();
/*      */     
/*  685 */     if (this.hurt_timer > 0) this.hurt_timer--;
/*      */     
/*  687 */     if (getActivity() == 1) {
/*  688 */       this.wing_sound++;
/*  689 */       if (this.wing_sound > 20) {
/*      */         
/*  691 */         if (!this.worldObj.isRemote) this.worldObj.playSoundAtEntity((Entity)this, "orespawn:MothraWings", 0.5F, 1.0F); 
/*  692 */         this.wing_sound = 0;
/*      */       } 
/*      */     } 
/*      */     
/*  696 */     if (isInWater()) {
/*  697 */       this.motionY += 0.07D;
/*      */     }
/*      */     
/*  700 */     if (this.worldObj.isRemote)
/*      */       return; 
/*  702 */     if (getActivity() == 0 && isTamed() && getOwner() != null && !isSitting()) {
/*  703 */       e = getOwner();
/*      */       
/*  705 */       if (e != null && getDistanceSqToEntity((Entity)e) > 144.0D)
/*      */       {
/*  707 */         setActivity(1);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void fly_without_rider() {
/*  715 */     int xdir = 1;
/*  716 */     int zdir = 1;
/*      */     
/*  718 */     int keep_trying = 50;
/*      */ 
/*      */     
/*  721 */     int do_new = 0;
/*  722 */     double ox = 0.0D, oy = 0.0D, oz = 0.0D;
/*      */     
/*  724 */     int has_owner = 0;
/*  725 */     EntityLivingBase e = null;
/*  726 */     double speed_factor = 0.5D;
/*  727 */     double var1 = 0.0D;
/*  728 */     double var3 = 0.0D;
/*  729 */     double var5 = 0.0D;
/*      */ 
/*      */     
/*  732 */     double gh = 1.25D;
/*  733 */     double obstruction_factor = 0.0D;
/*  734 */     double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*  735 */     int toofar = 0;
/*      */     
/*  737 */     if (this.worldObj.isRemote) {
/*      */       return;
/*      */     }
/*  740 */     if (this.currentFlightTarget == null) {
/*  741 */       do_new = 1;
/*  742 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*      */     } 
/*      */     
/*  745 */     if (isSitting())
/*  746 */       return;  if (this.riddenByEntity != null)
/*      */       return; 
/*  748 */     if (this.unstick_timer > 0) this.unstick_timer--; 
/*  749 */     if (this.lastX == (int)this.posX && this.lastZ == (int)this.posZ) {
/*      */       
/*  751 */       this.stuck_count++;
/*  752 */       if (this.stuck_count > 50) {
/*  753 */         this.stuck_count = 0;
/*  754 */         this.unstick_timer = 100;
/*  755 */         this.target_in_sight = false;
/*  756 */         setAttacking(0);
/*  757 */         setActivity(1);
/*  758 */         do_new = 1;
/*      */       } 
/*      */     } else {
/*      */       
/*  762 */       this.stuck_count = 0;
/*  763 */       this.lastX = (int)this.posX;
/*  764 */       this.lastZ = (int)this.posZ;
/*      */     } 
/*      */     
/*  767 */     if (this.posY < this.currentFlightTarget.posY + 2.0D) {
/*  768 */       this.motionY *= 0.7D;
/*  769 */     } else if (this.posY > this.currentFlightTarget.posY - 2.0D) {
/*  770 */       this.motionY *= 0.5D;
/*      */     } else {
/*  772 */       this.motionY *= 0.61D;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  777 */     if (this.worldObj.rand.nextInt(300) == 1) do_new = 1;
/*      */ 
/*      */     
/*  780 */     if (isTamed() && getOwner() != null) {
/*  781 */       e = getOwner();
/*  782 */       has_owner = 1;
/*  783 */       ox = e.posX;
/*  784 */       oy = e.posY;
/*  785 */       oz = e.posZ;
/*  786 */       if (getDistanceSqToEntity((Entity)e) > 144.0D) {
/*  787 */         toofar = 1;
/*  788 */         this.target_in_sight = false;
/*  789 */         setAttacking(0);
/*  790 */         this.flyaway = 0;
/*  791 */         do_new = 1;
/*      */       } 
/*      */     } 
/*      */     
/*  795 */     if (this.flyaway > 0) this.flyaway--;
/*      */ 
/*      */     
/*  798 */     if (toofar == 0 && this.unstick_timer == 0 && this.flyaway == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(8) == 1) {
/*      */ 
/*      */ 
/*      */       
/*  802 */       e = findSomethingToAttack();
/*  803 */       if (e != null) {
/*      */         
/*  805 */         if (isTamed() && getHealth() / mygetMaxHealth() < 0.25F) {
/*  806 */           setActivity(1);
/*  807 */           setAttacking(0);
/*  808 */           this.target_in_sight = false;
/*  809 */           do_new = 0;
/*  810 */           this.currentFlightTarget.set((int)(this.posX + this.posX - e.posX), (int)(this.posY + 1.0D), (int)(this.posZ + this.posZ - e.posZ));
/*      */         } else {
/*      */           
/*  813 */           setActivity(1);
/*  814 */           setAttacking(1);
/*  815 */           this.target_in_sight = true;
/*  816 */           this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0D), (int)e.posZ);
/*      */           
/*  818 */           do_new = 0;
/*  819 */           if (getDistanceSqToEntity((Entity)e) < ((7.0F + e.width / 2.0F) * (7.0F + e.width / 2.0F))) {
/*  820 */             attackEntityAsMob((Entity)e);
/*      */           }
/*      */         } 
/*      */       } else {
/*  824 */         this.target_in_sight = false;
/*  825 */         this.flyaway = 0;
/*  826 */         setAttacking(0);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  831 */     if (this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 4.1F)
/*      */     {
/*  833 */       do_new = 1;
/*      */     }
/*      */ 
/*      */     
/*  837 */     if ((do_new != 0 && !this.target_in_sight) || (do_new != 0 && this.flyaway != 0)) {
/*      */       
/*  839 */       Block bid = Blocks.stone;
/*  840 */       while (bid != Blocks.air && keep_trying != 0) {
/*  841 */         int gox = (int)this.posX;
/*  842 */         int goy = (int)this.posY;
/*  843 */         int goz = (int)this.posZ;
/*  844 */         if (has_owner == 1 && this.unstick_timer == 0) {
/*  845 */           gox = (int)ox;
/*  846 */           goy = (int)oy;
/*  847 */           goz = (int)oz;
/*  848 */           if (this.owner_flying == 0) {
/*  849 */             zdir = this.worldObj.rand.nextInt(12) + 6;
/*  850 */             xdir = this.worldObj.rand.nextInt(12) + 6;
/*      */           } else {
/*  852 */             zdir = this.worldObj.rand.nextInt(8);
/*  853 */             xdir = this.worldObj.rand.nextInt(8);
/*      */           } 
/*      */         } else {
/*  856 */           zdir = this.worldObj.rand.nextInt(20) + 6;
/*  857 */           xdir = this.worldObj.rand.nextInt(20) + 6;
/*      */         } 
/*  859 */         if (this.worldObj.rand.nextInt(2) == 1) zdir = -zdir; 
/*  860 */         if (this.worldObj.rand.nextInt(2) == 1) xdir = -xdir; 
/*  861 */         this.currentFlightTarget.set(gox + xdir, goy + this.worldObj.rand.nextInt(9 + this.owner_flying * 2) - 4, goz + zdir);
/*  862 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/*  863 */         if (bid == Blocks.air && 
/*  864 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/*  865 */           bid = Blocks.stone;
/*      */         }
/*      */ 
/*      */         
/*  869 */         keep_trying--;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  877 */     obstruction_factor = 0.0D;
/*  878 */     int dist = 2;
/*  879 */     dist += (int)(velocity * 4.0D);
/*      */     
/*  881 */     for (int k = 1; k < dist; k++) {
/*  882 */       for (int i = 1; i < dist * 2; i++) {
/*  883 */         double dx = i * Math.cos(Math.toRadians((this.rotationYaw + 90.0F)));
/*  884 */         double dz = i * Math.sin(Math.toRadians((this.rotationYaw + 90.0F)));
/*  885 */         Block bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - k, (int)(this.posZ + dz));
/*  886 */         if (bid != Blocks.air) {
/*  887 */           obstruction_factor += 0.05D;
/*      */         }
/*      */       } 
/*      */     } 
/*  891 */     this.motionY += obstruction_factor * 0.05D;
/*  892 */     this.posY += obstruction_factor * 0.05D;
/*      */ 
/*      */     
/*  895 */     speed_factor = 0.5D;
/*  896 */     var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/*  897 */     var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/*  898 */     var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/*  899 */     if (this.owner_flying != 0) {
/*  900 */       speed_factor = 1.75D;
/*  901 */       if (isTamed() && getOwner() != null) {
/*  902 */         e = getOwner();
/*  903 */         if (getDistanceSqToEntity((Entity)e) > 49.0D) {
/*  904 */           speed_factor = 3.5D;
/*      */         }
/*      */       } 
/*      */     } 
/*  908 */     this.motionX += (Math.signum(var1) - this.motionX) * 0.15D * speed_factor;
/*  909 */     this.motionY += (Math.signum(var3) - this.motionY) * 0.21D * speed_factor;
/*  910 */     this.motionZ += (Math.signum(var5) - this.motionZ) * 0.15D * speed_factor;
/*  911 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/*  912 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/*  913 */     this.moveForward = (float)(0.75D * speed_factor);
/*      */     
/*  915 */     this.rotationYaw += var8 / 5.0F;
/*  916 */     moveEntity(this.motionX, this.motionY, this.motionZ);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onLivingUpdate() {
/*  926 */     List<Entity> list = null;
/*  927 */     Entity listEntity = null;
/*      */ 
/*      */ 
/*      */     
/*  931 */     double d6 = (this.rand.nextFloat() * 2.0F - 1.0F);
/*  932 */     double d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  938 */     double obstruction_factor = 0.0D;
/*      */     
/*  940 */     double relative_g = 0.0D;
/*      */     
/*  942 */     double max_speed = 1.15D;
/*  943 */     double gh = 1.0D;
/*      */ 
/*      */ 
/*      */     
/*  947 */     double rt = 0.0D;
/*      */     
/*  949 */     double pi = 3.1415926545D;
/*  950 */     double deltav = 0.0D;
/*      */ 
/*      */     
/*  953 */     int dist = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  959 */     always_do();
/*      */     
/*  961 */     if (getActivity() == 0) {
/*      */       
/*  963 */       super.onLivingUpdate();
/*      */     
/*      */     }
/*  966 */     else if (this.isDead) {
/*  967 */       super.onLivingUpdate();
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  972 */     if (this.isDead) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  977 */     if (this.worldObj.isRemote) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  982 */       if (this.boatPosRotationIncrements > 0 && getActivity() != 0)
/*      */       {
/*  984 */         double d4 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
/*  985 */         double d5 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
/*  986 */         double d11 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
/*  987 */         setPosition(d4, d5, d11);
/*  988 */         this.rotationPitch = (float)(this.rotationPitch + (this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
/*  989 */         double d10 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
/*  990 */         if (this.riddenByEntity != null) d10 = MathHelper.wrapAngleTo180_double(this.riddenByEntity.rotationYaw - this.rotationYaw); 
/*  991 */         this.rotationYaw = (float)(this.rotationYaw + d10 / this.boatPosRotationIncrements);
/*  992 */         setRotation(this.rotationYaw, this.rotationPitch);
/*  993 */         this.rotationYawHead = this.rotationYaw;
/*      */         
/*  995 */         this.boatPosRotationIncrements--;
/*      */ 
/*      */       
/*      */       }
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/* 1006 */       if (this.riddenByEntity != null) {
/* 1007 */         setBeingRidden(1);
/*      */       } else {
/* 1009 */         setBeingRidden(0);
/*      */       } 
/* 1011 */       if (getActivity() != 0)
/*      */       {
/*      */         
/* 1014 */         if (this.riddenByEntity != null) {
/* 1015 */           EntityPlayer pp = (EntityPlayer)this.riddenByEntity;
/*      */ 
/*      */ 
/*      */           
/* 1019 */           if (this.motionX < -2.0D) this.motionX = -2.0D; 
/* 1020 */           if (this.motionX > 2.0D) this.motionX = 2.0D; 
/* 1021 */           if (this.motionZ < -2.0D) this.motionZ = -2.0D; 
/* 1022 */           if (this.motionZ > 2.0D) this.motionZ = 2.0D; 
/* 1023 */           double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */ 
/*      */           
/* 1026 */           gh = 1.55D;
/* 1027 */           Block bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh), (int)this.posZ);
/* 1028 */           if (bid != Blocks.air) {
/* 1029 */             this.motionY += 0.03D;
/* 1030 */             this.posY += 0.1D;
/*      */           } else {
/*      */             
/* 1033 */             this.motionY -= 0.018D;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1040 */           obstruction_factor = 0.0D;
/* 1041 */           dist = 3;
/* 1042 */           dist += (int)(velocity * 7.0D);
/*      */           
/* 1044 */           for (int k = 1; k < dist; k++) {
/* 1045 */             for (int i = 1; i < dist * 2; i++) {
/* 1046 */               double dx = i * Math.cos(Math.toRadians((this.rotationYaw + 90.0F)));
/* 1047 */               double dz = i * Math.sin(Math.toRadians((this.rotationYaw + 90.0F)));
/* 1048 */               bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - k, (int)(this.posZ + dz));
/* 1049 */               if (bid != Blocks.air) {
/* 1050 */                 obstruction_factor += 0.05D;
/*      */               }
/*      */             } 
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 1057 */           this.motionY += obstruction_factor * 0.07D;
/* 1058 */           this.posY += obstruction_factor * 0.07D;
/* 1059 */           if (this.motionY > 2.0D) this.motionY = 2.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1067 */           if (this.riddenByEntity != null) {
/*      */ 
/*      */             
/* 1070 */             double d4 = this.riddenByEntity.rotationYaw;
/* 1071 */             d4 %= 360.0D;
/* 1072 */             for (; d4 < 0.0D; d4 += 360.0D);
/* 1073 */             double d5 = this.rotationYaw;
/* 1074 */             d5 %= 360.0D;
/* 1075 */             for (; d5 < 0.0D; d5 += 360.0D);
/* 1076 */             relative_g = (d4 - d5) % 180.0D;
/* 1077 */             for (; relative_g < 0.0D; relative_g += 180.0D);
/* 1078 */             if (relative_g > 90.0D) relative_g -= 180.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1085 */             if (velocity > 0.01D) {
/*      */               
/* 1087 */               d4 = 1.85D - velocity;
/* 1088 */               d4 = Math.abs(d4);
/* 1089 */               if (d4 < 0.01D) d4 = 0.01D; 
/* 1090 */               if (d4 > 0.9D) d4 = 0.9D; 
/* 1091 */               this.rotationYaw = this.riddenByEntity.rotationYaw + (float)(relative_g * d4);
/*      */             } else {
/*      */               
/* 1094 */               this.rotationYaw = this.riddenByEntity.rotationYaw;
/*      */             } 
/* 1096 */             relative_g = Math.abs(relative_g) * velocity;
/* 1097 */             if (relative_g > 50.0D) relative_g = 0.0D;
/*      */           
/*      */           } 
/*      */ 
/*      */           
/* 1102 */           this.rotationPitch = 2.0F * (float)velocity;
/* 1103 */           setRotation(this.rotationYaw, this.rotationPitch);
/* 1104 */           this.rotationYawHead = this.rotationYaw;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1109 */           double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1117 */           double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
/* 1118 */           double rhm = Math.atan2(this.motionZ, this.motionX);
/* 1119 */           double rhdir = Math.toRadians(((this.riddenByEntity.rotationYaw + 90.0F) % 360.0F));
/* 1120 */           rt = 0.0D;
/* 1121 */           pi = 3.1415926545D;
/* 1122 */           deltav = 0.0D;
/* 1123 */           float im = pp.moveForward;
/*      */ 
/*      */           
/* 1126 */           if (OreSpawnMain.flyup_keystate != 0) {
/* 1127 */             this.motionY += 0.035D;
/* 1128 */             this.motionY += velocity * 0.038D;
/*      */           } 
/*      */ 
/*      */           
/* 1132 */           double rdv = Math.abs(rhm - rhdir) % pi * 2.0D;
/* 1133 */           if (rdv > pi) rdv -= pi * 2.0D; 
/* 1134 */           rdv = Math.abs(rdv);
/* 1135 */           if (Math.abs(newvelocity) < 0.01D) rdv = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1143 */           if (rdv > 1.5D) newvelocity = -newvelocity;
/*      */           
/* 1145 */           if (Math.abs(im) > 0.001F) {
/* 1146 */             if (im > 0.0F) {
/* 1147 */               deltav = 0.028D;
/* 1148 */               if (max_speed > 1.0D) deltav += 0.06D; 
/* 1149 */               if (this.deltasmooth < 0.0F) this.deltasmooth = 0.0F; 
/* 1150 */               this.deltasmooth = (float)(this.deltasmooth + deltav / 10.0D);
/* 1151 */               if (this.deltasmooth > deltav) this.deltasmooth = (float)deltav;
/*      */             
/*      */             } else {
/* 1154 */               max_speed = 0.35D;
/*      */               
/* 1156 */               deltav = -0.02D;
/* 1157 */               if (this.deltasmooth > 0.0F) this.deltasmooth = 0.0F; 
/* 1158 */               this.deltasmooth = (float)(this.deltasmooth + deltav / 10.0D);
/* 1159 */               if (this.deltasmooth < deltav) this.deltasmooth = (float)deltav;
/*      */             
/*      */             } 
/* 1162 */             newvelocity += this.deltasmooth;
/* 1163 */             if (newvelocity >= 0.0D) {
/* 1164 */               if (newvelocity > max_speed) newvelocity = max_speed; 
/* 1165 */               this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 1166 */               this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*      */             } else {
/* 1168 */               if (newvelocity < -max_speed) newvelocity = -max_speed; 
/* 1169 */               newvelocity = -newvelocity;
/* 1170 */               this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/* 1171 */               this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/*      */             }
/*      */           
/*      */           }
/* 1175 */           else if (newvelocity >= 0.0D) {
/* 1176 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 1177 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*      */           } else {
/* 1179 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/* 1180 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1187 */           moveEntity(this.motionX, this.motionY, this.motionZ);
/*      */ 
/*      */           
/* 1190 */           this.motionX *= 0.985D;
/* 1191 */           this.motionY *= 0.94D;
/* 1192 */           this.motionZ *= 0.985D;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1197 */           if (!this.worldObj.isRemote) {
/*      */             
/* 1199 */             list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(2.25D, 2.0D, 2.25D));
/*      */             
/* 1201 */             if (list != null && !list.isEmpty())
/*      */             {
/* 1203 */               for (int l = 0; l < list.size(); l++) {
/*      */                 
/* 1205 */                 listEntity = list.get(l);
/*      */                 
/* 1207 */                 if (listEntity != this.riddenByEntity && !listEntity.isDead && listEntity.canBePushed())
/*      */                 {
/* 1209 */                   listEntity.applyEntityCollision((Entity)this);
/*      */                 }
/*      */               } 
/*      */             }
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 1217 */           fly_with_rider();
/*      */           
/* 1219 */           if (this.riddenByEntity != null && this.riddenByEntity.isDead)
/*      */           {
/* 1221 */             this.riddenByEntity = null;
/*      */           }
/*      */         } else {
/*      */           
/* 1225 */           fly_without_rider();
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void always_do() {
/* 1236 */     EntityLivingBase e = null;
/* 1237 */     EntityPlayer pl = null;
/*      */ 
/*      */     
/* 1240 */     if (this.worldObj.isRemote) {
/*      */       return;
/*      */     }
/* 1243 */     if (!isSitting() && getActivity() == 0 && this.riddenByEntity == null && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(10) == 1) {
/*      */       
/* 1245 */       e = findSomethingToAttack();
/* 1246 */       if (e != null)
/*      */       {
/*      */         
/* 1249 */         setActivity(1);
/*      */       }
/*      */     } 
/*      */     
/* 1253 */     if (this.worldObj.rand.nextInt(250) == 1 && 
/* 1254 */       getHealth() < mygetMaxHealth())
/*      */     {
/* 1256 */       heal(2.0F);
/*      */     }
/*      */ 
/*      */     
/* 1260 */     if (isSitting())
/*      */       return; 
/* 1262 */     this.owner_flying = 0;
/* 1263 */     if (isTamed() && getOwner() != null && this.riddenByEntity == null && !isSitting()) {
/* 1264 */       pl = (EntityPlayer)getOwner();
/*      */       
/* 1266 */       if (pl.capabilities.isFlying) {
/* 1267 */         this.owner_flying = 1;
/*      */         
/* 1269 */         setActivity(1);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1274 */     if (isTamed() && getOwner() != null && !isSitting()) {
/* 1275 */       pl = (EntityPlayer)getOwner();
/*      */       
/* 1277 */       if (getDistanceSqToEntity((Entity)pl) > 400.0D)
/*      */       {
/* 1279 */         setActivity(1);
/*      */       }
/*      */     } 
/*      */     
/* 1283 */     if (this.worldObj.rand.nextInt(50) == 1 && !isSitting())
/*      */     {
/* 1285 */       if (!this.target_in_sight && this.riddenByEntity == null)
/*      */       {
/* 1287 */         if (this.worldObj.rand.nextInt(15) == 1) {
/*      */           
/* 1289 */           setActivity(1);
/*      */         } else {
/*      */           
/* 1292 */           setActivity(0);
/*      */         } 
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateRiderPosition() {
/* 1300 */     if (this.riddenByEntity != null) {
/*      */ 
/*      */ 
/*      */       
/* 1304 */       float f = 0.65F;
/* 1305 */       this.riddenByEntity.setPosition(this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void playTameEffect(boolean par1) {
/* 1317 */     String s = "heart";
/*      */     
/* 1319 */     if (!par1)
/*      */     {
/* 1321 */       s = "smoke";
/*      */     }
/*      */     
/* 1324 */     for (int i = 0; i < 20; i++) {
/*      */       
/* 1326 */       double d0 = this.rand.nextGaussian() * 0.08D;
/* 1327 */       double d1 = this.rand.nextGaussian() * 0.08D;
/* 1328 */       double d2 = this.rand.nextGaussian() * 0.08D;
/* 1329 */       this.worldObj.spawnParticle(s, this.posX + ((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5F), this.posY + 0.5D + this.rand.nextFloat() * 1.5D, this.posZ + ((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5F), d0, d1, d2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 1340 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*      */     
/* 1342 */     if (var2 != null && 
/* 1343 */       var2.stackSize <= 0) {
/* 1344 */       par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 1345 */       var2 = null;
/*      */     } 
/*      */ 
/*      */     
/* 1349 */     if (var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.diamond_block) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 49.0D) {
/* 1350 */       if (!this.worldObj.isRemote) {
/*      */         
/* 1352 */         setTamed(true);
/* 1353 */         func_152115_b(par1EntityPlayer.getUniqueID().toString());
/* 1354 */         playTameEffect(true);
/* 1355 */         this.worldObj.setEntityState((Entity)this, (byte)7);
/* 1356 */         heal(mygetMaxHealth() - getHealth());
/*      */       } 
/*      */ 
/*      */       
/* 1360 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 1361 */         var2.stackSize--;
/* 1362 */         if (var2.stackSize <= 0) {
/* 1363 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/* 1366 */       return true;
/*      */     } 
/*      */     
/* 1369 */     if (!isTamed()) {
/* 1370 */       if (var2 != null && var2.getItem() == Items.beef && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 49.0D) {
/* 1371 */         if (!this.worldObj.isRemote) {
/* 1372 */           if (this.worldObj.rand.nextInt(3) == 1) {
/* 1373 */             setTamed(true);
/* 1374 */             func_152115_b(par1EntityPlayer.getUniqueID().toString());
/* 1375 */             playTameEffect(true);
/* 1376 */             this.worldObj.setEntityState((Entity)this, (byte)7);
/* 1377 */             heal(mygetMaxHealth() - getHealth());
/*      */           } else {
/*      */             
/* 1380 */             playTameEffect(false);
/* 1381 */             this.worldObj.setEntityState((Entity)this, (byte)6);
/*      */           } 
/*      */         }
/* 1384 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 1385 */           var2.stackSize--;
/* 1386 */           if (var2.stackSize <= 0) {
/* 1387 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1390 */         return true;
/*      */       } 
/*      */     } else {
/*      */       
/* 1394 */       if (!isOwner((EntityLivingBase)par1EntityPlayer)) {
/* 1395 */         return false;
/*      */       }
/*      */       
/* 1398 */       if (var2 == null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 49.0D) {
/* 1399 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1401 */           par1EntityPlayer.mountEntity((Entity)this);
/*      */           
/* 1403 */           setActivity(1);
/* 1404 */           setSitting(false);
/*      */         } 
/* 1406 */         return true;
/*      */       } 
/*      */       
/* 1409 */       if (var2 != null && var2.getItem() == Items.beef && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 49.0D) {
/* 1410 */         if (this.worldObj.isRemote) {
/* 1411 */           playTameEffect(true);
/* 1412 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/* 1415 */         if (mygetMaxHealth() > getHealth()) {
/* 1416 */           heal(mygetMaxHealth() - getHealth());
/*      */         }
/* 1418 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 1419 */           var2.stackSize--;
/* 1420 */           if (var2.stackSize <= 0) {
/* 1421 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1424 */         return true;
/*      */       } 
/* 1426 */       if (var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 49.0D) {
/*      */         
/* 1428 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1430 */           setTamed(false);
/* 1431 */           func_152115_b("");
/* 1432 */           playTameEffect(false);
/* 1433 */           this.worldObj.setEntityState((Entity)this, (byte)6);
/*      */         } 
/* 1435 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 1436 */           var2.stackSize--;
/* 1437 */           if (var2.stackSize <= 0) {
/* 1438 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1441 */         return true;
/*      */       } 
/* 1443 */       if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 49.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */         
/* 1445 */         setCustomNameTag(var2.getDisplayName());
/* 1446 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1448 */           var2.stackSize--;
/* 1449 */           if (var2.stackSize <= 0)
/*      */           {
/* 1451 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1454 */         return true;
/*      */       } 
/* 1456 */       if (var2 != null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 49.0D && this.riddenByEntity == null) {
/*      */         
/* 1458 */         if (!isSitting()) {
/* 1459 */           setSitting(true);
/* 1460 */           setActivity(0);
/*      */         } else {
/* 1462 */           setSitting(false);
/* 1463 */           setActivity(0);
/*      */         } 
/* 1465 */         return true;
/*      */       } 
/*      */     } 
/*      */     
/* 1469 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWheat(ItemStack par1ItemStack) {
/* 1477 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.beef);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAttacking() {
/* 1483 */     return this.dataWatcher.getWatchableObjectInt(20);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAttacking(int par1) {
/* 1488 */     if (this.worldObj != null && this.worldObj.isRemote)
/* 1489 */       return;  this.dataWatcher.updateObject(20, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */   
/*      */   public int getActivity() {
/* 1494 */     return this.dataWatcher.getWatchableObjectInt(21);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setActivity(int par1) {
/* 1499 */     if (this.worldObj != null && this.worldObj.isRemote)
/* 1500 */       return;  this.dataWatcher.updateObject(21, Integer.valueOf(par1));
/*      */   }
/*      */   
/*      */   public int getBeingRidden() {
/* 1504 */     return this.dataWatcher.getWatchableObjectInt(22);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setBeingRidden(int par1) {
/* 1509 */     if (this.worldObj != null && this.worldObj.isRemote)
/* 1510 */       return;  this.dataWatcher.updateObject(22, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 1519 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canDespawn() {
/* 1527 */     if (isNoDespawnRequired()) return false; 
/* 1528 */     if (this.riddenByEntity != null) {
/* 1529 */       return false;
/*      */     }
/* 1531 */     if (isTamed()) {
/* 1532 */       return false;
/*      */     }
/* 1534 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 1545 */     super.writeEntityToNBT(par1NBTTagCompound);
/*      */     
/* 1547 */     par1NBTTagCompound.setInteger("LeonAttacking", getAttacking());
/* 1548 */     par1NBTTagCompound.setInteger("LeonActivity", getActivity());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 1558 */     super.readEntityFromNBT(par1NBTTagCompound);
/*      */     
/* 1560 */     setAttacking(par1NBTTagCompound.getInteger("LeonAttacking"));
/* 1561 */     setActivity(par1NBTTagCompound.getInteger("LeonActivity"));
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Leon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */