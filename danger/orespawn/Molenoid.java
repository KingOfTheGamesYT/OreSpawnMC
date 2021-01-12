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
/*     */ public class Molenoid
/*     */   extends EntityMob
/*     */ {
/*  51 */   private GenericTargetSorter TargetSorter = null;
/*  52 */   private float moveSpeed = 0.35F;
/*     */ 
/*     */   
/*     */   public Molenoid(World par1World) {
/*  56 */     super(par1World);
/*  57 */     setSize(3.9F, 2.6F);
/*  58 */     getNavigator().setAvoidsWater(true);
/*  59 */     this.experienceValue = 40;
/*  60 */     this.fireResistance = 100;
/*  61 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  62 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  63 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  64 */     this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  65 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  66 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  67 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  72 */     super.applyEntityAttributes();
/*  73 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  74 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  75 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Molenoid_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  80 */     super.entityInit();
/*  81 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  85 */     if (isNoDespawnRequired()) return false; 
/*  86 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  94 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  95 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 100 */     return OreSpawnMain.Molenoid_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 108 */     return OreSpawnMain.Molenoid_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 125 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 135 */     if (this.rand.nextInt(3) == 0) {
/* 136 */       return "orespawn:molenoid_living";
/*     */     }
/* 138 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 147 */     return "orespawn:molenoid_hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 155 */     return "orespawn:molenoid_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 162 */     return 1.1F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 169 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 179 */     return Items.beef;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 184 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/*     */     
/* 186 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 193 */     dropItemRand(OreSpawnMain.MolenoidNose, 1);
/* 194 */     dropItemRand(Items.item_frame, 1);
/*     */     
/*     */     int var4;
/* 197 */     for (var4 = 0; var4 < 10; var4++) {
/* 198 */       dropItemRand(Items.gold_nugget, 1);
/*     */     }
/* 200 */     for (var4 = 0; var4 < 6; var4++) {
/* 201 */       dropItemRand(Items.beef, 1);
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
/* 218 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 223 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/* 224 */       return false;
/*     */     }
/* 226 */     return super.attackEntityFrom(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 233 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 235 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 237 */         double ks = 0.8D;
/* 238 */         double inair = 0.1D;
/* 239 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 240 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 241 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 243 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 247 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 255 */     EntityLivingBase e = null;
/* 256 */     if (this.isDead)
/* 257 */       return;  super.updateAITasks();
/* 258 */     if (this.worldObj.rand.nextInt(4) == 0) {
/* 259 */       e = findSomethingToAttack();
/* 260 */       if (e != null) {
/* 261 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 262 */         if (getDistanceSqToEntity((Entity)e) < ((6.0F + e.width / 2.0F) * (6.0F + e.width / 2.0F))) {
/* 263 */           setAttacking(1);
/*     */           
/* 265 */           if (getDistanceSqToEntity((Entity)e) < 16.0D && (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1)) {
/*     */             
/* 267 */             attackEntityAsMob((Entity)e);
/*     */           
/*     */           }
/* 270 */           else if (OreSpawnMain.PlayNicely == 0) {
/* 271 */             int j = 1 + this.worldObj.rand.nextInt(4);
/* 272 */             for (int k = 0; k < j; k++) {
/* 273 */               double d1 = e.posX;
/* 274 */               double d2 = e.posZ;
/* 275 */               d1 += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0D;
/* 276 */               d2 += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0D;
/* 277 */               for (int i = 4; i > -3; i--) {
/* 278 */                 if (this.worldObj.getBlock((int)d1, (int)e.posY + i + 1, (int)d2) == Blocks.air && 
/* 279 */                   this.worldObj.getBlock((int)d1, (int)e.posY + i, (int)d2) != Blocks.air) {
/* 280 */                   this.worldObj.setBlock((int)d1, (int)e.posY + i + 1, (int)d2, OreSpawnMain.MyMoleDirtBlock);
/*     */ 
/*     */                   
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } else {
/* 289 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 292 */         setAttacking(0);
/*     */       } 
/*     */     } 
/* 295 */     if (this.worldObj.isRemote)
/* 296 */       return;  if (this.worldObj.rand.nextInt(2) == 0) {
/* 297 */       double spd = 0.0D;
/*     */       
/* 299 */       spd = this.motionX * this.motionX + this.motionZ * this.motionZ;
/* 300 */       spd = Math.sqrt(spd);
/* 301 */       if (spd > this.moveSpeed) spd = this.moveSpeed; 
/* 302 */       int odds = (int)(100.0D * spd / this.moveSpeed);
/*     */       
/* 304 */       if (odds > 0 && 
/* 305 */         this.worldObj.rand.nextInt(100) < odds && OreSpawnMain.PlayNicely == 0) {
/*     */ 
/*     */         
/* 308 */         double d1 = this.posX + 6.0D * Math.sin(Math.toRadians(this.rotationYawHead));
/* 309 */         double d2 = this.posZ - 6.0D * Math.cos(Math.toRadians(this.rotationYawHead));
/* 310 */         d1 += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0D;
/* 311 */         d2 += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0D;
/* 312 */         for (int i = 4; i > -4; i--) {
/* 313 */           if (this.worldObj.getBlock((int)d1, (int)this.posY + i + 1, (int)d2) == Blocks.air && 
/* 314 */             this.worldObj.getBlock((int)d1, (int)this.posY + i, (int)d2) != Blocks.air) {
/* 315 */             this.worldObj.setBlock((int)d1, (int)this.posY + i + 1, (int)d2, OreSpawnMain.MyMoleDirtBlock);
/*     */ 
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 326 */     double dx = this.posX - 3.0D * Math.sin(Math.toRadians(this.rotationYawHead));
/* 327 */     double dz = this.posZ + 3.0D * Math.cos(Math.toRadians(this.rotationYawHead));
/* 328 */     dx += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0D;
/* 329 */     dz += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0D;
/* 330 */     int dir = 1;
/* 331 */     if (e != null) {
/* 332 */       if ((int)e.posY > (int)this.posY) dir = 2; 
/* 333 */       if ((int)e.posY < (int)this.posY) dir = 0; 
/*     */     } 
/* 335 */     if (OreSpawnMain.PlayNicely == 0) {
/* 336 */       for (int i = dir; i < dir + 3; i++) {
/* 337 */         Block bid = this.worldObj.getBlock((int)dx, (int)this.posY + i, (int)dz);
/* 338 */         if ((bid == Blocks.dirt || bid == Blocks.grass || bid == Blocks.gravel || bid == Blocks.sand || bid == Blocks.leaves) && 
/* 339 */           this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock((int)dx, (int)this.posY + i, (int)dz, Blocks.air);
/*     */         
/* 341 */         if (bid == OreSpawnMain.MyMoleDirtBlock) {
/* 342 */           this.worldObj.setBlock((int)dx, (int)this.posY + i, (int)dz, Blocks.air);
/*     */         }
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
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 356 */     if (par1EntityLiving == null)
/*     */     {
/* 358 */       return false;
/*     */     }
/* 360 */     if (par1EntityLiving == this)
/*     */     {
/* 362 */       return false;
/*     */     }
/* 364 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 366 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 375 */     if (!MyCanSee(par1EntityLiving)) {
/* 376 */       return false;
/*     */     }
/*     */     
/* 379 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 381 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 382 */       if (p.capabilities.isCreativeMode == true) {
/* 383 */         return false;
/*     */       }
/* 385 */       return true;
/*     */     } 
/* 387 */     if (par1EntityLiving instanceof Molenoid)
/*     */     {
/* 389 */       return false;
/*     */     }
/*     */     
/* 392 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 394 */       return true;
/*     */     }
/* 396 */     if (MyUtils.isAttackableNonMob(par1EntityLiving)) {
/* 397 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 401 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 406 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 407 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 6.0D, 12.0D));
/* 408 */     Collections.sort(var5, this.TargetSorter);
/* 409 */     Iterator<?> var2 = var5.iterator();
/* 410 */     Entity var3 = null;
/* 411 */     EntityLivingBase var4 = null;
/*     */     
/* 413 */     while (var2.hasNext()) {
/*     */       
/* 415 */       var3 = (Entity)var2.next();
/* 416 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 418 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 420 */         return var4;
/*     */       }
/*     */     } 
/* 423 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 428 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 433 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
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
/* 445 */     for (k = -3; k < 3; k++) {
/*     */       
/* 447 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 449 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 451 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 452 */           if (bid == Blocks.mob_spawner) {
/* 453 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 454 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 455 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 456 */             if (s != null && 
/* 457 */               s.equals("Molenoid")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 463 */     if (!isValidLightLevel()) return false; 
/* 464 */     if (this.posY < 50.0D) return false; 
/* 465 */     if (this.worldObj.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 469 */     for (k = -1; k < 1; k++) {
/*     */       
/* 471 */       for (int j = -1; j < 1; j++) {
/*     */         
/* 473 */         for (int i = 1; i < 4; i++) {
/*     */           
/* 475 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 476 */           if (bid != Blocks.air) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 482 */     Molenoid target = null;
/* 483 */     target = (Molenoid)this.worldObj.findNearestEntityWithinAABB(Molenoid.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D), (Entity)this);
/* 484 */     if (target != null)
/*     */     {
/* 486 */       return false;
/*     */     }
/* 488 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean MyCanSee(EntityLivingBase e) {
/* 499 */     double xzoff = 2.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 506 */     int nblks = 10;
/*     */     
/* 508 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 509 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/* 510 */     float startx = (float)cx;
/* 511 */     float starty = (float)(this.posY + 1.0D);
/* 512 */     float startz = (float)cz;
/* 513 */     float dx = (float)((e.posX - startx) / 10.0D);
/* 514 */     float dy = (float)((e.posY + (e.height / 2.0F) - starty) / 10.0D);
/* 515 */     float dz = (float)((e.posZ - startz) / 10.0D);
/*     */     
/* 517 */     if (Math.abs(dx) > 1.0D) {
/* 518 */       dy /= Math.abs(dx);
/* 519 */       dz /= Math.abs(dx);
/* 520 */       nblks = (int)(nblks * Math.abs(dx));
/* 521 */       if (dx > 1.0F) dx = 1.0F; 
/* 522 */       if (dx < -1.0F) dx = -1.0F; 
/*     */     } 
/* 524 */     if (Math.abs(dy) > 1.0D) {
/* 525 */       dx /= Math.abs(dy);
/* 526 */       dz /= Math.abs(dy);
/* 527 */       nblks = (int)(nblks * Math.abs(dy));
/* 528 */       if (dy > 1.0F) dy = 1.0F; 
/* 529 */       if (dy < -1.0F) dy = -1.0F; 
/*     */     } 
/* 531 */     if (Math.abs(dz) > 1.0D) {
/* 532 */       dy /= Math.abs(dz);
/* 533 */       dx /= Math.abs(dz);
/* 534 */       nblks = (int)(nblks * Math.abs(dz));
/* 535 */       if (dz > 1.0F) dz = 1.0F; 
/* 536 */       if (dz < -1.0F) dz = -1.0F;
/*     */     
/*     */     } 
/* 539 */     for (int i = 0; i < nblks; ) {
/* 540 */       startx += dx;
/* 541 */       starty += dy;
/* 542 */       startz += dz;
/* 543 */       Block bid = this.worldObj.getBlock((int)startx, (int)starty, (int)startz);
/* 544 */       if (bid == Blocks.air || 
/* 545 */         bid == OreSpawnMain.MyMoleDirtBlock || 
/* 546 */         bid == Blocks.dirt || 
/* 547 */         bid == Blocks.grass || 
/* 548 */         bid == Blocks.tallgrass || 
/* 549 */         bid == Blocks.sand || 
/* 550 */         bid == Blocks.gravel) { i++; continue; }
/* 551 */        return false;
/*     */     } 
/*     */ 
/*     */     
/* 555 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Molenoid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */