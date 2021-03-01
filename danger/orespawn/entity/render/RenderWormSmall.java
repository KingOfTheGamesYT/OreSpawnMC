/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.WormSmall;
/*    */ import danger.orespawn.entity.model.ModelWormSmall;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderWormSmall
/*    */   extends RenderLiving<WormSmall>
/*    */ {
/*    */   protected ModelWormSmall model;
/* 21 */   private float scale = 1.0F;
/* 22 */   private static final ResourceLocation texture = new ResourceLocation("orespawn:textures/entity/wormsmalltexture.png");
/*    */   
/*    */   public RenderWormSmall(RenderManager manager) {
/* 25 */     super(manager, (ModelBase)new ModelWormSmall(), 0.0F);
/* 26 */     this.model = (ModelWormSmall)this.mainModel;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(WormSmall entity) {
/* 33 */     return texture;
/*    */   }
/*    */   
/*    */   protected void preRenderScale(WormSmall par1Entity, float par2) {
/* 37 */     GL11.glScalef(this.scale, this.scale, this.scale);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void preRenderCallback(WormSmall entitylivingbaseIn, float partialTickTime) {
/* 42 */     preRenderScale(entitylivingbaseIn, partialTickTime);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\render\RenderWormSmall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */