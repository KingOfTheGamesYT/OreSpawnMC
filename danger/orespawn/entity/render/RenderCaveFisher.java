/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.CaveFisher;
/*    */ import danger.orespawn.entity.model.ModelCaveFisher;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderCaveFisher extends RenderLiving<CaveFisher> {
/* 13 */   public static final ResourceLocation TEXTURES = new ResourceLocation("orespawn:textures/entity/cavefisher.png");
/*    */ 
/*    */ 
/*    */   
/*    */   public RenderCaveFisher(RenderManager manager) {
/* 18 */     super(manager, (ModelBase)new ModelCaveFisher(1.0F), 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(CaveFisher entity) {
/* 24 */     return TEXTURES;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void applyRotations(CaveFisher entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
/* 29 */     super.applyRotations((EntityLivingBase)entityLiving, p_77043_2_, rotationYaw, partialTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\entity\render\RenderCaveFisher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */