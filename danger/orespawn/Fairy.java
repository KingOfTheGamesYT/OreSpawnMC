/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.passive.EntityAmbientCreature;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Fairy
/*     */   extends EntityAmbientCreature
/*     */ {
/*  36 */   private static final ResourceLocation texture0 = new ResourceLocation("orespawn", "fairytexture.png");
/*  37 */   private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "fairytexture2.png");
/*  38 */   private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "fairytexture3.png");
/*  39 */   private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "fairytexture4.png");
/*  40 */   private static final ResourceLocation texture4 = new ResourceLocation("orespawn", "fairytexture5.png");
/*  41 */   private static final ResourceLocation texture5 = new ResourceLocation("orespawn", "fairytexture6.png");
/*  42 */   private static final ResourceLocation texture6 = new ResourceLocation("orespawn", "fairytexture7.png");
/*  43 */   private static final ResourceLocation texture7 = new ResourceLocation("orespawn", "fairytexture8.png");
/*  44 */   private static final ResourceLocation texture8 = new ResourceLocation("orespawn", "fairytexture9.png");
/*     */   
/*  46 */   int my_blink = 0;
/*  47 */   int blinker = 0;
/*  48 */   int myspace = 0;
/*  49 */   public int fairy_type = 0;
/*  50 */   private int force_sync = 10;
/*  51 */   private ChunkCoordinates currentFlightTarget = null;
/*  52 */   private String myowner = null;
/*  53 */   private GenericTargetSorter TargetSorter = null;
/*     */   
/*     */   public Fairy(World par1World) {
/*  56 */     super(par1World);
/*  57 */     this.my_blink = 20 + this.rand.nextInt(20);
/*  58 */     setSize(0.4F, 0.8F);
/*  59 */     if (par1World != null) this.fairy_type = par1World.rand.nextInt(9); 
/*  60 */     getNavigator().setAvoidsWater(true);
/*  61 */     this.renderDistanceWeight = 3.0D;
/*  62 */     this.tasks.addTask(0, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 8.0F));
/*  63 */     this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  64 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  69 */     super.applyEntityAttributes();
/*  70 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  71 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612D);
/*  72 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  73 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
/*     */   }
/*     */   
/*     */   public ResourceLocation getTexture(Fairy a) {
/*  77 */     if (this.fairy_type == 8) return texture8; 
/*  78 */     if (this.fairy_type == 7) return texture7; 
/*  79 */     if (this.fairy_type == 6) return texture6; 
/*  80 */     if (this.fairy_type == 5) return texture5; 
/*  81 */     if (this.fairy_type == 4) return texture4; 
/*  82 */     if (this.fairy_type == 3) return texture3; 
/*  83 */     if (this.fairy_type == 2) return texture2; 
/*  84 */     if (this.fairy_type == 1) return texture1; 
/*  85 */     return texture0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  90 */     super.entityInit();
/*  91 */     this.dataWatcher.addObject(20, Integer.valueOf(this.fairy_type));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOwner(EntityLivingBase e) {
/*  96 */     EntityPlayer p = null;
/*  97 */     if (e != null && 
/*  98 */       e instanceof EntityPlayer) {
/*  99 */       p = (EntityPlayer)e;
/* 100 */       String s = p.getDisplayName();
/* 101 */       if (s != null) {
/* 102 */         this.myowner = s;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getBlink() {
/* 110 */     if (this.blinker < this.my_blink / 2) return 240.0F; 
/* 111 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 118 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false; 
/* 119 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 2.0F);
/* 120 */     return var4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 128 */     return 4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 136 */     return 0.25F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 144 */     return 1.7F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 152 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 160 */     return "orespawn:rat_hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 168 */     return "orespawn:big_splat";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 176 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   protected void collideWithNearbyEntities() {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 185 */     return 40;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 190 */     return Item.getItemFromBlock(OreSpawnMain.CrystalTorch);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 198 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 207 */     super.onUpdate();
/* 208 */     this.motionY *= 0.600000023841D;
/* 209 */     this.blinker++;
/* 210 */     if (this.blinker > this.my_blink) this.blinker = 0; 
/* 211 */     this.force_sync--;
/* 212 */     if (this.force_sync < 0) {
/* 213 */       this.force_sync = 10;
/* 214 */       if (this.worldObj.isRemote) {
/* 215 */         this.fairy_type = this.dataWatcher.getWatchableObjectInt(20);
/*     */       } else {
/* 217 */         this.dataWatcher.updateObject(20, Integer.valueOf(this.fairy_type));
/*     */       } 
/*     */     } 
/*     */     
/* 221 */     long t = this.worldObj.getWorldTime();
/* 222 */     t %= 24000L;
/* 223 */     if (t < 12000L)
/*     */       return; 
/* 225 */     if (this.worldObj.isRemote && this.worldObj.rand.nextInt(5) == 0 && getBlink() > 1.0F) {
/* 226 */       this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY - 0.15000000596046448D, this.posZ, ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 8.0F), (-this.worldObj.rand.nextFloat() / 8.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 8.0F));
/*     */     }
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
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 239 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 240 */     if (this.myowner == null) this.myowner = "null"; 
/* 241 */     par1NBTTagCompound.setString("MyOwner", this.myowner);
/* 242 */     par1NBTTagCompound.setInteger("FairyType", this.fairy_type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 251 */     super.readEntityFromNBT(par1NBTTagCompound);
/* 252 */     this.myowner = par1NBTTagCompound.getString("MyOwner");
/* 253 */     if (this.myowner != null && 
/* 254 */       this.myowner.equals("null")) {
/* 255 */       this.myowner = null;
/*     */     }
/*     */     
/* 258 */     this.fairy_type = par1NBTTagCompound.getInteger("fairyType");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 266 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*     */     
/* 268 */     if (par1EntityLiving == null)
/*     */     {
/* 270 */       return false;
/*     */     }
/* 272 */     if (par1EntityLiving == this)
/*     */     {
/* 274 */       return false;
/*     */     }
/* 276 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/*     */       
/* 279 */       return false;
/*     */     }
/* 281 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 284 */       return false;
/*     */     }
/*     */     
/* 287 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityMob)
/*     */     {
/* 289 */       return true;
/*     */     }
/*     */     
/* 292 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 299 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 300 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(8.0D, 8.0D, 8.0D));
/* 301 */     Collections.sort(var5, this.TargetSorter);
/* 302 */     Iterator<?> var2 = var5.iterator();
/* 303 */     Entity var3 = null;
/* 304 */     EntityLivingBase var4 = null;
/*     */     
/* 306 */     while (var2.hasNext()) {
/*     */       
/* 308 */       var3 = (Entity)var2.next();
/* 309 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 311 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 313 */         return var4;
/*     */       }
/*     */     } 
/* 316 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSeeTarget(double pX, double pY, double pZ) {
/* 322 */     return (this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.25D, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 329 */     int keep_trying = 25;
/*     */     
/* 331 */     if (this.isDead)
/* 332 */       return;  super.updateAITasks();
/*     */ 
/*     */     
/* 335 */     if (this.currentFlightTarget == null) {
/* 336 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/* 338 */     if (this.worldObj.rand.nextInt(200) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.5F) {
/*     */       
/* 340 */       Block bid = Blocks.stone;
/* 341 */       while (bid != Blocks.air && keep_trying != 0) {
/* 342 */         int zdir = this.worldObj.rand.nextInt(8);
/* 343 */         int xdir = this.worldObj.rand.nextInt(8);
/* 344 */         if (this.worldObj.rand.nextInt(2) == 0) zdir = -zdir; 
/* 345 */         if (this.worldObj.rand.nextInt(2) == 0) xdir = -xdir; 
/* 346 */         this.currentFlightTarget.set((int)this.posX + xdir, (int)this.posY + this.worldObj.rand.nextInt(5) - 2, (int)this.posZ + zdir);
/* 347 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 348 */         if (bid == Blocks.air && 
/* 349 */           !canSeeTarget(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ)) {
/* 350 */           bid = Blocks.stone;
/*     */         }
/*     */         
/* 353 */         keep_trying--;
/*     */       } 
/* 355 */     } else if (this.worldObj.rand.nextInt(12) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
/*     */ 
/*     */       
/* 358 */       EntityLivingBase e = null;
/* 359 */       e = findSomethingToAttack();
/* 360 */       if (e != null)
/*     */       {
/*     */         
/* 363 */         this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 1.0D), (int)e.posZ);
/* 364 */         if (getDistanceSqToEntity((Entity)e) < 6.0D) {
/* 365 */           attackEntityAsMob((Entity)e);
/*     */         }
/*     */       }
/*     */     
/* 369 */     } else if (this.myowner != null) {
/* 370 */       EntityPlayer p = this.worldObj.getPlayerEntityByName(this.myowner);
/* 371 */       if (p != null) {
/* 372 */         if (getDistanceSqToEntity((Entity)p) > 64.0D) {
/* 373 */           this.currentFlightTarget.set((int)p.posX + this.worldObj.rand.nextInt(3) - this.worldObj.rand.nextInt(3), (int)(p.posY + 1.0D), (int)p.posZ + this.worldObj.rand.nextInt(3) - this.worldObj.rand.nextInt(3));
/*     */         }
/*     */         
/* 376 */         if (getDistanceSqToEntity((Entity)p) > 256.0D) {
/* 377 */           setPosition(p.posX + this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat(), p.posY, p.posZ + this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 382 */     if (this.worldObj.rand.nextInt(250) == 1) heal(1.0F);
/*     */     
/* 384 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 385 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 386 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 387 */     this.motionX += (Math.signum(var1) * 0.2D - this.motionX) * 0.1D;
/* 388 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.1D;
/* 389 */     this.motionZ += (Math.signum(var5) * 0.2D - this.motionZ) * 0.1D;
/* 390 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 391 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 392 */     this.moveForward = 0.2F;
/* 393 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 402 */     return false;
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
/* 421 */     return true;
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
/*     */   public boolean getCanSpawnHere() {
/* 433 */     int sc = 0;
/*     */ 
/*     */     
/* 436 */     for (int k = -1; k <= 1; k++) {
/*     */       
/* 438 */       for (int j = -1; j <= 1; j++) {
/*     */         
/* 440 */         Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY, (int)this.posZ + k);
/* 441 */         if (bid == Blocks.air) sc++; 
/*     */       } 
/*     */     } 
/* 444 */     if (sc < 6) return false; 
/* 445 */     if (this.posY < 50.0D) return false; 
/* 446 */     return true;
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
/*     */   protected boolean canDespawn() {
/* 458 */     if (isNoDespawnRequired()) return false; 
/* 459 */     if (this.myowner != null) return false; 
/* 460 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Fairy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */