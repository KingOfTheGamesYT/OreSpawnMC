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
/*     */ 
/*     */   
/*     */   public Cryolophosaurus(World par1World) {
/*  56 */     super(par1World);
/*  57 */     setSize(0.75F, 0.75F);
/*     */     
/*  59 */     this.experienceValue = 10;
/*     */     
/*  61 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  62 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.350000023841858D));
/*  63 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  64 */     this.tasks.addTask(3, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D));
/*  65 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  66 */     this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  67 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  73 */     super.applyEntityAttributes();
/*  74 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  75 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  76 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  81 */     super.entityInit();
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  85 */     if (isNoDespawnRequired()) return false; 
/*  86 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  91 */     return 45;
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 116 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 124 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/* 125 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getAmbientSound() {
/* 131 */     if (this.rand.nextInt(6) == 0) {
/* 132 */       return SoundsHandler.ENTITY_CRYO_LIVING;
/*     */     }
/* 134 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getHurtSound(DamageSource source) {
/* 140 */     return SoundsHandler.ENTITY_CRYO_HURT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 146 */     return SoundsHandler.ENTITY_CRYO_DEATH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 153 */     return 0.75F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 160 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 170 */     int i = this.world.rand.nextInt(10);
/* 171 */     if (i == 0) return Items.CHICKEN; 
/* 172 */     if (i == 1) return ModItems.URANIUMNUGGET; 
/* 173 */     if (i == 2) return ModItems.TITANIUMNUGGET; 
/* 174 */     return null;
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
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 189 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 194 */     if (this.isDead)
/* 195 */       return;  super.updateAITasks();
/* 196 */     if (this.world.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 197 */     if (this.world.rand.nextInt(5) == 1) {
/* 198 */       EntityLivingBase e = findSomethingToAttack();
/* 199 */       if (e != null) {
/* 200 */         getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/* 201 */         if (getDistanceSq((Entity)e) < 5.0D)
/*     */         {
/* 203 */           if (this.rand.nextInt(12) == 0 || this.rand.nextInt(14) == 1)
/*     */           {
/* 205 */             attackEntityAsMob((Entity)e);
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
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 220 */     if (par1EntityLiving == null)
/*     */     {
/* 222 */       return false;
/*     */     }
/* 224 */     if (par1EntityLiving == this)
/*     */     {
/* 226 */       return false;
/*     */     }
/* 228 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 230 */       return false;
/*     */     }
/* 232 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 235 */       return false;
/*     */     }
/* 237 */     if (par1EntityLiving instanceof Alosaurus)
/*     */     {
/* 239 */       return false;
/*     */     }
/* 241 */     if (par1EntityLiving instanceof TRex)
/*     */     {
/* 243 */       return false;
/*     */     }
/* 245 */     if (par1EntityLiving instanceof Cryolophosaurus)
/*     */     {
/* 247 */       return false;
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
/* 266 */     if (par1EntityLiving instanceof Ant)
/*     */     {
/* 268 */       return false;
/*     */     }
/* 270 */     if (par1EntityLiving instanceof RedAnt)
/*     */     {
/* 272 */       return false;
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
/* 290 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 292 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 293 */       if (p.capabilities.isCreativeMode == true) {
/* 294 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 298 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 303 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 304 */     List var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(9.0D, 2.0D, 9.0D));
/*     */     
/* 306 */     Iterator<Entity> var2 = var5.iterator();
/* 307 */     Entity var3 = null;
/* 308 */     EntityLivingBase var4 = null;
/*     */     
/* 310 */     while (var2.hasNext()) {
/*     */       
/* 312 */       var3 = var2.next();
/* 313 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 315 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 317 */         return var4;
/*     */       }
/*     */     } 
/* 320 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 330 */     if (!isValidLightLevel()) return false; 
/* 331 */     if (this.world.isDaytime() == true && this.posY > 50.0D) return false;
/*     */ 
/*     */ 
/*     */     
/* 335 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\entity\Cryolophosaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */