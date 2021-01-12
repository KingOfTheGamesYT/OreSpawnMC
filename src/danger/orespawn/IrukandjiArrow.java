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
/*     */ public class IrukandjiArrow
/*     */   extends EntityArrow {
/*  26 */   private int xTile = -1;
/*  27 */   private int yTile = -1;
/*  28 */   private int zTile = -1;
/*  29 */   private int inTile = 0;
/*  30 */   private int inData = 0;
/*     */   private boolean inGround = false;
/*     */   private int ticksInGround;
/*  33 */   private int ticksInAir = 0;
/*     */ 
/*     */   
/*     */   private int knockbackStrength;
/*     */ 
/*     */   
/*     */   public IrukandjiArrow(World par1World) {
/*  40 */     super(par1World);
/*     */   }
/*     */ 
/*     */   
/*     */   public IrukandjiArrow(World par1World, double par2, double par4, double par6) {
/*  45 */     super(par1World, par2, par4, par6);
/*     */   }
/*     */ 
/*     */   
/*     */   public IrukandjiArrow(World par1World, EntityLiving par2EntityLiving, EntityLivingBase par3EntityLiving, float par4, float par5) {
/*  50 */     super(par1World, (EntityLivingBase)par2EntityLiving, par3EntityLiving, par4, par5);
/*     */   }
/*     */ 
/*     */   
/*     */   public IrukandjiArrow(World par1World, EntityPlayer par3EntityPlayer, float par3) {
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
/* 108 */       var16.setBlockBoundsBasedOnState((IBlockAccess)this.worldObj, this.xTile, this.yTile, this.zTile);
/* 109 */       AxisAlignedBB var2 = var16.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
/*     */       
/* 111 */       if (var2 != null && var2.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ)))
/*     */       {
/* 113 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 117 */     if (this.arrowShake > 0)
/*     */     {
/* 119 */       this.arrowShake--;
/*     */     }
/*     */     
/* 122 */     if (this.inGround) {
/*     */       
/* 124 */       Block var18 = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
/* 125 */       int var19 = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
/*     */       
/* 127 */       if (var18 != Blocks.air && var19 == this.inData) {
/*     */         
/* 129 */         this.ticksInGround++;
/*     */         
/* 131 */         if (this.ticksInGround == 50)
/*     */         {
/* 133 */           if (!this.worldObj.isRemote)
/*     */           {
/* 135 */             dropItem(OreSpawnMain.MyIrukandjiArrow, 1);
/* 136 */             setDead();
/*     */           }
/*     */         
/*     */         }
/*     */       } else {
/*     */         
/* 142 */         this.inGround = false;
/* 143 */         this.motionX *= (this.rand.nextFloat() * 0.2F);
/* 144 */         this.motionY *= (this.rand.nextFloat() * 0.2F);
/* 145 */         this.motionZ *= (this.rand.nextFloat() * 0.2F);
/* 146 */         this.ticksInGround = 0;
/* 147 */         this.ticksInAir = 0;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 152 */       this.ticksInAir++;
/* 153 */       Vec3 var17 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 154 */       Vec3 var3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/* 155 */       MovingObjectPosition var4 = this.worldObj.rayTraceBlocks(var17, var3, true);
/* 156 */       var17 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 157 */       var3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/*     */       
/* 159 */       if (var4 != null)
/*     */       {
/* 161 */         var3 = Vec3.createVectorHelper(var4.hitVec.xCoord, var4.hitVec.yCoord, var4.hitVec.zCoord);
/*     */       }
/*     */       
/* 164 */       Entity var5 = null;
/* 165 */       List<Entity> var6 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
/* 166 */       double var7 = 0.0D;
/*     */       
/*     */       int var9;
/*     */       
/* 170 */       for (var9 = 0; var9 < var6.size(); var9++) {
/*     */         
/* 172 */         Entity var10 = var6.get(var9);
/*     */         
/* 174 */         if (var10.canBeCollidedWith() && (var10 != this.shootingEntity || this.ticksInAir >= 5) && !(var10 instanceof Elevator)) {
/*     */           
/* 176 */           if (var10 instanceof Cephadrome) {
/* 177 */             Cephadrome c = (Cephadrome)var10;
/* 178 */             if (c.riddenByEntity != null)
/*     */               continue; 
/* 180 */           }  if (var10 instanceof Dragon) {
/* 181 */             Dragon c = (Dragon)var10;
/* 182 */             if (c.riddenByEntity != null)
/*     */               continue; 
/* 184 */           }  if (var10 instanceof EntityHorse) {
/* 185 */             EntityHorse c = (EntityHorse)var10;
/* 186 */             if (c.riddenByEntity != null)
/*     */               continue; 
/* 188 */           }  float f = 0.3F;
/* 189 */           AxisAlignedBB var12 = var10.boundingBox.expand(f, f, f);
/* 190 */           MovingObjectPosition var13 = var12.calculateIntercept(var17, var3);
/*     */           
/* 192 */           if (var13 != null) {
/*     */             
/* 194 */             double var14 = var17.distanceTo(var13.hitVec);
/*     */             
/* 196 */             if (var14 < var7 || var7 == 0.0D) {
/*     */               
/* 198 */               var5 = var10;
/* 199 */               var7 = var14;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         continue;
/*     */       } 
/* 205 */       if (var5 != null)
/*     */       {
/* 207 */         var4 = new MovingObjectPosition(var5);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 213 */       if (var4 != null)
/*     */       {
/* 215 */         if (var4.entityHit != null) {
/*     */ 
/*     */           
/* 218 */           float var23 = 100.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 224 */           if (OreSpawnMain.ultimate_sword_pvp == 0) {
/* 225 */             if (var4.entityHit instanceof EntityPlayer || var4.entityHit instanceof Girlfriend || var4.entityHit instanceof Boyfriend) {
/*     */               
/* 227 */               EntityLivingBase e = (EntityLivingBase)var4.entityHit;
/*     */               
/* 229 */               playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
/* 230 */               setDead();
/*     */               return;
/*     */             } 
/* 233 */             if (var4.entityHit instanceof EntityTameable) {
/*     */               
/* 235 */               EntityTameable t = (EntityTameable)var4.entityHit;
/* 236 */               if (t.isTamed()) {
/* 237 */                 playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
/* 238 */                 setDead();
/*     */                 
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/* 245 */           if (getIsCritical())
/*     */           {
/* 247 */             var23 += this.rand.nextInt((int)var23 / 2 + 2);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 252 */           DamageSource var21 = null;
/*     */           
/* 254 */           if (this.shootingEntity == null) {
/*     */             
/* 256 */             var21 = DamageSource.causeArrowDamage(this, (Entity)this);
/*     */           }
/*     */           else {
/*     */             
/* 260 */             var21 = DamageSource.causeArrowDamage(this, this.shootingEntity);
/*     */           } 
/*     */           
/* 263 */           if (isBurning())
/*     */           {
/* 265 */             var4.entityHit.setFire(5);
/*     */           }
/*     */           
/* 268 */           if (var4.entityHit.attackEntityFrom(var21, var23))
/*     */           {
/* 270 */             if (var4.entityHit instanceof EntityLiving) {
/*     */               
/* 272 */               EntityLiving var24 = (EntityLiving)var4.entityHit;
/*     */               
/* 274 */               if (!this.worldObj.isRemote)
/*     */               {
/* 276 */                 var24.setArrowCountInEntity(var24.getArrowCountInEntity() + 1);
/*     */               }
/*     */               
/* 279 */               if (this.knockbackStrength > 0) {
/*     */                 
/* 281 */                 float var26 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*     */                 
/* 283 */                 if (var26 > 0.0F)
/*     */                 {
/* 285 */                   var4.entityHit.addVelocity(this.motionX * this.knockbackStrength * 0.6000000238418579D / var26, 0.1D, this.motionZ * this.knockbackStrength * 0.6000000238418579D / var26);
/*     */                 }
/*     */               } 
/*     */ 
/*     */ 
/*     */               
/* 291 */               if (this.shootingEntity != null && var4.entityHit != this.shootingEntity && var4.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP)
/*     */               {
/* 293 */                 ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.sendPacket((Packet)new S2BPacketChangeGameState(6, 0.0F));
/*     */               }
/*     */             } 
/*     */             
/* 297 */             playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
/*     */ 
/*     */             
/* 300 */             setDead();
/*     */           
/*     */           }
/*     */           else
/*     */           {
/* 305 */             this.motionX *= -0.10000000149D;
/* 306 */             this.motionY *= -0.10000000149D;
/* 307 */             this.motionZ *= -0.10000000149D;
/* 308 */             this.rotationYaw += 180.0F;
/* 309 */             this.prevRotationYaw += 180.0F;
/* 310 */             this.ticksInAir = 0;
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 315 */           this.xTile = var4.blockX;
/* 316 */           this.yTile = var4.blockY;
/* 317 */           this.zTile = var4.blockZ;
/*     */           
/* 319 */           this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
/* 320 */           this.motionX = (float)(var4.hitVec.xCoord - this.posX);
/* 321 */           this.motionY = (float)(var4.hitVec.yCoord - this.posY);
/* 322 */           this.motionZ = (float)(var4.hitVec.zCoord - this.posZ);
/* 323 */           float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
/* 324 */           this.posX -= this.motionX / f * 0.05D;
/* 325 */           this.posY -= this.motionY / f * 0.05D;
/* 326 */           this.posZ -= this.motionZ / f * 0.05D;
/* 327 */           playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
/* 328 */           this.inGround = true;
/* 329 */           this.arrowShake = 7;
/* 330 */           setIsCritical(false);
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 336 */       if (getIsCritical())
/*     */       {
/* 338 */         for (var9 = 0; var9 < 4; var9++)
/*     */         {
/* 340 */           this.worldObj.spawnParticle("crit", this.posX + this.motionX * var9 / 4.0D, this.posY + this.motionY * var9 / 4.0D, this.posZ + this.motionZ * var9 / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
/*     */         }
/*     */       }
/*     */       
/* 344 */       this.posX += this.motionX;
/* 345 */       this.posY += this.motionY;
/* 346 */       this.posZ += this.motionZ;
/* 347 */       float var20 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 348 */       this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/*     */       
/* 350 */       for (this.rotationPitch = (float)(Math.atan2(this.motionY, var20) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 355 */       while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
/*     */       {
/* 357 */         this.prevRotationPitch += 360.0F;
/*     */       }
/*     */       
/* 360 */       while (this.rotationYaw - this.prevRotationYaw < -180.0F)
/*     */       {
/* 362 */         this.prevRotationYaw -= 360.0F;
/*     */       }
/*     */       
/* 365 */       while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
/*     */       {
/* 367 */         this.prevRotationYaw += 360.0F;
/*     */       }
/*     */       
/* 370 */       this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
/* 371 */       this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
/* 372 */       float var22 = 0.99F;
/* 373 */       float var11 = 0.05F;
/*     */       
/* 375 */       if (isInWater()) {
/*     */         
/* 377 */         for (int var25 = 0; var25 < 4; var25++) {
/*     */           
/* 379 */           float var26 = 0.25F;
/* 380 */           this.worldObj.spawnParticle("bubble", this.posX - this.motionX * var26, this.posY - this.motionY * var26, this.posZ - this.motionZ * var26, this.motionX, this.motionY, this.motionZ);
/*     */         } 
/*     */         
/* 383 */         var22 = 0.8F;
/*     */       } 
/*     */       
/* 386 */       this.motionX *= var22;
/* 387 */       this.motionY *= var22;
/* 388 */       this.motionZ *= var22;
/* 389 */       this.motionY -= var11;
/* 390 */       setPosition(this.posX, this.posY, this.posZ);
/* 391 */       doBlockCollisions();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKnockbackStrength(int par1) {
/* 400 */     this.knockbackStrength = par1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDamage(double par1) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public double getDamage() {
/* 410 */     return 100.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\IrukandjiArrow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */