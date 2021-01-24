/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import net.minecraft.item.ItemHoe;
/*    */ 
/*    */ public class EmeraldHoe extends ItemHoe {
/*    */   public EmeraldHoe() {
/*  9 */     super(OrespawnToolMaterial.EmeraldTools.Material);
/* 10 */     setUnlocalizedName("emerald_hoe");
/* 11 */     setRegistryName("emerald_hoe");
/* 12 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 13 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\items\tools\EmeraldHoe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */