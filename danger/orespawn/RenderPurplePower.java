/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
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
/*    */ public class RenderPurplePower
/*    */   extends RenderLiving
/*    */ {
/*    */   protected ModelPurplePower model;
/* 18 */   private float scale = 1.0F;
/* 19 */   private static final ResourceLocation texture = new ResourceLocation("orespawn", "PurplePowertexture.png");
/* 20 */   private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "PurplePowertexture2.png");
/* 21 */   private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "PurplePowertexture3.png");
/* 22 */   private static final ResourceLocation texture4 = new ResourceLocation("orespawn", "PurplePowertexture4.png");
/* 23 */   private static final ResourceLocation texture10 = new ResourceLocation("orespawn", "PurplePowertexture10.png");
/*    */   
/*    */   public RenderPurplePower(ModelPurplePower par1ModelBase, float par2, float par3) {
/* 26 */     super(par1ModelBase, par2 * par3);
/* 27 */     this.model = (ModelPurplePower)this.mainModel;
/* 28 */     this.scale = par3;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderPurplePower(PurplePower par1EntityPurplePower, double par2, double par4, double par6, float par8, float par9) {
/* 34 */     doRender(par1EntityPurplePower, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 45 */     renderPurplePower((PurplePower)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderScale(PurplePower par1Entity, float par2) {
/* 53 */     float localscale = this.scale;
/* 54 */     if (par1Entity.getPurpleType() != 0) localscale = 0.55F; 
/* 55 */     GL11.glScalef(localscale, localscale, localscale);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 62 */     PurplePower p = (PurplePower)entity;
/* 63 */     int i = p.getPurpleType();
/* 64 */     if (i == 1) return texture2; 
/* 65 */     if (i == 2) return texture3; 
/* 66 */     if (i == 3) return texture4; 
/* 67 */     if (i == 10) return texture10; 
/* 68 */     return texture;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderPurplePower.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */