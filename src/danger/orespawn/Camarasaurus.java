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
/*     */ public class Camarasaurus
/*     */   extends EntityTameable
/*     */ {
/*  43 */   private float moveSpeed = 0.2F;
/*     */   private int closest; private int tx; private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*     */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*     */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  47 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D); } public Camarasaurus(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 126 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.5F, 1.2F); this.moveSpeed = 0.2F; this.fireResistance = 100; getNavigator().setAvoidsWater(true); setSitting(false); this.experienceValue = 5; this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0D)); this.tasks.addTask(2, new MyEntityAIFollowOwner(this, 2.0F, 10.0F, 2.0F)); this.tasks.addTask(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.399999976158142D)); this.tasks.addTask(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, Items.apple, false)); this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F)); this.tasks.addTask(7, new MyEntityAIWander((EntityCreature)this, 1.0F)); this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     this.tasks.addTask(9, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this)); }
/*     */   protected void entityInit() { super.entityInit();
/* 129 */     setSitting(false); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 134 */     for (i = -dy; i <= dy; i++) {
/* 135 */       for (int j = -dz; j <= dz; j++) {
/* 136 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 137 */         if (bid == Blocks.leaves || bid == Blocks.vine || bid == Blocks.tallgrass || bid == Blocks.cactus || bid == Blocks.double_plant) {
/* 138 */           int d = dx * dx + j * j + i * i;
/* 139 */           if (d < this.closest) {
/* 140 */             this.closest = d;
/* 141 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 142 */             found++;
/*     */           } 
/*     */         } 
/* 145 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 146 */         if (bid == Blocks.leaves || bid == Blocks.vine || bid == Blocks.tallgrass || bid == Blocks.cactus || bid == Blocks.double_plant) {
/* 147 */           int d = dx * dx + j * j + i * i;
/* 148 */           if (d < this.closest) {
/* 149 */             this.closest = d;
/* 150 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 151 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 157 */     for (i = -dx; i <= dx; i++) {
/* 158 */       for (int j = -dz; j <= dz; j++) {
/* 159 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 160 */         if (bid == Blocks.leaves || bid == Blocks.vine || bid == Blocks.tallgrass || bid == Blocks.cactus || bid == Blocks.double_plant) {
/* 161 */           int d = dy * dy + j * j + i * i;
/* 162 */           if (d < this.closest) {
/* 163 */             this.closest = d;
/* 164 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 165 */             found++;
/*     */           } 
/*     */         } 
/* 168 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 169 */         if (bid == Blocks.leaves || bid == Blocks.vine || bid == Blocks.tallgrass || bid == Blocks.cactus || bid == Blocks.double_plant) {
/* 170 */           int d = dy * dy + j * j + i * i;
/* 171 */           if (d < this.closest) {
/* 172 */             this.closest = d;
/* 173 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 174 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 180 */     for (i = -dx; i <= dx; i++) {
/* 181 */       for (int j = -dy; j <= dy; j++) {
/* 182 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 183 */         if (bid == Blocks.leaves || bid == Blocks.vine || bid == Blocks.tallgrass || bid == Blocks.cactus || bid == Blocks.double_plant) {
/* 184 */           int d = dz * dz + j * j + i * i;
/* 185 */           if (d < this.closest) {
/* 186 */             this.closest = d;
/* 187 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 188 */             found++;
/*     */           } 
/*     */         } 
/* 191 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 192 */         if (bid == Blocks.leaves || bid == Blocks.vine || bid == Blocks.tallgrass || bid == Blocks.cactus || bid == Blocks.double_plant) {
/* 193 */           int d = dz * dz + j * j + i * i;
/* 194 */           if (d < this.closest) {
/* 195 */             this.closest = d;
/* 196 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 197 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 203 */     if (found != 0) return true; 
/* 204 */     return false; } public boolean getCanSpawnHere() { if (this.posY < 50.0D)
/*     */       return false;  if (!this.worldObj.isDaytime())
/*     */       return false;  return true; }
/*     */   public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onUpdate(); }
/*     */   protected void fall(float par1) { float i = MathHelper.ceiling_float_int(par1 - 3.0F); if (i > 0.0F) { if (i > 3.0F) { playSound("damage.fallbig", 1.0F, 1.0F); }
/*     */       else
/*     */       { playSound("damage.fallsmall", 1.0F, 1.0F); }
/*     */        if (i > 2.0F)
/*     */         i = 2.0F;  attackEntityFrom(DamageSource.fall, i); }
/*     */      }
/* 214 */   protected void updateAITick() { if (this.isDead)
/* 215 */       return;  if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 216 */     super.updateAITick();
/* 217 */     if (!isSitting() && ((
/* 218 */       this.worldObj.rand.nextInt(20) == 0 && getCamarasaurusHealth() < mygetMaxHealth()) || this.worldObj.rand.nextInt(250) == 0))
/*     */     {
/* 220 */       if (OreSpawnMain.PlayNicely == 0) {
/*     */ 
/*     */         
/* 223 */         this.closest = 99999;
/* 224 */         this.tx = this.ty = this.tz = 0;
/* 225 */         for (int i = 1; i < 11; i++) {
/* 226 */           int j = i;
/* 227 */           if (j > 2) j = 2; 
/* 228 */           if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i) == true)
/* 229 */             break;  if (i >= 6) i++;
/*     */         
/*     */         } 
/* 232 */         if (this.closest < 99999) {
/*     */           
/* 234 */           getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 235 */           if (this.closest < 12) {
/*     */             
/* 237 */             if (this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2); 
/* 238 */             heal(1.0F);
/* 239 */             playSound("random.burp", 1.0F, this.worldObj.rand.nextFloat() * 0.2F + 0.9F);
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
/* 253 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 259 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 264 */     return 20;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCamarasaurusHealth() {
/* 271 */     return (int)getHealth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 279 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*     */ 
/*     */     
/* 282 */     if (var2 != null)
/*     */     {
/* 284 */       if (var2.stackSize <= 0) {
/*     */         
/* 286 */         par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 287 */         var2 = null;
/*     */       } 
/*     */     }
/*     */     
/* 291 */     if (super.interact(par1EntityPlayer)) {
/* 292 */       return true;
/*     */     }
/*     */     
/* 295 */     if (var2 != null && var2.getItem() == Items.apple && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*     */       
/* 297 */       if (!isTamed()) {
/*     */         
/* 299 */         if (!this.worldObj.isRemote)
/*     */         {
/* 301 */           if (this.rand.nextInt(2) == 0)
/*     */           {
/* 303 */             setTamed(true);
/* 304 */             func_152115_b(par1EntityPlayer.getUniqueID().toString());
/* 305 */             playTameEffect(true);
/* 306 */             this.worldObj.setEntityState((Entity)this, (byte)7);
/* 307 */             heal(mygetMaxHealth() - getHealth());
/*     */           
/*     */           }
/*     */           else
/*     */           {
/* 312 */             playTameEffect(false);
/* 313 */             this.worldObj.setEntityState((Entity)this, (byte)6);
/*     */           }
/*     */         
/*     */         }
/*     */       }
/* 318 */       else if (isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */         
/* 320 */         if (this.worldObj.isRemote) {
/* 321 */           playTameEffect(true);
/* 322 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*     */         } 
/*     */         
/* 325 */         if (mygetMaxHealth() > getHealth()) {
/* 326 */           heal(mygetMaxHealth() - getHealth());
/*     */         }
/*     */       } 
/*     */       
/* 330 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 332 */         var2.stackSize--;
/* 333 */         if (var2.stackSize <= 0)
/*     */         {
/* 335 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 338 */       return true;
/*     */     } 
/* 340 */     if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*     */       
/* 342 */       setCustomNameTag(var2.getDisplayName());
/* 343 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 345 */         var2.stackSize--;
/* 346 */         if (var2.stackSize <= 0)
/*     */         {
/* 348 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 351 */       return true;
/* 352 */     }  if (isTamed() && isOwner((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*     */       
/* 354 */       if (!isSitting()) {
/* 355 */         setSitting(true);
/*     */       } else {
/* 357 */         setSitting(false);
/*     */       } 
/* 359 */       return true;
/*     */     } 
/*     */     
/* 362 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 370 */     if (isSitting())
/*     */     {
/* 372 */       return null;
/*     */     }
/* 374 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 382 */     return "orespawn:cryo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 390 */     return "orespawn:cryo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 398 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 406 */     return Item.getItemFromBlock((Block)Blocks.red_flower);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/* 414 */     int var3 = 0;
/*     */     
/* 416 */     if (isTamed()) {
/*     */       
/* 418 */       var3 = this.rand.nextInt(5);
/* 419 */       var3 += 2;
/* 420 */       for (int var4 = 0; var4 < var3; var4++)
/*     */       {
/* 422 */         dropItem(Item.getItemFromBlock((Block)Blocks.red_flower), 1);
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
/* 434 */     return isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.5F) : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 444 */     boolean ret = false;
/* 445 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/* 446 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 455 */     if (isChild()) {
/* 456 */       enablePersistence();
/* 457 */       return false;
/*     */     } 
/* 459 */     if (isNoDespawnRequired()) return false; 
/* 460 */     if (isTamed()) return false; 
/* 461 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 466 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Camarasaurus spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 472 */     return new Camarasaurus(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 480 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.apple);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 489 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Camarasaurus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */