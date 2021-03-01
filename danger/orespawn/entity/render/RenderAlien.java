/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Alien;
/*    */ import danger.orespawn.entity.model.ModelAlien;
/*    */ import javax.annotation.Nullable;
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
/*    */ 
/*    */ public class RenderAlien
/*    */   extends RenderLiving<Alien>
/*    */ {
/*    */   protected ModelAlien model;
/* 22 */   private float scale = 1.0F;
/*    */ 
/*    */   
/*    */   public RenderAlien(RenderManager manager) {
/* 26 */     super(manager, (ModelBase)new ModelAlien(0.1F), 0.0F);
/* 27 */     this.model = (ModelAlien)this.mainModel;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(Alien entity) {
/* 34 */     return new ResourceLocation("orespawn:textures/entity/alien.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\render\RenderAlien.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */