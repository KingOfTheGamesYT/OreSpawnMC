/*    */ package danger.orespawn.blocks;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.entity.Butterfly;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.BlockCrops;
/*    */ import net.minecraft.block.properties.IProperty;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityList;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
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
/* 32 */     setUnlocalizedName("butterfly_plant");
/* 33 */     setRegistryName("butterfly_plant");
/* 34 */     setDefaultState(getDefaultState().withProperty((IProperty)AGE, Integer.valueOf(0)));
/* 35 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 36 */     ModBlocks.BLOCKS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
/* 41 */     super.updateTick(worldIn, pos, state, rand);
/*    */     
/* 43 */     if (worldIn.isRaining())
/*    */       return; 
/* 45 */     IBlockState st = worldIn.getBlockState(pos);
/* 46 */     int rate = st.getBlock().getMetaFromState(st);
/* 47 */     rate &= 0x7;
/* 48 */     rate = 7 - rate;
/* 49 */     if (rate > 1 && 
/* 50 */       OreSpawnMain.OreSpawnRand.nextInt(rate) != 0)
/*    */       return; 
/* 52 */     if (worldIn.getBlockState(pos.up(1)).getBlock() == Blocks.AIR && worldIn.isDaytime()) {
/* 53 */       Entity butterfly = EntityList.createEntityByID(EntityList.getID(Butterfly.class), worldIn);
/* 54 */       butterfly.setPosition(pos.getX(), (pos.getY() + 1), pos.getZ());
/* 55 */       worldIn.spawnEntity(butterfly);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/* 63 */     return ModItems.BUTTERFLY_SEED;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected Item getSeed() {
/* 69 */     return ModItems.BUTTERFLY_SEED;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected Item getCrop() {
/* 75 */     return ModItems.BUTTERFLY_SEED;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespawn\blocks\BlockButterflyPlant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */