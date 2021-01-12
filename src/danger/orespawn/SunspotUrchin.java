/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.projectile.EntityThrowable;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MovingObjectPosition;
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
/*     */ public class SunspotUrchin
/*     */   extends EntityThrowable
/*     */ {
/*  23 */   private float my_rotation = 0.0F;
/*  24 */   private int my_index = 50;
/*     */ 
/*     */   
/*     */   public SunspotUrchin(World par1World) {
/*  28 */     super(par1World);
/*     */   }
/*     */ 
/*     */   
/*     */   public SunspotUrchin(World par1World, int par2) {
/*  33 */     super(par1World);
/*     */   }
/*     */ 
/*     */   
/*     */   public SunspotUrchin(World par1World, EntityLivingBase par2EntityLiving) {
/*  38 */     super(par1World, par2EntityLiving);
/*     */   }
/*     */ 
/*     */   
/*     */   public SunspotUrchin(World par1World, EntityLivingBase par2EntityLiving, int par3) {
/*  43 */     super(par1World, par2EntityLiving);
/*     */   }
/*     */ 
/*     */   
/*     */   public SunspotUrchin(World par1World, double par2, double par4, double par6) {
/*  48 */     super(par1World, par2, par4, par6);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUrchinIndex() {
/*  54 */     return this.my_index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
/*  61 */     if (par1MovingObjectPosition.entityHit != null) {
/*     */       
/*  63 */       float var2 = 3.0F;
/*     */       
/*  65 */       if (par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.monster.EntityCreeper)
/*     */       {
/*  67 */         var2 = 6.0F;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  72 */       if (!(par1MovingObjectPosition.entityHit instanceof net.minecraft.entity.player.EntityPlayer)) {
/*     */         
/*  74 */         par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)getThrower()), var2);
/*  75 */         if (!par1MovingObjectPosition.entityHit.isImmuneToFire())
/*     */         {
/*  77 */           par1MovingObjectPosition.entityHit.setFire(5);
/*     */         }
/*     */       } 
/*     */     } else {
/*  81 */       int i = par1MovingObjectPosition.blockX;
/*  82 */       int j = par1MovingObjectPosition.blockY;
/*  83 */       int k = par1MovingObjectPosition.blockZ;
/*     */       
/*  85 */       switch (par1MovingObjectPosition.sideHit) {
/*     */         
/*     */         case 0:
/*  88 */           j--;
/*     */           break;
/*     */         case 1:
/*  91 */           j++;
/*     */           break;
/*     */         case 2:
/*  94 */           k--;
/*     */           break;
/*     */         case 3:
/*  97 */           k++;
/*     */           break;
/*     */         case 4:
/* 100 */           i--;
/*     */           break;
/*     */         case 5:
/* 103 */           i++;
/*     */           break;
/*     */       } 
/* 106 */       if (this.worldObj.isAirBlock(i, j, k))
/*     */       {
/* 108 */         this.worldObj.setBlock(i, j, k, (Block)Blocks.fire);
/*     */       }
/*     */     } 
/*     */     
/* 112 */     for (int var3 = 0; var3 < 5; var3++) {
/*     */       
/* 114 */       this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, this.worldObj.rand.nextFloat(), this.worldObj.rand.nextFloat(), this.worldObj.rand.nextFloat());
/*     */       
/* 116 */       this.worldObj.spawnParticle("reddust", this.posX, this.posY, this.posZ, this.worldObj.rand.nextFloat(), this.worldObj.rand.nextFloat(), this.worldObj.rand.nextFloat());
/*     */     } 
/*     */ 
/*     */     
/* 120 */     if (!this.worldObj.isRemote)
/*     */     {
/* 122 */       setDead();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 132 */     super.onUpdate();
/* 133 */     setFire(1);
/*     */ 
/*     */     
/* 136 */     this.my_rotation += 30.0F;
/*     */     
/* 138 */     while (this.my_rotation > 360.0F) {
/* 139 */       this.my_rotation -= 360.0F;
/*     */     }
/*     */ 
/*     */     
/* 143 */     this.rotationPitch = this.prevRotationPitch = this.my_rotation;
/*     */     
/* 145 */     this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\SunspotUrchin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */