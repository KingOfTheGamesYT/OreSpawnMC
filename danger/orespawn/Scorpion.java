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
/*     */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
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
/*     */ public class Scorpion
/*     */   extends EntityMob
/*     */ {
/*  56 */   private GenericTargetSorter TargetSorter = null;
/*  57 */   private RenderInfo renderdata = new RenderInfo();
/*  58 */   private float moveSpeed = 0.2F;
/*     */   
/*     */   public Scorpion(World par1World) {
/*  61 */     super(par1World);
/*  62 */     setSize(0.85F, 0.55F);
/*  63 */     getNavigator().setAvoidsWater(true);
/*  64 */     this.experienceValue = 10;
/*  65 */     this.fireResistance = 100;
/*  66 */     this.isImmuneToFire = false;
/*  67 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  68 */     this.renderdata = new RenderInfo();
/*  69 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  70 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  71 */     this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0D));
/*  72 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  73 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  74 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  79 */     super.applyEntityAttributes();
/*  80 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  81 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  82 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Scorpion_stats.attack);
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
/* 104 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 112 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 113 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 118 */     return OreSpawnMain.Scorpion_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 125 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 130 */     this.renderdata.rf1 = r.rf1;
/* 131 */     this.renderdata.rf2 = r.rf2;
/* 132 */     this.renderdata.rf3 = r.rf3;
/* 133 */     this.renderdata.rf4 = r.rf4;
/* 134 */     this.renderdata.ri1 = r.ri1;
/* 135 */     this.renderdata.ri2 = r.ri2;
/* 136 */     this.renderdata.ri3 = r.ri3;
/* 137 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 145 */     return OreSpawnMain.Scorpion_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 153 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 162 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 171 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 179 */     return "orespawn:scorpion_hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 187 */     return "orespawn:cryo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 194 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 201 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 210 */     int i = this.worldObj.rand.nextInt(10);
/* 211 */     if (i == 0) return Items.gold_nugget; 
/* 212 */     if (i == 1) return OreSpawnMain.UraniumNugget; 
/* 213 */     if (i == 2) return OreSpawnMain.TitaniumNugget; 
/* 214 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 222 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 228 */     return super.attackEntityAsMob(par1Entity);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 233 */     if (this.isDead)
/* 234 */       return;  super.updateAITasks();
/* 235 */     if (this.worldObj.rand.nextInt(6) == 0) {
/* 236 */       EntityLivingBase e = findSomethingToAttack();
/* 237 */       if (e != null) {
/* 238 */         if (getDistanceSqToEntity((Entity)e) < 9.0D) {
/* 239 */           setAttacking(1);
/*     */           
/* 241 */           if (this.worldObj.rand.nextInt(5) == 0 || this.worldObj.rand.nextInt(6) == 1) {
/*     */             
/* 243 */             attackEntityAsMob((Entity)e);
/* 244 */             if (!this.worldObj.isRemote && 
/* 245 */               this.worldObj.rand.nextInt(3) == 1) {
/* 246 */               this.worldObj.playSoundAtEntity((Entity)e, "orespawn:scorpion_attack", 0.75F, 1.5F);
/*     */             }
/*     */           } 
/*     */         } else {
/*     */           
/* 251 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */         } 
/*     */       } else {
/* 254 */         setAttacking(0);
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
/* 265 */     boolean ret = false;
/* 266 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 267 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     }
/* 269 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 279 */     if (par1EntityLiving == null)
/*     */     {
/* 281 */       return false;
/*     */     }
/* 283 */     if (par1EntityLiving == this)
/*     */     {
/* 285 */       return false;
/*     */     }
/* 287 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 289 */       return false;
/*     */     }
/*     */     
/* 292 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 294 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 297 */       return false;
/*     */     }
/*     */     
/* 300 */     if (par1EntityLiving instanceof Ghost)
/*     */     {
/* 302 */       return false;
/*     */     }
/* 304 */     if (par1EntityLiving instanceof GhostSkelly)
/*     */     {
/* 306 */       return false;
/*     */     }
/*     */     
/* 309 */     if (par1EntityLiving instanceof VelocityRaptor)
/*     */     {
/* 311 */       return true;
/*     */     }
/* 313 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntitySpider)
/*     */     {
/* 315 */       return true;
/*     */     }
/* 317 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCaveSpider)
/*     */     {
/* 319 */       return true;
/*     */     }
/* 321 */     if (par1EntityLiving instanceof Scorpion)
/*     */     {
/* 323 */       return false;
/*     */     }
/* 325 */     if (par1EntityLiving instanceof EmperorScorpion)
/*     */     {
/* 327 */       return false;
/*     */     }
/* 329 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCreeper)
/*     */     {
/* 331 */       return true;
/*     */     }
/* 333 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 335 */       return false;
/*     */     }
/* 337 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 339 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 340 */       if (p.capabilities.isCreativeMode == true) {
/* 341 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 345 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 350 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 351 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(8.0D, 3.0D, 8.0D));
/* 352 */     Collections.sort(var5, this.TargetSorter);
/* 353 */     Iterator<?> var2 = var5.iterator();
/* 354 */     Entity var3 = null;
/* 355 */     EntityLivingBase var4 = null;
/*     */     
/* 357 */     while (var2.hasNext()) {
/*     */       
/* 359 */       var3 = (Entity)var2.next();
/* 360 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 362 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 364 */         return var4;
/*     */       }
/*     */     } 
/* 367 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 373 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 378 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
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
/* 389 */     for (int k = -3; k < 3; k++) {
/*     */       
/* 391 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 393 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 395 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 396 */           if (bid == Blocks.mob_spawner) {
/* 397 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 398 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 399 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 400 */             if (s != null && 
/* 401 */               s.equals("Scorpion")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 409 */     if (!isValidLightLevel()) return false; 
/* 410 */     if (this.worldObj.isDaytime() == true && this.posY > 50.0D) return false;
/*     */     
/* 412 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Scorpion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */