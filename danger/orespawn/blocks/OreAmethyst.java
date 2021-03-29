/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class OreAmethyst extends Block {
/*    */   public OreAmethyst() {
/* 17 */     super(Material.ROCK);
/* 18 */     setUnlocalizedName("amethyst_ore");
/* 19 */     setRegistryName("amethyst_ore");
/* 20 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 21 */     setHardness(5.0F);
/* 22 */     setResistance(5.0F);
/* 23 */     setHarvestLevel("pickaxe", 2);
/* 24 */     setLightLevel(0.2F);
/*    */     
/* 26 */     ModBlocks.BLOCKS.add(this);
/* 27 */     ModItems.ITEMS.add((new ItemBlock(this)).setRegistryName(Objects.<ResourceLocation>requireNonNull(getRegistryName())));
/*    */   }
/*    */ 
/*    */   
/*    */   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/* 32 */     return ModItems.AMETHYST;
/*    */   }
/*    */ 
/*    */   
/*    */   public int quantityDropped(Random random) {
/* 37 */     return random.nextInt(2) + 1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\blocks\OreAmethyst.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */