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
/*    */ 
/*    */ public class PremiumChecker
/*    */ {
/* 18 */   static String urlString = "https://raw.githubusercontent.com/TheyCallMeDanger/OreSpawn_PublicData/main/boringdata.dat";
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
/*    */   
/*    */   private static final boolean PREMIUM_BUILD = true;
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean CheckUser(EntityPlayer player) {
/* 35 */     String trimmedUUID = EntityPlayer.getUUID(player.getGameProfile()).toString().replace("-", "");
/*    */     
/* 37 */     for (String s : viableUUIDs) {
/*    */ 
/*    */       
/* 40 */       if (trimmedUUID.equals(s))
/*    */       {
/* 42 */         return true;
/*    */       }
/*    */     } 
/*    */     
/* 46 */     throw new PlayerNotPremiumError("The user \"" + player.getName() + "\" is not premium. Either use the public version of the mod, or donate to https://www.gofundme.com/f/orespawn-update to use this version.");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void Init() {
/* 52 */     String URLString = "https://raw.githubusercontent.com/TheyCallMeDanger/OreSpawn_PublicData/main/boringdata.dat";
/*    */     
/*    */     try {
/* 55 */       HttpURLConnection con = (HttpURLConnection)(new URL(urlString)).openConnection();
/* 56 */       con.setConnectTimeout(1000);
/* 57 */       InputStream in2 = con.getInputStream();
/* 58 */       List<String> lines = IOUtils.readLines(in2, Charset.defaultCharset());
/*    */ 
/*    */       
/* 61 */       List<String> uuids = new ArrayList<>();
/* 62 */       for (String line : lines) {
/*    */         
/* 64 */         if (line.length() < 32)
/*    */           continue; 
/* 66 */         String uuidString = line.substring(0, 32);
/* 67 */         String accept = line.substring(33);
/*    */         
/* 69 */         if (!accept.equals("true"))
/*    */           continue; 
/* 71 */         uuids.add(uuidString);
/*    */       } 
/* 73 */       viableUUIDs = new String[uuids.size()];
/* 74 */       for (int i = 0; i < viableUUIDs.length; i++)
/*    */       {
/* 76 */         viableUUIDs[i] = uuids.get(i);
/*    */       }
/*    */     }
/* 79 */     catch (Exception e) {
/*    */       
/* 81 */       System.out.println(e);
/*    */       
/* 83 */       viableUUIDs = new String[0];
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespaw\\util\premium\PremiumChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */