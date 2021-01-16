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
/*     */   public BlockCornPlant() {
/*  40 */     super(Material.PLANTS);
/*  41 */     setDefaultState(this.blockState.getBaseState().withProperty((IProperty)STAGE, Integer.valueOf(0)));
/*  42 */     setUnlocalizedName("corn_plant");
/*  43 */     setRegistryName("corn_plant");
/*  44 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/*  45 */     setTickRandomly(true);
/*  46 */     setSoundType(SoundType.PLANT);
/*  47 */     ModBlocks.BLOCKS.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
/*  53 */     return CORN_AABB;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
/*  60 */     if (worldIn.getBlockState(pos.up()).getBlock() == Blocks.AIR && checkForDrop(worldIn, pos, state)) {
/*  61 */       int height = 0;
/*  62 */       int maxHeight = 21;
/*     */       
/*  64 */       for (int i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; i++) {
/*  65 */         BlockPos position = pos.down(i);
/*  66 */         BlockCornPlant plant = (BlockCornPlant)worldIn.getBlockState(position).getBlock();
/*  67 */         TileEntityPlant tileEntity = (TileEntityPlant)worldIn.getTileEntity(pos);
/*  68 */         height += tileEntity.getHeightContribution();
/*     */       } 
/*     */       
/*  71 */       if (ForgeHooks.onCropsGrowPre(worldIn, pos, state, true)) {
/*  72 */         if (height < maxHeight) {
/*  73 */           TileEntityPlant tileEntity = (TileEntityPlant)worldIn.getTileEntity(pos);
/*  74 */           if (tileEntity.getAge() == 15) {
/*  75 */             tileEntity.setAge(0);
/*  76 */             IBlockState currentState = worldIn.getBlockState(pos);
/*  77 */             worldIn.setBlockState(pos.up(), getDefaultState());
/*  78 */             worldIn.setBlockState(pos, (((Integer)currentState.getValue((IProperty)STAGE)).intValue() != 0) ? currentState : state.withProperty((IProperty)STAGE, Integer.valueOf(1)));
/*     */           } else {
/*  80 */             tileEntity.setAge(tileEntity.getAge() + 1);
/*     */           } 
/*     */         } else {
/*  83 */           TileEntityPlant tileEntity = (TileEntityPlant)worldIn.getTileEntity(pos);
/*  84 */           if (tileEntity.getAge() == 15) {
/*     */             
/*  86 */             int phase = tileEntity.getPhase();
/*  87 */             if (phase != 4) {
/*  88 */               if (phase <= 1) {
/*  89 */                 tileEntity.setPhase(2);
/*  90 */                 phase = tileEntity.getPhase();
/*     */               }  int j;
/*  92 */               for (j = 1; worldIn.getBlockState(pos.down(j)).getBlock() == this; j++);
/*  93 */               j--;
/*  94 */               while (j != 0) {
/*  95 */                 int stage = ((Integer)worldIn.getBlockState(pos.down(j)).getValue((IProperty)STAGE)).intValue();
/*  96 */                 if (stage < phase)
/*  97 */                   break;  j--;
/*     */               } 
/*  99 */               if (j >= 1) {
/* 100 */                 worldIn.setBlockState(pos.down(j), getDefaultState().withProperty((IProperty)STAGE, (((Integer)worldIn.getBlockState(pos.down(j)).getValue((IProperty)STAGE)).intValue() < 3) ? Integer.valueOf(((Integer)worldIn.getBlockState(pos.down(j)).getValue((IProperty)STAGE)).intValue() + 1) : worldIn.getBlockState(pos.down(j)).getValue((IProperty)STAGE)));
/*     */               } else {
/* 102 */                 tileEntity.setPhase(tileEntity.getPhase() + 1);
/*     */               } 
/*     */             } 
/*     */           } else {
/* 106 */             tileEntity.setAge(tileEntity.getAge() + 1);
/*     */           } 
/*     */         } 
/* 109 */         ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
/* 117 */     IBlockState state = worldIn.getBlockState(pos.down());
/* 118 */     Block block = state.getBlock();
/* 119 */     if (block.canSustainPlant(state, (IBlockAccess)worldIn, pos.down(), EnumFacing.UP, this)) return true;
/*     */     
/* 121 */     return (block == this || block == Blocks.GRASS || block == Blocks.DIRT || block == Blocks.FARMLAND);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
/* 127 */     checkForDrop(worldIn, pos, state);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state) {
/* 132 */     if (canBlockStay(worldIn, pos))
/*     */     {
/* 134 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 138 */     dropBlockAsItem(worldIn, pos, state, 0);
/* 139 */     worldIn.setBlockToAir(pos);
/* 140 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBlockStay(World worldIn, BlockPos pos) {
/* 146 */     return canPlaceBlockAt(worldIn, pos);
/*     */   }
/*     */ 
/*     */   
/*     */   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/* 151 */     if (((Integer)state.getValue((IProperty)STAGE)).intValue() == 3) {
/* 152 */       return ModItems.CORN;
/*     */     }
/* 154 */     return Items.AIR;
/*     */   }
/*     */ 
/*     */   
/*     */   public int quantityDropped(Random rand) {
/* 159 */     return 1 + rand.nextInt(2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube(IBlockState state) {
/* 165 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullCube(IBlockState state) {
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
/* 177 */     return BlockFaceShape.UNDEFINED;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
/* 184 */     return NULL_AABB;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public BlockRenderLayer getBlockLayer() {
/* 190 */     return BlockRenderLayer.CUTOUT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMetaFromState(IBlockState state) {
/* 196 */     return ((Integer)state.getValue((IProperty)STAGE)).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public IBlockState getStateFromMeta(int meta) {
/* 201 */     return getDefaultState().withProperty((IProperty)STAGE, Integer.valueOf(meta));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
/* 207 */     return EnumPlantType.Beach;
/*     */   }
/*     */ 
/*     */   
/*     */   public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
/* 212 */     return getDefaultState();
/*     */   }
/*     */ 
/*     */   
/*     */   protected BlockStateContainer createBlockState() {
/* 217 */     return new BlockStateContainer(this, new IProperty[] { (IProperty)STAGE });
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public TileEntity createNewTileEntity(World worldIn, int meta) {
/* 223 */     return new TileEntityPlant();
/*     */   }
/*     */   
/*     */   public boolean isBlockUnderCorn(World worldIn, BlockPos pos) {
/* 227 */     IBlockState state = worldIn.getBlockState(pos.down());
/* 228 */     Block block = state.getBlock();
/* 229 */     return (block == ModBlocks.CORN_PLANT);
/*     */   }
/*     */   
/*     */   public boolean isBlockUnderAir(World worldIn, BlockPos pos) {
/* 233 */     IBlockState state = worldIn.getBlockState(pos.down());
/* 234 */     Block block = state.getBlock();
/* 235 */     return (block == Blocks.AIR);
/*     */   }
/*     */   
/*     */   public boolean isBlockUnderGrass(World worldIn, BlockPos pos) {
/* 239 */     IBlockState state = worldIn.getBlockState(pos.down());
/* 240 */     Block block = state.getBlock();
/* 241 */     return (block == Blocks.GRASS);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\blocks\BlockCornPlant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */