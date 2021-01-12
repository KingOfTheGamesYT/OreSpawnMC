/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class DeadIrukandji
/*    */   extends LaserBall {
/*  8 */   private int my_index = 86;
/*    */ 
/*    */   
/*    */   public DeadIrukandji(World par1World) {
/* 12 */     super(par1World);
/* 13 */     setIrukandji();
/*    */   }
/*    */ 
/*    */   
/*    */   public DeadIrukandji(World par1World, int par2) {
/* 18 */     super(par1World);
/* 19 */     setIrukandji();
/*    */   }
/*    */ 
/*    */   
/*    */   public DeadIrukandji(World par1World, EntityLivingBase par2EntityLiving) {
/* 24 */     super(par1World, par2EntityLiving);
/* 25 */     setIrukandji();
/*    */   }
/*    */ 
/*    */   
/*    */   public DeadIrukandji(World par1World, EntityLivingBase par2EntityLiving, int par3) {
/* 30 */     super(par1World, par2EntityLiving);
/* 31 */     setIrukandji();
/*    */   }
/*    */ 
/*    */   
/*    */   public DeadIrukandji(World par1World, double par2, double par4, double par6) {
/* 36 */     super(par1World, par2, par4, par6);
/* 37 */     setIrukandji();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getIrukandjiIndex() {
/* 43 */     return this.my_index;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\DeadIrukandji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */