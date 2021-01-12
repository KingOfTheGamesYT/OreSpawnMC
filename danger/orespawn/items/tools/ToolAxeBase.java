/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import danger.orespawn.util.IHasModel;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemAxe;
/*    */ 
/*    */ public class ToolAxeBase
/*    */   extends ItemAxe
/*    */   implements IHasModel {
/*    */   protected final OrespawnToolMaterial material;
/*    */   
/*    */   public ToolAxeBase(String name, OrespawnToolMaterial material) {
/* 15 */     super(material.Material, material.Damage, -3.0F);
/*    */     
/* 17 */     setUnlocalizedName(name);
/* 18 */     setRegistryName(name);
/* 19 */     this.material = material;
/* 20 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 26 */     OreSpawnMain.proxy.registerItemRenderer((Item)this, 0, "inventory");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\items\tools\ToolAxeBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */