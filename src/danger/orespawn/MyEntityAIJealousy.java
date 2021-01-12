/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MyEntityAIJealousy
/*    */   extends MyEntityAINearestAttackableTarget
/*    */ {
/*    */   private EntityTameable theTameable;
/*    */   
/*    */   public MyEntityAIJealousy(EntityTameable par1EntityTameable, Class par2Class, float par3, int par4, boolean par5) {
/* 18 */     super((EntityLiving)par1EntityTameable, par2Class, par3, par4, par5);
/* 19 */     this.theTameable = par1EntityTameable;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldExecute() {
/* 27 */     EntityTameable te = (EntityTameable)this.taskOwner;
/* 28 */     Girlfriend gf = null;
/* 29 */     Boyfriend bf = null;
/* 30 */     EntityLivingBase ep = null;
/*    */     
/* 32 */     if (te == null)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 38 */     if (!te.isTamed())
/*    */     {
/*    */       
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     if (te.isSitting())
/*    */     {
/* 46 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 50 */     if (!super.shouldExecute())
/*    */     {
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     EntityLiving entityLiving = this.targetEntity;
/*    */     
/* 57 */     if (entityLiving == null)
/*    */     {
/*    */       
/* 60 */       return false;
/*    */     }
/*    */     
/* 63 */     if (te instanceof Girlfriend) {
/* 64 */       if (entityLiving instanceof Girlfriend) {
/* 65 */         gf = (Girlfriend)entityLiving;
/*    */         
/* 67 */         if (gf.isTamed())
/*    */         {
/*    */           
/* 70 */           return false;
/*    */         }
/*    */       }
/*    */     
/* 74 */     } else if (entityLiving instanceof Boyfriend) {
/* 75 */       bf = (Boyfriend)entityLiving;
/*    */       
/* 77 */       if (bf.isTamed())
/*    */       {
/*    */         
/* 80 */         return false;
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 85 */     ep = te.getOwner();
/* 86 */     if (ep == null) return false;
/*    */ 
/*    */     
/* 89 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MyEntityAIJealousy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */