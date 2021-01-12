/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelCow;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class RenderEnchantedCow
/*    */   extends RenderLiving
/*    */ {
/*    */   protected ModelCow model;
/* 16 */   private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "crystal_cow.png");
/* 17 */   private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "red_cow.png");
/* 18 */   private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "gold_cow.png");
/*    */   
/*    */   public RenderEnchantedCow(ModelCow par1ModelBase, float par2) {
/* 21 */     super((ModelBase)par1ModelBase, par2);
/* 22 */     this.model = (ModelCow)this.mainModel;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderEnchantedCow(RedCow par1EntityEnchantedCow, double par2, double par4, double par6, float par8, float par9) {
/* 28 */     super.doRender((EntityLiving)par1EntityEnchantedCow, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */   
/*    */   public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
/* 33 */     renderEnchantedCow((RedCow)par1EntityLiving, par2, par4, par6, par8, par9);
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
/* 44 */     renderEnchantedCow((RedCow)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3) {
/* 53 */     if (par1EntityLiving instanceof EnchantedCow && par2 == 3) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 59 */       setRenderPassModel((ModelBase)this.model);
/* 60 */       GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 61 */       return 31;
/*    */     } 
/* 63 */     return -1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 69 */     if (entity instanceof EnchantedCow) return texture2; 
/* 70 */     if (entity instanceof GoldCow) return texture2; 
/* 71 */     if (entity instanceof CrystalCow) return texture3; 
/* 72 */     return texture1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderEnchantedCow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */