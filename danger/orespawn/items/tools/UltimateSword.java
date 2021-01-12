/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.init.Enchantments;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class UltimateSword
/*    */   extends ToolSwordBase
/*    */ {
/*    */   public UltimateSword() {
/* 13 */     super("ultimate_sword", OrespawnToolMaterial.UltimateTools);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onUpdate(ItemStack stack, World world, Entity player, int itemSlot, boolean isSelected) {
/* 20 */     if (!stack.isItemEnchanted()) {
/*    */       
/* 22 */       stack.addEnchantment(Enchantments.LOOTING, 6);
/* 23 */       stack.addEnchantment(Enchantments.UNBREAKING, 6);
/*    */     } 
/* 25 */     super.onUpdate(stack, world, player, itemSlot, isSelected);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespawn\items\tools\UltimateSword.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */