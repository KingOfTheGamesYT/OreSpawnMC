/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockReed;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockExperiencePlant
/*     */   extends BlockReed
/*     */ {
/*     */   protected BlockExperiencePlant(int par1) {
/*  26 */     float var3 = 0.375F;
/*  27 */     setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
/*  28 */     setTickRandomly(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
/*  38 */     Block bid = par1World.getBlock(par2, par3 - 1, par4);
/*  39 */     if (bid == Blocks.air) return false; 
/*  40 */     if (bid == Blocks.grass || bid == Blocks.dirt || bid == Blocks.farmland)
/*     */     {
/*     */       
/*  43 */       return true;
/*     */     }
/*  45 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  50 */     if (par1World.rand.nextInt(20) != 1)
/*     */       return; 
/*  52 */     for (int j1 = 0; j1 < 20; j1++)
/*     */     {
/*     */       
/*  55 */       par1World.spawnParticle("happyVillager", (par2 + par1World.rand.nextFloat()), par3 + par1World.rand.nextFloat(), (par4 + par1World.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  67 */     if (par1World.isRemote)
/*     */       return; 
/*  69 */     if (par1World.rand.nextInt(10) != 1) {
/*     */       return;
/*     */     }
/*     */     
/*  73 */     par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
/*     */     
/*  75 */     OreSpawnMain.OreSpawnTrees.ExperienceTree(par1World, par2, par3 - 1, par4);
/*     */   }
/*     */ 
/*     */   
/*     */   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  80 */     return Item.getItemFromBlock(OreSpawnMain.MyExperiencePlant);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int quantityDropped(Random par1Random) {
/*  88 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int idPicked(World par1World, int par2, int par3, int par4) {
/*  96 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getSeedItem() {
/* 104 */     return OreSpawnMain.MyExperienceTreeSeed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getCropItem() {
/* 112 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 118 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BlockExperiencePlant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */