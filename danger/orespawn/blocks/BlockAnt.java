/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.entity.RedAnt;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityList;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockAnt
/*    */   extends Block
/*    */ {
/*    */   public BlockAnt() {
/* 31 */     super(Material.GRASS);
/* 32 */     setUnlocalizedName("ant_block");
/* 33 */     setRegistryName("ant_block");
/* 34 */     setTickRandomly(true);
/* 35 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 36 */     ModBlocks.BLOCKS.add(this);
/* 37 */     ModItems.ITEMS.add((new ItemBlock(this)).setRegistryName(Objects.<ResourceLocation>requireNonNull(getRegistryName())));
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
/* 42 */     super.updateTick(worldIn, pos, state, rand);
/*    */ 
/*    */     
/* 45 */     if (worldIn.getBlockState(pos.up(1)).getBlock() == Blocks.AIR && worldIn.isDaytime()) {
/* 46 */       int howmany = OreSpawnMain.OreSpawnRand.nextInt(6) + 2;
/* 47 */       for (int i = 0; i < howmany; i++) {
/* 48 */         Entity ant = EntityList.createEntityByID(EntityList.getID(RedAnt.class), worldIn);
/* 49 */         ant.setPositionAndRotation(pos.getX(), (pos.getY() + 1), pos.getZ(), rand.nextFloat() * 360.0F, 0.0F);
/* 50 */         worldIn.spawnEntity(ant);
/* 51 */         ((EntityLiving)ant).playLivingSound();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespawn\blocks\BlockAnt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */