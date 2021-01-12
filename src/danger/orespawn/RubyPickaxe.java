/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemPickaxe;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RubyPickaxe
/*    */   extends ItemPickaxe
/*    */ {
/* 22 */   private int weaponDamage = 12;
/*    */ 
/*    */   
/*    */   public RubyPickaxe(int par1, Item.ToolMaterial par2) {
/* 26 */     super(par2);
/* 27 */     this.maxStackSize = 1;
/* 28 */     setMaxDamage(1500);
/* 29 */     setCreativeTab(CreativeTabs.tabTools);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getDamageVsEntity(Entity par1Entity) {
/* 37 */     return this.weaponDamage;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getDamageVsEntity() {
/* 42 */     return this.weaponDamage;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMaterialName() {
/* 47 */     return "Ruby";
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 52 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RubyPickaxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */