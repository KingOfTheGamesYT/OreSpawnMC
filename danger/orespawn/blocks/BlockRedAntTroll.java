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
/*    */ public class BlockRedAntTroll
/*    */   extends Block {
/*    */   public BlockRedAntTroll() {
/* 22 */     super(Material.ROCK);
/* 23 */     setUnlocalizedName("red_ant_troll_block");
/* 24 */     setRegistryName("red_ant_troll_block");
/* 25 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 26 */     ModBlocks.BLOCKS.add(this);
/* 27 */     ModItems.ITEMS.add((new ItemBlock(this)).setRegistryName(Objects.<ResourceLocation>requireNonNull(getRegistryName())));
/*    */   }
/*    */ 
/*    */   
/*    */   public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
/* 32 */     super.breakBlock(worldIn, pos, state);
/* 33 */     for (int i = 0; i < 20; i++) {
/* 34 */       Entity ant = EntityList.newEntity(RedAnt.class, worldIn);
/* 35 */       assert ant != null;
/* 36 */       ant.setPositionAndRotation(pos.getX(), pos.getY(), pos.getZ(), worldIn.rand.nextFloat() * 360.0F, 0.0F);
/* 37 */       worldIn.spawnEntity(ant);
/* 38 */       ((EntityLiving)ant).playLivingSound();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\blocks\BlockRedAntTroll.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */