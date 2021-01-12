/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public class Gazelle
/*     */   extends EntityTameable
/*     */ {
/*  48 */   private float moveSpeed = 0.2F;
/*  49 */   private GenericTargetSorter TargetSorter = null;
/*     */   private int closest; private int tx; private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*     */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*     */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  53 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D); } public Gazelle(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     this.closest = 99999;
/* 103 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.6F, 1.8F); this.moveSpeed = 0.3F; this.fireResistance = 100; getNavigator().setAvoidsWater(true); setSitting(false); this.experienceValue = 5; this.TargetSorter = new GenericTargetSorter((Entity)this); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D)); this.tasks.addTask(2, new MyEntityAIFollowOwner(this, 2.0F, 10.0F, 2.0F)); this.tasks.addTask(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.7000000476837158D)); this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, Items.apple, false)); this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(6, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 12.0F, 1.0D, 2.0D)); this.tasks.addTask(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*     */     this.tasks.addTask(8, new MyEntityAIWander((EntityCreature)this, 1.0F));
/*     */     this.tasks.addTask(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/* 106 */     this.tasks.addTask(10, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this)); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 111 */     for (i = -dy; i <= dy; i++) {
/* 112 */       for (int j = -dz; j <= dz; j++) {
/* 113 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 114 */         if (bid == OreSpawnMain.MyStrawberryPlant || bid == Blocks.potatoes || bid == Blocks.carrots || bid == Blocks.tallgrass || bid == Blocks.double_plant) {
/* 115 */           int d = dx * dx + j * j + i * i;
/* 116 */           if (d < this.closest) {
/* 117 */             this.closest = d;
/* 118 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 119 */             found++;
/*     */           } 
/*     */         } 
/* 122 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 123 */         if (bid == OreSpawnMain.MyStrawberryPlant || bid == Blocks.potatoes || bid == Blocks.carrots || bid == Blocks.tallgrass || bid == Blocks.double_plant) {
/* 124 */           int d = dx * dx + j * j + i * i;
/* 125 */           if (d < this.closest) {
/* 126 */             this.closest = d;
/* 127 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 128 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 134 */     for (i = -dx; i <= dx; i++) {
/* 135 */       for (int j = -dz; j <= dz; j++) {
/* 136 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 137 */         if (bid == OreSpawnMain.MyStrawberryPlant || bid == Blocks.potatoes || bid == Blocks.carrots || bid == Blocks.tallgrass || bid == Blocks.double_plant) {
/* 138 */           int d = dy * dy + j * j + i * i;
/* 139 */           if (d < this.closest) {
/* 140 */             this.closest = d;
/* 141 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 142 */             found++;
/*     */           } 
/*     */         } 
/* 145 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 146 */         if (bid == OreSpawnMain.MyStrawberryPlant || bid == Blocks.potatoes || bid == Blocks.carrots || bid == Blocks.tallgrass || bid == Blocks.double_plant) {
/* 147 */           int d = dy * dy + j * j + i * i;
/* 148 */           if (d < this.closest) {
/* 149 */             this.closest = d;
/* 150 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 151 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 157 */     for (i = -dx; i <= dx; i++) {
/* 158 */       for (int j = -dy; j <= dy; j++) {
/* 159 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 160 */         if (bid == OreSpawnMain.MyStrawberryPlant || bid == Blocks.potatoes || bid == Blocks.carrots || bid == Blocks.tallgrass || bid == Blocks.double_plant) {
/* 161 */           int d = dz * dz + j * j + i * i;
/* 162 */           if (d < this.closest) {
/* 163 */             this.closest = d;
/* 164 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 165 */             found++;
/*     */           } 
/*     */         } 
/* 168 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 169 */         if (bid == OreSpawnMain.MyStrawberryPlant || bid == Blocks.potatoes || bid == Blocks.carrots || bid == Blocks.tallgrass || bid == Blocks.double_plant) {
/* 170 */           int d = dz * dz + j * j + i * i;
/* 171 */           if (d < this.closest) {
/* 172 */             this.closest = d;
/* 173 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 174 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 180 */     if (found != 0) return true; 
/* 181 */     return false; } protected void entityInit() { super.entityInit();
/*     */     setSitting(false); } public void onUpdate() {
/*     */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*     */     super.onUpdate();
/*     */   }
/*     */   protected void fall(float par1) {
/* 187 */     float i = MathHelper.ceiling_float_int(par1 - 3.0F);
/*     */     
/* 189 */     if (i > 0.0F) {
/*     */       
/* 191 */       if (i > 3.0F) {
/*     */         
/* 193 */         playSound("damage.fallbig", 1.0F, 1.0F);
/*     */       }
/*     */       else {
/*     */         
/* 197 */         playSound("damage.fallsmall", 1.0F, 1.0F);
/*     */       } 
/* 199 */       if (i > 2.0F)
/*     */       {
/* 201 */         i = 2.0F;
/*     */       }
/* 203 */       attackEntityFrom(DamageSource.fall, i);
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
/*     */   protected void updateAITick() {
/* 215 */     if (this.isDead)
/* 216 */       return;  if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 217 */     if (!isSitting()) {
/* 218 */       if ((this.worldObj.rand.nextInt(30) == 0 && getGazelleHealth() < mygetMaxHealth()) || this.worldObj.rand.nextInt(750) == 1)
/*     */       {
/*     */ 
/*     */         
/* 222 */         if (OreSpawnMain.PlayNicely == 0) {
/* 223 */           this.closest = 99999;
/* 224 */           this.tx = this.ty = this.tz = 0;
/* 225 */           for (int i = 1; i < 11; i++) {
/* 226 */             int j = i;
/* 227 */             if (j > 2) j = 2; 
/* 228 */             if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i) == true)
/* 229 */               break;  if (i >= 6) i++;
/*     */           
/*     */           } 
/* 232 */           if (this.closest < 99999) {
/*     */             
/* 234 */             getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 235 */             if (this.closest < 12) {
/*     */               
/* 237 */               if (this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2); 
/* 238 */               heal(1.0F);
/* 239 */               playSound("random.burp", 1.0F, this.worldObj.rand.nextFloat() * 0.2F + 0.9F);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 246 */       if (this.worldObj.rand.nextInt(250) == 1) {
/* 247 */         Gazelle buddy = findBuddy();
/* 248 */         if (buddy != null) {
/* 249 */           getNavigator().tryMoveToXYZ(buddy.posX, buddy.posY, buddy.posZ, 0.5D);
/*     */         }
/*     */       } 
/*     */     } 
/* 253 */     if (this.worldObj.rand.nextInt(250) == 0)
/*     */     {
/* 255 */       heal(1.0F);
/*     */     }
/* 257 */     super.updateAITick();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Gazelle findBuddy() {
/* 263 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(Gazelle.class, this.boundingBox.expand(16.0D, 6.0D, 16.0D));
/* 264 */     Collections.sort(var5, this.TargetSorter);
/* 265 */     Iterator<?> var2 = var5.iterator();
/* 266 */     Entity var3 = null;
/* 267 */     Gazelle var4 = null;
/*     */     
/* 269 */     if (var2.hasNext()) {
/*     */       
/* 271 */       var3 = (Entity)var2.next();
/* 272 */       var4 = (Gazelle)var3;
/* 273 */       return var4;
/*     */     } 
/* 275 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAIEnabled() {
/* 283 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 289 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 294 */     return 15;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGazelleHealth() {
/* 301 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 309 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*     */ 
/*     */     
/* 312 */     if (var2 != null)
/*     */     {
/* 314 */       if (var2.stackSize <= 0) {
/*     */         
/* 316 */         par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 317 */         var2 = null;
/*     */       } 
/*     */     }
/* 320 */     if (super.interact(par1EntityPlayer)) {
/* 321 */       return true;
/*     */     }
/* 323 */     if (var2 != null && var2.getItem() == Items.apple && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*     */       
/* 325 */       if (!isTamed()) {
/*     */         
/* 327 */         if (!this.worldObj.isRemote)
/*     */         {
/* 329 */           if (this.rand.nextInt(2) == 0)
/*     */           {
/* 331 */             setTamed(true);
/* 332 */             func_152115_b(par1EntityPlayer.getUniqueID().toString());
/* 333 */             playTameEffect(true);
/* 334 */             this.worldObj.setEntityState((Entity)this, (byte)7);
/* 335 */             heal(mygetMaxHealth() - getHealth());
/*     */           
/*     */           }
/*     */           else
/*     */           {
/* 340 */             playTameEffect(false);
/* 341 */             this.worldObj.setEntityState((Entity)this, (byte)6);
/*     */           }
/*     */         
/*     */         }
/*     */       }
/* 346 */       else if (isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */         
/* 348 */         if (this.worldObj.isRemote) {
/* 349 */           playTameEffect(true);
/* 350 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*     */         } 
/*     */         
/* 353 */         if (mygetMaxHealth() > getHealth()) {
/* 354 */           heal(mygetMaxHealth() - getHealth());
/*     */         }
/*     */       } 
/*     */       
/* 358 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 360 */         var2.stackSize--;
/* 361 */         if (var2.stackSize <= 0)
/*     */         {
/* 363 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 366 */       return true;
/*     */     } 
/* 368 */     if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */ 
/*     */       
/* 371 */       if (!this.worldObj.isRemote) {
/*     */         
/* 373 */         setTamed(false);
/* 374 */         func_152115_b("");
/* 375 */         playTameEffect(false);
/* 376 */         this.worldObj.setEntityState((Entity)this, (byte)6);
/*     */       } 
/* 378 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 380 */         var2.stackSize--;
/* 381 */         if (var2.stackSize <= 0)
/*     */         {
/* 383 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 386 */       return true;
/*     */     } 
/*     */     
/* 389 */     if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */       
/* 391 */       setCustomNameTag(var2.getDisplayName());
/* 392 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 394 */         var2.stackSize--;
/* 395 */         if (var2.stackSize <= 0)
/*     */         {
/* 397 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 400 */       return true;
/* 401 */     }  if (isTamed() && isOwner((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*     */       
/* 403 */       if (!isSitting()) {
/* 404 */         setSitting(true);
/*     */       } else {
/* 406 */         setSitting(false);
/*     */       } 
/* 408 */       return true;
/*     */     } 
/*     */     
/* 411 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 420 */     if (isSitting())
/*     */     {
/* 422 */       return null;
/*     */     }
/* 424 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 432 */     return "orespawn:scorpion_hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 440 */     return "orespawn:cryo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 448 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 456 */     return Items.beef;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 464 */     int var3 = 0;
/*     */     
/* 466 */     if (isTamed()) {
/*     */       
/* 468 */       var3 = this.rand.nextInt(5);
/* 469 */       var3 += 2;
/* 470 */       for (int var4 = 0; var4 < var3; var4++)
/*     */       {
/* 472 */         dropItem(Item.getItemFromBlock((Block)Blocks.red_flower), 1);
/*     */       }
/*     */     } else {
/* 475 */       super.dropFewItems(par1, par2);
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
/* 486 */     return isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.5F) : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 495 */     boolean ret = false;
/* 496 */     float p2 = par2;
/* 497 */     if (isTamed() && p2 > 10.0F) p2 = 10.0F; 
/* 498 */     ret = super.attackEntityFrom(par1DamageSource, p2);
/* 499 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 505 */     if (this.posY < 50.0D) return false; 
/* 506 */     if (this.posY > 100.0D) return false; 
/* 507 */     Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ);
/* 508 */     if (bid != Blocks.dirt && bid != Blocks.grass && bid != Blocks.tallgrass) return false; 
/* 509 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 517 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 522 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Gazelle spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 528 */     return new Gazelle(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 536 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.apple);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 545 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Gazelle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */