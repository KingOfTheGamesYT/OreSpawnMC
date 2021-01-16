/*    */ package danger.orespawn.proxy;
/*    */ 
/*    */ import danger.orespawn.events.ClientEvents;
/*    */ import net.minecraft.client.renderer.block.model.ModelResourceLocation;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.model.ModelLoader;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*    */ 
/*    */ public class ClientProxy extends CommonProxy {
/*    */   public void registerItemRenderer(Item item, int meta, String id) {
/* 13 */     ResourceLocation resourceLocation = item.getRegistryName();
/* 14 */     if (resourceLocation != null) {
/* 15 */       ModelResourceLocation modelResourceLocation = new ModelResourceLocation(resourceLocation, id);
/* 16 */       ModelLoader.setCustomModelResourceLocation(item, meta, modelResourceLocation);
/*    */     } else {
/* 18 */       System.out.println("Resource Location was null.");
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void postInit(FMLPostInitializationEvent event) {
/* 26 */     super.postInit(event);
/* 27 */     MinecraftForge.EVENT_BUS.register(new ClientEvents());
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\proxy\ClientProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */