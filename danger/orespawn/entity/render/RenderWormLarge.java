/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.WormLarge;
/*    */ import danger.orespawn.entity.model.ModelWormLarge;
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
/*    */ public class RenderWormLarge
/*    */   extends RenderLiving<WormLarge>
/*    */ {
/*    */   protected ModelWormLarge model;
/* 21 */   private float scale = 1.0F;
/* 22 */   private static final ResourceLocation texture = new ResourceLocation("orespawn:textures/entity/wormlargetexture.png");
/*    */   
/*    */   public RenderWormLarge(RenderManager manager) {
/* 25 */     super(manager, (ModelBase)new ModelWormLarge(), 0.0F);
/* 26 */     this.model = (ModelWormLarge)this.mainModel;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(WormLarge entity) {
/* 33 */     return texture;
/*    */   }
/*    */   
/*    */   protected void preRenderScale(WormLarge par1Entity, float par2) {
/* 37 */     GL11.glScalef(this.scale, this.scale, this.scale);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void preRenderCallback(WormLarge entitylivingbaseIn, float partialTickTime) {
/* 42 */     preRenderScale(entitylivingbaseIn, partialTickTime);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\render\RenderWormLarge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */