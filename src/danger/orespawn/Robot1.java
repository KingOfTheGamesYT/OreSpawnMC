/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
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
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.DamageSource;
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
/*     */ public class Robot1
/*     */   extends EntityMob
/*     */ {
/*  54 */   private GenericTargetSorter TargetSorter = null;
/*  55 */   private RenderInfo renderdata = new RenderInfo();
/*  56 */   private float moveSpeed = 0.2F;
/*     */ 
/*     */   
/*     */   public Robot1(World par1World) {
/*  60 */     super(par1World);
/*  61 */     setSize(0.5F, 0.5F);
/*  62 */     getNavigator().setAvoidsWater(true);
/*  63 */     this.experienceValue = 5;
/*  64 */     this.fireResistance = 5;
/*  65 */     this.isImmuneToFire = true;
/*  66 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  67 */     this.renderdata = new RenderInfo();
/*  68 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  69 */     this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D));
/*  70 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.8999999761581421D, false));
/*  71 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  72 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  73 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  78 */     super.applyEntityAttributes();
/*  79 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  80 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  81 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  86 */     super.entityInit();
/*  87 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  88 */     if (this.renderdata == null) {
/*  89 */       this.renderdata = new RenderInfo();
/*     */     }
/*  91 */     this.renderdata.rf1 = 0.0F;
/*  92 */     this.renderdata.rf2 = 0.0F;
/*  93 */     this.renderdata.rf3 = 0.0F;
/*  94 */     this.renderdata.rf4 = 0.0F;
/*  95 */     this.renderdata.ri1 = 0;
/*  96 */     this.renderdata.ri2 = 0;
/*  97 */     this.renderdata.ri3 = 0;
/*  98 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 102 */     if (isNoDespawnRequired()) return false; 
/* 103 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 111 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 112 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 117 */     return 5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 124 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 129 */     this.renderdata.rf1 = r.rf1;
/* 130 */     this.renderdata.rf2 = r.rf2;
/* 131 */     this.renderdata.rf3 = r.rf3;
/* 132 */     this.renderdata.rf4 = r.rf4;
/* 133 */     this.renderdata.ri1 = r.ri1;
/* 134 */     this.renderdata.ri2 = r.ri2;
/* 135 */     this.renderdata.ri3 = r.ri3;
/* 136 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 144 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 152 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 162 */     super.onLivingUpdate();
/* 163 */     if (this.worldObj.rand.nextInt(8) == 0) {
/* 164 */       EntityLivingBase e = findSomethingToAttack();
/* 165 */       if (e != null) {
/* 166 */         if (getDistanceSqToEntity((Entity)e) < 5.0D && !this.worldObj.isRemote && 
/* 167 */           this.worldObj.rand.nextInt(18) == 1) {
/* 168 */           this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, 2.5F, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
/* 169 */           setDead();
/*     */         } 
/*     */         
/* 172 */         for (int i = 0; i < 2; i++) {
/* 173 */           this.worldObj.spawnParticle("smoke", this.posX, this.posY + 1.0D, this.posZ, 0.0D, 0.0D, 0.0D);
/* 174 */           this.worldObj.spawnParticle("lava", this.posX, this.posY + 1.0D, this.posZ, 0.0D, 0.0D, 0.0D);
/*     */         } 
/* 176 */         getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
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
/*     */   protected String getLivingSound() {
/* 188 */     return "orespawn:kyuubi_living";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 196 */     return "orespawn:scorpion_hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 204 */     return "orespawn:robot1_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 211 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 218 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 226 */     return Items.gunpowder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 234 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 241 */     return super.attackEntityAsMob(par1Entity);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 246 */     if (this.isDead)
/* 247 */       return;  super.updateAITasks();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 255 */     boolean ret = false;
/* 256 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 257 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     }
/* 259 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 269 */     if (par1EntityLiving == null)
/*     */     {
/* 271 */       return false;
/*     */     }
/* 273 */     if (par1EntityLiving == this)
/*     */     {
/* 275 */       return false;
/*     */     }
/* 277 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 279 */       return false;
/*     */     }
/*     */     
/* 282 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 284 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 287 */       return false;
/*     */     }
/*     */     
/* 290 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 292 */       return false;
/*     */     }
/* 294 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 296 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 297 */       if (p.capabilities.isCreativeMode == true) {
/* 298 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 302 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 307 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 308 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(8.0D, 3.0D, 8.0D));
/* 309 */     Collections.sort(var5, this.TargetSorter);
/* 310 */     Iterator<?> var2 = var5.iterator();
/*     */     
/* 312 */     while (var2.hasNext()) {
/*     */       
/* 314 */       Entity var3 = (Entity)var2.next();
/* 315 */       EntityLivingBase var4 = (EntityLivingBase)var3;
/*     */       
/* 317 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 319 */         return var4;
/*     */       }
/*     */     } 
/* 322 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 328 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 333 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 341 */     if (this.posY < 50.0D) return false; 
/* 342 */     if (!isValidLightLevel()) return false; 
/* 343 */     if (this.worldObj.isDaytime() == true) return false;
/*     */     
/* 345 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Robot1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */