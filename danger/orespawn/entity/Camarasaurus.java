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
/*     */     
/* 136 */     this.closest = 99999;
/* 137 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.5F, 1.2F); this.moveSpeed = 0.2F; this.experienceValue = 5; this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new MyEntityAIFollowOwner(this, 2.0F, 10.0F, 2.0F)); this.tasks.addTask(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.399999976158142D)); this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, Items.APPLE, false)); this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F)); this.tasks.addTask(7, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 1.0F)); this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     this.tasks.addTask(9, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this)); }
/*     */   protected void entityInit() { super.entityInit();
/* 140 */     setSitting(false); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 145 */     for (i = -dy; i <= dy; i++) {
/* 146 */       for (int j = -dz; j <= dz; j++) {
/* 147 */         Block bid = this.world.getBlockState(new BlockPos(x + dx, y + i, z + j)).getBlock();
/*     */         
/* 149 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 150 */           int d = dx * dx + j * j + i * i;
/* 151 */           if (d < this.closest) {
/* 152 */             this.closest = d;
/* 153 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 154 */             found++;
/*     */           } 
/*     */         } 
/* 157 */         bid = this.world.getBlockState(new BlockPos(x - dx, y + i, z + j)).getBlock();
/* 158 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
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
/* 172 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 173 */           int d = dy * dy + j * j + i * i;
/* 174 */           if (d < this.closest) {
/* 175 */             this.closest = d;
/* 176 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 177 */             found++;
/*     */           } 
/*     */         } 
/* 180 */         bid = this.world.getBlockState(new BlockPos(x + i, y - dy, z + j)).getBlock();
/* 181 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 182 */           int d = dy * dy + j * j + i * i;
/* 183 */           if (d < this.closest) {
/* 184 */             this.closest = d;
/* 185 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 186 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 192 */     for (i = -dx; i <= dx; i++) {
/* 193 */       for (int j = -dy; j <= dy; j++) {
/* 194 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + j, z + dz)).getBlock();
/* 195 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 196 */           int d = dz * dz + j * j + i * i;
/* 197 */           if (d < this.closest) {
/* 198 */             this.closest = d;
/* 199 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 200 */             found++;
/*     */           } 
/*     */         } 
/* 203 */         bid = this.world.getBlockState(new BlockPos(x + i, y + j, z - dz)).getBlock();
/* 204 */         if (bid == Blocks.LEAVES || bid == Blocks.VINE || bid == Blocks.TALLGRASS || bid == Blocks.CACTUS || bid == Blocks.DOUBLE_PLANT) {
/* 205 */           int d = dz * dz + j * j + i * i;
/* 206 */           if (d < this.closest) {
/* 207 */             this.closest = d;
/* 208 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 209 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 215 */     if (found != 0) return true; 
/* 216 */     return false; } public boolean getCanSpawnHere() { if (this.posY < 50.0D)
/*     */       return false;  if (!this.world.isDaytime())
/*     */       return false;  return true; }
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
/*     */       
/* 233 */       if (OreSpawnMain.PlayNicely == 0) {
/*     */ 
/*     */         
/* 236 */         this.closest = 99999;
/* 237 */         this.tx = this.ty = this.tz = 0;
/* 238 */         for (int i = 1; i < 11; i++) {
/* 239 */           int j = i;
/* 240 */           if (j > 2) j = 2; 
/* 241 */           if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i) == true)
/* 242 */             break;  if (i >= 6) i++;
/*     */         
/*     */         } 
/* 245 */         if (this.closest < 99999) {
/*     */           
/* 247 */           getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 248 */           if (this.closest < 12) {
/*     */             
/* 250 */             if (this.world.getGameRules().getBoolean("mobGriefing")) this.world.setBlockState(new BlockPos(this.tx, this.ty, this.tz), Blocks.AIR.getDefaultState()); 
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
/*     */   
/*     */   public boolean isAIEnabled() {
/* 266 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 272 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 277 */     return 20;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCamarasaurusHealth() {
/* 284 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean processInteract(EntityPlayer par1EntityPlayer, EnumHand hand) {
/* 292 */     ItemStack var2 = par1EntityPlayer.getHeldItem(hand);
/*     */ 
/*     */     
/* 295 */     if (var2 != null)
/*     */     {
/* 297 */       if (var2.getCount() <= 0)
/*     */       {
/*     */         
/* 300 */         var2 = null;
/*     */       }
/*     */     }
/*     */     
/* 304 */     if (super.processInteract(par1EntityPlayer, hand)) {
/* 305 */       return true;
/*     */     }
/* 307 */     if (var2 != null && var2.getItem() == Items.APPLE && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D) {
/*     */       
/* 309 */       if (!isTamed()) {
/*     */         
/* 311 */         if (!this.world.isRemote)
/*     */         {
/* 313 */           if (this.rand.nextInt(2) == 0)
/*     */           {
/* 315 */             setTamed(true);
/* 316 */             setTamedBy(par1EntityPlayer);
/* 317 */             playTameEffect(true);
/* 318 */             this.world.setEntityState((Entity)this, (byte)7);
/* 319 */             heal(mygetMaxHealth() - getHealth());
/*     */           
/*     */           }
/*     */           else
/*     */           {
/* 324 */             playTameEffect(false);
/* 325 */             this.world.setEntityState((Entity)this, (byte)6);
/* 326 */             setSitting(true);
/*     */           }
/*     */         
/*     */         }
/*     */       }
/* 331 */       else if (isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */         
/* 333 */         if (this.world.isRemote)
/*     */         {
/* 335 */           this.world.setEntityState((Entity)this, (byte)7);
/*     */         }
/*     */         
/* 338 */         if (mygetMaxHealth() > getHealth()) {
/* 339 */           heal(mygetMaxHealth() - getHealth());
/* 340 */           playTameEffect(true);
/*     */         } 
/*     */       } 
/*     */       
/* 344 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 346 */         var2.shrink(1);
/* 347 */         if (var2.getCount() <= 0);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 352 */       return true;
/*     */     } 
/* 354 */     if (isTamed() && var2 != null && var2.getItem() == Items.NAME_TAG && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D && 
/* 355 */       isOwner((EntityLivingBase)par1EntityPlayer)) {
/* 356 */       setCustomNameTag(var2.getDisplayName());
/* 357 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 359 */         var2.shrink(1);
/* 360 */         if (var2.getCount() <= 0);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 365 */       return true;
/* 366 */     }  if (isTamed() && isOwner((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSq((Entity)this) < 16.0D) {
/*     */       
/* 368 */       if (!isSitting()) {
/* 369 */         setSitting(true);
/*     */       } else {
/* 371 */         setSitting(false);
/*     */       } 
/* 373 */       return true;
/*     */     } 
/*     */     
/* 376 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getAmbientSound() {
/* 385 */     if (isSitting())
/*     */     {
/* 387 */       return null;
/*     */     }
/* 389 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getHurtSound(DamageSource source) {
/* 398 */     return SoundsHandler.ENTITY_CRYO_HURT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundEvent getDeathSound() {
/* 404 */     return SoundsHandler.ENTITY_CRYO_DEATH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 412 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 420 */     return Item.getItemFromBlock((Block)Blocks.RED_FLOWER);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 428 */     int var3 = 0;
/*     */     
/* 430 */     if (isTamed()) {
/*     */       
/* 432 */       var3 = this.rand.nextInt(5);
/* 433 */       var3 += 2;
/* 434 */       for (int var4 = 0; var4 < var3; var4++)
/*     */       {
/* 436 */         dropItem(Item.getItemFromBlock((Block)Blocks.RED_FLOWER), 1);
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
/* 448 */     return isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.5F) : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 458 */     boolean ret = false;
/* 459 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/* 460 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 469 */     if (isChild())
/*     */     {
/* 471 */       return false;
/*     */     }
/* 473 */     if (isNoDespawnRequired()) return false; 
/* 474 */     if (isTamed()) return false; 
/* 475 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 480 */     return (EntityAgeable)new Camarasaurus(this.world);
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
/* 495 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.APPLE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 504 */     return (par1ItemStack.getItem() == Items.GOLDEN_APPLE);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canMateWith(EntityAnimal otherAnimal) {
/* 509 */     if (otherAnimal == this)
/*     */     {
/* 511 */       return false;
/*     */     }
/* 513 */     if (!isTamed())
/*     */     {
/* 515 */       return false;
/*     */     }
/* 517 */     if (!(otherAnimal instanceof Camarasaurus))
/*     */     {
/* 519 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 523 */     Camarasaurus camarasaurus = (Camarasaurus)otherAnimal;
/*     */     
/* 525 */     if (!camarasaurus.isTamed())
/*     */     {
/* 527 */       return false;
/*     */     }
/* 529 */     if (camarasaurus.isSitting())
/*     */     {
/* 531 */       return false;
/*     */     }
/* 533 */     if (isSitting())
/*     */     {
/* 535 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 539 */     return (isInLove() && camarasaurus.isInLove());
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\entity\Camarasaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */