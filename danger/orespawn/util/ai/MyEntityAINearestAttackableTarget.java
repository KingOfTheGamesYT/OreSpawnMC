/*    */ package danger.orespawn.util.ai;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.EntitySelector;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MyEntityAINearestAttackableTarget
/*    */   extends MyEntityAITarget
/*    */ {
/*    */   EntityLiving targetEntity;
/*    */   Class targetClass;
/*    */   int targetChance;
/*    */   private final EntitySelector targetEntitySelector;
/*    */   private MyEntityAINearestAttackableTargetSorter theNearestAttackableTargetSorter;
/*    */   
/*    */   public MyEntityAINearestAttackableTarget(EntityLiving par1EntityLiving, Class par2Class, float par3, int par4, boolean par5) {
/* 25 */     this(par1EntityLiving, par2Class, par3, par4, par5, false);
/*    */   }
/*    */   
/*    */   public MyEntityAINearestAttackableTarget(EntityLiving par1EntityLiving, Class par2Class, float par3, int par4, boolean par5, boolean par6) {
/* 29 */     this(par1EntityLiving, par2Class, par3, par4, par5, par6, (EntitySelector)null);
/*    */   }
/*    */   
/*    */   public MyEntityAINearestAttackableTarget(EntityLiving par1, Class par2, float par3, int par4, boolean par5, boolean par6, EntitySelector par7IEntitySelector) {
/* 33 */     super(par1, par3, par5, par6);
/* 34 */     this.targetClass = par2;
/* 35 */     this.targetDistance = par3;
/* 36 */     this.targetChance = par4;
/* 37 */     this.theNearestAttackableTargetSorter = new MyEntityAINearestAttackableTargetSorter(this, (Entity)par1);
/* 38 */     this.targetEntitySelector = par7IEntitySelector;
/* 39 */     setMutexBits(1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldExecute() {
/* 48 */     if (this.taskOwner instanceof EntityTameable && !((EntityTameable)this.taskOwner).isTamed()) {
/* 49 */       return false;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 63 */     if (this.targetChance > 0 && this.taskOwner.getRNG().nextInt(100) > this.targetChance) {
/* 64 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 68 */     List<?> var5 = this.taskOwner.world.getEntitiesWithinAABB(this.targetClass, this.taskOwner.getEntityBoundingBox().expand(this.targetDistance, 4.0D, this.targetDistance));
/* 69 */     Collections.sort(var5, this.theNearestAttackableTargetSorter);
/* 70 */     Iterator<?> var2 = var5.iterator();
/*    */     
/* 72 */     while (var2.hasNext()) {
/* 73 */       Entity var3 = (Entity)var2.next();
/* 74 */       EntityLiving var4 = (EntityLiving)var3;
/*    */       
/* 76 */       if (isSuitableTarget((EntityLivingBase)var4, false)) {
/* 77 */         this.targetEntity = var4;
/* 78 */         return true;
/*    */       } 
/*    */     } 
/*    */     
/* 82 */     this.targetEntity = null;
/* 83 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void startExecuting() {
/* 91 */     this.taskOwner.setAttackTarget((EntityLivingBase)this.targetEntity);
/* 92 */     super.startExecuting();
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespaw\\util\ai\MyEntityAINearestAttackableTarget.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */