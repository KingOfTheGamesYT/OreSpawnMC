/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryCraftResult;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.inventory.SlotCrafting;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.CraftingManager;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class ContainerCrystalWorkbench
/*     */   extends Container
/*     */ {
/*  19 */   public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
/*  20 */   public IInventory craftResult = (IInventory)new InventoryCraftResult();
/*     */   
/*     */   private World worldObj;
/*     */   private int posX;
/*     */   private int posY;
/*     */   private int posZ;
/*     */   
/*     */   public ContainerCrystalWorkbench(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
/*  28 */     this.worldObj = par2World;
/*  29 */     this.posX = par3;
/*  30 */     this.posY = par4;
/*  31 */     this.posZ = par5;
/*  32 */     addSlotToContainer((Slot)new SlotCrafting(par1InventoryPlayer.player, (IInventory)this.craftMatrix, this.craftResult, 0, 124, 35));
/*     */     
/*     */     int l;
/*     */     
/*  36 */     for (l = 0; l < 3; l++) {
/*     */       
/*  38 */       for (int i1 = 0; i1 < 3; i1++)
/*     */       {
/*  40 */         addSlotToContainer(new Slot((IInventory)this.craftMatrix, i1 + l * 3, 30 + i1 * 18, 17 + l * 18));
/*     */       }
/*     */     } 
/*     */     
/*  44 */     for (l = 0; l < 3; l++) {
/*     */       
/*  46 */       for (int i1 = 0; i1 < 9; i1++)
/*     */       {
/*  48 */         addSlotToContainer(new Slot((IInventory)par1InventoryPlayer, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
/*     */       }
/*     */     } 
/*     */     
/*  52 */     for (l = 0; l < 9; l++)
/*     */     {
/*  54 */       addSlotToContainer(new Slot((IInventory)par1InventoryPlayer, l, 8 + l * 18, 142));
/*     */     }
/*     */     
/*  57 */     onCraftMatrixChanged((IInventory)this.craftMatrix);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCraftMatrixChanged(IInventory par1IInventory) {
/*  65 */     this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onContainerClosed(EntityPlayer par1EntityPlayer) {
/*  73 */     super.onContainerClosed(par1EntityPlayer);
/*     */     
/*  75 */     if (!this.worldObj.isRemote)
/*     */     {
/*  77 */       for (int i = 0; i < 9; i++) {
/*     */         
/*  79 */         ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);
/*     */         
/*  81 */         if (itemstack != null)
/*     */         {
/*  83 */           par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
/*  91 */     return (this.worldObj.getBlock(this.posX, this.posY, this.posZ) != OreSpawnMain.CrystalWorkbenchBlock) ? false : ((par1EntityPlayer.getDistanceSq(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D) <= 64.0D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
/*  99 */     ItemStack itemstack = null;
/* 100 */     Slot slot = this.inventorySlots.get(par2);
/*     */     
/* 102 */     if (slot != null && slot.getHasStack()) {
/*     */       
/* 104 */       ItemStack itemstack1 = slot.getStack();
/* 105 */       itemstack = itemstack1.copy();
/*     */       
/* 107 */       if (par2 == 0) {
/*     */         
/* 109 */         if (!mergeItemStack(itemstack1, 10, 46, true))
/*     */         {
/* 111 */           return null;
/*     */         }
/*     */         
/* 114 */         slot.onSlotChange(itemstack1, itemstack);
/*     */       }
/* 116 */       else if (par2 >= 10 && par2 < 37) {
/*     */         
/* 118 */         if (!mergeItemStack(itemstack1, 37, 46, false))
/*     */         {
/* 120 */           return null;
/*     */         }
/*     */       }
/* 123 */       else if (par2 >= 37 && par2 < 46) {
/*     */         
/* 125 */         if (!mergeItemStack(itemstack1, 10, 37, false))
/*     */         {
/* 127 */           return null;
/*     */         }
/*     */       }
/* 130 */       else if (!mergeItemStack(itemstack1, 10, 46, false)) {
/*     */         
/* 132 */         return null;
/*     */       } 
/*     */       
/* 135 */       if (itemstack1.stackSize == 0) {
/*     */         
/* 137 */         slot.putStack((ItemStack)null);
/*     */       }
/*     */       else {
/*     */         
/* 141 */         slot.onSlotChanged();
/*     */       } 
/*     */       
/* 144 */       if (itemstack1.stackSize == itemstack.stackSize)
/*     */       {
/* 146 */         return null;
/*     */       }
/*     */       
/* 149 */       slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
/*     */     } 
/*     */     
/* 152 */     return itemstack;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canMergeSlot(ItemStack par1ItemStack, Slot par2Slot) {
/* 157 */     return (par2Slot.inventory != this.craftResult && super.canMergeSlot(par1ItemStack, par2Slot));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ContainerCrystalWorkbench.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */