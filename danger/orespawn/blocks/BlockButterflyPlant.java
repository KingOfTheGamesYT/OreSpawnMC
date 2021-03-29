/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.entity.Butterfly;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockButterflyPlant
/*    */   extends BlockCrops
/*    */ {
/*    */   private boolean shouldSpawn = true;
/*    */   
/*    */   public BlockButterflyPlant() {
/* 39 */     setUnlocalizedName("butterfly_plant");
/* 40 */     setRegistryName("butterfly_plant");
/* 41 */     setDefaultState(getDefaultState().withProperty((IProperty)AGE, Integer.valueOf(0)));
/* 42 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 43 */     ModBlocks.BLOCKS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
/* 48 */     super.updateTick(worldIn, pos, state, rand);
/*    */     
/* 50 */     if (worldIn.isRaining())
/*    */       return; 
/* 52 */     Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
/* 53 */     float radius = 50.0F;
/* 54 */     AxisAlignedBB aabb = new AxisAlignedBB((pos.getX() - radius), 0.0D, (pos.getZ() - radius), (pos.getX() + radius), 200.0D, (pos.getZ() + radius));
/* 55 */     List<Butterfly> butterflyList = new ArrayList<>();
/* 56 */     chunk.getEntitiesOfTypeWithinAABB(Butterfly.class, aabb, butterflyList, e -> true);
/* 57 */     if (butterflyList.size() > 15)
/*    */       return; 
/* 59 */     IBlockState st = worldIn.getBlockState(pos);
/* 60 */     int rate = st.getBlock().getMetaFromState(st);
/* 61 */     rate &= 0x7;
/* 62 */     rate = 7 - rate;
/* 63 */     if (rate > 1 && 
/* 64 */       OreSpawnMain.OreSpawnRand.nextInt(rate) != 0)
/*    */       return; 
/* 66 */     if (worldIn.getBlockState(pos.up(1)).getBlock() == Blocks.AIR && worldIn.isDaytime()) {
/* 67 */       Entity butterfly = EntityList.newEntity(Butterfly.class, worldIn);
/*    */       
/* 69 */       butterfly.setPosition(pos.getX(), (pos.getY() + 1), pos.getZ());
/* 70 */       worldIn.spawnEntity(butterfly);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/* 77 */     return ModItems.BUTTERFLY_SEED;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Item getSeed() {
/* 82 */     return ModItems.BUTTERFLY_SEED;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Item getCrop() {
/* 87 */     return ModItems.BUTTERFLY_SEED;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\blocks\BlockButterflyPlant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */