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
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OreUranium
/*     */   extends Block
/*     */ {
/*     */   private boolean glowing = false;
/*  21 */   private int glowcount = 0;
/*     */ 
/*     */   
/*     */   public OreUranium(int par1) {
/*  25 */     super(Material.rock);
/*  26 */     setHardness(10.0F);
/*  27 */     setResistance(1.0F);
/*  28 */     setCreativeTab(CreativeTabs.tabBlock);
/*  29 */     setTickRandomly(true);
/*  30 */     this.glowing = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int tickRate() {
/*  38 */     return 30;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
/*  46 */     glow(par1World, par2, par3, par4);
/*  47 */     super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
/*  55 */     glow(par1World, par2, par3, par4);
/*  56 */     super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
/*  64 */     glow(par1World, par2, par3, par4);
/*  65 */     return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void glow(World par1World, int par2, int par3, int par4) {
/*  73 */     this.glowing = true;
/*  74 */     this.glowcount = 10;
/*  75 */     sparkle(par1World, par2, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  93 */     if (this.glowing) {
/*     */       
/*  95 */       sparkle(par1World, par2, par3, par4);
/*  96 */       if (this.glowcount > 0) {
/*  97 */         this.glowcount--;
/*     */       } else {
/*  99 */         this.glowing = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sparkle(World par1World, int par2, int par3, int par4) {
/* 109 */     Random var5 = par1World.rand;
/* 110 */     double var6 = 0.0625D;
/*     */     
/* 112 */     for (int var8 = 0; var8 < 6; var8++) {
/*     */       
/* 114 */       double var9 = (par2 + var5.nextFloat());
/* 115 */       double var11 = (par3 + var5.nextFloat());
/* 116 */       double var13 = (par4 + var5.nextFloat());
/*     */       
/* 118 */       if (var8 == 0 && !par1World.getBlock(par2, par3 + 1, par4).isOpaqueCube())
/*     */       {
/* 120 */         var11 = (par3 + 1) + var6;
/*     */       }
/*     */       
/* 123 */       if (var8 == 1 && !par1World.getBlock(par2, par3 - 1, par4).isOpaqueCube())
/*     */       {
/* 125 */         var11 = (par3 + 0) - var6;
/*     */       }
/*     */       
/* 128 */       if (var8 == 2 && !par1World.getBlock(par2, par3, par4 + 1).isOpaqueCube())
/*     */       {
/* 130 */         var13 = (par4 + 1) + var6;
/*     */       }
/*     */       
/* 133 */       if (var8 == 3 && !par1World.getBlock(par2, par3, par4 - 1).isOpaqueCube())
/*     */       {
/* 135 */         var13 = (par4 + 0) - var6;
/*     */       }
/*     */       
/* 138 */       if (var8 == 4 && !par1World.getBlock(par2 + 1, par3, par4).isOpaqueCube())
/*     */       {
/* 140 */         var9 = (par2 + 1) + var6;
/*     */       }
/*     */       
/* 143 */       if (var8 == 5 && !par1World.getBlock(par2 - 1, par3, par4).isOpaqueCube())
/*     */       {
/* 145 */         var9 = (par2 + 0) - var6;
/*     */       }
/*     */       
/* 148 */       if (var9 < par2 || var9 > (par2 + 1) || var11 < 0.0D || var11 > (par3 + 1) || var13 < par4 || var13 > (par4 + 1))
/*     */       {
/* 150 */         par1World.spawnParticle("reddust", var9, var11, var13, 0.0D, 0.0D, 0.0D);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
/* 160 */     super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
/* 161 */     int j1 = 5 + par1World.rand.nextInt(5) + par1World.rand.nextInt(10);
/* 162 */     if (par3 < 40)
/* 163 */       dropXpOnBlockBreak(par1World, par2, par3, par4, j1); 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 168 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\OreUranium.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */