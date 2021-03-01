/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.model.ModelMosquito;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderMosquito
/*    */   extends RenderLiving
/*    */ {
/*    */   protected ModelMosquito model;
/* 18 */   private float scale = 1.0F;
/* 19 */   private static final ResourceLocation texture = new ResourceLocation("orespawn:textures/entity/mosquito.png");
/*    */   
/*    */   public RenderMosquito(RenderManager renderManager) {
/* 22 */     super(renderManager, (ModelBase)new ModelMosquito(), 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 28 */     return texture;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\render\RenderMosquito.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */