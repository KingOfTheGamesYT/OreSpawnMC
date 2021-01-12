/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class ItemPizza
/*     */   extends Item
/*     */ {
/*     */   private Block spawnID;
/*     */   
/*     */   public ItemPizza(int par1, Block par2Block) {
/*  22 */     this.spawnID = par2Block;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/*  31 */     Block i1 = par3World.getBlock(par4, par5, par6);
/*     */     
/*  33 */     if (i1 == Blocks.snow && (par3World.getBlockMetadata(par4, par5, par6) & 0x7) < 1) {
/*     */       
/*  35 */       par7 = 1;
/*     */     }
/*  37 */     else if (i1 != Blocks.vine && i1 != Blocks.tallgrass && i1 != Blocks.deadbush) {
/*     */       
/*  39 */       if (par7 == 0)
/*     */       {
/*  41 */         par5--;
/*     */       }
/*     */       
/*  44 */       if (par7 == 1)
/*     */       {
/*  46 */         par5++;
/*     */       }
/*     */       
/*  49 */       if (par7 == 2)
/*     */       {
/*  51 */         par6--;
/*     */       }
/*     */       
/*  54 */       if (par7 == 3)
/*     */       {
/*  56 */         par6++;
/*     */       }
/*     */       
/*  59 */       if (par7 == 4)
/*     */       {
/*  61 */         par4--;
/*     */       }
/*     */       
/*  64 */       if (par7 == 5)
/*     */       {
/*  66 */         par4++;
/*     */       }
/*     */     } 
/*     */     
/*  70 */     if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
/*     */     {
/*  72 */       return false;
/*     */     }
/*  74 */     if (par1ItemStack.stackSize == 0)
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  80 */     if (par3World.canPlaceEntityOnSide(this.spawnID, par4, par5, par6, false, par7, (Entity)null, par1ItemStack)) {
/*     */ 
/*     */       
/*  83 */       int j1 = this.spawnID.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, 0);
/*     */       
/*  85 */       if (par3World.setBlock(par4, par5, par6, this.spawnID, j1, 3)) {
/*     */         
/*  87 */         if (par3World.getBlock(par4, par5, par6) == this.spawnID) {
/*     */           
/*  89 */           this.spawnID.onBlockPlacedBy(par3World, par4, par5, par6, (EntityLivingBase)par2EntityPlayer, par1ItemStack);
/*  90 */           this.spawnID.onPostBlockPlaced(par3World, par4, par5, par6, j1);
/*     */         } 
/*     */         
/*  93 */         par3World.playSoundEffect((par4 + 0.5F), (par5 + 0.5F), (par6 + 0.5F), this.spawnID.stepSound.getStepResourcePath(), (this.spawnID.stepSound.getVolume() + 1.0F) / 2.0F, this.spawnID.stepSound.getPitch() * 0.8F);
/*  94 */         par1ItemStack.stackSize--;
/*     */       } 
/*     */     } 
/*     */     
/*  98 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 105 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemPizza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */