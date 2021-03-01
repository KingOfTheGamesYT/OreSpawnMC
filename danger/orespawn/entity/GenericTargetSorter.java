/*    */ package danger.orespawn.entity;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ public class GenericTargetSorter
/*    */   implements Comparator
/*    */ {
/*    */   private Entity theEntity;
/*    */   
/*    */   public GenericTargetSorter(Entity par2Entity) {
/* 13 */     this.theEntity = par2Entity;
/*    */   }
/*    */   
/*    */   public int compareDistanceSq(Entity par1Entity, Entity par2Entity) {
/* 17 */     double weight = 0.0D;
/* 18 */     double var3 = this.theEntity.getDistanceSq(par1Entity);
/* 19 */     if (par1Entity instanceof net.minecraft.entity.monster.EntityCreeper) {
/* 20 */       var3 /= 2.0D;
/*    */     }
/* 22 */     weight = (par1Entity.height * par1Entity.width);
/* 23 */     if (weight > 1.0D) var3 /= weight;
/*    */     
/* 25 */     double var5 = this.theEntity.getDistanceSq(par2Entity);
/* 26 */     if (par2Entity instanceof net.minecraft.entity.monster.EntityCreeper) {
/* 27 */       var5 /= 2.0D;
/*    */     }
/* 29 */     weight = (par2Entity.height * par2Entity.width);
/* 30 */     if (weight > 1.0D) var5 /= weight;
/*    */     
/* 32 */     return (var3 < var5) ? -1 : ((var3 > var5) ? 1 : 0);
/*    */   }
/*    */   
/*    */   public int compare(Object par1Obj, Object par2Obj) {
/* 36 */     return compareDistanceSq((Entity)par1Obj, (Entity)par2Obj);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\GenericTargetSorter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */