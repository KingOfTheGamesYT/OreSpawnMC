/*    */ package danger.orespawn.world.dimension.mining;
/*    */ 
/*    */ import danger.orespawn.init.ModBiomes;
/*    */ import danger.orespawn.init.ModDimensions;
/*    */ import danger.orespawn.util.Reference;
/*    */ import net.minecraft.world.DimensionType;
/*    */ import net.minecraft.world.WorldProvider;
/*    */ import net.minecraft.world.WorldServer;
/*    */ import net.minecraft.world.biome.BiomeProvider;
/*    */ import net.minecraft.world.biome.BiomeProviderSingle;
/*    */ import net.minecraft.world.gen.IChunkGenerator;
/*    */ import net.minecraft.world.storage.WorldInfo;
/*    */ import net.minecraftforge.common.DimensionManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldProviderMiningDimension
/*    */   extends WorldProvider
/*    */ {
/*    */   public DimensionType getDimensionType() {
/* 24 */     return ModDimensions.MINING;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canRespawnHere() {
/* 29 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IChunkGenerator createChunkGenerator() {
/* 35 */     return new ChunkGeneratorMiningDimension(this.world, getSeed(), (BiomeProvider)new BiomeProviderSingle(ModBiomes.MINING_BIOME));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isSurfaceWorld() {
/* 40 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setWorldTime(long time) {
/* 45 */     WorldServer ws = DimensionManager.getWorld(Reference.DimensionMiningID);
/* 46 */     if (ws != null) {
/* 47 */       WorldInfo wi = ws.getWorldInfo();
/* 48 */       if (wi != null && 
/* 49 */         time % 24000L > 12000L && ws.areAllPlayersAsleep()) {
/* 50 */         long newTime = time + 24000L;
/* 51 */         newTime -= newTime % 24000L;
/* 52 */         for (int i = 0; i < (ws.getMinecraftServer()).worlds.length; i++) {
/* 53 */           (ws.getMinecraftServer()).worlds[i].setWorldTime(newTime);
/*    */         }
/*    */         
/*    */         return;
/*    */       } 
/*    */     } 
/* 59 */     super.setWorldTime(time);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\world\dimension\mining\WorldProviderMiningDimension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */