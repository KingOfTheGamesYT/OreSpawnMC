/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CrystalFurnace
/*     */   extends BlockContainer
/*     */ {
/*  31 */   private final Random furnaceRand = new Random();
/*     */ 
/*     */   
/*     */   private final boolean isActive;
/*     */ 
/*     */   
/*     */   private static boolean keepFurnaceInventory;
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon furnaceIconTop;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon furnaceIconFront;
/*     */ 
/*     */   
/*     */   protected CrystalFurnace(int par1, boolean par2, float f1, float f2) {
/*  48 */     super(Material.rock);
/*  49 */     this.isActive = par2;
/*  50 */     if (!par2) {
/*  51 */       setCreativeTab(CreativeTabs.tabDecorations);
/*     */     } else {
/*  53 */       setLightLevel(0.6F);
/*     */     } 
/*  55 */     setHardness(f1);
/*  56 */     setResistance(f2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube() {
/*  65 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderAsNormalBlock() {
/*  73 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getItemDropped(int par1, Random par2Random, int par3) {
/*  81 */     return Item.getItemFromBlock((Block)OreSpawnMain.CrystalFurnaceBlock);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item idPicked(World par1World, int par2, int par3, int par4) {
/*  91 */     return Item.getItemFromBlock((Block)OreSpawnMain.CrystalFurnaceBlock);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(int par1, int par2) {
/* 101 */     return (par1 == 1) ? this.furnaceIconTop : ((par1 == 0) ? this.furnaceIconTop : ((par1 != par2) ? this.blockIcon : this.furnaceIconFront));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerBlockIcons(IIconRegister par1IIconRegister) {
/* 112 */     this.blockIcon = par1IIconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + "_side");
/*     */     
/* 114 */     this.furnaceIconFront = par1IIconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + (this.isActive ? "_front_off" : "_front_off"));
/* 115 */     this.furnaceIconTop = par1IIconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5) + "_top");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4) {
/* 124 */     int l = par1World.getBlockMetadata(par2, par3, par4);
/* 125 */     TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
/* 126 */     keepFurnaceInventory = true;
/*     */     
/* 128 */     if (par0) {
/*     */       
/* 130 */       par1World.setBlock(par2, par3, par4, OreSpawnMain.CrystalFurnaceOnBlock);
/*     */     }
/*     */     else {
/*     */       
/* 134 */       par1World.setBlock(par2, par3, par4, (Block)OreSpawnMain.CrystalFurnaceBlock);
/*     */     } 
/*     */     
/* 137 */     keepFurnaceInventory = false;
/* 138 */     par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
/*     */     
/* 140 */     if (tileentity != null) {
/*     */       
/* 142 */       tileentity.validate();
/* 143 */       par1World.setTileEntity(par2, par3, par4, tileentity);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockAdded(World par1World, int par2, int par3, int par4) {
/* 152 */     super.onBlockAdded(par1World, par2, par3, par4);
/* 153 */     setDefaultDirection(par1World, par2, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setDefaultDirection(World par1World, int par2, int par3, int par4) {
/* 161 */     if (!par1World.isRemote) {
/*     */       
/* 163 */       Block l = par1World.getBlock(par2, par3, par4 - 1);
/* 164 */       Block i1 = par1World.getBlock(par2, par3, par4 + 1);
/* 165 */       Block j1 = par1World.getBlock(par2 - 1, par3, par4);
/* 166 */       Block k1 = par1World.getBlock(par2 + 1, par3, par4);
/* 167 */       byte b0 = 3;
/*     */       
/* 169 */       if (l.isFullBlock() && !i1.isFullBlock())
/*     */       {
/* 171 */         b0 = 3;
/*     */       }
/*     */       
/* 174 */       if (i1.isFullBlock() && !l.isFullBlock())
/*     */       {
/* 176 */         b0 = 2;
/*     */       }
/*     */       
/* 179 */       if (j1.isFullBlock() && !k1.isFullBlock())
/*     */       {
/* 181 */         b0 = 5;
/*     */       }
/*     */       
/* 184 */       if (k1.isFullBlock() && !j1.isFullBlock())
/*     */       {
/* 186 */         b0 = 4;
/*     */       }
/*     */       
/* 189 */       par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
/* 198 */     if (par1World.isRemote)
/*     */     {
/* 200 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 204 */     TileEntityCrystalFurnace tileentitycrystalfurnace = (TileEntityCrystalFurnace)par1World.getTileEntity(par2, par3, par4);
/*     */     
/* 206 */     if (tileentitycrystalfurnace != null)
/*     */     {
/* 208 */       par5EntityPlayer.openGui(OreSpawnMain.instance, 0, par1World, par2, par3, par4);
/*     */     }
/*     */     
/* 211 */     return true;
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
/* 222 */     if (this.isActive) {
/*     */       
/* 224 */       int l = par1World.getBlockMetadata(par2, par3, par4);
/* 225 */       float f = par2 + 0.5F;
/* 226 */       float f1 = par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
/* 227 */       float f2 = par4 + 0.5F;
/*     */       
/* 229 */       float f3 = par5Random.nextFloat() * 0.6F - 0.3F;
/* 230 */       float f4 = par5Random.nextFloat() * 0.6F - 0.3F;
/*     */       
/* 232 */       if (l == 4) {
/*     */         
/* 234 */         par1World.spawnParticle("smoke", (f - f3), f1, (f2 + f4), 0.0D, 0.0D, 0.0D);
/* 235 */         par1World.spawnParticle("flame", (f - f3), f1, (f2 + f4), 0.0D, 0.0D, 0.0D);
/*     */       }
/* 237 */       else if (l == 5) {
/*     */         
/* 239 */         par1World.spawnParticle("smoke", (f + f3), f1, (f2 + f4), 0.0D, 0.0D, 0.0D);
/* 240 */         par1World.spawnParticle("flame", (f + f3), f1, (f2 + f4), 0.0D, 0.0D, 0.0D);
/*     */       }
/* 242 */       else if (l == 2) {
/*     */         
/* 244 */         par1World.spawnParticle("smoke", (f + f4), f1, (f2 - f3), 0.0D, 0.0D, 0.0D);
/* 245 */         par1World.spawnParticle("flame", (f + f4), f1, (f2 - f3), 0.0D, 0.0D, 0.0D);
/*     */       }
/* 247 */       else if (l == 3) {
/*     */         
/* 249 */         par1World.spawnParticle("smoke", (f + f4), f1, (f2 + f3), 0.0D, 0.0D, 0.0D);
/* 250 */         par1World.spawnParticle("flame", (f + f4), f1, (f2 + f3), 0.0D, 0.0D, 0.0D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
/* 261 */     int l = MathHelper.floor_double((par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 0x3;
/*     */     
/* 263 */     if (l == 0)
/*     */     {
/* 265 */       par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
/*     */     }
/*     */     
/* 268 */     if (l == 1)
/*     */     {
/* 270 */       par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
/*     */     }
/*     */     
/* 273 */     if (l == 2)
/*     */     {
/* 275 */       par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
/*     */     }
/*     */     
/* 278 */     if (l == 3)
/*     */     {
/* 280 */       par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
/*     */     }
/*     */     
/* 283 */     if (par6ItemStack.hasDisplayName())
/*     */     {
/* 285 */       ((TileEntityCrystalFurnace)par1World.getTileEntity(par2, par3, par4)).setCustomInventoryName(par6ItemStack.getDisplayName());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6) {
/* 296 */     if (!keepFurnaceInventory) {
/*     */       
/* 298 */       TileEntityCrystalFurnace tileentitycrystalfurnace = (TileEntityCrystalFurnace)par1World.getTileEntity(par2, par3, par4);
/*     */       
/* 300 */       if (tileentitycrystalfurnace != null) {
/*     */         
/* 302 */         for (int j1 = 0; j1 < tileentitycrystalfurnace.getSizeInventory(); j1++) {
/*     */           
/* 304 */           ItemStack itemstack = tileentitycrystalfurnace.getStackInSlot(j1);
/*     */           
/* 306 */           if (itemstack != null) {
/*     */             
/* 308 */             float f = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
/* 309 */             float f1 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
/* 310 */             float f2 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
/*     */             
/* 312 */             while (itemstack.stackSize > 0) {
/*     */               
/* 314 */               int k1 = this.furnaceRand.nextInt(21) + 10;
/*     */               
/* 316 */               if (k1 > itemstack.stackSize)
/*     */               {
/* 318 */                 k1 = itemstack.stackSize;
/*     */               }
/*     */               
/* 321 */               itemstack.stackSize -= k1;
/* 322 */               EntityItem entityitem = new EntityItem(par1World, (par2 + f), (par3 + f1), (par4 + f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));
/*     */               
/* 324 */               if (itemstack.hasTagCompound())
/*     */               {
/* 326 */                 entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
/*     */               }
/*     */               
/* 329 */               float f3 = 0.05F;
/* 330 */               entityitem.motionX = ((float)this.furnaceRand.nextGaussian() * f3);
/* 331 */               entityitem.motionY = ((float)this.furnaceRand.nextGaussian() * f3 + 0.2F);
/* 332 */               entityitem.motionZ = ((float)this.furnaceRand.nextGaussian() * f3);
/* 333 */               par1World.spawnEntityInWorld((Entity)entityitem);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 338 */         par1World.func_147453_f(par2, par3, par4, par5);
/*     */       } 
/*     */     } 
/*     */     
/* 342 */     super.breakBlock(par1World, par2, par3, par4, par5, par6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasComparatorInputOverride() {
/* 351 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5) {
/* 360 */     return Container.calcRedstoneFromInventory((IInventory)par1World.getTileEntity(par2, par3, par4));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity createNewTileEntity(World var1, int var2) {
/* 366 */     return new TileEntityCrystalFurnace();
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CrystalFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */