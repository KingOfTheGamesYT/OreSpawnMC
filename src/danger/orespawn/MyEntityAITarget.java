/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.pathfinding.PathEntity;
/*     */ import net.minecraft.pathfinding.PathPoint;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */   
/*     */   public MyEntityAITarget(EntityLiving par1EntityLiving, float par2, boolean par3, boolean par4) {
/*  43 */     this.targetSearchStatus = 0;
/*  44 */     this.targetSearchDelay = 0;
/*  45 */     this.targetUnseenTicks = 0;
/*  46 */     this.taskOwner = par1EntityLiving;
/*  47 */     this.targetDistance = par2;
/*  48 */     this.shouldCheckSight = par3;
/*  49 */     this.nearbyOnly = par4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean continueExecuting() {
/*  57 */     EntityLivingBase var1 = this.taskOwner.getAttackTarget();
/*     */     
/*  59 */     if (var1 == null)
/*     */     {
/*  61 */       return false;
/*     */     }
/*  63 */     if (!var1.isEntityAlive()) {
/*     */       
/*  65 */       this.taskOwner.setAttackTarget(null);
/*  66 */       return false;
/*     */     } 
/*  68 */     if (this.taskOwner.getDistanceSqToEntity((Entity)var1) > (this.targetDistance * this.targetDistance))
/*     */     {
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if (this.taskOwner instanceof EntityTameable && ((EntityTameable)this.taskOwner).isTamed())
/*     */     {
/*  75 */       if (var1 instanceof EntityTameable && ((EntityTameable)var1).isTamed())
/*     */       {
/*     */         
/*  78 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  82 */     if (this.shouldCheckSight)
/*     */     {
/*  84 */       if (this.taskOwner.getEntitySenses().canSee((Entity)var1)) {
/*     */         
/*  86 */         this.targetUnseenTicks = 0;
/*     */       }
/*  88 */       else if (++this.targetUnseenTicks > 60) {
/*     */         
/*  90 */         return false;
/*     */       } 
/*     */     }
/*     */     
/*  94 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startExecuting() {
/* 103 */     this.targetSearchStatus = 0;
/* 104 */     this.targetSearchDelay = 0;
/* 105 */     this.targetUnseenTicks = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetTask() {
/* 113 */     this.taskOwner.setAttackTarget((EntityLivingBase)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 123 */     if (par1EntityLiving == null)
/*     */     {
/*     */       
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     if (par1EntityLiving == this.taskOwner)
/*     */     {
/*     */       
/* 132 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 137 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     if (this.taskOwner instanceof EntityTameable && ((EntityTameable)this.taskOwner).isTamed()) {
/*     */       
/* 145 */       if (par1EntityLiving instanceof EntityTameable && ((EntityTameable)par1EntityLiving).isTamed())
/*     */       {
/*     */         
/* 148 */         return false;
/*     */       }
/* 150 */       if (par1EntityLiving == ((EntityTameable)this.taskOwner).getOwner())
/*     */       {
/*     */         
/* 153 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 157 */     if (par1EntityLiving instanceof net.minecraft.entity.player.EntityPlayer) {
/*     */ 
/*     */       
/* 160 */       if (OreSpawnMain.valentines_day != 0) return true; 
/* 161 */       return false;
/*     */     } 
/*     */     
/* 164 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityPigZombie)
/*     */     {
/*     */       
/* 167 */       return false;
/*     */     }
/* 169 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityEnderman)
/*     */     {
/*     */       
/* 172 */       return false;
/*     */     }
/* 174 */     if (par1EntityLiving instanceof Mothra)
/*     */     {
/* 176 */       return true;
/*     */     }
/*     */     
/* 179 */     if (this.shouldCheckSight && !this.taskOwner.getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 182 */       return false;
/*     */     }
/* 184 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCreeper)
/*     */     {
/*     */       
/* 187 */       return true;
/*     */     }
/*     */     
/* 190 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityGhast)
/*     */     {
/*     */       
/* 193 */       return true;
/*     */     }
/* 195 */     if (this.nearbyOnly) {
/*     */       
/* 197 */       if (--this.targetSearchDelay <= 0)
/*     */       {
/* 199 */         this.targetSearchStatus = 0;
/*     */       }
/*     */       
/* 202 */       if (this.targetSearchStatus == 0)
/*     */       {
/* 204 */         this.targetSearchStatus = canEasilyReach(par1EntityLiving) ? 1 : 2;
/*     */       }
/*     */       
/* 207 */       if (this.targetSearchStatus == 2)
/*     */       {
/*     */         
/* 210 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 214 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canEasilyReach(EntityLivingBase par1EntityLiving) {
/* 219 */     this.targetSearchDelay = 10 + this.taskOwner.getRNG().nextInt(5);
/* 220 */     PathEntity var2 = this.taskOwner.getNavigator().getPathToEntityLiving((Entity)par1EntityLiving);
/*     */     
/* 222 */     if (var2 == null)
/*     */     {
/* 224 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 228 */     PathPoint var3 = var2.getFinalPathPoint();
/*     */     
/* 230 */     if (var3 == null)
/*     */     {
/* 232 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 236 */     int var4 = var3.xCoord - MathHelper.floor_double(par1EntityLiving.posX);
/* 237 */     int var5 = var3.zCoord - MathHelper.floor_double(par1EntityLiving.posZ);
/* 238 */     return ((var4 * var4 + var5 * var5) <= 2.25D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MyEntityAITarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */