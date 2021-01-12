/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ public class ModelElevator
/*    */   extends ModelBase
/*    */ {
/* 11 */   private float wingspeed = 1.0F;
/*    */   
/*    */   ModelRenderer Shape1;
/*    */   
/*    */   ModelRenderer Shape2;
/*    */   
/*    */   ModelRenderer Shape3;
/*    */   ModelRenderer Shape4;
/*    */   ModelRenderer Shape5;
/*    */   
/*    */   public ModelElevator() {
/* 22 */     this.textureWidth = 64;
/* 23 */     this.textureHeight = 64;
/*    */     
/* 25 */     this.Shape2 = new ModelRenderer(this, 0, 18);
/*    */     
/* 27 */     this.Shape2.addBox(-3.0F, 0.0F, -9.0F, 6, 1, 1);
/* 28 */     this.Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 29 */     this.Shape2.setTextureSize(64, 64);
/* 30 */     this.Shape2.mirror = true;
/* 31 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/* 32 */     this.Shape3 = new ModelRenderer(this, 0, 21);
/* 33 */     this.Shape3.addBox(-1.0F, 0.0F, -10.0F, 2, 1, 1);
/* 34 */     this.Shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 35 */     this.Shape3.setTextureSize(64, 64);
/* 36 */     this.Shape3.mirror = true;
/* 37 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/* 38 */     this.Shape4 = new ModelRenderer(this, 17, 18);
/* 39 */     this.Shape4.addBox(-3.0F, 0.0F, 8.0F, 6, 1, 1);
/* 40 */     this.Shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 41 */     this.Shape4.setTextureSize(64, 64);
/* 42 */     this.Shape4.mirror = true;
/* 43 */     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
/* 44 */     this.Shape5 = new ModelRenderer(this, 17, 21);
/* 45 */     this.Shape5.addBox(-1.0F, 0.0F, 9.0F, 2, 1, 1);
/* 46 */     this.Shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 47 */     this.Shape5.setTextureSize(64, 64);
/* 48 */     this.Shape5.mirror = true;
/* 49 */     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
/* 50 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/* 51 */     this.Shape1.addBox(-4.0F, 0.0F, -8.0F, 8, 1, 16);
/* 52 */     this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 53 */     this.Shape1.setTextureSize(64, 64);
/* 54 */     this.Shape1.mirror = true;
/* 55 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 62 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 63 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*    */     
/* 65 */     this.Shape1.render(f5);
/* 66 */     this.Shape2.render(f5);
/* 67 */     this.Shape3.render(f5);
/* 68 */     this.Shape4.render(f5);
/* 69 */     this.Shape5.render(f5);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 75 */     model.rotateAngleX = x;
/* 76 */     model.rotateAngleY = y;
/* 77 */     model.rotateAngleZ = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 82 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelElevator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */