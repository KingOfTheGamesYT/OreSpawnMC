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
/*     */ 
/*     */ public class CaveFisher
/*     */   extends EntityMob
/*     */ {
/*  56 */   private GenericTargetSorter TargetSorter = null;
/*  57 */   private RenderInfo renderdata = new RenderInfo();
/*  58 */   private float moveSpeed = 0.2F;
/*     */ 
/*     */ 
/*     */   
/*     */   public CaveFisher(World par1World) {
/*  63 */     super(par1World);
/*  64 */     setSize(1.35F, 0.75F);
/*  65 */     getNavigator().setAvoidsWater(false);
/*  66 */     this.experienceValue = 10;
/*  67 */     this.fireResistance = 10;
/*  68 */     this.isImmuneToFire = false;
/*  69 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  70 */     this.renderdata = new RenderInfo();
/*  71 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  72 */     this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0D));
/*  73 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  74 */     this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  75 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  80 */     super.applyEntityAttributes();
/*  81 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  82 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  83 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.CaveFisher_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  88 */     super.entityInit();
/*  89 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  90 */     if (this.renderdata == null) {
/*  91 */       this.renderdata = new RenderInfo();
/*     */     }
/*  93 */     this.renderdata.rf1 = 0.0F;
/*  94 */     this.renderdata.rf2 = 0.0F;
/*  95 */     this.renderdata.rf3 = 0.0F;
/*  96 */     this.renderdata.rf4 = 0.0F;
/*  97 */     this.renderdata.ri1 = 0;
/*  98 */     this.renderdata.ri2 = 0;
/*  99 */     this.renderdata.ri3 = 0;
/* 100 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 104 */     if (isNoDespawnRequired()) return false; 
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
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 120 */     return OreSpawnMain.CaveFisher_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 127 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 132 */     this.renderdata.rf1 = r.rf1;
/* 133 */     this.renderdata.rf2 = r.rf2;
/* 134 */     this.renderdata.rf3 = r.rf3;
/* 135 */     this.renderdata.rf4 = r.rf4;
/* 136 */     this.renderdata.ri1 = r.ri1;
/* 137 */     this.renderdata.ri2 = r.ri2;
/* 138 */     this.renderdata.ri3 = r.ri3;
/* 139 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 147 */     return OreSpawnMain.CaveFisher_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 155 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 164 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 173 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 181 */     return "orespawn:cryo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 189 */     return "orespawn:cryo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 196 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 203 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 212 */     int i = this.worldObj.rand.nextInt(6);
/* 213 */     if (i == 0) return Items.gold_nugget; 
/* 214 */     if (i == 1) return OreSpawnMain.UraniumNugget; 
/* 215 */     if (i == 2) return OreSpawnMain.TitaniumNugget; 
/* 216 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 224 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 229 */     return super.attackEntityAsMob(par1Entity);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 234 */     if (this.isDead)
/* 235 */       return;  super.updateAITasks();
/* 236 */     if (this.worldObj.rand.nextInt(8) == 0) {
/* 237 */       EntityLivingBase e = findSomethingToAttack();
/* 238 */       if (e != null) {
/* 239 */         if (getDistanceSqToEntity((Entity)e) < 8.0D) {
/* 240 */           setAttacking(1);
/*     */           
/* 242 */           if (this.worldObj.rand.nextInt(7) == 0 || this.worldObj.rand.nextInt(8) == 1)
/*     */           {
/* 244 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 247 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */         } 
/*     */       } else {
/* 250 */         setAttacking(0);
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
/* 261 */     boolean ret = false;
/* 262 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 263 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     }
/* 265 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 275 */     if (par1EntityLiving == null)
/*     */     {
/* 277 */       return false;
/*     */     }
/* 279 */     if (par1EntityLiving == this)
/*     */     {
/* 281 */       return false;
/*     */     }
/* 283 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 285 */       return false;
/*     */     }
/* 287 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false; 
/* 288 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 291 */       return false;
/*     */     }
/* 293 */     if (par1EntityLiving instanceof CaveFisher)
/*     */     {
/* 295 */       return false;
/*     */     }
/* 297 */     if (par1EntityLiving instanceof EnderReaper)
/*     */     {
/* 299 */       return false;
/*     */     }
/* 301 */     if (par1EntityLiving instanceof EnderKnight)
/*     */     {
/* 303 */       return false;
/*     */     }
/* 305 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 307 */       return false;
/*     */     }
/* 309 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 311 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 312 */       if (p.capabilities.isCreativeMode == true) {
/* 313 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 317 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 322 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 323 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0D, 3.0D, 10.0D));
/* 324 */     Collections.sort(var5, this.TargetSorter);
/* 325 */     Iterator<?> var2 = var5.iterator();
/* 326 */     Entity var3 = null;
/* 327 */     EntityLivingBase var4 = null;
/*     */     
/* 329 */     while (var2.hasNext()) {
/*     */       
/* 331 */       var3 = (Entity)var2.next();
/* 332 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 334 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 336 */         return var4;
/*     */       }
/*     */     } 
/* 339 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 345 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 350 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 360 */     int sc = 0;
/*     */     
/* 362 */     for (int k = -2; k < 2; k++) {
/*     */       
/* 364 */       for (int j = -2; j < 2; j++) {
/*     */         
/* 366 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 368 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 369 */           if (bid == Blocks.mob_spawner) {
/* 370 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 371 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 372 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 373 */             if (s != null && 
/* 374 */               s.equals("CaveFisher")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 380 */     if (!isValidLightLevel()) return false; 
/* 381 */     if (this.posY > 50.0D) return false; 
/* 382 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CaveFisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */