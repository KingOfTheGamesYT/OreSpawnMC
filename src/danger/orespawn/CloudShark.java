/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
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
/*     */ public class CloudShark
/*     */   extends EntityMob
/*     */ {
/*  51 */   private ChunkCoordinates currentFlightTarget = null;
/*  52 */   private GenericTargetSorter TargetSorter = null;
/*     */ 
/*     */   
/*     */   public CloudShark(World par1World) {
/*  56 */     super(par1World);
/*  57 */     setSize(1.0F, 0.75F);
/*  58 */     this.experienceValue = 5;
/*  59 */     this.isImmuneToFire = false;
/*  60 */     this.fireResistance = 5;
/*  61 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  66 */     super.applyEntityAttributes();
/*  67 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  68 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
/*     */     
/*  70 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.CloudShark_stats.attack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  76 */     float f = (float)getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
/*  77 */     boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), f);
/*  78 */     return flag;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  82 */     if (isNoDespawnRequired()) return false; 
/*  83 */     if (this.worldObj.isDaytime()) return false; 
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  91 */     return 0.25F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  98 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 105 */     return "splash";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 112 */     return "orespawn:little_splat";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 119 */     return "orespawn:big_splat";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 133 */     return OreSpawnMain.CloudShark_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 140 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 148 */     super.onUpdate();
/*     */     
/* 150 */     this.motionY *= 0.6D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 158 */     return OreSpawnMain.CloudShark_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 165 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 171 */     int xdir = 1;
/* 172 */     int zdir = 1;
/*     */     
/* 174 */     int keep_trying = 50;
/*     */ 
/*     */     
/* 177 */     int updown = 0;
/*     */     
/* 179 */     if (this.isDead)
/* 180 */       return;  super.updateAITasks();
/*     */     
/* 182 */     if (this.currentFlightTarget == null) {
/* 183 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/* 185 */     if ((int)this.posY < 120) updown = 2; 
/* 186 */     if ((int)this.posY > 140) updown = -2; 
/* 187 */     if (this.rand.nextInt(300) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*     */       
/* 189 */       Block bid = Blocks.stone;
/* 190 */       while (bid != Blocks.air && keep_trying != 0) {
/* 191 */         zdir = this.rand.nextInt(10) + 8;
/* 192 */         xdir = this.rand.nextInt(10) + 8;
/* 193 */         if (this.rand.nextInt(2) == 0) zdir = -zdir; 
/* 194 */         if (this.rand.nextInt(2) == 0) xdir = -xdir; 
/* 195 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(5) - 2 + updown, (int)this.posZ + zdir);
/* 196 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 197 */         if (bid == Blocks.air && 
/* 198 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 199 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 202 */         keep_trying--;
/*     */       } 
/*     */     } 
/*     */     
/* 206 */     if (this.rand.nextInt(9) == 2) {
/*     */ 
/*     */       
/* 209 */       EntityLivingBase e = null;
/* 210 */       e = findSomethingToAttack();
/* 211 */       if (e != null) {
/*     */ 
/*     */         
/* 214 */         this.currentFlightTarget.set((int)e.posX, (int)e.posY, (int)e.posZ);
/* 215 */         if (getDistanceSqToEntity((Entity)e) < 9.0D) {
/* 216 */           attackEntityAsMob((Entity)e);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 222 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 223 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 224 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 225 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.30000000149011613D;
/* 226 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.20000000149011612D;
/* 227 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.30000000149011613D;
/* 228 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 229 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 230 */     this.moveForward = 1.0F;
/* 231 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 240 */     return true;
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
/* 258 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 268 */     boolean ret = super.attackEntityFrom(par1DamageSource, par2);
/* 269 */     Entity e = par1DamageSource.getEntity();
/* 270 */     if (e != null && this.currentFlightTarget != null)
/*     */     {
/* 272 */       this.currentFlightTarget.set((int)e.posX, (int)e.posY, (int)e.posZ);
/*     */     }
/* 274 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 284 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 296 */     if (par1EntityLiving == null)
/*     */     {
/* 298 */       return false;
/*     */     }
/* 300 */     if (par1EntityLiving == this)
/*     */     {
/* 302 */       return false;
/*     */     }
/* 304 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 307 */       return false;
/*     */     }
/* 309 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 312 */       return false;
/*     */     }
/* 314 */     if (par1EntityLiving instanceof RockBase)
/*     */     {
/* 316 */       return false;
/*     */     }
/* 318 */     if (par1EntityLiving instanceof EntityAnt)
/*     */     {
/* 320 */       return false;
/*     */     }
/* 322 */     if (par1EntityLiving instanceof EntityButterfly)
/*     */     {
/* 324 */       return true;
/*     */     }
/* 326 */     if (par1EntityLiving instanceof Cockateil)
/*     */     {
/* 328 */       return true;
/*     */     }
/* 330 */     if (par1EntityLiving instanceof EntityMosquito)
/*     */     {
/* 332 */       return true;
/*     */     }
/* 334 */     if (par1EntityLiving instanceof Firefly)
/*     */     {
/* 336 */       return true;
/*     */     }
/* 338 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 340 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 341 */       if (p.capabilities.isCreativeMode != true) {
/* 342 */         return true;
/*     */       }
/*     */     } 
/* 345 */     if (par1EntityLiving instanceof GoldFish)
/*     */     {
/* 347 */       return true;
/*     */     }
/* 349 */     if (par1EntityLiving instanceof CliffRacer)
/*     */     {
/* 351 */       return true;
/*     */     }
/*     */     
/* 354 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 359 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 360 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 10.0D, 12.0D));
/* 361 */     Collections.sort(var5, this.TargetSorter);
/* 362 */     Iterator<?> var2 = var5.iterator();
/* 363 */     Entity var3 = null;
/* 364 */     EntityLivingBase var4 = null;
/*     */     
/* 366 */     while (var2.hasNext()) {
/*     */       
/* 368 */       var3 = (Entity)var2.next();
/* 369 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 371 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 373 */         return var4;
/*     */       }
/*     */     } 
/* 376 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 385 */     int i = this.worldObj.rand.nextInt(3);
/* 386 */     if (i == 0) return Items.paper; 
/* 387 */     if (i == 1) return Items.string; 
/* 388 */     if (i == 2) return Items.bone; 
/* 389 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 395 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CloudShark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */