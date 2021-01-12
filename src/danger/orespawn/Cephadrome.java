/*      */ package danger.orespawn;
/*      */ 
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.enchantment.Enchantment;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityCreature;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*      */ import net.minecraft.entity.ai.EntityAILookIdle;
/*      */ import net.minecraft.entity.ai.EntityAISwimming;
/*      */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*      */ import net.minecraft.entity.boss.EntityDragon;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.passive.EntityTameable;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.MathHelper;
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
/*      */ public class Cephadrome
/*      */   extends EntityCreature
/*      */ {
/*      */   private int boatPosRotationIncrements;
/*      */   private double boatX;
/*      */   private double boatY;
/*      */   private double boatZ;
/*      */   private double boatYaw;
/*      */   private double boatPitch;
/*      */   private double boatYawHead;
/*   73 */   private int damage_counter = 100;
/*   74 */   private int updateit = 1;
/*   75 */   private int color = 1;
/*   76 */   private int playing = 0;
/*   77 */   private GenericTargetSorter TargetSorter = null;
/*   78 */   private RenderInfo renderdata = new RenderInfo();
/*   79 */   private int hurt_timer = 0;
/*      */   private int wasfed;
/*   81 */   private int shouldattack = 0;
/*   82 */   private int wing_sound = 0;
/*   83 */   private int hit_by_player = 0;
/*   84 */   private int badmood = 0;
/*   85 */   private float moveSpeed = 0.25F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Cephadrome(World par1World) {
/*   92 */     super(par1World);
/*   93 */     setSize(2.5F, 2.25F);
/*   94 */     getNavigator().setAvoidsWater(true);
/*   95 */     this.experienceValue = 200;
/*   96 */     this.fireResistance = 100;
/*   97 */     this.isImmuneToFire = false;
/*   98 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*   99 */     this.tasks.addTask(1, new MyEntityAIWanderALot(this, 16, 1.0D));
/*  100 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 9.0F));
/*  101 */     this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  102 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget(this, false));
/*  103 */     this.riddenByEntity = null;
/*  104 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  105 */     this.renderdata = new RenderInfo();
/*      */   }
/*      */ 
/*      */   
/*      */   public Cephadrome(World par1World, double par2, double par4, double par6) {
/*  110 */     this(par1World);
/*  111 */     setPosition(par2, par4 + this.yOffset, par6);
/*  112 */     this.motionX = 0.0D;
/*  113 */     this.motionY = 0.0D;
/*  114 */     this.motionZ = 0.0D;
/*  115 */     this.prevPosX = par2;
/*  116 */     this.prevPosY = par4;
/*  117 */     this.prevPosZ = par6;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void applyEntityAttributes() {
/*  123 */     super.applyEntityAttributes();
/*  124 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  125 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  126 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  127 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(70.0D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean shouldRiderSit() {
/*  136 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTrackingRange() {
/*  141 */     return 128;
/*      */   }
/*      */   
/*      */   public int getUpdateFrequency() {
/*  145 */     return 10;
/*      */   }
/*      */   
/*      */   public boolean sendsVelocityUpdates() {
/*  149 */     return true;
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
/*  163 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void entityInit() {
/*  168 */     super.entityInit();
/*  169 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  170 */     this.dataWatcher.addObject(21, Byte.valueOf((byte)0));
/*      */     
/*  172 */     setActivity(0);
/*  173 */     setAttacking(0);
/*      */     
/*  175 */     if (this.renderdata == null) {
/*  176 */       this.renderdata = new RenderInfo();
/*      */     }
/*  178 */     this.renderdata.rf1 = 0.0F;
/*  179 */     this.renderdata.rf2 = 0.0F;
/*  180 */     this.renderdata.rf3 = 0.0F;
/*  181 */     this.renderdata.rf4 = 0.0F;
/*  182 */     this.renderdata.ri1 = 0;
/*  183 */     this.renderdata.ri2 = 0;
/*  184 */     this.renderdata.ri3 = 0;
/*  185 */     this.renderdata.ri4 = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int mygetMaxHealth() {
/*  192 */     return 300;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RenderInfo getRenderInfo() {
/*  199 */     return this.renderdata;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRenderInfo(RenderInfo r) {
/*  204 */     this.renderdata.rf1 = r.rf1;
/*  205 */     this.renderdata.rf2 = r.rf2;
/*  206 */     this.renderdata.rf3 = r.rf3;
/*  207 */     this.renderdata.rf4 = r.rf4;
/*  208 */     this.renderdata.ri1 = r.ri1;
/*  209 */     this.renderdata.ri2 = r.ri2;
/*  210 */     this.renderdata.ri3 = r.ri3;
/*  211 */     this.renderdata.ri4 = r.ri4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  219 */     return 16;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void jump() {
/*  224 */     super.jump();
/*  225 */     this.motionY += 0.1D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAIEnabled() {
/*  233 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLivingSound() {
/*  241 */     if (getActivity() != 1 && this.rand.nextInt(6) == 1) {
/*  242 */       return "orespawn:MothraWings";
/*      */     }
/*  244 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getHurtSound() {
/*  252 */     return "orespawn:alo_hurt";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDeathSound() {
/*  260 */     return "orespawn:alo_death";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundVolume() {
/*  267 */     return 1.5F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getSoundPitch() {
/*  274 */     return 1.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBePushed() {
/*  283 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getMountedYOffset() {
/*  291 */     return 2.5D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/*  299 */     return Items.beef;
/*      */   }
/*      */ 
/*      */   
/*      */   private ItemStack dropItemRand(Item index, int par1) {
/*  304 */     EntityItem var3 = null;
/*  305 */     ItemStack is = new ItemStack(index, par1, 0);
/*      */     
/*  307 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), is);
/*      */     
/*  309 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/*  310 */     return is;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/*  318 */     int i = 4 + this.worldObj.rand.nextInt(6); int var4;
/*  319 */     for (var4 = 0; var4 < i; var4++) {
/*  320 */       dropItemRand(OreSpawnMain.UraniumNugget, 1);
/*      */     }
/*      */     
/*  323 */     i = 4 + this.worldObj.rand.nextInt(6);
/*  324 */     for (var4 = 0; var4 < i; var4++) {
/*  325 */       dropItemRand(OreSpawnMain.TitaniumNugget, 1);
/*      */     }
/*      */     
/*  328 */     i = 1 + this.worldObj.rand.nextInt(5);
/*  329 */     for (var4 = 0; var4 < i; var4++) {
/*  330 */       ItemStack is; int var3 = this.worldObj.rand.nextInt(20);
/*  331 */       switch (var3) {
/*      */         case 0:
/*  333 */           is = dropItemRand(OreSpawnMain.MyRubySword, 1);
/*      */           break;
/*      */         case 1:
/*  336 */           is = dropItemRand(Items.diamond, 1);
/*      */           break;
/*      */         case 2:
/*  339 */           is = dropItemRand(OreSpawnMain.MyThunderStaff, 1);
/*      */           break;
/*      */         case 3:
/*  342 */           is = dropItemRand(OreSpawnMain.MyRubySword, 1);
/*  343 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*  344 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/*  345 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/*  346 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/*  347 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  348 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/*  349 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 4:
/*  352 */           is = dropItemRand(OreSpawnMain.MyRubyShovel, 1);
/*  353 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  354 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 5:
/*  357 */           is = dropItemRand(OreSpawnMain.MyRubyPickaxe, 1);
/*  358 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  359 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*  360 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 6:
/*  363 */           is = dropItemRand(OreSpawnMain.MyRubyAxe, 1);
/*  364 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  365 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 7:
/*  368 */           is = dropItemRand(OreSpawnMain.MyRubyHoe, 1);
/*  369 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  370 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 8:
/*  373 */           is = dropItemRand((Item)OreSpawnMain.RubyHelmet, 1);
/*  374 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  375 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  376 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  377 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  378 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*  379 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2)); 
/*  380 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 9:
/*  383 */           is = dropItemRand((Item)OreSpawnMain.RubyBody, 1);
/*  384 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  385 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  386 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  387 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  388 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 10:
/*  391 */           is = dropItemRand((Item)OreSpawnMain.RubyLegs, 1);
/*  392 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/*  393 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  394 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  395 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/*  396 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 11:
/*  399 */           is = dropItemRand((Item)OreSpawnMain.RubyBoots, 1);
/*  400 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/*  401 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 12:
/*      */         case 13:
/*      */         case 14:
/*      */         case 15:
/*      */         case 16:
/*      */         case 17:
/*  409 */           is = dropItemRand(OreSpawnMain.MyRuby, 1);
/*      */           break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCephadromeHealth() {
/*  421 */     return (int)getHealth();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  429 */     double ks = 2.5D;
/*  430 */     double inair = 0.35D;
/*  431 */     float iskraken = 1.0F;
/*  432 */     boolean ret = false;
/*  433 */     if (par1Entity != null && par1Entity instanceof EntityDragon) {
/*  434 */       EntityDragon dr = (EntityDragon)par1Entity;
/*  435 */       DamageSource var21 = null;
/*  436 */       var21 = DamageSource.setExplosionSource(null);
/*  437 */       var21.setExplosion();
/*  438 */       if (this.worldObj.rand.nextInt(6) == 1) {
/*  439 */         dr.attackEntityFromPart(dr.dragonPartHead, var21, 70.0F);
/*      */       } else {
/*  441 */         dr.attackEntityFromPart(dr.dragonPartBody, var21, 70.0F);
/*      */       } 
/*  443 */       ret = true;
/*      */     }
/*  445 */     else if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*      */       
/*  447 */       if (par1Entity instanceof Kraken) iskraken = 1.5F; 
/*  448 */       ret = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), iskraken * 70.0F);
/*      */       
/*  450 */       float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/*  451 */       if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/*  452 */       par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*      */     } 
/*      */     
/*  455 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  463 */     boolean ret = false;
/*  464 */     if (this.hurt_timer > 0) return false;
/*      */     
/*  466 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*  467 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*  468 */       this.hurt_timer = 25;
/*      */       
/*  470 */       Entity e = par1DamageSource.getEntity();
/*  471 */       if (e != null && e instanceof EntityLivingBase) {
/*      */         
/*  473 */         setAttackTarget((EntityLivingBase)e);
/*  474 */         setTarget(e);
/*  475 */         getNavigator().tryMoveToEntityLiving(e, 1.2D);
/*  476 */         ret = true;
/*      */       } 
/*  478 */       if (e != null && e instanceof EntityPlayer && getHealth() < getMaxHealth() * 9.0F / 10.0F)
/*      */       {
/*  480 */         this.hit_by_player = 1;
/*      */       }
/*      */     } 
/*  483 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public double getHorizontalDistanceSqToEntity(Entity par1Entity) {
/*  489 */     double d0 = this.posX - par1Entity.posX;
/*  490 */     double d2 = this.posZ - par1Entity.posZ;
/*  491 */     return d0 * d0 + d2 * d2;
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateAITasks() {
/*  496 */     EntityLivingBase e = null;
/*  497 */     double maxdist = 10.0D;
/*      */     
/*  499 */     if (this.isDead)
/*      */       return; 
/*  501 */     if (this.updateit > 0) this.updateit--; 
/*  502 */     if (this.hurt_timer > 0) this.hurt_timer--;
/*      */     
/*  504 */     if (this.updateit <= 0 && !this.worldObj.isRemote) {
/*  505 */       this.updateit = 30;
/*  506 */       if (this.riddenByEntity != null) {
/*  507 */         setActivity(1);
/*      */       } else {
/*  509 */         setActivity(0);
/*      */       } 
/*      */     } 
/*      */     
/*  513 */     if (this.worldObj.rand.nextInt(100) == 1 && 
/*  514 */       getHealth() < mygetMaxHealth()) {
/*  515 */       heal(2.0F);
/*      */     }
/*      */ 
/*      */     
/*  519 */     if (getActivity() == 0) {
/*  520 */       super.updateAITasks();
/*      */     }
/*  522 */     if (this.worldObj.rand.nextInt(7) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
/*      */       
/*  524 */       e = getAttackTarget();
/*  525 */       if (e != null && !e.isEntityAlive()) {
/*  526 */         setAttackTarget(null);
/*  527 */         e = null;
/*      */       } 
/*  529 */       if (e == null) {
/*  530 */         e = findSomethingToAttack();
/*      */       }
/*  532 */       if (e != null)
/*      */       
/*  534 */       { if (getActivity() == 0) {
/*  535 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.7D);
/*  536 */           maxdist = 6.0D;
/*      */         } 
/*  538 */         faceEntity((Entity)e, 10.0F, 10.0F);
/*  539 */         setAttacking(1);
/*  540 */         if (getDistanceSqToEntity((Entity)e) < (maxdist + (e.width / 2.0F)) * (maxdist + (e.width / 2.0F))) {
/*  541 */           attackEntityAsMob((Entity)e);
/*      */         }
/*  543 */         else if (e instanceof Kraken && getHorizontalDistanceSqToEntity((Entity)e) < (maxdist + (e.width / 2.0F)) * (maxdist + (e.width / 2.0F))) {
/*  544 */           attackEntityAsMob((Entity)e);
/*      */         }
/*      */          }
/*      */       
/*  548 */       else if (getAttacking() != 0) { setAttacking(0); }
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/*  559 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*      */     
/*  561 */     if (par1EntityLiving == null)
/*      */     {
/*  563 */       return false;
/*      */     }
/*  565 */     if (par1EntityLiving == this)
/*      */     {
/*  567 */       return false;
/*      */     }
/*  569 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/*  571 */       return false;
/*      */     }
/*  573 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*  575 */       return false;
/*      */     }
/*  577 */     if (par1EntityLiving instanceof Cephadrome)
/*      */     {
/*  579 */       return false;
/*      */     }
/*  581 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityMob)
/*      */     {
/*  583 */       return true;
/*      */     }
/*  585 */     if (par1EntityLiving instanceof Mothra)
/*      */     {
/*  587 */       return true;
/*      */     }
/*  589 */     if (par1EntityLiving instanceof Leon) {
/*      */       
/*  591 */       EntityTameable et = (EntityTameable)par1EntityLiving;
/*  592 */       if (et.isTamed()) return false; 
/*  593 */       return true;
/*      */     } 
/*  595 */     if (par1EntityLiving instanceof GammaMetroid) {
/*      */       
/*  597 */       EntityTameable et = (EntityTameable)par1EntityLiving;
/*  598 */       if (et.isTamed()) return false; 
/*  599 */       return true;
/*      */     } 
/*  601 */     if (par1EntityLiving instanceof WaterDragon) {
/*      */       
/*  603 */       EntityTameable et = (EntityTameable)par1EntityLiving;
/*  604 */       if (et.isTamed()) return false; 
/*  605 */       return true;
/*      */     } 
/*      */     
/*  608 */     if (par1EntityLiving instanceof EntityDragon)
/*      */     {
/*  610 */       return true;
/*      */     }
/*  612 */     if (par1EntityLiving instanceof EntityPlayer) {
/*      */       
/*  614 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/*  615 */       if (p.capabilities.isCreativeMode == true) {
/*  616 */         return false;
/*      */       }
/*  618 */       if (this.hit_by_player != 0) return true; 
/*  619 */       if (this.badmood != 0) return true; 
/*  620 */       if (this.shouldattack > 0) {
/*  621 */         this.shouldattack = 0;
/*  622 */         return true;
/*      */       } 
/*  624 */       return false;
/*      */     } 
/*      */     
/*  627 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private EntityLivingBase findSomethingToAttack() {
/*  632 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/*  633 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0D, 20.0D, 16.0D));
/*  634 */     Collections.sort(var5, this.TargetSorter);
/*  635 */     Iterator<?> var2 = var5.iterator();
/*  636 */     Entity var3 = null;
/*  637 */     EntityLivingBase var4 = null;
/*      */     
/*  639 */     while (var2.hasNext()) {
/*      */       
/*  641 */       var3 = (Entity)var2.next();
/*  642 */       var4 = (EntityLivingBase)var3;
/*      */       
/*  644 */       if (isSuitableTarget(var4, false))
/*      */       {
/*  646 */         return var4;
/*      */       }
/*      */     } 
/*  649 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanSpawnHere() {
/*      */     int k;
/*  658 */     for (k = -3; k < 3; k++) {
/*      */       
/*  660 */       for (int j = -3; j < 3; j++) {
/*      */         
/*  662 */         for (int i = 0; i < 5; i++) {
/*      */           
/*  664 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/*  665 */           if (bid == Blocks.mob_spawner) {
/*  666 */             TileEntityMobSpawner tileentitymobspawner = null;
/*  667 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/*  668 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/*  669 */             if (s != null && 
/*  670 */               s.equals("Cephadrome")) {
/*  671 */               this.badmood = 1;
/*  672 */               return true;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  680 */     if ((!this.worldObj.isDaytime() ? true : false) == true) return false; 
/*  681 */     if (this.posY < 50.0D) return false;
/*      */ 
/*      */     
/*  684 */     for (k = -2; k < 2; k++) {
/*      */       
/*  686 */       for (int j = -2; j < 2; j++) {
/*      */         
/*  688 */         for (int i = 1; i < 5; i++) {
/*      */           
/*  690 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/*  691 */           if (bid != Blocks.air) return false;
/*      */         
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  697 */     Cephadrome target = null;
/*  698 */     target = (Cephadrome)this.worldObj.findNearestEntityWithinAABB(Cephadrome.class, this.boundingBox.expand(16.0D, 6.0D, 16.0D), (Entity)this);
/*  699 */     if (target != null)
/*      */     {
/*  701 */       return false;
/*      */     }
/*  703 */     return true;
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
/*  715 */     super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
/*  716 */     this.boatPosRotationIncrements = par9;
/*      */     
/*  718 */     this.boatX = par1;
/*  719 */     this.boatY = par3;
/*  720 */     this.boatZ = par5;
/*  721 */     this.boatYaw = par7;
/*  722 */     this.boatPitch = par8;
/*  723 */     this.boatYawHead = par7;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void setVelocity(double par1, double par3, double par5) {
/*  733 */     super.setVelocity(par1, par3, par5);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate() {
/*  739 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  740 */     super.onUpdate();
/*  741 */     if (getActivity() == 1) {
/*  742 */       this.wing_sound++;
/*  743 */       if (this.wing_sound > 22) {
/*      */         
/*  745 */         if (!this.worldObj.isRemote) this.worldObj.playSoundAtEntity((Entity)this, "orespawn:MothraWings", 0.5F, 1.0F); 
/*  746 */         this.wing_sound = 0;
/*      */       } 
/*      */     } 
/*  749 */     if (OreSpawnMain.PlayNicely == 0) this.wasfed = 1;
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onLivingUpdate() {
/*  759 */     List<Entity> list = null;
/*  760 */     Entity listEntity = null;
/*      */ 
/*      */ 
/*      */     
/*  764 */     double d6 = (this.rand.nextFloat() * 2.0F - 1.0F);
/*  765 */     double d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  771 */     double obstruction_factor = 0.0D;
/*      */     
/*  773 */     double relative_g = 0.0D;
/*      */     
/*  775 */     double max_speed = 1.15D;
/*  776 */     double gh = 1.0D;
/*      */ 
/*      */ 
/*      */     
/*  780 */     double rt = 0.0D;
/*      */     
/*  782 */     double pi = 3.1415926545D;
/*  783 */     double deltav = 0.0D;
/*      */ 
/*      */ 
/*      */     
/*  787 */     int dist = 2;
/*      */ 
/*      */ 
/*      */     
/*  791 */     if (getActivity() == 0) {
/*      */       
/*  793 */       super.onLivingUpdate();
/*      */     
/*      */     }
/*  796 */     else if (this.isDead) {
/*  797 */       super.onLivingUpdate();
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  802 */     if (this.isDead) {
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
/*  813 */     if (this.worldObj.isRemote) {
/*      */ 
/*      */ 
/*      */       
/*  817 */       if (this.boatPosRotationIncrements > 0 && getActivity() != 0)
/*      */       {
/*  819 */         double d4 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
/*  820 */         double d5 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
/*  821 */         double d11 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
/*  822 */         setPosition(d4, d5, d11);
/*      */         
/*  824 */         this.rotationPitch = (float)(this.rotationPitch + (this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
/*  825 */         double d10 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
/*  826 */         if (this.riddenByEntity != null) d10 = MathHelper.wrapAngleTo180_double(this.riddenByEntity.rotationYaw - this.rotationYaw); 
/*  827 */         this.rotationYaw = (float)(this.rotationYaw + d10 / this.boatPosRotationIncrements);
/*  828 */         setRotation(this.rotationYaw, this.rotationPitch);
/*      */ 
/*      */         
/*  831 */         this.boatPosRotationIncrements--;
/*      */       
/*      */       }
/*      */     
/*      */     }
/*  836 */     else if (getActivity() != 0) {
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
/*  854 */       if (this.riddenByEntity != null) {
/*  855 */         EntityPlayer pp = (EntityPlayer)this.riddenByEntity;
/*      */ 
/*      */ 
/*      */         
/*  859 */         if (this.motionX < -2.0D) this.motionX = -2.0D; 
/*  860 */         if (this.motionX > 2.0D) this.motionX = 2.0D; 
/*  861 */         if (this.motionZ < -2.0D) this.motionZ = -2.0D; 
/*  862 */         if (this.motionZ > 2.0D) this.motionZ = 2.0D; 
/*  863 */         double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */         
/*  865 */         gh = 1.55D;
/*  866 */         Block bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh), (int)this.posZ);
/*  867 */         if (bid != Blocks.air) {
/*  868 */           this.motionY += 0.07D;
/*  869 */           this.posY += 0.1D;
/*      */         } else {
/*  871 */           this.motionY -= 0.018D;
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  878 */         obstruction_factor = 0.0D;
/*  879 */         dist = 2;
/*  880 */         dist += (int)(velocity * 6.0D);
/*  881 */         for (int k = 1; k < dist; k++) {
/*  882 */           for (int i = 1; i < dist * 2; i++) {
/*  883 */             double dx = i * Math.cos(Math.toRadians((this.rotationYaw + 90.0F)));
/*  884 */             double dz = i * Math.sin(Math.toRadians((this.rotationYaw + 90.0F)));
/*  885 */             bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - k, (int)(this.posZ + dz));
/*  886 */             if (bid != Blocks.air) {
/*  887 */               obstruction_factor += 0.04D;
/*      */             }
/*      */           } 
/*      */         } 
/*  891 */         this.motionY += obstruction_factor * 0.09D;
/*  892 */         this.posY += obstruction_factor * 0.09D;
/*  893 */         if (this.motionY > 2.0D) this.motionY = 2.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  902 */         double d4 = this.riddenByEntity.rotationYaw;
/*  903 */         d4 %= 360.0D;
/*  904 */         for (; d4 < 0.0D; d4 += 360.0D);
/*  905 */         double d5 = this.rotationYaw;
/*  906 */         d5 %= 360.0D;
/*  907 */         for (; d5 < 0.0D; d5 += 360.0D);
/*  908 */         relative_g = (d4 - d5) % 180.0D;
/*  909 */         for (; relative_g < 0.0D; relative_g += 180.0D);
/*  910 */         if (relative_g > 90.0D) relative_g -= 180.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  916 */         if (velocity > 0.1D) {
/*  917 */           d4 = 1.5D - velocity;
/*  918 */           d4 = Math.abs(d4);
/*  919 */           if (d4 < 0.01D) d4 = 0.01D; 
/*  920 */           if (d4 > 0.9D) d4 = 0.9D; 
/*  921 */           this.rotationYaw = this.riddenByEntity.rotationYaw + (float)(relative_g * d4);
/*      */         } else {
/*      */           
/*  924 */           this.rotationYaw = this.riddenByEntity.rotationYaw;
/*      */         } 
/*  926 */         relative_g = Math.abs(relative_g) * velocity;
/*  927 */         if (relative_g > 50.0D) relative_g = 0.0D;
/*      */ 
/*      */ 
/*      */         
/*  931 */         if (this.motionY > 0.0D) {
/*  932 */           this.rotationPitch = 360.0F - 2.0F * (float)velocity;
/*      */         } else {
/*  934 */           this.rotationPitch = 2.0F * (float)velocity;
/*      */         } 
/*  936 */         setRotation(this.rotationYaw, this.rotationPitch);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  943 */         double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  952 */         double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
/*  953 */         double rhm = Math.atan2(this.motionZ, this.motionX);
/*  954 */         double rhdir = Math.toRadians(((this.riddenByEntity.rotationYaw + 90.0F) % 360.0F));
/*  955 */         rt = 0.0D;
/*  956 */         pi = 3.1415926545D;
/*  957 */         deltav = 0.0D;
/*  958 */         double im = pp.moveForward;
/*      */ 
/*      */         
/*  961 */         if (OreSpawnMain.flyup_keystate != 0) {
/*  962 */           this.motionY += 0.04D;
/*  963 */           this.motionY += velocity * 0.05D;
/*      */         } 
/*      */ 
/*      */         
/*  967 */         double rdv = Math.abs(rhm - rhdir) % pi * 2.0D;
/*  968 */         if (rdv > pi) rdv -= pi * 2.0D; 
/*  969 */         rdv = Math.abs(rdv);
/*  970 */         if (Math.abs(newvelocity) < 0.01D) rdv = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  978 */         if (rdv > 1.5D) newvelocity = -newvelocity;
/*      */         
/*  980 */         if (Math.abs(im) > 0.0010000000474974513D) {
/*  981 */           if (im > 0.0D) {
/*  982 */             deltav = 0.03D;
/*  983 */             if (max_speed > 0.85D) deltav += 0.05D;
/*      */           
/*      */           } else {
/*  986 */             max_speed = 0.35D;
/*      */             
/*  988 */             deltav = -0.03D;
/*      */           } 
/*      */           
/*  991 */           newvelocity += deltav;
/*  992 */           if (newvelocity >= 0.0D) {
/*  993 */             if (newvelocity > max_speed) newvelocity = max_speed; 
/*  994 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*  995 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*      */           } else {
/*  997 */             if (newvelocity < -max_speed) newvelocity = -max_speed; 
/*  998 */             newvelocity = -newvelocity;
/*  999 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/* 1000 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/*      */           }
/*      */         
/*      */         }
/* 1004 */         else if (newvelocity >= 0.0D) {
/* 1005 */           this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 1006 */           this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*      */         } else {
/* 1008 */           this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/* 1009 */           this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1015 */       moveEntity(this.motionX, this.motionY, this.motionZ);
/*      */       
/* 1017 */       this.motionX *= 0.985D;
/* 1018 */       this.motionY *= 0.94D;
/* 1019 */       this.motionZ *= 0.985D;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1024 */       if (!this.worldObj.isRemote) {
/*      */         
/* 1026 */         list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(2.25D, 2.0D, 2.25D));
/*      */         
/* 1028 */         if (list != null && !list.isEmpty())
/*      */         {
/* 1030 */           for (int l = 0; l < list.size(); l++) {
/*      */             
/* 1032 */             listEntity = list.get(l);
/*      */             
/* 1034 */             if (listEntity != this.riddenByEntity && !listEntity.isDead && listEntity.canBePushed())
/*      */             {
/* 1036 */               listEntity.applyEntityCollision((Entity)this);
/*      */             }
/*      */           } 
/*      */         }
/*      */       } 
/* 1041 */       if (this.riddenByEntity != null && this.riddenByEntity.isDead)
/*      */       {
/* 1043 */         this.riddenByEntity = null;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1049 */     if (getActivity() == 1) {
/* 1050 */       updateAITasks();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateRiderPosition() {
/* 1058 */     if (this.riddenByEntity != null) {
/*      */ 
/*      */       
/* 1061 */       float f = 0.75F;
/* 1062 */       this.riddenByEntity.setPosition(this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)));
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
/* 1074 */     String s = "heart";
/*      */     
/* 1076 */     if (!par1)
/*      */     {
/* 1078 */       s = "smoke";
/*      */     }
/*      */     
/* 1081 */     for (int i = 0; i < 20; i++) {
/*      */       
/* 1083 */       double d0 = this.rand.nextGaussian() * 0.08D;
/* 1084 */       double d1 = this.rand.nextGaussian() * 0.08D;
/* 1085 */       double d2 = this.rand.nextGaussian() * 0.08D;
/* 1086 */       this.worldObj.spawnParticle(s, this.posX + ((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5F), this.posY + 0.5D + this.rand.nextFloat() * 1.5D, this.posZ + ((this.rand.nextFloat() - this.rand.nextFloat()) * 2.5F), d0, d1, d2);
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
/* 1097 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*      */     
/* 1099 */     if (var2 != null && 
/* 1100 */       var2.stackSize <= 0) {
/* 1101 */       par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 1102 */       var2 = null;
/*      */     } 
/*      */     
/* 1105 */     if (var2 != null && (var2.getItem() == Items.beef || var2.getItem() == Items.chicken || var2.getItem() == Items.porkchop) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) {
/*      */ 
/*      */       
/* 1108 */       if (!this.worldObj.isRemote)
/*      */       {
/* 1110 */         heal(mygetMaxHealth() - getHealth());
/*      */       }
/* 1112 */       this.wasfed = 1;
/* 1113 */       this.shouldattack = 0;
/* 1114 */       playTameEffect(true);
/* 1115 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/* 1117 */         var2.stackSize--;
/* 1118 */         if (var2.stackSize <= 0) {
/*      */           
/* 1120 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 1121 */           var2 = null;
/*      */         } 
/*      */       } 
/*      */     } else {
/* 1125 */       if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != par1EntityPlayer)
/*      */       {
/* 1127 */         return true;
/*      */       }
/*      */ 
/*      */       
/* 1131 */       if (var2 == null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D)
/*      */       {
/* 1133 */         if (!this.worldObj.isRemote) {
/*      */           
/* 1135 */           if (this.wasfed == 0) {
/*      */ 
/*      */             
/* 1138 */             getNavigator().tryMoveToEntityLiving((Entity)par1EntityPlayer, 1.2D);
/* 1139 */             this.shouldattack = 1;
/* 1140 */             return false;
/*      */           } 
/* 1142 */           par1EntityPlayer.mountEntity((Entity)this);
/* 1143 */           this.wasfed = 0;
/*      */         } 
/*      */       }
/*      */       
/* 1147 */       return true;
/*      */     } 
/* 1149 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAttacking() {
/* 1155 */     return this.dataWatcher.getWatchableObjectByte(20);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAttacking(int par1) {
/* 1160 */     if (this.worldObj != null && this.worldObj.isRemote)
/* 1161 */       return;  this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*      */   }
/*      */ 
/*      */   
/*      */   public int getActivity() {
/* 1166 */     return this.dataWatcher.getWatchableObjectByte(21);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setActivity(int par1) {
/* 1171 */     if (this.worldObj != null && this.worldObj.isRemote)
/* 1172 */       return;  this.dataWatcher.updateObject(21, Byte.valueOf((byte)par1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canDespawn() {
/* 1180 */     if (isNoDespawnRequired()) return false; 
/* 1181 */     if (this.riddenByEntity != null) {
/* 1182 */       return false;
/*      */     }
/* 1184 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 1193 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 1194 */     par1NBTTagCompound.setInteger("CephaWasFed", this.wasfed);
/* 1195 */     par1NBTTagCompound.setInteger("CephaAttacking", getAttacking());
/* 1196 */     par1NBTTagCompound.setInteger("CephaActivity", getActivity());
/* 1197 */     par1NBTTagCompound.setInteger("CephaHitByPlayer", this.hit_by_player);
/* 1198 */     par1NBTTagCompound.setInteger("CephaBadMood", this.badmood);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 1207 */     super.readEntityFromNBT(par1NBTTagCompound);
/* 1208 */     this.wasfed = par1NBTTagCompound.getInteger("CephaWasFed");
/* 1209 */     this.hit_by_player = par1NBTTagCompound.getInteger("CephaHitByPlayer");
/* 1210 */     this.badmood = par1NBTTagCompound.getInteger("CephaBadMood");
/* 1211 */     setAttacking(par1NBTTagCompound.getInteger("CephaAttacking"));
/* 1212 */     setActivity(par1NBTTagCompound.getInteger("CephaActivity"));
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Cephadrome.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */