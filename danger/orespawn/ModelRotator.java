/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelRotator
/*    */   extends ModelBase
/*    */ {
/* 13 */   float wingspeed = 1.0F;
/*    */   
/*    */   ModelRenderer Shape1;
/*    */   ModelRenderer Shape2;
/*    */   ModelRenderer Shape3;
/*    */   
/*    */   public ModelRotator(float f1) {
/* 20 */     this.wingspeed = f1;
/*    */     
/* 22 */     this.textureWidth = 64;
/* 23 */     this.textureHeight = 32;
/*    */     
/* 25 */     this.Shape1 = new ModelRenderer(this, 0, 12);
/* 26 */     this.Shape1.addBox(-2.0F, 3.9F, 0.0F, 4, 1, 1);
/* 27 */     this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 28 */     this.Shape1.setTextureSize(64, 32);
/* 29 */     this.Shape1.mirror = true;
/* 30 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/* 31 */     this.Shape2 = new ModelRenderer(this, 0, 7);
/* 32 */     this.Shape2.addBox(-4.0F, 7.6F, 0.0F, 8, 2, 2);
/* 33 */     this.Shape2.setRotationPoint(0.0F, 0.0F, -0.5F);
/* 34 */     this.Shape2.setTextureSize(64, 32);
/* 35 */     this.Shape2.mirror = true;
/* 36 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/* 37 */     this.Shape3 = new ModelRenderer(this, 0, 0);
/* 38 */     this.Shape3.addBox(-7.0F, 13.7F, 0.0F, 14, 3, 3);
/* 39 */     this.Shape3.setRotationPoint(0.0F, 0.0F, -1.0F);
/* 40 */     this.Shape3.setTextureSize(64, 32);
/* 41 */     this.Shape3.mirror = true;
/* 42 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 47 */     Rotator r = (Rotator)entity;
/* 48 */     RenderInfo ri = null;
/* 49 */     float newangle = 0.0F;
/*    */     
/* 51 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 52 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*    */     
/* 54 */     ri = r.getRenderInfo();
/* 55 */     GL11.glRotatef(ri.rf1, 1.0F, 0.0F, 0.0F); int i;
/* 56 */     for (i = 0; i < 8; i++) {
/* 57 */       this.Shape1.rotateAngleZ = newangle;
/* 58 */       this.Shape1.render(f5);
/* 59 */       newangle += 0.7853982F;
/*    */     } 
/* 61 */     GL11.glRotatef(-ri.rf1, 1.0F, 0.0F, 0.0F);
/* 62 */     newangle = 0.0F;
/* 63 */     GL11.glRotatef(ri.rf1, 0.0F, 1.0F, 0.0F);
/* 64 */     for (i = 0; i < 8; i++) {
/* 65 */       this.Shape2.rotateAngleZ = newangle;
/* 66 */       this.Shape2.render(f5);
/* 67 */       newangle += 0.7853982F;
/*    */     } 
/* 69 */     GL11.glRotatef(-ri.rf1, 0.0F, 1.0F, 0.0F);
/* 70 */     newangle = 0.0F;
/* 71 */     GL11.glRotatef(ri.rf1, 0.0F, 0.0F, 1.0F);
/* 72 */     for (i = 0; i < 8; i++) {
/* 73 */       this.Shape3.rotateAngleZ = newangle;
/* 74 */       this.Shape3.render(f5);
/* 75 */       newangle += 0.7853982F;
/*    */     } 
/* 77 */     GL11.glRotatef(-ri.rf1, 0.0F, 0.0F, 1.0F);
/*    */     
/* 79 */     ri.rf1 += 2.0F;
/* 80 */     if (ri.rf1 > 359.0D) ri.rf1 = 0.0F;
/*    */     
/* 82 */     r.setRenderInfo(ri);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 88 */     model.rotateAngleX = x;
/* 89 */     model.rotateAngleY = y;
/* 90 */     model.rotateAngleZ = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 95 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelRotator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */