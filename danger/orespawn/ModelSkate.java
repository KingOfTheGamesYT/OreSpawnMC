/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class ModelSkate
/*    */   extends ModelBase
/*    */ {
/* 11 */   private float wingspeed = 1.0F;
/*    */   
/*    */   ModelRenderer body;
/*    */   
/*    */   ModelRenderer tail1;
/*    */   ModelRenderer Shape1;
/*    */   
/*    */   public ModelSkate(float f1) {
/* 19 */     this.wingspeed = f1;
/*    */     
/* 21 */     this.textureWidth = 64;
/* 22 */     this.textureHeight = 32;
/*    */     
/* 24 */     this.body = new ModelRenderer(this, 0, 13);
/* 25 */     this.body.addBox(-3.0F, 0.0F, -3.0F, 6, 1, 6);
/* 26 */     this.body.setRotationPoint(0.0F, 22.0F, 0.0F);
/* 27 */     this.body.setTextureSize(64, 32);
/* 28 */     this.body.mirror = true;
/* 29 */     setRotation(this.body, 0.0F, 0.7853982F, 0.0F);
/* 30 */     this.tail1 = new ModelRenderer(this, 0, 0);
/* 31 */     this.tail1.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 11);
/* 32 */     this.tail1.setRotationPoint(0.0F, 22.0F, 3.0F);
/* 33 */     this.tail1.setTextureSize(64, 32);
/* 34 */     this.tail1.mirror = true;
/* 35 */     setRotation(this.tail1, 0.0F, 0.0F, 0.0F);
/* 36 */     this.Shape1 = new ModelRenderer(this, 0, 21);
/* 37 */     this.Shape1.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4);
/* 38 */     this.Shape1.setRotationPoint(0.0F, 22.0F, 5.0F);
/* 39 */     this.Shape1.setTextureSize(64, 32);
/* 40 */     this.Shape1.mirror = true;
/* 41 */     setRotation(this.Shape1, 0.7853982F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 48 */     Skate e = (Skate)entity;
/* 49 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 50 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 51 */     float newangle = 0.0F;
/*    */     
/* 53 */     if (f1 > 0.1D) {
/* 54 */       newangle = MathHelper.cos(f2 * 1.2F) * 3.1415927F * 0.15F * f1;
/*    */     } else {
/* 56 */       newangle = MathHelper.cos(f2 * 0.4F) * 3.1415927F * 0.05F;
/*    */     } 
/* 58 */     this.Shape1.rotateAngleX = 0.785F + newangle;
/*    */     
/* 60 */     this.body.render(f5);
/* 61 */     this.tail1.render(f5);
/* 62 */     this.Shape1.render(f5);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 68 */     model.rotateAngleX = x;
/* 69 */     model.rotateAngleY = y;
/* 70 */     model.rotateAngleZ = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 75 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelSkate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */