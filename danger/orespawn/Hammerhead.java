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
/*     */ public class Hammerhead
/*     */   extends EntityMob
/*     */ {
/*  51 */   private GenericTargetSorter TargetSorter = null;
/*  52 */   private float moveSpeed = 0.35F;
/*  53 */   private EntityLivingBase rt = null;
/*     */ 
/*     */   
/*     */   public Hammerhead(World par1World) {
/*  57 */     super(par1World);
/*  58 */     setSize(3.0F, 5.0F);
/*  59 */     getNavigator().setAvoidsWater(true);
/*  60 */     this.experienceValue = 350;
/*  61 */     this.fireResistance = 100;
/*  62 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  63 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  64 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  65 */     this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  66 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 8.0F));
/*  67 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  68 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  73 */     super.applyEntityAttributes();
/*  74 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  75 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  76 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Hammerhead_stats.attack);
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
/* 101 */     return OreSpawnMain.Hammerhead_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 109 */     return OreSpawnMain.Hammerhead_stats.defense;
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
/* 135 */     if (this.rand.nextInt(3) == 0) {
/* 136 */       return "orespawn:hammerhead_living";
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
/* 155 */     return "orespawn:hammerhead_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 162 */     return 1.2F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 169 */     return 0.9F;
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
/* 184 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 2.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), new ItemStack(index, par1, 0));
/*     */     
/* 186 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 193 */     for (var4 = 0; var4 < 8; var4++) {
/* 194 */       dropItemRand(Items.experience_bottle, 1);
/*     */     }
/* 196 */     for (var4 = 0; var4 < 10; var4++) {
/* 197 */       dropItemRand(OreSpawnMain.MyExperienceCatcher, 1);
/*     */     }
/* 199 */     for (var4 = 0; var4 < 16; var4++) {
/* 200 */       dropItemRand(OreSpawnMain.CreeperLauncher, 1);
/*     */     }
/* 202 */     for (var4 = 0; var4 < 4; var4++) {
/* 203 */       dropItemRand(Item.getItemFromBlock(OreSpawnMain.CreeperRepellent), 1);
/*     */     }
/* 205 */     for (var4 = 0; var4 < 6; var4++) {
/* 206 */       dropItemRand(Items.beef, 1);
/*     */     }
/* 208 */     for (var4 = 0; var4 < 2; var4++) {
/* 209 */       dropItemRand(OreSpawnMain.MyExperienceTreeSeed, 1);
/*     */     }
/* 211 */     if (this.worldObj.rand.nextInt(3) == 1) dropItemRand(OreSpawnMain.MyHammy, 1);
/*     */   
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
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 227 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 234 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 236 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 238 */         double ks = 1.1D;
/* 239 */         double inair = 0.85D;
/* 240 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 241 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 242 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 244 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 248 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 257 */     boolean ret = false;
/*     */     
/* 259 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*     */       
/* 261 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 262 */       Entity e = par1DamageSource.getEntity();
/*     */       
/* 264 */       if (e != null && e instanceof EntityLivingBase) {
/* 265 */         this.rt = (EntityLivingBase)e;
/*     */       }
/*     */     } 
/* 268 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 273 */     if (this.isDead)
/* 274 */       return;  super.updateAITasks();
/* 275 */     if (this.worldObj.rand.nextInt(3) == 1) {
/* 276 */       EntityLivingBase e = null;
/* 277 */       e = this.rt;
/* 278 */       if (OreSpawnMain.PlayNicely != 0) e = null; 
/* 279 */       if (e != null) {
/* 280 */         if (e.isDead || this.worldObj.rand.nextInt(250) == 1) {
/* 281 */           e = null;
/* 282 */           this.rt = null;
/*     */         } 
/* 284 */         if (e != null && 
/* 285 */           !getEntitySenses().canSee((Entity)e)) {
/* 286 */           e = null;
/*     */         }
/*     */       } 
/*     */       
/* 290 */       if (e == null) e = findSomethingToAttack(); 
/* 291 */       if (e != null) {
/* 292 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 293 */         if (getDistanceSqToEntity((Entity)e) < ((7.0F + e.width / 2.0F) * (7.0F + e.width / 2.0F))) {
/* 294 */           setAttacking(1);
/*     */           
/* 296 */           if (this.worldObj.rand.nextInt(3) == 1 || this.worldObj.rand.nextInt(4) == 1)
/*     */           {
/* 298 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 301 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 304 */         setAttacking(0);
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
/* 317 */     if (par1EntityLiving == null)
/*     */     {
/* 319 */       return false;
/*     */     }
/* 321 */     if (par1EntityLiving == this)
/*     */     {
/* 323 */       return false;
/*     */     }
/* 325 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 327 */       return false;
/*     */     }
/* 329 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 332 */       return false;
/*     */     }
/* 334 */     if (par1EntityLiving instanceof Hammerhead)
/*     */     {
/* 336 */       return false;
/*     */     }
/* 338 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 340 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 341 */       if (p.capabilities.isCreativeMode == true) {
/* 342 */         return false;
/*     */       }
/* 344 */       return true;
/*     */     } 
/* 346 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 348 */       return true;
/*     */     }
/* 350 */     if (MyUtils.isAttackableNonMob(par1EntityLiving)) {
/* 351 */       return true;
/*     */     }
/*     */     
/* 354 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 359 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 360 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(18.0D, 9.0D, 18.0D));
/* 361 */     Collections.sort(var5, this.TargetSorter);
/* 362 */     Iterator<?> var2 = var5.iterator();
/* 363 */     Entity var3 = null;
/* 364 */     EntityLivingBase var4 = null;
/*     */     
/* 366 */     while (var2.hasNext()) {
/*     */       
/* 368 */       var3 = (Entity)var2.next();
/* 369 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 371 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 373 */         return var4;
/*     */       }
/*     */     } 
/* 376 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 381 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 386 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
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
/* 398 */     for (k = -3; k < 3; k++) {
/*     */       
/* 400 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 402 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 404 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 405 */           if (bid == Blocks.mob_spawner) {
/* 406 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 407 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 408 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 409 */             if (s != null && 
/* 410 */               s.equals("Hammerhead")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 416 */     if (!isValidLightLevel()) return false; 
/* 417 */     if (this.posY < 50.0D) return false; 
/* 418 */     if (this.worldObj.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 422 */     for (k = -1; k < 1; k++) {
/*     */       
/* 424 */       for (int j = -1; j < 1; j++) {
/*     */         
/* 426 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 428 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 429 */           if (bid != Blocks.air) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 435 */     Hammerhead target = null;
/* 436 */     target = (Hammerhead)this.worldObj.findNearestEntityWithinAABB(Hammerhead.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D), (Entity)this);
/* 437 */     if (target != null)
/*     */     {
/* 439 */       return false;
/*     */     }
/* 441 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Hammerhead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */