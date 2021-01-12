/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EnderReaper
/*     */   extends EntityMob
/*     */ {
/*  28 */   private static final UUID attackingSpeedBoostModifierUUID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
/*  29 */   private static final AttributeModifier attackingSpeedBoostModifier = (new AttributeModifier(attackingSpeedBoostModifierUUID, "Attacking speed boost", 6.199999809265137D, 0)).setSaved(false);
/*     */ 
/*     */ 
/*     */   
/*     */   private int teleportDelay;
/*     */ 
/*     */ 
/*     */   
/*     */   private int stareTimer;
/*     */ 
/*     */   
/*     */   private Entity lastEntityToAttack;
/*     */ 
/*     */ 
/*     */   
/*     */   public EnderReaper(World par1World) {
/*  45 */     super(par1World);
/*  46 */     setSize(0.7F, 2.9F);
/*  47 */     this.stepHeight = 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  52 */     super.applyEntityAttributes();
/*  53 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(OreSpawnMain.EnderReaper_stats.health);
/*  54 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.37D);
/*  55 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.EnderReaper_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  60 */     super.entityInit();
/*  61 */     this.dataWatcher.addObject(18, new Byte((byte)0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/*  69 */     super.writeEntityToNBT(par1NBTTagCompound);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/*  77 */     super.readEntityFromNBT(par1NBTTagCompound);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity findPlayerToAttack() {
/*  86 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/*  87 */     EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, 81.0D);
/*     */     
/*  89 */     if (entityplayer != null) {
/*     */       
/*  91 */       if (shouldAttackPlayer(entityplayer)) {
/*     */ 
/*     */         
/*  94 */         if (this.stareTimer == 0)
/*     */         {
/*  96 */           this.worldObj.playSoundAtEntity((Entity)entityplayer, "mob.endermen.stare", 1.0F, 1.0F);
/*     */         }
/*     */         
/*  99 */         if (this.stareTimer++ == 5)
/*     */         {
/* 101 */           this.stareTimer = 0;
/*     */         }
/*     */         
/* 104 */         setScreaming(true);
/* 105 */         return (Entity)entityplayer;
/*     */       } 
/*     */ 
/*     */       
/* 109 */       this.stareTimer = 0;
/* 110 */       setScreaming(false);
/*     */     } 
/*     */ 
/*     */     
/* 114 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean shouldAttackPlayer(EntityPlayer par1EntityPlayer) {
/* 122 */     ItemStack itemstack = par1EntityPlayer.inventory.armorInventory[3];
/*     */     
/* 124 */     if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.pumpkin))
/*     */     {
/* 126 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 130 */     Vec3 vec3 = par1EntityPlayer.getLook(1.0F).normalize();
/* 131 */     Vec3 vec31 = Vec3.createVectorHelper(this.posX - par1EntityPlayer.posX, this.boundingBox.minY + (this.height / 2.0F) - par1EntityPlayer.posY + par1EntityPlayer.getEyeHeight(), this.posZ - par1EntityPlayer.posZ);
/* 132 */     double d0 = vec31.lengthVector();
/* 133 */     vec31 = vec31.normalize();
/* 134 */     double d1 = vec3.dotProduct(vec31);
/* 135 */     return (d1 > 1.0D - 0.025D / d0) ? par1EntityPlayer.canEntityBeSeen((Entity)this) : false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 145 */     if (isWet())
/*     */     {
/* 147 */       attackEntityFrom(DamageSource.drown, 1.0F);
/*     */     }
/*     */     
/* 150 */     if (this.lastEntityToAttack != this.entityToAttack) {
/*     */       
/* 152 */       IAttributeInstance attributeinstance = getEntityAttribute(SharedMonsterAttributes.movementSpeed);
/* 153 */       attributeinstance.removeModifier(attackingSpeedBoostModifier);
/*     */       
/* 155 */       if (this.entityToAttack != null)
/*     */       {
/* 157 */         attributeinstance.applyModifier(attackingSpeedBoostModifier);
/*     */       }
/*     */     } 
/*     */     
/* 161 */     this.lastEntityToAttack = this.entityToAttack;
/*     */ 
/*     */ 
/*     */     
/* 165 */     for (int i = 0; i < 2; i++)
/*     */     {
/* 167 */       this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5D) * this.width, this.posY + this.rand.nextDouble() * this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
/*     */     }
/*     */     
/* 170 */     if (this.worldObj.isDaytime() && !this.worldObj.isRemote) {
/*     */       
/* 172 */       float f = getBrightness(1.0F);
/*     */       
/* 174 */       if (f > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
/*     */         
/* 176 */         this.entityToAttack = null;
/* 177 */         setScreaming(false);
/* 178 */         teleportRandomly();
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     if (isWet() || isBurning()) {
/*     */       
/* 184 */       setScreaming(false);
/* 185 */       teleportRandomly();
/*     */     } 
/*     */ 
/*     */     
/* 189 */     this.isJumping = false;
/*     */     
/* 191 */     if (this.entityToAttack != null)
/*     */     {
/* 193 */       faceEntity(this.entityToAttack, 100.0F, 100.0F);
/*     */     }
/*     */     
/* 196 */     if (!this.worldObj.isRemote && isEntityAlive())
/*     */     {
/* 198 */       if (this.entityToAttack != null) {
/*     */         
/* 200 */         if (this.entityToAttack instanceof EntityPlayer && shouldAttackPlayer((EntityPlayer)this.entityToAttack))
/*     */         {
/* 202 */           if (this.entityToAttack.getDistanceSqToEntity((Entity)this) < 16.0D)
/*     */           {
/* 204 */             teleportRandomly();
/*     */           }
/*     */           
/* 207 */           this.teleportDelay = 0;
/*     */         }
/* 209 */         else if (this.entityToAttack.getDistanceSqToEntity((Entity)this) > 256.0D && this.teleportDelay++ >= 30 && teleportToEntity(this.entityToAttack))
/*     */         {
/* 211 */           this.teleportDelay = 0;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 216 */         setScreaming(false);
/* 217 */         this.teleportDelay = 0;
/*     */       } 
/*     */     }
/*     */     
/* 221 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean teleportRandomly() {
/* 229 */     double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
/* 230 */     double d1 = this.posY + (this.rand.nextInt(64) - 32);
/* 231 */     double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
/* 232 */     return teleportTo(d0, d1, d2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean teleportToEntity(Entity par1Entity) {
/* 240 */     Vec3 vec3 = Vec3.createVectorHelper(this.posX - par1Entity.posX, this.boundingBox.minY + (this.height / 2.0F) - par1Entity.posY + par1Entity.getEyeHeight(), this.posZ - par1Entity.posZ);
/* 241 */     vec3 = vec3.normalize();
/* 242 */     double d0 = 16.0D;
/* 243 */     double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.xCoord * d0;
/* 244 */     double d2 = this.posY + (this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
/* 245 */     double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.zCoord * d0;
/* 246 */     return teleportTo(d1, d2, d3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean teleportTo(double par1, double par3, double par5) {
/* 256 */     double d3 = this.posX;
/* 257 */     double d4 = this.posY;
/* 258 */     double d5 = this.posZ;
/* 259 */     this.posX = par1;
/* 260 */     this.posY = par3;
/* 261 */     this.posZ = par5;
/* 262 */     boolean flag = false;
/* 263 */     int i = MathHelper.floor_double(this.posX);
/* 264 */     int j = MathHelper.floor_double(this.posY);
/* 265 */     int k = MathHelper.floor_double(this.posZ);
/*     */ 
/*     */     
/* 268 */     if (this.worldObj.blockExists(i, j, k)) {
/*     */       
/* 270 */       boolean flag1 = false;
/*     */       
/* 272 */       while (!flag1 && j > 0) {
/*     */         
/* 274 */         Block l = this.worldObj.getBlock(i, j - 1, k);
/*     */         
/* 276 */         if (l != Blocks.air && l.getMaterial().blocksMovement()) {
/*     */           
/* 278 */           flag1 = true;
/*     */           
/*     */           continue;
/*     */         } 
/* 282 */         this.posY--;
/* 283 */         j--;
/*     */       } 
/*     */ 
/*     */       
/* 287 */       if (flag1) {
/*     */         
/* 289 */         setPosition(this.posX, this.posY, this.posZ);
/*     */         
/* 291 */         if (this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox))
/*     */         {
/* 293 */           flag = true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 298 */     if (!flag) {
/*     */       
/* 300 */       setPosition(d3, d4, d5);
/* 301 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 305 */     short short1 = 128;
/*     */     
/* 307 */     for (int lx = 0; lx < short1; lx++) {
/*     */       
/* 309 */       double d6 = lx / (short1 - 1.0D);
/* 310 */       float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
/* 311 */       float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
/* 312 */       float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
/* 313 */       double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5D) * this.width * 2.0D;
/* 314 */       double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * this.height;
/* 315 */       double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5D) * this.width * 2.0D;
/* 316 */       this.worldObj.spawnParticle("portal", d7, d8, d9, f, f1, f2);
/*     */     } 
/*     */     
/* 319 */     this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
/* 320 */     playSound("mob.endermen.portal", 1.0F, 1.0F);
/* 321 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 330 */     return isScreaming() ? "mob.endermen.scream" : "mob.endermen.idle";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 338 */     return "mob.endermen.hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 346 */     return "mob.endermen.death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 354 */     return Items.ender_eye;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 362 */     return OreSpawnMain.EnderReaper_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 371 */     Item j = getDropItem();
/*     */     
/* 373 */     if (j != null) {
/*     */       
/* 375 */       int k = this.rand.nextInt(2 + par2);
/*     */       
/* 377 */       for (int l = 0; l < k; l++)
/*     */       {
/* 379 */         dropItem(j, 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 390 */     if (isEntityInvulnerable())
/*     */     {
/* 392 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 396 */     setScreaming(true);
/*     */     
/* 398 */     if (par1DamageSource instanceof net.minecraft.util.EntityDamageSourceIndirect) {
/*     */ 
/*     */       
/* 401 */       for (int i = 0; i < 16; i++) {
/*     */         
/* 403 */         if (teleportRandomly())
/*     */         {
/* 405 */           return true;
/*     */         }
/*     */       } 
/*     */       
/* 409 */       return super.attackEntityFrom(par1DamageSource, par2);
/*     */     } 
/*     */ 
/*     */     
/* 413 */     return super.attackEntityFrom(par1DamageSource, par2);
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
/* 424 */     for (int k = -3; k < 3; k++) {
/*     */       
/* 426 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 428 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 430 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 431 */           if (bid == Blocks.mob_spawner) {
/* 432 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 433 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 434 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 435 */             if (s != null && 
/* 436 */               s.equals("Ender Reaper")) {
/* 437 */               return true;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 444 */     if (!isValidLightLevel()) return false; 
/* 445 */     if (this.worldObj.isDaytime() == true) return false; 
/* 446 */     if (this.posY < 30.0D) return false; 
/* 447 */     EnderReaper target = null;
/* 448 */     target = (EnderReaper)this.worldObj.findNearestEntityWithinAABB(EnderReaper.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D), (Entity)this);
/* 449 */     if (target != null)
/*     */     {
/* 451 */       return false;
/*     */     }
/* 453 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isScreaming() {
/* 458 */     return (this.dataWatcher.getWatchableObjectByte(18) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScreaming(boolean par1) {
/* 463 */     this.dataWatcher.updateObject(18, Byte.valueOf((byte)(par1 ? 1 : 0)));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EnderReaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */