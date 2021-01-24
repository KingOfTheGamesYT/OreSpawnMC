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
/*    */ public class ItemGenericEgg
/*    */   extends Item
/*    */ {
/*    */   Class<? extends Entity> entityClass;
/*    */   
/*    */   public ItemGenericEgg(String name, Class<? extends Entity> entityClass) {
/* 41 */     setUnlocalizedName(name);
/* 42 */     setRegistryName(name);
/* 43 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 44 */     this.entityClass = entityClass;
/* 45 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */   
/*    */   public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/* 49 */     if (worldIn.isRemote) return EnumActionResult.SUCCESS; 
/* 50 */     Entity entity = EntityList.newEntity(this.entityClass, worldIn);
/*    */     
/* 52 */     entity.setPosition(pos.getX(), (pos.getY() + 1), pos.getZ());
/* 53 */     worldIn.spawnEntity(entity);
/* 54 */     ((EntityLiving)entity).playLivingSound();
/* 55 */     if (!player.isCreative()) {
/* 56 */       player.getHeldItem(hand).shrink(1);
/*    */     }
/* 58 */     return EnumActionResult.SUCCESS;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\items\ItemGenericEgg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */