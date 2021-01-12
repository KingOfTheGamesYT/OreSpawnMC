/*     */ package danger.orespawn;
/*     */ 
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
/*     */ public class Baryonyx
/*     */   extends EntityAnimal
/*     */ {
/*  46 */   private float moveSpeed = 0.25F;
/*     */   private int closest;
/*     */   private int tx;
/*     */   private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage); getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D); } protected void entityInit() { super.entityInit(); } public boolean getCanSpawnHere() { if (this.posY < 50.0D) return false;  if (!this.worldObj.isDaytime()) return false;  if (findBuddies() > 8)
/*  50 */       return false;  return true; } public Baryonyx(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 179 */     this.closest = 99999;
/* 180 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(1.5F, 2.8F); this.moveSpeed = 0.25F; this.fireResistance = 100; this.experienceValue = 5; getNavigator().setAvoidsWater(true); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate(this, 1.0D)); this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 8.0F, 1.0D, 1.399999976158142D)); this.tasks.addTask(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 12.0F)); this.tasks.addTask(6, new MyEntityAIWander((EntityCreature)this, 1.0F)); this.tasks.addTask(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); }
/*     */   public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); super.onUpdate(); }
/*     */   public boolean isAIEnabled() { return true; }
/* 183 */   public boolean canBreatheUnderwater() { return false; } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 188 */     for (i = -dy; i <= dy; i++) {
/* 189 */       for (int j = -dz; j <= dz; j++) {
/* 190 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 191 */         if (bid == Blocks.grass) {
/* 192 */           int d = dx * dx + j * j + i * i;
/* 193 */           if (d < this.closest) {
/* 194 */             this.closest = d;
/* 195 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 196 */             found++;
/*     */           } 
/*     */         } 
/* 199 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 200 */         if (bid == Blocks.grass) {
/* 201 */           int d = dx * dx + j * j + i * i;
/* 202 */           if (d < this.closest) {
/* 203 */             this.closest = d;
/* 204 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 205 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 211 */     for (i = -dx; i <= dx; i++) {
/* 212 */       for (int j = -dz; j <= dz; j++) {
/* 213 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 214 */         if (bid == Blocks.grass) {
/* 215 */           int d = dy * dy + j * j + i * i;
/* 216 */           if (d < this.closest) {
/* 217 */             this.closest = d;
/* 218 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 219 */             found++;
/*     */           } 
/*     */         } 
/* 222 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 223 */         if (bid == Blocks.grass) {
/* 224 */           int d = dy * dy + j * j + i * i;
/* 225 */           if (d < this.closest) {
/* 226 */             this.closest = d;
/* 227 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 228 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 234 */     for (i = -dx; i <= dx; i++) {
/* 235 */       for (int j = -dy; j <= dy; j++) {
/* 236 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 237 */         if (bid == Blocks.grass) {
/* 238 */           int d = dz * dz + j * j + i * i;
/* 239 */           if (d < this.closest) {
/* 240 */             this.closest = d;
/* 241 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 242 */             found++;
/*     */           } 
/*     */         } 
/* 245 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 246 */         if (bid == Blocks.grass) {
/* 247 */           int d = dz * dz + j * j + i * i;
/* 248 */           if (d < this.closest) {
/* 249 */             this.closest = d;
/* 250 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 251 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 257 */     if (found != 0) return true; 
/* 258 */     return false; } public int mygetMaxHealth() { return 40; }
/*     */   protected String getLivingSound() { return null; }
/*     */   protected String getHurtSound() { return "orespawn:duck_hurt"; }
/*     */   protected String getDeathSound() { return "orespawn:duck_hurt"; }
/*     */   protected float getSoundVolume() { return 0.4F; }
/*     */   protected Item getDropItem() { return Items.beef; }
/*     */   protected void dropFewItems(boolean par1, int par2) { int var3 = 0;
/*     */     var3 = this.rand.nextInt(5);
/*     */     var3 += 2;
/*     */     for (int var4 = 0; var4 < var3; var4++)
/*     */       dropItem(Items.beef, 1);  }
/* 269 */   protected void updateAITick() { if (this.isDead)
/* 270 */       return;  super.updateAITick();
/* 271 */     if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null);
/*     */     
/* 273 */     if (this.worldObj.rand.nextInt(60) == 0 && OreSpawnMain.PlayNicely == 0) {
/*     */ 
/*     */ 
/*     */       
/* 277 */       this.closest = 99999;
/* 278 */       this.tx = this.ty = this.tz = 0;
/* 279 */       for (int i = 1; i < 11; i++) {
/* 280 */         int j = i;
/* 281 */         if (j > 2) j = 2; 
/* 282 */         if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i) == true)
/* 283 */           break;  if (i >= 6) i++;
/*     */       
/*     */       } 
/* 286 */       if (this.closest < 99999) {
/*     */         
/* 288 */         getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 289 */         if (this.closest < 12) {
/*     */           
/* 291 */           if (this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.dirt, 0, 2); 
/* 292 */           heal(1.0F);
/* 293 */           playSound("random.burp", 1.0F, this.worldObj.rand.nextFloat() * 0.2F + 0.9F);
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
/* 306 */     if (isChild()) {
/* 307 */       enablePersistence();
/* 308 */       return false;
/*     */     } 
/* 310 */     if (isNoDespawnRequired()) return false; 
/* 311 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 316 */     return (EntityAgeable)spawnBabyAnimal(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Baryonyx spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 322 */     return new Baryonyx(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 330 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.apple);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 339 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 344 */     List var5 = this.worldObj.getEntitiesWithinAABB(Baryonyx.class, this.boundingBox.expand(20.0D, 10.0D, 20.0D));
/* 345 */     return var5.size();
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Baryonyx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */