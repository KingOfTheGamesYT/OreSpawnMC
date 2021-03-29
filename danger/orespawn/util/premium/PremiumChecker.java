/*    */ package danger.orespawn.util.premium;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ import java.nio.charset.Charset;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import org.apache.commons.io.IOUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PremiumChecker
/*    */ {
/* 17 */   static String urlString = "https://raw.githubusercontent.com/TheyCallMeDanger/OreSpawn_PublicData/main/boringdata.dat";
/*    */ 
/*    */ 
/*    */   
/*    */   private static String[] viableUUIDs;
/*    */ 
/*    */ 
/*    */   
/*    */   private static final boolean DEV_USER = false;
/*    */ 
/*    */   
/*    */   private static final boolean PREMIUM_BUILD = true;
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean CheckUser(EntityPlayer player) {
/* 33 */     String trimmedUUID = EntityPlayer.getUUID(player.getGameProfile()).toString().replace("-", "");
/*    */     
/* 35 */     for (String s : viableUUIDs) {
/*    */       
/* 37 */       if (trimmedUUID.equals(s)) {
/* 38 */         return true;
/*    */       }
/*    */     } 
/*    */     
/* 42 */     throw new PlayerNotPremiumError("The user \"" + player.getName() + "\" is not premium. Either use the public version of the mod, or donate to https://www.gofundme.com/f/orespawn-update to use this version.");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void Init() {
/* 49 */     String URLString = "https://raw.githubusercontent.com/TheyCallMeDanger/OreSpawn_PublicData/main/boringdata.dat";
/*    */     
/*    */     try {
/* 52 */       HttpURLConnection con = (HttpURLConnection)(new URL(urlString)).openConnection();
/* 53 */       con.setConnectTimeout(1000);
/* 54 */       InputStream in2 = con.getInputStream();
/* 55 */       List<String> lines = IOUtils.readLines(in2, Charset.defaultCharset());
/*    */ 
/*    */       
/* 58 */       List<String> uuids = new ArrayList<>();
/* 59 */       for (String line : lines) {
/* 60 */         if (line.length() < 32)
/*    */           continue; 
/* 62 */         String uuidString = line.substring(0, 32);
/* 63 */         String accept = line.substring(33);
/*    */         
/* 65 */         if (!accept.equals("true"))
/*    */           continue; 
/* 67 */         uuids.add(uuidString);
/*    */       } 
/* 69 */       viableUUIDs = new String[uuids.size()];
/* 70 */       for (int i = 0; i < viableUUIDs.length; i++) {
/* 71 */         viableUUIDs[i] = uuids.get(i);
/*    */       }
/*    */     }
/* 74 */     catch (Exception e) {
/* 75 */       System.out.println(e);
/*    */       
/* 77 */       viableUUIDs = new String[0];
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespaw\\util\premium\PremiumChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */