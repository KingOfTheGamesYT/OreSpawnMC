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
/*    */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class RegistryHandler
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onItemRegister(RegistryEvent.Register<Item> event) {
/* 30 */     event.getRegistry().registerAll((IForgeRegistryEntry[])ModItems.ITEMS.toArray((Object[])new Item[0]));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onBlockRegister(RegistryEvent.Register<Block> event) {
/* 35 */     event.getRegistry().registerAll((IForgeRegistryEntry[])ModBlocks.BLOCKS.toArray((Object[])new Block[0]));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onModelRegister(ModelRegistryEvent event) {
/* 40 */     for (Item item : ModItems.ITEMS) {
/* 41 */       OreSpawnMain.proxy.registerItemRenderer(item, 0, "inventory");
/*    */     }
/*    */     
/* 44 */     for (Block block : ModBlocks.BLOCKS) {
/* 45 */       OreSpawnMain.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
/*    */     }
/*    */   }
/*    */   
/*    */   public static void preInitRegistries() {
/* 50 */     ModEntities.registerEntities();
/* 51 */     RenderHandler.registerEntityRenders();
/* 52 */     ModDimensions.registerDimensions();
/* 53 */     ModBiomes.registerBiomes();
/*    */   }
/*    */   
/*    */   public static void initRegistries() {
/* 57 */     SoundsHandler.registerSounds();
/* 58 */     SmeltingRecipes.init();
/* 59 */     CraftingRecipes.init();
/* 60 */     GameRegistry.registerTileEntity(TileEntityPlant.class, TileEntityPlant.class.getName());
/*    */   }
/*    */ 
/*    */   
/*    */   public static void serverRegistries(FMLServerStartingEvent event) {
/* 65 */     event.registerServerCommand((ICommand)new CommandDimensionTeleport());
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespaw\\util\handlers\RegistryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */