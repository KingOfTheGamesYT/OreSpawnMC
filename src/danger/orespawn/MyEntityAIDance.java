/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MyEntityAIDance
/*     */   extends EntityAIBase
/*     */ {
/*     */   private Girlfriend thePet;
/*     */   World theWorld;
/*  24 */   public int ticker = 0;
/*  25 */   public int dance_move = 0;
/*  26 */   public int is_dancing = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MyEntityAIDance(Girlfriend par1EntityTameable) {
/*  32 */     this.thePet = par1EntityTameable;
/*  33 */     this.theWorld = par1EntityTameable.worldObj;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is_dance_block(Block bid) {
/*  38 */     if (bid == Blocks.gold_block || bid == Blocks.diamond_block || bid == Blocks.emerald_block || bid == OreSpawnMain.MyBlockRubyBlock || bid == OreSpawnMain.MyBlockAmethystBlock || bid == OreSpawnMain.MyBlockTitaniumBlock || bid == OreSpawnMain.MyBlockUraniumBlock)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  45 */       return true;
/*     */     }
/*     */     
/*  48 */     return false;
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
/*     */   public boolean shouldExecute() {
/*  61 */     if (this.thePet.isSitting()) return false;
/*     */     
/*  63 */     long t = this.theWorld.getWorldTime();
/*  64 */     t %= 24000L;
/*  65 */     if (t < 14000L || t > 22000L) return false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  71 */     int ic = 0, iz = ic, ix = iz;
/*  72 */     for (int i = -3; i < 4; i++) {
/*  73 */       for (int j = -3; j < 4; j++) {
/*  74 */         Block bid = this.theWorld.getBlock((int)this.thePet.posX + i, (int)this.thePet.posY - 1, (int)this.thePet.posZ + j);
/*  75 */         if (is_dance_block(bid)) {
/*  76 */           ic++;
/*  77 */           ix += i;
/*  78 */           iz += j;
/*     */         } 
/*     */       } 
/*     */     } 
/*  82 */     if (ic == 0) return false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     return true;
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
/*     */   public boolean continueExecuting() {
/* 100 */     if (this.thePet.isSitting()) return false;
/*     */     
/* 102 */     long t = this.theWorld.getWorldTime();
/* 103 */     t %= 24000L;
/* 104 */     if (t < 14000L || t > 22000L) return false;
/*     */     
/* 106 */     int ic = 0, iz = ic, ix = iz;
/* 107 */     for (int i = -3; i < 4; i++) {
/* 108 */       for (int j = -3; j < 4; j++) {
/* 109 */         Block bid = this.theWorld.getBlock((int)this.thePet.posX + i, (int)this.thePet.posY - 1, (int)this.thePet.posZ + j);
/* 110 */         if (is_dance_block(bid)) {
/* 111 */           ic++;
/* 112 */           ix += i;
/* 113 */           iz += j;
/*     */         } 
/*     */       } 
/*     */     } 
/* 117 */     if (ic == 0) return false; 
/* 118 */     ix /= ic;
/* 119 */     iz /= ic;
/* 120 */     if (ic < 40) {
/* 121 */       this.thePet.getNavigator().tryMoveToXYZ(((int)this.thePet.posX + ix), (int)this.thePet.posY, ((int)this.thePet.posZ + iz), 1.0D);
/*     */     
/*     */     }
/* 124 */     else if (this.theWorld.rand.nextInt(3) == 1) {
/* 125 */       this.thePet.getNavigator().tryMoveToXYZ((int)this.thePet.posX, (int)this.thePet.posY, (int)this.thePet.posZ, 1.0D);
/*     */     } 
/*     */     
/* 128 */     this.is_dancing = 1;
/* 129 */     return true;
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
/*     */   public void startExecuting() {
/* 141 */     this.thePet.setSneaking(false);
/* 142 */     this.ticker = 0;
/* 143 */     this.dance_move = 0;
/* 144 */     this.is_dancing = 1;
/*     */     
/* 146 */     int ic = 0, iz = ic, ix = iz;
/* 147 */     for (int i = -3; i < 4; i++) {
/* 148 */       for (int j = -3; j < 4; j++) {
/* 149 */         Block bid = this.theWorld.getBlock((int)this.thePet.posX + i, (int)this.thePet.posY - 1, (int)this.thePet.posZ + j);
/* 150 */         if (is_dance_block(bid)) {
/* 151 */           ic++;
/* 152 */           ix += i;
/* 153 */           iz += j;
/*     */         } 
/*     */       } 
/*     */     } 
/* 157 */     if (ic > 0) {
/* 158 */       ix /= ic;
/* 159 */       iz /= ic;
/* 160 */       if (ic < 40) {
/* 161 */         this.thePet.getNavigator().tryMoveToXYZ(((int)this.thePet.posX + ix), (int)this.thePet.posY, ((int)this.thePet.posZ + iz), 1.0D);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetTask() {
/* 172 */     this.thePet.setSneaking(false);
/* 173 */     this.ticker = 0;
/* 174 */     this.dance_move = 0;
/* 175 */     this.is_dancing = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTask() {
/* 184 */     int cycle = 20;
/* 185 */     int halfc = cycle / 2;
/* 186 */     int mover = cycle * 8;
/* 187 */     int tempid = this.thePet.getEntityId();
/*     */ 
/*     */     
/* 190 */     AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(this.thePet.posX - 4.0D, this.thePet.posY - 3.0D, this.thePet.posZ - 4.0D, this.thePet.posX + 4.0D, this.thePet.posY + 3.0D, this.thePet.posZ + 4.0D);
/* 191 */     List var5 = this.theWorld.getEntitiesWithinAABB(Girlfriend.class, bb);
/* 192 */     Iterator<Girlfriend> var2 = var5.iterator();
/* 193 */     while (var2.hasNext()) {
/*     */       
/* 195 */       Girlfriend var3 = var2.next();
/* 196 */       if (var3.getEntityId() < tempid) {
/*     */         
/* 198 */         if (var3.Dance.is_dancing == 1) {
/* 199 */           this.ticker = var3.Dance.ticker;
/* 200 */           this.dance_move = var3.Dance.dance_move;
/*     */         } 
/* 202 */         tempid = var3.getEntityId();
/*     */       } 
/*     */     } 
/*     */     
/* 206 */     this.ticker++;
/*     */ 
/*     */     
/* 209 */     if (this.dance_move == 0) {
/* 210 */       this.dance_move = 1 + this.theWorld.rand.nextInt(10);
/* 211 */       this.thePet.motionX = 0.0D;
/* 212 */       this.thePet.motionZ = 0.0D;
/* 213 */       this.ticker = 0;
/* 214 */       this.thePet.setSneaking(false);
/*     */     } 
/*     */     
/* 217 */     switch (this.dance_move) {
/*     */       case 1:
/* 219 */         move_it(this.thePet, this.ticker, cycle, 0);
/* 220 */         if (this.ticker > mover) this.dance_move = 0; 
/*     */         return;
/*     */       case 2:
/* 223 */         move_it(this.thePet, this.ticker, cycle, 1);
/* 224 */         if (this.ticker > mover) this.dance_move = 0; 
/*     */         return;
/*     */       case 3:
/* 227 */         if (this.ticker % cycle < halfc) {
/* 228 */           this.thePet.setSneaking(false);
/*     */         } else {
/* 230 */           this.thePet.setSneaking(true);
/*     */         } 
/* 232 */         if (this.ticker > mover) this.dance_move = 0; 
/*     */         return;
/*     */       case 4:
/* 235 */         if (this.ticker % halfc == 1) {
/* 236 */           this.thePet.swingItem();
/* 237 */           this.thePet.motionY = 0.25D;
/*     */         } 
/*     */         
/* 240 */         if (this.ticker > mover) this.dance_move = 0; 
/*     */         return;
/*     */       case 5:
/* 243 */         if (this.ticker % halfc == 1) {
/* 244 */           this.thePet.swingItem();
/*     */         }
/* 246 */         move_it(this.thePet, this.ticker, cycle, 0);
/* 247 */         if (this.ticker > mover) this.dance_move = 0; 
/*     */         return;
/*     */       case 6:
/* 250 */         if (this.ticker % halfc == 1) {
/* 251 */           this.thePet.swingItem();
/*     */         }
/* 253 */         move_it(this.thePet, this.ticker, cycle, 1);
/* 254 */         if (this.ticker > mover) this.dance_move = 0; 
/*     */         return;
/*     */       case 7:
/* 257 */         if (this.ticker % cycle < halfc) {
/* 258 */           this.thePet.setSneaking(false);
/*     */         } else {
/* 260 */           this.thePet.setSneaking(true);
/*     */         } 
/* 262 */         move_it(this.thePet, this.ticker, cycle, 0);
/* 263 */         move_it(this.thePet, this.ticker, cycle, 2);
/* 264 */         if (this.ticker > mover) this.dance_move = 0; 
/*     */         return;
/*     */       case 8:
/* 267 */         if (this.ticker % cycle < halfc) {
/* 268 */           this.thePet.setSneaking(false);
/*     */         } else {
/* 270 */           this.thePet.setSneaking(true);
/*     */         } 
/* 272 */         move_it(this.thePet, this.ticker, cycle, 1);
/* 273 */         move_it(this.thePet, this.ticker, cycle, 2);
/* 274 */         if (this.ticker > mover) this.dance_move = 0; 
/*     */         return;
/*     */       case 9:
/* 277 */         if (this.ticker % cycle < halfc) {
/* 278 */           this.thePet.setSneaking(false);
/*     */         } else {
/* 280 */           this.thePet.setSneaking(true);
/*     */         } 
/* 282 */         if (this.ticker % halfc == 1) {
/* 283 */           this.thePet.swingItem();
/*     */         }
/* 285 */         move_it(this.thePet, this.ticker, cycle, 0);
/* 286 */         move_it(this.thePet, this.ticker, cycle, 3);
/* 287 */         if (this.ticker > mover) this.dance_move = 0; 
/*     */         return;
/*     */       case 10:
/* 290 */         if (this.ticker % cycle < halfc) {
/* 291 */           this.thePet.setSneaking(false);
/* 292 */           this.thePet.motionY = 0.25D;
/*     */         } else {
/* 294 */           this.thePet.setSneaking(true);
/*     */         } 
/* 296 */         if (this.ticker % halfc == 1) {
/* 297 */           this.thePet.swingItem();
/*     */         }
/* 299 */         move_it(this.thePet, this.ticker, cycle, 1);
/* 300 */         move_it(this.thePet, this.ticker, cycle, 3);
/* 301 */         if (this.ticker > mover) this.dance_move = 0; 
/*     */         return;
/*     */     } 
/* 304 */     this.dance_move = 0;
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
/*     */   private void move_it(EntityTameable et, int t, int cycle, int dir) {
/* 316 */     float dirx = 0.0F, dirz = 0.0F, dirYaw = 0.0F, dirYawH = 0.0F;
/*     */     
/* 318 */     switch (dir) {
/*     */       case 0:
/* 320 */         dirx = 0.02F;
/* 321 */         dirz = 0.0F;
/* 322 */         dirYaw = 0.0F;
/* 323 */         dirYawH = 0.0F;
/*     */         break;
/*     */       case 1:
/* 326 */         dirx = 0.0F;
/* 327 */         dirz = 0.02F;
/* 328 */         dirYaw = 0.0F;
/* 329 */         dirYawH = 0.0F;
/*     */         break;
/*     */       case 2:
/* 332 */         dirx = 0.0F;
/* 333 */         dirz = 0.0F;
/* 334 */         dirYaw = 10.0F;
/* 335 */         dirYawH = 0.0F;
/*     */         break;
/*     */       case 3:
/* 338 */         dirx = 0.0F;
/* 339 */         dirz = 0.0F;
/* 340 */         dirYaw = 0.0F;
/* 341 */         dirYawH = 10.0F;
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 346 */     t %= cycle;
/* 347 */     if (t >= cycle / 2) {
/* 348 */       dirx = -dirx;
/* 349 */       dirz = -dirz;
/* 350 */       dirYaw = -dirYaw;
/* 351 */       dirYawH = -dirYawH;
/*     */     } 
/*     */ 
/*     */     
/* 355 */     t %= cycle / 2;
/* 356 */     if (t >= cycle / 4) {
/* 357 */       dirYaw = -dirYaw;
/* 358 */       dirYawH = -dirYawH;
/*     */     } 
/*     */     
/* 361 */     et.motionX += dirx;
/* 362 */     et.motionZ += dirz;
/* 363 */     et.rotationYaw += dirYaw;
/* 364 */     et.rotationYawHead += dirYawH;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MyEntityAIDance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */