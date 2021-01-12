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
/*     */ public class TRex
/*     */   extends EntityMob
/*     */ {
/*  51 */   private GenericTargetSorter TargetSorter = null;
/*  52 */   private float moveSpeed = 0.38F;
/*  53 */   private EntityLivingBase rt = null;
/*     */ 
/*     */   
/*     */   public TRex(World par1World) {
/*  57 */     super(par1World);
/*  58 */     setSize(2.0F, 4.2F);
/*  59 */     getNavigator().setAvoidsWater(true);
/*  60 */     this.experienceValue = 150;
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
/*  76 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.TRex_stats.attack);
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
/* 101 */     return OreSpawnMain.TRex_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 109 */     return OreSpawnMain.TRex_stats.defense;
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
/* 136 */       return "orespawn:trex_living";
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
/* 155 */     return "orespawn:trex_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 162 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 169 */     return 1.0F;
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
/* 184 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/*     */     
/* 186 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 193 */     dropItemRand(OreSpawnMain.TRexTooth, 1);
/* 194 */     dropItemRand(Items.item_frame, 1);
/*     */     int var4;
/* 196 */     for (var4 = 0; var4 < 7; var4++) {
/* 197 */       dropItemRand(Items.beef, 1);
/*     */     }
/* 199 */     var4 = 2 + this.worldObj.rand.nextInt(4);
/* 200 */     for (int i = 0; i < var4; i++) {
/* 201 */       dropItemRand(OreSpawnMain.UraniumNugget, 1);
/* 202 */       dropItemRand(OreSpawnMain.TitaniumNugget, 1);
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
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 218 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 225 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 227 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 229 */         double ks = 1.2D;
/* 230 */         double inair = 0.1D;
/* 231 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 232 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 233 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 235 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 239 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 248 */     boolean ret = false;
/*     */     
/* 250 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*     */       
/* 252 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 253 */       Entity e = par1DamageSource.getEntity();
/*     */       
/* 255 */       if (e != null && e instanceof EntityLivingBase) {
/* 256 */         this.rt = (EntityLivingBase)e;
/*     */       }
/*     */     } 
/* 259 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 264 */     if (this.isDead)
/* 265 */       return;  super.updateAITasks();
/* 266 */     if (this.worldObj.rand.nextInt(5) == 1) {
/* 267 */       EntityLivingBase e = null;
/* 268 */       e = this.rt;
/* 269 */       if (OreSpawnMain.PlayNicely != 0) e = null; 
/* 270 */       if (e != null) {
/* 271 */         if (e.isDead || this.worldObj.rand.nextInt(200) == 1) {
/* 272 */           e = null;
/* 273 */           this.rt = null;
/*     */         } 
/* 275 */         if (e != null && 
/* 276 */           !getEntitySenses().canSee((Entity)e)) {
/* 277 */           e = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 282 */       if (e == null) {
/* 283 */         e = findSomethingToAttack();
/*     */       }
/* 285 */       if (e != null) {
/* 286 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 287 */         if (getDistanceSqToEntity((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 288 */           setAttacking(1);
/*     */           
/* 290 */           if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1)
/*     */           {
/* 292 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 295 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 298 */         setAttacking(0);
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
/* 311 */     if (par1EntityLiving == null)
/*     */     {
/* 313 */       return false;
/*     */     }
/* 315 */     if (par1EntityLiving == this)
/*     */     {
/* 317 */       return false;
/*     */     }
/* 319 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 321 */       return false;
/*     */     }
/*     */     
/* 324 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 326 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 329 */       return false;
/*     */     }
/* 331 */     if (par1EntityLiving instanceof TRex)
/*     */     {
/* 333 */       return false;
/*     */     }
/* 335 */     if (par1EntityLiving instanceof Cryolophosaurus)
/*     */     {
/* 337 */       return false;
/*     */     }
/*     */     
/* 340 */     if (par1EntityLiving instanceof VelocityRaptor)
/*     */     {
/* 342 */       return false;
/*     */     }
/* 344 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 346 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 347 */       if (p.capabilities.isCreativeMode == true) {
/* 348 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 352 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 357 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 358 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(20.0D, 6.0D, 20.0D));
/* 359 */     Collections.sort(var5, this.TargetSorter);
/* 360 */     Iterator<?> var2 = var5.iterator();
/* 361 */     Entity var3 = null;
/* 362 */     EntityLivingBase var4 = null;
/*     */     
/* 364 */     while (var2.hasNext()) {
/*     */       
/* 366 */       var3 = (Entity)var2.next();
/* 367 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 369 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 371 */         return var4;
/*     */       }
/*     */     } 
/* 374 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 379 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 384 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/*     */     int k;
/* 395 */     for (k = -3; k < 3; k++) {
/*     */       
/* 397 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 399 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 401 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 402 */           if (bid == Blocks.mob_spawner) {
/* 403 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 404 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 405 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 406 */             if (s != null && 
/* 407 */               s.equals("T. Rex")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 413 */     if (!isValidLightLevel()) return false; 
/* 414 */     if (this.posY < 50.0D) return false; 
/* 415 */     if (this.worldObj.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 419 */     for (k = -1; k <= 1; k++) {
/*     */       
/* 421 */       for (int j = -1; j <= 1; j++) {
/*     */         
/* 423 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 425 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 426 */           if (bid != Blocks.air) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 432 */     TRex target = null;
/* 433 */     target = (TRex)this.worldObj.findNearestEntityWithinAABB(TRex.class, this.boundingBox.expand(24.0D, 12.0D, 24.0D), (Entity)this);
/* 434 */     if (target != null)
/*     */     {
/* 436 */       return false;
/*     */     }
/* 438 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\TRex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */