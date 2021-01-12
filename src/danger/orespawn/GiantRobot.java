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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GiantRobot
/*     */   extends EntityMob
/*     */ {
/*  56 */   private GenericTargetSorter TargetSorter = null;
/*  57 */   private RenderGiantRobotInfo renderdata = new RenderGiantRobotInfo();
/*  58 */   private int reload_ticker = 0;
/*  59 */   private float moveSpeed = 0.55F;
/*     */ 
/*     */   
/*     */   public GiantRobot(World par1World) {
/*  63 */     super(par1World);
/*  64 */     setSize(3.0F, 9.75F);
/*  65 */     getNavigator().setAvoidsWater(true);
/*  66 */     this.experienceValue = OreSpawnMain.Jeffery_stats.health / 2;
/*  67 */     this.fireResistance = 40;
/*  68 */     this.isImmuneToFire = true;
/*  69 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  70 */     this.renderdata = new RenderGiantRobotInfo();
/*  71 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  72 */     this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0D));
/*  73 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.8999999761581421D, false));
/*  74 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  75 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  76 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  81 */     super.applyEntityAttributes();
/*  82 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  83 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  84 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Jeffery_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  89 */     super.entityInit();
/*  90 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  91 */     initLegData();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void initLegData() {
/*  97 */     if (this.renderdata == null) {
/*  98 */       this.renderdata = new RenderGiantRobotInfo();
/*     */     }
/*     */     
/* 101 */     this.renderdata.hipydisplayangle = 0.0F;
/* 102 */     this.renderdata.hipxdisplayangle = 0.0F;
/* 103 */     this.renderdata.gpcounter = 2000000;
/* 104 */     this.renderdata.thighdisplayangle[0] = 0.0F;
/* 105 */     this.renderdata.thighdisplayangle[1] = 0.0F;
/* 106 */     this.renderdata.shindisplayangle[0] = 0.0F;
/* 107 */     this.renderdata.shindisplayangle[1] = 0.0F;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 111 */     if (isNoDespawnRequired()) return false; 
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 120 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 121 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 126 */     return OreSpawnMain.Jeffery_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderGiantRobotInfo getRenderGiantRobotInfo() {
/* 133 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 142 */     return OreSpawnMain.Jeffery_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 150 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 159 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void jump() {
/* 165 */     this.motionY += 0.25D;
/* 166 */     super.jump();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 176 */     if (this.rand.nextInt(4) == 0) {
/* 177 */       return "orespawn:robot_living";
/*     */     }
/* 179 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 187 */     return "orespawn:robot_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 195 */     return "orespawn:robot_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 203 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 210 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 218 */     return Items.iron_ingot;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 223 */     EntityItem var3 = null;
/* 224 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 226 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
/*     */     
/* 228 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 229 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 237 */     ItemStack is = null;
/*     */ 
/*     */     
/* 240 */     int var5 = 15 + this.worldObj.rand.nextInt(15); int var4;
/* 241 */     for (var4 = 0; var4 < var5; var4++) {
/* 242 */       dropItemRand(OreSpawnMain.MyLaserBall, 4);
/*     */     }
/*     */     
/* 245 */     int i = 10 + this.worldObj.rand.nextInt(10);
/* 246 */     for (var4 = 0; var4 < i; var4++) {
/* 247 */       int var3 = this.worldObj.rand.nextInt(12);
/* 248 */       switch (var3) {
/*     */         case 0:
/* 250 */           is = dropItemRand(OreSpawnMain.SpiderRobotKit, 1);
/*     */           break;
/*     */         case 1:
/* 253 */           is = dropItemRand(OreSpawnMain.AntRobotKit, 1);
/*     */           break;
/*     */         case 2:
/* 256 */           is = dropItemRand(OreSpawnMain.MyRayGun, 1);
/*     */           break;
/*     */         case 3:
/* 259 */           is = dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
/*     */           break;
/*     */         case 4:
/* 262 */           is = dropItemRand(Item.getItemFromBlock(Blocks.dispenser), 1);
/*     */           break;
/*     */         case 5:
/* 265 */           is = dropItemRand(Item.getItemFromBlock((Block)Blocks.sticky_piston), 1);
/*     */           break;
/*     */         case 6:
/* 268 */           is = dropItemRand(Item.getItemFromBlock((Block)Blocks.piston), 1);
/*     */           break;
/*     */         case 7:
/* 271 */           is = dropItemRand(Item.getItemFromBlock(Blocks.lever), 1);
/*     */           break;
/*     */         case 8:
/* 274 */           is = dropItemRand(Item.getItemFromBlock(Blocks.iron_block), 1);
/*     */           break;
/*     */         case 9:
/* 277 */           is = dropItemRand(Item.getItemFromBlock(Blocks.detector_rail), 1);
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
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 293 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 300 */     double ks = 2.2D;
/* 301 */     double inair = 0.25D;
/*     */     
/* 303 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 305 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 307 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 308 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 309 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 311 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 315 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 321 */     if (this.isDead)
/* 322 */       return;  super.updateAITasks();
/* 323 */     if (this.reload_ticker > 0) {
/* 324 */       this.reload_ticker--;
/*     */     }
/* 326 */     if (this.worldObj.rand.nextInt(5) == 0) {
/* 327 */       EntityLivingBase e = null;
/* 328 */       if (this.worldObj.rand.nextInt(100) == 1) setAttackTarget(null); 
/* 329 */       e = getAttackTarget();
/* 330 */       if (e != null && !e.isEntityAlive()) {
/* 331 */         setAttackTarget(null);
/* 332 */         e = null;
/*     */       } 
/* 334 */       if (e == null) {
/* 335 */         e = findSomethingToAttack();
/*     */       }
/*     */       
/* 338 */       if (e != null) {
/* 339 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 340 */         if (getDistanceSqToEntity((Entity)e) < 256.0D) {
/*     */ 
/*     */           
/* 343 */           double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/* 344 */           double rhdir = Math.toRadians(((this.rotationYawHead + 90.0F) % 360.0F));
/*     */           
/* 346 */           double pi = 3.1415926545D;
/*     */           
/* 348 */           double rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/* 349 */           if (rdd > pi) rdd -= pi * 2.0D; 
/* 350 */           rdd = Math.abs(rdd);
/*     */           
/* 352 */           if (rdd < 0.5D) {
/* 353 */             if (this.reload_ticker == 0) {
/* 354 */               double yoff = 10.0D;
/* 355 */               double xzoff = 3.75D;
/* 356 */               LaserBall var2 = new LaserBall(this.worldObj, e.posX - this.posX, e.posY - this.posY + yoff, e.posZ - this.posZ);
/* 357 */               var2.setLocationAndAngles(this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYawHead)), this.rotationYawHead, this.rotationPitch);
/* 358 */               double var3 = e.posX - var2.posX;
/* 359 */               double var5 = e.posY - var2.posY;
/* 360 */               double var7 = e.posZ - var2.posZ;
/* 361 */               float var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 362 */               var2.setThrowableHeading(var3, var5 + var9, var7, 2.0F, 4.0F);
/* 363 */               if (getDistanceSqToEntity((Entity)e) > 100.0D) {
/* 364 */                 var2.setSpecial();
/* 365 */                 this.reload_ticker = 25;
/* 366 */                 this.worldObj.playSoundAtEntity((Entity)this, "fireworks.launch", 3.5F, 0.5F);
/*     */               } else {
/* 368 */                 this.reload_ticker = 10;
/* 369 */                 this.worldObj.playSoundAtEntity((Entity)this, "fireworks.launch", 2.5F, 1.0F);
/*     */               } 
/* 371 */               this.worldObj.spawnEntityInWorld((Entity)var2);
/*     */             } 
/* 373 */             if (getDistanceSqToEntity((Entity)e) < ((8.0F + e.width / 2.0F) * (8.0F + e.width / 2.0F))) {
/* 374 */               setAttacking(1);
/* 375 */               attackEntityAsMob((Entity)e);
/*     */             } else {
/* 377 */               setAttacking(0);
/*     */             } 
/*     */           } 
/* 380 */           getNavigator().tryMoveToEntityLiving((Entity)e, 0.5D);
/*     */         } else {
/* 382 */           setAttacking(0);
/*     */         } 
/*     */       } else {
/* 385 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 396 */     boolean ret = false;
/* 397 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 398 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     }
/* 400 */     Entity e = par1DamageSource.getEntity();
/* 401 */     if (e != null && e instanceof EntityLiving) {
/*     */       
/* 403 */       setAttackTarget((EntityLivingBase)e);
/* 404 */       setTarget(e);
/*     */     } 
/* 406 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 416 */     if (par1EntityLiving == null)
/*     */     {
/* 418 */       return false;
/*     */     }
/* 420 */     if (par1EntityLiving == this)
/*     */     {
/* 422 */       return false;
/*     */     }
/* 424 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 426 */       return false;
/*     */     }
/*     */     
/* 429 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 431 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 434 */       return false;
/*     */     }
/*     */     
/* 437 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 439 */       return false;
/*     */     }
/* 441 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 443 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 444 */       if (p.capabilities.isCreativeMode == true) {
/* 445 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 449 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 454 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 455 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0D, 12.0D, 16.0D));
/* 456 */     Collections.sort(var5, this.TargetSorter);
/* 457 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 459 */     while (var2.hasNext()) {
/*     */       
/* 461 */       Entity var3 = (Entity)var2.next();
/* 462 */       EntityLivingBase var4 = (EntityLivingBase)var3;
/*     */       
/* 464 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 466 */         return var4;
/*     */       }
/*     */     } 
/* 469 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 475 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 480 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
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
/* 491 */     if (this.posY < 50.0D) return false; 
/* 492 */     if (this.worldObj.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 496 */     for (int k = -1; k < 1; k++) {
/*     */       
/* 498 */       for (int j = -1; j <= 1; j++) {
/*     */         
/* 500 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 502 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 503 */           if (bid != Blocks.air && bid != Blocks.tallgrass) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 507 */     if (!isValidLightLevel()) return false; 
/* 508 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\GiantRobot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */