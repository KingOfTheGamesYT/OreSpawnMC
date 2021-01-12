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
/*     */ public class TerribleTerror
/*     */   extends EntityMob
/*     */ {
/*  52 */   private ChunkCoordinates currentFlightTarget = null;
/*  53 */   private GenericTargetSorter TargetSorter = null;
/*     */   
/*     */   public TerribleTerror(World par1World) {
/*  56 */     super(par1World);
/*  57 */     setSize(1.0F, 0.75F);
/*  58 */     getNavigator().setAvoidsWater(false);
/*  59 */     this.experienceValue = 10;
/*  60 */     this.isImmuneToFire = false;
/*  61 */     this.fireResistance = 5;
/*  62 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  67 */     super.applyEntityAttributes();
/*  68 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  69 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612D);
/*  70 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.TerribleTerror_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  75 */     if (isNoDespawnRequired()) return false; 
/*  76 */     if (!this.worldObj.isDaytime()) return false; 
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  84 */     return 0.45F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  91 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/*  98 */     return "orespawn:terribleterror_living";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 105 */     return "orespawn:terribleterror_hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 112 */     return "orespawn:terribleterror_dead";
/*     */   }
/*     */   
/*     */   public int mygetMaxHealth() {
/* 116 */     return OreSpawnMain.TerribleTerror_stats.health;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 121 */     return OreSpawnMain.TerribleTerror_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 128 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 136 */     super.onUpdate();
/*     */     
/* 138 */     this.motionY *= 0.6D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 146 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 5.0F);
/* 147 */     return var4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 155 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 161 */     int xdir = 1;
/* 162 */     int zdir = 1;
/*     */     
/* 164 */     int keep_trying = 50;
/*     */ 
/*     */ 
/*     */     
/* 168 */     if (this.isDead)
/* 169 */       return;  super.updateAITasks();
/*     */     
/* 171 */     if (this.currentFlightTarget == null) {
/* 172 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */ 
/*     */     
/* 176 */     if (this.rand.nextInt(100) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*     */       
/* 178 */       Block bid = Blocks.stone;
/* 179 */       while (bid != Blocks.air && keep_trying != 0) {
/* 180 */         zdir = this.rand.nextInt(5) + 5;
/* 181 */         xdir = this.rand.nextInt(5) + 5;
/* 182 */         if (this.rand.nextInt(2) == 0) zdir = -zdir; 
/* 183 */         if (this.rand.nextInt(2) == 0) xdir = -xdir; 
/* 184 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(5) - 2, (int)this.posZ + zdir);
/* 185 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 186 */         if (bid == Blocks.air && 
/* 187 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 188 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 191 */         keep_trying--;
/*     */       }
/*     */     
/* 194 */     } else if (this.rand.nextInt(9) == 0) {
/*     */ 
/*     */       
/* 197 */       EntityLivingBase e = null;
/* 198 */       e = findSomethingToAttack();
/* 199 */       if (e != null) {
/*     */ 
/*     */         
/* 202 */         this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0D), (int)e.posZ);
/* 203 */         if (getDistanceSqToEntity((Entity)e) < 6.0D) {
/* 204 */           attackEntityAsMob((Entity)e);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 210 */     double var1 = this.currentFlightTarget.posX + 0.4D - this.posX;
/* 211 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 212 */     double var5 = this.currentFlightTarget.posZ + 0.4D - this.posZ;
/* 213 */     this.motionX += (Math.signum(var1) * 0.4D - this.motionX) * 0.30000000149011613D;
/* 214 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.20000000149011612D;
/* 215 */     this.motionZ += (Math.signum(var5) * 0.4D - this.motionZ) * 0.30000000149011613D;
/* 216 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 217 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 218 */     this.moveForward = 0.75F;
/* 219 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 228 */     return true;
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
/* 246 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 256 */     boolean ret = super.attackEntityFrom(par1DamageSource, par2);
/* 257 */     Entity e = par1DamageSource.getEntity();
/* 258 */     if (e != null && this.currentFlightTarget != null)
/*     */     {
/* 260 */       this.currentFlightTarget.set((int)e.posX, (int)e.posY, (int)e.posZ);
/*     */     }
/* 262 */     return ret;
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
/*     */   public boolean getCanSpawnHere() {
/* 274 */     for (int k = -2; k < 2; k++) {
/*     */       
/* 276 */       for (int j = -2; j < 2; j++) {
/*     */         
/* 278 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 280 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 281 */           if (bid == Blocks.mob_spawner) {
/* 282 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 283 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 284 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 285 */             if (s != null && 
/* 286 */               s.equals("Terrible Terror")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 292 */     if (!isValidLightLevel()) return false; 
/* 293 */     if (this.worldObj.isDaytime()) return false; 
/* 294 */     if (this.worldObj.provider.dimensionId != OreSpawnMain.DimensionID6 && 
/* 295 */       this.posY > 40.0D) return false;
/*     */     
/* 297 */     return true;
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
/* 308 */     if (par1EntityLiving == null)
/*     */     {
/* 310 */       return false;
/*     */     }
/* 312 */     if (par1EntityLiving == this)
/*     */     {
/* 314 */       return false;
/*     */     }
/* 316 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 319 */       return false;
/*     */     }
/* 321 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 324 */       return false;
/*     */     }
/* 326 */     if (par1EntityLiving instanceof RockBase)
/*     */     {
/* 328 */       return false;
/*     */     }
/* 330 */     if (par1EntityLiving instanceof TerribleTerror)
/*     */     {
/* 332 */       return false;
/*     */     }
/* 334 */     if (par1EntityLiving instanceof EnderReaper)
/*     */     {
/* 336 */       return false;
/*     */     }
/* 338 */     if (par1EntityLiving instanceof Mothra)
/*     */     {
/* 340 */       return false;
/*     */     }
/* 342 */     if (par1EntityLiving instanceof LurkingTerror)
/*     */     {
/* 344 */       return false;
/*     */     }
/* 346 */     if (par1EntityLiving instanceof CloudShark)
/*     */     {
/* 348 */       return false;
/*     */     }
/* 350 */     if (par1EntityLiving instanceof Rotator)
/*     */     {
/* 352 */       return false;
/*     */     }
/* 354 */     if (par1EntityLiving instanceof Bee)
/*     */     {
/* 356 */       return false;
/*     */     }
/* 358 */     if (par1EntityLiving instanceof Mantis)
/*     */     {
/* 360 */       return false;
/*     */     }
/* 362 */     if (par1EntityLiving instanceof LeafMonster)
/*     */     {
/* 364 */       return false;
/*     */     }
/* 366 */     if (par1EntityLiving instanceof CreepingHorror)
/*     */     {
/* 368 */       return false;
/*     */     }
/* 370 */     if (par1EntityLiving instanceof Triffid)
/*     */     {
/* 372 */       return false;
/*     */     }
/* 374 */     if (par1EntityLiving instanceof PitchBlack)
/*     */     {
/* 376 */       return false;
/*     */     }
/* 378 */     if (par1EntityLiving instanceof Dragon)
/*     */     {
/* 380 */       return false;
/*     */     }
/* 382 */     if (par1EntityLiving instanceof Island)
/*     */     {
/* 384 */       return false;
/*     */     }
/* 386 */     if (par1EntityLiving instanceof IslandToo)
/*     */     {
/* 388 */       return false;
/*     */     }
/* 390 */     if (par1EntityLiving instanceof EntityButterfly)
/*     */     {
/* 392 */       return false;
/*     */     }
/* 394 */     if (par1EntityLiving instanceof Firefly)
/*     */     {
/* 396 */       return false;
/*     */     }
/* 398 */     if (par1EntityLiving instanceof Triffid)
/*     */     {
/* 400 */       return false;
/*     */     }
/* 402 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 404 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 405 */       if (p.capabilities.isCreativeMode == true) {
/* 406 */         return false;
/*     */       }
/*     */     } 
/* 409 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 414 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 415 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 8.0D, 12.0D));
/* 416 */     Collections.sort(var5, this.TargetSorter);
/* 417 */     Iterator<?> var2 = var5.iterator();
/* 418 */     Entity var3 = null;
/* 419 */     EntityLivingBase var4 = null;
/*     */     
/* 421 */     while (var2.hasNext()) {
/*     */       
/* 423 */       var3 = (Entity)var2.next();
/* 424 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 426 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 428 */         return var4;
/*     */       }
/*     */     } 
/* 431 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 440 */     int i = this.worldObj.rand.nextInt(3);
/* 441 */     if (i == 0) return Items.rotten_flesh; 
/* 442 */     if (i == 1) return Items.emerald; 
/* 443 */     return Items.feather;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\TerribleTerror.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */