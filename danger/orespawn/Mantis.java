/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Mantis
/*     */   extends EntityMob
/*     */ {
/*  56 */   private ChunkCoordinates currentFlightTarget = null;
/*  57 */   private GenericTargetSorter TargetSorter = null;
/*  58 */   private int stuck_count = 0;
/*  59 */   private int lastX = 0;
/*  60 */   private int lastZ = 0;
/*  61 */   private Entity rt = null;
/*     */   
/*     */   public Mantis(World par1World) {
/*  64 */     super(par1World);
/*  65 */     setSize(2.5F, 3.25F);
/*  66 */     getNavigator().setAvoidsWater(false);
/*  67 */     this.experienceValue = 100;
/*  68 */     this.isImmuneToFire = false;
/*  69 */     this.fireResistance = 5;
/*  70 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  75 */     super.applyEntityAttributes();
/*  76 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  77 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3199999928474426D);
/*     */     
/*  79 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Mantis_stats.attack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  85 */     super.entityInit();
/*  86 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  90 */     if (isNoDespawnRequired()) return false; 
/*  91 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/*  96 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 101 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 108 */     return 0.35F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 115 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 122 */     return "orespawn:Beebuzz";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 129 */     return "orespawn:dragonfly_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 136 */     return "orespawn:alo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 143 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 150 */     return OreSpawnMain.Mantis_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 158 */     return Item.getItemFromBlock((Block)Blocks.yellow_flower);
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 163 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), new ItemStack(index, par1, 0));
/*     */     
/* 165 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 172 */     dropItemRand(OreSpawnMain.MyMantisClaw, 1);
/* 173 */     dropItemRand(OreSpawnMain.MyMantisClaw, 1);
/* 174 */     dropItemRand(Items.item_frame, 1);
/*     */     
/* 176 */     int var4 = 2 + this.worldObj.rand.nextInt(10); int i;
/* 177 */     for (i = 0; i < var4; i++) {
/* 178 */       dropItemRand(Items.gold_nugget, 1);
/*     */     }
/* 180 */     var4 = 1 + this.worldObj.rand.nextInt(3);
/* 181 */     for (i = 0; i < var4; i++) {
/* 182 */       dropItemRand(OreSpawnMain.UraniumNugget, 1);
/*     */     }
/* 184 */     var4 = 1 + this.worldObj.rand.nextInt(3);
/* 185 */     for (i = 0; i < var4; i++) {
/* 186 */       dropItemRand(OreSpawnMain.TitaniumNugget, 1);
/*     */     }
/* 188 */     var4 = 2 + this.worldObj.rand.nextInt(3);
/* 189 */     for (i = 0; i < var4; i++) {
/* 190 */       dropItemRand(Items.diamond, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 199 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 207 */     super.onUpdate();
/*     */     
/* 209 */     this.motionY *= 0.6D;
/* 210 */     if (isInWater() && this.worldObj.rand.nextInt(20) == 1) {
/* 211 */       attackEntityAsMob((Entity)this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 222 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 228 */     int xdir = 1;
/* 229 */     int zdir = 1;
/*     */     
/* 231 */     int keep_trying = 50;
/*     */ 
/*     */ 
/*     */     
/* 235 */     if (this.isDead)
/* 236 */       return;  super.updateAITasks();
/*     */     
/* 238 */     if (this.lastX == (int)this.posX && this.lastZ == (int)this.posZ) {
/*     */       
/* 240 */       this.stuck_count++;
/*     */     } else {
/* 242 */       this.stuck_count = 0;
/* 243 */       this.lastX = (int)this.posX;
/* 244 */       this.lastZ = (int)this.posZ;
/*     */     } 
/*     */ 
/*     */     
/* 248 */     if (this.currentFlightTarget == null) {
/* 249 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */ 
/*     */     
/* 253 */     if (this.stuck_count > 50 || this.rand.nextInt(300) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*     */       
/* 255 */       Block bid = Blocks.stone;
/* 256 */       this.stuck_count = 0;
/* 257 */       while (bid != Blocks.air && keep_trying != 0) {
/* 258 */         zdir = this.rand.nextInt(9) + 4;
/* 259 */         xdir = this.rand.nextInt(9) + 4;
/* 260 */         if (this.rand.nextInt(2) == 0) zdir = -zdir; 
/* 261 */         if (this.rand.nextInt(2) == 0) xdir = -xdir; 
/* 262 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(6) - 3, (int)this.posZ + zdir);
/* 263 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 264 */         if (bid == Blocks.air && 
/* 265 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 266 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 269 */         keep_trying--;
/*     */       }
/*     */     
/* 272 */     } else if (this.rand.nextInt(8) == 0) {
/*     */ 
/*     */       
/* 275 */       EntityLivingBase e = null;
/* 276 */       e = (EntityLivingBase)this.rt;
/* 277 */       if (e != null && 
/* 278 */         e.isDead) e = null;
/*     */       
/* 280 */       if (e == null) {
/* 281 */         e = findSomethingToAttack();
/*     */       }
/* 283 */       if (e != null) {
/*     */ 
/*     */         
/* 286 */         setAttacking(1);
/* 287 */         this.currentFlightTarget.set((int)e.posX, (int)e.posY + 1, (int)e.posZ);
/* 288 */         if (getDistanceSqToEntity((Entity)e) < ((5.0F + e.width / 2.0F) * (5.0F + e.width / 2.0F))) {
/* 289 */           attackEntityAsMob((Entity)e);
/*     */         }
/*     */       } else {
/* 292 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */     
/* 296 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 297 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 298 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 299 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.30000000149011613D;
/* 300 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.20000000149011612D;
/* 301 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.30000000149011613D;
/* 302 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 303 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 304 */     this.moveForward = 1.0F;
/* 305 */     this.rotationYaw += var8 / 4.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 311 */     if (this.worldObj.rand.nextInt(100) == 1) {
/* 312 */       heal(1.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 323 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFallState(double par1, boolean par3) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 341 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 351 */     boolean ret = super.attackEntityFrom(par1DamageSource, par2);
/* 352 */     Entity e = par1DamageSource.getEntity();
/* 353 */     if (e != null && e instanceof EntityLivingBase && this.currentFlightTarget != null) {
/*     */       
/* 355 */       this.rt = e;
/* 356 */       this.currentFlightTarget.set((int)e.posX, (int)e.posY, (int)e.posZ);
/*     */     } 
/* 358 */     return ret;
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
/*     */   
/*     */   public boolean getCanSpawnHere() {
/*     */     int k;
/* 373 */     for (k = -2; k <= 2; k++) {
/*     */       
/* 375 */       for (int j = -2; j <= 2; j++) {
/*     */         
/* 377 */         for (int i = 1; i < 4; i++) {
/*     */           
/* 379 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 380 */           if (bid == Blocks.mob_spawner) {
/* 381 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 382 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 383 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 384 */             if (s != null && 
/* 385 */               s.equals("Mantis")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 391 */     for (k = -2; k < 2; k++) {
/*     */       
/* 393 */       for (int j = -2; j < 2; j++) {
/*     */         
/* 395 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 397 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 398 */           if (bid != Blocks.air) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 402 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID6 && this.worldObj.rand.nextInt(6) != 0) return false; 
/* 403 */     if (this.posY < 50.0D) return false; 
/* 404 */     if (!this.worldObj.isDaytime()) return false; 
/* 405 */     Mantis target = null;
/* 406 */     target = (Mantis)this.worldObj.findNearestEntityWithinAABB(Mantis.class, this.boundingBox.expand(32.0D, 16.0D, 32.0D), (Entity)this);
/* 407 */     if (target != null)
/*     */     {
/* 409 */       return false;
/*     */     }
/* 411 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 419 */     return OreSpawnMain.Mantis_stats.defense;
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
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 435 */     if (par1EntityLiving == null)
/*     */     {
/* 437 */       return false;
/*     */     }
/* 439 */     if (par1EntityLiving == this)
/*     */     {
/* 441 */       return false;
/*     */     }
/* 443 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 446 */       return false;
/*     */     }
/* 448 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 451 */       return false;
/*     */     }
/* 453 */     if (par1EntityLiving.isInWater())
/*     */     {
/* 455 */       return false;
/*     */     }
/* 457 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 459 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 460 */       if (p.capabilities.isCreativeMode == true) {
/* 461 */         return false;
/*     */       }
/* 463 */       return true;
/*     */     } 
/* 465 */     if (par1EntityLiving instanceof Mantis)
/*     */     {
/* 467 */       return false;
/*     */     }
/* 469 */     if (par1EntityLiving instanceof Irukandji)
/*     */     {
/* 471 */       return false;
/*     */     }
/* 473 */     if (par1EntityLiving instanceof Skate)
/*     */     {
/* 475 */       return false;
/*     */     }
/* 477 */     if (par1EntityLiving instanceof Flounder)
/*     */     {
/* 479 */       return false;
/*     */     }
/* 481 */     if (par1EntityLiving instanceof Whale)
/*     */     {
/* 483 */       return false;
/*     */     }
/* 485 */     if (par1EntityLiving instanceof net.minecraft.entity.passive.EntitySquid)
/*     */     {
/* 487 */       return false;
/*     */     }
/* 489 */     if (par1EntityLiving instanceof WaterDragon)
/*     */     {
/* 491 */       return false;
/*     */     }
/* 493 */     if (par1EntityLiving instanceof AttackSquid)
/*     */     {
/* 495 */       return false;
/*     */     }
/* 497 */     if (par1EntityLiving instanceof TerribleTerror)
/*     */     {
/* 499 */       return false;
/*     */     }
/* 501 */     if (par1EntityLiving instanceof LurkingTerror)
/*     */     {
/* 503 */       return false;
/*     */     }
/* 505 */     if (par1EntityLiving instanceof CloudShark)
/*     */     {
/* 507 */       return false;
/*     */     }
/* 509 */     if (par1EntityLiving instanceof Rotator)
/*     */     {
/* 511 */       return false;
/*     */     }
/* 513 */     if (par1EntityLiving instanceof Bee)
/*     */     {
/* 515 */       return false;
/*     */     }
/* 517 */     if (par1EntityLiving instanceof Mothra)
/*     */     {
/* 519 */       return false;
/*     */     }
/* 521 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 523 */       return true;
/*     */     }
/* 525 */     if (par1EntityLiving instanceof EntityButterfly)
/*     */     {
/* 527 */       return true;
/*     */     }
/* 529 */     if (par1EntityLiving instanceof Cockateil)
/*     */     {
/* 531 */       return true;
/*     */     }
/* 533 */     if (par1EntityLiving instanceof Fairy)
/*     */     {
/* 535 */       return true;
/*     */     }
/* 537 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 539 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 540 */       if (p.capabilities.isCreativeMode != true) {
/* 541 */         return true;
/*     */       }
/*     */     } 
/* 544 */     if (MyUtils.isAttackableNonMob(par1EntityLiving)) {
/* 545 */       return true;
/*     */     }
/* 547 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 552 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 553 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D));
/* 554 */     Collections.sort(var5, this.TargetSorter);
/* 555 */     Iterator<?> var2 = var5.iterator();
/* 556 */     Entity var3 = null;
/* 557 */     EntityLivingBase var4 = null;
/*     */     
/* 559 */     while (var2.hasNext()) {
/*     */       
/* 561 */       var3 = (Entity)var2.next();
/* 562 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 564 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 566 */         return var4;
/*     */       }
/*     */     } 
/* 569 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Mantis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */