/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ 
/*     */ public class ModelButterfly
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer body;
/*     */   ModelRenderer leftwing;
/*     */   ModelRenderer rightwing;
/*     */   ModelRenderer leftwing2;
/*     */   ModelRenderer rightwing2;
/*     */   ModelRenderer leftwing3;
/*     */   ModelRenderer rightwing3;
/*     */   ModelRenderer head;
/*     */   ModelRenderer leftwing4;
/*     */   ModelRenderer rightwing4;
/*  22 */   private float wingspeed = 1.0F;
/*     */ 
/*     */   
/*     */   public ModelButterfly(float f1) {
/*  26 */     this.textureWidth = 64;
/*  27 */     this.textureHeight = 32;
/*  28 */     this.wingspeed = f1;
/*     */     
/*  30 */     this.body = new ModelRenderer(this, 21, 19);
/*  31 */     this.body.addBox(0.0F, 0.0F, -4.0F, 1, 1, 8);
/*  32 */     this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  33 */     this.body.setTextureSize(64, 32);
/*  34 */     this.body.mirror = true;
/*  35 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  36 */     this.leftwing = new ModelRenderer(this, 43, 24);
/*  37 */     this.leftwing.addBox(0.0F, 0.0F, -4.0F, 5, 1, 5);
/*  38 */     this.leftwing.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  39 */     this.leftwing.setTextureSize(64, 32);
/*  40 */     this.leftwing.mirror = true;
/*  41 */     setRotation(this.leftwing, 0.0F, 0.0F, 0.0F);
/*  42 */     this.rightwing = new ModelRenderer(this, 43, 17);
/*  43 */     this.rightwing.addBox(-5.0F, 0.0F, -4.0F, 5, 1, 5);
/*  44 */     this.rightwing.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  45 */     this.rightwing.setTextureSize(64, 32);
/*  46 */     this.rightwing.mirror = true;
/*  47 */     setRotation(this.rightwing, 0.0F, 0.0F, 0.0F);
/*  48 */     this.leftwing2 = new ModelRenderer(this, 0, 0);
/*  49 */     this.leftwing2.addBox(1.0F, 0.0F, -6.0F, 6, 1, 7);
/*  50 */     this.leftwing2.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  51 */     this.leftwing2.setTextureSize(64, 32);
/*  52 */     this.leftwing2.mirror = true;
/*  53 */     setRotation(this.leftwing2, 0.0F, 0.0F, 0.0F);
/*  54 */     this.rightwing2 = new ModelRenderer(this, 29, 0);
/*  55 */     this.rightwing2.addBox(-7.0F, 0.0F, -6.0F, 6, 1, 7);
/*  56 */     this.rightwing2.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  57 */     this.rightwing2.setTextureSize(64, 32);
/*  58 */     this.rightwing2.mirror = true;
/*  59 */     setRotation(this.rightwing2, 0.0F, 0.0F, 0.0F);
/*  60 */     this.leftwing3 = new ModelRenderer(this, 0, 9);
/*  61 */     this.leftwing3.addBox(0.0F, 0.0F, 1.0F, 5, 1, 5);
/*  62 */     this.leftwing3.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  63 */     this.leftwing3.setTextureSize(64, 32);
/*  64 */     this.leftwing3.mirror = true;
/*  65 */     setRotation(this.leftwing3, 0.0F, 0.0F, 0.0F);
/*  66 */     this.rightwing3 = new ModelRenderer(this, 27, 9);
/*  67 */     this.rightwing3.addBox(-5.0F, 0.0F, 1.0F, 5, 1, 5);
/*  68 */     this.rightwing3.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  69 */     this.rightwing3.setTextureSize(64, 32);
/*  70 */     this.rightwing3.mirror = true;
/*  71 */     setRotation(this.rightwing3, 0.0F, 0.0F, 0.0F);
/*  72 */     this.head = new ModelRenderer(this, 21, 11);
/*  73 */     this.head.addBox(0.0F, 0.0F, -6.0F, 1, 1, 1);
/*  74 */     this.head.setRotationPoint(0.0F, 17.0F, 1.0F);
/*  75 */     this.head.setTextureSize(64, 32);
/*  76 */     this.head.mirror = true;
/*  77 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  78 */     this.leftwing4 = new ModelRenderer(this, 2, 24);
/*  79 */     this.leftwing4.addBox(0.0F, 0.0F, 6.0F, 1, 1, 7);
/*  80 */     this.leftwing4.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  81 */     this.leftwing4.setTextureSize(64, 32);
/*  82 */     this.leftwing4.mirror = true;
/*  83 */     setRotation(this.leftwing4, 0.0F, 0.0F, 0.0F);
/*  84 */     this.rightwing4 = new ModelRenderer(this, 2, 16);
/*  85 */     this.rightwing4.addBox(-1.0F, 0.0F, 6.0F, 1, 1, 7);
/*  86 */     this.rightwing4.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  87 */     this.rightwing4.setTextureSize(64, 32);
/*  88 */     this.rightwing4.mirror = true;
/*  89 */     setRotation(this.rightwing4, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  94 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  95 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  97 */     this.head.render(f5);
/*  98 */     this.body.render(f5);
/*     */     
/* 100 */     this.rightwing.rotateAngleZ = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F;
/* 101 */     this.rightwing2.rotateAngleZ = this.rightwing.rotateAngleZ;
/* 102 */     this.rightwing3.rotateAngleZ = this.rightwing.rotateAngleZ;
/* 103 */     this.rightwing4.rotateAngleZ = this.rightwing.rotateAngleZ;
/*     */     
/* 105 */     this.leftwing.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 106 */     this.leftwing2.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 107 */     this.leftwing3.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 108 */     this.leftwing4.rotateAngleZ = -this.rightwing.rotateAngleZ;
/*     */     
/* 110 */     this.leftwing.render(f5);
/* 111 */     this.rightwing.render(f5);
/* 112 */     this.leftwing2.render(f5);
/* 113 */     this.rightwing2.render(f5);
/* 114 */     this.leftwing3.render(f5);
/* 115 */     this.rightwing3.render(f5);
/* 116 */     this.leftwing4.render(f5);
/* 117 */     this.rightwing4.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 123 */     model.rotateAngleX = x;
/* 124 */     model.rotateAngleY = y;
/* 125 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 130 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespawn\entity\model\ModelButterfly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */