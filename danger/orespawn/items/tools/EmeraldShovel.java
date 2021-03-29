/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import net.minecraft.item.ItemSpade;
/*    */ 
/*    */ public class EmeraldShovel extends ItemSpade {
/*    */   public EmeraldShovel() {
/*  9 */     super(OrespawnToolMaterial.EmeraldTools.Material);
/* 10 */     setUnlocalizedName("emerald_shovel");
/* 11 */     setRegistryName("emerald_shovel");
/* 12 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 13 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\items\tools\EmeraldShovel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */