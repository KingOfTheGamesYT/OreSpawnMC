/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import net.minecraft.item.ItemAxe;
/*    */ 
/*    */ public class GenericAxe
/*    */   extends ItemAxe {
/*    */   public GenericAxe(String name, OrespawnToolMaterial material) {
/* 10 */     super(material.Material, material.Damage, -3.0F);
/* 11 */     setUnlocalizedName(name);
/* 12 */     setRegistryName(name);
/* 13 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 14 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\items\tools\GenericAxe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */