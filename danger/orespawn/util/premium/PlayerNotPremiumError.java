/*    */ package danger.orespawn.util.premium;
/*    */ 
/*    */ 
/*    */ public class PlayerNotPremiumError
/*    */   extends Error
/*    */ {
/*    */   public PlayerNotPremiumError() {}
/*    */   
/*    */   public PlayerNotPremiumError(String message) {
/* 10 */     super(message);
/*    */   }
/*    */ 
/*    */   
/*    */   public PlayerNotPremiumError(Throwable cause) {
/* 15 */     super(cause);
/*    */   }
/*    */ 
/*    */   
/*    */   public PlayerNotPremiumError(String message, Throwable cause) {
/* 20 */     super(message, cause);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PlayerNotPremiumError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
/* 26 */     super(message, cause, enableSuppression, writableStackTrace);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespaw\\util\premium\PlayerNotPremiumError.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */