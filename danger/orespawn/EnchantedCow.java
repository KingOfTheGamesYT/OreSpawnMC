/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityAgeable;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.entity.passive.EntityCow;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EnchantedCow
/*    */   extends RedCow
/*    */ {
/*    */   public EnchantedCow(World world) {
/* 15 */     super(world);
/*    */   }
/*    */ 
/*    */   
/*    */   private void dropEnchantedGoldenApple() {
/* 20 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX, this.posY + 1.0D, this.posZ, new ItemStack(Items.golden_apple, 1, 1));
/* 21 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void dropFewItems(boolean par1, int par2) {
/* 29 */     int var3 = this.rand.nextInt(4) + this.rand.nextInt(1 + par2);
/*    */ 
/*    */     
/* 32 */     for (int var4 = 0; var4 < var3; var4++)
/*    */     {
/* 34 */       dropItem(Items.apple, 1);
/*    */     }
/*    */     
/* 37 */     dropItem(Items.golden_apple, 2);
/*    */     
/* 39 */     dropEnchantedGoldenApple();
/*    */     
/* 41 */     super.dropFewItems(par1, par2);
/*    */   }
/*    */   
/*    */   public EntityCow createChild(EntityAgeable entityageable) {
/* 45 */     return spawnBabyAnimal(entityageable);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EnchantedCow spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 51 */     return new EnchantedCow(this.worldObj);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EnchantedCow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */