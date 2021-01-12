/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.monster.EntitySpider;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SpiderDriver
/*     */   extends EntitySpider
/*     */ {
/*  29 */   private GenericTargetSorter TargetSorter = null;
/*     */   
/*     */   public SpiderDriver(World par1World) {
/*  32 */     super(par1World);
/*  33 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*  34 */     this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  35 */     this.tasks.addTask(2, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D));
/*  36 */     this.tasks.addTask(3, new MyEntityAIWander((EntityCreature)this, 0.65F));
/*  37 */     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  38 */     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */   
/*     */   protected boolean canDespawn() {
/*  42 */     if (isNoDespawnRequired()) return false; 
/*  43 */     if (this.ridingEntity != null) return false; 
/*  44 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAIEnabled() {
/*  52 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Entity findPlayerToAttack() {
/*  57 */     double d0 = 16.0D;
/*  58 */     return (Entity)this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, d0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/*  64 */     if (this.isDead)
/*  65 */       return;  super.updateAITasks();
/*  66 */     if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(5) == 0 && this.ridingEntity == null) {
/*  67 */       EntityLivingBase e = findSpiderRobot();
/*  68 */       if (e != null) {
/*  69 */         faceEntity((Entity)e, 10.0F, 10.0F);
/*  70 */         if (getDistanceSqToEntity((Entity)e) < ((4.0F + e.width / 2.0F) * (4.0F + e.width / 2.0F))) {
/*  71 */           mountEntity((Entity)e);
/*     */         } else {
/*  73 */           getNavigator().tryMoveToEntityLiving((Entity)e, 0.55D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  78 */     if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(4) == 0 && this.ridingEntity != null) {
/*  79 */       EntityLivingBase e = findSomethingToAttack();
/*  80 */       if (e != null) {
/*  81 */         faceEntity((Entity)e, 10.0F, 10.0F);
/*  82 */         if (getDistanceSqToEntity((Entity)e) >= ((11.0F + e.width / 2.0F) * (11.0F + e.width / 2.0F)))
/*     */         {
/*     */           
/*  85 */           if (this.ridingEntity instanceof SpiderRobot) {
/*  86 */             SpiderRobot sp = (SpiderRobot)this.ridingEntity;
/*     */             
/*  88 */             double d1 = e.posZ - this.posZ;
/*  89 */             double d2 = e.posX - this.posX;
/*  90 */             double dd = Math.atan2(d1, d2);
/*  91 */             sp.goThisWay(0.35D * Math.cos(dd), 0.35D * Math.sin(dd));
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
/*     */   protected void attackEntity(Entity par1Entity, float par2) {
/* 105 */     if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY) {
/*     */       
/* 107 */       this.attackTime = 16;
/* 108 */       attackEntityAsMob(par1Entity);
/* 109 */       if (this.worldObj.rand.nextInt(2) == 0) {
/* 110 */         ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, 60, 0));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 120 */     if (this.ridingEntity != null) return 8; 
/* 121 */     return 20;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSpiderRobot() {
/* 126 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 127 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(SpiderRobot.class, this.boundingBox.expand(25.0D, 15.0D, 25.0D));
/* 128 */     Collections.sort(var5, this.TargetSorter);
/* 129 */     Iterator<?> var2 = var5.iterator();
/* 130 */     Entity var3 = null;
/* 131 */     EntityLivingBase var4 = null;
/*     */     
/* 133 */     while (var2.hasNext()) {
/*     */       
/* 135 */       var3 = (Entity)var2.next();
/* 136 */       var4 = (EntityLivingBase)var3;
/* 137 */       if (var4.riddenByEntity == null) {
/* 138 */         return var4;
/*     */       }
/*     */     } 
/* 141 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 150 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*     */     
/* 152 */     if (par1EntityLiving == null)
/*     */     {
/* 154 */       return false;
/*     */     }
/* 156 */     if (par1EntityLiving == this)
/*     */     {
/* 158 */       return false;
/*     */     }
/* 160 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*     */     
/* 167 */     if (par1EntityLiving instanceof SpiderRobot)
/*     */     {
/* 169 */       return false;
/*     */     }
/*     */     
/* 172 */     if (par1EntityLiving instanceof SpiderDriver)
/*     */     {
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     if (par1EntityLiving instanceof EntitySpider)
/*     */     {
/* 179 */       return false;
/*     */     }
/* 181 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityCaveSpider)
/*     */     {
/* 183 */       return false;
/*     */     }
/*     */     
/* 186 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 189 */       return false;
/*     */     }
/*     */     
/* 192 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 194 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 195 */       if (p.capabilities.isCreativeMode == true) {
/* 196 */         return false;
/*     */       }
/* 198 */       return true;
/*     */     } 
/* 200 */     if (getDistanceSqToEntity((Entity)par1EntityLiving) < 36.0D) return false;
/*     */     
/* 202 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 207 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 208 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(35.0D, 15.0D, 35.0D));
/* 209 */     Collections.sort(var5, this.TargetSorter);
/* 210 */     Iterator<?> var2 = var5.iterator();
/* 211 */     Entity var3 = null;
/* 212 */     EntityLivingBase var4 = null;
/*     */     
/* 214 */     while (var2.hasNext()) {
/*     */       
/* 216 */       var3 = (Entity)var2.next();
/* 217 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 219 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 221 */         return var4;
/*     */       }
/*     */     } 
/* 224 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 232 */     SpiderRobot target = null;
/* 233 */     target = (SpiderRobot)this.worldObj.findNearestEntityWithinAABB(SpiderRobot.class, this.boundingBox.expand(24.0D, 12.0D, 24.0D), (Entity)this);
/* 234 */     if (target != null)
/*     */     {
/* 236 */       return true;
/*     */     }
/* 238 */     return super.getCanSpawnHere();
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\SpiderDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */