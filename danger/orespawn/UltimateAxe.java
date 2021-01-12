/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemAxe;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class UltimateAxe
/*    */   extends ItemAxe
/*    */ {
/* 21 */   private int weaponDamage = 15;
/*    */ 
/*    */   
/*    */   public UltimateAxe(int par1, Item.ToolMaterial par2) {
/* 25 */     super(par2);
/* 26 */     this.maxStackSize = 1;
/* 27 */     setMaxDamage(3000);
/* 28 */     setCreativeTab(CreativeTabs.tabTools);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 33 */     par1ItemStack.addEnchantment(Enchantment.efficiency, 5);
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
/* 44 */     int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, stack);
/* 45 */     if (lvl <= 0) {
/* 46 */       stack.addEnchantment(Enchantment.efficiency, 5);
/*    */     }
/*    */   }
/*    */   
/*    */   public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
/* 51 */     onUsingTick(stack, (EntityPlayer)null, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
/* 56 */     if (entity != null && OreSpawnMain.ultimate_sword_pvp == 0) {
/* 57 */       if (entity instanceof EntityPlayer || entity instanceof Girlfriend || entity instanceof Boyfriend) {
/* 58 */         return true;
/*    */       }
/* 60 */       if (entity instanceof EntityTameable) {
/* 61 */         EntityTameable t = (EntityTameable)entity;
/* 62 */         if (t.isTamed()) {
/* 63 */           return true;
/*    */         }
/*    */       } 
/*    */     } 
/* 67 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getDamageVsEntity(Entity par1Entity) {
/* 75 */     if (par1Entity instanceof Girlfriend) {
/* 76 */       return 1;
/*    */     }
/* 78 */     if (par1Entity instanceof EntityPlayer) {
/* 79 */       return 1;
/*    */     }
/* 81 */     return this.weaponDamage;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMaterialName() {
/* 87 */     return "Uranium/Titanium";
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 92 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\UltimateAxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */