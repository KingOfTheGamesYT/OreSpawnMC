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
/*     */ public class Alosaurus
/*     */   extends EntityMob
/*     */ {
/*  41 */   private float moveSpeed = 0.35F;
/*  42 */   protected static final DataParameter<Byte> ATTACKING = EntityDataManager.createKey(Alosaurus.class, DataSerializers.BYTE);
/*     */   
/*     */   public Alosaurus(World worldIn) {
/*  45 */     super(worldIn);
/*  46 */     setSize(1.9F, 3.6F);
/*     */     
/*  48 */     this.experienceValue = 40;
/*     */ 
/*     */ 
/*     */     
/*  52 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  53 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  54 */     this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  55 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  56 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  57 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  62 */     super.applyEntityAttributes();
/*  63 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  64 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  65 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(18.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  70 */     super.entityInit();
/*  71 */     this.dataManager.register(ATTACKING, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  75 */     return !isNoDespawnRequired();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  80 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  81 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  86 */     return 50;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/*  91 */     return 18;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/*  96 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 101 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getAmbientSound() {
/* 107 */     if (this.rand.nextInt(4) == 0) {
/* 108 */       return SoundsHandler.ENTITY_ALOSAURUS_LIVING;
/*     */     }
/* 110 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getHurtSound(DamageSource source) {
/* 116 */     return SoundsHandler.ENTITY_ALOSAURUS_HURT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 122 */     return SoundsHandler.ENTITY_ALOSAURUS_DEATH;
/*     */   }
/*     */   
/*     */   protected float getSoundVolume() {
/* 126 */     return 1.5F;
/*     */   }
/*     */   
/*     */   protected float getSoundPitch() {
/* 130 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 135 */     return Items.BEEF;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 140 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/* 141 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 147 */     for (var4 = 0; var4 < 10; var4++) {
/* 148 */       dropItemRand(Items.GOLD_NUGGET, 1);
/*     */     }
/* 150 */     for (var4 = 0; var4 < 6; var4++) {
/* 151 */       dropItemRand(Items.BEEF, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 159 */     return false;
/*     */   }
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 163 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 165 */       if (par1Entity instanceof EntityLivingBase) {
/*     */         
/* 167 */         double ks = 1.2D;
/* 168 */         double inair = 0.1D;
/* 169 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 170 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 171 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 173 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 177 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 182 */     if (this.isDead)
/* 183 */       return;  super.updateAITasks();
/* 184 */     if (this.world.rand.nextInt(5) == 0) {
/* 185 */       EntityLivingBase e = findSomethingToAttack();
/* 186 */       if (e != null) {
/* 187 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 188 */         if (getDistanceSq((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 189 */           setAttacking(1);
/*     */           
/* 191 */           if (this.world.rand.nextInt(4) == 0 || this.world.rand.nextInt(5) == 1)
/*     */           {
/* 193 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 196 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 199 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 208 */     if (par1EntityLiving == null)
/*     */     {
/* 210 */       return false;
/*     */     }
/* 212 */     if (par1EntityLiving == this)
/*     */     {
/* 214 */       return false;
/*     */     }
/* 216 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 218 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 223 */     if (par1EntityLiving instanceof Alosaurus)
/*     */     {
/* 225 */       return false;
/*     */     }
/*     */     
/* 228 */     if (par1EntityLiving instanceof Cryolophosaurus)
/*     */     {
/* 230 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 238 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 241 */       return false;
/*     */     }
/*     */     
/* 244 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 246 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 247 */       return !p.capabilities.isCreativeMode;
/*     */     } 
/*     */     
/* 250 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 255 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 256 */     List var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(12.0D, 5.0D, 12.0D));
/*     */     
/* 258 */     Iterator<Entity> var2 = var5.iterator();
/* 259 */     Entity var3 = null;
/* 260 */     EntityLivingBase var4 = null;
/*     */     
/* 262 */     while (var2.hasNext()) {
/*     */       
/* 264 */       var3 = var2.next();
/* 265 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 267 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 269 */         return var4;
/*     */       }
/*     */     } 
/* 272 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAttacking() {
/* 277 */     return ((Byte)this.dataManager.get(ATTACKING)).byteValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAttacking(int par1) {
/* 282 */     this.dataManager.set(ATTACKING, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/*     */     int k;
/* 291 */     for (k = -3; k < 3; k++) {
/*     */       
/* 293 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 295 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 297 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 298 */           if (bid == Blocks.MOB_SPAWNER) {
/* 299 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 300 */             tileentitymobspawner = (TileEntityMobSpawner)this.world.getTileEntity(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k));
/* 301 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getSpawnerEntity().getName();
/* 302 */             if (s != null && 
/* 303 */               s.equals("Alosaurus")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 309 */     if (!isValidLightLevel()) return false; 
/* 310 */     if (this.posY < 50.0D) return false; 
/* 311 */     if (this.world.isDaytime()) return false;
/*     */ 
/*     */ 
/*     */     
/* 315 */     for (k = -1; k < 1; k++) {
/*     */       
/* 317 */       for (int j = -1; j < 1; j++) {
/*     */         
/* 319 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 321 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 322 */           if (bid != Blocks.AIR) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 328 */     Alosaurus target = null;
/* 329 */     target = (Alosaurus)this.world.findNearestEntityWithinAABB(Alosaurus.class, getEntityBoundingBox().expand(16.0D, 8.0D, 16.0D), (Entity)this);
/* 330 */     return (target == null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\entity\Alosaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */