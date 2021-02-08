/*    */ package danger.orespawn.init;
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.entity.Alien;
/*    */ import danger.orespawn.entity.Alosaurus;
/*    */ import danger.orespawn.entity.Baryonyx;
/*    */ import danger.orespawn.entity.Bird;
/*    */ import danger.orespawn.entity.Camarasaurus;
/*    */ import danger.orespawn.entity.CaveFisher;
/*    */ import danger.orespawn.entity.Cryolophosaurus;
/*    */ import danger.orespawn.entity.Dragonfly;
/*    */ import danger.orespawn.entity.EntityCage;
/*    */ import danger.orespawn.entity.Firefly;
/*    */ import danger.orespawn.entity.GammaMetroid;
/*    */ import danger.orespawn.entity.Mosquito;
/*    */ import danger.orespawn.entity.Nastysaurus;
/*    */ import danger.orespawn.entity.Pointysaurus;
/*    */ import danger.orespawn.entity.RedAnt;
/*    */ import danger.orespawn.entity.Spyro;
/*    */ import danger.orespawn.entity.TRex;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.common.registry.EntityRegistry;
/*    */ 
/*    */ public class ModEntities {
/*    */   public static void registerEntities() {
/* 26 */     myRegisterEntity("alosaurus", (Class)Alosaurus.class, 120);
/* 27 */     myRegisterEntity("trex", (Class)TRex.class, 121);
/* 28 */     myRegisterEntity("baryonyx", (Class)Baryonyx.class, 122);
/* 29 */     myRegisterEntity("camarasaurus", (Class)Camarasaurus.class, 123);
/* 30 */     myRegisterEntity("pointysaurus", (Class)Pointysaurus.class, 124);
/* 31 */     myRegisterEntity("cryolophosaurus", (Class)Cryolophosaurus.class, 126);
/* 32 */     myRegisterEntity("cavefisher", (Class)CaveFisher.class, 128);
/* 33 */     myRegisterEntity("red_ant", (Class)RedAnt.class, 125);
/* 34 */     myRegisterEntity("bird", (Class)Bird.class, 130);
/* 35 */     myRegisterEntity("butterfly", (Class)Butterfly.class, 129);
/* 36 */     myRegisterEntity("gammametroid", (Class)GammaMetroid.class, 131);
/* 37 */     myRegisterEntity("spyro", (Class)Spyro.class, 132);
/* 38 */     myRegisterEntity("dragonfly", (Class)Dragonfly.class, 133);
/* 39 */     myRegisterEntity("firefly", (Class)Firefly.class, 134);
/* 40 */     myRegisterEntity("mosquito", (Class)Mosquito.class, 135);
/* 41 */     myRegisterEntity("nastysaurus", (Class)Nastysaurus.class, 136);
/* 42 */     myRegisterEntity("alien", (Class)Alien.class, 137);
/* 43 */     myRegisterEntity("velocityraptor", (Class)VelocityRaptor.class, 138);
/*    */     
/* 45 */     myRegisterEntity("thrown_critter_cage", (Class)EntityCage.class, 150);
/*    */   }
/*    */   
/*    */   public static void myRegisterEntity(String name, Class<? extends Entity> entity, int entity2, int range) {
/* 49 */     EntityRegistry.registerModEntity(new ResourceLocation("orespawn:" + name), entity, name, entity2, OreSpawnMain.instance, range, 1, true);
/*    */   }
/*    */   
/*    */   private static void myRegisterEntity(String name, Class<? extends Entity> cls, int id) {
/* 53 */     EntityRegistry.registerModEntity(new ResourceLocation("orespawn:" + name), cls, name, id, OreSpawnMain.instance, 50, 1, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\init\ModEntities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */