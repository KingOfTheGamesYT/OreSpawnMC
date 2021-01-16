/*    */ package danger.orespawn.init;
/*    */ import danger.orespawn.blocks.BlockAnt;
/*    */ import danger.orespawn.blocks.BlockButterflyPlant;
/*    */ import danger.orespawn.blocks.BlockCornPlant;
/*    */ import danger.orespawn.blocks.BlockUranium;
/*    */ import danger.orespawn.blocks.OreGenericEgg;
/*    */ import danger.orespawn.blocks.OreUranium;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ 
/*    */ public class ModBlocks {
/* 13 */   public static final List<Block> BLOCKS = new ArrayList<>();
/*    */ 
/*    */   
/* 16 */   public static final Block CORN_PLANT = (Block)new BlockCornPlant();
/* 17 */   public static final Block BUTTERFLY_PLANT = (Block)new BlockButterflyPlant();
/*    */   
/* 19 */   public static final Block URANIUM_BLOCK = (Block)new BlockUranium();
/* 20 */   public static final Block TITANIUM_BLOCK = (Block)new BlockTitanium();
/* 21 */   public static final Block URANIUM_ORE = (Block)new OreUranium();
/* 22 */   public static final Block TITANIUM_ORE = (Block)new OreTitanium();
/*    */   
/* 24 */   public static final Block ANT_BLOCK = (Block)new BlockAnt();
/*    */   
/* 26 */   public static final Block ALOSAURUS_ORE = (Block)new OreGenericEgg("alosaurus_ore");
/* 27 */   public static final Block BARYONYX_ORE = (Block)new OreGenericEgg("baryonyx_ore");
/* 28 */   public static final Block CAMARASAURUS_ORE = (Block)new OreGenericEgg("camarasaurus_ore");
/* 29 */   public static final Block CRYOLOPHOSAURUS_ORE = (Block)new OreGenericEgg("cryolophosaurus_ore");
/* 30 */   public static final Block POINTYSAURUS_ORE = (Block)new OreGenericEgg("pointysaurus_ore");
/* 31 */   public static final Block TREX_ORE = (Block)new OreGenericEgg("trex_ore");
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\init\ModBlocks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */