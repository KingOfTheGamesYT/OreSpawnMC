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
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class TRex
/*     */   extends EntityMob
/*     */ {
/*  39 */   private float moveSpeed = 0.38F;
/*  40 */   private EntityLivingBase rt = null;
/*  41 */   protected static final DataParameter<Byte> ATTACKING = EntityDataManager.createKey(Alosaurus.class, DataSerializers.BYTE);
/*     */   
/*     */   public TRex(World par1World) {
/*  44 */     super(par1World);
/*  45 */     setSize(2.0F, 4.2F);
/*     */     
/*  47 */     this.experienceValue = 150;
/*     */ 
/*     */ 
/*     */     
/*  51 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  52 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  53 */     this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  54 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  55 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  56 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
/*     */   }
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  60 */     super.applyEntityAttributes();
/*  61 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  62 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  63 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
/*     */   }
/*     */   
/*     */   protected void entityInit() {
/*  67 */     super.entityInit();
/*  68 */     this.dataManager.register(ATTACKING, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  72 */     if (isNoDespawnRequired()) return false; 
/*  73 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  80 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  81 */     super.onUpdate();
/*     */   }
/*     */   
/*     */   public int mygetMaxHealth() {
/*  85 */     return 30;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/*  92 */     return 12;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/*  99 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 107 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getAmbientSound() {
/* 116 */     if (this.rand.nextInt(4) == 0) {
/* 117 */       return SoundsHandler.ENTITY_TREX_AMBIENT;
/*     */     }
/* 119 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getHurtSound(DamageSource source) {
/* 124 */     return SoundsHandler.ENTITY_ALOSAURUS_HURT;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 129 */     return SoundsHandler.ENTITY_TREX_DEATH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 136 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 143 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 151 */     return Items.BEEF;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 156 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/* 157 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 163 */     dropItemRand(ModItems.TREX_TOOTH, 1);
/* 164 */     dropItemRand(Items.ITEM_FRAME, 1);
/*     */     int var4;
/* 166 */     for (var4 = 0; var4 < 7; var4++) {
/* 167 */       dropItemRand(Items.BEEF, 1);
/*     */     }
/* 169 */     var4 = 2 + this.world.rand.nextInt(4);
/* 170 */     for (int i = 0; i < var4; i++) {
/* 171 */       dropItemRand(ModItems.URANIUM_NUGGET, 1);
/* 172 */       dropItemRand(ModItems.TITANIUM_NUGGET, 1);
/*     */     } 
/*     */   }
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
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 186 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 191 */     if (super.attackEntityAsMob(par1Entity)) {
/* 192 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/* 193 */         double ks = 1.2D;
/* 194 */         double inair = 0.1D;
/* 195 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 196 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 197 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 199 */       return true;
/*     */     } 
/* 201 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 209 */     boolean ret = false;
/*     */     
/* 211 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*     */       
/* 213 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 214 */       Entity e = par1DamageSource.getImmediateSource();
/*     */       
/* 216 */       if (e != null && e instanceof EntityLivingBase) {
/* 217 */         this.rt = (EntityLivingBase)e;
/*     */       }
/*     */     } 
/* 220 */     return ret;
/*     */   }
/*     */   
/*     */   protected void updateAITasks() {
/* 224 */     if (this.isDead)
/* 225 */       return;  super.updateAITasks();
/* 226 */     if (this.world.rand.nextInt(5) == 1) {
/* 227 */       EntityLivingBase e = null;
/* 228 */       e = this.rt;
/* 229 */       if (OreSpawnMain.PlayNicely != 0) e = null; 
/* 230 */       if (e != null) {
/* 231 */         if (e.isDead || this.world.rand.nextInt(200) == 1) {
/* 232 */           e = null;
/* 233 */           this.rt = null;
/*     */         } 
/* 235 */         if (e != null && 
/* 236 */           !getEntitySenses().canSee((Entity)e)) {
/* 237 */           e = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 242 */       if (e == null) {
/* 243 */         e = findSomethingToAttack();
/*     */       }
/* 245 */       if (e != null) {
/* 246 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 247 */         if (getDistanceSq((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 248 */           setAttacking(1);
/*     */           
/* 250 */           if (this.world.rand.nextInt(4) == 0 || this.world.rand.nextInt(5) == 1)
/*     */           {
/* 252 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 255 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 258 */         setAttacking(0);
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
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 270 */     if (par1EntityLiving == null) {
/* 271 */       return false;
/*     */     }
/* 273 */     if (par1EntityLiving == this) {
/* 274 */       return false;
/*     */     }
/* 276 */     if (!par1EntityLiving.isEntityAlive()) {
/* 277 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 282 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/* 284 */       return false;
/*     */     }
/* 286 */     if (par1EntityLiving instanceof TRex) {
/* 287 */       return false;
/*     */     }
/* 289 */     if (par1EntityLiving instanceof Cryolophosaurus) {
/* 290 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 297 */     if (par1EntityLiving instanceof EntityPlayer) {
/* 298 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 299 */       if (p.capabilities.isCreativeMode == true) {
/* 300 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 304 */     return true;
/*     */   }
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 308 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 309 */     List var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(20.0D, 6.0D, 20.0D));
/*     */     
/* 311 */     Iterator<Entity> var2 = var5.iterator();
/* 312 */     Entity var3 = null;
/* 313 */     EntityLivingBase var4 = null;
/*     */     
/* 315 */     while (var2.hasNext()) {
/* 316 */       var3 = var2.next();
/* 317 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 319 */       if (isSuitableTarget(var4, false)) {
/* 320 */         return var4;
/*     */       }
/*     */     } 
/* 323 */     return null;
/*     */   }
/*     */   
/*     */   public int getAttacking() {
/* 327 */     return Byte.valueOf(((Byte)this.dataManager.get(ATTACKING)).byteValue()).byteValue();
/*     */   }
/*     */   
/*     */   public void setAttacking(int par1) {
/* 331 */     this.dataManager.set(ATTACKING, Byte.valueOf((byte)par1));
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
/*     */   public boolean getCanSpawnHere() {
/* 356 */     if (!isValidLightLevel()) return false; 
/* 357 */     if (this.posY < 50.0D) return false; 
/* 358 */     if (this.world.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 362 */     for (int k = -1; k <= 1; k++) {
/* 363 */       for (int j = -1; j <= 1; j++) {
/* 364 */         for (int i = 1; i < 6; i++) {
/* 365 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 366 */           if (bid != Blocks.AIR) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 372 */     TRex target = null;
/* 373 */     target = (TRex)this.world.findNearestEntityWithinAABB(TRex.class, getEntityBoundingBox().expand(24.0D, 12.0D, 24.0D), (Entity)this);
/* 374 */     if (target != null) {
/* 375 */       return false;
/*     */     }
/* 377 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\TRex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */