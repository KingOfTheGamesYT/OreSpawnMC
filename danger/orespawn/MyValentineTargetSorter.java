/*    */ package danger.orespawn;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MyValentineTargetSorter
/*    */   implements Comparator
/*    */ {
/*    */   private Entity theEntity;
/*    */   final MyValentineTarget parent;
/*    */   
/*    */   public MyValentineTargetSorter(MyValentineTarget par1EntityAINearestAttackableTarget, Entity par2Entity) {
/* 18 */     this.parent = par1EntityAINearestAttackableTarget;
/* 19 */     this.theEntity = par2Entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareDistanceSq(Entity par1Entity, Entity par2Entity) {
/* 24 */     double var3 = this.theEntity.getDistanceSqToEntity(par1Entity);
/* 25 */     double var5 = this.theEntity.getDistanceSqToEntity(par2Entity);
/*    */     
/* 27 */     return (var3 < var5) ? -1 : ((var3 > var5) ? 1 : 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public int compare(Object par1Obj, Object par2Obj) {
/* 32 */     return compareDistanceSq((Entity)par1Obj, (Entity)par2Obj);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MyValentineTargetSorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */