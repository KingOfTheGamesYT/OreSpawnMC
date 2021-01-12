/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntitySmallFireball;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
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
/*     */ public class Kyuubi
/*     */   extends EntityMob
/*     */ {
/*  47 */   private GenericTargetSorter TargetSorter = null;
/*  48 */   private float moveSpeed = 0.25F;
/*     */   
/*     */   public Kyuubi(World par1World) {
/*  51 */     super(par1World);
/*  52 */     setSize(0.5F, 1.25F);
/*  53 */     getNavigator().setAvoidsWater(true);
/*  54 */     this.experienceValue = 30;
/*  55 */     this.fireResistance = 1000;
/*  56 */     this.isImmuneToFire = true;
/*  57 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  58 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.350000023841858D));
/*  59 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  60 */     this.tasks.addTask(3, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
/*  61 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F));
/*  62 */     this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  63 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*  64 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  69 */     super.entityInit();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  74 */     super.applyEntityAttributes();
/*  75 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  76 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  77 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Kyuubi_stats.attack);
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  81 */     if (isNoDespawnRequired()) return false; 
/*  82 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  90 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  91 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  96 */     return OreSpawnMain.Kyuubi_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 104 */     return OreSpawnMain.Kyuubi_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 121 */     super.onLivingUpdate();
/* 122 */     if (this.worldObj.rand.nextInt(10) == 1) {
/* 123 */       this.worldObj.spawnParticle("reddust", this.posX, this.posY + 2.0D, this.posZ, 0.0D, 0.0D, 0.0D);
/* 124 */       this.worldObj.spawnParticle("lava", this.posX, this.posY + 2.0D, this.posZ, 0.0D, 0.0D, 0.0D);
/* 125 */       setFire(5);
/* 126 */       if (isInWater()) {
/* 127 */         attackEntityAsMob((Entity)this);
/* 128 */         this.worldObj.spawnParticle("smoke", this.posX, this.posY + 1.75D, this.posZ, 0.0D, 0.0D, 0.0D);
/* 129 */         this.worldObj.spawnParticle("largesmoke", this.posX, this.posY + 1.75D, this.posZ, 0.0D, 0.0D, 0.0D);
/* 130 */         this.worldObj.spawnParticle("smoke", this.posX, this.posY + 2.0D, this.posZ, 0.0D, 0.0D, 0.0D);
/* 131 */         this.worldObj.spawnParticle("largesmoke", this.posX, this.posY + 2.0D, this.posZ, 0.0D, 0.0D, 0.0D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAttackStrength(Entity par1Entity) {
/* 142 */     return 3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 150 */     return "orespawn:kyuubi_living";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 158 */     return "orespawn:alo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 166 */     return "orespawn:alo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 173 */     return 0.75F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 180 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 190 */     int i = this.worldObj.rand.nextInt(6);
/* 191 */     if (i == 0) return Items.gold_nugget; 
/* 192 */     if (i == 1) return OreSpawnMain.UraniumNugget; 
/* 193 */     if (i == 2) return OreSpawnMain.TitaniumNugget; 
/* 194 */     return null;
/*     */   }
/*     */ 
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
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 209 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 214 */     if (this.isDead)
/* 215 */       return;  if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 216 */     super.updateAITasks();
/* 217 */     if (this.worldObj.rand.nextInt(10) == 1) {
/* 218 */       EntityLivingBase e = findSomethingToAttack();
/* 219 */       if (e != null) {
/* 220 */         faceEntity((Entity)e, 10.0F, 10.0F);
/* 221 */         getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/* 222 */         if (getDistanceSqToEntity((Entity)e) < 64.0D)
/*     */         {
/* 224 */           if (this.rand.nextInt(6) == 0 || this.rand.nextInt(8) == 1) {
/*     */ 
/*     */             
/* 227 */             EntitySmallFireball var2 = new EntitySmallFireball(this.worldObj, (EntityLivingBase)this, e.posX - this.posX, e.posY + 0.75D - this.posY + 1.25D, e.posZ - this.posZ);
/* 228 */             var2.setLocationAndAngles(this.posX, this.posY + 1.25D, this.posZ, this.rotationYaw, this.rotationPitch);
/* 229 */             this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 230 */             this.worldObj.spawnEntityInWorld((Entity)var2);
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
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 245 */     if (par1EntityLiving == null)
/*     */     {
/* 247 */       return false;
/*     */     }
/* 249 */     if (par1EntityLiving == this)
/*     */     {
/* 251 */       return false;
/*     */     }
/* 253 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 255 */       return false;
/*     */     }
/*     */     
/* 258 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 260 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 263 */       return false;
/*     */     }
/* 265 */     if (par1EntityLiving instanceof EntityMob)
/*     */     {
/* 267 */       return false;
/*     */     }
/*     */     
/* 270 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityPigZombie)
/*     */     {
/* 272 */       return false;
/*     */     }
/* 274 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 276 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 277 */       if (p.capabilities.isCreativeMode == true) {
/* 278 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 282 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 287 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 288 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D, 4.0D, 12.0D));
/* 289 */     Collections.sort(var5, this.TargetSorter);
/* 290 */     Iterator<?> var2 = var5.iterator();
/* 291 */     Entity var3 = null;
/* 292 */     EntityLivingBase var4 = null;
/*     */     
/* 294 */     while (var2.hasNext()) {
/*     */       
/* 296 */       var3 = (Entity)var2.next();
/* 297 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 299 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 301 */         return var4;
/*     */       }
/*     */     } 
/* 304 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 313 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void dropItemRand(Item index, int par1) {
/* 318 */     EntityItem var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
/*     */     
/* 320 */     this.worldObj.spawnEntityInWorld((Entity)var3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropFewItems(boolean par1, int par2) {
/*     */     int var4;
/* 327 */     for (var4 = 0; var4 < 10; var4++) {
/* 328 */       dropItemRand(Items.coal, 1);
/*     */     }
/* 330 */     for (var4 = 0; var4 < 3; var4++) {
/* 331 */       dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
/*     */     }
/* 333 */     for (var4 = 0; var4 < 4; var4++)
/* 334 */       dropItemRand(Item.getItemFromBlock(Blocks.quartz_block), 1); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Kyuubi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */