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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EmperorScorpion
/*     */   extends EntityMob
/*     */ {
/*  60 */   private GenericTargetSorter TargetSorter = null;
/*  61 */   private RenderInfo renderdata = new RenderInfo();
/*  62 */   private int hurt_timer = 0;
/*  63 */   private float moveSpeed = 0.35F;
/*     */ 
/*     */   
/*     */   public EmperorScorpion(World par1World) {
/*  67 */     super(par1World);
/*     */     
/*  69 */     setSize(3.5F, 3.0F);
/*  70 */     getNavigator().setAvoidsWater(true);
/*  71 */     this.experienceValue = 200;
/*  72 */     this.fireResistance = 100;
/*  73 */     this.isImmuneToFire = true;
/*  74 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  75 */     this.renderdata = new RenderInfo();
/*  76 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  77 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.8999999761581421D, false));
/*  78 */     this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0D));
/*     */     
/*  80 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  81 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  82 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  88 */     super.entityInit();
/*  89 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*  90 */     if (this.renderdata == null) {
/*  91 */       this.renderdata = new RenderInfo();
/*     */     }
/*  93 */     this.renderdata.rf1 = 0.0F;
/*  94 */     this.renderdata.rf2 = 0.0F;
/*  95 */     this.renderdata.rf3 = 0.0F;
/*  96 */     this.renderdata.rf4 = 0.0F;
/*  97 */     this.renderdata.ri1 = 0;
/*  98 */     this.renderdata.ri2 = 0;
/*  99 */     this.renderdata.ri3 = 0;
/* 100 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/* 105 */     super.applyEntityAttributes();
/* 106 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/* 107 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 108 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.EmperorScorpion_stats.attack);
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
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 127 */     return OreSpawnMain.EmperorScorpion_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/* 134 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/* 139 */     this.renderdata.rf1 = r.rf1;
/* 140 */     this.renderdata.rf2 = r.rf2;
/* 141 */     this.renderdata.rf3 = r.rf3;
/* 142 */     this.renderdata.rf4 = r.rf4;
/* 143 */     this.renderdata.ri1 = r.ri1;
/* 144 */     this.renderdata.ri2 = r.ri2;
/* 145 */     this.renderdata.ri3 = r.ri3;
/* 146 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 154 */     return OreSpawnMain.EmperorScorpion_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 162 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 171 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void jump() {
/* 177 */     super.jump();
/* 178 */     this.motionY += 0.25D;
/* 179 */     this.posY += 0.5D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getEmperorScorpionHealth() {
/* 186 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 195 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 203 */     return "orespawn:alo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 211 */     return "orespawn:emperorscorpion_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 218 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 225 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 235 */     return Items.beef;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 240 */     EntityItem var3 = null;
/* 241 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 243 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), is);
/*     */     
/* 245 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 246 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 254 */     dropItemRand(OreSpawnMain.MyEmperorScorpionScale, 1);
/* 255 */     dropItemRand(Items.item_frame, 1);
/*     */     
/* 257 */     int i = 4 + this.worldObj.rand.nextInt(5); int var4;
/* 258 */     for (var4 = 0; var4 < i; var4++) {
/* 259 */       dropItemRand(Item.getItemFromBlock(Blocks.obsidian), 1);
/*     */     }
/*     */     
/* 262 */     i = 4 + this.worldObj.rand.nextInt(8);
/* 263 */     for (var4 = 0; var4 < i; var4++) {
/* 264 */       dropItemRand(Items.beef, 1);
/*     */     }
/*     */     
/* 267 */     i = 1 + this.worldObj.rand.nextInt(5);
/* 268 */     for (var4 = 0; var4 < i; var4++) {
/* 269 */       ItemStack is; int var3 = this.worldObj.rand.nextInt(20);
/* 270 */       switch (var3) {
/*     */         case 0:
/* 272 */           is = dropItemRand(OreSpawnMain.MyUltimateSword, 1);
/*     */           break;
/*     */         case 1:
/* 275 */           is = dropItemRand(Items.diamond, 1);
/*     */           break;
/*     */         case 2:
/* 278 */           is = dropItemRand(Item.getItemFromBlock(Blocks.diamond_block), 1);
/*     */           break;
/*     */         case 3:
/* 281 */           is = dropItemRand(Items.diamond_sword, 1);
/* 282 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/* 283 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5)); 
/* 284 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5)); 
/* 285 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5)); 
/* 286 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 287 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5)); 
/* 288 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 4:
/* 291 */           is = dropItemRand(Items.diamond_shovel, 1);
/* 292 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 293 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 5:
/* 296 */           is = dropItemRand(Items.diamond_pickaxe, 1);
/* 297 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 298 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/* 299 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 6:
/* 302 */           is = dropItemRand(Items.diamond_axe, 1);
/* 303 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 304 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 7:
/* 307 */           is = dropItemRand(Items.diamond_hoe, 1);
/* 308 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 309 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 8:
/* 312 */           is = dropItemRand((Item)Items.diamond_helmet, 1);
/* 313 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 314 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 315 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 316 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 317 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/* 318 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2)); 
/* 319 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5)); 
/*     */           break;
/*     */         case 9:
/* 322 */           is = dropItemRand((Item)Items.diamond_chestplate, 1);
/* 323 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 324 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 325 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 326 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 327 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*     */           break;
/*     */         case 10:
/* 330 */           is = dropItemRand((Item)Items.diamond_leggings, 1);
/* 331 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5)); 
/* 332 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 333 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 334 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5)); 
/* 335 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*     */           break;
/*     */         case 11:
/* 338 */           is = dropItemRand((Item)Items.diamond_boots, 1);
/* 339 */           if (this.worldObj.rand.nextInt(6) == 1) is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5)); 
/* 340 */           if (this.worldObj.rand.nextInt(2) == 1) is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4)); 
/*     */           break;
/*     */         case 12:
/* 343 */           is = dropItemRand(OreSpawnMain.MyUltimateBow, 1);
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
/* 367 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 372 */     double ks = 3.0D;
/* 373 */     double inair = 0.2D;
/* 374 */     int var2 = 6;
/*     */     
/* 376 */     if (super.attackEntityAsMob(par1Entity)) {
/*     */       
/* 378 */       if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*     */ 
/*     */         
/* 381 */         if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
/*     */           
/* 383 */           var2 = 8;
/* 384 */           if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
/*     */             
/* 386 */             var2 = 10;
/*     */           }
/* 388 */           else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
/*     */             
/* 390 */             var2 = 12;
/*     */           } 
/*     */         } 
/*     */         
/* 394 */         if (this.worldObj.rand.nextInt(3) == 1) {
/* 395 */           ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, var2 * 15, 0));
/*     */         }
/*     */         
/* 398 */         float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 399 */         if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 400 */         par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/*     */ 
/*     */       
/* 404 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 408 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 417 */     boolean ret = false;
/* 418 */     if (this.hurt_timer > 0) return false;
/*     */     
/* 420 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 421 */       ret = super.attackEntityFrom(par1DamageSource, par2);
/* 422 */       this.hurt_timer = 30;
/*     */       
/* 424 */       Entity e = par1DamageSource.getEntity();
/* 425 */       if (e != null && e instanceof EntityLiving) {
/*     */         
/* 427 */         setAttackTarget((EntityLivingBase)e);
/* 428 */         setTarget(e);
/* 429 */         getNavigator().tryMoveToEntityLiving(e, 1.2D);
/*     */       } 
/*     */     } 
/*     */     
/* 433 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 439 */     EntityLivingBase e = null;
/* 440 */     if (this.isDead)
/* 441 */       return;  super.updateAITasks();
/* 442 */     if (this.hurt_timer > 0) this.hurt_timer--; 
/* 443 */     if (this.worldObj.rand.nextInt(4) == 0) {
/* 444 */       e = getAttackTarget();
/* 445 */       if (e != null && !e.isEntityAlive()) {
/* 446 */         setAttackTarget(null);
/* 447 */         e = null;
/*     */       } 
/* 449 */       if (this.worldObj.rand.nextInt(100) == 0) setAttackTarget(null); 
/* 450 */       if (e == null) {
/* 451 */         e = findSomethingToAttack();
/*     */       }
/* 453 */       if (e != null) {
/* 454 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 455 */         if (getDistanceSqToEntity((Entity)e) < ((6.0F + e.width / 2.0F) * (6.0F + e.width / 2.0F))) {
/* 456 */           setAttacking(1);
/*     */           
/* 458 */           if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(6) == 1) {
/*     */             
/* 460 */             attackEntityAsMob((Entity)e);
/* 461 */             if (!this.worldObj.isRemote) {
/* 462 */               if (this.worldObj.rand.nextInt(3) == 1) {
/* 463 */                 this.worldObj.playSoundAtEntity((Entity)e, "orespawn:scorpion_attack", 1.4F, 1.0F);
/*     */               } else {
/* 465 */                 this.worldObj.playSoundAtEntity((Entity)e, "orespawn:scorpion_living", 1.0F, 1.0F);
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } else {
/* 470 */           getNavigator().tryMoveToEntityLiving((Entity)e, 1.2D);
/*     */         } 
/*     */ 
/*     */         
/* 474 */         if (this.worldObj.rand.nextInt(20) == 1)
/*     */         {
/*     */           
/* 477 */           EntityCreature newent = (EntityCreature)spawnCreature(this.worldObj, "Scorpion", (this.posX + e.posX) / 2.0D + this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5), (this.posY + e.posY) / 2.0D + 1.01D, (this.posZ + e.posZ) / 2.0D + this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5));
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 482 */         setAttacking(0);
/*     */       } 
/*     */     } 
/*     */     
/* 486 */     if (this.worldObj.rand.nextInt(100) == 1 && 
/* 487 */       getHealth() < mygetMaxHealth())
/*     */     {
/* 489 */       heal(2.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 500 */     Entity var8 = null;
/* 501 */     var8 = EntityList.createEntityByName(par1, par0World);
/* 502 */     if (var8 != null) {
/*     */ 
/*     */       
/* 505 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 508 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 510 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/* 512 */     return var8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 522 */     if (par1EntityLiving == null)
/*     */     {
/* 524 */       return false;
/*     */     }
/* 526 */     if (par1EntityLiving == this)
/*     */     {
/* 528 */       return false;
/*     */     }
/* 530 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 532 */       return false;
/*     */     }
/* 534 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 537 */       return false;
/*     */     }
/*     */     
/* 540 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 542 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityEnderman)
/*     */     {
/* 544 */       return false;
/*     */     }
/* 546 */     if (par1EntityLiving instanceof EnderKnight)
/*     */     {
/* 548 */       return false;
/*     */     }
/* 550 */     if (par1EntityLiving instanceof EnderReaper)
/*     */     {
/* 552 */       return false;
/*     */     }
/*     */     
/* 555 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCreeper)
/*     */     {
/* 557 */       return false;
/*     */     }
/* 559 */     if (par1EntityLiving instanceof Scorpion)
/*     */     {
/* 561 */       return false;
/*     */     }
/* 563 */     if (par1EntityLiving instanceof EmperorScorpion)
/*     */     {
/* 565 */       return false;
/*     */     }
/* 567 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 569 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 570 */       if (p.capabilities.isCreativeMode == true) {
/* 571 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 575 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 580 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 581 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(24.0D, 6.0D, 24.0D));
/* 582 */     Collections.sort(var5, this.TargetSorter);
/* 583 */     Iterator<?> var2 = var5.iterator();
/* 584 */     Entity var3 = null;
/* 585 */     EntityLivingBase var4 = null;
/*     */     
/* 587 */     while (var2.hasNext()) {
/*     */       
/* 589 */       var3 = (Entity)var2.next();
/* 590 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 592 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 594 */         return var4;
/*     */       }
/*     */     } 
/* 597 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getAttacking() {
/* 602 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAttacking(int par1) {
/* 607 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
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
/*     */   public boolean getCanSpawnHere() {
/* 624 */     for (int k = -2; k < 2; k++) {
/*     */       
/* 626 */       for (int j = -2; j < 2; j++) {
/*     */         
/* 628 */         for (int i = 2; i < 5; i++) {
/*     */           
/* 630 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 631 */           if (bid == Blocks.mob_spawner) {
/* 632 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 633 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 634 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 635 */             if (s != null && 
/* 636 */               s.equals("Emperor Scorpion")) return true;
/*     */           
/*     */           } 
/* 639 */           if (bid != Blocks.air) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 643 */     if (!isValidLightLevel()) return false; 
/* 644 */     if (this.worldObj.isDaytime() == true) return false; 
/* 645 */     if (this.posY < 50.0D) return false;
/*     */ 
/*     */     
/* 648 */     EmperorScorpion target = null;
/* 649 */     target = (EmperorScorpion)this.worldObj.findNearestEntityWithinAABB(EmperorScorpion.class, this.boundingBox.expand(20.0D, 6.0D, 20.0D), (Entity)this);
/* 650 */     if (target != null)
/*     */     {
/* 652 */       return false;
/*     */     }
/* 654 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EmperorScorpion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */