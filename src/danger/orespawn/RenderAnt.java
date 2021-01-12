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
/*    */ public class RenderAnt
/*    */   extends RenderLiving
/*    */ {
/*    */   protected ModelAnt model;
/* 15 */   private float scale = 0.25F;
/*    */   
/*    */   public RenderAnt(ModelAnt par1ModelBase, float par2, float par3) {
/* 18 */     super(par1ModelBase, par2 * par3);
/* 19 */     this.model = (ModelAnt)this.mainModel;
/* 20 */     this.scale = par3;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAnt(EntityAnt par1EntityAnt, double par2, double par4, double par6, float par8, float par9) {
/* 26 */     super.doRender((EntityLiving)par1EntityAnt, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */   
/*    */   public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
/* 31 */     renderAnt((EntityAnt)par1EntityLiving, par2, par4, par6, par8, par9);
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
/* 42 */     renderAnt((EntityAnt)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderScale(EntityAnt par1Entity, float par2) {
/* 50 */     GL11.glScalef(this.scale, this.scale, this.scale);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
/* 59 */     preRenderScale((EntityAnt)par1EntityLiving, par2);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 64 */     EntityAnt a = (EntityAnt)entity;
/* 65 */     return a.getTexture(a);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderAnt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */