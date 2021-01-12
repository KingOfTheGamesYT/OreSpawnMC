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
/*    */ public class ItemThunderStaff
/*    */   extends Item
/*    */ {
/* 18 */   private int ticker = 50;
/*    */ 
/*    */   
/*    */   public ItemThunderStaff(int i) {
/* 22 */     this.maxStackSize = 1;
/* 23 */     setMaxDamage(50);
/* 24 */     setCreativeTab(CreativeTabs.tabCombat);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 34 */     if (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() <= 1) {
/* 35 */       return par1ItemStack;
/*    */     }
/*    */ 
/*    */     
/* 39 */     double xzoff = 1.0D;
/* 40 */     double yoff = 1.55D;
/* 41 */     ThunderBolt lb = new ThunderBolt(par2World, (EntityLivingBase)par3EntityPlayer);
/* 42 */     lb.setLocationAndAngles(par3EntityPlayer.posX - xzoff * Math.sin(Math.toRadians((par3EntityPlayer.rotationYawHead + 45.0F))), par3EntityPlayer.posY + yoff, par3EntityPlayer.posZ + xzoff * Math.cos(Math.toRadians((par3EntityPlayer.rotationYawHead + 45.0F))), par3EntityPlayer.rotationYawHead, par3EntityPlayer.rotationPitch);
/* 43 */     lb.motionX *= 3.0D;
/* 44 */     lb.motionY *= 3.0D;
/* 45 */     lb.motionZ *= 3.0D;
/* 46 */     par2World.spawnEntityInWorld((Entity)lb);
/*    */ 
/*    */ 
/*    */     
/* 50 */     par3EntityPlayer.swingItem();
/*    */     
/* 52 */     par3EntityPlayer.addVelocity(Math.cos(Math.toRadians((par3EntityPlayer.rotationYawHead - 90.0F))) * 0.5D, 0.15D, Math.sin(Math.toRadians((par3EntityPlayer.rotationYawHead - 90.0F))) * 0.5D);
/*    */     
/* 54 */     par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityPlayer);
/* 55 */     return par1ItemStack;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onUpdate(ItemStack par1ItemStack, World world, Entity par3Entity, int par4, boolean par5) {
/* 61 */     if (world.isRaining() && 
/* 62 */       world.isThundering()) {
/* 63 */       if (this.ticker > 0) this.ticker--; 
/* 64 */       if (this.ticker <= 0 && 
/* 65 */         par1ItemStack.getItemDamage() > 0) {
/*    */         
/* 67 */         par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() - 1);
/* 68 */         this.ticker = 50;
/*    */       } 
/*    */     } 
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
/*    */   public String getMaterialName() {
/* 82 */     return "Unknown";
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 87 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemThunderStaff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */