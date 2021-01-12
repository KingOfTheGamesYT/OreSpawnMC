/*    */ package danger.orespawn.util.handlers;
/*    */ 
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.SoundEvent;
/*    */ import net.minecraftforge.fml.common.registry.ForgeRegistries;
/*    */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*    */ 
/*    */ public class SoundsHandler
/*    */ {
/*    */   public static SoundEvent ENTITY_ALOSAURUS_LIVING;
/*    */   public static SoundEvent ENTITY_ALOSAURUS_HURT;
/*    */   public static SoundEvent ENTITY_ALOSAURUS_DEATH;
/*    */   public static SoundEvent ENTITY_TREX_AMBIENT;
/*    */   
/*    */   public static void registerSounds() {
/* 16 */     ENTITY_ALOSAURUS_LIVING = registerSound("entity.alo.living");
/* 17 */     ENTITY_ALOSAURUS_HURT = registerSound("entity.alosaurus.hurt");
/* 18 */     ENTITY_ALOSAURUS_DEATH = registerSound("entity.alosaurus.death");
/*    */     
/* 20 */     ENTITY_TREX_AMBIENT = registerSound("entity.trex.ambient");
/* 21 */     ENTITY_TREX_DEATH = registerSound("entity.trex.death");
/*    */     
/* 23 */     ENTITY_DUCK_HURT = registerSound("entity.duck.hurt");
/*    */     
/* 25 */     ENTITY_CRYO_HURT = registerSound("entity.cryo.hurt");
/* 26 */     ENTITY_CRYO_DEATH = registerSound("entity.cryo.death");
/* 27 */     ENTITY_CRYO_LIVING = registerSound("entity.cryo.living");
/*    */   }
/*    */   public static SoundEvent ENTITY_TREX_DEATH; public static SoundEvent ENTITY_DUCK_HURT; public static SoundEvent ENTITY_CRYO_HURT; public static SoundEvent ENTITY_CRYO_DEATH; public static SoundEvent ENTITY_CRYO_LIVING;
/*    */   
/*    */   private static SoundEvent registerSound(String name) {
/* 32 */     ResourceLocation location = new ResourceLocation("orespawn", name);
/* 33 */     SoundEvent event = new SoundEvent(location);
/* 34 */     event.setRegistryName(name);
/* 35 */     ForgeRegistries.SOUND_EVENTS.register((IForgeRegistryEntry)event);
/* 36 */     return event;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespaw\\util\handlers\SoundsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */