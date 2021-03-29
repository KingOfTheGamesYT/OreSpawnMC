/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.entity.RedAnt;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityList;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockTermiteTroll extends Block {
/*    */   public BlockTermiteTroll() {
/* 21 */     super(Material.ROCK);
/* 22 */     setUnlocalizedName("termite_troll_block");
/* 23 */     setRegistryName("termite_troll_block");
/* 24 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 25 */     ModBlocks.BLOCKS.add(this);
/* 26 */     ModItems.ITEMS.add((new ItemBlock(this)).setRegistryName(Objects.<ResourceLocation>requireNonNull(getRegistryName())));
/*    */   }
/*    */ 
/*    */   
/*    */   public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
/* 31 */     super.breakBlock(worldIn, pos, state);
/* 32 */     for (int i = 0; i < 20; i++) {
/* 33 */       Entity termite = EntityList.newEntity(RedAnt.class, worldIn);
/* 34 */       assert termite != null;
/* 35 */       termite.setPositionAndRotation(pos.getX(), pos.getY(), pos.getZ(), worldIn.rand.nextFloat() * 360.0F, 0.0F);
/* 36 */       worldIn.spawnEntity(termite);
/* 37 */       ((EntityLiving)termite).playLivingSound();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\blocks\BlockTermiteTroll.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */