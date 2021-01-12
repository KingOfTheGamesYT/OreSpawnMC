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
/*     */ public class Pointysaurus
/*     */   extends EntityMob
/*     */ {
/*  51 */   private GenericTargetSorter TargetSorter = null;
/*  52 */   private float moveSpeed = 0.35F;
/*  53 */   private EntityLivingBase rt = null;
/*     */ 
/*     */   
/*     */   public Pointysaurus(World par1World) {
/*  57 */     super(par1World);
/*  58 */     setSize(2.9F, 2.9F);
/*  59 */     getNavigator().setAvoidsWater(true);
/*  60 */     this.experienceValue = 40;
/*  61 */     this.fireResistance = 100;
/*  62 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  63 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  64 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  65 */     this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  66 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  67 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  68 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  73 */     super.applyEntityAttributes();
/*  74 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  75 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  76 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Pointysaurus_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  81 */     super.entityInit();
/*  82 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  86 */     if (isNoDespawnRequired()) return false; 
/*  87 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  95 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  96 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 101 */     return OreSpawnMain.Pointysaurus_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 109 */     return OreSpawnMain.Pointysaurus_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 117 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 126 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 135 */     if (this.rand.nextInt(4) == 0) {
/* 136 */       return "orespawn:alo_living";
/*     */     }
/* 138 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 147 */     return "orespawn:alo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 155 */     return "orespawn:alo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 162 */     return 0.9F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 169 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 179 */     return Items.beef;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 184 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 2.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/*     */     
/* 186 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 193 */     for (var4 = 0; var4 < 10; var4++) {
/* 194 */       dropItemRand(Items.leather, 1);
/*     */     }
/* 196 */     for (var4 = 0; var4 < 6; var4++) {
/* 197 */       dropItemRand(Items.beef, 1);
/*     */     }
/* 199 */     for (var4 = 0; var4 < 6; var4++) {
/* 200 */       dropItemRand(Items.rotten_flesh, 1);
/*     */     }
/* 202 */     for (var4 = 0; var4 < 6; var4++) {
/* 203 */       dropItemRand(Items.string, 1);
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
/* 220 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 227 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 229 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 231 */         double ks = 0.8D;
/* 232 */         double inair = 0.1D;
/* 233 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 234 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 235 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 237 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 241 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 250 */     boolean ret = false;
/*     */     
/* 252 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*     */       
/* 254 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 255 */       Entity e = par1DamageSource.getEntity();
/*     */       
/* 257 */       if (e != null && e instanceof EntityLivingBase) {
/* 258 */         this.rt = (EntityLivingBase)e;
/*     */       }
/*     */     } 
/* 261 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 266 */     if (this.isDead)
/* 267 */       return;  super.updateAITasks();
/* 268 */     if (this.worldObj.rand.nextInt(6) == 0) {
/* 269 */       EntityLivingBase e = null;
/* 270 */       e = this.rt;
/* 271 */       if (OreSpawnMain.PlayNicely != 0) e = null; 
/* 272 */       if (e != null) {
/* 273 */         if (e.isDead || this.worldObj.rand.nextInt(250) == 1) {
/* 274 */           e = null;
/* 275 */           this.rt = null;
/*     */         } 
/* 277 */         if (e != null && 
/* 278 */           !getEntitySenses().canSee((Entity)e)) {
/* 279 */           e = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 284 */       if (e == null) {
/* 285 */         e = findSomethingToAttack();
/*     */       }
/*     */       
/* 288 */       if (e != null) {
/* 289 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 290 */         if (getDistanceSqToEntity((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 291 */           setAttacking(1);
/*     */           
/* 293 */           if (this.worldObj.rand.nextInt(5) == 0 || this.worldObj.rand.nextInt(6) == 1)
/*     */           {
/* 295 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 298 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 301 */         setAttacking(0);
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
/* 314 */     if (par1EntityLiving == null)
/*     */     {
/* 316 */       return false;
/*     */     }
/* 318 */     if (par1EntityLiving == this)
/*     */     {
/* 320 */       return false;
/*     */     }
/* 322 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 324 */       return false;
/*     */     }
/*     */     
/* 327 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 329 */     if (par1EntityLiving instanceof Pointysaurus)
/*     */     {
/* 331 */       return false;
/*     */     }
/*     */     
/* 334 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 336 */       return false;
/*     */     }
/*     */     
/* 339 */     if (par1EntityLiving instanceof VelocityRaptor)
/*     */     {
/* 341 */       return false;
/*     */     }
/*     */     
/* 344 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 347 */       return false;
/*     */     }
/*     */     
/* 350 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 352 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 353 */       if (p.capabilities.isCreativeMode == true) {
/* 354 */         return false;
/*     */       }
/* 356 */       return true;
/*     */     } 
/*     */     
/* 359 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 364 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 365 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 5.0D, 12.0D));
/* 366 */     Collections.sort(var5, this.TargetSorter);
/* 367 */     Iterator<?> var2 = var5.iterator();
/* 368 */     Entity var3 = null;
/* 369 */     EntityLivingBase var4 = null;
/*     */     
/* 371 */     while (var2.hasNext()) {
/*     */       
/* 373 */       var3 = (Entity)var2.next();
/* 374 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 376 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 378 */         return var4;
/*     */       }
/*     */     } 
/* 381 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAttacking() {
/* 386 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAttacking(int par1) {
/* 391 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
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
/* 403 */     for (k = -3; k < 3; k++) {
/*     */       
/* 405 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 407 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 409 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 410 */           if (bid == Blocks.mob_spawner) {
/* 411 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 412 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 413 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 414 */             if (s != null && 
/* 415 */               s.equals("Pointysaurus")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 421 */     if (!isValidLightLevel()) return false; 
/* 422 */     if (this.posY < 50.0D) return false; 
/* 423 */     if (this.worldObj.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 427 */     for (k = -1; k < 1; k++) {
/*     */       
/* 429 */       for (int j = -1; j < 1; j++) {
/*     */         
/* 431 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 433 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 434 */           if (bid != Blocks.air) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/* 439 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Pointysaurus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */