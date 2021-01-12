/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class IceBall
/*    */   extends LaserBall
/*    */ {
/* 11 */   private int my_index = 84;
/* 12 */   private int icemaker = 0;
/*    */ 
/*    */   
/*    */   public IceBall(World par1World) {
/* 16 */     super(par1World);
/* 17 */     setIceBall();
/*    */   }
/*    */ 
/*    */   
/*    */   public IceBall(World par1World, int par2) {
/* 22 */     super(par1World);
/* 23 */     setIceBall();
/*    */   }
/*    */ 
/*    */   
/*    */   public IceBall(World par1World, EntityLivingBase par2EntityLiving) {
/* 28 */     super(par1World, par2EntityLiving);
/* 29 */     setIceBall();
/*    */   }
/*    */ 
/*    */   
/*    */   public IceBall(World par1World, EntityLivingBase par2EntityLiving, int par3) {
/* 34 */     super(par1World, par2EntityLiving);
/* 35 */     setIceBall();
/*    */   }
/*    */ 
/*    */   
/*    */   public IceBall(World par1World, double par2, double par4, double par6) {
/* 40 */     super(par1World, par2, par4, par6);
/* 41 */     setIceBall();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getIceBallIndex() {
/* 47 */     return this.my_index;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setIceMaker(int i) {
/* 52 */     this.icemaker = i;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
/* 57 */     if (par1MovingObjectPosition.entityHit != null)
/*    */     {
/* 59 */       if (MyUtils.isRoyalty(par1MovingObjectPosition.entityHit)) {
/* 60 */         setDead();
/*    */         return;
/*    */       } 
/*    */     }
/* 64 */     super.onImpact(par1MovingObjectPosition);
/* 65 */     if (this.icemaker != 0)
/*    */     {
/* 67 */       for (int i = 0; i < 5; i++) {
/* 68 */         int x = this.worldObj.rand.nextInt(4);
/* 69 */         if (this.worldObj.rand.nextInt(2) == 1) x = -x; 
/* 70 */         int y = this.worldObj.rand.nextInt(4);
/* 71 */         if (this.worldObj.rand.nextInt(2) == 1) y = -y; 
/* 72 */         int z = this.worldObj.rand.nextInt(4);
/* 73 */         if (this.worldObj.rand.nextInt(2) == 1) z = -z; 
/* 74 */         x = (int)(x + par1MovingObjectPosition.hitVec.xCoord);
/* 75 */         y = (int)(y + par1MovingObjectPosition.hitVec.yCoord);
/* 76 */         z = (int)(z + par1MovingObjectPosition.hitVec.zCoord);
/* 77 */         this.worldObj.setBlock(x, y, z, Blocks.ice);
/*    */       } 
/*    */     }
/* 80 */     setDead();
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\IceBall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */