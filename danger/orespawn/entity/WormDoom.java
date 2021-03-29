/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WormDoom
/*     */   extends EntityLiving
/*     */ {
/*  29 */   public double[] lposx = new double[100];
/*  30 */   public double[] lposy = new double[100];
/*  31 */   public double[] lposz = new double[100];
/*     */   
/*  33 */   public double[] rotpitch = new double[100];
/*  34 */   public double[] rotyaw = new double[100];
/*     */   
/*  36 */   public long lasttime = 0L;
/*  37 */   public int backoff = 0;
/*  38 */   public int inarow = 0; public float cycle;
/*  39 */   public float target_direction = 0.0F;
/*  40 */   public float local_rotationYaw = 0.0F;
/*  41 */   public float local_rotation_yaw_motion = 0.0F;
/*     */   Block bid;
/*  43 */   float updown = 0.0F; float local_motionX;
/*     */   float local_motionY;
/*     */   float local_motionZ;
/*     */   
/*     */   public WormDoom(World worldIn) {
/*  48 */     super(worldIn);
/*  49 */     setRenderDistanceWeight(12.0D);
/*  50 */     this.ignoreFrustumCheck = true;
/*  51 */     this.rotationYaw = 1.0F;
/*  52 */     this.local_rotationYaw = 1.0F;
/*     */     
/*  54 */     this.noClip = true;
/*  55 */     double mx = ((float)Math.sin(Math.toRadians(this.local_rotationYaw)) * 0.75F);
/*  56 */     double mz = ((float)Math.cos(Math.toRadians(this.local_rotationYaw)) * 0.75F);
/*  57 */     mx /= 2.0D;
/*  58 */     mz /= 2.0D;
/*  59 */     for (int i = 0; i < 100; i++) {
/*  60 */       this.lposx[i] = this.posX - mx * i * 1.5D;
/*  61 */       this.lposy[i] = this.posY + ((float)Math.sin(Math.toRadians((i * 10 + 180))) * 4.0F);
/*  62 */       this.lposz[i] = this.posZ - mz * i * 1.5D;
/*  63 */       this.rotpitch[i] = 0.0D;
/*  64 */       this.rotyaw[i] = this.local_rotationYaw;
/*     */     } 
/*  66 */     this.cycle = worldIn.rand.nextFloat() * 360.0F;
/*  67 */     this.target_direction = this.local_rotationYaw;
/*     */     
/*  69 */     this.local_motionX = (float)mx;
/*  70 */     this.local_motionY = 0.0F;
/*  71 */     this.local_motionZ = (float)mz;
/*  72 */     this.local_posX = (float)this.posX;
/*  73 */     this.local_posY = (float)this.posY;
/*  74 */     this.local_posZ = (float)this.posZ;
/*     */   }
/*     */   public float local_posX; public float local_posY; public float local_posZ;
/*     */   
/*     */   public boolean isInRangeToRenderDist(double distance) {
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isInRangeToRender3d(double x, double y, double z) {
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  89 */     super.onUpdate();
/*     */ 
/*     */ 
/*     */     
/*  93 */     for (int i = 99; i > 0; i--) {
/*  94 */       this.lposx[i] = this.lposx[i - 1];
/*  95 */       this.lposy[i] = this.lposy[i - 1];
/*  96 */       this.lposz[i] = this.lposz[i - 1];
/*     */       
/*  98 */       this.rotpitch[i] = this.rotpitch[i - 1];
/*  99 */       this.rotyaw[i] = this.rotyaw[i - 1];
/*     */     } 
/* 101 */     this.lposx[0] = this.posX;
/* 102 */     this.lposy[0] = this.posY;
/* 103 */     this.lposz[0] = this.posZ;
/*     */     
/* 105 */     this.rotpitch[0] = this.rotationPitch;
/* 106 */     this.rotyaw[0] = this.rotationYaw;
/*     */ 
/*     */     
/* 109 */     this.motionX = this.motionY = this.motionZ = 0.0D;
/*     */     
/* 111 */     float myspeed = 0.3F;
/* 112 */     if (isChild()) myspeed = 0.2F;
/*     */     
/* 114 */     this.local_motionX = (float)Math.sin(Math.toRadians(this.local_rotationYaw)) * myspeed;
/* 115 */     this.local_motionZ = (float)Math.cos(Math.toRadians(this.local_rotationYaw)) * myspeed;
/*     */     
/* 117 */     int k = 0;
/* 118 */     int ht = 6;
/* 119 */     float frq = 10.0F;
/*     */     
/* 121 */     if (isChild()) {
/* 122 */       ht = 3;
/* 123 */       frq = 20.0F;
/*     */     } 
/* 125 */     for (k = ht; k >= -ht; k--) {
/* 126 */       this.bid = this.world.getBlockState(new BlockPos((int)this.posX, (int)this.posY + k, (int)this.posZ)).getBlock();
/* 127 */       if (this.bid != Blocks.AIR) {
/*     */         break;
/*     */       }
/*     */     } 
/* 131 */     this.updown = (float)Math.sin(Math.toRadians((this.cycle * frq))) * ht;
/* 132 */     this.updown -= k;
/* 133 */     this.updown = -this.updown;
/* 134 */     this.local_motionY *= 0.98F;
/* 135 */     this.local_motionY += 0.008F * this.updown;
/*     */     
/* 137 */     this.cycle = (this.cycle + 0.5F) % 360.0F;
/*     */ 
/*     */     
/* 140 */     float dx = (float)Math.sqrt((this.local_motionX * this.local_motionX + this.local_motionZ * this.local_motionZ));
/* 141 */     float dz = (float)Math.atan2(-this.local_motionY, dx);
/*     */ 
/*     */     
/* 144 */     this.rotationPitch = (float)Math.toDegrees(dz);
/*     */     
/* 146 */     float cdir = (float)Math.toRadians(this.local_rotationYaw);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 155 */     if (this.world.rand.nextInt(100) == 1) this.target_direction = 360.0F * this.world.rand.nextFloat();
/*     */     
/* 157 */     float tdir = (float)Math.toRadians(this.target_direction);
/* 158 */     float ddiff = tdir - cdir;
/* 159 */     for (; ddiff > Math.PI; ddiff = (float)(ddiff - 6.283185307179586D));
/* 160 */     for (; ddiff < -3.141592653589793D; ddiff = (float)(ddiff + 6.283185307179586D));
/* 161 */     this.local_rotation_yaw_motion *= 0.95F;
/* 162 */     this.local_rotation_yaw_motion = (float)(this.local_rotation_yaw_motion + (ddiff * 180.0F) / Math.PI / 20.0D);
/*     */     
/* 164 */     this.local_rotationYaw += this.local_rotation_yaw_motion;
/*     */     
/* 166 */     this.rotationYaw = -this.local_rotationYaw;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     this.motionX = this.local_motionX;
/* 173 */     this.motionY = this.local_motionY;
/* 174 */     this.motionZ = -this.local_motionZ;
/* 175 */     System.out.println(this.motionY);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNoGravity() {
/* 188 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fall(float distance, float damageMultiplier) {}
/*     */ 
/*     */   
/*     */   protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}
/*     */   
/*     */   protected void applyEntityAttributes() {
/* 198 */     super.applyEntityAttributes();
/* 199 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3000.0D);
/* 200 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/* 206 */     int which = this.world.rand.nextInt(4);
/* 207 */     if (which == 0) return SoundsHandler.ENTITY_CATERKILLER_LIVING1; 
/* 208 */     if (which == 1) return SoundsHandler.ENTITY_CATERKILLER_LIVING2; 
/* 209 */     if (which == 2) return SoundsHandler.ENTITY_CATERKILLER_LIVING3; 
/* 210 */     return SoundsHandler.ENTITY_CATERKILLER_LIVING4;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/* 216 */     return SoundsHandler.ENTITY_ALOSAURUS_HURT;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getDeathSound() {
/* 222 */     return SoundsHandler.ENTITY_ALOSAURUS_DEATH;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\WormDoom.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */