/*    */ package danger.orespawn.init;
/*    */ 
/*    */ import danger.orespawn.OreSpawnMain;
/*    */ import danger.orespawn.entity.Alosaurus;
/*    */ import danger.orespawn.entity.Baryonyx;
/*    */ import danger.orespawn.entity.Camarasaurus;
/*    */ import danger.orespawn.entity.EntityCage;
/*    */ import danger.orespawn.entity.TRex;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.common.registry.EntityRegistry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityInit
/*    */ {
/*    */   public static void registerEntities() {
/* 20 */     registerEntity("alosaurus", (Class)Alosaurus.class, 120, 50, 14053384, 10029321);
/* 21 */     registerEntity("trex", (Class)TRex.class, 121, 50, 14022384, 10034321);
/* 22 */     registerEntity("baryonyx", (Class)Baryonyx.class, 122, 50, 14084684, 10367421);
/* 23 */     registerEntity("camarasaurus", (Class)Camarasaurus.class, 123, 50, 14084642, 12367321);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 30 */     EntityRegistry.registerModEntity(new ResourceLocation("orespawn:thrown_critter_cage"), EntityCage.class, "thrown_critter_cage", 150, OreSpawnMain.instance, 50, 1, true);
/*    */   }
/*    */   
/*    */   public static void registerEntity(String name, Class<? extends Entity> entity, int entity2, int range, int color1, int color2) {
/* 34 */     EntityRegistry.registerModEntity(new ResourceLocation("orespawn:" + name), entity, name, entity2, OreSpawnMain.instance, range, 1, true, color1, color2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespawn\init\EntityInit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */