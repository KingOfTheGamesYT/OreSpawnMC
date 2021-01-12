/*    */ package danger.orespawn.entity.render;
/*    */ import danger.orespawn.entity.TRex;
/*    */ import danger.orespawn.entity.model.ModelTRex;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderTRex extends RenderLiving<TRex> {
/* 13 */   public static final ResourceLocation TEXTURES = new ResourceLocation("orespawn:textures/entity/trex.png");
/*    */ 
/*    */ 
/*    */   
/*    */   public RenderTRex(RenderManager manager) {
/* 18 */     super(manager, (ModelBase)new ModelTRex(1.5F), 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(TRex entity) {
/* 24 */     return TEXTURES;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void applyRotations(TRex entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
/* 29 */     super.applyRotations((EntityLivingBase)entityLiving, p_77043_2_, rotationYaw, partialTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespawn\entity\render\RenderTRex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */