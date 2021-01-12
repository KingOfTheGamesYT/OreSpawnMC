/*      */ package danger.orespawn;
/*      */ 
/*      */ import cpw.mods.fml.common.Mod;
/*      */ import cpw.mods.fml.common.Mod.EventHandler;
/*      */ import cpw.mods.fml.common.Mod.Instance;
/*      */ import cpw.mods.fml.common.SidedProxy;
/*      */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*      */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*      */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*      */ import cpw.mods.fml.common.network.NetworkRegistry;
/*      */ import cpw.mods.fml.common.registry.EntityRegistry;
/*      */ import cpw.mods.fml.common.registry.GameRegistry;
/*      */ import cpw.mods.fml.common.registry.LanguageRegistry;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.GregorianCalendar;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.BlockDispenser;
/*      */ import net.minecraft.creativetab.CreativeTabs;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EnumCreatureType;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemArmor;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.MovingObjectPosition;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.util.WeightedRandomChestContent;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.biome.BiomeGenBase;
/*      */ import net.minecraft.world.chunk.Chunk;
/*      */ import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
/*      */ import net.minecraftforge.common.ChestGenHooks;
/*      */ import net.minecraftforge.common.DimensionManager;
/*      */ import net.minecraftforge.common.config.Configuration;
/*      */ import net.minecraftforge.common.util.EnumHelper;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @Mod(modid = "OreSpawn", name = "OreSpawn", version = "1.7.10.20.3")
/*      */ public class OreSpawnMain
/*      */ {
/*      */   @SidedProxy(clientSide = "danger.orespawn.ClientProxyOreSpawn", serverSide = "danger.orespawn.CommonProxyOreSpawn")
/*      */   public static CommonProxyOreSpawn proxy;
/*      */   @Instance("OreSpawn")
/*      */   public static OreSpawnMain instance;
/*  101 */   public static KeyHandler MyKeyhandler = null;
/*  102 */   public static int flyup_keystate = 0;
/*      */   
/*  104 */   public static int BaseBlockID = 2700;
/*  105 */   public static int BaseItemID = 9000;
/*  106 */   public static int BaseBiomeID = 120;
/*  107 */   public static int BaseDimensionID = 80;
/*      */   
/*  109 */   public static int BiomeUtopiaID = 0;
/*  110 */   public static int BiomeIslandsID = 0;
/*  111 */   public static int BiomeCrystalID = 0;
/*  112 */   public static int BiomeVillageID = 0;
/*  113 */   public static int BiomeChaosID = 0;
/*  114 */   public static int DimensionID = 0;
/*  115 */   public static int DimensionID2 = 0;
/*  116 */   public static int DimensionID3 = 0;
/*  117 */   public static int DimensionID4 = 0;
/*  118 */   public static int DimensionID5 = 0;
/*  119 */   public static int DimensionID6 = 0;
/*      */   
/*  121 */   public static int godzilla_has_spawned = 0;
/*  122 */   public static int current_dimension = 0;
/*  123 */   public static int valentines_day = 0;
/*  124 */   public static int easter_day = 0;
/*  125 */   public static int ultimate_sword_pvp = 0;
/*  126 */   public static int big_bertha_pvp = 0;
/*  127 */   public static int bro_mode = 0;
/*  128 */   public static int enableduplicatortree = 1;
/*  129 */   public static int RoyalGlideEnable = 1;
/*  130 */   public static int DragonflyHorseFriendly = 0;
/*  131 */   public static int PlayNicely = 0;
/*  132 */   public static int MinersDreamExpensive = 0;
/*  133 */   public static int DisableOverworldDungeons = 0;
/*  134 */   public static int FullPowerKingEnable = 0;
/*      */   
/*  136 */   public static ArmorStats Amethyst_armorstats = null;
/*  137 */   public static ArmorStats Emerald_armorstats = null;
/*  138 */   public static ArmorStats Experience_armorstats = null;
/*  139 */   public static ArmorStats MothScale_armorstats = null;
/*  140 */   public static ArmorStats LavaEel_armorstats = null;
/*  141 */   public static ArmorStats Ultimate_armorstats = null;
/*  142 */   public static ArmorStats Pink_armorstats = null;
/*  143 */   public static ArmorStats TigersEye_armorstats = null;
/*  144 */   public static ArmorStats Peacock_armorstats = null;
/*  145 */   public static ArmorStats Mobzilla_armorstats = null;
/*  146 */   public static ArmorStats Ruby_armorstats = null;
/*  147 */   public static ArmorStats Royal_armorstats = null;
/*  148 */   public static ArmorStats Lapis_armorstats = null;
/*  149 */   public static ArmorStats Queen_armorstats = null;
/*      */   
/*  151 */   public static int AllMobsDisable = 0;
/*  152 */   public static int MosquitoEnable = 1;
/*  153 */   public static int RockEnable = 1;
/*  154 */   public static int GhostEnable = 1;
/*  155 */   public static int GhostSkellyEnable = 1;
/*  156 */   public static int SpiderDriverEnable = 1;
/*  157 */   public static int JefferyEnable = 1;
/*  158 */   public static int MothraEnable = 1;
/*  159 */   public static int BrutalflyEnable = 1;
/*  160 */   public static int NastysaurusEnable = 1;
/*  161 */   public static int PointysaurusEnable = 1;
/*  162 */   public static int CricketEnable = 1;
/*  163 */   public static int FrogEnable = 1;
/*  164 */   public static int MothraPeaceful = 0;
/*  165 */   public static int BlackAntEnable = 1;
/*  166 */   public static int RedAntEnable = 1;
/*  167 */   public static int TermiteEnable = 1;
/*  168 */   public static int UnstableAntEnable = 1;
/*  169 */   public static int RainbowAntEnable = 1;
/*  170 */   public static int AlosaurusEnable = 1;
/*  171 */   public static int HammerheadEnable = 1;
/*  172 */   public static int LeonEnable = 1;
/*  173 */   public static int CaterKillerEnable = 1;
/*  174 */   public static int MolenoidEnable = 1;
/*  175 */   public static int TRexEnable = 1;
/*  176 */   public static int CriminalEnable = 1;
/*  177 */   public static int CryolophosaurusEnable = 1;
/*  178 */   public static int RatEnable = 1;
/*  179 */   public static int RatPlayerFriendly = 0;
/*  180 */   public static int RatPetFriendly = 0;
/*  181 */   public static int UrchinEnable = 1;
/*  182 */   public static int CamarasaurusEnable = 1;
/*  183 */   public static int ChipmunkEnable = 1;
/*  184 */   public static int OstrichEnable = 1;
/*  185 */   public static int GazelleEnable = 1;
/*  186 */   public static int VelocityRaptorEnable = 1;
/*  187 */   public static int HydroliscEnable = 1;
/*  188 */   public static int SpyroEnable = 1;
/*  189 */   public static int BaryonyxEnable = 1;
/*  190 */   public static int CockateilEnable = 1;
/*  191 */   public static int CassowaryEnable = 1;
/*  192 */   public static int EasterBunnyEnable = 1;
/*  193 */   public static int PeacockEnable = 1;
/*  194 */   public static int KyuubiEnable = 1;
/*  195 */   public static int CephadromeEnable = 1;
/*  196 */   public static int DragonEnable = 1;
/*  197 */   public static int GammaMetroidEnable = 1;
/*  198 */   public static int BasiliskEnable = 1;
/*  199 */   public static int DragonflyEnable = 1;
/*  200 */   public static int EmperorScorpionEnable = 1;
/*  201 */   public static int TrooperBugEnable = 1;
/*  202 */   public static int SpitBugEnable = 1;
/*  203 */   public static int StinkBugEnable = 1;
/*  204 */   public static int ScorpionEnable = 1;
/*  205 */   public static int CaveFisherEnable = 1;
/*  206 */   public static int AlienEnable = 1;
/*  207 */   public static int WaterDragonEnable = 1;
/*  208 */   public static int SeaMonsterEnable = 1;
/*  209 */   public static int SeaViperEnable = 1;
/*  210 */   public static int AttackSquidEnable = 1;
/*  211 */   public static int GodzillaEnable = 1;
/*  212 */   public static int LessOre = 0;
/*  213 */   public static int LessLag = 0;
/*  214 */   public static int Robot1Enable = 1;
/*  215 */   public static int Robot2Enable = 1;
/*  216 */   public static int Robot3Enable = 1;
/*  217 */   public static int Robot4Enable = 1;
/*  218 */   public static int Robot5Enable = 1;
/*  219 */   public static int RotatorEnable = 1;
/*  220 */   public static int VortexEnable = 1;
/*  221 */   public static int DungeonBeastEnable = 1;
/*  222 */   public static int KrakenEnable = 1;
/*  223 */   public static int LizardEnable = 1;
/*  224 */   public static int RubberDuckyEnable = 1;
/*  225 */   public static int GirlfriendEnable = 1;
/*  226 */   public static int BoyfriendEnable = 0;
/*  227 */   public static int FireflyEnable = 1;
/*  228 */   public static int FairyEnable = 1;
/*  229 */   public static int BeeEnable = 1;
/*  230 */   public static int TheKingEnable = 1;
/*  231 */   public static int TheQueenEnable = 1;
/*  232 */   public static int ThePrinceEnable = 1;
/*  233 */   public static int ThePrincessEnable = 1;
/*  234 */   public static int MantisEnable = 1;
/*  235 */   public static int StinkyEnable = 1;
/*  236 */   public static int HerculesBeetleEnable = 1;
/*  237 */   public static int CowEnable = 1;
/*  238 */   public static int ButterflyEnable = 1;
/*  239 */   public static int MothEnable = 1;
/*  240 */   public static int TshirtEnable = 1;
/*  241 */   public static int CoinEnable = 1;
/*  242 */   public static int CreepingHorrorEnable = 1;
/*  243 */   public static int TerribleTerrorEnable = 1;
/*  244 */   public static int CliffRacerEnable = 1;
/*  245 */   public static int TriffidEnable = 1;
/*  246 */   public static int UltimateSwordMagic = 10;
/*  247 */   public static int UltimateBowDamage = 10;
/*  248 */   public static int PitchBlackEnable = 1;
/*  249 */   public static int NightmareSize = 0;
/*  250 */   public static int LurkingTerrorEnable = 1;
/*  251 */   public static int IslandSpeedFactor = 2;
/*  252 */   public static int IslandSizeFactor = 2;
/*  253 */   public static int GinormousEmeraldTreeEnable = 1;
/*  254 */   public static int GuiOverlayEnable = 1;
/*  255 */   public static int FastGraphicsLeaves = 0;
/*  256 */   public static int WormEnable = 1;
/*  257 */   public static int CloudSharkEnable = 1;
/*  258 */   public static int GoldFishEnable = 1;
/*  259 */   public static int LeafMonsterEnable = 1;
/*  260 */   public static int EnderKnightEnable = 1;
/*  261 */   public static int EnderReaperEnable = 1;
/*  262 */   public static int BeaverEnable = 1;
/*  263 */   public static int IrukandjiEnable = 1;
/*  264 */   public static int SkateEnable = 1;
/*  265 */   public static int WhaleEnable = 1;
/*  266 */   public static int FlounderEnable = 1;
/*  267 */   public static int CrabEnable = 1;
/*      */ 
/*      */ 
/*      */   
/*  271 */   public OreSpawnWorld OreSpawnGen = new OreSpawnWorld();
/*  272 */   public static Random OreSpawnRand = new Random(151L);
/*  273 */   public static Trees OreSpawnTrees = null;
/*      */   
/*      */   public static BasiliskMaze BMaze;
/*      */   
/*      */   public static RubyBirdDungeon RubyDungeon;
/*      */   
/*      */   public static GenericDungeon MyDungeon;
/*      */   
/*      */   public static MyUtils OreSpawnUtils;
/*      */   
/*      */   public static ChunkOreGenerator Chunker;
/*      */   
/*      */   public static OreGenericEgg MySpiderSpawnBlock;
/*      */   
/*      */   public static OreGenericEgg MyBatSpawnBlock;
/*      */   
/*      */   public static OreGenericEgg MyCowSpawnBlock;
/*      */   
/*      */   public static OreGenericEgg MyPigSpawnBlock;
/*      */   public static OreGenericEgg MySquidSpawnBlock;
/*      */   public static OreGenericEgg MyChickenSpawnBlock;
/*      */   public static OreGenericEgg MyCreeperSpawnBlock;
/*      */   public static OreGenericEgg MySkeletonSpawnBlock;
/*      */   public static OreGenericEgg MyZombieSpawnBlock;
/*      */   public static OreGenericEgg MySlimeSpawnBlock;
/*      */   public static OreGenericEgg MyGhastSpawnBlock;
/*      */   public static OreGenericEgg MyZombiePigmanSpawnBlock;
/*      */   public static OreGenericEgg MyEndermanSpawnBlock;
/*      */   public static OreGenericEgg MyCaveSpiderSpawnBlock;
/*      */   public static OreGenericEgg MySilverfishSpawnBlock;
/*      */   public static OreGenericEgg MyMagmaCubeSpawnBlock;
/*      */   public static OreGenericEgg MyWitchSpawnBlock;
/*      */   public static OreGenericEgg MySheepSpawnBlock;
/*      */   public static OreGenericEgg MyWolfSpawnBlock;
/*      */   public static OreGenericEgg MyMooshroomSpawnBlock;
/*      */   public static OreGenericEgg MyOcelotSpawnBlock;
/*      */   public static OreGenericEgg MyBlazeSpawnBlock;
/*      */   public static OreGenericEgg MyWitherSkeletonSpawnBlock;
/*      */   public static OreGenericEgg MyEnderDragonSpawnBlock;
/*      */   public static OreGenericEgg MySnowGolemSpawnBlock;
/*      */   public static OreGenericEgg MyIronGolemSpawnBlock;
/*      */   public static OreGenericEgg MyWitherBossSpawnBlock;
/*      */   public static OreGenericEgg MyGirlfriendSpawnBlock;
/*      */   public static OreGenericEgg MyBoyfriendSpawnBlock;
/*      */   public static OreGenericEgg MyRedCowSpawnBlock;
/*      */   public static OreGenericEgg MyCrystalCowSpawnBlock;
/*      */   public static OreGenericEgg MyVillagerSpawnBlock;
/*      */   public static OreGenericEgg MyGoldCowSpawnBlock;
/*      */   public static OreGenericEgg MyEnchantedCowSpawnBlock;
/*      */   public static OreGenericEgg MyMOTHRASpawnBlock;
/*      */   public static OreGenericEgg MyAloSpawnBlock;
/*      */   public static OreGenericEgg MyCryoSpawnBlock;
/*      */   public static OreGenericEgg MyCamaSpawnBlock;
/*      */   public static OreGenericEgg MyVeloSpawnBlock;
/*      */   public static OreGenericEgg MyHydroSpawnBlock;
/*      */   public static OreGenericEgg MyBasilSpawnBlock;
/*      */   public static OreGenericEgg MyDragonflySpawnBlock;
/*      */   public static OreGenericEgg MyEmperorScorpionSpawnBlock;
/*      */   public static OreGenericEgg MyScorpionSpawnBlock;
/*      */   public static OreGenericEgg MyCaveFisherSpawnBlock;
/*      */   public static OreGenericEgg MySpyroSpawnBlock;
/*      */   public static OreGenericEgg MyBaryonyxSpawnBlock;
/*      */   public static OreGenericEgg MyGammaMetroidSpawnBlock;
/*      */   public static OreGenericEgg MyCockateilSpawnBlock;
/*      */   public static OreGenericEgg MyKyuubiSpawnBlock;
/*      */   public static OreGenericEgg MyAlienSpawnBlock;
/*      */   public static OreGenericEgg MyAttackSquidSpawnBlock;
/*      */   public static OreGenericEgg MyWaterDragonSpawnBlock;
/*      */   public static OreGenericEgg MyKrakenSpawnBlock;
/*      */   public static OreGenericEgg MyLizardSpawnBlock;
/*      */   public static OreGenericEgg MyCephadromeSpawnBlock;
/*      */   public static OreGenericEgg MyDragonSpawnBlock;
/*      */   public static OreGenericEgg MyBeeSpawnBlock;
/*      */   public static OreGenericEgg MyHorseSpawnBlock;
/*      */   public static OreGenericEgg MyTrooperBugSpawnBlock;
/*      */   public static OreGenericEgg MySpitBugSpawnBlock;
/*      */   public static OreGenericEgg MyStinkBugSpawnBlock;
/*      */   public static OreGenericEgg MyOstrichSpawnBlock;
/*      */   public static OreGenericEgg MyGazelleSpawnBlock;
/*      */   public static OreGenericEgg MyChipmunkSpawnBlock;
/*      */   public static OreGenericEgg MyCreepingHorrorSpawnBlock;
/*      */   public static OreGenericEgg MyTerribleTerrorSpawnBlock;
/*      */   public static OreGenericEgg MyCliffRacerSpawnBlock;
/*      */   public static OreGenericEgg MyTriffidSpawnBlock;
/*      */   public static OreGenericEgg MyPitchBlackSpawnBlock;
/*      */   public static OreGenericEgg MyLurkingTerrorSpawnBlock;
/*      */   public static OreGenericEgg MyGodzillaPartSpawnBlock;
/*      */   public static OreGenericEgg MyGodzillaSpawnBlock;
/*      */   public static OreGenericEgg MyTheKingPartSpawnBlock;
/*      */   public static OreGenericEgg MyTheQueenPartSpawnBlock;
/*      */   public static OreGenericEgg MyTheKingSpawnBlock;
/*      */   public static OreGenericEgg MyTheQueenSpawnBlock;
/*      */   public static OreGenericEgg MySmallWormSpawnBlock;
/*      */   public static OreGenericEgg MyMediumWormSpawnBlock;
/*      */   public static OreGenericEgg MyLargeWormSpawnBlock;
/*      */   public static OreGenericEgg MyCassowarySpawnBlock;
/*      */   public static OreGenericEgg MyCloudSharkSpawnBlock;
/*      */   public static OreGenericEgg MyGoldFishSpawnBlock;
/*      */   public static OreGenericEgg MyLeafMonsterSpawnBlock;
/*      */   public static OreGenericEgg MyTshirtSpawnBlock;
/*      */   public static OreGenericEgg MyEnderKnightSpawnBlock;
/*      */   public static OreGenericEgg MyEnderReaperSpawnBlock;
/*      */   public static OreGenericEgg MyBeaverSpawnBlock;
/*      */   public static OreGenericEgg MyUrchinSpawnBlock;
/*      */   public static OreGenericEgg MyFlounderSpawnBlock;
/*      */   public static OreGenericEgg MySkateSpawnBlock;
/*      */   public static OreGenericEgg MyRotatorSpawnBlock;
/*      */   public static OreGenericEgg MyPeacockSpawnBlock;
/*      */   public static OreGenericEgg MyFairySpawnBlock;
/*      */   public static OreGenericEgg MyDungeonBeastSpawnBlock;
/*      */   public static OreGenericEgg MyVortexSpawnBlock;
/*      */   public static OreGenericEgg MyRatSpawnBlock;
/*      */   public static OreGenericEgg MyWhaleSpawnBlock;
/*      */   public static OreGenericEgg MyIrukandjiSpawnBlock;
/*      */   public static OreGenericEgg MyTRexSpawnBlock;
/*      */   public static OreGenericEgg MyHerculesSpawnBlock;
/*      */   public static OreGenericEgg MyMantisSpawnBlock;
/*      */   public static OreGenericEgg MyStinkySpawnBlock;
/*      */   public static OreGenericEgg MyEasterBunnySpawnBlock;
/*      */   public static OreGenericEgg MyCaterKillerSpawnBlock;
/*      */   public static OreGenericEgg MyMolenoidSpawnBlock;
/*      */   public static OreGenericEgg MySeaMonsterSpawnBlock;
/*      */   public static OreGenericEgg MySeaViperSpawnBlock;
/*      */   public static OreGenericEgg MyLeonSpawnBlock;
/*      */   public static OreGenericEgg MyHammerheadSpawnBlock;
/*      */   public static OreGenericEgg MyRubberDuckySpawnBlock;
/*      */   public static OreGenericEgg MyCriminalSpawnBlock;
/*      */   public static OreGenericEgg MyBrutalflySpawnBlock;
/*      */   public static OreGenericEgg MyNastysaurusSpawnBlock;
/*      */   public static OreGenericEgg MyPointysaurusSpawnBlock;
/*      */   public static OreGenericEgg MyCricketSpawnBlock;
/*      */   public static OreGenericEgg MyFrogSpawnBlock;
/*      */   public static OreGenericEgg MySpiderDriverSpawnBlock;
/*      */   public static OreGenericEgg MyCrabSpawnBlock;
/*      */   public static Block MyOreUraniumBlock;
/*      */   public static Block MyOreTitaniumBlock;
/*      */   public static Item MyIngotUranium;
/*      */   public static Item MyIngotTitanium;
/*      */   public static Block MyBlockUraniumBlock;
/*      */   public static Block MyBlockTitaniumBlock;
/*      */   public static Block MyBlockMobzillaScaleBlock;
/*      */   public static Block MyBlockRubyBlock;
/*      */   public static Block MyBlockAmethystBlock;
/*      */   public static Block MyLavafoamBlock;
/*      */   public static Block MyPizzaBlock;
/*      */   public static Item MyPizzaItem;
/*      */   public static Block MyDuctTapeBlock;
/*      */   public static Item MyDuctTapeItem;
/*      */   public static Block MyAntBlock;
/*      */   public static Block MyRedAntBlock;
/*      */   public static Block TermiteBlock;
/*      */   public static Block CrystalTermiteBlock;
/*      */   public static Block MyRainbowAntBlock;
/*      */   public static Block MyUnstableAntBlock;
/*      */   public static Block MyFlowerPinkBlock;
/*      */   public static Block MyFlowerBlueBlock;
/*      */   public static Block MyFlowerBlackBlock;
/*      */   public static Block MyFlowerScaryBlock;
/*      */   public static Block CrystalFlowerRedBlock;
/*      */   public static Block CrystalFlowerGreenBlock;
/*      */   public static Block CrystalFlowerBlueBlock;
/*      */   public static Block CrystalFlowerYellowBlock;
/*      */   public static Block CrystalPlanksBlock;
/*      */   public static Block CrystalWorkbenchBlock;
/*      */   public static CrystalFurnace CrystalFurnaceBlock;
/*      */   public static Block CrystalFurnaceOnBlock;
/*      */   public static Item MyUltimateSword;
/*      */   public static Item MyUltimatePickaxe;
/*      */   public static Item MyUltimateShovel;
/*      */   public static Item MyUltimateHoe;
/*      */   public static Item MyUltimateAxe;
/*      */   public static Item MyNightmareSword;
/*      */   public static Item MyBertha;
/*      */   public static Item MyHammy;
/*      */   public static Item MyBattleAxe;
/*      */   public static Item MyQueenBattleAxe;
/*      */   public static Item MyChainsaw;
/*      */   public static Item MySquidZooka;
/*      */   public static Item MySlice;
/*      */   public static Item MyRoyal;
/*      */   public static Item MyEmeraldSword;
/*      */   public static Item MyEmeraldPickaxe;
/*      */   public static Item MyEmeraldShovel;
/*      */   public static Item MyEmeraldHoe;
/*      */   public static Item MyEmeraldAxe;
/*      */   public static Item MyExperienceSword;
/*      */   public static Item MyPoisonSword;
/*      */   public static Item MyRatSword;
/*      */   public static Item MyFairySword;
/*      */   public static Item MyMantisClaw;
/*      */   public static Item MyBigHammer;
/*      */   public static Item MyRubySword;
/*      */   public static Item MyRubyPickaxe;
/*      */   public static Item MyRubyShovel;
/*      */   public static Item MyRubyHoe;
/*      */   public static Item MyRubyAxe;
/*      */   public static Item MyAmethystSword;
/*      */   public static Item MyAmethystPickaxe;
/*      */   public static Item MyAmethystShovel;
/*      */   public static Item MyAmethystHoe;
/*      */   public static Item MyAmethystAxe;
/*      */   public static Item MyRoseSword;
/*      */   static Item.ToolMaterial toolULTIMATE;
/*      */   static Item.ToolMaterial toolNIGHTMARE;
/*      */   static Item.ToolMaterial toolBERTHA;
/*      */   static Item.ToolMaterial toolCRYSTALWOOD;
/*      */   static Item.ToolMaterial toolCRYSTALSTONE;
/*      */   static Item.ToolMaterial toolCRYSTALPINK;
/*      */   static Item.ToolMaterial toolTIGERSEYE;
/*      */   static Item.ToolMaterial toolRUBY;
/*      */   static Item.ToolMaterial toolAMETHYST;
/*      */   static Item.ToolMaterial toolEMERALD;
/*      */   static Item.ToolMaterial toolROYAL;
/*      */   static Item.ToolMaterial toolHAMMY;
/*      */   static Item.ToolMaterial toolBATTLE;
/*      */   static Item.ToolMaterial toolCHAINSAW;
/*      */   static Item.ToolMaterial toolQUEENBATTLE;
/*  490 */   static WeaponStats ultimate_stats = null;
/*  491 */   static WeaponStats nightmare_stats = null;
/*  492 */   static WeaponStats bertha_stats = null;
/*  493 */   static WeaponStats crystalwood_stats = null;
/*  494 */   static WeaponStats crystalstone_stats = null;
/*  495 */   static WeaponStats crystalpink_stats = null;
/*  496 */   static WeaponStats tigerseye_stats = null;
/*  497 */   static WeaponStats ruby_stats = null;
/*  498 */   static WeaponStats amethyst_stats = null;
/*  499 */   static WeaponStats emerald_stats = null;
/*  500 */   static WeaponStats royal_stats = null;
/*  501 */   static WeaponStats hammy_stats = null;
/*  502 */   static WeaponStats battleaxe_stats = null;
/*  503 */   static WeaponStats queenbattleaxe_stats = null;
/*  504 */   static WeaponStats chainsaw_stats = null;
/*      */   
/*      */   public static Item MyCrystalWoodSword;
/*      */   
/*      */   public static Item MyCrystalWoodPickaxe;
/*      */   
/*      */   public static Item MyCrystalWoodShovel;
/*      */   
/*      */   public static Item MyCrystalWoodHoe;
/*      */   
/*      */   public static Item MyCrystalWoodAxe;
/*      */   
/*      */   public static Item MyCrystalPinkSword;
/*      */   
/*      */   public static Item MyCrystalPinkPickaxe;
/*      */   
/*      */   public static Item MyCrystalPinkShovel;
/*      */   
/*      */   public static Item MyCrystalPinkHoe;
/*      */   
/*      */   public static Item MyCrystalPinkAxe;
/*      */   
/*      */   public static Item MyTigersEyeSword;
/*      */   
/*      */   public static Item MyTigersEyePickaxe;
/*      */   
/*      */   public static Item MyTigersEyeShovel;
/*      */   
/*      */   public static Item MyTigersEyeHoe;
/*      */   
/*      */   public static Item MyTigersEyeAxe;
/*      */   
/*      */   public static Item MyCrystalStoneSword;
/*      */   
/*      */   public static Item MyCrystalStonePickaxe;
/*      */   
/*      */   public static Item MyCrystalStoneShovel;
/*      */   
/*      */   public static Item MyCrystalStoneHoe;
/*      */   
/*      */   public static Item MyCrystalStoneAxe;
/*      */   
/*      */   public static Item MyCrystalPinkIngot;
/*      */   
/*      */   public static Block MyCrystalPinkBlock;
/*      */   
/*      */   public static Item MyTigersEyeIngot;
/*      */   public static Block MyTigersEyeBlock;
/*      */   public static Item MyItemShoes;
/*      */   public static Item MyItemShoes_1;
/*      */   public static Item MyItemShoes_2;
/*      */   public static Item MyItemShoes_3;
/*      */   public static Item MyItemGameController;
/*      */   public static Item MyUltimateBow;
/*      */   public static Item MySkateBow;
/*      */   public static Item MyUltimateFishingRod;
/*      */   public static ItemStack UltimateFishingRod;
/*      */   public static Item MyFireFish;
/*      */   public static Item MySunFish;
/*      */   public static Item MyLavaEel;
/*      */   public static Item MyMothScale;
/*      */   public static Item MyQueenScale;
/*      */   public static Item MyNightmareScale;
/*      */   public static Item MyEmperorScorpionScale;
/*      */   public static Item MyBasiliskScale;
/*      */   public static Item MyWaterDragonScale;
/*      */   public static Item MyJumpyBugScale;
/*      */   public static Item MyKrakenTooth;
/*      */   public static Item MyGodzillaScale;
/*      */   public static Item GreenGoo;
/*      */   public static Item SpiderRobotKit;
/*      */   public static Item AntRobotKit;
/*      */   public static Item ZooKeeper;
/*      */   public static Item CreeperLauncher;
/*      */   public static Item NetherLost;
/*      */   public static Item CrystalSticks;
/*      */   public static Item Sifter;
/*      */   public static Item MySunspotUrchin;
/*      */   public static Item MySparkFish;
/*      */   public static Item MyWaterBall;
/*      */   public static Item MyLaserBall;
/*      */   public static Item MyRayGun;
/*      */   public static Item MyThunderStaff;
/*      */   public static Item MyWrench;
/*      */   public static Item MyIceBall;
/*      */   public static Item MySmallRock;
/*      */   public static Item MyRock;
/*      */   public static Item MyRedRock;
/*      */   public static Item MyCrystalRedRock;
/*      */   public static Item MyCrystalGreenRock;
/*      */   public static Item MyCrystalBlueRock;
/*      */   public static Item MyCrystalTNTRock;
/*      */   public static Item MyBlueRock;
/*      */   public static Item MyGreenRock;
/*      */   public static Item MyPurpleRock;
/*      */   public static Item MySpikeyRock;
/*      */   public static Item MyTNTRock;
/*      */   public static Item MyAcid;
/*      */   public static Item MyIrukandji;
/*      */   public static Item MyIrukandjiArrow;
/*      */   public static Item MyGreenFish;
/*      */   public static Item MyBlueFish;
/*      */   public static Item MyPinkFish;
/*      */   public static Item MyRockFish;
/*      */   public static Item MyWoodFish;
/*      */   public static Item MyGreyFish;
/*      */   public static Item BerthaHandle;
/*      */   public static Item BerthaGuard;
/*      */   public static Item BerthaBlade;
/*      */   public static Item MolenoidNose;
/*      */   public static Item SeaMonsterScale;
/*      */   public static Item WormTooth;
/*      */   public static Item TRexTooth;
/*      */   public static Item CaterKillerJaw;
/*      */   public static Item SeaViperTongue;
/*      */   public static Item VortexEye;
/*      */   public static Item MyStepUp;
/*      */   public static Item MyStepDown;
/*      */   public static Item MyStepAccross;
/*      */   static ItemArmor.ArmorMaterial armorULTIMATE;
/*      */   static ItemArmor.ArmorMaterial armorMOBZILLA;
/*      */   static ItemArmor.ArmorMaterial armorLAVAEEL;
/*      */   static ItemArmor.ArmorMaterial armorMOTHSCALE;
/*      */   static ItemArmor.ArmorMaterial armorEMERALD;
/*      */   static ItemArmor.ArmorMaterial armorEXPERIENCE;
/*      */   static ItemArmor.ArmorMaterial armorRUBY;
/*      */   static ItemArmor.ArmorMaterial armorAMETHYST;
/*      */   static ItemArmor.ArmorMaterial armorPINK;
/*      */   static ItemArmor.ArmorMaterial armorTIGERSEYE;
/*      */   static ItemArmor.ArmorMaterial armorPEACOCK;
/*      */   static ItemArmor.ArmorMaterial armorROYAL;
/*      */   static ItemArmor.ArmorMaterial armorLAPIS;
/*      */   static ItemArmor.ArmorMaterial armorQUEEN;
/*      */   public static ItemOreSpawnArmor UltimateHelmet;
/*      */   public static ItemOreSpawnArmor UltimateBody;
/*      */   public static ItemOreSpawnArmor UltimateLegs;
/*      */   public static ItemOreSpawnArmor UltimateBoots;
/*      */   public static ItemOreSpawnArmor LavaEelHelmet;
/*      */   public static ItemOreSpawnArmor LavaEelBody;
/*      */   public static ItemOreSpawnArmor LavaEelLegs;
/*      */   public static ItemOreSpawnArmor LavaEelBoots;
/*      */   public static ItemOreSpawnArmor MothScaleHelmet;
/*      */   public static ItemOreSpawnArmor MothScaleBody;
/*      */   public static ItemOreSpawnArmor MothScaleLegs;
/*      */   public static ItemOreSpawnArmor MothScaleBoots;
/*      */   public static ItemOreSpawnArmor EmeraldHelmet;
/*      */   public static ItemOreSpawnArmor EmeraldBody;
/*      */   public static ItemOreSpawnArmor EmeraldLegs;
/*      */   public static ItemOreSpawnArmor EmeraldBoots;
/*      */   public static ItemOreSpawnArmor ExperienceHelmet;
/*      */   public static ItemOreSpawnArmor ExperienceBody;
/*      */   public static ItemOreSpawnArmor ExperienceLegs;
/*      */   public static ItemOreSpawnArmor ExperienceBoots;
/*      */   public static ItemOreSpawnArmor RubyHelmet;
/*      */   public static ItemOreSpawnArmor RubyBody;
/*      */   public static ItemOreSpawnArmor RubyLegs;
/*      */   public static ItemOreSpawnArmor RubyBoots;
/*      */   public static ItemOreSpawnArmor AmethystHelmet;
/*      */   public static ItemOreSpawnArmor AmethystBody;
/*      */   public static ItemOreSpawnArmor AmethystLegs;
/*      */   public static ItemOreSpawnArmor AmethystBoots;
/*      */   public static ItemOreSpawnArmor CrystalPinkHelmet;
/*      */   public static ItemOreSpawnArmor CrystalPinkBody;
/*      */   public static ItemOreSpawnArmor CrystalPinkLegs;
/*      */   public static ItemOreSpawnArmor CrystalPinkBoots;
/*      */   public static ItemOreSpawnArmor TigersEyeHelmet;
/*      */   public static ItemOreSpawnArmor TigersEyeBody;
/*      */   public static ItemOreSpawnArmor TigersEyeLegs;
/*      */   public static ItemOreSpawnArmor TigersEyeBoots;
/*      */   public static Block TigersEye;
/*      */   public static ItemOreSpawnArmor PeacockFeatherBoots;
/*      */   public static ItemOreSpawnArmor PeacockFeatherHelmet;
/*      */   public static ItemOreSpawnArmor PeacockFeatherBody;
/*      */   public static ItemOreSpawnArmor PeacockFeatherLegs;
/*      */   public static ItemOreSpawnArmor MobzillaHelmet;
/*      */   public static ItemOreSpawnArmor MobzillaBody;
/*      */   public static ItemOreSpawnArmor MobzillaLegs;
/*      */   public static ItemOreSpawnArmor MobzillaBoots;
/*      */   public static ItemOreSpawnArmor RoyalHelmet;
/*      */   public static ItemOreSpawnArmor RoyalBody;
/*      */   public static ItemOreSpawnArmor RoyalLegs;
/*      */   public static ItemOreSpawnArmor RoyalBoots;
/*      */   public static ItemOreSpawnArmor LapisHelmet;
/*      */   public static ItemOreSpawnArmor LapisBody;
/*      */   public static ItemOreSpawnArmor LapisLegs;
/*      */   public static ItemOreSpawnArmor LapisBoots;
/*      */   public static ItemOreSpawnArmor QueenHelmet;
/*      */   public static ItemOreSpawnArmor QueenBody;
/*      */   public static ItemOreSpawnArmor QueenLegs;
/*      */   public static ItemOreSpawnArmor QueenBoots;
/*      */   public static Block MyOreSaltBlock;
/*      */   public static Block MyRTPBlock;
/*      */   public static Block MyMoleDirtBlock;
/*      */   public static Item MySalt;
/*      */   public static Item MyPopcorn;
/*      */   public static Item MyButteredPopcorn;
/*      */   public static Item MyButteredSaltedPopcorn;
/*      */   public static Item MyPopcornBag;
/*      */   public static Item MyButter;
/*      */   public static Item MyCornDog;
/*      */   public static Item MyRawCornDog;
/*      */   public static Item MyPeacock;
/*      */   public static Item MyRawPeacock;
/*      */   public static Item MyElevator;
/*      */   public static Block MyOreRubyBlock;
/*      */   public static Item MyRuby;
/*      */   public static Item MyBacon;
/*      */   public static Item MyRawBacon;
/*      */   public static Item MyCrabMeat;
/*      */   public static Item MyRawCrabMeat;
/*      */   public static Item MyButterCandy;
/*      */   public static Block MyOreAmethystBlock;
/*      */   public static Item MyAmethyst;
/*      */   public static Item UraniumNugget;
/*      */   public static Item TitaniumNugget;
/*      */   public static Item MySalad;
/*      */   public static Item MyBLT;
/*      */   public static Item MyCrabbyPatty;
/*      */   public static Block CrystalStone;
/*      */   public static Block CrystalRat;
/*      */   public static Block CrystalFairy;
/*      */   public static Block CrystalCoal;
/*      */   public static Block CrystalGrass;
/*      */   public static Block CrystalCrystal;
/*      */   public static Block RedAntTroll;
/*      */   public static Block TermiteTroll;
/*      */   public static Item CageEmpty;
/*      */   public static Item CagedSpider;
/*      */   public static Item CagedBat;
/*      */   public static Item CagedCow;
/*      */   public static Item CagedPig;
/*      */   public static Item CagedSquid;
/*      */   public static Item CagedChicken;
/*      */   public static Item CagedCreeper;
/*      */   public static Item CagedSkeleton;
/*      */   public static Item CagedZombie;
/*      */   public static Item CagedSlime;
/*      */   public static Item CagedGhast;
/*      */   public static Item CagedZombiePigman;
/*      */   public static Item CagedEnderman;
/*      */   public static Item CagedCaveSpider;
/*      */   public static Item CagedSilverfish;
/*      */   public static Item CagedMagmaCube;
/*      */   public static Item CagedWitch;
/*      */   public static Item CagedSheep;
/*      */   public static Item CagedWolf;
/*      */   public static Item CagedMooshroom;
/*      */   public static Item CagedOcelot;
/*      */   public static Item CagedBlaze;
/*      */   public static Item CagedGirlfriend;
/*      */   public static Item CagedBoyfriend;
/*      */   public static Item CagedWitherSkeleton;
/*      */   public static Item CagedEnderDragon;
/*      */   public static Item CagedSnowGolem;
/*      */   public static Item CagedIronGolem;
/*      */   public static Item CagedWitherBoss;
/*      */   public static Item CagedRedCow;
/*      */   public static Item CagedCrystalCow;
/*      */   public static Item CagedVillager;
/*      */   public static Item CagedGoldCow;
/*      */   public static Item CagedEnchantedCow;
/*      */   public static Item CagedMOTHRA;
/*      */   public static Item CagedAlo;
/*      */   public static Item CagedCryo;
/*      */   public static Item CagedCama;
/*      */   public static Item CagedVelo;
/*      */   public static Item CagedHydro;
/*      */   public static Item CagedBasil;
/*      */   public static Item CagedDragonfly;
/*      */   public static Item CagedEmperorScorpion;
/*      */   public static Item CagedScorpion;
/*      */   public static Item CagedCaveFisher;
/*      */   public static Item CagedSpyro;
/*      */   public static Item CagedBaryonyx;
/*      */   public static Item CagedGammaMetroid;
/*      */   public static Item CagedCockateil;
/*      */   public static Item CagedKyuubi;
/*      */   public static Item CagedAlien;
/*      */   public static Item CagedAttackSquid;
/*      */   public static Item CagedWaterDragon;
/*      */   public static Item CagedCephadrome;
/*      */   public static Item CagedDragon;
/*      */   public static Item CagedKraken;
/*      */   public static Item CagedLizard;
/*      */   public static Item CagedBee;
/*      */   public static Item CagedHorse;
/*      */   public static Item CagedFirefly;
/*      */   public static Item CagedChipmunk;
/*      */   public static Item CagedGazelle;
/*      */   public static Item CagedOstrich;
/*      */   public static Item CagedTrooper;
/*      */   public static Item CagedSpit;
/*      */   public static Item CagedStink;
/*      */   public static Item CagedCreepingHorror;
/*      */   public static Item CagedTerribleTerror;
/*      */   public static Item CagedCliffRacer;
/*      */   public static Item CagedTriffid;
/*      */   public static Item CagedPitchBlack;
/*      */   public static Item CagedLurkingTerror;
/*      */   public static Item CagedSmallWorm;
/*      */   public static Item CagedMediumWorm;
/*      */   public static Item CagedLargeWorm;
/*      */   public static Item CagedCassowary;
/*      */   public static Item CagedCloudShark;
/*      */   public static Item CagedGoldFish;
/*      */   public static Item CagedLeafMonster;
/*      */   public static Item CagedEnderKnight;
/*      */   public static Item CagedEnderReaper;
/*      */   public static Item CagedBeaver;
/*      */   public static Item CagedUrchin;
/*      */   public static Item CagedFlounder;
/*      */   public static Item CagedSkate;
/*      */   public static Item CagedRotator;
/*      */   public static Item CagedPeacock;
/*      */   public static Item CagedFairy;
/*      */   public static Item CagedDungeonBeast;
/*      */   public static Item CagedVortex;
/*      */   public static Item CagedRat;
/*      */   public static Item CagedWhale;
/*      */   public static Item CagedIrukandji;
/*      */   public static Item CagedTRex;
/*      */   public static Item CagedHercules;
/*      */   public static Item CagedMantis;
/*      */   public static Item CagedStinky;
/*      */   public static Item CagedEasterBunny;
/*      */   public static Item CagedCaterKiller;
/*      */   public static Item CagedMolenoid;
/*      */   public static Item CagedSeaMonster;
/*      */   public static Item CagedSeaViper;
/*      */   public static Item CagedLeon;
/*      */   public static Item CagedHammerhead;
/*      */   public static Item CagedRubberDucky;
/*      */   public static Item CagedCriminal;
/*      */   public static Item CagedBrutalfly;
/*      */   public static Item CagedNastysaurus;
/*      */   public static Item CagedPointysaurus;
/*      */   public static Item CagedCricket;
/*      */   public static Item CagedFrog;
/*      */   public static Item CagedSpiderDriver;
/*      */   public static Item CagedCrab;
/*      */   public static Item WitherSkeletonEgg;
/*      */   public static Item EnderDragonEgg;
/*      */   public static Item SnowGolemEgg;
/*      */   public static Item IronGolemEgg;
/*      */   public static Item WitherBossEgg;
/*      */   public static Item GirlfriendEgg;
/*      */   public static Item RedCowEgg;
/*      */   public static Item CrystalCowEgg;
/*      */   public static Item GoldCowEgg;
/*      */   public static Item EnchantedCowEgg;
/*      */   public static Item MOTHRAEgg;
/*      */   public static Item AloEgg;
/*      */   public static Item CryoEgg;
/*      */   public static Item CamaEgg;
/*      */   public static Item VeloEgg;
/*      */   public static Item HydroEgg;
/*      */   public static Item BasilEgg;
/*      */   public static Item DragonflyEgg;
/*      */   public static Item EmperorScorpionEgg;
/*      */   public static Item ScorpionEgg;
/*      */   public static Item CaveFisherEgg;
/*      */   public static Item SpyroEgg;
/*      */   public static Item BaryonyxEgg;
/*      */   public static Item GammaMetroidEgg;
/*      */   public static Item CockateilEgg;
/*      */   public static Item KyuubiEgg;
/*      */   public static Item AlienEgg;
/*      */   public static Item AttackSquidEgg;
/*      */   public static Item WaterDragonEgg;
/*      */   public static Item CephadromeEgg;
/*      */   public static Item DragonEgg;
/*      */   public static Item KrakenEgg;
/*      */   public static Item LizardEgg;
/*      */   public static Item BeeEgg;
/*      */   public static Item TrooperBugEgg;
/*      */   public static Item SpitBugEgg;
/*      */   public static Item StinkBugEgg;
/*      */   public static Item OstrichEgg;
/*      */   public static Item GazelleEgg;
/*      */   public static Item ChipmunkEgg;
/*      */   public static Item CreepingHorrorEgg;
/*      */   public static Item TerribleTerrorEgg;
/*      */   public static Item CliffRacerEgg;
/*      */   public static Item TriffidEgg;
/*      */   public static Item PitchBlackEgg;
/*      */   public static Item LurkingTerrorEgg;
/*      */   public static Item GodzillaEgg;
/*      */   public static Item SmallWormEgg;
/*      */   public static Item MediumWormEgg;
/*      */   public static Item LargeWormEgg;
/*      */   public static Item CassowaryEgg;
/*      */   public static Item CloudSharkEgg;
/*      */   public static Item GoldFishEgg;
/*      */   public static Item LeafMonsterEgg;
/*      */   public static Item TshirtEgg;
/*      */   public static Item EnderKnightEgg;
/*      */   public static Item EnderReaperEgg;
/*      */   public static Item BeaverEgg;
/*      */   public static Item RotatorEgg;
/*      */   public static Item VortexEgg;
/*      */   public static Item PeacockEgg;
/*      */   public static Item FairyEgg;
/*      */   public static Item DungeonBeastEgg;
/*      */   public static Item RatEgg;
/*      */   public static Item FlounderEgg;
/*      */   public static Item WhaleEgg;
/*      */   public static Item IrukandjiEgg;
/*      */   public static Item SkateEgg;
/*      */   public static Item UrchinEgg;
/*      */   public static Item Robot1Egg;
/*      */   public static Item Robot2Egg;
/*      */   public static Item Robot3Egg;
/*      */   public static Item Robot4Egg;
/*      */   public static Item GhostEgg;
/*      */   public static Item GhostSkellyEgg;
/*      */   public static Item BrownAntEgg;
/*      */   public static Item RedAntEgg;
/*      */   public static Item RainbowAntEgg;
/*      */   public static Item UnstableAntEgg;
/*      */   public static Item TermiteEgg;
/*      */   public static Item ButterflyEgg;
/*      */   public static Item MothEgg;
/*      */   public static Item MosquitoEgg;
/*      */   public static Item FireflyEgg;
/*      */   public static Item TRexEgg;
/*      */   public static Item HerculesEgg;
/*      */   public static Item MantisEgg;
/*      */   public static Item StinkyEgg;
/*      */   public static Item Robot5Egg;
/*      */   public static Item CoinEgg;
/*      */   public static Item BoyfriendEgg;
/*      */   public static Item TheKingEgg;
/*      */   public static Item TheQueenEgg;
/*      */   public static Item ThePrinceEgg;
/*      */   public static Item EasterBunnyEgg;
/*      */   public static Item MolenoidEgg;
/*      */   public static Item SeaMonsterEgg;
/*      */   public static Item SeaViperEgg;
/*      */   public static Item CaterKillerEgg;
/*      */   public static Item LeonEgg;
/*      */   public static Item HammerheadEgg;
/*      */   public static Item RubberDuckyEgg;
/*      */   public static Item CriminalEgg;
/*      */   public static Item BrutalflyEgg;
/*      */   public static Item NastysaurusEgg;
/*      */   public static Item PointysaurusEgg;
/*      */   public static Item CricketEgg;
/*      */   public static Item ThePrincessEgg;
/*      */   public static Item FrogEgg;
/*      */   public static Item JefferyEgg;
/*      */   public static Item AntRobotEgg;
/*      */   public static Item SpiderRobotEgg;
/*      */   public static Item SpiderDriverEgg;
/*      */   public static Item CrabEgg;
/*      */   public static Item MyStrawberry;
/*      */   public static Item MyCrystalApple;
/*      */   public static Item MyLove;
/*      */   public static Item MyCheese;
/*      */   public static Item MyCherry;
/*      */   public static Item MyPeach;
/*      */   public static Item MyStrawberrySeed;
/*      */   public static Block MyStrawberryPlant;
/*      */   public static Item MyButterflySeed;
/*      */   public static Block MyButterflyPlant;
/*      */   public static Item MyMothSeed;
/*      */   public static Block MyMothPlant;
/*      */   public static Item MyMosquitoSeed;
/*      */   public static Block MyMosquitoPlant;
/*      */   public static Item MyFireflySeed;
/*      */   public static Block MyFireflyPlant;
/*      */   public static Item MyRadish;
/*      */   public static Item MyRice;
/*      */   public static Block MyRadishPlant;
/*      */   public static Block MyRicePlant;
/*      */   public static Block MyCornPlant1;
/*      */   public static Block MyCornPlant2;
/*      */   public static Block MyCornPlant3;
/*      */   public static Block MyCornPlant4;
/*      */   public static Item MyCornCob;
/*      */   public static Block MyQuinoaPlant1;
/*      */   public static Block MyQuinoaPlant2;
/*      */   public static Block MyQuinoaPlant3;
/*      */   public static Block MyQuinoaPlant4;
/*      */   public static Item MyQuinoa;
/*      */   public static Block MyTomatoPlant1;
/*      */   public static Block MyTomatoPlant2;
/*      */   public static Block MyTomatoPlant3;
/*      */   public static Block MyTomatoPlant4;
/*      */   public static Item MyTomato;
/*      */   public static Block MyLettucePlant1;
/*      */   public static Block MyLettucePlant2;
/*      */   public static Block MyLettucePlant3;
/*      */   public static Block MyLettucePlant4;
/*      */   public static Item MyLettuce;
/*      */   public static Item MagicApple;
/*      */   public static Item RandomDungeon;
/*      */   public static Item MinersDream;
/*      */   public static Block ExtremeTorch;
/*      */   public static Block MyEnderPearlBlock;
/*      */   public static Block MyEyeOfEnderBlock;
/*      */   public static Block MyExperiencePlant;
/*      */   public static Block KrakenRepellent;
/*      */   public static Block MyIslandBlock;
/*      */   public static Block CreeperRepellent;
/*      */   public static Item ZooCage2;
/*      */   public static Item ZooCage4;
/*      */   public static Item ZooCage6;
/*      */   public static Item ZooCage8;
/*      */   public static Item ZooCage10;
/*      */   public static Item InstantShelter;
/*      */   public static Item InstantGarden;
/*      */   public static Block CrystalTorch;
/*      */   public static Item MyPeacockFeather;
/*      */   public static Block MyKingSpawnerBlock;
/*      */   public static Block MyQueenSpawnerBlock;
/*      */   public static Block MyDungeonSpawnerBlock;
/*      */   public static Block MyCrystalPlant;
/*      */   public static Block MyCrystalPlant2;
/*      */   public static Block MyCrystalPlant3;
/*      */   public static Block MyAppleLeaves;
/*      */   public static Item MyAppleSeed;
/*      */   public static Item MyCherrySeed;
/*      */   public static Item MyPeachSeed;
/*      */   public static Block MySkyTreeLog;
/*      */   public static Block MyDT;
/*      */   public static Block MyExperienceLeaves;
/*      */   public static Block MyScaryLeaves;
/*      */   public static Block MyCherryLeaves;
/*      */   public static Block MyPeachLeaves;
/*      */   public static Item MyExperienceCatcher;
/*      */   public static Item MyExperienceTreeSeed;
/*      */   public static Item MyDeadStinkBug;
/*      */   public static Block MyCrystalLeaves;
/*      */   public static Block MyCrystalLeaves2;
/*      */   public static Block MyCrystalLeaves3;
/*      */   public static Block MyCrystalTreeLog;
/* 1040 */   public static int GirlfriendID = 0;
/* 1041 */   public static int BoyfriendID = 0;
/* 1042 */   public static int RedCowID = 0;
/* 1043 */   public static int GoldCowID = 0;
/* 1044 */   public static int CrystalCowID = 0;
/* 1045 */   public static int ButterflyID = 0;
/* 1046 */   public static int FireflyID = 0;
/* 1047 */   public static int FairyID = 0;
/* 1048 */   public static int BeeID = 0;
/* 1049 */   public static int TheKingID = 0;
/* 1050 */   public static int TheQueenID = 0;
/* 1051 */   public static int ThePrinceID = 0;
/* 1052 */   public static int ThePrincessID = 0;
/* 1053 */   public static int ThePrinceTeenID = 0;
/* 1054 */   public static int ThePrinceAdultID = 0;
/* 1055 */   public static int MantisID = 0;
/* 1056 */   public static int StinkyID = 0;
/* 1057 */   public static int HerculesBeetleID = 0;
/* 1058 */   public static int LunaMothID = 0;
/* 1059 */   public static int MosquitoID = 0;
/* 1060 */   public static int GhostID = 0;
/* 1061 */   public static int GhostSkellyID = 0;
/* 1062 */   public static int SpiderRobotID = 0;
/* 1063 */   public static int AntRobotID = 0;
/* 1064 */   public static int JefferyID = 0;
/* 1065 */   public static int SpiderDriverID = 0;
/* 1066 */   public static int MothraID = 0;
/* 1067 */   public static int BrutalflyID = 0;
/* 1068 */   public static int NastysaurusID = 0;
/* 1069 */   public static int PointysaurusID = 0;
/* 1070 */   public static int CricketID = 0;
/* 1071 */   public static int FrogID = 0;
/* 1072 */   public static int EnchantedCowID = 0;
/* 1073 */   public static int AntID = 0;
/* 1074 */   public static int UnstableAntID = 0;
/* 1075 */   public static int RedAntID = 0;
/* 1076 */   public static int TermiteID = 0;
/* 1077 */   public static int RockBaseID = 0;
/* 1078 */   public static int RainbowAntID = 0;
/* 1079 */   public static int AlosaurusID = 0;
/* 1080 */   public static int LeonID = 0;
/* 1081 */   public static int CaterKillerID = 0;
/* 1082 */   public static int MolenoidID = 0;
/* 1083 */   public static int TRexID = 0;
/* 1084 */   public static int BandPID = 0;
/* 1085 */   public static int CryolophosaurusID = 0;
/* 1086 */   public static int RatID = 0;
/* 1087 */   public static int UrchinID = 0;
/* 1088 */   public static int CamarasaurusID = 0;
/* 1089 */   public static int VelocityRaptorID = 0;
/* 1090 */   public static int HydroliscID = 0;
/* 1091 */   public static int SpyroID = 0;
/* 1092 */   public static int BaryonyxID = 0;
/* 1093 */   public static int CassowaryID = 0;
/* 1094 */   public static int EasterBunnyID = 0;
/* 1095 */   public static int PeacockID = 0;
/* 1096 */   public static int CockateilID = 0;
/* 1097 */   public static int RubyBirdID = 0;
/* 1098 */   public static int KyuubiID = 0;
/* 1099 */   public static int CephadromeID = 0;
/* 1100 */   public static int DragonID = 0;
/* 1101 */   public static int GammaMetroidID = 0;
/* 1102 */   public static int BasiliskID = 0;
/* 1103 */   public static int DragonflyID = 0;
/* 1104 */   public static int EmperorScorpionID = 0;
/* 1105 */   public static int TrooperBugID = 0;
/* 1106 */   public static int SpitBugID = 0;
/* 1107 */   public static int StinkBugID = 0;
/* 1108 */   public static int ScorpionID = 0;
/* 1109 */   public static int CaveFisherID = 0;
/* 1110 */   public static int AlienID = 0;
/* 1111 */   public static int WaterDragonID = 0;
/* 1112 */   public static int SeaMonsterID = 0;
/* 1113 */   public static int SeaViperID = 0;
/* 1114 */   public static int AttackSquidID = 0;
/* 1115 */   public static int ElevatorID = 0;
/* 1116 */   public static int Robot1ID = 0;
/* 1117 */   public static int Robot2ID = 0;
/* 1118 */   public static int Robot3ID = 0;
/* 1119 */   public static int Robot4ID = 0;
/* 1120 */   public static int Robot5ID = 0;
/* 1121 */   public static int RotatorID = 0;
/* 1122 */   public static int VortexID = 0;
/* 1123 */   public static int DungeonBeastID = 0;
/* 1124 */   public static int KrakenID = 0;
/* 1125 */   public static int LizardID = 0;
/* 1126 */   public static int RubberDuckyID = 0;
/* 1127 */   public static int ChipmunkID = 0;
/* 1128 */   public static int OstrichID = 0;
/* 1129 */   public static int GazelleID = 0;
/* 1130 */   public static int TshirtID = 0;
/* 1131 */   public static int CoinID = 0;
/* 1132 */   public static int IslandID = 0;
/* 1133 */   public static int IslandTooID = 0;
/* 1134 */   public static int CreepingHorrorID = 0;
/* 1135 */   public static int TerribleTerrorID = 0;
/* 1136 */   public static int CliffRacerID = 0;
/* 1137 */   public static int TriffidID = 0;
/* 1138 */   public static int PitchBlackID = 0;
/* 1139 */   public static int LurkingTerrorID = 0;
/* 1140 */   public static int GodzillaID = 0;
/* 1141 */   public static int WormSmallID = 0;
/* 1142 */   public static int WormMediumID = 0;
/* 1143 */   public static int WormLargeID = 0;
/* 1144 */   public static int CloudSharkID = 0;
/* 1145 */   public static int GoldFishID = 0;
/* 1146 */   public static int LeafMonsterID = 0;
/* 1147 */   public static int GodzillaHeadID = 0;
/* 1148 */   public static int KingHeadID = 0;
/* 1149 */   public static int QueenHeadID = 0;
/* 1150 */   public static int EnderKnightID = 0;
/* 1151 */   public static int EnderReaperID = 0;
/* 1152 */   public static int BeaverID = 0;
/* 1153 */   public static int SkateID = 0;
/* 1154 */   public static int IrukandjiID = 0;
/* 1155 */   public static int FlounderID = 0;
/* 1156 */   public static int WhaleID = 0;
/* 1157 */   public static int HammerheadID = 0;
/* 1158 */   public static int CrabID = 0;
/*      */ 
/*      */   
/* 1161 */   public static MobStats Bee_stats = null;
/* 1162 */   public static MobStats Mantis_stats = null;
/* 1163 */   public static MobStats HerculesBeetle_stats = null;
/* 1164 */   public static MobStats Mothra_stats = null;
/* 1165 */   public static MobStats Brutalfly_stats = null;
/* 1166 */   public static MobStats Nastysaurus_stats = null;
/* 1167 */   public static MobStats Pointysaurus_stats = null;
/* 1168 */   public static MobStats Alosaurus_stats = null;
/* 1169 */   public static MobStats SpiderRobot_stats = null;
/* 1170 */   public static MobStats AntRobot_stats = null;
/* 1171 */   public static MobStats Jeffery_stats = null;
/* 1172 */   public static MobStats Hammerhead_stats = null;
/* 1173 */   public static MobStats Leon_stats = null;
/* 1174 */   public static MobStats CaterKiller_stats = null;
/* 1175 */   public static MobStats Molenoid_stats = null;
/* 1176 */   public static MobStats TRex_stats = null;
/* 1177 */   public static MobStats BandP_stats = null;
/* 1178 */   public static MobStats Cryolophosaurus_stats = null;
/* 1179 */   public static MobStats Rat_stats = null;
/* 1180 */   public static MobStats Urchin_stats = null;
/* 1181 */   public static MobStats Kyuubi_stats = null;
/* 1182 */   public static MobStats GammaMetroid_stats = null;
/* 1183 */   public static MobStats Basilisk_stats = null;
/* 1184 */   public static MobStats EmperorScorpion_stats = null;
/* 1185 */   public static MobStats TrooperBug_stats = null;
/* 1186 */   public static MobStats SpitBug_stats = null;
/* 1187 */   public static MobStats Alien_stats = null;
/* 1188 */   public static MobStats WaterDragon_stats = null;
/* 1189 */   public static MobStats SeaMonster_stats = null;
/* 1190 */   public static MobStats SeaViper_stats = null;
/* 1191 */   public static MobStats Robot2_stats = null;
/* 1192 */   public static MobStats Robot3_stats = null;
/* 1193 */   public static MobStats Robot4_stats = null;
/* 1194 */   public static MobStats Robot5_stats = null;
/* 1195 */   public static MobStats Rotator_stats = null;
/* 1196 */   public static MobStats Vortex_stats = null;
/* 1197 */   public static MobStats DungeonBeast_stats = null;
/* 1198 */   public static MobStats Triffid_stats = null;
/* 1199 */   public static MobStats LurkingTerror_stats = null;
/* 1200 */   public static MobStats WormSmall_stats = null;
/* 1201 */   public static MobStats WormMedium_stats = null;
/* 1202 */   public static MobStats WormLarge_stats = null;
/* 1203 */   public static MobStats EnderKnight_stats = null;
/* 1204 */   public static MobStats EnderReaper_stats = null;
/* 1205 */   public static MobStats Irukandji_stats = null;
/* 1206 */   public static MobStats AttackSquid_stats = null;
/* 1207 */   public static MobStats CaveFisher_stats = null;
/* 1208 */   public static MobStats CloudShark_stats = null;
/* 1209 */   public static MobStats CreepingHorror_stats = null;
/* 1210 */   public static MobStats Godzilla_stats = null;
/* 1211 */   public static MobStats Kraken_stats = null;
/* 1212 */   public static MobStats LeafMonster_stats = null;
/* 1213 */   public static MobStats PitchBlack_stats = null;
/* 1214 */   public static MobStats Crab_stats = null;
/* 1215 */   public static MobStats Scorpion_stats = null;
/* 1216 */   public static MobStats Skate_stats = null;
/* 1217 */   public static MobStats TerribleTerror_stats = null;
/* 1218 */   public static MobStats TheKing_stats = null;
/* 1219 */   public static MobStats TheQueen_stats = null;
/*      */   
/* 1221 */   public static OreStats Ruby_stats = null;
/* 1222 */   public static OreStats BlkRuby_stats = null;
/* 1223 */   public static OreStats Uranium_stats = null;
/* 1224 */   public static OreStats Titanium_stats = null;
/* 1225 */   public static OreStats Amethyst_stats = null;
/* 1226 */   public static OreStats Salt_stats = null;
/* 1227 */   public static OreStats SpawnOres_stats = null;
/* 1228 */   public static OreStats Diamond_stats = null;
/* 1229 */   public static OreStats BlkDiamond_stats = null;
/* 1230 */   public static OreStats Emerald_stats = null;
/* 1231 */   public static OreStats BlkEmerald_stats = null;
/* 1232 */   public static OreStats Gold_stats = null;
/* 1233 */   public static OreStats BlkGold_stats = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @EventHandler
/*      */   public void preInit(FMLPreInitializationEvent event) {
/* 1243 */     Configuration config = new Configuration(event.getSuggestedConfigurationFile());
/* 1244 */     String ids = "OreSpawnIDS";
/* 1245 */     String mobs = "OreSpawnMOBS";
/* 1246 */     String tweaks = "OreSpawnTWEAKS";
/* 1247 */     String weapons = "OreSpawnWEAPONS";
/* 1248 */     String ores = "OreSpawnORES";
/*      */     
/* 1250 */     config.load();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1258 */     BaseBlockID = config.get(ids, "BaseBlockID", 2700).getInt();
/* 1259 */     BaseItemID = config.get(ids, "BaseItemID", 9000).getInt();
/* 1260 */     BaseBiomeID = config.get(ids, "BaseBiomeID", 120).getInt();
/* 1261 */     BaseDimensionID = config.get(ids, "BaseDimensionID", 80).getInt();
/*      */     
/* 1263 */     getMobs(config, mobs);
/*      */ 
/*      */     
/* 1266 */     AllMobsDisable = config.get(tweaks, "AllMobsDisable", 0).getInt();
/* 1267 */     LessOre = config.get(tweaks, "LessOre", 0).getInt();
/* 1268 */     LessLag = config.get(tweaks, "LessLag", 0).getInt();
/* 1269 */     RatPlayerFriendly = config.get(tweaks, "RatPlayerFriendly", 1).getInt();
/* 1270 */     RatPetFriendly = config.get(tweaks, "RatPetFriendly", 1).getInt();
/* 1271 */     NightmareSize = config.get(tweaks, "NightmareSize", 0).getInt();
/* 1272 */     IslandSpeedFactor = config.get(tweaks, "IslandSpeedFactor", 2).getInt();
/* 1273 */     IslandSizeFactor = config.get(tweaks, "IslandSizeFactor", 2).getInt();
/* 1274 */     GinormousEmeraldTreeEnable = config.get(tweaks, "GinormousEmeraldTreeEnable", 1).getInt();
/* 1275 */     GuiOverlayEnable = config.get(tweaks, "GuiOverlayEnable", 1).getInt();
/* 1276 */     ultimate_sword_pvp = config.get(tweaks, "UltimateSwordPvp", 0).getInt();
/* 1277 */     big_bertha_pvp = config.get(tweaks, "BigBerthaPvp", 0).getInt();
/* 1278 */     bro_mode = config.get(tweaks, "BoyfriendBroMode", 0).getInt();
/* 1279 */     enableduplicatortree = config.get(tweaks, "DuplicatorTreeEnable", 1).getInt();
/* 1280 */     RoyalGlideEnable = config.get(tweaks, "RoyalGlideEnable", 1).getInt();
/* 1281 */     DragonflyHorseFriendly = config.get(tweaks, "DragonflyHorseFriendly", 0).getInt();
/* 1282 */     PlayNicely = config.get(tweaks, "PlayNicely", 0).getInt();
/* 1283 */     MinersDreamExpensive = config.get(tweaks, "MinersDreamExpensive", 0).getInt();
/* 1284 */     DisableOverworldDungeons = config.get(tweaks, "DisableOverworldDungeons", 0).getInt();
/* 1285 */     FullPowerKingEnable = config.get(tweaks, "FullPowerKingEnable", 0).getInt();
/*      */     
/* 1287 */     Amethyst_armorstats = get_armorstats(config, "Amethyst", 100, 4, 8, 7, 3, 40, 0, 0, 0, 0, 0, 0, 0, 0);
/* 1288 */     Emerald_armorstats = get_armorstats(config, "Emerald", 60, 3, 8, 6, 3, 40, 0, 0, 0, 0, 0, 0, 0, 0);
/* 1289 */     Experience_armorstats = get_armorstats(config, "Experience", 70, 5, 9, 7, 4, 50, 0, 0, 2, 0, 1, 0, 0, 1);
/* 1290 */     MothScale_armorstats = get_armorstats(config, "MothScale", 50, 2, 7, 5, 2, 50, 0, 0, 3, 3, 3, 0, 0, 5);
/* 1291 */     LavaEel_armorstats = get_armorstats(config, "LavaEel", 40, 2, 7, 5, 2, 35, 1, 2, 3, 2, 10, 0, 0, 2);
/* 1292 */     Ultimate_armorstats = get_armorstats(config, "Ultimate", 200, 6, 12, 10, 6, 100, 2, 3, 5, 5, 5, 5, 0, 3);
/* 1293 */     Pink_armorstats = get_armorstats(config, "Pink", 50, 3, 7, 5, 2, 40, 0, 0, 0, 0, 0, 0, 0, 0);
/* 1294 */     TigersEye_armorstats = get_armorstats(config, "TigersEye", 80, 4, 8, 7, 4, 55, 0, 0, 0, 0, 0, 0, 0, 0);
/* 1295 */     Peacock_armorstats = get_armorstats(config, "Peacock", 40, 2, 5, 4, 2, 30, 0, 0, 0, 0, 0, 0, 0, 10);
/* 1296 */     Mobzilla_armorstats = get_armorstats(config, "Mobzilla", 1000, 7, 13, 11, 7, 150, 0, 0, 10, 10, 10, 10, 5, 10);
/* 1297 */     Ruby_armorstats = get_armorstats(config, "Ruby", 90, 4, 9, 8, 4, 40, 0, 0, 0, 0, 0, 0, 0, 0);
/* 1298 */     Royal_armorstats = get_armorstats(config, "Royal", 2000, 8, 14, 12, 8, 200, 1, 2, 10, 10, 10, 10, 5, 10);
/* 1299 */     Lapis_armorstats = get_armorstats(config, "Lapis", 60, 2, 7, 5, 2, 60, 1, 1, 1, 0, 0, 1, 0, 0);
/* 1300 */     Queen_armorstats = get_armorstats(config, "Queen", 1500, 9, 16, 14, 9, 150, 0, 0, 0, 0, 0, 0, 0, 0);
/*      */ 
/*      */     
/* 1303 */     ultimate_stats = get_weaponstats(config, weapons, "Ultimate", 10, 3000, 15, 36, 100);
/* 1304 */     nightmare_stats = get_weaponstats(config, weapons, "Nightmare", 3, 1800, 12, 26, 60);
/* 1305 */     bertha_stats = get_weaponstats(config, weapons, "Bertha", 3, 9000, 15, 496, 100);
/* 1306 */     crystalwood_stats = get_weaponstats(config, weapons, "CrystalWood", 2, 300, 3, 2, 15);
/* 1307 */     crystalstone_stats = get_weaponstats(config, weapons, "CrystalStone", 3, 800, 6, 5, 45);
/* 1308 */     crystalpink_stats = get_weaponstats(config, weapons, "Pink", 4, 1100, 10, 7, 65);
/* 1309 */     tigerseye_stats = get_weaponstats(config, weapons, "TigersEye", 4, 1600, 12, 8, 75);
/* 1310 */     ruby_stats = get_weaponstats(config, weapons, "Ruby", 5, 1500, 11, 16, 85);
/* 1311 */     amethyst_stats = get_weaponstats(config, weapons, "Amethyst", 4, 2000, 11, 11, 70);
/* 1312 */     emerald_stats = get_weaponstats(config, weapons, "Emerald", 3, 1300, 10, 6, 75);
/* 1313 */     royal_stats = get_weaponstats(config, weapons, "Royal", 3, 10000, 15, 746, 150);
/* 1314 */     hammy_stats = get_weaponstats(config, weapons, "Attitude", 5, 2000, 15, 82, 100);
/* 1315 */     battleaxe_stats = get_weaponstats(config, weapons, "BattleAxe", 3, 1500, 15, 46, 75);
/* 1316 */     chainsaw_stats = get_weaponstats(config, weapons, "Chainsaw", 3, 1500, 10, 56, 75);
/* 1317 */     queenbattleaxe_stats = get_weaponstats(config, weapons, "QueenBattleAxe", 3, 2200, 15, 662, 100);
/*      */     
/* 1319 */     UltimateSwordMagic = config.get(weapons, "UltimateSwordEnchantmentLevel", 5).getInt();
/* 1320 */     UltimateBowDamage = config.get(weapons, "UltimateBowDamage", 10).getInt();
/*      */     
/* 1322 */     if (UltimateSwordMagic < 1) UltimateSwordMagic = 1; 
/* 1323 */     if (UltimateSwordMagic > 10) UltimateSwordMagic = 10; 
/* 1324 */     if (UltimateBowDamage < 2) UltimateBowDamage = 2; 
/* 1325 */     if (UltimateBowDamage > 20) UltimateBowDamage = 20;
/*      */     
/* 1327 */     if (IslandSpeedFactor < 1) IslandSpeedFactor = 1; 
/* 1328 */     if (IslandSpeedFactor > 5) IslandSpeedFactor = 5; 
/* 1329 */     if (IslandSizeFactor < 1) IslandSizeFactor = 1; 
/* 1330 */     if (IslandSizeFactor > 5) IslandSizeFactor = 5;
/*      */     
/* 1332 */     if (NightmareSize < 0) NightmareSize = 0; 
/* 1333 */     if (NightmareSize > 5) NightmareSize = 5; 
/* 1334 */     if (LessLag < 0) LessLag = 0; 
/* 1335 */     if (LessLag > 2) LessLag = 2; 
/* 1336 */     if (LessLag == 1) {
/* 1337 */       if (IslandSizeFactor > 2) IslandSizeFactor = 2; 
/* 1338 */       if (IslandSpeedFactor > 2) IslandSpeedFactor = 2; 
/*      */     } 
/* 1340 */     if (LessLag == 2) {
/* 1341 */       if (IslandSizeFactor > 1) IslandSizeFactor = 1; 
/* 1342 */       if (IslandSpeedFactor > 1) IslandSpeedFactor = 1; 
/* 1343 */       LessOre = 1;
/*      */     } 
/*      */     
/* 1346 */     Ruby_stats = get_orestats(config, ores, "Ruby", 10, 1, 0, 50);
/* 1347 */     BlkRuby_stats = get_orestats(config, ores, "BlockRuby", 1, 2, 0, 15);
/* 1348 */     Uranium_stats = get_orestats(config, ores, "Uranium", 3, 4, 0, 30);
/* 1349 */     Titanium_stats = get_orestats(config, ores, "Titanium", 3, 4, 0, 20);
/* 1350 */     Amethyst_stats = get_orestats(config, ores, "Amethyst", 2, 6, 0, 25);
/* 1351 */     Salt_stats = get_orestats(config, ores, "Salt", 5, 12, 50, 128);
/* 1352 */     SpawnOres_stats = get_orestats(config, ores, "SpawnOres", 28, 4, 50, 128);
/* 1353 */     Diamond_stats = get_orestats(config, ores, "Diamond", 4, 6, 0, 30);
/* 1354 */     BlkDiamond_stats = get_orestats(config, ores, "BlockDiamond", 2, 4, 0, 20);
/* 1355 */     Emerald_stats = get_orestats(config, ores, "Emerald", 4, 6, 0, 40);
/* 1356 */     BlkEmerald_stats = get_orestats(config, ores, "BlockEmerald", 2, 4, 0, 20);
/* 1357 */     Gold_stats = get_orestats(config, ores, "Gold", 4, 8, 0, 40);
/* 1358 */     BlkGold_stats = get_orestats(config, ores, "BlockGold", 2, 4, 0, 25);
/*      */ 
/*      */     
/* 1361 */     config.save();
/*      */     
/* 1363 */     if (AllMobsDisable != 0) {
/* 1364 */       disableAllMobs();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1370 */     BiomeUtopiaID = BaseBiomeID;
/* 1371 */     BiomeIslandsID = BaseBiomeID + 1;
/* 1372 */     BiomeCrystalID = BaseBiomeID + 2;
/* 1373 */     BiomeVillageID = BaseBiomeID + 3;
/* 1374 */     BiomeChaosID = BaseBiomeID + 4;
/* 1375 */     DimensionID = BaseDimensionID;
/* 1376 */     DimensionID2 = BaseDimensionID + 1;
/* 1377 */     DimensionID3 = BaseDimensionID + 2;
/* 1378 */     DimensionID4 = BaseDimensionID + 3;
/* 1379 */     DimensionID5 = BaseDimensionID + 4;
/* 1380 */     DimensionID6 = BaseDimensionID + 5;
/*      */ 
/*      */     
/* 1383 */     proxy.registerSoundThings();
/*      */     
/* 1385 */     laySomeEggs();
/*      */ 
/*      */ 
/*      */     
/* 1389 */     MyOreUraniumBlock = (new OreUranium(BaseBlockID + 101)).setBlockName("oreuranium");
/* 1390 */     MyOreTitaniumBlock = (new OreTitanium(BaseBlockID + 102)).setBlockName("oretitanium");
/* 1391 */     MyIngotUranium = (new IngotUranium(BaseItemID + 152)).setUnlocalizedName("ingoturanium");
/* 1392 */     MyIngotTitanium = (new IngotTitanium(BaseItemID + 153)).setUnlocalizedName("ingottitanium");
/* 1393 */     MyBlockUraniumBlock = (new BlockUranium(BaseBlockID + 107)).setBlockName("blockuranium");
/* 1394 */     MyBlockTitaniumBlock = (new BlockTitanium(BaseBlockID + 108)).setBlockName("blocktitanium");
/* 1395 */     MyBlockMobzillaScaleBlock = (new BlockRuby(BaseBlockID + 124)).setBlockName("blockmobzillascale");
/* 1396 */     MyLavafoamBlock = (new Lavafoam(BaseBlockID + 106)).setBlockName("lavafoam");
/* 1397 */     MyBlockRubyBlock = (new BlockRuby(BaseBlockID + 109)).setBlockName("blockruby");
/* 1398 */     MyBlockAmethystBlock = (new BlockRuby(BaseBlockID + 110)).setBlockName("blockamethyst");
/* 1399 */     MyCrystalPinkBlock = (new BlockCrystal(BaseBlockID + 216)).setBlockName("crystalpink_block");
/* 1400 */     MyCrystalPinkIngot = (new IngotUranium(BaseItemID + 348)).setUnlocalizedName("crystalpink_ingot");
/* 1401 */     MyTigersEyeBlock = (new BlockCrystal(BaseBlockID + 218)).setBlockName("tigerseye_block");
/* 1402 */     MyTigersEyeIngot = (new IngotUranium(BaseItemID + 358)).setUnlocalizedName("tigerseye_ingot");
/*      */     
/* 1404 */     MyPizzaBlock = (new BlockPizza(BaseBlockID + 194)).setBlockName("pizza");
/* 1405 */     MyPizzaItem = (new ItemPizza(BaseItemID + 204, MyPizzaBlock)).setMaxStackSize(1).setCreativeTab(CreativeTabs.tabFood).setUnlocalizedName("pizza");
/* 1406 */     MyDuctTapeBlock = (new BlockDuctTape(BaseBlockID + 198)).setBlockName("ducttape");
/* 1407 */     MyDuctTapeItem = (new ItemDuctTape(BaseItemID + 458, MyDuctTapeBlock)).setMaxStackSize(1).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("ducttape");
/*      */     
/* 1409 */     toolULTIMATE = EnumHelper.addToolMaterial("ULTIMATE", ultimate_stats.harvestlevel, ultimate_stats.maxuses, ultimate_stats.efficiency, ultimate_stats.damage, ultimate_stats.enchantability);
/*      */     
/* 1411 */     toolNIGHTMARE = EnumHelper.addToolMaterial("NIGHTMARE", nightmare_stats.harvestlevel, nightmare_stats.maxuses, nightmare_stats.efficiency, nightmare_stats.damage, nightmare_stats.enchantability);
/*      */     
/* 1413 */     toolEMERALD = EnumHelper.addToolMaterial("REALEMERALD", emerald_stats.harvestlevel, emerald_stats.maxuses, emerald_stats.efficiency, emerald_stats.damage, emerald_stats.enchantability);
/*      */     
/* 1415 */     toolRUBY = EnumHelper.addToolMaterial("RUBY", ruby_stats.harvestlevel, ruby_stats.maxuses, ruby_stats.efficiency, ruby_stats.damage, ruby_stats.enchantability);
/*      */     
/* 1417 */     toolAMETHYST = EnumHelper.addToolMaterial("AMETHYST", amethyst_stats.harvestlevel, amethyst_stats.maxuses, amethyst_stats.efficiency, amethyst_stats.damage, amethyst_stats.enchantability);
/*      */     
/* 1419 */     toolBERTHA = EnumHelper.addToolMaterial("BERTHA", bertha_stats.harvestlevel, bertha_stats.maxuses, bertha_stats.efficiency, bertha_stats.damage, bertha_stats.enchantability);
/*      */     
/* 1421 */     toolCRYSTALWOOD = EnumHelper.addToolMaterial("CRYSTALWOOD", crystalwood_stats.harvestlevel, crystalwood_stats.maxuses, crystalwood_stats.efficiency, crystalwood_stats.damage, crystalwood_stats.enchantability);
/*      */     
/* 1423 */     toolCRYSTALSTONE = EnumHelper.addToolMaterial("CRYSTALSTONE", crystalstone_stats.harvestlevel, crystalstone_stats.maxuses, crystalstone_stats.efficiency, crystalstone_stats.damage, crystalstone_stats.enchantability);
/*      */     
/* 1425 */     toolCRYSTALPINK = EnumHelper.addToolMaterial("CRYSTALPINK", crystalpink_stats.harvestlevel, crystalpink_stats.maxuses, crystalpink_stats.efficiency, crystalpink_stats.damage, crystalpink_stats.enchantability);
/*      */     
/* 1427 */     toolTIGERSEYE = EnumHelper.addToolMaterial("TIGERSEYE", tigerseye_stats.harvestlevel, tigerseye_stats.maxuses, tigerseye_stats.efficiency, tigerseye_stats.damage, tigerseye_stats.enchantability);
/*      */     
/* 1429 */     toolROYAL = EnumHelper.addToolMaterial("ROYAL", royal_stats.harvestlevel, royal_stats.maxuses, royal_stats.efficiency, royal_stats.damage, royal_stats.enchantability);
/*      */     
/* 1431 */     toolHAMMY = EnumHelper.addToolMaterial("HAMMY", hammy_stats.harvestlevel, hammy_stats.maxuses, hammy_stats.efficiency, hammy_stats.damage, hammy_stats.enchantability);
/*      */     
/* 1433 */     toolBATTLE = EnumHelper.addToolMaterial("BATTLE", battleaxe_stats.harvestlevel, battleaxe_stats.maxuses, battleaxe_stats.efficiency, battleaxe_stats.damage, battleaxe_stats.enchantability);
/*      */     
/* 1435 */     toolCHAINSAW = EnumHelper.addToolMaterial("CHAINSAW", chainsaw_stats.harvestlevel, chainsaw_stats.maxuses, chainsaw_stats.efficiency, chainsaw_stats.damage, chainsaw_stats.enchantability);
/*      */     
/* 1437 */     toolQUEENBATTLE = EnumHelper.addToolMaterial("QUEENBATTLE", queenbattleaxe_stats.harvestlevel, queenbattleaxe_stats.maxuses, queenbattleaxe_stats.efficiency, queenbattleaxe_stats.damage, queenbattleaxe_stats.enchantability);
/*      */ 
/*      */ 
/*      */     
/* 1441 */     MyUltimateSword = (new UltimateSword(BaseItemID + 302, toolULTIMATE)).setUnlocalizedName("ultimatesword");
/* 1442 */     MyUltimatePickaxe = (new UltimatePickaxe(BaseItemID + 305, toolULTIMATE)).setUnlocalizedName("ultimatepickaxe");
/* 1443 */     MyUltimatePickaxe.setHarvestLevel("pickaxe", ultimate_stats.harvestlevel);
/* 1444 */     MyUltimateShovel = (new UltimateShovel(BaseItemID + 306, toolULTIMATE)).setUnlocalizedName("ultimateshovel");
/* 1445 */     MyUltimateShovel.setHarvestLevel("shovel", ultimate_stats.harvestlevel);
/* 1446 */     MyUltimateHoe = (new UltimateHoe(BaseItemID + 307, toolULTIMATE)).setUnlocalizedName("ultimatehoe");
/* 1447 */     MyUltimateAxe = (new UltimateAxe(BaseItemID + 308, toolULTIMATE)).setUnlocalizedName("ultimateaxe");
/* 1448 */     MyUltimateAxe.setHarvestLevel("axe", ultimate_stats.harvestlevel);
/* 1449 */     MyNightmareSword = (new NightmareSword(BaseItemID + 326, toolNIGHTMARE)).setUnlocalizedName("nightmaresword");
/* 1450 */     MyBertha = (new Bertha(BaseItemID + 313, toolBERTHA)).setUnlocalizedName("berthasmall");
/* 1451 */     MySlice = (new Bertha(BaseItemID + 314, toolBERTHA)).setUnlocalizedName("slicesmall");
/* 1452 */     MyRoyal = (new Bertha(BaseItemID + 318, toolROYAL)).setUnlocalizedName("royalsmall");
/* 1453 */     MyHammy = (new Bertha(BaseItemID + 319, toolHAMMY)).setUnlocalizedName("hammysmall");
/* 1454 */     MyBattleAxe = (new UltimateSword(BaseItemID + 422, toolBATTLE)).setUnlocalizedName("battleaxesmall");
/* 1455 */     MyChainsaw = (new UltimateSword(BaseItemID + 447, toolCHAINSAW)).setUnlocalizedName("chainsawsmall");
/* 1456 */     MyQueenBattleAxe = (new UltimateSword(BaseItemID + 470, toolQUEENBATTLE)).setUnlocalizedName("queenbattleaxesmall");
/*      */     
/* 1458 */     MyEmeraldSword = (new EmeraldSword(BaseItemID + 280, toolEMERALD)).setUnlocalizedName("emeraldsword");
/* 1459 */     MyEmeraldPickaxe = (new EmeraldPickaxe(BaseItemID + 281, toolEMERALD)).setUnlocalizedName("emeraldpickaxe");
/* 1460 */     MyEmeraldShovel = (new EmeraldShovel(BaseItemID + 282, toolEMERALD)).setUnlocalizedName("emeraldshovel");
/* 1461 */     MyEmeraldHoe = (new EmeraldHoe(BaseItemID + 283, toolEMERALD)).setUnlocalizedName("emeraldhoe");
/* 1462 */     MyEmeraldAxe = (new EmeraldAxe(BaseItemID + 284, toolEMERALD)).setUnlocalizedName("emeraldaxe");
/* 1463 */     MyExperienceSword = (new ExperienceSword(BaseItemID + 289, toolEMERALD)).setUnlocalizedName("experiencesword");
/* 1464 */     MyPoisonSword = (new PoisonSword(BaseItemID + 241, toolEMERALD)).setUnlocalizedName("poisonsword");
/* 1465 */     MyRatSword = (new RatSword(BaseItemID + 256, toolEMERALD)).setUnlocalizedName("ratsword");
/* 1466 */     MyFairySword = (new FairySword(BaseItemID + 257, toolEMERALD)).setUnlocalizedName("fairysword");
/* 1467 */     MyMantisClaw = (new MantisClaw(BaseItemID + 315, toolEMERALD)).setUnlocalizedName("mantisclaw");
/* 1468 */     MyBigHammer = (new BigHammer(BaseItemID + 316, toolAMETHYST)).setUnlocalizedName("bighammer");
/* 1469 */     MyRubySword = (new RubySword(BaseItemID + 271, toolRUBY)).setUnlocalizedName("rubysword");
/* 1470 */     MyRubyPickaxe = (new RubyPickaxe(BaseItemID + 272, toolRUBY)).setUnlocalizedName("rubypickaxe");
/* 1471 */     MyRubyPickaxe.setHarvestLevel("pickaxe", ruby_stats.harvestlevel);
/* 1472 */     MyRubyShovel = (new RubyShovel(BaseItemID + 273, toolRUBY)).setUnlocalizedName("rubyshovel");
/* 1473 */     MyRubyShovel.setHarvestLevel("shovel", ruby_stats.harvestlevel);
/* 1474 */     MyRubyHoe = (new RubyHoe(BaseItemID + 274, toolRUBY)).setUnlocalizedName("rubyhoe");
/* 1475 */     MyRubyAxe = (new RubyAxe(BaseItemID + 275, toolRUBY)).setUnlocalizedName("rubyaxe");
/* 1476 */     MyRubyAxe.setHarvestLevel("axe", ruby_stats.harvestlevel);
/* 1477 */     MyAmethystSword = (new AmethystSword(BaseItemID + 261, toolAMETHYST)).setUnlocalizedName("amethystsword");
/* 1478 */     MyAmethystPickaxe = (new AmethystPickaxe(BaseItemID + 262, toolAMETHYST)).setUnlocalizedName("amethystpickaxe");
/* 1479 */     MyAmethystPickaxe.setHarvestLevel("pickaxe", amethyst_stats.harvestlevel);
/* 1480 */     MyAmethystShovel = (new AmethystShovel(BaseItemID + 263, toolAMETHYST)).setUnlocalizedName("amethystshovel");
/* 1481 */     MyAmethystShovel.setHarvestLevel("shovel", amethyst_stats.harvestlevel);
/* 1482 */     MyAmethystHoe = (new AmethystHoe(BaseItemID + 264, toolAMETHYST)).setUnlocalizedName("amethysthoe");
/* 1483 */     MyAmethystAxe = (new AmethystAxe(BaseItemID + 265, toolAMETHYST)).setUnlocalizedName("amethystaxe");
/* 1484 */     MyAmethystAxe.setHarvestLevel("axe", amethyst_stats.harvestlevel);
/* 1485 */     MyCrystalWoodSword = (new CrystalSword(BaseItemID + 329, toolCRYSTALWOOD)).setUnlocalizedName("crystalwoodsword");
/* 1486 */     MyCrystalWoodPickaxe = (new CrystalPickaxe(BaseItemID + 330, toolCRYSTALWOOD)).setUnlocalizedName("crystalwoodpickaxe");
/* 1487 */     MyCrystalWoodShovel = (new CrystalShovel(BaseItemID + 331, toolCRYSTALWOOD)).setUnlocalizedName("crystalwoodshovel");
/* 1488 */     MyCrystalWoodHoe = (new CrystalHoe(BaseItemID + 332, toolCRYSTALWOOD)).setUnlocalizedName("crystalwoodhoe");
/* 1489 */     MyCrystalWoodAxe = (new CrystalAxe(BaseItemID + 333, toolCRYSTALWOOD)).setUnlocalizedName("crystalwoodaxe");
/* 1490 */     MyCrystalPinkSword = (new CrystalSword(BaseItemID + 334, toolCRYSTALPINK)).setUnlocalizedName("crystalpinksword");
/* 1491 */     MyCrystalPinkPickaxe = (new CrystalPickaxe(BaseItemID + 335, toolCRYSTALPINK)).setUnlocalizedName("crystalpinkpickaxe");
/* 1492 */     MyCrystalPinkShovel = (new CrystalShovel(BaseItemID + 336, toolCRYSTALPINK)).setUnlocalizedName("crystalpinkshovel");
/* 1493 */     MyCrystalPinkHoe = (new CrystalHoe(BaseItemID + 337, toolCRYSTALPINK)).setUnlocalizedName("crystalpinkhoe");
/* 1494 */     MyCrystalPinkAxe = (new CrystalAxe(BaseItemID + 338, toolCRYSTALPINK)).setUnlocalizedName("crystalpinkaxe");
/* 1495 */     MyCrystalStoneSword = (new CrystalSword(BaseItemID + 339, toolCRYSTALSTONE)).setUnlocalizedName("crystalstonesword");
/* 1496 */     MyCrystalStonePickaxe = (new CrystalPickaxe(BaseItemID + 340, toolCRYSTALSTONE)).setUnlocalizedName("crystalstonepickaxe");
/* 1497 */     MyCrystalStoneShovel = (new CrystalShovel(BaseItemID + 341, toolCRYSTALSTONE)).setUnlocalizedName("crystalstoneshovel");
/* 1498 */     MyCrystalStoneHoe = (new CrystalHoe(BaseItemID + 342, toolCRYSTALSTONE)).setUnlocalizedName("crystalstonehoe");
/* 1499 */     MyCrystalStoneAxe = (new CrystalAxe(BaseItemID + 343, toolCRYSTALSTONE)).setUnlocalizedName("crystalstoneaxe");
/* 1500 */     MyTigersEyeSword = (new CrystalSword(BaseItemID + 349, toolTIGERSEYE)).setUnlocalizedName("tigerseye_sword");
/* 1501 */     MyTigersEyePickaxe = (new CrystalPickaxe(BaseItemID + 350, toolTIGERSEYE)).setUnlocalizedName("tigerseye_pickaxe");
/* 1502 */     MyTigersEyeShovel = (new CrystalShovel(BaseItemID + 351, toolTIGERSEYE)).setUnlocalizedName("tigerseye_shovel");
/* 1503 */     MyTigersEyeHoe = (new CrystalHoe(BaseItemID + 352, toolTIGERSEYE)).setUnlocalizedName("tigerseye_hoe");
/* 1504 */     MyTigersEyeAxe = (new CrystalAxe(BaseItemID + 353, toolTIGERSEYE)).setUnlocalizedName("tigerseye_axe");
/* 1505 */     MyRoseSword = (new EmeraldSword(BaseItemID + 484, toolEMERALD)).setUnlocalizedName("rosesword");
/*      */ 
/*      */     
/* 1508 */     MyItemShoes = (new ItemShoes(BaseItemID + 248, 2)).setUnlocalizedName("redheels");
/* 1509 */     MyItemShoes_1 = (new ItemShoes(BaseItemID + 249, 3)).setUnlocalizedName("blackheels");
/* 1510 */     MyItemShoes_2 = (new ItemShoes(BaseItemID + 250, 4)).setUnlocalizedName("slippers");
/* 1511 */     MyItemShoes_3 = (new ItemShoes(BaseItemID + 251, 5)).setUnlocalizedName("boots");
/* 1512 */     MyItemGameController = (new ItemShoes(BaseItemID + 259, 6)).setUnlocalizedName("gamecontroller");
/*      */     
/* 1514 */     MyUltimateBow = (new UltimateBow(BaseItemID + 303)).setUnlocalizedName("ultimatebow");
/* 1515 */     MySkateBow = (new SkateBow(BaseItemID + 373)).setUnlocalizedName("skatebow");
/*      */     
/* 1517 */     MyUltimateFishingRod = (new UltimateFishingRod(BaseItemID + 304)).setUnlocalizedName("ultimatefishingrod");
/* 1518 */     UltimateFishingRod = new ItemStack(MyUltimateFishingRod);
/*      */     
/* 1520 */     MyFireFish = (new ItemFireFish(BaseItemID + 175, 4, 0.6F, false)).setUnlocalizedName("firefish");
/* 1521 */     MySunFish = (new ItemSunFish(BaseItemID + 176, 6, 0.6F, false)).setUnlocalizedName("sunfish");
/* 1522 */     MyLavaEel = (new ItemLavaEel(BaseItemID + 157, 2, 0.6F, false)).setUnlocalizedName("lavaeel");
/* 1523 */     MyMothScale = (new ItemSalt(BaseItemID + 156)).setUnlocalizedName("mothscale");
/* 1524 */     MyQueenScale = (new ItemSalt(BaseItemID + 453)).setUnlocalizedName("queenscale");
/* 1525 */     MyNightmareScale = (new ItemSalt(BaseItemID + 158)).setUnlocalizedName("nightmarescale");
/* 1526 */     MyEmperorScorpionScale = (new ItemSalt(BaseItemID + 159)).setUnlocalizedName("emperorscorpionscale");
/* 1527 */     MyBasiliskScale = (new ItemSalt(BaseItemID + 160)).setUnlocalizedName("basiliskscale");
/* 1528 */     MyWaterDragonScale = (new ItemSalt(BaseItemID + 161)).setUnlocalizedName("waterdragonscale");
/* 1529 */     MyPeacockFeather = (new ItemSalt(BaseItemID + 255)).setUnlocalizedName("peacockfeather");
/* 1530 */     MyJumpyBugScale = (new ItemSalt(BaseItemID + 162)).setUnlocalizedName("jumpybugscale");
/* 1531 */     MyKrakenTooth = (new ItemSalt(BaseItemID + 163)).setUnlocalizedName("krakentooth");
/* 1532 */     MyGodzillaScale = (new ItemSalt(BaseItemID + 164)).setUnlocalizedName("godzillascale");
/* 1533 */     GreenGoo = (new ItemSalt(BaseItemID + 154)).setUnlocalizedName("greengoo");
/* 1534 */     SpiderRobotKit = (new ItemSpiderRobotKit(BaseItemID + 471)).setUnlocalizedName("spiderrobotkit");
/* 1535 */     AntRobotKit = (new ItemSpiderRobotKit(BaseItemID + 473)).setUnlocalizedName("antrobotkit");
/* 1536 */     ZooKeeper = (new ItemZooKeeper(BaseItemID + 230)).setUnlocalizedName("zookeeper");
/* 1537 */     CreeperLauncher = (new ItemCreeperLauncher(BaseItemID + 252)).setUnlocalizedName("creeperlauncher");
/* 1538 */     NetherLost = (new ItemNetherLost(BaseItemID + 253)).setUnlocalizedName("netherlost");
/* 1539 */     CrystalSticks = (new ItemCrystalSticks(BaseItemID + 254)).setUnlocalizedName("crystalsticks");
/* 1540 */     MySunspotUrchin = (new ItemSunspotUrchin(BaseItemID + 246)).setUnlocalizedName("sunspoturchin");
/* 1541 */     MySparkFish = (new ItemSparkFish(BaseItemID + 177, 1, 0.2F, false)).setUnlocalizedName("sparkfish");
/* 1542 */     MyWaterBall = (new ItemWaterBall(BaseItemID + 244)).setUnlocalizedName("waterball");
/* 1543 */     MyLaserBall = (new ItemLaserBall(BaseItemID + 242)).setUnlocalizedName("laserball");
/* 1544 */     MyIceBall = (new ItemIceBall(BaseItemID + 239)).setUnlocalizedName("iceball");
/* 1545 */     MySmallRock = (new ItemRock(BaseItemID + 436)).setUnlocalizedName("rocksmall");
/* 1546 */     MyRock = (new ItemRock(BaseItemID + 435)).setUnlocalizedName("rock");
/* 1547 */     MyRedRock = (new ItemRock(BaseItemID + 437)).setUnlocalizedName("rockred");
/* 1548 */     MyCrystalRedRock = (new ItemRock(BaseItemID + 443)).setUnlocalizedName("rockcrystalred");
/* 1549 */     MyCrystalGreenRock = (new ItemRock(BaseItemID + 444)).setUnlocalizedName("rockcrystalgreen");
/* 1550 */     MyCrystalBlueRock = (new ItemRock(BaseItemID + 445)).setUnlocalizedName("rockcrystalblue");
/* 1551 */     MyCrystalTNTRock = (new ItemRock(BaseItemID + 446)).setUnlocalizedName("rockcrystaltnt");
/* 1552 */     MyGreenRock = (new ItemRock(BaseItemID + 438)).setUnlocalizedName("rockgreen");
/* 1553 */     MyBlueRock = (new ItemRock(BaseItemID + 439)).setUnlocalizedName("rockblue");
/* 1554 */     MyPurpleRock = (new ItemRock(BaseItemID + 440)).setUnlocalizedName("rockpurple");
/* 1555 */     MySpikeyRock = (new ItemRock(BaseItemID + 441)).setUnlocalizedName("rockspikey");
/* 1556 */     MyTNTRock = (new ItemRock(BaseItemID + 442)).setUnlocalizedName("rocktnt");
/* 1557 */     MyRayGun = (new ItemRayGun(BaseItemID + 243)).setUnlocalizedName("RayGun");
/* 1558 */     MyThunderStaff = (new ItemThunderStaff(BaseItemID + 240)).setUnlocalizedName("thunderstaff");
/* 1559 */     MyWrench = (new ItemWrench(BaseItemID + 472)).setUnlocalizedName("wrench");
/* 1560 */     MyAcid = (new ItemAcid(BaseItemID + 247)).setUnlocalizedName("acid");
/* 1561 */     MyIrukandji = (new ItemIrukandji(BaseItemID + 258)).setUnlocalizedName("deadirukandji");
/* 1562 */     MyIrukandjiArrow = (new ItemIrukandjiArrow(BaseItemID + 372)).setUnlocalizedName("irukandjiarrow");
/* 1563 */     MyGreenFish = (new ItemGenericFish(BaseItemID + 191, 3, 0.5F, false)).setUnlocalizedName("greenfish");
/* 1564 */     MyBlueFish = (new ItemGenericFish(BaseItemID + 192, 4, 0.4F, false)).setUnlocalizedName("bluefish");
/* 1565 */     MyPinkFish = (new ItemGenericFish(BaseItemID + 193, 4, 0.6F, false)).setUnlocalizedName("pinkfish");
/* 1566 */     MyRockFish = (new ItemGenericFish(BaseItemID + 194, 3, 0.7F, false)).setUnlocalizedName("rockfish");
/* 1567 */     MyWoodFish = (new ItemGenericFish(BaseItemID + 195, 5, 0.7F, false)).setUnlocalizedName("woodfish");
/* 1568 */     MyGreyFish = (new ItemGenericFish(BaseItemID + 196, 5, 0.5F, false)).setUnlocalizedName("greyfish");
/* 1569 */     Sifter = (new ItemSifter(BaseItemID + 325)).setUnlocalizedName("sifter");
/* 1570 */     MySquidZooka = (new ItemSquidZooka(BaseItemID + 317)).setUnlocalizedName("squidzookasmall");
/*      */     
/* 1572 */     BerthaHandle = (new ItemSalt(BaseItemID + 406)).setUnlocalizedName("bbhandle");
/* 1573 */     BerthaGuard = (new ItemSalt(BaseItemID + 407)).setUnlocalizedName("bbguard");
/* 1574 */     BerthaBlade = (new ItemSalt(BaseItemID + 408)).setUnlocalizedName("bbblade");
/* 1575 */     MolenoidNose = (new ItemSalt(BaseItemID + 409)).setUnlocalizedName("molenoidnose");
/* 1576 */     SeaMonsterScale = (new ItemSalt(BaseItemID + 410)).setUnlocalizedName("seamonsterscale");
/* 1577 */     WormTooth = (new ItemSalt(BaseItemID + 411)).setUnlocalizedName("wormtooth");
/* 1578 */     TRexTooth = (new ItemSalt(BaseItemID + 412)).setUnlocalizedName("trextooth");
/* 1579 */     CaterKillerJaw = (new ItemSalt(BaseItemID + 413)).setUnlocalizedName("caterkillerjaw");
/* 1580 */     SeaViperTongue = (new ItemSalt(BaseItemID + 414)).setUnlocalizedName("seavipertongue");
/* 1581 */     VortexEye = (new ItemSalt(BaseItemID + 415)).setUnlocalizedName("vortexeye");
/*      */ 
/*      */ 
/*      */     
/* 1585 */     armorULTIMATE = EnumHelper.addArmorMaterial("ULTIMATE", Ultimate_armorstats.durability, new int[] { Ultimate_armorstats.head_protection, Ultimate_armorstats.chest_protection, Ultimate_armorstats.leg_protection, Ultimate_armorstats.boot_protection }, Ultimate_armorstats.enchantability);
/*      */ 
/*      */     
/* 1588 */     armorMOBZILLA = EnumHelper.addArmorMaterial("MOBZILLA", Mobzilla_armorstats.durability, new int[] { Mobzilla_armorstats.head_protection, Mobzilla_armorstats.chest_protection, Mobzilla_armorstats.leg_protection, Mobzilla_armorstats.boot_protection }, Mobzilla_armorstats.enchantability);
/*      */ 
/*      */     
/* 1591 */     armorLAVAEEL = EnumHelper.addArmorMaterial("LAVAEEL", LavaEel_armorstats.durability, new int[] { LavaEel_armorstats.head_protection, LavaEel_armorstats.chest_protection, LavaEel_armorstats.leg_protection, LavaEel_armorstats.boot_protection }, LavaEel_armorstats.enchantability);
/*      */ 
/*      */     
/* 1594 */     armorMOTHSCALE = EnumHelper.addArmorMaterial("MOTHSCALE", MothScale_armorstats.durability, new int[] { MothScale_armorstats.head_protection, MothScale_armorstats.chest_protection, MothScale_armorstats.leg_protection, MothScale_armorstats.boot_protection }, MothScale_armorstats.enchantability);
/*      */ 
/*      */     
/* 1597 */     armorEMERALD = EnumHelper.addArmorMaterial("EMERALD", Emerald_armorstats.durability, new int[] { Emerald_armorstats.head_protection, Emerald_armorstats.chest_protection, Emerald_armorstats.leg_protection, Emerald_armorstats.boot_protection }, Emerald_armorstats.enchantability);
/*      */ 
/*      */     
/* 1600 */     armorEXPERIENCE = EnumHelper.addArmorMaterial("EXPERIENCE", Experience_armorstats.durability, new int[] { Experience_armorstats.head_protection, Experience_armorstats.chest_protection, Experience_armorstats.leg_protection, Experience_armorstats.boot_protection }, Experience_armorstats.enchantability);
/*      */ 
/*      */     
/* 1603 */     armorRUBY = EnumHelper.addArmorMaterial("RUBY", Ruby_armorstats.durability, new int[] { Ruby_armorstats.head_protection, Ruby_armorstats.chest_protection, Ruby_armorstats.leg_protection, Ruby_armorstats.boot_protection }, Ruby_armorstats.enchantability);
/*      */ 
/*      */     
/* 1606 */     armorAMETHYST = EnumHelper.addArmorMaterial("AMETHYST", Amethyst_armorstats.durability, new int[] { Amethyst_armorstats.head_protection, Amethyst_armorstats.chest_protection, Amethyst_armorstats.leg_protection, Amethyst_armorstats.boot_protection }, Amethyst_armorstats.enchantability);
/*      */ 
/*      */     
/* 1609 */     armorPINK = EnumHelper.addArmorMaterial("PINK", Pink_armorstats.durability, new int[] { Pink_armorstats.head_protection, Pink_armorstats.chest_protection, Pink_armorstats.leg_protection, Pink_armorstats.boot_protection }, Pink_armorstats.enchantability);
/*      */ 
/*      */     
/* 1612 */     armorTIGERSEYE = EnumHelper.addArmorMaterial("TIGERSEYE", TigersEye_armorstats.durability, new int[] { TigersEye_armorstats.head_protection, TigersEye_armorstats.chest_protection, TigersEye_armorstats.leg_protection, TigersEye_armorstats.boot_protection }, TigersEye_armorstats.enchantability);
/*      */ 
/*      */     
/* 1615 */     armorPEACOCK = EnumHelper.addArmorMaterial("PEACOCK", Peacock_armorstats.durability, new int[] { Peacock_armorstats.head_protection, Peacock_armorstats.chest_protection, Peacock_armorstats.leg_protection, Peacock_armorstats.boot_protection }, Peacock_armorstats.enchantability);
/*      */ 
/*      */     
/* 1618 */     armorROYAL = EnumHelper.addArmorMaterial("ROYAL", Royal_armorstats.durability, new int[] { Royal_armorstats.head_protection, Royal_armorstats.chest_protection, Royal_armorstats.leg_protection, Royal_armorstats.boot_protection }, Royal_armorstats.enchantability);
/*      */ 
/*      */     
/* 1621 */     armorLAPIS = EnumHelper.addArmorMaterial("LAPIS", Lapis_armorstats.durability, new int[] { Lapis_armorstats.head_protection, Lapis_armorstats.chest_protection, Lapis_armorstats.leg_protection, Lapis_armorstats.boot_protection }, Lapis_armorstats.enchantability);
/*      */ 
/*      */     
/* 1624 */     armorQUEEN = EnumHelper.addArmorMaterial("QUEEN", Queen_armorstats.durability, new int[] { Queen_armorstats.head_protection, Queen_armorstats.chest_protection, Queen_armorstats.leg_protection, Queen_armorstats.boot_protection }, Queen_armorstats.enchantability);
/*      */ 
/*      */ 
/*      */     
/* 1628 */     UltimateHelmet = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 309, armorULTIMATE, proxy.setArmorPrefix("ultimate"), 0)).setUnlocalizedName("ultimate_helmet");
/* 1629 */     UltimateBody = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 310, armorULTIMATE, proxy.setArmorPrefix("ultimate"), 1)).setUnlocalizedName("ultimate_chest");
/* 1630 */     UltimateLegs = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 311, armorULTIMATE, proxy.setArmorPrefix("ultimate"), 2)).setUnlocalizedName("ultimate_leggings");
/* 1631 */     UltimateBoots = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 312, armorULTIMATE, proxy.setArmorPrefix("ultimate"), 3)).setUnlocalizedName("ultimate_boots");
/* 1632 */     LavaEelHelmet = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 298, armorLAVAEEL, proxy.setArmorPrefix("lavaeel"), 0)).setUnlocalizedName("lavaeel_helmet");
/* 1633 */     LavaEelBody = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 299, armorLAVAEEL, proxy.setArmorPrefix("lavaeel"), 1)).setUnlocalizedName("lavaeel_chest");
/* 1634 */     LavaEelLegs = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 300, armorLAVAEEL, proxy.setArmorPrefix("lavaeel"), 2)).setUnlocalizedName("lavaeel_leggings");
/* 1635 */     LavaEelBoots = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 301, armorLAVAEEL, proxy.setArmorPrefix("lavaeel"), 3)).setUnlocalizedName("lavaeel_boots");
/* 1636 */     MothScaleHelmet = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 294, armorMOTHSCALE, proxy.setArmorPrefix("mothscale"), 0)).setUnlocalizedName("mothscale_helmet");
/* 1637 */     MothScaleBody = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 295, armorMOTHSCALE, proxy.setArmorPrefix("mothscale"), 1)).setUnlocalizedName("mothscale_chest");
/* 1638 */     MothScaleLegs = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 296, armorMOTHSCALE, proxy.setArmorPrefix("mothscale"), 2)).setUnlocalizedName("mothscale_leggings");
/* 1639 */     MothScaleBoots = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 297, armorMOTHSCALE, proxy.setArmorPrefix("mothscale"), 3)).setUnlocalizedName("mothscale_boots");
/* 1640 */     EmeraldHelmet = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 285, armorEMERALD, proxy.setArmorPrefix("emerald"), 0)).setUnlocalizedName("emerald_helmet");
/* 1641 */     EmeraldBody = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 286, armorEMERALD, proxy.setArmorPrefix("emerald"), 1)).setUnlocalizedName("emerald_chest");
/* 1642 */     EmeraldLegs = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 287, armorEMERALD, proxy.setArmorPrefix("emerald"), 2)).setUnlocalizedName("emerald_leggings");
/* 1643 */     EmeraldBoots = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 288, armorEMERALD, proxy.setArmorPrefix("emerald"), 3)).setUnlocalizedName("emerald_boots");
/* 1644 */     ExperienceHelmet = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 290, armorEXPERIENCE, proxy.setArmorPrefix("experience"), 0)).setUnlocalizedName("experience_helmet");
/* 1645 */     ExperienceBody = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 291, armorEXPERIENCE, proxy.setArmorPrefix("experience"), 1)).setUnlocalizedName("experience_chest");
/* 1646 */     ExperienceLegs = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 292, armorEXPERIENCE, proxy.setArmorPrefix("experience"), 2)).setUnlocalizedName("experience_leggings");
/* 1647 */     ExperienceBoots = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 293, armorEXPERIENCE, proxy.setArmorPrefix("experience"), 3)).setUnlocalizedName("experience_boots");
/* 1648 */     RubyHelmet = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 276, armorRUBY, proxy.setArmorPrefix("ruby"), 0)).setUnlocalizedName("ruby_helmet");
/* 1649 */     RubyBody = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 277, armorRUBY, proxy.setArmorPrefix("ruby"), 1)).setUnlocalizedName("ruby_chest");
/* 1650 */     RubyLegs = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 278, armorRUBY, proxy.setArmorPrefix("ruby"), 2)).setUnlocalizedName("ruby_leggings");
/* 1651 */     RubyBoots = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 279, armorRUBY, proxy.setArmorPrefix("ruby"), 3)).setUnlocalizedName("ruby_boots");
/* 1652 */     AmethystHelmet = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 266, armorAMETHYST, proxy.setArmorPrefix("amethyst"), 0)).setUnlocalizedName("amethyst_helmet");
/* 1653 */     AmethystBody = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 267, armorAMETHYST, proxy.setArmorPrefix("amethyst"), 1)).setUnlocalizedName("amethyst_chest");
/* 1654 */     AmethystLegs = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 268, armorAMETHYST, proxy.setArmorPrefix("amethyst"), 2)).setUnlocalizedName("amethyst_leggings");
/* 1655 */     AmethystBoots = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 269, armorAMETHYST, proxy.setArmorPrefix("amethyst"), 3)).setUnlocalizedName("amethyst_boots");
/* 1656 */     CrystalPinkHelmet = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 344, armorPINK, proxy.setArmorPrefix("pink"), 0)).setUnlocalizedName("pink_helmet");
/* 1657 */     CrystalPinkBody = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 345, armorPINK, proxy.setArmorPrefix("pink"), 1)).setUnlocalizedName("pink_chest");
/* 1658 */     CrystalPinkLegs = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 346, armorPINK, proxy.setArmorPrefix("pink"), 2)).setUnlocalizedName("pink_leggings");
/* 1659 */     CrystalPinkBoots = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 347, armorPINK, proxy.setArmorPrefix("pink"), 3)).setUnlocalizedName("pink_boots");
/* 1660 */     TigersEyeHelmet = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 354, armorTIGERSEYE, proxy.setArmorPrefix("tigerseye"), 0)).setUnlocalizedName("tigerseye_helmet");
/* 1661 */     TigersEyeBody = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 355, armorTIGERSEYE, proxy.setArmorPrefix("tigerseye"), 1)).setUnlocalizedName("tigerseye_chest");
/* 1662 */     TigersEyeLegs = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 356, armorTIGERSEYE, proxy.setArmorPrefix("tigerseye"), 2)).setUnlocalizedName("tigerseye_leggings");
/* 1663 */     TigersEyeBoots = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 357, armorTIGERSEYE, proxy.setArmorPrefix("tigerseye"), 3)).setUnlocalizedName("tigerseye_boots");
/* 1664 */     PeacockFeatherBoots = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 371, armorPEACOCK, proxy.setArmorPrefix("peacock"), 3)).setUnlocalizedName("peacock_boots");
/* 1665 */     PeacockFeatherHelmet = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 359, armorPEACOCK, proxy.setArmorPrefix("peacock"), 0)).setUnlocalizedName("peacock_helmet");
/* 1666 */     PeacockFeatherBody = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 360, armorPEACOCK, proxy.setArmorPrefix("peacock"), 1)).setUnlocalizedName("peacock_chest");
/* 1667 */     PeacockFeatherLegs = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 370, armorPEACOCK, proxy.setArmorPrefix("peacock"), 2)).setUnlocalizedName("peacock_leggings");
/* 1668 */     MobzillaHelmet = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 395, armorMOBZILLA, proxy.setArmorPrefix("mobzilla"), 0)).setUnlocalizedName("mobzilla_helmet");
/* 1669 */     MobzillaBody = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 396, armorMOBZILLA, proxy.setArmorPrefix("mobzilla"), 1)).setUnlocalizedName("mobzilla_chest");
/* 1670 */     MobzillaLegs = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 397, armorMOBZILLA, proxy.setArmorPrefix("mobzilla"), 2)).setUnlocalizedName("mobzilla_leggings");
/* 1671 */     MobzillaBoots = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 398, armorMOBZILLA, proxy.setArmorPrefix("mobzilla"), 3)).setUnlocalizedName("mobzilla_boots");
/* 1672 */     RoyalHelmet = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 402, armorROYAL, proxy.setArmorPrefix("royal"), 0)).setUnlocalizedName("royal_helmet");
/* 1673 */     RoyalBody = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 403, armorROYAL, proxy.setArmorPrefix("royal"), 1)).setUnlocalizedName("royal_chest");
/* 1674 */     RoyalLegs = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 404, armorROYAL, proxy.setArmorPrefix("royal"), 2)).setUnlocalizedName("royal_leggings");
/* 1675 */     RoyalBoots = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 405, armorROYAL, proxy.setArmorPrefix("royal"), 3)).setUnlocalizedName("royal_boots");
/* 1676 */     LapisHelmet = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 449, armorLAPIS, proxy.setArmorPrefix("lapis"), 0)).setUnlocalizedName("lapis_helmet");
/* 1677 */     LapisBody = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 450, armorLAPIS, proxy.setArmorPrefix("lapis"), 1)).setUnlocalizedName("lapis_chest");
/* 1678 */     LapisLegs = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 451, armorLAPIS, proxy.setArmorPrefix("lapis"), 2)).setUnlocalizedName("lapis_leggings");
/* 1679 */     LapisBoots = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 452, armorLAPIS, proxy.setArmorPrefix("lapis"), 3)).setUnlocalizedName("lapis_boots");
/* 1680 */     QueenHelmet = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 454, armorQUEEN, proxy.setArmorPrefix("queen"), 0)).setUnlocalizedName("queen_helmet");
/* 1681 */     QueenBody = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 455, armorQUEEN, proxy.setArmorPrefix("queen"), 1)).setUnlocalizedName("queen_chest");
/* 1682 */     QueenLegs = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 456, armorQUEEN, proxy.setArmorPrefix("queen"), 2)).setUnlocalizedName("queen_leggings");
/* 1683 */     QueenBoots = (ItemOreSpawnArmor)(new ItemOreSpawnArmor(BaseItemID + 457, armorQUEEN, proxy.setArmorPrefix("queen"), 3)).setUnlocalizedName("queen_boots");
/*      */ 
/*      */ 
/*      */     
/* 1687 */     MyOreSaltBlock = (new OreSalt(BaseBlockID + 100)).setBlockName("oresalt");
/* 1688 */     MySalt = (new ItemSalt(BaseItemID + 178)).setUnlocalizedName("salt");
/* 1689 */     MyPopcorn = (new ItemPopcorn(BaseItemID + 179, 1, 0.5F, false)).setUnlocalizedName("popcorn");
/* 1690 */     MyButteredPopcorn = (new ItemPopcorn(BaseItemID + 180, 2, 0.6F, false)).setUnlocalizedName("popcorn_buttered");
/* 1691 */     MyButteredSaltedPopcorn = (new ItemPopcorn(BaseItemID + 181, 3, 0.75F, false)).setUnlocalizedName("popcorn_buttered_salted");
/* 1692 */     MyPopcornBag = (new ItemPopcorn(BaseItemID + 182, 10, 1.25F, false)).setUnlocalizedName("popcorn_bag");
/* 1693 */     MyButter = (new ItemPopcorn(BaseItemID + 183, 1, 0.5F, false)).setUnlocalizedName("butter");
/* 1694 */     MyCornDog = (new ItemPopcorn(BaseItemID + 186, 16, 2.5F, false)).setUnlocalizedName("corndog_cooked");
/* 1695 */     MyRawCornDog = (new ItemPopcorn(BaseItemID + 187, 4, 0.6F, false)).setUnlocalizedName("corndog_raw");
/* 1696 */     MyButterCandy = (new ItemSunFish(BaseItemID + 188, 4, 0.5F, false)).setUnlocalizedName("buttercandy");
/* 1697 */     MyBacon = (new ItemSunFish(BaseItemID + 189, 14, 1.5F, false)).setUnlocalizedName("cookedbacon");
/* 1698 */     MyRawBacon = (new ItemPopcorn(BaseItemID + 190, 8, 1.0F, false)).setUnlocalizedName("bacon");
/* 1699 */     MyCrabMeat = (new ItemSunFish(BaseItemID + 480, 6, 0.75F, false)).setUnlocalizedName("cookedcrabmeat");
/* 1700 */     MyRawCrabMeat = (new ItemPopcorn(BaseItemID + 479, 4, 0.25F, false)).setUnlocalizedName("crabmeat");
/* 1701 */     MyCheese = (new ItemPopcorn(BaseItemID + 205, 4, 0.5F, false)).setUnlocalizedName("cheese");
/* 1702 */     MySalad = (new ItemPopcorn(BaseItemID + 200, 10, 0.95F, false)).setUnlocalizedName("salad");
/* 1703 */     MyBLT = (new ItemPopcorn(BaseItemID + 201, 12, 0.95F, false)).setUnlocalizedName("blt_sandwich");
/* 1704 */     MyCrabbyPatty = (new ItemPopcorn(BaseItemID + 481, 16, 2.35F, false)).setUnlocalizedName("crabbypatty");
/* 1705 */     MyOreRubyBlock = (new OreRuby(BaseBlockID + 104)).setBlockName("oreruby");
/* 1706 */     MyRuby = (new ItemSalt(BaseItemID + 270)).setUnlocalizedName("ruby");
/* 1707 */     MyOreAmethystBlock = (new OreAmethyst(BaseBlockID + 103)).setBlockName("oreamethyst");
/* 1708 */     MyAmethyst = (new ItemSalt(BaseItemID + 260)).setUnlocalizedName("amethyst");
/* 1709 */     UraniumNugget = (new ItemSalt(BaseItemID + 150)).setUnlocalizedName("uranium_nugget");
/* 1710 */     TitaniumNugget = (new ItemSalt(BaseItemID + 151)).setUnlocalizedName("titanium_nugget");
/* 1711 */     CrystalStone = (new OreBasicStone(BaseBlockID + 200, 2.0F, 10.0F)).setBlockName("crystalstone");
/* 1712 */     CrystalCoal = (new OreCrystal(BaseBlockID + 201, 0.6F, 6.0F, 20.0F)).setBlockName("crystalcoal");
/* 1713 */     CrystalGrass = (new CrystalGrass(BaseBlockID + 202, 0.6F, 2.0F)).setBlockName("crystalgrass");
/* 1714 */     CrystalCrystal = (new OreCrystalCrystal(BaseBlockID + 209, 0.4F, 12.0F, 40.0F)).setBlockName("crystalcrystal");
/* 1715 */     TigersEye = (new OreCrystalCrystal(BaseBlockID + 217, 0.5F, 15.0F, 60.0F)).setBlockName("tigerseye");
/* 1716 */     CrystalPlanksBlock = (new CrystalWood(BaseBlockID + 210, 1.5F, 4.0F)).setBlockName("crystalplanks");
/* 1717 */     CrystalWorkbenchBlock = (new CrystalWorkbench(BaseBlockID + 211, 1.0F, 5.0F)).setBlockName("crystalworkbench");
/* 1718 */     CrystalFurnaceBlock = (CrystalFurnace)(new CrystalFurnace(BaseBlockID + 212, false, 2.0F, 10.0F)).setBlockName("crystalfurnace");
/* 1719 */     CrystalFurnaceOnBlock = (new CrystalFurnace(BaseBlockID + 213, true, 2.0F, 10.0F)).setBlockName("crystalfurnace");
/* 1720 */     MyPeacock = (new ItemPopcorn(BaseItemID + 207, 12, 1.4F, false)).setUnlocalizedName("cookedpeacock");
/* 1721 */     MyRawPeacock = (new ItemPopcorn(BaseItemID + 206, 6, 0.7F, false)).setUnlocalizedName("rawpeacock");
/* 1722 */     CrystalRat = (new OreBasicStone(BaseBlockID + 219, 2.5F, 14.0F)).setBlockName("crystalrat");
/* 1723 */     CrystalFairy = (new OreBasicStone(BaseBlockID + 220, 2.5F, 14.0F)).setBlockName("crystalfairy");
/* 1724 */     RedAntTroll = (new OreBasicStone(BaseBlockID + 225, 2.5F, 14.0F)).setBlockName("redanttroll");
/* 1725 */     TermiteTroll = (new OreBasicStone(BaseBlockID + 226, 2.5F, 14.0F)).setBlockName("termitetroll");
/*      */ 
/*      */     
/* 1728 */     MyRTPBlock = (new RTPBlock(BaseBlockID + 105)).setBlockName("blockteleport").setStepSound(Block.soundTypeStone);
/* 1729 */     MyStepUp = (new StepUp(BaseItemID + 232)).setUnlocalizedName("step_up");
/* 1730 */     MyStepDown = (new StepDown(BaseItemID + 233)).setUnlocalizedName("step_down");
/* 1731 */     MyStepAccross = (new StepAccross(BaseItemID + 234)).setUnlocalizedName("step_accross");
/* 1732 */     MyMoleDirtBlock = (new MoleDirtBlock(BaseBlockID + 123)).setHardness(0.6F).setBlockName("moledirt").setStepSound(new Block.SoundType("gravel", 1.0F, 1.0F));
/*      */ 
/*      */     
/* 1735 */     initializeCagesAndEggs();
/*      */ 
/*      */     
/* 1738 */     MyStrawberry = (new ItemStrawberry(BaseItemID + 184, 2, 0.65F, false)).setUnlocalizedName("strawberry");
/* 1739 */     MyStrawberryPlant = (Block)new BlockStrawberry(BaseBlockID + 153);
/* 1740 */     MyStrawberrySeed = (new ItemStrawberrySeed(BaseItemID + 210, MyStrawberryPlant, Blocks.farmland)).setUnlocalizedName("strawberry_seed");
/* 1741 */     MyButterflyPlant = (Block)new BlockButterflyPlant(BaseBlockID + 155);
/* 1742 */     MyButterflySeed = (new ItemButterflySeed(BaseItemID + 212, MyButterflyPlant, Blocks.farmland)).setUnlocalizedName("butterfly_seed");
/* 1743 */     MyMothPlant = (Block)new BlockMothPlant(BaseBlockID + 156);
/* 1744 */     MyMothSeed = (new ItemMothSeed(BaseItemID + 213, MyMothPlant, Blocks.farmland)).setUnlocalizedName("moth_seed");
/* 1745 */     MyMosquitoPlant = (Block)new BlockMosquitoPlant(BaseBlockID + 157);
/* 1746 */     MyMosquitoSeed = (new ItemMosquitoSeed(BaseItemID + 214, MyMosquitoPlant, Blocks.farmland)).setUnlocalizedName("mosquito_seed");
/* 1747 */     MyFireflyPlant = (Block)new BlockFireflyPlant(BaseBlockID + 154);
/* 1748 */     MyFireflySeed = (new ItemFireflySeed(BaseItemID + 215, MyFireflyPlant, Blocks.farmland)).setUnlocalizedName("firefly_seed");
/* 1749 */     MyRadishPlant = (Block)new BlockRadish(BaseBlockID + 175);
/* 1750 */     MyRadish = (new ItemRadish(BaseItemID + 199, 2, 0.45F, MyRadishPlant, Blocks.farmland)).setUnlocalizedName("radish");
/* 1751 */     MyCherry = (new ItemStrawberry(BaseItemID + 202, 3, 0.45F, false)).setUnlocalizedName("cherries");
/* 1752 */     MyPeach = (new ItemStrawberry(BaseItemID + 203, 4, 0.55F, false)).setUnlocalizedName("peach");
/* 1753 */     MyCrystalApple = (new ItemSunFish(BaseItemID + 208, 5, 0.85F, false)).setUnlocalizedName("crystalapple");
/* 1754 */     MyLove = (new ItemSunFish(BaseItemID + 485, 8, 0.95F, false)).setUnlocalizedName("heart");
/* 1755 */     MyRicePlant = (Block)new BlockRice(BaseBlockID + 178);
/* 1756 */     MyRice = (new ItemRadish(BaseItemID + 209, 5, 0.65F, MyRicePlant, CrystalGrass)).setUnlocalizedName("rice");
/*      */     
/* 1758 */     MyElevator = (new ItemElevator(BaseItemID + 235)).setUnlocalizedName("elevator");
/*      */     
/* 1760 */     MyCornPlant1 = (new BlockCorn(BaseBlockID + 163)).setBlockName("corn_0");
/* 1761 */     MyCornPlant2 = (new BlockCorn(BaseBlockID + 164)).setBlockName("corn_1");
/* 1762 */     MyCornPlant3 = (new BlockCorn(BaseBlockID + 165)).setBlockName("corn_2");
/* 1763 */     MyCornPlant4 = (new BlockCorn(BaseBlockID + 166)).setBlockName("corn_3");
/* 1764 */     MyCornCob = (new ItemCornCob(BaseItemID + 185, 6, 0.75F, MyCornPlant1, Blocks.farmland)).setUnlocalizedName("corn_seed");
/* 1765 */     MyQuinoaPlant1 = (new BlockQuinoa(BaseBlockID + 179)).setBlockName("quinoa_0");
/* 1766 */     MyQuinoaPlant2 = (new BlockQuinoa(BaseBlockID + 180)).setBlockName("quinoa_1");
/* 1767 */     MyQuinoaPlant3 = (new BlockQuinoa(BaseBlockID + 181)).setBlockName("quinoa_2");
/* 1768 */     MyQuinoaPlant4 = (new BlockQuinoa(BaseBlockID + 182)).setBlockName("quinoa_3");
/* 1769 */     MyQuinoa = (new ItemCornCob(BaseItemID + 224, 7, 0.85F, MyQuinoaPlant1, CrystalGrass)).setUnlocalizedName("quinoa");
/*      */     
/* 1771 */     MyTomatoPlant1 = (new BlockTomato(BaseBlockID + 167)).setBlockName("tomato_0");
/* 1772 */     MyTomatoPlant2 = (new BlockTomato(BaseBlockID + 168)).setBlockName("tomato_1");
/* 1773 */     MyTomatoPlant3 = (new BlockTomato(BaseBlockID + 169)).setBlockName("tomato_2");
/* 1774 */     MyTomatoPlant4 = (new BlockTomato(BaseBlockID + 170)).setBlockName("tomato_3");
/* 1775 */     MyTomato = (new ItemTomato(BaseItemID + 197, 4, 0.55F, MyTomatoPlant1, Blocks.farmland)).setUnlocalizedName("tomato_seed");
/* 1776 */     MyLettucePlant1 = (new BlockLettuce(BaseBlockID + 171)).setBlockName("lettuce_0");
/* 1777 */     MyLettucePlant2 = (new BlockLettuce(BaseBlockID + 172)).setBlockName("lettuce_1");
/* 1778 */     MyLettucePlant3 = (new BlockLettuce(BaseBlockID + 173)).setBlockName("lettuce_2");
/* 1779 */     MyLettucePlant4 = (new BlockLettuce(BaseBlockID + 174)).setBlockName("lettuce_3");
/* 1780 */     MyLettuce = (new ItemLettuce(BaseItemID + 198, 3, 0.45F, MyLettucePlant1, Blocks.farmland)).setUnlocalizedName("lettuce_seed");
/*      */     
/* 1782 */     MagicApple = (new ItemMagicApple(BaseItemID + 236)).setUnlocalizedName("magicapple");
/* 1783 */     MinersDream = (new ItemMinersDream(BaseItemID + 237)).setUnlocalizedName("minersdream");
/* 1784 */     ExtremeTorch = (new BlockExtremeTorch(BaseBlockID + 192)).setLightLevel(1.0F).setBlockName("extremetorch");
/* 1785 */     KrakenRepellent = (new KrakenRepellent(BaseBlockID + 190)).setLightLevel(0.8F).setBlockName("krakenrepellent");
/* 1786 */     MyIslandBlock = (new IslandBlock(BaseBlockID + 193)).setLightLevel(0.9F).setBlockName("island");
/* 1787 */     CreeperRepellent = (new CreeperRepellent(BaseBlockID + 191)).setLightLevel(0.8F).setBlockName("creeperrepellent");
/* 1788 */     ZooCage2 = (new ZooCage(BaseItemID + 320, 3)).setUnlocalizedName("zoo2");
/* 1789 */     ZooCage4 = (new ZooCage(BaseItemID + 321, 5)).setUnlocalizedName("zoo4");
/* 1790 */     ZooCage6 = (new ZooCage(BaseItemID + 322, 9)).setUnlocalizedName("zoo6");
/* 1791 */     ZooCage8 = (new ZooCage(BaseItemID + 323, 13)).setUnlocalizedName("zoo8");
/* 1792 */     ZooCage10 = (new ZooCage(BaseItemID + 324, 17)).setUnlocalizedName("zoo10");
/* 1793 */     InstantShelter = (new InstantShelter(BaseItemID + 327)).setUnlocalizedName("instantshelter");
/* 1794 */     InstantGarden = (new InstantGarden(BaseItemID + 328)).setUnlocalizedName("instantgarden");
/* 1795 */     CrystalTorch = (new BlockCrystalTorch(BaseBlockID + 214)).setLightLevel(0.99F).setBlockName("crystaltorch");
/* 1796 */     MyKingSpawnerBlock = (new KingSpawnerBlock(BaseBlockID + 195)).setLightLevel(0.9F).setBlockName("kingspawner");
/* 1797 */     MyQueenSpawnerBlock = (new QueenSpawnerBlock(BaseBlockID + 197)).setLightLevel(0.9F).setBlockName("queenspawner");
/* 1798 */     RandomDungeon = (new ItemRandomDungeon(BaseItemID + 421)).setUnlocalizedName("randomdungeon");
/* 1799 */     MyDungeonSpawnerBlock = (new DungeonSpawnerBlock(BaseBlockID + 196)).setLightLevel(0.9F).setBlockName("dungeonspawner");
/*      */ 
/*      */     
/* 1802 */     MyAppleLeaves = (new BlockAppleLeaves(BaseBlockID + 150)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("leaves_apple");
/* 1803 */     MyAppleSeed = (new ItemAppleSeed(BaseItemID + 211)).setUnlocalizedName("appletree_seed");
/* 1804 */     MySkyTreeLog = (new BlockSkyTreeLog(BaseBlockID + 113, 20)).setHardness(0.2F).setStepSound(Block.soundTypeWood).setBlockName("skytreelog");
/*      */ 
/*      */     
/* 1807 */     MyDT = (new BlockDuplicatorLog(BaseBlockID + 114)).setHardness(0.2F).setStepSound(Block.soundTypeWood).setBlockName("duplicatortreelog");
/* 1808 */     MyExperienceLeaves = (new BlockExperienceLeaves(BaseBlockID + 151)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("leaves_experience");
/* 1809 */     MyExperienceCatcher = (new ExperienceCatcher(BaseItemID + 238)).setUnlocalizedName("experiencecatcher");
/* 1810 */     MyExperienceTreeSeed = (new ItemExperienceTreeSeed(BaseItemID + 216)).setUnlocalizedName("experiencetree_seed");
/* 1811 */     MyExperiencePlant = (new BlockExperiencePlant(BaseBlockID + 158)).setBlockName("experiencesapling");
/* 1812 */     MyDeadStinkBug = (new ItemSalt(BaseItemID + 155)).setUnlocalizedName("deadstinkbug");
/* 1813 */     MyFlowerPinkBlock = (new MyBlockFlower(BaseBlockID + 159)).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("flower_pink");
/* 1814 */     MyFlowerBlueBlock = (new MyBlockFlower(BaseBlockID + 160)).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("flower_blue");
/* 1815 */     MyFlowerBlackBlock = (new MyBlockFlower(BaseBlockID + 161)).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("flower_black");
/* 1816 */     MyFlowerScaryBlock = (new MyBlockFlower(BaseBlockID + 162)).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("flower_scary");
/* 1817 */     MyScaryLeaves = (new BlockScaryLeaves(BaseBlockID + 152)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("leaves_scary");
/* 1818 */     MyCherryLeaves = (new BlockScaryLeaves(BaseBlockID + 176)).setHardness(0.15F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("leaves_cherry");
/* 1819 */     MyPeachLeaves = (new BlockScaryLeaves(BaseBlockID + 177)).setHardness(0.15F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("leaves_peach");
/* 1820 */     MyCherrySeed = (new ItemAppleSeed(BaseItemID + 217)).setUnlocalizedName("cherrytree_seed");
/* 1821 */     MyPeachSeed = (new ItemAppleSeed(BaseItemID + 218)).setUnlocalizedName("peachtree_seed");
/* 1822 */     CrystalFlowerRedBlock = (new MyBlockFlower(BaseBlockID + 203)).setHardness(0.0F).setStepSound(new Block.SoundType("grass", 1.0F, 1.0F)).setBlockName("crystalflower_red");
/* 1823 */     CrystalFlowerGreenBlock = (new MyBlockFlower(BaseBlockID + 204)).setHardness(0.0F).setStepSound(new Block.SoundType("grass", 1.0F, 1.0F)).setBlockName("crystalflower_green");
/* 1824 */     CrystalFlowerBlueBlock = (new MyBlockFlower(BaseBlockID + 205)).setHardness(0.0F).setStepSound(new Block.SoundType("grass", 1.0F, 1.0F)).setBlockName("crystalflower_blue");
/* 1825 */     CrystalFlowerYellowBlock = (new MyBlockFlower(BaseBlockID + 206)).setHardness(0.0F).setStepSound(new Block.SoundType("grass", 1.0F, 1.0F)).setBlockName("crystalflower_yellow");
/* 1826 */     MyCrystalLeaves = (new BlockCrystalLeaves(BaseBlockID + 208)).setHardness(0.2F).setLightOpacity(1).setStepSound(new Block.SoundType("grass", 1.0F, 1.0F)).setBlockName("crystaltreeleaves");
/* 1827 */     MyCrystalTreeLog = (new BlockCrystalTreeLog(BaseBlockID + 207, 20)).setHardness(0.2F).setStepSound(new Block.SoundType("wood", 1.0F, 1.0F)).setBlockName("crystaltreelog");
/* 1828 */     MyCrystalLeaves2 = (new BlockCrystalLeaves(BaseBlockID + 215)).setHardness(0.25F).setLightOpacity(1).setStepSound(new Block.SoundType("grass", 1.0F, 1.0F)).setBlockName("crystaltreeleaves2");
/* 1829 */     MyCrystalLeaves3 = (new BlockCrystalLeaves(BaseBlockID + 221)).setHardness(0.25F).setLightOpacity(1).setStepSound(new Block.SoundType("grass", 1.0F, 1.0F)).setBlockName("crystaltreeleaves3");
/* 1830 */     MyCrystalPlant = (new BlockCrystalPlant(BaseBlockID + 222)).setBlockName("crystalsapling");
/* 1831 */     MyCrystalPlant2 = (new BlockCrystalPlant(BaseBlockID + 223)).setBlockName("crystalsapling2");
/* 1832 */     MyCrystalPlant3 = (new BlockCrystalPlant(BaseBlockID + 224)).setBlockName("crystalsapling3");
/*      */     
/* 1834 */     MyEnderPearlBlock = (new OreGenericEgg(BaseBlockID + 111)).setBlockName("blockenderpearl");
/* 1835 */     MyEyeOfEnderBlock = (new OreGenericEgg(BaseBlockID + 112)).setBlockName("blockeyeofender");
/*      */ 
/*      */ 
/*      */     
/* 1839 */     make_some_more_things();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void make_some_more_things() {
/* 1845 */     GameRegistry.registerBlock(MySpiderSpawnBlock, "OreSpawn_SpiderSpawnBlock");
/* 1846 */     GameRegistry.registerBlock(MyBatSpawnBlock, "OreSpawn_BatSpawnBlock");
/* 1847 */     GameRegistry.registerBlock(MyCowSpawnBlock, "OreSpawn_CowSpawnBlock");
/* 1848 */     GameRegistry.registerBlock(MyPigSpawnBlock, "OreSpawn_PigSpawnBlock");
/* 1849 */     GameRegistry.registerBlock(MySquidSpawnBlock, "OreSpawn_SquidSpawnBlock");
/* 1850 */     GameRegistry.registerBlock(MyChickenSpawnBlock, "OreSpawn_ChickenSpawnBlock");
/* 1851 */     GameRegistry.registerBlock(MyCreeperSpawnBlock, "OreSpawn_CreeperSpawnBlock");
/* 1852 */     GameRegistry.registerBlock(MySkeletonSpawnBlock, "OreSpawn_SkeletonSpawnBlock");
/* 1853 */     GameRegistry.registerBlock(MyZombieSpawnBlock, "OreSpawn_ZombieSpawnBlock");
/* 1854 */     GameRegistry.registerBlock(MySlimeSpawnBlock, "OreSpawn_SlimeSpawnBlock");
/* 1855 */     GameRegistry.registerBlock(MyGhastSpawnBlock, "OreSpawn_GhastSpawnBlock");
/* 1856 */     GameRegistry.registerBlock(MyZombiePigmanSpawnBlock, "OreSpawn_ZombiePigmanSpawnBlock");
/* 1857 */     GameRegistry.registerBlock(MyEndermanSpawnBlock, "OreSpawn_EndermanSpawnBlock");
/* 1858 */     GameRegistry.registerBlock(MyCaveSpiderSpawnBlock, "OreSpawn_CaveSpiderSpawnBlock");
/* 1859 */     GameRegistry.registerBlock(MySilverfishSpawnBlock, "OreSpawn_SilverfishSpawnBlock");
/* 1860 */     GameRegistry.registerBlock(MyMagmaCubeSpawnBlock, "OreSpawn_MagmaCubeSpawnBlock");
/* 1861 */     GameRegistry.registerBlock(MyWitchSpawnBlock, "OreSpawn_WitchSpawnBlock");
/* 1862 */     GameRegistry.registerBlock(MySheepSpawnBlock, "OreSpawn_SheepSpawnBlock");
/* 1863 */     GameRegistry.registerBlock(MyWolfSpawnBlock, "OreSpawn_WolfSpawnBlock");
/* 1864 */     GameRegistry.registerBlock(MyMooshroomSpawnBlock, "OreSpawn_MooshroomSpawnBlock");
/* 1865 */     GameRegistry.registerBlock(MyWitherBossSpawnBlock, "OreSpawn_WitherBossSpawnBlock");
/* 1866 */     GameRegistry.registerBlock(MyGirlfriendSpawnBlock, "OreSpawn_GirlfriendSpawnBlock");
/* 1867 */     GameRegistry.registerBlock(MyBoyfriendSpawnBlock, "OreSpawn_BoyfriendSpawnBlock");
/* 1868 */     GameRegistry.registerBlock(MyRedCowSpawnBlock, "OreSpawn_RedCowSpawnBlock");
/* 1869 */     GameRegistry.registerBlock(MyCrystalCowSpawnBlock, "OreSpawn_CrystalCowSpawnBlock");
/* 1870 */     GameRegistry.registerBlock(MyVillagerSpawnBlock, "OreSpawn_VillagerSpawnBlock");
/* 1871 */     GameRegistry.registerBlock(MyGoldCowSpawnBlock, "OreSpawn_GoldCowSpawnBlock");
/* 1872 */     GameRegistry.registerBlock(MyEnchantedCowSpawnBlock, "OreSpawn_EnchantedCowSpawnBlock");
/* 1873 */     GameRegistry.registerBlock(MyMOTHRASpawnBlock, "OreSpawn_MOTHRASpawnBlock");
/* 1874 */     GameRegistry.registerBlock(MyAloSpawnBlock, "OreSpawn_AloSpawnBlock");
/* 1875 */     GameRegistry.registerBlock(MyCryoSpawnBlock, "OreSpawn_CryoSpawnBlock");
/* 1876 */     GameRegistry.registerBlock(MyCamaSpawnBlock, "OreSpawn_CamaSpawnBlock");
/* 1877 */     GameRegistry.registerBlock(MyVeloSpawnBlock, "OreSpawn_VeloSpawnBlock");
/* 1878 */     GameRegistry.registerBlock(MyHydroSpawnBlock, "OreSpawn_HydroSpawnBlock");
/* 1879 */     GameRegistry.registerBlock(MyBasilSpawnBlock, "OreSpawn_BasilSpawnBlock");
/* 1880 */     GameRegistry.registerBlock(MyDragonflySpawnBlock, "OreSpawn_DragonflySpawnBlock");
/* 1881 */     GameRegistry.registerBlock(MyEmperorScorpionSpawnBlock, "OreSpawn_EmperorScorpionSpawnBlock");
/* 1882 */     GameRegistry.registerBlock(MyScorpionSpawnBlock, "OreSpawn_ScorpionSpawnBlock");
/* 1883 */     GameRegistry.registerBlock(MyCaveFisherSpawnBlock, "OreSpawn_CaveFisherSpawnBlock");
/* 1884 */     GameRegistry.registerBlock(MySpyroSpawnBlock, "OreSpawn_SpyroSpawnBlock");
/* 1885 */     GameRegistry.registerBlock(MyBaryonyxSpawnBlock, "OreSpawn_BaryonyxSpawnBlock");
/* 1886 */     GameRegistry.registerBlock(MyGammaMetroidSpawnBlock, "OreSpawn_GammaMetroidSpawnBlock");
/* 1887 */     GameRegistry.registerBlock(MyCockateilSpawnBlock, "OreSpawn_CockateilSpawnBlock");
/* 1888 */     GameRegistry.registerBlock(MyKyuubiSpawnBlock, "OreSpawn_KyuubiSpawnBlock");
/* 1889 */     GameRegistry.registerBlock(MyAlienSpawnBlock, "OreSpawn_AlienSpawnBlock");
/* 1890 */     GameRegistry.registerBlock(MyIronGolemSpawnBlock, "OreSpawn_IronGolemSpawnBlock");
/* 1891 */     GameRegistry.registerBlock(MySnowGolemSpawnBlock, "OreSpawn_SnowGolemSpawnBlock");
/* 1892 */     GameRegistry.registerBlock(MyEnderDragonSpawnBlock, "OreSpawn_EnderDragonSpawnBlock");
/* 1893 */     GameRegistry.registerBlock(MyOcelotSpawnBlock, "OreSpawn_OcelotSpawnBlock");
/* 1894 */     GameRegistry.registerBlock(MyWitherSkeletonSpawnBlock, "OreSpawn_WitherSkeletonSpawnBlock");
/* 1895 */     GameRegistry.registerBlock(MyBlazeSpawnBlock, "OreSpawn_BlazeSpawnBlock");
/* 1896 */     GameRegistry.registerBlock(MyAttackSquidSpawnBlock, "OreSpawn_AttackSquidSpawnBlock");
/* 1897 */     GameRegistry.registerBlock(MyWaterDragonSpawnBlock, "OreSpawn_WaterDragonSpawnBlock");
/* 1898 */     GameRegistry.registerBlock(MyCephadromeSpawnBlock, "OreSpawn_CephadromeSpawnBlock");
/* 1899 */     GameRegistry.registerBlock(MyKrakenSpawnBlock, "OreSpawn_KrakenSpawnBlock");
/* 1900 */     GameRegistry.registerBlock(MyLizardSpawnBlock, "OreSpawn_LizardSpawnBlock");
/* 1901 */     GameRegistry.registerBlock(MyDragonSpawnBlock, "OreSpawn_DragonSpawnBlock");
/* 1902 */     GameRegistry.registerBlock(MyBeeSpawnBlock, "OreSpawn_BeeSpawnBlock");
/* 1903 */     GameRegistry.registerBlock(MyHorseSpawnBlock, "OreSpawn_HorseSpawnBlock");
/* 1904 */     GameRegistry.registerBlock(MyTrooperBugSpawnBlock, "OreSpawn_TrooperBugSpawnBlock");
/* 1905 */     GameRegistry.registerBlock(MySpitBugSpawnBlock, "OreSpawn_SpitBugSpawnBlock");
/* 1906 */     GameRegistry.registerBlock(MyStinkBugSpawnBlock, "OreSpawn_StinkBugSpawnBlock");
/* 1907 */     GameRegistry.registerBlock(MyOstrichSpawnBlock, "OreSpawn_OstrichSpawnBlock");
/* 1908 */     GameRegistry.registerBlock(MyGazelleSpawnBlock, "OreSpawn_GazelleSpawnBlock");
/* 1909 */     GameRegistry.registerBlock(MyChipmunkSpawnBlock, "OreSpawn_ChipmunkSpawnBlock");
/* 1910 */     GameRegistry.registerBlock(MyCreepingHorrorSpawnBlock, "OreSpawn_CreepingHorrorSpawnBlock");
/* 1911 */     GameRegistry.registerBlock(MyTerribleTerrorSpawnBlock, "OreSpawn_TerribleTerrorSpawnBlock");
/* 1912 */     GameRegistry.registerBlock(MyCliffRacerSpawnBlock, "OreSpawn_CliffRacerSpawnBlock");
/* 1913 */     GameRegistry.registerBlock(MyTriffidSpawnBlock, "OreSpawn_TriffidSpawnBlock");
/* 1914 */     GameRegistry.registerBlock(MyPitchBlackSpawnBlock, "OreSpawn_PitchBlackSpawnBlock");
/* 1915 */     GameRegistry.registerBlock(MyLurkingTerrorSpawnBlock, "OreSpawn_LurkingTerrorSpawnBlock");
/* 1916 */     GameRegistry.registerBlock(MyGodzillaPartSpawnBlock, "OreSpawn_GodzillaPartSpawnBlock");
/* 1917 */     GameRegistry.registerBlock(MyGodzillaSpawnBlock, "OreSpawn_GodzillaSpawnBlock");
/* 1918 */     GameRegistry.registerBlock(MyTheKingPartSpawnBlock, "OreSpawn_TheKingPartSpawnBlock");
/* 1919 */     GameRegistry.registerBlock(MyTheKingSpawnBlock, "OreSpawn_TheKingSpawnBlock");
/* 1920 */     GameRegistry.registerBlock(MyTheQueenPartSpawnBlock, "OreSpawn_TheQueenPartSpawnBlock");
/* 1921 */     GameRegistry.registerBlock(MyTheQueenSpawnBlock, "OreSpawn_TheQueenSpawnBlock");
/* 1922 */     GameRegistry.registerBlock(MySmallWormSpawnBlock, "OreSpawn_SmallWormSpawnBlock");
/* 1923 */     GameRegistry.registerBlock(MyMediumWormSpawnBlock, "OreSpawn_MediumWormSpawnBlock");
/* 1924 */     GameRegistry.registerBlock(MyLargeWormSpawnBlock, "OreSpawn_LargeWormSpawnBlock");
/* 1925 */     GameRegistry.registerBlock(MyCassowarySpawnBlock, "OreSpawn_CassowarySpawnBlock");
/* 1926 */     GameRegistry.registerBlock(MyCloudSharkSpawnBlock, "OreSpawn_CloudSharkSpawnBlock");
/* 1927 */     GameRegistry.registerBlock(MyGoldFishSpawnBlock, "OreSpawn_GoldFishSpawnBlock");
/* 1928 */     GameRegistry.registerBlock(MyLeafMonsterSpawnBlock, "OreSpawn_LeafMonsterSpawnBlock");
/* 1929 */     GameRegistry.registerBlock(MyTshirtSpawnBlock, "OreSpawn_TshirtSpawnBlock");
/* 1930 */     GameRegistry.registerBlock(MyEnderKnightSpawnBlock, "OreSpawn_EnderKnightSpawnBlock");
/* 1931 */     GameRegistry.registerBlock(MyEnderReaperSpawnBlock, "OreSpawn_EnderReaperSpawnBlock");
/* 1932 */     GameRegistry.registerBlock(MyBeaverSpawnBlock, "OreSpawn_BeaverSpawnBlock");
/* 1933 */     GameRegistry.registerBlock(MyUrchinSpawnBlock, "OreSpawn_UrchinSpawnBlock");
/* 1934 */     GameRegistry.registerBlock(MyFlounderSpawnBlock, "OreSpawn_FlounderSpawnBlock");
/* 1935 */     GameRegistry.registerBlock(MySkateSpawnBlock, "OreSpawn_SkateSpawnBlock");
/* 1936 */     GameRegistry.registerBlock(MyRotatorSpawnBlock, "OreSpawn_RotatorSpawnBlock");
/* 1937 */     GameRegistry.registerBlock(MyPeacockSpawnBlock, "OreSpawn_PeacockSpawnBlock");
/* 1938 */     GameRegistry.registerBlock(MyFairySpawnBlock, "OreSpawn_FairySpawnBlock");
/* 1939 */     GameRegistry.registerBlock(MyDungeonBeastSpawnBlock, "OreSpawn_DungeonBeastSpawnBlock");
/* 1940 */     GameRegistry.registerBlock(MyVortexSpawnBlock, "OreSpawn_VortexSpawnBlock");
/* 1941 */     GameRegistry.registerBlock(MyRatSpawnBlock, "OreSpawn_RatSpawnBlock");
/* 1942 */     GameRegistry.registerBlock(MyWhaleSpawnBlock, "OreSpawn_WhaleSpawnBlock");
/* 1943 */     GameRegistry.registerBlock(MyIrukandjiSpawnBlock, "OreSpawn_IrukandjiSpawnBlock");
/* 1944 */     GameRegistry.registerBlock(MyTRexSpawnBlock, "OreSpawn_TRexSpawnBlock");
/* 1945 */     GameRegistry.registerBlock(MyHerculesSpawnBlock, "OreSpawn_HerculesSpawnBlock");
/* 1946 */     GameRegistry.registerBlock(MyMantisSpawnBlock, "OreSpawn_MantisSpawnBlock");
/* 1947 */     GameRegistry.registerBlock(MyStinkySpawnBlock, "OreSpawn_StinkySpawnBlock");
/* 1948 */     GameRegistry.registerBlock(MyEasterBunnySpawnBlock, "OreSpawn_EasterBunnySpawnBlock");
/* 1949 */     GameRegistry.registerBlock(MyCaterKillerSpawnBlock, "OreSpawn_CaterKillerSpawnBlock");
/* 1950 */     GameRegistry.registerBlock(MyMolenoidSpawnBlock, "OreSpawn_MolenoidSpawnBlock");
/* 1951 */     GameRegistry.registerBlock(MySeaMonsterSpawnBlock, "OreSpawn_SeaMonsterSpawnBlock");
/* 1952 */     GameRegistry.registerBlock(MySeaViperSpawnBlock, "OreSpawn_SeaViperSpawnBlock");
/* 1953 */     GameRegistry.registerBlock(MyLeonSpawnBlock, "OreSpawn_LeonSpawnBlock");
/* 1954 */     GameRegistry.registerBlock(MyHammerheadSpawnBlock, "OreSpawn_HammerheadSpawnBlock");
/* 1955 */     GameRegistry.registerBlock(MyRubberDuckySpawnBlock, "OreSpawn_RubberDuckySpawnBlock");
/* 1956 */     GameRegistry.registerBlock(MyCriminalSpawnBlock, "OreSpawn_CriminalSpawnBlock");
/* 1957 */     GameRegistry.registerBlock(MyBrutalflySpawnBlock, "OreSpawn_BrutalflySpawnBlock");
/* 1958 */     GameRegistry.registerBlock(MyNastysaurusSpawnBlock, "OreSpawn_NastysaurusSpawnBlock");
/* 1959 */     GameRegistry.registerBlock(MyPointysaurusSpawnBlock, "OreSpawn_PointysaurusSpawnBlock");
/* 1960 */     GameRegistry.registerBlock(MyCricketSpawnBlock, "OreSpawn_CricketSpawnBlock");
/* 1961 */     GameRegistry.registerBlock(MyFrogSpawnBlock, "OreSpawn_FrogSpawnBlock");
/* 1962 */     GameRegistry.registerBlock(MySpiderDriverSpawnBlock, "OreSpawn_SpiderDriverSpawnBlock");
/* 1963 */     GameRegistry.registerBlock(MyCrabSpawnBlock, "OreSpawn_CrabSpawnBlock");
/*      */     
/* 1965 */     GameRegistry.registerBlock(MyOreSaltBlock, "OreSpawn_OreSaltBlock");
/* 1966 */     GameRegistry.registerBlock(MyRTPBlock, "OreSpawn_RTPBlock");
/* 1967 */     GameRegistry.registerBlock(MyMoleDirtBlock, "OreSpawn_MoleDirtBlock");
/* 1968 */     GameRegistry.registerBlock(MyOreTitaniumBlock, "OreSpawn_OreTitaniumBlock");
/* 1969 */     GameRegistry.registerBlock(MyOreUraniumBlock, "OreSpawn_OreUraniumBlock");
/* 1970 */     GameRegistry.registerBlock(MyBlockTitaniumBlock, "OreSpawn_BlockTitaniumBlock");
/* 1971 */     GameRegistry.registerBlock(MyBlockMobzillaScaleBlock, "OreSpawn_BlockMobzillaScaleBlock");
/* 1972 */     GameRegistry.registerBlock(MyBlockUraniumBlock, "OreSpawn_BlockUraniumBlock");
/* 1973 */     GameRegistry.registerBlock(MyLavafoamBlock, "OreSpawn_LavafoamBlock");
/* 1974 */     GameRegistry.registerBlock(MyOreRubyBlock, "OreSpawn_OreRubyBlock");
/* 1975 */     GameRegistry.registerBlock(MyBlockRubyBlock, "OreSpawn_BlockRubyBlock");
/* 1976 */     GameRegistry.registerBlock(MyOreAmethystBlock, "OreSpawn_OreAmethystBlock");
/* 1977 */     GameRegistry.registerBlock(MyBlockAmethystBlock, "OreSpawn_BlockAmethystBlock");
/* 1978 */     GameRegistry.registerBlock(MyCrystalPinkBlock, "OreSpawn_CrystalPinkBlock");
/* 1979 */     GameRegistry.registerBlock(MyTigersEyeBlock, "OreSpawn_TigersEyeBlock");
/* 1980 */     GameRegistry.registerBlock(MyPizzaBlock, "OreSpawn_PizzaBlock");
/* 1981 */     GameRegistry.registerItem(MyPizzaItem, "OreSpawn_PizzaItem");
/* 1982 */     GameRegistry.registerBlock(MyDuctTapeBlock, "OreSpawn_DuctTapeBlock");
/* 1983 */     GameRegistry.registerItem(MyDuctTapeItem, "OreSpawn_DuctTapeItem");
/* 1984 */     GameRegistry.registerBlock(CrystalStone, "OreSpawn_OreCrystalStoneBlock");
/* 1985 */     GameRegistry.registerBlock(CrystalRat, "OreSpawn_OreCrystalRatBlock");
/* 1986 */     GameRegistry.registerBlock(RedAntTroll, "OreSpawn_OreRedAntTrollBlock");
/* 1987 */     GameRegistry.registerBlock(TermiteTroll, "OreSpawn_OreTermiteTrollBlock");
/* 1988 */     GameRegistry.registerBlock(CrystalFairy, "OreSpawn_OreCrystalFairyBlock");
/* 1989 */     GameRegistry.registerBlock(CrystalCoal, "OreSpawn_OreCrystalCoalBlock");
/* 1990 */     GameRegistry.registerBlock(CrystalGrass, "OreSpawn_OreCrystalGrassBlock");
/* 1991 */     GameRegistry.registerBlock(CrystalCrystal, "OreSpawn_OreCrystalCrystalBlock");
/* 1992 */     GameRegistry.registerBlock(TigersEye, "OreSpawn_OreTigersEyeBlock");
/* 1993 */     GameRegistry.registerBlock(CrystalPlanksBlock, "OreSpawn_CrystalPlanksBlock");
/* 1994 */     GameRegistry.registerBlock(CrystalWorkbenchBlock, "OreSpawn_CrystalWorkbenchBlock");
/* 1995 */     GameRegistry.registerBlock((Block)CrystalFurnaceBlock, "OreSpawn_CrystalFurnaceBlock");
/* 1996 */     GameRegistry.registerBlock(CrystalFurnaceOnBlock, "OreSpawn_CrystalFurnaceOnBlock");
/*      */     
/* 1998 */     GameRegistry.registerBlock(MyStrawberryPlant, "OreSpawn_StrawberryPlant");
/* 1999 */     GameRegistry.registerBlock(MyRadishPlant, "OreSpawn_RadishPlant");
/* 2000 */     GameRegistry.registerBlock(MyRicePlant, "OreSpawn_RicePlant");
/* 2001 */     GameRegistry.registerBlock(MyButterflyPlant, "OreSpawn_ButterflyPlant");
/* 2002 */     GameRegistry.registerBlock(MyMothPlant, "OreSpawn_MothPlant");
/* 2003 */     GameRegistry.registerBlock(MyMosquitoPlant, "OreSpawn_MosquitoPlant");
/* 2004 */     GameRegistry.registerBlock(MyFireflyPlant, "OreSpawn_FireflyPlant");
/* 2005 */     GameRegistry.registerBlock(MyCornPlant1, "OreSpawn_CornPlant1");
/* 2006 */     GameRegistry.registerBlock(MyCornPlant2, "OreSpawn_CornPlant2");
/* 2007 */     GameRegistry.registerBlock(MyCornPlant3, "OreSpawn_CornPlant3");
/* 2008 */     GameRegistry.registerBlock(MyCornPlant4, "OreSpawn_CornPlant4");
/* 2009 */     GameRegistry.registerBlock(MyQuinoaPlant1, "OreSpawn_QuinoaPlant1");
/* 2010 */     GameRegistry.registerBlock(MyQuinoaPlant2, "OreSpawn_QuinoaPlant2");
/* 2011 */     GameRegistry.registerBlock(MyQuinoaPlant3, "OreSpawn_QuinoaPlant3");
/* 2012 */     GameRegistry.registerBlock(MyQuinoaPlant4, "OreSpawn_QuinoaPlant4");
/* 2013 */     GameRegistry.registerBlock(MyTomatoPlant1, "OreSpawn_TomatoPlant1");
/* 2014 */     GameRegistry.registerBlock(MyTomatoPlant2, "OreSpawn_TomatoPlant2");
/* 2015 */     GameRegistry.registerBlock(MyTomatoPlant3, "OreSpawn_TomatoPlant3");
/* 2016 */     GameRegistry.registerBlock(MyTomatoPlant4, "OreSpawn_TomatoPlant4");
/* 2017 */     GameRegistry.registerBlock(MyLettucePlant1, "OreSpawn_LettucePlant1");
/* 2018 */     GameRegistry.registerBlock(MyLettucePlant2, "OreSpawn_LettucePlant2");
/* 2019 */     GameRegistry.registerBlock(MyLettucePlant3, "OreSpawn_LettucePlant3");
/* 2020 */     GameRegistry.registerBlock(MyLettucePlant4, "OreSpawn_LettucePlant4");
/* 2021 */     GameRegistry.registerBlock(MyAppleLeaves, "OreSpawn_AppleLeaves");
/* 2022 */     GameRegistry.registerBlock(MyExperienceLeaves, "OreSpawn_ExperienceLeaves");
/* 2023 */     GameRegistry.registerBlock(MyScaryLeaves, "OreSpawn_ScaryLeaves");
/* 2024 */     GameRegistry.registerBlock(MyCherryLeaves, "OreSpawn_CherryLeaves");
/* 2025 */     GameRegistry.registerBlock(MyPeachLeaves, "OreSpawn_PeachLeaves");
/* 2026 */     GameRegistry.registerBlock(MySkyTreeLog, "OreSpawn_SkyTreeLog");
/* 2027 */     GameRegistry.registerBlock(MyDT, "OreSpawn_DuplicatorLog");
/* 2028 */     GameRegistry.registerBlock(MyExperiencePlant, "OreSpawn_ExperiencePlant");
/* 2029 */     GameRegistry.registerBlock(MyCrystalPlant, "OreSpawn_CrystalPlant");
/* 2030 */     GameRegistry.registerBlock(MyCrystalPlant2, "OreSpawn_CrystalPlant2");
/* 2031 */     GameRegistry.registerBlock(MyCrystalPlant3, "OreSpawn_CrystalPlant3");
/* 2032 */     GameRegistry.registerBlock(MyFlowerPinkBlock, "OreSpawn_FlowerPink");
/* 2033 */     GameRegistry.registerBlock(MyFlowerBlueBlock, "OreSpawn_FlowerBlue");
/* 2034 */     GameRegistry.registerBlock(MyFlowerBlackBlock, "OreSpawn_FlowerBlack");
/* 2035 */     GameRegistry.registerBlock(MyFlowerScaryBlock, "OreSpawn_FlowerScary");
/* 2036 */     GameRegistry.registerBlock(CrystalFlowerRedBlock, "OreSpawn_CrystalFlowerRed");
/* 2037 */     GameRegistry.registerBlock(CrystalFlowerGreenBlock, "OreSpawn_CrystalFlowerGreen");
/* 2038 */     GameRegistry.registerBlock(CrystalFlowerBlueBlock, "OreSpawn_CrystalFlowerBlue");
/* 2039 */     GameRegistry.registerBlock(CrystalFlowerYellowBlock, "OreSpawn_CrystalFlowerYellow");
/* 2040 */     GameRegistry.registerBlock(MyCrystalLeaves, "OreSpawn_CrystalLeaves");
/* 2041 */     GameRegistry.registerBlock(MyCrystalLeaves2, "OreSpawn_CrystalLeaves2");
/* 2042 */     GameRegistry.registerBlock(MyCrystalLeaves3, "OreSpawn_CrystalLeaves3");
/* 2043 */     GameRegistry.registerBlock(MyCrystalTreeLog, "OreSpawn_CrystalTreeLog");
/*      */     
/* 2045 */     GameRegistry.registerBlock(ExtremeTorch, "OreSpawn_ExtremeTorch");
/* 2046 */     GameRegistry.registerBlock(CrystalTorch, "OreSpawn_CrystalTorch");
/* 2047 */     GameRegistry.registerBlock(KrakenRepellent, "OreSpawn_KrakenRepellent");
/* 2048 */     GameRegistry.registerBlock(CreeperRepellent, "OreSpawn_CreeperRepellent");
/* 2049 */     GameRegistry.registerBlock(MyIslandBlock, "OreSpawn_Island");
/* 2050 */     GameRegistry.registerBlock(MyKingSpawnerBlock, "OreSpawn_KingSpawner");
/* 2051 */     GameRegistry.registerBlock(MyQueenSpawnerBlock, "OreSpawn_QueenSpawner");
/* 2052 */     GameRegistry.registerBlock(MyDungeonSpawnerBlock, "OreSpawn_DungeonSpawner");
/*      */     
/* 2054 */     GameRegistry.registerBlock(MyEnderPearlBlock, "OreSpawn_EnderPearlBlock");
/* 2055 */     GameRegistry.registerBlock(MyEyeOfEnderBlock, "OreSpawn_EyeOfEnderBlock");
/* 2056 */     GameRegistry.registerBlock(MyAntBlock, "OreSpawn_AntBlock");
/* 2057 */     GameRegistry.registerBlock(MyRedAntBlock, "OreSpawn_RedAntBlock");
/* 2058 */     GameRegistry.registerBlock(TermiteBlock, "OreSpawn_TermiteBlock");
/* 2059 */     GameRegistry.registerBlock(CrystalTermiteBlock, "OreSpawn_CrystalTermiteBlock");
/* 2060 */     GameRegistry.registerBlock(MyRainbowAntBlock, "OreSpawn_RainbowAntBlock");
/* 2061 */     GameRegistry.registerBlock(MyUnstableAntBlock, "OreSpawn_UnstableAntBlock");
/*      */     
/* 2063 */     GameRegistry.registerItem(MyIngotUranium, "OreSpawn_IngotUranium");
/* 2064 */     GameRegistry.registerItem(MyCrystalPinkIngot, "OreSpawn_CrystalPinkIngot");
/* 2065 */     GameRegistry.registerItem(MyTigersEyeIngot, "OreSpawn_TigersEyeIngot");
/* 2066 */     GameRegistry.registerItem(MyIngotTitanium, "OreSpawn_IngotTitanium");
/* 2067 */     GameRegistry.registerItem(MyUltimateSword, "OreSpawn_UltimateSword");
/* 2068 */     GameRegistry.registerItem(MyNightmareSword, "OreSpawn_NightmareSword");
/* 2069 */     GameRegistry.registerItem(MyBertha, "OreSpawn_Bertha");
/* 2070 */     GameRegistry.registerItem(MyHammy, "OreSpawn_Hammy");
/* 2071 */     GameRegistry.registerItem(MySlice, "OreSpawn_Slice");
/* 2072 */     GameRegistry.registerItem(MyRoyal, "OreSpawn_Royal");
/* 2073 */     GameRegistry.registerItem(MyBattleAxe, "OreSpawn_BattleAxe");
/* 2074 */     GameRegistry.registerItem(MyQueenBattleAxe, "OreSpawn_QueenBattleAxe");
/* 2075 */     GameRegistry.registerItem(MyChainsaw, "OreSpawn_Chainsaw");
/* 2076 */     GameRegistry.registerItem(MyUltimatePickaxe, "OreSpawn_UltimatePickaxe");
/* 2077 */     GameRegistry.registerItem(MyUltimateShovel, "OreSpawn_UltimateShovel");
/* 2078 */     GameRegistry.registerItem(MyUltimateHoe, "OreSpawn_UltimateHoe");
/* 2079 */     GameRegistry.registerItem(MyUltimateAxe, "OreSpawn_UltimateAxe");
/* 2080 */     GameRegistry.registerItem(MyEmeraldSword, "OreSpawn_EmeraldSword");
/* 2081 */     GameRegistry.registerItem(MyRoseSword, "OreSpawn_RoseSword");
/* 2082 */     GameRegistry.registerItem(MyExperienceSword, "OreSpawn_ExperienceSword");
/* 2083 */     GameRegistry.registerItem(MyPoisonSword, "OreSpawn_PoisonSword");
/* 2084 */     GameRegistry.registerItem(MyRatSword, "OreSpawn_RatSword");
/* 2085 */     GameRegistry.registerItem(MyFairySword, "OreSpawn_FairySword");
/* 2086 */     GameRegistry.registerItem(MyMantisClaw, "OreSpawn_MantisClaw");
/* 2087 */     GameRegistry.registerItem(MyBigHammer, "OreSpawn_BigHammer");
/* 2088 */     GameRegistry.registerItem(MyEmeraldPickaxe, "OreSpawn_EmeraldPickaxe");
/* 2089 */     GameRegistry.registerItem(MyEmeraldShovel, "OreSpawn_EmeraldShovel");
/* 2090 */     GameRegistry.registerItem(MyEmeraldHoe, "OreSpawn_EmeraldHoe");
/* 2091 */     GameRegistry.registerItem(MyEmeraldAxe, "OreSpawn_EmeraldAxe");
/* 2092 */     GameRegistry.registerItem(MyCrystalWoodSword, "OreSpawn_CrystalWoodSword");
/* 2093 */     GameRegistry.registerItem(MyCrystalWoodPickaxe, "OreSpawn_CrystalWoodPickaxe");
/* 2094 */     GameRegistry.registerItem(MyCrystalWoodShovel, "OreSpawn_CrystalWoodShovel");
/* 2095 */     GameRegistry.registerItem(MyCrystalWoodHoe, "OreSpawn_CrystalWoodHoe");
/* 2096 */     GameRegistry.registerItem(MyCrystalWoodAxe, "OreSpawn_CrystalWoodAxe");
/* 2097 */     GameRegistry.registerItem(MyCrystalPinkSword, "OreSpawn_CrystalPinkSword");
/* 2098 */     GameRegistry.registerItem(MyCrystalPinkPickaxe, "OreSpawn_CrystalPinkPickaxe");
/* 2099 */     GameRegistry.registerItem(MyCrystalPinkShovel, "OreSpawn_CrystalPinkShovel");
/* 2100 */     GameRegistry.registerItem(MyCrystalPinkHoe, "OreSpawn_CrystalPinkHoe");
/* 2101 */     GameRegistry.registerItem(MyCrystalPinkAxe, "OreSpawn_CrystalPinkAxe");
/* 2102 */     GameRegistry.registerItem(MyTigersEyeSword, "OreSpawn_TigersEyeSword");
/* 2103 */     GameRegistry.registerItem(MyTigersEyePickaxe, "OreSpawn_TigersEyePickaxe");
/* 2104 */     GameRegistry.registerItem(MyTigersEyeShovel, "OreSpawn_TigersEyeShovel");
/* 2105 */     GameRegistry.registerItem(MyTigersEyeHoe, "OreSpawn_TigersEyeHoe");
/* 2106 */     GameRegistry.registerItem(MyTigersEyeAxe, "OreSpawn_TigersEyeAxe");
/* 2107 */     GameRegistry.registerItem(MyCrystalStoneSword, "OreSpawn_CrystalStoneSword");
/* 2108 */     GameRegistry.registerItem(MyCrystalStonePickaxe, "OreSpawn_CrystalStonePickaxe");
/* 2109 */     GameRegistry.registerItem(MyCrystalStoneShovel, "OreSpawn_CrystalStoneShovel");
/* 2110 */     GameRegistry.registerItem(MyCrystalStoneHoe, "OreSpawn_CrystalStoneHoe");
/* 2111 */     GameRegistry.registerItem(MyCrystalStoneAxe, "OreSpawn_CrystalStoneAxe");
/* 2112 */     GameRegistry.registerItem(MyRubySword, "OreSpawn_RubySword");
/* 2113 */     GameRegistry.registerItem(MyRubyPickaxe, "OreSpawn_RubyPickaxe");
/* 2114 */     GameRegistry.registerItem(MyRubyShovel, "OreSpawn_RubyShovel");
/* 2115 */     GameRegistry.registerItem(MyRubyHoe, "OreSpawn_RubyHoe");
/* 2116 */     GameRegistry.registerItem(MyRubyAxe, "OreSpawn_RubyAxe");
/* 2117 */     GameRegistry.registerItem(MyAmethystSword, "OreSpawn_AmethystSword");
/* 2118 */     GameRegistry.registerItem(MyAmethystPickaxe, "OreSpawn_AmethystPickaxe");
/* 2119 */     GameRegistry.registerItem(MyAmethystShovel, "OreSpawn_AmethystShovel");
/* 2120 */     GameRegistry.registerItem(MyAmethystHoe, "OreSpawn_AmethystHoe");
/* 2121 */     GameRegistry.registerItem(MyAmethystAxe, "OreSpawn_AmethystAxe");
/* 2122 */     GameRegistry.registerItem(MyItemShoes, "OreSpawn_RedHeels");
/* 2123 */     GameRegistry.registerItem(MyItemShoes_1, "OreSpawn_BlackHeels");
/* 2124 */     GameRegistry.registerItem(MyItemShoes_2, "OreSpawn_Slippers");
/* 2125 */     GameRegistry.registerItem(MyItemShoes_3, "OreSpawn_Boots");
/* 2126 */     GameRegistry.registerItem(MyItemGameController, "OreSpawn_GameController");
/* 2127 */     GameRegistry.registerItem(MyUltimateBow, "OreSpawn_UltimateBow");
/* 2128 */     GameRegistry.registerItem(MySkateBow, "OreSpawn_SkateBow");
/* 2129 */     GameRegistry.registerItem(MyUltimateFishingRod, "OreSpawn_UltimateFishingRod");
/* 2130 */     GameRegistry.registerItem(MyFireFish, "OreSpawn_FireFish");
/* 2131 */     GameRegistry.registerItem(MySunFish, "OreSpawn_SunFish");
/* 2132 */     GameRegistry.registerItem(MyLavaEel, "OreSpawn_LavaEel");
/* 2133 */     GameRegistry.registerItem(MyMothScale, "OreSpawn_MothScale");
/* 2134 */     GameRegistry.registerItem(MyQueenScale, "OreSpawn_QueenScale");
/* 2135 */     GameRegistry.registerItem(MyNightmareScale, "OreSpawn_NightmareScale");
/* 2136 */     GameRegistry.registerItem(MyEmperorScorpionScale, "OreSpawn_EmperorScorpionScale");
/* 2137 */     GameRegistry.registerItem(MyBasiliskScale, "OreSpawn_BasiliskScale");
/* 2138 */     GameRegistry.registerItem(MyWaterDragonScale, "OreSpawn_WaterDragonScale");
/* 2139 */     GameRegistry.registerItem(MyPeacockFeather, "OreSpawn_PeacockFeather");
/* 2140 */     GameRegistry.registerItem(MyJumpyBugScale, "OreSpawn_JumpyBugScale");
/* 2141 */     GameRegistry.registerItem(MyKrakenTooth, "OreSpawn_KrakenTooth");
/* 2142 */     GameRegistry.registerItem(MyGodzillaScale, "OreSpawn_GodzillaScale");
/* 2143 */     GameRegistry.registerItem(GreenGoo, "OreSpawn_GreenGoo");
/* 2144 */     GameRegistry.registerItem(SpiderRobotKit, "OreSpawn_SpiderRobotKit");
/* 2145 */     GameRegistry.registerItem(AntRobotKit, "OreSpawn_AntRobotKit");
/* 2146 */     GameRegistry.registerItem(ZooKeeper, "OreSpawn_ZooKeeper");
/* 2147 */     GameRegistry.registerItem(CreeperLauncher, "OreSpawn_CreeperLauncher");
/* 2148 */     GameRegistry.registerItem(NetherLost, "OreSpawn_NetherLost");
/* 2149 */     GameRegistry.registerItem(CrystalSticks, "OreSpawn_CrystalSticks");
/* 2150 */     GameRegistry.registerItem(Sifter, "OreSpawn_Sifter");
/* 2151 */     GameRegistry.registerItem(MySunspotUrchin, "OreSpawn_SunspotUrchin");
/* 2152 */     GameRegistry.registerItem(MyWaterBall, "OreSpawn_WaterBall");
/* 2153 */     GameRegistry.registerItem(MyLaserBall, "OreSpawn_LaserBall");
/* 2154 */     GameRegistry.registerItem(MyIceBall, "OreSpawn_IceBall");
/* 2155 */     GameRegistry.registerItem(MySmallRock, "OreSpawn_SmallRock");
/* 2156 */     GameRegistry.registerItem(MyRock, "OreSpawn_Rock");
/* 2157 */     GameRegistry.registerItem(MyRedRock, "OreSpawn_RedRock");
/* 2158 */     GameRegistry.registerItem(MyCrystalRedRock, "OreSpawn_CrystalRedRock");
/* 2159 */     GameRegistry.registerItem(MyCrystalGreenRock, "OreSpawn_CrystalGreenRock");
/* 2160 */     GameRegistry.registerItem(MyCrystalBlueRock, "OreSpawn_CrystalBlueRock");
/* 2161 */     GameRegistry.registerItem(MyCrystalTNTRock, "OreSpawn_CrystalTNTRock");
/* 2162 */     GameRegistry.registerItem(MyGreenRock, "OreSpawn_GreenRock");
/* 2163 */     GameRegistry.registerItem(MyBlueRock, "OreSpawn_BlueRock");
/* 2164 */     GameRegistry.registerItem(MyPurpleRock, "OreSpawn_PurpleRock");
/* 2165 */     GameRegistry.registerItem(MySpikeyRock, "OreSpawn_SpikeyRock");
/* 2166 */     GameRegistry.registerItem(MyTNTRock, "OreSpawn_TNTRock");
/* 2167 */     GameRegistry.registerItem(MyAcid, "OreSpawn_Acid");
/* 2168 */     GameRegistry.registerItem(MyIrukandji, "OreSpawn_Irukandji");
/* 2169 */     GameRegistry.registerItem(MyIrukandjiArrow, "OreSpawn_IrukandjiArrow");
/* 2170 */     GameRegistry.registerItem(MyRayGun, "OreSpawn_RayGun");
/* 2171 */     GameRegistry.registerItem(MySquidZooka, "OreSpawn_SquidZooka");
/* 2172 */     GameRegistry.registerItem(MySparkFish, "OreSpawn_SparkFish");
/* 2173 */     GameRegistry.registerItem(MySalt, "OreSpawn_Salt");
/* 2174 */     GameRegistry.registerItem(MyPopcorn, "OreSpawn_Popcorn");
/* 2175 */     GameRegistry.registerItem(MyButteredPopcorn, "OreSpawn_ButteredPopcorn");
/* 2176 */     GameRegistry.registerItem(MyButteredSaltedPopcorn, "OreSpawn_ButteredSaltedPopcorn");
/* 2177 */     GameRegistry.registerItem(MyPopcornBag, "OreSpawn_PopcornBag");
/* 2178 */     GameRegistry.registerItem(MyButter, "OreSpawn_Butter");
/* 2179 */     GameRegistry.registerItem(MyCornDog, "OreSpawn_CornDog");
/* 2180 */     GameRegistry.registerItem(MyCheese, "OreSpawn_Cheese");
/* 2181 */     GameRegistry.registerItem(MyRawCornDog, "OreSpawn_RawCornDog");
/* 2182 */     GameRegistry.registerItem(MyPeacock, "OreSpawn_Peacock");
/* 2183 */     GameRegistry.registerItem(MyRawPeacock, "OreSpawn_RawPeacock");
/* 2184 */     GameRegistry.registerItem(MyRuby, "OreSpawn_Ruby");
/* 2185 */     GameRegistry.registerItem(MyAmethyst, "OreSpawn_Amethyst");
/* 2186 */     GameRegistry.registerItem(MyThunderStaff, "OreSpawn_ThunderStaff");
/* 2187 */     GameRegistry.registerItem(MyWrench, "OreSpawn_Wrench");
/* 2188 */     GameRegistry.registerItem(MyRawBacon, "OreSpawn_RawBacon");
/* 2189 */     GameRegistry.registerItem(MyBacon, "OreSpawn_Bacon");
/* 2190 */     GameRegistry.registerItem(MyRawCrabMeat, "OreSpawn_RawCrabMeat");
/* 2191 */     GameRegistry.registerItem(MyCrabMeat, "OreSpawn_CrabMeat");
/* 2192 */     GameRegistry.registerItem(MyButterCandy, "OreSpawn_ButterCandy");
/* 2193 */     GameRegistry.registerItem(UraniumNugget, "OreSpawn_UraniumNugget");
/* 2194 */     GameRegistry.registerItem(TitaniumNugget, "OreSpawn_TitaniumNugget");
/* 2195 */     GameRegistry.registerItem(MyGreenFish, "OreSpawn_GreenFish");
/* 2196 */     GameRegistry.registerItem(MyBlueFish, "OreSpawn_BlueFish");
/* 2197 */     GameRegistry.registerItem(MyPinkFish, "OreSpawn_PinkFish");
/* 2198 */     GameRegistry.registerItem(MyRockFish, "OreSpawn_RockFish");
/* 2199 */     GameRegistry.registerItem(MyWoodFish, "OreSpawn_WoodFish");
/* 2200 */     GameRegistry.registerItem(MyGreyFish, "OreSpawn_GreyFish");
/* 2201 */     GameRegistry.registerItem(MySalad, "OreSpawn_Salad");
/* 2202 */     GameRegistry.registerItem(MyBLT, "OreSpawn_BLT");
/* 2203 */     GameRegistry.registerItem(MyCrabbyPatty, "OreSpawn_CrabbyPatty");
/*      */     
/* 2205 */     GameRegistry.registerItem(BerthaHandle, "OreSpawn_BerthaHandle");
/* 2206 */     GameRegistry.registerItem(BerthaGuard, "OreSpawn_BerthaGuard");
/* 2207 */     GameRegistry.registerItem(BerthaBlade, "OreSpawn_BerthaBlade");
/* 2208 */     GameRegistry.registerItem(MolenoidNose, "OreSpawn_MolenoidNose");
/* 2209 */     GameRegistry.registerItem(SeaMonsterScale, "OreSpawn_SeaMonsterScale");
/* 2210 */     GameRegistry.registerItem(WormTooth, "OreSpawn_WormTooth");
/* 2211 */     GameRegistry.registerItem(TRexTooth, "OreSpawn_TRexTooth");
/* 2212 */     GameRegistry.registerItem(CaterKillerJaw, "OreSpawn_CaterKillerJaw");
/* 2213 */     GameRegistry.registerItem(SeaViperTongue, "OreSpawn_SeaViperTongue");
/* 2214 */     GameRegistry.registerItem(VortexEye, "OreSpawn_VortexEye");
/*      */ 
/*      */ 
/*      */     
/* 2218 */     GameRegistry.registerItem(WitherSkeletonEgg, "OreSpawn_WitherSkeletonEgg");
/* 2219 */     GameRegistry.registerItem(EnderDragonEgg, "OreSpawn_EnderDragonEgg");
/* 2220 */     GameRegistry.registerItem(SnowGolemEgg, "OreSpawn_SnowGolemEgg");
/* 2221 */     GameRegistry.registerItem(IronGolemEgg, "OreSpawn_IronGolemEgg");
/* 2222 */     GameRegistry.registerItem(WitherBossEgg, "OreSpawn_WitherBossEgg");
/* 2223 */     GameRegistry.registerItem(GirlfriendEgg, "OreSpawn_GirlfriendEgg");
/* 2224 */     GameRegistry.registerItem(BoyfriendEgg, "OreSpawn_BoyfriendEgg");
/* 2225 */     GameRegistry.registerItem(TheKingEgg, "OreSpawn_TheKingEgg");
/* 2226 */     GameRegistry.registerItem(TheQueenEgg, "OreSpawn_TheQueenEgg");
/* 2227 */     GameRegistry.registerItem(ThePrinceEgg, "OreSpawn_ThePrinceEgg");
/* 2228 */     GameRegistry.registerItem(RedCowEgg, "OreSpawn_RedCowEgg");
/* 2229 */     GameRegistry.registerItem(CrystalCowEgg, "OreSpawn_CrystalCowEgg");
/* 2230 */     GameRegistry.registerItem(GoldCowEgg, "OreSpawn_GoldCowEgg");
/* 2231 */     GameRegistry.registerItem(EnchantedCowEgg, "OreSpawn_EnchantedCowEgg");
/* 2232 */     GameRegistry.registerItem(MOTHRAEgg, "OreSpawn_MOTHRAEgg");
/* 2233 */     GameRegistry.registerItem(AloEgg, "OreSpawn_AloEgg");
/* 2234 */     GameRegistry.registerItem(CryoEgg, "OreSpawn_CryoEgg");
/* 2235 */     GameRegistry.registerItem(CamaEgg, "OreSpawn_CamaEgg");
/* 2236 */     GameRegistry.registerItem(VeloEgg, "OreSpawn_VeloEgg");
/* 2237 */     GameRegistry.registerItem(HydroEgg, "OreSpawn_HydroEgg");
/* 2238 */     GameRegistry.registerItem(BasilEgg, "OreSpawn_BasilEgg");
/* 2239 */     GameRegistry.registerItem(DragonflyEgg, "OreSpawn_DragonflyEgg");
/* 2240 */     GameRegistry.registerItem(EmperorScorpionEgg, "OreSpawn_EmperorScorpionEgg");
/* 2241 */     GameRegistry.registerItem(ScorpionEgg, "OreSpawn_ScorpionEgg");
/* 2242 */     GameRegistry.registerItem(CaveFisherEgg, "OreSpawn_CaveFisherEgg");
/* 2243 */     GameRegistry.registerItem(SpyroEgg, "OreSpawn_SpyroEgg");
/* 2244 */     GameRegistry.registerItem(BaryonyxEgg, "OreSpawn_BaryonyxEgg");
/* 2245 */     GameRegistry.registerItem(GammaMetroidEgg, "OreSpawn_GammaMetroidEgg");
/* 2246 */     GameRegistry.registerItem(CockateilEgg, "OreSpawn_CockateilEgg");
/* 2247 */     GameRegistry.registerItem(KyuubiEgg, "OreSpawn_KyuubiEgg");
/* 2248 */     GameRegistry.registerItem(AlienEgg, "OreSpawn_AlienEgg");
/* 2249 */     GameRegistry.registerItem(AttackSquidEgg, "OreSpawn_AttackSquidEgg");
/* 2250 */     GameRegistry.registerItem(WaterDragonEgg, "OreSpawn_WaterDragonEgg");
/* 2251 */     GameRegistry.registerItem(CephadromeEgg, "OreSpawn_CephadromeEgg");
/* 2252 */     GameRegistry.registerItem(KrakenEgg, "OreSpawn_KrakenEgg");
/* 2253 */     GameRegistry.registerItem(LizardEgg, "OreSpawn_LizardEgg");
/* 2254 */     GameRegistry.registerItem(DragonEgg, "OreSpawn_DragonEgg");
/* 2255 */     GameRegistry.registerItem(BeeEgg, "OreSpawn_BeeEgg");
/* 2256 */     GameRegistry.registerItem(TrooperBugEgg, "OreSpawn_TrooperBugEgg");
/* 2257 */     GameRegistry.registerItem(SpitBugEgg, "OreSpawn_SpitBugEgg");
/* 2258 */     GameRegistry.registerItem(StinkBugEgg, "OreSpawn_StinkBugEgg");
/* 2259 */     GameRegistry.registerItem(OstrichEgg, "OreSpawn_OstrichEgg");
/* 2260 */     GameRegistry.registerItem(GazelleEgg, "OreSpawn_GazelleEgg");
/* 2261 */     GameRegistry.registerItem(ChipmunkEgg, "OreSpawn_ChipmunkEgg");
/* 2262 */     GameRegistry.registerItem(CreepingHorrorEgg, "OreSpawn_CreepingHorrorEgg");
/* 2263 */     GameRegistry.registerItem(TerribleTerrorEgg, "OreSpawn_TerribleTerrorEgg");
/* 2264 */     GameRegistry.registerItem(CliffRacerEgg, "OreSpawn_CliffRacerEgg");
/* 2265 */     GameRegistry.registerItem(TriffidEgg, "OreSpawn_TriffidEgg");
/* 2266 */     GameRegistry.registerItem(PitchBlackEgg, "OreSpawn_PitchBlackEgg");
/* 2267 */     GameRegistry.registerItem(LurkingTerrorEgg, "OreSpawn_LurkingTerrorEgg");
/* 2268 */     GameRegistry.registerItem(GodzillaEgg, "OreSpawn_GodzillaEgg");
/* 2269 */     GameRegistry.registerItem(SmallWormEgg, "OreSpawn_SmallWormEgg");
/* 2270 */     GameRegistry.registerItem(MediumWormEgg, "OreSpawn_MediumWormEgg");
/* 2271 */     GameRegistry.registerItem(LargeWormEgg, "OreSpawn_LargeWormEgg");
/* 2272 */     GameRegistry.registerItem(CassowaryEgg, "OreSpawn_CassowaryEgg");
/* 2273 */     GameRegistry.registerItem(CloudSharkEgg, "OreSpawn_CloudSharkEgg");
/* 2274 */     GameRegistry.registerItem(GoldFishEgg, "OreSpawn_GoldFishEgg");
/* 2275 */     GameRegistry.registerItem(LeafMonsterEgg, "OreSpawn_LeafMonsterEgg");
/* 2276 */     GameRegistry.registerItem(TshirtEgg, "OreSpawn_TshirtEgg");
/* 2277 */     GameRegistry.registerItem(EnderKnightEgg, "OreSpawn_EnderKnightEgg");
/* 2278 */     GameRegistry.registerItem(EnderReaperEgg, "OreSpawn_EnderReaperEgg");
/* 2279 */     GameRegistry.registerItem(BeaverEgg, "OreSpawn_BeaverEgg");
/* 2280 */     GameRegistry.registerItem(DungeonBeastEgg, "OreSpawn_DungeonBeastEgg");
/* 2281 */     GameRegistry.registerItem(RotatorEgg, "OreSpawn_RotatorEgg");
/* 2282 */     GameRegistry.registerItem(VortexEgg, "OreSpawn_VortexEgg");
/* 2283 */     GameRegistry.registerItem(PeacockEgg, "OreSpawn_PeacockEgg");
/* 2284 */     GameRegistry.registerItem(FairyEgg, "OreSpawn_FairyEgg");
/* 2285 */     GameRegistry.registerItem(RatEgg, "OreSpawn_RatEgg");
/* 2286 */     GameRegistry.registerItem(FlounderEgg, "OreSpawn_FlounderEgg");
/* 2287 */     GameRegistry.registerItem(WhaleEgg, "OreSpawn_WhaleEgg");
/* 2288 */     GameRegistry.registerItem(IrukandjiEgg, "OreSpawn_IrukandjiEgg");
/* 2289 */     GameRegistry.registerItem(SkateEgg, "OreSpawn_SkateEgg");
/* 2290 */     GameRegistry.registerItem(UrchinEgg, "OreSpawn_UrchinEgg");
/* 2291 */     GameRegistry.registerItem(Robot1Egg, "OreSpawn_Robot1Egg");
/* 2292 */     GameRegistry.registerItem(Robot2Egg, "OreSpawn_Robot2Egg");
/* 2293 */     GameRegistry.registerItem(Robot3Egg, "OreSpawn_Robot3Egg");
/* 2294 */     GameRegistry.registerItem(Robot4Egg, "OreSpawn_Robot4Egg");
/* 2295 */     GameRegistry.registerItem(GhostEgg, "OreSpawn_GhostEgg");
/* 2296 */     GameRegistry.registerItem(GhostSkellyEgg, "OreSpawn_GhostSkellyEgg");
/* 2297 */     GameRegistry.registerItem(BrownAntEgg, "OreSpawn_BrownAntEgg");
/* 2298 */     GameRegistry.registerItem(RedAntEgg, "OreSpawn_RedAntEgg");
/* 2299 */     GameRegistry.registerItem(RainbowAntEgg, "OreSpawn_RainbowAntEgg");
/* 2300 */     GameRegistry.registerItem(UnstableAntEgg, "OreSpawn_UnstableAntEgg");
/* 2301 */     GameRegistry.registerItem(TermiteEgg, "OreSpawn_TermiteEgg");
/* 2302 */     GameRegistry.registerItem(ButterflyEgg, "OreSpawn_ButterflyEgg");
/* 2303 */     GameRegistry.registerItem(MothEgg, "OreSpawn_MothEgg");
/* 2304 */     GameRegistry.registerItem(MosquitoEgg, "OreSpawn_MosquitoEgg");
/* 2305 */     GameRegistry.registerItem(FireflyEgg, "OreSpawn_FireflyEgg");
/* 2306 */     GameRegistry.registerItem(TRexEgg, "OreSpawn_TRexEgg");
/* 2307 */     GameRegistry.registerItem(HerculesEgg, "OreSpawn_HerculesEgg");
/* 2308 */     GameRegistry.registerItem(MantisEgg, "OreSpawn_MantisEgg");
/* 2309 */     GameRegistry.registerItem(StinkyEgg, "OreSpawn_StinkyEgg");
/* 2310 */     GameRegistry.registerItem(Robot5Egg, "OreSpawn_Robot5Egg");
/* 2311 */     GameRegistry.registerItem(CoinEgg, "OreSpawn_CoinEgg");
/* 2312 */     GameRegistry.registerItem(EasterBunnyEgg, "OreSpawn_EasterBunnyEgg");
/* 2313 */     GameRegistry.registerItem(MolenoidEgg, "OreSpawn_MolenoidEgg");
/* 2314 */     GameRegistry.registerItem(SeaMonsterEgg, "OreSpawn_SeaMonsterEgg");
/* 2315 */     GameRegistry.registerItem(SeaViperEgg, "OreSpawn_SeaViperEgg");
/* 2316 */     GameRegistry.registerItem(CaterKillerEgg, "OreSpawn_CaterKillerEgg");
/* 2317 */     GameRegistry.registerItem(RubberDuckyEgg, "OreSpawn_RubberDuckyEgg");
/* 2318 */     GameRegistry.registerItem(HammerheadEgg, "OreSpawn_HammerheadEgg");
/* 2319 */     GameRegistry.registerItem(LeonEgg, "OreSpawn_LeonEgg");
/* 2320 */     GameRegistry.registerItem(CriminalEgg, "OreSpawn_CriminalEgg");
/* 2321 */     GameRegistry.registerItem(BrutalflyEgg, "OreSpawn_BrutalflyEgg");
/* 2322 */     GameRegistry.registerItem(NastysaurusEgg, "OreSpawn_NastysaurusEgg");
/* 2323 */     GameRegistry.registerItem(PointysaurusEgg, "OreSpawn_PointysaurusEgg");
/* 2324 */     GameRegistry.registerItem(CricketEgg, "OreSpawn_CricketEgg");
/* 2325 */     GameRegistry.registerItem(ThePrincessEgg, "OreSpawn_ThePrincessEgg");
/* 2326 */     GameRegistry.registerItem(FrogEgg, "OreSpawn_FrogEgg");
/* 2327 */     GameRegistry.registerItem(JefferyEgg, "OreSpawn_JefferyEgg");
/* 2328 */     GameRegistry.registerItem(AntRobotEgg, "OreSpawn_AntRobotEgg");
/* 2329 */     GameRegistry.registerItem(SpiderRobotEgg, "OreSpawn_SpiderRobotEgg");
/* 2330 */     GameRegistry.registerItem(SpiderDriverEgg, "OreSpawn_SpiderDriverEgg");
/* 2331 */     GameRegistry.registerItem(CrabEgg, "OreSpawn_CrabEgg");
/*      */ 
/*      */     
/* 2334 */     GameRegistry.registerItem(CageEmpty, "OreSpawn_CageEmpty");
/* 2335 */     GameRegistry.registerItem(CagedSpider, "OreSpawn_CagedSpider");
/* 2336 */     GameRegistry.registerItem(CagedBat, "OreSpawn_CagedBat");
/* 2337 */     GameRegistry.registerItem(CagedCow, "OreSpawn_CagedCow");
/* 2338 */     GameRegistry.registerItem(CagedPig, "OreSpawn_CagePig");
/* 2339 */     GameRegistry.registerItem(CagedSquid, "OreSpawn_CagedSquid");
/* 2340 */     GameRegistry.registerItem(CagedChicken, "OreSpawn_CagedChicken");
/* 2341 */     GameRegistry.registerItem(CagedCreeper, "OreSpawn_CagedCreeper");
/* 2342 */     GameRegistry.registerItem(CagedSkeleton, "OreSpawn_CagedSkeleton");
/* 2343 */     GameRegistry.registerItem(CagedZombie, "OreSpawn_CagedZombie");
/* 2344 */     GameRegistry.registerItem(CagedSlime, "OreSpawn_CagedSlime");
/* 2345 */     GameRegistry.registerItem(CagedGhast, "OreSpawn_CagedGhast");
/* 2346 */     GameRegistry.registerItem(CagedZombiePigman, "OreSpawn_CagedZombiePigman");
/* 2347 */     GameRegistry.registerItem(CagedEnderman, "OreSpawn_CagedEnderman");
/* 2348 */     GameRegistry.registerItem(CagedCaveSpider, "OreSpawn_CagedCaveSpider");
/* 2349 */     GameRegistry.registerItem(CagedSilverfish, "OreSpawn_CagedSilverfish");
/* 2350 */     GameRegistry.registerItem(CagedMagmaCube, "OreSpawn_CagedMagmaCube");
/* 2351 */     GameRegistry.registerItem(CagedWitch, "OreSpawn_CagedWitch");
/* 2352 */     GameRegistry.registerItem(CagedSheep, "OreSpawn_CagedSheep");
/* 2353 */     GameRegistry.registerItem(CagedWolf, "OreSpawn_CagedWolf");
/* 2354 */     GameRegistry.registerItem(CagedMooshroom, "OreSpawn_CagedMooshroom");
/* 2355 */     GameRegistry.registerItem(CagedOcelot, "OreSpawn_CagedOcelot");
/* 2356 */     GameRegistry.registerItem(CagedBlaze, "OreSpawn_CagedBlaze");
/* 2357 */     GameRegistry.registerItem(CagedGirlfriend, "OreSpawn_CagedGirlfriend");
/* 2358 */     GameRegistry.registerItem(CagedBoyfriend, "OreSpawn_CagedBoyfriend");
/* 2359 */     GameRegistry.registerItem(CagedWitherSkeleton, "OreSpawn_CagedWitherSkeleton");
/* 2360 */     GameRegistry.registerItem(CagedEnderDragon, "OreSpawn_CagedEnderDragon");
/* 2361 */     GameRegistry.registerItem(CagedSnowGolem, "OreSpawn_CagedSnowGolem");
/* 2362 */     GameRegistry.registerItem(CagedIronGolem, "OreSpawn_CagedIronGolem");
/* 2363 */     GameRegistry.registerItem(CagedWitherBoss, "OreSpawn_CagedWitherBoss");
/* 2364 */     GameRegistry.registerItem(CagedRedCow, "OreSpawn_CagedRedCow");
/* 2365 */     GameRegistry.registerItem(CagedCrystalCow, "OreSpawn_CagedCrystalCow");
/* 2366 */     GameRegistry.registerItem(CagedVillager, "OreSpawn_CagedVillager");
/* 2367 */     GameRegistry.registerItem(CagedGoldCow, "OreSpawn_CagedGoldCow");
/* 2368 */     GameRegistry.registerItem(CagedEnchantedCow, "OreSpawn_CagedEnchantedCow");
/* 2369 */     GameRegistry.registerItem(CagedMOTHRA, "OreSpawn_CagedMOTHRA");
/* 2370 */     GameRegistry.registerItem(CagedAlo, "OreSpawn_CagedAlo");
/* 2371 */     GameRegistry.registerItem(CagedCryo, "OreSpawn_CagedCryo");
/* 2372 */     GameRegistry.registerItem(CagedCama, "OreSpawn_CagedCama");
/* 2373 */     GameRegistry.registerItem(CagedVelo, "OreSpawn_CagedVelo");
/* 2374 */     GameRegistry.registerItem(CagedHydro, "OreSpawn_CagedHydro");
/* 2375 */     GameRegistry.registerItem(CagedBasil, "OreSpawn_CagedBasil");
/* 2376 */     GameRegistry.registerItem(CagedDragonfly, "OreSpawn_CagedDragonfly");
/* 2377 */     GameRegistry.registerItem(CagedEmperorScorpion, "OreSpawn_CagedEmperorScorpion");
/* 2378 */     GameRegistry.registerItem(CagedScorpion, "OreSpawn_CagedScorpion");
/* 2379 */     GameRegistry.registerItem(CagedCaveFisher, "OreSpawn_CagedCaveFisher");
/* 2380 */     GameRegistry.registerItem(CagedSpyro, "OreSpawn_CagedSpyro");
/* 2381 */     GameRegistry.registerItem(CagedBaryonyx, "OreSpawn_CagedBaryonyx");
/* 2382 */     GameRegistry.registerItem(CagedGammaMetroid, "OreSpawn_CagedGammaMetroid");
/* 2383 */     GameRegistry.registerItem(CagedCockateil, "OreSpawn_CagedCockateil");
/* 2384 */     GameRegistry.registerItem(CagedKyuubi, "OreSpawn_CagedKyuubi");
/* 2385 */     GameRegistry.registerItem(CagedAlien, "OreSpawn_CagedAlien");
/* 2386 */     GameRegistry.registerItem(MyElevator, "OreSpawn_Elevator");
/* 2387 */     GameRegistry.registerItem(CagedAttackSquid, "OreSpawn_CagedAttackSquid");
/* 2388 */     GameRegistry.registerItem(CagedWaterDragon, "OreSpawn_CagedWaterDragon");
/* 2389 */     GameRegistry.registerItem(CagedCephadrome, "OreSpawn_CagedCephadrome");
/* 2390 */     GameRegistry.registerItem(CagedKraken, "OreSpawn_CagedKraken");
/* 2391 */     GameRegistry.registerItem(CagedLizard, "OreSpawn_CagedLizard");
/* 2392 */     GameRegistry.registerItem(CagedDragon, "OreSpawn_CagedDragon");
/* 2393 */     GameRegistry.registerItem(CagedBee, "OreSpawn_CagedBee");
/* 2394 */     GameRegistry.registerItem(CagedHorse, "OreSpawn_CagedHorse");
/* 2395 */     GameRegistry.registerItem(CagedFirefly, "OreSpawn_CagedFirefly");
/* 2396 */     GameRegistry.registerItem(CagedChipmunk, "OreSpawn_CagedChipmunk");
/* 2397 */     GameRegistry.registerItem(CagedGazelle, "OreSpawn_CagedGazelle");
/* 2398 */     GameRegistry.registerItem(CagedOstrich, "OreSpawn_CagedOstrich");
/* 2399 */     GameRegistry.registerItem(CagedTrooper, "OreSpawn_CagedTrooper");
/* 2400 */     GameRegistry.registerItem(CagedSpit, "OreSpawn_CagedSpit");
/* 2401 */     GameRegistry.registerItem(CagedStink, "OreSpawn_CagedStink");
/* 2402 */     GameRegistry.registerItem(CagedCreepingHorror, "OreSpawn_CagedCreepingHorror");
/* 2403 */     GameRegistry.registerItem(CagedTerribleTerror, "OreSpawn_CagedTerribleTerror");
/* 2404 */     GameRegistry.registerItem(CagedCliffRacer, "OreSpawn_CagedCliffRacer");
/* 2405 */     GameRegistry.registerItem(CagedTriffid, "OreSpawn_CagedTriffid");
/* 2406 */     GameRegistry.registerItem(CagedPitchBlack, "OreSpawn_CagedPitchBlack");
/* 2407 */     GameRegistry.registerItem(CagedLurkingTerror, "OreSpawn_CagedLurkingTerror");
/* 2408 */     GameRegistry.registerItem(CagedSmallWorm, "OreSpawn_CagedSmallWorm");
/* 2409 */     GameRegistry.registerItem(CagedMediumWorm, "OreSpawn_CagedMediumWorm");
/* 2410 */     GameRegistry.registerItem(CagedLargeWorm, "OreSpawn_CagedLargeWorm");
/* 2411 */     GameRegistry.registerItem(CagedCassowary, "OreSpawn_CagedCassowary");
/* 2412 */     GameRegistry.registerItem(CagedCloudShark, "OreSpawn_CagedCloudShark");
/* 2413 */     GameRegistry.registerItem(CagedGoldFish, "OreSpawn_CagedGoldFish");
/* 2414 */     GameRegistry.registerItem(CagedLeafMonster, "OreSpawn_CagedLeafMonster");
/* 2415 */     GameRegistry.registerItem(CagedEnderKnight, "OreSpawn_CagedEnderKnight");
/* 2416 */     GameRegistry.registerItem(CagedEnderReaper, "OreSpawn_CagedEnderReaper");
/* 2417 */     GameRegistry.registerItem(CagedBeaver, "OreSpawn_CagedBeaver");
/* 2418 */     GameRegistry.registerItem(CagedUrchin, "OreSpawn_CagedUrchin");
/* 2419 */     GameRegistry.registerItem(CagedFlounder, "OreSpawn_CagedFlounder");
/* 2420 */     GameRegistry.registerItem(CagedSkate, "OreSpawn_CagedSkate");
/* 2421 */     GameRegistry.registerItem(CagedRotator, "OreSpawn_CagedRotator");
/* 2422 */     GameRegistry.registerItem(CagedPeacock, "OreSpawn_CagedPeacock");
/* 2423 */     GameRegistry.registerItem(CagedFairy, "OreSpawn_CagedFairy");
/* 2424 */     GameRegistry.registerItem(CagedDungeonBeast, "OreSpawn_CagedDungeonBeast");
/* 2425 */     GameRegistry.registerItem(CagedVortex, "OreSpawn_CagedVortex");
/* 2426 */     GameRegistry.registerItem(CagedRat, "OreSpawn_CagedRat");
/* 2427 */     GameRegistry.registerItem(CagedWhale, "OreSpawn_CagedWhale");
/* 2428 */     GameRegistry.registerItem(CagedIrukandji, "OreSpawn_CagedIrukandji");
/* 2429 */     GameRegistry.registerItem(CagedTRex, "OreSpawn_CagedTRex");
/* 2430 */     GameRegistry.registerItem(CagedHercules, "OreSpawn_CagedHercules");
/* 2431 */     GameRegistry.registerItem(CagedMantis, "OreSpawn_CagedMantis");
/* 2432 */     GameRegistry.registerItem(CagedStinky, "OreSpawn_CagedStinky");
/* 2433 */     GameRegistry.registerItem(CagedEasterBunny, "OreSpawn_CagedEasterBunny");
/* 2434 */     GameRegistry.registerItem(CagedCaterKiller, "OreSpawn_CagedCaterKiller");
/* 2435 */     GameRegistry.registerItem(CagedMolenoid, "OreSpawn_CagedMolenoid");
/* 2436 */     GameRegistry.registerItem(CagedSeaMonster, "OreSpawn_CagedSeaMonster");
/* 2437 */     GameRegistry.registerItem(CagedSeaViper, "OreSpawn_CagedSeaViper");
/* 2438 */     GameRegistry.registerItem(CagedLeon, "OreSpawn_CagedLeon");
/* 2439 */     GameRegistry.registerItem(CagedHammerhead, "OreSpawn_CagedHammerhead");
/* 2440 */     GameRegistry.registerItem(CagedRubberDucky, "OreSpawn_CagedRubberDucky");
/* 2441 */     GameRegistry.registerItem(CagedCriminal, "OreSpawn_CagedCriminal");
/* 2442 */     GameRegistry.registerItem(CagedBrutalfly, "OreSpawn_CagedBrutalfly");
/* 2443 */     GameRegistry.registerItem(CagedNastysaurus, "OreSpawn_CagedNastysaurus");
/* 2444 */     GameRegistry.registerItem(CagedPointysaurus, "OreSpawn_CagedPointysaurus");
/* 2445 */     GameRegistry.registerItem(CagedCricket, "OreSpawn_CagedCricket");
/* 2446 */     GameRegistry.registerItem(CagedFrog, "OreSpawn_CagedFrog");
/* 2447 */     GameRegistry.registerItem(CagedSpiderDriver, "OreSpawn_CagedSpiderDriver");
/* 2448 */     GameRegistry.registerItem(CagedCrab, "OreSpawn_CagedCrab");
/*      */     
/* 2450 */     GameRegistry.registerItem(MyStrawberry, "OreSpawn_Strawberry");
/* 2451 */     GameRegistry.registerItem(MyCrystalApple, "OreSpawn_CrystalApple");
/* 2452 */     GameRegistry.registerItem(MyLove, "OreSpawn_Love");
/* 2453 */     GameRegistry.registerItem(MyCherry, "OreSpawn_Cherry");
/* 2454 */     GameRegistry.registerItem(MyPeach, "OreSpawn_Peach");
/* 2455 */     GameRegistry.registerItem(MyRadish, "OreSpawn_Radish");
/* 2456 */     GameRegistry.registerItem(MyRice, "OreSpawn_Rice");
/* 2457 */     GameRegistry.registerItem(MyCornCob, "OreSpawn_CornCob");
/* 2458 */     GameRegistry.registerItem(MyQuinoa, "OreSpawn_Quinoa");
/* 2459 */     GameRegistry.registerItem(MyTomato, "OreSpawn_Tomato");
/* 2460 */     GameRegistry.registerItem(MyLettuce, "OreSpawn_Lettuce");
/* 2461 */     GameRegistry.registerItem(MyStrawberrySeed, "OreSpawn_StrawberrySeed");
/* 2462 */     GameRegistry.registerItem(MyButterflySeed, "OreSpawn_ButterflySeed");
/* 2463 */     GameRegistry.registerItem(MyMothSeed, "OreSpawn_MothSeed");
/* 2464 */     GameRegistry.registerItem(MyMosquitoSeed, "OreSpawn_MosquitoSeed");
/* 2465 */     GameRegistry.registerItem(MyFireflySeed, "OreSpawn_FireflySeed");
/* 2466 */     GameRegistry.registerItem(MagicApple, "OreSpawn_MagicApple");
/* 2467 */     GameRegistry.registerItem(RandomDungeon, "OreSpawn_RandomDungeon");
/* 2468 */     GameRegistry.registerItem(MinersDream, "OreSpawn_MinersDream");
/* 2469 */     GameRegistry.registerItem((Item)UltimateHelmet, "OreSpawn_UltimateHelmet");
/* 2470 */     GameRegistry.registerItem((Item)UltimateBody, "OreSpawn_UltimateBody");
/* 2471 */     GameRegistry.registerItem((Item)UltimateLegs, "OreSpawn_UltimateLegs");
/* 2472 */     GameRegistry.registerItem((Item)UltimateBoots, "OreSpawn_UltimateBoots");
/* 2473 */     GameRegistry.registerItem((Item)LavaEelHelmet, "OreSpawn_LavaEelHelmet");
/* 2474 */     GameRegistry.registerItem((Item)LavaEelBody, "OreSpawn_LavaEelBody");
/* 2475 */     GameRegistry.registerItem((Item)LavaEelLegs, "OreSpawn_LavaEelLegs");
/* 2476 */     GameRegistry.registerItem((Item)LavaEelBoots, "OreSpawn_LavaEelBoots");
/* 2477 */     GameRegistry.registerItem((Item)MothScaleHelmet, "OreSpawn_MothScaleHelmet");
/* 2478 */     GameRegistry.registerItem((Item)MothScaleBody, "OreSpawn_MothScaleBody");
/* 2479 */     GameRegistry.registerItem((Item)MothScaleLegs, "OreSpawn_MothScaleLegs");
/* 2480 */     GameRegistry.registerItem((Item)MothScaleBoots, "OreSpawn_MothScaleBoots");
/* 2481 */     GameRegistry.registerItem(MyAppleSeed, "OreSpawn_AppleSeed");
/* 2482 */     GameRegistry.registerItem(MyCherrySeed, "OreSpawn_CherrySeed");
/* 2483 */     GameRegistry.registerItem(MyPeachSeed, "OreSpawn_PeachSeed");
/* 2484 */     GameRegistry.registerItem(MyStepUp, "OreSpawn_StepUp");
/* 2485 */     GameRegistry.registerItem(MyStepDown, "OreSpawn_StepDown");
/* 2486 */     GameRegistry.registerItem(MyStepAccross, "OreSpawn_StepAccross");
/* 2487 */     GameRegistry.registerItem((Item)EmeraldHelmet, "OreSpawn_EmeraldHelmet");
/* 2488 */     GameRegistry.registerItem((Item)EmeraldBody, "OreSpawn_EmeraldBody");
/* 2489 */     GameRegistry.registerItem((Item)EmeraldLegs, "OreSpawn_EmeraldLegs");
/* 2490 */     GameRegistry.registerItem((Item)EmeraldBoots, "OreSpawn_EmeraldBoots");
/* 2491 */     GameRegistry.registerItem(MyExperienceCatcher, "OreSpawn_ExperienceCatcher");
/* 2492 */     GameRegistry.registerItem(MyDeadStinkBug, "OreSpawn_DeadStinkBug");
/* 2493 */     GameRegistry.registerItem(MyExperienceTreeSeed, "OreSpawn_ExperienceTreeSeed");
/* 2494 */     GameRegistry.registerItem((Item)ExperienceHelmet, "OreSpawn_ExperienceHelmet");
/* 2495 */     GameRegistry.registerItem((Item)ExperienceBody, "OreSpawn_ExperienceBody");
/* 2496 */     GameRegistry.registerItem((Item)ExperienceLegs, "OreSpawn_ExperienceLegs");
/* 2497 */     GameRegistry.registerItem((Item)ExperienceBoots, "OreSpawn_ExperienceBoots");
/* 2498 */     GameRegistry.registerItem((Item)RubyHelmet, "OreSpawn_RubyHelmet");
/* 2499 */     GameRegistry.registerItem((Item)RubyBody, "OreSpawn_RubyBody");
/* 2500 */     GameRegistry.registerItem((Item)RubyLegs, "OreSpawn_RubyLegs");
/* 2501 */     GameRegistry.registerItem((Item)RubyBoots, "OreSpawn_RubyBoots");
/* 2502 */     GameRegistry.registerItem((Item)AmethystHelmet, "OreSpawn_AmethystHelmet");
/* 2503 */     GameRegistry.registerItem((Item)AmethystBody, "OreSpawn_AmethystBody");
/* 2504 */     GameRegistry.registerItem((Item)AmethystLegs, "OreSpawn_AmethystLegs");
/* 2505 */     GameRegistry.registerItem((Item)AmethystBoots, "OreSpawn_AmethystBoots");
/* 2506 */     GameRegistry.registerItem(ZooCage2, "OreSpawn_ZooCage2");
/* 2507 */     GameRegistry.registerItem(ZooCage4, "OreSpawn_ZooCage4");
/* 2508 */     GameRegistry.registerItem(ZooCage6, "OreSpawn_ZooCage6");
/* 2509 */     GameRegistry.registerItem(ZooCage8, "OreSpawn_ZooCage8");
/* 2510 */     GameRegistry.registerItem(ZooCage10, "OreSpawn_ZooCage10");
/* 2511 */     GameRegistry.registerItem(InstantShelter, "OreSpawn_InstantShelter");
/* 2512 */     GameRegistry.registerItem(InstantGarden, "OreSpawn_InstantGarden");
/* 2513 */     GameRegistry.registerItem((Item)CrystalPinkHelmet, "OreSpawn_CrystalPinkHelmet");
/* 2514 */     GameRegistry.registerItem((Item)CrystalPinkBody, "OreSpawn_CrystalPinkBody");
/* 2515 */     GameRegistry.registerItem((Item)CrystalPinkLegs, "OreSpawn_CrystalPinkLegs");
/* 2516 */     GameRegistry.registerItem((Item)CrystalPinkBoots, "OreSpawn_CrystalPinkBoots");
/* 2517 */     GameRegistry.registerItem((Item)TigersEyeHelmet, "OreSpawn_TigersEyeHelmet");
/* 2518 */     GameRegistry.registerItem((Item)TigersEyeBody, "OreSpawn_TigersEyeBody");
/* 2519 */     GameRegistry.registerItem((Item)TigersEyeLegs, "OreSpawn_TigersEyeLegs");
/* 2520 */     GameRegistry.registerItem((Item)TigersEyeBoots, "OreSpawn_TigersEyeBoots");
/* 2521 */     GameRegistry.registerItem((Item)PeacockFeatherBoots, "OreSpawn_PeacockFeatherBoots");
/* 2522 */     GameRegistry.registerItem((Item)PeacockFeatherHelmet, "OreSpawn_PeacockFeatherHelmet");
/* 2523 */     GameRegistry.registerItem((Item)PeacockFeatherBody, "OreSpawn_PeacockFeatherBody");
/* 2524 */     GameRegistry.registerItem((Item)PeacockFeatherLegs, "OreSpawn_PeacockFeatherLegs");
/* 2525 */     GameRegistry.registerItem((Item)MobzillaHelmet, "OreSpawn_MobzillaHelmet");
/* 2526 */     GameRegistry.registerItem((Item)MobzillaBody, "OreSpawn_MobzillaBody");
/* 2527 */     GameRegistry.registerItem((Item)MobzillaLegs, "OreSpawn_MobzillaLegs");
/* 2528 */     GameRegistry.registerItem((Item)MobzillaBoots, "OreSpawn_MobzillaBoots");
/* 2529 */     GameRegistry.registerItem((Item)RoyalHelmet, "OreSpawn_RoyalHelmet");
/* 2530 */     GameRegistry.registerItem((Item)RoyalBody, "OreSpawn_RoyalBody");
/* 2531 */     GameRegistry.registerItem((Item)RoyalLegs, "OreSpawn_RoyalLegs");
/* 2532 */     GameRegistry.registerItem((Item)RoyalBoots, "OreSpawn_RoyalBoots");
/* 2533 */     GameRegistry.registerItem((Item)LapisHelmet, "OreSpawn_LapisHelmet");
/* 2534 */     GameRegistry.registerItem((Item)LapisBody, "OreSpawn_LapisBody");
/* 2535 */     GameRegistry.registerItem((Item)LapisLegs, "OreSpawn_LapisLegs");
/* 2536 */     GameRegistry.registerItem((Item)LapisBoots, "OreSpawn_LapisBoots");
/* 2537 */     GameRegistry.registerItem((Item)QueenHelmet, "OreSpawn_QueenHelmet");
/* 2538 */     GameRegistry.registerItem((Item)QueenBody, "OreSpawn_QueenBody");
/* 2539 */     GameRegistry.registerItem((Item)QueenLegs, "OreSpawn_QueenLegs");
/* 2540 */     GameRegistry.registerItem((Item)QueenBoots, "OreSpawn_QueenBoots");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2545 */     ItemStack OreSpiderEggStack = new ItemStack(MySpiderSpawnBlock);
/*      */     
/* 2547 */     LanguageRegistry.instance().addNameForObject(MySpiderSpawnBlock, "en_US", "Ancient Dried Spider Spawn Egg");
/* 2548 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 52), new Object[] { new ItemStack(Items.water_bucket), OreSpiderEggStack });
/*      */     
/* 2550 */     ItemStack OreBatEggStack = new ItemStack(MyBatSpawnBlock);
/*      */     
/* 2552 */     LanguageRegistry.instance().addNameForObject(MyBatSpawnBlock, "en_US", "Ancient Dried Bat Spawn Egg");
/* 2553 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 65), new Object[] { new ItemStack(Items.water_bucket), OreBatEggStack });
/*      */     
/* 2555 */     ItemStack OreCowEggStack = new ItemStack(MyCowSpawnBlock);
/*      */     
/* 2557 */     LanguageRegistry.instance().addNameForObject(MyCowSpawnBlock, "en_US", "Ancient Dried Cow Spawn Egg");
/* 2558 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 92), new Object[] { new ItemStack(Items.water_bucket), OreCowEggStack });
/*      */     
/* 2560 */     ItemStack OrePigEggStack = new ItemStack(MyPigSpawnBlock);
/*      */     
/* 2562 */     LanguageRegistry.instance().addNameForObject(MyPigSpawnBlock, "en_US", "Ancient Dried Pig Spawn Egg");
/* 2563 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 90), new Object[] { new ItemStack(Items.water_bucket), OrePigEggStack });
/*      */     
/* 2565 */     ItemStack OreSquidEggStack = new ItemStack(MySquidSpawnBlock);
/*      */     
/* 2567 */     LanguageRegistry.instance().addNameForObject(MySquidSpawnBlock, "en_US", "Ancient Dried Squid Spawn Egg");
/* 2568 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 94), new Object[] { new ItemStack(Items.water_bucket), OreSquidEggStack });
/*      */     
/* 2570 */     ItemStack OreChickenEggStack = new ItemStack(MyChickenSpawnBlock);
/*      */     
/* 2572 */     LanguageRegistry.instance().addNameForObject(MyChickenSpawnBlock, "en_US", "Ancient Dried Chicken Spawn Egg");
/* 2573 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 93), new Object[] { new ItemStack(Items.water_bucket), OreChickenEggStack });
/*      */     
/* 2575 */     ItemStack OreCreeperEggStack = new ItemStack(MyCreeperSpawnBlock);
/*      */     
/* 2577 */     LanguageRegistry.instance().addNameForObject(MyCreeperSpawnBlock, "en_US", "Ancient Dried Creeper Spawn Egg");
/* 2578 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 50), new Object[] { new ItemStack(Items.water_bucket), OreCreeperEggStack });
/*      */     
/* 2580 */     ItemStack OreSkeletonEggStack = new ItemStack(MySkeletonSpawnBlock);
/*      */     
/* 2582 */     LanguageRegistry.instance().addNameForObject(MySkeletonSpawnBlock, "en_US", "Ancient Dried Skeleton Spawn Egg");
/* 2583 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 51), new Object[] { new ItemStack(Items.water_bucket), OreSkeletonEggStack });
/*      */     
/* 2585 */     ItemStack OreZombieEggStack = new ItemStack(MyZombieSpawnBlock);
/*      */     
/* 2587 */     LanguageRegistry.instance().addNameForObject(MyZombieSpawnBlock, "en_US", "Ancient Dried Zombie Spawn Egg");
/* 2588 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 54), new Object[] { new ItemStack(Items.water_bucket), OreZombieEggStack });
/*      */     
/* 2590 */     ItemStack OreSlimeEggStack = new ItemStack(MySlimeSpawnBlock);
/*      */     
/* 2592 */     LanguageRegistry.instance().addNameForObject(MySlimeSpawnBlock, "en_US", "Ancient Dried Slime Spawn Egg");
/* 2593 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 55), new Object[] { new ItemStack(Items.water_bucket), OreSlimeEggStack });
/*      */     
/* 2595 */     ItemStack OreGhastEggStack = new ItemStack(MyGhastSpawnBlock);
/*      */     
/* 2597 */     LanguageRegistry.instance().addNameForObject(MyGhastSpawnBlock, "en_US", "Ancient Dried Ghast Spawn Egg");
/* 2598 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 56), new Object[] { new ItemStack(Items.water_bucket), OreGhastEggStack });
/*      */     
/* 2600 */     ItemStack OreZombiePigmanEggStack = new ItemStack(MyZombiePigmanSpawnBlock);
/*      */     
/* 2602 */     LanguageRegistry.instance().addNameForObject(MyZombiePigmanSpawnBlock, "en_US", "Ancient Dried Zombie Pigman Spawn Egg");
/* 2603 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 57), new Object[] { new ItemStack(Items.water_bucket), OreZombiePigmanEggStack });
/*      */     
/* 2605 */     ItemStack OreEndermanEggStack = new ItemStack(MyEndermanSpawnBlock);
/*      */     
/* 2607 */     LanguageRegistry.instance().addNameForObject(MyEndermanSpawnBlock, "en_US", "Ancient Dried Enderman Spawn Egg");
/* 2608 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 58), new Object[] { new ItemStack(Items.water_bucket), OreEndermanEggStack });
/*      */     
/* 2610 */     ItemStack OreCaveSpiderEggStack = new ItemStack(MyCaveSpiderSpawnBlock);
/*      */     
/* 2612 */     LanguageRegistry.instance().addNameForObject(MyCaveSpiderSpawnBlock, "en_US", "Ancient Dried Cave Spider Spawn Egg");
/* 2613 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 59), new Object[] { new ItemStack(Items.water_bucket), OreCaveSpiderEggStack });
/*      */     
/* 2615 */     ItemStack OreSilverfishEggStack = new ItemStack(MySilverfishSpawnBlock);
/*      */     
/* 2617 */     LanguageRegistry.instance().addNameForObject(MySilverfishSpawnBlock, "en_US", "Ancient Dried Silverfish Spawn Egg");
/* 2618 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 60), new Object[] { new ItemStack(Items.water_bucket), OreSilverfishEggStack });
/*      */     
/* 2620 */     ItemStack OreMagmaCubeEggStack = new ItemStack(MyMagmaCubeSpawnBlock);
/*      */     
/* 2622 */     LanguageRegistry.instance().addNameForObject(MyMagmaCubeSpawnBlock, "en_US", "Ancient Dried Magma Cube Spawn Egg");
/* 2623 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 62), new Object[] { new ItemStack(Items.water_bucket), OreMagmaCubeEggStack });
/*      */     
/* 2625 */     ItemStack OreWitchEggStack = new ItemStack(MyWitchSpawnBlock);
/*      */     
/* 2627 */     LanguageRegistry.instance().addNameForObject(MyWitchSpawnBlock, "en_US", "Ancient Dried Witch Spawn Egg");
/* 2628 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 66), new Object[] { new ItemStack(Items.water_bucket), OreWitchEggStack });
/*      */     
/* 2630 */     ItemStack OreSheepEggStack = new ItemStack(MySheepSpawnBlock);
/*      */     
/* 2632 */     LanguageRegistry.instance().addNameForObject(MySheepSpawnBlock, "en_US", "Ancient Dried Sheep Spawn Egg");
/* 2633 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 91), new Object[] { new ItemStack(Items.water_bucket), OreSheepEggStack });
/*      */     
/* 2635 */     ItemStack OreWolfEggStack = new ItemStack(MyWolfSpawnBlock);
/*      */     
/* 2637 */     LanguageRegistry.instance().addNameForObject(MyWolfSpawnBlock, "en_US", "Ancient Dried Wolf Spawn Egg");
/* 2638 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 95), new Object[] { new ItemStack(Items.water_bucket), OreWolfEggStack });
/*      */     
/* 2640 */     ItemStack OreMooshroomEggStack = new ItemStack(MyMooshroomSpawnBlock);
/*      */     
/* 2642 */     LanguageRegistry.instance().addNameForObject(MyMooshroomSpawnBlock, "en_US", "Ancient Dried Mooshroom Spawn Egg");
/* 2643 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 96), new Object[] { new ItemStack(Items.water_bucket), OreMooshroomEggStack });
/*      */     
/* 2645 */     ItemStack OreOcelotEggStack = new ItemStack(MyOcelotSpawnBlock);
/*      */     
/* 2647 */     LanguageRegistry.instance().addNameForObject(MyOcelotSpawnBlock, "en_US", "Ancient Dried Ocelot Spawn Egg");
/* 2648 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 98), new Object[] { new ItemStack(Items.water_bucket), OreOcelotEggStack });
/*      */     
/* 2650 */     ItemStack OreBlazeEggStack = new ItemStack(MyBlazeSpawnBlock);
/*      */     
/* 2652 */     LanguageRegistry.instance().addNameForObject(MyBlazeSpawnBlock, "en_US", "Ancient Dried Blaze Spawn Egg");
/* 2653 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 61), new Object[] { new ItemStack(Items.water_bucket), OreBlazeEggStack });
/*      */     
/* 2655 */     ItemStack OreWitherSkeletonEggStack = new ItemStack(MyWitherSkeletonSpawnBlock);
/*      */     
/* 2657 */     LanguageRegistry.instance().addNameForObject(MyWitherSkeletonSpawnBlock, "en_US", "Ancient Dried Wither Skeleton Spawn Egg");
/* 2658 */     GameRegistry.addShapelessRecipe(new ItemStack(WitherSkeletonEgg), new Object[] { new ItemStack(Items.water_bucket), OreWitherSkeletonEggStack });
/*      */     
/* 2660 */     ItemStack OreEnderDragonEggStack = new ItemStack(MyEnderDragonSpawnBlock);
/*      */     
/* 2662 */     LanguageRegistry.instance().addNameForObject(MyEnderDragonSpawnBlock, "en_US", "Ancient Dried Ender Dragon Spawn Egg");
/* 2663 */     GameRegistry.addShapelessRecipe(new ItemStack(EnderDragonEgg), new Object[] { new ItemStack(Items.water_bucket), OreEnderDragonEggStack });
/*      */     
/* 2665 */     ItemStack OreSnowGolemEggStack = new ItemStack(MySnowGolemSpawnBlock);
/*      */     
/* 2667 */     LanguageRegistry.instance().addNameForObject(MySnowGolemSpawnBlock, "en_US", "Ancient Dried Snow Golem Spawn Egg");
/* 2668 */     GameRegistry.addShapelessRecipe(new ItemStack(SnowGolemEgg), new Object[] { new ItemStack(Items.water_bucket), OreSnowGolemEggStack });
/*      */     
/* 2670 */     ItemStack OreIronGolemEggStack = new ItemStack(MyIronGolemSpawnBlock);
/*      */     
/* 2672 */     LanguageRegistry.instance().addNameForObject(MyIronGolemSpawnBlock, "en_US", "Ancient Dried Iron Golem Spawn Egg");
/* 2673 */     GameRegistry.addShapelessRecipe(new ItemStack(IronGolemEgg), new Object[] { new ItemStack(Items.water_bucket), OreIronGolemEggStack });
/*      */     
/* 2675 */     ItemStack OreWitherBossEggStack = new ItemStack(MyWitherBossSpawnBlock);
/*      */     
/* 2677 */     LanguageRegistry.instance().addNameForObject(MyWitherBossSpawnBlock, "en_US", "Ancient Dried Wither Boss Spawn Egg");
/* 2678 */     GameRegistry.addShapelessRecipe(new ItemStack(WitherBossEgg, 1, 64), new Object[] { new ItemStack(Items.water_bucket), OreWitherBossEggStack });
/*      */     
/* 2680 */     ItemStack OreGirlfriendEggStack = new ItemStack(MyGirlfriendSpawnBlock);
/*      */     
/* 2682 */     LanguageRegistry.instance().addNameForObject(MyGirlfriendSpawnBlock, "en_US", "Ancient Dried Girlfriend Spawn Egg");
/* 2683 */     GameRegistry.addShapelessRecipe(new ItemStack(GirlfriendEgg), new Object[] { new ItemStack(Items.water_bucket), OreGirlfriendEggStack });
/*      */     
/* 2685 */     ItemStack OreBoyfriendEggStack = new ItemStack(MyBoyfriendSpawnBlock);
/*      */     
/* 2687 */     LanguageRegistry.instance().addNameForObject(MyBoyfriendSpawnBlock, "en_US", "Ancient Dried Boyfriend Spawn Egg");
/* 2688 */     GameRegistry.addShapelessRecipe(new ItemStack(BoyfriendEgg), new Object[] { new ItemStack(Items.water_bucket), OreBoyfriendEggStack });
/*      */     
/* 2690 */     ItemStack OreRedCowEggStack = new ItemStack(MyRedCowSpawnBlock);
/*      */     
/* 2692 */     LanguageRegistry.instance().addNameForObject(MyRedCowSpawnBlock, "en_US", "Ancient Dried Apple Cow Spawn Egg");
/* 2693 */     GameRegistry.addShapelessRecipe(new ItemStack(RedCowEgg), new Object[] { new ItemStack(Items.water_bucket), OreRedCowEggStack });
/*      */     
/* 2695 */     ItemStack OreCrystalCowEggStack = new ItemStack(MyCrystalCowSpawnBlock);
/*      */     
/* 2697 */     LanguageRegistry.instance().addNameForObject(MyCrystalCowSpawnBlock, "en_US", "Ancient Dried Crystal Cow Spawn Egg");
/* 2698 */     GameRegistry.addShapelessRecipe(new ItemStack(CrystalCowEgg), new Object[] { new ItemStack(Items.water_bucket), OreCrystalCowEggStack });
/*      */     
/* 2700 */     ItemStack OreVillagerEggStack = new ItemStack(MyVillagerSpawnBlock);
/*      */     
/* 2702 */     LanguageRegistry.instance().addNameForObject(MyVillagerSpawnBlock, "en_US", "Ancient Dried Villager Spawn Egg");
/* 2703 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 120), new Object[] { new ItemStack(Items.water_bucket), OreVillagerEggStack });
/*      */     
/* 2705 */     ItemStack OreGoldCowEggStack = new ItemStack(MyGoldCowSpawnBlock);
/*      */     
/* 2707 */     LanguageRegistry.instance().addNameForObject(MyGoldCowSpawnBlock, "en_US", "Ancient Dried Golden Apple Cow Spawn Egg");
/* 2708 */     GameRegistry.addShapelessRecipe(new ItemStack(GoldCowEgg), new Object[] { new ItemStack(Items.water_bucket), OreGoldCowEggStack });
/*      */     
/* 2710 */     ItemStack OreEnchantedCowEggStack = new ItemStack(MyEnchantedCowSpawnBlock);
/*      */     
/* 2712 */     LanguageRegistry.instance().addNameForObject(MyEnchantedCowSpawnBlock, "en_US", "Ancient Dried Enchanted Golden Apple Cow Spawn Egg");
/* 2713 */     GameRegistry.addShapelessRecipe(new ItemStack(EnchantedCowEgg), new Object[] { new ItemStack(Items.water_bucket), OreEnchantedCowEggStack });
/*      */     
/* 2715 */     ItemStack OreMOTHRAEggStack = new ItemStack(MyMOTHRASpawnBlock);
/*      */     
/* 2717 */     LanguageRegistry.instance().addNameForObject(MyMOTHRASpawnBlock, "en_US", "Ancient Dried MOTHRA Spawn Egg");
/* 2718 */     GameRegistry.addShapelessRecipe(new ItemStack(MOTHRAEgg), new Object[] { new ItemStack(Items.water_bucket), OreMOTHRAEggStack });
/*      */     
/* 2720 */     ItemStack OreAloEggStack = new ItemStack(MyAloSpawnBlock);
/*      */     
/* 2722 */     LanguageRegistry.instance().addNameForObject(MyAloSpawnBlock, "en_US", "Ancient Dried Alosaurus Spawn Egg");
/* 2723 */     GameRegistry.addShapelessRecipe(new ItemStack(AloEgg), new Object[] { new ItemStack(Items.water_bucket), OreAloEggStack });
/*      */     
/* 2725 */     ItemStack OreCryoEggStack = new ItemStack(MyCryoSpawnBlock);
/*      */     
/* 2727 */     LanguageRegistry.instance().addNameForObject(MyCryoSpawnBlock, "en_US", "Ancient Dried Cryolophosaurus Spawn Egg");
/* 2728 */     GameRegistry.addShapelessRecipe(new ItemStack(CryoEgg), new Object[] { new ItemStack(Items.water_bucket), OreCryoEggStack });
/*      */     
/* 2730 */     ItemStack OreCamaEggStack = new ItemStack(MyCamaSpawnBlock);
/*      */     
/* 2732 */     LanguageRegistry.instance().addNameForObject(MyCamaSpawnBlock, "en_US", "Ancient Dried Camarasaurus Spawn Egg");
/* 2733 */     GameRegistry.addShapelessRecipe(new ItemStack(CamaEgg), new Object[] { new ItemStack(Items.water_bucket), OreCamaEggStack });
/*      */     
/* 2735 */     ItemStack OreVeloEggStack = new ItemStack(MyVeloSpawnBlock);
/*      */     
/* 2737 */     LanguageRegistry.instance().addNameForObject(MyVeloSpawnBlock, "en_US", "Ancient Dried Velocity Raptor Spawn Egg");
/* 2738 */     GameRegistry.addShapelessRecipe(new ItemStack(VeloEgg), new Object[] { new ItemStack(Items.water_bucket), OreVeloEggStack });
/*      */     
/* 2740 */     ItemStack OreHydroEggStack = new ItemStack(MyHydroSpawnBlock);
/*      */     
/* 2742 */     LanguageRegistry.instance().addNameForObject(MyHydroSpawnBlock, "en_US", "Ancient Dried Hydrolisc Spawn Egg");
/* 2743 */     GameRegistry.addShapelessRecipe(new ItemStack(HydroEgg), new Object[] { new ItemStack(Items.water_bucket), OreHydroEggStack });
/*      */     
/* 2745 */     ItemStack OreBasilEggStack = new ItemStack(MyBasilSpawnBlock);
/*      */     
/* 2747 */     LanguageRegistry.instance().addNameForObject(MyBasilSpawnBlock, "en_US", "Ancient Dried Basilisk Spawn Egg");
/* 2748 */     GameRegistry.addShapelessRecipe(new ItemStack(BasilEgg), new Object[] { new ItemStack(Items.water_bucket), OreBasilEggStack });
/*      */     
/* 2750 */     ItemStack OreDragonflyEggStack = new ItemStack(MyDragonflySpawnBlock);
/*      */     
/* 2752 */     LanguageRegistry.instance().addNameForObject(MyDragonflySpawnBlock, "en_US", "Ancient Dried Dragonfly Spawn Egg");
/* 2753 */     GameRegistry.addShapelessRecipe(new ItemStack(DragonflyEgg), new Object[] { new ItemStack(Items.water_bucket), OreDragonflyEggStack });
/*      */     
/* 2755 */     ItemStack OreEmperorScorpionEggStack = new ItemStack(MyEmperorScorpionSpawnBlock);
/*      */     
/* 2757 */     LanguageRegistry.instance().addNameForObject(MyEmperorScorpionSpawnBlock, "en_US", "Ancient Dried Emperor Scorpion Spawn Egg");
/* 2758 */     GameRegistry.addShapelessRecipe(new ItemStack(EmperorScorpionEgg), new Object[] { new ItemStack(Items.water_bucket), OreEmperorScorpionEggStack });
/*      */     
/* 2760 */     ItemStack OreScorpionEggStack = new ItemStack(MyScorpionSpawnBlock);
/*      */     
/* 2762 */     LanguageRegistry.instance().addNameForObject(MyScorpionSpawnBlock, "en_US", "Ancient Dried Scorpion Spawn Egg");
/* 2763 */     GameRegistry.addShapelessRecipe(new ItemStack(ScorpionEgg), new Object[] { new ItemStack(Items.water_bucket), OreScorpionEggStack });
/*      */     
/* 2765 */     ItemStack OreCaveFisherEggStack = new ItemStack(MyCaveFisherSpawnBlock);
/*      */     
/* 2767 */     LanguageRegistry.instance().addNameForObject(MyCaveFisherSpawnBlock, "en_US", "Ancient Dried Cave Fisher Spawn Egg");
/* 2768 */     GameRegistry.addShapelessRecipe(new ItemStack(CaveFisherEgg), new Object[] { new ItemStack(Items.water_bucket), OreCaveFisherEggStack });
/*      */     
/* 2770 */     ItemStack OreSpyroEggStack = new ItemStack(MySpyroSpawnBlock);
/*      */     
/* 2772 */     LanguageRegistry.instance().addNameForObject(MySpyroSpawnBlock, "en_US", "Ancient Dried Baby Dragon Spawn Egg");
/* 2773 */     GameRegistry.addShapelessRecipe(new ItemStack(SpyroEgg), new Object[] { new ItemStack(Items.water_bucket), OreSpyroEggStack });
/*      */     
/* 2775 */     ItemStack OreBaryonyxEggStack = new ItemStack(MyBaryonyxSpawnBlock);
/*      */     
/* 2777 */     LanguageRegistry.instance().addNameForObject(MyBaryonyxSpawnBlock, "en_US", "Ancient Dried Baryonyx Spawn Egg");
/* 2778 */     GameRegistry.addShapelessRecipe(new ItemStack(BaryonyxEgg), new Object[] { new ItemStack(Items.water_bucket), OreBaryonyxEggStack });
/*      */     
/* 2780 */     ItemStack OreGammaMetroidEggStack = new ItemStack(MyGammaMetroidSpawnBlock);
/*      */     
/* 2782 */     LanguageRegistry.instance().addNameForObject(MyGammaMetroidSpawnBlock, "en_US", "Ancient Dried WTF? Spawn Egg");
/* 2783 */     GameRegistry.addShapelessRecipe(new ItemStack(GammaMetroidEgg), new Object[] { new ItemStack(Items.water_bucket), OreGammaMetroidEggStack });
/*      */     
/* 2785 */     ItemStack OreCockateilEggStack = new ItemStack(MyCockateilSpawnBlock);
/*      */     
/* 2787 */     LanguageRegistry.instance().addNameForObject(MyCockateilSpawnBlock, "en_US", "Ancient Dried Bird Spawn Egg");
/* 2788 */     GameRegistry.addShapelessRecipe(new ItemStack(CockateilEgg), new Object[] { new ItemStack(Items.water_bucket), OreCockateilEggStack });
/*      */     
/* 2790 */     ItemStack OreKyuubiEggStack = new ItemStack(MyKyuubiSpawnBlock);
/*      */     
/* 2792 */     LanguageRegistry.instance().addNameForObject(MyKyuubiSpawnBlock, "en_US", "Ancient Dried Kyuubi Spawn Egg");
/* 2793 */     GameRegistry.addShapelessRecipe(new ItemStack(KyuubiEgg), new Object[] { new ItemStack(Items.water_bucket), OreKyuubiEggStack });
/*      */     
/* 2795 */     ItemStack OreAlienEggStack = new ItemStack(MyAlienSpawnBlock);
/*      */     
/* 2797 */     LanguageRegistry.instance().addNameForObject(MyAlienSpawnBlock, "en_US", "Ancient Dried Alien Spawn Egg");
/* 2798 */     GameRegistry.addShapelessRecipe(new ItemStack(AlienEgg), new Object[] { new ItemStack(Items.water_bucket), OreAlienEggStack });
/*      */     
/* 2800 */     ItemStack OreAttackSquidEggStack = new ItemStack(MyAttackSquidSpawnBlock);
/*      */     
/* 2802 */     LanguageRegistry.instance().addNameForObject(MyAttackSquidSpawnBlock, "en_US", "Ancient Dried Attack Squid Spawn Egg");
/* 2803 */     GameRegistry.addShapelessRecipe(new ItemStack(AttackSquidEgg), new Object[] { new ItemStack(Items.water_bucket), OreAttackSquidEggStack });
/*      */     
/* 2805 */     ItemStack OreWaterDragonEggStack = new ItemStack(MyWaterDragonSpawnBlock);
/*      */     
/* 2807 */     LanguageRegistry.instance().addNameForObject(MyWaterDragonSpawnBlock, "en_US", "Ancient Dried WaterDragon Spawn Egg");
/* 2808 */     GameRegistry.addShapelessRecipe(new ItemStack(WaterDragonEgg), new Object[] { new ItemStack(Items.water_bucket), OreWaterDragonEggStack });
/*      */     
/* 2810 */     ItemStack OreKrakenEggStack = new ItemStack(MyKrakenSpawnBlock);
/*      */     
/* 2812 */     LanguageRegistry.instance().addNameForObject(MyKrakenSpawnBlock, "en_US", "Ancient Dried Kraken Spawn Egg");
/* 2813 */     GameRegistry.addShapelessRecipe(new ItemStack(KrakenEgg), new Object[] { new ItemStack(Items.water_bucket), OreKrakenEggStack });
/*      */     
/* 2815 */     ItemStack OreLizardEggStack = new ItemStack(MyLizardSpawnBlock);
/*      */     
/* 2817 */     LanguageRegistry.instance().addNameForObject(MyLizardSpawnBlock, "en_US", "Ancient Dried Lizard Spawn Egg");
/* 2818 */     GameRegistry.addShapelessRecipe(new ItemStack(LizardEgg), new Object[] { new ItemStack(Items.water_bucket), OreLizardEggStack });
/*      */     
/* 2820 */     ItemStack OreCephadromeEggStack = new ItemStack(MyCephadromeSpawnBlock);
/*      */     
/* 2822 */     LanguageRegistry.instance().addNameForObject(MyCephadromeSpawnBlock, "en_US", "Ancient Dried Cephadrome Spawn Egg");
/* 2823 */     GameRegistry.addShapelessRecipe(new ItemStack(CephadromeEgg), new Object[] { new ItemStack(Items.water_bucket), OreCephadromeEggStack });
/*      */     
/* 2825 */     ItemStack OreDragonEggStack = new ItemStack(MyDragonSpawnBlock);
/*      */     
/* 2827 */     LanguageRegistry.instance().addNameForObject(MyDragonSpawnBlock, "en_US", "Ancient Dried Dragon Spawn Egg");
/* 2828 */     GameRegistry.addShapelessRecipe(new ItemStack(DragonEgg), new Object[] { new ItemStack(Items.water_bucket), OreDragonEggStack });
/*      */     
/* 2830 */     ItemStack OreBeeEggStack = new ItemStack(MyBeeSpawnBlock);
/*      */     
/* 2832 */     LanguageRegistry.instance().addNameForObject(MyBeeSpawnBlock, "en_US", "Ancient Dried Bee Spawn Egg");
/* 2833 */     GameRegistry.addShapelessRecipe(new ItemStack(BeeEgg), new Object[] { new ItemStack(Items.water_bucket), OreBeeEggStack });
/*      */     
/* 2835 */     ItemStack OreHorseEggStack = new ItemStack(MyHorseSpawnBlock);
/*      */     
/* 2837 */     LanguageRegistry.instance().addNameForObject(MyHorseSpawnBlock, "en_US", "Ancient Dried Horse Spawn Egg");
/* 2838 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 1, 100), new Object[] { new ItemStack(Items.water_bucket), OreHorseEggStack });
/*      */     
/* 2840 */     ItemStack OreTrooperBugEggStack = new ItemStack(MyTrooperBugSpawnBlock);
/*      */     
/* 2842 */     LanguageRegistry.instance().addNameForObject(MyTrooperBugSpawnBlock, "en_US", "Ancient Dried Jumpy Bug Spawn Egg");
/* 2843 */     GameRegistry.addShapelessRecipe(new ItemStack(TrooperBugEgg), new Object[] { new ItemStack(Items.water_bucket), OreTrooperBugEggStack });
/*      */     
/* 2845 */     ItemStack OreSpitBugEggStack = new ItemStack(MySpitBugSpawnBlock);
/*      */     
/* 2847 */     LanguageRegistry.instance().addNameForObject(MySpitBugSpawnBlock, "en_US", "Ancient Dried Spit Bug Spawn Egg");
/* 2848 */     GameRegistry.addShapelessRecipe(new ItemStack(SpitBugEgg), new Object[] { new ItemStack(Items.water_bucket), OreSpitBugEggStack });
/*      */     
/* 2850 */     ItemStack OreStinkBugEggStack = new ItemStack(MyStinkBugSpawnBlock);
/*      */     
/* 2852 */     LanguageRegistry.instance().addNameForObject(MyStinkBugSpawnBlock, "en_US", "Ancient Dried Stink Bug Spawn Egg");
/* 2853 */     GameRegistry.addShapelessRecipe(new ItemStack(StinkBugEgg), new Object[] { new ItemStack(Items.water_bucket), OreStinkBugEggStack });
/*      */     
/* 2855 */     ItemStack OreOstrichEggStack = new ItemStack(MyOstrichSpawnBlock);
/*      */     
/* 2857 */     LanguageRegistry.instance().addNameForObject(MyOstrichSpawnBlock, "en_US", "Ancient Dried Ostrich Spawn Egg");
/* 2858 */     GameRegistry.addShapelessRecipe(new ItemStack(OstrichEgg), new Object[] { new ItemStack(Items.water_bucket), OreOstrichEggStack });
/*      */     
/* 2860 */     ItemStack OreGazelleEggStack = new ItemStack(MyGazelleSpawnBlock);
/*      */     
/* 2862 */     LanguageRegistry.instance().addNameForObject(MyGazelleSpawnBlock, "en_US", "Ancient Dried Gazelle Spawn Egg");
/* 2863 */     GameRegistry.addShapelessRecipe(new ItemStack(GazelleEgg), new Object[] { new ItemStack(Items.water_bucket), OreGazelleEggStack });
/*      */     
/* 2865 */     ItemStack OreChipmunkEggStack = new ItemStack(MyChipmunkSpawnBlock);
/*      */     
/* 2867 */     LanguageRegistry.instance().addNameForObject(MyChipmunkSpawnBlock, "en_US", "Ancient Dried Chipmunk Spawn Egg");
/* 2868 */     GameRegistry.addShapelessRecipe(new ItemStack(ChipmunkEgg), new Object[] { new ItemStack(Items.water_bucket), OreChipmunkEggStack });
/*      */ 
/*      */     
/* 2871 */     LanguageRegistry.instance().addNameForObject(MyCreepingHorrorSpawnBlock, "en_US", "Ancient Dried Creeping Horror Spawn Egg");
/* 2872 */     ItemStack OreCreepingHorrorEggStack = new ItemStack(MyCreepingHorrorSpawnBlock);
/* 2873 */     GameRegistry.addShapelessRecipe(new ItemStack(CreepingHorrorEgg), new Object[] { new ItemStack(Items.water_bucket), OreCreepingHorrorEggStack });
/*      */ 
/*      */     
/* 2876 */     LanguageRegistry.instance().addNameForObject(MyTerribleTerrorSpawnBlock, "en_US", "Ancient Dried Terrible Terror Spawn Egg");
/* 2877 */     ItemStack OreTerribleTerrorEggStack = new ItemStack(MyTerribleTerrorSpawnBlock);
/* 2878 */     GameRegistry.addShapelessRecipe(new ItemStack(TerribleTerrorEgg), new Object[] { new ItemStack(Items.water_bucket), OreTerribleTerrorEggStack });
/*      */ 
/*      */     
/* 2881 */     LanguageRegistry.instance().addNameForObject(MyCliffRacerSpawnBlock, "en_US", "Ancient Dried Cliff Racer Spawn Egg");
/* 2882 */     ItemStack OreCliffRacerEggStack = new ItemStack(MyCliffRacerSpawnBlock);
/* 2883 */     GameRegistry.addShapelessRecipe(new ItemStack(CliffRacerEgg), new Object[] { new ItemStack(Items.water_bucket), OreCliffRacerEggStack });
/*      */ 
/*      */     
/* 2886 */     LanguageRegistry.instance().addNameForObject(MyTriffidSpawnBlock, "en_US", "Ancient Dried Triffid Spawn Egg");
/* 2887 */     ItemStack OreTriffidEggStack = new ItemStack(MyTriffidSpawnBlock);
/* 2888 */     GameRegistry.addShapelessRecipe(new ItemStack(TriffidEgg), new Object[] { new ItemStack(Items.water_bucket), OreTriffidEggStack });
/*      */ 
/*      */     
/* 2891 */     LanguageRegistry.instance().addNameForObject(MyPitchBlackSpawnBlock, "en_US", "Ancient Dried Nightmare Spawn Egg");
/* 2892 */     ItemStack OrePitchBlackEggStack = new ItemStack(MyPitchBlackSpawnBlock);
/* 2893 */     GameRegistry.addShapelessRecipe(new ItemStack(PitchBlackEgg), new Object[] { new ItemStack(Items.water_bucket), OrePitchBlackEggStack });
/*      */ 
/*      */     
/* 2896 */     LanguageRegistry.instance().addNameForObject(MyLurkingTerrorSpawnBlock, "en_US", "Ancient Dried Lurking Terror Spawn Egg");
/* 2897 */     ItemStack OreLurkingTerrorEggStack = new ItemStack(MyLurkingTerrorSpawnBlock);
/* 2898 */     GameRegistry.addShapelessRecipe(new ItemStack(LurkingTerrorEgg), new Object[] { new ItemStack(Items.water_bucket), OreLurkingTerrorEggStack });
/*      */ 
/*      */     
/* 2901 */     LanguageRegistry.instance().addNameForObject(MyEnderKnightSpawnBlock, "en_US", "Ancient Dried Ender Knight Spawn Egg");
/* 2902 */     ItemStack OreEnderKnightEggStack = new ItemStack(MyEnderKnightSpawnBlock);
/* 2903 */     GameRegistry.addShapelessRecipe(new ItemStack(EnderKnightEgg), new Object[] { new ItemStack(Items.water_bucket), OreEnderKnightEggStack });
/*      */ 
/*      */     
/* 2906 */     LanguageRegistry.instance().addNameForObject(MyEnderReaperSpawnBlock, "en_US", "Ancient Dried Ender Reaper Spawn Egg");
/* 2907 */     ItemStack OreEnderReaperEggStack = new ItemStack(MyEnderReaperSpawnBlock);
/* 2908 */     GameRegistry.addShapelessRecipe(new ItemStack(EnderReaperEgg), new Object[] { new ItemStack(Items.water_bucket), OreEnderReaperEggStack });
/*      */ 
/*      */     
/* 2911 */     LanguageRegistry.instance().addNameForObject(MyGodzillaPartSpawnBlock, "en_US", "Ancient Dried Mobzilla Spawn Egg Part");
/* 2912 */     ItemStack OreGodzillaPartEggStack = new ItemStack(MyGodzillaPartSpawnBlock);
/* 2913 */     GameRegistry.addShapelessRecipe(new ItemStack(MyGodzillaSpawnBlock), new Object[] { OreGodzillaPartEggStack, OreGodzillaPartEggStack, OreGodzillaPartEggStack, OreGodzillaPartEggStack, OreGodzillaPartEggStack, OreGodzillaPartEggStack, OreGodzillaPartEggStack, OreGodzillaPartEggStack, OreGodzillaPartEggStack });
/*      */ 
/*      */ 
/*      */     
/* 2917 */     LanguageRegistry.instance().addNameForObject(MyGodzillaSpawnBlock, "en_US", "Ancient Dried Mobzilla Spawn Egg");
/* 2918 */     ItemStack OreGodzillaEggStack = new ItemStack(MyGodzillaSpawnBlock);
/* 2919 */     GameRegistry.addShapelessRecipe(new ItemStack(GodzillaEgg), new Object[] { new ItemStack(Items.water_bucket), OreGodzillaEggStack });
/*      */ 
/*      */     
/* 2922 */     LanguageRegistry.instance().addNameForObject(MyTheKingPartSpawnBlock, "en_US", "Ancient Dried The King Spawn Egg Part");
/* 2923 */     ItemStack OreTheKingPartEggStack = new ItemStack(MyTheKingPartSpawnBlock);
/* 2924 */     GameRegistry.addShapelessRecipe(new ItemStack(MyTheKingSpawnBlock), new Object[] { OreTheKingPartEggStack, OreTheKingPartEggStack, OreTheKingPartEggStack, OreTheKingPartEggStack, OreTheKingPartEggStack, OreTheKingPartEggStack, OreTheKingPartEggStack, OreTheKingPartEggStack, OreTheKingPartEggStack });
/*      */ 
/*      */ 
/*      */     
/* 2928 */     LanguageRegistry.instance().addNameForObject(MyTheKingSpawnBlock, "en_US", "Ancient Dried The King Spawn Egg");
/* 2929 */     ItemStack OreTheKingEggStack = new ItemStack(MyTheKingSpawnBlock);
/* 2930 */     GameRegistry.addShapelessRecipe(new ItemStack(TheKingEgg), new Object[] { new ItemStack(Items.water_bucket), OreTheKingEggStack });
/*      */ 
/*      */     
/* 2933 */     LanguageRegistry.instance().addNameForObject(MyTheQueenPartSpawnBlock, "en_US", "Ancient Dried The Queen Spawn Egg Part");
/* 2934 */     ItemStack OreTheQueenPartEggStack = new ItemStack(MyTheQueenPartSpawnBlock);
/* 2935 */     GameRegistry.addShapelessRecipe(new ItemStack(MyTheQueenSpawnBlock), new Object[] { OreTheQueenPartEggStack, OreTheQueenPartEggStack, OreTheQueenPartEggStack, OreTheQueenPartEggStack, OreTheQueenPartEggStack, OreTheQueenPartEggStack, OreTheQueenPartEggStack, OreTheQueenPartEggStack, OreTheQueenPartEggStack });
/*      */ 
/*      */ 
/*      */     
/* 2939 */     LanguageRegistry.instance().addNameForObject(MyTheQueenSpawnBlock, "en_US", "Ancient Dried The Queen Spawn Egg");
/* 2940 */     ItemStack OreTheQueenEggStack = new ItemStack(MyTheQueenSpawnBlock);
/* 2941 */     GameRegistry.addShapelessRecipe(new ItemStack(TheQueenEgg), new Object[] { new ItemStack(Items.water_bucket), OreTheQueenEggStack });
/*      */ 
/*      */     
/* 2944 */     LanguageRegistry.instance().addNameForObject(MySmallWormSpawnBlock, "en_US", "Ancient Dried Small Worm Spawn Egg");
/* 2945 */     ItemStack OreSmallWormEggStack = new ItemStack(MySmallWormSpawnBlock);
/* 2946 */     GameRegistry.addShapelessRecipe(new ItemStack(SmallWormEgg), new Object[] { new ItemStack(Items.water_bucket), OreSmallWormEggStack });
/*      */ 
/*      */     
/* 2949 */     LanguageRegistry.instance().addNameForObject(MyMediumWormSpawnBlock, "en_US", "Ancient Dried Medium Worm Spawn Egg");
/* 2950 */     ItemStack OreMediumWormEggStack = new ItemStack(MyMediumWormSpawnBlock);
/* 2951 */     GameRegistry.addShapelessRecipe(new ItemStack(MediumWormEgg), new Object[] { new ItemStack(Items.water_bucket), OreMediumWormEggStack });
/*      */ 
/*      */     
/* 2954 */     LanguageRegistry.instance().addNameForObject(MyLargeWormSpawnBlock, "en_US", "Ancient Dried Large Worm Spawn Egg");
/* 2955 */     ItemStack OreLargeWormEggStack = new ItemStack(MyLargeWormSpawnBlock);
/* 2956 */     GameRegistry.addShapelessRecipe(new ItemStack(LargeWormEgg), new Object[] { new ItemStack(Items.water_bucket), OreLargeWormEggStack });
/*      */ 
/*      */     
/* 2959 */     LanguageRegistry.instance().addNameForObject(MyCassowarySpawnBlock, "en_US", "Ancient Dried Cassowary Spawn Egg");
/* 2960 */     ItemStack OreCassowaryEggStack = new ItemStack(MyCassowarySpawnBlock);
/* 2961 */     GameRegistry.addShapelessRecipe(new ItemStack(CassowaryEgg), new Object[] { new ItemStack(Items.water_bucket), OreCassowaryEggStack });
/*      */ 
/*      */     
/* 2964 */     LanguageRegistry.instance().addNameForObject(MyCloudSharkSpawnBlock, "en_US", "Ancient Dried Cloud Shark Spawn Egg");
/* 2965 */     ItemStack OreCloudSharkEggStack = new ItemStack(MyCloudSharkSpawnBlock);
/* 2966 */     GameRegistry.addShapelessRecipe(new ItemStack(CloudSharkEgg), new Object[] { new ItemStack(Items.water_bucket), OreCloudSharkEggStack });
/*      */ 
/*      */     
/* 2969 */     LanguageRegistry.instance().addNameForObject(MyGoldFishSpawnBlock, "en_US", "Ancient Dried Gold Fish Spawn Egg");
/* 2970 */     ItemStack OreGoldFishEggStack = new ItemStack(MyGoldFishSpawnBlock);
/* 2971 */     GameRegistry.addShapelessRecipe(new ItemStack(GoldFishEgg), new Object[] { new ItemStack(Items.water_bucket), OreGoldFishEggStack });
/*      */ 
/*      */     
/* 2974 */     LanguageRegistry.instance().addNameForObject(MyLeafMonsterSpawnBlock, "en_US", "Ancient Dried Leaf Monster Spawn Egg");
/* 2975 */     ItemStack OreLeafMonsterEggStack = new ItemStack(MyLeafMonsterSpawnBlock);
/* 2976 */     GameRegistry.addShapelessRecipe(new ItemStack(LeafMonsterEgg), new Object[] { new ItemStack(Items.water_bucket), OreLeafMonsterEggStack });
/*      */ 
/*      */     
/* 2979 */     LanguageRegistry.instance().addNameForObject(MyTshirtSpawnBlock, "en_US", "Ancient Dried T-Shirt Spawn Egg");
/* 2980 */     ItemStack OreTshirtEggStack = new ItemStack(MyTshirtSpawnBlock);
/* 2981 */     GameRegistry.addShapelessRecipe(new ItemStack(TshirtEgg), new Object[] { new ItemStack(Items.water_bucket), OreTshirtEggStack });
/*      */ 
/*      */     
/* 2984 */     LanguageRegistry.instance().addNameForObject(MyBeaverSpawnBlock, "en_US", "Ancient Dried Beaver Spawn Egg");
/* 2985 */     ItemStack OreBeaverEggStack = new ItemStack(MyBeaverSpawnBlock);
/* 2986 */     GameRegistry.addShapelessRecipe(new ItemStack(BeaverEgg), new Object[] { new ItemStack(Items.water_bucket), OreBeaverEggStack });
/*      */ 
/*      */     
/* 2989 */     LanguageRegistry.instance().addNameForObject(MyUrchinSpawnBlock, "en_US", "Ancient Dried Urchin Spawn Egg");
/* 2990 */     ItemStack OreUrchinEggStack = new ItemStack(MyUrchinSpawnBlock);
/* 2991 */     GameRegistry.addShapelessRecipe(new ItemStack(UrchinEgg), new Object[] { new ItemStack(Items.water_bucket), OreUrchinEggStack });
/*      */ 
/*      */     
/* 2994 */     LanguageRegistry.instance().addNameForObject(MyFlounderSpawnBlock, "en_US", "Ancient Dried Flounder Spawn Egg");
/* 2995 */     ItemStack OreFlounderEggStack = new ItemStack(MyFlounderSpawnBlock);
/* 2996 */     GameRegistry.addShapelessRecipe(new ItemStack(FlounderEgg), new Object[] { new ItemStack(Items.water_bucket), OreFlounderEggStack });
/*      */ 
/*      */     
/* 2999 */     LanguageRegistry.instance().addNameForObject(MySkateSpawnBlock, "en_US", "Ancient Dried Skate Spawn Egg");
/* 3000 */     ItemStack OreSkateEggStack = new ItemStack(MySkateSpawnBlock);
/* 3001 */     GameRegistry.addShapelessRecipe(new ItemStack(SkateEgg), new Object[] { new ItemStack(Items.water_bucket), OreSkateEggStack });
/*      */ 
/*      */     
/* 3004 */     LanguageRegistry.instance().addNameForObject(MyRotatorSpawnBlock, "en_US", "Ancient Dried Rotator Spawn Egg");
/* 3005 */     ItemStack OreRotatorEggStack = new ItemStack(MyRotatorSpawnBlock);
/* 3006 */     GameRegistry.addShapelessRecipe(new ItemStack(RotatorEgg), new Object[] { new ItemStack(Items.water_bucket), OreRotatorEggStack });
/*      */ 
/*      */     
/* 3009 */     LanguageRegistry.instance().addNameForObject(MyPeacockSpawnBlock, "en_US", "Ancient Dried Peacock Spawn Egg");
/* 3010 */     ItemStack OrePeacockEggStack = new ItemStack(MyPeacockSpawnBlock);
/* 3011 */     GameRegistry.addShapelessRecipe(new ItemStack(PeacockEgg), new Object[] { new ItemStack(Items.water_bucket), OrePeacockEggStack });
/*      */ 
/*      */     
/* 3014 */     LanguageRegistry.instance().addNameForObject(MyFairySpawnBlock, "en_US", "Ancient Dried Fairy Spawn Egg");
/* 3015 */     ItemStack OreFairyEggStack = new ItemStack(MyFairySpawnBlock);
/* 3016 */     GameRegistry.addShapelessRecipe(new ItemStack(FairyEgg), new Object[] { new ItemStack(Items.water_bucket), OreFairyEggStack });
/*      */ 
/*      */     
/* 3019 */     LanguageRegistry.instance().addNameForObject(MyDungeonBeastSpawnBlock, "en_US", "Ancient Dried Dungeon Beast Spawn Egg");
/* 3020 */     ItemStack OreDungeonBeastEggStack = new ItemStack(MyDungeonBeastSpawnBlock);
/* 3021 */     GameRegistry.addShapelessRecipe(new ItemStack(DungeonBeastEgg), new Object[] { new ItemStack(Items.water_bucket), OreDungeonBeastEggStack });
/*      */ 
/*      */     
/* 3024 */     LanguageRegistry.instance().addNameForObject(MyVortexSpawnBlock, "en_US", "Ancient Dried Vortex Spawn Egg");
/* 3025 */     ItemStack OreVortexEggStack = new ItemStack(MyVortexSpawnBlock);
/* 3026 */     GameRegistry.addShapelessRecipe(new ItemStack(VortexEgg), new Object[] { new ItemStack(Items.water_bucket), OreVortexEggStack });
/*      */ 
/*      */     
/* 3029 */     LanguageRegistry.instance().addNameForObject(MyRatSpawnBlock, "en_US", "Ancient Dried Rat Spawn Egg");
/* 3030 */     ItemStack OreRatEggStack = new ItemStack(MyRatSpawnBlock);
/* 3031 */     GameRegistry.addShapelessRecipe(new ItemStack(RatEgg), new Object[] { new ItemStack(Items.water_bucket), OreRatEggStack });
/*      */ 
/*      */     
/* 3034 */     LanguageRegistry.instance().addNameForObject(MyWhaleSpawnBlock, "en_US", "Ancient Dried Whale Spawn Egg");
/* 3035 */     ItemStack OreWhaleEggStack = new ItemStack(MyWhaleSpawnBlock);
/* 3036 */     GameRegistry.addShapelessRecipe(new ItemStack(WhaleEgg), new Object[] { new ItemStack(Items.water_bucket), OreWhaleEggStack });
/*      */ 
/*      */     
/* 3039 */     LanguageRegistry.instance().addNameForObject(MyIrukandjiSpawnBlock, "en_US", "Ancient Dried Irukandji Spawn Egg");
/* 3040 */     ItemStack OreIrukandjiEggStack = new ItemStack(MyIrukandjiSpawnBlock);
/* 3041 */     GameRegistry.addShapelessRecipe(new ItemStack(IrukandjiEgg), new Object[] { new ItemStack(Items.water_bucket), OreIrukandjiEggStack });
/*      */ 
/*      */     
/* 3044 */     LanguageRegistry.instance().addNameForObject(MyTRexSpawnBlock, "en_US", "Ancient Dried T. Rex Spawn Egg");
/* 3045 */     ItemStack OreTRexEggStack = new ItemStack(MyTRexSpawnBlock);
/* 3046 */     GameRegistry.addShapelessRecipe(new ItemStack(TRexEgg), new Object[] { new ItemStack(Items.water_bucket), OreTRexEggStack });
/*      */ 
/*      */     
/* 3049 */     LanguageRegistry.instance().addNameForObject(MyHerculesSpawnBlock, "en_US", "Ancient Dried Hercules Beetle Spawn Egg");
/* 3050 */     ItemStack OreHerculesEggStack = new ItemStack(MyHerculesSpawnBlock);
/* 3051 */     GameRegistry.addShapelessRecipe(new ItemStack(HerculesEgg), new Object[] { new ItemStack(Items.water_bucket), OreHerculesEggStack });
/*      */ 
/*      */     
/* 3054 */     LanguageRegistry.instance().addNameForObject(MyMantisSpawnBlock, "en_US", "Ancient Dried Mantis Spawn Egg");
/* 3055 */     ItemStack OreMantisEggStack = new ItemStack(MyMantisSpawnBlock);
/* 3056 */     GameRegistry.addShapelessRecipe(new ItemStack(MantisEgg), new Object[] { new ItemStack(Items.water_bucket), OreMantisEggStack });
/*      */ 
/*      */     
/* 3059 */     LanguageRegistry.instance().addNameForObject(MyStinkySpawnBlock, "en_US", "Ancient Dried Stinky Spawn Egg");
/* 3060 */     ItemStack OreStinkyEggStack = new ItemStack(MyStinkySpawnBlock);
/* 3061 */     GameRegistry.addShapelessRecipe(new ItemStack(StinkyEgg), new Object[] { new ItemStack(Items.water_bucket), OreStinkyEggStack });
/*      */ 
/*      */     
/* 3064 */     LanguageRegistry.instance().addNameForObject(MyEasterBunnySpawnBlock, "en_US", "Ancient Dried Easter Bunny Spawn Egg");
/* 3065 */     ItemStack OreEasterBunnyEggStack = new ItemStack(MyEasterBunnySpawnBlock);
/* 3066 */     GameRegistry.addShapelessRecipe(new ItemStack(EasterBunnyEgg), new Object[] { new ItemStack(Items.water_bucket), OreEasterBunnyEggStack });
/*      */ 
/*      */     
/* 3069 */     LanguageRegistry.instance().addNameForObject(MyCriminalSpawnBlock, "en_US", "Ancient Dried Criminal Spawn Egg");
/* 3070 */     ItemStack OreCriminalEggStack = new ItemStack(MyCriminalSpawnBlock);
/* 3071 */     GameRegistry.addShapelessRecipe(new ItemStack(CriminalEgg), new Object[] { new ItemStack(Items.water_bucket), OreCriminalEggStack });
/*      */ 
/*      */     
/* 3074 */     LanguageRegistry.instance().addNameForObject(MyBrutalflySpawnBlock, "en_US", "Ancient Dried Brutalfly Spawn Egg");
/* 3075 */     ItemStack OreBrutalflyEggStack = new ItemStack(MyBrutalflySpawnBlock);
/* 3076 */     GameRegistry.addShapelessRecipe(new ItemStack(BrutalflyEgg), new Object[] { new ItemStack(Items.water_bucket), OreBrutalflyEggStack });
/*      */ 
/*      */     
/* 3079 */     LanguageRegistry.instance().addNameForObject(MyNastysaurusSpawnBlock, "en_US", "Ancient Dried Nastysaurus Spawn Egg");
/* 3080 */     ItemStack OreNastysaurusEggStack = new ItemStack(MyNastysaurusSpawnBlock);
/* 3081 */     GameRegistry.addShapelessRecipe(new ItemStack(NastysaurusEgg), new Object[] { new ItemStack(Items.water_bucket), OreNastysaurusEggStack });
/*      */ 
/*      */     
/* 3084 */     LanguageRegistry.instance().addNameForObject(MyPointysaurusSpawnBlock, "en_US", "Ancient Dried Pointysaurus Spawn Egg");
/* 3085 */     ItemStack OrePointysaurusEggStack = new ItemStack(MyPointysaurusSpawnBlock);
/* 3086 */     GameRegistry.addShapelessRecipe(new ItemStack(PointysaurusEgg), new Object[] { new ItemStack(Items.water_bucket), OrePointysaurusEggStack });
/*      */ 
/*      */     
/* 3089 */     LanguageRegistry.instance().addNameForObject(MyCricketSpawnBlock, "en_US", "Ancient Dried Cricket Spawn Egg");
/* 3090 */     ItemStack OreCricketEggStack = new ItemStack(MyCricketSpawnBlock);
/* 3091 */     GameRegistry.addShapelessRecipe(new ItemStack(CricketEgg), new Object[] { new ItemStack(Items.water_bucket), OreCricketEggStack });
/*      */ 
/*      */     
/* 3094 */     LanguageRegistry.instance().addNameForObject(MyFrogSpawnBlock, "en_US", "Ancient Dried Frog Spawn Egg");
/* 3095 */     ItemStack OreFrogEggStack = new ItemStack(MyFrogSpawnBlock);
/* 3096 */     GameRegistry.addShapelessRecipe(new ItemStack(FrogEgg), new Object[] { new ItemStack(Items.water_bucket), OreFrogEggStack });
/*      */ 
/*      */     
/* 3099 */     LanguageRegistry.instance().addNameForObject(MySpiderDriverSpawnBlock, "en_US", "Ancient Dried Spider Driver Spawn Egg");
/* 3100 */     ItemStack OreSpiderDriverEggStack = new ItemStack(MySpiderDriverSpawnBlock);
/* 3101 */     GameRegistry.addShapelessRecipe(new ItemStack(SpiderDriverEgg), new Object[] { new ItemStack(Items.water_bucket), OreSpiderDriverEggStack });
/*      */ 
/*      */     
/* 3104 */     LanguageRegistry.instance().addNameForObject(MyCrabSpawnBlock, "en_US", "Ancient Dried Crab Spawn Egg");
/* 3105 */     ItemStack OreCrabEggStack = new ItemStack(MyCrabSpawnBlock);
/* 3106 */     GameRegistry.addShapelessRecipe(new ItemStack(CrabEgg), new Object[] { new ItemStack(Items.water_bucket), OreCrabEggStack });
/*      */ 
/*      */     
/* 3109 */     LanguageRegistry.instance().addNameForObject(MyCaterKillerSpawnBlock, "en_US", "Ancient Dried CaterKiller Spawn Egg");
/* 3110 */     ItemStack OreCaterKillerEggStack = new ItemStack(MyCaterKillerSpawnBlock);
/* 3111 */     GameRegistry.addShapelessRecipe(new ItemStack(CaterKillerEgg), new Object[] { new ItemStack(Items.water_bucket), OreCaterKillerEggStack });
/*      */ 
/*      */     
/* 3114 */     LanguageRegistry.instance().addNameForObject(MyMolenoidSpawnBlock, "en_US", "Ancient Dried Molenoid Spawn Egg");
/* 3115 */     ItemStack OreMolenoidEggStack = new ItemStack(MyMolenoidSpawnBlock);
/* 3116 */     GameRegistry.addShapelessRecipe(new ItemStack(MolenoidEgg), new Object[] { new ItemStack(Items.water_bucket), OreMolenoidEggStack });
/*      */ 
/*      */     
/* 3119 */     LanguageRegistry.instance().addNameForObject(MySeaMonsterSpawnBlock, "en_US", "Ancient Dried Sea Monster Spawn Egg");
/* 3120 */     ItemStack OreSeaMonsterEggStack = new ItemStack(MySeaMonsterSpawnBlock);
/* 3121 */     GameRegistry.addShapelessRecipe(new ItemStack(SeaMonsterEgg), new Object[] { new ItemStack(Items.water_bucket), OreSeaMonsterEggStack });
/*      */ 
/*      */     
/* 3124 */     LanguageRegistry.instance().addNameForObject(MySeaViperSpawnBlock, "en_US", "Ancient Dried Sea Viper Spawn Egg");
/* 3125 */     ItemStack OreSeaViperEggStack = new ItemStack(MySeaViperSpawnBlock);
/* 3126 */     GameRegistry.addShapelessRecipe(new ItemStack(SeaViperEgg), new Object[] { new ItemStack(Items.water_bucket), OreSeaViperEggStack });
/*      */ 
/*      */     
/* 3129 */     LanguageRegistry.instance().addNameForObject(MyRubberDuckySpawnBlock, "en_US", "Ancient Dried Rubber Ducky Spawn Egg");
/* 3130 */     ItemStack OreRubberDuckyEggStack = new ItemStack(MyRubberDuckySpawnBlock);
/* 3131 */     GameRegistry.addShapelessRecipe(new ItemStack(RubberDuckyEgg), new Object[] { new ItemStack(Items.water_bucket), OreRubberDuckyEggStack });
/*      */ 
/*      */     
/* 3134 */     LanguageRegistry.instance().addNameForObject(MyHammerheadSpawnBlock, "en_US", "Ancient Dried Hammerhead Spawn Egg");
/* 3135 */     ItemStack OreHammerheadEggStack = new ItemStack(MyHammerheadSpawnBlock);
/* 3136 */     GameRegistry.addShapelessRecipe(new ItemStack(HammerheadEgg), new Object[] { new ItemStack(Items.water_bucket), OreHammerheadEggStack });
/*      */ 
/*      */     
/* 3139 */     LanguageRegistry.instance().addNameForObject(MyLeonSpawnBlock, "en_US", "Ancient Dried Leonopteryx Spawn Egg");
/* 3140 */     ItemStack OreLeonEggStack = new ItemStack(MyLeonSpawnBlock);
/* 3141 */     GameRegistry.addShapelessRecipe(new ItemStack(LeonEgg), new Object[] { new ItemStack(Items.water_bucket), OreLeonEggStack });
/*      */ 
/*      */     
/* 3144 */     ItemStack OreUraniumStack = new ItemStack(MyOreUraniumBlock);
/*      */     
/* 3146 */     LanguageRegistry.instance().addNameForObject(MyOreUraniumBlock, "en_US", "Uranium Ore");
/*      */     
/* 3148 */     ItemStack OreTitaniumStack = new ItemStack(MyOreTitaniumBlock);
/*      */     
/* 3150 */     LanguageRegistry.instance().addNameForObject(MyOreTitaniumBlock, "en_US", "Titanium Ore");
/*      */     
/* 3152 */     ItemStack OreSaltStack = new ItemStack(MyOreSaltBlock);
/*      */     
/* 3154 */     LanguageRegistry.instance().addNameForObject(MyOreSaltBlock, "en_US", "Salt Ore");
/*      */     
/* 3156 */     ItemStack OreCrystalStoneStack = new ItemStack(CrystalStone);
/*      */     
/* 3158 */     LanguageRegistry.instance().addNameForObject(CrystalStone, "en_US", "Kyanite");
/*      */     
/* 3160 */     ItemStack OreCrystalRatStack = new ItemStack(CrystalRat);
/*      */     
/* 3162 */     LanguageRegistry.instance().addNameForObject(CrystalRat, "en_US", "Crystalized Rats");
/*      */     
/* 3164 */     ItemStack OreRedAntTrollStack = new ItemStack(RedAntTroll);
/*      */     
/* 3166 */     LanguageRegistry.instance().addNameForObject(RedAntTroll, "en_US", "Red Ant Troll Block");
/*      */     
/* 3168 */     ItemStack OreTermiteTrollStack = new ItemStack(TermiteTroll);
/*      */     
/* 3170 */     LanguageRegistry.instance().addNameForObject(TermiteTroll, "en_US", "Termite Troll Block");
/*      */     
/* 3172 */     ItemStack OreCrystalFairyStack = new ItemStack(CrystalFairy);
/*      */     
/* 3174 */     LanguageRegistry.instance().addNameForObject(CrystalFairy, "en_US", "Crystalized Fairies");
/*      */     
/* 3176 */     ItemStack OreCrystalCrystalStack = new ItemStack(CrystalCrystal);
/*      */     
/* 3178 */     LanguageRegistry.instance().addNameForObject(CrystalCrystal, "en_US", "Pink Tourmaline");
/*      */     
/* 3180 */     ItemStack OreTigersEyeStack = new ItemStack(TigersEye);
/*      */     
/* 3182 */     LanguageRegistry.instance().addNameForObject(TigersEye, "en_US", "Tiger's Eye");
/*      */     
/* 3184 */     ItemStack OreCrystalCoalStack = new ItemStack(CrystalCoal);
/*      */     
/* 3186 */     LanguageRegistry.instance().addNameForObject(CrystalCoal, "en_US", "Crystal Energy");
/*      */     
/* 3188 */     ItemStack OreCrystalGrassStack = new ItemStack(CrystalGrass);
/*      */     
/* 3190 */     LanguageRegistry.instance().addNameForObject(CrystalGrass, "en_US", "Crystal Grass");
/*      */     
/* 3192 */     ItemStack OreRubyStack = new ItemStack(MyOreRubyBlock);
/*      */     
/* 3194 */     LanguageRegistry.instance().addNameForObject(MyOreRubyBlock, "en_US", "Ruby Ore");
/*      */     
/* 3196 */     ItemStack OreAmethystStack = new ItemStack(MyOreAmethystBlock);
/*      */     
/* 3198 */     LanguageRegistry.instance().addNameForObject(MyOreAmethystBlock, "en_US", "Amethyst Ore");
/*      */ 
/*      */     
/* 3201 */     ItemStack BlockUraniumStack = new ItemStack(MyBlockUraniumBlock);
/*      */     
/* 3203 */     LanguageRegistry.instance().addNameForObject(MyBlockUraniumBlock, "en_US", "Uranium Block");
/*      */     
/* 3205 */     ItemStack LavafoamStack = new ItemStack(MyLavafoamBlock);
/*      */     
/* 3207 */     LanguageRegistry.instance().addNameForObject(MyLavafoamBlock, "en_US", "Lava Foam");
/*      */     
/* 3209 */     ItemStack BlockTitaniumStack = new ItemStack(MyBlockTitaniumBlock);
/*      */     
/* 3211 */     LanguageRegistry.instance().addNameForObject(MyBlockTitaniumBlock, "en_US", "Titanium Block");
/*      */     
/* 3213 */     ItemStack BlockMobzillaScaleStack = new ItemStack(MyBlockMobzillaScaleBlock);
/*      */     
/* 3215 */     LanguageRegistry.instance().addNameForObject(MyBlockMobzillaScaleBlock, "en_US", "Mobzilla Scale Block");
/*      */     
/* 3217 */     ItemStack BlockRubyStack = new ItemStack(MyBlockRubyBlock);
/*      */     
/* 3219 */     LanguageRegistry.instance().addNameForObject(MyBlockRubyBlock, "en_US", "Ruby Block");
/*      */     
/* 3221 */     ItemStack BlockAmethystStack = new ItemStack(MyBlockAmethystBlock);
/*      */     
/* 3223 */     LanguageRegistry.instance().addNameForObject(MyBlockAmethystBlock, "en_US", "Amethyst Block");
/*      */     
/* 3225 */     ItemStack BlockCrystalPinkStack = new ItemStack(MyCrystalPinkBlock);
/*      */     
/* 3227 */     LanguageRegistry.instance().addNameForObject(MyCrystalPinkBlock, "en_US", "Pink Tourmaline Block");
/*      */     
/* 3229 */     ItemStack BlockTigersEyeStack = new ItemStack(MyTigersEyeBlock);
/*      */     
/* 3231 */     LanguageRegistry.instance().addNameForObject(MyTigersEyeBlock, "en_US", "Tiger's Eye Block");
/*      */     
/* 3233 */     ItemStack EnderPearlStack = new ItemStack(MyEnderPearlBlock);
/*      */     
/* 3235 */     LanguageRegistry.instance().addNameForObject(MyEnderPearlBlock, "en_US", "Ender-Pearl Block");
/*      */     
/* 3237 */     ItemStack EyeOfEnderStack = new ItemStack(MyEyeOfEnderBlock);
/*      */     
/* 3239 */     LanguageRegistry.instance().addNameForObject(MyEyeOfEnderBlock, "en_US", "Eye-of-Ender Block");
/*      */ 
/*      */     
/* 3242 */     LanguageRegistry.instance().addNameForObject(MyRTPBlock, "en_US", "Random Teleport Block");
/*      */ 
/*      */     
/* 3245 */     LanguageRegistry.instance().addNameForObject(MyMoleDirtBlock, "en_US", "Molenoid Dirt");
/*      */     
/* 3247 */     ItemStack CrystalPlanksStack = new ItemStack(CrystalPlanksBlock);
/*      */     
/* 3249 */     LanguageRegistry.instance().addNameForObject(CrystalPlanksBlock, "en_US", "Crystal Planks");
/*      */     
/* 3251 */     ItemStack CrystalWorkbenchStack = new ItemStack(CrystalWorkbenchBlock);
/*      */     
/* 3253 */     LanguageRegistry.instance().addNameForObject(CrystalWorkbenchBlock, "en_US", "Crystal Workbench");
/*      */ 
/*      */     
/* 3256 */     ItemStack CrystalFurnaceStack = new ItemStack((Block)CrystalFurnaceBlock);
/*      */     
/* 3258 */     LanguageRegistry.instance().addNameForObject(CrystalFurnaceBlock, "en_US", "Crystal Furnace");
/*      */     
/* 3260 */     ItemStack CrystalFurnaceOnStack = new ItemStack(CrystalFurnaceOnBlock);
/*      */     
/* 3262 */     LanguageRegistry.instance().addNameForObject(CrystalFurnaceOnBlock, "en_US", "Crystal Furnace");
/*      */     
/* 3264 */     GameRegistry.addShapelessRecipe(new ItemStack(CrystalPlanksBlock, 4), new Object[] { MyCrystalTreeLog });
/* 3265 */     GameRegistry.addShapelessRecipe(new ItemStack(CrystalWorkbenchBlock), new Object[] { CrystalPlanksBlock, CrystalPlanksBlock, CrystalPlanksBlock, CrystalPlanksBlock });
/*      */     
/* 3267 */     GameRegistry.addRecipe(new ItemStack((Block)CrystalFurnaceBlock), new Object[] { "FFF", "F F", "FFF", Character.valueOf('F'), CrystalStone });
/*      */ 
/*      */     
/* 3270 */     GameRegistry.addRecipe(new ItemStack((Block)Blocks.chest), new Object[] { "FFF", "F F", "FFF", Character.valueOf('F'), CrystalPlanksBlock });
/*      */ 
/*      */     
/* 3273 */     GameRegistry.addRecipe(new ItemStack(Items.wooden_door), new Object[] { "FF ", "FF ", "FF ", Character.valueOf('F'), CrystalPlanksBlock });
/*      */ 
/*      */     
/* 3276 */     GameRegistry.addRecipe(new ItemStack(Items.wooden_door), new Object[] { " FF", " FF", " FF", Character.valueOf('F'), CrystalPlanksBlock });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3285 */     LanguageRegistry.instance().addNameForObject(MyAntBlock, "en_US", "Ant Nest");
/* 3286 */     LanguageRegistry.instance().addNameForObject(MyRedAntBlock, "en_US", "Red Ant Nest");
/* 3287 */     LanguageRegistry.instance().addNameForObject(MyRainbowAntBlock, "en_US", "Rainbow Ant Nest");
/* 3288 */     LanguageRegistry.instance().addNameForObject(MyUnstableAntBlock, "en_US", "Unstable Ant Nest");
/* 3289 */     LanguageRegistry.instance().addNameForObject(TermiteBlock, "en_US", "Termite Nest");
/* 3290 */     LanguageRegistry.instance().addNameForObject(CrystalTermiteBlock, "en_US", "Crystal Termite Nest");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3296 */     GameRegistry.addSmelting(MyOreUraniumBlock, new ItemStack(UraniumNugget), 0.3F);
/* 3297 */     LanguageRegistry.instance().addNameForObject(MyIngotUranium, "en_US", "Uranium Ingot");
/* 3298 */     GameRegistry.addSmelting(MyOreTitaniumBlock, new ItemStack(TitaniumNugget), 0.3F);
/* 3299 */     LanguageRegistry.instance().addNameForObject(MyIngotTitanium, "en_US", "Titanium Ingot");
/* 3300 */     GameRegistry.addSmelting(MyOreSaltBlock, new ItemStack(MySalt, 8), 0.1F);
/* 3301 */     LanguageRegistry.instance().addNameForObject(MySalt, "en_US", "Salt");
/* 3302 */     GameRegistry.addSmelting(MyCornCob, new ItemStack(MyPopcorn), 0.1F);
/* 3303 */     LanguageRegistry.instance().addNameForObject(MyPopcorn, "en_US", "Popcorn");
/* 3304 */     GameRegistry.addSmelting(MyRawCornDog, new ItemStack(MyCornDog), 0.4F);
/* 3305 */     LanguageRegistry.instance().addNameForObject(MyCornDog, "en_US", "Corn Dog");
/* 3306 */     GameRegistry.addSmelting(MyRawBacon, new ItemStack(MyBacon), 0.2F);
/* 3307 */     LanguageRegistry.instance().addNameForObject(MyBacon, "en_US", "Bacon!");
/* 3308 */     GameRegistry.addSmelting(CrystalCrystal, new ItemStack(MyCrystalPinkIngot), 0.3F);
/* 3309 */     LanguageRegistry.instance().addNameForObject(MyCrystalPinkIngot, "en_US", "Pink Tourmaline Ingot");
/* 3310 */     GameRegistry.addSmelting(TigersEye, new ItemStack(MyTigersEyeIngot), 0.3F);
/* 3311 */     LanguageRegistry.instance().addNameForObject(MyTigersEyeIngot, "en_US", "Tiger's Eye Ingot");
/* 3312 */     GameRegistry.addSmelting(MyRawPeacock, new ItemStack(MyPeacock), 0.4F);
/* 3313 */     LanguageRegistry.instance().addNameForObject(MyPeacock, "en_US", "Cooked Peacock");
/* 3314 */     GameRegistry.addSmelting(MyRawCrabMeat, new ItemStack(MyCrabMeat), 0.2F);
/* 3315 */     LanguageRegistry.instance().addNameForObject(MyCrabMeat, "en_US", "Crab Meat!");
/*      */ 
/*      */     
/* 3318 */     GameRegistry.addSmelting(MyGreenFish, new ItemStack(Items.cooked_fished), 0.2F);
/* 3319 */     GameRegistry.addSmelting(MyBlueFish, new ItemStack(Items.cooked_fished), 0.2F);
/* 3320 */     GameRegistry.addSmelting(MyPinkFish, new ItemStack(Items.cooked_fished), 0.2F);
/* 3321 */     GameRegistry.addSmelting(MyRockFish, new ItemStack(Items.cooked_fished), 0.2F);
/* 3322 */     GameRegistry.addSmelting(MyWoodFish, new ItemStack(Items.cooked_fished), 0.2F);
/* 3323 */     GameRegistry.addSmelting(MyGreyFish, new ItemStack(Items.cooked_fished), 0.2F);
/*      */     
/* 3325 */     LanguageRegistry.instance().addNameForObject(MyRuby, "en_US", "Ruby");
/* 3326 */     LanguageRegistry.instance().addNameForObject(MyAmethyst, "en_US", "Amethyst");
/* 3327 */     LanguageRegistry.instance().addNameForObject(UraniumNugget, "en_US", "Uranium Nugget");
/* 3328 */     LanguageRegistry.instance().addNameForObject(TitaniumNugget, "en_US", "Titanium Nugget");
/*      */ 
/*      */     
/* 3331 */     LanguageRegistry.instance().addNameForObject(MyButter, "en_US", "Butter");
/* 3332 */     LanguageRegistry.instance().addNameForObject(MyButterCandy, "en_US", "Butter Candy!");
/* 3333 */     LanguageRegistry.instance().addNameForObject(MyButteredPopcorn, "en_US", "Buttered Popcorn");
/* 3334 */     LanguageRegistry.instance().addNameForObject(MyButteredSaltedPopcorn, "en_US", "Buttered and Salted Popcorn");
/* 3335 */     LanguageRegistry.instance().addNameForObject(MyPopcornBag, "en_US", "Bag of Popcorn");
/* 3336 */     LanguageRegistry.instance().addNameForObject(MyRawCornDog, "en_US", "Raw Corn Dog");
/* 3337 */     LanguageRegistry.instance().addNameForObject(MyRawBacon, "en_US", "Raw Bacon");
/* 3338 */     LanguageRegistry.instance().addNameForObject(MyRawCrabMeat, "en_US", "Raw Crab Meat");
/* 3339 */     LanguageRegistry.instance().addNameForObject(MySalad, "en_US", "Garden Salad");
/* 3340 */     LanguageRegistry.instance().addNameForObject(MyBLT, "en_US", "BLT Sandwich!");
/* 3341 */     LanguageRegistry.instance().addNameForObject(MyRawPeacock, "en_US", "Raw Peacock");
/* 3342 */     LanguageRegistry.instance().addNameForObject(MyCrabbyPatty, "en_US", "A Crabby Patty!");
/*      */ 
/*      */     
/* 3345 */     LanguageRegistry.instance().addNameForObject(MyUltimateSword, "en_US", "The Ultimate Sword");
/* 3346 */     LanguageRegistry.instance().addNameForObject(MyUltimatePickaxe, "en_US", "The Ultimate Pickaxe");
/* 3347 */     LanguageRegistry.instance().addNameForObject(MyUltimateShovel, "en_US", "The Ultimate Shovel");
/* 3348 */     LanguageRegistry.instance().addNameForObject(MyUltimateHoe, "en_US", "The Ultimate Hoe");
/* 3349 */     LanguageRegistry.instance().addNameForObject(MyUltimateAxe, "en_US", "The Ultimate Axe");
/* 3350 */     LanguageRegistry.instance().addNameForObject(MyUltimateBow, "en_US", "The Ultimate Bow");
/* 3351 */     LanguageRegistry.instance().addNameForObject(MySkateBow, "en_US", "Skate String Bow");
/* 3352 */     LanguageRegistry.instance().addNameForObject(MyUltimateFishingRod, "en_US", "The Ultimate Fishing Rod");
/* 3353 */     LanguageRegistry.instance().addNameForObject(MyNightmareSword, "en_US", "Nightmare Sword");
/* 3354 */     LanguageRegistry.instance().addNameForObject(MyBertha, "en_US", "Big Bertha");
/* 3355 */     LanguageRegistry.instance().addNameForObject(MySlice, "en_US", "Slice");
/* 3356 */     LanguageRegistry.instance().addNameForObject(MyRoyal, "en_US", "Royal Guardian Sword");
/* 3357 */     LanguageRegistry.instance().addNameForObject(MyHammy, "en_US", "Attitude Adjuster");
/* 3358 */     LanguageRegistry.instance().addNameForObject(MyBattleAxe, "en_US", "Battle Axe");
/* 3359 */     LanguageRegistry.instance().addNameForObject(MyChainsaw, "en_US", "Chainsaw");
/* 3360 */     LanguageRegistry.instance().addNameForObject(MyQueenBattleAxe, "en_US", "Queen Scale Battle Axe");
/*      */     
/* 3362 */     GameRegistry.addRecipe(new ItemStack(MyUltimateSword), new Object[] { " T ", " U ", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3367 */     GameRegistry.addRecipe(new ItemStack(MyUltimateSword), new Object[] { "T  ", "U  ", "I  ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3372 */     GameRegistry.addRecipe(new ItemStack(MyUltimateSword), new Object[] { "  T", "  U", "  I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3377 */     GameRegistry.addRecipe(new ItemStack(MyUltimatePickaxe), new Object[] { "TUT", " U ", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3382 */     GameRegistry.addRecipe(new ItemStack(MyUltimateShovel), new Object[] { " U ", " T ", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3387 */     GameRegistry.addRecipe(new ItemStack(MyUltimateShovel), new Object[] { "U  ", "T  ", "I  ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3392 */     GameRegistry.addRecipe(new ItemStack(MyUltimateShovel), new Object[] { "  U", "  T", "  I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3397 */     GameRegistry.addRecipe(new ItemStack(MyUltimateHoe), new Object[] { "TU ", " I ", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3402 */     GameRegistry.addRecipe(new ItemStack(MyUltimateAxe), new Object[] { "TU ", "TI ", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3407 */     GameRegistry.addRecipe(new ItemStack(MyUltimateBow), new Object[] { " TS", "I S", " US", Character.valueOf('S'), Items.string, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3413 */     GameRegistry.addRecipe(new ItemStack(MySkateBow), new Object[] { " TS", "T S", " TS", Character.valueOf('S'), Items.string, Character.valueOf('T'), CrystalSticks });
/*      */ 
/*      */ 
/*      */     
/* 3417 */     GameRegistry.addRecipe(new ItemStack(MyUltimateFishingRod), new Object[] { "  T", " US", "I S", Character.valueOf('S'), Items.string, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3423 */     GameRegistry.addRecipe(new ItemStack(MyNightmareSword), new Object[] { "ODO", "RTR", "OIO", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('O'), MyNightmareScale, Character.valueOf('D'), Items.diamond, Character.valueOf('R'), Items.redstone, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3432 */     LanguageRegistry.instance().addNameForObject(MyEmeraldSword, "en_US", "Emerald Sword");
/* 3433 */     LanguageRegistry.instance().addNameForObject(MyRoseSword, "en_US", "Rose Sword");
/* 3434 */     LanguageRegistry.instance().addNameForObject(MyEmeraldPickaxe, "en_US", "Emerald Pickaxe");
/* 3435 */     LanguageRegistry.instance().addNameForObject(MyEmeraldShovel, "en_US", "Emerald Shovel");
/* 3436 */     LanguageRegistry.instance().addNameForObject(MyEmeraldHoe, "en_US", "Emerald Hoe");
/* 3437 */     LanguageRegistry.instance().addNameForObject(MyEmeraldAxe, "en_US", "Emerald Axe");
/* 3438 */     LanguageRegistry.instance().addNameForObject(MyExperienceSword, "en_US", "Experience Sword");
/* 3439 */     LanguageRegistry.instance().addNameForObject(MyPoisonSword, "en_US", "Poison Sword");
/* 3440 */     LanguageRegistry.instance().addNameForObject(MyRatSword, "en_US", "Rat Sword");
/* 3441 */     LanguageRegistry.instance().addNameForObject(MyFairySword, "en_US", "Fairy Sword");
/* 3442 */     LanguageRegistry.instance().addNameForObject(MyMantisClaw, "en_US", "Mantis Claw");
/* 3443 */     LanguageRegistry.instance().addNameForObject(MyBigHammer, "en_US", "Big Hammer");
/*      */ 
/*      */     
/* 3446 */     GameRegistry.addRecipe(new ItemStack(MyEmeraldSword), new Object[] { " E ", " E ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), Items.emerald });
/*      */ 
/*      */ 
/*      */     
/* 3450 */     GameRegistry.addRecipe(new ItemStack(MyEmeraldSword), new Object[] { "E  ", "E  ", "I  ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), Items.emerald });
/*      */ 
/*      */ 
/*      */     
/* 3454 */     GameRegistry.addRecipe(new ItemStack(MyEmeraldSword), new Object[] { "  E", "  E", "  I", Character.valueOf('I'), Items.stick, Character.valueOf('E'), Items.emerald });
/*      */ 
/*      */ 
/*      */     
/* 3458 */     GameRegistry.addRecipe(new ItemStack(MyRoseSword), new Object[] { " E ", " E ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), Blocks.red_flower });
/*      */ 
/*      */ 
/*      */     
/* 3462 */     GameRegistry.addRecipe(new ItemStack(MyRoseSword), new Object[] { "E  ", "E  ", "I  ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), Blocks.red_flower });
/*      */ 
/*      */ 
/*      */     
/* 3466 */     GameRegistry.addRecipe(new ItemStack(MyRoseSword), new Object[] { "  E", "  E", "  I", Character.valueOf('I'), Items.stick, Character.valueOf('E'), Blocks.red_flower });
/*      */ 
/*      */ 
/*      */     
/* 3470 */     GameRegistry.addRecipe(new ItemStack(MyEmeraldPickaxe), new Object[] { "EEE", " I ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), Items.emerald });
/*      */ 
/*      */ 
/*      */     
/* 3474 */     GameRegistry.addRecipe(new ItemStack(MyEmeraldShovel), new Object[] { " E ", " I ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), Items.emerald });
/*      */ 
/*      */ 
/*      */     
/* 3478 */     GameRegistry.addRecipe(new ItemStack(MyEmeraldShovel), new Object[] { "E  ", "I  ", "I  ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), Items.emerald });
/*      */ 
/*      */ 
/*      */     
/* 3482 */     GameRegistry.addRecipe(new ItemStack(MyEmeraldShovel), new Object[] { "  E", "  I", "  I", Character.valueOf('I'), Items.stick, Character.valueOf('E'), Items.emerald });
/*      */ 
/*      */ 
/*      */     
/* 3486 */     GameRegistry.addRecipe(new ItemStack(MyEmeraldHoe), new Object[] { "EE ", " I ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), Items.emerald });
/*      */ 
/*      */ 
/*      */     
/* 3490 */     GameRegistry.addRecipe(new ItemStack(MyEmeraldAxe), new Object[] { "EE ", "EI ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), Items.emerald });
/*      */ 
/*      */ 
/*      */     
/* 3494 */     GameRegistry.addRecipe(new ItemStack(MyExperienceSword), new Object[] { "EEE", "EIE", "EEE", Character.valueOf('I'), MyEmeraldSword, Character.valueOf('E'), Items.experience_bottle });
/*      */ 
/*      */ 
/*      */     
/* 3498 */     GameRegistry.addRecipe(new ItemStack(MyPoisonSword), new Object[] { "EEE", "EIE", "EEE", Character.valueOf('I'), MyEmeraldSword, Character.valueOf('E'), MyDeadStinkBug });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3503 */     GameRegistry.addRecipe(new ItemStack(MyRatSword), new Object[] { " E ", " E ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalRat });
/*      */ 
/*      */ 
/*      */     
/* 3507 */     GameRegistry.addRecipe(new ItemStack(MyRatSword), new Object[] { "E  ", "E  ", "I  ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalRat });
/*      */ 
/*      */ 
/*      */     
/* 3511 */     GameRegistry.addRecipe(new ItemStack(MyRatSword), new Object[] { "  E", "  E", "  I", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalRat });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3516 */     GameRegistry.addRecipe(new ItemStack(MyFairySword), new Object[] { " E ", " E ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalFairy });
/*      */ 
/*      */ 
/*      */     
/* 3520 */     GameRegistry.addRecipe(new ItemStack(MyFairySword), new Object[] { "E  ", "E  ", "I  ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalFairy });
/*      */ 
/*      */ 
/*      */     
/* 3524 */     GameRegistry.addRecipe(new ItemStack(MyFairySword), new Object[] { "  E", "  E", "  I", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalFairy });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3529 */     LanguageRegistry.instance().addNameForObject(MyCrystalWoodSword, "en_US", "Crystal Wood Sword");
/* 3530 */     LanguageRegistry.instance().addNameForObject(MyCrystalWoodPickaxe, "en_US", "Crystal Wood Pickaxe");
/* 3531 */     LanguageRegistry.instance().addNameForObject(MyCrystalWoodShovel, "en_US", "Crystal Wood Shovel");
/* 3532 */     LanguageRegistry.instance().addNameForObject(MyCrystalWoodHoe, "en_US", "Crystal Wood Hoe");
/* 3533 */     LanguageRegistry.instance().addNameForObject(MyCrystalWoodAxe, "en_US", "Crystal Wood Axe");
/*      */     
/* 3535 */     GameRegistry.addRecipe(new ItemStack(MyCrystalWoodSword), new Object[] { " E ", " E ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalPlanksBlock });
/*      */ 
/*      */ 
/*      */     
/* 3539 */     GameRegistry.addRecipe(new ItemStack(MyCrystalWoodSword), new Object[] { "E  ", "E  ", "I  ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalPlanksBlock });
/*      */ 
/*      */ 
/*      */     
/* 3543 */     GameRegistry.addRecipe(new ItemStack(MyCrystalWoodSword), new Object[] { "  E", "  E", "  I", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalPlanksBlock });
/*      */ 
/*      */ 
/*      */     
/* 3547 */     GameRegistry.addRecipe(new ItemStack(MyCrystalWoodPickaxe), new Object[] { "EEE", " I ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalPlanksBlock });
/*      */ 
/*      */ 
/*      */     
/* 3551 */     GameRegistry.addRecipe(new ItemStack(MyCrystalWoodShovel), new Object[] { " E ", " I ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalPlanksBlock });
/*      */ 
/*      */ 
/*      */     
/* 3555 */     GameRegistry.addRecipe(new ItemStack(MyCrystalWoodShovel), new Object[] { "E  ", "I  ", "I  ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalPlanksBlock });
/*      */ 
/*      */ 
/*      */     
/* 3559 */     GameRegistry.addRecipe(new ItemStack(MyCrystalWoodShovel), new Object[] { "  E", "  I", "  I", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalPlanksBlock });
/*      */ 
/*      */ 
/*      */     
/* 3563 */     GameRegistry.addRecipe(new ItemStack(MyCrystalWoodHoe), new Object[] { "EE ", " I ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalPlanksBlock });
/*      */ 
/*      */ 
/*      */     
/* 3567 */     GameRegistry.addRecipe(new ItemStack(MyCrystalWoodAxe), new Object[] { "EE ", "EI ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalPlanksBlock });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3573 */     GameRegistry.addRecipe(new ItemStack((Block)Blocks.chest), new Object[] { "EEE", "E E", "EEE", Character.valueOf('E'), CrystalPlanksBlock });
/*      */ 
/*      */ 
/*      */     
/* 3577 */     LanguageRegistry.instance().addNameForObject(MyCrystalPinkSword, "en_US", "Pink Tourmaline Sword");
/* 3578 */     LanguageRegistry.instance().addNameForObject(MyCrystalPinkPickaxe, "en_US", "Pink Tourmaline Pickaxe");
/* 3579 */     LanguageRegistry.instance().addNameForObject(MyCrystalPinkShovel, "en_US", "Pink Tourmaline Shovel");
/* 3580 */     LanguageRegistry.instance().addNameForObject(MyCrystalPinkHoe, "en_US", "Pink Tourmaline Hoe");
/* 3581 */     LanguageRegistry.instance().addNameForObject(MyCrystalPinkAxe, "en_US", "Pink Tourmaline Axe");
/*      */     
/* 3583 */     GameRegistry.addRecipe(new ItemStack(MyCrystalPinkSword), new Object[] { " E ", " E ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyCrystalPinkIngot });
/*      */ 
/*      */ 
/*      */     
/* 3587 */     GameRegistry.addRecipe(new ItemStack(MyCrystalPinkSword), new Object[] { "E  ", "E  ", "I  ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyCrystalPinkIngot });
/*      */ 
/*      */ 
/*      */     
/* 3591 */     GameRegistry.addRecipe(new ItemStack(MyCrystalPinkSword), new Object[] { "  E", "  E", "  I", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyCrystalPinkIngot });
/*      */ 
/*      */ 
/*      */     
/* 3595 */     GameRegistry.addRecipe(new ItemStack(MyCrystalPinkPickaxe), new Object[] { "EEE", " I ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyCrystalPinkIngot });
/*      */ 
/*      */ 
/*      */     
/* 3599 */     GameRegistry.addRecipe(new ItemStack(MyCrystalPinkShovel), new Object[] { " E ", " I ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyCrystalPinkIngot });
/*      */ 
/*      */ 
/*      */     
/* 3603 */     GameRegistry.addRecipe(new ItemStack(MyCrystalPinkShovel), new Object[] { "E  ", "I  ", "I  ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyCrystalPinkIngot });
/*      */ 
/*      */ 
/*      */     
/* 3607 */     GameRegistry.addRecipe(new ItemStack(MyCrystalPinkShovel), new Object[] { "  E", "  I", "  I", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyCrystalPinkIngot });
/*      */ 
/*      */ 
/*      */     
/* 3611 */     GameRegistry.addRecipe(new ItemStack(MyCrystalPinkHoe), new Object[] { "EE ", " I ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyCrystalPinkIngot });
/*      */ 
/*      */ 
/*      */     
/* 3615 */     GameRegistry.addRecipe(new ItemStack(MyCrystalPinkAxe), new Object[] { "EE ", "EI ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyCrystalPinkIngot });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3620 */     GameRegistry.addRecipe(new ItemStack(Items.bucket), new Object[] { "   ", "I I", " I ", Character.valueOf('I'), MyCrystalPinkIngot });
/*      */ 
/*      */ 
/*      */     
/* 3624 */     LanguageRegistry.instance().addNameForObject(MyTigersEyeSword, "en_US", "Tiger's Eye Sword");
/* 3625 */     LanguageRegistry.instance().addNameForObject(MyTigersEyePickaxe, "en_US", "Tiger's Eye Pickaxe");
/* 3626 */     LanguageRegistry.instance().addNameForObject(MyTigersEyeShovel, "en_US", "Tiger's Eye Shovel");
/* 3627 */     LanguageRegistry.instance().addNameForObject(MyTigersEyeHoe, "en_US", "Tiger's Eye Hoe");
/* 3628 */     LanguageRegistry.instance().addNameForObject(MyTigersEyeAxe, "en_US", "Tiger's Eye Axe");
/*      */     
/* 3630 */     GameRegistry.addRecipe(new ItemStack(MyTigersEyeSword), new Object[] { " E ", " E ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyTigersEyeIngot });
/*      */ 
/*      */ 
/*      */     
/* 3634 */     GameRegistry.addRecipe(new ItemStack(MyTigersEyeSword), new Object[] { "E  ", "E  ", "I  ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyTigersEyeIngot });
/*      */ 
/*      */ 
/*      */     
/* 3638 */     GameRegistry.addRecipe(new ItemStack(MyTigersEyeSword), new Object[] { "  E", "  E", "  I", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyTigersEyeIngot });
/*      */ 
/*      */ 
/*      */     
/* 3642 */     GameRegistry.addRecipe(new ItemStack(MyTigersEyePickaxe), new Object[] { "EEE", " I ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyTigersEyeIngot });
/*      */ 
/*      */ 
/*      */     
/* 3646 */     GameRegistry.addRecipe(new ItemStack(MyTigersEyeShovel), new Object[] { " E ", " I ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyTigersEyeIngot });
/*      */ 
/*      */ 
/*      */     
/* 3650 */     GameRegistry.addRecipe(new ItemStack(MyTigersEyeShovel), new Object[] { "E  ", "I  ", "I  ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyTigersEyeIngot });
/*      */ 
/*      */ 
/*      */     
/* 3654 */     GameRegistry.addRecipe(new ItemStack(MyTigersEyeShovel), new Object[] { "  E", "  I", "  I", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyTigersEyeIngot });
/*      */ 
/*      */ 
/*      */     
/* 3658 */     GameRegistry.addRecipe(new ItemStack(MyTigersEyeHoe), new Object[] { "EE ", " I ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyTigersEyeIngot });
/*      */ 
/*      */ 
/*      */     
/* 3662 */     GameRegistry.addRecipe(new ItemStack(MyTigersEyeAxe), new Object[] { "EE ", "EI ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), MyTigersEyeIngot });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3667 */     LanguageRegistry.instance().addNameForObject(MyCrystalStoneSword, "en_US", "Kyanite Sword");
/* 3668 */     LanguageRegistry.instance().addNameForObject(MyCrystalStonePickaxe, "en_US", "Kyanite Pickaxe");
/* 3669 */     LanguageRegistry.instance().addNameForObject(MyCrystalStoneShovel, "en_US", "Kyanite Shovel");
/* 3670 */     LanguageRegistry.instance().addNameForObject(MyCrystalStoneHoe, "en_US", "Kyanite Hoe");
/* 3671 */     LanguageRegistry.instance().addNameForObject(MyCrystalStoneAxe, "en_US", "Kyanite Axe");
/*      */     
/* 3673 */     GameRegistry.addRecipe(new ItemStack(MyCrystalStoneSword), new Object[] { " E ", " E ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalStone });
/*      */ 
/*      */ 
/*      */     
/* 3677 */     GameRegistry.addRecipe(new ItemStack(MyCrystalStoneSword), new Object[] { "E  ", "E  ", "I  ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalStone });
/*      */ 
/*      */ 
/*      */     
/* 3681 */     GameRegistry.addRecipe(new ItemStack(MyCrystalStoneSword), new Object[] { "  E", "  E", "  I", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalStone });
/*      */ 
/*      */ 
/*      */     
/* 3685 */     GameRegistry.addRecipe(new ItemStack(MyCrystalStonePickaxe), new Object[] { "EEE", " I ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalStone });
/*      */ 
/*      */ 
/*      */     
/* 3689 */     GameRegistry.addRecipe(new ItemStack(MyCrystalStoneShovel), new Object[] { " E ", " I ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalStone });
/*      */ 
/*      */ 
/*      */     
/* 3693 */     GameRegistry.addRecipe(new ItemStack(MyCrystalStoneShovel), new Object[] { "E  ", "I  ", "I  ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalStone });
/*      */ 
/*      */ 
/*      */     
/* 3697 */     GameRegistry.addRecipe(new ItemStack(MyCrystalStoneShovel), new Object[] { "  E", "  I", "  I", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalStone });
/*      */ 
/*      */ 
/*      */     
/* 3701 */     GameRegistry.addRecipe(new ItemStack(MyCrystalStoneHoe), new Object[] { "EE ", " I ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalStone });
/*      */ 
/*      */ 
/*      */     
/* 3705 */     GameRegistry.addRecipe(new ItemStack(MyCrystalStoneAxe), new Object[] { "EE ", "EI ", " I ", Character.valueOf('I'), CrystalSticks, Character.valueOf('E'), CrystalStone });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3710 */     LanguageRegistry.instance().addNameForObject(MyRubySword, "en_US", "Ruby Sword");
/* 3711 */     LanguageRegistry.instance().addNameForObject(MyRubyPickaxe, "en_US", "Ruby Pickaxe");
/* 3712 */     LanguageRegistry.instance().addNameForObject(MyRubyShovel, "en_US", "Ruby Shovel");
/* 3713 */     LanguageRegistry.instance().addNameForObject(MyRubyHoe, "en_US", "Ruby Hoe");
/* 3714 */     LanguageRegistry.instance().addNameForObject(MyRubyAxe, "en_US", "Ruby Axe");
/*      */     
/* 3716 */     GameRegistry.addRecipe(new ItemStack(MyRubySword), new Object[] { " E ", " E ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyRuby });
/*      */ 
/*      */ 
/*      */     
/* 3720 */     GameRegistry.addRecipe(new ItemStack(MyRubySword), new Object[] { "E  ", "E  ", "I  ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyRuby });
/*      */ 
/*      */ 
/*      */     
/* 3724 */     GameRegistry.addRecipe(new ItemStack(MyRubySword), new Object[] { "  E", "  E", "  I", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyRuby });
/*      */ 
/*      */ 
/*      */     
/* 3728 */     GameRegistry.addRecipe(new ItemStack(MyRubyPickaxe), new Object[] { "EEE", " I ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyRuby });
/*      */ 
/*      */ 
/*      */     
/* 3732 */     GameRegistry.addRecipe(new ItemStack(MyRubyShovel), new Object[] { " E ", " I ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyRuby });
/*      */ 
/*      */ 
/*      */     
/* 3736 */     GameRegistry.addRecipe(new ItemStack(MyRubyShovel), new Object[] { "E  ", "I  ", "I  ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyRuby });
/*      */ 
/*      */ 
/*      */     
/* 3740 */     GameRegistry.addRecipe(new ItemStack(MyRubyShovel), new Object[] { "  E", "  I", "  I", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyRuby });
/*      */ 
/*      */ 
/*      */     
/* 3744 */     GameRegistry.addRecipe(new ItemStack(MyRubyHoe), new Object[] { "EE ", " I ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyRuby });
/*      */ 
/*      */ 
/*      */     
/* 3748 */     GameRegistry.addRecipe(new ItemStack(MyRubyAxe), new Object[] { "EE ", "EI ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyRuby });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3753 */     LanguageRegistry.instance().addNameForObject(MyAmethystSword, "en_US", "Amethyst Sword");
/* 3754 */     LanguageRegistry.instance().addNameForObject(MyAmethystPickaxe, "en_US", "Amethyst Pickaxe");
/* 3755 */     LanguageRegistry.instance().addNameForObject(MyAmethystShovel, "en_US", "Amethyst Shovel");
/* 3756 */     LanguageRegistry.instance().addNameForObject(MyAmethystHoe, "en_US", "Amethyst Hoe");
/* 3757 */     LanguageRegistry.instance().addNameForObject(MyAmethystAxe, "en_US", "Amethyst Axe");
/*      */     
/* 3759 */     GameRegistry.addRecipe(new ItemStack(MyAmethystSword), new Object[] { " E ", " E ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyAmethyst });
/*      */ 
/*      */ 
/*      */     
/* 3763 */     GameRegistry.addRecipe(new ItemStack(MyAmethystSword), new Object[] { "E  ", "E  ", "I  ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyAmethyst });
/*      */ 
/*      */ 
/*      */     
/* 3767 */     GameRegistry.addRecipe(new ItemStack(MyAmethystSword), new Object[] { "  E", "  E", "  I", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyAmethyst });
/*      */ 
/*      */ 
/*      */     
/* 3771 */     GameRegistry.addRecipe(new ItemStack(MyAmethystPickaxe), new Object[] { "EEE", " I ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyAmethyst });
/*      */ 
/*      */ 
/*      */     
/* 3775 */     GameRegistry.addRecipe(new ItemStack(MyAmethystShovel), new Object[] { " E ", " I ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyAmethyst });
/*      */ 
/*      */ 
/*      */     
/* 3779 */     GameRegistry.addRecipe(new ItemStack(MyAmethystShovel), new Object[] { "E  ", "I  ", "I  ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyAmethyst });
/*      */ 
/*      */ 
/*      */     
/* 3783 */     GameRegistry.addRecipe(new ItemStack(MyAmethystShovel), new Object[] { "  E", "  I", "  I", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyAmethyst });
/*      */ 
/*      */ 
/*      */     
/* 3787 */     GameRegistry.addRecipe(new ItemStack(MyAmethystHoe), new Object[] { "EE ", " I ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyAmethyst });
/*      */ 
/*      */ 
/*      */     
/* 3791 */     GameRegistry.addRecipe(new ItemStack(MyAmethystAxe), new Object[] { "EE ", "EI ", " I ", Character.valueOf('I'), Items.stick, Character.valueOf('E'), MyAmethyst });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3797 */     GameRegistry.addShapelessRecipe(new ItemStack(MyHammy), new Object[] { MyUltimateSword, MyUltimateSword, MyBigHammer, GreenGoo });
/* 3798 */     GameRegistry.addShapelessRecipe(new ItemStack(MyBattleAxe), new Object[] { MyUltimateSword, MyUltimateAxe, GreenGoo });
/* 3799 */     GameRegistry.addRecipe(new ItemStack(MyChainsaw), new Object[] { "EEE", "EIE", "EEE", Character.valueOf('I'), MyUltimateAxe, Character.valueOf('E'), Blocks.redstone_block });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3804 */     GameRegistry.addRecipe(new ItemStack(MyQueenBattleAxe), new Object[] { "EIE", "EIE", " I ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('E'), MyQueenScale });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3809 */     GameRegistry.addShapelessRecipe(new ItemStack(MyBertha), new Object[] { BerthaHandle, BerthaGuard, BerthaBlade });
/* 3810 */     GameRegistry.addShapelessRecipe(new ItemStack(BerthaHandle), new Object[] { MyRayGun, MyBigHammer, MyMantisClaw, MyWaterDragonScale, GreenGoo });
/* 3811 */     GameRegistry.addShapelessRecipe(new ItemStack(BerthaGuard), new Object[] { MolenoidNose, SeaMonsterScale, MyMothScale, MyBasiliskScale, MyNightmareScale, MyEmperorScorpionScale, MyJumpyBugScale });
/* 3812 */     GameRegistry.addShapelessRecipe(new ItemStack(BerthaBlade), new Object[] { MyKrakenTooth, WormTooth, TRexTooth, MyUltimateSword, CaterKillerJaw, SeaViperTongue, VortexEye });
/* 3813 */     GameRegistry.addShapelessRecipe(new ItemStack(MySlice), new Object[] { MyBertha, Items.iron_ingot });
/*      */     
/* 3815 */     GameRegistry.addShapelessRecipe(new ItemStack(MyIrukandjiArrow), new Object[] { MyPeacockFeather, MyIrukandji, CrystalSticks });
/* 3816 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.bed), new Object[] { MyPeacockFeather, CrystalPlanksBlock, MyPeacockFeather, CrystalPlanksBlock, MyPeacockFeather, CrystalPlanksBlock });
/* 3817 */     GameRegistry.addShapelessRecipe(new ItemStack(MySquidZooka), new Object[] { Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.dye, Items.dye, Items.dye, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot });
/*      */ 
/*      */ 
/*      */     
/* 3821 */     GameRegistry.addRecipe(new ItemStack(MyIngotUranium), new Object[] { "UUU", "UUU", "UUU", Character.valueOf('U'), UraniumNugget });
/*      */ 
/*      */     
/* 3824 */     GameRegistry.addShapelessRecipe(new ItemStack(UraniumNugget, 9), new Object[] { new ItemStack(MyIngotUranium) });
/* 3825 */     GameRegistry.addRecipe(new ItemStack(MyIngotTitanium), new Object[] { "UUU", "UUU", "UUU", Character.valueOf('U'), TitaniumNugget });
/*      */ 
/*      */     
/* 3828 */     GameRegistry.addShapelessRecipe(new ItemStack(TitaniumNugget, 9), new Object[] { new ItemStack(MyIngotTitanium) });
/*      */     
/* 3830 */     GameRegistry.addRecipe(new ItemStack(MyBlockUraniumBlock), new Object[] { "UUU", "UUU", "UUU", Character.valueOf('U'), MyIngotUranium });
/*      */ 
/*      */     
/* 3833 */     GameRegistry.addShapelessRecipe(new ItemStack(MyIngotUranium, 9), new Object[] { new ItemStack(MyBlockUraniumBlock) });
/*      */     
/* 3835 */     GameRegistry.addRecipe(new ItemStack(MyBlockTitaniumBlock), new Object[] { "TTT", "TTT", "TTT", Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */     
/* 3838 */     GameRegistry.addShapelessRecipe(new ItemStack(MyIngotTitanium, 9), new Object[] { new ItemStack(MyBlockTitaniumBlock) });
/*      */     
/* 3840 */     GameRegistry.addRecipe(new ItemStack(MyBlockMobzillaScaleBlock), new Object[] { "TTT", "TTT", "TTT", Character.valueOf('T'), MyGodzillaScale });
/*      */ 
/*      */     
/* 3843 */     GameRegistry.addShapelessRecipe(new ItemStack(MyGodzillaScale, 9), new Object[] { new ItemStack(MyBlockMobzillaScaleBlock) });
/*      */     
/* 3845 */     GameRegistry.addRecipe(new ItemStack(MyBlockRubyBlock), new Object[] { "TTT", "TTT", "TTT", Character.valueOf('T'), MyRuby });
/*      */ 
/*      */     
/* 3848 */     GameRegistry.addShapelessRecipe(new ItemStack(MyRuby, 9), new Object[] { new ItemStack(MyBlockRubyBlock) });
/*      */     
/* 3850 */     GameRegistry.addRecipe(new ItemStack(MyBlockAmethystBlock), new Object[] { "TTT", "TTT", "TTT", Character.valueOf('T'), MyAmethyst });
/*      */ 
/*      */     
/* 3853 */     GameRegistry.addRecipe(new ItemStack(MyCrystalPinkBlock), new Object[] { "TTT", "TTT", "TTT", Character.valueOf('T'), MyCrystalPinkIngot });
/*      */ 
/*      */     
/* 3856 */     GameRegistry.addRecipe(new ItemStack(MyTigersEyeBlock), new Object[] { "TTT", "TTT", "TTT", Character.valueOf('T'), MyTigersEyeIngot });
/*      */ 
/*      */     
/* 3859 */     GameRegistry.addShapelessRecipe(new ItemStack(MyAmethyst, 9), new Object[] { new ItemStack(MyBlockAmethystBlock) });
/* 3860 */     GameRegistry.addShapelessRecipe(new ItemStack(MyCrystalPinkIngot, 9), new Object[] { new ItemStack(MyCrystalPinkBlock) });
/* 3861 */     GameRegistry.addShapelessRecipe(new ItemStack(MyTigersEyeIngot, 9), new Object[] { new ItemStack(MyTigersEyeBlock) });
/*      */     
/* 3863 */     GameRegistry.addRecipe(new ItemStack(MyEnderPearlBlock), new Object[] { "TTT", "TTT", "TTT", Character.valueOf('T'), Items.ender_pearl });
/*      */ 
/*      */     
/* 3866 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_pearl, 9), new Object[] { new ItemStack(MyEnderPearlBlock) });
/*      */     
/* 3868 */     GameRegistry.addRecipe(new ItemStack(MyEyeOfEnderBlock), new Object[] { "TTT", "TTT", "TTT", Character.valueOf('T'), Items.ender_eye });
/*      */ 
/*      */     
/* 3871 */     GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_eye, 9), new Object[] { new ItemStack(MyEyeOfEnderBlock) });
/*      */     
/* 3873 */     GameRegistry.addRecipe(new ItemStack(MyThunderStaff), new Object[] { "DR ", "RR ", "  R", Character.valueOf('D'), Items.diamond, Character.valueOf('R'), MyRuby });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3878 */     GameRegistry.addRecipe(new ItemStack(MyWrench), new Object[] { "D D", " D ", " D ", Character.valueOf('D'), Items.iron_ingot });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3883 */     ItemStack MilkBucket = new ItemStack(Items.milk_bucket);
/* 3884 */     ItemStack SomePaper = new ItemStack(Items.paper);
/* 3885 */     GameRegistry.addShapelessRecipe(new ItemStack(MyButter, 4), new Object[] { MilkBucket, MilkBucket });
/* 3886 */     GameRegistry.addShapelessRecipe(new ItemStack(MyCheese, 2), new Object[] { MilkBucket, MilkBucket, MilkBucket, MilkBucket });
/* 3887 */     GameRegistry.addShapelessRecipe(new ItemStack(MyButteredPopcorn), new Object[] { MyPopcorn, MyButter });
/* 3888 */     GameRegistry.addShapelessRecipe(new ItemStack(MyButteredSaltedPopcorn), new Object[] { MyButteredPopcorn, MySalt });
/* 3889 */     GameRegistry.addShapelessRecipe(new ItemStack(MyButteredSaltedPopcorn), new Object[] { MyPopcorn, MySalt, MyButter });
/* 3890 */     GameRegistry.addShapelessRecipe(new ItemStack(MyPopcornBag), new Object[] { MyButteredSaltedPopcorn, MyButteredSaltedPopcorn, MyButteredSaltedPopcorn, MyButteredSaltedPopcorn, MyButteredSaltedPopcorn, MyButteredSaltedPopcorn, SomePaper, SomePaper, SomePaper });
/*      */ 
/*      */     
/* 3893 */     GameRegistry.addShapelessRecipe(new ItemStack(MyRawCornDog, 4), new Object[] { MyCornCob, Items.chicken, Items.porkchop, Items.stick });
/* 3894 */     GameRegistry.addShapelessRecipe(new ItemStack(MyRawBacon, 2), new Object[] { MySalt, Items.porkchop });
/* 3895 */     GameRegistry.addShapelessRecipe(new ItemStack(MyButterCandy, 4), new Object[] { MyButter, Items.sugar });
/*      */     
/* 3897 */     GameRegistry.addShapelessRecipe(new ItemStack(MySalad, 1), new Object[] { MyLettuce, MyTomato, MyRadish, Items.carrot, Items.bowl });
/* 3898 */     GameRegistry.addShapelessRecipe(new ItemStack(MyBLT, 1), new Object[] { MyBacon, MyLettuce, MyTomato, MyButter, Items.bread });
/* 3899 */     GameRegistry.addShapelessRecipe(new ItemStack(MyPizzaItem, 1), new Object[] { MyTomato, MyCheese, MyBacon, Items.bread });
/* 3900 */     GameRegistry.addRecipe(new ItemStack(MyDuctTapeItem), new Object[] { "   ", "AAA", "RRR", Character.valueOf('R'), Items.string, Character.valueOf('A'), Items.slime_ball });
/*      */ 
/*      */ 
/*      */     
/* 3904 */     GameRegistry.addShapelessRecipe(new ItemStack(MyCrabbyPatty, 1), new Object[] { MyCrabMeat, MyLettuce, MyTomato, Items.bread });
/*      */     
/* 3906 */     LanguageRegistry.instance().addNameForObject(MyCheese, "en_US", "Cheese");
/* 3907 */     LanguageRegistry.instance().addNameForObject(MyPizzaBlock, "en_US", "Pizza!");
/* 3908 */     LanguageRegistry.instance().addNameForObject(MyPizzaItem, "en_US", "Pizza!");
/* 3909 */     LanguageRegistry.instance().addNameForObject(MyDuctTapeBlock, "en_US", "Duct Tape!");
/* 3910 */     LanguageRegistry.instance().addNameForObject(MyDuctTapeItem, "en_US", "Duct Tape!");
/*      */     
/* 3912 */     LanguageRegistry.instance().addNameForObject(ZooCage2, "en_US", "Extra Small Zoo Cage");
/* 3913 */     LanguageRegistry.instance().addNameForObject(ZooCage4, "en_US", "Small Zoo Cage");
/* 3914 */     LanguageRegistry.instance().addNameForObject(ZooCage6, "en_US", "Medium Zoo Cage");
/* 3915 */     LanguageRegistry.instance().addNameForObject(ZooCage8, "en_US", "Large Zoo Cage");
/* 3916 */     LanguageRegistry.instance().addNameForObject(ZooCage10, "en_US", "Extra Large Zoo Cage");
/*      */     
/* 3918 */     GameRegistry.addShapelessRecipe(new ItemStack(ZooCage2), new Object[] { Blocks.iron_block, Blocks.glass, Blocks.quartz_block });
/* 3919 */     GameRegistry.addShapelessRecipe(new ItemStack(ZooCage4), new Object[] { ZooCage2, Blocks.iron_block, Blocks.glass, Blocks.quartz_block });
/* 3920 */     GameRegistry.addShapelessRecipe(new ItemStack(ZooCage6), new Object[] { ZooCage4, Blocks.iron_block, Blocks.glass, Blocks.quartz_block });
/* 3921 */     GameRegistry.addShapelessRecipe(new ItemStack(ZooCage8), new Object[] { ZooCage6, Blocks.iron_block, Blocks.glass, Blocks.quartz_block });
/* 3922 */     GameRegistry.addShapelessRecipe(new ItemStack(ZooCage10), new Object[] { ZooCage8, Blocks.iron_block, Blocks.glass, Blocks.quartz_block });
/*      */     
/* 3924 */     LanguageRegistry.instance().addNameForObject(InstantShelter, "en_US", "Instant Survival Shelter");
/* 3925 */     LanguageRegistry.instance().addNameForObject(InstantGarden, "en_US", "Instant Survival Garden");
/* 3926 */     GameRegistry.addShapelessRecipe(new ItemStack(InstantShelter), new Object[] { Blocks.redstone_block, Items.stick, Blocks.cobblestone });
/* 3927 */     GameRegistry.addShapelessRecipe(new ItemStack(InstantGarden), new Object[] { Blocks.redstone_block, Items.wheat, Items.gunpowder });
/*      */     
/* 3929 */     GameRegistry.addShapelessRecipe(new ItemStack(CreeperLauncher, 4), new Object[] { Items.paper, Items.redstone, Items.stick });
/* 3930 */     GameRegistry.addShapelessRecipe(new ItemStack(NetherLost, 1), new Object[] { Items.nether_star, Blocks.netherrack });
/*      */     
/* 3932 */     GameRegistry.addRecipe(new ItemStack(Sifter), new Object[] { "RRR", "RAR", "RRR", Character.valueOf('R'), Items.stick, Character.valueOf('A'), Items.string });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3938 */     LanguageRegistry.instance().addNameForObject(MagicApple, "en_US", "OMG! No! Don't do it!!!");
/* 3939 */     GameRegistry.addRecipe(new ItemStack(MagicApple), new Object[] { "RRR", "RAR", "RRR", Character.valueOf('R'), Blocks.redstone_block, Character.valueOf('A'), Items.apple });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3944 */     LanguageRegistry.instance().addNameForObject(RandomDungeon, "en_US", "Random Dungeon");
/* 3945 */     GameRegistry.addRecipe(new ItemStack(RandomDungeon), new Object[] { "RRR", "RAR", "RRR", Character.valueOf('R'), Blocks.redstone_block, Character.valueOf('A'), Items.coal });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3950 */     if (MinersDreamExpensive == 0) {
/*      */       
/* 3952 */       LanguageRegistry.instance().addNameForObject(MinersDream, "en_US", "Miner's Dream");
/* 3953 */       GameRegistry.addRecipe(new ItemStack(MinersDream), new Object[] { "CCC", "RRR", "GGG", Character.valueOf('R'), Blocks.redstone_block, Character.valueOf('C'), Blocks.cactus, Character.valueOf('G'), Items.gunpowder });
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/* 3960 */       LanguageRegistry.instance().addNameForObject(MinersDream, "en_US", "Miner's Dream");
/* 3961 */       GameRegistry.addRecipe(new ItemStack(MinersDream), new Object[] { "CCC", "RRR", "GGG", Character.valueOf('R'), Blocks.redstone_block, Character.valueOf('C'), Blocks.cactus, Character.valueOf('G'), Blocks.tnt });
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3969 */     LanguageRegistry.instance().addNameForObject(MyStepUp, "en_US", "Stairs going Up");
/* 3970 */     GameRegistry.addRecipe(new ItemStack(MyStepUp, 8), new Object[] { "GC ", " C ", " C ", Character.valueOf('C'), Blocks.cobblestone, Character.valueOf('G'), Items.gunpowder });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3975 */     LanguageRegistry.instance().addNameForObject(MyStepDown, "en_US", "Stairs going Down");
/* 3976 */     GameRegistry.addRecipe(new ItemStack(MyStepDown, 8), new Object[] { " C ", " C ", "GC ", Character.valueOf('C'), Blocks.cobblestone, Character.valueOf('G'), Items.gunpowder });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3981 */     LanguageRegistry.instance().addNameForObject(MyStepAccross, "en_US", "Insta-Bridge");
/* 3982 */     GameRegistry.addRecipe(new ItemStack(MyStepAccross, 8), new Object[] { " C ", "GC ", " C ", Character.valueOf('C'), Blocks.cobblestone, Character.valueOf('G'), Items.gunpowder });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3990 */     LanguageRegistry.instance().addNameForObject(ExtremeTorch, "en_US", "Extreme Torch");
/* 3991 */     GameRegistry.addShapelessRecipe(new ItemStack(ExtremeTorch, 4), new Object[] { Items.redstone, Items.stick, Items.coal });
/* 3992 */     GameRegistry.addShapelessRecipe(new ItemStack(ExtremeTorch, 1), new Object[] { Items.redstone, Blocks.torch });
/* 3993 */     GameRegistry.addShapelessRecipe(new ItemStack(CrystalSticks, 6), new Object[] { CrystalPlanksBlock, CrystalPlanksBlock });
/* 3994 */     GameRegistry.addShapelessRecipe(new ItemStack(CrystalTorch, 6), new Object[] { CrystalCoal, CrystalSticks });
/*      */     
/* 3996 */     LanguageRegistry.instance().addNameForObject(CrystalTorch, "en_US", "Crystal Torch");
/*      */     
/* 3998 */     LanguageRegistry.instance().addNameForObject(KrakenRepellent, "en_US", "Kraken Repellent");
/* 3999 */     LanguageRegistry.instance().addNameForObject(MyDeadStinkBug, "en_US", "Dead Stink Bug");
/* 4000 */     GameRegistry.addRecipe(new ItemStack(KrakenRepellent, 1), new Object[] { "D D", "STS", "D D", Character.valueOf('D'), MyDeadStinkBug, Character.valueOf('T'), ExtremeTorch, Character.valueOf('S'), Items.string });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4005 */     LanguageRegistry.instance().addNameForObject(CreeperRepellent, "en_US", "Creeper Repellent");
/* 4006 */     GameRegistry.addRecipe(new ItemStack(CreeperRepellent, 1), new Object[] { "D D", "STS", "D D", Character.valueOf('D'), GreenGoo, Character.valueOf('T'), ExtremeTorch, Character.valueOf('S'), Items.string });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4012 */     LanguageRegistry.instance().addNameForObject(MyIslandBlock, "en_US", "Island Block");
/* 4013 */     LanguageRegistry.instance().addNameForObject(MyKingSpawnerBlock, "en_US", "The King Spawner Block");
/* 4014 */     LanguageRegistry.instance().addNameForObject(MyQueenSpawnerBlock, "en_US", "The Queen Spawner Block");
/* 4015 */     LanguageRegistry.instance().addNameForObject(MyDungeonSpawnerBlock, "en_US", "Random Dungeon Spawner");
/*      */     
/* 4017 */     LanguageRegistry.instance().addNameForObject(MyAppleSeed, "en_US", "Apple Tree Seed");
/* 4018 */     GameRegistry.addShapelessRecipe(new ItemStack(MyAppleSeed, 6), new Object[] { Items.apple });
/* 4019 */     LanguageRegistry.instance().addNameForObject(MyCherrySeed, "en_US", "Cherry Pit");
/* 4020 */     GameRegistry.addShapelessRecipe(new ItemStack(MyCherrySeed, 1), new Object[] { MyCherry });
/* 4021 */     LanguageRegistry.instance().addNameForObject(MyPeachSeed, "en_US", "Peach Pit");
/* 4022 */     GameRegistry.addShapelessRecipe(new ItemStack(MyPeachSeed, 1), new Object[] { MyPeach });
/*      */     
/* 4024 */     LanguageRegistry.instance().addNameForObject(MyExperienceCatcher, "en_US", "Experience Orb Catcher");
/* 4025 */     GameRegistry.addShapelessRecipe(new ItemStack(MyExperienceCatcher, 1), new Object[] { Items.glass_bottle, Items.stick, Items.string });
/*      */     
/* 4027 */     LanguageRegistry.instance().addNameForObject(MyExperienceTreeSeed, "en_US", "Experience Tree Seed");
/* 4028 */     GameRegistry.addRecipe(new ItemStack(MyExperienceTreeSeed, 1), new Object[] { "EEE", "EAE", "EEE", Character.valueOf('A'), MyAppleSeed, Character.valueOf('E'), Items.experience_bottle });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4047 */     EntityRegistry.instance(); int hookid = EntityRegistry.findGlobalUniqueEntityId();
/* 4048 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(UltimateFishHook.class, "UltimateFishHook", hookid);
/*      */     
/* 4050 */     EntityRegistry.instance(); int urchinid = EntityRegistry.findGlobalUniqueEntityId();
/* 4051 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(SunspotUrchin.class, "SunspotUrchin", urchinid);
/* 4052 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(SunspotUrchin.class, "SunspotUrchin", urchinid, this, 64, 1, true);
/*      */     
/* 4054 */     EntityRegistry.instance(); int waterballid = EntityRegistry.findGlobalUniqueEntityId();
/* 4055 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(WaterBall.class, "WaterBall", waterballid);
/* 4056 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(WaterBall.class, "WaterBall", waterballid, this, 64, 1, true);
/*      */     
/* 4058 */     EntityRegistry.instance(); int inksackid = EntityRegistry.findGlobalUniqueEntityId();
/* 4059 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(InkSack.class, "InkSack", inksackid);
/* 4060 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(InkSack.class, "InkSack", inksackid, this, 64, 1, true);
/*      */     
/* 4062 */     EntityRegistry.instance(); int laserballid = EntityRegistry.findGlobalUniqueEntityId();
/* 4063 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(LaserBall.class, "LaserBall", laserballid);
/* 4064 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(LaserBall.class, "LaserBall", laserballid, this, 64, 1, true);
/*      */     
/* 4066 */     EntityRegistry.instance(); int iceballid = EntityRegistry.findGlobalUniqueEntityId();
/* 4067 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(IceBall.class, "IceBall", iceballid);
/* 4068 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(IceBall.class, "IceBall", iceballid, this, 64, 1, true);
/*      */     
/* 4070 */     EntityRegistry.instance(); int acidid = EntityRegistry.findGlobalUniqueEntityId();
/* 4071 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Acid.class, "Acid", acidid);
/* 4072 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Acid.class, "Acid", acidid, this, 64, 1, true);
/*      */     
/* 4074 */     EntityRegistry.instance(); int Irukandjiid = EntityRegistry.findGlobalUniqueEntityId();
/* 4075 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(DeadIrukandji.class, "DeadIrukandji", Irukandjiid);
/* 4076 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(DeadIrukandji.class, "DeadIrukandji", Irukandjiid, this, 64, 1, true);
/*      */     
/* 4078 */     EntityRegistry.instance(); int berthahitid = EntityRegistry.findGlobalUniqueEntityId();
/* 4079 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(BerthaHit.class, "BerthaHit", berthahitid);
/* 4080 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(BerthaHit.class, "BerthaHit", berthahitid, this, 64, 1, true);
/*      */     
/* 4082 */     EntityRegistry.instance(); int purplepowerid = EntityRegistry.findGlobalUniqueEntityId();
/* 4083 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(PurplePower.class, "PurplePower", purplepowerid);
/* 4084 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(PurplePower.class, "PurplePower", purplepowerid, this, 64, 1, true);
/*      */     
/* 4086 */     EntityRegistry.instance(); int rockid = EntityRegistry.findGlobalUniqueEntityId();
/* 4087 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(EntityThrownRock.class, "EntityThrownRock", rockid);
/* 4088 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(EntityThrownRock.class, "EntityThrownRock", rockid, this, 64, 1, true);
/*      */     
/* 4090 */     LanguageRegistry.instance().addNameForObject(MyFireFish, "en_US", "Fire Fish");
/* 4091 */     LanguageRegistry.instance().addNameForObject(MySunFish, "en_US", "Sun Fish");
/* 4092 */     LanguageRegistry.instance().addNameForObject(MyLavaEel, "en_US", "Lava Eel");
/* 4093 */     LanguageRegistry.instance().addNameForObject(MyMothScale, "en_US", "Moth Scale");
/* 4094 */     LanguageRegistry.instance().addNameForObject(MyQueenScale, "en_US", "The Queen Scale");
/* 4095 */     LanguageRegistry.instance().addNameForObject(MyNightmareScale, "en_US", "Nightmare Scale");
/* 4096 */     LanguageRegistry.instance().addNameForObject(MyEmperorScorpionScale, "en_US", "Emperor Scorpion Scale");
/* 4097 */     LanguageRegistry.instance().addNameForObject(MyBasiliskScale, "en_US", "Basilisk Scale");
/* 4098 */     LanguageRegistry.instance().addNameForObject(MyWaterDragonScale, "en_US", "Water Dragon Scale");
/* 4099 */     LanguageRegistry.instance().addNameForObject(MyJumpyBugScale, "en_US", "Jumpy Bug Scale");
/* 4100 */     LanguageRegistry.instance().addNameForObject(MyKrakenTooth, "en_US", "Kraken Tooth");
/* 4101 */     LanguageRegistry.instance().addNameForObject(MyGodzillaScale, "en_US", "Mobzilla Scale");
/* 4102 */     LanguageRegistry.instance().addNameForObject(GreenGoo, "en_US", "Green Goo");
/* 4103 */     LanguageRegistry.instance().addNameForObject(SpiderRobotKit, "en_US", "Spider Robot Kit");
/* 4104 */     LanguageRegistry.instance().addNameForObject(AntRobotKit, "en_US", "Red Ant Robot Kit");
/* 4105 */     LanguageRegistry.instance().addNameForObject(ZooKeeper, "en_US", "ZooKeeper Shard");
/* 4106 */     LanguageRegistry.instance().addNameForObject(MySunspotUrchin, "en_US", "Sunspot Urchin");
/* 4107 */     LanguageRegistry.instance().addNameForObject(MySparkFish, "en_US", "Spark Fish");
/* 4108 */     LanguageRegistry.instance().addNameForObject(MyWaterBall, "en_US", "WaterDragon Charge");
/* 4109 */     LanguageRegistry.instance().addNameForObject(MyLaserBall, "en_US", "Robot Laser Charge");
/* 4110 */     LanguageRegistry.instance().addNameForObject(MyIceBall, "en_US", "Ice Ball");
/* 4111 */     LanguageRegistry.instance().addNameForObject(MySmallRock, "en_US", "Small Rock");
/* 4112 */     LanguageRegistry.instance().addNameForObject(MyRock, "en_US", "Big Rock");
/* 4113 */     LanguageRegistry.instance().addNameForObject(MyRedRock, "en_US", "Flame Rock");
/* 4114 */     LanguageRegistry.instance().addNameForObject(MyCrystalRedRock, "en_US", "Flame Crystal");
/* 4115 */     LanguageRegistry.instance().addNameForObject(MyCrystalGreenRock, "en_US", "Poison Crystal");
/* 4116 */     LanguageRegistry.instance().addNameForObject(MyCrystalBlueRock, "en_US", "Slowness Crystal");
/* 4117 */     LanguageRegistry.instance().addNameForObject(MyCrystalTNTRock, "en_US", "Explosive Crystal");
/* 4118 */     LanguageRegistry.instance().addNameForObject(MyBlueRock, "en_US", "Slowness Rock");
/* 4119 */     LanguageRegistry.instance().addNameForObject(MyGreenRock, "en_US", "Poison Rock");
/* 4120 */     LanguageRegistry.instance().addNameForObject(MyPurpleRock, "en_US", "Weakness Rock");
/* 4121 */     LanguageRegistry.instance().addNameForObject(MySpikeyRock, "en_US", "Painful Rock");
/* 4122 */     LanguageRegistry.instance().addNameForObject(MyTNTRock, "en_US", "Explosive Rock");
/* 4123 */     LanguageRegistry.instance().addNameForObject(MyAcid, "en_US", "Acid");
/* 4124 */     LanguageRegistry.instance().addNameForObject(MyIrukandji, "en_US", "Dead Irukandji");
/* 4125 */     LanguageRegistry.instance().addNameForObject(MyIrukandjiArrow, "en_US", "Irukandji Arrow");
/* 4126 */     LanguageRegistry.instance().addNameForObject(MyRayGun, "en_US", "A Freakin' Ray Gun!");
/* 4127 */     LanguageRegistry.instance().addNameForObject(MySquidZooka, "en_US", "SquidZooka!");
/* 4128 */     LanguageRegistry.instance().addNameForObject(MyThunderStaff, "en_US", "Thunder Staff");
/* 4129 */     LanguageRegistry.instance().addNameForObject(MyWrench, "en_US", "Wrench");
/* 4130 */     LanguageRegistry.instance().addNameForObject(MyGreenFish, "en_US", "Green Fish");
/* 4131 */     LanguageRegistry.instance().addNameForObject(MyBlueFish, "en_US", "Blue Fish");
/* 4132 */     LanguageRegistry.instance().addNameForObject(MyPinkFish, "en_US", "Pink Fish");
/* 4133 */     LanguageRegistry.instance().addNameForObject(MyRockFish, "en_US", "Rock Fish");
/* 4134 */     LanguageRegistry.instance().addNameForObject(MyWoodFish, "en_US", "Wood Fish");
/* 4135 */     LanguageRegistry.instance().addNameForObject(MyGreyFish, "en_US", "Grey Fish");
/* 4136 */     LanguageRegistry.instance().addNameForObject(Sifter, "en_US", "Sifter");
/* 4137 */     LanguageRegistry.instance().addNameForObject(CreeperLauncher, "en_US", "Creeper Launcher");
/* 4138 */     LanguageRegistry.instance().addNameForObject(NetherLost, "en_US", "Nether Tracker");
/* 4139 */     LanguageRegistry.instance().addNameForObject(CrystalSticks, "en_US", "Crystal Shards");
/* 4140 */     LanguageRegistry.instance().addNameForObject(MyPeacockFeather, "en_US", "Peacock Feather");
/*      */     
/* 4142 */     LanguageRegistry.instance().addNameForObject(BerthaHandle, "en_US", "Big Bertha Handle");
/* 4143 */     LanguageRegistry.instance().addNameForObject(BerthaGuard, "en_US", "Big Bertha Guard");
/* 4144 */     LanguageRegistry.instance().addNameForObject(BerthaBlade, "en_US", "Big Bertha Blade");
/* 4145 */     LanguageRegistry.instance().addNameForObject(MolenoidNose, "en_US", "Molenoid Nose");
/* 4146 */     LanguageRegistry.instance().addNameForObject(SeaMonsterScale, "en_US", "Sea Monster Scale");
/* 4147 */     LanguageRegistry.instance().addNameForObject(WormTooth, "en_US", "Worm Tooth");
/* 4148 */     LanguageRegistry.instance().addNameForObject(TRexTooth, "en_US", "TRex Tooth");
/* 4149 */     LanguageRegistry.instance().addNameForObject(CaterKillerJaw, "en_US", "CaterKiller Jaws");
/* 4150 */     LanguageRegistry.instance().addNameForObject(SeaViperTongue, "en_US", "Sea Viper Tongue");
/* 4151 */     LanguageRegistry.instance().addNameForObject(VortexEye, "en_US", "Vortex Eye");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4156 */     ItemStack RayStack = new ItemStack(MyRayGun);
/* 4157 */     RayStack.setItemDamage(32767);
/* 4158 */     GameRegistry.addShapelessRecipe(new ItemStack(MyRayGun), new Object[] { new ItemStack(Blocks.redstone_block), RayStack });
/*      */ 
/*      */     
/* 4161 */     ItemStack SquidStack = new ItemStack(MySquidZooka);
/* 4162 */     SquidStack.setItemDamage(32767);
/* 4163 */     GameRegistry.addShapelessRecipe(new ItemStack(MySquidZooka), new Object[] { new ItemStack(Items.dye), SquidStack });
/*      */ 
/*      */     
/* 4166 */     LanguageRegistry.instance().addNameForObject(MyStrawberry, "en_US", "Strawberry");
/* 4167 */     LanguageRegistry.instance().addNameForObject(MyStrawberrySeed, "en_US", "Strawberry Plant");
/* 4168 */     LanguageRegistry.instance().addNameForObject(MyButterflySeed, "en_US", "Butterfly Plant");
/* 4169 */     LanguageRegistry.instance().addNameForObject(MyMothSeed, "en_US", "Moth Plant");
/* 4170 */     LanguageRegistry.instance().addNameForObject(MyMosquitoSeed, "en_US", "Mosquito Plant");
/* 4171 */     LanguageRegistry.instance().addNameForObject(MyFireflySeed, "en_US", "Firefly Plant");
/* 4172 */     LanguageRegistry.instance().addNameForObject(MyRadish, "en_US", "Radish");
/* 4173 */     LanguageRegistry.instance().addNameForObject(MyRice, "en_US", "Rice");
/* 4174 */     LanguageRegistry.instance().addNameForObject(MyCherry, "en_US", "Cherries");
/* 4175 */     LanguageRegistry.instance().addNameForObject(MyPeach, "en_US", "Peach");
/* 4176 */     LanguageRegistry.instance().addNameForObject(MyCrystalApple, "en_US", "Crystal Apple");
/* 4177 */     LanguageRegistry.instance().addNameForObject(MyLove, "en_US", "Love");
/*      */ 
/*      */     
/* 4180 */     LanguageRegistry.instance().addNameForObject(MyCornCob, "en_US", "Corn");
/* 4181 */     LanguageRegistry.instance().addNameForObject(MyCornPlant1, "en_US", "Corn Plant");
/* 4182 */     LanguageRegistry.instance().addNameForObject(MyCornPlant2, "en_US", "Corn Plant");
/* 4183 */     LanguageRegistry.instance().addNameForObject(MyCornPlant3, "en_US", "Corn Plant");
/* 4184 */     LanguageRegistry.instance().addNameForObject(MyCornPlant4, "en_US", "Corn Plant");
/* 4185 */     LanguageRegistry.instance().addNameForObject(MyQuinoa, "en_US", "Quinoa");
/* 4186 */     LanguageRegistry.instance().addNameForObject(MyQuinoaPlant1, "en_US", "Quinoa Plant");
/* 4187 */     LanguageRegistry.instance().addNameForObject(MyQuinoaPlant2, "en_US", "Quinoa Plant");
/* 4188 */     LanguageRegistry.instance().addNameForObject(MyQuinoaPlant3, "en_US", "Quinoa Plant");
/* 4189 */     LanguageRegistry.instance().addNameForObject(MyQuinoaPlant4, "en_US", "Quinoa Plant");
/* 4190 */     LanguageRegistry.instance().addNameForObject(MyTomato, "en_US", "Tomato");
/* 4191 */     LanguageRegistry.instance().addNameForObject(MyTomatoPlant1, "en_US", "Tomato Plant");
/* 4192 */     LanguageRegistry.instance().addNameForObject(MyTomatoPlant2, "en_US", "Tomato Plant");
/* 4193 */     LanguageRegistry.instance().addNameForObject(MyTomatoPlant3, "en_US", "Tomato Plant");
/* 4194 */     LanguageRegistry.instance().addNameForObject(MyTomatoPlant4, "en_US", "Tomato Plant");
/* 4195 */     LanguageRegistry.instance().addNameForObject(MyLettuce, "en_US", "Lettuce");
/* 4196 */     LanguageRegistry.instance().addNameForObject(MyLettucePlant1, "en_US", "Lettuce Plant");
/* 4197 */     LanguageRegistry.instance().addNameForObject(MyLettucePlant2, "en_US", "Lettuce Plant");
/* 4198 */     LanguageRegistry.instance().addNameForObject(MyLettucePlant3, "en_US", "Lettuce Plant");
/* 4199 */     LanguageRegistry.instance().addNameForObject(MyLettucePlant4, "en_US", "Lettuce Plant");
/* 4200 */     LanguageRegistry.instance().addNameForObject(MyExperiencePlant, "en_US", "Experience Tree Sapling");
/* 4201 */     LanguageRegistry.instance().addNameForObject(MyFlowerPinkBlock, "en_US", "Pink Flower");
/* 4202 */     LanguageRegistry.instance().addNameForObject(MyFlowerBlueBlock, "en_US", "Blue Flower");
/* 4203 */     LanguageRegistry.instance().addNameForObject(MyFlowerBlackBlock, "en_US", "Black Flower");
/* 4204 */     LanguageRegistry.instance().addNameForObject(MyFlowerScaryBlock, "en_US", "Dead Flower");
/* 4205 */     LanguageRegistry.instance().addNameForObject(CrystalFlowerRedBlock, "en_US", "Red Crystal Flower");
/* 4206 */     LanguageRegistry.instance().addNameForObject(CrystalFlowerGreenBlock, "en_US", "Green Crystal Flower");
/* 4207 */     LanguageRegistry.instance().addNameForObject(CrystalFlowerBlueBlock, "en_US", "Blue Crystal Flower");
/* 4208 */     LanguageRegistry.instance().addNameForObject(CrystalFlowerYellowBlock, "en_US", "Yellow Crystal Flower");
/* 4209 */     LanguageRegistry.instance().addNameForObject(MyCrystalPlant, "en_US", "Red Crystal Tree Sapling");
/* 4210 */     LanguageRegistry.instance().addNameForObject(MyCrystalPlant2, "en_US", "Yellow Crystal Tree Sapling");
/* 4211 */     LanguageRegistry.instance().addNameForObject(MyCrystalPlant3, "en_US", "Blue Crystal Tree Sapling");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4216 */     EntityRegistry.instance(); GirlfriendID = EntityRegistry.findGlobalUniqueEntityId();
/* 4217 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Girlfriend.class, "Girlfriend", GirlfriendID);
/* 4218 */     LanguageRegistry.instance().addStringLocalization("Girlfriend", "en_US", "Girlfriend");
/* 4219 */     LanguageRegistry.instance().addStringLocalization("entity.Girlfriend.name", "en_US", "Girlfriend");
/* 4220 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Girlfriend.class, "Girlfriend", GirlfriendID, this, 64, 1, false);
/*      */     
/* 4222 */     EntityRegistry.instance(); RedCowID = EntityRegistry.findGlobalUniqueEntityId();
/* 4223 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(RedCow.class, "Apple Cow", RedCowID);
/* 4224 */     LanguageRegistry.instance().addStringLocalization("Apple Cow", "en_US", "Apple Cow");
/* 4225 */     LanguageRegistry.instance().addStringLocalization("entity.Apple Cow.name", "en_US", "Apple Cow");
/* 4226 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(RedCow.class, "Apple Cow", RedCowID, this, 64, 1, false);
/*      */     
/* 4228 */     EntityRegistry.instance(); GoldCowID = EntityRegistry.findGlobalUniqueEntityId();
/* 4229 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(GoldCow.class, "Golden Apple Cow", GoldCowID);
/* 4230 */     LanguageRegistry.instance().addStringLocalization("Golden Apple Cow", "en_US", "Golden Apple Cow");
/* 4231 */     LanguageRegistry.instance().addStringLocalization("entity.Golden Apple Cow.name", "en_US", "Golden Apple Cow");
/* 4232 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(GoldCow.class, "Golden Apple Cow", GoldCowID, this, 64, 1, false);
/*      */     
/* 4234 */     EntityRegistry.instance(); EnchantedCowID = EntityRegistry.findGlobalUniqueEntityId();
/* 4235 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(EnchantedCow.class, "Enchanted Golden Apple Cow", EnchantedCowID);
/* 4236 */     LanguageRegistry.instance().addStringLocalization("Enchanted Golden Apple Cow", "en_US", "Enchanted Golden Apple Cow");
/* 4237 */     LanguageRegistry.instance().addStringLocalization("entity.Enchanted Golden Apple Cow.name", "en_US", "Enchanted Golden Apple Cow");
/* 4238 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(EnchantedCow.class, "Enchanted Golden Apple Cow", EnchantedCowID, this, 64, 1, false);
/*      */     
/* 4240 */     EntityRegistry.instance(); ButterflyID = EntityRegistry.findGlobalUniqueEntityId();
/* 4241 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(EntityButterfly.class, "Butterfly", ButterflyID);
/* 4242 */     LanguageRegistry.instance().addStringLocalization("entity.Butterfly.name", "en_US", "Butterfly");
/* 4243 */     LanguageRegistry.instance().addStringLocalization("Butterfly", "en_US", "Butterfly");
/* 4244 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(EntityButterfly.class, "Butterfly", ButterflyID, this, 32, 1, false);
/*      */     
/* 4246 */     EntityRegistry.instance(); LunaMothID = EntityRegistry.findGlobalUniqueEntityId();
/* 4247 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(EntityLunaMoth.class, "Moth", LunaMothID);
/* 4248 */     LanguageRegistry.instance().addStringLocalization("entity.Moth.name", "en_US", "Moth");
/* 4249 */     LanguageRegistry.instance().addStringLocalization("Moth", "en_US", "Moth");
/* 4250 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(EntityLunaMoth.class, "Moth", LunaMothID, this, 32, 1, false);
/*      */     
/* 4252 */     EntityRegistry.instance(); MosquitoID = EntityRegistry.findGlobalUniqueEntityId();
/* 4253 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(EntityMosquito.class, "Mosquito", MosquitoID);
/* 4254 */     LanguageRegistry.instance().addStringLocalization("entity.Mosquito.name", "en_US", "Mosquito");
/* 4255 */     LanguageRegistry.instance().addStringLocalization("Mosquito", "en_US", "Mosquito");
/* 4256 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(EntityMosquito.class, "Mosquito", MosquitoID, this, 16, 1, false);
/*      */     
/* 4258 */     EntityRegistry.instance(); FireflyID = EntityRegistry.findGlobalUniqueEntityId();
/* 4259 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Firefly.class, "Firefly", FireflyID);
/* 4260 */     LanguageRegistry.instance().addStringLocalization("entity.Firefly.name", "en_US", "Firefly");
/* 4261 */     LanguageRegistry.instance().addStringLocalization("Firefly", "en_US", "Firefly");
/* 4262 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Firefly.class, "Firefly", FireflyID, this, 64, 1, false);
/*      */     
/* 4264 */     EntityRegistry.instance(); BeeID = EntityRegistry.findGlobalUniqueEntityId();
/* 4265 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Bee.class, "Bee", BeeID);
/* 4266 */     LanguageRegistry.instance().addStringLocalization("Bee", "en_US", "Bee");
/* 4267 */     LanguageRegistry.instance().addStringLocalization("entity.Bee.name", "en_US", "Bee");
/* 4268 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Bee.class, "Bee", BeeID, this, 64, 1, false);
/*      */     
/* 4270 */     EntityRegistry.instance(); MothraID = EntityRegistry.findGlobalUniqueEntityId();
/* 4271 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Mothra.class, "Mothra", MothraID);
/* 4272 */     LanguageRegistry.instance().addStringLocalization("Mothra", "en_US", "Mothra");
/* 4273 */     LanguageRegistry.instance().addStringLocalization("entity.Mothra.name", "en_US", "Mothra");
/* 4274 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Mothra.class, "Mothra", MothraID, this, 128, 1, false);
/*      */     
/* 4276 */     EntityRegistry.instance(); AntID = EntityRegistry.findGlobalUniqueEntityId();
/* 4277 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(EntityAnt.class, "Ant", AntID);
/* 4278 */     LanguageRegistry.instance().addStringLocalization("entity.Ant.name", "en_US", "Ant");
/* 4279 */     LanguageRegistry.instance().addStringLocalization("Ant", "en_US", "Ant");
/* 4280 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(EntityAnt.class, "Ant", AntID, this, 16, 1, false);
/* 4281 */     EntityRegistry.instance(); RedAntID = EntityRegistry.findGlobalUniqueEntityId();
/* 4282 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(EntityRedAnt.class, "Red Ant", RedAntID);
/* 4283 */     LanguageRegistry.instance().addStringLocalization("entity.Red Ant.name", "en_US", "Red Ant");
/* 4284 */     LanguageRegistry.instance().addStringLocalization("Red Ant", "en_US", "Red Ant");
/* 4285 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(EntityRedAnt.class, "Red Ant", RedAntID, this, 16, 1, false);
/* 4286 */     EntityRegistry.instance(); RainbowAntID = EntityRegistry.findGlobalUniqueEntityId();
/* 4287 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(EntityRainbowAnt.class, "Rainbow Ant", RainbowAntID);
/* 4288 */     LanguageRegistry.instance().addStringLocalization("entity.Rainbow Ant.name", "en_US", "Rainbow Ant");
/* 4289 */     LanguageRegistry.instance().addStringLocalization("Rainbow Ant", "en_US", "Rainbow Ant");
/* 4290 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(EntityRainbowAnt.class, "Rainbow Ant", RainbowAntID, this, 16, 1, false);
/* 4291 */     EntityRegistry.instance(); UnstableAntID = EntityRegistry.findGlobalUniqueEntityId();
/* 4292 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(EntityUnstableAnt.class, "Unstable Ant", UnstableAntID);
/* 4293 */     LanguageRegistry.instance().addStringLocalization("entity.Unstable Ant.name", "en_US", "Unstable Ant");
/* 4294 */     LanguageRegistry.instance().addStringLocalization("Unstable Ant", "en_US", "Unstable Ant");
/* 4295 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(EntityUnstableAnt.class, "Unstable Ant", UnstableAntID, this, 16, 1, false);
/*      */ 
/*      */     
/* 4298 */     EntityRegistry.instance(); Robot1ID = EntityRegistry.findGlobalUniqueEntityId();
/* 4299 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Robot1.class, "Bomb-Omb", Robot1ID);
/* 4300 */     LanguageRegistry.instance().addStringLocalization("entity.Bomb-Omb.name", "en_US", "Bomb-Omb");
/* 4301 */     LanguageRegistry.instance().addStringLocalization("Bomb-Omb", "en_US", "Bomb-Omb");
/* 4302 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Robot1.class, "Bomb-Omb", Robot1ID, this, 32, 1, false);
/*      */     
/* 4304 */     EntityRegistry.instance(); Robot2ID = EntityRegistry.findGlobalUniqueEntityId();
/* 4305 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Robot2.class, "Robo-Pounder", Robot2ID);
/* 4306 */     LanguageRegistry.instance().addStringLocalization("entity.Robo-Pounder.name", "en_US", "Robo-Pounder");
/* 4307 */     LanguageRegistry.instance().addStringLocalization("Robo-Pounder", "en_US", "Robo-Pounder");
/* 4308 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Robot2.class, "Robo-Pounder", Robot2ID, this, 64, 1, false);
/*      */     
/* 4310 */     EntityRegistry.instance(); Robot3ID = EntityRegistry.findGlobalUniqueEntityId();
/* 4311 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Robot3.class, "Robo-Gunner", Robot3ID);
/* 4312 */     LanguageRegistry.instance().addStringLocalization("entity.Robo-Gunner.name", "en_US", "Robo-Gunner");
/* 4313 */     LanguageRegistry.instance().addStringLocalization("Robo-Gunner", "en_US", "Robo-Gunner");
/* 4314 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Robot3.class, "Robo-Gunner", Robot3ID, this, 64, 1, false);
/*      */     
/* 4316 */     EntityRegistry.instance(); Robot4ID = EntityRegistry.findGlobalUniqueEntityId();
/* 4317 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Robot4.class, "Robo-Warrior", Robot4ID);
/* 4318 */     LanguageRegistry.instance().addStringLocalization("entity.Robo-Warrior.name", "en_US", "Robo-Warrior");
/* 4319 */     LanguageRegistry.instance().addStringLocalization("Robo-Warrior", "en_US", "Robo-Warrior");
/* 4320 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Robot4.class, "Robo-Warrior", Robot4ID, this, 64, 1, false);
/*      */     
/* 4322 */     EntityRegistry.instance(); Robot5ID = EntityRegistry.findGlobalUniqueEntityId();
/* 4323 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Robot5.class, "Robo-Sniper", Robot5ID);
/* 4324 */     LanguageRegistry.instance().addStringLocalization("entity.Robo-Sniper.name", "en_US", "Robo-Sniper");
/* 4325 */     LanguageRegistry.instance().addStringLocalization("Robo-Sniper", "en_US", "Robo-Sniper");
/* 4326 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Robot5.class, "Robo-Sniper", Robot5ID, this, 64, 1, false);
/*      */ 
/*      */     
/* 4329 */     EntityRegistry.instance(); AlosaurusID = EntityRegistry.findGlobalUniqueEntityId();
/* 4330 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Alosaurus.class, "Alosaurus", AlosaurusID);
/* 4331 */     LanguageRegistry.instance().addStringLocalization("Alosaurus", "en_US", "Alosaurus");
/* 4332 */     LanguageRegistry.instance().addStringLocalization("entity.Alosaurus.name", "en_US", "Alosaurus");
/* 4333 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Alosaurus.class, "Alosaurus", AlosaurusID, this, 64, 1, false);
/* 4334 */     EntityRegistry.instance(); CryolophosaurusID = EntityRegistry.findGlobalUniqueEntityId();
/* 4335 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Cryolophosaurus.class, "Cryolophosaurus", CryolophosaurusID);
/* 4336 */     LanguageRegistry.instance().addStringLocalization("Cryolophosaurus", "en_US", "Cryolophosaurus");
/* 4337 */     LanguageRegistry.instance().addStringLocalization("entity.Cryolophosaurus.name", "en_US", "Cryolophosaurus");
/* 4338 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Cryolophosaurus.class, "Cryolophosaurus", CryolophosaurusID, this, 64, 1, false);
/* 4339 */     EntityRegistry.instance(); BasiliskID = EntityRegistry.findGlobalUniqueEntityId();
/* 4340 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Basilisk.class, "Basilisk", BasiliskID);
/* 4341 */     LanguageRegistry.instance().addStringLocalization("Basilisk", "en_US", "Basilisk");
/* 4342 */     LanguageRegistry.instance().addStringLocalization("entity.Basilisk.name", "en_US", "Basilisk");
/* 4343 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Basilisk.class, "Basilisk", BasiliskID, this, 64, 1, false);
/* 4344 */     EntityRegistry.instance(); CamarasaurusID = EntityRegistry.findGlobalUniqueEntityId();
/* 4345 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Camarasaurus.class, "Camarasaurus", CamarasaurusID);
/* 4346 */     LanguageRegistry.instance().addStringLocalization("Camarasaurus", "en_US", "Camarasaurus");
/* 4347 */     LanguageRegistry.instance().addStringLocalization("entity.Camarasaurus.name", "en_US", "Camarasaurus");
/* 4348 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Camarasaurus.class, "Camarasaurus", CamarasaurusID, this, 64, 1, false);
/* 4349 */     EntityRegistry.instance(); HydroliscID = EntityRegistry.findGlobalUniqueEntityId();
/* 4350 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Hydrolisc.class, "Hydrolisc", HydroliscID);
/* 4351 */     LanguageRegistry.instance().addStringLocalization("Hydrolisc", "en_US", "Hydrolisc");
/* 4352 */     LanguageRegistry.instance().addStringLocalization("entity.Hydrolisc.name", "en_US", "Hydrolisc");
/* 4353 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Hydrolisc.class, "Hydrolisc", HydroliscID, this, 64, 1, false);
/* 4354 */     EntityRegistry.instance(); VelocityRaptorID = EntityRegistry.findGlobalUniqueEntityId();
/* 4355 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(VelocityRaptor.class, "Velocity Raptor", VelocityRaptorID);
/* 4356 */     LanguageRegistry.instance().addStringLocalization("Velocity Raptor", "en_US", "Velocity Raptor");
/* 4357 */     LanguageRegistry.instance().addStringLocalization("entity.Velocity Raptor.name", "en_US", "Velocity Raptor");
/* 4358 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(VelocityRaptor.class, "Velocity Raptor", VelocityRaptorID, this, 64, 1, false);
/*      */     
/* 4360 */     EntityRegistry.instance(); DragonflyID = EntityRegistry.findGlobalUniqueEntityId();
/* 4361 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Dragonfly.class, "Dragonfly", DragonflyID);
/* 4362 */     LanguageRegistry.instance().addStringLocalization("Dragonfly", "en_US", "Dragonfly");
/* 4363 */     LanguageRegistry.instance().addStringLocalization("entity.Dragonfly.name", "en_US", "Dragonfly");
/* 4364 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Dragonfly.class, "Dragonfly", DragonflyID, this, 64, 1, false);
/*      */     
/* 4366 */     EntityRegistry.instance(); EmperorScorpionID = EntityRegistry.findGlobalUniqueEntityId();
/* 4367 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(EmperorScorpion.class, "Emperor Scorpion", EmperorScorpionID);
/* 4368 */     LanguageRegistry.instance().addStringLocalization("Emperor Scorpion", "en_US", "Emperor Scorpion");
/* 4369 */     LanguageRegistry.instance().addStringLocalization("entity.Emperor Scorpion.name", "en_US", "Emperor Scorpion");
/* 4370 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(EmperorScorpion.class, "Emperor Scorpion", EmperorScorpionID, this, 64, 1, false);
/*      */     
/* 4372 */     EntityRegistry.instance(); ScorpionID = EntityRegistry.findGlobalUniqueEntityId();
/* 4373 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Scorpion.class, "Scorpion", ScorpionID);
/* 4374 */     LanguageRegistry.instance().addStringLocalization("Scorpion", "en_US", "Scorpion");
/* 4375 */     LanguageRegistry.instance().addStringLocalization("entity.Scorpion.name", "en_US", "Scorpion");
/* 4376 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Scorpion.class, "Scorpion", ScorpionID, this, 32, 1, false);
/*      */     
/* 4378 */     EntityRegistry.instance(); CaveFisherID = EntityRegistry.findGlobalUniqueEntityId();
/* 4379 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(CaveFisher.class, "CaveFisher", CaveFisherID);
/* 4380 */     LanguageRegistry.instance().addStringLocalization("CaveFisher", "en_US", "CaveFisher");
/* 4381 */     LanguageRegistry.instance().addStringLocalization("entity.CaveFisher.name", "en_US", "CaveFisher");
/* 4382 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(CaveFisher.class, "CaveFisher", CaveFisherID, this, 32, 1, false);
/*      */     
/* 4384 */     EntityRegistry.instance(); SpyroID = EntityRegistry.findGlobalUniqueEntityId();
/* 4385 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Spyro.class, "Baby Dragon", SpyroID);
/* 4386 */     LanguageRegistry.instance().addStringLocalization("Baby Dragon", "en_US", "Baby Dragon");
/* 4387 */     LanguageRegistry.instance().addStringLocalization("entity.Baby Dragon.name", "en_US", "Baby Dragon");
/* 4388 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Spyro.class, "Baby Dragon", SpyroID, this, 64, 1, false);
/*      */     
/* 4390 */     EntityRegistry.instance(); BaryonyxID = EntityRegistry.findGlobalUniqueEntityId();
/* 4391 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Baryonyx.class, "Baryonyx", BaryonyxID);
/* 4392 */     LanguageRegistry.instance().addStringLocalization("Baryonyx", "en_US", "Baryonyx");
/* 4393 */     LanguageRegistry.instance().addStringLocalization("entity.Baryonyx.name", "en_US", "Baryonyx");
/* 4394 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Baryonyx.class, "Baryonyx", BaryonyxID, this, 64, 1, false);
/*      */     
/* 4396 */     EntityRegistry.instance(); GammaMetroidID = EntityRegistry.findGlobalUniqueEntityId();
/* 4397 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(GammaMetroid.class, "WTF?", GammaMetroidID);
/* 4398 */     LanguageRegistry.instance().addStringLocalization("WTF?", "en_US", "WTF?");
/* 4399 */     LanguageRegistry.instance().addStringLocalization("entity.WTF?.name", "en_US", "WTF?");
/* 4400 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(GammaMetroid.class, "WTF?", GammaMetroidID, this, 64, 1, false);
/*      */     
/* 4402 */     EntityRegistry.instance(); CockateilID = EntityRegistry.findGlobalUniqueEntityId();
/* 4403 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Cockateil.class, "Bird", CockateilID);
/* 4404 */     LanguageRegistry.instance().addStringLocalization("Bird", "en_US", "Bird");
/* 4405 */     LanguageRegistry.instance().addStringLocalization("entity.Bird.name", "en_US", "Bird");
/* 4406 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Cockateil.class, "Bird", CockateilID, this, 32, 1, false);
/*      */     
/* 4408 */     EntityRegistry.instance(); RubyBirdID = EntityRegistry.findGlobalUniqueEntityId();
/* 4409 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(RubyBird.class, "Ruby Bird", RubyBirdID);
/* 4410 */     LanguageRegistry.instance().addStringLocalization("Ruby Bird", "en_US", "Ruby Bird");
/* 4411 */     LanguageRegistry.instance().addStringLocalization("entity.Ruby Bird.name", "en_US", "Ruby Bird");
/* 4412 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(RubyBird.class, "Ruby Bird", RubyBirdID, this, 32, 1, false);
/*      */     
/* 4414 */     EntityRegistry.instance(); KyuubiID = EntityRegistry.findGlobalUniqueEntityId();
/* 4415 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Kyuubi.class, "Kyuubi", KyuubiID);
/* 4416 */     LanguageRegistry.instance().addStringLocalization("Kyuubi", "en_US", "Kyuubi");
/* 4417 */     LanguageRegistry.instance().addStringLocalization("entity.Kyuubi.name", "en_US", "Kyuubi");
/* 4418 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Kyuubi.class, "Kyuubi", KyuubiID, this, 64, 1, false);
/*      */     
/* 4420 */     EntityRegistry.instance(); WaterDragonID = EntityRegistry.findGlobalUniqueEntityId();
/* 4421 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(WaterDragon.class, "Water Dragon", WaterDragonID);
/* 4422 */     LanguageRegistry.instance().addStringLocalization("Water Dragon", "en_US", "Water Dragon");
/* 4423 */     LanguageRegistry.instance().addStringLocalization("entity.Water Dragon.name", "en_US", "Water Dragon");
/* 4424 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(WaterDragon.class, "Water Dragon", WaterDragonID, this, 64, 1, false);
/*      */     
/* 4426 */     EntityRegistry.instance(); AttackSquidID = EntityRegistry.findGlobalUniqueEntityId();
/* 4427 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(AttackSquid.class, "Attack Squid", AttackSquidID);
/* 4428 */     LanguageRegistry.instance().addStringLocalization("AttackSquid", "en_US", "Attack Squid");
/* 4429 */     LanguageRegistry.instance().addStringLocalization("entity.AttackSquid.name", "en_US", "Attack Squid");
/* 4430 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(AttackSquid.class, "Attack Squid", AttackSquidID, this, 32, 1, false);
/*      */     
/* 4432 */     EntityRegistry.instance(); AlienID = EntityRegistry.findGlobalUniqueEntityId();
/* 4433 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Alien.class, "Alien", AlienID);
/* 4434 */     LanguageRegistry.instance().addStringLocalization("Alien", "en_US", "Alien");
/* 4435 */     LanguageRegistry.instance().addStringLocalization("entity.Alien.name", "en_US", "Alien");
/* 4436 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Alien.class, "Alien", AlienID, this, 64, 1, false);
/*      */ 
/*      */     
/* 4439 */     EntityRegistry.instance(); ElevatorID = EntityRegistry.findGlobalUniqueEntityId();
/* 4440 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Elevator.class, "Hoverboard", ElevatorID);
/* 4441 */     LanguageRegistry.instance().addStringLocalization("Hoverboard", "en_US", "Hoverboard");
/* 4442 */     LanguageRegistry.instance().addStringLocalization("entity.Hoverboard.name", "en_US", "Hoverboard");
/*      */     
/* 4444 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Elevator.class, "Hoverboard", ElevatorID, this, 128, 1, true);
/*      */     
/* 4446 */     EntityRegistry.instance(); KrakenID = EntityRegistry.findGlobalUniqueEntityId();
/* 4447 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Kraken.class, "The Kraken", KrakenID);
/* 4448 */     LanguageRegistry.instance().addStringLocalization("The Kraken", "en_US", "The Kraken");
/* 4449 */     LanguageRegistry.instance().addStringLocalization("entity.The Kraken.name", "en_US", "The Kraken");
/* 4450 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Kraken.class, "The Kraken", KrakenID, this, 128, 1, false);
/*      */     
/* 4452 */     EntityRegistry.instance(); LizardID = EntityRegistry.findGlobalUniqueEntityId();
/* 4453 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Lizard.class, "Lizard", LizardID);
/* 4454 */     LanguageRegistry.instance().addStringLocalization("Lizard", "en_US", "Lizard");
/* 4455 */     LanguageRegistry.instance().addStringLocalization("entity.Lizard.name", "en_US", "Lizard");
/* 4456 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Lizard.class, "Lizard", LizardID, this, 64, 1, false);
/*      */     
/* 4458 */     EntityRegistry.instance(); CephadromeID = EntityRegistry.findGlobalUniqueEntityId();
/* 4459 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Cephadrome.class, "Cephadrome", CephadromeID);
/* 4460 */     LanguageRegistry.instance().addStringLocalization("Cephadrome", "en_US", "Cephadrome");
/* 4461 */     LanguageRegistry.instance().addStringLocalization("entity.Cephadrome.name", "en_US", "Cephadrome");
/*      */     
/* 4463 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Cephadrome.class, "Cephadrome", CephadromeID, this, 128, 1, true);
/*      */     
/* 4465 */     EntityRegistry.instance(); DragonID = EntityRegistry.findGlobalUniqueEntityId();
/* 4466 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Dragon.class, "Dragon", DragonID);
/* 4467 */     LanguageRegistry.instance().addStringLocalization("entity.Dragon.name", "en_US", "Dragon");
/* 4468 */     LanguageRegistry.instance().addStringLocalization("Dragon", "en_US", "Dragon");
/*      */     
/* 4470 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Dragon.class, "Dragon", DragonID, this, 128, 1, true);
/*      */     
/* 4472 */     EntityRegistry.instance(); ChipmunkID = EntityRegistry.findGlobalUniqueEntityId();
/* 4473 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Chipmunk.class, "Chipmunk", ChipmunkID);
/* 4474 */     LanguageRegistry.instance().addStringLocalization("Chipmunk", "en_US", "Chipmunk");
/* 4475 */     LanguageRegistry.instance().addStringLocalization("entity.Chipmunk.name", "en_US", "Chipmunk");
/* 4476 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Chipmunk.class, "Chipmunk", ChipmunkID, this, 32, 1, false);
/*      */     
/* 4478 */     EntityRegistry.instance(); GazelleID = EntityRegistry.findGlobalUniqueEntityId();
/* 4479 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Gazelle.class, "Gazelle", GazelleID);
/* 4480 */     LanguageRegistry.instance().addStringLocalization("Gazelle", "en_US", "Gazelle");
/* 4481 */     LanguageRegistry.instance().addStringLocalization("entity.Gazelle.name", "en_US", "Gazelle");
/* 4482 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Gazelle.class, "Gazelle", GazelleID, this, 64, 1, false);
/*      */     
/* 4484 */     EntityRegistry.instance(); OstrichID = EntityRegistry.findGlobalUniqueEntityId();
/* 4485 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Ostrich.class, "Ostrich", OstrichID);
/* 4486 */     LanguageRegistry.instance().addStringLocalization("Ostrich", "en_US", "Ostrich");
/* 4487 */     LanguageRegistry.instance().addStringLocalization("entity.Ostrich.name", "en_US", "Ostrich");
/*      */     
/* 4489 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Ostrich.class, "Ostrich", OstrichID, this, 64, 1, true);
/*      */     
/* 4491 */     EntityRegistry.instance(); TrooperBugID = EntityRegistry.findGlobalUniqueEntityId();
/* 4492 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(TrooperBug.class, "Jumpy Bug", TrooperBugID);
/* 4493 */     LanguageRegistry.instance().addStringLocalization("Jumpy Bug", "en_US", "Jumpy Bug");
/* 4494 */     LanguageRegistry.instance().addStringLocalization("entity.Jumpy Bug.name", "en_US", "Jumpy Bug");
/* 4495 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(TrooperBug.class, "Jumpy Bug", TrooperBugID, this, 64, 1, false);
/*      */     
/* 4497 */     EntityRegistry.instance(); SpitBugID = EntityRegistry.findGlobalUniqueEntityId();
/* 4498 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(SpitBug.class, "Spit Bug", SpitBugID);
/* 4499 */     LanguageRegistry.instance().addStringLocalization("Spit Bug", "en_US", "Spit Bug");
/* 4500 */     LanguageRegistry.instance().addStringLocalization("entity.Spit Bug.name", "en_US", "Spit Bug");
/* 4501 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(SpitBug.class, "Spit Bug", SpitBugID, this, 64, 1, false);
/*      */     
/* 4503 */     EntityRegistry.instance(); StinkBugID = EntityRegistry.findGlobalUniqueEntityId();
/* 4504 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(StinkBug.class, "Stink Bug", StinkBugID);
/* 4505 */     LanguageRegistry.instance().addStringLocalization("Stink Bug", "en_US", "Stink Bug");
/* 4506 */     LanguageRegistry.instance().addStringLocalization("entity.Stink Bug.name", "en_US", "Stink Bug");
/* 4507 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(StinkBug.class, "Stink Bug", StinkBugID, this, 32, 1, false);
/*      */     
/* 4509 */     EntityRegistry.instance(); TshirtID = EntityRegistry.findGlobalUniqueEntityId();
/* 4510 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Tshirt.class, "T-Shirt", TshirtID);
/* 4511 */     LanguageRegistry.instance().addStringLocalization("entity.T-Shirt.name", "en_US", "T-Shirt!");
/* 4512 */     LanguageRegistry.instance().addStringLocalization("T-Shirt", "en_US", "T-Shirt!");
/* 4513 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Tshirt.class, "T-Shirt", TshirtID, this, 32, 1, false);
/*      */     
/* 4515 */     EntityRegistry.instance(); IslandID = EntityRegistry.findGlobalUniqueEntityId();
/* 4516 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Island.class, "Island", IslandID);
/* 4517 */     LanguageRegistry.instance().addStringLocalization("Island", "en_US", "Light Floating Island");
/* 4518 */     LanguageRegistry.instance().addStringLocalization("entity.Island.name", "en_US", "Light Floating Island");
/* 4519 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Island.class, "Island", IslandID, this, 64, 1, false);
/*      */     
/* 4521 */     EntityRegistry.instance(); IslandTooID = EntityRegistry.findGlobalUniqueEntityId();
/* 4522 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(IslandToo.class, "IslandToo", IslandTooID);
/* 4523 */     LanguageRegistry.instance().addStringLocalization("IslandToo", "en_US", "Dark Floating Island");
/* 4524 */     LanguageRegistry.instance().addStringLocalization("entity.IslandToo.name", "en_US", "Dark Floating Island");
/* 4525 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(IslandToo.class, "IslandToo", IslandTooID, this, 64, 1, false);
/*      */     
/* 4527 */     EntityRegistry.instance(); CreepingHorrorID = EntityRegistry.findGlobalUniqueEntityId();
/* 4528 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(CreepingHorror.class, "Creeping Horror", CreepingHorrorID);
/* 4529 */     LanguageRegistry.instance().addStringLocalization("Creeping Horror", "en_US", "Creeping Horror");
/* 4530 */     LanguageRegistry.instance().addStringLocalization("entity.Creeping Horror.name", "en_US", "Creeping Horror");
/* 4531 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(CreepingHorror.class, "Creeping Horror", CreepingHorrorID, this, 64, 1, false);
/*      */     
/* 4533 */     EntityRegistry.instance(); TerribleTerrorID = EntityRegistry.findGlobalUniqueEntityId();
/* 4534 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(TerribleTerror.class, "Terrible Terror", TerribleTerrorID);
/* 4535 */     LanguageRegistry.instance().addStringLocalization("Terrible Terror", "en_US", "Terrible Terror");
/* 4536 */     LanguageRegistry.instance().addStringLocalization("entity.Terrible Terror.name", "en_US", "Terrible Terror");
/* 4537 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(TerribleTerror.class, "Terrible Terror", TerribleTerrorID, this, 64, 1, false);
/*      */     
/* 4539 */     EntityRegistry.instance(); CliffRacerID = EntityRegistry.findGlobalUniqueEntityId();
/* 4540 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(CliffRacer.class, "Cliff Racer", CliffRacerID);
/* 4541 */     LanguageRegistry.instance().addStringLocalization("Cliff Racer", "en_US", "Cliff Racer");
/* 4542 */     LanguageRegistry.instance().addStringLocalization("entity.Cliff Racer.name", "en_US", "Cliff Racer");
/* 4543 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(CliffRacer.class, "Cliff Racer", CliffRacerID, this, 32, 1, false);
/*      */     
/* 4545 */     EntityRegistry.instance(); TriffidID = EntityRegistry.findGlobalUniqueEntityId();
/* 4546 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Triffid.class, "Triffid", TriffidID);
/* 4547 */     LanguageRegistry.instance().addStringLocalization("Triffid", "en_US", "Triffid");
/* 4548 */     LanguageRegistry.instance().addStringLocalization("entity.Triffid.name", "en_US", "Triffid");
/* 4549 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Triffid.class, "Triffid", TriffidID, this, 64, 1, false);
/*      */     
/* 4551 */     EntityRegistry.instance(); PitchBlackID = EntityRegistry.findGlobalUniqueEntityId();
/* 4552 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(PitchBlack.class, "Nightmare", PitchBlackID);
/* 4553 */     LanguageRegistry.instance().addStringLocalization("Nightmare", "en_US", "Nightmare");
/* 4554 */     LanguageRegistry.instance().addStringLocalization("entity.Nightmare.name", "en_US", "Nightmare");
/* 4555 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(PitchBlack.class, "Nightmare", PitchBlackID, this, 64, 1, false);
/*      */     
/* 4557 */     EntityRegistry.instance(); LurkingTerrorID = EntityRegistry.findGlobalUniqueEntityId();
/* 4558 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(LurkingTerror.class, "Lurking Terror", LurkingTerrorID);
/* 4559 */     LanguageRegistry.instance().addStringLocalization("Lurking Terror", "en_US", "Lurking Terror");
/* 4560 */     LanguageRegistry.instance().addStringLocalization("entity.Lurking Terror.name", "en_US", "Lurking Terror");
/* 4561 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(LurkingTerror.class, "Lurking Terror", LurkingTerrorID, this, 64, 1, false);
/*      */     
/* 4563 */     EntityRegistry.instance(); GodzillaID = EntityRegistry.findGlobalUniqueEntityId();
/* 4564 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Godzilla.class, "Mobzilla", GodzillaID);
/* 4565 */     LanguageRegistry.instance().addStringLocalization("Mobzilla", "en_US", "Mobzilla");
/* 4566 */     LanguageRegistry.instance().addStringLocalization("entity.Mobzilla.name", "en_US", "Mobzilla");
/* 4567 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Godzilla.class, "Mobzilla", GodzillaID, this, 128, 1, false);
/*      */ 
/*      */     
/* 4570 */     EntityRegistry.instance(); GhostID = EntityRegistry.findGlobalUniqueEntityId();
/* 4571 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Ghost.class, "Ghost", GhostID);
/* 4572 */     LanguageRegistry.instance().addStringLocalization("entity.Ghost.name", "en_US", "Ghost");
/* 4573 */     LanguageRegistry.instance().addStringLocalization("Ghost", "en_US", "Ghost");
/* 4574 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Ghost.class, "Ghost", GhostID, this, 32, 1, false);
/*      */ 
/*      */     
/* 4577 */     EntityRegistry.instance(); GhostSkellyID = EntityRegistry.findGlobalUniqueEntityId();
/* 4578 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(GhostSkelly.class, "Ghost Pumpkin Skelly", GhostSkellyID);
/* 4579 */     LanguageRegistry.instance().addStringLocalization("entity.Ghost Pumpkin Skelly.name", "en_US", "Ghost Pumpkin Skelly");
/* 4580 */     LanguageRegistry.instance().addStringLocalization("Ghost Pumpkin Skelly", "en_US", "Ghost Pumpkin Skelly");
/* 4581 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(GhostSkelly.class, "Ghost Pumpkin Skelly", GhostSkellyID, this, 64, 1, false);
/*      */ 
/*      */     
/* 4584 */     EntityRegistry.instance(); WormSmallID = EntityRegistry.findGlobalUniqueEntityId();
/* 4585 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(WormSmall.class, "Small Worm", WormSmallID);
/* 4586 */     LanguageRegistry.instance().addStringLocalization("Small Worm", "en_US", "Small Worm");
/* 4587 */     LanguageRegistry.instance().addStringLocalization("entity.Small Worm.name", "en_US", "Small Worm");
/* 4588 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(WormSmall.class, "Small Worm", WormSmallID, this, 32, 1, false);
/*      */     
/* 4590 */     EntityRegistry.instance(); WormMediumID = EntityRegistry.findGlobalUniqueEntityId();
/* 4591 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(WormMedium.class, "Medium Worm", WormMediumID);
/* 4592 */     LanguageRegistry.instance().addStringLocalization("Medium Worm", "en_US", "Medium Worm");
/* 4593 */     LanguageRegistry.instance().addStringLocalization("entity.Medium Worm.name", "en_US", "Medium Worm");
/* 4594 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(WormMedium.class, "Medium Worm", WormMediumID, this, 64, 1, false);
/*      */     
/* 4596 */     EntityRegistry.instance(); WormLargeID = EntityRegistry.findGlobalUniqueEntityId();
/* 4597 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(WormLarge.class, "Large Worm", WormLargeID);
/* 4598 */     LanguageRegistry.instance().addStringLocalization("Large Worm", "en_US", "Large Worm");
/* 4599 */     LanguageRegistry.instance().addStringLocalization("entity.Large Worm.name", "en_US", "Large Worm");
/* 4600 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(WormLarge.class, "Large Worm", WormLargeID, this, 64, 1, false);
/*      */ 
/*      */     
/* 4603 */     EntityRegistry.instance(); CassowaryID = EntityRegistry.findGlobalUniqueEntityId();
/* 4604 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Cassowary.class, "Cassowary", CassowaryID);
/* 4605 */     LanguageRegistry.instance().addStringLocalization("Cassowary", "en_US", "Cassowary");
/* 4606 */     LanguageRegistry.instance().addStringLocalization("entity.Cassowary.name", "en_US", "Cassowary");
/* 4607 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Cassowary.class, "Cassowary", CassowaryID, this, 64, 1, false);
/*      */     
/* 4609 */     EntityRegistry.instance(); CloudSharkID = EntityRegistry.findGlobalUniqueEntityId();
/* 4610 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(CloudShark.class, "Cloud Shark", CloudSharkID);
/* 4611 */     LanguageRegistry.instance().addStringLocalization("Cloud Shark", "en_US", "Cloud Shark");
/* 4612 */     LanguageRegistry.instance().addStringLocalization("entity.Cloud Shark.name", "en_US", "Cloud Shark");
/* 4613 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(CloudShark.class, "Cloud Shark", CloudSharkID, this, 64, 1, false);
/*      */     
/* 4615 */     EntityRegistry.instance(); GoldFishID = EntityRegistry.findGlobalUniqueEntityId();
/* 4616 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(GoldFish.class, "Gold Fish", GoldFishID);
/* 4617 */     LanguageRegistry.instance().addStringLocalization("Gold Fish", "en_US", "Goldfish");
/* 4618 */     LanguageRegistry.instance().addStringLocalization("entity.Gold Fish.name", "en_US", "Goldfish");
/* 4619 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(GoldFish.class, "Gold Fish", GoldFishID, this, 32, 1, false);
/*      */     
/* 4621 */     EntityRegistry.instance(); LeafMonsterID = EntityRegistry.findGlobalUniqueEntityId();
/* 4622 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(LeafMonster.class, "Leaf Monster", LeafMonsterID);
/* 4623 */     LanguageRegistry.instance().addStringLocalization("Leaf Monster", "en_US", "LeafMonster");
/* 4624 */     LanguageRegistry.instance().addStringLocalization("entity.Leaf Monster.name", "en_US", "LeafMonster");
/* 4625 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(LeafMonster.class, "Leaf Monster", LeafMonsterID, this, 64, 1, false);
/*      */     
/* 4627 */     EntityRegistry.instance(); GodzillaHeadID = EntityRegistry.findGlobalUniqueEntityId();
/* 4628 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(GodzillaHead.class, "MobzillaHead", GodzillaHeadID);
/* 4629 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(GodzillaHead.class, "MobzillaHead", GodzillaHeadID, this, 128, 10, true);
/*      */     
/* 4631 */     EntityRegistry.instance(); EnderKnightID = EntityRegistry.findGlobalUniqueEntityId();
/* 4632 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(EnderKnight.class, "Ender Knight", EnderKnightID);
/* 4633 */     LanguageRegistry.instance().addStringLocalization("Ender Knight", "en_US", "Ender Knight");
/* 4634 */     LanguageRegistry.instance().addStringLocalization("entity.Ender Knight.name", "en_US", "Ender Knight");
/* 4635 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(EnderKnight.class, "Ender Knight", EnderKnightID, this, 64, 1, false);
/*      */     
/* 4637 */     EntityRegistry.instance(); EnderReaperID = EntityRegistry.findGlobalUniqueEntityId();
/* 4638 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(EnderReaper.class, "Ender Reaper", EnderReaperID);
/* 4639 */     LanguageRegistry.instance().addStringLocalization("Ender Reaper", "en_US", "Ender Reaper");
/* 4640 */     LanguageRegistry.instance().addStringLocalization("entity.Ender Reaper.name", "en_US", "Ender Reaper");
/* 4641 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(EnderReaper.class, "Ender Reaper", EnderReaperID, this, 64, 1, false);
/*      */     
/* 4643 */     EntityRegistry.instance(); BeaverID = EntityRegistry.findGlobalUniqueEntityId();
/* 4644 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Beaver.class, "Beaver", BeaverID);
/* 4645 */     LanguageRegistry.instance().addStringLocalization("Beaver", "en_US", "Beaver");
/* 4646 */     LanguageRegistry.instance().addStringLocalization("entity.Beaver.name", "en_US", "Beaver");
/* 4647 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Beaver.class, "Beaver", BeaverID, this, 64, 1, false);
/*      */     
/* 4649 */     EntityRegistry.instance(); TermiteID = EntityRegistry.findGlobalUniqueEntityId();
/* 4650 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Termite.class, "Termite", TermiteID);
/* 4651 */     LanguageRegistry.instance().addStringLocalization("Termite", "en_US", "Termite");
/* 4652 */     LanguageRegistry.instance().addStringLocalization("entity.Termite.name", "en_US", "Termite");
/* 4653 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Termite.class, "Termite", TermiteID, this, 32, 1, false);
/*      */     
/* 4655 */     EntityRegistry.instance(); FairyID = EntityRegistry.findGlobalUniqueEntityId();
/* 4656 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Fairy.class, "Fairy", FairyID);
/* 4657 */     LanguageRegistry.instance().addStringLocalization("Fairy", "en_US", "Fairy");
/* 4658 */     LanguageRegistry.instance().addStringLocalization("entity.Fairy.name", "en_US", "Fairy");
/* 4659 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Fairy.class, "Fairy", FairyID, this, 32, 1, false);
/*      */     
/* 4661 */     EntityRegistry.instance(); PeacockID = EntityRegistry.findGlobalUniqueEntityId();
/* 4662 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Peacock.class, "Peacock", PeacockID);
/* 4663 */     LanguageRegistry.instance().addStringLocalization("Peacock", "en_US", "Peacock");
/* 4664 */     LanguageRegistry.instance().addStringLocalization("entity.Peacock.name", "en_US", "Peacock");
/* 4665 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Peacock.class, "Peacock", PeacockID, this, 64, 1, false);
/*      */     
/* 4667 */     EntityRegistry.instance(); RotatorID = EntityRegistry.findGlobalUniqueEntityId();
/* 4668 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Rotator.class, "Rotator", RotatorID);
/* 4669 */     LanguageRegistry.instance().addStringLocalization("Rotator", "en_US", "Rotator");
/* 4670 */     LanguageRegistry.instance().addStringLocalization("entity.Rotator.name", "en_US", "Rotator");
/* 4671 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Rotator.class, "Rotator", RotatorID, this, 64, 1, false);
/*      */     
/* 4673 */     EntityRegistry.instance(); VortexID = EntityRegistry.findGlobalUniqueEntityId();
/* 4674 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Vortex.class, "Vortex", VortexID);
/* 4675 */     LanguageRegistry.instance().addStringLocalization("Vortex", "en_US", "Vortex");
/* 4676 */     LanguageRegistry.instance().addStringLocalization("entity.Vortex.name", "en_US", "Vortex");
/* 4677 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Vortex.class, "Vortex", VortexID, this, 64, 1, false);
/*      */     
/* 4679 */     EntityRegistry.instance(); DungeonBeastID = EntityRegistry.findGlobalUniqueEntityId();
/* 4680 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(DungeonBeast.class, "Dungeon Beast", DungeonBeastID);
/* 4681 */     LanguageRegistry.instance().addStringLocalization("Dungeon Beast", "en_US", "Dungeon Beast");
/* 4682 */     LanguageRegistry.instance().addStringLocalization("entity.Dungeon Beast.name", "en_US", "Dungeon Beast");
/* 4683 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(DungeonBeast.class, "Dungeon Beast", DungeonBeastID, this, 64, 1, false);
/*      */     
/* 4685 */     EntityRegistry.instance(); RatID = EntityRegistry.findGlobalUniqueEntityId();
/* 4686 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Rat.class, "Rat", RatID);
/* 4687 */     LanguageRegistry.instance().addStringLocalization("Rat", "en_US", "Rat");
/* 4688 */     LanguageRegistry.instance().addStringLocalization("entity.Rat.name", "en_US", "Rat");
/* 4689 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Rat.class, "Rat", RatID, this, 32, 1, false);
/*      */     
/* 4691 */     EntityRegistry.instance(); FlounderID = EntityRegistry.findGlobalUniqueEntityId();
/* 4692 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Flounder.class, "Flounder", FlounderID);
/* 4693 */     LanguageRegistry.instance().addStringLocalization("Flounder", "en_US", "Flounder");
/* 4694 */     LanguageRegistry.instance().addStringLocalization("entity.Flounder.name", "en_US", "Flounder");
/* 4695 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Flounder.class, "Flounder", FlounderID, this, 32, 1, false);
/*      */     
/* 4697 */     EntityRegistry.instance(); WhaleID = EntityRegistry.findGlobalUniqueEntityId();
/* 4698 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Whale.class, "Whale", WhaleID);
/* 4699 */     LanguageRegistry.instance().addStringLocalization("Whale", "en_US", "Whale");
/* 4700 */     LanguageRegistry.instance().addStringLocalization("entity.Whale.name", "en_US", "Whale");
/* 4701 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Whale.class, "Whale", WhaleID, this, 64, 1, false);
/*      */     
/* 4703 */     EntityRegistry.instance(); IrukandjiID = EntityRegistry.findGlobalUniqueEntityId();
/* 4704 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Irukandji.class, "Irukandji", IrukandjiID);
/* 4705 */     LanguageRegistry.instance().addStringLocalization("Irukandji", "en_US", "Irukandji");
/* 4706 */     LanguageRegistry.instance().addStringLocalization("entity.Irukandji.name", "en_US", "Irukandji");
/* 4707 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Irukandji.class, "Irukandji", IrukandjiID, this, 32, 1, false);
/*      */     
/* 4709 */     EntityRegistry.instance(); SkateID = EntityRegistry.findGlobalUniqueEntityId();
/* 4710 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Skate.class, "Skate", SkateID);
/* 4711 */     LanguageRegistry.instance().addStringLocalization("Skate", "en_US", "Skate");
/* 4712 */     LanguageRegistry.instance().addStringLocalization("entity.Skate.name", "en_US", "Skate");
/* 4713 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Skate.class, "Skate", SkateID, this, 32, 1, false);
/*      */     
/* 4715 */     EntityRegistry.instance(); UrchinID = EntityRegistry.findGlobalUniqueEntityId();
/* 4716 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Urchin.class, "Crystal Urchin", UrchinID);
/* 4717 */     LanguageRegistry.instance().addStringLocalization("Crystal Urchin", "en_US", "Crystal Urchin");
/* 4718 */     LanguageRegistry.instance().addStringLocalization("entity.Crystal Urchin.name", "en_US", "Crystal Urchin");
/* 4719 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Urchin.class, "Crystal Urchin", UrchinID, this, 64, 1, false);
/*      */ 
/*      */     
/* 4722 */     EntityRegistry.instance(); MantisID = EntityRegistry.findGlobalUniqueEntityId();
/* 4723 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Mantis.class, "Mantis", MantisID);
/* 4724 */     LanguageRegistry.instance().addStringLocalization("Mantis", "en_US", "Mantis");
/* 4725 */     LanguageRegistry.instance().addStringLocalization("entity.Mantis.name", "en_US", "Mantis");
/* 4726 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Mantis.class, "Mantis", MantisID, this, 64, 1, false);
/*      */ 
/*      */     
/* 4729 */     EntityRegistry.instance(); HerculesBeetleID = EntityRegistry.findGlobalUniqueEntityId();
/* 4730 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(HerculesBeetle.class, "Hercules Beetle", HerculesBeetleID);
/* 4731 */     LanguageRegistry.instance().addStringLocalization("Hercules Beetle", "en_US", "Hercules Beetle");
/* 4732 */     LanguageRegistry.instance().addStringLocalization("entity.Hercules Beetle.name", "en_US", "Hercules Beetle");
/* 4733 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(HerculesBeetle.class, "Hercules Beetle", HerculesBeetleID, this, 64, 1, false);
/*      */     
/* 4735 */     EntityRegistry.instance(); TRexID = EntityRegistry.findGlobalUniqueEntityId();
/* 4736 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(TRex.class, "T. Rex", TRexID);
/* 4737 */     LanguageRegistry.instance().addStringLocalization("T. Rex", "en_US", "T. Rex");
/* 4738 */     LanguageRegistry.instance().addStringLocalization("entity.T. Rex.name", "en_US", "T. Rex");
/* 4739 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(TRex.class, "T. Rex", TRexID, this, 64, 1, false);
/*      */     
/* 4741 */     EntityRegistry.instance(); StinkyID = EntityRegistry.findGlobalUniqueEntityId();
/* 4742 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Stinky.class, "Stinky", StinkyID);
/* 4743 */     LanguageRegistry.instance().addStringLocalization("Stinky", "en_US", "Stinky");
/* 4744 */     LanguageRegistry.instance().addStringLocalization("entity.Stinky.name", "en_US", "Stinky");
/* 4745 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Stinky.class, "Stinky", StinkyID, this, 64, 1, false);
/*      */     
/* 4747 */     EntityRegistry.instance(); CoinID = EntityRegistry.findGlobalUniqueEntityId();
/* 4748 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Coin.class, "Coin", CoinID);
/* 4749 */     LanguageRegistry.instance().addStringLocalization("entity.Coin.name", "en_US", "Coin!");
/* 4750 */     LanguageRegistry.instance().addStringLocalization("Coin", "en_US", "Coin!");
/* 4751 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Coin.class, "Coin", CoinID, this, 64, 1, false);
/*      */ 
/*      */     
/* 4754 */     EntityRegistry.instance(); TheKingID = EntityRegistry.findGlobalUniqueEntityId();
/* 4755 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(TheKing.class, "The King", TheKingID);
/* 4756 */     LanguageRegistry.instance().addStringLocalization("The King", "en_US", "The King");
/* 4757 */     LanguageRegistry.instance().addStringLocalization("entity.The King.name", "en_US", "The King");
/* 4758 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(TheKing.class, "The King", TheKingID, this, 128, 1, false);
/*      */     
/* 4760 */     EntityRegistry.instance(); KingHeadID = EntityRegistry.findGlobalUniqueEntityId();
/* 4761 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(KingHead.class, "KingHead", KingHeadID);
/* 4762 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(KingHead.class, "KingHead", KingHeadID, this, 128, 10, true);
/*      */     
/* 4764 */     EntityRegistry.instance(); TheQueenID = EntityRegistry.findGlobalUniqueEntityId();
/* 4765 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(TheQueen.class, "The Queen", TheQueenID);
/* 4766 */     LanguageRegistry.instance().addStringLocalization("The Queen", "en_US", "The Queen");
/* 4767 */     LanguageRegistry.instance().addStringLocalization("entity.The Queen.name", "en_US", "The Queen");
/* 4768 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(TheQueen.class, "The Queen", TheQueenID, this, 128, 1, false);
/*      */     
/* 4770 */     EntityRegistry.instance(); QueenHeadID = EntityRegistry.findGlobalUniqueEntityId();
/* 4771 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(QueenHead.class, "QueenHead", QueenHeadID);
/* 4772 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(QueenHead.class, "QueenHead", QueenHeadID, this, 128, 10, true);
/*      */     
/* 4774 */     EntityRegistry.instance(); BoyfriendID = EntityRegistry.findGlobalUniqueEntityId();
/* 4775 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Boyfriend.class, "Boyfriend", BoyfriendID);
/* 4776 */     LanguageRegistry.instance().addStringLocalization("Boyfriend", "en_US", "Boyfriend");
/* 4777 */     LanguageRegistry.instance().addStringLocalization("entity.Boyfriend.name", "en_US", "Boyfriend");
/* 4778 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Boyfriend.class, "Boyfriend", BoyfriendID, this, 64, 1, false);
/*      */     
/* 4780 */     EntityRegistry.instance(); ThePrinceID = EntityRegistry.findGlobalUniqueEntityId();
/* 4781 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(ThePrince.class, "The Prince", ThePrinceID);
/* 4782 */     LanguageRegistry.instance().addStringLocalization("The Prince", "en_US", "The Prince");
/* 4783 */     LanguageRegistry.instance().addStringLocalization("entity.The Prince.name", "en_US", "The Prince");
/* 4784 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(ThePrince.class, "The Prince", ThePrinceID, this, 64, 1, false);
/*      */     
/* 4786 */     EntityRegistry.instance(); MolenoidID = EntityRegistry.findGlobalUniqueEntityId();
/* 4787 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Molenoid.class, "Molenoid", MolenoidID);
/* 4788 */     LanguageRegistry.instance().addStringLocalization("Molenoid", "en_US", "Molenoid");
/* 4789 */     LanguageRegistry.instance().addStringLocalization("entity.Molenoid.name", "en_US", "Molenoid");
/* 4790 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Molenoid.class, "Molenoid", MolenoidID, this, 64, 1, false);
/*      */     
/* 4792 */     EntityRegistry.instance(); SeaMonsterID = EntityRegistry.findGlobalUniqueEntityId();
/* 4793 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(SeaMonster.class, "Sea Monster", SeaMonsterID);
/* 4794 */     LanguageRegistry.instance().addStringLocalization("Sea Monster", "en_US", "Sea Monster");
/* 4795 */     LanguageRegistry.instance().addStringLocalization("entity.Sea Monster.name", "en_US", "Sea Monster");
/* 4796 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(SeaMonster.class, "Sea Monster", SeaMonsterID, this, 64, 1, false);
/*      */     
/* 4798 */     EntityRegistry.instance(); SeaViperID = EntityRegistry.findGlobalUniqueEntityId();
/* 4799 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(SeaViper.class, "Sea Viper", SeaViperID);
/* 4800 */     LanguageRegistry.instance().addStringLocalization("Sea Viper", "en_US", "Sea Viper");
/* 4801 */     LanguageRegistry.instance().addStringLocalization("entity.Sea Viper.name", "en_US", "Sea Viper");
/* 4802 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(SeaViper.class, "Sea Viper", SeaViperID, this, 64, 1, false);
/*      */     
/* 4804 */     EntityRegistry.instance(); EasterBunnyID = EntityRegistry.findGlobalUniqueEntityId();
/* 4805 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(EasterBunny.class, "Easter Bunny", EasterBunnyID);
/* 4806 */     LanguageRegistry.instance().addStringLocalization("Easter Bunny", "en_US", "Easter Bunny");
/* 4807 */     LanguageRegistry.instance().addStringLocalization("entity.Easter Bunny.name", "en_US", "Easter Bunny");
/* 4808 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(EasterBunny.class, "EasterBunny", EasterBunnyID, this, 64, 1, false);
/*      */     
/* 4810 */     EntityRegistry.instance(); CaterKillerID = EntityRegistry.findGlobalUniqueEntityId();
/* 4811 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(CaterKiller.class, "CaterKiller", CaterKillerID);
/* 4812 */     LanguageRegistry.instance().addStringLocalization("CaterKiller", "en_US", "CaterKiller");
/* 4813 */     LanguageRegistry.instance().addStringLocalization("entity.CaterKiller.name", "en_US", "CaterKiller");
/* 4814 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(CaterKiller.class, "CaterKiller", CaterKillerID, this, 64, 1, false);
/*      */     
/* 4816 */     EntityRegistry.instance(); CrystalCowID = EntityRegistry.findGlobalUniqueEntityId();
/* 4817 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(CrystalCow.class, "Crystal Apple Cow", CrystalCowID);
/* 4818 */     LanguageRegistry.instance().addStringLocalization("Crystal Apple Cow", "en_US", "Crystal Apple Cow");
/* 4819 */     LanguageRegistry.instance().addStringLocalization("entity.Crystal Apple Cow.name", "en_US", "Crystal Apple Cow");
/* 4820 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(CrystalCow.class, "Crystal Apple Cow", CrystalCowID, this, 64, 1, false);
/*      */     
/* 4822 */     EntityRegistry.instance(); LeonID = EntityRegistry.findGlobalUniqueEntityId();
/* 4823 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Leon.class, "Leonopteryx", LeonID);
/* 4824 */     LanguageRegistry.instance().addStringLocalization("Leonopteryx", "en_US", "Leonopteryx");
/* 4825 */     LanguageRegistry.instance().addStringLocalization("entity.Leonopteryx.name", "en_US", "Leonopteryx");
/* 4826 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Leon.class, "Leonopteryx", LeonID, this, 64, 1, false);
/*      */     
/* 4828 */     EntityRegistry.instance(); HammerheadID = EntityRegistry.findGlobalUniqueEntityId();
/* 4829 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Hammerhead.class, "Hammerhead", HammerheadID);
/* 4830 */     LanguageRegistry.instance().addStringLocalization("Hammerhead", "en_US", "Hammerhead");
/* 4831 */     LanguageRegistry.instance().addStringLocalization("entity.Hammerhead.name", "en_US", "Hammerhead");
/* 4832 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Hammerhead.class, "Hammerhead", HammerheadID, this, 64, 1, false);
/*      */     
/* 4834 */     EntityRegistry.instance(); RubberDuckyID = EntityRegistry.findGlobalUniqueEntityId();
/* 4835 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(RubberDucky.class, "Rubber Ducky", RubberDuckyID);
/* 4836 */     LanguageRegistry.instance().addStringLocalization("Rubber Ducky", "en_US", "Rubber Ducky");
/* 4837 */     LanguageRegistry.instance().addStringLocalization("entity.Rubber Ducky.name", "en_US", "Rubber Ducky");
/* 4838 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(RubberDucky.class, "Rubber Ducky", RubberDuckyID, this, 64, 1, false);
/*      */     
/* 4840 */     EntityRegistry.instance(); ThePrinceTeenID = EntityRegistry.findGlobalUniqueEntityId();
/* 4841 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(ThePrinceTeen.class, "The Young Prince", ThePrinceTeenID);
/* 4842 */     LanguageRegistry.instance().addStringLocalization("The Young Prince", "en_US", "The Young Prince");
/* 4843 */     LanguageRegistry.instance().addStringLocalization("entity.The Young Prince.name", "en_US", "The Young Prince");
/* 4844 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(ThePrinceTeen.class, "The Young Prince", ThePrinceTeenID, this, 64, 1, false);
/*      */     
/* 4846 */     EntityRegistry.instance(); BandPID = EntityRegistry.findGlobalUniqueEntityId();
/* 4847 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(BandP.class, "Criminal", BandPID);
/* 4848 */     LanguageRegistry.instance().addStringLocalization("Criminal", "en_US", "Criminal");
/* 4849 */     LanguageRegistry.instance().addStringLocalization("entity.Criminal.name", "en_US", "Criminal");
/* 4850 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(BandP.class, "Criminal", BandPID, this, 64, 1, false);
/*      */     
/* 4852 */     EntityRegistry.instance(); RockBaseID = EntityRegistry.findGlobalUniqueEntityId();
/* 4853 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(RockBase.class, "Rock", RockBaseID, 1118481, 16777215);
/* 4854 */     LanguageRegistry.instance().addStringLocalization("Rock", "en_US", "Rock");
/* 4855 */     LanguageRegistry.instance().addStringLocalization("entity.Rock.name", "en_US", "Rock");
/* 4856 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(RockBase.class, "Rock", RockBaseID, this, 32, 1, false);
/*      */     
/* 4858 */     EntityRegistry.instance(); BrutalflyID = EntityRegistry.findGlobalUniqueEntityId();
/* 4859 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Brutalfly.class, "Brutalfly", BrutalflyID);
/* 4860 */     LanguageRegistry.instance().addStringLocalization("Brutalfly", "en_US", "Brutalfly");
/* 4861 */     LanguageRegistry.instance().addStringLocalization("entity.Brutalfly.name", "en_US", "Brutalfly");
/* 4862 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Brutalfly.class, "Brutalfly", BrutalflyID, this, 128, 1, false);
/*      */     
/* 4864 */     EntityRegistry.instance(); NastysaurusID = EntityRegistry.findGlobalUniqueEntityId();
/* 4865 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Nastysaurus.class, "Nastysaurus", NastysaurusID);
/* 4866 */     LanguageRegistry.instance().addStringLocalization("Nastysaurus", "en_US", "Nastysaurus");
/* 4867 */     LanguageRegistry.instance().addStringLocalization("entity.Nastysaurus.name", "en_US", "Nastysaurus");
/* 4868 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Nastysaurus.class, "Nastysaurus", NastysaurusID, this, 128, 1, false);
/*      */     
/* 4870 */     EntityRegistry.instance(); PointysaurusID = EntityRegistry.findGlobalUniqueEntityId();
/* 4871 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Pointysaurus.class, "Pointysaurus", PointysaurusID);
/* 4872 */     LanguageRegistry.instance().addStringLocalization("Pointysaurus", "en_US", "Pointysaurus");
/* 4873 */     LanguageRegistry.instance().addStringLocalization("entity.Pointysaurus.name", "en_US", "Pointysaurus");
/* 4874 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Pointysaurus.class, "Pointysaurus", PointysaurusID, this, 64, 1, false);
/*      */     
/* 4876 */     EntityRegistry.instance(); CricketID = EntityRegistry.findGlobalUniqueEntityId();
/* 4877 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Cricket.class, "Cricket", CricketID);
/* 4878 */     LanguageRegistry.instance().addStringLocalization("Cricket", "en_US", "Cricket");
/* 4879 */     LanguageRegistry.instance().addStringLocalization("entity.Cricket.name", "en_US", "Cricket");
/* 4880 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Cricket.class, "Cricket", CricketID, this, 32, 1, false);
/*      */     
/* 4882 */     EntityRegistry.instance(); ThePrincessID = EntityRegistry.findGlobalUniqueEntityId();
/* 4883 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(ThePrincess.class, "The Princess", ThePrincessID);
/* 4884 */     LanguageRegistry.instance().addStringLocalization("The Princess", "en_US", "The Princess");
/* 4885 */     LanguageRegistry.instance().addStringLocalization("entity.The Princess.name", "en_US", "The Princess");
/* 4886 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(ThePrincess.class, "The Princess", ThePrincessID, this, 64, 1, false);
/*      */     
/* 4888 */     EntityRegistry.instance(); FrogID = EntityRegistry.findGlobalUniqueEntityId();
/* 4889 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Frog.class, "Frog", FrogID);
/* 4890 */     LanguageRegistry.instance().addStringLocalization("Frog", "en_US", "Frog");
/* 4891 */     LanguageRegistry.instance().addStringLocalization("entity.Frog.name", "en_US", "Frog");
/* 4892 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Frog.class, "Frog", FrogID, this, 32, 1, false);
/*      */     
/* 4894 */     EntityRegistry.instance(); ThePrinceAdultID = EntityRegistry.findGlobalUniqueEntityId();
/* 4895 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(ThePrinceAdult.class, "The Young Adult Prince", ThePrinceAdultID);
/* 4896 */     LanguageRegistry.instance().addStringLocalization("The Young Adult Prince", "en_US", "The Young Adult Prince");
/* 4897 */     LanguageRegistry.instance().addStringLocalization("entity.The Young Adult Prince.name", "en_US", "The Young Adult Prince");
/* 4898 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(ThePrinceAdult.class, "The Young Adult Prince", ThePrinceAdultID, this, 128, 1, false);
/*      */     
/* 4900 */     EntityRegistry.instance(); SpiderRobotID = EntityRegistry.findGlobalUniqueEntityId();
/* 4901 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(SpiderRobot.class, "Robot Spider", SpiderRobotID);
/* 4902 */     LanguageRegistry.instance().addStringLocalization("entity.Robot Spider.name", "en_US", "Robot Spider");
/* 4903 */     LanguageRegistry.instance().addStringLocalization("Robot Spider", "en_US", "Robot Spider");
/* 4904 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(SpiderRobot.class, "Robot Spider", SpiderRobotID, this, 128, 1, false);
/*      */     
/* 4906 */     EntityRegistry.instance(); SpiderDriverID = EntityRegistry.findGlobalUniqueEntityId();
/* 4907 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(SpiderDriver.class, "Spider Driver", SpiderDriverID);
/* 4908 */     LanguageRegistry.instance().addStringLocalization("entity.Spider Driver.name", "en_US", "Spider Driver");
/* 4909 */     LanguageRegistry.instance().addStringLocalization("Spider Driver", "en_US", "Spider Driver");
/* 4910 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(SpiderDriver.class, "Spider Driver", SpiderDriverID, this, 64, 1, false);
/*      */     
/* 4912 */     EntityRegistry.instance(); JefferyID = EntityRegistry.findGlobalUniqueEntityId();
/* 4913 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(GiantRobot.class, "Jeffery", JefferyID);
/* 4914 */     LanguageRegistry.instance().addStringLocalization("entity.Jeffery.name", "en_US", "Jeffery");
/* 4915 */     LanguageRegistry.instance().addStringLocalization("Jeffery", "en_US", "Jeffery");
/* 4916 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(GiantRobot.class, "Jeffery", JefferyID, this, 128, 1, false);
/*      */     
/* 4918 */     EntityRegistry.instance(); AntRobotID = EntityRegistry.findGlobalUniqueEntityId();
/* 4919 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(AntRobot.class, "Robot Red Ant", AntRobotID);
/* 4920 */     LanguageRegistry.instance().addStringLocalization("entity.Robot Red Ant.name", "en_US", "Robot Red Ant");
/* 4921 */     LanguageRegistry.instance().addStringLocalization("Robot Red Ant", "en_US", "Robot Red Ant");
/* 4922 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(AntRobot.class, "Robot Red Ant", AntRobotID, this, 128, 1, false);
/*      */     
/* 4924 */     EntityRegistry.instance(); CrabID = EntityRegistry.findGlobalUniqueEntityId();
/* 4925 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Crab.class, "Crab", CrabID);
/* 4926 */     LanguageRegistry.instance().addStringLocalization("Crab", "en_US", "Crab");
/* 4927 */     LanguageRegistry.instance().addStringLocalization("entity.Crab.name", "en_US", "Crab");
/* 4928 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Crab.class, "Crab", CrabID, this, 64, 1, false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4934 */     GregorianCalendar gcalendar = new GregorianCalendar();
/*      */     
/* 4936 */     int nowmonth = gcalendar.get(2);
/* 4937 */     int nowday = gcalendar.get(5);
/*      */ 
/*      */     
/* 4940 */     if (nowmonth == 9 && nowday == 31) {
/* 4941 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.beach });
/* 4942 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHills });
/* 4943 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHillsEdge });
/* 4944 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 4945 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 4946 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 4947 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 4948 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.plains });
/* 4949 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.river });
/* 4950 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.desert });
/* 4951 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 4952 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 4953 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 4954 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taiga });
/* 4955 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 4956 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/* 4957 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesaPlateau_F });
/* 4958 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesaPlateau });
/* 4959 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesa });
/* 4960 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.coldTaigaHills });
/* 4961 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.coldTaiga });
/* 4962 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/*      */       
/* 4964 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.beach });
/* 4965 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHills });
/* 4966 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHillsEdge });
/* 4967 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 4968 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 4969 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 4970 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 4971 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.plains });
/* 4972 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.river });
/* 4973 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.desert });
/* 4974 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 4975 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 4976 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 4977 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taiga });
/* 4978 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 4979 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/* 4980 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesaPlateau_F });
/* 4981 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesaPlateau });
/* 4982 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesa });
/* 4983 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.coldTaigaHills });
/* 4984 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.coldTaiga });
/* 4985 */       EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/*      */     } 
/*      */ 
/*      */     
/* 4989 */     if (nowmonth == 1 && nowday == 14) {
/* 4990 */       valentines_day = 1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4999 */     if (nowmonth == 3 && nowday == 20) {
/* 5000 */       easter_day = 1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5010 */     if (GirlfriendEnable != 0) {
/* 5011 */       EntityRegistry.addSpawn(Girlfriend.class, 30, 8, 15, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.beach });
/* 5012 */       EntityRegistry.addSpawn(Girlfriend.class, 10, 3, 6, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5013 */       EntityRegistry.addSpawn(Girlfriend.class, 8, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5014 */       EntityRegistry.addSpawn(Girlfriend.class, 5, 2, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5015 */       EntityRegistry.addSpawn(Girlfriend.class, 10, 3, 6, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.river });
/* 5016 */       EntityRegistry.addSpawn(Girlfriend.class, 10, 3, 6, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.stoneBeach });
/* 5017 */       EntityRegistry.addSpawn(Girlfriend.class, 5, 2, 4, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5018 */       EntityRegistry.addSpawn(Girlfriend.class, 5, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5019 */       EntityRegistry.addSpawn(Girlfriend.class, 5, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5020 */       EntityRegistry.addSpawn(Girlfriend.class, 5, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.taiga });
/* 5021 */       EntityRegistry.addSpawn(Girlfriend.class, 2, 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 5022 */       EntityRegistry.addSpawn(Girlfriend.class, 2, 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/*      */     } 
/*      */     
/* 5025 */     if (BoyfriendEnable != 0) {
/* 5026 */       EntityRegistry.addSpawn(Boyfriend.class, 30, 8, 15, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.beach });
/* 5027 */       EntityRegistry.addSpawn(Boyfriend.class, 10, 3, 6, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5028 */       EntityRegistry.addSpawn(Boyfriend.class, 8, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5029 */       EntityRegistry.addSpawn(Boyfriend.class, 5, 2, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5030 */       EntityRegistry.addSpawn(Boyfriend.class, 10, 3, 6, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.river });
/* 5031 */       EntityRegistry.addSpawn(Boyfriend.class, 10, 3, 6, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.stoneBeach });
/* 5032 */       EntityRegistry.addSpawn(Boyfriend.class, 5, 2, 4, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5033 */       EntityRegistry.addSpawn(Boyfriend.class, 5, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5034 */       EntityRegistry.addSpawn(Boyfriend.class, 5, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5035 */       EntityRegistry.addSpawn(Boyfriend.class, 5, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.taiga });
/* 5036 */       EntityRegistry.addSpawn(Boyfriend.class, 2, 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 5037 */       EntityRegistry.addSpawn(Boyfriend.class, 2, 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/*      */     } 
/*      */     
/* 5040 */     if (BeaverEnable != 0) {
/* 5041 */       EntityRegistry.addSpawn(Beaver.class, 10, 2, 4, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.river });
/* 5042 */       EntityRegistry.addSpawn(Beaver.class, 3, 2, 4, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5043 */       EntityRegistry.addSpawn(Beaver.class, 2, 2, 4, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5044 */       EntityRegistry.addSpawn(Beaver.class, 2, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5045 */       EntityRegistry.addSpawn(Beaver.class, 5, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5046 */       EntityRegistry.addSpawn(Beaver.class, 5, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.taiga });
/*      */     } 
/*      */     
/* 5049 */     if (CowEnable != 0) {
/*      */       
/* 5051 */       EntityRegistry.addSpawn(RedCow.class, 8, 4, 8, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5052 */       EntityRegistry.addSpawn(RedCow.class, 8, 4, 8, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5053 */       EntityRegistry.addSpawn(RedCow.class, 5, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5054 */       EntityRegistry.addSpawn(RedCow.class, 5, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.taiga });
/* 5055 */       EntityRegistry.addSpawn(RedCow.class, 8, 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 5056 */       EntityRegistry.addSpawn(RedCow.class, 2, 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/*      */ 
/*      */       
/* 5059 */       EntityRegistry.addSpawn(GoldCow.class, 5, 2, 6, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5060 */       EntityRegistry.addSpawn(GoldCow.class, 5, 2, 6, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5061 */       EntityRegistry.addSpawn(GoldCow.class, 5, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5062 */       EntityRegistry.addSpawn(GoldCow.class, 5, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.taiga });
/*      */ 
/*      */       
/* 5065 */       EntityRegistry.addSpawn(EnchantedCow.class, 3, 2, 4, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5066 */       EntityRegistry.addSpawn(EnchantedCow.class, 3, 2, 4, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5067 */       EntityRegistry.addSpawn(EnchantedCow.class, 5, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5068 */       EntityRegistry.addSpawn(EnchantedCow.class, 15, 3, 6, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.mushroomIsland });
/*      */     } 
/*      */     
/* 5071 */     if (CriminalEnable != 0) {
/* 5072 */       EntityRegistry.addSpawn(BandP.class, 20, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5073 */       EntityRegistry.addSpawn(BandP.class, 20, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.desert });
/* 5074 */       EntityRegistry.addSpawn(BandP.class, 20, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/*      */     } 
/*      */     
/* 5077 */     if (WormEnable != 0) {
/* 5078 */       EntityRegistry.addSpawn(WormLarge.class, 25, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5079 */       EntityRegistry.addSpawn(WormLarge.class, 15, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 5080 */       EntityRegistry.addSpawn(WormLarge.class, 10, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/*      */     } 
/*      */ 
/*      */     
/* 5084 */     if (ButterflyEnable != 0) {
/* 5085 */       EntityRegistry.addSpawn(EntityButterfly.class, 8, 5, 15, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.beach });
/* 5086 */       EntityRegistry.addSpawn(EntityButterfly.class, 5, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHills });
/* 5087 */       EntityRegistry.addSpawn(EntityButterfly.class, 5, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHillsEdge });
/* 5088 */       EntityRegistry.addSpawn(EntityButterfly.class, 30, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5089 */       EntityRegistry.addSpawn(EntityButterfly.class, 20, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5090 */       EntityRegistry.addSpawn(EntityButterfly.class, 20, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5091 */       EntityRegistry.addSpawn(EntityButterfly.class, 10, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5092 */       EntityRegistry.addSpawn(EntityButterfly.class, 20, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5093 */       EntityRegistry.addSpawn(EntityButterfly.class, 20, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.river });
/* 5094 */       EntityRegistry.addSpawn(EntityButterfly.class, 20, 4, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.swampland });
/* 5095 */       EntityRegistry.addSpawn(EntityButterfly.class, 15, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5096 */       EntityRegistry.addSpawn(EntityButterfly.class, 15, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5097 */       EntityRegistry.addSpawn(EntityButterfly.class, 15, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5098 */       EntityRegistry.addSpawn(EntityButterfly.class, 15, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taiga });
/* 5099 */       EntityRegistry.addSpawn(EntityButterfly.class, 10, 1, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 5100 */       EntityRegistry.addSpawn(EntityButterfly.class, 10, 1, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/*      */     } 
/*      */ 
/*      */     
/* 5104 */     if (MothEnable != 0) {
/* 5105 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 8, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHills });
/* 5106 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 8, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHillsEdge });
/* 5107 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 10, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5108 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 20, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5109 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 20, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5110 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 10, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5111 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 20, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.swampland });
/* 5112 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 10, 1, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5113 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 15, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5114 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 15, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5115 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 15, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/* 5116 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 15, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5117 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 15, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taiga });
/* 5118 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 10, 1, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 5119 */       EntityRegistry.addSpawn(EntityLunaMoth.class, 10, 1, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/*      */     } 
/*      */     
/* 5122 */     if (CassowaryEnable != 0) {
/* 5123 */       EntityRegistry.addSpawn(Cassowary.class, 5, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHills });
/* 5124 */       EntityRegistry.addSpawn(Cassowary.class, 5, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHillsEdge });
/* 5125 */       EntityRegistry.addSpawn(Cassowary.class, 5, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHillsPlus });
/* 5126 */       EntityRegistry.addSpawn(Cassowary.class, 5, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5127 */       EntityRegistry.addSpawn(Cassowary.class, 5, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5128 */       EntityRegistry.addSpawn(Cassowary.class, 15, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5129 */       EntityRegistry.addSpawn(Cassowary.class, 15, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaigaHills });
/* 5130 */       EntityRegistry.addSpawn(Cassowary.class, 3, 1, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 5131 */       EntityRegistry.addSpawn(Cassowary.class, 10, 1, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/*      */     } 
/*      */     
/* 5134 */     if (EasterBunnyEnable != 0 && easter_day != 0) {
/* 5135 */       EntityRegistry.addSpawn(EasterBunny.class, 10, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5136 */       EntityRegistry.addSpawn(EasterBunny.class, 10, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5137 */       EntityRegistry.addSpawn(EasterBunny.class, 10, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5138 */       EntityRegistry.addSpawn(EasterBunny.class, 5, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5139 */       EntityRegistry.addSpawn(EasterBunny.class, 5, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5140 */       EntityRegistry.addSpawn(EasterBunny.class, 5, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5141 */       EntityRegistry.addSpawn(EasterBunny.class, 8, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taiga });
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 5146 */     if (FireflyEnable != 0) {
/* 5147 */       EntityRegistry.addSpawn(Firefly.class, 15, 5, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5148 */       EntityRegistry.addSpawn(Firefly.class, 15, 5, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5149 */       EntityRegistry.addSpawn(Firefly.class, 10, 4, 8, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.swampland });
/* 5150 */       EntityRegistry.addSpawn(Firefly.class, 15, 5, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5151 */       EntityRegistry.addSpawn(Firefly.class, 15, 5, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5152 */       EntityRegistry.addSpawn(Firefly.class, 10, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.stoneBeach });
/* 5153 */       EntityRegistry.addSpawn(Firefly.class, 15, 3, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5154 */       EntityRegistry.addSpawn(Firefly.class, 15, 3, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5155 */       EntityRegistry.addSpawn(Firefly.class, 15, 2, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5156 */       EntityRegistry.addSpawn(Firefly.class, 15, 2, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taiga });
/* 5157 */       EntityRegistry.addSpawn(Firefly.class, 15, 2, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaigaHills });
/* 5158 */       EntityRegistry.addSpawn(Firefly.class, 10, 2, 8, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 5159 */       EntityRegistry.addSpawn(Firefly.class, 10, 2, 8, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/*      */     } 
/*      */     
/* 5162 */     if (WhaleEnable != 0) {
/* 5163 */       EntityRegistry.addSpawn(Whale.class, 1, 1, 2, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.deepOcean });
/*      */     }
/*      */     
/* 5166 */     if (BeeEnable != 0) {
/* 5167 */       EntityRegistry.addSpawn(Bee.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5168 */       EntityRegistry.addSpawn(Bee.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5169 */       EntityRegistry.addSpawn(Bee.class, 5, 3, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5170 */       EntityRegistry.addSpawn(Bee.class, 5, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5171 */       EntityRegistry.addSpawn(Bee.class, 3, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5172 */       EntityRegistry.addSpawn(Bee.class, 3, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5173 */       EntityRegistry.addSpawn(Bee.class, 5, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5174 */       EntityRegistry.addSpawn(Bee.class, 5, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taiga });
/* 5175 */       EntityRegistry.addSpawn(Bee.class, 3, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 5176 */       EntityRegistry.addSpawn(Bee.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/*      */     } 
/*      */     
/* 5179 */     if (MantisEnable != 0) {
/* 5180 */       EntityRegistry.addSpawn(Mantis.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5181 */       EntityRegistry.addSpawn(Mantis.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5182 */       EntityRegistry.addSpawn(Mantis.class, 5, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5183 */       EntityRegistry.addSpawn(Mantis.class, 1, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5184 */       EntityRegistry.addSpawn(Mantis.class, 1, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.swampland });
/* 5185 */       EntityRegistry.addSpawn(Mantis.class, 1, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5186 */       EntityRegistry.addSpawn(Mantis.class, 1, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5187 */       EntityRegistry.addSpawn(Mantis.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 5188 */       EntityRegistry.addSpawn(Mantis.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/*      */     } 
/*      */     
/* 5191 */     if (HerculesBeetleEnable != 0) {
/* 5192 */       EntityRegistry.addSpawn(HerculesBeetle.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5193 */       EntityRegistry.addSpawn(HerculesBeetle.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5194 */       EntityRegistry.addSpawn(HerculesBeetle.class, 5, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHillsEdge });
/* 5195 */       EntityRegistry.addSpawn(HerculesBeetle.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taigaHills });
/* 5196 */       EntityRegistry.addSpawn(HerculesBeetle.class, 5, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5197 */       EntityRegistry.addSpawn(HerculesBeetle.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.coldTaigaHills });
/* 5198 */       EntityRegistry.addSpawn(HerculesBeetle.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaigaHills });
/*      */     } 
/*      */     
/* 5201 */     if (MolenoidEnable != 0) {
/* 5202 */       EntityRegistry.addSpawn(Molenoid.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5203 */       EntityRegistry.addSpawn(Molenoid.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 5204 */       EntityRegistry.addSpawn(Molenoid.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/*      */     } 
/*      */     
/* 5207 */     if (CaterKillerEnable != 0) {
/* 5208 */       EntityRegistry.addSpawn(CaterKiller.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5209 */       EntityRegistry.addSpawn(CaterKiller.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5210 */       EntityRegistry.addSpawn(CaterKiller.class, 4, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5211 */       EntityRegistry.addSpawn(CaterKiller.class, 4, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5212 */       EntityRegistry.addSpawn(CaterKiller.class, 6, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5213 */       EntityRegistry.addSpawn(CaterKiller.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5214 */       EntityRegistry.addSpawn(CaterKiller.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5215 */       EntityRegistry.addSpawn(CaterKiller.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taiga });
/* 5216 */       EntityRegistry.addSpawn(CaterKiller.class, 10, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/*      */     } 
/*      */     
/* 5219 */     if (ChipmunkEnable != 0) {
/* 5220 */       EntityRegistry.addSpawn(Chipmunk.class, 8, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5221 */       EntityRegistry.addSpawn(Chipmunk.class, 5, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5222 */       EntityRegistry.addSpawn(Chipmunk.class, 4, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5223 */       EntityRegistry.addSpawn(Chipmunk.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5224 */       EntityRegistry.addSpawn(Chipmunk.class, 5, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5225 */       EntityRegistry.addSpawn(Chipmunk.class, 4, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5226 */       EntityRegistry.addSpawn(Chipmunk.class, 10, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/* 5227 */       EntityRegistry.addSpawn(Chipmunk.class, 2, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5228 */       EntityRegistry.addSpawn(Chipmunk.class, 6, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taiga });
/*      */     } 
/*      */     
/* 5231 */     if (OstrichEnable != 0) {
/* 5232 */       EntityRegistry.addSpawn(Ostrich.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.desert });
/* 5233 */       EntityRegistry.addSpawn(Ostrich.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.stoneBeach });
/* 5234 */       EntityRegistry.addSpawn(Ostrich.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 5235 */       EntityRegistry.addSpawn(Ostrich.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/*      */     } 
/*      */ 
/*      */     
/* 5239 */     if (CephadromeEnable != 0) {
/* 5240 */       EntityRegistry.addSpawn(Cephadrome.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.icePlains });
/* 5241 */       EntityRegistry.addSpawn(Cephadrome.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.coldTaiga });
/*      */     } 
/*      */ 
/*      */     
/* 5245 */     if (MosquitoEnable != 0) {
/* 5246 */       EntityRegistry.addSpawn(EntityMosquito.class, 30, 5, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.swampland });
/* 5247 */       EntityRegistry.addSpawn(EntityMosquito.class, 20, 5, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5248 */       EntityRegistry.addSpawn(EntityMosquito.class, 20, 5, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5249 */       EntityRegistry.addSpawn(EntityMosquito.class, 15, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/*      */     } 
/*      */ 
/*      */     
/* 5253 */     if (GhostEnable != 0) {
/* 5254 */       EntityRegistry.addSpawn(Ghost.class, 15, 5, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.coldTaiga });
/* 5255 */       EntityRegistry.addSpawn(Ghost.class, 10, 5, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taigaHills });
/* 5256 */       EntityRegistry.addSpawn(Ghost.class, 6, 4, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.frozenRiver });
/* 5257 */       EntityRegistry.addSpawn(Ghost.class, 2, 1, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5258 */       EntityRegistry.addSpawn(Ghost.class, 15, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/*      */     } 
/*      */ 
/*      */     
/* 5262 */     if (GhostSkellyEnable != 0) {
/* 5263 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 5, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.coldTaiga });
/* 5264 */       EntityRegistry.addSpawn(GhostSkelly.class, 10, 5, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taigaHills });
/* 5265 */       EntityRegistry.addSpawn(GhostSkelly.class, 6, 4, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.frozenRiver });
/* 5266 */       EntityRegistry.addSpawn(GhostSkelly.class, 2, 1, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5267 */       EntityRegistry.addSpawn(GhostSkelly.class, 15, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/*      */     } 
/*      */     
/* 5270 */     if (DragonflyEnable != 0) {
/* 5271 */       EntityRegistry.addSpawn(Dragonfly.class, 5, 3, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.swampland });
/* 5272 */       EntityRegistry.addSpawn(Dragonfly.class, 4, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.river });
/*      */     } 
/*      */ 
/*      */     
/* 5276 */     if (KyuubiEnable != 0) {
/* 5277 */       EntityRegistry.addSpawn(Kyuubi.class, 10, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
/*      */     }
/*      */     
/* 5280 */     if (StinkyEnable != 0) {
/* 5281 */       EntityRegistry.addSpawn(Stinky.class, 2, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
/* 5282 */       EntityRegistry.addSpawn(Stinky.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesa });
/* 5283 */       EntityRegistry.addSpawn(Stinky.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesaPlateau });
/* 5284 */       EntityRegistry.addSpawn(Stinky.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesaPlateau_F });
/*      */     } 
/*      */     
/* 5287 */     if (CockateilEnable != 0) {
/* 5288 */       EntityRegistry.addSpawn(Cockateil.class, 10, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.beach });
/* 5289 */       EntityRegistry.addSpawn(Cockateil.class, 10, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHills });
/* 5290 */       EntityRegistry.addSpawn(Cockateil.class, 10, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHillsEdge });
/* 5291 */       EntityRegistry.addSpawn(Cockateil.class, 25, 5, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5292 */       EntityRegistry.addSpawn(Cockateil.class, 20, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5293 */       EntityRegistry.addSpawn(Cockateil.class, 35, 5, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5294 */       EntityRegistry.addSpawn(Cockateil.class, 25, 5, 10, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5295 */       EntityRegistry.addSpawn(Cockateil.class, 10, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5296 */       EntityRegistry.addSpawn(Cockateil.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.river });
/* 5297 */       EntityRegistry.addSpawn(Cockateil.class, 5, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.stoneBeach });
/* 5298 */       EntityRegistry.addSpawn(Cockateil.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5299 */       EntityRegistry.addSpawn(Cockateil.class, 5, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5300 */       EntityRegistry.addSpawn(Cockateil.class, 15, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5301 */       EntityRegistry.addSpawn(Cockateil.class, 15, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taiga });
/* 5302 */       EntityRegistry.addSpawn(Cockateil.class, 11, 1, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 5303 */       EntityRegistry.addSpawn(Cockateil.class, 11, 1, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/*      */     } 
/*      */ 
/*      */     
/* 5307 */     if (HydroliscEnable != 0) {
/* 5308 */       EntityRegistry.addSpawn(Hydrolisc.class, 25, 3, 6, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.swampland });
/* 5309 */       EntityRegistry.addSpawn(Hydrolisc.class, 15, 2, 5, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5310 */       EntityRegistry.addSpawn(Hydrolisc.class, 10, 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5311 */       EntityRegistry.addSpawn(Hydrolisc.class, 5, 3, 6, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.stoneBeach });
/*      */     } 
/*      */ 
/*      */     
/* 5315 */     if (MothraEnable != 0) {
/* 5316 */       EntityRegistry.addSpawn(Mothra.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHills });
/* 5317 */       EntityRegistry.addSpawn(Mothra.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHillsPlus });
/*      */     } 
/* 5319 */     if (BrutalflyEnable != 0) {
/* 5320 */       EntityRegistry.addSpawn(Brutalfly.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaigaHills });
/* 5321 */       EntityRegistry.addSpawn(Brutalfly.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHillsPlus });
/* 5322 */       EntityRegistry.addSpawn(Brutalfly.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesaPlateau });
/*      */     } 
/* 5324 */     if (WaterDragonEnable != 0) {
/* 5325 */       EntityRegistry.addSpawn(WaterDragon.class, 5, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.river });
/* 5326 */       EntityRegistry.addSpawn(WaterDragon.class, 3, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.swampland });
/* 5327 */       EntityRegistry.addSpawn(WaterDragon.class, 2, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.ocean });
/* 5328 */       EntityRegistry.addSpawn(WaterDragon.class, 2, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.stoneBeach });
/*      */     } 
/* 5330 */     if (SeaMonsterEnable != 0) {
/* 5331 */       EntityRegistry.addSpawn(SeaMonster.class, 4, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.ocean });
/* 5332 */       EntityRegistry.addSpawn(SeaMonster.class, 2, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.swampland });
/*      */     } 
/* 5334 */     if (SeaViperEnable != 0) {
/* 5335 */       EntityRegistry.addSpawn(SeaViper.class, 3, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.ocean });
/* 5336 */       EntityRegistry.addSpawn(SeaViper.class, 2, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.stoneBeach });
/*      */     } 
/* 5338 */     if (CrabEnable != 0) {
/* 5339 */       EntityRegistry.addSpawn(Crab.class, 2, 3, 6, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.ocean });
/* 5340 */       EntityRegistry.addSpawn(Crab.class, 1, 3, 6, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.swampland });
/* 5341 */       EntityRegistry.addSpawn(Crab.class, 1, 2, 4, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.stoneBeach });
/*      */     } 
/* 5343 */     if (AttackSquidEnable != 0) {
/* 5344 */       EntityRegistry.addSpawn(AttackSquid.class, 12, 6, 10, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.river });
/* 5345 */       EntityRegistry.addSpawn(AttackSquid.class, 10, 5, 9, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.swampland });
/* 5346 */       EntityRegistry.addSpawn(AttackSquid.class, 7, 4, 8, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.ocean });
/*      */     } 
/* 5348 */     if (LizardEnable != 0) {
/* 5349 */       EntityRegistry.addSpawn(Lizard.class, 5, 2, 4, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.river });
/* 5350 */       EntityRegistry.addSpawn(Lizard.class, 4, 2, 4, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.swampland });
/* 5351 */       EntityRegistry.addSpawn(Lizard.class, 2, 2, 4, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.ocean });
/*      */     } 
/* 5353 */     if (RubberDuckyEnable != 0) {
/* 5354 */       EntityRegistry.addSpawn(RubberDucky.class, 10, 10, 20, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.river });
/* 5355 */       EntityRegistry.addSpawn(RubberDucky.class, 4, 4, 6, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.stoneBeach });
/*      */     } 
/* 5357 */     if (BasiliskEnable != 0) {
/* 5358 */       EntityRegistry.addSpawn(Basilisk.class, 3, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5359 */       EntityRegistry.addSpawn(Basilisk.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5360 */       EntityRegistry.addSpawn(Basilisk.class, 4, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5361 */       EntityRegistry.addSpawn(Basilisk.class, 15, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/*      */     } 
/* 5363 */     if (EmperorScorpionEnable != 0) {
/* 5364 */       EntityRegistry.addSpawn(EmperorScorpion.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.desert });
/* 5365 */       EntityRegistry.addSpawn(EmperorScorpion.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/*      */     } 
/* 5367 */     if (TrooperBugEnable != 0) {
/* 5368 */       EntityRegistry.addSpawn(TrooperBug.class, 3, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.swampland });
/* 5369 */       EntityRegistry.addSpawn(TrooperBug.class, 1, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesa });
/*      */     } 
/* 5371 */     if (SpitBugEnable != 0) {
/* 5372 */       EntityRegistry.addSpawn(SpitBug.class, 6, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.swampland });
/*      */     }
/* 5374 */     if (StinkBugEnable != 0) {
/* 5375 */       EntityRegistry.addSpawn(StinkBug.class, 10, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5376 */       EntityRegistry.addSpawn(StinkBug.class, 8, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5377 */       EntityRegistry.addSpawn(StinkBug.class, 6, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5378 */       EntityRegistry.addSpawn(StinkBug.class, 4, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5379 */       EntityRegistry.addSpawn(StinkBug.class, 8, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/*      */     } 
/* 5381 */     if (ScorpionEnable != 0) {
/* 5382 */       EntityRegistry.addSpawn(Scorpion.class, 15, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.desert });
/* 5383 */       EntityRegistry.addSpawn(Scorpion.class, 28, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/* 5384 */       EntityRegistry.addSpawn(Scorpion.class, 15, 3, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savanna });
/* 5385 */       EntityRegistry.addSpawn(Scorpion.class, 15, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/* 5386 */       EntityRegistry.addSpawn(Scorpion.class, 6, 1, 3, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesa });
/* 5387 */       EntityRegistry.addSpawn(Scorpion.class, 4, 1, 3, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesaPlateau });
/* 5388 */       EntityRegistry.addSpawn(Scorpion.class, 5, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesaPlateau_F });
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5457 */     if (LeafMonsterEnable != 0) {
/* 5458 */       EntityRegistry.addSpawn(LeafMonster.class, 5, 2, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5459 */       EntityRegistry.addSpawn(LeafMonster.class, 5, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5460 */       EntityRegistry.addSpawn(LeafMonster.class, 3, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5461 */       EntityRegistry.addSpawn(LeafMonster.class, 3, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5462 */       EntityRegistry.addSpawn(LeafMonster.class, 3, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5463 */       EntityRegistry.addSpawn(LeafMonster.class, 2, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5464 */       EntityRegistry.addSpawn(LeafMonster.class, 2, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5465 */       EntityRegistry.addSpawn(LeafMonster.class, 2, 2, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taiga });
/*      */     } 
/*      */     
/* 5468 */     if (EnderKnightEnable != 0) {
/* 5469 */       EntityRegistry.addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHills });
/* 5470 */       EntityRegistry.addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHillsEdge });
/* 5471 */       EntityRegistry.addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5472 */       EntityRegistry.addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5473 */       EntityRegistry.addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5474 */       EntityRegistry.addSpawn(EnderKnight.class, 2, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5475 */       EntityRegistry.addSpawn(EnderKnight.class, 2, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.river });
/* 5476 */       EntityRegistry.addSpawn(EnderKnight.class, 2, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.desert });
/* 5477 */       EntityRegistry.addSpawn(EnderKnight.class, 20, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/*      */     } 
/* 5479 */     if (EnderReaperEnable != 0) {
/* 5480 */       EntityRegistry.addSpawn(EnderReaper.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHills });
/* 5481 */       EntityRegistry.addSpawn(EnderReaper.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.extremeHillsEdge });
/* 5482 */       EntityRegistry.addSpawn(EnderReaper.class, 1, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5483 */       EntityRegistry.addSpawn(EnderReaper.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5484 */       EntityRegistry.addSpawn(EnderReaper.class, 2, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5485 */       EntityRegistry.addSpawn(EnderReaper.class, 1, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5486 */       EntityRegistry.addSpawn(EnderReaper.class, 1, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.river });
/* 5487 */       EntityRegistry.addSpawn(EnderReaper.class, 1, 1, 2, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.desert });
/* 5488 */       EntityRegistry.addSpawn(EnderReaper.class, 38, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/*      */     } 
/*      */     
/* 5491 */     if (CoinEnable != 0) {
/* 5492 */       EntityRegistry.addSpawn(Coin.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taiga });
/* 5493 */       EntityRegistry.addSpawn(Coin.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5494 */       EntityRegistry.addSpawn(Coin.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5495 */       EntityRegistry.addSpawn(Coin.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5496 */       EntityRegistry.addSpawn(Coin.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.coldTaiga });
/* 5497 */       EntityRegistry.addSpawn(Coin.class, 2, 1, 1, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/*      */     } 
/*      */     
/* 5500 */     if (CricketEnable != 0) {
/* 5501 */       EntityRegistry.addSpawn(Cricket.class, 3, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forest });
/* 5502 */       EntityRegistry.addSpawn(Cricket.class, 2, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.forestHills });
/* 5503 */       EntityRegistry.addSpawn(Cricket.class, 3, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5504 */       EntityRegistry.addSpawn(Cricket.class, 2, 3, 5, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungleHills });
/* 5505 */       EntityRegistry.addSpawn(Cricket.class, 3, 4, 8, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.plains });
/* 5506 */       EntityRegistry.addSpawn(Cricket.class, 2, 2, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForest });
/* 5507 */       EntityRegistry.addSpawn(Cricket.class, 2, 2, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.birchForestHills });
/* 5508 */       EntityRegistry.addSpawn(Cricket.class, 3, 1, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/* 5509 */       EntityRegistry.addSpawn(Cricket.class, 2, 1, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.megaTaiga });
/* 5510 */       EntityRegistry.addSpawn(Cricket.class, 2, 1, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taiga });
/* 5511 */       EntityRegistry.addSpawn(Cricket.class, 1, 1, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.savannaPlateau });
/*      */     } 
/* 5513 */     if (FrogEnable != 0) {
/* 5514 */       EntityRegistry.addSpawn(Frog.class, 20, 3, 6, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.river });
/* 5515 */       EntityRegistry.addSpawn(Frog.class, 3, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.river });
/* 5516 */       EntityRegistry.addSpawn(Frog.class, 3, 3, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.jungle });
/* 5517 */       EntityRegistry.addSpawn(Frog.class, 20, 2, 6, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.swampland });
/* 5518 */       EntityRegistry.addSpawn(Frog.class, 2, 2, 6, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.swampland });
/*      */     } 
/*      */     
/* 5521 */     if (PeacockEnable != 0) {
/* 5522 */       EntityRegistry.addSpawn(Peacock.class, 1, 1, 3, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesa });
/* 5523 */       EntityRegistry.addSpawn(Peacock.class, 1, 1, 3, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.mesaPlateau });
/*      */     } 
/*      */     
/* 5526 */     if (FairyEnable != 0) {
/* 5527 */       EntityRegistry.addSpawn(Fairy.class, 25, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/*      */     }
/* 5529 */     if (RatEnable != 0) {
/* 5530 */       EntityRegistry.addSpawn(Rat.class, 35, 10, 20, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/* 5531 */       EntityRegistry.addSpawn(Rat.class, 25, 2, 8, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.taiga });
/*      */     } 
/* 5533 */     if (DungeonBeastEnable != 0) {
/* 5534 */       EntityRegistry.addSpawn(DungeonBeast.class, 20, 2, 4, EnumCreatureType.ambient, new BiomeGenBase[] { BiomeGenBase.roofedForest });
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5542 */     EntityRegistry.instance(); int shoeid = EntityRegistry.findGlobalUniqueEntityId();
/* 5543 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(Shoes.class, "Shoes", shoeid);
/* 5544 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(Shoes.class, "Shoes", shoeid, this, 64, 1, true);
/* 5545 */     LanguageRegistry.instance().addNameForObject(MyItemShoes, "en_US", "Red Heels");
/* 5546 */     LanguageRegistry.instance().addNameForObject(MyItemShoes_1, "en_US", "Black Heels");
/* 5547 */     LanguageRegistry.instance().addNameForObject(MyItemShoes_2, "en_US", "Slippers");
/* 5548 */     LanguageRegistry.instance().addNameForObject(MyItemShoes_3, "en_US", "Boots");
/* 5549 */     LanguageRegistry.instance().addNameForObject(MyItemGameController, "en_US", "Game Controller");
/*      */ 
/*      */     
/* 5552 */     LanguageRegistry.instance().addNameForObject(UltimateHelmet, "en_US", "The Ultimate Helmet");
/* 5553 */     LanguageRegistry.instance().addNameForObject(UltimateBody, "en_US", "The Ultimate Chestplate");
/* 5554 */     LanguageRegistry.instance().addNameForObject(UltimateLegs, "en_US", "The Ultimate Leggings");
/* 5555 */     LanguageRegistry.instance().addNameForObject(UltimateBoots, "en_US", "The Ultimate Boots");
/*      */     
/* 5557 */     GameRegistry.addRecipe(new ItemStack((Item)UltimateHelmet), new Object[] { "   ", "TIT", "U U", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5562 */     GameRegistry.addRecipe(new ItemStack((Item)UltimateHelmet), new Object[] { "TIT", "U U", "   ", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5567 */     GameRegistry.addRecipe(new ItemStack((Item)UltimateBody), new Object[] { "I I", "TTT", "UUU", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5572 */     GameRegistry.addRecipe(new ItemStack((Item)UltimateLegs), new Object[] { "III", "T T", "U U", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5577 */     GameRegistry.addRecipe(new ItemStack((Item)UltimateBoots), new Object[] { "   ", "T T", "U U", Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */     
/* 5581 */     GameRegistry.addRecipe(new ItemStack((Item)UltimateBoots), new Object[] { "T T", "U U", "   ", Character.valueOf('U'), MyIngotUranium, Character.valueOf('T'), MyIngotTitanium });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5587 */     LanguageRegistry.instance().addNameForObject(LavaEelHelmet, "en_US", "Lava Eel Helmet");
/* 5588 */     LanguageRegistry.instance().addNameForObject(LavaEelBody, "en_US", "Lava Eel Chestplate");
/* 5589 */     LanguageRegistry.instance().addNameForObject(LavaEelLegs, "en_US", "Lava Eel Leggings");
/* 5590 */     LanguageRegistry.instance().addNameForObject(LavaEelBoots, "en_US", "Lava Eel Boots");
/*      */     
/* 5592 */     GameRegistry.addRecipe(new ItemStack((Item)LavaEelHelmet), new Object[] { "   ", "***", "* *", Character.valueOf('*'), MyLavaEel });
/*      */ 
/*      */     
/* 5595 */     GameRegistry.addRecipe(new ItemStack((Item)LavaEelHelmet), new Object[] { "***", "* *", "   ", Character.valueOf('*'), MyLavaEel });
/*      */ 
/*      */     
/* 5598 */     GameRegistry.addRecipe(new ItemStack((Item)LavaEelBody), new Object[] { "* *", "***", "***", Character.valueOf('*'), MyLavaEel });
/*      */ 
/*      */     
/* 5601 */     GameRegistry.addRecipe(new ItemStack((Item)LavaEelLegs), new Object[] { "***", "* *", "* *", Character.valueOf('*'), MyLavaEel });
/*      */ 
/*      */     
/* 5604 */     GameRegistry.addRecipe(new ItemStack((Item)LavaEelBoots), new Object[] { "   ", "* *", "* *", Character.valueOf('*'), MyLavaEel });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5609 */     LanguageRegistry.instance().addNameForObject(MothScaleHelmet, "en_US", "Moth Scale Helmet");
/* 5610 */     LanguageRegistry.instance().addNameForObject(MothScaleBody, "en_US", "Moth Scale Chestplate");
/* 5611 */     LanguageRegistry.instance().addNameForObject(MothScaleLegs, "en_US", "Moth Scale Leggings");
/* 5612 */     LanguageRegistry.instance().addNameForObject(MothScaleBoots, "en_US", "Moth Scale Boots");
/*      */     
/* 5614 */     GameRegistry.addRecipe(new ItemStack((Item)MothScaleHelmet), new Object[] { "   ", "***", "* *", Character.valueOf('*'), MyMothScale });
/*      */ 
/*      */     
/* 5617 */     GameRegistry.addRecipe(new ItemStack((Item)MothScaleHelmet), new Object[] { "***", "* *", "   ", Character.valueOf('*'), MyMothScale });
/*      */ 
/*      */     
/* 5620 */     GameRegistry.addRecipe(new ItemStack((Item)MothScaleBody), new Object[] { "* *", "***", "***", Character.valueOf('*'), MyMothScale });
/*      */ 
/*      */     
/* 5623 */     GameRegistry.addRecipe(new ItemStack((Item)MothScaleLegs), new Object[] { "***", "* *", "* *", Character.valueOf('*'), MyMothScale });
/*      */ 
/*      */     
/* 5626 */     GameRegistry.addRecipe(new ItemStack((Item)MothScaleBoots), new Object[] { "   ", "* *", "* *", Character.valueOf('*'), MyMothScale });
/*      */ 
/*      */ 
/*      */     
/* 5630 */     LanguageRegistry.instance().addNameForObject(EmeraldHelmet, "en_US", "Emerald Helmet");
/* 5631 */     LanguageRegistry.instance().addNameForObject(EmeraldBody, "en_US", "Emerald Chestplate");
/* 5632 */     LanguageRegistry.instance().addNameForObject(EmeraldLegs, "en_US", "Emerald Leggings");
/* 5633 */     LanguageRegistry.instance().addNameForObject(EmeraldBoots, "en_US", "Emerald Boots");
/*      */     
/* 5635 */     GameRegistry.addRecipe(new ItemStack((Item)EmeraldHelmet), new Object[] { "   ", "***", "* *", Character.valueOf('*'), Items.emerald });
/*      */ 
/*      */     
/* 5638 */     GameRegistry.addRecipe(new ItemStack((Item)EmeraldHelmet), new Object[] { "***", "* *", "   ", Character.valueOf('*'), Items.emerald });
/*      */ 
/*      */     
/* 5641 */     GameRegistry.addRecipe(new ItemStack((Item)EmeraldBody), new Object[] { "* *", "***", "***", Character.valueOf('*'), Items.emerald });
/*      */ 
/*      */     
/* 5644 */     GameRegistry.addRecipe(new ItemStack((Item)EmeraldLegs), new Object[] { "***", "* *", "* *", Character.valueOf('*'), Items.emerald });
/*      */ 
/*      */     
/* 5647 */     GameRegistry.addRecipe(new ItemStack((Item)EmeraldBoots), new Object[] { "   ", "* *", "* *", Character.valueOf('*'), Items.emerald });
/*      */ 
/*      */ 
/*      */     
/* 5651 */     LanguageRegistry.instance().addNameForObject(RubyHelmet, "en_US", "Ruby Helmet");
/* 5652 */     LanguageRegistry.instance().addNameForObject(RubyBody, "en_US", "Ruby Chestplate");
/* 5653 */     LanguageRegistry.instance().addNameForObject(RubyLegs, "en_US", "Ruby Leggings");
/* 5654 */     LanguageRegistry.instance().addNameForObject(RubyBoots, "en_US", "Ruby Boots");
/*      */     
/* 5656 */     GameRegistry.addRecipe(new ItemStack((Item)RubyHelmet), new Object[] { "   ", "***", "* *", Character.valueOf('*'), MyRuby });
/*      */ 
/*      */     
/* 5659 */     GameRegistry.addRecipe(new ItemStack((Item)RubyHelmet), new Object[] { "***", "* *", "   ", Character.valueOf('*'), MyRuby });
/*      */ 
/*      */     
/* 5662 */     GameRegistry.addRecipe(new ItemStack((Item)RubyBody), new Object[] { "* *", "***", "***", Character.valueOf('*'), MyRuby });
/*      */ 
/*      */     
/* 5665 */     GameRegistry.addRecipe(new ItemStack((Item)RubyLegs), new Object[] { "***", "* *", "* *", Character.valueOf('*'), MyRuby });
/*      */ 
/*      */     
/* 5668 */     GameRegistry.addRecipe(new ItemStack((Item)RubyBoots), new Object[] { "   ", "* *", "* *", Character.valueOf('*'), MyRuby });
/*      */ 
/*      */ 
/*      */     
/* 5672 */     LanguageRegistry.instance().addNameForObject(AmethystHelmet, "en_US", "Amethyst Helmet");
/* 5673 */     LanguageRegistry.instance().addNameForObject(AmethystBody, "en_US", "Amethyst Chestplate");
/* 5674 */     LanguageRegistry.instance().addNameForObject(AmethystLegs, "en_US", "Amethyst Leggings");
/* 5675 */     LanguageRegistry.instance().addNameForObject(AmethystBoots, "en_US", "Amethyst Boots");
/*      */     
/* 5677 */     GameRegistry.addRecipe(new ItemStack((Item)AmethystHelmet), new Object[] { "   ", "***", "* *", Character.valueOf('*'), MyAmethyst });
/*      */ 
/*      */     
/* 5680 */     GameRegistry.addRecipe(new ItemStack((Item)AmethystHelmet), new Object[] { "***", "* *", "   ", Character.valueOf('*'), MyAmethyst });
/*      */ 
/*      */     
/* 5683 */     GameRegistry.addRecipe(new ItemStack((Item)AmethystBody), new Object[] { "* *", "***", "***", Character.valueOf('*'), MyAmethyst });
/*      */ 
/*      */     
/* 5686 */     GameRegistry.addRecipe(new ItemStack((Item)AmethystLegs), new Object[] { "***", "* *", "* *", Character.valueOf('*'), MyAmethyst });
/*      */ 
/*      */     
/* 5689 */     GameRegistry.addRecipe(new ItemStack((Item)AmethystBoots), new Object[] { "   ", "* *", "* *", Character.valueOf('*'), MyAmethyst });
/*      */ 
/*      */ 
/*      */     
/* 5693 */     LanguageRegistry.instance().addNameForObject(CrystalPinkHelmet, "en_US", "Pink Tourmailine Helmet");
/* 5694 */     LanguageRegistry.instance().addNameForObject(CrystalPinkBody, "en_US", "Pink Tourmailine Chestplate");
/* 5695 */     LanguageRegistry.instance().addNameForObject(CrystalPinkLegs, "en_US", "Pink Tourmailine Leggings");
/* 5696 */     LanguageRegistry.instance().addNameForObject(CrystalPinkBoots, "en_US", "Pink Tourmailine Boots");
/*      */ 
/*      */     
/* 5699 */     GameRegistry.addRecipe(new ItemStack((Item)CrystalPinkHelmet), new Object[] { "   ", "***", "* *", Character.valueOf('*'), MyCrystalPinkIngot });
/*      */ 
/*      */     
/* 5702 */     GameRegistry.addRecipe(new ItemStack((Item)CrystalPinkHelmet), new Object[] { "***", "* *", "   ", Character.valueOf('*'), MyCrystalPinkIngot });
/*      */ 
/*      */     
/* 5705 */     GameRegistry.addRecipe(new ItemStack((Item)CrystalPinkBody), new Object[] { "* *", "***", "***", Character.valueOf('*'), MyCrystalPinkIngot });
/*      */ 
/*      */     
/* 5708 */     GameRegistry.addRecipe(new ItemStack((Item)CrystalPinkLegs), new Object[] { "***", "* *", "* *", Character.valueOf('*'), MyCrystalPinkIngot });
/*      */ 
/*      */     
/* 5711 */     GameRegistry.addRecipe(new ItemStack((Item)CrystalPinkBoots), new Object[] { "   ", "* *", "* *", Character.valueOf('*'), MyCrystalPinkIngot });
/*      */ 
/*      */ 
/*      */     
/* 5715 */     LanguageRegistry.instance().addNameForObject(MobzillaHelmet, "en_US", "Mobzilla Scale Helmet");
/* 5716 */     LanguageRegistry.instance().addNameForObject(MobzillaBody, "en_US", "Mobzilla Scale Chestplate");
/* 5717 */     LanguageRegistry.instance().addNameForObject(MobzillaLegs, "en_US", "Mobzilla Scale Leggings");
/* 5718 */     LanguageRegistry.instance().addNameForObject(MobzillaBoots, "en_US", "Mobzilla Scale Boots");
/*      */     
/* 5720 */     LanguageRegistry.instance().addNameForObject(RoyalHelmet, "en_US", "Royal Guardian Helmet");
/* 5721 */     LanguageRegistry.instance().addNameForObject(RoyalBody, "en_US", "Royal Guardian Chestplate");
/* 5722 */     LanguageRegistry.instance().addNameForObject(RoyalLegs, "en_US", "Royal Guardian Leggings");
/* 5723 */     LanguageRegistry.instance().addNameForObject(RoyalBoots, "en_US", "Royal Guardian Boots");
/*      */     
/* 5725 */     LanguageRegistry.instance().addNameForObject(LapisHelmet, "en_US", "Lapis Lazuli Helmet");
/* 5726 */     LanguageRegistry.instance().addNameForObject(LapisBody, "en_US", "Lapis Lazuli Chestplate");
/* 5727 */     LanguageRegistry.instance().addNameForObject(LapisLegs, "en_US", "Lapis Lazuli Leggings");
/* 5728 */     LanguageRegistry.instance().addNameForObject(LapisBoots, "en_US", "Lapis Lazuli Boots");
/*      */     
/* 5730 */     LanguageRegistry.instance().addNameForObject(QueenHelmet, "en_US", "Queen Scale Helmet");
/* 5731 */     LanguageRegistry.instance().addNameForObject(QueenBody, "en_US", "Queen Scale Chestplate");
/* 5732 */     LanguageRegistry.instance().addNameForObject(QueenLegs, "en_US", "Queen Scale Leggings");
/* 5733 */     LanguageRegistry.instance().addNameForObject(QueenBoots, "en_US", "Queen Scale Boots");
/*      */ 
/*      */     
/* 5736 */     GameRegistry.addRecipe(new ItemStack((Item)MobzillaHelmet), new Object[] { "   ", "***", "* *", Character.valueOf('*'), MyGodzillaScale });
/*      */ 
/*      */     
/* 5739 */     GameRegistry.addRecipe(new ItemStack((Item)MobzillaHelmet), new Object[] { "***", "* *", "   ", Character.valueOf('*'), MyGodzillaScale });
/*      */ 
/*      */     
/* 5742 */     GameRegistry.addRecipe(new ItemStack((Item)MobzillaBody), new Object[] { "* *", "***", "***", Character.valueOf('*'), MyGodzillaScale });
/*      */ 
/*      */     
/* 5745 */     GameRegistry.addRecipe(new ItemStack((Item)MobzillaLegs), new Object[] { "***", "* *", "* *", Character.valueOf('*'), MyGodzillaScale });
/*      */ 
/*      */     
/* 5748 */     GameRegistry.addRecipe(new ItemStack((Item)MobzillaBoots), new Object[] { "   ", "* *", "* *", Character.valueOf('*'), MyGodzillaScale });
/*      */ 
/*      */ 
/*      */     
/* 5752 */     GameRegistry.addRecipe(new ItemStack((Item)LapisHelmet), new Object[] { "   ", "***", "* *", Character.valueOf('*'), Blocks.lapis_block });
/*      */ 
/*      */     
/* 5755 */     GameRegistry.addRecipe(new ItemStack((Item)LapisHelmet), new Object[] { "***", "* *", "   ", Character.valueOf('*'), Blocks.lapis_block });
/*      */ 
/*      */     
/* 5758 */     GameRegistry.addRecipe(new ItemStack((Item)LapisBody), new Object[] { "* *", "***", "***", Character.valueOf('*'), Blocks.lapis_block });
/*      */ 
/*      */     
/* 5761 */     GameRegistry.addRecipe(new ItemStack((Item)LapisLegs), new Object[] { "***", "* *", "* *", Character.valueOf('*'), Blocks.lapis_block });
/*      */ 
/*      */     
/* 5764 */     GameRegistry.addRecipe(new ItemStack((Item)LapisBoots), new Object[] { "   ", "* *", "* *", Character.valueOf('*'), Blocks.lapis_block });
/*      */ 
/*      */ 
/*      */     
/* 5768 */     GameRegistry.addRecipe(new ItemStack((Item)QueenHelmet), new Object[] { "   ", "***", "* *", Character.valueOf('*'), MyQueenScale });
/*      */ 
/*      */     
/* 5771 */     GameRegistry.addRecipe(new ItemStack((Item)QueenHelmet), new Object[] { "***", "* *", "   ", Character.valueOf('*'), MyQueenScale });
/*      */ 
/*      */     
/* 5774 */     GameRegistry.addRecipe(new ItemStack((Item)QueenBody), new Object[] { "* *", "***", "***", Character.valueOf('*'), MyQueenScale });
/*      */ 
/*      */     
/* 5777 */     GameRegistry.addRecipe(new ItemStack((Item)QueenLegs), new Object[] { "***", "* *", "* *", Character.valueOf('*'), MyQueenScale });
/*      */ 
/*      */     
/* 5780 */     GameRegistry.addRecipe(new ItemStack((Item)QueenBoots), new Object[] { "   ", "* *", "* *", Character.valueOf('*'), MyQueenScale });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5785 */     LanguageRegistry.instance().addNameForObject(PeacockFeatherBoots, "en_US", "Peacock Feather Boots");
/* 5786 */     LanguageRegistry.instance().addNameForObject(PeacockFeatherHelmet, "en_US", "Peacock Feather Helmet");
/* 5787 */     LanguageRegistry.instance().addNameForObject(PeacockFeatherBody, "en_US", "Peacock Feather Chestplate");
/* 5788 */     LanguageRegistry.instance().addNameForObject(PeacockFeatherLegs, "en_US", "Peacock Feather Leggings");
/*      */     
/* 5790 */     GameRegistry.addRecipe(new ItemStack((Item)PeacockFeatherHelmet), new Object[] { "   ", "***", "* *", Character.valueOf('*'), MyPeacockFeather });
/*      */ 
/*      */     
/* 5793 */     GameRegistry.addRecipe(new ItemStack((Item)PeacockFeatherHelmet), new Object[] { "***", "* *", "   ", Character.valueOf('*'), MyPeacockFeather });
/*      */ 
/*      */     
/* 5796 */     GameRegistry.addRecipe(new ItemStack((Item)PeacockFeatherBody), new Object[] { "* *", "***", "***", Character.valueOf('*'), MyPeacockFeather });
/*      */ 
/*      */     
/* 5799 */     GameRegistry.addRecipe(new ItemStack((Item)PeacockFeatherLegs), new Object[] { "***", "* *", "* *", Character.valueOf('*'), MyPeacockFeather });
/*      */ 
/*      */     
/* 5802 */     GameRegistry.addRecipe(new ItemStack((Item)PeacockFeatherBoots), new Object[] { "   ", "* *", "* *", Character.valueOf('*'), MyPeacockFeather });
/*      */ 
/*      */ 
/*      */     
/* 5806 */     LanguageRegistry.instance().addNameForObject(TigersEyeHelmet, "en_US", "Tiger's Eye Helmet");
/* 5807 */     LanguageRegistry.instance().addNameForObject(TigersEyeBody, "en_US", "Tiger's Eye Chestplate");
/* 5808 */     LanguageRegistry.instance().addNameForObject(TigersEyeLegs, "en_US", "Tiger's Eye Leggings");
/* 5809 */     LanguageRegistry.instance().addNameForObject(TigersEyeBoots, "en_US", "Tiger's Eye Boots");
/*      */     
/* 5811 */     GameRegistry.addRecipe(new ItemStack((Item)TigersEyeHelmet), new Object[] { "   ", "***", "* *", Character.valueOf('*'), MyTigersEyeIngot });
/*      */ 
/*      */     
/* 5814 */     GameRegistry.addRecipe(new ItemStack((Item)TigersEyeHelmet), new Object[] { "***", "* *", "   ", Character.valueOf('*'), MyTigersEyeIngot });
/*      */ 
/*      */     
/* 5817 */     GameRegistry.addRecipe(new ItemStack((Item)TigersEyeBody), new Object[] { "* *", "***", "***", Character.valueOf('*'), MyTigersEyeIngot });
/*      */ 
/*      */     
/* 5820 */     GameRegistry.addRecipe(new ItemStack((Item)TigersEyeLegs), new Object[] { "***", "* *", "* *", Character.valueOf('*'), MyTigersEyeIngot });
/*      */ 
/*      */     
/* 5823 */     GameRegistry.addRecipe(new ItemStack((Item)TigersEyeBoots), new Object[] { "   ", "* *", "* *", Character.valueOf('*'), MyTigersEyeIngot });
/*      */ 
/*      */ 
/*      */     
/* 5827 */     LanguageRegistry.instance().addNameForObject(ExperienceHelmet, "en_US", "Experience Helmet");
/* 5828 */     LanguageRegistry.instance().addNameForObject(ExperienceBody, "en_US", "Experience Chestplate");
/* 5829 */     LanguageRegistry.instance().addNameForObject(ExperienceLegs, "en_US", "Experience Leggings");
/* 5830 */     LanguageRegistry.instance().addNameForObject(ExperienceBoots, "en_US", "Experience Boots");
/*      */     
/* 5832 */     GameRegistry.addRecipe(new ItemStack((Item)ExperienceHelmet), new Object[] { "EEE", "EAE", "EEE", Character.valueOf('A'), EmeraldHelmet, Character.valueOf('E'), Items.experience_bottle });
/*      */ 
/*      */ 
/*      */     
/* 5836 */     GameRegistry.addRecipe(new ItemStack((Item)ExperienceBody), new Object[] { "EEE", "EAE", "EEE", Character.valueOf('A'), EmeraldBody, Character.valueOf('E'), Items.experience_bottle });
/*      */ 
/*      */ 
/*      */     
/* 5840 */     GameRegistry.addRecipe(new ItemStack((Item)ExperienceLegs), new Object[] { "EEE", "EAE", "EEE", Character.valueOf('A'), EmeraldLegs, Character.valueOf('E'), Items.experience_bottle });
/*      */ 
/*      */ 
/*      */     
/* 5844 */     GameRegistry.addRecipe(new ItemStack((Item)ExperienceBoots), new Object[] { "EEE", "EAE", "EEE", Character.valueOf('A'), EmeraldBoots, Character.valueOf('E'), Items.experience_bottle });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5850 */     GameRegistry.addRecipe(new ItemStack(Blocks.web), new Object[] { "***", "* *", "***", Character.valueOf('*'), Items.string });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5855 */     EntityRegistry.instance(); int cageid = EntityRegistry.findGlobalUniqueEntityId();
/* 5856 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(EntityCage.class, "EntityCage", cageid);
/* 5857 */     EntityRegistry.instance(); EntityRegistry.registerModEntity(EntityCage.class, "EntityCage", cageid, this, 64, 1, true);
/*      */     
/* 5859 */     LanguageRegistry.instance().addNameForObject(CageEmpty, "en_US", "Empty Critter Cage");
/* 5860 */     LanguageRegistry.instance().addNameForObject(CagedSpider, "en_US", "Caged Spider");
/* 5861 */     LanguageRegistry.instance().addNameForObject(CagedBat, "en_US", "Caged Bat");
/* 5862 */     LanguageRegistry.instance().addNameForObject(CagedCow, "en_US", "Caged Cow");
/* 5863 */     LanguageRegistry.instance().addNameForObject(CagedPig, "en_US", "Caged Pig");
/* 5864 */     LanguageRegistry.instance().addNameForObject(CagedSquid, "en_US", "Caged Squid");
/* 5865 */     LanguageRegistry.instance().addNameForObject(CagedChicken, "en_US", "Caged Chicken");
/* 5866 */     LanguageRegistry.instance().addNameForObject(CagedCreeper, "en_US", "Caged Creeper");
/* 5867 */     LanguageRegistry.instance().addNameForObject(CagedSkeleton, "en_US", "Caged Skeleton");
/* 5868 */     LanguageRegistry.instance().addNameForObject(CagedZombie, "en_US", "Caged Zombie");
/* 5869 */     LanguageRegistry.instance().addNameForObject(CagedSlime, "en_US", "Caged Slime");
/* 5870 */     LanguageRegistry.instance().addNameForObject(CagedGhast, "en_US", "Caged Ghast");
/* 5871 */     LanguageRegistry.instance().addNameForObject(CagedZombiePigman, "en_US", "Caged ZombiePigman");
/* 5872 */     LanguageRegistry.instance().addNameForObject(CagedEnderman, "en_US", "Caged Enderman");
/* 5873 */     LanguageRegistry.instance().addNameForObject(CagedCaveSpider, "en_US", "Caged Cave Spider");
/* 5874 */     LanguageRegistry.instance().addNameForObject(CagedSilverfish, "en_US", "Caged Silverfish");
/* 5875 */     LanguageRegistry.instance().addNameForObject(CagedMagmaCube, "en_US", "Caged Magma Cube");
/* 5876 */     LanguageRegistry.instance().addNameForObject(CagedWitch, "en_US", "Caged Witch");
/* 5877 */     LanguageRegistry.instance().addNameForObject(CagedSheep, "en_US", "Caged Sheep");
/* 5878 */     LanguageRegistry.instance().addNameForObject(CagedWolf, "en_US", "Caged Wolf");
/* 5879 */     LanguageRegistry.instance().addNameForObject(CagedMooshroom, "en_US", "Caged Mooshroom");
/* 5880 */     LanguageRegistry.instance().addNameForObject(CagedOcelot, "en_US", "Caged Ocelot");
/* 5881 */     LanguageRegistry.instance().addNameForObject(CagedBlaze, "en_US", "Caged Blaze");
/* 5882 */     LanguageRegistry.instance().addNameForObject(CagedGirlfriend, "en_US", "Caged Girlfriend");
/* 5883 */     LanguageRegistry.instance().addNameForObject(CagedBoyfriend, "en_US", "Caged Boyfriend");
/* 5884 */     LanguageRegistry.instance().addNameForObject(CagedWitherSkeleton, "en_US", "Caged Wither Skeleton");
/* 5885 */     LanguageRegistry.instance().addNameForObject(CagedEnderDragon, "en_US", "Caged Ender Dragon");
/* 5886 */     LanguageRegistry.instance().addNameForObject(CagedSnowGolem, "en_US", "Caged Snow Golem");
/* 5887 */     LanguageRegistry.instance().addNameForObject(CagedIronGolem, "en_US", "Caged Iron Golem");
/* 5888 */     LanguageRegistry.instance().addNameForObject(CagedWitherBoss, "en_US", "Caged Wither Boss");
/* 5889 */     LanguageRegistry.instance().addNameForObject(CagedRedCow, "en_US", "Caged Apple Cow");
/* 5890 */     LanguageRegistry.instance().addNameForObject(CagedCrystalCow, "en_US", "Caged Crystal Cow");
/* 5891 */     LanguageRegistry.instance().addNameForObject(CagedVillager, "en_US", "Caged Villager");
/* 5892 */     LanguageRegistry.instance().addNameForObject(CagedGoldCow, "en_US", "Caged Golden Apple Cow");
/* 5893 */     LanguageRegistry.instance().addNameForObject(CagedEnchantedCow, "en_US", "Caged Enchanted Golden Apple Cow");
/* 5894 */     LanguageRegistry.instance().addNameForObject(CagedMOTHRA, "en_US", "Caged MOTHRA");
/* 5895 */     LanguageRegistry.instance().addNameForObject(CagedAlo, "en_US", "Caged Alosaurus");
/* 5896 */     LanguageRegistry.instance().addNameForObject(CagedCryo, "en_US", "Caged Cryosaurus");
/* 5897 */     LanguageRegistry.instance().addNameForObject(CagedCama, "en_US", "Caged Camarasaurus");
/* 5898 */     LanguageRegistry.instance().addNameForObject(CagedVelo, "en_US", "Caged Velocity Raptor");
/* 5899 */     LanguageRegistry.instance().addNameForObject(CagedHydro, "en_US", "Caged Hydrolisc");
/* 5900 */     LanguageRegistry.instance().addNameForObject(CagedBasil, "en_US", "Caged Basilisk");
/* 5901 */     LanguageRegistry.instance().addNameForObject(CagedDragonfly, "en_US", "Caged Dragonfly");
/* 5902 */     LanguageRegistry.instance().addNameForObject(CagedEmperorScorpion, "en_US", "Caged Emperor Scorpion");
/* 5903 */     LanguageRegistry.instance().addNameForObject(CagedScorpion, "en_US", "Caged Scorpion");
/* 5904 */     LanguageRegistry.instance().addNameForObject(CagedCaveFisher, "en_US", "Caged Cave Fisher");
/* 5905 */     LanguageRegistry.instance().addNameForObject(CagedSpyro, "en_US", "Caged Baby Dragon");
/* 5906 */     LanguageRegistry.instance().addNameForObject(CagedBaryonyx, "en_US", "Caged Baryonyx");
/* 5907 */     LanguageRegistry.instance().addNameForObject(CagedGammaMetroid, "en_US", "Caged WTF?");
/* 5908 */     LanguageRegistry.instance().addNameForObject(CagedCockateil, "en_US", "Caged Bird");
/* 5909 */     LanguageRegistry.instance().addNameForObject(CagedKyuubi, "en_US", "Caged Kyuubi");
/* 5910 */     LanguageRegistry.instance().addNameForObject(CagedAlien, "en_US", "Caged Alien");
/* 5911 */     LanguageRegistry.instance().addNameForObject(MyElevator, "en_US", "Hoverboard");
/* 5912 */     LanguageRegistry.instance().addNameForObject(CagedAttackSquid, "en_US", "Caged Attack Squid");
/* 5913 */     LanguageRegistry.instance().addNameForObject(CagedWaterDragon, "en_US", "Caged Water Dragon");
/* 5914 */     LanguageRegistry.instance().addNameForObject(CagedCephadrome, "en_US", "Caged Cephadrome");
/* 5915 */     LanguageRegistry.instance().addNameForObject(CagedKraken, "en_US", "Caged Kraken");
/* 5916 */     LanguageRegistry.instance().addNameForObject(CagedLizard, "en_US", "Caged Lizard");
/* 5917 */     LanguageRegistry.instance().addNameForObject(CagedDragon, "en_US", "Caged Dragon");
/* 5918 */     LanguageRegistry.instance().addNameForObject(CagedBee, "en_US", "Caged Bee");
/* 5919 */     LanguageRegistry.instance().addNameForObject(CagedHorse, "en_US", "Caged Horse");
/* 5920 */     LanguageRegistry.instance().addNameForObject(CagedFirefly, "en_US", "Caged Firefly");
/* 5921 */     LanguageRegistry.instance().addNameForObject(CagedChipmunk, "en_US", "Caged Chipmunk");
/* 5922 */     LanguageRegistry.instance().addNameForObject(CagedGazelle, "en_US", "Caged Gazelle");
/* 5923 */     LanguageRegistry.instance().addNameForObject(CagedOstrich, "en_US", "Caged Ostrich");
/* 5924 */     LanguageRegistry.instance().addNameForObject(CagedTrooper, "en_US", "Caged Jumpy Bug");
/* 5925 */     LanguageRegistry.instance().addNameForObject(CagedSpit, "en_US", "Caged Spit Bug");
/* 5926 */     LanguageRegistry.instance().addNameForObject(CagedStink, "en_US", "Caged Stink Bug");
/* 5927 */     LanguageRegistry.instance().addNameForObject(CagedCreepingHorror, "en_US", "Caged Creeping Horror");
/* 5928 */     LanguageRegistry.instance().addNameForObject(CagedTerribleTerror, "en_US", "Caged Terrible Terror");
/* 5929 */     LanguageRegistry.instance().addNameForObject(CagedCliffRacer, "en_US", "Caged Cliff Racer");
/* 5930 */     LanguageRegistry.instance().addNameForObject(CagedTriffid, "en_US", "Caged Triffid");
/* 5931 */     LanguageRegistry.instance().addNameForObject(CagedPitchBlack, "en_US", "Caged Nightmare");
/* 5932 */     LanguageRegistry.instance().addNameForObject(CagedLurkingTerror, "en_US", "Caged Lurking Terror");
/* 5933 */     LanguageRegistry.instance().addNameForObject(CagedSmallWorm, "en_US", "Caged Small Worm");
/* 5934 */     LanguageRegistry.instance().addNameForObject(CagedMediumWorm, "en_US", "Caged Medium Worm");
/* 5935 */     LanguageRegistry.instance().addNameForObject(CagedLargeWorm, "en_US", "Caged Large Worm");
/* 5936 */     LanguageRegistry.instance().addNameForObject(CagedCassowary, "en_US", "Caged Cassowary");
/* 5937 */     LanguageRegistry.instance().addNameForObject(CagedCloudShark, "en_US", "Caged Cloud Shark");
/* 5938 */     LanguageRegistry.instance().addNameForObject(CagedGoldFish, "en_US", "Caged Gold Fish");
/* 5939 */     LanguageRegistry.instance().addNameForObject(CagedLeafMonster, "en_US", "Caged Leaf Monster");
/* 5940 */     LanguageRegistry.instance().addNameForObject(CagedEnderKnight, "en_US", "Caged Ender Knight");
/* 5941 */     LanguageRegistry.instance().addNameForObject(CagedEnderReaper, "en_US", "Caged Ender Reaper");
/* 5942 */     LanguageRegistry.instance().addNameForObject(CagedBeaver, "en_US", "Caged Beaver");
/* 5943 */     LanguageRegistry.instance().addNameForObject(CagedUrchin, "en_US", "Caged Crystal Urchin");
/* 5944 */     LanguageRegistry.instance().addNameForObject(CagedFlounder, "en_US", "Caged Flounder");
/* 5945 */     LanguageRegistry.instance().addNameForObject(CagedSkate, "en_US", "Caged Skate");
/* 5946 */     LanguageRegistry.instance().addNameForObject(CagedRotator, "en_US", "Caged Rotator");
/* 5947 */     LanguageRegistry.instance().addNameForObject(CagedPeacock, "en_US", "Caged Peacock");
/* 5948 */     LanguageRegistry.instance().addNameForObject(CagedFairy, "en_US", "Caged Fairy");
/* 5949 */     LanguageRegistry.instance().addNameForObject(CagedDungeonBeast, "en_US", "Caged Dungeon Beast");
/* 5950 */     LanguageRegistry.instance().addNameForObject(CagedVortex, "en_US", "Caged Vortex");
/* 5951 */     LanguageRegistry.instance().addNameForObject(CagedRat, "en_US", "Caged Rat");
/* 5952 */     LanguageRegistry.instance().addNameForObject(CagedWhale, "en_US", "Caged Whale");
/* 5953 */     LanguageRegistry.instance().addNameForObject(CagedIrukandji, "en_US", "Caged Irukandji");
/* 5954 */     LanguageRegistry.instance().addNameForObject(CagedTRex, "en_US", "Caged T. Rex");
/* 5955 */     LanguageRegistry.instance().addNameForObject(CagedHercules, "en_US", "Caged Hercules Beetle");
/* 5956 */     LanguageRegistry.instance().addNameForObject(CagedMantis, "en_US", "Caged Mantis");
/* 5957 */     LanguageRegistry.instance().addNameForObject(CagedStinky, "en_US", "Caged Stinky");
/* 5958 */     LanguageRegistry.instance().addNameForObject(CagedEasterBunny, "en_US", "Caged Easter Bunny");
/* 5959 */     LanguageRegistry.instance().addNameForObject(CagedCaterKiller, "en_US", "Caged CaterKiller");
/* 5960 */     LanguageRegistry.instance().addNameForObject(CagedMolenoid, "en_US", "Caged Molenoid");
/* 5961 */     LanguageRegistry.instance().addNameForObject(CagedSeaMonster, "en_US", "Caged Sea Monster");
/* 5962 */     LanguageRegistry.instance().addNameForObject(CagedSeaViper, "en_US", "Caged Sea Viper");
/* 5963 */     LanguageRegistry.instance().addNameForObject(CagedLeon, "en_US", "Caged Leonopteryx");
/* 5964 */     LanguageRegistry.instance().addNameForObject(CagedHammerhead, "en_US", "Caged Hammerhead");
/* 5965 */     LanguageRegistry.instance().addNameForObject(CagedRubberDucky, "en_US", "Caged Rubber Ducky");
/* 5966 */     LanguageRegistry.instance().addNameForObject(CagedCriminal, "en_US", "Caged Criminal");
/* 5967 */     LanguageRegistry.instance().addNameForObject(CagedNastysaurus, "en_US", "Caged Nastysaurus");
/* 5968 */     LanguageRegistry.instance().addNameForObject(CagedPointysaurus, "en_US", "Caged Pointysaurus");
/* 5969 */     LanguageRegistry.instance().addNameForObject(CagedCricket, "en_US", "Caged Cricket");
/* 5970 */     LanguageRegistry.instance().addNameForObject(CagedBrutalfly, "en_US", "Caged Brutalfly");
/* 5971 */     LanguageRegistry.instance().addNameForObject(CagedFrog, "en_US", "Caged Frog");
/* 5972 */     LanguageRegistry.instance().addNameForObject(CagedSpiderDriver, "en_US", "Caged Spider Driver");
/* 5973 */     LanguageRegistry.instance().addNameForObject(CagedCrab, "en_US", "Caged Crab");
/*      */ 
/*      */     
/* 5976 */     LanguageRegistry.instance().addNameForObject(WitherSkeletonEgg, "en_US", "Spawn Wither Skeleton");
/* 5977 */     LanguageRegistry.instance().addNameForObject(EnderDragonEgg, "en_US", "Spawn Ender Dragon");
/* 5978 */     LanguageRegistry.instance().addNameForObject(SnowGolemEgg, "en_US", "Spawn Snow Golem");
/* 5979 */     LanguageRegistry.instance().addNameForObject(IronGolemEgg, "en_US", "Spawn Iron Golem");
/* 5980 */     LanguageRegistry.instance().addNameForObject(WitherBossEgg, "en_US", "Spawn Wither Boss");
/* 5981 */     LanguageRegistry.instance().addNameForObject(GirlfriendEgg, "en_US", "Spawn Girlfriend");
/* 5982 */     LanguageRegistry.instance().addNameForObject(BoyfriendEgg, "en_US", "Spawn Boyfriend");
/* 5983 */     LanguageRegistry.instance().addNameForObject(TheKingEgg, "en_US", "Spawn The King");
/* 5984 */     LanguageRegistry.instance().addNameForObject(TheQueenEgg, "en_US", "Spawn The Queen");
/* 5985 */     LanguageRegistry.instance().addNameForObject(ThePrinceEgg, "en_US", "Spawn The Prince");
/* 5986 */     LanguageRegistry.instance().addNameForObject(RedCowEgg, "en_US", "Spawn Apple Cow");
/* 5987 */     LanguageRegistry.instance().addNameForObject(CrystalCowEgg, "en_US", "Spawn Crystal Cow");
/* 5988 */     LanguageRegistry.instance().addNameForObject(GoldCowEgg, "en_US", "Spawn Golden Apple Cow");
/* 5989 */     LanguageRegistry.instance().addNameForObject(EnchantedCowEgg, "en_US", "Spawn Enchanted Golden Apple Cow");
/* 5990 */     LanguageRegistry.instance().addNameForObject(MOTHRAEgg, "en_US", "Spawn MOTHRA!");
/* 5991 */     LanguageRegistry.instance().addNameForObject(AloEgg, "en_US", "Spawn Alosaurus");
/* 5992 */     LanguageRegistry.instance().addNameForObject(CryoEgg, "en_US", "Spawn Cryolophosaurus");
/* 5993 */     LanguageRegistry.instance().addNameForObject(CamaEgg, "en_US", "Spawn Camarasaurus");
/* 5994 */     LanguageRegistry.instance().addNameForObject(VeloEgg, "en_US", "Spawn Velocity Raptor");
/* 5995 */     LanguageRegistry.instance().addNameForObject(HydroEgg, "en_US", "Spawn Hydrolisc");
/* 5996 */     LanguageRegistry.instance().addNameForObject(BasilEgg, "en_US", "Spawn Basilisk");
/* 5997 */     LanguageRegistry.instance().addNameForObject(DragonflyEgg, "en_US", "Spawn Dragonfly");
/* 5998 */     LanguageRegistry.instance().addNameForObject(EmperorScorpionEgg, "en_US", "Spawn Emperor Scorpion!");
/* 5999 */     LanguageRegistry.instance().addNameForObject(ScorpionEgg, "en_US", "Spawn Scorpion");
/* 6000 */     LanguageRegistry.instance().addNameForObject(CaveFisherEgg, "en_US", "Spawn Cave Fisher");
/* 6001 */     LanguageRegistry.instance().addNameForObject(SpyroEgg, "en_US", "Spawn Baby Dragon");
/* 6002 */     LanguageRegistry.instance().addNameForObject(BaryonyxEgg, "en_US", "Spawn Baryonyx");
/* 6003 */     LanguageRegistry.instance().addNameForObject(GammaMetroidEgg, "en_US", "Spawn WTF?");
/* 6004 */     LanguageRegistry.instance().addNameForObject(CockateilEgg, "en_US", "Spawn Bird");
/* 6005 */     LanguageRegistry.instance().addNameForObject(KyuubiEgg, "en_US", "Spawn Kyuubi");
/* 6006 */     LanguageRegistry.instance().addNameForObject(AlienEgg, "en_US", "Spawn Alien");
/* 6007 */     LanguageRegistry.instance().addNameForObject(AttackSquidEgg, "en_US", "Spawn Attack Squid");
/* 6008 */     LanguageRegistry.instance().addNameForObject(WaterDragonEgg, "en_US", "Spawn Water Dragon");
/* 6009 */     LanguageRegistry.instance().addNameForObject(CephadromeEgg, "en_US", "Spawn Cephadrome");
/* 6010 */     LanguageRegistry.instance().addNameForObject(KrakenEgg, "en_US", "Uh, no. Don't.");
/* 6011 */     LanguageRegistry.instance().addNameForObject(LizardEgg, "en_US", "Spawn Lizard");
/* 6012 */     LanguageRegistry.instance().addNameForObject(DragonEgg, "en_US", "Spawn Dragon");
/* 6013 */     LanguageRegistry.instance().addNameForObject(BeeEgg, "en_US", "Spawn Bee");
/* 6014 */     LanguageRegistry.instance().addNameForObject(TrooperBugEgg, "en_US", "Spawn Jumpy Bug");
/* 6015 */     LanguageRegistry.instance().addNameForObject(SpitBugEgg, "en_US", "Spawn Spit Bug");
/* 6016 */     LanguageRegistry.instance().addNameForObject(StinkBugEgg, "en_US", "Spawn Stink Bug");
/* 6017 */     LanguageRegistry.instance().addNameForObject(OstrichEgg, "en_US", "Spawn Ostrich");
/* 6018 */     LanguageRegistry.instance().addNameForObject(GazelleEgg, "en_US", "Spawn Gazelle");
/* 6019 */     LanguageRegistry.instance().addNameForObject(ChipmunkEgg, "en_US", "Spawn Chipmunk");
/* 6020 */     LanguageRegistry.instance().addNameForObject(CreepingHorrorEgg, "en_US", "Spawn Creeping Horror");
/* 6021 */     LanguageRegistry.instance().addNameForObject(TerribleTerrorEgg, "en_US", "Spawn Terrible Terror");
/* 6022 */     LanguageRegistry.instance().addNameForObject(CliffRacerEgg, "en_US", "Spawn Cliff Racer");
/* 6023 */     LanguageRegistry.instance().addNameForObject(TriffidEgg, "en_US", "Spawn Triffid");
/* 6024 */     LanguageRegistry.instance().addNameForObject(PitchBlackEgg, "en_US", "Spawn Nightmare!!!");
/* 6025 */     LanguageRegistry.instance().addNameForObject(LurkingTerrorEgg, "en_US", "Spawn Lurking Terror");
/* 6026 */     LanguageRegistry.instance().addNameForObject(GodzillaEgg, "en_US", "Spawn Mobzilla");
/* 6027 */     LanguageRegistry.instance().addNameForObject(SmallWormEgg, "en_US", "Spawn Small Worm");
/* 6028 */     LanguageRegistry.instance().addNameForObject(MediumWormEgg, "en_US", "Spawn Medium Worm");
/* 6029 */     LanguageRegistry.instance().addNameForObject(LargeWormEgg, "en_US", "Spawn Large Worm");
/* 6030 */     LanguageRegistry.instance().addNameForObject(CassowaryEgg, "en_US", "Spawn Cassowary");
/* 6031 */     LanguageRegistry.instance().addNameForObject(CloudSharkEgg, "en_US", "Spawn Cloud Shark");
/* 6032 */     LanguageRegistry.instance().addNameForObject(GoldFishEgg, "en_US", "Spawn Gold Fish");
/* 6033 */     LanguageRegistry.instance().addNameForObject(LeafMonsterEgg, "en_US", "Spawn Leaf Monster");
/* 6034 */     LanguageRegistry.instance().addNameForObject(TshirtEgg, "en_US", "Spawn T-Shirt!");
/* 6035 */     LanguageRegistry.instance().addNameForObject(EnderKnightEgg, "en_US", "Spawn Ender Knight");
/* 6036 */     LanguageRegistry.instance().addNameForObject(EnderReaperEgg, "en_US", "Spawn Ender Reaper");
/* 6037 */     LanguageRegistry.instance().addNameForObject(BeaverEgg, "en_US", "Spawn Beaver");
/* 6038 */     LanguageRegistry.instance().addNameForObject(FairyEgg, "en_US", "Spawn Fairy");
/* 6039 */     LanguageRegistry.instance().addNameForObject(VortexEgg, "en_US", "Spawn Vortex");
/* 6040 */     LanguageRegistry.instance().addNameForObject(RotatorEgg, "en_US", "Spawn Rotator");
/* 6041 */     LanguageRegistry.instance().addNameForObject(PeacockEgg, "en_US", "Spawn Peacock");
/* 6042 */     LanguageRegistry.instance().addNameForObject(DungeonBeastEgg, "en_US", "Spawn Dungeon Beast");
/* 6043 */     LanguageRegistry.instance().addNameForObject(RatEgg, "en_US", "Spawn Rat");
/* 6044 */     LanguageRegistry.instance().addNameForObject(FlounderEgg, "en_US", "Spawn Flounder");
/* 6045 */     LanguageRegistry.instance().addNameForObject(WhaleEgg, "en_US", "Spawn Whale");
/* 6046 */     LanguageRegistry.instance().addNameForObject(IrukandjiEgg, "en_US", "Spawn Irukandji");
/* 6047 */     LanguageRegistry.instance().addNameForObject(SkateEgg, "en_US", "Spawn Skate");
/* 6048 */     LanguageRegistry.instance().addNameForObject(UrchinEgg, "en_US", "Spawn Crystal Urchin");
/* 6049 */     LanguageRegistry.instance().addNameForObject(Robot1Egg, "en_US", "Spawn Bomb-Omb");
/* 6050 */     LanguageRegistry.instance().addNameForObject(Robot2Egg, "en_US", "Spawn Robo-Pounder");
/* 6051 */     LanguageRegistry.instance().addNameForObject(Robot3Egg, "en_US", "Spawn Robo-Gunner");
/* 6052 */     LanguageRegistry.instance().addNameForObject(Robot4Egg, "en_US", "Spawn Robo-Warrior");
/* 6053 */     LanguageRegistry.instance().addNameForObject(GhostEgg, "en_US", "Spawn Ghost");
/* 6054 */     LanguageRegistry.instance().addNameForObject(GhostSkellyEgg, "en_US", "Spawn Ghost Pumpkin Skelly");
/* 6055 */     LanguageRegistry.instance().addNameForObject(BrownAntEgg, "en_US", "Spawn Brown Ant");
/* 6056 */     LanguageRegistry.instance().addNameForObject(RedAntEgg, "en_US", "Spawn Red Ant");
/* 6057 */     LanguageRegistry.instance().addNameForObject(RainbowAntEgg, "en_US", "Spawn Rainbow Ant");
/* 6058 */     LanguageRegistry.instance().addNameForObject(UnstableAntEgg, "en_US", "Spawn Unstable Ant");
/* 6059 */     LanguageRegistry.instance().addNameForObject(TermiteEgg, "en_US", "Spawn Termite");
/* 6060 */     LanguageRegistry.instance().addNameForObject(ButterflyEgg, "en_US", "Spawn Butterfly");
/* 6061 */     LanguageRegistry.instance().addNameForObject(MothEgg, "en_US", "Spawn Moth");
/* 6062 */     LanguageRegistry.instance().addNameForObject(MosquitoEgg, "en_US", "Spawn Mosquito");
/* 6063 */     LanguageRegistry.instance().addNameForObject(FireflyEgg, "en_US", "Spawn Firefly");
/* 6064 */     LanguageRegistry.instance().addNameForObject(TRexEgg, "en_US", "Spawn T. Rex");
/* 6065 */     LanguageRegistry.instance().addNameForObject(HerculesEgg, "en_US", "Spawn Hercules Beetle");
/* 6066 */     LanguageRegistry.instance().addNameForObject(MantisEgg, "en_US", "Spawn Mantis");
/* 6067 */     LanguageRegistry.instance().addNameForObject(StinkyEgg, "en_US", "Spawn Stinky");
/* 6068 */     LanguageRegistry.instance().addNameForObject(Robot5Egg, "en_US", "Spawn Robo-Sniper");
/* 6069 */     LanguageRegistry.instance().addNameForObject(CoinEgg, "en_US", "Spawn Coin");
/* 6070 */     LanguageRegistry.instance().addNameForObject(EasterBunnyEgg, "en_US", "Spawn Easter Bunny");
/* 6071 */     LanguageRegistry.instance().addNameForObject(MolenoidEgg, "en_US", "Spawn Molenoid");
/* 6072 */     LanguageRegistry.instance().addNameForObject(SeaMonsterEgg, "en_US", "Spawn Sea Monster");
/* 6073 */     LanguageRegistry.instance().addNameForObject(SeaViperEgg, "en_US", "Spawn Sea Viper");
/* 6074 */     LanguageRegistry.instance().addNameForObject(CaterKillerEgg, "en_US", "Spawn CaterKiller");
/* 6075 */     LanguageRegistry.instance().addNameForObject(LeonEgg, "en_US", "Spawn Leonopteryx");
/* 6076 */     LanguageRegistry.instance().addNameForObject(HammerheadEgg, "en_US", "Spawn Hammerhead");
/* 6077 */     LanguageRegistry.instance().addNameForObject(RubberDuckyEgg, "en_US", "Spawn Rubber Ducky");
/* 6078 */     LanguageRegistry.instance().addNameForObject(CriminalEgg, "en_US", "Spawn Criminal");
/* 6079 */     LanguageRegistry.instance().addNameForObject(BrutalflyEgg, "en_US", "Spawn Brutalfly");
/* 6080 */     LanguageRegistry.instance().addNameForObject(NastysaurusEgg, "en_US", "Spawn Nastysaurus");
/* 6081 */     LanguageRegistry.instance().addNameForObject(PointysaurusEgg, "en_US", "Spawn Pointysaurus");
/* 6082 */     LanguageRegistry.instance().addNameForObject(CricketEgg, "en_US", "Spawn Cricket");
/* 6083 */     LanguageRegistry.instance().addNameForObject(ThePrincessEgg, "en_US", "Spawn The Princess");
/* 6084 */     LanguageRegistry.instance().addNameForObject(FrogEgg, "en_US", "Spawn Frog");
/* 6085 */     LanguageRegistry.instance().addNameForObject(JefferyEgg, "en_US", "Spawn Jeffery");
/* 6086 */     LanguageRegistry.instance().addNameForObject(AntRobotEgg, "en_US", "Spawn Red Ant Robot");
/* 6087 */     LanguageRegistry.instance().addNameForObject(SpiderRobotEgg, "en_US", "Spawn Giant Spider Robot");
/* 6088 */     LanguageRegistry.instance().addNameForObject(SpiderDriverEgg, "en_US", "Spawn Spider Robot Driver");
/* 6089 */     LanguageRegistry.instance().addNameForObject(CrabEgg, "en_US", "Spawn Crab");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6094 */     GameRegistry.addRecipe(new ItemStack(CageEmpty, 2), new Object[] { "IWI", "W W", "IWI", Character.valueOf('W'), Items.stick, Character.valueOf('I'), Items.iron_ingot });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6099 */     GameRegistry.addRecipe(new ItemStack(CageEmpty, 2), new Object[] { "IWI", "W W", "IWI", Character.valueOf('W'), CrystalSticks, Character.valueOf('I'), MyCrystalPinkIngot });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6106 */     EntityRegistry.instance(); int arrowid = EntityRegistry.findGlobalUniqueEntityId();
/* 6107 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(UltimateArrow.class, "UltimateArrow", arrowid);
/*      */     
/* 6109 */     EntityRegistry.instance(); int irukandiarrowid = EntityRegistry.findGlobalUniqueEntityId();
/* 6110 */     EntityRegistry.instance(); EntityRegistry.registerGlobalEntityID(IrukandjiArrow.class, "IrukandjiArrow", irukandiarrowid);
/*      */     
/* 6112 */     LanguageRegistry.instance().addNameForObject(MyAppleLeaves, "en_US", "Apple Tree Leaves");
/* 6113 */     LanguageRegistry.instance().addNameForObject(MySkyTreeLog, "en_US", "Sky Tree Wood");
/* 6114 */     GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 4), new Object[] { new ItemStack(MySkyTreeLog) });
/* 6115 */     LanguageRegistry.instance().addNameForObject(MyDT, "en_US", "Duplicator Tree Wood");
/* 6116 */     GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 4), new Object[] { new ItemStack(MyDT) });
/* 6117 */     LanguageRegistry.instance().addNameForObject(MyScaryLeaves, "en_US", "Scary Tree Leaves");
/* 6118 */     LanguageRegistry.instance().addNameForObject(MyCherryLeaves, "en_US", "Cherry Tree Leaves");
/* 6119 */     LanguageRegistry.instance().addNameForObject(MyPeachLeaves, "en_US", "Peach Tree Leaves");
/* 6120 */     LanguageRegistry.instance().addNameForObject(MyExperienceLeaves, "en_US", "Experience Tree Leaves");
/* 6121 */     LanguageRegistry.instance().addNameForObject(MyCrystalLeaves, "en_US", "Crystal Tree Leaves");
/* 6122 */     LanguageRegistry.instance().addNameForObject(MyCrystalLeaves2, "en_US", "Crystal Tree Leaves");
/* 6123 */     LanguageRegistry.instance().addNameForObject(MyCrystalLeaves3, "en_US", "Crystal Tree Leaves");
/* 6124 */     LanguageRegistry.instance().addNameForObject(MyCrystalTreeLog, "en_US", "Crystal Tree Wood");
/*      */ 
/*      */     
/* 6127 */     GameRegistry.addRecipe(new ItemStack(MyElevator), new Object[] { "   ", "WWW", "DRD", Character.valueOf('W'), Blocks.planks, Character.valueOf('R'), Items.redstone, Character.valueOf('D'), Items.diamond });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6136 */     GameRegistry.registerWorldGenerator(this.OreSpawnGen, 10);
/*      */ 
/*      */ 
/*      */     
/* 6140 */     proxy.registerRenderThings();
/*      */     
/* 6142 */     proxy.registerKeyboardInput();
/*      */     
/* 6144 */     proxy.registerNetworkStuff();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6149 */     DimensionManager.registerProviderType(DimensionID, WorldProviderOreSpawn.class, true);
/* 6150 */     DimensionManager.registerDimension(DimensionID, DimensionID);
/*      */     
/* 6152 */     DimensionManager.registerProviderType(DimensionID2, WorldProviderOreSpawn2.class, true);
/* 6153 */     DimensionManager.registerDimension(DimensionID2, DimensionID2);
/*      */     
/* 6155 */     DimensionManager.registerProviderType(DimensionID3, WorldProviderOreSpawn3.class, true);
/* 6156 */     DimensionManager.registerDimension(DimensionID3, DimensionID3);
/*      */     
/* 6158 */     DimensionManager.registerProviderType(DimensionID4, WorldProviderOreSpawn4.class, true);
/* 6159 */     DimensionManager.registerDimension(DimensionID4, DimensionID4);
/*      */     
/* 6161 */     DimensionManager.registerProviderType(DimensionID5, WorldProviderOreSpawn5.class, true);
/* 6162 */     DimensionManager.registerDimension(DimensionID5, DimensionID5);
/*      */     
/* 6164 */     DimensionManager.registerProviderType(DimensionID6, WorldProviderOreSpawn6.class, true);
/* 6165 */     DimensionManager.registerDimension(DimensionID6, DimensionID6);
/*      */ 
/*      */     
/* 6168 */     ChestGenHooks chestGenHooksDungeon = ChestGenHooks.getInfo("dungeonChest");
/* 6169 */     chestGenHooksDungeon.addItem(new WeightedRandomChestContent(new ItemStack(MyRuby), 1, 1, 3));
/* 6170 */     chestGenHooksDungeon.addItem(new WeightedRandomChestContent(new ItemStack(MyAmethyst), 1, 1, 3));
/* 6171 */     chestGenHooksDungeon.addItem(new WeightedRandomChestContent(new ItemStack(MyThunderStaff), 1, 1, 2));
/*      */     
/* 6173 */     ChestGenHooks chestGenHooksJungleChest = ChestGenHooks.getInfo("pyramidJungleChest");
/* 6174 */     chestGenHooksJungleChest.addItem(new WeightedRandomChestContent(new ItemStack(MyRuby), 1, 1, 3));
/* 6175 */     chestGenHooksJungleChest.addItem(new WeightedRandomChestContent(new ItemStack(MyAmethyst), 1, 1, 3));
/* 6176 */     chestGenHooksJungleChest.addItem(new WeightedRandomChestContent(new ItemStack(AntRobotKit), 1, 1, 3));
/*      */     
/* 6178 */     ChestGenHooks chestGenHooksDesertChest = ChestGenHooks.getInfo("pyramidDesertyChest");
/* 6179 */     chestGenHooksDesertChest.addItem(new WeightedRandomChestContent(new ItemStack(MyRuby), 1, 1, 2));
/* 6180 */     chestGenHooksDesertChest.addItem(new WeightedRandomChestContent(new ItemStack(MyAmethyst), 1, 1, 2));
/* 6181 */     chestGenHooksDesertChest.addItem(new WeightedRandomChestContent(new ItemStack(SpiderRobotKit), 1, 1, 2));
/*      */ 
/*      */     
/* 6184 */     GameRegistry.registerTileEntity(TileEntityCrystalFurnace.class, "TileEntityCrystalFurnace");
/* 6185 */     NetworkRegistry.INSTANCE.registerGuiHandler(this, new OreSpawnGUIHandler());
/*      */     
/* 6187 */     DoDispenserRegistrations();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void initializeCagesAndEggs() {
/* 6193 */     CageEmpty = (new CritterCage(BaseItemID + 0, 160)).setUnlocalizedName("cageempty");
/* 6194 */     CagedSpider = (new CritterCage(BaseItemID + 1, 161)).setUnlocalizedName("cagespider");
/* 6195 */     CagedBat = (new CritterCage(BaseItemID + 2, 162)).setUnlocalizedName("cagebat");
/* 6196 */     CagedCow = (new CritterCage(BaseItemID + 3, 163)).setUnlocalizedName("cagecow");
/* 6197 */     CagedPig = (new CritterCage(BaseItemID + 4, 164)).setUnlocalizedName("cagepig");
/* 6198 */     CagedSquid = (new CritterCage(BaseItemID + 5, 165)).setUnlocalizedName("cagesquid");
/* 6199 */     CagedChicken = (new CritterCage(BaseItemID + 6, 166)).setUnlocalizedName("cagechicken");
/* 6200 */     CagedCreeper = (new CritterCage(BaseItemID + 7, 167)).setUnlocalizedName("cagecreeper");
/* 6201 */     CagedSkeleton = (new CritterCage(BaseItemID + 8, 168)).setUnlocalizedName("cageskeleton");
/* 6202 */     CagedZombie = (new CritterCage(BaseItemID + 9, 169)).setUnlocalizedName("cagezombie");
/* 6203 */     CagedSlime = (new CritterCage(BaseItemID + 10, 170)).setUnlocalizedName("cageslime");
/* 6204 */     CagedGhast = (new CritterCage(BaseItemID + 11, 171)).setUnlocalizedName("cageghast");
/* 6205 */     CagedZombiePigman = (new CritterCage(BaseItemID + 12, 172)).setUnlocalizedName("cagezombiepigman");
/* 6206 */     CagedEnderman = (new CritterCage(BaseItemID + 13, 173)).setUnlocalizedName("cageenderman");
/* 6207 */     CagedCaveSpider = (new CritterCage(BaseItemID + 14, 174)).setUnlocalizedName("cagecavespider");
/* 6208 */     CagedSilverfish = (new CritterCage(BaseItemID + 15, 175)).setUnlocalizedName("cagesilverfish");
/* 6209 */     CagedMagmaCube = (new CritterCage(BaseItemID + 16, 176)).setUnlocalizedName("cagemagmacube");
/* 6210 */     CagedWitch = (new CritterCage(BaseItemID + 17, 177)).setUnlocalizedName("cagewitch");
/* 6211 */     CagedSheep = (new CritterCage(BaseItemID + 18, 178)).setUnlocalizedName("cagesheep");
/* 6212 */     CagedWolf = (new CritterCage(BaseItemID + 19, 179)).setUnlocalizedName("cagewolf");
/* 6213 */     CagedMooshroom = (new CritterCage(BaseItemID + 20, 180)).setUnlocalizedName("cagemooshroom");
/* 6214 */     CagedOcelot = (new CritterCage(BaseItemID + 21, 181)).setUnlocalizedName("cageocelot");
/* 6215 */     CagedBlaze = (new CritterCage(BaseItemID + 22, 182)).setUnlocalizedName("cageblaze");
/* 6216 */     CagedGirlfriend = (new CritterCage(BaseItemID + 23, 183)).setUnlocalizedName("cagegirlfriend");
/* 6217 */     CagedBoyfriend = (new CritterCage(BaseItemID + 95, 215)).setUnlocalizedName("cageboyfriend");
/* 6218 */     CagedWitherSkeleton = (new CritterCage(BaseItemID + 24, 188)).setUnlocalizedName("cagewitherskeleton");
/* 6219 */     CagedEnderDragon = (new CritterCage(BaseItemID + 25, 184)).setUnlocalizedName("cageenderdragon");
/* 6220 */     CagedSnowGolem = (new CritterCage(BaseItemID + 26, 185)).setUnlocalizedName("cagesnowgolem");
/* 6221 */     CagedIronGolem = (new CritterCage(BaseItemID + 27, 186)).setUnlocalizedName("cageirongolem");
/* 6222 */     CagedWitherBoss = (new CritterCage(BaseItemID + 28, 187)).setUnlocalizedName("cagewitherboss");
/* 6223 */     CagedRedCow = (new CritterCage(BaseItemID + 29, 189)).setUnlocalizedName("cageredcow");
/* 6224 */     CagedGoldCow = (new CritterCage(BaseItemID + 30, 190)).setUnlocalizedName("cagegoldcow");
/* 6225 */     CagedEnchantedCow = (new CritterCage(BaseItemID + 31, 191)).setUnlocalizedName("cageenchantedcow");
/* 6226 */     CagedMOTHRA = (new CritterCage(BaseItemID + 32, 208)).setUnlocalizedName("cageMOTHRA");
/* 6227 */     CagedAlo = (new CritterCage(BaseItemID + 33, 209)).setUnlocalizedName("cagealosaurus");
/* 6228 */     CagedCryo = (new CritterCage(BaseItemID + 34, 210)).setUnlocalizedName("cagecryolophosaurus");
/* 6229 */     CagedCama = (new CritterCage(BaseItemID + 35, 211)).setUnlocalizedName("cagecamarasaurus");
/* 6230 */     CagedVelo = (new CritterCage(BaseItemID + 36, 212)).setUnlocalizedName("cagevelocityraptor");
/* 6231 */     CagedHydro = (new CritterCage(BaseItemID + 37, 213)).setUnlocalizedName("cagehydrolisc");
/* 6232 */     CagedBasil = (new CritterCage(BaseItemID + 38, 214)).setUnlocalizedName("cagebasilisc");
/* 6233 */     CagedDragonfly = (new CritterCage(BaseItemID + 39, 220)).setUnlocalizedName("cagedragonfly");
/* 6234 */     CagedEmperorScorpion = (new CritterCage(BaseItemID + 41, 222)).setUnlocalizedName("cageemperorscorpion");
/* 6235 */     CagedScorpion = (new CritterCage(BaseItemID + 40, 224)).setUnlocalizedName("cagescorpion");
/* 6236 */     CagedCaveFisher = (new CritterCage(BaseItemID + 45, 226)).setUnlocalizedName("cagecavefisher");
/* 6237 */     CagedSpyro = (new CritterCage(BaseItemID + 42, 228)).setUnlocalizedName("cagespyro");
/* 6238 */     CagedBaryonyx = (new CritterCage(BaseItemID + 43, 230)).setUnlocalizedName("cagebaryonyx");
/* 6239 */     CagedGammaMetroid = (new CritterCage(BaseItemID + 44, 232)).setUnlocalizedName("cagegammametroid");
/* 6240 */     CagedCockateil = (new CritterCage(BaseItemID + 46, 234)).setUnlocalizedName("cagecockateil");
/* 6241 */     CagedKyuubi = (new CritterCage(BaseItemID + 47, 236)).setUnlocalizedName("cagekyuubi");
/* 6242 */     CagedAlien = (new CritterCage(BaseItemID + 48, 238)).setUnlocalizedName("cagealien");
/* 6243 */     CagedAttackSquid = (new CritterCage(BaseItemID + 49, 240)).setUnlocalizedName("cageattacksquid");
/* 6244 */     CagedWaterDragon = (new CritterCage(BaseItemID + 50, 242)).setUnlocalizedName("cagewaterdragon");
/* 6245 */     CagedCephadrome = (new CritterCage(BaseItemID + 53, 248)).setUnlocalizedName("cagecephadrome");
/* 6246 */     CagedKraken = (new CritterCage(BaseItemID + 51, 244)).setUnlocalizedName("cagekraken");
/* 6247 */     CagedLizard = (new CritterCage(BaseItemID + 52, 246)).setUnlocalizedName("cagelizard");
/* 6248 */     CagedDragon = (new CritterCage(BaseItemID + 54, 250)).setUnlocalizedName("cagedragon");
/* 6249 */     CagedBee = (new CritterCage(BaseItemID + 55, 252)).setUnlocalizedName("cagebee");
/* 6250 */     CagedHorse = (new CritterCage(BaseItemID + 56, 253)).setUnlocalizedName("cagehorse");
/* 6251 */     CagedFirefly = (new CritterCage(BaseItemID + 57, 255)).setUnlocalizedName("cagefirefly");
/* 6252 */     CagedChipmunk = (new CritterCage(BaseItemID + 58, 256)).setUnlocalizedName("cagechipmunk");
/* 6253 */     CagedGazelle = (new CritterCage(BaseItemID + 59, 257)).setUnlocalizedName("cagegazelle");
/* 6254 */     CagedOstrich = (new CritterCage(BaseItemID + 60, 258)).setUnlocalizedName("cageostrich");
/* 6255 */     CagedTrooper = (new CritterCage(BaseItemID + 61, 259)).setUnlocalizedName("cagetrooper");
/* 6256 */     CagedSpit = (new CritterCage(BaseItemID + 62, 260)).setUnlocalizedName("cagespit");
/* 6257 */     CagedStink = (new CritterCage(BaseItemID + 63, 261)).setUnlocalizedName("cagestink");
/* 6258 */     CagedCreepingHorror = (new CritterCage(BaseItemID + 64, 268)).setUnlocalizedName("cagecreepinghorror");
/* 6259 */     CagedTerribleTerror = (new CritterCage(BaseItemID + 65, 269)).setUnlocalizedName("cageterribleterror");
/* 6260 */     CagedCliffRacer = (new CritterCage(BaseItemID + 66, 270)).setUnlocalizedName("cagecliffracer");
/* 6261 */     CagedTriffid = (new CritterCage(BaseItemID + 67, 271)).setUnlocalizedName("cagetriffid");
/* 6262 */     CagedPitchBlack = (new CritterCage(BaseItemID + 68, 272)).setUnlocalizedName("cagenightmare");
/* 6263 */     CagedLurkingTerror = (new CritterCage(BaseItemID + 69, 273)).setUnlocalizedName("cagelurkingterror");
/* 6264 */     CagedSmallWorm = (new CritterCage(BaseItemID + 70, 281)).setUnlocalizedName("cagesmallworm");
/* 6265 */     CagedMediumWorm = (new CritterCage(BaseItemID + 71, 282)).setUnlocalizedName("cagemediumworm");
/* 6266 */     CagedLargeWorm = (new CritterCage(BaseItemID + 72, 283)).setUnlocalizedName("cagelargeworm");
/* 6267 */     CagedCassowary = (new CritterCage(BaseItemID + 73, 284)).setUnlocalizedName("cagecassowary");
/* 6268 */     CagedCloudShark = (new CritterCage(BaseItemID + 74, 285)).setUnlocalizedName("cagecloudshark");
/* 6269 */     CagedGoldFish = (new CritterCage(BaseItemID + 75, 286)).setUnlocalizedName("cagegoldfish");
/* 6270 */     CagedLeafMonster = (new CritterCage(BaseItemID + 76, 287)).setUnlocalizedName("cageleafmonster");
/* 6271 */     CagedEnderKnight = (new CritterCage(BaseItemID + 77, 296)).setUnlocalizedName("cageenderknight");
/* 6272 */     CagedEnderReaper = (new CritterCage(BaseItemID + 78, 297)).setUnlocalizedName("cageenderreaper");
/* 6273 */     CagedBeaver = (new CritterCage(BaseItemID + 79, 300)).setUnlocalizedName("cagebeaver");
/* 6274 */     CagedUrchin = (new CritterCage(BaseItemID + 80, 323)).setUnlocalizedName("cageurchin");
/* 6275 */     CagedFlounder = (new CritterCage(BaseItemID + 81, 319)).setUnlocalizedName("cageflounder");
/* 6276 */     CagedSkate = (new CritterCage(BaseItemID + 82, 322)).setUnlocalizedName("cageskate");
/* 6277 */     CagedRotator = (new CritterCage(BaseItemID + 83, 313)).setUnlocalizedName("cagerotator");
/* 6278 */     CagedPeacock = (new CritterCage(BaseItemID + 84, 315)).setUnlocalizedName("cagepeacock");
/* 6279 */     CagedFairy = (new CritterCage(BaseItemID + 85, 316)).setUnlocalizedName("cagefairy");
/* 6280 */     CagedDungeonBeast = (new CritterCage(BaseItemID + 86, 317)).setUnlocalizedName("cagedungeonbeast");
/* 6281 */     CagedVortex = (new CritterCage(BaseItemID + 87, 314)).setUnlocalizedName("cagevortex");
/* 6282 */     CagedRat = (new CritterCage(BaseItemID + 88, 318)).setUnlocalizedName("cagerat");
/* 6283 */     CagedWhale = (new CritterCage(BaseItemID + 89, 320)).setUnlocalizedName("cagewhale");
/* 6284 */     CagedIrukandji = (new CritterCage(BaseItemID + 90, 321)).setUnlocalizedName("cageirukandji");
/* 6285 */     CagedTRex = (new CritterCage(BaseItemID + 91, 345)).setUnlocalizedName("cagetrex");
/* 6286 */     CagedHercules = (new CritterCage(BaseItemID + 92, 346)).setUnlocalizedName("cagehercules");
/* 6287 */     CagedMantis = (new CritterCage(BaseItemID + 93, 347)).setUnlocalizedName("cagemantis");
/* 6288 */     CagedStinky = (new CritterCage(BaseItemID + 94, 348)).setUnlocalizedName("cagestinky");
/* 6289 */     CagedEasterBunny = (new CritterCage(BaseItemID + 96, 150)).setUnlocalizedName("cageeasterbunny");
/* 6290 */     CagedCaterKiller = (new CritterCage(BaseItemID + 97, 151)).setUnlocalizedName("cagecaterkiller");
/* 6291 */     CagedMolenoid = (new CritterCage(BaseItemID + 98, 152)).setUnlocalizedName("cagemolenoid");
/* 6292 */     CagedSeaMonster = (new CritterCage(BaseItemID + 99, 153)).setUnlocalizedName("cageseamonster");
/* 6293 */     CagedSeaViper = (new CritterCage(BaseItemID + 174, 154)).setUnlocalizedName("cageseaviper");
/* 6294 */     CagedLeon = (new CritterCage(BaseItemID + 423, 357)).setUnlocalizedName("cageleon");
/* 6295 */     CagedHammerhead = (new CritterCage(BaseItemID + 425, 359)).setUnlocalizedName("cagehammerhead");
/* 6296 */     CagedRubberDucky = (new CritterCage(BaseItemID + 427, 361)).setUnlocalizedName("cagerubberducky");
/* 6297 */     CagedCrystalCow = (new CritterCage(BaseItemID + 429, 216)).setUnlocalizedName("cagecrystalcow");
/* 6298 */     CagedVillager = (new CritterCage(BaseItemID + 430, 217)).setUnlocalizedName("cagevillager");
/* 6299 */     CagedCriminal = (new CritterCage(BaseItemID + 433, 218)).setUnlocalizedName("cagecriminal");
/* 6300 */     CagedBrutalfly = (new CritterCage(BaseItemID + 465, 373)).setUnlocalizedName("cagebrutalfly");
/* 6301 */     CagedNastysaurus = (new CritterCage(BaseItemID + 466, 374)).setUnlocalizedName("cagenastysaurus");
/* 6302 */     CagedPointysaurus = (new CritterCage(BaseItemID + 467, 375)).setUnlocalizedName("cagepointysaurus");
/* 6303 */     CagedCricket = (new CritterCage(BaseItemID + 468, 376)).setUnlocalizedName("cagecricket");
/* 6304 */     CagedFrog = (new CritterCage(BaseItemID + 469, 377)).setUnlocalizedName("cagefrog");
/* 6305 */     CagedSpiderDriver = (new CritterCage(BaseItemID + 478, 382)).setUnlocalizedName("cagespiderdriver");
/* 6306 */     CagedCrab = (new CritterCage(BaseItemID + 483, 384)).setUnlocalizedName("cagecrab");
/*      */ 
/*      */     
/* 6309 */     WitherSkeletonEgg = (new ItemSpawnEgg(BaseItemID + 100, 192)).setUnlocalizedName("eggwitherskeleton");
/* 6310 */     EnderDragonEgg = (new ItemSpawnEgg(BaseItemID + 101, 193)).setUnlocalizedName("eggenderdragon");
/* 6311 */     SnowGolemEgg = (new ItemSpawnEgg(BaseItemID + 102, 194)).setUnlocalizedName("eggsnowgolem");
/* 6312 */     IronGolemEgg = (new ItemSpawnEgg(BaseItemID + 103, 195)).setUnlocalizedName("eggirongolem");
/* 6313 */     WitherBossEgg = (new ItemSpawnEgg(BaseItemID + 104, 196)).setUnlocalizedName("eggwitherboss");
/* 6314 */     GirlfriendEgg = (new ItemSpawnEgg(BaseItemID + 105, 197)).setUnlocalizedName("egggirlfriend");
/* 6315 */     RedCowEgg = (new ItemSpawnEgg(BaseItemID + 106, 198)).setUnlocalizedName("eggredcow");
/* 6316 */     CrystalCowEgg = (new ItemSpawnEgg(BaseItemID + 431, 363)).setUnlocalizedName("eggcrystalcow");
/* 6317 */     GoldCowEgg = (new ItemSpawnEgg(BaseItemID + 107, 199)).setUnlocalizedName("egggoldcow");
/* 6318 */     EnchantedCowEgg = (new ItemSpawnEgg(BaseItemID + 108, 200)).setUnlocalizedName("eggenchantedcow");
/* 6319 */     MOTHRAEgg = (new ItemSpawnEgg(BaseItemID + 109, 201)).setUnlocalizedName("eggMOTHRA");
/* 6320 */     AloEgg = (new ItemSpawnEgg(BaseItemID + 110, 202)).setUnlocalizedName("eggalosaurus");
/* 6321 */     CryoEgg = (new ItemSpawnEgg(BaseItemID + 111, 203)).setUnlocalizedName("eggcryolophosaurus");
/* 6322 */     CamaEgg = (new ItemSpawnEgg(BaseItemID + 112, 204)).setUnlocalizedName("eggcamarasaurus");
/* 6323 */     VeloEgg = (new ItemSpawnEgg(BaseItemID + 113, 205)).setUnlocalizedName("eggvelocityraptor");
/* 6324 */     HydroEgg = (new ItemSpawnEgg(BaseItemID + 114, 206)).setUnlocalizedName("egghydrolisc");
/* 6325 */     BasilEgg = (new ItemSpawnEgg(BaseItemID + 115, 207)).setUnlocalizedName("eggbasilisc");
/* 6326 */     DragonflyEgg = (new ItemSpawnEgg(BaseItemID + 116, 221)).setUnlocalizedName("eggdragonfly");
/* 6327 */     EmperorScorpionEgg = (new ItemSpawnEgg(BaseItemID + 117, 223)).setUnlocalizedName("eggemperorscorpion");
/* 6328 */     ScorpionEgg = (new ItemSpawnEgg(BaseItemID + 118, 225)).setUnlocalizedName("eggscorpion");
/* 6329 */     CaveFisherEgg = (new ItemSpawnEgg(BaseItemID + 119, 227)).setUnlocalizedName("eggcavefisher");
/* 6330 */     SpyroEgg = (new ItemSpawnEgg(BaseItemID + 120, 229)).setUnlocalizedName("eggspyro");
/* 6331 */     BaryonyxEgg = (new ItemSpawnEgg(BaseItemID + 121, 231)).setUnlocalizedName("eggbaryonyx");
/* 6332 */     GammaMetroidEgg = (new ItemSpawnEgg(BaseItemID + 122, 233)).setUnlocalizedName("egggammametroid");
/* 6333 */     CockateilEgg = (new ItemSpawnEgg(BaseItemID + 123, 235)).setUnlocalizedName("eggcockateil");
/* 6334 */     KyuubiEgg = (new ItemSpawnEgg(BaseItemID + 124, 237)).setUnlocalizedName("eggkyuubi");
/* 6335 */     AlienEgg = (new ItemSpawnEgg(BaseItemID + 125, 239)).setUnlocalizedName("eggalien");
/* 6336 */     AttackSquidEgg = (new ItemSpawnEgg(BaseItemID + 126, 241)).setUnlocalizedName("eggattacksquid");
/* 6337 */     WaterDragonEgg = (new ItemSpawnEgg(BaseItemID + 127, 243)).setUnlocalizedName("eggwaterdragon");
/* 6338 */     CephadromeEgg = (new ItemSpawnEgg(BaseItemID + 130, 249)).setUnlocalizedName("eggcephadrome");
/* 6339 */     KrakenEgg = (new ItemSpawnEgg(BaseItemID + 128, 245)).setUnlocalizedName("eggkraken");
/* 6340 */     LizardEgg = (new ItemSpawnEgg(BaseItemID + 129, 247)).setUnlocalizedName("egglizard");
/* 6341 */     DragonEgg = (new ItemSpawnEgg(BaseItemID + 131, 251)).setUnlocalizedName("eggdragon");
/* 6342 */     BeeEgg = (new ItemSpawnEgg(BaseItemID + 132, 254)).setUnlocalizedName("eggbee");
/* 6343 */     TrooperBugEgg = (new ItemSpawnEgg(BaseItemID + 133, 262)).setUnlocalizedName("eggtrooper");
/* 6344 */     SpitBugEgg = (new ItemSpawnEgg(BaseItemID + 134, 263)).setUnlocalizedName("eggspit");
/* 6345 */     StinkBugEgg = (new ItemSpawnEgg(BaseItemID + 135, 264)).setUnlocalizedName("eggstink");
/* 6346 */     OstrichEgg = (new ItemSpawnEgg(BaseItemID + 136, 265)).setUnlocalizedName("eggostrich");
/* 6347 */     GazelleEgg = (new ItemSpawnEgg(BaseItemID + 137, 266)).setUnlocalizedName("egggazelle");
/* 6348 */     ChipmunkEgg = (new ItemSpawnEgg(BaseItemID + 138, 267)).setUnlocalizedName("eggchipmunk");
/* 6349 */     CreepingHorrorEgg = (new ItemSpawnEgg(BaseItemID + 139, 274)).setUnlocalizedName("eggcreepinghorror");
/* 6350 */     TerribleTerrorEgg = (new ItemSpawnEgg(BaseItemID + 140, 275)).setUnlocalizedName("eggterribleterror");
/* 6351 */     CliffRacerEgg = (new ItemSpawnEgg(BaseItemID + 141, 276)).setUnlocalizedName("eggcliffracer");
/* 6352 */     TriffidEgg = (new ItemSpawnEgg(BaseItemID + 142, 277)).setUnlocalizedName("eggtriffid");
/* 6353 */     PitchBlackEgg = (new ItemSpawnEgg(BaseItemID + 143, 278)).setUnlocalizedName("eggnightmare");
/* 6354 */     LurkingTerrorEgg = (new ItemSpawnEgg(BaseItemID + 144, 279)).setUnlocalizedName("egglurkingterror");
/* 6355 */     GodzillaEgg = (new ItemSpawnEgg(BaseItemID + 145, 280)).setUnlocalizedName("egggodzilla");
/* 6356 */     SmallWormEgg = (new ItemSpawnEgg(BaseItemID + 146, 288)).setUnlocalizedName("eggsmallworm");
/* 6357 */     MediumWormEgg = (new ItemSpawnEgg(BaseItemID + 147, 289)).setUnlocalizedName("eggmediumworm");
/* 6358 */     LargeWormEgg = (new ItemSpawnEgg(BaseItemID + 148, 290)).setUnlocalizedName("egglargeworm");
/* 6359 */     CassowaryEgg = (new ItemSpawnEgg(BaseItemID + 149, 291)).setUnlocalizedName("eggcassowary");
/* 6360 */     CloudSharkEgg = (new ItemSpawnEgg(BaseItemID + 165, 292)).setUnlocalizedName("eggcloudshark");
/* 6361 */     GoldFishEgg = (new ItemSpawnEgg(BaseItemID + 166, 293)).setUnlocalizedName("egggoldfish");
/* 6362 */     LeafMonsterEgg = (new ItemSpawnEgg(BaseItemID + 167, 294)).setUnlocalizedName("eggleafmonster");
/* 6363 */     TshirtEgg = (new ItemSpawnEgg(BaseItemID + 168, 295)).setUnlocalizedName("eggtshirt");
/* 6364 */     EnderKnightEgg = (new ItemSpawnEgg(BaseItemID + 169, 298)).setUnlocalizedName("eggenderknight");
/* 6365 */     EnderReaperEgg = (new ItemSpawnEgg(BaseItemID + 170, 299)).setUnlocalizedName("eggenderreaper");
/* 6366 */     BeaverEgg = (new ItemSpawnEgg(BaseItemID + 171, 301)).setUnlocalizedName("eggbeaver");
/* 6367 */     RotatorEgg = (new ItemSpawnEgg(BaseItemID + 219, 302)).setUnlocalizedName("eggrotator");
/* 6368 */     VortexEgg = (new ItemSpawnEgg(BaseItemID + 223, 303)).setUnlocalizedName("eggvortex");
/* 6369 */     PeacockEgg = (new ItemSpawnEgg(BaseItemID + 220, 304)).setUnlocalizedName("eggpeacock");
/* 6370 */     FairyEgg = (new ItemSpawnEgg(BaseItemID + 221, 305)).setUnlocalizedName("eggfairy");
/* 6371 */     DungeonBeastEgg = (new ItemSpawnEgg(BaseItemID + 222, 306)).setUnlocalizedName("eggdungeonbeast");
/* 6372 */     RatEgg = (new ItemSpawnEgg(BaseItemID + 374, 307)).setUnlocalizedName("eggrat");
/* 6373 */     FlounderEgg = (new ItemSpawnEgg(BaseItemID + 375, 308)).setUnlocalizedName("eggflounder");
/* 6374 */     WhaleEgg = (new ItemSpawnEgg(BaseItemID + 376, 309)).setUnlocalizedName("eggwhale");
/* 6375 */     IrukandjiEgg = (new ItemSpawnEgg(BaseItemID + 377, 310)).setUnlocalizedName("eggirukandji");
/* 6376 */     SkateEgg = (new ItemSpawnEgg(BaseItemID + 378, 311)).setUnlocalizedName("eggskate");
/* 6377 */     UrchinEgg = (new ItemSpawnEgg(BaseItemID + 379, 312)).setUnlocalizedName("eggurchin");
/* 6378 */     Robot1Egg = (new ItemSpawnEgg(BaseItemID + 380, 324)).setUnlocalizedName("eggrobot1");
/* 6379 */     Robot2Egg = (new ItemSpawnEgg(BaseItemID + 381, 325)).setUnlocalizedName("eggrobot2");
/* 6380 */     Robot3Egg = (new ItemSpawnEgg(BaseItemID + 382, 326)).setUnlocalizedName("eggrobot3");
/* 6381 */     Robot4Egg = (new ItemSpawnEgg(BaseItemID + 383, 327)).setUnlocalizedName("eggrobot4");
/* 6382 */     GhostEgg = (new ItemSpawnEgg(BaseItemID + 384, 328)).setUnlocalizedName("eggghost");
/* 6383 */     GhostSkellyEgg = (new ItemSpawnEgg(BaseItemID + 385, 329)).setUnlocalizedName("eggghostskelly");
/* 6384 */     BrownAntEgg = (new ItemSpawnEgg(BaseItemID + 386, 330)).setUnlocalizedName("eggbrownant");
/* 6385 */     RedAntEgg = (new ItemSpawnEgg(BaseItemID + 387, 331)).setUnlocalizedName("eggredant");
/* 6386 */     RainbowAntEgg = (new ItemSpawnEgg(BaseItemID + 388, 332)).setUnlocalizedName("eggrainbowant");
/* 6387 */     UnstableAntEgg = (new ItemSpawnEgg(BaseItemID + 389, 333)).setUnlocalizedName("eggunstableant");
/* 6388 */     TermiteEgg = (new ItemSpawnEgg(BaseItemID + 390, 334)).setUnlocalizedName("eggtermite");
/* 6389 */     ButterflyEgg = (new ItemSpawnEgg(BaseItemID + 391, 335)).setUnlocalizedName("eggbutterfly");
/* 6390 */     MothEgg = (new ItemSpawnEgg(BaseItemID + 392, 336)).setUnlocalizedName("eggmoth");
/* 6391 */     MosquitoEgg = (new ItemSpawnEgg(BaseItemID + 393, 337)).setUnlocalizedName("eggmosquito");
/* 6392 */     FireflyEgg = (new ItemSpawnEgg(BaseItemID + 394, 338)).setUnlocalizedName("eggfirefly");
/* 6393 */     TRexEgg = (new ItemSpawnEgg(BaseItemID + 225, 339)).setUnlocalizedName("eggtrex");
/* 6394 */     HerculesEgg = (new ItemSpawnEgg(BaseItemID + 226, 340)).setUnlocalizedName("egghercules");
/* 6395 */     MantisEgg = (new ItemSpawnEgg(BaseItemID + 227, 341)).setUnlocalizedName("eggmantis");
/* 6396 */     StinkyEgg = (new ItemSpawnEgg(BaseItemID + 228, 342)).setUnlocalizedName("eggstinky");
/* 6397 */     Robot5Egg = (new ItemSpawnEgg(BaseItemID + 172, 343)).setUnlocalizedName("eggrobot5");
/* 6398 */     CoinEgg = (new ItemSpawnEgg(BaseItemID + 173, 344)).setUnlocalizedName("eggcoin");
/* 6399 */     BoyfriendEgg = (new ItemSpawnEgg(BaseItemID + 399, 349)).setUnlocalizedName("eggboyfriend");
/* 6400 */     TheKingEgg = (new ItemSpawnEgg(BaseItemID + 400, 350)).setUnlocalizedName("eggtheking");
/* 6401 */     TheQueenEgg = (new ItemSpawnEgg(BaseItemID + 448, 366)).setUnlocalizedName("eggthequeen");
/* 6402 */     ThePrinceEgg = (new ItemSpawnEgg(BaseItemID + 401, 351)).setUnlocalizedName("eggtheprince");
/* 6403 */     EasterBunnyEgg = (new ItemSpawnEgg(BaseItemID + 416, 352)).setUnlocalizedName("eggeasterbunny");
/* 6404 */     MolenoidEgg = (new ItemSpawnEgg(BaseItemID + 417, 353)).setUnlocalizedName("eggmolenoid");
/* 6405 */     SeaMonsterEgg = (new ItemSpawnEgg(BaseItemID + 418, 354)).setUnlocalizedName("eggseamonster");
/* 6406 */     SeaViperEgg = (new ItemSpawnEgg(BaseItemID + 419, 355)).setUnlocalizedName("eggseaviper");
/* 6407 */     CaterKillerEgg = (new ItemSpawnEgg(BaseItemID + 420, 356)).setUnlocalizedName("eggcaterkiller");
/* 6408 */     RubberDuckyEgg = (new ItemSpawnEgg(BaseItemID + 428, 362)).setUnlocalizedName("eggrubberducky");
/* 6409 */     HammerheadEgg = (new ItemSpawnEgg(BaseItemID + 426, 360)).setUnlocalizedName("egghammerhead");
/* 6410 */     LeonEgg = (new ItemSpawnEgg(BaseItemID + 424, 358)).setUnlocalizedName("eggleon");
/* 6411 */     CriminalEgg = (new ItemSpawnEgg(BaseItemID + 434, 365)).setUnlocalizedName("eggcriminal");
/* 6412 */     BrutalflyEgg = (new ItemSpawnEgg(BaseItemID + 459, 367)).setUnlocalizedName("eggbrutalfly");
/* 6413 */     NastysaurusEgg = (new ItemSpawnEgg(BaseItemID + 460, 368)).setUnlocalizedName("eggnastysaurus");
/* 6414 */     PointysaurusEgg = (new ItemSpawnEgg(BaseItemID + 461, 369)).setUnlocalizedName("eggpointysaurus");
/* 6415 */     CricketEgg = (new ItemSpawnEgg(BaseItemID + 462, 370)).setUnlocalizedName("eggcricket");
/* 6416 */     ThePrincessEgg = (new ItemSpawnEgg(BaseItemID + 463, 371)).setUnlocalizedName("eggtheprincess");
/* 6417 */     FrogEgg = (new ItemSpawnEgg(BaseItemID + 464, 372)).setUnlocalizedName("eggfrog");
/* 6418 */     JefferyEgg = (new ItemSpawnEgg(BaseItemID + 474, 378)).setUnlocalizedName("eggrobot6");
/* 6419 */     AntRobotEgg = (new ItemSpawnEgg(BaseItemID + 475, 379)).setUnlocalizedName("eggantrobot");
/* 6420 */     SpiderRobotEgg = (new ItemSpawnEgg(BaseItemID + 476, 380)).setUnlocalizedName("eggspiderrobot");
/* 6421 */     SpiderDriverEgg = (new ItemSpawnEgg(BaseItemID + 477, 381)).setUnlocalizedName("eggspiderdriver");
/* 6422 */     CrabEgg = (new ItemSpawnEgg(BaseItemID + 482, 383)).setUnlocalizedName("eggcrab");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void DoDispenserRegistrations() {
/* 6431 */     BlockDispenser.dispenseBehaviorRegistry.putObject(LizardEgg, new DispenserBehaviorOreSpawnEgg());
/* 6432 */     BlockDispenser.dispenseBehaviorRegistry.putObject(WitherSkeletonEgg, new DispenserBehaviorOreSpawnEgg());
/* 6433 */     BlockDispenser.dispenseBehaviorRegistry.putObject(EnderDragonEgg, new DispenserBehaviorOreSpawnEgg());
/* 6434 */     BlockDispenser.dispenseBehaviorRegistry.putObject(SnowGolemEgg, new DispenserBehaviorOreSpawnEgg());
/* 6435 */     BlockDispenser.dispenseBehaviorRegistry.putObject(IronGolemEgg, new DispenserBehaviorOreSpawnEgg());
/* 6436 */     BlockDispenser.dispenseBehaviorRegistry.putObject(WitherBossEgg, new DispenserBehaviorOreSpawnEgg());
/* 6437 */     BlockDispenser.dispenseBehaviorRegistry.putObject(GirlfriendEgg, new DispenserBehaviorOreSpawnEgg());
/* 6438 */     BlockDispenser.dispenseBehaviorRegistry.putObject(BoyfriendEgg, new DispenserBehaviorOreSpawnEgg());
/* 6439 */     BlockDispenser.dispenseBehaviorRegistry.putObject(TheKingEgg, new DispenserBehaviorOreSpawnEgg());
/* 6440 */     BlockDispenser.dispenseBehaviorRegistry.putObject(TheQueenEgg, new DispenserBehaviorOreSpawnEgg());
/* 6441 */     BlockDispenser.dispenseBehaviorRegistry.putObject(ThePrinceEgg, new DispenserBehaviorOreSpawnEgg());
/* 6442 */     BlockDispenser.dispenseBehaviorRegistry.putObject(RedCowEgg, new DispenserBehaviorOreSpawnEgg());
/* 6443 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CrystalCowEgg, new DispenserBehaviorOreSpawnEgg());
/* 6444 */     BlockDispenser.dispenseBehaviorRegistry.putObject(GoldCowEgg, new DispenserBehaviorOreSpawnEgg());
/* 6445 */     BlockDispenser.dispenseBehaviorRegistry.putObject(EnchantedCowEgg, new DispenserBehaviorOreSpawnEgg());
/* 6446 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MOTHRAEgg, new DispenserBehaviorOreSpawnEgg());
/* 6447 */     BlockDispenser.dispenseBehaviorRegistry.putObject(AloEgg, new DispenserBehaviorOreSpawnEgg());
/* 6448 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CryoEgg, new DispenserBehaviorOreSpawnEgg());
/* 6449 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CamaEgg, new DispenserBehaviorOreSpawnEgg());
/* 6450 */     BlockDispenser.dispenseBehaviorRegistry.putObject(VeloEgg, new DispenserBehaviorOreSpawnEgg());
/* 6451 */     BlockDispenser.dispenseBehaviorRegistry.putObject(HydroEgg, new DispenserBehaviorOreSpawnEgg());
/* 6452 */     BlockDispenser.dispenseBehaviorRegistry.putObject(BasilEgg, new DispenserBehaviorOreSpawnEgg());
/* 6453 */     BlockDispenser.dispenseBehaviorRegistry.putObject(DragonflyEgg, new DispenserBehaviorOreSpawnEgg());
/* 6454 */     BlockDispenser.dispenseBehaviorRegistry.putObject(EmperorScorpionEgg, new DispenserBehaviorOreSpawnEgg());
/* 6455 */     BlockDispenser.dispenseBehaviorRegistry.putObject(ScorpionEgg, new DispenserBehaviorOreSpawnEgg());
/* 6456 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CaveFisherEgg, new DispenserBehaviorOreSpawnEgg());
/* 6457 */     BlockDispenser.dispenseBehaviorRegistry.putObject(SpyroEgg, new DispenserBehaviorOreSpawnEgg());
/* 6458 */     BlockDispenser.dispenseBehaviorRegistry.putObject(BaryonyxEgg, new DispenserBehaviorOreSpawnEgg());
/* 6459 */     BlockDispenser.dispenseBehaviorRegistry.putObject(GammaMetroidEgg, new DispenserBehaviorOreSpawnEgg());
/* 6460 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CockateilEgg, new DispenserBehaviorOreSpawnEgg());
/* 6461 */     BlockDispenser.dispenseBehaviorRegistry.putObject(KyuubiEgg, new DispenserBehaviorOreSpawnEgg());
/* 6462 */     BlockDispenser.dispenseBehaviorRegistry.putObject(AlienEgg, new DispenserBehaviorOreSpawnEgg());
/* 6463 */     BlockDispenser.dispenseBehaviorRegistry.putObject(AttackSquidEgg, new DispenserBehaviorOreSpawnEgg());
/* 6464 */     BlockDispenser.dispenseBehaviorRegistry.putObject(WaterDragonEgg, new DispenserBehaviorOreSpawnEgg());
/* 6465 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CephadromeEgg, new DispenserBehaviorOreSpawnEgg());
/* 6466 */     BlockDispenser.dispenseBehaviorRegistry.putObject(DragonEgg, new DispenserBehaviorOreSpawnEgg());
/* 6467 */     BlockDispenser.dispenseBehaviorRegistry.putObject(KrakenEgg, new DispenserBehaviorOreSpawnEgg());
/* 6468 */     BlockDispenser.dispenseBehaviorRegistry.putObject(LizardEgg, new DispenserBehaviorOreSpawnEgg());
/* 6469 */     BlockDispenser.dispenseBehaviorRegistry.putObject(BeeEgg, new DispenserBehaviorOreSpawnEgg());
/* 6470 */     BlockDispenser.dispenseBehaviorRegistry.putObject(TrooperBugEgg, new DispenserBehaviorOreSpawnEgg());
/* 6471 */     BlockDispenser.dispenseBehaviorRegistry.putObject(SpitBugEgg, new DispenserBehaviorOreSpawnEgg());
/* 6472 */     BlockDispenser.dispenseBehaviorRegistry.putObject(StinkBugEgg, new DispenserBehaviorOreSpawnEgg());
/* 6473 */     BlockDispenser.dispenseBehaviorRegistry.putObject(OstrichEgg, new DispenserBehaviorOreSpawnEgg());
/* 6474 */     BlockDispenser.dispenseBehaviorRegistry.putObject(GazelleEgg, new DispenserBehaviorOreSpawnEgg());
/* 6475 */     BlockDispenser.dispenseBehaviorRegistry.putObject(ChipmunkEgg, new DispenserBehaviorOreSpawnEgg());
/* 6476 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CreepingHorrorEgg, new DispenserBehaviorOreSpawnEgg());
/* 6477 */     BlockDispenser.dispenseBehaviorRegistry.putObject(TerribleTerrorEgg, new DispenserBehaviorOreSpawnEgg());
/* 6478 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CliffRacerEgg, new DispenserBehaviorOreSpawnEgg());
/* 6479 */     BlockDispenser.dispenseBehaviorRegistry.putObject(TriffidEgg, new DispenserBehaviorOreSpawnEgg());
/* 6480 */     BlockDispenser.dispenseBehaviorRegistry.putObject(PitchBlackEgg, new DispenserBehaviorOreSpawnEgg());
/* 6481 */     BlockDispenser.dispenseBehaviorRegistry.putObject(LurkingTerrorEgg, new DispenserBehaviorOreSpawnEgg());
/* 6482 */     BlockDispenser.dispenseBehaviorRegistry.putObject(GodzillaEgg, new DispenserBehaviorOreSpawnEgg());
/* 6483 */     BlockDispenser.dispenseBehaviorRegistry.putObject(SmallWormEgg, new DispenserBehaviorOreSpawnEgg());
/* 6484 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MediumWormEgg, new DispenserBehaviorOreSpawnEgg());
/* 6485 */     BlockDispenser.dispenseBehaviorRegistry.putObject(LargeWormEgg, new DispenserBehaviorOreSpawnEgg());
/* 6486 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CassowaryEgg, new DispenserBehaviorOreSpawnEgg());
/* 6487 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CloudSharkEgg, new DispenserBehaviorOreSpawnEgg());
/* 6488 */     BlockDispenser.dispenseBehaviorRegistry.putObject(GoldFishEgg, new DispenserBehaviorOreSpawnEgg());
/* 6489 */     BlockDispenser.dispenseBehaviorRegistry.putObject(LeafMonsterEgg, new DispenserBehaviorOreSpawnEgg());
/* 6490 */     BlockDispenser.dispenseBehaviorRegistry.putObject(TshirtEgg, new DispenserBehaviorOreSpawnEgg());
/* 6491 */     BlockDispenser.dispenseBehaviorRegistry.putObject(EnderKnightEgg, new DispenserBehaviorOreSpawnEgg());
/* 6492 */     BlockDispenser.dispenseBehaviorRegistry.putObject(EnderReaperEgg, new DispenserBehaviorOreSpawnEgg());
/* 6493 */     BlockDispenser.dispenseBehaviorRegistry.putObject(BeaverEgg, new DispenserBehaviorOreSpawnEgg());
/* 6494 */     BlockDispenser.dispenseBehaviorRegistry.putObject(RotatorEgg, new DispenserBehaviorOreSpawnEgg());
/* 6495 */     BlockDispenser.dispenseBehaviorRegistry.putObject(VortexEgg, new DispenserBehaviorOreSpawnEgg());
/* 6496 */     BlockDispenser.dispenseBehaviorRegistry.putObject(PeacockEgg, new DispenserBehaviorOreSpawnEgg());
/* 6497 */     BlockDispenser.dispenseBehaviorRegistry.putObject(FairyEgg, new DispenserBehaviorOreSpawnEgg());
/* 6498 */     BlockDispenser.dispenseBehaviorRegistry.putObject(DungeonBeastEgg, new DispenserBehaviorOreSpawnEgg());
/* 6499 */     BlockDispenser.dispenseBehaviorRegistry.putObject(RatEgg, new DispenserBehaviorOreSpawnEgg());
/* 6500 */     BlockDispenser.dispenseBehaviorRegistry.putObject(FlounderEgg, new DispenserBehaviorOreSpawnEgg());
/* 6501 */     BlockDispenser.dispenseBehaviorRegistry.putObject(WhaleEgg, new DispenserBehaviorOreSpawnEgg());
/* 6502 */     BlockDispenser.dispenseBehaviorRegistry.putObject(IrukandjiEgg, new DispenserBehaviorOreSpawnEgg());
/* 6503 */     BlockDispenser.dispenseBehaviorRegistry.putObject(SkateEgg, new DispenserBehaviorOreSpawnEgg());
/* 6504 */     BlockDispenser.dispenseBehaviorRegistry.putObject(UrchinEgg, new DispenserBehaviorOreSpawnEgg());
/* 6505 */     BlockDispenser.dispenseBehaviorRegistry.putObject(Robot1Egg, new DispenserBehaviorOreSpawnEgg());
/* 6506 */     BlockDispenser.dispenseBehaviorRegistry.putObject(Robot2Egg, new DispenserBehaviorOreSpawnEgg());
/* 6507 */     BlockDispenser.dispenseBehaviorRegistry.putObject(Robot3Egg, new DispenserBehaviorOreSpawnEgg());
/* 6508 */     BlockDispenser.dispenseBehaviorRegistry.putObject(Robot4Egg, new DispenserBehaviorOreSpawnEgg());
/* 6509 */     BlockDispenser.dispenseBehaviorRegistry.putObject(GhostEgg, new DispenserBehaviorOreSpawnEgg());
/* 6510 */     BlockDispenser.dispenseBehaviorRegistry.putObject(GhostSkellyEgg, new DispenserBehaviorOreSpawnEgg());
/* 6511 */     BlockDispenser.dispenseBehaviorRegistry.putObject(BrownAntEgg, new DispenserBehaviorOreSpawnEgg());
/* 6512 */     BlockDispenser.dispenseBehaviorRegistry.putObject(RedAntEgg, new DispenserBehaviorOreSpawnEgg());
/* 6513 */     BlockDispenser.dispenseBehaviorRegistry.putObject(RainbowAntEgg, new DispenserBehaviorOreSpawnEgg());
/* 6514 */     BlockDispenser.dispenseBehaviorRegistry.putObject(UnstableAntEgg, new DispenserBehaviorOreSpawnEgg());
/* 6515 */     BlockDispenser.dispenseBehaviorRegistry.putObject(TermiteEgg, new DispenserBehaviorOreSpawnEgg());
/* 6516 */     BlockDispenser.dispenseBehaviorRegistry.putObject(ButterflyEgg, new DispenserBehaviorOreSpawnEgg());
/* 6517 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MothEgg, new DispenserBehaviorOreSpawnEgg());
/* 6518 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MosquitoEgg, new DispenserBehaviorOreSpawnEgg());
/* 6519 */     BlockDispenser.dispenseBehaviorRegistry.putObject(FireflyEgg, new DispenserBehaviorOreSpawnEgg());
/* 6520 */     BlockDispenser.dispenseBehaviorRegistry.putObject(TRexEgg, new DispenserBehaviorOreSpawnEgg());
/* 6521 */     BlockDispenser.dispenseBehaviorRegistry.putObject(HerculesEgg, new DispenserBehaviorOreSpawnEgg());
/* 6522 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MantisEgg, new DispenserBehaviorOreSpawnEgg());
/* 6523 */     BlockDispenser.dispenseBehaviorRegistry.putObject(StinkyEgg, new DispenserBehaviorOreSpawnEgg());
/* 6524 */     BlockDispenser.dispenseBehaviorRegistry.putObject(Robot5Egg, new DispenserBehaviorOreSpawnEgg());
/* 6525 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CoinEgg, new DispenserBehaviorOreSpawnEgg());
/* 6526 */     BlockDispenser.dispenseBehaviorRegistry.putObject(EasterBunnyEgg, new DispenserBehaviorOreSpawnEgg());
/* 6527 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MolenoidEgg, new DispenserBehaviorOreSpawnEgg());
/* 6528 */     BlockDispenser.dispenseBehaviorRegistry.putObject(SeaMonsterEgg, new DispenserBehaviorOreSpawnEgg());
/* 6529 */     BlockDispenser.dispenseBehaviorRegistry.putObject(SeaViperEgg, new DispenserBehaviorOreSpawnEgg());
/* 6530 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CaterKillerEgg, new DispenserBehaviorOreSpawnEgg());
/* 6531 */     BlockDispenser.dispenseBehaviorRegistry.putObject(LeonEgg, new DispenserBehaviorOreSpawnEgg());
/* 6532 */     BlockDispenser.dispenseBehaviorRegistry.putObject(HammerheadEgg, new DispenserBehaviorOreSpawnEgg());
/* 6533 */     BlockDispenser.dispenseBehaviorRegistry.putObject(RubberDuckyEgg, new DispenserBehaviorOreSpawnEgg());
/* 6534 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CriminalEgg, new DispenserBehaviorOreSpawnEgg());
/* 6535 */     BlockDispenser.dispenseBehaviorRegistry.putObject(BrutalflyEgg, new DispenserBehaviorOreSpawnEgg());
/* 6536 */     BlockDispenser.dispenseBehaviorRegistry.putObject(NastysaurusEgg, new DispenserBehaviorOreSpawnEgg());
/* 6537 */     BlockDispenser.dispenseBehaviorRegistry.putObject(PointysaurusEgg, new DispenserBehaviorOreSpawnEgg());
/* 6538 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CricketEgg, new DispenserBehaviorOreSpawnEgg());
/* 6539 */     BlockDispenser.dispenseBehaviorRegistry.putObject(ThePrincessEgg, new DispenserBehaviorOreSpawnEgg());
/* 6540 */     BlockDispenser.dispenseBehaviorRegistry.putObject(FrogEgg, new DispenserBehaviorOreSpawnEgg());
/* 6541 */     BlockDispenser.dispenseBehaviorRegistry.putObject(JefferyEgg, new DispenserBehaviorOreSpawnEgg());
/* 6542 */     BlockDispenser.dispenseBehaviorRegistry.putObject(AntRobotEgg, new DispenserBehaviorOreSpawnEgg());
/* 6543 */     BlockDispenser.dispenseBehaviorRegistry.putObject(SpiderRobotEgg, new DispenserBehaviorOreSpawnEgg());
/* 6544 */     BlockDispenser.dispenseBehaviorRegistry.putObject(SpiderDriverEgg, new DispenserBehaviorOreSpawnEgg());
/* 6545 */     BlockDispenser.dispenseBehaviorRegistry.putObject(CrabEgg, new DispenserBehaviorOreSpawnEgg());
/*      */ 
/*      */     
/* 6548 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyIrukandjiArrow, new MyDispenserBehaviorArrow());
/* 6549 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyWaterBall, new MyDispenserBehaviorWDCharge());
/* 6550 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MySunspotUrchin, new MyDispenserBehaviorSunspotUrchin());
/* 6551 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyAcid, new MyDispenserBehaviorAcid());
/* 6552 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyIceBall, new MyDispenserBehaviorIceball());
/* 6553 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyIrukandji, new MyDispenserBehaviorDeadIrukandji());
/* 6554 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyLaserBall, new MyDispenserBehaviorLaserball());
/* 6555 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MySmallRock, new MyDispenserBehaviorRock());
/* 6556 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyRock, new MyDispenserBehaviorRock());
/* 6557 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyRedRock, new MyDispenserBehaviorRock());
/* 6558 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyCrystalRedRock, new MyDispenserBehaviorRock());
/* 6559 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyCrystalGreenRock, new MyDispenserBehaviorRock());
/* 6560 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyCrystalBlueRock, new MyDispenserBehaviorRock());
/* 6561 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyCrystalTNTRock, new MyDispenserBehaviorRock());
/* 6562 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyBlueRock, new MyDispenserBehaviorRock());
/* 6563 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyGreenRock, new MyDispenserBehaviorRock());
/* 6564 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyPurpleRock, new MyDispenserBehaviorRock());
/* 6565 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MySpikeyRock, new MyDispenserBehaviorRock());
/* 6566 */     BlockDispenser.dispenseBehaviorRegistry.putObject(MyTNTRock, new MyDispenserBehaviorRock());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @EventHandler
/*      */   public void load(FMLInitializationEvent event) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @EventHandler
/*      */   public static void postInit(FMLPostInitializationEvent event) {
/* 6583 */     BMaze = new BasiliskMaze();
/* 6584 */     RubyDungeon = new RubyBirdDungeon();
/* 6585 */     MyDungeon = new GenericDungeon();
/* 6586 */     OreSpawnTrees = new Trees();
/* 6587 */     OreSpawnUtils = new MyUtils();
/* 6588 */     Chunker = new ChunkOreGenerator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public Entity spawnEntity(int entityId, World world, double scaledX, double scaledY, double scaledZ) {
/* 6626 */     return null;
/*      */   }
/*      */   
/*      */   public static Entity getPointedAtEntity(World world, EntityPlayer player, double dist) {
/* 6630 */     Entity pointedAt = null;
/* 6631 */     if (player != null)
/*      */     {
/*      */       
/* 6634 */       if (world != null) {
/*      */ 
/*      */         
/* 6637 */         double d0 = dist;
/* 6638 */         double d1 = dist;
/* 6639 */         Vec3 vec3 = player.getPosition(1.0F);
/* 6640 */         Vec3 vec31 = player.getLook(1.0F);
/* 6641 */         Vec3 vec32 = vec3.addVector(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0);
/* 6642 */         pointedAt = null;
/* 6643 */         float f1 = 1.0F;
/* 6644 */         List<Entity> list = world.getEntitiesWithinAABBExcludingEntity((Entity)player, player.boundingBox.addCoord(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0).expand(f1, f1, f1));
/* 6645 */         double d2 = d1;
/*      */         
/* 6647 */         for (int i = 0; i < list.size(); i++) {
/*      */           
/* 6649 */           Entity entity = list.get(i);
/*      */           
/* 6651 */           if (entity.canBeCollidedWith()) {
/*      */             
/* 6653 */             float f2 = entity.getCollisionBorderSize();
/* 6654 */             AxisAlignedBB axisalignedbb = entity.boundingBox.expand(f2, f2, f2);
/* 6655 */             MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec32);
/*      */             
/* 6657 */             if (axisalignedbb.isVecInside(vec3)) {
/*      */               
/* 6659 */               if (0.0D < d2 || d2 == 0.0D)
/*      */               {
/* 6661 */                 pointedAt = entity;
/* 6662 */                 d2 = 0.0D;
/*      */               }
/*      */             
/* 6665 */             } else if (movingobjectposition != null) {
/*      */               
/* 6667 */               double d3 = vec3.distanceTo(movingobjectposition.hitVec);
/*      */               
/* 6669 */               if (d3 < d2 || d2 == 0.0D)
/*      */               {
/* 6671 */                 if (entity == player.ridingEntity && !entity.canRiderInteract()) {
/*      */                   
/* 6673 */                   if (d2 == 0.0D)
/*      */                   {
/* 6675 */                     pointedAt = entity;
/*      */                   }
/*      */                 }
/*      */                 else {
/*      */                   
/* 6680 */                   pointedAt = entity;
/* 6681 */                   d2 = d3;
/*      */                 } 
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/* 6689 */     return pointedAt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean setBlockFast(World world, int par1, int par2, int par3, Block par4, int par5, int par6) {
/* 6697 */     if (par1 >= -30000000 && par3 >= -30000000 && par1 < 30000000 && par3 < 30000000) {
/*      */       
/* 6699 */       if (par2 < 0)
/*      */       {
/* 6701 */         return false;
/*      */       }
/* 6703 */       if (par2 >= 256)
/*      */       {
/* 6705 */         return false;
/*      */       }
/*      */ 
/*      */       
/* 6709 */       Chunk chunk = world.getChunkFromChunkCoords(par1 >> 4, par3 >> 4);
/*      */       
/* 6711 */       Block k1 = Blocks.air;
/* 6712 */       if ((par6 & 0x1) != 0)
/*      */       {
/* 6714 */         k1 = chunk.getBlock(par1 & 0xF, par2, par3 & 0xF);
/*      */       }
/*      */       
/* 6717 */       boolean flag = setBlockIDWithMetadataFast(chunk, par1 & 0xF, par2, par3 & 0xF, par4, par5);
/*      */ 
/*      */       
/* 6720 */       if (flag) {
/*      */         
/* 6722 */         if ((par6 & 0x2) != 0 && (!world.isRemote || (par6 & 0x4) == 0))
/*      */         {
/* 6724 */           world.markBlockForUpdate(par1, par2, par3);
/*      */         }
/*      */         
/* 6727 */         if (!world.isRemote && (par6 & 0x1) != 0)
/*      */         {
/* 6729 */           world.notifyBlockChange(par1, par2, par3, k1);
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 6734 */       return flag;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 6739 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean setBlockSuperFast(World world, int par1, int par2, int par3, Block par4, int par5, int par6, Chunk refChunk) {
/* 6746 */     if (par1 >= -30000000 && par3 >= -30000000 && par1 < 30000000 && par3 < 30000000) {
/*      */       
/* 6748 */       if (par2 < 0)
/*      */       {
/* 6750 */         return false;
/*      */       }
/* 6752 */       if (par2 >= 256)
/*      */       {
/* 6754 */         return false;
/*      */       }
/*      */ 
/*      */       
/* 6758 */       Chunk chunk = world.getChunkFromChunkCoords(par1 >> 4, par3 >> 4);
/* 6759 */       boolean flag = true;
/* 6760 */       if (chunk != refChunk) {
/*      */         
/* 6762 */         Block k1 = Blocks.air;
/* 6763 */         if ((par6 & 0x1) != 0)
/*      */         {
/* 6765 */           k1 = chunk.getBlock(par1 & 0xF, par2, par3 & 0xF);
/*      */         }
/*      */         
/* 6768 */         flag = setBlockIDWithMetadataFast(chunk, par1 & 0xF, par2, par3 & 0xF, par4, par5);
/*      */         
/* 6770 */         if (flag) {
/*      */           
/* 6772 */           if ((par6 & 0x2) != 0 && (!world.isRemote || (par6 & 0x4) == 0))
/*      */           {
/* 6774 */             world.markBlockForUpdate(par1, par2, par3);
/*      */           }
/*      */           
/* 6777 */           if (!world.isRemote && (par6 & 0x1) != 0)
/*      */           {
/* 6779 */             world.notifyBlockChange(par1, par2, par3, k1);
/*      */           }
/*      */         } 
/*      */       } else {
/*      */         
/* 6784 */         setBlockIDWithMetadataFast(chunk, par1 & 0xF, par2, par3 & 0xF, par4, par5);
/*      */       } 
/*      */       
/* 6787 */       return flag;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 6792 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean setBlockIDWithMetadataFast(Chunk chunk, int par1, int par2, int par3, Block par4, int par5) {
/* 6803 */     if (par1 >= -30000000 && par3 >= -30000000 && par1 < 30000000 && par3 < 30000000) {
/*      */       
/* 6805 */       if (par2 < 0 || par2 > 255) return false;
/*      */       
/* 6807 */       ExtendedBlockStorage[] mystorage = chunk.getBlockStorageArray();
/* 6808 */       ExtendedBlockStorage extendedblockstorage = mystorage[par2 >> 4];
/*      */       
/* 6810 */       if (extendedblockstorage == null) {
/*      */         
/* 6812 */         if (par4 == Blocks.air)
/*      */         {
/* 6814 */           return false;
/*      */         }
/* 6816 */         extendedblockstorage = mystorage[par2 >> 4] = new ExtendedBlockStorage(par2 >> 4 << 4, !chunk.worldObj.provider.hasNoSky);
/* 6817 */         chunk.setStorageArrays(mystorage);
/*      */       } 
/*      */       
/* 6820 */       extendedblockstorage.func_150818_a(par1, par2 & 0xF, par3, par4);
/* 6821 */       extendedblockstorage.setExtBlockMetadata(par1, par2 & 0xF, par3, par5);
/*      */       
/* 6823 */       return true;
/*      */     } 
/* 6825 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static Block getBlockIDInChunk(Chunk chunk, int par1, int par2, int par3) {
/* 6831 */     if (par1 >= -30000000 && par3 >= -30000000 && par1 < 30000000 && par3 < 30000000) {
/* 6832 */       if (par1 >> 4 != chunk.xPosition) return Blocks.air; 
/* 6833 */       if (par3 >> 4 != chunk.zPosition) return Blocks.air; 
/* 6834 */       if (par2 < 0 || par2 > 255) return Blocks.air; 
/* 6835 */       return chunk.getBlock(par1 & 0xF, par2, par3 & 0xF);
/*      */     } 
/* 6837 */     return Blocks.air;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean setBlockIDWithMetadataInChunk(Chunk chunk, int par1, int par2, int par3, Block par4, int par5) {
/* 6843 */     if (par1 >= -30000000 && par3 >= -30000000 && par1 < 30000000 && par3 < 30000000) {
/* 6844 */       if (par1 >> 4 != chunk.xPosition) return false; 
/* 6845 */       if (par3 >> 4 != chunk.zPosition) return false; 
/* 6846 */       if (par2 < 0 || par2 > 255) return false;
/*      */       
/* 6848 */       ExtendedBlockStorage[] mystorage = chunk.getBlockStorageArray();
/* 6849 */       ExtendedBlockStorage extendedblockstorage = mystorage[par2 >> 4];
/*      */       
/* 6851 */       par1 &= 0xF;
/* 6852 */       par3 &= 0xF;
/*      */       
/* 6854 */       if (extendedblockstorage == null) {
/* 6855 */         if (par4 == Blocks.air || par4 == null) {
/* 6856 */           return false;
/*      */         }
/* 6858 */         extendedblockstorage = mystorage[par2 >> 4] = new ExtendedBlockStorage(par2 >> 4 << 4, !chunk.worldObj.provider.hasNoSky);
/* 6859 */         chunk.setStorageArrays(mystorage);
/*      */       } 
/* 6861 */       extendedblockstorage.func_150818_a(par1, par2 & 0xF, par3, par4);
/* 6862 */       extendedblockstorage.setExtBlockMetadata(par1, par2 & 0xF, par3, par5);
/*      */       
/* 6864 */       return true;
/*      */     } 
/* 6866 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ArmorStats get_armorstats(Configuration config, String s, int dura, int head, int chest, int leg, int boots, int enchant, int e_resp, int e_aqua, int e_prot, int e_fire, int e_blast, int e_proj, int e_unbreak, int e_feather) {
/* 6873 */     ArmorStats a = new ArmorStats();
/* 6874 */     String arm = "OreSpawnARMOR";
/*      */     
/* 6876 */     a.durability = config.get(arm, s + "_durability", dura).getInt();
/* 6877 */     if (a.durability < dura / 2) a.durability = dura / 2; 
/* 6878 */     if (a.durability > dura * 2) a.durability = dura * 2; 
/* 6879 */     a.head_protection = config.get(arm, s + "_head_damage_reduce", head).getInt();
/* 6880 */     if (a.head_protection < head - 2) a.head_protection = head - 2; 
/* 6881 */     a.chest_protection = config.get(arm, s + "_chest_damage_reduce", chest).getInt();
/* 6882 */     if (a.chest_protection < chest - 2) a.chest_protection = chest - 2; 
/* 6883 */     a.leg_protection = config.get(arm, s + "_leggings_damage_reduce", leg).getInt();
/* 6884 */     if (a.leg_protection < leg - 2) a.leg_protection = leg - 2; 
/* 6885 */     a.boot_protection = config.get(arm, s + "_boots_damage_reduce", boots).getInt();
/* 6886 */     if (a.boot_protection < boots - 2) a.boot_protection = boots - 2; 
/* 6887 */     a.enchantability = config.get(arm, s + "_enchantability", enchant).getInt();
/* 6888 */     if (a.enchantability < enchant / 2) a.enchantability = enchant / 2; 
/* 6889 */     if (a.enchantability > enchant * 2) a.enchantability = enchant * 2;
/*      */     
/* 6891 */     a.e_respiration = config.get(arm, s + "_enchant_respiration", e_resp).getInt();
/* 6892 */     if (a.e_respiration < e_resp / 2) a.e_respiration = e_resp / 2; 
/* 6893 */     a.e_aquaaffinity = config.get(arm, s + "_enchant_aquaaffinity", e_aqua).getInt();
/* 6894 */     if (a.e_aquaaffinity < e_aqua / 2) a.e_aquaaffinity = e_aqua / 2; 
/* 6895 */     a.e_protection = config.get(arm, s + "_enchant_protection", e_prot).getInt();
/* 6896 */     if (a.e_protection < e_prot / 2) a.e_protection = e_prot / 2; 
/* 6897 */     a.e_fireprotection = config.get(arm, s + "_enchant_fireprotection", e_fire).getInt();
/* 6898 */     if (a.e_fireprotection < e_fire / 2) a.e_fireprotection = e_fire / 2; 
/* 6899 */     a.e_blastprotection = config.get(arm, s + "_enchant_blastprotection", e_blast).getInt();
/* 6900 */     if (a.e_blastprotection < e_blast / 2) a.e_blastprotection = e_blast / 2; 
/* 6901 */     a.e_projectileprotection = config.get(arm, s + "_enchant_projectileprotection", e_proj).getInt();
/* 6902 */     if (a.e_projectileprotection < e_proj / 2) a.e_projectileprotection = e_proj / 2; 
/* 6903 */     a.e_unbreaking = config.get(arm, s + "_enchant_unbreaking", e_unbreak).getInt();
/* 6904 */     if (a.e_unbreaking < e_unbreak / 2) a.e_unbreaking = e_unbreak / 2; 
/* 6905 */     a.e_featherfalling = config.get(arm, s + "_enchant_featherfalling", e_feather).getInt();
/* 6906 */     if (a.e_featherfalling < e_feather / 2) a.e_featherfalling = e_feather / 2;
/*      */     
/* 6908 */     return a;
/*      */   }
/*      */ 
/*      */   
/*      */   private WeaponStats get_weaponstats(Configuration config, String arm, String s, int harvest, int maxuses, int efficiency, int damage, int enchantability) {
/* 6913 */     WeaponStats w = new WeaponStats();
/*      */     
/* 6915 */     w.harvestlevel = config.get(arm, s + "_harvestlevel", harvest).getInt();
/* 6916 */     if (w.harvestlevel < harvest - 1) w.harvestlevel = harvest; 
/* 6917 */     w.maxuses = config.get(arm, s + "_maxuses", maxuses).getInt();
/* 6918 */     if (w.maxuses < maxuses / 2) w.maxuses = maxuses / 2; 
/* 6919 */     if (w.maxuses > maxuses * 2) w.maxuses = maxuses * 2; 
/* 6920 */     w.efficiency = config.get(arm, s + "_efficiency", efficiency).getInt();
/* 6921 */     if (w.efficiency < efficiency / 2) w.efficiency = efficiency / 2; 
/* 6922 */     if (w.efficiency > efficiency * 2) w.efficiency = efficiency * 2; 
/* 6923 */     w.damage = config.get(arm, s + "_damage", damage).getInt();
/* 6924 */     if (w.damage < damage / 2) w.damage = damage / 2; 
/* 6925 */     if (w.damage > damage * 2) w.damage = damage * 2; 
/* 6926 */     w.enchantability = config.get(arm, s + "_enchantability", enchantability).getInt();
/* 6927 */     if (w.enchantability < enchantability / 2) w.enchantability = enchantability / 2; 
/* 6928 */     if (w.enchantability > enchantability * 2) w.enchantability = enchantability * 2;
/*      */     
/* 6930 */     return w;
/*      */   }
/*      */ 
/*      */   
/*      */   private MobStats get_mobstats(Configuration config, String arm, String s, int health, int attack, int defense) {
/* 6935 */     MobStats m = new MobStats();
/*      */     
/* 6937 */     m.health = config.get(arm, s + "_health", health).getInt();
/* 6938 */     if (m.health < health / 2) m.health = health / 2; 
/* 6939 */     if (m.health > health * 2) m.health = health * 2; 
/* 6940 */     m.attack = config.get(arm, s + "_attack", attack).getInt();
/* 6941 */     if (m.attack < attack / 2) m.attack = attack / 2; 
/* 6942 */     if (m.attack > attack * 2) m.attack = attack * 2; 
/* 6943 */     m.defense = config.get(arm, s + "_defense", defense).getInt();
/* 6944 */     if (m.defense < defense - 4) m.defense = defense - 4; 
/* 6945 */     if (m.defense > defense + 4) m.defense = defense + 4; 
/* 6946 */     if (m.defense > 22) m.defense = 22; 
/* 6947 */     if (m.defense < 0) m.defense = 0;
/*      */     
/* 6949 */     return m;
/*      */   }
/*      */ 
/*      */   
/*      */   private OreStats get_orestats(Configuration config, String arm, String s, int rate, int clumpsize, int min, int max) {
/* 6954 */     OreStats o = new OreStats();
/*      */     
/* 6956 */     o.rate = config.get(arm, s + "_rate", rate).getInt();
/* 6957 */     if (o.rate < rate / 2) o.rate = rate / 2; 
/* 6958 */     if (o.rate > rate * 2) o.rate = rate * 2; 
/* 6959 */     o.clumpsize = config.get(arm, s + "_clumpsize", clumpsize).getInt();
/* 6960 */     if (o.clumpsize < clumpsize / 2) o.clumpsize = clumpsize / 2; 
/* 6961 */     if (o.clumpsize > clumpsize * 2) o.clumpsize = clumpsize * 2; 
/* 6962 */     if (o.clumpsize < 1) o.clumpsize = 1; 
/* 6963 */     o.mindepth = config.get(arm, s + "_mindepth", min).getInt();
/* 6964 */     if (o.mindepth < 0) o.mindepth = 0; 
/* 6965 */     o.maxdepth = config.get(arm, s + "_maxdepth", max).getInt();
/* 6966 */     if (o.maxdepth < 0) o.maxdepth = 0; 
/* 6967 */     if (o.maxdepth - o.mindepth < 10) {
/* 6968 */       o.mindepth = min;
/* 6969 */       o.maxdepth = max;
/*      */     } 
/* 6971 */     return o;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void disableAllMobs() {
/* 6977 */     MosquitoEnable = 0;
/* 6978 */     GhostEnable = 0;
/* 6979 */     GhostSkellyEnable = 0;
/* 6980 */     SpiderDriverEnable = 0;
/* 6981 */     CrabEnable = 0;
/* 6982 */     JefferyEnable = 0;
/* 6983 */     MothraEnable = 0;
/* 6984 */     BrutalflyEnable = 0;
/* 6985 */     NastysaurusEnable = 0;
/* 6986 */     PointysaurusEnable = 0;
/* 6987 */     MothraPeaceful = 0;
/* 6988 */     BlackAntEnable = 0;
/* 6989 */     RedAntEnable = 0;
/* 6990 */     TermiteEnable = 0;
/* 6991 */     UnstableAntEnable = 0;
/* 6992 */     RainbowAntEnable = 0;
/* 6993 */     AlosaurusEnable = 0;
/* 6994 */     HammerheadEnable = 0;
/* 6995 */     LeonEnable = 0;
/* 6996 */     CaterKillerEnable = 0;
/* 6997 */     MolenoidEnable = 0;
/* 6998 */     TRexEnable = 0;
/* 6999 */     CriminalEnable = 0;
/* 7000 */     CryolophosaurusEnable = 0;
/* 7001 */     RatEnable = 0;
/* 7002 */     UrchinEnable = 0;
/* 7003 */     CamarasaurusEnable = 0;
/* 7004 */     VelocityRaptorEnable = 0;
/* 7005 */     HydroliscEnable = 0;
/* 7006 */     SpyroEnable = 0;
/* 7007 */     BaryonyxEnable = 0;
/* 7008 */     CockateilEnable = 0;
/* 7009 */     CassowaryEnable = 0;
/* 7010 */     EasterBunnyEnable = 0;
/* 7011 */     PeacockEnable = 0;
/* 7012 */     KyuubiEnable = 0;
/* 7013 */     CephadromeEnable = 0;
/* 7014 */     DragonEnable = 0;
/* 7015 */     GammaMetroidEnable = 0;
/* 7016 */     BasiliskEnable = 0;
/* 7017 */     DragonflyEnable = 0;
/* 7018 */     EmperorScorpionEnable = 0;
/* 7019 */     TrooperBugEnable = 0;
/* 7020 */     SpitBugEnable = 0;
/* 7021 */     StinkBugEnable = 0;
/* 7022 */     ScorpionEnable = 0;
/* 7023 */     CaveFisherEnable = 0;
/* 7024 */     AlienEnable = 0;
/* 7025 */     WaterDragonEnable = 0;
/* 7026 */     SeaMonsterEnable = 0;
/* 7027 */     SeaViperEnable = 0;
/* 7028 */     AttackSquidEnable = 0;
/* 7029 */     Robot1Enable = 0;
/* 7030 */     Robot2Enable = 0;
/* 7031 */     Robot3Enable = 0;
/* 7032 */     Robot4Enable = 0;
/* 7033 */     Robot5Enable = 0;
/* 7034 */     RotatorEnable = 0;
/* 7035 */     VortexEnable = 0;
/* 7036 */     DungeonBeastEnable = 0;
/* 7037 */     KrakenEnable = 0;
/* 7038 */     LizardEnable = 0;
/* 7039 */     RubberDuckyEnable = 0;
/* 7040 */     GirlfriendEnable = 0;
/* 7041 */     BoyfriendEnable = 0;
/* 7042 */     FireflyEnable = 0;
/* 7043 */     FairyEnable = 0;
/* 7044 */     BeeEnable = 0;
/* 7045 */     TheKingEnable = 0;
/* 7046 */     TheQueenEnable = 0;
/* 7047 */     MantisEnable = 0;
/* 7048 */     StinkyEnable = 0;
/* 7049 */     HerculesBeetleEnable = 0;
/* 7050 */     ChipmunkEnable = 0;
/* 7051 */     OstrichEnable = 0;
/* 7052 */     GazelleEnable = 0;
/* 7053 */     CowEnable = 0;
/* 7054 */     ButterflyEnable = 0;
/* 7055 */     MothEnable = 0;
/* 7056 */     TshirtEnable = 0;
/* 7057 */     CoinEnable = 0;
/* 7058 */     CreepingHorrorEnable = 0;
/* 7059 */     TerribleTerrorEnable = 0;
/* 7060 */     CliffRacerEnable = 0;
/* 7061 */     TriffidEnable = 0;
/* 7062 */     WormEnable = 0;
/* 7063 */     CloudSharkEnable = 0;
/* 7064 */     GoldFishEnable = 0;
/* 7065 */     LeafMonsterEnable = 0;
/* 7066 */     EnderKnightEnable = 0;
/* 7067 */     EnderReaperEnable = 0;
/* 7068 */     BeaverEnable = 0;
/* 7069 */     IrukandjiEnable = 0;
/* 7070 */     SkateEnable = 0;
/* 7071 */     WhaleEnable = 0;
/* 7072 */     FlounderEnable = 0;
/* 7073 */     PitchBlackEnable = 0;
/* 7074 */     LurkingTerrorEnable = 0;
/* 7075 */     GodzillaEnable = 0;
/* 7076 */     CrabEnable = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void laySomeEggs() {
/* 7082 */     MySpiderSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 0)).setBlockName("orespider");
/* 7083 */     MyBatSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 1)).setBlockName("orebat");
/* 7084 */     MyCowSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 2)).setBlockName("orecow");
/* 7085 */     MyPigSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 3)).setBlockName("orepig");
/* 7086 */     MySquidSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 4)).setBlockName("oresquid");
/* 7087 */     MyChickenSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 5)).setBlockName("orechicken");
/* 7088 */     MyCreeperSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 6)).setBlockName("orecreeper");
/* 7089 */     MySkeletonSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 7)).setBlockName("oreskeleton");
/* 7090 */     MyZombieSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 8)).setBlockName("orezombie");
/* 7091 */     MySlimeSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 9)).setBlockName("oreslime");
/* 7092 */     MyGhastSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 10)).setBlockName("oreghast");
/* 7093 */     MyZombiePigmanSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 11)).setBlockName("orezombiepigman");
/* 7094 */     MyEndermanSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 12)).setBlockName("oreenderman");
/* 7095 */     MyCaveSpiderSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 13)).setBlockName("orecavespider");
/* 7096 */     MySilverfishSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 14)).setBlockName("oresilverfish");
/* 7097 */     MyMagmaCubeSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 15)).setBlockName("oremagmacube");
/* 7098 */     MyWitchSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 16)).setBlockName("orewitch");
/* 7099 */     MySheepSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 17)).setBlockName("oresheep");
/* 7100 */     MyWolfSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 18)).setBlockName("orewolf");
/* 7101 */     MyMooshroomSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 19)).setBlockName("oremooshroom");
/* 7102 */     MyOcelotSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 20)).setBlockName("oreocelot");
/* 7103 */     MyBlazeSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 21)).setBlockName("oreblaze");
/* 7104 */     MyWitherSkeletonSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 22)).setBlockName("orewitherskeleton");
/* 7105 */     MyEnderDragonSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 23)).setBlockName("oreenderdragon");
/* 7106 */     MySnowGolemSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 24)).setBlockName("oresnowgolem");
/* 7107 */     MyIronGolemSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 25)).setBlockName("oreirongolem");
/* 7108 */     MyWitherBossSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 26)).setBlockName("orewitherboss");
/* 7109 */     MyGirlfriendSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 27)).setBlockName("oregirlfriend");
/* 7110 */     MyBoyfriendSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 84)).setBlockName("oreboyfriend");
/* 7111 */     MyRedCowSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 28)).setBlockName("oreredcow");
/* 7112 */     MyCrystalCowSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 261)).setBlockName("orecrystalcow");
/* 7113 */     MyVillagerSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 94)).setBlockName("orevillager");
/* 7114 */     MyGoldCowSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 29)).setBlockName("oregoldcow");
/* 7115 */     MyEnchantedCowSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 30)).setBlockName("oreenchantedcow");
/* 7116 */     MyMOTHRASpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 31)).setBlockName("oreMOTHRA");
/* 7117 */     MyAntBlock = (new AntBlock(BaseBlockID + 115)).setBlockName("AntBlock");
/* 7118 */     MyRedAntBlock = (new AntBlock(BaseBlockID + 116)).setBlockName("RedAntBlock");
/* 7119 */     TermiteBlock = (new AntBlock(BaseBlockID + 120)).setBlockName("TermiteBlock");
/* 7120 */     CrystalTermiteBlock = (new CrystalAntBlock(BaseBlockID + 121)).setBlockName("CrystalTermiteBlock");
/* 7121 */     MyRainbowAntBlock = (new AntBlock(BaseBlockID + 117)).setBlockName("RainbowAntBlock");
/* 7122 */     MyUnstableAntBlock = (new AntBlock(BaseBlockID + 118)).setBlockName("UnstableAntBlock");
/* 7123 */     MyAloSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 32)).setBlockName("orealosaurus");
/* 7124 */     MyCryoSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 33)).setBlockName("orecryolophosaurus");
/* 7125 */     MyCamaSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 34)).setBlockName("orecamarasaurus");
/* 7126 */     MyVeloSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 35)).setBlockName("orevelocityraptor");
/* 7127 */     MyHydroSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 36)).setBlockName("orehydrolisc");
/* 7128 */     MyBasilSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 37)).setBlockName("orebasilisc");
/* 7129 */     MyDragonflySpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 38)).setBlockName("oredragonfly");
/* 7130 */     MyEmperorScorpionSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 39)).setBlockName("oreemperorscorpion");
/* 7131 */     MyScorpionSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 40)).setBlockName("orescorpion");
/* 7132 */     MyCaveFisherSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 41)).setBlockName("orecavefisher");
/* 7133 */     MySpyroSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 42)).setBlockName("orespyro");
/* 7134 */     MyBaryonyxSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 43)).setBlockName("orebaryonyx");
/* 7135 */     MyGammaMetroidSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 44)).setBlockName("oregammametroid");
/* 7136 */     MyCockateilSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 45)).setBlockName("orecockateil");
/* 7137 */     MyKyuubiSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 46)).setBlockName("orekyuubi");
/* 7138 */     MyAlienSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 47)).setBlockName("orealien");
/* 7139 */     MyAttackSquidSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 48)).setBlockName("oreattacksquid");
/* 7140 */     MyWaterDragonSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 49)).setBlockName("orewaterdragon");
/* 7141 */     MyCephadromeSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 52)).setBlockName("orecephadrome");
/* 7142 */     MyDragonSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 53)).setBlockName("oredragon");
/* 7143 */     MyKrakenSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 50)).setBlockName("orekraken");
/* 7144 */     MyLizardSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 51)).setBlockName("orelizard");
/* 7145 */     MyBeeSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 54)).setBlockName("orebee");
/* 7146 */     MyHorseSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 55)).setBlockName("orehorse");
/* 7147 */     MyTrooperBugSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 56)).setBlockName("oretrooper");
/* 7148 */     MySpitBugSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 57)).setBlockName("orespit");
/* 7149 */     MyStinkBugSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 58)).setBlockName("orestink");
/* 7150 */     MyOstrichSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 59)).setBlockName("oreostrich");
/* 7151 */     MyGazelleSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 60)).setBlockName("oregazelle");
/* 7152 */     MyChipmunkSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 61)).setBlockName("orechipmunk");
/* 7153 */     MyCreepingHorrorSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 62)).setBlockName("orecreepinghorror");
/* 7154 */     MyTerribleTerrorSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 63)).setBlockName("oreterribleterror");
/* 7155 */     MyCliffRacerSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 64)).setBlockName("orecliffracer");
/* 7156 */     MyTriffidSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 65)).setBlockName("oretriffid");
/* 7157 */     MyPitchBlackSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 66)).setBlockName("orenightmare");
/* 7158 */     MyLurkingTerrorSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 67)).setBlockName("orelurkingterror");
/* 7159 */     MyGodzillaPartSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 68)).setBlockName("oregodzillapart");
/* 7160 */     MyGodzillaSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 119)).setBlockName("oregodzilla");
/* 7161 */     MySmallWormSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 69)).setBlockName("oresmallworm");
/* 7162 */     MyMediumWormSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 70)).setBlockName("oremediumworm");
/* 7163 */     MyLargeWormSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 71)).setBlockName("orelargeworm");
/* 7164 */     MyCassowarySpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 72)).setBlockName("orecassowary");
/* 7165 */     MyCloudSharkSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 73)).setBlockName("orecloudshark");
/* 7166 */     MyGoldFishSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 74)).setBlockName("oregoldfish");
/* 7167 */     MyLeafMonsterSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 75)).setBlockName("oreleafmonster");
/* 7168 */     MyTshirtSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 76)).setBlockName("oretshirt");
/* 7169 */     MyEnderKnightSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 77)).setBlockName("oreenderknight");
/* 7170 */     MyEnderReaperSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 78)).setBlockName("oreenderreaper");
/* 7171 */     MyBeaverSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 79)).setBlockName("orebeaver");
/* 7172 */     MyUrchinSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 250)).setBlockName("oreurchin");
/* 7173 */     MyFlounderSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 251)).setBlockName("oreflounder");
/* 7174 */     MySkateSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 252)).setBlockName("oreskate");
/* 7175 */     MyRotatorSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 253)).setBlockName("orerotator");
/* 7176 */     MyPeacockSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 254)).setBlockName("orepeacock");
/* 7177 */     MyFairySpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 255)).setBlockName("orefairy");
/* 7178 */     MyDungeonBeastSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 256)).setBlockName("oredungeonbeast");
/* 7179 */     MyVortexSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 257)).setBlockName("orevortex");
/* 7180 */     MyRatSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 258)).setBlockName("orerat");
/* 7181 */     MyWhaleSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 259)).setBlockName("orewhale");
/* 7182 */     MyIrukandjiSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 260)).setBlockName("oreirukandji");
/* 7183 */     MyTRexSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 80)).setBlockName("oretrex");
/* 7184 */     MyHerculesSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 81)).setBlockName("orehercules");
/* 7185 */     MyMantisSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 82)).setBlockName("oremantis");
/* 7186 */     MyStinkySpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 83)).setBlockName("orestinky");
/* 7187 */     MyTheKingPartSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 85)).setBlockName("orethekingpart");
/* 7188 */     MyTheKingSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 122)).setBlockName("oretheking");
/* 7189 */     MyTheQueenPartSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 96)).setBlockName("orethequeenpart");
/* 7190 */     MyTheQueenSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 125)).setBlockName("orethequeen");
/* 7191 */     MyEasterBunnySpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 86)).setBlockName("oreeasterbunny");
/* 7192 */     MyCaterKillerSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 87)).setBlockName("orecaterkiller");
/* 7193 */     MyMolenoidSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 88)).setBlockName("oremolenoid");
/* 7194 */     MySeaMonsterSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 89)).setBlockName("oreseamonster");
/* 7195 */     MySeaViperSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 90)).setBlockName("oreseaviper");
/* 7196 */     MyLeonSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 91)).setBlockName("oreleon");
/* 7197 */     MyHammerheadSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 92)).setBlockName("orehammerhead");
/* 7198 */     MyRubberDuckySpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 93)).setBlockName("orerubberducky");
/* 7199 */     MyCriminalSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 95)).setBlockName("orecriminal");
/* 7200 */     MyBrutalflySpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 300)).setBlockName("orebrutalfly");
/* 7201 */     MyNastysaurusSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 301)).setBlockName("orenastysaurus");
/* 7202 */     MyPointysaurusSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 302)).setBlockName("orepointysaurus");
/* 7203 */     MyCricketSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 303)).setBlockName("orecricket");
/* 7204 */     MyFrogSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 304)).setBlockName("orefrog");
/* 7205 */     MySpiderDriverSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 305)).setBlockName("orespiderdriver");
/* 7206 */     MyCrabSpawnBlock = (OreGenericEgg)(new OreGenericEgg(BaseBlockID + 306)).setBlockName("orecrab");
/*      */   }
/*      */ 
/*      */   
/*      */   private void getMobs(Configuration config, String mobs) {
/* 7211 */     MosquitoEnable = config.get(mobs, "MosquitoEnable", 1).getInt();
/* 7212 */     RockEnable = config.get(mobs, "RockEnable", 1).getInt();
/* 7213 */     GhostEnable = config.get(mobs, "GhostEnable", 1).getInt();
/* 7214 */     GhostSkellyEnable = config.get(mobs, "GhostSkellyEnable", 1).getInt();
/* 7215 */     SpiderDriverEnable = config.get(mobs, "SpiderDriverEnable", 1).getInt();
/* 7216 */     JefferyEnable = config.get(mobs, "JefferyEnable", 1).getInt();
/* 7217 */     MothraEnable = config.get(mobs, "MothraEnable", 1).getInt();
/* 7218 */     BrutalflyEnable = config.get(mobs, "BrutalflyEnable", 1).getInt();
/* 7219 */     NastysaurusEnable = config.get(mobs, "NastysaurusEnable", 1).getInt();
/* 7220 */     PointysaurusEnable = config.get(mobs, "PointysaurusEnable", 1).getInt();
/* 7221 */     CricketEnable = config.get(mobs, "CricketEnable", 1).getInt();
/* 7222 */     FrogEnable = config.get(mobs, "FrogEnable", 1).getInt();
/* 7223 */     MothraPeaceful = config.get(mobs, "MothraPeaceful", 0).getInt();
/* 7224 */     BlackAntEnable = config.get(mobs, "BlackAntEnable", 1).getInt();
/* 7225 */     RedAntEnable = config.get(mobs, "RedAntEnable", 1).getInt();
/* 7226 */     TermiteEnable = config.get(mobs, "TermiteEnable", 1).getInt();
/* 7227 */     UnstableAntEnable = config.get(mobs, "UnstableAntEnable", 1).getInt();
/* 7228 */     RainbowAntEnable = config.get(mobs, "RainbowedAntEnable", 1).getInt();
/* 7229 */     AlosaurusEnable = config.get(mobs, "AlosaurusEnable", 1).getInt();
/* 7230 */     HammerheadEnable = config.get(mobs, "HammerheadEnable", 1).getInt();
/* 7231 */     LeonEnable = config.get(mobs, "LeonEnable", 1).getInt();
/* 7232 */     CaterKillerEnable = config.get(mobs, "CaterKillerEnable", 1).getInt();
/* 7233 */     MolenoidEnable = config.get(mobs, "MolenoidEnable", 1).getInt();
/* 7234 */     TRexEnable = config.get(mobs, "TRexEnable", 1).getInt();
/* 7235 */     CriminalEnable = config.get(mobs, "CriminalEnable", 1).getInt();
/* 7236 */     CryolophosaurusEnable = config.get(mobs, "CryolophosaurusEnable", 1).getInt();
/* 7237 */     RatEnable = config.get(mobs, "RatEnable", 1).getInt();
/* 7238 */     UrchinEnable = config.get(mobs, "UrchinEnable", 1).getInt();
/* 7239 */     CamarasaurusEnable = config.get(mobs, "CamarasaurusEnable", 1).getInt();
/* 7240 */     VelocityRaptorEnable = config.get(mobs, "VelocityRaptorEnable", 1).getInt();
/* 7241 */     HydroliscEnable = config.get(mobs, "HydroliscEnable", 1).getInt();
/* 7242 */     SpyroEnable = config.get(mobs, "SpyroEnable", 1).getInt();
/* 7243 */     BaryonyxEnable = config.get(mobs, "BaryonyxEnable", 1).getInt();
/* 7244 */     CockateilEnable = config.get(mobs, "BirdEnable", 1).getInt();
/* 7245 */     CassowaryEnable = config.get(mobs, "CassowaryEnable", 1).getInt();
/* 7246 */     EasterBunnyEnable = config.get(mobs, "EasterBunnyEnable", 1).getInt();
/* 7247 */     PeacockEnable = config.get(mobs, "PeacockEnable", 1).getInt();
/* 7248 */     KyuubiEnable = config.get(mobs, "KyuubiEnable", 1).getInt();
/* 7249 */     CephadromeEnable = config.get(mobs, "CephadromeEnable", 1).getInt();
/* 7250 */     DragonEnable = config.get(mobs, "DragonEnable", 1).getInt();
/* 7251 */     GammaMetroidEnable = config.get(mobs, "GammaMetroidEnable", 1).getInt();
/* 7252 */     BasiliskEnable = config.get(mobs, "BasiliskEnable", 1).getInt();
/* 7253 */     DragonflyEnable = config.get(mobs, "DragonflyEnable", 1).getInt();
/* 7254 */     EmperorScorpionEnable = config.get(mobs, "EmperorScorpionEnable", 1).getInt();
/* 7255 */     TrooperBugEnable = config.get(mobs, "TrooperBugEnable", 1).getInt();
/* 7256 */     SpitBugEnable = config.get(mobs, "SpitBugEnable", 1).getInt();
/* 7257 */     StinkBugEnable = config.get(mobs, "StinkBugEnable", 1).getInt();
/* 7258 */     ScorpionEnable = config.get(mobs, "ScorpionEnable", 1).getInt();
/* 7259 */     CaveFisherEnable = config.get(mobs, "CaveFisherEnable", 1).getInt();
/* 7260 */     AlienEnable = config.get(mobs, "AlienEnable", 1).getInt();
/* 7261 */     WaterDragonEnable = config.get(mobs, "WaterDragonEnable", 1).getInt();
/* 7262 */     SeaMonsterEnable = config.get(mobs, "SeaMonsterEnable", 1).getInt();
/* 7263 */     SeaViperEnable = config.get(mobs, "SeaViperEnable", 1).getInt();
/* 7264 */     AttackSquidEnable = config.get(mobs, "AttackSquidEnable", 1).getInt();
/* 7265 */     Robot1Enable = config.get(mobs, "Robot1Enable", 1).getInt();
/* 7266 */     Robot2Enable = config.get(mobs, "Robot2Enable", 1).getInt();
/* 7267 */     Robot3Enable = config.get(mobs, "Robot3Enable", 1).getInt();
/* 7268 */     Robot4Enable = config.get(mobs, "Robot4Enable", 1).getInt();
/* 7269 */     Robot5Enable = config.get(mobs, "Robot5Enable", 1).getInt();
/* 7270 */     RotatorEnable = config.get(mobs, "RotatorEnable", 1).getInt();
/* 7271 */     VortexEnable = config.get(mobs, "VortexEnable", 1).getInt();
/* 7272 */     DungeonBeastEnable = config.get(mobs, "DungeonBeastEnable", 1).getInt();
/* 7273 */     KrakenEnable = config.get(mobs, "KrakenEnable", 1).getInt();
/* 7274 */     LizardEnable = config.get(mobs, "LizardEnable", 1).getInt();
/* 7275 */     RubberDuckyEnable = config.get(mobs, "RubberDuckyEnable", 1).getInt();
/* 7276 */     GirlfriendEnable = config.get(mobs, "GirlfriendEnable", 1).getInt();
/* 7277 */     BoyfriendEnable = config.get(mobs, "BoyfriendEnable", 0).getInt();
/* 7278 */     FireflyEnable = config.get(mobs, "FireflyEnable", 1).getInt();
/* 7279 */     FairyEnable = config.get(mobs, "FairyEnable", 1).getInt();
/* 7280 */     BeeEnable = config.get(mobs, "BeeEnable", 1).getInt();
/* 7281 */     TheKingEnable = config.get(mobs, "TheKingEnable", 1).getInt();
/* 7282 */     TheQueenEnable = config.get(mobs, "TheQueenEnable", 1).getInt();
/* 7283 */     MantisEnable = config.get(mobs, "MantisEnable", 1).getInt();
/* 7284 */     StinkyEnable = config.get(mobs, "StinkyEnable", 1).getInt();
/* 7285 */     HerculesBeetleEnable = config.get(mobs, "HerculesBeetleEnable", 1).getInt();
/* 7286 */     ChipmunkEnable = config.get(mobs, "ChipmunkEnable", 1).getInt();
/* 7287 */     OstrichEnable = config.get(mobs, "OstrichEnable", 1).getInt();
/* 7288 */     GazelleEnable = config.get(mobs, "GazelleEnable", 1).getInt();
/* 7289 */     CowEnable = config.get(mobs, "CowEnable", 1).getInt();
/* 7290 */     ButterflyEnable = config.get(mobs, "ButterflyEnable", 1).getInt();
/* 7291 */     MothEnable = config.get(mobs, "MothEnable", 1).getInt();
/* 7292 */     TshirtEnable = config.get(mobs, "TshirtEnable", 1).getInt();
/* 7293 */     CoinEnable = config.get(mobs, "CoinEnable", 1).getInt();
/* 7294 */     CreepingHorrorEnable = config.get(mobs, "CreepingHorrorEnable", 1).getInt();
/* 7295 */     TerribleTerrorEnable = config.get(mobs, "TerribleTerrorEnable", 1).getInt();
/* 7296 */     CliffRacerEnable = config.get(mobs, "CliffRacerEnable", 1).getInt();
/* 7297 */     TriffidEnable = config.get(mobs, "TriffidEnable", 1).getInt();
/* 7298 */     WormEnable = config.get(mobs, "WormEnable", 1).getInt();
/* 7299 */     CloudSharkEnable = config.get(mobs, "CloudSharkEnable", 1).getInt();
/* 7300 */     GoldFishEnable = config.get(mobs, "GoldFishEnable", 1).getInt();
/* 7301 */     LeafMonsterEnable = config.get(mobs, "LeafMonsterEnable", 1).getInt();
/* 7302 */     EnderKnightEnable = config.get(mobs, "EnderKnightEnable", 1).getInt();
/* 7303 */     EnderReaperEnable = config.get(mobs, "EnderReaperEnable", 1).getInt();
/* 7304 */     BeaverEnable = config.get(mobs, "BeaverEnable", 1).getInt();
/* 7305 */     IrukandjiEnable = config.get(mobs, "IrukandjiEnable", 1).getInt();
/* 7306 */     SkateEnable = config.get(mobs, "SkateEnable", 1).getInt();
/* 7307 */     WhaleEnable = config.get(mobs, "WhaleEnable", 1).getInt();
/* 7308 */     FlounderEnable = config.get(mobs, "FlounderEnable", 1).getInt();
/* 7309 */     PitchBlackEnable = config.get(mobs, "NightmareEnable", 1).getInt();
/* 7310 */     LurkingTerrorEnable = config.get(mobs, "LurkingTerrorEnable", 1).getInt();
/* 7311 */     GodzillaEnable = config.get(mobs, "GodzillaEnable", 1).getInt();
/* 7312 */     CrabEnable = config.get(mobs, "CrabEnable", 1).getInt();
/*      */     
/* 7314 */     Bee_stats = get_mobstats(config, mobs, "Bee", 80, 12, 5);
/* 7315 */     Mantis_stats = get_mobstats(config, mobs, "Mantis", 120, 16, 10);
/* 7316 */     HerculesBeetle_stats = get_mobstats(config, mobs, "HerculesBeetle", 250, 30, 19);
/* 7317 */     Mothra_stats = get_mobstats(config, mobs, "Mothra", 150, 12, 8);
/* 7318 */     Brutalfly_stats = get_mobstats(config, mobs, "Brutalfly", 110, 10, 6);
/* 7319 */     Nastysaurus_stats = get_mobstats(config, mobs, "Nastysaurus", 200, 32, 17);
/* 7320 */     Pointysaurus_stats = get_mobstats(config, mobs, "Pointysaurus", 80, 10, 16);
/* 7321 */     Alosaurus_stats = get_mobstats(config, mobs, "Alosaurus", 110, 18, 8);
/* 7322 */     SpiderRobot_stats = get_mobstats(config, mobs, "SpiderRobot", 1500, 100, 16);
/* 7323 */     AntRobot_stats = get_mobstats(config, mobs, "AntRobot", 300, 30, 16);
/* 7324 */     Jeffery_stats = get_mobstats(config, mobs, "Jeffery", 550, 40, 18);
/* 7325 */     Hammerhead_stats = get_mobstats(config, mobs, "Hammerhead", 240, 75, 20);
/* 7326 */     Molenoid_stats = get_mobstats(config, mobs, "Molenoid", 200, 18, 12);
/* 7327 */     TRex_stats = get_mobstats(config, mobs, "TRex", 160, 22, 14);
/* 7328 */     BandP_stats = get_mobstats(config, mobs, "BandP", 100, 1, 18);
/* 7329 */     CaterKiller_stats = get_mobstats(config, mobs, "CaterKiller", 450, 32, 19);
/* 7330 */     Cryolophosaurus_stats = get_mobstats(config, mobs, "Cryolophosaurus", 10, 3, 1);
/* 7331 */     Rat_stats = get_mobstats(config, mobs, "Rat", 5, 3, 1);
/* 7332 */     Urchin_stats = get_mobstats(config, mobs, "Urchin", 25, 10, 4);
/* 7333 */     Kyuubi_stats = get_mobstats(config, mobs, "Kyuubi", 125, 10, 10);
/* 7334 */     GammaMetroid_stats = get_mobstats(config, mobs, "GammaMetroid", 100, 10, 12);
/* 7335 */     Basilisk_stats = get_mobstats(config, mobs, "Basilisk", 200, 24, 15);
/* 7336 */     EmperorScorpion_stats = get_mobstats(config, mobs, "EmperorScorpion", 350, 35, 20);
/* 7337 */     TrooperBug_stats = get_mobstats(config, mobs, "TrooperBug", 200, 20, 15);
/* 7338 */     SpitBug_stats = get_mobstats(config, mobs, "SpitBug", 100, 10, 12);
/* 7339 */     Alien_stats = get_mobstats(config, mobs, "Alien", 100, 12, 8);
/* 7340 */     WaterDragon_stats = get_mobstats(config, mobs, "WaterDragon", 150, 20, 8);
/* 7341 */     SeaMonster_stats = get_mobstats(config, mobs, "SeaMonster", 110, 14, 8);
/* 7342 */     SeaViper_stats = get_mobstats(config, mobs, "SeaViper", 160, 22, 12);
/* 7343 */     Robot2_stats = get_mobstats(config, mobs, "Robot2", 200, 22, 18);
/* 7344 */     Robot3_stats = get_mobstats(config, mobs, "Robot3", 80, 16, 14);
/* 7345 */     Robot4_stats = get_mobstats(config, mobs, "Robot4", 170, 12, 18);
/* 7346 */     Robot5_stats = get_mobstats(config, mobs, "Robot5", 20, 5, 6);
/* 7347 */     Rotator_stats = get_mobstats(config, mobs, "Rotator", 35, 10, 8);
/* 7348 */     Vortex_stats = get_mobstats(config, mobs, "Vortex", 150, 26, 10);
/* 7349 */     DungeonBeast_stats = get_mobstats(config, mobs, "DungeonBeast", 65, 12, 6);
/* 7350 */     Triffid_stats = get_mobstats(config, mobs, "Triffid", 100, 20, 12);
/* 7351 */     LurkingTerror_stats = get_mobstats(config, mobs, "LurkingTerror", 30, 6, 5);
/* 7352 */     WormSmall_stats = get_mobstats(config, mobs, "WormSmall", 10, 3, 0);
/* 7353 */     WormMedium_stats = get_mobstats(config, mobs, "WormMedium", 30, 10, 8);
/* 7354 */     WormLarge_stats = get_mobstats(config, mobs, "WormLarge", 90, 18, 14);
/* 7355 */     EnderKnight_stats = get_mobstats(config, mobs, "EnderKnight", 60, 12, 6);
/* 7356 */     EnderReaper_stats = get_mobstats(config, mobs, "EnderReaper", 90, 18, 8);
/* 7357 */     Irukandji_stats = get_mobstats(config, mobs, "Irukandji", 1, 20, 0);
/* 7358 */     AttackSquid_stats = get_mobstats(config, mobs, "AttackSquid", 10, 8, 0);
/* 7359 */     CaveFisher_stats = get_mobstats(config, mobs, "CaveFisher", 10, 4, 4);
/* 7360 */     CloudShark_stats = get_mobstats(config, mobs, "CloudShark", 15, 6, 5);
/* 7361 */     CreepingHorror_stats = get_mobstats(config, mobs, "CreepingHorror", 10, 3, 2);
/* 7362 */     Godzilla_stats = get_mobstats(config, mobs, "Mobzilla", 4000, 175, 21);
/* 7363 */     Kraken_stats = get_mobstats(config, mobs, "Kraken", 1000, 40, 10);
/* 7364 */     LeafMonster_stats = get_mobstats(config, mobs, "LeafMonster", 6, 2, 1);
/* 7365 */     PitchBlack_stats = get_mobstats(config, mobs, "Nightmare", 250, 30, 10);
/* 7366 */     Scorpion_stats = get_mobstats(config, mobs, "Scorpion", 15, 4, 10);
/* 7367 */     Skate_stats = get_mobstats(config, mobs, "Skate", 8, 8, 4);
/* 7368 */     TerribleTerror_stats = get_mobstats(config, mobs, "TerribleTerror", 10, 5, 3);
/* 7369 */     TheKing_stats = get_mobstats(config, mobs, "TheKing", 7000, 350, 21);
/* 7370 */     TheQueen_stats = get_mobstats(config, mobs, "TheQueen", 6000, 225, 21);
/* 7371 */     Leon_stats = get_mobstats(config, mobs, "Leonopteryx", 150, 20, 8);
/* 7372 */     Crab_stats = get_mobstats(config, mobs, "Crab", 180, 24, 16);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getVersion() {
/* 7379 */     return "1.7.10.20.3";
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\OreSpawnMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */