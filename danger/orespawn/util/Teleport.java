/*    */ package danger.orespawn.util;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.Teleporter;
/*    */ import net.minecraft.world.WorldServer;
/*    */ 
/*    */ public class Teleport
/*    */   extends Teleporter {
/*    */   private final WorldServer world;
/*    */   private final double x;
/*    */   private final double y;
/*    */   private final double z;
/*    */   
/*    */   public Teleport(WorldServer world, double x, double y, double z) {
/* 21 */     super(world);
/* 22 */     this.world = world;
/* 23 */     this.x = x;
/* 24 */     this.y = y;
/* 25 */     this.z = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void placeInPortal(Entity entityIn, float rotationYaw) {
/* 30 */     this.world.getBlockState(new BlockPos(this.x, this.y, this.z));
/* 31 */     entityIn.setPosition(this.x, this.y, this.z);
/* 32 */     entityIn.motionX = 0.0D;
/* 33 */     entityIn.motionY = 0.0D;
/* 34 */     entityIn.motionZ = 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void teleportToDimension(EntityPlayer player, int dimension, double x, double y, double z) {
/* 39 */     if (!(player instanceof EntityPlayerMP)) {
/*    */       return;
/*    */     }
/* 42 */     int oldDimension = (player.getEntityWorld()).provider.getDimension();
/* 43 */     MinecraftServer server = player.getEntityWorld().getMinecraftServer();
/* 44 */     assert server != null;
/* 45 */     WorldServer worldServer = server.getWorld(oldDimension);
/* 46 */     WorldServer newDim = server.getWorld(dimension);
/*    */ 
/*    */     
/* 49 */     int i = 0;
/* 50 */     for (i = 255; i > 0 && 
/* 51 */       newDim.getBlockState(new BlockPos(x, i, z)) == Blocks.AIR.getDefaultState(); i--);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 56 */     i++;
/*    */     
/* 58 */     ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(worldServer.getMinecraftServer())).getPlayerList().transferPlayerToDimension((EntityPlayerMP)player, dimension, new Teleport(worldServer, x, i, z));
/*    */     
/* 60 */     player.setPositionAndUpdate(x, i, z);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespaw\\util\Teleport.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */