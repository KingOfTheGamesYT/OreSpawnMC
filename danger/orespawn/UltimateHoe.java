/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemHoe;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UltimateHoe
/*     */   extends ItemHoe
/*     */ {
/*     */   public UltimateHoe(int par1, Item.ToolMaterial par2) {
/*  28 */     super(par2);
/*  29 */     this.maxStackSize = 1;
/*  30 */     setMaxDamage(3000);
/*  31 */     setCreativeTab(CreativeTabs.tabTools);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  36 */     par1ItemStack.addEnchantment(Enchantment.efficiency, 2);
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
/*  47 */     int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, stack);
/*  48 */     if (lvl <= 0) {
/*  49 */       stack.addEnchantment(Enchantment.efficiency, 2);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
/*  54 */     onUsingTick(stack, (EntityPlayer)null, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/*  63 */     if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  69 */     Block i1 = par3World.getBlock(par4, par5, par6);
/*  70 */     boolean air = par3World.isAirBlock(par4, par5 + 1, par6);
/*     */     
/*  72 */     if (par7 != 0 && air && (i1 == Blocks.grass || i1 == Blocks.dirt)) {
/*     */       
/*  74 */       Block block = Blocks.farmland;
/*  75 */       par3World.playSoundEffect((par4 + 0.5F), (par5 + 0.5F), (par6 + 0.5F), block.stepSound.getBreakSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
/*     */       
/*  77 */       if (par3World.isRemote)
/*     */       {
/*  79 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  84 */       for (int i = -1; i <= 1; i++) {
/*  85 */         for (int k = -1; k <= 1; k++) {
/*  86 */           for (int j = -1; j <= 1; j++) {
/*  87 */             i1 = par3World.getBlock(par4 + i, par5 + j, par6 + k);
/*  88 */             air = par3World.isAirBlock(par4 + i, par5 + j + 1, par6 + k);
/*  89 */             if (air && (i1 == Blocks.grass || i1 == Blocks.dirt)) {
/*  90 */               par3World.setBlock(par4 + i, par5 + j, par6 + k, block, 7, 2);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  96 */       par1ItemStack.damageItem(1, (EntityLivingBase)par2EntityPlayer);
/*  97 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMaterialName() {
/* 110 */     return "Uranium/Titanium";
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 115 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\UltimateHoe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */