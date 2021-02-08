/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import net.minecraft.item.ItemAxe;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EmeraldAxe
/*    */   extends ItemAxe
/*    */ {
/*    */   public EmeraldAxe() {
/* 15 */     super(OrespawnToolMaterial.EmeraldTools.Material, OrespawnToolMaterial.EmeraldTools.Damage, -3.0F);
/* 16 */     setUnlocalizedName("emerald_axe");
/* 17 */     setRegistryName("emerald_axe");
/* 18 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 19 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\items\tools\EmeraldAxe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */