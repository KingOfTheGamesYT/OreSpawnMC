/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Mothra;
/*    */ import danger.orespawn.entity.model.ModelButterfly;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderMothra
/*    */   extends RenderLiving<Mothra> {
/*    */   public RenderMothra(RenderManager rendermanagerIn) {
/* 15 */     super(rendermanagerIn, (ModelBase)new ModelButterfly(0.1F, 8.0F), 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(Mothra entity) {
/* 21 */     return new ResourceLocation("orespawn:textures/entity/eyemoth.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\render\RenderMothra.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */