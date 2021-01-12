/*    */ package danger.orespawn;
/*    */ 
/*    */ import danger.orespawn.proxy.CommonProxy;
/*    */ import danger.orespawn.util.handlers.RegistryHandler;
/*    */ import danger.orespawn.util.premium.PremiumChecker;
/*    */ import java.util.Random;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventHandler;
/*    */ import net.minecraftforge.fml.common.Mod.Instance;
/*    */ import net.minecraftforge.fml.common.SidedProxy;
/*    */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
/*    */ import net.minecraftforge.fml.common.gameevent.PlayerEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mod(modid = "orespawn", name = "OreSpawn", version = "1.0.0")
/*    */ public class OreSpawnMain
/*    */ {
/* 23 */   public static Random OreSpawnRand = new Random(151L);
/* 24 */   public static int PlayNicely = 0;
/*    */   
/*    */   @Instance
/*    */   public static OreSpawnMain instance;
/*    */   
/*    */   @SidedProxy(clientSide = "danger.orespawn.proxy.ClientProxy", serverSide = "danger.orespawn.proxy.CommonProxy")
/*    */   public static CommonProxy proxy;
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void PreInit(FMLPreInitializationEvent event) {
/* 35 */     RegistryHandler.preInitRegistries();
/* 36 */     proxy.preInit(event);
/*    */     
/* 38 */     PremiumChecker.Init();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void init(FMLInitializationEvent event) {
/* 45 */     RegistryHandler.initRegistries();
/* 46 */     proxy.init(event);
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void PostInit(FMLPostInitializationEvent event) {
/* 52 */     proxy.postInit(event);
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void serverInit(FMLServerStartingEvent event) {
/* 58 */     RegistryHandler.serverRegistries(event);
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void playerJoin(PlayerEvent.PlayerLoggedInEvent event) {
/* 64 */     System.out.println("---------------------------------------------------------------------- PLAYER JOINED");
/* 65 */     PremiumChecker.CheckUser(event.player);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\OreSpawnMain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */