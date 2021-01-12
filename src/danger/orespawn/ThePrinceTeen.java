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
/*      */ import net.minecraft.entity.ai.EntityAIMoveIndoors;
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
/*      */ public class ThePrinceTeen
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
/*   90 */   private float moveSpeed = 0.32F;
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
/*  102 */   private int kill_count = 0;
/*  103 */   private int day_count = 0;
/*  104 */   private int is_day = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ThePrinceTeen(World par1World) {
/*  112 */     super(par1World);
/*      */     
/*  114 */     setSize(3.25F, 4.25F);
/*  115 */     getNavigator().setAvoidsWater(true);
/*  116 */     this.experienceValue = 300;
/*  117 */     this.fireResistance = 1000;
/*  118 */     this.isImmuneToFire = true;
/*  119 */     setSitting(false);
/*  120 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  121 */     this.tasks.addTask(1, new MyEntityAIFollowOwner(this, 1.1F, 12.0F, 2.0F));
/*  122 */     this.tasks.addTask(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.beef, false));
/*  123 */     this.tasks.addTask(3, new MyEntityAIWander((EntityCreature)this, 0.75F));
/*  124 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 9.0F));
/*  125 */     this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  126 */     this.tasks.addTask(6, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
/*  127 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityLiving.class, 0, true, false, IMob.mobSelector)); 
/*  128 */     this.targetTasks.addTask(2, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*  129 */     this.riddenByEntity = null;
/*  130 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  131 */     this.renderdata = new RenderInfo();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ThePrinceTeen(World par1World, double par2, double par4, double par6) {
/*  137 */     this(par1World);
/*  138 */     setPosition(par2, par4 + this.yOffset, par6);
/*  139 */     this.motionX = 0.0D;
/*  140 */     this.motionY = 0.0D;
/*  141 */     this.motionZ = 0.0D;
/*  142 */     this.prevPosX = par2;
/*  143 */     this.prevPosY = par4;
/*  144 */     this.prevPosZ = par6;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void applyEntityAttributes() {
/*  149 */     super.applyEntityAttributes();
/*  150 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  151 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  152 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  153 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50.0D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean shouldRiderSit() {
/*  162 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTrackingRange() {
/*  167 */     return 64;
/*      */   }
/*      */   
/*      */   public int getUpdateFrequency() {
/*  171 */     return 10;
/*      */   }
/*      */   
/*      */   public boolean sendsVelocityUpdates() {
/*  175 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getHead1Ext() {
/*  180 */     return this.dataWatcher.getWatchableObjectInt(22);
/*      */   }
/*      */   
/*      */   public int getHead2Ext() {
/*  184 */     return this.dataWatcher.getWatchableObjectInt(23);
/*      */   }
/*      */   
/*      */   public int getHead3Ext() {
/*  188 */     return this.dataWatcher.getWatchableObjectInt(25);
/*      */   }
/*      */   
/*      */   public void setHead1Ext(int par1) {
/*  192 */     if (this.worldObj != null && this.worldObj.isRemote)
/*  193 */       return;  this.dataWatcher.updateObject(22, Integer.valueOf(par1));
/*      */   }
/*      */   
/*      */   public void setHead2Ext(int par1) {
/*  197 */     if (this.worldObj != null && this.worldObj.isRemote)
/*  198 */       return;  this.dataWatcher.updateObject(23, Integer.valueOf(par1));
/*      */   }
/*      */   
/*      */   public void setHead3Ext(int par1) {
/*  202 */     if (this.worldObj != null && this.worldObj.isRemote)
/*  203 */       return;  this.dataWatcher.updateObject(25, Integer.valueOf(par1));
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
/*  216 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void entityInit() {
/*  221 */     super.entityInit();
/*  222 */     this.dataWatcher.addObject(20, Integer.valueOf(0));
/*  223 */     this.dataWatcher.addObject(21, Integer.valueOf(0));
/*  224 */     this.dataWatcher.addObject(24, Integer.valueOf(1));
/*  225 */     this.dataWatcher.addObject(22, Integer.valueOf(0));
/*  226 */     this.dataWatcher.addObject(23, Integer.valueOf(0));
/*  227 */     this.dataWatcher.addObject(25, Integer.valueOf(0));
/*  228 */     setActivity(0);
/*  229 */     setAttacking(0);
/*  230 */     setTamed(false);
/*  231 */     setThePrinceTeenFire(1);
/*  232 */     this.noClip = false;
/*      */     
/*  234 */     if (this.renderdata == null) {
/*  235 */       this.renderdata = new RenderInfo();
/*      */     }
/*  237 */     this.renderdata.rf1 = 0.0F;
/*  238 */     this.renderdata.rf2 = 0.0F;
/*  239 */     this.renderdata.rf3 = 0.0F;
/*  240 */     this.renderdata.rf4 = 0.0F;
/*  241 */     this.renderdata.ri1 = 0;
/*  242 */     this.renderdata.ri2 = 0;
/*  243 */     this.renderdata.ri3 = 0;
/*  244 */     this.renderdata.ri4 = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int mygetMaxHealth() {
/*  251 */     return 1500;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getThePrinceTeenHealth() {
/*  258 */     return (int)getHealth();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RenderInfo getRenderInfo() {
/*  265 */     return this.renderdata;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRenderInfo(RenderInfo r) {
/*  270 */     this.renderdata.rf1 = r.rf1;
/*  271 */     this.renderdata.rf2 = r.rf2;
/*  272 */     this.renderdata.rf3 = r.rf3;
/*  273 */     this.renderdata.rf4 = r.rf4;
/*  274 */     this.renderdata.ri1 = r.ri1;
/*  275 */     this.renderdata.ri2 = r.ri2;
/*  276 */     this.renderdata.ri3 = r.ri3;
/*  277 */     this.renderdata.ri4 = r.ri4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  285 */     return 18;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void jump() {
/*  291 */     super.jump();
/*  292 */     this.motionY += 0.25D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAIEnabled() {
/*  300 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBreatheUnderwater() {
/*  309 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLivingSound() {
/*  317 */     if (isSitting())
/*      */     {
/*  319 */       return null;
/*      */     }
/*  321 */     if (getActivity() == 1 && this.riddenByEntity == null) {
/*  322 */       return "orespawn:roar";
/*      */     }
/*      */     
/*  325 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getHurtSound() {
/*  333 */     return "orespawn:alo_hurt";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDeathSound() {
/*  341 */     return "orespawn:alo_death";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundVolume() {
/*  348 */     return 0.6F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getSoundPitch() {
/*  355 */     return 0.75F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBePushed() {
/*  364 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getMountedYOffset() {
/*  372 */     return 2.75D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/*  380 */     return OreSpawnMain.ThePrinceEgg;
/*      */   }
/*      */ 
/*      */   
/*      */   private ItemStack dropItemRand(Item index, int par1) {
/*  385 */     EntityItem var3 = null;
/*  386 */     ItemStack is = new ItemStack(index, par1, 0);
/*      */     
/*  388 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
/*      */     
/*  390 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/*  391 */     return is;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/*  396 */     dropItemRand(OreSpawnMain.ThePrinceEgg, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  405 */     double ks = 1.75D;
/*  406 */     double inair = 0.1D;
/*  407 */     float iskraken = 1.0F;
/*  408 */     if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*      */       
/*  410 */       if (par1Entity instanceof Kraken) iskraken = 2.0F; 
/*  411 */       par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), iskraken * 45.0F);
/*      */       
/*  413 */       float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/*  414 */       if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/*  415 */       par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*  416 */       if (par1Entity instanceof EntityLiving) {
/*  417 */         EntityLiving e = (EntityLiving)par1Entity;
/*  418 */         if (e.getHealth() <= 0.0F) {
/*  419 */           this.kill_count++;
/*      */         }
/*      */       } 
/*      */     } 
/*  423 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  431 */     boolean ret = false;
/*  432 */     Entity e = null;
/*      */     
/*  434 */     if (this.hurt_timer > 0) return false;
/*      */     
/*  436 */     if (par1DamageSource.getDamageType().equals("cactus")) {
/*  437 */       return ret;
/*      */     }
/*  439 */     if (par1DamageSource.getDamageType().equals("inFire")) {
/*  440 */       return ret;
/*      */     }
/*  442 */     if (par1DamageSource.getDamageType().equals("onFire")) {
/*  443 */       return ret;
/*      */     }
/*  445 */     if (par1DamageSource.getDamageType().equals("lava")) {
/*  446 */       return ret;
/*      */     }
/*  448 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/*  449 */       return ret;
/*      */     }
/*      */     
/*  452 */     setSitting(false);
/*  453 */     setActivity(1);
/*      */     
/*  455 */     e = par1DamageSource.getEntity();
/*      */ 
/*      */     
/*  458 */     if (e != null && e instanceof BetterFireball) {
/*      */       
/*  460 */       e.setDead();
/*  461 */       return ret;
/*      */     } 
/*      */     
/*  464 */     if (e != null && e instanceof net.minecraft.entity.projectile.EntitySmallFireball) {
/*      */       
/*  466 */       e.setDead();
/*  467 */       return ret;
/*      */     } 
/*  469 */     if (e != null && e instanceof ThePrinceTeen) {
/*  470 */       return false;
/*      */     }
/*  472 */     if (e != null && e instanceof Spyro) {
/*  473 */       return false;
/*      */     }
/*      */     
/*  476 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*  477 */     this.hurt_timer = 20;
/*      */     
/*  479 */     if (e != null && e instanceof EntityLivingBase) {
/*      */       
/*  481 */       if (isTamed() && 
/*  482 */         e instanceof EntityPlayer) {
/*  483 */         return false;
/*      */       }
/*      */ 
/*      */       
/*  487 */       setAttackTarget((EntityLivingBase)e);
/*  488 */       setTarget(e);
/*  489 */       getNavigator().tryMoveToEntityLiving(e, 1.2D);
/*  490 */       ret = true;
/*      */     } 
/*      */     
/*  493 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateAITasks() {
/*  499 */     EntityLivingBase e = null;
/*  500 */     super.updateAITasks();
/*      */ 
/*      */     
/*  503 */     if (!isSitting() && getActivity() == 0 && this.riddenByEntity == null && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(10) == 1) {
/*      */       
/*  505 */       e = findSomethingToAttack();
/*  506 */       if (e != null) {
/*      */ 
/*      */         
/*  509 */         setActivity(1);
/*      */       } else {
/*  511 */         setAttacking(0);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  516 */     if (this.kill_count > 25 && this.day_count > 10) {
/*  517 */       Entity ent = null;
/*  518 */       ThePrinceAdult d = null;
/*  519 */       ent = spawnCreature(this.worldObj, "The Young Adult Prince", this.posX, this.posY, this.posZ);
/*  520 */       if (ent != null) {
/*  521 */         d = (ThePrinceAdult)ent;
/*  522 */         if (isTamed()) {
/*  523 */           d.setTamed(true);
/*  524 */           d.func_152115_b(func_152113_b());
/*      */         } 
/*  526 */         setDead();
/*      */       } 
/*      */     } 
/*      */     
/*  530 */     if (this.is_day == 0) {
/*  531 */       this.is_day = 1;
/*  532 */       if (!this.worldObj.isDaytime()) this.is_day = -1; 
/*      */     } else {
/*  534 */       if (this.is_day == -1 && 
/*  535 */         this.worldObj.isDaytime())
/*      */       {
/*  537 */         this.day_count++;
/*      */       }
/*      */       
/*  540 */       this.is_day = 1;
/*  541 */       if (!this.worldObj.isDaytime()) this.is_day = -1;
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   public void always_do() {
/*  547 */     EntityPlayer p = null;
/*      */ 
/*      */     
/*  550 */     if (this.worldObj.rand.nextInt(250) == 1 && 
/*  551 */       getHealth() < mygetMaxHealth())
/*      */     {
/*  553 */       heal(2.0F);
/*      */     }
/*      */ 
/*      */     
/*  557 */     if (this.worldObj.rand.nextInt(250) == 0) {
/*  558 */       setAttackTarget(null);
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
/*  574 */     if (isSitting())
/*      */       return; 
/*  576 */     this.owner_flying = 0;
/*  577 */     if (isTamed() && getOwner() != null && this.riddenByEntity == null && !isSitting()) {
/*  578 */       p = (EntityPlayer)getOwner();
/*      */       
/*  580 */       if (p.capabilities.isFlying) {
/*  581 */         this.owner_flying = 1;
/*      */         
/*  583 */         setActivity(1);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  589 */     if (this.worldObj.rand.nextInt(50) == 1 && !isSitting())
/*      */     {
/*  591 */       if (!this.target_in_sight && this.riddenByEntity == null)
/*      */       {
/*  593 */         if (this.worldObj.rand.nextInt(15) == 1) {
/*      */           
/*  595 */           setActivity(1);
/*      */         } else {
/*      */           
/*  598 */           setActivity(0);
/*      */         } 
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void fly_with_rider() {
/*  607 */     EntityLivingBase e = null;
/*      */ 
/*      */     
/*  610 */     if (this.isDead)
/*      */       return; 
/*  612 */     if (isSitting())
/*  613 */       return;  if (this.worldObj.isRemote)
/*      */       return; 
/*  615 */     if (this.worldObj.rand.nextInt(5) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
/*      */       
/*  617 */       e = findSomethingToAttack();
/*  618 */       if (e != null) {
/*      */         
/*  620 */         setAttacking(1);
/*  621 */         if (getDistanceSqToEntity((Entity)e) < ((8.0F + e.width / 2.0F) * (8.0F + e.width / 2.0F))) {
/*      */           
/*  623 */           attackEntityAsMob((Entity)e);
/*  624 */         } else if (getDistanceSqToEntity((Entity)e) > 100.0D && getDistanceSqToEntity((Entity)e) < 625.0D && !isInWater() && 
/*  625 */           getThePrinceTeenFire() != 0) {
/*  626 */           shoot_something(e.posX, e.posY, e.posZ);
/*      */         } 
/*      */       } else {
/*      */         
/*  630 */         setAttacking(0);
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
/*  641 */     if (this.riddenByEntity != null)
/*  642 */       return;  super.updateAITick();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/*  650 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*      */     
/*  652 */     if (par1EntityLiving == null)
/*      */     {
/*  654 */       return false;
/*      */     }
/*  656 */     if (par1EntityLiving == this)
/*      */     {
/*  658 */       return false;
/*      */     }
/*  660 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/*      */       
/*  663 */       return false;
/*      */     }
/*  665 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*      */       
/*  668 */       return false;
/*      */     }
/*  670 */     if (MyUtils.isRoyalty((Entity)par1EntityLiving))
/*      */     {
/*  672 */       return false;
/*      */     }
/*      */     
/*  675 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityMob)
/*      */     {
/*  677 */       return true;
/*      */     }
/*  679 */     if (par1EntityLiving instanceof Mothra)
/*      */     {
/*      */       
/*  682 */       return true;
/*      */     }
/*  684 */     if (par1EntityLiving instanceof Kraken)
/*      */     {
/*      */       
/*  687 */       return true;
/*      */     }
/*  689 */     if (par1EntityLiving instanceof Leon) {
/*      */       
/*  691 */       Leon l = (Leon)par1EntityLiving;
/*  692 */       if (l.isTamed()) return false;
/*      */       
/*  694 */       return true;
/*      */     } 
/*  696 */     if (par1EntityLiving instanceof WaterDragon) {
/*      */       
/*  698 */       WaterDragon l = (WaterDragon)par1EntityLiving;
/*  699 */       if (l.isTamed()) return false;
/*      */       
/*  701 */       return true;
/*      */     } 
/*  703 */     if (par1EntityLiving instanceof GammaMetroid) {
/*      */       
/*  705 */       GammaMetroid l = (GammaMetroid)par1EntityLiving;
/*  706 */       if (l.isTamed()) return false;
/*      */       
/*  708 */       return true;
/*      */     } 
/*      */ 
/*      */     
/*  712 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private EntityLivingBase findSomethingToAttack() {
/*  717 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/*  718 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(25.0D, 20.0D, 25.0D));
/*  719 */     Collections.sort(var5, this.TargetSorter);
/*  720 */     Iterator<?> var2 = var5.iterator();
/*  721 */     Entity var3 = null;
/*  722 */     EntityLivingBase var4 = null;
/*      */     
/*  724 */     while (var2.hasNext()) {
/*      */       
/*  726 */       var3 = (Entity)var2.next();
/*  727 */       var4 = (EntityLivingBase)var3;
/*      */       
/*  729 */       if (isSuitableTarget(var4, false))
/*      */       {
/*  731 */         return var4;
/*      */       }
/*      */     } 
/*  734 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean doesEntityNotTriggerPressurePlate() {
/*  741 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanSpawnHere() {
/*  749 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/*  757 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
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
/*  769 */     super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
/*  770 */     this.boatPosRotationIncrements = par9;
/*      */ 
/*      */     
/*  773 */     this.boatX = par1;
/*  774 */     this.boatY = par3;
/*  775 */     this.boatZ = par5;
/*  776 */     this.boatYaw = par7;
/*  777 */     this.boatPitch = par8;
/*  778 */     this.boatYawHead = par7;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void setVelocity(double par1, double par3, double par5) {
/*  788 */     super.setVelocity(par1, par3, par5);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate() {
/*  794 */     EntityLivingBase e = null;
/*      */     
/*  796 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  797 */     super.onUpdate();
/*      */     
/*  799 */     if (getActivity() != 0) {
/*  800 */       this.noClip = true;
/*      */     } else {
/*  802 */       this.noClip = false;
/*      */     } 
/*      */     
/*  805 */     if (!this.worldObj.isRemote) {
/*  806 */       if (this.worldObj.rand.nextInt(10) == 1) {
/*  807 */         int i = this.worldObj.rand.nextInt(3);
/*  808 */         if (i == 0) this.head1dir = 2; 
/*  809 */         if (i == 1) this.head1dir = -2; 
/*  810 */         if (i == 2) this.head1dir = 0; 
/*      */       } 
/*  812 */       if (this.worldObj.rand.nextInt(10) == 1) {
/*  813 */         int i = this.worldObj.rand.nextInt(3);
/*  814 */         if (i == 0) this.head2dir = 2; 
/*  815 */         if (i == 1) this.head2dir = -2; 
/*  816 */         if (i == 2) this.head2dir = 0; 
/*      */       } 
/*  818 */       if (this.worldObj.rand.nextInt(10) == 1) {
/*  819 */         int i = this.worldObj.rand.nextInt(3);
/*  820 */         if (i == 0) this.head3dir = 2; 
/*  821 */         if (i == 1) this.head3dir = -2; 
/*  822 */         if (i == 2) this.head3dir = 0; 
/*      */       } 
/*  824 */       this.head1ext += this.head1dir;
/*  825 */       if (this.head1ext < 0) this.head1ext = 0; 
/*  826 */       if (this.head1ext > 60) this.head1ext = 60; 
/*  827 */       this.head2ext += this.head2dir;
/*  828 */       if (this.head2ext < 0) this.head2ext = 0; 
/*  829 */       if (this.head2ext > 60) this.head2ext = 60; 
/*  830 */       this.head3ext += this.head3dir;
/*  831 */       if (this.head3ext < 0) this.head3ext = 0; 
/*  832 */       if (this.head3ext > 60) this.head3ext = 60;
/*      */       
/*  834 */       setHead1Ext(this.head1ext);
/*  835 */       setHead2Ext(this.head2ext);
/*  836 */       setHead3Ext(this.head3ext);
/*      */     } 
/*      */     
/*  839 */     if (this.hurt_timer > 0) this.hurt_timer--;
/*      */     
/*  841 */     if (getActivity() == 1) {
/*  842 */       this.wing_sound++;
/*  843 */       if (this.wing_sound > 20) {
/*      */         
/*  845 */         if (!this.worldObj.isRemote) this.worldObj.playSoundAtEntity((Entity)this, "orespawn:MothraWings", 0.5F, 1.0F); 
/*  846 */         this.wing_sound = 0;
/*      */       } 
/*      */     } 
/*      */     
/*  850 */     if (isInWater()) {
/*  851 */       this.motionY += 0.07D;
/*      */     }
/*      */     
/*  854 */     if (this.worldObj.isRemote)
/*      */       return; 
/*  856 */     if (getActivity() == 0 && isTamed() && getOwner() != null && !isSitting()) {
/*  857 */       e = getOwner();
/*      */       
/*  859 */       if (getDistanceSqToEntity((Entity)e) > 400.0D)
/*      */       {
/*  861 */         setActivity(1);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void fly_without_rider() {
/*  869 */     int xdir = 1;
/*  870 */     int zdir = 1;
/*      */     
/*  872 */     int keep_trying = 10;
/*      */ 
/*      */     
/*  875 */     int do_new = 0;
/*  876 */     double ox = 0.0D, oy = 0.0D, oz = 0.0D;
/*      */     
/*  878 */     int has_owner = 0;
/*  879 */     EntityLivingBase e = null;
/*  880 */     double speed_factor = 0.5D;
/*  881 */     double var1 = 0.0D;
/*  882 */     double var3 = 0.0D;
/*  883 */     double var5 = 0.0D;
/*      */ 
/*      */ 
/*      */     
/*  887 */     double gh = 1.25D;
/*  888 */     double obstruction_factor = 0.0D;
/*  889 */     double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */     
/*  891 */     int toofar = 0;
/*      */ 
/*      */     
/*  894 */     if (this.currentFlightTarget == null) {
/*  895 */       do_new = 1;
/*  896 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*      */     } 
/*  898 */     if (this.riddenByEntity != null) {
/*      */       return;
/*      */     }
/*  901 */     if (isTamed() && getOwner() != null) {
/*  902 */       e = getOwner();
/*  903 */       has_owner = 1;
/*  904 */       ox = e.posX;
/*  905 */       oy = e.posY;
/*  906 */       oz = e.posZ;
/*  907 */       if (getDistanceSqToEntity((Entity)e) > 400.0D) {
/*  908 */         toofar = 1;
/*  909 */         this.target_in_sight = false;
/*  910 */         setAttacking(0);
/*  911 */         setSitting(false);
/*  912 */         this.flyaway = 0;
/*  913 */         do_new = 1;
/*      */       } 
/*      */     } 
/*      */     
/*  917 */     if (isSitting())
/*      */       return; 
/*  919 */     if (this.posY < this.currentFlightTarget.posY + 2.0D) {
/*  920 */       this.motionY *= 0.7D;
/*  921 */     } else if (this.posY > this.currentFlightTarget.posY - 2.0D) {
/*  922 */       this.motionY *= 0.5D;
/*      */     } else {
/*  924 */       this.motionY *= 0.61D;
/*      */     } 
/*      */ 
/*      */     
/*  928 */     if (this.worldObj.rand.nextInt(300) == 1) do_new = 1; 
/*  929 */     if (this.flyaway > 0) this.flyaway--;
/*      */ 
/*      */     
/*  932 */     if (toofar == 0 && this.flyaway == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(7) == 1) {
/*      */ 
/*      */       
/*  935 */       e = getAttackTarget();
/*  936 */       if (e != null && !e.isEntityAlive()) {
/*  937 */         setAttackTarget(null);
/*  938 */         e = null;
/*      */       } 
/*      */       
/*  941 */       if (e == null) {
/*  942 */         e = findSomethingToAttack();
/*      */       }
/*  944 */       if (e != null) {
/*      */         
/*  946 */         if (isTamed() && getHealth() / mygetMaxHealth() < 0.25F) {
/*  947 */           setActivity(1);
/*  948 */           setAttacking(0);
/*  949 */           this.target_in_sight = false;
/*  950 */           do_new = 0;
/*  951 */           this.currentFlightTarget.set((int)(this.posX + this.posX - e.posX), (int)(this.posY + 1.0D), (int)(this.posZ + this.posZ - e.posZ));
/*      */         } else {
/*      */           
/*  954 */           setActivity(1);
/*  955 */           setAttacking(1);
/*  956 */           this.target_in_sight = true;
/*  957 */           this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0D), (int)e.posZ);
/*      */           
/*  959 */           do_new = 0;
/*  960 */           if (getDistanceSqToEntity((Entity)e) < ((8.0F + e.width / 2.0F) * (8.0F + e.width / 2.0F))) {
/*  961 */             attackEntityAsMob((Entity)e);
/*  962 */             this.flyaway = 5 + this.worldObj.rand.nextInt(15);
/*  963 */             do_new = 1;
/*  964 */           } else if (getDistanceSqToEntity((Entity)e) < 400.0D && !isInWater()) {
/*      */             
/*  966 */             if (getThePrinceTeenFire() != 0 && this.worldObj.rand.nextInt(2) == 1) {
/*  967 */               shoot_something(e.posX, e.posY, e.posZ);
/*      */             }
/*      */           }
/*      */         
/*      */         } 
/*      */       } else {
/*      */         
/*  974 */         this.target_in_sight = false;
/*  975 */         this.flyaway = 0;
/*  976 */         setAttacking(0);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  981 */     if (this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*  982 */       do_new = 1;
/*      */     }
/*      */ 
/*      */     
/*  986 */     if ((do_new != 0 && !this.target_in_sight) || (do_new != 0 && this.flyaway != 0)) {
/*      */       
/*  988 */       Block bid = Blocks.stone;
/*  989 */       while (bid != Blocks.air && keep_trying != 0) {
/*  990 */         int gox = (int)this.posX;
/*  991 */         int goy = (int)this.posY;
/*  992 */         int goz = (int)this.posZ;
/*  993 */         if (has_owner == 1) {
/*  994 */           gox = (int)ox;
/*  995 */           goy = (int)oy;
/*  996 */           goz = (int)oz;
/*  997 */           if (this.owner_flying == 0) {
/*  998 */             zdir = this.worldObj.rand.nextInt(14) + 5;
/*  999 */             xdir = this.worldObj.rand.nextInt(14) + 5;
/*      */           } else {
/* 1001 */             zdir = this.worldObj.rand.nextInt(6);
/* 1002 */             xdir = this.worldObj.rand.nextInt(6);
/*      */           } 
/*      */         } else {
/* 1005 */           zdir = this.worldObj.rand.nextInt(10) + 16;
/* 1006 */           xdir = this.worldObj.rand.nextInt(10) + 16;
/*      */         } 
/* 1008 */         if (this.worldObj.rand.nextInt(2) == 1) zdir = -zdir; 
/* 1009 */         if (this.worldObj.rand.nextInt(2) == 1) xdir = -xdir; 
/* 1010 */         this.currentFlightTarget.set(gox + xdir, goy + this.worldObj.rand.nextInt(9 + this.owner_flying * 2) - 4, goz + zdir);
/* 1011 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 1012 */         if (bid == Blocks.air && 
/* 1013 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 1014 */           bid = Blocks.stone;
/*      */         }
/*      */         
/* 1017 */         keep_trying--;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1025 */     obstruction_factor = 0.0D;
/* 1026 */     int dist = 2;
/* 1027 */     dist += (int)(velocity * 4.0D);
/*      */     
/* 1029 */     for (int k = 1; k < dist; k++) {
/* 1030 */       for (int i = 1; i < dist * 2; i++) {
/* 1031 */         double dx = i * Math.cos(Math.toRadians((this.rotationYaw + 90.0F)));
/* 1032 */         double dz = i * Math.sin(Math.toRadians((this.rotationYaw + 90.0F)));
/* 1033 */         Block bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - k, (int)(this.posZ + dz));
/* 1034 */         if (bid != Blocks.air) {
/* 1035 */           obstruction_factor += 0.05D;
/*      */         }
/*      */       } 
/*      */     } 
/* 1039 */     this.motionY += obstruction_factor * 0.05D;
/* 1040 */     this.posY += obstruction_factor * 0.05D;
/*      */ 
/*      */     
/* 1043 */     speed_factor = 0.5D;
/* 1044 */     var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 1045 */     var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 1046 */     var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 1047 */     if (this.owner_flying != 0) {
/* 1048 */       speed_factor = 1.75D;
/* 1049 */       if (isTamed() && getOwner() != null) {
/* 1050 */         e = getOwner();
/* 1051 */         if (getDistanceSqToEntity((Entity)e) > 64.0D) {
/* 1052 */           speed_factor = 3.5D;
/*      */         }
/*      */       } 
/*      */     } 
/* 1056 */     this.motionX += (Math.signum(var1) - this.motionX) * 0.15D * speed_factor;
/* 1057 */     this.motionY += (Math.signum(var3) - this.motionY) * 0.21D * speed_factor;
/* 1058 */     this.motionZ += (Math.signum(var5) - this.motionZ) * 0.15D * speed_factor;
/* 1059 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 1060 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 1061 */     this.moveForward = (float)(0.75D * speed_factor);
/*      */     
/* 1063 */     this.rotationYaw += var8 / 4.0F;
/* 1064 */     moveEntity(this.motionX, this.motionY, this.motionZ);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onLivingUpdate() {
/* 1074 */     List<Entity> list = null;
/* 1075 */     Entity listEntity = null;
/*      */ 
/*      */ 
/*      */     
/* 1079 */     double d6 = (this.rand.nextFloat() * 2.0F - 1.0F);
/* 1080 */     double d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1086 */     double obstruction_factor = 0.0D;
/*      */     
/* 1088 */     double relative_g = 0.0D;
/*      */     
/* 1090 */     double max_speed = 0.95D;
/* 1091 */     double gh = 1.0D;
/*      */ 
/*      */ 
/*      */     
/* 1095 */     double rt = 0.0D;
/*      */     
/* 1097 */     double pi = 3.1415926545D;
/* 1098 */     double deltav = 0.0D;
/*      */ 
/*      */ 
/*      */     
/* 1102 */     int dist = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1107 */     if (getActivity() == 0) {
/*      */       
/* 1109 */       super.onLivingUpdate();
/*      */     
/*      */     }
/* 1112 */     else if (this.isDead) {
/* 1113 */       super.onLivingUpdate();
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1118 */     if (this.isDead) {
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
/* 1131 */     if (this.worldObj.isRemote) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1136 */       if (this.boatPosRotationIncrements > 0 && getActivity() != 0) {
/*      */         
/* 1138 */         double d4 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
/* 1139 */         double d5 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
/* 1140 */         double d11 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
/* 1141 */         setPosition(d4, d5, d11);
/*      */         
/* 1143 */         this.rotationPitch = (float)(this.rotationPitch + (this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
/* 1144 */         double d10 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
/* 1145 */         if (this.riddenByEntity != null) d10 = MathHelper.wrapAngleTo180_double(this.riddenByEntity.rotationYaw - this.rotationYaw); 
/* 1146 */         this.rotationYaw = (float)(this.rotationYaw + d10 / this.boatPosRotationIncrements);
/* 1147 */         setRotation(this.rotationYaw, this.rotationPitch);
/* 1148 */         this.rotationYawHead = this.rotationYaw;
/*      */         
/* 1150 */         this.boatPosRotationIncrements--;
/*      */       } 
/*      */     } else {
/*      */       
/* 1154 */       if (getActivity() != 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1160 */         if (this.fireballticker > 0) this.fireballticker--;
/*      */         
/* 1162 */         if (this.riddenByEntity != null) {
/* 1163 */           EntityPlayer pp = (EntityPlayer)this.riddenByEntity;
/*      */ 
/*      */ 
/*      */           
/* 1167 */           if (this.motionX < -2.0D) this.motionX = -2.0D; 
/* 1168 */           if (this.motionX > 2.0D) this.motionX = 2.0D; 
/* 1169 */           if (this.motionZ < -2.0D) this.motionZ = -2.0D; 
/* 1170 */           if (this.motionZ > 2.0D) this.motionZ = 2.0D; 
/* 1171 */           double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */ 
/*      */           
/* 1174 */           gh = 1.25D;
/* 1175 */           Block bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh), (int)this.posZ);
/* 1176 */           if (bid != Blocks.air) {
/* 1177 */             this.motionY += 0.03D;
/* 1178 */             this.posY += 0.1D;
/*      */           } else {
/*      */             
/* 1181 */             this.motionY -= 0.018D;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1188 */           obstruction_factor = 0.0D;
/* 1189 */           dist = 3;
/* 1190 */           dist += (int)(velocity * 7.0D);
/*      */           
/* 1192 */           for (int k = 1; k < dist; k++) {
/* 1193 */             for (int i = 1; i < dist * 2; i++) {
/* 1194 */               double dx = i * Math.cos(Math.toRadians((this.rotationYaw + 90.0F)));
/* 1195 */               double dz = i * Math.sin(Math.toRadians((this.rotationYaw + 90.0F)));
/* 1196 */               bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - k, (int)(this.posZ + dz));
/* 1197 */               if (bid != Blocks.air) {
/* 1198 */                 obstruction_factor += 0.05D;
/*      */               }
/*      */             } 
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 1205 */           this.motionY += obstruction_factor * 0.07D;
/* 1206 */           this.posY += obstruction_factor * 0.07D;
/* 1207 */           if (this.motionY > 2.0D) this.motionY = 2.0D;
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
/* 1218 */           double d4 = this.riddenByEntity.rotationYaw;
/* 1219 */           d4 %= 360.0D;
/* 1220 */           for (; d4 < 0.0D; d4 += 360.0D);
/* 1221 */           double d5 = this.rotationYaw;
/* 1222 */           d5 %= 360.0D;
/* 1223 */           for (; d5 < 0.0D; d5 += 360.0D);
/* 1224 */           relative_g = (d4 - d5) % 180.0D;
/* 1225 */           for (; relative_g < 0.0D; relative_g += 180.0D);
/* 1226 */           if (relative_g > 90.0D) relative_g -= 180.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1233 */           if (velocity > 0.01D) {
/*      */             
/* 1235 */             d4 = 1.85D - velocity;
/* 1236 */             d4 = Math.abs(d4);
/* 1237 */             if (d4 < 0.01D) d4 = 0.01D; 
/* 1238 */             if (d4 > 0.9D) d4 = 0.9D; 
/* 1239 */             this.rotationYaw = this.riddenByEntity.rotationYaw + (float)(relative_g * d4);
/*      */           } else {
/*      */             
/* 1242 */             this.rotationYaw = this.riddenByEntity.rotationYaw;
/*      */           } 
/* 1244 */           relative_g = Math.abs(relative_g) * velocity;
/* 1245 */           if (relative_g > 50.0D) relative_g = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1250 */           this.rotationPitch = 2.0F * (float)velocity;
/* 1251 */           setRotation(this.rotationYaw, this.rotationPitch);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1257 */           double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1265 */           double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
/* 1266 */           double rhm = Math.atan2(this.motionZ, this.motionX);
/* 1267 */           double rhdir = Math.toRadians(((this.riddenByEntity.rotationYaw + 90.0F) % 360.0F));
/* 1268 */           rt = 0.0D;
/* 1269 */           pi = 3.1415926545D;
/* 1270 */           deltav = 0.0D;
/* 1271 */           float im = pp.moveForward;
/*      */ 
/*      */           
/* 1274 */           if (OreSpawnMain.flyup_keystate != 0) {
/* 1275 */             this.motionY += 0.035D;
/* 1276 */             this.motionY += velocity * 0.046D;
/*      */           } 
/*      */ 
/*      */           
/* 1280 */           double rdv = Math.abs(rhm - rhdir) % pi * 2.0D;
/* 1281 */           if (rdv > pi) rdv -= pi * 2.0D; 
/* 1282 */           rdv = Math.abs(rdv);
/* 1283 */           if (Math.abs(newvelocity) < 0.01D) rdv = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1291 */           if (rdv > 1.5D) newvelocity = -newvelocity;
/*      */           
/* 1293 */           if (Math.abs(im) > 0.001F) {
/* 1294 */             if (im > 0.0F) {
/* 1295 */               deltav = 0.025D;
/* 1296 */               if (max_speed > 1.0D) deltav += 0.05D; 
/* 1297 */               if (this.deltasmooth < 0.0F) this.deltasmooth = 0.0F; 
/* 1298 */               this.deltasmooth = (float)(this.deltasmooth + deltav / 10.0D);
/* 1299 */               if (this.deltasmooth > deltav) this.deltasmooth = (float)deltav;
/*      */             
/*      */             } else {
/* 1302 */               max_speed = 0.35D;
/*      */               
/* 1304 */               deltav = -0.02D;
/* 1305 */               if (this.deltasmooth > 0.0F) this.deltasmooth = 0.0F; 
/* 1306 */               this.deltasmooth = (float)(this.deltasmooth + deltav / 10.0D);
/* 1307 */               if (this.deltasmooth < deltav) this.deltasmooth = (float)deltav;
/*      */             
/*      */             } 
/* 1310 */             newvelocity += this.deltasmooth;
/* 1311 */             if (newvelocity >= 0.0D) {
/* 1312 */               if (newvelocity > max_speed) newvelocity = max_speed; 
/* 1313 */               this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 1314 */               this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*      */             } else {
/* 1316 */               if (newvelocity < -max_speed) newvelocity = -max_speed; 
/* 1317 */               newvelocity = -newvelocity;
/* 1318 */               this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/* 1319 */               this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/*      */             }
/*      */           
/*      */           }
/* 1323 */           else if (newvelocity >= 0.0D) {
/* 1324 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 1325 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*      */           } else {
/* 1327 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/* 1328 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 1333 */           if (this.fireballticker == 0 && (pp.moveStrafing < -0.001F || pp.moveStrafing > 0.001F)) {
/*      */             
/* 1335 */             double yoff = 1.5D;
/* 1336 */             double xzoff = 7.5D;
/*      */             
/* 1338 */             this.which_attack++;
/* 1339 */             if (this.which_attack > 2) this.which_attack = 0;
/*      */ 
/*      */             
/* 1342 */             if (this.which_attack == 0) {
/* 1343 */               yoff += (getHead1Ext() * 0.04F);
/* 1344 */               double cx = this.posX - xzoff * Math.sin(Math.toRadians((this.rotationYaw - 10.0F)));
/* 1345 */               double cz = this.posZ + xzoff * Math.cos(Math.toRadians((this.rotationYaw - 10.0F)));
/* 1346 */               BetterFireball bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, 0.0D, 0.0D, 0.0D);
/* 1347 */               bf.setNotMe();
/* 1348 */               bf.setPosition(cx, this.posY + yoff, cz);
/* 1349 */               cx = Math.cos(Math.toRadians((pp.rotationYawHead + 90.0F)));
/* 1350 */               cz = Math.sin(Math.toRadians((pp.rotationYawHead + 90.0F)));
/* 1351 */               double cy = -Math.sin(Math.toRadians(pp.rotationPitch));
/*      */               
/* 1353 */               double d3 = MathHelper.sqrt_double(cx * cx + cy * cy + cz * cz);
/* 1354 */               bf.accelerationX = cx / d3 * 0.1D;
/* 1355 */               bf.accelerationY = cy / d3 * 0.1D;
/* 1356 */               bf.accelerationZ = cz / d3 * 0.1D;
/* 1357 */               bf.motionX = this.motionX;
/* 1358 */               bf.motionY = this.motionY;
/* 1359 */               bf.motionZ = this.motionZ;
/* 1360 */               bf.posX -= this.motionX * 3.0D;
/* 1361 */               bf.posY -= this.motionY * 3.0D;
/* 1362 */               bf.posZ -= this.motionZ * 3.0D;
/* 1363 */               this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1364 */               this.worldObj.spawnEntityInWorld((Entity)bf);
/*      */             } 
/*      */             
/* 1367 */             if (this.which_attack == 1) {
/* 1368 */               yoff += (getHead3Ext() * 0.04F);
/* 1369 */               double cx = this.posX - xzoff * Math.sin(Math.toRadians((this.rotationYaw + 10.0F)));
/* 1370 */               double cz = this.posZ + xzoff * Math.cos(Math.toRadians((this.rotationYaw + 10.0F)));
/* 1371 */               IceBall var2 = new IceBall(this.worldObj, cx, this.posY + yoff, cz);
/* 1372 */               var2.setLocationAndAngles(cx, this.posY + yoff, cz, pp.rotationYaw + 90.0F, pp.rotationPitch);
/* 1373 */               var2.setIceMaker(1);
/* 1374 */               double var3 = Math.cos(Math.toRadians((pp.rotationYaw + 90.0F)));
/* 1375 */               double var5 = -Math.sin(Math.toRadians(pp.rotationPitch));
/* 1376 */               double var77 = Math.sin(Math.toRadians((pp.rotationYaw + 90.0F)));
/* 1377 */               float var9 = MathHelper.sqrt_double(var3 * var3 + var77 * var77) * 0.2F;
/* 1378 */               var2.setThrowableHeading(var3, var5 + var9, var77, 1.4F, 5.0F);
/* 1379 */               var2.posX -= this.motionX * 3.0D;
/* 1380 */               var2.posY -= this.motionY * 3.0D;
/* 1381 */               var2.posZ -= this.motionZ * 3.0D;
/* 1382 */               var2.motionX *= 2.0D;
/* 1383 */               var2.motionY *= 2.0D;
/* 1384 */               var2.motionZ *= 2.0D;
/* 1385 */               this.worldObj.playSoundAtEntity((Entity)this, "fireworks.launch", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1386 */               this.worldObj.spawnEntityInWorld((Entity)var2);
/*      */             } 
/*      */             
/* 1389 */             if (this.which_attack == 2) {
/* 1390 */               yoff += (getHead2Ext() * 0.04F);
/* 1391 */               double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1392 */               double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/* 1393 */               ThunderBolt lb = new ThunderBolt(this.worldObj, (EntityLivingBase)pp);
/* 1394 */               lb.setLocationAndAngles(cx, this.posY + yoff, cz, pp.rotationYaw + 90.0F, pp.rotationPitch);
/* 1395 */               lb.motionX *= 3.0D;
/* 1396 */               lb.motionY *= 3.0D;
/* 1397 */               lb.motionZ *= 3.0D;
/* 1398 */               this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1399 */               this.worldObj.spawnEntityInWorld((Entity)lb);
/*      */             } 
/* 1401 */             this.fireballticker = 10;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 1406 */           moveEntity(this.motionX, this.motionY, this.motionZ);
/*      */ 
/*      */           
/* 1409 */           this.motionX *= 0.985D;
/* 1410 */           this.motionY *= 0.94D;
/* 1411 */           this.motionZ *= 0.985D;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1416 */           if (!this.worldObj.isRemote) {
/*      */             
/* 1418 */             list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(3.25D, 4.0D, 3.25D));
/*      */             
/* 1420 */             if (list != null && !list.isEmpty())
/*      */             {
/* 1422 */               for (int l = 0; l < list.size(); l++) {
/*      */                 
/* 1424 */                 listEntity = list.get(l);
/*      */                 
/* 1426 */                 if (listEntity != this.riddenByEntity && !listEntity.isDead && listEntity.canBePushed())
/*      */                 {
/* 1428 */                   listEntity.applyEntityCollision((Entity)this);
/*      */                 }
/*      */               } 
/*      */             }
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 1436 */           fly_with_rider();
/*      */           
/* 1438 */           if (this.riddenByEntity != null && this.riddenByEntity.isDead)
/*      */           {
/* 1440 */             this.riddenByEntity = null;
/*      */           }
/*      */         } else {
/*      */           
/* 1444 */           fly_without_rider();
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1450 */       always_do();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateRiderPosition() {
/* 1457 */     if (this.riddenByEntity != null) {
/*      */ 
/*      */ 
/*      */       
/* 1461 */       float f = 0.65F;
/* 1462 */       this.riddenByEntity.setPosition(this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)));
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
/* 1474 */     String s = "heart";
/*      */     
/* 1476 */     if (!par1)
/*      */     {
/* 1478 */       s = "smoke";
/*      */     }
/*      */     
/* 1481 */     for (int i = 0; i < 20; i++) {
/*      */       
/* 1483 */       double d0 = this.rand.nextGaussian() * 0.08D;
/* 1484 */       double d1 = this.rand.nextGaussian() * 0.08D;
/* 1485 */       double d2 = this.rand.nextGaussian() * 0.08D;
/* 1486 */       this.worldObj.spawnParticle(s, this.posX + ((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5F), this.posY + 0.5D + this.rand.nextFloat() * 1.5D, this.posZ + ((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5F), d0, d1, d2);
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
/* 1497 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*      */     
/* 1499 */     if (var2 != null && 
/* 1500 */       var2.stackSize <= 0) {
/* 1501 */       par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 1502 */       var2 = null;
/*      */     } 
/*      */ 
/*      */     
/* 1506 */     if (var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.diamond_block) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) {
/* 1507 */       if (!this.worldObj.isRemote) {
/*      */         
/* 1509 */         setTamed(true);
/* 1510 */         func_152115_b(par1EntityPlayer.getUniqueID().toString());
/* 1511 */         playTameEffect(true);
/* 1512 */         this.worldObj.setEntityState((Entity)this, (byte)7);
/* 1513 */         heal(mygetMaxHealth() - getHealth());
/* 1514 */         this.kill_count = 1000;
/* 1515 */         this.day_count = 1000;
/*      */       } 
/*      */ 
/*      */       
/* 1519 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 1520 */         var2.stackSize--;
/* 1521 */         if (var2.stackSize <= 0) {
/* 1522 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/* 1525 */       return true;
/*      */     } 
/*      */     
/* 1528 */     if (isTamed()) {
/*      */       
/* 1530 */       if (!isOwner((EntityLivingBase)par1EntityPlayer)) {
/* 1531 */         return false;
/*      */       }
/*      */       
/* 1534 */       if (var2 == null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) {
/* 1535 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1537 */           par1EntityPlayer.mountEntity((Entity)this);
/*      */           
/* 1539 */           setActivity(1);
/* 1540 */           setSitting(false);
/*      */         } 
/* 1542 */         return true;
/*      */       } 
/*      */       
/* 1545 */       if (var2 != null && var2.getItem() == Items.beef && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) {
/* 1546 */         if (this.worldObj.isRemote) {
/* 1547 */           playTameEffect(true);
/* 1548 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/* 1551 */         if (mygetMaxHealth() > getHealth()) {
/* 1552 */           heal(mygetMaxHealth() - getHealth());
/*      */         }
/* 1554 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 1555 */           var2.stackSize--;
/* 1556 */           if (var2.stackSize <= 0) {
/* 1557 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1560 */         return true;
/*      */       } 
/*      */       
/* 1563 */       if (var2 != null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D && var2.getItem() instanceof ItemFood) {
/*      */ 
/*      */         
/* 1566 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1568 */           ItemFood var3 = (ItemFood)var2.getItem();
/*      */           
/* 1570 */           if (mygetMaxHealth() > getHealth())
/*      */           {
/* 1572 */             heal((var3.getHealAmount(var2) * 10));
/*      */           }
/*      */           
/* 1575 */           playTameEffect(true);
/* 1576 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/* 1579 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1581 */           var2.stackSize--;
/* 1582 */           if (var2.stackSize <= 0)
/*      */           {
/* 1584 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1587 */         return true;
/*      */       } 
/*      */ 
/*      */       
/* 1591 */       if (var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.ice) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) {
/*      */         
/* 1593 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1595 */           playTameEffect(true);
/* 1596 */           this.worldObj.setEntityState((Entity)this, (byte)6);
/* 1597 */           setThePrinceTeenFire(0);
/* 1598 */           String healthMessage = new String();
/* 1599 */           healthMessage = String.format("Fireballs extinguished.", new Object[0]);
/* 1600 */           par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText(healthMessage));
/*      */         } 
/* 1602 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1604 */           var2.stackSize--;
/* 1605 */           if (var2.stackSize <= 0)
/*      */           {
/* 1607 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1610 */         return true;
/*      */       } 
/*      */       
/* 1613 */       if (var2 != null && var2.getItem() == Items.flint_and_steel && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) {
/*      */         
/* 1615 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1617 */           playTameEffect(true);
/* 1618 */           this.worldObj.setEntityState((Entity)this, (byte)6);
/* 1619 */           setThePrinceTeenFire(1);
/* 1620 */           String healthMessage = new String();
/* 1621 */           healthMessage = String.format("Fireballs lit!", new Object[0]);
/* 1622 */           par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText(healthMessage));
/*      */         } 
/* 1624 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1626 */           var2.stackSize--;
/* 1627 */           if (var2.stackSize <= 0)
/*      */           {
/* 1629 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1632 */         return true;
/*      */       } 
/*      */ 
/*      */       
/* 1636 */       if (var2 != null && var2.getItem() == Items.diamond && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D && !this.worldObj.isRemote) {
/*      */ 
/*      */ 
/*      */         
/* 1640 */         Entity ent = null;
/* 1641 */         ThePrince d = null;
/* 1642 */         ent = spawnCreature(this.worldObj, "The Prince", this.posX, this.posY, this.posZ);
/* 1643 */         if (ent != null) {
/* 1644 */           d = (ThePrince)ent;
/* 1645 */           if (isTamed()) {
/* 1646 */             d.setTamed(true);
/* 1647 */             d.func_152115_b(par1EntityPlayer.getUniqueID().toString());
/* 1648 */             d.set_ok_to_grow();
/*      */           } 
/* 1650 */           setDead();
/*      */         } 
/* 1652 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1654 */           var2.stackSize--;
/* 1655 */           if (var2.stackSize <= 0)
/*      */           {
/* 1657 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1660 */         return true;
/*      */       } 
/*      */       
/* 1663 */       if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */         
/* 1665 */         setCustomNameTag(var2.getDisplayName());
/* 1666 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1668 */           var2.stackSize--;
/* 1669 */           if (var2.stackSize <= 0)
/*      */           {
/* 1671 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1674 */         return true;
/*      */       } 
/*      */       
/* 1677 */       if (var2 != null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*      */         
/* 1679 */         if (!isSitting()) {
/* 1680 */           setSitting(true);
/* 1681 */           setActivity(0);
/*      */         } else {
/* 1683 */           setSitting(false);
/* 1684 */           setActivity(0);
/*      */         } 
/* 1686 */         return true;
/*      */       } 
/*      */     } 
/*      */     
/* 1690 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWheat(ItemStack par1ItemStack) {
/* 1698 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.beef);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAttacking() {
/* 1704 */     return this.dataWatcher.getWatchableObjectInt(20);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAttacking(int par1) {
/* 1709 */     if (this.worldObj != null && this.worldObj.isRemote)
/* 1710 */       return;  this.dataWatcher.updateObject(20, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */   
/*      */   public int getActivity() {
/* 1715 */     return this.dataWatcher.getWatchableObjectInt(21);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setActivity(int par1) {
/* 1720 */     if (this.worldObj != null && this.worldObj.isRemote)
/* 1721 */       return;  this.dataWatcher.updateObject(21, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getThePrinceTeenFire() {
/* 1727 */     return this.dataWatcher.getWatchableObjectInt(24);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setThePrinceTeenFire(int par1) {
/* 1733 */     if (this.worldObj.isRemote)
/* 1734 */       return;  this.dataWatcher.updateObject(24, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 1743 */     Entity var8 = null;
/*      */ 
/*      */     
/* 1746 */     var8 = EntityList.createEntityByName(par1, par0World);
/*      */     
/* 1748 */     if (var8 != null) {
/*      */ 
/*      */       
/* 1751 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*      */ 
/*      */       
/* 1754 */       par0World.spawnEntityInWorld(var8);
/*      */       
/* 1756 */       ((EntityLiving)var8).playLivingSound();
/*      */     } 
/*      */     
/* 1759 */     return var8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 1767 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canDespawn() {
/* 1775 */     if (isNoDespawnRequired()) return false; 
/* 1776 */     if (this.riddenByEntity != null) {
/* 1777 */       return false;
/*      */     }
/* 1779 */     if (isTamed()) {
/* 1780 */       return false;
/*      */     }
/* 1782 */     return true;
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
/* 1793 */     super.writeEntityToNBT(par1NBTTagCompound);
/*      */     
/* 1795 */     par1NBTTagCompound.setInteger("ThePrinceTeenAttacking", getAttacking());
/* 1796 */     par1NBTTagCompound.setInteger("ThePrinceTeenActivity", getActivity());
/* 1797 */     par1NBTTagCompound.setInteger("ThePrinceTeenFire", getThePrinceTeenFire());
/* 1798 */     par1NBTTagCompound.setInteger("SpyroKill", this.kill_count);
/* 1799 */     par1NBTTagCompound.setInteger("SpyroDay", this.day_count);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 1809 */     super.readEntityFromNBT(par1NBTTagCompound);
/*      */     
/* 1811 */     setAttacking(par1NBTTagCompound.getInteger("ThePrinceTeenAttacking"));
/* 1812 */     setActivity(par1NBTTagCompound.getInteger("ThePrinceTeenActivity"));
/* 1813 */     setThePrinceTeenFire(par1NBTTagCompound.getInteger("ThePrinceTeenFire"));
/* 1814 */     this.kill_count = par1NBTTagCompound.getInteger("SpyroKill");
/* 1815 */     this.day_count = par1NBTTagCompound.getInteger("SpyroDay");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void shoot_something(double x, double y, double z) {
/* 1821 */     double rr = 0.0D;
/* 1822 */     double rhdir = 0.0D;
/* 1823 */     double rdd = 0.0D;
/* 1824 */     double pi = 3.1415926545D;
/*      */     
/* 1826 */     int which = this.worldObj.rand.nextInt(3);
/*      */ 
/*      */ 
/*      */     
/* 1830 */     if (which == 0) {
/*      */ 
/*      */       
/* 1833 */       rr = Math.atan2(z - this.posZ, x - this.posX);
/* 1834 */       rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */       
/* 1836 */       rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/* 1837 */       if (rdd > pi) rdd -= pi * 2.0D; 
/* 1838 */       rdd = Math.abs(rdd);
/*      */       
/* 1840 */       if (rdd < 0.5D) {
/* 1841 */         firecanon(x, y, z);
/*      */       }
/* 1843 */     } else if (which == 1) {
/*      */ 
/*      */ 
/*      */       
/* 1847 */       rr = Math.atan2(z - this.posZ, x - this.posX);
/* 1848 */       rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */       
/* 1850 */       rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/* 1851 */       if (rdd > pi) rdd -= pi * 2.0D; 
/* 1852 */       rdd = Math.abs(rdd);
/*      */       
/* 1854 */       if (rdd < 0.5D) {
/* 1855 */         firecanonl(x, y, z);
/*      */       
/*      */       }
/*      */     }
/*      */     else {
/*      */       
/* 1861 */       rr = Math.atan2(z - this.posZ, x - this.posX);
/* 1862 */       rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */       
/* 1864 */       rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/* 1865 */       if (rdd > pi) rdd -= pi * 2.0D; 
/* 1866 */       rdd = Math.abs(rdd);
/*      */       
/* 1868 */       if (rdd < 0.5D) {
/* 1869 */         firecanoni(x, y, z);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void firecanon(double x, double y, double z) {
/* 1877 */     double yoff = 3.5D;
/* 1878 */     double xzoff = 6.0D;
/*      */ 
/*      */     
/* 1881 */     BetterFireball bf = null;
/*      */     
/* 1883 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1884 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/* 1885 */     float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1886 */     float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1887 */     float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1888 */     bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, x - cx + r1, y + 0.25D - this.posY + yoff + r2, z - cz + r3);
/* 1889 */     bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 1890 */     bf.setPosition(cx, this.posY + yoff, cz);
/* 1891 */     bf.setBig();
/* 1892 */     this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1893 */     this.worldObj.spawnEntityInWorld((Entity)bf);
/*      */   }
/*      */ 
/*      */   
/*      */   private void firecanonl(double x, double y, double z) {
/* 1898 */     double yoff = 3.5D;
/* 1899 */     double xzoff = 6.0D;
/*      */ 
/*      */ 
/*      */     
/* 1903 */     double var3 = 0.0D;
/* 1904 */     double var5 = 0.0D;
/* 1905 */     double var7 = 0.0D;
/* 1906 */     float var9 = 0.0F;
/* 1907 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1908 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*      */     
/* 1910 */     this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*      */     
/* 1912 */     float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1913 */     float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1914 */     float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1915 */     ThunderBolt lb = new ThunderBolt(this.worldObj, cx, this.posY + yoff, cz);
/* 1916 */     lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0F, 0.0F);
/* 1917 */     var3 = x - lb.posX;
/* 1918 */     var5 = y + 0.25D - lb.posY;
/* 1919 */     var7 = z - lb.posZ;
/* 1920 */     var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 1921 */     lb.setThrowableHeading(var3, var5 + var9, var7, 1.4F, 4.0F);
/* 1922 */     lb.motionX *= 3.0D;
/* 1923 */     lb.motionY *= 3.0D;
/* 1924 */     lb.motionZ *= 3.0D;
/* 1925 */     this.worldObj.spawnEntityInWorld((Entity)lb);
/*      */   }
/*      */ 
/*      */   
/*      */   private void firecanoni(double x, double y, double z) {
/* 1930 */     double yoff = 3.5D;
/* 1931 */     double xzoff = 6.0D;
/*      */ 
/*      */ 
/*      */     
/* 1935 */     double var3 = 0.0D;
/* 1936 */     double var5 = 0.0D;
/* 1937 */     double var7 = 0.0D;
/* 1938 */     float var9 = 0.0F;
/* 1939 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1940 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*      */     
/* 1942 */     this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*      */     
/* 1944 */     float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1945 */     float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1946 */     float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/* 1947 */     IceBall lb = new IceBall(this.worldObj, cx, this.posY + yoff, cz);
/* 1948 */     lb.setIceMaker(1);
/* 1949 */     lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0F, 0.0F);
/* 1950 */     var3 = x - lb.posX;
/* 1951 */     var5 = y + 0.25D - lb.posY;
/* 1952 */     var7 = z - lb.posZ;
/* 1953 */     var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 1954 */     lb.setThrowableHeading(var3, var5 + var9, var7, 1.4F, 4.0F);
/* 1955 */     lb.motionX *= 3.0D;
/* 1956 */     lb.motionY *= 3.0D;
/* 1957 */     lb.motionZ *= 3.0D;
/* 1958 */     this.worldObj.spawnEntityInWorld((Entity)lb);
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ThePrinceTeen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */