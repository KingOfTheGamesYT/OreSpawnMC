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
/*     */ public class WaterBall
/*     */   extends EntityThrowable
/*     */ {
/*  15 */   private float my_rotation = 0.0F;
/*  16 */   private int my_index = 49;
/*     */ 
/*     */   
/*     */   public WaterBall(World par1World) {
/*  20 */     super(par1World);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WaterBall(World par1World, EntityLivingBase par2EntityLiving) {
/*  26 */     super(par1World, par2EntityLiving);
/*     */   }
/*     */ 
/*     */   
/*     */   public WaterBall(World worldObj, double d, double e, double f) {
/*  31 */     super(worldObj, d, e, f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWaterBallIndex() {
/*  38 */     return this.my_index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
/*  46 */     if (par1MovingObjectPosition.entityHit != null) {
/*     */       
/*  48 */       float var2 = 2.0F;
/*     */       
/*  50 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntityCreeper)
/*     */       {
/*  52 */         var2 = 5.0F;
/*     */       }
/*  54 */       if (par1MovingObjectPosition.entityHit instanceof WaterDragon) {
/*     */         return;
/*     */       }
/*     */       
/*  58 */       if (par1MovingObjectPosition.entityHit instanceof AttackSquid) {
/*     */         return;
/*     */       }
/*     */       
/*  62 */       if (par1MovingObjectPosition.entityHit instanceof Dragon) {
/*     */         
/*  64 */         Dragon d = (Dragon)par1MovingObjectPosition.entityHit;
/*  65 */         if (d.getDragonType() != 0) {
/*     */           return;
/*     */         }
/*     */       } 
/*  69 */       if (par1MovingObjectPosition.entityHit instanceof EntityPlayer) {
/*     */         
/*  71 */         EntityPlayer d = (EntityPlayer)par1MovingObjectPosition.entityHit;
/*  72 */         if (d.ridingEntity != null) {
/*     */           return;
/*     */         }
/*     */       } 
/*  76 */       par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)getThrower()), var2);
/*  77 */       if (this.worldObj.rand.nextInt(10) == 1) par1MovingObjectPosition.entityHit.dropItem(OreSpawnMain.MyWaterBall, 1); 
/*  78 */       par1MovingObjectPosition.entityHit.extinguish();
/*     */     } 
/*     */     
/*  81 */     for (int var3 = 0; var3 < 8; var3++) {
/*     */       
/*  83 */       this.worldObj.spawnParticle("bubble", this.posX + this.rand.nextFloat() - this.rand.nextFloat(), this.posY + this.rand.nextFloat() - this.rand.nextFloat(), this.posZ + this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
/*  84 */       this.worldObj.spawnParticle("splash", this.posX + this.rand.nextFloat() - this.rand.nextFloat(), this.posY + this.rand.nextFloat() - this.rand.nextFloat(), this.posZ + this.rand.nextFloat() - this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
/*     */     } 
/*  86 */     playSound("random.splash", 0.5F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5F);
/*     */     
/*  88 */     if (!this.worldObj.isRemote)
/*     */     {
/*  90 */       setDead();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 100 */     super.onUpdate();
/* 101 */     this.my_rotation += 30.0F;
/*     */     
/* 103 */     while (this.my_rotation > 360.0F) {
/* 104 */       this.my_rotation -= 360.0F;
/*     */     }
/*     */     
/* 107 */     this.rotationPitch = this.prevRotationPitch = this.my_rotation;
/*     */     
/* 109 */     this.worldObj.spawnParticle("splash", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\WaterBall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */