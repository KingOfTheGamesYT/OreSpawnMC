/*    */ package danger.orespawn.util.ai;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MyEntityAINearestAttackableTargetSorter
/*    */   implements Comparator
/*    */ {
/*    */   private Entity theEntity;
/*    */   final MyEntityAINearestAttackableTarget parent;
/*    */   
/*    */   public MyEntityAINearestAttackableTargetSorter(MyEntityAINearestAttackableTarget par1EntityAINearestAttackableTarget, Entity par2Entity) {
/* 18 */     this.parent = par1EntityAINearestAttackableTarget;
/* 19 */     this.theEntity = par2Entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareDistanceSq(Entity par1Entity, Entity par2Entity) {
/* 24 */     double var3 = this.theEntity.getDistanceSq(par1Entity);
/* 25 */     if (par1Entity instanceof net.minecraft.entity.monster.EntityCreeper) {
/* 26 */       var3 /= 2.0D;
/*    */     }
/* 28 */     double var5 = this.theEntity.getDistanceSq(par2Entity);
/* 29 */     if (par2Entity instanceof net.minecraft.entity.monster.EntityCreeper) {
/* 30 */       var5 /= 2.0D;
/*    */     }
/* 32 */     return (var3 < var5) ? -1 : ((var3 > var5) ? 1 : 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public int compare(Object par1Obj, Object par2Obj) {
/* 37 */     return compareDistanceSq((Entity)par1Obj, (Entity)par2Obj);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespaw\\util\ai\MyEntityAINearestAttackableTargetSorter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */