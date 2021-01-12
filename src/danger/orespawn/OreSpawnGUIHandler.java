/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.common.network.IGuiHandler;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OreSpawnGUIHandler
/*    */   implements IGuiHandler
/*    */ {
/*    */   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
/* 32 */     TileEntity tileEntity = world.getTileEntity(x, y, z);
/*    */     
/* 34 */     switch (ID) {
/*    */       case 0:
/* 36 */         if (tileEntity instanceof TileEntityCrystalFurnace) {
/* 37 */           return new ContainerCrystalFurnace(player.inventory, (TileEntityCrystalFurnace)tileEntity);
/*    */         }
/*    */         break;
/*    */       
/*    */       case 1:
/* 42 */         return new ContainerCrystalWorkbench(player.inventory, world, x, y, z);
/*    */     } 
/*    */ 
/*    */     
/* 46 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
/* 71 */     TileEntity tileEntity = world.getTileEntity(x, y, z);
/*    */     
/* 73 */     switch (ID) {
/*    */       case 0:
/* 75 */         if (tileEntity instanceof TileEntityCrystalFurnace) {
/* 76 */           return new CrystalFurnaceGUI(player.inventory, (TileEntityCrystalFurnace)tileEntity);
/*    */         }
/*    */         break;
/*    */       case 1:
/* 80 */         return new CrystalWorkbenchGUI(player.inventory, world, x, y, z);
/*    */     } 
/*    */ 
/*    */     
/* 84 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\OreSpawnGUIHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */