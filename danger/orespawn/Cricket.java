/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
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
/*     */ 
/*     */ 
/*     */ public class Cricket
/*     */   extends EntityAnimal
/*     */ {
/*  30 */   public double moveSpeed = 0.15000000596046448D;
/*  31 */   private int singing = 0;
/*  32 */   private int jumpcount = 0;
/*     */   
/*     */   public Cricket(World par1World) {
/*  35 */     super(par1World);
/*  36 */     setSize(0.1F, 0.1F);
/*  37 */     this.experienceValue = 1;
/*  38 */     getNavigator().setAvoidsWater(true);
/*  39 */     this.tasks.addTask(0, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.4D));
/*  40 */     this.tasks.addTask(1, new MyEntityAIWanderALot((EntityCreature)this, 8, 1.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  45 */     super.applyEntityAttributes();
/*  46 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  47 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  48 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  49 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  54 */     super.entityInit();
/*  55 */     this.dataWatcher.addObject(20, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/*  60 */     if (isNoDespawnRequired()) return false; 
/*  61 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSinging() {
/*  66 */     return this.dataWatcher.getWatchableObjectByte(20);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSinging(int par1) {
/*  71 */     this.dataWatcher.updateObject(20, Byte.valueOf((byte)par1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void jumpAround() {
/*  77 */     this.motionY += (0.55F + Math.abs(this.worldObj.rand.nextFloat() * 0.35F));
/*  78 */     this.posY += 0.25D;
/*  79 */     float f = 0.3F + Math.abs(this.worldObj.rand.nextFloat() * 0.25F);
/*  80 */     float d = (float)(this.worldObj.rand.nextFloat() * Math.PI * 2.0D);
/*  81 */     this.motionX += f * Math.sin(d);
/*  82 */     this.motionZ += f * Math.cos(d);
/*  83 */     this.isAirBorne = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  91 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  92 */     super.onUpdate();
/*  93 */     if (!this.worldObj.isRemote) {
/*  94 */       if (this.singing != 0) {
/*  95 */         this.singing--;
/*  96 */         if (this.singing <= 0) {
/*  97 */           setSinging(0);
/*     */         }
/*     */       } 
/* 100 */       if (this.jumpcount > 0) this.jumpcount--; 
/* 101 */       if (this.jumpcount == 0 && 
/* 102 */         this.worldObj.rand.nextInt(50) == 1) {
/* 103 */         jumpAround();
/* 104 */         this.jumpcount = 50;
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
/*     */   
/*     */   public boolean isAIEnabled() {
/* 119 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/* 125 */     return 3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 134 */     if (!this.worldObj.isRemote) {
/* 135 */       if (this.worldObj.rand.nextInt(2) == 0) return null; 
/* 136 */       this.singing = 40;
/* 137 */       setSinging(this.singing);
/*     */     } 
/* 139 */     return "orespawn:cricket";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 147 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 155 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 164 */     return 0.7F;
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
/*     */   protected void playStepSound(int par1, int par2, int par3, int par4) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTriggerWalking() {
/* 194 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fall(float par1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateFallState(double par1, boolean par3) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable var1) {
/* 211 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 219 */     if (this.posY < 30.0D) return false; 
/* 220 */     if (findBuddies() > 5) return false; 
/* 221 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private int findBuddies() {
/* 226 */     List var5 = this.worldObj.getEntitiesWithinAABB(Cricket.class, this.boundingBox.expand(20.0D, 10.0D, 20.0D));
/* 227 */     return var5.size();
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Cricket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */