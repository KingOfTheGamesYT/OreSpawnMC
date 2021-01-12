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
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
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
/*     */ public class Rat
/*     */   extends EntityMob
/*     */ {
/*  45 */   private GenericTargetSorter TargetSorter = null;
/*  46 */   private float moveSpeed = 0.25F;
/*  47 */   private String myowner = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public Rat(World par1World) {
/*  52 */     super(par1World);
/*  53 */     setSize(0.25F, 0.5F);
/*  54 */     getNavigator().setAvoidsWater(true);
/*  55 */     this.experienceValue = 5;
/*  56 */     this.fireResistance = 10;
/*  57 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  58 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.350000023841858D));
/*  59 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  60 */     this.tasks.addTask(3, new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D));
/*  61 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  62 */     this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  63 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*  64 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  69 */     super.applyEntityAttributes();
/*  70 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  71 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  72 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Rat_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  77 */     super.entityInit();
/*  78 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  82 */     if (isNoDespawnRequired()) return false; 
/*  83 */     if (this.myowner != null) return false; 
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/*  89 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/*  94 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  99 */     return OreSpawnMain.Rat_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 107 */     return OreSpawnMain.Rat_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 115 */     return true;
/*     */   }
/*     */ 
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
/*     */   public void onUpdate() {
/* 132 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 133 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void jump() {
/* 139 */     super.jump();
/* 140 */     this.motionY += 0.25D;
/* 141 */     this.posY += 0.25D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 149 */     return "orespawn:ratlive";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 157 */     return "orespawn:rathit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 165 */     return "orespawn:ratdead";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 172 */     return 0.45F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 179 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 188 */     return Items.rotten_flesh;
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
/* 203 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 208 */     if (this.isDead)
/* 209 */       return;  super.updateAITasks();
/* 210 */     if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 211 */     if (this.worldObj.rand.nextInt(5) == 1) {
/* 212 */       EntityLivingBase e = findSomethingToAttack();
/* 213 */       if (e != null) {
/* 214 */         setAttacking(1);
/* 215 */         getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/* 216 */         if (getDistanceSqToEntity((Entity)e) < 4.0D)
/*     */         {
/* 218 */           if (this.rand.nextInt(8) == 0 || this.rand.nextInt(7) == 1)
/*     */           {
/* 220 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         }
/*     */       } else {
/* 224 */         setAttacking(0);
/* 225 */         if (this.myowner != null) {
/* 226 */           EntityPlayer p = this.worldObj.getPlayerEntityByName(this.myowner);
/* 227 */           if (p != null) {
/* 228 */             if (getDistanceSqToEntity((Entity)p) > 64.0D) {
/* 229 */               getNavigator().tryMoveToEntityLiving((Entity)p, 1.75D);
/*     */             }
/* 231 */             if (getDistanceSqToEntity((Entity)p) > 256.0D) {
/* 232 */               setPosition(p.posX + this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat(), p.posY, p.posZ + this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 239 */     if (this.worldObj.rand.nextInt(250) == 1) heal(1.0F);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 250 */     if (par1EntityLiving == null)
/*     */     {
/* 252 */       return false;
/*     */     }
/* 254 */     if (par1EntityLiving == this)
/*     */     {
/* 256 */       return false;
/*     */     }
/* 258 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 260 */       return false;
/*     */     }
/*     */     
/* 263 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 265 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 268 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 272 */     if (par1EntityLiving instanceof Irukandji)
/*     */     {
/* 274 */       return false;
/*     */     }
/* 276 */     if (par1EntityLiving instanceof Skate)
/*     */     {
/* 278 */       return false;
/*     */     }
/* 280 */     if (par1EntityLiving instanceof Whale)
/*     */     {
/* 282 */       return false;
/*     */     }
/* 284 */     if (par1EntityLiving instanceof Flounder)
/*     */     {
/* 286 */       return false;
/*     */     }
/* 288 */     if (par1EntityLiving instanceof Rat)
/*     */     {
/* 290 */       return false;
/*     */     }
/* 292 */     if (par1EntityLiving instanceof Ghost)
/*     */     {
/* 294 */       return false;
/*     */     }
/* 296 */     if (par1EntityLiving instanceof GhostSkelly)
/*     */     {
/* 298 */       return false;
/*     */     }
/* 300 */     if (par1EntityLiving instanceof DungeonBeast)
/*     */     {
/* 302 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 306 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 308 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 309 */       if (p.capabilities.isCreativeMode == true) {
/* 310 */         return false;
/*     */       }
/*     */       
/* 313 */       if (this.myowner != null) {
/* 314 */         if (this.myowner.equals(p.getUniqueID().toString())) {
/* 315 */           return false;
/*     */         }
/* 317 */         if (OreSpawnMain.RatPlayerFriendly != 0) {
/* 318 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 324 */     if (this.myowner != null && 
/* 325 */       par1EntityLiving instanceof EntityTameable) {
/* 326 */       EntityTameable e = (EntityTameable)par1EntityLiving;
/* 327 */       if (OreSpawnMain.RatPetFriendly != 0 && e.isTamed()) {
/* 328 */         return false;
/*     */       }
/* 330 */       if (e.func_152113_b() != null && this.myowner.equals(e.func_152113_b())) {
/* 331 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 336 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 341 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 342 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(9.0D, 2.0D, 9.0D));
/* 343 */     Collections.sort(var5, this.TargetSorter);
/* 344 */     Iterator<?> var2 = var5.iterator();
/* 345 */     Entity var3 = null;
/* 346 */     EntityLivingBase var4 = null;
/*     */     
/* 348 */     while (var2.hasNext()) {
/*     */       
/* 350 */       var3 = (Entity)var2.next();
/* 351 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 353 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 355 */         return var4;
/*     */       }
/*     */     } 
/* 358 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOwner(EntityLivingBase e) {
/* 363 */     EntityPlayer p = null;
/* 364 */     if (e != null && 
/* 365 */       e instanceof EntityPlayer) {
/* 366 */       p = (EntityPlayer)e;
/* 367 */       String s = p.getUniqueID().toString();
/* 368 */       if (s != null) {
/* 369 */         this.myowner = s;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 380 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 381 */     if (this.myowner == null) this.myowner = "null"; 
/* 382 */     par1NBTTagCompound.setString("MyOwner", this.myowner);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 390 */     super.readEntityFromNBT(par1NBTTagCompound);
/* 391 */     this.myowner = par1NBTTagCompound.getString("MyOwner");
/* 392 */     if (this.myowner != null && 
/* 393 */       this.myowner.equals("null")) {
/* 394 */       this.myowner = null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 403 */     boolean ret = false;
/* 404 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/* 405 */       return ret;
/*     */     }
/*     */     
/* 408 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 410 */     return ret;
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
/* 421 */     int sc = 0;
/*     */     int k;
/* 423 */     for (k = -2; k < 2; k++) {
/*     */       
/* 425 */       for (int j = -2; j < 2; j++) {
/*     */         
/* 427 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 429 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 430 */           if (bid == Blocks.mob_spawner) {
/* 431 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 432 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 433 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 434 */             if (s != null && 
/* 435 */               s.equals("Rat")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 443 */     if (!isValidLightLevel()) return false;
/*     */ 
/*     */     
/* 446 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID5) {
/* 447 */       if (this.posY > 50.0D) return false; 
/* 448 */       for (k = -1; k <= 1; k++) {
/*     */         
/* 450 */         for (int j = -1; j <= 1; j++) {
/*     */           
/* 452 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + 1, (int)this.posZ + k);
/* 453 */           if (bid == Blocks.air) sc++; 
/*     */         } 
/*     */       } 
/* 456 */       if (sc < 4) return false; 
/*     */     } 
/* 458 */     if (findBuddies() > 8) return false; 
/* 459 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 464 */     List var5 = this.worldObj.getEntitiesWithinAABB(Rat.class, this.boundingBox.expand(20.0D, 10.0D, 20.0D));
/* 465 */     return var5.size();
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Rat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */