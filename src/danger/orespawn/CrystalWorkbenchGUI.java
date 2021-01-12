/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class CrystalWorkbenchGUI
/*    */   extends GuiContainer
/*    */ {
/* 16 */   private static final ResourceLocation craftingTableGuiTextures = new ResourceLocation("textures/gui/container/crafting_table.png");
/*    */ 
/*    */   
/*    */   public CrystalWorkbenchGUI(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
/* 20 */     super(new ContainerCrystalWorkbench(par1InventoryPlayer, par2World, par3, par4, par5));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawGuiContainerForegroundLayer(int par1, int par2) {
/* 28 */     this.fontRendererObj.drawString(I18n.format("container.crafting", new Object[0]), 28, 6, 4210752);
/* 29 */     this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
/* 37 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 38 */     this.mc.getTextureManager().bindTexture(craftingTableGuiTextures);
/* 39 */     int k = (this.width - this.xSize) / 2;
/* 40 */     int l = (this.height - this.ySize) / 2;
/* 41 */     drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CrystalWorkbenchGUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */