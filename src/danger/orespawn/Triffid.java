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
/*     */ public class Triffid
/*     */   extends EntityMob
/*     */ {
/*  57 */   private GenericTargetSorter TargetSorter = null;
/*  58 */   private RenderInfo renderdata = new RenderInfo();
/*  59 */   private int hurt_timer = 0;
/*  60 */   private float moveSpeed = 0.13F;
/*     */ 
/*     */   
/*     */   public Triffid(World par1World) {
/*  64 */     super(par1World);
/*     */     
/*  66 */     setSize(2.0F, 4.0F);
/*  67 */     getNavigator().setAvoidsWater(true);
/*  68 */     this.experienceValue = 50;
/*  69 */     this.fireResistance = 75;
/*  70 */     this.isImmuneToFire = false;
/*  71 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  72 */     this.renderdata = new RenderInfo();
/*  73 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*     */ 
/*     */     
/*  76 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F));
/*  77 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  78 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  84 */     super.entityInit();
/*  85 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  86 */     this.dataWatcher.addObject(21, Byte.valueOf((byte)0));
/*  87 */     if (this.renderdata == null) {
/*  88 */       this.renderdata = new RenderInfo();
/*     */     }
/*  90 */     this.renderdata.rf1 = 0.0F;
/*  91 */     this.renderdata.rf2 = 0.0F;
/*  92 */     this.renderdata.rf3 = 0.0F;
/*  93 */     this.renderdata.rf4 = 0.0F;
/*  94 */     this.renderdata.ri1 = 0;
/*  95 */     this.renderdata.ri2 = 0;
/*  96 */     this.renderdata.ri3 = 0;
/*  97 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/* 103 */     super.applyEntityAttributes();
/* 104 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/* 105 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 106 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Triffid_stats.attack);
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 110 */     if (isNoDespawnRequired()) return false; 
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 119 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 120 */     super.onUpdate();
/*     */ 
/*     */     
/* 123 */     if (this.worldObj.rand.nextInt(100) == 1) {
/*     */ 
/*     */ 
/*     */       
/* 127 */       int ix = (int)this.posX;
/* 128 */       int iz = (int)this.posZ;
/*     */       int k;
/* 130 */       for (k = -5; k <= 5; k++) {
/*     */         
/* 132 */         Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ + k);
/* 133 */         if (bid != Blocks.air) {
/* 134 */           if (k < 0) iz--; 
/* 135 */           if (k > 0) iz++; 
/*     */         } 
/*     */       } 
/* 138 */       for (k = -5; k <= 5; k++) {
/*     */         
/* 140 */         Block bid = this.worldObj.getBlock((int)this.posX + k, (int)this.posY - 1, (int)this.posZ);
/* 141 */         if (bid != Blocks.air) {
/* 142 */           if (k < 0) ix--; 
/* 143 */           if (k > 0) ix++; 
/*     */         } 
/*     */       } 
/* 146 */       getNavigator().tryMoveToXYZ(ix, this.posY, iz, 1.0D);
/*     */     } 
/*     */     
/* 149 */     if (this.hurt_timer <= 0) {
/* 150 */       EntityLivingBase e = findSomethingToAttack();
/* 151 */       if (e != null) {
/*     */         
/* 153 */         this.rotationYaw = (float)Math.toDegrees(Math.atan2(e.posZ - this.posZ, e.posX - this.posX)) - 90.0F;
/* 154 */         for (; this.rotationYaw < 0.0F; this.rotationYaw += 360.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 162 */     return OreSpawnMain.Triffid_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 169 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 174 */     this.renderdata.rf1 = r.rf1;
/* 175 */     this.renderdata.rf2 = r.rf2;
/* 176 */     this.renderdata.rf3 = r.rf3;
/* 177 */     this.renderdata.rf4 = r.rf4;
/* 178 */     this.renderdata.ri1 = r.ri1;
/* 179 */     this.renderdata.ri2 = r.ri2;
/* 180 */     this.renderdata.ri3 = r.ri3;
/* 181 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 189 */     return OreSpawnMain.Triffid_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 197 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 206 */     super.onLivingUpdate();
/* 207 */     if (!this.worldObj.isRemote && this.hurt_timer > 0) {
/* 208 */       this.motionX = this.motionZ = 0.0D;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTriffidHealth() {
/* 216 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 226 */     return "orespawn:triffid_living";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 234 */     return "orespawn:triffid_hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 242 */     return "orespawn:triffid_dead";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 249 */     return 0.75F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 256 */     return 1.0F;
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
/* 267 */     int i = this.worldObj.rand.nextInt(3);
/* 268 */     if (i == 0) return Items.gold_nugget; 
/* 269 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 274 */     EntityItem var3 = null;
/* 275 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 277 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), is);
/*     */     
/* 279 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 280 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 287 */     int i = 4 + this.worldObj.rand.nextInt(6);
/* 288 */     for (int var4 = 0; var4 < i; var4++) {
/* 289 */       dropItemRand(OreSpawnMain.GreenGoo, 1);
/*     */     }
/* 291 */     dropItemRand(Items.item_frame, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 300 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 305 */     boolean ret = super.attackEntityAsMob(par1Entity);
/* 306 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 314 */     boolean ret = false;
/*     */     
/* 316 */     if (this.hurt_timer > 0 || getOpenClosed() == 0) {
/* 317 */       this.hurt_timer = 300;
/* 318 */       setAttacking(0);
/* 319 */       return false;
/*     */     } 
/* 321 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/* 322 */     this.hurt_timer = 300;
/* 323 */     setOpenClosed(0);
/* 324 */     setAttacking(0);
/* 325 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 331 */     if (this.isDead)
/*     */       return; 
/* 333 */     super.updateAITasks();
/*     */     
/* 335 */     if (this.hurt_timer > 0) {
/* 336 */       this.hurt_timer--;
/* 337 */       setFire(0);
/* 338 */       setOpenClosed(0);
/*     */     } 
/*     */     
/* 341 */     if (this.worldObj.rand.nextInt(250) == 1 && 
/* 342 */       getHealth() < mygetMaxHealth())
/*     */     {
/* 344 */       heal(1.0F);
/*     */     }
/*     */ 
/*     */     
/* 348 */     if (this.worldObj.rand.nextInt(80) == 2 && 
/* 349 */       this.hurt_timer <= 0) {
/* 350 */       if (this.worldObj.rand.nextInt(8) == 1) {
/* 351 */         setOpenClosed(1);
/*     */       } else {
/* 353 */         setOpenClosed(0);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 358 */     if (this.worldObj.rand.nextInt(10) == 1 && this.hurt_timer <= 0) {
/* 359 */       EntityLivingBase e = findSomethingToAttack();
/* 360 */       if (e != null) {
/* 361 */         setOpenClosed(1);
/* 362 */         if (getDistanceSqToEntity((Entity)e) < 25.0D) {
/* 363 */           this.rotationYaw = (float)Math.toDegrees(Math.atan2(e.posZ - this.posZ, e.posX - this.posX)) - 90.0F;
/* 364 */           for (; this.rotationYaw < 0.0F; this.rotationYaw += 360.0F);
/* 365 */           setAttacking(1);
/* 366 */           attackEntityAsMob((Entity)e);
/*     */         } else {
/* 368 */           setAttacking(0);
/*     */         } 
/*     */       } else {
/* 371 */         setAttacking(0);
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
/* 384 */     if (par1EntityLiving == null)
/*     */     {
/* 386 */       return false;
/*     */     }
/* 388 */     if (par1EntityLiving == this)
/*     */     {
/* 390 */       return false;
/*     */     }
/* 392 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 394 */       return false;
/*     */     }
/*     */     
/* 397 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 399 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 402 */       return false;
/*     */     }
/* 404 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCreeper)
/*     */     {
/* 406 */       return false;
/*     */     }
/* 408 */     if (par1EntityLiving instanceof EnderReaper)
/*     */     {
/* 410 */       return false;
/*     */     }
/* 412 */     if (par1EntityLiving instanceof Triffid)
/*     */     {
/* 414 */       return false;
/*     */     }
/* 416 */     if (par1EntityLiving instanceof TerribleTerror)
/*     */     {
/* 418 */       return false;
/*     */     }
/* 420 */     if (par1EntityLiving instanceof LurkingTerror)
/*     */     {
/* 422 */       return false;
/*     */     }
/* 424 */     if (par1EntityLiving instanceof PitchBlack)
/*     */     {
/* 426 */       return false;
/*     */     }
/* 428 */     if (par1EntityLiving instanceof Dragon)
/*     */     {
/* 430 */       return false;
/*     */     }
/*     */     
/* 433 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 435 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 436 */       if (p.capabilities.isCreativeMode == true) {
/* 437 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 441 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 446 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 447 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0D, 8.0D, 10.0D));
/* 448 */     Collections.sort(var5, this.TargetSorter);
/* 449 */     Iterator<?> var2 = var5.iterator();
/* 450 */     Entity var3 = null;
/* 451 */     EntityLivingBase var4 = null;
/*     */     
/* 453 */     while (var2.hasNext()) {
/*     */       
/* 455 */       var3 = (Entity)var2.next();
/* 456 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 458 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 460 */         return var4;
/*     */       }
/*     */     } 
/* 463 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 468 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 473 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getOpenClosed() {
/* 478 */     return this.dataWatcher.getWatchableObjectByte(21);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setOpenClosed(int par1) {
/* 483 */     this.dataWatcher.updateObject(21, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 491 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Triffid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */