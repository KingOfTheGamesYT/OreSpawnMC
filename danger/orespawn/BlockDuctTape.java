/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BlockDuctTape
/*     */   extends Block
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon DuctTapeTopIcon;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon DuctTapeBottomIcon;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_94382_c;
/*     */   
/*     */   protected BlockDuctTape(int par1) {
/*  29 */     super(Material.anvil);
/*  30 */     setTickRandomly(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/*  38 */     int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
/*  39 */     float f = 0.0625F;
/*  40 */     float f1 = (1 + l * 2) / 16.0F;
/*  41 */     float f2 = 0.25F;
/*  42 */     setBlockBounds(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlockBoundsForItemRender() {
/*  50 */     float f = 0.0625F;
/*  51 */     float f1 = 0.25F;
/*  52 */     setBlockBounds(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
/*  61 */     int l = par1World.getBlockMetadata(par2, par3, par4);
/*  62 */     float f = 0.0625F;
/*  63 */     float f1 = (1 + l * 2) / 16.0F;
/*  64 */     float f2 = 0.25F;
/*  65 */     return AxisAlignedBB.getBoundingBox((par2 + f1), par3, (par4 + f), ((par2 + 1) - f), (par3 + f2 - f), ((par4 + 1) - f));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderAsNormalBlock() {
/*  73 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
/*  83 */     int l = par1World.getBlockMetadata(par2, par3, par4);
/*  84 */     float f = 0.0625F;
/*  85 */     float f1 = (1 + l * 2) / 16.0F;
/*  86 */     float f2 = 0.25F;
/*  87 */     return AxisAlignedBB.getBoundingBox((par2 + f1), par3, (par4 + f), ((par2 + 1) - f), (par3 + f2), ((par4 + 1) - f));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2) {
/*  97 */     return (par1 == 1) ? this.DuctTapeTopIcon : ((par1 == 0) ? this.DuctTapeBottomIcon : ((par2 > 0 && par1 == 4) ? this.field_94382_c : this.blockIcon));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister par1IconRegister) {
/* 108 */     this.blockIcon = par1IconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + "_side");
/* 109 */     this.field_94382_c = par1IconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + "_inner");
/* 110 */     this.DuctTapeTopIcon = par1IconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + "_top");
/* 111 */     this.DuctTapeBottomIcon = par1IconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + "_bottom");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube() {
/* 120 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
/* 128 */     eatDuctTapeSlice(par1World, par2, par3, par4, par5EntityPlayer);
/* 129 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
/* 137 */     eatDuctTapeSlice(par1World, par2, par3, par4, par5EntityPlayer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void eatDuctTapeSlice(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
/* 145 */     if (par5EntityPlayer != null) {
/*     */       
/* 147 */       ItemStack var2 = par5EntityPlayer.inventory.getCurrentItem();
/* 148 */       if (var2 != null && 
/* 149 */         var2.stackSize == 1) {
/* 150 */         int cd = var2.getMaxDamage();
/* 151 */         int fd = 0;
/* 152 */         if (cd > 0) {
/* 153 */           cd /= 6;
/* 154 */           if (cd < 1) cd = 1; 
/* 155 */           fd = var2.getItemDamage();
/* 156 */           if (fd > 0) {
/* 157 */             if (fd > cd) {
/* 158 */               fd -= cd;
/*     */             } else {
/* 160 */               fd = 0;
/*     */             } 
/* 162 */             var2.setItemDamage(fd);
/*     */             
/* 164 */             int l = par1World.getBlockMetadata(par2, par3, par4) + 1;
/* 165 */             if (l >= 6) {
/* 166 */               par1World.setBlockToAir(par2, par3, par4);
/*     */             } else {
/* 168 */               par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
/* 182 */     return !super.canPlaceBlockAt(par1World, par2, par3, par4) ? false : canBlockStay(par1World, par2, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
/* 191 */     if (!canBlockStay(par1World, par2, par3, par4))
/*     */     {
/* 193 */       par1World.setBlockToAir(par2, par3, par4);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
/* 202 */     return par1World.getBlock(par2, par3 - 1, par4).getMaterial().isSolid();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int quantityDropped(Random par1Random) {
/* 210 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 218 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 230 */     return OreSpawnMain.MyDuctTapeItem;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BlockDuctTape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */