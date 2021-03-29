/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Termite;
/*    */ import danger.orespawn.entity.model.ModelAnt;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderTermite extends RenderLiving<Termite> {
/* 13 */   public static final ResourceLocation TEXTURES = new ResourceLocation("orespawn:textures/entity/termite.png");
/*    */ 
/*    */   
/*    */   public RenderTermite(RenderManager manager) {
/* 17 */     super(manager, (ModelBase)new ModelAnt(), 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Termite entity) {
/* 23 */     return TEXTURES;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void applyRotations(Termite entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
/* 28 */     super.applyRotations((EntityLivingBase)entityLiving, p_77043_2_, rotationYaw, partialTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\render\RenderTermite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */