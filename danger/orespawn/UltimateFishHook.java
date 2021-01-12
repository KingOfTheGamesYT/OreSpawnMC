/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.item.EntityXPOrb;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityFishHook;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemFishFood;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.util.WeightedRandom;
/*     */ import net.minecraft.util.WeightedRandomFishable;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UltimateFishHook
/*     */   extends EntityFishHook
/*     */ {
/*  40 */   private static final List field_146039_d = Arrays.asList(new WeightedRandomFishable[] { (new WeightedRandomFishable(new ItemStack((Item)Items.leather_boots), 10)).func_150709_a(0.9F), new WeightedRandomFishable(new ItemStack(Items.leather), 10), new WeightedRandomFishable(new ItemStack(Items.bone), 10), new WeightedRandomFishable(new ItemStack((Item)Items.potionitem), 10), new WeightedRandomFishable(new ItemStack(Items.string), 5), (new WeightedRandomFishable(new ItemStack((Item)Items.fishing_rod), 2)).func_150709_a(0.9F), new WeightedRandomFishable(new ItemStack(Items.bowl), 10), new WeightedRandomFishable(new ItemStack(Items.stick), 5), new WeightedRandomFishable(new ItemStack(Items.dye, 10, 0), 1), new WeightedRandomFishable(new ItemStack((Block)Blocks.tripwire_hook), 10), new WeightedRandomFishable(new ItemStack(Items.rotten_flesh), 10) });
/*  41 */   private static final List field_146041_e = Arrays.asList(new WeightedRandomFishable[] { new WeightedRandomFishable(new ItemStack(Blocks.waterlily), 1), new WeightedRandomFishable(new ItemStack(Items.name_tag), 1), new WeightedRandomFishable(new ItemStack(Items.saddle), 1), (new WeightedRandomFishable(new ItemStack((Item)Items.bow), 1)).func_150709_a(0.25F).func_150707_a(), (new WeightedRandomFishable(new ItemStack((Item)Items.fishing_rod), 1)).func_150709_a(0.25F).func_150707_a(), (new WeightedRandomFishable(new ItemStack(Items.book), 1)).func_150707_a() });
/*  42 */   private static final List field_146036_f = Arrays.asList(new WeightedRandomFishable[] { new WeightedRandomFishable(new ItemStack(Items.fish, 1, ItemFishFood.FishType.COD.getMetadata()), 60), new WeightedRandomFishable(new ItemStack(Items.fish, 1, ItemFishFood.FishType.SALMON.getMetadata()), 25), new WeightedRandomFishable(new ItemStack(Items.fish, 1, ItemFishFood.FishType.CLOWNFISH.getMetadata()), 2), new WeightedRandomFishable(new ItemStack(Items.fish, 1, ItemFishFood.FishType.PUFFERFISH.getMetadata()), 13) });
/*  43 */   private static final List orespawn_lava_fish = Arrays.asList(new WeightedRandomFishable[] { new WeightedRandomFishable(new ItemStack(OreSpawnMain.MySunspotUrchin), 25), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyLavaEel), 10), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MySunFish), 15), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MySparkFish), 10), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyFireFish), 15) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   private static final List orespawn_fish = Arrays.asList(new WeightedRandomFishable[] { new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyBlueFish), 25), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyPinkFish), 10), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyRockFish), 15), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyWoodFish), 10), new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyGreyFish), 15) });
/*     */   
/*     */   private int field_146037_g;
/*     */   
/*     */   private int field_146048_h;
/*     */   
/*     */   private int field_146050_i;
/*     */   
/*     */   private Block field_146046_j;
/*     */   
/*     */   private boolean inGround;
/*     */   
/*     */   private int ticksInGround;
/*     */   
/*     */   private int ticksInAir;
/*     */   
/*     */   private int fish_on_hook;
/*     */   
/*     */   private int fish_wait_time;
/*     */   private int ticks_catchable;
/*     */   private float fish_direction;
/*     */   public Entity caughtEntity;
/*     */   private int field_146055_aB;
/*     */   private double field_146056_aC;
/*     */   private double field_146057_aD;
/*     */   private double field_146058_aE;
/*     */   private double field_146059_aF;
/*     */   private double field_146060_aG;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double field_146061_aH;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double field_146052_aI;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double field_146053_aJ;
/*  83 */   private int fishing_in_lava = 0;
/*     */ 
/*     */   
/*     */   public UltimateFishHook(World par1World) {
/*  87 */     super(par1World);
/*  88 */     this.field_146037_g = -1;
/*  89 */     this.field_146048_h = -1;
/*  90 */     this.field_146050_i = -1;
/*  91 */     setSize(0.25F, 0.25F);
/*  92 */     this.ignoreFrustumCheck = true;
/*  93 */     this.fireResistance = 3000;
/*  94 */     this.isImmuneToFire = true;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public UltimateFishHook(World par1World, double par2, double par4, double par6, EntityPlayer par8EntityPlayer) {
/* 100 */     this(par1World);
/* 101 */     setPosition(par2, par4, par6);
/* 102 */     this.ignoreFrustumCheck = true;
/* 103 */     this.angler = par8EntityPlayer;
/* 104 */     par8EntityPlayer.fishEntity = this;
/* 105 */     this.fireResistance = 3000;
/* 106 */     this.isImmuneToFire = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public UltimateFishHook(World par1World, EntityPlayer par2EntityPlayer) {
/* 111 */     super(par1World);
/* 112 */     this.field_146037_g = -1;
/* 113 */     this.field_146048_h = -1;
/* 114 */     this.field_146050_i = -1;
/* 115 */     this.ignoreFrustumCheck = true;
/* 116 */     this.angler = par2EntityPlayer;
/* 117 */     this.angler.fishEntity = this;
/* 118 */     setSize(0.25F, 0.25F);
/* 119 */     setLocationAndAngles(par2EntityPlayer.posX, par2EntityPlayer.posY + 1.62D - par2EntityPlayer.yOffset, par2EntityPlayer.posZ, par2EntityPlayer.rotationYaw, par2EntityPlayer.rotationPitch);
/* 120 */     this.posX -= (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 121 */     this.posY -= 0.10000000149011612D;
/* 122 */     this.posZ -= (MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
/* 123 */     setPosition(this.posX, this.posY, this.posZ);
/* 124 */     this.yOffset = 0.0F;
/* 125 */     float f = 0.4F;
/* 126 */     this.motionX = (-MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F) * f);
/* 127 */     this.motionZ = (MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F) * f);
/* 128 */     this.motionY = (-MathHelper.sin(this.rotationPitch / 180.0F * 3.1415927F) * f);
/* 129 */     func_146035_c(this.motionX, this.motionY, this.motionZ, 1.5F, 1.0F);
/* 130 */     this.fireResistance = 3000;
/* 131 */     this.isImmuneToFire = true;
/*     */   }
/*     */   
/*     */   protected void entityInit() {
/* 135 */     this.fireResistance = 3000;
/* 136 */     this.isImmuneToFire = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146035_c(double p_146035_1_, double p_146035_3_, double p_146035_5_, float p_146035_7_, float p_146035_8_) {
/* 144 */     float f2 = MathHelper.sqrt_double(p_146035_1_ * p_146035_1_ + p_146035_3_ * p_146035_3_ + p_146035_5_ * p_146035_5_);
/* 145 */     p_146035_1_ /= f2;
/* 146 */     p_146035_3_ /= f2;
/* 147 */     p_146035_5_ /= f2;
/* 148 */     p_146035_1_ += this.rand.nextGaussian() * 0.007499999832361937D * p_146035_8_;
/* 149 */     p_146035_3_ += this.rand.nextGaussian() * 0.007499999832361937D * p_146035_8_;
/* 150 */     p_146035_5_ += this.rand.nextGaussian() * 0.007499999832361937D * p_146035_8_;
/* 151 */     p_146035_1_ *= p_146035_7_;
/* 152 */     p_146035_3_ *= p_146035_7_;
/* 153 */     p_146035_5_ *= p_146035_7_;
/* 154 */     this.motionX = p_146035_1_;
/* 155 */     this.motionY = p_146035_3_;
/* 156 */     this.motionZ = p_146035_5_;
/* 157 */     float f3 = MathHelper.sqrt_double(p_146035_1_ * p_146035_1_ + p_146035_5_ * p_146035_5_);
/* 158 */     this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(p_146035_1_, p_146035_5_) * 180.0D / Math.PI);
/* 159 */     this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(p_146035_3_, f3) * 180.0D / Math.PI);
/* 160 */     this.ticksInGround = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean isInRangeToRenderDist(double par1) {
/* 170 */     double d1 = this.boundingBox.getAverageEdgeLength() * 4.0D;
/* 171 */     d1 *= 64.0D;
/* 172 */     return (par1 < d1 * d1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 182 */     this.field_146056_aC = par1;
/* 183 */     this.field_146057_aD = par3;
/* 184 */     this.field_146058_aE = par5;
/* 185 */     this.field_146059_aF = par7;
/* 186 */     this.field_146060_aG = par8;
/* 187 */     this.field_146055_aB = par9;
/* 188 */     this.motionX = this.field_146061_aH;
/* 189 */     this.motionY = this.field_146052_aI;
/* 190 */     this.motionZ = this.field_146053_aJ;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setVelocity(double par1, double par3, double par5) {
/* 199 */     this.field_146061_aH = this.motionX = par1;
/* 200 */     this.field_146052_aI = this.motionY = par3;
/* 201 */     this.field_146053_aJ = this.motionZ = par5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 211 */     if (this.field_146055_aB > 0) {
/*     */       
/* 213 */       double d7 = this.posX + (this.field_146056_aC - this.posX) / this.field_146055_aB;
/* 214 */       double d8 = this.posY + (this.field_146057_aD - this.posY) / this.field_146055_aB;
/* 215 */       double d9 = this.posZ + (this.field_146058_aE - this.posZ) / this.field_146055_aB;
/* 216 */       double d1 = MathHelper.wrapAngleTo180_double(this.field_146059_aF - this.rotationYaw);
/* 217 */       this.rotationYaw = (float)(this.rotationYaw + d1 / this.field_146055_aB);
/* 218 */       this.rotationPitch = (float)(this.rotationPitch + (this.field_146060_aG - this.rotationPitch) / this.field_146055_aB);
/* 219 */       this.field_146055_aB--;
/* 220 */       setPosition(d7, d8, d9);
/* 221 */       setRotation(this.rotationYaw, this.rotationPitch);
/*     */     }
/*     */     else {
/*     */       
/* 225 */       if (!this.worldObj.isRemote) {
/*     */         
/* 227 */         ItemStack itemstack = this.angler.getCurrentEquippedItem();
/*     */         
/* 229 */         if (this.angler.isDead || !this.angler.isEntityAlive() || itemstack == null || itemstack.getItem() != OreSpawnMain.MyUltimateFishingRod || getDistanceSqToEntity((Entity)this.angler) > 1024.0D) {
/*     */           
/* 231 */           setDead();
/* 232 */           this.angler.fishEntity = null;
/*     */           
/*     */           return;
/*     */         } 
/* 236 */         if (this.caughtEntity != null) {
/*     */           
/* 238 */           if (!this.caughtEntity.isDead) {
/*     */             
/* 240 */             this.posX = this.caughtEntity.posX;
/* 241 */             this.posY = this.caughtEntity.boundingBox.minY + this.caughtEntity.height * 0.8D;
/* 242 */             this.posZ = this.caughtEntity.posZ;
/*     */             
/*     */             return;
/*     */           } 
/* 246 */           this.caughtEntity = null;
/*     */         } 
/*     */       } 
/*     */       
/* 250 */       if (this.field_146044_a > 0)
/*     */       {
/* 252 */         this.field_146044_a--;
/*     */       }
/*     */       
/* 255 */       if (this.inGround) {
/*     */         
/* 257 */         if (this.worldObj.getBlock(this.field_146037_g, this.field_146048_h, this.field_146050_i) == this.field_146046_j) {
/*     */           
/* 259 */           this.ticksInGround++;
/*     */           
/* 261 */           if (this.ticksInGround == 1200)
/*     */           {
/* 263 */             setDead();
/*     */           }
/*     */           
/*     */           return;
/*     */         } 
/*     */         
/* 269 */         this.inGround = false;
/* 270 */         this.motionX *= (this.rand.nextFloat() * 0.2F);
/* 271 */         this.motionY *= (this.rand.nextFloat() * 0.2F);
/* 272 */         this.motionZ *= (this.rand.nextFloat() * 0.2F);
/* 273 */         this.ticksInGround = 0;
/* 274 */         this.ticksInAir = 0;
/*     */       }
/*     */       else {
/*     */         
/* 278 */         this.ticksInAir++;
/*     */       } 
/*     */       
/* 281 */       Vec3 vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 282 */       Vec3 vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/* 283 */       MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec31, vec3);
/* 284 */       vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
/* 285 */       vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
/*     */       
/* 287 */       if (movingobjectposition != null)
/*     */       {
/* 289 */         vec3 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
/*     */       }
/*     */       
/* 292 */       Entity entity = null;
/* 293 */       List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
/* 294 */       double d0 = 0.0D;
/*     */ 
/*     */       
/* 297 */       for (int i = 0; i < list.size(); i++) {
/*     */         
/* 299 */         Entity entity1 = list.get(i);
/*     */         
/* 301 */         if (entity1.canBeCollidedWith() && (entity1 != this.angler || this.ticksInAir >= 5)) {
/*     */           
/* 303 */           float f = 0.3F;
/* 304 */           AxisAlignedBB axisalignedbb = entity1.boundingBox.expand(f, f, f);
/* 305 */           MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(vec31, vec3);
/*     */           
/* 307 */           if (movingobjectposition1 != null) {
/*     */             
/* 309 */             double d2 = vec31.distanceTo(movingobjectposition1.hitVec);
/*     */             
/* 311 */             if (d2 < d0 || d0 == 0.0D) {
/*     */               
/* 313 */               entity = entity1;
/* 314 */               d0 = d2;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 320 */       if (entity != null)
/*     */       {
/* 322 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 325 */       if (movingobjectposition != null)
/*     */       {
/* 327 */         if (movingobjectposition.entityHit != null) {
/*     */           
/* 329 */           if (movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)this.angler), 0.0F))
/*     */           {
/* 331 */             this.caughtEntity = movingobjectposition.entityHit;
/*     */           }
/*     */         }
/*     */         else {
/*     */           
/* 336 */           this.inGround = true;
/*     */         } 
/*     */       }
/*     */       
/* 340 */       if (!this.inGround) {
/*     */         
/* 342 */         moveEntity(this.motionX, this.motionY, this.motionZ);
/* 343 */         float f5 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
/* 344 */         this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
/*     */         
/* 346 */         for (this.rotationPitch = (float)(Math.atan2(this.motionY, f5) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 351 */         while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
/*     */         {
/* 353 */           this.prevRotationPitch += 360.0F;
/*     */         }
/*     */         
/* 356 */         while (this.rotationYaw - this.prevRotationYaw < -180.0F)
/*     */         {
/* 358 */           this.prevRotationYaw -= 360.0F;
/*     */         }
/*     */         
/* 361 */         while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
/*     */         {
/* 363 */           this.prevRotationYaw += 360.0F;
/*     */         }
/*     */         
/* 366 */         this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
/* 367 */         this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
/* 368 */         float f6 = 0.92F;
/*     */         
/* 370 */         if (this.onGround || this.isCollidedHorizontally)
/*     */         {
/* 372 */           f6 = 0.5F;
/*     */         }
/*     */         
/* 375 */         byte b0 = 5;
/* 376 */         double d10 = 0.0D;
/*     */         
/* 378 */         for (int j = 0; j < b0; j++) {
/*     */           
/* 380 */           double d3 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (j + 0) / b0 - 0.125D + 0.125D;
/* 381 */           double d4 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (j + 1) / b0 - 0.125D + 0.125D;
/* 382 */           AxisAlignedBB axisalignedbb1 = AxisAlignedBB.getBoundingBox(this.boundingBox.minX, d3, this.boundingBox.minZ, this.boundingBox.maxX, d4, this.boundingBox.maxZ);
/*     */           
/* 384 */           if (this.worldObj.isAABBInMaterial(axisalignedbb1, Material.water))
/*     */           {
/* 386 */             d10 += 1.0D / b0;
/*     */           }
/* 388 */           if (this.worldObj.isAABBInMaterial(axisalignedbb1, Material.lava))
/*     */           {
/* 390 */             d10 += 1.0D / b0;
/*     */           }
/*     */         } 
/*     */         
/* 394 */         if (!this.worldObj.isRemote && d10 > 0.0D) {
/*     */           
/* 396 */           WorldServer worldserver = (WorldServer)this.worldObj;
/* 397 */           int k = 1;
/*     */           
/* 399 */           if (this.rand.nextFloat() < 0.25F && this.worldObj.canLightningStrikeAt(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) + 1, MathHelper.floor_double(this.posZ)))
/*     */           {
/* 401 */             k = 2;
/*     */           }
/*     */           
/* 404 */           if (this.rand.nextFloat() < 0.5F && !this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) + 1, MathHelper.floor_double(this.posZ)))
/*     */           {
/* 406 */             k--;
/*     */           }
/*     */           
/* 409 */           if (this.fish_on_hook > 0) {
/*     */             
/* 411 */             this.fish_on_hook--;
/*     */             
/* 413 */             if (this.fish_on_hook <= 0)
/*     */             {
/* 415 */               this.fish_wait_time = 0;
/* 416 */               this.ticks_catchable = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           }
/* 428 */           else if (this.ticks_catchable > 0) {
/*     */             
/* 430 */             this.ticks_catchable -= k;
/*     */             
/* 432 */             if (this.ticks_catchable <= 0)
/*     */             {
/* 434 */               this.motionY -= 0.20000000298023224D;
/* 435 */               playSound("random.splash", 0.25F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
/* 436 */               float f1 = MathHelper.floor_double(this.boundingBox.minY);
/* 437 */               worldserver.func_147487_a("bubble", this.posX, (f1 + 1.0F), this.posZ, (int)(1.0F + this.width * 20.0F), this.width, 0.0D, this.width, 0.20000000298023224D);
/* 438 */               worldserver.func_147487_a("wake", this.posX, (f1 + 1.0F), this.posZ, (int)(1.0F + this.width * 20.0F), this.width, 0.0D, this.width, 0.20000000298023224D);
/* 439 */               this.fish_on_hook = MathHelper.getRandomIntegerInRange(this.rand, 10, 30);
/*     */             }
/*     */             else
/*     */             {
/* 443 */               this.fish_direction = (float)(this.fish_direction + this.rand.nextGaussian() * 4.0D);
/* 444 */               float f1 = this.fish_direction * 0.017453292F;
/* 445 */               float f7 = MathHelper.sin(f1);
/* 446 */               float f2 = MathHelper.cos(f1);
/* 447 */               double d11 = this.posX + (f7 * this.ticks_catchable * 0.1F);
/* 448 */               double d5 = (MathHelper.floor_double(this.boundingBox.minY) + 1.0F);
/* 449 */               double d6 = this.posZ + (f2 * this.ticks_catchable * 0.1F);
/*     */               
/* 451 */               if (this.rand.nextFloat() < 0.15F)
/*     */               {
/* 453 */                 worldserver.func_147487_a("bubble", d11, d5 - 0.10000000149011612D, d6, 1, f7, 0.1D, f2, 0.0D);
/*     */               }
/*     */               
/* 456 */               float f3 = f7 * 0.04F;
/* 457 */               float f4 = f2 * 0.04F;
/* 458 */               worldserver.func_147487_a("wake", d11, d5, d6, 0, f4, 0.01D, -f3, 1.0D);
/* 459 */               worldserver.func_147487_a("wake", d11, d5, d6, 0, -f4, 0.01D, f3, 1.0D);
/*     */             }
/*     */           
/* 462 */           } else if (this.fish_wait_time > 0) {
/*     */             
/* 464 */             this.fish_wait_time -= k;
/* 465 */             float f1 = 0.15F;
/*     */             
/* 467 */             if (this.fish_wait_time < 20) {
/*     */               
/* 469 */               f1 = (float)(f1 + (20 - this.fish_wait_time) * 0.05D);
/*     */             }
/* 471 */             else if (this.fish_wait_time < 40) {
/*     */               
/* 473 */               f1 = (float)(f1 + (40 - this.fish_wait_time) * 0.02D);
/*     */             }
/* 475 */             else if (this.fish_wait_time < 60) {
/*     */               
/* 477 */               f1 = (float)(f1 + (60 - this.fish_wait_time) * 0.01D);
/*     */             } 
/*     */             
/* 480 */             if (this.rand.nextFloat() < f1) {
/*     */               
/* 482 */               float f7 = MathHelper.randomFloatClamp(this.rand, 0.0F, 360.0F) * 0.017453292F;
/* 483 */               float f2 = MathHelper.randomFloatClamp(this.rand, 25.0F, 60.0F);
/* 484 */               double d11 = this.posX + (MathHelper.sin(f7) * f2 * 0.1F);
/* 485 */               double d5 = (MathHelper.floor_double(this.boundingBox.minY) + 1.0F);
/* 486 */               double d6 = this.posZ + (MathHelper.cos(f7) * f2 * 0.1F);
/* 487 */               worldserver.func_147487_a("splash", d11, d5, d6, 2 + this.rand.nextInt(2), 0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.0D);
/*     */             } 
/*     */             
/* 490 */             if (this.fish_wait_time <= 0)
/*     */             {
/* 492 */               this.fish_direction = MathHelper.randomFloatClamp(this.rand, 0.0F, 360.0F);
/* 493 */               this.ticks_catchable = MathHelper.getRandomIntegerInRange(this.rand, 100, 200);
/*     */             }
/*     */           
/*     */           } else {
/*     */             
/* 498 */             this.fish_wait_time = MathHelper.getRandomIntegerInRange(this.rand, 50, 300);
/* 499 */             this.fish_wait_time -= EnchantmentHelper.func_151387_h((EntityLivingBase)this.angler) * 20 * 5;
/*     */           } 
/*     */ 
/*     */           
/* 503 */           if (this.fish_on_hook > 0)
/*     */           {
/* 505 */             this.motionY -= (this.rand.nextFloat() * this.rand.nextFloat() * this.rand.nextFloat()) * 0.2D;
/*     */           }
/*     */         } 
/*     */         
/* 509 */         double d2 = d10 * 2.0D - 1.0D;
/* 510 */         this.motionY += 0.03999999910593033D * d2;
/*     */         
/* 512 */         if (d10 > 0.0D) {
/*     */           
/* 514 */           f6 = (float)(f6 * 0.9D);
/* 515 */           this.motionY *= 0.8D;
/*     */         } 
/*     */         
/* 518 */         this.motionX *= f6;
/* 519 */         this.motionY *= f6;
/* 520 */         this.motionZ *= f6;
/* 521 */         setPosition(this.posX, this.posY, this.posZ);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 531 */     par1NBTTagCompound.setShort("xTile", (short)this.field_146037_g);
/* 532 */     par1NBTTagCompound.setShort("yTile", (short)this.field_146048_h);
/* 533 */     par1NBTTagCompound.setShort("zTile", (short)this.field_146050_i);
/* 534 */     par1NBTTagCompound.setByte("inTile", (byte)Block.getIdFromBlock(this.field_146046_j));
/* 535 */     par1NBTTagCompound.setByte("shake", (byte)this.field_146044_a);
/* 536 */     par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 544 */     this.field_146037_g = par1NBTTagCompound.getShort("xTile");
/* 545 */     this.field_146048_h = par1NBTTagCompound.getShort("yTile");
/* 546 */     this.field_146050_i = par1NBTTagCompound.getShort("zTile");
/* 547 */     this.field_146046_j = Block.getBlockById(par1NBTTagCompound.getByte("inTile") & 0xFF);
/* 548 */     this.field_146044_a = par1NBTTagCompound.getByte("shake") & 0xFF;
/* 549 */     this.inGround = (par1NBTTagCompound.getByte("inGround") == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float getShadowSize() {
/* 555 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public int handleHookRetraction() {
/* 560 */     if (this.worldObj.isRemote)
/*     */     {
/* 562 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 566 */     byte b0 = 0;
/*     */     
/* 568 */     if (this.caughtEntity != null) {
/*     */       
/* 570 */       double d0 = this.angler.posX - this.posX;
/* 571 */       double d2 = this.angler.posY - this.posY;
/* 572 */       double d4 = this.angler.posZ - this.posZ;
/* 573 */       double d6 = MathHelper.sqrt_double(d0 * d0 + d2 * d2 + d4 * d4);
/* 574 */       double d8 = 0.1D;
/* 575 */       this.caughtEntity.motionX += d0 * d8;
/* 576 */       this.caughtEntity.motionY += d2 * d8 + MathHelper.sqrt_double(d6) * 0.08D;
/* 577 */       this.caughtEntity.motionZ += d4 * d8;
/* 578 */       b0 = 3;
/*     */     }
/* 580 */     else if (this.fish_on_hook > 0) {
/*     */       
/* 582 */       EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY + 1.25D, this.posZ, func_146033_f());
/* 583 */       double d1 = this.angler.posX - this.posX;
/* 584 */       double d3 = this.angler.posY - this.posY;
/* 585 */       double d5 = this.angler.posZ - this.posZ;
/* 586 */       double d7 = MathHelper.sqrt_double(d1 * d1 + d3 * d3 + d5 * d5);
/* 587 */       double d9 = 0.1D;
/* 588 */       entityitem.motionX = d1 * d9;
/* 589 */       entityitem.motionY = d3 * d9 + MathHelper.sqrt_double(d7) * 0.08D;
/* 590 */       entityitem.motionZ = d5 * d9;
/* 591 */       entityitem.fireResistance = 3000;
/* 592 */       this.worldObj.spawnEntityInWorld((Entity)entityitem);
/* 593 */       this.angler.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.angler.worldObj, this.angler.posX, this.angler.posY + 0.5D, this.angler.posZ + 0.5D, this.rand.nextInt(6) + 1));
/* 594 */       b0 = 1;
/*     */     } 
/*     */     
/* 597 */     if (this.inGround)
/*     */     {
/* 599 */       b0 = 2;
/*     */     }
/*     */     
/* 602 */     setDead();
/* 603 */     this.angler.fishEntity = null;
/* 604 */     return b0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemStack func_146033_f() {
/* 610 */     float f = this.worldObj.rand.nextFloat();
/* 611 */     int i = EnchantmentHelper.func_151386_g((EntityLivingBase)this.angler);
/* 612 */     int j = EnchantmentHelper.func_151387_h((EntityLivingBase)this.angler);
/* 613 */     float f1 = 0.1F - i * 0.025F - j * 0.01F;
/* 614 */     float f2 = 0.05F + i * 0.01F - j * 0.01F;
/* 615 */     f1 = MathHelper.clamp_float(f1, 0.0F, 1.0F);
/* 616 */     f2 = MathHelper.clamp_float(f2, 0.0F, 1.0F);
/* 617 */     Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */ 
/*     */     
/* 620 */     if (handleLavaMovement() || bid == Blocks.lava || bid == Blocks.flowing_lava) {
/* 621 */       this.angler.addStat(StatList.fishCaughtStat, 1);
/* 622 */       return ((WeightedRandomFishable)WeightedRandom.getRandomItem(this.rand, orespawn_lava_fish)).func_150708_a(this.rand);
/*     */     } 
/* 624 */     if (f < f1) {
/*     */       
/* 626 */       this.angler.addStat(StatList.field_151183_A, 1);
/* 627 */       return ((WeightedRandomFishable)WeightedRandom.getRandomItem(this.rand, field_146039_d)).func_150708_a(this.rand);
/*     */     } 
/*     */ 
/*     */     
/* 631 */     f -= f1;
/*     */     
/* 633 */     if (f < f2) {
/*     */       
/* 635 */       this.angler.addStat(StatList.field_151184_B, 1);
/* 636 */       return ((WeightedRandomFishable)WeightedRandom.getRandomItem(this.rand, field_146041_e)).func_150708_a(this.rand);
/*     */     } 
/*     */ 
/*     */     
/* 640 */     float f3 = this.worldObj.rand.nextFloat();
/* 641 */     this.angler.addStat(StatList.fishCaughtStat, 1);
/* 642 */     if (f3 < 0.5F) {
/* 643 */       return ((WeightedRandomFishable)WeightedRandom.getRandomItem(this.rand, field_146036_f)).func_150708_a(this.rand);
/*     */     }
/* 645 */     return ((WeightedRandomFishable)WeightedRandom.getRandomItem(this.rand, orespawn_fish)).func_150708_a(this.rand);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDead() {
/* 656 */     super.setDead();
/*     */     
/* 658 */     if (this.angler != null)
/*     */     {
/* 660 */       this.angler.fishEntity = null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\UltimateFishHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */