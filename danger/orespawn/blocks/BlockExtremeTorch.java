/*     */ package danger.orespawn.blocks;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.init.ModBlocks;
/*     */ import danger.orespawn.init.ModItems;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockTorch;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockExtremeTorch
/*     */   extends BlockTorch
/*     */ {
/*     */   public BlockExtremeTorch() {
/*  33 */     setUnlocalizedName("extreme_torch");
/*  34 */     setRegistryName("extreme_torch");
/*  35 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/*  36 */     ModBlocks.BLOCKS.add(this);
/*  37 */     setLightLevel(1.0F);
/*  38 */     ModItems.ITEMS.add((new ItemBlock((Block)this)).setRegistryName(Objects.<ResourceLocation>requireNonNull(getRegistryName())));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void randomDisplayTick(IBlockState stateIn, World par1World, BlockPos pos, Random par5Random) {
/*  47 */     int var6 = getMetaFromState(par1World.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ())));
/*     */     
/*  49 */     double var7 = (pos.getX() + 0.5F);
/*  50 */     double var9 = (pos.getY() + 0.7F);
/*  51 */     double var11 = (pos.getZ() + 0.5F);
/*  52 */     double var13 = 0.213D;
/*  53 */     double var15 = 0.271D;
/*     */     
/*  55 */     if (var6 == 1) {
/*     */       
/*  57 */       par1World.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D, new int[0]);
/*  58 */       par1World.spawnParticle(EnumParticleTypes.FLAME, var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D, new int[0]);
/*  59 */       par1World.spawnParticle(EnumParticleTypes.REDSTONE, var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */     }
/*  61 */     else if (var6 == 2) {
/*     */       
/*  63 */       par1World.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D, new int[0]);
/*  64 */       par1World.spawnParticle(EnumParticleTypes.FLAME, var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D, new int[0]);
/*  65 */       par1World.spawnParticle(EnumParticleTypes.REDSTONE, var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */     }
/*  67 */     else if (var6 == 3) {
/*     */       
/*  69 */       par1World.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D, new int[0]);
/*  70 */       par1World.spawnParticle(EnumParticleTypes.FLAME, var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D, new int[0]);
/*  71 */       par1World.spawnParticle(EnumParticleTypes.REDSTONE, var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */     }
/*  73 */     else if (var6 == 4) {
/*     */       
/*  75 */       par1World.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D, new int[0]);
/*  76 */       par1World.spawnParticle(EnumParticleTypes.FLAME, var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D, new int[0]);
/*  77 */       par1World.spawnParticle(EnumParticleTypes.REDSTONE, var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */     }
/*     */     else {
/*     */       
/*  81 */       par1World.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, var7, var9, var11, 0.0D, 0.0D, 0.0D, new int[0]);
/*  82 */       par1World.spawnParticle(EnumParticleTypes.FLAME, var7, var9, var11, 0.0D, 0.0D, 0.0D, new int[0]);
/*  83 */       par1World.spawnParticle(EnumParticleTypes.REDSTONE, var7, var9, var11, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */     } 
/*     */ 
/*     */     
/*  87 */     onBlockPlacedBy(par1World, pos.getX(), pos.getY(), pos.getZ(), (EntityLivingBase)null, (ItemStack)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
/*  95 */     return canPlaceBlockAt(par1World, new BlockPos(par2, par3, par4));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onBlockPlacedBy(World world, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack) {
/* 100 */     int x = par2, y = par3, z = par4, found = 0;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 156 */     onBlockPlacedBy(world, new BlockPos(par2, par3, par4), Blocks.AIR.getDefaultState(), par5EntityLiving, par6ItemStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 166 */     Entity var8 = null;
/*     */ 
/*     */     
/* 169 */     var8 = EntityList.createEntityByIDFromName(new ResourceLocation(par1), par0World);
/*     */ 
/*     */     
/* 172 */     if (var8 != null) {
/*     */ 
/*     */       
/* 175 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 178 */       par0World.spawnEntity(var8);
/*     */ 
/*     */       
/* 181 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     
/* 184 */     return var8;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\blocks\BlockExtremeTorch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */