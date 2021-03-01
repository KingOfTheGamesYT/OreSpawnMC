/*    */ package danger.orespawn.util.handlers;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.SoundEvent;
/*    */ import net.minecraftforge.fml.common.registry.ForgeRegistries;
/*    */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*    */ 
/*    */ public class SoundsHandler {
/*    */   public static SoundEvent LITTLE_SPLAT;
/*    */   public static SoundEvent BIG_SPLAT;
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
/*    */   public static SoundEvent ENTITY_BIRD_BIRD11;
/*    */   public static SoundEvent ENTITY_BIRD_BIRD12;
/*    */   public static SoundEvent ENTITY_BIRD_BIRD13;
/*    */   
/*    */   public static void registerSounds() {
/* 34 */     LITTLE_SPLAT = registerSound("little_splat");
/* 35 */     BIG_SPLAT = registerSound("big_splat");
/* 36 */     ENTITY_ALOSAURUS_LIVING = registerSound("entity.alosaurus.living");
/* 37 */     ENTITY_ALOSAURUS_HURT = registerSound("entity.alosaurus.hurt");
/* 38 */     ENTITY_ALOSAURUS_DEATH = registerSound("entity.alosaurus.death");
/*    */     
/* 40 */     ENTITY_TREX_AMBIENT = registerSound("entity.trex.ambient");
/* 41 */     ENTITY_TREX_DEATH = registerSound("entity.trex.death");
/*    */     
/* 43 */     ENTITY_DUCK_HURT = registerSound("entity.duck.hurt");
/*    */     
/* 45 */     ENTITY_CRYO_HURT = registerSound("entity.cryo.hurt");
/* 46 */     ENTITY_CRYO_DEATH = registerSound("entity.cryo.death");
/* 47 */     ENTITY_CRYO_LIVING = registerSound("entity.cryo.living");
/*    */     
/* 49 */     ENTITY_BIRD_BIRD1 = registerSound("entity.birds.birds1");
/* 50 */     ENTITY_BIRD_BIRD2 = registerSound("entity.birds.birds2");
/* 51 */     ENTITY_BIRD_BIRD3 = registerSound("entity.birds.birds3");
/* 52 */     ENTITY_BIRD_BIRD4 = registerSound("entity.birds.birds4");
/* 53 */     ENTITY_BIRD_BIRD5 = registerSound("entity.birds.birds5");
/* 54 */     ENTITY_BIRD_BIRD6 = registerSound("entity.birds.birds6");
/* 55 */     ENTITY_BIRD_BIRD7 = registerSound("entity.birds.birds7");
/* 56 */     ENTITY_BIRD_BIRD8 = registerSound("entity.birds.birds8");
/* 57 */     ENTITY_BIRD_BIRD9 = registerSound("entity.birds.birds9");
/* 58 */     ENTITY_BIRD_BIRD10 = registerSound("entity.birds.birds10");
/* 59 */     ENTITY_BIRD_BIRD11 = registerSound("entity.birds.birds11");
/* 60 */     ENTITY_BIRD_BIRD12 = registerSound("entity.birds.birds12");
/* 61 */     ENTITY_BIRD_BIRD13 = registerSound("entity.birds.birds13");
/* 62 */     ENTITY_BIRD_BIRD14 = registerSound("entity.birds.birds14");
/* 63 */     ENTITY_BIRD_BIRD15 = registerSound("entity.birds.birds15");
/* 64 */     ENTITY_BIRD_BIRD16 = registerSound("entity.birds.birds16");
/* 65 */     ENTITY_BIRD_BIRD17 = registerSound("entity.birds.birds17");
/* 66 */     ENTITY_BIRD_BIRD18 = registerSound("entity.birds.birds18");
/* 67 */     ENTITY_BIRD_BIRD19 = registerSound("entity.birds.birds19");
/* 68 */     ENTITY_BIRD_BIRD20 = registerSound("entity.birds.birds20");
/* 69 */     ENTITY_BIRD_BIRD21 = registerSound("entity.birds.birds21");
/* 70 */     ENTITY_BIRD_BIRD22 = registerSound("entity.birds.birds22");
/* 71 */     ENTITY_BIRD_BIRD23 = registerSound("entity.birds.birds23");
/*    */     
/* 73 */     ENTITY_GAMMAMETROID_LIVING = registerSound("entity.gammametroid.living");
/*    */     
/* 75 */     ENTITY_ALIEN_LIVING = registerSound("entity.alien.living");
/* 76 */     ENTITY_ALIEN_HURT = registerSound("entity.alien.hurt");
/*    */   }
/*    */   public static SoundEvent ENTITY_BIRD_BIRD14; public static SoundEvent ENTITY_BIRD_BIRD15; public static SoundEvent ENTITY_BIRD_BIRD16; public static SoundEvent ENTITY_BIRD_BIRD17; public static SoundEvent ENTITY_BIRD_BIRD18; public static SoundEvent ENTITY_BIRD_BIRD19; public static SoundEvent ENTITY_BIRD_BIRD20; public static SoundEvent ENTITY_BIRD_BIRD21; public static SoundEvent ENTITY_BIRD_BIRD22; public static SoundEvent ENTITY_BIRD_BIRD23; public static SoundEvent ENTITY_GAMMAMETROID_LIVING; public static SoundEvent ENTITY_DRAGONFLY_LIVING; public static SoundEvent ENTITY_DRAGONFLY_HURT; public static SoundEvent ENTITY_MOSQUITO_LIVING; public static SoundEvent ENTITY_ALIEN_LIVING; public static SoundEvent ENTITY_ALIEN_HURT; public static SoundEvent ENTITY_CATERKILLER_LIVING1; public static SoundEvent ENTITY_CATERKILLER_LIVING2; public static SoundEvent ENTITY_CATERKILLER_LIVING3; public static SoundEvent ENTITY_CATERKILLER_LIVING4; public static SoundEvent ENTITY_SCORPION_HIT; public static SoundEvent CHAINSAW; public static SoundEvent ENTITY_MOTHRA_WINGS; public static SoundEvent ENTITY_KYUUBI_LIVING;
/*    */   private static SoundEvent registerSound(String name) {
/* 80 */     ResourceLocation location = new ResourceLocation("orespawn", name);
/* 81 */     SoundEvent event = new SoundEvent(location);
/* 82 */     event.setRegistryName(name);
/* 83 */     ForgeRegistries.SOUND_EVENTS.register((IForgeRegistryEntry)event);
/* 84 */     return event;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespaw\\util\handlers\SoundsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */