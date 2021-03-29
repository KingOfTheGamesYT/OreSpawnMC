/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.SoundType;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class OreGenericEgg
/*    */   extends Block {
/*    */   public OreGenericEgg(String name) {
/* 19 */     super(Material.GROUND);
/* 20 */     setHardness(0.5F);
/* 21 */     setResistance(1.0F);
/* 22 */     setUnlocalizedName(name);
/* 23 */     setRegistryName(name);
/* 24 */     setSoundType(SoundType.GROUND);
/* 25 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 26 */     ModBlocks.BLOCKS.add(this);
/* 27 */     ModItems.ITEMS.add((new ItemBlock(this)).setRegistryName(Objects.<ResourceLocation>requireNonNull(getRegistryName())));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
/* 35 */     super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
/* 36 */     int dropAmount = 5 + worldIn.rand.nextInt(3) + worldIn.rand.nextInt(3);
/* 37 */     if (worldIn.rand.nextInt(2) == 1)
/* 38 */       dropXpOnBlockBreak(worldIn, pos, dropAmount); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\blocks\OreGenericEgg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */