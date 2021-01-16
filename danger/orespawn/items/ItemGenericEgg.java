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
/*    */ public class ItemGenericEgg
/*    */   extends Item
/*    */ {
/*    */   Class<? extends Entity> entityClass;
/*    */   
/*    */   public ItemGenericEgg(String name, Class<? extends Entity> entityClass) {
/* 39 */     setUnlocalizedName(name);
/* 40 */     setRegistryName(name);
/* 41 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/* 42 */     this.entityClass = entityClass;
/* 43 */     ModItems.ITEMS.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/* 48 */     if (worldIn.isRemote) return EnumActionResult.SUCCESS; 
/* 49 */     Entity entity = EntityList.createEntityByID(EntityList.getID(this.entityClass), worldIn);
/* 50 */     entity.setPosition(pos.getX(), (pos.getY() + 1), pos.getZ());
/* 51 */     worldIn.spawnEntity(entity);
/* 52 */     ((EntityLiving)entity).playLivingSound();
/* 53 */     return EnumActionResult.SUCCESS;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\items\ItemGenericEgg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */