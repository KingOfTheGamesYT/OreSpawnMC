/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import net.minecraft.item.ItemSword;
/*    */ 
/*    */ public class GenericSword extends ItemSword {
/*    */   public GenericSword(String name, OrespawnToolMaterial material) {
/*  9 */     super(material.Material);
/* 10 */     setUnlocalizedName(name);
/* 11 */     setRegistryName(name);
/* 12 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 13 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\items\tools\GenericSword.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */