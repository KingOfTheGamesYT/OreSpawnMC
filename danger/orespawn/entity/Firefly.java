/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.init.ModBlocks;
/*     */ import java.util.List;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.passive.EntityAmbientCreature;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Firefly
/*     */   extends EntityAmbientCreature
/*     */ {
/*  28 */   int my_blink = 0;
/*  29 */   int blinker = 0;
/*  30 */   int myspace = 0;
/*     */ 
/*     */   
/*  33 */   private BlockPos currentFlightTarget = null;
/*     */   
/*     */   public Firefly(World par1World) {
/*  36 */     super(par1World);
/*  37 */     this.my_blink = 20 + this.rand.nextInt(20);
/*  38 */     setSize(0.4F, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInRangeToRenderDist(double distance) {
/*  45 */     double d0 = getEntityBoundingBox().getAverageEdgeLength();
/*     */     
/*  47 */     if (Double.isNaN(d0)) {
/*  48 */       d0 = 1.0D;
/*     */     }
/*     */     
/*  51 */     d0 = d0 * 64.0D * 3.0D;
/*  52 */     return (distance < d0 * d0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  57 */     super.applyEntityAttributes();
/*  58 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  59 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);
/*  60 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
/*  61 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  67 */     super.entityInit();
/*     */   }
/*     */   
/*     */   public float getBlink() {
/*  71 */     if (this.blinker < this.my_blink / 2) return 240.0F; 
/*  72 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  80 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  88 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/*  94 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/* 100 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 108 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */ 
/*     */   
/*     */   protected void collideWithNearbyEntities() {}
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 119 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 124 */     return Item.getItemFromBlock(ModBlocks.EXTREME_TORCH);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAIDisabled() {
/* 129 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 138 */     super.onUpdate();
/* 139 */     this.motionY *= 0.600000023841D;
/* 140 */     this.blinker++;
/* 141 */     if (this.blinker > this.my_blink) this.blinker = 0; 
/* 142 */     if (isNoDespawnRequired()) {
/*     */       return;
/*     */     }
/* 145 */     long t = this.world.getWorldTime();
/* 146 */     t %= 24000L;
/* 147 */     if (t > 11000L)
/* 148 */       return;  if (this.world.rand.nextInt(500) == 1) setDead();
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 154 */     int keep_trying = 25;
/* 155 */     if (this.isDead)
/* 156 */       return;  super.updateAITasks();
/*     */ 
/*     */     
/* 159 */     if (this.currentFlightTarget == null) {
/* 160 */       this.currentFlightTarget = new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/* 162 */     if (this.rand.nextInt(40) == 0 || this.currentFlightTarget.distanceSq((int)this.posX, (int)this.posY, (int)this.posZ) < 2.0D) {
/* 163 */       Block bid = Blocks.STONE;
/* 164 */       while (bid != Blocks.AIR && keep_trying != 0) {
/* 165 */         this
/*     */           
/* 167 */           .currentFlightTarget = new BlockPos((int)this.posX + this.rand.nextInt(4) - this.rand.nextInt(4), (int)this.posY + this.rand.nextInt(4) - 2, (int)this.posZ + this.rand.nextInt(4) - this.rand.nextInt(4));
/*     */ 
/*     */ 
/*     */         
/* 171 */         bid = this.world.getBlockState(new BlockPos(this.currentFlightTarget.getX(), this.currentFlightTarget.getY(), this.currentFlightTarget.getZ())).getBlock();
/*     */         
/* 173 */         keep_trying--;
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     double var1 = this.currentFlightTarget.getX() + 0.5D - this.posX;
/* 178 */     double var3 = this.currentFlightTarget.getY() + 0.1D - this.posY;
/* 179 */     double var5 = this.currentFlightTarget.getZ() + 0.5D - this.posZ;
/* 180 */     this.motionX += (Math.signum(var1) * 0.2D - this.motionX) * 0.1D;
/* 181 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.1D;
/* 182 */     this.motionZ += (Math.signum(var5) * 0.2D - this.motionZ) * 0.1D;
/* 183 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 184 */     float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
/* 185 */     this.moveForward = 0.2F;
/* 186 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 195 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fall(float distance, float damageMultiplier) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 221 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 231 */     Block bid = this.world.getBlockState(new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ)).getBlock();
/*     */     
/* 233 */     if (bid != Blocks.AIR) return false; 
/* 234 */     if (this.world.isDaytime()) return false; 
/* 235 */     if (findBuddies() > 10) return false;
/*     */     
/* 237 */     if (this.posY < 50.0D) return false; 
/* 238 */     return true;
/*     */   }
/*     */   
/*     */   private int findBuddies() {
/* 242 */     List var5 = this.world.getEntitiesWithinAABB(Firefly.class, getEntityBoundingBox().expand(20.0D, 8.0D, 20.0D));
/* 243 */     return var5.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 253 */     if (!this.world.isDaytime()) return false; 
/* 254 */     if (isNoDespawnRequired()) return false; 
/* 255 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\Firefly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */