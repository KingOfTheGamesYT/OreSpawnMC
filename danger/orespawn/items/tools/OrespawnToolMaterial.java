/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.common.util.EnumHelper;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OrespawnToolMaterial
/*    */ {
/*    */   public final String Name;
/*    */   public final int HarvestLevel;
/*    */   public final int Durability;
/*    */   public final float Efficiency;
/*    */   public final float Damage;
/*    */   public final int Enchantability;
/*    */   public final Item.ToolMaterial Material;
/*    */   
/*    */   public OrespawnToolMaterial(String name, int harvestLevel, int durability, float efficiency, float damage, int enchantability) {
/* 19 */     this.Name = name;
/* 20 */     this.HarvestLevel = harvestLevel;
/* 21 */     this.Durability = durability;
/* 22 */     this.Efficiency = efficiency;
/* 23 */     this.Damage = damage;
/* 24 */     this.Enchantability = enchantability;
/* 25 */     this.Material = EnumHelper.addToolMaterial(this.Name, this.HarvestLevel, this.Durability, this.Efficiency, this.Damage, this.Enchantability);
/*    */   }
/*    */   
/* 28 */   public static OrespawnToolMaterial UltimateTools = new OrespawnToolMaterial("ultimate", 10, 3000, 15.0F, 36.0F, 100);
/* 29 */   public static OrespawnToolMaterial EmeraldTools = new OrespawnToolMaterial("emerald", 2, 1000, 6.5F, 3.0F, 12);
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\items\tools\OrespawnToolMaterial.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */