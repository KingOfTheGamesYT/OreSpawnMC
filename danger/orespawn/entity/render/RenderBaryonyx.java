/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Baryonyx;
/*    */ import danger.orespawn.entity.model.ModelBaryonyx;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderBaryonyx extends RenderLiving<Baryonyx> {
/* 14 */   public static final ResourceLocation TEXTURES = new ResourceLocation("orespawn:textures/entity/baryonyx.png");
/*    */ 
/*    */ 
/*    */   
/*    */   public RenderBaryonyx(RenderManager manager) {
/* 19 */     super(manager, (ModelBase)new ModelBaryonyx(1.5F), 0.8F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Baryonyx entity) {
/* 25 */     return TEXTURES;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void applyRotations(Baryonyx entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
/* 30 */     super.applyRotations((EntityLivingBase)entityLiving, p_77043_2_, rotationYaw, partialTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespawn\entity\render\RenderBaryonyx.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */