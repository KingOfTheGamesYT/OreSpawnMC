/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Alosaurus;
/*    */ import danger.orespawn.entity.model.ModelAlosaurus;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderAlosaurus extends RenderLiving<Alosaurus> {
/* 13 */   public static final ResourceLocation TEXTURES = new ResourceLocation("orespawn:textures/entity/alosaurus.png");
/*    */   
/*    */   public RenderAlosaurus(RenderManager manager) {
/* 16 */     super(manager, (ModelBase)new ModelAlosaurus(1.5F), 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Alosaurus entity) {
/* 22 */     return TEXTURES;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void applyRotations(Alosaurus entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
/* 27 */     super.applyRotations((EntityLivingBase)entityLiving, p_77043_2_, rotationYaw, partialTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\entity\render\RenderAlosaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */