/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockTorch;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockCrystalTorch
/*     */   extends BlockTorch
/*     */ {
/*     */   public BlockCrystalTorch(int par1) {
/*  27 */     setCreativeTab(CreativeTabs.tabDecorations);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  37 */     if (par1World.rand.nextInt(4) != 1)
/*     */       return; 
/*  39 */     int var6 = par1World.getBlockMetadata(par2, par3, par4);
/*  40 */     double var7 = (par2 + 0.5F);
/*  41 */     double var9 = (par3 + 0.7F);
/*  42 */     double var11 = (par4 + 0.5F);
/*  43 */     double var13 = 0.213D;
/*  44 */     double var15 = 0.271D;
/*     */     
/*  46 */     if (var6 == 1) {
/*     */       
/*  48 */       par1World.spawnParticle("fireworksSpark", var7 - var15, var9 + var13, var11, ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 8.0F), (par1World.rand.nextFloat() / 8.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 8.0F));
/*     */       
/*  50 */       par1World.spawnParticle("flame", var7 - var15, var9 + var13, var11, ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 60.0F), (par1World.rand.nextFloat() / 10.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 60.0F));
/*     */     
/*     */     }
/*  53 */     else if (var6 == 2) {
/*     */       
/*  55 */       par1World.spawnParticle("fireworksSpark", var7 + var15, var9 + var13, var11, ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 8.0F), (par1World.rand.nextFloat() / 8.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 8.0F));
/*     */       
/*  57 */       par1World.spawnParticle("flame", var7 + var15, var9 + var13, var11, ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 60.0F), (par1World.rand.nextFloat() / 10.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 60.0F));
/*     */     
/*     */     }
/*  60 */     else if (var6 == 3) {
/*     */       
/*  62 */       par1World.spawnParticle("fireworksSpark", var7, var9 + var13, var11 - var15, ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 8.0F), (par1World.rand.nextFloat() / 8.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 8.0F));
/*     */       
/*  64 */       par1World.spawnParticle("flame", var7, var9 + var13, var11 - var15, ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 60.0F), (par1World.rand.nextFloat() / 10.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 60.0F));
/*     */     
/*     */     }
/*  67 */     else if (var6 == 4) {
/*     */       
/*  69 */       par1World.spawnParticle("fireworksSpark", var7, var9 + var13, var11 + var15, ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 8.0F), (par1World.rand.nextFloat() / 8.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 8.0F));
/*     */       
/*  71 */       par1World.spawnParticle("flame", var7, var9 + var13, var11 + var15, ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 60.0F), (par1World.rand.nextFloat() / 10.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 60.0F));
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  76 */       par1World.spawnParticle("fireworksSpark", var7, var9, var11, ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 8.0F), (par1World.rand.nextFloat() / 8.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 8.0F));
/*     */       
/*  78 */       par1World.spawnParticle("flame", var7, var9, var11, ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 60.0F), (par1World.rand.nextFloat() / 10.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 60.0F));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isCrystalBlock(World par1World, int par2, int par3, int par4) {
/*  85 */     Block l = par1World.getBlock(par2, par3, par4);
/*  86 */     if (l == OreSpawnMain.CrystalStone) return true; 
/*  87 */     if (l == OreSpawnMain.CrystalGrass) return true; 
/*  88 */     if (l == OreSpawnMain.MyCrystalTreeLog) return true; 
/*  89 */     if (l == OreSpawnMain.CrystalPlanksBlock) return true; 
/*  90 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isItSolidOnSide(World par1World, int par2, int par3, int par4, ForgeDirection dir, boolean tf) {
/*  95 */     if (isCrystalBlock(par1World, par2, par3, par4)) return true; 
/*  96 */     return par1World.isSideSolid(par2, par3, par4, dir, tf);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean canPlaceTorchOn(World par1World, int par2, int par3, int par4) {
/* 104 */     Block l = par1World.getBlock(par2, par3, par4);
/* 105 */     if (isCrystalBlock(par1World, par2, par3, par4)) return true;
/*     */     
/* 107 */     if (World.doesBlockHaveSolidTopSurface((IBlockAccess)par1World, par2, par3, par4))
/*     */     {
/* 109 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 113 */     return (l != null && l.canPlaceTorchOnTop(par1World, par2, par3, par4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
/* 122 */     return (isItSolidOnSide(par1World, par2 - 1, par3, par4, ForgeDirection.EAST, true) || isItSolidOnSide(par1World, par2 + 1, par3, par4, ForgeDirection.WEST, true) || isItSolidOnSide(par1World, par2, par3, par4 - 1, ForgeDirection.SOUTH, true) || isItSolidOnSide(par1World, par2, par3, par4 + 1, ForgeDirection.NORTH, true) || canPlaceTorchOn(par1World, par2, par3 - 1, par4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
/* 134 */     int j1 = par9;
/*     */     
/* 136 */     if (par5 == 1 && canPlaceTorchOn(par1World, par2, par3 - 1, par4))
/*     */     {
/* 138 */       j1 = 5;
/*     */     }
/*     */     
/* 141 */     if (par5 == 2 && (par1World.isSideSolid(par2, par3, par4 + 1, ForgeDirection.NORTH, true) || isCrystalBlock(par1World, par2, par3, par4 + 1)))
/*     */     {
/* 143 */       j1 = 4;
/*     */     }
/*     */     
/* 146 */     if (par5 == 3 && (par1World.isSideSolid(par2, par3, par4 - 1, ForgeDirection.SOUTH, true) || isCrystalBlock(par1World, par2, par3, par4 - 1)))
/*     */     {
/* 148 */       j1 = 3;
/*     */     }
/*     */     
/* 151 */     if (par5 == 4 && (par1World.isSideSolid(par2 + 1, par3, par4, ForgeDirection.WEST, true) || isCrystalBlock(par1World, par2 + 1, par3, par4)))
/*     */     {
/* 153 */       j1 = 2;
/*     */     }
/*     */     
/* 156 */     if (par5 == 5 && (par1World.isSideSolid(par2 - 1, par3, par4, ForgeDirection.EAST, true) || isCrystalBlock(par1World, par2 - 1, par3, par4)))
/*     */     {
/* 158 */       j1 = 1;
/*     */     }
/*     */     
/* 161 */     return j1;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 167 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BlockCrystalTorch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */