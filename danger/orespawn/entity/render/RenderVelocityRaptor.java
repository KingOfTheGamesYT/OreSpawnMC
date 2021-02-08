/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.VelocityRaptor;
/*    */ import danger.orespawn.entity.model.ModelVelocityRaptor;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class RenderVelocityRaptor extends RenderLiving<VelocityRaptor> {
/*    */   public RenderVelocityRaptor(RenderManager rendermanagerIn) {
/* 16 */     super(rendermanagerIn, (ModelBase)new ModelVelocityRaptor(1.0F), 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderCallback(VelocityRaptor entitylivingbaseIn, float partialTickTime) {
/* 22 */     GL11.glScalef(0.8F, 0.8F, 0.8F);
/* 23 */     super.preRenderCallback((EntityLivingBase)entitylivingbaseIn, partialTickTime);
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(VelocityRaptor entity) {
/* 29 */     return new ResourceLocation("orespawn:textures/entity/velocityraptor.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\entity\render\RenderVelocityRaptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */