/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.world.WorldProvider;
/*    */ import net.minecraft.world.WorldServer;
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ import net.minecraft.world.biome.WorldChunkManager;
/*    */ import net.minecraft.world.biome.WorldChunkManagerHell;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ import net.minecraft.world.storage.WorldInfo;
/*    */ import net.minecraftforge.common.DimensionManager;
/*    */ 
/*    */ public class WorldProviderOreSpawn5 extends WorldProvider {
/* 14 */   private BiomeGenUtopianPlains MyPlains = (BiomeGenUtopianPlains)(new BiomeGenUtopianPlains(OreSpawnMain.BiomeCrystalID)).setColor(353825).setBiomeName("Crystal").setTemperatureRainfall(0.7F, 0.5F);
/*    */ 
/*    */   
/*    */   public String getDimensionName() {
/* 18 */     return "Dimension-Crystal";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canRespawnHere() {
/* 23 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerWorldChunkManager() {
/* 28 */     this.MyPlains.setCrystalCreatures();
/* 29 */     this.MyPlains.setHeight(new BiomeGenBase.Height(0.1F, 0.5F));
/* 30 */     this.worldChunkMgr = (WorldChunkManager)new WorldChunkManagerHell(this.MyPlains, 0.01F);
/* 31 */     this.worldChunkMgr.getBiomeGenAt(0, 0).setTemperatureRainfall(0.8F, 0.01F);
/* 32 */     this.dimensionId = OreSpawnMain.DimensionID5;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setWorldTime(long time) {
/* 37 */     WorldServer ws = DimensionManager.getWorld(this.dimensionId);
/* 38 */     if (ws != null) {
/* 39 */       WorldInfo w = ws.getWorldInfo();
/* 40 */       if (w != null) {
/*    */         
/* 42 */         if (time % 24000L > 12000L && ws.areAllPlayersAsleep()) {
/*    */           
/* 44 */           long i = time + 24000L;
/* 45 */           i -= i % 24000L;
/* 46 */           for (int j = 0; j < (MinecraftServer.getServer()).worldServers.length; j++)
/*    */           {
/* 48 */             (MinecraftServer.getServer()).worldServers[j].setWorldTime(i);
/*    */           }
/*    */         } else {
/* 51 */           super.setWorldTime(time);
/*    */         } 
/*    */       } else {
/*    */         
/* 55 */         super.setWorldTime(time);
/*    */       } 
/*    */     } else {
/*    */       
/* 59 */       super.setWorldTime(time);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IChunkProvider createChunkGenerator() {
/* 66 */     return new ChunkProviderOreSpawn5(this.worldObj, this.worldObj.getSeed(), true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\WorldProviderOreSpawn5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */