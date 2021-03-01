/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.init.ModItems;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.DamageSource;
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
/*     */ public class Dragonfly
/*     */   extends EntityAnimal
/*     */ {
/*  61 */   private BlockPos currentFlightTarget = null;
/*  62 */   private GenericTargetSorter TargetSorter = null;
/*     */ 
/*     */   
/*     */   public Dragonfly(World par1World) {
/*  66 */     super(par1World);
/*  67 */     setSize(1.5F, 0.5F);
/*     */     
/*  69 */     this.experienceValue = 5;
/*  70 */     this.isImmuneToFire = false;
/*     */     
/*  72 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  77 */     super.applyEntityAttributes();
/*  78 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  79 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.33000001311302185D);
/*  80 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
/*  81 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  86 */     if (isNoDespawnRequired()) return false; 
/*  87 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  95 */     return 0.25F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 103 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/* 109 */     return SoundsHandler.ENTITY_DRAGONFLY_LIVING;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/* 116 */     return SoundsHandler.ENTITY_DRAGONFLY_HURT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleStatusUpdate(byte id) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 135 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */ 
/*     */   
/*     */   private int mygetMaxHealth() {
/* 144 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAIDisabled() {
/* 152 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 160 */     super.onUpdate();
/* 161 */     this.motionY *= 0.6D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 168 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 2.0F);
/* 169 */     return var4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 177 */     return (this.world.rayTraceBlocks(new Vec3d(this.posX, this.posY + 0.25D, this.posZ), new Vec3d(pX, pY, pZ)) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 183 */     int xdir = 1;
/* 184 */     int zdir = 1;
/*     */     
/* 186 */     int keep_trying = 50;
/*     */ 
/*     */ 
/*     */     
/* 190 */     if (this.isDead)
/* 191 */       return;  super.updateAITasks();
/*     */     
/* 193 */     if (this.currentFlightTarget == null) {
/* 194 */       this.currentFlightTarget = new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */ 
/*     */     
/* 198 */     if (this.rand.nextInt(300) == 0 || this.currentFlightTarget.distanceSq((int)this.posX, (int)this.posY, (int)this.posZ) < 2.0999999046325684D) {
/* 199 */       Block bid = Blocks.STONE;
/* 200 */       while (bid != Blocks.AIR && keep_trying != 0) {
/* 201 */         zdir = this.rand.nextInt(5) + 5;
/* 202 */         xdir = this.rand.nextInt(5) + 5;
/* 203 */         if (this.rand.nextInt(2) == 0) zdir = -zdir; 
/* 204 */         if (this.rand.nextInt(2) == 0) xdir = -xdir; 
/* 205 */         this.currentFlightTarget = new BlockPos((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(5) - 2, (int)this.posZ + zdir);
/*     */ 
/*     */         
/* 208 */         bid = this.world.getBlockState(this.currentFlightTarget).getBlock();
/* 209 */         if (bid == Blocks.AIR && 
/* 210 */           !canSeeTarget(this.currentFlightTarget.getX(), this.currentFlightTarget.getY(), this.currentFlightTarget.getZ())) {
/* 211 */           bid = Blocks.STONE;
/*     */         }
/*     */         
/* 214 */         keep_trying--;
/*     */       } 
/* 216 */     } else if (this.rand.nextInt(12) == 0 && this.world.getDifficulty() != EnumDifficulty.PEACEFUL) {
/*     */       
/* 218 */       EntityLivingBase e = null;
/* 219 */       e = findSomethingToAttack();
/* 220 */       if (e != null) {
/*     */         
/* 222 */         this.currentFlightTarget = new BlockPos((int)e.posX, (int)(e.posY + 1.0D), (int)e.posZ);
/*     */         
/* 224 */         if (getDistanceSq((Entity)e) < 6.0D) {
/* 225 */           attackEntityAsMob((Entity)e);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 230 */     double var1 = this.currentFlightTarget.getX() + 0.5D - this.posX;
/* 231 */     double var3 = this.currentFlightTarget.getX() + 0.1D - this.posY;
/* 232 */     double var5 = this.currentFlightTarget.getX() + 0.5D - this.posZ;
/* 233 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.30000000149011613D;
/* 234 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.20000000149011612D;
/* 235 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.30000000149011613D;
/* 236 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/*     */     
/* 238 */     float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
/* 239 */     this.moveForward = 1.0F;
/* 240 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 249 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fall(float distance, float damageMultiplier) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}
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
/* 277 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 286 */     boolean ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 288 */     Entity e = par1DamageSource.getTrueSource();
/* 289 */     if (e != null && this.currentFlightTarget != null) {
/* 290 */       this.currentFlightTarget = new BlockPos((int)e.posX, (int)e.posY, (int)e.posZ);
/*     */     }
/*     */     
/* 293 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 303 */     if (this.posY < 50.0D) return false; 
/* 304 */     if (!this.world.isDaytime()) return false; 
/* 305 */     return true;
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
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 318 */     if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL) return false;
/*     */     
/* 320 */     if (par1EntityLiving == null) {
/* 321 */       return false;
/*     */     }
/* 323 */     if (par1EntityLiving == this) {
/* 324 */       return false;
/*     */     }
/* 326 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 328 */       return false;
/*     */     }
/* 330 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/* 332 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 338 */     if (par1EntityLiving instanceof Butterfly) {
/* 339 */       return true;
/*     */     }
/* 341 */     if (par1EntityLiving instanceof Bird) {
/* 342 */       return true;
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
/* 356 */     return false;
/*     */   }
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 360 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 361 */     List<?> var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(10.0D, 6.0D, 10.0D));
/* 362 */     Collections.sort(var5, this.TargetSorter);
/* 363 */     Iterator<?> var2 = var5.iterator();
/* 364 */     Entity var3 = null;
/* 365 */     EntityLivingBase var4 = null;
/*     */     
/* 367 */     while (var2.hasNext()) {
/* 368 */       var3 = (Entity)var2.next();
/* 369 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 371 */       if (isSuitableTarget(var4, false)) {
/* 372 */         return var4;
/*     */       }
/*     */     } 
/* 375 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 383 */     int i = this.world.rand.nextInt(6);
/* 384 */     if (i == 0) return Items.GOLD_NUGGET; 
/* 385 */     if (i == 1) return ModItems.URANIUM_NUGGET; 
/* 386 */     if (i == 2) return ModItems.TITANIUM_NUGGET; 
/* 387 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable var1) {
/* 393 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\Dragonfly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */