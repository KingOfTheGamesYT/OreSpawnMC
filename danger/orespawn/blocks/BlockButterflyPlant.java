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
/*    */ public class BlockButterflyPlant
/*    */   extends BlockCrops
/*    */ {
/*    */   private boolean shouldSpawn = true;
/*    */   
/*    */   public BlockButterflyPlant() {
/* 38 */     setUnlocalizedName("butterfly_plant");
/* 39 */     setRegistryName("butterfly_plant");
/* 40 */     setDefaultState(getDefaultState().withProperty((IProperty)AGE, Integer.valueOf(0)));
/* 41 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 42 */     ModBlocks.BLOCKS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
/* 47 */     super.updateTick(worldIn, pos, state, rand);
/*    */     
/* 49 */     if (worldIn.isRaining())
/*    */       return; 
/* 51 */     Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
/* 52 */     float radius = 50.0F;
/* 53 */     AxisAlignedBB aabb = new AxisAlignedBB((pos.getX() - radius), 0.0D, (pos.getZ() - radius), (pos.getX() + radius), 200.0D, (pos.getZ() + radius));
/* 54 */     List<Butterfly> butterflyList = new ArrayList<>();
/* 55 */     chunk.getEntitiesOfTypeWithinAABB(Butterfly.class, aabb, butterflyList, e -> true);
/* 56 */     if (butterflyList.size() > 15)
/*    */       return; 
/* 58 */     IBlockState st = worldIn.getBlockState(pos);
/* 59 */     int rate = st.getBlock().getMetaFromState(st);
/* 60 */     rate &= 0x7;
/* 61 */     rate = 7 - rate;
/* 62 */     if (rate > 1 && 
/* 63 */       OreSpawnMain.OreSpawnRand.nextInt(rate) != 0)
/*    */       return; 
/* 65 */     if (worldIn.getBlockState(pos.up(1)).getBlock() == Blocks.AIR && worldIn.isDaytime()) {
/* 66 */       Entity butterfly = EntityList.newEntity(Butterfly.class, worldIn);
/*    */       
/* 68 */       butterfly.setPosition(pos.getX(), (pos.getY() + 1), pos.getZ());
/* 69 */       worldIn.spawnEntity(butterfly);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/* 77 */     return ModItems.BUTTERFLY_SEED;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected Item getSeed() {
/* 83 */     return ModItems.BUTTERFLY_SEED;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected Item getCrop() {
/* 89 */     return ModItems.BUTTERFLY_SEED;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\blocks\BlockButterflyPlant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */