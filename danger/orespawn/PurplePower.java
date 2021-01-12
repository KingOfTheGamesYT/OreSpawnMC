/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.EnumDifficulty;
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
/*     */ public class PurplePower
/*     */   extends EntityLiving
/*     */ {
/*  54 */   private ChunkCoordinates currentFlightTarget = null;
/*  55 */   private GenericTargetSorter TargetSorter = null;
/*  56 */   private int purple_type = 0;
/*     */   
/*     */   public PurplePower(World par1World) {
/*  59 */     super(par1World);
/*  60 */     setSize(0.75F, 0.75F);
/*  61 */     this.experienceValue = 35;
/*  62 */     this.isImmuneToFire = true;
/*  63 */     this.fireResistance = 25;
/*  64 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  65 */     this.noClip = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  70 */     super.applyEntityAttributes();
/*  71 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  72 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
/*  73 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  74 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(500.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  79 */     super.entityInit();
/*  80 */     this.dataWatcher.addObject(20, Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPurpleType(int par1) {
/*  85 */     if (this.worldObj == null)
/*  86 */       return;  if (this.worldObj.isRemote)
/*  87 */       return;  this.purple_type = par1;
/*  88 */     this.dataWatcher.updateObject(20, Integer.valueOf(par1));
/*     */   }
/*     */   
/*     */   public int getPurpleType() {
/*  92 */     return this.dataWatcher.getWatchableObjectInt(20);
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 103 */     return 0.75F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 110 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 124 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 131 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 138 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 145 */     return 1000;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 152 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 160 */     EntityLivingBase e = null;
/* 161 */     super.onUpdate();
/*     */     
/* 163 */     this.motionY *= 0.6D;
/*     */     
/* 165 */     if (getPurpleType() == 0) {
/* 166 */       if (this.worldObj.isRemote && this.worldObj.rand.nextInt(4) == 1) {
/* 167 */         this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.25D, this.posZ, ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0F));
/*     */ 
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 173 */     else if (this.worldObj.isRemote && this.worldObj.rand.nextInt(6) == 1) {
/* 174 */       this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 0.6499999761581421D, this.posZ, ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0F));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     if (this.worldObj.isRemote) {
/* 182 */       this.purple_type = getPurpleType();
/*     */     } else {
/* 184 */       setPurpleType(this.purple_type);
/*     */     } 
/*     */     
/* 187 */     if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(2500) == 1) {
/* 188 */       if (getPurpleType() == 10) {
/* 189 */         this.worldObj.newExplosion((Entity)null, this.posX, this.posY + 0.25D, this.posZ, 9.1F, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
/*     */       }
/*     */       
/* 192 */       setDead();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 202 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.55D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 208 */     int xdir = 1;
/* 209 */     int zdir = 1;
/*     */     
/* 211 */     int keep_trying = 50;
/*     */ 
/*     */     
/* 214 */     EntityLivingBase e = null;
/*     */     
/* 216 */     if (this.isDead)
/* 217 */       return;  super.updateAITasks();
/*     */     
/* 219 */     if (this.currentFlightTarget == null) {
/* 220 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */     
/* 223 */     if (this.rand.nextInt(300) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*     */       
/* 225 */       Block bid = Blocks.stone;
/* 226 */       while (bid != Blocks.air && keep_trying != 0) {
/* 227 */         zdir = this.rand.nextInt(10) + 8;
/* 228 */         xdir = this.rand.nextInt(10) + 8;
/* 229 */         if (this.rand.nextInt(2) == 0) zdir = -zdir; 
/* 230 */         if (this.rand.nextInt(2) == 0) xdir = -xdir; 
/* 231 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(20) - 10, (int)this.posZ + zdir);
/* 232 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 233 */         if (bid == Blocks.air && 
/* 234 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 235 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 238 */         keep_trying--;
/*     */       }
/*     */     
/* 241 */     } else if (this.rand.nextInt(7) == 2 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
/*     */ 
/*     */ 
/*     */       
/* 245 */       e = findSomethingToAttack();
/* 246 */       if (e != null) {
/*     */ 
/*     */         
/* 249 */         this.currentFlightTarget.set((int)e.posX, (int)(e.posY + (e.height / 2.0F)), (int)e.posZ);
/*     */         
/* 251 */         if (getDistanceSqToEntity((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 252 */           attackEntityAsMob((Entity)e);
/* 253 */           setDead();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 259 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
/* 260 */       setDead();
/*     */     }
/*     */ 
/*     */     
/* 264 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 265 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 266 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 267 */     this.motionX += (Math.signum(var1) * 0.4D - this.motionX) * 0.2D;
/* 268 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.20000000149011612D;
/* 269 */     this.motionZ += (Math.signum(var5) * 0.4D - this.motionZ) * 0.2D;
/* 270 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 271 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 272 */     this.moveForward = 0.75F;
/* 273 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 282 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFallState(double par1, boolean par3) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 300 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 308 */     boolean ret = false;
/* 309 */     Entity e = par1DamageSource.getEntity();
/* 310 */     float dm = par2;
/* 311 */     if (e != null && e instanceof net.minecraft.entity.projectile.EntityArrow)
/*     */     {
/* 313 */       return false;
/*     */     }
/* 315 */     if (dm > 10.0F) dm = 10.0F; 
/* 316 */     ret = super.attackEntityFrom(par1DamageSource, dm);
/* 317 */     if (e != null && this.currentFlightTarget != null)
/*     */     {
/* 319 */       this.currentFlightTarget.set((int)e.posX, (int)(e.posY + (e.height / 2.0F)), (int)e.posZ);
/*     */     }
/* 321 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 331 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 339 */     return 25;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 347 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*     */     
/* 349 */     if (par1EntityLiving == null)
/*     */     {
/* 351 */       return false;
/*     */     }
/* 353 */     if (par1EntityLiving == this)
/*     */     {
/* 355 */       return false;
/*     */     }
/* 357 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 360 */       return false;
/*     */     }
/*     */     
/* 363 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 365 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 368 */       return false;
/*     */     }
/*     */     
/* 371 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 373 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 374 */       if (p.capabilities.isCreativeMode == true) {
/* 375 */         return false;
/*     */       }
/* 377 */       if (getPurpleType() > 0 && getPurpleType() != 10) return false; 
/* 378 */       return true;
/*     */     } 
/*     */     
/* 381 */     if (getPurpleType() != 0 && getPurpleType() != 10 && 
/* 382 */       par1EntityLiving instanceof EntityTameable) {
/*     */       
/* 384 */       EntityTameable e = (EntityTameable)par1EntityLiving;
/* 385 */       if (e.isTamed()) {
/* 386 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 391 */     if (MyUtils.isRoyalty((Entity)par1EntityLiving))
/*     */     {
/* 393 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 397 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 402 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 403 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(32.0D, 24.0D, 32.0D));
/* 404 */     Collections.sort(var5, this.TargetSorter);
/* 405 */     Iterator<?> var2 = var5.iterator();
/* 406 */     Entity var3 = null;
/* 407 */     EntityLivingBase var4 = null;
/*     */     
/* 409 */     while (var2.hasNext()) {
/*     */       
/* 411 */       var3 = (Entity)var2.next();
/* 412 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 414 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 416 */         return var4;
/*     */       }
/*     */     } 
/* 419 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 424 */     boolean var4 = false;
/*     */     
/* 426 */     if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */       
/* 428 */       EntityLivingBase e = (EntityLivingBase)par1Entity;
/* 429 */       if (getPurpleType() == 0 || getPurpleType() == 10) {
/* 430 */         e.setHealth(e.getHealth() / 4.0F - 1.0F);
/* 431 */         var4 = e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), e.getMaxHealth() / 8.0F);
/* 432 */         if (getPurpleType() == 10) {
/* 433 */           this.worldObj.newExplosion((Entity)null, e.posX, e.posY - 0.25D, e.posZ, 9.1F, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
/*     */         }
/*     */       } else {
/*     */         
/* 437 */         e.setHealth(e.getHealth() * 15.0F / 16.0F);
/* 438 */         var4 = e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 5.0F);
/* 439 */         if (getPurpleType() == 1) e.setFire(10); 
/* 440 */         if (getPurpleType() == 2) e.addPotionEffect(new PotionEffect(Potion.poison.id, 50, 0)); 
/* 441 */         if (getPurpleType() == 3) e.addPotionEffect(new PotionEffect(Potion.weakness.id, 50, 0)); 
/*     */       } 
/*     */     } 
/* 444 */     return var4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 452 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 460 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 461 */     par1NBTTagCompound.setInteger("PurpleType", this.purple_type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 469 */     super.readEntityFromNBT(par1NBTTagCompound);
/* 470 */     this.purple_type = par1NBTTagCompound.getInteger("PurpleType");
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\PurplePower.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */