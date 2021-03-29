/*    */ package danger.orespawn.init;
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.entity.Alien;
/*    */ import danger.orespawn.entity.Firefly;
/*    */ import danger.orespawn.entity.Mosquito;
/*    */ import danger.orespawn.entity.Nastysaurus;
/*    */ import danger.orespawn.entity.WormDoom;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.common.registry.EntityRegistry;
/*    */ 
/*    */ public class ModEntities {
/*    */   public static void registerEntities() {
/* 14 */     myRegisterEntity("alosaurus", (Class)Alosaurus.class, 120);
/* 15 */     myRegisterEntity("trex", (Class)TRex.class, 121);
/* 16 */     myRegisterEntity("baryonyx", (Class)Baryonyx.class, 122);
/* 17 */     myRegisterEntity("camarasaurus", (Class)Camarasaurus.class, 123);
/* 18 */     myRegisterEntity("pointysaurus", (Class)Pointysaurus.class, 124);
/* 19 */     myRegisterEntity("cryolophosaurus", (Class)Cryolophosaurus.class, 126);
/* 20 */     myRegisterEntity("cavefisher", (Class)CaveFisher.class, 128);
/* 21 */     myRegisterEntity("red_ant", (Class)RedAnt.class, 125);
/* 22 */     myRegisterEntity("bird", (Class)Bird.class, 130);
/* 23 */     myRegisterEntity("butterfly", (Class)Butterfly.class, 129);
/* 24 */     myRegisterEntity("gammametroid", (Class)GammaMetroid.class, 131);
/* 25 */     myRegisterEntity("spyro", (Class)Spyro.class, 132);
/* 26 */     myRegisterEntity("dragonfly", (Class)Dragonfly.class, 133);
/* 27 */     myRegisterEntity("firefly", (Class)Firefly.class, 134);
/* 28 */     myRegisterEntity("mosquito", (Class)Mosquito.class, 135);
/* 29 */     myRegisterEntity("nastysaurus", (Class)Nastysaurus.class, 136);
/* 30 */     myRegisterEntity("alien", (Class)Alien.class, 137);
/* 31 */     myRegisterEntity("velocityraptor", (Class)VelocityRaptor.class, 138);
/*    */     
/* 33 */     myRegisterEntity("thrown_critter_cage", (Class)EntityCage.class, 150);
/*    */     
/* 35 */     myRegisterEntity("small_worm", (Class)WormSmall.class, 139);
/* 36 */     myRegisterEntity("medium_worm", (Class)WormMedium.class, 140);
/* 37 */     myRegisterEntity("large_worm", (Class)WormLarge.class, 141);
/* 38 */     EntityRegistry.registerModEntity(new ResourceLocation("orespawn:doom_worm"), WormDoom.class, "doom_worm", 142, OreSpawnMain.instance, 325, 1, true);
/*    */     
/* 40 */     myRegisterEntity("moth", (Class)Moth.class, 143);
/* 41 */     myRegisterEntity("kyuubi", (Class)Kyuubi.class, 144);
/* 42 */     myRegisterEntity("mantis", (Class)Mantis.class, 145);
/* 43 */     myRegisterEntity("mothra", (Class)Mothra.class, 146);
/* 44 */     myRegisterEntity("brutalfly", (Class)Brutalfly.class, 147);
/* 45 */     myRegisterEntity("beaver", (Class)Beaver.class, 148);
/*    */     
/* 47 */     myRegisterEntity("cassowary", (Class)Cassowary.class, 151);
/* 48 */     myRegisterEntity("termite", (Class)Termite.class, 149);
/* 49 */     myRegisterEntity("redcow", (Class)RedCow.class, 152);
/* 50 */     myRegisterEntity("stinkbug", (Class)StinkBug.class, 153);
/*    */   }
/*    */   
/*    */   public static void myRegisterEntity(String name, Class<? extends Entity> entity, int entity2, int range) {
/* 54 */     EntityRegistry.registerModEntity(new ResourceLocation("orespawn:" + name), entity, name, entity2, OreSpawnMain.instance, range, 1, true);
/*    */   }
/*    */   
/*    */   private static void myRegisterEntity(String name, Class<? extends Entity> cls, int id) {
/* 58 */     EntityRegistry.registerModEntity(new ResourceLocation("orespawn:" + name), cls, name, id, OreSpawnMain.instance, 50, 1, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\init\ModEntities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */