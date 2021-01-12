/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ 
/*    */ public class ModelMosquito
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer body;
/*    */   ModelRenderer leftwing1;
/*    */   ModelRenderer rightwing1;
/*    */   ModelRenderer leftwing2;
/*    */   ModelRenderer rightwing2;
/*    */   
/*    */   public ModelMosquito() {
/* 19 */     this.textureWidth = 32;
/* 20 */     this.textureHeight = 32;
/*    */     
/* 22 */     this.body = new ModelRenderer(this, 8, 18);
/* 23 */     this.body.addBox(0.0F, 0.0F, -2.0F, 1, 1, 8);
/* 24 */     this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 25 */     this.body.setTextureSize(64, 32);
/* 26 */     this.body.mirror = true;
/* 27 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/* 28 */     this.leftwing1 = new ModelRenderer(this, 16, 13);
/* 29 */     this.leftwing1.addBox(1.0F, 0.0F, -1.0F, 3, 1, 3);
/* 30 */     this.leftwing1.setRotationPoint(1.0F, 17.0F, 0.0F);
/* 31 */     this.leftwing1.setTextureSize(64, 32);
/* 32 */     this.leftwing1.mirror = true;
/* 33 */     setRotation(this.leftwing1, 0.0F, 0.0F, 0.0F);
/* 34 */     this.rightwing1 = new ModelRenderer(this, 2, 13);
/* 35 */     this.rightwing1.addBox(-4.0F, 0.0F, -1.0F, 3, 1, 3);
/* 36 */     this.rightwing1.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 37 */     this.rightwing1.setTextureSize(64, 32);
/* 38 */     this.rightwing1.mirror = true;
/* 39 */     setRotation(this.rightwing1, 0.0F, 0.0F, 0.0F);
/* 40 */     this.leftwing2 = new ModelRenderer(this, 15, 8);
/* 41 */     this.leftwing2.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1);
/* 42 */     this.leftwing2.setRotationPoint(1.0F, 17.0F, 0.0F);
/* 43 */     this.leftwing2.setTextureSize(64, 32);
/* 44 */     this.leftwing2.mirror = true;
/* 45 */     setRotation(this.leftwing2, 0.0F, 0.0F, 0.0F);
/* 46 */     this.rightwing2 = new ModelRenderer(this, 2, 8);
/* 47 */     this.rightwing2.addBox(-5.0F, 0.0F, 0.0F, 5, 1, 1);
/* 48 */     this.rightwing2.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 49 */     this.rightwing2.setTextureSize(64, 32);
/* 50 */     this.rightwing2.mirror = true;
/* 51 */     setRotation(this.rightwing2, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 57 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 58 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*    */     
/* 60 */     this.body.render(f5);
/*    */     
/* 62 */     this.rightwing1.rotateAngleZ = MathHelper.cos(f2 * 3.0F) * 3.1415927F * 0.25F;
/* 63 */     this.rightwing2.rotateAngleZ = this.rightwing1.rotateAngleZ;
/*    */     
/* 65 */     this.leftwing1.rotateAngleZ = -this.rightwing1.rotateAngleZ;
/* 66 */     this.leftwing2.rotateAngleZ = -this.rightwing1.rotateAngleZ;
/*    */     
/* 68 */     this.leftwing1.render(f5);
/* 69 */     this.rightwing1.render(f5);
/* 70 */     this.leftwing2.render(f5);
/* 71 */     this.rightwing2.render(f5);
/*    */   }
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 76 */     model.rotateAngleX = x;
/* 77 */     model.rotateAngleY = y;
/* 78 */     model.rotateAngleZ = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 83 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelMosquito.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */