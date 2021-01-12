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
/*     */ public class GhostSkelly
/*     */   extends EntityAmbientCreature
/*     */ {
/*  22 */   private ChunkCoordinates currentFlightTarget = null;
/*  23 */   private RenderInfo renderdata = new RenderInfo();
/*     */   
/*     */   public GhostSkelly(World par1World) {
/*  26 */     super(par1World);
/*     */     
/*  28 */     setSize(1.5F, 2.0F);
/*  29 */     getNavigator().setAvoidsWater(false);
/*  30 */     this.experienceValue = 10;
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
/*  47 */     if (this.renderdata == null) {
/*  48 */       this.renderdata = new RenderInfo();
/*     */     }
/*  50 */     this.renderdata.rf1 = 0.0F;
/*  51 */     this.renderdata.rf2 = 0.0F;
/*  52 */     this.renderdata.rf3 = 0.0F;
/*  53 */     this.renderdata.rf4 = 0.0F;
/*  54 */     this.renderdata.ri1 = 0;
/*  55 */     this.renderdata.ri2 = 0;
/*  56 */     this.renderdata.ri3 = 0;
/*  57 */     this.renderdata.ri4 = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderInfo getRenderInfo() {
/*  64 */     return this.renderdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRenderInfo(RenderInfo r) {
/*  69 */     this.renderdata.rf1 = r.rf1;
/*  70 */     this.renderdata.rf2 = r.rf2;
/*  71 */     this.renderdata.rf3 = r.rf3;
/*  72 */     this.renderdata.rf4 = r.rf4;
/*  73 */     this.renderdata.ri1 = r.ri1;
/*  74 */     this.renderdata.ri2 = r.ri2;
/*  75 */     this.renderdata.ri3 = r.ri3;
/*  76 */     this.renderdata.ri4 = r.ri4;
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  80 */     if (isNoDespawnRequired()) return false; 
/*  81 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  89 */     return 0.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  97 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 105 */     if (this.worldObj.rand.nextInt(2) == 0) {
/* 106 */       return "orespawn:chain_rattles";
/*     */     }
/* 108 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 116 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 124 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 132 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   protected void collideWithNearbyEntities() {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 141 */     return 5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 149 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 157 */     if (isNoDespawnRequired()) this.noClip = false; 
/* 158 */     super.onUpdate();
/* 159 */     this.motionY *= 0.65D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 164 */     Block bid = Blocks.air;
/* 165 */     int i = 0, j = 0;
/* 166 */     if (this.isDead)
/* 167 */       return;  super.updateAITasks();
/*     */ 
/*     */     
/* 170 */     if (this.currentFlightTarget == null) {
/* 171 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/* 173 */     if (this.worldObj.rand.nextInt(40) == 1 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.0F) {
/*     */       
/* 175 */       EntityPlayer target = null;
/*     */       
/* 177 */       target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(16.0D, 16.0D, 16.0D), (Entity)this);
/* 178 */       if (target != null) {
/*     */         
/* 180 */         this.currentFlightTarget.set((int)target.posX + this.rand.nextInt(3) - this.rand.nextInt(3), (int)(target.posY + 1.0D), (int)target.posZ + this.rand.nextInt(3) - this.rand.nextInt(3));
/*     */       } else {
/*     */         
/* 183 */         for (i = 0; i < 3; i++) {
/* 184 */           bid = this.worldObj.getBlock((int)this.posX, (int)this.posY + i, (int)this.posZ);
/* 185 */           if (bid == Blocks.air)
/*     */             break; 
/*     */         } 
/* 188 */         for (j = -1; j >= -3; j--) {
/* 189 */           bid = this.worldObj.getBlock((int)this.posX, (int)this.posY + j, (int)this.posZ);
/* 190 */           if (bid != Blocks.air)
/*     */             break; 
/* 192 */         }  this.currentFlightTarget.set((int)this.posX + this.rand.nextInt(10) - this.rand.nextInt(10), (int)this.posY + i + j + this.rand.nextInt(4) + 1, (int)this.posZ + this.rand.nextInt(10) - this.rand.nextInt(10));
/*     */       } 
/*     */     } 
/*     */     
/* 196 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 197 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 198 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 199 */     this.motionX += (Math.signum(var1) * 0.1D - this.motionX) * 0.05D;
/* 200 */     this.motionY += (Math.signum(var3) * 0.7D - this.motionY) * 0.1D;
/* 201 */     this.motionZ += (Math.signum(var5) * 0.1D - this.motionZ) * 0.05D;
/* 202 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 203 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 204 */     this.moveForward = 0.05F;
/* 205 */     this.rotationYaw += var8 / 6.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 214 */     return false;
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
/* 233 */     return true;
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
/* 244 */     for (int k = -2; k < 2; k++) {
/*     */       
/* 246 */       for (int j = -2; j < 2; j++) {
/*     */         
/* 248 */         for (int i = 0; i < 5; i++) {
/*     */           
/* 250 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 251 */           if (bid == Blocks.mob_spawner) {
/* 252 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 253 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 254 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 255 */             if (s != null && 
/* 256 */               s.equals("Ghost Pumpkin Skelly")) return true;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 262 */     if (this.worldObj.isDaytime()) return false; 
/* 263 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 273 */     boolean ret = false;
/*     */     
/* 275 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/* 276 */       return ret;
/*     */     }
/*     */     
/* 279 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 281 */     return ret;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\GhostSkelly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */