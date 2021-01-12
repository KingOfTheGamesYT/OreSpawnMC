/*    */ package danger.orespawn.util.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.ai.EntityAIBase;
/*    */ import net.minecraft.entity.ai.RandomPositionGenerator;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ import net.minecraft.util.math.Vec3d;
/*    */ 
/*    */ 
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
/* 22 */     this.entity = par1EntityCreature;
/* 23 */     this.speed = par2;
/* 24 */     setMutexBits(1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldExecute() {
/* 32 */     if (this.entity.getRNG().nextInt(90) != 0)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     if (this.entity instanceof EntityTameable && ((EntityTameable)this.entity).isSitting())
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 43 */     Vec3d var1 = RandomPositionGenerator.findRandomTarget(this.entity, 10, 7);
/*    */     
/* 45 */     if (var1 == null)
/*    */     {
/* 47 */       return false;
/*    */     }
/*    */ 
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
/*    */   
/*    */   public boolean continueExecuting() {
/* 64 */     if (this.entity != null && 
/* 65 */       this.entity instanceof EntityTameable) {
/* 66 */       EntityTameable gf = (EntityTameable)this.entity;
/* 67 */       EntityLivingBase var1 = gf.getOwner();
/* 68 */       if (var1 != null && 
/* 69 */         (int)gf.posZ == (int)var1.posZ && 
/* 70 */         (int)gf.posX == (int)var1.posX && 
/* 71 */         (int)gf.posY < (int)var1.posY + 2 && 
/* 72 */         (int)gf.posY > (int)var1.posY - 2) {
/* 73 */         return false;
/*    */       }
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 82 */     return !this.entity.getNavigator().noPath();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void startExecuting() {
/* 90 */     this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespaw\\util\ai\MyEntityAIWander.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */