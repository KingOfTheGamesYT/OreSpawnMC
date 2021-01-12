/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityLunaMoth
/*     */   extends EntityButterfly
/*     */ {
/*  17 */   private ChunkCoordinates currentFlightTarget = null;
/*  18 */   public int moth_type = 0;
/*     */   private int closest; private int tx; private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes();
/*     */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*     */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612D);
/*  22 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D); } public EntityLunaMoth(World par1World) { super(par1World);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     this.closest = 99999;
/*  68 */     this.tx = 0; this.ty = 0; this.tz = 0;
/*     */     this.moth_type = OreSpawnMain.OreSpawnRand.nextInt(4);
/*     */     setSize(0.5F, 0.5F);
/*     */     getNavigator().setAvoidsWater(true); }
/*  72 */   protected void entityInit() { super.entityInit(); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/*  77 */     for (i = -dy; i <= dy; i++) {
/*  78 */       for (int j = -dz; j <= dz; j++) {
/*  79 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/*  80 */         if (bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) {
/*  81 */           int d = dx * dx + j * j + i * i;
/*  82 */           if (d < this.closest) {
/*  83 */             this.closest = d;
/*  84 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/*  85 */             found++;
/*     */           } 
/*     */         } 
/*  88 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/*  89 */         if (bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) {
/*  90 */           int d = dx * dx + j * j + i * i;
/*  91 */           if (d < this.closest) {
/*  92 */             this.closest = d;
/*  93 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/*  94 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 100 */     for (i = -dx; i <= dx; i++) {
/* 101 */       for (int j = -dz; j <= dz; j++) {
/* 102 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 103 */         if (bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) {
/* 104 */           int d = dy * dy + j * j + i * i;
/* 105 */           if (d < this.closest) {
/* 106 */             this.closest = d;
/* 107 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 108 */             found++;
/*     */           } 
/*     */         } 
/* 111 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 112 */         if (bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) {
/* 113 */           int d = dy * dy + j * j + i * i;
/* 114 */           if (d < this.closest) {
/* 115 */             this.closest = d;
/* 116 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 117 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 123 */     for (i = -dx; i <= dx; i++) {
/* 124 */       for (int j = -dy; j <= dy; j++) {
/* 125 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 126 */         if (bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) {
/* 127 */           int d = dz * dz + j * j + i * i;
/* 128 */           if (d < this.closest) {
/* 129 */             this.closest = d;
/* 130 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 131 */             found++;
/*     */           } 
/*     */         } 
/* 134 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 135 */         if (bid == Blocks.torch || bid == OreSpawnMain.ExtremeTorch) {
/* 136 */           int d = dz * dz + j * j + i * i;
/* 137 */           if (d < this.closest) {
/* 138 */             this.closest = d;
/* 139 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 140 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 146 */     if (found != 0) return true; 
/* 147 */     return false; } protected void collideWithEntity(Entity par1Entity) {} protected boolean isAIEnabled() {
/*     */     return true;
/*     */   } public void onUpdate() {
/*     */     super.onUpdate();
/*     */     this.motionY *= 0.6D;
/*     */   } protected void updateAITasks() {
/* 153 */     int keep_trying = 25;
/*     */     
/* 155 */     if (this.isDead)
/* 156 */       return;  super.updateAITasks();
/*     */ 
/*     */     
/* 159 */     if (this.currentFlightTarget == null) {
/* 160 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/* 162 */     if (this.rand.nextInt(100) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0F) {
/*     */       
/* 164 */       Block bid = Blocks.stone;
/* 165 */       while (bid != Blocks.air && keep_trying != 0) {
/* 166 */         this.currentFlightTarget.set((int)this.posX + this.rand.nextInt(10) - this.rand.nextInt(10), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(10) - this.rand.nextInt(10));
/* 167 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 168 */         keep_trying--;
/*     */       }
/*     */     
/* 171 */     } else if (!this.worldObj.isDaytime() && this.rand.nextInt(10) == 0) {
/*     */       
/* 173 */       this.closest = 99999;
/* 174 */       this.tx = this.ty = this.tz = 0;
/* 175 */       for (int i = 2; i < 15 && 
/* 176 */         scan_it((int)this.posX, (int)this.posY, (int)this.posZ, i, i, i) != true; i++) {
/* 177 */         if (i >= 6) i++;
/*     */       
/*     */       } 
/* 180 */       if (this.closest < 99999)
/*     */       {
/* 182 */         this.currentFlightTarget.set(this.tx, this.ty + 1, this.tz);
/*     */       }
/*     */     } 
/*     */     
/* 186 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 187 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 188 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 189 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.10000000149011612D;
/* 190 */     this.motionY += (Math.signum(var3) * 0.68D - this.motionY) * 0.10000000149011612D;
/* 191 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.10000000149011612D;
/* 192 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 193 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 194 */     this.moveForward = 0.75F;
/* 195 */     this.rotationYaw += var8;
/*     */   }
/*     */ 
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
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 216 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 225 */     Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY, (int)this.posZ);
/* 226 */     if (bid != Blocks.air) return false; 
/* 227 */     if (this.worldObj.isDaytime()) return false; 
/* 228 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) return true; 
/* 229 */     if (this.posY < 50.0D) return false; 
/* 230 */     return true;
/*     */   }
/*     */   
/*     */   public void initCreature() {}
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EntityLunaMoth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */