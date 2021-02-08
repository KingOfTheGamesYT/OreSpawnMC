/*     */ package danger.orespawn.init;
/*     */ import danger.orespawn.entity.Alien;
/*     */ import danger.orespawn.entity.Alosaurus;
/*     */ import danger.orespawn.entity.Dragonfly;
/*     */ import danger.orespawn.entity.Firefly;
/*     */ import danger.orespawn.entity.GammaMetroid;
/*     */ import danger.orespawn.entity.Mosquito;
/*     */ import danger.orespawn.entity.Nastysaurus;
/*     */ import danger.orespawn.entity.Spyro;
/*     */ import danger.orespawn.entity.TRex;
/*     */ import danger.orespawn.entity.VelocityRaptor;
/*     */ import danger.orespawn.items.CritterCage;
/*     */ import danger.orespawn.items.ItemBasic;
/*     */ import danger.orespawn.items.ItemFireflySeed;
/*     */ import danger.orespawn.items.ItemGenericEgg;
/*     */ import danger.orespawn.items.ItemMosquitoSeed;
/*     */ import danger.orespawn.items.armor.ArmorBase;
/*     */ import danger.orespawn.items.armor.OrespawnArmorMaterial;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.entity.passive.EntityCow;
/*     */ import net.minecraft.entity.passive.EntityHorse;
/*     */ import net.minecraft.entity.passive.EntityPig;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.Item;
/*     */ 
/*     */ public class ModItems {
/*  27 */   public static final List<Item> ITEMS = new ArrayList<>();
/*     */   
/*  29 */   public static final Item URANIUM_NUGGET = (Item)new ItemBasic("uranium_nugget");
/*  30 */   public static final Item TITANIUM_NUGGET = (Item)new ItemBasic("titanium_nugget");
/*  31 */   public static final Item URANIUM_INGOT = (Item)new ItemBasic("uranium_ingot");
/*  32 */   public static final Item TITANIUM_INGOT = (Item)new ItemBasic("titanium_ingot");
/*     */   
/*  34 */   public static final Item TREX_TOOTH = (Item)new ItemBasic("trextooth");
/*     */ 
/*     */   
/*  37 */   public static final Item EMPTY_CAGE = (Item)new CritterCage(null, "empty_cage");
/*  38 */   public static final Item ALOSAURUS_CAGE = (Item)new CritterCage(Alosaurus.class, "alosaurus_cage", 0.4F);
/*  39 */   public static final Item TREX_CAGE = (Item)new CritterCage(TRex.class, "trex_cage", 0.4F);
/*     */   
/*  41 */   public static final Item COW_CAGE = (Item)new CritterCage(EntityCow.class, "cow_cage", 0.4F);
/*  42 */   public static final Item CREEPER_CAGE = (Item)new CritterCage(EntityCreeper.class, "creeper_cage", 0.4F);
/*  43 */   public static final Item GHAST_CAGE = (Item)new CritterCage(EntityGhast.class, "ghast_cage", 0.4F);
/*  44 */   public static final Item HORSE_CAGE = (Item)new CritterCage(EntityHorse.class, "horse_cage", 0.4F);
/*  45 */   public static final Item PIG_CAGE = (Item)new CritterCage(EntityPig.class, "pig_cage", 0.4F);
/*  46 */   public static final Item ZOMBIE_CAGE = (Item)new CritterCage(EntityZombie.class, "zombie_cage", 0.4F);
/*     */   
/*  48 */   public static final Item GAMMAMETROID_CAGE = (Item)new CritterCage(GammaMetroid.class, "gammametroid_cage", 0.4F);
/*  49 */   public static final Item SPYRO_CAGE = (Item)new CritterCage(Spyro.class, "spyro_cage", 0.4F);
/*  50 */   public static final Item DRAGONFLY_CAGE = (Item)new CritterCage(Dragonfly.class, "dragonfly_cage", 0.4F);
/*  51 */   public static final Item FIREFLY_CAGE = (Item)new CritterCage(Firefly.class, "firefly_cage", 0.4F);
/*  52 */   public static final Item NASTYSAURUS_CAGE = (Item)new CritterCage(Nastysaurus.class, "nastysaurus_cage", 0.4F);
/*  53 */   public static final Item ALIEN_CAGE = (Item)new CritterCage(Alien.class, "alien_cage", 0.4F);
/*  54 */   public static final Item VELOCITYRAPTOR_CAGE = (Item)new CritterCage(VelocityRaptor.class, "velocityraptor_cage", 0.4F);
/*     */ 
/*     */   
/*  57 */   public static final Item ULTIMATE_HELMET = (Item)new ArmorBase("ultimate_helmet", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.HEAD);
/*  58 */   public static final Item ULTIMATE_CHESTPLATE = (Item)new ArmorBase("ultimate_chestplate", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.CHEST);
/*  59 */   public static final Item ULTIMATE_LEGGINGS = (Item)new ArmorBase("ultimate_leggings", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.LEGS);
/*  60 */   public static final Item ULTIMATE_BOOTS = (Item)new ArmorBase("ultimate_boots", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.FEET);
/*     */   
/*  62 */   public static final Item EMERALD_HELMET = (Item)new ArmorBase("emerald_helmet", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.HEAD);
/*  63 */   public static final Item EMERALD_CHESTPLATE = (Item)new ArmorBase("emerald_chestplate", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.CHEST);
/*  64 */   public static final Item EMERALD_LEGGINGS = (Item)new ArmorBase("emerald_leggings", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.LEGS);
/*  65 */   public static final Item EMERALD_BOOTS = (Item)new ArmorBase("emerald_boots", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.FEET);
/*     */   
/*  67 */   public static final Item ULTIMATE_PICKAXE = (Item)new UltimatePickaxe();
/*  68 */   public static final Item ULTIMATE_SWORD = (Item)new UltimateSword();
/*  69 */   public static final Item ULTIMATE_AXE = (Item)new UltimateAxe();
/*  70 */   public static final Item ULTIMATE_SHOVEL = (Item)new UltimateShovel();
/*  71 */   public static final Item ULTIMATE_HOE = (Item)new UltimateHoe();
/*     */   
/*  73 */   public static final Item EMERALD_PICKAXE = (Item)new EmeraldPickaxe();
/*  74 */   public static final Item EMERALD_SWORD = (Item)new EmeraldSword();
/*  75 */   public static final Item EMERALD_AXE = (Item)new EmeraldAxe();
/*  76 */   public static final Item EMERALD_SHOVEL = (Item)new EmeraldShovel();
/*  77 */   public static final Item EMERALD_HOE = (Item)new EmeraldHoe();
/*     */ 
/*     */ 
/*     */   
/*  81 */   public static final Item CORN = (Item)new ItemCorn();
/*  82 */   public static final Item BUTTERFLY_SEED = (Item)new ItemButterflySeed();
/*  83 */   public static final Item MOSQUITO_SEED = (Item)new ItemMosquitoSeed();
/*  84 */   public static final Item FIREFLY_SEED = (Item)new ItemFireflySeed();
/*     */ 
/*     */ 
/*     */   
/*  88 */   public static final Item ALOSAURUS_EGG = (Item)new ItemGenericEgg("alosaurus_egg", Alosaurus.class);
/*  89 */   public static final Item BARYONYX_EGG = (Item)new ItemGenericEgg("baryonyx_egg", Baryonyx.class);
/*  90 */   public static final Item CAMARASAURUS_EGG = (Item)new ItemGenericEgg("camarasaurus_egg", Camarasaurus.class);
/*  91 */   public static final Item CRYOLOPHOSAURUS_EGG = (Item)new ItemGenericEgg("cryolophosaurus_egg", Cryolophosaurus.class);
/*  92 */   public static final Item POINTYSAURUS_EGG = (Item)new ItemGenericEgg("pointysaurus_egg", Pointysaurus.class);
/*  93 */   public static final Item TREX_EGG = (Item)new ItemGenericEgg("trex_egg", TRex.class);
/*  94 */   public static final Item CAVEFISHER_EGG = (Item)new ItemGenericEgg("cavefisher_egg", CaveFisher.class);
/*     */   
/*  96 */   public static final Item BUTTERFLY_EGG = (Item)new ItemGenericEgg("butterfly_egg", Butterfly.class);
/*  97 */   public static final Item BIRD_EGG = (Item)new ItemGenericEgg("bird_egg", Bird.class);
/*  98 */   public static final Item RED_ANT_EGG = (Item)new ItemGenericEgg("red_ant_egg", RedAnt.class);
/*     */   
/* 100 */   public static final Item GAMMAMETROID_EGG = (Item)new ItemGenericEgg("gammametroid_egg", GammaMetroid.class);
/* 101 */   public static final Item SPYRO_EGG = (Item)new ItemGenericEgg("spyro_egg", Spyro.class);
/* 102 */   public static final Item DRAGONFLY_EGG = (Item)new ItemGenericEgg("dragonfly_egg", Dragonfly.class);
/* 103 */   public static final Item FIREFLY_EGG = (Item)new ItemGenericEgg("firefly_egg", Firefly.class);
/* 104 */   public static final Item MOSQUITO_EGG = (Item)new ItemGenericEgg("mosquito_egg", Mosquito.class);
/* 105 */   public static final Item NASTYSAURUS_EGG = (Item)new ItemGenericEgg("nastysaurus_egg", Nastysaurus.class);
/* 106 */   public static final Item ALIEN_EGG = (Item)new ItemGenericEgg("alien_egg", Alien.class);
/* 107 */   public static final Item VELOCITYRAPTOR_EGG = (Item)new ItemGenericEgg("velocityraptor_egg", VelocityRaptor.class);
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\init\ModItems.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */