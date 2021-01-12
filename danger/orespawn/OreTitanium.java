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
/*     */ public class OreTitanium
/*     */   extends Block
/*     */ {
/*     */   private boolean glowing = false;
/*  20 */   private int glowcount = 0;
/*     */ 
/*     */   
/*     */   public OreTitanium(int par1) {
/*  24 */     super(Material.rock);
/*  25 */     setHardness(15.0F);
/*  26 */     setResistance(5.0F);
/*  27 */     setCreativeTab(CreativeTabs.tabBlock);
/*  28 */     setTickRandomly(true);
/*  29 */     this.glowing = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int tickRate() {
/*  37 */     return 30;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
/*  45 */     glow(par1World, par2, par3, par4);
/*  46 */     super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
/*  54 */     glow(par1World, par2, par3, par4);
/*  55 */     super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
/*  63 */     glow(par1World, par2, par3, par4);
/*  64 */     return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void glow(World par1World, int par2, int par3, int par4) {
/*  72 */     this.glowing = true;
/*  73 */     this.glowcount = 5;
/*  74 */     sparkle(par1World, par2, par3, par4);
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
/*  92 */     if (this.glowing) {
/*     */       
/*  94 */       sparkle(par1World, par2, par3, par4);
/*  95 */       if (this.glowcount > 0) {
/*  96 */         this.glowcount--;
/*     */       } else {
/*  98 */         this.glowing = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sparkle(World par1World, int par2, int par3, int par4) {
/* 108 */     Random var5 = par1World.rand;
/* 109 */     double var6 = 0.0625D;
/*     */     
/* 111 */     for (int var8 = 0; var8 < 6; var8++) {
/*     */       
/* 113 */       double var9 = (par2 + var5.nextFloat());
/* 114 */       double var11 = (par3 + var5.nextFloat());
/* 115 */       double var13 = (par4 + var5.nextFloat());
/*     */       
/* 117 */       if (var8 == 0 && !par1World.getBlock(par2, par3 + 1, par4).isOpaqueCube())
/*     */       {
/* 119 */         var11 = (par3 + 1) + var6;
/*     */       }
/*     */       
/* 122 */       if (var8 == 1 && !par1World.getBlock(par2, par3 - 1, par4).isOpaqueCube())
/*     */       {
/* 124 */         var11 = (par3 + 0) - var6;
/*     */       }
/*     */       
/* 127 */       if (var8 == 2 && !par1World.getBlock(par2, par3, par4 + 1).isOpaqueCube())
/*     */       {
/* 129 */         var13 = (par4 + 1) + var6;
/*     */       }
/*     */       
/* 132 */       if (var8 == 3 && !par1World.getBlock(par2, par3, par4 - 1).isOpaqueCube())
/*     */       {
/* 134 */         var13 = (par4 + 0) - var6;
/*     */       }
/*     */       
/* 137 */       if (var8 == 4 && !par1World.getBlock(par2 + 1, par3, par4).isOpaqueCube())
/*     */       {
/* 139 */         var9 = (par2 + 1) + var6;
/*     */       }
/*     */       
/* 142 */       if (var8 == 5 && !par1World.getBlock(par2 - 1, par3, par4).isOpaqueCube())
/*     */       {
/* 144 */         var9 = (par2 + 0) - var6;
/*     */       }
/*     */       
/* 147 */       if (var9 < par2 || var9 > (par2 + 1) || var11 < 0.0D || var11 > (par3 + 1) || var13 < par4 || var13 > (par4 + 1))
/*     */       {
/* 149 */         par1World.spawnParticle("reddust", var9, var11, var13, 0.0D, 0.0D, 0.0D);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
/* 159 */     super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
/* 160 */     int j1 = 5 + par1World.rand.nextInt(5) + par1World.rand.nextInt(10);
/* 161 */     if (par3 < 40)
/* 162 */       dropXpOnBlockBreak(par1World, par2, par3, par4, j1); 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 167 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\OreTitanium.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */