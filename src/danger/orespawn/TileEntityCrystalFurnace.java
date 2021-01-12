/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.ISidedInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemHoe;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.item.ItemTool;
/*     */ import net.minecraft.item.crafting.FurnaceRecipes;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ 
/*     */ public class TileEntityCrystalFurnace
/*     */   extends TileEntity
/*     */   implements ISidedInventory {
/*  26 */   private static final int[] slots_top = new int[] { 0 };
/*  27 */   private static final int[] slots_bottom = new int[] { 2, 1 };
/*  28 */   private static final int[] slots_sides = new int[] { 1 };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  33 */   private ItemStack[] furnaceItemStacks = new ItemStack[3];
/*     */ 
/*     */ 
/*     */   
/*     */   public int furnaceBurnTime;
/*     */ 
/*     */ 
/*     */   
/*     */   public int currentItemBurnTime;
/*     */ 
/*     */   
/*     */   public int furnaceCookTime;
/*     */ 
/*     */   
/*     */   private String field_94130_e;
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSizeInventory() {
/*  52 */     return this.furnaceItemStacks.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getStackInSlot(int par1) {
/*  60 */     return this.furnaceItemStacks[par1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack decrStackSize(int par1, int par2) {
/*  69 */     if (this.furnaceItemStacks[par1] != null) {
/*     */ 
/*     */ 
/*     */       
/*  73 */       if ((this.furnaceItemStacks[par1]).stackSize <= par2) {
/*     */         
/*  75 */         ItemStack itemStack = this.furnaceItemStacks[par1];
/*  76 */         this.furnaceItemStacks[par1] = null;
/*  77 */         return itemStack;
/*     */       } 
/*     */ 
/*     */       
/*  81 */       ItemStack itemstack = this.furnaceItemStacks[par1].splitStack(par2);
/*     */       
/*  83 */       if ((this.furnaceItemStacks[par1]).stackSize == 0)
/*     */       {
/*  85 */         this.furnaceItemStacks[par1] = null;
/*     */       }
/*     */       
/*  88 */       return itemstack;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  93 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getStackInSlotOnClosing(int par1) {
/* 103 */     if (this.furnaceItemStacks[par1] != null) {
/*     */       
/* 105 */       ItemStack itemstack = this.furnaceItemStacks[par1];
/* 106 */       this.furnaceItemStacks[par1] = null;
/* 107 */       return itemstack;
/*     */     } 
/*     */ 
/*     */     
/* 111 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
/* 120 */     this.furnaceItemStacks[par1] = par2ItemStack;
/*     */     
/* 122 */     if (par2ItemStack != null && par2ItemStack.stackSize > getInventoryStackLimit())
/*     */     {
/* 124 */       par2ItemStack.stackSize = getInventoryStackLimit();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInventoryName() {
/* 133 */     return hasCustomInventoryName() ? this.field_94130_e : "container.furnace";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasCustomInventoryName() {
/* 141 */     return (this.field_94130_e != null && this.field_94130_e.length() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomInventoryName(String par1Str) {
/* 150 */     this.field_94130_e = par1Str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 158 */     super.readFromNBT(par1NBTTagCompound);
/* 159 */     NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", 10);
/* 160 */     this.furnaceItemStacks = new ItemStack[getSizeInventory()];
/*     */     
/* 162 */     for (int i = 0; i < nbttaglist.tagCount(); i++) {
/*     */       
/* 164 */       NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
/* 165 */       byte b0 = nbttagcompound1.getByte("Slot");
/*     */       
/* 167 */       if (b0 >= 0 && b0 < this.furnaceItemStacks.length)
/*     */       {
/* 169 */         this.furnaceItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */     
/* 173 */     this.furnaceBurnTime = par1NBTTagCompound.getShort("BurnTime");
/* 174 */     this.furnaceCookTime = par1NBTTagCompound.getShort("CookTime");
/* 175 */     this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
/*     */     
/* 177 */     if (par1NBTTagCompound.hasKey("CustomName"))
/*     */     {
/* 179 */       this.field_94130_e = par1NBTTagCompound.getString("CustomName");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
/* 188 */     super.writeToNBT(par1NBTTagCompound);
/* 189 */     par1NBTTagCompound.setShort("BurnTime", (short)this.furnaceBurnTime);
/* 190 */     par1NBTTagCompound.setShort("CookTime", (short)this.furnaceCookTime);
/* 191 */     NBTTagList nbttaglist = new NBTTagList();
/*     */     
/* 193 */     for (int i = 0; i < this.furnaceItemStacks.length; i++) {
/*     */       
/* 195 */       if (this.furnaceItemStacks[i] != null) {
/*     */         
/* 197 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 198 */         nbttagcompound1.setByte("Slot", (byte)i);
/* 199 */         this.furnaceItemStacks[i].writeToNBT(nbttagcompound1);
/* 200 */         nbttaglist.appendTag((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/*     */     
/* 204 */     par1NBTTagCompound.setTag("Items", (NBTBase)nbttaglist);
/*     */     
/* 206 */     if (hasCustomInventoryName())
/*     */     {
/* 208 */       par1NBTTagCompound.setString("CustomName", this.field_94130_e);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInventoryStackLimit() {
/* 218 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getCookProgressScaled(int par1) {
/* 229 */     return this.furnaceCookTime * par1 / 150;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getBurnTimeRemainingScaled(int par1) {
/* 240 */     if (this.currentItemBurnTime == 0)
/*     */     {
/* 242 */       this.currentItemBurnTime = 150;
/*     */     }
/*     */     
/* 245 */     return this.furnaceBurnTime * par1 / this.currentItemBurnTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBurning() {
/* 253 */     return (this.furnaceBurnTime > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateEntity() {
/* 262 */     boolean flag = (this.furnaceBurnTime > 0);
/* 263 */     boolean flag1 = false;
/*     */     
/* 265 */     if (this.furnaceBurnTime > 0)
/*     */     {
/* 267 */       this.furnaceBurnTime--;
/*     */     }
/*     */     
/* 270 */     if (!this.worldObj.isRemote) {
/*     */       
/* 272 */       if (this.furnaceBurnTime == 0 && canSmelt()) {
/*     */         
/* 274 */         this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
/*     */         
/* 276 */         if (this.furnaceBurnTime > 0) {
/*     */           
/* 278 */           flag1 = true;
/*     */           
/* 280 */           if (this.furnaceItemStacks[1] != null) {
/*     */             
/* 282 */             (this.furnaceItemStacks[1]).stackSize--;
/*     */             
/* 284 */             if ((this.furnaceItemStacks[1]).stackSize == 0)
/*     */             {
/* 286 */               this.furnaceItemStacks[1] = this.furnaceItemStacks[1].getItem().getContainerItem(this.furnaceItemStacks[1]);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 292 */       if (isBurning() && canSmelt()) {
/*     */         
/* 294 */         this.furnaceCookTime++;
/*     */         
/* 296 */         if (this.furnaceCookTime == 150)
/*     */         {
/* 298 */           this.furnaceCookTime = 0;
/* 299 */           smeltItem();
/* 300 */           flag1 = true;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 305 */         this.furnaceCookTime = 0;
/*     */       } 
/*     */       
/* 308 */       if (flag != ((this.furnaceBurnTime > 0))) {
/*     */         
/* 310 */         flag1 = true;
/* 311 */         CrystalFurnace.updateFurnaceBlockState((this.furnaceBurnTime > 0), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
/*     */       } 
/*     */     } 
/*     */     
/* 315 */     if (flag1)
/*     */     {
/* 317 */       markDirty();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean canSmelt() {
/* 326 */     if (this.furnaceItemStacks[0] == null)
/*     */     {
/* 328 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 332 */     ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
/* 333 */     if (itemstack == null) return false; 
/* 334 */     if (this.furnaceItemStacks[2] == null) return true; 
/* 335 */     if (!this.furnaceItemStacks[2].isItemEqual(itemstack)) return false; 
/* 336 */     int result = (this.furnaceItemStacks[2]).stackSize + itemstack.stackSize;
/* 337 */     return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void smeltItem() {
/* 346 */     if (canSmelt()) {
/*     */       
/* 348 */       ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
/*     */       
/* 350 */       if (this.furnaceItemStacks[2] == null) {
/*     */         
/* 352 */         this.furnaceItemStacks[2] = itemstack.copy();
/*     */       }
/* 354 */       else if (this.furnaceItemStacks[2].isItemEqual(itemstack)) {
/*     */         
/* 356 */         (this.furnaceItemStacks[2]).stackSize += itemstack.stackSize;
/*     */       } 
/*     */       
/* 359 */       (this.furnaceItemStacks[0]).stackSize--;
/*     */       
/* 361 */       if ((this.furnaceItemStacks[0]).stackSize <= 0)
/*     */       {
/* 363 */         this.furnaceItemStacks[0] = null;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getItemBurnTime(ItemStack par0ItemStack) {
/* 374 */     if (par0ItemStack == null)
/*     */     {
/* 376 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 381 */     Item item = par0ItemStack.getItem();
/*     */     
/* 383 */     if (item instanceof net.minecraft.item.ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
/*     */       
/* 385 */       Block block = Block.getBlockFromItem(item);
/*     */       
/* 387 */       if (block == Blocks.wooden_slab)
/*     */       {
/* 389 */         return 150;
/*     */       }
/*     */       
/* 392 */       if (block.getMaterial() == Material.wood)
/*     */       {
/* 394 */         return 300;
/*     */       }
/*     */       
/* 397 */       if (block == Blocks.coal_block)
/*     */       {
/* 399 */         return 16000;
/*     */       }
/*     */     } 
/*     */     
/* 403 */     if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200; 
/* 404 */     if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200; 
/* 405 */     if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200; 
/* 406 */     if (item == Items.stick) return 100; 
/* 407 */     if (item == Items.coal) return 1600; 
/* 408 */     if (item == Items.lava_bucket) return 20000; 
/* 409 */     if (item == Item.getItemFromBlock(Blocks.sapling)) return 100; 
/* 410 */     if (item == Items.blaze_rod) return 2400; 
/* 411 */     if (item == Item.getItemFromBlock(OreSpawnMain.CrystalCoal)) return 20000; 
/* 412 */     if (item == Item.getItemFromBlock(OreSpawnMain.MyCrystalTreeLog)) return 800; 
/* 413 */     if (item == Item.getItemFromBlock(OreSpawnMain.CrystalPlanksBlock)) return 400; 
/* 414 */     return GameRegistry.getFuelValue(par0ItemStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isItemFuel(ItemStack par0ItemStack) {
/* 423 */     return (getItemBurnTime(par0ItemStack) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
/* 431 */     return (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) ? false : ((par1EntityPlayer.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void openChest() {}
/*     */ 
/*     */   
/*     */   public void closeChest() {}
/*     */ 
/*     */   
/*     */   public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
/* 443 */     return (par1 == 2) ? false : ((par1 == 1) ? isItemFuel(par2ItemStack) : true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getAccessibleSlotsFromSide(int par1) {
/* 452 */     return (par1 == 0) ? slots_bottom : ((par1 == 1) ? slots_top : slots_sides);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3) {
/* 461 */     return isItemValidForSlot(par1, par2ItemStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3) {
/* 470 */     return (par3 != 0 || par1 != 1 || par2ItemStack.getItem() == Items.bucket);
/*     */   }
/*     */   
/*     */   public void openInventory() {}
/*     */   
/*     */   public void closeInventory() {}
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\TileEntityCrystalFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */