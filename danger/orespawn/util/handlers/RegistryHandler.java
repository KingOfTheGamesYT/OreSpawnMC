/*    */ package danger.orespawn.util.handlers;
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.blocks.TileEntityPlant;
/*    */ import danger.orespawn.commands.CommandDimensionTeleport;
/*    */ import danger.orespawn.init.ModBiomes;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModDimensions;
/*    */ import danger.orespawn.init.ModEntities;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import danger.orespawn.recipes.CraftingRecipes;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.event.RegistryEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*    */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class RegistryHandler {
/*    */   @SubscribeEvent
/*    */   public static void onItemRegister(RegistryEvent.Register<Item> event) {
/* 23 */     event.getRegistry().registerAll((IForgeRegistryEntry[])ModItems.ITEMS.toArray((Object[])new Item[0]));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onBlockRegister(RegistryEvent.Register<Block> event) {
/* 28 */     event.getRegistry().registerAll((IForgeRegistryEntry[])ModBlocks.BLOCKS.toArray((Object[])new Block[0]));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onModelRegister(ModelRegistryEvent event) {
/* 33 */     for (Item item : ModItems.ITEMS) {
/* 34 */       OreSpawnMain.proxy.registerItemRenderer(item, 0, "inventory");
/*    */     }
/*    */     
/* 37 */     for (Block block : ModBlocks.BLOCKS) {
/* 38 */       OreSpawnMain.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
/*    */     }
/*    */   }
/*    */   
/*    */   public static void preInitRegistries() {
/* 43 */     ModEntities.registerEntities();
/* 44 */     RenderHandler.registerEntityRenders();
/* 45 */     ModDimensions.registerDimensions();
/* 46 */     ModBiomes.registerBiomes();
/*    */   }
/*    */   
/*    */   public static void initRegistries() {
/* 50 */     SoundsHandler.registerSounds();
/* 51 */     SmeltingRecipes.init();
/* 52 */     CraftingRecipes.init();
/* 53 */     GameRegistry.registerTileEntity(TileEntityPlant.class, TileEntityPlant.class.getName());
/*    */   }
/*    */ 
/*    */   
/*    */   public static void serverRegistries(FMLServerStartingEvent event) {
/* 58 */     event.registerServerCommand((ICommand)new CommandDimensionTeleport());
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespaw\\util\handlers\RegistryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */