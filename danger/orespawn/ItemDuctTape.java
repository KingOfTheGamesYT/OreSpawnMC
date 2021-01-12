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
/*     */ 
/*     */ public class ItemDuctTape
/*     */   extends Item
/*     */ {
/*     */   private Block block;
/*     */   
/*     */   public ItemDuctTape(int par1, Block par2Block) {
/*  23 */     this.block = par2Block;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/*  32 */     Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
/*     */     
/*  34 */     if (block == Blocks.snow_layer && (p_77648_3_.getBlockMetadata(p_77648_4_, p_77648_5_, p_77648_6_) & 0x7) < 1) {
/*     */       
/*  36 */       p_77648_7_ = 1;
/*     */     }
/*  38 */     else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush) {
/*     */       
/*  40 */       if (p_77648_7_ == 0)
/*     */       {
/*  42 */         p_77648_5_--;
/*     */       }
/*     */       
/*  45 */       if (p_77648_7_ == 1)
/*     */       {
/*  47 */         p_77648_5_++;
/*     */       }
/*     */       
/*  50 */       if (p_77648_7_ == 2)
/*     */       {
/*  52 */         p_77648_6_--;
/*     */       }
/*     */       
/*  55 */       if (p_77648_7_ == 3)
/*     */       {
/*  57 */         p_77648_6_++;
/*     */       }
/*     */       
/*  60 */       if (p_77648_7_ == 4)
/*     */       {
/*  62 */         p_77648_4_--;
/*     */       }
/*     */       
/*  65 */       if (p_77648_7_ == 5)
/*     */       {
/*  67 */         p_77648_4_++;
/*     */       }
/*     */     } 
/*     */     
/*  71 */     if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_))
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     if (p_77648_1_.stackSize == 0)
/*     */     {
/*  77 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  81 */     if (p_77648_3_.canPlaceEntityOnSide(this.block, p_77648_4_, p_77648_5_, p_77648_6_, false, p_77648_7_, (Entity)null, p_77648_1_)) {
/*     */       
/*  83 */       int i1 = this.block.onBlockPlaced(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, 0);
/*     */       
/*  85 */       if (p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, this.block, i1, 3)) {
/*     */         
/*  87 */         if (p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == this.block) {
/*     */           
/*  89 */           this.block.onBlockPlacedBy(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, (EntityLivingBase)p_77648_2_, p_77648_1_);
/*  90 */           this.block.onPostBlockPlaced(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, i1);
/*     */         } 
/*     */         
/*  93 */         p_77648_3_.playSoundEffect((p_77648_4_ + 0.5F), (p_77648_5_ + 0.5F), (p_77648_6_ + 0.5F), this.block.stepSound.func_150496_b(), (this.block.stepSound.getVolume() + 1.0F) / 2.0F, this.block.stepSound.getPitch() * 0.8F);
/*  94 */         p_77648_1_.stackSize--;
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


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemDuctTape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */