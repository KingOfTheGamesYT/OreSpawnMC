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
/*  40 */   private float moveSpeed = 0.35F;
/*  41 */   protected static final DataParameter<Byte> ATTACKING = EntityDataManager.createKey(Alosaurus.class, DataSerializers.BYTE);
/*     */   
/*     */   public Alosaurus(World worldIn) {
/*  44 */     super(worldIn);
/*  45 */     setSize(1.9F, 3.6F);
/*     */     
/*  47 */     this.experienceValue = 40;
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
/*  63 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(18.0D);
/*     */   }
/*     */   
/*     */   protected void entityInit() {
/*  67 */     super.entityInit();
/*  68 */     this.dataManager.register(ATTACKING, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  72 */     return !isNoDespawnRequired();
/*     */   }
/*     */   
/*     */   public void onUpdate() {
/*  76 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  77 */     super.onUpdate();
/*     */   }
/*     */   
/*     */   public int mygetMaxHealth() {
/*  81 */     return 50;
/*     */   }
/*     */   
/*     */   public int getTotalArmorValue() {
/*  85 */     return 18;
/*     */   }
/*     */   
/*     */   protected boolean isAIEnabled() {
/*  89 */     return true;
/*     */   }
/*     */   
/*     */   public void onLivingUpdate() {
/*  93 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getAmbientSound() {
/*  98 */     if (this.rand.nextInt(4) == 0) {
/*  99 */       return SoundsHandler.ENTITY_ALOSAURUS_LIVING;
/*     */     }
/* 101 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getHurtSound(DamageSource source) {
/* 106 */     return SoundsHandler.ENTITY_ALOSAURUS_HURT;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 111 */     return SoundsHandler.ENTITY_ALOSAURUS_DEATH;
/*     */   }
/*     */   
/*     */   protected float getSoundVolume() {
/* 115 */     return 1.5F;
/*     */   }
/*     */   
/*     */   protected float getSoundPitch() {
/* 119 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 124 */     return Items.BEEF;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 129 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/* 130 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 136 */     for (var4 = 0; var4 < 10; var4++) {
/* 137 */       dropItemRand(Items.GOLD_NUGGET, 1);
/*     */     }
/* 139 */     for (var4 = 0; var4 < 6; var4++) {
/* 140 */       dropItemRand(Items.BEEF, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 148 */     return false;
/*     */   }
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 152 */     if (super.attackEntityAsMob(par1Entity)) {
/* 153 */       if (par1Entity instanceof EntityLivingBase) {
/* 154 */         double ks = 1.2D;
/* 155 */         double inair = 0.1D;
/* 156 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 157 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 158 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 160 */       return true;
/*     */     } 
/* 162 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 167 */     if (this.isDead)
/* 168 */       return;  super.updateAITasks();
/* 169 */     if (this.world.rand.nextInt(5) == 0) {
/* 170 */       EntityLivingBase e = findSomethingToAttack();
/* 171 */       if (e != null) {
/* 172 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 173 */         if (getDistanceSq((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 174 */           setAttacking(1);
/*     */           
/* 176 */           if (this.world.rand.nextInt(4) == 0 || this.world.rand.nextInt(5) == 1)
/*     */           {
/* 178 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 181 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 184 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 192 */     if (par1EntityLiving == null) {
/* 193 */       return false;
/*     */     }
/* 195 */     if (par1EntityLiving == this) {
/* 196 */       return false;
/*     */     }
/* 198 */     if (!par1EntityLiving.isEntityAlive()) {
/* 199 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 204 */     if (par1EntityLiving instanceof Alosaurus) {
/* 205 */       return false;
/*     */     }
/*     */     
/* 208 */     if (par1EntityLiving instanceof Cryolophosaurus) {
/* 209 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 217 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/* 219 */       return false;
/*     */     }
/*     */     
/* 222 */     if (par1EntityLiving instanceof EntityPlayer) {
/* 223 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 224 */       return !p.capabilities.isCreativeMode;
/*     */     } 
/*     */     
/* 227 */     return true;
/*     */   }
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 231 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 232 */     List var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(12.0D, 5.0D, 12.0D));
/*     */     
/* 234 */     Iterator<Entity> var2 = var5.iterator();
/* 235 */     Entity var3 = null;
/* 236 */     EntityLivingBase var4 = null;
/*     */     
/* 238 */     while (var2.hasNext()) {
/* 239 */       var3 = var2.next();
/* 240 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 242 */       if (isSuitableTarget(var4, false)) {
/* 243 */         return var4;
/*     */       }
/*     */     } 
/* 246 */     return null;
/*     */   }
/*     */   
/*     */   public int getAttacking() {
/* 250 */     return ((Byte)this.dataManager.get(ATTACKING)).byteValue();
/*     */   }
/*     */   
/*     */   public void setAttacking(int par1) {
/* 254 */     this.dataManager.set(ATTACKING, Byte.valueOf((byte)par1));
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
/*     */   public boolean getCanSpawnHere() {
/* 277 */     if (!isValidLightLevel()) return false; 
/* 278 */     if (this.posY < 50.0D) return false; 
/* 279 */     if (this.world.isDaytime()) return false;
/*     */ 
/*     */ 
/*     */     
/* 283 */     for (int k = -1; k < 1; k++) {
/* 284 */       for (int j = -1; j < 1; j++) {
/* 285 */         for (int i = 1; i < 6; i++) {
/* 286 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 287 */           if (bid != Blocks.AIR) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 293 */     Alosaurus target = null;
/* 294 */     target = (Alosaurus)this.world.findNearestEntityWithinAABB(Alosaurus.class, getEntityBoundingBox().expand(16.0D, 8.0D, 16.0D), (Entity)this);
/* 295 */     return (target == null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\Alosaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */