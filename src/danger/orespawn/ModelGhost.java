/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelGhost
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer HeadAndBody;
/*    */   ModelRenderer LArm;
/*    */   ModelRenderer RArm;
/*    */   
/*    */   public ModelGhost() {
/* 19 */     this.textureWidth = 64;
/* 20 */     this.textureHeight = 64;
/*    */     
/* 22 */     this.HeadAndBody = new ModelRenderer(this, 0, 0);
/* 23 */     this.HeadAndBody.addBox(-3.0F, 0.0F, -3.0F, 6, 21, 6);
/* 24 */     this.HeadAndBody.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 25 */     this.HeadAndBody.setTextureSize(64, 64);
/* 26 */     this.HeadAndBody.mirror = true;
/* 27 */     setRotation(this.HeadAndBody, 0.0F, 0.0F, 0.0F);
/* 28 */     this.LArm = new ModelRenderer(this, 34, 0);
/* 29 */     this.LArm.addBox(-1.0F, -1.0F, -1.0F, 2, 11, 2);
/* 30 */     this.LArm.setRotationPoint(3.0F, 6.0F, 0.0F);
/* 31 */     this.LArm.setTextureSize(64, 64);
/* 32 */     this.LArm.mirror = true;
/* 33 */     setRotation(this.LArm, 0.0F, 0.0F, -0.3316126F);
/* 34 */     this.RArm = new ModelRenderer(this, 25, 0);
/* 35 */     this.RArm.addBox(-1.0F, -1.0F, -1.0F, 2, 11, 2);
/* 36 */     this.RArm.setRotationPoint(-3.0F, 6.0F, 0.0F);
/* 37 */     this.RArm.setTextureSize(64, 64);
/* 38 */     this.RArm.mirror = true;
/* 39 */     setRotation(this.RArm, 0.0F, 0.0F, 0.3316126F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 44 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 45 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*    */     
/* 47 */     this.LArm.rotateAngleZ = -0.33F + MathHelper.cos(f2 * 0.3F) * 3.1415927F * 0.05F;
/* 48 */     this.RArm.rotateAngleZ = 0.33F + MathHelper.cos(f2 * 0.32F) * 3.1415927F * 0.05F;
/* 49 */     this.LArm.rotateAngleX = -0.33F + MathHelper.cos(f2 * 0.34F) * 3.1415927F * 0.05F;
/* 50 */     this.RArm.rotateAngleX = 0.33F + MathHelper.cos(f2 * 0.36F) * 3.1415927F * 0.05F;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 55 */     GL11.glPushMatrix();
/* 56 */     GL11.glEnable(2977);
/* 57 */     GL11.glEnable(3042);
/* 58 */     GL11.glBlendFunc(770, 771);
/* 59 */     GL11.glColor4f(0.75F, 0.75F, 0.75F, 0.25F);
/*    */     
/* 61 */     this.HeadAndBody.render(f5);
/* 62 */     this.LArm.render(f5);
/* 63 */     this.RArm.render(f5);
/*    */     
/* 65 */     GL11.glDisable(3042);
/* 66 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 71 */     model.rotateAngleX = x;
/* 72 */     model.rotateAngleY = y;
/* 73 */     model.rotateAngleZ = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 78 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelGhost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */