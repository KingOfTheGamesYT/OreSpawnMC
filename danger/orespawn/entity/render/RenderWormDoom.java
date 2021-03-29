/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.WormDoom;
/*    */ import danger.orespawn.entity.model.ModelWormDoom;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
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
/*    */ public class RenderWormDoom
/*    */   extends RenderLiving<WormDoom>
/*    */ {
/*    */   protected ModelWormDoom model;
/* 27 */   private float scale = 1.0F;
/* 28 */   private static final ResourceLocation texture = new ResourceLocation("orespawn:textures/entity/wormdoomtexture.png");
/*    */   
/*    */   public RenderWormDoom(RenderManager manager) {
/* 31 */     super(manager, (ModelBase)new ModelWormDoom(), 0.0F);
/* 32 */     this.model = (ModelWormDoom)this.mainModel;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(WormDoom entity) {
/* 38 */     return texture;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderCallback(WormDoom entitylivingbaseIn, float partialTickTime) {
/* 44 */     super.preRenderCallback((EntityLivingBase)entitylivingbaseIn, partialTickTime);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void doRender(WormDoom entity, double x, double y, double z, float entityYaw, float partialTicks) {
/* 52 */     super.doRender((EntityLiving)entity, x, y, z, entityYaw, partialTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\render\RenderWormDoom.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */