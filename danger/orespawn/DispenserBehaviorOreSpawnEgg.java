/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.block.BlockDispenser;
/*    */ import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
/*    */ import net.minecraft.dispenser.IBlockSource;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class DispenserBehaviorOreSpawnEgg
/*    */   extends BehaviorDefaultDispenseItem
/*    */ {
/*    */   public ItemStack dispenseStack(IBlockSource par1IBlockSource, ItemStack par2ItemStack) {
/* 23 */     EnumFacing enumfacing = BlockDispenser.func_149937_b(par1IBlockSource.getBlockMetadata());
/* 24 */     double d0 = par1IBlockSource.getX() + enumfacing.getFrontOffsetX() * 2.0D;
/* 25 */     double d1 = (par1IBlockSource.getYInt() + 0.2F);
/* 26 */     double d2 = par1IBlockSource.getZ() + enumfacing.getFrontOffsetZ() * 2.0D;
/* 27 */     Item it = par2ItemStack.getItem();
/* 28 */     if (it instanceof ItemSpawnEgg) {
/* 29 */       ItemSpawnEgg ise = (ItemSpawnEgg)it;
/* 30 */       Entity entity = ItemSpawnEgg.spawn_something(ise.my_id, par1IBlockSource.getWorld(), (int)d0, (int)d1, (int)d2);
/* 31 */       if (entity instanceof net.minecraft.entity.EntityLivingBase && par2ItemStack.hasDisplayName())
/*    */       {
/* 33 */         ((EntityLiving)entity).setCustomNameTag(par2ItemStack.getDisplayName());
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 38 */     par2ItemStack.splitStack(1);
/* 39 */     return par2ItemStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\DispenserBehaviorOreSpawnEgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */