/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityThrowable;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityThrownRock
/*     */   extends EntityThrowable
/*     */ {
/*  21 */   private int rock_type = 0;
/*  22 */   private int myage = 0;
/*  23 */   private float my_rotation = 0.0F;
/*     */ 
/*     */   
/*     */   public EntityThrownRock(World par1World) {
/*  27 */     super(par1World);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityThrownRock(World par1World, int par2) {
/*  32 */     super(par1World);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityThrownRock(World par1World, EntityLivingBase par2EntityLiving) {
/*  37 */     super(par1World, par2EntityLiving);
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
/*     */   public EntityThrownRock(World par1World, EntityLivingBase par2EntityLiving, int par3) {
/*  57 */     super(par1World, par2EntityLiving);
/*  58 */     this.rock_type = par3;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityThrownRock(World par1World, double par2, double par4, double par6) {
/*  63 */     super(par1World, par2, par4, par6);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  68 */     super.entityInit();
/*  69 */     this.dataWatcher.addObject(20, Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRockType() {
/*  74 */     return this.dataWatcher.getWatchableObjectInt(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRockType(int par1) {
/*  79 */     if (this.worldObj == null)
/*  80 */       return;  if (this.worldObj.isRemote)
/*  81 */       return;  this.rock_type = par1;
/*  82 */     this.dataWatcher.updateObject(20, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
/*  91 */     if (this.isDead)
/*  92 */       return;  if (this.worldObj.isRemote)
/*  93 */       return;  if (par1MovingObjectPosition.entityHit != null && getThrower() != null) {
/*     */       
/*  95 */       Entity e = par1MovingObjectPosition.entityHit;
/*  96 */       if (this.rock_type == 1 && e != getThrower()) {
/*  97 */         e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)getThrower()), 2.0F);
/*  98 */         double ks = 0.1D;
/*  99 */         double inair = 0.025D;
/* 100 */         float f3 = (float)Math.atan2(e.posZ - (getThrower()).posZ, e.posX - (getThrower()).posX);
/* 101 */         if (e.isDead) inair *= 2.0D; 
/* 102 */         e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 104 */       if (this.rock_type == 2 && e != getThrower()) {
/* 105 */         e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)getThrower()), 5.0F);
/* 106 */         double ks = 0.2D;
/* 107 */         double inair = 0.025D;
/* 108 */         float f3 = (float)Math.atan2(e.posZ - (getThrower()).posZ, e.posX - (getThrower()).posX);
/* 109 */         if (e.isDead) inair *= 2.0D; 
/* 110 */         e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 112 */       if (this.rock_type == 3 && e != getThrower()) {
/* 113 */         e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)getThrower()), 5.0F);
/* 114 */         double ks = 0.2D;
/* 115 */         double inair = 0.025D;
/* 116 */         float f3 = (float)Math.atan2(e.posZ - (getThrower()).posZ, e.posX - (getThrower()).posX);
/* 117 */         if (e.isDead) inair *= 2.0D; 
/* 118 */         e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/* 119 */         e.setFire(20);
/*     */       } 
/* 121 */       if (this.rock_type == 4 && e != getThrower()) {
/* 122 */         e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)getThrower()), 5.0F);
/* 123 */         double ks = 0.2D;
/* 124 */         double inair = 0.025D;
/* 125 */         float f3 = (float)Math.atan2(e.posZ - (getThrower()).posZ, e.posX - (getThrower()).posX);
/* 126 */         if (e.isDead) inair *= 2.0D; 
/* 127 */         e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/* 128 */         if (e instanceof EntityLivingBase) ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.poison.id, 100, 0)); 
/*     */       } 
/* 130 */       if (this.rock_type == 5 && e != getThrower()) {
/* 131 */         e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)getThrower()), 10.0F);
/* 132 */         double ks = 0.1D;
/* 133 */         double inair = 0.025D;
/* 134 */         float f3 = (float)Math.atan2(e.posZ - (getThrower()).posZ, e.posX - (getThrower()).posX);
/* 135 */         if (e.isDead) inair *= 2.0D; 
/* 136 */         e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/* 137 */         if (e instanceof EntityLivingBase) ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0)); 
/*     */       } 
/* 139 */       if (this.rock_type == 6 && e != getThrower()) {
/* 140 */         e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)getThrower()), 20.0F);
/* 141 */         double ks = 0.2D;
/* 142 */         double inair = 0.025D;
/* 143 */         float f3 = (float)Math.atan2(e.posZ - (getThrower()).posZ, e.posX - (getThrower()).posX);
/* 144 */         if (e.isDead) inair *= 2.0D; 
/* 145 */         e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/* 146 */         if (e instanceof EntityLivingBase) ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0)); 
/*     */       } 
/* 148 */       if (this.rock_type == 7 && e != getThrower()) {
/* 149 */         e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)getThrower()), 40.0F);
/* 150 */         double ks = 0.2D;
/* 151 */         double inair = 0.025D;
/* 152 */         float f3 = (float)Math.atan2(e.posZ - (getThrower()).posZ, e.posX - (getThrower()).posX);
/* 153 */         if (e.isDead) inair *= 2.0D; 
/* 154 */         e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/*     */       } 
/* 156 */       if (this.rock_type == 8 && e != getThrower()) {
/* 157 */         e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)getThrower()), 40.0F);
/* 158 */         double ks = 0.5D;
/* 159 */         double inair = 0.055D;
/* 160 */         float f3 = (float)Math.atan2(e.posZ - (getThrower()).posZ, e.posX - (getThrower()).posX);
/* 161 */         if (e.isDead) inair *= 2.0D; 
/* 162 */         e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/* 163 */         this.worldObj.newExplosion((Entity)null, e.posX, e.posY + 0.25D, e.posZ, 2.1F, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
/*     */       } 
/*     */       
/* 166 */       if (this.rock_type == 9 && e != getThrower()) {
/* 167 */         e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)getThrower()), 150.0F);
/* 168 */         double ks = 0.2D;
/* 169 */         double inair = 0.025D;
/* 170 */         float f3 = (float)Math.atan2(e.posZ - (getThrower()).posZ, e.posX - (getThrower()).posX);
/* 171 */         if (e.isDead) inair *= 2.0D; 
/* 172 */         e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/* 173 */         e.setFire(50);
/* 174 */         if (e instanceof EntityLivingBase) ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0)); 
/*     */       } 
/* 176 */       if (this.rock_type == 10 && e != getThrower()) {
/* 177 */         e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)getThrower()), 150.0F);
/* 178 */         double ks = 0.2D;
/* 179 */         double inair = 0.025D;
/* 180 */         float f3 = (float)Math.atan2(e.posZ - (getThrower()).posZ, e.posX - (getThrower()).posX);
/* 181 */         if (e.isDead) inair *= 2.0D; 
/* 182 */         e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/* 183 */         if (e instanceof EntityLivingBase) ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 0)); 
/* 184 */         if (e instanceof EntityLivingBase) ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0)); 
/*     */       } 
/* 186 */       if (this.rock_type == 11 && e != getThrower()) {
/* 187 */         e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)getThrower()), 150.0F);
/* 188 */         double ks = 0.2D;
/* 189 */         double inair = 0.025D;
/* 190 */         float f3 = (float)Math.atan2(e.posZ - (getThrower()).posZ, e.posX - (getThrower()).posX);
/* 191 */         if (e.isDead) inair *= 2.0D; 
/* 192 */         e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/* 193 */         if (e instanceof EntityLivingBase) ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 0)); 
/* 194 */         if (e instanceof EntityLivingBase) ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0)); 
/*     */       } 
/* 196 */       if (this.rock_type == 12 && e != getThrower()) {
/* 197 */         e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)getThrower()), 250.0F);
/* 198 */         double ks = 0.2D;
/* 199 */         double inair = 0.025D;
/* 200 */         float f3 = (float)Math.atan2(e.posZ - (getThrower()).posZ, e.posX - (getThrower()).posX);
/* 201 */         if (e.isDead) inair *= 2.0D; 
/* 202 */         e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
/* 203 */         if (e instanceof EntityLivingBase) ((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0)); 
/* 204 */         this.worldObj.newExplosion((Entity)null, e.posX, e.posY + 0.25D, e.posZ, 5.1F, true, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 209 */     else if (this.rock_type != 0) {
/*     */ 
/*     */       
/* 212 */       int played = 0;
/*     */       
/* 214 */       int x = par1MovingObjectPosition.blockX;
/* 215 */       int y = par1MovingObjectPosition.blockY;
/* 216 */       int z = par1MovingObjectPosition.blockZ;
/* 217 */       for (int i = -1; i <= 1; i++) {
/* 218 */         for (int j = -1; j <= 1; j++) {
/* 219 */           for (int k = -1; k <= 1; k++) {
/* 220 */             Block bid = this.worldObj.getBlock(x + i, y + j, z + k);
/* 221 */             if (bid == Blocks.glass || bid == Blocks.glass_pane || bid == Blocks.glass) {
/* 222 */               if (!this.worldObj.isRemote) this.worldObj.setBlock(x + i, y + j, z + k, Blocks.air); 
/* 223 */               if (played == 0) {
/* 224 */                 this.worldObj.playSoundEffect(x, y, z, "orespawn:glassdead", 1.0F, 1.0F);
/* 225 */                 played++;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 232 */       if (!this.worldObj.isRemote) {
/* 233 */         if (this.rock_type == 1) dropItem(OreSpawnMain.MySmallRock, 1); 
/* 234 */         if (this.rock_type == 2) dropItem(OreSpawnMain.MyRock, 1); 
/* 235 */         if (this.rock_type == 3) dropItem(OreSpawnMain.MyRedRock, 1); 
/* 236 */         if (this.rock_type == 4) dropItem(OreSpawnMain.MyGreenRock, 1); 
/* 237 */         if (this.rock_type == 5) dropItem(OreSpawnMain.MyBlueRock, 1); 
/* 238 */         if (this.rock_type == 6) dropItem(OreSpawnMain.MyPurpleRock, 1); 
/* 239 */         if (this.rock_type == 7) dropItem(OreSpawnMain.MySpikeyRock, 1); 
/* 240 */         if (this.rock_type == 8) dropItem(OreSpawnMain.MyTNTRock, 1); 
/* 241 */         if (this.rock_type == 9) dropItem(OreSpawnMain.MyCrystalRedRock, 1); 
/* 242 */         if (this.rock_type == 10) dropItem(OreSpawnMain.MyCrystalGreenRock, 1); 
/* 243 */         if (this.rock_type == 11) dropItem(OreSpawnMain.MyCrystalBlueRock, 1); 
/* 244 */         if (this.rock_type == 12) dropItem(OreSpawnMain.MyCrystalTNTRock, 1);
/*     */       
/*     */       } 
/*     */     } 
/* 248 */     setDead();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 258 */     int x = (int)this.posX;
/* 259 */     int y = (int)this.posY;
/* 260 */     int z = (int)this.posZ;
/* 261 */     super.onUpdate();
/* 262 */     this.my_rotation += 30.0F;
/* 263 */     this.my_rotation %= 360.0F;
/* 264 */     this.rotationPitch = this.prevRotationPitch = this.my_rotation;
/* 265 */     this.myage++;
/* 266 */     if (this.myage > 1000) setDead(); 
/* 267 */     if (this.worldObj.isRemote) {
/* 268 */       this.rock_type = getRockType();
/*     */     } else {
/* 270 */       setRockType(this.rock_type);
/*     */     } 
/*     */ 
/*     */     
/* 274 */     Block bid = this.worldObj.getBlock(x, y, z);
/*     */     
/* 276 */     if (bid == Blocks.water)
/*     */     {
/*     */       
/* 279 */       if (this.motionY < -0.15000000596046448D && this.motionY > -0.550000011920929D && (float)(this.motionX * this.motionX + this.motionZ * this.motionZ) > 0.5F) {
/* 280 */         this.motionY = -(this.motionY * 3.0D / 4.0D);
/* 281 */         this.motionX = this.motionX * 3.0D / 4.0D;
/* 282 */         this.motionZ = this.motionZ * 3.0D / 4.0D;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EntityThrownRock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */