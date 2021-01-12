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
/*     */ 
/*     */ 
/*     */ public class CreeperRepellent
/*     */   extends BlockTorch
/*     */ {
/*     */   public CreeperRepellent(int par1) {
/*  31 */     setCreativeTab(CreativeTabs.tabRedstone);
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
/*  42 */     int var6 = par1World.getBlockMetadata(par2, par3, par4);
/*  43 */     double var7 = (par2 + 0.5F);
/*  44 */     double var9 = (par3 + 0.7F);
/*  45 */     double var11 = (par4 + 0.5F);
/*  46 */     double var13 = 0.413D;
/*  47 */     double var15 = 0.271D;
/*     */     
/*  49 */     if (var6 == 1) {
/*     */       
/*  51 */       par1World.spawnParticle("smoke", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
/*  52 */       par1World.spawnParticle("flame", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
/*  53 */       par1World.spawnParticle("reddust", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
/*     */     }
/*  55 */     else if (var6 == 2) {
/*     */       
/*  57 */       par1World.spawnParticle("smoke", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
/*  58 */       par1World.spawnParticle("flame", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
/*  59 */       par1World.spawnParticle("reddust", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
/*     */     }
/*  61 */     else if (var6 == 3) {
/*     */       
/*  63 */       par1World.spawnParticle("smoke", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
/*  64 */       par1World.spawnParticle("flame", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
/*  65 */       par1World.spawnParticle("reddust", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
/*     */     }
/*  67 */     else if (var6 == 4) {
/*     */       
/*  69 */       par1World.spawnParticle("smoke", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
/*  70 */       par1World.spawnParticle("flame", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
/*  71 */       par1World.spawnParticle("reddust", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
/*     */     }
/*     */     else {
/*     */       
/*  75 */       par1World.spawnParticle("smoke", var7, var9 + 0.21D, var11, 0.0D, 0.0D, 0.0D);
/*  76 */       par1World.spawnParticle("flame", var7, var9 + 0.21D, var11, 0.0D, 0.0D, 0.0D);
/*  77 */       par1World.spawnParticle("reddust", var7, var9 + 0.21D, var11, 0.0D, 0.0D, 0.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int tickRate(World par1World) {
/*  86 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  94 */     if (!par1World.isRemote) {
/*     */ 
/*     */       
/*  97 */       findSomethingToRepell(par1World, par2, par3, par4);
/*     */       
/*  99 */       par1World.scheduleBlockUpdate(par2, par3, par4, (Block)this, tickRate(par1World));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockAdded(World world, int x, int y, int z) {
/* 107 */     world.scheduleBlockUpdate(x, y, z, (Block)this, tickRate(world));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onNeighborBlockChange(World world, int x, int y, int z, Block blockId) {
/* 113 */     world.scheduleBlockUpdate(x, y, z, (Block)this, tickRate(world));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
/* 121 */     return super.canPlaceBlockAt(par1World, par2, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void findSomethingToRepell(World par1World, int par2, int par3, int par4) {
/* 127 */     AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(par2 - 20.0D, par3 - 10.0D, par4 - 20.0D, par2 + 20.0D, par3 + 10.0D, par4 + 20.0D);
/* 128 */     List var5 = par1World.getEntitiesWithinAABB(EntityLivingBase.class, bb);
/* 129 */     Iterator<EntityLivingBase> var2 = var5.iterator();
/* 130 */     EntityLivingBase var3 = null;
/*     */ 
/*     */     
/* 133 */     while (var2.hasNext()) {
/*     */       
/* 135 */       var3 = var2.next();
/*     */       
/* 137 */       if (var3 != null && var3 instanceof net.minecraft.entity.monster.EntityCreeper) {
/*     */         
/* 139 */         double d1 = var3.posX - par2;
/* 140 */         double d2 = var3.posY - par3;
/* 141 */         double d3 = var3.posZ - par4;
/* 142 */         double f = d1 * d1 + d2 * d2 + d3 * d3;
/* 143 */         f = Math.sqrt(f);
/*     */         
/* 145 */         f = 20.0D - f;
/* 146 */         if (f > 20.0D) f = 20.0D; 
/* 147 */         if (f < 0.0D) f = 0.0D; 
/* 148 */         f *= 0.4D;
/* 149 */         double d = (float)Math.atan2(var3.posX - par2, var3.posZ - par4);
/* 150 */         var3.motionX += f * Math.sin(d);
/* 151 */         var3.motionZ += f * Math.cos(d);
/*     */       } 
/*     */ 
/*     */       
/* 155 */       if (var3 != null && var3 instanceof EntityAnt) {
/*     */         
/* 157 */         double d1 = var3.posX - par2;
/* 158 */         double d2 = var3.posY - par3;
/* 159 */         double d3 = var3.posZ - par4;
/* 160 */         double f = d1 * d1 + d2 * d2 + d3 * d3;
/* 161 */         f = Math.sqrt(f);
/*     */         
/* 163 */         f = 20.0D - f;
/* 164 */         if (f > 20.0D) f = 20.0D; 
/* 165 */         if (f < 0.0D) f = 0.0D; 
/* 166 */         f *= 0.4D;
/* 167 */         double d = (float)Math.atan2(var3.posX - par2, var3.posZ - par4);
/* 168 */         var3.motionX += f * Math.sin(d);
/* 169 */         var3.motionZ += f * Math.cos(d);
/*     */       } 
/*     */ 
/*     */       
/* 173 */       if (var3 != null && var3 instanceof PurplePower) {
/*     */         
/* 175 */         PurplePower p = (PurplePower)var3;
/* 176 */         if (p.getPurpleType() == 10)
/* 177 */           return;  double d1 = var3.posX - par2;
/* 178 */         double d2 = var3.posY - par3;
/* 179 */         double d3 = var3.posZ - par4;
/* 180 */         double f = d1 * d1 + d2 * d2 + d3 * d3;
/* 181 */         f = Math.sqrt(f);
/*     */         
/* 183 */         f = 20.0D - f;
/* 184 */         if (f > 20.0D) f = 20.0D; 
/* 185 */         if (f < 0.0D) f = 0.0D; 
/* 186 */         f *= 0.4D;
/* 187 */         double d = (float)Math.atan2(var3.posX - par2, var3.posZ - par4);
/* 188 */         var3.motionX += f * Math.sin(d);
/* 189 */         var3.motionZ += f * Math.cos(d);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 198 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CreeperRepellent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */