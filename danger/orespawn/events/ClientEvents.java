/*    */ package danger.orespawn.events;
/*    */ 
/*    */ import danger.orespawn.util.premium.PremiumChecker;
/*    */ import net.minecraft.util.text.ITextComponent;
/*    */ import net.minecraft.util.text.TextComponentString;
/*    */ import net.minecraft.util.text.TextFormatting;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.gameevent.PlayerEvent;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "orespawn", value = {Side.CLIENT})
/*    */ public class ClientEvents
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
/* 19 */     boolean premium = PremiumChecker.CheckUser(event.player);
/* 20 */     if (premium) {
/*    */       
/* 22 */       TextComponentString textComponentString = new TextComponentString("Welcome premium user!");
/* 23 */       textComponentString.getStyle().setColor(TextFormatting.GOLD);
/* 24 */       event.player.sendMessage((ITextComponent)textComponentString);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\events\ClientEvents.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */