/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.util.ai.MyEntityAIWanderALot;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
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
/*     */ public class Beaver
/*     */   extends EntityAnimal
/*     */ {
/*  53 */   private float moveSpeed = 0.15F;
/*  54 */   private GenericTargetSorter TargetSorter = null;
/*     */   private int closest; private int tx; private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*     */     getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
/*  57 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D); } public Beaver(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     this.closest = 99999;
/* 112 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.6F, 0.8F); this.moveSpeed = 0.2F; this.experienceValue = 5; this.TargetSorter = new GenericTargetSorter((Entity)this); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate(this, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.5D)); this.tasks.addTask(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(5, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 8.0F, 1.0D, 1.5D)); this.tasks.addTask(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*     */     this.tasks.addTask(7, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D));
/*     */     this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); }
/* 115 */   protected void entityInit() { super.entityInit(); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 120 */     for (i = -dy; i <= dy; i++) {
/* 121 */       for (int j = -dz; j <= dz; j++) {
/* 122 */         Block bid = this.world.getBlockState(new BlockPos(x + dx, y + i, z + j)).getBlock();
/* 123 */         if (isWood(bid)) {
/* 124 */           int d = dx * dx + j * j + i * i;
/* 125 */           if (d < this.closest) {
/* 126 */             this.closest = d;
/* 127 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 128 */             found++;
/*     */           } 
/*     */         } 
/* 131 */         bid = this.world.getBlockState(new BlockPos(x - dx, y + i, z + j)).getBlock();
/* 132 */         if (isWood(bid)) {
/* 133 */           int d = dx * dx + j * j + i * i;
/* 134 */           if (d < this.closest) {
/* 135 */             this.closest = d;
/* 136 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 137 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 143 */     for (i = -dx; i <= dx; i++) {
/* 144 */       for (int j = -dz; j <= dz; j++) {
/* 145 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + dy, z + j)).getBlock();
/* 146 */         if (isWood(bid)) {
/* 147 */           int d = dy * dy + j * j + i * i;
/* 148 */           if (d < this.closest) {
/* 149 */             this.closest = d;
/* 150 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 151 */             found++;
/*     */           } 
/*     */         } 
/* 154 */         bid = this.world.getBlockState(new BlockPos(x + i, y - dy, z + j)).getBlock();
/* 155 */         if (isWood(bid)) {
/* 156 */           int d = dy * dy + j * j + i * i;
/* 157 */           if (d < this.closest) {
/* 158 */             this.closest = d;
/* 159 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 160 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 166 */     for (i = -dx; i <= dx; i++) {
/* 167 */       for (int j = -dy; j <= dy; j++) {
/* 168 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + j, z + dz)).getBlock();
/* 169 */         if (isWood(bid)) {
/* 170 */           int d = dz * dz + j * j + i * i;
/* 171 */           if (d < this.closest) {
/* 172 */             this.closest = d;
/* 173 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 174 */             found++;
/*     */           } 
/*     */         } 
/* 177 */         bid = this.world.getBlockState(new BlockPos(x + i, y + j, z - dz)).getBlock();
/* 178 */         if (isWood(bid)) {
/* 179 */           int d = dz * dz + j * j + i * i;
/* 180 */           if (d < this.closest) {
/* 181 */             this.closest = d;
/* 182 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 183 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 189 */     if (found != 0) return true; 
/* 190 */     return false; } public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed); super.onUpdate(); }
/*     */   private boolean isWood(Block bid) { if (bid == Blocks.LOG)
/*     */       return true;  if (bid == Blocks.OAK_FENCE || bid == Blocks.OAK_FENCE_GATE || bid == Blocks.STANDING_SIGN || bid == Blocks.BIRCH_FENCE || bid == Blocks.BIRCH_FENCE_GATE || bid == Blocks.ACACIA_FENCE || bid == Blocks.ACACIA_FENCE_GATE || bid == Blocks.JUNGLE_FENCE || bid == Blocks.JUNGLE_FENCE_GATE || bid == Blocks.SPRUCE_FENCE || bid == Blocks.SPRUCE_FENCE_GATE || bid == Blocks.DARK_OAK_FENCE || bid == Blocks.DARK_OAK_FENCE_GATE)
/*     */       return true; 
/*     */     return false; }
/* 195 */   private ItemStack dropItemRand(Item index, int par1) { EntityItem var3 = null;
/* 196 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */ 
/*     */ 
/*     */     
/* 200 */     var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 4.0D + this.world.rand.nextInt(4), this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), is);
/*     */     
/* 202 */     if (var3 != null) this.world.spawnEntity((Entity)var3); 
/* 203 */     return is; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void breakRecursor(World world, int x, int y, int z, int xf, int yf, int zf, int recursion) {
/* 211 */     int var7 = 1;
/*     */     
/* 213 */     if (recursion > 200)
/*     */       return; 
/* 215 */     for (int var9 = -var7; var9 <= var7; var9++) {
/*     */       
/* 217 */       for (int var10 = -var7; var10 <= var7; var10++) {
/*     */         
/* 219 */         for (int var11 = -var7; var11 <= var7; var11++) {
/*     */ 
/*     */           
/* 222 */           if ((var9 != 0 || var10 != 0 || var11 != 0) && (
/* 223 */             x + var9 != xf || y + var10 != yf || z + var11 != zf) && (
/* 224 */             recursion <= 0 || x + var9 < xf - var7 || x + var9 > xf + var7 || y + var10 < yf - var7 || y + var10 > yf + var7 || z + var11 < zf - var7 || z + var11 > zf + var7)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 230 */             Block var12 = world.getBlockState(new BlockPos(x + var9, y + var10, z + var11)).getBlock();
/* 231 */             if (isWood(var12)) {
/*     */               
/* 233 */               world.setBlockToAir(new BlockPos(x + var9, y + var10, z + var11));
/*     */               
/* 235 */               dropItemRand(Item.getItemFromBlock(var12), 1);
/* 236 */               breakRecursor(world, x + var9, y + var10, z + var11, x, y, z, recursion + 1);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 249 */     if (this.isDead)
/* 250 */       return;  if (this.world.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 251 */     if ((this.world.rand.nextInt(30) == 0 && getBeaverHealth() < mygetMaxHealth()) || this.world.rand.nextInt(350) == 1)
/*     */     {
/* 253 */       if (OreSpawnMain.PlayNicely == 0) {
/*     */ 
/*     */         
/* 256 */         this.closest = 99999;
/* 257 */         this.tx = this.ty = this.tz = 0; int i;
/* 258 */         for (i = 1; i < 11; i++) {
/* 259 */           int j = i;
/* 260 */           if (j > 2) j = 2; 
/* 261 */           if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i))
/* 262 */             break;  if (i >= 6) i++; 
/*     */         } 
/* 264 */         i = 0;
/* 265 */         if (this.closest < 99999) {
/*     */           
/* 267 */           getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 268 */           if (this.closest < 12) {
/*     */             
/* 270 */             if (this.world.getGameRules().getBoolean("mobGriefing")) {
/* 271 */               this.world.setBlockToAir(new BlockPos(this.tx, this.ty, this.tz));
/*     */               
/* 273 */               breakRecursor(this.world, this.tx, this.ty, this.tz, this.tx, this.ty, this.tz, i);
/*     */             } 
/* 275 */             heal(1.0F);
/* 276 */             playSound(SoundsHandler.CHAINSAW, 1.0F, this.world.rand.nextFloat() * 0.2F + 0.9F);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 283 */     if (this.world.rand.nextInt(200) == 1) {
/* 284 */       Beaver buddy = findBuddy();
/* 285 */       if (buddy != null) {
/* 286 */         getNavigator().tryMoveToXYZ(buddy.posX, buddy.posY, buddy.posZ, 0.5D);
/*     */       }
/*     */     } 
/* 289 */     super.updateAITasks();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Beaver findBuddy() {
/* 346 */     List<?> var5 = this.world.getEntitiesWithinAABB(Beaver.class, getEntityBoundingBox().expand(16.0D, 6.0D, 16.0D));
/* 347 */     Collections.sort(var5, this.TargetSorter);
/* 348 */     Iterator<?> var2 = var5.iterator();
/* 349 */     Entity var3 = null;
/* 350 */     Beaver var4 = null;
/*     */     
/* 352 */     if (var2.hasNext()) {
/*     */       
/* 354 */       var3 = (Entity)var2.next();
/* 355 */       var4 = (Beaver)var3;
/* 356 */       return var4;
/*     */     } 
/* 358 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isAIDisabled() {
/* 362 */     return false;
/*     */   }
/*     */   public boolean canBreatheUnderwater() {
/* 365 */     return true;
/*     */   } private int mygetMaxHealth() {
/* 367 */     return 15;
/*     */   } private int getBeaverHealth() {
/* 369 */     return (int)getHealth();
/*     */   }
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/* 373 */     return null;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/* 378 */     return SoundsHandler.ENTITY_SCORPION_HIT;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDeath(DamageSource cause) {
/* 383 */     super.onDeath(cause);
/* 384 */     playSound(SoundsHandler.ENTITY_CRYO_DEATH, getSoundVolume(), getSoundPitch());
/*     */   }
/*     */   
/*     */   protected float getSoundVolume() {
/* 388 */     return 0.4F;
/*     */   }
/*     */   protected Item getDropItem() {
/* 391 */     return Items.PORKCHOP;
/*     */   }
/*     */   
/*     */   protected float getSoundPitch() {
/* 395 */     return isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F + 1.5F) : ((this.rand
/* 396 */       .nextFloat() - this.rand.nextFloat()) * 0.1F + 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 402 */     if (this.posY < 50.0D) return false; 
/* 403 */     if (this.posY > 100.0D) return false; 
/* 404 */     Block bid = this.world.getBlockState(new BlockPos((int)this.posX, (int)this.posY - 1, (int)this.posZ)).getBlock();
/* 405 */     return (bid == Blocks.DIRT || bid == Blocks.GRASS || bid == Blocks.TALLGRASS || bid == Blocks.LEAVES);
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 409 */     return false;
/*     */   }
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 412 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   } public Beaver spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 414 */     return new Beaver(this.world);
/*     */   }
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 418 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.APPLE);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 423 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\Beaver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */