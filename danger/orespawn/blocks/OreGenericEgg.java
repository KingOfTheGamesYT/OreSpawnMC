/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class OreGenericEgg extends Block {
/*    */   public OreGenericEgg(String name) {
/* 17 */     super(Material.GROUND);
/* 18 */     setHardness(0.5F);
/* 19 */     setResistance(1.0F);
/* 20 */     setUnlocalizedName(name);
/* 21 */     setRegistryName(name);
/*    */     
/* 23 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 24 */     ModBlocks.BLOCKS.add(this);
/* 25 */     ModItems.ITEMS.add((new ItemBlock(this)).setRegistryName(Objects.<ResourceLocation>requireNonNull(getRegistryName())));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
/* 33 */     super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
/* 34 */     int dropAmount = 5 + worldIn.rand.nextInt(3) + worldIn.rand.nextInt(3);
/* 35 */     if (worldIn.rand.nextInt(2) == 1)
/* 36 */       dropXpOnBlockBreak(worldIn, pos, dropAmount); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\blocks\OreGenericEgg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */