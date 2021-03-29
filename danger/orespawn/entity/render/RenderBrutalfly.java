/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Brutalfly;
/*    */ import danger.orespawn.entity.model.ModelBrutalfly;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderBrutalfly
/*    */   extends RenderLiving<Brutalfly>
/*    */ {
/*    */   public RenderBrutalfly(RenderManager rendermanagerIn) {
/* 16 */     super(rendermanagerIn, (ModelBase)new ModelBrutalfly(0.1F), 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(Brutalfly entity) {
/* 22 */     return new ResourceLocation("orespawn:textures/entity/brutalfly.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\render\RenderBrutalfly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */