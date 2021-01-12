/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockLeaves;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockCrystalLeaves
/*     */   extends BlockLeaves
/*     */ {
/*     */   protected BlockCrystalLeaves(int par1) {
/*  34 */     setTickRandomly(true);
/*     */     
/*  36 */     setCreativeTab(CreativeTabs.tabDecorations);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> par3List) {
/*  44 */     par3List.add(new ItemStack(Item.getItemFromBlock((Block)this), 1, 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
/*  53 */     if (!par1World.isRemote) {
/*     */       
/*  55 */       if (par1World.rand.nextInt(100) == 1)
/*     */       {
/*  57 */         dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCrystalApple));
/*     */       }
/*  59 */       if (par1World.rand.nextInt(50) == 1) {
/*     */         
/*  61 */         if (this == OreSpawnMain.MyCrystalLeaves) dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCrystalPlant)); 
/*  62 */         if (this == OreSpawnMain.MyCrystalLeaves2) dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCrystalPlant2)); 
/*  63 */         if (this == OreSpawnMain.MyCrystalLeaves3) dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCrystalPlant3));
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int quantityDropped(Random par1Random) {
/*  74 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  84 */     int var7 = 2;
/*     */ 
/*     */     
/*  87 */     int totaldist = 0;
/*  88 */     int chance = 20;
/*     */     
/*  90 */     if (par1World.provider.dimensionId == OreSpawnMain.DimensionID4) {
/*  91 */       chance = 100;
/*  92 */       var7 = 1;
/*     */     } 
/*     */     
/*  95 */     if (!par1World.isRemote && par1World.checkChunksExist(par2 - var7, par3 - var7, par4 - var7, par2 + var7, par3 + var7, par4 + var7)) {
/*     */       
/*  97 */       for (int var12 = -var7; var12 <= var7; var12++) {
/*     */         
/*  99 */         for (int var13 = -var7; var13 <= 0; var13++) {
/*     */           
/* 101 */           for (int var14 = -var7; var14 <= var7; var14++) {
/*     */             
/* 103 */             totaldist = Math.abs(var12) + Math.abs(var13) + Math.abs(var14);
/* 104 */             if (totaldist <= 3) {
/* 105 */               Block bid = par1World.getBlock(par2 + var12, par3 + var13, par4 + var14);
/*     */               
/* 107 */               if (bid != null && bid.canSustainLeaves((IBlockAccess)par1World, par2 + var12, par3 + var13, par4 + var14)) {
/*     */ 
/*     */                 
/* 110 */                 bid = par1World.getBlock(par2, par3 - 1, par4);
/* 111 */                 if (bid == Blocks.air)
/*     */                 {
/* 113 */                   if (par1World.rand.nextInt(chance) == 3)
/*     */                   {
/* 115 */                     dropBlockAsItemWithChance(par1World, par2, par3 - 1, par4, 0, 0.0F, 0);
/*     */                   }
/*     */                 }
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 124 */       removeLeaves(par1World, par2, par3, par4);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void removeLeaves(World par1World, int par2, int par3, int par4) {
/* 130 */     dropBlockAsItem(par1World, par2, par3, par4, 0, 0);
/* 131 */     par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube() {
/* 140 */     if (OreSpawnMain.FastGraphicsLeaves != 0) return true; 
/* 141 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderAsNormalBlock() {
/* 149 */     if (OreSpawnMain.FastGraphicsLeaves != 0) return true; 
/* 150 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderType() {
/* 158 */     if (OreSpawnMain.FastGraphicsLeaves != 0) return super.getRenderType(); 
/* 159 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
/* 169 */     Block i1 = par1IBlockAccess.getBlock(par2, par3, par4);
/* 170 */     return !(OreSpawnMain.FastGraphicsLeaves != 0 && i1 == this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getBlockColor() {
/* 177 */     return 14540253;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getRenderColor(int par1) {
/* 187 */     return 14540253;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 198 */     return 14540253;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2) {
/* 207 */     return this.blockIcon;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 214 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] func_150125_e() {
/* 220 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BlockCrystalLeaves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */