/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
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
/*     */ public class WormLarge
/*     */   extends EntityMob
/*     */ {
/*  36 */   private int wormsSpawned = 0;
/*     */   
/*     */   public WormLarge(World par1World) {
/*  39 */     super(par1World);
/*     */     
/*  41 */     setSize(1.55F, 2.5F);
/*  42 */     getNavigator().setAvoidsWater(true);
/*  43 */     this.experienceValue = 2050;
/*  44 */     this.noClip = true;
/*  45 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  46 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  47 */     this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  48 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  49 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  54 */     super.applyEntityAttributes();
/*  55 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  56 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
/*  57 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.WormLarge_stats.attack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  63 */     super.entityInit();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  68 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  76 */     return 0.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  84 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/*  92 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 100 */     return "orespawn:big_splat";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 108 */     return "orespawn:alo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   protected void collideWithNearbyEntities() {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 125 */     return OreSpawnMain.WormLarge_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 133 */     return OreSpawnMain.WormLarge_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 141 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void pointAtEntity(EntityLivingBase e) {
/* 147 */     double d1 = e.posX - this.posX;
/* 148 */     double d2 = e.posZ - this.posZ;
/* 149 */     float d = (float)Math.atan2(d2, d1);
/* 150 */     float f2 = (float)(d * 180.0D / Math.PI) - 90.0F;
/* 151 */     this.rotationYaw = this.rotationYawHead = f2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 159 */     EntityPlayer target = null;
/* 160 */     WormMedium worms = null;
/* 161 */     EntityCreature newent = null;
/* 162 */     super.onLivingUpdate();
/*     */ 
/*     */     
/* 165 */     worms = (WormMedium)this.worldObj.findNearestEntityWithinAABB(WormMedium.class, this.boundingBox.expand(8.0D, 8.0D, 8.0D), (Entity)this);
/* 166 */     if (worms == null) target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(8.0D, 8.0D, 8.0D), (Entity)this); 
/* 167 */     if ((worms == null && target != null) || OreSpawnMain.PlayNicely != 0) {
/*     */       
/* 169 */       if (target != null) pointAtEntity((EntityLivingBase)target); 
/* 170 */       Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY, (int)this.posZ);
/* 171 */       if (bid == Blocks.tallgrass) bid = Blocks.air; 
/* 172 */       if (bid != Blocks.air) {
/* 173 */         this.motionY += 0.25D;
/* 174 */         this.posY += 0.10000000149011612D;
/*     */       } else {
/* 176 */         this.noClip = false;
/*     */       } 
/*     */     } else {
/* 179 */       this.noClip = true;
/* 180 */       Block bid = this.worldObj.getBlock((int)this.posX, (int)(this.posY + 3.5D), (int)this.posZ);
/* 181 */       if (bid == Blocks.tallgrass) bid = Blocks.air; 
/* 182 */       if (bid != Blocks.air) {
/* 183 */         this.motionY += 0.10000000149011612D;
/* 184 */         this.posY += 0.05000000074505806D;
/* 185 */         if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) setDead();
/*     */       
/*     */       } 
/*     */     } 
/* 189 */     if (this.noClip == true) {
/* 190 */       this.motionY -= 0.01D;
/* 191 */       this.motionX = 0.0D;
/* 192 */       this.motionZ = 0.0D;
/* 193 */       this.moveForward = 0.0F;
/*     */     } 
/*     */     
/* 196 */     if (this.worldObj.isRemote)
/*     */       return; 
/* 198 */     if (this.wormsSpawned != 0)
/* 199 */       return;  this.wormsSpawned = 1;
/*     */     
/* 201 */     for (int i = 0; i < 20; i++) {
/*     */ 
/*     */       
/* 204 */       newent = (EntityCreature)spawnCreature(this.worldObj, "Small Worm", this.posX + this.worldObj.rand.nextInt(6) - this.worldObj.rand.nextInt(6), this.posY, this.posZ + this.worldObj.rand.nextInt(6) - this.worldObj.rand.nextInt(6));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 209 */       newent = (EntityCreature)spawnCreature(this.worldObj, "Medium Worm", this.posX + this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5), this.posY, this.posZ + this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5));
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
/*     */   public void onUpdate() {
/* 221 */     if (isNoDespawnRequired()) this.noClip = false; 
/* 222 */     super.onUpdate();
/* 223 */     this.motionY *= 0.85D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 228 */     int bid = 0;
/* 229 */     EntityPlayer target = null;
/* 230 */     WormMedium worms = null;
/*     */     
/* 232 */     if (this.isDead)
/* 233 */       return;  if (!this.noClip) super.updateAITasks(); 
/* 234 */     if (OreSpawnMain.PlayNicely != 0)
/* 235 */       return;  worms = (WormMedium)this.worldObj.findNearestEntityWithinAABB(WormMedium.class, this.boundingBox.expand(8.0D, 8.0D, 8.0D), (Entity)this);
/* 236 */     if (worms != null)
/*     */       return; 
/* 238 */     target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(8.0D, 6.0D, 8.0D), (Entity)this);
/* 239 */     if (target != null && 
/* 240 */       target.capabilities.isCreativeMode == true) {
/* 241 */       target = null;
/*     */     }
/*     */     
/* 244 */     if (target != null) {
/*     */       
/* 246 */       pointAtEntity((EntityLivingBase)target);
/* 247 */       getNavigator().tryMoveToXYZ(target.posX, target.posY, target.posZ, 1.0D);
/* 248 */       if (this.worldObj.rand.nextInt(10) == 1 && getDistanceToEntity((Entity)target) < 3.0D) {
/*     */         
/* 250 */         attackEntityAsMob((Entity)target);
/* 251 */         if (this.worldObj.rand.nextInt(4) == 1) {
/* 252 */           ItemStack boots = target.getEquipmentInSlot(4);
/* 253 */           if (boots != null) {
/* 254 */             target.setCurrentItemOrArmor(4, null);
/* 255 */             bid = boots.getMaxDamage() - boots.getItemDamage();
/* 256 */             if (bid > 10) {
/* 257 */               bid /= 10;
/*     */             } else {
/* 259 */               bid = 1;
/*     */             } 
/* 261 */             boots.damageItem(bid, (EntityLivingBase)this);
/* 262 */             EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 3.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), boots);
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 267 */             this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */           } else {
/* 269 */             boots = target.getEquipmentInSlot(3);
/* 270 */             if (boots != null) {
/* 271 */               target.setCurrentItemOrArmor(3, null);
/* 272 */               bid = boots.getMaxDamage() - boots.getItemDamage();
/* 273 */               if (bid > 10) {
/* 274 */                 bid /= 10;
/*     */               } else {
/* 276 */                 bid = 1;
/*     */               } 
/* 278 */               boots.damageItem(bid, (EntityLivingBase)this);
/* 279 */               EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 3.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), boots);
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 284 */               this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 289 */         if (this.worldObj.rand.nextInt(4) == 1) {
/* 290 */           ItemStack boots = target.getEquipmentInSlot(0);
/* 291 */           if (boots != null) {
/* 292 */             target.setCurrentItemOrArmor(0, null);
/* 293 */             bid = boots.getMaxDamage() - boots.getItemDamage();
/* 294 */             if (bid > 10) {
/* 295 */               bid /= 10;
/*     */             } else {
/* 297 */               bid = 1;
/*     */             } 
/* 299 */             boots.damageItem(bid, (EntityLivingBase)this);
/* 300 */             EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 3.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), boots);
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 305 */             this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */           } 
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
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 319 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {
/* 326 */     if (!this.noClip) super.fall(par1);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFallState(double par1, boolean par3) {
/* 334 */     if (!this.noClip) super.updateFallState(par1, par3);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 342 */     return true;
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
/* 353 */     for (k = -3; k < 3; k++) {
/*     */       
/* 355 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 357 */         for (int m = 0; m < 5; m++) {
/*     */           
/* 359 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + m, (int)this.posZ + k);
/* 360 */           if (bid == Blocks.mob_spawner) {
/* 361 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 362 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + m, (int)this.posZ + k);
/* 363 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 364 */             if (s != null && 
/* 365 */               s.equals("Large Worm")) {
/* 366 */               this.wormsSpawned = 1;
/*     */               
/* 368 */               return true;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 376 */     if (this.posY < 50.0D) return false;
/*     */     
/* 378 */     WormLarge target = null;
/* 379 */     target = (WormLarge)this.worldObj.findNearestEntityWithinAABB(WormLarge.class, this.boundingBox.expand(32.0D, 8.0D, 32.0D), (Entity)this);
/* 380 */     if (target != null)
/*     */     {
/* 382 */       return false;
/*     */     }
/*     */     int i;
/* 385 */     for (i = -6; i <= 6; i++) {
/* 386 */       for (int j = -6; j <= 6; j++) {
/* 387 */         for (k = -2; k >= -8; k--) {
/* 388 */           Block bid = this.worldObj.getBlock((int)this.posX + i, (int)this.posY + k, (int)this.posZ + j);
/* 389 */           if (bid == Blocks.air) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 393 */     for (i = -6; i <= 6; i++) {
/* 394 */       for (int j = -6; j <= 6; j++) {
/* 395 */         for (k = 2; k <= 8; k++) {
/* 396 */           Block bid = this.worldObj.getBlock((int)this.posX + i, (int)this.posY + k, (int)this.posZ + j);
/* 397 */           if (bid != Blocks.air) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 401 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 411 */     boolean ret = false;
/*     */     
/* 413 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/* 414 */       return ret;
/*     */     }
/*     */     
/* 417 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 419 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 427 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 428 */     par1NBTTagCompound.setInteger("wormsSpawned", this.wormsSpawned);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 436 */     super.readEntityFromNBT(par1NBTTagCompound);
/* 437 */     this.wormsSpawned = par1NBTTagCompound.getInteger("wormsSpawned");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 446 */     Entity var8 = null;
/* 447 */     var8 = EntityList.createEntityByName(par1, par0World);
/* 448 */     if (var8 != null) {
/*     */ 
/*     */       
/* 451 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 454 */       par0World.spawnEntityInWorld(var8);
/*     */     } 
/*     */     
/* 457 */     return var8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 465 */     return Items.rotten_flesh;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 470 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 2.5D + this.worldObj.rand.nextInt(4), this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/*     */     
/* 472 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 478 */     dropItemRand(OreSpawnMain.WormTooth, 1);
/* 479 */     dropItemRand(Items.item_frame, 1);
/*     */     int var4;
/* 481 */     for (var4 = 0; var4 < 6; var4++) {
/* 482 */       dropItemRand(Items.rotten_flesh, 1);
/*     */     }
/* 484 */     for (var4 = 0; var4 < 6; var4++) {
/* 485 */       dropItemRand(Items.leather, 1);
/*     */     }
/* 487 */     for (var4 = 0; var4 < 8; var4++) {
/* 488 */       dropItemRand(Item.getItemFromBlock(Blocks.dirt), 1);
/*     */     }
/* 490 */     for (var4 = 0; var4 < 16; var4++) {
/* 491 */       dropItemRand(Items.gold_nugget, 1);
/*     */     }
/* 493 */     for (var4 = 0; var4 < 5; var4++) {
/* 494 */       dropItemRand(Items.diamond, 1);
/*     */     }
/* 496 */     for (var4 = 0; var4 < 4; var4++) {
/* 497 */       dropItemRand(OreSpawnMain.UraniumNugget, 1);
/*     */     }
/* 499 */     for (var4 = 0; var4 < 4; var4++)
/* 500 */       dropItemRand(OreSpawnMain.TitaniumNugget, 1); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\WormLarge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */