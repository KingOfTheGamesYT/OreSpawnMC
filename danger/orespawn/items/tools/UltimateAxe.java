/*    */ package danger.orespawn.items.tools;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.init.Enchantments;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class UltimateAxe
/*    */   extends ToolAxeBase
/*    */ {
/*    */   public UltimateAxe() {
/* 12 */     super("ultimate_axe", OrespawnToolMaterial.UltimateTools);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onUpdate(ItemStack stack, World world, Entity player, int itemSlot, boolean isSelected) {
/* 18 */     if (!stack.isItemEnchanted())
/*    */     {
/* 20 */       stack.addEnchantment(Enchantments.EFFICIENCY, 5);
/*    */     }
/* 22 */     super.onUpdate(stack, world, player, itemSlot, isSelected);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\items\tools\UltimateAxe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */