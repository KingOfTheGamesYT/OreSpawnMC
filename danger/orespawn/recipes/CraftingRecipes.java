/*     */ package danger.orespawn.recipes;
/*     */ 
/*     */ import danger.orespawn.init.ModBlocks;
/*     */ import danger.orespawn.init.ModItems;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.Ingredient;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*     */ 
/*     */ public class CraftingRecipes {
/*     */   public static void init() {
/*  14 */     GameRegistry.addShapelessRecipe(new ResourceLocation("uranium_ingot"), null, new ItemStack(ModItems.URANIUM_INGOT, 9), new Ingredient[] {
/*     */           
/*  16 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.URANIUM_BLOCK) })
/*     */         });
/*  18 */     GameRegistry.addShapelessRecipe(new ResourceLocation("titanium_ingot"), null, new ItemStack(ModItems.TITANIUM_INGOT, 9), new Ingredient[] {
/*     */ 
/*     */           
/*  21 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.TITANIUM_BLOCK) })
/*     */         });
/*  23 */     GameRegistry.addShapelessRecipe(new ResourceLocation("uranium_nugget"), null, new ItemStack(ModItems.URANIUM_NUGGET, 9), new Ingredient[] {
/*     */ 
/*     */           
/*  26 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModItems.URANIUM_INGOT) })
/*     */         });
/*  28 */     GameRegistry.addShapelessRecipe(new ResourceLocation("titanium_nugget"), null, new ItemStack(ModItems.TITANIUM_NUGGET, 9), new Ingredient[] {
/*     */ 
/*     */           
/*  31 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModItems.TITANIUM_INGOT) })
/*     */         });
/*  33 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_sword"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_SWORD, 1), new Object[] { "XTX", "XUX", "XIX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  39 */           Character.valueOf('X'), Blocks.AIR, 
/*  40 */           Character.valueOf('I'), Items.IRON_INGOT, 
/*  41 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/*  42 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/*  44 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_pickaxe"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_PICKAXE, 1), new Object[] { "TUT", "XUX", "XIX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  50 */           Character.valueOf('X'), Blocks.AIR, 
/*  51 */           Character.valueOf('I'), Items.IRON_INGOT, 
/*  52 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/*  53 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/*  55 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_axe"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_AXE, 1), new Object[] { "TUX", "TIX", "XIX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  61 */           Character.valueOf('X'), Blocks.AIR, 
/*  62 */           Character.valueOf('I'), Items.IRON_INGOT, 
/*  63 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/*  64 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/*  66 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_helmet"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_HELMET, 1), new Object[] { "XXX", "TIT", "UXU", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  72 */           Character.valueOf('X'), Blocks.AIR, 
/*  73 */           Character.valueOf('I'), Items.IRON_INGOT, 
/*  74 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/*  75 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/*  77 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_chestplate"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_CHESTPLATE, 1), new Object[] { "IXI", "TTT", "UUU", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  83 */           Character.valueOf('X'), Blocks.AIR, 
/*  84 */           Character.valueOf('I'), Items.IRON_INGOT, 
/*  85 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/*  86 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/*  88 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_leggings"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_LEGGINGS, 1), new Object[] { "III", "TXT", "UXU", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  94 */           Character.valueOf('X'), Blocks.AIR, 
/*  95 */           Character.valueOf('I'), Items.IRON_INGOT, 
/*  96 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/*  97 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/*  99 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_boots"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_BOOTS, 1), new Object[] { "XXX", "TXT", "UXU", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 105 */           Character.valueOf('X'), Blocks.AIR, 
/* 106 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/* 107 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/* 109 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_sword"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_SWORD, 1), new Object[] { "XYX", "XYX", "XZX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 115 */           Character.valueOf('X'), Blocks.AIR, 
/* 116 */           Character.valueOf('Y'), Items.EMERALD, 
/* 117 */           Character.valueOf('Z'), Items.STICK });
/*     */     
/* 119 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_pickaxe"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_PICKAXE, 1), new Object[] { "YYY", "XZX", "XZX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 125 */           Character.valueOf('X'), Blocks.AIR, 
/* 126 */           Character.valueOf('Y'), Items.EMERALD, 
/* 127 */           Character.valueOf('Z'), Items.STICK });
/*     */     
/* 129 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_axe"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_AXE, 1), new Object[] { "YYX", "YZX", "XZX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 135 */           Character.valueOf('X'), Blocks.AIR, 
/* 136 */           Character.valueOf('Y'), Items.EMERALD, 
/* 137 */           Character.valueOf('Z'), Items.STICK });
/*     */     
/* 139 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_helmet"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_HELMET, 1), new Object[] { "XXX", "YYY", "YXY", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 145 */           Character.valueOf('X'), Blocks.AIR, 
/* 146 */           Character.valueOf('Y'), Items.EMERALD });
/*     */     
/* 148 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_chestplate"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_CHESTPLATE, 1), new Object[] { "YXY", "YYY", "YYY", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 154 */           Character.valueOf('X'), Blocks.AIR, 
/* 155 */           Character.valueOf('Y'), Items.EMERALD });
/*     */     
/* 157 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_leggings"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_LEGGINGS, 1), new Object[] { "YYY", "YXY", "YXY", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 163 */           Character.valueOf('X'), Blocks.AIR, 
/* 164 */           Character.valueOf('Y'), Items.EMERALD });
/*     */     
/* 166 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_boots"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_BOOTS, 1), new Object[] { "XXX", "YXY", "YXY", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 172 */           Character.valueOf('X'), Blocks.AIR, 
/* 173 */           Character.valueOf('Y'), Items.EMERALD });
/*     */     
/* 175 */     GameRegistry.addShapelessRecipe(new ResourceLocation("alosaurus_egg"), null, new ItemStack(ModItems.ALOSAURUS_EGG, 1), new Ingredient[] {
/* 176 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 177 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.ALOSAURUS_ORE) })
/*     */         });
/* 179 */     GameRegistry.addShapelessRecipe(new ResourceLocation("baryonyx_egg"), null, new ItemStack(ModItems.BARYONYX_EGG, 1), new Ingredient[] {
/* 180 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 181 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.BARYONYX_ORE) })
/*     */         });
/* 183 */     GameRegistry.addShapelessRecipe(new ResourceLocation("camarasaurus_egg"), null, new ItemStack(ModItems.CAMARASAURUS_EGG, 1), new Ingredient[] {
/* 184 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 185 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.CAMARASAURUS_ORE) })
/*     */         });
/* 187 */     GameRegistry.addShapelessRecipe(new ResourceLocation("cryolophosaurus_egg"), null, new ItemStack(ModItems.CRYOLOPHOSAURUS_EGG, 1), new Ingredient[] {
/* 188 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 189 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.CRYOLOPHOSAURUS_ORE) })
/*     */         });
/* 191 */     GameRegistry.addShapelessRecipe(new ResourceLocation("pointysaurus_egg"), null, new ItemStack(ModItems.POINTYSAURUS_EGG, 1), new Ingredient[] {
/* 192 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 193 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.POINTYSAURUS_ORE) })
/*     */         });
/* 195 */     GameRegistry.addShapelessRecipe(new ResourceLocation("trex_egg"), null, new ItemStack(ModItems.TREX_EGG, 1), new Ingredient[] {
/* 196 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 197 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.TREX_ORE) })
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\recipes\CraftingRecipes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */