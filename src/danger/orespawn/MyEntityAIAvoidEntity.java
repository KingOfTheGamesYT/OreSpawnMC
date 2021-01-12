/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.RandomPositionGenerator;
/*     */ import net.minecraft.entity.monster.IMob;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.pathfinding.PathEntity;
/*     */ import net.minecraft.pathfinding.PathNavigate;
/*     */ import net.minecraft.util.Vec3;
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
/*     */ public class MyEntityAIAvoidEntity
/*     */   extends EntityAIBase
/*     */ {
/*     */   private EntityCreature theEntity;
/*     */   private double farSpeed;
/*     */   private double nearSpeed;
/*     */   private Entity closestLivingEntity;
/*     */   private float distanceFromEntity;
/*     */   private PathEntity entityPathEntity;
/*     */   private PathNavigate entityPathNavigate;
/*     */   private Class targetEntityClass;
/*     */   
/*     */   public MyEntityAIAvoidEntity(EntityCreature par1EntityCreature, Class par2Class, float par3, double par4, double par6) {
/*  37 */     this.theEntity = par1EntityCreature;
/*  38 */     this.targetEntityClass = par2Class;
/*  39 */     this.distanceFromEntity = par3;
/*  40 */     this.farSpeed = par4;
/*  41 */     this.nearSpeed = par6;
/*  42 */     this.entityPathNavigate = par1EntityCreature.getNavigator();
/*  43 */     setMutexBits(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldExecute() {
/*  51 */     if (this.theEntity != null && this.theEntity instanceof EntityCannonFodder) {
/*  52 */       EntityCannonFodder cf = (EntityCannonFodder)this.theEntity;
/*  53 */       if (cf.get_is_activated() != 0) return false;
/*     */     
/*     */     } 
/*  56 */     if (this.targetEntityClass == EntityPlayer.class) {
/*     */       
/*  58 */       if (this.theEntity instanceof EntityTameable && ((EntityTameable)this.theEntity).isTamed())
/*     */       {
/*  60 */         return false;
/*     */       }
/*     */       
/*  63 */       this.closestLivingEntity = (Entity)this.theEntity.worldObj.getClosestPlayerToEntity((Entity)this.theEntity, this.distanceFromEntity);
/*     */       
/*  65 */       if (this.closestLivingEntity == null)
/*     */       {
/*  67 */         return false;
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/*  72 */       List<Entity> list = this.theEntity.worldObj.selectEntitiesWithinAABB(this.targetEntityClass, this.theEntity.boundingBox.expand(this.distanceFromEntity, 3.0D, this.distanceFromEntity), IMob.mobSelector);
/*     */       
/*  74 */       if (list.isEmpty())
/*     */       {
/*  76 */         return false;
/*     */       }
/*     */       
/*  79 */       this.closestLivingEntity = list.get(0);
/*     */     } 
/*     */     
/*  82 */     Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(this.theEntity, 16, 7, Vec3.createVectorHelper(this.closestLivingEntity.posX, this.closestLivingEntity.posY, this.closestLivingEntity.posZ));
/*     */     
/*  84 */     if (vec3 == null)
/*     */     {
/*  86 */       return false;
/*     */     }
/*  88 */     if (this.closestLivingEntity.getDistanceSq(vec3.xCoord, vec3.yCoord, vec3.zCoord) < this.closestLivingEntity.getDistanceSqToEntity((Entity)this.theEntity))
/*     */     {
/*  90 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  94 */     this.entityPathEntity = this.entityPathNavigate.getPathToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord);
/*  95 */     return (this.entityPathEntity == null) ? false : this.entityPathEntity.isDestinationSame(vec3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean continueExecuting() {
/* 104 */     return !this.entityPathNavigate.noPath();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startExecuting() {
/* 112 */     this.entityPathNavigate.setPath(this.entityPathEntity, this.farSpeed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetTask() {
/* 120 */     this.closestLivingEntity = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTask() {
/* 128 */     if (this.theEntity.getDistanceSqToEntity(this.closestLivingEntity) < 49.0D) {
/*     */       
/* 130 */       this.theEntity.getNavigator().setSpeed(this.nearSpeed);
/*     */     }
/*     */     else {
/*     */       
/* 134 */       this.theEntity.getNavigator().setSpeed(this.farSpeed);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static EntityCreature func_98217_a(MyEntityAIAvoidEntity par0EntityAIAvoidEntity) {
/* 140 */     return par0EntityAIAvoidEntity.theEntity;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MyEntityAIAvoidEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */