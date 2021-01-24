/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.entity.RedAnt;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ import net.minecraft.util.math.AxisAlignedBB;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.chunk.Chunk;
/*    */ 
/*    */ 
/*    */ public class BlockAnt
/*    */   extends Block
/*    */ {
/*    */   public BlockAnt() {
/* 30 */     super(Material.GRASS);
/* 31 */     setUnlocalizedName("ant_block");
/* 32 */     setRegistryName("ant_block");
/* 33 */     setTickRandomly(true);
/* 34 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 35 */     ModBlocks.BLOCKS.add(this);
/* 36 */     ModItems.ITEMS.add((new ItemBlock(this)).setRegistryName(Objects.<ResourceLocation>requireNonNull(getRegistryName())));
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
/* 41 */     if (worldIn.isRemote)
/* 42 */       return;  super.updateTick(worldIn, pos, state, rand);
/*    */     
/* 44 */     if (worldIn.getBlockState(pos.up(1)).getBlock() == Blocks.AIR && worldIn.isDaytime()) {
/* 45 */       Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
/* 46 */       int radius = 16;
/* 47 */       AxisAlignedBB aabb = new AxisAlignedBB((pos.getX() - radius), 0.0D, (pos.getZ() - radius), (pos.getX() + radius), 200.0D, (pos.getZ() + radius));
/* 48 */       List<RedAnt> antList = new ArrayList<>();
/* 49 */       chunk.getEntitiesOfTypeWithinAABB(RedAnt.class, aabb, antList, e -> true);
/* 50 */       if (antList.size() > 20)
/*    */         return; 
/* 52 */       int howmany = OreSpawnMain.OreSpawnRand.nextInt(6) + 2;
/* 53 */       for (int i = 0; i < howmany; i++) {
/* 54 */         Entity ant = EntityList.newEntity(RedAnt.class, worldIn);
/* 55 */         ant.setPositionAndRotation(pos.getX(), (pos.getY() + 1), pos.getZ(), rand.nextFloat() * 360.0F, 0.0F);
/* 56 */         worldIn.spawnEntity(ant);
/* 57 */         ((EntityLiving)ant).playLivingSound();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\blocks\BlockAnt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */