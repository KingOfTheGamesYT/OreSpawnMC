/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.init.ModItems;
/*     */ import danger.orespawn.util.ai.MyEntityAIWanderALot;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
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
/*     */ import net.minecraft.network.datasync.DataParameter;
/*     */ import net.minecraft.network.datasync.DataSerializers;
/*     */ import net.minecraft.network.datasync.EntityDataManager;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class TRex
/*     */   extends EntityMob
/*     */ {
/*  40 */   private float moveSpeed = 0.38F;
/*  41 */   private EntityLivingBase rt = null;
/*  42 */   protected static final DataParameter<Byte> ATTACKING = EntityDataManager.createKey(Alosaurus.class, DataSerializers.BYTE);
/*     */ 
/*     */   
/*     */   public TRex(World par1World) {
/*  46 */     super(par1World);
/*  47 */     setSize(2.0F, 4.2F);
/*     */     
/*  49 */     this.experienceValue = 150;
/*     */ 
/*     */ 
/*     */     
/*  53 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  54 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  55 */     this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  56 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  57 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  58 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  63 */     super.applyEntityAttributes();
/*  64 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  65 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  66 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  71 */     super.entityInit();
/*  72 */     this.dataManager.register(ATTACKING, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  76 */     if (isNoDespawnRequired()) return false; 
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  85 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  86 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  91 */     return 30;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/*  99 */     return 12;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 116 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getAmbientSound() {
/* 126 */     if (this.rand.nextInt(4) == 0) {
/* 127 */       return SoundsHandler.ENTITY_TREX_AMBIENT;
/*     */     }
/* 129 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getHurtSound(DamageSource source) {
/* 135 */     return SoundsHandler.ENTITY_ALOSAURUS_HURT;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 140 */     return SoundsHandler.ENTITY_TREX_DEATH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 147 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 154 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 164 */     return Items.BEEF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 170 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/* 171 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 178 */     dropItemRand(ModItems.TREX_TOOTH, 1);
/* 179 */     dropItemRand(Items.ITEM_FRAME, 1);
/*     */     int var4;
/* 181 */     for (var4 = 0; var4 < 7; var4++) {
/* 182 */       dropItemRand(Items.BEEF, 1);
/*     */     }
/* 184 */     var4 = 2 + this.world.rand.nextInt(4);
/* 185 */     for (int i = 0; i < var4; i++) {
/* 186 */       dropItemRand(ModItems.URANIUM_NUGGET, 1);
/* 187 */       dropItemRand(ModItems.TITANIUM_NUGGET, 1);
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
/* 203 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 210 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 212 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 214 */         double ks = 1.2D;
/* 215 */         double inair = 0.1D;
/* 216 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 217 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 218 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 220 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 224 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 233 */     boolean ret = false;
/*     */     
/* 235 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*     */       
/* 237 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 238 */       Entity e = par1DamageSource.getImmediateSource();
/*     */       
/* 240 */       if (e != null && e instanceof EntityLivingBase) {
/* 241 */         this.rt = (EntityLivingBase)e;
/*     */       }
/*     */     } 
/* 244 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 249 */     if (this.isDead)
/* 250 */       return;  super.updateAITasks();
/* 251 */     if (this.world.rand.nextInt(5) == 1) {
/* 252 */       EntityLivingBase e = null;
/* 253 */       e = this.rt;
/* 254 */       if (OreSpawnMain.PlayNicely != 0) e = null; 
/* 255 */       if (e != null) {
/* 256 */         if (e.isDead || this.world.rand.nextInt(200) == 1) {
/* 257 */           e = null;
/* 258 */           this.rt = null;
/*     */         } 
/* 260 */         if (e != null && 
/* 261 */           !getEntitySenses().canSee((Entity)e)) {
/* 262 */           e = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 267 */       if (e == null) {
/* 268 */         e = findSomethingToAttack();
/*     */       }
/* 270 */       if (e != null) {
/* 271 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 272 */         if (getDistanceSq((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 273 */           setAttacking(1);
/*     */           
/* 275 */           if (this.world.rand.nextInt(4) == 0 || this.world.rand.nextInt(5) == 1)
/*     */           {
/* 277 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 280 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 283 */         setAttacking(0);
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
/* 296 */     if (par1EntityLiving == null)
/*     */     {
/* 298 */       return false;
/*     */     }
/* 300 */     if (par1EntityLiving == this)
/*     */     {
/* 302 */       return false;
/*     */     }
/* 304 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 306 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 311 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 314 */       return false;
/*     */     }
/* 316 */     if (par1EntityLiving instanceof TRex)
/*     */     {
/* 318 */       return false;
/*     */     }
/* 320 */     if (par1EntityLiving instanceof Cryolophosaurus)
/*     */     {
/* 322 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 343 */     List var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(20.0D, 6.0D, 20.0D));
/*     */     
/* 345 */     Iterator<Entity> var2 = var5.iterator();
/* 346 */     Entity var3 = null;
/* 347 */     EntityLivingBase var4 = null;
/*     */     
/* 349 */     while (var2.hasNext()) {
/*     */       
/* 351 */       var3 = var2.next();
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
/*     */   public int getAttacking() {
/* 364 */     return Byte.valueOf(((Byte)this.dataManager.get(ATTACKING)).byteValue()).byteValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAttacking(int par1) {
/* 369 */     this.dataManager.set(ATTACKING, Byte.valueOf((byte)par1));
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
/* 380 */     for (k = -3; k < 3; k++) {
/*     */       
/* 382 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 384 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 386 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 387 */           if (bid == Blocks.MOB_SPAWNER) {
/* 388 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 389 */             tileentitymobspawner = (TileEntityMobSpawner)this.world.getTileEntity(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k));
/* 390 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getSpawnerEntity().getName();
/* 391 */             if (s != null && 
/* 392 */               s.equals("T. Rex")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 398 */     if (!isValidLightLevel()) return false; 
/* 399 */     if (this.posY < 50.0D) return false; 
/* 400 */     if (this.world.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 404 */     for (k = -1; k <= 1; k++) {
/*     */       
/* 406 */       for (int j = -1; j <= 1; j++) {
/*     */         
/* 408 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 410 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 411 */           if (bid != Blocks.AIR) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 417 */     TRex target = null;
/* 418 */     target = (TRex)this.world.findNearestEntityWithinAABB(TRex.class, getEntityBoundingBox().expand(24.0D, 12.0D, 24.0D), (Entity)this);
/* 419 */     if (target != null)
/*     */     {
/* 421 */       return false;
/*     */     }
/* 423 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\entity\TRex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */