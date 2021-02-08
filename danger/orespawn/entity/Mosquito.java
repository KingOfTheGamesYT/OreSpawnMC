/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.passive.EntityAmbientCreature;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class Mosquito
/*     */   extends EntityAmbientCreature
/*     */ {
/*  22 */   private BlockPos currentFlightTarget = null;
/*     */ 
/*     */   
/*     */   public Mosquito(World par1World) {
/*  26 */     super(par1World);
/*     */     
/*  28 */     setSize(0.2F, 0.2F);
/*     */     
/*  30 */     this.experienceValue = 5;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  35 */     super.applyEntityAttributes();
/*  36 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  37 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);
/*  38 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
/*  39 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  45 */     super.entityInit();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  50 */     if (isNoDespawnRequired()) return false; 
/*  51 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  60 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  68 */     return 1.5F;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/*  74 */     return SoundsHandler.ENTITY_MOSQUITO_LIVING;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/*  80 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/*  89 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 100 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAIDisabled() {
/* 105 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 113 */     super.onUpdate();
/* 114 */     this.motionY *= 0.6000000238418579D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 120 */     int keep_trying = 50;
/* 121 */     if (this.isDead)
/* 122 */       return;  super.updateAITasks();
/*     */ 
/*     */     
/* 125 */     if (this.currentFlightTarget == null) {
/* 126 */       this.currentFlightTarget = new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/* 128 */     if (this.rand.nextInt(20) == 0 || this.currentFlightTarget.distanceSq((int)this.posX, (int)this.posY, (int)this.posZ) < 3.0D) {
/* 129 */       EntityPlayer target = null;
/*     */       
/* 131 */       if (OreSpawnMain.OreSpawnRand.nextInt(4) == 0) {
/* 132 */         target = (EntityPlayer)this.world.findNearestEntityWithinAABB(EntityPlayer.class, getEntityBoundingBox().expand(10.0D, 6.0D, 10.0D), (Entity)this);
/* 133 */         if (target != null) {
/* 134 */           this.currentFlightTarget = new BlockPos((int)target.posX, (int)target.posY + 2, (int)target.posZ);
/*     */         } else {
/*     */           
/* 137 */           Block bid = Blocks.STONE;
/* 138 */           while (bid != Blocks.AIR && keep_trying != 0) {
/* 139 */             this.currentFlightTarget = new BlockPos((int)this.posX + this.rand.nextInt(6) - this.rand.nextInt(6), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(6) - this.rand.nextInt(6));
/*     */             
/* 141 */             bid = this.world.getBlockState(new BlockPos(this.currentFlightTarget.getX(), this.currentFlightTarget.getY(), this.currentFlightTarget.getZ())).getBlock();
/*     */             
/* 143 */             keep_trying--;
/*     */           } 
/*     */         } 
/*     */       } else {
/* 147 */         Block bid = Blocks.STONE;
/* 148 */         while (bid != Blocks.AIR && keep_trying != 0) {
/* 149 */           this.currentFlightTarget = new BlockPos((int)this.posX + this.rand.nextInt(6) - this.rand.nextInt(6), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(6) - this.rand.nextInt(6));
/* 150 */           bid = this.world.getBlockState(new BlockPos(this.currentFlightTarget.getX(), this.currentFlightTarget.getY(), this.currentFlightTarget.getZ())).getBlock();
/* 151 */           keep_trying--;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 156 */     double var1 = this.currentFlightTarget.getX() + 0.5D - this.posX;
/* 157 */     double var3 = this.currentFlightTarget.getY() + 0.1D - this.posY;
/* 158 */     double var5 = this.currentFlightTarget.getZ() + 0.5D - this.posZ;
/* 159 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.10000000149011612D;
/* 160 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
/* 161 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.10000000149011612D;
/* 162 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 163 */     float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
/* 164 */     this.moveForward = 0.3F;
/* 165 */     this.rotationYaw += var8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 174 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 182 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 190 */     return true;
/*     */   }
/*     */   
/*     */   public void fall(float distance, float damageMultiplier) {}
/*     */   
/*     */   protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\entity\Mosquito.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */