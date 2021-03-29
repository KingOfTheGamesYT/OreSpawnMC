/*     */ package danger.orespawn.init;
/*     */ import danger.orespawn.entity.Alien;
/*     */ import danger.orespawn.entity.Brutalfly;
/*     */ import danger.orespawn.entity.Cassowary;
/*     */ import danger.orespawn.entity.Firefly;
/*     */ import danger.orespawn.entity.GammaMetroid;
/*     */ import danger.orespawn.entity.Kyuubi;
/*     */ import danger.orespawn.entity.RedCow;
/*     */ import danger.orespawn.entity.StinkBug;
/*     */ import danger.orespawn.entity.TRex;
/*     */ import danger.orespawn.entity.VelocityRaptor;
/*     */ import danger.orespawn.entity.WormSmall;
/*     */ import danger.orespawn.items.CritterCage;
/*     */ import danger.orespawn.items.ItemBasic;
/*     */ import danger.orespawn.items.ItemGenericEgg;
/*     */ import danger.orespawn.items.armor.ArmorBase;
/*     */ import danger.orespawn.items.armor.OrespawnArmorMaterial;
/*     */ import danger.orespawn.items.tools.OrespawnToolMaterial;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.Item;
/*     */ 
/*     */ public class ModItems {
/*  23 */   public static final List<Item> ITEMS = new ArrayList<>();
/*     */   
/*  25 */   public static final Item URANIUM_NUGGET = (Item)new ItemBasic("uranium_nugget");
/*  26 */   public static final Item TITANIUM_NUGGET = (Item)new ItemBasic("titanium_nugget");
/*  27 */   public static final Item URANIUM_INGOT = (Item)new ItemBasic("uranium_ingot");
/*  28 */   public static final Item TITANIUM_INGOT = (Item)new ItemBasic("titanium_ingot");
/*     */   
/*  30 */   public static final Item TREX_TOOTH = (Item)new ItemBasic("trextooth");
/*     */ 
/*     */   
/*  33 */   public static final Item EMPTY_CAGE = (Item)new CritterCage(null, "empty_cage");
/*  34 */   public static final Item ALOSAURUS_CAGE = (Item)new CritterCage(Alosaurus.class, "alosaurus_cage", 0.4F);
/*  35 */   public static final Item TREX_CAGE = (Item)new CritterCage(TRex.class, "trex_cage", 0.4F);
/*     */   
/*  37 */   public static final Item COW_CAGE = (Item)new CritterCage(EntityCow.class, "cow_cage", 0.4F);
/*  38 */   public static final Item CREEPER_CAGE = (Item)new CritterCage(EntityCreeper.class, "creeper_cage", 0.4F);
/*  39 */   public static final Item GHAST_CAGE = (Item)new CritterCage(EntityGhast.class, "ghast_cage", 0.4F);
/*  40 */   public static final Item HORSE_CAGE = (Item)new CritterCage(EntityHorse.class, "horse_cage", 0.4F);
/*  41 */   public static final Item PIG_CAGE = (Item)new CritterCage(EntityPig.class, "pig_cage", 0.4F);
/*  42 */   public static final Item ZOMBIE_CAGE = (Item)new CritterCage(EntityZombie.class, "zombie_cage", 0.4F);
/*     */   
/*  44 */   public static final Item GAMMAMETROID_CAGE = (Item)new CritterCage(GammaMetroid.class, "gammametroid_cage", 0.4F);
/*  45 */   public static final Item SPYRO_CAGE = (Item)new CritterCage(Spyro.class, "spyro_cage", 0.4F);
/*  46 */   public static final Item DRAGONFLY_CAGE = (Item)new CritterCage(Dragonfly.class, "dragonfly_cage", 0.4F);
/*  47 */   public static final Item FIREFLY_CAGE = (Item)new CritterCage(Firefly.class, "firefly_cage", 0.4F);
/*  48 */   public static final Item NASTYSAURUS_CAGE = (Item)new CritterCage(Nastysaurus.class, "nastysaurus_cage", 0.4F);
/*  49 */   public static final Item ALIEN_CAGE = (Item)new CritterCage(Alien.class, "alien_cage", 0.4F);
/*  50 */   public static final Item VELOCITYRAPTOR_CAGE = (Item)new CritterCage(VelocityRaptor.class, "velocityraptor_cage", 0.4F);
/*     */ 
/*     */   
/*  53 */   public static final Item ULTIMATE_HELMET = (Item)new ArmorBase("ultimate_helmet", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.HEAD);
/*  54 */   public static final Item ULTIMATE_CHESTPLATE = (Item)new ArmorBase("ultimate_chestplate", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.CHEST);
/*  55 */   public static final Item ULTIMATE_LEGGINGS = (Item)new ArmorBase("ultimate_leggings", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.LEGS);
/*  56 */   public static final Item ULTIMATE_BOOTS = (Item)new ArmorBase("ultimate_boots", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.FEET);
/*     */   
/*  58 */   public static final Item EMERALD_HELMET = (Item)new ArmorBase("emerald_helmet", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.HEAD);
/*  59 */   public static final Item EMERALD_CHESTPLATE = (Item)new ArmorBase("emerald_chestplate", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.CHEST);
/*  60 */   public static final Item EMERALD_LEGGINGS = (Item)new ArmorBase("emerald_leggings", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.LEGS);
/*  61 */   public static final Item EMERALD_BOOTS = (Item)new ArmorBase("emerald_boots", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.FEET);
/*     */   
/*  63 */   public static final Item ULTIMATE_PICKAXE = (Item)new UltimatePickaxe();
/*  64 */   public static final Item ULTIMATE_SWORD = (Item)new UltimateSword();
/*  65 */   public static final Item ULTIMATE_AXE = (Item)new UltimateAxe();
/*  66 */   public static final Item ULTIMATE_SHOVEL = (Item)new UltimateShovel();
/*  67 */   public static final Item ULTIMATE_HOE = (Item)new UltimateHoe();
/*     */   
/*  69 */   public static final Item EMERALD_PICKAXE = (Item)new EmeraldPickaxe();
/*  70 */   public static final Item EMERALD_SWORD = (Item)new EmeraldSword();
/*  71 */   public static final Item EMERALD_AXE = (Item)new EmeraldAxe();
/*  72 */   public static final Item EMERALD_SHOVEL = (Item)new EmeraldShovel();
/*  73 */   public static final Item EMERALD_HOE = (Item)new EmeraldHoe();
/*     */   
/*  75 */   public static final Item AMETHYST_PICKAXE = (Item)new GenericPickaxe("amethyst_pickaxe", OrespawnToolMaterial.AmethystTools);
/*  76 */   public static final Item AMETHYST_SWORD = (Item)new GenericSword("amethyst_sword", OrespawnToolMaterial.AmethystTools);
/*  77 */   public static final Item AMETHYST_AXE = (Item)new GenericAxe("amethyst_axe", OrespawnToolMaterial.AmethystTools);
/*  78 */   public static final Item AMETHYST_SHOVEL = (Item)new GenericShovel("amethyst_shovel", OrespawnToolMaterial.AmethystTools);
/*  79 */   public static final Item AMETHYST_HOE = (Item)new GenericHoe("amethyst_hoe", OrespawnToolMaterial.AmethystTools);
/*     */ 
/*     */   
/*  82 */   public static final Item CORN = (Item)new ItemCorn();
/*  83 */   public static final Item BUTTERFLY_SEED = (Item)new ItemButterflySeed();
/*  84 */   public static final Item MOSQUITO_SEED = (Item)new ItemMosquitoSeed();
/*  85 */   public static final Item FIREFLY_SEED = (Item)new ItemFireflySeed();
/*  86 */   public static final Item MOTH_SEED = (Item)new ItemMothSeed();
/*     */ 
/*     */ 
/*     */   
/*  90 */   public static final Item ALOSAURUS_EGG = (Item)new ItemGenericEgg("alosaurus_egg", Alosaurus.class);
/*  91 */   public static final Item BARYONYX_EGG = (Item)new ItemGenericEgg("baryonyx_egg", Baryonyx.class);
/*  92 */   public static final Item CAMARASAURUS_EGG = (Item)new ItemGenericEgg("camarasaurus_egg", Camarasaurus.class);
/*  93 */   public static final Item CRYOLOPHOSAURUS_EGG = (Item)new ItemGenericEgg("cryolophosaurus_egg", Cryolophosaurus.class);
/*  94 */   public static final Item POINTYSAURUS_EGG = (Item)new ItemGenericEgg("pointysaurus_egg", Pointysaurus.class);
/*  95 */   public static final Item TREX_EGG = (Item)new ItemGenericEgg("trex_egg", TRex.class);
/*  96 */   public static final Item CAVEFISHER_EGG = (Item)new ItemGenericEgg("cavefisher_egg", CaveFisher.class);
/*     */   
/*  98 */   public static final Item BUTTERFLY_EGG = (Item)new ItemGenericEgg("butterfly_egg", Butterfly.class);
/*  99 */   public static final Item BIRD_EGG = (Item)new ItemGenericEgg("bird_egg", Bird.class);
/* 100 */   public static final Item RED_ANT_EGG = (Item)new ItemGenericEgg("red_ant_egg", RedAnt.class);
/*     */   
/* 102 */   public static final Item GAMMAMETROID_EGG = (Item)new ItemGenericEgg("gammametroid_egg", GammaMetroid.class);
/* 103 */   public static final Item SPYRO_EGG = (Item)new ItemGenericEgg("spyro_egg", Spyro.class);
/* 104 */   public static final Item DRAGONFLY_EGG = (Item)new ItemGenericEgg("dragonfly_egg", Dragonfly.class);
/* 105 */   public static final Item FIREFLY_EGG = (Item)new ItemGenericEgg("firefly_egg", Firefly.class);
/* 106 */   public static final Item MOSQUITO_EGG = (Item)new ItemGenericEgg("mosquito_egg", Mosquito.class);
/* 107 */   public static final Item NASTYSAURUS_EGG = (Item)new ItemGenericEgg("nastysaurus_egg", Nastysaurus.class);
/* 108 */   public static final Item ALIEN_EGG = (Item)new ItemGenericEgg("alien_egg", Alien.class);
/* 109 */   public static final Item VELOCITYRAPTOR_EGG = (Item)new ItemGenericEgg("velocityraptor_egg", VelocityRaptor.class);
/*     */   
/* 111 */   public static final Item WORM_TOOTH = (Item)new ItemBasic("worm_tooth");
/* 112 */   public static final Item WORM_FOOD = (Item)new ItemBasic("worm_food");
/*     */   
/* 114 */   public static final Item SMALLWORM_EGG = (Item)new ItemGenericEgg("smallworm_egg", WormSmall.class);
/* 115 */   public static final Item MEDIUMWORM_EGG = (Item)new ItemGenericEgg("mediumworm_egg", WormMedium.class);
/* 116 */   public static final Item LARGEWORM_EGG = (Item)new ItemGenericEgg("largeworm_egg", WormLarge.class);
/* 117 */   public static final Item DOOMWORM_EGG = (Item)new ItemGenericEgg("doomworm_egg", WormDoom.class);
/*     */   
/* 119 */   public static final Item SMALLWORM_CAGE = (Item)new CritterCage(WormSmall.class, "smallworm_cage", 0.4F);
/* 120 */   public static final Item MEDIUMWORM_CAGE = (Item)new CritterCage(WormMedium.class, "mediumworm_cage", 0.4F);
/* 121 */   public static final Item LARGEWORM_CAGE = (Item)new CritterCage(WormLarge.class, "largeworm_cage", 0.4F);
/*     */   
/* 123 */   public static final Item MOTH_EGG = (Item)new ItemGenericEgg("moth_egg", Moth.class);
/* 124 */   public static final Item KYUUBI_EGG = (Item)new ItemGenericEgg("kyuubi_egg", Kyuubi.class);
/* 125 */   public static final Item MANTIS_EGG = (Item)new ItemGenericEgg("mantis_egg", Mantis.class);
/* 126 */   public static final Item MONTHRA_EGG = (Item)new ItemGenericEgg("mothra_egg", Mothra.class);
/* 127 */   public static final Item BRUTALFLY_EGG = (Item)new ItemGenericEgg("brutalfly_egg", Brutalfly.class);
/* 128 */   public static final Item BEAVER_EGG = (Item)new ItemGenericEgg("beaver_egg", Beaver.class);
/*     */   
/* 130 */   public static final Item KYUUBI_CAGE = (Item)new CritterCage(Kyuubi.class, "kyuubi_cage", 0.4F);
/* 131 */   public static final Item MANTIS_CAGE = (Item)new CritterCage(Mantis.class, "mantis_cage", 0.4F);
/* 132 */   public static final Item MONTHRA_CAGE = (Item)new CritterCage(Mothra.class, "mothra_cage", 0.4F);
/* 133 */   public static final Item BRUTALFLY_CAGE = (Item)new CritterCage(Brutalfly.class, "brutalfly_cage", 0.4F);
/* 134 */   public static final Item BEAVER_CAGE = (Item)new CritterCage(Beaver.class, "beaver_cage", 0.4F);
/*     */   
/* 136 */   public static final Item MOTH_SCALE = (Item)new ItemBasic("moth_scale");
/* 137 */   public static final Item MANTIS_CLAW = (Item)new ItemBasic("mantis_claw");
/*     */   
/* 139 */   public static final Item MOTH_HELMET = (Item)new ArmorBase("moth_helmet", OrespawnArmorMaterial.MothArmor, EntityEquipmentSlot.HEAD);
/* 140 */   public static final Item MOTH_CHESTPLATE = (Item)new ArmorBase("moth_chestplate", OrespawnArmorMaterial.MothArmor, EntityEquipmentSlot.CHEST);
/* 141 */   public static final Item MOTH_LEGGINGS = (Item)new ArmorBase("moth_leggings", OrespawnArmorMaterial.MothArmor, EntityEquipmentSlot.LEGS);
/* 142 */   public static final Item MOTH_BOOTS = (Item)new ArmorBase("moth_boots", OrespawnArmorMaterial.MothArmor, EntityEquipmentSlot.FEET);
/*     */   
/* 144 */   public static final Item AMETHYST_HELMET = (Item)new ArmorBase("amethyst_helmet", OrespawnArmorMaterial.AmethystArmor, EntityEquipmentSlot.HEAD);
/* 145 */   public static final Item AMETHYST_CHESTPLATE = (Item)new ArmorBase("amethyst_chestplate", OrespawnArmorMaterial.AmethystArmor, EntityEquipmentSlot.CHEST);
/* 146 */   public static final Item AMETHYST_LEGGINGS = (Item)new ArmorBase("amethyst_leggings", OrespawnArmorMaterial.AmethystArmor, EntityEquipmentSlot.LEGS);
/* 147 */   public static final Item AMETHYST_BOOTS = (Item)new ArmorBase("amethyst_boots", OrespawnArmorMaterial.AmethystArmor, EntityEquipmentSlot.FEET);
/*     */ 
/*     */   
/* 150 */   public static final Item AMETHYST = (Item)new ItemBasic("amethyst");
/* 151 */   public static final Item TERMITE_EGG = (Item)new ItemGenericEgg("termite_egg", Termite.class);
/* 152 */   public static final Item CASSOWARY_EGG = (Item)new ItemGenericEgg("cassowary_egg", Cassowary.class);
/* 153 */   public static final Item REDCOW_EGG = (Item)new ItemGenericEgg("redcow_egg", RedCow.class);
/* 154 */   public static final Item STINKBUG_EGG = (Item)new ItemGenericEgg("stinkbug_egg", StinkBug.class);
/*     */   
/* 156 */   public static final Item REDCOW_CAGE = (Item)new CritterCage(RedCow.class, "redcow_cage", 0.4F);
/* 157 */   public static final Item STINKBUG_CAGE = (Item)new CritterCage(StinkBug.class, "stinkbug_cage", 0.4F);
/* 158 */   public static final Item CASSOWARY_CAGE = (Item)new CritterCage(Cassowary.class, "cassowary_cage", 0.4F);
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\init\ModItems.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */