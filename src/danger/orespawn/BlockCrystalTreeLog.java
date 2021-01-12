/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockRotatedPillar;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockCrystalTreeLog
/*     */   extends BlockRotatedPillar
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_111052_c;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon tree_top;
/*     */   
/*     */   protected BlockCrystalTreeLog(int par1, int par2) {
/*  30 */     super(Material.wood);
/*  31 */     setCreativeTab(CreativeTabs.tabBlock);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ItemStack createStackedBlock(int par1) {
/*  42 */     return new ItemStack(Item.getItemFromBlock((Block)this), 1, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
/*  47 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWood(IBlockAccess world, int x, int y, int z) {
/*  52 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube() {
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderAsNormalBlock() {
/*  69 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  78 */     return Item.getItemFromBlock(OreSpawnMain.MyCrystalTreeLog);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected IIcon getSideIcon(int par1) {
/*  88 */     return this.field_111052_c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected IIcon getTopIcon(int par1) {
/*  98 */     return this.tree_top;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 103 */     this.field_111052_c = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/* 104 */     this.tree_top = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + "_top");
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BlockCrystalTreeLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */