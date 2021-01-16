/*    */ package danger.orespawn.items.food;
/*    */ 
/*    */ import danger.orespawn.init.ModItems;
/*    */ import net.minecraft.item.ItemFood;
/*    */ 
/*    */ 
/*    */ public class ItemCustomFood
/*    */   extends ItemFood
/*    */ {
/*    */   public ItemCustomFood(String name, int amount, boolean isWolfFood) {
/* 11 */     super(amount, isWolfFood);
/* 12 */     setUnlocalizedName(name);
/* 13 */     setRegistryName(name);
/*    */ 
/*    */     
/* 16 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\items\food\ItemCustomFood.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */