/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class ModelIsland
/*    */   extends ModelBase
/*    */ {
/* 11 */   private float wingspeed = 1.0F;
/*    */   
/*    */   ModelRenderer Shape1;
/*    */   
/*    */   ModelRenderer Shape2;
/*    */   
/*    */   ModelRenderer Shape3;
/*    */   
/*    */   public ModelIsland(float f) {
/* 20 */     this.textureWidth = 64;
/* 21 */     this.textureHeight = 32;
/*    */     
/* 23 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/* 24 */     this.Shape1.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
/* 25 */     this.Shape1.setRotationPoint(0.0F, 16.0F, 0.0F);
/* 26 */     this.Shape1.setTextureSize(64, 32);
/* 27 */     this.Shape1.mirror = true;
/* 28 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/* 29 */     this.Shape2 = new ModelRenderer(this, 32, 0);
/* 30 */     this.Shape2.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
/* 31 */     this.Shape2.setRotationPoint(0.0F, 16.0F, 0.0F);
/* 32 */     this.Shape2.setTextureSize(64, 32);
/* 33 */     this.Shape2.mirror = true;
/* 34 */     setRotation(this.Shape2, 0.7853982F, 0.7853982F, 0.7853982F);
/* 35 */     this.Shape3 = new ModelRenderer(this, 32, 16);
/* 36 */     this.Shape3.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
/* 37 */     this.Shape3.setRotationPoint(0.0F, 16.0F, 0.0F);
/* 38 */     this.Shape3.setTextureSize(64, 32);
/* 39 */     this.Shape3.mirror = true;
/* 40 */     setRotation(this.Shape3, 0.7853982F, 0.7853982F, 0.7853982F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 47 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 48 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 49 */     float newangle = 0.0F;
/*    */     
/* 51 */     newangle = MathHelper.cos(f2 * 0.05F * this.wingspeed) * 3.1415927F;
/* 52 */     this.Shape1.rotateAngleX = newangle;
/* 53 */     newangle = MathHelper.cos(f2 * 0.051F * this.wingspeed) * 3.1415927F;
/* 54 */     this.Shape1.rotateAngleY = newangle;
/* 55 */     newangle = MathHelper.cos(f2 * 0.052F * this.wingspeed) * 3.1415927F;
/* 56 */     this.Shape1.rotateAngleZ = newangle;
/*    */     
/* 58 */     newangle = MathHelper.cos(f2 * 0.053F * this.wingspeed) * 3.1415927F;
/* 59 */     this.Shape2.rotateAngleX = newangle;
/* 60 */     newangle = MathHelper.cos(f2 * 0.054F * this.wingspeed) * 3.1415927F;
/* 61 */     this.Shape2.rotateAngleY = newangle;
/* 62 */     newangle = MathHelper.cos(f2 * 0.055F * this.wingspeed) * 3.1415927F;
/* 63 */     this.Shape2.rotateAngleZ = newangle;
/*    */     
/* 65 */     newangle = MathHelper.cos(f2 * 0.056F * this.wingspeed) * 3.1415927F;
/* 66 */     this.Shape3.rotateAngleX = newangle;
/* 67 */     newangle = MathHelper.cos(f2 * 0.057F * this.wingspeed) * 3.1415927F;
/* 68 */     this.Shape3.rotateAngleY = newangle;
/* 69 */     newangle = MathHelper.cos(f2 * 0.058F * this.wingspeed) * 3.1415927F;
/* 70 */     this.Shape3.rotateAngleZ = newangle;
/*    */ 
/*    */     
/* 73 */     this.Shape1.render(f5);
/* 74 */     this.Shape2.render(f5);
/* 75 */     this.Shape3.render(f5);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 82 */     model.rotateAngleX = x;
/* 83 */     model.rotateAngleY = y;
/* 84 */     model.rotateAngleZ = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 89 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelIsland.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */