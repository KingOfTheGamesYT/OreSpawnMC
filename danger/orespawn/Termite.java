/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.world.EnumDifficulty;
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
/*     */ public class Termite
/*     */   extends EntityAnt
/*     */ {
/*  41 */   int attack_delay = 20;
/*     */   private int closest;
/*     */   private int tx; private int ty; private int tz; protected void applyEntityAttributes() { super.applyEntityAttributes(); getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*     */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  45 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D); } public int mygetMaxHealth() { return 5; } public Termite(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     this.closest = 99999;
/* 175 */     this.tx = 0; this.ty = 0; this.tz = 0; setSize(0.2F, 0.2F); this.moveSpeed = 0.20000000298023224D; this.experienceValue = 1; getNavigator().setAvoidsWater(true); this.tasks.addTask(0, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.399999976158142D)); this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, EntityPlayer.class, 1.0D, false)); this.tasks.addTask(2, new MyEntityAIWanderALot((EntityCreature)this, 8, 1.0D)); if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, 6, true));  }
/*     */   public boolean attackEntityAsMob(Entity par1Entity) { if (OreSpawnMain.OreSpawnRand.nextInt(15) != 0)
/*     */       return false;  if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL)
/* 178 */       return false;  boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 1.0F); return var4; } private boolean scan_it(int x, int y, int z, int dx, int dy, int dz) { int found = 0;
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/* 183 */     for (i = -dy; i <= dy; i++) {
/* 184 */       for (int j = -dz; j <= dz; j++) {
/* 185 */         Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
/* 186 */         if (isWood(bid)) {
/* 187 */           int d = dx * dx + j * j + i * i;
/* 188 */           if (d < this.closest) {
/* 189 */             this.closest = d;
/* 190 */             this.tx = x + dx; this.ty = y + i; this.tz = z + j;
/* 191 */             found++;
/*     */           } 
/*     */         } 
/* 194 */         bid = this.worldObj.getBlock(x - dx, y + i, z + j);
/* 195 */         if (isWood(bid)) {
/* 196 */           int d = dx * dx + j * j + i * i;
/* 197 */           if (d < this.closest) {
/* 198 */             this.closest = d;
/* 199 */             this.tx = x - dx; this.ty = y + i; this.tz = z + j;
/* 200 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 206 */     for (i = -dx; i <= dx; i++) {
/* 207 */       for (int j = -dz; j <= dz; j++) {
/* 208 */         Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
/* 209 */         if (isWood(bid)) {
/* 210 */           int d = dy * dy + j * j + i * i;
/* 211 */           if (d < this.closest) {
/* 212 */             this.closest = d;
/* 213 */             this.tx = x + i; this.ty = y + dy; this.tz = z + j;
/* 214 */             found++;
/*     */           } 
/*     */         } 
/* 217 */         bid = this.worldObj.getBlock(x + i, y - dy, z + j);
/* 218 */         if (isWood(bid)) {
/* 219 */           int d = dy * dy + j * j + i * i;
/* 220 */           if (d < this.closest) {
/* 221 */             this.closest = d;
/* 222 */             this.tx = x + i; this.ty = y - dy; this.tz = z + j;
/* 223 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 229 */     for (i = -dx; i <= dx; i++) {
/* 230 */       for (int j = -dy; j <= dy; j++) {
/* 231 */         Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
/* 232 */         if (isWood(bid)) {
/* 233 */           int d = dz * dz + j * j + i * i;
/* 234 */           if (d < this.closest) {
/* 235 */             this.closest = d;
/* 236 */             this.tx = x + i; this.ty = y + j; this.tz = z + dz;
/* 237 */             found++;
/*     */           } 
/*     */         } 
/* 240 */         bid = this.worldObj.getBlock(x + i, y + j, z - dz);
/* 241 */         if (isWood(bid)) {
/* 242 */           int d = dz * dz + j * j + i * i;
/* 243 */           if (d < this.closest) {
/* 244 */             this.closest = d;
/* 245 */             this.tx = x + i; this.ty = y + j; this.tz = z - dz;
/* 246 */             found++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 252 */     if (found != 0) return true; 
/* 253 */     return false; } public boolean interact(EntityPlayer par1EntityPlayer) { if (par1EntityPlayer == null)
/*     */       return false;  if (!(par1EntityPlayer instanceof EntityPlayerMP))
/*     */       return false;  ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem(); if (var2 != null && var2.stackSize <= 0) { par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null); var2 = null; }
/*     */      if (var2 != null) { par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText("Empty your hand!")); return false; }
/*     */      if (par1EntityPlayer.dimension != OreSpawnMain.DimensionID5) { int i; for (i = 0; i < par1EntityPlayer.inventory.mainInventory.length; i++) { if (par1EntityPlayer.inventory.mainInventory[i] != null) { par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText("Empty your inventory!")); return false; }
/*     */          }
/*     */        for (i = 0; i < par1EntityPlayer.inventory.armorInventory.length; i++) { if (par1EntityPlayer.inventory.armorInventory[i] != null) { par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText("Take off your armor!")); return false; }
/*     */          }
/*     */        MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)par1EntityPlayer, OreSpawnMain.DimensionID5, new OreSpawnTeleporter(MinecraftServer.getServer().worldServerForDimension(OreSpawnMain.DimensionID5), OreSpawnMain.DimensionID5, this.worldObj)); }
/*     */     else { MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)par1EntityPlayer, 0, new OreSpawnTeleporter(MinecraftServer.getServer().worldServerForDimension(0), 0, this.worldObj)); }
/*     */      return true; }
/* 264 */   public void updateAITick() { if (this.isDead)
/* 265 */       return;  if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 266 */     if (this.worldObj.rand.nextInt(200) == 1 && OreSpawnMain.PlayNicely == 0) {
/*     */ 
/*     */ 
/*     */       
/* 270 */       this.closest = 99999;
/* 271 */       this.tx = this.ty = this.tz = 0; int i;
/* 272 */       for (i = 1; i < 8; i++) {
/* 273 */         int j = i;
/* 274 */         if (j > 4) j = 4; 
/* 275 */         if (scan_it((int)this.posX, (int)this.posY + 1, (int)this.posZ, i, j, i) == true)
/* 276 */           break;  if (i >= 5) i++; 
/*     */       } 
/* 278 */       i = 0;
/* 279 */       if (this.closest < 99999) {
/*     */         
/* 281 */         getNavigator().tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0D);
/* 282 */         if (this.closest < 6) {
/*     */           
/* 284 */           if (this.worldObj.rand.nextInt(3) != 0) {
/* 285 */             if (this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.dirt, 0, 2); 
/* 286 */             if (findBuddies() < 10)
/* 287 */               spawnCreature(this.worldObj, "Termite", this.posX + 0.10000000149011612D, this.posY + 0.10000000149011612D, this.posZ + 0.10000000149011612D); 
/*     */           } else {
/* 289 */             if (this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2); 
/* 290 */             if (findBuddies() < 10)
/* 291 */               spawnCreature(this.worldObj, "Termite", (this.tx + 0.1F), (this.ty + 0.1F), (this.tz + 0.1F)); 
/*     */           } 
/* 293 */           heal(1.0F);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 300 */     super.updateAITick(); } public void onUpdate() { super.onUpdate(); if (this.isDead) return;  if (this.attack_delay > 0) this.attack_delay--;  if (this.attack_delay > 0) return;  this.attack_delay = 20; if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return;  EntityPlayer entityPlayer = this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, 1.5D); if (entityPlayer != null) attackEntityAsMob((Entity)entityPlayer);  }
/*     */   public boolean isWood(Block bid) { if (bid == Blocks.fence || bid == Blocks.fence_gate || bid == Blocks.planks || bid == Blocks.wooden_slab) return true;  if (bid == Blocks.double_wooden_slab || bid == Blocks.bed || bid == Blocks.crafting_table)
/*     */       return true;  if (bid == Blocks.standing_sign || bid == Blocks.bookshelf || bid == Blocks.wooden_door || bid == Blocks.wooden_pressure_plate)
/*     */       return true;  if (bid == Blocks.birch_stairs || bid == Blocks.oak_stairs || bid == Blocks.jungle_stairs || bid == Blocks.spruce_stairs)
/*     */       return true;  if (bid == OreSpawnMain.CrystalPlanksBlock)
/*     */       return true;  return false; }
/* 306 */   private int findBuddies() { List var5 = this.worldObj.getEntitiesWithinAABB(Termite.class, this.boundingBox.expand(3.0D, 3.0D, 3.0D));
/* 307 */     return var5.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 316 */     Entity var8 = null;
/* 317 */     var8 = EntityList.createEntityByName(par1, par0World);
/* 318 */     if (var8 != null) {
/*     */ 
/*     */       
/* 321 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 324 */       par0World.spawnEntityInWorld(var8);
/*     */     } 
/* 326 */     return var8;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Termite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */