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
/*     */   private int closest; private int tx; private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*     */     getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
/*  55 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D); } public Camarasaurus(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 125 */     this.closest = 99999;
/* 126 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.5F, 1.2F); this.moveSpeed = 0.2F; this.experienceValue = 5; this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new MyEntityAIFollowOwner(this, 2.0F, 10.0F, 2.0F)); this.tasks.addTask(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.399999976158142D)); this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, Items.APPLE, false)); this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F)); this.tasks.addTask(7, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 1.0F)); this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     this.tasks.addTask(9, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this)); }
/*     */   protected void entityInit() { super.entityInit();
/* 129 */     setSitting(false); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 134 */     for (i = -dy; i <= dy; i++) {
/* 135 */       for (int j = -dz; j <= dz; j++) {
/* 136 */         Block bid = this.world.getBlockState(new BlockPos(x + dx, y + i, z + j)).getBlock();
/*     */         
/* 138 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 139 */           int d = dx * dx + j * j + i * i;
/* 140 */           if (d < this.closest) {
/* 141 */             this.closest = d;
/* 142 */             this.tx = x + dx;
/* 143 */             this.ty = y + i;
/* 144 */             this.tz = z + j;
/* 145 */             found++;
/*     */           } 
/*     */         } 
/* 148 */         bid = this.world.getBlockState(new BlockPos(x - dx, y + i, z + j)).getBlock();
/* 149 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 150 */           int d = dx * dx + j * j + i * i;
/* 151 */           if (d < this.closest) {
/* 152 */             this.closest = d;
/* 153 */             this.tx = x - dx;
/* 154 */             this.ty = y + i;
/* 155 */             this.tz = z + j;
/* 156 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 162 */     for (i = -dx; i <= dx; i++) {
/* 163 */       for (int j = -dz; j <= dz; j++) {
/* 164 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + dy, z + j)).getBlock();
/* 165 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 166 */           int d = dy * dy + j * j + i * i;
/* 167 */           if (d < this.closest) {
/* 168 */             this.closest = d;
/* 169 */             this.tx = x + i;
/* 170 */             this.ty = y + dy;
/* 171 */             this.tz = z + j;
/* 172 */             found++;
/*     */           } 
/*     */         } 
/* 175 */         bid = this.world.getBlockState(new BlockPos(x + i, y - dy, z + j)).getBlock();
/* 176 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 177 */           int d = dy * dy + j * j + i * i;
/* 178 */           if (d < this.closest) {
/* 179 */             this.closest = d;
/* 180 */             this.tx = x + i;
/* 181 */             this.ty = y - dy;
/* 182 */             this.tz = z + j;
/* 183 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 189 */     for (i = -dx; i <= dx; i++) {
/* 190 */       for (int j = -dy; j <= dy; j++) {
/* 191 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + j, z + dz)).getBlock();
/* 192 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 193 */           int d = dz * dz + j * j + i * i;
/* 194 */           if (d < this.closest) {
/* 195 */             this.closest = d;
/* 196 */             this.tx = x + i;
/* 197 */             this.ty = y + j;
/* 198 */             this.tz = z + dz;
/* 199 */             found++;
/*     */           } 
/*     */         } 
/* 202 */         bid = this.world.getBlockState(new BlockPos(x + i, y + j, z - dz)).getBlock();
/* 203 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 204 */           int d = dz * dz + j * j + i * i;
/* 205 */           if (d < this.closest) {
/* 206 */             this.closest = d;
/* 207 */             this.tx = x + i;
/* 208 */             this.ty = y + j;
/* 209 */             this.tz = z - dz;
/* 210 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 216 */     if (found != 0) return true; 
/* 217 */     return false; } public boolean getCanSpawnHere() { if (this.posY < 50.0D)
/*     */       return false;  return this.world.isDaytime(); }
/*     */   public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed); updateAITick(); super.onUpdate(); }
/*     */   protected void fall(float par1) { float i = MathHelper.ceil(par1 - 3.0F); if (i > 0.0F) { if (i > 3.0F) { playSound(SoundEvents.ENTITY_GENERIC_BIG_FALL, 1.0F, 1.0F); }
/*     */       else
/*     */       { playSound(SoundEvents.ENTITY_GENERIC_SMALL_FALL, 1.0F, 1.0F); }
/*     */        if (i > 2.0F)
/*     */         i = 2.0F;  attackEntityFrom(DamageSource.FALL, i); }
/*     */      }
/* 226 */   protected void updateAITick() { if (this.isDead)
/* 227 */       return;  if (this.world.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 228 */     updateAITasks();
/* 229 */     if (!isSitting() && ((
/* 230 */       this.world.rand.nextInt(20) == 0 && getCamarasaurusHealth() < mygetMaxHealth()) || this.world.rand.nextInt(250) == 0))
/*     */     {
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
/* 249 */             if (this.world.getGameRules().getBoolean("mobGriefing"))
/* 250 */               this.world.setBlockState(new BlockPos(this.tx, this.ty, this.tz), Blocks.AIR.getDefaultState()); 
/* 251 */             heal(1.0F);
/* 252 */             playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0F, this.world.rand.nextFloat() * 0.2F + 0.9F);
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
/*     */   public boolean isAIEnabled() {
/* 265 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 270 */     return false;
/*     */   }
/*     */   
/*     */   public int mygetMaxHealth() {
/* 274 */     return 20;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCamarasaurusHealth() {
/* 281 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean processInteract(EntityPlayer par1EntityPlayer, EnumHand hand) {
/* 288 */     ItemStack var2 = par1EntityPlayer.getHeldItem(hand);
/*     */ 
/*     */     
/* 291 */     if (var2 != null && 
/* 292 */       var2.getCount() <= 0)
/*     */     {
/* 294 */       var2 = null;
/*     */     }
/*     */ 
/*     */     
/* 298 */     if (super.processInteract(par1EntityPlayer, hand)) {
/* 299 */       return true;
/*     */     }
/* 301 */     if (var2 != null && var2.getItem() == Items.APPLE && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D) {
/* 302 */       if (!isTamed()) {
/* 303 */         if (!this.world.isRemote) {
/* 304 */           if (this.rand.nextInt(2) == 0) {
/* 305 */             setTamed(true);
/* 306 */             setTamedBy(par1EntityPlayer);
/* 307 */             playTameEffect(true);
/* 308 */             this.world.setEntityState((Entity)this, (byte)7);
/* 309 */             heal(mygetMaxHealth() - getHealth());
/*     */           } else {
/*     */             
/* 312 */             playTameEffect(false);
/* 313 */             this.world.setEntityState((Entity)this, (byte)6);
/* 314 */             setSitting(true);
/*     */           }
/*     */         
/*     */         }
/*     */       }
/* 319 */       else if (isOwner((EntityLivingBase)par1EntityPlayer)) {
/* 320 */         if (this.world.isRemote)
/*     */         {
/* 322 */           this.world.setEntityState((Entity)this, (byte)7);
/*     */         }
/*     */         
/* 325 */         if (mygetMaxHealth() > getHealth()) {
/* 326 */           heal(mygetMaxHealth() - getHealth());
/* 327 */           playTameEffect(true);
/*     */         } 
/*     */       } 
/*     */       
/* 331 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 332 */         var2.shrink(1);
/* 333 */         if (var2.getCount() <= 0);
/*     */       } 
/*     */ 
/*     */       
/* 337 */       return true;
/*     */     } 
/* 339 */     if (isTamed() && var2 != null && var2.getItem() == Items.NAME_TAG && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D && 
/* 340 */       isOwner((EntityLivingBase)par1EntityPlayer)) {
/* 341 */       setCustomNameTag(var2.getDisplayName());
/* 342 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/* 343 */         var2.shrink(1);
/* 344 */         if (var2.getCount() <= 0);
/*     */       } 
/*     */ 
/*     */       
/* 348 */       return true;
/* 349 */     }  if (isTamed() && isOwner((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D) {
/* 350 */       if (!isSitting()) {
/* 351 */         setSitting(true);
/*     */       } else {
/* 353 */         setSitting(false);
/*     */       } 
/* 355 */       return true;
/*     */     } 
/*     */     
/* 358 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getAmbientSound() {
/* 366 */     if (isSitting()) {
/* 367 */       return null;
/*     */     }
/* 369 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getHurtSound(DamageSource source) {
/* 377 */     return SoundsHandler.ENTITY_CRYO_HURT;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 382 */     return SoundsHandler.ENTITY_CRYO_DEATH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 389 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 396 */     return Item.getItemFromBlock((Block)Blocks.RED_FLOWER);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 403 */     int var3 = 0;
/*     */     
/* 405 */     if (isTamed()) {
/*     */       
/* 407 */       var3 = this.rand.nextInt(5);
/* 408 */       var3 += 2;
/* 409 */       for (int var4 = 0; var4 < var3; var4++) {
/* 410 */         dropItem(Item.getItemFromBlock((Block)Blocks.RED_FLOWER), 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 421 */     return isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.5F) : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 429 */     boolean ret = false;
/* 430 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/* 431 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 439 */     if (isChild())
/*     */     {
/* 441 */       return false;
/*     */     }
/* 443 */     if (isNoDespawnRequired()) return false; 
/* 444 */     if (isTamed()) return false; 
/* 445 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 450 */     return (EntityAgeable)new Camarasaurus(this.world);
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
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 464 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.APPLE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 472 */     return (par1ItemStack.getItem() == Items.GOLDEN_APPLE);
/*     */   }
/*     */   
/*     */   public boolean canMateWith(EntityAnimal otherAnimal) {
/* 476 */     if (otherAnimal == this)
/* 477 */       return false; 
/* 478 */     if (!isTamed())
/* 479 */       return false; 
/* 480 */     if (!(otherAnimal instanceof Camarasaurus)) {
/* 481 */       return false;
/*     */     }
/* 483 */     Camarasaurus camarasaurus = (Camarasaurus)otherAnimal;
/*     */     
/* 485 */     if (!camarasaurus.isTamed())
/* 486 */       return false; 
/* 487 */     if (camarasaurus.isSitting())
/* 488 */       return false; 
/* 489 */     if (isSitting()) {
/* 490 */       return false;
/*     */     }
/* 492 */     return (isInLove() && camarasaurus.isInLove());
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\Camarasaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */