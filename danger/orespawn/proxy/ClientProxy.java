/*    */ package danger.orespawn.proxy;
/*    */ 
/*    */ import danger.orespawn.events.ClientEvents;
/*    */ import danger.orespawn.util.handlers.RenderHandler;
/*    */ import net.minecraft.client.renderer.block.model.ModelResourceLocation;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.model.ModelLoader;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.fml.common.Mod.EventHandler;
/*    */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*    */ 
/*    */ public class ClientProxy extends CommonProxy {
/*    */   public void registerItemRenderer(Item item, int meta, String id) {
/* 16 */     ResourceLocation resourceLocation = item.getRegistryName();
/* 17 */     if (resourceLocation != null) {
/* 18 */       ModelResourceLocation modelResourceLocation = new ModelResourceLocation(resourceLocation, id);
/* 19 */       ModelLoader.setCustomModelResourceLocation(item, meta, modelResourceLocation);
/*    */     } else {
/* 21 */       System.out.println("Resource Location was null.");
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void PreInit(FMLPreInitializationEvent event) {
/* 28 */     RenderHandler.registerEntityRenders();
/*    */   }
/*    */ 
/*    */   
/*    */   public void postInit(FMLPostInitializationEvent event) {
/* 33 */     super.postInit(event);
/* 34 */     MinecraftForge.EVENT_BUS.register(new ClientEvents());
/*    */   }
/*    */   
/*    */   public void render() {}
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\proxy\ClientProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */