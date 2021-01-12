/*      */ package danger.orespawn;
/*      */ 
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityCreature;
/*      */ import net.minecraft.entity.EntityList;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*      */ import net.minecraft.entity.ai.EntityAILookIdle;
/*      */ import net.minecraft.entity.ai.EntityAISwimming;
/*      */ import net.minecraft.entity.boss.EntityDragon;
/*      */ import net.minecraft.entity.effect.EntityLightningBolt;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.monster.EntityMob;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.ChunkCoordinates;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.Vec3;
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
/*      */ public class TheQueen
/*      */   extends EntityMob
/*      */ {
/*   64 */   private ChunkCoordinates currentFlightTarget = null;
/*   65 */   private GenericTargetSorter TargetSorter = null;
/*   66 */   private EntityLivingBase rt = null;
/*   67 */   private double attdam = 250.0D;
/*   68 */   private int hurt_timer = 0;
/*   69 */   private int homex = 0;
/*   70 */   private int homez = 0;
/*   71 */   private int stream_count = 0;
/*   72 */   private int stream_count_l = 0;
/*   73 */   private int ticker = 0;
/*   74 */   private int player_hit_count = 0;
/*   75 */   private int backoff_timer = 0;
/*   76 */   private int guard_mode = 0;
/*   77 */   private volatile int head_found = 0;
/*   78 */   private int wing_sound = 0;
/*   79 */   private int attack_level = 1;
/*   80 */   private EntityLivingBase ev = null;
/*   81 */   private float evh = 0.0F;
/*   82 */   private int mood = 0;
/*   83 */   private int always_mad = 0;
/*      */ 
/*      */   
/*      */   public TheQueen(World par1World) {
/*   87 */     super(par1World);
/*   88 */     if (OreSpawnMain.PlayNicely == 0) {
/*   89 */       setSize(22.0F, 24.0F);
/*      */     } else {
/*   91 */       setSize(5.5F, 6.0F);
/*      */     } 
/*   93 */     getNavigator().setAvoidsWater(false);
/*   94 */     this.experienceValue = 25000;
/*   95 */     this.isImmuneToFire = true;
/*   96 */     this.fireResistance = 5000;
/*   97 */     this.noClip = true;
/*   98 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*   99 */     this.renderDistanceWeight = 12.0D;
/*  100 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  101 */     this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  102 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*      */   }
/*      */ 
/*      */   
/*      */   protected void applyEntityAttributes() {
/*  107 */     super.applyEntityAttributes();
/*  108 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  109 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6200000047683716D);
/*      */     
/*  111 */     this.attdam = OreSpawnMain.TheQueen_stats.attack;
/*  112 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(this.attdam);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void entityInit() {
/*  118 */     int i = 0;
/*  119 */     super.entityInit();
/*  120 */     this.dataWatcher.addObject(20, Integer.valueOf(i));
/*  121 */     this.dataWatcher.addObject(21, Integer.valueOf(OreSpawnMain.PlayNicely));
/*  122 */     this.dataWatcher.addObject(22, Integer.valueOf(this.mood));
/*  123 */     this.dataWatcher.addObject(23, Integer.valueOf(this.attack_level));
/*      */   }
/*      */   
/*      */   public int getPlayNicely() {
/*  127 */     return this.dataWatcher.getWatchableObjectInt(21);
/*      */   }
/*      */   
/*      */   public int getIsHappy() {
/*  131 */     return this.dataWatcher.getWatchableObjectInt(22);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean isInRangeToRenderDist(double par1) {
/*  141 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean isInRangeToRenderVec3D(Vec3 par1Vec3) {
/*  149 */     return true;
/*      */   }
/*      */   
/*      */   protected boolean canDespawn() {
/*  153 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getAttacking() {
/*  158 */     return this.dataWatcher.getWatchableObjectInt(20);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAttacking(int par1) {
/*  163 */     this.dataWatcher.updateObject(20, Integer.valueOf(par1));
/*      */   }
/*      */   
/*      */   public int getPower() {
/*  167 */     return this.dataWatcher.getWatchableObjectInt(23);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPower(int par1) {
/*  172 */     this.dataWatcher.updateObject(23, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundVolume() {
/*  179 */     return 1.35F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundPitch() {
/*  186 */     return 1.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getLivingSound() {
/*  193 */     return "orespawn:king_living";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getHurtSound() {
/*  200 */     return "orespawn:king_hit";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDeathSound() {
/*  207 */     return "orespawn:trex_death";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBePushed() {
/*  214 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void collideWithEntity(Entity par1Entity) {}
/*      */   
/*      */   public int mygetMaxHealth() {
/*  221 */     return OreSpawnMain.TheQueen_stats.health;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/*  229 */     return Item.getItemFromBlock((Block)Blocks.yellow_flower);
/*      */   }
/*      */ 
/*      */   
/*      */   private void dropItemRand(Item index, int par1) {
/*  234 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(20) - OreSpawnMain.OreSpawnRand.nextInt(20), this.posY + 12.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(20) - OreSpawnMain.OreSpawnRand.nextInt(20), new ItemStack(index, par1, 0));
/*      */     
/*  236 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/*  243 */     dropItemRand(OreSpawnMain.MyRoyal, 1);
/*  244 */     dropItemRand(OreSpawnMain.ThePrinceEgg, 1);
/*      */     
/*  246 */     this; spawnCreature(this.worldObj, "The Princess", this.posX, this.posY + 10.0D, this.posZ);
/*      */     
/*  248 */     for (int i = 0; i < 56; i++) {
/*  249 */       dropItemRand(OreSpawnMain.MyQueenScale, 1);
/*  250 */       dropItemRand(Items.beef, 1);
/*  251 */       dropItemRand(Items.bone, 1);
/*  252 */       dropItemRand(Items.rotten_flesh, 1);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isAIEnabled() {
/*  261 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isHappy() {
/*  266 */     if (getIsHappy() == 0) return true; 
/*  267 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate() {
/*  275 */     super.onUpdate();
/*      */     
/*  277 */     this.wing_sound++;
/*  278 */     if (this.wing_sound > 30) {
/*      */       
/*  280 */       if (!this.worldObj.isRemote) this.worldObj.playSoundAtEntity((Entity)this, "orespawn:MothraWings", 1.75F, 0.75F); 
/*  281 */       this.wing_sound = 0;
/*      */     } 
/*      */     
/*  284 */     this.noClip = true;
/*  285 */     this.motionY *= 0.6D;
/*  286 */     if (this.player_hit_count < 10 && getHealth() < (mygetMaxHealth() * 3 / 4)) this.attdam = (OreSpawnMain.TheQueen_stats.attack * 20); 
/*  287 */     if (this.player_hit_count < 10 && getHealth() < (mygetMaxHealth() / 2)) this.attdam = (OreSpawnMain.TheQueen_stats.attack * 100); 
/*  288 */     if (this.player_hit_count < 10 && getHealth() < (mygetMaxHealth() / 3)) this.attdam = (OreSpawnMain.TheQueen_stats.attack * 500); 
/*  289 */     if (this.player_hit_count < 10 && getHealth() < (mygetMaxHealth() / 4)) this.attdam = (OreSpawnMain.TheQueen_stats.attack * 1000);
/*      */     
/*  291 */     if (this.worldObj.isRemote && getPower() > 800) {
/*  292 */       float f = 7.0F;
/*      */       
/*  294 */       if (this.worldObj.rand.nextInt(4) == 1)
/*      */       {
/*      */         
/*  297 */         for (int i = 0; i < 10; i++) {
/*  298 */           this.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 14.0D, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 5.0D + this.motionX * 3.0D, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 5.0D, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 5.0D + this.motionZ * 3.0D);
/*      */         }
/*      */       }
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
/*      */ 
/*      */   
/*      */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  315 */     if (par1Entity != null && par1Entity instanceof EntityLivingBase)
/*      */     {
/*  317 */       if (!this.worldObj.isRemote) {
/*  318 */         EntityLivingBase e = (EntityLivingBase)par1Entity;
/*  319 */         if (!e.isDead) {
/*  320 */           if (this.ev == e) {
/*  321 */             if (this.evh < e.getHealth()) e.setHealth(this.evh); 
/*      */           } else {
/*  323 */             this.ev = e;
/*      */           } 
/*  325 */           if (e.width * e.height > 30.0F) {
/*  326 */             e.setHealth(e.getHealth() * 3.0F / 4.0F);
/*  327 */             e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)this.attdam);
/*      */           } 
/*  329 */           this.evh = e.getHealth();
/*  330 */           if (this.evh <= 0.0F) this.ev.setDead(); 
/*      */         } else {
/*  332 */           this.ev = null;
/*  333 */           this.evh = 0.0F;
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  339 */     if (par1Entity != null && par1Entity instanceof EntityDragon) {
/*  340 */       EntityDragon dr = (EntityDragon)par1Entity;
/*  341 */       DamageSource var21 = null;
/*  342 */       var21 = DamageSource.setExplosionSource(null);
/*  343 */       var21.setExplosion();
/*  344 */       if (this.worldObj.rand.nextInt(6) == 1) {
/*  345 */         dr.attackEntityFromPart(dr.dragonPartHead, var21, (float)this.attdam);
/*      */       } else {
/*  347 */         dr.attackEntityFromPart(dr.dragonPartBody, var21, (float)this.attdam);
/*      */       } 
/*      */     } 
/*      */     
/*  351 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)this.attdam);
/*  352 */     if (var4) {
/*  353 */       double ks = 2.75D;
/*  354 */       double inair = 0.2D;
/*  355 */       float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/*  356 */       inair += (this.worldObj.rand.nextFloat() * 0.25F);
/*  357 */       if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 1.5D; 
/*  358 */       par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*      */     } 
/*      */     
/*  361 */     return var4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/*  369 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 8.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean tooFarFromHome() {
/*  375 */     float d1 = (float)(this.posX - this.homex);
/*  376 */     float d2 = (float)(this.posZ - this.homez);
/*      */     
/*  378 */     d1 = (float)Math.sqrt((d1 * d1 + d2 * d2));
/*  379 */     if (d1 > 120.0F) return true; 
/*  380 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void updateAITasks() {
/*  385 */     int xdir = 1;
/*  386 */     int zdir = 1;
/*      */ 
/*      */ 
/*      */     
/*  390 */     int attrand = 5;
/*  391 */     int updown = 0;
/*  392 */     int which = 0;
/*  393 */     EntityLivingBase e = null;
/*  394 */     EntityLivingBase f = null;
/*      */     
/*  396 */     double rr = 0.0D;
/*  397 */     double rhdir = 0.0D;
/*  398 */     double rdd = 0.0D;
/*  399 */     double pi = 3.1415926545D;
/*  400 */     double var1 = 0.0D;
/*  401 */     double var3 = 0.0D;
/*  402 */     double var5 = 0.0D;
/*  403 */     float var7 = 0.0F;
/*  404 */     float var8 = 0.0F;
/*  405 */     EntityLiving newent = null;
/*  406 */     double xzoff = 8.0D;
/*  407 */     double yoff = 14.0D;
/*  408 */     List<?> kinglist = null;
/*  409 */     Iterator<?> var2 = null;
/*  410 */     TheKing var4 = null;
/*      */     
/*  412 */     if (this.isDead)
/*  413 */       return;  super.updateAITasks();
/*      */     
/*  415 */     if (this.ev != null) {
/*  416 */       if (getDistanceSqToEntity((Entity)this.ev) < 2000.0D && !this.ev.isDead) {
/*  417 */         if (this.evh < this.ev.getHealth()) {
/*  418 */           this.ev.setHealth(this.evh);
/*      */         } else {
/*  420 */           this.evh = this.ev.getHealth();
/*      */         } 
/*  422 */         if (this.evh <= 0.0F) this.ev.setDead(); 
/*      */       } else {
/*  424 */         this.ev = null;
/*  425 */         this.evh = 0.0F;
/*      */       } 
/*      */     }
/*      */     
/*  429 */     if (this.attack_level > 1000) {
/*      */       
/*  431 */       if (this.mood == 1) {
/*  432 */         int j = 15;
/*  433 */         if (this.player_hit_count < 10) j = 45; 
/*  434 */         for (int i = 0; i < j; i++) {
/*  435 */           this; Entity ppwr = spawnCreature(this.worldObj, "PurplePower", this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)));
/*      */ 
/*      */ 
/*      */           
/*  439 */           if (ppwr != null) {
/*  440 */             ppwr.motionX = this.motionX * 3.0D;
/*  441 */             ppwr.motionZ = this.motionZ * 3.0D;
/*      */           } 
/*      */         } 
/*      */       } else {
/*  445 */         if (this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"))
/*  446 */           for (int i = 0; i < 25; i++) {
/*  447 */             int n = this.worldObj.rand.nextInt(25) - this.worldObj.rand.nextInt(25);
/*  448 */             int k = this.worldObj.rand.nextInt(25) - this.worldObj.rand.nextInt(25);
/*  449 */             for (int j = -20; j < 20; j++) {
/*  450 */               Block bid = this.worldObj.getBlock((int)this.posX + n, (int)this.posY + j, (int)this.posZ + k);
/*  451 */               if (bid == Blocks.grass) {
/*  452 */                 if (this.worldObj.getBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air) {
/*  453 */                   which = this.worldObj.rand.nextInt(8);
/*  454 */                   if (which == 0) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, (Block)Blocks.red_flower); 
/*  455 */                   if (which == 1) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, (Block)Blocks.yellow_flower); 
/*  456 */                   if (which == 2) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.MyFlowerBlueBlock); 
/*  457 */                   if (which == 3) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.MyFlowerPinkBlock); 
/*  458 */                   if (which == 4) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.CrystalFlowerRedBlock); 
/*  459 */                   if (which == 5) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.CrystalFlowerGreenBlock); 
/*  460 */                   if (which == 6) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.CrystalFlowerBlueBlock); 
/*  461 */                   if (which == 7) this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, OreSpawnMain.CrystalFlowerYellowBlock); 
/*      */                 } 
/*      */                 break;
/*      */               } 
/*  465 */               if (bid == Blocks.dirt && 
/*  466 */                 this.worldObj.getBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air) {
/*  467 */                 this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j, (int)this.posZ + k, (Block)Blocks.grass);
/*      */                 
/*      */                 break;
/*      */               } 
/*  471 */               if (bid == Blocks.stone && 
/*  472 */                 this.worldObj.getBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air) {
/*  473 */                 this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, Blocks.dirt);
/*      */                 
/*      */                 break;
/*      */               } 
/*  477 */               if (bid == Blocks.sand && 
/*  478 */                 this.worldObj.getBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air) {
/*  479 */                 if (this.worldObj.rand.nextInt(2) == 0) {
/*  480 */                   this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k, Blocks.cactus); break;
/*      */                 } 
/*  482 */                 this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j, (int)this.posZ + k, Blocks.dirt);
/*      */                 
/*      */                 break;
/*      */               } 
/*      */               
/*  487 */               if (bid == Blocks.lava && 
/*  488 */                 this.worldObj.getBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air) {
/*  489 */                 this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j, (int)this.posZ + k, Blocks.water);
/*      */                 
/*      */                 break;
/*      */               } 
/*  493 */               if (bid == Blocks.flowing_lava && 
/*  494 */                 this.worldObj.getBlock((int)this.posX + n, (int)this.posY + j + 1, (int)this.posZ + k) == Blocks.air) {
/*  495 */                 this.worldObj.setBlock((int)this.posX + n, (int)this.posY + j, (int)this.posZ + k, (Block)Blocks.flowing_water);
/*      */                 
/*      */                 break;
/*      */               } 
/*  499 */               if (bid == Blocks.air && j > 0) {
/*      */                 break;
/*      */               }
/*      */             } 
/*      */           }  
/*  504 */         for (int m = 0; m < 10; m++) {
/*  505 */           int i = this.worldObj.rand.nextInt(15) - this.worldObj.rand.nextInt(15);
/*  506 */           int k = this.worldObj.rand.nextInt(15) - this.worldObj.rand.nextInt(15);
/*  507 */           int j = this.worldObj.rand.nextInt(20);
/*  508 */           Block bid = this.worldObj.getBlock((int)this.posX + i, (int)this.posY + j, (int)this.posZ + k);
/*  509 */           if (bid == Blocks.air) {
/*  510 */             if (this.worldObj.rand.nextInt(2) == 0) {
/*  511 */               newent = (EntityLiving)spawnCreature(this.worldObj, "Butterfly", this.posX + i, this.posY + j, this.posZ + k);
/*      */             } else {
/*  513 */               newent = (EntityLiving)spawnCreature(this.worldObj, "Bird", this.posX + i, this.posY + j, this.posZ + k);
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*  518 */       this.attack_level = 1;
/*      */     } 
/*      */     
/*  521 */     if (this.attack_level > 1) this.attack_level--;
/*      */     
/*  523 */     if (this.hurt_timer > 0) this.hurt_timer--; 
/*  524 */     if ((this.homex == 0 && this.homez == 0) || this.guard_mode == 0) {
/*  525 */       this.homex = (int)this.posX;
/*  526 */       this.homez = (int)this.posZ;
/*      */     } 
/*      */     
/*  529 */     if (getHealth() > (mygetMaxHealth() - 2) && this.worldObj.rand.nextInt(500) == 1) {
/*  530 */       this.mood = 0;
/*      */     }
/*  532 */     if (this.always_mad != 0) {
/*  533 */       this.mood = 1;
/*      */     }
/*      */     
/*  536 */     if (this.mood == 0) {
/*  537 */       this.attack_level += 10;
/*      */     }
/*      */     
/*  540 */     this.ticker++;
/*  541 */     if (this.ticker > 30000) this.ticker = 0; 
/*  542 */     if (this.ticker % 60 == 0) this.stream_count = 10; 
/*  543 */     if (this.ticker % 70 == 0) this.stream_count_l = 6; 
/*  544 */     if (this.ticker % 10 == 0) {
/*  545 */       this.dataWatcher.updateObject(21, Integer.valueOf(OreSpawnMain.PlayNicely));
/*  546 */       this.dataWatcher.updateObject(22, Integer.valueOf(this.mood));
/*  547 */       setPower(this.attack_level);
/*      */     } 
/*      */     
/*  550 */     if (this.backoff_timer > 0) this.backoff_timer--;
/*      */     
/*  552 */     if (this.player_hit_count < 10 && getHealth() < (mygetMaxHealth() / 2)) attrand = 3; 
/*  553 */     this.noClip = true;
/*      */ 
/*      */ 
/*      */     
/*  557 */     if (this.currentFlightTarget == null) {
/*  558 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  564 */     if (tooFarFromHome() || this.worldObj.rand.nextInt(200) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 9.1F) {
/*      */ 
/*      */ 
/*      */       
/*  568 */       zdir = this.worldObj.rand.nextInt(120);
/*  569 */       xdir = this.worldObj.rand.nextInt(120);
/*  570 */       if (this.worldObj.rand.nextInt(2) == 0) zdir = -zdir; 
/*  571 */       if (this.worldObj.rand.nextInt(2) == 0) xdir = -xdir;
/*      */ 
/*      */       
/*  574 */       int dist = 0;
/*  575 */       for (int i = -5; i <= 5; i += 5) {
/*  576 */         for (int j = -5; j <= 5; j += 5) {
/*  577 */           Block bid = this.worldObj.getBlock(this.homex + j, (int)this.posY, this.homez + i);
/*  578 */           if (bid != Blocks.air)
/*  579 */           { for (int k = 1; k < 20; k++) {
/*  580 */               bid = this.worldObj.getBlock(this.homex + j, (int)this.posY + k, this.homez + i);
/*  581 */               dist++;
/*  582 */               if (bid == Blocks.air)
/*      */                 break; 
/*      */             }  }
/*  585 */           else { for (int k = 1; k < 20; k++) {
/*  586 */               bid = this.worldObj.getBlock(this.homex + j, (int)this.posY - k, this.homez + i);
/*  587 */               dist--;
/*  588 */               if (bid != Blocks.air)
/*      */                 break; 
/*      */             }  }
/*      */         
/*      */         } 
/*  593 */       }  dist = dist / 9 + 2;
/*  594 */       if ((int)(this.posY + dist) > 230) dist = 230 - (int)this.posY; 
/*  595 */       this.currentFlightTarget.set(this.homex + xdir, (int)(this.posY + dist), this.homez + zdir);
/*  596 */       if (this.mood == 0) {
/*  597 */         kinglist = this.worldObj.getEntitiesWithinAABB(TheKing.class, this.boundingBox.expand(64.0D, 32.0D, 64.0D));
/*  598 */         if (kinglist != null) {
/*  599 */           Collections.sort(kinglist, this.TargetSorter);
/*  600 */           var2 = kinglist.iterator();
/*  601 */           if (var2.hasNext()) {
/*  602 */             var4 = null;
/*  603 */             var4 = (TheKing)var2.next();
/*  604 */             this.guard_mode = 0;
/*  605 */             zdir = this.worldObj.rand.nextInt(16);
/*  606 */             xdir = this.worldObj.rand.nextInt(16);
/*  607 */             if (this.worldObj.rand.nextInt(2) == 0) zdir = -zdir; 
/*  608 */             if (this.worldObj.rand.nextInt(2) == 0) xdir = -xdir; 
/*  609 */             this.currentFlightTarget.set((int)var4.posX + xdir, (int)(var4.posY + (this.worldObj.rand.nextInt(8) - this.worldObj.rand.nextInt(8))), (int)var4.posZ + zdir);
/*      */           }
/*      */         
/*      */         } 
/*      */       } 
/*  614 */     } else if (this.worldObj.rand.nextInt(attrand) == 0) {
/*      */ 
/*      */       
/*  617 */       e = this.rt;
/*  618 */       if (OreSpawnMain.PlayNicely != 0 || isHappy()) e = null; 
/*  619 */       if (e != null && (
/*  620 */         e instanceof TheQueen || e instanceof QueenHead)) {
/*  621 */         this.rt = null;
/*  622 */         e = null;
/*      */       } 
/*      */       
/*  625 */       if (e != null) {
/*      */         
/*  627 */         float d1 = (float)(e.posX - this.homex);
/*  628 */         float d2 = (float)(e.posZ - this.homez);
/*  629 */         d1 = (float)Math.sqrt((d1 * d1 + d2 * d2));
/*  630 */         if (e.isDead || this.worldObj.rand.nextInt(450) == 1 || (d1 > 128.0F && this.guard_mode == 1)) {
/*  631 */           e = null;
/*  632 */           this.rt = null;
/*      */         } 
/*  634 */         if (e != null && 
/*  635 */           !MyCanSee(e)) {
/*  636 */           e = null;
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  642 */       f = findSomethingToAttack();
/*  643 */       if (this.head_found == 0 && this.mood == 1)
/*      */       {
/*  645 */         newent = (EntityLiving)spawnCreature(this.worldObj, "QueenHead", this.posX, this.posY + 20.0D, this.posZ);
/*      */       }
/*      */ 
/*      */       
/*  649 */       if (e == null) {
/*  650 */         e = f;
/*      */       }
/*      */       
/*  653 */       if (e != null) {
/*      */ 
/*      */         
/*  656 */         float d1 = e.width * e.height;
/*  657 */         if (this.attack_level < 1000) {
/*  658 */           this.attack_level += 15;
/*  659 */           if (getHealth() < (mygetMaxHealth() / 2)) this.attack_level += 15; 
/*  660 */           if (d1 > 50.0F) this.attack_level += 15; 
/*  661 */           if (d1 > 100.0F) this.attack_level += 15; 
/*  662 */           if (d1 > 200.0F) this.attack_level += 25; 
/*      */         } 
/*  664 */         setAttacking(1);
/*  665 */         if (this.backoff_timer == 0) {
/*  666 */           int dist = (int)(e.posY + (e.height / 2.0F) + 1.0D);
/*  667 */           if (dist > 230) dist = 230; 
/*  668 */           this.currentFlightTarget.set((int)e.posX, dist, (int)e.posZ);
/*  669 */           if (this.worldObj.rand.nextInt(50) == 1) this.backoff_timer = 90 + this.worldObj.rand.nextInt(90);
/*      */         
/*  671 */         } else if (this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 9.1F) {
/*      */ 
/*      */           
/*  674 */           zdir = this.worldObj.rand.nextInt(20) + 30;
/*  675 */           xdir = this.worldObj.rand.nextInt(20) + 30;
/*  676 */           if (this.worldObj.rand.nextInt(2) == 0) zdir = -zdir; 
/*  677 */           if (this.worldObj.rand.nextInt(2) == 0) xdir = -xdir;
/*      */ 
/*      */           
/*  680 */           int dist = 0;
/*  681 */           for (int i = -5; i <= 5; i += 5) {
/*  682 */             for (int j = -5; j <= 5; j += 5) {
/*  683 */               Block bid = this.worldObj.getBlock((int)e.posX + j, (int)this.posY, (int)e.posZ + i);
/*  684 */               if (bid != Blocks.air)
/*  685 */               { for (int k = 1; k < 20; k++) {
/*  686 */                   bid = this.worldObj.getBlock((int)e.posX + j, (int)this.posY + k, (int)e.posZ + i);
/*  687 */                   dist++;
/*  688 */                   if (bid == Blocks.air)
/*      */                     break; 
/*      */                 }  }
/*  691 */               else { for (int k = 1; k < 20; k++) {
/*  692 */                   bid = this.worldObj.getBlock((int)e.posX + j, (int)this.posY - k, (int)e.posZ + i);
/*  693 */                   dist--;
/*  694 */                   if (bid != Blocks.air)
/*      */                     break; 
/*      */                 }  }
/*      */             
/*      */             } 
/*  699 */           }  dist = dist / 9 + 2;
/*  700 */           if ((int)(this.posY + dist) > 230) dist = 230 - (int)this.posY; 
/*  701 */           this.currentFlightTarget.set((int)e.posX + xdir, (int)(this.posY + dist), (int)e.posZ + zdir);
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  707 */         if (getDistanceSqToEntity((Entity)e) < 900.0D) {
/*  708 */           if (this.worldObj.rand.nextInt(2) == 1) doJumpDamage(this.posX, this.posY, this.posZ, 15.0D, (OreSpawnMain.TheQueen_stats.attack / 4), 0); 
/*  709 */           attackEntityAsMob((Entity)e);
/*      */         } 
/*      */         
/*  712 */         double dx = this.posX + 20.0D * Math.sin(Math.toRadians(this.rotationYaw));
/*  713 */         double dz = this.posZ - 20.0D * Math.cos(Math.toRadians(this.rotationYaw));
/*  714 */         if (this.worldObj.rand.nextInt(3) == 1) doJumpDamage(dx, this.posY + 10.0D, dz, 15.0D, (OreSpawnMain.TheQueen_stats.attack / 2), 1);
/*      */         
/*  716 */         if (getHorizontalDistanceSqToEntity((Entity)e) > 900.0D) {
/*  717 */           which = this.worldObj.rand.nextInt(2);
/*  718 */           if (which == 0) {
/*      */             
/*  720 */             if (this.stream_count > 0) {
/*  721 */               setAttacking(1);
/*      */ 
/*      */               
/*  724 */               rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/*  725 */               rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */               
/*  727 */               rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/*  728 */               if (rdd > pi) rdd -= pi * 2.0D; 
/*  729 */               rdd = Math.abs(rdd);
/*      */               
/*  731 */               if (rdd < 0.5D) {
/*  732 */                 firecanon(e);
/*      */               }
/*      */             }
/*      */           
/*      */           }
/*  737 */           else if (this.stream_count_l > 0) {
/*  738 */             setAttacking(1);
/*      */ 
/*      */             
/*  741 */             rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/*  742 */             rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */             
/*  744 */             rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/*  745 */             if (rdd > pi) rdd -= pi * 2.0D; 
/*  746 */             rdd = Math.abs(rdd);
/*      */             
/*  748 */             if (rdd < 0.5D) {
/*  749 */               firecanonl(e);
/*      */             }
/*      */           }
/*      */         
/*      */         } 
/*      */       } else {
/*      */         
/*  756 */         setAttacking(0);
/*  757 */         this.stream_count = 10;
/*  758 */         this.stream_count_l = 6;
/*      */       } 
/*      */     } 
/*      */     
/*  762 */     var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/*  763 */     var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/*  764 */     var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  770 */     this.motionX += (Math.signum(var1) * 0.65D - this.motionX) * 0.35D;
/*  771 */     this.motionY += (Math.signum(var3) * 0.69999D - this.motionY) * 0.3D;
/*  772 */     this.motionZ += (Math.signum(var5) * 0.65D - this.motionZ) * 0.35D;
/*      */     
/*  774 */     var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/*  775 */     var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/*  776 */     this.moveForward = 0.75F;
/*  777 */     this.rotationYaw += var8 / 8.0F;
/*      */ 
/*      */     
/*  780 */     if (this.worldObj.rand.nextInt(32) == 1 && 
/*  781 */       getHealth() < mygetMaxHealth()) {
/*      */       
/*  783 */       heal(5.0F);
/*  784 */       if (this.player_hit_count < 10) heal(50.0F);
/*      */     
/*      */     } 
/*      */     
/*  788 */     if (this.player_hit_count < 10 && getHealth() < 2000.0F) heal(2000.0F - getHealth());
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private double getHorizontalDistanceSqToEntity(Entity e) {
/*  800 */     double d1 = e.posZ - this.posZ;
/*  801 */     double d2 = e.posX - this.posX;
/*  802 */     return d1 * d1 + d2 * d2;
/*      */   }
/*      */ 
/*      */   
/*      */   private void firecanon(EntityLivingBase e) {
/*  807 */     double yoff = 14.0D;
/*  808 */     double xzoff = 32.0D;
/*      */ 
/*      */     
/*  811 */     BetterFireball bf = null;
/*      */     
/*  813 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/*  814 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*  815 */     if (this.stream_count > 0) {
/*      */ 
/*      */ 
/*      */       
/*  819 */       bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, e.posX - cx, e.posY + (e.height / 2.0F) - this.posY + yoff, e.posZ - cz);
/*  820 */       bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/*  821 */       bf.setPosition(cx, this.posY + yoff, cz);
/*  822 */       bf.setReallyBig();
/*  823 */       this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*  824 */       this.worldObj.spawnEntityInWorld((Entity)bf);
/*  825 */       for (int i = 0; i < 6; i++) {
/*  826 */         float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/*  827 */         float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/*  828 */         float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/*  829 */         bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, e.posX - cx + r1, e.posY + (e.height / 2.0F) - this.posY + yoff + r2, e.posZ - cz + r3);
/*  830 */         bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/*  831 */         bf.setPosition(cx, this.posY + yoff, cz);
/*  832 */         bf.setBig();
/*  833 */         if (this.worldObj.rand.nextInt(2) == 1) bf.setSmall(); 
/*  834 */         this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*  835 */         this.worldObj.spawnEntityInWorld((Entity)bf);
/*      */       } 
/*  837 */       this.stream_count--;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void firecanonl(EntityLivingBase e) {
/*  844 */     double yoff = 14.0D;
/*  845 */     double xzoff = 32.0D;
/*      */ 
/*      */ 
/*      */     
/*  849 */     double var3 = 0.0D;
/*  850 */     double var5 = 0.0D;
/*  851 */     double var7 = 0.0D;
/*  852 */     float var9 = 0.0F;
/*  853 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/*  854 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*  855 */     if (this.stream_count_l > 0) {
/*  856 */       this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*  857 */       for (int i = 0; i < 3; i++) {
/*  858 */         ThunderBolt lb = new ThunderBolt(this.worldObj, cx, this.posY + yoff, cz);
/*  859 */         lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0F, 0.0F);
/*  860 */         var3 = e.posX - lb.posX;
/*  861 */         var5 = e.posY + 0.25D - lb.posY;
/*  862 */         var7 = e.posZ - lb.posZ;
/*  863 */         var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/*  864 */         lb.setThrowableHeading(var3, var5 + var9, var7, 1.4F, 4.0F);
/*  865 */         lb.motionX *= 3.0D;
/*  866 */         lb.motionY *= 3.0D;
/*  867 */         lb.motionZ *= 3.0D;
/*  868 */         this.worldObj.spawnEntityInWorld((Entity)lb);
/*      */       } 
/*  870 */       this.stream_count_l--;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canTriggerWalking() {
/*  880 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void fall(float par1) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateFallState(double par1, boolean par3) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean doesEntityNotTriggerPressurePlate() {
/*  898 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  906 */     boolean ret = false;
/*  907 */     float dm = par2;
/*      */ 
/*      */     
/*  910 */     if (this.hurt_timer > 0) return false; 
/*  911 */     if (dm > 750.0F) dm = 750.0F;
/*      */     
/*  913 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/*  914 */       return false;
/*      */     }
/*  916 */     this.mood = 1;
/*      */     
/*  918 */     if (par1DamageSource.isExplosion()) {
/*  919 */       float s = getHealth();
/*  920 */       s += par2 / 2.0F;
/*  921 */       if (s > getMaxHealth()) s = getMaxHealth(); 
/*  922 */       setHealth(s);
/*  923 */       return false;
/*      */     } 
/*      */     
/*  926 */     Entity e = par1DamageSource.getEntity();
/*  927 */     if (e != null && e instanceof EntityLivingBase) {
/*      */       
/*  929 */       if (e instanceof PurplePower) return false; 
/*  930 */       float s = e.height * e.width;
/*  931 */       if (e instanceof EntityMob && 
/*  932 */         s < 3.0F) {
/*  933 */         e.setDead();
/*  934 */         return false;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  939 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*  940 */       this.hurt_timer = 20;
/*  941 */       ret = super.attackEntityFrom(par1DamageSource, dm);
/*      */       
/*  943 */       if (e != null && e instanceof EntityPlayer)
/*      */       {
/*      */ 
/*      */ 
/*      */         
/*  948 */         this.player_hit_count++;
/*      */       }
/*      */       
/*  951 */       if (e != null && e instanceof EntityLivingBase && this.currentFlightTarget != null)
/*      */       {
/*  953 */         if (!MyUtils.isRoyalty(e)) {
/*  954 */           this.rt = (EntityLivingBase)e;
/*  955 */           int dist = (int)e.posY;
/*  956 */           if (dist > 230) dist = 230; 
/*  957 */           this.currentFlightTarget.set((int)e.posX, dist, (int)e.posZ);
/*      */         } 
/*      */       }
/*      */     } 
/*  961 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanSpawnHere() {
/*  971 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  979 */     if (this.player_hit_count < 10 && getHealth() < (mygetMaxHealth() * 2 / 3)) return OreSpawnMain.TheQueen_stats.defense + 2; 
/*  980 */     if (this.player_hit_count < 10 && getHealth() < (mygetMaxHealth() / 2)) return OreSpawnMain.TheQueen_stats.defense + 3; 
/*  981 */     if (this.player_hit_count < 10 && getHealth() < (mygetMaxHealth() / 3)) return OreSpawnMain.TheQueen_stats.defense + 5;
/*      */     
/*  983 */     return OreSpawnMain.TheQueen_stats.defense;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onStruckByLightning(EntityLightningBolt par1EntityLightningBolt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void initCreature() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean MyCanSee(EntityLivingBase e) {
/* 1003 */     double xzoff = 10.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1010 */     int nblks = 20;
/*      */     
/* 1012 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 1013 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/* 1014 */     float startx = (float)cx;
/* 1015 */     float starty = (float)(this.posY + 14.0D);
/* 1016 */     float startz = (float)cz;
/* 1017 */     float dx = (float)((e.posX - startx) / 20.0D);
/* 1018 */     float dy = (float)((e.posY + (e.height / 2.0F) - starty) / 20.0D);
/* 1019 */     float dz = (float)((e.posZ - startz) / 20.0D);
/*      */     
/* 1021 */     if (Math.abs(dx) > 1.0D) {
/* 1022 */       dy /= Math.abs(dx);
/* 1023 */       dz /= Math.abs(dx);
/* 1024 */       nblks = (int)(nblks * Math.abs(dx));
/* 1025 */       if (dx > 1.0F) dx = 1.0F; 
/* 1026 */       if (dx < -1.0F) dx = -1.0F; 
/*      */     } 
/* 1028 */     if (Math.abs(dy) > 1.0D) {
/* 1029 */       dx /= Math.abs(dy);
/* 1030 */       dz /= Math.abs(dy);
/* 1031 */       nblks = (int)(nblks * Math.abs(dy));
/* 1032 */       if (dy > 1.0F) dy = 1.0F; 
/* 1033 */       if (dy < -1.0F) dy = -1.0F; 
/*      */     } 
/* 1035 */     if (Math.abs(dz) > 1.0D) {
/* 1036 */       dy /= Math.abs(dz);
/* 1037 */       dx /= Math.abs(dz);
/* 1038 */       nblks = (int)(nblks * Math.abs(dz));
/* 1039 */       if (dz > 1.0F) dz = 1.0F; 
/* 1040 */       if (dz < -1.0F) dz = -1.0F;
/*      */     
/*      */     } 
/* 1043 */     for (int i = 0; i < nblks; i++) {
/* 1044 */       startx += dx;
/* 1045 */       starty += dy;
/* 1046 */       startz += dz;
/* 1047 */       Block bid = this.worldObj.getBlock((int)startx, (int)starty, (int)startz);
/* 1048 */       if (bid != Blocks.air) return false;
/*      */     
/*      */     } 
/*      */     
/* 1052 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 1062 */     if (par1EntityLiving == null)
/*      */     {
/* 1064 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1068 */     if (par1EntityLiving == this)
/*      */     {
/* 1070 */       return false;
/*      */     }
/* 1072 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/*      */       
/* 1075 */       return false;
/*      */     }
/*      */     
/* 1078 */     if (par1EntityLiving instanceof QueenHead) {
/*      */       
/* 1080 */       this.head_found = 1;
/* 1081 */       return false;
/*      */     } 
/* 1083 */     if (MyUtils.isRoyalty((Entity)par1EntityLiving))
/*      */     {
/* 1085 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1090 */     float d1 = (float)(par1EntityLiving.posX - this.homex);
/* 1091 */     float d2 = (float)(par1EntityLiving.posZ - this.homez);
/* 1092 */     d1 = (float)Math.sqrt((d1 * d1 + d2 * d2));
/* 1093 */     if (d1 > 144.0F) return false;
/*      */     
/* 1095 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*      */     
/* 1097 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*      */ 
/*      */       
/* 1101 */       return false;
/*      */     }
/*      */     
/* 1104 */     if (par1EntityLiving instanceof EntityPlayer) {
/*      */       
/* 1106 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 1107 */       if (p.capabilities.isCreativeMode == true) {
/* 1108 */         return false;
/*      */       }
/* 1110 */       return true;
/*      */     } 
/*      */     
/* 1113 */     if (par1EntityLiving instanceof net.minecraft.entity.passive.EntityHorse)
/*      */     {
/* 1115 */       return true;
/*      */     }
/* 1117 */     if (par1EntityLiving instanceof EntityMob)
/*      */     {
/* 1119 */       return true;
/*      */     }
/*      */     
/* 1122 */     if (par1EntityLiving instanceof EntityDragon)
/*      */     {
/* 1124 */       return true;
/*      */     }
/* 1126 */     if (MyUtils.isAttackableNonMob(par1EntityLiving)) {
/* 1127 */       return true;
/*      */     }
/*      */     
/* 1130 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private EntityLivingBase findSomethingToAttack() {
/* 1135 */     if (OreSpawnMain.PlayNicely != 0 || isHappy()) {
/* 1136 */       this.head_found = 1;
/* 1137 */       return null;
/*      */     } 
/* 1139 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(80.0D, 60.0D, 80.0D));
/* 1140 */     Collections.sort(var5, this.TargetSorter);
/* 1141 */     Iterator<?> var2 = var5.iterator();
/* 1142 */     Entity var3 = null;
/* 1143 */     EntityLivingBase var4 = null;
/* 1144 */     EntityLivingBase ret = null;
/*      */     
/* 1146 */     this.head_found = 0;
/* 1147 */     while (var2.hasNext()) {
/*      */       
/* 1149 */       var3 = (Entity)var2.next();
/* 1150 */       var4 = (EntityLivingBase)var3;
/*      */       
/* 1152 */       if (isSuitableTarget(var4, false))
/*      */       {
/*      */         
/* 1155 */         if (ret == null) ret = var4;
/*      */       
/*      */       }
/* 1158 */       if (ret != null && this.head_found != 0)
/*      */         break; 
/* 1160 */     }  return ret;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setGuardMode(int i) {
/* 1165 */     this.guard_mode = i;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setBadMood(int i) {
/* 1170 */     this.always_mad = i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 1180 */     super.writeEntityToNBT(par1NBTTagCompound);
/*      */     
/* 1182 */     par1NBTTagCompound.setInteger("KingHomeX", this.homex);
/* 1183 */     par1NBTTagCompound.setInteger("KingHomeZ", this.homez);
/* 1184 */     par1NBTTagCompound.setInteger("GuardMode", this.guard_mode);
/* 1185 */     par1NBTTagCompound.setInteger("PlayerHits", this.player_hit_count);
/* 1186 */     par1NBTTagCompound.setInteger("MeanMode", this.always_mad);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 1195 */     super.readEntityFromNBT(par1NBTTagCompound);
/*      */     
/* 1197 */     this.homex = par1NBTTagCompound.getInteger("KingHomeX");
/* 1198 */     this.homez = par1NBTTagCompound.getInteger("KingHomeZ");
/* 1199 */     this.guard_mode = par1NBTTagCompound.getInteger("GuardMode");
/* 1200 */     this.player_hit_count = par1NBTTagCompound.getInteger("PlayerHits");
/* 1201 */     this.always_mad = par1NBTTagCompound.getInteger("MeanMode");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 1210 */     Entity var8 = null;
/* 1211 */     var8 = EntityList.createEntityByName(par1, par0World);
/* 1212 */     if (var8 != null) {
/*      */ 
/*      */       
/* 1215 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*      */ 
/*      */       
/* 1218 */       par0World.spawnEntityInWorld(var8);
/*      */     } 
/* 1220 */     return var8;
/*      */   }
/*      */ 
/*      */   
/*      */   private EntityLivingBase doJumpDamage(double X, double Y, double Z, double dist, double damage, int knock) {
/* 1225 */     AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(X - dist, Y - 10.0D, Z - dist, X + dist, Y + 10.0D, Z + dist);
/* 1226 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
/* 1227 */     Collections.sort(var5, this.TargetSorter);
/* 1228 */     Iterator<?> var2 = var5.iterator();
/* 1229 */     Entity var3 = null;
/* 1230 */     EntityLivingBase var4 = null;
/*      */     
/* 1232 */     while (var2.hasNext()) {
/*      */       
/* 1234 */       var3 = (Entity)var2.next();
/* 1235 */       var4 = (EntityLivingBase)var3;
/*      */       
/* 1237 */       if (var4 == null) {
/*      */         continue;
/*      */       }
/*      */       
/* 1241 */       if (var4 == this) {
/*      */         continue;
/*      */       }
/*      */       
/* 1245 */       if (!var4.isEntityAlive()) {
/*      */         continue;
/*      */       }
/*      */       
/* 1249 */       if (MyUtils.isRoyalty((Entity)var4)) {
/*      */         continue;
/*      */       }
/*      */       
/* 1253 */       if (var4 instanceof Ghost || 
/* 1254 */         var4 instanceof GhostSkelly)
/*      */         continue; 
/* 1256 */       DamageSource var21 = null;
/* 1257 */       var21 = DamageSource.setExplosionSource(null);
/* 1258 */       var21.setExplosion();
/* 1259 */       var4.attackEntityFrom(var21, (float)damage / 2.0F);
/* 1260 */       var4.attackEntityFrom(DamageSource.fall, (float)damage / 2.0F);
/* 1261 */       this.worldObj.playSoundAtEntity((Entity)var4, "random.explode", 0.65F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5F);
/* 1262 */       if (knock != 0) {
/* 1263 */         double ks = 2.75D;
/* 1264 */         double inair = 0.65D;
/* 1265 */         float f3 = (float)Math.atan2(var4.posZ - this.posZ, var4.posX - this.posX);
/* 1266 */         var4.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*      */       } 
/*      */     } 
/*      */     
/* 1270 */     return null;
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\TheQueen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */