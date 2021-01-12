/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.world.WorldProvider;
/*    */ import net.minecraft.world.WorldServer;
/*    */ import net.minecraft.world.biome.WorldChunkManager;
/*    */ import net.minecraft.world.biome.WorldChunkManagerHell;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ import net.minecraft.world.storage.WorldInfo;
/*    */ import net.minecraftforge.common.BiomeManager;
/*    */ import net.minecraftforge.common.DimensionManager;
/*    */ 
/*    */ public class WorldProviderOreSpawn3
/*    */   extends WorldProvider {
/* 15 */   private BiomeGenUtopianPlains MyPlains = (BiomeGenUtopianPlains)(new BiomeGenUtopianPlains(OreSpawnMain.BiomeVillageID)).setColor(353825).setBiomeName("Villages").setTemperatureRainfall(0.7F, 0.5F);
/*    */ 
/*    */   
/*    */   public String getDimensionName() {
/* 19 */     return "Dimension-VillageMania";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canRespawnHere() {
/* 24 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerWorldChunkManager() {
/* 29 */     this.MyPlains.setVillageCreatures();
/* 30 */     this.worldChunkMgr = (WorldChunkManager)new WorldChunkManagerHell(this.MyPlains, 0.5F);
/* 31 */     this.worldChunkMgr.getBiomeGenAt(0, 0).setTemperatureRainfall(0.7F, 0.5F);
/* 32 */     this.dimensionId = OreSpawnMain.DimensionID3;
/* 33 */     BiomeManager.addVillageBiome(this.MyPlains, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setWorldTime(long time) {
/* 38 */     WorldServer ws = DimensionManager.getWorld(this.dimensionId);
/* 39 */     if (ws != null) {
/* 40 */       WorldInfo w = ws.getWorldInfo();
/* 41 */       if (w != null) {
/*    */         
/* 43 */         if (time % 24000L > 12000L && ws.areAllPlayersAsleep()) {
/*    */           
/* 45 */           long i = time + 24000L;
/* 46 */           i -= i % 24000L;
/* 47 */           for (int j = 0; j < (MinecraftServer.getServer()).worldServers.length; j++)
/*    */           {
/* 49 */             (MinecraftServer.getServer()).worldServers[j].setWorldTime(i);
/*    */           }
/*    */         } else {
/* 52 */           super.setWorldTime(time);
/*    */         } 
/*    */       } else {
/*    */         
/* 56 */         super.setWorldTime(time);
/*    */       } 
/*    */     } else {
/*    */       
/* 60 */       super.setWorldTime(time);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IChunkProvider createChunkGenerator() {
/* 67 */     return new ChunkProviderOreSpawn3(this.worldObj, this.worldObj.getSeed(), true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\WorldProviderOreSpawn3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */