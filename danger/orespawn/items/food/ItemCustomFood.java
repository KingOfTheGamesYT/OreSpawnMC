/*    */ package danger.orespawn.items.food;
/*    */ 
/*    */ import danger.orespawn.init.ModItems;
/*    */ import net.minecraft.item.ItemFood;
/*    */ 
/*    */ public class ItemCustomFood
/*    */   extends ItemFood {
/*    */   public ItemCustomFood(String name, int amount, boolean isWolfFood) {
/*  9 */     super(amount, isWolfFood);
/* 10 */     setUnlocalizedName(name);
/* 11 */     setRegistryName(name);
/*    */ 
/*    */     
/* 14 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\items\food\ItemCustomFood.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */