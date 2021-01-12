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
/*    */ @EventBusSubscriber(modid = "orespawn", value = {Side.CLIENT})
/*    */ public class ClientEvents
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
/* 17 */     boolean premium = PremiumChecker.CheckUser(event.player);
/* 18 */     if (premium) {
/* 19 */       TextComponentString textComponentString = new TextComponentString("Welcome premium user!");
/* 20 */       textComponentString.getStyle().setColor(TextFormatting.GOLD);
/* 21 */       event.player.sendMessage((ITextComponent)textComponentString);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespawn\events\ClientEvents.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */