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
/*      */ import net.minecraft.entity.EntityList;
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
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.monster.IMob;
/*      */ import net.minecraft.entity.passive.EntityTameable;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemFood;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.util.ChatComponentText;
/*      */ import net.minecraft.util.ChunkCoordinates;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.IChatComponent;
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
/*      */ public class ThePrinceAdult
/*      */   extends EntityTameable
/*      */ {
/*      */   private int boatPosRotationIncrements;
/*      */   private double boatX;
/*      */   private double boatY;
/*      */   private double boatZ;
/*      */   private double boatYaw;
/*      */   private double boatPitch;
/*      */   private double boatYawHead;
/*   80 */   private int updateit = 1;
/*   81 */   private int playing = 0;
/*   82 */   private GenericTargetSorter TargetSorter = null;
/*   83 */   private RenderInfo renderdata = new RenderInfo();
/*   84 */   private int hurt_timer = 0;
/*   85 */   private int wing_sound = 0;
/*   86 */   private ChunkCoordinates currentFlightTarget = null;
/*      */   private boolean target_in_sight = false;
/*   88 */   private int owner_flying = 0;
/*   89 */   private int flyaway = 0;
/*   90 */   private float moveSpeed = 0.36F;
/*   91 */   private float deltasmooth = 0.0F;
/*   92 */   private int which_attack = 0;
/*   93 */   private int fireballticker = 0;
/*      */   
/*   95 */   private int head1ext = 0;
/*   96 */   private int head2ext = 0;
/*   97 */   private int head3ext = 0;
/*   98 */   private int head1dir = 1;
/*   99 */   private int head2dir = 1;
/*  100 */   private int head3dir = 1;
/*      */   
/*  102 */   private int growcounter = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ThePrinceAdult(World par1World) {
/*  110 */     super(par1World);
/*      */     
/*  112 */     setSize(6.25F, 10.25F);
/*  113 */     getNavigator().setAvoidsWater(true);
/*  114 */     this.experienceValue = 3000;
/*  115 */     this.fireResistance = 1000;
/*  116 */     this.isImmuneToFire = true;
/*  117 */     setSitting(false);
/*  118 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  119 */     this.tasks.addTask(1, new MyEntityAIFollowOwner(this, 1.1F, 12.0F, 2.0F));
/*  120 */     this.tasks.addTask(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.beef, false));
/*  121 */     this.tasks.addTask(3, new MyEntityAIWander((EntityCreature)this, 0.75F));
/*  122 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 20.0F));
/*  123 */     this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  124 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityLiving.class, 0, true, false, IMob.mobSelector)); 
/*  125 */     this.targetTasks.addTask(2, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*  126 */     this.riddenByEntity = null;
/*  127 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  128 */     this.renderdata = new RenderInfo();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ThePrinceAdult(World par1World, double par2, double par4, double par6) {
/*  134 */     this(par1World);
/*  135 */     setPosition(par2, par4 + this.yOffset, par6);
/*  136 */     this.motionX = 0.0D;
/*  137 */     this.motionY = 0.0D;
/*  138 */     this.motionZ = 0.0D;
/*  139 */     this.prevPosX = par2;
/*  140 */     this.prevPosY = par4;
/*  141 */     this.prevPosZ = par6;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void applyEntityAttributes() {
/*  146 */     super.applyEntityAttributes();
/*  147 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  148 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  149 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  150 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(100.0D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean shouldRiderSit() {
/*  159 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTrackingRange() {
/*  164 */     return 64;
/*      */   }
/*      */   
/*      */   public int getUpdateFrequency() {
/*  168 */     return 10;
/*      */   }
/*      */   
/*      */   public boolean sendsVelocityUpdates() {
/*  172 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getHead1Ext() {
/*  177 */     return this.dataWatcher.getWatchableObjectInt(22);
/*      */   }
/*      */   
/*      */   public int getHead2Ext() {
/*  181 */     return this.dataWatcher.getWatchableObjectInt(23);
/*      */   }
/*      */   
/*      */   public int getHead3Ext() {
/*  185 */     return this.dataWatcher.getWatchableObjectInt(25);
/*      */   }
/*      */   
/*      */   public void setHead1Ext(int par1) {
/*  189 */     if (this.worldObj != null && this.worldObj.isRemote)
/*  190 */       return;  this.dataWatcher.updateObject(22, Integer.valueOf(par1));
/*      */   }
/*      */   
/*      */   public void setHead2Ext(int par1) {
/*  194 */     if (this.worldObj != null && this.worldObj.isRemote)
/*  195 */       return;  this.dataWatcher.updateObject(23, Integer.valueOf(par1));
/*      */   }
/*      */   
/*      */   public void setHead3Ext(int par1) {
/*  199 */     if (this.worldObj != null && this.worldObj.isRemote)
/*  200 */       return;  this.dataWatcher.updateObject(25, Integer.valueOf(par1));
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
/*      */   protected boolean canTriggerWalking() {
/*  213 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void entityInit() {
/*  218 */     super.entityInit();
/*  219 */     this.dataWatcher.addObject(20, Integer.valueOf(0));
/*  220 */     this.dataWatcher.addObject(21, Integer.valueOf(0));
/*  221 */     this.dataWatcher.addObject(24, Integer.valueOf(1));
/*  222 */     this.dataWatcher.addObject(22, Integer.valueOf(0));
/*  223 */     this.dataWatcher.addObject(23, Integer.valueOf(0));
/*  224 */     this.dataWatcher.addObject(25, Integer.valueOf(0));
/*  225 */     setActivity(0);
/*  226 */     setAttacking(0);
/*  227 */     setTamed(false);
/*  228 */     setThePrinceAdultFire(1);
/*  229 */     this.noClip = false;
/*      */     
/*  231 */     if (this.renderdata == null) {
/*  232 */       this.renderdata = new RenderInfo();
/*      */     }
/*  234 */     this.renderdata.rf1 = 0.0F;
/*  235 */     this.renderdata.rf2 = 0.0F;
/*  236 */     this.renderdata.rf3 = 0.0F;
/*  237 */     this.renderdata.rf4 = 0.0F;
/*  238 */     this.renderdata.ri1 = 0;
/*  239 */     this.renderdata.ri2 = 0;
/*  240 */     this.renderdata.ri3 = 0;
/*  241 */     this.renderdata.ri4 = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int mygetMaxHealth() {
/*  248 */     return 3000;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getThePrinceAdultHealth() {
/*  255 */     return (int)getHealth();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RenderInfo getRenderInfo() {
/*  262 */     return this.renderdata;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRenderInfo(RenderInfo r) {
/*  267 */     this.renderdata.rf1 = r.rf1;
/*  268 */     this.renderdata.rf2 = r.rf2;
/*  269 */     this.renderdata.rf3 = r.rf3;
/*  270 */     this.renderdata.rf4 = r.rf4;
/*  271 */     this.renderdata.ri1 = r.ri1;
/*  272 */     this.renderdata.ri2 = r.ri2;
/*  273 */     this.renderdata.ri3 = r.ri3;
/*  274 */     this.renderdata.ri4 = r.ri4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  282 */     return 20;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void jump() {
/*  288 */     super.jump();
/*  289 */     this.motionY += 0.35D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAIEnabled() {
/*  297 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBreatheUnderwater() {
/*  306 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLivingSound() {
/*  314 */     if (isSitting())
/*      */     {
/*  316 */       return null;
/*      */     }
/*  318 */     if (getActivity() == 1 && this.riddenByEntity == null) {
/*  319 */       return "orespawn:king_living";
/*      */     }
/*      */     
/*  322 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getHurtSound() {
/*  330 */     return "orespawn:king_hit";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDeathSound() {
/*  338 */     return "orespawn:trex_death";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundVolume() {
/*  345 */     return 0.85F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getSoundPitch() {
/*  352 */     return 1.1F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBePushed() {
/*  361 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getMountedYOffset() {
/*  369 */     return 9.25D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/*  378 */     return OreSpawnMain.ThePrinceEgg;
/*      */   }
/*      */ 
/*      */   
/*      */   private ItemStack dropItemRand(Item index, int par1) {
/*  383 */     EntityItem var3 = null;
/*  384 */     ItemStack is = new ItemStack(index, par1, 0);
/*      */     
/*  386 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
/*      */     
/*  388 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/*  389 */     return is;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/*  394 */     dropItemRand(OreSpawnMain.ThePrinceEgg, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  403 */     double ks = 2.0D;
/*  404 */     double inair = 0.2D;
/*  405 */     float iskraken = 1.0F;
/*  406 */     if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*      */       
/*  408 */       if (par1Entity instanceof Kraken) iskraken = 2.0F; 
/*  409 */       par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), iskraken * 100.0F);
/*      */       
/*  411 */       float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/*  412 */       if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/*  413 */       par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*      */     } 
/*  415 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  423 */     boolean ret = false;
/*  424 */     Entity e = null;
/*      */     
/*  426 */     if (this.hurt_timer > 0) return false;
/*      */     
/*  428 */     if (par1DamageSource.getDamageType().equals("cactus")) {
/*  429 */       return ret;
/*      */     }
/*  431 */     if (par1DamageSource.getDamageType().equals("inFire")) {
/*  432 */       return ret;
/*      */     }
/*  434 */     if (par1DamageSource.getDamageType().equals("onFire")) {
/*  435 */       return ret;
/*      */     }
/*  437 */     if (par1DamageSource.getDamageType().equals("lava")) {
/*  438 */       return ret;
/*      */     }
/*  440 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/*  441 */       setSitting(false);
/*  442 */       setActivity(1);
/*  443 */       return ret;
/*      */     } 
/*      */     
/*  446 */     setSitting(false);
/*  447 */     setActivity(1);
/*      */     
/*  449 */     e = par1DamageSource.getEntity();
/*      */ 
/*      */     
/*  452 */     if (e != null && e instanceof BetterFireball) {
/*      */       
/*  454 */       e.setDead();
/*  455 */       return ret;
/*      */     } 
/*      */     
/*  458 */     if (e != null && e instanceof net.minecraft.entity.projectile.EntitySmallFireball) {
/*      */       
/*  460 */       e.setDead();
/*  461 */       return ret;
/*      */     } 
/*  463 */     if (e != null && e instanceof ThePrinceAdult) {
/*  464 */       return false;
/*      */     }
/*  466 */     if (e != null && e instanceof Spyro) {
/*  467 */       return false;
/*      */     }
/*      */     
/*  470 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*  471 */     this.hurt_timer = 20;
/*      */     
/*  473 */     if (e != null && e instanceof EntityLivingBase) {
/*      */       
/*  475 */       if (isTamed() && 
/*  476 */         e instanceof EntityPlayer) {
/*  477 */         return false;
/*      */       }
/*      */ 
/*      */       
/*  481 */       setAttackTarget((EntityLivingBase)e);
/*  482 */       setTarget(e);
/*  483 */       getNavigator().tryMoveToEntityLiving(e, 1.2D);
/*  484 */       ret = true;
/*      */     } 
/*      */     
/*  487 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateAITasks() {
/*  493 */     EntityLivingBase e = null;
/*  494 */     super.updateAITasks();
/*      */ 
/*      */     
/*  497 */     if (!isSitting() && getActivity() == 0 && this.riddenByEntity == null && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(10) == 1) {
/*      */       
/*  499 */       e = findSomethingToAttack();
/*  500 */       if (e != null) {
/*      */ 
/*      */         
/*  503 */         setActivity(1);
/*      */       } else {
/*  505 */         setAttacking(0);
/*      */       } 
/*      */     } 
/*  508 */     if (getActivity() == 0 && this.riddenByEntity == null && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && isTamed() && OreSpawnMain.FullPowerKingEnable != 0) {
/*      */ 
/*      */       
/*  511 */       this.growcounter++;
/*  512 */       if (this.growcounter > 288000) {
/*  513 */         Entity ent = null;
/*  514 */         TheKing d = null;
/*  515 */         ent = spawnCreature(this.worldObj, "The King", this.posX, this.posY, this.posZ);
/*  516 */         if (ent != null) {
/*  517 */           d = (TheKing)ent;
/*  518 */           d.setFree();
/*  519 */           setDead();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void always_do() {
/*  527 */     EntityPlayer p = null;
/*      */ 
/*      */     
/*  530 */     if (this.worldObj.rand.nextInt(250) == 1 && 
/*  531 */       getHealth() < mygetMaxHealth())
/*      */     {
/*  533 */       heal(5.0F);
/*      */     }
/*      */ 
/*      */     
/*  537 */     if (this.worldObj.rand.nextInt(250) == 0) {
/*  538 */       setAttackTarget(null);
/*      */     }
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
/*  554 */     if (isSitting())
/*      */       return; 
/*  556 */     this.owner_flying = 0;
/*  557 */     if (isTamed() && getOwner() != null && this.riddenByEntity == null && !isSitting()) {
/*  558 */       p = (EntityPlayer)getOwner();
/*      */       
/*  560 */       if (p.capabilities.isFlying) {
/*  561 */         this.owner_flying = 1;
/*      */         
/*  563 */         setActivity(1);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  569 */     if (this.worldObj.rand.nextInt(50) == 1 && !isSitting())
/*      */     {
/*  571 */       if (!this.target_in_sight && this.riddenByEntity == null)
/*      */       {
/*  573 */         if (this.worldObj.rand.nextInt(15) == 1) {
/*      */           
/*  575 */           setActivity(1);
/*      */         } else {
/*      */           
/*  578 */           setActivity(0);
/*      */         } 
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void fly_with_rider() {
/*  587 */     EntityLivingBase e = null;
/*      */ 
/*      */     
/*  590 */     if (this.isDead)
/*      */       return; 
/*  592 */     if (isSitting())
/*  593 */       return;  if (this.worldObj.isRemote)
/*      */       return; 
/*  595 */     if (this.worldObj.rand.nextInt(5) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
/*      */       
/*  597 */       e = findSomethingToAttack();
/*  598 */       if (e != null) {
/*      */         
/*  600 */         setAttacking(1);
/*  601 */         if (getDistanceSqToEntity((Entity)e) < ((10.0F + e.width / 2.0F) * (10.0F + e.width / 2.0F))) {
/*      */           
/*  603 */           attackEntityAsMob((Entity)e);
/*  604 */         } else if (getDistanceSqToEntity((Entity)e) < 625.0D && !isInWater() && 
/*  605 */           getThePrinceAdultFire() != 0) {
/*  606 */           shoot_something(e.posX, e.posY, e.posZ);
/*      */         } 
/*      */       } else {
/*      */         
/*  610 */         setAttacking(0);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateAITick() {
/*  621 */     if (this.riddenByEntity != null)
/*  622 */       return;  super.updateAITick();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/*  630 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*      */     
/*  632 */     if (par1EntityLiving == null)
/*      */     {
/*  634 */       return false;
/*      */     }
/*  636 */     if (par1EntityLiving == this)
/*      */     {
/*  638 */       return false;
/*      */     }
/*  640 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/*      */       
/*  643 */       return false;
/*      */     }
/*  645 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*      */       
/*  648 */       return false;
/*      */     }
/*  650 */     if (MyUtils.isRoyalty((Entity)par1EntityLiving))
/*      */     {
/*  652 */       return false;
/*      */     }
/*      */     
/*  655 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityMob)
/*      */     {
/*  657 */       return true;
/*      */     }
/*  659 */     if (par1EntityLiving instanceof Mothra)
/*      */     {
/*      */       
/*  662 */       return true;
/*      */     }
/*  664 */     if (par1EntityLiving instanceof Kraken)
/*      */     {
/*      */       
/*  667 */       return true;
/*      */     }
/*  669 */     if (par1EntityLiving instanceof Leon) {
/*      */       
/*  671 */       Leon l = (Leon)par1EntityLiving;
/*  672 */       if (l.isTamed()) return false;
/*      */       
/*  674 */       return true;
/*      */     } 
/*  676 */     if (par1EntityLiving instanceof WaterDragon) {
/*      */       
/*  678 */       WaterDragon l = (WaterDragon)par1EntityLiving;
/*  679 */       if (l.isTamed()) return false;
/*      */       
/*  681 */       return true;
/*      */     } 
/*  683 */     if (par1EntityLiving instanceof GammaMetroid) {
/*      */       
/*  685 */       GammaMetroid l = (GammaMetroid)par1EntityLiving;
/*  686 */       if (l.isTamed()) return false;
/*      */       
/*  688 */       return true;
/*      */     } 
/*      */ 
/*      */     
/*  692 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private EntityLivingBase findSomethingToAttack() {
/*  697 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/*  698 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(32.0D, 20.0D, 32.0D));
/*  699 */     Collections.sort(var5, this.TargetSorter);
/*  700 */     Iterator<?> var2 = var5.iterator();
/*  701 */     Entity var3 = null;
/*  702 */     EntityLivingBase var4 = null;
/*      */     
/*  704 */     while (var2.hasNext()) {
/*      */       
/*  706 */       var3 = (Entity)var2.next();
/*  707 */       var4 = (EntityLivingBase)var3;
/*      */       
/*  709 */       if (isSuitableTarget(var4, false))
/*      */       {
/*  711 */         return var4;
/*      */       }
/*      */     } 
/*  714 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean doesEntityNotTriggerPressurePlate() {
/*  721 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanSpawnHere() {
/*  729 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/*  737 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
/*  749 */     super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
/*  750 */     this.boatPosRotationIncrements = par9;
/*      */ 
/*      */     
/*  753 */     this.boatX = par1;
/*  754 */     this.boatY = par3;
/*  755 */     this.boatZ = par5;
/*  756 */     this.boatYaw = par7;
/*  757 */     this.boatPitch = par8;
/*  758 */     this.boatYawHead = par7;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void setVelocity(double par1, double par3, double par5) {
/*  768 */     super.setVelocity(par1, par3, par5);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate() {
/*  774 */     EntityLivingBase e = null;
/*      */     
/*  776 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  777 */     super.onUpdate();
/*      */     
/*  779 */     if (getActivity() != 0) {
/*  780 */       this.noClip = true;
/*      */     } else {
/*  782 */       this.noClip = false;
/*      */     } 
/*      */     
/*  785 */     if (!this.worldObj.isRemote) {
/*  786 */       if (this.worldObj.rand.nextInt(10) == 1) {
/*  787 */         int i = this.worldObj.rand.nextInt(3);
/*  788 */         if (i == 0) this.head1dir = 2; 
/*  789 */         if (i == 1) this.head1dir = -2; 
/*  790 */         if (i == 2) this.head1dir = 0; 
/*      */       } 
/*  792 */       if (this.worldObj.rand.nextInt(10) == 1) {
/*  793 */         int i = this.worldObj.rand.nextInt(3);
/*  794 */         if (i == 0) this.head2dir = 2; 
/*  795 */         if (i == 1) this.head2dir = -2; 
/*  796 */         if (i == 2) this.head2dir = 0; 
/*      */       } 
/*  798 */       if (this.worldObj.rand.nextInt(10) == 1) {
/*  799 */         int i = this.worldObj.rand.nextInt(3);
/*  800 */         if (i == 0) this.head3dir = 2; 
/*  801 */         if (i == 1) this.head3dir = -2; 
/*  802 */         if (i == 2) this.head3dir = 0; 
/*      */       } 
/*  804 */       this.head1ext += this.head1dir;
/*  805 */       if (this.head1ext < 0) this.head1ext = 0; 
/*  806 */       if (this.head1ext > 60) this.head1ext = 60; 
/*  807 */       this.head2ext += this.head2dir;
/*  808 */       if (this.head2ext < 0) this.head2ext = 0; 
/*  809 */       if (this.head2ext > 60) this.head2ext = 60; 
/*  810 */       this.head3ext += this.head3dir;
/*  811 */       if (this.head3ext < 0) this.head3ext = 0; 
/*  812 */       if (this.head3ext > 60) this.head3ext = 60;
/*      */       
/*  814 */       setHead1Ext(this.head1ext);
/*  815 */       setHead2Ext(this.head2ext);
/*  816 */       setHead3Ext(this.head3ext);
/*      */     } 
/*      */     
/*  819 */     if (this.hurt_timer > 0) this.hurt_timer--;
/*      */     
/*  821 */     if (getActivity() == 1) {
/*  822 */       this.wing_sound++;
/*  823 */       if (this.wing_sound > 30) {
/*      */         
/*  825 */         if (!this.worldObj.isRemote) this.worldObj.playSoundAtEntity((Entity)this, "orespawn:MothraWings", 0.5F, 1.0F); 
/*  826 */         this.wing_sound = 0;
/*      */       } 
/*      */     } 
/*      */     
/*  830 */     if (isInWater()) {
/*  831 */       this.motionY += 0.07D;
/*      */     }
/*      */     
/*  834 */     if (this.worldObj.isRemote)
/*      */       return; 
/*  836 */     if (getActivity() == 0 && isTamed() && getOwner() != null && !isSitting()) {
/*  837 */       e = getOwner();
/*      */       
/*  839 */       if (getDistanceSqToEntity((Entity)e) > 900.0D)
/*      */       {
/*  841 */         setActivity(1);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void fly_without_rider() {
/*  849 */     int xdir = 1;
/*  850 */     int zdir = 1;
/*      */     
/*  852 */     int keep_trying = 10;
/*      */ 
/*      */     
/*  855 */     int do_new = 0;
/*  856 */     double ox = 0.0D, oy = 0.0D, oz = 0.0D;
/*      */     
/*  858 */     int has_owner = 0;
/*  859 */     EntityLivingBase e = null;
/*  860 */     double speed_factor = 0.5D;
/*  861 */     double var1 = 0.0D;
/*  862 */     double var3 = 0.0D;
/*  863 */     double var5 = 0.0D;
/*      */ 
/*      */ 
/*      */     
/*  867 */     double gh = 1.25D;
/*  868 */     double obstruction_factor = 0.0D;
/*  869 */     double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */     
/*  871 */     int toofar = 0;
/*      */ 
/*      */     
/*  874 */     if (this.currentFlightTarget == null) {
/*  875 */       do_new = 1;
/*  876 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*      */     } 
/*  878 */     if (this.riddenByEntity != null) {
/*      */       return;
/*      */     }
/*  881 */     if (isTamed() && getOwner() != null) {
/*  882 */       e = getOwner();
/*  883 */       has_owner = 1;
/*  884 */       ox = e.posX;
/*  885 */       oy = e.posY;
/*  886 */       oz = e.posZ;
/*  887 */       if (getDistanceSqToEntity((Entity)e) > 400.0D) {
/*  888 */         toofar = 1;
/*  889 */         this.target_in_sight = false;
/*  890 */         setAttacking(0);
/*  891 */         setSitting(false);
/*  892 */         this.flyaway = 0;
/*  893 */         do_new = 1;
/*      */       } 
/*      */     } 
/*      */     
/*  897 */     if (isSitting())
/*      */       return; 
/*  899 */     if (this.posY < this.currentFlightTarget.posY + 2.0D) {
/*  900 */       this.motionY *= 0.7D;
/*  901 */     } else if (this.posY > this.currentFlightTarget.posY - 2.0D) {
/*  902 */       this.motionY *= 0.5D;
/*      */     } else {
/*  904 */       this.motionY *= 0.61D;
/*      */     } 
/*      */ 
/*      */     
/*  908 */     if (this.worldObj.rand.nextInt(300) == 1) do_new = 1; 
/*  909 */     if (this.flyaway > 0) this.flyaway--;
/*      */ 
/*      */     
/*  912 */     if (toofar == 0 && this.flyaway == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(6) == 1) {
/*      */ 
/*      */       
/*  915 */       e = getAttackTarget();
/*  916 */       if (e != null && !e.isEntityAlive()) {
/*  917 */         setAttackTarget(null);
/*  918 */         e = null;
/*      */       } 
/*      */       
/*  921 */       if (e == null) {
/*  922 */         e = findSomethingToAttack();
/*      */       }
/*  924 */       if (e != null) {
/*      */         
/*  926 */         if (isTamed() && getHealth() / mygetMaxHealth() < 0.25F) {
/*  927 */           setActivity(1);
/*  928 */           setAttacking(0);
/*  929 */           this.target_in_sight = false;
/*  930 */           do_new = 0;
/*  931 */           this.currentFlightTarget.set((int)(this.posX + this.posX - e.posX), (int)(this.posY + 1.0D), (int)(this.posZ + this.posZ - e.posZ));
/*      */         } else {
/*      */           
/*  934 */           setActivity(1);
/*  935 */           setAttacking(1);
/*  936 */           this.target_in_sight = true;
/*  937 */           this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0D), (int)e.posZ);
/*      */           
/*  939 */           do_new = 0;
/*  940 */           if (getDistanceSqToEntity((Entity)e) < ((10.0F + e.width / 2.0F) * (10.0F + e.width / 2.0F))) {
/*  941 */             attackEntityAsMob((Entity)e);
/*  942 */             this.flyaway = 5 + this.worldObj.rand.nextInt(15);
/*  943 */             do_new = 1;
/*  944 */           } else if (getDistanceSqToEntity((Entity)e) < 600.0D && !isInWater()) {
/*      */             
/*  946 */             if (getThePrinceAdultFire() != 0 && this.worldObj.rand.nextInt(2) == 1) {
/*  947 */               shoot_something(e.posX, e.posY, e.posZ);
/*      */             }
/*      */           }
/*      */         
/*      */         } 
/*      */       } else {
/*      */         
/*  954 */         this.target_in_sight = false;
/*  955 */         this.flyaway = 0;
/*  956 */         setAttacking(0);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  961 */     if (this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*  962 */       do_new = 1;
/*      */     }
/*      */ 
/*      */     
/*  966 */     if ((do_new != 0 && !this.target_in_sight) || (do_new != 0 && this.flyaway != 0)) {
/*      */       
/*  968 */       Block bid = Blocks.stone;
/*  969 */       while (bid != Blocks.air && keep_trying != 0) {
/*  970 */         int gox = (int)this.posX;
/*  971 */         int goy = (int)this.posY;
/*  972 */         int goz = (int)this.posZ;
/*  973 */         if (has_owner == 1) {
/*  974 */           gox = (int)ox;
/*  975 */           goy = (int)oy;
/*  976 */           goz = (int)oz;
/*  977 */           if (this.owner_flying == 0) {
/*  978 */             zdir = this.worldObj.rand.nextInt(16) + 8;
/*  979 */             xdir = this.worldObj.rand.nextInt(16) + 8;
/*      */           } else {
/*  981 */             zdir = this.worldObj.rand.nextInt(12);
/*  982 */             xdir = this.worldObj.rand.nextInt(12);
/*      */           } 
/*      */         } else {
/*  985 */           zdir = this.worldObj.rand.nextInt(15) + 20;
/*  986 */           xdir = this.worldObj.rand.nextInt(15) + 20;
/*      */         } 
/*  988 */         if (this.worldObj.rand.nextInt(2) == 1) zdir = -zdir; 
/*  989 */         if (this.worldObj.rand.nextInt(2) == 1) xdir = -xdir; 
/*  990 */         this.currentFlightTarget.set(gox + xdir, goy + this.worldObj.rand.nextInt(9 + this.owner_flying * 2) - 4, goz + zdir);
/*  991 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/*  992 */         if (bid == Blocks.air && 
/*  993 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/*  994 */           bid = Blocks.stone;
/*      */         }
/*      */         
/*  997 */         keep_trying--;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1005 */     obstruction_factor = 0.0D;
/* 1006 */     int dist = 2;
/* 1007 */     dist += (int)(velocity * 4.0D);
/*      */     
/* 1009 */     for (int k = 1; k < dist; k++) {
/* 1010 */       for (int i = 1; i < dist * 2; i++) {
/* 1011 */         double dx = i * Math.cos(Math.toRadians((this.rotationYaw + 90.0F)));
/* 1012 */         double dz = i * Math.sin(Math.toRadians((this.rotationYaw + 90.0F)));
/* 1013 */         Block bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - k, (int)(this.posZ + dz));
/* 1014 */         if (bid != Blocks.air) {
/* 1015 */           obstruction_factor += 0.05D;
/*      */         }
/*      */       } 
/*      */     } 
/* 1019 */     this.motionY += obstruction_factor * 0.05D;
/* 1020 */     this.posY += obstruction_factor * 0.05D;
/*      */ 
/*      */     
/* 1023 */     speed_factor = 0.5D;
/* 1024 */     var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 1025 */     var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 1026 */     var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 1027 */     if (this.owner_flying != 0) {
/* 1028 */       speed_factor = 1.75D;
/* 1029 */       if (isTamed() && getOwner() != null) {
/* 1030 */         e = getOwner();
/* 1031 */         if (getDistanceSqToEntity((Entity)e) > 64.0D) {
/* 1032 */           speed_factor = 3.5D;
/*      */         }
/*      */       } 
/*      */     } 
/* 1036 */     this.motionX += (Math.signum(var1) - this.motionX) * 0.15D * speed_factor;
/* 1037 */     this.motionY += (Math.signum(var3) - this.motionY) * 0.21D * speed_factor;
/* 1038 */     this.motionZ += (Math.signum(var5) - this.motionZ) * 0.15D * speed_factor;
/* 1039 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 1040 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 1041 */     this.moveForward = (float)(0.75D * speed_factor);
/*      */     
/* 1043 */     this.rotationYaw += var8 / 4.0F;
/* 1044 */     moveEntity(this.motionX, this.motionY, this.motionZ);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onLivingUpdate() {
/* 1054 */     List<Entity> list = null;
/* 1055 */     Entity listEntity = null;
/*      */ 
/*      */ 
/*      */     
/* 1059 */     double d6 = (this.rand.nextFloat() * 2.0F - 1.0F);
/* 1060 */     double d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1066 */     double obstruction_factor = 0.0D;
/*      */     
/* 1068 */     double relative_g = 0.0D;
/*      */     
/* 1070 */     double max_speed = 1.05D;
/* 1071 */     double gh = 1.25D;
/*      */ 
/*      */ 
/*      */     
/* 1075 */     double rt = 0.0D;
/*      */     
/* 1077 */     double pi = 3.1415926545D;
/* 1078 */     double deltav = 0.0D;
/*      */ 
/*      */ 
/*      */     
/* 1082 */     int dist = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1087 */     if (getActivity() == 0) {
/*      */       
/* 1089 */       super.onLivingUpdate();
/*      */     
/*      */     }
/* 1092 */     else if (this.isDead) {
/* 1093 */       super.onLivingUpdate();
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1098 */     if (this.isDead) {
/*      */       return;
/*      */     }
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
/* 1111 */     if (this.worldObj.isRemote) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1116 */       if (this.boatPosRotationIncrements > 0 && getActivity() != 0) {
/*      */         
/* 1118 */         double d4 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
/* 1119 */         double d5 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
/* 1120 */         double d11 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
/* 1121 */         setPosition(d4, d5, d11);
/*      */         
/* 1123 */         this.rotationPitch = (float)(this.rotationPitch + (this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
/* 1124 */         double d10 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
/* 1125 */         if (this.riddenByEntity != null) d10 = MathHelper.wrapAngleTo180_double(this.riddenByEntity.rotationYaw - this.rotationYaw); 
/* 1126 */         this.rotationYaw = (float)(this.rotationYaw + d10 / this.boatPosRotationIncrements);
/* 1127 */         setRotation(this.rotationYaw, this.rotationPitch);
/* 1128 */         this.rotationYawHead = this.rotationYaw;
/*      */         
/* 1130 */         this.boatPosRotationIncrements--;
/*      */       } 
/*      */     } else {
/*      */       
/* 1134 */       if (getActivity() != 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1140 */         if (this.fireballticker > 0) this.fireballticker--;
/*      */         
/* 1142 */         if (this.riddenByEntity != null) {
/* 1143 */           EntityPlayer pp = (EntityPlayer)this.riddenByEntity;
/*      */ 
/*      */ 
/*      */           
/* 1147 */           if (this.motionX < -2.0D) this.motionX = -2.0D; 
/* 1148 */           if (this.motionX > 2.0D) this.motionX = 2.0D; 
/* 1149 */           if (this.motionZ < -2.0D) this.motionZ = -2.0D; 
/* 1150 */           if (this.motionZ > 2.0D) this.motionZ = 2.0D; 
/* 1151 */           double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */ 
/*      */           
/* 1154 */           gh = 1.25D;
/* 1155 */           Block bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh), (int)this.posZ);
/* 1156 */           if (bid != Blocks.air) {
/* 1157 */             this.motionY += 0.03D;
/* 1158 */             this.posY += 0.1D;
/*      */           } else {
/*      */             
/* 1161 */             this.motionY -= 0.018D;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1168 */           obstruction_factor = 0.0D;
/* 1169 */           dist = 3;
/* 1170 */           dist += (int)(velocity * 7.0D);
/*      */           
/* 1172 */           for (int k = 1; k < dist; k++) {
/* 1173 */             for (int i = 1; i < dist * 2; i++) {
/* 1174 */               double dx = i * Math.cos(Math.toRadians((this.rotationYaw + 90.0F)));
/* 1175 */               double dz = i * Math.sin(Math.toRadians((this.rotationYaw + 90.0F)));
/* 1176 */               bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - k, (int)(this.posZ + dz));
/* 1177 */               if (bid != Blocks.air) {
/* 1178 */                 obstruction_factor += 0.05D;
/*      */               }
/*      */             } 
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 1185 */           this.motionY += obstruction_factor * 0.07D;
/* 1186 */           this.posY += obstruction_factor * 0.07D;
/* 1187 */           if (this.motionY > 2.0D) this.motionY = 2.0D;
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
/* 1198 */           double d4 = this.riddenByEntity.rotationYaw;
/* 1199 */           d4 %= 360.0D;
/* 1200 */           for (; d4 < 0.0D; d4 += 360.0D);
/* 1201 */           double d5 = this.rotationYaw;
/* 1202 */           d5 %= 360.0D;
/* 1203 */           for (; d5 < 0.0D; d5 += 360.0D);
/* 1204 */           relative_g = (d4 - d5) % 180.0D;
/* 1205 */           for (; relative_g < 0.0D; relative_g += 180.0D);
/* 1206 */           if (relative_g > 90.0D) relative_g -= 180.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1213 */           if (velocity > 0.01D) {
/*      */             
/* 1215 */             d4 = 1.85D - velocity;
/* 1216 */             d4 = Math.abs(d4);
/* 1217 */             if (d4 < 0.01D) d4 = 0.01D; 
/* 1218 */             if (d4 > 0.9D) d4 = 0.9D; 
/* 1219 */             this.rotationYaw = this.riddenByEntity.rotationYaw + (float)(relative_g * d4);
/*      */           } else {
/*      */             
/* 1222 */             this.rotationYaw = this.riddenByEntity.rotationYaw;
/*      */           } 
/* 1224 */           relative_g = Math.abs(relative_g) * velocity;
/* 1225 */           if (relative_g > 50.0D) relative_g = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1230 */           this.rotationPitch = 2.0F * (float)velocity;
/* 1231 */           setRotation(this.rotationYaw, this.rotationPitch);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1237 */           double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1245 */           double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
/* 1246 */           double rhm = Math.atan2(this.motionZ, this.motionX);
/* 1247 */           double rhdir = Math.toRadians(((this.riddenByEntity.rotationYaw + 90.0F) % 360.0F));
/* 1248 */           rt = 0.0D;
/* 1249 */           pi = 3.1415926545D;
/* 1250 */           deltav = 0.0D;
/* 1251 */           float im = pp.moveForward;
/*      */ 
/*      */           
/* 1254 */           if (OreSpawnMain.flyup_keystate != 0) {
/* 1255 */             this.motionY += 0.045D;
/* 1256 */             this.motionY += velocity * 0.066D;
/*      */           } 
/*      */ 
/*      */           
/* 1260 */           double rdv = Math.abs(rhm - rhdir) % pi * 2.0D;
/* 1261 */           if (rdv > pi) rdv -= pi * 2.0D; 
/* 1262 */           rdv = Math.abs(rdv);
/* 1263 */           if (Math.abs(newvelocity) < 0.01D) rdv = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1271 */           if (rdv > 1.5D) newvelocity = -newvelocity;
/*      */           
/* 1273 */           if (Math.abs(im) > 0.001F) {
/* 1274 */             if (im > 0.0F) {
/* 1275 */               deltav = 0.035D;
/* 1276 */               if (max_speed > 1.0D) deltav += 0.07D; 
/* 1277 */               if (this.deltasmooth < 0.0F) this.deltasmooth = 0.0F; 
/* 1278 */               this.deltasmooth = (float)(this.deltasmooth + deltav / 10.0D);
/* 1279 */               if (this.deltasmooth > deltav) this.deltasmooth = (float)deltav;
/*      */             
/*      */             } else {
/* 1282 */               max_speed = 0.35D;
/*      */               
/* 1284 */               deltav = -0.02D;
/* 1285 */               if (this.deltasmooth > 0.0F) this.deltasmooth = 0.0F; 
/* 1286 */               this.deltasmooth = (float)(this.deltasmooth + deltav / 10.0D);
/* 1287 */               if (this.deltasmooth < deltav) this.deltasmooth = (float)deltav;
/*      */             
/*      */             } 
/* 1290 */             newvelocity += this.deltasmooth;
/* 1291 */             if (newvelocity >= 0.0D) {
/* 1292 */               if (newvelocity > max_speed) newvelocity = max_speed; 
/* 1293 */               this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 1294 */               this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*      */             } else {
/* 1296 */               if (newvelocity < -max_speed) newvelocity = -max_speed; 
/* 1297 */               newvelocity = -newvelocity;
/* 1298 */               this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/* 1299 */               this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/*      */             }
/*      */           
/*      */           }
/* 1303 */           else if (newvelocity >= 0.0D) {
/* 1304 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 1305 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*      */           } else {
/* 1307 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/* 1308 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 1313 */           if (this.fireballticker == 0 && (pp.moveStrafing < -0.001F || pp.moveStrafing > 0.001F)) {
/*      */             
/* 1315 */             double yoff = 9.5D;
/* 1316 */             double xzoff = 14.5D;
/*      */             
/* 1318 */             this.which_attack++;
/* 1319 */             if (this.which_attack > 2) this.which_attack = 0;
/*      */ 
/*      */             
/* 1322 */             if (this.which_attack == 0) {
/* 1323 */               yoff -= (getHead1Ext() * 0.08F);
/* 1324 */               double cx = this.posX - xzoff * Math.sin(Math.toRadians((this.rotationYaw - 10.0F)));
/* 1325 */               double cz = this.posZ + xzoff * Math.cos(Math.toRadians((this.rotationYaw - 10.0F)));
/* 1326 */               BetterFireball bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, 0.0D, 0.0D, 0.0D);
/* 1327 */               bf.setBig();
/* 1328 */               bf.setNotMe();
/* 1329 */               bf.setPosition(cx, this.posY + yoff, cz);
/* 1330 */               cx = Math.cos(Math.toRadians((pp.rotationYawHead + 90.0F)));
/* 1331 */               cz = Math.sin(Math.toRadians((pp.rotationYawHead + 90.0F)));
/* 1332 */               double cy = -Math.sin(Math.toRadians(pp.rotationPitch));
/*      */               
/* 1334 */               double d3 = MathHelper.sqrt_double(cx * cx + cy * cy + cz * cz);
/* 1335 */               bf.accelerationX = cx / d3 * 0.1D;
/* 1336 */               bf.accelerationY = cy / d3 * 0.1D;
/* 1337 */               bf.accelerationZ = cz / d3 * 0.1D;
/* 1338 */               bf.motionX = this.motionX;
/* 1339 */               bf.motionY = this.motionY;
/* 1340 */               bf.motionZ = this.motionZ;
/* 1341 */               bf.posX -= this.motionX * 3.0D;
/* 1342 */               bf.posY -= this.motionY * 3.0D;
/* 1343 */               bf.posZ -= this.motionZ * 3.0D;
/* 1344 */               this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1345 */               this.worldObj.spawnEntityInWorld((Entity)bf);
/*      */             } 
/*      */             
/* 1348 */             if (this.which_attack == 1) {
/* 1349 */               yoff -= (getHead3Ext() * 0.08F);
/* 1350 */               double cx = this.posX - xzoff * Math.sin(Math.toRadians((this.rotationYaw + 10.0F)));
/* 1351 */               double cz = this.posZ + xzoff * Math.cos(Math.toRadians((this.rotationYaw + 10.0F)));
/* 1352 */               IceBall var2 = new IceBall(this.worldObj, cx, this.posY + yoff, cz);
/* 1353 */               var2.setLocationAndAngles(cx, this.posY + yoff, cz, pp.rotationYaw + 90.0F, pp.rotationPitch);
/* 1354 */               var2.setIceMaker(1);
/* 1355 */               double var3 = Math.cos(Math.toRadians((pp.rotationYaw + 90.0F)));
/* 1356 */               double var5 = -Math.sin(Math.toRadians(pp.rotationPitch));
/* 1357 */               double var77 = Math.sin(Math.toRadians((pp.rotationYaw + 90.0F)));
/* 1358 */               float var9 = MathHelper.sqrt_double(var3 * var3 + var77 * var77) * 0.2F;
/* 1359 */               var2.setThrowableHeading(var3, var5 + var9, var77, 1.4F, 5.0F);
/* 1360 */               var2.posX -= this.motionX * 3.0D;
/* 1361 */               var2.posY -= this.motionY * 3.0D;
/* 1362 */               var2.posZ -= this.motionZ * 3.0D;
/* 1363 */               var2.motionX *= 2.0D;
/* 1364 */               var2.motionY *= 2.0D;
/* 1365 */               var2.motionZ *= 2.0D;
/* 1366 */               this.worldObj.playSoundAtEntity((Entity)this, "fireworks.launch", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1367 */               this.worldObj.spawnEntityInWorld((Entity)var2);
/*      */             } 
/*      */             
/* 1370 */             if (this.which_attack == 2) {
/* 1371 */               yoff -= (getHead2Ext() * 0.08F);
/* 1372 */               double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1373 */               double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/* 1374 */               ThunderBolt lb = new ThunderBolt(this.worldObj, (EntityLivingBase)pp);
/* 1375 */               lb.setLocationAndAngles(cx, this.posY + yoff, cz, pp.rotationYaw + 90.0F, pp.rotationPitch);
/* 1376 */               lb.motionX *= 3.0D;
/* 1377 */               lb.motionY *= 3.0D;
/* 1378 */               lb.motionZ *= 3.0D;
/* 1379 */               this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1380 */               this.worldObj.spawnEntityInWorld((Entity)lb);
/*      */             } 
/* 1382 */             this.fireballticker = 8;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 1387 */           moveEntity(this.motionX, this.motionY, this.motionZ);
/*      */ 
/*      */           
/* 1390 */           this.motionX *= 0.985D;
/* 1391 */           this.motionY *= 0.94D;
/* 1392 */           this.motionZ *= 0.985D;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1397 */           if (!this.worldObj.isRemote) {
/*      */             
/* 1399 */             list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(6.25D, 10.0D, 6.25D));
/*      */             
/* 1401 */             if (list != null && !list.isEmpty())
/*      */             {
/* 1403 */               for (int l = 0; l < list.size(); l++) {
/*      */                 
/* 1405 */                 listEntity = list.get(l);
/*      */                 
/* 1407 */                 if (listEntity != this.riddenByEntity && !listEntity.isDead && listEntity.canBePushed())
/*      */                 {
/* 1409 */                   listEntity.applyEntityCollision((Entity)this);
/*      */                 }
/*      */               } 
/*      */             }
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 1417 */           fly_with_rider();
/*      */           
/* 1419 */           if (this.riddenByEntity != null && this.riddenByEntity.isDead)
/*      */           {
/* 1421 */             this.riddenByEntity = null;
/*      */           }
/*      */         } else {
/*      */           
/* 1425 */           fly_without_rider();
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1431 */       always_do();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateRiderPosition() {
/* 1438 */     if (this.riddenByEntity != null) {
/*      */ 
/*      */ 
/*      */       
/* 1442 */       float f = 4.65F;
/* 1443 */       this.riddenByEntity.setPosition(this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)));
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
/* 1455 */     String s = "heart";
/*      */     
/* 1457 */     if (!par1)
/*      */     {
/* 1459 */       s = "smoke";
/*      */     }
/*      */     
/* 1462 */     for (int i = 0; i < 20; i++) {
/*      */       
/* 1464 */       double d0 = this.rand.nextGaussian() * 0.08D;
/* 1465 */       double d1 = this.rand.nextGaussian() * 0.08D;
/* 1466 */       double d2 = this.rand.nextGaussian() * 0.08D;
/* 1467 */       this.worldObj.spawnParticle(s, this.posX + ((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5F), this.posY + 0.5D + this.rand.nextFloat() * 1.5D, this.posZ + ((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5F), d0, d1, d2);
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
/* 1478 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*      */     
/* 1480 */     if (var2 != null && 
/* 1481 */       var2.stackSize <= 0) {
/* 1482 */       par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 1483 */       var2 = null;
/*      */     } 
/*      */ 
/*      */     
/* 1487 */     if (var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.diamond_block) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 36.0D) {
/* 1488 */       if (!this.worldObj.isRemote) {
/* 1489 */         heal(mygetMaxHealth() - getHealth());
/*      */         
/* 1491 */         this.growcounter = 288000;
/*      */       } 
/* 1493 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 1494 */         var2.stackSize--;
/* 1495 */         if (var2.stackSize <= 0) {
/* 1496 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/* 1499 */       return true;
/*      */     } 
/*      */     
/* 1502 */     if (isTamed()) {
/*      */       
/* 1504 */       if (!isOwner((EntityLivingBase)par1EntityPlayer)) {
/* 1505 */         return false;
/*      */       }
/*      */       
/* 1508 */       if (var2 == null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 36.0D) {
/* 1509 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1511 */           par1EntityPlayer.mountEntity((Entity)this);
/*      */           
/* 1513 */           setActivity(1);
/* 1514 */           setSitting(false);
/*      */         } 
/* 1516 */         return true;
/*      */       } 
/*      */       
/* 1519 */       if (var2 != null && var2.getItem() == Items.beef && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 36.0D) {
/* 1520 */         if (this.worldObj.isRemote) {
/* 1521 */           playTameEffect(true);
/* 1522 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/* 1525 */         if (mygetMaxHealth() > getHealth()) {
/* 1526 */           heal(mygetMaxHealth() - getHealth());
/*      */         }
/* 1528 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 1529 */           var2.stackSize--;
/* 1530 */           if (var2.stackSize <= 0) {
/* 1531 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1534 */         return true;
/*      */       } 
/*      */       
/* 1537 */       if (var2 != null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 36.0D && var2.getItem() instanceof ItemFood) {
/*      */ 
/*      */         
/* 1540 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1542 */           ItemFood var3 = (ItemFood)var2.getItem();
/*      */           
/* 1544 */           if (mygetMaxHealth() > getHealth())
/*      */           {
/* 1546 */             heal((var3.getHealAmount(var2) * 10));
/*      */           }
/*      */           
/* 1549 */           playTameEffect(true);
/* 1550 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/* 1553 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1555 */           var2.stackSize--;
/* 1556 */           if (var2.stackSize <= 0)
/*      */           {
/* 1558 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1561 */         return true;
/*      */       } 
/*      */ 
/*      */       
/* 1565 */       if (var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.ice) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 36.0D) {
/*      */         
/* 1567 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1569 */           playTameEffect(true);
/* 1570 */           this.worldObj.setEntityState((Entity)this, (byte)6);
/* 1571 */           setThePrinceAdultFire(0);
/* 1572 */           String healthMessage = new String();
/* 1573 */           healthMessage = String.format("Fireballs extinguished.", new Object[0]);
/* 1574 */           par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText(healthMessage));
/*      */         } 
/* 1576 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1578 */           var2.stackSize--;
/* 1579 */           if (var2.stackSize <= 0)
/*      */           {
/* 1581 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1584 */         return true;
/*      */       } 
/*      */       
/* 1587 */       if (var2 != null && var2.getItem() == Items.flint_and_steel && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 36.0D) {
/*      */         
/* 1589 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1591 */           playTameEffect(true);
/* 1592 */           this.worldObj.setEntityState((Entity)this, (byte)6);
/* 1593 */           setThePrinceAdultFire(1);
/* 1594 */           String healthMessage = new String();
/* 1595 */           healthMessage = String.format("Fireballs lit!", new Object[0]);
/* 1596 */           par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText(healthMessage));
/*      */         } 
/* 1598 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1600 */           var2.stackSize--;
/* 1601 */           if (var2.stackSize <= 0)
/*      */           {
/* 1603 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1606 */         return true;
/*      */       } 
/*      */ 
/*      */       
/* 1610 */       if (var2 != null && var2.getItem() == Items.diamond && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 36.0D && !this.worldObj.isRemote) {
/*      */ 
/*      */ 
/*      */         
/* 1614 */         Entity ent = null;
/* 1615 */         ThePrinceTeen d = null;
/* 1616 */         ent = spawnCreature(this.worldObj, "The Young Prince", this.posX, this.posY, this.posZ);
/* 1617 */         if (ent != null) {
/* 1618 */           d = (ThePrinceTeen)ent;
/* 1619 */           if (isTamed()) {
/* 1620 */             d.setTamed(true);
/* 1621 */             d.func_152115_b(par1EntityPlayer.getUniqueID().toString());
/*      */           } 
/* 1623 */           setDead();
/*      */         } 
/* 1625 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1627 */           var2.stackSize--;
/* 1628 */           if (var2.stackSize <= 0)
/*      */           {
/* 1630 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1633 */         return true;
/*      */       } 
/*      */       
/* 1636 */       if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 36.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */         
/* 1638 */         setCustomNameTag(var2.getDisplayName());
/* 1639 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1641 */           var2.stackSize--;
/* 1642 */           if (var2.stackSize <= 0)
/*      */           {
/* 1644 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1647 */         return true;
/*      */       } 
/*      */       
/* 1650 */       if (var2 != null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 36.0D) {
/*      */         
/* 1652 */         if (!isSitting()) {
/* 1653 */           setSitting(true);
/* 1654 */           setActivity(0);
/*      */         } else {
/* 1656 */           setSitting(false);
/* 1657 */           setActivity(0);
/*      */         } 
/* 1659 */         return true;
/*      */       } 
/*      */     } 
/*      */     
/* 1663 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWheat(ItemStack par1ItemStack) {
/* 1671 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.beef);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAttacking() {
/* 1677 */     return this.dataWatcher.getWatchableObjectInt(20);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAttacking(int par1) {
/* 1682 */     if (this.worldObj != null && this.worldObj.isRemote)
/* 1683 */       return;  this.dataWatcher.updateObject(20, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */   
/*      */   public int getActivity() {
/* 1688 */     return this.dataWatcher.getWatchableObjectInt(21);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setActivity(int par1) {
/* 1693 */     if (this.worldObj != null && this.worldObj.isRemote)
/* 1694 */       return;  this.dataWatcher.updateObject(21, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getThePrinceAdultFire() {
/* 1700 */     return this.dataWatcher.getWatchableObjectInt(24);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setThePrinceAdultFire(int par1) {
/* 1706 */     if (this.worldObj.isRemote)
/* 1707 */       return;  this.dataWatcher.updateObject(24, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 1716 */     Entity var8 = null;
/*      */ 
/*      */     
/* 1719 */     var8 = EntityList.createEntityByName(par1, par0World);
/*      */     
/* 1721 */     if (var8 != null) {
/*      */ 
/*      */       
/* 1724 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*      */ 
/*      */       
/* 1727 */       par0World.spawnEntityInWorld(var8);
/*      */       
/* 1729 */       ((EntityLiving)var8).playLivingSound();
/*      */     } 
/*      */     
/* 1732 */     return var8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 1740 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canDespawn() {
/* 1748 */     if (isNoDespawnRequired()) return false; 
/* 1749 */     if (this.riddenByEntity != null) {
/* 1750 */       return false;
/*      */     }
/* 1752 */     if (isTamed()) {
/* 1753 */       return false;
/*      */     }
/* 1755 */     return true;
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
/* 1766 */     super.writeEntityToNBT(par1NBTTagCompound);
/*      */     
/* 1768 */     par1NBTTagCompound.setInteger("ThePrinceAdultAttacking", getAttacking());
/* 1769 */     par1NBTTagCompound.setInteger("ThePrinceAdultActivity", getActivity());
/* 1770 */     par1NBTTagCompound.setInteger("ThePrinceAdultFire", getThePrinceAdultFire());
/* 1771 */     par1NBTTagCompound.setInteger("ThePrinceAdultGrow", this.growcounter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 1781 */     super.readEntityFromNBT(par1NBTTagCompound);
/*      */     
/* 1783 */     setAttacking(par1NBTTagCompound.getInteger("ThePrinceAdultAttacking"));
/* 1784 */     setActivity(par1NBTTagCompound.getInteger("ThePrinceAdultActivity"));
/* 1785 */     setThePrinceAdultFire(par1NBTTagCompound.getInteger("ThePrinceAdultFire"));
/* 1786 */     this.growcounter = par1NBTTagCompound.getInteger("ThePrinceAdultGrow");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void shoot_something(double x, double y, double z) {
/* 1792 */     double rr = 0.0D;
/* 1793 */     double rhdir = 0.0D;
/* 1794 */     double rdd = 0.0D;
/* 1795 */     double pi = 3.1415926545D;
/*      */     
/* 1797 */     int which = this.worldObj.rand.nextInt(3);
/*      */ 
/*      */ 
/*      */     
/* 1801 */     if (which == 0) {
/*      */ 
/*      */       
/* 1804 */       rr = Math.atan2(z - this.posZ, x - this.posX);
/* 1805 */       rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */       
/* 1807 */       rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/* 1808 */       if (rdd > pi) rdd -= pi * 2.0D; 
/* 1809 */       rdd = Math.abs(rdd);
/*      */       
/* 1811 */       if (rdd < 0.5D) {
/* 1812 */         firecanon(x, y, z);
/*      */       }
/* 1814 */     } else if (which == 1) {
/*      */ 
/*      */ 
/*      */       
/* 1818 */       rr = Math.atan2(z - this.posZ, x - this.posX);
/* 1819 */       rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */       
/* 1821 */       rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/* 1822 */       if (rdd > pi) rdd -= pi * 2.0D; 
/* 1823 */       rdd = Math.abs(rdd);
/*      */       
/* 1825 */       if (rdd < 0.5D) {
/* 1826 */         firecanonl(x, y, z);
/*      */       
/*      */       }
/*      */     }
/*      */     else {
/*      */       
/* 1832 */       rr = Math.atan2(z - this.posZ, x - this.posX);
/* 1833 */       rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */       
/* 1835 */       rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/* 1836 */       if (rdd > pi) rdd -= pi * 2.0D; 
/* 1837 */       rdd = Math.abs(rdd);
/*      */       
/* 1839 */       if (rdd < 0.5D) {
/* 1840 */         firecanoni(x, y, z);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void firecanon(double x, double y, double z) {
/* 1848 */     double yoff = 3.5D;
/* 1849 */     double xzoff = 6.0D;
/*      */ 
/*      */     
/* 1852 */     BetterFireball bf = null;
/*      */     
/* 1854 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1855 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/* 1856 */     float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1857 */     float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1858 */     float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1859 */     bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, x - cx + r1, y + 0.25D - this.posY + yoff + r2, z - cz + r3);
/* 1860 */     bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 1861 */     bf.setPosition(cx, this.posY + yoff, cz);
/* 1862 */     bf.setBig();
/* 1863 */     this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1864 */     this.worldObj.spawnEntityInWorld((Entity)bf);
/*      */   }
/*      */ 
/*      */   
/*      */   private void firecanonl(double x, double y, double z) {
/* 1869 */     double yoff = 3.5D;
/* 1870 */     double xzoff = 6.0D;
/*      */ 
/*      */ 
/*      */     
/* 1874 */     double var3 = 0.0D;
/* 1875 */     double var5 = 0.0D;
/* 1876 */     double var7 = 0.0D;
/* 1877 */     float var9 = 0.0F;
/* 1878 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1879 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*      */     
/* 1881 */     this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*      */     
/* 1883 */     float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1884 */     float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1885 */     float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1886 */     ThunderBolt lb = new ThunderBolt(this.worldObj, cx, this.posY + yoff, cz);
/* 1887 */     lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0F, 0.0F);
/* 1888 */     var3 = x - lb.posX;
/* 1889 */     var5 = y + 0.25D - lb.posY;
/* 1890 */     var7 = z - lb.posZ;
/* 1891 */     var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 1892 */     lb.setThrowableHeading(var3, var5 + var9, var7, 1.4F, 4.0F);
/* 1893 */     lb.motionX *= 3.0D;
/* 1894 */     lb.motionY *= 3.0D;
/* 1895 */     lb.motionZ *= 3.0D;
/* 1896 */     this.worldObj.spawnEntityInWorld((Entity)lb);
/*      */   }
/*      */ 
/*      */   
/*      */   private void firecanoni(double x, double y, double z) {
/* 1901 */     double yoff = 3.5D;
/* 1902 */     double xzoff = 6.0D;
/*      */ 
/*      */ 
/*      */     
/* 1906 */     double var3 = 0.0D;
/* 1907 */     double var5 = 0.0D;
/* 1908 */     double var7 = 0.0D;
/* 1909 */     float var9 = 0.0F;
/* 1910 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1911 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*      */     
/* 1913 */     this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*      */     
/* 1915 */     float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1916 */     float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1917 */     float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1918 */     IceBall lb = new IceBall(this.worldObj, cx, this.posY + yoff, cz);
/* 1919 */     lb.setIceMaker(1);
/* 1920 */     lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0F, 0.0F);
/* 1921 */     var3 = x - lb.posX;
/* 1922 */     var5 = y + 0.25D - lb.posY;
/* 1923 */     var7 = z - lb.posZ;
/* 1924 */     var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 1925 */     lb.setThrowableHeading(var3, var5 + var9, var7, 1.4F, 4.0F);
/* 1926 */     lb.motionX *= 3.0D;
/* 1927 */     lb.motionY *= 3.0D;
/* 1928 */     lb.motionZ *= 3.0D;
/* 1929 */     this.worldObj.spawnEntityInWorld((Entity)lb);
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ThePrinceAdult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */