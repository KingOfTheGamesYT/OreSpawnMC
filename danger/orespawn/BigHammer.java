/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BigHammer
/*    */   extends ItemSword
/*    */ {
/*    */   private int weaponDamage;
/*    */   private final Item.ToolMaterial toolMaterial;
/*    */   
/*    */   public BigHammer(int par1, Item.ToolMaterial par2EnumToolMaterial) {
/* 29 */     super(par2EnumToolMaterial);
/* 30 */     this.toolMaterial = par2EnumToolMaterial;
/* 31 */     this.weaponDamage = 15;
/* 32 */     this.maxStackSize = 1;
/* 33 */     setMaxDamage(9000);
/* 34 */     setCreativeTab(CreativeTabs.tabCombat);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMaterialName() {
/* 40 */     return "AMETHYST";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
/* 48 */     int var2 = 5;
/*    */     
/* 50 */     if (par2EntityLiving != null && 
/* 51 */       !par2EntityLiving.worldObj.isRemote)
/*    */     {
/* 53 */       par2EntityLiving.addVelocity(0.0D, Math.abs(par2EntityLiving.worldObj.rand.nextFloat() * 2.0F / 3.0F), 0.0D);
/*    */     }
/*    */ 
/*    */     
/* 57 */     par1ItemStack.damageItem(1, par3EntityLiving);
/* 58 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
/* 68 */     return 3000;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 74 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BigHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */