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
/*  38 */   public int inarow = 0; public float ten;
/*  39 */   public float eleven = 0.0F; public float rotation_pitch;
/*  40 */   public float rotation_yaw_motion = 0.0F; public float rotation_roll;
/*     */   Block bid;
/*  42 */   float updown = 0.0F;
/*     */   
/*     */   public double renderX;
/*     */   public double renderY;
/*     */   public double renderZ;
/*     */   
/*     */   public WormDoom(World worldIn) {
/*  49 */     super(worldIn);
/*  50 */     setRenderDistanceWeight(12.0D);
/*  51 */     this.ignoreFrustumCheck = true;
/*  52 */     this.rotationYaw = 1.0F;
/*     */     
/*  54 */     this.noClip = true;
/*  55 */     double mx = ((float)Math.sin(Math.toRadians(this.rotationYaw)) * 0.75F);
/*  56 */     double mz = ((float)Math.cos(Math.toRadians(this.rotationYaw)) * 0.75F);
/*  57 */     mx /= 2.0D;
/*  58 */     mz /= 2.0D;
/*  59 */     for (int i = 0; i < 100; i++) {
/*  60 */       this.lposx[i] = this.posX - mx * i * 1.5D;
/*  61 */       this.lposy[i] = this.posY + ((float)Math.sin(Math.toRadians((i * 10 + 180))) * 4.0F);
/*  62 */       this.lposz[i] = this.posZ - mz * i * 1.5D;
/*  63 */       this.rotpitch[i] = 0.0D;
/*  64 */       this.rotyaw[i] = this.rotationYaw;
/*     */     } 
/*  66 */     this.ten = worldIn.rand.nextFloat() * 360.0F;
/*  67 */     this.eleven = this.rotationYaw;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isInRangeToRenderDist(double distance) {
/*  72 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isInRangeToRender3d(double x, double y, double z) {
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  84 */     super.onUpdate();
/*  85 */     double x = this.posX;
/*  86 */     double y = this.posY;
/*  87 */     double z = this.posZ;
/*     */     
/*  89 */     if (this.world.isRemote) {
/*  90 */       for (int i = 99; i > 0; i--) {
/*  91 */         this.lposx[i] = this.lposx[i - 1];
/*  92 */         this.lposy[i] = this.lposy[i - 1];
/*  93 */         this.lposz[i] = this.lposz[i - 1];
/*     */         
/*  95 */         this.rotpitch[i] = this.rotpitch[i - 1];
/*  96 */         this.rotyaw[i] = this.rotyaw[i - 1];
/*     */       } 
/*  98 */       this.lposx[0] = x;
/*  99 */       this.lposy[0] = y;
/* 100 */       this.lposz[0] = z;
/*     */       
/* 102 */       this.rotpitch[0] = this.rotationPitch;
/* 103 */       this.rotyaw[0] = this.rotationYaw;
/*     */     } else {
/* 105 */       float myspeed = 0.3F;
/* 106 */       if (isChild()) myspeed = 0.2F;
/*     */       
/* 108 */       this.motionX = ((float)Math.sin(Math.toRadians(this.rotationYaw)) * myspeed);
/* 109 */       this.motionZ = ((float)Math.cos(Math.toRadians(this.rotationYaw)) * myspeed);
/*     */       
/* 111 */       int k = 0;
/* 112 */       int ht = 6;
/* 113 */       float frq = 10.0F;
/*     */       
/* 115 */       if (isChild()) {
/* 116 */         ht = 3;
/* 117 */         frq = 20.0F;
/*     */       } 
/* 119 */       for (k = ht; k >= -ht; k--) {
/* 120 */         this.bid = this.world.getBlockState(new BlockPos((int)this.posX, (int)this.posY + k, (int)this.posZ)).getBlock();
/* 121 */         if (this.bid != Blocks.AIR) {
/*     */           break;
/*     */         }
/*     */       } 
/* 125 */       this.updown = (float)Math.sin(Math.toRadians((this.ten * frq))) * ht;
/* 126 */       this.updown -= k;
/* 127 */       this.updown = -this.updown;
/* 128 */       this.motionY *= 0.9800000190734863D;
/*     */       
/* 130 */       this.motionY += (0.008F * this.updown);
/*     */       
/* 132 */       this.ten = (this.ten + 0.5F) % 360.0F;
/*     */ 
/*     */       
/* 135 */       float dx = (float)Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 136 */       float dz = (float)Math.atan2(-this.motionY, dx);
/*     */       
/* 138 */       this.rotationPitch = (float)Math.toDegrees(dz);
/*     */ 
/*     */       
/* 141 */       float cdir = (float)Math.toRadians(this.rotationYaw);
/* 142 */       float tdir = (float)Math.toRadians(this.eleven);
/* 143 */       float ddiff = tdir - cdir;
/* 144 */       for (; ddiff > Math.PI; ddiff = (float)(ddiff - 6.283185307179586D));
/* 145 */       for (; ddiff < -3.141592653589793D; ddiff = (float)(ddiff + 6.283185307179586D));
/* 146 */       this.rotation_yaw_motion *= 0.95F;
/* 147 */       this.rotation_yaw_motion = (float)(this.rotation_yaw_motion + (ddiff * 180.0F) / Math.PI / 20.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasNoGravity() {
/* 153 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fall(float distance, float damageMultiplier) {}
/*     */ 
/*     */   
/*     */   protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}
/*     */   
/*     */   protected void applyEntityAttributes() {
/* 163 */     super.applyEntityAttributes();
/* 164 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3000.0D);
/* 165 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/* 171 */     int which = this.world.rand.nextInt(4);
/* 172 */     if (which == 0) return SoundsHandler.ENTITY_CATERKILLER_LIVING1; 
/* 173 */     if (which == 1) return SoundsHandler.ENTITY_CATERKILLER_LIVING2; 
/* 174 */     if (which == 2) return SoundsHandler.ENTITY_CATERKILLER_LIVING3; 
/* 175 */     return SoundsHandler.ENTITY_CATERKILLER_LIVING4;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/* 181 */     return SoundsHandler.ENTITY_ALOSAURUS_HURT;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getDeathSound() {
/* 187 */     return SoundsHandler.ENTITY_ALOSAURUS_DEATH;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\WormDoom.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */