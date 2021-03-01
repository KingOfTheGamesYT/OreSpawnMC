/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntitySmallFireball;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.util.math.Vec3d;
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
/*     */ public class Brutalfly
/*     */   extends EntityMob
/*     */ {
/*  57 */   private BlockPos currentFlightTarget = null;
/*  58 */   private int lastX = 0, lastZ = 0, lastY = 0;
/*  59 */   private int stuck_count = 0;
/*  60 */   private int wing_sound = 0;
/*  61 */   private int health_ticker = 100;
/*  62 */   private GenericTargetSorter TargetSorter = null;
/*  63 */   private float moveSpeed = 0.35F;
/*     */   
/*     */   public Brutalfly(World par1World) {
/*  66 */     super(par1World);
/*  67 */     setSize(5.0F, 2.0F);
/*  68 */     this.experienceValue = 100;
/*  69 */     this.isImmuneToFire = true;
/*  70 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  74 */     super.applyEntityAttributes();
/*  75 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  76 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  77 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  82 */     return !isNoDespawnRequired();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/*  87 */     return 6;
/*     */   }
/*     */   
/*     */   private int getBrutalflyHealth() {
/*  91 */     return (int)getHealth();
/*     */   }
/*     */   
/*     */   protected float getSoundVolume() {
/*  95 */     return 1.5F;
/*     */   }
/*     */   protected float getSoundPitch() {
/*  98 */     return 1.0F;
/*     */   }
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/* 102 */     return null;
/*     */   }
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/* 105 */     return null;
/*     */   }
/*     */   
/*     */   public void onDeath(DamageSource cause) {
/* 109 */     playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, getSoundVolume(), getSoundPitch());
/*     */   }
/*     */   
/*     */   public boolean canBePushed() {
/* 113 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 120 */     return 110;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAIDisabled() {
/* 125 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 131 */     super.onUpdate();
/*     */     
/* 133 */     this.motionY *= 0.6D;
/*     */     
/* 135 */     this.wing_sound++;
/* 136 */     if (this.wing_sound > 30) {
/*     */       
/* 138 */       if (!this.world.isRemote) playSound(SoundsHandler.ENTITY_MOTHRA_WINGS, 1.0F, 1.0F); 
/* 139 */       this.wing_sound = 0;
/*     */     } 
/*     */     
/* 142 */     this.health_ticker--;
/* 143 */     if (this.health_ticker <= 0) {
/* 144 */       if (getHealth() < mygetMaxHealth())
/* 145 */         heal(1.0F); 
/* 146 */       this.health_ticker = 100;
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean canSeeTarget(double pX, double pY, double pZ) {
/* 151 */     return (this.world.rayTraceBlocks(new Vec3d(this.posX, this.posY + 0.75D, this.posZ), new Vec3d(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 157 */     int xdir = 1;
/* 158 */     int zdir = 1;
/*     */     
/* 160 */     int keep_trying = 30;
/*     */     
/* 162 */     int shoot = 3;
/*     */     
/* 164 */     if (this.isDead)
/* 165 */       return;  super.updateAITasks();
/*     */     
/* 167 */     if (this.lastX == (int)this.posX && this.lastY == (int)this.posY && this.lastZ == (int)this.posZ) {
/*     */       
/* 169 */       this.stuck_count++;
/*     */     } else {
/* 171 */       this.stuck_count = 0;
/* 172 */       this.lastX = (int)this.posX;
/* 173 */       this.lastY = (int)this.posY;
/* 174 */       this.lastZ = (int)this.posZ;
/*     */     } 
/*     */     
/* 177 */     if (this.world.getDifficulty() == EnumDifficulty.HARD) shoot = 2;
/*     */ 
/*     */     
/* 180 */     if (this.currentFlightTarget == null) {
/* 181 */       this.currentFlightTarget = new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */     
/* 184 */     if (this.stuck_count > 30 || this.world.rand.nextInt(200) == 0 || this.currentFlightTarget.distanceSq((int)this.posX, (int)this.posY, (int)this.posZ) < 9.0D) {
/*     */ 
/*     */       
/* 187 */       int down = 0;
/*     */       
/* 189 */       int dist = 20;
/* 190 */       for (int i = -5; i <= 5; i += 5) {
/* 191 */         for (int j = -5; j <= 5; j += 5) {
/* 192 */           for (int k = 1; k < 20; k++) {
/* 193 */             Block block = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY - k, (int)this.posZ + i)).getBlock();
/*     */             
/* 195 */             if (block != Blocks.AIR) {
/* 196 */               if (k < dist) dist = k; 
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 202 */       if (dist > 10) down = dist - 10 + 1;
/*     */       
/* 204 */       Block bid = Blocks.STONE;
/* 205 */       while (bid != Blocks.AIR && keep_trying != 0) {
/* 206 */         xdir = 1; zdir = 1;
/* 207 */         if (this.world.rand.nextInt(2) == 0) xdir = -1; 
/* 208 */         if (this.world.rand.nextInt(2) == 0) zdir = -1; 
/* 209 */         int newz = this.rand.nextInt(20) + 8;
/* 210 */         newz *= zdir;
/* 211 */         int newx = this.rand.nextInt(20) + 8;
/* 212 */         newx *= xdir;
/* 213 */         this.currentFlightTarget = new BlockPos((int)this.posX + newx, (int)this.posY + this.world.rand.nextInt(7) - 1 - down, (int)this.posZ + newz);
/*     */         
/* 215 */         bid = this.world.getBlockState(new BlockPos(this.currentFlightTarget.getX(), this.currentFlightTarget.getY(), this.currentFlightTarget.getZ())).getBlock();
/*     */         
/* 217 */         if (bid == Blocks.AIR && 
/* 218 */           !canSeeTarget(this.currentFlightTarget.getX(), this.currentFlightTarget.getY(), this.currentFlightTarget.getZ())) {
/* 219 */           bid = Blocks.STONE;
/*     */         }
/*     */         
/* 222 */         keep_trying--;
/*     */       } 
/* 224 */       this.stuck_count = 0;
/*     */     } 
/*     */     
/* 227 */     if (this.world.rand.nextInt(6) == 0) {
/*     */       
/* 229 */       EntityPlayer target = null;
/*     */       
/* 231 */       target = (EntityPlayer)this.world.findNearestEntityWithinAABB(EntityPlayer.class, getEntityBoundingBox().expand(30.0D, 20.0D, 30.0D), (Entity)this);
/* 232 */       if (target != null)
/*     */       {
/* 234 */         if (!target.capabilities.isCreativeMode) {
/*     */           
/* 236 */           if (getEntitySenses().canSee((Entity)target)) {
/*     */             
/* 238 */             this.currentFlightTarget = new BlockPos((int)target.posX, (int)target.posY + 4, (int)target.posZ);
/*     */             
/* 240 */             if (this.rand.nextInt(shoot) == 0)
/* 241 */               attackWithSomething((EntityLivingBase)target); 
/*     */           } 
/*     */         } else {
/* 244 */           target = null;
/*     */         } 
/*     */       }
/*     */       
/* 248 */       if (target == null && this.world.rand.nextInt(3) == 0) {
/* 249 */         EntityLivingBase e = null;
/* 250 */         e = findSomethingToAttack();
/* 251 */         if (e != null) {
/*     */ 
/*     */           
/* 254 */           this.currentFlightTarget = new BlockPos((int)e.posX, (int)e.posY + 5, (int)e.posZ);
/*     */           
/* 256 */           if (getDistanceSq((Entity)e) > 25.0D) {
/* 257 */             if (this.world.rand.nextInt(shoot) == 0) {
/* 258 */               attackWithSomething(e);
/*     */             }
/*     */           } else {
/* 261 */             attackEntityAsMob((Entity)e);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 267 */     double var1 = this.currentFlightTarget.getX() + 0.5D - this.posX;
/* 268 */     double var3 = this.currentFlightTarget.getY() + 0.1D - this.posY;
/* 269 */     double var5 = this.currentFlightTarget.getZ() + 0.5D - this.posZ;
/* 270 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.30001D;
/* 271 */     this.motionY += (Math.signum(var3) * 0.7D - this.motionY) * 0.20001D;
/* 272 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.30001D;
/* 273 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 274 */     float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
/* 275 */     this.moveForward = 1.0F;
/* 276 */     this.rotationYaw += var8 / 8.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 282 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fall(float distance, float damageMultiplier) {}
/*     */ 
/*     */   
/*     */   protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 292 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 297 */     boolean ret = false;
/* 298 */     Entity e = par1DamageSource.getTrueSource();
/*     */     
/* 300 */     if (e != null && e instanceof Brutalfly) {
/* 301 */       return false;
/*     */     }
/* 303 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 305 */     if (e != null && this.currentFlightTarget != null)
/*     */     {
/*     */       
/* 308 */       this.currentFlightTarget = new BlockPos((int)e.posX, (int)e.posY + 2, (int)e.posZ);
/*     */     }
/*     */     
/* 311 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 317 */     super.readEntityFromNBT(par1NBTTagCompound);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 322 */     super.writeEntityToNBT(par1NBTTagCompound);
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
/*     */   public boolean getCanSpawnHere() {
/* 351 */     if (this.posY < 70.0D) return false;
/*     */     
/* 353 */     if (!isValidLightLevel()) return false; 
/* 354 */     if (this.world.isDaytime()) return false;
/*     */ 
/*     */ 
/*     */     
/* 358 */     for (int k = -4; k < 4; k++) {
/*     */       
/* 360 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 362 */         for (int i = 1; i < 10; i++) {
/*     */           
/* 364 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 365 */           if (bid != Blocks.AIR) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 373 */     Brutalfly target = null;
/* 374 */     target = (Brutalfly)this.world.findNearestEntityWithinAABB(Brutalfly.class, getEntityBoundingBox().expand(64.0D, 32.0D, 64.0D), (Entity)this);
/* 375 */     return (target == null);
/*     */   }
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
/*     */   private void dropItemRand(Item index, int par1) {
/* 388 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), new ItemStack(index, par1, 0));
/* 389 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 396 */     for (int i = 0; i < 20; i++) {
/* 397 */       float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
/* 398 */       float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
/* 399 */       float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
/* 400 */       this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + var1, this.posY + 2.0D + var2, this.posZ + var3, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */     } 
/*     */     int var4;
/* 403 */     for (var4 = 0; var4 < 53; var4++) {
/* 404 */       dropItemRand(Items.GOLD_NUGGET, 1);
/*     */     }
/*     */     
/* 407 */     for (var4 = 0; var4 < 20; var4++) {
/* 408 */       spawnCreature(this.world, "Butterfly", this.posX + 0.5D, this.posY + 1.0D, this.posZ + 0.5D);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 419 */     Entity var8 = null;
/*     */     
/* 421 */     if (par0World == null) return null;
/*     */ 
/*     */     
/* 424 */     var8 = EntityList.createEntityByIDFromName(new ResourceLocation(par1), par0World);
/*     */ 
/*     */     
/* 427 */     if (var8 != null) {
/*     */ 
/*     */       
/* 430 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 433 */       par0World.spawnEntity(var8);
/*     */       
/* 435 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     
/* 438 */     return var8;
/*     */   }
/*     */   
/*     */   private void attackWithSomething(EntityLivingBase par1) {
/* 442 */     double xzoff = 2.25D;
/*     */     
/* 444 */     double yoff = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 452 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 453 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*     */     
/* 455 */     if (this.world.getDifficulty() == EnumDifficulty.EASY) {
/* 456 */       EntitySmallFireball sf = new EntitySmallFireball(this.world, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 457 */       sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 458 */       sf.setPosition(cx, this.posY + yoff, cz);
/* 459 */       playSound(SoundEvents.ENTITY_ARROW_SHOOT, 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*     */       
/* 461 */       this.world.spawnEntity((Entity)sf);
/* 462 */     } else if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
/* 463 */       if (this.world.rand.nextInt(2) == 0) {
/* 464 */         EntitySmallFireball sf = new EntitySmallFireball(this.world, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 465 */         sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 466 */         sf.setPosition(cx, this.posY + yoff, cz);
/* 467 */         playSound(SoundEvents.ENTITY_ARROW_SHOOT, 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*     */         
/* 469 */         this.world.spawnEntity((Entity)sf);
/*     */       } else {
/* 471 */         BetterFireball bf = new BetterFireball(this.world, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 472 */         bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 473 */         bf.setPosition(cx, this.posY + yoff, cz);
/* 474 */         bf.setNotMe();
/* 475 */         playSound(SoundEvents.ITEM_FIRECHARGE_USE, 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 476 */         this.world.spawnEntity((Entity)bf);
/*     */       } 
/*     */     } else {
/* 479 */       BetterFireball bf = new BetterFireball(this.world, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 480 */       bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 481 */       bf.setPosition(cx, this.posY + yoff, cz);
/* 482 */       bf.setNotMe();
/* 483 */       playSound(SoundEvents.ITEM_FIRECHARGE_USE, 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 484 */       this.world.spawnEntity((Entity)bf);
/*     */     } 
/* 486 */     if (getHealth() < mygetMaxHealth()) {
/* 487 */       heal(1.0F);
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
/* 499 */     if (par1EntityLiving == null)
/*     */     {
/* 501 */       return false;
/*     */     }
/* 503 */     if (par1EntityLiving == this)
/*     */     {
/* 505 */       return false;
/*     */     }
/* 507 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 509 */       return false;
/*     */     }
/*     */     
/* 512 */     if (par1EntityLiving instanceof Brutalfly)
/*     */     {
/* 514 */       return false;
/*     */     }
/* 516 */     if (par1EntityLiving instanceof Mothra)
/*     */     {
/* 518 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 527 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving)) {
/* 528 */       return false;
/*     */     }
/*     */     
/* 531 */     if (par1EntityLiving instanceof EntityMob) {
/* 532 */       return true;
/*     */     }
/*     */     
/* 535 */     if (par1EntityLiving instanceof EntityPlayer) {
/* 536 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 537 */       return !p.capabilities.isCreativeMode;
/*     */     } 
/* 539 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 545 */     List<?> var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(25.0D, 20.0D, 25.0D));
/* 546 */     Collections.sort(var5, this.TargetSorter);
/* 547 */     Iterator<?> var2 = var5.iterator();
/* 548 */     Entity var3 = null;
/* 549 */     EntityLivingBase var4 = null;
/*     */     
/* 551 */     while (var2.hasNext()) {
/*     */       
/* 553 */       var3 = (Entity)var2.next();
/* 554 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 556 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 558 */         return var4;
/*     */       }
/*     */     } 
/* 561 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\Brutalfly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */