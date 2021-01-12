/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.common.gameevent.TickEvent;
/*    */ import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RiderControl
/*    */ {
/* 28 */   private final RiderControlMessage rcm = new RiderControlMessage();
/*    */   private final SimpleNetworkWrapper network;
/* 30 */   private int keystate = 0;
/*    */   
/*    */   public RiderControl(SimpleNetworkWrapper network) {
/* 33 */     this.network = network;
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onTick(TickEvent.ClientTickEvent evt) {
/* 38 */     int newkeystate = 0;
/* 39 */     if (KeyHandler.KEY_FLY_UP.getIsKeyPressed()) newkeystate = 1;
/*    */ 
/*    */     
/* 42 */     if (this.keystate != newkeystate) {
/* 43 */       this.rcm.keystate = newkeystate;
/* 44 */       this.network.sendToServer(this.rcm);
/* 45 */       this.keystate = newkeystate;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RiderControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */