/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.ItemSword;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PoisonSword
/*    */   extends ItemSword
/*    */ {
/*    */   private int weaponDamage;
/*    */   private final Item.ToolMaterial toolMaterial;
/*    */   
/*    */   public PoisonSword(int par1, Item.ToolMaterial par2EnumToolMaterial) {
/* 29 */     super(par2EnumToolMaterial);
/* 30 */     this.toolMaterial = par2EnumToolMaterial;
/* 31 */     this.weaponDamage = 15;
/* 32 */     this.maxStackSize = 1;
/* 33 */     setMaxDamage(1300);
/* 34 */     setCreativeTab(CreativeTabs.tabCombat);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 39 */     par1ItemStack.addEnchantment(Enchantment.sharpness, 1);
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
/* 50 */     int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, stack);
/* 51 */     if (lvl <= 0) {
/* 52 */       stack.addEnchantment(Enchantment.sharpness, 1);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMaterialName() {
/* 60 */     return "Emerald";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
/* 67 */     int var2 = 5;
/*    */     
/* 69 */     if (par2EntityLiving != null) {
/* 70 */       var2 = 10 + par2EntityLiving.worldObj.rand.nextInt(10);
/* 71 */       par2EntityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, var2 * 20, 0));
/* 72 */       var2 = 10 + par2EntityLiving.worldObj.rand.nextInt(10);
/* 73 */       par2EntityLiving.addPotionEffect(new PotionEffect(Potion.wither.id, var2 * 20, 0));
/* 74 */       var2 = 10 + par2EntityLiving.worldObj.rand.nextInt(10);
/* 75 */       par2EntityLiving.addPotionEffect(new PotionEffect(Potion.weakness.id, var2 * 20, 0));
/*    */     } 
/*    */     
/* 78 */     par1ItemStack.damageItem(1, par3EntityLiving);
/* 79 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
/* 87 */     return 3000;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 93 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\PoisonSword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */