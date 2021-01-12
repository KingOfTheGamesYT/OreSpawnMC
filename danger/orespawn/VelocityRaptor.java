/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
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
/*     */ public class VelocityRaptor
/*     */   extends EntityCannonFodder
/*     */ {
/*  43 */   private float moveSpeed = 0.55F;
/*     */   private int closest; private int tx; private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*     */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*     */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  47 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D); } public VelocityRaptor(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     this.closest = 99999;
/* 128 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.5F, 0.6F); this.fireResistance = 10; getNavigator().setAvoidsWater(true); setSitting(false); this.experienceValue = 5; this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D)); this.tasks.addTask(2, new MyEntityAIFollowOwner(this, 1.5F, 10.0F, 2.0F)); this.tasks.addTask(3, new MyEntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.399999976158142D)); this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.apple, false)); this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.600000023841858D)); this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F)); this.tasks.addTask(7, new MyEntityAIWander((EntityCreature)this, 0.9F)); this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     this.tasks.addTask(9, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this)); }
/*     */   protected void entityInit() { super.entityInit();
/* 131 */     setSitting(false); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 136 */     for (i = -dy; i <= dy; i++) {
/* 137 */       for (int j = -dz; j <= dz; j++) {
/* 138 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 139 */         if (bid == Blocks.tallgrass || bid == Blocks.yellow_flower || bid == Blocks.red_flower || bid == Blocks.deadbush || bid == Blocks.double_plant) {
/* 140 */           int d = dx * dx + j * j + i * i;
/* 141 */           if (d < this.closest) {
/* 142 */             this.closest = d;
/* 143 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 144 */             found++;
/*     */           } 
/*     */         } 
/* 147 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 148 */         if (bid == Blocks.tallgrass || bid == Blocks.yellow_flower || bid == Blocks.red_flower || bid == Blocks.deadbush || bid == Blocks.double_plant) {
/* 149 */           int d = dx * dx + j * j + i * i;
/* 150 */           if (d < this.closest) {
/* 151 */             this.closest = d;
/* 152 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 153 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 159 */     for (i = -dx; i <= dx; i++) {
/* 160 */       for (int j = -dz; j <= dz; j++) {
/* 161 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 162 */         if (bid == Blocks.tallgrass || bid == Blocks.yellow_flower || bid == Blocks.red_flower || bid == Blocks.deadbush || bid == Blocks.double_plant) {
/* 163 */           int d = dy * dy + j * j + i * i;
/* 164 */           if (d < this.closest) {
/* 165 */             this.closest = d;
/* 166 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 167 */             found++;
/*     */           } 
/*     */         } 
/* 170 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 171 */         if (bid == Blocks.tallgrass || bid == Blocks.yellow_flower || bid == Blocks.red_flower || bid == Blocks.deadbush || bid == Blocks.double_plant) {
/* 172 */           int d = dy * dy + j * j + i * i;
/* 173 */           if (d < this.closest) {
/* 174 */             this.closest = d;
/* 175 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 176 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     for (i = -dx; i <= dx; i++) {
/* 183 */       for (int j = -dy; j <= dy; j++) {
/* 184 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 185 */         if (bid == Blocks.tallgrass || bid == Blocks.yellow_flower || bid == Blocks.red_flower || bid == Blocks.deadbush || bid == Blocks.double_plant) {
/* 186 */           int d = dz * dz + j * j + i * i;
/* 187 */           if (d < this.closest) {
/* 188 */             this.closest = d;
/* 189 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 190 */             found++;
/*     */           } 
/*     */         } 
/* 193 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 194 */         if (bid == Blocks.tallgrass || bid == Blocks.yellow_flower || bid == Blocks.red_flower || bid == Blocks.deadbush || bid == Blocks.double_plant) {
/* 195 */           int d = dz * dz + j * j + i * i;
/* 196 */           if (d < this.closest) {
/* 197 */             this.closest = d;
/* 198 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 199 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 205 */     if (found != 0) return true; 
/* 206 */     return false; } public boolean getCanSpawnHere() { if (this.posY < 50.0D)
/*     */       return false;  if (!this.worldObj.isDaytime())
/*     */       return false;  return true; }
/*     */   public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onUpdate(); }
/*     */   protected void fall(float par1) { float i = MathHelper.ceiling_float_int(par1 - 3.0F); if (i > 0.0F) { if (i > 3.0F) { playSound("damage.fallbig", 1.0F, 1.0F); }
/*     */       else { playSound("damage.fallsmall", 1.0F, 1.0F); }
/*     */        if (i > 2.0F)
/*     */         i = 2.0F;  attackEntityFrom(DamageSource.fall, i); }
/*     */      }
/* 215 */   protected void updateAITick() { super.updateAITick();
/* 216 */     if (this.isDead)
/* 217 */       return;  if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 218 */     if (!isSitting() && ((
/* 219 */       this.worldObj.rand.nextInt(20) == 0 && getVHealth() < mygetMaxHealth()) || this.worldObj.rand.nextInt(250) == 0))
/*     */     {
/*     */ 
/*     */       
/* 223 */       if (OreSpawnMain.PlayNicely == 0) {
/* 224 */         this.closest = 99999;
/* 225 */         this.tx = this.ty = this.tz = 0;
/* 226 */         for (int i = 1; i < 10; i++) {
/* 227 */           int j = i;
/* 228 */           if (j > 2) j = 2; 
/* 229 */           if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i) == true)
/* 230 */             break;  if (i >= 5) i++;
/*     */         
/*     */         } 
/* 233 */         if (this.closest < 99999) {
/*     */           
/* 235 */           getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 236 */           if (this.closest < 12) {
/*     */             
/* 238 */             if (this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2); 
/* 239 */             heal(2.0F);
/* 240 */             playSound("random.burp", 0.5F, this.worldObj.rand.nextFloat() * 0.2F + 1.5F);
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
/*     */   public boolean isAIEnabled() {
/* 255 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 261 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 266 */     return isTamed() ? 20 : 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 275 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getVHealth() {
/* 282 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 290 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*     */     
/* 292 */     if (var2 != null)
/*     */     {
/* 294 */       if (var2.stackSize <= 0) {
/*     */         
/* 296 */         par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 297 */         var2 = null;
/*     */       } 
/*     */     }
/*     */     
/* 301 */     if (super.interact(par1EntityPlayer)) {
/* 302 */       return true;
/*     */     }
/*     */     
/* 305 */     if (var2 != null && var2.getItem() == Items.apple && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*     */       
/* 307 */       if (!isTamed()) {
/*     */         
/* 309 */         if (!this.worldObj.isRemote)
/*     */         {
/* 311 */           if (this.rand.nextInt(2) == 0)
/*     */           {
/* 313 */             setTamed(true);
/* 314 */             func_152115_b(par1EntityPlayer.getUniqueID().toString());
/* 315 */             playTameEffect(true);
/* 316 */             this.worldObj.setEntityState((Entity)this, (byte)7);
/* 317 */             heal(mygetMaxHealth() - getHealth());
/*     */           
/*     */           }
/*     */           else
/*     */           {
/* 322 */             playTameEffect(false);
/* 323 */             this.worldObj.setEntityState((Entity)this, (byte)6);
/*     */           }
/*     */         
/*     */         }
/*     */       }
/* 328 */       else if (isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */         
/* 330 */         if (this.worldObj.isRemote) {
/* 331 */           playTameEffect(true);
/* 332 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*     */           
/* 334 */           par1EntityPlayer.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6000000238418579D);
/*     */         } 
/*     */         
/* 337 */         if (mygetMaxHealth() > getHealth()) {
/* 338 */           heal(mygetMaxHealth() - getHealth());
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 343 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 345 */         var2.stackSize--;
/* 346 */         if (var2.stackSize <= 0)
/*     */         {
/* 348 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 351 */       return true;
/*     */     } 
/* 353 */     if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */ 
/*     */       
/* 356 */       if (!this.worldObj.isRemote) {
/*     */         
/* 358 */         setTamed(false);
/* 359 */         setHealth(mygetMaxHealth());
/* 360 */         func_152115_b("");
/* 361 */         playTameEffect(false);
/* 362 */         this.worldObj.setEntityState((Entity)this, (byte)6);
/*     */       } else {
/*     */         
/* 365 */         par1EntityPlayer.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
/*     */       } 
/* 367 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 369 */         var2.stackSize--;
/* 370 */         if (var2.stackSize <= 0)
/*     */         {
/* 372 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 375 */       return true;
/*     */     } 
/* 377 */     if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */       
/* 379 */       setCustomNameTag(var2.getDisplayName());
/* 380 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 382 */         var2.stackSize--;
/* 383 */         if (var2.stackSize <= 0)
/*     */         {
/* 385 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 388 */       return true;
/* 389 */     }  if (isTamed() && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */       
/* 391 */       if (!isSitting()) {
/* 392 */         setSitting(true);
/*     */       } else {
/* 394 */         setSitting(false);
/*     */       } 
/*     */       
/* 397 */       if (this.worldObj.isRemote)
/*     */       {
/*     */         
/* 400 */         par1EntityPlayer.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
/*     */       }
/* 402 */       return true;
/*     */     } 
/*     */     
/* 405 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 414 */     if (isSitting())
/*     */     {
/* 416 */       return null;
/*     */     }
/* 418 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 426 */     return "orespawn:cryo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 434 */     return "orespawn:cryo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 442 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 450 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 458 */     int var3 = 0;
/*     */     
/* 460 */     if (isTamed()) {
/*     */       
/* 462 */       var3 = this.rand.nextInt(5);
/* 463 */       var3 += 2;
/* 464 */       for (int var4 = 0; var4 < var3; var4++)
/*     */       {
/* 466 */         dropItem(Item.getItemFromBlock((Block)Blocks.red_flower), 1);
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
/* 478 */     return isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.5F) : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 487 */     boolean ret = false;
/* 488 */     float p2 = par2;
/* 489 */     if (p2 > 10.0F) p2 = 10.0F; 
/* 490 */     ret = super.attackEntityFrom(par1DamageSource, p2);
/* 491 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 500 */     if (isChild()) {
/* 501 */       enablePersistence();
/* 502 */       return false;
/*     */     } 
/* 504 */     if (isTamed()) return false; 
/* 505 */     if (isNoDespawnRequired()) return false; 
/* 506 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 511 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VelocityRaptor spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 517 */     return new VelocityRaptor(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 525 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.apple);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 534 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\VelocityRaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */