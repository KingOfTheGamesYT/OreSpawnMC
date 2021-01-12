/*     */ package danger.orespawn;
/*     */ 
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
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ public class Hydrolisc
/*     */   extends EntityTameable
/*     */ {
/*  45 */   private float moveSpeed = 0.25F;
/*     */   private int closest; private int tx; private int ty; private int tz; protected void entityInit() {
/*     */     super.entityInit();
/*     */     setSitting(false);
/*  49 */   } public Hydrolisc(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     this.closest = 99999;
/*  94 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.5F, 0.5F); this.fireResistance = 100; getNavigator().setAvoidsWater(false); setSitting(false); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.399999976158142D)); this.tasks.addTask(3, new MyEntityAIFollowOwner(this, 1.2F, 10.0F, 2.0F)); this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.fish, false)); this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F)); this.tasks.addTask(7, new MyEntityAIWander((EntityCreature)this, 1.0F));
/*     */     this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     this.tasks.addTask(9, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
/*  97 */     this.experienceValue = 5; } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 102 */     for (i = -dy; i <= dy; i++) {
/* 103 */       for (int j = -dz; j <= dz; j++) {
/* 104 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 105 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 106 */           int d = dx * dx + j * j + i * i;
/* 107 */           if (d < this.closest) {
/* 108 */             this.closest = d;
/* 109 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 110 */             found++;
/*     */           } 
/*     */         } 
/* 113 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 114 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 115 */           int d = dx * dx + j * j + i * i;
/* 116 */           if (d < this.closest) {
/* 117 */             this.closest = d;
/* 118 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 119 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 125 */     for (i = -dx; i <= dx; i++) {
/* 126 */       for (int j = -dz; j <= dz; j++) {
/* 127 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 128 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 129 */           int d = dy * dy + j * j + i * i;
/* 130 */           if (d < this.closest) {
/* 131 */             this.closest = d;
/* 132 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 133 */             found++;
/*     */           } 
/*     */         } 
/* 136 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 137 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 138 */           int d = dy * dy + j * j + i * i;
/* 139 */           if (d < this.closest) {
/* 140 */             this.closest = d;
/* 141 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 142 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 148 */     for (i = -dx; i <= dx; i++) {
/* 149 */       for (int j = -dy; j <= dy; j++) {
/* 150 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 151 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 152 */           int d = dz * dz + j * j + i * i;
/* 153 */           if (d < this.closest) {
/* 154 */             this.closest = d;
/* 155 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 156 */             found++;
/*     */           } 
/*     */         } 
/* 159 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 160 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 161 */           int d = dz * dz + j * j + i * i;
/* 162 */           if (d < this.closest) {
/* 163 */             this.closest = d;
/* 164 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 165 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 171 */     if (found != 0) return true; 
/* 172 */     return false; } protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*     */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*     */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*     */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D); }
/*     */   public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*     */     super.onUpdate(); }
/* 178 */   protected void fall(float par1) { float i = MathHelper.ceiling_float_int(par1 - 3.0F);
/*     */     
/* 180 */     if (i > 0.0F) {
/*     */       
/* 182 */       if (i > 3.0F) {
/*     */         
/* 184 */         playSound("damage.fallbig", 1.0F, 1.0F);
/*     */       }
/*     */       else {
/*     */         
/* 188 */         playSound("damage.fallsmall", 1.0F, 1.0F);
/*     */       } 
/* 190 */       if (i > 2.0F)
/*     */       {
/* 192 */         i = 2.0F;
/*     */       }
/* 194 */       attackEntityFrom(DamageSource.fall, i);
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 204 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITick() {
/* 213 */     super.updateAITick();
/* 214 */     if (this.isDead)
/* 215 */       return;  if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 216 */     if (!isSitting())
/*     */     {
/* 218 */       if ((this.worldObj.rand.nextInt(20) == 0 && getHydroHealth() < getMaxHealth()) || this.worldObj.rand.nextInt(100) == 0) {
/*     */ 
/*     */ 
/*     */         
/* 222 */         this.closest = 99999;
/* 223 */         this.tx = this.ty = this.tz = 0;
/* 224 */         for (int i = 1; i < 11; i++) {
/* 225 */           int j = i;
/* 226 */           if (j > 4) j = 4; 
/* 227 */           if (scan_it((int)this.posX, (int)this.posY - 1, (int)this.posZ, i, j, i) == true)
/* 228 */             break;  if (i >= 5) i++;
/*     */         
/*     */         } 
/* 231 */         if (this.closest < 99999) {
/* 232 */           getNavigator().tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.0D);
/* 233 */           if (isInWater()) {
/* 234 */             heal(1.0F);
/* 235 */             playSound("splash", 1.0F, this.worldObj.rand.nextFloat() * 0.2F + 0.9F);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 242 */     if (this.worldObj.rand.nextInt(10) == 0 && 
/* 243 */       isTamed()) {
/* 244 */       EntityLivingBase e = getOwner();
/* 245 */       if (e != null && 
/* 246 */         e.getHealth() < e.getMaxHealth() && 
/* 247 */         getHydroHealth() > 20) {
/*     */         
/* 249 */         e.heal(1.0F);
/* 250 */         heal(-1.0F);
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
/*     */   public boolean isAIEnabled() {
/* 265 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 271 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 276 */     return 100;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 286 */     super.onLivingUpdate();
/*     */     
/* 288 */     if (isInWater()) {
/* 289 */       this.motionY += 0.04D;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHydroHealth() {
/* 298 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 306 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*     */ 
/*     */     
/* 309 */     if (var2 != null)
/*     */     {
/* 311 */       if (var2.stackSize <= 0) {
/*     */         
/* 313 */         par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 314 */         var2 = null;
/*     */       } 
/*     */     }
/*     */     
/* 318 */     if (super.interact(par1EntityPlayer)) {
/* 319 */       return true;
/*     */     }
/*     */     
/* 322 */     if (var2 != null && var2.getItem() == Items.fish && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*     */       
/* 324 */       if (!isTamed()) {
/*     */         
/* 326 */         if (!this.worldObj.isRemote)
/*     */         {
/* 328 */           if (this.rand.nextInt(2) == 0)
/*     */           {
/* 330 */             setTamed(true);
/* 331 */             func_152115_b(par1EntityPlayer.getUniqueID().toString());
/* 332 */             playTameEffect(true);
/* 333 */             this.worldObj.setEntityState((Entity)this, (byte)7);
/* 334 */             heal(getMaxHealth() - getHealth());
/*     */           
/*     */           }
/*     */           else
/*     */           {
/* 339 */             playTameEffect(false);
/* 340 */             this.worldObj.setEntityState((Entity)this, (byte)6);
/*     */           }
/*     */         
/*     */         }
/*     */       }
/* 345 */       else if (isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */         
/* 347 */         if (this.worldObj.isRemote) {
/* 348 */           playTameEffect(true);
/* 349 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*     */         } 
/*     */         
/* 352 */         if (getMaxHealth() > getHealth()) {
/* 353 */           heal(getMaxHealth() - getHealth());
/*     */         }
/*     */       } 
/*     */       
/* 357 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 359 */         var2.stackSize--;
/* 360 */         if (var2.stackSize <= 0)
/*     */         {
/* 362 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 365 */       return true;
/* 366 */     }  if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */ 
/*     */       
/* 369 */       if (!this.worldObj.isRemote) {
/*     */         
/* 371 */         setTamed(false);
/* 372 */         func_152115_b("");
/* 373 */         playTameEffect(false);
/* 374 */         this.worldObj.setEntityState((Entity)this, (byte)6);
/*     */       } 
/* 376 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 378 */         var2.stackSize--;
/* 379 */         if (var2.stackSize <= 0)
/*     */         {
/* 381 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 384 */       return true;
/*     */     } 
/* 386 */     if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */       
/* 388 */       setCustomNameTag(var2.getDisplayName());
/* 389 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 391 */         var2.stackSize--;
/* 392 */         if (var2.stackSize <= 0)
/*     */         {
/* 394 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 397 */       return true;
/* 398 */     }  if (isTamed() && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */       
/* 400 */       if (!isSitting()) {
/* 401 */         setSitting(true);
/*     */       } else {
/* 403 */         setSitting(false);
/*     */       } 
/* 405 */       return true;
/*     */     } 
/*     */     
/* 408 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 416 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.fish);
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
/*     */   protected String getLivingSound() {
/* 429 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 437 */     return "orespawn:cryo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 445 */     return "orespawn:cryo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 453 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 461 */     return Items.fish;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 469 */     int var3 = 0;
/*     */     
/* 471 */     if (isTamed()) {
/*     */       
/* 473 */       var3 = this.rand.nextInt(5);
/* 474 */       var3 += 2;
/* 475 */       for (int var4 = 0; var4 < var3; var4++)
/*     */       {
/* 477 */         dropItem(Items.fish, 1);
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
/* 488 */     return isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.5F) : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 497 */     boolean ret = false;
/* 498 */     float p2 = par2;
/* 499 */     if (p2 > 10.0F) p2 = 10.0F; 
/* 500 */     ret = super.attackEntityFrom(par1DamageSource, p2);
/* 501 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 510 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 515 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Hydrolisc spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 521 */     return new Hydrolisc(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 531 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Hydrolisc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */