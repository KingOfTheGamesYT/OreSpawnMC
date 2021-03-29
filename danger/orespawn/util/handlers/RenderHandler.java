/*    */ package danger.orespawn.util.handlers;
/*    */ import danger.orespawn.entity.Alien;
/*    */ import danger.orespawn.entity.Firefly;
/*    */ import danger.orespawn.entity.Kyuubi;
/*    */ import danger.orespawn.entity.Mosquito;
/*    */ import danger.orespawn.entity.Nastysaurus;
/*    */ import danger.orespawn.entity.WormDoom;
/*    */ import net.minecraftforge.fml.client.registry.IRenderFactory;
/*    */ import net.minecraftforge.fml.client.registry.RenderingRegistry;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderHandler {
/*    */   public static void registerEntityRenders() {
/* 14 */     RenderingRegistry.registerEntityRenderingHandler(Alosaurus.class, danger.orespawn.entity.render.RenderAlosaurus::new);
/* 15 */     RenderingRegistry.registerEntityRenderingHandler(TRex.class, danger.orespawn.entity.render.RenderTRex::new);
/* 16 */     RenderingRegistry.registerEntityRenderingHandler(Baryonyx.class, danger.orespawn.entity.render.RenderBaryonyx::new);
/* 17 */     RenderingRegistry.registerEntityRenderingHandler(Camarasaurus.class, danger.orespawn.entity.render.RenderCamarasaurus::new);
/* 18 */     RenderingRegistry.registerEntityRenderingHandler(RedAnt.class, danger.orespawn.entity.render.RenderRedAnt::new);
/* 19 */     RenderingRegistry.registerEntityRenderingHandler(Cryolophosaurus.class, danger.orespawn.entity.render.RenderCryolophosaurus::new);
/* 20 */     RenderingRegistry.registerEntityRenderingHandler(Pointysaurus.class, danger.orespawn.entity.render.RenderPointysaurus::new);
/* 21 */     RenderingRegistry.registerEntityRenderingHandler(CaveFisher.class, danger.orespawn.entity.render.RenderCaveFisher::new);
/* 22 */     RenderingRegistry.registerEntityRenderingHandler(Butterfly.class, danger.orespawn.entity.render.RenderButterfly::new);
/* 23 */     RenderingRegistry.registerEntityRenderingHandler(Bird.class, danger.orespawn.entity.render.RenderBird::new);
/* 24 */     RenderingRegistry.registerEntityRenderingHandler(GammaMetroid.class, danger.orespawn.entity.render.RenderGammaMetroid::new);
/* 25 */     RenderingRegistry.registerEntityRenderingHandler(Spyro.class, danger.orespawn.entity.render.RenderSpyro::new);
/* 26 */     RenderingRegistry.registerEntityRenderingHandler(Dragonfly.class, danger.orespawn.entity.render.RenderDragonfly::new);
/* 27 */     RenderingRegistry.registerEntityRenderingHandler(Firefly.class, danger.orespawn.entity.render.RenderFirefly::new);
/* 28 */     RenderingRegistry.registerEntityRenderingHandler(Mosquito.class, danger.orespawn.entity.render.RenderMosquito::new);
/* 29 */     RenderingRegistry.registerEntityRenderingHandler(Nastysaurus.class, danger.orespawn.entity.render.RenderNastysaurus::new);
/* 30 */     RenderingRegistry.registerEntityRenderingHandler(Alien.class, danger.orespawn.entity.render.RenderAlien::new);
/* 31 */     RenderingRegistry.registerEntityRenderingHandler(VelocityRaptor.class, danger.orespawn.entity.render.RenderVelocityRaptor::new);
/* 32 */     RenderingRegistry.registerEntityRenderingHandler(WormSmall.class, danger.orespawn.entity.render.RenderWormSmall::new);
/* 33 */     RenderingRegistry.registerEntityRenderingHandler(WormMedium.class, danger.orespawn.entity.render.RenderWormMedium::new);
/* 34 */     RenderingRegistry.registerEntityRenderingHandler(WormLarge.class, danger.orespawn.entity.render.RenderWormLarge::new);
/* 35 */     RenderingRegistry.registerEntityRenderingHandler(WormDoom.class, danger.orespawn.entity.render.RenderWormDoom::new);
/* 36 */     RenderingRegistry.registerEntityRenderingHandler(Moth.class, danger.orespawn.entity.render.RenderMoth::new);
/* 37 */     RenderingRegistry.registerEntityRenderingHandler(Kyuubi.class, danger.orespawn.entity.render.RenderKyuubi::new);
/* 38 */     RenderingRegistry.registerEntityRenderingHandler(Mantis.class, danger.orespawn.entity.render.RenderMantis::new);
/* 39 */     RenderingRegistry.registerEntityRenderingHandler(Mothra.class, danger.orespawn.entity.render.RenderMothra::new);
/* 40 */     RenderingRegistry.registerEntityRenderingHandler(Brutalfly.class, danger.orespawn.entity.render.RenderBrutalfly::new);
/* 41 */     RenderingRegistry.registerEntityRenderingHandler(Beaver.class, danger.orespawn.entity.render.RenderBeaver::new);
/* 42 */     RenderingRegistry.registerEntityRenderingHandler(Termite.class, danger.orespawn.entity.render.RenderTermite::new);
/* 43 */     RenderingRegistry.registerEntityRenderingHandler(Cassowary.class, danger.orespawn.entity.render.RenderCassowary::new);
/* 44 */     RenderingRegistry.registerEntityRenderingHandler(RedCow.class, danger.orespawn.entity.render.RenderEnchantedCow::new);
/* 45 */     RenderingRegistry.registerEntityRenderingHandler(StinkBug.class, danger.orespawn.entity.render.RenderStinkBug::new);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespaw\\util\handlers\RenderHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */