/*    */ package danger.orespawn.entity.model;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.math.MathHelper;
/*    */ 
/*    */ public class ModelMosquito
/*    */   extends ModelBase {
/*    */   ModelRenderer body;
/*    */   ModelRenderer leftwing1;
/*    */   ModelRenderer rightwing1;
/*    */   ModelRenderer leftwing2;
/*    */   ModelRenderer rightwing2;
/*    */   
/*    */   public ModelMosquito() {
/* 17 */     this.textureWidth = 32;
/* 18 */     this.textureHeight = 32;
/*    */     
/* 20 */     this.body = new ModelRenderer(this, 8, 18);
/* 21 */     this.body.addBox(0.0F, 0.0F, -2.0F, 1, 1, 8);
/* 22 */     this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 23 */     this.body.setTextureSize(64, 32);
/* 24 */     this.body.mirror = true;
/* 25 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/* 26 */     this.leftwing1 = new ModelRenderer(this, 16, 13);
/* 27 */     this.leftwing1.addBox(1.0F, 0.0F, -1.0F, 3, 1, 3);
/* 28 */     this.leftwing1.setRotationPoint(1.0F, 17.0F, 0.0F);
/* 29 */     this.leftwing1.setTextureSize(64, 32);
/* 30 */     this.leftwing1.mirror = true;
/* 31 */     setRotation(this.leftwing1, 0.0F, 0.0F, 0.0F);
/* 32 */     this.rightwing1 = new ModelRenderer(this, 2, 13);
/* 33 */     this.rightwing1.addBox(-4.0F, 0.0F, -1.0F, 3, 1, 3);
/* 34 */     this.rightwing1.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 35 */     this.rightwing1.setTextureSize(64, 32);
/* 36 */     this.rightwing1.mirror = true;
/* 37 */     setRotation(this.rightwing1, 0.0F, 0.0F, 0.0F);
/* 38 */     this.leftwing2 = new ModelRenderer(this, 15, 8);
/* 39 */     this.leftwing2.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1);
/* 40 */     this.leftwing2.setRotationPoint(1.0F, 17.0F, 0.0F);
/* 41 */     this.leftwing2.setTextureSize(64, 32);
/* 42 */     this.leftwing2.mirror = true;
/* 43 */     setRotation(this.leftwing2, 0.0F, 0.0F, 0.0F);
/* 44 */     this.rightwing2 = new ModelRenderer(this, 2, 8);
/* 45 */     this.rightwing2.addBox(-5.0F, 0.0F, 0.0F, 5, 1, 1);
/* 46 */     this.rightwing2.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 47 */     this.rightwing2.setTextureSize(64, 32);
/* 48 */     this.rightwing2.mirror = true;
/* 49 */     setRotation(this.rightwing2, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 54 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 55 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*    */     
/* 57 */     this.body.render(f5);
/*    */     
/* 59 */     this.rightwing1.rotateAngleZ = MathHelper.cos(f2 * 3.0F) * 3.1415927F * 0.25F;
/* 60 */     this.rightwing2.rotateAngleZ = this.rightwing1.rotateAngleZ;
/*    */     
/* 62 */     this.leftwing1.rotateAngleZ = -this.rightwing1.rotateAngleZ;
/* 63 */     this.leftwing2.rotateAngleZ = -this.rightwing1.rotateAngleZ;
/*    */     
/* 65 */     this.leftwing1.render(f5);
/* 66 */     this.rightwing1.render(f5);
/* 67 */     this.leftwing2.render(f5);
/* 68 */     this.rightwing2.render(f5);
/*    */   }
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 72 */     model.rotateAngleX = x;
/* 73 */     model.rotateAngleY = y;
/* 74 */     model.rotateAngleZ = z;
/*    */   }
/*    */   
/*    */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 78 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\model\ModelMosquito.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */