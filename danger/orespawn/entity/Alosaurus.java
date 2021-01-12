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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Alosaurus
/*     */   extends EntityMob
/*     */ {
/*  44 */   private float moveSpeed = 0.35F;
/*  45 */   protected static final DataParameter<Byte> ATTACKING = EntityDataManager.createKey(Alosaurus.class, DataSerializers.BYTE);
/*     */   
/*     */   public Alosaurus(World worldIn) {
/*  48 */     super(worldIn);
/*  49 */     setSize(1.9F, 3.6F);
/*     */     
/*  51 */     this.experienceValue = 40;
/*     */ 
/*     */ 
/*     */     
/*  55 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  56 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  57 */     this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  58 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  59 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  60 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  65 */     super.applyEntityAttributes();
/*  66 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  67 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  68 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(18.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  73 */     super.entityInit();
/*  74 */     this.dataManager.register(ATTACKING, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  78 */     if (isNoDespawnRequired()) return false; 
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  84 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  85 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  90 */     return 50;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/*  95 */     return 18;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 105 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getAmbientSound() {
/* 111 */     if (this.rand.nextInt(4) == 0) {
/* 112 */       return SoundsHandler.ENTITY_ALOSAURUS_LIVING;
/*     */     }
/* 114 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getHurtSound(DamageSource source) {
/* 120 */     return SoundsHandler.ENTITY_ALOSAURUS_HURT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 126 */     return SoundsHandler.ENTITY_ALOSAURUS_DEATH;
/*     */   }
/*     */   
/*     */   protected float getSoundVolume() {
/* 130 */     return 1.5F;
/*     */   }
/*     */   
/*     */   protected float getSoundPitch() {
/* 134 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 139 */     return Items.BEEF;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 144 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/* 145 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 151 */     for (var4 = 0; var4 < 10; var4++) {
/* 152 */       dropItemRand(Items.GOLD_NUGGET, 1);
/*     */     }
/* 154 */     for (var4 = 0; var4 < 6; var4++) {
/* 155 */       dropItemRand(Items.BEEF, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 163 */     return false;
/*     */   }
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 167 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 169 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 171 */         double ks = 1.2D;
/* 172 */         double inair = 0.1D;
/* 173 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 174 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 175 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 177 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 181 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 186 */     if (this.isDead)
/* 187 */       return;  super.updateAITasks();
/* 188 */     if (this.world.rand.nextInt(5) == 0) {
/* 189 */       EntityLivingBase e = findSomethingToAttack();
/* 190 */       if (e != null) {
/* 191 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 192 */         if (getDistanceSq((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 193 */           setAttacking(1);
/*     */           
/* 195 */           if (this.world.rand.nextInt(4) == 0 || this.world.rand.nextInt(5) == 1)
/*     */           {
/* 197 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 200 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 203 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 212 */     if (par1EntityLiving == null)
/*     */     {
/* 214 */       return false;
/*     */     }
/* 216 */     if (par1EntityLiving == this)
/*     */     {
/* 218 */       return false;
/*     */     }
/* 220 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 222 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 227 */     if (par1EntityLiving instanceof Alosaurus)
/*     */     {
/* 229 */       return false;
/*     */     }
/*     */     
/* 232 */     if (par1EntityLiving instanceof Cryolophosaurus)
/*     */     {
/* 234 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 242 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 245 */       return false;
/*     */     }
/*     */     
/* 248 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 250 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 251 */       if (p.capabilities.isCreativeMode == true) {
/* 252 */         return false;
/*     */       }
/* 254 */       return true;
/*     */     } 
/*     */     
/* 257 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 262 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 263 */     List var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(12.0D, 5.0D, 12.0D));
/*     */     
/* 265 */     Iterator<Entity> var2 = var5.iterator();
/* 266 */     Entity var3 = null;
/* 267 */     EntityLivingBase var4 = null;
/*     */     
/* 269 */     while (var2.hasNext()) {
/*     */       
/* 271 */       var3 = var2.next();
/* 272 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 274 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 276 */         return var4;
/*     */       }
/*     */     } 
/* 279 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAttacking() {
/* 284 */     return Byte.valueOf(((Byte)this.dataManager.get(ATTACKING)).byteValue()).byteValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAttacking(int par1) {
/* 289 */     this.dataManager.set(ATTACKING, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/*     */     int k;
/* 298 */     for (k = -3; k < 3; k++) {
/*     */       
/* 300 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 302 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 304 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 305 */           if (bid == Blocks.MOB_SPAWNER) {
/* 306 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 307 */             tileentitymobspawner = (TileEntityMobSpawner)this.world.getTileEntity(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k));
/* 308 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getSpawnerEntity().getName();
/* 309 */             if (s != null && 
/* 310 */               s.equals("Alosaurus")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 316 */     if (!isValidLightLevel()) return false; 
/* 317 */     if (this.posY < 50.0D) return false; 
/* 318 */     if (this.world.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 322 */     for (k = -1; k < 1; k++) {
/*     */       
/* 324 */       for (int j = -1; j < 1; j++) {
/*     */         
/* 326 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 328 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 329 */           if (bid != Blocks.AIR) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 335 */     Alosaurus target = null;
/* 336 */     target = (Alosaurus)this.world.findNearestEntityWithinAABB(Alosaurus.class, getEntityBoundingBox().expand(16.0D, 8.0D, 16.0D), (Entity)this);
/* 337 */     if (target != null)
/*     */     {
/* 339 */       return false;
/*     */     }
/* 341 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\entity\Alosaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */