/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OreGenericEgg
/*    */   extends Block
/*    */ {
/*    */   public OreGenericEgg(int oldid) {
/* 23 */     super(Material.ground);
/* 24 */     setHardness(0.5F);
/* 25 */     setResistance(1.0F);
/* 26 */     setStepSound(Block.soundTypeGravel);
/* 27 */     setCreativeTab(CreativeTabs.tabBlock);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
/* 35 */     super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
/* 36 */     int j1 = 5 + par1World.rand.nextInt(3) + par1World.rand.nextInt(3);
/* 37 */     if (par1World.rand.nextInt(2) == 1) {
/* 38 */       dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isOpaqueCube() {
/* 47 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean renderAsNormalBlock() {
/* 55 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 61 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\OreGenericEgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */