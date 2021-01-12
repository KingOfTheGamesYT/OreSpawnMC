/*    */ package danger.orespawn.util.handlers;
/*    */ 
/*    */ import danger.orespawn.entity.Alosaurus;
/*    */ import danger.orespawn.entity.Baryonyx;
/*    */ import danger.orespawn.entity.Camarasaurus;
/*    */ import danger.orespawn.entity.TRex;
/*    */ import danger.orespawn.entity.render.RenderAlosaurus;
/*    */ import danger.orespawn.entity.render.RenderBaryonyx;
/*    */ import danger.orespawn.entity.render.RenderCamarasaurus;
/*    */ import danger.orespawn.entity.render.RenderTRex;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraftforge.fml.client.registry.IRenderFactory;
/*    */ import net.minecraftforge.fml.client.registry.RenderingRegistry;
/*    */ 
/*    */ public class RenderHandler {
/*    */   public static void registerEntityRenders() {
/* 18 */     RenderingRegistry.registerEntityRenderingHandler(Alosaurus.class, new IRenderFactory<Alosaurus>()
/*    */         {
/*    */           public Render<? super Alosaurus> createRenderFor(RenderManager manager) {
/* 21 */             return (Render<? super Alosaurus>)new RenderAlosaurus(manager);
/*    */           }
/*    */         });
/* 24 */     RenderingRegistry.registerEntityRenderingHandler(TRex.class, new IRenderFactory<TRex>()
/*    */         {
/*    */           public Render<? super TRex> createRenderFor(RenderManager manager) {
/* 27 */             return (Render<? super TRex>)new RenderTRex(manager);
/*    */           }
/*    */         });
/* 30 */     RenderingRegistry.registerEntityRenderingHandler(Baryonyx.class, new IRenderFactory<Baryonyx>()
/*    */         {
/*    */           public Render<? super Baryonyx> createRenderFor(RenderManager manager) {
/* 33 */             return (Render<? super Baryonyx>)new RenderBaryonyx(manager);
/*    */           }
/*    */         });
/* 36 */     RenderingRegistry.registerEntityRenderingHandler(Camarasaurus.class, new IRenderFactory<Camarasaurus>()
/*    */         {
/*    */           public Render<? super Camarasaurus> createRenderFor(RenderManager manager) {
/* 39 */             return (Render<? super Camarasaurus>)new RenderCamarasaurus(manager);
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespaw\\util\handlers\RenderHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */