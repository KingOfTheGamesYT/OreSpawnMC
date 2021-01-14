/*    */ package danger.orespawn.init;
/*    */ 
/*    */ import danger.orespawn.world.biome.BiomeMiningDimension;
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
/*    */ public class ModBiomes
/*    */ {
/* 16 */   public static final Biome MINING_BIOME = (Biome)new BiomeMiningDimension();
/*    */ 
/*    */   
/*    */   public static void registerBiomes() {
/* 20 */     initBiome(MINING_BIOME, "Mining Biome", BiomeManager.BiomeType.WARM, new BiomeDictionary.Type[] { BiomeDictionary.Type.HILLS });
/*    */   }
/*    */   
/*    */   private static Biome initBiome(Biome biome, String name, BiomeManager.BiomeType biomeType, BiomeDictionary.Type... types) {
/* 24 */     biome.setRegistryName(name);
/* 25 */     ForgeRegistries.BIOMES.register((IForgeRegistryEntry)biome);
/*    */     
/* 27 */     System.out.println("Registered " + name + " biome");
/* 28 */     BiomeDictionary.addTypes(biome, types);
/*    */ 
/*    */     
/* 31 */     BiomeManager.addSpawnBiome(biome);
/* 32 */     return biome;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespawn\init\ModBiomes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */