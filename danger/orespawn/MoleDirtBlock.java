/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.AxisAlignedBB;
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
/*    */ 
/*    */ public class MoleDirtBlock
/*    */   extends Block
/*    */ {
/*    */   public MoleDirtBlock(int i) {
/* 28 */     super(Material.ground);
/* 29 */     setCreativeTab(CreativeTabs.tabBlock);
/* 30 */     setTickRandomly(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/* 35 */     if (par1World.isRemote)
/* 36 */       return;  par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
/*    */   }
/*    */ 
/*    */   
/*    */   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
/* 41 */     float f = 0.125F;
/* 42 */     return AxisAlignedBB.getBoundingBox(par2, par3, par4, (par2 + 1), ((par3 + 1) - f), (par4 + 1));
/*    */   }
/*    */ 
/*    */   
/*    */   public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
/* 47 */     if (par5Entity != null) {
/* 48 */       par5Entity.motionX *= 0.3D;
/* 49 */       par5Entity.motionZ *= 0.3D;
/*    */     } 
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 55 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MoleDirtBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */