/*    */ package danger.orespawn.entity;
/*    */ 
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.passive.IAnimals;
/*    */ import net.minecraft.network.datasync.DataParameter;
/*    */ import net.minecraft.network.datasync.DataSerializers;
/*    */ import net.minecraft.network.datasync.EntityDataManager;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.util.math.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class Butterfly
/*    */   extends EntityCreature
/*    */   implements IAnimals
/*    */ {
/* 19 */   protected static final DataParameter<Integer> TYPE = EntityDataManager.createKey(Butterfly.class, DataSerializers.VARINT);
/*    */   private BlockPos spawnPosition;
/*    */   
/*    */   public Butterfly(World worldIn) {
/* 23 */     super(worldIn);
/* 24 */     setSize(0.4F, 0.4F);
/* 25 */     this.butterflyType = this.rand.nextInt(4) + 1;
/*    */   }
/*    */   public int butterflyType;
/*    */   
/*    */   public void applyEntityAttributes() {
/* 30 */     super.applyEntityAttributes();
/* 31 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateAITasks() {
/* 36 */     super.updateAITasks();
/*    */     
/* 38 */     if (this.spawnPosition != null && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) {
/* 39 */       this.spawnPosition = null;
/*    */     }
/*    */     
/* 42 */     if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0D) {
/* 43 */       this.spawnPosition = new BlockPos((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
/*    */     }
/*    */     
/* 46 */     double d0 = this.spawnPosition.getX() + 0.5D - this.posX;
/* 47 */     double d1 = this.spawnPosition.getY() + 0.1D - this.posY;
/* 48 */     double d2 = this.spawnPosition.getZ() + 0.5D - this.posZ;
/* 49 */     this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
/* 50 */     this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
/* 51 */     this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
/* 52 */     float f = (float)(MathHelper.atan2(this.motionZ, this.motionX) * 57.29577951308232D) - 90.0F;
/* 53 */     float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
/* 54 */     this.moveForward = 0.5F;
/* 55 */     this.rotationYaw += f1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onUpdate() {
/* 60 */     super.onUpdate();
/* 61 */     this.motionY *= 0.6000000238418579D;
/*    */   }
/*    */   
/*    */   public void fall(float distance, float damageMultiplier) {}
/*    */   
/*    */   protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespawn\entity\Butterfly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */