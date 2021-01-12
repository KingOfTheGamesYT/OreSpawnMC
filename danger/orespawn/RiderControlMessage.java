/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import io.netty.buffer.ByteBuf;
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
/*    */ public class RiderControlMessage
/*    */   implements IMessage
/*    */ {
/* 27 */   public int keystate = 0;
/*    */   
/*    */   private int previous;
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 32 */     fromInteger(buf.readUnsignedByte());
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 37 */     buf.writeByte(toInteger());
/*    */   }
/*    */   
/*    */   public void fromInteger(int value) {
/* 41 */     this.keystate = value;
/*    */   }
/*    */   
/*    */   public int toInteger() {
/* 45 */     return this.keystate;
/*    */   }
/*    */   
/*    */   public boolean hasChanged() {
/* 49 */     int current = this.keystate;
/* 50 */     boolean changed = (this.previous != current);
/* 51 */     this.previous = current;
/* 52 */     return changed;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RiderControlMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */