/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ 
/*    */ public class BlockBasic
/*    */   extends Block {
/*    */   public BlockBasic(String name, Material material) {
/* 10 */     super(material);
/* 11 */     setUnlocalizedName(name);
/* 12 */     setRegistryName(name);
/* 13 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\blocks\BlockBasic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */