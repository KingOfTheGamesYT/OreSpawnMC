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
/*      */ import net.minecraft.entity.projectile.EntitySmallFireball;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
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
/*      */ public class Dragon
/*      */   extends EntityTameable
/*      */ {
/*      */   private int boatPosRotationIncrements;
/*      */   private double boatX;
/*      */   private double boatY;
/*      */   private double boatZ;
/*      */   private double boatYaw;
/*      */   private double boatPitch;
/*      */   private double boatYawHead;
/*   81 */   private int updateit = 1;
/*   82 */   private int color = 1;
/*   83 */   private int playing = 0;
/*   84 */   private GenericTargetSorter TargetSorter = null;
/*   85 */   private RenderInfo renderdata = new RenderInfo();
/*   86 */   private int hurt_timer = 0;
/*   87 */   private int wing_sound = 0;
/*   88 */   private ChunkCoordinates currentFlightTarget = null;
/*      */   private boolean target_in_sight = false;
/*   90 */   private int owner_flying = 0;
/*   91 */   private int flyaway = 0;
/*   92 */   private int stuck_count = 0;
/*   93 */   private int lastX = 0;
/*   94 */   private int lastZ = 0;
/*   95 */   private int unstick_timer = 0;
/*   96 */   private int fireballticker = 0;
/*   97 */   private float moveSpeed = 0.32F;
/*   98 */   private float deltasmooth = 0.0F;
/*   99 */   private int dragontype = 0;
/*      */   private int closest;
/*      */   private int tx;
/*      */   private int ty;
/*      */   private int tz; public Dragon(World par1World, double par2, double par4, double par6) { this(par1World); setPosition(par2, par4 + this.yOffset, par6); this.motionX = 0.0D; this.motionY = 0.0D; this.motionZ = 0.0D; this.prevPosX = par2; this.prevPosY = par4; this.prevPosZ = par6; } protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*      */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*      */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  106 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(35.0D); } public boolean shouldRiderSit() { return true; } public int getTrackingRange() { return 128; } public Dragon(World par1World) { super(par1World);
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
/*  267 */     this.closest = 99999;
/*  268 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(1.5F, 1.25F); getNavigator().setAvoidsWater(true); this.experienceValue = 100; this.fireResistance = 1000; this.isImmuneToFire = true; setSitting(false); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, new MyEntityAIFollowOwner(this, 1.1F, 12.0F, 2.0F)); this.tasks.addTask(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.beef, false)); this.tasks.addTask(3, new MyEntityAIWander((EntityCreature)this, 0.75F)); this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 9.0F)); this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.tasks.addTask(6, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this)); if (OreSpawnMain.PlayNicely == 0)
/*      */       this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityLiving.class, 0, true, false, IMob.mobSelector));  this.targetTasks.addTask(2, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false)); this.riddenByEntity = null; this.TargetSorter = new GenericTargetSorter((Entity)this); this.renderdata = new RenderInfo(); }
/*      */   public int getUpdateFrequency() { return 10; }
/*  271 */   public boolean sendsVelocityUpdates() { return true; } protected void fall(float par1) {} protected void updateFallState(double par1, boolean par3) {} private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*      */ 
/*      */     
/*      */     int i;
/*      */     
/*  276 */     for (i = -dy; i <= dy; i++) {
/*  277 */       for (int j = -dz; j <= dz; j++) {
/*  278 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/*  279 */         if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
/*  280 */           int d = dx * dx + j * j + i * i;
/*  281 */           if (d < this.closest) {
/*  282 */             this.closest = d;
/*  283 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/*  284 */             found++;
/*      */           } 
/*      */         } 
/*  287 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/*  288 */         if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
/*  289 */           int d = dx * dx + j * j + i * i;
/*  290 */           if (d < this.closest) {
/*  291 */             this.closest = d;
/*  292 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/*  293 */             found++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  299 */     for (i = -dx; i <= dx; i++) {
/*  300 */       for (int j = -dz; j <= dz; j++) {
/*  301 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/*  302 */         if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
/*  303 */           int d = dy * dy + j * j + i * i;
/*  304 */           if (d < this.closest) {
/*  305 */             this.closest = d;
/*  306 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/*  307 */             found++;
/*      */           } 
/*      */         } 
/*  310 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/*  311 */         if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
/*  312 */           int d = dy * dy + j * j + i * i;
/*  313 */           if (d < this.closest) {
/*  314 */             this.closest = d;
/*  315 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/*  316 */             found++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  322 */     for (i = -dx; i <= dx; i++) {
/*  323 */       for (int j = -dy; j <= dy; j++) {
/*  324 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/*  325 */         if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
/*  326 */           int d = dz * dz + j * j + i * i;
/*  327 */           if (d < this.closest) {
/*  328 */             this.closest = d;
/*  329 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/*  330 */             found++;
/*      */           } 
/*      */         } 
/*  333 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/*  334 */         if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
/*  335 */           int d = dz * dz + j * j + i * i;
/*  336 */           if (d < this.closest) {
/*  337 */             this.closest = d;
/*  338 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/*  339 */             found++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  345 */     if (found != 0) return true; 
/*  346 */     return false; } protected boolean canTriggerWalking() { return true; } protected void entityInit() { super.entityInit(); this.dataWatcher.addObject(20, Byte.valueOf((byte)0)); this.dataWatcher.addObject(21, Byte.valueOf((byte)0)); this.dataWatcher.addObject(22, Integer.valueOf(0)); this.dataWatcher.addObject(24, Integer.valueOf(1)); setActivity(0); setAttacking(0); setTamed(false); if (this.renderdata == null) this.renderdata = new RenderInfo();  this.renderdata.rf1 = 0.0F; this.renderdata.rf2 = 0.0F; this.renderdata.rf3 = 0.0F; this.renderdata.rf4 = 0.0F; this.renderdata.ri1 = 0; this.renderdata.ri2 = 0; this.renderdata.ri3 = 0; this.renderdata.ri4 = 0; } public int mygetMaxHealth() { return 200; } public int getDragonHealth() { return (int)getHealth(); }
/*      */   public RenderInfo getRenderInfo() { return this.renderdata; }
/*      */   public void setRenderInfo(RenderInfo r) { this.renderdata.rf1 = r.rf1; this.renderdata.rf2 = r.rf2; this.renderdata.rf3 = r.rf3; this.renderdata.rf4 = r.rf4; this.renderdata.ri1 = r.ri1; this.renderdata.ri2 = r.ri2; this.renderdata.ri3 = r.ri3; this.renderdata.ri4 = r.ri4; }
/*      */   public int getTotalArmorValue() { return 14; }
/*      */   protected void jump() { super.jump(); this.motionY += 0.25D; }
/*      */   public boolean isAIEnabled() { return true; }
/*  352 */   public boolean canBreatheUnderwater() { return true; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLivingSound() {
/*  360 */     if (isSitting())
/*      */     {
/*  362 */       return null;
/*      */     }
/*  364 */     if (getAttacking() == 1 && this.riddenByEntity == null) {
/*  365 */       return "orespawn:roar";
/*      */     }
/*      */     
/*  368 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getHurtSound() {
/*  376 */     return "orespawn:alo_hurt";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDeathSound() {
/*  384 */     return "orespawn:alo_death";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundVolume() {
/*  391 */     return 0.6F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getSoundPitch() {
/*  398 */     return 0.75F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBePushed() {
/*  407 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getMountedYOffset() {
/*  415 */     return 1.3D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/*  423 */     return Items.beef;
/*      */   }
/*      */ 
/*      */   
/*      */   private ItemStack dropItemRand(Item index, int par1) {
/*  428 */     EntityItem var3 = null;
/*  429 */     ItemStack is = new ItemStack(index, par1, 0);
/*      */     
/*  431 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), is);
/*      */     
/*  433 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/*  434 */     return is;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/*  442 */     int i = 1 + this.worldObj.rand.nextInt(6);
/*  443 */     for (int var4 = 0; var4 < i; var4++) {
/*  444 */       dropItemRand(Items.beef, 1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  455 */     double ks = 1.75D;
/*  456 */     double inair = 0.1D;
/*  457 */     float iskraken = 1.0F;
/*  458 */     if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*      */       
/*  460 */       if (par1Entity instanceof Kraken) iskraken = 2.0F; 
/*  461 */       par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), iskraken * 35.0F);
/*      */       
/*  463 */       float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/*  464 */       if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/*  465 */       par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*      */     } 
/*  467 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  475 */     boolean ret = false;
/*  476 */     Entity e = null;
/*      */     
/*  478 */     if (this.hurt_timer > 0) return false;
/*      */     
/*  480 */     if (par1DamageSource.getDamageType().equals("cactus")) {
/*  481 */       return ret;
/*      */     }
/*  483 */     if (par1DamageSource.getDamageType().equals("inFire")) {
/*  484 */       return ret;
/*      */     }
/*  486 */     if (par1DamageSource.getDamageType().equals("onFire")) {
/*  487 */       return ret;
/*      */     }
/*  489 */     if (par1DamageSource.getDamageType().equals("lava")) {
/*  490 */       return ret;
/*      */     }
/*  492 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/*  493 */       return ret;
/*      */     }
/*      */     
/*  496 */     setSitting(false);
/*  497 */     setActivity(1);
/*      */     
/*  499 */     e = par1DamageSource.getEntity();
/*      */ 
/*      */     
/*  502 */     if (e != null && e instanceof BetterFireball && this.dragontype == 0) {
/*      */       
/*  504 */       e.setDead();
/*  505 */       return ret;
/*      */     } 
/*  507 */     if (e != null && e instanceof IceBall && this.dragontype != 0) {
/*      */       
/*  509 */       e.setDead();
/*  510 */       return ret;
/*      */     } 
/*  512 */     if (e != null && e instanceof WaterBall && this.dragontype != 0) {
/*      */       
/*  514 */       e.setDead();
/*  515 */       return ret;
/*      */     } 
/*  517 */     if (e != null && e instanceof EntitySmallFireball && this.dragontype == 0) {
/*      */       
/*  519 */       e.setDead();
/*  520 */       return ret;
/*      */     } 
/*  522 */     if (e != null && e instanceof Dragon) {
/*  523 */       return false;
/*      */     }
/*  525 */     if (e != null && e instanceof Spyro) {
/*  526 */       return false;
/*      */     }
/*      */     
/*  529 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*  530 */     this.hurt_timer = 20;
/*      */     
/*  532 */     if (e != null && e instanceof EntityLivingBase) {
/*      */       
/*  534 */       if (isTamed() && 
/*  535 */         e instanceof EntityPlayer) {
/*  536 */         return false;
/*      */       }
/*      */ 
/*      */       
/*  540 */       setAttackTarget((EntityLivingBase)e);
/*  541 */       setTarget(e);
/*  542 */       getNavigator().tryMoveToEntityLiving(e, 1.2D);
/*  543 */       ret = true;
/*      */     } 
/*      */     
/*  546 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateAITasks() {
/*  552 */     EntityLivingBase e = null;
/*  553 */     super.updateAITasks();
/*      */ 
/*      */     
/*  556 */     if (!isSitting() && getActivity() == 0 && this.riddenByEntity == null && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(10) == 1) {
/*      */       
/*  558 */       e = findSomethingToAttack();
/*  559 */       if (e != null)
/*      */       {
/*      */         
/*  562 */         setActivity(1);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void always_do() {
/*  569 */     EntityPlayer p = null;
/*      */ 
/*      */     
/*  572 */     if (this.worldObj.rand.nextInt(250) == 1 && 
/*  573 */       getHealth() < mygetMaxHealth())
/*      */     {
/*  575 */       heal(2.0F);
/*      */     }
/*      */ 
/*      */     
/*  579 */     if (isSitting())
/*      */       return; 
/*  581 */     this.owner_flying = 0;
/*  582 */     if (isTamed() && getOwner() != null && this.riddenByEntity == null && !isSitting()) {
/*  583 */       p = (EntityPlayer)getOwner();
/*      */       
/*  585 */       if (p.capabilities.isFlying) {
/*  586 */         this.owner_flying = 1;
/*      */         
/*  588 */         setActivity(1);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  593 */     if (isTamed() && getOwner() != null && !isSitting()) {
/*  594 */       p = (EntityPlayer)getOwner();
/*      */       
/*  596 */       if (getDistanceSqToEntity((Entity)p) > 400.0D)
/*      */       {
/*  598 */         setActivity(1);
/*      */       }
/*      */     } 
/*      */     
/*  602 */     if (this.worldObj.rand.nextInt(50) == 1 && !isSitting())
/*      */     {
/*  604 */       if (!this.target_in_sight && this.riddenByEntity == null)
/*      */       {
/*  606 */         if (this.worldObj.rand.nextInt(15) == 1) {
/*      */           
/*  608 */           setActivity(1);
/*      */         } else {
/*      */           
/*  611 */           setActivity(0);
/*      */         } 
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*  617 */     if (this.worldObj.rand.nextInt(25) == 0 && !this.target_in_sight && this.riddenByEntity == null) {
/*      */ 
/*      */ 
/*      */       
/*  621 */       this.closest = 99999;
/*  622 */       this.tx = this.ty = this.tz = 0;
/*  623 */       for (int i = 1; i < 11; i++) {
/*  624 */         int j = i;
/*  625 */         if (j > 4) j = 4; 
/*  626 */         if (scan_it((int)this.posX, (int)this.posY - 1, (int)this.posZ, i, j, i) == true)
/*  627 */           break;  if (i >= 6) i++;
/*      */       
/*      */       } 
/*  630 */       if (this.closest < 99999) {
/*      */         
/*  632 */         setActivity(0);
/*  633 */         getNavigator().tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.0D);
/*  634 */         if (handleLavaMovement()) {
/*  635 */           heal(1.0F);
/*  636 */           playSound("splash", 1.0F, this.worldObj.rand.nextFloat() * 0.2F + 0.9F);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void fly_with_rider() {
/*  644 */     EntityLivingBase e = null;
/*  645 */     int freq = 7;
/*      */ 
/*      */     
/*  648 */     if (this.isDead)
/*      */       return; 
/*  650 */     if (isSitting())
/*  651 */       return;  if (this.worldObj.isRemote)
/*      */       return; 
/*  653 */     if (this.worldObj.rand.nextInt(freq) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
/*      */       
/*  655 */       if (this.worldObj.rand.nextInt(250) == 0) {
/*  656 */         setAttackTarget(null);
/*      */       }
/*  658 */       e = getAttackTarget();
/*  659 */       if (e != null && !e.isEntityAlive()) {
/*  660 */         setAttackTarget(null);
/*  661 */         e = null;
/*      */       } 
/*  663 */       if (e == null) {
/*  664 */         e = findSomethingToAttack();
/*      */       }
/*      */       
/*  667 */       if (e != null) {
/*      */ 
/*      */         
/*  670 */         setAttacking(1);
/*      */         
/*  672 */         if (getDistanceSqToEntity((Entity)e) < ((7.0F + e.width / 2.0F) * (7.0F + e.width / 2.0F)))
/*      */         {
/*  674 */           attackEntityAsMob((Entity)e);
/*      */         }
/*      */         
/*      */         return;
/*      */       } 
/*  679 */       setAttacking(0);
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
/*      */   
/*      */   protected void updateAITick() {
/*  692 */     if (this.riddenByEntity != null)
/*  693 */       return;  super.updateAITick();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/*  701 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*      */     
/*  703 */     if (par1EntityLiving == null)
/*      */     {
/*  705 */       return false;
/*      */     }
/*  707 */     if (par1EntityLiving == this)
/*      */     {
/*  709 */       return false;
/*      */     }
/*  711 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/*      */       
/*  714 */       return false;
/*      */     }
/*  716 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*      */       
/*  719 */       return false;
/*      */     }
/*  721 */     if (par1EntityLiving instanceof LurkingTerror)
/*      */     {
/*  723 */       return false;
/*      */     }
/*  725 */     if (par1EntityLiving instanceof EnderReaper)
/*      */     {
/*  727 */       return false;
/*      */     }
/*  729 */     if (par1EntityLiving instanceof TerribleTerror)
/*      */     {
/*  731 */       return false;
/*      */     }
/*  733 */     if (par1EntityLiving instanceof LeafMonster)
/*      */     {
/*  735 */       return false;
/*      */     }
/*  737 */     if (par1EntityLiving instanceof CreepingHorror)
/*      */     {
/*  739 */       return false;
/*      */     }
/*  741 */     if (par1EntityLiving instanceof Triffid)
/*      */     {
/*  743 */       return false;
/*      */     }
/*  745 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityMob)
/*      */     {
/*  747 */       return true;
/*      */     }
/*  749 */     if (par1EntityLiving instanceof Mothra)
/*      */     {
/*      */       
/*  752 */       return true;
/*      */     }
/*  754 */     if (par1EntityLiving instanceof Kraken)
/*      */     {
/*      */       
/*  757 */       return true;
/*      */     }
/*  759 */     if (par1EntityLiving instanceof EntityPlayer)
/*      */     {
/*  761 */       return false;
/*      */     }
/*      */     
/*  764 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private EntityLivingBase findSomethingToAttack() {
/*  769 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/*  770 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(20.0D, 20.0D, 20.0D));
/*  771 */     Collections.sort(var5, this.TargetSorter);
/*  772 */     Iterator<?> var2 = var5.iterator();
/*  773 */     Entity var3 = null;
/*  774 */     EntityLivingBase var4 = null;
/*      */     
/*  776 */     while (var2.hasNext()) {
/*      */       
/*  778 */       var3 = (Entity)var2.next();
/*  779 */       var4 = (EntityLivingBase)var3;
/*      */       
/*  781 */       if (isSuitableTarget(var4, false))
/*      */       {
/*  783 */         return var4;
/*      */       }
/*      */     } 
/*  786 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean doesEntityNotTriggerPressurePlate() {
/*  793 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanSpawnHere() {
/*  801 */     Dragon target = null;
/*  802 */     if (!this.worldObj.isDaytime()) return false; 
/*  803 */     target = (Dragon)this.worldObj.findNearestEntityWithinAABB(Dragon.class, this.boundingBox.expand(16.0D, 6.0D, 16.0D), (Entity)this);
/*  804 */     if (target != null)
/*      */     {
/*  806 */       return false;
/*      */     }
/*  808 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) return true; 
/*  809 */     if (this.posY < 50.0D) return false; 
/*  810 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/*  818 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
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
/*  830 */     super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
/*  831 */     this.boatPosRotationIncrements = par9;
/*      */ 
/*      */     
/*  834 */     this.boatX = par1;
/*  835 */     this.boatY = par3;
/*  836 */     this.boatZ = par5;
/*  837 */     this.boatYaw = par7;
/*  838 */     this.boatPitch = par8;
/*  839 */     this.boatYawHead = par7;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void setVelocity(double par1, double par3, double par5) {
/*  849 */     super.setVelocity(par1, par3, par5);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate() {
/*  855 */     EntityLivingBase e = null;
/*  856 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  857 */     super.onUpdate();
/*      */     
/*  859 */     if (this.hurt_timer > 0) this.hurt_timer--;
/*      */     
/*  861 */     if (getActivity() == 1) {
/*  862 */       this.wing_sound++;
/*  863 */       if (this.wing_sound > 20) {
/*      */         
/*  865 */         if (!this.worldObj.isRemote) this.worldObj.playSoundAtEntity((Entity)this, "orespawn:MothraWings", 0.5F, 1.0F); 
/*  866 */         this.wing_sound = 0;
/*      */       } 
/*      */     } 
/*      */     
/*  870 */     if (isInWater()) {
/*  871 */       this.motionY += 0.07D;
/*      */     }
/*      */     
/*  874 */     if (this.worldObj.isRemote)
/*      */       return; 
/*  876 */     if (getActivity() == 0 && isTamed() && getOwner() != null && !isSitting()) {
/*  877 */       e = getOwner();
/*      */       
/*  879 */       if (getDistanceSqToEntity((Entity)e) > 144.0D)
/*      */       {
/*  881 */         setActivity(1);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void fly_without_rider() {
/*  889 */     int xdir = 1;
/*  890 */     int zdir = 1;
/*      */     
/*  892 */     int keep_trying = 50;
/*      */ 
/*      */     
/*  895 */     int do_new = 0;
/*  896 */     double ox = 0.0D, oy = 0.0D, oz = 0.0D;
/*      */     
/*  898 */     int has_owner = 0;
/*  899 */     EntityLivingBase e = null;
/*  900 */     double speed_factor = 0.5D;
/*  901 */     double var1 = 0.0D;
/*  902 */     double var3 = 0.0D;
/*  903 */     double var5 = 0.0D;
/*  904 */     double yoff = 1.25D;
/*  905 */     double xzoff = 2.25D;
/*      */ 
/*      */ 
/*      */     
/*  909 */     double gh = 1.25D;
/*  910 */     double obstruction_factor = 0.0D;
/*  911 */     double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*  912 */     EntitySmallFireball sf = null;
/*  913 */     BetterFireball bf = null;
/*  914 */     IceBall ib = null;
/*  915 */     WaterBall wb = null;
/*  916 */     int toofar = 0;
/*      */ 
/*      */     
/*  919 */     if (this.currentFlightTarget == null) {
/*  920 */       do_new = 1;
/*  921 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*      */     } 
/*      */     
/*  924 */     if (isSitting())
/*  925 */       return;  if (this.riddenByEntity != null)
/*      */       return; 
/*  927 */     if (this.unstick_timer > 0) this.unstick_timer--; 
/*  928 */     if (this.lastX == (int)this.posX && this.lastZ == (int)this.posZ) {
/*      */       
/*  930 */       this.stuck_count++;
/*  931 */       if (this.stuck_count > 50) {
/*  932 */         this.stuck_count = 0;
/*  933 */         this.unstick_timer = 100;
/*  934 */         this.target_in_sight = false;
/*  935 */         setAttacking(0);
/*  936 */         do_new = 1;
/*      */       } 
/*      */     } else {
/*  939 */       this.stuck_count = 0;
/*  940 */       this.lastX = (int)this.posX;
/*  941 */       this.lastZ = (int)this.posZ;
/*      */     } 
/*      */     
/*  944 */     if (this.posY < this.currentFlightTarget.posY + 2.0D) {
/*  945 */       this.motionY *= 0.7D;
/*  946 */     } else if (this.posY > this.currentFlightTarget.posY - 2.0D) {
/*  947 */       this.motionY *= 0.5D;
/*      */     } else {
/*  949 */       this.motionY *= 0.61D;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  954 */     if (this.worldObj.rand.nextInt(300) == 1) do_new = 1;
/*      */ 
/*      */     
/*  957 */     if (isTamed() && getOwner() != null) {
/*  958 */       e = getOwner();
/*  959 */       has_owner = 1;
/*  960 */       ox = e.posX;
/*  961 */       oy = e.posY;
/*  962 */       oz = e.posZ;
/*  963 */       if (getDistanceSqToEntity((Entity)e) > 144.0D) {
/*  964 */         toofar = 1;
/*  965 */         this.target_in_sight = false;
/*  966 */         setAttacking(0);
/*  967 */         this.flyaway = 0;
/*  968 */         do_new = 1;
/*      */       } 
/*      */     } 
/*      */     
/*  972 */     if (this.flyaway > 0) this.flyaway--;
/*      */ 
/*      */     
/*  975 */     if (toofar == 0 && this.unstick_timer == 0 && this.flyaway == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(9) == 1) {
/*      */ 
/*      */ 
/*      */       
/*  979 */       e = findSomethingToAttack();
/*  980 */       if (e != null) {
/*      */         
/*  982 */         if (isTamed() && getHealth() / mygetMaxHealth() < 0.25F) {
/*  983 */           setActivity(1);
/*  984 */           setAttacking(0);
/*  985 */           this.target_in_sight = false;
/*  986 */           do_new = 0;
/*  987 */           this.currentFlightTarget.set((int)(this.posX + this.posX - e.posX), (int)(this.posY + 1.0D), (int)(this.posZ + this.posZ - e.posZ));
/*      */         } else {
/*      */           
/*  990 */           setActivity(1);
/*  991 */           setAttacking(1);
/*  992 */           this.target_in_sight = true;
/*  993 */           this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0D), (int)e.posZ);
/*      */           
/*  995 */           do_new = 0;
/*  996 */           if (getDistanceSqToEntity((Entity)e) < ((5.0F + e.width / 2.0F) * (5.0F + e.width / 2.0F))) {
/*  997 */             attackEntityAsMob((Entity)e);
/*  998 */             this.flyaway = 5 + this.worldObj.rand.nextInt(10);
/*  999 */             do_new = 1;
/* 1000 */           } else if (getDistanceSqToEntity((Entity)e) < 256.0D && !isInWater()) {
/*      */             
/* 1002 */             if (getDragonFire() >= 1) {
/* 1003 */               double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1004 */               double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*      */               
/* 1006 */               if (this.dragontype == 0) {
/* 1007 */                 if (getDragonFire() == 1) {
/* 1008 */                   sf = new EntitySmallFireball(this.worldObj, (EntityLivingBase)this, e.posX - cx, e.posY + (e.height / 2.0F) - this.posY + yoff, e.posZ - cz);
/* 1009 */                   sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 1010 */                   sf.setPosition(cx, this.posY + yoff, cz);
/* 1011 */                   this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1012 */                   this.worldObj.spawnEntityInWorld((Entity)sf);
/*      */                 } else {
/* 1014 */                   bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, e.posX - cx, e.posY + (e.height / 2.0F) - this.posY + yoff, e.posZ - cz);
/* 1015 */                   bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 1016 */                   bf.setPosition(cx, this.posY + yoff, cz);
/* 1017 */                   this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1018 */                   this.worldObj.spawnEntityInWorld((Entity)bf);
/*      */                 }
/*      */               
/* 1021 */               } else if (getDragonFire() == 1) {
/*      */ 
/*      */ 
/*      */                 
/* 1025 */                 wb = new WaterBall(this.worldObj, e.posX - this.posX, e.posY + (e.height / 2.0F) - this.posY + yoff, e.posZ - this.posZ);
/* 1026 */                 wb.setLocationAndAngles(this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)), this.rotationYawHead, this.rotationPitch);
/* 1027 */                 var3 = e.posX - wb.posX;
/* 1028 */                 var5 = e.posY + 0.25D - wb.posY;
/* 1029 */                 double d = e.posZ - wb.posZ;
/* 1030 */                 float var9 = MathHelper.sqrt_double(var3 * var3 + d * d) * 0.2F;
/* 1031 */                 wb.setThrowableHeading(var3, var5 + var9, d, 1.4F, 5.0F);
/* 1032 */                 this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1033 */                 this.worldObj.spawnEntityInWorld((Entity)wb);
/*      */               } else {
/* 1035 */                 ib = new IceBall(this.worldObj, e.posX - this.posX, e.posY + (e.height / 2.0F) - this.posY + yoff, e.posZ - this.posZ);
/* 1036 */                 ib.setLocationAndAngles(this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)), this.rotationYawHead, this.rotationPitch);
/* 1037 */                 ib.setSpecial();
/* 1038 */                 ib.setIceBall();
/* 1039 */                 var3 = e.posX - ib.posX;
/* 1040 */                 var5 = e.posY + 0.25D - ib.posY;
/* 1041 */                 double d = e.posZ - ib.posZ;
/* 1042 */                 float var9 = MathHelper.sqrt_double(var3 * var3 + d * d) * 0.2F;
/* 1043 */                 ib.setThrowableHeading(var3, var5 + var9, d, 1.4F, 5.0F);
/* 1044 */                 this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1045 */                 this.worldObj.spawnEntityInWorld((Entity)ib);
/*      */               }
/*      */             
/*      */             }
/*      */           
/*      */           } 
/*      */         } 
/*      */       } else {
/*      */         
/* 1054 */         this.target_in_sight = false;
/* 1055 */         this.flyaway = 0;
/* 1056 */         setAttacking(0);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1061 */     if (this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/* 1062 */       do_new = 1;
/*      */     }
/*      */ 
/*      */     
/* 1066 */     if ((do_new != 0 && !this.target_in_sight) || (do_new != 0 && this.flyaway != 0)) {
/*      */       
/* 1068 */       Block bid = Blocks.stone;
/* 1069 */       while (bid != Blocks.air && keep_trying != 0) {
/* 1070 */         int gox = (int)this.posX;
/* 1071 */         int goy = (int)this.posY;
/* 1072 */         int goz = (int)this.posZ;
/* 1073 */         if (has_owner == 1 && this.unstick_timer == 0) {
/* 1074 */           gox = (int)ox;
/* 1075 */           goy = (int)oy;
/* 1076 */           goz = (int)oz;
/* 1077 */           if (this.owner_flying == 0) {
/* 1078 */             zdir = this.worldObj.rand.nextInt(10) + 4;
/* 1079 */             xdir = this.worldObj.rand.nextInt(10) + 4;
/*      */           } else {
/* 1081 */             zdir = this.worldObj.rand.nextInt(6);
/* 1082 */             xdir = this.worldObj.rand.nextInt(6);
/*      */           } 
/*      */         } else {
/* 1085 */           zdir = this.worldObj.rand.nextInt(10) + 16;
/* 1086 */           xdir = this.worldObj.rand.nextInt(10) + 16;
/*      */         } 
/* 1088 */         if (this.worldObj.rand.nextInt(2) == 1) zdir = -zdir; 
/* 1089 */         if (this.worldObj.rand.nextInt(2) == 1) xdir = -xdir; 
/* 1090 */         this.currentFlightTarget.set(gox + xdir, goy + this.worldObj.rand.nextInt(9 + this.owner_flying * 2) - 4, goz + zdir);
/* 1091 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 1092 */         if (bid == Blocks.air && 
/* 1093 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 1094 */           bid = Blocks.stone;
/*      */         }
/*      */         
/* 1097 */         keep_trying--;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1105 */     obstruction_factor = 0.0D;
/* 1106 */     int dist = 2;
/* 1107 */     dist += (int)(velocity * 4.0D);
/*      */     
/* 1109 */     for (int k = 1; k < dist; k++) {
/* 1110 */       for (int i = 1; i < dist * 2; i++) {
/* 1111 */         double dx = i * Math.cos(Math.toRadians((this.rotationYaw + 90.0F)));
/* 1112 */         double dz = i * Math.sin(Math.toRadians((this.rotationYaw + 90.0F)));
/* 1113 */         Block bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - k, (int)(this.posZ + dz));
/* 1114 */         if (bid != Blocks.air) {
/* 1115 */           obstruction_factor += 0.05D;
/*      */         }
/*      */       } 
/*      */     } 
/* 1119 */     this.motionY += obstruction_factor * 0.05D;
/* 1120 */     this.posY += obstruction_factor * 0.05D;
/*      */ 
/*      */     
/* 1123 */     speed_factor = 0.5D;
/* 1124 */     var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 1125 */     var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 1126 */     var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 1127 */     if (this.owner_flying != 0) {
/* 1128 */       speed_factor = 1.75D;
/* 1129 */       if (isTamed() && getOwner() != null) {
/* 1130 */         e = getOwner();
/* 1131 */         if (getDistanceSqToEntity((Entity)e) > 49.0D) {
/* 1132 */           speed_factor = 3.5D;
/*      */         }
/*      */       } 
/*      */     } 
/* 1136 */     this.motionX += (Math.signum(var1) - this.motionX) * 0.15D * speed_factor;
/* 1137 */     this.motionY += (Math.signum(var3) - this.motionY) * 0.21D * speed_factor;
/* 1138 */     this.motionZ += (Math.signum(var5) - this.motionZ) * 0.15D * speed_factor;
/* 1139 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 1140 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 1141 */     this.moveForward = (float)(0.75D * speed_factor);
/*      */     
/* 1143 */     this.rotationYaw += var8 / 4.0F;
/* 1144 */     moveEntity(this.motionX, this.motionY, this.motionZ);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onLivingUpdate() {
/* 1154 */     List<Entity> list = null;
/* 1155 */     Entity listEntity = null;
/*      */ 
/*      */ 
/*      */     
/* 1159 */     double d6 = (this.rand.nextFloat() * 2.0F - 1.0F);
/* 1160 */     double d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1166 */     double obstruction_factor = 0.0D;
/*      */     
/* 1168 */     double relative_g = 0.0D;
/*      */     
/* 1170 */     double max_speed = 0.95D;
/* 1171 */     double gh = 1.0D;
/*      */ 
/*      */ 
/*      */     
/* 1175 */     double rt = 0.0D;
/*      */     
/* 1177 */     double pi = 3.1415926545D;
/* 1178 */     double deltav = 0.0D;
/*      */ 
/*      */     
/* 1181 */     int dist = 2;
/*      */     
/* 1183 */     BetterFireball bf = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1189 */     if (getActivity() == 0) {
/*      */       
/* 1191 */       super.onLivingUpdate();
/*      */     
/*      */     }
/* 1194 */     else if (this.isDead) {
/* 1195 */       super.onLivingUpdate();
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1200 */     if (this.isDead) {
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
/* 1213 */     if (this.worldObj.isRemote) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1218 */       if (this.boatPosRotationIncrements > 0 && getActivity() != 0)
/*      */       {
/* 1220 */         double d4 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
/* 1221 */         double d5 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
/* 1222 */         double d11 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
/* 1223 */         setPosition(d4, d5, d11);
/*      */         
/* 1225 */         this.rotationPitch = (float)(this.rotationPitch + (this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
/* 1226 */         double d10 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
/* 1227 */         if (this.riddenByEntity != null) d10 = MathHelper.wrapAngleTo180_double(this.riddenByEntity.rotationYaw - this.rotationYaw); 
/* 1228 */         this.rotationYaw = (float)(this.rotationYaw + d10 / this.boatPosRotationIncrements);
/* 1229 */         setRotation(this.rotationYaw, this.rotationPitch);
/* 1230 */         this.rotationYawHead = this.rotationYaw;
/*      */         
/* 1232 */         this.boatPosRotationIncrements--;
/*      */       
/*      */       }
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1240 */       if (getActivity() != 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1246 */         if (this.fireballticker > 0) this.fireballticker--;
/*      */         
/* 1248 */         if (this.riddenByEntity != null) {
/* 1249 */           EntityPlayer pp = (EntityPlayer)this.riddenByEntity;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1255 */           if (this.motionX < -2.0D) this.motionX = -2.0D; 
/* 1256 */           if (this.motionX > 2.0D) this.motionX = 2.0D; 
/* 1257 */           if (this.motionZ < -2.0D) this.motionZ = -2.0D; 
/* 1258 */           if (this.motionZ > 2.0D) this.motionZ = 2.0D; 
/* 1259 */           double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */ 
/*      */           
/* 1262 */           gh = 1.25D;
/* 1263 */           Block bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh), (int)this.posZ);
/* 1264 */           if (bid != Blocks.air) {
/* 1265 */             this.motionY += 0.03D;
/* 1266 */             this.posY += 0.1D;
/*      */           } else {
/*      */             
/* 1269 */             this.motionY -= 0.018D;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1276 */           obstruction_factor = 0.0D;
/* 1277 */           dist = 3;
/* 1278 */           dist += (int)(velocity * 7.0D);
/*      */           
/* 1280 */           for (int k = 1; k < dist; k++) {
/* 1281 */             for (int i = 1; i < dist * 2; i++) {
/* 1282 */               double dx = i * Math.cos(Math.toRadians((this.rotationYaw + 90.0F)));
/* 1283 */               double dz = i * Math.sin(Math.toRadians((this.rotationYaw + 90.0F)));
/* 1284 */               bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - k, (int)(this.posZ + dz));
/* 1285 */               if (bid != Blocks.air) {
/* 1286 */                 obstruction_factor += 0.05D;
/*      */               }
/*      */             } 
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 1293 */           this.motionY += obstruction_factor * 0.07D;
/* 1294 */           this.posY += obstruction_factor * 0.07D;
/* 1295 */           if (this.motionY > 2.0D) this.motionY = 2.0D;
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
/* 1306 */           double d4 = this.riddenByEntity.rotationYaw;
/* 1307 */           d4 %= 360.0D;
/* 1308 */           for (; d4 < 0.0D; d4 += 360.0D);
/* 1309 */           double d5 = this.rotationYaw;
/* 1310 */           d5 %= 360.0D;
/* 1311 */           for (; d5 < 0.0D; d5 += 360.0D);
/* 1312 */           relative_g = (d4 - d5) % 180.0D;
/* 1313 */           for (; relative_g < 0.0D; relative_g += 180.0D);
/* 1314 */           if (relative_g > 90.0D) relative_g -= 180.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1321 */           if (velocity > 0.01D) {
/*      */             
/* 1323 */             d4 = 1.85D - velocity;
/* 1324 */             d4 = Math.abs(d4);
/* 1325 */             if (d4 < 0.01D) d4 = 0.01D; 
/* 1326 */             if (d4 > 0.9D) d4 = 0.9D; 
/* 1327 */             this.rotationYaw = this.riddenByEntity.rotationYaw + (float)(relative_g * d4);
/*      */           } else {
/*      */             
/* 1330 */             this.rotationYaw = this.riddenByEntity.rotationYaw;
/*      */           } 
/* 1332 */           relative_g = Math.abs(relative_g) * velocity;
/* 1333 */           if (relative_g > 50.0D) relative_g = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1338 */           this.rotationPitch = 2.0F * (float)velocity;
/* 1339 */           setRotation(this.rotationYaw, this.rotationPitch);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1345 */           double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1353 */           double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
/* 1354 */           double rhm = Math.atan2(this.motionZ, this.motionX);
/* 1355 */           double rhdir = Math.toRadians(((this.riddenByEntity.rotationYaw + 90.0F) % 360.0F));
/* 1356 */           rt = 0.0D;
/* 1357 */           pi = 3.1415926545D;
/* 1358 */           deltav = 0.0D;
/* 1359 */           float im = pp.moveForward;
/*      */ 
/*      */           
/* 1362 */           if (OreSpawnMain.flyup_keystate != 0) {
/* 1363 */             this.motionY += 0.03D;
/* 1364 */             this.motionY += velocity * 0.036D;
/*      */           } 
/*      */ 
/*      */           
/* 1368 */           double rdv = Math.abs(rhm - rhdir) % pi * 2.0D;
/* 1369 */           if (rdv > pi) rdv -= pi * 2.0D; 
/* 1370 */           rdv = Math.abs(rdv);
/* 1371 */           if (Math.abs(newvelocity) < 0.01D) rdv = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1379 */           if (rdv > 1.5D) newvelocity = -newvelocity;
/*      */           
/* 1381 */           if (Math.abs(im) > 0.001F) {
/* 1382 */             if (im > 0.0F) {
/* 1383 */               deltav = 0.025D;
/* 1384 */               if (max_speed > 1.0D) deltav += 0.05D; 
/* 1385 */               if (this.deltasmooth < 0.0F) this.deltasmooth = 0.0F; 
/* 1386 */               this.deltasmooth = (float)(this.deltasmooth + deltav / 10.0D);
/* 1387 */               if (this.deltasmooth > deltav) this.deltasmooth = (float)deltav;
/*      */             
/*      */             } else {
/* 1390 */               max_speed = 0.35D;
/*      */               
/* 1392 */               deltav = -0.02D;
/* 1393 */               if (this.deltasmooth > 0.0F) this.deltasmooth = 0.0F; 
/* 1394 */               this.deltasmooth = (float)(this.deltasmooth + deltav / 10.0D);
/* 1395 */               if (this.deltasmooth < deltav) this.deltasmooth = (float)deltav;
/*      */             
/*      */             } 
/* 1398 */             newvelocity += this.deltasmooth;
/* 1399 */             if (newvelocity >= 0.0D) {
/* 1400 */               if (newvelocity > max_speed) newvelocity = max_speed; 
/* 1401 */               this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 1402 */               this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*      */             } else {
/* 1404 */               if (newvelocity < -max_speed) newvelocity = -max_speed; 
/* 1405 */               newvelocity = -newvelocity;
/* 1406 */               this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/* 1407 */               this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/*      */             }
/*      */           
/*      */           }
/* 1411 */           else if (newvelocity >= 0.0D) {
/* 1412 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 1413 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*      */           } else {
/* 1415 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/* 1416 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/*      */           } 
/*      */ 
/*      */           
/* 1420 */           if (this.fireballticker == 0) {
/*      */             
/* 1422 */             double xzoff = 4.0D;
/* 1423 */             double yoff = -0.25D;
/*      */             
/* 1425 */             if (getDragonType() == 0) {
/* 1426 */               if (pp.moveStrafing > 0.001F) {
/* 1427 */                 bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, 0.0D, 0.0D, 0.0D);
/* 1428 */                 bf.setNotMe();
/* 1429 */                 bf.setSmall();
/* 1430 */                 double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1431 */                 double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/* 1432 */                 bf.setPosition(cx, this.posY + yoff, cz);
/* 1433 */                 cx = Math.cos(Math.toRadians((pp.rotationYawHead + 90.0F)));
/* 1434 */                 cz = Math.sin(Math.toRadians((pp.rotationYawHead + 90.0F)));
/* 1435 */                 double cy = -Math.sin(Math.toRadians(pp.rotationPitch));
/*      */                 
/* 1437 */                 double d3 = MathHelper.sqrt_double(cx * cx + cy * cy + cz * cz);
/* 1438 */                 bf.accelerationX = cx / d3 * 0.15D;
/* 1439 */                 bf.accelerationY = cy / d3 * 0.15D;
/* 1440 */                 bf.accelerationZ = cz / d3 * 0.15D;
/* 1441 */                 bf.motionX = this.motionX;
/* 1442 */                 bf.motionY = this.motionY;
/* 1443 */                 bf.motionZ = this.motionZ;
/* 1444 */                 bf.posX -= this.motionX * 9.0D;
/* 1445 */                 bf.posY -= this.motionY * 9.0D;
/* 1446 */                 bf.posZ -= this.motionZ * 9.0D;
/* 1447 */                 this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1448 */                 this.worldObj.spawnEntityInWorld((Entity)bf);
/* 1449 */                 this.fireballticker = 10;
/*      */               } 
/* 1451 */               if (pp.moveStrafing < -0.001F) {
/* 1452 */                 bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, 0.0D, 0.0D, 0.0D);
/* 1453 */                 bf.setNotMe();
/* 1454 */                 double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1455 */                 double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/* 1456 */                 bf.setPosition(cx, this.posY + yoff, cz);
/* 1457 */                 cx = Math.cos(Math.toRadians((pp.rotationYawHead + 90.0F)));
/* 1458 */                 cz = Math.sin(Math.toRadians((pp.rotationYawHead + 90.0F)));
/* 1459 */                 double cy = -Math.sin(Math.toRadians(pp.rotationPitch));
/*      */                 
/* 1461 */                 double d3 = MathHelper.sqrt_double(cx * cx + cy * cy + cz * cz);
/* 1462 */                 bf.accelerationX = cx / d3 * 0.1D;
/* 1463 */                 bf.accelerationY = cy / d3 * 0.1D;
/* 1464 */                 bf.accelerationZ = cz / d3 * 0.1D;
/* 1465 */                 bf.motionX = this.motionX;
/* 1466 */                 bf.motionY = this.motionY;
/* 1467 */                 bf.motionZ = this.motionZ;
/* 1468 */                 bf.posX -= this.motionX * 9.0D;
/* 1469 */                 bf.posY -= this.motionY * 9.0D;
/* 1470 */                 bf.posZ -= this.motionZ * 9.0D;
/* 1471 */                 this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1472 */                 this.worldObj.spawnEntityInWorld((Entity)bf);
/* 1473 */                 this.fireballticker = 20;
/*      */               } 
/*      */             } else {
/* 1476 */               if (pp.moveStrafing > 0.001F) {
/* 1477 */                 double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1478 */                 double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/* 1479 */                 WaterBall var2 = new WaterBall(this.worldObj, cx, this.posY + yoff, cz);
/* 1480 */                 var2.setLocationAndAngles(cx, this.posY + yoff, cz, pp.rotationYaw + 90.0F, pp.rotationPitch);
/* 1481 */                 double var3 = Math.cos(Math.toRadians((pp.rotationYawHead + 90.0F)));
/* 1482 */                 double var5 = -Math.sin(Math.toRadians(pp.rotationPitch));
/* 1483 */                 double var77 = Math.sin(Math.toRadians((pp.rotationYawHead + 90.0F)));
/* 1484 */                 float var9 = MathHelper.sqrt_double(var3 * var3 + var77 * var77) * 0.2F;
/* 1485 */                 var2.setThrowableHeading(var3, var5 + var9, var77, 1.4F, 5.0F);
/* 1486 */                 var2.posX -= this.motionX * 7.0D;
/* 1487 */                 var2.posY -= this.motionY * 7.0D;
/* 1488 */                 var2.posZ -= this.motionZ * 7.0D;
/* 1489 */                 this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1490 */                 this.worldObj.spawnEntityInWorld((Entity)var2);
/* 1491 */                 this.fireballticker = 5;
/*      */               } 
/* 1493 */               if (pp.moveStrafing < -0.001F) {
/* 1494 */                 double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1495 */                 double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/* 1496 */                 IceBall var2 = new IceBall(this.worldObj, cx, this.posY + yoff, cz);
/* 1497 */                 var2.setLocationAndAngles(cx, this.posY + yoff, cz, pp.rotationYaw + 90.0F, pp.rotationPitch);
/* 1498 */                 var2.setSpecial();
/* 1499 */                 var2.setIceBall();
/* 1500 */                 double var3 = Math.cos(Math.toRadians((pp.rotationYaw + 90.0F)));
/* 1501 */                 double var5 = -Math.sin(Math.toRadians(pp.rotationPitch));
/* 1502 */                 double var77 = Math.sin(Math.toRadians((pp.rotationYaw + 90.0F)));
/* 1503 */                 float var9 = MathHelper.sqrt_double(var3 * var3 + var77 * var77) * 0.2F;
/* 1504 */                 var2.setThrowableHeading(var3, var5 + var9, var77, 1.4F, 5.0F);
/* 1505 */                 var2.posX -= this.motionX * 7.0D;
/* 1506 */                 var2.posY -= this.motionY * 7.0D;
/* 1507 */                 var2.posZ -= this.motionZ * 7.0D;
/* 1508 */                 var2.motionX *= 2.0D;
/* 1509 */                 var2.motionY *= 2.0D;
/* 1510 */                 var2.motionZ *= 2.0D;
/* 1511 */                 this.worldObj.playSoundAtEntity((Entity)this, "fireworks.launch", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1512 */                 this.worldObj.spawnEntityInWorld((Entity)var2);
/* 1513 */                 this.fireballticker = 15;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1522 */           moveEntity(this.motionX, this.motionY, this.motionZ);
/*      */ 
/*      */           
/* 1525 */           this.motionX *= 0.985D;
/* 1526 */           this.motionY *= 0.94D;
/* 1527 */           this.motionZ *= 0.985D;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1532 */           if (!this.worldObj.isRemote) {
/*      */             
/* 1534 */             list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(2.25D, 2.0D, 2.25D));
/*      */             
/* 1536 */             if (list != null && !list.isEmpty())
/*      */             {
/* 1538 */               for (int l = 0; l < list.size(); l++) {
/*      */                 
/* 1540 */                 listEntity = list.get(l);
/*      */                 
/* 1542 */                 if (listEntity != this.riddenByEntity && !listEntity.isDead && listEntity.canBePushed())
/*      */                 {
/* 1544 */                   listEntity.applyEntityCollision((Entity)this);
/*      */                 }
/*      */               } 
/*      */             }
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 1552 */           fly_with_rider();
/*      */ 
/*      */           
/* 1555 */           if (this.riddenByEntity.isDead)
/*      */           {
/* 1557 */             this.riddenByEntity = null;
/*      */           }
/*      */         }
/*      */         else {
/*      */           
/* 1562 */           fly_without_rider();
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1568 */       always_do();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateRiderPosition() {
/* 1575 */     if (this.riddenByEntity != null) {
/*      */ 
/*      */ 
/*      */       
/* 1579 */       float f = 0.65F;
/* 1580 */       this.riddenByEntity.setPosition(this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)));
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
/* 1592 */     String s = "heart";
/*      */     
/* 1594 */     if (!par1)
/*      */     {
/* 1596 */       s = "smoke";
/*      */     }
/*      */     
/* 1599 */     for (int i = 0; i < 20; i++) {
/*      */       
/* 1601 */       double d0 = this.rand.nextGaussian() * 0.08D;
/* 1602 */       double d1 = this.rand.nextGaussian() * 0.08D;
/* 1603 */       double d2 = this.rand.nextGaussian() * 0.08D;
/* 1604 */       this.worldObj.spawnParticle(s, this.posX + ((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5F), this.posY + 0.5D + this.rand.nextFloat() * 1.5D, this.posZ + ((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5F), d0, d1, d2);
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
/* 1615 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*      */     
/* 1617 */     if (var2 != null && 
/* 1618 */       var2.stackSize <= 0) {
/* 1619 */       par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 1620 */       var2 = null;
/*      */     } 
/*      */ 
/*      */     
/* 1624 */     if (!isTamed()) {
/* 1625 */       if (var2 != null && var2.getItem() == Items.beef && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) {
/* 1626 */         if (!this.worldObj.isRemote) {
/* 1627 */           if (this.worldObj.rand.nextInt(5) == 1) {
/* 1628 */             setTamed(true);
/* 1629 */             func_152115_b(par1EntityPlayer.getUniqueID().toString());
/* 1630 */             playTameEffect(true);
/* 1631 */             this.worldObj.setEntityState((Entity)this, (byte)7);
/* 1632 */             heal(mygetMaxHealth() - getHealth());
/*      */           } else {
/*      */             
/* 1635 */             playTameEffect(false);
/* 1636 */             this.worldObj.setEntityState((Entity)this, (byte)6);
/*      */           } 
/*      */         }
/* 1639 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 1640 */           var2.stackSize--;
/* 1641 */           if (var2.stackSize <= 0) {
/* 1642 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1645 */         return true;
/*      */       } 
/*      */     } else {
/*      */       
/* 1649 */       if (!isOwner((EntityLivingBase)par1EntityPlayer)) {
/* 1650 */         return false;
/*      */       }
/*      */       
/* 1653 */       if (var2 == null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/* 1654 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1656 */           par1EntityPlayer.mountEntity((Entity)this);
/*      */           
/* 1658 */           setActivity(1);
/* 1659 */           setSitting(false);
/*      */         } 
/* 1661 */         return true;
/*      */       } 
/*      */       
/* 1664 */       if (var2 != null && var2.getItem() == Items.beef && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) {
/* 1665 */         if (this.worldObj.isRemote) {
/* 1666 */           playTameEffect(true);
/* 1667 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/* 1670 */         if (mygetMaxHealth() > getHealth()) {
/* 1671 */           heal(mygetMaxHealth() - getHealth());
/*      */         }
/* 1673 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 1674 */           var2.stackSize--;
/* 1675 */           if (var2.stackSize <= 0) {
/* 1676 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1679 */         return true;
/*      */       } 
/* 1681 */       if (var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) {
/*      */         
/* 1683 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1685 */           setTamed(false);
/* 1686 */           func_152115_b("");
/* 1687 */           playTameEffect(false);
/* 1688 */           this.worldObj.setEntityState((Entity)this, (byte)6);
/*      */         } 
/* 1690 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 1691 */           var2.stackSize--;
/* 1692 */           if (var2.stackSize <= 0) {
/* 1693 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1696 */         return true;
/*      */       } 
/*      */       
/* 1699 */       if (var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.ice) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */         
/* 1702 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1704 */           playTameEffect(true);
/* 1705 */           this.worldObj.setEntityState((Entity)this, (byte)6);
/* 1706 */           setDragonFire(0);
/* 1707 */           par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText("Dragon fireballs extinguished."));
/*      */         } 
/*      */         
/* 1710 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1712 */           var2.stackSize--;
/* 1713 */           if (var2.stackSize <= 0)
/*      */           {
/* 1715 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1718 */         return true;
/*      */       } 
/*      */       
/* 1721 */       if (var2 != null && var2.getItem() == Items.flint_and_steel && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */         
/* 1724 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1726 */           playTameEffect(true);
/* 1727 */           this.worldObj.setEntityState((Entity)this, (byte)6);
/* 1728 */           setDragonFire(1);
/* 1729 */           par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText("Dragon fireballs lit!"));
/*      */         } 
/*      */         
/* 1732 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1734 */           var2.stackSize--;
/* 1735 */           if (var2.stackSize <= 0)
/*      */           {
/* 1737 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1740 */         return true;
/*      */       } 
/*      */       
/* 1743 */       if (var2 != null && var2.getItem() == Items.gunpowder && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D && isOwner((EntityLivingBase)par1EntityPlayer) && getDragonFire() > 0) {
/*      */ 
/*      */         
/* 1746 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1748 */           playTameEffect(true);
/* 1749 */           this.worldObj.setEntityState((Entity)this, (byte)6);
/* 1750 */           setDragonFire(2);
/* 1751 */           par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText("Dragon fireballs supercharged!"));
/*      */         } 
/*      */         
/* 1754 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1756 */           var2.stackSize--;
/* 1757 */           if (var2.stackSize <= 0)
/*      */           {
/* 1759 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1762 */         return true;
/*      */       } 
/* 1764 */       if (var2 != null && var2.getItem() == Items.snowball && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) {
/* 1765 */         if (this.worldObj.isRemote) {
/* 1766 */           playTameEffect(true);
/* 1767 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/* 1770 */         this.dragontype = 1;
/* 1771 */         setDragonType(this.dragontype);
/*      */         
/* 1773 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 1774 */           var2.stackSize--;
/* 1775 */           if (var2.stackSize <= 0) {
/* 1776 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1779 */         return true;
/*      */       } 
/* 1781 */       if (var2 != null && var2.getItem() == Items.coal && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) {
/* 1782 */         if (this.worldObj.isRemote) {
/* 1783 */           playTameEffect(true);
/* 1784 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/* 1787 */         this.dragontype = 0;
/* 1788 */         setDragonType(this.dragontype);
/*      */         
/* 1790 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 1791 */           var2.stackSize--;
/* 1792 */           if (var2.stackSize <= 0) {
/* 1793 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1796 */         return true;
/*      */       } 
/*      */       
/* 1799 */       if (var2 != null && var2.getItem() == Items.diamond && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D && isOwner((EntityLivingBase)par1EntityPlayer) && !this.worldObj.isRemote) {
/*      */ 
/*      */ 
/*      */         
/* 1803 */         Entity ent = null;
/* 1804 */         Spyro d = null;
/* 1805 */         ent = spawnCreature(this.worldObj, "Baby Dragon", this.posX, this.posY, this.posZ);
/* 1806 */         if (ent != null) {
/* 1807 */           d = (Spyro)ent;
/* 1808 */           if (isTamed()) {
/* 1809 */             d.setTamed(true);
/* 1810 */             d.func_152115_b(par1EntityPlayer.getUniqueID().toString());
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1817 */           setDead();
/*      */         } 
/* 1819 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1821 */           var2.stackSize--;
/* 1822 */           if (var2.stackSize <= 0)
/*      */           {
/* 1824 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1827 */         return true;
/*      */       } 
/*      */       
/* 1830 */       if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */         
/* 1832 */         setCustomNameTag(var2.getDisplayName());
/* 1833 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/* 1835 */           var2.stackSize--;
/* 1836 */           if (var2.stackSize <= 0)
/*      */           {
/* 1838 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/* 1841 */         return true;
/*      */       } 
/*      */       
/* 1844 */       if (var2 != null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) {
/*      */         
/* 1846 */         if (!isSitting()) {
/* 1847 */           setSitting(true);
/* 1848 */           setActivity(0);
/*      */         } else {
/* 1850 */           setSitting(false);
/* 1851 */           setActivity(0);
/*      */         } 
/* 1853 */         return true;
/*      */       } 
/*      */     } 
/*      */     
/* 1857 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWheat(ItemStack par1ItemStack) {
/* 1865 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.beef);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAttacking() {
/* 1871 */     return this.dataWatcher.getWatchableObjectByte(20);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAttacking(int par1) {
/* 1876 */     if (this.worldObj != null && this.worldObj.isRemote)
/* 1877 */       return;  this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*      */   }
/*      */ 
/*      */   
/*      */   public int getActivity() {
/* 1882 */     return this.dataWatcher.getWatchableObjectByte(21);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setActivity(int par1) {
/* 1887 */     if (this.worldObj != null && this.worldObj.isRemote)
/* 1888 */       return;  this.dataWatcher.updateObject(21, Byte.valueOf((byte)par1));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDragonFire() {
/* 1894 */     return this.dataWatcher.getWatchableObjectInt(24);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDragonFire(int par1) {
/* 1900 */     if (this.worldObj.isRemote)
/* 1901 */       return;  this.dataWatcher.updateObject(24, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 1910 */     Entity var8 = null;
/*      */ 
/*      */     
/* 1913 */     var8 = EntityList.createEntityByName(par1, par0World);
/*      */     
/* 1915 */     if (var8 != null) {
/*      */ 
/*      */       
/* 1918 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*      */ 
/*      */       
/* 1921 */       par0World.spawnEntityInWorld(var8);
/*      */       
/* 1923 */       ((EntityLiving)var8).playLivingSound();
/*      */     } 
/*      */     
/* 1926 */     return var8;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDragonType(int par1) {
/* 1931 */     this.dataWatcher.updateObject(22, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDragonType() {
/* 1937 */     return this.dataWatcher.getWatchableObjectInt(22);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 1943 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canDespawn() {
/* 1951 */     if (isNoDespawnRequired()) return false; 
/* 1952 */     if (this.riddenByEntity != null) {
/* 1953 */       return false;
/*      */     }
/* 1955 */     if (isTamed()) {
/* 1956 */       return false;
/*      */     }
/* 1958 */     return true;
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
/* 1969 */     super.writeEntityToNBT(par1NBTTagCompound);
/*      */     
/* 1971 */     par1NBTTagCompound.setInteger("DragonAttacking", getAttacking());
/* 1972 */     par1NBTTagCompound.setInteger("DragonActivity", getActivity());
/* 1973 */     par1NBTTagCompound.setInteger("DragonFire", getDragonFire());
/* 1974 */     par1NBTTagCompound.setInteger("DragonType", getDragonType());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 1983 */     super.readEntityFromNBT(par1NBTTagCompound);
/*      */     
/* 1985 */     setAttacking(par1NBTTagCompound.getInteger("DragonAttacking"));
/* 1986 */     setActivity(par1NBTTagCompound.getInteger("DragonActivity"));
/* 1987 */     setDragonFire(par1NBTTagCompound.getInteger("DragonFire"));
/* 1988 */     this.dragontype = par1NBTTagCompound.getInteger("DragonType");
/* 1989 */     setDragonType(this.dragontype);
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Dragon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */