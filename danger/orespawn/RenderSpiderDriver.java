/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.client.model.ModelSpider;
/*    */ import net.minecraft.client.renderer.entity.RenderSpider;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.monster.EntitySpider;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderSpiderDriver
/*    */   extends RenderSpider
/*    */ {
/* 18 */   private static final ResourceLocation texture = new ResourceLocation("orespawn", "spiderdriver.png");
/*    */ 
/*    */ 
/*    */   
/*    */   public RenderSpiderDriver(ModelSpider modelSpider, float par2) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderSpiderDriver(SpiderDriver par1EntitySpiderDriver, double par2, double par4, double par6, float par8, float par9) {
/* 27 */     super.doRender((EntityLiving)par1EntitySpiderDriver, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */   
/*    */   public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
/* 32 */     renderSpiderDriver((SpiderDriver)par1EntityLiving, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 43 */     renderSpiderDriver((SpiderDriver)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 48 */     return texture;
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation getSpiderTextures(EntitySpider par1EntitySpider) {
/* 53 */     return texture;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderSpiderDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */