/*    */ package danger.orespawn.util.interfaces;
/*    */ 
/*    */ import net.minecraft.util.Mirror;
/*    */ import net.minecraft.util.Rotation;
/*    */ import net.minecraft.world.WorldServer;
/*    */ import net.minecraft.world.gen.structure.template.PlacementSettings;
/*    */ import net.minecraftforge.fml.common.FMLCommonHandler;
/*    */ 
/*    */ public interface IStructure {
/* 10 */   public static final WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(0);
/* 11 */   public static final PlacementSettings settings = (new PlacementSettings()).setChunk(null).setIgnoreEntities(false).setIgnoreStructureBlock(false).setMirror(Mirror.NONE).setRotation(Rotation.NONE);
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespaw\\util\interfaces\IStructure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */