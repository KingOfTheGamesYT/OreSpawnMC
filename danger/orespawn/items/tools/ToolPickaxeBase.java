/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import danger.orespawn.util.IHasModel;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemPickaxe;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ToolPickaxeBase
/*    */   extends ItemPickaxe
/*    */   implements IHasModel
/*    */ {
/*    */   protected final OrespawnToolMaterial material;
/*    */   
/*    */   public ToolPickaxeBase(String name, OrespawnToolMaterial material) {
/* 18 */     super(material.Material);
/* 19 */     setUnlocalizedName(name);
/* 20 */     setRegistryName(name);
/* 21 */     this.material = material;
/* 22 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 28 */     OreSpawnMain.proxy.registerItemRenderer((Item)this, 0, "inventory");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\items\tools\ToolPickaxeBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */