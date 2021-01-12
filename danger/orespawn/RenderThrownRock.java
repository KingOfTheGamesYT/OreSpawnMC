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
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderThrownRock
/*    */   extends Render
/*    */ {
/* 23 */   private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "textures/items/rocksmall.png");
/* 24 */   private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "textures/items/rock.png");
/* 25 */   private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "textures/items/rockred.png");
/* 26 */   private static final ResourceLocation texture4 = new ResourceLocation("orespawn", "textures/items/rockgreen.png");
/* 27 */   private static final ResourceLocation texture5 = new ResourceLocation("orespawn", "textures/items/rockblue.png");
/* 28 */   private static final ResourceLocation texture6 = new ResourceLocation("orespawn", "textures/items/rockpurple.png");
/* 29 */   private static final ResourceLocation texture7 = new ResourceLocation("orespawn", "textures/items/rockspikey.png");
/* 30 */   private static final ResourceLocation texture8 = new ResourceLocation("orespawn", "textures/items/rocktnt.png");
/* 31 */   private static final ResourceLocation texture9 = new ResourceLocation("orespawn", "textures/items/rockcrystalred.png");
/* 32 */   private static final ResourceLocation texture10 = new ResourceLocation("orespawn", "textures/items/rockcrystalgreen.png");
/* 33 */   private static final ResourceLocation texture11 = new ResourceLocation("orespawn", "textures/items/rockcrystalblue.png");
/* 34 */   private static final ResourceLocation texture12 = new ResourceLocation("orespawn", "textures/items/rockcrystaltnt.png");
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
/* 48 */     bindTexture(getEntityTexture(par1Entity));
/* 49 */     GL11.glPushMatrix();
/* 50 */     GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/* 51 */     GL11.glEnable(32826);
/* 52 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 53 */     Tessellator var10 = Tessellator.instance;
/* 54 */     func_77026_a(var10, 0, par1Entity.rotationPitch);
/* 55 */     GL11.glDisable(32826);
/* 56 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   private void func_77026_a(Tessellator par1Tessellator, int par2, float par3) {
/* 61 */     float var3 = (par2 % 16 * 16 + 0) / 16.0F;
/* 62 */     float var4 = (par2 % 16 * 16 + 16) / 16.0F;
/* 63 */     float var5 = (par2 / 16 * 16 + 0) / 16.0F;
/* 64 */     float var6 = (par2 / 16 * 16 + 16) / 16.0F;
/* 65 */     float var7 = 1.0F;
/* 66 */     float var8 = 0.5F;
/* 67 */     float var9 = 0.25F;
/*    */     
/* 69 */     GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
/* 70 */     GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
/*    */     
/* 72 */     GL11.glRotatef(par3, 0.0F, 0.0F, 1.0F);
/* 73 */     par1Tessellator.startDrawingQuads();
/* 74 */     par1Tessellator.setNormal(0.0F, 1.0F, 0.0F);
/* 75 */     par1Tessellator.addVertexWithUV((0.0F - var8), (0.0F - var9), 0.0D, var3, var6);
/* 76 */     par1Tessellator.addVertexWithUV((var7 - var8), (0.0F - var9), 0.0D, var4, var6);
/* 77 */     par1Tessellator.addVertexWithUV((var7 - var8), (var7 - var9), 0.0D, var4, var5);
/* 78 */     par1Tessellator.addVertexWithUV((0.0F - var8), (var7 - var9), 0.0D, var3, var5);
/* 79 */     par1Tessellator.draw();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 84 */     EntityThrownRock r = (EntityThrownRock)entity;
/*    */     
/* 86 */     if (r.getRockType() == 1) return texture1; 
/* 87 */     if (r.getRockType() == 2) return texture2; 
/* 88 */     if (r.getRockType() == 3) return texture3; 
/* 89 */     if (r.getRockType() == 4) return texture4; 
/* 90 */     if (r.getRockType() == 5) return texture5; 
/* 91 */     if (r.getRockType() == 6) return texture6; 
/* 92 */     if (r.getRockType() == 7) return texture7; 
/* 93 */     if (r.getRockType() == 8) return texture8; 
/* 94 */     if (r.getRockType() == 9) return texture9; 
/* 95 */     if (r.getRockType() == 10) return texture10; 
/* 96 */     if (r.getRockType() == 11) return texture11; 
/* 97 */     if (r.getRockType() == 12) return texture12; 
/* 98 */     return texture1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderThrownRock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */