/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GoldFish
/*     */   extends EntityAnimal
/*     */ {
/*  50 */   private ChunkCoordinates currentFlightTarget = null;
/*     */ 
/*     */   
/*     */   public GoldFish(World par1World) {
/*  54 */     super(par1World);
/*  55 */     setSize(0.75F, 0.5F);
/*  56 */     this.experienceValue = 5;
/*  57 */     this.isImmuneToFire = false;
/*  58 */     this.fireResistance = 5;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  64 */     super.applyEntityAttributes();
/*  65 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  66 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2199999988079071D);
/*  67 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  68 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  72 */     if (isNoDespawnRequired()) return false; 
/*  73 */     if (this.worldObj.isDaytime()) return false; 
/*  74 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  81 */     return 0.45F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  88 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/*  95 */     return "splash";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 102 */     return "splash";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 109 */     return "orespawn:little_splat";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 123 */     return 6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 130 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 138 */     super.onUpdate();
/*     */     
/* 140 */     this.motionY *= 0.6D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 149 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 155 */     int xdir = 1;
/* 156 */     int zdir = 1;
/*     */     
/* 158 */     int keep_trying = 50;
/*     */ 
/*     */     
/* 161 */     int updown = 0;
/*     */     
/* 163 */     if (this.isDead)
/* 164 */       return;  super.updateAITasks();
/*     */     
/* 166 */     if (this.currentFlightTarget == null) {
/* 167 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */     
/* 170 */     if ((int)this.posY < 120) updown = 2; 
/* 171 */     if ((int)this.posY > 140) updown = -2; 
/* 172 */     if (this.rand.nextInt(300) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*     */       
/* 174 */       Block bid = Blocks.stone;
/* 175 */       while (bid != Blocks.air && keep_trying != 0) {
/* 176 */         zdir = this.rand.nextInt(5) + 5;
/* 177 */         xdir = this.rand.nextInt(5) + 5;
/* 178 */         if (this.rand.nextInt(2) == 0) zdir = -zdir; 
/* 179 */         if (this.rand.nextInt(2) == 0) xdir = -xdir; 
/* 180 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(11) - 5 + updown, (int)this.posZ + zdir);
/* 181 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 182 */         if (bid == Blocks.air && 
/* 183 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 184 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 187 */         keep_trying--;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 192 */     double var1 = this.currentFlightTarget.posX + 0.4D - this.posX;
/* 193 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 194 */     double var5 = this.currentFlightTarget.posZ + 0.4D - this.posZ;
/* 195 */     this.motionX += (Math.signum(var1) * 0.4D - this.motionX) * 0.3D;
/* 196 */     this.motionY += (Math.signum(var3) * 0.7D - this.motionY) * 0.2D;
/* 197 */     this.motionZ += (Math.signum(var5) * 0.4D - this.motionZ) * 0.3D;
/* 198 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 199 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 200 */     this.moveForward = 0.75F;
/* 201 */     this.rotationYaw += var8 / 6.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 210 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFallState(double par1, boolean par3) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 228 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 236 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 245 */     int i = this.worldObj.rand.nextInt(3);
/* 246 */     if (i == 0) return Item.getItemFromBlock(Blocks.gold_block); 
/* 247 */     if (i == 1) return OreSpawnMain.UraniumNugget; 
/* 248 */     if (i == 2) return OreSpawnMain.TitaniumNugget; 
/* 249 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable var1) {
/* 255 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBreatheUnderwater() {
/* 261 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\GoldFish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */