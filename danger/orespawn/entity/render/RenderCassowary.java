/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Cassowary;
/*    */ import danger.orespawn.entity.model.ModelCassowary;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderCassowary
/*    */   extends RenderLiving<Cassowary> {
/*    */   public RenderCassowary(RenderManager rendermanagerIn) {
/* 15 */     super(rendermanagerIn, (ModelBase)new ModelCassowary(1.0F), 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(Cassowary entity) {
/* 21 */     return new ResourceLocation("orespawn:textures/entity/cassowary.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\render\RenderCassowary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */