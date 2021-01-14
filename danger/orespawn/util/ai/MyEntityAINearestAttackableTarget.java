/*     */ package danger.orespawn.util.ai;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.EntitySelector;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MyEntityAINearestAttackableTarget
/*     */   extends MyEntityAITarget
/*     */ {
/*     */   EntityLiving targetEntity;
/*     */   Class targetClass;
/*     */   int targetChance;
/*     */   private final EntitySelector targetEntitySelector;
/*     */   private MyEntityAINearestAttackableTargetSorter theNearestAttackableTargetSorter;
/*     */   
/*     */   public MyEntityAINearestAttackableTarget(EntityLiving par1EntityLiving, Class par2Class, float par3, int par4, boolean par5) {
/*  25 */     this(par1EntityLiving, par2Class, par3, par4, par5, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public MyEntityAINearestAttackableTarget(EntityLiving par1EntityLiving, Class par2Class, float par3, int par4, boolean par5, boolean par6) {
/*  30 */     this(par1EntityLiving, par2Class, par3, par4, par5, par6, (EntitySelector)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public MyEntityAINearestAttackableTarget(EntityLiving par1, Class par2, float par3, int par4, boolean par5, boolean par6, EntitySelector par7IEntitySelector) {
/*  35 */     super(par1, par3, par5, par6);
/*  36 */     this.targetClass = par2;
/*  37 */     this.targetDistance = par3;
/*  38 */     this.targetChance = par4;
/*  39 */     this.theNearestAttackableTargetSorter = new MyEntityAINearestAttackableTargetSorter(this, (Entity)par1);
/*  40 */     this.targetEntitySelector = par7IEntitySelector;
/*  41 */     setMutexBits(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldExecute() {
/*  51 */     if (this.taskOwner instanceof EntityTameable && !((EntityTameable)this.taskOwner).isTamed())
/*     */     {
/*  53 */       return false;
/*     */     }
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
/*  67 */     if (this.targetChance > 0 && this.taskOwner.getRNG().nextInt(100) > this.targetChance)
/*     */     {
/*  69 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  73 */     List<?> var5 = this.taskOwner.world.getEntitiesWithinAABB(this.targetClass, this.taskOwner.getEntityBoundingBox().expand(this.targetDistance, 4.0D, this.targetDistance));
/*  74 */     Collections.sort(var5, this.theNearestAttackableTargetSorter);
/*  75 */     Iterator<?> var2 = var5.iterator();
/*     */     
/*  77 */     while (var2.hasNext()) {
/*     */       
/*  79 */       Entity var3 = (Entity)var2.next();
/*  80 */       EntityLiving var4 = (EntityLiving)var3;
/*     */       
/*  82 */       if (isSuitableTarget((EntityLivingBase)var4, false)) {
/*     */         
/*  84 */         this.targetEntity = var4;
/*  85 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     this.targetEntity = null;
/*  90 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startExecuting() {
/*  99 */     this.taskOwner.setAttackTarget((EntityLivingBase)this.targetEntity);
/* 100 */     super.startExecuting();
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespaw\\util\ai\MyEntityAINearestAttackableTarget.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */