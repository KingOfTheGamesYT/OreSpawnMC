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
/*     */ public class BlockLettuce
/*     */   extends BlockReed
/*     */ {
/*     */   protected BlockLettuce(int par1) {
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
/*  40 */     if (bid == OreSpawnMain.MyLettucePlant1 || bid == OreSpawnMain.MyLettucePlant2 || bid == OreSpawnMain.MyLettucePlant3 || bid == OreSpawnMain.MyLettucePlant4 || bid == Blocks.grass || bid == Blocks.dirt || bid == Blocks.farmland)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/*  45 */       return true;
/*     */     }
/*  47 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  59 */     int dontGrow = 0;
/*     */     
/*  61 */     if (par1World.isRemote) {
/*     */       return;
/*     */     }
/*  64 */     int var7 = par1World.getBlockMetadata(par2, par3, par4);
/*     */     
/*  66 */     var7 &= 0xFF;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  71 */     if (var7 >= 4) {
/*     */ 
/*     */ 
/*     */       
/*  75 */       Block bid = par1World.getBlock(par2, par3, par4);
/*  76 */       if (bid == OreSpawnMain.MyLettucePlant1)
/*     */       {
/*  78 */         par1World.setBlock(par2, par3, par4, OreSpawnMain.MyLettucePlant2, 0, 2);
/*     */       }
/*  80 */       else if (bid == OreSpawnMain.MyLettucePlant2)
/*     */       {
/*  82 */         par1World.setBlock(par2, par3, par4, OreSpawnMain.MyLettucePlant3, 0, 2);
/*     */       }
/*  84 */       else if (bid == OreSpawnMain.MyLettucePlant3)
/*     */       {
/*  86 */         par1World.setBlock(par2, par3, par4, OreSpawnMain.MyLettucePlant4, 0, 2);
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  93 */       Block bid = par1World.getBlock(par2, par3, par4);
/*  94 */       par1World.setBlock(par2, par3, par4, bid, var7 + 1, 2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getItemDropped(int par1, Random par2Random, int par3) {
/* 104 */     return OreSpawnMain.MyLettuce;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int quantityDropped(Random par1Random) {
/* 112 */     if (this == OreSpawnMain.MyLettucePlant4)
/*     */     {
/* 114 */       return 2 + par1Random.nextInt(3);
/*     */     }
/* 116 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 123 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BlockLettuce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */