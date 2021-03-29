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
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WormSmall
/*     */   extends EntityMob
/*     */ {
/*  31 */   public int upcount = 50;
/*  32 */   public int downcount = 0;
/*     */   
/*     */   public WormSmall(World par1World) {
/*  35 */     super(par1World);
/*  36 */     setSize(0.25F, 1.0F);
/*     */     
/*  38 */     this.experienceValue = 0;
/*  39 */     this.noClip = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  44 */     super.applyEntityAttributes();
/*  45 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  46 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);
/*  47 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  52 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  58 */     return 0.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  64 */     return 1.5F;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   protected SoundEvent getAmbientSound() {
/*  69 */     return null;
/*     */   }
/*     */   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
/*  72 */     return SoundsHandler.LITTLE_SPLAT;
/*     */   }
/*     */   protected SoundEvent getDeathSound() {
/*  75 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/*  83 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  92 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/*  98 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAIDisabled() {
/* 103 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 110 */     EntityPlayer target = null;
/* 111 */     super.onLivingUpdate();
/*     */     
/* 113 */     target = (EntityPlayer)this.world.findNearestEntityWithinAABB(EntityPlayer.class, getEntityBoundingBox().expand(8.0D, 8.0D, 8.0D), (Entity)this);
/* 114 */     if (target != null || OreSpawnMain.PlayNicely != 0) {
/*     */       
/* 116 */       if (this.upcount > 0) {
/* 117 */         this.upcount--;
/* 118 */         if (this.upcount == 0) this.downcount = 100 + this.world.rand.nextInt(150); 
/* 119 */         if (target != null) pointAtEntity((EntityLivingBase)target); 
/* 120 */         Block bid = this.world.getBlockState(new BlockPos((int)this.posX, (int)(this.posY + 0.25D), (int)this.posZ)).getBlock();
/*     */         
/* 122 */         if (bid == Blocks.TALLGRASS) bid = Blocks.AIR; 
/* 123 */         if (bid != Blocks.AIR) {
/* 124 */           if (bid != Blocks.GRASS && bid != Blocks.DIRT && bid != Blocks.STONE) setDead(); 
/* 125 */           this.motionY += 0.15000000596046448D;
/* 126 */           this.posY += 0.10000000149011612D;
/*     */         } 
/*     */       } else {
/* 129 */         if (this.downcount > 0) {
/* 130 */           this.downcount--;
/*     */         } else {
/* 132 */           this.upcount = 25 + this.world.rand.nextInt(50);
/*     */         } 
/* 134 */         Block bid = this.world.getBlockState(new BlockPos((int)this.posX, (int)this.posY + 2, (int)this.posZ)).getBlock();
/*     */         
/* 136 */         if (bid == Blocks.TALLGRASS) bid = Blocks.AIR; 
/* 137 */         if (bid != Blocks.AIR) {
/* 138 */           if (bid != Blocks.GRASS && bid != Blocks.DIRT && bid != Blocks.STONE) setDead(); 
/* 139 */           this.motionY += 0.20000000298023224D;
/* 140 */           this.posY += 0.05000000074505806D;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 144 */       this.upcount = this.world.rand.nextInt(50);
/* 145 */       this.downcount = 0;
/* 146 */       Block bid = this.world.getBlockState(new BlockPos((int)this.posX, (int)this.posY + 2, (int)this.posZ)).getBlock();
/*     */       
/* 148 */       if (bid == Blocks.TALLGRASS) bid = Blocks.AIR; 
/* 149 */       if (bid != Blocks.AIR) {
/* 150 */         if (bid != Blocks.GRASS && bid != Blocks.DIRT && bid != Blocks.STONE) setDead(); 
/* 151 */         this.motionY += 0.10000000149011612D;
/* 152 */         this.posY += 0.05000000074505806D;
/*     */       } 
/*     */     } 
/*     */     
/* 156 */     this.motionY -= 0.01D;
/* 157 */     this.motionX = 0.0D;
/* 158 */     this.motionZ = 0.0D;
/* 159 */     this.moveForward = 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 169 */     if (isNoDespawnRequired()) this.noClip = false; 
/* 170 */     super.onUpdate();
/* 171 */     this.motionY *= 0.75D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void pointAtEntity(EntityLivingBase e) {
/* 177 */     double d1 = e.posX - this.posX;
/* 178 */     double d2 = e.posZ - this.posZ;
/* 179 */     float d = (float)Math.atan2(d2, d1);
/* 180 */     float f2 = (float)(d * 180.0D / Math.PI) - 90.0F;
/* 181 */     this.rotationYaw = this.rotationYawHead = f2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 188 */     int bid = 0;
/*     */     
/* 190 */     EntityPlayer target = null;
/*     */     
/* 192 */     if (this.isDead)
/* 193 */       return;  super.updateAITasks();
/* 194 */     if (OreSpawnMain.PlayNicely != 0)
/*     */       return; 
/* 196 */     target = (EntityPlayer)this.world.findNearestEntityWithinAABB(EntityPlayer.class, getEntityBoundingBox().expand(1.5D, 4.0D, 1.5D), (Entity)this);
/* 197 */     if (target != null && 
/* 198 */       target.capabilities.isCreativeMode == true) {
/* 199 */       target = null;
/*     */     }
/*     */     
/* 202 */     if (target != null) {
/*     */       
/* 204 */       pointAtEntity((EntityLivingBase)target);
/* 205 */       if (this.upcount > 0 && this.world.rand.nextInt(15) == 1 && !target.capabilities.isCreativeMode) {
/* 206 */         attackEntityAsMob((Entity)target);
/* 207 */         if (this.world.rand.nextInt(6) == 1) {
/* 208 */           ItemStack boots = target.inventory.armorItemInSlot(1);
/*     */           
/* 210 */           if (boots != null) {
/* 211 */             target.inventory.setInventorySlotContents(1, null);
/*     */             
/* 213 */             bid = boots.getMaxDamage() - boots.getItemDamage();
/* 214 */             if (bid > 20) {
/* 215 */               bid /= 20;
/*     */             } else {
/* 217 */               bid = 1;
/*     */             } 
/* 219 */             boots.damageItem(bid, (EntityLivingBase)this);
/*     */ 
/*     */ 
/*     */             
/* 223 */             EntityItem var3 = new EntityItem(this.world, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 3.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), boots);
/*     */             
/* 225 */             this.world.spawnEntity((Entity)var3);
/*     */           } 
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
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 241 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fall(float distance, float damageMultiplier) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 256 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 265 */     if (this.world.isDaytime()) return false; 
/* 266 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 273 */     boolean ret = false;
/*     */ 
/*     */     
/* 276 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/* 277 */       return ret;
/*     */     }
/*     */     
/* 280 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 282 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 291 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\WormSmall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */