/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.projectile.EntityFireball;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BetterFireball
/*     */   extends EntityFireball {
/*  23 */   private int xTile = -1;
/*  24 */   private int yTile = -1;
/*  25 */   private int zTile = -1;
/*  26 */   private int inTile = 0;
/*     */   private boolean inGround = false;
/*     */   public EntityLivingBase shootingEntity;
/*     */   private int ticksAlive;
/*  30 */   private int ticksInAir = 0;
/*     */   public double accelerationX;
/*     */   public double accelerationY;
/*     */   public double accelerationZ;
/*  34 */   public int field_92012_e = 1;
/*  35 */   private int notme = 0;
/*     */   private boolean small = false;
/*     */   
/*     */   public BetterFireball(World par1World) {
/*  39 */     super(par1World);
/*  40 */     setSize(1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {}
/*     */   
/*     */   public BetterFireball(World par1World, EntityLivingBase par2EntityLiving, double par3, double par5, double par7) {
/*  47 */     super(par1World);
/*     */     
/*  49 */     this.shootingEntity = par2EntityLiving;
/*  50 */     setSize(1.0F, 1.0F);
/*  51 */     setLocationAndAngles(par2EntityLiving.posX, par2EntityLiving.posY, par2EntityLiving.posZ, par2EntityLiving.rotationYaw, par2EntityLiving.rotationPitch);
/*  52 */     setPosition(this.posX, this.posY, this.posZ);
/*     */     
/*  54 */     this.motionX = this.motionY = this.motionZ = 0.0D;
/*  55 */     double var9 = MathHelper.sqrt(par3 * par3 + par5 * par5 + par7 * par7);
/*  56 */     this.accelerationX = par3 / var9 * 0.1D;
/*  57 */     this.accelerationY = par5 / var9 * 0.1D;
/*  58 */     this.accelerationZ = par7 / var9 * 0.1D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNotMe() {
/*  64 */     this.notme = 1;
/*     */   }
/*     */   
/*     */   public void setBig() {
/*  68 */     this.field_92012_e = 2;
/*     */   }
/*     */   
/*     */   public void setReallyBig() {
/*  72 */     this.field_92012_e = 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSmall() {
/*  77 */     this.small = true;
/*  78 */     setSize(0.3125F, 0.3125F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  87 */     Vec3d var15 = null;
/*  88 */     Vec3d var2 = null;
/*  89 */     RayTraceResult var3 = null;
/*  90 */     Entity var4 = null;
/*  91 */     List<Entity> var5 = null;
/*  92 */     double var6 = 0.0D;
/*  93 */     Entity var9 = null;
/*     */     
/*  95 */     float var10 = 0.3F;
/*  96 */     double var13 = 0.0D;
/*  97 */     float var16 = 0.0F;
/*  98 */     float var17 = 0.0F;
/*  99 */     float var18 = 0.0F;
/*     */ 
/*     */     
/* 102 */     if (this.ticksAlive >= 600 || this.ticksInAir >= 600) {
/*     */       
/* 104 */       setDead();
/*     */       
/*     */       return;
/*     */     } 
/* 108 */     if (!this.world.isRemote && this.shootingEntity != null && this.shootingEntity.isDead) {
/*     */       
/* 110 */       setDead();
/*     */     }
/*     */     else {
/*     */       
/* 114 */       super.onUpdate();
/* 115 */       setFire(1);
/*     */       
/* 117 */       if (this.inGround) {
/*     */         
/* 119 */         Block var1 = this.world.getBlockState(new BlockPos(this.xTile, this.yTile, this.zTile)).getBlock();
/*     */         
/* 121 */         if (var1 != Blocks.AIR)
/*     */         {
/* 123 */           this.ticksAlive++;
/*     */         }
/*     */         
/* 126 */         this.inGround = false;
/* 127 */         this.motionX *= (this.rand.nextFloat() * 0.2F);
/* 128 */         this.motionY *= (this.rand.nextFloat() * 0.2F);
/* 129 */         this.motionZ *= (this.rand.nextFloat() * 0.2F);
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 135 */         this.ticksInAir++;
/*     */       } 
/*     */       
/* 138 */       var15 = new Vec3d(this.posX, this.posY, this.posZ);
/* 139 */       var2 = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/* 140 */       var3 = this.world.rayTraceBlocks(var15, var2, false);
/* 141 */       var15 = new Vec3d(this.posX, this.posY, this.posZ);
/* 142 */       var2 = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/*     */       
/* 144 */       if (var3 != null)
/*     */       {
/* 146 */         var2 = new Vec3d(var3.hitVec.x, var3.hitVec.y, var3.hitVec.z);
/*     */       }
/*     */       
/* 149 */       var4 = null;
/* 150 */       var5 = this.world.getEntitiesWithinAABBExcludingEntity((Entity)this, getEntityBoundingBox().offset(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
/* 151 */       var6 = 0.0D;
/*     */       
/* 153 */       for (int var8 = 0; var8 < var5.size(); var8++) {
/*     */         
/* 155 */         var9 = var5.get(var8);
/* 156 */         if (this.shootingEntity == var9) {
/* 157 */           var3 = null;
/*     */           break;
/*     */         } 
/* 160 */         if (var9 instanceof BetterFireball) {
/* 161 */           var3 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 173 */         if (this.notme != 0 && (
/* 174 */           var9 instanceof net.minecraft.entity.player.EntityPlayer || var9 instanceof Mothra)) {
/* 175 */           var3 = null;
/*     */           
/*     */           break;
/*     */         } 
/*     */         
/* 180 */         if (var9.canBeCollidedWith() && (!var9.isEntityEqual((Entity)this.shootingEntity) || this.ticksInAir >= 25)) {
/*     */ 
/*     */           
/* 183 */           AxisAlignedBB var11 = var9.getEntityBoundingBox().expand(var10, var10, var10);
/* 184 */           RayTraceResult var12 = var11.calculateIntercept(var15, var2);
/*     */           
/* 186 */           if (var12 != null) {
/*     */             
/* 188 */             var13 = var15.distanceTo(var12.hitVec);
/*     */             
/* 190 */             if (var13 < var6 || var6 == 0.0D) {
/*     */               
/* 192 */               var4 = var9;
/* 193 */               var6 = var13;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 199 */       if (var4 != null)
/*     */       {
/* 201 */         var3 = new RayTraceResult(var4);
/*     */       }
/*     */       
/* 204 */       if (var3 != null)
/*     */       {
/* 206 */         onImpact(var3);
/*     */       }
/*     */       
/* 209 */       this.posX += this.motionX;
/* 210 */       this.posY += this.motionY;
/* 211 */       this.posZ += this.motionZ;
/* 212 */       var16 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 213 */       this.rotationYaw = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) + 90.0F;
/*     */       
/* 215 */       for (this.rotationPitch = (float)(Math.atan2(var16, this.motionY) * 180.0D / Math.PI) - 90.0F; this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 220 */       while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
/*     */       {
/* 222 */         this.prevRotationPitch += 360.0F;
/*     */       }
/*     */       
/* 225 */       while (this.rotationYaw - this.prevRotationYaw < -180.0F)
/*     */       {
/* 227 */         this.prevRotationYaw -= 360.0F;
/*     */       }
/*     */       
/* 230 */       while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
/*     */       {
/* 232 */         this.prevRotationYaw += 360.0F;
/*     */       }
/*     */       
/* 235 */       this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
/* 236 */       this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
/* 237 */       var17 = getMotionFactor();
/*     */       
/* 239 */       if (isInWater()) {
/*     */         
/* 241 */         for (int var19 = 0; var19 < 4; var19++) {
/*     */           
/* 243 */           var18 = 0.25F;
/* 244 */           this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * var18, this.posY - this.motionY * var18, this.posZ - this.motionZ * var18, this.motionX, this.motionY, this.motionZ, new int[0]);
/*     */         } 
/*     */         
/* 247 */         var17 = 0.8F;
/*     */       } 
/*     */       
/* 250 */       this.motionX += this.accelerationX;
/* 251 */       this.motionY += this.accelerationY;
/* 252 */       this.motionZ += this.accelerationZ;
/* 253 */       this.motionX *= var17;
/* 254 */       this.motionY *= var17;
/* 255 */       this.motionZ *= var17;
/* 256 */       this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/* 257 */       setPosition(this.posX, this.posY, this.posZ);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onImpact(RayTraceResult par1MovingObjectPosition) {
/* 266 */     if (!this.world.isRemote) {
/*     */       
/* 268 */       if (par1MovingObjectPosition.entityHit != null) {
/* 269 */         if (par1MovingObjectPosition.entityHit instanceof BetterFireball)
/* 270 */           return;  if (par1MovingObjectPosition.entityHit instanceof Mothra)
/* 271 */           return;  if (this.notme != 0 && 
/* 272 */           par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.player.EntityPlayer) {
/* 273 */           setDead();
/*     */           
/*     */           return;
/*     */         } 
/* 277 */         Entity e = par1MovingObjectPosition.entityHit;
/* 278 */         if (e instanceof EntityLiving) {
/* 279 */           EntityLiving el = (EntityLiving)e;
/* 280 */           if (el.width * el.height > 30.0F);
/*     */         } 
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
/* 292 */         if (!this.small) {
/* 293 */           par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, (Entity)this.shootingEntity), 10.0F);
/* 294 */           par1MovingObjectPosition.entityHit.setFire(5);
/*     */         } else {
/* 296 */           par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, (Entity)this.shootingEntity), 5.0F);
/* 297 */           par1MovingObjectPosition.entityHit.setFire(5);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 302 */         int i = par1MovingObjectPosition.getBlockPos().getX();
/* 303 */         int j = par1MovingObjectPosition.getBlockPos().getY();
/* 304 */         int k = par1MovingObjectPosition.getBlockPos().getZ();
/*     */         
/* 306 */         switch (par1MovingObjectPosition.sideHit) {
/*     */           
/*     */           case DOWN:
/* 309 */             j--;
/*     */             break;
/*     */           case UP:
/* 312 */             j++;
/*     */             break;
/*     */           case SOUTH:
/* 315 */             k--;
/*     */             break;
/*     */           case NORTH:
/* 318 */             k++;
/*     */             break;
/*     */           case WEST:
/* 321 */             i--;
/*     */             break;
/*     */           case EAST:
/* 324 */             i++;
/*     */             break;
/*     */         } 
/* 327 */         if (this.world.isAirBlock(new BlockPos(i, j, k))) {
/* 328 */           this.world.setBlockState(new BlockPos(i, j, k), Blocks.FIRE.getDefaultState());
/*     */         }
/*     */       } 
/*     */       
/* 332 */       if (!this.small) {
/* 333 */         this.world.newExplosion((Entity)null, this.posX, this.posY, this.posZ, this.field_92012_e, true, this.world
/* 334 */             .getGameRules().getBoolean("mobGriefing"));
/*     */       }
/* 336 */       setDead();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 345 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 346 */     par1NBTTagCompound.setInteger("ExplosionPower", this.field_92012_e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 354 */     super.readEntityFromNBT(par1NBTTagCompound);
/*     */     
/* 356 */     if (par1NBTTagCompound.hasKey("ExplosionPower"))
/*     */     {
/* 358 */       this.field_92012_e = par1NBTTagCompound.getInteger("ExplosionPower");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\BetterFireball.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */