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
/* 29 */   private AntType ANT_TYPE = AntType.RED;
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
/* 42 */     if (worldIn.isRemote)
/* 43 */       return;  super.updateTick(worldIn, pos, state, rand);
/*    */     
/* 45 */     if (worldIn.getBlockState(pos.up(1)).getBlock() == Blocks.AIR && worldIn.isDaytime()) {
/* 46 */       Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
/* 47 */       int radius = 16;
/* 48 */       AxisAlignedBB aabb = new AxisAlignedBB((pos.getX() - radius), 0.0D, (pos.getZ() - radius), (pos.getX() + radius), 200.0D, (pos.getZ() + radius));
/* 49 */       List<RedAnt> antList = new ArrayList<>();
/* 50 */       chunk.getEntitiesOfTypeWithinAABB(RedAnt.class, aabb, antList, e -> true);
/* 51 */       if (antList.size() > 20)
/*    */         return; 
/* 53 */       int howmany = OreSpawnMain.OreSpawnRand.nextInt(6) + 2;
/* 54 */       for (int i = 0; i < howmany; i++) {
/* 55 */         Entity ant = EntityList.newEntity(getClassFromAntType(this.ANT_TYPE), worldIn);
/* 56 */         ant.setPositionAndRotation(pos.getX(), (pos.getY() + 1), pos.getZ(), rand.nextFloat() * 360.0F, 0.0F);
/* 57 */         worldIn.spawnEntity(ant);
/* 58 */         ((EntityLiving)ant).playLivingSound();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private Class<? extends Entity> getClassFromAntType(AntType type) {
/* 64 */     switch (type) {
/*    */       case RED:
/* 66 */         return (Class)RedAnt.class;
/*    */     } 
/* 68 */     return (Class)RedAnt.class;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\blocks\BlockAnt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */