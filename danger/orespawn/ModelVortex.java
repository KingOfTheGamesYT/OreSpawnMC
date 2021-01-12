/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelVortex
/*    */   extends ModelBase
/*    */ {
/* 13 */   float wingspeed = 1.0F;
/*    */   
/*    */   ModelRenderer Shape1;
/*    */   
/*    */   public ModelVortex(float f1) {
/* 18 */     this.wingspeed = f1;
/*    */     
/* 20 */     this.textureWidth = 256;
/* 21 */     this.textureHeight = 128;
/*    */     
/* 23 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/* 24 */     this.Shape1.addBox(-64.0F, -64.0F, 0.0F, 128, 64, 0);
/* 25 */     this.Shape1.setRotationPoint(0.0F, 22.0F, 0.0F);
/* 26 */     this.Shape1.setTextureSize(256, 128);
/* 27 */     this.Shape1.mirror = true;
/* 28 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 33 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 34 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 35 */     this.Shape1.render(f5);
/*    */   }
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 40 */     model.rotateAngleX = x;
/* 41 */     model.rotateAngleY = y;
/* 42 */     model.rotateAngleZ = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 47 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelVortex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */