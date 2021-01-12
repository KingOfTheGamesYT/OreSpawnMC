/*    */ package danger.orespawn.recipes;
/*    */ 
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*    */ 
/*    */ public class SmeltingRecipes {
/*    */   public static void init() {
/* 10 */     GameRegistry.addSmelting(new ItemStack(ModBlocks.URANIUM_ORE), new ItemStack(ModItems.URANIUM_INGOT), 0.4F);
/* 11 */     GameRegistry.addSmelting(new ItemStack(ModBlocks.TITANIUM_ORE), new ItemStack(ModItems.TITANIUM_INGOT), 0.4F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespawn\recipes\SmeltingRecipes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */