/*    */ package danger.orespawn.init;
/*    */ 
/*    */ import danger.orespawn.util.Reference;
/*    */ import danger.orespawn.world.dimension.mining.WorldProviderMiningDimension;
/*    */ import net.minecraft.world.DimensionType;
/*    */ import net.minecraftforge.common.DimensionManager;
/*    */ 
/*    */ public class DimensionInit {
/*  9 */   public static final DimensionType MINING = DimensionType.register("Mining Dimension", "_mining", Reference.DimensionMiningID, WorldProviderMiningDimension.class, false);
/*    */ 
/*    */   
/*    */   public static void registerDimensions() {
/* 13 */     DimensionManager.registerDimension(Reference.DimensionMiningID, MINING);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespawn\init\DimensionInit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */