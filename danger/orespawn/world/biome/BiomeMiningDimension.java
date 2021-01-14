/*    */ package danger.orespawn.world.biome;
/*    */ 
/*    */ import danger.orespawn.entity.Alosaurus;
/*    */ import danger.orespawn.entity.Baryonyx;
/*    */ import danger.orespawn.entity.Camarasaurus;
/*    */ import danger.orespawn.entity.Cryolophosaurus;
/*    */ import danger.orespawn.entity.Pointysaurus;
/*    */ import danger.orespawn.entity.TRex;
/*    */ import net.minecraft.world.biome.Biome;
/*    */ import net.minecraft.world.biome.BiomeHills;
/*    */ 
/*    */ public class BiomeMiningDimension extends BiomeHills {
/*    */   public BiomeMiningDimension() {
/* 14 */     super(BiomeHills.Type.NORMAL, (new Biome.BiomeProperties("Mining Biome")).setBaseHeight(1.0F).setHeightVariation(0.5F).setTemperature(0.2F).setRainfall(0.3F));
/* 15 */     this.spawnableMonsterList.add(new Biome.SpawnListEntry(Alosaurus.class, 100, 1, 1));
/* 16 */     this.spawnableMonsterList.add(new Biome.SpawnListEntry(TRex.class, 100, 1, 1));
/* 17 */     this.spawnableMonsterList.add(new Biome.SpawnListEntry(Pointysaurus.class, 100, 1, 1));
/* 18 */     this.spawnableMonsterList.add(new Biome.SpawnListEntry(Cryolophosaurus.class, 100, 1, 1));
/*    */     
/* 20 */     this.spawnableCreatureList.clear();
/* 21 */     this.spawnableCreatureList.add(new Biome.SpawnListEntry(Baryonyx.class, 200, 1, 1));
/* 22 */     this.spawnableCreatureList.add(new Biome.SpawnListEntry(Camarasaurus.class, 250, 1, 1));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespawn\world\biome\BiomeMiningDimension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */