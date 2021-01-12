/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.client.registry.ClientRegistry;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.common.gameevent.InputEvent;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.settings.KeyBinding;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KeyHandler
/*    */ {
/*    */   private final Minecraft mc;
/*    */   public static final String KEY_CATEGORY = "key.categories.orespawn";
/* 18 */   public static final KeyBinding KEY_FLY_UP = new KeyBinding("OreSpawn UP/FAST", 56, "key.categories.orespawn");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public KeyHandler() {
/* 24 */     this.mc = Minecraft.getMinecraft();
/* 25 */     ClientRegistry.registerKeyBinding(KEY_FLY_UP);
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onKeyInput(InputEvent.KeyInputEvent event) {}
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\KeyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */