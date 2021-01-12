/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraft.world.biome.WorldChunkManager;
/*     */ import net.minecraft.world.biome.WorldChunkManagerHell;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.storage.WorldInfo;
/*     */ import net.minecraftforge.common.DimensionManager;
/*     */ 
/*     */ public class WorldProviderOreSpawn
/*     */   extends WorldProvider {
/*  14 */   private BiomeGenUtopianPlains MyPlains = (BiomeGenUtopianPlains)(new BiomeGenUtopianPlains(OreSpawnMain.BiomeUtopiaID)).setColor(353825).setBiomeName("Utopia").setTemperatureRainfall(0.7F, 0.5F);
/*     */ 
/*     */   
/*     */   public String getDimensionName() {
/*  18 */     return "Dimension-Utopia";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canRespawnHere() {
/*  23 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWorldTime(long time) {
/*  87 */     WorldServer ws = DimensionManager.getWorld(this.dimensionId);
/*  88 */     if (ws != null) {
/*  89 */       WorldInfo w = ws.getWorldInfo();
/*  90 */       if (w != null) {
/*     */         
/*  92 */         if (time % 24000L > 12000L && ws.areAllPlayersAsleep()) {
/*     */           
/*  94 */           long i = time + 24000L;
/*  95 */           i -= i % 24000L;
/*  96 */           for (int j = 0; j < (MinecraftServer.getServer()).worldServers.length; j++)
/*     */           {
/*  98 */             (MinecraftServer.getServer()).worldServers[j].setWorldTime(i);
/*     */           }
/*     */         } else {
/* 101 */           super.setWorldTime(time);
/*     */         } 
/*     */       } else {
/*     */         
/* 105 */         super.setWorldTime(time);
/*     */       } 
/*     */     } else {
/*     */       
/* 109 */       super.setWorldTime(time);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerWorldChunkManager() {
/* 115 */     this.worldChunkMgr = (WorldChunkManager)new WorldChunkManagerHell(this.MyPlains, 0.5F);
/* 116 */     this.worldChunkMgr.getBiomeGenAt(0, 0).setTemperatureRainfall(0.7F, 0.5F);
/* 117 */     this.dimensionId = OreSpawnMain.DimensionID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IChunkProvider createChunkGenerator() {
/* 123 */     return new ChunkProviderOreSpawn(this.worldObj, this.worldObj.getSeed(), true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\WorldProviderOreSpawn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */