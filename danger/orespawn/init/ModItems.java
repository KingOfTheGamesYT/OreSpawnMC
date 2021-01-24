/*    */ package danger.orespawn.init;
/*    */ import danger.orespawn.entity.Alosaurus;
/*    */ import danger.orespawn.entity.Baryonyx;
/*    */ import danger.orespawn.entity.Bird;
/*    */ import danger.orespawn.entity.Butterfly;
/*    */ import danger.orespawn.entity.Camarasaurus;
/*    */ import danger.orespawn.entity.TRex;
/*    */ import danger.orespawn.items.CritterCage;
/*    */ import danger.orespawn.items.ItemBasic;
/*    */ import danger.orespawn.items.ItemButterflySeed;
/*    */ import danger.orespawn.items.ItemGenericEgg;
/*    */ import danger.orespawn.items.armor.ArmorBase;
/*    */ import danger.orespawn.items.armor.OrespawnArmorMaterial;
/*    */ import danger.orespawn.items.tools.EmeraldPickaxe;
/*    */ import danger.orespawn.items.tools.UltimateHoe;
/*    */ import danger.orespawn.items.tools.UltimateSword;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.inventory.EntityEquipmentSlot;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class ModItems {
/* 22 */   public static final List<Item> ITEMS = new ArrayList<>();
/*    */   
/* 24 */   public static final Item URANIUM_NUGGET = (Item)new ItemBasic("uranium_nugget");
/* 25 */   public static final Item TITANIUM_NUGGET = (Item)new ItemBasic("titanium_nugget");
/* 26 */   public static final Item URANIUM_INGOT = (Item)new ItemBasic("uranium_ingot");
/* 27 */   public static final Item TITANIUM_INGOT = (Item)new ItemBasic("titanium_ingot");
/*    */   
/* 29 */   public static final Item TREX_TOOTH = (Item)new ItemBasic("trextooth");
/*    */   
/* 31 */   public static final Item EMPTY_CAGE = (Item)new CritterCage(null, "empty_cage");
/* 32 */   public static final Item ALOSAURUS_CAGE = (Item)new CritterCage(Alosaurus.class, "alosaurus_cage", 0.4F);
/* 33 */   public static final Item TREX_CAGE = (Item)new CritterCage(TRex.class, "trex_cage", 0.4F);
/*    */ 
/*    */   
/* 36 */   public static final Item ULTIMATE_HELMET = (Item)new ArmorBase("ultimate_helmet", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.HEAD);
/* 37 */   public static final Item ULTIMATE_CHESTPLATE = (Item)new ArmorBase("ultimate_chestplate", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.CHEST);
/* 38 */   public static final Item ULTIMATE_LEGGINGS = (Item)new ArmorBase("ultimate_leggings", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.LEGS);
/* 39 */   public static final Item ULTIMATE_BOOTS = (Item)new ArmorBase("ultimate_boots", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.FEET);
/*    */   
/* 41 */   public static final Item EMERALD_HELMET = (Item)new ArmorBase("emerald_helmet", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.HEAD);
/* 42 */   public static final Item EMERALD_CHESTPLATE = (Item)new ArmorBase("emerald_chestplate", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.CHEST);
/* 43 */   public static final Item EMERALD_LEGGINGS = (Item)new ArmorBase("emerald_leggings", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.LEGS);
/* 44 */   public static final Item EMERALD_BOOTS = (Item)new ArmorBase("emerald_boots", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.FEET);
/*    */   
/* 46 */   public static final Item ULTIMATE_PICKAXE = (Item)new UltimatePickaxe();
/* 47 */   public static final Item ULTIMATE_SWORD = (Item)new UltimateSword();
/* 48 */   public static final Item ULTIMATE_AXE = (Item)new UltimateAxe();
/* 49 */   public static final Item ULTIMATE_SHOVEL = (Item)new UltimateShovel();
/* 50 */   public static final Item ULTIMATE_HOE = (Item)new UltimateHoe();
/*    */   
/* 52 */   public static final Item EMERALD_PICKAXE = (Item)new EmeraldPickaxe();
/* 53 */   public static final Item EMERALD_SWORD = (Item)new EmeraldSword();
/* 54 */   public static final Item EMERALD_AXE = (Item)new EmeraldAxe();
/* 55 */   public static final Item EMERALD_SHOVEL = (Item)new EmeraldShovel();
/* 56 */   public static final Item EMERALD_HOE = (Item)new EmeraldHoe();
/*    */ 
/*    */ 
/*    */   
/* 60 */   public static final Item CORN = (Item)new ItemCorn();
/* 61 */   public static final Item BUTTERFLY_SEED = (Item)new ItemButterflySeed();
/*    */ 
/*    */ 
/*    */   
/* 65 */   public static final Item ALOSAURUS_EGG = (Item)new ItemGenericEgg("alosaurus_egg", Alosaurus.class);
/* 66 */   public static final Item BARYONYX_EGG = (Item)new ItemGenericEgg("baryonyx_egg", Baryonyx.class);
/* 67 */   public static final Item CAMARASAURUS_EGG = (Item)new ItemGenericEgg("camarasaurus_egg", Camarasaurus.class);
/* 68 */   public static final Item CRYOLOPHOSAURUS_EGG = (Item)new ItemGenericEgg("cryolophosaurus_egg", Cryolophosaurus.class);
/* 69 */   public static final Item POINTYSAURUS_EGG = (Item)new ItemGenericEgg("pointysaurus_egg", Pointysaurus.class);
/* 70 */   public static final Item TREX_EGG = (Item)new ItemGenericEgg("trex_egg", TRex.class);
/*    */   
/* 72 */   public static final Item BUTTERFLY_EGG = (Item)new ItemGenericEgg("butterfly_egg", Butterfly.class);
/* 73 */   public static final Item BIRD_EGG = (Item)new ItemGenericEgg("bird_egg", Bird.class);
/* 74 */   public static final Item RED_ANT_EGG = (Item)new ItemGenericEgg("red_ant_egg", RedAnt.class);
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\init\ModItems.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */