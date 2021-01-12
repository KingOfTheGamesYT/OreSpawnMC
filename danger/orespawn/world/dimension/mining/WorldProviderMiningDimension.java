/*    */ package danger.orespawn.world.dimension.mining;
/*    */ 
/*    */ import danger.orespawn.init.DimensionInit;
/*    */ import danger.orespawn.util.Reference;
/*    */ import net.minecraft.init.Biomes;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldProviderMiningDimension
/*    */   extends WorldProvider
/*    */ {
/*    */   public DimensionType getDimensionType() {
/* 29 */     return DimensionInit.MINING;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canRespawnHere() {
/* 34 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IChunkGenerator createChunkGenerator() {
/* 40 */     return new ChunkGeneratorMiningDimension(this.world, getSeed(), (BiomeProvider)new BiomeProviderSingle(Biomes.EXTREME_HILLS_WITH_TREES));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isSurfaceWorld() {
/* 45 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setWorldTime(long time) {
/* 50 */     WorldServer ws = DimensionManager.getWorld(Reference.DimensionMiningID);
/* 51 */     if (ws != null) {
/*    */       
/* 53 */       WorldInfo wi = ws.getWorldInfo();
/* 54 */       if (wi != null)
/*    */       {
/* 56 */         if (time % 24000L > 12000L && ws.areAllPlayersAsleep()) {
/*    */           
/* 58 */           long newTime = time + 24000L;
/* 59 */           newTime -= newTime % 24000L;
/* 60 */           for (int i = 0; i < (ws.getMinecraftServer()).worlds.length; i++)
/*    */           {
/* 62 */             (ws.getMinecraftServer()).worlds[i].setWorldTime(newTime);
/*    */           }
/*    */           return;
/*    */         } 
/*    */       }
/*    */     } 
/* 68 */     super.setWorldTime(time);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespawn\world\dimension\mining\WorldProviderMiningDimension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */