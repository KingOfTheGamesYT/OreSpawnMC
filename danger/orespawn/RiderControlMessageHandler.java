/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import io.netty.channel.ChannelHandler.Sharable;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
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
/*    */ @Sharable
/*    */ public class RiderControlMessageHandler
/*    */   implements IMessageHandler<RiderControlMessage, IMessage>
/*    */ {
/* 30 */   private static final Logger L = LogManager.getLogger();
/*    */ 
/*    */ 
/*    */   
/*    */   public IMessage onMessage(RiderControlMessage message, MessageContext ctx) {
/* 35 */     if (ctx.side == Side.CLIENT)
/*    */     {
/* 37 */       return null;
/*    */     }
/*    */     
/* 40 */     OreSpawnMain.flyup_keystate = message.keystate;
/*    */ 
/*    */     
/* 43 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RiderControlMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */