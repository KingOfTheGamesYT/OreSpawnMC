/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.DamageSource;
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
/*     */ public class Urchin
/*     */   extends EntityMob
/*     */ {
/*  54 */   private GenericTargetSorter TargetSorter = null;
/*  55 */   private RenderInfo renderdata = new RenderInfo();
/*  56 */   private float moveSpeed = 0.3F;
/*  57 */   private int was_spawnered = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public Urchin(World par1World) {
/*  62 */     super(par1World);
/*  63 */     setSize(1.35F, 2.1F);
/*  64 */     getNavigator().setAvoidsWater(true);
/*  65 */     this.experienceValue = 20;
/*  66 */     this.fireResistance = 1000;
/*  67 */     this.isImmuneToFire = true;
/*  68 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  69 */     this.renderdata = new RenderInfo();
/*  70 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  71 */     this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0D));
/*  72 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  73 */     this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  74 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  79 */     super.applyEntityAttributes();
/*  80 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  81 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  82 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Urchin_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  87 */     super.entityInit();
/*  88 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  89 */     if (this.renderdata == null) {
/*  90 */       this.renderdata = new RenderInfo();
/*     */     }
/*  92 */     this.renderdata.rf1 = 0.0F;
/*  93 */     this.renderdata.rf2 = 0.0F;
/*  94 */     this.renderdata.rf3 = 0.0F;
/*  95 */     this.renderdata.rf4 = 0.0F;
/*  96 */     this.renderdata.ri1 = 0;
/*  97 */     this.renderdata.ri2 = 0;
/*  98 */     this.renderdata.ri3 = 0;
/*  99 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 103 */     if (isNoDespawnRequired()) return false; 
/* 104 */     if (this.was_spawnered != 0) return false; 
/* 105 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 114 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 115 */     super.onUpdate();
/*     */     
/* 117 */     if (isNoDespawnRequired())
/* 118 */       return;  if (this.was_spawnered != 0)
/* 119 */       return;  long t = this.worldObj.getWorldTime();
/* 120 */     t %= 24000L;
/* 121 */     if (t < 12000L && this.worldObj.rand.nextInt(400) == 1) setDead();
/*     */   
/*     */   }
/*     */   
/*     */   public int mygetMaxHealth() {
/* 126 */     return OreSpawnMain.Urchin_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 133 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 138 */     this.renderdata.rf1 = r.rf1;
/* 139 */     this.renderdata.rf2 = r.rf2;
/* 140 */     this.renderdata.rf3 = r.rf3;
/* 141 */     this.renderdata.rf4 = r.rf4;
/* 142 */     this.renderdata.ri1 = r.ri1;
/* 143 */     this.renderdata.ri2 = r.ri2;
/* 144 */     this.renderdata.ri3 = r.ri3;
/* 145 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 153 */     return OreSpawnMain.Urchin_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 161 */     return true;
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
/*     */   
/*     */   public void onLivingUpdate() {
/* 174 */     super.onLivingUpdate();
/* 175 */     if (this.worldObj.rand.nextInt(3) == 1) {
/* 176 */       this.worldObj.spawnParticle("flame", this.posX, this.posY + 0.75D, this.posZ, 0.0D, (this.worldObj.rand.nextFloat() / 10.0F), 0.0D);
/* 177 */       if (isInWater() && this.worldObj.rand.nextInt(5) == 1) {
/* 178 */         attackEntityAsMob((Entity)this);
/* 179 */         this.worldObj.spawnParticle("smoke", this.posX, this.posY + 1.75D, this.posZ, 0.0D, (this.worldObj.rand.nextFloat() / 10.0F), 0.0D);
/* 180 */         this.worldObj.spawnParticle("largesmoke", this.posX, this.posY + 1.75D, this.posZ, 0.0D, (this.worldObj.rand.nextFloat() / 10.0F), 0.0D);
/* 181 */         this.worldObj.spawnParticle("smoke", this.posX, this.posY + 2.0D, this.posZ, 0.0D, (this.worldObj.rand.nextFloat() / 10.0F), 0.0D);
/* 182 */         this.worldObj.spawnParticle("largesmoke", this.posX, this.posY + 2.0D, this.posZ, 0.0D, (this.worldObj.rand.nextFloat() / 10.0F), 0.0D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 193 */     return "orespawn:kyuubi_living";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 201 */     return "orespawn:glasshit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 209 */     return "orespawn:glassdead";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 216 */     return 1.1F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 223 */     return 1.25F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 232 */     int i = this.worldObj.rand.nextInt(3);
/* 233 */     if (i == 1) return OreSpawnMain.MyCrystalPinkIngot; 
/* 234 */     if (i == 2) return OreSpawnMain.MyCrystalApple; 
/* 235 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 243 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 248 */     par1Entity.setFire(5);
/* 249 */     return super.attackEntityAsMob(par1Entity);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 254 */     if (this.isDead)
/* 255 */       return;  super.updateAITasks();
/* 256 */     if (this.worldObj.rand.nextInt(8) == 0) {
/* 257 */       EntityLivingBase e = findSomethingToAttack();
/* 258 */       if (e != null) {
/* 259 */         if (getDistanceSqToEntity((Entity)e) < 8.0D) {
/* 260 */           setAttacking(1);
/*     */           
/* 262 */           if (this.worldObj.rand.nextInt(7) == 0 || this.worldObj.rand.nextInt(8) == 1)
/*     */           {
/* 264 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 267 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */         } 
/*     */       } else {
/* 270 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 281 */     boolean ret = false;
/* 282 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 283 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     }
/* 285 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 295 */     if (par1EntityLiving == null)
/*     */     {
/* 297 */       return false;
/*     */     }
/* 299 */     if (par1EntityLiving == this)
/*     */     {
/* 301 */       return false;
/*     */     }
/* 303 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 305 */       return false;
/*     */     }
/*     */     
/* 308 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 310 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 313 */       return false;
/*     */     }
/*     */     
/* 316 */     if (par1EntityLiving instanceof Vortex)
/*     */     {
/* 318 */       return false;
/*     */     }
/* 320 */     if (par1EntityLiving instanceof Rotator)
/*     */     {
/* 322 */       return false;
/*     */     }
/* 324 */     if (par1EntityLiving instanceof Peacock)
/*     */     {
/* 326 */       return false;
/*     */     }
/* 328 */     if (par1EntityLiving instanceof CrystalCow)
/*     */     {
/* 330 */       return false;
/*     */     }
/* 332 */     if (par1EntityLiving instanceof Irukandji)
/*     */     {
/* 334 */       return false;
/*     */     }
/* 336 */     if (par1EntityLiving instanceof Skate)
/*     */     {
/* 338 */       return false;
/*     */     }
/* 340 */     if (par1EntityLiving instanceof Whale)
/*     */     {
/* 342 */       return false;
/*     */     }
/* 344 */     if (par1EntityLiving instanceof Flounder)
/*     */     {
/* 346 */       return false;
/*     */     }
/* 348 */     if (par1EntityLiving instanceof Urchin)
/*     */     {
/* 350 */       return false;
/*     */     }
/* 352 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 354 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 355 */       if (p.capabilities.isCreativeMode == true) {
/* 356 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 360 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 365 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 366 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0D, 3.0D, 16.0D));
/* 367 */     Collections.sort(var5, this.TargetSorter);
/* 368 */     Iterator<?> var2 = var5.iterator();
/* 369 */     Entity var3 = null;
/* 370 */     EntityLivingBase var4 = null;
/*     */     
/* 372 */     while (var2.hasNext()) {
/*     */       
/* 374 */       var3 = (Entity)var2.next();
/* 375 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 377 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 379 */         return var4;
/*     */       }
/*     */     } 
/* 382 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 388 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 393 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 403 */     int sc = 0;
/*     */     int k;
/* 405 */     for (k = -2; k <= 2; k++) {
/*     */       
/* 407 */       for (int j = -2; j <= 2; j++) {
/*     */         
/* 409 */         for (int i = 1; i < 4; i++) {
/*     */           
/* 411 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 412 */           if (bid == Blocks.mob_spawner) {
/* 413 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 414 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 415 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 416 */             if (s != null && 
/* 417 */               s.equals("Crystal Urchin")) {
/* 418 */               this.was_spawnered = 1;
/* 419 */               return true;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 427 */     for (k = -1; k <= 1; k++) {
/*     */       
/* 429 */       for (int j = -1; j <= 1; j++) {
/*     */         
/* 431 */         Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + 1, (int)this.posZ + k);
/* 432 */         if (bid == Blocks.air) sc++; 
/*     */       } 
/*     */     } 
/* 435 */     if (sc < 6) return false; 
/* 436 */     if (!isValidLightLevel()) return false; 
/* 437 */     long t = this.worldObj.getWorldTime();
/* 438 */     t %= 24000L;
/* 439 */     if (t < 13000L) return false;
/*     */     
/* 441 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Urchin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */