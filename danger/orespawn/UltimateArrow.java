/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntityHorse;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S2BPacketChangeGameState;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class UltimateArrow
/*     */   extends EntityArrow {
/*  26 */   private int xTile = -1;
/*  27 */   private int yTile = -1;
/*  28 */   private int zTile = -1;
/*  29 */   private Block inTile = Blocks.air;
/*  30 */   private int inData = 0;
/*     */   private boolean inGround = false;
/*     */   private int ticksInGround;
/*  33 */   private int ticksInAir = 0;
/*     */ 
/*     */   
/*     */   private int knockbackStrength;
/*     */ 
/*     */   
/*     */   public UltimateArrow(World par1World) {
/*  40 */     super(par1World);
/*     */   }
/*     */ 
/*     */   
/*     */   public UltimateArrow(World par1World, double par2, double par4, double par6) {
/*  45 */     super(par1World, par2, par4, par6);
/*     */   }
/*     */ 
/*     */   
/*     */   public UltimateArrow(World par1World, EntityLiving par2EntityLiving, EntityLivingBase par3EntityLiving, float par4, float par5) {
/*  50 */     super(par1World, (EntityLivingBase)par2EntityLiving, par3EntityLiving, par4, par5);
/*     */   }
/*     */ 
/*     */   
/*     */   public UltimateArrow(World par1World, EntityPlayer par3EntityPlayer, float par3) {
/*  55 */     super(par1World, (EntityLivingBase)par3EntityPlayer, par3);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  60 */     this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
/*  68 */     float var9 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
/*  69 */     par1 /= var9;
/*  70 */     par3 /= var9;
/*  71 */     par5 /= var9;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     par1 *= par7;
/*  77 */     par3 *= par7;
/*  78 */     par5 *= par7;
/*  79 */     this.motionX = par1;
/*  80 */     this.motionY = par3;
/*  81 */     this.motionZ = par5;
/*  82 */     float var10 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
/*  83 */     this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/*  84 */     this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, var10) * 180.0D / Math.PI);
/*  85 */     this.ticksInGround = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  95 */     onEntityUpdate();
/*     */     
/*  97 */     if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
/*     */       
/*  99 */       float var1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 100 */       this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/* 101 */       this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, var1) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 104 */     Block var16 = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/*     */     
/* 106 */     if (var16 != Blocks.air) {
/*     */ 
/*     */       
/* 109 */       var16.setBlockBoundsBasedOnState((IBlockAccess)this.worldObj, this.xTile, this.yTile, this.zTile);
/* 110 */       AxisAlignedBB var2 = var16.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
/*     */       
/* 112 */       if (var2 != null && var2.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ)))
/*     */       {
/* 114 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 118 */     if (this.arrowShake > 0)
/*     */     {
/* 120 */       this.arrowShake--;
/*     */     }
/*     */     
/* 123 */     if (this.inGround) {
/*     */       
/* 125 */       Block var18 = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/* 126 */       int var19 = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
/*     */       
/* 128 */       if (var18 != Blocks.air)
/*     */       {
/* 130 */         this.ticksInGround++;
/*     */         
/* 132 */         if (this.ticksInGround == 500)
/*     */         {
/* 134 */           setDead();
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 139 */         this.inGround = false;
/* 140 */         this.motionX *= (this.rand.nextFloat() * 0.2F);
/* 141 */         this.motionY *= (this.rand.nextFloat() * 0.2F);
/* 142 */         this.motionZ *= (this.rand.nextFloat() * 0.2F);
/* 143 */         this.ticksInGround = 0;
/* 144 */         this.ticksInAir = 0;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 149 */       this.ticksInAir++;
/* 150 */       Vec3 var17 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 151 */       Vec3 var3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/* 152 */       MovingObjectPosition var4 = this.worldObj.rayTraceBlocks(var17, var3, true);
/* 153 */       var17 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 154 */       var3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/*     */       
/* 156 */       if (var4 != null)
/*     */       {
/* 158 */         var3 = Vec3.createVectorHelper(var4.hitVec.xCoord, var4.hitVec.yCoord, var4.hitVec.zCoord);
/*     */       }
/*     */       
/* 161 */       Entity var5 = null;
/* 162 */       List<Entity> var6 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
/* 163 */       double var7 = 0.0D;
/*     */       
/*     */       int var9;
/*     */       
/* 167 */       for (var9 = 0; var9 < var6.size(); var9++) {
/*     */         
/* 169 */         Entity var10 = var6.get(var9);
/*     */         
/* 171 */         if (var10.canBeCollidedWith() && (var10 != this.shootingEntity || this.ticksInAir >= 5) && !(var10 instanceof Elevator)) {
/*     */           
/* 173 */           if (var10 instanceof Cephadrome) {
/* 174 */             Cephadrome c = (Cephadrome)var10;
/* 175 */             if (c.riddenByEntity != null)
/*     */               continue; 
/* 177 */           }  if (var10 instanceof Dragon) {
/* 178 */             Dragon c = (Dragon)var10;
/* 179 */             if (c.riddenByEntity != null)
/*     */               continue; 
/* 181 */           }  if (var10 instanceof EntityHorse) {
/* 182 */             EntityHorse c = (EntityHorse)var10;
/* 183 */             if (c.riddenByEntity != null)
/*     */               continue; 
/* 185 */           }  float f = 0.3F;
/* 186 */           AxisAlignedBB var12 = var10.boundingBox.expand(f, f, f);
/* 187 */           MovingObjectPosition var13 = var12.calculateIntercept(var17, var3);
/*     */           
/* 189 */           if (var13 != null) {
/*     */             
/* 191 */             double var14 = var17.distanceTo(var13.hitVec);
/*     */             
/* 193 */             if (var14 < var7 || var7 == 0.0D) {
/*     */               
/* 195 */               var5 = var10;
/* 196 */               var7 = var14;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         continue;
/*     */       } 
/* 202 */       if (var5 != null)
/*     */       {
/* 204 */         var4 = new MovingObjectPosition(var5);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 210 */       if (var4 != null)
/*     */       {
/* 212 */         if (var4.entityHit != null) {
/*     */           
/* 214 */           float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
/* 215 */           float var23 = MathHelper.ceiling_double_int(f1 * OreSpawnMain.UltimateBowDamage);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 221 */           if (OreSpawnMain.ultimate_sword_pvp == 0) {
/* 222 */             if (var4.entityHit instanceof EntityPlayer || var4.entityHit instanceof Girlfriend || var4.entityHit instanceof Boyfriend) {
/*     */               
/* 224 */               EntityLivingBase e = (EntityLivingBase)var4.entityHit;
/*     */               
/* 226 */               playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
/* 227 */               e.heal(1.0F);
/* 228 */               setDead();
/*     */               return;
/*     */             } 
/* 231 */             if (var4.entityHit instanceof EntityTameable) {
/*     */               
/* 233 */               EntityTameable t = (EntityTameable)var4.entityHit;
/* 234 */               if (t.isTamed()) {
/* 235 */                 playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
/* 236 */                 t.heal(1.0F);
/* 237 */                 setDead();
/*     */                 
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/* 244 */           if (getIsCritical())
/*     */           {
/* 246 */             var23 += this.rand.nextInt((int)var23 / 2 + 2);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 251 */           DamageSource var21 = null;
/*     */           
/* 253 */           if (this.shootingEntity == null) {
/*     */             
/* 255 */             var21 = DamageSource.causeArrowDamage(this, (Entity)this);
/*     */           }
/*     */           else {
/*     */             
/* 259 */             var21 = DamageSource.causeArrowDamage(this, this.shootingEntity);
/*     */           } 
/*     */           
/* 262 */           if (isBurning())
/*     */           {
/* 264 */             var4.entityHit.setFire(5);
/*     */           }
/*     */           
/* 267 */           if (var4.entityHit.attackEntityFrom(var21, var23))
/*     */           {
/* 269 */             if (var4.entityHit instanceof EntityLiving) {
/*     */               
/* 271 */               EntityLiving var24 = (EntityLiving)var4.entityHit;
/*     */               
/* 273 */               if (!this.worldObj.isRemote)
/*     */               {
/* 275 */                 var24.setArrowCountInEntity(var24.getArrowCountInEntity() + 1);
/*     */               }
/*     */               
/* 278 */               if (this.knockbackStrength > 0) {
/*     */                 
/* 280 */                 float var26 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*     */                 
/* 282 */                 if (var26 > 0.0F)
/*     */                 {
/* 284 */                   var4.entityHit.addVelocity(this.motionX * this.knockbackStrength * 0.6000000238418579D / var26, 0.1D, this.motionZ * this.knockbackStrength * 0.6000000238418579D / var26);
/*     */                 }
/*     */               } 
/*     */ 
/*     */ 
/*     */               
/* 290 */               if (this.shootingEntity != null && var4.entityHit != this.shootingEntity && var4.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP)
/*     */               {
/* 292 */                 ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.sendPacket((Packet)new S2BPacketChangeGameState(6, 0.0F));
/*     */               }
/*     */             } 
/*     */             
/* 296 */             playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
/*     */ 
/*     */             
/* 299 */             setDead();
/*     */           
/*     */           }
/*     */           else
/*     */           {
/* 304 */             this.motionX *= -0.10000000149D;
/* 305 */             this.motionY *= -0.10000000149D;
/* 306 */             this.motionZ *= -0.10000000149D;
/* 307 */             this.rotationYaw += 180.0F;
/* 308 */             this.prevRotationYaw += 180.0F;
/* 309 */             this.ticksInAir = 0;
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 314 */           this.xTile = var4.blockX;
/* 315 */           this.yTile = var4.blockY;
/* 316 */           this.zTile = var4.blockZ;
/* 317 */           this.inTile = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/* 318 */           this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
/* 319 */           this.motionX = (float)(var4.hitVec.xCoord - this.posX);
/* 320 */           this.motionY = (float)(var4.hitVec.yCoord - this.posY);
/* 321 */           this.motionZ = (float)(var4.hitVec.zCoord - this.posZ);
/* 322 */           float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
/* 323 */           this.posX -= this.motionX / f * 0.05D;
/* 324 */           this.posY -= this.motionY / f * 0.05D;
/* 325 */           this.posZ -= this.motionZ / f * 0.05D;
/* 326 */           playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
/* 327 */           this.inGround = true;
/* 328 */           this.arrowShake = 7;
/* 329 */           setIsCritical(false);
/*     */           
/* 331 */           if (this.inTile != Blocks.air)
/*     */           {
/* 333 */             this.inTile.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, (Entity)this);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 338 */       if (getIsCritical())
/*     */       {
/* 340 */         for (var9 = 0; var9 < 4; var9++)
/*     */         {
/* 342 */           this.worldObj.spawnParticle("crit", this.posX + this.motionX * var9 / 4.0D, this.posY + this.motionY * var9 / 4.0D, this.posZ + this.motionZ * var9 / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
/*     */         }
/*     */       }
/*     */       
/* 346 */       this.posX += this.motionX;
/* 347 */       this.posY += this.motionY;
/* 348 */       this.posZ += this.motionZ;
/* 349 */       float var20 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 350 */       this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/*     */       
/* 352 */       for (this.rotationPitch = (float)(Math.atan2(this.motionY, var20) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 357 */       while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
/*     */       {
/* 359 */         this.prevRotationPitch += 360.0F;
/*     */       }
/*     */       
/* 362 */       while (this.rotationYaw - this.prevRotationYaw < -180.0F)
/*     */       {
/* 364 */         this.prevRotationYaw -= 360.0F;
/*     */       }
/*     */       
/* 367 */       while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
/*     */       {
/* 369 */         this.prevRotationYaw += 360.0F;
/*     */       }
/*     */       
/* 372 */       this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
/* 373 */       this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
/* 374 */       float var22 = 0.99F;
/* 375 */       float var11 = 0.05F;
/*     */       
/* 377 */       if (isInWater()) {
/*     */         
/* 379 */         for (int var25 = 0; var25 < 4; var25++) {
/*     */           
/* 381 */           float var26 = 0.25F;
/* 382 */           this.worldObj.spawnParticle("bubble", this.posX - this.motionX * var26, this.posY - this.motionY * var26, this.posZ - this.motionZ * var26, this.motionX, this.motionY, this.motionZ);
/*     */         } 
/*     */         
/* 385 */         var22 = 0.8F;
/*     */       } 
/*     */       
/* 388 */       this.motionX *= var22;
/* 389 */       this.motionY *= var22;
/* 390 */       this.motionZ *= var22;
/* 391 */       this.motionY -= var11;
/* 392 */       setPosition(this.posX, this.posY, this.posZ);
/* 393 */       doBlockCollisions();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKnockbackStrength(int par1) {
/* 402 */     this.knockbackStrength = par1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDamage(double par1) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public double getDamage() {
/* 412 */     return OreSpawnMain.UltimateBowDamage;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\UltimateArrow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */