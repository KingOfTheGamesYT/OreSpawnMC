/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.init.ModBlocks;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.passive.IAnimals;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Moth
/*     */   extends EntityCreature
/*     */   implements IAnimals
/*     */ {
/*  22 */   private BlockPos currentFlightTarget = null;
/*  23 */   public int moth_type = 0;
/*     */   private int closest; private int tx; private int ty; private int tz; public void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D); getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);
/*     */     getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
/*  26 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D); } public Moth(World par1World) { super(par1World);
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
/*  55 */     this.closest = 99999;
/*  56 */     this.tx = 0; this.ty = 0; this.tz = 0;
/*     */     this.moth_type = OreSpawnMain.OreSpawnRand.nextInt(4);
/*     */     setSize(0.5F, 0.5F); } protected void collideWithEntity(Entity par1Entity) {} private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) {
/*  59 */     int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/*  64 */     for (i = -dy; i <= dy; i++) {
/*  65 */       for (int j = -dz; j <= dz; j++) {
/*  66 */         Block bid = this.world.getBlockState(new BlockPos(x + dx, y + i, z + j)).getBlock();
/*  67 */         if (bid == Blocks.TORCH || bid == ModBlocks.EXTREME_TORCH) {
/*  68 */           int d = dx * dx + j * j + i * i;
/*  69 */           if (d < this.closest) {
/*  70 */             this.closest = d;
/*  71 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/*  72 */             found++;
/*     */           } 
/*     */         } 
/*  75 */         bid = this.world.getBlockState(new BlockPos(x - dx, y + i, z + j)).getBlock();
/*  76 */         if (bid == Blocks.TORCH || bid == ModBlocks.EXTREME_TORCH) {
/*  77 */           int d = dx * dx + j * j + i * i;
/*  78 */           if (d < this.closest) {
/*  79 */             this.closest = d;
/*  80 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/*  81 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  87 */     for (i = -dx; i <= dx; i++) {
/*  88 */       for (int j = -dz; j <= dz; j++) {
/*  89 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + dy, z + j)).getBlock();
/*  90 */         if (bid == Blocks.TORCH || bid == ModBlocks.EXTREME_TORCH) {
/*  91 */           int d = dy * dy + j * j + i * i;
/*  92 */           if (d < this.closest) {
/*  93 */             this.closest = d;
/*  94 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/*  95 */             found++;
/*     */           } 
/*     */         } 
/*  98 */         bid = this.world.getBlockState(new BlockPos(x + i, y - dy, z + j)).getBlock();
/*  99 */         if (bid == Blocks.TORCH || bid == ModBlocks.EXTREME_TORCH) {
/* 100 */           int d = dy * dy + j * j + i * i;
/* 101 */           if (d < this.closest) {
/* 102 */             this.closest = d;
/* 103 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 104 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 110 */     for (i = -dx; i <= dx; i++) {
/* 111 */       for (int j = -dy; j <= dy; j++) {
/* 112 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + j, z + dz)).getBlock();
/* 113 */         if (bid == Blocks.TORCH || bid == ModBlocks.EXTREME_TORCH) {
/* 114 */           int d = dz * dz + j * j + i * i;
/* 115 */           if (d < this.closest) {
/* 116 */             this.closest = d;
/* 117 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 118 */             found++;
/*     */           } 
/*     */         } 
/* 121 */         bid = this.world.getBlockState(new BlockPos(x + i, y + j, z - dz)).getBlock();
/* 122 */         if (bid == Blocks.TORCH || bid == ModBlocks.EXTREME_TORCH) {
/* 123 */           int d = dz * dz + j * j + i * i;
/* 124 */           if (d < this.closest) {
/* 125 */             this.closest = d;
/* 126 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 127 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 133 */     if (found != 0) return true; 
/* 134 */     return false;
/*     */   } public boolean isAIDisabled() {
/*     */     return false;
/*     */   } public void onUpdate() {
/*     */     super.onUpdate();
/*     */     this.motionY *= 0.6D;
/*     */   } public void updateAITasks() {
/* 141 */     int keep_trying = 25;
/*     */     
/* 143 */     if (this.isDead)
/* 144 */       return;  super.updateAITasks();
/*     */ 
/*     */     
/* 147 */     if (this.currentFlightTarget == null) {
/* 148 */       this.currentFlightTarget = new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/* 150 */     if (this.rand.nextInt(100) == 0 || this.currentFlightTarget.distanceSq((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0D) {
/*     */       
/* 152 */       Block bid = Blocks.STONE;
/* 153 */       while (bid != Blocks.AIR && keep_trying != 0) {
/* 154 */         this.currentFlightTarget = new BlockPos((int)this.posX + this.rand.nextInt(10) - this.rand.nextInt(10), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(10) - this.rand.nextInt(10));
/* 155 */         bid = this.world.getBlockState(new BlockPos(this.currentFlightTarget.getX(), this.currentFlightTarget.getY(), this.currentFlightTarget.getZ())).getBlock();
/* 156 */         keep_trying--;
/*     */       }
/*     */     
/* 159 */     } else if (!this.world.isDaytime() && this.rand.nextInt(10) == 0) {
/*     */       
/* 161 */       this.closest = 99999;
/* 162 */       this.tx = this.ty = this.tz = 0;
/* 163 */       for (int i = 2; i < 15 && 
/* 164 */         !scan_it((int)this.posX, (int)this.posY, (int)this.posZ, i, i, i); i++) {
/* 165 */         if (i >= 6) i++;
/*     */       
/*     */       } 
/* 168 */       if (this.closest < 99999)
/*     */       {
/* 170 */         this.currentFlightTarget = new BlockPos(this.tx, this.ty + 1, this.tz);
/*     */       }
/*     */     } 
/*     */     
/* 174 */     double var1 = this.currentFlightTarget.getX() + 0.5D - this.posX;
/* 175 */     double var3 = this.currentFlightTarget.getY() + 0.1D - this.posY;
/* 176 */     double var5 = this.currentFlightTarget.getZ() + 0.5D - this.posZ;
/* 177 */     this.motionX += (Math.signum(var1) * 0.5D - this.motionX) * 0.10000000149011612D;
/* 178 */     this.motionY += (Math.signum(var3) * 0.68D - this.motionY) * 0.10000000149011612D;
/* 179 */     this.motionZ += (Math.signum(var5) * 0.5D - this.motionZ) * 0.10000000149011612D;
/* 180 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 181 */     float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
/* 182 */     this.moveForward = 0.75F;
/* 183 */     this.rotationYaw += var8;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fall(float distance, float damageMultiplier) {}
/*     */ 
/*     */   
/*     */   protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}
/*     */ 
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 194 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 199 */     Block bid = this.world.getBlockState(new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ)).getBlock();
/* 200 */     if (bid != Blocks.AIR) return false; 
/* 201 */     if (this.world.isDaytime()) return false;
/*     */     
/* 203 */     if (this.posY < 50.0D) return false; 
/* 204 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\Moth.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */