/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.entity.Mosquito;
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
/*    */ public class BlockMosquitoPlant
/*    */   extends BlockCrops {
/*    */   public BlockMosquitoPlant() {
/* 25 */     setUnlocalizedName("mosquito_plant");
/* 26 */     setRegistryName("mosquito_plant");
/* 27 */     setDefaultState(getDefaultState().withProperty((IProperty)AGE, Integer.valueOf(0)));
/* 28 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 29 */     ModBlocks.BLOCKS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
/* 34 */     super.updateTick(worldIn, pos, state, rand);
/*    */     
/* 36 */     if (worldIn.isRaining())
/*    */       return; 
/* 38 */     Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
/* 39 */     float radius = 50.0F;
/* 40 */     AxisAlignedBB aabb = new AxisAlignedBB((pos.getX() - radius), 0.0D, (pos.getZ() - radius), (pos.getX() + radius), 200.0D, (pos.getZ() + radius));
/* 41 */     List<Mosquito> mosquitoList = new ArrayList<>();
/* 42 */     chunk.getEntitiesOfTypeWithinAABB(Mosquito.class, aabb, mosquitoList, e -> true);
/* 43 */     if (mosquitoList.size() > 15)
/*    */       return; 
/* 45 */     IBlockState st = worldIn.getBlockState(pos);
/* 46 */     int rate = st.getBlock().getMetaFromState(st);
/* 47 */     rate &= 0x7;
/* 48 */     rate = 6 - rate;
/* 49 */     if (rate > 1 && 
/* 50 */       OreSpawnMain.OreSpawnRand.nextInt(rate) != 0)
/*    */       return; 
/* 52 */     if (worldIn.getBlockState(pos.up(1)).getBlock() == Blocks.AIR && worldIn.isDaytime()) {
/* 53 */       Entity mosquito = EntityList.newEntity(Mosquito.class, worldIn);
/* 54 */       mosquito.setPosition(pos.getX(), (pos.getY() + 1), pos.getZ());
/* 55 */       worldIn.spawnEntity(mosquito);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/* 61 */     return ModItems.MOSQUITO_SEED;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Item getSeed() {
/* 66 */     return ModItems.MOSQUITO_SEED;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Item getCrop() {
/* 71 */     return ModItems.MOSQUITO_SEED;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\blocks\BlockMosquitoPlant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */