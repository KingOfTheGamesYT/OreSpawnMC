/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.Chunk;
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
/*     */ public class ItemAppleSeed
/*     */   extends Item
/*     */ {
/*     */   public ItemAppleSeed(int i) {
/*  28 */     this.maxStackSize = 16;
/*  29 */     setCreativeTab(CreativeTabs.tabDecorations);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
/*  36 */     if (!world.isRemote) {
/*     */ 
/*     */       
/*  39 */       Block bid = world.getBlock(x, y, z);
/*  40 */       if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
/*  41 */         return false;
/*     */       }
/*     */       
/*  44 */       if (this == OreSpawnMain.MyAppleSeed) {
/*  45 */         makeTree(world, x, y, z, OreSpawnMain.MyAppleLeaves, (Chunk)null);
/*  46 */       } else if (this == OreSpawnMain.MyCherrySeed) {
/*  47 */         makeTree(world, x, y, z, OreSpawnMain.MyCherryLeaves, (Chunk)null);
/*     */       } else {
/*  49 */         makeTree(world, x, y, z, OreSpawnMain.MyPeachLeaves, (Chunk)null);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  57 */     if (!par2EntityPlayer.capabilities.isCreativeMode)
/*     */     {
/*  59 */       par1ItemStack.stackSize--;
/*     */     }
/*     */     
/*  62 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void makeTree(World world, int x, int y, int z, Block blkid, Chunk chunk) {
/*  71 */     Block bid = world.getBlock(x, y, z);
/*  72 */     if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
/*     */       return;
/*     */     }
/*     */     
/*  76 */     int h1 = 12;
/*  77 */     int h2 = 6;
/*  78 */     int h3 = 9;
/*  79 */     int h4 = 6;
/*  80 */     int h5 = 14;
/*  81 */     int w1 = 5;
/*  82 */     int w2 = 3;
/*  83 */     if (blkid == OreSpawnMain.MyPeachLeaves) {
/*  84 */       h1 = 10;
/*  85 */       h2 = 5;
/*  86 */       h3 = 7;
/*  87 */       h4 = 5;
/*  88 */       h5 = 12;
/*  89 */       w1 = 4;
/*  90 */       w2 = 2;
/*     */     } 
/*  92 */     if (blkid == OreSpawnMain.MyCherryLeaves) {
/*  93 */       h1 = 8;
/*  94 */       h2 = 3;
/*  95 */       h3 = 5;
/*  96 */       h4 = 3;
/*  97 */       h5 = 10;
/*  98 */       w1 = 3;
/*  99 */       w2 = 1;
/*     */     } 
/*     */     
/*     */     int j;
/* 103 */     for (j = 1; j < h1; j++) {
/* 104 */       world.setBlock(x, y + j, z, Blocks.log, 0, 2);
/*     */     }
/*     */ 
/*     */     
/* 108 */     for (j = 1; j < w1; ) { OreSpawnMain.setBlockSuperFast(world, x + j, y + h2, z, Blocks.log, 0, 2, chunk); j++; }
/* 109 */      for (j = 1; j < w1; ) { OreSpawnMain.setBlockSuperFast(world, x - j, y + h2, z, Blocks.log, 0, 2, chunk); j++; }
/* 110 */      for (j = 1; j < w1; ) { OreSpawnMain.setBlockSuperFast(world, x, y + h2, z + j, Blocks.log, 0, 2, chunk); j++; }
/* 111 */      for (j = 1; j < w1; ) { OreSpawnMain.setBlockSuperFast(world, x, y + h2, z - j, Blocks.log, 0, 2, chunk); j++; }
/*     */ 
/*     */     
/* 114 */     for (j = 1; j < w2; ) { OreSpawnMain.setBlockSuperFast(world, x + j, y + h3, z, Blocks.log, 0, 2, chunk); j++; }
/* 115 */      for (j = 1; j < w2; ) { OreSpawnMain.setBlockSuperFast(world, x - j, y + h3, z, Blocks.log, 0, 2, chunk); j++; }
/* 116 */      for (j = 1; j < w2; ) { OreSpawnMain.setBlockSuperFast(world, x, y + h3, z + j, Blocks.log, 0, 2, chunk); j++; }
/* 117 */      for (j = 1; j < w2; ) { OreSpawnMain.setBlockSuperFast(world, x, y + h3, z - j, Blocks.log, 0, 2, chunk); j++; }
/*     */ 
/*     */     
/* 120 */     for (int i = h4; i < h5; i++) {
/* 121 */       int width = 6;
/* 122 */       if (i > 8) width = 5; 
/* 123 */       if (i > 10) width = 4; 
/* 124 */       if (blkid != OreSpawnMain.MyAppleLeaves) width--; 
/* 125 */       for (j = -width; j <= width; j++) {
/* 126 */         for (int k = -width; k <= width; k++) {
/* 127 */           bid = world.getBlock(x + k, y + i, z + j);
/* 128 */           if (bid == Blocks.air) OreSpawnMain.setBlockSuperFast(world, x + k, y + i, z + j, blkid, 0, 2, chunk);
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 138 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemAppleSeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */