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
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SkateBow
/*     */   extends Item
/*     */ {
/*     */   public SkateBow(int par1) {
/*  26 */     this.maxStackSize = 1;
/*  27 */     setMaxDamage(300);
/*  28 */     setCreativeTab(CreativeTabs.tabCombat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
/*  52 */     int var6 = getMaxItemUseDuration(par1ItemStack) - par4;
/*     */     
/*  54 */     boolean flag = (par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0);
/*     */     
/*  56 */     if (flag || par3EntityPlayer.inventory.hasItem(OreSpawnMain.MyIrukandjiArrow)) {
/*     */ 
/*     */       
/*  59 */       float f = var6 / 20.0F;
/*  60 */       f = (f * f + f * 2.0F) / 3.0F;
/*     */       
/*  62 */       if (f < 0.1D) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/*  67 */       if (f > 1.75F)
/*     */       {
/*  69 */         f = 1.75F;
/*     */       }
/*     */ 
/*     */       
/*  73 */       IrukandjiArrow var8 = new IrukandjiArrow(par2World, par3EntityPlayer, f);
/*     */ 
/*     */       
/*  76 */       if (par2World.rand.nextInt(20) == 1) var8.setIsCritical(true);
/*     */ 
/*     */       
/*  79 */       int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
/*  80 */       if (var10 > 0)
/*     */       {
/*  82 */         var8.setKnockbackStrength(var10);
/*     */       }
/*     */       
/*  85 */       if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
/*     */       {
/*  87 */         var8.setFire(100);
/*     */       }
/*     */       
/*  90 */       par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityPlayer);
/*  91 */       par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F);
/*     */       
/*  93 */       if (!flag) {
/*  94 */         par3EntityPlayer.inventory.consumeInventoryItem(OreSpawnMain.MyIrukandjiArrow);
/*     */       }
/*     */       
/*  97 */       if (!par2World.isRemote)
/*     */       {
/*  99 */         par2World.spawnEntityInWorld((Entity)var8);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 106 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
/* 114 */     return 9000;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumAction getItemUseAction(ItemStack par1ItemStack) {
/* 122 */     return EnumAction.bow;
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
/* 137 */     par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
/*     */     
/* 139 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getItemEnchantability() {
/* 147 */     return 50;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 152 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\SkateBow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */