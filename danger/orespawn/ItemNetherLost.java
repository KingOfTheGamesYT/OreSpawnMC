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
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
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
/*     */ public class ItemNetherLost
/*     */   extends Item
/*     */ {
/*     */   public ItemNetherLost(int par1) {
/*  32 */     this.maxStackSize = 1;
/*  33 */     setMaxDamage(3000);
/*  34 */     setCreativeTab(CreativeTabs.tabDecorations);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  39 */     par1ItemStack.addEnchantment(Enchantment.sharpness, 2);
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
/*     */   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
/*  51 */     int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, stack);
/*  52 */     if (lvl <= 0) {
/*  53 */       stack.addEnchantment(Enchantment.sharpness, 2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
/*  62 */     EntityLivingBase e = null;
/*  63 */     EntityPlayer p = null;
/*     */     
/*  65 */     onUsingTick(stack, (EntityPlayer)null, 0);
/*  66 */     if (par2World == null)
/*     */       return; 
/*  68 */     if (par3Entity != null && 
/*  69 */       par3Entity instanceof EntityLivingBase) {
/*  70 */       e = (EntityLivingBase)par3Entity;
/*     */       
/*  72 */       if (e instanceof EntityPlayer) {
/*  73 */         p = (EntityPlayer)e;
/*  74 */         ItemStack is = p.getCurrentEquippedItem();
/*  75 */         if (is != null) {
/*  76 */           Item it = is.getItem();
/*  77 */           if (it != null)
/*     */           {
/*  79 */             if (it instanceof ItemNetherLost && 
/*  80 */               par2World.provider.dimensionId == -1) {
/*  81 */               Block i = par2World.getBlock((int)p.posX, (int)p.posY - 1, (int)p.posZ);
/*  82 */               if (i == Blocks.netherrack) {
/*  83 */                 par2World.setBlock((int)p.posX, (int)p.posY - 1, (int)p.posZ, Blocks.quartz_block);
/*     */               }
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
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
/*     */   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
/* 101 */     return 3000;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 107 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemNetherLost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */