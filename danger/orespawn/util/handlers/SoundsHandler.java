/*    */ package danger.orespawn.util.handlers;public class SoundsHandler { public static SoundEvent ENTITY_ALOSAURUS_LIVING; public static SoundEvent ENTITY_ALOSAURUS_HURT;
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
/*    */   
/*    */   public static void registerSounds() {
/* 18 */     ENTITY_ALOSAURUS_LIVING = registerSound("entity.alo.living");
/* 19 */     ENTITY_ALOSAURUS_HURT = registerSound("entity.alosaurus.hurt");
/* 20 */     ENTITY_ALOSAURUS_DEATH = registerSound("entity.alosaurus.death");
/*    */     
/* 22 */     ENTITY_TREX_AMBIENT = registerSound("entity.trex.ambient");
/* 23 */     ENTITY_TREX_DEATH = registerSound("entity.trex.death");
/*    */     
/* 25 */     ENTITY_DUCK_HURT = registerSound("entity.duck.hurt");
/*    */     
/* 27 */     ENTITY_CRYO_HURT = registerSound("entity.cryo.hurt");
/* 28 */     ENTITY_CRYO_DEATH = registerSound("entity.cryo.death");
/* 29 */     ENTITY_CRYO_LIVING = registerSound("entity.cryo.living");
/*    */     
/* 31 */     ENTITY_BIRD_BIRD1 = registerSound("entity.birds.birds1");
/* 32 */     ENTITY_BIRD_BIRD2 = registerSound("entity.birds.birds2");
/* 33 */     ENTITY_BIRD_BIRD3 = registerSound("entity.birds.birds3");
/* 34 */     ENTITY_BIRD_BIRD4 = registerSound("entity.birds.birds4");
/* 35 */     ENTITY_BIRD_BIRD5 = registerSound("entity.birds.birds5");
/* 36 */     ENTITY_BIRD_BIRD6 = registerSound("entity.birds.birds6");
/* 37 */     ENTITY_BIRD_BIRD7 = registerSound("entity.birds.birds7");
/* 38 */     ENTITY_BIRD_BIRD8 = registerSound("entity.birds.birds8");
/* 39 */     ENTITY_BIRD_BIRD9 = registerSound("entity.birds.birds9");
/* 40 */     ENTITY_BIRD_BIRD10 = registerSound("entity.birds.birds10");
/* 41 */     ENTITY_BIRD_BIRD11 = registerSound("entity.birds.birds11");
/* 42 */     ENTITY_BIRD_BIRD12 = registerSound("entity.birds.birds12");
/* 43 */     ENTITY_BIRD_BIRD13 = registerSound("entity.birds.birds13");
/* 44 */     ENTITY_BIRD_BIRD14 = registerSound("entity.birds.birds14");
/* 45 */     ENTITY_BIRD_BIRD15 = registerSound("entity.birds.birds15");
/* 46 */     ENTITY_BIRD_BIRD16 = registerSound("entity.birds.birds16");
/* 47 */     ENTITY_BIRD_BIRD17 = registerSound("entity.birds.birds17");
/* 48 */     ENTITY_BIRD_BIRD18 = registerSound("entity.birds.birds18");
/* 49 */     ENTITY_BIRD_BIRD19 = registerSound("entity.birds.birds19");
/* 50 */     ENTITY_BIRD_BIRD20 = registerSound("entity.birds.birds20");
/* 51 */     ENTITY_BIRD_BIRD21 = registerSound("entity.birds.birds21");
/* 52 */     ENTITY_BIRD_BIRD22 = registerSound("entity.birds.birds22");
/* 53 */     ENTITY_BIRD_BIRD23 = registerSound("entity.birds.birds23");
/*    */   }
/*    */   public static SoundEvent ENTITY_BIRD_BIRD8; public static SoundEvent ENTITY_BIRD_BIRD9; public static SoundEvent ENTITY_BIRD_BIRD10; public static SoundEvent ENTITY_BIRD_BIRD11; public static SoundEvent ENTITY_BIRD_BIRD12; public static SoundEvent ENTITY_BIRD_BIRD13; public static SoundEvent ENTITY_BIRD_BIRD14; public static SoundEvent ENTITY_BIRD_BIRD15; public static SoundEvent ENTITY_BIRD_BIRD16; public static SoundEvent ENTITY_BIRD_BIRD17; public static SoundEvent ENTITY_BIRD_BIRD18; public static SoundEvent ENTITY_BIRD_BIRD19; public static SoundEvent ENTITY_BIRD_BIRD20; public static SoundEvent ENTITY_BIRD_BIRD21; public static SoundEvent ENTITY_BIRD_BIRD22; public static SoundEvent ENTITY_BIRD_BIRD23;
/*    */   
/*    */   private static SoundEvent registerSound(String name) {
/* 58 */     ResourceLocation location = new ResourceLocation("orespawn", name);
/* 59 */     SoundEvent event = new SoundEvent(location);
/* 60 */     event.setRegistryName(name);
/* 61 */     ForgeRegistries.SOUND_EVENTS.register((IForgeRegistryEntry)event);
/* 62 */     return event;
/*    */   } }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespaw\\util\handlers\SoundsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */