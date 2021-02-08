/*     */ package danger.orespawn.util.ai;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.pathfinding.PathNavigate;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MyEntityAIFollowOwner
/*     */   extends EntityAIBase
/*     */ {
/*     */   private EntityTameable thePet;
/*     */   private EntityLivingBase theOwner;
/*     */   World theWorld;
/*     */   private float followSpeed;
/*     */   private PathNavigate petPathfinder;
/*     */   private int timeToRecalcPath;
/*     */   float maxDist;
/*     */   float minDist;
/*     */   private boolean oldWaterCost;
/*     */   
/*     */   public MyEntityAIFollowOwner(EntityTameable par1EntityTameable, float par2, float par3, float par4) {
/*  28 */     this.thePet = par1EntityTameable;
/*  29 */     this.theWorld = par1EntityTameable.world;
/*  30 */     this.followSpeed = par2;
/*  31 */     this.petPathfinder = par1EntityTameable.getNavigator();
/*  32 */     this.minDist = par4;
/*  33 */     this.maxDist = par3;
/*  34 */     setMutexBits(3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldExecute() {
/*  41 */     EntityLivingBase var1 = this.thePet.getOwner();
/*     */     
/*  43 */     if (var1 == null) {
/*  44 */       return false;
/*     */     }
/*  46 */     this.theOwner = var1;
/*     */     
/*  48 */     if (this.thePet.isSitting()) {
/*  49 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  58 */     if (this.thePet != null && (
/*  59 */       this.thePet.posY < 60.0D || !this.thePet.world.isDaytime()) && 
/*  60 */       this.thePet.getDistanceSq((Entity)var1) > (this.maxDist / 2.0F * this.maxDist / 2.0F)) {
/*  61 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  66 */     if (this.thePet.getDistanceSq((Entity)var1) < (this.maxDist * this.maxDist)) {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean continueExecuting() {
/*  78 */     if (this.thePet.isSitting()) {
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (this.petPathfinder.noPath()) {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if (this.thePet != null && 
/*  87 */       this.thePet instanceof EntityTameable) {
/*  88 */       EntityTameable gf = this.thePet;
/*  89 */       EntityLivingBase var1 = gf.getOwner();
/*  90 */       if (var1 != null && 
/*  91 */         (int)gf.posZ == (int)var1.posZ && 
/*  92 */         (int)gf.posX == (int)var1.posX && 
/*  93 */         (int)gf.posY < (int)var1.posY + 2 && 
/*  94 */         (int)gf.posY > (int)var1.posY - 2) {
/*  95 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     return (this.thePet.getDistanceSq((Entity)this.theOwner) > (this.minDist * this.minDist));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startExecuting() {
/* 111 */     this.timeToRecalcPath = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetTask() {
/* 120 */     this.theOwner = null;
/* 121 */     this.petPathfinder.clearPath();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTask() {
/* 129 */     this.thePet.getLookHelper().setLookPositionWithEntity((Entity)this.theOwner, 10.0F, this.thePet.getVerticalFaceSpeed());
/*     */     
/* 131 */     if (!this.thePet.isSitting() && 
/* 132 */       --this.timeToRecalcPath <= 0) {
/* 133 */       this.timeToRecalcPath = 10;
/*     */       
/* 135 */       if (!this.petPathfinder.tryMoveToEntityLiving((Entity)this.theOwner, this.followSpeed) && 
/* 136 */         this.thePet.getDistanceSq((Entity)this.theOwner) >= 144.0D) {
/* 137 */         int var1 = MathHelper.floor(this.theOwner.posX) - 2;
/* 138 */         int var2 = MathHelper.floor(this.theOwner.posZ) - 2;
/* 139 */         int var3 = MathHelper.floor((this.theOwner.getEntityBoundingBox()).minY);
/*     */         
/* 141 */         for (int var4 = 0; var4 <= 4; var4++) {
/* 142 */           for (int var5 = 0; var5 <= 4; var5++) {
/* 143 */             if ((var4 < 1 || var5 < 1 || var4 > 3 || var5 > 3) && this.theWorld.getBlockState(new BlockPos(var1 + var4, var3 - 1, var2 + var5)).isTopSolid() && !this.theWorld.getBlockState(new BlockPos(var1 + var4, var3, var2 + var5)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(var1 + var4, var3 + 1, var2 + var5)).isNormalCube()) {
/* 144 */               this.thePet.setLocationAndAngles(((var1 + var4) + 0.5F), var3, ((var2 + var5) + 0.5F), this.thePet.rotationYaw, this.thePet.rotationPitch);
/* 145 */               this.petPathfinder.clearPath();
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespaw\\util\ai\MyEntityAIFollowOwner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */