/*    */ package danger.orespawn.init;
/*    */ import danger.orespawn.entity.TRex;
/*    */ import danger.orespawn.items.CritterCage;
/*    */ import danger.orespawn.items.ItemBasic;
/*    */ import danger.orespawn.items.ItemButterflySeed;
/*    */ import danger.orespawn.items.armor.ArmorBase;
/*    */ import danger.orespawn.items.armor.OrespawnArmorMaterial;
/*    */ import danger.orespawn.items.food.ItemCorn;
/*    */ import danger.orespawn.items.tools.EmeraldPickaxe;
/*    */ import danger.orespawn.items.tools.UltimateAxe;
/*    */ import danger.orespawn.items.tools.UltimatePickaxe;
/*    */ import danger.orespawn.items.tools.UltimateSword;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.EntityList;
/*    */ import net.minecraft.inventory.EntityEquipmentSlot;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class ModItems {
/* 20 */   public static final List<Item> ITEMS = new ArrayList<>();
/*    */   
/* 22 */   public static final Item URANIUM_NUGGET = (Item)new ItemBasic("uranium_nugget");
/* 23 */   public static final Item TITANIUM_NUGGET = (Item)new ItemBasic("titanium_nugget");
/* 24 */   public static final Item URANIUM_INGOT = (Item)new ItemBasic("uranium_ingot");
/* 25 */   public static final Item TITANIUM_INGOT = (Item)new ItemBasic("titanium_ingot");
/*    */   
/* 27 */   public static final Item TREX_TOOTH = (Item)new ItemBasic("trextooth");
/*    */   
/* 29 */   public static final Item EMPTY_CAGE = (Item)new CritterCage(-10, "empty_cage");
/* 30 */   public static final Item ALOSAURUS_CAGE = (Item)new CritterCage(EntityList.getID(Alosaurus.class), "alosaurus_cage", 0.4F);
/* 31 */   public static final Item TREX_CAGE = (Item)new CritterCage(EntityList.getID(TRex.class), "trex_cage", 0.4F);
/*    */ 
/*    */   
/* 34 */   public static final Item ULTIMATE_HELMET = (Item)new ArmorBase("ultimate_helmet", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.HEAD);
/* 35 */   public static final Item ULTIMATE_CHESTPLATE = (Item)new ArmorBase("ultimate_chestplate", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.CHEST);
/* 36 */   public static final Item ULTIMATE_LEGGINGS = (Item)new ArmorBase("ultimate_leggings", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.LEGS);
/* 37 */   public static final Item ULTIMATE_BOOTS = (Item)new ArmorBase("ultimate_boots", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.FEET);
/*    */   
/* 39 */   public static final Item EMERALD_HELMET = (Item)new ArmorBase("emerald_helmet", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.HEAD);
/* 40 */   public static final Item EMERALD_CHESTPLATE = (Item)new ArmorBase("emerald_chestplate", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.CHEST);
/* 41 */   public static final Item EMERALD_LEGGINGS = (Item)new ArmorBase("emerald_leggings", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.LEGS);
/* 42 */   public static final Item EMERALD_BOOTS = (Item)new ArmorBase("emerald_boots", OrespawnArmorMaterial.EmeraldArmor, EntityEquipmentSlot.FEET);
/*    */   
/* 44 */   public static final Item ULTIMATE_PICKAXE = (Item)new UltimatePickaxe();
/* 45 */   public static final Item ULTIMATE_SWORD = (Item)new UltimateSword();
/* 46 */   public static final Item ULTIMATE_AXE = (Item)new UltimateAxe();
/*    */   
/* 48 */   public static final Item EMERALD_PICKAXE = (Item)new EmeraldPickaxe();
/* 49 */   public static final Item EMERALD_SWORD = (Item)new EmeraldSword();
/* 50 */   public static final Item EMERALD_AXE = (Item)new EmeraldAxe();
/*    */ 
/*    */ 
/*    */   
/* 54 */   public static final Item CORN = (Item)new ItemCorn();
/* 55 */   public static final Item BUTTERFLY_SEED = (Item)new ItemButterflySeed();
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespawn\init\ModItems.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */