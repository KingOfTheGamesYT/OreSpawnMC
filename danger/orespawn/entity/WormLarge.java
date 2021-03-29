/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.init.ModItems;
/*     */ import danger.orespawn.util.ai.MyEntityAIWanderALot;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
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
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WormLarge
/*     */   extends EntityMob
/*     */ {
/*  44 */   private int wormsSpawned = 0;
/*     */   
/*     */   public WormLarge(World par1World) {
/*  47 */     super(par1World);
/*  48 */     setSize(1.55F, 2.5F);
/*     */     
/*  50 */     this.experienceValue = 2050;
/*  51 */     this.noClip = true;
/*  52 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  53 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  54 */     this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0D));
/*  55 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  56 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  61 */     super.applyEntityAttributes();
/*  62 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  63 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
/*  64 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(18.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  69 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  75 */     return 0.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  81 */     return 1.0F;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/*  86 */     return null;
/*     */   }
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/*  89 */     return SoundsHandler.BIG_SPLAT;
/*     */   }
/*     */   
/*     */   public void onDeath(DamageSource cause) {
/*  93 */     super.onDeath(cause);
/*  94 */     playSound(SoundsHandler.ENTITY_ALOSAURUS_DEATH, getSoundVolume(), getSoundPitch());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 100 */     return true;
/*     */   }
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 106 */     return 90;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 111 */     return 14;
/*     */   }
/*     */   
/*     */   public boolean isAIDisabled() {
/* 115 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void pointAtEntity(EntityLivingBase e) {
/* 120 */     double d1 = e.posX - this.posX;
/* 121 */     double d2 = e.posZ - this.posZ;
/* 122 */     float d = (float)Math.atan2(d2, d1);
/* 123 */     float f2 = (float)(d * 180.0D / Math.PI) - 90.0F;
/* 124 */     this.rotationYaw = this.rotationYawHead = f2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 131 */     EntityPlayer target = null;
/* 132 */     WormMedium worms = null;
/* 133 */     EntityCreature newent = null;
/* 134 */     super.onLivingUpdate();
/*     */ 
/*     */     
/* 137 */     worms = (WormMedium)this.world.findNearestEntityWithinAABB(WormMedium.class, getEntityBoundingBox().expand(8.0D, 8.0D, 8.0D), (Entity)this);
/* 138 */     if (worms == null) target = (EntityPlayer)this.world.findNearestEntityWithinAABB(EntityPlayer.class, getEntityBoundingBox().expand(8.0D, 8.0D, 8.0D), (Entity)this); 
/* 139 */     if ((worms == null && target != null) || OreSpawnMain.PlayNicely != 0) {
/*     */       
/* 141 */       if (target != null) pointAtEntity((EntityLivingBase)target); 
/* 142 */       Block bid = this.world.getBlockState(new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ)).getBlock();
/* 143 */       if (bid == Blocks.TALLGRASS) bid = Blocks.AIR; 
/* 144 */       if (bid != Blocks.AIR) {
/* 145 */         this.motionY += 0.25D;
/* 146 */         this.posY += 0.10000000149011612D;
/*     */       } else {
/* 148 */         this.noClip = false;
/*     */       } 
/*     */     } else {
/* 151 */       this.noClip = true;
/* 152 */       Block bid = this.world.getBlockState(new BlockPos((int)this.posX, (int)(this.posY + 3.5D), (int)this.posZ)).getBlock();
/* 153 */       if (bid == Blocks.TALLGRASS) bid = Blocks.AIR; 
/* 154 */       if (bid != Blocks.AIR) {
/* 155 */         this.motionY += 0.10000000149011612D;
/* 156 */         this.posY += 0.05000000074505806D;
/* 157 */         if (bid != Blocks.GRASS && bid != Blocks.DIRT && bid != Blocks.STONE) setDead();
/*     */       
/*     */       } 
/*     */     } 
/* 161 */     if (this.noClip) {
/* 162 */       this.motionY -= 0.01D;
/* 163 */       this.motionX = 0.0D;
/* 164 */       this.motionZ = 0.0D;
/* 165 */       this.moveForward = 0.0F;
/*     */     } 
/*     */     
/* 168 */     if (this.world.isRemote)
/*     */       return; 
/* 170 */     if (this.wormsSpawned != 0)
/* 171 */       return;  this.wormsSpawned = 1;
/*     */     
/* 173 */     for (int i = 0; i < 20; i++) {
/*     */ 
/*     */       
/* 176 */       newent = (EntityCreature)spawnCreature(this.world, "Small Worm", this.posX + this.world.rand
/* 177 */           .nextInt(6) - this.world.rand.nextInt(6), this.posY, this.posZ + this.world.rand
/*     */           
/* 179 */           .nextInt(6) - this.world.rand.nextInt(6));
/*     */       
/* 181 */       newent = (EntityCreature)spawnCreature(this.world, "Medium Worm", this.posX + this.world.rand
/* 182 */           .nextInt(5) - this.world.rand.nextInt(5), this.posY, this.posZ + this.world.rand
/*     */           
/* 184 */           .nextInt(5) - this.world.rand.nextInt(5));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 190 */     if (isNoDespawnRequired()) this.noClip = false; 
/* 191 */     super.onUpdate();
/* 192 */     this.motionY *= 0.85D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 197 */     int bid = 0;
/* 198 */     EntityPlayer target = null;
/* 199 */     WormMedium worms = null;
/*     */     
/* 201 */     if (this.isDead)
/* 202 */       return;  if (!this.noClip) super.updateAITasks(); 
/* 203 */     if (OreSpawnMain.PlayNicely != 0)
/* 204 */       return;  worms = (WormMedium)this.world.findNearestEntityWithinAABB(WormMedium.class, getEntityBoundingBox().expand(8.0D, 8.0D, 8.0D), (Entity)this);
/* 205 */     if (worms != null)
/*     */       return; 
/* 207 */     target = (EntityPlayer)this.world.findNearestEntityWithinAABB(EntityPlayer.class, getEntityBoundingBox().expand(8.0D, 6.0D, 8.0D), (Entity)this);
/* 208 */     if (target != null && 
/* 209 */       target.capabilities.isCreativeMode) {
/* 210 */       target = null;
/*     */     }
/*     */     
/* 213 */     if (target != null) {
/*     */       
/* 215 */       pointAtEntity((EntityLivingBase)target);
/* 216 */       getNavigator().tryMoveToXYZ(target.posX, target.posY, target.posZ, 1.0D);
/* 217 */       if (this.world.rand.nextInt(10) == 1 && getDistanceSq((Entity)target) < 3.0D) {
/*     */         
/* 219 */         attackEntityAsMob((Entity)target);
/* 220 */         if (this.world.rand.nextInt(4) == 1) {
/* 221 */           ItemStack boots = target.inventory.armorItemInSlot(4);
/*     */           
/* 223 */           target.inventory.setInventorySlotContents(4, null);
/*     */           
/* 225 */           bid = boots.getMaxDamage() - boots.getItemDamage();
/* 226 */           if (bid > 10) {
/* 227 */             bid /= 10;
/*     */           } else {
/* 229 */             bid = 1;
/*     */           } 
/* 231 */           boots.damageItem(bid, (EntityLivingBase)this);
/*     */ 
/*     */ 
/*     */           
/* 235 */           EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 3.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), boots);
/*     */           
/* 237 */           this.world.spawnEntity((Entity)var3);
/*     */         } 
/*     */ 
/*     */         
/* 241 */         if (this.world.rand.nextInt(4) == 1) {
/* 242 */           ItemStack boots = target.inventory.armorItemInSlot(0);
/*     */           
/* 244 */           target.inventory.setInventorySlotContents(0, null);
/*     */           
/* 246 */           bid = boots.getMaxDamage() - boots.getItemDamage();
/* 247 */           if (bid > 10) {
/* 248 */             bid /= 10;
/*     */           } else {
/* 250 */             bid = 1;
/*     */           } 
/* 252 */           boots.damageItem(bid, (EntityLivingBase)this);
/*     */ 
/*     */ 
/*     */           
/* 256 */           EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 3.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), boots);
/*     */           
/* 258 */           this.world.spawnEntity((Entity)var3);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 265 */     return false;
/*     */   }
/*     */   
/*     */   public void fall(float distance, float damageMultiplier) {
/* 269 */     if (!this.noClip) super.fall(distance, damageMultiplier);
/*     */   
/*     */   }
/*     */   
/*     */   protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
/* 274 */     if (!this.noClip) super.updateFallState(y, onGroundIn, state, pos); 
/*     */   }
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 278 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/*     */     int k;
/* 285 */     for (k = -3; k < 3; k++) {
/*     */       
/* 287 */       for (int j = -3; j < 3; j++) {
/*     */         
/* 289 */         for (int m = 0; m < 5; m++) {
/*     */           
/* 291 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + j, (int)this.posY + m, (int)this.posZ + k)).getBlock();
/* 292 */           if (bid == Blocks.MOB_SPAWNER) {
/* 293 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 294 */             tileentitymobspawner = (TileEntityMobSpawner)this.world.getTileEntity(new BlockPos((int)this.posX + j, (int)this.posY + m, (int)this.posZ + k));
/* 295 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getCachedEntity().getName();
/* 296 */             if (s.equals("Large Worm")) {
/* 297 */               this.wormsSpawned = 1;
/* 298 */               return true;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 305 */     if (this.posY < 50.0D) return false;
/*     */     
/* 307 */     WormLarge target = null;
/* 308 */     target = (WormLarge)this.world.findNearestEntityWithinAABB(WormLarge.class, getEntityBoundingBox().expand(32.0D, 8.0D, 32.0D), (Entity)this);
/* 309 */     if (target != null)
/*     */     {
/* 311 */       return false;
/*     */     }
/*     */     int i;
/* 314 */     for (i = -6; i <= 6; i++) {
/* 315 */       for (int j = -6; j <= 6; j++) {
/* 316 */         for (k = -2; k >= -8; k--) {
/* 317 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + i, (int)this.posY + k, (int)this.posZ + j)).getBlock();
/* 318 */           if (bid == Blocks.AIR) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 322 */     for (i = -6; i <= 6; i++) {
/* 323 */       for (int j = -6; j <= 6; j++) {
/* 324 */         for (k = 2; k <= 8; k++) {
/* 325 */           Block bid = this.world.getBlockState(new BlockPos((int)this.posX + i, (int)this.posY + k, (int)this.posZ + j)).getBlock();
/* 326 */           if (bid != Blocks.AIR) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 330 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 336 */     boolean ret = false;
/*     */     
/* 338 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/* 339 */       return ret;
/*     */     }
/*     */     
/* 342 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 344 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 350 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 351 */     par1NBTTagCompound.setInteger("wormsSpawned", this.wormsSpawned);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 357 */     super.readEntityFromNBT(par1NBTTagCompound);
/* 358 */     this.wormsSpawned = par1NBTTagCompound.getInteger("wormsSpawned");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 367 */     Entity var8 = null;
/* 368 */     var8 = EntityList.createEntityByIDFromName(new ResourceLocation(par1), par0World);
/*     */     
/* 370 */     if (var8 != null) {
/*     */ 
/*     */       
/* 373 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 376 */       par0World.spawnEntity(var8);
/*     */     } 
/* 378 */     return var8;
/*     */   }
/*     */   
/*     */   protected Item getDropItem() {
/* 382 */     return Items.ROTTEN_FLESH;
/*     */   }
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 386 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 2.5D + this.world.rand.nextInt(4), this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/* 387 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 395 */     dropItemRand(Items.ITEM_FRAME, 1);
/*     */     int var4;
/* 397 */     for (var4 = 0; var4 < 6; var4++) {
/* 398 */       dropItemRand(Items.ROTTEN_FLESH, 1);
/*     */     }
/* 400 */     for (var4 = 0; var4 < 6; var4++) {
/* 401 */       dropItemRand(Items.LEATHER, 1);
/*     */     }
/* 403 */     for (var4 = 0; var4 < 8; var4++) {
/* 404 */       dropItemRand(Item.getItemFromBlock(Blocks.DIRT), 1);
/*     */     }
/* 406 */     for (var4 = 0; var4 < 16; var4++) {
/* 407 */       dropItemRand(Items.GOLD_NUGGET, 1);
/*     */     }
/* 409 */     for (var4 = 0; var4 < 5; var4++) {
/* 410 */       dropItemRand(Items.DIAMOND, 1);
/*     */     }
/* 412 */     for (var4 = 0; var4 < 4; var4++) {
/* 413 */       dropItemRand(ModItems.URANIUM_NUGGET, 1);
/*     */     }
/* 415 */     for (var4 = 0; var4 < 4; var4++)
/* 416 */       dropItemRand(ModItems.TITANIUM_NUGGET, 1); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\WormLarge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */