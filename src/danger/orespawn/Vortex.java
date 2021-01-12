/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
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
/*     */ public class Vortex
/*     */   extends EntityMob
/*     */ {
/*  54 */   private ChunkCoordinates currentFlightTarget = null;
/*  55 */   private GenericTargetSorter TargetSorter = null;
/*  56 */   private int winded = 0;
/*  57 */   private int busy_fighting = 0;
/*  58 */   private int was_spawnered = 0;
/*     */   
/*     */   public Vortex(World par1World) {
/*  61 */     super(par1World);
/*  62 */     setSize(2.0F, 4.0F);
/*  63 */     this.experienceValue = 200;
/*  64 */     this.isImmuneToFire = true;
/*  65 */     this.fireResistance = 250;
/*  66 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  71 */     super.applyEntityAttributes();
/*  72 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  73 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3499999940395355D);
/*  74 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Vortex_stats.attack);
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  78 */     if (isNoDespawnRequired()) return false; 
/*  79 */     if (this.busy_fighting != 0) return false; 
/*  80 */     if (this.was_spawnered != 0) return false; 
/*  81 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  88 */     return 0.75F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  95 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 102 */     return "orespawn:vortexlive";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 109 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 116 */     return "orespawn:vortexlive";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 123 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 130 */     return OreSpawnMain.Vortex_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 137 */     return true;
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
/*     */   public void onUpdate() {
/* 149 */     EntityLivingBase e = null;
/* 150 */     super.onUpdate();
/*     */     
/* 152 */     this.motionY *= 0.6D;
/* 153 */     this.busy_fighting = 0;
/* 154 */     e = findSomethingToAttack();
/* 155 */     if (e != null) {
/*     */       
/* 157 */       this.busy_fighting = 1;
/* 158 */       if (this.worldObj.isRemote)
/*     */       {
/*     */ 
/*     */         
/* 162 */         for (int i = 0; i < 20; i++) {
/* 163 */           double d = this.worldObj.rand.nextDouble() * 3.5D;
/* 164 */           d *= d;
/* 165 */           double dir = this.worldObj.rand.nextDouble() * 2.0D * Math.PI;
/* 166 */           dir -= Math.PI;
/* 167 */           double dx = Math.cos(dir) * d / 2.0D;
/* 168 */           double dz = Math.sin(dir) * d / 2.0D;
/* 169 */           dir += 1.5707963267948966D;
/* 170 */           this.worldObj.spawnParticle("smoke", this.posX + dx, this.posY + 0.75D + d, this.posZ + dz, Math.cos(dir) * this.worldObj.rand.nextFloat() / 4.0D, (this.worldObj.rand.nextFloat() / 2.0F), Math.sin(dir) * this.worldObj.rand.nextFloat() / 4.0D);
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 178 */     if (this.worldObj.rand.nextInt(200) == 1) heal(1.0F);
/*     */     
/* 180 */     if (isNoDespawnRequired())
/* 181 */       return;  if (this.busy_fighting != 0)
/* 182 */       return;  if (this.was_spawnered != 0)
/* 183 */       return;  long t = this.worldObj.getWorldTime();
/* 184 */     t %= 24000L;
/* 185 */     if (t < 12000L && this.worldObj.rand.nextInt(500) == 1) setDead();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 194 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 201 */     int xdir = 1;
/* 202 */     int zdir = 1;
/*     */     
/* 204 */     int keep_trying = 50;
/*     */ 
/*     */     
/* 207 */     EntityLivingBase e = null;
/*     */ 
/*     */     
/* 210 */     if (this.isDead)
/* 211 */       return;  super.updateAITasks();
/*     */     
/* 213 */     if (this.currentFlightTarget == null) {
/* 214 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */     
/* 217 */     if (this.winded > 0) this.winded--;
/*     */     
/* 219 */     if (this.rand.nextInt(300) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*     */       
/* 221 */       Block bid = Blocks.stone;
/* 222 */       while (bid != Blocks.air && keep_trying != 0) {
/* 223 */         zdir = this.rand.nextInt(14) + 10;
/* 224 */         xdir = this.rand.nextInt(14) + 10;
/* 225 */         if (this.rand.nextInt(2) == 0) zdir = -zdir; 
/* 226 */         if (this.rand.nextInt(2) == 0) xdir = -xdir; 
/* 227 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(6) - 3, (int)this.posZ + zdir);
/* 228 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 229 */         if (bid == Blocks.air && 
/* 230 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 231 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 234 */         keep_trying--;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 240 */     e = findSomethingToAttack();
/* 241 */     if (e != null) {
/*     */       
/* 243 */       this.currentFlightTarget.set((int)e.posX, (int)e.posY, (int)e.posZ);
/*     */       
/* 245 */       double d = getDistanceSqToEntity((Entity)e);
/* 246 */       if (d < 81.0D && this.winded == 0) {
/* 247 */         double a = Math.atan2(this.posZ - e.posZ, this.posX - e.posX);
/* 248 */         double pm = 1.0D;
/* 249 */         if (e instanceof EntityPlayer) pm = 2.0D; 
/* 250 */         e.addVelocity(Math.cos(a) * (10.0D - Math.sqrt(d)) * 0.10000000149011612D, (10.0D - Math.sqrt(d)) * 0.05000000074505806D * pm, Math.sin(a) * (10.0D - Math.sqrt(d)) * 0.10000000149011612D);
/*     */       } 
/* 252 */       if (getDistanceSqToEntity((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F)) && this.rand.nextInt(8) == 2) {
/* 253 */         attackEntityAsMob((Entity)e);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 258 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 259 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 260 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 261 */     this.motionX += (Math.signum(var1) * 0.4D - this.motionX) * 0.2D;
/* 262 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.20000000149011612D;
/* 263 */     this.motionZ += (Math.signum(var5) * 0.4D - this.motionZ) * 0.2D;
/* 264 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 265 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 266 */     this.moveForward = 0.75F;
/* 267 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 276 */     return true;
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
/* 294 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 302 */     boolean ret = false;
/* 303 */     Entity e = par1DamageSource.getEntity();
/* 304 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/* 305 */     if (e != null && this.currentFlightTarget != null)
/*     */     {
/* 307 */       this.currentFlightTarget.set((int)e.posX, (int)e.posY, (int)e.posZ);
/*     */     }
/* 309 */     this.winded = 20;
/* 310 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 319 */     return OreSpawnMain.Vortex_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/*     */     int k;
/* 329 */     for (k = -3; k < 3; k++) {
/*     */       
/* 331 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 333 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 335 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 336 */           if (bid == Blocks.mob_spawner) {
/* 337 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 338 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 339 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 340 */             if (s != null && 
/* 341 */               s.equals("Vortex")) {
/* 342 */               this.was_spawnered = 1;
/* 343 */               return true;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 352 */     for (k = -2; k <= 2; k++) {
/*     */       
/* 354 */       for (int j = -2; j <= 2; j++) {
/*     */         
/* 356 */         for (int i = 1; i < 4; i++) {
/*     */           
/* 358 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 359 */           if (bid != Blocks.air) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 363 */     if (!isValidLightLevel()) return false; 
/* 364 */     if (this.posY < 50.0D) return false; 
/* 365 */     long t = this.worldObj.getWorldTime();
/* 366 */     t %= 24000L;
/* 367 */     if (t < 12000L) return false; 
/* 368 */     if (this.worldObj.rand.nextInt(2) != 1) return false; 
/* 369 */     Vortex target = null;
/* 370 */     target = (Vortex)this.worldObj.findNearestEntityWithinAABB(Vortex.class, this.boundingBox.expand(20.0D, 16.0D, 20.0D), (Entity)this);
/* 371 */     if (target != null)
/*     */     {
/* 373 */       return false;
/*     */     }
/*     */     
/* 376 */     return true;
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
/* 388 */     if (par1EntityLiving == null)
/*     */     {
/* 390 */       return false;
/*     */     }
/* 392 */     if (par1EntityLiving == this)
/*     */     {
/* 394 */       return false;
/*     */     }
/* 396 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 399 */       return false;
/*     */     }
/*     */     
/* 402 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 404 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 407 */       return false;
/*     */     }
/*     */     
/* 410 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 412 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 413 */       if (p.capabilities.isCreativeMode == true) {
/* 414 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 418 */     if (par1EntityLiving instanceof Vortex)
/*     */     {
/* 420 */       return false;
/*     */     }
/* 422 */     if (par1EntityLiving instanceof Rotator)
/*     */     {
/* 424 */       return false;
/*     */     }
/* 426 */     if (par1EntityLiving instanceof Mothra)
/*     */     {
/* 428 */       return false;
/*     */     }
/* 430 */     if (par1EntityLiving instanceof Brutalfly)
/*     */     {
/* 432 */       return false;
/*     */     }
/* 434 */     if (par1EntityLiving instanceof Peacock)
/*     */     {
/* 436 */       return false;
/*     */     }
/* 438 */     if (par1EntityLiving instanceof CrystalCow)
/*     */     {
/* 440 */       return false;
/*     */     }
/* 442 */     if (par1EntityLiving instanceof Irukandji)
/*     */     {
/* 444 */       return false;
/*     */     }
/* 446 */     if (par1EntityLiving instanceof Skate)
/*     */     {
/* 448 */       return false;
/*     */     }
/* 450 */     if (par1EntityLiving instanceof Whale)
/*     */     {
/* 452 */       return false;
/*     */     }
/* 454 */     if (par1EntityLiving instanceof Flounder)
/*     */     {
/* 456 */       return false;
/*     */     }
/* 458 */     if (par1EntityLiving instanceof Urchin)
/*     */     {
/* 460 */       return false;
/*     */     }
/*     */     
/* 463 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 468 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 469 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0D, 10.0D, 16.0D));
/* 470 */     Collections.sort(var5, this.TargetSorter);
/* 471 */     Iterator<?> var2 = var5.iterator();
/* 472 */     Entity var3 = null;
/* 473 */     EntityLivingBase var4 = null;
/*     */     
/* 475 */     while (var2.hasNext()) {
/*     */       
/* 477 */       var3 = (Entity)var2.next();
/* 478 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 480 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 482 */         return var4;
/*     */       }
/*     */     } 
/* 485 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 490 */     EntityItem var3 = null;
/* 491 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 493 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(6) - OreSpawnMain.OreSpawnRand.nextInt(6), this.posY + 1.0D + this.worldObj.rand.nextInt(10), this.posZ + OreSpawnMain.OreSpawnRand.nextInt(6) - OreSpawnMain.OreSpawnRand.nextInt(6), is);
/*     */     
/* 495 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 496 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 503 */     dropItemRand(OreSpawnMain.VortexEye, 1);
/* 504 */     dropItemRand(Items.item_frame, 1);
/*     */     
/* 506 */     int i = 5 + this.worldObj.rand.nextInt(7);
/* 507 */     for (int var4 = 0; var4 < i; var4++) {
/* 508 */       int var3 = this.worldObj.rand.nextInt(10);
/* 509 */       if (var3 == 0) dropItemRand(Items.stick, 1); 
/* 510 */       if (var3 == 1) dropItemRand(OreSpawnMain.MyTigersEyeIngot, 1); 
/* 511 */       if (var3 == 2) dropItemRand(OreSpawnMain.MyCrystalPinkIngot, 1); 
/* 512 */       if (var3 == 3) dropItemRand(Items.iron_ingot, 1); 
/* 513 */       if (var3 == 4) dropItemRand(OreSpawnMain.UraniumNugget, 1); 
/* 514 */       if (var3 == 6) dropItemRand(OreSpawnMain.TitaniumNugget, 1); 
/* 515 */       if (var3 == 7) dropItemRand(OreSpawnMain.MyIrukandji, 1); 
/* 516 */       if (var3 == 8) dropItemRand(Item.getItemFromBlock(OreSpawnMain.CrystalCoal), 1);
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 526 */     return OreSpawnMain.FairyEgg;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Vortex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */