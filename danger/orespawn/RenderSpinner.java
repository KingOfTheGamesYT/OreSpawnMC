/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
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
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSpinner
/*    */   extends Render
/*    */ {
/* 24 */   public int spinItemIconIndex = 160;
/* 25 */   private static final ResourceLocation texture = new ResourceLocation("orespawn", "spinners.png");
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
/*    */   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 39 */     this; bindTexture(texture);
/* 40 */     GL11.glPushMatrix();
/* 41 */     GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/* 42 */     GL11.glEnable(32826);
/* 43 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 44 */     Tessellator var10 = Tessellator.instance;
/* 45 */     func_77026_a(var10, this.spinItemIconIndex, par1Entity.rotationPitch);
/* 46 */     GL11.glDisable(32826);
/* 47 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   private void func_77026_a(Tessellator par1Tessellator, int par2, float par3) {
/* 52 */     float var3 = (par2 % 16 * 16 + 0) / 256.0F;
/* 53 */     float var4 = (par2 % 16 * 16 + 16) / 256.0F;
/* 54 */     float var5 = (par2 / 16 * 16 + 0) / 256.0F;
/* 55 */     float var6 = (par2 / 16 * 16 + 16) / 256.0F;
/* 56 */     float var7 = 1.0F;
/* 57 */     float var8 = 0.5F;
/* 58 */     float var9 = 0.25F;
/*    */     
/* 60 */     GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
/* 61 */     GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
/*    */     
/* 63 */     GL11.glRotatef(par3, 0.0F, 0.0F, 1.0F);
/* 64 */     par1Tessellator.startDrawingQuads();
/* 65 */     par1Tessellator.setNormal(0.0F, 1.0F, 0.0F);
/* 66 */     par1Tessellator.addVertexWithUV((0.0F - var8), (0.0F - var9), 0.0D, var3, var6);
/* 67 */     par1Tessellator.addVertexWithUV((var7 - var8), (0.0F - var9), 0.0D, var4, var6);
/* 68 */     par1Tessellator.addVertexWithUV((var7 - var8), (var7 - var9), 0.0D, var4, var5);
/* 69 */     par1Tessellator.addVertexWithUV((0.0F - var8), (var7 - var9), 0.0D, var3, var5);
/* 70 */     par1Tessellator.draw();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 76 */     return texture;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderSpinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */