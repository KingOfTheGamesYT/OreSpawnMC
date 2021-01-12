/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.client.registry.RenderingRegistry;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelCow;
/*     */ import net.minecraft.client.model.ModelSpider;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.client.renderer.entity.RenderArrow;
/*     */ import net.minecraft.client.renderer.entity.RenderFish;
/*     */ import net.minecraftforge.client.MinecraftForgeClient;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClientProxyOreSpawn
/*     */   extends CommonProxyOreSpawn
/*     */ {
/*     */   public void registerRenderThings() {
/*  41 */     MinecraftForge.EVENT_BUS.register(new GirlfriendOverlayGui(Minecraft.getMinecraft()));
/*     */ 
/*     */     
/*  44 */     RenderingRegistry.registerEntityRenderingHandler(Girlfriend.class, (Render)new RenderGirlfriend(new ModelBiped(), 0.5F));
/*  45 */     RenderingRegistry.registerEntityRenderingHandler(Boyfriend.class, (Render)new RenderBoyfriend(new ModelBiped(), 0.55F));
/*  46 */     RenderingRegistry.registerEntityRenderingHandler(RedCow.class, (Render)new RenderEnchantedCow(new ModelCow(), 0.7F));
/*  47 */     RenderingRegistry.registerEntityRenderingHandler(GoldCow.class, (Render)new RenderEnchantedCow(new ModelCow(), 0.7F));
/*  48 */     RenderingRegistry.registerEntityRenderingHandler(EnchantedCow.class, (Render)new RenderEnchantedCow(new ModelCow(), 0.7F));
/*  49 */     RenderingRegistry.registerEntityRenderingHandler(CrystalCow.class, (Render)new RenderEnchantedCow(new ModelCow(), 0.7F));
/*  50 */     RenderingRegistry.registerEntityRenderingHandler(Shoes.class, new RenderShoe());
/*  51 */     RenderingRegistry.registerEntityRenderingHandler(SunspotUrchin.class, new RenderItemUrchin());
/*  52 */     RenderingRegistry.registerEntityRenderingHandler(WaterBall.class, new RenderItemUrchin());
/*  53 */     RenderingRegistry.registerEntityRenderingHandler(InkSack.class, new RenderItemUrchin());
/*  54 */     RenderingRegistry.registerEntityRenderingHandler(LaserBall.class, new RenderItemUrchin());
/*  55 */     RenderingRegistry.registerEntityRenderingHandler(IceBall.class, new RenderItemUrchin());
/*  56 */     RenderingRegistry.registerEntityRenderingHandler(Acid.class, new RenderItemUrchin());
/*  57 */     RenderingRegistry.registerEntityRenderingHandler(DeadIrukandji.class, new RenderItemUrchin());
/*  58 */     RenderingRegistry.registerEntityRenderingHandler(BerthaHit.class, new RenderItemUrchin());
/*  59 */     RenderingRegistry.registerEntityRenderingHandler(EntityCage.class, new RenderCage());
/*  60 */     RenderingRegistry.registerEntityRenderingHandler(UltimateFishHook.class, (Render)new RenderFish());
/*  61 */     RenderingRegistry.registerEntityRenderingHandler(UltimateArrow.class, (Render)new RenderArrow());
/*  62 */     RenderingRegistry.registerEntityRenderingHandler(EntityThrownRock.class, new RenderThrownRock());
/*  63 */     RenderingRegistry.registerEntityRenderingHandler(EntityButterfly.class, (Render)new RenderButterfly(new ModelButterfly(1.0F), 0.3F, 1.0F));
/*  64 */     RenderingRegistry.registerEntityRenderingHandler(Firefly.class, (Render)new RenderFirefly(new ModelFirefly(2.5F), 0.2F, 0.75F));
/*  65 */     RenderingRegistry.registerEntityRenderingHandler(EntityLunaMoth.class, (Render)new RenderButterfly(new ModelButterfly(0.75F), 0.4F, 1.5F));
/*  66 */     RenderingRegistry.registerEntityRenderingHandler(EntityMosquito.class, (Render)new RenderMosquito(new ModelMosquito(), 0.3F, 0.5F));
/*  67 */     RenderingRegistry.registerEntityRenderingHandler(Ghost.class, (Render)new RenderGhost(new ModelGhost(), 0.0F, 0.65F));
/*  68 */     RenderingRegistry.registerEntityRenderingHandler(GhostSkelly.class, (Render)new RenderGhostSkelly(new ModelGhostSkelly(), 0.0F, 1.05F));
/*  69 */     RenderingRegistry.registerEntityRenderingHandler(Mothra.class, (Render)new RenderButterfly(new ModelButterfly(0.2F), 0.75F, 10.0F));
/*  70 */     RenderingRegistry.registerEntityRenderingHandler(EntityAnt.class, (Render)new RenderAnt(new ModelAnt(), 0.1F, 0.25F));
/*  71 */     RenderingRegistry.registerEntityRenderingHandler(EntityRedAnt.class, (Render)new RenderAnt(new ModelAnt(), 0.15F, 0.35F));
/*  72 */     RenderingRegistry.registerEntityRenderingHandler(EntityRainbowAnt.class, (Render)new RenderAnt(new ModelAnt(), 0.1F, 0.25F));
/*  73 */     RenderingRegistry.registerEntityRenderingHandler(EntityUnstableAnt.class, (Render)new RenderAnt(new ModelAnt(), 0.1F, 0.25F));
/*  74 */     RenderingRegistry.registerEntityRenderingHandler(Alosaurus.class, (Render)new RenderAlosaurus(new ModelAlosaurus(0.22F), 1.0F, 1.0F));
/*  75 */     RenderingRegistry.registerEntityRenderingHandler(TRex.class, (Render)new RenderTRex(new ModelTRex(0.2F), 1.0F, 1.2F));
/*  76 */     RenderingRegistry.registerEntityRenderingHandler(Tshirt.class, (Render)new RenderTshirt(new ModelTshirt(0.22F), 1.0F, 0.33F));
/*  77 */     RenderingRegistry.registerEntityRenderingHandler(Cryolophosaurus.class, (Render)new RenderCryolophosaurus(new ModelCryolophosaurus(0.75F), 0.75F, 0.5F));
/*  78 */     RenderingRegistry.registerEntityRenderingHandler(Basilisk.class, (Render)new RenderBasilisk(new ModelBasilisk(0.3F), 0.5F, 1.25F));
/*  79 */     RenderingRegistry.registerEntityRenderingHandler(Camarasaurus.class, (Render)new RenderCamarasaurus(new ModelCamarasaurus(0.65F), 0.65F, 0.65F));
/*  80 */     RenderingRegistry.registerEntityRenderingHandler(Hydrolisc.class, (Render)new RenderHydrolisc(new ModelHydrolisc(0.65F), 0.65F, 0.65F));
/*  81 */     RenderingRegistry.registerEntityRenderingHandler(VelocityRaptor.class, (Render)new RenderVelocityRaptor(new ModelVelocityRaptor(1.25F), 0.55F, 0.75F));
/*  82 */     RenderingRegistry.registerEntityRenderingHandler(Dragonfly.class, (Render)new RenderDragonfly(new ModelDragonfly(2.0F), 0.3F, 1.5F));
/*  83 */     RenderingRegistry.registerEntityRenderingHandler(Bee.class, (Render)new RenderBee(new ModelBee(2.0F), 0.9F, 1.1F));
/*  84 */     RenderingRegistry.registerEntityRenderingHandler(EmperorScorpion.class, (Render)new RenderEmperorScorpion(new ModelEmperorScorpion(0.22F), 0.95F, 1.5F));
/*  85 */     RenderingRegistry.registerEntityRenderingHandler(Spyro.class, (Render)new RenderSpyro(new ModelSpyro(0.65F), 0.65F, 0.75F));
/*  86 */     RenderingRegistry.registerEntityRenderingHandler(Baryonyx.class, (Render)new RenderBaryonyx(new ModelBaryonyx(0.25F), 1.0F, 1.0F));
/*  87 */     RenderingRegistry.registerEntityRenderingHandler(GammaMetroid.class, (Render)new RenderGammaMetroid(new ModelGammaMetroid(0.45F), 0.75F, 0.9F));
/*  88 */     RenderingRegistry.registerEntityRenderingHandler(Cockateil.class, (Render)new RenderCockateil(new ModelCockateil(1.0F), 0.3F, 0.75F));
/*  89 */     RenderingRegistry.registerEntityRenderingHandler(RubyBird.class, (Render)new RenderCockateil(new ModelCockateil(1.0F), 0.3F, 0.75F));
/*     */     
/*  91 */     RenderingRegistry.registerEntityRenderingHandler(Kyuubi.class, (Render)new RenderKyuubi(new ModelKyuubi(0.5F), 0.1F, 1.0F));
/*  92 */     RenderingRegistry.registerEntityRenderingHandler(Scorpion.class, (Render)new RenderScorpion(new ModelScorpion(0.62F), 0.35F, 0.75F));
/*  93 */     RenderingRegistry.registerEntityRenderingHandler(CaveFisher.class, (Render)new RenderCaveFisher(new ModelCaveFisher(0.62F), 0.35F, 0.75F));
/*  94 */     RenderingRegistry.registerEntityRenderingHandler(Alien.class, (Render)new RenderAlien(new ModelAlien(0.22F), 0.35F, 1.1F));
/*  95 */     RenderingRegistry.registerEntityRenderingHandler(WaterDragon.class, (Render)new RenderWaterDragon(new ModelWaterDragon(0.5F), 0.85F, 1.1F));
/*  96 */     RenderingRegistry.registerEntityRenderingHandler(AttackSquid.class, (Render)new RenderAttackSquid(new ModelAttackSquid(1.0F), 0.25F, 0.9F));
/*  97 */     RenderingRegistry.registerEntityRenderingHandler(Elevator.class, new RenderElevator());
/*  98 */     RenderingRegistry.registerEntityRenderingHandler(Robot1.class, (Render)new RenderRobot1(new ModelRobot1(2.0F), 0.3F, 1.0F));
/*  99 */     RenderingRegistry.registerEntityRenderingHandler(Robot2.class, (Render)new RenderRobot2(new ModelRobot2(1.0F), 1.0F, 1.0F));
/* 100 */     RenderingRegistry.registerEntityRenderingHandler(Robot3.class, (Render)new RenderRobot3(new ModelRobot3(1.0F), 1.0F, 0.5F));
/* 101 */     RenderingRegistry.registerEntityRenderingHandler(Robot4.class, (Render)new RenderRobot4(new ModelRobot4(1.0F), 1.0F, 1.0F));
/* 102 */     RenderingRegistry.registerEntityRenderingHandler(Robot5.class, (Render)new RenderRobot5(new ModelRobot5(1.0F), 0.5F, 1.0F));
/*     */     
/* 104 */     RenderingRegistry.registerEntityRenderingHandler(Kraken.class, (Render)new RenderKraken(new ModelKraken(1.0F), 1.0F, 1.0F));
/* 105 */     RenderingRegistry.registerEntityRenderingHandler(Lizard.class, (Render)new RenderLizard(new ModelLizard(0.65F), 0.75F, 1.0F));
/* 106 */     RenderingRegistry.registerEntityRenderingHandler(Cephadrome.class, (Render)new RenderCephadrome(new ModelCephadrome(0.55F), 1.25F, 1.0F));
/* 107 */     RenderingRegistry.registerEntityRenderingHandler(Dragon.class, (Render)new RenderDragon(new ModelDragon(0.65F), 1.25F, 1.0F));
/* 108 */     RenderingRegistry.registerEntityRenderingHandler(Chipmunk.class, (Render)new RenderChipmunk(new ModelChipmunk(1.0F), 0.15F, 0.9F));
/* 109 */     RenderingRegistry.registerEntityRenderingHandler(Gazelle.class, (Render)new RenderGazelle(new ModelGazelle(0.65F), 0.45F, 1.0F));
/* 110 */     RenderingRegistry.registerEntityRenderingHandler(Ostrich.class, (Render)new RenderOstrich(new ModelOstrich(0.65F), 0.55F, 1.0F));
/* 111 */     RenderingRegistry.registerEntityRenderingHandler(TrooperBug.class, (Render)new RenderTrooperBug(new ModelTrooperBug(0.22F), 0.95F, 1.1F));
/* 112 */     RenderingRegistry.registerEntityRenderingHandler(SpitBug.class, (Render)new RenderSpitBug(new ModelSpitBug(0.55F), 0.55F, 0.75F));
/* 113 */     RenderingRegistry.registerEntityRenderingHandler(StinkBug.class, (Render)new RenderStinkBug(new ModelStinkBug(0.75F), 0.35F, 0.85F));
/* 114 */     RenderingRegistry.registerEntityRenderingHandler(Island.class, (Render)new RenderIsland(new ModelIsland(1.0F), 0.25F, 1.0F));
/* 115 */     RenderingRegistry.registerEntityRenderingHandler(IslandToo.class, (Render)new RenderIslandToo(new ModelIsland(1.0F), 0.25F, 1.0F));
/* 116 */     RenderingRegistry.registerEntityRenderingHandler(CreepingHorror.class, (Render)new RenderCreepingHorror(new ModelCreepingHorror(), 0.45F, 0.75F));
/* 117 */     RenderingRegistry.registerEntityRenderingHandler(TerribleTerror.class, (Render)new RenderTerribleTerror(new ModelTerribleTerror(), 0.45F, 0.75F));
/* 118 */     RenderingRegistry.registerEntityRenderingHandler(CliffRacer.class, (Render)new RenderCliffRacer(new ModelCliffRacer(1.0F), 0.3F, 1.0F));
/* 119 */     RenderingRegistry.registerEntityRenderingHandler(Triffid.class, (Render)new RenderTriffid(new ModelTriffid(1.0F), 0.3F, 1.0F));
/* 120 */     RenderingRegistry.registerEntityRenderingHandler(PitchBlack.class, (Render)new RenderPitchBlack(new ModelPitchBlack(0.65F), 1.25F, 1.0F));
/* 121 */     RenderingRegistry.registerEntityRenderingHandler(LurkingTerror.class, (Render)new RenderLurkingTerror(new ModelLurkingTerror(), 0.45F, 0.85F));
/* 122 */     RenderingRegistry.registerEntityRenderingHandler(Godzilla.class, (Render)new RenderGodzilla(new ModelGodzilla(0.2F), 1.0F, 2.0F));
/* 123 */     RenderingRegistry.registerEntityRenderingHandler(GodzillaHead.class, (Render)new RenderGodzillaHead(null, 0.0F, 0.0F));
/* 124 */     RenderingRegistry.registerEntityRenderingHandler(KingHead.class, (Render)new RenderKingHead(null, 0.0F, 0.0F));
/* 125 */     RenderingRegistry.registerEntityRenderingHandler(QueenHead.class, (Render)new RenderQueenHead(null, 0.0F, 0.0F));
/*     */     
/* 127 */     RenderingRegistry.registerEntityRenderingHandler(WormSmall.class, (Render)new RenderWormSmall(new ModelWormSmall(), 0.1F, 1.0F));
/* 128 */     RenderingRegistry.registerEntityRenderingHandler(WormMedium.class, (Render)new RenderWormMedium(new ModelWormMedium(), 0.25F, 1.0F));
/* 129 */     RenderingRegistry.registerEntityRenderingHandler(WormLarge.class, (Render)new RenderWormLarge(new ModelWormLarge(), 0.9F, 1.0F));
/* 130 */     RenderingRegistry.registerEntityRenderingHandler(Cassowary.class, (Render)new RenderCassowary(new ModelCassowary(0.55F), 0.5F, 1.0F));
/* 131 */     RenderingRegistry.registerEntityRenderingHandler(GoldFish.class, (Render)new RenderGoldFish(new ModelGoldFish(0.7F), 0.2F, 1.0F));
/* 132 */     RenderingRegistry.registerEntityRenderingHandler(CloudShark.class, (Render)new RenderCloudShark(new ModelCloudShark(1.0F), 0.5F, 1.0F));
/* 133 */     RenderingRegistry.registerEntityRenderingHandler(LeafMonster.class, (Render)new RenderLeafMonster(new ModelLeafMonster(), 0.65F, 1.0F));
/*     */     
/* 135 */     RenderingRegistry.registerEntityRenderingHandler(EnderKnight.class, (Render)new RenderEnderKnight(new ModelEnderKnight(0.21F), 0.3F, 1.0F));
/* 136 */     RenderingRegistry.registerEntityRenderingHandler(EnderReaper.class, (Render)new RenderEnderReaper(new ModelEnderReaper(0.23F), 0.2F, 1.0F));
/* 137 */     RenderingRegistry.registerEntityRenderingHandler(Beaver.class, (Render)new RenderBeaver(new ModelBeaver(0.5F), 0.15F, 0.75F));
/* 138 */     RenderingRegistry.registerEntityRenderingHandler(Termite.class, (Render)new RenderAnt(new ModelAnt(), 0.15F, 0.35F));
/*     */     
/* 140 */     RenderingRegistry.registerEntityRenderingHandler(Fairy.class, (Render)new RenderFairy(new ModelFairy(1.5F), 0.1F, 0.35F));
/* 141 */     RenderingRegistry.registerEntityRenderingHandler(Peacock.class, (Render)new RenderPeacock(new ModelPeacock(0.75F), 0.25F, 1.0F));
/* 142 */     RenderingRegistry.registerEntityRenderingHandler(Rotator.class, (Render)new RenderRotator(new ModelRotator(0.25F), 0.1F, 1.0F));
/* 143 */     RenderingRegistry.registerEntityRenderingHandler(Vortex.class, (Render)new RenderVortex(new ModelVortex(0.25F), 0.1F, 1.0F));
/* 144 */     RenderingRegistry.registerEntityRenderingHandler(DungeonBeast.class, (Render)new RenderDungeonBeast(new ModelDungeonBeast(0.62F), 0.25F, 1.0F));
/* 145 */     RenderingRegistry.registerEntityRenderingHandler(Rat.class, (Render)new RenderRat(new ModelRat(1.0F), 0.1F, 0.75F));
/* 146 */     RenderingRegistry.registerEntityRenderingHandler(Flounder.class, (Render)new RenderFlounder(new ModelFlounder(), 0.1F, 1.0F));
/* 147 */     RenderingRegistry.registerEntityRenderingHandler(Whale.class, (Render)new RenderWhale(new ModelWhale(), 0.1F, 1.0F));
/* 148 */     RenderingRegistry.registerEntityRenderingHandler(Irukandji.class, (Render)new RenderIrukandji(new ModelIrukandji(1.0F), 0.1F, 0.25F));
/* 149 */     RenderingRegistry.registerEntityRenderingHandler(Skate.class, (Render)new RenderSkate(new ModelSkate(1.0F), 0.1F, 0.75F));
/* 150 */     RenderingRegistry.registerEntityRenderingHandler(Urchin.class, (Render)new RenderUrchin(new ModelUrchin(1.0F), 0.35F, 1.25F));
/*     */     
/* 152 */     RenderingRegistry.registerEntityRenderingHandler(Mantis.class, (Render)new RenderMantis(new ModelMantis(2.0F), 0.9F, 1.1F));
/* 153 */     RenderingRegistry.registerEntityRenderingHandler(HerculesBeetle.class, (Render)new RenderHerculesBeetle(new ModelHerculesBeetle(1.0F), 0.99F, 1.1F));
/* 154 */     RenderingRegistry.registerEntityRenderingHandler(Stinky.class, (Render)new RenderStinky(new ModelStinky(0.65F), 0.75F, 1.0F));
/* 155 */     RenderingRegistry.registerEntityRenderingHandler(Coin.class, (Render)new RenderCoin(new ModelCoin(0.22F), 0.75F, 0.125F));
/*     */     
/* 157 */     RenderingRegistry.registerEntityRenderingHandler(TheKing.class, (Render)new RenderTheKing(new ModelTheKing(0.65F), 1.9F, 2.1F));
/* 158 */     RenderingRegistry.registerEntityRenderingHandler(TheQueen.class, (Render)new RenderTheQueen(new ModelTheQueen(0.65F), 1.9F, 2.0F));
/* 159 */     RenderingRegistry.registerEntityRenderingHandler(ThePrince.class, (Render)new RenderThePrince(new ModelThePrince(0.65F), 0.75F, 0.75F));
/*     */     
/* 161 */     RenderingRegistry.registerEntityRenderingHandler(Molenoid.class, (Render)new RenderMolenoid(new ModelMolenoid(0.5F), 1.0F, 1.0F));
/* 162 */     RenderingRegistry.registerEntityRenderingHandler(SeaMonster.class, (Render)new RenderSeaMonster(new ModelSeaMonster(0.5F), 1.0F, 1.0F));
/* 163 */     RenderingRegistry.registerEntityRenderingHandler(SeaViper.class, (Render)new RenderSeaViper(new ModelSeaViper(0.5F), 1.0F, 1.0F));
/* 164 */     RenderingRegistry.registerEntityRenderingHandler(EasterBunny.class, (Render)new RenderEasterBunny(new ModelEasterBunny(0.55F), 0.5F, 1.0F));
/* 165 */     RenderingRegistry.registerEntityRenderingHandler(CaterKiller.class, (Render)new RenderCaterKiller(new ModelCaterKiller(0.22F), 1.0F, 1.25F));
/*     */     
/* 167 */     RenderingRegistry.registerEntityRenderingHandler(Leon.class, (Render)new RenderLeon(new ModelLeon(0.22F), 1.0F, 1.75F));
/* 168 */     RenderingRegistry.registerEntityRenderingHandler(Hammerhead.class, (Render)new RenderHammerhead(new ModelHammerhead(0.33F), 1.0F, 2.5F));
/* 169 */     RenderingRegistry.registerEntityRenderingHandler(RubberDucky.class, (Render)new RenderRubberDucky(new ModelRubberDucky(1.0F), 0.15F, 0.75F));
/* 170 */     RenderingRegistry.registerEntityRenderingHandler(ThePrinceTeen.class, (Render)new RenderThePrinceTeen(new ModelThePrinceTeen(0.65F), 1.0F, 1.25F));
/* 171 */     RenderingRegistry.registerEntityRenderingHandler(BandP.class, (Render)new RenderBandP(new ModelBandP(0.4F), 1.0F, 1.0F));
/* 172 */     RenderingRegistry.registerEntityRenderingHandler(RockBase.class, (Render)new RenderRockBase(new ModelRockBase(1.0F), 0.0F, 1.0F));
/*     */     
/* 174 */     RenderingRegistry.registerEntityRenderingHandler(PurplePower.class, (Render)new RenderPurplePower(new ModelPurplePower(1.0F), 0.3F, 2.75F));
/* 175 */     RenderingRegistry.registerEntityRenderingHandler(Brutalfly.class, (Render)new RenderBrutalfly(new ModelBrutalfly(0.2F), 0.75F, 9.0F));
/* 176 */     RenderingRegistry.registerEntityRenderingHandler(Nastysaurus.class, (Render)new RenderNastysaurus(new ModelNastysaurus(0.65F), 1.0F, 1.5F));
/* 177 */     RenderingRegistry.registerEntityRenderingHandler(Pointysaurus.class, (Render)new RenderPointysaurus(new ModelPointysaurus(1.0F), 1.0F, 1.0F));
/* 178 */     RenderingRegistry.registerEntityRenderingHandler(Cricket.class, (Render)new RenderCricket(new ModelCricket(2.5F), 0.15F, 0.5F));
/* 179 */     RenderingRegistry.registerEntityRenderingHandler(ThePrincess.class, (Render)new RenderThePrincess(new ModelThePrincess(0.65F), 0.7F, 0.7F));
/* 180 */     RenderingRegistry.registerEntityRenderingHandler(Frog.class, (Render)new RenderFrog(new ModelFrog(1.0F), 0.35F, 1.0F));
/* 181 */     RenderingRegistry.registerEntityRenderingHandler(ThePrinceAdult.class, (Render)new RenderThePrinceAdult(new ModelThePrinceAdult(0.65F), 1.2F, 1.0F));
/*     */     
/* 183 */     RenderingRegistry.registerEntityRenderingHandler(SpiderRobot.class, (Render)new RenderSpiderRobot(new ModelSpiderRobot(1.0F), 0.99F, 1.0F));
/* 184 */     RenderingRegistry.registerEntityRenderingHandler(SpiderDriver.class, (Render)new RenderSpiderDriver(new ModelSpider(), 0.5F));
/* 185 */     RenderingRegistry.registerEntityRenderingHandler(GiantRobot.class, (Render)new RenderGiantRobot(new ModelGiantRobot(0.25F), 0.99F, 1.0F));
/* 186 */     RenderingRegistry.registerEntityRenderingHandler(AntRobot.class, (Render)new RenderAntRobot(new ModelAntRobot(1.0F), 0.99F, 1.0F));
/* 187 */     RenderingRegistry.registerEntityRenderingHandler(Crab.class, (Render)new RenderCrab(new ModelCrab(1.0F), 0.99F, 1.0F));
/*     */ 
/*     */     
/* 190 */     MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyBertha, new RenderBertha());
/* 191 */     MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MySlice, new RenderSlice());
/* 192 */     MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyRoyal, new RenderRoyal());
/* 193 */     MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MySquidZooka, new RenderSquidZooka());
/* 194 */     MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyHammy, new RenderHammy());
/* 195 */     MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyBattleAxe, new RenderBattleAxe());
/* 196 */     MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyChainsaw, new RenderChainsaw());
/* 197 */     MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyQueenBattleAxe, new RenderQueenBattleAxe());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerSoundThings() {
/* 211 */     MinecraftForge.EVENT_BUS.register(new OreSpawnSounds());
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerKeyboardInput() {
/* 216 */     KeyHandler k = new KeyHandler();
/* 217 */     FMLCommonHandler.instance().bus().register(k);
/* 218 */     OreSpawnMain.MyKeyhandler = k;
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerNetworkStuff() {
/* 223 */     super.registerNetworkStuff();
/* 224 */     FMLCommonHandler.instance().bus().register(new RiderControl(getNetwork()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int setArmorPrefix(String string) {
/* 231 */     return RenderingRegistry.addNewArmourRendererPrefix(string);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ClientProxyOreSpawn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */