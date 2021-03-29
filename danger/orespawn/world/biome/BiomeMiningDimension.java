/*    */ package danger.orespawn.world.biome;
/*    */ import danger.orespawn.entity.Alien;
/*    */ import danger.orespawn.entity.Alosaurus;
/*    */ import danger.orespawn.entity.Baryonyx;
/*    */ import danger.orespawn.entity.Bird;
/*    */ import danger.orespawn.entity.Butterfly;
/*    */ import danger.orespawn.entity.Camarasaurus;
/*    */ import danger.orespawn.entity.Cryolophosaurus;
/*    */ import danger.orespawn.entity.GammaMetroid;
/*    */ import danger.orespawn.entity.Nastysaurus;
/*    */ import danger.orespawn.entity.Pointysaurus;
/*    */ import danger.orespawn.entity.Spyro;
/*    */ import danger.orespawn.entity.TRex;
/*    */ import net.minecraft.world.biome.Biome;
/*    */ import net.minecraft.world.biome.BiomeHills;
/*    */ 
/*    */ public class BiomeMiningDimension extends BiomeHills {
/*    */   public BiomeMiningDimension() {
/* 19 */     super(BiomeHills.Type.NORMAL, (new Biome.BiomeProperties("Mining Biome")).setBaseHeight(1.0F).setHeightVariation(0.5F).setTemperature(0.2F).setRainfall(0.3F));
/* 20 */     this.spawnableMonsterList.add(new Biome.SpawnListEntry(Alosaurus.class, 100, 1, 1));
/* 21 */     this.spawnableMonsterList.add(new Biome.SpawnListEntry(TRex.class, 100, 1, 1));
/* 22 */     this.spawnableMonsterList.add(new Biome.SpawnListEntry(Pointysaurus.class, 100, 1, 1));
/* 23 */     this.spawnableMonsterList.add(new Biome.SpawnListEntry(Cryolophosaurus.class, 100, 1, 1));
/* 24 */     this.spawnableMonsterList.add(new Biome.SpawnListEntry(Alien.class, 100, 1, 1));
/*    */     
/* 26 */     this.spawnableCreatureList.clear();
/* 27 */     this.spawnableCreatureList.add(new Biome.SpawnListEntry(Baryonyx.class, 200, 1, 1));
/* 28 */     this.spawnableCreatureList.add(new Biome.SpawnListEntry(Camarasaurus.class, 250, 1, 1));
/* 29 */     this.spawnableCreatureList.add(new Biome.SpawnListEntry(Bird.class, 255, 1, 2));
/* 30 */     this.spawnableCreatureList.add(new Biome.SpawnListEntry(Butterfly.class, 100, 1, 1));
/* 31 */     this.spawnableCreatureList.add(new Biome.SpawnListEntry(Spyro.class, 250, 1, 1));
/* 32 */     this.spawnableCreatureList.add(new Biome.SpawnListEntry(GammaMetroid.class, 200, 1, 1));
/* 33 */     this.spawnableCreatureList.add(new Biome.SpawnListEntry(Nastysaurus.class, 200, 1, 1));
/* 34 */     this.spawnableCreatureList.add(new Biome.SpawnListEntry(VelocityRaptor.class, 200, 1, 1));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\world\biome\BiomeMiningDimension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */