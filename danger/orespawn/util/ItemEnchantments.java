/*    */ package danger.orespawn.util;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemEnchantments
/*    */ {
/* 13 */   private Map<Enchantment, Integer> enchantmentLevels = new HashMap<>();
/*    */ 
/*    */   
/*    */   public ItemEnchantments addEnchantment(Enchantment e, int level) {
/* 17 */     this.enchantmentLevels.put(e, Integer.valueOf(level));
/* 18 */     return this;
/*    */   }
/*    */   
/*    */   public Map getMap() {
/* 22 */     return this.enchantmentLevels;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespaw\\util\ItemEnchantments.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */