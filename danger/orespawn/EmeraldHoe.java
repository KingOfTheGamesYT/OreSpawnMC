/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemHoe;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EmeraldHoe
/*    */   extends ItemHoe
/*    */ {
/*    */   public EmeraldHoe(int par1, Item.ToolMaterial par2) {
/* 23 */     super(par2);
/* 24 */     this.maxStackSize = 1;
/* 25 */     setMaxDamage(1300);
/* 26 */     setCreativeTab(CreativeTabs.tabTools);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getDamageVsEntity(Entity par1Entity) {
/* 34 */     return 5;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMaterialName() {
/* 39 */     return "Emerald";
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 44 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EmeraldHoe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */