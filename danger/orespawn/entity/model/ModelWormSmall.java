/*    */ package danger.orespawn.entity.model;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.math.MathHelper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelWormSmall
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer head;
/*    */   ModelRenderer body;
/*    */   ModelRenderer tail;
/*    */   
/*    */   public ModelWormSmall() {
/* 20 */     this.textureWidth = 64;
/* 21 */     this.textureHeight = 32;
/*    */     
/* 23 */     this.head = new ModelRenderer(this, 0, 0);
/* 24 */     this.head.addBox(-0.5F, -5.0F, -0.5F, 1, 5, 1);
/* 25 */     this.head.setRotationPoint(0.0F, 14.0F, 0.0F);
/* 26 */     this.head.setTextureSize(64, 32);
/* 27 */     this.head.mirror = true;
/* 28 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/* 29 */     this.body = new ModelRenderer(this, 6, 0);
/* 30 */     this.body.addBox(-0.5F, -5.0F, -0.5F, 1, 5, 1);
/* 31 */     this.body.setRotationPoint(0.0F, 19.0F, 0.0F);
/* 32 */     this.body.setTextureSize(64, 32);
/* 33 */     this.body.mirror = true;
/* 34 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/* 35 */     this.tail = new ModelRenderer(this, 12, 0);
/* 36 */     this.tail.addBox(-0.5F, -5.0F, -0.5F, 1, 5, 1);
/* 37 */     this.tail.setRotationPoint(0.0F, 24.0F, 0.0F);
/* 38 */     this.tail.setTextureSize(64, 32);
/* 39 */     this.tail.mirror = true;
/* 40 */     setRotation(this.tail, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 46 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 47 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*    */     
/* 49 */     float newangle = MathHelper.cos(f2 * 0.55F) * 3.1415927F * 0.15F;
/* 50 */     this.tail.rotateAngleX = newangle;
/* 51 */     float d1 = (float)(Math.sin(newangle) * 5.0D);
/* 52 */     float d2 = (float)(Math.cos(newangle) * 5.0D);
/* 53 */     this.tail.rotationPointZ -= d1;
/* 54 */     newangle = MathHelper.cos(f2 * 0.35F) * 3.1415927F * 0.1F;
/* 55 */     this.tail.rotateAngleZ = newangle;
/* 56 */     float d3 = (float)(Math.cos(newangle) * d2);
/* 57 */     float d4 = (float)(Math.sin(newangle) * d2);
/* 58 */     this.tail.rotationPointX += d4;
/* 59 */     this.body.rotationPointY = (float)(this.tail.rotationPointY - 5.0D + 5.0D - d3);
/*    */     
/* 61 */     newangle = MathHelper.cos(f2 * 0.45F) * 3.1415927F * 0.15F;
/* 62 */     this.body.rotateAngleX = newangle;
/* 63 */     d1 = (float)(Math.sin(newangle) * 5.0D);
/* 64 */     d2 = (float)(Math.cos(newangle) * 5.0D);
/* 65 */     this.body.rotationPointZ -= d1;
/* 66 */     newangle = MathHelper.cos(f2 * 0.25F) * 3.1415927F * 0.1F;
/* 67 */     this.body.rotateAngleZ = newangle;
/* 68 */     d3 = (float)(Math.cos(newangle) * d2);
/* 69 */     d4 = (float)(Math.sin(newangle) * d2);
/* 70 */     this.body.rotationPointX += d4;
/* 71 */     this.head.rotationPointY = (float)(this.body.rotationPointY - 5.0D + 5.0D - d3);
/*    */     
/* 73 */     this.head.rotateAngleX = 0.62F + MathHelper.cos(f2 * 0.65F) * 3.1415927F * 0.15F;
/* 74 */     this.head.rotateAngleZ = MathHelper.cos(f2 * 0.3F) * 3.1415927F * 0.05F;
/*    */     
/* 76 */     this.head.render(f5);
/* 77 */     this.body.render(f5);
/* 78 */     this.tail.render(f5);
/*    */   }
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 83 */     model.rotateAngleX = x;
/* 84 */     model.rotateAngleY = y;
/* 85 */     model.rotateAngleZ = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 90 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\model\ModelWormSmall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */