/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.projectile.EntityFireball;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BetterFireball
/*     */   extends EntityFireball
/*     */ {
/*  22 */   private int xTile = -1;
/*  23 */   private int yTile = -1;
/*  24 */   private int zTile = -1;
/*  25 */   private int inTile = 0;
/*     */   private boolean inGround = false;
/*     */   public EntityLivingBase shootingEntity;
/*     */   private int ticksAlive;
/*  29 */   private int ticksInAir = 0;
/*     */   public double accelerationX;
/*     */   public double accelerationY;
/*     */   public double accelerationZ;
/*  33 */   public int field_92012_e = 1;
/*  34 */   private int notme = 0;
/*     */   
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
/*  53 */     this.yOffset = 0.0F;
/*  54 */     this.motionX = this.motionY = this.motionZ = 0.0D;
/*     */ 
/*     */ 
/*     */     
/*  58 */     double var9 = MathHelper.sqrt_double(par3 * par3 + par5 * par5 + par7 * par7);
/*  59 */     this.accelerationX = par3 / var9 * 0.1D;
/*  60 */     this.accelerationY = par5 / var9 * 0.1D;
/*  61 */     this.accelerationZ = par7 / var9 * 0.1D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNotMe() {
/*  67 */     this.notme = 1;
/*     */   }
/*     */   
/*     */   public void setBig() {
/*  71 */     this.field_92012_e = 2;
/*     */   }
/*     */   
/*     */   public void setReallyBig() {
/*  75 */     this.field_92012_e = 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSmall() {
/*  80 */     this.small = true;
/*  81 */     setSize(0.3125F, 0.3125F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  90 */     Vec3 var15 = null;
/*  91 */     Vec3 var2 = null;
/*  92 */     MovingObjectPosition var3 = null;
/*  93 */     Entity var4 = null;
/*  94 */     List<Entity> var5 = null;
/*  95 */     double var6 = 0.0D;
/*  96 */     Entity var9 = null;
/*     */     
/*  98 */     float var10 = 0.3F;
/*  99 */     double var13 = 0.0D;
/* 100 */     float var16 = 0.0F;
/* 101 */     float var17 = 0.0F;
/* 102 */     float var18 = 0.0F;
/*     */ 
/*     */     
/* 105 */     if (this.ticksAlive >= 600 || this.ticksInAir >= 600) {
/*     */       
/* 107 */       setDead();
/*     */       
/*     */       return;
/*     */     } 
/* 111 */     if (!this.worldObj.isRemote && ((this.shootingEntity != null && this.shootingEntity.isDead) || !this.worldObj.blockExists((int)this.posX, (int)this.posY, (int)this.posZ))) {
/*     */       
/* 113 */       setDead();
/*     */     }
/*     */     else {
/*     */       
/* 117 */       super.onUpdate();
/* 118 */       setFire(1);
/*     */       
/* 120 */       if (this.inGround) {
/*     */         
/* 122 */         Block var1 = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/*     */         
/* 124 */         if (var1 != Blocks.air)
/*     */         {
/* 126 */           this.ticksAlive++;
/*     */         }
/*     */         
/* 129 */         this.inGround = false;
/* 130 */         this.motionX *= (this.rand.nextFloat() * 0.2F);
/* 131 */         this.motionY *= (this.rand.nextFloat() * 0.2F);
/* 132 */         this.motionZ *= (this.rand.nextFloat() * 0.2F);
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 138 */         this.ticksInAir++;
/*     */       } 
/*     */       
/* 141 */       var15 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 142 */       var2 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/* 143 */       var3 = this.worldObj.rayTraceBlocks(var15, var2, false);
/* 144 */       var15 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 145 */       var2 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/*     */       
/* 147 */       if (var3 != null)
/*     */       {
/* 149 */         var2 = Vec3.createVectorHelper(var3.hitVec.xCoord, var3.hitVec.yCoord, var3.hitVec.zCoord);
/*     */       }
/*     */       
/* 152 */       var4 = null;
/* 153 */       var5 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
/* 154 */       var6 = 0.0D;
/*     */       
/* 156 */       for (int var8 = 0; var8 < var5.size(); var8++) {
/*     */         
/* 158 */         var9 = var5.get(var8);
/* 159 */         if (this.shootingEntity == var9) {
/* 160 */           var3 = null;
/*     */           break;
/*     */         } 
/* 163 */         if (var9 instanceof BetterFireball) {
/* 164 */           var3 = null;
/*     */           break;
/*     */         } 
/* 167 */         if (var9 instanceof GodzillaHead) {
/* 168 */           var3 = null;
/*     */           break;
/*     */         } 
/* 171 */         if (MyUtils.isRoyalty(var9)) {
/* 172 */           var3 = null;
/*     */           
/*     */           break;
/*     */         } 
/* 176 */         if (this.notme != 0 && (
/* 177 */           var9 instanceof net.minecraft.entity.player.EntityPlayer || var9 instanceof Dragon || var9 instanceof Mothra)) {
/* 178 */           var3 = null;
/*     */           
/*     */           break;
/*     */         } 
/*     */         
/* 183 */         if (var9.canBeCollidedWith() && (!var9.isEntityEqual((Entity)this.shootingEntity) || this.ticksInAir >= 25)) {
/*     */ 
/*     */           
/* 186 */           AxisAlignedBB var11 = var9.boundingBox.expand(var10, var10, var10);
/* 187 */           MovingObjectPosition var12 = var11.calculateIntercept(var15, var2);
/*     */           
/* 189 */           if (var12 != null) {
/*     */             
/* 191 */             var13 = var15.distanceTo(var12.hitVec);
/*     */             
/* 193 */             if (var13 < var6 || var6 == 0.0D) {
/*     */               
/* 195 */               var4 = var9;
/* 196 */               var6 = var13;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 202 */       if (var4 != null)
/*     */       {
/* 204 */         var3 = new MovingObjectPosition(var4);
/*     */       }
/*     */       
/* 207 */       if (var3 != null)
/*     */       {
/* 209 */         onImpact(var3);
/*     */       }
/*     */       
/* 212 */       this.posX += this.motionX;
/* 213 */       this.posY += this.motionY;
/* 214 */       this.posZ += this.motionZ;
/* 215 */       var16 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 216 */       this.rotationYaw = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) + 90.0F;
/*     */       
/* 218 */       for (this.rotationPitch = (float)(Math.atan2(var16, this.motionY) * 180.0D / Math.PI) - 90.0F; this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 223 */       while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
/*     */       {
/* 225 */         this.prevRotationPitch += 360.0F;
/*     */       }
/*     */       
/* 228 */       while (this.rotationYaw - this.prevRotationYaw < -180.0F)
/*     */       {
/* 230 */         this.prevRotationYaw -= 360.0F;
/*     */       }
/*     */       
/* 233 */       while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
/*     */       {
/* 235 */         this.prevRotationYaw += 360.0F;
/*     */       }
/*     */       
/* 238 */       this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
/* 239 */       this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
/* 240 */       var17 = getMotionFactor();
/*     */       
/* 242 */       if (isInWater()) {
/*     */         
/* 244 */         for (int var19 = 0; var19 < 4; var19++) {
/*     */           
/* 246 */           var18 = 0.25F;
/* 247 */           this.worldObj.spawnParticle("bubble", this.posX - this.motionX * var18, this.posY - this.motionY * var18, this.posZ - this.motionZ * var18, this.motionX, this.motionY, this.motionZ);
/*     */         } 
/*     */         
/* 250 */         var17 = 0.8F;
/*     */       } 
/*     */       
/* 253 */       this.motionX += this.accelerationX;
/* 254 */       this.motionY += this.accelerationY;
/* 255 */       this.motionZ += this.accelerationZ;
/* 256 */       this.motionX *= var17;
/* 257 */       this.motionY *= var17;
/* 258 */       this.motionZ *= var17;
/* 259 */       this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
/* 260 */       setPosition(this.posX, this.posY, this.posZ);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
/* 269 */     if (!this.worldObj.isRemote) {
/*     */       
/* 271 */       if (par1MovingObjectPosition.entityHit != null) {
/* 272 */         if (par1MovingObjectPosition.entityHit instanceof BetterFireball)
/* 273 */           return;  if (par1MovingObjectPosition.entityHit instanceof Mothra)
/* 274 */           return;  if (this.notme != 0 && (
/* 275 */           par1MovingObjectPosition.entityHit instanceof Dragon || par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.player.EntityPlayer)) {
/* 276 */           setDead();
/*     */           
/*     */           return;
/*     */         } 
/* 280 */         Entity e = par1MovingObjectPosition.entityHit;
/* 281 */         if (e instanceof EntityLiving) {
/* 282 */           EntityLiving el = (EntityLiving)e;
/* 283 */           if (el.width * el.height > 30.0F && 
/* 284 */             !MyUtils.isRoyalty((Entity)el) && !(el instanceof Godzilla) && !(el instanceof GodzillaHead) && !(el instanceof PitchBlack) && !(el instanceof Kraken))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 290 */             el.setHealth(el.getHealth() / 2.0F);
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 295 */         if (!this.small) {
/* 296 */           par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, (Entity)this.shootingEntity), 10.0F);
/* 297 */           par1MovingObjectPosition.entityHit.setFire(5);
/*     */         } else {
/* 299 */           par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, (Entity)this.shootingEntity), 5.0F);
/* 300 */           par1MovingObjectPosition.entityHit.setFire(5);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 305 */         int i = par1MovingObjectPosition.blockX;
/* 306 */         int j = par1MovingObjectPosition.blockY;
/* 307 */         int k = par1MovingObjectPosition.blockZ;
/*     */         
/* 309 */         switch (par1MovingObjectPosition.sideHit) {
/*     */           
/*     */           case 0:
/* 312 */             j--;
/*     */             break;
/*     */           case 1:
/* 315 */             j++;
/*     */             break;
/*     */           case 2:
/* 318 */             k--;
/*     */             break;
/*     */           case 3:
/* 321 */             k++;
/*     */             break;
/*     */           case 4:
/* 324 */             i--;
/*     */             break;
/*     */           case 5:
/* 327 */             i++;
/*     */             break;
/*     */         } 
/* 330 */         if (this.worldObj.isAirBlock(i, j, k))
/*     */         {
/* 332 */           this.worldObj.setBlock(i, j, k, (Block)Blocks.fire);
/*     */         }
/*     */       } 
/*     */       
/* 336 */       if (!this.small) {
/* 337 */         this.worldObj.newExplosion((Entity)null, this.posX, this.posY, this.posZ, this.field_92012_e, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
/*     */       }
/*     */       
/* 340 */       setDead();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 349 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 350 */     par1NBTTagCompound.setInteger("ExplosionPower", this.field_92012_e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 358 */     super.readEntityFromNBT(par1NBTTagCompound);
/*     */     
/* 360 */     if (par1NBTTagCompound.hasKey("ExplosionPower"))
/*     */     {
/* 362 */       this.field_92012_e = par1NBTTagCompound.getInteger("ExplosionPower");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\BetterFireball.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */