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
/*     */   private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed); getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE); getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D); } protected void entityInit() { super.entityInit(); } public boolean getCanSpawnHere() { if (this.posY < 50.0D) return false;  if (!this.world.isDaytime()) return false;  if (findBuddies() > 8)
/*  55 */       return false;  return true; } public Baryonyx(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 185 */     this.closest = 99999;
/* 186 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(1.5F, 2.8F); this.moveSpeed = 0.25F; this.experienceValue = 5; this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate(this, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.399999976158142D)); this.tasks.addTask(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 12.0F)); this.tasks.addTask(6, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 1.0F)); this.tasks.addTask(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); }
/*     */   public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed); updateAITick(); super.onUpdate(); }
/*     */   public boolean isAIEnabled() { return true; }
/* 189 */   public boolean canBreatheUnderwater() { return false; } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 194 */     for (i = -dy; i <= dy; i++) {
/* 195 */       for (int j = -dz; j <= dz; j++) {
/* 196 */         Block bid = this.world.getBlockState(new BlockPos(x + dx, y + i, z + j)).getBlock();
/* 197 */         if (bid == Blocks.GRASS) {
/* 198 */           int d = dx * dx + j * j + i * i;
/* 199 */           if (d < this.closest) {
/* 200 */             this.closest = d;
/* 201 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 202 */             found++;
/*     */           } 
/*     */         } 
/* 205 */         bid = this.world.getBlockState(new BlockPos(x - dx, y + i, z + j)).getBlock();
/* 206 */         if (bid == Blocks.GRASS) {
/* 207 */           int d = dx * dx + j * j + i * i;
/* 208 */           if (d < this.closest) {
/* 209 */             this.closest = d;
/* 210 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 211 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 217 */     for (i = -dx; i <= dx; i++) {
/* 218 */       for (int j = -dz; j <= dz; j++) {
/* 219 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + dy, z + j)).getBlock();
/* 220 */         if (bid == Blocks.GRASS) {
/* 221 */           int d = dy * dy + j * j + i * i;
/* 222 */           if (d < this.closest) {
/* 223 */             this.closest = d;
/* 224 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 225 */             found++;
/*     */           } 
/*     */         } 
/* 228 */         bid = this.world.getBlockState(new BlockPos(x + i, y - dy, z + j)).getBlock();
/* 229 */         if (bid == Blocks.GRASS) {
/* 230 */           int d = dy * dy + j * j + i * i;
/* 231 */           if (d < this.closest) {
/* 232 */             this.closest = d;
/* 233 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 234 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 240 */     for (i = -dx; i <= dx; i++) {
/* 241 */       for (int j = -dy; j <= dy; j++) {
/* 242 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + j, z + dz)).getBlock();
/* 243 */         if (bid == Blocks.GRASS) {
/* 244 */           int d = dz * dz + j * j + i * i;
/* 245 */           if (d < this.closest) {
/* 246 */             this.closest = d;
/* 247 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 248 */             found++;
/*     */           } 
/*     */         } 
/* 251 */         bid = this.world.getBlockState(new BlockPos(x + i, y + j, z - dz)).getBlock();
/* 252 */         if (bid == Blocks.GRASS) {
/* 253 */           int d = dz * dz + j * j + i * i;
/* 254 */           if (d < this.closest) {
/* 255 */             this.closest = d;
/* 256 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 257 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 263 */     if (found != 0) return true; 
/* 264 */     return false; } public int mygetMaxHealth() { return 40; }
/*     */   protected SoundEvent getAmbientSound() { return null; }
/*     */   protected SoundEvent getHurtSound(DamageSource source) { return SoundsHandler.ENTITY_DUCK_HURT; }
/*     */   protected SoundEvent getDeathSound() { return SoundsHandler.ENTITY_DUCK_HURT; }
/*     */   protected float getSoundVolume() { return 0.4F; }
/*     */   protected Item getDropItem() { return Items.BEEF; }
/*     */   protected void dropFewItems(boolean par1, int par2) { int var3 = 0;
/*     */     var3 = this.rand.nextInt(5);
/*     */     var3 += 2;
/*     */     for (int var4 = 0; var4 < var3; var4++)
/*     */       dropItem(Items.BEEF, 1);  }
/* 275 */   protected void updateAITick() { if (this.isDead)
/* 276 */       return;  if (this.world.rand.nextInt(200) == 1) setRevengeTarget(null);
/*     */     
/* 278 */     if (this.world.rand.nextInt(60) == 0 && OreSpawnMain.PlayNicely == 0) {
/*     */ 
/*     */ 
/*     */       
/* 282 */       this.closest = 99999;
/* 283 */       this.tx = this.ty = this.tz = 0;
/* 284 */       for (int i = 1; i < 11; i++) {
/* 285 */         int j = i;
/* 286 */         if (j > 2) j = 2; 
/* 287 */         if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i) == true)
/* 288 */           break;  if (i >= 6) i++;
/*     */       
/*     */       } 
/* 291 */       if (this.closest < 99999) {
/*     */         
/* 293 */         getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 294 */         if (this.closest < 12) {
/*     */           
/* 296 */           if (this.world.getGameRules().getBoolean("mobGriefing")) this.world.setBlockState(new BlockPos(this.tx, this.ty, this.tz), Blocks.DIRT.getDefaultState()); 
/* 297 */           heal(1.0F);
/* 298 */           playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0F, this.world.rand.nextFloat() * 0.2F + 0.9F);
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
/*     */   
/*     */   protected boolean canDespawn() {
/* 311 */     if (isChild())
/*     */     {
/* 313 */       return false;
/*     */     }
/* 315 */     if (isNoDespawnRequired()) return false; 
/* 316 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 321 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Baryonyx spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 327 */     return new Baryonyx(this.world);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 335 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.APPLE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 344 */     return (par1ItemStack.getItem() == Items.GOLDEN_APPLE);
/*     */   }
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 349 */     List var5 = this.world.getEntitiesWithinAABB(Baryonyx.class, getEntityBoundingBox().expand(20.0D, 10.0D, 20.0D));
/* 350 */     return var5.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canMateWith(EntityAnimal otherAnimal) {
/* 355 */     if (otherAnimal == this)
/*     */     {
/* 357 */       return false;
/*     */     }
/* 359 */     if (!(otherAnimal instanceof Baryonyx))
/*     */     {
/* 361 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 365 */     Baryonyx baryonyx = (Baryonyx)otherAnimal;
/* 366 */     return (isInLove() && baryonyx.isInLove());
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespawn\entity\Baryonyx.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */