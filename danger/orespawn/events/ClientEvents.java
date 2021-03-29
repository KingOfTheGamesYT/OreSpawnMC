/*    */ package danger.orespawn.events;
/*    */ 
/*    */ import danger.orespawn.init.ModBlocks;
/*    */ import danger.orespawn.util.premium.PremiumChecker;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.renderer.color.IBlockColor;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.util.text.ITextComponent;
/*    */ import net.minecraft.util.text.TextComponentString;
/*    */ import net.minecraft.util.text.TextFormatting;
/*    */ import net.minecraft.world.ColorizerGrass;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraftforge.client.event.ColorHandlerEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.gameevent.PlayerEvent;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "orespawn", value = {Side.CLIENT})
/*    */ public class ClientEvents
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
/* 31 */     boolean premium = PremiumChecker.CheckUser(event.player);
/* 32 */     if (premium) {
/* 33 */       TextComponentString textComponentString = new TextComponentString("Welcome premium user!");
/* 34 */       textComponentString.getStyle().setColor(TextFormatting.GOLD);
/* 35 */       event.player.sendMessage((ITextComponent)textComponentString);
/*    */     } 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void registerBlockColors(ColorHandlerEvent.Block event) {
/* 41 */     event.getBlockColors().registerBlockColorHandler(new IBlockColor()
/*    */         {
/*    */           public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex) {
/* 44 */             double temperature = worldIn.getBiome(pos).getTemperature(pos);
/* 45 */             double humidity = worldIn.getBiome(pos).getRainfall();
/* 46 */             if (temperature < 0.0D) { temperature = 0.0D; }
/* 47 */             else if (temperature > 1.0D) { temperature = 1.0D; }
/* 48 */              if (humidity < 0.0D) { humidity = 0.0D; }
/* 49 */             else if (humidity > 1.0D) { humidity = 1.0D; }
/* 50 */              return ColorizerGrass.getGrassColor(temperature, humidity);
/*    */           }
/*    */         }new Block[] { ModBlocks.ANT_BLOCK });
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void registerItemColors(ColorHandlerEvent.Item event) {
/* 57 */     event.getItemColors().registerItemColorHandler((stack, tintIndex) -> ColorizerGrass.getGrassColor(0.5D, 0.5D), new Block[] { ModBlocks.ANT_BLOCK });
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\events\ClientEvents.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */