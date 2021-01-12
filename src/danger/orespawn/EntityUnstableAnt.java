/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.ai.EntityAIBase;
/*    */ import net.minecraft.entity.ai.EntityAIPanic;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.server.MinecraftServer;
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
/*    */ public class EntityUnstableAnt
/*    */   extends EntityAnt
/*    */ {
/*    */   public EntityUnstableAnt(World par1World) {
/* 31 */     super(par1World);
/*    */     
/* 33 */     setSize(0.1F, 0.1F);
/* 34 */     this.experienceValue = 0;
/* 35 */     getNavigator().setAvoidsWater(true);
/* 36 */     this.tasks.addTask(0, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.399999976158142D));
/* 37 */     this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 9, 1.0D));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void applyEntityAttributes() {
/* 42 */     super.applyEntityAttributes();
/* 43 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/* 44 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 45 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 54 */     if (par1EntityPlayer == null) return false;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 60 */     if (!(par1EntityPlayer instanceof EntityPlayerMP)) return false;
/*    */ 
/*    */     
/* 63 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/* 64 */     if (var2 != null && 
/* 65 */       var2.stackSize <= 0) {
/* 66 */       par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 67 */       var2 = null;
/*    */     } 
/*    */     
/* 70 */     if (var2 != null) {
/* 71 */       return false;
/*    */     }
/*    */     
/* 74 */     if (par1EntityPlayer.dimension != OreSpawnMain.DimensionID4) {
/* 75 */       MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)par1EntityPlayer, OreSpawnMain.DimensionID4, new OreSpawnTeleporter(MinecraftServer.getServer().worldServerForDimension(OreSpawnMain.DimensionID4), OreSpawnMain.DimensionID4, this.worldObj));
/*    */     } else {
/*    */       
/* 78 */       MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)par1EntityPlayer, 0, new OreSpawnTeleporter(MinecraftServer.getServer().worldServerForDimension(0), 0, this.worldObj));
/*    */     } 
/*    */ 
/*    */     
/* 82 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EntityUnstableAnt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */