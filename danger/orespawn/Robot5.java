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
/*     */ 
/*     */ public class Robot5
/*     */   extends EntityMob
/*     */ {
/*  58 */   private GenericTargetSorter TargetSorter = null;
/*     */   
/*  60 */   private int reload_ticker = 0;
/*  61 */   private float moveSpeed = 0.3F;
/*     */ 
/*     */   
/*     */   public Robot5(World par1World) {
/*  65 */     super(par1World);
/*  66 */     setSize(1.0F, 2.25F);
/*  67 */     getNavigator().setAvoidsWater(true);
/*  68 */     this.experienceValue = 20;
/*  69 */     this.fireResistance = 40;
/*  70 */     this.isImmuneToFire = true;
/*  71 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */     
/*  73 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  74 */     this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0D));
/*  75 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.8999999761581421D, false));
/*  76 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  77 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  78 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  83 */     super.applyEntityAttributes();
/*  84 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  85 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  86 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Robot5_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  91 */     super.entityInit();
/*  92 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  97 */     if (isNoDespawnRequired()) return false; 
/*  98 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 106 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 107 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 112 */     return OreSpawnMain.Robot5_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 121 */     return OreSpawnMain.Robot5_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 129 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 138 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void jump() {
/* 144 */     this.motionY += 0.25D;
/* 145 */     super.jump();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 155 */     if (this.rand.nextInt(4) == 0) {
/* 156 */       return "orespawn:robot_living";
/*     */     }
/* 158 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 166 */     return "orespawn:robot_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 174 */     return "orespawn:robot_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 182 */     return 0.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 189 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 197 */     return Items.iron_ingot;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 202 */     EntityItem var3 = null;
/* 203 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 205 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
/*     */     
/* 207 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 208 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 216 */     ItemStack is = null;
/*     */ 
/*     */     
/* 219 */     int var5 = 5 + this.worldObj.rand.nextInt(6); int var4;
/* 220 */     for (var4 = 0; var4 < var5; var4++) {
/* 221 */       dropItemRand(OreSpawnMain.MyLaserBall, 4);
/*     */     }
/*     */     
/* 224 */     int i = 2 + this.worldObj.rand.nextInt(5);
/* 225 */     for (var4 = 0; var4 < i; var4++) {
/* 226 */       int var3 = this.worldObj.rand.nextInt(15);
/* 227 */       switch (var3) {
/*     */         case 0:
/* 229 */           is = dropItemRand(Items.redstone, 1);
/*     */           break;
/*     */         case 1:
/* 232 */           is = dropItemRand(Items.repeater, 1);
/*     */           break;
/*     */         case 2:
/* 235 */           is = dropItemRand(Items.comparator, 1);
/*     */           break;
/*     */         case 3:
/* 238 */           is = dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
/*     */           break;
/*     */         case 4:
/* 241 */           is = dropItemRand(Item.getItemFromBlock(Blocks.dispenser), 1);
/*     */           break;
/*     */         case 5:
/* 244 */           is = dropItemRand(Item.getItemFromBlock((Block)Blocks.sticky_piston), 1);
/*     */           break;
/*     */         case 6:
/* 247 */           is = dropItemRand(Item.getItemFromBlock((Block)Blocks.piston), 1);
/*     */           break;
/*     */         case 7:
/* 250 */           is = dropItemRand(Item.getItemFromBlock(Blocks.lever), 1);
/*     */           break;
/*     */         case 8:
/* 253 */           is = dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
/*     */           break;
/*     */         case 9:
/* 256 */           is = dropItemRand(Item.getItemFromBlock(Blocks.light_weighted_pressure_plate), 1);
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
/* 272 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 279 */     return super.attackEntityAsMob(par1Entity);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 284 */     if (this.isDead)
/* 285 */       return;  super.updateAITasks();
/* 286 */     if (this.reload_ticker > 0) {
/* 287 */       this.reload_ticker--;
/* 288 */       if (this.reload_ticker < 15) setAttacking(0); 
/*     */     } 
/* 290 */     if (this.reload_ticker == 0) {
/* 291 */       EntityLivingBase e = null;
/* 292 */       if (this.worldObj.rand.nextInt(50) == 1) setAttackTarget(null); 
/* 293 */       e = getAttackTarget();
/* 294 */       if (e != null && !e.isEntityAlive()) {
/* 295 */         setAttackTarget(null);
/* 296 */         e = null;
/*     */       } 
/* 298 */       if (e == null) {
/* 299 */         e = findSomethingToAttack();
/*     */       }
/* 301 */       this.reload_ticker = 20;
/* 302 */       if (e != null) {
/* 303 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 304 */         if (getDistanceSqToEntity((Entity)e) < 900.0D) {
/*     */ 
/*     */           
/* 307 */           double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/* 308 */           double rhdir = Math.toRadians(((this.rotationYawHead + 90.0F) % 360.0F));
/*     */           
/* 310 */           double pi = 3.1415926545D;
/*     */           
/* 312 */           double rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/* 313 */           if (rdd > pi) rdd -= pi * 2.0D; 
/* 314 */           rdd = Math.abs(rdd);
/*     */           
/* 316 */           if (rdd < 0.5D) {
/* 317 */             double yoff = 1.6D;
/* 318 */             double xzoff = 1.6D;
/* 319 */             LaserBall var2 = new LaserBall(this.worldObj, e.posX - this.posX, e.posY - this.posY + yoff, e.posZ - this.posZ);
/* 320 */             var2.setLocationAndAngles(this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYawHead)), this.rotationYawHead, this.rotationPitch);
/* 321 */             double var3 = e.posX - var2.posX;
/* 322 */             double var5 = e.posY - var2.posY;
/* 323 */             double var7 = e.posZ - var2.posZ;
/* 324 */             float var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 325 */             var2.setThrowableHeading(var3, var5 + var9, var7, 1.4F, 5.0F);
/* 326 */             this.worldObj.playSoundAtEntity((Entity)this, "fireworks.launch", 3.0F, 1.0F);
/* 327 */             this.worldObj.spawnEntityInWorld((Entity)var2);
/* 328 */             setAttacking(1);
/*     */           } 
/* 330 */           if (getDistanceSqToEntity((Entity)e) > 36.0D) {
/* 331 */             getNavigator().tryMoveToEntityLiving((Entity)e, 0.5D);
/*     */           }
/*     */         } 
/*     */       } else {
/* 335 */         setAttacking(0);
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
/* 346 */     boolean ret = false;
/* 347 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 348 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     }
/* 350 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 360 */     if (par1EntityLiving == null)
/*     */     {
/* 362 */       return false;
/*     */     }
/* 364 */     if (par1EntityLiving == this)
/*     */     {
/* 366 */       return false;
/*     */     }
/* 368 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 370 */       return false;
/*     */     }
/*     */     
/* 373 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 375 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 378 */       return false;
/*     */     }
/*     */     
/* 381 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 383 */       return false;
/*     */     }
/* 385 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 387 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 388 */       if (p.capabilities.isCreativeMode == true) {
/* 389 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 393 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 398 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 399 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(30.0D, 6.0D, 30.0D));
/* 400 */     Collections.sort(var5, this.TargetSorter);
/* 401 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 403 */     while (var2.hasNext()) {
/*     */       
/* 405 */       Entity var3 = (Entity)var2.next();
/* 406 */       EntityLivingBase var4 = (EntityLivingBase)var3;
/*     */       
/* 408 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 410 */         return var4;
/*     */       }
/*     */     } 
/* 413 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 419 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 424 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
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
/* 436 */     for (k = -3; k < 3; k++) {
/*     */       
/* 438 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 440 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 442 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 443 */           if (bid == Blocks.mob_spawner) {
/* 444 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 445 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 446 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 447 */             if (s != null && 
/* 448 */               s.equals("Robo-Sniper")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 455 */     if (this.posY < 50.0D) return false; 
/* 456 */     if (this.worldObj.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 460 */     for (k = -1; k < 1; k++) {
/*     */       
/* 462 */       for (int j = -1; j <= 1; j++) {
/*     */         
/* 464 */         for (int i = 1; i < 3; i++) {
/*     */           
/* 466 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 467 */           if (bid != Blocks.air && bid != Blocks.tallgrass) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 471 */     if (!isValidLightLevel()) return false; 
/* 472 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Robot5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */