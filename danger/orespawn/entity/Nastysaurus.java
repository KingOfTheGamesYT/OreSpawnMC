/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.util.ai.MyEntityAIWanderALot;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.annotation.Nullable;
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
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
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
/*     */ public class Nastysaurus
/*     */   extends EntityMob
/*     */ {
/*  61 */   protected static final DataParameter<Byte> ATTACKING = EntityDataManager.createKey(Alosaurus.class, DataSerializers.BYTE);
/*  62 */   private GenericTargetSorter TargetSorter = null;
/*  63 */   private float moveSpeed = 0.35F;
/*  64 */   private EntityLivingBase rt = null;
/*  65 */   private RenderInfo renderdata = new RenderInfo();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nastysaurus(World par1World) {
/*  72 */     super(par1World);
/*  73 */     setSize(2.2F, 4.6F);
/*     */     
/*  75 */     this.experienceValue = 40;
/*     */     
/*  77 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  78 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  79 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  80 */     this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  81 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  82 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  83 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  88 */     super.applyEntityAttributes();
/*  89 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  90 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  91 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(32.0D);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/* 113 */     super.entityInit();
/* 114 */     this.dataManager.register(ATTACKING, Byte.valueOf((byte)0));
/*     */     
/* 116 */     if (this.renderdata == null) {
/* 117 */       this.renderdata = new RenderInfo();
/*     */     }
/*     */     
/* 120 */     this.renderdata.rf1 = 0.0F;
/* 121 */     this.renderdata.rf2 = 0.0F;
/* 122 */     this.renderdata.rf3 = 0.0F;
/* 123 */     this.renderdata.rf4 = 0.0F;
/* 124 */     this.renderdata.ri1 = 0;
/* 125 */     this.renderdata.ri2 = 0;
/* 126 */     this.renderdata.ri3 = 0;
/* 127 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 134 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 139 */     this.renderdata.rf1 = r.rf1;
/* 140 */     this.renderdata.rf2 = r.rf2;
/* 141 */     this.renderdata.rf3 = r.rf3;
/* 142 */     this.renderdata.rf4 = r.rf4;
/* 143 */     this.renderdata.ri1 = r.ri1;
/* 144 */     this.renderdata.ri2 = r.ri2;
/* 145 */     this.renderdata.ri3 = r.ri3;
/* 146 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 150 */     if (isNoDespawnRequired()) return false; 
/* 151 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 159 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/* 160 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 165 */     return 200;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 173 */     return 17;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 181 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 190 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/* 197 */     if (this.rand.nextInt(4) == 0) {
/* 198 */       return SoundsHandler.ENTITY_ALOSAURUS_LIVING;
/*     */     }
/* 200 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/* 205 */     return SoundsHandler.ENTITY_ALOSAURUS_HURT;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 223 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 231 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 242 */     return Items.BEEF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 248 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 3.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/*     */     
/* 250 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 258 */     for (var4 = 0; var4 < 10; var4++) {
/* 259 */       dropItemRand(Items.IRON_INGOT, 1);
/*     */     }
/* 261 */     for (var4 = 0; var4 < 10; var4++) {
/* 262 */       dropItemRand(Items.ROTTEN_FLESH, 1);
/*     */     }
/* 264 */     for (var4 = 0; var4 < 10; var4++) {
/* 265 */       dropItemRand(Items.LEATHER, 1);
/*     */     }
/* 267 */     for (var4 = 0; var4 < 10; var4++) {
/* 268 */       dropItemRand(Items.STRING, 1);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 285 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 287 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 289 */         double ks = 1.2D;
/* 290 */         double inair = 0.1D;
/* 291 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 292 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 293 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 295 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 299 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 309 */     boolean ret = false;
/*     */     
/* 311 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*     */       
/* 313 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 314 */       Entity e = par1DamageSource.getTrueSource();
/*     */       
/* 316 */       if (e != null && e instanceof EntityLivingBase) {
/* 317 */         this.rt = (EntityLivingBase)e;
/*     */       }
/*     */     } 
/* 320 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 326 */     if (this.isDead)
/* 327 */       return;  super.updateAITasks();
/* 328 */     if (this.world.rand.nextInt(5) == 0) {
/* 329 */       EntityLivingBase e = null;
/* 330 */       e = this.rt;
/* 331 */       if (OreSpawnMain.PlayNicely != 0) e = null; 
/* 332 */       if (e != null) {
/* 333 */         if (e.isDead || this.world.rand.nextInt(250) == 1) {
/* 334 */           e = null;
/* 335 */           this.rt = null;
/*     */         } 
/* 337 */         if (e != null && 
/* 338 */           !getEntitySenses().canSee((Entity)e)) {
/* 339 */           e = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 344 */       if (e == null) {
/* 345 */         e = findSomethingToAttack();
/*     */       }
/* 347 */       if (e != null) {
/* 348 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 349 */         if (getDistanceSq((Entity)e) < ((4.5F + e.width / 2.0F) * (4.5F + e.width / 2.0F))) {
/* 350 */           setAttacking(1);
/*     */           
/* 352 */           if (this.world.rand.nextInt(4) == 0 || this.world.rand.nextInt(5) == 1)
/*     */           {
/* 354 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 357 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 360 */         setAttacking(0);
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
/* 373 */     if (par1EntityLiving == null)
/*     */     {
/* 375 */       return false;
/*     */     }
/* 377 */     if (par1EntityLiving == this)
/*     */     {
/* 379 */       return false;
/*     */     }
/* 381 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 383 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 388 */     if (par1EntityLiving instanceof Nastysaurus)
/*     */     {
/* 390 */       return false;
/*     */     }
/*     */     
/* 393 */     if (par1EntityLiving instanceof Cryolophosaurus)
/*     */     {
/* 395 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 403 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 406 */       return false;
/*     */     }
/*     */     
/* 409 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 411 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 412 */       if (p.capabilities.isCreativeMode == true) {
/* 413 */         return false;
/*     */       }
/* 415 */       return true;
/*     */     } 
/*     */     
/* 418 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 423 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 424 */     List<?> var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(32.0D, 8.0D, 32.0D));
/* 425 */     Collections.sort(var5, this.TargetSorter);
/* 426 */     Iterator<?> var2 = var5.iterator();
/* 427 */     Entity var3 = null;
/* 428 */     EntityLivingBase var4 = null;
/*     */     
/* 430 */     while (var2.hasNext()) {
/*     */       
/* 432 */       var3 = (Entity)var2.next();
/* 433 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 435 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 437 */         return var4;
/*     */       }
/*     */     } 
/* 440 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAttacking() {
/* 445 */     return ((Byte)this.dataManager.get(ATTACKING)).byteValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttacking(int par1) {
/* 451 */     this.dataManager.set(ATTACKING, Byte.valueOf((byte)par1));
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
/*     */   public boolean getCanSpawnHere() {
/* 484 */     if (!isValidLightLevel()) return false; 
/* 485 */     if (this.posY < 50.0D) return false; 
/* 486 */     if (this.world.isDaytime()) return false;
/*     */ 
/*     */ 
/*     */     
/* 490 */     for (int k = -1; k < 1; k++) {
/*     */       
/* 492 */       for (int j = -1; j < 1; j++) {
/*     */         
/* 494 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 496 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/*     */           
/* 498 */           if (bid != Blocks.AIR) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 504 */     Nastysaurus target = null;
/* 505 */     target = (Nastysaurus)this.world.findNearestEntityWithinAABB(Nastysaurus.class, getEntityBoundingBox().expand(16.0D, 8.0D, 16.0D), (Entity)this);
/* 506 */     if (target != null)
/*     */     {
/* 508 */       return false;
/*     */     }
/* 510 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\Nastysaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */