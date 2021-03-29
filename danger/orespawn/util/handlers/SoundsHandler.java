/*     */ package danger.orespawn.util.handlers;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraftforge.fml.common.registry.ForgeRegistries;
/*     */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*     */ 
/*     */ public class SoundsHandler {
/*     */   public static SoundEvent LITTLE_SPLAT;
/*     */   public static SoundEvent BIG_SPLAT;
/*     */   public static SoundEvent ENTITY_ALOSAURUS_LIVING;
/*     */   public static SoundEvent ENTITY_ALOSAURUS_HURT;
/*     */   public static SoundEvent ENTITY_ALOSAURUS_DEATH;
/*     */   public static SoundEvent ENTITY_TREX_AMBIENT;
/*     */   public static SoundEvent ENTITY_TREX_DEATH;
/*     */   public static SoundEvent ENTITY_DUCK_HURT;
/*     */   public static SoundEvent ENTITY_CRYO_HURT;
/*     */   public static SoundEvent ENTITY_CRYO_DEATH;
/*     */   public static SoundEvent ENTITY_CRYO_LIVING;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD1;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD2;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD3;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD4;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD5;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD6;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD7;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD8;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD9;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD10;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD11;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD12;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD13;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD14;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD15;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD16;
/*     */   public static SoundEvent ENTITY_BIRD_BIRD17;
/*     */   
/*     */   public static void registerSounds() {
/*  38 */     LITTLE_SPLAT = registerSound("little_splat");
/*  39 */     BIG_SPLAT = registerSound("big_splat");
/*  40 */     ENTITY_ALOSAURUS_LIVING = registerSound("entity.alosaurus.living");
/*  41 */     ENTITY_ALOSAURUS_HURT = registerSound("entity.alosaurus.hurt");
/*  42 */     ENTITY_ALOSAURUS_DEATH = registerSound("entity.alosaurus.death");
/*     */     
/*  44 */     ENTITY_TREX_AMBIENT = registerSound("entity.trex.ambient");
/*  45 */     ENTITY_TREX_DEATH = registerSound("entity.trex.death");
/*     */     
/*  47 */     ENTITY_DUCK_HURT = registerSound("entity.duck.hurt");
/*     */     
/*  49 */     ENTITY_CRYO_HURT = registerSound("entity.cryo.hurt");
/*  50 */     ENTITY_CRYO_DEATH = registerSound("entity.cryo.death");
/*  51 */     ENTITY_CRYO_LIVING = registerSound("entity.cryo.living");
/*     */     
/*  53 */     ENTITY_BIRD_BIRD1 = registerSound("entity.birds.birds1");
/*  54 */     ENTITY_BIRD_BIRD2 = registerSound("entity.birds.birds2");
/*  55 */     ENTITY_BIRD_BIRD3 = registerSound("entity.birds.birds3");
/*  56 */     ENTITY_BIRD_BIRD4 = registerSound("entity.birds.birds4");
/*  57 */     ENTITY_BIRD_BIRD5 = registerSound("entity.birds.birds5");
/*  58 */     ENTITY_BIRD_BIRD6 = registerSound("entity.birds.birds6");
/*  59 */     ENTITY_BIRD_BIRD7 = registerSound("entity.birds.birds7");
/*  60 */     ENTITY_BIRD_BIRD8 = registerSound("entity.birds.birds8");
/*  61 */     ENTITY_BIRD_BIRD9 = registerSound("entity.birds.birds9");
/*  62 */     ENTITY_BIRD_BIRD10 = registerSound("entity.birds.birds10");
/*  63 */     ENTITY_BIRD_BIRD11 = registerSound("entity.birds.birds11");
/*  64 */     ENTITY_BIRD_BIRD12 = registerSound("entity.birds.birds12");
/*  65 */     ENTITY_BIRD_BIRD13 = registerSound("entity.birds.birds13");
/*  66 */     ENTITY_BIRD_BIRD14 = registerSound("entity.birds.birds14");
/*  67 */     ENTITY_BIRD_BIRD15 = registerSound("entity.birds.birds15");
/*  68 */     ENTITY_BIRD_BIRD16 = registerSound("entity.birds.birds16");
/*  69 */     ENTITY_BIRD_BIRD17 = registerSound("entity.birds.birds17");
/*  70 */     ENTITY_BIRD_BIRD18 = registerSound("entity.birds.birds18");
/*  71 */     ENTITY_BIRD_BIRD19 = registerSound("entity.birds.birds19");
/*  72 */     ENTITY_BIRD_BIRD20 = registerSound("entity.birds.birds20");
/*  73 */     ENTITY_BIRD_BIRD21 = registerSound("entity.birds.birds21");
/*  74 */     ENTITY_BIRD_BIRD22 = registerSound("entity.birds.birds22");
/*  75 */     ENTITY_BIRD_BIRD23 = registerSound("entity.birds.birds23");
/*     */     
/*  77 */     ENTITY_GAMMAMETROID_LIVING = registerSound("entity.gammametroid.living");
/*     */     
/*  79 */     ENTITY_ALIEN_LIVING = registerSound("entity.alien.living");
/*  80 */     ENTITY_ALIEN_HURT = registerSound("entity.alien.hurt");
/*     */     
/*  82 */     ENTITY_MOTHRA_WINGS = registerSound("entity.mothra.wings");
/*     */     
/*  84 */     ENTITY_STINKBUG_FART1 = registerSound("entity.stinkbug.fart1");
/*  85 */     ENTITY_STINKBUG_FART2 = registerSound("entity.stinkbug.fart2");
/*  86 */     ENTITY_STINKBUG_FART3 = registerSound("entity.stinkbug.fart3");
/*  87 */     ENTITY_STINKBUG_FART4 = registerSound("entity.stinkbug.fart4");
/*  88 */     ENTITY_STINKBUG_FART5 = registerSound("entity.stinkbug.fart5");
/*  89 */     ENTITY_STINKBUG_FART6 = registerSound("entity.stinkbug.fart6");
/*  90 */     ENTITY_STINKBUG_FART7 = registerSound("entity.stinkbug.fart7");
/*  91 */     ENTITY_STINKBUG_FART8 = registerSound("entity.stinkbug.fart8");
/*  92 */     ENTITY_STINKBUG_FART9 = registerSound("entity.stinkbug.fart9");
/*     */   }
/*     */   public static SoundEvent ENTITY_BIRD_BIRD18; public static SoundEvent ENTITY_BIRD_BIRD19; public static SoundEvent ENTITY_BIRD_BIRD20; public static SoundEvent ENTITY_BIRD_BIRD21; public static SoundEvent ENTITY_BIRD_BIRD22; public static SoundEvent ENTITY_BIRD_BIRD23; public static SoundEvent ENTITY_GAMMAMETROID_LIVING; public static SoundEvent ENTITY_DRAGONFLY_LIVING; public static SoundEvent ENTITY_DRAGONFLY_HURT; public static SoundEvent ENTITY_MOSQUITO_LIVING; public static SoundEvent ENTITY_ALIEN_LIVING; public static SoundEvent ENTITY_ALIEN_HURT; public static SoundEvent ENTITY_CATERKILLER_LIVING1; public static SoundEvent ENTITY_CATERKILLER_LIVING2; public static SoundEvent ENTITY_CATERKILLER_LIVING3; public static SoundEvent ENTITY_CATERKILLER_LIVING4; public static SoundEvent ENTITY_SCORPION_HIT; public static SoundEvent CHAINSAW; public static SoundEvent ENTITY_MOTHRA_WINGS; public static SoundEvent ENTITY_KYUUBI_LIVING; public static SoundEvent ENTITY_STINKBUG_FART1; public static SoundEvent ENTITY_STINKBUG_FART2; public static SoundEvent ENTITY_STINKBUG_FART3; public static SoundEvent ENTITY_STINKBUG_FART4; public static SoundEvent ENTITY_STINKBUG_FART5; public static SoundEvent ENTITY_STINKBUG_FART6; public static SoundEvent ENTITY_STINKBUG_FART7; public static SoundEvent ENTITY_STINKBUG_FART8; public static SoundEvent ENTITY_STINKBUG_FART9;
/*     */   private static SoundEvent registerSound(String name) {
/*  96 */     ResourceLocation location = new ResourceLocation("orespawn", name);
/*  97 */     SoundEvent event = new SoundEvent(location);
/*  98 */     event.setRegistryName(name);
/*  99 */     ForgeRegistries.SOUND_EVENTS.register((IForgeRegistryEntry)event);
/* 100 */     return event;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespaw\\util\handlers\SoundsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */