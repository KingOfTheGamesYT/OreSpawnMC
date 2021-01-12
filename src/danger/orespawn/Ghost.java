/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.passive.EntityAmbientCreature;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Ghost
/*     */   extends EntityAmbientCreature
/*     */ {
/*  22 */   private ChunkCoordinates currentFlightTarget = null;
/*     */ 
/*     */   
/*     */   public Ghost(World par1World) {
/*  26 */     super(par1World);
/*     */     
/*  28 */     setSize(0.5F, 1.5F);
/*  29 */     getNavigator().setAvoidsWater(false);
/*  30 */     this.experienceValue = 5;
/*  31 */     this.noClip = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  36 */     super.applyEntityAttributes();
/*  37 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  38 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612D);
/*  39 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  40 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  46 */     super.entityInit();
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  50 */     if (isNoDespawnRequired()) return false; 
/*  51 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  59 */     return 0.3F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  67 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/*  75 */     if (this.worldObj.rand.nextInt(2) == 0) {
/*  76 */       return "orespawn:ghost_sound";
/*     */     }
/*  78 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/*  94 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   protected void collideWithNearbyEntities() {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 111 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 119 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 127 */     if (isNoDespawnRequired()) this.noClip = false; 
/* 128 */     super.onUpdate();
/* 129 */     this.motionY *= 0.65D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 134 */     int i = 0, j = 0;
/*     */     
/* 136 */     if (this.isDead)
/* 137 */       return;  super.updateAITasks();
/*     */ 
/*     */     
/* 140 */     if (this.currentFlightTarget == null) {
/* 141 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/* 143 */     if (this.worldObj.rand.nextInt(40) == 1 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.0F) {
/*     */       
/* 145 */       EntityPlayer target = null;
/*     */       
/* 147 */       target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(16.0D, 16.0D, 16.0D), (Entity)this);
/* 148 */       if (target != null) {
/*     */         
/* 150 */         this.currentFlightTarget.set((int)target.posX + this.rand.nextInt(3) - this.rand.nextInt(3), (int)target.posY + 1, (int)target.posZ + this.rand.nextInt(3) - this.rand.nextInt(3));
/*     */       } else {
/* 152 */         for (i = 0; i < 3; i++) {
/* 153 */           Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY + i, (int)this.posZ);
/* 154 */           if (bid == Blocks.air)
/*     */             break; 
/*     */         } 
/* 157 */         for (j = -1; j >= -3; j--) {
/* 158 */           Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY + j, (int)this.posZ);
/* 159 */           if (bid != Blocks.air)
/*     */             break; 
/* 161 */         }  this.currentFlightTarget.set((int)this.posX + this.rand.nextInt(10) - this.rand.nextInt(10), (int)this.posY + i + j + this.rand.nextInt(4) + 1, (int)this.posZ + this.rand.nextInt(10) - this.rand.nextInt(10));
/*     */       } 
/*     */     } 
/*     */     
/* 165 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 166 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 167 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 168 */     this.motionX += (Math.signum(var1) * 0.1D - this.motionX) * 0.05D;
/* 169 */     this.motionY += (Math.signum(var3) * 0.7D - this.motionY) * 0.1D;
/* 170 */     this.motionZ += (Math.signum(var5) * 0.1D - this.motionZ) * 0.05D;
/* 171 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 172 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 173 */     this.moveForward = 0.05F;
/* 174 */     this.rotationYaw += var8 / 6.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 183 */     return false;
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
/*     */   
/*     */   protected void updateFallState(double par1, boolean par3) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 202 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 213 */     for (int k = -2; k < 2; k++) {
/*     */       
/* 215 */       for (int j = -2; j < 2; j++) {
/*     */         
/* 217 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 219 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 220 */           if (bid == Blocks.mob_spawner) {
/* 221 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 222 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 223 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 224 */             if (s != null && 
/* 225 */               s.equals("Ghost")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 232 */     if (this.worldObj.isDaytime()) return false; 
/* 233 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 243 */     boolean ret = false;
/*     */     
/* 245 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/* 246 */       return ret;
/*     */     }
/*     */     
/* 249 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 251 */     return ret;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Ghost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */