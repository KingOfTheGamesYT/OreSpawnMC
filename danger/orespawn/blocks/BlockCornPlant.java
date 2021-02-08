/*     */ package danger.orespawn.blocks;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.init.ModBlocks;
/*     */ import danger.orespawn.init.ModItems;
/*     */ import java.util.Random;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.ITileEntityProvider;
/*     */ import net.minecraft.block.SoundType;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.properties.PropertyInteger;
/*     */ import net.minecraft.block.state.BlockFaceShape;
/*     */ import net.minecraft.block.state.BlockStateContainer;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockRenderLayer;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.EnumPlantType;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ import net.minecraftforge.common.IPlantable;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockCornPlant
/*     */   extends Block
/*     */   implements IPlantable, ITileEntityProvider
/*     */ {
/*  37 */   public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 15);
/*  38 */   protected static final AxisAlignedBB CORN_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 1.0D, 0.875D);
/*     */   
/*     */   public BlockCornPlant() {
/*  41 */     super(Material.PLANTS);
/*  42 */     setDefaultState(this.blockState.getBaseState().withProperty((IProperty)STAGE, Integer.valueOf(0)));
/*  43 */     setUnlocalizedName("corn_plant");
/*  44 */     setRegistryName("corn_plant");
/*  45 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/*  46 */     setTickRandomly(true);
/*  47 */     setSoundType(SoundType.PLANT);
/*  48 */     ModBlocks.BLOCKS.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
/*  53 */     return CORN_AABB;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
/*  59 */     if (worldIn.getBlockState(pos.up()).getBlock() == Blocks.AIR && checkForDrop(worldIn, pos, state)) {
/*  60 */       int height = 0;
/*  61 */       int maxHeight = 21;
/*     */       
/*  63 */       for (int i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; i++) {
/*  64 */         BlockPos position = pos.down(i);
/*  65 */         BlockCornPlant plant = (BlockCornPlant)worldIn.getBlockState(position).getBlock();
/*  66 */         TileEntityPlant tileEntity = (TileEntityPlant)worldIn.getTileEntity(pos);
/*  67 */         height += tileEntity.getHeightContribution();
/*     */       } 
/*     */       
/*  70 */       if (ForgeHooks.onCropsGrowPre(worldIn, pos, state, true)) {
/*  71 */         if (height < maxHeight) {
/*  72 */           TileEntityPlant tileEntity = (TileEntityPlant)worldIn.getTileEntity(pos);
/*  73 */           if (tileEntity.getAge() == 15) {
/*  74 */             tileEntity.setAge(0);
/*  75 */             IBlockState currentState = worldIn.getBlockState(pos);
/*  76 */             worldIn.setBlockState(pos.up(), getDefaultState());
/*  77 */             worldIn.setBlockState(pos, (((Integer)currentState.getValue((IProperty)STAGE)).intValue() != 0) ? currentState : state.withProperty((IProperty)STAGE, Integer.valueOf(1)));
/*     */           } else {
/*  79 */             tileEntity.setAge(tileEntity.getAge() + 1);
/*     */           } 
/*     */         } else {
/*  82 */           TileEntityPlant tileEntity = (TileEntityPlant)worldIn.getTileEntity(pos);
/*  83 */           if (tileEntity.getAge() == 15) {
/*     */             
/*  85 */             int phase = tileEntity.getPhase();
/*  86 */             if (phase != 4) {
/*  87 */               if (phase <= 1) {
/*  88 */                 tileEntity.setPhase(2);
/*  89 */                 phase = tileEntity.getPhase();
/*     */               }  int j;
/*  91 */               for (j = 1; worldIn.getBlockState(pos.down(j)).getBlock() == this; j++);
/*  92 */               j--;
/*  93 */               while (j != 0) {
/*  94 */                 int stage = ((Integer)worldIn.getBlockState(pos.down(j)).getValue((IProperty)STAGE)).intValue();
/*  95 */                 if (stage < phase)
/*  96 */                   break;  j--;
/*     */               } 
/*  98 */               if (j >= 1) {
/*  99 */                 worldIn.setBlockState(pos.down(j), getDefaultState().withProperty((IProperty)STAGE, (((Integer)worldIn.getBlockState(pos.down(j)).getValue((IProperty)STAGE)).intValue() < 3) ? Integer.valueOf(((Integer)worldIn.getBlockState(pos.down(j)).getValue((IProperty)STAGE)).intValue() + 1) : worldIn.getBlockState(pos.down(j)).getValue((IProperty)STAGE)));
/*     */               } else {
/* 101 */                 tileEntity.setPhase(tileEntity.getPhase() + 1);
/*     */               } 
/*     */             } 
/*     */           } else {
/* 105 */             tileEntity.setAge(tileEntity.getAge() + 1);
/*     */           } 
/*     */         } 
/* 108 */         ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
/* 115 */     IBlockState state = worldIn.getBlockState(pos.down());
/* 116 */     Block block = state.getBlock();
/* 117 */     if (block.canSustainPlant(state, (IBlockAccess)worldIn, pos.down(), EnumFacing.UP, this)) return true;
/*     */     
/* 119 */     return (block == this || block == Blocks.GRASS || block == Blocks.DIRT || block == Blocks.FARMLAND);
/*     */   }
/*     */ 
/*     */   
/*     */   public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
/* 124 */     checkForDrop(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   protected final boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state) {
/* 128 */     if (canBlockStay(worldIn, pos)) {
/* 129 */       return true;
/*     */     }
/* 131 */     dropBlockAsItem(worldIn, pos, state, 0);
/* 132 */     worldIn.setBlockToAir(pos);
/* 133 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBlockStay(World worldIn, BlockPos pos) {
/* 138 */     return canPlaceBlockAt(worldIn, pos);
/*     */   }
/*     */ 
/*     */   
/*     */   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/* 143 */     if (((Integer)state.getValue((IProperty)STAGE)).intValue() == 3) {
/* 144 */       return ModItems.CORN;
/*     */     }
/* 146 */     return Items.AIR;
/*     */   }
/*     */ 
/*     */   
/*     */   public int quantityDropped(Random rand) {
/* 151 */     return 1 + rand.nextInt(2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube(IBlockState state) {
/* 156 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFullCube(IBlockState state) {
/* 161 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
/* 166 */     return BlockFaceShape.UNDEFINED;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
/* 172 */     return NULL_AABB;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public BlockRenderLayer getBlockLayer() {
/* 177 */     return BlockRenderLayer.CUTOUT;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMetaFromState(IBlockState state) {
/* 182 */     return ((Integer)state.getValue((IProperty)STAGE)).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public IBlockState getStateFromMeta(int meta) {
/* 187 */     return getDefaultState().withProperty((IProperty)STAGE, Integer.valueOf(meta));
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
/* 192 */     return EnumPlantType.Beach;
/*     */   }
/*     */ 
/*     */   
/*     */   public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
/* 197 */     return getDefaultState();
/*     */   }
/*     */ 
/*     */   
/*     */   protected BlockStateContainer createBlockState() {
/* 202 */     return new BlockStateContainer(this, new IProperty[] { (IProperty)STAGE });
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public TileEntity createNewTileEntity(World worldIn, int meta) {
/* 208 */     return new TileEntityPlant();
/*     */   }
/*     */   
/*     */   public boolean isBlockUnderCorn(World worldIn, BlockPos pos) {
/* 212 */     IBlockState state = worldIn.getBlockState(pos.down());
/* 213 */     Block block = state.getBlock();
/* 214 */     return (block == ModBlocks.CORN_PLANT);
/*     */   }
/*     */   
/*     */   public boolean isBlockUnderAir(World worldIn, BlockPos pos) {
/* 218 */     IBlockState state = worldIn.getBlockState(pos.down());
/* 219 */     Block block = state.getBlock();
/* 220 */     return (block == Blocks.AIR);
/*     */   }
/*     */   
/*     */   public boolean isBlockUnderGrass(World worldIn, BlockPos pos) {
/* 224 */     IBlockState state = worldIn.getBlockState(pos.down());
/* 225 */     Block block = state.getBlock();
/* 226 */     return (block == Blocks.GRASS);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\blocks\BlockCornPlant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */