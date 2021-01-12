/*    */ package danger.orespawn.init;
/*    */ 
/*    */ import net.minecraft.world.biome.Biome;
/*    */ import net.minecraftforge.common.BiomeDictionary;
/*    */ import net.minecraftforge.common.BiomeManager;
/*    */ import net.minecraftforge.fml.common.registry.ForgeRegistries;
/*    */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BiomeInit
/*    */ {
/*    */   public static void registerBiomes() {}
/*    */   
/*    */   private static Biome initBiome(Biome biome, String name, BiomeManager.BiomeType biomeType, BiomeDictionary.Type... types) {
/* 20 */     biome.setRegistryName(name);
/* 21 */     ForgeRegistries.BIOMES.register((IForgeRegistryEntry)biome);
/*    */     
/* 23 */     System.out.println("Registered " + name + " biome");
/* 24 */     BiomeDictionary.addTypes(biome, types);
/*    */     
/* 26 */     BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, 10));
/* 27 */     BiomeManager.addSpawnBiome(biome);
/* 28 */     return biome;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\init\BiomeInit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */