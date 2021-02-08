/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.model.ModelFirefly;
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
/*    */ 
/*    */ public class RenderFirefly
/*    */   extends RenderLiving
/*    */ {
/* 18 */   private static final ResourceLocation texture = new ResourceLocation("orespawn:textures/entity/firefly.png");
/*    */   
/*    */   public RenderFirefly(RenderManager renderManager) {
/* 21 */     super(renderManager, (ModelBase)new ModelFirefly(1.5F), 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 26 */     return texture;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\entity\render\RenderFirefly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */