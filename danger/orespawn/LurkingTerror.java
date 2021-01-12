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
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
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
/*     */ public class LurkingTerror
/*     */   extends EntityMob
/*     */ {
/*  52 */   private ChunkCoordinates currentFlightTarget = null;
/*  53 */   private GenericTargetSorter TargetSorter = null;
/*  54 */   private RenderInfo renderdata = new RenderInfo();
/*     */   
/*     */   public LurkingTerror(World par1World) {
/*  57 */     super(par1World);
/*  58 */     setSize(1.75F, 1.25F);
/*  59 */     getNavigator().setAvoidsWater(false);
/*  60 */     this.experienceValue = 20;
/*  61 */     this.isImmuneToFire = false;
/*  62 */     this.fireResistance = 5;
/*  63 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  68 */     super.applyEntityAttributes();
/*  69 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  70 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
/*  71 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.LurkingTerror_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  76 */     super.entityInit();
/*  77 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  78 */     if (this.renderdata == null) {
/*  79 */       this.renderdata = new RenderInfo();
/*     */     }
/*  81 */     this.renderdata.rf1 = 0.0F;
/*  82 */     this.renderdata.rf2 = 0.0F;
/*  83 */     this.renderdata.rf3 = 0.0F;
/*  84 */     this.renderdata.rf4 = 0.0F;
/*  85 */     this.renderdata.ri1 = 0;
/*  86 */     this.renderdata.ri2 = 0;
/*  87 */     this.renderdata.ri3 = 0;
/*  88 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  92 */     if (isNoDespawnRequired()) return false; 
/*  93 */     if (getAttacking() != 0) return false; 
/*  94 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAttacking() {
/*  99 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAttacking(int par1) {
/* 104 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 111 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 116 */     this.renderdata.rf1 = r.rf1;
/* 117 */     this.renderdata.rf2 = r.rf2;
/* 118 */     this.renderdata.rf3 = r.rf3;
/* 119 */     this.renderdata.rf4 = r.rf4;
/* 120 */     this.renderdata.ri1 = r.ri1;
/* 121 */     this.renderdata.ri2 = r.ri2;
/* 122 */     this.renderdata.ri3 = r.ri3;
/* 123 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 131 */     return 0.55F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 138 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 145 */     return "orespawn:lurkinghorror_living";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 152 */     return "orespawn:lurkinghorror_hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 159 */     return "orespawn:lurkinghorror_dead";
/*     */   }
/*     */   
/*     */   public int mygetMaxHealth() {
/* 163 */     return OreSpawnMain.LurkingTerror_stats.health;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 168 */     return OreSpawnMain.LurkingTerror_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 176 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 184 */     super.onUpdate();
/*     */     
/* 186 */     this.motionY *= 0.6D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 194 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 5.0F);
/* 195 */     return var4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 203 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 209 */     int xdir = 1;
/* 210 */     int zdir = 1;
/*     */     
/* 212 */     int keep_trying = 50;
/*     */ 
/*     */ 
/*     */     
/* 216 */     if (this.isDead)
/* 217 */       return;  super.updateAITasks();
/*     */     
/* 219 */     if (this.currentFlightTarget == null) {
/* 220 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */ 
/*     */     
/* 224 */     if (this.rand.nextInt(120) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*     */       
/* 226 */       Block bid = Blocks.stone;
/* 227 */       while (bid != Blocks.air && keep_trying != 0) {
/* 228 */         zdir = this.rand.nextInt(10) + 2;
/* 229 */         xdir = this.rand.nextInt(10) + 2;
/* 230 */         if (this.rand.nextInt(2) == 0) zdir = -zdir; 
/* 231 */         if (this.rand.nextInt(2) == 0) xdir = -xdir; 
/* 232 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(5) - 2, (int)this.posZ + zdir);
/* 233 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 234 */         if (bid == Blocks.air && 
/* 235 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 236 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 239 */         keep_trying--;
/*     */       }
/*     */     
/* 242 */     } else if (this.rand.nextInt(9) == 0) {
/*     */ 
/*     */       
/* 245 */       EntityLivingBase e = null;
/* 246 */       e = findSomethingToAttack();
/* 247 */       if (e != null) {
/*     */         
/* 249 */         setAttacking(1);
/*     */         
/* 251 */         this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0D), (int)e.posZ);
/* 252 */         if (getDistanceSqToEntity((Entity)e) < 6.0D) {
/* 253 */           attackEntityAsMob((Entity)e);
/*     */         }
/*     */       } else {
/*     */         
/* 257 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */     
/* 261 */     double var1 = this.currentFlightTarget.posX + 0.4D - this.posX;
/* 262 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 263 */     double var5 = this.currentFlightTarget.posZ + 0.4D - this.posZ;
/* 264 */     this.motionX += (Math.signum(var1) * 0.4D - this.motionX) * 0.30000000149011613D;
/* 265 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.20000000149011612D;
/* 266 */     this.motionZ += (Math.signum(var5) * 0.4D - this.motionZ) * 0.30000000149011613D;
/* 267 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 268 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 269 */     this.moveForward = 0.75F;
/* 270 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 279 */     return true;
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
/* 297 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 307 */     boolean ret = super.attackEntityFrom(par1DamageSource, par2);
/* 308 */     Entity e = par1DamageSource.getEntity();
/* 309 */     if (e != null && this.currentFlightTarget != null)
/*     */     {
/* 311 */       this.currentFlightTarget.set((int)e.posX, (int)e.posY, (int)e.posZ);
/*     */     }
/* 313 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 323 */     LurkingTerror target = null;
/*     */ 
/*     */     
/* 326 */     for (int k = -2; k < 2; k++) {
/*     */       
/* 328 */       for (int j = -2; j < 2; j++) {
/*     */         
/* 330 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 332 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 333 */           if (bid == Blocks.mob_spawner) {
/* 334 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 335 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 336 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 337 */             if (s != null && 
/* 338 */               s.equals("Lurking Terror")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 344 */     if (!isValidLightLevel()) return false; 
/* 345 */     if (!this.worldObj.isDaytime()) return false; 
/* 346 */     if (this.worldObj.rand.nextInt(2) != 1) return false; 
/* 347 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID6 && this.worldObj.rand.nextInt(6) != 0) return false; 
/* 348 */     target = (LurkingTerror)this.worldObj.findNearestEntityWithinAABB(LurkingTerror.class, this.boundingBox.expand(32.0D, 16.0D, 32.0D), (Entity)this);
/* 349 */     if (target != null)
/*     */     {
/* 351 */       return false;
/*     */     }
/* 353 */     if (this.posY < 10.0D) return false; 
/* 354 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 365 */     if (par1EntityLiving == null)
/*     */     {
/* 367 */       return false;
/*     */     }
/* 369 */     if (par1EntityLiving == this)
/*     */     {
/* 371 */       return false;
/*     */     }
/* 373 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 376 */       return false;
/*     */     }
/*     */     
/* 379 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 382 */       return false;
/*     */     }
/* 384 */     if (par1EntityLiving instanceof LurkingTerror)
/*     */     {
/* 386 */       return false;
/*     */     }
/* 388 */     if (par1EntityLiving instanceof RockBase)
/*     */     {
/* 390 */       return false;
/*     */     }
/* 392 */     if (par1EntityLiving instanceof EnderReaper)
/*     */     {
/* 394 */       return false;
/*     */     }
/* 396 */     if (par1EntityLiving instanceof LeafMonster)
/*     */     {
/* 398 */       return false;
/*     */     }
/* 400 */     if (par1EntityLiving instanceof TerribleTerror)
/*     */     {
/* 402 */       return false;
/*     */     }
/* 404 */     if (par1EntityLiving instanceof Mothra)
/*     */     {
/* 406 */       return false;
/*     */     }
/* 408 */     if (par1EntityLiving instanceof CloudShark)
/*     */     {
/* 410 */       return false;
/*     */     }
/* 412 */     if (par1EntityLiving instanceof Rotator)
/*     */     {
/* 414 */       return false;
/*     */     }
/* 416 */     if (par1EntityLiving instanceof Bee)
/*     */     {
/* 418 */       return false;
/*     */     }
/* 420 */     if (par1EntityLiving instanceof Mantis)
/*     */     {
/* 422 */       return false;
/*     */     }
/* 424 */     if (par1EntityLiving instanceof CreepingHorror)
/*     */     {
/* 426 */       return false;
/*     */     }
/* 428 */     if (par1EntityLiving instanceof Triffid)
/*     */     {
/* 430 */       return false;
/*     */     }
/* 432 */     if (par1EntityLiving instanceof PitchBlack)
/*     */     {
/* 434 */       return false;
/*     */     }
/* 436 */     if (par1EntityLiving instanceof Dragon)
/*     */     {
/* 438 */       return false;
/*     */     }
/* 440 */     if (par1EntityLiving instanceof Island)
/*     */     {
/* 442 */       return false;
/*     */     }
/* 444 */     if (par1EntityLiving instanceof IslandToo)
/*     */     {
/* 446 */       return false;
/*     */     }
/* 448 */     if (par1EntityLiving instanceof EntityButterfly)
/*     */     {
/* 450 */       return false;
/*     */     }
/*     */     
/* 453 */     if (par1EntityLiving instanceof Firefly)
/*     */     {
/* 455 */       return false;
/*     */     }
/* 457 */     if (par1EntityLiving instanceof Triffid)
/*     */     {
/* 459 */       return false;
/*     */     }
/* 461 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 463 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 464 */       if (p.capabilities.isCreativeMode == true) {
/* 465 */         return false;
/*     */       }
/*     */     } 
/* 468 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 473 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 474 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 8.0D, 12.0D));
/* 475 */     Collections.sort(var5, this.TargetSorter);
/* 476 */     Iterator<?> var2 = var5.iterator();
/* 477 */     Entity var3 = null;
/* 478 */     EntityLivingBase var4 = null;
/*     */     
/* 480 */     while (var2.hasNext()) {
/*     */       
/* 482 */       var3 = (Entity)var2.next();
/* 483 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 485 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 487 */         return var4;
/*     */       }
/*     */     } 
/* 490 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 499 */     int i = this.worldObj.rand.nextInt(3);
/* 500 */     if (i == 0) return Items.beef; 
/* 501 */     if (i == 1) return Items.flint; 
/* 502 */     return Items.feather;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\LurkingTerror.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */