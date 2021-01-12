/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.block.BlockDispenser;
/*    */ import net.minecraft.dispenser.BehaviorProjectileDispense;
/*    */ import net.minecraft.dispenser.IBlockSource;
/*    */ import net.minecraft.dispenser.IPosition;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.IProjectile;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ final class MyDispenserBehaviorRock
/*    */   extends BehaviorProjectileDispense
/*    */ {
/*    */   public ItemStack dispenseStack(IBlockSource par1IBlockSource, ItemStack par2ItemStack) {
/* 18 */     World world = par1IBlockSource.getWorld();
/* 19 */     IPosition iposition = BlockDispenser.getDispensePosition(par1IBlockSource);
/* 20 */     EnumFacing enumfacing = BlockDispenser.func_149937_b(par1IBlockSource.getBlockMetadata());
/* 21 */     IProjectile iprojectile = getProjectileEntity(world, iposition);
/* 22 */     iprojectile.setThrowableHeading(enumfacing.getFrontOffsetX(), (enumfacing.getFrontOffsetY() + 0.1F), enumfacing.getFrontOffsetZ(), getProjectileVelocity(), getProjectileInaccuracy());
/* 23 */     EntityThrownRock r = (EntityThrownRock)iprojectile;
/* 24 */     if (par2ItemStack.getItem() == OreSpawnMain.MySmallRock) r.setRockType(1); 
/* 25 */     if (par2ItemStack.getItem() == OreSpawnMain.MyRock) r.setRockType(2); 
/* 26 */     if (par2ItemStack.getItem() == OreSpawnMain.MyRedRock) r.setRockType(3); 
/* 27 */     if (par2ItemStack.getItem() == OreSpawnMain.MyGreenRock) r.setRockType(4); 
/* 28 */     if (par2ItemStack.getItem() == OreSpawnMain.MyBlueRock) r.setRockType(5); 
/* 29 */     if (par2ItemStack.getItem() == OreSpawnMain.MyPurpleRock) r.setRockType(6); 
/* 30 */     if (par2ItemStack.getItem() == OreSpawnMain.MySpikeyRock) r.setRockType(7); 
/* 31 */     if (par2ItemStack.getItem() == OreSpawnMain.MyTNTRock) r.setRockType(8); 
/* 32 */     if (par2ItemStack.getItem() == OreSpawnMain.MyCrystalRedRock) r.setRockType(9); 
/* 33 */     if (par2ItemStack.getItem() == OreSpawnMain.MyCrystalGreenRock) r.setRockType(10); 
/* 34 */     if (par2ItemStack.getItem() == OreSpawnMain.MyCrystalBlueRock) r.setRockType(11); 
/* 35 */     if (par2ItemStack.getItem() == OreSpawnMain.MyCrystalTNTRock) r.setRockType(12); 
/* 36 */     world.spawnEntityInWorld((Entity)iprojectile);
/* 37 */     par2ItemStack.splitStack(1);
/* 38 */     return par2ItemStack;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected IProjectile getProjectileEntity(World par1World, IPosition par2IPosition) {
/* 45 */     EntityThrownRock entityarrow = new EntityThrownRock(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
/* 46 */     return (IProjectile)entityarrow;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MyDispenserBehaviorRock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */