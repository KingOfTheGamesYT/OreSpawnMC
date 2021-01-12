/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
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
/*    */ public class OreRuby
/*    */   extends Block
/*    */ {
/*    */   public OreRuby(int i) {
/* 25 */     super(Material.rock);
/* 26 */     setHardness(10.0F);
/* 27 */     setResistance(4.0F);
/* 28 */     setCreativeTab(CreativeTabs.tabBlock);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
/* 36 */     super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
/* 37 */     int j1 = 5 + par1World.rand.nextInt(5) + par1World.rand.nextInt(5);
/* 38 */     dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Item getItemDropped(int par1, Random par2Random, int par3) {
/* 46 */     return OreSpawnMain.MyRuby;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int quantityDroppedWithBonus(int par1, Random par2Random) {
/* 52 */     return 1 + par2Random.nextInt(2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int quantityDropped(Random par1Random) {
/* 60 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 66 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\OreRuby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */