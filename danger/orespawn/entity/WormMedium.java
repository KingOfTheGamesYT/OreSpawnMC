/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.util.handlers.SoundsHandler;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class WormMedium
/*     */   extends EntityMob
/*     */ {
/*  26 */   public int upcount = 0;
/*  27 */   public int downcount = 0;
/*     */   
/*     */   public WormMedium(World par1World) {
/*  30 */     super(par1World);
/*  31 */     setSize(0.5F, 2.0F);
/*     */     
/*  33 */     this.experienceValue = 0;
/*  34 */     this.noClip = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  39 */     super.applyEntityAttributes();
/*  40 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  41 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);
/*  42 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  47 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  53 */     return 0.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  59 */     return 1.5F;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/*  64 */     return null;
/*     */   }
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/*  67 */     return SoundsHandler.LITTLE_SPLAT;
/*     */   }
/*     */   
/*     */   public void onDeath(DamageSource cause) {
/*  71 */     super.onDeath(cause);
/*  72 */     playSound(SoundsHandler.BIG_SPLAT, getSoundVolume(), getSoundPitch());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  86 */     return 30;
/*     */   }
/*     */   
/*     */   public boolean isAIDisabled() {
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public void onLivingUpdate() {
/*  94 */     Block bid = Blocks.AIR;
/*  95 */     EntityPlayer target = null;
/*  96 */     WormSmall worms = null;
/*  97 */     super.onLivingUpdate();
/*  98 */     if (this.world.isRemote)
/*     */       return; 
/* 100 */     worms = (WormSmall)this.world.findNearestEntityWithinAABB(WormSmall.class, getEntityBoundingBox().expand(8.0D, 8.0D, 8.0D), (Entity)this);
/* 101 */     if (worms == null) target = (EntityPlayer)this.world.findNearestEntityWithinAABB(EntityPlayer.class, getEntityBoundingBox().expand(8.0D, 8.0D, 8.0D), (Entity)this); 
/* 102 */     if ((worms == null && target != null) || OreSpawnMain.PlayNicely != 0) {
/*     */       
/* 104 */       if (this.upcount > 0) {
/* 105 */         this.upcount--;
/* 106 */         if (this.upcount == 0) this.downcount = 100 + this.world.rand.nextInt(150); 
/* 107 */         if (target != null) pointAtEntity((EntityLivingBase)target); 
/* 108 */         bid = this.world.getBlockState(new BlockPos((int)this.posX, (int)(this.posY + 0.25D), (int)this.posZ)).getBlock();
/*     */         
/* 110 */         if (bid == Blocks.TALLGRASS) bid = Blocks.AIR; 
/* 111 */         if (bid != Blocks.AIR) {
/* 112 */           if (bid != Blocks.GRASS && bid != Blocks.DIRT && bid != Blocks.STONE) setDead(); 
/* 113 */           this.motionY += 0.20000000298023224D;
/* 114 */           this.posY += 0.10000000149011612D;
/*     */         } 
/*     */       } else {
/* 117 */         if (this.downcount > 0) {
/* 118 */           this.downcount--;
/*     */         } else {
/* 120 */           this.upcount = 25 + this.world.rand.nextInt(75);
/*     */         } 
/* 122 */         bid = this.world.getBlockState(new BlockPos((int)this.posX, (int)this.posY + 3, (int)this.posZ)).getBlock();
/*     */         
/* 124 */         if (bid == Blocks.TALLGRASS) bid = Blocks.AIR; 
/* 125 */         if (bid != Blocks.AIR) {
/* 126 */           if (bid != Blocks.GRASS && bid != Blocks.DIRT && bid != Blocks.STONE) setDead(); 
/* 127 */           this.motionY += 0.10000000149011612D;
/* 128 */           this.posY += 0.05000000074505806D;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 132 */       this.upcount = this.world.rand.nextInt(50);
/* 133 */       this.downcount = 0;
/* 134 */       bid = this.world.getBlockState(new BlockPos((int)this.posX, (int)this.posY + 3, (int)this.posZ)).getBlock();
/*     */       
/* 136 */       if (bid == Blocks.TALLGRASS) bid = Blocks.AIR; 
/* 137 */       if (bid != Blocks.AIR) {
/* 138 */         if (bid != Blocks.GRASS && bid != Blocks.DIRT && bid != Blocks.STONE) setDead(); 
/* 139 */         this.motionY += 0.10000000149011612D;
/* 140 */         this.posY += 0.05000000074505806D;
/*     */       } 
/*     */     } 
/*     */     
/* 144 */     this.motionY -= 0.01D;
/* 145 */     this.motionX = 0.0D;
/* 146 */     this.motionZ = 0.0D;
/* 147 */     this.moveForward = 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 154 */     if (isNoDespawnRequired()) this.noClip = false; 
/* 155 */     super.onUpdate();
/* 156 */     this.motionY *= 0.65D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void pointAtEntity(EntityLivingBase e) {
/* 162 */     double d1 = e.posX - this.posX;
/* 163 */     double d2 = e.posZ - this.posZ;
/* 164 */     float d = (float)Math.atan2(d2, d1);
/* 165 */     float f2 = (float)(d * 180.0D / Math.PI) - 90.0F;
/* 166 */     this.rotationYaw = this.rotationYawHead = f2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 173 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 178 */     int bid = 0;
/*     */     
/* 180 */     EntityPlayer target = null;
/* 181 */     WormSmall worms = null;
/* 182 */     if (this.isDead)
/* 183 */       return;  super.updateAITasks();
/* 184 */     if (OreSpawnMain.PlayNicely != 0)
/* 185 */       return;  worms = (WormSmall)this.world.findNearestEntityWithinAABB(WormSmall.class, getEntityBoundingBox().expand(8.0D, 8.0D, 8.0D), (Entity)this);
/* 186 */     if (worms != null)
/*     */       return; 
/* 188 */     target = (EntityPlayer)this.world.findNearestEntityWithinAABB(EntityPlayer.class, getEntityBoundingBox().expand(2.25D, 8.0D, 2.25D), (Entity)this);
/* 189 */     if (target != null && 
/* 190 */       target.capabilities.isCreativeMode) {
/* 191 */       target = null;
/*     */     }
/*     */     
/* 194 */     if (target != null) {
/*     */       
/* 196 */       pointAtEntity((EntityLivingBase)target);
/* 197 */       if (this.upcount > 0 && this.world.rand.nextInt(15) == 1 && !target.capabilities.isCreativeMode) {
/* 198 */         attackEntityAsMob((Entity)target);
/* 199 */         if (this.world.rand.nextInt(6) == 1) {
/* 200 */           ItemStack boots = target.inventory.armorItemInSlot(1);
/*     */ 
/*     */           
/* 203 */           target.inventory.setInventorySlotContents(1, null);
/*     */           
/* 205 */           bid = boots.getMaxDamage() - boots.getItemDamage();
/* 206 */           if (bid > 15) {
/* 207 */             bid /= 15;
/*     */           } else {
/* 209 */             bid = 1;
/*     */           } 
/* 211 */           boots.damageItem(bid, (EntityLivingBase)this);
/*     */ 
/*     */ 
/*     */           
/* 215 */           EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 3.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), boots);
/*     */           
/* 217 */           this.world.spawnEntity((Entity)var3);
/*     */         } 
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
/*     */   protected boolean canTriggerWalking() {
/* 230 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fall(float distance, float damageMultiplier) {}
/*     */ 
/*     */   
/*     */   protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}
/*     */ 
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 242 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 247 */     if (this.world.isDaytime()) return false; 
/* 248 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 253 */     boolean ret = false;
/*     */     
/* 255 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/* 256 */       return ret;
/*     */     }
/* 258 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 260 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 266 */     return Items.ROTTEN_FLESH;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 271 */     EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), this.posY + 2.5D + this.world.rand.nextInt(3), this.posZ + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), new ItemStack(index, par1, 0));
/* 272 */     this.world.spawnEntity((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 279 */     for (var4 = 0; var4 < 2; var4++) {
/* 280 */       dropItemRand(Items.ROTTEN_FLESH, 1);
/*     */     }
/* 282 */     for (var4 = 0; var4 < 2; var4++)
/* 283 */       dropItemRand(Items.LEATHER, 1); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\WormMedium.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */