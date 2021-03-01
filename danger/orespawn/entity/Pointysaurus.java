/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.util.ai.MyEntityAIWanderALot;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.annotation.ParametersAreNonnullByDefault;
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
/*     */ public class Pointysaurus
/*     */   extends EntityMob
/*     */ {
/*  59 */   private final float moveSpeed = 0.35F;
/*  60 */   private EntityLivingBase rt = null;
/*     */   
/*     */   public Pointysaurus(World par1World) {
/*  63 */     super(par1World);
/*  64 */     setSize(2.9F, 2.9F);
/*     */     
/*  66 */     this.experienceValue = 40;
/*     */ 
/*     */     
/*  69 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  70 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  71 */     this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  72 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  73 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  74 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
/*     */   }
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  78 */     super.applyEntityAttributes();
/*  79 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  80 */     getClass(); getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3499999940395355D);
/*  81 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0D);
/*     */   }
/*     */   
/*     */   protected void entityInit() {
/*  85 */     super.entityInit();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  90 */     return !isNoDespawnRequired();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  97 */     getClass(); getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3499999940395355D);
/*  98 */     super.onUpdate();
/*     */   }
/*     */   
/*     */   public int mygetMaxHealth() {
/* 102 */     return 40;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 109 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 124 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getAmbientSound() {
/* 133 */     if (this.rand.nextInt(4) == 0) {
/* 134 */       return SoundsHandler.ENTITY_ALOSAURUS_LIVING;
/*     */     }
/* 136 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   @ParametersAreNonnullByDefault
/*     */   protected SoundEvent getHurtSound(DamageSource source) {
/* 142 */     return SoundsHandler.ENTITY_ALOSAURUS_HURT;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 147 */     return SoundsHandler.ENTITY_ALOSAURUS_DEATH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 154 */     return 0.9F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 161 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 169 */     return Items.BEEF;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 174 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 2.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/* 175 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 181 */     for (var4 = 0; var4 < 10; var4++) {
/* 182 */       dropItemRand(Items.LEATHER, 1);
/*     */     }
/* 184 */     for (var4 = 0; var4 < 6; var4++) {
/* 185 */       dropItemRand(Items.BEEF, 1);
/*     */     }
/* 187 */     for (var4 = 0; var4 < 6; var4++) {
/* 188 */       dropItemRand(Items.ROTTEN_FLESH, 1);
/*     */     }
/* 190 */     for (var4 = 0; var4 < 6; var4++) {
/* 191 */       dropItemRand(Items.STRING, 1);
/*     */     }
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
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 206 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 211 */     if (super.attackEntityAsMob(par1Entity)) {
/* 212 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/* 213 */         double ks = 0.8D;
/* 214 */         double inair = 0.1D;
/* 215 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 216 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 217 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 219 */       return true;
/*     */     } 
/* 221 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 229 */     boolean ret = false;
/*     */     
/* 231 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/*     */       
/* 233 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 234 */       Entity e = par1DamageSource.getImmediateSource();
/*     */       
/* 236 */       if (e instanceof EntityLivingBase) {
/* 237 */         this.rt = (EntityLivingBase)e;
/*     */       }
/*     */     } 
/* 240 */     return ret;
/*     */   }
/*     */   
/*     */   protected void updateAITasks() {
/* 244 */     if (this.isDead)
/* 245 */       return;  super.updateAITasks();
/* 246 */     if (this.world.rand.nextInt(6) == 0) {
/* 247 */       EntityLivingBase e = null;
/* 248 */       e = this.rt;
/* 249 */       if (OreSpawnMain.PlayNicely != 0) e = null; 
/* 250 */       if (e != null) {
/* 251 */         if (e.isDead || this.world.rand.nextInt(250) == 1) {
/* 252 */           e = null;
/* 253 */           this.rt = null;
/*     */         } 
/* 255 */         if (e != null && 
/* 256 */           !getEntitySenses().canSee((Entity)e)) {
/* 257 */           e = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 262 */       if (e == null) {
/* 263 */         e = findSomethingToAttack();
/*     */       }
/*     */       
/* 266 */       if (e != null) {
/* 267 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 268 */         if (getDistanceSq((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 269 */           setAttacking(1);
/*     */           
/* 271 */           if (this.world.rand.nextInt(5) == 0 || this.world.rand.nextInt(6) == 1)
/*     */           {
/* 273 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 276 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 279 */         setAttacking(0);
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
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 291 */     if (par1EntityLiving == null) {
/* 292 */       return false;
/*     */     }
/* 294 */     if (par1EntityLiving == this) {
/* 295 */       return false;
/*     */     }
/* 297 */     if (!par1EntityLiving.isEntityAlive()) {
/* 298 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 303 */     if (par1EntityLiving instanceof Pointysaurus) {
/* 304 */       return false;
/*     */     }
/*     */     
/* 307 */     if (par1EntityLiving instanceof EntityMob) {
/* 308 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 316 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/* 318 */       return false;
/*     */     }
/*     */     
/* 321 */     if (par1EntityLiving instanceof EntityPlayer) {
/* 322 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 323 */       if (p.capabilities.isCreativeMode) {
/* 324 */         return false;
/*     */       }
/* 326 */       return true;
/*     */     } 
/*     */     
/* 329 */     return false;
/*     */   }
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 333 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 334 */     List var5 = this.world.getEntitiesWithinAABB(EntityLivingBase.class, getEntityBoundingBox().expand(12.0D, 5.0D, 12.0D));
/*     */     
/* 336 */     Iterator<Entity> var2 = var5.iterator();
/* 337 */     Entity var3 = null;
/* 338 */     EntityLivingBase var4 = null;
/*     */     
/* 340 */     while (var2.hasNext()) {
/* 341 */       var3 = var2.next();
/* 342 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 344 */       if (isSuitableTarget(var4, false)) {
/* 345 */         return var4;
/*     */       }
/*     */     } 
/* 348 */     return null;
/*     */   }
/*     */   
/*     */   public int getAttacking() {
/* 352 */     return 1;
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
/*     */   public void setAttacking(int par1) {}
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
/* 382 */     if (!isValidLightLevel()) return false; 
/* 383 */     if (this.posY < 50.0D) return false; 
/* 384 */     if (this.world.isDaytime()) return false;
/*     */ 
/*     */ 
/*     */     
/* 388 */     for (int k = -1; k < 1; k++) {
/* 389 */       for (int j = -1; j < 1; j++) {
/* 390 */         for (int i = 1; i < 6; i++) {
/* 391 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k)).getBlock();
/* 392 */           if (bid != Blocks.AIR) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/* 397 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\Pointysaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */