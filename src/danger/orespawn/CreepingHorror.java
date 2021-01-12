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
/*     */ public class CreepingHorror
/*     */   extends EntityMob
/*     */ {
/*  41 */   private GenericTargetSorter TargetSorter = null;
/*  42 */   private float moveSpeed = 0.25F;
/*     */ 
/*     */ 
/*     */   
/*     */   public CreepingHorror(World par1World) {
/*  47 */     super(par1World);
/*  48 */     setSize(0.75F, 0.5F);
/*  49 */     getNavigator().setAvoidsWater(true);
/*  50 */     this.experienceValue = 5;
/*  51 */     this.fireResistance = 10;
/*  52 */     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  53 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.350000023841858D));
/*  54 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
/*  55 */     this.tasks.addTask(3, new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D));
/*  56 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  57 */     this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  58 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*  59 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  64 */     super.applyEntityAttributes();
/*  65 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  66 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  67 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.CreepingHorror_stats.attack);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  72 */     super.entityInit();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  77 */     return OreSpawnMain.CreepingHorror_stats.health;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/*  85 */     return OreSpawnMain.CreepingHorror_stats.defense;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAIEnabled() {
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 102 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/* 103 */     super.onUpdate();
/* 104 */     if (isNoDespawnRequired()) {
/*     */       return;
/*     */     }
/* 107 */     long t = this.worldObj.getWorldTime();
/* 108 */     t %= 24000L;
/* 109 */     if (t > 11000L)
/* 110 */       return;  if (this.worldObj.rand.nextInt(500) == 1) setDead();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getLivingSound() {
/* 120 */     return "orespawn:creepinghorror_living";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getHurtSound() {
/* 128 */     return "orespawn:creepinghorror_hit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getDeathSound() {
/* 136 */     return "orespawn:creepinghorror_dead";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundVolume() {
/* 143 */     return 0.65F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getSoundPitch() {
/* 150 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item getDropItem() {
/* 160 */     int i = this.worldObj.rand.nextInt(3);
/* 161 */     if (i == 0) return Items.rotten_flesh; 
/* 162 */     if (i == 1) return Items.bone; 
/* 163 */     return Items.string;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 169 */     if (this.isDead)
/* 170 */       return;  super.updateAITasks();
/* 171 */     if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 172 */     if (this.worldObj.rand.nextInt(5) == 1) {
/* 173 */       EntityLivingBase e = findSomethingToAttack();
/* 174 */       if (e != null) {
/* 175 */         getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/* 176 */         if (getDistanceSqToEntity((Entity)e) < 5.0D)
/*     */         {
/* 178 */           if (this.rand.nextInt(12) == 0 || this.rand.nextInt(14) == 1)
/*     */           {
/* 180 */             attackEntityAsMob((Entity)e);
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
/* 195 */     if (par1EntityLiving == null)
/*     */     {
/* 197 */       return false;
/*     */     }
/* 199 */     if (par1EntityLiving == this)
/*     */     {
/* 201 */       return false;
/*     */     }
/* 203 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 205 */       return false;
/*     */     }
/* 207 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 210 */       return false;
/*     */     }
/* 212 */     if (par1EntityLiving instanceof CreepingHorror)
/*     */     {
/* 214 */       return false;
/*     */     }
/* 216 */     if (par1EntityLiving instanceof RockBase)
/*     */     {
/* 218 */       return false;
/*     */     }
/* 220 */     if (par1EntityLiving instanceof EnderReaper)
/*     */     {
/* 222 */       return false;
/*     */     }
/* 224 */     if (par1EntityLiving instanceof LeafMonster)
/*     */     {
/* 226 */       return false;
/*     */     }
/* 228 */     if (par1EntityLiving instanceof Dragon)
/*     */     {
/* 230 */       return false;
/*     */     }
/* 232 */     if (par1EntityLiving instanceof TerribleTerror)
/*     */     {
/* 234 */       return false;
/*     */     }
/* 236 */     if (par1EntityLiving instanceof LurkingTerror)
/*     */     {
/* 238 */       return false;
/*     */     }
/* 240 */     if (par1EntityLiving instanceof PitchBlack)
/*     */     {
/* 242 */       return false;
/*     */     }
/* 244 */     if (par1EntityLiving instanceof Firefly)
/*     */     {
/* 246 */       return false;
/*     */     }
/* 248 */     if (par1EntityLiving instanceof Island)
/*     */     {
/* 250 */       return false;
/*     */     }
/* 252 */     if (par1EntityLiving instanceof IslandToo)
/*     */     {
/* 254 */       return false;
/*     */     }
/*     */     
/* 257 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 259 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 260 */       if (p.capabilities.isCreativeMode == true) {
/* 261 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 265 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 270 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 271 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0D, 4.0D, 16.0D));
/* 272 */     Collections.sort(var5, this.TargetSorter);
/* 273 */     Iterator<?> var2 = var5.iterator();
/* 274 */     Entity var3 = null;
/* 275 */     EntityLivingBase var4 = null;
/*     */     
/* 277 */     while (var2.hasNext()) {
/*     */       
/* 279 */       var3 = (Entity)var2.next();
/* 280 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 282 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 284 */         return var4;
/*     */       }
/*     */     } 
/* 287 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 295 */     if (!isValidLightLevel()) return false; 
/* 296 */     if (this.worldObj.isDaytime()) return false; 
/* 297 */     if (this.worldObj.provider.dimensionId != OreSpawnMain.DimensionID6 && 
/* 298 */       this.posY > 15.0D) return false;
/*     */     
/* 300 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canDespawn() {
/* 307 */     if (isNoDespawnRequired()) return false; 
/* 308 */     if (!this.worldObj.isDaytime()) return false; 
/* 309 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CreepingHorror.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */