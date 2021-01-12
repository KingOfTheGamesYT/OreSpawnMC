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
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class WormMedium
/*     */   extends EntityMob
/*     */ {
/*  21 */   public int upcount = 0;
/*  22 */   public int downcount = 0;
/*     */   
/*     */   public WormMedium(World par1World) {
/*  25 */     super(par1World);
/*     */     
/*  27 */     setSize(0.5F, 2.0F);
/*  28 */     getNavigator().setAvoidsWater(true);
/*  29 */     this.experienceValue = 0;
/*  30 */     this.noClip = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  35 */     super.applyEntityAttributes();
/*  36 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  37 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612D);
/*  38 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.WormMedium_stats.attack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  44 */     super.entityInit();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  49 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  57 */     return 0.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  65 */     return 1.5F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/*  73 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/*  81 */     return "orespawn:little_splat";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/*  89 */     return "orespawn:big_splat";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/*  97 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   protected void collideWithNearbyEntities() {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 106 */     return OreSpawnMain.WormMedium_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 119 */     Block bid = Blocks.air;
/* 120 */     EntityPlayer target = null;
/* 121 */     WormSmall worms = null;
/* 122 */     super.onLivingUpdate();
/* 123 */     if (this.worldObj.isRemote)
/*     */       return; 
/* 125 */     worms = (WormSmall)this.worldObj.findNearestEntityWithinAABB(WormSmall.class, this.boundingBox.expand(8.0D, 8.0D, 8.0D), (Entity)this);
/* 126 */     if (worms == null) target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(8.0D, 8.0D, 8.0D), (Entity)this); 
/* 127 */     if ((worms == null && target != null) || OreSpawnMain.PlayNicely != 0) {
/*     */       
/* 129 */       if (this.upcount > 0) {
/* 130 */         this.upcount--;
/* 131 */         if (this.upcount == 0) this.downcount = 100 + this.worldObj.rand.nextInt(150); 
/* 132 */         if (target != null) pointAtEntity((EntityLivingBase)target); 
/* 133 */         bid = this.worldObj.getBlock((int)this.posX, (int)(this.posY + 0.25D), (int)this.posZ);
/* 134 */         if (bid == Blocks.tallgrass) bid = Blocks.air; 
/* 135 */         if (bid != Blocks.air) {
/* 136 */           if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) setDead(); 
/* 137 */           this.motionY += 0.20000000298023224D;
/* 138 */           this.posY += 0.10000000149011612D;
/*     */         } 
/*     */       } else {
/* 141 */         if (this.downcount > 0) {
/* 142 */           this.downcount--;
/*     */         } else {
/* 144 */           this.upcount = 25 + this.worldObj.rand.nextInt(75);
/*     */         } 
/* 146 */         bid = this.worldObj.getBlock((int)this.posX, (int)this.posY + 3, (int)this.posZ);
/* 147 */         if (bid == Blocks.tallgrass) bid = Blocks.air; 
/* 148 */         if (bid != Blocks.air) {
/* 149 */           if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) setDead(); 
/* 150 */           this.motionY += 0.10000000149011612D;
/* 151 */           this.posY += 0.05000000074505806D;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 155 */       this.upcount = this.worldObj.rand.nextInt(50);
/* 156 */       this.downcount = 0;
/* 157 */       bid = this.worldObj.getBlock((int)this.posX, (int)this.posY + 3, (int)this.posZ);
/* 158 */       if (bid == Blocks.tallgrass) bid = Blocks.air; 
/* 159 */       if (bid != Blocks.air) {
/* 160 */         if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) setDead(); 
/* 161 */         this.motionY += 0.10000000149011612D;
/* 162 */         this.posY += 0.05000000074505806D;
/*     */       } 
/*     */     } 
/*     */     
/* 166 */     this.motionY -= 0.01D;
/* 167 */     this.motionX = 0.0D;
/* 168 */     this.motionZ = 0.0D;
/* 169 */     this.moveForward = 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 178 */     if (isNoDespawnRequired()) this.noClip = false; 
/* 179 */     super.onUpdate();
/* 180 */     this.motionY *= 0.65D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void pointAtEntity(EntityLivingBase e) {
/* 186 */     double d1 = e.posX - this.posX;
/* 187 */     double d2 = e.posZ - this.posZ;
/* 188 */     float d = (float)Math.atan2(d2, d1);
/* 189 */     float f2 = (float)(d * 180.0D / Math.PI) - 90.0F;
/* 190 */     this.rotationYaw = this.rotationYawHead = f2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 199 */     return OreSpawnMain.WormMedium_stats.defense;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 204 */     int bid = 0;
/*     */     
/* 206 */     EntityPlayer target = null;
/* 207 */     WormSmall worms = null;
/* 208 */     if (this.isDead)
/* 209 */       return;  super.updateAITasks();
/* 210 */     if (OreSpawnMain.PlayNicely != 0)
/* 211 */       return;  worms = (WormSmall)this.worldObj.findNearestEntityWithinAABB(WormSmall.class, this.boundingBox.expand(8.0D, 8.0D, 8.0D), (Entity)this);
/* 212 */     if (worms != null)
/*     */       return; 
/* 214 */     target = (EntityPlayer)this.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(2.25D, 8.0D, 2.25D), (Entity)this);
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
/* 230 */             if (bid > 15) {
/* 231 */               bid /= 15;
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
/*     */           } else {
/* 243 */             boots = target.getEquipmentInSlot(2);
/* 244 */             if (boots != null) {
/* 245 */               target.setCurrentItemOrArmor(2, null);
/* 246 */               bid = boots.getMaxDamage() - boots.getItemDamage();
/* 247 */               if (bid > 15) {
/* 248 */                 bid /= 15;
/*     */               } else {
/* 250 */                 bid = 1;
/*     */               } 
/* 252 */               boots.damageItem(bid, (EntityLivingBase)this);
/* 253 */               EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.posY + 3.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), boots);
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 258 */               this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */             } 
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
/*     */   protected boolean canTriggerWalking() {
/* 274 */     return false;
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
/* 293 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 301 */     if (this.worldObj.isDaytime()) return false; 
/* 302 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 312 */     boolean ret = false;
/*     */ 
/*     */     
/* 315 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/* 316 */       return ret;
/*     */     }
/*     */     
/* 319 */     ret = super.attackEntityFrom(par1DamageSource, par2);
/*     */     
/* 321 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 329 */     return Items.rotten_flesh;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 334 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), this.posY + 2.5D + this.worldObj.rand.nextInt(3), this.posZ + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), new ItemStack(index, par1, 0));
/*     */     
/* 336 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 343 */     for (var4 = 0; var4 < 2; var4++) {
/* 344 */       dropItemRand(Items.rotten_flesh, 1);
/*     */     }
/* 346 */     for (var4 = 0; var4 < 2; var4++)
/* 347 */       dropItemRand(Items.leather, 1); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\WormMedium.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */