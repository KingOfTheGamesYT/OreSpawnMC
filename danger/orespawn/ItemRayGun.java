/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class ItemRayGun
/*    */   extends Item
/*    */ {
/*    */   public ItemRayGun(int i) {
/* 19 */     this.maxStackSize = 1;
/* 20 */     setMaxDamage(50);
/* 21 */     setCreativeTab(CreativeTabs.tabCombat);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 31 */     if (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() <= 1) {
/* 32 */       return par1ItemStack;
/*    */     }
/*    */     
/* 35 */     par2World.playSoundAtEntity((Entity)par3EntityPlayer, "fireworks.launch", 3.5F, 0.5F);
/*    */     
/* 37 */     if (!par2World.isRemote) {
/*    */       
/* 39 */       double xzoff = 1.0D;
/* 40 */       double yoff = 1.55D;
/* 41 */       LaserBall lb = new LaserBall(par2World, (EntityLivingBase)par3EntityPlayer);
/* 42 */       lb.setSpecial();
/* 43 */       lb.setLocationAndAngles(par3EntityPlayer.posX - xzoff * Math.sin(Math.toRadians((par3EntityPlayer.rotationYawHead + 45.0F))), par3EntityPlayer.posY + yoff, par3EntityPlayer.posZ + xzoff * Math.cos(Math.toRadians((par3EntityPlayer.rotationYawHead + 45.0F))), par3EntityPlayer.rotationYawHead, par3EntityPlayer.rotationPitch);
/* 44 */       lb.motionX *= 3.0D;
/* 45 */       lb.motionY *= 3.0D;
/* 46 */       lb.motionZ *= 3.0D;
/* 47 */       par2World.spawnEntityInWorld((Entity)lb);
/*    */     } 
/*    */ 
/*    */     
/* 51 */     par3EntityPlayer.swingItem();
/*    */     
/* 53 */     par3EntityPlayer.addVelocity(Math.cos(Math.toRadians((par3EntityPlayer.rotationYawHead - 90.0F))) * 1.5D, 0.3D, Math.sin(Math.toRadians((par3EntityPlayer.rotationYawHead - 90.0F))) * 1.5D);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 62 */     par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityPlayer);
/* 63 */     return par1ItemStack;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMaterialName() {
/* 72 */     return "Unknown";
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 77 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemRayGun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */