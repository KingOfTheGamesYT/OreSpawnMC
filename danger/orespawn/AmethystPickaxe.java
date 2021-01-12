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
/*    */ public class AmethystPickaxe
/*    */   extends ItemPickaxe
/*    */ {
/* 21 */   private int weaponDamage = 12;
/*    */ 
/*    */   
/*    */   public AmethystPickaxe(int par1, Item.ToolMaterial par2) {
/* 25 */     super(par2);
/* 26 */     this.maxStackSize = 1;
/* 27 */     setMaxDamage(2000);
/* 28 */     setCreativeTab(CreativeTabs.tabTools);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getDamageVsEntity(Entity par1Entity) {
/* 36 */     return this.weaponDamage;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getDamageVsEntity() {
/* 41 */     return this.weaponDamage;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMaterialName() {
/* 46 */     return "Amethyst";
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 51 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\AmethystPickaxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */