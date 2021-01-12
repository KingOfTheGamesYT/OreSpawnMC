/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBrutalfly
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
/*     */   ModelRenderer leftwing5;
/*     */   ModelRenderer leftwing6;
/*     */   ModelRenderer rightwing5;
/*     */   ModelRenderer rightwing6;
/*  25 */   private float wingspeed = 1.0F;
/*     */ 
/*     */   
/*     */   public ModelBrutalfly(float f1) {
/*  29 */     this.textureWidth = 64;
/*  30 */     this.textureHeight = 32;
/*  31 */     this.wingspeed = f1;
/*     */     
/*  33 */     this.body = new ModelRenderer(this, 21, 19);
/*  34 */     this.body.addBox(0.0F, 0.0F, -4.0F, 1, 1, 8);
/*  35 */     this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  36 */     this.body.setTextureSize(64, 32);
/*  37 */     this.body.mirror = true;
/*  38 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  39 */     this.leftwing = new ModelRenderer(this, 43, 24);
/*  40 */     this.leftwing.addBox(0.0F, 0.0F, -4.0F, 1, 1, 5);
/*  41 */     this.leftwing.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  42 */     this.leftwing.setTextureSize(64, 32);
/*  43 */     this.leftwing.mirror = true;
/*  44 */     setRotation(this.leftwing, 0.0F, 0.0F, 0.0F);
/*  45 */     this.rightwing = new ModelRenderer(this, 43, 17);
/*  46 */     this.rightwing.addBox(-1.0F, 0.0F, -4.0F, 1, 1, 5);
/*  47 */     this.rightwing.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  48 */     this.rightwing.setTextureSize(64, 32);
/*  49 */     this.rightwing.mirror = true;
/*  50 */     setRotation(this.rightwing, 0.0F, 0.0F, 0.0F);
/*  51 */     this.leftwing2 = new ModelRenderer(this, 0, 0);
/*  52 */     this.leftwing2.addBox(1.0F, 0.0F, -6.0F, 6, 1, 7);
/*  53 */     this.leftwing2.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  54 */     this.leftwing2.setTextureSize(64, 32);
/*  55 */     this.leftwing2.mirror = true;
/*  56 */     setRotation(this.leftwing2, 0.0F, 0.0F, 0.0F);
/*  57 */     this.rightwing2 = new ModelRenderer(this, 29, 0);
/*  58 */     this.rightwing2.addBox(-7.0F, 0.0F, -6.0F, 6, 1, 7);
/*  59 */     this.rightwing2.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  60 */     this.rightwing2.setTextureSize(64, 32);
/*  61 */     this.rightwing2.mirror = true;
/*  62 */     setRotation(this.rightwing2, 0.0F, 0.0F, 0.0F);
/*  63 */     this.leftwing3 = new ModelRenderer(this, 0, 9);
/*  64 */     this.leftwing3.addBox(0.0F, 0.0F, 1.0F, 5, 1, 5);
/*  65 */     this.leftwing3.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  66 */     this.leftwing3.setTextureSize(64, 32);
/*  67 */     this.leftwing3.mirror = true;
/*  68 */     setRotation(this.leftwing3, 0.0F, 0.0F, 0.0F);
/*  69 */     this.rightwing3 = new ModelRenderer(this, 27, 9);
/*  70 */     this.rightwing3.addBox(-5.0F, 0.0F, 1.0F, 5, 1, 5);
/*  71 */     this.rightwing3.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  72 */     this.rightwing3.setTextureSize(64, 32);
/*  73 */     this.rightwing3.mirror = true;
/*  74 */     setRotation(this.rightwing3, 0.0F, 0.0F, 0.0F);
/*  75 */     this.head = new ModelRenderer(this, 21, 11);
/*  76 */     this.head.addBox(0.0F, 0.0F, -6.0F, 1, 1, 1);
/*  77 */     this.head.setRotationPoint(0.0F, 17.0F, 1.0F);
/*  78 */     this.head.setTextureSize(64, 32);
/*  79 */     this.head.mirror = true;
/*  80 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  81 */     this.leftwing4 = new ModelRenderer(this, 2, 24);
/*  82 */     this.leftwing4.addBox(0.0F, 0.0F, 6.0F, 2, 1, 7);
/*  83 */     this.leftwing4.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  84 */     this.leftwing4.setTextureSize(64, 32);
/*  85 */     this.leftwing4.mirror = true;
/*  86 */     setRotation(this.leftwing4, 0.0F, 0.0F, 0.0F);
/*  87 */     this.rightwing4 = new ModelRenderer(this, 2, 16);
/*  88 */     this.rightwing4.addBox(-2.0F, 0.0F, 6.0F, 2, 1, 7);
/*  89 */     this.rightwing4.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  90 */     this.rightwing4.setTextureSize(64, 32);
/*  91 */     this.rightwing4.mirror = true;
/*  92 */     setRotation(this.rightwing4, 0.0F, 0.0F, 0.0F);
/*  93 */     this.leftwing5 = new ModelRenderer(this, 21, 16);
/*  94 */     this.leftwing5.addBox(1.0F, 0.0F, -7.0F, 1, 1, 1);
/*  95 */     this.leftwing5.setRotationPoint(1.0F, 17.0F, 0.0F);
/*  96 */     this.leftwing5.setTextureSize(64, 32);
/*  97 */     this.leftwing5.mirror = true;
/*  98 */     setRotation(this.leftwing5, 0.0F, 0.0F, 0.0F);
/*  99 */     this.leftwing6 = new ModelRenderer(this, 50, 10);
/* 100 */     this.leftwing6.addBox(7.0F, 0.0F, -6.0F, 2, 1, 1);
/* 101 */     this.leftwing6.setRotationPoint(1.0F, 17.0F, 0.0F);
/* 102 */     this.leftwing6.setTextureSize(64, 32);
/* 103 */     this.leftwing6.mirror = true;
/* 104 */     setRotation(this.leftwing6, 0.0F, 0.0F, 0.0F);
/* 105 */     this.rightwing5 = new ModelRenderer(this, 27, 16);
/* 106 */     this.rightwing5.addBox(-2.0F, 0.0F, -7.0F, 1, 1, 1);
/* 107 */     this.rightwing5.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 108 */     this.rightwing5.setTextureSize(64, 32);
/* 109 */     this.rightwing5.mirror = true;
/* 110 */     setRotation(this.rightwing5, 0.0F, 0.0F, 0.0F);
/* 111 */     this.rightwing6 = new ModelRenderer(this, 50, 13);
/* 112 */     this.rightwing6.addBox(-9.0F, 0.0F, -6.0F, 2, 1, 1);
/* 113 */     this.rightwing6.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 114 */     this.rightwing6.setTextureSize(64, 32);
/* 115 */     this.rightwing6.mirror = true;
/* 116 */     setRotation(this.rightwing6, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 121 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 122 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 124 */     this.head.render(f5);
/* 125 */     this.body.render(f5);
/*     */     
/* 127 */     this.rightwing.rotateAngleZ = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F;
/* 128 */     this.rightwing2.rotateAngleZ = this.rightwing.rotateAngleZ;
/* 129 */     this.rightwing3.rotateAngleZ = this.rightwing.rotateAngleZ;
/* 130 */     this.rightwing4.rotateAngleZ = this.rightwing.rotateAngleZ;
/* 131 */     this.rightwing5.rotateAngleZ = this.rightwing.rotateAngleZ;
/* 132 */     this.rightwing6.rotateAngleZ = this.rightwing.rotateAngleZ;
/*     */     
/* 134 */     this.leftwing.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 135 */     this.leftwing2.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 136 */     this.leftwing3.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 137 */     this.leftwing4.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 138 */     this.leftwing5.rotateAngleZ = -this.rightwing.rotateAngleZ;
/* 139 */     this.leftwing6.rotateAngleZ = -this.rightwing.rotateAngleZ;
/*     */     
/* 141 */     this.leftwing.render(f5);
/* 142 */     this.rightwing.render(f5);
/* 143 */     this.leftwing2.render(f5);
/* 144 */     this.rightwing2.render(f5);
/* 145 */     this.leftwing3.render(f5);
/* 146 */     this.rightwing3.render(f5);
/* 147 */     this.leftwing4.render(f5);
/* 148 */     this.rightwing4.render(f5);
/* 149 */     this.leftwing5.render(f5);
/* 150 */     this.rightwing5.render(f5);
/* 151 */     this.leftwing6.render(f5);
/* 152 */     this.rightwing6.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 158 */     model.rotateAngleX = x;
/* 159 */     model.rotateAngleY = y;
/* 160 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 165 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelBrutalfly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */