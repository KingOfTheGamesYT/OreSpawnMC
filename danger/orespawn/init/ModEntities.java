/*    */ package danger.orespawn.init;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.entity.Alosaurus;
/*    */ import danger.orespawn.entity.Baryonyx;
/*    */ import danger.orespawn.entity.Bird;
/*    */ import danger.orespawn.entity.Butterfly;
/*    */ import danger.orespawn.entity.Camarasaurus;
/*    */ import danger.orespawn.entity.Cryolophosaurus;
/*    */ import danger.orespawn.entity.EntityCage;
/*    */ import danger.orespawn.entity.Pointysaurus;
/*    */ import danger.orespawn.entity.RedAnt;
/*    */ import danger.orespawn.entity.TRex;
/*    */ import java.util.Collection;
/*    */ import java.util.LinkedList;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EnumCreatureType;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.biome.Biome;
/*    */ import net.minecraftforge.common.BiomeDictionary;
/*    */ import net.minecraftforge.fml.common.registry.EntityRegistry;
/*    */ import net.minecraftforge.fml.common.registry.ForgeRegistries;
/*    */ 
/*    */ 
/*    */ public class ModEntities
/*    */ {
/*    */   public static void registerEntities() {
/* 28 */     registerEntity("alosaurus", (Class)Alosaurus.class, 120, 50);
/* 29 */     registerEntity("trex", (Class)TRex.class, 121, 50);
/* 30 */     registerEntity("baryonyx", (Class)Baryonyx.class, 122, 50);
/* 31 */     registerEntity("camarasaurus", (Class)Camarasaurus.class, 123, 50);
/* 32 */     registerEntity("pointysaurus", (Class)Pointysaurus.class, 124, 50);
/* 33 */     registerEntity("cryolophosaurus", (Class)Cryolophosaurus.class, 126, 50);
/*    */     
/* 35 */     registerEntity("red_ant", (Class)RedAnt.class, 125, 50);
/*    */     
/* 37 */     registerEntity("bird", (Class)Bird.class, 130, 50);
/* 38 */     EntityRegistry.addSpawn(Bird.class, 10, 1, 2, EnumCreatureType.CREATURE, excludeBiomesWithTypes(new BiomeDictionary.Type[] { BiomeDictionary.Type.NETHER, BiomeDictionary.Type.END }));
/*    */     
/* 40 */     registerEntity("butterfly", (Class)Butterfly.class, 129, 50);
/* 41 */     EntityRegistry.addSpawn(Butterfly.class, 10, 1, 1, EnumCreatureType.CREATURE, excludeBiomesWithTypes(new BiomeDictionary.Type[] { BiomeDictionary.Type.NETHER, BiomeDictionary.Type.END }));
/*    */ 
/*    */ 
/*    */     
/* 45 */     EntityRegistry.registerModEntity(new ResourceLocation("orespawn:thrown_critter_cage"), EntityCage.class, "thrown_critter_cage", 150, OreSpawnMain.instance, 50, 1, true);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void registerEntity(String name, Class<? extends Entity> entity, int entity2, int range) {
/* 51 */     EntityRegistry.registerModEntity(new ResourceLocation("orespawn:" + name), entity, name, entity2, OreSpawnMain.instance, range, 1, true);
/*    */   }
/*    */   
/*    */   private static Biome[] excludeBiomesWithTypes(BiomeDictionary.Type... types) {
/* 55 */     LinkedList<Biome> list = new LinkedList<>();
/* 56 */     Collection<Biome> biomes = ForgeRegistries.BIOMES.getValuesCollection();
/* 57 */     for (Biome biome : biomes) {
/* 58 */       for (BiomeDictionary.Type t : types) {
/* 59 */         if (!BiomeDictionary.hasType(biome, t) && 
/* 60 */           !list.contains(biome)) {
/* 61 */           list.add(biome);
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 66 */     list.add(ModBiomes.MINING_BIOME);
/* 67 */     return list.<Biome>toArray(new Biome[0]);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\init\ModEntities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */