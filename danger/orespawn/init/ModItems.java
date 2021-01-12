/*    */ package danger.orespawn.init;
/*    */ 
/*    */ import danger.orespawn.entity.Alosaurus;
/*    */ import danger.orespawn.entity.TRex;
/*    */ import danger.orespawn.items.CritterCage;
/*    */ import danger.orespawn.items.ItemMaterial;
/*    */ import danger.orespawn.items.armor.ArmorBase;
/*    */ import danger.orespawn.items.armor.OrespawnArmorMaterial;
/*    */ import danger.orespawn.items.tools.UltimateAxe;
/*    */ import danger.orespawn.items.tools.UltimatePickaxe;
/*    */ import danger.orespawn.items.tools.UltimateSword;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.EntityList;
/*    */ import net.minecraft.inventory.EntityEquipmentSlot;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ 
/*    */ public class ModItems
/*    */ {
/* 21 */   public static final List<Item> ITEMS = new ArrayList<>();
/*    */ 
/*    */   
/* 24 */   public static final Item URANIUMNUGGET = (Item)new ItemMaterial("uranium_nugget");
/* 25 */   public static final Item TITANIUMNUGGET = (Item)new ItemMaterial("titanium_nugget");
/* 26 */   public static final Item TREXTOOTH = (Item)new ItemMaterial("trextooth");
/* 27 */   public static final Item CageEmpty = (Item)new CritterCage(-10, "empty_cage");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   public static final Item CageAlosaurus = (Item)new CritterCage(EntityList.getID(Alosaurus.class), "alosaurus_cage", 0.4F);
/* 35 */   public static final Item CageTRex = (Item)new CritterCage(EntityList.getID(TRex.class), "trex_cage", 0.4F);
/*    */ 
/*    */   
/* 38 */   public static final Item UltimateHelmet = (Item)new ArmorBase("ultimate_helmet", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.HEAD);
/* 39 */   public static final Item UltimateChestplate = (Item)new ArmorBase("ultimate_chestplate", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.CHEST);
/* 40 */   public static final Item UltimateLeggings = (Item)new ArmorBase("ultimate_leggings", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.LEGS);
/* 41 */   public static final Item UltimateBoots = (Item)new ArmorBase("ultimate_boots", OrespawnArmorMaterial.UltimateArmor, EntityEquipmentSlot.FEET);
/*    */   
/* 43 */   public static final Item UltimatePickaxe = (Item)new UltimatePickaxe();
/* 44 */   public static final Item UltimateSword = (Item)new UltimateSword();
/* 45 */   public static final Item UltimateAxe = (Item)new UltimateAxe();
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespawn\init\ModItems.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */