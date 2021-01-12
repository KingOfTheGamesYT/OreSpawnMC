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
/*     */ public class Robot2
/*     */   extends EntityMob
/*     */ {
/*  57 */   private GenericTargetSorter TargetSorter = null;
/*  58 */   private RenderInfo renderdata = new RenderInfo();
/*  59 */   private int just_for_fun = 0;
/*  60 */   private float moveSpeed = 0.3F;
/*     */   
/*     */   public Robot2(World par1World) {
/*  63 */     super(par1World);
/*  64 */     setSize(3.0F, 6.2F);
/*  65 */     getNavigator().setAvoidsWater(true);
/*  66 */     this.experienceValue = 100;
/*  67 */     this.fireResistance = 200;
/*  68 */     this.isImmuneToFire = true;
/*  69 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  70 */     this.renderdata = new RenderInfo();
/*  71 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  72 */     this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0D));
/*  73 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.8999999761581421D, false));
/*  74 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F));
/*  75 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  76 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  81 */     super.applyEntityAttributes();
/*  82 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  83 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  84 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Robot2_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  89 */     super.entityInit();
/*  90 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  91 */     if (this.renderdata == null) {
/*  92 */       this.renderdata = new RenderInfo();
/*     */     }
/*  94 */     this.renderdata.rf1 = 0.0F;
/*  95 */     this.renderdata.rf2 = 0.0F;
/*  96 */     this.renderdata.rf3 = 0.0F;
/*  97 */     this.renderdata.rf4 = 0.0F;
/*  98 */     this.renderdata.ri1 = 0;
/*  99 */     this.renderdata.ri2 = 0;
/* 100 */     this.renderdata.ri3 = 0;
/* 101 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 105 */     if (isNoDespawnRequired()) return false; 
/* 106 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 114 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 115 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 120 */     return OreSpawnMain.Robot2_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 127 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 132 */     this.renderdata.rf1 = r.rf1;
/* 133 */     this.renderdata.rf2 = r.rf2;
/* 134 */     this.renderdata.rf3 = r.rf3;
/* 135 */     this.renderdata.rf4 = r.rf4;
/* 136 */     this.renderdata.ri1 = r.ri1;
/* 137 */     this.renderdata.ri2 = r.ri2;
/* 138 */     this.renderdata.ri3 = r.ri3;
/* 139 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 147 */     return OreSpawnMain.Robot2_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 155 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 164 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void jump() {
/* 170 */     this.motionY += 0.25D;
/* 171 */     super.jump();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 180 */     if (this.rand.nextInt(4) == 0) {
/* 181 */       return "orespawn:robot_living";
/*     */     }
/* 183 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 191 */     return "orespawn:robot_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 199 */     return "orespawn:robot_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 207 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 214 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 222 */     return Item.getItemFromBlock(Blocks.iron_block);
/*     */   }
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 226 */     EntityItem var3 = null;
/* 227 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 229 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
/*     */     
/* 231 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 232 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 240 */     ItemStack is = null;
/*     */ 
/*     */     
/* 243 */     int var5 = 2 + this.worldObj.rand.nextInt(8); int var4;
/* 244 */     for (var4 = 0; var4 < var5; var4++) {
/* 245 */       dropItemRand(Item.getItemFromBlock(Blocks.iron_block), 1);
/*     */     }
/*     */     
/* 248 */     var5 = 5 + this.worldObj.rand.nextInt(6);
/* 249 */     for (var4 = 0; var4 < var5; var4++) {
/* 250 */       dropItemRand(Items.iron_ingot, 1);
/*     */     }
/*     */ 
/*     */     
/* 254 */     int i = 5 + this.worldObj.rand.nextInt(10);
/* 255 */     for (var4 = 0; var4 < i; var4++) {
/* 256 */       int var3 = this.worldObj.rand.nextInt(15);
/* 257 */       switch (var3) {
/*     */         case 0:
/* 259 */           is = dropItemRand(Items.redstone, 1);
/*     */           break;
/*     */         case 1:
/* 262 */           is = dropItemRand(Items.repeater, 1);
/*     */           break;
/*     */         case 2:
/* 265 */           is = dropItemRand(Items.comparator, 1);
/*     */           break;
/*     */         case 3:
/* 268 */           is = dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
/*     */           break;
/*     */         case 4:
/* 271 */           is = dropItemRand(Item.getItemFromBlock(Blocks.dispenser), 1);
/*     */           break;
/*     */         case 5:
/* 274 */           is = dropItemRand(Item.getItemFromBlock((Block)Blocks.sticky_piston), 1);
/*     */           break;
/*     */         case 6:
/* 277 */           is = dropItemRand(Item.getItemFromBlock((Block)Blocks.piston), 1);
/*     */           break;
/*     */         case 7:
/* 280 */           is = dropItemRand(Item.getItemFromBlock(Blocks.lever), 1);
/*     */           break;
/*     */         case 8:
/* 283 */           is = dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
/*     */           break;
/*     */         case 9:
/* 286 */           is = dropItemRand(Item.getItemFromBlock(Blocks.light_weighted_pressure_plate), 1);
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
/* 300 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 306 */     return super.attackEntityAsMob(par1Entity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void destroyBlock(EntityLivingBase e) {
/* 312 */     double x = e.posX + this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat();
/* 313 */     double y = e.posY - 1.0D;
/* 314 */     double z = e.posZ + this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat();
/*     */ 
/*     */     
/* 317 */     Block bid = this.worldObj.getBlock((int)x, (int)y, (int)z);
/* 318 */     if (bid == Blocks.obsidian)
/* 319 */       return;  if (bid == Blocks.bedrock)
/* 320 */       return;  if (bid == Blocks.quartz_block)
/* 321 */       return;  if (bid == Blocks.mob_spawner)
/* 322 */       return;  if (bid == Blocks.redstone_block)
/* 323 */       return;  if (bid == Blocks.iron_block)
/* 324 */       return;  if (bid == Blocks.chest) {
/*     */       return;
/*     */     }
/* 327 */     if (bid != Blocks.air && 
/* 328 */       this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock((int)x, (int)y, (int)z, Blocks.air);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void destroyNearbyBlocks() {
/* 337 */     for (int i = 0; i < 50; i++) {
/* 338 */       double x = this.posX + this.worldObj.rand.nextFloat() * 6.5D - this.worldObj.rand.nextFloat() * 6.5D;
/* 339 */       double y = this.posY + 0.1D + this.worldObj.rand.nextFloat() * 8.5D;
/* 340 */       double z = this.posZ + this.worldObj.rand.nextFloat() * 6.5D - this.worldObj.rand.nextFloat() * 6.5D;
/*     */ 
/*     */       
/* 343 */       Block bid = this.worldObj.getBlock((int)x, (int)y, (int)z);
/* 344 */       if (bid != Blocks.obsidian && 
/* 345 */         bid != Blocks.bedrock && 
/* 346 */         bid != Blocks.quartz_block && 
/* 347 */         bid != Blocks.mob_spawner && 
/* 348 */         bid != Blocks.redstone_block && 
/* 349 */         bid != Blocks.iron_block && 
/* 350 */         bid != Blocks.chest)
/*     */       {
/*     */         
/* 353 */         if (bid != Blocks.air && 
/* 354 */           this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock((int)x, (int)y, (int)z, Blocks.air);
/*     */       
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void updateAITasks() {
/* 361 */     if (this.isDead)
/* 362 */       return;  super.updateAITasks();
/* 363 */     if (this.worldObj.rand.nextInt(6) == 1 && OreSpawnMain.PlayNicely == 0) {
/* 364 */       EntityLivingBase e = null;
/* 365 */       if (this.worldObj.rand.nextInt(50) == 1) setAttackTarget(null); 
/* 366 */       e = getAttackTarget();
/* 367 */       if (e != null && !e.isEntityAlive()) {
/* 368 */         setAttackTarget(null);
/* 369 */         e = null;
/*     */       } 
/* 371 */       if (e == null) {
/* 372 */         e = findSomethingToAttack();
/*     */       }
/* 374 */       if (e != null) {
/*     */         
/* 376 */         double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/* 377 */         double rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*     */         
/* 379 */         double pi = 3.1415926545D;
/*     */         
/* 381 */         double rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/* 382 */         if (rdd > pi) rdd -= pi * 2.0D; 
/* 383 */         rdd = Math.abs(rdd);
/*     */         
/* 385 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 386 */         if (rdd < 1.25D) {
/* 387 */           if (getDistanceSqToEntity((Entity)e) < ((5.0F + e.width / 2.0F) * (5.0F + e.width / 2.0F))) {
/* 388 */             setAttacking(1);
/*     */             
/* 390 */             if (this.worldObj.rand.nextInt(5) == 0 || this.worldObj.rand.nextInt(6) == 1) {
/*     */               
/* 392 */               attackEntityAsMob((Entity)e);
/* 393 */               for (int i = 0; i < 6; ) { destroyBlock(e); i++; }
/*     */             
/*     */             } 
/* 396 */             destroyNearbyBlocks();
/*     */           } 
/*     */         } else {
/* 399 */           setAttacking(0);
/*     */         } 
/* 401 */         getNavigator().tryMoveToEntityLiving((Entity)e, 1.0D);
/*     */       } else {
/* 403 */         setAttacking(0);
/*     */       } 
/*     */     } 
/* 406 */     if (getAttacking() == 0 && OreSpawnMain.PlayNicely == 0) {
/* 407 */       if (this.worldObj.rand.nextInt(450) == 1) {
/* 408 */         this.just_for_fun = 50;
/*     */       }
/* 410 */       if (this.just_for_fun > 0) this.just_for_fun--; 
/* 411 */       if (this.just_for_fun > 0) {
/* 412 */         setAttacking(1);
/* 413 */         if (this.worldObj.rand.nextInt(3) == 1) {
/* 414 */           destroyNearbyBlocks();
/*     */         }
/*     */       } else {
/* 417 */         setAttacking(0);
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
/* 428 */     boolean ret = false;
/* 429 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 430 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 431 */       Entity e = par1DamageSource.getEntity();
/* 432 */       if (e != null && e instanceof EntityLiving) {
/*     */         
/* 434 */         setAttackTarget((EntityLivingBase)e);
/* 435 */         setTarget(e);
/* 436 */         getNavigator().tryMoveToEntityLiving(e, 1.2D);
/*     */       } 
/* 438 */       return ret;
/*     */     } 
/* 440 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 450 */     if (par1EntityLiving == null)
/*     */     {
/* 452 */       return false;
/*     */     }
/* 454 */     if (par1EntityLiving == this)
/*     */     {
/* 456 */       return false;
/*     */     }
/* 458 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 460 */       return false;
/*     */     }
/*     */     
/* 463 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 465 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 468 */       return false;
/*     */     }
/*     */     
/* 471 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 473 */       return false;
/*     */     }
/* 475 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 477 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 478 */       if (p.capabilities.isCreativeMode == true) {
/* 479 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 483 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 488 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 489 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(14.0D, 3.0D, 14.0D));
/* 490 */     Collections.sort(var5, this.TargetSorter);
/* 491 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 493 */     while (var2.hasNext()) {
/*     */       
/* 495 */       Entity var3 = (Entity)var2.next();
/* 496 */       EntityLivingBase var4 = (EntityLivingBase)var3;
/*     */       
/* 498 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 500 */         return var4;
/*     */       }
/*     */     } 
/* 503 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 509 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 514 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
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
/* 526 */     for (k = -3; k < 3; k++) {
/*     */       
/* 528 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 530 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 532 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 533 */           if (bid == Blocks.mob_spawner) {
/* 534 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 535 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 536 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 537 */             if (s != null && 
/* 538 */               s.equals("Robo-Pounder")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 545 */     if (this.posY < 50.0D) return false; 
/* 546 */     if (this.worldObj.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 551 */     for (k = -1; k < 1; k++) {
/*     */       
/* 553 */       for (int j = -1; j <= 1; j++) {
/*     */         
/* 555 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 557 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 558 */           if (bid != Blocks.air && bid != Blocks.tallgrass) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 562 */     if (!isValidLightLevel()) return false;
/*     */     
/* 564 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Robot2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */