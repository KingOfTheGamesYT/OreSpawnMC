/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.client.C03PacketPlayer;
/*     */ import net.minecraft.network.play.client.C0CPacketInput;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Elevator
/*     */   extends EntityLiving
/*     */ {
/*     */   private int boatPosRotationIncrements;
/*     */   private double boatX;
/*     */   private double boatY;
/*     */   private double boatZ;
/*     */   private double boatYaw;
/*     */   private double boatPitch;
/*     */   private double velocityX;
/*     */   private double velocityY;
/*     */   private double velocityZ;
/*  72 */   private int damage_counter = 100;
/*  73 */   private int exploding = 0;
/*  74 */   private int color = 1;
/*  75 */   private int playing = 0;
/*     */ 
/*     */ 
/*     */   
/*  79 */   private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "Elevator1.png");
/*  80 */   private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "Elevator2.png");
/*  81 */   private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "Elevator3.png");
/*  82 */   private static final ResourceLocation texture4 = new ResourceLocation("orespawn", "Elevator4.png");
/*  83 */   private static final ResourceLocation texture5 = new ResourceLocation("orespawn", "Elevator5.png");
/*  84 */   private static final ResourceLocation texture6 = new ResourceLocation("orespawn", "Elevator6.png");
/*  85 */   private static final ResourceLocation texture7 = new ResourceLocation("orespawn", "Elevator7.png");
/*  86 */   private static final ResourceLocation texture8 = new ResourceLocation("orespawn", "Elevator8.png");
/*  87 */   private static final ResourceLocation texture9 = new ResourceLocation("orespawn", "Elevator9.png");
/*  88 */   private static final ResourceLocation texture10 = new ResourceLocation("orespawn", "Elevator10.png");
/*     */ 
/*     */   
/*     */   public Elevator(World par1World) {
/*  92 */     super(par1World);
/*  93 */     setSize(1.25F, 1.0F);
/*  94 */     this.riddenByEntity = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Elevator(World par1World, double par2, double par4, double par6) {
/*  99 */     this(par1World);
/* 100 */     setPosition(par2, par4 + this.yOffset, par6);
/* 101 */     this.motionX = 0.0D;
/* 102 */     this.motionY = 0.0D;
/* 103 */     this.motionZ = 0.0D;
/* 104 */     this.prevPosX = par2;
/* 105 */     this.prevPosY = par4;
/* 106 */     this.prevPosZ = par6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResourceLocation getTexture() {
/* 113 */     switch (getColor()) {
/*     */       case 1:
/* 115 */         return texture1;
/*     */       case 2:
/* 117 */         return texture2;
/*     */       case 3:
/* 119 */         return texture3;
/*     */       case 4:
/* 121 */         return texture4;
/*     */       case 5:
/* 123 */         return texture5;
/*     */       case 6:
/* 125 */         return texture6;
/*     */       case 7:
/* 127 */         return texture7;
/*     */       case 8:
/* 129 */         return texture8;
/*     */       case 9:
/* 131 */         return texture9;
/*     */       case 10:
/* 133 */         return texture10;
/*     */     } 
/* 135 */     return texture1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/* 141 */     super.applyEntityAttributes();
/* 142 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0D);
/* 143 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.3300000429153442D);
/* 144 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/* 145 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/* 149 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRiderSit() {
/* 157 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTrackingRange() {
/* 162 */     return 128;
/*     */   }
/*     */   
/*     */   public int getUpdateFrequency() {
/* 166 */     return 10;
/*     */   }
/*     */   
/*     */   public boolean sendsVelocityUpdates() {
/* 170 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFallState(double par1, boolean par3) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 184 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/* 189 */     super.entityInit();
/* 190 */     this.dataWatcher.addObject(22, new Integer(0));
/* 191 */     this.dataWatcher.addObject(23, new Integer(1));
/* 192 */     this.dataWatcher.addObject(24, new Float(0.0F));
/* 193 */     this.dataWatcher.addObject(20, new Integer(0));
/* 194 */     this.dataWatcher.addObject(21, new Integer(0));
/* 195 */     enablePersistence();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 220 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMountedYOffset() {
/* 228 */     return 0.5D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 236 */     boolean p = par1DamageSource.getEntity() instanceof EntityPlayer;
/* 237 */     if (this.riddenByEntity != null && !p)
/*     */     {
/* 239 */       return false;
/*     */     }
/*     */     
/* 242 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/* 243 */       return false;
/*     */     }
/*     */     
/* 246 */     if (!this.worldObj.isRemote && !this.isDead) {
/*     */       
/* 248 */       setForwardDirection(-getForwardDirection());
/* 249 */       setTimeSinceHit(10);
/* 250 */       setDamageTaken(getDamageTaken() + par2 * 10.0F);
/* 251 */       setBeenAttacked();
/* 252 */       boolean flag = (par1DamageSource.getEntity() instanceof EntityPlayer && ((EntityPlayer)par1DamageSource.getEntity()).capabilities.isCreativeMode);
/*     */       
/* 254 */       if (flag || getDamageTaken() > 40.0F) {
/*     */         
/* 256 */         if (this.riddenByEntity != null)
/*     */         {
/* 258 */           this.riddenByEntity.mountEntity((Entity)this);
/*     */         }
/*     */         
/* 261 */         if (!flag)
/*     */         {
/* 263 */           dropItem(OreSpawnMain.MyElevator, 1);
/*     */         }
/*     */         
/* 266 */         setDead();
/*     */       } 
/*     */       
/* 269 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 273 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void performHurtAnimation() {
/* 284 */     setForwardDirection(-getForwardDirection());
/* 285 */     setTimeSinceHit(10);
/* 286 */     setDamageTaken(getDamageTaken() * 11.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeCollidedWith() {
/* 294 */     return !this.isDead;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 305 */     if (this.riddenByEntity != null) {
/*     */       
/* 307 */       this.boatPosRotationIncrements = par9 + 8;
/*     */     }
/*     */     else {
/*     */       
/* 311 */       this.boatPosRotationIncrements = 6;
/*     */     } 
/*     */     
/* 314 */     this.boatX = par1;
/* 315 */     this.boatY = par3;
/* 316 */     this.boatZ = par5;
/* 317 */     this.boatYaw = par7;
/* 318 */     this.boatPitch = par8;
/* 319 */     this.motionX = this.velocityX;
/* 320 */     this.motionY = this.velocityY;
/* 321 */     this.motionZ = this.velocityZ;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setVelocity(double par1, double par3, double par5) {
/* 332 */     this.velocityX = this.motionX = par1;
/* 333 */     this.velocityY = this.motionY = par3;
/* 334 */     this.velocityZ = this.motionZ = par5;
/*     */   }
/*     */   
/*     */   public void onLivingpdate() {
/* 338 */     if (this.riddenByEntity == null) {
/* 339 */       onLivingUpdate();
/*     */     }
/* 341 */     setFire(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 350 */     List<Entity> list = null;
/* 351 */     double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*     */ 
/*     */     
/* 354 */     double d6 = (this.rand.nextFloat() * 2.0F - 1.0F);
/* 355 */     double d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 361 */     double obstruction_factor = 0.0D;
/*     */     
/* 363 */     double relative_g = 0.0D;
/*     */     
/* 365 */     double max_speed = 0.85D;
/* 366 */     double gh = 0.75D;
/*     */     
/* 368 */     int dist = 2;
/*     */ 
/*     */     
/* 371 */     if (this.isDead)
/* 372 */       return;  this.isAirBorne = true;
/*     */     
/* 374 */     if (getTimeSinceHit() > 0)
/*     */     {
/* 376 */       setTimeSinceHit(getTimeSinceHit() - 1);
/*     */     }
/*     */     
/* 379 */     if (getDamageTaken() > 0.0F)
/*     */     {
/* 381 */       setDamageTaken(getDamageTaken() - 1.0F);
/*     */     }
/*     */     
/* 384 */     this.prevPosX = this.posX;
/* 385 */     this.prevPosY = this.posY;
/* 386 */     this.prevPosZ = this.posZ;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 393 */     if (velocity > 0.15D && this.riddenByEntity != null) {
/*     */       
/* 395 */       double d4 = Math.cos(Math.toRadians((this.rotationYaw + 270.0F)));
/* 396 */       double d5 = Math.sin(Math.toRadians((this.rotationYaw + 270.0F)));
/*     */       
/* 398 */       Block bid = Blocks.air; int i;
/* 399 */       for (i = 1; i < 10; i++) {
/* 400 */         bid = this.worldObj.getBlock((int)this.posX, (int)this.posY - i, (int)this.posZ);
/* 401 */         if (bid != Blocks.air)
/*     */           break; 
/*     */       } 
/* 404 */       for (int j = 0; j < 1.0D + velocity * 10.0D; j++) {
/*     */         
/* 406 */         d6 = (this.rand.nextFloat() * 2.0F - 1.0F);
/* 407 */         d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7D;
/*     */         
/* 409 */         if (this.rand.nextBoolean()) {
/*     */           
/* 411 */           double d8 = this.posX - d4 * d6 * 0.8D + d5 * d7;
/* 412 */           double d9 = this.posZ - d5 * d6 * 0.8D - d4 * d7;
/* 413 */           if (this.rand.nextBoolean()) {
/* 414 */             this.worldObj.spawnParticle("smoke", d8, this.posY - 0.25D, d9, this.motionX, this.motionY, this.motionZ);
/*     */           } else {
/* 416 */             this.worldObj.spawnParticle("reddust", d8, this.posY - 0.25D, d9, this.motionX, this.motionY, this.motionZ);
/*     */           } 
/*     */         } else {
/*     */           
/* 420 */           double d8 = this.posX + d4 + d5 * d6 * 0.7D;
/* 421 */           double d9 = this.posZ + d5 - d4 * d6 * 0.7D;
/* 422 */           if (this.rand.nextBoolean()) {
/* 423 */             this.worldObj.spawnParticle("smoke", d8, this.posY - 0.225D, d9, this.motionX, this.motionY, this.motionZ);
/*     */           } else {
/* 425 */             this.worldObj.spawnParticle("reddust", d8, this.posY - 0.225D, d9, this.motionX, this.motionY, this.motionZ);
/*     */           } 
/* 427 */         }  if (bid == Blocks.water || bid == Blocks.flowing_water)
/*     */         {
/* 429 */           for (int k = 0; k < 5; k++) {
/* 430 */             this.worldObj.spawnParticle("splash", this.posX + this.rand.nextFloat(), this.posY - i + 1.25D, this.posZ + this.rand.nextFloat(), this.motionX / 2.0D, this.motionY + velocity, this.motionZ / 2.0D);
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 439 */     if (this.playing > 0) this.playing--; 
/* 440 */     if (this.riddenByEntity != null && this.playing == 0 && this.worldObj.rand.nextInt(80) == 1) {
/* 441 */       this.worldObj.playSoundAtEntity(this.riddenByEntity, "orespawn:hover", 0.45F, 1.0F);
/* 442 */       this.playing = 55;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 451 */     if (!this.worldObj.isRemote) {
/*     */       
/* 453 */       if (this.exploding > 0) this.exploding--; 
/* 454 */       if (this.exploding == 0 && velocity > 0.65D && this.worldObj.rand.nextInt(20000) == 1) {
/* 455 */         this.exploding = 45;
/* 456 */         this.playing = 50;
/*     */       } 
/* 458 */       setExploding(this.exploding);
/*     */     } else {
/* 460 */       this.exploding = getExploding();
/*     */     } 
/*     */     
/* 463 */     if (getExploding() > 0 && this.riddenByEntity != null) {
/*     */ 
/*     */       
/* 466 */       if (this.worldObj.rand.nextInt(10) == 1) {
/* 467 */         this.worldObj.playSoundAtEntity(this.riddenByEntity, "random.explode", 0.55F, 0.75F + this.worldObj.rand.nextFloat());
/*     */       }
/*     */       
/* 470 */       for (int i = 0; i < 15; i++) {
/* 471 */         this.worldObj.spawnParticle("explode", (int)(this.posX + ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 4.0F)), (int)(this.posY + ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 4.0F)), (int)(this.posZ + ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 4.0F)), this.motionX, 0.0D, this.motionZ);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 476 */         this.worldObj.spawnParticle("largeexplode", (int)(this.posX + ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0F)), (int)(this.posY + ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0F)), (int)(this.posZ + ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0F)), this.motionX, 0.0D, this.motionZ);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 481 */         this.worldObj.spawnParticle("smoke", (int)(this.posX + ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 5.0F)), (int)(this.posY + ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 5.0F)), (int)(this.posZ + ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 5.0F)), this.motionX, 0.0D, this.motionZ);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 486 */         this.worldObj.spawnParticle("largesmoke", (int)(this.posX + ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0F)), (int)(this.posY + ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0F)), (int)(this.posZ + ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0F)), this.motionX, 0.0D, this.motionZ);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 498 */     if (this.worldObj.isRemote) {
/*     */ 
/*     */ 
/*     */       
/* 502 */       if (this.riddenByEntity == null) {
/* 503 */         Block bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh), (int)this.posZ);
/* 504 */         if (bid != Blocks.air) {
/* 505 */           this.motionY += 0.06D;
/* 506 */           this.posY += 0.07D;
/* 507 */           this.boatY += 0.07D;
/*     */         } else {
/* 509 */           this.motionY -= 0.003D;
/*     */         }
/*     */       
/* 512 */       } else if (this.riddenByEntity instanceof EntityClientPlayerMP) {
/* 513 */         EntityClientPlayerMP pp = (EntityClientPlayerMP)this.riddenByEntity;
/* 514 */         pp.sendQueue.addToSendQueue((Packet)new C03PacketPlayer.C05PacketPlayerLook(pp.rotationYaw, pp.rotationPitch, pp.onGround));
/* 515 */         pp.sendQueue.addToSendQueue((Packet)new C0CPacketInput(pp.moveStrafing, pp.moveForward, pp.movementInput.jump, pp.movementInput.sneak));
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 520 */       if (this.boatPosRotationIncrements > 0)
/*     */       {
/* 522 */         double d4 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
/* 523 */         double d5 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
/* 524 */         double d11 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
/* 525 */         setPosition(d4, d5, d11);
/*     */         
/* 527 */         this.rotationPitch = (float)(this.rotationPitch + (this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
/* 528 */         double d10 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
/* 529 */         if (this.riddenByEntity != null) d10 = MathHelper.wrapAngleTo180_double(this.riddenByEntity.rotationYaw - this.rotationYaw); 
/* 530 */         this.rotationYaw = (float)(this.rotationYaw + d10 / this.boatPosRotationIncrements);
/* 531 */         setRotation(this.rotationYaw, this.rotationPitch);
/*     */         
/* 533 */         this.boatPosRotationIncrements--;
/*     */ 
/*     */       
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */         
/* 541 */         double d4 = this.posX + this.motionX;
/* 542 */         double d5 = this.posY + this.motionY;
/* 543 */         double d11 = this.posZ + this.motionZ;
/* 544 */         setPosition(d4, d5, d11);
/*     */ 
/*     */ 
/*     */         
/* 548 */         this.motionX *= 0.99D;
/* 549 */         this.motionY *= 0.95D;
/* 550 */         this.motionZ *= 0.99D;
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 565 */       if (this.riddenByEntity != null) {
/* 566 */         gh = 1.25D;
/*     */       }
/* 568 */       Block bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh), (int)this.posZ);
/* 569 */       if (bid != Blocks.air) {
/* 570 */         this.motionY += 0.06D;
/* 571 */         this.posY += 0.1D;
/*     */         
/* 573 */         if (bid == Blocks.tallgrass && this.riddenByEntity != null && this.worldObj.rand.nextInt(200) == 1 && 
/* 574 */           this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock((int)this.posX, (int)(this.posY - gh), (int)this.posZ, Blocks.air);
/*     */         
/* 576 */         if (bid == Blocks.grass && this.riddenByEntity != null && this.worldObj.rand.nextInt(200) == 1 && 
/* 577 */           this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock((int)this.posX, (int)(this.posY - gh), (int)this.posZ, Blocks.dirt);
/*     */       
/*     */       } else {
/* 580 */         this.motionY -= 0.01D;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 586 */       if (this.riddenByEntity != null) {
/* 587 */         EntityPlayer pp = (EntityPlayer)this.riddenByEntity;
/*     */         
/* 589 */         obstruction_factor = 0.0D;
/* 590 */         dist = 3;
/* 591 */         dist += (int)(velocity * 8.0D);
/*     */         
/* 593 */         for (int k = 1; k < dist; k++) {
/* 594 */           for (int i = 1; i < dist * 2; i++) {
/* 595 */             double dx = i * Math.cos(Math.toRadians((this.rotationYaw + 90.0F)));
/* 596 */             double dz = i * Math.sin(Math.toRadians((this.rotationYaw + 90.0F)));
/* 597 */             bid = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - k, (int)(this.posZ + dz));
/* 598 */             if (bid != Blocks.air) {
/* 599 */               obstruction_factor += 0.05D;
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 606 */         this.motionY += obstruction_factor * 0.11D;
/* 607 */         this.posY += obstruction_factor * 0.11D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 617 */         double d4 = this.riddenByEntity.rotationYaw;
/* 618 */         d4 %= 360.0D;
/* 619 */         for (; d4 < 0.0D; d4 += 360.0D);
/* 620 */         double d5 = this.rotationYaw;
/* 621 */         d5 %= 360.0D;
/* 622 */         for (; d5 < 0.0D; d5 += 360.0D);
/* 623 */         relative_g = (d4 - d5) % 180.0D;
/* 624 */         for (; relative_g < 0.0D; relative_g += 180.0D);
/* 625 */         if (relative_g > 90.0D) relative_g -= 180.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 632 */         if (velocity > 0.01D) {
/*     */           
/* 634 */           d4 = 1.85D - velocity;
/* 635 */           d4 = Math.abs(d4);
/* 636 */           if (d4 < 0.01D) d4 = 0.01D; 
/* 637 */           if (d4 > 0.9D) d4 = 0.9D; 
/* 638 */           this.rotationYaw = this.riddenByEntity.rotationYaw + (float)(relative_g * d4);
/*     */         } else {
/*     */           
/* 641 */           this.rotationYaw = this.riddenByEntity.rotationYaw;
/*     */         } 
/* 643 */         relative_g = Math.abs(relative_g) * velocity;
/* 644 */         if (relative_g > 50.0D) relative_g = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 649 */         this.rotationPitch = 10.0F * (float)velocity;
/* 650 */         setRotation(this.rotationYaw, this.rotationPitch);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 656 */         double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 657 */         if (this.exploding != 0) {
/* 658 */           newvelocity -= 0.05D;
/* 659 */           if (newvelocity < 0.0D) newvelocity = 0.0D;
/*     */         
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 668 */         double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
/* 669 */         double rhm = Math.atan2(this.motionZ, this.motionX);
/* 670 */         double rhdir = Math.toRadians(((this.riddenByEntity.rotationYaw + 90.0F) % 360.0F));
/* 671 */         double rt = 0.0D;
/*     */         
/* 673 */         double pi = 3.1415926545D;
/* 674 */         double deltav = 0.0D;
/* 675 */         float im = pp.moveForward;
/*     */         
/* 677 */         if (OreSpawnMain.flyup_keystate != 0) max_speed++;
/*     */ 
/*     */         
/* 680 */         double rdv = Math.abs(rhm - rhdir) % pi * 2.0D;
/* 681 */         if (rdv > pi) rdv -= pi * 2.0D; 
/* 682 */         rdv = Math.abs(rdv);
/* 683 */         if (Math.abs(newvelocity) < 0.01D) rdv = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 691 */         if (rdv > 1.5D) newvelocity = -newvelocity;
/*     */         
/* 693 */         if (Math.abs(im) > 0.001F) {
/* 694 */           if (im > 0.0F) {
/* 695 */             deltav = 0.025D;
/* 696 */             if (max_speed > 1.0D) deltav += 0.15D;
/*     */           
/*     */           } else {
/* 699 */             max_speed = 0.35D;
/*     */             
/* 701 */             deltav = -0.02D;
/*     */           } 
/*     */           
/* 704 */           newvelocity += deltav;
/* 705 */           if (newvelocity >= 0.0D) {
/* 706 */             if (newvelocity > max_speed) newvelocity = max_speed; 
/* 707 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 708 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*     */           } else {
/* 710 */             if (newvelocity < -max_speed) newvelocity = -max_speed; 
/* 711 */             newvelocity = -newvelocity;
/* 712 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/* 713 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/*     */           }
/*     */         
/*     */         }
/* 717 */         else if (newvelocity >= 0.0D) {
/* 718 */           this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 719 */           this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*     */         } else {
/* 721 */           this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/* 722 */           this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/*     */         }
/*     */       
/*     */       }
/* 726 */       else if (this.riddenByEntity == null) {
/* 727 */         this.motionX = 0.0D;
/* 728 */         this.motionZ = 0.0D;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 734 */       moveEntity(this.motionX, this.motionY, this.motionZ);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 741 */       if (this.isCollidedHorizontally && velocity > 0.75D) {
/*     */ 
/*     */ 
/*     */         
/* 745 */         setDead();
/* 746 */         int p = this.worldObj.rand.nextInt(10); int k;
/* 747 */         for (k = 0; k < 6 + p; k++) {
/* 748 */           dropItem(Items.stick, 1);
/*     */         }
/* 750 */         for (k = 0; k < 2; k++) {
/* 751 */           dropItem(Items.diamond, 1);
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 756 */         this.motionX *= 0.98D;
/* 757 */         this.motionY *= 0.94D;
/* 758 */         this.motionZ *= 0.98D;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 766 */       list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(0.25D, 0.0D, 0.25D));
/*     */       
/* 768 */       if (list != null && !list.isEmpty())
/*     */       {
/* 770 */         for (int l = 0; l < list.size(); l++) {
/*     */           
/* 772 */           Entity entity = list.get(l);
/*     */           
/* 774 */           if (entity != this.riddenByEntity && entity.canBePushed() && !(entity instanceof Girlfriend) && !(entity instanceof Boyfriend))
/*     */           {
/* 776 */             entity.applyEntityCollision((Entity)this);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 781 */       if (this.riddenByEntity != null && this.riddenByEntity.isDead)
/*     */       {
/* 783 */         this.riddenByEntity = null;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRiderPosition() {
/* 790 */     if (this.riddenByEntity != null)
/*     */     {
/*     */       
/* 793 */       this.riddenByEntity.setPosition(this.posX, this.posY + getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 799 */     par1NBTTagCompound.setInteger("HoverColor", getColor());
/*     */   }
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 804 */     this.color = par1NBTTagCompound.getInteger("HoverColor");
/* 805 */     if (this.color < 1) this.color = 1; 
/* 806 */     if (this.color > 10) this.color = 10; 
/* 807 */     setColor(this.color);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getShadowSize() {
/* 813 */     return 0.25F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 821 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*     */     
/* 823 */     if (var2 != null && 
/* 824 */       var2.stackSize <= 0) {
/* 825 */       par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 826 */       var2 = null;
/*     */     } 
/*     */ 
/*     */     
/* 830 */     if (var2 != null && var2.getItem() == OreSpawnMain.MyUltimateSword && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/* 831 */       if (!this.worldObj.isRemote) {
/* 832 */         this.color++;
/* 833 */         if (this.color > 10) this.color = 1; 
/* 834 */         setColor(this.color);
/*     */       } 
/* 836 */       return true;
/*     */     } 
/*     */     
/* 839 */     if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != par1EntityPlayer)
/*     */     {
/* 841 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 845 */     if (!this.worldObj.isRemote)
/*     */     {
/* 847 */       par1EntityPlayer.mountEntity((Entity)this);
/*     */     }
/* 849 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDamageTaken(float f) {
/* 858 */     this.dataWatcher.updateObject(24, Float.valueOf(f));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getDamageTaken() {
/* 866 */     return this.dataWatcher.getWatchableObjectFloat(24);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimeSinceHit(int par1) {
/* 874 */     this.dataWatcher.updateObject(22, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTimeSinceHit() {
/* 882 */     return this.dataWatcher.getWatchableObjectInt(22);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForwardDirection(int par1) {
/* 890 */     this.dataWatcher.updateObject(23, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getForwardDirection() {
/* 898 */     return this.dataWatcher.getWatchableObjectInt(23);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setExploding(int par1) {
/* 903 */     this.dataWatcher.updateObject(20, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getExploding() {
/* 909 */     return this.dataWatcher.getWatchableObjectInt(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColor(int par1) {
/* 914 */     this.dataWatcher.updateObject(21, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColor() {
/* 920 */     return this.dataWatcher.getWatchableObjectInt(21);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Elevator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */