/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.init.ModItems;
/*     */ import danger.orespawn.util.ai.MyEntityAIWanderALot;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.DamageSource;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Cryolophosaurus
/*     */   extends EntityMob
/*     */ {
/*  50 */   private float moveSpeed = 0.25F;
/*     */ 
/*     */   
/*     */   public Cryolophosaurus(World par1World) {
/*  54 */     super(par1World);
/*  55 */     setSize(0.75F, 0.75F);
/*     */     
/*  57 */     this.experienceValue = 10;
/*     */     
/*  59 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  60 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.350000023841858D));
/*  61 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  62 */     this.tasks.addTask(3, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D));
/*  63 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  64 */     this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  65 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  70 */     super.applyEntityAttributes();
/*  71 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  72 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  73 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
/*     */   }
/*     */   
/*     */   protected void entityInit() {
/*  77 */     super.entityInit();
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  81 */     if (isNoDespawnRequired()) return false; 
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   public int mygetMaxHealth() {
/*  86 */     return 45;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/*  93 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 108 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 115 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/* 116 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getAmbientSound() {
/* 121 */     if (this.rand.nextInt(6) == 0) {
/* 122 */       return SoundsHandler.ENTITY_CRYO_LIVING;
/*     */     }
/* 124 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getHurtSound(DamageSource source) {
/* 129 */     return SoundsHandler.ENTITY_CRYO_HURT;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 134 */     return SoundsHandler.ENTITY_CRYO_DEATH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 141 */     return 0.75F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 148 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 157 */     int i = this.world.rand.nextInt(10);
/* 158 */     if (i == 0) return Items.CHICKEN; 
/* 159 */     if (i == 1) return ModItems.URANIUM_NUGGET; 
/* 160 */     if (i == 2) return ModItems.TITANIUM_NUGGET; 
/* 161 */     return null;
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
/* 174 */     return false;
/*     */   }
/*     */   
/*     */   protected void updateAITasks() {
/* 178 */     if (this.isDead)
/* 179 */       return;  super.updateAITasks();
/* 180 */     if (this.world.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 181 */     if (this.world.rand.nextInt(5) == 1) {
/* 182 */       EntityLivingBase e = findSomethingToAttack();
/* 183 */       if (e != null) {
/* 184 */         getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/* 185 */         if (getDistanceSq((Entity)e) < 5.0D)
/*     */         {
/* 187 */           if (this.rand.nextInt(12) == 0 || this.rand.nextInt(14) == 1)
/*     */           {
/* 189 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 201 */     if (par1EntityLiving == null) {
/* 202 */       return false;
/*     */     }
/* 204 */     if (par1EntityLiving == this) {
/* 205 */       return false;
/*     */     }
/* 207 */     if (!par1EntityLiving.isEntityAlive()) {
/* 208 */       return false;
/*     */     }
/* 210 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving)) {
/* 211 */       return false;
/*     */     }
/* 213 */     if (par1EntityLiving instanceof Alosaurus) {
/* 214 */       return false;
/*     */     }
/* 216 */     if (par1EntityLiving instanceof TRex) {
/* 217 */       return false;
/*     */     }
/* 219 */     if (par1EntityLiving instanceof Cryolophosaurus) {
/* 220 */       return false;
/*     */     }
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
/* 239 */     if (par1EntityLiving instanceof Ant) {
/* 240 */       return false;
/*     */     }
/* 242 */     if (par1EntityLiving instanceof RedAnt) {
/* 243 */       return false;
/*     */     }
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
/* 261 */     if (par1EntityLiving instanceof EntityPlayer) {
/* 262 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 263 */       return !p.capabilities.isCreativeMode;
/*     */     } 
/*     */     
/* 266 */     return true;
/*     */   }
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 270 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 271 */     List var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(9.0D, 2.0D, 9.0D));
/*     */     
/* 273 */     Iterator<Entity> var2 = var5.iterator();
/* 274 */     Entity var3 = null;
/* 275 */     EntityLivingBase var4 = null;
/*     */     
/* 277 */     while (var2.hasNext()) {
/* 278 */       var3 = var2.next();
/* 279 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 281 */       if (isSuitableTarget(var4, false)) {
/* 282 */         return var4;
/*     */       }
/*     */     } 
/* 285 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 295 */     if (!isValidLightLevel()) return false; 
/* 296 */     if (this.world.isDaytime() && this.posY > 50.0D) return false;
/*     */ 
/*     */ 
/*     */     
/* 300 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\Cryolophosaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */