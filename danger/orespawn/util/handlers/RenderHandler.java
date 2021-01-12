/*    */ package danger.orespawn.util.handlers;
/*    */ import danger.orespawn.entity.Camarasaurus;
/*    */ import danger.orespawn.entity.Cryolophosaurus;
/*    */ import danger.orespawn.entity.Pointysaurus;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraftforge.fml.client.registry.IRenderFactory;
/*    */ import net.minecraftforge.fml.client.registry.RenderingRegistry;
/*    */ 
/*    */ public class RenderHandler {
/*    */   public static void registerEntityRenders() {
/* 12 */     RenderingRegistry.registerEntityRenderingHandler(Alosaurus.class, new IRenderFactory<Alosaurus>()
/*    */         {
/*    */           public Render<? super Alosaurus> createRenderFor(RenderManager manager) {
/* 15 */             return (Render<? super Alosaurus>)new RenderAlosaurus(manager);
/*    */           }
/*    */         });
/* 18 */     RenderingRegistry.registerEntityRenderingHandler(TRex.class, new IRenderFactory<TRex>()
/*    */         {
/*    */           public Render<? super TRex> createRenderFor(RenderManager manager) {
/* 21 */             return (Render<? super TRex>)new RenderTRex(manager);
/*    */           }
/*    */         });
/* 24 */     RenderingRegistry.registerEntityRenderingHandler(Baryonyx.class, new IRenderFactory<Baryonyx>()
/*    */         {
/*    */           public Render<? super Baryonyx> createRenderFor(RenderManager manager) {
/* 27 */             return (Render<? super Baryonyx>)new RenderBaryonyx(manager);
/*    */           }
/*    */         });
/* 30 */     RenderingRegistry.registerEntityRenderingHandler(Camarasaurus.class, new IRenderFactory<Camarasaurus>()
/*    */         {
/*    */           public Render<? super Camarasaurus> createRenderFor(RenderManager manager) {
/* 33 */             return (Render<? super Camarasaurus>)new RenderCamarasaurus(manager);
/*    */           }
/*    */         });
/* 36 */     RenderingRegistry.registerEntityRenderingHandler(RedAnt.class, new IRenderFactory<RedAnt>()
/*    */         {
/*    */           public Render<? super RedAnt> createRenderFor(RenderManager manager) {
/* 39 */             return (Render<? super RedAnt>)new RenderRedAnt(manager);
/*    */           }
/*    */         });
/* 42 */     RenderingRegistry.registerEntityRenderingHandler(Cryolophosaurus.class, new IRenderFactory<Cryolophosaurus>()
/*    */         {
/*    */           public Render<? super Cryolophosaurus> createRenderFor(RenderManager manager) {
/* 45 */             return (Render<? super Cryolophosaurus>)new RenderCryolophosaurus(manager);
/*    */           }
/*    */         });
/* 48 */     RenderingRegistry.registerEntityRenderingHandler(Pointysaurus.class, new IRenderFactory<Pointysaurus>()
/*    */         {
/*    */           public Render<? super Pointysaurus> createRenderFor(RenderManager manager) {
/* 51 */             return (Render<? super Pointysaurus>)new RenderPointysaurus(manager);
/*    */           }
/*    */         });
/* 54 */     RenderingRegistry.registerEntityRenderingHandler(CaveFisher.class, new IRenderFactory<CaveFisher>()
/*    */         {
/*    */           public Render<? super CaveFisher> createRenderFor(RenderManager manager) {
/* 57 */             return (Render<? super CaveFisher>)new RenderCaveFisher(manager);
/*    */           }
/*    */         });
/* 60 */     RenderingRegistry.registerEntityRenderingHandler(Butterfly.class, new IRenderFactory<Butterfly>()
/*    */         {
/*    */           public Render<? super Butterfly> createRenderFor(RenderManager manager) {
/* 63 */             return (Render<? super Butterfly>)new RenderButterfly(manager);
/*    */           }
/*    */         });
/* 66 */     RenderingRegistry.registerEntityRenderingHandler(Bird.class, new IRenderFactory<Bird>()
/*    */         {
/*    */           public Render<? super Bird> createRenderFor(RenderManager manager) {
/* 69 */             return (Render<? super Bird>)new RenderBird(manager);
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespaw\\util\handlers\RenderHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */