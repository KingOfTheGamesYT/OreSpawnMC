/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.init.ModItems;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntitySmallFireball;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.SoundEvent;
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
/*     */ public class Kyuubi
/*     */   extends EntityMob
/*     */ {
/*  52 */   private GenericTargetSorter TargetSorter = null;
/*  53 */   private float moveSpeed = 0.25F;
/*     */   
/*     */   public Kyuubi(World par1World) {
/*  56 */     super(par1World);
/*  57 */     setSize(0.5F, 1.25F);
/*  58 */     this.experienceValue = 30;
/*  59 */     this.isImmuneToFire = true;
/*  60 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  61 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.350000023841858D));
/*  62 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  63 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
/*  64 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F));
/*  65 */     this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  66 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
/*  67 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  71 */     super.applyEntityAttributes();
/*  72 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  73 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  74 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  78 */     return !isNoDespawnRequired();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  86 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  87 */     super.onUpdate();
/*     */   }
/*     */   
/*     */   public int mygetMaxHealth() {
/*  91 */     return 125;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/*  99 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAIDisabled() {
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 113 */     super.onLivingUpdate();
/* 114 */     if (this.world.rand.nextInt(10) == 1) {
/* 115 */       this.world.spawnParticle(EnumParticleTypes.REDSTONE, this.posX, this.posY + 2.0D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/* 116 */       this.world.spawnParticle(EnumParticleTypes.LAVA, this.posX, this.posY + 2.0D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/* 117 */       setFire(5);
/* 118 */       if (isInWater()) {
/* 119 */         attackEntityAsMob((Entity)this);
/* 120 */         this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 1.75D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/* 121 */         this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY + 1.75D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/* 122 */         this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 2.0D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/* 123 */         this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY + 2.0D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAttackStrength(Entity par1Entity) {
/* 133 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/* 139 */     return SoundsHandler.ENTITY_KYUUBI_LIVING;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/* 144 */     return SoundsHandler.ENTITY_ALOSAURUS_HURT;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDeath(DamageSource cause) {
/* 149 */     playSound(SoundsHandler.ENTITY_ALOSAURUS_DEATH, getSoundVolume(), getSoundPitch());
/*     */   }
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 154 */     return 0.75F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 159 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 166 */     int i = this.world.rand.nextInt(6);
/* 167 */     if (i == 0) return Items.GOLD_NUGGET; 
/* 168 */     if (i == 1) return ModItems.URANIUM_NUGGET; 
/* 169 */     if (i == 2) return ModItems.TITANIUM_NUGGET; 
/* 170 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 176 */     if (this.isDead)
/* 177 */       return;  if (this.world.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 178 */     super.updateAITasks();
/* 179 */     if (this.world.rand.nextInt(10) == 1) {
/* 180 */       EntityLivingBase e = findSomethingToAttack();
/* 181 */       if (e != null) {
/* 182 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 183 */         getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/* 184 */         if (getDistanceSq((Entity)e) < 64.0D)
/*     */         {
/* 186 */           if (this.rand.nextInt(6) == 0 || this.rand.nextInt(8) == 1) {
/*     */ 
/*     */             
/* 189 */             EntitySmallFireball var2 = new EntitySmallFireball(this.world, (EntityLivingBase)this, e.posX - this.posX, e.posY + 0.75D - this.posY + 1.25D, e.posZ - this.posZ);
/* 190 */             var2.setLocationAndAngles(this.posX, this.posY + 1.25D, this.posZ, this.rotationYaw, this.rotationPitch);
/* 191 */             playSound(SoundEvents.ENTITY_ARROW_SHOOT, 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 192 */             this.world.spawnEntity((Entity)var2);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttackTarget(@Nullable EntityLivingBase par1EntityLiving) {
/* 202 */     if (par1EntityLiving == null) {
/*     */       return;
/*     */     }
/* 205 */     if (par1EntityLiving == this) {
/*     */       return;
/*     */     }
/* 208 */     if (!par1EntityLiving.isEntityAlive()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 214 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving)) {
/*     */       return;
/*     */     }
/*     */     
/* 218 */     if (par1EntityLiving instanceof EntityMob) {
/*     */       return;
/*     */     }
/*     */     
/* 222 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityPigZombie) {
/*     */       return;
/*     */     }
/* 225 */     if (par1EntityLiving instanceof EntityPlayer) {
/* 226 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 227 */       if (p.capabilities.isCreativeMode) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */     
/* 232 */     super.setAttackTarget(par1EntityLiving);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 242 */     if (par1EntityLiving == null)
/*     */     {
/* 244 */       return false;
/*     */     }
/* 246 */     if (par1EntityLiving == this)
/*     */     {
/* 248 */       return false;
/*     */     }
/* 250 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 252 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 257 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 260 */       return false;
/*     */     }
/* 262 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 264 */       return false;
/*     */     }
/*     */     
/* 267 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityPigZombie)
/*     */     {
/* 269 */       return false;
/*     */     }
/* 271 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 273 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 274 */       if (p.capabilities.isCreativeMode) {
/* 275 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 279 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 284 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 285 */     List<?> var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(12.0D, 4.0D, 12.0D));
/* 286 */     Collections.sort(var5, this.TargetSorter);
/* 287 */     Iterator<?> var2 = var5.iterator();
/* 288 */     Entity var3 = null;
/* 289 */     EntityLivingBase var4 = null;
/*     */     
/* 291 */     while (var2.hasNext()) {
/*     */       
/* 293 */       var3 = (Entity)var2.next();
/* 294 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 296 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 298 */         return var4;
/*     */       }
/*     */     } 
/* 301 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 308 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 313 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/* 314 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 322 */     for (var4 = 0; var4 < 10; var4++) {
/* 323 */       dropItemRand(Items.COAL, 1);
/*     */     }
/* 325 */     for (var4 = 0; var4 < 3; var4++) {
/* 326 */       dropItemRand(Item.getItemFromBlock(Blocks.REDSTONE_BLOCK), 1);
/*     */     }
/* 328 */     for (var4 = 0; var4 < 4; var4++)
/* 329 */       dropItemRand(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK), 1); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\Kyuubi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */