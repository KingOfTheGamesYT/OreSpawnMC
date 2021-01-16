/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.util.ai.MyEntityAIFollowOwner;
/*     */ import danger.orespawn.util.ai.MyEntityAIWander;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAIMoveIndoors;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITempt;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
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
/*     */ public class Camarasaurus
/*     */   extends EntityTameable
/*     */ {
/*  52 */   private float moveSpeed = 0.2F;
/*     */   private int closest; private int tx; private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*     */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*     */     getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
/*  56 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D); } public Camarasaurus(World par1World) { super(par1World);
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
/* 136 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.5F, 1.2F); this.moveSpeed = 0.2F; this.experienceValue = 5; this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new MyEntityAIFollowOwner(this, 2.0F, 10.0F, 2.0F)); this.tasks.addTask(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.399999976158142D)); this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, Items.APPLE, false)); this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F)); this.tasks.addTask(7, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 1.0F)); this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
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
/* 148 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 149 */           int d = dx * dx + j * j + i * i;
/* 150 */           if (d < this.closest) {
/* 151 */             this.closest = d;
/* 152 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 153 */             found++;
/*     */           } 
/*     */         } 
/* 156 */         bid = this.world.getBlockState(new BlockPos(x - dx, y + i, z + j)).getBlock();
/* 157 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 158 */           int d = dx * dx + j * j + i * i;
/* 159 */           if (d < this.closest) {
/* 160 */             this.closest = d;
/* 161 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 162 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 168 */     for (i = -dx; i <= dx; i++) {
/* 169 */       for (int j = -dz; j <= dz; j++) {
/* 170 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + dy, z + j)).getBlock();
/* 171 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 172 */           int d = dy * dy + j * j + i * i;
/* 173 */           if (d < this.closest) {
/* 174 */             this.closest = d;
/* 175 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 176 */             found++;
/*     */           } 
/*     */         } 
/* 179 */         bid = this.world.getBlockState(new BlockPos(x + i, y - dy, z + j)).getBlock();
/* 180 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 181 */           int d = dy * dy + j * j + i * i;
/* 182 */           if (d < this.closest) {
/* 183 */             this.closest = d;
/* 184 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 185 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 191 */     for (i = -dx; i <= dx; i++) {
/* 192 */       for (int j = -dy; j <= dy; j++) {
/* 193 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + j, z + dz)).getBlock();
/* 194 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 195 */           int d = dz * dz + j * j + i * i;
/* 196 */           if (d < this.closest) {
/* 197 */             this.closest = d;
/* 198 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 199 */             found++;
/*     */           } 
/*     */         } 
/* 202 */         bid = this.world.getBlockState(new BlockPos(x + i, y + j, z - dz)).getBlock();
/* 203 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 204 */           int d = dz * dz + j * j + i * i;
/* 205 */           if (d < this.closest) {
/* 206 */             this.closest = d;
/* 207 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 208 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 214 */     if (found != 0) return true; 
/* 215 */     return false; } public boolean getCanSpawnHere() { if (this.posY < 50.0D)
/*     */       return false;  return this.world.isDaytime(); }
/*     */   public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed); updateAITick(); super.onUpdate(); }
/*     */   protected void fall(float par1) { float i = MathHelper.ceil(par1 - 3.0F); if (i > 0.0F) { if (i > 3.0F) {
/*     */         playSound(SoundEvents.ENTITY_GENERIC_BIG_FALL, 1.0F, 1.0F);
/*     */       } else {
/*     */         playSound(SoundEvents.ENTITY_GENERIC_SMALL_FALL, 1.0F, 1.0F);
/*     */       }  if (i > 2.0F)
/*     */         i = 2.0F;  attackEntityFrom(DamageSource.FALL, i); }
/*     */      }
/* 225 */   protected void updateAITick() { if (this.isDead)
/* 226 */       return;  if (this.world.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 227 */     updateAITasks();
/* 228 */     if (!isSitting() && ((
/* 229 */       this.world.rand.nextInt(20) == 0 && getCamarasaurusHealth() < mygetMaxHealth()) || this.world.rand.nextInt(250) == 0))
/*     */     {
/*     */       
/* 232 */       if (OreSpawnMain.PlayNicely == 0) {
/*     */ 
/*     */         
/* 235 */         this.closest = 99999;
/* 236 */         this.tx = this.ty = this.tz = 0;
/* 237 */         for (int i = 1; i < 11; i++) {
/* 238 */           int j = i;
/* 239 */           if (j > 2) j = 2; 
/* 240 */           if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i) == true)
/* 241 */             break;  if (i >= 6) i++;
/*     */         
/*     */         } 
/* 244 */         if (this.closest < 99999) {
/*     */           
/* 246 */           getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 247 */           if (this.closest < 12) {
/*     */             
/* 249 */             if (this.world.getGameRules().getBoolean("mobGriefing")) this.world.setBlockState(new BlockPos(this.tx, this.ty, this.tz), Blocks.AIR.getDefaultState()); 
/* 250 */             heal(1.0F);
/* 251 */             playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0F, this.world.rand.nextFloat() * 0.2F + 0.9F);
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
/*     */   public boolean isAIEnabled() {
/* 265 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 271 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 276 */     return 20;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCamarasaurusHealth() {
/* 283 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean processInteract(EntityPlayer par1EntityPlayer, EnumHand hand) {
/* 291 */     ItemStack var2 = par1EntityPlayer.getHeldItem(hand);
/*     */ 
/*     */     
/* 294 */     if (var2 != null)
/*     */     {
/* 296 */       if (var2.getCount() <= 0)
/*     */       {
/*     */         
/* 299 */         var2 = null;
/*     */       }
/*     */     }
/*     */     
/* 303 */     if (super.processInteract(par1EntityPlayer, hand)) {
/* 304 */       return true;
/*     */     }
/* 306 */     if (var2 != null && var2.getItem() == Items.APPLE && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D) {
/*     */       
/* 308 */       if (!isTamed()) {
/*     */         
/* 310 */         if (!this.world.isRemote)
/*     */         {
/* 312 */           if (this.rand.nextInt(2) == 0)
/*     */           {
/* 314 */             setTamed(true);
/* 315 */             setTamedBy(par1EntityPlayer);
/* 316 */             playTameEffect(true);
/* 317 */             this.world.setEntityState((Entity)this, (byte)7);
/* 318 */             heal(mygetMaxHealth() - getHealth());
/*     */           
/*     */           }
/*     */           else
/*     */           {
/* 323 */             playTameEffect(false);
/* 324 */             this.world.setEntityState((Entity)this, (byte)6);
/* 325 */             setSitting(true);
/*     */           }
/*     */         
/*     */         }
/*     */       }
/* 330 */       else if (isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */         
/* 332 */         if (this.world.isRemote)
/*     */         {
/* 334 */           this.world.setEntityState((Entity)this, (byte)7);
/*     */         }
/*     */         
/* 337 */         if (mygetMaxHealth() > getHealth()) {
/* 338 */           heal(mygetMaxHealth() - getHealth());
/* 339 */           playTameEffect(true);
/*     */         } 
/*     */       } 
/*     */       
/* 343 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 345 */         var2.shrink(1);
/* 346 */         if (var2.getCount() <= 0);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 351 */       return true;
/*     */     } 
/* 353 */     if (isTamed() && var2 != null && var2.getItem() == Items.NAME_TAG && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D && 
/* 354 */       isOwner((EntityLivingBase)par1EntityPlayer)) {
/* 355 */       setCustomNameTag(var2.getDisplayName());
/* 356 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 358 */         var2.shrink(1);
/* 359 */         if (var2.getCount() <= 0);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 364 */       return true;
/* 365 */     }  if (isTamed() && isOwner((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D) {
/*     */       
/* 367 */       if (!isSitting()) {
/* 368 */         setSitting(true);
/*     */       } else {
/* 370 */         setSitting(false);
/*     */       } 
/* 372 */       return true;
/*     */     } 
/*     */     
/* 375 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getAmbientSound() {
/* 384 */     if (isSitting())
/*     */     {
/* 386 */       return null;
/*     */     }
/* 388 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getHurtSound(DamageSource source) {
/* 397 */     return SoundsHandler.ENTITY_CRYO_HURT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 403 */     return SoundsHandler.ENTITY_CRYO_DEATH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 411 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 419 */     return Item.getItemFromBlock((Block)Blocks.RED_FLOWER);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 427 */     int var3 = 0;
/*     */     
/* 429 */     if (isTamed()) {
/*     */       
/* 431 */       var3 = this.rand.nextInt(5);
/* 432 */       var3 += 2;
/* 433 */       for (int var4 = 0; var4 < var3; var4++)
/*     */       {
/* 435 */         dropItem(Item.getItemFromBlock((Block)Blocks.RED_FLOWER), 1);
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
/*     */   protected float getSoundPitch() {
/* 447 */     return isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.5F) : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 457 */     boolean ret = false;
/* 458 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/* 459 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 468 */     if (isChild())
/*     */     {
/* 470 */       return false;
/*     */     }
/* 472 */     if (isNoDespawnRequired()) return false; 
/* 473 */     if (isTamed()) return false; 
/* 474 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 479 */     return (EntityAgeable)new Camarasaurus(this.world);
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
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 494 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.APPLE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 503 */     return (par1ItemStack.getItem() == Items.GOLDEN_APPLE);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canMateWith(EntityAnimal otherAnimal) {
/* 508 */     if (otherAnimal == this)
/*     */     {
/* 510 */       return false;
/*     */     }
/* 512 */     if (!isTamed())
/*     */     {
/* 514 */       return false;
/*     */     }
/* 516 */     if (!(otherAnimal instanceof Camarasaurus))
/*     */     {
/* 518 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 522 */     Camarasaurus camarasaurus = (Camarasaurus)otherAnimal;
/*     */     
/* 524 */     if (!camarasaurus.isTamed())
/*     */     {
/* 526 */       return false;
/*     */     }
/* 528 */     if (camarasaurus.isSitting())
/*     */     {
/* 530 */       return false;
/*     */     }
/* 532 */     if (isSitting())
/*     */     {
/* 534 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 538 */     return (isInLove() && camarasaurus.isInLove());
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\entity\Camarasaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */