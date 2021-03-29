/*    */ package danger.orespawn.util.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.ai.EntityAIBase;
/*    */ import net.minecraft.entity.ai.RandomPositionGenerator;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ import net.minecraft.util.math.Vec3d;
/*    */ 
/*    */ public class MyEntityAIWander
/*    */   extends EntityAIBase
/*    */ {
/*    */   private EntityCreature entity;
/*    */   private double xPosition;
/*    */   private double yPosition;
/*    */   private double zPosition;
/*    */   private float speed;
/*    */   
/*    */   public MyEntityAIWander(EntityCreature par1EntityCreature, float par2) {
/* 20 */     this.entity = par1EntityCreature;
/* 21 */     this.speed = par2;
/* 22 */     setMutexBits(1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldExecute() {
/* 29 */     if (this.entity.getRNG().nextInt(90) != 0) {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     if (this.entity instanceof EntityTameable && ((EntityTameable)this.entity).isSitting()) {
/* 34 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 38 */     Vec3d var1 = RandomPositionGenerator.findRandomTarget(this.entity, 10, 7);
/*    */     
/* 40 */     if (var1 == null) {
/* 41 */       return false;
/*    */     }
/* 43 */     this.xPosition = var1.x;
/* 44 */     this.yPosition = var1.y;
/* 45 */     this.zPosition = var1.z;
/* 46 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean continueExecuting() {
/* 55 */     if (this.entity != null && 
/* 56 */       this.entity instanceof EntityTameable) {
/* 57 */       EntityTameable gf = (EntityTameable)this.entity;
/* 58 */       EntityLivingBase var1 = gf.getOwner();
/* 59 */       if (var1 != null && 
/* 60 */         (int)gf.posZ == (int)var1.posZ && 
/* 61 */         (int)gf.posX == (int)var1.posX && 
/* 62 */         (int)gf.posY < (int)var1.posY + 2 && 
/* 63 */         (int)gf.posY > (int)var1.posY - 2) {
/* 64 */         return false;
/*    */       }
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 73 */     return !this.entity.getNavigator().noPath();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void startExecuting() {
/* 80 */     this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespaw\\util\ai\MyEntityAIWander.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */