/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import net.minecraft.item.ItemSword;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EmeraldSword
/*    */   extends ItemSword
/*    */ {
/*    */   public EmeraldSword() {
/* 16 */     super(OrespawnToolMaterial.EmeraldTools.Material);
/* 17 */     setUnlocalizedName("emerald_sword");
/* 18 */     setRegistryName("emerald_sword");
/* 19 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 20 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\items\tools\EmeraldSword.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */