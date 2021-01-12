/*    */ package danger.orespawn.util.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.ai.EntityAIBase;
/*    */ import net.minecraft.entity.ai.RandomPositionGenerator;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ import net.minecraft.util.math.Vec3d;
/*    */ 
/*    */ public class MyEntityAIWanderALot
/*    */   extends EntityAIBase
/*    */ {
/*    */   private EntityCreature entity;
/*    */   private double xPosition;
/*    */   private double yPosition;
/*    */   private double zPosition;
/*    */   private double speed;
/* 17 */   private int xzRange = 10;
/* 18 */   private int busy = 0;
/*    */ 
/*    */   
/*    */   public MyEntityAIWanderALot(EntityCreature par1EntityCreature, int par1, double par2) {
/* 22 */     this.entity = par1EntityCreature;
/* 23 */     this.xzRange = par1;
/* 24 */     this.speed = par2;
/* 25 */     setMutexBits(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setBusy(int i) {
/* 30 */     this.busy = i;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldExecute() {
/* 39 */     if (this.busy != 0) return false;
/*    */     
/* 41 */     if (this.entity.world.rand.nextInt(30) != 0)
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if (this.entity instanceof EntityTameable && ((EntityTameable)this.entity).isSitting())
/*    */     {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     Vec3d var1 = RandomPositionGenerator.findRandomTarget(this.entity, this.xzRange, 7);
/*    */     
/* 53 */     if (var1 == null)
/*    */     {
/* 55 */       return false;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 60 */     this.xPosition = var1.x;
/* 61 */     this.yPosition = var1.y;
/* 62 */     this.zPosition = var1.z;
/* 63 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean continueExecuting() {
/* 73 */     return !this.entity.getNavigator().noPath();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void startExecuting() {
/* 81 */     this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespaw\\util\ai\MyEntityAIWanderALot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */