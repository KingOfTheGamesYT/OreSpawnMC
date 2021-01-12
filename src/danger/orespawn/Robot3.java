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
/*     */ 
/*     */ 
/*     */ public class Robot3
/*     */   extends EntityMob
/*     */ {
/*  58 */   private GenericTargetSorter TargetSorter = null;
/*  59 */   private RenderInfo renderdata = new RenderInfo();
/*  60 */   private int reload_ticker = 0;
/*  61 */   private float moveSpeed = 0.35F;
/*     */ 
/*     */   
/*     */   public Robot3(World par1World) {
/*  65 */     super(par1World);
/*  66 */     setSize(2.5F, 5.0F);
/*  67 */     getNavigator().setAvoidsWater(true);
/*  68 */     this.experienceValue = 60;
/*  69 */     this.fireResistance = 40;
/*  70 */     this.isImmuneToFire = true;
/*  71 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  72 */     this.renderdata = new RenderInfo();
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
/*  86 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Robot3_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  91 */     super.entityInit();
/*  92 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  93 */     if (this.renderdata == null) {
/*  94 */       this.renderdata = new RenderInfo();
/*     */     }
/*  96 */     this.renderdata.rf1 = 0.0F;
/*  97 */     this.renderdata.rf2 = 0.0F;
/*  98 */     this.renderdata.rf3 = 0.0F;
/*  99 */     this.renderdata.rf4 = 0.0F;
/* 100 */     this.renderdata.ri1 = 0;
/* 101 */     this.renderdata.ri2 = 0;
/* 102 */     this.renderdata.ri3 = 0;
/* 103 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 107 */     if (isNoDespawnRequired()) return false; 
/* 108 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 116 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 117 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 122 */     return OreSpawnMain.Robot3_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 129 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 134 */     this.renderdata.rf1 = r.rf1;
/* 135 */     this.renderdata.rf2 = r.rf2;
/* 136 */     this.renderdata.rf3 = r.rf3;
/* 137 */     this.renderdata.rf4 = r.rf4;
/* 138 */     this.renderdata.ri1 = r.ri1;
/* 139 */     this.renderdata.ri2 = r.ri2;
/* 140 */     this.renderdata.ri3 = r.ri3;
/* 141 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 149 */     return OreSpawnMain.Robot3_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 157 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 166 */     super.onLivingUpdate();
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
/*     */   
/*     */   protected String getLivingSound() {
/* 183 */     if (this.rand.nextInt(4) == 0) {
/* 184 */       return "orespawn:robot_living";
/*     */     }
/* 186 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 194 */     return "orespawn:robot_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 202 */     return "orespawn:robot_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 210 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 217 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 225 */     return Items.iron_ingot;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 230 */     EntityItem var3 = null;
/* 231 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 233 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
/*     */     
/* 235 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 236 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 244 */     ItemStack is = null;
/*     */ 
/*     */     
/* 247 */     int var5 = 5 + this.worldObj.rand.nextInt(6); int var4;
/* 248 */     for (var4 = 0; var4 < var5; var4++) {
/* 249 */       dropItemRand(OreSpawnMain.MyLaserBall, 4);
/*     */     }
/*     */     
/* 252 */     int i = 5 + this.worldObj.rand.nextInt(10);
/* 253 */     for (var4 = 0; var4 < i; var4++) {
/* 254 */       int var3 = this.worldObj.rand.nextInt(15);
/* 255 */       switch (var3) {
/*     */         case 0:
/* 257 */           is = dropItemRand(Items.redstone, 1);
/*     */           break;
/*     */         case 1:
/* 260 */           is = dropItemRand(Items.repeater, 1);
/*     */           break;
/*     */         case 2:
/* 263 */           is = dropItemRand(Items.comparator, 1);
/*     */           break;
/*     */         case 3:
/* 266 */           is = dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
/*     */           break;
/*     */         case 4:
/* 269 */           is = dropItemRand(Item.getItemFromBlock(Blocks.dispenser), 1);
/*     */           break;
/*     */         case 5:
/* 272 */           is = dropItemRand(Item.getItemFromBlock((Block)Blocks.sticky_piston), 1);
/*     */           break;
/*     */         case 6:
/* 275 */           is = dropItemRand(Item.getItemFromBlock((Block)Blocks.piston), 1);
/*     */           break;
/*     */         case 7:
/* 278 */           is = dropItemRand(Item.getItemFromBlock(Blocks.lever), 1);
/*     */           break;
/*     */         case 8:
/* 281 */           is = dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
/*     */           break;
/*     */         case 9:
/* 284 */           is = dropItemRand(Item.getItemFromBlock(Blocks.light_weighted_pressure_plate), 1);
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
/* 300 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 307 */     return super.attackEntityAsMob(par1Entity);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 312 */     if (this.isDead)
/* 313 */       return;  super.updateAITasks();
/* 314 */     if (this.reload_ticker > 0) {
/* 315 */       this.reload_ticker--;
/* 316 */       if (this.reload_ticker < 25) setAttacking(0); 
/*     */     } 
/* 318 */     if (this.reload_ticker == 0) {
/* 319 */       EntityLivingBase e = null;
/* 320 */       if (this.worldObj.rand.nextInt(50) == 1) setAttackTarget(null); 
/* 321 */       e = getAttackTarget();
/* 322 */       if (e != null && !e.isEntityAlive()) {
/* 323 */         setAttackTarget(null);
/* 324 */         e = null;
/*     */       } 
/* 326 */       if (e == null) {
/* 327 */         e = findSomethingToAttack();
/*     */       }
/* 329 */       this.reload_ticker = 35;
/* 330 */       if (e != null) {
/* 331 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 332 */         if (getDistanceSqToEntity((Entity)e) < 256.0D) {
/*     */ 
/*     */           
/* 335 */           double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/* 336 */           double rhdir = Math.toRadians(((this.rotationYawHead + 90.0F) % 360.0F));
/*     */           
/* 338 */           double pi = 3.1415926545D;
/*     */           
/* 340 */           double rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/* 341 */           if (rdd > pi) rdd -= pi * 2.0D; 
/* 342 */           rdd = Math.abs(rdd);
/*     */           
/* 344 */           if (rdd < 0.5D) {
/* 345 */             double yoff = 3.0D;
/* 346 */             double xzoff = 1.75D;
/* 347 */             LaserBall var2 = new LaserBall(this.worldObj, e.posX - this.posX, e.posY - this.posY + yoff, e.posZ - this.posZ);
/* 348 */             var2.setLocationAndAngles(this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYawHead)), this.rotationYawHead, this.rotationPitch);
/* 349 */             double var3 = e.posX - var2.posX;
/* 350 */             double var5 = e.posY - var2.posY;
/* 351 */             double var7 = e.posZ - var2.posZ;
/* 352 */             float var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 353 */             var2.setThrowableHeading(var3, var5 + var9, var7, 1.4F, 5.0F);
/* 354 */             this.worldObj.playSoundAtEntity((Entity)this, "fireworks.launch", 3.0F, 1.0F);
/* 355 */             this.worldObj.spawnEntityInWorld((Entity)var2);
/* 356 */             setAttacking(1);
/*     */           } 
/* 358 */           getNavigator().tryMoveToEntityLiving((Entity)e, 0.5D);
/*     */         } 
/*     */       } else {
/* 361 */         setAttacking(0);
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
/* 372 */     boolean ret = false;
/* 373 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 374 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     }
/* 376 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 386 */     if (par1EntityLiving == null)
/*     */     {
/* 388 */       return false;
/*     */     }
/* 390 */     if (par1EntityLiving == this)
/*     */     {
/* 392 */       return false;
/*     */     }
/* 394 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 396 */       return false;
/*     */     }
/*     */     
/* 399 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 401 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 404 */       return false;
/*     */     }
/*     */     
/* 407 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 409 */       return false;
/*     */     }
/* 411 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 413 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 414 */       if (p.capabilities.isCreativeMode == true) {
/* 415 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 419 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 424 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 425 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0D, 3.0D, 16.0D));
/* 426 */     Collections.sort(var5, this.TargetSorter);
/* 427 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 429 */     while (var2.hasNext()) {
/*     */       
/* 431 */       Entity var3 = (Entity)var2.next();
/* 432 */       EntityLivingBase var4 = (EntityLivingBase)var3;
/*     */       
/* 434 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 436 */         return var4;
/*     */       }
/*     */     } 
/* 439 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 445 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 450 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
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
/* 461 */     if (this.posY < 50.0D) return false; 
/* 462 */     if (this.worldObj.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 466 */     for (int k = -1; k < 1; k++) {
/*     */       
/* 468 */       for (int j = -1; j <= 1; j++) {
/*     */         
/* 470 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 472 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 473 */           if (bid != Blocks.air && bid != Blocks.tallgrass) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 477 */     if (!isValidLightLevel()) return false; 
/* 478 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Robot3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */