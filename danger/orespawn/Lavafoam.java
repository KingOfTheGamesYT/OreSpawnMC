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
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Lavafoam
/*     */   extends Block
/*     */ {
/*     */   public Lavafoam(int par1) {
/*  25 */     super(Material.rock);
/*  26 */     setHardness(5.0F);
/*  27 */     setResistance(5.0F);
/*  28 */     setCreativeTab(CreativeTabs.tabBlock);
/*  29 */     setTickRandomly(true);
/*     */     
/*  31 */     this.slipperiness = 1.1F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int tickRate() {
/*  41 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  50 */     if (par1World.rand.nextInt(20) == 0) {
/*  51 */       sparkle(par1World, par2, par3, par4);
/*     */     }
/*     */   }
/*     */   
/*     */   private void sparkle(World par1World, int par2, int par3, int par4) {
/*  56 */     Random var5 = par1World.rand;
/*  57 */     double var6 = 0.0625D;
/*     */     
/*  59 */     for (int var8 = 0; var8 < 6; var8++) {
/*     */       
/*  61 */       double var9 = (par2 + var5.nextFloat());
/*  62 */       double var11 = (par3 + var5.nextFloat());
/*  63 */       double var13 = (par4 + var5.nextFloat());
/*     */       
/*  65 */       if (var8 == 0 && !par1World.getBlock(par2, par3 + 1, par4).isOpaqueCube())
/*     */       {
/*  67 */         var11 = (par3 + 1) + var6;
/*     */       }
/*     */       
/*  70 */       if (var8 == 1 && !par1World.getBlock(par2, par3 - 1, par4).isOpaqueCube())
/*     */       {
/*  72 */         var11 = (par3 + 0) - var6;
/*     */       }
/*     */       
/*  75 */       if (var8 == 2 && !par1World.getBlock(par2, par3, par4 + 1).isOpaqueCube())
/*     */       {
/*  77 */         var13 = (par4 + 1) + var6;
/*     */       }
/*     */       
/*  80 */       if (var8 == 3 && !par1World.getBlock(par2, par3, par4 - 1).isOpaqueCube())
/*     */       {
/*  82 */         var13 = (par4 + 0) - var6;
/*     */       }
/*     */       
/*  85 */       if (var8 == 4 && !par1World.getBlock(par2 + 1, par3, par4).isOpaqueCube())
/*     */       {
/*  87 */         var9 = (par2 + 1) + var6;
/*     */       }
/*     */       
/*  90 */       if (var8 == 5 && !par1World.getBlock(par2 - 1, par3, par4).isOpaqueCube())
/*     */       {
/*  92 */         var9 = (par2 + 0) - var6;
/*     */       }
/*     */       
/*  95 */       if (var9 < par2 || var9 > (par2 + 1) || var11 < 0.0D || var11 > (par3 + 1) || var13 < par4 || var13 > (par4 + 1)) {
/*     */         
/*  97 */         int which = par1World.rand.nextInt(10);
/*  98 */         if (which == 1) par1World.spawnParticle("smoke", var9, var11, var13, 0.0D, 0.0D, 0.0D); 
/*  99 */         if (which == 2) par1World.spawnParticle("reddust", var9, var11, var13, 0.0D, 0.0D, 0.0D);
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
/* 110 */     double pi = 3.14159D;
/* 111 */     double pi2 = pi / 2.0D;
/* 112 */     double pi4 = pi / 4.0D;
/* 113 */     super.onEntityCollidedWithBlock(par1World, par2, par3, par4, par5Entity);
/*     */     
/* 115 */     if (par5Entity == null)
/* 116 */       return;  if (!(par5Entity instanceof net.minecraft.entity.EntityLivingBase)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 121 */     double d = Math.atan2(par5Entity.posX - (par2 + 0.5F), par5Entity.posZ - (par4 + 0.5F));
/* 122 */     if (d < 0.0D) d = pi * 2.0D + d;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     if (d > pi2 - pi4 && d < pi2 + pi4) {
/* 128 */       par5Entity.motionX = 0.44999998807907104D;
/* 129 */       par5Entity.motionZ *= 1.350000023841858D;
/* 130 */     } else if (d > pi - pi4 && d < pi + pi4) {
/* 131 */       par5Entity.motionZ = -0.44999998807907104D;
/* 132 */       par5Entity.motionX *= 1.350000023841858D;
/* 133 */     } else if (d > pi + pi2 - pi4 && d < pi + pi2 + pi4) {
/* 134 */       par5Entity.motionX = -0.44999998807907104D;
/* 135 */       par5Entity.motionZ *= 1.350000023841858D;
/*     */     } else {
/* 137 */       par5Entity.motionZ = 0.44999998807907104D;
/* 138 */       par5Entity.motionX *= 1.350000023841858D;
/*     */     } 
/*     */ 
/*     */     
/* 142 */     d = Math.sqrt(par5Entity.motionZ * par5Entity.motionZ + par5Entity.motionX * par5Entity.motionX);
/* 143 */     if (d > 1.0D) {
/* 144 */       par5Entity.attackEntityFrom(DamageSource.fall, (float)d);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
/* 155 */     super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
/* 156 */     int j1 = 5 + par1World.rand.nextInt(5) + par1World.rand.nextInt(5);
/* 157 */     if (par1World.provider.dimensionId == -1) {
/* 158 */       dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
/* 169 */     float f = 0.0125F;
/* 170 */     return AxisAlignedBB.getBoundingBox((par2 + f), par3, (par4 + f), ((par2 + 1) - f), (par3 + 1), ((par4 + 1) - f));
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 176 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Lavafoam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */