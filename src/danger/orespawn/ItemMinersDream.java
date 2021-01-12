/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
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
/*     */ 
/*     */ 
/*     */ public class ItemMinersDream
/*     */   extends Item
/*     */ {
/*     */   public ItemMinersDream(int i) {
/*  32 */     this.maxStackSize = 16;
/*  33 */     setCreativeTab(CreativeTabs.tabRedstone);
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
/*     */ 
/*     */   
/*     */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer Player, World world, int cposx, int cposy, int cposz, int par7, float par8, float par9, float par10) {
/*  47 */     int deltax = 0, deltaz = 0;
/*     */ 
/*     */     
/*  50 */     int dirx = 0, dirz = 0;
/*  51 */     int height = 5, width = 5, length = 64;
/*  52 */     int torches = 5;
/*  53 */     int solid_count = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     if (cposx < 0) dirx = -1; 
/*  64 */     if (cposz < 0) dirz = -1; 
/*  65 */     int pposx = (int)(Player.posX + 0.99D * dirx);
/*  66 */     int pposy = (int)Player.posY;
/*  67 */     int pposz = (int)(Player.posZ + 0.99D * dirz);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     if (cposx - pposx == 0 || cposz - pposz == 0) {
/*     */ 
/*     */       
/*  75 */       int x = cposx, y = pposy, z = cposz;
/*  76 */       if (x - pposx < 0) deltax = -1; 
/*  77 */       if (x - pposx > 0) deltax = 1; 
/*  78 */       if (z - pposz < 0) deltaz = -1; 
/*  79 */       if (z - pposz > 0) deltaz = 1; 
/*  80 */       if (deltax == 0 && deltaz == 0) return false; 
/*  81 */       if (deltax != 0 && deltaz != 0) return false;
/*     */       
/*  83 */       Player.worldObj.playSoundAtEntity((Entity)Player, "random.explode", 1.0F, 1.5F);
/*     */       
/*  85 */       if (world.isRemote)
/*     */       {
/*     */         
/*  88 */         return true;
/*     */       }
/*     */ 
/*     */       
/*  92 */       for (int i = 0; i < height; i++) {
/*     */ 
/*     */         
/*  95 */         for (int j = 0; j < length; j++) {
/*     */           
/*  97 */           solid_count = 0; int m;
/*  98 */           for (m = -width; m <= width; m++) {
/*     */             
/* 100 */             Block bid = world.getBlock(x + j * deltax + m * deltaz, y + i, z + j * deltaz + m * deltax);
/* 101 */             if (bid == Blocks.stone || bid == Blocks.dirt || bid == Blocks.gravel || bid == Blocks.flowing_water || bid == Blocks.water || bid == Blocks.flowing_lava || bid == Blocks.lava || bid == Blocks.netherrack || bid == Blocks.end_stone || bid == OreSpawnMain.CrystalStone)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 107 */               world.setBlock(x + j * deltax + m * deltaz, y + i, z + j * deltaz + m * deltax, Blocks.air, 0, 2);
/*     */             }
/*     */             
/* 110 */             if (i == height - 1) {
/*     */               
/* 112 */               bid = world.getBlock(x + j * deltax + m * deltaz, y + i + 1, z + j * deltaz + m * deltax);
/* 113 */               if (bid != Blocks.air) solid_count++; 
/* 114 */               if (bid == Blocks.air || bid == Blocks.gravel || bid == Blocks.sand || bid == Blocks.flowing_water || bid == Blocks.water || bid == Blocks.flowing_lava || bid == Blocks.lava)
/*     */               {
/*     */ 
/*     */                 
/* 118 */                 if (world.provider.dimensionId == OreSpawnMain.DimensionID5) {
/* 119 */                   world.setBlock(x + j * deltax + m * deltaz, y + i + 1, z + j * deltaz + m * deltax, OreSpawnMain.CrystalStone, 0, 2);
/*     */                 } else {
/* 121 */                   world.setBlock(x + j * deltax + m * deltaz, y + i + 1, z + j * deltaz + m * deltax, Blocks.cobblestone, 0, 2);
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 128 */           if (i == height - 1 && solid_count == 0)
/*     */           {
/*     */             
/* 131 */             for (m = -width; m <= width; m++)
/*     */             {
/* 133 */               world.setBlock(x + j * deltax + m * deltaz, y + i + 1, z + j * deltaz + m * deltax, Blocks.air, 0, 2);
/*     */             }
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/*     */       int k;
/*     */       
/* 141 */       for (k = 0; k < length; k += torches) {
/*     */         
/* 143 */         Block bid = world.getBlock(x + k * deltax, y - 1, z + k * deltaz);
/* 144 */         if (bid == Blocks.stone || bid == Blocks.dirt || bid == Blocks.gravel || bid == Blocks.netherrack || bid == Blocks.end_stone || bid == Blocks.bedrock)
/*     */         {
/*     */           
/* 147 */           if (world.isAirBlock(x + k * deltax, y, z + k * deltaz))
/*     */           {
/* 149 */             world.setBlock(x + k * deltax, y, z + k * deltaz, OreSpawnMain.ExtremeTorch, 0, 2);
/*     */           }
/*     */         }
/* 152 */         if (bid == OreSpawnMain.CrystalStone)
/*     */         {
/* 154 */           if (world.isAirBlock(x + k * deltax, y, z + k * deltaz))
/*     */           {
/* 156 */             world.setBlock(x + k * deltax, y, z + k * deltaz, OreSpawnMain.CrystalTorch, 0, 2);
/*     */           }
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 162 */       if (!Player.capabilities.isCreativeMode)
/*     */       {
/* 164 */         par1ItemStack.stackSize--;
/*     */       }
/*     */       
/* 167 */       return true;
/*     */     } 
/* 169 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 176 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemMinersDream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */