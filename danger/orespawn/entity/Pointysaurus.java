/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
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
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
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
/*     */ public class Pointysaurus
/*     */   extends EntityMob
/*     */ {
/*  57 */   private float moveSpeed = 0.35F;
/*  58 */   private EntityLivingBase rt = null;
/*     */ 
/*     */   
/*     */   public Pointysaurus(World par1World) {
/*  62 */     super(par1World);
/*  63 */     setSize(2.9F, 2.9F);
/*     */     
/*  65 */     this.experienceValue = 40;
/*     */ 
/*     */     
/*  68 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  69 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  70 */     this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  71 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  72 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  73 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  78 */     super.applyEntityAttributes();
/*  79 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  80 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  81 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  86 */     super.entityInit();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  91 */     if (isNoDespawnRequired()) return false; 
/*  92 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 100 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/* 101 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 106 */     return 40;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 114 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 122 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 131 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getAmbientSound() {
/* 141 */     if (this.rand.nextInt(4) == 0) {
/* 142 */       return SoundsHandler.ENTITY_ALOSAURUS_LIVING;
/*     */     }
/* 144 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getHurtSound(DamageSource source) {
/* 150 */     return SoundsHandler.ENTITY_ALOSAURUS_HURT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 156 */     return SoundsHandler.ENTITY_ALOSAURUS_DEATH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 163 */     return 0.9F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 170 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 180 */     return Items.BEEF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 186 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 2.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/* 187 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 194 */     for (var4 = 0; var4 < 10; var4++) {
/* 195 */       dropItemRand(Items.LEATHER, 1);
/*     */     }
/* 197 */     for (var4 = 0; var4 < 6; var4++) {
/* 198 */       dropItemRand(Items.BEEF, 1);
/*     */     }
/* 200 */     for (var4 = 0; var4 < 6; var4++) {
/* 201 */       dropItemRand(Items.ROTTEN_FLESH, 1);
/*     */     }
/* 203 */     for (var4 = 0; var4 < 6; var4++) {
/* 204 */       dropItemRand(Items.STRING, 1);
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
/* 221 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 228 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 230 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 232 */         double ks = 0.8D;
/* 233 */         double inair = 0.1D;
/* 234 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 235 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 236 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 238 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 242 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 251 */     boolean ret = false;
/*     */     
/* 253 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*     */       
/* 255 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 256 */       Entity e = par1DamageSource.getImmediateSource();
/*     */       
/* 258 */       if (e != null && e instanceof EntityLivingBase) {
/* 259 */         this.rt = (EntityLivingBase)e;
/*     */       }
/*     */     } 
/* 262 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 267 */     if (this.isDead)
/* 268 */       return;  super.updateAITasks();
/* 269 */     if (this.world.rand.nextInt(6) == 0) {
/* 270 */       EntityLivingBase e = null;
/* 271 */       e = this.rt;
/* 272 */       if (OreSpawnMain.PlayNicely != 0) e = null; 
/* 273 */       if (e != null) {
/* 274 */         if (e.isDead || this.world.rand.nextInt(250) == 1) {
/* 275 */           e = null;
/* 276 */           this.rt = null;
/*     */         } 
/* 278 */         if (e != null && 
/* 279 */           !getEntitySenses().canSee((Entity)e)) {
/* 280 */           e = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 285 */       if (e == null) {
/* 286 */         e = findSomethingToAttack();
/*     */       }
/*     */       
/* 289 */       if (e != null) {
/* 290 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 291 */         if (getDistanceSq((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 292 */           setAttacking(1);
/*     */           
/* 294 */           if (this.world.rand.nextInt(5) == 0 || this.world.rand.nextInt(6) == 1)
/*     */           {
/* 296 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 299 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 302 */         setAttacking(0);
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
/* 315 */     if (par1EntityLiving == null)
/*     */     {
/* 317 */       return false;
/*     */     }
/* 319 */     if (par1EntityLiving == this)
/*     */     {
/* 321 */       return false;
/*     */     }
/* 323 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 325 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 330 */     if (par1EntityLiving instanceof Pointysaurus)
/*     */     {
/* 332 */       return false;
/*     */     }
/*     */     
/* 335 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 337 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 345 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 348 */       return false;
/*     */     }
/*     */     
/* 351 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 353 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 354 */       if (p.capabilities.isCreativeMode == true) {
/* 355 */         return false;
/*     */       }
/* 357 */       return true;
/*     */     } 
/*     */     
/* 360 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 365 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 366 */     List var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(12.0D, 5.0D, 12.0D));
/*     */     
/* 368 */     Iterator<Entity> var2 = var5.iterator();
/* 369 */     Entity var3 = null;
/* 370 */     EntityLivingBase var4 = null;
/*     */     
/* 372 */     while (var2.hasNext()) {
/*     */       
/* 374 */       var3 = var2.next();
/* 375 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 377 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 379 */         return var4;
/*     */       }
/*     */     } 
/* 382 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAttacking() {
/* 387 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttacking(int par1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/*     */     int k;
/* 404 */     for (k = -3; k < 3; k++) {
/*     */       
/* 406 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 408 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 410 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 411 */           if (bid == Blocks.MOB_SPAWNER) {
/* 412 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 413 */             tileentitymobspawner = (TileEntityMobSpawner)this.world.getTileEntity(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k));
/* 414 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getSpawnerEntity().getName();
/* 415 */             if (s != null && 
/* 416 */               s.equals("Pointysaurus")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 422 */     if (!isValidLightLevel()) return false; 
/* 423 */     if (this.posY < 50.0D) return false; 
/* 424 */     if (this.world.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 428 */     for (k = -1; k < 1; k++) {
/*     */       
/* 430 */       for (int j = -1; j < 1; j++) {
/*     */         
/* 432 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 434 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 435 */           if (bid != Blocks.AIR) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/* 440 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\entity\Pointysaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */