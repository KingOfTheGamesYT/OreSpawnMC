/*    */ package danger.orespawn.init;
/*    */ import danger.orespawn.entity.Bird;
/*    */ import danger.orespawn.entity.CaveFisher;
/*    */ import danger.orespawn.entity.Dragonfly;
/*    */ import danger.orespawn.entity.Firefly;
/*    */ import danger.orespawn.entity.GammaMetroid;
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
/* 23 */     EntityRegistry.addSpawn(GammaMetroid.class, 15, 1, 1, EnumCreatureType.MONSTER, biomes);
/* 24 */     EntityRegistry.addSpawn(Dragonfly.class, 15, 1, 1, EnumCreatureType.CREATURE, swampsAndLakes());
/* 25 */     EntityRegistry.addSpawn(Mosquito.class, 15, 1, 1, EnumCreatureType.CREATURE, new Biome[] { Biomes.SWAMPLAND });
/*    */   }
/*    */ 
/*    */   
/*    */   private static Biome[] excludeEndNether() {
/* 30 */     LinkedList<Biome> list = new LinkedList<>();
/* 31 */     Collection<Biome> biomes = ForgeRegistries.BIOMES.getValuesCollection();
/* 32 */     for (Biome biome : biomes) {
/* 33 */       if (!biome.getRegistryName().toString().toLowerCase().contains("end") && 
/* 34 */         !biome.getRegistryName().toString().toLowerCase().contains("hell") && 
/* 35 */         !biome.getRegistryName().toString().toLowerCase().contains("void")) {
/* 36 */         list.add(biome);
/*    */       }
/*    */     } 
/* 39 */     return list.<Biome>toArray(new Biome[0]);
/*    */   }
/*    */   
/*    */   private static Biome[] swampsAndLakes() {
/* 43 */     LinkedList<Biome> list = new LinkedList<>();
/* 44 */     Collection<Biome> biomes = ForgeRegistries.BIOMES.getValuesCollection();
/* 45 */     for (Biome biome : biomes) {
/* 46 */       if (biome.getRegistryName().toString().toLowerCase().contains("swamp") || biome
/* 47 */         .getRegistryName().toString().toLowerCase().contains("lake")) {
/* 48 */         list.add(biome);
/*    */       }
/*    */     } 
/* 51 */     return list.<Biome>toArray(new Biome[0]);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\init\EntitySpawns.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */