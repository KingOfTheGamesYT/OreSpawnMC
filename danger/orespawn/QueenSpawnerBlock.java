/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockReed;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QueenSpawnerBlock
/*     */   extends BlockReed
/*     */ {
/*     */   protected QueenSpawnerBlock(int par1) {
/*  26 */     float var3 = 0.375F;
/*  27 */     setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
/*  28 */     setTickRandomly(true);
/*  29 */     setCreativeTab(CreativeTabs.tabDecorations);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
/*  38 */     if (par1World.getBlock(par2, par3 - 1, par4).getMaterial().isSolid()) return true; 
/*  39 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  44 */     if (!par1World.isRemote) {
/*  45 */       updateTick(par1World, par2, par3, par4, par5Random);
/*     */       return;
/*     */     } 
/*  48 */     if (par1World.rand.nextInt(20) != 1)
/*     */       return; 
/*  50 */     for (int j1 = 0; j1 < 20; j1++)
/*     */     {
/*     */       
/*  53 */       par1World.spawnParticle("fireworksSpark", (par2 + par1World.rand.nextFloat()), par3 + par1World.rand.nextFloat(), (par4 + par1World.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockAdded(World world, int x, int y, int z) {
/*  61 */     if (world.isRemote)
/*  62 */       return;  world.scheduleBlockUpdate(x, y, z, (Block)this, 100);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
/*  71 */     updateTick(par1World, par2, par3, par4, (Random)null);
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
/*  82 */     if (par1World.isRemote)
/*     */       return; 
/*  84 */     if (OreSpawnMain.TheQueenEnable != 0) { this; spawnTheQueen(par1World, par2, (par3 + 8), par4); }
/*     */     
/*  86 */     par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
/*  87 */     par1World.setBlock(par2, par3 + 1, par4, Blocks.air, 0, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getItemDropped(int par1, Random par2Random, int par3) {
/*  95 */     return Item.getItemFromBlock(OreSpawnMain.MyQueenSpawnerBlock);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int quantityDropped(Random par1Random) {
/* 103 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnTheQueen(World par0World, double par2, double par4, double par6) {
/* 113 */     Entity var8 = null;
/*     */ 
/*     */     
/* 116 */     var8 = EntityList.createEntityByName("The Queen", par0World);
/*     */     
/* 118 */     if (var8 != null) {
/*     */ 
/*     */       
/* 121 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 124 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 126 */       ((EntityLiving)var8).playLivingSound();
/* 127 */       ((TheQueen)var8).setGuardMode(1);
/*     */     } 
/*     */     
/* 130 */     return var8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
/* 138 */     updateTick(par1World, par2, par3, par4, (Random)null);
/* 139 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 146 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\QueenSpawnerBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */