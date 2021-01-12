/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.EnumDifficulty;
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
/*     */ public class Frog
/*     */   extends EntityAnimal
/*     */ {
/*  40 */   private GenericTargetSorter TargetSorter = null;
/*  41 */   public double moveSpeed = 0.10000000149011612D;
/*  42 */   private int singing = 0;
/*  43 */   private int jumpcount = 0;
/*     */   
/*     */   public Frog(World par1World) {
/*  46 */     super(par1World);
/*  47 */     setSize(0.75F, 0.75F);
/*  48 */     this.experienceValue = 5;
/*  49 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  50 */     getNavigator().setAvoidsWater(false);
/*  51 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  52 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.4D));
/*  53 */     this.tasks.addTask(2, new MyEntityAIWander((EntityCreature)this, 1.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  58 */     super.applyEntityAttributes();
/*  59 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  60 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  61 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  62 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  67 */     super.entityInit();
/*  68 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/*  74 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  78 */     if (isNoDespawnRequired()) return false; 
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSinging() {
/*  84 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSinging(int par1) {
/*  89 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void jumpAround() {
/*  95 */     this.motionY += (0.75F + Math.abs(this.worldObj.rand.nextFloat() * 0.55F));
/*  96 */     this.posY += 0.3499999940395355D;
/*  97 */     float f = 0.7F + Math.abs(this.worldObj.rand.nextFloat() * 0.75F);
/*  98 */     float d = (float)Math.toRadians(this.rotationYaw);
/*  99 */     this.motionX -= f * Math.sin(d);
/* 100 */     this.motionZ += f * Math.cos(d);
/* 101 */     this.isAirBorne = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 109 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 110 */     super.onUpdate();
/* 111 */     if (!this.worldObj.isRemote) {
/* 112 */       if (this.singing != 0) {
/* 113 */         this.singing--;
/* 114 */         if (this.singing <= 0) {
/* 115 */           setSinging(0);
/*     */         }
/*     */       } 
/* 118 */       if (this.jumpcount > 0) this.jumpcount--; 
/* 119 */       if (this.jumpcount == 0 && 
/* 120 */         this.worldObj.rand.nextInt(70) == 1) {
/* 121 */         jumpAround();
/* 122 */         this.jumpcount = 50;
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
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 134 */     if (par1EntityPlayer != null && 
/* 135 */       par1EntityPlayer.isSneaking() && 
/* 136 */       par1EntityPlayer.inventory.getCurrentItem() == null) {
/* 137 */       World world = par1EntityPlayer.worldObj;
/* 138 */       setDead();
/* 139 */       par1EntityPlayer.worldObj.playSoundAtEntity((Entity)par1EntityPlayer, "random.explode", 1.0F, world.rand.nextFloat() * 0.2F + 0.9F);
/* 140 */       if (!world.isRemote) {
/* 141 */         if (world.rand.nextInt(2) == 0) {
/* 142 */           Boyfriend ent = null;
/* 143 */           ent = (Boyfriend)spawnCreature(world, "Boyfriend", this.posX, this.posY + 0.01D, this.posZ);
/* 144 */           if (ent != null) ent.setPrince(1 + world.rand.nextInt(2)); 
/*     */         } else {
/* 146 */           Girlfriend ent = null;
/* 147 */           ent = (Girlfriend)spawnCreature(world, "Girlfriend", this.posX, this.posY + 0.01D, this.posZ);
/* 148 */           if (ent != null) ent.setPrincess(1 + world.rand.nextInt(2)); 
/*     */         } 
/*     */       } else {
/* 151 */         for (int var3 = 0; var3 < 16; var3++) {
/*     */           
/* 153 */           world.spawnParticle("smoke", ((float)this.posX + world.rand.nextFloat() - world.rand.nextFloat()), ((float)this.posY + world.rand.nextFloat()), ((float)this.posZ + world.rand.nextFloat() - world.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
/* 154 */           world.spawnParticle("explode", ((float)this.posX + world.rand.nextFloat() - world.rand.nextFloat()), ((float)this.posY + world.rand.nextFloat()), ((float)this.posZ + world.rand.nextFloat() - world.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
/* 155 */           world.spawnParticle("reddust", ((float)this.posX + world.rand.nextFloat() - world.rand.nextFloat()), ((float)this.posY + world.rand.nextFloat()), ((float)this.posZ + world.rand.nextFloat() - world.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 162 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAIEnabled() {
/* 171 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 177 */     return 8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 186 */     if (!this.worldObj.isRemote) {
/* 187 */       if (this.worldObj.rand.nextInt(2) == 0) return null; 
/* 188 */       this.singing = 35;
/* 189 */       setSinging(this.singing);
/*     */     } 
/* 191 */     return "orespawn:frog";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 199 */     return "orespawn:scorpion_hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 207 */     return "orespawn:big_splat";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 216 */     return 0.7F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFallState(double par1, boolean par3) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void playStepSound(int par1, int par2, int par3, int par4) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 241 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), new ItemStack(index, par1, 0));
/*     */     
/* 243 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 252 */     for (int i = 0; i < 4; i++) {
/* 253 */       dropItemRand(Items.slime_ball, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 261 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 3.0F);
/* 262 */     if (par1Entity.isDead) heal(1.0F); 
/* 263 */     return var4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 271 */     boolean ret = false;
/*     */     
/* 273 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/* 274 */     if (!this.worldObj.isRemote && this.jumpcount <= 0) {
/* 275 */       jumpAround();
/* 276 */       this.jumpcount = 25;
/*     */     } 
/* 278 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 287 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.25D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
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
/*     */   protected boolean canTriggerWalking() {
/* 305 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable var1) {
/* 312 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 317 */     List var5 = this.worldObj.getEntitiesWithinAABB(Frog.class, this.boundingBox.expand(20.0D, 8.0D, 20.0D));
/* 318 */     return var5.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 326 */     if (this.posY < 50.0D) return false; 
/* 327 */     if (!this.worldObj.isDaytime()) return false;
/*     */     
/* 329 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID5 && 
/* 330 */       this.worldObj.rand.nextInt(20) != 1) return false;
/*     */     
/* 332 */     if (findBuddies() > 5) return false; 
/* 333 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 338 */     int xdir = 1;
/* 339 */     int zdir = 1;
/*     */     
/* 341 */     int keep_trying = 50;
/*     */ 
/*     */ 
/*     */     
/* 345 */     if (this.isDead)
/* 346 */       return;  super.updateAITasks();
/* 347 */     if (this.rand.nextInt(12) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
/*     */ 
/*     */       
/* 350 */       EntityLivingBase e = null;
/* 351 */       e = findSomethingToAttack();
/* 352 */       if (e != null) {
/*     */ 
/*     */         
/* 355 */         getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/* 356 */         if (getDistanceSqToEntity((Entity)e) < 6.0D) {
/* 357 */           attackEntityAsMob((Entity)e);
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
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 369 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*     */     
/* 371 */     if (par1EntityLiving == null)
/*     */     {
/* 373 */       return false;
/*     */     }
/* 375 */     if (par1EntityLiving == this)
/*     */     {
/* 377 */       return false;
/*     */     }
/* 379 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 382 */       return false;
/*     */     }
/* 384 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 387 */       return false;
/*     */     }
/* 389 */     if (par1EntityLiving instanceof EntityAnt)
/*     */     {
/* 391 */       return true;
/*     */     }
/* 393 */     if (par1EntityLiving instanceof EntityButterfly)
/*     */     {
/* 395 */       return true;
/*     */     }
/* 397 */     if (par1EntityLiving instanceof Cricket)
/*     */     {
/* 399 */       return true;
/*     */     }
/* 401 */     if (par1EntityLiving instanceof EntityMosquito)
/*     */     {
/* 403 */       return true;
/*     */     }
/* 405 */     if (par1EntityLiving instanceof Firefly)
/*     */     {
/* 407 */       return true;
/*     */     }
/* 409 */     if (par1EntityLiving instanceof WormSmall)
/*     */     {
/* 411 */       return true;
/*     */     }
/*     */     
/* 414 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 419 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 420 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(8.0D, 3.0D, 8.0D));
/* 421 */     Collections.sort(var5, this.TargetSorter);
/* 422 */     Iterator<?> var2 = var5.iterator();
/* 423 */     Entity var3 = null;
/* 424 */     EntityLivingBase var4 = null;
/*     */     
/* 426 */     while (var2.hasNext()) {
/*     */       
/* 428 */       var3 = (Entity)var2.next();
/* 429 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 431 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 433 */         return var4;
/*     */       }
/*     */     } 
/* 436 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 445 */     Entity var8 = null;
/* 446 */     var8 = EntityList.createEntityByName(par1, par0World);
/* 447 */     if (var8 != null) {
/*     */ 
/*     */       
/* 450 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 453 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 455 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/* 457 */     return var8;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Frog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */