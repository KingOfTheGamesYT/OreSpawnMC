/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.util.ai.MyEntityAIWander;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
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
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.init.SoundEvents;
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
/*     */ 
/*     */ 
/*     */ public class Baryonyx
/*     */   extends EntityAnimal
/*     */ {
/*  51 */   private float moveSpeed = 0.25F;
/*     */   private int closest;
/*     */   private int tx;
/*  54 */   private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed); getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE); getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D); } protected void entityInit() { super.entityInit(); } public boolean getCanSpawnHere() { if (this.posY < 50.0D) return false;  if (!this.world.isDaytime()) return false;  if (findBuddies() > 8) return false;  return true; } public Baryonyx(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 171 */     this.closest = 99999;
/* 172 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(1.5F, 2.8F); this.moveSpeed = 0.25F; this.experienceValue = 5; this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate(this, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.399999976158142D)); this.tasks.addTask(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 12.0F)); this.tasks.addTask(6, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 1.0F)); this.tasks.addTask(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); }
/*     */   public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed); updateAITick(); super.onUpdate(); }
/*     */   public boolean isAIEnabled() { return true; }
/* 175 */   public boolean canBreatheUnderwater() { return false; } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 180 */     for (i = -dy; i <= dy; i++) {
/* 181 */       for (int j = -dz; j <= dz; j++) {
/* 182 */         Block bid = this.world.getBlockState(new BlockPos(x + dx, y + i, z + j)).getBlock();
/* 183 */         if (bid == Blocks.GRASS) {
/* 184 */           int d = dx * dx + j * j + i * i;
/* 185 */           if (d < this.closest) {
/* 186 */             this.closest = d;
/* 187 */             this.tx = x + dx;
/* 188 */             this.ty = y + i;
/* 189 */             this.tz = z + j;
/* 190 */             found++;
/*     */           } 
/*     */         } 
/* 193 */         bid = this.world.getBlockState(new BlockPos(x - dx, y + i, z + j)).getBlock();
/* 194 */         if (bid == Blocks.GRASS) {
/* 195 */           int d = dx * dx + j * j + i * i;
/* 196 */           if (d < this.closest) {
/* 197 */             this.closest = d;
/* 198 */             this.tx = x - dx;
/* 199 */             this.ty = y + i;
/* 200 */             this.tz = z + j;
/* 201 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 207 */     for (i = -dx; i <= dx; i++) {
/* 208 */       for (int j = -dz; j <= dz; j++) {
/* 209 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + dy, z + j)).getBlock();
/* 210 */         if (bid == Blocks.GRASS) {
/* 211 */           int d = dy * dy + j * j + i * i;
/* 212 */           if (d < this.closest) {
/* 213 */             this.closest = d;
/* 214 */             this.tx = x + i;
/* 215 */             this.ty = y + dy;
/* 216 */             this.tz = z + j;
/* 217 */             found++;
/*     */           } 
/*     */         } 
/* 220 */         bid = this.world.getBlockState(new BlockPos(x + i, y - dy, z + j)).getBlock();
/* 221 */         if (bid == Blocks.GRASS) {
/* 222 */           int d = dy * dy + j * j + i * i;
/* 223 */           if (d < this.closest) {
/* 224 */             this.closest = d;
/* 225 */             this.tx = x + i;
/* 226 */             this.ty = y - dy;
/* 227 */             this.tz = z + j;
/* 228 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 234 */     for (i = -dx; i <= dx; i++) {
/* 235 */       for (int j = -dy; j <= dy; j++) {
/* 236 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + j, z + dz)).getBlock();
/* 237 */         if (bid == Blocks.GRASS) {
/* 238 */           int d = dz * dz + j * j + i * i;
/* 239 */           if (d < this.closest) {
/* 240 */             this.closest = d;
/* 241 */             this.tx = x + i;
/* 242 */             this.ty = y + j;
/* 243 */             this.tz = z + dz;
/* 244 */             found++;
/*     */           } 
/*     */         } 
/* 247 */         bid = this.world.getBlockState(new BlockPos(x + i, y + j, z - dz)).getBlock();
/* 248 */         if (bid == Blocks.GRASS) {
/* 249 */           int d = dz * dz + j * j + i * i;
/* 250 */           if (d < this.closest) {
/* 251 */             this.closest = d;
/* 252 */             this.tx = x + i;
/* 253 */             this.ty = y + j;
/* 254 */             this.tz = z - dz;
/* 255 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 261 */     if (found != 0) return true; 
/* 262 */     return false; } public int mygetMaxHealth() { return 40; }
/*     */   protected SoundEvent getAmbientSound() { return null; }
/*     */   protected SoundEvent getHurtSound(DamageSource source) { return SoundsHandler.ENTITY_DUCK_HURT; }
/*     */   protected SoundEvent getDeathSound() { return SoundsHandler.ENTITY_DUCK_HURT; }
/*     */   protected float getSoundVolume() { return 0.4F; }
/*     */   protected Item getDropItem() { return Items.BEEF; }
/*     */   protected void dropFewItems(boolean par1, int par2) { int var3 = 0; var3 = this.rand.nextInt(5);
/*     */     var3 += 2;
/*     */     for (int var4 = 0; var4 < var3; var4++)
/*     */       dropItem(Items.BEEF, 1);  }
/* 272 */   protected void updateAITick() { if (this.isDead)
/* 273 */       return;  if (this.world.rand.nextInt(200) == 1) setRevengeTarget(null);
/*     */     
/* 275 */     if (this.world.rand.nextInt(60) == 0 && OreSpawnMain.PlayNicely == 0) {
/*     */ 
/*     */       
/* 278 */       this.closest = 99999;
/* 279 */       this.tx = this.ty = this.tz = 0;
/* 280 */       for (int i = 1; i < 11; i++) {
/* 281 */         int j = i;
/* 282 */         if (j > 2) j = 2; 
/* 283 */         if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i) == true)
/* 284 */           break;  if (i >= 6) i++;
/*     */       
/*     */       } 
/* 287 */       if (this.closest < 99999) {
/*     */         
/* 289 */         getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 290 */         if (this.closest < 12) {
/*     */           
/* 292 */           if (this.world.getGameRules().getBoolean("mobGriefing"))
/* 293 */             this.world.setBlockState(new BlockPos(this.tx, this.ty, this.tz), Blocks.DIRT.getDefaultState()); 
/* 294 */           heal(1.0F);
/* 295 */           playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0F, this.world.rand.nextFloat() * 0.2F + 0.9F);
/*     */         } 
/*     */       } 
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 307 */     if (isChild())
/*     */     {
/* 309 */       return false;
/*     */     }
/* 311 */     if (isNoDespawnRequired()) return false; 
/* 312 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 317 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */   
/*     */   public Baryonyx spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 322 */     return new Baryonyx(this.world);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 329 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.APPLE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 337 */     return (par1ItemStack.getItem() == Items.GOLDEN_APPLE);
/*     */   }
/*     */   
/*     */   private int findBuddies() {
/* 341 */     List var5 = this.world.getEntitiesWithinAABB(Baryonyx.class, getEntityBoundingBox().expand(20.0D, 10.0D, 20.0D));
/* 342 */     return var5.size();
/*     */   }
/*     */   
/*     */   public boolean canMateWith(EntityAnimal otherAnimal) {
/* 346 */     if (otherAnimal == this)
/* 347 */       return false; 
/* 348 */     if (!(otherAnimal instanceof Baryonyx)) {
/* 349 */       return false;
/*     */     }
/* 351 */     Baryonyx baryonyx = (Baryonyx)otherAnimal;
/* 352 */     return (isInLove() && baryonyx.isInLove());
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\entity\Baryonyx.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */