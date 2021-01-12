/*    */ package danger.orespawn.items;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import danger.orespawn.util.IHasModel;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class ItemBase
/*    */   extends Item
/*    */   implements IHasModel
/*    */ {
/*    */   public ItemBase(String name) {
/* 14 */     setUnlocalizedName(name);
/* 15 */     setRegistryName(name);
/* 16 */     setCreativeTab(CreativeTabs.MISC);
/*    */     
/* 18 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 23 */     OreSpawnMain.proxy.registerItemRenderer(this, 0, "inventory");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespawn\items\ItemBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */