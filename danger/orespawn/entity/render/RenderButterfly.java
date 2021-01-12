/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Butterfly;
/*    */ import danger.orespawn.entity.model.ModelButterfly;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderButterfly
/*    */   extends RenderLiving<Butterfly>
/*    */ {
/*    */   protected ModelButterfly model;
/* 28 */   private float scale = 1.0F;
/* 29 */   private static final ResourceLocation TEXTURE1 = new ResourceLocation("orespawn:textures/entity/butterfly.png");
/* 30 */   private static final ResourceLocation TEXTURE2 = new ResourceLocation("orespawn:textures/entity/butterfly2.png");
/* 31 */   private static final ResourceLocation TEXTURE3 = new ResourceLocation("orespawn:textures/entity/butterfly3.png");
/* 32 */   private static final ResourceLocation TEXTURE4 = new ResourceLocation("orespawn:textures/entity/butterfly4.png");
/*    */   
/*    */   public RenderButterfly(RenderManager manager) {
/* 35 */     super(manager, (ModelBase)new ModelButterfly(0.6F), 0.0F);
/* 36 */     this.model = (ModelButterfly)this.mainModel;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(Butterfly entity) {
/* 42 */     switch (entity.butterflyType) { case 1:
/* 43 */         return TEXTURE1;
/* 44 */       case 2: return TEXTURE2;
/* 45 */       case 3: return TEXTURE3; }
/* 46 */      return TEXTURE4;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void applyRotations(Butterfly entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
/* 52 */     GlStateManager.translate(0.0F, MathHelper.cos(p_77043_2_ * 0.3F) * 0.1F, 0.0F);
/* 53 */     super.applyRotations((EntityLivingBase)entityLiving, p_77043_2_, rotationYaw, partialTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespawn\entity\render\RenderButterfly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */