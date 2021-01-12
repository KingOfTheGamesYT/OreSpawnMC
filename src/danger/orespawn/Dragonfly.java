/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
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
/*     */ 
/*     */ public class Dragonfly
/*     */   extends EntityAnimal
/*     */ {
/*  52 */   private ChunkCoordinates currentFlightTarget = null;
/*  53 */   private GenericTargetSorter TargetSorter = null;
/*     */ 
/*     */   
/*     */   public Dragonfly(World par1World) {
/*  57 */     super(par1World);
/*  58 */     setSize(1.5F, 0.5F);
/*  59 */     getNavigator().setAvoidsWater(false);
/*  60 */     this.experienceValue = 5;
/*  61 */     this.isImmuneToFire = false;
/*  62 */     this.fireResistance = 5;
/*  63 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  68 */     super.applyEntityAttributes();
/*  69 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  70 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.33000001311302185D);
/*  71 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  72 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  78 */     super.entityInit();
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  82 */     if (isNoDespawnRequired()) return false; 
/*  83 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  90 */     return 0.25F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  97 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 104 */     return "orespawn:dragonfly_living";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 111 */     return "orespawn:dragonfly_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 118 */     return "orespawn:dragonfly_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 125 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 132 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 139 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 147 */     super.onUpdate();
/*     */     
/* 149 */     this.motionY *= 0.6D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 157 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 2.0F);
/* 158 */     return var4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 166 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.25D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 172 */     int xdir = 1;
/* 173 */     int zdir = 1;
/*     */     
/* 175 */     int keep_trying = 50;
/*     */ 
/*     */ 
/*     */     
/* 179 */     if (this.isDead)
/* 180 */       return;  super.updateAITasks();
/*     */     
/* 182 */     if (this.currentFlightTarget == null) {
/* 183 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */ 
/*     */     
/* 187 */     if (this.rand.nextInt(300) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*     */       
/* 189 */       Block bid = Blocks.stone;
/* 190 */       while (bid != Blocks.air && keep_trying != 0) {
/* 191 */         zdir = this.rand.nextInt(5) + 5;
/* 192 */         xdir = this.rand.nextInt(5) + 5;
/* 193 */         if (this.rand.nextInt(2) == 0) zdir = -zdir; 
/* 194 */         if (this.rand.nextInt(2) == 0) xdir = -xdir; 
/* 195 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(5) - 2, (int)this.posZ + zdir);
/* 196 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 197 */         if (bid == Blocks.air && 
/* 198 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 199 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 202 */         keep_trying--;
/*     */       }
/*     */     
/* 205 */     } else if (this.rand.nextInt(12) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
/*     */ 
/*     */       
/* 208 */       EntityLivingBase e = null;
/* 209 */       e = findSomethingToAttack();
/* 210 */       if (e != null) {
/*     */ 
/*     */         
/* 213 */         this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0D), (int)e.posZ);
/* 214 */         if (getDistanceSqToEntity((Entity)e) < 6.0D) {
/* 215 */           attackEntityAsMob((Entity)e);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 221 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 222 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 223 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 224 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.30000000149011613D;
/* 225 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.20000000149011612D;
/* 226 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.30000000149011613D;
/* 227 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 228 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 229 */     this.moveForward = 1.0F;
/* 230 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 239 */     return true;
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
/* 257 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 267 */     boolean ret = super.attackEntityFrom(par1DamageSource, par2);
/* 268 */     Entity e = par1DamageSource.getEntity();
/* 269 */     if (e != null && this.currentFlightTarget != null)
/*     */     {
/* 271 */       this.currentFlightTarget.set((int)e.posX, (int)e.posY, (int)e.posZ);
/*     */     }
/* 273 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 284 */     if (this.posY < 50.0D) return false; 
/* 285 */     if (!this.worldObj.isDaytime()) return false; 
/* 286 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 300 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*     */     
/* 302 */     if (par1EntityLiving == null)
/*     */     {
/* 304 */       return false;
/*     */     }
/* 306 */     if (par1EntityLiving == this)
/*     */     {
/* 308 */       return false;
/*     */     }
/* 310 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 313 */       return false;
/*     */     }
/* 315 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 318 */       return false;
/*     */     }
/* 320 */     if (par1EntityLiving instanceof EntityAnt)
/*     */     {
/* 322 */       return true;
/*     */     }
/* 324 */     if (par1EntityLiving instanceof EntityButterfly)
/*     */     {
/* 326 */       return true;
/*     */     }
/* 328 */     if (par1EntityLiving instanceof Cockateil)
/*     */     {
/* 330 */       return true;
/*     */     }
/* 332 */     if (par1EntityLiving instanceof EntityMosquito)
/*     */     {
/* 334 */       return true;
/*     */     }
/* 336 */     if (par1EntityLiving instanceof Firefly)
/*     */     {
/* 338 */       return true;
/*     */     }
/* 340 */     if (par1EntityLiving instanceof net.minecraft.entity.passive.EntityHorse && OreSpawnMain.DragonflyHorseFriendly == 0)
/*     */     {
/* 342 */       return true;
/*     */     }
/* 344 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 349 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 350 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0D, 6.0D, 10.0D));
/* 351 */     Collections.sort(var5, this.TargetSorter);
/* 352 */     Iterator<?> var2 = var5.iterator();
/* 353 */     Entity var3 = null;
/* 354 */     EntityLivingBase var4 = null;
/*     */     
/* 356 */     while (var2.hasNext()) {
/*     */       
/* 358 */       var3 = (Entity)var2.next();
/* 359 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 361 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 363 */         return var4;
/*     */       }
/*     */     } 
/* 366 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 375 */     int i = this.worldObj.rand.nextInt(6);
/* 376 */     if (i == 0) return Items.gold_nugget; 
/* 377 */     if (i == 1) return OreSpawnMain.UraniumNugget; 
/* 378 */     if (i == 2) return OreSpawnMain.TitaniumNugget; 
/* 379 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable var1) {
/* 385 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Dragonfly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */