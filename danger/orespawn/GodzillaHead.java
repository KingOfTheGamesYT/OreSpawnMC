/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GodzillaHead
/*     */   extends EntityLiving
/*     */ {
/*     */   private int boatPosRotationIncrements;
/*     */   private double boatX;
/*     */   private double boatY;
/*     */   private double boatZ;
/*     */   private double boatYaw;
/*     */   private double boatPitch;
/*     */   private double velocityX;
/*     */   private double velocityY;
/*     */   private double velocityZ;
/*     */   
/*     */   public GodzillaHead(World par1World) {
/*  69 */     super(par1World);
/*  70 */     setSize(9.9F, 10.0F);
/*  71 */     this.noClip = true;
/*  72 */     this.fireResistance = 10000;
/*  73 */     this.isImmuneToFire = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  79 */     super.applyEntityAttributes();
/*  80 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(OreSpawnMain.Godzilla_stats.health);
/*  81 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.3300000429153442D);
/*  82 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  83 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFallState(double par1, boolean par3) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/* 107 */     super.entityInit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 125 */     boolean ret = false;
/*     */     
/* 127 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/* 128 */       return false;
/*     */     }
/* 130 */     Entity e = par1DamageSource.getEntity();
/* 131 */     if (e != null && (e instanceof Godzilla || e instanceof GodzillaHead)) return false; 
/* 132 */     e = par1DamageSource.getSourceOfDamage();
/* 133 */     if (e != null && (e instanceof Godzilla || e instanceof GodzillaHead)) return false;
/*     */     
/* 135 */     List var5 = this.worldObj.getEntitiesWithinAABB(Godzilla.class, this.boundingBox.expand(32.0D, 32.0D, 32.0D));
/* 136 */     Iterator<Entity> var2 = var5.iterator();
/* 137 */     Entity var3 = null;
/* 138 */     Godzilla var4 = null;
/*     */     
/* 140 */     if (var2.hasNext()) {
/*     */ 
/*     */       
/* 143 */       var3 = var2.next();
/* 144 */       var4 = (Godzilla)var3;
/* 145 */       ret = var4.attackEntityFrom(par1DamageSource, par2);
/*     */     } 
/* 147 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeCollidedWith() {
/* 155 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 166 */     if (this.riddenByEntity != null) {
/*     */       
/* 168 */       this.boatPosRotationIncrements = par9 + 8;
/*     */     }
/*     */     else {
/*     */       
/* 172 */       this.boatPosRotationIncrements = 6;
/*     */     } 
/*     */     
/* 175 */     this.boatX = par1;
/* 176 */     this.boatY = par3;
/* 177 */     this.boatZ = par5;
/* 178 */     this.boatYaw = par7;
/* 179 */     this.boatPitch = par8;
/* 180 */     this.motionX = this.velocityX;
/* 181 */     this.motionY = this.velocityY;
/* 182 */     this.motionZ = this.velocityZ;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setVelocity(double par1, double par3, double par5) {
/* 193 */     this.velocityX = this.motionX = par1;
/* 194 */     this.velocityY = this.motionY = par3;
/* 195 */     this.velocityZ = this.motionZ = par5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 206 */     if (this.isDead)
/* 207 */       return;  this.isAirBorne = true;
/* 208 */     setFire(0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 214 */     if (this.worldObj.isRemote) {
/*     */ 
/*     */       
/* 217 */       if (this.boatPosRotationIncrements > 0)
/*     */       {
/* 219 */         double d4 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
/* 220 */         double d5 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
/* 221 */         double d11 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
/* 222 */         setPosition(d4, d5, d11);
/*     */         
/* 224 */         this.rotationPitch = (float)(this.rotationPitch + (this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
/* 225 */         double d10 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
/* 226 */         if (this.riddenByEntity != null) d10 = MathHelper.wrapAngleTo180_double(this.riddenByEntity.rotationYaw - this.rotationYaw); 
/* 227 */         this.rotationYaw = (float)(this.rotationYaw + d10 / this.boatPosRotationIncrements);
/* 228 */         setRotation(this.rotationYaw, this.rotationPitch);
/*     */         
/* 230 */         this.boatPosRotationIncrements--;
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 241 */       List var5 = this.worldObj.getEntitiesWithinAABB(Godzilla.class, this.boundingBox.expand(32.0D, 32.0D, 32.0D));
/* 242 */       Iterator<Entity> var2 = var5.iterator();
/* 243 */       Entity var3 = null;
/* 244 */       Godzilla var4 = null;
/*     */       
/* 246 */       if (var2.hasNext()) {
/*     */         
/* 248 */         var3 = var2.next();
/* 249 */         var4 = (Godzilla)var3;
/* 250 */         this.posY = var4.posY + 16.0D;
/* 251 */         this.posX = var4.posX - 17.0D * Math.sin(Math.toRadians(var4.rotationYawHead));
/* 252 */         this.posZ = var4.posZ + 17.0D * Math.cos(Math.toRadians(var4.rotationYawHead));
/* 253 */         this.rotationYaw = var4.rotationYaw;
/* 254 */         this.rotationYawHead = var4.rotationYawHead;
/* 255 */         this.motionX = var4.motionX;
/* 256 */         this.motionY = var4.motionY;
/* 257 */         this.motionZ = var4.motionZ;
/* 258 */         setHealth(var4.getHealth());
/*     */       } else {
/* 260 */         setDead();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\GodzillaHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */