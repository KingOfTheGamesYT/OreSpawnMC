/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Kyuubi;
/*    */ import danger.orespawn.entity.model.ModelKyuubi;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderKyuubi
/*    */   extends RenderLiving<Kyuubi> {
/*    */   public RenderKyuubi(RenderManager rendermanagerIn) {
/* 15 */     super(rendermanagerIn, (ModelBase)new ModelKyuubi(1.0F), 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(Kyuubi entity) {
/* 21 */     return new ResourceLocation("orespawn:textures/entity/kyuubi.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\render\RenderKyuubi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */