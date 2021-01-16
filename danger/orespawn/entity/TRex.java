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
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 141 */     return SoundsHandler.ENTITY_TREX_DEATH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 148 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 155 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 165 */     return Items.BEEF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 171 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/* 172 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 179 */     dropItemRand(ModItems.TREX_TOOTH, 1);
/* 180 */     dropItemRand(Items.ITEM_FRAME, 1);
/*     */     int var4;
/* 182 */     for (var4 = 0; var4 < 7; var4++) {
/* 183 */       dropItemRand(Items.BEEF, 1);
/*     */     }
/* 185 */     var4 = 2 + this.world.rand.nextInt(4);
/* 186 */     for (int i = 0; i < var4; i++) {
/* 187 */       dropItemRand(ModItems.URANIUM_NUGGET, 1);
/* 188 */       dropItemRand(ModItems.TITANIUM_NUGGET, 1);
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
/* 204 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 211 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 213 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 215 */         double ks = 1.2D;
/* 216 */         double inair = 0.1D;
/* 217 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 218 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 219 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 221 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 225 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 234 */     boolean ret = false;
/*     */     
/* 236 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*     */       
/* 238 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 239 */       Entity e = par1DamageSource.getImmediateSource();
/*     */       
/* 241 */       if (e != null && e instanceof EntityLivingBase) {
/* 242 */         this.rt = (EntityLivingBase)e;
/*     */       }
/*     */     } 
/* 245 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 250 */     if (this.isDead)
/* 251 */       return;  super.updateAITasks();
/* 252 */     if (this.world.rand.nextInt(5) == 1) {
/* 253 */       EntityLivingBase e = null;
/* 254 */       e = this.rt;
/* 255 */       if (OreSpawnMain.PlayNicely != 0) e = null; 
/* 256 */       if (e != null) {
/* 257 */         if (e.isDead || this.world.rand.nextInt(200) == 1) {
/* 258 */           e = null;
/* 259 */           this.rt = null;
/*     */         } 
/* 261 */         if (e != null && 
/* 262 */           !getEntitySenses().canSee((Entity)e)) {
/* 263 */           e = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 268 */       if (e == null) {
/* 269 */         e = findSomethingToAttack();
/*     */       }
/* 271 */       if (e != null) {
/* 272 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 273 */         if (getDistanceSq((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 274 */           setAttacking(1);
/*     */           
/* 276 */           if (this.world.rand.nextInt(4) == 0 || this.world.rand.nextInt(5) == 1)
/*     */           {
/* 278 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 281 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 284 */         setAttacking(0);
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
/* 297 */     if (par1EntityLiving == null)
/*     */     {
/* 299 */       return false;
/*     */     }
/* 301 */     if (par1EntityLiving == this)
/*     */     {
/* 303 */       return false;
/*     */     }
/* 305 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 307 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 312 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 315 */       return false;
/*     */     }
/* 317 */     if (par1EntityLiving instanceof TRex)
/*     */     {
/* 319 */       return false;
/*     */     }
/* 321 */     if (par1EntityLiving instanceof Cryolophosaurus)
/*     */     {
/* 323 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 330 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 332 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 333 */       if (p.capabilities.isCreativeMode == true) {
/* 334 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 338 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 343 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 344 */     List var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(20.0D, 6.0D, 20.0D));
/*     */     
/* 346 */     Iterator<Entity> var2 = var5.iterator();
/* 347 */     Entity var3 = null;
/* 348 */     EntityLivingBase var4 = null;
/*     */     
/* 350 */     while (var2.hasNext()) {
/*     */       
/* 352 */       var3 = var2.next();
/* 353 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 355 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 357 */         return var4;
/*     */       }
/*     */     } 
/* 360 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAttacking() {
/* 365 */     return Byte.valueOf(((Byte)this.dataManager.get(ATTACKING)).byteValue()).byteValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAttacking(int par1) {
/* 370 */     this.dataManager.set(ATTACKING, Byte.valueOf((byte)par1));
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
/* 381 */     for (k = -3; k < 3; k++) {
/*     */       
/* 383 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 385 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 387 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 388 */           if (bid == Blocks.MOB_SPAWNER) {
/* 389 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 390 */             tileentitymobspawner = (TileEntityMobSpawner)this.world.getTileEntity(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k));
/* 391 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getSpawnerEntity().getName();
/* 392 */             if (s != null && 
/* 393 */               s.equals("T. Rex")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 399 */     if (!isValidLightLevel()) return false; 
/* 400 */     if (this.posY < 50.0D) return false; 
/* 401 */     if (this.world.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 405 */     for (k = -1; k <= 1; k++) {
/*     */       
/* 407 */       for (int j = -1; j <= 1; j++) {
/*     */         
/* 409 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 411 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 412 */           if (bid != Blocks.AIR) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 418 */     TRex target = null;
/* 419 */     target = (TRex)this.world.findNearestEntityWithinAABB(TRex.class, getEntityBoundingBox().expand(24.0D, 12.0D, 24.0D), (Entity)this);
/* 420 */     if (target != null)
/*     */     {
/* 422 */       return false;
/*     */     }
/* 424 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\entity\TRex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */