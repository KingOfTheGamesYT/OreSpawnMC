/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.util.ai.MyEntityAIWanderALot;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.annotation.ParametersAreNonnullByDefault;
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
/*     */ 
/*     */ public class Pointysaurus
/*     */   extends EntityMob
/*     */ {
/*  59 */   private final float moveSpeed = 0.35F;
/*  60 */   private EntityLivingBase rt = null;
/*     */ 
/*     */   
/*     */   public Pointysaurus(World par1World) {
/*  64 */     super(par1World);
/*  65 */     setSize(2.9F, 2.9F);
/*     */     
/*  67 */     this.experienceValue = 40;
/*     */ 
/*     */     
/*  70 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  71 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  72 */     this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  73 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  74 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  75 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  80 */     super.applyEntityAttributes();
/*  81 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  82 */     getClass(); getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3499999940395355D);
/*  83 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  88 */     super.entityInit();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  93 */     return !isNoDespawnRequired();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 101 */     getClass(); getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3499999940395355D);
/* 102 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 107 */     return 40;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 115 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 123 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 132 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getAmbientSound() {
/* 142 */     if (this.rand.nextInt(4) == 0) {
/* 143 */       return SoundsHandler.ENTITY_ALOSAURUS_LIVING;
/*     */     }
/* 145 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @ParametersAreNonnullByDefault
/*     */   protected SoundEvent getHurtSound(DamageSource source) {
/* 152 */     return SoundsHandler.ENTITY_ALOSAURUS_HURT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 158 */     return SoundsHandler.ENTITY_ALOSAURUS_DEATH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 165 */     return 0.9F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 172 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 182 */     return Items.BEEF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 188 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 2.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/* 189 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 196 */     for (var4 = 0; var4 < 10; var4++) {
/* 197 */       dropItemRand(Items.LEATHER, 1);
/*     */     }
/* 199 */     for (var4 = 0; var4 < 6; var4++) {
/* 200 */       dropItemRand(Items.BEEF, 1);
/*     */     }
/* 202 */     for (var4 = 0; var4 < 6; var4++) {
/* 203 */       dropItemRand(Items.ROTTEN_FLESH, 1);
/*     */     }
/* 205 */     for (var4 = 0; var4 < 6; var4++) {
/* 206 */       dropItemRand(Items.STRING, 1);
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
/* 223 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 230 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 232 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 234 */         double ks = 0.8D;
/* 235 */         double inair = 0.1D;
/* 236 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 237 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 238 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 240 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 244 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 253 */     boolean ret = false;
/*     */     
/* 255 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*     */       
/* 257 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 258 */       Entity e = par1DamageSource.getImmediateSource();
/*     */       
/* 260 */       if (e instanceof EntityLivingBase) {
/* 261 */         this.rt = (EntityLivingBase)e;
/*     */       }
/*     */     } 
/* 264 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 269 */     if (this.isDead)
/* 270 */       return;  super.updateAITasks();
/* 271 */     if (this.world.rand.nextInt(6) == 0) {
/* 272 */       EntityLivingBase e = null;
/* 273 */       e = this.rt;
/* 274 */       if (OreSpawnMain.PlayNicely != 0) e = null; 
/* 275 */       if (e != null) {
/* 276 */         if (e.isDead || this.world.rand.nextInt(250) == 1) {
/* 277 */           e = null;
/* 278 */           this.rt = null;
/*     */         } 
/* 280 */         if (e != null && 
/* 281 */           !getEntitySenses().canSee((Entity)e)) {
/* 282 */           e = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 287 */       if (e == null) {
/* 288 */         e = findSomethingToAttack();
/*     */       }
/*     */       
/* 291 */       if (e != null) {
/* 292 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 293 */         if (getDistanceSq((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 294 */           setAttacking(1);
/*     */           
/* 296 */           if (this.world.rand.nextInt(5) == 0 || this.world.rand.nextInt(6) == 1)
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
/*     */ 
/*     */ 
/*     */     
/* 332 */     if (par1EntityLiving instanceof Pointysaurus)
/*     */     {
/* 334 */       return false;
/*     */     }
/*     */     
/* 337 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 339 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 347 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 350 */       return false;
/*     */     }
/*     */     
/* 353 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 355 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 356 */       if (p.capabilities.isCreativeMode) {
/* 357 */         return false;
/*     */       }
/* 359 */       return true;
/*     */     } 
/*     */     
/* 362 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 367 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 368 */     List var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(12.0D, 5.0D, 12.0D));
/*     */     
/* 370 */     Iterator<Entity> var2 = var5.iterator();
/* 371 */     Entity var3 = null;
/* 372 */     EntityLivingBase var4 = null;
/*     */     
/* 374 */     while (var2.hasNext()) {
/*     */       
/* 376 */       var3 = var2.next();
/* 377 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 379 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 381 */         return var4;
/*     */       }
/*     */     } 
/* 384 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAttacking() {
/* 389 */     return 1;
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
/* 406 */     for (k = -3; k < 3; k++) {
/*     */       
/* 408 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 410 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 412 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 413 */           if (bid == Blocks.MOB_SPAWNER) {
/* 414 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 415 */             tileentitymobspawner = (TileEntityMobSpawner)this.world.getTileEntity(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k));
/* 416 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getSpawnerEntity().getName();
/* 417 */             if (s != null && 
/* 418 */               s.equals("Pointysaurus")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 424 */     if (!isValidLightLevel()) return false; 
/* 425 */     if (this.posY < 50.0D) return false; 
/* 426 */     if (this.world.isDaytime()) return false;
/*     */ 
/*     */ 
/*     */     
/* 430 */     for (k = -1; k < 1; k++) {
/*     */       
/* 432 */       for (int j = -1; j < 1; j++) {
/*     */         
/* 434 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 436 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 437 */           if (bid != Blocks.AIR) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/* 442 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\entity\Pointysaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */