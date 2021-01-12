/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.passive.EntityAmbientCreature;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityMosquito
/*     */   extends EntityAmbientCreature
/*     */ {
/*  18 */   private ChunkCoordinates currentFlightTarget = null;
/*     */ 
/*     */   
/*     */   public EntityMosquito(World par1World) {
/*  22 */     super(par1World);
/*     */     
/*  24 */     setSize(0.2F, 0.2F);
/*  25 */     getNavigator().setAvoidsWater(true);
/*  26 */     this.experienceValue = 5;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  31 */     super.applyEntityAttributes();
/*  32 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  33 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612D);
/*  34 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  35 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  41 */     super.entityInit();
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  45 */     if (isNoDespawnRequired()) return false; 
/*  46 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  54 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  62 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/*  70 */     return "orespawn:mosquito";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/*  78 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/*  94 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   protected void collideWithNearbyEntities() {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 103 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 119 */     super.onUpdate();
/* 120 */     this.motionY *= 0.6000000238418579D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 128 */     int keep_trying = 50;
/* 129 */     if (this.isDead)
/* 130 */       return;  super.updateAITasks();
/*     */ 
/*     */     
/* 133 */     if (this.currentFlightTarget == null) {
/* 134 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/* 136 */     if (this.rand.nextInt(20) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 3.0F) {
/*     */       
/* 138 */       EntityPlayer target = null;
/*     */       
/* 140 */       if (OreSpawnMain.OreSpawnRand.nextInt(4) == 0) {
/*     */         
/* 142 */         target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(10.0D, 6.0D, 10.0D), (Entity)this);
/* 143 */         if (target != null) {
/*     */           
/* 145 */           this.currentFlightTarget.set((int)target.posX, (int)target.posY + 2, (int)target.posZ);
/*     */         } else {
/* 147 */           Block bid = Blocks.stone;
/* 148 */           while (bid != Blocks.air && keep_trying != 0) {
/* 149 */             this.currentFlightTarget.set((int)this.posX + this.rand.nextInt(6) - this.rand.nextInt(6), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(6) - this.rand.nextInt(6));
/* 150 */             bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 151 */             keep_trying--;
/*     */           } 
/*     */         } 
/*     */       } else {
/* 155 */         Block bid = Blocks.stone;
/* 156 */         while (bid != Blocks.air && keep_trying != 0) {
/* 157 */           this.currentFlightTarget.set((int)this.posX + this.rand.nextInt(6) - this.rand.nextInt(6), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(6) - this.rand.nextInt(6));
/* 158 */           bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 159 */           keep_trying--;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 164 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 165 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 166 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 167 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.10000000149011612D;
/* 168 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
/* 169 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.10000000149011612D;
/* 170 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 171 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 172 */     this.moveForward = 0.3F;
/* 173 */     this.rotationYaw += var8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 182 */     return false;
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
/* 201 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 209 */     return true;
/*     */   }
/*     */   
/*     */   public void initCreature() {}
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EntityMosquito.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */