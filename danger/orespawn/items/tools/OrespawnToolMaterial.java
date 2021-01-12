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
/*    */   public final int Efficiency;
/*    */   public final int Damage;
/*    */   public final int Enchantability;
/*    */   public final Item.ToolMaterial Material;
/*    */   
/*    */   public OrespawnToolMaterial(String name, int harvestLevel, int durability, int efficiency, int damage, int enchantability) {
/* 21 */     this.Name = name;
/* 22 */     this.HarvestLevel = harvestLevel;
/* 23 */     this.Durability = durability;
/* 24 */     this.Efficiency = efficiency;
/* 25 */     this.Damage = damage;
/* 26 */     this.Enchantability = enchantability;
/* 27 */     this.Material = EnumHelper.addToolMaterial(this.Name, this.HarvestLevel, this.Durability, this.Efficiency, this.Damage, this.Enchantability);
/*    */   }
/*    */   
/* 30 */   public static OrespawnToolMaterial UltimateTools = new OrespawnToolMaterial("ultimate", 10, 3000, 15, 36, 100);
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\items\tools\OrespawnToolMaterial.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */