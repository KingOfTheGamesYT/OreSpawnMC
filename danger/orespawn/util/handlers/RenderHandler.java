/*    */ package danger.orespawn.util.handlers;
/*    */ import danger.orespawn.entity.Alien;
/*    */ import danger.orespawn.entity.Cryolophosaurus;
/*    */ import danger.orespawn.entity.Dragonfly;
/*    */ import danger.orespawn.entity.Firefly;
/*    */ import danger.orespawn.entity.Mosquito;
/*    */ import danger.orespawn.entity.Nastysaurus;
/*    */ import danger.orespawn.entity.Pointysaurus;
/*    */ import net.minecraftforge.fml.client.registry.IRenderFactory;
/*    */ import net.minecraftforge.fml.client.registry.RenderingRegistry;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderHandler {
/*    */   public static void registerEntityRenders() {
/* 17 */     RenderingRegistry.registerEntityRenderingHandler(Alosaurus.class, danger.orespawn.entity.render.RenderAlosaurus::new);
/* 18 */     RenderingRegistry.registerEntityRenderingHandler(TRex.class, danger.orespawn.entity.render.RenderTRex::new);
/* 19 */     RenderingRegistry.registerEntityRenderingHandler(Baryonyx.class, danger.orespawn.entity.render.RenderBaryonyx::new);
/* 20 */     RenderingRegistry.registerEntityRenderingHandler(Camarasaurus.class, danger.orespawn.entity.render.RenderCamarasaurus::new);
/* 21 */     RenderingRegistry.registerEntityRenderingHandler(RedAnt.class, danger.orespawn.entity.render.RenderRedAnt::new);
/* 22 */     RenderingRegistry.registerEntityRenderingHandler(Cryolophosaurus.class, danger.orespawn.entity.render.RenderCryolophosaurus::new);
/* 23 */     RenderingRegistry.registerEntityRenderingHandler(Pointysaurus.class, danger.orespawn.entity.render.RenderPointysaurus::new);
/* 24 */     RenderingRegistry.registerEntityRenderingHandler(CaveFisher.class, danger.orespawn.entity.render.RenderCaveFisher::new);
/* 25 */     RenderingRegistry.registerEntityRenderingHandler(Butterfly.class, danger.orespawn.entity.render.RenderButterfly::new);
/* 26 */     RenderingRegistry.registerEntityRenderingHandler(Bird.class, danger.orespawn.entity.render.RenderBird::new);
/* 27 */     RenderingRegistry.registerEntityRenderingHandler(GammaMetroid.class, danger.orespawn.entity.render.RenderGammaMetroid::new);
/* 28 */     RenderingRegistry.registerEntityRenderingHandler(Spyro.class, danger.orespawn.entity.render.RenderSpyro::new);
/* 29 */     RenderingRegistry.registerEntityRenderingHandler(Dragonfly.class, danger.orespawn.entity.render.RenderDragonfly::new);
/* 30 */     RenderingRegistry.registerEntityRenderingHandler(Firefly.class, danger.orespawn.entity.render.RenderFirefly::new);
/* 31 */     RenderingRegistry.registerEntityRenderingHandler(Mosquito.class, danger.orespawn.entity.render.RenderMosquito::new);
/* 32 */     RenderingRegistry.registerEntityRenderingHandler(Nastysaurus.class, danger.orespawn.entity.render.RenderNastysaurus::new);
/* 33 */     RenderingRegistry.registerEntityRenderingHandler(Alien.class, danger.orespawn.entity.render.RenderAlien::new);
/* 34 */     RenderingRegistry.registerEntityRenderingHandler(VelocityRaptor.class, danger.orespawn.entity.render.RenderVelocityRaptor::new);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespaw\\util\handlers\RenderHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */