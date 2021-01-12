/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.BlockWorkbench;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrystalWorkbench
/*    */   extends BlockWorkbench
/*    */ {
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon workbenchIconTop;
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon workbenchIconFront;
/*    */   
/*    */   protected CrystalWorkbench(int par1, float f1, float f2) {
/* 24 */     setCreativeTab(CreativeTabs.tabDecorations);
/* 25 */     setHardness(f1);
/* 26 */     setResistance(f2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
/* 35 */     if (par1World.isRemote)
/*    */     {
/* 37 */       return true;
/*    */     }
/*    */ 
/*    */     
/* 41 */     par5EntityPlayer.openGui(OreSpawnMain.instance, 1, par1World, par2, par3, par4);
/* 42 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isOpaqueCube() {
/* 52 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean renderAsNormalBlock() {
/* 60 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon getIcon(int par1, int par2) {
/* 72 */     return (par1 == 1) ? this.workbenchIconTop : ((par1 == 0) ? this.blockIcon : ((par1 != 2 && par1 != 4) ? this.blockIcon : this.workbenchIconFront));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerBlockIcons(IIconRegister par1IIconRegister) {
/* 83 */     this.blockIcon = par1IIconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + "_side");
/* 84 */     this.workbenchIconTop = par1IIconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + "_top");
/* 85 */     this.workbenchIconFront = par1IIconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + "_bottom");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CrystalWorkbench.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */