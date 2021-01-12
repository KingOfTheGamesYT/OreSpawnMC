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
/*     */ public class IslandBlock
/*     */   extends BlockReed
/*     */ {
/*     */   protected IslandBlock(int par1) {
/*  25 */     float var3 = 0.375F;
/*  26 */     setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
/*  27 */     setTickRandomly(true);
/*  28 */     setCreativeTab(CreativeTabs.tabDecorations);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
/*  37 */     if (par1World.getBlock(par2, par3 - 1, par4).getMaterial().isSolid()) return true; 
/*  38 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  43 */     if (par1World.rand.nextInt(20) != 1)
/*     */       return; 
/*  45 */     for (int j1 = 0; j1 < 20; j1++)
/*     */     {
/*     */       
/*  48 */       par1World.spawnParticle("happyVillager", (par2 + par1World.rand.nextFloat()), par3 + par1World.rand.nextFloat(), (par4 + par1World.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
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
/*     */   
/*     */   public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  61 */     int isok = 1;
/*  62 */     if (par1World.isRemote) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     int n = 1 + par1World.rand.nextInt(3);
/*  70 */     int m = 64;
/*  71 */     if (OreSpawnMain.IslandSizeFactor == 2) m = 55; 
/*  72 */     if (OreSpawnMain.IslandSizeFactor == 1) m = 45;
/*     */     
/*  74 */     for (int i = 0; i < n; i++) {
/*  75 */       int height = 12 + par1World.rand.nextInt(m);
/*  76 */       isok = 1;
/*  77 */       for (int k = -10; k <= 10; k++) {
/*     */         
/*  79 */         for (int j = -10; j <= 10; j++) {
/*     */           
/*  81 */           Block bid = par1World.getBlock(par2 + j, par3 + height, par4 + k);
/*  82 */           if (bid != Blocks.air) {
/*  83 */             isok = 0;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*  89 */       if (isok != 0) {
/*  90 */         if (par1World.rand.nextInt(25) == 1) {
/*  91 */           this; spawnCreature(par1World, "Island", par2, (par3 + height), par4);
/*     */         } else {
/*  93 */           this; spawnCreature(par1World, "IslandToo", par2, (par3 + height), par4);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/*  98 */     par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
/*  99 */     par1World.setBlock(par2, par3 + 1, par4, Blocks.air, 0, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getItemDropped(int par1, Random par2Random, int par3) {
/* 107 */     return Item.getItemFromBlock(OreSpawnMain.MyIslandBlock);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int quantityDropped(Random par1Random) {
/* 115 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 125 */     Entity var8 = null;
/*     */ 
/*     */     
/* 128 */     var8 = EntityList.createEntityByName(par1, par0World);
/*     */     
/* 130 */     if (var8 != null) {
/*     */ 
/*     */       
/* 133 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 136 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 138 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     
/* 141 */     return var8;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 148 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\IslandBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */