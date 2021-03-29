/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.entity.Moth;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.BlockCrops;
/*    */ import net.minecraft.block.properties.IProperty;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityList;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.math.AxisAlignedBB;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.chunk.Chunk;
/*    */ 
/*    */ public class BlockMothPlant extends BlockCrops {
/*    */   private boolean shouldSpawn = true;
/*    */   
/*    */   public BlockMothPlant() {
/* 26 */     setUnlocalizedName("moth_plant");
/* 27 */     setRegistryName("moth_plant");
/* 28 */     setDefaultState(getDefaultState().withProperty((IProperty)AGE, Integer.valueOf(0)));
/* 29 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 30 */     ModBlocks.BLOCKS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
/* 35 */     super.updateTick(worldIn, pos, state, rand);
/*    */     
/* 37 */     if (worldIn.isRaining())
/*    */       return; 
/* 39 */     Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
/* 40 */     float radius = 50.0F;
/* 41 */     AxisAlignedBB aabb = new AxisAlignedBB((pos.getX() - radius), 0.0D, (pos.getZ() - radius), (pos.getX() + radius), 200.0D, (pos.getZ() + radius));
/* 42 */     List<Moth> mothList = new ArrayList<>();
/* 43 */     chunk.getEntitiesOfTypeWithinAABB(Moth.class, aabb, mothList, e -> true);
/* 44 */     if (mothList.size() > 15)
/*    */       return; 
/* 46 */     IBlockState st = worldIn.getBlockState(pos);
/* 47 */     int rate = st.getBlock().getMetaFromState(st);
/* 48 */     rate &= 0x7;
/* 49 */     rate = 6 - rate;
/* 50 */     if (rate > 1 && 
/* 51 */       OreSpawnMain.OreSpawnRand.nextInt(rate) != 0)
/*    */       return; 
/* 53 */     if (worldIn.getBlockState(pos.up(1)).getBlock() == Blocks.AIR && !worldIn.isDaytime()) {
/* 54 */       Entity moth = EntityList.newEntity(Moth.class, worldIn);
/*    */       
/* 56 */       assert moth != null;
/* 57 */       moth.setPosition(pos.getX(), (pos.getY() + 1), pos.getZ());
/* 58 */       worldIn.spawnEntity(moth);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/* 65 */     return ModItems.MOTH_SEED;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Item getSeed() {
/* 70 */     return ModItems.MOTH_SEED;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Item getCrop() {
/* 75 */     return ModItems.MOTH_SEED;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\blocks\BlockMothPlant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */