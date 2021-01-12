/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.enchantment.Enchantment;
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
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.DamageSource;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Basilisk
/*     */   extends EntityMob
/*     */ {
/*  54 */   private GenericTargetSorter TargetSorter = null;
/*  55 */   private int hurt_timer = 0;
/*  56 */   private float moveSpeed = 0.4F;
/*     */ 
/*     */   
/*     */   public Basilisk(World par1World) {
/*  60 */     super(par1World);
/*  61 */     setSize(1.6F, 3.5F);
/*  62 */     this.experienceValue = 150;
/*  63 */     this.fireResistance = 2000;
/*  64 */     this.isImmuneToFire = true;
/*  65 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  66 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  67 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  68 */     this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 20, 1.0D));
/*  69 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  70 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  71 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  76 */     super.applyEntityAttributes();
/*  77 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  78 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  79 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Basilisk_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  84 */     super.entityInit();
/*  85 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  89 */     if (isNoDespawnRequired()) return false; 
/*  90 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  99 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 100 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 105 */     return OreSpawnMain.Basilisk_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 113 */     return OreSpawnMain.Basilisk_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 121 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void jump() {
/* 127 */     this.motionY += 0.25D;
/* 128 */     super.jump();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 137 */     super.onLivingUpdate();
/* 138 */     if (this.isDead)
/* 139 */       return;  if (this.rand.nextInt(200) == 0) {
/* 140 */       heal(1.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBasiliskHealth() {
/* 148 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 157 */     if (this.rand.nextInt(2) == 0) {
/* 158 */       return "orespawn:basilisk_living";
/*     */     }
/* 160 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 169 */     return "orespawn:alo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 177 */     return "orespawn:emperorscorpion_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 184 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 191 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 199 */     return Items.beef;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 204 */     EntityItem var3 = null;
/* 205 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 207 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), is);
/*     */     
/* 209 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 210 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 216 */     ItemStack is = null;
/*     */     
/* 218 */     dropItemRand(OreSpawnMain.MyBasiliskScale, 1);
/* 219 */     dropItemRand(Items.item_frame, 1);
/*     */     
/* 221 */     int i = 12 + this.worldObj.rand.nextInt(6); int var4;
/* 222 */     for (var4 = 0; var4 < i; var4++) {
/* 223 */       dropItemRand(Items.emerald, 1);
/*     */     }
/*     */     
/* 226 */     i = 8 + this.worldObj.rand.nextInt(5);
/* 227 */     for (var4 = 0; var4 < i; var4++) {
/* 228 */       dropItemRand(Items.chicken, 1);
/*     */     }
/*     */     
/* 231 */     i = 3 + this.worldObj.rand.nextInt(5);
/* 232 */     for (var4 = 0; var4 < i; var4++) {
/* 233 */       int var3 = this.worldObj.rand.nextInt(15);
/* 234 */       switch (var3) {
/*     */         case 1:
/* 236 */           is = dropItemRand(Items.emerald, 1);
/*     */           break;
/*     */         case 2:
/* 239 */           is = dropItemRand(Item.getItemFromBlock(Blocks.emerald_block), 1);
/*     */           break;
/*     */         case 3:
/* 242 */           is = dropItemRand(OreSpawnMain.MyEmeraldSword, 1);
/* 243 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/* 244 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/* 245 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/* 246 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/* 247 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 248 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/* 249 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 4:
/* 252 */           is = dropItemRand(OreSpawnMain.MyEmeraldShovel, 1);
/* 253 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 254 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 5:
/* 257 */           is = dropItemRand(OreSpawnMain.MyEmeraldPickaxe, 1);
/* 258 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 259 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/* 260 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 6:
/* 263 */           is = dropItemRand(OreSpawnMain.MyEmeraldAxe, 1);
/* 264 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 265 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 7:
/* 268 */           is = dropItemRand(OreSpawnMain.MyEmeraldHoe, 1);
/* 269 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 270 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 8:
/* 273 */           is = dropItemRand((Item)OreSpawnMain.EmeraldHelmet, 1);
/* 274 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 275 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 276 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 277 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 278 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 279 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2)); 
/* 280 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 9:
/* 283 */           is = dropItemRand((Item)OreSpawnMain.EmeraldBody, 1);
/* 284 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 285 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 286 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 287 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 288 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*     */           break;
/*     */         case 10:
/* 291 */           is = dropItemRand((Item)OreSpawnMain.EmeraldLegs, 1);
/* 292 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 293 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 294 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 295 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 296 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*     */           break;
/*     */         case 11:
/* 299 */           is = dropItemRand((Item)OreSpawnMain.EmeraldBoots, 1);
/* 300 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/* 301 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
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
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 317 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 323 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 325 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */         
/* 327 */         int var2 = 8;
/*     */         
/* 329 */         if (this.worldObj.difficultySetting == EnumDifficulty.EASY)
/*     */         {
/* 331 */           var2 = 10;
/*     */         }
/* 333 */         if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
/*     */           
/* 335 */           var2 = 12;
/*     */         }
/* 337 */         else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
/*     */           
/* 339 */           var2 = 14;
/*     */         } 
/*     */         
/* 342 */         if (this.worldObj.rand.nextInt(3) == 0)
/*     */         {
/* 344 */           ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, var2 * 20, 0));
/*     */         }
/* 346 */         double ks = 1.5D;
/* 347 */         double inair = 0.15D;
/* 348 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 349 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 350 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/*     */ 
/*     */       
/* 354 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 358 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 365 */     if (this.hurt_timer > 0) return false; 
/* 366 */     this.hurt_timer = 30;
/* 367 */     return super.attackEntityFrom(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 373 */     if (this.isDead)
/* 374 */       return;  super.updateAITasks();
/*     */     
/* 376 */     if (this.hurt_timer > 0) this.hurt_timer--; 
/* 377 */     if (this.worldObj.rand.nextInt(5) == 0) {
/* 378 */       EntityLivingBase e = findSomethingToAttack();
/* 379 */       if (e != null) {
/* 380 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 381 */         if (getDistanceSqToEntity((Entity)e) < ((6.0F + e.width / 2.0F) * (6.0F + e.width / 2.0F))) {
/* 382 */           setAttacking(1);
/*     */           
/* 384 */           if (this.worldObj.rand.nextInt(3) == 0 || this.worldObj.rand.nextInt(4) == 1)
/*     */           {
/* 386 */             attackEntityAsMob((Entity)e);
/*     */           }
/*     */         } else {
/* 389 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/*     */         } 
/*     */         
/* 392 */         if (e instanceof EntityLivingBase)
/*     */         {
/* 394 */           e.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 5));
/*     */         }
/*     */       } else {
/* 397 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */     
/* 401 */     if (this.worldObj.rand.nextInt(75) == 1 && 
/* 402 */       getHealth() < mygetMaxHealth()) {
/* 403 */       heal(1.0F);
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
/* 415 */     if (par1EntityLiving == null)
/*     */     {
/* 417 */       return false;
/*     */     }
/* 419 */     if (par1EntityLiving == this)
/*     */     {
/* 421 */       return false;
/*     */     }
/* 423 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 425 */       return false;
/*     */     }
/* 427 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false; 
/* 428 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 431 */       return false;
/*     */     }
/* 433 */     if (par1EntityLiving instanceof Basilisk)
/*     */     {
/* 435 */       return false;
/*     */     }
/*     */     
/* 438 */     if (par1EntityLiving instanceof LeafMonster)
/*     */     {
/* 440 */       return false;
/*     */     }
/*     */     
/* 443 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 445 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 446 */       if (p.capabilities.isCreativeMode == true) {
/* 447 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 451 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 456 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 457 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(24.0D, 7.0D, 24.0D));
/* 458 */     Collections.sort(var5, this.TargetSorter);
/* 459 */     Iterator<?> var2 = var5.iterator();
/* 460 */     Entity var3 = null;
/* 461 */     EntityLivingBase var4 = null;
/*     */     
/* 463 */     while (var2.hasNext()) {
/*     */       
/* 465 */       var3 = (Entity)var2.next();
/* 466 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 468 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 470 */         return var4;
/*     */       }
/*     */     } 
/* 473 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 478 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 483 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
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
/* 494 */     for (k = -3; k < 3; k++) {
/*     */       
/* 496 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 498 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 500 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 501 */           if (bid == Blocks.mob_spawner) {
/* 502 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 503 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 504 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 505 */             if (s != null && 
/* 506 */               s.equals("Basilisk")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 512 */     if (!isValidLightLevel()) return false; 
/* 513 */     if (this.worldObj.isDaytime() == true) return false;
/*     */ 
/*     */ 
/*     */     
/* 517 */     for (k = -1; k < 2; k++) {
/*     */       
/* 519 */       for (int j = -1; j < 2; j++) {
/*     */         
/* 521 */         for (int i = 1; i < 5; i++) {
/*     */           
/* 523 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 524 */           if (bid != Blocks.air) return false;
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 530 */     Basilisk target = null;
/* 531 */     target = (Basilisk)this.worldObj.findNearestEntityWithinAABB(Basilisk.class, this.boundingBox.expand(20.0D, 6.0D, 20.0D), (Entity)this);
/* 532 */     if (target != null)
/*     */     {
/* 534 */       return false;
/*     */     }
/* 536 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Basilisk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */