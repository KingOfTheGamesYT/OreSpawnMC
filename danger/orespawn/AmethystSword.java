/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.ItemSword;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AmethystSword
/*    */   extends ItemSword
/*    */ {
/*    */   private int weaponDamage;
/*    */   private final Item.ToolMaterial toolMaterial;
/*    */   
/*    */   public AmethystSword(int par1, Item.ToolMaterial par2EnumToolMaterial) {
/* 27 */     super(par2EnumToolMaterial);
/* 28 */     this.toolMaterial = par2EnumToolMaterial;
/* 29 */     this.weaponDamage = 18;
/* 30 */     this.maxStackSize = 1;
/* 31 */     setMaxDamage(2000);
/* 32 */     setCreativeTab(CreativeTabs.tabCombat);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getDamageVsEntity(Entity par1Entity) {
/* 41 */     return this.weaponDamage;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMaterialName() {
/* 47 */     return "Amethyst";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) {
/* 52 */     par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityLiving);
/* 53 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
/* 61 */     return 3500;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 67 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\AmethystSword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */