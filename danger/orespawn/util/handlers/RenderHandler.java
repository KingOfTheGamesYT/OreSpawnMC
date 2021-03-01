/*    */ package danger.orespawn.util.handlers;
/*    */ import danger.orespawn.entity.Alien;
/*    */ import danger.orespawn.entity.Firefly;
/*    */ import danger.orespawn.entity.Mosquito;
/*    */ import danger.orespawn.entity.Nastysaurus;
/*    */ import danger.orespawn.entity.WormDoom;
/*    */ import net.minecraftforge.fml.client.registry.IRenderFactory;
/*    */ import net.minecraftforge.fml.client.registry.RenderingRegistry;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderHandler {
/*    */   public static void registerEntityRenders() {
/* 13 */     RenderingRegistry.registerEntityRenderingHandler(Alosaurus.class, danger.orespawn.entity.render.RenderAlosaurus::new);
/* 14 */     RenderingRegistry.registerEntityRenderingHandler(TRex.class, danger.orespawn.entity.render.RenderTRex::new);
/* 15 */     RenderingRegistry.registerEntityRenderingHandler(Baryonyx.class, danger.orespawn.entity.render.RenderBaryonyx::new);
/* 16 */     RenderingRegistry.registerEntityRenderingHandler(Camarasaurus.class, danger.orespawn.entity.render.RenderCamarasaurus::new);
/* 17 */     RenderingRegistry.registerEntityRenderingHandler(RedAnt.class, danger.orespawn.entity.render.RenderRedAnt::new);
/* 18 */     RenderingRegistry.registerEntityRenderingHandler(Cryolophosaurus.class, danger.orespawn.entity.render.RenderCryolophosaurus::new);
/* 19 */     RenderingRegistry.registerEntityRenderingHandler(Pointysaurus.class, danger.orespawn.entity.render.RenderPointysaurus::new);
/* 20 */     RenderingRegistry.registerEntityRenderingHandler(CaveFisher.class, danger.orespawn.entity.render.RenderCaveFisher::new);
/* 21 */     RenderingRegistry.registerEntityRenderingHandler(Butterfly.class, danger.orespawn.entity.render.RenderButterfly::new);
/* 22 */     RenderingRegistry.registerEntityRenderingHandler(Bird.class, danger.orespawn.entity.render.RenderBird::new);
/* 23 */     RenderingRegistry.registerEntityRenderingHandler(GammaMetroid.class, danger.orespawn.entity.render.RenderGammaMetroid::new);
/* 24 */     RenderingRegistry.registerEntityRenderingHandler(Spyro.class, danger.orespawn.entity.render.RenderSpyro::new);
/* 25 */     RenderingRegistry.registerEntityRenderingHandler(Dragonfly.class, danger.orespawn.entity.render.RenderDragonfly::new);
/* 26 */     RenderingRegistry.registerEntityRenderingHandler(Firefly.class, danger.orespawn.entity.render.RenderFirefly::new);
/* 27 */     RenderingRegistry.registerEntityRenderingHandler(Mosquito.class, danger.orespawn.entity.render.RenderMosquito::new);
/* 28 */     RenderingRegistry.registerEntityRenderingHandler(Nastysaurus.class, danger.orespawn.entity.render.RenderNastysaurus::new);
/* 29 */     RenderingRegistry.registerEntityRenderingHandler(Alien.class, danger.orespawn.entity.render.RenderAlien::new);
/* 30 */     RenderingRegistry.registerEntityRenderingHandler(VelocityRaptor.class, danger.orespawn.entity.render.RenderVelocityRaptor::new);
/* 31 */     RenderingRegistry.registerEntityRenderingHandler(WormSmall.class, danger.orespawn.entity.render.RenderWormSmall::new);
/* 32 */     RenderingRegistry.registerEntityRenderingHandler(WormMedium.class, danger.orespawn.entity.render.RenderWormMedium::new);
/* 33 */     RenderingRegistry.registerEntityRenderingHandler(WormLarge.class, danger.orespawn.entity.render.RenderWormLarge::new);
/* 34 */     RenderingRegistry.registerEntityRenderingHandler(WormDoom.class, danger.orespawn.entity.render.RenderWormDoom::new);
/* 35 */     RenderingRegistry.registerEntityRenderingHandler(Moth.class, danger.orespawn.entity.render.RenderMoth::new);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespaw\\util\handlers\RenderHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */