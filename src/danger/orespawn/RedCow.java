/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.entity.EntityAgeable;
/*    */ import net.minecraft.entity.passive.EntityCow;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RedCow
/*    */   extends EntityCow
/*    */ {
/*    */   public RedCow(World world) {
/* 16 */     super(world);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void dropFewItems(boolean par1, int par2) {
/* 24 */     int var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
/*    */ 
/*    */     
/* 27 */     for (int var4 = 0; var4 < var3; var4++)
/*    */     {
/* 29 */       dropItem(Items.apple, 1);
/*    */     }
/*    */     
/* 32 */     super.dropFewItems(par1, par2);
/*    */   }
/*    */   
/*    */   public EntityCow createChild(EntityAgeable entityageable) {
/* 36 */     return spawnBabyAnimal(entityageable);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RedCow spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 42 */     return new RedCow(this.worldObj);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void updateAITick() {
/* 47 */     if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 48 */     super.updateAITick();
/*    */   }
/*    */   
/*    */   protected boolean canDespawn() {
/* 52 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RedCow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */