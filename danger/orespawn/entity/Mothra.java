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
/*  78 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  83 */     return !isNoDespawnRequired();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/*  88 */     return 8;
/*     */   }
/*     */   private int getMothraHealth() {
/*  91 */     return (int)getHealth();
/*     */   }
/*     */   protected float getSoundVolume() {
/*  94 */     return 1.5F;
/*     */   }
/*     */   protected float getSoundPitch() {
/*  97 */     return 1.0F;
/*     */   }
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/* 101 */     return null;
/*     */   }
/*     */   @Nullable
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/* 105 */     return null;
/*     */   }
/*     */   
/*     */   public void onDeath(DamageSource cause) {
/* 109 */     playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, getSoundVolume(), getSoundPitch());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 121 */     return 150;
/*     */   }
/*     */   
/*     */   public boolean isAIDisabled() {
/* 125 */     return false;
/*     */   }
/*     */   
/*     */   public void onUpdate() {
/* 129 */     super.onUpdate();
/*     */     
/* 131 */     this.motionY *= 0.6D;
/*     */     
/* 133 */     this.wing_sound++;
/* 134 */     if (this.wing_sound > 30) {
/* 135 */       if (!this.world.isRemote) playSound(SoundsHandler.ENTITY_MOTHRA_WINGS, 1.0F, 1.0F); 
/* 136 */       this.wing_sound = 0;
/*     */     } 
/*     */     
/* 139 */     this.health_ticker--;
/* 140 */     if (this.health_ticker <= 0) {
/* 141 */       if (getHealth() < mygetMaxHealth())
/* 142 */         heal(1.0F); 
/* 143 */       this.health_ticker = 200;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 152 */     return (this.world.rayTraceBlocks(new Vec3d(this.posX, this.posY + 0.75D, this.posZ), new Vec3d(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAITasks() {
/* 158 */     int xdir = 1;
/* 159 */     int zdir = 1;
/*     */     
/* 161 */     int keep_trying = 50;
/*     */     
/* 163 */     int shoot = 3;
/*     */     
/* 165 */     if (this.isDead)
/* 166 */       return;  super.updateAITasks();
/*     */     
/* 168 */     if (this.lastX == (int)this.posX && this.lastY == (int)this.posY && this.lastZ == (int)this.posZ) {
/*     */       
/* 170 */       this.stuck_count++;
/*     */     } else {
/* 172 */       this.stuck_count = 0;
/* 173 */       this.lastX = (int)this.posX;
/* 174 */       this.lastY = (int)this.posY;
/* 175 */       this.lastZ = (int)this.posZ;
/*     */     } 
/*     */     
/* 178 */     if (this.world.getDifficulty() == EnumDifficulty.HARD) shoot = 2;
/*     */ 
/*     */     
/* 181 */     if (this.currentFlightTarget == null) {
/* 182 */       this.currentFlightTarget = new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */     
/* 185 */     if (this.stuck_count > 50 || this.world.rand.nextInt(300) == 0 || this.currentFlightTarget.distanceSq((int)this.posX, (int)this.posY, (int)this.posZ) < 9.0D) {
/*     */       
/* 187 */       int down = 0;
/*     */       
/* 189 */       int dist = 20;
/* 190 */       for (int i = -5; i <= 5; i += 5) {
/* 191 */         for (int j = -5; j <= 5; j += 5) {
/* 192 */           for (int k = 1; k < 20; k++) {
/* 193 */             Block block = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY - k, (int)this.posZ + i)).getBlock();
/* 194 */             if (block != Blocks.AIR) {
/* 195 */               if (k < dist) dist = k; 
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 201 */       if (dist > 10) down = dist - 10 + 1;
/*     */       
/* 203 */       Block bid = Blocks.STONE;
/* 204 */       while (bid != Blocks.AIR && keep_trying != 0) {
/* 205 */         xdir = 1; zdir = 1;
/* 206 */         if (this.rand.nextInt(2) == 0) xdir = -1; 
/* 207 */         if (this.rand.nextInt(2) == 0) zdir = -1; 
/* 208 */         int newz = this.rand.nextInt(20) + 8;
/* 209 */         newz *= zdir;
/* 210 */         int newx = this.rand.nextInt(20) + 8;
/* 211 */         newx *= xdir;
/* 212 */         this.currentFlightTarget = new BlockPos((int)this.posX + newx, (int)this.posY + this.rand.nextInt(7) - 1 - down, (int)this.posZ + newz);
/* 213 */         bid = this.world.getBlockState(new BlockPos(this.currentFlightTarget.getX(), this.currentFlightTarget.getY(), this.currentFlightTarget.getZ())).getBlock();
/* 214 */         if (bid == Blocks.AIR && 
/* 215 */           !canSeeTarget(this.currentFlightTarget.getX(), this.currentFlightTarget.getY(), this.currentFlightTarget.getZ())) {
/* 216 */           bid = Blocks.STONE;
/*     */         }
/*     */         
/* 219 */         keep_trying--;
/*     */       } 
/* 221 */       this.stuck_count = 0;
/*     */     }
/* 223 */     else if (this.world.rand.nextInt(10) == 0 && this.world.getDifficulty() != EnumDifficulty.PEACEFUL) {
/*     */       
/* 225 */       EntityPlayer target = null;
/*     */       
/* 227 */       target = (EntityPlayer)this.world.findNearestEntityWithinAABB(EntityPlayer.class, getEntityBoundingBox().expand(25.0D, 20.0D, 25.0D), (Entity)this);
/* 228 */       if (target != null)
/*     */       {
/* 230 */         if (!target.capabilities.isCreativeMode) {
/*     */           
/* 232 */           if (getEntitySenses().canSee((Entity)target)) {
/*     */             
/* 234 */             this.currentFlightTarget = new BlockPos((int)target.posX, (int)target.posY + 4, (int)target.posZ);
/* 235 */             if (this.rand.nextInt(shoot) == 0)
/* 236 */               attackWithSomething((EntityLivingBase)target); 
/*     */           } 
/*     */         } else {
/* 239 */           target = null;
/*     */         } 
/*     */       }
/*     */       
/* 243 */       if (target == null && this.world.rand.nextInt(3) == 0) {
/* 244 */         EntityLivingBase e = null;
/* 245 */         e = findSomethingToAttack();
/* 246 */         if (e != null) {
/*     */ 
/*     */           
/* 249 */           this.currentFlightTarget = new BlockPos((int)e.posX, (int)e.posY + 5, (int)e.posZ);
/* 250 */           if (this.world.rand.nextInt(shoot) == 0) {
/* 251 */             attackWithSomething(e);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 257 */     double var1 = this.currentFlightTarget.getX() + 0.5D - this.posX;
/* 258 */     double var3 = this.currentFlightTarget.getY() + 0.1D - this.posY;
/* 259 */     double var5 = this.currentFlightTarget.getZ() + 0.5D - this.posZ;
/* 260 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.30001D;
/* 261 */     this.motionY += (Math.signum(var3) * 0.7D - this.motionY) * 0.20001D;
/* 262 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.30001D;
/* 263 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 264 */     float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
/* 265 */     this.moveForward = 1.0F;
/* 266 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 275 */     return false;
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
/* 293 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 301 */     boolean ret = false;
/* 302 */     Entity e = par1DamageSource.getTrueSource();
/*     */     
/* 304 */     if (e != null && e instanceof Mothra) {
/* 305 */       return false;
/*     */     }
/* 307 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 309 */     if (e != null && this.currentFlightTarget != null)
/*     */     {
/*     */       
/* 312 */       this.currentFlightTarget = new BlockPos((int)e.posX, (int)e.posY + 2, (int)e.posZ);
/*     */     }
/* 314 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 323 */     super.readEntityFromNBT(par1NBTTagCompound);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 331 */     super.writeEntityToNBT(par1NBTTagCompound);
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
/* 363 */     if (this.posY < 70.0D) return false;
/*     */ 
/*     */     
/* 366 */     if (this.world.isDaytime()) return false;
/*     */ 
/*     */ 
/*     */     
/* 370 */     for (int k = -4; k < 4; k++) {
/*     */       
/* 372 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 374 */         for (int i = 1; i < 10; i++) {
/*     */           
/* 376 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 377 */           if (bid != Blocks.AIR) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 385 */     Mothra target = null;
/* 386 */     target = (Mothra)this.world.findNearestEntityWithinAABB(Mothra.class, getEntityBoundingBox().expand(64.0D, 32.0D, 64.0D), (Entity)this);
/* 387 */     if (target != null)
/*     */     {
/* 389 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 393 */     return true;
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
/* 406 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8), new ItemStack(index, par1, 0));
/* 407 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 414 */     dropItemRand(Items.ITEM_FRAME, 1);
/*     */     
/* 416 */     for (int i = 0; i < 20; i++) {
/* 417 */       float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
/* 418 */       float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
/* 419 */       float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
/* 420 */       this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + var1, this.posY + 2.0D + var2, this.posZ + var3, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */     } 
/*     */     int var4;
/* 423 */     for (var4 = 0; var4 < 53; var4++) {
/* 424 */       dropItemRand(Items.GOLD_NUGGET, 1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 431 */     for (var4 = 0; var4 < 3; var4++) {
/* 432 */       dropItemRand(Items.BLAZE_ROD, 1);
/*     */     }
/*     */     
/* 435 */     dropItemRand(Items.NETHER_STAR, 1);
/*     */     
/* 437 */     for (var4 = 0; var4 < 20; var4++) {
/* 438 */       spawnCreature(this.world, "Moth", this.posX + 0.5D, this.posY + 1.0D, this.posZ + 0.5D);
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
/* 457 */     Entity var8 = null;
/*     */     
/* 459 */     if (par0World == null) return null;
/*     */ 
/*     */     
/* 462 */     var8 = EntityList.createEntityByIDFromName(new ResourceLocation(par1), par0World);
/*     */ 
/*     */     
/* 465 */     if (var8 != null) {
/*     */ 
/*     */       
/* 468 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 471 */       par0World.spawnEntity(var8);
/*     */       
/* 473 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     
/* 476 */     return var8;
/*     */   }
/*     */   
/*     */   private void attackWithSomething(EntityLivingBase par1) {
/* 480 */     double xzoff = 2.25D;
/*     */     
/* 482 */     double yoff = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 488 */     if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL)
/*     */       return; 
/* 490 */     double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
/* 491 */     double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
/*     */     
/* 493 */     if (this.world.getDifficulty() == EnumDifficulty.EASY) {
/* 494 */       EntitySmallFireball sf = new EntitySmallFireball(this.world, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 495 */       sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 496 */       sf.setPosition(cx, this.posY + yoff, cz);
/* 497 */       playSound(SoundEvents.ENTITY_ARROW_SHOOT, 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/*     */       
/* 499 */       this.world.spawnEntity((Entity)sf);
/* 500 */     } else if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
/* 501 */       if (this.world.rand.nextInt(2) == 0) {
/* 502 */         EntitySmallFireball sf = new EntitySmallFireball(this.world, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 503 */         sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 504 */         sf.setPosition(cx, this.posY + yoff, cz);
/* 505 */         playSound(SoundEvents.ENTITY_ARROW_SHOOT, 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 506 */         this.world.spawnEntity((Entity)sf);
/*     */       } else {
/* 508 */         BetterFireball bf = new BetterFireball(this.world, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 509 */         bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 510 */         bf.setPosition(cx, this.posY + yoff, cz);
/* 511 */         bf.setNotMe();
/*     */         
/* 513 */         playSound(SoundEvents.ITEM_FIRECHARGE_USE, 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 514 */         this.world.spawnEntity((Entity)bf);
/*     */       } 
/*     */     } else {
/* 517 */       BetterFireball bf = new BetterFireball(this.world, (EntityLivingBase)this, par1.posX - cx, par1.posY + 0.55D - this.posY + yoff, par1.posZ - cz);
/* 518 */       bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0F);
/* 519 */       bf.setPosition(cx, this.posY + yoff, cz);
/* 520 */       bf.setNotMe();
/* 521 */       playSound(SoundEvents.ITEM_FIRECHARGE_USE, 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 522 */       this.world.spawnEntity((Entity)bf);
/*     */     } 
/* 524 */     if (getHealth() < mygetMaxHealth()) {
/* 525 */       heal(1.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 535 */     if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL) return false;
/*     */     
/* 537 */     if (par1EntityLiving == null)
/*     */     {
/* 539 */       return false;
/*     */     }
/* 541 */     if (par1EntityLiving == this)
/*     */     {
/* 543 */       return false;
/*     */     }
/* 545 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 547 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 552 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/* 554 */       return false;
/*     */     }
/* 556 */     if (par1EntityLiving instanceof Mothra)
/*     */     {
/* 558 */       return false;
/*     */     }
/* 560 */     if (par1EntityLiving instanceof Brutalfly)
/*     */     {
/* 562 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 569 */     if (par1EntityLiving instanceof VelocityRaptor)
/*     */     {
/* 571 */       return false;
/*     */     }
/* 573 */     if (par1EntityLiving instanceof Cryolophosaurus)
/*     */     {
/* 575 */       return false;
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
/* 598 */     if (par1EntityLiving instanceof Mantis)
/*     */     {
/* 600 */       return false;
/*     */     }
/*     */     
/* 603 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 605 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 606 */       if (p.capabilities.isCreativeMode) {
/* 607 */         return false;
/*     */       }
/*     */     } 
/* 610 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 615 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 616 */     List<?> var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(15.0D, 20.0D, 15.0D));
/* 617 */     Collections.sort(var5, this.TargetSorter);
/* 618 */     Iterator<?> var2 = var5.iterator();
/* 619 */     Entity var3 = null;
/* 620 */     EntityLivingBase var4 = null;
/*     */     
/* 622 */     while (var2.hasNext()) {
/*     */       
/* 624 */       var3 = (Entity)var2.next();
/* 625 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 627 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 629 */         return var4;
/*     */       }
/*     */     } 
/* 632 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\Mothra.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */