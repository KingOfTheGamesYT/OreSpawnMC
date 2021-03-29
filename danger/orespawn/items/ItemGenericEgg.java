/*    */ package danger.orespawn.items;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityList;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.EnumActionResult;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.EnumHand;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
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
/*    */ public class ItemGenericEgg
/*    */   extends Item
/*    */ {
/*    */   Class<? extends Entity> entityClass;
/*    */   
/*    */   public ItemGenericEgg(String name, Class<? extends Entity> entityClass) {
/* 42 */     setUnlocalizedName(name);
/* 43 */     setRegistryName(name);
/* 44 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 45 */     this.entityClass = entityClass;
/* 46 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */   
/*    */   public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/* 50 */     if (worldIn.isRemote) return EnumActionResult.SUCCESS; 
/* 51 */     Entity entity = EntityList.newEntity(this.entityClass, worldIn);
/*    */     
/* 53 */     assert entity != null;
/* 54 */     entity.setPosition(pos.getX(), (pos.getY() + 1), pos.getZ());
/* 55 */     worldIn.spawnEntity(entity);
/* 56 */     ((EntityLiving)entity).playLivingSound();
/* 57 */     if (!player.isCreative()) {
/* 58 */       player.getHeldItem(hand).shrink(1);
/*    */     }
/* 60 */     return EnumActionResult.SUCCESS;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\items\ItemGenericEgg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */