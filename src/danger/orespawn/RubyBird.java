/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class RubyBird
/*    */   extends Cockateil {
/*    */   public RubyBird(World par1World) {
/*  8 */     super(par1World);
/*    */   }
/*    */   
/*    */   protected void entityInit() {
/* 12 */     super.entityInit();
/* 13 */     this.birdtype = 5;
/* 14 */     setBirdType(this.birdtype);
/* 15 */     setFlyUp();
/*    */   }
/*    */   
/*    */   protected String getLivingSound() {
/* 19 */     if (this.worldObj.isDaytime() && !this.worldObj.isRaining()) {
/* 20 */       return "orespawn:rubybird";
/*    */     }
/* 22 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getCanSpawnHere() {
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RubyBird.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */