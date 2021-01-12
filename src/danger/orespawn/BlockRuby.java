/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockRuby
/*    */   extends Block
/*    */ {
/*    */   public BlockRuby(int par1) {
/* 22 */     super(Material.rock);
/* 23 */     setHardness(4.0F);
/* 24 */     setResistance(4.0F);
/* 25 */     setCreativeTab(CreativeTabs.tabBlock);
/* 26 */     setLightLevel(0.4F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isOpaqueCube() {
/* 35 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean renderAsNormalBlock() {
/* 43 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
/* 51 */     if (this == OreSpawnMain.MyBlockMobzillaScaleBlock && par5Entity instanceof EntityLivingBase) {
/* 52 */       ((EntityLivingBase)par5Entity).addPotionEffect(new PotionEffect(Potion.damageBoost.id, 200, 0));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
/* 62 */     if (this == OreSpawnMain.MyBlockMobzillaScaleBlock && par5Entity instanceof EntityLivingBase) {
/* 63 */       ((EntityLivingBase)par5Entity).addPotionEffect(new PotionEffect(Potion.damageBoost.id, 200, 0));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 70 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BlockRuby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */