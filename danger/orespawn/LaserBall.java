/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityThrowable;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class LaserBall
/*     */   extends EntityThrowable
/*     */ {
/*  15 */   private float my_rotation = 0.0F;
/*  16 */   private int my_index = 81;
/*  17 */   private int is_special = 0;
/*  18 */   private int is_iceball = 0;
/*  19 */   private int is_acid = 0;
/*  20 */   private int is_irukandji = 0;
/*  21 */   private int ticksalive = 0;
/*     */ 
/*     */   
/*     */   public LaserBall(World par1World) {
/*  25 */     super(par1World);
/*     */   }
/*     */ 
/*     */   
/*     */   public LaserBall(World par1World, int par2) {
/*  30 */     super(par1World);
/*     */   }
/*     */ 
/*     */   
/*     */   public LaserBall(World par1World, EntityLivingBase par2EntityLiving) {
/*  35 */     super(par1World, par2EntityLiving);
/*     */   }
/*     */ 
/*     */   
/*     */   public LaserBall(World par1World, EntityLivingBase par2EntityLiving, int par3) {
/*  40 */     super(par1World, par2EntityLiving);
/*     */   }
/*     */ 
/*     */   
/*     */   public LaserBall(World par1World, double par2, double par4, double par6) {
/*  45 */     super(par1World, par2, par4, par6);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLaserBallIndex() {
/*  51 */     return this.my_index;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSpecial() {
/*  56 */     this.is_special = 1;
/*     */   }
/*     */   
/*     */   public void setIceBall() {
/*  60 */     this.is_iceball = 1;
/*     */   }
/*     */   
/*     */   public void setAcid() {
/*  64 */     this.is_acid = 1;
/*     */   }
/*     */   
/*     */   public void setIrukandji() {
/*  68 */     this.is_irukandji = 1;
/*  69 */     this.is_acid = 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
/*  77 */     if (par1MovingObjectPosition.entityHit != null) {
/*     */       
/*  79 */       float var2 = 16.0F;
/*     */       
/*  81 */       if (this.is_irukandji != 0) {
/*  82 */         par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)getThrower()), 100.0F);
/*  83 */         setDead();
/*     */         
/*     */         return;
/*     */       } 
/*  87 */       if (this.is_acid != 0) {
/*  88 */         if (par1MovingObjectPosition.entityHit instanceof TrooperBug) {
/*     */           
/*  90 */           setDead();
/*     */           return;
/*     */         } 
/*  93 */         if (par1MovingObjectPosition.entityHit instanceof SpitBug) {
/*     */           
/*  95 */           setDead();
/*     */           return;
/*     */         } 
/*     */       } 
/*  99 */       if (this.is_iceball == 0 && this.is_acid == 0) {
/* 100 */         if (par1MovingObjectPosition.entityHit instanceof Robot2) {
/*     */           
/* 102 */           setDead();
/*     */           return;
/*     */         } 
/* 105 */         if (par1MovingObjectPosition.entityHit instanceof Robot3) {
/*     */           
/* 107 */           setDead();
/*     */           return;
/*     */         } 
/* 110 */         if (par1MovingObjectPosition.entityHit instanceof Robot4) {
/*     */           
/* 112 */           setDead();
/*     */           return;
/*     */         } 
/* 115 */         if (par1MovingObjectPosition.entityHit instanceof Robot5) {
/*     */           
/* 117 */           setDead();
/*     */           return;
/*     */         } 
/* 120 */         if (par1MovingObjectPosition.entityHit instanceof GiantRobot) {
/*     */           
/* 122 */           setDead();
/*     */           return;
/*     */         } 
/*     */       } 
/* 126 */       if (par1MovingObjectPosition.entityHit instanceof Dragon && this.is_acid == 0) {
/*     */         
/* 128 */         Dragon d = (Dragon)par1MovingObjectPosition.entityHit;
/* 129 */         if (d.riddenByEntity != null) {
/* 130 */           setDead();
/*     */           
/*     */           return;
/*     */         } 
/* 134 */         if (d.getDragonType() != 0 && this.is_iceball != 0) {
/* 135 */           setDead();
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/* 140 */       if (par1MovingObjectPosition.entityHit instanceof EntityPlayer && this.is_acid == 0) {
/*     */         
/* 142 */         EntityPlayer d = (EntityPlayer)par1MovingObjectPosition.entityHit;
/* 143 */         if (d.ridingEntity != null) {
/* 144 */           setDead();
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/* 149 */       par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)getThrower()), var2);
/* 150 */       if (this.is_iceball == 0) par1MovingObjectPosition.entityHit.setFire(1);
/*     */     
/*     */     }
/* 153 */     else if (this.is_irukandji != 0 && 
/* 154 */       !this.worldObj.isRemote) {
/* 155 */       dropItem(OreSpawnMain.MyIrukandji, 1);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 160 */     if (this.is_acid == 0) {
/* 161 */       int mx = 10;
/* 162 */       if (this.is_special != 0) mx = 20; 
/* 163 */       for (int var3 = 0; var3 < mx; var3++) {
/*     */         
/* 165 */         this.worldObj.spawnParticle("smoke", this.posX + this.rand.nextFloat() - this.rand.nextFloat(), this.posY + this.rand.nextFloat() - this.rand.nextFloat(), this.posZ + this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
/* 166 */         this.worldObj.spawnParticle("largesmoke", this.posX + this.rand.nextFloat() - this.rand.nextFloat(), this.posY + this.rand.nextFloat() - this.rand.nextFloat(), this.posZ + this.rand.nextFloat() - this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
/* 167 */         this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY, this.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
/*     */       } 
/*     */       
/* 170 */       playSound("random.explode", 0.5F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5F);
/* 171 */       if (!this.worldObj.isRemote && (this.is_special != 0 || this.is_iceball != 0)) {
/* 172 */         this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, 3.0F, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
/*     */       }
/*     */     } 
/* 175 */     setDead();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 183 */     this.ticksalive++;
/* 184 */     if (this.ticksalive > 200) {
/* 185 */       setDead();
/*     */       return;
/*     */     } 
/* 188 */     super.onUpdate();
/* 189 */     this.my_rotation += 50.0F;
/*     */     
/* 191 */     while (this.my_rotation > 360.0F) {
/* 192 */       this.my_rotation -= 360.0F;
/*     */     }
/*     */     
/* 195 */     this.rotationPitch = this.prevRotationPitch = this.my_rotation;
/* 196 */     if (this.is_acid != 0) {
/*     */       return;
/*     */     }
/* 199 */     int mx = 4;
/* 200 */     if (this.is_special != 0) mx = 10; 
/* 201 */     if (this.is_iceball != 0 && this.is_special == 0) mx = 2; 
/* 202 */     for (int i = 0; i < mx; i++) {
/* 203 */       this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY, this.posZ, this.worldObj.rand.nextGaussian() / 2.0D, this.worldObj.rand.nextGaussian() / 2.0D, this.worldObj.rand.nextGaussian() / 2.0D);
/*     */       
/* 205 */       if (this.is_iceball == 0) this.worldObj.spawnParticle("reddust", this.posX, this.posY, this.posZ, this.worldObj.rand.nextGaussian() / 10.0D, this.worldObj.rand.nextGaussian() / 10.0D, this.worldObj.rand.nextGaussian() / 10.0D); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\LaserBall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */