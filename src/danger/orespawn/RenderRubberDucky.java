/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class RenderRubberDucky
/*    */   extends RenderLiving
/*    */ {
/*    */   protected ModelRubberDucky model;
/* 15 */   private float scale = 1.0F;
/* 16 */   private static final ResourceLocation texture = new ResourceLocation("orespawn", "RubberDuckytexture.png");
/* 17 */   private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "EvilRubberDuckytexture.png");
/*    */   
/*    */   public RenderRubberDucky(ModelRubberDucky par1ModelBase, float par2, float par3) {
/* 20 */     super(par1ModelBase, par2 * par3);
/* 21 */     this.model = (ModelRubberDucky)this.mainModel;
/* 22 */     this.scale = par3;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderRubberDucky(RubberDucky par1EntityRubberDucky, double par2, double par4, double par6, float par8, float par9) {
/* 28 */     super.doRender((EntityLiving)par1EntityRubberDucky, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */   
/*    */   public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
/* 33 */     renderRubberDucky((RubberDucky)par1EntityLiving, par2, par4, par6, par8, par9);
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
/* 44 */     renderRubberDucky((RubberDucky)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderScale(RubberDucky par1Entity, float par2) {
/* 52 */     if (par1Entity != null && 
/* 53 */       par1Entity.isChild()) {
/* 54 */       GL11.glScalef(this.scale / 2.0F, this.scale / 2.0F, this.scale / 2.0F);
/*    */       
/*    */       return;
/*    */     } 
/* 58 */     GL11.glScalef(this.scale, this.scale, this.scale);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
/* 67 */     preRenderScale((RubberDucky)par1EntityLiving, par2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 73 */     if (entity instanceof RubberDucky) {
/* 74 */       RubberDucky d = (RubberDucky)entity;
/* 75 */       if (d.getKillCount() >= 5) return texture2; 
/*    */     } 
/* 77 */     return texture;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderRubberDucky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */