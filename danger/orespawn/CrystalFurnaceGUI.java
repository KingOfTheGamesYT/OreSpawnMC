/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class CrystalFurnaceGUI
/*    */   extends GuiContainer
/*    */ {
/* 15 */   private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
/*    */   
/*    */   private TileEntityCrystalFurnace furnaceInventory;
/*    */   
/*    */   public CrystalFurnaceGUI(InventoryPlayer par1InventoryPlayer, TileEntityCrystalFurnace par2TileEntityCrystalFurnace) {
/* 20 */     super(new ContainerCrystalFurnace(par1InventoryPlayer, par2TileEntityCrystalFurnace));
/* 21 */     this.furnaceInventory = par2TileEntityCrystalFurnace;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawGuiContainerForegroundLayer(int par1, int par2) {
/* 29 */     String s = this.furnaceInventory.hasCustomInventoryName() ? this.furnaceInventory.getInventoryName() : I18n.format(this.furnaceInventory.getInventoryName(), new Object[0]);
/* 30 */     this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
/* 31 */     this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
/* 39 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 40 */     this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
/* 41 */     int k = (this.width - this.xSize) / 2;
/* 42 */     int l = (this.height - this.ySize) / 2;
/* 43 */     drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
/*    */ 
/*    */     
/* 46 */     if (this.furnaceInventory.isBurning()) {
/*    */       
/* 48 */       int i = this.furnaceInventory.getBurnTimeRemainingScaled(12);
/* 49 */       drawTexturedModalRect(k + 56, l + 36 + 12 - i, 176, 12 - i, 14, i + 2);
/*    */     } 
/*    */     
/* 52 */     int i1 = this.furnaceInventory.getCookProgressScaled(24);
/* 53 */     drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CrystalFurnaceGUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */