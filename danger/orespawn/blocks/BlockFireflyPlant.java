/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.entity.Butterfly;
/*    */ import danger.orespawn.entity.Firefly;
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
/*    */ public class BlockFireflyPlant extends BlockCrops {
/*    */   private boolean shouldSpawn = true;
/*    */   
/*    */   public BlockFireflyPlant() {
/* 27 */     setUnlocalizedName("firefly_plant");
/* 28 */     setRegistryName("firefly_plant");
/* 29 */     setDefaultState(getDefaultState().withProperty((IProperty)AGE, Integer.valueOf(0)));
/* 30 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 31 */     ModBlocks.BLOCKS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
/* 36 */     super.updateTick(worldIn, pos, state, rand);
/*    */     
/* 38 */     if (worldIn.isRaining())
/*    */       return; 
/* 40 */     Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
/* 41 */     float radius = 50.0F;
/* 42 */     AxisAlignedBB aabb = new AxisAlignedBB((pos.getX() - radius), 0.0D, (pos.getZ() - radius), (pos.getX() + radius), 200.0D, (pos.getZ() + radius));
/* 43 */     List<Butterfly> butterflyList = new ArrayList<>();
/* 44 */     chunk.getEntitiesOfTypeWithinAABB(Butterfly.class, aabb, butterflyList, e -> true);
/* 45 */     if (butterflyList.size() > 15)
/*    */       return; 
/* 47 */     IBlockState st = worldIn.getBlockState(pos);
/* 48 */     int rate = st.getBlock().getMetaFromState(st);
/* 49 */     rate &= 0x7;
/* 50 */     rate = 6 - rate;
/* 51 */     if (rate > 1 && 
/* 52 */       OreSpawnMain.OreSpawnRand.nextInt(rate) != 0)
/*    */       return; 
/* 54 */     if (worldIn.getBlockState(pos.up(1)).getBlock() == Blocks.AIR && !worldIn.isDaytime()) {
/* 55 */       Entity firefly = EntityList.newEntity(Firefly.class, worldIn);
/*    */       
/* 57 */       firefly.setPosition(pos.getX(), (pos.getY() + 1), pos.getZ());
/* 58 */       worldIn.spawnEntity(firefly);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/* 65 */     return ModItems.FIREFLY_SEED;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Item getSeed() {
/* 70 */     return ModItems.FIREFLY_SEED;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Item getCrop() {
/* 75 */     return ModItems.FIREFLY_SEED;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\blocks\BlockFireflyPlant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */