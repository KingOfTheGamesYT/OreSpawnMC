/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.entity.EntityAgeable;
/*    */ import net.minecraft.entity.passive.EntityCow;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class CrystalCow
/*    */   extends RedCow
/*    */ {
/*    */   public CrystalCow(World world) {
/* 13 */     super(world);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void dropFewItems(boolean par1, int par2) {
/* 21 */     int var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
/*    */ 
/*    */     
/* 24 */     for (int var4 = 0; var4 < var3; var4++)
/*    */     {
/* 26 */       dropItem(OreSpawnMain.MyCrystalApple, 1);
/*    */     }
/*    */     
/* 29 */     dropItem(Items.apple, 1);
/*    */     
/* 31 */     super.dropFewItems(par1, par2);
/*    */   }
/*    */   
/*    */   public EntityCow createChild(EntityAgeable entityageable) {
/* 35 */     return spawnBabyAnimal(entityageable);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CrystalCow spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 41 */     return new CrystalCow(this.worldObj);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CrystalCow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */