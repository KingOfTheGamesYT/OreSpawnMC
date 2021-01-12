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
/*    */ public class RenderCreepingHorror
/*    */   extends RenderLiving
/*    */ {
/*    */   protected ModelCreepingHorror model;
/* 15 */   private float scale = 1.0F;
/* 16 */   private static final ResourceLocation texture = new ResourceLocation("orespawn", "CreepingHorror.png");
/*    */   
/*    */   public RenderCreepingHorror(ModelCreepingHorror par1ModelBase, float par2, float par3) {
/* 19 */     super(par1ModelBase, par2 * par3);
/* 20 */     this.model = (ModelCreepingHorror)this.mainModel;
/* 21 */     this.scale = par3;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderCreepingHorror(CreepingHorror par1EntityCreepingHorror, double par2, double par4, double par6, float par8, float par9) {
/* 27 */     super.doRender((EntityLiving)par1EntityCreepingHorror, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */   
/*    */   public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
/* 32 */     renderCreepingHorror((CreepingHorror)par1EntityLiving, par2, par4, par6, par8, par9);
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
/* 43 */     renderCreepingHorror((CreepingHorror)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderScale(CreepingHorror par1Entity, float par2) {
/* 51 */     GL11.glScalef(this.scale, this.scale, this.scale);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
/* 60 */     preRenderScale((CreepingHorror)par1EntityLiving, par2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 66 */     return texture;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderCreepingHorror.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */