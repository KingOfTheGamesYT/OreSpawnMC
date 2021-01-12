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
/*    */ 
/*    */ public class RubySword
/*    */   extends ItemSword
/*    */ {
/*    */   private int weaponDamage;
/*    */   private final Item.ToolMaterial toolMaterial;
/*    */   
/*    */   public RubySword(int par1, Item.ToolMaterial par2EnumToolMaterial) {
/* 28 */     super(par2EnumToolMaterial);
/* 29 */     this.toolMaterial = par2EnumToolMaterial;
/* 30 */     this.weaponDamage = 18;
/* 31 */     this.maxStackSize = 1;
/* 32 */     setMaxDamage(1500);
/* 33 */     setCreativeTab(CreativeTabs.tabCombat);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getDamageVsEntity(Entity par1Entity) {
/* 42 */     return this.weaponDamage;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMaterialName() {
/* 48 */     return "Ruby";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) {
/* 53 */     par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityLiving);
/* 54 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
/* 62 */     return 4000;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 68 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RubySword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */