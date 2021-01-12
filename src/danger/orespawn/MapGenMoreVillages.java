/*    */ package danger.orespawn;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.world.gen.structure.MapGenVillage;
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
/*    */ 
/*    */ public class MapGenMoreVillages
/*    */   extends MapGenVillage
/*    */ {
/* 31 */   private int distance = 9;
/* 32 */   private int minTownSeparation = 7;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean canSpawnStructureAtCoords(int par1, int par2) {
/* 38 */     int var3 = par1;
/* 39 */     int var4 = par2;
/*    */     
/* 41 */     if (par1 < 0)
/*    */     {
/* 43 */       par1 -= this.distance - 1;
/*    */     }
/*    */     
/* 46 */     if (par2 < 0)
/*    */     {
/* 48 */       par2 -= this.distance - 1;
/*    */     }
/*    */     
/* 51 */     int var5 = par1 / this.distance;
/* 52 */     int var6 = par2 / this.distance;
/* 53 */     Random var7 = this.worldObj.setRandomSeed(var5, var6, 10387312);
/* 54 */     var5 *= this.distance;
/* 55 */     var6 *= this.distance;
/* 56 */     var5 += var7.nextInt(this.distance - this.minTownSeparation);
/* 57 */     var6 += var7.nextInt(this.distance - this.minTownSeparation);
/*    */     
/* 59 */     if (var3 == var5 && var4 == var6) {
/*    */       
/* 61 */       boolean var8 = this.worldObj.getWorldChunkManager().areBiomesViable(var3 * 16 + 8, var4 * 16 + 8, 0, villageSpawnBiomes);
/*    */ 
/*    */       
/* 64 */       return true;
/*    */     } 
/*    */ 
/*    */     
/* 68 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MapGenMoreVillages.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */