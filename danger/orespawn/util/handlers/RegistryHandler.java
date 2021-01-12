/*    */ package danger.orespawn.util.handlers;
/*    */ import danger.orespawn.commands.CommandDimensionTeleport;
/*    */ import danger.orespawn.init.DimensionInit;
/*    */ import danger.orespawn.init.EntityInit;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import danger.orespawn.util.IHasModel;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.client.event.ModelRegistryEvent;
/*    */ import net.minecraftforge.event.RegistryEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class RegistryHandler {
/*    */   @SubscribeEvent
/*    */   public static void onItemRegister(RegistryEvent.Register<Item> event) {
/* 20 */     event.getRegistry().registerAll((IForgeRegistryEntry[])ModItems.ITEMS.toArray((Object[])new Item[0]));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onModelRegister(ModelRegistryEvent event) {
/* 25 */     for (Item item : ModItems.ITEMS) {
/* 26 */       if (item instanceof IHasModel) {
/* 27 */         ((IHasModel)item).registerModels();
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void preInitRegistries() {
/* 33 */     EntityInit.registerEntities();
/* 34 */     RenderHandler.registerEntityRenders();
/* 35 */     DimensionInit.registerDimensions();
/*    */   }
/*    */   
/*    */   public static void initRegistries() {
/* 39 */     SoundsHandler.registerSounds();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void serverRegistries(FMLServerStartingEvent event) {
/* 44 */     event.registerServerCommand((ICommand)new CommandDimensionTeleport());
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespaw\\util\handlers\RegistryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */