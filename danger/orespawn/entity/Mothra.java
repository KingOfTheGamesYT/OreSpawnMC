/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.IMob;
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
/*     */ public class Mothra
/*     */   extends Butterfly
/*     */   implements IMob
/*     */ {
/*  56 */   private BlockPos currentFlightTarget = null;
/*  57 */   private int lastX = 0, lastZ = 0, lastY = 0;
/*  58 */   private int stuck_count = 0;
/*  59 */   private int wing_sound = 0;
/*  60 */   private int health_ticker = 100;
/*  61 */   private GenericTargetSorter TargetSorter = null;
/*  62 */   private float moveSpeed = 0.35F;
/*     */   
/*     */   public Mothra(World par1World) {
/*  65 */     super(par1World);
/*  66 */     setSize(5.0F, 2.0F);
/*  67 */     this.experienceValue = 100;
/*  68 */     this.isImmuneToFire = true;
/*  69 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyEntityAttributes() {
/*  75 */     super.applyEntityAttributes();
/*  76 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  77 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  78 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
/*  79 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  84 */     return !isNoDespawnRequired();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/*  89 */     return 8;
/*     */   }
/*     */   public int getMothraHealth() {
/*  92 */     return (int)getHealth();
/*     */   }
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
/*     */   @Nullable
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/* 106 */     return null;
/*     */   }
/*     */   
/*     */   public void onDeath(DamageSource cause) {
/* 110 */     playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, getSoundVolume(), getSoundPitch());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 115 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 122 */     return 150;
/*     */   }
/*     */   
/*     */   public boolean isAIDisabled() {
/* 126 */     return false;
/*     */   }
/*     */   
/*     */   public void onUpdate() {
/* 130 */     super.onUpdate();
/*     */     
/* 132 */     this.motionY *= 0.6D;
/*     */     
/* 134 */     this.wing_sound++;
/* 135 */     if (this.wing_sound > 30) {
/* 136 */       if (!this.world.isRemote) playSound(SoundsHandler.ENTITY_MOTHRA_WINGS, 1.0F, 1.0F); 
/* 137 */       this.wing_sound = 0;
/*     */     } 
/*     */     
/* 140 */     this.health_ticker--;
/* 141 */     if (this.health_ticker <= 0) {
/* 142 */       if (getHealth() < mygetMaxHealth())
/* 143 */         heal(1.0F); 
/* 144 */       this.health_ticker = 200;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 153 */     return (this.world.rayTraceBlocks(new Vec3d(this.posX, this.posY + 0.75D, this.posZ), new Vec3d(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAITasks() {
/* 159 */     int xdir = 1;
/* 160 */     int zdir = 1;
/*     */     
/* 162 */     int keep_trying = 50;
/*     */     
/* 164 */     int shoot = 3;
/*     */     
/* 166 */     if (this.isDead)
/* 167 */       return;  super.updateAITasks();
/*     */     
/* 169 */     if (this.lastX == (int)this.posX && this.lastY == (int)this.posY && this.lastZ == (int)this.posZ) {
/*     */       
/* 171 */       this.stuck_count++;
/*     */     } else {
/* 173 */       this.stuck_count = 0;
/* 174 */       this.lastX = (int)this.posX;
/* 175 */       this.lastY = (int)this.posY;
/* 176 */       this.lastZ = (int)this.posZ;
/*     */     } 
/*     */     
/* 179 */     if (this.world.getDifficulty() == EnumDifficulty.HARD) shoot = 2;
/*     */ 
/*     */     
/* 182 */     if (this.currentFlightTarget == null) {
/* 183 */       this.currentFlightTarget = new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */     
/* 186 */     if (this.stuck_count > 50 || this.world.rand.nextInt(300) == 0 || this.currentFlightTarget.distanceSq((int)this.posX, (int)this.posY, (int)this.posZ) < 9.0D) {
/*     */       
/* 188 */       int down = 0;
/*     */       
/* 190 */       int dist = 20;
/* 191 */       for (int i = -5; i <= 5; i += 5) {
/* 192 */         for (int j = -5; j <= 5; j += 5) {
/* 193 */           for (int k = 1; k < 20; k++) {
/* 194 */             Block block = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY - k, (int)this.posZ + i)).getBlock();
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
/* 207 */         if (this.rand.nextInt(2) == 0) xdir = -1; 
/* 208 */         if (this.rand.nextInt(2) == 0) zdir = -1; 
/* 209 */         int newz = this.rand.nextInt(20) + 8;
/* 210 */         newz *= zdir;
/* 211 */         int newx = this.rand.nextInt(20) + 8;
/* 212 */         newx *= xdir;
/* 213 */         this.currentFlightTarget = new BlockPos((int)this.posX + newx, (int)this.posY + this.rand.nextInt(7) - 1 - down, (int)this.posZ + newz);
/* 214 */         bid = this.world.getBlockState(new BlockPos(this.currentFlightTarget.getX(), this.currentFlightTarget.getY(), this.currentFlightTarget.getZ())).getBlock();
/* 215 */         if (bid == Blocks.AIR && 
/* 216 */           !canSeeTarget(this.currentFlightTarget.getX(), this.currentFlightTarget.getY(), this.currentFlightTarget.getZ())) {
/* 217 */           bid = Blocks.STONE;
/*     */         }
/*     */         
/* 220 */         keep_trying--;
/*     */       } 
/* 222 */       this.stuck_count = 0;
/*     */     }
/* 224 */     else if (this.world.rand.nextInt(10) == 0 && this.world.getDifficulty() != EnumDifficulty.PEACEFUL) {
/*     */       
/* 226 */       EntityPlayer target = null;
/*     */       
/* 228 */       target = (EntityPlayer)this.world.findNearestEntityWithinAABB(EntityPlayer.class, getEntityBoundingBox().expand(25.0D, 20.0D, 25.0D), (Entity)this);
/* 229 */       if (target != null)
/*     */       {
/* 231 */         if (!target.capabilities.isCreativeMode) {
/*     */           
/* 233 */           if (getEntitySenses().canSee((Entity)target)) {
/*     */             
/* 235 */             this.currentFlightTarget = new BlockPos((int)target.posX, (int)target.posY + 4, (int)target.posZ);
/* 236 */             if (this.rand.nextInt(shoot) == 0)
/* 237 */               attackWithSomething((EntityLivingBase)target); 
/*     */           } 
/*     */         } else {
/* 240 */           target = null;
/*     */         } 
/*     */       }
/*     */       
/* 244 */       if (target == null && this.world.rand.nextInt(3) == 0) {
/* 245 */         EntityLivingBase e = null;
/* 246 */         e = findSomethingToAttack();
/* 247 */         if (e != null) {
/*     */ 
/*     */           
/* 250 */           this.currentFlightTarget = new BlockPos((int)e.posX, (int)e.posY + 5, (int)e.posZ);
/* 251 */           if (this.world.rand.nextInt(shoot) == 0) {
/* 252 */             attackWithSomething(e);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 258 */     double var1 = this.currentFlightTarget.getX() + 0.5D - this.posX;
/* 259 */     double var3 = this.currentFlightTarget.getY() + 0.1D - this.posY;
/* 260 */     double var5 = this.currentFlightTarget.getZ() + 0.5D - this.posZ;
/* 261 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.30001D;
/* 262 */     this.motionY += (Math.signum(var3) * 0.7D - this.motionY) * 0.20001D;
/* 263 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.30001D;
/* 264 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 265 */     float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
/* 266 */     this.moveForward = 1.0F;
/* 267 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 276 */     return false;
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
/* 294 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 302 */     boolean ret = false;
/* 303 */     Entity e = par1DamageSource.getTrueSource();
/*     */     
/* 305 */     if (e != null && e instanceof Mothra) {
/* 306 */       return false;
/*     */     }
/* 308 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 310 */     if (e != null && this.currentFlightTarget != null)
/*     */     {
/*     */       
/* 313 */       this.currentFlightTarget = new BlockPos((int)e.posX, (int)e.posY + 2, (int)e.posZ);
/*     */     }
/* 315 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 324 */     super.readEntityFromNBT(par1NBTTagCompound);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 332 */     super.writeEntityToNBT(par1NBTTagCompound);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 364 */     if (this.posY < 70.0D) return false;
/*     */ 
/*     */     
/* 367 */     if (this.world.isDaytime()) return false;
/*     */ 
/*     */ 
/*     */     
/* 371 */     for (int k = -4; k < 4; k++) {
/*     */       
/* 373 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 375 */         for (int i = 1; i < 10; i++) {
/*     */           
/* 377 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 378 */           if (bid != Blocks.AIR) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 386 */     Mothra target = null;
/* 387 */     target = (Mothra)this.world.findNearestEntityWithinAABB(Mothra.class, getEntityBoundingBox().expand(64.0D, 32.0D, 64.0D), (Entity)this);
/* 388 */     if (target != null)
/*     */     {
/* 390 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 394 */     return true;
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
/* 407 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), new ItemStack(index, par1, 0));
/* 408 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 415 */     dropItemRand(Items.ITEM_FRAME, 1);
/*     */     
/* 417 */     for (int i = 0; i < 20; i++) {
/* 418 */       float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
/* 419 */       float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
/* 420 */       float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
/* 421 */       this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + var1, this.posY + 2.0D + var2, this.posZ + var3, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */     } 
/*     */     int var4;
/* 424 */     for (var4 = 0; var4 < 53; var4++) {
/* 425 */       dropItemRand(Items.GOLD_NUGGET, 1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 432 */     for (var4 = 0; var4 < 3; var4++) {
/* 433 */       dropItemRand(Items.BLAZE_ROD, 1);
/*     */     }
/*     */     
/* 436 */     dropItemRand(Items.NETHER_STAR, 1);
/*     */     
/* 438 */     for (var4 = 0; var4 < 20; var4++) {
/* 439 */       spawnCreature(this.world, "Moth", this.posX + 0.5D, this.posY + 1.0D, this.posZ + 0.5D);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 458 */     Entity var8 = null;
/*     */     
/* 460 */     if (par0World == null) return null;
/*     */ 
/*     */     
/* 463 */     var8 = EntityList.createEntityByIDFromName(new ResourceLocation(par1), par0World);
/*     */ 
/*     */     
/* 466 */     if (var8 != null) {
/*     */ 
/*     */       
/* 469 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 472 */       par0World.spawnEntity(var8);
/*     */       
/* 474 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     
/* 477 */     return var8;
/*     */   }
/*     */   
/*     */   private void attackWithSomething(EntityLivingBase par1) {
/* 481 */     double xzoff = 2.25D;
/*     */     
/* 483 */     double yoff = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 489 */     if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL)
/*     */       return; 
/* 491 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 492 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*     */     
/* 494 */     if (this.world.getDifficulty() == EnumDifficulty.EASY) {
/* 495 */       EntitySmallFireball sf = new EntitySmallFireball(this.world, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 496 */       sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 497 */       sf.setPosition(cx, this.posY + yoff, cz);
/* 498 */       playSound(SoundEvents.ENTITY_ARROW_SHOOT, 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*     */       
/* 500 */       this.world.spawnEntity((Entity)sf);
/* 501 */     } else if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
/* 502 */       if (this.world.rand.nextInt(2) == 0) {
/* 503 */         EntitySmallFireball sf = new EntitySmallFireball(this.world, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 504 */         sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 505 */         sf.setPosition(cx, this.posY + yoff, cz);
/* 506 */         playSound(SoundEvents.ENTITY_ARROW_SHOOT, 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 507 */         this.world.spawnEntity((Entity)sf);
/*     */       } else {
/* 509 */         BetterFireball bf = new BetterFireball(this.world, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 510 */         bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 511 */         bf.setPosition(cx, this.posY + yoff, cz);
/* 512 */         bf.setNotMe();
/*     */         
/* 514 */         playSound(SoundEvents.ITEM_FIRECHARGE_USE, 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 515 */         this.world.spawnEntity((Entity)bf);
/*     */       } 
/*     */     } else {
/* 518 */       BetterFireball bf = new BetterFireball(this.world, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 519 */       bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 520 */       bf.setPosition(cx, this.posY + yoff, cz);
/* 521 */       bf.setNotMe();
/* 522 */       playSound(SoundEvents.ITEM_FIRECHARGE_USE, 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 523 */       this.world.spawnEntity((Entity)bf);
/*     */     } 
/* 525 */     if (getHealth() < mygetMaxHealth()) {
/* 526 */       heal(1.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 536 */     if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL) return false;
/*     */     
/* 538 */     if (par1EntityLiving == null)
/*     */     {
/* 540 */       return false;
/*     */     }
/* 542 */     if (par1EntityLiving == this)
/*     */     {
/* 544 */       return false;
/*     */     }
/* 546 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 548 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 553 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/* 555 */       return false;
/*     */     }
/* 557 */     if (par1EntityLiving instanceof Mothra)
/*     */     {
/* 559 */       return false;
/*     */     }
/* 561 */     if (par1EntityLiving instanceof Brutalfly)
/*     */     {
/* 563 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 570 */     if (par1EntityLiving instanceof VelocityRaptor)
/*     */     {
/* 572 */       return false;
/*     */     }
/* 574 */     if (par1EntityLiving instanceof Cryolophosaurus)
/*     */     {
/* 576 */       return false;
/*     */     }
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
/* 599 */     if (par1EntityLiving instanceof Mantis)
/*     */     {
/* 601 */       return false;
/*     */     }
/*     */     
/* 604 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 606 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 607 */       if (p.capabilities.isCreativeMode) {
/* 608 */         return false;
/*     */       }
/*     */     } 
/* 611 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 616 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 617 */     List<?> var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(15.0D, 20.0D, 15.0D));
/* 618 */     Collections.sort(var5, this.TargetSorter);
/* 619 */     Iterator<?> var2 = var5.iterator();
/* 620 */     Entity var3 = null;
/* 621 */     EntityLivingBase var4 = null;
/*     */     
/* 623 */     while (var2.hasNext()) {
/*     */       
/* 625 */       var3 = (Entity)var2.next();
/* 626 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 628 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 630 */         return var4;
/*     */       }
/*     */     } 
/* 633 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\Mothra.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */