/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.RedAnt;
/*    */ import danger.orespawn.entity.model.ModelAnt;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderRedAnt extends RenderLiving<RedAnt> {
/* 13 */   public static final ResourceLocation TEXTURES = new ResourceLocation("orespawn:textures/entity/red_ant.png");
/*    */ 
/*    */ 
/*    */   
/*    */   public RenderRedAnt(RenderManager manager) {
/* 18 */     super(manager, (ModelBase)new ModelAnt(), 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(RedAnt entity) {
/* 24 */     return TEXTURES;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void applyRotations(RedAnt entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
/* 29 */     super.applyRotations((EntityLivingBase)entityLiving, p_77043_2_, rotationYaw, partialTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespawn\entity\render\RenderRedAnt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */