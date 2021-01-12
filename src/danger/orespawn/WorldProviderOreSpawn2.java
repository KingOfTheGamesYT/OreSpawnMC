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
/*    */ public class WorldProviderOreSpawn2
/*    */   extends WorldProvider {
/*    */   public String getDimensionName() {
/* 16 */     return "Dimension-Extreme";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canRespawnHere() {
/* 21 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerWorldChunkManager() {
/* 26 */     this.worldChunkMgr = (WorldChunkManager)new WorldChunkManagerHell(BiomeGenBase.extremeHills, 0.01F);
/* 27 */     this.worldChunkMgr.getBiomeGenAt(0, 0).setTemperatureRainfall(0.8F, 0.01F);
/* 28 */     this.dimensionId = OreSpawnMain.DimensionID2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setWorldTime(long time) {
/* 33 */     WorldServer ws = DimensionManager.getWorld(this.dimensionId);
/* 34 */     if (ws != null) {
/* 35 */       WorldInfo w = ws.getWorldInfo();
/* 36 */       if (w != null) {
/*    */         
/* 38 */         if (time % 24000L > 12000L && ws.areAllPlayersAsleep()) {
/*    */           
/* 40 */           long i = time + 24000L;
/* 41 */           i -= i % 24000L;
/* 42 */           for (int j = 0; j < (MinecraftServer.getServer()).worldServers.length; j++)
/*    */           {
/* 44 */             (MinecraftServer.getServer()).worldServers[j].setWorldTime(i);
/*    */           }
/*    */         } else {
/* 47 */           super.setWorldTime(time);
/*    */         } 
/*    */       } else {
/*    */         
/* 51 */         super.setWorldTime(time);
/*    */       } 
/*    */     } else {
/*    */       
/* 55 */       super.setWorldTime(time);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IChunkProvider createChunkGenerator() {
/* 62 */     return new ChunkProviderOreSpawn2(this.worldObj, this.worldObj.getSeed(), true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\WorldProviderOreSpawn2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */