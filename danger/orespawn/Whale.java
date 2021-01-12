/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITempt;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Whale
/*     */   extends EntityAnimal
/*     */ {
/*  47 */   private float moveSpeed = 0.35F;
/*  48 */   private int spray = 0;
/*  49 */   private int spray_timer = 0;
/*     */   private int closest;
/*     */   private int tx;
/*     */   private int ty;
/*  53 */   private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage); getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D); } protected void entityInit() { super.entityInit(); } public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onUpdate(); if (this.spray == 0) { if (this.spray_timer > 0) this.spray_timer--;  if (this.spray_timer == 0) { this.spray_timer = 250 + this.worldObj.rand.nextInt(250); this.spray = 25 + this.worldObj.rand.nextInt(25); }  }  if (this.worldObj.isRemote && this.spray > 0) { for (int i = 0; i < 20; i++) { double d = this.worldObj.rand.nextDouble() * 0.75D; d *= d; double dir = this.worldObj.rand.nextDouble() * 2.0D * Math.PI; dir -= Math.PI; double dx = Math.cos(dir) * d / 2.0D; double dz = Math.sin(dir) * d / 2.0D; dir += 1.5707963267948966D; if (i < 10) { this.worldObj.spawnParticle("bubble", this.posX + dx, this.posY + 1.0D + d, this.posZ + dz, Math.cos(dir) * this.worldObj.rand.nextFloat() / 4.0D, (this.worldObj.rand.nextFloat() * 2.0F), Math.sin(dir) * this.worldObj.rand.nextFloat() / 4.0D); } else { this.worldObj.spawnParticle("splash", this.posX + dx, this.posY + 1.0D + d, this.posZ + dz, Math.cos(dir) * this.worldObj.rand.nextFloat() / 4.0D, (this.worldObj.rand.nextFloat() * 2.0F), Math.sin(dir) * this.worldObj.rand.nextFloat() / 4.0D); }  }  this.spray--; }  if (this.worldObj.rand.nextInt(200) == 1) heal(1.0F);  } public boolean isAIEnabled() { return true; } public Whale(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 214 */     this.closest = 99999;
/* 215 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(1.5F, 2.5F); this.moveSpeed = 0.35F; this.fireResistance = 100; this.experienceValue = 40; getNavigator().setAvoidsWater(false); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate(this, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, Items.fish, false)); this.tasks.addTask(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 12.0F)); this.tasks.addTask(6, new MyEntityAIWander((EntityCreature)this, 1.0F)); this.tasks.addTask(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); }
/*     */   public boolean canBreatheUnderwater() { return true; }
/*     */   public int mygetMaxHealth() { return 100; }
/* 218 */   protected String getLivingSound() { return "splash"; } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 223 */     for (i = -dy; i <= dy; i++) {
/* 224 */       for (int j = -dz; j <= dz; j++) {
/* 225 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 226 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 227 */           int d = dx * dx + j * j + i * i;
/* 228 */           if (d < this.closest) {
/* 229 */             this.closest = d;
/* 230 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 231 */             found++;
/*     */           } 
/*     */         } 
/* 234 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 235 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 236 */           int d = dx * dx + j * j + i * i;
/* 237 */           if (d < this.closest) {
/* 238 */             this.closest = d;
/* 239 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 240 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 246 */     for (i = -dx; i <= dx; i++) {
/* 247 */       for (int j = -dz; j <= dz; j++) {
/* 248 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 249 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 250 */           int d = dy * dy + j * j + i * i;
/* 251 */           if (d < this.closest) {
/* 252 */             this.closest = d;
/* 253 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 254 */             found++;
/*     */           } 
/*     */         } 
/* 257 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 258 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 259 */           int d = dy * dy + j * j + i * i;
/* 260 */           if (d < this.closest) {
/* 261 */             this.closest = d;
/* 262 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 263 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 269 */     for (i = -dx; i <= dx; i++) {
/* 270 */       for (int j = -dy; j <= dy; j++) {
/* 271 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 272 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 273 */           int d = dz * dz + j * j + i * i;
/* 274 */           if (d < this.closest) {
/* 275 */             this.closest = d;
/* 276 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 277 */             found++;
/*     */           } 
/*     */         } 
/* 280 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 281 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 282 */           int d = dz * dz + j * j + i * i;
/* 283 */           if (d < this.closest) {
/* 284 */             this.closest = d;
/* 285 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 286 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 292 */     if (found != 0) return true; 
/* 293 */     return false; } protected String getHurtSound() { return "orespawn:little_splat"; }
/*     */   protected String getDeathSound() { return "orespawn:big_splat"; }
/*     */   protected float getSoundVolume() { return 0.9F; }
/*     */   protected float getSoundPitch() { return 0.5F; }
/*     */   protected Item getDropItem() { return Items.fish; }
/*     */   private void dropItemRand(Item index, int par1) { EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0)); this.worldObj.spawnEntityInWorld((Entity)var3); }
/*     */   protected void dropFewItems(boolean par1, int par2) { int var3 = 0; var3 = this.rand.nextInt(25);
/*     */     var3 += 20;
/*     */     for (int var4 = 0; var4 < var3; var4++)
/*     */       dropItemRand(Items.fish, 1);  }
/* 303 */   protected void updateAITick() { super.updateAITick();
/* 304 */     if (this.isDead)
/* 305 */       return;  if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null);
/*     */ 
/*     */     
/* 308 */     if (!isInWater() && this.worldObj.rand.nextInt(20) == 0) {
/*     */ 
/*     */ 
/*     */       
/* 312 */       this.closest = 99999;
/* 313 */       this.tx = this.ty = this.tz = 0;
/* 314 */       for (int i = 1; i < 11; i++) {
/* 315 */         int j = i;
/* 316 */         if (j > 4) j = 4; 
/* 317 */         if (scan_it((int)this.posX, (int)this.posY - 1, (int)this.posZ, i, j, i) == true)
/* 318 */           break;  if (i >= 5) i++;
/*     */       
/*     */       } 
/* 321 */       if (this.closest < 99999) {
/* 322 */         getNavigator().tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.0D);
/*     */       } else {
/*     */         
/* 325 */         if (this.worldObj.rand.nextInt(25) == 1)
/* 326 */           heal(-4.0F); 
/* 327 */         if (getHealth() <= 0.0F) {
/* 328 */           setDead();
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/* 333 */     if (isInWater() && this.worldObj.rand.nextInt(50) == 0) {
/* 334 */       playSound("splash", 1.0F, this.worldObj.rand.nextFloat() * 0.2F + 0.9F);
/* 335 */       heal(1.0F);
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 342 */     List var5 = this.worldObj.getEntitiesWithinAABB(Whale.class, this.boundingBox.expand(32.0D, 8.0D, 32.0D));
/* 343 */     return var5.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 351 */     if (this.posY < 50.0D) return false; 
/* 352 */     if (!this.worldObj.isDaytime()) return false; 
/* 353 */     if (this.worldObj.rand.nextInt(50) != 1) return false; 
/* 354 */     if (findBuddies() > 0) return false; 
/* 355 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 363 */     if (isChild()) {
/* 364 */       enablePersistence();
/* 365 */       return false;
/*     */     } 
/* 367 */     if (isNoDespawnRequired()) return false; 
/* 368 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 373 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Whale spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 379 */     return new Whale(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 387 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.fish);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 396 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Whale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */