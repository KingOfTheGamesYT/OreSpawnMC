/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockTorch;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.AxisAlignedBB;
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
/*     */ public class KrakenRepellent
/*     */   extends BlockTorch
/*     */ {
/*     */   public KrakenRepellent(int par1) {
/*  29 */     setCreativeTab(CreativeTabs.tabRedstone);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  40 */     int var6 = par1World.getBlockMetadata(par2, par3, par4);
/*  41 */     double var7 = (par2 + 0.5F);
/*  42 */     double var9 = (par3 + 0.7F);
/*  43 */     double var11 = (par4 + 0.5F);
/*  44 */     double var13 = 0.413D;
/*  45 */     double var15 = 0.271D;
/*     */     
/*  47 */     if (var6 == 1) {
/*     */       
/*  49 */       par1World.spawnParticle("smoke", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
/*  50 */       par1World.spawnParticle("flame", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
/*  51 */       par1World.spawnParticle("reddust", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
/*     */     }
/*  53 */     else if (var6 == 2) {
/*     */       
/*  55 */       par1World.spawnParticle("smoke", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
/*  56 */       par1World.spawnParticle("flame", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
/*  57 */       par1World.spawnParticle("reddust", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
/*     */     }
/*  59 */     else if (var6 == 3) {
/*     */       
/*  61 */       par1World.spawnParticle("smoke", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
/*  62 */       par1World.spawnParticle("flame", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
/*  63 */       par1World.spawnParticle("reddust", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
/*     */     }
/*  65 */     else if (var6 == 4) {
/*     */       
/*  67 */       par1World.spawnParticle("smoke", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
/*  68 */       par1World.spawnParticle("flame", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
/*  69 */       par1World.spawnParticle("reddust", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
/*     */     }
/*     */     else {
/*     */       
/*  73 */       par1World.spawnParticle("smoke", var7, var9 + 0.21D, var11, 0.0D, 0.0D, 0.0D);
/*  74 */       par1World.spawnParticle("flame", var7, var9 + 0.21D, var11, 0.0D, 0.0D, 0.0D);
/*  75 */       par1World.spawnParticle("reddust", var7, var9 + 0.21D, var11, 0.0D, 0.0D, 0.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int tickRate(World par1World) {
/*  84 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  92 */     if (!par1World.isRemote) {
/*     */ 
/*     */       
/*  95 */       findSomethingToRepell(par1World, par2, par3, par4);
/*     */       
/*  97 */       par1World.scheduleBlockUpdate(par2, par3, par4, (Block)this, tickRate(par1World));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockAdded(World world, int x, int y, int z) {
/* 105 */     world.scheduleBlockUpdate(x, y, z, (Block)this, tickRate(world));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onNeighborBlockChange(World world, int x, int y, int z, Block blockId) {
/* 111 */     world.scheduleBlockUpdate(x, y, z, (Block)this, tickRate(world));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
/* 119 */     return super.canPlaceBlockAt(par1World, par2, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void findSomethingToRepell(World par1World, int par2, int par3, int par4) {
/* 125 */     AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(par2 - 20.0D, par3 - 10.0D, par4 - 20.0D, par2 + 20.0D, par3 + 40.0D, par4 + 20.0D);
/* 126 */     List var5 = par1World.getEntitiesWithinAABB(EntityLivingBase.class, bb);
/* 127 */     Iterator<EntityLivingBase> var2 = var5.iterator();
/* 128 */     EntityLivingBase var3 = null;
/*     */ 
/*     */     
/* 131 */     while (var2.hasNext()) {
/*     */       
/* 133 */       var3 = var2.next();
/*     */       
/* 135 */       if (var3 != null && var3 instanceof Kraken) {
/*     */         
/* 137 */         double d1 = var3.posX - par2;
/* 138 */         double d2 = var3.posY - 15.0D - par3;
/* 139 */         double d3 = var3.posZ - par4;
/* 140 */         double f = d1 * d1 + d2 * d2 + d3 * d3;
/* 141 */         f = Math.sqrt(f);
/*     */         
/* 143 */         f = 20.0D - f;
/* 144 */         if (f > 20.0D) f = 20.0D; 
/* 145 */         if (f < 0.0D) f = 0.0D; 
/* 146 */         f *= 0.4D;
/* 147 */         double d = (float)Math.atan2(var3.posX - par2, var3.posZ - par4);
/* 148 */         var3.motionX += f * Math.sin(d);
/* 149 */         var3.motionZ += f * Math.cos(d);
/*     */       } 
/*     */       
/* 152 */       if (var3 != null && var3 instanceof EntityAnt) {
/*     */         
/* 154 */         double d1 = var3.posX - par2;
/* 155 */         double d2 = var3.posY - par3;
/* 156 */         double d3 = var3.posZ - par4;
/* 157 */         double f = d1 * d1 + d2 * d2 + d3 * d3;
/* 158 */         f = Math.sqrt(f);
/*     */         
/* 160 */         f = 20.0D - f;
/* 161 */         if (f > 20.0D) f = 20.0D; 
/* 162 */         if (f < 0.0D) f = 0.0D; 
/* 163 */         f *= 0.4D;
/* 164 */         double d = (float)Math.atan2(var3.posX - par2, var3.posZ - par4);
/* 165 */         var3.motionX += f * Math.sin(d);
/* 166 */         var3.motionZ += f * Math.cos(d);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 176 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\KrakenRepellent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */