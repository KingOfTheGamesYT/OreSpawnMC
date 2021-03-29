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
/*    */ 
/*    */ public class ClientProxy
/*    */   extends CommonProxy
/*    */ {
/*    */   public void registerItemRenderer(Item item, int meta, String id) {
/* 19 */     ResourceLocation resourceLocation = item.getRegistryName();
/* 20 */     if (resourceLocation != null) {
/* 21 */       ModelResourceLocation modelResourceLocation = new ModelResourceLocation(resourceLocation, id);
/* 22 */       ModelLoader.setCustomModelResourceLocation(item, meta, modelResourceLocation);
/*    */     } else {
/* 24 */       System.out.println("Resource Location was null.");
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void PreInit(FMLPreInitializationEvent event) {
/* 31 */     RenderHandler.registerEntityRenders();
/*    */   }
/*    */ 
/*    */   
/*    */   public void postInit(FMLPostInitializationEvent event) {
/* 36 */     super.postInit(event);
/* 37 */     MinecraftForge.EVENT_BUS.register(new ClientEvents());
/*    */   }
/*    */   
/*    */   public void render() {}
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\proxy\ClientProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */