/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.common.util.EnumHelper;
/*    */ 
/*    */ 
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
/* 21 */     this.Name = name;
/* 22 */     this.HarvestLevel = harvestLevel;
/* 23 */     this.Durability = durability;
/* 24 */     this.Efficiency = efficiency;
/* 25 */     this.Damage = damage;
/* 26 */     this.Enchantability = enchantability;
/* 27 */     this.Material = EnumHelper.addToolMaterial(this.Name, this.HarvestLevel, this.Durability, this.Efficiency, this.Damage, this.Enchantability);
/*    */   }
/*    */   
/* 30 */   public static OrespawnToolMaterial UltimateTools = new OrespawnToolMaterial("ultimate", 10, 3000, 15.0F, 36.0F, 100);
/* 31 */   public static OrespawnToolMaterial EmeraldTools = new OrespawnToolMaterial("emerald", 2, 1000, 6.5F, 3.0F, 12);
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\items\tools\OrespawnToolMaterial.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */