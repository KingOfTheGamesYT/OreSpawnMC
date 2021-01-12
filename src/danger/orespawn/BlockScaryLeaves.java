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
/*     */ public class BlockScaryLeaves
/*     */   extends BlockLeaves
/*     */ {
/*  24 */   private IIcon scary_solid = null;
/*  25 */   private IIcon generic_solid = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BlockScaryLeaves(int par1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> par3List) {
/*  38 */     par3List.add(new ItemStack(Item.getItemFromBlock((Block)this), 1, 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
/*  46 */     if (!par1World.isRemote)
/*     */     {
/*  48 */       if (par1World.rand.nextInt(25) == 1) {
/*     */         
/*  50 */         if (this == OreSpawnMain.MyCherryLeaves) dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCherry)); 
/*  51 */         if (this == OreSpawnMain.MyPeachLeaves) dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyPeach));
/*     */       
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int quantityDropped(Random par1Random) {
/*  61 */     if (this == OreSpawnMain.MyCherryLeaves) return par1Random.nextInt(4); 
/*  62 */     if (this == OreSpawnMain.MyPeachLeaves) return par1Random.nextInt(1); 
/*  63 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  73 */     int var7 = 2;
/*     */ 
/*     */     
/*  76 */     int totaldist = 0;
/*     */     
/*  78 */     if (!par1World.isRemote && par1World.checkChunksExist(par2 - var7, par3 - var7, par4 - var7, par2 + var7, par3 + var7, par4 + var7)) {
/*     */       
/*  80 */       for (int var12 = -var7; var12 <= var7; var12++) {
/*     */         
/*  82 */         for (int var13 = -var7; var13 <= 0; var13++) {
/*     */           
/*  84 */           for (int var14 = -var7; var14 <= var7; var14++) {
/*     */             
/*  86 */             totaldist = Math.abs(var12) + Math.abs(var13) + Math.abs(var14);
/*  87 */             if (totaldist <= 3) {
/*  88 */               Block bid = par1World.getBlock(par2 + var12, par3 + var13, par4 + var14);
/*     */               
/*  90 */               if (bid != null && bid.canSustainLeaves((IBlockAccess)par1World, par2 + var12, par3 + var13, par4 + var14)) {
/*     */ 
/*     */                 
/*  93 */                 long t = par1World.getWorldTime();
/*  94 */                 t %= 24000L;
/*     */                 
/*  96 */                 if (this == OreSpawnMain.MyScaryLeaves && t < 12000L)
/*     */                 {
/*  98 */                   OreSpawnMain.setBlockFast(par1World, par2, par3, par4, OreSpawnMain.MyAppleLeaves, 0, 3);
/*     */                 }
/*     */                 
/* 101 */                 bid = par1World.getBlock(par2, par3 - 1, par4);
/* 102 */                 if (bid == Blocks.air)
/*     */                 {
/* 104 */                   if (par1World.rand.nextInt(20) == 3)
/*     */                   {
/* 106 */                     dropBlockAsItemWithChance(par1World, par2, par3 - 1, par4, 0, 0.0F, 0);
/*     */                   }
/*     */                 }
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 115 */       removeLeaves(par1World, par2, par3, par4);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeLeaves(World par1World, int par2, int par3, int par4) {
/* 128 */     dropBlockAsItem(par1World, par2, par3, par4, 0, 0);
/* 129 */     par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube() {
/* 138 */     if (OreSpawnMain.FastGraphicsLeaves != 0) return true; 
/* 139 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
/* 149 */     Block i1 = par1IBlockAccess.getBlock(par2, par3, par4);
/* 150 */     return !(OreSpawnMain.FastGraphicsLeaves != 0 && i1 == this);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 156 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/* 157 */     this.generic_solid = iconRegister.registerIcon("OreSpawn:generic_solid");
/* 158 */     this.scary_solid = iconRegister.registerIcon("OreSpawn:scary_solid");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2) {
/* 167 */     if (OreSpawnMain.FastGraphicsLeaves != 0) {
/* 168 */       if (this == OreSpawnMain.MyCherryLeaves) return this.generic_solid; 
/* 169 */       if (this == OreSpawnMain.MyPeachLeaves) return this.generic_solid; 
/* 170 */       return this.scary_solid;
/*     */     } 
/* 172 */     return this.blockIcon;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] func_150125_e() {
/* 178 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BlockScaryLeaves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */