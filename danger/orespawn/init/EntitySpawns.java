/*    */ package danger.orespawn.init;
/*    */ import danger.orespawn.entity.Bird;
/*    */ import danger.orespawn.entity.Butterfly;
/*    */ import danger.orespawn.entity.CaveFisher;
/*    */ import danger.orespawn.entity.Dragonfly;
/*    */ import danger.orespawn.entity.Firefly;
/*    */ import danger.orespawn.entity.Mosquito;
/*    */ import java.util.Collection;
/*    */ import java.util.LinkedList;
/*    */ import net.minecraft.entity.EnumCreatureType;
/*    */ import net.minecraft.init.Biomes;
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
/*    */   }
/*    */ 
/*    */   
/*    */   private static Biome[] excludeEndNether() {
/* 29 */     LinkedList<Biome> list = new LinkedList<>();
/* 30 */     Collection<Biome> biomes = ForgeRegistries.BIOMES.getValuesCollection();
/* 31 */     for (Biome biome : biomes) {
/* 32 */       if (!biome.getRegistryName().toString().toLowerCase().contains("end") && 
/* 33 */         !biome.getRegistryName().toString().toLowerCase().contains("hell") && 
/* 34 */         !biome.getRegistryName().toString().toLowerCase().contains("void")) {
/* 35 */         list.add(biome);
/*    */       }
/*    */     } 
/* 38 */     return list.<Biome>toArray(new Biome[0]);
/*    */   }
/*    */   
/*    */   private static Biome[] swampsAndLakes() {
/* 42 */     LinkedList<Biome> list = new LinkedList<>();
/* 43 */     Collection<Biome> biomes = ForgeRegistries.BIOMES.getValuesCollection();
/* 44 */     for (Biome biome : biomes) {
/* 45 */       if (biome.getRegistryName().toString().toLowerCase().contains("swamp") || biome
/* 46 */         .getRegistryName().toString().toLowerCase().contains("lake")) {
/* 47 */         list.add(biome);
/*    */       }
/*    */     } 
/* 50 */     return list.<Biome>toArray(new Biome[0]);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\init\EntitySpawns.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */