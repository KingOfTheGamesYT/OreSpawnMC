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
/*  39 */     this(par1EntityLiving, par2, par3, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public MyEntityAITarget(EntityLiving par1EntityLiving, float par2, boolean par3, boolean par4) {
/*  44 */     this.targetSearchStatus = 0;
/*  45 */     this.targetSearchDelay = 0;
/*  46 */     this.targetUnseenTicks = 0;
/*  47 */     this.taskOwner = par1EntityLiving;
/*  48 */     this.targetDistance = par2;
/*  49 */     this.shouldCheckSight = par3;
/*  50 */     this.nearbyOnly = par4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean continueExecuting() {
/*  58 */     EntityLivingBase var1 = this.taskOwner.getAttackTarget();
/*     */     
/*  60 */     if (var1 == null)
/*     */     {
/*  62 */       return false;
/*     */     }
/*  64 */     if (!var1.isEntityAlive()) {
/*     */       
/*  66 */       this.taskOwner.setAttackTarget(null);
/*  67 */       return false;
/*     */     } 
/*  69 */     if (this.taskOwner.getDistanceSq((Entity)var1) > (this.targetDistance * this.targetDistance))
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if (this.taskOwner instanceof EntityTameable && ((EntityTameable)this.taskOwner).isTamed())
/*     */     {
/*  76 */       if (var1 instanceof EntityTameable && ((EntityTameable)var1).isTamed())
/*     */       {
/*     */         
/*  79 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  83 */     if (this.shouldCheckSight)
/*     */     {
/*  85 */       if (this.taskOwner.getEntitySenses().canSee((Entity)var1)) {
/*     */         
/*  87 */         this.targetUnseenTicks = 0;
/*     */       }
/*  89 */       else if (++this.targetUnseenTicks > 60) {
/*     */         
/*  91 */         return false;
/*     */       } 
/*     */     }
/*     */     
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startExecuting() {
/* 104 */     this.targetSearchStatus = 0;
/* 105 */     this.targetSearchDelay = 0;
/* 106 */     this.targetUnseenTicks = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetTask() {
/* 114 */     this.taskOwner.setAttackTarget((EntityLivingBase)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 124 */     if (par1EntityLiving == null)
/*     */     {
/*     */       
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     if (par1EntityLiving == this.taskOwner)
/*     */     {
/*     */       
/* 133 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 138 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     if (this.taskOwner instanceof EntityTameable && ((EntityTameable)this.taskOwner).isTamed()) {
/*     */       
/* 146 */       if (par1EntityLiving instanceof EntityTameable && ((EntityTameable)par1EntityLiving).isTamed())
/*     */       {
/*     */         
/* 149 */         return false;
/*     */       }
/* 151 */       if (par1EntityLiving == ((EntityTameable)this.taskOwner).getOwner())
/*     */       {
/*     */         
/* 154 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 158 */     if (par1EntityLiving instanceof net.minecraft.entity.player.EntityPlayer)
/*     */     {
/*     */ 
/*     */       
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityPigZombie)
/*     */     {
/*     */       
/* 168 */       return false;
/*     */     }
/* 170 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityEnderman)
/*     */     {
/*     */       
/* 173 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 180 */     if (this.shouldCheckSight && !this.taskOwner.getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 183 */       return false;
/*     */     }
/* 185 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCreeper)
/*     */     {
/*     */       
/* 188 */       return true;
/*     */     }
/*     */     
/* 191 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityGhast)
/*     */     {
/*     */       
/* 194 */       return true;
/*     */     }
/* 196 */     if (this.nearbyOnly) {
/*     */       
/* 198 */       if (--this.targetSearchDelay <= 0)
/*     */       {
/* 200 */         this.targetSearchStatus = 0;
/*     */       }
/*     */       
/* 203 */       if (this.targetSearchStatus == 0)
/*     */       {
/* 205 */         this.targetSearchStatus = canEasilyReach(par1EntityLiving) ? 1 : 2;
/*     */       }
/*     */       
/* 208 */       if (this.targetSearchStatus == 2)
/*     */       {
/*     */         
/* 211 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 215 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canEasilyReach(EntityLivingBase par1EntityLiving) {
/* 220 */     this.targetSearchDelay = 10 + this.taskOwner.getRNG().nextInt(5);
/* 221 */     Path var2 = this.taskOwner.getNavigator().getPathToEntityLiving((Entity)par1EntityLiving);
/*     */     
/* 223 */     if (var2 == null)
/*     */     {
/* 225 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 229 */     PathPoint var3 = var2.getFinalPathPoint();
/*     */     
/* 231 */     if (var3 == null)
/*     */     {
/* 233 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 237 */     int var4 = var3.x - MathHelper.floor(par1EntityLiving.posX);
/* 238 */     int var5 = var3.z - MathHelper.floor(par1EntityLiving.posZ);
/* 239 */     return ((var4 * var4 + var5 * var5) <= 2.25D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespaw\\util\ai\MyEntityAITarget.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */