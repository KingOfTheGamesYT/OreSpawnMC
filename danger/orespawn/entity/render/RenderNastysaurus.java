/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.model.ModelNastysaurus;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ public class RenderNastysaurus
/*    */   extends RenderLiving
/*    */ {
/*    */   public RenderNastysaurus(RenderManager renderManager) {
/* 16 */     super(renderManager, (ModelBase)new ModelNastysaurus(1.5F), 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 22 */     return new ResourceLocation("orespawn:textures/entity/nastysaurus.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\entity\render\RenderNastysaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */