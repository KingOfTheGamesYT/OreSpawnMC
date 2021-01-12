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
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
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
/*     */ public class Cockateil
/*     */   extends EntityAnimal
/*     */ {
/*  50 */   private ChunkCoordinates currentFlightTarget = null;
/*     */   public int birdtype;
/*     */   private boolean killedByPlayer = false;
/*  53 */   private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "Bird1.png");
/*  54 */   private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "Bird2.png");
/*  55 */   private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "Bird3.png");
/*  56 */   private static final ResourceLocation texture4 = new ResourceLocation("orespawn", "Bird4.png");
/*  57 */   private static final ResourceLocation texture5 = new ResourceLocation("orespawn", "Bird5.png");
/*  58 */   private static final ResourceLocation texture6 = new ResourceLocation("orespawn", "Bird6.png");
/*  59 */   private int stuck_count = 0;
/*  60 */   private int lastX = 0;
/*  61 */   private int lastZ = 0;
/*  62 */   private int flyup = 0;
/*     */ 
/*     */   
/*     */   public Cockateil(World par1World) {
/*  66 */     super(par1World);
/*     */     
/*  68 */     setSize(0.5F, 0.5F);
/*  69 */     getNavigator().setAvoidsWater(true);
/*  70 */     this.experienceValue = 2;
/*  71 */     this.isImmuneToFire = false;
/*  72 */     this.fireResistance = 2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  77 */     super.applyEntityAttributes();
/*  78 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  79 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.33000001311302185D);
/*  80 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  81 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
/*     */   }
/*     */   
/*     */   public ResourceLocation getTexture() {
/*  85 */     this.birdtype = getBirdType();
/*  86 */     switch (this.birdtype) {
/*     */       case 0:
/*  88 */         return texture1;
/*     */       case 1:
/*  90 */         return texture2;
/*     */       case 2:
/*  92 */         return texture3;
/*     */       case 3:
/*  94 */         return texture4;
/*     */       case 4:
/*  96 */         return texture5;
/*     */       case 5:
/*  98 */         return texture6;
/*     */     } 
/* 100 */     return null;
/*     */   }
/*     */   
/*     */   protected void entityInit() {
/* 104 */     super.entityInit();
/* 105 */     this.birdtype = this.rand.nextInt(6);
/* 106 */     this.dataWatcher.addObject(22, Integer.valueOf(this.birdtype));
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 110 */     if (isNoDespawnRequired()) return false; 
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBirdType() {
/* 116 */     return this.dataWatcher.getWatchableObjectInt(22);
/*     */   }
/*     */   
/*     */   public void setBirdType(int par1) {
/* 120 */     this.dataWatcher.updateObject(22, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 128 */     return 0.55F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 135 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 142 */     if (this.worldObj.isDaytime() && !this.worldObj.isRaining()) {
/* 143 */       return "orespawn:birds";
/*     */     }
/* 145 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 153 */     return "orespawn:duck_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 160 */     return "orespawn:duck_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 167 */     return true;
/*     */   }
/*     */   
/*     */   public int mygetMaxHealth() {
/* 171 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 178 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 186 */     Entity e = par1DamageSource.getEntity();
/* 187 */     if (e != null && e instanceof net.minecraft.entity.player.EntityPlayer)
/*     */     {
/* 189 */       this.killedByPlayer = true;
/*     */     }
/* 191 */     return super.attackEntityFrom(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 198 */     super.onUpdate();
/* 199 */     if (this.currentFlightTarget == null) {
/* 200 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/* 202 */     else if (this.posY < this.currentFlightTarget.posY) {
/* 203 */       this.motionY *= 0.7D;
/*     */     } else {
/* 205 */       this.motionY *= 0.5D;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAttackStrength(Entity par1Entity) {
/* 212 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFlyUp() {
/* 217 */     this.flyup = 2;
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
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 236 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 242 */     int xdir = 1;
/* 243 */     int zdir = 1;
/*     */     
/* 245 */     int keep_trying = 35;
/*     */ 
/*     */     
/* 248 */     int stayup = 0;
/*     */ 
/*     */     
/* 251 */     if (this.isDead)
/* 252 */       return;  super.updateAITasks();
/*     */     
/* 254 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) stayup = 2;
/*     */     
/* 256 */     if (this.lastX == (int)this.posX && this.lastZ == (int)this.posZ) {
/*     */       
/* 258 */       this.stuck_count++;
/*     */     } else {
/* 260 */       this.stuck_count = 0;
/* 261 */       this.lastX = (int)this.posX;
/* 262 */       this.lastZ = (int)this.posZ;
/*     */     } 
/*     */ 
/*     */     
/* 266 */     if (this.currentFlightTarget == null) {
/* 267 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/*     */ 
/*     */     
/* 271 */     if (this.stuck_count > 40 || this.rand.nextInt(250) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 4.1F) {
/*     */       
/* 273 */       Block bid = Blocks.stone;
/* 274 */       this.stuck_count = 0;
/* 275 */       while (bid != Blocks.air && keep_trying != 0) {
/* 276 */         zdir = this.rand.nextInt(8) + 5 - this.flyup * 2;
/* 277 */         xdir = this.rand.nextInt(8) + 5 - this.flyup * 2;
/* 278 */         if (this.rand.nextInt(2) == 0) zdir = -zdir; 
/* 279 */         if (this.rand.nextInt(2) == 0) xdir = -xdir; 
/* 280 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.rand.nextInt(9 + stayup) - 5 + this.flyup, (int)this.posZ + zdir);
/* 281 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 282 */         if (bid == Blocks.air && 
/* 283 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 284 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 287 */         keep_trying--;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 292 */     double var1 = this.currentFlightTarget.posX + 0.3D - this.posX;
/* 293 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 294 */     double var5 = this.currentFlightTarget.posZ + 0.3D - this.posZ;
/* 295 */     this.motionX += (Math.signum(var1) * 0.3D - this.motionX) * 0.25D;
/* 296 */     this.motionY += (Math.signum(var3) * 0.699999D - this.motionY) * 0.200000001D;
/* 297 */     this.motionZ += (Math.signum(var5) * 0.3D - this.motionZ) * 0.25D;
/* 298 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 299 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 300 */     this.moveForward = 0.8F;
/* 301 */     this.rotationYaw += var8 / 3.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 310 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 318 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 326 */     if (!this.worldObj.isDaytime()) return false; 
/* 327 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) return true; 
/* 328 */     if (this.posY < 50.0D) return false; 
/* 329 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 337 */     this.birdtype = getBirdType();
/* 338 */     if (this.birdtype == 5 && this.killedByPlayer && this.worldObj.rand.nextInt(3) == 1) return OreSpawnMain.MyRuby; 
/* 339 */     return Items.feather;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable var1) {
/* 351 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 361 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 362 */     par1NBTTagCompound.setInteger("BirdType", getBirdType());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 370 */     super.readEntityFromNBT(par1NBTTagCompound);
/* 371 */     this.birdtype = par1NBTTagCompound.getInteger("BirdType");
/* 372 */     setBirdType(this.birdtype);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Cockateil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */