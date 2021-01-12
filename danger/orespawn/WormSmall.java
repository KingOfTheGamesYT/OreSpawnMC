/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.block.Block;
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
/*     */ import net.minecraft.world.World;
/*     */ 
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
/*  26 */   public int upcount = 50;
/*  27 */   public int downcount = 0;
/*     */   
/*     */   public WormSmall(World par1World) {
/*  30 */     super(par1World);
/*     */     
/*  32 */     setSize(0.25F, 1.0F);
/*  33 */     getNavigator().setAvoidsWater(true);
/*  34 */     this.experienceValue = 0;
/*  35 */     this.noClip = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  40 */     super.applyEntityAttributes();
/*  41 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  42 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612D);
/*  43 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.WormSmall_stats.attack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  49 */     super.entityInit();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  62 */     return 0.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  70 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/*  78 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/*  86 */     return "orespawn:little_splat";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/*  94 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 102 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   protected void collideWithNearbyEntities() {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 111 */     return OreSpawnMain.WormSmall_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 119 */     return OreSpawnMain.WormSmall_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 127 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 133 */     EntityPlayer target = null;
/* 134 */     super.onLivingUpdate();
/*     */     
/* 136 */     target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(8.0D, 8.0D, 8.0D), (Entity)this);
/* 137 */     if (target != null || OreSpawnMain.PlayNicely != 0) {
/*     */       
/* 139 */       if (this.upcount > 0) {
/* 140 */         this.upcount--;
/* 141 */         if (this.upcount == 0) this.downcount = 100 + this.worldObj.rand.nextInt(150); 
/* 142 */         if (target != null) pointAtEntity((EntityLivingBase)target); 
/* 143 */         Block bid = this.worldObj.getBlock((int)this.posX, (int)(this.posY + 0.25D), (int)this.posZ);
/* 144 */         if (bid == Blocks.tallgrass) bid = Blocks.air; 
/* 145 */         if (bid != Blocks.air) {
/* 146 */           if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) setDead(); 
/* 147 */           this.motionY += 0.15000000596046448D;
/* 148 */           this.posY += 0.10000000149011612D;
/*     */         } 
/*     */       } else {
/* 151 */         if (this.downcount > 0) {
/* 152 */           this.downcount--;
/*     */         } else {
/* 154 */           this.upcount = 25 + this.worldObj.rand.nextInt(50);
/*     */         } 
/* 156 */         Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY + 2, (int)this.posZ);
/* 157 */         if (bid == Blocks.tallgrass) bid = Blocks.air; 
/* 158 */         if (bid != Blocks.air) {
/* 159 */           if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) setDead(); 
/* 160 */           this.motionY += 0.20000000298023224D;
/* 161 */           this.posY += 0.05000000074505806D;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 165 */       this.upcount = this.worldObj.rand.nextInt(50);
/* 166 */       this.downcount = 0;
/* 167 */       Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY + 2, (int)this.posZ);
/* 168 */       if (bid == Blocks.tallgrass) bid = Blocks.air; 
/* 169 */       if (bid != Blocks.air) {
/* 170 */         if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) setDead(); 
/* 171 */         this.motionY += 0.10000000149011612D;
/* 172 */         this.posY += 0.05000000074505806D;
/*     */       } 
/*     */     } 
/*     */     
/* 176 */     this.motionY -= 0.01D;
/* 177 */     this.motionX = 0.0D;
/* 178 */     this.motionZ = 0.0D;
/* 179 */     this.moveForward = 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 188 */     if (isNoDespawnRequired()) this.noClip = false; 
/* 189 */     super.onUpdate();
/* 190 */     this.motionY *= 0.75D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void pointAtEntity(EntityLivingBase e) {
/* 196 */     double d1 = e.posX - this.posX;
/* 197 */     double d2 = e.posZ - this.posZ;
/* 198 */     float d = (float)Math.atan2(d2, d1);
/* 199 */     float f2 = (float)(d * 180.0D / Math.PI) - 90.0F;
/* 200 */     this.rotationYaw = this.rotationYawHead = f2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 206 */     int bid = 0;
/*     */     
/* 208 */     EntityPlayer target = null;
/*     */     
/* 210 */     if (this.isDead)
/* 211 */       return;  super.updateAITasks();
/* 212 */     if (OreSpawnMain.PlayNicely != 0)
/*     */       return; 
/* 214 */     target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(1.5D, 4.0D, 1.5D), (Entity)this);
/* 215 */     if (target != null && 
/* 216 */       target.capabilities.isCreativeMode == true) {
/* 217 */       target = null;
/*     */     }
/*     */     
/* 220 */     if (target != null) {
/*     */       
/* 222 */       pointAtEntity((EntityLivingBase)target);
/* 223 */       if (this.upcount > 0 && this.worldObj.rand.nextInt(15) == 1 && !target.capabilities.isCreativeMode) {
/* 224 */         attackEntityAsMob((Entity)target);
/* 225 */         if (this.worldObj.rand.nextInt(6) == 1) {
/* 226 */           ItemStack boots = target.getEquipmentInSlot(1);
/* 227 */           if (boots != null) {
/* 228 */             target.setCurrentItemOrArmor(1, null);
/* 229 */             bid = boots.getMaxDamage() - boots.getItemDamage();
/* 230 */             if (bid > 20) {
/* 231 */               bid /= 20;
/*     */             } else {
/* 233 */               bid = 1;
/*     */             } 
/* 235 */             boots.damageItem(bid, (EntityLivingBase)this);
/* 236 */             EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 3.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), boots);
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 241 */             this.worldObj.spawnEntityInWorld((Entity)var3);
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
/*     */   protected boolean canTriggerWalking() {
/* 255 */     return false;
/*     */   }
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
/*     */   public boolean doesEntityNotTriggerPressurePlate() {
/* 274 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 282 */     if (this.worldObj.isDaytime()) return false; 
/* 283 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 293 */     boolean ret = false;
/*     */ 
/*     */     
/* 296 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/* 297 */       return ret;
/*     */     }
/*     */     
/* 300 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 302 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 310 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\WormSmall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */