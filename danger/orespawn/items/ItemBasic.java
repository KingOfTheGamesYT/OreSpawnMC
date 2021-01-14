/*    */ package danger.orespawn.items;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class ItemBasic
/*    */   extends Item
/*    */ {
/*    */   public ItemBasic(String name) {
/* 11 */     setUnlocalizedName(name);
/* 12 */     setRegistryName(name);
/* 13 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 14 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespawn\items\ItemBasic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */