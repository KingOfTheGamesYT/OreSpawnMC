/*    */ package danger.orespawn;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.IEntitySelector;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MyValentineTarget
/*    */   extends MyEntityAITarget
/*    */ {
/*    */   EntityLivingBase targetEntity;
/*    */   EntityLivingBase Me;
/*    */   Class targetClass;
/*    */   int targetChance;
/*    */   private final IEntitySelector targetEntitySelector;
/*    */   private MyValentineTargetSorter theNearestAttackableTargetSorter;
/*    */   
/*    */   public MyValentineTarget(EntityLiving par1EntityLiving, Class par2Class, float par3, int par4, boolean par5) {
/* 27 */     this(par1EntityLiving, par2Class, par3, par4, par5, false);
/* 28 */     this.Me = (EntityLivingBase)par1EntityLiving;
/*    */   }
/*    */ 
/*    */   
/*    */   public MyValentineTarget(EntityLiving par1EntityLiving, Class par2Class, float par3, int par4, boolean par5, boolean par6) {
/* 33 */     this(par1EntityLiving, par2Class, par3, par4, par5, par6, (IEntitySelector)null);
/* 34 */     this.Me = (EntityLivingBase)par1EntityLiving;
/*    */   }
/*    */ 
/*    */   
/*    */   public MyValentineTarget(EntityLiving par1, Class par2, float par3, int par4, boolean par5, boolean par6, IEntitySelector par7IEntitySelector) {
/* 39 */     super(par1, par3, par5, par6);
/* 40 */     this.targetClass = par2;
/* 41 */     this.targetDistance = par3;
/* 42 */     this.targetChance = par4;
/* 43 */     this.theNearestAttackableTargetSorter = new MyValentineTargetSorter(this, (Entity)par1);
/* 44 */     this.targetEntitySelector = par7IEntitySelector;
/* 45 */     setMutexBits(1);
/* 46 */     this.Me = (EntityLivingBase)par1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldExecute() {
/* 54 */     if (OreSpawnMain.valentines_day == 0) return false; 
/* 55 */     if (this.Me != null && this.Me instanceof Girlfriend) {
/* 56 */       Girlfriend gf = (Girlfriend)this.Me;
/* 57 */       if (gf.feelingBetter != 0) return false;
/*    */     
/*    */     } 
/*    */     
/* 61 */     if (this.targetChance > 0 && this.taskOwner.getRNG().nextInt(100) > this.targetChance)
/*    */     {
/* 63 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 67 */     List<?> var5 = this.taskOwner.worldObj.selectEntitiesWithinAABB(this.targetClass, this.taskOwner.boundingBox.expand(this.targetDistance, 4.0D, this.targetDistance), this.targetEntitySelector);
/* 68 */     Collections.sort(var5, this.theNearestAttackableTargetSorter);
/* 69 */     Iterator<?> var2 = var5.iterator();
/*    */     
/* 71 */     while (var2.hasNext()) {
/*    */       
/* 73 */       Entity var3 = (Entity)var2.next();
/* 74 */       if (var3 instanceof EntityLivingBase) {
/* 75 */         EntityLivingBase var4 = (EntityLivingBase)var3;
/*    */         
/* 77 */         if (isSuitableTarget(var4, false)) {
/*    */           
/* 79 */           this.targetEntity = var4;
/* 80 */           return true;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 85 */     this.targetEntity = null;
/* 86 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void startExecuting() {
/* 95 */     this.taskOwner.setAttackTarget(this.targetEntity);
/* 96 */     super.startExecuting();
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MyValentineTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */