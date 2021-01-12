/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
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
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
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
/*     */ public class Alosaurus
/*     */   extends EntityMob
/*     */ {
/*  52 */   private GenericTargetSorter TargetSorter = null;
/*  53 */   private float moveSpeed = 0.35F;
/*     */ 
/*     */   
/*     */   public Alosaurus(World par1World) {
/*  57 */     super(par1World);
/*  58 */     setSize(1.9F, 3.6F);
/*  59 */     getNavigator().setAvoidsWater(true);
/*  60 */     this.experienceValue = 40;
/*  61 */     this.fireResistance = 100;
/*  62 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  63 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  64 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  65 */     this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  66 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  67 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  68 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  73 */     super.applyEntityAttributes();
/*  74 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  75 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  76 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Alosaurus_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  81 */     super.entityInit();
/*  82 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  86 */     if (isNoDespawnRequired()) return false; 
/*  87 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  95 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  96 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 101 */     return OreSpawnMain.Alosaurus_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 109 */     return OreSpawnMain.Alosaurus_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 117 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 126 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 135 */     if (this.rand.nextInt(4) == 0) {
/* 136 */       return "orespawn:alo_living";
/*     */     }
/* 138 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 147 */     return "orespawn:alo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 155 */     return "orespawn:alo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 162 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 169 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 180 */     return Items.beef;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 185 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/*     */     
/* 187 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 194 */     for (var4 = 0; var4 < 10; var4++) {
/* 195 */       dropItemRand(Items.gold_nugget, 1);
/*     */     }
/* 197 */     for (var4 = 0; var4 < 6; var4++) {
/* 198 */       dropItemRand(Items.beef, 1);
/*     */     }
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
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 215 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 222 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 224 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 226 */         double ks = 1.2D;
/* 227 */         double inair = 0.1D;
/* 228 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 229 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 230 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 232 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 236 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 242 */     if (this.isDead)
/* 243 */       return;  super.updateAITasks();
/* 244 */     if (this.worldObj.rand.nextInt(5) == 0) {
/* 245 */       EntityLivingBase e = findSomethingToAttack();
/* 246 */       if (e != null) {
/* 247 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 248 */         if (getDistanceSqToEntity((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/* 249 */           setAttacking(1);
/*     */           
/* 251 */           if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1)
/*     */           {
/* 253 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 256 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */       } else {
/* 259 */         setAttacking(0);
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
/* 272 */     if (par1EntityLiving == null)
/*     */     {
/* 274 */       return false;
/*     */     }
/* 276 */     if (par1EntityLiving == this)
/*     */     {
/* 278 */       return false;
/*     */     }
/* 280 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 282 */       return false;
/*     */     }
/*     */     
/* 285 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 287 */     if (par1EntityLiving instanceof Alosaurus)
/*     */     {
/* 289 */       return false;
/*     */     }
/*     */     
/* 292 */     if (par1EntityLiving instanceof Cryolophosaurus)
/*     */     {
/* 294 */       return false;
/*     */     }
/*     */     
/* 297 */     if (par1EntityLiving instanceof VelocityRaptor)
/*     */     {
/* 299 */       return false;
/*     */     }
/*     */     
/* 302 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 305 */       return false;
/*     */     }
/*     */     
/* 308 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 310 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 311 */       if (p.capabilities.isCreativeMode == true) {
/* 312 */         return false;
/*     */       }
/* 314 */       return true;
/*     */     } 
/*     */     
/* 317 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 322 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 323 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 5.0D, 12.0D));
/* 324 */     Collections.sort(var5, this.TargetSorter);
/* 325 */     Iterator<?> var2 = var5.iterator();
/* 326 */     Entity var3 = null;
/* 327 */     EntityLivingBase var4 = null;
/*     */     
/* 329 */     while (var2.hasNext()) {
/*     */       
/* 331 */       var3 = (Entity)var2.next();
/* 332 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 334 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 336 */         return var4;
/*     */       }
/*     */     } 
/* 339 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAttacking() {
/* 344 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAttacking(int par1) {
/* 349 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/*     */     int k;
/* 361 */     for (k = -3; k < 3; k++) {
/*     */       
/* 363 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 365 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 367 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 368 */           if (bid == Blocks.mob_spawner) {
/* 369 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 370 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 371 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 372 */             if (s != null && 
/* 373 */               s.equals("Alosaurus")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 379 */     if (!isValidLightLevel()) return false; 
/* 380 */     if (this.posY < 50.0D) return false; 
/* 381 */     if (this.worldObj.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 385 */     for (k = -1; k < 1; k++) {
/*     */       
/* 387 */       for (int j = -1; j < 1; j++) {
/*     */         
/* 389 */         for (int i = 1; i < 6; i++) {
/*     */           
/* 391 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 392 */           if (bid != Blocks.air) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 398 */     Alosaurus target = null;
/* 399 */     target = (Alosaurus)this.worldObj.findNearestEntityWithinAABB(Alosaurus.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D), (Entity)this);
/* 400 */     if (target != null)
/*     */     {
/* 402 */       return false;
/*     */     }
/* 404 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Alosaurus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */