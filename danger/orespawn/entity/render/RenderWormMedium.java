/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.WormMedium;
/*    */ import danger.orespawn.entity.model.ModelWormMedium;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderWormMedium
/*    */   extends RenderLiving<WormMedium>
/*    */ {
/*    */   protected ModelWormMedium model;
/* 21 */   private float scale = 1.0F;
/* 22 */   private static final ResourceLocation texture = new ResourceLocation("orespawn:textures/entity/wormmediumtexture.png");
/*    */   
/*    */   public RenderWormMedium(RenderManager manager) {
/* 25 */     super(manager, (ModelBase)new ModelWormMedium(), 0.0F);
/* 26 */     this.model = (ModelWormMedium)this.mainModel;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(WormMedium entity) {
/* 33 */     return texture;
/*    */   }
/*    */   
/*    */   protected void preRenderScale(WormMedium par1Entity, float par2) {
/* 37 */     GL11.glScalef(this.scale, this.scale, this.scale);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void preRenderCallback(WormMedium entitylivingbaseIn, float partialTickTime) {
/* 42 */     preRenderScale(entitylivingbaseIn, partialTickTime);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\render\RenderWormMedium.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */