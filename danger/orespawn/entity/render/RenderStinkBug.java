/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.StinkBug;
/*    */ import danger.orespawn.entity.model.ModelStinkBug;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderStinkBug
/*    */   extends RenderLiving<StinkBug>
/*    */ {
/*    */   public RenderStinkBug(RenderManager manager) {
/* 16 */     super(manager, (ModelBase)new ModelStinkBug(0.1F), 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(StinkBug entity) {
/* 24 */     return new ResourceLocation("orespawn:textures/entity/stinkbug.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\render\RenderStinkBug.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */