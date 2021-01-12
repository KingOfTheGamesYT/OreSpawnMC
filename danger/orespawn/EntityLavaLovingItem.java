/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityLavaLovingItem
/*    */   extends EntityItem
/*    */ {
/*    */   public EntityLavaLovingItem(World par1World, double par2, double par4, double par6, ItemStack par8ItemStack) {
/* 15 */     super(par1World, par2, par4, par6, par8ItemStack);
/* 16 */     this.fireResistance = 300;
/* 17 */     this.isImmuneToFire = true;
/* 18 */     this.hurtResistantTime = 300;
/*    */   }
/*    */ 
/*    */   
/*    */   public void noFire() {
/* 23 */     this.fireResistance = 300;
/* 24 */     this.isImmuneToFire = true;
/* 25 */     this.hurtResistantTime = 300;
/*    */   }
/*    */ 
/*    */   
/*    */   public void yesFire() {
/* 30 */     this.fireResistance = 0;
/* 31 */     this.isImmuneToFire = false;
/* 32 */     this.hurtResistantTime = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void dealFireDamage(float par1) {
/* 37 */     if (!this.isImmuneToFire)
/*    */     {
/* 39 */       attackEntityFrom(DamageSource.inFire, par1);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EntityLavaLovingItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */