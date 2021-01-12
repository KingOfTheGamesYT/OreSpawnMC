/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ public class ModelBasilisk
/*     */   extends ModelBase
/*     */ {
/*  12 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer body3;
/*     */   
/*     */   ModelRenderer body2;
/*     */   ModelRenderer body1;
/*     */   ModelRenderer body4;
/*     */   ModelRenderer body5;
/*     */   ModelRenderer body6;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer tail3;
/*     */   ModelRenderer tail4;
/*     */   ModelRenderer neck2;
/*     */   ModelRenderer neck1;
/*     */   ModelRenderer head;
/*     */   ModelRenderer rog_1;
/*     */   ModelRenderer rog_2;
/*     */   ModelRenderer rog_3;
/*     */   ModelRenderer rog_4;
/*     */   ModelRenderer rog_5;
/*     */   ModelRenderer rog_6;
/*     */   ModelRenderer snout;
/*     */   ModelRenderer jaw;
/*     */   
/*     */   public ModelBasilisk(float f1) {
/*  38 */     this.wingspeed = f1;
/*     */     
/*  40 */     this.textureWidth = 256;
/*  41 */     this.textureHeight = 64;
/*     */     
/*  43 */     this.body3 = new ModelRenderer(this, 0, 32);
/*  44 */     this.body3.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
/*  45 */     this.body3.setRotationPoint(-8.0F, 8.0F, 0.0F);
/*  46 */     this.body3.setTextureSize(256, 64);
/*  47 */     this.body3.mirror = true;
/*  48 */     setRotation(this.body3, 0.0F, 0.0F, 0.0F);
/*  49 */     this.body2 = new ModelRenderer(this, 0, 32);
/*  50 */     this.body2.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
/*  51 */     this.body2.setRotationPoint(-8.0F, 4.0F, -10.0F);
/*  52 */     this.body2.setTextureSize(256, 64);
/*  53 */     this.body2.mirror = true;
/*  54 */     setRotation(this.body2, -0.2974289F, 0.0F, 0.0F);
/*  55 */     this.body1 = new ModelRenderer(this, 0, 32);
/*  56 */     this.body1.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
/*  57 */     this.body1.setRotationPoint(-8.0F, 2.0F, -25.0F);
/*  58 */     this.body1.setTextureSize(256, 64);
/*  59 */     this.body1.mirror = true;
/*  60 */     setRotation(this.body1, -0.1487144F, 0.0F, 0.0F);
/*  61 */     this.body4 = new ModelRenderer(this, 0, 32);
/*  62 */     this.body4.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
/*  63 */     this.body4.setRotationPoint(-8.0F, 8.0F, 13.0F);
/*  64 */     this.body4.setTextureSize(256, 64);
/*  65 */     this.body4.mirror = true;
/*  66 */     setRotation(this.body4, 0.1487144F, 0.0F, 0.0F);
/*  67 */     this.body5 = new ModelRenderer(this, 0, 32);
/*  68 */     this.body5.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
/*  69 */     this.body5.setRotationPoint(-8.0F, 5.8F, 28.8F);
/*  70 */     this.body5.setTextureSize(256, 64);
/*  71 */     this.body5.mirror = true;
/*  72 */     setRotation(this.body5, 0.0F, 0.0F, 0.0F);
/*  73 */     this.body6 = new ModelRenderer(this, 148, 4);
/*  74 */     this.body6.addBox(0.0F, 0.0F, 0.0F, 15, 15, 17);
/*  75 */     this.body6.setRotationPoint(-7.5F, 6.166667F, 44.0F);
/*  76 */     this.body6.setTextureSize(256, 64);
/*  77 */     this.body6.mirror = true;
/*  78 */     setRotation(this.body6, -0.1115358F, 0.0F, 0.0F);
/*  79 */     this.tail1 = new ModelRenderer(this, 140, 36);
/*  80 */     this.tail1.addBox(0.0F, 0.0F, 0.0F, 13, 13, 15);
/*  81 */     this.tail1.setRotationPoint(-6.5F, 9.0F, 58.0F);
/*  82 */     this.tail1.setTextureSize(256, 64);
/*  83 */     this.tail1.mirror = true;
/*  84 */     setRotation(this.tail1, 0.1115358F, 0.0F, 0.0F);
/*  85 */     this.tail2 = new ModelRenderer(this, 64, 41);
/*  86 */     this.tail2.addBox(0.0F, 0.0F, 0.0F, 10, 10, 13);
/*  87 */     this.tail2.setRotationPoint(-5.0F, 10.0F, 70.0F);
/*  88 */     this.tail2.setTextureSize(256, 64);
/*  89 */     this.tail2.mirror = true;
/*  90 */     setRotation(this.tail2, 0.4089647F, 0.0F, 0.0F);
/*  91 */     this.tail3 = new ModelRenderer(this, 64, 20);
/*  92 */     this.tail3.addBox(0.0F, 0.0F, 0.0F, 8, 8, 13);
/*  93 */     this.tail3.setRotationPoint(-4.0F, 6.0F, 82.0F);
/*  94 */     this.tail3.setTextureSize(256, 64);
/*  95 */     this.tail3.mirror = true;
/*  96 */     setRotation(this.tail3, 0.2230717F, 0.0F, 0.0F);
/*  97 */     this.tail4 = new ModelRenderer(this, 64, 1);
/*  98 */     this.tail4.addBox(0.0F, 0.0F, 0.0F, 6, 6, 13);
/*  99 */     this.tail4.setRotationPoint(-3.0F, 4.0F, 95.0F);
/* 100 */     this.tail4.setTextureSize(256, 64);
/* 101 */     this.tail4.mirror = true;
/* 102 */     setRotation(this.tail4, -0.0743572F, 0.0F, 0.0F);
/* 103 */     this.neck2 = new ModelRenderer(this, 0, 32);
/* 104 */     this.neck2.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
/* 105 */     this.neck2.setRotationPoint(-8.0F, -4.9F, -26.0F);
/* 106 */     this.neck2.setTextureSize(256, 64);
/* 107 */     this.neck2.mirror = true;
/* 108 */     setRotation(this.neck2, -0.8464847F, 0.0F, 0.0F);
/* 109 */     this.neck1 = new ModelRenderer(this, 0, 32);
/* 110 */     this.neck1.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
/* 111 */     this.neck1.setRotationPoint(-8.0F, -15.0F, -29.0F);
/* 112 */     this.neck1.setTextureSize(256, 64);
/* 113 */     this.neck1.mirror = true;
/* 114 */     setRotation(this.neck1, -1.181092F, 0.0F, 0.0F);
/* 115 */     this.head = new ModelRenderer(this, 0, 0);
/* 116 */     this.head.addBox(0.0F, 0.0F, 0.0F, 16, 18, 10);
/* 117 */     this.head.setRotationPoint(-8.0F, -21.0F, -30.0F);
/* 118 */     this.head.setTextureSize(256, 64);
/* 119 */     this.head.mirror = true;
/* 120 */     setRotation(this.head, -1.404164F, 0.0F, 0.0F);
/* 121 */     this.rog_1 = new ModelRenderer(this, 110, 45);
/* 122 */     this.rog_1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 5);
/* 123 */     this.rog_1.setRotationPoint(3.0F, -21.0F, -32.0F);
/* 124 */     this.rog_1.setTextureSize(256, 64);
/* 125 */     this.rog_1.mirror = true;
/* 126 */     setRotation(this.rog_1, 0.6320364F, 0.2230717F, 0.0F);
/* 127 */     this.rog_2 = new ModelRenderer(this, 110, 45);
/* 128 */     this.rog_2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 5);
/* 129 */     this.rog_2.setRotationPoint(-6.0F, -21.0F, -32.8F);
/* 130 */     this.rog_2.setTextureSize(256, 64);
/* 131 */     this.rog_2.mirror = true;
/* 132 */     setRotation(this.rog_2, 0.6320364F, -0.2230705F, 0.0F);
/* 133 */     this.rog_3 = new ModelRenderer(this, 52, 0);
/* 134 */     this.rog_3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4);
/* 135 */     this.rog_3.setRotationPoint(0.4666667F, -21.0F, -31.0F);
/* 136 */     this.rog_3.setTextureSize(256, 64);
/* 137 */     this.rog_3.mirror = true;
/* 138 */     setRotation(this.rog_3, 0.6320364F, 0.2230717F, 0.0F);
/* 139 */     this.rog_4 = new ModelRenderer(this, 52, 0);
/* 140 */     this.rog_4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4);
/* 141 */     this.rog_4.setRotationPoint(-2.466667F, -21.0F, -31.46667F);
/* 142 */     this.rog_4.setTextureSize(256, 64);
/* 143 */     this.rog_4.mirror = true;
/* 144 */     setRotation(this.rog_4, 0.6320364F, -0.2230705F, 0.0F);
/* 145 */     this.rog_5 = new ModelRenderer(this, 52, 0);
/* 146 */     this.rog_5.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4);
/* 147 */     this.rog_5.setRotationPoint(-8.0F, -17.0F, -32.0F);
/* 148 */     this.rog_5.setTextureSize(256, 64);
/* 149 */     this.rog_5.mirror = true;
/* 150 */     setRotation(this.rog_5, 0.6320364F, -0.6692139F, 0.0F);
/* 151 */     this.rog_6 = new ModelRenderer(this, 52, 0);
/* 152 */     this.rog_6.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4);
/* 153 */     this.rog_6.setRotationPoint(6.4F, -17.0F, -32.0F);
/* 154 */     this.rog_6.setTextureSize(256, 64);
/* 155 */     this.rog_6.mirror = true;
/* 156 */     setRotation(this.rog_6, 0.6320364F, 0.6692116F, 0.0F);
/* 157 */     this.snout = new ModelRenderer(this, 102, 1);
/* 158 */     this.snout.addBox(0.0F, 0.0F, 0.0F, 14, 16, 9);
/* 159 */     this.snout.setRotationPoint(-7.0F, -17.0F, -43.0F);
/* 160 */     this.snout.setTextureSize(256, 64);
/* 161 */     this.snout.mirror = true;
/* 162 */     setRotation(this.snout, -1.404164F, 0.0F, 0.0F);
/* 163 */     this.jaw = new ModelRenderer(this, 106, 26);
/* 164 */     this.jaw.addBox(0.0F, 0.0F, 0.0F, 14, 16, 3);
/* 165 */     this.jaw.setRotationPoint(-7.0F, -11.0F, -39.0F);
/* 166 */     this.jaw.setTextureSize(256, 64);
/* 167 */     this.jaw.mirror = true;
/* 168 */     setRotation(this.jaw, -0.8836633F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 174 */     Basilisk e = (Basilisk)entity;
/* 175 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 176 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 177 */     float newangle = 0.0F;
/*     */     
/* 179 */     if (f1 > 0.1D) {
/* 180 */       newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.1F * f1;
/*     */     } else {
/* 182 */       newangle = 0.0F;
/*     */     } 
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
/*     */ 
/*     */ 
/*     */     
/* 219 */     float pi4 = 0.7853975F;
/*     */     
/* 221 */     this.body1.rotateAngleY = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.1F * f1;
/* 222 */     this.body1.rotationPointZ += (float)Math.cos(this.body1.rotateAngleY) * 12.0F;
/* 223 */     this.body1.rotationPointX += (float)Math.sin(this.body1.rotateAngleY) * 12.0F;
/* 224 */     this.body2.rotateAngleY = MathHelper.cos(f2 * 1.3F * this.wingspeed - pi4) * 3.1415927F * 0.1F * f1;
/* 225 */     this.body2.rotationPointZ += (float)Math.cos(this.body2.rotateAngleY) * 11.0F;
/* 226 */     this.body2.rotationPointX += (float)Math.sin(this.body2.rotateAngleY) * 11.0F;
/* 227 */     this.body3.rotateAngleY = MathHelper.cos(f2 * 1.3F * this.wingspeed - 2.0F * pi4) * 3.1415927F * 0.1F * f1;
/* 228 */     this.body3.rotationPointZ += (float)Math.cos(this.body3.rotateAngleY) * 12.0F;
/* 229 */     this.body3.rotationPointX += (float)Math.sin(this.body3.rotateAngleY) * 12.0F;
/* 230 */     this.body4.rotateAngleY = MathHelper.cos(f2 * 1.3F * this.wingspeed - 3.0F * pi4) * 3.1415927F * 0.1F * f1;
/* 231 */     this.body4.rotationPointZ += (float)Math.cos(this.body4.rotateAngleY) * 12.0F;
/* 232 */     this.body4.rotationPointX += (float)Math.sin(this.body4.rotateAngleY) * 12.0F;
/* 233 */     this.body5.rotateAngleY = MathHelper.cos(f2 * 1.3F * this.wingspeed - 4.0F * pi4) * 3.1415927F * 0.1F * f1;
/* 234 */     this.body5.rotationPointZ += (float)Math.cos(this.body5.rotateAngleY) * 12.0F;
/* 235 */     this.body6.rotationPointX = this.body5.rotationPointX + 0.5F + (float)Math.sin(this.body5.rotateAngleY) * 12.0F;
/*     */ 
/*     */ 
/*     */     
/* 239 */     this.body6.rotateAngleY = MathHelper.cos(f2 * 1.3F * this.wingspeed - 5.0F * pi4) * 3.1415927F * 0.1F * f1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 249 */     this.body6.rotationPointZ += (float)Math.cos(this.body6.rotateAngleY) * 12.0F;
/* 250 */     this.tail1.rotationPointX = this.body6.rotationPointX + 1.0F + (float)Math.sin(this.body6.rotateAngleY) * 12.0F;
/* 251 */     this.tail1.rotateAngleY = MathHelper.cos(f2 * 1.3F * this.wingspeed - 6.0F * pi4) * 3.1415927F * 0.1F * f1;
/* 252 */     this.tail1.rotationPointZ += (float)Math.cos(this.tail1.rotateAngleY) * 10.0F;
/* 253 */     this.tail2.rotationPointX = this.tail1.rotationPointX + 1.5F + (float)Math.sin(this.tail1.rotateAngleY) * 10.0F;
/* 254 */     this.tail2.rotateAngleY = MathHelper.cos(f2 * 1.3F * this.wingspeed - 7.0F * pi4) * 3.1415927F * 0.1F * f1;
/* 255 */     this.tail2.rotationPointZ += (float)Math.cos(this.tail2.rotateAngleY) * 10.0F;
/* 256 */     this.tail3.rotationPointX = this.tail2.rotationPointX + 1.0F + (float)Math.sin(this.tail2.rotateAngleY) * 10.0F;
/* 257 */     this.tail3.rotateAngleY = MathHelper.cos(f2 * 1.3F * this.wingspeed - 8.0F * pi4) * 3.1415927F * 0.1F * f1;
/* 258 */     this.tail3.rotationPointZ += (float)Math.cos(this.tail3.rotateAngleY) * 10.0F;
/* 259 */     this.tail4.rotationPointX = this.tail3.rotationPointX + 1.0F + (float)Math.sin(this.tail3.rotateAngleY) * 10.0F;
/* 260 */     this.tail4.rotateAngleY = MathHelper.cos(f2 * 1.3F * this.wingspeed - 9.0F * pi4) * 3.1415927F * 0.1F * f1;
/*     */     
/* 262 */     if (e.getAttacking() != 0) {
/* 263 */       this.jaw.rotateAngleX = -1.0F + MathHelper.cos(f2 * 0.45F) * 3.1415927F * 0.18F;
/*     */     } else {
/* 265 */       this.jaw.rotateAngleX = -1.1F;
/*     */     } 
/*     */ 
/*     */     
/* 269 */     this.body3.render(f5);
/* 270 */     this.body2.render(f5);
/* 271 */     this.body1.render(f5);
/* 272 */     this.body4.render(f5);
/* 273 */     this.body5.render(f5);
/* 274 */     this.body6.render(f5);
/* 275 */     this.tail1.render(f5);
/* 276 */     this.tail2.render(f5);
/* 277 */     this.tail3.render(f5);
/* 278 */     this.tail4.render(f5);
/* 279 */     this.neck2.render(f5);
/* 280 */     this.neck1.render(f5);
/* 281 */     this.head.render(f5);
/* 282 */     this.rog_1.render(f5);
/* 283 */     this.rog_2.render(f5);
/* 284 */     this.rog_3.render(f5);
/* 285 */     this.rog_4.render(f5);
/* 286 */     this.rog_5.render(f5);
/* 287 */     this.rog_6.render(f5);
/* 288 */     this.snout.render(f5);
/* 289 */     this.jaw.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 295 */     model.rotateAngleX = x;
/* 296 */     model.rotateAngleY = y;
/* 297 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 302 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelBasilisk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */