/*     */ package danger.orespawn.entity;
/*     */ import danger.orespawn.util.ai.MyEntityAIWander;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class Cassowary extends EntityAnimal {
/*  24 */   private float moveSpeed = 0.25F;
/*     */ 
/*     */   
/*     */   public Cassowary(World par1World) {
/*  28 */     super(par1World);
/*     */     
/*  30 */     setSize(0.5F, 1.2F);
/*  31 */     this.moveSpeed = 0.25F;
/*     */     
/*  33 */     this.experienceValue = 5;
/*     */     
/*  35 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  36 */     this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  37 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.399999976158142D));
/*  38 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 8.0F, 1.0D, 1.399999976158142D));
/*  39 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D));
/*  40 */     this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 12.0F));
/*  41 */     this.tasks.addTask(6, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 1.0F));
/*  42 */     this.tasks.addTask(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public EntityAgeable createChild(EntityAgeable ageable) {
/*  48 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  54 */     super.applyEntityAttributes();
/*  55 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  56 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  57 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
/*  58 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  67 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  68 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAIDisabled() {
/*  73 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/*  79 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  84 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/*  90 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/*  96 */     return SoundsHandler.ENTITY_DUCK_HURT;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDeath(DamageSource cause) {
/* 101 */     super.onDeath(cause);
/* 102 */     playSound(SoundsHandler.ENTITY_DUCK_HURT, getSoundVolume(), getSoundPitch());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 110 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 119 */     return Items.CHICKEN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 128 */     int var3 = 0;
/* 129 */     var3 = this.rand.nextInt(3);
/* 130 */     var3 += 2;
/* 131 */     for (int var4 = 0; var4 < var3; var4++)
/*     */     {
/* 133 */       dropItem(Items.CHICKEN, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 140 */     if (this.world.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 141 */     super.updateAITasks();
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
/*     */   public boolean getCanSpawnHere() {
/* 156 */     return this.world.isDaytime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 165 */     if (isChild())
/*     */     {
/* 167 */       return false;
/*     */     }
/* 169 */     if (isNoDespawnRequired()) return false; 
/* 170 */     return true;
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
/*     */   public Cassowary spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 182 */     return new Cassowary(this.world);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 192 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.APPLE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 202 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\Cassowary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */