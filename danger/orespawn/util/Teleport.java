/*    */ package danger.orespawn.util;
/*    */ 
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
/*    */   private double x;
/*    */   
/*    */   public Teleport(WorldServer world, double x, double y, double z) {
/* 18 */     super(world);
/* 19 */     this.world = world;
/* 20 */     this.x = x;
/* 21 */     this.y = y;
/* 22 */     this.z = z;
/*    */   }
/*    */   private double y; private double z;
/*    */   
/*    */   public void placeInPortal(Entity entityIn, float rotationYaw) {
/* 27 */     this.world.getBlockState(new BlockPos(this.x, this.y, this.z));
/* 28 */     entityIn.setPosition(this.x, this.y, this.z);
/* 29 */     entityIn.motionX = 0.0D;
/* 30 */     entityIn.motionY = 0.0D;
/* 31 */     entityIn.motionZ = 0.0D;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void teleportToDimension(EntityPlayer player, int dimension, double x, double y, double z) {
/* 37 */     int oldDimension = (player.getEntityWorld()).provider.getDimension();
/* 38 */     EntityPlayerMP entityPlayerMP = (EntityPlayerMP)player;
/* 39 */     MinecraftServer server = player.getEntityWorld().getMinecraftServer();
/* 40 */     WorldServer worldServer = server.getWorld(oldDimension);
/* 41 */     WorldServer newDim = server.getWorld(dimension);
/*    */ 
/*    */     
/* 44 */     int i = 0;
/* 45 */     for (i = 255; i > 0; i--) {
/*    */       
/* 47 */       if (newDim.getBlockState(new BlockPos(x, i, z)) != Blocks.AIR.getDefaultState()) {
/*    */         break;
/*    */       }
/*    */     } 
/*    */     
/* 52 */     i++;
/*    */     
/* 54 */     if (worldServer == null || server == null) throw new IllegalArgumentException("Dimension: " + dimension + " doesnt exist"); 
/* 55 */     worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, dimension, new Teleport(worldServer, x, i, z));
/* 56 */     player.setPositionAndUpdate(x, i, z);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespaw\\util\Teleport.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */