/*    */ package danger.orespawn.proxy;
/*    */ 
/*    */ import danger.orespawn.events.ClientEvents;
/*    */ import net.minecraft.client.renderer.block.model.ModelResourceLocation;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.client.model.ModelLoader;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*    */ 
/*    */ public class ClientProxy extends CommonProxy {
/*    */   public void registerItemRenderer(Item item, int meta, String id) {
/* 12 */     ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void postInit(FMLPostInitializationEvent event) {
/* 19 */     super.postInit(event);
/* 20 */     MinecraftForge.EVENT_BUS.register(new ClientEvents());
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\proxy\ClientProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */