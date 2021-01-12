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
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
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
/*     */ public class Nastysaurus
/*     */   extends EntityMob
/*     */ {
/*  51 */   private GenericTargetSorter TargetSorter = null;
/*  52 */   private float moveSpeed = 0.35F;
/*  53 */   private RenderInfo renderdata = new RenderInfo();
/*  54 */   private EntityLivingBase rt = null;
/*     */ 
/*     */   
/*     */   public Nastysaurus(World par1World) {
/*  58 */     super(par1World);
/*  59 */     setSize(2.2F, 4.6F);
/*  60 */     getNavigator().setAvoidsWater(true);
/*  61 */     this.experienceValue = 40;
/*  62 */     this.fireResistance = 100;
/*  63 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  64 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  65 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  66 */     this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  67 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  68 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  69 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  74 */     super.applyEntityAttributes();
/*  75 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  76 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  77 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Nastysaurus_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  82 */     super.entityInit();
/*  83 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  84 */     if (this.renderdata == null) {
/*  85 */       this.renderdata = new RenderInfo();
/*     */     }
/*  87 */     this.renderdata.rf1 = 0.0F;
/*  88 */     this.renderdata.rf2 = 0.0F;
/*  89 */     this.renderdata.rf3 = 0.0F;
/*  90 */     this.renderdata.rf4 = 0.0F;
/*  91 */     this.renderdata.ri1 = 0;
/*  92 */     this.renderdata.ri2 = 0;
/*  93 */     this.renderdata.ri3 = 0;
/*  94 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 101 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 106 */     this.renderdata.rf1 = r.rf1;
/* 107 */     this.renderdata.rf2 = r.rf2;
/* 108 */     this.renderdata.rf3 = r.rf3;
/* 109 */     this.renderdata.rf4 = r.rf4;
/* 110 */     this.renderdata.ri1 = r.ri1;
/* 111 */     this.renderdata.ri2 = r.ri2;
/* 112 */     this.renderdata.ri3 = r.ri3;
/* 113 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 117 */     if (isNoDespawnRequired()) return false; 
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 126 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 127 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 132 */     return OreSpawnMain.Nastysaurus_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 140 */     return OreSpawnMain.Nastysaurus_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 148 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 157 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 166 */     if (this.rand.nextInt(4) == 0) {
/* 167 */       return "orespawn:alo_living";
/*     */     }
/* 169 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 178 */     return "orespawn:alo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 186 */     return "orespawn:alo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 193 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 200 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 210 */     return Items.beef;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 215 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 3.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/*     */     
/* 217 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 224 */     for (var4 = 0; var4 < 10; var4++) {
/* 225 */       dropItemRand(Items.iron_ingot, 1);
/*     */     }
/* 227 */     for (var4 = 0; var4 < 10; var4++) {
/* 228 */       dropItemRand(Items.rotten_flesh, 1);
/*     */     }
/* 230 */     for (var4 = 0; var4 < 10; var4++) {
/* 231 */       dropItemRand(Items.leather, 1);
/*     */     }
/* 233 */     for (var4 = 0; var4 < 10; var4++) {
/* 234 */       dropItemRand(Items.string, 1);
/*     */     }
/*     */   }
/*     */ 
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
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 251 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 258 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 260 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 262 */         double ks = 1.2D;
/* 263 */         double inair = 0.1D;
/* 264 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 265 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 266 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 268 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 272 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 281 */     boolean ret = false;
/*     */     
/* 283 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*     */       
/* 285 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 286 */       Entity e = par1DamageSource.getEntity();
/*     */       
/* 288 */       if (e != null && e instanceof EntityLivingBase) {
/* 289 */         this.rt = (EntityLivingBase)e;
/*     */       }
/*     */     } 
/* 292 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 297 */     if (this.isDead)
/* 298 */       return;  super.updateAITasks();
/* 299 */     if (this.worldObj.rand.nextInt(5) == 0) {
/* 300 */       EntityLivingBase e = null;
/* 301 */       e = this.rt;
/* 302 */       if (OreSpawnMain.PlayNicely != 0) e = null; 
/* 303 */       if (e != null) {
/* 304 */         if (e.isDead || this.worldObj.rand.nextInt(250) == 1) {
/* 305 */           e = null;
/* 306 */           this.rt = null;
/*     */         } 
/* 308 */         if (e != null && 
/* 309 */           !getEntitySenses().canSee((Entity)e)) {
/* 310 */           e = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 315 */       if (e == null) {
/* 316 */         e = findSomethingToAttack();
/*     */       }
/* 318 */       if (e != null) {
/* 319 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 320 */         if (getDistanceSqToEntity((Entity)e) < ((4.5F + e.width / 2.0F) * (4.5F + e.width / 2.0F))) {
/* 321 */           setAttacking(1);
/*     */           
/* 323 */           if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1)
/*     */           {
/* 325 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 328 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 331 */         setAttacking(0);
/*     */       } 
/*     */     } 
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
/* 344 */     if (par1EntityLiving == null)
/*     */     {
/* 346 */       return false;
/*     */     }
/* 348 */     if (par1EntityLiving == this)
/*     */     {
/* 350 */       return false;
/*     */     }
/* 352 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 354 */       return false;
/*     */     }
/*     */     
/* 357 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 359 */     if (par1EntityLiving instanceof Nastysaurus)
/*     */     {
/* 361 */       return false;
/*     */     }
/*     */     
/* 364 */     if (par1EntityLiving instanceof Cryolophosaurus)
/*     */     {
/* 366 */       return false;
/*     */     }
/*     */     
/* 369 */     if (par1EntityLiving instanceof VelocityRaptor)
/*     */     {
/* 371 */       return false;
/*     */     }
/*     */     
/* 374 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 377 */       return false;
/*     */     }
/*     */     
/* 380 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 382 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 383 */       if (p.capabilities.isCreativeMode == true) {
/* 384 */         return false;
/*     */       }
/* 386 */       return true;
/*     */     } 
/*     */     
/* 389 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 394 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 395 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(32.0D, 8.0D, 32.0D));
/* 396 */     Collections.sort(var5, this.TargetSorter);
/* 397 */     Iterator<?> var2 = var5.iterator();
/* 398 */     Entity var3 = null;
/* 399 */     EntityLivingBase var4 = null;
/*     */     
/* 401 */     while (var2.hasNext()) {
/*     */       
/* 403 */       var3 = (Entity)var2.next();
/* 404 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 406 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 408 */         return var4;
/*     */       }
/*     */     } 
/* 411 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAttacking() {
/* 416 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAttacking(int par1) {
/* 421 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
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
/*     */     int k;
/* 433 */     for (k = -3; k < 3; k++) {
/*     */       
/* 435 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 437 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 439 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 440 */           if (bid == Blocks.mob_spawner) {
/* 441 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 442 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 443 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 444 */             if (s != null && 
/* 445 */               s.equals("Nastysaurus")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 451 */     if (!isValidLightLevel()) return false; 
/* 452 */     if (this.posY < 50.0D) return false; 
/* 453 */     if (this.worldObj.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 457 */     for (k = -1; k < 1; k++) {
/*     */       
/* 459 */       for (int j = -1; j < 1; j++) {
/*     */         
/* 461 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 463 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 464 */           if (bid != Blocks.air) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 470 */     Nastysaurus target = null;
/* 471 */     target = (Nastysaurus)this.worldObj.findNearestEntityWithinAABB(Nastysaurus.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D), (Entity)this);
/* 472 */     if (target != null)
/*     */     {
/* 474 */       return false;
/*     */     }
/* 476 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Nastysaurus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */