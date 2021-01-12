/*   */ package danger.orespawn.proxy;
/*   */ 
/*   */ import net.minecraft.client.renderer.block.model.ModelResourceLocation;
/*   */ import net.minecraft.item.Item;
/*   */ import net.minecraftforge.client.model.ModelLoader;
/*   */ 
/*   */ public class ClientProxy extends CommonProxy {
/*   */   public void registerItemRenderer(Item item, int meta, String id) {
/* 9 */     ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
/*   */   }
/*   */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespawn\proxy\ClientProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */