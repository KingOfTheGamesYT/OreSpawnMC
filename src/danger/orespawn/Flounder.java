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
/*     */ 
/*     */ public class Flounder
/*     */   extends EntityAnimal
/*     */ {
/*  46 */   private float moveSpeed = 0.25F;
/*     */   private int closest;
/*     */   private int tx;
/*     */   private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth()); getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed); getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage); getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D); } protected void entityInit() { super.entityInit(); } public void onUpdate() { getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  50 */     super.onUpdate(); } public Flounder(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     this.closest = 99999;
/* 164 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.55F, 0.25F); this.moveSpeed = 0.25F; this.fireResistance = 15; this.experienceValue = 5; getNavigator().setAvoidsWater(false); this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.tasks.addTask(1, (EntityAIBase)new EntityAIMate(this, 1.0D)); this.tasks.addTask(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 8.0F, 1.0D, 1.399999976158142D)); this.tasks.addTask(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D)); this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 12.0F)); this.tasks.addTask(6, new MyEntityAIWander((EntityCreature)this, 1.0F)); this.tasks.addTask(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); }
/*     */   public boolean isAIEnabled() { return true; }
/*     */   public boolean canBreatheUnderwater() { return true; }
/* 167 */   public int mygetMaxHealth() { return 5; } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 172 */     for (i = -dy; i <= dy; i++) {
/* 173 */       for (int j = -dz; j <= dz; j++) {
/* 174 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 175 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 176 */           int d = dx * dx + j * j + i * i;
/* 177 */           if (d < this.closest) {
/* 178 */             this.closest = d;
/* 179 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 180 */             found++;
/*     */           } 
/*     */         } 
/* 183 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 184 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 185 */           int d = dx * dx + j * j + i * i;
/* 186 */           if (d < this.closest) {
/* 187 */             this.closest = d;
/* 188 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 189 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 195 */     for (i = -dx; i <= dx; i++) {
/* 196 */       for (int j = -dz; j <= dz; j++) {
/* 197 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 198 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 199 */           int d = dy * dy + j * j + i * i;
/* 200 */           if (d < this.closest) {
/* 201 */             this.closest = d;
/* 202 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 203 */             found++;
/*     */           } 
/*     */         } 
/* 206 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 207 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 208 */           int d = dy * dy + j * j + i * i;
/* 209 */           if (d < this.closest) {
/* 210 */             this.closest = d;
/* 211 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 212 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 218 */     for (i = -dx; i <= dx; i++) {
/* 219 */       for (int j = -dy; j <= dy; j++) {
/* 220 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 221 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 222 */           int d = dz * dz + j * j + i * i;
/* 223 */           if (d < this.closest) {
/* 224 */             this.closest = d;
/* 225 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 226 */             found++;
/*     */           } 
/*     */         } 
/* 229 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 230 */         if (bid == Blocks.water || bid == Blocks.flowing_water) {
/* 231 */           int d = dz * dz + j * j + i * i;
/* 232 */           if (d < this.closest) {
/* 233 */             this.closest = d;
/* 234 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 235 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 241 */     if (found != 0) return true; 
/* 242 */     return false; } protected String getLivingSound() { return "splash"; }
/*     */   protected String getHurtSound() { return "little_splat"; }
/*     */   protected String getDeathSound() { return "orespawn:ratdead"; }
/*     */   protected float getSoundVolume() { return 0.4F; }
/*     */   protected Item getDropItem() { return Items.fish; }
/*     */   protected void dropFewItems(boolean par1, int par2) { int var3 = 0;
/*     */     var3 = this.rand.nextInt(2);
/*     */     var3++;
/*     */     for (int var4 = 0; var4 < var3; var4++)
/*     */       dropItem(Items.fish, 1);  }
/* 252 */   protected void updateAITick() { super.updateAITick();
/* 253 */     if (this.isDead)
/* 254 */       return;  if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null);
/*     */ 
/*     */     
/* 257 */     if (!isInWater() && this.worldObj.rand.nextInt(20) == 0) {
/*     */ 
/*     */ 
/*     */       
/* 261 */       this.closest = 99999;
/* 262 */       this.tx = this.ty = this.tz = 0;
/* 263 */       for (int i = 1; i < 11; i++) {
/* 264 */         int j = i;
/* 265 */         if (j > 4) j = 4; 
/* 266 */         if (scan_it((int)this.posX, (int)this.posY - 1, (int)this.posZ, i, j, i) == true)
/* 267 */           break;  if (i >= 5) i++;
/*     */       
/*     */       } 
/* 270 */       if (this.closest < 99999) {
/* 271 */         getNavigator().tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.0D);
/*     */       } else {
/* 273 */         if (this.worldObj.rand.nextInt(25) == 1)
/* 274 */           heal(-1.0F); 
/* 275 */         if (getHealth() <= 0.0F) {
/* 276 */           setDead();
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/* 281 */     if (isInWater() && this.worldObj.rand.nextInt(50) == 0) {
/* 282 */       playSound("splash", 1.0F, this.worldObj.rand.nextFloat() * 0.2F + 0.9F);
/* 283 */       heal(1.0F);
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 290 */     List var5 = this.worldObj.getEntitiesWithinAABB(Flounder.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D));
/* 291 */     return var5.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 299 */     if (this.posY < 50.0D) return false; 
/* 300 */     if (!this.worldObj.isDaytime()) return false; 
/* 301 */     if (this.worldObj.rand.nextInt(20) != 1) return false; 
/* 302 */     if (findBuddies() > 10) return false; 
/* 303 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 311 */     if (isChild()) {
/* 312 */       enablePersistence();
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
/*     */   public Flounder spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
/* 327 */     return new Flounder(this.worldObj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWheat(ItemStack par1ItemStack) {
/* 335 */     return (par1ItemStack != null && par1ItemStack.getItem() == Items.fish);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBreedingItem(ItemStack par1ItemStack) {
/* 344 */     return (par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Flounder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */