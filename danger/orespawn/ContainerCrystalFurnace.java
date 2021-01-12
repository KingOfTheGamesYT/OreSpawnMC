/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.inventory.SlotFurnace;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.FurnaceRecipes;
/*     */ 
/*     */ public class ContainerCrystalFurnace
/*     */   extends Container {
/*     */   private TileEntityCrystalFurnace furnace;
/*     */   private int lastCookTime;
/*     */   private int lastBurnTime;
/*     */   private int lastItemBurnTime;
/*     */   
/*     */   public ContainerCrystalFurnace(InventoryPlayer par1InventoryPlayer, TileEntityCrystalFurnace par2TileEntityCrystalFurnace) {
/*  23 */     this.furnace = par2TileEntityCrystalFurnace;
/*  24 */     addSlotToContainer(new Slot((IInventory)par2TileEntityCrystalFurnace, 0, 56, 17));
/*  25 */     addSlotToContainer(new Slot((IInventory)par2TileEntityCrystalFurnace, 1, 56, 53));
/*  26 */     addSlotToContainer((Slot)new SlotFurnace(par1InventoryPlayer.player, (IInventory)par2TileEntityCrystalFurnace, 2, 116, 35));
/*     */     
/*     */     int i;
/*  29 */     for (i = 0; i < 3; i++) {
/*     */       
/*  31 */       for (int j = 0; j < 9; j++)
/*     */       {
/*  33 */         addSlotToContainer(new Slot((IInventory)par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
/*     */       }
/*     */     } 
/*     */     
/*  37 */     for (i = 0; i < 9; i++)
/*     */     {
/*  39 */       addSlotToContainer(new Slot((IInventory)par1InventoryPlayer, i, 8 + i * 18, 142));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void addCraftingToCrafters(ICrafting par1ICrafting) {
/*  45 */     super.addCraftingToCrafters(par1ICrafting);
/*  46 */     par1ICrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
/*  47 */     par1ICrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
/*  48 */     par1ICrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void detectAndSendChanges() {
/*  56 */     super.detectAndSendChanges();
/*     */     
/*  58 */     for (int i = 0; i < this.crafters.size(); i++) {
/*     */       
/*  60 */       ICrafting icrafting = this.crafters.get(i);
/*     */       
/*  62 */       if (this.lastCookTime != this.furnace.furnaceCookTime)
/*     */       {
/*  64 */         icrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
/*     */       }
/*     */       
/*  67 */       if (this.lastBurnTime != this.furnace.furnaceBurnTime)
/*     */       {
/*  69 */         icrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
/*     */       }
/*     */       
/*  72 */       if (this.lastItemBurnTime != this.furnace.currentItemBurnTime)
/*     */       {
/*  74 */         icrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
/*     */       }
/*     */     } 
/*     */     
/*  78 */     this.lastCookTime = this.furnace.furnaceCookTime;
/*  79 */     this.lastBurnTime = this.furnace.furnaceBurnTime;
/*  80 */     this.lastItemBurnTime = this.furnace.currentItemBurnTime;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void updateProgressBar(int par1, int par2) {
/*  86 */     if (par1 == 0)
/*     */     {
/*  88 */       this.furnace.furnaceCookTime = par2;
/*     */     }
/*     */     
/*  91 */     if (par1 == 1)
/*     */     {
/*  93 */       this.furnace.furnaceBurnTime = par2;
/*     */     }
/*     */     
/*  96 */     if (par1 == 2)
/*     */     {
/*  98 */       this.furnace.currentItemBurnTime = par2;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
/* 104 */     return this.furnace.isUseableByPlayer(par1EntityPlayer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
/* 112 */     ItemStack itemstack = null;
/* 113 */     Slot slot = this.inventorySlots.get(par2);
/*     */     
/* 115 */     if (slot != null && slot.getHasStack()) {
/*     */       
/* 117 */       ItemStack itemstack1 = slot.getStack();
/* 118 */       itemstack = itemstack1.copy();
/*     */       
/* 120 */       if (par2 == 2) {
/*     */         
/* 122 */         if (!mergeItemStack(itemstack1, 3, 39, true))
/*     */         {
/* 124 */           return null;
/*     */         }
/*     */         
/* 127 */         slot.onSlotChange(itemstack1, itemstack);
/*     */       }
/* 129 */       else if (par2 != 1 && par2 != 0) {
/*     */         
/* 131 */         if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
/*     */         {
/* 133 */           if (!mergeItemStack(itemstack1, 0, 1, false))
/*     */           {
/* 135 */             return null;
/*     */           }
/*     */         }
/* 138 */         else if (TileEntityCrystalFurnace.isItemFuel(itemstack1))
/*     */         {
/* 140 */           if (!mergeItemStack(itemstack1, 1, 2, false))
/*     */           {
/* 142 */             return null;
/*     */           }
/*     */         }
/* 145 */         else if (par2 >= 3 && par2 < 30)
/*     */         {
/* 147 */           if (!mergeItemStack(itemstack1, 30, 39, false))
/*     */           {
/* 149 */             return null;
/*     */           }
/*     */         }
/* 152 */         else if (par2 >= 30 && par2 < 39 && !mergeItemStack(itemstack1, 3, 30, false))
/*     */         {
/* 154 */           return null;
/*     */         }
/*     */       
/* 157 */       } else if (!mergeItemStack(itemstack1, 3, 39, false)) {
/*     */         
/* 159 */         return null;
/*     */       } 
/*     */       
/* 162 */       if (itemstack1.stackSize == 0) {
/*     */         
/* 164 */         slot.putStack((ItemStack)null);
/*     */       }
/*     */       else {
/*     */         
/* 168 */         slot.onSlotChanged();
/*     */       } 
/*     */       
/* 171 */       if (itemstack1.stackSize == itemstack.stackSize)
/*     */       {
/* 173 */         return null;
/*     */       }
/*     */       
/* 176 */       slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
/*     */     } 
/*     */     
/* 179 */     return itemstack;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ContainerCrystalFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */