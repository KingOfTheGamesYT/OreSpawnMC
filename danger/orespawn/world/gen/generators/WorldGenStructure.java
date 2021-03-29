/*    */ package danger.orespawn.world.gen.generators;
/*    */ 
/*    */ import danger.orespawn.util.interfaces.IStructure;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ import net.minecraft.world.gen.structure.template.Template;
/*    */ import net.minecraft.world.gen.structure.template.TemplateManager;
/*    */ 
/*    */ public class WorldGenStructure
/*    */   extends WorldGenerator
/*    */   implements IStructure {
/*    */   public static String structureName;
/*    */   
/*    */   public WorldGenStructure(String name) {
/* 20 */     this; structureName = name;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean generate(World worldIn, Random rand, BlockPos position) {
/* 25 */     generateStructure(worldIn, position);
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public static void generateStructure(World world, BlockPos pos) {
/* 30 */     MinecraftServer mcServer = world.getMinecraftServer();
/* 31 */     TemplateManager manager = worldServer.getStructureTemplateManager();
/* 32 */     ResourceLocation location = new ResourceLocation("orespawn", structureName);
/* 33 */     Template template = manager.get(mcServer, location);
/*    */     
/* 35 */     if (template != null) {
/* 36 */       IBlockState state = world.getBlockState(pos);
/* 37 */       world.notifyBlockUpdate(pos, state, state, 3);
/* 38 */       template.addBlocksToWorld(world, pos, settings);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\world\gen\generators\WorldGenStructure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */