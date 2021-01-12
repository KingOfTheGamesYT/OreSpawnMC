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
/*     */ 
/*     */ public class Rotator
/*     */   extends EntityMob
/*     */ {
/*  53 */   private ChunkCoordinates currentFlightTarget = null;
/*  54 */   private GenericTargetSorter TargetSorter = null;
/*  55 */   private RenderInfo renderdata = new RenderInfo();
/*  56 */   private int busy_fighting = 0;
/*  57 */   private int was_spawnered = 0;
/*     */   
/*     */   public Rotator(World par1World) {
/*  60 */     super(par1World);
/*  61 */     setSize(1.0F, 2.0F);
/*  62 */     this.experienceValue = 35;
/*  63 */     this.isImmuneToFire = true;
/*  64 */     this.fireResistance = 25;
/*  65 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  66 */     this.renderdata = new RenderInfo();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  71 */     super.applyEntityAttributes();
/*  72 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  73 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
/*  74 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Rotator_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  79 */     super.entityInit();
/*  80 */     if (this.renderdata == null) {
/*  81 */       this.renderdata = new RenderInfo();
/*     */     }
/*  83 */     this.renderdata.rf1 = 0.0F;
/*  84 */     this.renderdata.rf2 = 0.0F;
/*  85 */     this.renderdata.rf3 = 0.0F;
/*  86 */     this.renderdata.rf4 = 0.0F;
/*  87 */     this.renderdata.ri1 = 0;
/*  88 */     this.renderdata.ri2 = 0;
/*  89 */     this.renderdata.ri3 = 0;
/*  90 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/*  97 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 102 */     this.renderdata.rf1 = r.rf1;
/* 103 */     this.renderdata.rf2 = r.rf2;
/* 104 */     this.renderdata.rf3 = r.rf3;
/* 105 */     this.renderdata.rf4 = r.rf4;
/* 106 */     this.renderdata.ri1 = r.ri1;
/* 107 */     this.renderdata.ri2 = r.ri2;
/* 108 */     this.renderdata.ri3 = r.ri3;
/* 109 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 114 */     if (isNoDespawnRequired()) return false; 
/* 115 */     if (this.busy_fighting != 0) return false; 
/* 116 */     if (this.was_spawnered != 0) return false; 
/* 117 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 124 */     return 0.75F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 131 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 138 */     return "vortexlive";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 145 */     return "orespawn:glasshit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 152 */     return "orespawn:glassdead";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 159 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 166 */     return OreSpawnMain.Rotator_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 173 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 181 */     EntityLivingBase e = null;
/* 182 */     super.onUpdate();
/*     */     
/* 184 */     this.motionY *= 0.6D;
/* 185 */     if (this.worldObj.isRemote && this.worldObj.rand.nextInt(10) == 1) {
/* 186 */       this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.399999976158142D, this.posZ, ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 4.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 4.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 4.0F));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 191 */     this.busy_fighting = 0;
/* 192 */     e = findSomethingToAttack();
/* 193 */     if (e != null) {
/*     */       
/* 195 */       double a = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/* 196 */       this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.399999976158142D, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.0D, Math.sin(a));
/*     */ 
/*     */ 
/*     */       
/* 200 */       this.busy_fighting = 1;
/*     */     } 
/*     */ 
/*     */     
/* 204 */     if (isNoDespawnRequired())
/* 205 */       return;  if (this.busy_fighting != 0)
/* 206 */       return;  if (this.was_spawnered != 0)
/* 207 */       return;  long t = this.worldObj.getWorldTime();
/* 208 */     t %= 24000L;
/* 209 */     if (t < 12000L && this.worldObj.rand.nextInt(400) == 1) setDead();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 218 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 224 */     int xdir = 1;
/* 225 */     int zdir = 1;
/*     */     
/* 227 */     int keep_trying = 50;
/*     */ 
/*     */     
/* 230 */     EntityLivingBase e = null;
/*     */     
/* 232 */     if (this.isDead)
/* 233 */       return;  super.updateAITasks();
/*     */     
/* 235 */     if (this.currentFlightTarget == null) {
/* 236 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */     
/* 239 */     if (this.rand.nextInt(300) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*     */       
/* 241 */       Block bid = Blocks.stone;
/* 242 */       while (bid != Blocks.air && keep_trying != 0) {
/* 243 */         zdir = this.rand.nextInt(10) + 8;
/* 244 */         xdir = this.rand.nextInt(10) + 8;
/* 245 */         if (this.rand.nextInt(2) == 0) zdir = -zdir; 
/* 246 */         if (this.rand.nextInt(2) == 0) xdir = -xdir; 
/* 247 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(6) - 3, (int)this.posZ + zdir);
/* 248 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 249 */         if (bid == Blocks.air && 
/* 250 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 251 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 254 */         keep_trying--;
/*     */       }
/*     */     
/* 257 */     } else if (this.rand.nextInt(9) == 2) {
/*     */ 
/*     */ 
/*     */       
/* 261 */       e = findSomethingToAttack();
/* 262 */       if (e != null) {
/*     */ 
/*     */ 
/*     */         
/* 266 */         double a = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
/* 267 */         a += 1.5707963267948966D;
/* 268 */         this.currentFlightTarget.set((int)(e.posX + 2.5D * Math.cos(a)), (int)e.posY, (int)(e.posZ + 2.5D * Math.sin(a)));
/*     */         
/* 270 */         if (getDistanceSqToEntity((Entity)e) < 9.0D) {
/* 271 */           attackEntityAsMob((Entity)e);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 278 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 279 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 280 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 281 */     this.motionX += (Math.signum(var1) * 0.4D - this.motionX) * 0.2D;
/* 282 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.20000000149011612D;
/* 283 */     this.motionZ += (Math.signum(var5) * 0.4D - this.motionZ) * 0.2D;
/* 284 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 285 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 286 */     this.moveForward = 0.75F;
/* 287 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 296 */     return true;
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
/* 314 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 322 */     boolean ret = false;
/* 323 */     Entity e = par1DamageSource.getEntity();
/* 324 */     if (e != null && e instanceof net.minecraft.entity.projectile.EntityArrow)
/*     */     {
/* 326 */       return false;
/*     */     }
/* 328 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/* 329 */     if (e != null && this.currentFlightTarget != null)
/*     */     {
/* 331 */       this.currentFlightTarget.set((int)e.posX, (int)e.posY, (int)e.posZ);
/*     */     }
/* 333 */     return ret;
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
/*     */     int k;
/* 346 */     for (k = -2; k <= 2; k++) {
/*     */       
/* 348 */       for (int j = -2; j <= 2; j++) {
/*     */         
/* 350 */         for (int i = 1; i < 4; i++) {
/*     */           
/* 352 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 353 */           if (bid == Blocks.mob_spawner) {
/* 354 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 355 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 356 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 357 */             if (s != null && 
/* 358 */               s.equals("Rotator")) {
/* 359 */               this.was_spawnered = 1;
/* 360 */               return true;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 367 */     if (!isValidLightLevel()) return false;
/*     */     
/* 369 */     for (k = -1; k <= 1; k++) {
/*     */       
/* 371 */       for (int j = -1; j <= 1; j++) {
/*     */         
/* 373 */         for (int i = 1; i < 3; i++) {
/*     */           
/* 375 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 376 */           if (bid != Blocks.air) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 380 */     long t = this.worldObj.getWorldTime();
/* 381 */     t %= 24000L;
/* 382 */     if (t < 12000L) return false;
/*     */     
/* 384 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 392 */     return OreSpawnMain.Rotator_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 402 */     if (par1EntityLiving == null)
/*     */     {
/* 404 */       return false;
/*     */     }
/* 406 */     if (par1EntityLiving == this)
/*     */     {
/* 408 */       return false;
/*     */     }
/* 410 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 413 */       return false;
/*     */     }
/*     */     
/* 416 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 418 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 421 */       return false;
/*     */     }
/*     */     
/* 424 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 426 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 427 */       if (p.capabilities.isCreativeMode == true) {
/* 428 */         return false;
/*     */       }
/*     */     } 
/* 431 */     if (par1EntityLiving instanceof Termite)
/*     */     {
/* 433 */       return false;
/*     */     }
/* 435 */     if (par1EntityLiving instanceof Vortex)
/*     */     {
/* 437 */       return false;
/*     */     }
/* 439 */     if (par1EntityLiving instanceof Rotator)
/*     */     {
/* 441 */       return false;
/*     */     }
/* 443 */     if (par1EntityLiving instanceof DungeonBeast)
/*     */     {
/* 445 */       return false;
/*     */     }
/* 447 */     if (par1EntityLiving instanceof Peacock)
/*     */     {
/* 449 */       return false;
/*     */     }
/* 451 */     if (par1EntityLiving instanceof CrystalCow)
/*     */     {
/* 453 */       return false;
/*     */     }
/* 455 */     if (par1EntityLiving instanceof Irukandji)
/*     */     {
/* 457 */       return false;
/*     */     }
/* 459 */     if (par1EntityLiving instanceof Skate)
/*     */     {
/* 461 */       return false;
/*     */     }
/* 463 */     if (par1EntityLiving instanceof Whale)
/*     */     {
/* 465 */       return false;
/*     */     }
/* 467 */     if (par1EntityLiving instanceof Flounder)
/*     */     {
/* 469 */       return false;
/*     */     }
/* 471 */     if (par1EntityLiving instanceof Urchin)
/*     */     {
/* 473 */       return false;
/*     */     }
/* 475 */     if (par1EntityLiving instanceof TerribleTerror)
/*     */     {
/* 477 */       return false;
/*     */     }
/* 479 */     if (par1EntityLiving instanceof LurkingTerror)
/*     */     {
/* 481 */       return false;
/*     */     }
/* 483 */     if (par1EntityLiving instanceof CloudShark)
/*     */     {
/* 485 */       return false;
/*     */     }
/* 487 */     if (par1EntityLiving instanceof Mothra)
/*     */     {
/* 489 */       return false;
/*     */     }
/* 491 */     if (par1EntityLiving instanceof Bee)
/*     */     {
/* 493 */       return false;
/*     */     }
/* 495 */     if (par1EntityLiving instanceof Mantis)
/*     */     {
/* 497 */       return false;
/*     */     }
/*     */     
/* 500 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 505 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 506 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 10.0D, 12.0D));
/* 507 */     Collections.sort(var5, this.TargetSorter);
/* 508 */     Iterator<?> var2 = var5.iterator();
/* 509 */     Entity var3 = null;
/* 510 */     EntityLivingBase var4 = null;
/*     */     
/* 512 */     while (var2.hasNext()) {
/*     */       
/* 514 */       var3 = (Entity)var2.next();
/* 515 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 517 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 519 */         return var4;
/*     */       }
/*     */     } 
/* 522 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 531 */     int i = this.worldObj.rand.nextInt(4);
/* 532 */     if (i == 0) return OreSpawnMain.MyCrystalPinkIngot; 
/* 533 */     if (i == 1) return OreSpawnMain.MyTigersEyeIngot; 
/* 534 */     if (i == 2) return Item.getItemFromBlock(OreSpawnMain.CrystalCoal); 
/* 535 */     if (i == 3) return Items.iron_ingot; 
/* 536 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Rotator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */