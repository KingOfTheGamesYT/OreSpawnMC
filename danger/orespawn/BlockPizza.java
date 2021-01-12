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
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BlockPizza
/*     */   extends Block
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon pizzaTopIcon;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon pizzaBottomIcon;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_94382_c;
/*     */   
/*     */   protected BlockPizza(int par1) {
/*  28 */     super(Material.cake);
/*  29 */     setTickRandomly(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/*  37 */     int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
/*  38 */     float f = 0.0625F;
/*  39 */     float f1 = (1 + l * 2) / 16.0F;
/*  40 */     float f2 = 0.25F;
/*  41 */     setBlockBounds(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlockBoundsForItemRender() {
/*  49 */     float f = 0.0625F;
/*  50 */     float f1 = 0.25F;
/*  51 */     setBlockBounds(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
/*  60 */     int l = par1World.getBlockMetadata(par2, par3, par4);
/*  61 */     float f = 0.0625F;
/*  62 */     float f1 = (1 + l * 2) / 16.0F;
/*  63 */     float f2 = 0.25F;
/*  64 */     return AxisAlignedBB.getBoundingBox((par2 + f1), par3, (par4 + f), ((par2 + 1) - f), (par3 + f2 - f), ((par4 + 1) - f));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderAsNormalBlock() {
/*  72 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
/*  82 */     int l = par1World.getBlockMetadata(par2, par3, par4);
/*  83 */     float f = 0.0625F;
/*  84 */     float f1 = (1 + l * 2) / 16.0F;
/*  85 */     float f2 = 0.25F;
/*  86 */     return AxisAlignedBB.getBoundingBox((par2 + f1), par3, (par4 + f), ((par2 + 1) - f), (par3 + f2), ((par4 + 1) - f));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2) {
/*  96 */     return (par1 == 1) ? this.pizzaTopIcon : ((par1 == 0) ? this.pizzaBottomIcon : ((par2 > 0 && par1 == 4) ? this.field_94382_c : this.blockIcon));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister par1IIconRegister) {
/* 107 */     this.blockIcon = par1IIconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + "_side");
/* 108 */     this.field_94382_c = par1IIconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + "_inner");
/* 109 */     this.pizzaTopIcon = par1IIconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + "_top");
/* 110 */     this.pizzaBottomIcon = par1IIconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + "_bottom");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube() {
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
/* 127 */     eatPizzaSlice(par1World, par2, par3, par4, par5EntityPlayer);
/* 128 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
/* 136 */     eatPizzaSlice(par1World, par2, par3, par4, par5EntityPlayer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void eatPizzaSlice(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
/* 144 */     if (par5EntityPlayer.canEat(false)) {
/*     */       
/* 146 */       par5EntityPlayer.getFoodStats().addStats(4, 0.2F);
/* 147 */       int l = par1World.getBlockMetadata(par2, par3, par4) + 1;
/*     */       
/* 149 */       if (l >= 6) {
/*     */         
/* 151 */         par1World.setBlockToAir(par2, par3, par4);
/*     */       }
/*     */       else {
/*     */         
/* 155 */         par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
/* 165 */     return !super.canPlaceBlockAt(par1World, par2, par3, par4) ? false : canBlockStay(par1World, par2, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
/* 174 */     if (!canBlockStay(par1World, par2, par3, par4))
/*     */     {
/* 176 */       par1World.setBlockToAir(par2, par3, par4);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
/* 185 */     return par1World.getBlock(par2, par3 - 1, par4).isNormalCube();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int quantityDropped(Random par1Random) {
/* 193 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item getItemDropped(int par1, Random par2Random, int par3) {
/* 198 */     return OreSpawnMain.MyPizzaItem;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BlockPizza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */