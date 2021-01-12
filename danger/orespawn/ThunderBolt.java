/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.effect.EntityLightningBolt;
/*    */ import net.minecraft.entity.projectile.EntityThrowable;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ThunderBolt
/*    */   extends EntityThrowable
/*    */ {
/*    */   public ThunderBolt(World par1World) {
/* 18 */     super(par1World);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ThunderBolt(World par1World, EntityLivingBase par3EntityPlayer) {
/* 24 */     super(par1World, par3EntityPlayer);
/*    */   }
/*    */ 
/*    */   
/*    */   public ThunderBolt(World par1World, EntityLivingBase par2EntityLiving, int par3) {
/* 29 */     super(par1World, par2EntityLiving);
/*    */   }
/*    */ 
/*    */   
/*    */   public ThunderBolt(World par1World, double par2, double par4, double par6) {
/* 34 */     super(par1World, par2, par4, par6);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
/* 42 */     if (par1MovingObjectPosition.entityHit != null) {
/*    */       
/* 44 */       float var2 = 40.0F;
/*    */       
/* 46 */       if (MyUtils.isRoyalty(par1MovingObjectPosition.entityHit)) {
/* 47 */         setDead();
/*    */         
/*    */         return;
/*    */       } 
/* 51 */       par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)getThrower()), var2 / 2.0F);
/* 52 */       par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(getThrower()), var2 / 2.0F);
/* 53 */       par1MovingObjectPosition.entityHit.setFire(1);
/*    */     } 
/*    */     
/* 56 */     int mx = 20;
/* 57 */     for (int var3 = 0; var3 < mx; var3++) {
/*    */       
/* 59 */       this.worldObj.spawnParticle("smoke", this.posX + this.rand.nextFloat() - this.rand.nextFloat(), this.posY + this.rand.nextFloat() - this.rand.nextFloat(), this.posZ + this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
/* 60 */       this.worldObj.spawnParticle("largesmoke", this.posX + this.rand.nextFloat() - this.rand.nextFloat(), this.posY + this.rand.nextFloat() - this.rand.nextFloat(), this.posZ + this.rand.nextFloat() - this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
/* 61 */       this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY, this.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
/*    */     } 
/*    */     
/* 64 */     playSound("random.explode", 0.5F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5F);
/* 65 */     if (!this.worldObj.isRemote)
/*    */     {
/* 67 */       this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, 3.0F, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
/*    */     }
/* 69 */     this.worldObj.addWeatherEffect((Entity)new EntityLightningBolt(this.worldObj, this.posX, this.posY + 1.0D, this.posZ));
/*    */     
/* 71 */     setDead();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onUpdate() {
/* 80 */     super.onUpdate();
/*    */ 
/*    */     
/* 83 */     int mx = 4;
/* 84 */     for (int i = 0; i < mx; i++)
/* 85 */       this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY, this.posZ, this.worldObj.rand.nextGaussian() / 10.0D, this.worldObj.rand.nextGaussian() / 10.0D, this.worldObj.rand.nextGaussian() / 10.0D); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ThunderBolt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */