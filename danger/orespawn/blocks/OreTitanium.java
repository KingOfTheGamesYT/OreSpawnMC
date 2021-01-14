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
/*     */ public class OreTitanium
/*     */   extends Block
/*     */ {
/*     */   static final int tickRate = 100;
/*     */   private boolean glowing = false;
/*  28 */   private int glowcount = 0;
/*     */   
/*     */   public OreTitanium() {
/*  31 */     super(Material.ROCK);
/*  32 */     setUnlocalizedName("titanium_ore");
/*  33 */     setRegistryName("titanium_ore");
/*  34 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/*  35 */     setHardness(5.0F);
/*  36 */     setResistance(5.0F);
/*  37 */     setHarvestLevel("pickaxe", 2);
/*  38 */     setLightLevel(0.2F);
/*     */     
/*  40 */     ModBlocks.BLOCKS.add(this);
/*  41 */     ModItems.ITEMS.add((new ItemBlock(this)).setRegistryName(Objects.<ResourceLocation>requireNonNull(getRegistryName())));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
/*  46 */     glow(worldIn, pos);
/*  47 */     super.onEntityWalk(worldIn, pos, entityIn);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/*  52 */     glow(worldIn, pos);
/*  53 */     return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
/*  58 */     glow(worldIn, pos);
/*  59 */     super.onBlockClicked(worldIn, pos, playerIn);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
/*  65 */     if (this.glowing) {
/*  66 */       sparkle(worldIn, pos);
/*  67 */       if (this.glowcount > 0) {
/*  68 */         this.glowcount--;
/*     */       } else {
/*  70 */         this.glowing = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void glow(World par1World, BlockPos pos) {
/*  76 */     this.glowing = true;
/*  77 */     this.glowcount = 10;
/*  78 */     sparkle(par1World, pos);
/*     */   }
/*     */   
/*     */   private void sparkle(World worldIn, BlockPos pos) {
/*  82 */     int par2 = pos.getX();
/*  83 */     int par3 = pos.getY();
/*  84 */     int par4 = pos.getZ();
/*  85 */     Random var5 = worldIn.rand;
/*  86 */     double var6 = 0.0625D;
/*     */ 
/*     */     
/*  89 */     for (int var8 = 0; var8 < 6; var8++) {
/*     */       
/*  91 */       double var9 = (par2 + var5.nextFloat());
/*  92 */       double var11 = (par3 + var5.nextFloat());
/*  93 */       double var13 = (par4 + var5.nextFloat());
/*  94 */       if (var8 == 0 && !worldIn.getBlockState(new BlockPos(par2, par3 + 1, par4)).isOpaqueCube()) {
/*  95 */         var11 = (par3 + 1) + var6;
/*     */       }
/*  97 */       if (var8 == 1 && !worldIn.getBlockState(new BlockPos(par2, par3 - 1, par4)).isOpaqueCube()) {
/*  98 */         var11 = (par3 + 0) - var6;
/*     */       }
/* 100 */       if (var8 == 2 && !worldIn.getBlockState(new BlockPos(par2, par3, par4 - 1)).isOpaqueCube()) {
/* 101 */         var13 = (par4 + 1) + var6;
/*     */       }
/* 103 */       if (var8 == 3 && !worldIn.getBlockState(new BlockPos(par2, par3, par4 - 1)).isOpaqueCube()) {
/* 104 */         var13 = (par4 + 0) - var6;
/*     */       }
/* 106 */       if (var8 == 4 && !worldIn.getBlockState(new BlockPos(par2 + 1, par3, par4)).isOpaqueCube()) {
/* 107 */         var9 = (par2 + 1) + var6;
/*     */       }
/* 109 */       if (var8 == 5 && !worldIn.getBlockState(new BlockPos(par2 - 1, par3, par4)).isOpaqueCube()) {
/* 110 */         var9 = (par2 + 0) - var6;
/*     */       }
/*     */       
/* 113 */       if (var9 < par2 || var9 > (par2 + 1) || var11 < 0.0D || var11 > (par3 + 1) || var13 < par4 || var13 > (par4 + 1)) {
/* 114 */         int which = var5.nextInt(3);
/* 115 */         if (which == 2) worldIn.spawnParticle(EnumParticleTypes.REDSTONE, var9, var11, var13, 0.0D, 0.0D, 0.0D, new int[0]); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespawn\blocks\OreTitanium.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */