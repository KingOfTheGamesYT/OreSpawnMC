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
/*  31 */     this.thePet = par1EntityTameable;
/*  32 */     this.theWorld = par1EntityTameable.world;
/*  33 */     this.followSpeed = par2;
/*  34 */     this.petPathfinder = par1EntityTameable.getNavigator();
/*  35 */     this.minDist = par4;
/*  36 */     this.maxDist = par3;
/*  37 */     setMutexBits(3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldExecute() {
/*  45 */     EntityLivingBase var1 = this.thePet.getOwner();
/*     */     
/*  47 */     if (var1 == null)
/*     */     {
/*  49 */       return false;
/*     */     }
/*  51 */     this.theOwner = var1;
/*     */     
/*  53 */     if (this.thePet.isSitting())
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  64 */     if (this.thePet != null && (
/*  65 */       this.thePet.posY < 60.0D || !this.thePet.world.isDaytime()) && 
/*  66 */       this.thePet.getDistanceSq((Entity)var1) > (this.maxDist / 2.0F * this.maxDist / 2.0F))
/*     */     {
/*  68 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  73 */     if (this.thePet.getDistanceSq((Entity)var1) < (this.maxDist * this.maxDist))
/*     */     {
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean continueExecuting() {
/*  87 */     if (this.thePet.isSitting()) {
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     if (this.petPathfinder.noPath()) {
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     if (this.thePet != null && 
/*  96 */       this.thePet instanceof EntityTameable) {
/*  97 */       EntityTameable gf = this.thePet;
/*  98 */       EntityLivingBase var1 = gf.getOwner();
/*  99 */       if (var1 != null && 
/* 100 */         (int)gf.posZ == (int)var1.posZ && 
/* 101 */         (int)gf.posX == (int)var1.posX && 
/* 102 */         (int)gf.posY < (int)var1.posY + 2 && 
/* 103 */         (int)gf.posY > (int)var1.posY - 2) {
/* 104 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     return (this.thePet.getDistanceSq((Entity)this.theOwner) > (this.minDist * this.minDist));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startExecuting() {
/* 121 */     this.timeToRecalcPath = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetTask() {
/* 131 */     this.theOwner = null;
/* 132 */     this.petPathfinder.clearPath();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTask() {
/* 141 */     this.thePet.getLookHelper().setLookPositionWithEntity((Entity)this.theOwner, 10.0F, this.thePet.getVerticalFaceSpeed());
/*     */     
/* 143 */     if (!this.thePet.isSitting())
/*     */     {
/* 145 */       if (--this.timeToRecalcPath <= 0) {
/*     */         
/* 147 */         this.timeToRecalcPath = 10;
/*     */         
/* 149 */         if (!this.petPathfinder.tryMoveToEntityLiving((Entity)this.theOwner, this.followSpeed))
/*     */         {
/* 151 */           if (this.thePet.getDistanceSq((Entity)this.theOwner) >= 144.0D) {
/*     */             
/* 153 */             int var1 = MathHelper.floor(this.theOwner.posX) - 2;
/* 154 */             int var2 = MathHelper.floor(this.theOwner.posZ) - 2;
/* 155 */             int var3 = MathHelper.floor((this.theOwner.getEntityBoundingBox()).minY);
/*     */             
/* 157 */             for (int var4 = 0; var4 <= 4; var4++) {
/*     */               
/* 159 */               for (int var5 = 0; var5 <= 4; var5++) {
/*     */                 
/* 161 */                 if ((var4 < 1 || var5 < 1 || var4 > 3 || var5 > 3) && this.theWorld.getBlockState(new BlockPos(var1 + var4, var3 - 1, var2 + var5)).isTopSolid() && !this.theWorld.getBlockState(new BlockPos(var1 + var4, var3, var2 + var5)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(var1 + var4, var3 + 1, var2 + var5)).isNormalCube()) {
/*     */                   
/* 163 */                   this.thePet.setLocationAndAngles(((var1 + var4) + 0.5F), var3, ((var2 + var5) + 0.5F), this.thePet.rotationYaw, this.thePet.rotationPitch);
/* 164 */                   this.petPathfinder.clearPath();
/*     */                   return;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespaw\\util\ai\MyEntityAIFollowOwner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */