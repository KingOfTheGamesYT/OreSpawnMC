/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.util.ai.MyEntityAIFollowOwner;
/*     */ import danger.orespawn.util.ai.MyEntityAIWander;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAIMoveIndoors;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITempt;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.MathHelper;
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
/*     */ public class VelocityRaptor
/*     */   extends EntityTameable
/*     */ {
/*  50 */   private float moveSpeed = 0.55F;
/*     */   private int closest; private int tx; private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*     */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*     */     getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
/*  54 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D); } public VelocityRaptor(World par1World) { super(par1World);
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
/* 135 */     this.closest = 99999;
/* 136 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.5F, 0.6F); setSitting(false); this.experienceValue = 5; this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new MyEntityAIFollowOwner(this, 1.5F, 10.0F, 2.0F)); this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.APPLE, false)); this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.600000023841858D)); this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F)); this.tasks.addTask(7, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 0.9F)); this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     this.tasks.addTask(9, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this)); }
/*     */   protected void entityInit() { super.entityInit();
/* 139 */     setSitting(false); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 144 */     for (i = -dy; i <= dy; i++) {
/* 145 */       for (int j = -dz; j <= dz; j++) {
/* 146 */         Block bid = this.world.getBlockState(new BlockPos(x + dx, y + i, z + j)).getBlock();
/*     */         
/* 148 */         if (bid == Blocks.TALLGRASS || bid == Blocks.YELLOW_FLOWER || bid == Blocks.RED_FLOWER || bid == Blocks.DEADBUSH || bid == Blocks.DOUBLE_PLANT) {
/* 149 */           int d = dx * dx + j * j + i * i;
/* 150 */           if (d < this.closest) {
/* 151 */             this.closest = d;
/* 152 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 153 */             found++;
/*     */           } 
/*     */         } 
/* 156 */         bid = this.world.getBlockState(new BlockPos(x - dx, y + i, z + j)).getBlock();
/*     */         
/* 158 */         if (bid == Blocks.TALLGRASS || bid == Blocks.YELLOW_FLOWER || bid == Blocks.RED_FLOWER || bid == Blocks.DEADBUSH || bid == Blocks.DOUBLE_PLANT) {
/* 159 */           int d = dx * dx + j * j + i * i;
/* 160 */           if (d < this.closest) {
/* 161 */             this.closest = d;
/* 162 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 163 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 169 */     for (i = -dx; i <= dx; i++) {
/* 170 */       for (int j = -dz; j <= dz; j++) {
/* 171 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + dy, z + j)).getBlock();
/*     */         
/* 173 */         if (bid == Blocks.TALLGRASS || bid == Blocks.YELLOW_FLOWER || bid == Blocks.RED_FLOWER || bid == Blocks.DEADBUSH || bid == Blocks.DOUBLE_PLANT) {
/* 174 */           int d = dy * dy + j * j + i * i;
/* 175 */           if (d < this.closest) {
/* 176 */             this.closest = d;
/* 177 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 178 */             found++;
/*     */           } 
/*     */         } 
/* 181 */         bid = this.world.getBlockState(new BlockPos(x + i, y - dy, z + j)).getBlock();
/*     */         
/* 183 */         if (bid == Blocks.TALLGRASS || bid == Blocks.YELLOW_FLOWER || bid == Blocks.RED_FLOWER || bid == Blocks.DEADBUSH || bid == Blocks.DOUBLE_PLANT) {
/* 184 */           int d = dy * dy + j * j + i * i;
/* 185 */           if (d < this.closest) {
/* 186 */             this.closest = d;
/* 187 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 188 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 194 */     for (i = -dx; i <= dx; i++) {
/* 195 */       for (int j = -dy; j <= dy; j++) {
/* 196 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + j, z + dz)).getBlock();
/*     */         
/* 198 */         if (bid == Blocks.TALLGRASS || bid == Blocks.YELLOW_FLOWER || bid == Blocks.RED_FLOWER || bid == Blocks.DEADBUSH || bid == Blocks.DOUBLE_PLANT) {
/* 199 */           int d = dz * dz + j * j + i * i;
/* 200 */           if (d < this.closest) {
/* 201 */             this.closest = d;
/* 202 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 203 */             found++;
/*     */           } 
/*     */         } 
/* 206 */         bid = this.world.getBlockState(new BlockPos(x + i, y + j, z - dz)).getBlock();
/*     */         
/* 208 */         if (bid == Blocks.TALLGRASS || bid == Blocks.YELLOW_FLOWER || bid == Blocks.RED_FLOWER || bid == Blocks.DEADBUSH || bid == Blocks.DOUBLE_PLANT) {
/* 209 */           int d = dz * dz + j * j + i * i;
/* 210 */           if (d < this.closest) {
/* 211 */             this.closest = d;
/* 212 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 213 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 219 */     return (found != 0); } public boolean getCanSpawnHere() { if (this.posY < 50.0D)
/*     */       return false;  if (!this.world.isDaytime())
/*     */       return false;  return true; }
/*     */   public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed); super.onUpdate(); }
/*     */   protected void fall(float par1) { float i = MathHelper.ceil(par1 - 3.0F); if (i > 0.0F) { if (i > 3.0F) { playSound(SoundEvents.ENTITY_GENERIC_BIG_FALL, 1.0F, 1.0F); } else { playSound(SoundEvents.ENTITY_GENERIC_SMALL_FALL, 1.0F, 1.0F); }  if (i > 2.0F)
/*     */         i = 2.0F;  attackEntityFrom(DamageSource.FALL, i); }  }
/* 225 */   public void onEntityUpdate() { super.onEntityUpdate();
/* 226 */     if (this.isDead)
/* 227 */       return;  if (this.world.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 228 */     if (!isSitting() && ((
/* 229 */       this.world.rand.nextInt(20) == 0 && getVHealth() < mygetMaxHealth()) || this.world.rand.nextInt(250) == 0))
/*     */     {
/*     */ 
/*     */       
/* 233 */       if (OreSpawnMain.PlayNicely == 0) {
/* 234 */         this.closest = 99999;
/* 235 */         this.tx = this.ty = this.tz = 0;
/* 236 */         for (int i = 1; i < 10; i++) {
/* 237 */           int j = i;
/* 238 */           if (j > 2) j = 2; 
/* 239 */           if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i))
/* 240 */             break;  if (i >= 5) i++;
/*     */         
/*     */         } 
/* 243 */         if (this.closest < 99999) {
/*     */           
/* 245 */           getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 246 */           if (this.closest < 12) {
/*     */             
/* 248 */             if (this.world.getGameRules().getBoolean("mobGriefing")) this.world.setBlockState(new BlockPos(this.tx, this.ty, this.tz), Blocks.AIR.getDefaultState());
/*     */             
/* 250 */             heal(2.0F);
/* 251 */             playSound(SoundEvents.ENTITY_PLAYER_BURP, 0.5F, this.world.rand.nextFloat() * 0.2F + 1.5F);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } }
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
/*     */   public boolean isAIDisabled() {
/* 308 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 313 */     return false;
/*     */   }
/*     */   
/*     */   public int mygetMaxHealth() {
/* 317 */     return isTamed() ? 20 : 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 326 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getVHealth() {
/* 333 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean processInteract(EntityPlayer par1EntityPlayer, EnumHand hand) {
/* 338 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 345 */     if (super.processInteract(par1EntityPlayer, EnumHand.MAIN_HAND)) {
/* 346 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 352 */     if (var2 != null && var2.getItem() == Items.APPLE && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D) {
/*     */       
/* 354 */       if (!isTamed()) {
/*     */         
/* 356 */         if (!this.world.isRemote)
/*     */         {
/* 358 */           if (this.rand.nextInt(2) == 0) {
/*     */             
/* 360 */             setTamedBy(par1EntityPlayer);
/*     */             
/* 362 */             playTameEffect(true);
/* 363 */             this.world.setEntityState((Entity)this, (byte)7);
/* 364 */             heal(mygetMaxHealth() - getHealth());
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 369 */             playTameEffect(false);
/* 370 */             this.world.setEntityState((Entity)this, (byte)6);
/*     */           } 
/*     */         }
/*     */       } else {
/*     */         
/* 375 */         if (this.world.isRemote) {
/* 376 */           playTameEffect(true);
/* 377 */           this.world.setEntityState((Entity)this, (byte)7);
/*     */           
/* 379 */           par1EntityPlayer.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6000000238418579D);
/*     */         } 
/* 381 */         if (mygetMaxHealth() > getHealth()) {
/* 382 */           heal(mygetMaxHealth() - getHealth());
/*     */         }
/*     */       } 
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
/* 399 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 401 */         var2.setCount(var2.getCount() - 1);
/* 402 */         if (var2.getCount() <= 0)
/*     */         {
/* 404 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 407 */       return true;
/*     */     } 
/* 409 */     if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.DEADBUSH) && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D) {
/*     */       
/* 411 */       if (!this.world.isRemote) {
/*     */         
/* 413 */         setTamed(false);
/* 414 */         setOwnerId(null);
/* 415 */         par1EntityPlayer.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
/* 416 */         setHealth(mygetMaxHealth());
/*     */         
/* 418 */         playTameEffect(false);
/* 419 */         this.world.setEntityState((Entity)this, (byte)6);
/*     */       } else {
/*     */         
/* 422 */         par1EntityPlayer.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
/*     */       } 
/* 424 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 426 */         var2.setCount(var2.getCount() - 1);
/* 427 */         if (var2.getCount() <= 0)
/*     */         {
/* 429 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 432 */       return true;
/*     */     } 
/* 434 */     if (isTamed() && var2 != null && var2.getItem() == Items.NAME_TAG && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D) {
/*     */       
/* 436 */       setCustomNameTag(var2.getDisplayName());
/* 437 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 439 */         var2.setCount(var2.getCount() - 1);
/* 440 */         if (var2.getCount() <= 0)
/*     */         {
/* 442 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 445 */       return true;
/* 446 */     }  if (isTamed() && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D) {
/*     */       
/* 448 */       setSitting(!isSitting());
/*     */       
/* 450 */       if (this.world.isRemote)
/*     */       {
/*     */         
/* 453 */         par1EntityPlayer.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
/*     */       }
/* 455 */       return true;
/*     */     } 
/*     */     
/* 458 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 467 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*     */     
/* 469 */     if (var2.getCount() <= 0) {
/* 470 */       par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 471 */       var2 = null;
/*     */     } 
/*     */     
/* 474 */     if (super.processInteract(par1EntityPlayer, EnumHand.MAIN_HAND)) {
/* 475 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 481 */     if (var2 != null && var2.getItem() == Items.APPLE && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D) {
/*     */       
/* 483 */       if (!isTamed())
/*     */       {
/* 485 */         if (!this.world.isRemote)
/*     */         {
/* 487 */           if (this.rand.nextInt(2) == 0) {
/*     */             
/* 489 */             setTamedBy(par1EntityPlayer);
/*     */             
/* 491 */             playTameEffect(true);
/* 492 */             this.world.setEntityState((Entity)this, (byte)7);
/* 493 */             heal(mygetMaxHealth() - getHealth());
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 498 */             playTameEffect(false);
/* 499 */             this.world.setEntityState((Entity)this, (byte)6);
/*     */           } 
/*     */         }
/*     */       }
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
/* 519 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 521 */         var2.setCount(var2.getCount() - 1);
/* 522 */         if (var2.getCount() <= 0)
/*     */         {
/* 524 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 527 */       return true;
/*     */     } 
/* 529 */     if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.DEADBUSH) && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D) {
/*     */       
/* 531 */       if (!this.world.isRemote) {
/*     */         
/* 533 */         setTamed(false);
/* 534 */         setOwnerId(null);
/* 535 */         setHealth(mygetMaxHealth());
/*     */         
/* 537 */         playTameEffect(false);
/* 538 */         this.world.setEntityState((Entity)this, (byte)6);
/*     */       } else {
/*     */         
/* 541 */         par1EntityPlayer.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
/*     */       } 
/* 543 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 545 */         var2.setCount(var2.getCount() - 1);
/* 546 */         if (var2.getCount() <= 0)
/*     */         {
/* 548 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 551 */       return true;
/*     */     } 
/* 553 */     if (isTamed() && var2 != null && var2.getItem() == Items.NAME_TAG && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D) {
/*     */       
/* 555 */       setCustomNameTag(var2.getDisplayName());
/* 556 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 558 */         var2.setCount(var2.getCount() - 1);
/* 559 */         if (var2.getCount() <= 0)
/*     */         {
/* 561 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 564 */       return true;
/* 565 */     }  if (isTamed() && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D) {
/*     */       
/* 567 */       setSitting(!isSitting());
/*     */       
/* 569 */       if (this.world.isRemote)
/*     */       {
/*     */         
/* 572 */         par1EntityPlayer.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
/*     */       }
/* 574 */       return true;
/*     */     } 
/*     */     
/* 577 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/* 584 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/* 590 */     return SoundsHandler.ENTITY_CRYO_HURT;
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
/*     */   protected float getSoundVolume() {
/* 608 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 617 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 626 */     int var3 = 0;
/*     */     
/* 628 */     if (isTamed()) {
/*     */       
/* 630 */       var3 = this.rand.nextInt(5);
/* 631 */       var3 += 2;
/* 632 */       for (int var4 = 0; var4 < var3; var4++) {
/* 633 */         dropItem(Item.getItemFromBlock((Block)Blocks.RED_FLOWER), 1);
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
/*     */   protected float getSoundPitch() {
/* 646 */     return isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.5F) : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 655 */     boolean ret = false;
/* 656 */     float p2 = par2;
/* 657 */     if (p2 > 10.0F) p2 = 10.0F; 
/* 658 */     ret = super.attackEntityFrom(par1DamageSource, p2);
/* 659 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 669 */     if (isChild())
/*     */     {
/* 671 */       return false;
/*     */     }
/* 673 */     if (isTamed()) return false; 
/* 674 */     if (isNoDespawnRequired()) return false; 
/* 675 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 680 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VelocityRaptor spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 686 */     return new VelocityRaptor(this.world);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 694 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.APPLE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 703 */     return (par1ItemStack.getItem() == Items.APPLE);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\entity\VelocityRaptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */