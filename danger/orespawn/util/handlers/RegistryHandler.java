/*    */ package danger.orespawn.util.handlers;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.blocks.TileEntityPlant;
/*    */ import danger.orespawn.commands.CommandDimensionTeleport;
/*    */ import danger.orespawn.init.ModBiomes;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModDimensions;
/*    */ import danger.orespawn.init.ModEntities;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import danger.orespawn.recipes.CraftingRecipes;
/*    */ import danger.orespawn.recipes.SmeltingRecipes;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.client.event.ModelRegistryEvent;
/*    */ import net.minecraftforge.event.RegistryEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class RegistryHandler
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onItemRegister(RegistryEvent.Register<Item> event) {
/* 33 */     event.getRegistry().registerAll((IForgeRegistryEntry[])ModItems.ITEMS.toArray((Object[])new Item[0]));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onBlockRegister(RegistryEvent.Register<Block> event) {
/* 38 */     event.getRegistry().registerAll((IForgeRegistryEntry[])ModBlocks.BLOCKS.toArray((Object[])new Block[0]));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   @SideOnly(Side.CLIENT)
/*    */   public static void onModelRegister(ModelRegistryEvent event) {
/* 44 */     RenderHandler.registerEntityRenders();
/* 45 */     for (Item item : ModItems.ITEMS) {
/* 46 */       OreSpawnMain.proxy.registerItemRenderer(item, 0, "inventory");
/*    */     }
/*    */     
/* 49 */     for (Block block : ModBlocks.BLOCKS) {
/* 50 */       OreSpawnMain.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
/*    */     }
/*    */   }
/*    */   
/*    */   public static void preInitRegistries() {
/* 55 */     ModEntities.registerEntities();
/* 56 */     ModDimensions.registerDimensions();
/* 57 */     ModBiomes.registerBiomes();
/*    */   }
/*    */   
/*    */   public static void initRegistries() {
/* 61 */     SoundsHandler.registerSounds();
/* 62 */     SmeltingRecipes.init();
/* 63 */     CraftingRecipes.init();
/* 64 */     GameRegistry.registerTileEntity(TileEntityPlant.class, TileEntityPlant.class.getName());
/*    */   }
/*    */ 
/*    */   
/*    */   public static void serverRegistries(FMLServerStartingEvent event) {
/* 69 */     event.registerServerCommand((ICommand)new CommandDimensionTeleport());
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespaw\\util\handlers\RegistryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */