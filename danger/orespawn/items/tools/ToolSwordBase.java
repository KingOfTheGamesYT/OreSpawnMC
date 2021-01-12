/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import danger.orespawn.util.IHasModel;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemSword;
/*    */ 
/*    */ public class ToolSwordBase
/*    */   extends ItemSword
/*    */   implements IHasModel {
/*    */   protected final OrespawnToolMaterial material;
/*    */   
/*    */   public ToolSwordBase(String name, OrespawnToolMaterial material) {
/* 15 */     super(material.Material);
/* 16 */     setUnlocalizedName(name);
/* 17 */     setRegistryName(name);
/* 18 */     this.material = material;
/* 19 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerModels() {
/* 25 */     OreSpawnMain.proxy.registerItemRenderer((Item)this, 0, "inventory");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\items\tools\ToolSwordBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */