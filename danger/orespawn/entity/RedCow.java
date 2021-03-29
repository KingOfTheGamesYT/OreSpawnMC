/*    */ package danger.orespawn.entity;
/*    */ 
/*    */ import net.minecraft.entity.EntityAgeable;
/*    */ import net.minecraft.entity.passive.EntityCow;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class RedCow
/*    */   extends EntityCow {
/*    */   public RedCow(World world) {
/* 11 */     super(world);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void dropFewItems(boolean par1, int par2) {
/* 20 */     int var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
/*    */ 
/*    */     
/* 23 */     for (int var4 = 0; var4 < var3; var4++)
/*    */     {
/* 25 */       dropItem(Items.APPLE, 1);
/*    */     }
/*    */     
/* 28 */     super.dropFewItems(par1, par2);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityCow createChild(EntityAgeable entityageable) {
/* 33 */     return spawnBabyAnimal(entityageable);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RedCow spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 39 */     return new RedCow(this.world);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void updateAITasks() {
/* 50 */     if (this.world.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 51 */     super.updateAITasks();
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean canDespawn() {
/* 56 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\RedCow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */