/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MyUtils
/*     */ {
/*     */   public static boolean isRoyalty(Entity e) {
/*  12 */     if (!(e instanceof EntityLivingBase)) return false; 
/*  13 */     if (e instanceof ThePrince) return true; 
/*  14 */     if (e instanceof ThePrinceTeen) return true; 
/*  15 */     if (e instanceof ThePrinceAdult) return true; 
/*  16 */     if (e instanceof ThePrincess) return true; 
/*  17 */     if (e instanceof TheKing) return true; 
/*  18 */     if (e instanceof KingHead) return true; 
/*  19 */     if (e instanceof TheQueen) return true; 
/*  20 */     if (e instanceof QueenHead) return true; 
/*  21 */     if (e instanceof PurplePower) return true; 
/*  22 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isAttackableNonMob(EntityLivingBase par1EntityLiving) {
/*  29 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityMob)
/*     */     {
/*  31 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  37 */     if (par1EntityLiving instanceof Mothra)
/*     */     {
/*  39 */       return true;
/*     */     }
/*  41 */     if (par1EntityLiving instanceof Leon)
/*     */     {
/*  43 */       return true;
/*     */     }
/*  45 */     if (par1EntityLiving instanceof Dragon)
/*     */     {
/*  47 */       return true;
/*     */     }
/*  49 */     if (par1EntityLiving instanceof Spyro)
/*     */     {
/*  51 */       return true;
/*     */     }
/*  53 */     if (isRoyalty((Entity)par1EntityLiving))
/*     */     {
/*  55 */       return true;
/*     */     }
/*  57 */     if (par1EntityLiving instanceof GammaMetroid)
/*     */     {
/*  59 */       return true;
/*     */     }
/*  61 */     if (par1EntityLiving instanceof Cephadrome)
/*     */     {
/*  63 */       return true;
/*     */     }
/*  65 */     if (par1EntityLiving instanceof WaterDragon)
/*     */     {
/*  67 */       return true;
/*     */     }
/*  69 */     if (par1EntityLiving instanceof Girlfriend)
/*     */     {
/*  71 */       return true;
/*     */     }
/*  73 */     if (par1EntityLiving instanceof Boyfriend)
/*     */     {
/*  75 */       return true;
/*     */     }
/*  77 */     if (par1EntityLiving instanceof net.minecraft.entity.passive.EntityVillager)
/*     */     {
/*  79 */       return true;
/*     */     }
/*  81 */     if (par1EntityLiving instanceof Stinky)
/*     */     {
/*  83 */       return true;
/*     */     }
/*     */     
/*  86 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isIgnoreable(EntityLivingBase par1EntityLiving) {
/*  92 */     if (par1EntityLiving instanceof RockBase)
/*     */     {
/*  94 */       return true;
/*     */     }
/*  96 */     if (par1EntityLiving instanceof EntityAnt)
/*     */     {
/*  98 */       return true;
/*     */     }
/* 100 */     if (par1EntityLiving instanceof EntityButterfly)
/*     */     {
/* 102 */       return true;
/*     */     }
/* 104 */     if (par1EntityLiving instanceof EntityMosquito)
/*     */     {
/* 106 */       return true;
/*     */     }
/* 108 */     if (par1EntityLiving instanceof Dragonfly)
/*     */     {
/* 110 */       return true;
/*     */     }
/* 112 */     if (par1EntityLiving instanceof Firefly)
/*     */     {
/* 114 */       return true;
/*     */     }
/* 116 */     if (par1EntityLiving instanceof Cricket)
/*     */     {
/* 118 */       return true;
/*     */     }
/* 120 */     if (par1EntityLiving instanceof Cockateil)
/*     */     {
/* 122 */       return true;
/*     */     }
/* 124 */     if (par1EntityLiving instanceof Termite)
/*     */     {
/* 126 */       return true;
/*     */     }
/* 128 */     if (par1EntityLiving instanceof Ghost)
/*     */     {
/* 130 */       return true;
/*     */     }
/* 132 */     if (par1EntityLiving instanceof GhostSkelly)
/*     */     {
/* 134 */       return true;
/*     */     }
/* 136 */     if (par1EntityLiving instanceof Elevator)
/*     */     {
/* 138 */       return true;
/*     */     }
/*     */     
/* 141 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\MyUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */