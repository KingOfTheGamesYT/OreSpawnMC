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
/*    */ 
/*    */ public class MantisClaw
/*    */   extends ItemSword
/*    */ {
/*    */   private int weaponDamage;
/*    */   private final Item.ToolMaterial toolMaterial;
/*    */   
/*    */   public MantisClaw(int par1, Item.ToolMaterial par2EnumToolMaterial) {
/* 30 */     super(par2EnumToolMaterial);
/* 31 */     this.toolMaterial = par2EnumToolMaterial;
/* 32 */     this.weaponDamage = 10;
/* 33 */     this.maxStackSize = 1;
/* 34 */     setMaxDamage(1000);
/* 35 */     setCreativeTab(CreativeTabs.tabCombat);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMaterialName() {
/* 41 */     return "AMETHYST";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
/* 49 */     int var2 = 5;
/*    */     
/* 51 */     if (par2EntityLiving != null && par3EntityLiving != null && 
/* 52 */       !par2EntityLiving.worldObj.isRemote) {
/*    */       
/* 54 */       par2EntityLiving.heal(-1.0F);
/* 55 */       par3EntityLiving.heal(1.0F);
/*    */     } 
/*    */ 
/*    */     
/* 59 */     par1ItemStack.damageItem(1, par3EntityLiving);
/* 60 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
/* 70 */     return 3000;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 76 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MantisClaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */