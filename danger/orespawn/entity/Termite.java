/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.util.ai.MyEntityAIWanderALot;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class Termite
/*     */   extends Ant
/*     */ {
/*  25 */   int attack_delay = 20; private int closest; private int tx;
/*     */   private int ty;
/*     */   private int tz;
/*     */   
/*  29 */   public Termite(World par1World) { super(par1World);
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
/* 184 */     this.closest = 99999;
/* 185 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.2F, 0.2F); this.moveSpeed = 0.20000000298023224D; this.experienceValue = 1; this.tasks.addTask(0, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.399999976158142D)); this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 8, 1.0D)); }
/*     */   protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*     */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/* 188 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D); } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 193 */     for (i = -dy; i <= dy; i++) {
/* 194 */       for (int j = -dz; j <= dz; j++) {
/* 195 */         Block bid = this.world.getBlockState(new BlockPos(x + dx, y + i, z + j)).getBlock();
/* 196 */         if (isWood(bid)) {
/* 197 */           int d = dx * dx + j * j + i * i;
/* 198 */           if (d < this.closest) {
/* 199 */             this.closest = d;
/* 200 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 201 */             found++;
/*     */           } 
/*     */         } 
/* 204 */         bid = this.world.getBlockState(new BlockPos(x - dx, y + i, z + j)).getBlock();
/* 205 */         if (isWood(bid)) {
/* 206 */           int d = dx * dx + j * j + i * i;
/* 207 */           if (d < this.closest) {
/* 208 */             this.closest = d;
/* 209 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 210 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 216 */     for (i = -dx; i <= dx; i++) {
/* 217 */       for (int j = -dz; j <= dz; j++) {
/* 218 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + dy, z + j)).getBlock();
/* 219 */         if (isWood(bid)) {
/* 220 */           int d = dy * dy + j * j + i * i;
/* 221 */           if (d < this.closest) {
/* 222 */             this.closest = d;
/* 223 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 224 */             found++;
/*     */           } 
/*     */         } 
/* 227 */         bid = this.world.getBlockState(new BlockPos(x + i, y - dy, z + j)).getBlock();
/* 228 */         if (isWood(bid)) {
/* 229 */           int d = dy * dy + j * j + i * i;
/* 230 */           if (d < this.closest) {
/* 231 */             this.closest = d;
/* 232 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 233 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 239 */     for (i = -dx; i <= dx; i++) {
/* 240 */       for (int j = -dy; j <= dy; j++) {
/* 241 */         Block bid = this.world.getBlockState(new BlockPos(x + i, y + j, z + dz)).getBlock();
/* 242 */         if (isWood(bid)) {
/* 243 */           int d = dz * dz + j * j + i * i;
/* 244 */           if (d < this.closest) {
/* 245 */             this.closest = d;
/* 246 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 247 */             found++;
/*     */           } 
/*     */         } 
/* 250 */         bid = this.world.getBlockState(new BlockPos(x + i, y + j, z - dz)).getBlock();
/* 251 */         if (isWood(bid)) {
/* 252 */           int d = dz * dz + j * j + i * i;
/* 253 */           if (d < this.closest) {
/* 254 */             this.closest = d;
/* 255 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 256 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 262 */     if (found != 0) return true; 
/* 263 */     return false; }
/*     */    public int mygetMaxHealth() {
/*     */     return 5;
/*     */   } public boolean attackEntityAsMob(Entity par1Entity) {
/*     */     if (OreSpawnMain.OreSpawnRand.nextInt(15) != 0)
/*     */       return false; 
/*     */     if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL)
/*     */       return false; 
/*     */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 1.0F);
/*     */     return var4;
/*     */   } public void updateAITick() {
/* 274 */     if (this.isDead)
/* 275 */       return;  if (this.world.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 276 */     if (this.world.rand.nextInt(200) == 1 && OreSpawnMain.PlayNicely == 0) {
/*     */ 
/*     */ 
/*     */       
/* 280 */       this.closest = 99999;
/* 281 */       this.tx = this.ty = this.tz = 0; int i;
/* 282 */       for (i = 1; i < 8; i++) {
/* 283 */         int j = i;
/* 284 */         if (j > 4) j = 4; 
/* 285 */         if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i) == true)
/* 286 */           break;  if (i >= 5) i++; 
/*     */       } 
/* 288 */       i = 0;
/* 289 */       if (this.closest < 99999) {
/*     */         
/* 291 */         getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 292 */         if (this.closest < 6) {
/*     */           
/* 294 */           if (this.world.rand.nextInt(3) != 0) {
/* 295 */             if (this.world.getGameRules().getBoolean("mobGriefing")) {
/* 296 */               this.world.setBlockState(new BlockPos(this.tx, this.ty, this.tz), Blocks.DIRT.getDefaultState());
/*     */             }
/* 298 */             if (findBuddies() < 10)
/* 299 */               spawnCreature(this.world, "Termite", this.posX + 0.10000000149011612D, this.posY + 0.10000000149011612D, this.posZ + 0.10000000149011612D); 
/*     */           } else {
/* 301 */             if (this.world.getGameRules().getBoolean("mobGriefing")) {
/* 302 */               this.world.setBlockToAir(new BlockPos(this.tx, this.ty, this.tz));
/*     */             }
/* 304 */             if (findBuddies() < 10)
/* 305 */               spawnCreature(this.world, "Termite", (this.tx + 0.1F), (this.ty + 0.1F), (this.tz + 0.1F)); 
/*     */           } 
/* 307 */           heal(1.0F);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 314 */     super.updateAITick(); } public void onUpdate() { super.onUpdate(); if (this.isDead)
/*     */       return;  if (this.attack_delay > 0)
/*     */       this.attack_delay--;  if (this.attack_delay > 0)
/*     */       return;  this.attack_delay = 20; if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL)
/*     */       return;  EntityPlayer entityPlayer = this.world.getNearestAttackablePlayer((Entity)this, 1.5D, 1.5D); if (entityPlayer != null)
/*     */       attackEntityAsMob((Entity)entityPlayer);  }
/* 320 */   private int findBuddies() { List var5 = this.world.getEntitiesWithinAABB(Termite.class, getEntityBoundingBox().expand(3.0D, 3.0D, 3.0D));
/* 321 */     return var5.size(); }
/*     */    private boolean isWood(Block bid) {
/*     */     if (bid == Blocks.LOG)
/*     */       return true; 
/*     */     if (bid == Blocks.OAK_FENCE || bid == Blocks.OAK_FENCE_GATE || bid == Blocks.STANDING_SIGN || bid == Blocks.BIRCH_FENCE || bid == Blocks.BIRCH_FENCE_GATE || bid == Blocks.ACACIA_FENCE || bid == Blocks.ACACIA_FENCE_GATE || bid == Blocks.JUNGLE_FENCE || bid == Blocks.JUNGLE_FENCE_GATE || bid == Blocks.SPRUCE_FENCE || bid == Blocks.SPRUCE_FENCE_GATE || bid == Blocks.DARK_OAK_FENCE || bid == Blocks.DARK_OAK_FENCE_GATE || bid == Blocks.DOUBLE_WOODEN_SLAB || bid == Blocks.BED || bid == Blocks.ACACIA_STAIRS || bid == Blocks.OAK_STAIRS || bid == Blocks.DARK_OAK_STAIRS || bid == Blocks.BIRCH_STAIRS || bid == Blocks.JUNGLE_STAIRS || bid == Blocks.ACACIA_DOOR || bid == Blocks.OAK_DOOR || bid == Blocks.DARK_OAK_DOOR || bid == Blocks.BIRCH_DOOR || bid == Blocks.JUNGLE_DOOR || bid == Blocks.SPRUCE_DOOR || bid == Blocks.SPRUCE_STAIRS || bid == Blocks.WOODEN_PRESSURE_PLATE || bid == Blocks.WOODEN_SLAB || bid == Blocks.BOOKSHELF || bid == Blocks.CRAFTING_TABLE)
/*     */       return true; 
/*     */     return false;
/*     */   }
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 330 */     Entity var8 = null;
/* 331 */     var8 = EntityList.createEntityByIDFromName(new ResourceLocation(par1), par0World);
/*     */     
/* 333 */     if (var8 != null) {
/*     */ 
/*     */       
/* 336 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 339 */       par0World.spawnEntity(var8);
/*     */     } 
/*     */     
/* 342 */     return var8;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\Termite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */