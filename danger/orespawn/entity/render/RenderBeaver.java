/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Beaver;
/*    */ import danger.orespawn.entity.model.ModelBeaver;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderBeaver
/*    */   extends RenderLiving<Beaver> {
/*    */   public RenderBeaver(RenderManager rendermanagerIn) {
/* 15 */     super(rendermanagerIn, (ModelBase)new ModelBeaver(1.0F), 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(Beaver entity) {
/* 21 */     return new ResourceLocation("orespawn:textures/entity/beaver.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\render\RenderBeaver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */