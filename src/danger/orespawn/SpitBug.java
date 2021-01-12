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
/*     */ 
/*     */ public class SpitBug
/*     */   extends EntityMob
/*     */ {
/*  59 */   private GenericTargetSorter TargetSorter = null;
/*  60 */   private RenderInfo renderdata = new RenderInfo();
/*  61 */   private int force_sync = 50;
/*  62 */   private int hurt_timer = 0;
/*  63 */   private float moveSpeed = 0.33F;
/*  64 */   private int stream_count = 0;
/*     */ 
/*     */   
/*     */   public SpitBug(World par1World) {
/*  68 */     super(par1World);
/*     */     
/*  70 */     setSize(2.0F, 2.0F);
/*  71 */     getNavigator().setAvoidsWater(true);
/*  72 */     this.experienceValue = 50;
/*  73 */     this.fireResistance = 75;
/*  74 */     this.isImmuneToFire = false;
/*  75 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  76 */     this.renderdata = new RenderInfo();
/*  77 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  78 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.8999999761581421D, false));
/*  79 */     this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0D));
/*  80 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F));
/*  81 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  82 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  88 */     super.entityInit();
/*  89 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  90 */     if (this.renderdata == null) {
/*  91 */       this.renderdata = new RenderInfo();
/*     */     }
/*  93 */     this.renderdata.rf1 = 0.0F;
/*  94 */     this.renderdata.rf2 = 0.0F;
/*  95 */     this.renderdata.rf3 = 0.0F;
/*  96 */     this.renderdata.rf4 = 0.0F;
/*  97 */     this.renderdata.ri1 = 0;
/*  98 */     this.renderdata.ri2 = 0;
/*  99 */     this.renderdata.ri3 = 0;
/* 100 */     this.renderdata.ri4 = 0;
/* 101 */     this.force_sync = 50;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/* 106 */     super.applyEntityAttributes();
/* 107 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/* 108 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 109 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.SpitBug_stats.attack);
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 113 */     if (isNoDespawnRequired()) return false; 
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 122 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 123 */     super.onUpdate();
/* 124 */     if (this.isAirBorne)
/*     */     {
/*     */       
/* 127 */       getNavigator().setPath(null, 0.0D);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 133 */     return OreSpawnMain.SpitBug_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 141 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 146 */     this.renderdata.rf1 = r.rf1;
/* 147 */     this.renderdata.rf2 = r.rf2;
/* 148 */     this.renderdata.rf3 = r.rf3;
/* 149 */     this.renderdata.rf4 = r.rf4;
/* 150 */     this.renderdata.ri1 = r.ri1;
/* 151 */     this.renderdata.ri2 = r.ri2;
/* 152 */     this.renderdata.ri3 = r.ri3;
/* 153 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 161 */     return OreSpawnMain.SpitBug_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 169 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 178 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void jump() {
/* 185 */     this.motionY += 0.75D;
/* 186 */     this.posY += 0.75D;
/* 187 */     float f = 0.2F + Math.abs(this.worldObj.rand.nextFloat() * 0.45F);
/* 188 */     this.motionX -= f * Math.sin(Math.toRadians(this.rotationYawHead));
/* 189 */     this.motionZ += f * Math.cos(Math.toRadians(this.rotationYawHead));
/* 190 */     this.isAirBorne = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void jumpAtEntity(EntityLivingBase e) {
/* 196 */     this.motionY += 0.75D;
/* 197 */     this.posY += 0.75D;
/* 198 */     float f = 0.2F + Math.abs(this.worldObj.rand.nextFloat() * 0.25F);
/* 199 */     float d = (float)Math.atan2(e.posX - this.posX, e.posZ - this.posZ);
/* 200 */     this.motionX += f * Math.sin(d);
/* 201 */     this.motionZ += f * Math.cos(d);
/* 202 */     this.isAirBorne = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSpitBugHealth() {
/* 209 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 218 */     if (this.rand.nextInt(4) == 0) {
/* 219 */       return "orespawn:clatter";
/*     */     }
/* 221 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 229 */     return "orespawn:crunch";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 237 */     return "orespawn:emperorscorpion_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 244 */     return 0.75F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 251 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 262 */     int i = this.worldObj.rand.nextInt(10);
/* 263 */     if (i == 0) return Items.gold_nugget; 
/* 264 */     if (i == 1) return OreSpawnMain.UraniumNugget; 
/* 265 */     if (i == 2) return OreSpawnMain.TitaniumNugget; 
/* 266 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 271 */     EntityItem var3 = null;
/* 272 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 274 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), is);
/*     */     
/* 276 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 277 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 285 */     int i = 1 + this.worldObj.rand.nextInt(3);
/* 286 */     for (int var4 = 0; var4 < i; var4++) {
/* 287 */       dropItemRand(OreSpawnMain.MyAmethyst, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 304 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 309 */     double ks = 0.5D;
/* 310 */     double inair = 0.1D;
/* 311 */     int var2 = 6;
/* 312 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 314 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */ 
/*     */         
/* 317 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 318 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 319 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/*     */ 
/*     */       
/* 323 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 327 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 336 */     boolean ret = false;
/* 337 */     if (this.hurt_timer > 0) return false;
/*     */     
/* 339 */     if (!par1DamageSource.getDamageType().equals("cactus") && !par1DamageSource.getDamageType().equals("fall")) {
/* 340 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 341 */       this.hurt_timer = 15;
/*     */       
/* 343 */       Entity e = par1DamageSource.getEntity();
/* 344 */       if (e != null && e instanceof EntityLiving) {
/*     */         
/* 346 */         setAttackTarget((EntityLivingBase)e);
/* 347 */         setTarget(e);
/* 348 */         getNavigator().tryMoveToEntityLiving(e, 1.2D);
/* 349 */         ret = true;
/*     */       } 
/*     */     } 
/* 352 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 358 */     EntityLivingBase e = null;
/* 359 */     if (this.isDead)
/* 360 */       return;  super.updateAITasks();
/* 361 */     if (this.hurt_timer > 0) this.hurt_timer--; 
/* 362 */     if (this.worldObj.rand.nextInt(5) == 0) {
/* 363 */       e = getAttackTarget();
/* 364 */       if (e != null && !e.isEntityAlive()) {
/* 365 */         setAttackTarget(null);
/* 366 */         e = null;
/*     */       } 
/* 368 */       if (e == null) {
/* 369 */         e = findSomethingToAttack();
/*     */       }
/* 371 */       if (e != null) {
/* 372 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 373 */         if (this.worldObj.rand.nextInt(15) == 1 && !this.isAirBorne) {
/* 374 */           jumpAtEntity(e);
/*     */         }
/* 376 */         else if (getDistanceSqToEntity((Entity)e) < 9.0D) {
/* 377 */           setAttacking(1);
/*     */           
/* 379 */           if (this.worldObj.rand.nextInt(6) == 0 || this.worldObj.rand.nextInt(7) == 1)
/*     */           {
/* 381 */             attackEntityAsMob((Entity)e);
/* 382 */             if (!this.worldObj.isRemote && 
/* 383 */               this.worldObj.rand.nextInt(3) != 1)
/*     */             {
/*     */               
/* 386 */               this.worldObj.playSoundAtEntity((Entity)e, "orespawn:clatter", 1.0F, 1.0F);
/*     */             }
/*     */           }
/*     */         
/*     */         }
/* 391 */         else if (!this.isAirBorne) {
/* 392 */           getNavigator().tryMoveToEntityLiving((Entity)e, 0.5D);
/* 393 */           watercanon(e);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 398 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */     
/* 402 */     if (this.worldObj.rand.nextInt(150) == 1 && 
/* 403 */       getHealth() < mygetMaxHealth())
/*     */     {
/* 405 */       heal(1.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void watercanon(EntityLivingBase e) {
/* 413 */     double yoff = 1.5D;
/* 414 */     double xzoff = 1.5D;
/*     */     
/* 416 */     if (this.stream_count > 0) {
/* 417 */       setAttacking(1);
/*     */       
/* 419 */       Acid var2 = new Acid(this.worldObj, e.posX - this.posX, e.posY + 0.75D - this.posY + yoff, e.posZ - this.posZ);
/* 420 */       var2.setLocationAndAngles(this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)), this.rotationYawHead, this.rotationPitch);
/* 421 */       double var3 = e.posX - var2.posX;
/* 422 */       double var5 = e.posY + 0.25D - var2.posY;
/* 423 */       double var7 = e.posZ - var2.posZ;
/* 424 */       float var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 425 */       var2.setThrowableHeading(var3, var5 + var9, var7, 1.1F, 6.0F);
/* 426 */       this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 427 */       this.worldObj.spawnEntityInWorld((Entity)var2);
/* 428 */       this.stream_count--;
/*     */     } else {
/* 430 */       setAttacking(0);
/*     */     } 
/*     */     
/* 433 */     if (this.stream_count <= 0 && this.rand.nextInt(7) == 1) this.stream_count = 8;
/*     */   
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
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 446 */     if (par1EntityLiving == null)
/*     */     {
/* 448 */       return false;
/*     */     }
/* 450 */     if (par1EntityLiving == this)
/*     */     {
/* 452 */       return false;
/*     */     }
/* 454 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 456 */       return false;
/*     */     }
/*     */     
/* 459 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 461 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 464 */       return false;
/*     */     }
/*     */     
/* 467 */     if (par1EntityLiving instanceof EnderReaper)
/*     */     {
/* 469 */       return false;
/*     */     }
/* 471 */     if (par1EntityLiving instanceof EnderKnight)
/*     */     {
/* 473 */       return false;
/*     */     }
/* 475 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityEnderman)
/*     */     {
/* 477 */       return false;
/*     */     }
/* 479 */     if (par1EntityLiving instanceof Hydrolisc)
/*     */     {
/* 481 */       return false;
/*     */     }
/*     */     
/* 484 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCreeper)
/*     */     {
/* 486 */       return false;
/*     */     }
/* 488 */     if (par1EntityLiving instanceof SpitBug)
/*     */     {
/* 490 */       return false;
/*     */     }
/* 492 */     if (par1EntityLiving instanceof TrooperBug)
/*     */     {
/* 494 */       return false;
/*     */     }
/* 496 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 498 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 499 */       if (p.capabilities.isCreativeMode == true) {
/* 500 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 504 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 509 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 510 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 7.0D, 12.0D));
/* 511 */     Collections.sort(var5, this.TargetSorter);
/* 512 */     Iterator<?> var2 = var5.iterator();
/* 513 */     Entity var3 = null;
/* 514 */     EntityLivingBase var4 = null;
/*     */     
/* 516 */     while (var2.hasNext()) {
/*     */       
/* 518 */       var3 = (Entity)var2.next();
/* 519 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 521 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 523 */         return var4;
/*     */       }
/*     */     } 
/* 526 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 531 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 536 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/*     */     int k;
/* 547 */     for (k = -3; k < 3; k++) {
/*     */       
/* 549 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 551 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 553 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 554 */           if (bid == Blocks.mob_spawner) {
/* 555 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 556 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 557 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 558 */             if (s != null && 
/* 559 */               s.equals("Spit Bug")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 566 */     if (this.worldObj.isDaytime() == true && 
/* 567 */       this.worldObj.rand.nextInt(20) > 1) {
/* 568 */       return false;
/*     */     }
/*     */     
/* 571 */     if (!isValidLightLevel()) return false;
/*     */ 
/*     */     
/* 574 */     for (k = -2; k < 2; k++) {
/*     */       
/* 576 */       for (int j = -2; j < 2; j++) {
/*     */         
/* 578 */         for (int i = 1; i < 4; i++) {
/*     */           
/* 580 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 581 */           if (bid != Blocks.air) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 585 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\SpitBug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */