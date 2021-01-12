/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UltimateFishingRod
/*    */   extends Item
/*    */ {
/*    */   public UltimateFishingRod(int par1) {
/* 22 */     setMaxDamage(3000);
/* 23 */     setMaxStackSize(1);
/* 24 */     setCreativeTab(CreativeTabs.tabTools);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isFull3D() {
/* 32 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 37 */     par1ItemStack.addEnchantment(Enchantment.unbreaking, 2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
/* 48 */     int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, stack);
/* 49 */     if (lvl <= 0) {
/* 50 */       stack.addEnchantment(Enchantment.unbreaking, 2);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldRotateAroundWhenRendering() {
/* 61 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 69 */     if (par3EntityPlayer.fishEntity != null) {
/*    */       
/* 71 */       int var4 = par3EntityPlayer.fishEntity.handleHookRetraction();
/* 72 */       par1ItemStack.damageItem(var4, (EntityLivingBase)par3EntityPlayer);
/* 73 */       par3EntityPlayer.swingItem();
/*    */     }
/*    */     else {
/*    */       
/* 77 */       par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
/*    */       
/* 79 */       if (!par2World.isRemote)
/*    */       {
/* 81 */         par2World.spawnEntityInWorld((Entity)new UltimateFishHook(par2World, par3EntityPlayer));
/*    */       }
/*    */       
/* 84 */       par3EntityPlayer.swingItem();
/*    */     } 
/*    */     
/* 87 */     return par1ItemStack;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 92 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\UltimateFishingRod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */