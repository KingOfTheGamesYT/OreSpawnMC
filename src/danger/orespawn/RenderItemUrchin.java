/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderItemUrchin
/*    */   extends RenderSpinner
/*    */ {
/*    */   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 16 */     if (par1Entity instanceof BerthaHit) {
/*    */       return;
/*    */     }
/* 19 */     if (par1Entity instanceof SunspotUrchin) {
/* 20 */       SunspotUrchin var2 = (SunspotUrchin)par1Entity;
/* 21 */       this.spinItemIconIndex = var2.getUrchinIndex();
/*    */     } 
/* 23 */     if (par1Entity instanceof WaterBall) {
/* 24 */       WaterBall var2 = (WaterBall)par1Entity;
/* 25 */       this.spinItemIconIndex = var2.getWaterBallIndex();
/*    */     } 
/* 27 */     if (par1Entity instanceof InkSack) {
/* 28 */       InkSack var2 = (InkSack)par1Entity;
/* 29 */       this.spinItemIconIndex = var2.getInkSackIndex();
/*    */     } 
/* 31 */     if (par1Entity instanceof LaserBall) {
/* 32 */       LaserBall var2 = (LaserBall)par1Entity;
/* 33 */       this.spinItemIconIndex = var2.getLaserBallIndex();
/*    */     } 
/* 35 */     if (par1Entity instanceof IceBall) {
/* 36 */       IceBall var2 = (IceBall)par1Entity;
/* 37 */       this.spinItemIconIndex = var2.getIceBallIndex();
/*    */     } 
/* 39 */     if (par1Entity instanceof Acid) {
/* 40 */       Acid var2 = (Acid)par1Entity;
/* 41 */       this.spinItemIconIndex = var2.getAcidIndex();
/*    */     } 
/* 43 */     if (par1Entity instanceof DeadIrukandji) {
/* 44 */       DeadIrukandji var2 = (DeadIrukandji)par1Entity;
/* 45 */       this.spinItemIconIndex = var2.getIrukandjiIndex();
/*    */     } 
/* 47 */     super.doRender(par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderItemUrchin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */