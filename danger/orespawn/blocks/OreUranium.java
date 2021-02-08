/*     */ package danger.orespawn.blocks;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.init.ModBlocks;
/*     */ import danger.orespawn.init.ModItems;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class OreUranium extends Block {
/*     */   static final int tickRate = 100;
/*     */   private boolean glowing = false;
/*  26 */   private int glowcount = 0;
/*     */   
/*     */   public OreUranium() {
/*  29 */     super(Material.ROCK);
/*  30 */     setUnlocalizedName("uranium_ore");
/*  31 */     setRegistryName("uranium_ore");
/*  32 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/*  33 */     setHardness(5.0F);
/*  34 */     setResistance(5.0F);
/*  35 */     setHarvestLevel("pickaxe", 2);
/*  36 */     setLightLevel(0.2F);
/*     */     
/*  38 */     ModBlocks.BLOCKS.add(this);
/*  39 */     ModItems.ITEMS.add((new ItemBlock(this)).setRegistryName(Objects.<ResourceLocation>requireNonNull(getRegistryName())));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
/*  44 */     glow(worldIn, pos);
/*  45 */     super.onEntityWalk(worldIn, pos, entityIn);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/*  50 */     glow(worldIn, pos);
/*  51 */     return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
/*  56 */     glow(worldIn, pos);
/*  57 */     super.onBlockClicked(worldIn, pos, playerIn);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
/*  63 */     if (this.glowing) {
/*  64 */       sparkle(worldIn, pos);
/*  65 */       if (this.glowcount > 0) {
/*  66 */         this.glowcount--;
/*     */       } else {
/*  68 */         this.glowing = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void glow(World par1World, BlockPos pos) {
/*  74 */     this.glowing = true;
/*  75 */     this.glowcount = 10;
/*  76 */     sparkle(par1World, pos);
/*     */   }
/*     */   
/*     */   private void sparkle(World worldIn, BlockPos pos) {
/*  80 */     int par2 = pos.getX();
/*  81 */     int par3 = pos.getY();
/*  82 */     int par4 = pos.getZ();
/*  83 */     Random var5 = worldIn.rand;
/*  84 */     double var6 = 0.0625D;
/*     */ 
/*     */     
/*  87 */     for (int var8 = 0; var8 < 6; var8++) {
/*     */       
/*  89 */       double var9 = (par2 + var5.nextFloat());
/*  90 */       double var11 = (par3 + var5.nextFloat());
/*  91 */       double var13 = (par4 + var5.nextFloat());
/*  92 */       if (var8 == 0 && !worldIn.getBlockState(new BlockPos(par2, par3 + 1, par4)).isOpaqueCube()) {
/*  93 */         var11 = (par3 + 1) + var6;
/*     */       }
/*  95 */       if (var8 == 1 && !worldIn.getBlockState(new BlockPos(par2, par3 - 1, par4)).isOpaqueCube()) {
/*  96 */         var11 = (par3 + 0) - var6;
/*     */       }
/*  98 */       if (var8 == 2 && !worldIn.getBlockState(new BlockPos(par2, par3, par4 - 1)).isOpaqueCube()) {
/*  99 */         var13 = (par4 + 1) + var6;
/*     */       }
/* 101 */       if (var8 == 3 && !worldIn.getBlockState(new BlockPos(par2, par3, par4 - 1)).isOpaqueCube()) {
/* 102 */         var13 = (par4 + 0) - var6;
/*     */       }
/* 104 */       if (var8 == 4 && !worldIn.getBlockState(new BlockPos(par2 + 1, par3, par4)).isOpaqueCube()) {
/* 105 */         var9 = (par2 + 1) + var6;
/*     */       }
/* 107 */       if (var8 == 5 && !worldIn.getBlockState(new BlockPos(par2 - 1, par3, par4)).isOpaqueCube()) {
/* 108 */         var9 = (par2 + 0) - var6;
/*     */       }
/*     */       
/* 111 */       if (var9 < par2 || var9 > (par2 + 1) || var11 < 0.0D || var11 > (par3 + 1) || var13 < par4 || var13 > (par4 + 1)) {
/* 112 */         int which = var5.nextInt(3);
/* 113 */         if (which == 2) worldIn.spawnParticle(EnumParticleTypes.REDSTONE, var9, var11, var13, 0.0D, 0.0D, 0.0D, new int[0]); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\blocks\OreUranium.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */