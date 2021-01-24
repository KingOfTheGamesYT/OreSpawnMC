/*    */ package danger.orespawn.tabs;
/*    */ 
/*    */ import danger.orespawn.init.ModItems;
/*    */ import mcp.MethodsReturnNonnullByDefault;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ @MethodsReturnNonnullByDefault
/*    */ public class OrespawnTab extends CreativeTabs {
/*    */   public OrespawnTab() {
/* 11 */     super("Orespawn");
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack getTabIconItem() {
/* 16 */     return new ItemStack(ModItems.ULTIMATE_SWORD);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\tabs\OrespawnTab.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */