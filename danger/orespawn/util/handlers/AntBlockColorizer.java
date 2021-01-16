/*    */ package danger.orespawn.util.handlers;
/*    */ 
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.ColorizerGrass;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraftforge.client.event.ColorHandlerEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ @EventBusSubscriber
/*    */ public class AntBlockColorizer
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void registerBlockColors(ColorHandlerEvent.Block event) {
/* 22 */     event.getBlockColors().registerBlockColorHandler((state, worldIn, pos, tintIndex) -> ColorizerGrass.getGrassColor(0.5D, 1.0D), new Block[] { ModBlocks.ANT_BLOCK });
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void registerItemColors(ColorHandlerEvent.Item event) {
/* 28 */     event.getItemColors().registerItemColorHandler((stack, tintIndex) -> ColorizerGrass.getGrassColor(0.5D, 1.0D), new Block[] { ModBlocks.ANT_BLOCK });
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespaw\\util\handlers\AntBlockColorizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */