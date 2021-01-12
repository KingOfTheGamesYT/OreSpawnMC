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
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntityChest;
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
/*     */ public class InstantShelter
/*     */   extends Item
/*     */ {
/*     */   public InstantShelter(int i) {
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
/*  49 */     int bid = 0;
/*  50 */     int dirx = 0, dirz = 0;
/*     */     
/*  52 */     int stuffdir = 0;
/*     */     
/*  54 */     int length = 3, width = length;
/*  55 */     int height = 3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     if (cposx < 0) dirx = -1; 
/*  66 */     if (cposz < 0) dirz = -1; 
/*  67 */     int pposx = (int)(Player.posX + 0.99D * dirx);
/*  68 */     int pposy = (int)Player.posY;
/*  69 */     int pposz = (int)(Player.posZ + 0.99D * dirz);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  74 */     if (cposx - pposx == 0 || cposz - pposz == 0) {
/*     */       
/*  76 */       int x = cposx, y = pposy - 1, z = cposz;
/*  77 */       if (x - pposx < 0) {
/*  78 */         deltax = -1;
/*  79 */         stuffdir = 3;
/*     */       } 
/*     */       
/*  82 */       if (x - pposx > 0) {
/*  83 */         deltax = 1;
/*     */         
/*  85 */         stuffdir = 2;
/*     */       } 
/*  87 */       if (z - pposz < 0) {
/*  88 */         deltaz = -1;
/*     */         
/*  90 */         stuffdir = 5;
/*     */       } 
/*  92 */       if (z - pposz > 0) {
/*  93 */         deltaz = 1;
/*     */         
/*  95 */         stuffdir = 4;
/*     */       } 
/*  97 */       if (deltax == 0 && deltaz == 0) return false; 
/*  98 */       if (deltax != 0 && deltaz != 0) return false;
/*     */       
/* 100 */       x = pposx; z = pposz;
/*     */       
/* 102 */       Player.worldObj.playSoundAtEntity((Entity)Player, "random.explode", 1.0F, 1.5F);
/*     */       
/* 104 */       if (world.isRemote)
/*     */       {
/*     */         
/* 107 */         return true;
/*     */       }
/*     */       
/*     */       int i;
/* 111 */       for (i = -width; i <= width; i++) {
/*     */         
/* 113 */         for (int m = -length; m <= length; m++) {
/*     */           
/* 115 */           for (int n = 0; n <= height + 1; n++) {
/*     */             
/* 117 */             if (n == height + 1) {
/* 118 */               world.setBlock(x + i, y + n, z + m, Blocks.planks);
/* 119 */             } else if (n == 0) {
/* 120 */               world.setBlock(x + i, y + n, z + m, Blocks.cobblestone);
/* 121 */             } else if (i == width || m == length || i == -width || m == -length) {
/* 122 */               if (n == height) {
/* 123 */                 world.setBlock(x + i, y + n, z + m, Blocks.glass);
/* 124 */               } else if ((n == 1 || n == 2) && i == deltax * width && m == deltaz * length) {
/*     */                 
/* 126 */                 world.setBlock(x + i, y + n, z + m, Blocks.air);
/*     */               } else {
/* 128 */                 world.setBlock(x + i, y + n, z + m, Blocks.planks);
/*     */               } 
/*     */             } else {
/* 131 */               world.setBlock(x + i, y + n, z + m, Blocks.air);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 138 */       i = 2; int k = 1, j = length - 1;
/* 139 */       world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, Blocks.furnace);
/* 140 */       world.setBlockMetadataWithNotify(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, stuffdir, 3);
/* 141 */       i = 1;
/* 142 */       world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, Blocks.crafting_table);
/* 143 */       i = 0;
/* 144 */       world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, (Block)Blocks.chest);
/* 145 */       world.setBlockMetadataWithNotify(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, stuffdir, 3);
/*     */       
/* 147 */       TileEntityChest chest = (TileEntityChest)world.getTileEntity(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax);
/* 148 */       if (chest != null) {
/*     */         
/* 150 */         chest.setInventorySlotContents(0, new ItemStack(Items.compass));
/* 151 */         chest.setInventorySlotContents(1, new ItemStack((Item)Items.map));
/* 152 */         chest.setInventorySlotContents(2, new ItemStack(Items.porkchop, 8));
/* 153 */         chest.setInventorySlotContents(3, new ItemStack(Blocks.torch, 32));
/* 154 */         chest.setInventorySlotContents(4, new ItemStack(Items.coal, 16));
/* 155 */         chest.setInventorySlotContents(5, new ItemStack(Items.bed));
/* 156 */         chest.setInventorySlotContents(6, new ItemStack(Items.bed));
/* 157 */         chest.setInventorySlotContents(7, new ItemStack(Items.wooden_door));
/* 158 */         chest.setInventorySlotContents(8, new ItemStack(Items.iron_pickaxe));
/* 159 */         chest.setInventorySlotContents(9, new ItemStack(Items.iron_sword));
/* 160 */         chest.setInventorySlotContents(10, new ItemStack(Items.iron_axe));
/* 161 */         chest.setInventorySlotContents(11, new ItemStack(Items.bucket));
/* 162 */         chest.setInventorySlotContents(12, new ItemStack(OreSpawnMain.MyOreSaltBlock, 4));
/* 163 */         chest.setInventorySlotContents(13, new ItemStack((Block)Blocks.chest));
/*     */       } 
/*     */ 
/*     */       
/* 167 */       if (!Player.capabilities.isCreativeMode)
/*     */       {
/* 169 */         par1ItemStack.stackSize--;
/*     */       }
/*     */       
/* 172 */       return true;
/*     */     } 
/* 174 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 181 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\InstantShelter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */