/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrystalWood
/*    */   extends Block
/*    */ {
/*    */   public CrystalWood(int par1, float f1, float f2) {
/* 22 */     super(Material.wood);
/* 23 */     setCreativeTab(CreativeTabs.tabBlock);
/* 24 */     setTickRandomly(false);
/* 25 */     setHardness(f1);
/* 26 */     setResistance(f2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon getIcon(int par1, int par2) {
/* 37 */     return this.blockIcon;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isOpaqueCube() {
/* 46 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean renderAsNormalBlock() {
/* 54 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 61 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CrystalWood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */