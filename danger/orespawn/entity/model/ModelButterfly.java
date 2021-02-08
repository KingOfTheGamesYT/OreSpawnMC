/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
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
/*  21 */   private float wingspeed = 1.0F;
/*     */   
/*     */   public ModelButterfly(float f1) {
/*  24 */     this.textureWidth = 64;
/*  25 */     this.textureHeight = 32;
/*  26 */     this.wingspeed = f1;
/*     */     
/*  28 */     this.body = new ModelRenderer(this, 21, 19);
/*  29 */     this.body.addBox(0.0F, 0.0F, -4.0F, 1, 1, 8);
/*  30 */     this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  31 */     this.body.setTextureSize(64, 32);
/*  32 */     this.body.mirror = true;
/*  33 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  34 */     this.leftwing = new ModelRenderer(this, 43, 24);
/*  35 */     this.leftwing.addBox(0.0F, 0.0F, -4.0F, 5, 1, 5);
/*  36 */     this.leftwing.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  37 */     this.leftwing.setTextureSize(64, 32);
/*  38 */     this.leftwing.mirror = true;
/*  39 */     setRotation(this.leftwing, 0.0F, 0.0F, 0.0F);
/*  40 */     this.rightwing = new ModelRenderer(this, 43, 17);
/*  41 */     this.rightwing.addBox(-5.0F, 0.0F, -4.0F, 5, 1, 5);
/*  42 */     this.rightwing.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  43 */     this.rightwing.setTextureSize(64, 32);
/*  44 */     this.rightwing.mirror = true;
/*  45 */     setRotation(this.rightwing, 0.0F, 0.0F, 0.0F);
/*  46 */     this.leftwing2 = new ModelRenderer(this, 0, 0);
/*  47 */     this.leftwing2.addBox(1.0F, 0.0F, -6.0F, 6, 1, 7);
/*  48 */     this.leftwing2.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  49 */     this.leftwing2.setTextureSize(64, 32);
/*  50 */     this.leftwing2.mirror = true;
/*  51 */     setRotation(this.leftwing2, 0.0F, 0.0F, 0.0F);
/*  52 */     this.rightwing2 = new ModelRenderer(this, 29, 0);
/*  53 */     this.rightwing2.addBox(-7.0F, 0.0F, -6.0F, 6, 1, 7);
/*  54 */     this.rightwing2.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  55 */     this.rightwing2.setTextureSize(64, 32);
/*  56 */     this.rightwing2.mirror = true;
/*  57 */     setRotation(this.rightwing2, 0.0F, 0.0F, 0.0F);
/*  58 */     this.leftwing3 = new ModelRenderer(this, 0, 9);
/*  59 */     this.leftwing3.addBox(0.0F, 0.0F, 1.0F, 5, 1, 5);
/*  60 */     this.leftwing3.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  61 */     this.leftwing3.setTextureSize(64, 32);
/*  62 */     this.leftwing3.mirror = true;
/*  63 */     setRotation(this.leftwing3, 0.0F, 0.0F, 0.0F);
/*  64 */     this.rightwing3 = new ModelRenderer(this, 27, 9);
/*  65 */     this.rightwing3.addBox(-5.0F, 0.0F, 1.0F, 5, 1, 5);
/*  66 */     this.rightwing3.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  67 */     this.rightwing3.setTextureSize(64, 32);
/*  68 */     this.rightwing3.mirror = true;
/*  69 */     setRotation(this.rightwing3, 0.0F, 0.0F, 0.0F);
/*  70 */     this.head = new ModelRenderer(this, 21, 11);
/*  71 */     this.head.addBox(0.0F, 0.0F, -6.0F, 1, 1, 1);
/*  72 */     this.head.setRotationPoint(0.0F, 17.0F, 1.0F);
/*  73 */     this.head.setTextureSize(64, 32);
/*  74 */     this.head.mirror = true;
/*  75 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  76 */     this.leftwing4 = new ModelRenderer(this, 2, 24);
/*  77 */     this.leftwing4.addBox(0.0F, 0.0F, 6.0F, 1, 1, 7);
/*  78 */     this.leftwing4.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  79 */     this.leftwing4.setTextureSize(64, 32);
/*  80 */     this.leftwing4.mirror = true;
/*  81 */     setRotation(this.leftwing4, 0.0F, 0.0F, 0.0F);
/*  82 */     this.rightwing4 = new ModelRenderer(this, 2, 16);
/*  83 */     this.rightwing4.addBox(-1.0F, 0.0F, 6.0F, 1, 1, 7);
/*  84 */     this.rightwing4.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  85 */     this.rightwing4.setTextureSize(64, 32);
/*  86 */     this.rightwing4.mirror = true;
/*  87 */     setRotation(this.rightwing4, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  91 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  92 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  94 */     this.head.render(f5);
/*  95 */     this.body.render(f5);
/*     */     
/*  97 */     this.rightwing.rotateAngleZ = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F;
/*  98 */     this.rightwing2.rotateAngleZ = this.rightwing.rotateAngleZ;
/*  99 */     this.rightwing3.rotateAngleZ = this.rightwing.rotateAngleZ;
/* 100 */     this.rightwing4.rotateAngleZ = this.rightwing.rotateAngleZ;
/*     */     
/* 102 */     this.leftwing.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 103 */     this.leftwing2.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 104 */     this.leftwing3.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 105 */     this.leftwing4.rotateAngleZ = -this.rightwing.rotateAngleZ;
/*     */     
/* 107 */     this.leftwing.render(f5);
/* 108 */     this.rightwing.render(f5);
/* 109 */     this.leftwing2.render(f5);
/* 110 */     this.rightwing2.render(f5);
/* 111 */     this.leftwing3.render(f5);
/* 112 */     this.rightwing3.render(f5);
/* 113 */     this.leftwing4.render(f5);
/* 114 */     this.rightwing4.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 119 */     model.rotateAngleX = x;
/* 120 */     model.rotateAngleY = y;
/* 121 */     model.rotateAngleZ = z;
/*     */   }
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 125 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\entity\model\ModelButterfly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */