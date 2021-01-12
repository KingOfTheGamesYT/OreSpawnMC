/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockUranium
/*    */   extends Block
/*    */ {
/*    */   public BlockUranium(int par1) {
/* 18 */     super(Material.rock);
/* 19 */     setHardness(5.0F);
/* 20 */     setResistance(5.0F);
/* 21 */     setCreativeTab(CreativeTabs.tabBlock);
/*    */     
/* 23 */     setLightLevel(0.2F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int tickRate() {
/* 32 */     return 100;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/* 41 */     if (par1World.rand.nextInt(20) == 0) {
/* 42 */       sparkle(par1World, par2, par3, par4);
/*    */     }
/*    */   }
/*    */   
/*    */   private void sparkle(World par1World, int par2, int par3, int par4) {
/* 47 */     Random var5 = par1World.rand;
/* 48 */     double var6 = 0.0625D;
/*    */     
/* 50 */     for (int var8 = 0; var8 < 6; var8++) {
/*    */       
/* 52 */       double var9 = (par2 + var5.nextFloat());
/* 53 */       double var11 = (par3 + var5.nextFloat());
/* 54 */       double var13 = (par4 + var5.nextFloat());
/*    */       
/* 56 */       if (var8 == 0 && !par1World.getBlock(par2, par3 + 1, par4).isOpaqueCube())
/*    */       {
/* 58 */         var11 = (par3 + 1) + var6;
/*    */       }
/*    */       
/* 61 */       if (var8 == 1 && !par1World.getBlock(par2, par3 - 1, par4).isOpaqueCube())
/*    */       {
/* 63 */         var11 = (par3 + 0) - var6;
/*    */       }
/*    */       
/* 66 */       if (var8 == 2 && !par1World.getBlock(par2, par3, par4 + 1).isOpaqueCube())
/*    */       {
/* 68 */         var13 = (par4 + 1) + var6;
/*    */       }
/*    */       
/* 71 */       if (var8 == 3 && !par1World.getBlock(par2, par3, par4 - 1).isOpaqueCube())
/*    */       {
/* 73 */         var13 = (par4 + 0) - var6;
/*    */       }
/*    */       
/* 76 */       if (var8 == 4 && !par1World.getBlock(par2 + 1, par3, par4).isOpaqueCube())
/*    */       {
/* 78 */         var9 = (par2 + 1) + var6;
/*    */       }
/*    */       
/* 81 */       if (var8 == 5 && !par1World.getBlock(par2 - 1, par3, par4).isOpaqueCube())
/*    */       {
/* 83 */         var9 = (par2 + 0) - var6;
/*    */       }
/*    */       
/* 86 */       if (var9 < par2 || var9 > (par2 + 1) || var11 < 0.0D || var11 > (par3 + 1) || var13 < par4 || var13 > (par4 + 1)) {
/*    */         
/* 88 */         int which = par1World.rand.nextInt(3);
/* 89 */         if (which == 0) par1World.spawnParticle("flame", var9, var11, var13, 0.0D, 0.0D, 0.0D); 
/* 90 */         if (which == 1) par1World.spawnParticle("smoke", var9, var11, var13, 0.0D, 0.0D, 0.0D); 
/* 91 */         if (which == 2) par1World.spawnParticle("reddust", var9, var11, var13, 0.0D, 0.0D, 0.0D);
/*    */       
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 99 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BlockUranium.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */