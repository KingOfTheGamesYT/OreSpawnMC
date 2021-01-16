/*    */ package danger.orespawn.init;
/*    */ import danger.orespawn.entity.Alosaurus;
/*    */ import danger.orespawn.entity.Baryonyx;
/*    */ import danger.orespawn.entity.Camarasaurus;
/*    */ import danger.orespawn.entity.Cryolophosaurus;
/*    */ import danger.orespawn.entity.Pointysaurus;
/*    */ import danger.orespawn.entity.TRex;
/*    */ import danger.orespawn.items.CritterCage;
/*    */ import danger.orespawn.items.ItemBasic;
/*    */ import danger.orespawn.items.ItemButterflySeed;
/*    */ import danger.orespawn.items.ItemGenericEgg;
/*    */ import danger.orespawn.items.armor.ArmorBase;
/*    */ import danger.orespawn.items.armor.OrespawnArmorMaterial;
/*    */ import danger.orespawn.items.tools.EmeraldPickaxe;
/*    */ import danger.orespawn.items.tools.UltimatePickaxe;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.entity.EntityList;
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
/* 31 */   public static final Item EMPTY_CAGE = (Item)new CritterCage(-10, "empty_cage");
/* 32 */   public static final Item ALOSAURUS_CAGE = (Item)new CritterCage(EntityList.getID(Alosaurus.class), "alosaurus_cage", 0.4F);
/* 33 */   public static final Item TREX_CAGE = (Item)new CritterCage(EntityList.getID(TRex.class), "trex_cage", 0.4F);
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
/*    */   
/* 50 */   public static final Item EMERALD_PICKAXE = (Item)new EmeraldPickaxe();
/* 51 */   public static final Item EMERALD_SWORD = (Item)new EmeraldSword();
/* 52 */   public static final Item EMERALD_AXE = (Item)new EmeraldAxe();
/*    */ 
/*    */ 
/*    */   
/* 56 */   public static final Item CORN = (Item)new ItemCorn();
/* 57 */   public static final Item BUTTERFLY_SEED = (Item)new ItemButterflySeed();
/*    */ 
/*    */ 
/*    */   
/* 61 */   public static final Item ALOSAURUS_EGG = (Item)new ItemGenericEgg("alosaurus_egg", Alosaurus.class);
/* 62 */   public static final Item BARYONYX_EGG = (Item)new ItemGenericEgg("baryonyx_egg", Baryonyx.class);
/* 63 */   public static final Item CAMARASAURUS_EGG = (Item)new ItemGenericEgg("camarasaurus_egg", Camarasaurus.class);
/* 64 */   public static final Item CRYOLOPHOSAURUS_EGG = (Item)new ItemGenericEgg("cryolophosaurus_egg", Cryolophosaurus.class);
/* 65 */   public static final Item POINTYSAURUS_EGG = (Item)new ItemGenericEgg("pointysaurus_egg", Pointysaurus.class);
/* 66 */   public static final Item TREX_EGG = (Item)new ItemGenericEgg("trex_egg", TRex.class);
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\init\ModItems.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */