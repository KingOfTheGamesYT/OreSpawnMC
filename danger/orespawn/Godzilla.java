/*      */ package danger.orespawn;
/*      */ 
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.enchantment.Enchantment;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityCreature;
/*      */ import net.minecraft.entity.EntityList;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*      */ import net.minecraft.entity.ai.EntityAILookIdle;
/*      */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*      */ import net.minecraft.entity.ai.EntityAISwimming;
/*      */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*      */ import net.minecraft.entity.boss.EntityDragon;
/*      */ import net.minecraft.entity.effect.EntityLightningBolt;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.monster.EntityMob;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.DamageSource;
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
/*      */ public class Godzilla
/*      */   extends EntityMob
/*      */ {
/*   59 */   private GenericTargetSorter TargetSorter = null;
/*   60 */   private float moveSpeed = 0.75F;
/*   61 */   private int hurt_timer = 0;
/*   62 */   private int jumped = 0;
/*   63 */   private int jump_timer = 0;
/*   64 */   private int ticker = 0;
/*   65 */   private RenderInfo renderdata = new RenderInfo();
/*   66 */   private int stream_count = 8;
/*   67 */   private MyEntityAIWanderALot wander = null;
/*   68 */   private int head_found = 0;
/*   69 */   private int large_unknown_detected = 0;
/*      */ 
/*      */   
/*      */   public Godzilla(World par1World) {
/*   73 */     super(par1World);
/*   74 */     if (OreSpawnMain.PlayNicely == 0) {
/*   75 */       setSize(9.9F, 25.0F);
/*      */     } else {
/*   77 */       setSize(2.475F, 6.25F);
/*      */     } 
/*   79 */     getNavigator().setAvoidsWater(true);
/*   80 */     this.experienceValue = 10000;
/*   81 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*   82 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*   83 */     this.wander = new MyEntityAIWanderALot((EntityCreature)this, 15, 1.0D);
/*   84 */     this.tasks.addTask(2, this.wander);
/*   85 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 50.0F));
/*   86 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*   87 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*   88 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*   89 */     this.fireResistance = 10000;
/*   90 */     this.isImmuneToFire = true;
/*   91 */     this.renderDistanceWeight = 12.0D;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void applyEntityAttributes() {
/*   97 */     super.applyEntityAttributes();
/*   98 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*   99 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  100 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Godzilla_stats.attack);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void entityInit() {
/*  105 */     super.entityInit();
/*  106 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  107 */     this.dataWatcher.addObject(21, Integer.valueOf(OreSpawnMain.PlayNicely));
/*  108 */     if (this.renderdata == null) {
/*  109 */       this.renderdata = new RenderInfo();
/*      */     }
/*  111 */     this.renderdata.rf1 = 0.0F;
/*  112 */     this.renderdata.rf2 = 0.0F;
/*  113 */     this.renderdata.rf3 = 0.0F;
/*  114 */     this.renderdata.rf4 = 0.0F;
/*  115 */     this.renderdata.ri1 = 0;
/*  116 */     this.renderdata.ri2 = 0;
/*  117 */     this.renderdata.ri3 = 0;
/*  118 */     this.renderdata.ri4 = 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getPlayNicely() {
/*  123 */     return this.dataWatcher.getWatchableObjectInt(21);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RenderInfo getRenderInfo() {
/*  130 */     return this.renderdata;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRenderInfo(RenderInfo r) {
/*  135 */     this.renderdata.rf1 = r.rf1;
/*  136 */     this.renderdata.rf2 = r.rf2;
/*  137 */     this.renderdata.rf3 = r.rf3;
/*  138 */     this.renderdata.rf4 = r.rf4;
/*  139 */     this.renderdata.ri1 = r.ri1;
/*  140 */     this.renderdata.ri2 = r.ri2;
/*  141 */     this.renderdata.ri3 = r.ri3;
/*  142 */     this.renderdata.ri4 = r.ri4;
/*      */   }
/*      */   
/*      */   protected boolean canDespawn() {
/*  146 */     if (isNoDespawnRequired()) return false; 
/*  147 */     if (OreSpawnMain.PlayNicely != 0) return true; 
/*  148 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public int mygetMaxHealth() {
/*  153 */     return OreSpawnMain.Godzilla_stats.health;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  161 */     if (this.large_unknown_detected != 0) return 25; 
/*  162 */     return OreSpawnMain.Godzilla_stats.defense;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isAIEnabled() {
/*  170 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate() {
/*  178 */     double xzoff = 0.0D;
/*      */     
/*  180 */     double myoff = 20.0D;
/*  181 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  182 */     super.onUpdate();
/*  183 */     if (this.isAirBorne) {
/*  184 */       getNavigator().setPath(null, 0.0D);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void onLivingUpdate() {
/*  190 */     super.onLivingUpdate();
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
/*      */   
/*      */   protected void updateFallState(double par1, boolean par3) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getLivingSound() {
/*  210 */     if (this.worldObj.rand.nextInt(5) == 0) {
/*  211 */       return "orespawn:godzilla_living";
/*      */     }
/*  213 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getHurtSound() {
/*  221 */     return "orespawn:alo_hurt";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDeathSound() {
/*  229 */     return "orespawn:godzilla_death";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundVolume() {
/*  236 */     return 1.65F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundPitch() {
/*  243 */     return 1.1F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/*  252 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void jump() {
/*  260 */     for (; this.rotationYaw < 0.0F; this.rotationYaw += 360.0F);
/*  261 */     for (; this.rotationYawHead < 0.0F; this.rotationYawHead += 360.0F);
/*  262 */     for (; this.rotationYaw > 360.0F; this.rotationYaw -= 360.0F);
/*  263 */     for (; this.rotationYawHead > 360.0F; this.rotationYawHead -= 360.0F);
/*      */     
/*  265 */     this.motionY += 0.44999998807907104D;
/*  266 */     this.posY += 0.5D;
/*  267 */     float f = 0.2F + Math.abs(this.worldObj.rand.nextFloat() * 0.45F);
/*  268 */     this.motionX += f * Math.cos(Math.toRadians((this.rotationYawHead + 90.0F)));
/*  269 */     this.motionZ += f * Math.sin(Math.toRadians((this.rotationYawHead + 90.0F)));
/*  270 */     this.isAirBorne = true;
/*  271 */     getNavigator().setPath(null, 0.0D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void jumpAtEntity(EntityLivingBase e) {
/*  278 */     this.motionY += 1.25D;
/*  279 */     this.posY += 1.5499999523162842D;
/*  280 */     double d1 = e.posX - this.posX;
/*  281 */     double d2 = e.posZ - this.posZ;
/*  282 */     float d = (float)Math.atan2(d2, d1);
/*  283 */     float f2 = (float)(d * 180.0D / Math.PI) - 90.0F;
/*  284 */     this.rotationYaw = f2;
/*  285 */     d1 = Math.sqrt(d1 * d1 + d2 * d2);
/*  286 */     this.motionX += d1 * 0.05D * Math.cos(d);
/*  287 */     this.motionZ += d1 * 0.05D * Math.sin(d);
/*  288 */     this.isAirBorne = true;
/*  289 */     getNavigator().setPath(null, 0.0D);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private double getHorizontalDistanceSqToEntity(Entity e) {
/*  295 */     double d1 = e.posZ - this.posZ;
/*  296 */     double d2 = e.posX - this.posX;
/*  297 */     return d1 * d1 + d2 * d2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double MygetDistanceSqToEntity(Entity par1Entity) {
/*  305 */     double d0 = this.posX - par1Entity.posX;
/*  306 */     double d1 = par1Entity.posY - this.posY;
/*  307 */     double d2 = this.posZ - par1Entity.posZ;
/*  308 */     if (d1 > 0.0D && d1 < 20.0D) d1 = 0.0D; 
/*  309 */     if (d1 > 20.0D) d1 -= 10.0D; 
/*  310 */     return d0 * d0 + d1 * d1 + d2 * d2;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void updateAITasks() {
/*  315 */     EntityLivingBase e = null;
/*      */     
/*  317 */     int xzrange = 9;
/*      */ 
/*      */     
/*  320 */     if (this.isDead)
/*  321 */       return;  if (this.worldObj.isRemote)
/*  322 */       return;  this.dataWatcher.updateObject(21, Integer.valueOf(OreSpawnMain.PlayNicely));
/*      */     
/*  324 */     super.updateAITasks();
/*      */     
/*  326 */     this.ticker++;
/*  327 */     if (this.ticker > 30000) this.ticker = 0; 
/*  328 */     if (this.ticker % 100 == 0) this.stream_count = 8; 
/*  329 */     if (this.hurt_timer > 0) this.hurt_timer--; 
/*  330 */     if (this.jump_timer > 0) this.jump_timer--; 
/*  331 */     OreSpawnMain.godzilla_has_spawned = 1;
/*      */     
/*  333 */     if (this.worldObj.rand.nextInt(200) == 0) {
/*  334 */       setAttackTarget(null);
/*      */     }
/*      */     
/*  337 */     if (OreSpawnMain.PlayNicely == 0) {
/*      */       
/*  339 */       if (this.motionY < -0.95D) this.jumped = 1; 
/*  340 */       if (this.motionY < -1.5D) this.jumped = 2; 
/*  341 */       if (this.jumped != 0 && this.motionY > -0.1D) {
/*      */         
/*  343 */         double df = 1.0D;
/*  344 */         if (this.jumped == 2) df = 1.5D; 
/*  345 */         doJumpDamage(this.posX, this.posY, this.posZ, 10.0D, OreSpawnMain.Godzilla_stats.attack * df, 0);
/*  346 */         doJumpDamage(this.posX, this.posY, this.posZ, 15.0D, (OreSpawnMain.Godzilla_stats.attack / 2) * df, 0);
/*  347 */         doJumpDamage(this.posX, this.posY, this.posZ, 25.0D, (OreSpawnMain.Godzilla_stats.attack / 4) * df, 0);
/*  348 */         this.jumped = 0;
/*      */       } 
/*      */     } 
/*      */     
/*  352 */     xzrange = 12;
/*  353 */     if (getAttacking() != 0) xzrange = 16;
/*      */ 
/*      */     
/*  356 */     int k = -3 + this.ticker % 30;
/*  357 */     if (OreSpawnMain.PlayNicely == 0) {
/*  358 */       for (int i = -xzrange; i <= xzrange; i++) {
/*  359 */         for (int j = -xzrange; j <= xzrange; j++) {
/*      */           
/*  361 */           Block bid = this.worldObj.getBlock((int)this.posX + i, (int)this.posY + k, (int)this.posZ + j);
/*  362 */           if (isCrushable(bid)) {
/*  363 */             this.worldObj.setBlock((int)this.posX + i, (int)this.posY + k, (int)this.posZ + j, Blocks.air);
/*  364 */             if (this.worldObj.rand.nextInt(15) == 1) dropItemRand(Item.getItemFromBlock(bid), 1); 
/*      */           } else {
/*  366 */             if (bid == Blocks.grass && 
/*  367 */               this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock((int)this.posX + i, (int)this.posY + k, (int)this.posZ + j, Blocks.dirt);
/*      */             
/*  369 */             if (bid == Blocks.farmland && 
/*  370 */               this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock((int)this.posX + i, (int)this.posY + k, (int)this.posZ + j, Blocks.dirt);
/*      */           
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  378 */     double dx = this.posX + 16.0D * Math.sin(Math.toRadians(this.rotationYawHead));
/*  379 */     double dz = this.posZ - 16.0D * Math.cos(Math.toRadians(this.rotationYawHead));
/*  380 */     k = -3 + this.ticker % 12;
/*  381 */     if (OreSpawnMain.PlayNicely == 0) {
/*  382 */       for (int i = -xzrange; i <= xzrange; i++) {
/*  383 */         for (int j = -xzrange; j <= xzrange; j++) {
/*  384 */           Block bid = this.worldObj.getBlock((int)dx + i, (int)this.posY + k, (int)dz + j);
/*  385 */           if (isCrushable(bid)) {
/*  386 */             this.worldObj.setBlock((int)dx + i, (int)this.posY + k, (int)dz + j, Blocks.air);
/*  387 */             if (this.worldObj.rand.nextInt(15) == 1) dropItemRandAt(Item.getItemFromBlock(bid), 1, dx, dz); 
/*      */           } else {
/*  389 */             if (bid == Blocks.grass && 
/*  390 */               this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock((int)dx + i, (int)this.posY + k, (int)dz + j, Blocks.dirt);
/*      */             
/*  392 */             if (bid == Blocks.farmland && 
/*  393 */               this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock((int)dx + i, (int)this.posY + k, (int)dz + j, Blocks.dirt);
/*      */           
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*  399 */     if (OreSpawnMain.PlayNicely == 0 && 
/*  400 */       k == 0) doJumpDamage(dx, this.posY, dz, 15.0D, (OreSpawnMain.Godzilla_stats.attack / 2), 1);
/*      */ 
/*      */ 
/*      */     
/*  404 */     if (this.worldObj.rand.nextInt(5 - this.large_unknown_detected) == 1) {
/*  405 */       e = getAttackTarget();
/*  406 */       if (OreSpawnMain.PlayNicely != 0) e = null; 
/*  407 */       if (e != null) {
/*  408 */         if (!e.isEntityAlive()) {
/*  409 */           setAttackTarget(null);
/*  410 */           e = null;
/*      */         }
/*  412 */         else if (e instanceof Godzilla || e instanceof GodzillaHead) {
/*  413 */           setAttackTarget(null);
/*  414 */           e = null;
/*      */         } 
/*      */       }
/*      */       
/*  418 */       if (e == null) {
/*  419 */         e = findSomethingToAttack();
/*      */         
/*  421 */         if (this.head_found == 0)
/*      */         {
/*      */           
/*  424 */           EntityLiving newent = (EntityLiving)spawnCreature(this.worldObj, "MobzillaHead", this.posX, this.posY + 20.0D, this.posZ);
/*      */         }
/*      */       } 
/*  427 */       if (e != null) {
/*  428 */         this.wander.setBusy(1);
/*  429 */         faceEntity((Entity)e, 10.0F, 10.0F);
/*  430 */         if (this.worldObj.rand.nextInt(65) == 1 && MygetDistanceSqToEntity((Entity)e) > 300.0D) {
/*  431 */           doLightningAttack(e);
/*  432 */         } else if (this.worldObj.rand.nextInt(20 - this.large_unknown_detected * 5) == 1 && this.jump_timer == 0) {
/*  433 */           jumpAtEntity(e);
/*  434 */           this.jump_timer = 30;
/*      */         }
/*  436 */         else if (MygetDistanceSqToEntity((Entity)e) < (300.0F + e.width / 2.0F * e.width / 2.0F)) {
/*  437 */           setAttacking(1);
/*  438 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.0D);
/*      */           
/*  440 */           if (this.worldObj.rand.nextInt(4 - this.large_unknown_detected) == 0 || this.worldObj.rand.nextInt(3 - this.large_unknown_detected) == 1)
/*      */           {
/*  442 */             attackEntityAsMob((Entity)e);
/*      */           }
/*      */         } else {
/*  445 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.0D);
/*  446 */           if (getHorizontalDistanceSqToEntity((Entity)e) > 625.0D) {
/*      */             
/*  448 */             if (this.stream_count > 0) {
/*  449 */               setAttacking(1);
/*      */ 
/*      */               
/*  452 */               double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/*  453 */               double rhdir = Math.toRadians(((this.rotationYawHead + 90.0F) % 360.0F));
/*      */               
/*  455 */               double pi = 3.1415926545D;
/*      */               
/*  457 */               double rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/*  458 */               if (rdd > pi) rdd -= pi * 2.0D; 
/*  459 */               rdd = Math.abs(rdd);
/*      */               
/*  461 */               if (rdd < 0.5D) {
/*  462 */                 firecanon(e);
/*      */               }
/*      */             } else {
/*  465 */               setAttacking(0);
/*      */             } 
/*      */           } else {
/*  468 */             setAttacking(0);
/*      */           }
/*      */         
/*      */         } 
/*      */       } else {
/*      */         
/*  474 */         setAttacking(0);
/*  475 */         this.wander.setBusy(0);
/*  476 */         this.stream_count = 8;
/*      */       } 
/*      */     } 
/*      */     
/*  480 */     if (this.worldObj.rand.nextInt(35) == 1 && 
/*  481 */       getHealth() < mygetMaxHealth())
/*      */     {
/*  483 */       heal(5.0F);
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
/*      */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/*  495 */     Entity var8 = null;
/*  496 */     var8 = EntityList.createEntityByName(par1, par0World);
/*  497 */     if (var8 != null) {
/*      */ 
/*      */       
/*  500 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*      */ 
/*      */       
/*  503 */       par0World.spawnEntityInWorld(var8);
/*      */     } 
/*  505 */     return var8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/*  515 */     if (par1EntityLiving == null)
/*      */     {
/*  517 */       return false;
/*      */     }
/*  519 */     if (par1EntityLiving == this)
/*      */     {
/*  521 */       return false;
/*      */     }
/*  523 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/*  525 */       return false;
/*      */     }
/*      */     
/*  528 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*      */     
/*  530 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*      */       
/*  533 */       return false;
/*      */     }
/*  535 */     if (par1EntityLiving instanceof Godzilla)
/*      */     {
/*  537 */       return false;
/*      */     }
/*  539 */     if (par1EntityLiving instanceof GodzillaHead)
/*      */     {
/*  541 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  545 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCreeper)
/*      */     {
/*  547 */       return false;
/*      */     }
/*  549 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityZombie)
/*      */     {
/*  551 */       return false;
/*      */     }
/*  553 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntitySpider)
/*      */     {
/*  555 */       return false;
/*      */     }
/*  557 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntitySkeleton)
/*      */     {
/*  559 */       return false;
/*      */     }
/*  561 */     if (par1EntityLiving instanceof Ghost)
/*      */     {
/*  563 */       return false;
/*      */     }
/*  565 */     if (par1EntityLiving instanceof GhostSkelly)
/*      */     {
/*  567 */       return false;
/*      */     }
/*  569 */     if (par1EntityLiving instanceof EntityPlayer) {
/*      */       
/*  571 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/*  572 */       if (p.capabilities.isCreativeMode == true) {
/*  573 */         return false;
/*      */       }
/*      */     } 
/*      */     
/*  577 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isVillagerTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/*  586 */     if (par1EntityLiving == null)
/*      */     {
/*  588 */       return false;
/*      */     }
/*  590 */     if (par1EntityLiving == this)
/*      */     {
/*  592 */       return false;
/*      */     }
/*  594 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/*  596 */       return false;
/*      */     }
/*  598 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*      */       
/*  601 */       return false;
/*      */     }
/*      */     
/*  604 */     if (par1EntityLiving instanceof net.minecraft.entity.passive.EntityVillager)
/*      */     {
/*  606 */       return true;
/*      */     }
/*      */     
/*  609 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private EntityLivingBase doJumpDamage(double X, double Y, double Z, double dist, double damage, int knock) {
/*  614 */     AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(X - dist, Y - 10.0D, Z - dist, X + dist, Y + 10.0D, Z + dist);
/*  615 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
/*  616 */     Collections.sort(var5, this.TargetSorter);
/*  617 */     Iterator<?> var2 = var5.iterator();
/*  618 */     Entity var3 = null;
/*  619 */     EntityLivingBase var4 = null;
/*      */     
/*  621 */     while (var2.hasNext()) {
/*      */       
/*  623 */       var3 = (Entity)var2.next();
/*  624 */       var4 = (EntityLivingBase)var3;
/*      */ 
/*      */ 
/*      */       
/*  628 */       if (var4 == null) {
/*      */         continue;
/*      */       }
/*      */       
/*  632 */       if (var4 == this) {
/*      */         continue;
/*      */       }
/*      */       
/*  636 */       if (!var4.isEntityAlive()) {
/*      */         continue;
/*      */       }
/*      */       
/*  640 */       if (var4 instanceof Godzilla) {
/*      */         continue;
/*      */       }
/*  643 */       if (var4 instanceof GodzillaHead) {
/*      */         continue;
/*      */       }
/*  646 */       if (var4 instanceof Ghost || 
/*  647 */         var4 instanceof GhostSkelly)
/*      */         continue; 
/*  649 */       DamageSource var21 = null;
/*  650 */       var21 = DamageSource.setExplosionSource(null);
/*  651 */       var21.setExplosion();
/*  652 */       var4.attackEntityFrom(var21, (float)damage / 2.0F);
/*  653 */       var4.attackEntityFrom(DamageSource.fall, (float)damage / 2.0F);
/*  654 */       this.worldObj.playSoundAtEntity((Entity)var4, "random.explode", 0.85F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5F);
/*  655 */       if (knock != 0) {
/*  656 */         double ks = 3.5D;
/*  657 */         double inair = 0.75D;
/*  658 */         float f3 = (float)Math.atan2(var4.posZ - this.posZ, var4.posX - this.posX);
/*  659 */         var4.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*      */       } 
/*      */     } 
/*      */     
/*  663 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private EntityLivingBase findSomethingToAttack() {
/*  670 */     if (OreSpawnMain.PlayNicely != 0) {
/*  671 */       this.head_found = 1;
/*  672 */       return null;
/*      */     } 
/*  674 */     List<?> var5 = null;
/*  675 */     Iterator<?> var2 = null;
/*  676 */     Entity var3 = null;
/*  677 */     EntityLivingBase var4 = null;
/*  678 */     EntityLivingBase ret = null;
/*  679 */     int vf = 0;
/*      */     
/*  681 */     var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(64.0D, 40.0D, 64.0D));
/*  682 */     if (var5 == null) return null; 
/*  683 */     Collections.sort(var5, this.TargetSorter);
/*  684 */     var2 = var5.iterator();
/*      */     
/*  686 */     this.head_found = 0;
/*  687 */     while (var2.hasNext()) {
/*      */       
/*  689 */       var3 = (Entity)var2.next();
/*  690 */       var4 = (EntityLivingBase)var3;
/*      */       
/*  692 */       if (var4 instanceof GodzillaHead) {
/*  693 */         this.head_found = 1;
/*      */       }
/*  695 */       if (vf == 0 && isVillagerTarget(var4, false)) {
/*      */         
/*  697 */         ret = var4;
/*  698 */         vf = 1;
/*      */       } 
/*      */       
/*  701 */       if (ret == null && vf == 0 && isSuitableTarget(var4, false))
/*      */       {
/*  703 */         ret = var4;
/*      */       }
/*      */     } 
/*      */     
/*  707 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanSpawnHere() {
/*  715 */     if (!isValidLightLevel()) return false; 
/*  716 */     if (this.worldObj.isDaytime() == true) return false; 
/*  717 */     if (this.posY < 50.0D) return false;
/*      */     
/*  719 */     if (OreSpawnMain.godzilla_has_spawned != 0) return false; 
/*  720 */     if (this.worldObj.rand.nextInt(40) != 1) return false;
/*      */ 
/*      */     
/*  723 */     for (int k = -8; k <= 8; k++) {
/*      */       
/*  725 */       for (int j = -8; j <= 8; j++) {
/*      */         
/*  727 */         for (int i = 5; i < 15; i++) {
/*      */           
/*  729 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/*  730 */           if (bid != Blocks.air) return false;
/*      */         
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  736 */     Godzilla target = null;
/*  737 */     target = (Godzilla)this.worldObj.findNearestEntityWithinAABB(Godzilla.class, this.boundingBox.expand(64.0D, 16.0D, 64.0D), (Entity)this);
/*  738 */     if (target != null)
/*      */     {
/*  740 */       return false;
/*      */     }
/*  742 */     if (!this.worldObj.isRemote) OreSpawnMain.godzilla_has_spawned = 1; 
/*  743 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public final int getAttacking() {
/*  748 */     return this.dataWatcher.getWatchableObjectByte(20);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void setAttacking(int par1) {
/*  753 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*      */   }
/*      */ 
/*      */   
/*      */   private ItemStack dropItemRand(Item index, int par1) {
/*  758 */     EntityItem var3 = null;
/*  759 */     ItemStack is = new ItemStack(index, par1, 0);
/*  760 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(10) - OreSpawnMain.OreSpawnRand.nextInt(10), this.posY + 4.0D + this.worldObj.rand.nextInt(10), this.posZ + OreSpawnMain.OreSpawnRand.nextInt(10) - OreSpawnMain.OreSpawnRand.nextInt(10), is);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  765 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/*  766 */     return is;
/*      */   }
/*      */ 
/*      */   
/*      */   private ItemStack dropItemRandAt(Item index, int par1, double dx, double dz) {
/*  771 */     EntityItem var3 = null;
/*  772 */     ItemStack is = new ItemStack(index, par1, 0);
/*  773 */     var3 = new EntityItem(this.worldObj, dx + OreSpawnMain.OreSpawnRand.nextInt(10) - OreSpawnMain.OreSpawnRand.nextInt(10), this.posY + 4.0D + this.worldObj.rand.nextInt(6), dz + OreSpawnMain.OreSpawnRand.nextInt(10) - OreSpawnMain.OreSpawnRand.nextInt(10), is);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  778 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/*  779 */     return is;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isCrushable(Block bid) {
/*  847 */     if (bid == null) return false; 
/*  848 */     if (!this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) return false; 
/*  849 */     if (bid == Blocks.grass) return false; 
/*  850 */     if (bid == Blocks.dirt) return false; 
/*  851 */     if (bid == Blocks.stone) return false; 
/*  852 */     if (bid == Blocks.farmland) return false; 
/*  853 */     if (bid == Blocks.water) return false; 
/*  854 */     if (bid == Blocks.flowing_water) return false; 
/*  855 */     if (bid == Blocks.lava) return false; 
/*  856 */     if (bid == Blocks.flowing_lava) return false; 
/*  857 */     if (bid == Blocks.bedrock) return false; 
/*  858 */     if (bid == Blocks.obsidian) return false; 
/*  859 */     if (bid == Blocks.sand) return false; 
/*  860 */     if (bid == Blocks.gravel) return false; 
/*  861 */     if (bid == Blocks.iron_block) return false; 
/*  862 */     if (bid == Blocks.diamond_block) return false; 
/*  863 */     if (bid == Blocks.emerald_block) return false; 
/*  864 */     if (bid == Blocks.gold_block) return false; 
/*  865 */     if (bid == Blocks.netherrack) return false; 
/*  866 */     if (bid == Blocks.end_stone) return false;
/*      */     
/*  868 */     if (bid == OreSpawnMain.MyBlockAmethystBlock) return false; 
/*  869 */     if (bid == OreSpawnMain.MyBlockRubyBlock) return false; 
/*  870 */     if (bid == OreSpawnMain.MyBlockUraniumBlock) return false; 
/*  871 */     if (bid == OreSpawnMain.MyBlockTitaniumBlock) return false; 
/*  872 */     if (bid == OreSpawnMain.CrystalStone) return false; 
/*  873 */     if (bid == OreSpawnMain.CrystalGrass) return false;
/*      */     
/*  875 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private void firecanon(EntityLivingBase e) {
/*  880 */     double yoff = 19.0D;
/*  881 */     double xzoff = 22.0D;
/*      */ 
/*      */     
/*  884 */     BetterFireball bf = null;
/*      */     
/*  886 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/*  887 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*  888 */     if (this.stream_count > 0) {
/*      */ 
/*      */ 
/*      */       
/*  892 */       bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, e.posX - cx, e.posY + (e.height / 2.0F) - this.posY + yoff, e.posZ - cz);
/*  893 */       bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/*  894 */       bf.setPosition(cx, this.posY + yoff, cz);
/*  895 */       bf.setBig();
/*  896 */       this.worldObj.playSoundAtEntity((Entity)this, "random.fuse", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*  897 */       this.worldObj.spawnEntityInWorld((Entity)bf);
/*  898 */       for (int i = 0; i < 5; i++) {
/*  899 */         float r1 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/*  900 */         float r2 = 3.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/*  901 */         float r3 = 5.0F * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/*  902 */         bf = new BetterFireball(this.worldObj, (EntityLivingBase)this, e.posX - cx + r1, e.posY + (e.height / 2.0F) - this.posY + yoff + r2, e.posZ - cz + r3);
/*  903 */         bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/*  904 */         bf.setPosition(cx, this.posY + yoff, cz);
/*  905 */         if (this.worldObj.rand.nextInt(2) == 1) bf.setSmall(); 
/*  906 */         this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*  907 */         this.worldObj.spawnEntityInWorld((Entity)bf);
/*      */       } 
/*  909 */       this.stream_count--;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  916 */     if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*      */       
/*  918 */       float s = par1Entity.height * par1Entity.width;
/*  919 */       if (s > 30.0F && 
/*  920 */         !MyUtils.isRoyalty(par1Entity) && !(par1Entity instanceof Godzilla) && !(par1Entity instanceof GodzillaHead) && !(par1Entity instanceof PitchBlack) && !(par1Entity instanceof Kraken)) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  925 */         EntityLivingBase e = (EntityLivingBase)par1Entity;
/*  926 */         e.setHealth(e.getHealth() / 2.0F);
/*  927 */         e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), OreSpawnMain.Godzilla_stats.attack * 10.0F);
/*  928 */         this.large_unknown_detected = 1;
/*      */       } 
/*      */     } 
/*      */     
/*  932 */     if (par1Entity != null && par1Entity instanceof EntityDragon) {
/*  933 */       EntityDragon dr = (EntityDragon)par1Entity;
/*  934 */       DamageSource var21 = null;
/*  935 */       var21 = DamageSource.setExplosionSource(null);
/*  936 */       var21.setExplosion();
/*  937 */       if (this.worldObj.rand.nextInt(6) == 1) {
/*  938 */         dr.attackEntityFromPart(dr.dragonPartHead, var21, OreSpawnMain.Godzilla_stats.attack / 2.0F);
/*      */       } else {
/*  940 */         dr.attackEntityFromPart(dr.dragonPartBody, var21, OreSpawnMain.Godzilla_stats.attack / 2.0F);
/*      */       } 
/*      */     } 
/*  943 */     if (super.attackEntityAsMob(par1Entity)) {
/*      */       
/*  945 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*      */         
/*  947 */         double ks = 3.2D;
/*  948 */         double inair = 0.3D;
/*  949 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/*  950 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/*  951 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*      */       } 
/*  953 */       return true;
/*      */     } 
/*      */ 
/*      */     
/*  957 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  966 */     boolean ret = false;
/*  967 */     float dm = par2;
/*  968 */     float s = 0.0F;
/*  969 */     if (this.hurt_timer > 0) return false; 
/*  970 */     if (dm > 750.0F) dm = 750.0F;
/*      */     
/*  972 */     Entity e = par1DamageSource.getEntity();
/*  973 */     if (e != null && e instanceof EntityLivingBase) {
/*      */       
/*  975 */       EntityLivingBase enl = (EntityLivingBase)e;
/*  976 */       s = enl.height * enl.width;
/*  977 */       if (s > 30.0F && 
/*  978 */         !MyUtils.isRoyalty((Entity)enl) && !(enl instanceof Godzilla) && !(enl instanceof GodzillaHead) && !(enl instanceof PitchBlack) && !(enl instanceof Kraken)) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  983 */         dm /= 10.0F;
/*  984 */         this.hurt_timer = 50;
/*  985 */         this.large_unknown_detected = 1;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  990 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*  991 */       ret = super.attackEntityFrom(par1DamageSource, dm);
/*  992 */       this.hurt_timer = 20;
/*      */       
/*  994 */       e = par1DamageSource.getEntity();
/*  995 */       if (e != null && e instanceof EntityLivingBase)
/*      */       {
/*  997 */         if (!(e instanceof GodzillaHead) && !(e instanceof Godzilla)) {
/*  998 */           setAttackTarget((EntityLivingBase)e);
/*  999 */           setTarget(e);
/* 1000 */           getNavigator().tryMoveToEntityLiving(e, 1.2D);
/*      */         } 
/*      */       }
/*      */     } 
/* 1004 */     return ret;
/*      */   }
/*      */ 
/*      */   
/*      */   public void onStruckByLightning(EntityLightningBolt par1EntityLightningBolt) {}
/*      */ 
/*      */   
/*      */   private void doLightningAttack(EntityLivingBase e) {
/* 1012 */     if (e == null)
/* 1013 */       return;  float var2 = 100.0F;
/* 1014 */     e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2);
/* 1015 */     e.setFire(5);
/* 1016 */     for (int var3 = 0; var3 < 20; var3++) {
/*      */       
/* 1018 */       this.worldObj.spawnParticle("smoke", e.posX + this.rand.nextFloat() - this.rand.nextFloat(), e.posY + this.rand.nextFloat() - this.rand.nextFloat(), e.posZ + this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
/* 1019 */       this.worldObj.spawnParticle("largesmoke", e.posX + this.rand.nextFloat() - this.rand.nextFloat(), e.posY + this.rand.nextFloat() - this.rand.nextFloat(), e.posZ + this.rand.nextFloat() - this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
/* 1020 */       this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
/*      */     } 
/*      */     
/* 1023 */     this.worldObj.playSoundAtEntity((Entity)e, "random.explode", 0.5F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5F);
/*      */     
/* 1025 */     if (!this.worldObj.isRemote) this.worldObj.createExplosion((Entity)this, e.posX, e.posY, e.posZ, 3.0F, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
/*      */     
/* 1027 */     this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, e.posX, e.posY + 1.0D, e.posZ));
/* 1028 */     this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, this.posX, this.posY + 15.0D, this.posZ));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/* 1035 */     ItemStack is = null;
/*      */ 
/*      */     
/* 1038 */     dropItemRand(Items.item_frame, 1);
/*      */     
/* 1040 */     int var5 = 50 + this.worldObj.rand.nextInt(30); int var4;
/* 1041 */     for (var4 = 0; var4 < var5; var4++) {
/* 1042 */       dropItemRand(OreSpawnMain.MyGodzillaScale, 1);
/*      */     }
/* 1044 */     var5 = 100 + this.worldObj.rand.nextInt(160);
/* 1045 */     for (var4 = 0; var4 < var5; var4++) {
/* 1046 */       dropItemRand(Items.beef, 1);
/*      */     }
/* 1048 */     var5 = 50 + this.worldObj.rand.nextInt(60);
/* 1049 */     for (var4 = 0; var4 < var5; var4++) {
/* 1050 */       dropItemRand(Items.bone, 1);
/*      */     }
/*      */ 
/*      */     
/* 1054 */     int i = 25 + this.worldObj.rand.nextInt(15);
/* 1055 */     for (var4 = 0; var4 < i; var4++) {
/* 1056 */       EntityItem var33; int var3 = this.worldObj.rand.nextInt(80);
/* 1057 */       switch (var3) {
/*      */         case 0:
/* 1059 */           is = dropItemRand(OreSpawnMain.MyUltimateSword, 1);
/*      */           break;
/*      */         case 1:
/* 1062 */           is = dropItemRand(Items.diamond, 1);
/*      */           break;
/*      */         case 2:
/* 1065 */           is = dropItemRand(Item.getItemFromBlock(Blocks.diamond_block), 1);
/*      */           break;
/*      */         case 3:
/* 1068 */           is = dropItemRand(Items.diamond_sword, 1);
/* 1069 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/* 1070 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/* 1071 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/* 1072 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/* 1073 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1074 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/* 1075 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 4:
/* 1078 */           is = dropItemRand(Items.diamond_shovel, 1);
/* 1079 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1080 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 5:
/* 1083 */           is = dropItemRand(Items.diamond_pickaxe, 1);
/* 1084 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1085 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/* 1086 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 6:
/* 1089 */           is = dropItemRand(Items.diamond_axe, 1);
/* 1090 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1091 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 7:
/* 1094 */           is = dropItemRand(Items.diamond_hoe, 1);
/* 1095 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1096 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 8:
/* 1099 */           is = dropItemRand((Item)Items.diamond_helmet, 1);
/* 1100 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1101 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1102 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1103 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1104 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1105 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2)); 
/* 1106 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 9:
/* 1109 */           is = dropItemRand((Item)Items.diamond_chestplate, 1);
/* 1110 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1111 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1112 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1113 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1114 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 10:
/* 1117 */           is = dropItemRand((Item)Items.diamond_leggings, 1);
/* 1118 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1119 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1120 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1121 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1122 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 11:
/* 1125 */           is = dropItemRand((Item)Items.diamond_boots, 1);
/* 1126 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/* 1127 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 12:
/* 1130 */           is = dropItemRand(OreSpawnMain.MyUltimateBow, 1);
/*      */           break;
/*      */         case 13:
/* 1133 */           is = dropItemRand(OreSpawnMain.MyUltimateAxe, 1);
/*      */           break;
/*      */         case 14:
/* 1136 */           is = dropItemRand(Items.iron_ingot, 1);
/*      */           break;
/*      */         case 15:
/* 1139 */           is = dropItemRand(OreSpawnMain.MyUltimatePickaxe, 1);
/*      */           break;
/*      */         case 16:
/* 1142 */           is = dropItemRand(Items.iron_sword, 1);
/* 1143 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/* 1144 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/* 1145 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/* 1146 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/* 1147 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1148 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/* 1149 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 17:
/* 1152 */           is = dropItemRand(Items.iron_shovel, 1);
/* 1153 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1154 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 18:
/* 1157 */           is = dropItemRand(Items.iron_pickaxe, 1);
/* 1158 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1159 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/* 1160 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 19:
/* 1163 */           is = dropItemRand(Items.iron_axe, 1);
/* 1164 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1165 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 20:
/* 1168 */           is = dropItemRand(Items.iron_hoe, 1);
/* 1169 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1170 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 21:
/* 1173 */           is = dropItemRand((Item)Items.iron_helmet, 1);
/* 1174 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1175 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1176 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1177 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1178 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1179 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5)); 
/* 1180 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 22:
/* 1183 */           is = dropItemRand((Item)Items.iron_chestplate, 1);
/* 1184 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1185 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1186 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1187 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1188 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 23:
/* 1191 */           is = dropItemRand((Item)Items.iron_leggings, 1);
/* 1192 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1193 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1194 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1195 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1196 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 24:
/* 1199 */           is = dropItemRand((Item)Items.iron_boots, 1);
/* 1200 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/* 1201 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 25:
/* 1204 */           is = dropItemRand(OreSpawnMain.MyUltimateShovel, 1);
/*      */           break;
/*      */         case 26:
/* 1207 */           dropItemRand(Item.getItemFromBlock(Blocks.iron_block), 1);
/*      */           break;
/*      */         case 27:
/* 1210 */           is = dropItemRand(Items.gold_nugget, 1);
/*      */           break;
/*      */         case 28:
/* 1213 */           is = dropItemRand(Items.gold_ingot, 1);
/*      */           break;
/*      */         case 29:
/* 1216 */           is = dropItemRand(Items.golden_carrot, 1);
/*      */           break;
/*      */         case 30:
/* 1219 */           is = dropItemRand(Items.golden_sword, 1);
/* 1220 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/* 1221 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/* 1222 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/* 1223 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/* 1224 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1225 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/* 1226 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 31:
/* 1229 */           is = dropItemRand(Items.golden_shovel, 1);
/* 1230 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1231 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 32:
/* 1234 */           is = dropItemRand(Items.golden_pickaxe, 1);
/* 1235 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1236 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/* 1237 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 33:
/* 1240 */           is = dropItemRand(Items.golden_axe, 1);
/* 1241 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1242 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 34:
/* 1245 */           is = dropItemRand(Items.golden_hoe, 1);
/* 1246 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1247 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 35:
/* 1250 */           is = dropItemRand((Item)Items.golden_helmet, 1);
/* 1251 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1252 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1253 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1254 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1255 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1256 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5)); 
/* 1257 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 36:
/* 1260 */           is = dropItemRand((Item)Items.golden_chestplate, 1);
/* 1261 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1262 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1263 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1264 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1265 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 37:
/* 1268 */           is = dropItemRand((Item)Items.golden_leggings, 1);
/* 1269 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1270 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1271 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1272 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1273 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 38:
/* 1276 */           is = dropItemRand((Item)Items.golden_boots, 1);
/* 1277 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/* 1278 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 39:
/* 1281 */           dropItemRand(Items.golden_apple, 1);
/*      */           break;
/*      */         case 40:
/* 1284 */           dropItemRand(Item.getItemFromBlock(Blocks.gold_block), 1);
/*      */           break;
/*      */         
/*      */         case 41:
/* 1288 */           var33 = null;
/* 1289 */           is = new ItemStack(Items.golden_apple, 1, 1);
/* 1290 */           var33 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), is);
/*      */           
/* 1292 */           if (var33 != null) this.worldObj.spawnEntityInWorld((Entity)var33);
/*      */           
/*      */           break;
/*      */         case 42:
/* 1296 */           is = dropItemRand(OreSpawnMain.MyExperienceSword, 1);
/* 1297 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/* 1298 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/* 1299 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/* 1300 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/* 1301 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1302 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/* 1303 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 43:
/* 1306 */           is = dropItemRand((Item)OreSpawnMain.ExperienceHelmet, 1);
/* 1307 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1308 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1309 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1310 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1311 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1312 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5)); 
/* 1313 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 44:
/* 1316 */           is = dropItemRand((Item)OreSpawnMain.ExperienceBody, 1);
/* 1317 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1318 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1319 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1320 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1321 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 45:
/* 1324 */           is = dropItemRand((Item)OreSpawnMain.ExperienceLegs, 1);
/* 1325 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1326 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1327 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1328 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1329 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 46:
/* 1332 */           is = dropItemRand((Item)OreSpawnMain.ExperienceBoots, 1);
/* 1333 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/* 1334 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 47:
/* 1337 */           is = dropItemRand(OreSpawnMain.MyAmethystSword, 1);
/* 1338 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/* 1339 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/* 1340 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/* 1341 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/* 1342 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1343 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/* 1344 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 48:
/* 1347 */           is = dropItemRand(OreSpawnMain.MyAmethystShovel, 1);
/* 1348 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1349 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 49:
/* 1352 */           is = dropItemRand(OreSpawnMain.MyAmethystPickaxe, 1);
/* 1353 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1354 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/* 1355 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 50:
/* 1358 */           is = dropItemRand(OreSpawnMain.MyAmethystAxe, 1);
/* 1359 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1360 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 51:
/* 1363 */           is = dropItemRand(OreSpawnMain.MyAmethystHoe, 1);
/* 1364 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1365 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 52:
/* 1368 */           is = dropItemRand(Item.getItemFromBlock(OreSpawnMain.MyBlockAmethystBlock), 1);
/*      */           break;
/*      */         case 53:
/* 1371 */           is = dropItemRand((Item)OreSpawnMain.AmethystHelmet, 1);
/* 1372 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1373 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1374 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1375 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1376 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1377 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5)); 
/* 1378 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 54:
/* 1381 */           is = dropItemRand((Item)OreSpawnMain.AmethystBody, 1);
/* 1382 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1383 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1384 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1385 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1386 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 55:
/* 1389 */           is = dropItemRand((Item)OreSpawnMain.AmethystLegs, 1);
/* 1390 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1391 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1392 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1393 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1394 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 56:
/* 1397 */           is = dropItemRand((Item)OreSpawnMain.AmethystBoots, 1);
/* 1398 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/* 1399 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 57:
/* 1402 */           is = dropItemRand((Item)OreSpawnMain.RubyHelmet, 1);
/* 1403 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1404 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1405 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1406 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1407 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1408 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5)); 
/* 1409 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 58:
/* 1412 */           is = dropItemRand((Item)OreSpawnMain.RubyBody, 1);
/* 1413 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1414 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1415 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1416 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1417 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 59:
/* 1420 */           is = dropItemRand((Item)OreSpawnMain.RubyLegs, 1);
/* 1421 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1422 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1423 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1424 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1425 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 60:
/* 1428 */           is = dropItemRand((Item)OreSpawnMain.RubyBoots, 1);
/* 1429 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/* 1430 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 61:
/* 1433 */           is = dropItemRand(OreSpawnMain.MyRubySword, 1);
/* 1434 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/* 1435 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/* 1436 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/* 1437 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/* 1438 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1439 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/* 1440 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 62:
/* 1443 */           is = dropItemRand(OreSpawnMain.MyRubyShovel, 1);
/* 1444 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1445 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 63:
/* 1448 */           is = dropItemRand(OreSpawnMain.MyRubyPickaxe, 1);
/* 1449 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1450 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/* 1451 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 64:
/* 1454 */           is = dropItemRand(OreSpawnMain.MyRubyAxe, 1);
/* 1455 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1456 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 65:
/* 1459 */           is = dropItemRand(OreSpawnMain.MyRubyHoe, 1);
/* 1460 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1461 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 66:
/* 1464 */           is = dropItemRand(Item.getItemFromBlock(OreSpawnMain.MyBlockRubyBlock), 1);
/*      */           break;
/*      */         case 67:
/* 1467 */           is = dropItemRand((Item)OreSpawnMain.UltimateHelmet, 1);
/* 1468 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1469 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1470 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1471 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1472 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1473 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5)); 
/* 1474 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 68:
/* 1477 */           is = dropItemRand((Item)OreSpawnMain.UltimateBody, 1);
/* 1478 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1479 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1480 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1481 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1482 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 69:
/* 1485 */           is = dropItemRand((Item)OreSpawnMain.UltimateLegs, 1);
/* 1486 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1487 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1488 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1489 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 1490 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 70:
/* 1493 */           is = dropItemRand((Item)OreSpawnMain.UltimateBoots, 1);
/* 1494 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/* 1495 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*      */           break;
/*      */         case 71:
/* 1498 */           is = dropItemRand(OreSpawnMain.MyUltimateShovel, 1);
/* 1499 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1500 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 73:
/* 1503 */           is = dropItemRand(OreSpawnMain.MyUltimatePickaxe, 1);
/* 1504 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1505 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/* 1506 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 74:
/* 1509 */           is = dropItemRand(OreSpawnMain.MyUltimateAxe, 1);
/* 1510 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1511 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */         case 75:
/* 1514 */           is = dropItemRand(OreSpawnMain.MyUltimateHoe, 1);
/* 1515 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 1516 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*      */           break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Godzilla.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */