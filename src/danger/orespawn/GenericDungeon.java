/*      */ package danger.orespawn;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.BlockBush;
/*      */ import net.minecraft.block.BlockDeadBush;
/*      */ import net.minecraft.block.BlockFlower;
/*      */ import net.minecraft.block.BlockGrass;
/*      */ import net.minecraft.block.BlockLeaves;
/*      */ import net.minecraft.block.BlockSand;
/*      */ import net.minecraft.block.BlockSlab;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityList;
/*      */ import net.minecraft.entity.item.EntityEnderCrystal;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.inventory.IInventory;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemDoor;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.tileentity.TileEntity;
/*      */ import net.minecraft.tileentity.TileEntityChest;
/*      */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*      */ import net.minecraft.util.WeightedRandomChestContent;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ public class GenericDungeon {
/*   26 */   private final WeightedRandomChestContent[] RainbowContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(OreSpawnMain.MagicApple, 0, 1, 1, 25), new WeightedRandomChestContent(OreSpawnMain.CloudSharkEgg, 0, 4, 10, 25), new WeightedRandomChestContent(Items.bone, 0, 2, 16, 25), new WeightedRandomChestContent(Items.string, 0, 2, 16, 25), new WeightedRandomChestContent(Items.rotten_flesh, 0, 3, 10, 25), new WeightedRandomChestContent(Items.experience_bottle, 0, 4, 10, 25) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   35 */   private final WeightedRandomChestContent[] WhiteHouseContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(OreSpawnMain.MyCornDog, 0, 6, 12, 35), new WeightedRandomChestContent(OreSpawnMain.UraniumNugget, 0, 2, 6, 10), new WeightedRandomChestContent(OreSpawnMain.TitaniumNugget, 0, 2, 6, 10), new WeightedRandomChestContent(OreSpawnMain.MyAmethyst, 0, 2, 6, 35), new WeightedRandomChestContent(OreSpawnMain.MyRuby, 0, 2, 6, 25), new WeightedRandomChestContent(OreSpawnMain.CriminalEgg, 0, 4, 10, 35), new WeightedRandomChestContent(Items.emerald, 0, 6, 16, 35), new WeightedRandomChestContent(Items.porkchop, 0, 6, 16, 35), new WeightedRandomChestContent(Items.cooked_porkchop, 0, 6, 16, 35), new WeightedRandomChestContent(Items.diamond, 0, 6, 16, 35), new WeightedRandomChestContent(Items.gold_ingot, 0, 6, 16, 35) };
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
/*   49 */   private final WeightedRandomChestContent[] RubberDuckyContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(OreSpawnMain.MyDeadStinkBug, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyFireFish, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MySunFish, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MySparkFish, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyGreenFish, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyBlueFish, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyPinkFish, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyRockFish, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyWoodFish, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyGreyFish, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.RubberDuckyEgg, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyPeacockFeather, 0, 4, 10, 35), new WeightedRandomChestContent(Items.feather, 0, 6, 16, 35) };
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
/*   66 */   private final WeightedRandomChestContent[] StinkyHouseContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(OreSpawnMain.MyDeadStinkBug, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.StinkyEgg, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.StinkBugEgg, 0, 4, 10, 35), new WeightedRandomChestContent(Items.bone, 0, 6, 16, 25), new WeightedRandomChestContent(Items.coal, 0, 6, 16, 25), new WeightedRandomChestContent(Items.string, 0, 6, 16, 25), new WeightedRandomChestContent(Items.rotten_flesh, 0, 3, 10, 35) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   76 */   private final WeightedRandomChestContent[] NightmareRookeryContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(OreSpawnMain.MyDeadStinkBug, 0, 4, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyFlowerBlackBlock), 0, 4, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyFlowerScaryBlock), 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.PitchBlackEgg, 0, 4, 10, 25), new WeightedRandomChestContent(OreSpawnMain.AntRobotKit, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.SpiderRobotKit, 0, 1, 1, 10), new WeightedRandomChestContent(Items.bone, 0, 6, 16, 25), new WeightedRandomChestContent(Items.string, 0, 6, 16, 25), new WeightedRandomChestContent(Items.rotten_flesh, 0, 3, 10, 35), new WeightedRandomChestContent(Items.experience_bottle, 0, 4, 10, 35) };
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
/*   89 */   private final WeightedRandomChestContent[] MonsterIslandContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CreeperRepellent), 0, 4, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.KrakenRepellent), 0, 4, 10, 35), new WeightedRandomChestContent(Items.dye, 0, 6, 16, 25), new WeightedRandomChestContent(Items.bone, 0, 6, 16, 25), new WeightedRandomChestContent(Items.string, 0, 6, 16, 25), new WeightedRandomChestContent(Items.porkchop, 0, 3, 10, 35), new WeightedRandomChestContent(Items.beef, 0, 3, 10, 35), new WeightedRandomChestContent(Items.chicken, 0, 3, 10, 35), new WeightedRandomChestContent(Items.fish, 0, 3, 10, 35), new WeightedRandomChestContent(Items.rotten_flesh, 0, 3, 10, 35), new WeightedRandomChestContent(Items.experience_bottle, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyRawBacon, 0, 6, 16, 35), new WeightedRandomChestContent(OreSpawnMain.MyRawPeacock, 0, 6, 16, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.log), 0, 6, 16, 25) };
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
/*  106 */   private final WeightedRandomChestContent[] GreenhouseContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(OreSpawnMain.GreenGoo, 0, 4, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CreeperRepellent), 0, 4, 10, 35), new WeightedRandomChestContent(Items.flower_pot, 0, 6, 16, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.sapling), 0, 6, 16, 35), new WeightedRandomChestContent(Item.getItemFromBlock((Block)Blocks.leaves), 0, 6, 16, 25), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.dirt), 0, 6, 16, 25), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.log), 0, 6, 16, 25) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  116 */   private final WeightedRandomChestContent[] CrystalBattleTowerRatContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.cooked_porkchop, 0, 3, 10, 35), new WeightedRandomChestContent(Items.beef, 0, 3, 10, 35), new WeightedRandomChestContent(Items.cooked_chicken, 0, 3, 10, 35), new WeightedRandomChestContent(Items.cooked_fished, 0, 3, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyBLT, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MySalad, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyCornDog, 0, 4, 10, 35) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  125 */   private final WeightedRandomChestContent[] CrystalBattleTowerDungeonBeastContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.dye, 0, 6, 16, 25), new WeightedRandomChestContent(OreSpawnMain.MySquidZooka, 0, 1, 1, 25), new WeightedRandomChestContent(Items.gold_nugget, 0, 5, 15, 15), new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  131 */   private final WeightedRandomChestContent[] CrystalBattleTowerUrchinContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkHelmet, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkBody, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkLegs, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkBoots, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyFairySword, 0, 1, 1, 15) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  138 */   private final WeightedRandomChestContent[] CrystalBattleTowerRotatorContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeHelmet, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeBody, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeLegs, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeBoots, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyRatSword, 0, 1, 1, 15) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  145 */   private final WeightedRandomChestContent[] CrystalBattleTowerVortexContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalCoal), 0, 6, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalCoal), 0, 6, 10, 10), new WeightedRandomChestContent(OreSpawnMain.MyTigersEyeSword, 0, 1, 1, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyTigersEyeBlock), 0, 4, 8, 15), new WeightedRandomChestContent(OreSpawnMain.MyPoisonSword, 0, 1, 1, 15) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  155 */   private final WeightedRandomChestContent[] RobotContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.redstone, 0, 1, 10, 35), new WeightedRandomChestContent(Items.repeater, 0, 1, 10, 35), new WeightedRandomChestContent(Items.minecart, 0, 1, 1, 35), new WeightedRandomChestContent(Items.fire_charge, 0, 1, 10, 35), new WeightedRandomChestContent(Items.hopper_minecart, 0, 1, 1, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.redstone_block), 0, 1, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.rail), 0, 1, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.detector_rail), 0, 1, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock((Block)Blocks.sticky_piston), 0, 1, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock((Block)Blocks.piston), 0, 1, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.redstone_torch), 0, 1, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.tnt), 0, 1, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.rail), 0, 1, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.lever), 0, 1, 10, 35), new WeightedRandomChestContent(OreSpawnMain.AntRobotKit, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.SpiderRobotKit, 0, 1, 1, 10), new WeightedRandomChestContent(Items.iron_door, 0, 1, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.redstone_torch), 0, 1, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.wooden_button), 0, 1, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.iron_bars), 0, 1, 10, 35), new WeightedRandomChestContent(Items.comparator, 0, 1, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.activator_rail), 0, 1, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyRayGun, 0, 1, 1, 35) };
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
/*  182 */   private final WeightedRandomChestContent[] IncaPyramidContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.golden_sword, 0, 1, 1, 35), new WeightedRandomChestContent((Item)Items.golden_boots, 0, 1, 1, 35), new WeightedRandomChestContent((Item)Items.golden_leggings, 0, 1, 1, 35), new WeightedRandomChestContent((Item)Items.golden_helmet, 0, 1, 1, 35), new WeightedRandomChestContent((Item)Items.golden_chestplate, 0, 1, 1, 35), new WeightedRandomChestContent(Item.getItemFromBlock((Block)Blocks.yellow_flower), 0, 3, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock((Block)Blocks.red_flower), 0, 3, 10, 35), new WeightedRandomChestContent(Items.gold_nugget, 0, 3, 10, 35), new WeightedRandomChestContent(Items.gold_ingot, 0, 3, 10, 35), new WeightedRandomChestContent(Items.experience_bottle, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyCornCob, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyExperienceCatcher, 0, 4, 10, 25), new WeightedRandomChestContent(Items.bone, 0, 4, 10, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.gold_block), 0, 4, 10, 35) };
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
/*  199 */   private final WeightedRandomChestContent[] DamselContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 35), new WeightedRandomChestContent(Items.iron_sword, 0, 1, 1, 35), new WeightedRandomChestContent(Items.cooked_porkchop, 0, 3, 10, 35), new WeightedRandomChestContent(Items.beef, 0, 3, 10, 35), new WeightedRandomChestContent(Items.cooked_chicken, 0, 3, 10, 35), new WeightedRandomChestContent(Items.cooked_fished, 0, 3, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyBLT, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MySalad, 0, 4, 10, 35), new WeightedRandomChestContent(OreSpawnMain.MyCornDog, 0, 4, 10, 35) };
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
/*  211 */   private final WeightedRandomChestContent[] EnderCastleContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.ender_chest), 0, 2, 4, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.diamond_block), 0, 2, 4, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.dragon_egg), 0, 1, 1, 35), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyEnderPearlBlock), 0, 3, 6, 35), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyEyeOfEnderBlock), 0, 3, 6, 35), new WeightedRandomChestContent(OreSpawnMain.MyExperienceCatcher, 0, 4, 10, 25), new WeightedRandomChestContent(Items.ender_pearl, 0, 2, 4, 35), new WeightedRandomChestContent(Items.ender_eye, 0, 2, 4, 35) };
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
/*  222 */   private final WeightedRandomChestContent[] BouncyContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 35), new WeightedRandomChestContent(Items.fish, 0, 6, 16, 25), new WeightedRandomChestContent(Items.bone, 0, 6, 16, 25), new WeightedRandomChestContent(Items.string, 0, 6, 16, 25), new WeightedRandomChestContent(Item.getItemFromBlock((Block)Blocks.red_flower), 0, 6, 16, 25), new WeightedRandomChestContent(Item.getItemFromBlock((Block)Blocks.yellow_flower), 0, 6, 16, 25), new WeightedRandomChestContent(Items.ender_pearl, 0, 2, 4, 20) };
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
/*  233 */   private final WeightedRandomChestContent[] SpitBugContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 35), new WeightedRandomChestContent(Items.fish, 0, 6, 16, 25), new WeightedRandomChestContent(Items.bone, 0, 6, 16, 25), new WeightedRandomChestContent(Items.string, 0, 6, 16, 25), new WeightedRandomChestContent(OreSpawnMain.MyAmethystPickaxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystShovel, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystHoe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystAxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystSword, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystBoots, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.InstantGarden, 0, 2, 4, 25), new WeightedRandomChestContent(OreSpawnMain.InstantShelter, 0, 2, 4, 25) };
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
/*  251 */   private final WeightedRandomChestContent[] GraveContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.ender_eye, 0, 6, 16, 35), new WeightedRandomChestContent(Item.getItemFromBlock((Block)Blocks.red_flower), 0, 6, 16, 35), new WeightedRandomChestContent(Item.getItemFromBlock((Block)Blocks.yellow_flower), 0, 6, 16, 35), new WeightedRandomChestContent(Items.ender_pearl, 0, 6, 16, 35) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  258 */   private final WeightedRandomChestContent[] HospitalContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.ender_chest), 0, 2, 4, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.diamond_block), 0, 2, 4, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.dragon_egg), 0, 1, 1, 35), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyEnderPearlBlock), 0, 3, 6, 35), new WeightedRandomChestContent(Items.ender_pearl, 0, 2, 4, 35), new WeightedRandomChestContent(Items.ender_eye, 0, 2, 4, 35) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  267 */   private final WeightedRandomChestContent[] MiniContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.golden_apple, 0, 6, 16, 35), new WeightedRandomChestContent(OreSpawnMain.MyCrystalApple, 0, 6, 16, 35), new WeightedRandomChestContent(OreSpawnMain.MyBacon, 0, 6, 16, 35), new WeightedRandomChestContent(OreSpawnMain.MyFireFish, 0, 6, 16, 35), new WeightedRandomChestContent(OreSpawnMain.InstantGarden, 0, 2, 4, 25), new WeightedRandomChestContent(OreSpawnMain.InstantShelter, 0, 2, 4, 25) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  276 */   private final WeightedRandomChestContent[] LeafMonsterContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.flower_pot, 0, 6, 16, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.sapling), 0, 6, 16, 35), new WeightedRandomChestContent(Items.flower_pot, 0, 6, 16, 35), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.sapling), 0, 6, 16, 35), new WeightedRandomChestContent(Item.getItemFromBlock((Block)Blocks.leaves), 0, 6, 16, 25), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.dirt), 0, 6, 16, 25), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.log), 0, 6, 16, 25), new WeightedRandomChestContent(OreSpawnMain.MyPoisonSword, 0, 1, 1, 15), new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25) };
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
/*  288 */   private final WeightedRandomChestContent[] CloudSharkContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.fish, 0, 6, 16, 25), new WeightedRandomChestContent(Items.bone, 0, 6, 16, 25), new WeightedRandomChestContent(Items.string, 0, 6, 16, 25), new WeightedRandomChestContent(Items.paper, 0, 6, 16, 25), new WeightedRandomChestContent(OreSpawnMain.MyExperienceTreeSeed, 0, 1, 2, 15), new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  297 */   private final WeightedRandomChestContent[] WaterDragonContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.fish, 0, 6, 16, 25), new WeightedRandomChestContent(OreSpawnMain.MyUltimateAxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyUltimatePickaxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyUltimateShovel, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyExperienceCatcher, 0, 4, 10, 25), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.iron_block), 0, 6, 16, 25), new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  307 */   private final WeightedRandomChestContent[] SquidContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.dye, 0, 6, 16, 25), new WeightedRandomChestContent(OreSpawnMain.MySquidZooka, 0, 1, 1, 15), new WeightedRandomChestContent(Items.gold_nugget, 0, 5, 15, 15), new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  314 */   private final WeightedRandomChestContent[] KnightContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.paper, 0, 2, 8, 20), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.planks), 0, 4, 8, 20), new WeightedRandomChestContent(Items.ender_eye, 0, 2, 8, 15), new WeightedRandomChestContent(Items.ender_pearl, 0, 2, 8, 15), new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  322 */   private final WeightedRandomChestContent[] AlienWTFContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.diamond_block), 0, 1, 2, 15), new WeightedRandomChestContent(OreSpawnMain.MyRuby, 0, 1, 1, 20), new WeightedRandomChestContent(OreSpawnMain.MyAmethyst, 0, 1, 1, 20), new WeightedRandomChestContent(OreSpawnMain.MyIngotUranium, 0, 1, 2, 5), new WeightedRandomChestContent(OreSpawnMain.MyIngotTitanium, 0, 1, 2, 5), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateHelmet, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateBody, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateLegs, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.UltimateBoots, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyUltimateBow, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyNightmareSword, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyExperienceCatcher, 0, 4, 10, 15), new WeightedRandomChestContent(OreSpawnMain.MyRayGun, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.CageEmpty, 0, 1, 10, 20), new WeightedRandomChestContent(OreSpawnMain.MyCornDog, 0, 1, 10, 20), new WeightedRandomChestContent(OreSpawnMain.MyBacon, 0, 1, 5, 20), new WeightedRandomChestContent(OreSpawnMain.MyPopcornBag, 0, 2, 8, 20), new WeightedRandomChestContent(OreSpawnMain.MyFireFish, 0, 2, 8, 15) };
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
/*  343 */   private final WeightedRandomChestContent[] shadowContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.glowstone_dust, 0, 2, 8, 20), new WeightedRandomChestContent(Items.nether_wart, 0, 4, 8, 20), new WeightedRandomChestContent(Items.blaze_rod, 0, 2, 8, 15), new WeightedRandomChestContent(Items.blaze_powder, 0, 2, 8, 15), new WeightedRandomChestContent(Items.fire_charge, 0, 4, 8, 15), new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25), new WeightedRandomChestContent(Items.dye, 0, 6, 16, 25), new WeightedRandomChestContent(OreSpawnMain.MyRuby, 0, 2, 8, 15), new WeightedRandomChestContent(OreSpawnMain.MyExperienceTreeSeed, 0, 2, 4, 15), new WeightedRandomChestContent(OreSpawnMain.MyElevator, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyNightmareSword, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyPoisonSword, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyRatSword, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyRubySword, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyBigHammer, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MySquidZooka, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyIngotTitanium, 0, 1, 1, 5), new WeightedRandomChestContent(OreSpawnMain.MyIngotUranium, 0, 1, 1, 5), new WeightedRandomChestContent(OreSpawnMain.MyUltimateSword, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyUltimateBow, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.EnderReaperEgg, 0, 2, 8, 15), new WeightedRandomChestContent(OreSpawnMain.PitchBlackEgg, 0, 2, 8, 15) };
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
/*  368 */   private final WeightedRandomChestContent[] kyuubiContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.redstone, 0, 2, 8, 10), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.redstone_block), 0, 4, 8, 15), new WeightedRandomChestContent(Items.quartz, 0, 2, 8, 15), new WeightedRandomChestContent(Items.coal, 0, 2, 8, 15), new WeightedRandomChestContent(OreSpawnMain.MyNightmareSword, 0, 1, 1, 20), new WeightedRandomChestContent(OreSpawnMain.MyPoisonSword, 0, 1, 1, 20), new WeightedRandomChestContent(OreSpawnMain.KyuubiEgg, 0, 2, 8, 15) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  378 */   private final WeightedRandomChestContent[] blazeContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.blaze_rod, 0, 2, 8, 15), new WeightedRandomChestContent(Items.blaze_powder, 0, 2, 8, 15), new WeightedRandomChestContent(Items.fire_charge, 0, 4, 8, 15), new WeightedRandomChestContent(Items.flint_and_steel, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.LavaEelHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.LavaEelBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.LavaEelLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.LavaEelBoots, 0, 1, 1, 15), new WeightedRandomChestContent(Items.spawn_egg, 61, 2, 8, 15) };
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
/*  390 */   private final WeightedRandomChestContent[] beeContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.sugar, 0, 2, 8, 15), new WeightedRandomChestContent(Item.getItemFromBlock((Block)Blocks.yellow_flower), 0, 4, 8, 15), new WeightedRandomChestContent(Items.gold_nugget, 0, 5, 15, 15), new WeightedRandomChestContent(Items.paper, 0, 2, 8, 15), new WeightedRandomChestContent(OreSpawnMain.MyFairySword, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkHelmet, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkBody, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkLegs, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkBoots, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyButterCandy, 0, 2, 8, 15), new WeightedRandomChestContent(OreSpawnMain.MyExperienceCatcher, 0, 4, 10, 10), new WeightedRandomChestContent(OreSpawnMain.BeeEgg, 0, 2, 8, 15) };
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
/*  405 */   private final WeightedRandomChestContent[] mantisContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(OreSpawnMain.MyMantisClaw, 0, 1, 1, 10), new WeightedRandomChestContent(Items.gold_nugget, 0, 4, 8, 15), new WeightedRandomChestContent(OreSpawnMain.UraniumNugget, 0, 1, 3, 5), new WeightedRandomChestContent(OreSpawnMain.TitaniumNugget, 0, 1, 3, 5), new WeightedRandomChestContent(OreSpawnMain.MantisEgg, 0, 2, 4, 20), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeHelmet, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeBody, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeLegs, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeBoots, 0, 1, 1, 10), new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25), new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 15) };
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
/*  419 */   private final WeightedRandomChestContent[] level1ContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.emerald, 0, 2, 8, 15), new WeightedRandomChestContent(OreSpawnMain.MinersDream, 0, 4, 8, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldPickaxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldShovel, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldHoe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldAxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldSword, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.EmeraldBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.EmeraldLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.EmeraldHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.EmeraldBoots, 0, 1, 1, 15) };
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
/*  432 */   private final WeightedRandomChestContent[] level2ContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.experience_bottle, 0, 2, 8, 15), new WeightedRandomChestContent(Items.experience_bottle, 0, 2, 8, 15), new WeightedRandomChestContent(OreSpawnMain.CreeperLauncher, 0, 2, 10, 15), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkHelmet, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkBody, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkLegs, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkBoots, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyFairySword, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldPickaxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldShovel, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldHoe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldAxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldSword, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceBoots, 0, 1, 1, 15) };
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
/*  451 */   private final WeightedRandomChestContent[] level3ContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(OreSpawnMain.MySquidZooka, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyRatSword, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethyst, 0, 2, 8, 15), new WeightedRandomChestContent(Items.dye, 0, 2, 8, 15), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeHelmet, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeBody, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeLegs, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeBoots, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyAmethystPickaxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystShovel, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystHoe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystAxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyAmethystSword, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.AmethystBoots, 0, 1, 1, 15) };
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
/*  470 */   private final WeightedRandomChestContent[] level4ContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(OreSpawnMain.MyRuby, 0, 2, 8, 15), new WeightedRandomChestContent(OreSpawnMain.MagicApple, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyRayGun, 0, 1, 1, 15), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CreeperRepellent), 0, 4, 10, 15), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.KrakenRepellent), 0, 4, 10, 15), new WeightedRandomChestContent(OreSpawnMain.MyExperienceCatcher, 0, 4, 10, 15), new WeightedRandomChestContent(OreSpawnMain.ZooKeeper, 0, 10, 16, 15), new WeightedRandomChestContent(OreSpawnMain.MyRubyPickaxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyRubyShovel, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyRubyHoe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyRubyAxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyRubySword, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyThunderStaff, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.RubyBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.RubyLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.RubyHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.RubyBoots, 0, 1, 1, 15) };
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
/*  489 */   private final WeightedRandomChestContent[] level5ContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(OreSpawnMain.MyNightmareSword, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyPoisonSword, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.WitherSkeletonEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.EnderDragonEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SnowGolemEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.IronGolemEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.WitherBossEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.RedCowEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.GoldCowEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.EnchantedCowEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.MOTHRAEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.AloEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CryoEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CamaEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.VeloEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.HydroEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.BasilEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.DragonflyEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.EmperorScorpionEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.ScorpionEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CaveFisherEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SpyroEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.BaryonyxEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CockateilEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.GammaMetroidEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.KyuubiEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.AlienEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.AttackSquidEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.WaterDragonEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CephadromeEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.KrakenEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.LizardEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.DragonEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.BeeEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.TrooperBugEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SpitBugEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.StinkBugEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.OstrichEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.GazelleEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.ChipmunkEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CreepingHorrorEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.TerribleTerrorEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CliffRacerEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.TriffidEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.PitchBlackEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.LurkingTerrorEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SmallWormEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.MediumWormEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.LargeWormEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.TRexEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.GodzillaEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.MantisEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.HerculesEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.VortexEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.RatEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.DungeonBeastEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.FairyEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.WhaleEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SkateEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.IrukandjiEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.Robot1Egg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.Robot2Egg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.Robot3Egg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.Robot4Egg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.Robot5Egg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CriminalEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CoinEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.BoyfriendEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.EasterBunnyEgg, 0, 1, 4, 5), new WeightedRandomChestContent(OreSpawnMain.MolenoidEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SeaMonsterEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SeaViperEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CaterKillerEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.LeonEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.HammerheadEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.RubberDuckyEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.NastysaurusEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.PointysaurusEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.BrutalflyEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CricketEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.FrogEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.AntRobotKit, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.SpiderRobotKit, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.JefferyEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SpiderDriverEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CrabEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CassowaryEgg, 0, 1, 4, 15) };
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
/*  579 */   private final WeightedRandomChestContent[] chestContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(OreSpawnMain.MyBacon, 0, 6, 12, 20), new WeightedRandomChestContent(OreSpawnMain.MyButterCandy, 0, 6, 12, 20), new WeightedRandomChestContent(Items.emerald, 0, 2, 8, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldPickaxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldShovel, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldHoe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldAxe, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyEmeraldSword, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.EmeraldBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.EmeraldLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.EmeraldHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.EmeraldBoots, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyMothScale, 0, 2, 8, 15), new WeightedRandomChestContent((Item)OreSpawnMain.MothScaleBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.MothScaleLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.MothScaleHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.MothScaleBoots, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyLavaEel, 0, 2, 8, 15), new WeightedRandomChestContent((Item)OreSpawnMain.LavaEelBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.LavaEelLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.LavaEelHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.LavaEelBoots, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceBody, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceLegs, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceHelmet, 0, 1, 1, 15), new WeightedRandomChestContent((Item)OreSpawnMain.ExperienceBoots, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.MyExperienceSword, 0, 1, 1, 15), new WeightedRandomChestContent(OreSpawnMain.WitherSkeletonEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.EnderDragonEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SnowGolemEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.IronGolemEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.WitherBossEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.RedCowEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.GoldCowEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.EnchantedCowEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.MOTHRAEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.AloEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CryoEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CamaEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.VeloEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.HydroEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.BasilEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.DragonflyEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.EmperorScorpionEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.ScorpionEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CaveFisherEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SpyroEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.BaryonyxEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CockateilEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.GammaMetroidEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.KyuubiEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.AlienEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.AttackSquidEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.WaterDragonEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CephadromeEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.KrakenEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.LizardEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.DragonEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.BeeEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.TrooperBugEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SpitBugEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.StinkBugEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.OstrichEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.GazelleEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.ChipmunkEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CreepingHorrorEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.TerribleTerrorEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CliffRacerEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.TriffidEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.PitchBlackEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.LurkingTerrorEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SmallWormEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.MediumWormEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.LargeWormEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CassowaryEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.MolenoidEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SeaMonsterEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SeaViperEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CaterKillerEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.LeonEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.HammerheadEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.RubberDuckyEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.NastysaurusEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.PointysaurusEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.BrutalflyEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CricketEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.FrogEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.JefferyEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.SpiderDriverEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CrabEgg, 0, 1, 4, 15), new WeightedRandomChestContent(OreSpawnMain.CageEmpty, 0, 3, 10, 20) };
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
/*      */   private void setThisBlock(World world, int cposx, int cposy, int cposz) {
/*  680 */     if (world.rand.nextInt(2) == 1) {
/*  681 */       FastSetBlock(world, cposx, cposy, cposz, Blocks.mossy_cobblestone);
/*      */     } else {
/*  683 */       FastSetBlock(world, cposx, cposy, cposz, Blocks.cobblestone);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private TileEntityChest getChestTileEntity(World world, int cposx, int cposy, int cposz) {
/*  689 */     TileEntityChest chest = null;
/*  690 */     TileEntity t = null;
/*  691 */     t = world.getTileEntity(cposx, cposy, cposz);
/*  692 */     if (t != null && t instanceof TileEntityChest) {
/*  693 */       chest = (TileEntityChest)t;
/*  694 */       return chest;
/*      */     } 
/*  696 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private TileEntityMobSpawner getSpawnerTileEntity(World world, int cposx, int cposy, int cposz) {
/*  701 */     TileEntityMobSpawner chest = null;
/*  702 */     TileEntity t = null;
/*  703 */     t = world.getTileEntity(cposx, cposy, cposz);
/*  704 */     if (t != null && t instanceof TileEntityMobSpawner) {
/*  705 */       chest = (TileEntityMobSpawner)t;
/*  706 */       return chest;
/*      */     } 
/*  708 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeDungeon(World world, int cposx, int cposy, int cposz) {
/*  715 */     int width = 12;
/*  716 */     int height = 6;
/*      */     
/*      */     int i;
/*  719 */     for (i = 0; i < width; i++) {
/*  720 */       for (int j = 0; j < height; j++) {
/*  721 */         for (int m = 0; m < width; m++) {
/*  722 */           FastSetBlock(world, cposx + i, cposy + j, cposz + m, Blocks.air);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  728 */     for (i = 0; i < width; i++) {
/*  729 */       int j = 0;
/*  730 */       for (int m = 0; m < width; m++) {
/*  731 */         FastSetBlock(world, cposx + i, cposy + j, cposz + m, Blocks.mossy_cobblestone);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  736 */     for (i = 0; i < width; i++) {
/*  737 */       int j = height - 1;
/*  738 */       for (int m = 0; m < width; m++) {
/*  739 */         setThisBlock(world, cposx + i, cposy + j, cposz + m);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  744 */     for (i = 0; i < width; i++) {
/*  745 */       for (int j = 0; j < height; j++) {
/*  746 */         int m = 0;
/*  747 */         setThisBlock(world, cposx + i, cposy + j, cposz + m);
/*  748 */         m = width - 1;
/*  749 */         setThisBlock(world, cposx + i, cposy + j, cposz + m);
/*      */       } 
/*      */     } 
/*      */     
/*  753 */     for (int k = 0; k < width; k++) {
/*  754 */       for (int j = 0; j < height; j++) {
/*  755 */         i = 0;
/*  756 */         setThisBlock(world, cposx + i, cposy + j, cposz + k);
/*  757 */         i = width - 1;
/*  758 */         setThisBlock(world, cposx + i, cposy + j, cposz + k);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  764 */     world.setBlock(cposx + width / 2, cposy + 1, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/*  765 */     TileEntityMobSpawner tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 1, cposz + width / 2);
/*      */     
/*  767 */     if (tileentitymobspawner != null) {
/*      */       
/*  769 */       int t = world.rand.nextInt(12);
/*  770 */       if (t == 0) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Scorpion"); 
/*  771 */       if (t == 1) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Alien"); 
/*  772 */       if (t == 2) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Cryolophosaurus"); 
/*  773 */       if (t == 3) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("WTF?"); 
/*  774 */       if (t == 4) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Kyuubi"); 
/*  775 */       if (t == 5) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Bee"); 
/*  776 */       if (t == 6) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Cloud Shark"); 
/*  777 */       if (t == 7) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Lurking Terror"); 
/*  778 */       if (t == 8) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Terrible Terror"); 
/*  779 */       if (t == 9) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rotator"); 
/*  780 */       if (t == 10) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rat"); 
/*  781 */       if (t == 11) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Dungeon Beast");
/*      */     
/*      */     } 
/*      */ 
/*      */     
/*  786 */     TileEntityChest chest = null;
/*      */     
/*  788 */     world.setBlock(cposx + width / 2, cposy + 1, cposz + 1, (Block)Blocks.chest, 0, 2);
/*  789 */     chest = getChestTileEntity(world, cposx + width / 2, cposy + 1, cposz + 1);
/*  790 */     if (chest != null)
/*      */     {
/*      */       
/*  793 */       WeightedRandomChestContent.generateChestContents(world.rand, this.chestContentsList, (IInventory)chest, 5 + world.rand.nextInt(7));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void FastSetBlock(World world, int ix, int iy, int iz, Block id) {
/*  800 */     OreSpawnMain.setBlockFast(world, ix, iy, iz, id, 0, 2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeEnormousCastle(World world, int cposx, int cposy, int cposz) {
/*  806 */     int width = 28;
/*  807 */     int height = 16;
/*  808 */     int platformwidth = 11;
/*  809 */     int level = 0;
/*      */     
/*  811 */     if (world.isRemote) {
/*      */       return;
/*      */     }
/*      */     
/*  815 */     level = 1 + world.rand.nextInt(6);
/*  816 */     if (level <= 3 && world.rand.nextInt(3) != 1) level += 3;
/*      */     
/*      */     int i;
/*  819 */     for (i = -20; i < width + 4; i++) {
/*  820 */       for (int m = 1; m < height + 10; m++) {
/*  821 */         for (int n = -4; n < width + 4; n++) {
/*  822 */           FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.air);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  830 */     for (i = 0; i < width; i++) {
/*  831 */       int m = 0;
/*  832 */       for (int n = 0; n < width; n++) {
/*  833 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.stone);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  838 */     for (i = 0; i < width; i++) {
/*  839 */       int m = height;
/*  840 */       for (int n = 0; n < width; n++) {
/*  841 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.bedrock);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  846 */     for (i = 0; i < width; i++) {
/*  847 */       for (int m = 1; m < height; m++) {
/*  848 */         int n = 0;
/*  849 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.iron_bars);
/*  850 */         n = width - 1;
/*  851 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.iron_bars);
/*      */       } 
/*      */     } 
/*      */     int k;
/*  855 */     for (k = 0; k < width; k++) {
/*  856 */       for (int m = 1; m < height; m++) {
/*  857 */         i = 0;
/*  858 */         FastSetBlock(world, cposx + i, cposy + m, cposz + k, Blocks.iron_bars);
/*  859 */         i = width - 1;
/*  860 */         FastSetBlock(world, cposx + i, cposy + m, cposz + k, Blocks.iron_bars);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  865 */     world.setBlock(cposx + 1, cposy + 1, cposz + 1, OreSpawnMain.ExtremeTorch);
/*  866 */     world.setBlock(cposx + 1, cposy + 1, cposz + width - 2, OreSpawnMain.ExtremeTorch);
/*  867 */     world.setBlock(cposx + width - 2, cposy + 1, cposz + 1, OreSpawnMain.ExtremeTorch);
/*  868 */     world.setBlock(cposx + width - 2, cposy + 1, cposz + width - 2, OreSpawnMain.ExtremeTorch);
/*      */ 
/*      */     
/*  871 */     for (i = -4; i < width + 4; i++) {
/*  872 */       for (k = -4; k < width + 4; k++) {
/*  873 */         if (i < 0 || k < 0 || i >= width || k >= width)
/*  874 */           FastSetBlock(world, cposx + i, cposy, cposz + k, Blocks.stone); 
/*  875 */         if (i == -4 || k == -4 || i == width + 3 || k == width + 3)
/*  876 */           FastSetBlock(world, cposx + i, cposy + 1, cposz + k, Blocks.nether_brick_fence); 
/*      */       } 
/*      */     } 
/*  879 */     TileEntityMobSpawner tileentitymobspawner = null; int j;
/*  880 */     for (j = 0; j < 4; j++) {
/*      */       
/*  882 */       world.setBlock(cposx - 3, cposy + 1 + j, cposz - 3, Blocks.mob_spawner, 0, 2);
/*  883 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx - 3, cposy + 1 + j, cposz - 3);
/*  884 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Terrible Terror");
/*      */       
/*  886 */       world.setBlock(cposx - 3, cposy + 1 + j, cposz + width + 2, Blocks.mob_spawner, 0, 2);
/*  887 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx - 3, cposy + 1 + j, cposz + width + 2);
/*  888 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Terrible Terror");
/*      */       
/*  890 */       world.setBlock(cposx + width + 2, cposy + 1 + j, cposz - 3, Blocks.mob_spawner, 0, 2);
/*  891 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width + 2, cposy + 1 + j, cposz - 3);
/*  892 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Terrible Terror");
/*      */       
/*  894 */       world.setBlock(cposx + width + 2, cposy + 1 + j, cposz + width + 2, Blocks.mob_spawner, 0, 2);
/*  895 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width + 2, cposy + 1 + j, cposz + width + 2);
/*  896 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Terrible Terror");
/*      */     
/*      */     } 
/*      */     
/*  900 */     world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/*  901 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
/*  902 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Emperor Scorpion"); 
/*  903 */     world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/*  904 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
/*  905 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Emperor Scorpion"); 
/*  906 */     world.setBlock(cposx + width / 2, cposy + 4, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/*  907 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 4, cposz + width / 2);
/*  908 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Emperor Scorpion");
/*      */     
/*  910 */     j = height;
/*  911 */     buildLevel(world, cposx + 1, cposy + j, cposz + 1, width - 2, 10, 4, "Cloud Shark", 1, -1, 5, 1, level);
/*  912 */     j += 10;
/*  913 */     if (level >= 2) buildLevel(world, cposx + 1, cposy + j, cposz + 1, width - 2, 10, 4, "Lurking Terror", 0, 0, 4, 2, level); 
/*  914 */     j += 10;
/*  915 */     if (level >= 3) buildLevel(world, cposx + 2, cposy + j, cposz + 2, width - 4, 9, 4, "Rotator", 1, 1, 4, 3, level); 
/*  916 */     j += 9;
/*  917 */     if (level >= 4) buildLevel(world, cposx + 2, cposy + j, cposz + 2, width - 4, 9, 3, "Bee", 0, 0, 4, 4, level); 
/*  918 */     j += 9;
/*  919 */     if (level >= 5) buildLevel(world, cposx + 3, cposy + j, cposz + 3, width - 6, 8, 3, "Mantis", 1, 1, 4, 5, level); 
/*  920 */     j += 8;
/*  921 */     if (level >= 6) buildLevel(world, cposx + 3, cposy + j, cposz + 3, width - 6, 16, 3, "Mothra", 0, 0, 3, 6, level); 
/*  922 */     j += 16;
/*      */ 
/*      */ 
/*      */     
/*  926 */     for (i = 0; i < platformwidth; i++) {
/*  927 */       j = height;
/*  928 */       for (k = -(platformwidth / 2); k <= platformwidth / 2; k++) {
/*  929 */         FastSetBlock(world, cposx + i - 20, cposy + j, cposz + k + width / 2, Blocks.quartz_block);
/*  930 */         if ((i == 0 || i == platformwidth - 1 || k == -(platformwidth / 2) || k == platformwidth / 2) && (
/*  931 */           i != 0 || k < -1 || k > 1)) {
/*  932 */           FastSetBlock(world, cposx + i - 20, cposy + j + 1, cposz + k + width / 2, Blocks.nether_brick_fence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  937 */     for (i = -10; i <= -3; i++) {
/*  938 */       j = height;
/*  939 */       for (k = -2; k < 3; k++) {
/*  940 */         if (i == -3 || i == -10) {
/*  941 */           if (k != -2 && k != 2) {
/*  942 */             FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.air);
/*      */           } else {
/*  944 */             FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.netherrack);
/*  945 */             FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k + width / 2, Blocks.netherrack);
/*  946 */             FastSetBlock(world, cposx + i, cposy + j + 3, cposz + k + width / 2, (Block)Blocks.fire);
/*      */           } 
/*      */         } else {
/*  949 */           FastSetBlock(world, cposx + i, cposy + j, cposz + k + width / 2, Blocks.quartz_block);
/*  950 */           if (k == -2 || k == 2) {
/*  951 */             FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.nether_brick_fence);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  957 */     i = -21;
/*  958 */     for (j = height; j >= 0; j--) {
/*      */       
/*  960 */       for (k = -2; k < 3; k++) {
/*      */         
/*  962 */         for (int t = 0; t < 6; ) { FastSetBlock(world, cposx + i, cposy + j + t + 1, cposz + k + width / 2, Blocks.air); t++; }
/*      */         
/*  964 */         if (j == 0) {
/*  965 */           if (k != -2 && k != 2) {
/*  966 */             FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.air);
/*      */           } else {
/*  968 */             FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.netherrack);
/*  969 */             FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k + width / 2, Blocks.netherrack);
/*  970 */             FastSetBlock(world, cposx + i, cposy + j + 3, cposz + k + width / 2, (Block)Blocks.fire);
/*      */           } 
/*      */         } else {
/*  973 */           FastSetBlock(world, cposx + i, cposy + j, cposz + k + width / 2, Blocks.quartz_block);
/*  974 */           if (k == -2 || k == 2) {
/*  975 */             FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.nether_brick_fence);
/*      */           }
/*      */         } 
/*      */       } 
/*  979 */       i--;
/*      */     } 
/*      */     
/*  982 */     if (level >= 6) {
/*      */       
/*  984 */       int span = width * 3;
/*  985 */       for (int tries = 0; tries < 100; tries++) {
/*  986 */         j = -1;
/*  987 */         i = world.rand.nextInt(span);
/*  988 */         k = world.rand.nextInt(span);
/*  989 */         if (i < span / 4 || i > span * 3 / 4 || k < span / 4 || k > span * 3 / 4) {
/*  990 */           i -= span / 2;
/*  991 */           k -= span / 2;
/*  992 */           world.setBlock(cposx + i + width / 2, cposy + j, cposz + k + width / 2, Blocks.mob_spawner, 0, 2);
/*  993 */           tileentitymobspawner = getSpawnerTileEntity(world, cposx + i + width / 2, cposy + j, cposz + k + width / 2);
/*  994 */           if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Large Worm");
/*      */         
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void buildLevel(World world, int cposx, int cposy, int cposz, int width, int height, int pw, String critter, int stepside, int stepoff, int holelen, int decor, int level) {
/*      */     int i;
/* 1007 */     for (i = -pw; i < width + pw; i++) {
/* 1008 */       for (int m = 1; m < height; m++) {
/* 1009 */         for (int n = -pw; n < width + pw; n++) {
/* 1010 */           FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.air);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1016 */     for (i = 0; i < width; i++) {
/* 1017 */       int m = 0;
/* 1018 */       for (int n = 0; n < width; n++) {
/* 1019 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.bedrock);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1024 */     for (i = 0; i < width; i++) {
/* 1025 */       int m = height;
/* 1026 */       for (int n = 0; n < width; n++) {
/* 1027 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.bedrock);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1032 */     for (i = 0; i < width; i++) {
/* 1033 */       for (int m = 1; m < height; m++) {
/* 1034 */         int n = 0;
/* 1035 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.bedrock);
/* 1036 */         n = width - 1;
/* 1037 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.bedrock);
/*      */       } 
/*      */     } 
/*      */     int k;
/* 1041 */     for (k = 0; k < width; k++) {
/* 1042 */       for (int m = 1; m < height; m++) {
/* 1043 */         Block blk = Blocks.bedrock;
/* 1044 */         if (k == 0 || k == width - 1) blk = Blocks.gold_block; 
/* 1045 */         i = 0;
/* 1046 */         FastSetBlock(world, cposx + i, cposy + m, cposz + k, blk);
/* 1047 */         i = width - 1;
/* 1048 */         FastSetBlock(world, cposx + i, cposy + m, cposz + k, blk);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1059 */     for (i = -pw; i < width + pw; i++) {
/* 1060 */       for (k = -pw; k < width + pw; k++) {
/* 1061 */         if (i < 0 || k < 0 || i >= width || k >= width)
/* 1062 */           FastSetBlock(world, cposx + i, cposy, cposz + k, Blocks.stone); 
/* 1063 */         if (i == -pw || k == -pw || i == width + pw - 1 || k == width + pw - 1) {
/* 1064 */           FastSetBlock(world, cposx + i, cposy + 1, cposz + k, Blocks.nether_brick_fence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1069 */     i = -(height / 2);
/* 1070 */     i += width / 2; int j;
/* 1071 */     for (j = 1; j < height; j++) {
/* 1072 */       if (stepside != 0) {
/* 1073 */         k = -1;
/* 1074 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.stone);
/*      */       } else {
/* 1076 */         k = width;
/* 1077 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.stone);
/*      */       } 
/* 1079 */       i++;
/*      */     } 
/*      */     
/* 1082 */     if (stepoff >= 0) {
/*      */       
/* 1084 */       if (stepside == 0) {
/* 1085 */         k = -1;
/* 1086 */         k -= stepoff;
/*      */       } else {
/* 1088 */         k = width;
/* 1089 */         k += stepoff;
/*      */       } 
/* 1091 */       i = width / 2;
/* 1092 */       j = 0;
/* 1093 */       for (int l = 0; l < holelen; l++) {
/* 1094 */         FastSetBlock(world, cposx + i + l, cposy + j, cposz + k, Blocks.air);
/*      */       }
/*      */     } 
/*      */     
/* 1098 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 1099 */     for (j = 0; j < 4; j++) {
/*      */       
/* 1101 */       world.setBlock(cposx - pw - 1, cposy + j + 1, cposz - pw - 1, Blocks.mob_spawner, 0, 2);
/* 1102 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx - pw - 1, cposy + j + 1, cposz - pw - 1);
/* 1103 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter);
/*      */       
/* 1105 */       world.setBlock(cposx - pw - 1, cposy + j + 1, cposz + width + pw - 2, Blocks.mob_spawner, 0, 2);
/* 1106 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx - pw - 1, cposy + j + 1, cposz + width + pw - 2);
/* 1107 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter);
/*      */       
/* 1109 */       world.setBlock(cposx + width + pw - 2, cposy + j + 1, cposz - pw - 1, Blocks.mob_spawner, 0, 2);
/* 1110 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width + pw - 2, cposy + j + 1, cposz - pw - 1);
/* 1111 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter);
/*      */       
/* 1113 */       world.setBlock(cposx + width + pw - 2, cposy + j + 1, cposz + width + pw - 2, Blocks.mob_spawner, 0, 2);
/* 1114 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width + pw - 2, cposy + j + 1, cposz + width + pw - 2);
/* 1115 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter);
/*      */     
/*      */     } 
/* 1118 */     addLevelDecorations(world, cposx, cposy, cposz, width, height, decor, level);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addLevelDecorations(World world, int cposx, int cposy, int cposz, int width, int height, int decor, int difficulty) {
/* 1124 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 1125 */     int reward = 1;
/*      */     
/* 1127 */     String critter = "Alosaurus";
/*      */     
/* 1129 */     if (decor == 6) {
/* 1130 */       FastSetBlock(world, cposx, cposy + height, cposz, Blocks.netherrack);
/* 1131 */       FastSetBlock(world, cposx, cposy + height + 1, cposz, (Block)Blocks.fire);
/* 1132 */       FastSetBlock(world, cposx, cposy + height, cposz + width - 1, Blocks.netherrack);
/* 1133 */       FastSetBlock(world, cposx, cposy + height + 1, cposz + width - 1, (Block)Blocks.fire);
/* 1134 */       FastSetBlock(world, cposx + width - 1, cposy + height, cposz, Blocks.netherrack);
/* 1135 */       FastSetBlock(world, cposx + width - 1, cposy + height + 1, cposz, (Block)Blocks.fire);
/* 1136 */       FastSetBlock(world, cposx + width - 1, cposy + height, cposz + width - 1, Blocks.netherrack);
/* 1137 */       FastSetBlock(world, cposx + width - 1, cposy + height + 1, cposz + width - 1, (Block)Blocks.fire);
/*      */       
/* 1139 */       FastSetBlock(world, cposx + width / 2, cposy + height, cposz + width / 2, Blocks.air);
/*      */       
/* 1141 */       world.setBlock(cposx + width / 2 - 1, cposy + height + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1142 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 - 1, cposy + height + 2, cposz + width / 2);
/* 1143 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Nightmare"); 
/* 1144 */       world.setBlock(cposx + width / 2 + 1, cposy + height + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1145 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 + 1, cposy + height + 2, cposz + width / 2);
/* 1146 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Nightmare"); 
/* 1147 */       world.setBlock(cposx + width / 2, cposy + height + 2, cposz + width / 2 - 1, Blocks.mob_spawner, 0, 2);
/* 1148 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + height + 2, cposz + width / 2 - 1);
/* 1149 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Nightmare"); 
/* 1150 */       world.setBlock(cposx + width / 2, cposy + height + 2, cposz + width / 2 + 1, Blocks.mob_spawner, 0, 2);
/* 1151 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + height + 2, cposz + width / 2 + 1);
/* 1152 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Nightmare");
/*      */ 
/*      */       
/* 1155 */       for (int i = 1; i < width - 1; i++) {
/* 1156 */         for (int k = 1; k < 5; k++) {
/* 1157 */           for (int m = 1; m < width - 1; m++) {
/* 1158 */             FastSetBlock(world, cposx + i, cposy + k, cposz + m, Blocks.dirt);
/*      */           }
/*      */         } 
/*      */       } 
/* 1162 */       world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1163 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
/* 1164 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Large Worm"); 
/* 1165 */       world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1166 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
/* 1167 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Large Worm"); 
/* 1168 */       world.setBlock(cposx + width / 2, cposy + 4, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1169 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 4, cposz + width / 2);
/* 1170 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Large Worm");
/*      */       
/* 1172 */       for (int j = 0; j < 10; j++) {
/* 1173 */         FastSetBlock(world, cposx + 1, cposy + j, cposz + 1, Blocks.air);
/*      */       }
/*      */       
/* 1176 */       fill_chests(world, cposx, cposy + 4, cposz, width, height, decor, reward);
/*      */     } 
/* 1178 */     if (decor == 5) {
/* 1179 */       if (difficulty == 5) {
/* 1180 */         critter = "Alosaurus";
/* 1181 */         reward = 1;
/*      */       } 
/* 1183 */       if (difficulty == 6) {
/* 1184 */         critter = "T. Rex";
/* 1185 */         reward = 2;
/*      */       } 
/*      */ 
/*      */       
/* 1189 */       world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1190 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
/* 1191 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 1192 */       world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1193 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
/* 1194 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 1195 */       for (int j = 1; j < 5; j++) {
/* 1196 */         FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 1197 */         FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 1198 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
/* 1199 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
/*      */       } 
/*      */       
/* 1202 */       FastSetBlock(world, cposx + width - 2, cposy, cposz + width - 2, Blocks.air);
/* 1203 */       FastSetBlock(world, cposx + 1, cposy + height, cposz + 1, Blocks.air);
/*      */       
/* 1205 */       fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
/*      */     } 
/* 1207 */     if (decor == 4) {
/* 1208 */       if (difficulty == 4) {
/* 1209 */         critter = "Alosaurus";
/* 1210 */         reward = 1;
/*      */       } 
/* 1212 */       if (difficulty == 5) {
/* 1213 */         critter = "T. Rex";
/* 1214 */         reward = 2;
/*      */       } 
/* 1216 */       if (difficulty == 6) {
/* 1217 */         critter = "Basilisk";
/* 1218 */         reward = 3;
/*      */       } 
/*      */       
/* 1221 */       world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1222 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
/* 1223 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 1224 */       world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1225 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
/* 1226 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 1227 */       for (int j = 1; j < 5; j++) {
/* 1228 */         FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 1229 */         FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 1230 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
/* 1231 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
/*      */       } 
/*      */       
/* 1234 */       FastSetBlock(world, cposx + 1, cposy, cposz + 1, Blocks.air);
/* 1235 */       FastSetBlock(world, cposx + width - 2, cposy + height, cposz + width - 2, Blocks.air);
/*      */       
/* 1237 */       fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
/*      */     } 
/* 1239 */     if (decor == 3) {
/* 1240 */       if (difficulty == 3) {
/* 1241 */         critter = "Alosaurus";
/* 1242 */         reward = 1;
/*      */       } 
/* 1244 */       if (difficulty == 4) {
/* 1245 */         critter = "T. Rex";
/* 1246 */         reward = 2;
/*      */       } 
/* 1248 */       if (difficulty == 5) {
/* 1249 */         critter = "Basilisk";
/* 1250 */         reward = 3;
/*      */       } 
/* 1252 */       if (difficulty == 6) {
/* 1253 */         critter = "Hercules Beetle";
/* 1254 */         reward = 4;
/*      */       } 
/*      */       
/* 1257 */       world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1258 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
/* 1259 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 1260 */       world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1261 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
/* 1262 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 1263 */       for (int j = 1; j < 5; j++) {
/* 1264 */         FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 1265 */         FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 1266 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
/* 1267 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
/*      */       } 
/*      */       
/* 1270 */       FastSetBlock(world, cposx + width - 2, cposy, cposz + width - 2, Blocks.air);
/* 1271 */       FastSetBlock(world, cposx + 1, cposy + height, cposz + 1, Blocks.air);
/*      */       
/* 1273 */       fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
/*      */     } 
/* 1275 */     if (decor == 2) {
/* 1276 */       if (difficulty == 2) {
/* 1277 */         critter = "Alosaurus";
/* 1278 */         reward = 1;
/*      */       } 
/* 1280 */       if (difficulty == 3) {
/* 1281 */         critter = "T. Rex";
/* 1282 */         reward = 2;
/*      */       } 
/* 1284 */       if (difficulty == 4) {
/* 1285 */         critter = "Basilisk";
/* 1286 */         reward = 3;
/*      */       } 
/* 1288 */       if (difficulty == 5) {
/* 1289 */         critter = "Hercules Beetle";
/* 1290 */         reward = 4;
/*      */       } 
/* 1292 */       if (difficulty == 6) {
/* 1293 */         critter = "Jumpy Bug";
/* 1294 */         reward = 5;
/*      */       } 
/* 1296 */       world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1297 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
/* 1298 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 1299 */       world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1300 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
/* 1301 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 1302 */       for (int j = 1; j < 5; j++) {
/* 1303 */         FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 1304 */         FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 1305 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
/* 1306 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
/*      */       } 
/* 1308 */       FastSetBlock(world, cposx + 1, cposy, cposz + 1, Blocks.air);
/* 1309 */       FastSetBlock(world, cposx + width - 2, cposy + height, cposz + width - 2, Blocks.air);
/*      */       
/* 1311 */       fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
/*      */     } 
/* 1313 */     if (decor == 1) {
/* 1314 */       if (difficulty == 1) critter = "Alosaurus"; 
/* 1315 */       if (difficulty == 2) critter = "T. Rex"; 
/* 1316 */       if (difficulty == 3) critter = "Basilisk"; 
/* 1317 */       if (difficulty == 4) critter = "Hercules Beetle"; 
/* 1318 */       if (difficulty == 5) critter = "Jumpy Bug"; 
/* 1319 */       if (difficulty == 6) critter = "Hammerhead"; 
/* 1320 */       reward = difficulty;
/*      */       
/* 1322 */       world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1323 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
/* 1324 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 1325 */       world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1326 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
/* 1327 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 1328 */       for (int j = 1; j < 5; j++) {
/* 1329 */         FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 1330 */         FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 1331 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
/* 1332 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1337 */       FastSetBlock(world, cposx + width / 2 - 1, cposy + 1, cposz + width / 2 - 1, OreSpawnMain.MyRTPBlock);
/* 1338 */       FastSetBlock(world, cposx + width / 2 + 1, cposy + 1, cposz + width / 2 + 1, OreSpawnMain.MyRTPBlock);
/* 1339 */       FastSetBlock(world, cposx + width / 2 + 1, cposy + 1, cposz + width / 2 - 1, OreSpawnMain.MyRTPBlock);
/* 1340 */       FastSetBlock(world, cposx + width / 2 - 1, cposy + 1, cposz + width / 2 + 1, OreSpawnMain.MyRTPBlock);
/*      */ 
/*      */       
/* 1343 */       FastSetBlock(world, cposx + 1, cposy + height, cposz + 1, Blocks.air);
/*      */       
/* 1345 */       fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void fill_chests(World world, int cposx, int cposy, int cposz, int width, int height, int decor, int reward) {
/* 1353 */     TileEntityChest chest = null;
/* 1354 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 1356 */     chestContents = this.level1ContentsList;
/* 1357 */     if (reward == 2) chestContents = this.level2ContentsList; 
/* 1358 */     if (reward == 3) chestContents = this.level3ContentsList; 
/* 1359 */     if (reward == 4) chestContents = this.level4ContentsList; 
/* 1360 */     if (reward == 5) chestContents = this.level5ContentsList;
/*      */     
/* 1362 */     world.setBlock(cposx + 1, cposy + 1, cposz + width / 2, (Block)Blocks.chest, 0, 2);
/* 1363 */     world.setBlockMetadataWithNotify(cposx + 1, cposy + 1, cposz + width / 2, 5, 3);
/* 1364 */     chest = getChestTileEntity(world, cposx + 1, cposy + 1, cposz + width / 2);
/*      */     
/* 1366 */     if (chest != null)
/*      */     {
/* 1368 */       if (reward == 6) {
/* 1369 */         chest.setInventorySlotContents(1, new ItemStack(OreSpawnMain.ThePrinceEgg, 1, 0));
/*      */       } else {
/*      */         
/* 1372 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 5 + world.rand.nextInt(7));
/*      */       } 
/*      */     }
/*      */     
/* 1376 */     world.setBlock(cposx + width - 2, cposy + 1, cposz + width / 2, (Block)Blocks.chest, 0, 2);
/* 1377 */     world.setBlockMetadataWithNotify(cposx + width - 2, cposy + 1, cposz + width / 2, 4, 3);
/* 1378 */     chest = getChestTileEntity(world, cposx + width - 2, cposy + 1, cposz + width / 2);
/*      */     
/* 1380 */     if (chest != null)
/*      */     {
/* 1382 */       if (reward == 6) {
/*      */         
/* 1384 */         chest.setInventorySlotContents(1, new ItemStack((Item)OreSpawnMain.RoyalHelmet, 1, 0));
/* 1385 */         chest.setInventorySlotContents(2, new ItemStack((Item)OreSpawnMain.RoyalBody, 1, 0));
/*      */       } else {
/*      */         
/* 1388 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 5 + world.rand.nextInt(7));
/*      */       } 
/*      */     }
/*      */     
/* 1392 */     world.setBlock(cposx + width / 2, cposy + 1, cposz + 1, (Block)Blocks.chest, 0, 2);
/* 1393 */     world.setBlockMetadataWithNotify(cposx + width / 2, cposy + 1, cposz + 1, 3, 3);
/* 1394 */     chest = getChestTileEntity(world, cposx + width / 2, cposy + 1, cposz + 1);
/*      */     
/* 1396 */     if (chest != null)
/*      */     {
/* 1398 */       if (reward == 6) {
/*      */         
/* 1400 */         chest.setInventorySlotContents(1, new ItemStack((Item)OreSpawnMain.RoyalLegs, 1, 0));
/* 1401 */         chest.setInventorySlotContents(2, new ItemStack((Item)OreSpawnMain.RoyalBoots, 1, 0));
/*      */       } else {
/*      */         
/* 1404 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 5 + world.rand.nextInt(7));
/*      */       } 
/*      */     }
/*      */     
/* 1408 */     world.setBlock(cposx + width / 2, cposy + 1, cposz + width - 2, (Block)Blocks.chest, 0, 2);
/* 1409 */     world.setBlockMetadataWithNotify(cposx + width / 2, cposy + 1, cposz + width - 2, 2, 3);
/* 1410 */     chest = getChestTileEntity(world, cposx + width / 2, cposy + 1, cposz + width - 2);
/*      */     
/* 1412 */     if (chest != null)
/*      */     {
/* 1414 */       if (reward == 6) {
/*      */         
/* 1416 */         chest.setInventorySlotContents(1, new ItemStack(OreSpawnMain.MyRoyal, 1, 0));
/*      */       } else {
/* 1418 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 5 + world.rand.nextInt(7));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeRotatorStation(World world, int cposx, int cposy, int cposz) {
/* 1426 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 1427 */     TileEntityChest chest = null;
/*      */     
/* 1429 */     world.setBlock(cposx, cposy + 4, cposz, OreSpawnMain.CrystalStone, 0, 2);
/*      */     
/* 1431 */     world.setBlock(cposx, cposy + 5, cposz, Blocks.mob_spawner, 0, 2);
/* 1432 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 5, cposz);
/* 1433 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rotator"); 
/* 1434 */     world.setBlock(cposx, cposy + 6, cposz, Blocks.mob_spawner, 0, 2);
/* 1435 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 6, cposz);
/* 1436 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rotator");
/*      */     
/* 1438 */     world.setBlock(cposx, cposy + 7, cposz, OreSpawnMain.CrystalStone, 0, 2);
/*      */     
/* 1440 */     world.setBlock(cposx, cposy + 8, cposz, (Block)Blocks.chest, 0, 2);
/* 1441 */     world.setBlockMetadataWithNotify(cposx, cposy + 8, cposz, 2, 3);
/* 1442 */     chest = getChestTileEntity(world, cposx, cposy + 8, cposz);
/*      */     
/* 1444 */     if (chest != null) {
/*      */       
/* 1446 */       chest.setInventorySlotContents(1, new ItemStack(OreSpawnMain.RotatorEgg, 1 + world.rand.nextInt(5), 0));
/* 1447 */       chest.setInventorySlotContents(2, new ItemStack(OreSpawnMain.CrystalCoal, 4 + world.rand.nextInt(16), 0));
/* 1448 */       chest.setInventorySlotContents(3, new ItemStack(OreSpawnMain.CrystalCoal, 4 + world.rand.nextInt(16), 0));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeBeeHive(World world, int cposx, int cposy, int cposz) {
/* 1455 */     int width = 10;
/* 1456 */     int height = 30;
/*      */ 
/*      */     
/* 1459 */     if (world.isRemote)
/*      */       return; 
/*      */     int i;
/* 1462 */     for (i = 0; i < width; i++) {
/* 1463 */       for (int k = 0; k < 5; k++) {
/* 1464 */         for (int m = 0; m < width; m++) {
/* 1465 */           FastSetBlock(world, cposx + i, cposy - k, cposz + m, Blocks.air);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1473 */     for (i = 0; i < width; i++) {
/* 1474 */       int m = height;
/* 1475 */       for (int k = 0; k < width; k++) {
/* 1476 */         FastSetBlock(world, cposx + i, cposy - m, cposz + k, Blocks.coal_ore);
/*      */       }
/*      */     } 
/*      */     
/* 1480 */     Block blk = Blocks.coal_ore;
/*      */     
/* 1482 */     for (i = 0; i < width; i++) {
/* 1483 */       for (int k = 0; k < width; k++) {
/* 1484 */         for (int m = 1; m < height; m++) {
/* 1485 */           if (k == 0 || i == 0 || k == width - 1 || i == width - 1) {
/* 1486 */             blk = Blocks.coal_ore;
/* 1487 */             if ((m & 0x1) == 1) blk = Blocks.gold_ore; 
/* 1488 */             FastSetBlock(world, cposx + i, cposy - m, cposz + k, blk);
/*      */           } else {
/* 1490 */             FastSetBlock(world, cposx + i, cposy - m, cposz + k, Blocks.air);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1498 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */     
/* 1500 */     for (int j = 0; j < 4; j++) {
/*      */       
/* 1502 */       world.setBlock(cposx + width / 2, cposy - 2 - j * height / 4, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 1503 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy - 2 - j * height / 4, cposz + width / 2);
/* 1504 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Bee");
/*      */     
/*      */     } 
/*      */     
/* 1508 */     fill_beehive_chests(world, cposx, cposy, cposz, width, height);
/*      */   }
/*      */ 
/*      */   
/*      */   private void fill_beehive_chests(World world, int cposx, int cposy, int cposz, int width, int height) {
/* 1513 */     TileEntityChest chest = null;
/* 1514 */     WeightedRandomChestContent[] chestContents = null;
/*      */ 
/*      */     
/* 1517 */     chestContents = this.beeContentsList;
/*      */     
/* 1519 */     for (int j = 2; j < height - 1; j += 2) {
/* 1520 */       world.setBlock(cposx + 1, cposy - j, cposz + width / 2, (Block)Blocks.chest, 0, 2);
/* 1521 */       world.setBlockMetadataWithNotify(cposx + 1, cposy - j, cposz + width / 2, 5, 3);
/* 1522 */       chest = getChestTileEntity(world, cposx + 1, cposy - j, cposz + width / 2);
/*      */       
/* 1524 */       if (chest != null)
/*      */       {
/* 1526 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 1 + world.rand.nextInt(5));
/*      */       }
/*      */       
/* 1529 */       world.setBlock(cposx + width - 2, cposy - j, cposz + width / 2, (Block)Blocks.chest, 0, 2);
/* 1530 */       world.setBlockMetadataWithNotify(cposx + width - 2, cposy - j, cposz + width / 2, 4, 3);
/* 1531 */       chest = getChestTileEntity(world, cposx + width - 2, cposy - j, cposz + width / 2);
/*      */       
/* 1533 */       if (chest != null)
/*      */       {
/* 1535 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 1 + world.rand.nextInt(5));
/*      */       }
/*      */       
/* 1538 */       world.setBlock(cposx + width / 2, cposy - j, cposz + 1, (Block)Blocks.chest, 0, 2);
/* 1539 */       world.setBlockMetadataWithNotify(cposx + width / 2, cposy - j, cposz + 1, 3, 3);
/* 1540 */       chest = getChestTileEntity(world, cposx + width / 2, cposy - j, cposz + 1);
/*      */       
/* 1542 */       if (chest != null)
/*      */       {
/* 1544 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 1 + world.rand.nextInt(5));
/*      */       }
/*      */       
/* 1547 */       world.setBlock(cposx + width / 2, cposy - j, cposz + width - 2, (Block)Blocks.chest, 0, 2);
/* 1548 */       world.setBlockMetadataWithNotify(cposx + width / 2, cposy - j, cposz + width - 2, 2, 3);
/* 1549 */       chest = getChestTileEntity(world, cposx + width / 2, cposy - j, cposz + width - 2);
/*      */       
/* 1551 */       if (chest != null)
/*      */       {
/* 1553 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 1 + world.rand.nextInt(5));
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeHauntedHouse(World world, int cposx, int cposy, int cposz) {
/* 1562 */     int deltax = 0, deltaz = 0;
/*      */     
/* 1564 */     int bid = 0;
/* 1565 */     int dirx = 0, dirz = 0;
/*      */     
/* 1567 */     int stuffdir = 0;
/* 1568 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */     
/* 1570 */     int length = 3, width = length;
/* 1571 */     int height = 3;
/*      */ 
/*      */     
/* 1574 */     deltax = 1;
/*      */     
/* 1576 */     stuffdir = 2;
/* 1577 */     int x = cposx, z = cposz, y = cposy;
/*      */ 
/*      */     
/* 1580 */     if (world.isRemote) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*      */     int i;
/*      */     
/* 1587 */     for (i = -width; i <= width; i++) {
/*      */       
/* 1589 */       for (int m = -length; m <= length; m++) {
/*      */         
/* 1591 */         for (int n = 0; n <= height + 1; n++) {
/*      */           
/* 1593 */           if (n == height + 1) {
/* 1594 */             world.setBlock(x + i, y + n, z + m, Blocks.planks);
/* 1595 */           } else if (n == 0) {
/* 1596 */             world.setBlock(x + i, y + n, z + m, Blocks.cobblestone);
/* 1597 */           } else if (i == width || m == length || i == -width || m == -length) {
/* 1598 */             if (n == height) {
/* 1599 */               world.setBlock(x + i, y + n, z + m, Blocks.glass);
/* 1600 */             } else if ((n == 1 || n == 2) && i == deltax * width && m == deltaz * length) {
/*      */               
/* 1602 */               world.setBlock(x + i, y + n, z + m, Blocks.air);
/*      */             } else {
/* 1604 */               world.setBlock(x + i, y + n, z + m, Blocks.planks);
/*      */             } 
/*      */           } else {
/* 1607 */             world.setBlock(x + i, y + n, z + m, Blocks.air);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1614 */     i = 2; int k = 1, j = length - 1;
/* 1615 */     world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, Blocks.furnace);
/* 1616 */     world.setBlockMetadataWithNotify(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, stuffdir, 3);
/* 1617 */     i = 1;
/* 1618 */     world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, Blocks.crafting_table);
/* 1619 */     i = 0;
/* 1620 */     world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, (Block)Blocks.chest);
/* 1621 */     world.setBlockMetadataWithNotify(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, stuffdir, 3);
/*      */     
/* 1623 */     TileEntityChest chest = getChestTileEntity(world, x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax);
/* 1624 */     if (chest != null) {
/*      */       
/* 1626 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(0, new ItemStack(Items.compass)); 
/* 1627 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(1, new ItemStack((Item)Items.map)); 
/* 1628 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(2, new ItemStack(Items.cooked_porkchop, 8)); 
/* 1629 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(3, new ItemStack(Item.getItemFromBlock(Blocks.torch), 32)); 
/* 1630 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(4, new ItemStack(Items.coal, 16)); 
/* 1631 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(5, new ItemStack(Items.bed)); 
/* 1632 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(6, new ItemStack(Items.bed)); 
/* 1633 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(7, new ItemStack(Items.wooden_door)); 
/* 1634 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(8, new ItemStack(Items.iron_pickaxe)); 
/* 1635 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(9, new ItemStack(Items.iron_sword)); 
/* 1636 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(10, new ItemStack(Items.iron_axe)); 
/* 1637 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(11, new ItemStack(Items.bucket)); 
/* 1638 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(12, new ItemStack(OreSpawnMain.MyOreSaltBlock, 4)); 
/* 1639 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(13, new ItemStack((Block)Blocks.chest));
/*      */     
/*      */     } 
/* 1642 */     world.setBlock(cposx, cposy + 1, cposz, Blocks.mob_spawner, 0, 2);
/* 1643 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 1, cposz);
/* 1644 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rat"); 
/* 1645 */     world.setBlock(cposx, cposy + 2, cposz, Blocks.mob_spawner, 0, 2);
/* 1646 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 2, cposz);
/* 1647 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ghost"); 
/* 1648 */     world.setBlock(cposx, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
/* 1649 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 3, cposz);
/* 1650 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ghost Pumpkin Skelly");
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeMantisHive(World world, int cposx, int cposy, int cposz) {
/* 1658 */     int width = 13;
/*      */     
/* 1660 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */ 
/*      */     
/* 1663 */     if (world.isRemote)
/*      */       return; 
/*      */     int i;
/* 1666 */     for (i = 0; i < width; i++) {
/* 1667 */       for (int k = 0; k < 20; k++) {
/* 1668 */         for (int m = 0; m < width; m++) {
/* 1669 */           FastSetBlock(world, cposx + i, cposy + k, cposz + m, Blocks.air);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1674 */     int yoff = 0, zoff = yoff, xoff = zoff;
/* 1675 */     for (; width > 0; width -= 2) {
/* 1676 */       for (i = 0; i < width; i++) {
/* 1677 */         for (int k = 0; k < width; k++) {
/* 1678 */           if (k == 0 || k == width - 1 || i == 0 || i == width - 1) {
/* 1679 */             Block blk = Blocks.gold_ore;
/* 1680 */             if ((yoff & 0x1) != 0) blk = Blocks.emerald_ore; 
/* 1681 */             FastSetBlock(world, cposx + i + xoff, cposy - yoff, cposz + k + zoff, blk);
/*      */           } else {
/* 1683 */             FastSetBlock(world, cposx + i + xoff, cposy - yoff, cposz + k + zoff, Blocks.air);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 1688 */       if (width <= 11 && width >= 7) fill_mantishive_chests(world, cposx + xoff, cposy - yoff, cposz + zoff, width, 0);
/*      */       
/* 1690 */       xoff++; zoff++; yoff++;
/*      */     } 
/*      */ 
/*      */     
/* 1694 */     xoff--; zoff--; yoff--;
/*      */     
/* 1696 */     for (int j = 4; j < 7; j++) {
/*      */       
/* 1698 */       world.setBlock(cposx + xoff, cposy + j - yoff, cposz + yoff, Blocks.mob_spawner, 0, 2);
/* 1699 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + xoff, cposy + j - yoff, cposz + yoff);
/* 1700 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Mantis");
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void fill_mantishive_chests(World world, int cposx, int cposy, int cposz, int width, int height) {
/* 1709 */     TileEntityChest chest = null;
/* 1710 */     WeightedRandomChestContent[] chestContents = null;
/*      */ 
/*      */     
/* 1713 */     chestContents = this.mantisContentsList;
/* 1714 */     int j = height;
/*      */     
/* 1716 */     world.setBlock(cposx + 1, cposy + j, cposz + width / 2, (Block)Blocks.chest, 0, 2);
/* 1717 */     world.setBlockMetadataWithNotify(cposx + 1, cposy + j, cposz + width / 2, 5, 3);
/* 1718 */     chest = getChestTileEntity(world, cposx + 1, cposy + j, cposz + width / 2);
/*      */     
/* 1720 */     if (chest != null)
/*      */     {
/* 1722 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(7));
/*      */     }
/*      */     
/* 1725 */     world.setBlock(cposx + width - 2, cposy + j, cposz + width / 2, (Block)Blocks.chest, 0, 2);
/* 1726 */     world.setBlockMetadataWithNotify(cposx + width - 2, cposy + j, cposz + width / 2, 4, 3);
/* 1727 */     chest = getChestTileEntity(world, cposx + width - 2, cposy + j, cposz + width / 2);
/*      */     
/* 1729 */     if (chest != null)
/*      */     {
/* 1731 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(7));
/*      */     }
/*      */     
/* 1734 */     world.setBlock(cposx + width / 2, cposy + j, cposz + 1, (Block)Blocks.chest, 0, 2);
/* 1735 */     world.setBlockMetadataWithNotify(cposx + width / 2, cposy + j, cposz + 1, 3, 3);
/* 1736 */     chest = getChestTileEntity(world, cposx + width / 2, cposy + j, cposz + 1);
/*      */     
/* 1738 */     if (chest != null)
/*      */     {
/* 1740 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(7));
/*      */     }
/*      */     
/* 1743 */     world.setBlock(cposx + width / 2, cposy + j, cposz + width - 2, (Block)Blocks.chest, 0, 2);
/* 1744 */     world.setBlockMetadataWithNotify(cposx + width / 2, cposy + j, cposz + width - 2, 2, 3);
/* 1745 */     chest = getChestTileEntity(world, cposx + width / 2, cposy + j, cposz + width - 2);
/*      */     
/* 1747 */     if (chest != null)
/*      */     {
/* 1749 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(7));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeKyuubiDungeon(World world, int cposx, int cposy, int cposz) {
/* 1757 */     int width = 5;
/* 1758 */     int height = 5;
/* 1759 */     int depth = 20;
/*      */     
/* 1761 */     int length = 12;
/* 1762 */     int rwidth = 30;
/* 1763 */     int rheight = 18;
/* 1764 */     int rlength = 20;
/*      */ 
/*      */     
/* 1767 */     if (world.isRemote)
/*      */       return; 
/*      */     int i;
/* 1770 */     for (i = 0; i < width; i++) {
/* 1771 */       for (int k = 0; k < 5; k++) {
/* 1772 */         for (int m = 0; m < width; m++) {
/* 1773 */           FastSetBlock(world, cposx + i, cposy - k, cposz + m, Blocks.air);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1779 */     int j = height;
/* 1780 */     for (i = 0; i < width; i++) {
/* 1781 */       for (int k = 0; k < width; k++) {
/* 1782 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.sandstone);
/*      */       }
/*      */     } 
/* 1785 */     FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2, Blocks.air);
/*      */     
/* 1787 */     Block blk = Blocks.sandstone;
/*      */     
/* 1789 */     for (i = 0; i < width; i++) {
/* 1790 */       for (int k = 0; k < width; k++) {
/* 1791 */         for (j = 0; j < height; j++) {
/* 1792 */           if (k == 0 || k == width - 1 || i == 0 || i == width - 1) {
/* 1793 */             FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
/*      */           } else {
/* 1795 */             FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1801 */     blk = Blocks.stone;
/*      */     
/* 1803 */     for (i = 0; i < width; i++) {
/* 1804 */       for (int k = 0; k < width; k++) {
/* 1805 */         for (j = -1; j > -depth; j--) {
/* 1806 */           if (k == 0 || k == width - 1 || i == 0 || i == width - 1) {
/* 1807 */             FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
/*      */           } else {
/* 1809 */             FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1816 */     for (i = 1; i < width - 1; i++) {
/* 1817 */       for (int k = 1; k < width - 1; k++) {
/* 1818 */         for (j = -depth; j > -(depth + 2); j--) {
/* 1819 */           FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.water);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1824 */     for (i = 1; i < width - 1; i++) {
/* 1825 */       for (int k = 1; k < width - 1; k++) {
/* 1826 */         j = -(depth + 2);
/* 1827 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.stone);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1832 */     int x = cposx + width + length - 2;
/* 1833 */     int z = cposz - rwidth / 2;
/* 1834 */     int y = cposy - depth;
/* 1835 */     blk = Blocks.netherrack;
/* 1836 */     for (i = 0; i < rlength; i++) {
/* 1837 */       for (int k = 0; k < rwidth; k++) {
/* 1838 */         for (j = 0; j < rheight; j++) {
/* 1839 */           if (k == 0 || k == rwidth - 1 || j == 0 || j == rheight - 1 || i == 0 || i == rlength - 1) {
/* 1840 */             FastSetBlock(world, x + i, y + j, z + k, blk);
/*      */           } else {
/* 1842 */             FastSetBlock(world, x + i, y + j, z + k, Blocks.air);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1849 */     x = cposx + width - 1;
/* 1850 */     z = cposz;
/* 1851 */     y = cposy - depth;
/*      */     
/* 1853 */     for (i = 0; i < length; i++) {
/* 1854 */       for (int k = 0; k < width; k++) {
/* 1855 */         for (j = 0; j < width; j++) {
/* 1856 */           if (k == 0 || k == width - 1 || j == 0 || j == width - 1) {
/* 1857 */             blk = Blocks.stone;
/* 1858 */             if (j > 0 && j < width - 1) blk = Blocks.lava; 
/* 1859 */             FastSetBlock(world, x + i, y + j, z + k, blk);
/*      */           } else {
/* 1861 */             FastSetBlock(world, x + i, y + j, z + k, Blocks.air);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1868 */     x = cposx + width + length - 2;
/* 1869 */     z = cposz - rwidth / 2;
/* 1870 */     y = cposy - depth;
/* 1871 */     y++;
/*      */     
/* 1873 */     addlavasquare(world, x + 2, y, z + 2);
/* 1874 */     addlavasquare(world, x + 4, y, z + 6);
/* 1875 */     addlavasquare(world, x + 12, y, z + 10);
/* 1876 */     addlavasquare(world, x + 6, y, z + 15);
/* 1877 */     addlavasquare(world, x + 3, y, z + 22);
/*      */     
/* 1879 */     addkyuubi(world, x + rlength / 4, y, z + rwidth * 3 / 4 - 3);
/* 1880 */     addblaze(world, x + rlength * 2 / 3 - 3, y, z + rwidth / 4 - 2);
/*      */     
/* 1882 */     FastSetBlock(world, x + 7, y, z + 1, (Block)Blocks.fire);
/* 1883 */     FastSetBlock(world, x + 5, y, z + 9, (Block)Blocks.fire);
/* 1884 */     FastSetBlock(world, x + 2, y, z + 12, (Block)Blocks.fire);
/* 1885 */     FastSetBlock(world, x + 16, y, z + 18, (Block)Blocks.fire);
/* 1886 */     FastSetBlock(world, x + 2, y, z + 27, (Block)Blocks.fire);
/* 1887 */     FastSetBlock(world, x + 18, y, z + 28, (Block)Blocks.fire);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void addlavasquare(World world, int x, int y, int z) {
/* 1893 */     FastSetBlock(world, x - 1, y, z, Blocks.netherrack);
/* 1894 */     FastSetBlock(world, x + 1, y, z, Blocks.netherrack);
/* 1895 */     FastSetBlock(world, x, y, z + 1, Blocks.netherrack);
/* 1896 */     FastSetBlock(world, x, y, z - 1, Blocks.netherrack);
/* 1897 */     FastSetBlock(world, x, y, z, Blocks.lava);
/*      */   }
/*      */   
/*      */   private void addkyuubi(World world, int x, int y, int z) {
/* 1901 */     int width = 9;
/*      */     
/* 1903 */     TileEntityChest chest = null;
/* 1904 */     WeightedRandomChestContent[] chestContents = null;
/* 1905 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */ 
/*      */ 
/*      */     
/* 1909 */     chestContents = this.kyuubiContentsList;
/*      */     int i;
/* 1911 */     for (i = 0; i < width; i++) {
/* 1912 */       for (int k = 0; k < width; k++) {
/* 1913 */         if (k == 0 || k == width - 1 || i == 0 || i == width - 1) {
/* 1914 */           FastSetBlock(world, x + i, y, z + k, Blocks.nether_brick);
/*      */         } else {
/* 1916 */           FastSetBlock(world, x + i, y, z + k, Blocks.lava);
/*      */         } 
/*      */       } 
/*      */     } 
/* 1920 */     width = 7;
/* 1921 */     for (i = 0; i < width; i++) {
/* 1922 */       for (int k = 0; k < width; k++) {
/* 1923 */         if (k == 0 || k == width - 1 || i == 0 || i == width - 1) {
/* 1924 */           FastSetBlock(world, x + i + 1, y + 1, z + k + 1, Blocks.nether_brick);
/*      */         } else {
/* 1926 */           FastSetBlock(world, x + i + 1, y + 1, z + k + 1, Blocks.lava);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1931 */     for (int j = 0; j < 3; j++) {
/*      */       
/* 1933 */       world.setBlock(x + 4, y + j + 2, z + 4, Blocks.mob_spawner, 0, 2);
/* 1934 */       tileentitymobspawner = getSpawnerTileEntity(world, x + 4, y + j + 2, z + 4);
/* 1935 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Kyuubi");
/*      */     
/*      */     } 
/*      */     
/* 1939 */     world.setBlock(x + 4, y + 5, z + 4, (Block)Blocks.chest, 0, 2);
/* 1940 */     world.setBlockMetadataWithNotify(x + 4, y + 5, z + 4, 2, 3);
/* 1941 */     chest = getChestTileEntity(world, x + 4, y + 5, z + 4);
/*      */     
/* 1943 */     if (chest != null)
/*      */     {
/* 1945 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 7 + world.rand.nextInt(7));
/*      */     }
/*      */   }
/*      */   
/*      */   private void addblaze(World world, int x, int y, int z) {
/* 1950 */     int width = 7;
/* 1951 */     int height = 4;
/*      */     
/* 1953 */     int xx = x;
/* 1954 */     int yy = y;
/* 1955 */     int zz = z;
/* 1956 */     TileEntityChest chest = null;
/* 1957 */     WeightedRandomChestContent[] chestContents = null;
/* 1958 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */ 
/*      */ 
/*      */     
/* 1962 */     chestContents = this.blazeContentsList;
/*      */     int i;
/* 1964 */     for (i = 0; i < width; i++) {
/* 1965 */       for (int k = 0; k < width; k++) {
/* 1966 */         for (int m = 0; m < height; m++) {
/* 1967 */           FastSetBlock(world, xx + i, yy + m, zz + k, Blocks.obsidian);
/*      */         }
/*      */       } 
/*      */     } 
/* 1971 */     xx++; yy += height; zz++;
/* 1972 */     width = 5;
/* 1973 */     height = 1;
/* 1974 */     for (i = 0; i < width; i++) {
/* 1975 */       for (int k = 0; k < width; k++) {
/* 1976 */         for (int m = 0; m < height; m++) {
/* 1977 */           FastSetBlock(world, xx + i, yy + m, zz + k, Blocks.obsidian);
/*      */         }
/*      */       } 
/*      */     } 
/* 1981 */     xx++; yy += height; zz++;
/* 1982 */     width = 3;
/* 1983 */     height = 6;
/* 1984 */     for (i = 0; i < width; i++) {
/* 1985 */       for (int k = 0; k < width; k++) {
/* 1986 */         for (int m = 0; m < height; m++) {
/* 1987 */           FastSetBlock(world, xx + i, yy + m, zz + k, Blocks.obsidian);
/*      */         }
/*      */       } 
/*      */     } 
/* 1991 */     xx++; yy += height; zz++;
/* 1992 */     width = 1;
/* 1993 */     height = 5;
/* 1994 */     for (i = 0; i < width; i++) {
/* 1995 */       for (int k = 0; k < width; k++) {
/* 1996 */         for (int m = 0; m < height; m++) {
/* 1997 */           FastSetBlock(world, xx + i, yy + m, zz + k, Blocks.obsidian);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2002 */     for (int j = 0; j < 2; j++) {
/*      */       
/* 2004 */       world.setBlock(xx - 1, yy + height + j - 3, zz, Blocks.mob_spawner, 0, 2);
/* 2005 */       tileentitymobspawner = getSpawnerTileEntity(world, xx - 1, yy + height + j - 3, zz);
/* 2006 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Blaze"); 
/* 2007 */       world.setBlock(xx + 1, yy + height + j - 3, zz, Blocks.mob_spawner, 0, 2);
/* 2008 */       tileentitymobspawner = getSpawnerTileEntity(world, xx + 1, yy + height + j - 3, zz);
/* 2009 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Blaze"); 
/* 2010 */       world.setBlock(xx, yy + height + j - 3, zz - 1, Blocks.mob_spawner, 0, 2);
/* 2011 */       tileentitymobspawner = getSpawnerTileEntity(world, xx, yy + height + j - 3, zz - 1);
/* 2012 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Blaze"); 
/* 2013 */       world.setBlock(xx, yy + height + j - 3, zz + 1, Blocks.mob_spawner, 0, 2);
/* 2014 */       tileentitymobspawner = getSpawnerTileEntity(world, xx, yy + height + j - 3, zz + 1);
/* 2015 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Blaze");
/*      */     
/*      */     } 
/* 2018 */     world.setBlock(x, y + 4, z + 3, (Block)Blocks.chest, 0, 2);
/* 2019 */     world.setBlockMetadataWithNotify(x, y + 4, z + 3, 4, 3);
/* 2020 */     chest = getChestTileEntity(world, x, y + 4, z + 3);
/* 2021 */     if (chest != null)
/*      */     {
/* 2023 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 4 + world.rand.nextInt(5));
/*      */     }
/*      */     
/* 2026 */     world.setBlock(x + 3, y + 4, z, (Block)Blocks.chest, 0, 2);
/* 2027 */     world.setBlockMetadataWithNotify(x + 3, y + 4, z, 2, 3);
/* 2028 */     chest = getChestTileEntity(world, x + 3, y + 4, z);
/* 2029 */     if (chest != null)
/*      */     {
/* 2031 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(5));
/*      */     }
/*      */     
/* 2034 */     world.setBlock(x + 3, y + 4, z + 6, (Block)Blocks.chest, 0, 2);
/* 2035 */     world.setBlockMetadataWithNotify(x + 3, y + 4, z + 6, 3, 3);
/* 2036 */     chest = getChestTileEntity(world, x + 3, y + 4, z + 6);
/* 2037 */     if (chest != null)
/*      */     {
/* 2039 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 5 + world.rand.nextInt(5));
/*      */     }
/*      */     
/* 2042 */     world.setBlock(x + 6, y + 4, z + 3, (Block)Blocks.chest, 0, 2);
/* 2043 */     world.setBlockMetadataWithNotify(x + 6, y + 4, z + 3, 5, 3);
/* 2044 */     chest = getChestTileEntity(world, x + 6, y + 4, z + 3);
/* 2045 */     if (chest != null)
/*      */     {
/* 2047 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 6 + world.rand.nextInt(5));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeSmallBeeHive(World world, int cposx, int cposy, int cposz) {
/* 2055 */     int width = 7;
/* 2056 */     int height = 21;
/* 2057 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 2058 */     TileEntityChest chest = null;
/* 2059 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 2061 */     if (world.isRemote)
/*      */       return; 
/*      */     int i;
/* 2064 */     for (i = -3; i < width + 3; i++) {
/* 2065 */       for (int k = height * 2 / 3; k < height; k++) {
/* 2066 */         for (int m = -3; m < width + 3; m++) {
/* 2067 */           FastSetBlock(world, cposx + i, cposy + k, cposz + m, Blocks.air);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2073 */     for (i = 0; i < width; i++) {
/* 2074 */       for (int k = 0; k < width; k++) {
/* 2075 */         int m = height * 2 / 3;
/* 2076 */         FastSetBlock(world, cposx + i, cposy + m, cposz + k, Blocks.sponge);
/* 2077 */         int n = world.rand.nextInt(height / 3);
/* 2078 */         n *= 2;
/* 2079 */         n -= Math.abs(i - width / 2);
/* 2080 */         n -= Math.abs(k - width / 2);
/* 2081 */         if (n < 1) n = 1; 
/* 2082 */         if (i == width / 2 && k == width / 2) n = height * 2 / 3; 
/* 2083 */         for (m = 0; m < n; m++) {
/* 2084 */           FastSetBlock(world, cposx + i, cposy + height * 2 / 3 - m, cposz + k, Blocks.mossy_cobblestone);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2092 */     int j = height * 2 / 3; int blk;
/* 2093 */     for (blk = 0; blk < height / 6; blk++) {
/* 2094 */       j++;
/* 2095 */       for (i = 0; i < width; i++) {
/* 2096 */         for (int k = 0; k < width; k++) {
/* 2097 */           if (k == 0 || i == 0 || k == width - 1 || i == width - 1) {
/* 2098 */             FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.sponge);
/*      */           } else {
/* 2100 */             FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
/*      */           } 
/*      */         } 
/*      */       } 
/* 2104 */       j++;
/* 2105 */       for (i = -1; i < width + 1; i++) {
/* 2106 */         for (int k = -1; k < width + 1; k++) {
/* 2107 */           if (k == -1 || i == -1 || k == width || i == width) {
/* 2108 */             FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.sponge);
/*      */           } else {
/* 2110 */             FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 2116 */     j++;
/* 2117 */     for (i = 0; i < width; i++) {
/* 2118 */       for (int k = 0; k < width; k++) {
/* 2119 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.sponge);
/*      */       }
/*      */     } 
/*      */     
/* 2123 */     j = height * 2 / 3 + 1;
/*      */     
/* 2125 */     for (i = -1; i < 1; i++) {
/* 2126 */       for (int k = 2; k < 4; k++) {
/* 2127 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
/* 2128 */         FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k, Blocks.air);
/* 2129 */         FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k, Blocks.air);
/*      */       } 
/*      */     } 
/*      */     
/* 2133 */     for (blk = 0; blk < 3; blk++) {
/*      */       
/* 2135 */       world.setBlock(cposx + 1, cposy + blk + j, cposz + 1, Blocks.mob_spawner, 0, 2);
/* 2136 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + 1, cposy + blk + j, cposz + 1);
/* 2137 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Bee");
/*      */     
/*      */     } 
/* 2140 */     chestContents = this.beeContentsList;
/* 2141 */     world.setBlock(cposx + width / 2, cposy + j, cposz + width / 2, (Block)Blocks.chest, 0, 2);
/* 2142 */     world.setBlockMetadataWithNotify(cposx + width / 2, cposy + j, cposz + width / 2, 5, 3);
/* 2143 */     chest = getChestTileEntity(world, cposx + width / 2, cposy + j, cposz + width / 2);
/* 2144 */     if (chest != null)
/*      */     {
/* 2146 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 7 + world.rand.nextInt(5));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeShadowDungeon(World world, int cposx, int cposy, int cposz) {
/* 2154 */     int totalwidth = 19;
/*      */ 
/*      */     
/* 2157 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 2158 */     String whichmob = null;
/*      */ 
/*      */ 
/*      */     
/* 2162 */     if (world.isRemote)
/*      */       return; 
/* 2164 */     int yoff = 0, zoff = yoff, xoff = zoff; int width;
/* 2165 */     for (width = totalwidth; width > 0; width -= 2) {
/* 2166 */       for (int i = 0; i < width; i++) {
/* 2167 */         for (int k = 0; k < width; k++) {
/* 2168 */           if (k == 0 || k == width - 1 || i == 0 || i == width - 1) {
/* 2169 */             Block blk = Blocks.obsidian;
/* 2170 */             if ((yoff & 0x1) != 0) blk = Blocks.bedrock; 
/* 2171 */             if ((k >= width / 2 - 1 && k <= width / 2 + 1) || (i >= width / 2 - 1 && i <= width / 2 + 1)) blk = Blocks.soul_sand; 
/* 2172 */             FastSetBlock(world, cposx + i + xoff, cposy - yoff, cposz + k + zoff, blk);
/*      */           } else {
/* 2174 */             FastSetBlock(world, cposx + i + xoff, cposy - yoff, cposz + k + zoff, Blocks.air);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 2179 */       if (width <= 15 && width >= 9) {
/* 2180 */         if ((yoff & 0x1) != 0) {
/* 2181 */           fill_shadow_chests(world, cposx + xoff, cposy - yoff, cposz + zoff, width, 0);
/* 2182 */           whichmob = "Ender Reaper";
/*      */         } else {
/* 2184 */           whichmob = "Nightmare";
/*      */         } 
/* 2186 */         world.setBlock(cposx + xoff + 1, cposy - yoff, cposz + zoff + 1, Blocks.mob_spawner, 0, 2);
/* 2187 */         tileentitymobspawner = getSpawnerTileEntity(world, cposx + xoff + 1, cposy - yoff, cposz + zoff + 1);
/* 2188 */         if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(whichmob); 
/* 2189 */         world.setBlock(cposx + xoff + width - 2, cposy - yoff, cposz + zoff + 1, Blocks.mob_spawner, 0, 2);
/* 2190 */         tileentitymobspawner = getSpawnerTileEntity(world, cposx + xoff + width - 2, cposy - yoff, cposz + zoff + 1);
/* 2191 */         if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(whichmob); 
/* 2192 */         world.setBlock(cposx + xoff + 1, cposy - yoff, cposz + zoff + width - 2, Blocks.mob_spawner, 0, 2);
/* 2193 */         tileentitymobspawner = getSpawnerTileEntity(world, cposx + xoff + 1, cposy - yoff, cposz + zoff + width - 2);
/* 2194 */         if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(whichmob); 
/* 2195 */         world.setBlock(cposx + xoff + width - 2, cposy - yoff, cposz + zoff + width - 2, Blocks.mob_spawner, 0, 2);
/* 2196 */         tileentitymobspawner = getSpawnerTileEntity(world, cposx + xoff + width - 2, cposy - yoff, cposz + zoff + width - 2);
/* 2197 */         if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(whichmob);
/*      */       
/*      */       } 
/* 2200 */       xoff++; zoff++; yoff++;
/*      */     } 
/* 2202 */     xoff = zoff = yoff = 0;
/* 2203 */     for (width = totalwidth; width > 0; width -= 2) {
/* 2204 */       for (int i = 0; i < width; i++) {
/* 2205 */         for (int k = 0; k < width; k++) {
/* 2206 */           if (k == 0 || k == width - 1 || i == 0 || i == width - 1) {
/* 2207 */             Block blk = Blocks.obsidian;
/* 2208 */             if ((yoff & 0x1) != 0) blk = Blocks.bedrock; 
/* 2209 */             FastSetBlock(world, cposx + i + xoff, cposy + yoff, cposz + k + zoff, blk);
/*      */           } else {
/* 2211 */             FastSetBlock(world, cposx + i + xoff, cposy + yoff, cposz + k + zoff, Blocks.air);
/*      */           } 
/*      */         } 
/*      */       } 
/* 2215 */       xoff++; zoff++; yoff++;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void fill_shadow_chests(World world, int cposx, int cposy, int cposz, int width, int height) {
/* 2222 */     TileEntityChest chest = null;
/* 2223 */     WeightedRandomChestContent[] chestContents = null;
/*      */ 
/*      */     
/* 2226 */     chestContents = this.shadowContentsList;
/* 2227 */     int j = height;
/*      */     
/* 2229 */     world.setBlock(cposx + 1, cposy + j, cposz + width / 2, (Block)Blocks.chest, 0, 2);
/* 2230 */     world.setBlockMetadataWithNotify(cposx + 1, cposy + j, cposz + width / 2, 5, 3);
/* 2231 */     chest = getChestTileEntity(world, cposx + 1, cposy + j, cposz + width / 2);
/*      */     
/* 2233 */     if (chest != null)
/*      */     {
/* 2235 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(7));
/*      */     }
/*      */     
/* 2238 */     world.setBlock(cposx + width - 2, cposy + j, cposz + width / 2, (Block)Blocks.chest, 0, 2);
/* 2239 */     world.setBlockMetadataWithNotify(cposx + width - 2, cposy + j, cposz + width / 2, 4, 3);
/* 2240 */     chest = getChestTileEntity(world, cposx + width - 2, cposy + j, cposz + width / 2);
/*      */     
/* 2242 */     if (chest != null)
/*      */     {
/* 2244 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(7));
/*      */     }
/*      */     
/* 2247 */     world.setBlock(cposx + width / 2, cposy + j, cposz + 1, (Block)Blocks.chest, 0, 2);
/* 2248 */     world.setBlockMetadataWithNotify(cposx + width / 2, cposy + j, cposz + 1, 3, 3);
/* 2249 */     chest = getChestTileEntity(world, cposx + width / 2, cposy + j, cposz + 1);
/*      */     
/* 2251 */     if (chest != null)
/*      */     {
/* 2253 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(7));
/*      */     }
/*      */     
/* 2256 */     world.setBlock(cposx + width / 2, cposy + j, cposz + width - 2, (Block)Blocks.chest, 0, 2);
/* 2257 */     world.setBlockMetadataWithNotify(cposx + width / 2, cposy + j, cposz + width - 2, 2, 3);
/* 2258 */     chest = getChestTileEntity(world, cposx + width / 2, cposy + j, cposz + width - 2);
/*      */     
/* 2260 */     if (chest != null)
/*      */     {
/* 2262 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(7));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeAlienWTFDungeon(World world, int cposx, int cposy, int cposz) {
/* 2270 */     int width = 5;
/* 2271 */     int height = 5;
/* 2272 */     int xwidth = 3;
/* 2273 */     int zwidth = 6;
/*      */     
/* 2275 */     int depth = 20;
/*      */ 
/*      */     
/* 2278 */     cposy -= depth - 3;
/*      */     int i;
/* 2280 */     for (i = 0; i < width; i++) {
/* 2281 */       for (int k = 0; k < height; k++) {
/* 2282 */         for (int m = 0; m < width; m++) {
/* 2283 */           if (i == 0 || k == 0 || m == 0 || i == width - 1 || k == height - 1 || m == width - 1) {
/*      */             
/* 2285 */             FastSetBlock(world, cposx + i - 2, cposy + k, cposz + m - 2, Blocks.lapis_ore);
/*      */           } else {
/* 2287 */             FastSetBlock(world, cposx + i - 2, cposy + k, cposz + m - 2, Blocks.air);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2294 */     int s = 0;
/* 2295 */     cposx--;
/* 2296 */     cposz--; int j;
/* 2297 */     for (j = 3; j < depth; j++) {
/* 2298 */       for (i = 0; i < 4; i++) {
/* 2299 */         for (int k = 0; k < 4; k++) {
/* 2300 */           Block blk = Blocks.air;
/* 2301 */           if (i == 0 || k == 0 || i == 3 || k == 3) blk = Blocks.lapis_ore; 
/* 2302 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, blk, 0, 2);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 2307 */       switch (s) {
/*      */         case 0:
/* 2309 */           OreSpawnMain.setBlockFast(world, cposx + 1, cposy + j, cposz + 1, Blocks.stone, 0, 2);
/*      */           break;
/*      */         case 1:
/* 2312 */           OreSpawnMain.setBlockFast(world, cposx + 2, cposy + j, cposz + 1, Blocks.stone, 0, 2);
/*      */           break;
/*      */         case 2:
/* 2315 */           OreSpawnMain.setBlockFast(world, cposx + 2, cposy + j, cposz + 2, Blocks.stone, 0, 2);
/*      */           break;
/*      */         default:
/* 2318 */           OreSpawnMain.setBlockFast(world, cposx + 1, cposy + j, cposz + 2, Blocks.stone, 0, 2);
/*      */           break;
/*      */       } 
/* 2321 */       s++;
/* 2322 */       if (s > 3) s = 0; 
/*      */     } 
/* 2324 */     cposx++;
/* 2325 */     cposz++;
/*      */ 
/*      */     
/* 2328 */     makePart(world, cposx, cposy, cposz + 7, 9, 5, 1, 1, 1);
/*      */     
/* 2330 */     for (i = 0; i < xwidth; i++) {
/* 2331 */       for (int k = 0; k < zwidth; k++) {
/* 2332 */         for (j = 0; j < 4; j++) {
/* 2333 */           Block blk = Blocks.air;
/* 2334 */           if (j == 0 || j == 3) blk = Blocks.lapis_ore; 
/* 2335 */           if (i == 0 || i == xwidth - 1) blk = Blocks.lapis_ore; 
/* 2336 */           FastSetBlock(world, cposx + i, cposy + j, cposz + k + 2, blk);
/*      */         } 
/*      */       } 
/*      */     } 
/* 2340 */     makePart(world, cposx + 7, cposy, cposz, 11, 6, 1, -1, 2);
/*      */     
/* 2342 */     xwidth = 6;
/* 2343 */     zwidth = 3;
/* 2344 */     for (i = 0; i < xwidth; i++) {
/* 2345 */       for (int k = 0; k < zwidth; k++) {
/* 2346 */         for (j = 0; j < 4; j++) {
/* 2347 */           Block blk = Blocks.air;
/* 2348 */           if (j == 0 || j == 3) blk = Blocks.lapis_ore; 
/* 2349 */           if (k == 0 || k == zwidth - 1) blk = Blocks.lapis_ore; 
/* 2350 */           FastSetBlock(world, cposx + i + 2, cposy + j, cposz - k, blk);
/*      */         } 
/*      */       } 
/*      */     } 
/* 2354 */     makePart(world, cposx - 7, cposy, cposz, 13, 7, -1, 1, 3);
/*      */     
/* 2356 */     xwidth = 6;
/* 2357 */     zwidth = 3;
/* 2358 */     for (i = 0; i < xwidth; i++) {
/* 2359 */       for (int k = 0; k < zwidth; k++) {
/* 2360 */         for (j = 0; j < 4; j++) {
/* 2361 */           Block blk = Blocks.air;
/* 2362 */           if (j == 0 || j == 3) blk = Blocks.lapis_ore; 
/* 2363 */           if (k == 0 || k == zwidth - 1) blk = Blocks.lapis_ore; 
/* 2364 */           FastSetBlock(world, cposx - i - 2, cposy + j, cposz + k, blk);
/*      */         } 
/*      */       } 
/*      */     } 
/* 2368 */     makePart(world, cposx, cposy, cposz - 7, 15, 8, -1, -1, 4);
/*      */     
/* 2370 */     xwidth = 3;
/* 2371 */     zwidth = 6;
/* 2372 */     for (i = 0; i < xwidth; i++) {
/* 2373 */       for (int k = 0; k < zwidth; k++) {
/* 2374 */         for (j = 0; j < 4; j++) {
/* 2375 */           Block blk = Blocks.air;
/* 2376 */           if (j == 0 || j == 3) blk = Blocks.lapis_ore; 
/* 2377 */           if (i == 0 || i == xwidth - 1) blk = Blocks.lapis_ore; 
/* 2378 */           FastSetBlock(world, cposx - i, cposy + j, cposz - k - 2, blk);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void makePart(World world, int cposx, int cposy, int cposz, int width, int height, int dx, int dz, int difficulty) {
/* 2388 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */     int i;
/* 2390 */     for (i = 0; i < width; i++) {
/* 2391 */       for (int m = 0; m < height; m++) {
/* 2392 */         for (int n = 0; n < width; n++) {
/* 2393 */           FastSetBlock(world, cposx + i * dx, cposy + m, cposz + n * dz, Blocks.air);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2399 */     for (i = 0; i < width; i++) {
/* 2400 */       int m = 0;
/* 2401 */       for (int n = 0; n < width; n++) {
/* 2402 */         Block blk = Blocks.quartz_block;
/* 2403 */         if (i == width / 2 || n == width / 2) blk = Blocks.obsidian; 
/* 2404 */         FastSetBlock(world, cposx + i * dx, cposy + m, cposz + n * dz, blk);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2409 */     for (i = 0; i < width; i++) {
/* 2410 */       int m = height;
/* 2411 */       for (int n = 0; n < width; n++) {
/* 2412 */         Block blk = Blocks.obsidian;
/* 2413 */         FastSetBlock(world, cposx + i * dx, cposy + m, cposz + n * dz, blk);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2418 */     for (i = 0; i < width; i++) {
/* 2419 */       for (int m = 0; m < height; m++) {
/* 2420 */         Block blk = Blocks.obsidian;
/* 2421 */         int n = 0;
/* 2422 */         FastSetBlock(world, cposx + i * dx, cposy + m, cposz + n * dz, blk);
/* 2423 */         n = width - 1;
/* 2424 */         FastSetBlock(world, cposx + i * dx, cposy + m, cposz + n * dz, blk);
/*      */       } 
/*      */     } 
/*      */     
/* 2428 */     for (int k = 0; k < width; k++) {
/* 2429 */       for (int m = 0; m < height; m++) {
/* 2430 */         i = 0;
/* 2431 */         FastSetBlock(world, cposx + i * dx, cposy + m, cposz + k * dz, Blocks.obsidian);
/* 2432 */         i = width - 1;
/* 2433 */         FastSetBlock(world, cposx + i * dx, cposy + m, cposz + k * dz, Blocks.obsidian);
/*      */       } 
/*      */     } 
/*      */     
/* 2437 */     for (int j = 0; j < difficulty; j++) {
/*      */       
/* 2439 */       world.setBlock(cposx + dx * width / 2, cposy + j + 2, cposz + dz * width / 2, Blocks.mob_spawner, 0, 2);
/* 2440 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + dx * width / 2, cposy + j + 2, cposz + dz * width / 2);
/* 2441 */       if (tileentitymobspawner != null) {
/*      */         
/* 2443 */         int t = world.rand.nextInt(2);
/* 2444 */         if (t == 0) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Alien"); 
/* 2445 */         if (t == 1) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("WTF?"); 
/*      */       } 
/* 2447 */       world.setBlock(cposx + dx * width / 2 + dx, cposy + j + 2, cposz + dz * width / 2 + dz, Blocks.mob_spawner, 0, 2);
/* 2448 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + dx * width / 2 + dx, cposy + j + 2, cposz + dz * width / 2 + dz);
/* 2449 */       if (tileentitymobspawner != null) {
/*      */         
/* 2451 */         int t = world.rand.nextInt(2);
/* 2452 */         if (t == 0) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Alien"); 
/* 2453 */         if (t == 1) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("WTF?");
/*      */       
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2461 */     TileEntityChest chest = null;
/* 2462 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 2464 */     chestContents = this.AlienWTFContentsList;
/*      */     
/* 2466 */     world.setBlock(cposx + width * dx / 2, cposy + 1, cposz + dz, (Block)Blocks.chest, 0, 2);
/* 2467 */     chest = getChestTileEntity(world, cposx + width * dx / 2, cposy + 1, cposz + dz);
/* 2468 */     if (chest != null)
/*      */     {
/*      */       
/* 2471 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(5));
/*      */     }
/* 2473 */     if (difficulty > 1) {
/* 2474 */       world.setBlock(cposx + width * dx / 2, cposy + 1, cposz + (width - 2) * dz, (Block)Blocks.chest, 0, 2);
/* 2475 */       chest = getChestTileEntity(world, cposx + width * dx / 2, cposy + 1, cposz + (width - 2) * dz);
/* 2476 */       if (chest != null)
/*      */       {
/*      */         
/* 2479 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(5));
/*      */       }
/*      */     } 
/* 2482 */     if (difficulty > 2) {
/* 2483 */       world.setBlock(cposx + dx, cposy + 1, cposz + width / 2 * dz, (Block)Blocks.chest, 0, 2);
/* 2484 */       chest = getChestTileEntity(world, cposx + dx, cposy + 1, cposz + width / 2 * dz);
/* 2485 */       if (chest != null)
/*      */       {
/*      */         
/* 2488 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(5));
/*      */       }
/*      */     } 
/* 2491 */     if (difficulty > 3) {
/* 2492 */       world.setBlock(cposx + (width - 2) * dx, cposy + 1, cposz + width / 2 * dz, (Block)Blocks.chest, 0, 2);
/* 2493 */       chest = getChestTileEntity(world, cposx + (width - 2) * dx, cposy + 1, cposz + width / 2 * dz);
/* 2494 */       if (chest != null)
/*      */       {
/*      */         
/* 2497 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(5));
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeEnderKnightDungeon(World world, int cposx, int cposy, int cposz) {
/* 2505 */     int height = 6;
/* 2506 */     int zwidth = 5;
/*      */ 
/*      */     
/* 2509 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */     
/* 2511 */     for (int i = 0; i < 4; i++) {
/* 2512 */       for (int j = 0; j < 5; j++) {
/* 2513 */         for (int n = 0; n < 5; n++) {
/* 2514 */           FastSetBlock(world, cposx, cposy + n, cposz + j, Blocks.air);
/*      */         }
/*      */       } 
/* 2517 */       cposx++;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2522 */     zwidth = 5; int k;
/* 2523 */     for (k = 0; k < zwidth; k++) {
/* 2524 */       for (int j = 0; j < height; j++) {
/* 2525 */         Block blk = Blocks.obsidian;
/* 2526 */         if (k == 2 && j >= 1 && j <= 3) blk = Blocks.air; 
/* 2527 */         FastSetBlock(world, cposx, cposy + j, cposz + k, blk);
/*      */       } 
/*      */     } 
/* 2530 */     cposx++;
/* 2531 */     cposz--;
/* 2532 */     zwidth = 7;
/* 2533 */     for (k = 0; k < zwidth; k++) {
/* 2534 */       for (int j = 0; j < height; j++) {
/* 2535 */         Block blk = Blocks.air;
/* 2536 */         if (j == 0 || j == height - 1) blk = Blocks.obsidian; 
/* 2537 */         if (j == 0 && k > 0 && k < zwidth - 1) blk = Blocks.end_stone; 
/* 2538 */         if (k == 0 || k == zwidth - 1) blk = Blocks.obsidian; 
/* 2539 */         FastSetBlock(world, cposx, cposy + j, cposz + k, blk);
/*      */       } 
/* 2541 */       if (k == 1 || k == 2 || k == zwidth - 3 || k == zwidth - 2) {
/* 2542 */         makeShelves(world, cposx, cposy + 1, cposz + k);
/*      */       }
/*      */     } 
/* 2545 */     cposz--;
/* 2546 */     for (int m = 0; m < 5; m++) {
/* 2547 */       cposx++;
/* 2548 */       zwidth = 9;
/* 2549 */       for (k = 0; k < zwidth; k++) {
/* 2550 */         for (int j = 0; j < height; j++) {
/* 2551 */           Block blk = Blocks.air;
/* 2552 */           if (j == 0 || j == height - 1) blk = Blocks.obsidian; 
/* 2553 */           if (j == 0 && k > 0 && k < zwidth - 1) blk = Blocks.end_stone; 
/* 2554 */           if (k == 0 || k == zwidth - 1) blk = Blocks.obsidian; 
/* 2555 */           FastSetBlock(world, cposx, cposy + j, cposz + k, blk);
/*      */         } 
/* 2557 */         if (k == 1 || k == 2 || k == zwidth - 3 || k == zwidth - 2) {
/* 2558 */           makeShelves(world, cposx, cposy + 1, cposz + k);
/*      */         }
/* 2560 */         if (m == 2 && k == 4) {
/* 2561 */           world.setBlock(cposx, cposy + 2, cposz + k, Blocks.mob_spawner, 0, 2);
/* 2562 */           tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 2, cposz + k);
/* 2563 */           if (tileentitymobspawner != null)
/*      */           {
/* 2565 */             tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Knight");
/*      */           }
/* 2567 */           world.setBlock(cposx, cposy + 3, cposz + k, Blocks.mob_spawner, 0, 2);
/* 2568 */           tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 3, cposz + k);
/* 2569 */           if (tileentitymobspawner != null)
/*      */           {
/* 2571 */             tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Knight");
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/* 2576 */     cposz++;
/* 2577 */     cposx++;
/* 2578 */     zwidth = 7;
/* 2579 */     for (k = 0; k < zwidth; k++) {
/* 2580 */       for (int j = 0; j < height; j++) {
/* 2581 */         Block blk = Blocks.air;
/* 2582 */         if (j == 0 || j == height - 1) blk = Blocks.obsidian; 
/* 2583 */         if (j == 0 && k > 0 && k < zwidth - 1) blk = Blocks.end_stone; 
/* 2584 */         if (k == 0 || k == zwidth - 1) blk = Blocks.obsidian; 
/* 2585 */         FastSetBlock(world, cposx, cposy + j, cposz + k, blk);
/*      */       } 
/* 2587 */       if (k == 1 || k == 2 || k == zwidth - 3 || k == zwidth - 2) {
/* 2588 */         makeShelves(world, cposx, cposy + 1, cposz + k);
/*      */       }
/*      */     } 
/* 2591 */     cposz++;
/* 2592 */     cposx++;
/* 2593 */     zwidth = 5;
/* 2594 */     for (k = 0; k < zwidth; k++) {
/* 2595 */       for (int j = 0; j < height; j++) {
/* 2596 */         Block blk = Blocks.obsidian;
/* 2597 */         FastSetBlock(world, cposx, cposy + j, cposz + k, blk);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void makeShelves(World world, int cposx, int cposy, int cposz) {
/* 2609 */     int i = world.rand.nextInt(4);
/* 2610 */     Block blk = Blocks.air;
/* 2611 */     if (i == 0) {
/* 2612 */       TileEntityChest chest = null;
/* 2613 */       WeightedRandomChestContent[] chestContents = null;
/*      */       
/* 2615 */       chestContents = this.KnightContentsList;
/*      */       
/* 2617 */       world.setBlock(cposx, cposy, cposz, (Block)Blocks.chest, 0, 2);
/* 2618 */       chest = getChestTileEntity(world, cposx, cposy, cposz);
/* 2619 */       if (chest != null)
/*      */       {
/*      */         
/* 2622 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(5));
/*      */       }
/*      */     } 
/* 2625 */     if (i == 1) {
/* 2626 */       blk = Blocks.bookshelf;
/* 2627 */       int k = 1 + world.rand.nextInt(4);
/* 2628 */       for (int j = 0; j < k; j++)
/* 2629 */         FastSetBlock(world, cposx, cposy + j, cposz, blk); 
/*      */     } 
/* 2631 */     if (i == 2) {
/* 2632 */       blk = Blocks.web;
/* 2633 */       int k = 1 + world.rand.nextInt(4);
/* 2634 */       for (int j = 0; j < k; j++) {
/* 2635 */         FastSetBlock(world, cposx, cposy + j, cposz, blk);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makePlayPool(World world, int cposx, int cposy, int cposz) {
/* 2644 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 2645 */     TileEntityChest chest = null;
/* 2646 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 2648 */     chestContents = this.SquidContentsList;
/*      */     int i;
/* 2650 */     for (i = 0; i < 4; i++) {
/* 2651 */       world.setBlock(cposx + i, cposy + 16, cposz, Blocks.mob_spawner, 0, 2);
/* 2652 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + 16, cposz);
/* 2653 */       if (tileentitymobspawner != null)
/*      */       {
/* 2655 */         tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Attack Squid");
/*      */       }
/*      */     } 
/*      */     
/* 2659 */     world.setBlock(cposx + 1, cposy + 17, cposz, (Block)Blocks.chest, 0, 2);
/* 2660 */     world.setBlock(cposx + 2, cposy + 17, cposz, (Block)Blocks.chest, 0, 2);
/* 2661 */     chest = getChestTileEntity(world, cposx + 1, cposy + 17, cposz);
/* 2662 */     if (chest != null)
/*      */     {
/*      */       
/* 2665 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(5));
/*      */     }
/*      */     
/* 2668 */     for (i = 0; i < 4; i++) {
/* 2669 */       world.setBlock(cposx + i, cposy + 18, cposz, Blocks.water, 0, 3);
/*      */     }
/* 2671 */     world.setBlock(cposx - 1, cposy + 18, cposz, (Block)Blocks.flowing_water, 0, 3);
/* 2672 */     world.setBlock(cposx + 4, cposy + 18, cposz, (Block)Blocks.flowing_water, 0, 3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeWaterDragonLair(World world, int cposx, int cposy, int cposz) {
/* 2681 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 2682 */     TileEntityChest chest = null;
/* 2683 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 2685 */     chestContents = this.WaterDragonContentsList;
/*      */ 
/*      */     
/* 2688 */     float radius = 10.0F; float currad;
/* 2689 */     for (currad = 0.0F; currad < radius; currad += 0.33F) {
/* 2690 */       float f; for (f = 0.0F; f < 360.0F; f += 5.0F) {
/* 2691 */         float curx = (float)(currad * Math.cos(Math.toRadians(f)));
/* 2692 */         float curz = (float)(currad * Math.sin(Math.toRadians(f)));
/* 2693 */         Block blk = Blocks.bedrock;
/* 2694 */         if (currad > 5.0F && currad < 6.0F) blk = Blocks.iron_block; 
/* 2695 */         FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 7, (int)(cposz + curz + 0.5F), blk);
/*      */       } 
/*      */     }  int i;
/* 2698 */     for (i = 1; i < 10; i++) {
/* 2699 */       FastSetBlock(world, (int)((cposx + i) + 0.5F), cposy + 7, (int)(cposz + 0.5F), Blocks.iron_block);
/* 2700 */       FastSetBlock(world, (int)((cposx - i) + 0.5F), cposy + 7, (int)(cposz + 0.5F), Blocks.iron_block);
/* 2701 */       FastSetBlock(world, (int)(cposx + 0.5F), cposy + 7, (int)((cposz + i) + 0.5F), Blocks.iron_block);
/* 2702 */       FastSetBlock(world, (int)(cposx + 0.5F), cposy + 7, (int)((cposz - i) + 0.5F), Blocks.iron_block);
/*      */     } 
/* 2704 */     FastSetBlock(world, (int)(cposx + 0.5F), cposy + 7, (int)(cposz + 0.5F), Blocks.air);
/* 2705 */     FastSetBlock(world, (int)((cposx + 1) + 0.5F), cposy + 7, (int)(cposz + 0.5F), Blocks.glowstone);
/* 2706 */     FastSetBlock(world, (int)((cposx - 1) + 0.5F), cposy + 7, (int)(cposz + 0.5F), Blocks.glowstone);
/* 2707 */     FastSetBlock(world, (int)(cposx + 0.5F), cposy + 7, (int)((cposz + 1) + 0.5F), Blocks.glowstone);
/* 2708 */     FastSetBlock(world, (int)(cposx + 0.5F), cposy + 7, (int)((cposz - 1) + 0.5F), Blocks.glowstone);
/*      */     
/* 2710 */     currad = 10.0F; float curdeg;
/* 2711 */     for (curdeg = 0.0F; curdeg < 360.0F; curdeg += 5.0F) {
/* 2712 */       float curx = (float)(currad * Math.cos(Math.toRadians(curdeg)));
/* 2713 */       float curz = (float)(currad * Math.sin(Math.toRadians(curdeg)));
/* 2714 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 1, (int)(cposz + curz + 0.5F), Blocks.glowstone);
/* 2715 */       Block blk = Blocks.lapis_block;
/* 2716 */       if (world.rand.nextInt(2) == 0) blk = OreSpawnMain.MyWaterDragonSpawnBlock; 
/* 2717 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 2, (int)(cposz + curz + 0.5F), blk);
/* 2718 */       blk = Blocks.lapis_block;
/* 2719 */       if (world.rand.nextInt(2) == 0) blk = OreSpawnMain.MyWaterDragonSpawnBlock; 
/* 2720 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 3, (int)(cposz + curz + 0.5F), blk);
/* 2721 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 4, (int)(cposz + curz + 0.5F), Blocks.glowstone);
/* 2722 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 5, (int)(cposz + curz + 0.5F), Blocks.bedrock);
/* 2723 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 6, (int)(cposz + curz + 0.5F), Blocks.bedrock);
/*      */     } 
/*      */     
/* 2726 */     for (i = -3; i <= 3; i++) {
/* 2727 */       for (int j = -3; j <= 3; j++) {
/* 2728 */         FastSetBlock(world, cposx + i, cposy, cposz + j, (Block)Blocks.sand);
/* 2729 */         FastSetBlock(world, cposx + i, cposy - 1, cposz + j, Blocks.stone);
/*      */       } 
/*      */     } 
/* 2732 */     for (i = -2; i <= 2; i++) {
/* 2733 */       for (int j = -2; j <= 2; j++) {
/* 2734 */         FastSetBlock(world, cposx + i, cposy + 3, cposz + j, (Block)Blocks.leaves);
/*      */       }
/*      */     } 
/* 2737 */     FastSetBlock(world, cposx, cposy + 4, cposz, (Block)Blocks.leaves);
/* 2738 */     FastSetBlock(world, cposx, cposy + 3, cposz, Blocks.log);
/* 2739 */     FastSetBlock(world, cposx, cposy + 2, cposz, Blocks.log);
/* 2740 */     FastSetBlock(world, cposx, cposy + 1, cposz, Blocks.log);
/*      */     
/* 2742 */     FastSetBlock(world, cposx + 1, cposy + 3, cposz + 1, Blocks.log);
/* 2743 */     FastSetBlock(world, cposx - 1, cposy + 3, cposz - 1, Blocks.log);
/* 2744 */     FastSetBlock(world, cposx + 1, cposy + 3, cposz - 1, Blocks.log);
/* 2745 */     FastSetBlock(world, cposx - 1, cposy + 3, cposz + 1, Blocks.log);
/*      */     
/* 2747 */     world.setBlock(cposx + 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
/* 2748 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 1, cposy + 3, cposz);
/* 2749 */     if (tileentitymobspawner != null)
/*      */     {
/* 2751 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Water Dragon");
/*      */     }
/* 2753 */     world.setBlock(cposx - 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
/* 2754 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - 1, cposy + 3, cposz);
/* 2755 */     if (tileentitymobspawner != null)
/*      */     {
/* 2757 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Water Dragon");
/*      */     }
/* 2759 */     world.setBlock(cposx, cposy + 3, cposz + 1, Blocks.mob_spawner, 0, 2);
/* 2760 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 3, cposz + 1);
/* 2761 */     if (tileentitymobspawner != null)
/*      */     {
/* 2763 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Water Dragon");
/*      */     }
/* 2765 */     world.setBlock(cposx, cposy + 3, cposz - 1, Blocks.mob_spawner, 0, 2);
/* 2766 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 3, cposz - 1);
/* 2767 */     if (tileentitymobspawner != null)
/*      */     {
/* 2769 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Water Dragon");
/*      */     }
/*      */ 
/*      */     
/* 2773 */     world.setBlock(cposx, cposy + 1, cposz - 1, (Block)Blocks.chest, 0, 2);
/* 2774 */     chest = getChestTileEntity(world, cposx, cposy + 1, cposz - 1);
/* 2775 */     if (chest != null)
/*      */     {
/*      */       
/* 2778 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 4 + world.rand.nextInt(5));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeCloudSharkDungeon(World world, int cposx, int cposy, int cposz) {
/* 2786 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 2787 */     TileEntityChest chest = null;
/* 2788 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 2790 */     chestContents = this.CloudSharkContentsList;
/*      */     
/* 2792 */     FastSetBlock(world, cposx, cposy, cposz, Blocks.glowstone);
/* 2793 */     FastSetBlock(world, cposx, cposy - 1, cposz, Blocks.glowstone);
/*      */ 
/*      */     
/* 2796 */     world.setBlock(cposx + 1, cposy, cposz, Blocks.mob_spawner, 0, 2);
/* 2797 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 1, cposy, cposz);
/* 2798 */     if (tileentitymobspawner != null)
/*      */     {
/* 2800 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Cloud Shark");
/*      */     }
/* 2802 */     world.setBlock(cposx - 1, cposy, cposz, Blocks.mob_spawner, 0, 2);
/* 2803 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - 1, cposy, cposz);
/* 2804 */     if (tileentitymobspawner != null)
/*      */     {
/* 2806 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Cloud Shark");
/*      */     }
/* 2808 */     world.setBlock(cposx, cposy, cposz + 1, Blocks.mob_spawner, 0, 2);
/* 2809 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy, cposz + 1);
/* 2810 */     if (tileentitymobspawner != null)
/*      */     {
/* 2812 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Cloud Shark");
/*      */     }
/* 2814 */     world.setBlock(cposx, cposy, cposz - 1, Blocks.mob_spawner, 0, 2);
/* 2815 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy, cposz - 1);
/* 2816 */     if (tileentitymobspawner != null)
/*      */     {
/* 2818 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Cloud Shark");
/*      */     }
/*      */     
/* 2821 */     world.setBlock(cposx, cposy + 1, cposz, (Block)Blocks.chest, 0, 2);
/* 2822 */     chest = getChestTileEntity(world, cposx, cposy + 1, cposz);
/* 2823 */     if (chest != null)
/*      */     {
/*      */       
/* 2826 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 4 + world.rand.nextInt(5));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeLeafMonsterDungeon(World world, int cposx, int cposy, int cposz) {
/* 2838 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 2839 */     TileEntityChest chest = null;
/* 2840 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 2842 */     chestContents = this.LeafMonsterContentsList;
/*      */     
/*      */     int i;
/* 2845 */     for (i = -2; i < 6; i++) {
/* 2846 */       for (int k = -3; k < 2; k++) {
/* 2847 */         for (int j = 0; j < 4; j++) {
/* 2848 */           FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2853 */     for (i = 0; i < 4; i++) {
/* 2854 */       for (int k = 0; k < 4; k++) {
/* 2855 */         for (int j = -1; j > -5; j--) {
/* 2856 */           Block blk = Blocks.log;
/* 2857 */           Block bid = world.getBlock(cposx + i, cposy + j, cposz + k);
/* 2858 */           if (bid == Blocks.air || bid == Blocks.tallgrass) {
/* 2859 */             FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2866 */     for (i = 0; i < 4; i++) {
/* 2867 */       for (int k = 0; k < 4; k++) {
/* 2868 */         for (int j = 0; j < 10; j++) {
/* 2869 */           Block blk = Blocks.log;
/* 2870 */           if (j < 2 && (k == 0 || k == 1) && (i == 1 || i == 2)) blk = Blocks.air; 
/* 2871 */           if (k == 1 && (i == 1 || i == 2)) blk = Blocks.air; 
/* 2872 */           if (k != 2 || (i != 1 && i != 2))
/*      */           {
/*      */             
/* 2875 */             FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/* 2880 */     for (i = 0; i < 4; i++) {
/* 2881 */       for (int k = 0; k < 4; k++) {
/* 2882 */         for (int j = 0; j < 10; j++) {
/* 2883 */           if (k == 2 && (i == 1 || i == 2)) {
/* 2884 */             Block blk = Blocks.ladder;
/* 2885 */             world.setBlock(cposx + i, cposy + j, cposz + k, blk, 2, 3);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 2890 */     FastSetBlock(world, cposx + 1, cposy + 2, cposz - 1, (Block)Blocks.leaves);
/* 2891 */     FastSetBlock(world, cposx + 2, cposy + 2, cposz - 1, (Block)Blocks.leaves);
/*      */     
/* 2893 */     for (i = -3; i < 7; i++) {
/* 2894 */       for (int k = -3; k < 7; k++) {
/* 2895 */         int j = 9;
/* 2896 */         if (i < 0 || i > 3 || k < 0 || k > 3) {
/* 2897 */           BlockLeaves blockLeaves; Block blk = Blocks.log;
/* 2898 */           if (i == -3 || i == 6 || k == -3 || k == 6) blockLeaves = Blocks.leaves; 
/* 2899 */           FastSetBlock(world, cposx + i, cposy + j, cposz + k, (Block)blockLeaves);
/*      */         } 
/*      */       } 
/* 2902 */     }  for (i = -3; i < 7; i++) {
/* 2903 */       for (int k = -3; k < 7; k++) {
/* 2904 */         for (int j = 10; j < 13; j++) {
/* 2905 */           BlockLeaves blockLeaves; Block blk = Blocks.air;
/* 2906 */           if (i == -3 || i == 6 || k == -3 || k == 6) blockLeaves = Blocks.leaves; 
/* 2907 */           FastSetBlock(world, cposx + i, cposy + j, cposz + k, (Block)blockLeaves);
/*      */         } 
/*      */       } 
/*      */     } 
/* 2911 */     for (i = -2; i < 6; i++) {
/* 2912 */       for (int k = -2; k < 6; k++) {
/* 2913 */         BlockLeaves blockLeaves; int j = 13;
/* 2914 */         Block blk = Blocks.air;
/* 2915 */         if (i == -2 || i == 5 || k == -2 || k == 5) blk = Blocks.log; 
/* 2916 */         if (i == -1 || i == 4 || k == -1 || k == 4) blockLeaves = Blocks.leaves; 
/* 2917 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, (Block)blockLeaves);
/*      */       } 
/*      */     } 
/* 2920 */     for (i = -1; i < 5; i++) {
/* 2921 */       for (int k = -1; k < 5; k++) {
/* 2922 */         int j = 14;
/* 2923 */         BlockLeaves blockLeaves = Blocks.leaves;
/* 2924 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, (Block)blockLeaves);
/*      */       } 
/*      */     } 
/* 2927 */     for (i = 0; i < 4; i++) {
/* 2928 */       for (int k = 0; k < 4; k++) {
/* 2929 */         int j = 15;
/* 2930 */         Block blk = Blocks.log;
/* 2931 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
/*      */       } 
/*      */     } 
/* 2934 */     for (i = 1; i < 3; i++) {
/* 2935 */       for (int k = 1; k < 3; k++) {
/* 2936 */         int j = 16;
/* 2937 */         BlockLeaves blockLeaves = Blocks.leaves;
/* 2938 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, (Block)blockLeaves);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2944 */     world.setBlock(cposx - 2, cposy + 10, cposz - 2, Blocks.mob_spawner, 0, 2);
/* 2945 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - 2, cposy + 10, cposz - 2);
/* 2946 */     if (tileentitymobspawner != null)
/*      */     {
/* 2948 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Leaf Monster");
/*      */     }
/* 2950 */     world.setBlock(cposx + 5, cposy + 10, cposz + 5, Blocks.mob_spawner, 0, 2);
/* 2951 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 5, cposy + 10, cposz + 5);
/* 2952 */     if (tileentitymobspawner != null)
/*      */     {
/* 2954 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Leaf Monster");
/*      */     }
/* 2956 */     world.setBlock(cposx - 2, cposy + 10, cposz + 5, Blocks.mob_spawner, 0, 2);
/* 2957 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - 2, cposy + 10, cposz + 5);
/* 2958 */     if (tileentitymobspawner != null)
/*      */     {
/* 2960 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Leaf Monster");
/*      */     }
/* 2962 */     world.setBlock(cposx + 5, cposy + 10, cposz - 2, Blocks.mob_spawner, 0, 2);
/* 2963 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 5, cposy + 10, cposz - 2);
/* 2964 */     if (tileentitymobspawner != null)
/*      */     {
/* 2966 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Leaf Monster");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2971 */     world.setBlock(cposx + 1, cposy + 10, cposz + 5, (Block)Blocks.chest, 0, 2);
/* 2972 */     world.setBlock(cposx + 2, cposy + 10, cposz + 5, (Block)Blocks.chest, 0, 2);
/*      */     
/* 2974 */     chest = getChestTileEntity(world, cposx + 1, cposy + 10, cposz + 5);
/* 2975 */     if (chest != null)
/*      */     {
/*      */       
/* 2978 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 12 + world.rand.nextInt(5));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeMiniDungeon(World world, int cposx, int cposy, int cposz) {
/* 2988 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 2989 */     TileEntityChest chest = null;
/* 2990 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 2992 */     chestContents = this.MiniContentsList;
/*      */     
/*      */     int i;
/* 2995 */     for (i = 0; i < 10; i++) {
/* 2996 */       for (int n = 0; n < 10; n++) {
/* 2997 */         for (int i1 = 0; i1 < 7; i1++) {
/* 2998 */           Block blk = Blocks.air;
/* 2999 */           if (i == 0 || n == 0 || i == 9 || n == 9) blk = Blocks.iron_bars; 
/* 3000 */           if (i == 0 && n == 0) blk = Blocks.cobblestone; 
/* 3001 */           if (i == 9 && n == 9) blk = Blocks.cobblestone; 
/* 3002 */           if (i == 0 && n == 9) blk = Blocks.cobblestone; 
/* 3003 */           if (i == 9 && n == 0) blk = Blocks.cobblestone; 
/* 3004 */           if (i1 == 0) blk = Blocks.cobblestone; 
/* 3005 */           if (i1 == 6 && (i == 0 || n == 0 || i == 9 || n == 9)) blk = Blocks.cobblestone; 
/* 3006 */           FastSetBlock(world, cposx + i, cposy + i1, cposz + n, blk);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 3011 */     for (i = 1; i < 9; i++) {
/* 3012 */       for (int n = 1; n < 9; n++) {
/* 3013 */         BlockGrass blockGrass; int i1 = 7;
/* 3014 */         Block blk = Blocks.air;
/* 3015 */         if (i == 1 || i == 8 || n == 1 || n == 8) blockGrass = Blocks.grass; 
/* 3016 */         FastSetBlock(world, cposx + i, cposy + i1, cposz + n, (Block)blockGrass);
/*      */       } 
/*      */     } 
/*      */     
/* 3020 */     for (i = 2; i < 8; i++) {
/* 3021 */       for (int n = 2; n < 8; n++) {
/* 3022 */         BlockGrass blockGrass; int i1 = 8;
/* 3023 */         Block blk = Blocks.air;
/* 3024 */         if (i == 2 || i == 7 || n == 2 || n == 7) blockGrass = Blocks.grass; 
/* 3025 */         FastSetBlock(world, cposx + i, cposy + i1, cposz + n, (Block)blockGrass);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 3030 */     i = -6;
/* 3031 */     int j = 1;
/* 3032 */     int k = 3;
/*      */     
/* 3034 */     for (int m = 0; m < 6; m++) {
/* 3035 */       FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.planks);
/* 3036 */       FastSetBlock(world, cposx + i, cposy + j, cposz + k + 1, Blocks.planks);
/* 3037 */       FastSetBlock(world, cposx + i, cposy + j, cposz + k + 2, Blocks.planks);
/* 3038 */       FastSetBlock(world, cposx + i, cposy + j, cposz + k + 3, Blocks.planks);
/*      */       
/* 3040 */       FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k, Blocks.fence);
/* 3041 */       FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + 3, Blocks.fence);
/* 3042 */       FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k, Blocks.torch);
/* 3043 */       FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k + 3, Blocks.torch);
/* 3044 */       i++;
/* 3045 */       j++;
/*      */     } 
/*      */ 
/*      */     
/* 3049 */     for (i = 3; i < 7; i++) {
/* 3050 */       for (k = 3; k < 7; k++) {
/* 3051 */         j = 9;
/* 3052 */         Block blk = Blocks.air;
/* 3053 */         if (i == 3 || i == 6 || k == 3 || k == 6) {
/* 3054 */           world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3055 */           tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3056 */           if (tileentitymobspawner != null)
/*      */           {
/* 3058 */             tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Butterfly");
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 3066 */     i = k = 0;
/* 3067 */     for (j = 7; j < 11; j++) {
/* 3068 */       FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.cobblestone);
/*      */     }
/* 3070 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3071 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3072 */     if (tileentitymobspawner != null)
/*      */     {
/* 3074 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Terrible Terror");
/*      */     }
/* 3076 */     i = k = 9;
/* 3077 */     for (j = 7; j < 11; j++) {
/* 3078 */       FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.cobblestone);
/*      */     }
/* 3080 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3081 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3082 */     if (tileentitymobspawner != null)
/*      */     {
/* 3084 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Butterfly");
/*      */     }
/* 3086 */     i = 0;
/* 3087 */     k = 9;
/* 3088 */     for (j = 7; j < 11; j++) {
/* 3089 */       FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.cobblestone);
/*      */     }
/* 3091 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3092 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3093 */     if (tileentitymobspawner != null)
/*      */     {
/* 3095 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Terrible Terror");
/*      */     }
/* 3097 */     i = 9;
/* 3098 */     k = 0;
/* 3099 */     for (j = 7; j < 11; j++) {
/* 3100 */       FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.cobblestone);
/*      */     }
/* 3102 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3103 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3104 */     if (tileentitymobspawner != null)
/*      */     {
/* 3106 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Butterfly");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 3111 */     i = k = 1;
/* 3112 */     j = 1;
/* 3113 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3114 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3115 */     if (tileentitymobspawner != null)
/*      */     {
/* 3117 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Terrible Terror");
/*      */     }
/* 3119 */     i = k = 8;
/* 3120 */     j = 1;
/* 3121 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3122 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3123 */     if (tileentitymobspawner != null)
/*      */     {
/* 3125 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Terrible Terror");
/*      */     }
/* 3127 */     i = 8;
/* 3128 */     k = 1;
/* 3129 */     j = 1;
/* 3130 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3131 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3132 */     if (tileentitymobspawner != null)
/*      */     {
/* 3134 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Butterfly");
/*      */     }
/* 3136 */     i = 1;
/* 3137 */     k = 8;
/* 3138 */     j = 1;
/* 3139 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3140 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3141 */     if (tileentitymobspawner != null)
/*      */     {
/* 3143 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Butterfly");
/*      */     }
/*      */     
/* 3146 */     i = 4;
/* 3147 */     k = 4;
/* 3148 */     j = 1;
/* 3149 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3150 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3151 */     if (tileentitymobspawner != null)
/*      */     {
/* 3153 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Lurking Terror");
/*      */     }
/* 3155 */     i = 5;
/* 3156 */     k = 5;
/* 3157 */     j = 1;
/* 3158 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3159 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3160 */     if (tileentitymobspawner != null)
/*      */     {
/* 3162 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Lurking Terror");
/*      */     }
/*      */ 
/*      */     
/* 3166 */     world.setBlock(cposx + 3, cposy + 1, cposz + 3, (Block)Blocks.chest, 0, 2);
/*      */     
/* 3168 */     chest = getChestTileEntity(world, cposx + 3, cposy + 1, cposz + 3);
/* 3169 */     if (chest != null)
/*      */     {
/*      */       
/* 3172 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 4 + world.rand.nextInt(5));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeGoldFishBowl(World world, int cposx, int cposy, int cposz) {
/* 3182 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */ 
/*      */     
/* 3185 */     int j = 1;
/* 3186 */     Block blk = Blocks.glass; int i;
/* 3187 */     for (i = 0; i < 5; i++) {
/* 3188 */       for (int m = 0; m < 5; m++) {
/* 3189 */         FastSetBlock(world, cposx + i, cposy + j, cposz + m, blk);
/*      */       }
/*      */     } 
/* 3192 */     j = 2;
/* 3193 */     for (i = -1; i < 6; i++) {
/* 3194 */       for (int m = -1; m < 6; m++) {
/* 3195 */         Block block; BlockSand blockSand = Blocks.sand;
/* 3196 */         if (i == -1 || m == -1 || i == 5 || m == 5) block = Blocks.glass; 
/* 3197 */         FastSetBlock(world, cposx + i, cposy + j, cposz + m, block);
/*      */       } 
/*      */     } 
/* 3200 */     j = 3;
/* 3201 */     for (i = -1; i < 6; i++) {
/* 3202 */       for (int m = -1; m < 6; m++) {
/* 3203 */         blk = Blocks.water;
/* 3204 */         if (i == -1 || m == -1 || i == 5 || m == 5) blk = Blocks.glass; 
/* 3205 */         FastSetBlock(world, cposx + i, cposy + j, cposz + m, blk);
/*      */       } 
/*      */     } 
/* 3208 */     int k = 0;
/* 3209 */     i = 0;
/* 3210 */     blk = Blocks.glowstone;
/* 3211 */     FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
/* 3212 */     k = 4;
/* 3213 */     i = 4;
/* 3214 */     FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
/* 3215 */     k = 4;
/* 3216 */     i = 0;
/* 3217 */     FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
/* 3218 */     k = 0;
/* 3219 */     i = 4;
/* 3220 */     FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
/* 3221 */     j = 4;
/* 3222 */     for (i = -1; i < 6; i++) {
/* 3223 */       for (k = -1; k < 6; k++) {
/* 3224 */         blk = Blocks.water;
/* 3225 */         if (i == -1 || k == -1 || i == 5 || k == 5) blk = Blocks.glass; 
/* 3226 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
/*      */       } 
/*      */     } 
/* 3229 */     for (j = 5; j < 8; j++) {
/* 3230 */       for (i = -1; i < 6; i++) {
/* 3231 */         for (k = -1; k < 6; k++) {
/* 3232 */           blk = Blocks.air;
/* 3233 */           if (i == -1 || k == -1 || i == 5 || k == 5) blk = Blocks.glass; 
/* 3234 */           FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
/*      */         } 
/*      */       } 
/*      */     } 
/* 3238 */     j = 8;
/* 3239 */     blk = Blocks.glass;
/* 3240 */     for (i = 0; i < 5; i++) {
/* 3241 */       for (k = 0; k < 5; k++) {
/* 3242 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
/*      */       }
/*      */     } 
/*      */     
/* 3246 */     i = 2;
/* 3247 */     k = 2;
/* 3248 */     j = 6;
/* 3249 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3250 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3251 */     if (tileentitymobspawner != null)
/*      */     {
/* 3253 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Gold Fish");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeEnderReaperGraveyard(World world, int cposx, int cposy, int cposz) {
/* 3262 */     int width = 11;
/* 3263 */     int length = 13;
/*      */     
/* 3265 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */     
/*      */     int j;
/* 3268 */     for (j = 1; j < 5; j++) {
/* 3269 */       for (int m = 0; m < width; m++) {
/* 3270 */         for (int n = 0; n < length; n++) {
/* 3271 */           if (world.getBlock(cposx + m, cposy - j, cposz + n) == Blocks.air) {
/* 3272 */             FastSetBlock(world, cposx + m, cposy - j, cposz + n, Blocks.end_stone);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 3278 */     j = 0;
/* 3279 */     Block blk = Blocks.end_stone; int i;
/* 3280 */     for (i = 0; i < width; i++) {
/* 3281 */       for (int m = 0; m < length; m++) {
/* 3282 */         FastSetBlock(world, cposx + i, cposy + j, cposz + m, blk);
/*      */       }
/*      */     } 
/*      */     
/* 3286 */     for (j = 1; j < 5; j++) {
/* 3287 */       for (i = 0; i < width; i++) {
/* 3288 */         for (int m = 0; m < length; m++) {
/* 3289 */           blk = Blocks.air;
/* 3290 */           if (i == 0 || m == 0 || i == width - 1 || m == length - 1) blk = Blocks.iron_bars; 
/* 3291 */           FastSetBlock(world, cposx + i, cposy + j, cposz + m, blk);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 3297 */     i = 1;
/* 3298 */     int k = 1;
/* 3299 */     j = 1;
/* 3300 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3301 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3302 */     if (tileentitymobspawner != null)
/*      */     {
/* 3304 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Reaper");
/*      */     }
/* 3306 */     i = width - 2;
/* 3307 */     k = length - 2;
/* 3308 */     j = 1;
/* 3309 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3310 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3311 */     if (tileentitymobspawner != null)
/*      */     {
/* 3313 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Reaper");
/*      */     }
/* 3315 */     i = 1;
/* 3316 */     k = length - 2;
/* 3317 */     j = 1;
/* 3318 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3319 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3320 */     if (tileentitymobspawner != null)
/*      */     {
/* 3322 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Reaper");
/*      */     }
/* 3324 */     i = width - 2;
/* 3325 */     k = 1;
/* 3326 */     j = 1;
/* 3327 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3328 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3329 */     if (tileentitymobspawner != null)
/*      */     {
/* 3331 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Reaper");
/*      */     }
/*      */     
/* 3334 */     makeAGrave(world, cposx, cposy, cposz, 1, 6);
/* 3335 */     makeAGrave(world, cposx, cposy, cposz, 3, 4);
/* 3336 */     makeAGrave(world, cposx, cposy, cposz, 5, 4);
/* 3337 */     makeAGrave(world, cposx, cposy, cposz, 7, 4);
/* 3338 */     makeAGrave(world, cposx, cposy, cposz, 3, 8);
/* 3339 */     makeAGrave(world, cposx, cposy, cposz, 5, 8);
/* 3340 */     makeAGrave(world, cposx, cposy, cposz, 7, 8);
/* 3341 */     makeAGrave(world, cposx, cposy, cposz, 9, 6);
/*      */   }
/*      */ 
/*      */   
/*      */   public void makeAGrave(World world, int cposx, int cposy, int cposz, int xoff, int zoff) {
/* 3346 */     TileEntityChest chest = null;
/* 3347 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 3349 */     chestContents = this.GraveContentsList;
/*      */     
/* 3351 */     FastSetBlock(world, cposx + xoff, cposy + 1, cposz + zoff - 1, Blocks.obsidian);
/* 3352 */     FastSetBlock(world, cposx + xoff, cposy, cposz + zoff + 1, Blocks.obsidian);
/*      */     
/* 3354 */     world.setBlock(cposx + xoff, cposy, cposz + zoff, (Block)Blocks.chest, 0, 2);
/*      */     
/* 3356 */     chest = getChestTileEntity(world, cposx + xoff, cposy, cposz + zoff);
/* 3357 */     if (chest != null)
/*      */     {
/*      */       
/* 3360 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(3));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeUrchinSpawner(World world, int cposx, int cposy, int cposz) {
/* 3372 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 3373 */     TileEntityChest chest = null;
/*      */     
/* 3375 */     int patchy = 3;
/*      */     
/* 3377 */     for (int i = 0; i < patchy; i++) {
/* 3378 */       Block bid = OreSpawnMain.CrystalStone;
/* 3379 */       if (i == 1) bid = OreSpawnMain.CrystalCrystal; 
/* 3380 */       if (i == 2) bid = OreSpawnMain.TigersEye; 
/* 3381 */       float dx = world.rand.nextFloat() - world.rand.nextFloat();
/* 3382 */       float dz = world.rand.nextFloat() - world.rand.nextFloat();
/* 3383 */       float dy = 0.5F + world.rand.nextFloat() / 2.0F;
/* 3384 */       int width = world.rand.nextInt(2);
/* 3385 */       int length = 10 + width * 3 + world.rand.nextInt(5);
/* 3386 */       if (i != 0) length /= 2; 
/* 3387 */       float rx = cposx;
/* 3388 */       float ry = cposy;
/* 3389 */       float rz = cposz;
/* 3390 */       for (int iy = 0; iy <= length; iy++) {
/* 3391 */         for (int ix = 0; ix <= width; ix++) {
/* 3392 */           for (int iz = 0; iz <= width; iz++) {
/* 3393 */             OreSpawnMain.setBlockFast(world, (int)(rx + ix), (int)ry, (int)(rz + iz), bid, 0, 2);
/*      */           }
/*      */         } 
/* 3396 */         ry += dy;
/* 3397 */         rx += dx;
/* 3398 */         rz += dz;
/*      */       } 
/*      */     } 
/*      */     
/* 3402 */     world.setBlock(cposx, cposy + 1, cposz, Blocks.mob_spawner, 0, 2);
/* 3403 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 1, cposz);
/* 3404 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Crystal Urchin"); 
/* 3405 */     world.setBlock(cposx, cposy + 2, cposz, Blocks.mob_spawner, 0, 2);
/* 3406 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 2, cposz);
/* 3407 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Crystal Urchin"); 
/* 3408 */     world.setBlock(cposx, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
/* 3409 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 3, cposz);
/* 3410 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Crystal Urchin");
/*      */     
/* 3412 */     world.setBlock(cposx, cposy, cposz, Blocks.air, 0, 2);
/*      */     
/* 3414 */     world.setBlock(cposx, cposy - 1, cposz, (Block)Blocks.chest, 0, 2);
/* 3415 */     world.setBlockMetadataWithNotify(cposx, cposy - 1, cposz, 2, 3);
/* 3416 */     chest = getChestTileEntity(world, cposx, cposy - 1, cposz);
/*      */     
/* 3418 */     if (chest != null) {
/*      */       
/* 3420 */       chest.setInventorySlotContents(1, new ItemStack(OreSpawnMain.UrchinEgg, 1 + world.rand.nextInt(5), 0));
/* 3421 */       chest.setInventorySlotContents(2, new ItemStack(OreSpawnMain.CrystalCoal, 4 + world.rand.nextInt(16), 0));
/* 3422 */       chest.setInventorySlotContents(3, new ItemStack(OreSpawnMain.CrystalCoal, 4 + world.rand.nextInt(16), 0));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeSpitBugLair(World world, int cposx, int cposy, int cposz) {
/* 3429 */     int green = 5;
/* 3430 */     int dark_green = 13;
/* 3431 */     int width = 9;
/* 3432 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 3433 */     TileEntityChest chest = null;
/* 3434 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 3436 */     chestContents = this.SpitBugContentsList;
/*      */     int i;
/* 3438 */     for (i = 0; i < width; i++) {
/*      */       
/* 3440 */       OreSpawnMain.setBlockFast(world, cposx + i, cposy + width - i + 2, cposz, Blocks.stained_hardened_clay, dark_green, 2);
/* 3441 */       OreSpawnMain.setBlockFast(world, cposx + i, cposy + width - i + 1, cposz, Blocks.stained_hardened_clay, dark_green, 2);
/* 3442 */       OreSpawnMain.setBlockFast(world, cposx + i, cposy + width - i, cposz, Blocks.mossy_cobblestone, 0, 2);
/*      */       
/* 3444 */       OreSpawnMain.setBlockFast(world, cposx - i, cposy + width - i + 2, cposz, Blocks.stained_hardened_clay, dark_green, 2);
/* 3445 */       OreSpawnMain.setBlockFast(world, cposx - i, cposy + width - i + 1, cposz, Blocks.stained_hardened_clay, dark_green, 2);
/* 3446 */       OreSpawnMain.setBlockFast(world, cposx - i, cposy + width - i, cposz, Blocks.mossy_cobblestone, 0, 2);
/*      */     } 
/*      */     
/* 3449 */     OreSpawnMain.setBlockFast(world, cposx, cposy + width + 3, cposz, Blocks.emerald_ore, 0, 2);
/* 3450 */     OreSpawnMain.setBlockFast(world, cposx, cposy + width + 2, cposz, Blocks.emerald_ore, 0, 2);
/* 3451 */     OreSpawnMain.setBlockFast(world, cposx, cposy + width + 1, cposz, Blocks.emerald_ore, 0, 2);
/* 3452 */     world.setBlock(cposx, cposy + width + 0, cposz, Blocks.mob_spawner, 0, 2);
/* 3453 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + width + 0, cposz);
/* 3454 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Spit Bug"); 
/* 3455 */     world.setBlock(cposx, cposy + width - 1, cposz, Blocks.mob_spawner, 0, 2);
/* 3456 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + width - 1, cposz);
/* 3457 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Spit Bug"); 
/* 3458 */     world.setBlock(cposx, cposy + width - 2, cposz, Blocks.mob_spawner, 0, 2);
/* 3459 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + width - 2, cposz);
/* 3460 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Spit Bug");
/*      */     
/* 3462 */     int k = 0;
/* 3463 */     for (i = 0; i < width; i++) {
/* 3464 */       for (int j = -i; j <= i; j++) {
/* 3465 */         OreSpawnMain.setBlockFast(world, cposx - width + i + 1, cposy, cposz + j, Blocks.stained_hardened_clay, green, 2);
/* 3466 */         OreSpawnMain.setBlockFast(world, cposx + width - i - 1, cposy, cposz + j, Blocks.stained_hardened_clay, green, 2);
/* 3467 */         if (j == -i || j == i) {
/* 3468 */           OreSpawnMain.setBlockFast(world, cposx - width + i + 1, cposy + 1, cposz + j, Blocks.stained_hardened_clay, dark_green, 2);
/* 3469 */           OreSpawnMain.setBlockFast(world, cposx + width - i - 1, cposy + 1, cposz + j, Blocks.stained_hardened_clay, dark_green, 2);
/* 3470 */           OreSpawnMain.setBlockFast(world, cposx - width + i + 1, cposy + 2, cposz + j, Blocks.stonebrick, 3, 2);
/* 3471 */           OreSpawnMain.setBlockFast(world, cposx + width - i - 1, cposy + 2, cposz + j, Blocks.stonebrick, 3, 2);
/*      */         } else {
/* 3473 */           OreSpawnMain.setBlockFast(world, cposx - width + i + 1, cposy + 1, cposz + j, Blocks.air, 0, 2);
/* 3474 */           OreSpawnMain.setBlockFast(world, cposx + width - i - 1, cposy + 1, cposz + j, Blocks.air, 0, 2);
/* 3475 */           OreSpawnMain.setBlockFast(world, cposx - width + i + 1, cposy + 2, cposz + j, Blocks.air, 0, 2);
/* 3476 */           OreSpawnMain.setBlockFast(world, cposx + width - i - 1, cposy + 2, cposz + j, Blocks.air, 0, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 3481 */     world.setBlock(cposx, cposy + 1, cposz, (Block)Blocks.chest, 0, 2);
/*      */     
/* 3483 */     chest = getChestTileEntity(world, cposx, cposy + 1, cposz);
/* 3484 */     if (chest != null)
/*      */     {
/*      */       
/* 3487 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 4 + world.rand.nextInt(4));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeIgloo(World world, int cposx, int cposy, int cposz) {
/* 3497 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 3498 */     TileEntityChest chest = null;
/*      */ 
/*      */     
/* 3501 */     float currad = 6.0F; float curdeg;
/* 3502 */     for (curdeg = 0.0F; curdeg < 360.0F; curdeg += 5.0F) {
/* 3503 */       float curx = (float)(currad * Math.cos(Math.toRadians(curdeg)));
/* 3504 */       float curz = (float)(currad * Math.sin(Math.toRadians(curdeg)));
/* 3505 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 1, (int)(cposz + curz + 0.5F), Blocks.snow);
/* 3506 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 2, (int)(cposz + curz + 0.5F), Blocks.ice);
/* 3507 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 3, (int)(cposz + curz + 0.5F), Blocks.snow);
/*      */     } 
/*      */     
/* 3510 */     currad = 5.0F;
/* 3511 */     for (curdeg = 0.0F; curdeg < 360.0F; curdeg += 5.0F) {
/* 3512 */       float curx = (float)(currad * Math.cos(Math.toRadians(curdeg)));
/* 3513 */       float curz = (float)(currad * Math.sin(Math.toRadians(curdeg)));
/* 3514 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 4, (int)(cposz + curz + 0.5F), Blocks.ice);
/*      */     } 
/* 3516 */     currad = 4.0F;
/* 3517 */     for (curdeg = 0.0F; curdeg < 360.0F; curdeg += 5.0F) {
/* 3518 */       float curx = (float)(currad * Math.cos(Math.toRadians(curdeg)));
/* 3519 */       float curz = (float)(currad * Math.sin(Math.toRadians(curdeg)));
/* 3520 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 5, (int)(cposz + curz + 0.5F), Blocks.snow);
/*      */     } 
/* 3522 */     currad = 3.0F;
/* 3523 */     for (curdeg = 0.0F; curdeg < 360.0F; curdeg += 10.0F) {
/* 3524 */       float curx = (float)(currad * Math.cos(Math.toRadians(curdeg)));
/* 3525 */       float curz = (float)(currad * Math.sin(Math.toRadians(curdeg)));
/* 3526 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 5, (int)(cposz + curz + 0.5F), Blocks.ice);
/*      */     } 
/* 3528 */     currad = 2.0F;
/* 3529 */     for (curdeg = 0.0F; curdeg < 360.0F; curdeg += 15.0F) {
/* 3530 */       float curx = (float)(currad * Math.cos(Math.toRadians(curdeg)));
/* 3531 */       float curz = (float)(currad * Math.sin(Math.toRadians(curdeg)));
/* 3532 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 5, (int)(cposz + curz + 0.5F), Blocks.snow);
/*      */     } 
/* 3534 */     currad = 1.0F;
/* 3535 */     for (curdeg = 0.0F; curdeg < 360.0F; curdeg += 15.0F) {
/* 3536 */       float curx = (float)(currad * Math.cos(Math.toRadians(curdeg)));
/* 3537 */       float curz = (float)(currad * Math.sin(Math.toRadians(curdeg)));
/* 3538 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + 5, (int)(cposz + curz + 0.5F), Blocks.ice);
/*      */     } 
/* 3540 */     FastSetBlock(world, (int)(cposx - 6.0F + 0.5F), cposy, (int)(cposz + 0.5F), Blocks.planks);
/* 3541 */     FastSetBlock(world, (int)(cposx - 6.0F + 0.5F), cposy + 1, (int)(cposz + 0.5F), Blocks.air);
/* 3542 */     FastSetBlock(world, (int)(cposx - 6.0F + 0.5F), cposy + 2, (int)(cposz + 0.5F), Blocks.air);
/* 3543 */     ItemDoor.placeDoorBlock(world, (int)(cposx - 6.0F + 0.5F), cposy + 1, (int)(cposz + 0.5F), 2, Blocks.wooden_door);
/*      */ 
/*      */     
/* 3546 */     world.setBlock(cposx + 2, cposy + 1, cposz - 4, Blocks.mob_spawner, 0, 2);
/* 3547 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 2, cposy + 1, cposz - 4);
/* 3548 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rat"); 
/* 3549 */     world.setBlock(cposx - 1, cposy + 1, cposz + 1, Blocks.mob_spawner, 0, 2);
/* 3550 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - 1, cposy + 1, cposz + 1);
/* 3551 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ghost"); 
/* 3552 */     world.setBlock(cposx + 3, cposy + 1, cposz + 4, Blocks.mob_spawner, 0, 2);
/* 3553 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 3, cposy + 1, cposz + 4);
/* 3554 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ghost Pumpkin Skelly");
/*      */ 
/*      */     
/* 3557 */     world.setBlock(cposx - 3, cposy + 1, cposz - 3, (Block)Blocks.chest, 2, 2);
/* 3558 */     chest = getChestTileEntity(world, cposx - 3, cposy + 1, cposz - 3);
/* 3559 */     if (chest != null) {
/*      */       
/* 3561 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(0, new ItemStack(Items.compass)); 
/* 3562 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(1, new ItemStack((Item)Items.map)); 
/* 3563 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(2, new ItemStack(Items.cooked_porkchop, 8)); 
/* 3564 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(3, new ItemStack(Blocks.torch, 32)); 
/* 3565 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(4, new ItemStack(Items.coal, 16)); 
/* 3566 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(5, new ItemStack(Items.bed)); 
/* 3567 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(6, new ItemStack(Items.bed)); 
/* 3568 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(7, new ItemStack(Items.wooden_door)); 
/* 3569 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(8, new ItemStack(Items.iron_pickaxe)); 
/* 3570 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(9, new ItemStack(Items.iron_sword)); 
/* 3571 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(10, new ItemStack(Items.iron_axe)); 
/* 3572 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(11, new ItemStack(Items.bucket));
/*      */       
/* 3574 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(13, new ItemStack((Block)Blocks.chest)); 
/* 3575 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(14, new ItemStack(Items.gold_nugget, 6)); 
/* 3576 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(15, new ItemStack(Items.gold_nugget, 8)); 
/* 3577 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(16, new ItemStack(Items.gold_nugget, 10));
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeEnderDragonHospital(World world, int cposx, int cposy, int cposz) {
/* 3587 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 3588 */     TileEntityChest chest = null;
/* 3589 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 3591 */     chestContents = this.HospitalContentsList;
/*      */     
/*      */     int i;
/* 3594 */     for (i = 0; i < 10; i++) {
/* 3595 */       for (int n = 0; n < 10; n++) {
/* 3596 */         for (int i1 = 0; i1 < 7; i1++) {
/* 3597 */           Block blk = Blocks.air;
/* 3598 */           if (i == 0 || n == 0 || i == 9 || n == 9) blk = Blocks.iron_bars; 
/* 3599 */           if (i == 0 && n == 0) blk = Blocks.obsidian; 
/* 3600 */           if (i == 9 && n == 9) blk = Blocks.obsidian; 
/* 3601 */           if (i == 0 && n == 9) blk = Blocks.obsidian; 
/* 3602 */           if (i == 9 && n == 0) blk = Blocks.obsidian; 
/* 3603 */           if (i1 == 0) blk = Blocks.end_stone; 
/* 3604 */           if (i1 == 6 && (i == 0 || n == 0 || i == 9 || n == 9)) blk = Blocks.end_stone; 
/* 3605 */           FastSetBlock(world, cposx + i, cposy + i1, cposz + n, blk);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 3610 */     for (i = 1; i < 9; i++) {
/* 3611 */       for (int n = 1; n < 9; n++) {
/* 3612 */         int i1 = 7;
/* 3613 */         Block blk = Blocks.air;
/* 3614 */         if (i == 1 || i == 8 || n == 1 || n == 8) blk = OreSpawnMain.MyEyeOfEnderBlock; 
/* 3615 */         FastSetBlock(world, cposx + i, cposy + i1, cposz + n, blk);
/*      */       } 
/*      */     } 
/* 3618 */     for (i = 2; i < 8; i++) {
/* 3619 */       for (int n = 2; n < 8; n++) {
/* 3620 */         int i1 = 8;
/* 3621 */         Block blk = Blocks.air;
/* 3622 */         if (i == 2 || i == 7 || n == 2 || n == 7) blk = OreSpawnMain.MyEyeOfEnderBlock; 
/* 3623 */         FastSetBlock(world, cposx + i, cposy + i1, cposz + n, blk);
/*      */       } 
/*      */     } 
/* 3626 */     for (i = 3; i < 7; i++) {
/* 3627 */       for (int n = 3; n < 7; n++) {
/* 3628 */         int i1 = 9;
/* 3629 */         Block blk = Blocks.air;
/* 3630 */         if (i == 3 || i == 6 || n == 3 || n == 6) blk = OreSpawnMain.MyEyeOfEnderBlock; 
/* 3631 */         FastSetBlock(world, cposx + i, cposy + i1, cposz + n, blk);
/*      */       } 
/*      */     } 
/*      */     
/* 3635 */     i = -6;
/* 3636 */     int j = 1;
/* 3637 */     int k = 3;
/*      */     
/* 3639 */     for (int m = 0; m < 6; m++) {
/* 3640 */       FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.end_stone);
/* 3641 */       FastSetBlock(world, cposx + i, cposy + j, cposz + k + 1, Blocks.end_stone);
/* 3642 */       FastSetBlock(world, cposx + i, cposy + j, cposz + k + 2, Blocks.end_stone);
/* 3643 */       FastSetBlock(world, cposx + i, cposy + j, cposz + k + 3, Blocks.end_stone);
/*      */       
/* 3645 */       FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k, Blocks.iron_bars);
/* 3646 */       FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + 3, Blocks.iron_bars);
/* 3647 */       FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k, Blocks.glowstone);
/* 3648 */       FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k + 3, Blocks.glowstone);
/* 3649 */       i++;
/* 3650 */       j++;
/*      */     } 
/*      */ 
/*      */     
/* 3654 */     FastSetBlock(world, cposx + 0, cposy + 7, cposz + 0, Blocks.obsidian);
/* 3655 */     FastSetBlock(world, cposx + 0, cposy + 7, cposz + 9, Blocks.obsidian);
/* 3656 */     FastSetBlock(world, cposx + 9, cposy + 7, cposz + 0, Blocks.obsidian);
/* 3657 */     FastSetBlock(world, cposx + 9, cposy + 7, cposz + 9, Blocks.obsidian);
/* 3658 */     FastSetBlock(world, cposx + 0, cposy + 8, cposz + 0, Blocks.obsidian);
/* 3659 */     FastSetBlock(world, cposx + 0, cposy + 8, cposz + 9, Blocks.obsidian);
/* 3660 */     FastSetBlock(world, cposx + 9, cposy + 8, cposz + 0, Blocks.obsidian);
/* 3661 */     FastSetBlock(world, cposx + 9, cposy + 8, cposz + 9, Blocks.obsidian);
/*      */     
/* 3663 */     EntityEnderCrystal entityendercrystal = new EntityEnderCrystal(world);
/* 3664 */     entityendercrystal.setLocationAndAngles((cposx + 0.5F), (cposy + 9), (cposz + 0.5F), world.rand.nextFloat() * 360.0F, 0.0F);
/* 3665 */     world.spawnEntityInWorld((Entity)entityendercrystal);
/* 3666 */     FastSetBlock(world, cposx, cposy + 9, cposz, Blocks.bedrock);
/* 3667 */     entityendercrystal = new EntityEnderCrystal(world);
/* 3668 */     entityendercrystal.setLocationAndAngles((cposx + 0.5F), (cposy + 9), (cposz + 9.5F), world.rand.nextFloat() * 360.0F, 0.0F);
/* 3669 */     world.spawnEntityInWorld((Entity)entityendercrystal);
/* 3670 */     FastSetBlock(world, cposx, cposy + 9, cposz + 9, Blocks.bedrock);
/* 3671 */     entityendercrystal = new EntityEnderCrystal(world);
/* 3672 */     entityendercrystal.setLocationAndAngles((cposx + 9.5F), (cposy + 9), (cposz + 0.5F), world.rand.nextFloat() * 360.0F, 0.0F);
/* 3673 */     world.spawnEntityInWorld((Entity)entityendercrystal);
/* 3674 */     FastSetBlock(world, cposx + 9, cposy + 9, cposz, Blocks.bedrock);
/* 3675 */     entityendercrystal = new EntityEnderCrystal(world);
/* 3676 */     entityendercrystal.setLocationAndAngles((cposx + 9.5F), (cposy + 9), (cposz + 9.5F), world.rand.nextFloat() * 360.0F, 0.0F);
/* 3677 */     world.spawnEntityInWorld((Entity)entityendercrystal);
/* 3678 */     FastSetBlock(world, cposx + 9, cposy + 9, cposz + 9, Blocks.bedrock);
/*      */     
/* 3680 */     i = 3;
/* 3681 */     k = 3;
/* 3682 */     j = 9;
/* 3683 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3684 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3685 */     if (tileentitymobspawner != null)
/*      */     {
/* 3687 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Reaper");
/*      */     }
/* 3689 */     i = 3;
/* 3690 */     k = 6;
/* 3691 */     j = 9;
/* 3692 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3693 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3694 */     if (tileentitymobspawner != null)
/*      */     {
/* 3696 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Reaper");
/*      */     }
/* 3698 */     i = 6;
/* 3699 */     k = 3;
/* 3700 */     j = 9;
/* 3701 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3702 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3703 */     if (tileentitymobspawner != null)
/*      */     {
/* 3705 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Reaper");
/*      */     }
/* 3707 */     i = 6;
/* 3708 */     k = 6;
/* 3709 */     j = 9;
/* 3710 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3711 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3712 */     if (tileentitymobspawner != null)
/*      */     {
/* 3714 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Reaper");
/*      */     }
/*      */ 
/*      */     
/* 3718 */     i = 1;
/* 3719 */     k = 1;
/* 3720 */     j = 1;
/* 3721 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3722 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3723 */     if (tileentitymobspawner != null)
/*      */     {
/* 3725 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Nightmare");
/*      */     }
/* 3727 */     i = 1;
/* 3728 */     k = 8;
/* 3729 */     j = 1;
/* 3730 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3731 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3732 */     if (tileentitymobspawner != null)
/*      */     {
/* 3734 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Nightmare");
/*      */     }
/* 3736 */     i = 8;
/* 3737 */     k = 1;
/* 3738 */     j = 1;
/* 3739 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3740 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3741 */     if (tileentitymobspawner != null)
/*      */     {
/* 3743 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Nightmare");
/*      */     }
/* 3745 */     i = 8;
/* 3746 */     k = 8;
/* 3747 */     j = 1;
/* 3748 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 3749 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 3750 */     if (tileentitymobspawner != null)
/*      */     {
/* 3752 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Nightmare");
/*      */     }
/*      */     
/* 3755 */     world.setBlock(cposx + 4, cposy + 1, cposz + 4, (Block)Blocks.chest, 0, 2);
/* 3756 */     chest = getChestTileEntity(world, cposx + 4, cposy + 1, cposz + 4);
/* 3757 */     if (chest != null)
/*      */     {
/*      */       
/* 3760 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 6 + world.rand.nextInt(5));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeCrystalHauntedHouse(World world, int cposx, int cposy, int cposz) {
/* 3769 */     int deltax = 0, deltaz = 0;
/*      */     
/* 3771 */     int bid = 0;
/* 3772 */     int dirx = 0, dirz = 0;
/*      */     
/* 3774 */     int stuffdir = 0;
/* 3775 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */     
/* 3777 */     int length = 3, width = length;
/* 3778 */     int height = 3;
/*      */ 
/*      */     
/* 3781 */     deltax = 1;
/*      */     
/* 3783 */     stuffdir = 2;
/* 3784 */     int x = cposx, z = cposz, y = cposy;
/*      */ 
/*      */     
/* 3787 */     if (world.isRemote) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*      */     int i;
/*      */     
/* 3794 */     for (i = -width; i <= width; i++) {
/*      */       
/* 3796 */       for (int m = -length; m <= length; m++) {
/*      */         
/* 3798 */         for (int n = 0; n <= height + 1; n++) {
/*      */           
/* 3800 */           if (n == height + 1) {
/* 3801 */             world.setBlock(x + i, y + n, z + m, OreSpawnMain.CrystalPlanksBlock);
/* 3802 */           } else if (n == 0) {
/* 3803 */             world.setBlock(x + i, y + n, z + m, OreSpawnMain.CrystalStone);
/* 3804 */           } else if (i == width || m == length || i == -width || m == -length) {
/* 3805 */             if (n == height) {
/* 3806 */               world.setBlock(x + i, y + n, z + m, Blocks.glass);
/* 3807 */             } else if ((n == 1 || n == 2) && i == deltax * width && m == deltaz * length) {
/*      */               
/* 3809 */               world.setBlock(x + i, y + n, z + m, Blocks.air);
/*      */             } else {
/* 3811 */               world.setBlock(x + i, y + n, z + m, OreSpawnMain.CrystalPlanksBlock);
/*      */             } 
/*      */           } else {
/* 3814 */             world.setBlock(x + i, y + n, z + m, Blocks.air);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 3821 */     i = 2; int k = 1, j = length - 1;
/* 3822 */     world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, (Block)OreSpawnMain.CrystalFurnaceBlock);
/* 3823 */     world.setBlockMetadataWithNotify(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, stuffdir, 3);
/* 3824 */     i = 1;
/* 3825 */     world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, OreSpawnMain.CrystalWorkbenchBlock);
/* 3826 */     i = 0;
/* 3827 */     world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, (Block)Blocks.chest);
/* 3828 */     world.setBlockMetadataWithNotify(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, stuffdir, 3);
/*      */     
/* 3830 */     TileEntityChest chest = getChestTileEntity(world, x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax);
/* 3831 */     if (chest != null) {
/*      */       
/* 3833 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(0, new ItemStack(Items.compass));
/*      */       
/* 3835 */       if (world.rand.nextInt(3) != 0) chest.setInventorySlotContents(2, new ItemStack(OreSpawnMain.MyPeacock, 8)); 
/* 3836 */       if (world.rand.nextInt(3) != 0) chest.setInventorySlotContents(3, new ItemStack(OreSpawnMain.CrystalTorch, 32)); 
/* 3837 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(4, new ItemStack(OreSpawnMain.CrystalCoal, 16)); 
/* 3838 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(5, new ItemStack(Items.bed)); 
/* 3839 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(6, new ItemStack(Items.bed)); 
/* 3840 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(7, new ItemStack(Items.wooden_door)); 
/* 3841 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(8, new ItemStack(OreSpawnMain.MyCrystalPinkPickaxe)); 
/* 3842 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(9, new ItemStack(OreSpawnMain.MyCrystalPinkSword)); 
/* 3843 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(10, new ItemStack(OreSpawnMain.MyCrystalPinkAxe)); 
/* 3844 */       chest.setInventorySlotContents(11, new ItemStack(OreSpawnMain.KrakenRepellent));
/*      */       
/* 3846 */       if (world.rand.nextInt(2) == 0) chest.setInventorySlotContents(13, new ItemStack((Block)Blocks.chest));
/*      */     
/*      */     } 
/* 3849 */     world.setBlock(cposx, cposy + 1, cposz, Blocks.mob_spawner, 0, 2);
/* 3850 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 1, cposz);
/* 3851 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rat"); 
/* 3852 */     world.setBlock(cposx, cposy + 2, cposz, Blocks.mob_spawner, 0, 2);
/* 3853 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 2, cposz);
/* 3854 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ghost"); 
/* 3855 */     world.setBlock(cposx, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
/* 3856 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 3, cposz);
/* 3857 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ghost Pumpkin Skelly");
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeBouncyCastle(World world, int cposx, int cposy, int cposz) {
/* 3865 */     int deltax = 0, deltaz = 0;
/*      */     
/* 3867 */     Block bid = Blocks.air;
/* 3868 */     int meta = 0;
/* 3869 */     int dirx = 0, dirz = 0;
/*      */     
/* 3871 */     int stuffdir = 0;
/*      */     
/* 3873 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 3874 */     TileEntityChest chest = null;
/* 3875 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 3877 */     chestContents = this.BouncyContentsList;
/*      */     
/* 3879 */     int length = 4, width = length;
/* 3880 */     int height = 5;
/*      */ 
/*      */     
/* 3883 */     deltax = 1;
/*      */     
/* 3885 */     stuffdir = 2;
/* 3886 */     int x = cposx, z = cposz, y = cposy;
/*      */ 
/*      */     
/* 3889 */     if (world.isRemote) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3896 */     for (int i = -width; i <= width; i++) {
/*      */       
/* 3898 */       for (int j = -length; j <= length; j++) {
/*      */         
/* 3900 */         for (int k = 0; k < height; k++) {
/*      */           
/* 3902 */           bid = Blocks.air;
/* 3903 */           meta = 0;
/* 3904 */           if (k == height - 1 || k == 0) {
/* 3905 */             bid = OreSpawnMain.MyLavafoamBlock;
/*      */           }
/* 3907 */           if (i == -width || i == width) bid = OreSpawnMain.MyLavafoamBlock; 
/* 3908 */           if (j == -length || j == length) bid = OreSpawnMain.MyLavafoamBlock; 
/* 3909 */           if ((i == -width || i == width) && (j == -length || j == length)) {
/* 3910 */             bid = Blocks.stained_hardened_clay;
/* 3911 */             meta = 14;
/*      */           } 
/* 3913 */           if ((k == 1 || k == 2) && 
/* 3914 */             i == 0 && 
/* 3915 */             j == -length) {
/* 3916 */             meta = 0;
/* 3917 */             bid = Blocks.air;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 3922 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + k, cposz + j, bid, meta, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 3928 */     world.setBlock(cposx - 1, cposy + 3, cposz + length - 1, Blocks.mob_spawner, 0, 2);
/* 3929 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - 1, cposy + 3, cposz + length - 1);
/* 3930 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Silverfish"); 
/* 3931 */     world.setBlock(cposx, cposy + 3, cposz + length - 1, Blocks.mob_spawner, 0, 2);
/* 3932 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 3, cposz + length - 1);
/* 3933 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rat"); 
/* 3934 */     world.setBlock(cposx + 1, cposy + 3, cposz + length - 1, Blocks.mob_spawner, 0, 2);
/* 3935 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 1, cposy + 3, cposz + length - 1);
/* 3936 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Scorpion");
/*      */     
/* 3938 */     world.setBlock(cposx + width - 1, cposy + 3, cposz - 1, Blocks.mob_spawner, 0, 2);
/* 3939 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width - 1, cposy + 3, cposz - 1);
/* 3940 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Silverfish"); 
/* 3941 */     world.setBlock(cposx + width - 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
/* 3942 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width - 1, cposy + 3, cposz);
/* 3943 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rat"); 
/* 3944 */     world.setBlock(cposx + width - 1, cposy + 3, cposz + 1, Blocks.mob_spawner, 0, 2);
/* 3945 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width - 1, cposy + 3, cposz + 1);
/* 3946 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Scorpion");
/*      */     
/* 3948 */     world.setBlock(cposx - width + 1, cposy + 3, cposz - 1, Blocks.mob_spawner, 0, 2);
/* 3949 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - width + 1, cposy + 3, cposz - 1);
/* 3950 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Silverfish"); 
/* 3951 */     world.setBlock(cposx - width + 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
/* 3952 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - width + 1, cposy + 3, cposz);
/* 3953 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rat"); 
/* 3954 */     world.setBlock(cposx - width + 1, cposy + 3, cposz + 1, Blocks.mob_spawner, 0, 2);
/* 3955 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - width + 1, cposy + 3, cposz + 1);
/* 3956 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Scorpion");
/*      */ 
/*      */     
/* 3959 */     world.setBlock(cposx + width - 1, cposy + 3, cposz + length - 1, (Block)Blocks.chest, 2, 2);
/*      */     
/* 3961 */     chest = getChestTileEntity(world, cposx + width - 1, cposy + 3, cposz + length - 1);
/* 3962 */     if (chest != null)
/*      */     {
/*      */       
/* 3965 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 6 + world.rand.nextInt(5));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeEnderCastle(World world, int cposx, int cposy, int cposz) {
/* 3972 */     int width = 22;
/* 3973 */     int height = 12;
/*      */ 
/*      */     
/* 3976 */     TileEntityChest chest = null;
/* 3977 */     WeightedRandomChestContent[] chestContents = null;
/* 3978 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */     
/* 3980 */     chestContents = this.EnderCastleContentsList;
/*      */ 
/*      */     
/* 3983 */     Block bid = Blocks.obsidian; int i;
/* 3984 */     for (i = -3; i <= width + 3; i++) {
/* 3985 */       for (int n = -3; n <= width + 3; n++) {
/* 3986 */         for (int i1 = 0;; i1++);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3998 */     for (i = 0; i <= width; i++) {
/* 3999 */       for (int n = 0; n <= width; n++) {
/* 4000 */         for (int i1 = 1;; i1++);
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
/*      */         continue;
/*      */       } 
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
/* 4031 */     for (i = -1; i <= width + 1; i++) {
/* 4032 */       for (int n = -1; n <= width + 1; n++) {
/* 4033 */         for (int i1 = 1;; i1++);
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
/*      */         continue;
/*      */       } 
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
/* 4059 */     makeAColumn(world, cposx - 2, cposy, cposz - 2, height + 1, 0);
/* 4060 */     makeAColumn(world, cposx + width - 2, cposy, cposz - 2, height + 1, 1);
/* 4061 */     makeAColumn(world, cposx - 2, cposy, cposz + width - 2, height + 1, 2);
/* 4062 */     makeAColumn(world, cposx + width - 2, cposy, cposz + width - 2, height + 1, 3);
/*      */ 
/*      */     
/* 4065 */     int j = 8;
/* 4066 */     for (i = 1; i <= width - 1; i++) {
/* 4067 */       for (int n = 1; n <= width - 1; n++) {
/* 4068 */         bid = Blocks.obsidian;
/* 4069 */         if (i == width / 2 || n == width / 2 || i == n || i == width - n) bid = Blocks.bedrock; 
/* 4070 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + n, bid, 0, 2);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 4075 */     j = 9;
/* 4076 */     for (i = -2; i <= 2; i++) {
/* 4077 */       for (int n = -2; n <= 2; n++) {
/* 4078 */         bid = Blocks.lava;
/* 4079 */         OreSpawnMain.setBlockFast(world, cposx + i + width / 2, cposy + j, cposz + n + width / 2, bid, 0, 2);
/*      */       } 
/*      */     }  int m;
/* 4082 */     for (m = -1; m <= 1; m++) {
/* 4083 */       OreSpawnMain.setBlockFast(world, cposx + width / 2 + m, cposy + j, cposz + width / 2 + 3, Blocks.bedrock, 0, 2);
/* 4084 */       OreSpawnMain.setBlockFast(world, cposx + width / 2 + m, cposy + j, cposz + width / 2 - 3, Blocks.bedrock, 0, 2);
/* 4085 */       OreSpawnMain.setBlockFast(world, cposx + width / 2 + 3, cposy + j, cposz + width / 2 + m, Blocks.bedrock, 0, 2);
/* 4086 */       OreSpawnMain.setBlockFast(world, cposx + width / 2 - 3, cposy + j, cposz + width / 2 + m, Blocks.bedrock, 0, 2);
/*      */     } 
/* 4088 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 - 2, cposy + j, cposz + width / 2 - 2, Blocks.bedrock, 0, 2);
/* 4089 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 + 2, cposy + j, cposz + width / 2 + 2, Blocks.bedrock, 0, 2);
/* 4090 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 - 2, cposy + j, cposz + width / 2 + 2, Blocks.bedrock, 0, 2);
/* 4091 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 + 2, cposy + j, cposz + width / 2 - 2, Blocks.bedrock, 0, 2);
/*      */ 
/*      */     
/* 4094 */     OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j, cposz + width / 2, Blocks.bedrock, 0, 2);
/*      */     
/* 4096 */     world.setBlock(cposx + width / 2, cposy + j + 1, cposz + width / 2, Blocks.ender_chest, 2, 2);
/*      */     
/* 4098 */     OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 2, cposz + width / 2, Blocks.obsidian, 0, 2);
/* 4099 */     OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 3, cposz + width / 2, Blocks.bedrock, 0, 2);
/* 4100 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 - 1, cposy + j + 3, cposz + width / 2, Blocks.bedrock, 0, 2);
/* 4101 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 + 1, cposy + j + 3, cposz + width / 2, Blocks.bedrock, 0, 2);
/* 4102 */     OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 3, cposz + width / 2 - 1, Blocks.bedrock, 0, 2);
/* 4103 */     OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 3, cposz + width / 2 + 1, Blocks.bedrock, 0, 2);
/* 4104 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 - 1, cposy + j + 4, cposz + width / 2, Blocks.torch, 0, 2);
/* 4105 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 + 1, cposy + j + 4, cposz + width / 2, Blocks.torch, 0, 2);
/* 4106 */     OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 4, cposz + width / 2 - 1, Blocks.torch, 0, 2);
/* 4107 */     OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 4, cposz + width / 2 + 1, Blocks.torch, 0, 2);
/* 4108 */     OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 4, cposz + width / 2, Blocks.bedrock, 0, 2);
/* 4109 */     OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 5, cposz + width / 2, Blocks.bedrock, 0, 2);
/* 4110 */     OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 6, cposz + width / 2, Blocks.dragon_egg, 0, 2);
/*      */     
/* 4112 */     world.setBlock(cposx + width / 2 + 5, cposy + j, cposz + width / 2 + 5, Blocks.mob_spawner, 0, 2);
/* 4113 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 + 5, cposy + j, cposz + width / 2 + 5);
/* 4114 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Reaper"); 
/* 4115 */     world.setBlock(cposx + width / 2 + 5, cposy + j + 1, cposz + width / 2 + 5, Blocks.mob_spawner, 0, 2);
/* 4116 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 + 5, cposy + j + 1, cposz + width / 2 + 5);
/* 4117 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Knight");
/*      */     
/* 4119 */     world.setBlock(cposx + width / 2 - 5, cposy + j, cposz + width / 2 + 5, Blocks.mob_spawner, 0, 2);
/* 4120 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 - 5, cposy + j, cposz + width / 2 + 5);
/* 4121 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Reaper"); 
/* 4122 */     world.setBlock(cposx + width / 2 - 5, cposy + j + 1, cposz + width / 2 + 5, Blocks.mob_spawner, 0, 2);
/* 4123 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 - 5, cposy + j + 1, cposz + width / 2 + 5);
/* 4124 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Knight");
/*      */     
/* 4126 */     world.setBlock(cposx + width / 2 + 5, cposy + j, cposz + width / 2 - 5, Blocks.mob_spawner, 0, 2);
/* 4127 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 + 5, cposy + j, cposz + width / 2 - 5);
/* 4128 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Reaper"); 
/* 4129 */     world.setBlock(cposx + width / 2 + 5, cposy + j + 1, cposz + width / 2 - 5, Blocks.mob_spawner, 0, 2);
/* 4130 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 + 5, cposy + j + 1, cposz + width / 2 - 5);
/* 4131 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Knight");
/*      */     
/* 4133 */     world.setBlock(cposx + width / 2 - 5, cposy + j, cposz + width / 2 - 5, Blocks.mob_spawner, 0, 2);
/* 4134 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 - 5, cposy + j, cposz + width / 2 - 5);
/* 4135 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Reaper"); 
/* 4136 */     world.setBlock(cposx + width / 2 - 5, cposy + j + 1, cposz + width / 2 - 5, Blocks.mob_spawner, 0, 2);
/* 4137 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 - 5, cposy + j + 1, cposz + width / 2 - 5);
/* 4138 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Knight");
/*      */ 
/*      */     
/* 4141 */     j = 4;
/* 4142 */     for (i = 1; i <= width - 1; i++) {
/* 4143 */       for (int n = 1; n <= width - 1; n++) {
/* 4144 */         bid = Blocks.air;
/* 4145 */         if (i <= 5 || n <= 5 || i >= width - 5 || n >= width - 5) bid = Blocks.bedrock; 
/* 4146 */         if (bid != Blocks.air) OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + n, bid, 0, 2); 
/* 4147 */         if (i == 5 && n >= 5 && n <= width - 5) {
/* 4148 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + n, Blocks.iron_bars, 0, 2);
/* 4149 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 2, cposz + n, Blocks.iron_bars, 0, 2);
/* 4150 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 3, cposz + n, Blocks.iron_bars, 0, 2);
/*      */         } 
/* 4152 */         if (i == width - 5 && n >= 5 && n <= width - 5) {
/* 4153 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + n, Blocks.iron_bars, 0, 2);
/* 4154 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 2, cposz + n, Blocks.iron_bars, 0, 2);
/* 4155 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 3, cposz + n, Blocks.iron_bars, 0, 2);
/*      */         } 
/* 4157 */         if (n == 5 && i >= 5 && i <= width - 5) {
/* 4158 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + n, Blocks.iron_bars, 0, 2);
/* 4159 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 2, cposz + n, Blocks.iron_bars, 0, 2);
/* 4160 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 3, cposz + n, Blocks.iron_bars, 0, 2);
/*      */         } 
/* 4162 */         if (n == width - 5 && i >= 5 && i <= width - 5) {
/* 4163 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + n, Blocks.iron_bars, 0, 2);
/* 4164 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 2, cposz + n, Blocks.iron_bars, 0, 2);
/* 4165 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 3, cposz + n, Blocks.iron_bars, 0, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 4170 */     bid = Blocks.bedrock;
/* 4171 */     j = 3;
/* 4172 */     int k = width / 2;
/* 4173 */     i = width - 6;
/* 4174 */     for (m = -1; m <= 1; m++) {
/* 4175 */       OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k + m, bid, 0, 2);
/*      */     }
/* 4177 */     j = 2;
/* 4178 */     k = width / 2;
/* 4179 */     i = width - 7;
/* 4180 */     for (m = -1; m <= 1; m++) {
/* 4181 */       OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k + m, bid, 0, 2);
/*      */     }
/* 4183 */     j = 1;
/* 4184 */     k = width / 2;
/* 4185 */     i = width - 8;
/* 4186 */     for (m = -1; m <= 1; m++) {
/* 4187 */       OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k + m, bid, 0, 2);
/*      */     }
/*      */     
/* 4190 */     j = 4;
/* 4191 */     i = width - 5;
/* 4192 */     for (m = -1; m <= 1; m++) {
/* 4193 */       OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + k + m, Blocks.air, 0, 2);
/* 4194 */       OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 2, cposz + k + m, Blocks.air, 0, 2);
/* 4195 */       OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 3, cposz + k + m, Blocks.air, 0, 2);
/*      */     } 
/*      */ 
/*      */     
/* 4199 */     j = 1;
/* 4200 */     world.setBlock(cposx + width / 2, cposy + j, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 4201 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + j, cposz + width / 2);
/* 4202 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Reaper"); 
/* 4203 */     world.setBlock(cposx + width / 2, cposy + j + 1, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 4204 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + j + 1, cposz + width / 2);
/* 4205 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ender Knight");
/*      */ 
/*      */     
/* 4208 */     j = 5;
/* 4209 */     world.setBlock(cposx + 1, cposy + j, cposz + width / 2 - 1, Blocks.mob_spawner, 0, 2);
/* 4210 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 1, cposy + j, cposz + width / 2 - 1);
/* 4211 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("CaveFisher"); 
/* 4212 */     world.setBlock(cposx + 1, cposy + j, cposz + width / 2 + 1, Blocks.mob_spawner, 0, 2);
/* 4213 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 1, cposy + j, cposz + width / 2 + 1);
/* 4214 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("CaveFisher"); 
/* 4215 */     world.setBlock(cposx + 1, cposy + j, cposz + width / 2, (Block)Blocks.chest, 2, 2);
/* 4216 */     chest = getChestTileEntity(world, cposx + 1, cposy + j, cposz + width / 2);
/* 4217 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 6 + world.rand.nextInt(5));
/*      */     
/* 4219 */     world.setBlock(cposx + width / 2 - 1, cposy + j, cposz + 1, Blocks.mob_spawner, 0, 2);
/* 4220 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 - 1, cposy + j, cposz + 1);
/* 4221 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("CaveFisher"); 
/* 4222 */     world.setBlock(cposx + width / 2 + 1, cposy + j, cposz + 1, Blocks.mob_spawner, 0, 2);
/* 4223 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 + 1, cposy + j, cposz + 1);
/* 4224 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("CaveFisher"); 
/* 4225 */     world.setBlock(cposx + width / 2, cposy + j, cposz + 1, (Block)Blocks.chest, 3, 2);
/* 4226 */     chest = getChestTileEntity(world, cposx + width / 2, cposy + j, cposz + 1);
/* 4227 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 6 + world.rand.nextInt(5));
/*      */     
/* 4229 */     world.setBlock(cposx + width / 2 - 1, cposy + j, cposz + width - 1, Blocks.mob_spawner, 0, 2);
/* 4230 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 - 1, cposy + j, cposz + width - 1);
/* 4231 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("CaveFisher"); 
/* 4232 */     world.setBlock(cposx + width / 2 + 1, cposy + j, cposz + width - 1, Blocks.mob_spawner, 0, 2);
/* 4233 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 + 1, cposy + j, cposz + width - 1);
/* 4234 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("CaveFisher"); 
/* 4235 */     world.setBlock(cposx + width / 2, cposy + j, cposz + width - 1, (Block)Blocks.chest, 4, 2);
/* 4236 */     chest = getChestTileEntity(world, cposx + width / 2, cposy + j, cposz + width - 1);
/* 4237 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 6 + world.rand.nextInt(5));
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void makeAColumn(World world, int cposx, int cposy, int cposz, int height, int dir) {
/* 4244 */     int width = 4;
/* 4245 */     int halfwidth = 2;
/* 4246 */     int step = dir;
/*      */     
/*      */     int i;
/*      */     
/* 4250 */     for (i = -2; i <= width + 2; i++) {
/* 4251 */       for (int m = -2; m <= width + 2; m++) {
/* 4252 */         int n = height + 2;
/* 4253 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + n, cposz + m, Blocks.obsidian, 0, 2);
/*      */       } 
/*      */     } 
/*      */     
/* 4257 */     for (i = -2; i <= width + 2; i++) {
/* 4258 */       for (int m = -2;; m++);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       continue;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4272 */     for (i = 0; i <= width; i++) {
/* 4273 */       for (int m = 0; m <= width; m++) {
/* 4274 */         for (int n = 1;; n++);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4288 */     if (dir == 0) {
/* 4289 */       int m; for (m = 1; m <= 2; m++) {
/* 4290 */         OreSpawnMain.setBlockFast(world, cposx + width, cposy + m, cposz + width, Blocks.air, 0, 2);
/* 4291 */         OreSpawnMain.setBlockFast(world, cposx + width - 1, cposy + m, cposz + width, Blocks.air, 0, 2);
/* 4292 */         OreSpawnMain.setBlockFast(world, cposx + width, cposy + m, cposz + width - 1, Blocks.air, 0, 2);
/*      */       } 
/* 4294 */       for (m = 9; m <= 10; m++) {
/* 4295 */         OreSpawnMain.setBlockFast(world, cposx + width, cposy + m, cposz + width, Blocks.air, 0, 2);
/* 4296 */         OreSpawnMain.setBlockFast(world, cposx + width - 1, cposy + m, cposz + width, Blocks.air, 0, 2);
/* 4297 */         OreSpawnMain.setBlockFast(world, cposx + width, cposy + m, cposz + width - 1, Blocks.air, 0, 2);
/*      */       } 
/*      */     } 
/* 4300 */     if (dir == 1) {
/* 4301 */       int m; for (m = 1; m <= 2; m++) {
/* 4302 */         OreSpawnMain.setBlockFast(world, cposx, cposy + m, cposz + width, Blocks.air, 0, 2);
/* 4303 */         OreSpawnMain.setBlockFast(world, cposx + 1, cposy + m, cposz + width, Blocks.air, 0, 2);
/* 4304 */         OreSpawnMain.setBlockFast(world, cposx, cposy + m, cposz + width - 1, Blocks.air, 0, 2);
/*      */       } 
/* 4306 */       for (m = 9; m <= 10; m++) {
/* 4307 */         OreSpawnMain.setBlockFast(world, cposx, cposy + m, cposz + width, Blocks.air, 0, 2);
/* 4308 */         OreSpawnMain.setBlockFast(world, cposx + 1, cposy + m, cposz + width, Blocks.air, 0, 2);
/* 4309 */         OreSpawnMain.setBlockFast(world, cposx, cposy + m, cposz + width - 1, Blocks.air, 0, 2);
/*      */       } 
/* 4311 */       step++;
/* 4312 */       if (step > 3) step = 0; 
/*      */     } 
/* 4314 */     if (dir == 2) {
/* 4315 */       int m; for (m = 1; m <= 2; m++) {
/* 4316 */         OreSpawnMain.setBlockFast(world, cposx + width, cposy + m, cposz, Blocks.air, 0, 2);
/* 4317 */         OreSpawnMain.setBlockFast(world, cposx + width - 1, cposy + m, cposz, Blocks.air, 0, 2);
/* 4318 */         OreSpawnMain.setBlockFast(world, cposx + width, cposy + m, cposz + 1, Blocks.air, 0, 2);
/*      */       } 
/* 4320 */       for (m = 9; m <= 10; m++) {
/* 4321 */         OreSpawnMain.setBlockFast(world, cposx + width, cposy + m, cposz, Blocks.air, 0, 2);
/* 4322 */         OreSpawnMain.setBlockFast(world, cposx + width - 1, cposy + m, cposz, Blocks.air, 0, 2);
/* 4323 */         OreSpawnMain.setBlockFast(world, cposx + width, cposy + m, cposz + 1, Blocks.air, 0, 2);
/*      */       } 
/* 4325 */       step++;
/* 4326 */       if (step > 3) step = 0; 
/* 4327 */       step++;
/* 4328 */       if (step > 3) step = 0; 
/*      */     } 
/* 4330 */     if (dir == 3) {
/* 4331 */       int m; for (m = 1; m <= 2; m++) {
/* 4332 */         OreSpawnMain.setBlockFast(world, cposx, cposy + m, cposz, Blocks.air, 0, 2);
/* 4333 */         OreSpawnMain.setBlockFast(world, cposx + 1, cposy + m, cposz, Blocks.air, 0, 2);
/* 4334 */         OreSpawnMain.setBlockFast(world, cposx, cposy + m, cposz + 1, Blocks.air, 0, 2);
/*      */       } 
/* 4336 */       for (m = 9; m <= 10; m++) {
/* 4337 */         OreSpawnMain.setBlockFast(world, cposx, cposy + m, cposz, Blocks.air, 0, 2);
/* 4338 */         OreSpawnMain.setBlockFast(world, cposx + 1, cposy + m, cposz, Blocks.air, 0, 2);
/* 4339 */         OreSpawnMain.setBlockFast(world, cposx, cposy + m, cposz + 1, Blocks.air, 0, 2);
/*      */       } 
/* 4341 */       step++;
/* 4342 */       if (step > 3) step = 0; 
/* 4343 */       step++;
/* 4344 */       if (step > 3) step = 0;
/*      */     
/*      */     } 
/*      */     
/* 4348 */     Block bid = Blocks.nether_brick;
/* 4349 */     int k = 0;
/* 4350 */     for (int j = 1; j <= height + 2; j++) {
/* 4351 */       if (step == 0) {
/* 4352 */         i = k = 1;
/*      */       }
/* 4354 */       if (step == 1) {
/* 4355 */         i = 1;
/* 4356 */         k = 3;
/*      */       } 
/* 4358 */       if (step == 2) {
/* 4359 */         i = 3;
/* 4360 */         k = 3;
/*      */       } 
/* 4362 */       if (step == 3) {
/* 4363 */         i = 3;
/* 4364 */         k = 1;
/*      */       } 
/* 4366 */       step++;
/* 4367 */       if (step > 3) step = 0; 
/* 4368 */       OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeDamselInDistress(World world, int cposx, int cposy, int cposz) {
/* 4376 */     Block bid = Blocks.air;
/* 4377 */     int meta = 0;
/*      */     
/* 4379 */     int stuffdir = 0;
/*      */     
/* 4381 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 4382 */     TileEntityChest chest = null;
/* 4383 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 4385 */     chestContents = this.DamselContentsList;
/*      */     
/* 4387 */     int length = 4, width = length;
/* 4388 */     int height = 5;
/*      */ 
/*      */ 
/*      */     
/* 4392 */     stuffdir = 2;
/*      */ 
/*      */ 
/*      */     
/* 4396 */     if (world.isRemote) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*      */     int i;
/*      */     
/* 4403 */     for (i = -width; i <= width; i++) {
/*      */       
/* 4405 */       for (int n = -length; n <= length; n++) {
/*      */         
/* 4407 */         for (int i1 = 0; i1 < height; i1++) {
/*      */           
/* 4409 */           bid = Blocks.air;
/* 4410 */           meta = 0;
/* 4411 */           if (i1 == 0) {
/* 4412 */             bid = Blocks.cobblestone;
/*      */           }
/* 4414 */           if (i == -width || i == width) bid = Blocks.cobblestone; 
/* 4415 */           if (n == -length || n == length) bid = Blocks.cobblestone; 
/* 4416 */           if (bid == Blocks.cobblestone && 
/* 4417 */             world.rand.nextInt(8) == 1) bid = Blocks.mossy_cobblestone;
/*      */ 
/*      */           
/* 4420 */           if ((i1 == 1 || i1 == 2 || i1 == 3) && (
/* 4421 */             i == 0 || i == -1 || i == 1) && 
/* 4422 */             n == -length) {
/* 4423 */             meta = 0;
/* 4424 */             bid = Blocks.air;
/*      */           } 
/*      */ 
/*      */           
/* 4428 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + i1, cposz + n, bid, meta, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 4433 */     meta = 0;
/* 4434 */     for (i = -width + 1; i <= width - 1; i++) {
/* 4435 */       for (int n = -length; n <= length - 1; n++) {
/* 4436 */         int i1 = height;
/* 4437 */         bid = Blocks.cobblestone;
/* 4438 */         if (world.rand.nextInt(8) == 1) bid = Blocks.mossy_cobblestone; 
/* 4439 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + i1, cposz + n, bid, meta, 2);
/*      */       } 
/*      */     } 
/* 4442 */     for (i = -width + 2; i <= width - 2; i++) {
/* 4443 */       for (int n = -length; n <= length - 2; n++) {
/* 4444 */         int i1 = height + 1;
/* 4445 */         bid = Blocks.cobblestone;
/* 4446 */         if (world.rand.nextInt(8) == 1) bid = Blocks.mossy_cobblestone; 
/* 4447 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + i1, cposz + n, bid, meta, 2);
/*      */       } 
/*      */     } 
/*      */     
/* 4451 */     int k = height;
/* 4452 */     int j = -length;
/* 4453 */     for (int m = width; m >= 0; m--) {
/* 4454 */       for (i = m; i >= 0; i--) {
/* 4455 */         bid = Blocks.cobblestone;
/* 4456 */         if (world.rand.nextInt(8) == 1) bid = Blocks.mossy_cobblestone; 
/* 4457 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + k, cposz + j, bid, meta, 2);
/* 4458 */         bid = Blocks.cobblestone;
/* 4459 */         if (world.rand.nextInt(8) == 1) bid = Blocks.mossy_cobblestone; 
/* 4460 */         OreSpawnMain.setBlockFast(world, cposx - i, cposy + k, cposz + j, bid, meta, 2);
/*      */       } 
/*      */       
/* 4463 */       k++;
/*      */     } 
/*      */     
/* 4466 */     for (i = -width + 1; i < width; i++) {
/* 4467 */       for (j = 1; j < height; j++) {
/* 4468 */         k = length - 3;
/* 4469 */         OreSpawnMain.setBlockFast(world, cposx - i, cposy + j, cposz + k, Blocks.iron_bars, 0, 2);
/*      */       } 
/*      */     } 
/*      */     
/* 4473 */     world.setBlock(cposx - width + 1, cposy + 1, cposz - length + 1, Blocks.mob_spawner, 0, 2);
/* 4474 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - width + 1, cposy + 1, cposz - length + 1);
/* 4475 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Scorpion"); 
/* 4476 */     world.setBlock(cposx + width - 1, cposy + 1, cposz - length + 1, Blocks.mob_spawner, 0, 2);
/* 4477 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width - 1, cposy + 1, cposz - length + 1);
/* 4478 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Scorpion");
/*      */ 
/*      */     
/* 4481 */     world.setBlock(cposx + width - 1, cposy + 1, cposz + length - 1, (Block)Blocks.chest, 2, 2);
/*      */     
/* 4483 */     chest = getChestTileEntity(world, cposx + width - 1, cposy + 1, cposz + length - 1);
/* 4484 */     if (chest != null)
/*      */     {
/*      */       
/* 4487 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 10 + world.rand.nextInt(5));
/*      */     }
/*      */     
/* 4490 */     Entity var8 = null;
/*      */     
/* 4492 */     var8 = EntityList.createEntityByName("Girlfriend", world);
/* 4493 */     if (var8 != null) {
/*      */ 
/*      */       
/* 4496 */       var8.setLocationAndAngles((cposx - width + 2), (cposy + 1), (cposz + length - 1), world.rand.nextFloat() * 360.0F, 0.0F);
/*      */       
/* 4498 */       world.spawnEntityInWorld(var8);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeIncaPyramid(World world, int cposx, int cposy, int cposz) {
/* 4508 */     Block bid = Blocks.air;
/*      */ 
/*      */     
/* 4511 */     int meta = 0;
/*      */     
/* 4513 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 4514 */     TileEntityChest chest = null;
/* 4515 */     WeightedRandomChestContent[] chestContents = null;
/*      */ 
/*      */ 
/*      */     
/* 4519 */     int width = 21;
/* 4520 */     int depth = 11;
/* 4521 */     int height = 9;
/*      */     
/* 4523 */     int basewidth = 41;
/* 4524 */     int basedepth = 31;
/* 4525 */     int baseheight = 10;
/*      */     
/* 4527 */     if (world.isRemote) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*      */     int j;
/*      */     
/* 4534 */     for (j = 0; j < baseheight; j++) {
/* 4535 */       for (int n = 0; n < basewidth - j * 2; n++) {
/* 4536 */         for (int i1 = 0; i1 < basedepth - j * 2; i1++) {
/* 4537 */           meta = 0;
/* 4538 */           bid = Blocks.air;
/* 4539 */           if (n == 0 || i1 == 0 || n == basewidth - j * 2 - 1 || i1 == basedepth - j * 2 - 1) {
/* 4540 */             bid = Blocks.stone;
/* 4541 */             if (world.rand.nextInt(2) == 0) bid = Blocks.cobblestone; 
/* 4542 */             if (world.rand.nextInt(4) == 0) bid = Blocks.mossy_cobblestone; 
/*      */           } 
/* 4544 */           if (j == 0) bid = Blocks.stonebrick; 
/* 4545 */           if (i1 == 1 && j % 3 == 2 && 
/* 4546 */             n != 0 && n != basewidth - j * 2 - 1) {
/* 4547 */             bid = Blocks.torch;
/* 4548 */             meta = 3;
/*      */           } 
/*      */           
/* 4551 */           OreSpawnMain.setBlockFast(world, cposx + n + j, cposy + j, cposz + i1 + j, bid, meta, 2);
/*      */           
/* 4553 */           if (i1 == basedepth - j * 2 - 1 && j % 3 == 2 && 
/* 4554 */             n != 0 && n != basewidth - j * 2 - 1) {
/* 4555 */             meta = 4;
/* 4556 */             OreSpawnMain.setBlockFast(world, cposx + n + j, cposy + j, cposz + i1 + j - 1, Blocks.torch, meta, 2);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 4564 */     meta = 0; int m;
/* 4565 */     for (m = 0; m < baseheight * 2 - 1; m++) {
/* 4566 */       int n = -baseheight + m;
/*      */       
/* 4568 */       for (int p = -2; p <= 2; p++) {
/* 4569 */         int i1 = basedepth / 2;
/* 4570 */         i1 += p;
/* 4571 */         j = m / 2;
/*      */         
/* 4573 */         if (p < -1 || p > 1) {
/* 4574 */           bid = world.getBlock(cposx + n, cposy + j + 1, cposz + i1);
/* 4575 */           if (bid == Blocks.air) {
/* 4576 */             OreSpawnMain.setBlockFast(world, cposx + n, cposy + j + 1, cposz + i1, Blocks.stonebrick, meta, 2);
/* 4577 */             if (m == 0 || m == baseheight * 2 - 2) {
/* 4578 */               OreSpawnMain.setBlockFast(world, cposx + n, cposy + j + 2, cposz + i1, Blocks.torch, meta, 2);
/*      */             }
/*      */           }
/*      */         
/* 4582 */         } else if (m % 2 == 1) {
/* 4583 */           bid = world.getBlock(cposx + n, cposy + j + 1, cposz + i1);
/* 4584 */           if (bid == Blocks.air) OreSpawnMain.setBlockFast(world, cposx + n, cposy + j + 1, cposz + i1, (Block)Blocks.stone_slab, meta, 2);
/*      */         
/*      */         } 
/* 4587 */         while (j >= 0) {
/* 4588 */           bid = world.getBlock(cposx + n, cposy + j, cposz + i1);
/* 4589 */           if (bid == Blocks.air) {
/* 4590 */             OreSpawnMain.setBlockFast(world, cposx + n, cposy + j, cposz + i1, Blocks.stone, meta, 2);
/*      */             
/*      */             j--;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 4598 */     meta = 0;
/* 4599 */     for (m = 0; m < baseheight * 2 - 1; m++) {
/* 4600 */       int n = basewidth + baseheight - m - 1;
/*      */       
/* 4602 */       for (int p = -2; p <= 2; p++) {
/* 4603 */         int i1 = basedepth / 2;
/* 4604 */         i1 += p;
/* 4605 */         j = m / 2;
/*      */         
/* 4607 */         if (p < -1 || p > 1) {
/* 4608 */           bid = world.getBlock(cposx + n, cposy + j + 1, cposz + i1);
/* 4609 */           if (bid == Blocks.air) {
/* 4610 */             OreSpawnMain.setBlockFast(world, cposx + n, cposy + j + 1, cposz + i1, Blocks.stonebrick, meta, 2);
/* 4611 */             if (m == 0 || m == baseheight * 2 - 2) {
/* 4612 */               OreSpawnMain.setBlockFast(world, cposx + n, cposy + j + 2, cposz + i1, Blocks.torch, meta, 2);
/*      */             }
/*      */           }
/*      */         
/* 4616 */         } else if (m % 2 == 1) {
/* 4617 */           bid = world.getBlock(cposx + n, cposy + j + 1, cposz + i1);
/* 4618 */           if (bid == Blocks.air) OreSpawnMain.setBlockFast(world, cposx + n, cposy + j + 1, cposz + i1, (Block)Blocks.stone_slab, meta, 2);
/*      */         
/*      */         } 
/* 4621 */         while (j >= 0) {
/* 4622 */           bid = world.getBlock(cposx + n, cposy + j, cposz + i1);
/* 4623 */           if (bid == Blocks.air) {
/* 4624 */             OreSpawnMain.setBlockFast(world, cposx + n, cposy + j, cposz + i1, Blocks.stone, meta, 2);
/*      */ 
/*      */             
/*      */             j--;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 4633 */     meta = 0;
/* 4634 */     for (m = 0; m < baseheight * 2 - 1; m++) {
/* 4635 */       int n = -baseheight + m;
/*      */       
/* 4637 */       for (int p = -2; p <= 2; p++) {
/* 4638 */         int i1 = basewidth / 2;
/* 4639 */         i1 += p;
/* 4640 */         j = m / 2;
/*      */         
/* 4642 */         if (p < -1 || p > 1) {
/* 4643 */           bid = world.getBlock(cposx + i1, cposy + j + 1, cposz + n);
/* 4644 */           if (bid == Blocks.air) {
/* 4645 */             OreSpawnMain.setBlockFast(world, cposx + i1, cposy + j + 1, cposz + n, Blocks.stonebrick, meta, 2);
/* 4646 */             if (m == 0 || m == baseheight * 2 - 2) {
/* 4647 */               OreSpawnMain.setBlockFast(world, cposx + i1, cposy + j + 2, cposz + n, Blocks.torch, meta, 2);
/*      */             }
/*      */           }
/*      */         
/* 4651 */         } else if (m % 2 == 1) {
/* 4652 */           bid = world.getBlock(cposx + i1, cposy + j + 1, cposz + n);
/* 4653 */           if (bid == Blocks.air) OreSpawnMain.setBlockFast(world, cposx + i1, cposy + j + 1, cposz + n, (Block)Blocks.stone_slab, meta, 2);
/*      */         
/*      */         } 
/* 4656 */         while (j >= 0) {
/* 4657 */           bid = world.getBlock(cposx + i1, cposy + j, cposz + n);
/* 4658 */           if (bid == Blocks.air) {
/* 4659 */             OreSpawnMain.setBlockFast(world, cposx + i1, cposy + j, cposz + n, Blocks.stone, meta, 2);
/*      */ 
/*      */             
/*      */             j--;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 4668 */     meta = 0;
/* 4669 */     for (m = 0; m < baseheight * 2 - 1; m++) {
/* 4670 */       int n = basedepth + baseheight - m - 1;
/*      */       
/* 4672 */       for (int p = -2; p <= 2; p++) {
/* 4673 */         int i1 = basewidth / 2;
/* 4674 */         i1 += p;
/* 4675 */         j = m / 2;
/*      */         
/* 4677 */         if (p < -1 || p > 1) {
/* 4678 */           bid = world.getBlock(cposx + i1, cposy + j + 1, cposz + n);
/* 4679 */           if (bid == Blocks.air) {
/* 4680 */             OreSpawnMain.setBlockFast(world, cposx + i1, cposy + j + 1, cposz + n, Blocks.stonebrick, meta, 2);
/* 4681 */             if (m == 0 || m == baseheight * 2 - 2) {
/* 4682 */               OreSpawnMain.setBlockFast(world, cposx + i1, cposy + j + 2, cposz + n, Blocks.torch, meta, 2);
/*      */             }
/*      */           }
/*      */         
/* 4686 */         } else if (m % 2 == 1) {
/* 4687 */           bid = world.getBlock(cposx + i1, cposy + j + 1, cposz + n);
/* 4688 */           if (bid == Blocks.air) OreSpawnMain.setBlockFast(world, cposx + i1, cposy + j + 1, cposz + n, (Block)Blocks.stone_slab, meta, 2);
/*      */         
/*      */         } 
/* 4691 */         while (j >= 0) {
/* 4692 */           bid = world.getBlock(cposx + i1, cposy + j, cposz + n);
/* 4693 */           if (bid == Blocks.air) {
/* 4694 */             OreSpawnMain.setBlockFast(world, cposx + i1, cposy + j, cposz + n, Blocks.stone, meta, 2);
/*      */ 
/*      */             
/*      */             j--;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 4703 */     cposx += baseheight;
/* 4704 */     cposy += baseheight;
/* 4705 */     cposz += baseheight;
/*      */ 
/*      */     
/* 4708 */     for (j = 0; j < height; j++) {
/* 4709 */       for (int n = 0; n < width; n++) {
/* 4710 */         for (int i1 = 0; i1 < depth; i1++) {
/* 4711 */           bid = Blocks.air;
/* 4712 */           meta = 0;
/* 4713 */           if (n == 0 || i1 == 0 || n == width - 1 || i1 == depth - 1) {
/* 4714 */             bid = Blocks.stone;
/* 4715 */             if (world.rand.nextInt(2) == 0) bid = Blocks.cobblestone; 
/* 4716 */             if (world.rand.nextInt(4) == 0) bid = Blocks.mossy_cobblestone; 
/*      */           } 
/* 4718 */           if (j == 0 || j == height - 1) bid = Blocks.stonebrick; 
/* 4719 */           if (j == 1 || j == 2 || j == 3) {
/* 4720 */             if ((i1 == 0 || i1 == depth - 1) && 
/* 4721 */               n >= width / 2 - 1 && n <= width / 2 + 1) {
/* 4722 */               if (j == 3) {
/* 4723 */                 bid = Blocks.fence;
/*      */               } else {
/* 4725 */                 bid = Blocks.air;
/*      */               } 
/*      */             }
/*      */             
/* 4729 */             if ((n == 0 || n == width - 1) && 
/* 4730 */               i1 >= depth / 2 - 1 && i1 <= depth / 2 + 1) {
/* 4731 */               if (j == 3) {
/* 4732 */                 bid = Blocks.fence;
/*      */               } else {
/* 4734 */                 bid = Blocks.air;
/*      */               } 
/*      */             }
/*      */           } 
/*      */ 
/*      */           
/* 4740 */           if ((j == height - 3 || j == height - 2) && (
/* 4741 */             n + i1) % 2 == 1) {
/* 4742 */             if (j == height - 3) {
/* 4743 */               if (bid != Blocks.air) bid = Blocks.lit_redstone_lamp; 
/*      */             } else {
/* 4745 */               bid = Blocks.air;
/*      */             } 
/*      */           }
/*      */           
/* 4749 */           OreSpawnMain.setBlockFast(world, cposx + n, cposy + j, cposz + i1, bid, meta, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 4755 */     BlockSlab blockSlab = Blocks.stone_slab;
/* 4756 */     meta = 0;
/* 4757 */     j = height; int i;
/* 4758 */     for (i = -1; i <= width; i++) {
/* 4759 */       for (int n = -1; n <= depth; n++) {
/* 4760 */         if ((i == -1 || n == -1 || i == width || n == depth) && (
/* 4761 */           i + n & 0x1) == 1) {
/* 4762 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + n, (Block)blockSlab, meta, 2);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 4768 */     makepoolalter(world, cposx + 1, cposy, cposz + 1);
/* 4769 */     makepoolalter(world, cposx + width - 2, cposy, cposz + depth - 2);
/* 4770 */     makepoolalter(world, cposx + 1, cposy, cposz + depth - 2);
/* 4771 */     makepoolalter(world, cposx + width - 2, cposy, cposz + 1);
/*      */     
/* 4773 */     makepoolalter(world, cposx + width / 2, cposy, cposz + depth / 2);
/* 4774 */     world.setBlock(cposx + width / 2 - 1, cposy + 2, cposz + depth / 2 - 1, OreSpawnMain.CreeperRepellent, 0, 2);
/* 4775 */     world.setBlock(cposx + width / 2 + 1, cposy + 2, cposz + depth / 2 + 1, OreSpawnMain.CreeperRepellent, 0, 2);
/* 4776 */     world.setBlock(cposx + width / 2 - 1, cposy + 2, cposz + depth / 2 + 1, OreSpawnMain.CreeperRepellent, 0, 2);
/* 4777 */     world.setBlock(cposx + width / 2 + 1, cposy + 2, cposz + depth / 2 - 1, OreSpawnMain.CreeperRepellent, 0, 2);
/*      */     
/* 4779 */     world.setBlock(cposx + width / 2 - 2, cposy + 1, cposz + depth / 2, Blocks.mob_spawner, 0, 2);
/* 4780 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 - 2, cposy + 1, cposz + depth / 2);
/* 4781 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Molenoid");
/*      */     
/* 4783 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 + 2, cposy + 1, cposz + depth / 2, Blocks.trapdoor, 3, 2);
/* 4784 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 + 2, cposy, cposz + depth / 2, Blocks.air, 0, 2);
/* 4785 */     i = cposx + width / 2 + 2;
/* 4786 */     int k = cposz + depth / 2;
/* 4787 */     for (j = 1; j < baseheight; j++) {
/* 4788 */       OreSpawnMain.setBlockFast(world, i, cposy - j, k + 1, Blocks.cobblestone, 0, 2);
/* 4789 */       OreSpawnMain.setBlockFast(world, i, cposy - j, k, Blocks.ladder, 2, 2);
/*      */     } 
/*      */     
/* 4792 */     makeincagraves(world, cposx - baseheight, cposy - baseheight, cposz - baseheight, basewidth, basedepth);
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
/*      */   private void makepoolalter(World world, int cposx, int cposy, int cposz) {
/* 4815 */     for (int i = -1; i <= 1; i++) {
/* 4816 */       for (int k = -1; k <= 1; k++) {
/* 4817 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + 1, cposz + k, Blocks.cobblestone, 0, 2);
/*      */       }
/*      */     } 
/* 4820 */     OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz, Blocks.water, 0, 2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void makeincagraves(World world, int cposx, int cposy, int cposz, int width, int depth) {
/*      */     int i;
/* 4827 */     for (i = 5; i < width - 5; i += 6) {
/* 4828 */       makeincagrave(world, cposx + i, cposy, cposz + 5, 1);
/*      */     }
/*      */     
/* 4831 */     for (i = 5; i < width - 5; i += 6) {
/* 4832 */       makeincagrave(world, cposx + i, cposy, cposz + 10, 1);
/*      */     }
/*      */     
/* 4835 */     for (i = 5; i < width - 5; i += 6) {
/* 4836 */       makeincagrave(world, cposx + i, cposy, cposz + 20, 3);
/*      */     }
/*      */     
/* 4839 */     for (i = 5; i < width - 5; i += 6) {
/* 4840 */       makeincagrave(world, cposx + i, cposy, cposz + 25, 3);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void makeincagrave(World world, int cposx, int cposy, int cposz, int dir) {
/* 4847 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 4848 */     TileEntityChest chest = null;
/* 4849 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 4851 */     chestContents = this.IncaPyramidContentsList;
/*      */ 
/*      */     
/* 4854 */     if (dir == 1) {
/* 4855 */       OreSpawnMain.setBlockFast(world, cposx - 1, cposy, cposz, (Block)Blocks.grass, 0, 2);
/* 4856 */       OreSpawnMain.setBlockFast(world, cposx - 1, cposy + 1, cposz, (Block)Blocks.red_flower, 0, 2);
/* 4857 */       OreSpawnMain.setBlockFast(world, cposx - 1, cposy, cposz + 1, (Block)Blocks.grass, 0, 2);
/* 4858 */       OreSpawnMain.setBlockFast(world, cposx - 1, cposy + 1, cposz + 1, (Block)Blocks.yellow_flower, 0, 2);
/* 4859 */       OreSpawnMain.setBlockFast(world, cposx - 1, cposy, cposz + 2, (Block)Blocks.grass, 0, 2);
/* 4860 */       OreSpawnMain.setBlockFast(world, cposx - 1, cposy + 1, cposz + 2, (Block)Blocks.red_flower, 0, 2);
/*      */       
/* 4862 */       OreSpawnMain.setBlockFast(world, cposx + 1, cposy, cposz, (Block)Blocks.grass, 0, 2);
/* 4863 */       OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz, (Block)Blocks.red_flower, 0, 2);
/* 4864 */       OreSpawnMain.setBlockFast(world, cposx + 1, cposy, cposz + 1, (Block)Blocks.grass, 0, 2);
/* 4865 */       OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz + 1, (Block)Blocks.yellow_flower, 0, 2);
/* 4866 */       OreSpawnMain.setBlockFast(world, cposx + 1, cposy, cposz + 2, (Block)Blocks.grass, 0, 2);
/* 4867 */       OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz + 2, (Block)Blocks.red_flower, 0, 2);
/*      */       
/* 4869 */       OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz, Blocks.stone, 0, 2);
/* 4870 */       OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz + 1, (Block)Blocks.stone_slab, 0, 2);
/* 4871 */       OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz + 2, (Block)Blocks.stone_slab, 0, 2);
/* 4872 */       if (world.rand.nextInt(3) == 1) {
/* 4873 */         world.setBlock(cposx, cposy + 2, cposz, Blocks.mob_spawner, 0, 2);
/* 4874 */         tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 2, cposz);
/* 4875 */         if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ghost");
/*      */       
/*      */       } 
/* 4878 */       world.setBlock(cposx, cposy + 1, cposz - 1, (Block)Blocks.chest, 2, 2);
/* 4879 */       chest = getChestTileEntity(world, cposx, cposy + 1, cposz - 1);
/* 4880 */       if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 10 + world.rand.nextInt(5));
/*      */     
/*      */     } 
/* 4883 */     if (dir == 3) {
/* 4884 */       OreSpawnMain.setBlockFast(world, cposx - 1, cposy, cposz, (Block)Blocks.grass, 0, 2);
/* 4885 */       OreSpawnMain.setBlockFast(world, cposx - 1, cposy + 1, cposz, (Block)Blocks.red_flower, 0, 2);
/* 4886 */       OreSpawnMain.setBlockFast(world, cposx - 1, cposy, cposz - 1, (Block)Blocks.grass, 0, 2);
/* 4887 */       OreSpawnMain.setBlockFast(world, cposx - 1, cposy + 1, cposz - 1, (Block)Blocks.yellow_flower, 0, 2);
/* 4888 */       OreSpawnMain.setBlockFast(world, cposx - 1, cposy, cposz - 2, (Block)Blocks.grass, 0, 2);
/* 4889 */       OreSpawnMain.setBlockFast(world, cposx - 1, cposy + 1, cposz - 2, (Block)Blocks.red_flower, 0, 2);
/*      */       
/* 4891 */       OreSpawnMain.setBlockFast(world, cposx + 1, cposy, cposz, (Block)Blocks.grass, 0, 2);
/* 4892 */       OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz, (Block)Blocks.red_flower, 0, 2);
/* 4893 */       OreSpawnMain.setBlockFast(world, cposx + 1, cposy, cposz - 1, (Block)Blocks.grass, 0, 2);
/* 4894 */       OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz - 1, (Block)Blocks.yellow_flower, 0, 2);
/* 4895 */       OreSpawnMain.setBlockFast(world, cposx + 1, cposy, cposz - 2, (Block)Blocks.grass, 0, 2);
/* 4896 */       OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz - 2, (Block)Blocks.red_flower, 0, 2);
/*      */       
/* 4898 */       OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz, Blocks.stone, 0, 2);
/* 4899 */       OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz - 1, (Block)Blocks.stone_slab, 0, 2);
/* 4900 */       OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz - 2, (Block)Blocks.stone_slab, 0, 2);
/*      */       
/* 4902 */       if (world.rand.nextInt(3) == 1) {
/* 4903 */         world.setBlock(cposx, cposy + 2, cposz, Blocks.mob_spawner, 0, 2);
/* 4904 */         tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 2, cposz);
/* 4905 */         if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ghost");
/*      */       
/*      */       } 
/* 4908 */       world.setBlock(cposx, cposy + 1, cposz + 1, (Block)Blocks.chest, 2, 2);
/* 4909 */       chest = getChestTileEntity(world, cposx, cposy + 1, cposz + 1);
/* 4910 */       if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 10 + world.rand.nextInt(5));
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeRobotLab(World world, int cposx, int cposy, int cposz) {
/* 4920 */     Block bid = Blocks.air;
/* 4921 */     int meta = 0;
/*      */ 
/*      */ 
/*      */     
/* 4925 */     int width = 10;
/* 4926 */     int length = 20;
/* 4927 */     int height = 5;
/*      */     
/* 4929 */     if (world.isRemote) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4936 */     for (int j = 0; j <= height; j++) {
/* 4937 */       for (int i = 0; i < width; i++) {
/* 4938 */         for (int k = 0; k < length; k++) {
/* 4939 */           bid = Blocks.air;
/* 4940 */           if (i == 0 || k == 0 || i == width - 1 || k == length - 1) bid = Blocks.quartz_block; 
/* 4941 */           if (j == 0) {
/* 4942 */             bid = Blocks.quartz_block;
/* 4943 */             if (i == width / 2 || i == width / 2 - 1) bid = Blocks.iron_block; 
/*      */           } 
/* 4945 */           if (j == height) {
/* 4946 */             bid = Blocks.quartz_block;
/* 4947 */             if (i == 0 || k == 0 || i == width - 1 || k == length - 1) bid = Blocks.air; 
/*      */           } 
/* 4949 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 4954 */     OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + 1, cposz, Blocks.air, 0, 2);
/* 4955 */     OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + 2, cposz, Blocks.air, 0, 2);
/* 4956 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 - 1, cposy + 1, cposz, Blocks.air, 0, 2);
/* 4957 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 - 1, cposy + 2, cposz, Blocks.air, 0, 2);
/* 4958 */     ItemDoor.placeDoorBlock(world, cposx + width / 2, cposy + 1, cposz, 3, Blocks.iron_door);
/* 4959 */     ItemDoor.placeDoorBlock(world, cposx + width / 2 - 1, cposy + 1, cposz, 3, Blocks.iron_door);
/*      */     
/* 4961 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 - 2, cposy + 2, cposz - 1, Blocks.stone_button, 4, 2);
/* 4962 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 + 1, cposy + 2, cposz - 1, Blocks.stone_button, 4, 2);
/*      */     
/* 4964 */     makerobomain(world, cposx, cposy, cposz + length - 1);
/*      */     
/* 4966 */     makerobopillar(world, cposx, cposy, cposz + length / 3, 0);
/* 4967 */     makerobopillar(world, cposx, cposy, cposz + length * 2 / 3, 0);
/* 4968 */     makerobopillar(world, cposx, cposy, cposz + length - 1, 0);
/* 4969 */     makerobopillar(world, cposx + width - 1, cposy, cposz + length / 3, 1);
/* 4970 */     makerobopillar(world, cposx + width - 1, cposy, cposz + length * 2 / 3, 1);
/* 4971 */     makerobopillar(world, cposx + width - 1, cposy, cposz + length - 1, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void makerobopillar(World world, int cposx, int cposy, int cposz, int dir) {
/* 4977 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */ 
/*      */     
/* 4980 */     for (int j = 0; j < 5; j++) {
/* 4981 */       for (int i = -1; i < 2; i++) {
/* 4982 */         for (int k = -1; k < 2; k++) {
/* 4983 */           Block bid = Blocks.quartz_block;
/* 4984 */           if (j == 2 || j == 3) {
/* 4985 */             if (k == 0 && (i == -1 || i == 1)) {
/* 4986 */               bid = Blocks.redstone_block;
/*      */             }
/* 4988 */             if (i == 0 && (k == -1 || k == 1)) {
/* 4989 */               bid = Blocks.redstone_block;
/*      */             }
/*      */           } 
/* 4992 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 4997 */     if (dir == 0) {
/* 4998 */       world.setBlock(cposx + 1, cposy + 1, cposz, Blocks.mob_spawner, 0, 2);
/* 4999 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + 1, cposy + 1, cposz);
/* 5000 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Robo-Sniper"); 
/*      */     } 
/* 5002 */     if (dir == 1) {
/* 5003 */       world.setBlock(cposx - 1, cposy + 1, cposz, Blocks.mob_spawner, 0, 2);
/* 5004 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx - 1, cposy + 1, cposz);
/* 5005 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Robo-Sniper");
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void makerobomain(World world, int cposx, int cposy, int cposz) {
/* 5013 */     Block bid = Blocks.air;
/*      */ 
/*      */ 
/*      */     
/* 5017 */     int width = 30;
/* 5018 */     int length = 30;
/* 5019 */     int height = 9;
/* 5020 */     cposx -= 10;
/*      */ 
/*      */     
/* 5023 */     for (int j = 0; j <= height; j++) {
/* 5024 */       for (int i = 0; i < width; i++) {
/* 5025 */         for (int k = 0; k < length; k++) {
/* 5026 */           bid = Blocks.air;
/* 5027 */           if (i == 0 || k == 0 || i == width - 1 || k == length - 1) bid = Blocks.quartz_block; 
/* 5028 */           if (j == 0) {
/* 5029 */             bid = Blocks.quartz_block;
/* 5030 */             if (i == width / 2 || i == width / 2 - 1) bid = Blocks.iron_block; 
/*      */           } 
/* 5032 */           if (j == height) {
/* 5033 */             bid = Blocks.quartz_block;
/* 5034 */             if (i == 0 || k == 0 || i == width - 1 || k == length - 1) bid = Blocks.air; 
/*      */           } 
/* 5036 */           if ((j == 1 || j == 2 || j == 3) && 
/* 5037 */             k == 0 && 
/* 5038 */             i >= width / 3 && i < width * 2 / 3) bid = Blocks.air;
/*      */ 
/*      */           
/* 5041 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 5046 */     makeroboaltar(world, cposx + width / 2 - 4, cposy, cposz + 6);
/* 5047 */     makeroborailway(world, cposx + 3, cposy, cposz + 10);
/* 5048 */     makeroboassemblyline(world, cposx + width - 4, cposy, cposz + 4);
/* 5049 */     makerobotreasureroom(world, cposx + 9, cposy, cposz + 18);
/* 5050 */     makerobotower(world, cposx + width / 2 - 6, cposy + height, cposz + length / 2 - 6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makerobotower(World world, int cposx, int cposy, int cposz) {
/* 5058 */     Block bid = Blocks.air;
/*      */     
/*      */     int j;
/* 5061 */     for (j = 0; j < 2; j++) {
/* 5062 */       for (int i = 0; i < 12; i++) {
/* 5063 */         for (int k = 0; k < 12; k++) {
/* 5064 */           bid = Blocks.air;
/*      */           
/* 5066 */           if (j == 1) {
/* 5067 */             if (i == 0 || k == 0 || i == 11 || k == 11) bid = Blocks.iron_bars; 
/* 5068 */             if (i == 0 && (k == 0 || k == 11)) bid = Blocks.redstone_block; 
/* 5069 */             if (i == 11 && (k == 0 || k == 11)) bid = Blocks.redstone_block; 
/*      */           } 
/* 5071 */           if (j == 0) bid = Blocks.quartz_block; 
/* 5072 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 5077 */     makerobopillar(world, cposx + 4, cposy + 1, cposz + 4, 1);
/* 5078 */     makerobopillar(world, cposx + 7, cposy + 1, cposz + 7, 0);
/* 5079 */     makerobopillar(world, cposx + 4, cposy + 1, cposz + 7, 1);
/* 5080 */     makerobopillar(world, cposx + 7, cposy + 1, cposz + 4, 0);
/*      */     
/* 5082 */     for (j = 5; j < 35; j++) {
/* 5083 */       for (int i = 0; i < 2; i++) {
/* 5084 */         for (int k = 0; k < 3; k++) {
/* 5085 */           bid = Blocks.air;
/* 5086 */           if (j < 15) {
/* 5087 */             bid = Blocks.quartz_block;
/* 5088 */           } else if (j < 25) {
/* 5089 */             bid = Blocks.quartz_block;
/* 5090 */             if (k == 2) bid = Blocks.iron_bars; 
/*      */           } else {
/* 5092 */             bid = Blocks.quartz_block;
/* 5093 */             if (k == 1) bid = Blocks.iron_bars; 
/* 5094 */             if (k == 2) bid = Blocks.air; 
/*      */           } 
/* 5096 */           OreSpawnMain.setBlockFast(world, cposx + i + 5, cposy + j, cposz + k + 5, bid, 0, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeroboaltar(World world, int cposx, int cposy, int cposz) {
/* 5107 */     Block bid = Blocks.air;
/*      */     
/* 5109 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */     
/* 5111 */     bid = Blocks.iron_block; int i;
/* 5112 */     for (i = 0; i < 8; i++) {
/* 5113 */       for (int k = 0; k < 8; k++) {
/* 5114 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/* 5117 */     bid = Blocks.quartz_block;
/* 5118 */     for (i = 0; i < 6; i++) {
/* 5119 */       for (int k = 0; k < 6; k++) {
/* 5120 */         OreSpawnMain.setBlockFast(world, cposx + i + 1, cposy + 1, cposz + k + 1, bid, 0, 2);
/*      */       }
/*      */     } 
/*      */     
/* 5124 */     OreSpawnMain.setBlockFast(world, cposx + 2, cposy + 1, cposz + 2, Blocks.redstone_block, 0, 2);
/* 5125 */     OreSpawnMain.setBlockFast(world, cposx + 2, cposy + 2, cposz + 2, Blocks.torch, 0, 2);
/* 5126 */     OreSpawnMain.setBlockFast(world, cposx + 5, cposy + 1, cposz + 5, Blocks.redstone_block, 0, 2);
/* 5127 */     OreSpawnMain.setBlockFast(world, cposx + 5, cposy + 2, cposz + 5, Blocks.torch, 0, 2);
/* 5128 */     OreSpawnMain.setBlockFast(world, cposx + 5, cposy + 1, cposz + 2, Blocks.redstone_block, 0, 2);
/* 5129 */     OreSpawnMain.setBlockFast(world, cposx + 5, cposy + 2, cposz + 2, Blocks.torch, 0, 2);
/* 5130 */     OreSpawnMain.setBlockFast(world, cposx + 2, cposy + 1, cposz + 5, Blocks.redstone_block, 0, 2);
/* 5131 */     OreSpawnMain.setBlockFast(world, cposx + 2, cposy + 2, cposz + 5, Blocks.torch, 0, 2);
/*      */     
/* 5133 */     world.setBlock(cposx + 3, cposy + 2, cposz + 3, Blocks.mob_spawner, 0, 2);
/* 5134 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 3, cposy + 2, cposz + 3);
/* 5135 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Robo-Pounder"); 
/* 5136 */     world.setBlock(cposx + 4, cposy + 2, cposz + 4, Blocks.mob_spawner, 0, 2);
/* 5137 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 4, cposy + 2, cposz + 4);
/* 5138 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Robo-Pounder");
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeroborailway(World world, int cposx, int cposy, int cposz) {
/* 5146 */     OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 0, Blocks.rail, 0, 2);
/* 5147 */     OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 0, Blocks.rail, 0, 2);
/*      */     
/* 5149 */     OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 1, Blocks.rail, 0, 2);
/* 5150 */     OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 1, Blocks.rail, 0, 2);
/*      */     
/* 5152 */     OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 2, Blocks.golden_rail, 0, 2);
/* 5153 */     OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz + 2, Blocks.lever, 5, 2);
/* 5154 */     OreSpawnMain.setBlockFast(world, cposx + 2, cposy + 1, cposz + 2, Blocks.lever, 5, 2);
/* 5155 */     OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 2, Blocks.golden_rail, 0, 2);
/*      */     
/* 5157 */     OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 3, Blocks.rail, 0, 2);
/* 5158 */     OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 3, Blocks.rail, 0, 2);
/*      */     
/* 5160 */     OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 4, Blocks.rail, 0, 2);
/* 5161 */     OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 4, Blocks.rail, 0, 2);
/*      */     
/* 5163 */     OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 5, Blocks.rail, 0, 2);
/* 5164 */     OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 5, Blocks.rail, 0, 2);
/*      */     
/* 5166 */     OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 6, Blocks.golden_rail, 0, 2);
/* 5167 */     OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz + 6, Blocks.lever, 5, 2);
/* 5168 */     OreSpawnMain.setBlockFast(world, cposx + 2, cposy + 1, cposz + 6, Blocks.lever, 5, 2);
/* 5169 */     OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 6, Blocks.golden_rail, 0, 2);
/*      */     
/* 5171 */     OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 7, Blocks.rail, 0, 2);
/* 5172 */     OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 7, Blocks.rail, 0, 2);
/*      */     
/* 5174 */     OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 8, Blocks.rail, 0, 2);
/* 5175 */     OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 8, Blocks.rail, 0, 2);
/*      */     
/* 5177 */     OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 9, Blocks.rail, 0, 2);
/* 5178 */     OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 9, Blocks.rail, 0, 2);
/*      */     
/* 5180 */     OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 10, Blocks.golden_rail, 0, 2);
/* 5181 */     OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz + 10, Blocks.lever, 5, 2);
/* 5182 */     OreSpawnMain.setBlockFast(world, cposx + 2, cposy + 1, cposz + 10, Blocks.lever, 5, 2);
/* 5183 */     OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 10, Blocks.golden_rail, 0, 2);
/*      */     
/* 5185 */     OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 11, Blocks.rail, 0, 2);
/* 5186 */     OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 11, Blocks.rail, 0, 2);
/*      */     
/* 5188 */     OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 12, Blocks.rail, 0, 2);
/* 5189 */     OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 12, Blocks.rail, 0, 2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeroboassemblyline(World world, int cposx, int cposy, int cposz) {
/* 5198 */     for (int k = 0; k < 24; k++) {
/* 5199 */       if (k % 3 == 1) {
/* 5200 */         OreSpawnMain.setBlockFast(world, cposx - 2, cposy + 1, cposz + k, Blocks.quartz_stairs, 1, 2);
/* 5201 */         OreSpawnMain.setBlockFast(world, cposx, cposy + 2, cposz + k, (Block)Blocks.sticky_piston, 3, 2);
/* 5202 */         OreSpawnMain.setBlockFast(world, cposx, cposy + 3, cposz + k, Blocks.carpet, 0, 2);
/*      */       } 
/* 5204 */       if (k % 3 == 0) {
/* 5205 */         OreSpawnMain.setBlockFast(world, cposx, cposy + 2, cposz + k, Blocks.lever, 13, 2);
/*      */       }
/* 5207 */       OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz + k, Blocks.quartz_block, 0, 2);
/* 5208 */       OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz + k, Blocks.quartz_block, 0, 2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makerobotreasureroom(World world, int cposx, int cposy, int cposz) {
/* 5216 */     Block bid = Blocks.air;
/* 5217 */     TileEntityChest chest = null;
/* 5218 */     WeightedRandomChestContent[] chestContents = null;
/* 5219 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 5220 */     chestContents = this.RobotContentsList;
/*      */ 
/*      */ 
/*      */     
/* 5224 */     for (int j = 1; j < 7; j++) {
/* 5225 */       for (int i = 0; i < 12; i++) {
/* 5226 */         for (int k = 0; k < 8; k++) {
/* 5227 */           bid = Blocks.air;
/* 5228 */           if (i == 0 || k == 0 || i == 11 || k == 7) bid = Blocks.quartz_block; 
/* 5229 */           if (j == 2 && 
/* 5230 */             i == 11) bid = Blocks.iron_bars;
/*      */           
/* 5232 */           if (j == 3 && 
/* 5233 */             bid != Blocks.air) bid = Blocks.iron_bars;
/*      */           
/* 5235 */           if ((j == 1 || j == 2 || j == 3) && 
/* 5236 */             k == 0 && (
/* 5237 */             i == 1 || i == 2)) {
/* 5238 */             bid = Blocks.air;
/*      */           }
/*      */ 
/*      */           
/* 5242 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 5249 */     world.setBlock(cposx + 10, cposy + 1, cposz + 1, Blocks.mob_spawner, 0, 2);
/* 5250 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 10, cposy + 1, cposz + 1);
/* 5251 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Robo-Warrior");
/*      */     
/* 5253 */     world.setBlock(cposx + 8, cposy + 1, cposz + 1, (Block)Blocks.chest, 2, 2);
/* 5254 */     chest = getChestTileEntity(world, cposx + 8, cposy + 1, cposz + 1);
/* 5255 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 10 + world.rand.nextInt(5));
/*      */     
/* 5257 */     world.setBlock(cposx + 6, cposy + 1, cposz + 1, (Block)Blocks.chest, 2, 2);
/* 5258 */     chest = getChestTileEntity(world, cposx + 6, cposy + 1, cposz + 1);
/* 5259 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 10 + world.rand.nextInt(5));
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeKingAltar(World world, int cposx, int cposy, int cposz) {
/* 5267 */     Block bid = Blocks.air;
/*      */ 
/*      */ 
/*      */     
/* 5271 */     int width = 51;
/* 5272 */     int length = 51;
/* 5273 */     int height = 48;
/*      */     
/* 5275 */     if (world.isRemote) {
/*      */       return;
/*      */     }
/*      */     
/*      */     int j;
/*      */     
/* 5281 */     for (j = 0; j <= height + 10; j++) {
/* 5282 */       for (int k = -5; k < width + 5; k++) {
/* 5283 */         for (int m = -5; m < length + 5; m++) {
/* 5284 */           bid = Blocks.air;
/* 5285 */           OreSpawnMain.setBlockFast(world, cposx + k, cposy + j, cposz + m, bid, 0, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/* 5289 */     j = 0; int i;
/* 5290 */     for (i = 0; i < width; i++) {
/* 5291 */       for (int k = 0; k < length; k++) {
/* 5292 */         BlockGrass blockGrass = Blocks.grass;
/* 5293 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, (Block)blockGrass, 0, 2);
/* 5294 */         for (int v = 1; v < 10; v++) {
/* 5295 */           Block block = world.getBlock(cposx + i, cposy + j - v, cposz + k);
/* 5296 */           if (block == Blocks.air || block == Blocks.tallgrass || block == Blocks.water) {
/* 5297 */             block = Blocks.dirt;
/* 5298 */             OreSpawnMain.setBlockFast(world, cposx + i, cposy + j - v, cposz + k, block, 0, 2);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 5304 */     makekingcolumn(world, cposx + 1, cposy + 1, cposz + 1);
/* 5305 */     makekingcolumn(world, cposx + width - 8, cposy + 1, cposz + length - 8);
/* 5306 */     makekingcolumn(world, cposx + 1, cposy + 1, cposz + length - 8);
/* 5307 */     makekingcolumn(world, cposx + width - 8, cposy + 1, cposz + 1);
/*      */ 
/*      */     
/* 5310 */     j = height - 1;
/* 5311 */     bid = Blocks.quartz_block;
/* 5312 */     for (i = 0; i < width; i++) {
/* 5313 */       for (int k = 0; k < length; k++) {
/* 5314 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/* 5317 */     j = height;
/* 5318 */     bid = Blocks.quartz_block;
/* 5319 */     for (i = -1; i <= width; i++) {
/* 5320 */       for (int k = -1; k <= length; k++) {
/* 5321 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/*      */     
/* 5325 */     makekingbackground(world, cposx + 4, cposy + 10, cposz + 9);
/* 5326 */     makekingcenteraltar(world, cposx + width / 2, cposy, cposz + length / 2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void makekingcolumn(World world, int cposx, int cposy, int cposz) {
/* 5335 */     Block bid = Blocks.air;
/* 5336 */     int meta = 0;
/*      */ 
/*      */ 
/*      */     
/* 5340 */     int width = 5;
/* 5341 */     int length = 5;
/* 5342 */     int height = 44;
/*      */     
/* 5344 */     if (world.isRemote) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 5350 */     int j = 0;
/* 5351 */     bid = Blocks.quartz_block; int i;
/* 5352 */     for (i = 0; i < width + 2; i++) {
/* 5353 */       for (int k = 0; k < length + 2; k++) {
/* 5354 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, meta, 2);
/* 5355 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + height + 1, cposz + k, bid, meta, 2);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 5360 */     cposx++; cposz++; cposy++;
/* 5361 */     for (j = 0; j < height; j++) {
/* 5362 */       for (i = 0; i < width; i++) {
/* 5363 */         for (int k = 0; k < length; k++) {
/* 5364 */           bid = Blocks.air;
/* 5365 */           if (i == 0 || k == 0 || i == width - 1 || k == length - 1) bid = Blocks.quartz_block; 
/* 5366 */           if (j % 4 == 0 && 
/* 5367 */             bid != Blocks.air && (
/* 5368 */             i == 2 || k == 2)) bid = Blocks.gold_block;
/*      */ 
/*      */           
/* 5371 */           if (j % 4 == 1 && 
/* 5372 */             bid != Blocks.air) {
/* 5373 */             if (i == 1 || k == 1) bid = Blocks.gold_block; 
/* 5374 */             if (i == 3 || k == 3) bid = Blocks.gold_block;
/*      */           
/*      */           } 
/* 5377 */           if (j % 4 == 2 && 
/* 5378 */             bid != Blocks.air) {
/* 5379 */             if (i == 1 || k == 1) bid = Blocks.gold_block; 
/* 5380 */             if (i == 3 || k == 3) bid = Blocks.gold_block; 
/* 5381 */             if (i == 2 || k == 2) bid = Blocks.emerald_block;
/*      */           
/*      */           } 
/* 5384 */           if (j % 4 == 3 && 
/* 5385 */             bid != Blocks.air) {
/* 5386 */             if (i == 1 || k == 1) bid = Blocks.gold_block; 
/* 5387 */             if (i == 3 || k == 3) bid = Blocks.gold_block;
/*      */           
/*      */           } 
/* 5390 */           meta = 0;
/* 5391 */           if (bid == Blocks.quartz_block) meta = 2; 
/* 5392 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, meta, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/* 5398 */   private int[] king = new int[] { -1, -1, 24, 3, -1, 24, 5, -1, 17, 12, -1, 16, 15, -1, 15, 14, -1, 15, 6, 3, 5, -1, 14, 6, 4, 3, -1, 14, 5, -1, 14, 5, -1, 12, 9, -1, 11, 11, -1, 8, 17, -1, 5, 23, -1, 3, 27, -1, 2, 29, -1, 1, 31, -1, 0, 33, -1, 13, 6, -1, 12, 9, -1, 11, 3, 1, 2, 1, 4, -1, 10, 3, 2, 2, 3, 2, -1, 10, 2, 4, 2, 3, 2, -1, 9, 2, 5, 2, 4, 6, -1, 9, 2, 5, 2, 6, 4, -1, 8, 2, 6, 1, -1, 8, 2, 5, 2, -1, 8, 2, 5, 2, -1, 8, 2, 5, 2, -1, 15, 2, -1, -1, -1 };
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
/*      */   private void makekingbackground(World world, int cposx, int cposy, int cposz) {
/* 5434 */     Block bid = Blocks.air;
/* 5435 */     int meta = 0;
/* 5436 */     int curz = 0;
/* 5437 */     int cury = 0;
/* 5438 */     int height = 33;
/* 5439 */     int width = 33;
/*      */     
/* 5441 */     bid = Blocks.stone;
/* 5442 */     for (int m = 0; m < this.king.length; m++) {
/* 5443 */       int v = this.king[m];
/* 5444 */       if (v < 0) {
/* 5445 */         bid = Blocks.stone;
/* 5446 */         while (curz < width) {
/* 5447 */           OreSpawnMain.setBlockFast(world, cposx, cposy + cury, cposz + curz, bid, 0, 2);
/* 5448 */           curz++;
/*      */         } 
/* 5450 */         cury++;
/* 5451 */         curz = 0;
/*      */       } else {
/* 5453 */         for (int n = 0; n < v; n++) {
/* 5454 */           OreSpawnMain.setBlockFast(world, cposx, cposy + cury, cposz + curz, bid, 0, 2);
/* 5455 */           curz++;
/*      */         } 
/* 5457 */         if (bid == Blocks.stone) {
/* 5458 */           bid = Blocks.quartz_block;
/*      */         } else {
/* 5460 */           bid = Blocks.stone;
/*      */         } 
/*      */       } 
/*      */     }  int i;
/* 5464 */     for (i = 0; i < width; i++) {
/* 5465 */       OreSpawnMain.setBlockFast(world, cposx, cposy - 1, cposz + i, Blocks.gold_block, 0, 2);
/*      */     }
/* 5467 */     for (i = 0; i < width; i++) {
/* 5468 */       OreSpawnMain.setBlockFast(world, cposx, cposy + height, cposz + i, Blocks.gold_block, 0, 2);
/*      */     }
/* 5470 */     for (i = -1; i <= height; i++) {
/* 5471 */       OreSpawnMain.setBlockFast(world, cposx, cposy + i, cposz - 1, Blocks.gold_block, 0, 2);
/*      */     }
/* 5473 */     for (i = -1; i <= height; i++) {
/* 5474 */       OreSpawnMain.setBlockFast(world, cposx, cposy + i, cposz + width, Blocks.gold_block, 0, 2);
/*      */     }
/*      */ 
/*      */     
/* 5478 */     OreSpawnMain.setBlockFast(world, cposx, cposy - 2, cposz - 2, Blocks.diamond_block, 0, 2);
/* 5479 */     OreSpawnMain.setBlockFast(world, cposx, cposy + height + 1, cposz + width + 1, Blocks.diamond_block, 0, 2);
/* 5480 */     OreSpawnMain.setBlockFast(world, cposx, cposy - 2, cposz + width + 1, Blocks.diamond_block, 0, 2);
/* 5481 */     OreSpawnMain.setBlockFast(world, cposx, cposy + height + 1, cposz - 2, Blocks.diamond_block, 0, 2);
/*      */     
/* 5483 */     OreSpawnMain.setBlockFast(world, cposx, cposy - 1, cposz - 2, OreSpawnMain.CrystalTorch, 0, 2);
/* 5484 */     OreSpawnMain.setBlockFast(world, cposx, cposy + height + 2, cposz + width + 1, OreSpawnMain.CrystalTorch, 0, 2);
/* 5485 */     OreSpawnMain.setBlockFast(world, cposx, cposy - 1, cposz + width + 1, OreSpawnMain.CrystalTorch, 0, 2);
/* 5486 */     OreSpawnMain.setBlockFast(world, cposx, cposy + height + 2, cposz - 2, OreSpawnMain.CrystalTorch, 0, 2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void makekingcenteraltar(World world, int cposx, int cposy, int cposz) {
/* 5492 */     Block bid = Blocks.air;
/* 5493 */     int meta = 0;
/*      */ 
/*      */ 
/*      */     
/* 5497 */     int width = 10;
/* 5498 */     int length = 10;
/* 5499 */     int j = 0;
/* 5500 */     bid = Blocks.quartz_block; int i;
/* 5501 */     for (i = -width; i <= width; i++) {
/* 5502 */       for (int k = -length; k <= length; k++) {
/* 5503 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/*      */     
/* 5507 */     width = 6;
/* 5508 */     length = 20;
/* 5509 */     j = 0;
/* 5510 */     bid = Blocks.quartz_block;
/* 5511 */     for (i = -width; i <= width; i++) {
/* 5512 */       for (int k = -length; k <= length; k++) {
/* 5513 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/* 5516 */     width = 20;
/* 5517 */     length = 6;
/* 5518 */     j = 0;
/* 5519 */     bid = Blocks.quartz_block;
/* 5520 */     for (i = -width; i <= width; i++) {
/* 5521 */       for (int k = -length; k <= length; k++) {
/* 5522 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 5527 */     width = 8;
/* 5528 */     length = 8;
/* 5529 */     j = 1;
/* 5530 */     for (i = -width; i <= width; i++) {
/* 5531 */       for (int k = -length; k <= length; k++) {
/* 5532 */         bid = Blocks.quartz_block;
/* 5533 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       } 
/*      */     } 
/* 5536 */     width = 4;
/* 5537 */     length = 18;
/* 5538 */     j = 1;
/*      */     
/* 5540 */     for (i = -width; i <= width; i++) {
/* 5541 */       for (int k = -length; k <= length; k++) {
/* 5542 */         bid = Blocks.quartz_block;
/* 5543 */         if (i == width && (
/* 5544 */           k == -length || k == length)) bid = Blocks.lapis_block;
/*      */         
/* 5546 */         if (i == -width && (
/* 5547 */           k == -length || k == length)) bid = Blocks.lapis_block;
/*      */         
/* 5549 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       } 
/*      */     } 
/* 5552 */     width = 18;
/* 5553 */     length = 4;
/* 5554 */     j = 1;
/* 5555 */     for (i = -width; i <= width; i++) {
/* 5556 */       for (int k = -length; k <= length; k++) {
/* 5557 */         bid = Blocks.quartz_block;
/* 5558 */         if (i == width && (
/* 5559 */           k == -length || k == length)) bid = Blocks.lapis_block;
/*      */         
/* 5561 */         if (i == -width && (
/* 5562 */           k == -length || k == length)) bid = Blocks.lapis_block;
/*      */         
/* 5564 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 5569 */     width = 7;
/* 5570 */     length = 7;
/* 5571 */     j = 2;
/* 5572 */     bid = Blocks.quartz_block;
/* 5573 */     for (i = -width; i <= width; i++) {
/* 5574 */       for (int k = -length; k <= length; k++) {
/* 5575 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/* 5576 */         if (i == width && (
/* 5577 */           k == -length || k == length)) {
/* 5578 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
/*      */         }
/*      */         
/* 5581 */         if (i == -width && (
/* 5582 */           k == -length || k == length)) {
/* 5583 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 5588 */     width = 3;
/* 5589 */     length = 17;
/* 5590 */     j = 2;
/* 5591 */     bid = Blocks.quartz_block;
/* 5592 */     for (i = -width; i <= width; i++) {
/* 5593 */       for (int k = -length; k <= length; k++) {
/* 5594 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/* 5597 */     width = 17;
/* 5598 */     length = 3;
/* 5599 */     j = 2;
/* 5600 */     bid = Blocks.quartz_block;
/* 5601 */     for (i = -width; i <= width; i++) {
/* 5602 */       for (int k = -length; k <= length; k++) {
/* 5603 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/*      */     
/* 5607 */     width = 6;
/* 5608 */     length = 6;
/* 5609 */     j = 3;
/* 5610 */     bid = Blocks.quartz_block;
/* 5611 */     for (i = -width; i <= width; i++) {
/* 5612 */       for (int k = -length; k <= length; k++) {
/* 5613 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/* 5616 */     width = 2;
/* 5617 */     length = 16;
/* 5618 */     j = 3;
/* 5619 */     bid = Blocks.quartz_block;
/* 5620 */     for (i = -width; i <= width; i++) {
/* 5621 */       for (int k = -length; k <= length; k++) {
/* 5622 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/* 5625 */     width = 16;
/* 5626 */     length = 2;
/* 5627 */     j = 3;
/* 5628 */     bid = Blocks.quartz_block;
/* 5629 */     for (i = -width; i <= width; i++) {
/* 5630 */       for (int k = -length; k <= length; k++) {
/* 5631 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 5636 */     width = 2;
/* 5637 */     length = 2;
/* 5638 */     j = 4;
/* 5639 */     bid = Blocks.quartz_block;
/* 5640 */     for (i = -width; i <= width; i++) {
/* 5641 */       for (int k = -length; k <= length; k++) {
/* 5642 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/* 5643 */         if (i == width && (
/* 5644 */           k == -length || k == length)) {
/* 5645 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
/*      */         }
/*      */         
/* 5648 */         if (i == -width && (
/* 5649 */           k == -length || k == length)) {
/* 5650 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 5656 */     world.setBlock(cposx, cposy + j, cposz, (Block)Blocks.chest);
/* 5657 */     world.setBlockMetadataWithNotify(cposx, cposy + j, cposz, 2, 3);
/* 5658 */     TileEntityChest chest = getChestTileEntity(world, cposx, cposy + j, cposz);
/* 5659 */     if (chest != null)
/*      */     {
/* 5661 */       chest.setInventorySlotContents(13, new ItemStack(OreSpawnMain.TheKingEgg));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeLeonNest(World world, int cposx, int cposy, int cposz) {
/* 5670 */     Block bid = Blocks.air;
/* 5671 */     int rad = 10;
/* 5672 */     int dist = 0;
/*      */     
/* 5674 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */     int j;
/* 5676 */     for (j = 0; j <= rad; j++) {
/* 5677 */       for (int i = -rad; i <= rad; i++) {
/* 5678 */         for (int k = -rad; k <= rad; k++) {
/* 5679 */           bid = Blocks.air;
/* 5680 */           dist = j * j + i * i + k * k;
/* 5681 */           dist = (int)Math.sqrt(dist);
/* 5682 */           if (dist <= rad) {
/* 5683 */             if (dist >= rad - 2) {
/* 5684 */               int which = world.rand.nextInt(6);
/* 5685 */               if (which == 0) BlockLeaves blockLeaves = Blocks.leaves; 
/* 5686 */               if (which == 1) bid = Blocks.log; 
/* 5687 */               if (which == 2) bid = Blocks.planks; 
/* 5688 */               if (which == 3) bid = Blocks.dirt; 
/* 5689 */               if (which == 4) bid = Blocks.cobblestone; 
/* 5690 */               if (which == 5) bid = Blocks.mossy_cobblestone; 
/*      */             } 
/* 5692 */             OreSpawnMain.setBlockFast(world, cposx + i, cposy - j, cposz + k, bid, 0, 2);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 5698 */     for (j = 1; j <= 5; j++) {
/* 5699 */       for (int i = -rad; i <= rad; i++) {
/* 5700 */         for (int k = -rad; k <= rad; k++) {
/* 5701 */           bid = Blocks.air;
/* 5702 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 5707 */     world.setBlock(cposx, cposy - rad - 4, cposz, Blocks.mob_spawner, 0, 2);
/* 5708 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy - rad - 4, cposz);
/* 5709 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Leonopteryx");
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeCephadromeAltar(World world, int cposx, int cposy, int cposz) {
/* 5716 */     Block bid = Blocks.air;
/* 5717 */     int meta = 0;
/*      */ 
/*      */ 
/*      */     
/* 5721 */     int width = 4;
/* 5722 */     int length = 4;
/* 5723 */     int j = 0;
/* 5724 */     bid = Blocks.cobblestone; int i;
/* 5725 */     for (i = -width; i <= width; i++) {
/* 5726 */       for (int k = -length; k <= length; k++) {
/* 5727 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/*      */     
/* 5731 */     width = 3;
/* 5732 */     length = 3;
/* 5733 */     j = 1;
/* 5734 */     bid = Blocks.cobblestone;
/* 5735 */     for (i = -width; i <= width; i++) {
/* 5736 */       for (int k = -length; k <= length; k++) {
/* 5737 */         bid = Blocks.cobblestone;
/* 5738 */         if (k == 0 || i == 0) bid = Blocks.stonebrick; 
/* 5739 */         if ((k == -length || k == length) && (
/* 5740 */           i == -width || i == width)) {
/* 5741 */           bid = Blocks.stonebrick;
/*      */         }
/*      */         
/* 5744 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       } 
/*      */     } 
/* 5747 */     width = 3;
/* 5748 */     length = 3;
/* 5749 */     j = 2;
/* 5750 */     for (i = -width; i <= width; i++) {
/* 5751 */       for (int k = -length; k <= length; k++) {
/* 5752 */         bid = Blocks.air;
/* 5753 */         if ((k == -length || k == length) && (
/* 5754 */           i == -width || i == width)) {
/* 5755 */           bid = Blocks.stonebrick;
/*      */         }
/*      */         
/* 5758 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       } 
/*      */     } 
/* 5761 */     width = 3;
/* 5762 */     length = 3;
/* 5763 */     j = 3;
/* 5764 */     for (i = -width; i <= width; i++) {
/* 5765 */       for (int k = -length; k <= length; k++) {
/* 5766 */         bid = Blocks.air;
/* 5767 */         if ((k == -length || k == length) && (
/* 5768 */           i == -width || i == width)) {
/* 5769 */           bid = Blocks.end_stone;
/*      */         }
/*      */         
/* 5772 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       } 
/*      */     } 
/* 5775 */     width = 3;
/* 5776 */     length = 3;
/* 5777 */     j = 4;
/* 5778 */     for (i = -width; i <= width; i++) {
/* 5779 */       for (int k = -length; k <= length; k++) {
/* 5780 */         bid = Blocks.air;
/* 5781 */         if ((k == -length || k == length) && (
/* 5782 */           i == -width || i == width)) {
/* 5783 */           bid = OreSpawnMain.ExtremeTorch;
/*      */         }
/*      */         
/* 5786 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       } 
/*      */     } 
/*      */     
/* 5790 */     width = 2;
/* 5791 */     length = 2;
/* 5792 */     j = 2;
/* 5793 */     bid = Blocks.cobblestone;
/* 5794 */     for (i = -width; i <= width; i++) {
/* 5795 */       for (int k = -length; k <= length; k++) {
/* 5796 */         bid = Blocks.cobblestone;
/* 5797 */         if (k == 0 || i == 0) bid = Blocks.stonebrick; 
/* 5798 */         if ((k == -length || k == length) && (
/* 5799 */           i == -width || i == width)) {
/* 5800 */           bid = Blocks.stonebrick;
/*      */         }
/*      */         
/* 5803 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       } 
/*      */     } 
/* 5806 */     width = 1;
/* 5807 */     length = 1;
/* 5808 */     j = 3;
/* 5809 */     bid = Blocks.cobblestone;
/* 5810 */     for (i = -width; i <= width; i++) {
/* 5811 */       for (int k = -length; k <= length; k++) {
/* 5812 */         bid = Blocks.cobblestone;
/* 5813 */         if (k == 0 && i == 0) bid = OreSpawnMain.MyEyeOfEnderBlock; 
/* 5814 */         if ((k == -length || k == length) && (
/* 5815 */           i == -width || i == width)) {
/* 5816 */           bid = Blocks.end_stone;
/*      */         }
/*      */         
/* 5819 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeCrystalBattleTower(World world, int cposx, int cposy, int cposz) {
/* 5830 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 5831 */     TileEntityChest chest = null;
/* 5832 */     WeightedRandomChestContent[] chestContents = null;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5837 */     float radius = 10.0F; int j;
/* 5838 */     for (j = 0; j <= 20; j++) {
/* 5839 */       Block blk = OreSpawnMain.CrystalStone;
/* 5840 */       if (j % 5 == 0) {
/* 5841 */         float currad; for (currad = 0.0F; currad < radius; currad += 0.33F) {
/* 5842 */           float curdeg; for (curdeg = 0.0F; curdeg < 360.0F; curdeg += 5.0F) {
/* 5843 */             float curx = (float)(currad * Math.cos(Math.toRadians(curdeg)));
/* 5844 */             float curz = (float)(currad * Math.sin(Math.toRadians(curdeg)));
/* 5845 */             FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + j, (int)(cposz + curz + 0.5F), blk);
/*      */           } 
/*      */         } 
/*      */       } else {
/* 5849 */         float currad = 10.0F; float curdeg;
/* 5850 */         for (curdeg = 0.0F; curdeg < 360.0F; curdeg += 5.0F) {
/* 5851 */           float curx = (float)(currad * Math.cos(Math.toRadians(curdeg)));
/* 5852 */           float curz = (float)(currad * Math.sin(Math.toRadians(curdeg)));
/* 5853 */           blk = OreSpawnMain.CrystalStone;
/* 5854 */           if (j % 5 >= 1 && j % 5 <= 3 && (curdeg < 10.0F || curdeg > 350.0F)) blk = Blocks.air; 
/* 5855 */           FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + j, (int)(cposz + curz + 0.5F), blk);
/*      */         } 
/*      */       } 
/*      */     } 
/* 5859 */     radius = 10.0F;
/* 5860 */     for (j = 21; j <= 22; j++) {
/* 5861 */       Block blk = OreSpawnMain.CrystalCrystal;
/* 5862 */       float currad = 10.0F; float curdeg;
/* 5863 */       for (curdeg = 0.0F; curdeg < 360.0F; curdeg += 5.0F) {
/* 5864 */         float curx = (float)(currad * Math.cos(Math.toRadians(curdeg)));
/* 5865 */         float curz = (float)(currad * Math.sin(Math.toRadians(curdeg)));
/* 5866 */         FastSetBlock(world, (int)(cposx + curx + 0.5F), cposy + j, (int)(cposz + curz + 0.5F), blk);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 5872 */     j = 1;
/* 5873 */     chestContents = this.CrystalBattleTowerRatContentsList;
/* 5874 */     world.setBlock(cposx, cposy + j + 1, cposz, Blocks.mob_spawner, 0, 2);
/* 5875 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + j + 1, cposz);
/* 5876 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rat"); 
/* 5877 */     world.setBlock(cposx, cposy + j + 2, cposz, Blocks.mob_spawner, 0, 2);
/* 5878 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + j + 2, cposz);
/* 5879 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rat"); 
/* 5880 */     world.setBlock(cposx, cposy + j, cposz, (Block)Blocks.chest, 0, 2);
/* 5881 */     chest = getChestTileEntity(world, cposx, cposy + j, cposz);
/* 5882 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 5 + world.rand.nextInt(5));
/*      */     
/* 5884 */     j = 6;
/* 5885 */     chestContents = this.CrystalBattleTowerDungeonBeastContentsList;
/* 5886 */     world.setBlock(cposx, cposy + j + 1, cposz, Blocks.mob_spawner, 0, 2);
/* 5887 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + j + 1, cposz);
/* 5888 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Dungeon Beast"); 
/* 5889 */     world.setBlock(cposx, cposy + j + 2, cposz, Blocks.mob_spawner, 0, 2);
/* 5890 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + j + 2, cposz);
/* 5891 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Dungeon Beast"); 
/* 5892 */     world.setBlock(cposx, cposy + j, cposz, (Block)Blocks.chest, 0, 2);
/* 5893 */     chest = getChestTileEntity(world, cposx, cposy + j, cposz);
/* 5894 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 5 + world.rand.nextInt(5));
/*      */     
/* 5896 */     j = 11;
/* 5897 */     chestContents = this.CrystalBattleTowerUrchinContentsList;
/* 5898 */     world.setBlock(cposx, cposy + j + 1, cposz, Blocks.mob_spawner, 0, 2);
/* 5899 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + j + 1, cposz);
/* 5900 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Crystal Urchin"); 
/* 5901 */     world.setBlock(cposx, cposy + j + 2, cposz, Blocks.mob_spawner, 0, 2);
/* 5902 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + j + 2, cposz);
/* 5903 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Crystal Urchin"); 
/* 5904 */     world.setBlock(cposx, cposy + j, cposz, (Block)Blocks.chest, 0, 2);
/* 5905 */     chest = getChestTileEntity(world, cposx, cposy + j, cposz);
/* 5906 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 5 + world.rand.nextInt(5));
/*      */     
/* 5908 */     j = 16;
/* 5909 */     chestContents = this.CrystalBattleTowerRotatorContentsList;
/* 5910 */     world.setBlock(cposx, cposy + j + 1, cposz, Blocks.mob_spawner, 0, 2);
/* 5911 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + j + 1, cposz);
/* 5912 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rotator"); 
/* 5913 */     world.setBlock(cposx, cposy + j + 2, cposz, Blocks.mob_spawner, 0, 2);
/* 5914 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + j + 2, cposz);
/* 5915 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rotator"); 
/* 5916 */     world.setBlock(cposx, cposy + j, cposz, (Block)Blocks.chest, 0, 2);
/* 5917 */     chest = getChestTileEntity(world, cposx, cposy + j, cposz);
/* 5918 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 5 + world.rand.nextInt(5));
/*      */     
/* 5920 */     j = 21;
/* 5921 */     chestContents = this.CrystalBattleTowerVortexContentsList;
/* 5922 */     world.setBlock(cposx, cposy + j + 1, cposz, Blocks.mob_spawner, 0, 2);
/* 5923 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + j + 1, cposz);
/* 5924 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Vortex"); 
/* 5925 */     world.setBlock(cposx, cposy + j + 2, cposz, Blocks.mob_spawner, 0, 2);
/* 5926 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + j + 2, cposz);
/* 5927 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Vortex"); 
/* 5928 */     world.setBlock(cposx, cposy + j, cposz, (Block)Blocks.chest, 0, 2);
/* 5929 */     chest = getChestTileEntity(world, cposx, cposy + j, cposz);
/* 5930 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 6 + world.rand.nextInt(6));
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeGirlfriendIsland(World world, int cposx, int cposy, int cposz) {
/* 5940 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 5941 */     TileEntityChest chest = null;
/* 5942 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 5944 */     chestContents = this.DamselContentsList;
/*      */     
/*      */     int i;
/* 5947 */     for (i = -5; i <= 5; i++) {
/* 5948 */       int k = 3;
/* 5949 */       if (i == -5 || i == 5) k = 1; 
/* 5950 */       if (i == -4 || i == 4) k = 2; 
/* 5951 */       if (i == -3 || i == 3) k = 2; 
/* 5952 */       for (int j = -k; j <= k; j++) {
/* 5953 */         FastSetBlock(world, cposx + i, cposy, cposz + j, (Block)Blocks.sand);
/* 5954 */         FastSetBlock(world, cposx + i, cposy - 1, cposz + j, Blocks.stone);
/*      */       } 
/*      */     } 
/* 5957 */     for (i = -2; i <= 2; i++) {
/* 5958 */       for (int j = -2; j <= 2; j++) {
/* 5959 */         FastSetBlock(world, cposx + i, cposy + 3, cposz + j, (Block)Blocks.leaves);
/*      */       }
/*      */     } 
/* 5962 */     FastSetBlock(world, cposx, cposy + 4, cposz, (Block)Blocks.leaves);
/* 5963 */     FastSetBlock(world, cposx, cposy + 3, cposz, Blocks.log);
/* 5964 */     FastSetBlock(world, cposx, cposy + 2, cposz, Blocks.log);
/* 5965 */     FastSetBlock(world, cposx, cposy + 1, cposz, Blocks.log);
/*      */     
/* 5967 */     FastSetBlock(world, cposx + 1, cposy + 3, cposz + 1, Blocks.log);
/* 5968 */     FastSetBlock(world, cposx - 1, cposy + 3, cposz - 1, Blocks.log);
/* 5969 */     FastSetBlock(world, cposx + 1, cposy + 3, cposz - 1, Blocks.log);
/* 5970 */     FastSetBlock(world, cposx - 1, cposy + 3, cposz + 1, Blocks.log);
/*      */     
/* 5972 */     world.setBlock(cposx + 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
/* 5973 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 1, cposy + 3, cposz);
/* 5974 */     if (tileentitymobspawner != null)
/*      */     {
/* 5976 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Girlfriend");
/*      */     }
/* 5978 */     world.setBlock(cposx - 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
/* 5979 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - 1, cposy + 3, cposz);
/* 5980 */     if (tileentitymobspawner != null)
/*      */     {
/* 5982 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Boyfriend");
/*      */     }
/* 5984 */     world.setBlock(cposx, cposy + 3, cposz + 1, Blocks.mob_spawner, 0, 2);
/* 5985 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 3, cposz + 1);
/* 5986 */     if (tileentitymobspawner != null)
/*      */     {
/* 5988 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Gold Fish");
/*      */     }
/* 5990 */     world.setBlock(cposx, cposy + 3, cposz - 1, Blocks.mob_spawner, 0, 2);
/* 5991 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 3, cposz - 1);
/* 5992 */     if (tileentitymobspawner != null)
/*      */     {
/* 5994 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Gold Fish");
/*      */     }
/*      */ 
/*      */     
/* 5998 */     world.setBlock(cposx, cposy + 1, cposz - 1, (Block)Blocks.chest, 0, 2);
/* 5999 */     chest = getChestTileEntity(world, cposx, cposy + 1, cposz - 1);
/* 6000 */     if (chest != null)
/*      */     {
/*      */       
/* 6003 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 4 + world.rand.nextInt(5));
/*      */     }
/*      */     
/* 6006 */     world.setBlock(cposx, cposy + 1, cposz + 1, (Block)Blocks.chest, 0, 2);
/* 6007 */     chest = getChestTileEntity(world, cposx, cposy + 1, cposz + 1);
/* 6008 */     if (chest != null)
/*      */     {
/*      */       
/* 6011 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 4 + world.rand.nextInt(5));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeGreenhouseDungeon(World world, int cposx, int cposy, int cposz) {
/* 6021 */     int height = 7;
/* 6022 */     int width = 15;
/* 6023 */     int length = 23;
/* 6024 */     int t = 0;
/*      */     
/* 6026 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 6027 */     TileEntityChest chest = null;
/* 6028 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 6030 */     chestContents = this.GreenhouseContentsList;
/*      */     int i;
/* 6032 */     for (i = 0; i < length; i++) {
/* 6033 */       for (int m = 0; m < width; m++) {
/* 6034 */         for (int n = 0; n < height; n++) {
/* 6035 */           Block blk = Blocks.air;
/* 6036 */           if (i == 0 || m == 0 || i == length - 1 || m == width - 1) blk = Blocks.glass; 
/* 6037 */           if (n == height - 1) {
/* 6038 */             blk = Blocks.iron_block;
/* 6039 */             if (i % 4 == 3 && m % 4 == 3) blk = Blocks.glowstone; 
/* 6040 */             if (m % 4 == 1) blk = Blocks.glass; 
/*      */           } 
/* 6042 */           if (n == 0) {
/* 6043 */             BlockGrass blockGrass = Blocks.grass;
/* 6044 */             if (i != 0 && m != 0 && i != length - 1 && m != width - 1 && 
/* 6045 */               i % 3 == 2) Block block = Blocks.water;
/*      */           
/*      */           } 
/* 6048 */           if (n == 1 && 
/* 6049 */             i != 0 && m != 0 && i != length - 1 && m != width - 1 && 
/* 6050 */             i % 3 != 2 && 
/* 6051 */             world.rand.nextInt(3) != 1) {
/* 6052 */             blk = Blocks.farmland;
/* 6053 */             FastSetBlock(world, cposx + i, cposy + n - 1, cposz + m, blk);
/* 6054 */             t = world.rand.nextInt(20);
/* 6055 */             blk = Blocks.air;
/* 6056 */             if (t == 0) BlockFlower blockFlower = Blocks.yellow_flower; 
/* 6057 */             if (t == 1) BlockFlower blockFlower = Blocks.red_flower; 
/* 6058 */             if (t == 2) BlockBush blockBush = Blocks.brown_mushroom; 
/* 6059 */             if (t == 3) BlockBush blockBush = Blocks.red_mushroom; 
/* 6060 */             if (t == 4) blk = Blocks.wheat; 
/* 6061 */             if (t == 5) blk = Blocks.carrots; 
/* 6062 */             if (t == 6) blk = Blocks.potatoes; 
/* 6063 */             if (t == 7) blk = Blocks.reeds;
/*      */             
/* 6065 */             if (t == 9) blk = OreSpawnMain.MyCornPlant1; 
/* 6066 */             if (t == 10) blk = OreSpawnMain.MyTomatoPlant1; 
/* 6067 */             if (t == 11) blk = OreSpawnMain.MyStrawberryPlant; 
/* 6068 */             if (t == 12) blk = OreSpawnMain.MyButterflyPlant; 
/* 6069 */             if (t == 13) blk = OreSpawnMain.MyMothPlant; 
/* 6070 */             if (t == 14) blk = OreSpawnMain.MyRadishPlant; 
/* 6071 */             if (t == 15) blk = OreSpawnMain.MyLettucePlant1; 
/* 6072 */             if (t == 16) blk = OreSpawnMain.MyFlowerPinkBlock; 
/* 6073 */             if (t == 17) blk = OreSpawnMain.MyFlowerBlueBlock; 
/* 6074 */             if (t == 18) blk = OreSpawnMain.MyQuinoaPlant1; 
/* 6075 */             if (t == 19) blk = OreSpawnMain.MyRicePlant;
/*      */           
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 6081 */           FastSetBlock(world, cposx + i, cposy + n, cposz + m, blk);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 6086 */     for (i = 0; i < length; i++) {
/* 6087 */       for (int m = 0; m < width; m++) {
/* 6088 */         for (int n = height; n <= height + 6; n++) {
/* 6089 */           FastSetBlock(world, cposx + i, cposy + n, cposz + m, Blocks.air);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 6094 */     OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + 1, cposz, Blocks.air, 0, 2);
/* 6095 */     OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + 2, cposz, Blocks.air, 0, 2);
/* 6096 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 - 1, cposy + 1, cposz, Blocks.air, 0, 2);
/* 6097 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 - 1, cposy + 2, cposz, Blocks.air, 0, 2);
/* 6098 */     ItemDoor.placeDoorBlock(world, cposx + width / 2, cposy + 1, cposz, 3, Blocks.iron_door);
/* 6099 */     ItemDoor.placeDoorBlock(world, cposx + width / 2 - 1, cposy + 1, cposz, 3, Blocks.iron_door);
/* 6100 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 - 2, cposy + 2, cposz, Blocks.stone, 0, 2);
/* 6101 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 + 1, cposy + 2, cposz, Blocks.stone, 0, 2);
/* 6102 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 - 2, cposy + 2, cposz - 1, Blocks.stone_button, 4, 2);
/* 6103 */     OreSpawnMain.setBlockFast(world, cposx + width / 2 + 1, cposy + 2, cposz - 1, Blocks.stone_button, 4, 2);
/*      */     
/* 6105 */     i = length / 2;
/* 6106 */     int k = width / 2;
/* 6107 */     int j = height + 1;
/*      */     
/* 6109 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 6110 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 6111 */     if (tileentitymobspawner != null)
/*      */     {
/* 6113 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Triffid");
/*      */     }
/* 6115 */     j = height + 2;
/* 6116 */     world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 6117 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 6118 */     if (tileentitymobspawner != null)
/*      */     {
/* 6120 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Triffid");
/*      */     }
/*      */ 
/*      */     
/* 6124 */     j = height;
/* 6125 */     world.setBlock(cposx + i, cposy + j, cposz + k, (Block)Blocks.chest, 0, 2);
/* 6126 */     chest = getChestTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 6127 */     if (chest != null)
/*      */     {
/*      */       
/* 6130 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 5 + world.rand.nextInt(5));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeMonsterIsland(World world, int cposx, int cposy, int cposz) {
/* 6139 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 6140 */     TileEntityChest chest = null;
/* 6141 */     WeightedRandomChestContent[] chestContents = null;
/* 6142 */     String monster = "Sea Viper";
/*      */     
/* 6144 */     chestContents = this.MonsterIslandContentsList;
/* 6145 */     if (world.rand.nextInt(2) == 0) monster = "Sea Monster";
/*      */     
/*      */     int i;
/* 6148 */     for (i = -5; i <= 5; i++) {
/* 6149 */       int k = 3;
/* 6150 */       if (i == -5 || i == 5) k = 1; 
/* 6151 */       if (i == -4 || i == 4) k = 2; 
/* 6152 */       if (i == -3 || i == 3) k = 2; 
/* 6153 */       for (int j = -k; j <= k; j++) {
/* 6154 */         FastSetBlock(world, cposx + i, cposy, cposz + j, (Block)Blocks.sand);
/* 6155 */         FastSetBlock(world, cposx + i, cposy - 1, cposz + j, Blocks.stone);
/*      */       } 
/*      */     } 
/* 6158 */     for (i = -2; i <= 2; i++) {
/* 6159 */       for (int j = -2; j <= 2; j++) {
/* 6160 */         FastSetBlock(world, cposx + i, cposy + 3, cposz + j, (Block)Blocks.leaves);
/*      */       }
/*      */     } 
/* 6163 */     FastSetBlock(world, cposx, cposy + 4, cposz, (Block)Blocks.leaves);
/* 6164 */     FastSetBlock(world, cposx, cposy + 3, cposz, Blocks.log);
/* 6165 */     FastSetBlock(world, cposx, cposy + 2, cposz, Blocks.log);
/* 6166 */     FastSetBlock(world, cposx, cposy + 1, cposz, Blocks.log);
/*      */     
/* 6168 */     FastSetBlock(world, cposx + 1, cposy + 3, cposz + 1, Blocks.log);
/* 6169 */     FastSetBlock(world, cposx - 1, cposy + 3, cposz - 1, Blocks.log);
/* 6170 */     FastSetBlock(world, cposx + 1, cposy + 3, cposz - 1, Blocks.log);
/* 6171 */     FastSetBlock(world, cposx - 1, cposy + 3, cposz + 1, Blocks.log);
/*      */     
/* 6173 */     world.setBlock(cposx + 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
/* 6174 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 1, cposy + 3, cposz);
/* 6175 */     if (tileentitymobspawner != null)
/*      */     {
/* 6177 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName(monster);
/*      */     }
/* 6179 */     world.setBlock(cposx - 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
/* 6180 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - 1, cposy + 3, cposz);
/* 6181 */     if (tileentitymobspawner != null)
/*      */     {
/* 6183 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName(monster);
/*      */     }
/* 6185 */     world.setBlock(cposx, cposy + 3, cposz + 1, Blocks.mob_spawner, 0, 2);
/* 6186 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 3, cposz + 1);
/* 6187 */     if (tileentitymobspawner != null)
/*      */     {
/* 6189 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName(monster);
/*      */     }
/* 6191 */     world.setBlock(cposx, cposy + 3, cposz - 1, Blocks.mob_spawner, 0, 2);
/* 6192 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 3, cposz - 1);
/* 6193 */     if (tileentitymobspawner != null)
/*      */     {
/* 6195 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName(monster);
/*      */     }
/*      */ 
/*      */     
/* 6199 */     world.setBlock(cposx, cposy + 1, cposz - 1, (Block)Blocks.chest, 0, 2);
/* 6200 */     chest = getChestTileEntity(world, cposx, cposy + 1, cposz - 1);
/* 6201 */     if (chest != null)
/*      */     {
/*      */       
/* 6204 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 4 + world.rand.nextInt(5));
/*      */     }
/*      */     
/* 6207 */     world.setBlock(cposx, cposy + 1, cposz + 1, (Block)Blocks.chest, 0, 2);
/* 6208 */     chest = getChestTileEntity(world, cposx, cposy + 1, cposz + 1);
/* 6209 */     if (chest != null)
/*      */     {
/*      */       
/* 6212 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 4 + world.rand.nextInt(5));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeNightmareRookery(World world, int cposx, int cposy, int cposz) {
/* 6222 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 6223 */     TileEntityChest chest = null;
/* 6224 */     WeightedRandomChestContent[] chestContents = null;
/* 6225 */     String monster = "Nightmare";
/*      */     
/* 6227 */     chestContents = this.NightmareRookeryContentsList;
/*      */ 
/*      */     
/* 6230 */     int h = 0, k = h, j = k, i = j;
/* 6231 */     for (i = -5; i <= 20; i++) {
/* 6232 */       k += world.rand.nextInt(3) - 1;
/* 6233 */       h = world.rand.nextInt(20) + 1;
/* 6234 */       for (j = 0; j < h; j++) {
/* 6235 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.stone);
/* 6236 */         if (world.rand.nextInt(j + 5) == 1) FastSetBlock(world, cposx + i + 1, cposy + j, cposz + k, Blocks.stone); 
/* 6237 */         if (world.rand.nextInt(j + 5) == 1) FastSetBlock(world, cposx + i - 1, cposy + j, cposz + k, Blocks.stone); 
/* 6238 */         if (world.rand.nextInt(j + 5) == 1) FastSetBlock(world, cposx + i, cposy + j, cposz + k + 1, Blocks.stone); 
/* 6239 */         if (world.rand.nextInt(j + 5) == 1) FastSetBlock(world, cposx + i, cposy + j, cposz + k - 1, Blocks.stone); 
/* 6240 */         if (j >= 18) {
/* 6241 */           world.setBlock(cposx + i, cposy + j + 2, cposz + k, Blocks.mob_spawner, 0, 2);
/* 6242 */           tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j + 2, cposz + k);
/* 6243 */           if (tileentitymobspawner != null)
/*      */           {
/* 6245 */             tileentitymobspawner.getSpawnerBaseLogic().setEntityName(monster);
/*      */           }
/* 6247 */           world.setBlock(cposx + i, cposy + j + 1, cposz + k, (Block)Blocks.chest, 0, 2);
/* 6248 */           chest = getChestTileEntity(world, cposx + i, cposy + j + 1, cposz + k);
/* 6249 */           if (chest != null)
/*      */           {
/*      */             
/* 6252 */             WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 4 + world.rand.nextInt(5));
/*      */           }
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/* 6259 */     for (i = -5; i <= 20; i++) {
/* 6260 */       k += world.rand.nextInt(3) - 1;
/* 6261 */       h = world.rand.nextInt(20) + 1;
/* 6262 */       for (j = 0; j < h; j++) {
/* 6263 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.stone);
/* 6264 */         if (world.rand.nextInt(j + 5) == 1) FastSetBlock(world, cposx + i + 1, cposy + j, cposz + k, Blocks.stone); 
/* 6265 */         if (world.rand.nextInt(j + 5) == 1) FastSetBlock(world, cposx + i - 1, cposy + j, cposz + k, Blocks.stone); 
/* 6266 */         if (world.rand.nextInt(j + 5) == 1) FastSetBlock(world, cposx + i, cposy + j, cposz + k + 1, Blocks.stone); 
/* 6267 */         if (world.rand.nextInt(j + 5) == 1) FastSetBlock(world, cposx + i, cposy + j, cposz + k - 1, Blocks.stone); 
/* 6268 */         if (j >= 18) {
/* 6269 */           world.setBlock(cposx + i, cposy + j + 2, cposz + k, Blocks.mob_spawner, 0, 2);
/* 6270 */           tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j + 2, cposz + k);
/* 6271 */           if (tileentitymobspawner != null)
/*      */           {
/* 6273 */             tileentitymobspawner.getSpawnerBaseLogic().setEntityName(monster);
/*      */           }
/* 6275 */           world.setBlock(cposx + i, cposy + j + 1, cposz + k, (Block)Blocks.chest, 0, 2);
/* 6276 */           chest = getChestTileEntity(world, cposx + i, cposy + j + 1, cposz + k);
/* 6277 */           if (chest != null)
/*      */           {
/*      */             
/* 6280 */             WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 4 + world.rand.nextInt(5));
/*      */           }
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
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
/*      */   public void makeStinkyHouse(World world, int cposx, int cposy, int cposz) {
/* 6297 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 6298 */     TileEntityChest chest = null;
/* 6299 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 6301 */     chestContents = this.StinkyHouseContentsList;
/* 6302 */     int height = 2;
/* 6303 */     int width = 9;
/* 6304 */     int length = 12;
/* 6305 */     int yardwidth = 16;
/* 6306 */     int yardlength = 24; int i;
/* 6307 */     for (i = 0; i <= yardlength; i++) {
/* 6308 */       for (int k = 0; k <= yardwidth; k++) {
/* 6309 */         BlockDeadBush blockDeadBush; Block bid = Blocks.air;
/* 6310 */         if (i == 0 || i == yardlength || k == 0 || k == yardwidth) bid = Blocks.fence; 
/* 6311 */         if (bid == Blocks.fence && world.rand.nextInt(3) == 1) bid = Blocks.air; 
/* 6312 */         if (bid == Blocks.air && world.rand.nextInt(10) == 1) blockDeadBush = Blocks.deadbush; 
/* 6313 */         if (blockDeadBush != Blocks.air) FastSetBlock(world, cposx + i - 5, cposy + 1, cposz + k - 4, (Block)blockDeadBush);
/*      */       
/*      */       } 
/*      */     } 
/* 6317 */     for (i = 0; i <= length; i++) {
/* 6318 */       for (int k = 0; k <= width; k++) {
/* 6319 */         for (int j = 0; j <= height; j++) {
/* 6320 */           Block bid = Blocks.air;
/* 6321 */           if (i == 0 || i == length || k == 0 || k == width) bid = Blocks.planks; 
/* 6322 */           if (bid == Blocks.planks && j == 1 && (
/* 6323 */             i == 1 || i == length - 1 || k == 1 || k == width - 1)) bid = Blocks.glass_pane;
/*      */           
/* 6325 */           if (j == height) bid = Blocks.planks; 
/* 6326 */           if (world.rand.nextInt(10) == 1) bid = Blocks.air; 
/* 6327 */           if ((j == 0 || j == 1) && 
/* 6328 */             i == 0 && (
/* 6329 */             k == width / 2 || k == width / 2 + 1)) {
/* 6330 */             bid = Blocks.air;
/*      */           }
/*      */ 
/*      */           
/* 6334 */           FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k, bid);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 6339 */     world.setBlock(cposx + 2, cposy + 1, cposz + 2, Blocks.mob_spawner, 0, 2);
/* 6340 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 2, cposy + 1, cposz + 2);
/* 6341 */     if (tileentitymobspawner != null)
/*      */     {
/* 6343 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Stink Bug");
/*      */     }
/* 6345 */     world.setBlock(cposx + length - 2, cposy + 1, cposz + width - 2, Blocks.mob_spawner, 0, 2);
/* 6346 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + length - 2, cposy + 1, cposz + width - 2);
/* 6347 */     if (tileentitymobspawner != null)
/*      */     {
/* 6349 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Stinky");
/*      */     }
/*      */     
/* 6352 */     world.setBlock(cposx + length / 2, cposy + 1, cposz + width / 2, (Block)Blocks.chest, 0, 2);
/* 6353 */     chest = getChestTileEntity(world, cposx + length / 2, cposy + 1, cposz + width / 2);
/* 6354 */     if (chest != null)
/*      */     {
/*      */       
/* 6357 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 8 + world.rand.nextInt(5));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeRubberDuckyPond(World world, int cposx, int cposy, int cposz) {
/* 6365 */     Block bid = Blocks.air;
/* 6366 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 6367 */     TileEntityChest chest = null;
/* 6368 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 6370 */     chestContents = this.RubberDuckyContentsList;
/*      */     int i;
/* 6372 */     for (i = 0; i < 2; i++) {
/* 6373 */       world.setBlock(cposx + i, cposy + 6, cposz, Blocks.mob_spawner, 0, 2);
/* 6374 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + 6, cposz);
/* 6375 */       if (tileentitymobspawner != null)
/*      */       {
/* 6377 */         tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rubber Ducky");
/*      */       }
/*      */     } 
/*      */     
/* 6381 */     world.setBlock(cposx, cposy + 5, cposz, (Block)Blocks.chest, 0, 2);
/* 6382 */     world.setBlock(cposx + 1, cposy + 5, cposz, (Block)Blocks.chest, 0, 2);
/* 6383 */     chest = getChestTileEntity(world, cposx + 1, cposy + 5, cposz);
/* 6384 */     if (chest != null)
/*      */     {
/*      */       
/* 6387 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 8 + world.rand.nextInt(5));
/*      */     }
/*      */     
/* 6390 */     world.setBlock(cposx, cposy + 4, cposz, Blocks.glass, 0, 2);
/* 6391 */     world.setBlock(cposx + 1, cposy + 4, cposz, Blocks.glass, 0, 2);
/*      */     
/* 6393 */     for (i = 0; i < 2; i++) {
/* 6394 */       world.setBlock(cposx + i, cposy + 3, cposz, Blocks.water, 0, 3);
/*      */     }
/* 6396 */     world.setBlock(cposx - 1, cposy + 3, cposz, (Block)Blocks.flowing_water, 0, 3);
/* 6397 */     world.setBlock(cposx + 2, cposy + 3, cposz, (Block)Blocks.flowing_water, 0, 3);
/*      */     
/* 6399 */     for (i = 0; i < 12; i++) {
/* 6400 */       for (int k = 0; k < 11; k++) {
/* 6401 */         BlockSand blockSand; bid = Blocks.water;
/* 6402 */         if (i == 0 || k == 0 || i == 11 || k == 10) blockSand = Blocks.sand; 
/* 6403 */         FastSetBlock(world, cposx + i - 5, cposy, cposz + k - 5, (Block)blockSand);
/* 6404 */         Block block = Blocks.air;
/* 6405 */         FastSetBlock(world, cposx + i - 5, cposy + 1, cposz + k - 5, block);
/* 6406 */         FastSetBlock(world, cposx + i - 5, cposy + 2, cposz + k - 5, block);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeWhiteHouse(World world, int cposx, int cposy, int cposz) {
/* 6415 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 6416 */     TileEntityChest chest = null;
/* 6417 */     WeightedRandomChestContent[] chestContents = null;
/*      */ 
/*      */     
/* 6420 */     makefountain(world, cposx - 5, cposy, cposz - 15);
/* 6421 */     makefountain(world, cposx + 15, cposy, cposz - 15);
/* 6422 */     makewalkway(world, cposx + 7, cposy, cposz - 15);
/* 6423 */     makewhbase(world, cposx - 4, cposy, cposz - 6);
/* 6424 */     makewhwalls(world, cposx - 3, cposy + 2, cposz - 5);
/* 6425 */     makewhroof(world, cposx - 4, cposy, cposz - 6);
/* 6426 */     makewhinterior(world, cposx - 1, cposy + 2, cposz - 3);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void makefountain(World world, int cposx, int cposy, int cposz) {
/* 6432 */     Block bid = Blocks.air;
/* 6433 */     for (int i = 0; i < 7; i++) {
/* 6434 */       for (int k = 0; k < 5; k++) {
/* 6435 */         for (int j = 0; j < 15; j++) {
/* 6436 */           bid = Blocks.water;
/* 6437 */           if (i == 0 || k == 0 || i == 6 || k == 4) bid = Blocks.quartz_block; 
/* 6438 */           if (j == 0) bid = Blocks.quartz_block; 
/* 6439 */           if (j == 1 && i == 3 && k == 2) bid = Blocks.glowstone; 
/* 6440 */           if (j > 1) {
/* 6441 */             bid = Blocks.air;
/* 6442 */             if (j <= 4 && i == 3 && k == 2) bid = Blocks.quartz_block; 
/*      */           } 
/* 6444 */           FastSetBlock(world, cposx + i, cposy + j, cposz + k, bid);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 6450 */     world.setBlock(cposx + 3, cposy + 5, cposz + 2, Blocks.water, 0, 3);
/* 6451 */     world.setBlock(cposx + 2, cposy + 5, cposz + 2, (Block)Blocks.flowing_water, 0, 3);
/* 6452 */     world.setBlock(cposx + 4, cposy + 5, cposz + 2, (Block)Blocks.flowing_water, 0, 3);
/*      */   }
/*      */ 
/*      */   
/*      */   private void makewalkway(World world, int cposx, int cposy, int cposz) {
/* 6457 */     Block bid = Blocks.air;
/* 6458 */     for (int i = 0; i < 3; i++) {
/* 6459 */       for (int k = 0; k < 10; k++) {
/* 6460 */         for (int j = 0; j < 15; j++) {
/* 6461 */           bid = Blocks.quartz_block;
/* 6462 */           if (j == 1) {
/* 6463 */             bid = Blocks.air;
/* 6464 */             if (k > 6) bid = Blocks.quartz_block;
/*      */           
/*      */           } 
/* 6467 */           if (j > 1) bid = Blocks.air; 
/* 6468 */           FastSetBlock(world, cposx + i, cposy + j, cposz + k, bid);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void makewhbase(World world, int cposx, int cposy, int cposz) {
/* 6476 */     Block bid = Blocks.air; int i;
/* 6477 */     for (i = 0; i < 25; i++) {
/* 6478 */       for (int k = 0; k < 25; k++) {
/* 6479 */         bid = Blocks.quartz_block;
/* 6480 */         FastSetBlock(world, cposx + i, cposy + 1, cposz + k, bid);
/* 6481 */         if ((i == 0 || i == 24) && (
/* 6482 */           k == 0 || k == 24)) FastSetBlock(world, cposx + i, cposy + 2, cposz + k, OreSpawnMain.CrystalTorch);
/*      */       
/*      */       } 
/*      */     } 
/* 6486 */     for (i = 1; i < 24; i++) {
/* 6487 */       for (int k = 1; k < 24; k++) {
/* 6488 */         bid = Blocks.quartz_block;
/* 6489 */         FastSetBlock(world, cposx + i, cposy + 2, cposz + k, bid);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void makewhwalls(World world, int cposx, int cposy, int cposz) {
/* 6496 */     Block bid = Blocks.air;
/* 6497 */     for (int i = 0; i < 23; i++) {
/* 6498 */       for (int k = 0; k < 23; k++) {
/* 6499 */         for (int j = 0; j < 6; j++) {
/* 6500 */           bid = Blocks.air;
/* 6501 */           if (i == 0 || k == 0 || i == 22 || k == 22) bid = Blocks.quartz_block; 
/* 6502 */           if (j != 0 && bid != Blocks.air)
/*      */           {
/* 6504 */             if (k == 22)
/* 6505 */             { if ((j & 0x1) == 1)
/* 6506 */               { if ((i & 0x1) == 0 || (k & 0x1) == 0) bid = Blocks.glass_pane;
/*      */                  }
/* 6508 */               else if ((i & 0x1) == 1 || (k & 0x1) == 1) { bid = Blocks.glass_pane; }
/*      */                }
/* 6510 */             else if (k != 0)
/* 6511 */             { if ((j & 0x1) == 1)
/* 6512 */               { if (i == 2 || k == 2 || i == 20 || k == 20) bid = Blocks.glass_pane;
/*      */                  }
/* 6514 */               else if (i == 1 || k == 1 || i == 21 || k == 21) { bid = Blocks.glass_pane; }
/*      */               
/* 6516 */               if (j > 0 && j < 5 && k > 7 && k < 15) bid = Blocks.glass_pane;
/*      */                }
/* 6518 */             else if ((j & 0x1) == 1)
/* 6519 */             { if (i == 2 || k == 2 || i == 20 || k == 20) bid = Blocks.glass_pane;
/*      */                }
/* 6521 */             else if (i == 1 || k == 1 || i == 21 || k == 21) { bid = Blocks.glass_pane; }
/*      */           
/*      */           }
/*      */           
/* 6525 */           FastSetBlock(world, cposx + i, cposy + j, cposz + k, bid);
/*      */         } 
/*      */       } 
/*      */     } 
/* 6529 */     OreSpawnMain.setBlockFast(world, cposx + 11, cposy, cposz, Blocks.air, 0, 2);
/* 6530 */     OreSpawnMain.setBlockFast(world, cposx + 11, cposy + 1, cposz, Blocks.air, 0, 2);
/* 6531 */     ItemDoor.placeDoorBlock(world, cposx + 11, cposy, cposz, 3, Blocks.iron_door);
/* 6532 */     OreSpawnMain.setBlockFast(world, cposx + 12, cposy + 1, cposz - 1, Blocks.stone_button, 4, 2);
/*      */   }
/*      */ 
/*      */   
/*      */   private void makewhroof(World world, int cposx, int cposy, int cposz) {
/* 6537 */     Block bid = Blocks.air;
/* 6538 */     for (int j = 0; j < 13; j++) {
/* 6539 */       for (int i = 0; i < 25 - 2 * j; i++) {
/* 6540 */         for (int k = 0; k < 25 - 2 * j; k++) {
/* 6541 */           bid = Blocks.air;
/* 6542 */           if (i == 0 || k == 0 || i == 24 - 2 * j || k == 24 - 2 * j) bid = Blocks.quartz_block; 
/* 6543 */           if (j == 0 && bid != Blocks.air && (
/* 6544 */             i + k & 0x1) == 1) {
/* 6545 */             bid = Blocks.emerald_block;
/*      */           }
/*      */           
/* 6548 */           if (j == 12) bid = Blocks.emerald_block; 
/* 6549 */           FastSetBlock(world, cposx + i + j, cposy + 8 + j, cposz + k + j, bid);
/* 6550 */           if ((i == 0 || i == 24 - 2 * j) && (
/* 6551 */             k == 0 || k == 24 - 2 * j)) FastSetBlock(world, cposx + i + j, cposy + 8 + j + 1, cposz + k + j, OreSpawnMain.CrystalTorch);
/*      */         
/*      */         } 
/*      */       } 
/*      */     } 
/* 6556 */     bid = Blocks.fence;
/* 6557 */     FastSetBlock(world, cposx + 12, cposy + 8 + 11, cposz + 12, bid);
/* 6558 */     FastSetBlock(world, cposx + 12, cposy + 8 + 10, cposz + 12, bid);
/* 6559 */     FastSetBlock(world, cposx + 12, cposy + 8 + 9, cposz + 12, bid);
/* 6560 */     FastSetBlock(world, cposx + 12, cposy + 8 + 8, cposz + 12, bid);
/* 6561 */     FastSetBlock(world, cposx + 12, cposy + 8 + 7, cposz + 12, bid);
/* 6562 */     FastSetBlock(world, cposx + 12, cposy + 8 + 6, cposz + 12, bid);
/* 6563 */     FastSetBlock(world, cposx + 12, cposy + 8 + 5, cposz + 12, bid);
/* 6564 */     FastSetBlock(world, cposx + 12, cposy + 8 + 4, cposz + 12, bid);
/* 6565 */     FastSetBlock(world, cposx + 12, cposy + 8 + 3, cposz + 12, bid);
/* 6566 */     FastSetBlock(world, cposx + 12, cposy + 8 + 2, cposz + 12, bid);
/* 6567 */     FastSetBlock(world, cposx + 12, cposy + 8 + 1, cposz + 12, bid);
/* 6568 */     FastSetBlock(world, cposx + 12, cposy + 8 + 0, cposz + 12, bid);
/*      */     
/* 6570 */     FastSetBlock(world, cposx + 11, cposy + 8 + 0, cposz + 12, bid);
/* 6571 */     FastSetBlock(world, cposx + 13, cposy + 8 + 0, cposz + 12, bid);
/* 6572 */     FastSetBlock(world, cposx + 12, cposy + 8 + 0, cposz + 11, bid);
/* 6573 */     FastSetBlock(world, cposx + 12, cposy + 8 + 0, cposz + 13, bid);
/*      */     
/* 6575 */     bid = OreSpawnMain.CrystalTorch;
/* 6576 */     FastSetBlock(world, cposx + 11, cposy + 8 + 1, cposz + 12, bid);
/* 6577 */     FastSetBlock(world, cposx + 13, cposy + 8 + 1, cposz + 12, bid);
/* 6578 */     FastSetBlock(world, cposx + 12, cposy + 8 + 1, cposz + 11, bid);
/* 6579 */     FastSetBlock(world, cposx + 12, cposy + 8 + 1, cposz + 13, bid);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void makewhinterior(World world, int cposx, int cposy, int cposz) {
/* 6587 */     int zoff = 1;
/* 6588 */     int xoff = 0; int i;
/* 6589 */     for (i = 0; i < 8; i++) {
/* 6590 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff, Blocks.quartz_stairs, 3, 2);
/* 6591 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 1, (Block)Blocks.piston_extension, 1, 2);
/* 6592 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 2, (Block)Blocks.piston_extension, 1, 2);
/* 6593 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 3, Blocks.quartz_stairs, 2, 2);
/*      */     } 
/*      */     
/* 6596 */     xoff = 11;
/* 6597 */     for (i = 0; i < 8; i++) {
/* 6598 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff, Blocks.quartz_stairs, 3, 2);
/* 6599 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 1, (Block)Blocks.piston_extension, 1, 2);
/* 6600 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 2, (Block)Blocks.piston_extension, 1, 2);
/* 6601 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 3, Blocks.quartz_stairs, 2, 2);
/*      */     } 
/*      */     
/* 6604 */     zoff = 7;
/* 6605 */     xoff = 0;
/* 6606 */     for (i = 0; i < 8; i++) {
/* 6607 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff, Blocks.quartz_stairs, 3, 2);
/* 6608 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 1, (Block)Blocks.piston_extension, 1, 2);
/* 6609 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 2, (Block)Blocks.piston_extension, 1, 2);
/* 6610 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 3, Blocks.quartz_stairs, 2, 2);
/*      */     } 
/*      */     
/* 6613 */     xoff = 11;
/* 6614 */     for (i = 0; i < 8; i++) {
/* 6615 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff, Blocks.quartz_stairs, 3, 2);
/* 6616 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 1, (Block)Blocks.piston_extension, 1, 2);
/* 6617 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 2, (Block)Blocks.piston_extension, 1, 2);
/* 6618 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 3, Blocks.quartz_stairs, 2, 2);
/*      */     } 
/*      */     
/* 6621 */     zoff = 13;
/* 6622 */     xoff = 0;
/* 6623 */     for (i = 0; i < 8; i++) {
/* 6624 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff, Blocks.quartz_stairs, 3, 2);
/* 6625 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 1, (Block)Blocks.piston_extension, 1, 2);
/* 6626 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 2, (Block)Blocks.piston_extension, 1, 2);
/* 6627 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 3, Blocks.quartz_stairs, 2, 2);
/*      */     } 
/*      */     
/* 6630 */     xoff = 11;
/* 6631 */     for (i = 0; i < 8; i++) {
/* 6632 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff, Blocks.quartz_stairs, 3, 2);
/* 6633 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 1, (Block)Blocks.piston_extension, 1, 2);
/* 6634 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 2, (Block)Blocks.piston_extension, 1, 2);
/* 6635 */       OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 3, Blocks.quartz_stairs, 2, 2);
/*      */     } 
/*      */     
/* 6638 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 6639 */     TileEntityChest chest = null;
/* 6640 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 6642 */     chestContents = this.WhiteHouseContentsList;
/*      */     
/* 6644 */     zoff = 18;
/* 6645 */     xoff = 2;
/* 6646 */     world.setBlock(cposx + xoff, cposy + 1, cposz + zoff, Blocks.mob_spawner, 0, 2);
/* 6647 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + xoff, cposy + 1, cposz + zoff);
/* 6648 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Criminal"); 
/* 6649 */     world.setBlock(cposx + xoff, cposy, cposz + zoff, (Block)Blocks.chest, 0, 2);
/* 6650 */     chest = getChestTileEntity(world, cposx + xoff, cposy, cposz + zoff);
/* 6651 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(5));
/*      */     
/* 6653 */     xoff = 6;
/* 6654 */     world.setBlock(cposx + xoff, cposy + 1, cposz + zoff, Blocks.mob_spawner, 0, 2);
/* 6655 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + xoff, cposy + 1, cposz + zoff);
/* 6656 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Criminal"); 
/* 6657 */     world.setBlock(cposx + xoff, cposy, cposz + zoff, (Block)Blocks.chest, 0, 2);
/* 6658 */     chest = getChestTileEntity(world, cposx + xoff, cposy, cposz + zoff);
/* 6659 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(5));
/*      */     
/* 6661 */     xoff = 12;
/* 6662 */     world.setBlock(cposx + xoff, cposy + 1, cposz + zoff, Blocks.mob_spawner, 0, 2);
/* 6663 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + xoff, cposy + 1, cposz + zoff);
/* 6664 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Criminal"); 
/* 6665 */     world.setBlock(cposx + xoff, cposy, cposz + zoff, (Block)Blocks.chest, 0, 2);
/* 6666 */     chest = getChestTileEntity(world, cposx + xoff, cposy, cposz + zoff);
/* 6667 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(5));
/*      */     
/* 6669 */     xoff = 16;
/* 6670 */     world.setBlock(cposx + xoff, cposy + 1, cposz + zoff, Blocks.mob_spawner, 0, 2);
/* 6671 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + xoff, cposy + 1, cposz + zoff);
/* 6672 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Criminal"); 
/* 6673 */     world.setBlock(cposx + xoff, cposy, cposz + zoff, (Block)Blocks.chest, 0, 2);
/* 6674 */     chest = getChestTileEntity(world, cposx + xoff, cposy, cposz + zoff);
/* 6675 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 3 + world.rand.nextInt(5));
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeQueenAltar(World world, int cposx, int cposy, int cposz) {
/* 6684 */     Block bid = Blocks.air;
/*      */ 
/*      */ 
/*      */     
/* 6688 */     int width = 51;
/* 6689 */     int length = 51;
/* 6690 */     int height = 48;
/*      */     
/* 6692 */     if (world.isRemote) {
/*      */       return;
/*      */     }
/*      */     
/*      */     int j;
/*      */     
/* 6698 */     for (j = 0; j <= height + 10; j++) {
/* 6699 */       for (int k = -5; k < width + 5; k++) {
/* 6700 */         for (int m = -5; m < length + 5; m++) {
/* 6701 */           bid = Blocks.air;
/* 6702 */           OreSpawnMain.setBlockFast(world, cposx + k, cposy + j, cposz + m, bid, 0, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/* 6706 */     j = 0; int i;
/* 6707 */     for (i = 0; i < width; i++) {
/* 6708 */       for (int k = 0; k < length; k++) {
/* 6709 */         BlockGrass blockGrass = Blocks.grass;
/* 6710 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, (Block)blockGrass, 0, 2);
/* 6711 */         for (int v = 1; v < 10; v++) {
/* 6712 */           Block block = world.getBlock(cposx + i, cposy + j - v, cposz + k);
/* 6713 */           if (block == Blocks.air || block == Blocks.tallgrass || block == Blocks.water) {
/* 6714 */             block = Blocks.dirt;
/* 6715 */             OreSpawnMain.setBlockFast(world, cposx + i, cposy + j - v, cposz + k, block, 0, 2);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 6721 */     makequeencolumn(world, cposx + 1, cposy + 1, cposz + 1);
/* 6722 */     makequeencolumn(world, cposx + width - 8, cposy + 1, cposz + length - 8);
/* 6723 */     makequeencolumn(world, cposx + 1, cposy + 1, cposz + length - 8);
/* 6724 */     makequeencolumn(world, cposx + width - 8, cposy + 1, cposz + 1);
/*      */ 
/*      */     
/* 6727 */     j = height - 1;
/* 6728 */     bid = Blocks.obsidian;
/* 6729 */     for (i = 0; i < width; i++) {
/* 6730 */       for (int k = 0; k < length; k++) {
/* 6731 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/* 6734 */     j = height;
/* 6735 */     bid = Blocks.obsidian;
/* 6736 */     for (i = -1; i <= width; i++) {
/* 6737 */       for (int k = -1; k <= length; k++) {
/* 6738 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/*      */     
/* 6742 */     makequeenbackground(world, cposx + 4, cposy + 10, cposz + 9);
/* 6743 */     makequeencenteraltar(world, cposx + width / 2, cposy, cposz + length / 2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void makequeencolumn(World world, int cposx, int cposy, int cposz) {
/* 6752 */     Block bid = Blocks.air;
/* 6753 */     int meta = 0;
/*      */ 
/*      */ 
/*      */     
/* 6757 */     int width = 5;
/* 6758 */     int length = 5;
/* 6759 */     int height = 44;
/*      */     
/* 6761 */     if (world.isRemote) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 6767 */     int j = 0;
/* 6768 */     bid = Blocks.obsidian; int i;
/* 6769 */     for (i = 0; i < width + 2; i++) {
/* 6770 */       for (int k = 0; k < length + 2; k++) {
/* 6771 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, meta, 2);
/* 6772 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + height + 1, cposz + k, bid, meta, 2);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 6777 */     cposx++; cposz++; cposy++;
/* 6778 */     for (j = 0; j < height; j++) {
/* 6779 */       for (i = 0; i < width; i++) {
/* 6780 */         for (int k = 0; k < length; k++) {
/* 6781 */           bid = Blocks.air;
/* 6782 */           if (i == 0 || k == 0 || i == width - 1 || k == length - 1) bid = Blocks.obsidian; 
/* 6783 */           if (j % 4 == 0 && 
/* 6784 */             bid != Blocks.air && (
/* 6785 */             i == 2 || k == 2)) bid = Blocks.redstone_block;
/*      */ 
/*      */           
/* 6788 */           if (j % 4 == 1 && 
/* 6789 */             bid != Blocks.air) {
/* 6790 */             if (i == 1 || k == 1) bid = Blocks.redstone_block; 
/* 6791 */             if (i == 3 || k == 3) bid = Blocks.redstone_block;
/*      */           
/*      */           } 
/* 6794 */           if (j % 4 == 2 && 
/* 6795 */             bid != Blocks.air) {
/* 6796 */             if (i == 1 || k == 1) bid = Blocks.redstone_block; 
/* 6797 */             if (i == 3 || k == 3) bid = Blocks.redstone_block; 
/* 6798 */             if (i == 2 || k == 2) bid = OreSpawnMain.MyBlockAmethystBlock;
/*      */           
/*      */           } 
/* 6801 */           if (j % 4 == 3 && 
/* 6802 */             bid != Blocks.air) {
/* 6803 */             if (i == 1 || k == 1) bid = Blocks.redstone_block; 
/* 6804 */             if (i == 3 || k == 3) bid = Blocks.redstone_block;
/*      */           
/*      */           } 
/* 6807 */           meta = 0;
/* 6808 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, meta, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/* 6814 */   private int[] queen = new int[] { -1, -1, 24, 3, -1, 24, 5, -1, 17, 12, -1, 16, 15, -1, 15, 14, -1, 15, 6, 3, 5, -1, 14, 6, 4, 3, -1, 14, 5, -1, 14, 5, -1, 12, 9, -1, 11, 11, -1, 8, 17, -1, 5, 23, -1, 3, 27, -1, 2, 29, -1, 1, 31, -1, 0, 33, -1, 13, 6, -1, 12, 9, -1, 11, 3, 1, 2, 1, 4, -1, 10, 3, 2, 2, 3, 2, -1, 10, 2, 4, 2, 3, 2, -1, 9, 2, 5, 2, 4, 6, -1, 9, 2, 5, 2, 6, 4, -1, 8, 2, 6, 1, -1, 8, 2, 5, 2, -1, 8, 2, 5, 2, -1, 8, 2, 5, 2, -1, 15, 2, -1, -1, -1 };
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
/*      */   private void makequeenbackground(World world, int cposx, int cposy, int cposz) {
/* 6850 */     Block bid = Blocks.air;
/* 6851 */     int meta = 0;
/* 6852 */     int curz = 0;
/* 6853 */     int cury = 0;
/* 6854 */     int height = 33;
/* 6855 */     int width = 33;
/*      */     
/* 6857 */     bid = Blocks.stone;
/* 6858 */     for (int m = 0; m < this.queen.length; m++) {
/* 6859 */       int v = this.queen[m];
/* 6860 */       if (v < 0) {
/* 6861 */         bid = Blocks.stone;
/* 6862 */         while (curz < width) {
/* 6863 */           OreSpawnMain.setBlockFast(world, cposx, cposy + cury, cposz + curz, bid, 0, 2);
/* 6864 */           curz++;
/*      */         } 
/* 6866 */         cury++;
/* 6867 */         curz = 0;
/*      */       } else {
/* 6869 */         for (int n = 0; n < v; n++) {
/* 6870 */           OreSpawnMain.setBlockFast(world, cposx, cposy + cury, cposz + curz, bid, 0, 2);
/* 6871 */           curz++;
/*      */         } 
/* 6873 */         if (bid == Blocks.stone) {
/* 6874 */           bid = OreSpawnMain.MyBlockRubyBlock;
/*      */         } else {
/* 6876 */           bid = Blocks.stone;
/*      */         } 
/*      */       } 
/*      */     }  int i;
/* 6880 */     for (i = 0; i < width; i++) {
/* 6881 */       OreSpawnMain.setBlockFast(world, cposx, cposy - 1, cposz + i, Blocks.diamond_block, 0, 2);
/*      */     }
/* 6883 */     for (i = 0; i < width; i++) {
/* 6884 */       OreSpawnMain.setBlockFast(world, cposx, cposy + height, cposz + i, Blocks.diamond_block, 0, 2);
/*      */     }
/* 6886 */     for (i = -1; i <= height; i++) {
/* 6887 */       OreSpawnMain.setBlockFast(world, cposx, cposy + i, cposz - 1, Blocks.diamond_block, 0, 2);
/*      */     }
/* 6889 */     for (i = -1; i <= height; i++) {
/* 6890 */       OreSpawnMain.setBlockFast(world, cposx, cposy + i, cposz + width, Blocks.diamond_block, 0, 2);
/*      */     }
/*      */ 
/*      */     
/* 6894 */     OreSpawnMain.setBlockFast(world, cposx, cposy - 2, cposz - 2, Blocks.diamond_block, 0, 2);
/* 6895 */     OreSpawnMain.setBlockFast(world, cposx, cposy + height + 1, cposz + width + 1, Blocks.diamond_block, 0, 2);
/* 6896 */     OreSpawnMain.setBlockFast(world, cposx, cposy - 2, cposz + width + 1, Blocks.diamond_block, 0, 2);
/* 6897 */     OreSpawnMain.setBlockFast(world, cposx, cposy + height + 1, cposz - 2, Blocks.diamond_block, 0, 2);
/*      */     
/* 6899 */     OreSpawnMain.setBlockFast(world, cposx, cposy - 1, cposz - 2, OreSpawnMain.CrystalTorch, 0, 2);
/* 6900 */     OreSpawnMain.setBlockFast(world, cposx, cposy + height + 2, cposz + width + 1, OreSpawnMain.CrystalTorch, 0, 2);
/* 6901 */     OreSpawnMain.setBlockFast(world, cposx, cposy - 1, cposz + width + 1, OreSpawnMain.CrystalTorch, 0, 2);
/* 6902 */     OreSpawnMain.setBlockFast(world, cposx, cposy + height + 2, cposz - 2, OreSpawnMain.CrystalTorch, 0, 2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void makequeencenteraltar(World world, int cposx, int cposy, int cposz) {
/* 6908 */     Block bid = Blocks.air;
/* 6909 */     int meta = 0;
/*      */ 
/*      */ 
/*      */     
/* 6913 */     int width = 10;
/* 6914 */     int length = 10;
/* 6915 */     int j = 0;
/* 6916 */     bid = Blocks.obsidian; int i;
/* 6917 */     for (i = -width; i <= width; i++) {
/* 6918 */       for (int k = -length; k <= length; k++) {
/* 6919 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/*      */     
/* 6923 */     width = 6;
/* 6924 */     length = 20;
/* 6925 */     j = 0;
/* 6926 */     bid = Blocks.obsidian;
/* 6927 */     for (i = -width; i <= width; i++) {
/* 6928 */       for (int k = -length; k <= length; k++) {
/* 6929 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/* 6932 */     width = 20;
/* 6933 */     length = 6;
/* 6934 */     j = 0;
/* 6935 */     bid = Blocks.obsidian;
/* 6936 */     for (i = -width; i <= width; i++) {
/* 6937 */       for (int k = -length; k <= length; k++) {
/* 6938 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 6943 */     width = 8;
/* 6944 */     length = 8;
/* 6945 */     j = 1;
/* 6946 */     for (i = -width; i <= width; i++) {
/* 6947 */       for (int k = -length; k <= length; k++) {
/* 6948 */         bid = Blocks.obsidian;
/* 6949 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       } 
/*      */     } 
/* 6952 */     width = 4;
/* 6953 */     length = 18;
/* 6954 */     j = 1;
/*      */     
/* 6956 */     for (i = -width; i <= width; i++) {
/* 6957 */       for (int k = -length; k <= length; k++) {
/* 6958 */         bid = Blocks.obsidian;
/* 6959 */         if (i == width && (
/* 6960 */           k == -length || k == length)) bid = OreSpawnMain.MyBlockAmethystBlock;
/*      */         
/* 6962 */         if (i == -width && (
/* 6963 */           k == -length || k == length)) bid = OreSpawnMain.MyBlockAmethystBlock;
/*      */         
/* 6965 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       } 
/*      */     } 
/* 6968 */     width = 18;
/* 6969 */     length = 4;
/* 6970 */     j = 1;
/* 6971 */     for (i = -width; i <= width; i++) {
/* 6972 */       for (int k = -length; k <= length; k++) {
/* 6973 */         bid = Blocks.obsidian;
/* 6974 */         if (i == width && (
/* 6975 */           k == -length || k == length)) bid = OreSpawnMain.MyBlockAmethystBlock;
/*      */         
/* 6977 */         if (i == -width && (
/* 6978 */           k == -length || k == length)) bid = OreSpawnMain.MyBlockAmethystBlock;
/*      */         
/* 6980 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 6985 */     width = 7;
/* 6986 */     length = 7;
/* 6987 */     j = 2;
/* 6988 */     bid = Blocks.obsidian;
/* 6989 */     for (i = -width; i <= width; i++) {
/* 6990 */       for (int k = -length; k <= length; k++) {
/* 6991 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/* 6992 */         if (i == width && (
/* 6993 */           k == -length || k == length)) {
/* 6994 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
/*      */         }
/*      */         
/* 6997 */         if (i == -width && (
/* 6998 */           k == -length || k == length)) {
/* 6999 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 7004 */     width = 3;
/* 7005 */     length = 17;
/* 7006 */     j = 2;
/* 7007 */     bid = Blocks.obsidian;
/* 7008 */     for (i = -width; i <= width; i++) {
/* 7009 */       for (int k = -length; k <= length; k++) {
/* 7010 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/* 7013 */     width = 17;
/* 7014 */     length = 3;
/* 7015 */     j = 2;
/* 7016 */     bid = Blocks.obsidian;
/* 7017 */     for (i = -width; i <= width; i++) {
/* 7018 */       for (int k = -length; k <= length; k++) {
/* 7019 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/*      */     
/* 7023 */     width = 6;
/* 7024 */     length = 6;
/* 7025 */     j = 3;
/* 7026 */     bid = Blocks.obsidian;
/* 7027 */     for (i = -width; i <= width; i++) {
/* 7028 */       for (int k = -length; k <= length; k++) {
/* 7029 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/* 7032 */     width = 2;
/* 7033 */     length = 16;
/* 7034 */     j = 3;
/* 7035 */     bid = Blocks.obsidian;
/* 7036 */     for (i = -width; i <= width; i++) {
/* 7037 */       for (int k = -length; k <= length; k++) {
/* 7038 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/* 7041 */     width = 16;
/* 7042 */     length = 2;
/* 7043 */     j = 3;
/* 7044 */     bid = Blocks.obsidian;
/* 7045 */     for (i = -width; i <= width; i++) {
/* 7046 */       for (int k = -length; k <= length; k++) {
/* 7047 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 7052 */     width = 2;
/* 7053 */     length = 2;
/* 7054 */     j = 4;
/* 7055 */     bid = Blocks.obsidian;
/* 7056 */     for (i = -width; i <= width; i++) {
/* 7057 */       for (int k = -length; k <= length; k++) {
/* 7058 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
/* 7059 */         if (i == width && (
/* 7060 */           k == -length || k == length)) {
/* 7061 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
/*      */         }
/*      */         
/* 7064 */         if (i == -width && (
/* 7065 */           k == -length || k == length)) {
/* 7066 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 7072 */     world.setBlock(cposx, cposy + j, cposz, (Block)Blocks.chest);
/* 7073 */     world.setBlockMetadataWithNotify(cposx, cposy + j, cposz, 2, 3);
/* 7074 */     TileEntityChest chest = getChestTileEntity(world, cposx, cposy + j, cposz);
/* 7075 */     if (chest != null)
/*      */     {
/* 7077 */       chest.setInventorySlotContents(13, new ItemStack(OreSpawnMain.TheQueenEgg));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeFrogPond(World world, int cposx, int cposy, int cposz) {
/* 7085 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */     
/* 7087 */     world.setBlock(cposx, cposy + 2, cposz, Blocks.mob_spawner, 0, 2);
/* 7088 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 2, cposz);
/* 7089 */     if (tileentitymobspawner != null)
/*      */     {
/* 7091 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Frog");
/*      */     }
/*      */     
/* 7094 */     for (int i = -3; i <= 3; i++) {
/* 7095 */       for (int j = -3; j <= 3; j++) {
/* 7096 */         world.setBlock(cposx + i, cposy, cposz + j, Blocks.water, 0, 3);
/*      */       }
/*      */     } 
/*      */     
/* 7100 */     world.setBlock(cposx, cposy + 1, cposz, Blocks.water, 0, 3);
/*      */     
/* 7102 */     world.setBlock(cposx - 1, cposy + 1, cposz, (Block)Blocks.flowing_water, 0, 3);
/* 7103 */     world.setBlock(cposx + 1, cposy + 1, cposz, (Block)Blocks.flowing_water, 0, 3);
/* 7104 */     world.setBlock(cposx, cposy + 1, cposz - 1, (Block)Blocks.flowing_water, 0, 3);
/* 7105 */     world.setBlock(cposx, cposy + 1, cposz + 1, (Block)Blocks.flowing_water, 0, 3);
/*      */     
/* 7107 */     world.setBlock(cposx - 1, cposy + 2, cposz, Blocks.waterlily, 0, 3);
/* 7108 */     world.setBlock(cposx + 1, cposy + 2, cposz, Blocks.waterlily, 0, 3);
/* 7109 */     world.setBlock(cposx, cposy + 2, cposz - 1, Blocks.waterlily, 0, 3);
/* 7110 */     world.setBlock(cposx, cposy + 2, cposz + 1, Blocks.waterlily, 0, 3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makePumpkin(World world, int cposx, int cposy, int cposz) {
/* 7117 */     int width = 14;
/* 7118 */     int depth = 12;
/* 7119 */     int height = 14;
/* 7120 */     int dark_green = 13;
/* 7121 */     int orange = 1;
/* 7122 */     int which_color = 0;
/* 7123 */     Block blk = Blocks.air;
/* 7124 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */     
/*      */     int i;
/*      */     
/* 7128 */     for (i = 0; i < width; i++) {
/* 7129 */       for (int m = 0; m < height; m++) {
/* 7130 */         for (int n = 0; n < depth; n++) {
/* 7131 */           which_color = 0;
/* 7132 */           blk = Blocks.air;
/* 7133 */           if (m == 0 || m == height - 1) {
/* 7134 */             blk = Blocks.stained_hardened_clay;
/* 7135 */             which_color = orange;
/*      */           } 
/* 7137 */           if (i == 0 || i == width - 1) {
/* 7138 */             blk = Blocks.stained_hardened_clay;
/* 7139 */             which_color = orange;
/*      */           } 
/* 7141 */           if (n == 0 || n == depth - 1) {
/* 7142 */             blk = Blocks.stained_hardened_clay;
/* 7143 */             which_color = orange;
/*      */           } 
/*      */           
/* 7146 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + m, cposz + n, blk, which_color, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 7151 */     i = width / 2 - 1;
/* 7152 */     int k = 0;
/* 7153 */     int j = 11;
/* 7154 */     OreSpawnMain.setBlockFast(world, cposx + i + 3, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7155 */     OreSpawnMain.setBlockFast(world, cposx + i + 4, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7156 */     OreSpawnMain.setBlockFast(world, cposx + i + 5, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7157 */     j = 10;
/* 7158 */     OreSpawnMain.setBlockFast(world, cposx + i + 3, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7159 */     OreSpawnMain.setBlockFast(world, cposx + i + 4, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7160 */     OreSpawnMain.setBlockFast(world, cposx + i + 5, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7161 */     j = 9;
/* 7162 */     OreSpawnMain.setBlockFast(world, cposx + i + 3, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7163 */     OreSpawnMain.setBlockFast(world, cposx + i + 4, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7164 */     OreSpawnMain.setBlockFast(world, cposx + i + 5, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7165 */     j = 8;
/* 7166 */     OreSpawnMain.setBlockFast(world, cposx + i + 2, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7167 */     OreSpawnMain.setBlockFast(world, cposx + i + 3, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7168 */     j = 7;
/* 7169 */     OreSpawnMain.setBlockFast(world, cposx + i + 2, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7170 */     OreSpawnMain.setBlockFast(world, cposx + i + 3, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7171 */     j = 4;
/* 7172 */     OreSpawnMain.setBlockFast(world, cposx + i + 1, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7173 */     OreSpawnMain.setBlockFast(world, cposx + i + 4, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7174 */     j = 3;
/* 7175 */     OreSpawnMain.setBlockFast(world, cposx + i + 1, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7176 */     OreSpawnMain.setBlockFast(world, cposx + i + 2, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7177 */     OreSpawnMain.setBlockFast(world, cposx + i + 3, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7178 */     OreSpawnMain.setBlockFast(world, cposx + i + 4, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7179 */     j = 2;
/* 7180 */     OreSpawnMain.setBlockFast(world, cposx + i + 1, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7181 */     OreSpawnMain.setBlockFast(world, cposx + i + 2, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7182 */     OreSpawnMain.setBlockFast(world, cposx + i + 3, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7183 */     OreSpawnMain.setBlockFast(world, cposx + i + 4, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7184 */     j = 1;
/* 7185 */     OreSpawnMain.setBlockFast(world, cposx + i + 2, cposy + j, cposz + k, Blocks.air, 0, 2);
/*      */ 
/*      */     
/* 7188 */     i = width / 2;
/* 7189 */     k = 0;
/* 7190 */     j = 11;
/* 7191 */     OreSpawnMain.setBlockFast(world, cposx + i - 3, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7192 */     OreSpawnMain.setBlockFast(world, cposx + i - 4, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7193 */     OreSpawnMain.setBlockFast(world, cposx + i - 5, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7194 */     j = 10;
/* 7195 */     OreSpawnMain.setBlockFast(world, cposx + i - 3, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7196 */     OreSpawnMain.setBlockFast(world, cposx + i - 4, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7197 */     OreSpawnMain.setBlockFast(world, cposx + i - 5, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7198 */     j = 9;
/* 7199 */     OreSpawnMain.setBlockFast(world, cposx + i - 3, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7200 */     OreSpawnMain.setBlockFast(world, cposx + i - 4, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7201 */     OreSpawnMain.setBlockFast(world, cposx + i - 5, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7202 */     j = 8;
/* 7203 */     OreSpawnMain.setBlockFast(world, cposx + i - 2, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7204 */     OreSpawnMain.setBlockFast(world, cposx + i - 3, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7205 */     j = 7;
/* 7206 */     OreSpawnMain.setBlockFast(world, cposx + i - 2, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7207 */     OreSpawnMain.setBlockFast(world, cposx + i - 3, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7208 */     j = 4;
/* 7209 */     OreSpawnMain.setBlockFast(world, cposx + i - 1, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7210 */     OreSpawnMain.setBlockFast(world, cposx + i - 4, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7211 */     j = 3;
/* 7212 */     OreSpawnMain.setBlockFast(world, cposx + i - 1, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7213 */     OreSpawnMain.setBlockFast(world, cposx + i - 2, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7214 */     OreSpawnMain.setBlockFast(world, cposx + i - 3, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7215 */     OreSpawnMain.setBlockFast(world, cposx + i - 4, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7216 */     j = 2;
/* 7217 */     OreSpawnMain.setBlockFast(world, cposx + i - 1, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7218 */     OreSpawnMain.setBlockFast(world, cposx + i - 2, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7219 */     OreSpawnMain.setBlockFast(world, cposx + i - 3, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7220 */     OreSpawnMain.setBlockFast(world, cposx + i - 4, cposy + j, cposz + k, Blocks.air, 0, 2);
/* 7221 */     j = 1;
/* 7222 */     OreSpawnMain.setBlockFast(world, cposx + i - 2, cposy + j, cposz + k, Blocks.air, 0, 2);
/*      */     
/* 7224 */     k = depth / 2 - 1;
/* 7225 */     for (j = 0; j < 4; j++) {
/* 7226 */       for (i = 0; i < 3; i++) {
/* 7227 */         OreSpawnMain.setBlockFast(world, cposx + width / 2 - i - j, cposy + height + j, cposz + k, Blocks.stained_hardened_clay, dark_green, 2);
/*      */       }
/*      */     } 
/*      */     
/* 7231 */     for (j = 0; j < 5; j++) {
/* 7232 */       for (i = 0; i < 2; i++) {
/* 7233 */         for (k = 0; k < 2; k++) {
/* 7234 */           OreSpawnMain.setBlockFast(world, cposx + width / 2 + i - 1, cposy + j + 1, cposz + depth / 2 + k - 1, Blocks.planks, 0, 2);
/*      */         }
/*      */       } 
/*      */     } 
/* 7238 */     j = 5;
/* 7239 */     for (i = 0; i < 2; i++) {
/* 7240 */       for (k = 0; k < 2; k++) {
/* 7241 */         OreSpawnMain.setBlockFast(world, cposx + width / 2 + i - 1, cposy + j + 1, cposz + depth / 2 + k - 1, Blocks.netherrack, 0, 2);
/*      */       }
/*      */     } 
/* 7244 */     j = 6;
/* 7245 */     k = 0;
/* 7246 */     for (i = 0; i < 2; i++) {
/* 7247 */       OreSpawnMain.setBlockFast(world, cposx + width / 2 + i - 1, cposy + j + 1, cposz + depth / 2 + k - 1, (Block)Blocks.fire, 0, 2);
/*      */     }
/* 7249 */     j = 6;
/* 7250 */     k = 1;
/* 7251 */     i = 0;
/* 7252 */     world.setBlock(cposx + width / 2 + i - 1, cposy + j + 1, cposz + depth / 2 + k - 1, Blocks.mob_spawner, 0, 2);
/* 7253 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 + i - 1, cposy + j + 1, cposz + depth / 2 + k - 1);
/* 7254 */     if (tileentitymobspawner != null)
/*      */     {
/* 7256 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ghost Pumpkin Skelly");
/*      */     }
/* 7258 */     i = 1;
/* 7259 */     world.setBlock(cposx + width / 2 + i - 1, cposy + j + 1, cposz + depth / 2 + k - 1, Blocks.mob_spawner, 0, 2);
/* 7260 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 + i - 1, cposy + j + 1, cposz + depth / 2 + k - 1);
/* 7261 */     if (tileentitymobspawner != null)
/*      */     {
/* 7263 */       tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Ghost Pumpkin Skelly");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeRoundRotator(World world, int cposx, int cposy, int cposz) {
/* 7273 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 7274 */     TileEntityChest chest = null;
/* 7275 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 7277 */     float radius = 6.0F; float curdeg;
/* 7278 */     for (curdeg = 0.0F; curdeg < 360.0F; curdeg += 5.0F) {
/* 7279 */       float curx = (float)(radius * Math.cos(Math.toRadians(curdeg)));
/* 7280 */       float cury = (float)(radius * Math.sin(Math.toRadians(curdeg)));
/* 7281 */       Block block = Blocks.bedrock;
/* 7282 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), (int)((cposy + 6) + cury + 0.5F), cposz, block);
/*      */     } 
/*      */     
/* 7285 */     radius = 2.0F;
/* 7286 */     for (curdeg = 0.0F; curdeg < 360.0F; curdeg += 5.0F) {
/* 7287 */       float curx = (float)(radius * Math.cos(Math.toRadians(curdeg)));
/* 7288 */       float cury = (float)(radius * Math.sin(Math.toRadians(curdeg)));
/* 7289 */       Block block = OreSpawnMain.MyCrystalPinkBlock;
/* 7290 */       FastSetBlock(world, (int)(cposx + curx + 0.5F), (int)((cposy + 6) + cury + 0.5F), cposz, block);
/*      */     } 
/*      */ 
/*      */     
/* 7294 */     world.setBlock(cposx + 1, cposy + 6 + 1, cposz, Blocks.mob_spawner, 0, 2);
/* 7295 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 1, cposy + 6 + 1, cposz);
/* 7296 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rotator");
/*      */     
/* 7298 */     world.setBlock(cposx - 1, cposy + 6 - 1, cposz, Blocks.mob_spawner, 0, 2);
/* 7299 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - 1, cposy + 6 - 1, cposz);
/* 7300 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rotator");
/*      */     
/* 7302 */     world.setBlock(cposx + 1, cposy + 6 - 1, cposz, Blocks.mob_spawner, 0, 2);
/* 7303 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 1, cposy + 6 - 1, cposz);
/* 7304 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rotator");
/*      */     
/* 7306 */     world.setBlock(cposx - 1, cposy + 6 + 1, cposz, Blocks.mob_spawner, 0, 2);
/* 7307 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - 1, cposy + 6 + 1, cposz);
/* 7308 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Rotator");
/*      */     
/* 7310 */     world.setBlock(cposx + 5, cposy + 6, cposz, Blocks.mob_spawner, 0, 2);
/* 7311 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 5, cposy + 6, cposz);
/* 7312 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Dungeon Beast");
/*      */     
/* 7314 */     world.setBlock(cposx - 5, cposy + 6, cposz, Blocks.mob_spawner, 0, 2);
/* 7315 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - 5, cposy + 6, cposz);
/* 7316 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Dungeon Beast");
/*      */     
/* 7318 */     world.setBlock(cposx, cposy + 6 - 5, cposz, Blocks.mob_spawner, 0, 2);
/* 7319 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 6 - 5, cposz);
/* 7320 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Dungeon Beast");
/*      */     
/* 7322 */     world.setBlock(cposx, cposy + 6 + 5, cposz, Blocks.mob_spawner, 0, 2);
/* 7323 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx, cposy + 6 + 5, cposz);
/* 7324 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Dungeon Beast");
/*      */     
/* 7326 */     Block blk = OreSpawnMain.CrystalCoal;
/* 7327 */     FastSetBlock(world, cposx + 1, cposy + 6, cposz, blk);
/* 7328 */     FastSetBlock(world, cposx - 1, cposy + 6, cposz, blk);
/* 7329 */     FastSetBlock(world, cposx, cposy + 6 + 1, cposz, blk);
/* 7330 */     FastSetBlock(world, cposx, cposy + 6 - 1, cposz, blk);
/*      */     
/* 7332 */     world.setBlock(cposx, cposy + 6, cposz, (Block)Blocks.chest);
/* 7333 */     world.setBlockMetadataWithNotify(cposx, cposy + 6, cposz, 2, 3);
/* 7334 */     chest = getChestTileEntity(world, cposx, cposy + 6, cposz);
/* 7335 */     if (chest != null) {
/* 7336 */       chestContents = this.CrystalBattleTowerVortexContentsList;
/* 7337 */       WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 6 + world.rand.nextInt(6));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/* 7342 */   private int[] blkcolors = new int[] { 14, 1, 4, 5, 3, 11, 10, 6 };
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeRainbow(World world, int cposx, int cposy, int cposz) {
/* 7347 */     int width = 12;
/* 7348 */     int depth = 1;
/* 7349 */     int blk_color = 0;
/* 7350 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 7351 */     TileEntityChest chest = null;
/* 7352 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 7354 */     blk_color = 0;
/* 7355 */     int j = 35;
/* 7356 */     width = 12;
/* 7357 */     depth = 1; int i;
/* 7358 */     for (i = -width; i < width; i++) {
/* 7359 */       for (int n = -depth; n <= depth; n++) {
/* 7360 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + n, Blocks.stained_hardened_clay, blk_color, 2);
/*      */       }
/*      */     } 
/* 7363 */     int k = 0;
/* 7364 */     for (i = -width + 1; i < width; i += 3) {
/* 7365 */       OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, Blocks.water, 0, 2);
/* 7366 */       OreSpawnMain.setBlockFast(world, cposx + i, cposy + j - 1, cposz + k, (Block)Blocks.flowing_water, 0, 2);
/*      */     } 
/*      */     
/* 7369 */     width = 13;
/* 7370 */     depth = 2;
/* 7371 */     j = 26;
/* 7372 */     for (i = -width; i < width; i++) {
/* 7373 */       for (k = -depth; k <= depth; k++) {
/* 7374 */         Block blk = Blocks.air;
/* 7375 */         if (i == -width || i == width - 1) blk = Blocks.stained_hardened_clay; 
/* 7376 */         if (k == -depth || k == depth) blk = Blocks.stained_hardened_clay; 
/* 7377 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, blk, blk_color, 2);
/*      */       } 
/*      */     } 
/* 7380 */     width = 14;
/* 7381 */     depth = 3;
/* 7382 */     j = 27;
/* 7383 */     for (i = -width; i < width; i++) {
/* 7384 */       for (k = -depth; k <= depth; k++) {
/* 7385 */         Block blk = Blocks.air;
/* 7386 */         if (i == -width || i == width - 1) blk = Blocks.stained_hardened_clay; 
/* 7387 */         if (k == -depth || k == depth) blk = Blocks.stained_hardened_clay; 
/* 7388 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, blk, blk_color, 2);
/*      */       } 
/*      */     } 
/* 7391 */     width = 13;
/* 7392 */     depth = 2;
/* 7393 */     j = 28;
/* 7394 */     for (i = -width; i < width; i++) {
/* 7395 */       for (k = -depth; k <= depth; k++) {
/* 7396 */         Block blk = Blocks.air;
/* 7397 */         if (i == -width || i == width - 1) blk = Blocks.stained_hardened_clay; 
/* 7398 */         if (k == -depth || k == depth) blk = Blocks.stained_hardened_clay; 
/* 7399 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, blk, blk_color, 2);
/*      */       } 
/*      */     } 
/* 7402 */     j = 29;
/* 7403 */     width = 12;
/* 7404 */     depth = 1;
/* 7405 */     for (i = -width; i < width; i++) {
/* 7406 */       for (k = -depth; k <= depth; k++) {
/* 7407 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, Blocks.stained_hardened_clay, blk_color, 2);
/*      */       }
/*      */     } 
/*      */     
/* 7411 */     j = 30;
/* 7412 */     for (int m = 3; m < 11; m++) {
/* 7413 */       blk_color = this.blkcolors[m - 3];
/* 7414 */       for (i = 0; i < m; i++) {
/* 7415 */         OreSpawnMain.setBlockFast(world, cposx + m, cposy + j + i, cposz, Blocks.stained_hardened_clay, blk_color, 2);
/* 7416 */         OreSpawnMain.setBlockFast(world, cposx - m + 1, cposy + j + i, cposz, Blocks.stained_hardened_clay, blk_color, 2);
/*      */       } 
/* 7418 */       for (i = -(m + 1); i <= m; i++) {
/* 7419 */         OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + m, cposz, Blocks.stained_hardened_clay, blk_color, 2);
/*      */       }
/*      */     } 
/*      */     
/* 7423 */     world.setBlock(cposx + 2, cposy + j, cposz, Blocks.mob_spawner, 0, 2);
/* 7424 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 2, cposy + j, cposz);
/* 7425 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Cloud Shark"); 
/* 7426 */     world.setBlock(cposx - 3, cposy + j, cposz, Blocks.mob_spawner, 0, 2);
/* 7427 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - 3, cposy + j, cposz);
/* 7428 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Cloud Shark"); 
/* 7429 */     world.setBlock(cposx + 2, cposy + j + 1, cposz, Blocks.mob_spawner, 0, 2);
/* 7430 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 2, cposy + j + 1, cposz);
/* 7431 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Cloud Shark"); 
/* 7432 */     world.setBlock(cposx - 3, cposy + j + 1, cposz, Blocks.mob_spawner, 0, 2);
/* 7433 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - 3, cposy + j + 1, cposz);
/* 7434 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Cloud Shark"); 
/* 7435 */     world.setBlock(cposx + 2, cposy + j + 2, cposz, Blocks.mob_spawner, 0, 2);
/* 7436 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + 2, cposy + j + 2, cposz);
/* 7437 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Cloud Shark"); 
/* 7438 */     world.setBlock(cposx - 3, cposy + j + 2, cposz, Blocks.mob_spawner, 0, 2);
/* 7439 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx - 3, cposy + j + 2, cposz);
/* 7440 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Cloud Shark");
/*      */     
/* 7442 */     chestContents = this.RainbowContentsList;
/* 7443 */     world.setBlock(cposx, cposy + j, cposz, (Block)Blocks.chest);
/* 7444 */     world.setBlockMetadataWithNotify(cposx, cposy + j, cposz, 2, 3);
/* 7445 */     chest = getChestTileEntity(world, cposx, cposy + j, cposz);
/* 7446 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 10 + world.rand.nextInt(5)); 
/* 7447 */     world.setBlock(cposx - 1, cposy + j, cposz, (Block)Blocks.chest);
/* 7448 */     world.setBlockMetadataWithNotify(cposx - 1, cposy + j, cposz, 2, 3);
/* 7449 */     chest = getChestTileEntity(world, cposx - 1, cposy + j, cposz);
/* 7450 */     if (chest != null) WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 10 + world.rand.nextInt(5));
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeEnormousCastleQ(World world, int cposx, int cposy, int cposz) {
/* 7457 */     int width = 28;
/* 7458 */     int height = 16;
/* 7459 */     int platformwidth = 11;
/* 7460 */     int level = 0;
/*      */     
/* 7462 */     if (world.isRemote) {
/*      */       return;
/*      */     }
/*      */     
/* 7466 */     level = 1 + world.rand.nextInt(6);
/* 7467 */     if (level <= 3 && world.rand.nextInt(3) != 1) level += 3;
/*      */     
/*      */     int i;
/* 7470 */     for (i = -20; i < width + 4; i++) {
/* 7471 */       for (int m = 1; m < height + 10; m++) {
/* 7472 */         for (int n = -4; n < width + 4; n++) {
/* 7473 */           FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.air);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7481 */     for (i = 0; i < width; i++) {
/* 7482 */       int m = 0;
/* 7483 */       for (int n = 0; n < width; n++) {
/* 7484 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.obsidian);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 7489 */     for (i = 0; i < width; i++) {
/* 7490 */       int m = height;
/* 7491 */       for (int n = 0; n < width; n++) {
/* 7492 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.bedrock);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 7497 */     for (i = 0; i < width; i++) {
/* 7498 */       for (int m = 1; m < height; m++) {
/* 7499 */         int n = 0;
/* 7500 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.iron_bars);
/* 7501 */         n = width - 1;
/* 7502 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.iron_bars);
/*      */       } 
/*      */     } 
/*      */     int k;
/* 7506 */     for (k = 0; k < width; k++) {
/* 7507 */       for (int m = 1; m < height; m++) {
/* 7508 */         i = 0;
/* 7509 */         FastSetBlock(world, cposx + i, cposy + m, cposz + k, Blocks.iron_bars);
/* 7510 */         i = width - 1;
/* 7511 */         FastSetBlock(world, cposx + i, cposy + m, cposz + k, Blocks.iron_bars);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 7516 */     world.setBlock(cposx + 1, cposy + 1, cposz + 1, OreSpawnMain.ExtremeTorch);
/* 7517 */     world.setBlock(cposx + 1, cposy + 1, cposz + width - 2, OreSpawnMain.ExtremeTorch);
/* 7518 */     world.setBlock(cposx + width - 2, cposy + 1, cposz + 1, OreSpawnMain.ExtremeTorch);
/* 7519 */     world.setBlock(cposx + width - 2, cposy + 1, cposz + width - 2, OreSpawnMain.ExtremeTorch);
/*      */ 
/*      */     
/* 7522 */     for (i = -4; i < width + 4; i++) {
/* 7523 */       for (k = -4; k < width + 4; k++) {
/* 7524 */         if (i < 0 || k < 0 || i >= width || k >= width)
/* 7525 */           FastSetBlock(world, cposx + i, cposy, cposz + k, Blocks.obsidian); 
/* 7526 */         if (i == -4 || k == -4 || i == width + 3 || k == width + 3)
/* 7527 */           FastSetBlock(world, cposx + i, cposy + 1, cposz + k, Blocks.nether_brick_fence); 
/*      */       } 
/*      */     } 
/* 7530 */     TileEntityMobSpawner tileentitymobspawner = null; int j;
/* 7531 */     for (j = 0; j < 4; j++) {
/*      */       
/* 7533 */       world.setBlock(cposx - 3, cposy + 1 + j, cposz - 3, Blocks.mob_spawner, 0, 2);
/* 7534 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx - 3, cposy + 1 + j, cposz - 3);
/* 7535 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Lurking Terror");
/*      */       
/* 7537 */       world.setBlock(cposx - 3, cposy + 1 + j, cposz + width + 2, Blocks.mob_spawner, 0, 2);
/* 7538 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx - 3, cposy + 1 + j, cposz + width + 2);
/* 7539 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Lurking Terror");
/*      */       
/* 7541 */       world.setBlock(cposx + width + 2, cposy + 1 + j, cposz - 3, Blocks.mob_spawner, 0, 2);
/* 7542 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width + 2, cposy + 1 + j, cposz - 3);
/* 7543 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Lurking Terror");
/*      */       
/* 7545 */       world.setBlock(cposx + width + 2, cposy + 1 + j, cposz + width + 2, Blocks.mob_spawner, 0, 2);
/* 7546 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width + 2, cposy + 1 + j, cposz + width + 2);
/* 7547 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Lurking Terror");
/*      */     
/*      */     } 
/*      */     
/* 7551 */     world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7552 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
/* 7553 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Emperor Scorpion"); 
/* 7554 */     world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7555 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
/* 7556 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Emperor Scorpion"); 
/* 7557 */     world.setBlock(cposx + width / 2, cposy + 4, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7558 */     tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 4, cposz + width / 2);
/* 7559 */     if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Emperor Scorpion");
/*      */     
/* 7561 */     j = height;
/* 7562 */     buildLevelQ(world, cposx + 1, cposy + j, cposz + 1, width - 2, 10, 4, "Rotator", 1, -1, 5, 1, level);
/* 7563 */     j += 10;
/* 7564 */     if (level >= 2) buildLevelQ(world, cposx + 1, cposy + j, cposz + 1, width - 2, 10, 4, "Bee", 0, 0, 4, 2, level); 
/* 7565 */     j += 10;
/* 7566 */     if (level >= 3) buildLevelQ(world, cposx + 2, cposy + j, cposz + 2, width - 4, 9, 4, "Mantis", 1, 1, 4, 3, level); 
/* 7567 */     j += 9;
/* 7568 */     if (level >= 4) buildLevelQ(world, cposx + 2, cposy + j, cposz + 2, width - 4, 9, 3, "Mothra", 0, 0, 4, 4, level); 
/* 7569 */     j += 9;
/* 7570 */     if (level >= 5) buildLevelQ(world, cposx + 3, cposy + j, cposz + 3, width - 6, 8, 3, "Brutalfly", 1, 1, 4, 5, level); 
/* 7571 */     j += 8;
/* 7572 */     if (level >= 6) buildLevelQ(world, cposx + 3, cposy + j, cposz + 3, width - 6, 16, 3, "Vortex", 0, 0, 3, 6, level); 
/* 7573 */     j += 16;
/*      */ 
/*      */ 
/*      */     
/* 7577 */     for (i = 0; i < platformwidth; i++) {
/* 7578 */       j = height;
/* 7579 */       for (k = -(platformwidth / 2); k <= platformwidth / 2; k++) {
/* 7580 */         FastSetBlock(world, cposx + i - 20, cposy + j, cposz + k + width / 2, OreSpawnMain.MyBlockAmethystBlock);
/* 7581 */         if ((i == 0 || i == platformwidth - 1 || k == -(platformwidth / 2) || k == platformwidth / 2) && (
/* 7582 */           i != 0 || k < -1 || k > 1)) {
/* 7583 */           FastSetBlock(world, cposx + i - 20, cposy + j + 1, cposz + k + width / 2, Blocks.nether_brick_fence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 7588 */     for (i = -10; i <= -3; i++) {
/* 7589 */       j = height;
/* 7590 */       for (k = -2; k < 3; k++) {
/* 7591 */         if (i == -3 || i == -10) {
/* 7592 */           if (k != -2 && k != 2) {
/* 7593 */             FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.air);
/*      */           } else {
/* 7595 */             FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.netherrack);
/* 7596 */             FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k + width / 2, Blocks.netherrack);
/* 7597 */             FastSetBlock(world, cposx + i, cposy + j + 3, cposz + k + width / 2, (Block)Blocks.fire);
/*      */           } 
/*      */         } else {
/* 7600 */           FastSetBlock(world, cposx + i, cposy + j, cposz + k + width / 2, OreSpawnMain.MyBlockAmethystBlock);
/* 7601 */           if (k == -2 || k == 2) {
/* 7602 */             FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.nether_brick_fence);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 7608 */     i = -21;
/* 7609 */     for (j = height; j >= 0; j--) {
/*      */       
/* 7611 */       for (k = -2; k < 3; k++) {
/*      */         
/* 7613 */         for (int t = 0; t < 6; ) { FastSetBlock(world, cposx + i, cposy + j + t + 1, cposz + k + width / 2, Blocks.air); t++; }
/*      */         
/* 7615 */         if (j == 0) {
/* 7616 */           if (k != -2 && k != 2) {
/* 7617 */             FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.air);
/*      */           } else {
/* 7619 */             FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.netherrack);
/* 7620 */             FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k + width / 2, Blocks.netherrack);
/* 7621 */             FastSetBlock(world, cposx + i, cposy + j + 3, cposz + k + width / 2, (Block)Blocks.fire);
/*      */           } 
/*      */         } else {
/* 7624 */           FastSetBlock(world, cposx + i, cposy + j, cposz + k + width / 2, OreSpawnMain.MyBlockAmethystBlock);
/* 7625 */           if (k == -2 || k == 2) {
/* 7626 */             FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.nether_brick_fence);
/*      */           }
/*      */         } 
/*      */       } 
/* 7630 */       i--;
/*      */     } 
/*      */     
/* 7633 */     if (level >= 6) {
/*      */       
/* 7635 */       int span = width * 3;
/* 7636 */       for (int tries = 0; tries < 100; tries++) {
/* 7637 */         j = -1;
/* 7638 */         i = world.rand.nextInt(span);
/* 7639 */         k = world.rand.nextInt(span);
/* 7640 */         if (i < span / 4 || i > span * 3 / 4 || k < span / 4 || k > span * 3 / 4) {
/* 7641 */           i -= span / 2;
/* 7642 */           k -= span / 2;
/* 7643 */           world.setBlock(cposx + i + width / 2, cposy + j, cposz + k + width / 2, Blocks.mob_spawner, 0, 2);
/* 7644 */           tileentitymobspawner = getSpawnerTileEntity(world, cposx + i + width / 2, cposy + j, cposz + k + width / 2);
/* 7645 */           if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Large Worm");
/*      */         
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void buildLevelQ(World world, int cposx, int cposy, int cposz, int width, int height, int pw, String critter, int stepside, int stepoff, int holelen, int decor, int level) {
/*      */     int i;
/* 7658 */     for (i = -pw; i < width + pw; i++) {
/* 7659 */       for (int m = 1; m < height; m++) {
/* 7660 */         for (int n = -pw; n < width + pw; n++) {
/* 7661 */           FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.air);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 7667 */     for (i = 0; i < width; i++) {
/* 7668 */       int m = 0;
/* 7669 */       for (int n = 0; n < width; n++) {
/* 7670 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.bedrock);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 7675 */     for (i = 0; i < width; i++) {
/* 7676 */       int m = height;
/* 7677 */       for (int n = 0; n < width; n++) {
/* 7678 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.bedrock);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 7683 */     for (i = 0; i < width; i++) {
/* 7684 */       for (int m = 1; m < height; m++) {
/* 7685 */         int n = 0;
/* 7686 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.bedrock);
/* 7687 */         n = width - 1;
/* 7688 */         FastSetBlock(world, cposx + i, cposy + m, cposz + n, Blocks.bedrock);
/*      */       } 
/*      */     } 
/*      */     int k;
/* 7692 */     for (k = 0; k < width; k++) {
/* 7693 */       for (int m = 1; m < height; m++) {
/* 7694 */         Block blk = Blocks.bedrock;
/* 7695 */         if (k == 0 || k == width - 1) blk = OreSpawnMain.MyBlockRubyBlock; 
/* 7696 */         i = 0;
/* 7697 */         FastSetBlock(world, cposx + i, cposy + m, cposz + k, blk);
/* 7698 */         i = width - 1;
/* 7699 */         FastSetBlock(world, cposx + i, cposy + m, cposz + k, blk);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7710 */     for (i = -pw; i < width + pw; i++) {
/* 7711 */       for (k = -pw; k < width + pw; k++) {
/* 7712 */         if (i < 0 || k < 0 || i >= width || k >= width)
/* 7713 */           FastSetBlock(world, cposx + i, cposy, cposz + k, Blocks.obsidian); 
/* 7714 */         if (i == -pw || k == -pw || i == width + pw - 1 || k == width + pw - 1) {
/* 7715 */           FastSetBlock(world, cposx + i, cposy + 1, cposz + k, Blocks.nether_brick_fence);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 7720 */     i = -(height / 2);
/* 7721 */     i += width / 2; int j;
/* 7722 */     for (j = 1; j < height; j++) {
/* 7723 */       if (stepside != 0) {
/* 7724 */         k = -1;
/* 7725 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.obsidian);
/*      */       } else {
/* 7727 */         k = width;
/* 7728 */         FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.obsidian);
/*      */       } 
/* 7730 */       i++;
/*      */     } 
/*      */     
/* 7733 */     if (stepoff >= 0) {
/*      */       
/* 7735 */       if (stepside == 0) {
/* 7736 */         k = -1;
/* 7737 */         k -= stepoff;
/*      */       } else {
/* 7739 */         k = width;
/* 7740 */         k += stepoff;
/*      */       } 
/* 7742 */       i = width / 2;
/* 7743 */       j = 0;
/* 7744 */       for (int l = 0; l < holelen; l++) {
/* 7745 */         FastSetBlock(world, cposx + i + l, cposy + j, cposz + k, Blocks.air);
/*      */       }
/*      */     } 
/*      */     
/* 7749 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 7750 */     for (j = 0; j < 4; j++) {
/*      */       
/* 7752 */       world.setBlock(cposx - pw - 1, cposy + j + 1, cposz - pw - 1, Blocks.mob_spawner, 0, 2);
/* 7753 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx - pw - 1, cposy + j + 1, cposz - pw - 1);
/* 7754 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter);
/*      */       
/* 7756 */       world.setBlock(cposx - pw - 1, cposy + j + 1, cposz + width + pw - 2, Blocks.mob_spawner, 0, 2);
/* 7757 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx - pw - 1, cposy + j + 1, cposz + width + pw - 2);
/* 7758 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter);
/*      */       
/* 7760 */       world.setBlock(cposx + width + pw - 2, cposy + j + 1, cposz - pw - 1, Blocks.mob_spawner, 0, 2);
/* 7761 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width + pw - 2, cposy + j + 1, cposz - pw - 1);
/* 7762 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter);
/*      */       
/* 7764 */       world.setBlock(cposx + width + pw - 2, cposy + j + 1, cposz + width + pw - 2, Blocks.mob_spawner, 0, 2);
/* 7765 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width + pw - 2, cposy + j + 1, cposz + width + pw - 2);
/* 7766 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter);
/*      */     
/*      */     } 
/* 7769 */     addLevelDecorationsQ(world, cposx, cposy, cposz, width, height, decor, level);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void addLevelDecorationsQ(World world, int cposx, int cposy, int cposz, int width, int height, int decor, int difficulty) {
/* 7775 */     TileEntityMobSpawner tileentitymobspawner = null;
/* 7776 */     int reward = 1;
/*      */     
/* 7778 */     String critter = "T. Rex";
/*      */     
/* 7780 */     if (decor == 6) {
/* 7781 */       FastSetBlock(world, cposx, cposy + height, cposz, Blocks.netherrack);
/* 7782 */       FastSetBlock(world, cposx, cposy + height + 1, cposz, (Block)Blocks.fire);
/* 7783 */       FastSetBlock(world, cposx, cposy + height, cposz + width - 1, Blocks.netherrack);
/* 7784 */       FastSetBlock(world, cposx, cposy + height + 1, cposz + width - 1, (Block)Blocks.fire);
/* 7785 */       FastSetBlock(world, cposx + width - 1, cposy + height, cposz, Blocks.netherrack);
/* 7786 */       FastSetBlock(world, cposx + width - 1, cposy + height + 1, cposz, (Block)Blocks.fire);
/* 7787 */       FastSetBlock(world, cposx + width - 1, cposy + height, cposz + width - 1, Blocks.netherrack);
/* 7788 */       FastSetBlock(world, cposx + width - 1, cposy + height + 1, cposz + width - 1, (Block)Blocks.fire);
/*      */       
/* 7790 */       FastSetBlock(world, cposx + width / 2, cposy + height, cposz + width / 2, Blocks.air);
/*      */       
/* 7792 */       world.setBlock(cposx + width / 2 - 1, cposy + height + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7793 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 - 1, cposy + height + 2, cposz + width / 2);
/* 7794 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Nightmare"); 
/* 7795 */       world.setBlock(cposx + width / 2 + 1, cposy + height + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7796 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2 + 1, cposy + height + 2, cposz + width / 2);
/* 7797 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Nightmare"); 
/* 7798 */       world.setBlock(cposx + width / 2, cposy + height + 2, cposz + width / 2 - 1, Blocks.mob_spawner, 0, 2);
/* 7799 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + height + 2, cposz + width / 2 - 1);
/* 7800 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Nightmare"); 
/* 7801 */       world.setBlock(cposx + width / 2, cposy + height + 2, cposz + width / 2 + 1, Blocks.mob_spawner, 0, 2);
/* 7802 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + height + 2, cposz + width / 2 + 1);
/* 7803 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Nightmare");
/*      */ 
/*      */       
/* 7806 */       for (int i = 1; i < width - 1; i++) {
/* 7807 */         for (int k = 1; k < 5; k++) {
/* 7808 */           for (int m = 1; m < width - 1; m++) {
/* 7809 */             FastSetBlock(world, cposx + i, cposy + k, cposz + m, Blocks.dirt);
/*      */           }
/*      */         } 
/*      */       } 
/* 7813 */       world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7814 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
/* 7815 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Large Worm"); 
/* 7816 */       world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7817 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
/* 7818 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Large Worm"); 
/* 7819 */       world.setBlock(cposx + width / 2, cposy + 4, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7820 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 4, cposz + width / 2);
/* 7821 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Large Worm");
/*      */       
/* 7823 */       for (int j = 0; j < 10; j++) {
/* 7824 */         FastSetBlock(world, cposx + 1, cposy + j, cposz + 1, Blocks.air);
/*      */       }
/*      */       
/* 7827 */       fill_chests(world, cposx, cposy + 4, cposz, width, height, decor, reward);
/*      */     } 
/* 7829 */     if (decor == 5) {
/* 7830 */       if (difficulty == 5) {
/* 7831 */         critter = "T. Rex";
/* 7832 */         reward = 1;
/*      */       } 
/* 7834 */       if (difficulty == 6) {
/* 7835 */         critter = "Nastysaurus";
/* 7836 */         reward = 2;
/*      */       } 
/*      */ 
/*      */       
/* 7840 */       world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7841 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
/* 7842 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 7843 */       world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7844 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
/* 7845 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 7846 */       for (int j = 1; j < 5; j++) {
/* 7847 */         FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 7848 */         FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 7849 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
/* 7850 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
/*      */       } 
/*      */       
/* 7853 */       FastSetBlock(world, cposx + width - 2, cposy, cposz + width - 2, Blocks.air);
/* 7854 */       FastSetBlock(world, cposx + 1, cposy + height, cposz + 1, Blocks.air);
/*      */       
/* 7856 */       fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
/*      */     } 
/* 7858 */     if (decor == 4) {
/* 7859 */       if (difficulty == 4) {
/* 7860 */         critter = "T. Rex";
/* 7861 */         reward = 1;
/*      */       } 
/* 7863 */       if (difficulty == 5) {
/* 7864 */         critter = "Nastysaurus";
/* 7865 */         reward = 2;
/*      */       } 
/* 7867 */       if (difficulty == 6) {
/* 7868 */         critter = "Basilisk";
/* 7869 */         reward = 3;
/*      */       } 
/*      */       
/* 7872 */       world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7873 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
/* 7874 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 7875 */       world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7876 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
/* 7877 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 7878 */       for (int j = 1; j < 5; j++) {
/* 7879 */         FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 7880 */         FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 7881 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
/* 7882 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
/*      */       } 
/*      */       
/* 7885 */       FastSetBlock(world, cposx + 1, cposy, cposz + 1, Blocks.air);
/* 7886 */       FastSetBlock(world, cposx + width - 2, cposy + height, cposz + width - 2, Blocks.air);
/*      */       
/* 7888 */       fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
/*      */     } 
/* 7890 */     if (decor == 3) {
/* 7891 */       if (difficulty == 3) {
/* 7892 */         critter = "T. Rex";
/* 7893 */         reward = 1;
/*      */       } 
/* 7895 */       if (difficulty == 4) {
/* 7896 */         critter = "Nastysaurus";
/* 7897 */         reward = 2;
/*      */       } 
/* 7899 */       if (difficulty == 5) {
/* 7900 */         critter = "Basilisk";
/* 7901 */         reward = 3;
/*      */       } 
/* 7903 */       if (difficulty == 6) {
/* 7904 */         critter = "Hercules Beetle";
/* 7905 */         reward = 4;
/*      */       } 
/*      */       
/* 7908 */       world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7909 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
/* 7910 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 7911 */       world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7912 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
/* 7913 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 7914 */       for (int j = 1; j < 5; j++) {
/* 7915 */         FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 7916 */         FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 7917 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
/* 7918 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
/*      */       } 
/*      */       
/* 7921 */       FastSetBlock(world, cposx + width - 2, cposy, cposz + width - 2, Blocks.air);
/* 7922 */       FastSetBlock(world, cposx + 1, cposy + height, cposz + 1, Blocks.air);
/*      */       
/* 7924 */       fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
/*      */     } 
/* 7926 */     if (decor == 2) {
/* 7927 */       if (difficulty == 2) {
/* 7928 */         critter = "T. Rex";
/* 7929 */         reward = 1;
/*      */       } 
/* 7931 */       if (difficulty == 3) {
/* 7932 */         critter = "Nastysaurus";
/* 7933 */         reward = 2;
/*      */       } 
/* 7935 */       if (difficulty == 4) {
/* 7936 */         critter = "Basilisk";
/* 7937 */         reward = 3;
/*      */       } 
/* 7939 */       if (difficulty == 5) {
/* 7940 */         critter = "Hercules Beetle";
/* 7941 */         reward = 4;
/*      */       } 
/* 7943 */       if (difficulty == 6) {
/* 7944 */         critter = "Jumpy Bug";
/* 7945 */         reward = 5;
/*      */       } 
/* 7947 */       world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7948 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
/* 7949 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 7950 */       world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7951 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
/* 7952 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 7953 */       for (int j = 1; j < 5; j++) {
/* 7954 */         FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 7955 */         FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 7956 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
/* 7957 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
/*      */       } 
/* 7959 */       FastSetBlock(world, cposx + 1, cposy, cposz + 1, Blocks.air);
/* 7960 */       FastSetBlock(world, cposx + width - 2, cposy + height, cposz + width - 2, Blocks.air);
/*      */       
/* 7962 */       fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
/*      */     } 
/* 7964 */     if (decor == 1) {
/* 7965 */       if (difficulty == 1) critter = "T. Rex"; 
/* 7966 */       if (difficulty == 2) critter = "Nastysaurus"; 
/* 7967 */       if (difficulty == 3) critter = "Basilisk"; 
/* 7968 */       if (difficulty == 4) critter = "Hercules Beetle"; 
/* 7969 */       if (difficulty == 5) critter = "Jumpy Bug"; 
/* 7970 */       if (difficulty == 6) critter = "CaterKiller"; 
/* 7971 */       reward = difficulty;
/*      */       
/* 7973 */       world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7974 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
/* 7975 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 7976 */       world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
/* 7977 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
/* 7978 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName(critter); 
/* 7979 */       for (int j = 1; j < 5; j++) {
/* 7980 */         FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 7981 */         FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
/* 7982 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
/* 7983 */         FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 7988 */       FastSetBlock(world, cposx + width / 2 - 1, cposy + 1, cposz + width / 2 - 1, OreSpawnMain.MyRTPBlock);
/* 7989 */       FastSetBlock(world, cposx + width / 2 + 1, cposy + 1, cposz + width / 2 + 1, OreSpawnMain.MyRTPBlock);
/* 7990 */       FastSetBlock(world, cposx + width / 2 + 1, cposy + 1, cposz + width / 2 - 1, OreSpawnMain.MyRTPBlock);
/* 7991 */       FastSetBlock(world, cposx + width / 2 - 1, cposy + 1, cposz + width / 2 + 1, OreSpawnMain.MyRTPBlock);
/*      */ 
/*      */       
/* 7994 */       FastSetBlock(world, cposx + 1, cposy + height, cposz + 1, Blocks.air);
/*      */       
/* 7996 */       fill_chestsQ(world, cposx, cposy, cposz, width, height, decor, reward);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void fill_chestsQ(World world, int cposx, int cposy, int cposz, int width, int height, int decor, int reward) {
/* 8004 */     TileEntityChest chest = null;
/* 8005 */     WeightedRandomChestContent[] chestContents = null;
/*      */     
/* 8007 */     chestContents = this.level1ContentsList;
/* 8008 */     if (reward == 2) chestContents = this.level2ContentsList; 
/* 8009 */     if (reward == 3) chestContents = this.level3ContentsList; 
/* 8010 */     if (reward == 4) chestContents = this.level4ContentsList; 
/* 8011 */     if (reward == 5) chestContents = this.level5ContentsList;
/*      */     
/* 8013 */     world.setBlock(cposx + 1, cposy + 1, cposz + width / 2, (Block)Blocks.chest, 0, 2);
/* 8014 */     world.setBlockMetadataWithNotify(cposx + 1, cposy + 1, cposz + width / 2, 5, 3);
/* 8015 */     chest = getChestTileEntity(world, cposx + 1, cposy + 1, cposz + width / 2);
/*      */     
/* 8017 */     if (chest != null)
/*      */     {
/* 8019 */       if (reward == 6) {
/* 8020 */         chest.setInventorySlotContents(1, new ItemStack(OreSpawnMain.ThePrincessEgg, 1, 0));
/*      */       } else {
/*      */         
/* 8023 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 5 + world.rand.nextInt(7));
/*      */       } 
/*      */     }
/*      */     
/* 8027 */     world.setBlock(cposx + width - 2, cposy + 1, cposz + width / 2, (Block)Blocks.chest, 0, 2);
/* 8028 */     world.setBlockMetadataWithNotify(cposx + width - 2, cposy + 1, cposz + width / 2, 4, 3);
/* 8029 */     chest = getChestTileEntity(world, cposx + width - 2, cposy + 1, cposz + width / 2);
/*      */     
/* 8031 */     if (chest != null)
/*      */     {
/* 8033 */       if (reward == 6) {
/*      */         
/* 8035 */         chest.setInventorySlotContents(1, new ItemStack((Item)OreSpawnMain.QueenHelmet, 1, 0));
/* 8036 */         chest.setInventorySlotContents(2, new ItemStack((Item)OreSpawnMain.QueenBody, 1, 0));
/*      */       } else {
/*      */         
/* 8039 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 5 + world.rand.nextInt(7));
/*      */       } 
/*      */     }
/*      */     
/* 8043 */     world.setBlock(cposx + width / 2, cposy + 1, cposz + 1, (Block)Blocks.chest, 0, 2);
/* 8044 */     world.setBlockMetadataWithNotify(cposx + width / 2, cposy + 1, cposz + 1, 3, 3);
/* 8045 */     chest = getChestTileEntity(world, cposx + width / 2, cposy + 1, cposz + 1);
/*      */     
/* 8047 */     if (chest != null)
/*      */     {
/* 8049 */       if (reward == 6) {
/*      */         
/* 8051 */         chest.setInventorySlotContents(1, new ItemStack((Item)OreSpawnMain.QueenLegs, 1, 0));
/* 8052 */         chest.setInventorySlotContents(2, new ItemStack((Item)OreSpawnMain.QueenBoots, 1, 0));
/*      */       } else {
/*      */         
/* 8055 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 5 + world.rand.nextInt(7));
/*      */       } 
/*      */     }
/*      */     
/* 8059 */     world.setBlock(cposx + width / 2, cposy + 1, cposz + width - 2, (Block)Blocks.chest, 0, 2);
/* 8060 */     world.setBlockMetadataWithNotify(cposx + width / 2, cposy + 1, cposz + width - 2, 2, 3);
/* 8061 */     chest = getChestTileEntity(world, cposx + width / 2, cposy + 1, cposz + width - 2);
/*      */     
/* 8063 */     if (chest != null)
/*      */     {
/* 8065 */       if (reward == 6) {
/*      */         
/* 8067 */         chest.setInventorySlotContents(1, new ItemStack(OreSpawnMain.MyRoyal, 1, 0));
/*      */       } else {
/* 8069 */         WeightedRandomChestContent.generateChestContents(world.rand, chestContents, (IInventory)chest, 5 + world.rand.nextInt(7));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeSpiderHangout(World world, int cposx, int cposy, int cposz) {
/* 8078 */     Entity var8 = null;
/* 8079 */     TileEntityMobSpawner tileentitymobspawner = null;
/*      */     int i;
/* 8081 */     for (i = 0; i < 20; i++) {
/* 8082 */       for (int k = -1; k < 20; k++) {
/* 8083 */         for (int m = 0; m < 20; m++) {
/* 8084 */           Block blk = Blocks.air;
/* 8085 */           if (k == -1) {
/* 8086 */             blk = Blocks.stone;
/*      */           }
/* 8088 */           if (k == 0) {
/* 8089 */             blk = Blocks.gravel;
/*      */           }
/* 8091 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + k, cposz + m, blk, 0, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 8097 */     for (int j = 1; j < 4; j++) {
/* 8098 */       int k = 0;
/* 8099 */       i = 0;
/* 8100 */       world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 8101 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 8102 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Spider Driver");
/*      */       
/* 8104 */       k = 19;
/* 8105 */       i = 19;
/* 8106 */       world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 8107 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 8108 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Spider Driver");
/*      */       
/* 8110 */       k = 0;
/* 8111 */       i = 19;
/* 8112 */       world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 8113 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 8114 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Spider Driver");
/*      */       
/* 8116 */       k = 19;
/* 8117 */       i = 0;
/* 8118 */       world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
/* 8119 */       tileentitymobspawner = getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
/* 8120 */       if (tileentitymobspawner != null) tileentitymobspawner.getSpawnerBaseLogic().setEntityName("Spider Driver");
/*      */     
/*      */     } 
/* 8123 */     var8 = EntityList.createEntityByName("Robot Spider", world);
/* 8124 */     if (var8 != null) {
/*      */ 
/*      */       
/* 8127 */       var8.setLocationAndAngles((cposx + 10), (cposy + 1), (cposz + 10), world.rand.nextFloat() * 360.0F, 0.0F);
/*      */       
/* 8129 */       world.spawnEntityInWorld(var8);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void makeRedAntHangout(World world, int cposx, int cposy, int cposz) {
/* 8140 */     Entity var8 = null;
/*      */     
/* 8142 */     for (int i = 0; i < 16; i++) {
/* 8143 */       for (int j = -1; j < 16; j++) {
/* 8144 */         for (int k = 0; k < 16; k++) {
/* 8145 */           Block blk = Blocks.air;
/* 8146 */           if (j == -1) {
/* 8147 */             blk = Blocks.stone;
/*      */           }
/* 8149 */           if (j == 0) {
/* 8150 */             blk = Blocks.gravel;
/* 8151 */             if ((i < 3 || i > 12) && (
/* 8152 */               k < 3 || k > 12)) {
/* 8153 */               blk = OreSpawnMain.MyRedAntBlock;
/*      */             }
/*      */           } 
/*      */           
/* 8157 */           OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, blk, 0, 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 8162 */     var8 = EntityList.createEntityByName("Robot Red Ant", world);
/* 8163 */     if (var8 != null) {
/*      */ 
/*      */       
/* 8166 */       var8.setLocationAndAngles((cposx + 8), (cposy + 1), (cposz + 8), world.rand.nextFloat() * 360.0F, 0.0F);
/*      */       
/* 8168 */       world.spawnEntityInWorld(var8);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\GenericDungeon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */