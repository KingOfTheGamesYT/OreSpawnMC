/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemCreeperLauncher
/*    */   extends Item
/*    */ {
/*    */   public ItemCreeperLauncher(int i) {
/* 22 */     setCreativeTab(CreativeTabs.tabRedstone);
/* 23 */     setMaxDamage(1);
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
/*    */   public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
/* 40 */     if (entity != null && entity instanceof net.minecraft.entity.monster.EntityCreeper) {
/*    */       
/* 42 */       for (int var3 = 0; var3 < 6; var3++) {
/*    */         
/* 44 */         float f1 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
/* 45 */         float f2 = 0.25F + player.worldObj.rand.nextFloat() * 6.0F;
/* 46 */         float f3 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
/* 47 */         player.worldObj.spawnParticle("smoke", ((float)entity.posX + f1), ((float)entity.posY + f2), ((float)entity.posZ + f3), 0.0D, (f2 / 4.0F), 0.0D);
/* 48 */         f1 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
/* 49 */         f2 = 0.25F + player.worldObj.rand.nextFloat() * 6.0F;
/* 50 */         f3 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
/* 51 */         player.worldObj.spawnParticle("explode", ((float)entity.posX + f1), ((float)entity.posY + f2), ((float)entity.posZ + f3), 0.0D, (f2 / 4.0F), 0.0D);
/* 52 */         f1 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
/* 53 */         f2 = 0.25F + player.worldObj.rand.nextFloat() * 6.0F;
/* 54 */         f3 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
/* 55 */         player.worldObj.spawnParticle("reddust", ((float)entity.posX + f1), ((float)entity.posY + f2), ((float)entity.posZ + f3), 0.0D, (f2 / 4.0F), 0.0D);
/*    */       } 
/* 57 */       player.worldObj.playSoundAtEntity((Entity)player, "fireworks.launch", 2.0F, 1.2F);
/*    */       
/* 59 */       EntityLiving e = (EntityLiving)entity;
/* 60 */       e.addVelocity(0.0D, 4.5D, 0.0D);
/*    */     } else {
/* 62 */       return false;
/*    */     } 
/*    */     
/* 65 */     if (!player.capabilities.isCreativeMode)
/*    */     {
/* 67 */       stack.stackSize--;
/*    */     }
/* 69 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 75 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemCreeperLauncher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */