/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemZooKeeper
/*    */   extends Item
/*    */ {
/*    */   public ItemZooKeeper(int i) {
/* 26 */     setCreativeTab(CreativeTabs.tabDecorations);
/* 27 */     setMaxDamage(1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
/* 46 */     for (int var3 = 0; var3 < 8; var3++) {
/*    */       
/* 48 */       float f1 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/* 49 */       float f2 = 0.25F + player.worldObj.rand.nextFloat() * 2.0F;
/* 50 */       float f3 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/* 51 */       player.worldObj.spawnParticle("smoke", ((float)entity.posX + f1), ((float)entity.posY + f2), ((float)entity.posZ + f3), 0.0D, 0.0D, 0.0D);
/* 52 */       f1 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/* 53 */       f2 = 0.25F + player.worldObj.rand.nextFloat() * 2.0F;
/* 54 */       f3 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/* 55 */       player.worldObj.spawnParticle("explode", ((float)entity.posX + f1), ((float)entity.posY + f2), ((float)entity.posZ + f3), 0.0D, 0.0D, 0.0D);
/* 56 */       f1 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/* 57 */       f2 = 0.25F + player.worldObj.rand.nextFloat() * 2.0F;
/* 58 */       f3 = player.worldObj.rand.nextFloat() * 3.0F - player.worldObj.rand.nextFloat() * 3.0F;
/* 59 */       player.worldObj.spawnParticle("reddust", ((float)entity.posX + f1), ((float)entity.posY + f2), ((float)entity.posZ + f3), 0.0D, 0.0D, 0.0D);
/*    */     } 
/* 61 */     player.worldObj.playSoundAtEntity((Entity)player, "random.explode", 0.5F, 1.5F);
/*    */ 
/*    */     
/* 64 */     if (entity != null && entity instanceof EntityLiving) {
/* 65 */       EntityLiving e = (EntityLiving)entity;
/* 66 */       e.enablePersistence();
/*    */     } else {
/* 68 */       return false;
/*    */     } 
/*    */ 
/*    */     
/* 72 */     stack.damageItem(2, (EntityLivingBase)player);
/* 73 */     if (stack.stackSize <= 0)
/*    */     {
/* 75 */       player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
/*    */     }
/* 77 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 85 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemZooKeeper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */