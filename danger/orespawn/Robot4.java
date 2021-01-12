/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ public class Robot4
/*     */   extends EntityMob
/*     */ {
/*  57 */   private GenericTargetSorter TargetSorter = null;
/*  58 */   private RenderInfo renderdata = new RenderInfo();
/*  59 */   private int reload_ticker = 0;
/*  60 */   private int was_attacked_ticker = 0;
/*  61 */   private float moveSpeed = 0.34F;
/*     */ 
/*     */   
/*     */   public Robot4(World par1World) {
/*  65 */     super(par1World);
/*     */     
/*  67 */     setSize(2.5F, 4.0F);
/*  68 */     getNavigator().setAvoidsWater(true);
/*  69 */     this.experienceValue = 120;
/*  70 */     this.fireResistance = 120;
/*  71 */     this.isImmuneToFire = true;
/*  72 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  73 */     this.renderdata = new RenderInfo();
/*  74 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  75 */     this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0D));
/*  76 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.8999999761581421D, false));
/*  77 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  78 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  79 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  84 */     super.applyEntityAttributes();
/*  85 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  86 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  87 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Robot4_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  92 */     super.entityInit();
/*  93 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  94 */     this.dataWatcher.addObject(21, Byte.valueOf((byte)0));
/*  95 */     if (this.renderdata == null) {
/*  96 */       this.renderdata = new RenderInfo();
/*     */     }
/*  98 */     this.renderdata.rf1 = 0.0F;
/*  99 */     this.renderdata.rf2 = 0.0F;
/* 100 */     this.renderdata.rf3 = 0.0F;
/* 101 */     this.renderdata.rf4 = 0.0F;
/* 102 */     this.renderdata.ri1 = 0;
/* 103 */     this.renderdata.ri2 = 0;
/* 104 */     this.renderdata.ri3 = 0;
/* 105 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 110 */     if (isNoDespawnRequired()) return false; 
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 119 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 120 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 125 */     return OreSpawnMain.Robot4_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRobot4Health() {
/* 131 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 138 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 143 */     this.renderdata.rf1 = r.rf1;
/* 144 */     this.renderdata.rf2 = r.rf2;
/* 145 */     this.renderdata.rf3 = r.rf3;
/* 146 */     this.renderdata.rf4 = r.rf4;
/* 147 */     this.renderdata.ri1 = r.ri1;
/* 148 */     this.renderdata.ri2 = r.ri2;
/* 149 */     this.renderdata.ri3 = r.ri3;
/* 150 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 158 */     return OreSpawnMain.Robot4_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 166 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void jump() {
/* 172 */     this.motionY += 0.25D;
/* 173 */     super.jump();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 182 */     super.onLivingUpdate();
/*     */     
/* 184 */     if (this.worldObj.isRemote) {
/* 185 */       if (this.rand.nextInt(3) == 1) {
/* 186 */         this.worldObj.spawnParticle("smoke", this.posX - 1.25D * Math.sin(Math.toRadians((this.rotationYaw + 180.0F))), this.posY + 3.0D + this.worldObj.rand.nextFloat(), this.posZ + 1.25D * Math.cos(Math.toRadians((this.rotationYaw + 180.0F))), 0.0D, this.worldObj.rand.nextFloat() / 2.0D, 0.0D);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 191 */       if (getAttacking() != 0) {
/* 192 */         this.worldObj.spawnParticle("reddust", this.posX - 1.55D * Math.sin(Math.toRadians((this.rotationYaw + 35.0F))), this.posY + 2.25D + this.worldObj.rand.nextFloat(), this.posZ + 1.55D * Math.cos(Math.toRadians((this.rotationYaw + 35.0F))), 0.0D, this.worldObj.rand.nextFloat(), 0.0D);
/*     */       }
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
/*     */ 
/*     */   
/*     */   public int getAttackStrength(Entity par1Entity) {
/* 207 */     int var2 = 0;
/* 208 */     if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
/*     */       
/* 210 */       var2 = 15;
/* 211 */       if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
/*     */         
/* 213 */         var2 = 20;
/*     */       }
/* 215 */       else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
/*     */         
/* 217 */         var2 = 25;
/*     */       } 
/*     */     } 
/* 220 */     return var2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 228 */     if (this.rand.nextInt(4) == 0) {
/* 229 */       return "orespawn:robot_living";
/*     */     }
/* 231 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 239 */     return "orespawn:robot_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 247 */     return "orespawn:robot_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 254 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 261 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 269 */     return Items.quartz;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 275 */     EntityItem var3 = null;
/* 276 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 278 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
/*     */     
/* 280 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 281 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 289 */     ItemStack is = null;
/*     */ 
/*     */     
/* 292 */     int var5 = 5 + this.worldObj.rand.nextInt(10); int var4;
/* 293 */     for (var4 = 0; var4 < var5; var4++) {
/* 294 */       dropItemRand(OreSpawnMain.MyLaserBall, 4);
/*     */     }
/*     */     
/* 297 */     dropItemRand(OreSpawnMain.MyRayGun, 1);
/* 298 */     dropItemRand(Items.item_frame, 1);
/*     */     
/* 300 */     int i = 10 + this.worldObj.rand.nextInt(15);
/* 301 */     for (var4 = 0; var4 < i; var4++) {
/* 302 */       int var3 = this.worldObj.rand.nextInt(15);
/* 303 */       switch (var3) {
/*     */         case 0:
/* 305 */           is = dropItemRand(Items.redstone, 1);
/*     */           break;
/*     */         case 1:
/* 308 */           is = dropItemRand(Items.repeater, 1);
/*     */           break;
/*     */         case 2:
/* 311 */           is = dropItemRand(Items.comparator, 1);
/*     */           break;
/*     */         case 3:
/* 314 */           is = dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
/*     */           break;
/*     */         case 4:
/* 317 */           is = dropItemRand(Item.getItemFromBlock(Blocks.dispenser), 1);
/*     */           break;
/*     */         case 5:
/* 320 */           is = dropItemRand(Item.getItemFromBlock((Block)Blocks.sticky_piston), 1);
/*     */           break;
/*     */         case 6:
/* 323 */           is = dropItemRand(Item.getItemFromBlock((Block)Blocks.piston), 1);
/*     */           break;
/*     */         case 7:
/* 326 */           is = dropItemRand(Item.getItemFromBlock(Blocks.lever), 1);
/*     */           break;
/*     */         case 8:
/* 329 */           is = dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
/*     */           break;
/*     */         case 9:
/* 332 */           is = dropItemRand(Item.getItemFromBlock(Blocks.light_weighted_pressure_plate), 1);
/*     */           break;
/*     */       } 
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
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 346 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 354 */     if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */       
/* 356 */       double ks = 2.0D;
/* 357 */       double inair = 0.12D;
/* 358 */       float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 359 */       if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 360 */       par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */     } 
/* 362 */     return super.attackEntityAsMob(par1Entity);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 367 */     if (this.isDead)
/* 368 */       return;  super.updateAITasks();
/* 369 */     if (this.reload_ticker > 0) {
/* 370 */       this.reload_ticker--;
/*     */     }
/* 372 */     if (this.was_attacked_ticker > 0) {
/* 373 */       this.was_attacked_ticker--;
/*     */     }
/* 375 */     if (this.reload_ticker == 0 && this.worldObj.rand.nextInt(8) == 1) {
/* 376 */       EntityLivingBase e = null;
/* 377 */       if (this.worldObj.rand.nextInt(50) == 1) setAttackTarget(null); 
/* 378 */       e = getAttackTarget();
/* 379 */       if (e != null && !e.isEntityAlive()) {
/* 380 */         setAttackTarget(null);
/* 381 */         e = null;
/*     */       } 
/* 383 */       if (e == null) {
/* 384 */         e = findSomethingToAttack();
/*     */       }
/* 386 */       if (e != null) {
/* 387 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 388 */         if (getDistanceSqToEntity((Entity)e) < 256.0D) {
/* 389 */           if (getDistanceSqToEntity((Entity)e) < ((3.0F + e.width / 2.0F) * (3.0F + e.width / 2.0F))) {
/* 390 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */           else {
/*     */             
/* 394 */             double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/* 395 */             double rhdir = Math.toRadians(((this.rotationYawHead + 90.0F) % 360.0F));
/*     */             
/* 397 */             double pi = 3.1415926545D;
/*     */             
/* 399 */             double rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/* 400 */             if (rdd > pi) rdd -= pi * 2.0D; 
/* 401 */             rdd = Math.abs(rdd);
/*     */             
/* 403 */             if (rdd < 0.5D) {
/* 404 */               double yoff = 2.0D;
/* 405 */               double xzoff = 1.75D;
/* 406 */               LaserBall var2 = new LaserBall(this.worldObj, e.posX - this.posX, e.posY - this.posY + yoff, e.posZ - this.posZ);
/* 407 */               var2.setLocationAndAngles(this.posX - xzoff * Math.sin(Math.toRadians((this.rotationYaw + 45.0F))), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians((this.rotationYaw + 45.0F))), this.rotationYaw, this.rotationPitch);
/* 408 */               double var3 = e.posX - var2.posX;
/* 409 */               double var5 = e.posY - var2.posY;
/* 410 */               double var7 = e.posZ - var2.posZ;
/* 411 */               float var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 412 */               var2.setThrowableHeading(var3, var5 + var9, var7, 2.0F, 4.0F);
/* 413 */               if (getDistanceSqToEntity((Entity)e) > 65.0D) {
/* 414 */                 var2.setSpecial();
/* 415 */                 this.reload_ticker = 30;
/* 416 */                 this.worldObj.playSoundAtEntity((Entity)this, "fireworks.launch", 3.5F, 0.5F);
/*     */               } else {
/* 418 */                 this.reload_ticker = 10;
/* 419 */                 this.worldObj.playSoundAtEntity((Entity)this, "fireworks.launch", 2.5F, 1.0F);
/*     */               } 
/* 421 */               this.worldObj.spawnEntityInWorld((Entity)var2);
/*     */             } 
/* 423 */             setAttacking(1);
/*     */           } 
/* 425 */           getNavigator().tryMoveToEntityLiving((Entity)e, 0.75D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 430 */     if (this.reload_ticker <= 0 && this.was_attacked_ticker <= 0) {
/* 431 */       setAttacking(0);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 440 */     boolean ret = false;
/* 441 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 442 */       if (getShielding() != 0 || this.was_attacked_ticker != 0)
/*     */       {
/* 444 */         return false;
/*     */       }
/* 446 */       this.was_attacked_ticker = 65;
/* 447 */       setAttacking(1);
/* 448 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 449 */       Entity e = par1DamageSource.getEntity();
/* 450 */       if (e != null && e instanceof EntityLiving) {
/*     */         
/* 452 */         setAttackTarget((EntityLivingBase)e);
/* 453 */         setTarget(e);
/* 454 */         getNavigator().tryMoveToEntityLiving(e, 1.2D);
/* 455 */         ret = true;
/*     */       } 
/* 457 */       return ret;
/*     */     } 
/* 459 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 469 */     if (par1EntityLiving == null)
/*     */     {
/* 471 */       return false;
/*     */     }
/* 473 */     if (par1EntityLiving == this)
/*     */     {
/* 475 */       return false;
/*     */     }
/* 477 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 479 */       return false;
/*     */     }
/*     */     
/* 482 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 484 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 487 */       return false;
/*     */     }
/*     */     
/* 490 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 492 */       return false;
/*     */     }
/* 494 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 496 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 497 */       if (p.capabilities.isCreativeMode == true) {
/* 498 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 502 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 507 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 508 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0D, 4.0D, 16.0D));
/* 509 */     Collections.sort(var5, this.TargetSorter);
/* 510 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 512 */     while (var2.hasNext()) {
/*     */       
/* 514 */       Entity var3 = (Entity)var2.next();
/* 515 */       EntityLivingBase var4 = (EntityLivingBase)var3;
/*     */       
/* 517 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 519 */         return var4;
/*     */       }
/*     */     } 
/* 522 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 528 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 532 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getShielding() {
/* 537 */     return this.dataWatcher.getWatchableObjectByte(21);
/*     */   }
/*     */   
/*     */   public final void setShielding(int par1) {
/* 541 */     this.dataWatcher.updateObject(21, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/*     */     int k;
/* 553 */     for (k = -3; k < 3; k++) {
/*     */       
/* 555 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 557 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 559 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 560 */           if (bid == Blocks.mob_spawner) {
/* 561 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 562 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 563 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 564 */             if (s != null && 
/* 565 */               s.equals("Robo-Warrior")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 572 */     if (this.posY < 50.0D) return false; 
/* 573 */     if (this.worldObj.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 577 */     for (k = -1; k < 1; k++) {
/*     */       
/* 579 */       for (int j = -1; j <= 1; j++) {
/*     */         
/* 581 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 583 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 584 */           if (bid != Blocks.air && bid != Blocks.tallgrass) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 588 */     if (!isValidLightLevel()) return false; 
/* 589 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Robot4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */