/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Mantis;
/*    */ import danger.orespawn.entity.model.ModelMantis;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderMantis
/*    */   extends RenderLiving<Mantis> {
/*    */   public RenderMantis(RenderManager rendermanagerIn) {
/* 15 */     super(rendermanagerIn, (ModelBase)new ModelMantis(1.0F), 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(Mantis entity) {
/* 21 */     return new ResourceLocation("orespawn:textures/entity/mantis.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\render\RenderMantis.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */