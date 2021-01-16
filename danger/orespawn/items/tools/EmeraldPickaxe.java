/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import net.minecraft.item.ItemPickaxe;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EmeraldPickaxe
/*    */   extends ItemPickaxe
/*    */ {
/*    */   public EmeraldPickaxe() {
/* 15 */     super(OrespawnToolMaterial.EmeraldTools.Material);
/* 16 */     setUnlocalizedName("emerald_pickaxe");
/* 17 */     setRegistryName("emerald_pickaxe");
/* 18 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 19 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\items\tools\EmeraldPickaxe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */