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
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
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
/*     */ public class Cryolophosaurus
/*     */   extends EntityMob
/*     */ {
/*  42 */   private GenericTargetSorter TargetSorter = null;
/*  43 */   private float moveSpeed = 0.25F;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Cryolophosaurus(World par1World) {
/*  49 */     super(par1World);
/*  50 */     setSize(0.75F, 0.75F);
/*  51 */     getNavigator().setAvoidsWater(true);
/*  52 */     this.experienceValue = 10;
/*  53 */     this.fireResistance = 10;
/*  54 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  55 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.350000023841858D));
/*  56 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  57 */     this.tasks.addTask(3, new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D));
/*  58 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  59 */     this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  60 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*  61 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  66 */     super.applyEntityAttributes();
/*  67 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  68 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  69 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.Cryolophosaurus_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  74 */     super.entityInit();
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  78 */     if (isNoDespawnRequired()) return false; 
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  84 */     return OreSpawnMain.Cryolophosaurus_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/*  92 */     return OreSpawnMain.Cryolophosaurus_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onLivingUpdate() {
/* 109 */     super.onLivingUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 117 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 118 */     super.onUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 127 */     if (this.rand.nextInt(6) == 0) {
/* 128 */       return "orespawn:cryo_living";
/*     */     }
/* 130 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 138 */     return "orespawn:cryo_hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 146 */     return "orespawn:cryo_death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 153 */     return 0.75F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 160 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 170 */     int i = this.worldObj.rand.nextInt(10);
/* 171 */     if (i == 0) return Items.chicken; 
/* 172 */     if (i == 1) return OreSpawnMain.UraniumNugget; 
/* 173 */     if (i == 2) return OreSpawnMain.TitaniumNugget; 
/* 174 */     return null;
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
/* 189 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 194 */     if (this.isDead)
/* 195 */       return;  super.updateAITasks();
/* 196 */     if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 197 */     if (this.worldObj.rand.nextInt(5) == 1) {
/* 198 */       EntityLivingBase e = findSomethingToAttack();
/* 199 */       if (e != null) {
/* 200 */         getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/* 201 */         if (getDistanceSqToEntity((Entity)e) < 5.0D)
/*     */         {
/* 203 */           if (this.rand.nextInt(12) == 0 || this.rand.nextInt(14) == 1)
/*     */           {
/* 205 */             attackEntityAsMob((Entity)e);
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
/* 220 */     if (par1EntityLiving == null)
/*     */     {
/* 222 */       return false;
/*     */     }
/* 224 */     if (par1EntityLiving == this)
/*     */     {
/* 226 */       return false;
/*     */     }
/* 228 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 230 */       return false;
/*     */     }
/* 232 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 235 */       return false;
/*     */     }
/* 237 */     if (par1EntityLiving instanceof Alosaurus)
/*     */     {
/* 239 */       return false;
/*     */     }
/* 241 */     if (par1EntityLiving instanceof TRex)
/*     */     {
/* 243 */       return false;
/*     */     }
/* 245 */     if (par1EntityLiving instanceof Cryolophosaurus)
/*     */     {
/* 247 */       return false;
/*     */     }
/* 249 */     if (par1EntityLiving instanceof Ghost)
/*     */     {
/* 251 */       return false;
/*     */     }
/* 253 */     if (par1EntityLiving instanceof GhostSkelly)
/*     */     {
/* 255 */       return false;
/*     */     }
/* 257 */     if (par1EntityLiving instanceof CaveFisher)
/*     */     {
/* 259 */       return false;
/*     */     }
/* 261 */     if (par1EntityLiving instanceof GammaMetroid)
/*     */     {
/* 263 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 270 */     if (par1EntityLiving instanceof EntityButterfly)
/*     */     {
/* 272 */       return false;
/*     */     }
/* 274 */     if (par1EntityLiving instanceof Firefly)
/*     */     {
/* 276 */       return false;
/*     */     }
/* 278 */     if (par1EntityLiving instanceof EntityMosquito)
/*     */     {
/* 280 */       return false;
/*     */     }
/* 282 */     if (par1EntityLiving instanceof RockBase)
/*     */     {
/* 284 */       return false;
/*     */     }
/* 286 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 288 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 289 */       if (p.capabilities.isCreativeMode == true) {
/* 290 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 294 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 299 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 300 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(9.0D, 2.0D, 9.0D));
/* 301 */     Collections.sort(var5, this.TargetSorter);
/* 302 */     Iterator<?> var2 = var5.iterator();
/* 303 */     Entity var3 = null;
/* 304 */     EntityLivingBase var4 = null;
/*     */     
/* 306 */     while (var2.hasNext()) {
/*     */       
/* 308 */       var3 = (Entity)var2.next();
/* 309 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 311 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 313 */         return var4;
/*     */       }
/*     */     } 
/* 316 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 326 */     if (!isValidLightLevel()) return false; 
/* 327 */     if (this.worldObj.isDaytime() == true && this.posY > 50.0D) return false;
/*     */ 
/*     */ 
/*     */     
/* 331 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Cryolophosaurus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */