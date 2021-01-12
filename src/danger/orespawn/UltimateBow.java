/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UltimateBow
/*     */   extends Item
/*     */ {
/*     */   public UltimateBow(int par1) {
/*  26 */     this.maxStackSize = 1;
/*  27 */     setMaxDamage(1000);
/*  28 */     setCreativeTab(CreativeTabs.tabCombat);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  33 */     par1ItemStack.addEnchantment(Enchantment.power, 5);
/*  34 */     par1ItemStack.addEnchantment(Enchantment.flame, 3);
/*  35 */     par1ItemStack.addEnchantment(Enchantment.punch, 2);
/*  36 */     par1ItemStack.addEnchantment(Enchantment.infinity, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
/*  47 */     int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack);
/*  48 */     if (lvl <= 0) {
/*  49 */       stack.addEnchantment(Enchantment.power, 5);
/*  50 */       stack.addEnchantment(Enchantment.flame, 3);
/*  51 */       stack.addEnchantment(Enchantment.punch, 2);
/*  52 */       stack.addEnchantment(Enchantment.infinity, 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
/*  71 */     EntityArrow var8 = new UltimateArrow(par2World, par3EntityPlayer, 3.0F);
/*     */ 
/*     */     
/*  74 */     if (par2World.rand.nextInt(4) == 1) var8.setIsCritical(true);
/*     */ 
/*     */     
/*  77 */     int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
/*  78 */     if (var10 > 0)
/*     */     {
/*  80 */       var8.setKnockbackStrength(var10);
/*     */     }
/*     */     
/*  83 */     if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
/*     */     {
/*  85 */       var8.setFire(100);
/*     */     }
/*     */     
/*  88 */     par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityPlayer);
/*  89 */     par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F);
/*     */     
/*  91 */     var8.canBePickedUp = 2;
/*     */     
/*  93 */     if (!par2World.isRemote)
/*     */     {
/*  95 */       par2World.spawnEntityInWorld((Entity)var8);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 101 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
/* 109 */     return 9000;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumAction getItemUseAction(ItemStack par1ItemStack) {
/* 117 */     return EnumAction.bow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 132 */     par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
/*     */     
/* 134 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getItemEnchantability() {
/* 142 */     return 50;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 147 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\UltimateBow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */