/*    */ package danger.orespawn.util.handlers;
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.blocks.TileEntityPlant;
/*    */ import danger.orespawn.commands.CommandDimensionTeleport;
/*    */ import danger.orespawn.init.EntitySpawns;
/*    */ import danger.orespawn.init.ModBiomes;
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.init.ModEntities;
/*    */ import danger.orespawn.init.ModItems;
/*    */ import danger.orespawn.recipes.CraftingRecipes;
/*    */ import danger.orespawn.world.gen.StructureGenerator;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.event.RegistryEvent;
/*    */ import net.minecraftforge.fml.common.IWorldGenerator;
/*    */ import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class RegistryHandler {
/*    */   @SubscribeEvent
/*    */   public static void onItemRegister(RegistryEvent.Register<Item> event) {
/* 26 */     event.getRegistry().registerAll((IForgeRegistryEntry[])ModItems.ITEMS.toArray((Object[])new Item[0]));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onBlockRegister(RegistryEvent.Register<Block> event) {
/* 31 */     event.getRegistry().registerAll((IForgeRegistryEntry[])ModBlocks.BLOCKS.toArray((Object[])new Block[0]));
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   @SideOnly(Side.CLIENT)
/*    */   public static void onModelRegister(ModelRegistryEvent event) {
/* 37 */     RenderHandler.registerEntityRenders();
/* 38 */     for (Item item : ModItems.ITEMS) {
/* 39 */       OreSpawnMain.proxy.registerItemRenderer(item, 0, "inventory");
/*    */     }
/*    */     
/* 42 */     for (Block block : ModBlocks.BLOCKS) {
/* 43 */       OreSpawnMain.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
/*    */     }
/*    */   }
/*    */   
/*    */   public static void preInitRegistries() {
/* 48 */     ModEntities.registerEntities();
/* 49 */     ModDimensions.registerDimensions();
/* 50 */     ModBiomes.registerBiomes();
/* 51 */     EntitySpawns.addSpawns();
/* 52 */     GameRegistry.registerWorldGenerator((IWorldGenerator)new StructureGenerator(), 3);
/*    */   }
/*    */   
/*    */   public static void initRegistries() {
/* 56 */     SoundsHandler.registerSounds();
/* 57 */     SmeltingRecipes.init();
/* 58 */     CraftingRecipes.init();
/* 59 */     GameRegistry.registerTileEntity(TileEntityPlant.class, TileEntityPlant.class.getName());
/*    */   }
/*    */   
/*    */   public static void serverRegistries(FMLServerStartingEvent event) {
/* 63 */     event.registerServerCommand((ICommand)new CommandDimensionTeleport());
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespaw\\util\handlers\RegistryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */