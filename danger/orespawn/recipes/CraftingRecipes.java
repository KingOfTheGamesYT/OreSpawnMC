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
/*  66 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_shovel"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_SHOVEL, 1), new Object[] { "XUX", "XTX", "XIX", 
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
/*  77 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_hoe"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_HOE, 1), new Object[] { "TUX", "XIX", "XIX", 
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
/*  88 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_helmet"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_HELMET, 1), new Object[] { "XXX", "TIT", "UXU", 
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
/*  99 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_chestplate"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_CHESTPLATE, 1), new Object[] { "IXI", "TTT", "UUU", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 105 */           Character.valueOf('X'), Blocks.AIR, 
/* 106 */           Character.valueOf('I'), Items.IRON_INGOT, 
/* 107 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/* 108 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/* 110 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_leggings"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_LEGGINGS, 1), new Object[] { "III", "TXT", "UXU", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 116 */           Character.valueOf('X'), Blocks.AIR, 
/* 117 */           Character.valueOf('I'), Items.IRON_INGOT, 
/* 118 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/* 119 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/* 121 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_boots"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_BOOTS, 1), new Object[] { "XXX", "TXT", "UXU", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 127 */           Character.valueOf('X'), Blocks.AIR, 
/* 128 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/* 129 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/* 131 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_sword"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_SWORD, 1), new Object[] { "XYX", "XYX", "XZX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 137 */           Character.valueOf('X'), Blocks.AIR, 
/* 138 */           Character.valueOf('Y'), Items.EMERALD, 
/* 139 */           Character.valueOf('Z'), Items.STICK });
/*     */     
/* 141 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_pickaxe"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_PICKAXE, 1), new Object[] { "YYY", "XZX", "XZX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 147 */           Character.valueOf('X'), Blocks.AIR, 
/* 148 */           Character.valueOf('Y'), Items.EMERALD, 
/* 149 */           Character.valueOf('Z'), Items.STICK });
/*     */     
/* 151 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_axe"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_AXE, 1), new Object[] { "YYX", "YZX", "XZX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 157 */           Character.valueOf('X'), Blocks.AIR, 
/* 158 */           Character.valueOf('Y'), Items.EMERALD, 
/* 159 */           Character.valueOf('Z'), Items.STICK });
/*     */     
/* 161 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_shovel"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_SHOVEL, 1), new Object[] { "XYX", "XZX", "XZX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 167 */           Character.valueOf('X'), Blocks.AIR, 
/* 168 */           Character.valueOf('Y'), Items.EMERALD, 
/* 169 */           Character.valueOf('Z'), Items.STICK });
/*     */     
/* 171 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_hoe"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_HOE, 1), new Object[] { "YYX", "XZX", "XZX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 177 */           Character.valueOf('X'), Blocks.AIR, 
/* 178 */           Character.valueOf('Y'), Items.EMERALD, 
/* 179 */           Character.valueOf('Z'), Items.STICK });
/*     */     
/* 181 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_helmet"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_HELMET, 1), new Object[] { "XXX", "YYY", "YXY", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 187 */           Character.valueOf('X'), Blocks.AIR, 
/* 188 */           Character.valueOf('Y'), Items.EMERALD });
/*     */     
/* 190 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_chestplate"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_CHESTPLATE, 1), new Object[] { "YXY", "YYY", "YYY", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 196 */           Character.valueOf('X'), Blocks.AIR, 
/* 197 */           Character.valueOf('Y'), Items.EMERALD });
/*     */     
/* 199 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_leggings"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_LEGGINGS, 1), new Object[] { "YYY", "YXY", "YXY", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 205 */           Character.valueOf('X'), Blocks.AIR, 
/* 206 */           Character.valueOf('Y'), Items.EMERALD });
/*     */     
/* 208 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_boots"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_BOOTS, 1), new Object[] { "XXX", "YXY", "YXY", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 214 */           Character.valueOf('X'), Blocks.AIR, 
/* 215 */           Character.valueOf('Y'), Items.EMERALD });
/*     */     
/* 217 */     GameRegistry.addShapelessRecipe(new ResourceLocation("alosaurus_egg"), null, new ItemStack(ModItems.ALOSAURUS_EGG, 1), new Ingredient[] {
/* 218 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 219 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.ALOSAURUS_ORE) })
/*     */         });
/* 221 */     GameRegistry.addShapelessRecipe(new ResourceLocation("baryonyx_egg"), null, new ItemStack(ModItems.BARYONYX_EGG, 1), new Ingredient[] {
/* 222 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 223 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.BARYONYX_ORE) })
/*     */         });
/* 225 */     GameRegistry.addShapelessRecipe(new ResourceLocation("camarasaurus_egg"), null, new ItemStack(ModItems.CAMARASAURUS_EGG, 1), new Ingredient[] {
/* 226 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 227 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.CAMARASAURUS_ORE) })
/*     */         });
/* 229 */     GameRegistry.addShapelessRecipe(new ResourceLocation("cryolophosaurus_egg"), null, new ItemStack(ModItems.CRYOLOPHOSAURUS_EGG, 1), new Ingredient[] {
/* 230 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 231 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.CRYOLOPHOSAURUS_ORE) })
/*     */         });
/* 233 */     GameRegistry.addShapelessRecipe(new ResourceLocation("pointysaurus_egg"), null, new ItemStack(ModItems.POINTYSAURUS_EGG, 1), new Ingredient[] {
/* 234 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 235 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.POINTYSAURUS_ORE) })
/*     */         });
/* 237 */     GameRegistry.addShapelessRecipe(new ResourceLocation("trex_egg"), null, new ItemStack(ModItems.TREX_EGG, 1), new Ingredient[] {
/* 238 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 239 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.TREX_ORE) })
/*     */         });
/* 241 */     GameRegistry.addShapelessRecipe(new ResourceLocation("bird_egg"), null, new ItemStack(ModItems.BIRD_EGG, 1), new Ingredient[] {
/* 242 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 243 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.BIRD_ORE) })
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\recipes\CraftingRecipes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */