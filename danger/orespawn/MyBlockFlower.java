/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.EnumPlantType;
/*     */ import net.minecraftforge.common.IPlantable;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MyBlockFlower
/*     */   extends Block
/*     */   implements IPlantable
/*     */ {
/*     */   protected MyBlockFlower(int par1, Material par2Material) {
/*  26 */     super(par2Material);
/*  27 */     setTickRandomly(true);
/*  28 */     float f = 0.2F;
/*  29 */     setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
/*  30 */     setCreativeTab(CreativeTabs.tabDecorations);
/*     */   }
/*     */ 
/*     */   
/*     */   protected MyBlockFlower(int par1) {
/*  35 */     this(par1, Material.plants);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
/*  43 */     return (super.canPlaceBlockAt(par1World, par2, par3, par4) && canBlockStay(par1World, par2, par3, par4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canPlaceBlockOn(Block par1) {
/*  52 */     return (par1 == Blocks.grass || par1 == Blocks.dirt || par1 == Blocks.farmland || par1 == OreSpawnMain.CrystalGrass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
/*  61 */     super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
/*  62 */     checkFlowerChange(par1World, par2, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  70 */     checkFlowerChange(par1World, par2, par3, par4);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void checkFlowerChange(World par1World, int par2, int par3, int par4) {
/*  75 */     if (!canBlockStay(par1World, par2, par3, par4)) {
/*     */       
/*  77 */       dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
/*  78 */       par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  83 */     long t = par1World.getWorldTime();
/*  84 */     t %= 24000L;
/*     */     
/*  86 */     if (t > 12000L) {
/*  87 */       if (this == OreSpawnMain.MyFlowerPinkBlock) {
/*  88 */         par1World.setBlock(par2, par3, par4, OreSpawnMain.MyFlowerBlackBlock);
/*     */       }
/*  90 */       if (this == OreSpawnMain.MyFlowerBlueBlock) {
/*  91 */         par1World.setBlock(par2, par3, par4, OreSpawnMain.MyFlowerScaryBlock);
/*     */       }
/*     */     } else {
/*  94 */       if (this == OreSpawnMain.MyFlowerBlackBlock) {
/*  95 */         par1World.setBlock(par2, par3, par4, OreSpawnMain.MyFlowerPinkBlock);
/*     */       }
/*  97 */       if (this == OreSpawnMain.MyFlowerScaryBlock) {
/*  98 */         par1World.setBlock(par2, par3, par4, OreSpawnMain.MyFlowerBlueBlock);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
/* 108 */     return p_149718_1_.getBlock(p_149718_2_, p_149718_3_ - 1, p_149718_4_).canSustainPlant((IBlockAccess)p_149718_1_, p_149718_2_, p_149718_3_ - 1, p_149718_4_, ForgeDirection.UP, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube() {
/* 126 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderAsNormalBlock() {
/* 134 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderType() {
/* 142 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 149 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
/* 155 */     return EnumPlantType.Plains;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Block getPlant(IBlockAccess world, int x, int y, int z) {
/* 161 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
/* 167 */     return world.getBlockMetadata(x, y, z);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MyBlockFlower.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */