/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
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
/*     */ public class CliffRacer
/*     */   extends EntityAnimal
/*     */ {
/*  51 */   private ChunkCoordinates currentFlightTarget = null;
/*     */ 
/*     */   
/*     */   public CliffRacer(World par1World) {
/*  55 */     super(par1World);
/*  56 */     setSize(0.75F, 0.5F);
/*  57 */     getNavigator().setAvoidsWater(false);
/*  58 */     this.experienceValue = 5;
/*  59 */     this.isImmuneToFire = false;
/*  60 */     this.fireResistance = 5;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  66 */     super.applyEntityAttributes();
/*  67 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  68 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.33000001311302185D);
/*  69 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  70 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  74 */     if (isNoDespawnRequired()) return false; 
/*  75 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  82 */     return 0.45F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  89 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/*  96 */     return "orespawn:cliffracer";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 103 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 110 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 117 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 124 */     return 5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 131 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 139 */     super.onUpdate();
/*     */     
/* 141 */     this.motionY *= 0.6D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 150 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 156 */     int xdir = 1;
/* 157 */     int zdir = 1;
/*     */     
/* 159 */     int keep_trying = 50;
/*     */ 
/*     */ 
/*     */     
/* 163 */     if (this.isDead)
/* 164 */       return;  super.updateAITasks();
/*     */     
/* 166 */     if (this.currentFlightTarget == null) {
/* 167 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */ 
/*     */     
/* 171 */     if (this.rand.nextInt(300) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.1F) {
/*     */       
/* 173 */       Block bid = Blocks.stone;
/* 174 */       while (bid != Blocks.air && keep_trying != 0) {
/* 175 */         zdir = this.rand.nextInt(10) + 5;
/* 176 */         xdir = this.rand.nextInt(10) + 5;
/* 177 */         if (this.rand.nextInt(2) == 0) zdir = -zdir; 
/* 178 */         if (this.rand.nextInt(2) == 0) xdir = -xdir; 
/* 179 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(11) - 5, (int)this.posZ + zdir);
/* 180 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 181 */         if (bid == Blocks.air && 
/* 182 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 183 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 186 */         keep_trying--;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 191 */     double var1 = this.currentFlightTarget.posX + 0.4D - this.posX;
/* 192 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 193 */     double var5 = this.currentFlightTarget.posZ + 0.4D - this.posZ;
/* 194 */     this.motionX += (Math.signum(var1) * 0.4D - this.motionX) * 0.3D;
/* 195 */     this.motionY += (Math.signum(var3) * 0.7D - this.motionY) * 0.2D;
/* 196 */     this.motionZ += (Math.signum(var5) * 0.4D - this.motionZ) * 0.3D;
/* 197 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 198 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 199 */     this.moveForward = 0.75F;
/* 200 */     this.rotationYaw += var8 / 6.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 209 */     return true;
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
/* 227 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 235 */     if (this.posY < 50.0D) return false; 
/* 236 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 245 */     int i = this.worldObj.rand.nextInt(8);
/* 246 */     if (i == 0) return Items.chicken; 
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
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CliffRacer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */