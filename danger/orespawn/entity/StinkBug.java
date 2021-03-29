/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.util.ai.MyEntityAIWanderALot;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAIMoveIndoors;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class StinkBug extends EntityAnimal {
/*  35 */   private float moveSpeed = 0.15F;
/*     */ 
/*     */   
/*     */   public StinkBug(World par1World) {
/*  39 */     super(par1World);
/*     */     
/*  41 */     setSize(0.55F, 0.55F);
/*     */ 
/*     */     
/*  44 */     this.experienceValue = 2;
/*  45 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  46 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMate(this, 1.0D));
/*  47 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D));
/*  48 */     this.tasks.addTask(5, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 4.0F, 1.0D, 1.399999976158142D));
/*  49 */     this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*  50 */     this.tasks.addTask(8, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D));
/*  51 */     this.tasks.addTask(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  52 */     this.tasks.addTask(10, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  58 */     super.applyEntityAttributes();
/*  59 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  60 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  61 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
/*  62 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  68 */     super.entityInit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  78 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  79 */     super.onUpdate();
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
/*     */   protected void updateAITasks() {
/*  97 */     if (this.isDead)
/*  98 */       return;  if (this.world.rand.nextInt(200) == 1) setRevengeTarget(null); 
/*  99 */     super.updateAITasks();
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
/*     */   public boolean isAIDisabled() {
/* 112 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 122 */     boolean ret = false;
/*     */     
/* 124 */     if (this.isDead) return false;
/*     */     
/* 126 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */ 
/*     */     
/* 129 */     if (getHealth() <= 0.0F || this.isDead) {
/* 130 */       AxisAlignedBB bb = getEntityBoundingBox().expand(8.0D, 5.0D, 8.0D);
/*     */ 
/*     */       
/* 133 */       List var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, bb);
/* 134 */       Iterator<EntityLivingBase> var2 = var5.iterator();
/* 135 */       EntityLivingBase var3 = null;
/*     */       
/* 137 */       while (var2.hasNext()) {
/*     */         
/* 139 */         var3 = var2.next();
/* 140 */         if (var3 != null)
/*     */         {
/*     */           
/* 143 */           var3.addPotionEffect(new PotionEffect(Objects.<Potion>requireNonNull(Potion.getPotionById(9)), 300, 0));
/*     */         }
/*     */       } 
/*     */     } 
/* 147 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 153 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 158 */     return 5;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/* 164 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/* 170 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDeath(DamageSource cause) {
/* 175 */     super.onDeath(cause);
/* 176 */     switch (this.rand.nextInt(9) + 1) { case 1:
/* 177 */         playSound(SoundsHandler.ENTITY_STINKBUG_FART1, getSoundVolume(), getSoundPitch()); break;
/* 178 */       case 2: playSound(SoundsHandler.ENTITY_STINKBUG_FART2, getSoundVolume(), getSoundPitch()); break;
/* 179 */       case 3: playSound(SoundsHandler.ENTITY_STINKBUG_FART3, getSoundVolume(), getSoundPitch()); break;
/* 180 */       case 4: playSound(SoundsHandler.ENTITY_STINKBUG_FART4, getSoundVolume(), getSoundPitch()); break;
/* 181 */       case 5: playSound(SoundsHandler.ENTITY_STINKBUG_FART5, getSoundVolume(), getSoundPitch()); break;
/* 182 */       case 6: playSound(SoundsHandler.ENTITY_STINKBUG_FART6, getSoundVolume(), getSoundPitch()); break;
/* 183 */       case 7: playSound(SoundsHandler.ENTITY_STINKBUG_FART7, getSoundVolume(), getSoundPitch()); break;
/* 184 */       case 8: playSound(SoundsHandler.ENTITY_STINKBUG_FART8, getSoundVolume(), getSoundPitch()); break;
/* 185 */       case 9: playSound(SoundsHandler.ENTITY_STINKBUG_FART9, getSoundVolume(), getSoundPitch());
/*     */         break; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 195 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 204 */     return null;
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
/*     */   public boolean getCanSpawnHere() {
/* 233 */     if (this.posY < 50.0D) return false; 
/* 234 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 243 */     if (isChild())
/*     */     {
/* 245 */       return false;
/*     */     }
/* 247 */     if (isNoDespawnRequired()) return false; 
/* 248 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 253 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public StinkBug spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 259 */     return new StinkBug(this.world);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 267 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.FISH);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 276 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\StinkBug.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */