/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ public class ModelAttackSquid
/*     */   extends ModelBase
/*     */ {
/*  12 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer tent1;
/*     */   
/*     */   ModelRenderer tent2;
/*     */   ModelRenderer tent3;
/*     */   ModelRenderer tent4;
/*     */   ModelRenderer tent5;
/*     */   ModelRenderer tent6;
/*     */   ModelRenderer tent7;
/*     */   ModelRenderer body;
/*     */   ModelRenderer tent8;
/*     */   
/*     */   public ModelAttackSquid(float f1) {
/*  26 */     this.wingspeed = f1;
/*     */     
/*  28 */     this.textureWidth = 64;
/*  29 */     this.textureHeight = 32;
/*     */     
/*  31 */     this.tent1 = new ModelRenderer(this, 0, 18);
/*  32 */     this.tent1.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2);
/*  33 */     this.tent1.setRotationPoint(5.0F, 15.0F, -1.0F);
/*  34 */     this.tent1.setTextureSize(64, 32);
/*  35 */     this.tent1.mirror = true;
/*  36 */     setRotation(this.tent1, -0.9250245F, -1.745329F, 0.0F);
/*  37 */     this.tent2 = new ModelRenderer(this, 0, 18);
/*  38 */     this.tent2.addBox(-8.0F, -1.0F, -1.0F, 8, 2, 2);
/*  39 */     this.tent2.setRotationPoint(-2.0F, 15.0F, -3.0F);
/*  40 */     this.tent2.setTextureSize(64, 32);
/*  41 */     this.tent2.mirror = true;
/*  42 */     setRotation(this.tent2, -0.1745329F, -0.6632251F, -0.2443461F);
/*  43 */     this.tent3 = new ModelRenderer(this, 0, 18);
/*  44 */     this.tent3.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2);
/*  45 */     this.tent3.setRotationPoint(1.0F, 15.0F, -4.0F);
/*  46 */     this.tent3.setTextureSize(64, 32);
/*  47 */     this.tent3.mirror = true;
/*  48 */     setRotation(this.tent3, -1.134464F, 0.3316126F, 0.0F);
/*  49 */     this.tent4 = new ModelRenderer(this, 0, 18);
/*  50 */     this.tent4.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2);
/*  51 */     this.tent4.setRotationPoint(-3.0F, 15.0F, -1.0F);
/*  52 */     this.tent4.setTextureSize(64, 32);
/*  53 */     this.tent4.mirror = true;
/*  54 */     setRotation(this.tent4, 0.5585054F, -1.692969F, 0.0F);
/*  55 */     this.tent5 = new ModelRenderer(this, 0, 18);
/*  56 */     this.tent5.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2);
/*  57 */     this.tent5.setRotationPoint(1.0F, 15.0F, 3.0F);
/*  58 */     this.tent5.setTextureSize(64, 32);
/*  59 */     this.tent5.mirror = true;
/*  60 */     setRotation(this.tent5, 0.5410521F, 0.2268928F, 0.0F);
/*  61 */     this.tent6 = new ModelRenderer(this, 0, 18);
/*  62 */     this.tent6.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 8);
/*  63 */     this.tent6.setRotationPoint(-2.0F, 15.0F, 2.0F);
/*  64 */     this.tent6.setTextureSize(64, 32);
/*  65 */     this.tent6.mirror = true;
/*  66 */     setRotation(this.tent6, -0.418879F, -0.6806784F, 0.0F);
/*  67 */     this.tent7 = new ModelRenderer(this, 0, 18);
/*  68 */     this.tent7.addBox(0.0F, -1.0F, -1.0F, 8, 2, 2);
/*  69 */     this.tent7.setRotationPoint(3.0F, 15.0F, 1.0F);
/*  70 */     this.tent7.setTextureSize(64, 32);
/*  71 */     this.tent7.mirror = true;
/*  72 */     setRotation(this.tent7, -0.1919862F, -0.6632251F, 0.418879F);
/*  73 */     this.body = new ModelRenderer(this, 0, 0);
/*  74 */     this.body.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8);
/*  75 */     this.body.setRotationPoint(1.0F, 16.0F, -1.0F);
/*  76 */     this.body.setTextureSize(64, 32);
/*  77 */     this.body.mirror = true;
/*  78 */     setRotation(this.body, -0.1919862F, -0.6806784F, 0.0F);
/*  79 */     this.tent8 = new ModelRenderer(this, 0, 18);
/*  80 */     this.tent8.addBox(-1.0F, -1.0F, -8.0F, 2, 2, 8);
/*  81 */     this.tent8.setRotationPoint(3.0F, 15.0F, -4.0F);
/*  82 */     this.tent8.setTextureSize(64, 32);
/*  83 */     this.tent8.mirror = true;
/*  84 */     setRotation(this.tent8, 0.1919862F, -0.6806784F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  91 */     AttackSquid e = (AttackSquid)entity;
/*  92 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  93 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*  94 */     float newangleA = 0.0F;
/*  95 */     float newangleB = 0.0F;
/*  96 */     float newangle8 = 0.0F;
/*  97 */     float newangle1 = 0.0F;
/*  98 */     float newangle2 = 0.0F;
/*  99 */     float newangle3 = 0.0F;
/* 100 */     float newangle4 = 0.0F;
/* 101 */     float newangle5 = 0.0F;
/* 102 */     float newangle6 = 0.0F;
/* 103 */     float newangle7 = 0.0F;
/* 104 */     float pi4 = 0.7853982F;
/*     */ 
/*     */     
/* 107 */     if (f1 > 0.1D) {
/* 108 */       newangleA = MathHelper.cos(f2 * 0.25F * this.wingspeed) * 3.1415927F * 0.04F * f1;
/* 109 */       newangleB = MathHelper.cos(f2 * 0.39F * this.wingspeed) * 3.1415927F * 0.04F * f1;
/* 110 */       newangle1 = MathHelper.cos(f2 * 1.2F * this.wingspeed) * 3.1415927F * 0.4F * f1;
/* 111 */       newangle2 = MathHelper.cos(f2 * 1.1F * this.wingspeed) * 3.1415927F * 0.4F * f1;
/* 112 */       newangle3 = MathHelper.cos(f2 * 1.0F * this.wingspeed) * 3.1415927F * 0.4F * f1;
/* 113 */       newangle4 = MathHelper.cos(f2 * 1.9F * this.wingspeed) * 3.1415927F * 0.4F * f1;
/* 114 */       newangle5 = MathHelper.cos(f2 * 1.8F * this.wingspeed) * 3.1415927F * 0.4F * f1;
/* 115 */       newangle6 = MathHelper.cos(f2 * 1.7F * this.wingspeed) * 3.1415927F * 0.4F * f1;
/* 116 */       newangle7 = MathHelper.cos(f2 * 1.6F * this.wingspeed) * 3.1415927F * 0.4F * f1;
/* 117 */       newangle8 = MathHelper.cos(f2 * 1.5F * this.wingspeed) * 3.1415927F * 0.4F * f1;
/*     */     } else {
/* 119 */       newangleA = MathHelper.cos(f2 * 0.25F * this.wingspeed) * 3.1415927F * 0.01F;
/* 120 */       newangleB = MathHelper.cos(f2 * 0.39F * this.wingspeed) * 3.1415927F * 0.01F;
/* 121 */       newangle1 = MathHelper.cos(f2 * 1.2F * this.wingspeed) * 3.1415927F * 0.1F;
/* 122 */       newangle2 = MathHelper.cos(f2 * 1.1F * this.wingspeed) * 3.1415927F * 0.1F;
/* 123 */       newangle3 = MathHelper.cos(f2 * 1.0F * this.wingspeed) * 3.1415927F * 0.1F;
/* 124 */       newangle4 = MathHelper.cos(f2 * 1.9F * this.wingspeed) * 3.1415927F * 0.1F;
/* 125 */       newangle5 = MathHelper.cos(f2 * 1.8F * this.wingspeed) * 3.1415927F * 0.1F;
/* 126 */       newangle6 = MathHelper.cos(f2 * 1.7F * this.wingspeed) * 3.1415927F * 0.1F;
/* 127 */       newangle7 = MathHelper.cos(f2 * 1.6F * this.wingspeed) * 3.1415927F * 0.1F;
/* 128 */       newangle8 = MathHelper.cos(f2 * 1.5F * this.wingspeed) * 3.1415927F * 0.1F;
/*     */     } 
/*     */ 
/*     */     
/* 132 */     this.tent1.rotateAngleX = newangle1 - 1.03F;
/* 133 */     this.tent7.rotateAngleZ = newangle2 + 0.37F;
/* 134 */     this.tent5.rotateAngleX = newangle3 + 0.6F;
/* 135 */     this.tent6.rotateAngleX = newangle4 - 0.48F;
/* 136 */     this.tent4.rotateAngleX = newangle5 + 0.63F;
/* 137 */     this.tent2.rotateAngleZ = newangle6 - 0.26F;
/* 138 */     this.tent3.rotateAngleX = newangle7 - 1.03F;
/* 139 */     this.tent8.rotateAngleX = newangle8 + 0.43F;
/*     */     
/* 141 */     this.body.rotateAngleX = newangleA;
/* 142 */     this.body.rotateAngleZ = newangleB;
/* 143 */     newangleA = (float)Math.toRadians(f3) * 0.75F;
/* 144 */     this.body.rotateAngleY = newangleA;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     this.tent1.render(f5);
/* 178 */     this.tent2.render(f5);
/* 179 */     this.tent3.render(f5);
/* 180 */     this.tent4.render(f5);
/* 181 */     this.tent5.render(f5);
/* 182 */     this.tent6.render(f5);
/* 183 */     this.tent7.render(f5);
/* 184 */     this.body.render(f5);
/* 185 */     this.tent8.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 191 */     model.rotateAngleX = x;
/* 192 */     model.rotateAngleY = y;
/* 193 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 198 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelAttackSquid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */