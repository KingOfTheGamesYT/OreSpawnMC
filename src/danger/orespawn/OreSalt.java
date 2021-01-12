/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OreSalt
/*    */   extends Block
/*    */ {
/*    */   public OreSalt(int par1) {
/* 20 */     super(Material.rock);
/* 21 */     setHardness(5.0F);
/* 22 */     setResistance(2.0F);
/* 23 */     setCreativeTab(CreativeTabs.tabBlock);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
/* 32 */     if (par5Entity instanceof EntityAnt) {
/* 33 */       par5Entity.attackEntityFrom(DamageSource.cactus, 5.0F);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
/* 42 */     if (par5Entity instanceof EntityAnt) {
/* 43 */       par5Entity.attackEntityFrom(DamageSource.cactus, 5.0F);
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 49 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\OreSalt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */