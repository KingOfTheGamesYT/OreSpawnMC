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
/*     */ public class DungeonBeast
/*     */   extends EntityMob
/*     */ {
/*  54 */   private GenericTargetSorter TargetSorter = null;
/*  55 */   private RenderInfo renderdata = new RenderInfo();
/*  56 */   private float moveSpeed = 0.29F;
/*     */ 
/*     */ 
/*     */   
/*     */   public DungeonBeast(World par1World) {
/*  61 */     super(par1World);
/*  62 */     setSize(1.15F, 1.1F);
/*  63 */     getNavigator().setAvoidsWater(true);
/*  64 */     this.experienceValue = 60;
/*  65 */     this.fireResistance = 10;
/*  66 */     this.isImmuneToFire = false;
/*  67 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  68 */     this.renderdata = new RenderInfo();
/*  69 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  70 */     this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0D));
/*  71 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  72 */     this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  73 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  78 */     super.applyEntityAttributes();
/*  79 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  80 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  81 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.DungeonBeast_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  86 */     super.entityInit();
/*  87 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  88 */     if (this.renderdata == null) {
/*  89 */       this.renderdata = new RenderInfo();
/*     */     }
/*  91 */     this.renderdata.rf1 = 0.0F;
/*  92 */     this.renderdata.rf2 = 0.0F;
/*  93 */     this.renderdata.rf3 = 0.0F;
/*  94 */     this.renderdata.rf4 = 0.0F;
/*  95 */     this.renderdata.ri1 = 0;
/*  96 */     this.renderdata.ri2 = 0;
/*  97 */     this.renderdata.ri3 = 0;
/*  98 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 102 */     if (isNoDespawnRequired()) return false; 
/* 103 */     return true;
/*     */   }
/*     */ 
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
/* 118 */     return OreSpawnMain.DungeonBeast_stats.health;
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
/* 145 */     return OreSpawnMain.DungeonBeast_stats.defense;
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
/* 179 */     return "orespawn:dbhit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 187 */     return "orespawn:dbdead";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 194 */     return 0.8F;
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
/* 210 */     int i = this.worldObj.rand.nextInt(4);
/* 211 */     if (i == 1) return OreSpawnMain.MyCrystalPinkIngot; 
/* 212 */     if (i == 2) return OreSpawnMain.MyCrystalApple; 
/* 213 */     if (i == 3) return Item.getItemFromBlock(Blocks.log); 
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
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 227 */     return super.attackEntityAsMob(par1Entity);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 232 */     if (this.isDead)
/* 233 */       return;  super.updateAITasks();
/* 234 */     if (this.worldObj.rand.nextInt(8) == 0) {
/* 235 */       EntityLivingBase e = findSomethingToAttack();
/* 236 */       if (e != null) {
/* 237 */         if (getDistanceSqToEntity((Entity)e) < 8.0D) {
/* 238 */           setAttacking(1);
/*     */           
/* 240 */           if (this.worldObj.rand.nextInt(7) == 0 || this.worldObj.rand.nextInt(8) == 1)
/*     */           {
/* 242 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 245 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */         } 
/*     */       } else {
/* 248 */         setAttacking(0);
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
/* 259 */     boolean ret = false;
/* 260 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/* 261 */       return ret;
/*     */     }
/* 263 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 264 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     }
/* 266 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 276 */     if (par1EntityLiving == null)
/*     */     {
/* 278 */       return false;
/*     */     }
/* 280 */     if (par1EntityLiving == this)
/*     */     {
/* 282 */       return false;
/*     */     }
/* 284 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 286 */       return false;
/*     */     }
/* 288 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 290 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 293 */       return false;
/*     */     }
/*     */     
/* 296 */     if (par1EntityLiving instanceof Rat)
/*     */     {
/* 298 */       return false;
/*     */     }
/* 300 */     if (par1EntityLiving instanceof DungeonBeast)
/*     */     {
/* 302 */       return false;
/*     */     }
/* 304 */     if (par1EntityLiving instanceof Rotator)
/*     */     {
/* 306 */       return false;
/*     */     }
/* 308 */     if (par1EntityLiving instanceof Peacock)
/*     */     {
/* 310 */       return false;
/*     */     }
/* 312 */     if (par1EntityLiving instanceof Irukandji)
/*     */     {
/* 314 */       return false;
/*     */     }
/* 316 */     if (par1EntityLiving instanceof Skate)
/*     */     {
/* 318 */       return false;
/*     */     }
/* 320 */     if (par1EntityLiving instanceof Whale)
/*     */     {
/* 322 */       return false;
/*     */     }
/* 324 */     if (par1EntityLiving instanceof Flounder)
/*     */     {
/* 326 */       return false;
/*     */     }
/*     */     
/* 329 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 331 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 332 */       if (p.capabilities.isCreativeMode == true) {
/* 333 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 337 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 342 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 343 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0D, 3.0D, 16.0D));
/* 344 */     Collections.sort(var5, this.TargetSorter);
/* 345 */     Iterator<?> var2 = var5.iterator();
/* 346 */     Entity var3 = null;
/* 347 */     EntityLivingBase var4 = null;
/*     */     
/* 349 */     while (var2.hasNext()) {
/*     */       
/* 351 */       var3 = (Entity)var2.next();
/* 352 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 354 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 356 */         return var4;
/*     */       }
/*     */     } 
/* 359 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 365 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 370 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
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
/* 381 */     int sc = 0;
/*     */     int k;
/* 383 */     for (k = -3; k < 3; k++) {
/*     */       
/* 385 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 387 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 389 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 390 */           if (bid == Blocks.mob_spawner) {
/* 391 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 392 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 393 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 394 */             if (s != null && 
/* 395 */               s.equals("Dungeon Beast")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 403 */     if (!isValidLightLevel()) return false; 
/* 404 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID5) {
/* 405 */       if (this.posY > 28.0D || this.posY < 25.0D) return false;
/*     */       
/* 407 */       for (k = -1; k <= 1; k++) {
/*     */         
/* 409 */         for (int j = -1; j <= 1; j++) {
/*     */           
/* 411 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + 1, (int)this.posZ + k);
/* 412 */           if (bid == Blocks.air) sc++; 
/*     */         } 
/*     */       } 
/* 415 */       if (sc < 6) return false;
/*     */     
/*     */     } 
/* 418 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\DungeonBeast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */