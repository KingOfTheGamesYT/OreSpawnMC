/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.projectile.EntityThrowable;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class InkSack
/*     */   extends EntityThrowable
/*     */ {
/*  17 */   private float my_rotation = 0.0F;
/*  18 */   private int my_index = 65;
/*     */ 
/*     */   
/*     */   public InkSack(World par1World) {
/*  22 */     super(par1World);
/*     */   }
/*     */ 
/*     */   
/*     */   public InkSack(World par1World, int par2) {
/*  27 */     super(par1World);
/*     */   }
/*     */ 
/*     */   
/*     */   public InkSack(World par1World, EntityLiving par2EntityLiving) {
/*  32 */     super(par1World, (EntityLivingBase)par2EntityLiving);
/*     */   }
/*     */ 
/*     */   
/*     */   public InkSack(World par1World, EntityLiving par2EntityLiving, int par3) {
/*  37 */     super(par1World, (EntityLivingBase)par2EntityLiving);
/*     */   }
/*     */ 
/*     */   
/*     */   public InkSack(World par1World, double par2, double par4, double par6) {
/*  42 */     super(par1World, par2, par4, par6);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInkSackIndex() {
/*  48 */     return this.my_index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
/*  56 */     if (par1MovingObjectPosition.entityHit != null) {
/*     */       
/*  58 */       float var2 = 1.0F;
/*     */       
/*  60 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntityCreeper)
/*     */       {
/*  62 */         var2 = 4.0F;
/*     */       }
/*  64 */       if (par1MovingObjectPosition.entityHit instanceof WaterDragon) {
/*     */         return;
/*     */       }
/*     */       
/*  68 */       if (par1MovingObjectPosition.entityHit instanceof AttackSquid) {
/*     */         return;
/*     */       }
/*     */       
/*  72 */       par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)getThrower()), var2);
/*  73 */       if (par1MovingObjectPosition.entityHit instanceof EntityLivingBase && 
/*  74 */         this.worldObj.rand.nextInt(2) == 0)
/*     */       {
/*  76 */         ((EntityLivingBase)par1MovingObjectPosition.entityHit).addPotionEffect(new PotionEffect(Potion.blindness.id, 100 + 50 * this.worldObj.rand.nextInt(8), 0));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  81 */     for (int var3 = 0; var3 < 4; var3++)
/*     */     {
/*  83 */       this.worldObj.spawnParticle("smoke", this.posX + this.rand.nextFloat() - this.rand.nextFloat(), this.posY + this.rand.nextFloat() - this.rand.nextFloat(), this.posZ + this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
/*     */     }
/*  85 */     playSound("random.splash", 0.5F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5F);
/*     */     
/*  87 */     if (!this.worldObj.isRemote)
/*     */     {
/*  89 */       setDead();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  99 */     super.onUpdate();
/* 100 */     this.my_rotation += 30.0F;
/*     */     
/* 102 */     while (this.my_rotation > 360.0F) {
/* 103 */       this.my_rotation -= 360.0F;
/*     */     }
/*     */     
/* 106 */     this.rotationPitch = this.prevRotationPitch = this.my_rotation;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\InkSack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */