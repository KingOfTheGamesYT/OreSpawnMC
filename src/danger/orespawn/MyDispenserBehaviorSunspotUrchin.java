/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.dispenser.BehaviorProjectileDispense;
/*    */ import net.minecraft.dispenser.IPosition;
/*    */ import net.minecraft.entity.IProjectile;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class MyDispenserBehaviorSunspotUrchin
/*    */   extends BehaviorProjectileDispense
/*    */ {
/*    */   protected IProjectile getProjectileEntity(World par1World, IPosition par2IPosition) {
/* 16 */     SunspotUrchin entityarrow = new SunspotUrchin(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
/* 17 */     return (IProjectile)entityarrow;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MyDispenserBehaviorSunspotUrchin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */