/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Bird;
/*    */ import danger.orespawn.entity.model.ModelBird;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.math.MathHelper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderBird
/*    */   extends RenderLiving<Bird>
/*    */ {
/*    */   protected ModelBird model;
/* 22 */   private static final ResourceLocation TEXTURE1 = new ResourceLocation("orespawn:textures/entity/bird1.png");
/* 23 */   private static final ResourceLocation TEXTURE2 = new ResourceLocation("orespawn:textures/entity/bird2.png");
/* 24 */   private static final ResourceLocation TEXTURE3 = new ResourceLocation("orespawn:textures/entity/bird3.png");
/* 25 */   private static final ResourceLocation TEXTURE4 = new ResourceLocation("orespawn:textures/entity/bird4.png");
/* 26 */   private static final ResourceLocation TEXTURE5 = new ResourceLocation("orespawn:textures/entity/bird5.png");
/* 27 */   private static final ResourceLocation TEXTURE6 = new ResourceLocation("orespawn:textures/entity/bird6.png");
/*    */   
/*    */   public RenderBird(RenderManager manager) {
/* 30 */     super(manager, (ModelBase)new ModelBird(0.6F), 0.0F);
/* 31 */     this.model = (ModelBird)this.mainModel;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(Bird entity) {
/* 37 */     switch (entity.birdType) { case 1:
/* 38 */         return TEXTURE1;
/* 39 */       case 2: return TEXTURE2;
/* 40 */       case 3: return TEXTURE3;
/* 41 */       case 4: return TEXTURE4;
/* 42 */       case 5: return TEXTURE5; }
/* 43 */      return TEXTURE6;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void applyRotations(Bird entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
/* 49 */     GlStateManager.translate(0.0F, MathHelper.cos(p_77043_2_ * 0.3F) * 0.1F, 0.0F);
/* 50 */     super.applyRotations((EntityLivingBase)entityLiving, p_77043_2_, rotationYaw, partialTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespawn\entity\render\RenderBird.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */