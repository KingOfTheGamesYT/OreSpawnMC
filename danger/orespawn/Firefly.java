/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.passive.EntityAmbientCreature;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Firefly
/*     */   extends EntityAmbientCreature
/*     */ {
/*  25 */   private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "Fireflytexture.png");
/*  26 */   int my_blink = 0;
/*  27 */   int blinker = 0;
/*  28 */   int myspace = 0;
/*     */ 
/*     */   
/*  31 */   private ChunkCoordinates currentFlightTarget = null;
/*     */   
/*     */   public Firefly(World par1World) {
/*  34 */     super(par1World);
/*  35 */     this.my_blink = 20 + this.rand.nextInt(20);
/*  36 */     setSize(0.4F, 0.8F);
/*  37 */     getNavigator().setAvoidsWater(true);
/*  38 */     this.renderDistanceWeight = 3.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  43 */     super.applyEntityAttributes();
/*  44 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  45 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612D);
/*  46 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  47 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
/*     */   }
/*     */   
/*     */   public ResourceLocation getTexture(Firefly a) {
/*  51 */     return texture1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  56 */     super.entityInit();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getBlink() {
/*  61 */     if (this.blinker < this.my_blink / 2) return 240.0F; 
/*  62 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/*  70 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/*  78 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/*  94 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 102 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBePushed() {
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void collideWithEntity(Entity par1Entity) {}
/*     */   
/*     */   protected void collideWithNearbyEntities() {}
/*     */   
/*     */   public int mygetMaxHealth() {
/* 119 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 124 */     return Item.getItemFromBlock(OreSpawnMain.ExtremeTorch);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 132 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 141 */     super.onUpdate();
/* 142 */     this.motionY *= 0.600000023841D;
/* 143 */     this.blinker++;
/* 144 */     if (this.blinker > this.my_blink) this.blinker = 0; 
/* 145 */     if (isNoDespawnRequired()) {
/*     */       return;
/*     */     }
/* 148 */     long t = this.worldObj.getWorldTime();
/* 149 */     t %= 24000L;
/* 150 */     if (t > 11000L)
/* 151 */       return;  if (this.worldObj.rand.nextInt(500) == 1) setDead();
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 157 */     int keep_trying = 25;
/* 158 */     if (this.isDead)
/* 159 */       return;  super.updateAITasks();
/*     */ 
/*     */     
/* 162 */     if (this.currentFlightTarget == null) {
/* 163 */       this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
/*     */     }
/* 165 */     if (this.rand.nextInt(40) == 0 || this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.0F) {
/*     */       
/* 167 */       Block bid = Blocks.stone;
/* 168 */       while (bid != Blocks.air && keep_trying != 0) {
/* 169 */         this.currentFlightTarget.set((int)this.posX + this.rand.nextInt(4) - this.rand.nextInt(4), (int)this.posY + this.rand.nextInt(4) - 2, (int)this.posZ + this.rand.nextInt(4) - this.rand.nextInt(4));
/*     */ 
/*     */         
/* 172 */         bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
/* 173 */         keep_trying--;
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     double var1 = this.currentFlightTarget.posX + 0.5D - this.posX;
/* 178 */     double var3 = this.currentFlightTarget.posY + 0.1D - this.posY;
/* 179 */     double var5 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
/* 180 */     this.motionX += (Math.signum(var1) * 0.2D - this.motionX) * 0.1D;
/* 181 */     this.motionY += (Math.signum(var3) * 0.699999988079071D - this.motionY) * 0.1D;
/* 182 */     this.motionZ += (Math.signum(var5) * 0.2D - this.motionZ) * 0.1D;
/* 183 */     float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
/* 184 */     float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
/* 185 */     this.moveForward = 0.2F;
/* 186 */     this.rotationYaw += var8 / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 195 */     return false;
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
/* 214 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 224 */     Block bid = this.worldObj.getBlock((int)this.posX, (int)this.posY, (int)this.posZ);
/* 225 */     if (bid != Blocks.air) return false; 
/* 226 */     if (this.worldObj.isDaytime()) return false; 
/* 227 */     if (findBuddies() > 10) return false; 
/* 228 */     if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) return true; 
/* 229 */     if (this.posY < 50.0D) return false; 
/* 230 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 235 */     List var5 = this.worldObj.getEntitiesWithinAABB(Firefly.class, this.boundingBox.expand(20.0D, 8.0D, 20.0D));
/* 236 */     return var5.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCreature() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 249 */     if (!this.worldObj.isDaytime()) return false; 
/* 250 */     if (isNoDespawnRequired()) return false; 
/* 251 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Firefly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */