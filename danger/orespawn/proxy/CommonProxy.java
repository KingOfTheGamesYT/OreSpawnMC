package danger.orespawn.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
  public void registerItemRenderer(Item item, int meta, String id) {}
  
  public void init(FMLInitializationEvent event) {}
  
  public void postInit(FMLPostInitializationEvent event) {}
  
  public void preInit(FMLPreInitializationEvent event) {}
  
  public void render() {}
}


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\proxy\CommonProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */