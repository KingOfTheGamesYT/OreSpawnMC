/*    */ package danger.orespawn;
/*    */ 
/*    */ import danger.orespawn.proxy.CommonProxy;
/*    */ import danger.orespawn.tabs.OrespawnTab;
/*    */ import danger.orespawn.util.handlers.RegistryHandler;
/*    */ import danger.orespawn.util.premium.PremiumChecker;
/*    */ import danger.orespawn.world.ButterflyPlantGenerator;
/*    */ import danger.orespawn.world.CornPlantGenerator;
/*    */ import danger.orespawn.world.gen.ores.AntHillGenerator;
/*    */ import danger.orespawn.world.gen.ores.WorldGenOres;
/*    */ import java.util.Random;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.fml.common.IWorldGenerator;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventHandler;
/*    */ import net.minecraftforge.fml.common.Mod.Instance;
/*    */ import net.minecraftforge.fml.common.SidedProxy;
/*    */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.gameevent.PlayerEvent;
/*    */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*    */ 
/*    */ 
/*    */ @Mod(modid = "orespawn", name = "OreSpawn", version = "1.0.0")
/*    */ public class OreSpawnMain
/*    */ {
/* 31 */   public static Random OreSpawnRand = new Random(151L);
/* 32 */   public static int PlayNicely = 0;
/*    */   
/*    */   @Instance
/*    */   public static OreSpawnMain instance;
/*    */   
/*    */   @SidedProxy(clientSide = "danger.orespawn.proxy.ClientProxy", serverSide = "danger.orespawn.proxy.CommonProxy")
/*    */   public static CommonProxy proxy;
/*    */   
/* 40 */   public static final CreativeTabs OreSpawnTab = (CreativeTabs)new OrespawnTab();
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void PreInit(FMLPreInitializationEvent event) {
/* 45 */     RegistryHandler.preInitRegistries();
/* 46 */     proxy.preInit(event);
/*    */     
/* 48 */     PremiumChecker.Init();
/* 49 */     GameRegistry.registerWorldGenerator((IWorldGenerator)new WorldGenOres(), 3);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void init(FMLInitializationEvent event) {
/* 56 */     RegistryHandler.initRegistries();
/* 57 */     proxy.init(event);
/* 58 */     MinecraftForge.TERRAIN_GEN_BUS.register(new CornPlantGenerator());
/* 59 */     MinecraftForge.TERRAIN_GEN_BUS.register(new ButterflyPlantGenerator());
/* 60 */     MinecraftForge.TERRAIN_GEN_BUS.register(new AntHillGenerator());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void PostInit(FMLPostInitializationEvent event) {
/* 67 */     proxy.postInit(event);
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void serverInit(FMLServerStartingEvent event) {
/* 73 */     RegistryHandler.serverRegistries(event);
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void playerJoin(PlayerEvent.PlayerLoggedInEvent event) {
/* 79 */     System.out.println("---------------------------------------------------------------------- PLAYER JOINED");
/* 80 */     PremiumChecker.CheckUser(event.player);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespawn\OreSpawnMain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */