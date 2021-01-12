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
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.network.datasync.DataParameter;
/*     */ import net.minecraft.network.datasync.DataSerializers;
/*     */ import net.minecraft.network.datasync.EntityDataManager;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CaveFisher
/*     */   extends EntityMob
/*     */ {
/*  63 */   private float moveSpeed = 0.2F;
/*  64 */   protected static final DataParameter<Byte> ATTACKING = EntityDataManager.createKey(CaveFisher.class, DataSerializers.BYTE);
/*     */ 
/*     */ 
/*     */   
/*     */   public CaveFisher(World worldIn) {
/*  69 */     super(worldIn);
/*  70 */     setSize(1.35F, 0.75F);
/*     */     
/*  72 */     this.experienceValue = 10;
/*     */     
/*  74 */     this.isImmuneToFire = false;
/*     */ 
/*     */     
/*  77 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  78 */     this.tasks.addTask(1, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0D));
/*  79 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  80 */     this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  81 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  86 */     super.applyEntityAttributes();
/*  87 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  88 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  89 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  94 */     super.entityInit();
/*  95 */     this.dataManager.register(ATTACKING, Byte.valueOf((byte)0));
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
/*     */   protected boolean canDespawn() {
/* 111 */     return !isNoDespawnRequired();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 120 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/* 121 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 126 */     return 20;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 136 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 144 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 153 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 162 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 170 */     return "orespawn:cryo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 178 */     return SoundsHandler.ENTITY_ALOSAURUS_DEATH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 185 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 192 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 201 */     int i = this.world.rand.nextInt(6);
/* 202 */     if (i == 0) return Items.GOLD_NUGGET; 
/* 203 */     if (i == 1) return ModItems.URANIUM_NUGGET; 
/* 204 */     if (i == 2) return ModItems.TITANIUM_NUGGET; 
/* 205 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 213 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 218 */     return super.attackEntityAsMob(par1Entity);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 223 */     if (this.isDead)
/* 224 */       return;  super.updateAITasks();
/* 225 */     if (this.world.rand.nextInt(8) == 0) {
/* 226 */       EntityLivingBase e = findSomethingToAttack();
/* 227 */       if (e != null) {
/* 228 */         if (getDistanceSq((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 229 */           setAttacking(1);
/*     */           
/* 231 */           if (this.world.rand.nextInt(7) == 0 || this.world.rand.nextInt(8) == 1)
/*     */           {
/* 233 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 236 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */         } 
/*     */       } else {
/* 239 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 250 */     boolean ret = false;
/* 251 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 252 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     }
/* 254 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 264 */     if (par1EntityLiving == null)
/*     */     {
/* 266 */       return false;
/*     */     }
/* 268 */     if (par1EntityLiving == this)
/*     */     {
/* 270 */       return false;
/*     */     }
/* 272 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 274 */       return false;
/*     */     }
/*     */     
/* 277 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 280 */       return false;
/*     */     }
/* 282 */     if (par1EntityLiving instanceof CaveFisher)
/*     */     {
/* 284 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 294 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 296 */       return false;
/*     */     }
/* 298 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 300 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 301 */       if (p.capabilities.isCreativeMode == true) {
/* 302 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 306 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 311 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 312 */     List var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(10.0D, 3.0D, 10.0D));
/*     */     
/* 314 */     Iterator<Entity> var2 = var5.iterator();
/* 315 */     Entity var3 = null;
/* 316 */     EntityLivingBase var4 = null;
/*     */     
/* 318 */     while (var2.hasNext()) {
/*     */       
/* 320 */       var3 = var2.next();
/* 321 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 323 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 325 */         return var4;
/*     */       }
/*     */     } 
/* 328 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 334 */     return ((Byte)this.dataManager.get(ATTACKING)).byteValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 340 */     this.dataManager.set(ATTACKING, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 350 */     int sc = 0;
/*     */     
/* 352 */     for (int k = -2; k < 2; k++) {
/*     */       
/* 354 */       for (int j = -2; j < 2; j++) {
/*     */         
/* 356 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 358 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 359 */           if (bid == Blocks.MOB_SPAWNER) {
/* 360 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 361 */             tileentitymobspawner = (TileEntityMobSpawner)this.world.getTileEntity(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k));
/* 362 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getSpawnerEntity().getName();
/* 363 */             if (s != null && 
/* 364 */               s.equals("CaveFisher")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 370 */     if (!isValidLightLevel()) return false; 
/* 371 */     if (this.posY > 50.0D) return false; 
/* 372 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespawn\entity\CaveFisher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */