/*    */ package danger.orespawn.tabs;
/*    */ 
/*    */ import danger.orespawn.init.ModItems;
/*    */ import java.util.Comparator;
/*    */ import mcp.MethodsReturnNonnullByDefault;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.NonNullList;
/*    */ 
/*    */ @MethodsReturnNonnullByDefault
/*    */ public class OrespawnTab
/*    */   extends CreativeTabs
/*    */ {
/*    */   public OrespawnTab() {
/* 15 */     super("Orespawn");
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack getTabIconItem() {
/* 20 */     return new ItemStack(ModItems.ULTIMATE_SWORD);
/*    */   }
/*    */ 
/*    */   
/*    */   public void displayAllRelevantItems(NonNullList<ItemStack> list) {
/* 25 */     list.sort(Comparator.comparing(ItemStack::func_82833_r));
/* 26 */     super.displayAllRelevantItems(list);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\tabs\OrespawnTab.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */