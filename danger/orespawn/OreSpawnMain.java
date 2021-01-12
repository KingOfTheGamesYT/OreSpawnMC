/*    */ package danger.orespawn;
/*    */ 
/*    */ import danger.orespawn.proxy.CommonProxy;
/*    */ import danger.orespawn.util.handlers.RegistryHandler;
/*    */ import java.util.Random;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventHandler;
/*    */ import net.minecraftforge.fml.common.Mod.Instance;
/*    */ import net.minecraftforge.fml.common.SidedProxy;
/*    */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mod(modid = "orespawn", name = "OreSpawn", version = "1.0.0")
/*    */ public class OreSpawnMain
/*    */ {
/* 22 */   public static Random OreSpawnRand = new Random(151L);
/* 23 */   public static int PlayNicely = 0;
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
/* 34 */     RegistryHandler.preInitRegistries();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void init(FMLInitializationEvent event) {
/* 41 */     RegistryHandler.initRegistries();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void PostInit(FMLPostInitializationEvent event) {}
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public static void serverInit(FMLServerStartingEvent event) {
/* 54 */     RegistryHandler.serverRegistries(event);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespawn\OreSpawnMain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */