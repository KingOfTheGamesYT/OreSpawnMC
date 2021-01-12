/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.ItemSword;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NightmareSword
/*    */   extends ItemSword
/*    */ {
/*    */   public NightmareSword(int par1, Item.ToolMaterial par2EnumToolMaterial) {
/* 28 */     super(par2EnumToolMaterial);
/*    */     
/* 30 */     this.maxStackSize = 1;
/* 31 */     setMaxDamage(1200);
/* 32 */     setCreativeTab(CreativeTabs.tabCombat);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 37 */     par1ItemStack.addEnchantment(Enchantment.sharpness, 1);
/* 38 */     par1ItemStack.addEnchantment(Enchantment.knockback, 3);
/* 39 */     par1ItemStack.addEnchantment(Enchantment.fireAspect, 1);
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
/*    */   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
/* 51 */     int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, stack);
/* 52 */     if (lvl <= 0) {
/* 53 */       stack.addEnchantment(Enchantment.sharpness, 1);
/* 54 */       stack.addEnchantment(Enchantment.knockback, 3);
/* 55 */       stack.addEnchantment(Enchantment.fireAspect, 1);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
/* 60 */     onUsingTick(stack, (EntityPlayer)null, 0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMaterialName() {
/* 66 */     return "Uranium/Titanium";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) {
/* 71 */     par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityLiving);
/* 72 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
/* 80 */     return 5000;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 85 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\NightmareSword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */