/*    */ package danger.orespawn.init;
/*    */ import danger.orespawn.entity.Brutalfly;
/*    */ import danger.orespawn.entity.CaveFisher;
/*    */ import danger.orespawn.entity.Dragonfly;
/*    */ import danger.orespawn.entity.Firefly;
/*    */ import danger.orespawn.entity.Kyuubi;
/*    */ import danger.orespawn.entity.Mosquito;
/*    */ import danger.orespawn.entity.StinkBug;
/*    */ import java.util.Collection;
/*    */ import java.util.LinkedList;
/*    */ import net.minecraft.entity.EnumCreatureType;
/*    */ import net.minecraft.world.biome.Biome;
/*    */ import net.minecraftforge.fml.common.registry.EntityRegistry;
/*    */ import net.minecraftforge.fml.common.registry.ForgeRegistries;
/*    */ 
/*    */ public class EntitySpawns {
/*    */   public static void addSpawns() {
/* 18 */     Biome[] biomes = excludeEndNether();
/* 19 */     EntityRegistry.addSpawn(Bird.class, 30, 1, 3, EnumCreatureType.CREATURE, biomes);
/* 20 */     EntityRegistry.addSpawn(Butterfly.class, 15, 1, 1, EnumCreatureType.CREATURE, biomes);
/* 21 */     EntityRegistry.addSpawn(Firefly.class, 15, 1, 1, EnumCreatureType.CREATURE, biomes);
/* 22 */     EntityRegistry.addSpawn(CaveFisher.class, 15, 1, 1, EnumCreatureType.MONSTER, biomes);
/* 23 */     EntityRegistry.addSpawn(Dragonfly.class, 15, 1, 1, EnumCreatureType.CREATURE, swampsAndLakes());
/* 24 */     EntityRegistry.addSpawn(Mosquito.class, 15, 1, 1, EnumCreatureType.CREATURE, new Biome[] { Biomes.SWAMPLAND });
/* 25 */     EntityRegistry.addSpawn(Mantis.class, 10, 1, 1, EnumCreatureType.MONSTER, biomes);
/* 26 */     EntityRegistry.addSpawn(Brutalfly.class, 10, 1, 1, EnumCreatureType.MONSTER, forestsAndJungles());
/* 27 */     EntityRegistry.addSpawn(Kyuubi.class, 15, 1, 1, EnumCreatureType.MONSTER, nether());
/* 28 */     EntityRegistry.addSpawn(Mothra.class, 15, 1, 1, EnumCreatureType.MONSTER, extremeHills());
/* 29 */     EntityRegistry.addSpawn(Beaver.class, 15, 1, 1, EnumCreatureType.CREATURE, forestsAndJungles());
/*    */     
/* 31 */     EntityRegistry.addSpawn(Cassowary.class, 15, 1, 1, EnumCreatureType.CREATURE, extremeHills());
/* 32 */     EntityRegistry.addSpawn(RedCow.class, 15, 1, 1, EnumCreatureType.CREATURE, biomes);
/* 33 */     EntityRegistry.addSpawn(StinkBug.class, 15, 1, 1, EnumCreatureType.CREATURE, forestsAndJungles());
/*    */   }
/*    */   
/*    */   private static Biome[] excludeEndNether() {
/* 37 */     LinkedList<Biome> list = new LinkedList<>();
/* 38 */     Collection<Biome> biomes = ForgeRegistries.BIOMES.getValuesCollection();
/* 39 */     for (Biome biome : biomes) {
/* 40 */       if (!biome.getRegistryName().toString().toLowerCase().contains("end") && 
/* 41 */         !biome.getRegistryName().toString().toLowerCase().contains("hell") && 
/* 42 */         !biome.getRegistryName().toString().toLowerCase().contains("void")) {
/* 43 */         list.add(biome);
/*    */       }
/*    */     } 
/* 46 */     return list.<Biome>toArray(new Biome[0]);
/*    */   }
/*    */   
/*    */   private static Biome[] swampsAndLakes() {
/* 50 */     LinkedList<Biome> list = new LinkedList<>();
/* 51 */     Collection<Biome> biomes = ForgeRegistries.BIOMES.getValuesCollection();
/* 52 */     for (Biome biome : biomes) {
/* 53 */       if (biome.getRegistryName().toString().toLowerCase().contains("swamp") || biome
/* 54 */         .getRegistryName().toString().toLowerCase().contains("lake")) {
/* 55 */         list.add(biome);
/*    */       }
/*    */     } 
/* 58 */     return list.<Biome>toArray(new Biome[0]);
/*    */   }
/*    */   
/*    */   private static Biome[] forestsAndJungles() {
/* 62 */     LinkedList<Biome> list = new LinkedList<>();
/* 63 */     Collection<Biome> biomes = ForgeRegistries.BIOMES.getValuesCollection();
/* 64 */     for (Biome biome : biomes) {
/* 65 */       if (biome.getRegistryName().toString().toLowerCase().contains("forest") || biome
/* 66 */         .getRegistryName().toString().toLowerCase().contains("jungle")) {
/* 67 */         list.add(biome);
/*    */       }
/*    */     } 
/* 70 */     return list.<Biome>toArray(new Biome[0]);
/*    */   }
/*    */   
/*    */   private static Biome[] nether() {
/* 74 */     LinkedList<Biome> list = new LinkedList<>();
/* 75 */     Collection<Biome> biomes = ForgeRegistries.BIOMES.getValuesCollection();
/* 76 */     for (Biome biome : biomes) {
/* 77 */       if (biome.getRegistryName().toString().toLowerCase().contains("hell")) {
/* 78 */         list.add(biome);
/*    */       }
/*    */     } 
/* 81 */     return list.<Biome>toArray(new Biome[0]);
/*    */   }
/*    */   
/*    */   private static Biome[] extremeHills() {
/* 85 */     LinkedList<Biome> list = new LinkedList<>();
/* 86 */     Collection<Biome> biomes = ForgeRegistries.BIOMES.getValuesCollection();
/* 87 */     for (Biome biome : biomes) {
/* 88 */       if (biome.getRegistryName().toString().toLowerCase().contains("extreme")) {
/* 89 */         list.add(biome);
/*    */       }
/*    */     } 
/* 92 */     return list.<Biome>toArray(new Biome[0]);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\init\EntitySpawns.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */