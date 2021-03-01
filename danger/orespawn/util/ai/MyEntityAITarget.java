/*     */ package danger.orespawn.util.ai;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.pathfinding.Path;
/*     */ import net.minecraft.pathfinding.PathPoint;
/*     */ import net.minecraft.util.math.MathHelper;
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
/*     */ public abstract class MyEntityAITarget
/*     */   extends EntityAIBase
/*     */ {
/*     */   protected EntityLiving taskOwner;
/*     */   protected float targetDistance;
/*     */   protected boolean shouldCheckSight;
/*     */   private boolean nearbyOnly;
/*     */   private int targetSearchStatus;
/*     */   private int targetSearchDelay;
/*     */   private int targetUnseenTicks;
/*     */   
/*     */   public MyEntityAITarget(EntityLiving par1EntityLiving, float par2, boolean par3) {
/*  38 */     this(par1EntityLiving, par2, par3, false);
/*     */   }
/*     */   
/*     */   public MyEntityAITarget(EntityLiving par1EntityLiving, float par2, boolean par3, boolean par4) {
/*  42 */     this.targetSearchStatus = 0;
/*  43 */     this.targetSearchDelay = 0;
/*  44 */     this.targetUnseenTicks = 0;
/*  45 */     this.taskOwner = par1EntityLiving;
/*  46 */     this.targetDistance = par2;
/*  47 */     this.shouldCheckSight = par3;
/*  48 */     this.nearbyOnly = par4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean continueExecuting() {
/*  55 */     EntityLivingBase var1 = this.taskOwner.getAttackTarget();
/*     */     
/*  57 */     if (var1 == null) {
/*  58 */       return false;
/*     */     }
/*  60 */     if (!var1.isEntityAlive()) {
/*     */       
/*  62 */       this.taskOwner.setAttackTarget(null);
/*  63 */       return false;
/*     */     } 
/*  65 */     if (this.taskOwner.getDistanceSq((Entity)var1) > (this.targetDistance * this.targetDistance)) {
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (this.taskOwner instanceof EntityTameable && ((EntityTameable)this.taskOwner).isTamed() && 
/*  70 */       var1 instanceof EntityTameable && ((EntityTameable)var1).isTamed())
/*     */     {
/*  72 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  76 */     if (this.shouldCheckSight) {
/*  77 */       if (this.taskOwner.getEntitySenses().canSee((Entity)var1)) {
/*  78 */         this.targetUnseenTicks = 0;
/*  79 */       } else if (++this.targetUnseenTicks > 60) {
/*  80 */         return false;
/*     */       } 
/*     */     }
/*     */     
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startExecuting() {
/*  92 */     this.targetSearchStatus = 0;
/*  93 */     this.targetSearchDelay = 0;
/*  94 */     this.targetUnseenTicks = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetTask() {
/* 101 */     this.taskOwner.setAttackTarget((EntityLivingBase)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 109 */     if (par1EntityLiving == null)
/*     */     {
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     if (par1EntityLiving == this.taskOwner)
/*     */     {
/* 116 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 121 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     if (this.taskOwner instanceof EntityTameable && ((EntityTameable)this.taskOwner).isTamed()) {
/* 127 */       if (par1EntityLiving instanceof EntityTameable && ((EntityTameable)par1EntityLiving).isTamed())
/*     */       {
/* 129 */         return false;
/*     */       }
/* 131 */       if (par1EntityLiving == ((EntityTameable)this.taskOwner).getOwner())
/*     */       {
/* 133 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 137 */     if (par1EntityLiving instanceof net.minecraft.entity.player.EntityPlayer)
/*     */     {
/*     */       
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityPigZombie)
/*     */     {
/* 145 */       return false;
/*     */     }
/* 147 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityEnderman)
/*     */     {
/* 149 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 156 */     if (this.shouldCheckSight && !this.taskOwner.getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/* 158 */       return false;
/*     */     }
/* 160 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCreeper)
/*     */     {
/* 162 */       return true;
/*     */     }
/*     */     
/* 165 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityGhast)
/*     */     {
/* 167 */       return true;
/*     */     }
/* 169 */     if (this.nearbyOnly) {
/* 170 */       if (--this.targetSearchDelay <= 0) {
/* 171 */         this.targetSearchStatus = 0;
/*     */       }
/*     */       
/* 174 */       if (this.targetSearchStatus == 0) {
/* 175 */         this.targetSearchStatus = canEasilyReach(par1EntityLiving) ? 1 : 2;
/*     */       }
/*     */       
/* 178 */       if (this.targetSearchStatus == 2)
/*     */       {
/* 180 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 184 */     return true;
/*     */   }
/*     */   
/*     */   private boolean canEasilyReach(EntityLivingBase par1EntityLiving) {
/* 188 */     this.targetSearchDelay = 10 + this.taskOwner.getRNG().nextInt(5);
/* 189 */     Path var2 = this.taskOwner.getNavigator().getPathToEntityLiving((Entity)par1EntityLiving);
/*     */     
/* 191 */     if (var2 == null) {
/* 192 */       return false;
/*     */     }
/* 194 */     PathPoint var3 = var2.getFinalPathPoint();
/*     */     
/* 196 */     if (var3 == null) {
/* 197 */       return false;
/*     */     }
/* 199 */     int var4 = var3.x - MathHelper.floor(par1EntityLiving.posX);
/* 200 */     int var5 = var3.z - MathHelper.floor(par1EntityLiving.posZ);
/* 201 */     return ((var4 * var4 + var5 * var5) <= 2.25D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespaw\\util\ai\MyEntityAITarget.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */