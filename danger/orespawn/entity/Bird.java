/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.passive.IAnimals;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class Bird
/*     */   extends EntityCreature implements IAnimals {
/*     */   private BlockPos spawnPosition;
/*     */   public int birdType;
/*     */   
/*     */   public Bird(World worldIn) {
/*  19 */     super(worldIn);
/*  20 */     setSize(0.4F, 0.4F);
/*  21 */     this.birdType = this.rand.nextInt(6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void applyEntityAttributes() {
/*  26 */     super.applyEntityAttributes();
/*  27 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);
/*  28 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAITasks() {
/*  33 */     super.updateAITasks();
/*     */     
/*  35 */     if (this.spawnPosition != null && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) {
/*  36 */       this.spawnPosition = null;
/*     */     }
/*     */     
/*  39 */     if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0D) {
/*  40 */       this.spawnPosition = new BlockPos((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
/*     */     }
/*     */     
/*  43 */     double d0 = this.spawnPosition.getX() + 0.5D - this.posX;
/*  44 */     double d1 = this.spawnPosition.getY() + 0.1D - this.posY;
/*  45 */     double d2 = this.spawnPosition.getZ() + 0.5D - this.posZ;
/*  46 */     this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
/*  47 */     this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
/*  48 */     this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
/*  49 */     float f = (float)(MathHelper.atan2(this.motionZ, this.motionX) * 57.29577951308232D) - 90.0F;
/*  50 */     float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
/*  51 */     this.moveForward = 0.5F;
/*  52 */     this.rotationYaw += f1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  58 */     super.onUpdate();
/*  59 */     this.motionY *= 0.6000000238418579D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fall(float distance, float damageMultiplier) {}
/*     */ 
/*     */   
/*     */   protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  70 */     return 0.55F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  75 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getAmbientSound() {
/*  80 */     if (this.rand.nextInt(4) == 0) {
/*  81 */       switch (this.rand.nextInt(23) + 1) { case 1:
/*  82 */           return SoundsHandler.ENTITY_BIRD_BIRD1;
/*  83 */         case 2: return SoundsHandler.ENTITY_BIRD_BIRD2;
/*  84 */         case 3: return SoundsHandler.ENTITY_BIRD_BIRD3;
/*  85 */         case 4: return SoundsHandler.ENTITY_BIRD_BIRD4;
/*  86 */         case 5: return SoundsHandler.ENTITY_BIRD_BIRD5;
/*  87 */         case 6: return SoundsHandler.ENTITY_BIRD_BIRD6;
/*  88 */         case 7: return SoundsHandler.ENTITY_BIRD_BIRD7;
/*  89 */         case 8: return SoundsHandler.ENTITY_BIRD_BIRD8;
/*  90 */         case 9: return SoundsHandler.ENTITY_BIRD_BIRD9;
/*  91 */         case 10: return SoundsHandler.ENTITY_BIRD_BIRD10;
/*  92 */         case 11: return SoundsHandler.ENTITY_BIRD_BIRD11;
/*  93 */         case 12: return SoundsHandler.ENTITY_BIRD_BIRD12;
/*  94 */         case 13: return SoundsHandler.ENTITY_BIRD_BIRD13;
/*  95 */         case 14: return SoundsHandler.ENTITY_BIRD_BIRD14;
/*  96 */         case 15: return SoundsHandler.ENTITY_BIRD_BIRD15;
/*  97 */         case 16: return SoundsHandler.ENTITY_BIRD_BIRD16;
/*  98 */         case 17: return SoundsHandler.ENTITY_BIRD_BIRD17;
/*  99 */         case 18: return SoundsHandler.ENTITY_BIRD_BIRD18;
/* 100 */         case 19: return SoundsHandler.ENTITY_BIRD_BIRD19;
/* 101 */         case 20: return SoundsHandler.ENTITY_BIRD_BIRD20;
/* 102 */         case 21: return SoundsHandler.ENTITY_BIRD_BIRD21;
/* 103 */         case 22: return SoundsHandler.ENTITY_BIRD_BIRD22; }
/* 104 */        return SoundsHandler.ENTITY_BIRD_BIRD23;
/*     */     } 
/*     */ 
/*     */     
/* 108 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\entity\Bird.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */