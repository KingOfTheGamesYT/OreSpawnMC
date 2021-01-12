/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelIrukandji
/*     */   extends ModelBase
/*     */ {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer body;
/*     */   
/*     */   ModelRenderer t11;
/*     */   ModelRenderer t12;
/*     */   ModelRenderer t21;
/*     */   ModelRenderer t22;
/*     */   ModelRenderer t31;
/*     */   ModelRenderer t32;
/*     */   ModelRenderer t41;
/*     */   ModelRenderer t42;
/*     */   
/*     */   public ModelIrukandji(float f1) {
/*  25 */     this.wingspeed = f1;
/*     */     
/*  27 */     this.textureWidth = 64;
/*  28 */     this.textureHeight = 32;
/*     */     
/*  30 */     this.body = new ModelRenderer(this, 0, 9);
/*  31 */     this.body.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4);
/*  32 */     this.body.setRotationPoint(0.0F, 6.0F, 0.0F);
/*  33 */     this.body.setTextureSize(64, 32);
/*  34 */     this.body.mirror = true;
/*  35 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  36 */     this.t11 = new ModelRenderer(this, 25, 0);
/*  37 */     this.t11.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
/*  38 */     this.t11.setRotationPoint(1.0F, 10.0F, -2.0F);
/*  39 */     this.t11.setTextureSize(64, 32);
/*  40 */     this.t11.mirror = true;
/*  41 */     setRotation(this.t11, 0.0F, 0.0F, 0.0F);
/*  42 */     this.t12 = new ModelRenderer(this, 5, 0);
/*  43 */     this.t12.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
/*  44 */     this.t12.setRotationPoint(1.0F, 17.0F, -2.0F);
/*  45 */     this.t12.setTextureSize(64, 32);
/*  46 */     this.t12.mirror = true;
/*  47 */     setRotation(this.t12, 0.0F, 0.0F, 0.0F);
/*  48 */     this.t21 = new ModelRenderer(this, 0, 0);
/*  49 */     this.t21.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
/*  50 */     this.t21.setRotationPoint(-2.0F, 10.0F, -2.0F);
/*  51 */     this.t21.setTextureSize(64, 32);
/*  52 */     this.t21.mirror = true;
/*  53 */     setRotation(this.t21, 0.0F, 0.0F, 0.0F);
/*  54 */     this.t22 = new ModelRenderer(this, 20, 0);
/*  55 */     this.t22.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
/*  56 */     this.t22.setRotationPoint(-2.0F, 17.0F, -2.0F);
/*  57 */     this.t22.setTextureSize(64, 32);
/*  58 */     this.t22.mirror = true;
/*  59 */     setRotation(this.t22, 0.0F, 0.0F, 0.0F);
/*  60 */     this.t31 = new ModelRenderer(this, 30, 0);
/*  61 */     this.t31.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
/*  62 */     this.t31.setRotationPoint(1.0F, 10.0F, 1.0F);
/*  63 */     this.t31.setTextureSize(64, 32);
/*  64 */     this.t31.mirror = true;
/*  65 */     setRotation(this.t31, 0.0F, 0.0F, 0.0F);
/*  66 */     this.t32 = new ModelRenderer(this, 10, 0);
/*  67 */     this.t32.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
/*  68 */     this.t32.setRotationPoint(1.0F, 17.0F, 1.0F);
/*  69 */     this.t32.setTextureSize(64, 32);
/*  70 */     this.t32.mirror = true;
/*  71 */     setRotation(this.t32, 0.0F, 0.0F, 0.0F);
/*  72 */     this.t41 = new ModelRenderer(this, 35, 0);
/*  73 */     this.t41.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
/*  74 */     this.t41.setRotationPoint(-2.0F, 10.0F, 1.0F);
/*  75 */     this.t41.setTextureSize(64, 32);
/*  76 */     this.t41.mirror = true;
/*  77 */     setRotation(this.t41, 0.0F, 0.0F, 0.0F);
/*  78 */     this.t42 = new ModelRenderer(this, 15, 0);
/*  79 */     this.t42.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
/*  80 */     this.t42.setRotationPoint(-2.0F, 17.0F, 1.0F);
/*  81 */     this.t42.setTextureSize(64, 32);
/*  82 */     this.t42.mirror = true;
/*  83 */     setRotation(this.t42, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  90 */     Irukandji e = (Irukandji)entity;
/*  91 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  92 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*  93 */     float newangle = 0.0F;
/*     */ 
/*     */     
/*  96 */     newangle = MathHelper.cos(f2 * 0.55F) * 3.1415927F * 0.15F;
/*  97 */     this.t11.rotateAngleX = newangle;
/*  98 */     float d1 = (float)(Math.sin(newangle) * 7.0D);
/*  99 */     float d2 = (float)(Math.cos(newangle) * 7.0D);
/* 100 */     this.t11.rotationPointZ += d1;
/* 101 */     newangle = MathHelper.cos(f2 * 0.35F) * 3.1415927F * 0.1F;
/* 102 */     this.t11.rotateAngleZ = newangle;
/* 103 */     float d3 = (float)(Math.cos(newangle) * d2);
/* 104 */     float d4 = (float)(Math.sin(newangle) * d2);
/* 105 */     this.t11.rotationPointX -= d4;
/* 106 */     this.t11.rotationPointY += d3;
/* 107 */     newangle = MathHelper.cos(f2 * 0.45F) * 3.1415927F * 0.15F;
/* 108 */     this.t12.rotateAngleX = newangle;
/* 109 */     newangle = MathHelper.cos(f2 * 0.25F) * 3.1415927F * 0.1F;
/* 110 */     this.t12.rotateAngleZ = newangle;
/*     */ 
/*     */     
/* 113 */     newangle = MathHelper.cos(f2 * 0.65F) * 3.1415927F * 0.15F;
/* 114 */     this.t21.rotateAngleX = newangle;
/* 115 */     d1 = (float)(Math.sin(newangle) * 7.0D);
/* 116 */     d2 = (float)(Math.cos(newangle) * 7.0D);
/* 117 */     this.t21.rotationPointZ += d1;
/* 118 */     newangle = MathHelper.cos(f2 * 0.45F) * 3.1415927F * 0.1F;
/* 119 */     this.t21.rotateAngleZ = newangle;
/* 120 */     d3 = (float)(Math.cos(newangle) * d2);
/* 121 */     d4 = (float)(Math.sin(newangle) * d2);
/* 122 */     this.t21.rotationPointX -= d4;
/* 123 */     this.t21.rotationPointY += d3;
/* 124 */     newangle = MathHelper.cos(f2 * 0.55F) * 3.1415927F * 0.15F;
/* 125 */     this.t22.rotateAngleX = newangle;
/* 126 */     newangle = MathHelper.cos(f2 * 0.35F) * 3.1415927F * 0.1F;
/* 127 */     this.t22.rotateAngleZ = newangle;
/*     */ 
/*     */     
/* 130 */     newangle = MathHelper.cos(f2 * 0.5F) * 3.1415927F * 0.15F;
/* 131 */     this.t31.rotateAngleX = newangle;
/* 132 */     d1 = (float)(Math.sin(newangle) * 7.0D);
/* 133 */     d2 = (float)(Math.cos(newangle) * 7.0D);
/* 134 */     this.t31.rotationPointZ += d1;
/* 135 */     newangle = MathHelper.cos(f2 * 0.3F) * 3.1415927F * 0.1F;
/* 136 */     this.t31.rotateAngleZ = newangle;
/* 137 */     d3 = (float)(Math.cos(newangle) * d2);
/* 138 */     d4 = (float)(Math.sin(newangle) * d2);
/* 139 */     this.t31.rotationPointX -= d4;
/* 140 */     this.t31.rotationPointY += d3;
/* 141 */     newangle = MathHelper.cos(f2 * 0.4F) * 3.1415927F * 0.15F;
/* 142 */     this.t32.rotateAngleX = newangle;
/* 143 */     newangle = MathHelper.cos(f2 * 0.2F) * 3.1415927F * 0.1F;
/* 144 */     this.t32.rotateAngleZ = newangle;
/*     */ 
/*     */     
/* 147 */     newangle = MathHelper.cos(f2 * 0.57F) * 3.1415927F * 0.15F;
/* 148 */     this.t41.rotateAngleX = newangle;
/* 149 */     d1 = (float)(Math.sin(newangle) * 7.0D);
/* 150 */     d2 = (float)(Math.cos(newangle) * 7.0D);
/* 151 */     this.t41.rotationPointZ += d1;
/* 152 */     newangle = MathHelper.cos(f2 * 0.37F) * 3.1415927F * 0.1F;
/* 153 */     this.t41.rotateAngleZ = newangle;
/* 154 */     d3 = (float)(Math.cos(newangle) * d2);
/* 155 */     d4 = (float)(Math.sin(newangle) * d2);
/* 156 */     this.t41.rotationPointX -= d4;
/* 157 */     this.t41.rotationPointY += d3;
/* 158 */     newangle = MathHelper.cos(f2 * 0.48F) * 3.1415927F * 0.15F;
/* 159 */     this.t42.rotateAngleX = newangle;
/* 160 */     newangle = MathHelper.cos(f2 * 0.29F) * 3.1415927F * 0.1F;
/* 161 */     this.t42.rotateAngleZ = newangle;
/*     */ 
/*     */     
/* 164 */     this.body.render(f5);
/* 165 */     this.t11.render(f5);
/* 166 */     this.t12.render(f5);
/* 167 */     this.t21.render(f5);
/* 168 */     this.t22.render(f5);
/* 169 */     this.t31.render(f5);
/* 170 */     this.t32.render(f5);
/* 171 */     this.t41.render(f5);
/* 172 */     this.t42.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 178 */     model.rotateAngleX = x;
/* 179 */     model.rotateAngleY = y;
/* 180 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 185 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelIrukandji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */