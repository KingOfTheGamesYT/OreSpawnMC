/*     */ package danger.orespawn.recipes;
/*     */ 
/*     */ import danger.orespawn.init.ModBlocks;
/*     */ import danger.orespawn.init.ModItems;
/*     */ import java.util.Objects;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.monster.EntityCreeper;
/*     */ import net.minecraft.entity.monster.EntityGhast;
/*     */ import net.minecraft.entity.monster.EntityZombie;
/*     */ import net.minecraft.entity.passive.EntityCow;
/*     */ import net.minecraft.entity.passive.EntityHorse;
/*     */ import net.minecraft.entity.passive.EntityPig;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemMonsterPlacer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.Ingredient;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*     */ 
/*     */ public class CraftingRecipes {
/*     */   public static void init() {
/*  23 */     GameRegistry.addShapelessRecipe(new ResourceLocation("uranium_ingot"), null, new ItemStack(ModItems.URANIUM_INGOT, 9), new Ingredient[] {
/*     */           
/*  25 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.URANIUM_BLOCK) })
/*     */         });
/*  27 */     GameRegistry.addShapelessRecipe(new ResourceLocation("titanium_ingot"), null, new ItemStack(ModItems.TITANIUM_INGOT, 9), new Ingredient[] {
/*     */ 
/*     */           
/*  30 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.TITANIUM_BLOCK) })
/*     */         });
/*  32 */     GameRegistry.addShapelessRecipe(new ResourceLocation("uranium_nugget"), null, new ItemStack(ModItems.URANIUM_NUGGET, 9), new Ingredient[] {
/*     */ 
/*     */           
/*  35 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModItems.URANIUM_INGOT) })
/*     */         });
/*  37 */     GameRegistry.addShapelessRecipe(new ResourceLocation("titanium_nugget"), null, new ItemStack(ModItems.TITANIUM_NUGGET, 9), new Ingredient[] {
/*     */ 
/*     */           
/*  40 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModItems.TITANIUM_INGOT) })
/*     */         });
/*  42 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_sword"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_SWORD, 1), new Object[] { "XTX", "XUX", "XIX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  48 */           Character.valueOf('X'), Blocks.AIR, 
/*  49 */           Character.valueOf('I'), Items.IRON_INGOT, 
/*  50 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/*  51 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/*  53 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_pickaxe"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_PICKAXE, 1), new Object[] { "TUT", "XUX", "XIX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  59 */           Character.valueOf('X'), Blocks.AIR, 
/*  60 */           Character.valueOf('I'), Items.IRON_INGOT, 
/*  61 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/*  62 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/*  64 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_axe"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_AXE, 1), new Object[] { "TUX", "TIX", "XIX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  70 */           Character.valueOf('X'), Blocks.AIR, 
/*  71 */           Character.valueOf('I'), Items.IRON_INGOT, 
/*  72 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/*  73 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/*  75 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_shovel"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_SHOVEL, 1), new Object[] { "XUX", "XTX", "XIX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  81 */           Character.valueOf('X'), Blocks.AIR, 
/*  82 */           Character.valueOf('I'), Items.IRON_INGOT, 
/*  83 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/*  84 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/*  86 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_hoe"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_HOE, 1), new Object[] { "TUX", "XIX", "XIX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  92 */           Character.valueOf('X'), Blocks.AIR, 
/*  93 */           Character.valueOf('I'), Items.IRON_INGOT, 
/*  94 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/*  95 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/*  97 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_helmet"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_HELMET, 1), new Object[] { "XXX", "TIT", "UXU", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 103 */           Character.valueOf('X'), Blocks.AIR, 
/* 104 */           Character.valueOf('I'), Items.IRON_INGOT, 
/* 105 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/* 106 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/* 108 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_chestplate"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_CHESTPLATE, 1), new Object[] { "IXI", "TTT", "UUU", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 114 */           Character.valueOf('X'), Blocks.AIR, 
/* 115 */           Character.valueOf('I'), Items.IRON_INGOT, 
/* 116 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/* 117 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/* 119 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_leggings"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_LEGGINGS, 1), new Object[] { "III", "TXT", "UXU", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 125 */           Character.valueOf('X'), Blocks.AIR, 
/* 126 */           Character.valueOf('I'), Items.IRON_INGOT, 
/* 127 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/* 128 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/* 130 */     GameRegistry.addShapedRecipe(new ResourceLocation("ultimate_boots"), new ResourceLocation("orespawn"), new ItemStack(ModItems.ULTIMATE_BOOTS, 1), new Object[] { "XXX", "TXT", "UXU", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 136 */           Character.valueOf('X'), Blocks.AIR, 
/* 137 */           Character.valueOf('U'), ModItems.URANIUM_INGOT, 
/* 138 */           Character.valueOf('T'), ModItems.TITANIUM_INGOT });
/*     */     
/* 140 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_sword"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_SWORD, 1), new Object[] { "XYX", "XYX", "XZX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 146 */           Character.valueOf('X'), Blocks.AIR, 
/* 147 */           Character.valueOf('Y'), Items.EMERALD, 
/* 148 */           Character.valueOf('Z'), Items.STICK });
/*     */     
/* 150 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_pickaxe"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_PICKAXE, 1), new Object[] { "YYY", "XZX", "XZX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 156 */           Character.valueOf('X'), Blocks.AIR, 
/* 157 */           Character.valueOf('Y'), Items.EMERALD, 
/* 158 */           Character.valueOf('Z'), Items.STICK });
/*     */     
/* 160 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_axe"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_AXE, 1), new Object[] { "YYX", "YZX", "XZX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 166 */           Character.valueOf('X'), Blocks.AIR, 
/* 167 */           Character.valueOf('Y'), Items.EMERALD, 
/* 168 */           Character.valueOf('Z'), Items.STICK });
/*     */     
/* 170 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_shovel"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_SHOVEL, 1), new Object[] { "XYX", "XZX", "XZX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 176 */           Character.valueOf('X'), Blocks.AIR, 
/* 177 */           Character.valueOf('Y'), Items.EMERALD, 
/* 178 */           Character.valueOf('Z'), Items.STICK });
/*     */     
/* 180 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_hoe"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_HOE, 1), new Object[] { "YYX", "XZX", "XZX", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 186 */           Character.valueOf('X'), Blocks.AIR, 
/* 187 */           Character.valueOf('Y'), Items.EMERALD, 
/* 188 */           Character.valueOf('Z'), Items.STICK });
/*     */     
/* 190 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_helmet"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_HELMET, 1), new Object[] { "XXX", "YYY", "YXY", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 196 */           Character.valueOf('X'), Blocks.AIR, 
/* 197 */           Character.valueOf('Y'), Items.EMERALD });
/*     */     
/* 199 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_chestplate"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_CHESTPLATE, 1), new Object[] { "YXY", "YYY", "YYY", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 205 */           Character.valueOf('X'), Blocks.AIR, 
/* 206 */           Character.valueOf('Y'), Items.EMERALD });
/*     */     
/* 208 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_leggings"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_LEGGINGS, 1), new Object[] { "YYY", "YXY", "YXY", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 214 */           Character.valueOf('X'), Blocks.AIR, 
/* 215 */           Character.valueOf('Y'), Items.EMERALD });
/*     */     
/* 217 */     GameRegistry.addShapedRecipe(new ResourceLocation("emerald_boots"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMERALD_BOOTS, 1), new Object[] { "XXX", "YXY", "YXY", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 223 */           Character.valueOf('X'), Blocks.AIR, 
/* 224 */           Character.valueOf('Y'), Items.EMERALD });
/*     */     
/* 226 */     GameRegistry.addShapedRecipe(new ResourceLocation("empty_cage"), new ResourceLocation("orespawn"), new ItemStack(ModItems.EMPTY_CAGE, 2), new Object[] { "ISI", "SXS", "ISI", 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 232 */           Character.valueOf('X'), Blocks.AIR, 
/* 233 */           Character.valueOf('S'), Items.STICK, 
/* 234 */           Character.valueOf('I'), Items.IRON_INGOT });
/*     */     
/* 236 */     GameRegistry.addShapelessRecipe(new ResourceLocation("alosaurus_egg"), null, new ItemStack(ModItems.ALOSAURUS_EGG, 1), new Ingredient[] {
/* 237 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 238 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.ALOSAURUS_ORE) })
/*     */         });
/* 240 */     GameRegistry.addShapelessRecipe(new ResourceLocation("baryonyx_egg"), null, new ItemStack(ModItems.BARYONYX_EGG, 1), new Ingredient[] {
/* 241 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 242 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.BARYONYX_ORE) })
/*     */         });
/* 244 */     GameRegistry.addShapelessRecipe(new ResourceLocation("camarasaurus_egg"), null, new ItemStack(ModItems.CAMARASAURUS_EGG, 1), new Ingredient[] {
/* 245 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 246 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.CAMARASAURUS_ORE) })
/*     */         });
/* 248 */     GameRegistry.addShapelessRecipe(new ResourceLocation("cryolophosaurus_egg"), null, new ItemStack(ModItems.CRYOLOPHOSAURUS_EGG, 1), new Ingredient[] {
/* 249 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 250 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.CRYOLOPHOSAURUS_ORE) })
/*     */         });
/* 252 */     GameRegistry.addShapelessRecipe(new ResourceLocation("pointysaurus_egg"), null, new ItemStack(ModItems.POINTYSAURUS_EGG, 1), new Ingredient[] {
/* 253 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 254 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.POINTYSAURUS_ORE) })
/*     */         });
/* 256 */     GameRegistry.addShapelessRecipe(new ResourceLocation("trex_egg"), null, new ItemStack(ModItems.TREX_EGG, 1), new Ingredient[] {
/* 257 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 258 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.TREX_ORE) })
/*     */         });
/* 260 */     GameRegistry.addShapelessRecipe(new ResourceLocation("bird_egg"), null, new ItemStack(ModItems.BIRD_EGG, 1), new Ingredient[] {
/* 261 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 262 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.BIRD_ORE) })
/*     */         });
/* 264 */     ItemStack cowEgg = new ItemStack(Items.SPAWN_EGG, 1);
/* 265 */     ItemMonsterPlacer.applyEntityIdToItemStack(cowEgg, Objects.<ResourceLocation>requireNonNull(EntityList.getKey(EntityCow.class)));
/* 266 */     GameRegistry.addShapelessRecipe(new ResourceLocation("cow_egg"), null, cowEgg, new Ingredient[] {
/* 267 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 268 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.COW_ORE) })
/*     */         });
/* 270 */     ItemStack creeperEgg = new ItemStack(Items.SPAWN_EGG, 1);
/* 271 */     ItemMonsterPlacer.applyEntityIdToItemStack(creeperEgg, Objects.<ResourceLocation>requireNonNull(EntityList.getKey(EntityCreeper.class)));
/* 272 */     GameRegistry.addShapelessRecipe(new ResourceLocation("creeper_egg"), null, creeperEgg, new Ingredient[] {
/* 273 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 274 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.CREEPER_ORE) })
/*     */         });
/* 276 */     ItemStack ghastEgg = new ItemStack(Items.SPAWN_EGG, 1);
/* 277 */     ItemMonsterPlacer.applyEntityIdToItemStack(ghastEgg, Objects.<ResourceLocation>requireNonNull(EntityList.getKey(EntityGhast.class)));
/* 278 */     GameRegistry.addShapelessRecipe(new ResourceLocation("ghast_egg"), null, ghastEgg, new Ingredient[] {
/* 279 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 280 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.GHAST_ORE) })
/*     */         });
/* 282 */     ItemStack horseEgg = new ItemStack(Items.SPAWN_EGG, 1);
/* 283 */     ItemMonsterPlacer.applyEntityIdToItemStack(horseEgg, Objects.<ResourceLocation>requireNonNull(EntityList.getKey(EntityHorse.class)));
/* 284 */     GameRegistry.addShapelessRecipe(new ResourceLocation("horse_egg"), null, horseEgg, new Ingredient[] {
/* 285 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 286 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.HORSE_ORE) })
/*     */         });
/* 288 */     ItemStack pigEgg = new ItemStack(Items.SPAWN_EGG, 1);
/* 289 */     ItemMonsterPlacer.applyEntityIdToItemStack(pigEgg, Objects.<ResourceLocation>requireNonNull(EntityList.getKey(EntityPig.class)));
/* 290 */     GameRegistry.addShapelessRecipe(new ResourceLocation("pig_egg"), null, pigEgg, new Ingredient[] {
/* 291 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 292 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.PIG_ORE) })
/*     */         });
/* 294 */     ItemStack zombieEgg = new ItemStack(Items.SPAWN_EGG, 1);
/* 295 */     ItemMonsterPlacer.applyEntityIdToItemStack(cowEgg, Objects.<ResourceLocation>requireNonNull(EntityList.getKey(EntityZombie.class)));
/* 296 */     GameRegistry.addShapelessRecipe(new ResourceLocation("zombie_egg"), null, zombieEgg, new Ingredient[] {
/* 297 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 298 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.ZOMBIE_ORE) })
/*     */         });
/* 300 */     GameRegistry.addShapelessRecipe(new ResourceLocation("alien_egg"), null, new ItemStack(ModItems.ALIEN_EGG, 1), new Ingredient[] {
/* 301 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 302 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.ALIEN_ORE) })
/*     */         });
/* 304 */     GameRegistry.addShapelessRecipe(new ResourceLocation("cavefisher_egg"), null, new ItemStack(ModItems.CAVEFISHER_EGG, 1), new Ingredient[] {
/* 305 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 306 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.CAVEFISHER_ORE) })
/*     */         });
/* 308 */     GameRegistry.addShapelessRecipe(new ResourceLocation("nastysaurus_egg"), null, new ItemStack(ModItems.NASTYSAURUS_EGG, 1), new Ingredient[] {
/* 309 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 310 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.NASTYSAURUS_ORE) })
/*     */         });
/* 312 */     GameRegistry.addShapelessRecipe(new ResourceLocation("velocityraptor_egg"), null, new ItemStack(ModItems.VELOCITYRAPTOR_EGG, 1), new Ingredient[] {
/* 313 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 314 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.VELOCITYRAPTOR_ORE) })
/*     */         });
/* 316 */     GameRegistry.addShapelessRecipe(new ResourceLocation("gammametroid_egg"), null, new ItemStack(ModItems.GAMMAMETROID_EGG, 1), new Ingredient[] {
/* 317 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 318 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.WTF_ORE) })
/*     */         });
/* 320 */     GameRegistry.addShapelessRecipe(new ResourceLocation("spyro_egg"), null, new ItemStack(ModItems.SPYRO_EGG, 1), new Ingredient[] {
/* 321 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 322 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.SPYRO_ORE) })
/*     */         });
/* 324 */     GameRegistry.addShapelessRecipe(new ResourceLocation("dragonfly_egg"), null, new ItemStack(ModItems.DRAGONFLY_EGG, 1), new Ingredient[] {
/* 325 */           Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.WATER_BUCKET, 1)
/* 326 */             }), Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModBlocks.DRAGONFLY_ORE) })
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\recipes\CraftingRecipes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */