/*    */ package danger.orespawn.util.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.ai.EntityAIBase;
/*    */ import net.minecraft.entity.ai.RandomPositionGenerator;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ import net.minecraft.util.math.Vec3d;
/*    */ 
/*    */ public class MyEntityAIWanderALot
/*    */   extends EntityAIBase {
/*    */   private EntityCreature entity;
/*    */   private double xPosition;
/*    */   private double yPosition;
/*    */   private double zPosition;
/*    */   private double speed;
/* 16 */   private int xzRange = 10;
/* 17 */   private int busy = 0;
/*    */   
/*    */   public MyEntityAIWanderALot(EntityCreature par1EntityCreature, int par1, double par2) {
/* 20 */     this.entity = par1EntityCreature;
/* 21 */     this.xzRange = par1;
/* 22 */     this.speed = par2;
/* 23 */     setMutexBits(1);
/*    */   }
/*    */   
/*    */   public void setBusy(int i) {
/* 27 */     this.busy = i;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldExecute() {
/* 35 */     if (this.busy != 0) return false;
/*    */     
/* 37 */     if (this.entity.world.rand.nextInt(30) != 0) {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (this.entity instanceof EntityTameable && ((EntityTameable)this.entity).isSitting()) {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     Vec3d var1 = RandomPositionGenerator.findRandomTarget(this.entity, this.xzRange, 7);
/*    */     
/* 47 */     if (var1 == null) {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     this.xPosition = var1.x;
/* 52 */     this.yPosition = var1.y;
/* 53 */     this.zPosition = var1.z;
/* 54 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean continueExecuting() {
/* 63 */     return !this.entity.getNavigator().noPath();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void startExecuting() {
/* 70 */     this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespaw\\util\ai\MyEntityAIWanderALot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */