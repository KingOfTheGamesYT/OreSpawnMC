/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
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
/*     */ public class RockBase
/*     */   extends EntityLiving
/*     */ {
/*  47 */   public int rock_type = 0;
/*     */   private double dx;
/*     */   private double dz;
/*     */   
/*     */   public RockBase(World par1World) {
/*  52 */     super(par1World);
/*  53 */     setSize(0.25F, 0.15F);
/*  54 */     this.fireResistance = 100000;
/*  55 */     this.isImmuneToFire = true;
/*  56 */     this.dx = this.dz = 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  62 */     super.entityInit();
/*  63 */     this.dataWatcher.addObject(20, Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  68 */     super.applyEntityAttributes();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  73 */     Entity e = par1DamageSource.getEntity();
/*  74 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/*  75 */       return false;
/*     */     }
/*  77 */     if (e != null && e instanceof net.minecraft.entity.EntityLivingBase) {
/*  78 */       playSound("random.pop", 0.75F, 2.25F);
/*     */     }
/*  80 */     return super.attackEntityFrom(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRockType() {
/*  91 */     return this.dataWatcher.getWatchableObjectInt(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRockType(int par1) {
/*  96 */     if (this.worldObj == null)
/*  97 */       return;  if (this.worldObj.isRemote)
/*  98 */       return;  this.dataWatcher.updateObject(20, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeRock(int par1) {
/* 103 */     this.rock_type = par1;
/* 104 */     setRockType(par1);
/* 105 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((1 + this.rock_type / 4));
/* 106 */     setHealth((1 + this.rock_type / 4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 114 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 126 */     if (this.dx == 0.0D && this.dz == 0.0D) {
/* 127 */       this.dx = this.posX;
/* 128 */       this.dz = this.posZ;
/*     */     } 
/* 130 */     super.onUpdate();
/* 131 */     this.rotationPitch = 0.0F;
/* 132 */     this.rotationYaw = this.rotationYawHead = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 136 */     if (this.worldObj.isRemote) {
/* 137 */       this.rock_type = getRockType();
/*     */     }
/* 139 */     if (!this.worldObj.isRemote && this.rock_type == 0) {
/* 140 */       if (this.worldObj.provider.dimensionId != OreSpawnMain.DimensionID5) {
/* 141 */         this.rock_type = 1;
/* 142 */         if (this.worldObj.rand.nextInt(10) == 0) this.rock_type = 2; 
/* 143 */         if (this.worldObj.rand.nextInt(20) == 0) this.rock_type = 3; 
/* 144 */         if (this.worldObj.rand.nextInt(30) == 0) this.rock_type = 4; 
/* 145 */         if (this.worldObj.rand.nextInt(40) == 0) this.rock_type = 5; 
/* 146 */         if (this.worldObj.rand.nextInt(50) == 0) this.rock_type = 6; 
/* 147 */         if (this.worldObj.rand.nextInt(100) == 0) this.rock_type = 7; 
/* 148 */         if (this.worldObj.rand.nextInt(200) == 0) this.rock_type = 8; 
/* 149 */         if (this.worldObj.rand.nextInt(500) == 0) this.rock_type = 9; 
/* 150 */         if (this.worldObj.rand.nextInt(500) == 0) this.rock_type = 10; 
/* 151 */         if (this.worldObj.rand.nextInt(500) == 0) this.rock_type = 11; 
/* 152 */         if (this.worldObj.rand.nextInt(1000) == 0) this.rock_type = 12; 
/*     */       } else {
/* 154 */         this.rock_type = 9;
/* 155 */         if (this.worldObj.rand.nextInt(3) == 0) this.rock_type = 10; 
/* 156 */         if (this.worldObj.rand.nextInt(5) == 0) this.rock_type = 11; 
/* 157 */         if (this.worldObj.rand.nextInt(10) == 0) this.rock_type = 12;
/*     */       
/*     */       } 
/*     */       
/* 161 */       getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((1 + this.rock_type / 4));
/* 162 */       setHealth((1 + this.rock_type / 4));
/*     */     } 
/* 164 */     if (!this.worldObj.isRemote) setRockType(this.rock_type);
/*     */     
/* 166 */     if (this.worldObj.isRemote) {
/* 167 */       if (this.rock_type == 9 && this.worldObj.rand.nextInt(20) == 0) {
/* 168 */         this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0F), (this.worldObj.rand.nextFloat() / 10.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0F));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 174 */       if (this.rock_type == 10 && this.worldObj.rand.nextInt(20) == 0) {
/* 175 */         this.worldObj.spawnParticle("happyVillager", this.posX, this.posY + 0.25D, this.posZ, ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0F), (this.worldObj.rand.nextFloat() / 2.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0F));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 181 */       if (this.rock_type == 11 && this.worldObj.rand.nextInt(20) == 0) {
/* 182 */         this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0F), (this.worldObj.rand.nextFloat() / 10.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0F));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 188 */       if (this.rock_type == 12 && this.worldObj.rand.nextInt(20) == 0) {
/* 189 */         this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 0.25D, this.posZ, ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0F), (this.worldObj.rand.nextFloat() / 5.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0F));
/*     */       }
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
/*     */   
/*     */   protected String getLivingSound() {
/* 204 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 212 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 220 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 227 */     return 0.65F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 234 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 243 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDespawn() {
/* 248 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 253 */     if (this.posY < 50.0D) return false; 
/* 254 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeCollidedWith() {
/* 262 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 270 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void performHurtAnimation() {
/* 278 */     this.hurtTime = this.maxHurtTime = 0;
/* 279 */     this.attackedAtYaw = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onDeathUpdate() {
/* 284 */     setDead();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDeath(DamageSource par1DamageSource) {
/* 289 */     setDead();
/* 290 */     if (this.rock_type == 1) dropItemRand(OreSpawnMain.MySmallRock, 1); 
/* 291 */     if (this.rock_type == 2) dropItemRand(OreSpawnMain.MyRock, 1); 
/* 292 */     if (this.rock_type == 3) dropItemRand(OreSpawnMain.MyRedRock, 1); 
/* 293 */     if (this.rock_type == 4) dropItemRand(OreSpawnMain.MyGreenRock, 1); 
/* 294 */     if (this.rock_type == 5) dropItemRand(OreSpawnMain.MyBlueRock, 1); 
/* 295 */     if (this.rock_type == 6) dropItemRand(OreSpawnMain.MyPurpleRock, 1); 
/* 296 */     if (this.rock_type == 7) dropItemRand(OreSpawnMain.MySpikeyRock, 1); 
/* 297 */     if (this.rock_type == 8) dropItemRand(OreSpawnMain.MyTNTRock, 1); 
/* 298 */     if (this.rock_type == 9) dropItemRand(OreSpawnMain.MyCrystalRedRock, 1); 
/* 299 */     if (this.rock_type == 10) dropItemRand(OreSpawnMain.MyCrystalGreenRock, 1); 
/* 300 */     if (this.rock_type == 11) dropItemRand(OreSpawnMain.MyCrystalBlueRock, 1); 
/* 301 */     if (this.rock_type == 12) dropItemRand(OreSpawnMain.MyCrystalTNTRock, 1);
/*     */   
/*     */   }
/*     */   
/*     */   private ItemStack dropItemRand(Item index, int par1) {
/* 306 */     EntityItem var3 = null;
/* 307 */     ItemStack is = new ItemStack(index, par1, 0);
/*     */     
/* 309 */     var3 = new EntityItem(this.worldObj, this.posX + ((OreSpawnMain.OreSpawnRand.nextFloat() - OreSpawnMain.OreSpawnRand.nextFloat()) / 3.0F), this.posY + 0.25D, this.posZ + ((OreSpawnMain.OreSpawnRand.nextFloat() - OreSpawnMain.OreSpawnRand.nextFloat()) / 3.0F), is);
/*     */     
/* 311 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 312 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 321 */     super.writeEntityToNBT(par1NBTTagCompound);
/*     */     
/* 323 */     par1NBTTagCompound.setInteger("ButterflyType", this.rock_type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 332 */     super.readEntityFromNBT(par1NBTTagCompound);
/*     */     
/* 334 */     this.rock_type = par1NBTTagCompound.getInteger("ButterflyType");
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RockBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */