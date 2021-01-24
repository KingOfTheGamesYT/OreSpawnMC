/*    */ package danger.orespawn.util.handlers;
/*    */ import danger.orespawn.entity.Baryonyx;
/*    */ import danger.orespawn.entity.Bird;
/*    */ import danger.orespawn.entity.Butterfly;
/*    */ import danger.orespawn.entity.Camarasaurus;
/*    */ import danger.orespawn.entity.CaveFisher;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraftforge.fml.client.registry.IRenderFactory;
/*    */ import net.minecraftforge.fml.client.registry.RenderingRegistry;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderHandler {
/*    */   public static void registerEntityRenders() {
/* 15 */     RenderingRegistry.registerEntityRenderingHandler(Alosaurus.class, new IRenderFactory<Alosaurus>()
/*    */         {
/*    */           public Render<? super Alosaurus> createRenderFor(RenderManager manager) {
/* 18 */             return (Render<? super Alosaurus>)new RenderAlosaurus(manager);
/*    */           }
/*    */         });
/* 21 */     RenderingRegistry.registerEntityRenderingHandler(TRex.class, new IRenderFactory<TRex>()
/*    */         {
/*    */           public Render<? super TRex> createRenderFor(RenderManager manager) {
/* 24 */             return (Render<? super TRex>)new RenderTRex(manager);
/*    */           }
/*    */         });
/* 27 */     RenderingRegistry.registerEntityRenderingHandler(Baryonyx.class, new IRenderFactory<Baryonyx>()
/*    */         {
/*    */           public Render<? super Baryonyx> createRenderFor(RenderManager manager) {
/* 30 */             return (Render<? super Baryonyx>)new RenderBaryonyx(manager);
/*    */           }
/*    */         });
/* 33 */     RenderingRegistry.registerEntityRenderingHandler(Camarasaurus.class, new IRenderFactory<Camarasaurus>()
/*    */         {
/*    */           public Render<? super Camarasaurus> createRenderFor(RenderManager manager) {
/* 36 */             return (Render<? super Camarasaurus>)new RenderCamarasaurus(manager);
/*    */           }
/*    */         });
/* 39 */     RenderingRegistry.registerEntityRenderingHandler(RedAnt.class, new IRenderFactory<RedAnt>()
/*    */         {
/*    */           public Render<? super RedAnt> createRenderFor(RenderManager manager) {
/* 42 */             return (Render<? super RedAnt>)new RenderRedAnt(manager);
/*    */           }
/*    */         });
/* 45 */     RenderingRegistry.registerEntityRenderingHandler(Cryolophosaurus.class, new IRenderFactory<Cryolophosaurus>()
/*    */         {
/*    */           public Render<? super Cryolophosaurus> createRenderFor(RenderManager manager) {
/* 48 */             return (Render<? super Cryolophosaurus>)new RenderCryolophosaurus(manager);
/*    */           }
/*    */         });
/* 51 */     RenderingRegistry.registerEntityRenderingHandler(Pointysaurus.class, new IRenderFactory<Pointysaurus>()
/*    */         {
/*    */           public Render<? super Pointysaurus> createRenderFor(RenderManager manager) {
/* 54 */             return (Render<? super Pointysaurus>)new RenderPointysaurus(manager);
/*    */           }
/*    */         });
/* 57 */     RenderingRegistry.registerEntityRenderingHandler(CaveFisher.class, new IRenderFactory<CaveFisher>()
/*    */         {
/*    */           public Render<? super CaveFisher> createRenderFor(RenderManager manager) {
/* 60 */             return (Render<? super CaveFisher>)new RenderCaveFisher(manager);
/*    */           }
/*    */         });
/* 63 */     RenderingRegistry.registerEntityRenderingHandler(Butterfly.class, new IRenderFactory<Butterfly>()
/*    */         {
/*    */           public Render<? super Butterfly> createRenderFor(RenderManager manager) {
/* 66 */             return (Render<? super Butterfly>)new RenderButterfly(manager);
/*    */           }
/*    */         });
/* 69 */     RenderingRegistry.registerEntityRenderingHandler(Bird.class, new IRenderFactory<Bird>()
/*    */         {
/*    */           public Render<? super Bird> createRenderFor(RenderManager manager) {
/* 72 */             return (Render<? super Bird>)new RenderBird(manager);
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespaw\\util\handlers\RenderHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */