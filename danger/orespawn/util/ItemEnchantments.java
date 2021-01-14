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
/*    */ 
/*    */ 
/*    */ public class ItemEnchantments
/*    */ {
/* 15 */   private Map<Enchantment, Integer> enchantmentLevels = new HashMap<>();
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemEnchantments addEnchantment(Enchantment e, int level) {
/* 20 */     this.enchantmentLevels.put(e, Integer.valueOf(level));
/* 21 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public Map getMap() {
/* 26 */     return this.enchantmentLevels;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespaw\\util\ItemEnchantments.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */