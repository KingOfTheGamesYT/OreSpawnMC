/*    */ package danger.orespawn.entity;
/*    */ 
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.passive.IAnimals;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.util.math.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Butterfly
/*    */   extends EntityCreature
/*    */   implements IAnimals
/*    */ {
/*    */   private BlockPos spawnPosition;
/*    */   public int butterflyType;
/*    */   
/*    */   public Butterfly(World worldIn) {
/* 23 */     super(worldIn);
/* 24 */     setSize(0.4F, 0.4F);
/* 25 */     this.butterflyType = this.rand.nextInt(4) + 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void applyEntityAttributes() {
/* 30 */     super.applyEntityAttributes();
/* 31 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);
/* 32 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateAITasks() {
/* 37 */     super.updateAITasks();
/*    */     
/* 39 */     if (this.spawnPosition != null && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) {
/* 40 */       this.spawnPosition = null;
/*    */     }
/*    */     
/* 43 */     if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0D) {
/* 44 */       this.spawnPosition = new BlockPos((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
/*    */     }
/*    */     
/* 47 */     double d0 = this.spawnPosition.getX() + 0.5D - this.posX;
/* 48 */     double d1 = this.spawnPosition.getY() + 0.1D - this.posY;
/* 49 */     double d2 = this.spawnPosition.getZ() + 0.5D - this.posZ;
/* 50 */     this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
/* 51 */     this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
/* 52 */     this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
/* 53 */     float f = (float)(MathHelper.atan2(this.motionZ, this.motionX) * 57.29577951308232D) - 90.0F;
/* 54 */     float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
/* 55 */     this.moveForward = 0.5F;
/* 56 */     this.rotationYaw += f1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onUpdate() {
/* 61 */     super.onUpdate();
/* 62 */     this.motionY *= 0.6000000238418579D;
/* 63 */     if (this.world.getSkylightSubtracted() > 7)
/* 64 */       setDead(); 
/*    */   }
/*    */   
/*    */   public void fall(float distance, float damageMultiplier) {}
/*    */   
/*    */   protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\entity\Butterfly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */