/*     */ package danger.orespawn;
/*     */ import danger.orespawn.entity.Alien;
/*     */ import danger.orespawn.entity.Alosaurus;
/*     */ import danger.orespawn.entity.Kyuubi;
/*     */ import danger.orespawn.entity.Mantis;
/*     */ import danger.orespawn.entity.Mothra;
/*     */ import danger.orespawn.entity.Nastysaurus;
/*     */ import danger.orespawn.entity.Spyro;
/*     */ import danger.orespawn.entity.TRex;
/*     */ import danger.orespawn.entity.WormLarge;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ 
/*     */ public class GirlfriendOverlayGui extends Gui {
/*  22 */   private static final ResourceLocation texture = new ResourceLocation("orespawn", "girlfriendgui.png");
/*     */   private Minecraft mc;
/*     */   
/*     */   public GirlfriendOverlayGui(Minecraft mc) {
/*  26 */     this.mc = mc;
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onRenderOverlay(RenderGameOverlayEvent event) {
/*  32 */     System.out.println("RUNNING");
/*  33 */     if (event.isCancelable() || event.getType() != RenderGameOverlayEvent.ElementType.HOTBAR) {
/*     */       return;
/*     */     }
/*     */     
/*  37 */     System.out.println("GOING THRU");
/*  38 */     int u = 0;
/*  39 */     int v = 0;
/*  40 */     String outstring = null;
/*  41 */     int color = 16725044;
/*  42 */     FontRenderer fr = this.mc.fontRenderer;
/*     */     
/*  44 */     int barWidth = 182;
/*     */     
/*  46 */     int barHeight = 5;
/*     */ 
/*     */     
/*  49 */     float gfHealth = 0.0F;
/*     */     
/*  51 */     Entity entity = null;
/*  52 */     EntityPlayer player = null;
/*     */ 
/*     */ 
/*     */     
/*  56 */     if (this.mc.gameSettings.hideGUI || this.mc.currentScreen != null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  62 */     EntityPlayerSP entityPlayerSP = this.mc.player;
/*     */     
/*  64 */     if (entityPlayerSP == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     entity = this.mc.pointedEntity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 237 */     if (entity instanceof Mothra) {
/* 238 */       Mothra e = (Mothra)entity;
/* 239 */       outstring = "Mothra!";
/* 240 */       gfHealth = e.getMothraHealth() / e.getMaxHealth();
/*     */     } 
/*     */     
/* 243 */     if (entity instanceof Spyro) {
/* 244 */       Spyro e = (Spyro)entity;
/* 245 */       if (e.hasCustomName()) outstring = e.getCustomNameTag(); 
/* 246 */       if (outstring == null || outstring.equals("")) {
/* 247 */         outstring = "Baby Dragon";
/*     */       }
/*     */       
/* 250 */       gfHealth = e.getSpyroHealth() / e.getMaxHealth();
/*     */     } 
/*     */     
/* 253 */     if (entity instanceof WormLarge) {
/* 254 */       WormLarge e = (WormLarge)entity;
/* 255 */       if (!e.noClip) {
/* 256 */         outstring = "Worm";
/* 257 */         gfHealth = e.getHealth() / e.getMaxHealth();
/*     */       } 
/*     */     } 
/*     */     
/* 261 */     if (entity instanceof Alien) {
/* 262 */       Alien e = (Alien)entity;
/* 263 */       outstring = "Alien!";
/* 264 */       gfHealth = e.getAlienHealth() / e.getMaxHealth();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 307 */     if (entity instanceof Alosaurus) {
/* 308 */       Alosaurus e = (Alosaurus)entity;
/* 309 */       outstring = "Alosaurus";
/* 310 */       gfHealth = e.getHealth() / e.getMaxHealth();
/*     */     } 
/*     */     
/* 313 */     if (entity instanceof Nastysaurus) {
/* 314 */       Nastysaurus e = (Nastysaurus)entity;
/* 315 */       outstring = "Nastysaurus";
/* 316 */       gfHealth = e.getHealth() / e.getMaxHealth();
/*     */     } 
/*     */     
/* 319 */     if (entity instanceof TRex) {
/* 320 */       TRex e = (TRex)entity;
/* 321 */       outstring = "T. Rex";
/* 322 */       gfHealth = e.getHealth() / e.getMaxHealth();
/*     */     } 
/*     */     
/* 325 */     if (entity instanceof Kyuubi) {
/* 326 */       Kyuubi e = (Kyuubi)entity;
/* 327 */       outstring = "Kyuubi";
/* 328 */       gfHealth = e.getHealth() / e.getMaxHealth();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 367 */     if (entity instanceof Mantis) {
/* 368 */       Mantis e = (Mantis)entity;
/* 369 */       outstring = "Mantis";
/* 370 */       gfHealth = e.getHealth() / e.getMaxHealth();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 469 */     if (outstring == null) {
/*     */       return;
/*     */     }
/*     */     
/* 473 */     ScaledResolution res = new ScaledResolution(this.mc);
/* 474 */     int width = res.getScaledWidth();
/* 475 */     int barWidthFilled = (int)(gfHealth * (barWidth + 1));
/*     */     
/* 477 */     int x = width / 2 - barWidth / 2;
/*     */     
/* 479 */     int y = 25;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 484 */     if (entityPlayerSP.isInsideOfMaterial(Material.WATER) || entityPlayerSP.getTotalArmorValue() > 0) {
/* 485 */       y -= 10;
/*     */     }
/*     */ 
/*     */     
/* 489 */     fr.drawStringWithShadow(outstring, (width / 2 - fr.getStringWidth(outstring) / 2), (y - 10), color);
/*     */ 
/*     */ 
/*     */     
/* 493 */     this; this.mc.renderEngine.bindTexture(texture);
/*     */     
/* 495 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 497 */     drawTexturedModalRect(x, y, u, v, barWidth, barHeight);
/*     */     
/* 499 */     if (barWidthFilled > 0)
/* 500 */       drawTexturedModalRect(x, y, u, v + barHeight, barWidthFilled, barHeight); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\GirlfriendOverlayGui.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */