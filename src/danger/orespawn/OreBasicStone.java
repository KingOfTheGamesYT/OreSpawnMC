/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OreBasicStone
/*     */   extends Block
/*     */ {
/*     */   public OreBasicStone(int par1, float f1, float f2) {
/*  25 */     super(Material.rock);
/*  26 */     setHardness(f1);
/*  27 */     setResistance(f2);
/*  28 */     setCreativeTab(CreativeTabs.tabBlock);
/*  29 */     setTickRandomly(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
/*  38 */     if (!par1World.isRemote && this == OreSpawnMain.CrystalRat) {
/*     */ 
/*     */       
/*  41 */       int num = 1 + par1World.rand.nextInt(10);
/*  42 */       for (int i = 0; i < num; i++) {
/*  43 */         spawnCreature(par1World, 0, "Rat", par2 + 0.5D + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2D, par3 + 0.01D, par4 + 0.5D + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2D);
/*     */       }
/*     */     } 
/*     */     
/*  47 */     if (!par1World.isRemote && this == OreSpawnMain.CrystalFairy) {
/*     */ 
/*     */       
/*  50 */       int num = 1 + par1World.rand.nextInt(6);
/*  51 */       for (int i = 0; i < num; i++) {
/*  52 */         spawnCreature(par1World, 0, "Fairy", par2 + 0.5D + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2D, par3 + 0.01D, par4 + 0.5D + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2D);
/*     */       }
/*     */     } 
/*     */     
/*  56 */     if (!par1World.isRemote && this == OreSpawnMain.RedAntTroll) {
/*     */ 
/*     */       
/*  59 */       int num = 15 + par1World.rand.nextInt(6);
/*  60 */       for (int i = 0; i < num; i++) {
/*  61 */         spawnCreature(par1World, 0, "Red Ant", par2 + 0.5D + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2D, par3 + 0.01D, par4 + 0.5D + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2D);
/*     */       }
/*     */     } 
/*     */     
/*  65 */     if (!par1World.isRemote && this == OreSpawnMain.TermiteTroll) {
/*     */ 
/*     */       
/*  68 */       int num = 15 + par1World.rand.nextInt(6);
/*  69 */       for (int i = 0; i < num; i++) {
/*  70 */         spawnCreature(par1World, 0, "Termite", par2 + 0.5D + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2D, par3 + 0.01D, par4 + 0.5D + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.2D);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  75 */     super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side) {
/*  80 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube() {
/*  89 */     if (OreSpawnMain.current_dimension != OreSpawnMain.DimensionID5) return false; 
/*  90 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderAsNormalBlock() {
/*  98 */     if (OreSpawnMain.current_dimension != OreSpawnMain.DimensionID5) return false; 
/*  99 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, int par1, String name, double par2, double par4, double par6) {
/* 109 */     Entity var8 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     if (name == null) {
/* 116 */       var8 = EntityList.createEntityByID(par1, par0World);
/*     */     } else {
/* 118 */       var8 = EntityList.createEntityByName(name, par0World);
/*     */     } 
/*     */     
/* 121 */     if (var8 != null) {
/*     */ 
/*     */       
/* 124 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/* 125 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 127 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     
/* 130 */     return var8;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 136 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\OreBasicStone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */