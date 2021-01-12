/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OreCrystal
/*     */   extends Block
/*     */ {
/*     */   public OreCrystal(int par1, float lv, float f1, float f2) {
/*  22 */     super(Material.rock);
/*  23 */     setHardness(f1);
/*  24 */     setResistance(f2);
/*  25 */     setCreativeTab(CreativeTabs.tabBlock);
/*  26 */     setLightLevel(lv);
/*  27 */     setTickRandomly(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  36 */     if (par1World.rand.nextInt(5) == 0) {
/*  37 */       sparkle(par1World, par2, par3, par4);
/*     */     }
/*     */   }
/*     */   
/*     */   private void sparkle(World par1World, int par2, int par3, int par4) {
/*  42 */     int which = 0;
/*  43 */     float dx = 0.5F;
/*  44 */     float dz = 0.5F;
/*  45 */     float dy = 0.5F;
/*     */     
/*  47 */     for (int j1 = 0; j1 < 5; j1++) {
/*     */       
/*  49 */       which = par1World.rand.nextInt(3);
/*  50 */       if (which == 0) par1World.spawnParticle("flame", (par2 + dx), par3 + dy, (par4 + dz), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0F));
/*     */       
/*  52 */       if (which == 1) par1World.spawnParticle("smoke", (par2 + dx), par3 + dy, (par4 + dz), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0F));
/*     */       
/*  54 */       if (which == 2) par1World.spawnParticle("reddust", (par2 + dx), par3 + dy, (par4 + dz), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0F), ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0F));
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderType() {
/*  62 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube() {
/*  71 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderAsNormalBlock() {
/*  79 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
/*  87 */     if (!par1World.isRemote && par1World.rand.nextInt(3) == 1)
/*     */     {
/*  89 */       par1World.newExplosion((Entity)null, (par2 + 0.5F), (par3 + 0.5F), (par4 + 0.5F), 1.5F, true, par1World.getGameRules().getGameRuleBooleanValue("mobGriefing"));
/*     */     }
/*     */ 
/*     */     
/*  93 */     super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
/* 101 */     super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
/* 102 */     int j1 = 5 + par1World.rand.nextInt(5) + par1World.rand.nextInt(10);
/* 103 */     if (par3 < 40) {
/* 104 */       dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 110 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\OreCrystal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */