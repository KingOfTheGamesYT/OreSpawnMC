/*    */ package danger.orespawn.items;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import danger.orespawn.util.IHasModel;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class ItemMaterial
/*    */   extends Item
/*    */   implements IHasModel {
/*    */   public ItemMaterial(String name) {
/* 13 */     setUnlocalizedName(name);
/* 14 */     setRegistryName(name);
/* 15 */     setCreativeTab(CreativeTabs.MATERIALS);
/*    */     
/* 17 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 22 */     OreSpawnMain.proxy.registerItemRenderer(this, 0, "inventory");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespawn\items\ItemMaterial.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */