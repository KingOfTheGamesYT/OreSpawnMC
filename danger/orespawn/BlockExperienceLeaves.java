/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockLeaves;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityExpBottle;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BlockExperienceLeaves
/*     */   extends BlockLeaves
/*     */ {
/*  25 */   private IIcon generic_solid = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BlockExperienceLeaves(int par1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> par3List) {
/*  38 */     par3List.add(new ItemStack(Item.getItemFromBlock((Block)this), 1, 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
/*  47 */     if (!par1World.isRemote);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int quantityDropped(Random par1Random) {
/*  58 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  68 */     int var7 = 2;
/*     */ 
/*     */     
/*  71 */     int totaldist = 0;
/*     */     
/*  73 */     if (!par1World.isRemote && par1World.checkChunksExist(par2 - var7, par3 - var7, par4 - var7, par2 + var7, par3 + var7, par4 + var7)) {
/*     */       
/*  75 */       for (int var12 = -var7; var12 <= var7; var12++) {
/*     */         
/*  77 */         for (int var13 = -var7; var13 <= 0; var13++) {
/*     */           
/*  79 */           for (int var14 = -var7; var14 <= var7; var14++) {
/*     */             
/*  81 */             totaldist = Math.abs(var12) + Math.abs(var13) + Math.abs(var14);
/*  82 */             if (totaldist <= 3) {
/*  83 */               Block bid = par1World.getBlock(par2 + var12, par3 + var13, par4 + var14);
/*     */               
/*  85 */               if (bid != null && bid.canSustainLeaves((IBlockAccess)par1World, par2 + var12, par3 + var13, par4 + var14)) {
/*     */ 
/*     */ 
/*     */                 
/*  89 */                 long t = par1World.getWorldTime();
/*  90 */                 t %= 24000L;
/*  91 */                 if (t < 14000L || t > 22000L)
/*     */                   return; 
/*  93 */                 if (par1World.rand.nextInt(65) == 1) {
/*     */ 
/*     */                   
/*  96 */                   bid = par1World.getBlock(par2, par3 + 1, par4);
/*  97 */                   if (bid == Blocks.air)
/*     */                   {
/*  99 */                     dropBlockAsItem(par1World, par2, par3 + 2, par4, new ItemStack(Items.experience_bottle));
/*     */                   }
/*     */                 } 
/* 102 */                 if (par1World.rand.nextInt(75) == 1) {
/*     */ 
/*     */                   
/* 105 */                   bid = par1World.getBlock(par2, par3 - 1, par4);
/* 106 */                   if (bid == Blocks.air) {
/*     */ 
/*     */                     
/* 109 */                     EntityExpBottle var2 = new EntityExpBottle(par1World, par2, (par3 - 1), par4);
/* 110 */                     var2.setLocationAndAngles(par2, (par3 - 1), par4, 0.0F, 0.0F);
/* 111 */                     var2.setThrowableHeading(((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 2.0F), -0.10000000149011612D, ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 2.0F), 0.4F, 5.0F);
/* 112 */                     par1World.spawnEntityInWorld((Entity)var2);
/*     */                   } 
/*     */                 } 
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 121 */       removeLeaves(par1World, par2, par3, par4);
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
/*     */   public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
/* 134 */     long t = par1World.getWorldTime();
/* 135 */     t %= 24000L;
/* 136 */     if (t < 13000L || t > 23000L)
/* 137 */       return;  int rate = 0;
/* 138 */     if (t < 14000L) {
/* 139 */       rate = (14000 - (int)t) / 2;
/*     */     }
/* 141 */     if (t > 22000L) {
/* 142 */       rate = (int)(t - 22000L) / 2;
/*     */     }
/*     */     
/* 145 */     if (par1World.rand.nextInt(200 + rate) == 1) {
/* 146 */       Block bid = par1World.getBlock(par2, par3 + 1, par4);
/* 147 */       if (bid == Blocks.air)
/*     */       {
/* 149 */         for (int i = 0; i < 10; i++) {
/* 150 */           par1World.spawnParticle("fireworksSpark", par2, par3 + 1.25D, par4, par1World.rand.nextGaussian(), Math.abs(par1World.rand.nextGaussian()), par1World.rand.nextGaussian());
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/* 155 */     if (par1World.rand.nextInt(40 + rate) == 1) {
/* 156 */       Block bid = par1World.getBlock(par2, par3 - 1, par4);
/* 157 */       if (bid == Blocks.air)
/*     */       {
/* 159 */         for (int i = 0; i < 4; i++) {
/* 160 */           par1World.spawnParticle("fireworksSpark", par2, par3 - 1.25D, par4, (par1World.rand.nextFloat() - par1World.rand.nextFloat()), -Math.abs(par1World.rand.nextFloat()), (par1World.rand.nextFloat() - par1World.rand.nextFloat()));
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeLeaves(World par1World, int par2, int par3, int par4) {
/* 170 */     dropBlockAsItem(par1World, par2, par3, par4, 0, 0);
/* 171 */     par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube() {
/* 180 */     if (OreSpawnMain.FastGraphicsLeaves != 0) return true; 
/* 181 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
/* 191 */     Block i1 = par1IBlockAccess.getBlock(par2, par3, par4);
/* 192 */     return !(OreSpawnMain.FastGraphicsLeaves != 0 && i1 == this);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister iconRegister) {
/* 198 */     this.blockIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/* 199 */     this.generic_solid = iconRegister.registerIcon("OreSpawn:generic_solid");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2) {
/* 208 */     if (OreSpawnMain.FastGraphicsLeaves != 0) {
/* 209 */       return this.generic_solid;
/*     */     }
/* 211 */     return this.blockIcon;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] func_150125_e() {
/* 217 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BlockExperienceLeaves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */