/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.GammaMetroid;
/*    */ import danger.orespawn.entity.model.ModelGammaMetroid;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderGammaMetroid
/*    */   extends RenderLiving<GammaMetroid>
/*    */ {
/*    */   protected ModelGammaMetroid model;
/* 21 */   private float scale = 1.0F;
/* 22 */   private static final ResourceLocation texture = new ResourceLocation("orespawn:textures/entity/gammametroid.png");
/*    */   
/*    */   public RenderGammaMetroid(RenderManager renderManager) {
/* 25 */     super(renderManager, (ModelBase)new ModelGammaMetroid(1.0F), 0.0F);
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
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderScale(GammaMetroid par1Entity, float par2) {
/* 54 */     if (par1Entity != null && 
/* 55 */       par1Entity.isChild()) {
/* 56 */       GL11.glScalef(this.scale / 2.0F, this.scale / 2.0F, this.scale / 2.0F);
/*    */       
/*    */       return;
/*    */     } 
/* 60 */     GL11.glScalef(this.scale, this.scale, this.scale);
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
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(GammaMetroid entity) {
/* 75 */     return texture;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\render\RenderGammaMetroid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */