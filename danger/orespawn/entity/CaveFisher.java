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
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.network.datasync.DataParameter;
/*     */ import net.minecraft.network.datasync.DataSerializers;
/*     */ import net.minecraft.network.datasync.EntityDataManager;
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
/*  60 */   private RenderInfo renderdata = new RenderInfo();
/*  61 */   private float moveSpeed = 0.2F;
/*  62 */   protected static final DataParameter<Byte> ATTACKING = EntityDataManager.createKey(CaveFisher.class, DataSerializers.BYTE);
/*     */ 
/*     */   
/*     */   public CaveFisher(World worldIn) {
/*  66 */     super(worldIn);
/*  67 */     setSize(1.35F, 0.75F);
/*     */     
/*  69 */     this.experienceValue = 10;
/*     */     
/*  71 */     this.isImmuneToFire = false;
/*     */     
/*  73 */     this.renderdata = new RenderInfo();
/*  74 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  75 */     this.tasks.addTask(1, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0D));
/*  76 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  77 */     this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  78 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
/*     */   }
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  82 */     super.applyEntityAttributes();
/*  83 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  84 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  85 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/*  90 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/*  95 */     this.renderdata.rf1 = r.rf1;
/*  96 */     this.renderdata.rf2 = r.rf2;
/*  97 */     this.renderdata.rf3 = r.rf3;
/*  98 */     this.renderdata.rf4 = r.rf4;
/*  99 */     this.renderdata.ri1 = r.ri1;
/* 100 */     this.renderdata.ri2 = r.ri2;
/* 101 */     this.renderdata.ri3 = r.ri3;
/* 102 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */   
/*     */   protected void entityInit() {
/* 106 */     super.entityInit();
/* 107 */     this.dataManager.register(ATTACKING, Byte.valueOf((byte)0));
/*     */     
/* 109 */     if (this.renderdata == null) {
/* 110 */       this.renderdata = new RenderInfo();
/*     */     }
/* 112 */     this.renderdata.rf1 = 0.0F;
/* 113 */     this.renderdata.rf2 = 0.0F;
/* 114 */     this.renderdata.rf3 = 0.0F;
/* 115 */     this.renderdata.rf4 = 0.0F;
/* 116 */     this.renderdata.ri1 = 0;
/* 117 */     this.renderdata.ri2 = 0;
/* 118 */     this.renderdata.ri3 = 0;
/* 119 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 123 */     return !isNoDespawnRequired();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 131 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/* 132 */     super.onUpdate();
/*     */   }
/*     */   
/*     */   public int mygetMaxHealth() {
/* 136 */     return 20;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 144 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 151 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 159 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 167 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 174 */     return "orespawn:cryo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 181 */     return SoundsHandler.ENTITY_ALOSAURUS_DEATH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 188 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 195 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 203 */     int i = this.world.rand.nextInt(6);
/* 204 */     if (i == 0) return Items.GOLD_NUGGET; 
/* 205 */     if (i == 1) return ModItems.URANIUM_NUGGET; 
/* 206 */     if (i == 2) return ModItems.TITANIUM_NUGGET; 
/* 207 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 214 */     return false;
/*     */   }
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 218 */     return super.attackEntityAsMob(par1Entity);
/*     */   }
/*     */   
/*     */   protected void updateAITasks() {
/* 222 */     if (this.isDead)
/* 223 */       return;  super.updateAITasks();
/* 224 */     if (this.world.rand.nextInt(8) == 0) {
/* 225 */       EntityLivingBase e = findSomethingToAttack();
/* 226 */       if (e != null) {
/* 227 */         if (getDistanceSq((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 228 */           setAttacking(1);
/*     */           
/* 230 */           if (this.world.rand.nextInt(7) == 0 || this.world.rand.nextInt(8) == 1)
/*     */           {
/* 232 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 235 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */         } 
/*     */       } else {
/* 238 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 248 */     boolean ret = false;
/* 249 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 250 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     }
/* 252 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 261 */     if (par1EntityLiving == null) {
/* 262 */       return false;
/*     */     }
/* 264 */     if (par1EntityLiving == this) {
/* 265 */       return false;
/*     */     }
/* 267 */     if (!par1EntityLiving.isEntityAlive()) {
/* 268 */       return false;
/*     */     }
/*     */     
/* 271 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/* 273 */       return false;
/*     */     }
/* 275 */     if (par1EntityLiving instanceof CaveFisher) {
/* 276 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 286 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 288 */       return false;
/*     */     }
/* 290 */     if (par1EntityLiving instanceof EntityPlayer) {
/* 291 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 292 */       if (p.capabilities.isCreativeMode == true) {
/* 293 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 297 */     return true;
/*     */   }
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 301 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 302 */     List var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(10.0D, 3.0D, 10.0D));
/*     */     
/* 304 */     Iterator<Entity> var2 = var5.iterator();
/* 305 */     Entity var3 = null;
/* 306 */     EntityLivingBase var4 = null;
/*     */     
/* 308 */     while (var2.hasNext()) {
/* 309 */       var3 = var2.next();
/* 310 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 312 */       if (isSuitableTarget(var4, false)) {
/* 313 */         return var4;
/*     */       }
/*     */     } 
/* 316 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 321 */     return ((Byte)this.dataManager.get(ATTACKING)).byteValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 326 */     this.dataManager.set(ATTACKING, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 335 */     int sc = 0;
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
/* 352 */     if (!isValidLightLevel()) return false; 
/* 353 */     if (this.posY > 50.0D) return false; 
/* 354 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\CaveFisher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */