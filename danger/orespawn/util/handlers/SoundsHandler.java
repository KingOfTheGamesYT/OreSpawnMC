/*    */ package danger.orespawn.util.handlers;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.SoundEvent;
/*    */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*    */ 
/*    */ public class SoundsHandler {
/*    */   public static SoundEvent ENTITY_ALOSAURUS_LIVING;
/*    */   public static SoundEvent ENTITY_ALOSAURUS_HURT;
/*    */   public static SoundEvent ENTITY_ALOSAURUS_DEATH;
/*    */   public static SoundEvent ENTITY_TREX_AMBIENT;
/*    */   public static SoundEvent ENTITY_TREX_DEATH;
/*    */   public static SoundEvent ENTITY_DUCK_HURT;
/*    */   public static SoundEvent ENTITY_CRYO_HURT;
/*    */   public static SoundEvent ENTITY_CRYO_DEATH;
/*    */   public static SoundEvent ENTITY_CRYO_LIVING;
/*    */   public static SoundEvent ENTITY_BIRD_BIRD1;
/*    */   public static SoundEvent ENTITY_BIRD_BIRD2;
/*    */   public static SoundEvent ENTITY_BIRD_BIRD3;
/*    */   public static SoundEvent ENTITY_BIRD_BIRD4;
/*    */   public static SoundEvent ENTITY_BIRD_BIRD5;
/*    */   public static SoundEvent ENTITY_BIRD_BIRD6;
/*    */   public static SoundEvent ENTITY_BIRD_BIRD7;
/*    */   public static SoundEvent ENTITY_BIRD_BIRD8;
/*    */   public static SoundEvent ENTITY_BIRD_BIRD9;
/*    */   public static SoundEvent ENTITY_BIRD_BIRD10;
/*    */   
/*    */   public static void registerSounds() {
/* 28 */     ENTITY_ALOSAURUS_LIVING = registerSound("entity.alosaurus.living");
/* 29 */     ENTITY_ALOSAURUS_HURT = registerSound("entity.alosaurus.hurt");
/* 30 */     ENTITY_ALOSAURUS_DEATH = registerSound("entity.alosaurus.death");
/*    */     
/* 32 */     ENTITY_TREX_AMBIENT = registerSound("entity.trex.ambient");
/* 33 */     ENTITY_TREX_DEATH = registerSound("entity.trex.death");
/*    */     
/* 35 */     ENTITY_DUCK_HURT = registerSound("entity.duck.hurt");
/*    */     
/* 37 */     ENTITY_CRYO_HURT = registerSound("entity.cryo.hurt");
/* 38 */     ENTITY_CRYO_DEATH = registerSound("entity.cryo.death");
/* 39 */     ENTITY_CRYO_LIVING = registerSound("entity.cryo.living");
/*    */     
/* 41 */     ENTITY_BIRD_BIRD1 = registerSound("entity.birds.birds1");
/* 42 */     ENTITY_BIRD_BIRD2 = registerSound("entity.birds.birds2");
/* 43 */     ENTITY_BIRD_BIRD3 = registerSound("entity.birds.birds3");
/* 44 */     ENTITY_BIRD_BIRD4 = registerSound("entity.birds.birds4");
/* 45 */     ENTITY_BIRD_BIRD5 = registerSound("entity.birds.birds5");
/* 46 */     ENTITY_BIRD_BIRD6 = registerSound("entity.birds.birds6");
/* 47 */     ENTITY_BIRD_BIRD7 = registerSound("entity.birds.birds7");
/* 48 */     ENTITY_BIRD_BIRD8 = registerSound("entity.birds.birds8");
/* 49 */     ENTITY_BIRD_BIRD9 = registerSound("entity.birds.birds9");
/* 50 */     ENTITY_BIRD_BIRD10 = registerSound("entity.birds.birds10");
/* 51 */     ENTITY_BIRD_BIRD11 = registerSound("entity.birds.birds11");
/* 52 */     ENTITY_BIRD_BIRD12 = registerSound("entity.birds.birds12");
/* 53 */     ENTITY_BIRD_BIRD13 = registerSound("entity.birds.birds13");
/* 54 */     ENTITY_BIRD_BIRD14 = registerSound("entity.birds.birds14");
/* 55 */     ENTITY_BIRD_BIRD15 = registerSound("entity.birds.birds15");
/* 56 */     ENTITY_BIRD_BIRD16 = registerSound("entity.birds.birds16");
/* 57 */     ENTITY_BIRD_BIRD17 = registerSound("entity.birds.birds17");
/* 58 */     ENTITY_BIRD_BIRD18 = registerSound("entity.birds.birds18");
/* 59 */     ENTITY_BIRD_BIRD19 = registerSound("entity.birds.birds19");
/* 60 */     ENTITY_BIRD_BIRD20 = registerSound("entity.birds.birds20");
/* 61 */     ENTITY_BIRD_BIRD21 = registerSound("entity.birds.birds21");
/* 62 */     ENTITY_BIRD_BIRD22 = registerSound("entity.birds.birds22");
/* 63 */     ENTITY_BIRD_BIRD23 = registerSound("entity.birds.birds23");
/*    */     
/* 65 */     ENTITY_GAMMAMETROID_LIVING = registerSound("entity.gammametroid.living");
/*    */     
/* 67 */     ENTITY_ALIEN_LIVING = registerSound("entity.alien.living");
/* 68 */     ENTITY_ALIEN_HURT = registerSound("entity.alien.hurt");
/*    */   }
/*    */   public static SoundEvent ENTITY_BIRD_BIRD11; public static SoundEvent ENTITY_BIRD_BIRD12; public static SoundEvent ENTITY_BIRD_BIRD13; public static SoundEvent ENTITY_BIRD_BIRD14; public static SoundEvent ENTITY_BIRD_BIRD15; public static SoundEvent ENTITY_BIRD_BIRD16; public static SoundEvent ENTITY_BIRD_BIRD17; public static SoundEvent ENTITY_BIRD_BIRD18; public static SoundEvent ENTITY_BIRD_BIRD19; public static SoundEvent ENTITY_BIRD_BIRD20; public static SoundEvent ENTITY_BIRD_BIRD21; public static SoundEvent ENTITY_BIRD_BIRD22; public static SoundEvent ENTITY_BIRD_BIRD23; public static SoundEvent ENTITY_GAMMAMETROID_LIVING; public static SoundEvent ENTITY_DRAGONFLY_LIVING; public static SoundEvent ENTITY_DRAGONFLY_HURT; public static SoundEvent ENTITY_MOSQUITO_LIVING; public static SoundEvent ENTITY_ALIEN_LIVING; public static SoundEvent ENTITY_ALIEN_HURT;
/*    */   private static SoundEvent registerSound(String name) {
/* 72 */     ResourceLocation location = new ResourceLocation("orespawn", name);
/* 73 */     SoundEvent event = new SoundEvent(location);
/* 74 */     event.setRegistryName(name);
/* 75 */     ForgeRegistries.SOUND_EVENTS.register((IForgeRegistryEntry)event);
/* 76 */     return event;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespaw\\util\handlers\SoundsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */