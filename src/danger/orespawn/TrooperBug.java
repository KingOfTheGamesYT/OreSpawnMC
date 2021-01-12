/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityList;
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
/*     */ public class TrooperBug
/*     */   extends EntityMob
/*     */ {
/*  59 */   private GenericTargetSorter TargetSorter = null;
/*  60 */   private RenderInfo renderdata = new RenderInfo();
/*  61 */   private int force_sync = 50;
/*  62 */   private int hurt_timer = 0;
/*  63 */   private float moveSpeed = 0.4F;
/*     */ 
/*     */   
/*     */   public TrooperBug(World par1World) {
/*  67 */     super(par1World);
/*     */     
/*  69 */     setSize(3.0F, 3.5F);
/*  70 */     getNavigator().setAvoidsWater(true);
/*  71 */     this.experienceValue = 150;
/*  72 */     this.fireResistance = 100;
/*  73 */     this.isImmuneToFire = false;
/*  74 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  75 */     this.renderdata = new RenderInfo();
/*  76 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  77 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.8999999761581421D, false));
/*  78 */     this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0D));
/*  79 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F));
/*  80 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  81 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  87 */     super.entityInit();
/*  88 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  89 */     if (this.renderdata == null) {
/*  90 */       this.renderdata = new RenderInfo();
/*     */     }
/*  92 */     this.renderdata.rf1 = 0.0F;
/*  93 */     this.renderdata.rf2 = 0.0F;
/*  94 */     this.renderdata.rf3 = 0.0F;
/*  95 */     this.renderdata.rf4 = 0.0F;
/*  96 */     this.renderdata.ri1 = 0;
/*  97 */     this.renderdata.ri2 = 0;
/*  98 */     this.renderdata.ri3 = 0;
/*  99 */     this.renderdata.ri4 = 0;
/* 100 */     this.force_sync = 50;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/* 105 */     super.applyEntityAttributes();
/* 106 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/* 107 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 108 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.TrooperBug_stats.attack);
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 112 */     if (isNoDespawnRequired()) return false; 
/* 113 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 121 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 122 */     super.onUpdate();
/* 123 */     if (this.isAirBorne)
/*     */     {
/*     */       
/* 126 */       getNavigator().setPath(null, 0.0D);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 132 */     return OreSpawnMain.TrooperBug_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 140 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 145 */     this.renderdata.rf1 = r.rf1;
/* 146 */     this.renderdata.rf2 = r.rf2;
/* 147 */     this.renderdata.rf3 = r.rf3;
/* 148 */     this.renderdata.rf4 = r.rf4;
/* 149 */     this.renderdata.ri1 = r.ri1;
/* 150 */     this.renderdata.ri2 = r.ri2;
/* 151 */     this.renderdata.ri3 = r.ri3;
/* 152 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 160 */     return OreSpawnMain.TrooperBug_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 168 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 177 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void jump() {
/* 184 */     this.motionY += 1.149999976158142D;
/* 185 */     this.posY += 1.5D;
/* 186 */     float f = 0.2F + Math.abs(this.worldObj.rand.nextFloat() * 0.45F);
/* 187 */     this.motionX -= f * Math.sin(Math.toRadians(this.rotationYawHead));
/* 188 */     this.motionZ += f * Math.cos(Math.toRadians(this.rotationYawHead));
/* 189 */     this.isAirBorne = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void jumpAtEntity(EntityLivingBase e) {
/* 195 */     this.motionY += 1.25D;
/* 196 */     this.posY += 1.25D;
/* 197 */     float f = 0.3F + Math.abs(this.worldObj.rand.nextFloat() * 0.25F);
/* 198 */     float d = (float)Math.atan2(e.posX - this.posX, e.posZ - this.posZ);
/* 199 */     this.motionX += f * Math.sin(d);
/* 200 */     this.motionZ += f * Math.cos(d);
/* 201 */     this.isAirBorne = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTrooperBugHealth() {
/* 208 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 217 */     if (this.rand.nextInt(4) == 0) {
/* 218 */       return "orespawn:clatter";
/*     */     }
/* 220 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 228 */     return "orespawn:crunch";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 236 */     return "orespawn:emperorscorpion_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 243 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 250 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 260 */     return Items.beef;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 265 */     EntityItem var3 = null;
/* 266 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 268 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), is);
/*     */     
/* 270 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 271 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 279 */     dropItemRand(OreSpawnMain.MyJumpyBugScale, 1);
/* 280 */     dropItemRand(Items.item_frame, 1);
/*     */     
/* 282 */     int i = 2 + this.worldObj.rand.nextInt(5); int var4;
/* 283 */     for (var4 = 0; var4 < i; var4++) {
/* 284 */       dropItemRand(OreSpawnMain.MyAmethyst, 1);
/*     */     }
/*     */     
/* 287 */     i = 1 + this.worldObj.rand.nextInt(5);
/* 288 */     for (var4 = 0; var4 < i; var4++) {
/* 289 */       ItemStack is; int var3 = this.worldObj.rand.nextInt(14);
/* 290 */       switch (var3) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 2:
/* 296 */           is = dropItemRand(Item.getItemFromBlock(OreSpawnMain.MyBlockAmethystBlock), 1);
/*     */           break;
/*     */         case 3:
/* 299 */           is = dropItemRand(OreSpawnMain.MyAmethystSword, 1);
/* 300 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/* 301 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/* 302 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/* 303 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/* 304 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 305 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/* 306 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 4:
/* 309 */           is = dropItemRand(OreSpawnMain.MyAmethystShovel, 1);
/* 310 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 311 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 5:
/* 314 */           is = dropItemRand(OreSpawnMain.MyAmethystPickaxe, 1);
/* 315 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 316 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/* 317 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 6:
/* 320 */           is = dropItemRand(OreSpawnMain.MyAmethystAxe, 1);
/* 321 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 322 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 7:
/* 325 */           is = dropItemRand(OreSpawnMain.MyAmethystHoe, 1);
/* 326 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 327 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 8:
/* 330 */           is = dropItemRand((Item)OreSpawnMain.AmethystHelmet, 1);
/* 331 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 332 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 333 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 334 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 335 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 336 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2)); 
/* 337 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 9:
/* 340 */           is = dropItemRand((Item)OreSpawnMain.AmethystBody, 1);
/* 341 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 342 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 343 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 344 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 345 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*     */           break;
/*     */         case 10:
/* 348 */           is = dropItemRand((Item)OreSpawnMain.AmethystLegs, 1);
/* 349 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 350 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 351 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 352 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 353 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*     */           break;
/*     */         case 11:
/* 356 */           is = dropItemRand((Item)OreSpawnMain.AmethystBoots, 1);
/* 357 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/* 358 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
/*     */           
/*     */           break;
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
/*     */   public void initCreature() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 382 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 388 */     double ks = 1.8D;
/* 389 */     double inair = 0.2D;
/* 390 */     int var2 = 6;
/* 391 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 393 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */ 
/*     */         
/* 396 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 397 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 398 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/*     */ 
/*     */       
/* 402 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 406 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 415 */     boolean ret = false;
/* 416 */     if (this.hurt_timer > 0) return false;
/*     */     
/* 418 */     if (!par1DamageSource.getDamageType().equals("cactus") && !par1DamageSource.getDamageType().equals("fall")) {
/* 419 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 420 */       this.hurt_timer = 20;
/*     */       
/* 422 */       Entity e = par1DamageSource.getEntity();
/* 423 */       if (e != null && e instanceof EntityLiving) {
/*     */         
/* 425 */         setAttackTarget((EntityLivingBase)e);
/* 426 */         setTarget(e);
/* 427 */         getNavigator().tryMoveToEntityLiving(e, 1.2D);
/* 428 */         ret = true;
/*     */       } 
/*     */     } 
/* 431 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 437 */     EntityLivingBase e = null;
/* 438 */     if (this.isDead)
/* 439 */       return;  super.updateAITasks();
/* 440 */     if (this.hurt_timer > 0) this.hurt_timer--; 
/* 441 */     if (this.worldObj.rand.nextInt(5) == 0) {
/* 442 */       e = getAttackTarget();
/* 443 */       if (e != null && !e.isEntityAlive()) {
/* 444 */         setAttackTarget(null);
/* 445 */         e = null;
/*     */       } 
/* 447 */       if (e == null) {
/* 448 */         e = findSomethingToAttack();
/*     */       }
/* 450 */       if (e != null) {
/* 451 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 452 */         if (this.worldObj.rand.nextInt(10) == 1 && !this.isAirBorne)
/* 453 */         { jumpAtEntity(e); }
/*     */         
/* 455 */         else if (getDistanceSqToEntity((Entity)e) < ((5.0F + e.width / 2.0F) * (5.0F + e.width / 2.0F)))
/* 456 */         { setAttacking(1);
/*     */           
/* 458 */           if (this.worldObj.rand.nextInt(6) == 0 || this.worldObj.rand.nextInt(7) == 1) {
/*     */             
/* 460 */             attackEntityAsMob((Entity)e);
/* 461 */             if (!this.worldObj.isRemote) {
/* 462 */               if (this.worldObj.rand.nextInt(3) == 1) {
/* 463 */                 this.worldObj.playSoundAtEntity((Entity)e, "orespawn:scorpion_attack", 1.4F, 1.0F);
/*     */               } else {
/* 465 */                 this.worldObj.playSoundAtEntity((Entity)e, "orespawn:clatter", 1.0F, 1.0F);
/*     */               }
/*     */             
/*     */             }
/*     */           }  }
/* 470 */         else if (!this.isAirBorne) { getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D); }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 475 */         if (this.worldObj.rand.nextInt(30) == 1)
/*     */         {
/*     */           
/* 478 */           EntityCreature newent = (EntityCreature)spawnCreature(this.worldObj, "Spit Bug", (this.posX + e.posX) / 2.0D + this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5), (this.posY + e.posY) / 2.0D + 1.01D, (this.posZ + e.posZ) / 2.0D + this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5));
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 483 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */     
/* 487 */     if (this.worldObj.rand.nextInt(150) == 1 && 
/* 488 */       getHealth() < mygetMaxHealth())
/*     */     {
/* 490 */       heal(1.0F);
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
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 502 */     Entity var8 = null;
/* 503 */     var8 = EntityList.createEntityByName(par1, par0World);
/* 504 */     if (var8 != null) {
/*     */ 
/*     */       
/* 507 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 510 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 512 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/* 514 */     return var8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 524 */     if (par1EntityLiving == null)
/*     */     {
/* 526 */       return false;
/*     */     }
/* 528 */     if (par1EntityLiving == this)
/*     */     {
/* 530 */       return false;
/*     */     }
/* 532 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 534 */       return false;
/*     */     }
/*     */     
/* 537 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 539 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 542 */       return false;
/*     */     }
/*     */     
/* 545 */     if (par1EntityLiving instanceof Hydrolisc)
/*     */     {
/* 547 */       return false;
/*     */     }
/* 549 */     if (par1EntityLiving instanceof EnderReaper)
/*     */     {
/* 551 */       return false;
/*     */     }
/* 553 */     if (par1EntityLiving instanceof EnderKnight)
/*     */     {
/* 555 */       return false;
/*     */     }
/* 557 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityEnderman)
/*     */     {
/* 559 */       return false;
/*     */     }
/*     */     
/* 562 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCreeper)
/*     */     {
/* 564 */       return false;
/*     */     }
/* 566 */     if (par1EntityLiving instanceof TrooperBug)
/*     */     {
/* 568 */       return false;
/*     */     }
/* 570 */     if (par1EntityLiving instanceof SpitBug)
/*     */     {
/* 572 */       return false;
/*     */     }
/* 574 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 576 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 577 */       if (p.capabilities.isCreativeMode == true) {
/* 578 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 582 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 587 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 588 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 7.0D, 12.0D));
/* 589 */     Collections.sort(var5, this.TargetSorter);
/* 590 */     Iterator<?> var2 = var5.iterator();
/* 591 */     Entity var3 = null;
/* 592 */     EntityLivingBase var4 = null;
/*     */     
/* 594 */     while (var2.hasNext()) {
/*     */       
/* 596 */       var3 = (Entity)var2.next();
/* 597 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 599 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 601 */         return var4;
/*     */       }
/*     */     } 
/* 604 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 609 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 614 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/*     */     int k;
/* 625 */     for (k = -3; k < 3; k++) {
/*     */       
/* 627 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 629 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 631 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 632 */           if (bid == Blocks.mob_spawner) {
/* 633 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 634 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 635 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 636 */             if (s != null && 
/* 637 */               s.equals("Jumpy Bug")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 643 */     if (!isValidLightLevel()) return false; 
/* 644 */     if (this.worldObj.isDaytime() == true && 
/* 645 */       this.worldObj.rand.nextInt(20) > 1) {
/* 646 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 651 */     for (k = -2; k < 2; k++) {
/*     */       
/* 653 */       for (int j = -2; j < 2; j++) {
/*     */         
/* 655 */         for (int i = 1; i < 5; i++) {
/*     */           
/* 657 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 658 */           if (bid != Blocks.air) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 662 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\TrooperBug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */