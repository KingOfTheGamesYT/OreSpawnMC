/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class BlockAmethyst extends Block {
/*    */   public BlockAmethyst() {
/* 14 */     super(Material.IRON);
/* 15 */     setUnlocalizedName("amethyst_block");
/* 16 */     setRegistryName("amethyst_block");
/* 17 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 18 */     setHardness(5.0F);
/* 19 */     setResistance(5.0F);
/* 20 */     setHarvestLevel("pickaxe", 2);
/* 21 */     setLightLevel(0.2F);
/*    */     
/* 23 */     ModBlocks.BLOCKS.add(this);
/* 24 */     ModItems.ITEMS.add((new ItemBlock(this)).setRegistryName(Objects.<ResourceLocation>requireNonNull(getRegistryName())));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\blocks\BlockAmethyst.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */