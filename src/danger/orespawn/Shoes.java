/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.projectile.EntityThrowable;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Shoes
/*     */   extends EntityThrowable
/*     */ {
/*  16 */   public int ShoeId = 0;
/*  17 */   private float my_rotation = 0.0F;
/*     */ 
/*     */   
/*     */   public Shoes(World par1World) {
/*  21 */     super(par1World);
/*  22 */     this.ShoeId = this.rand.nextInt(4) + 2;
/*     */     
/*  24 */     this.dataWatcher.addObject(20, Integer.valueOf(this.ShoeId));
/*     */   }
/*     */ 
/*     */   
/*     */   public Shoes(World par1World, int par2) {
/*  29 */     super(par1World);
/*  30 */     this.ShoeId = par2;
/*     */     
/*  32 */     this.dataWatcher.addObject(20, Integer.valueOf(this.ShoeId));
/*     */   }
/*     */ 
/*     */   
/*     */   public Shoes(World par1World, EntityLivingBase par2EntityLiving) {
/*  37 */     super(par1World, par2EntityLiving);
/*  38 */     this.ShoeId = this.rand.nextInt(4) + 2;
/*     */     
/*  40 */     this.dataWatcher.addObject(20, Integer.valueOf(this.ShoeId));
/*     */   }
/*     */ 
/*     */   
/*     */   public Shoes(World par1World, EntityLivingBase par2EntityLiving, int par3) {
/*  45 */     super(par1World, par2EntityLiving);
/*  46 */     this.ShoeId = par3;
/*     */     
/*  48 */     this.dataWatcher.addObject(20, Integer.valueOf(this.ShoeId));
/*     */   }
/*     */ 
/*     */   
/*     */   public Shoes(World par1World, double par2, double par4, double par6) {
/*  53 */     super(par1World, par2, par4, par6);
/*  54 */     this.ShoeId = this.rand.nextInt(4) + 2;
/*     */     
/*  56 */     this.dataWatcher.addObject(20, Integer.valueOf(this.ShoeId));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getShoeId() {
/*  61 */     return this.dataWatcher.getWatchableObjectInt(20);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
/*  69 */     if (par1MovingObjectPosition.entityHit != null) {
/*     */       
/*  71 */       float var2 = 2.0F;
/*     */       
/*  73 */       if (getShoeId() == 6) {
/*  74 */         var2 = 6.0F;
/*     */       }
/*     */       
/*  77 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntityCreeper)
/*     */       {
/*  79 */         var2 += 4.0F;
/*     */       }
/*     */       
/*  82 */       if (par1MovingObjectPosition.entityHit instanceof Girlfriend)
/*     */       {
/*  84 */         var2 = 1.0F;
/*     */       }
/*  86 */       if (par1MovingObjectPosition.entityHit instanceof Boyfriend)
/*     */       {
/*  88 */         var2 = 1.0F;
/*     */       }
/*     */ 
/*     */       
/*  92 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.player.EntityPlayer)
/*     */       {
/*  94 */         var2 = 0.0F;
/*     */       }
/*     */ 
/*     */       
/*  98 */       if (OreSpawnMain.valentines_day != 0) var2 = 10.0F;
/*     */       
/* 100 */       par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)getThrower()), var2);
/*     */     } 
/*     */     
/* 103 */     for (int var3 = 0; var3 < 4; var3++) {
/*     */       
/* 105 */       this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
/* 106 */       this.worldObj.spawnParticle("reddust", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
/*     */     } 
/*     */     
/* 109 */     if (!this.worldObj.isRemote)
/*     */     {
/* 111 */       setDead();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 121 */     super.onUpdate();
/*     */ 
/*     */     
/* 124 */     this.my_rotation += 20.0F;
/*     */     
/* 126 */     while (this.my_rotation > 360.0F) {
/* 127 */       this.my_rotation -= 360.0F;
/*     */     }
/*     */ 
/*     */     
/* 131 */     this.rotationPitch = this.prevRotationPitch = this.my_rotation;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Shoes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */