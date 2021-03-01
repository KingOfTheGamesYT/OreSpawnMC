/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Moth;
/*    */ import danger.orespawn.entity.model.ModelButterfly;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderMoth
/*    */   extends RenderLiving<Moth> {
/*    */   protected ModelButterfly model;
/* 16 */   private float scale = 1.0F;
/*    */ 
/*    */   
/*    */   public RenderMoth(RenderManager manager) {
/* 20 */     super(manager, (ModelBase)new ModelButterfly(0.1F), 0.0F);
/* 21 */     this.model = (ModelButterfly)this.mainModel;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(Moth entity) {
/* 27 */     return new ResourceLocation("orespawn:textures/entity/lunamoth.png");
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renderModel(Moth entitylivingbaseIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
/* 32 */     super.renderModel((EntityLivingBase)entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor * 2.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\render\RenderMoth.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */