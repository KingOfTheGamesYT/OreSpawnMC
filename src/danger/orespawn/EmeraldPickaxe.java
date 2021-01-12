/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemPickaxe;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EmeraldPickaxe
/*    */   extends ItemPickaxe
/*    */ {
/* 22 */   private int weaponDamage = 10;
/*    */ 
/*    */   
/*    */   public EmeraldPickaxe(int par1, Item.ToolMaterial par2) {
/* 26 */     super(par2);
/* 27 */     this.maxStackSize = 1;
/* 28 */     setMaxDamage(1300);
/* 29 */     setCreativeTab(CreativeTabs.tabTools);
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
/* 40 */     int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, stack);
/* 41 */     if (lvl <= 0) {
/* 42 */       stack.addEnchantment(Enchantment.silkTouch, 1);
/*    */     }
/*    */   }
/*    */   
/*    */   public void onUpdate(ItemStack stack, World par2World, Entity par3Entity, int par4, boolean par5) {
/* 47 */     onUsingTick(stack, (EntityPlayer)null, 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getDamageVsEntity(Entity par1Entity) {
/* 55 */     return this.weaponDamage;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getDamageVsEntity() {
/* 60 */     return this.weaponDamage;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMaterialName() {
/* 65 */     return "Emerald";
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 70 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EmeraldPickaxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */