/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ public class ModelCrab
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer body1;
/*     */   ModelRenderer body2;
/*     */   ModelRenderer leg1;
/*     */   ModelRenderer body3;
/*     */   ModelRenderer body4;
/*     */   ModelRenderer leg2;
/*     */   ModelRenderer leg3;
/*     */   ModelRenderer body5;
/*     */   ModelRenderer body6;
/*     */   ModelRenderer Leye1;
/*     */   ModelRenderer Reye1;
/*     */   ModelRenderer Leye2;
/*     */   ModelRenderer Reye2;
/*     */   ModelRenderer Lclaw1;
/*     */   ModelRenderer Lclaw2;
/*     */   ModelRenderer Lclaw3;
/*     */   ModelRenderer Lclaw4;
/*     */   ModelRenderer Lclaw5;
/*     */   ModelRenderer Rclaw1;
/*     */   ModelRenderer Rclaw2;
/*     */   ModelRenderer Rclaw3;
/*     */   ModelRenderer Rclaw4;
/*     */   ModelRenderer Rclaw5;
/*     */   ModelRenderer Rmouth;
/*     */   ModelRenderer Lmouth;
/*     */   
/*     */   public ModelCrab(float f) {
/*  39 */     this.textureWidth = 256;
/*  40 */     this.textureHeight = 512;
/*     */     
/*  42 */     this.body1 = new ModelRenderer(this, 0, 450);
/*  43 */     this.body1.addBox(-38.0F, -5.0F, -8.0F, 76, 10, 48);
/*  44 */     this.body1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  45 */     this.body1.setTextureSize(64, 32);
/*  46 */     this.body1.mirror = true;
/*  47 */     setRotation(this.body1, 0.0F, 0.0F, 0.0F);
/*  48 */     this.body2 = new ModelRenderer(this, 0, 406);
/*  49 */     this.body2.addBox(-32.0F, -10.0F, -10.0F, 64, 5, 34);
/*  50 */     this.body2.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  51 */     this.body2.setTextureSize(64, 32);
/*  52 */     this.body2.mirror = true;
/*  53 */     setRotation(this.body2, 0.0F, 0.0F, 0.0F);
/*  54 */     this.leg1 = new ModelRenderer(this, 128, 0);
/*  55 */     this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
/*  56 */     this.leg1.setRotationPoint(36.0F, 3.0F, 0.0F);
/*  57 */     this.leg1.setTextureSize(64, 32);
/*  58 */     this.leg1.mirror = true;
/*  59 */     setRotation(this.leg1, -1.343904F, -1.500983F, 0.0F);
/*  60 */     this.body3 = new ModelRenderer(this, 0, 357);
/*  61 */     this.body3.addBox(0.0F, 0.0F, 0.0F, 8, 4, 40);
/*  62 */     this.body3.setRotationPoint(38.0F, -5.0F, -6.0F);
/*  63 */     this.body3.setTextureSize(64, 32);
/*  64 */     this.body3.mirror = true;
/*  65 */     setRotation(this.body3, 0.0F, 0.0F, 0.0F);
/*  66 */     this.body4 = new ModelRenderer(this, 100, 357);
/*  67 */     this.body4.addBox(0.0F, 0.0F, 0.0F, 8, 4, 40);
/*  68 */     this.body4.setRotationPoint(-46.0F, -5.0F, -6.0F);
/*  69 */     this.body4.setTextureSize(64, 32);
/*  70 */     this.body4.mirror = true;
/*  71 */     setRotation(this.body4, 0.0F, 0.0F, 0.0F);
/*  72 */     this.leg2 = new ModelRenderer(this, 128, 20);
/*  73 */     this.leg2.addBox(-1.0F, 10.0F, -6.0F, 3, 16, 3);
/*  74 */     this.leg2.setRotationPoint(36.0F, 3.0F, 0.0F);
/*  75 */     this.leg2.setTextureSize(256, 512);
/*  76 */     this.leg2.mirror = true;
/*  77 */     setRotation(this.leg2, -0.9599311F, -1.500983F, 0.0F);
/*  78 */     this.leg3 = new ModelRenderer(this, 128, 43);
/*  79 */     this.leg3.addBox(0.0F, 21.0F, -15.0F, 2, 16, 2);
/*  80 */     this.leg3.setRotationPoint(36.0F, 3.0F, 0.0F);
/*  81 */     this.leg3.setTextureSize(256, 512);
/*  82 */     this.leg3.mirror = true;
/*  83 */     setRotation(this.leg3, -0.5759587F, -1.500983F, 0.0F);
/*  84 */     this.body5 = new ModelRenderer(this, 0, 339);
/*  85 */     this.body5.addBox(-25.0F, 0.0F, 0.0F, 50, 4, 10);
/*  86 */     this.body5.setRotationPoint(0.0F, -4.0F, 40.0F);
/*  87 */     this.body5.setTextureSize(64, 32);
/*  88 */     this.body5.mirror = true;
/*  89 */     setRotation(this.body5, 0.0F, 0.0F, 0.0F);
/*  90 */     this.body6 = new ModelRenderer(this, 124, 342);
/*  91 */     this.body6.addBox(-14.0F, 0.0F, 0.0F, 28, 3, 4);
/*  92 */     this.body6.setRotationPoint(0.0F, -10.0F, -14.0F);
/*  93 */     this.body6.setTextureSize(64, 32);
/*  94 */     this.body6.mirror = true;
/*  95 */     setRotation(this.body6, 0.0F, 0.0F, 0.0F);
/*  96 */     this.Leye1 = new ModelRenderer(this, 62, 0);
/*  97 */     this.Leye1.addBox(-0.5F, -12.0F, -0.5F, 1, 12, 1);
/*  98 */     this.Leye1.setRotationPoint(9.0F, -9.0F, -11.0F);
/*  99 */     this.Leye1.setTextureSize(64, 32);
/* 100 */     this.Leye1.mirror = true;
/* 101 */     setRotation(this.Leye1, 0.0F, 0.0F, 0.4886922F);
/* 102 */     this.Reye1 = new ModelRenderer(this, 40, 0);
/* 103 */     this.Reye1.addBox(-0.5F, -12.0F, -0.5F, 1, 12, 1);
/* 104 */     this.Reye1.setRotationPoint(-9.0F, -9.0F, -11.0F);
/* 105 */     this.Reye1.setTextureSize(64, 32);
/* 106 */     this.Reye1.mirror = true;
/* 107 */     setRotation(this.Reye1, 0.0F, 0.0F, -0.4886922F);
/* 108 */     this.Leye2 = new ModelRenderer(this, 50, 0);
/* 109 */     this.Leye2.addBox(-1.0F, -14.0F, -1.0F, 2, 2, 2);
/* 110 */     this.Leye2.setRotationPoint(9.0F, -9.0F, -11.0F);
/* 111 */     this.Leye2.setTextureSize(64, 32);
/* 112 */     this.Leye2.mirror = true;
/* 113 */     setRotation(this.Leye2, 0.0F, 0.0F, 0.4886922F);
/* 114 */     this.Reye2 = new ModelRenderer(this, 26, 0);
/* 115 */     this.Reye2.addBox(-1.0F, -14.0F, -1.0F, 2, 2, 2);
/* 116 */     this.Reye2.setRotationPoint(-9.0F, -9.0F, -11.0F);
/* 117 */     this.Reye2.setTextureSize(64, 32);
/* 118 */     this.Reye2.mirror = true;
/* 119 */     setRotation(this.Reye2, 0.0F, 0.0F, -0.4886922F);
/* 120 */     this.Lclaw1 = new ModelRenderer(this, 0, 80);
/* 121 */     this.Lclaw1.addBox(-4.0F, 0.0F, -14.0F, 8, 4, 18);
/* 122 */     this.Lclaw1.setRotationPoint(31.0F, -2.0F, -8.0F);
/* 123 */     this.Lclaw1.setTextureSize(64, 32);
/* 124 */     this.Lclaw1.mirror = true;
/* 125 */     setRotation(this.Lclaw1, 0.0F, -0.4886922F, 0.0F);
/* 126 */     this.Lclaw2 = new ModelRenderer(this, 0, 105);
/* 127 */     this.Lclaw2.addBox(-7.0F, -3.0F, -12.0F, 17, 6, 16);
/* 128 */     this.Lclaw2.setRotationPoint(37.0F, 0.0F, -20.0F);
/* 129 */     this.Lclaw2.setTextureSize(64, 32);
/* 130 */     this.Lclaw2.mirror = true;
/* 131 */     setRotation(this.Lclaw2, 0.0F, -0.1745329F, 0.0F);
/* 132 */     this.Lclaw3 = new ModelRenderer(this, 0, 131);
/* 133 */     this.Lclaw3.addBox(0.0F, -5.0F, -25.0F, 17, 10, 30);
/* 134 */     this.Lclaw3.setRotationPoint(37.0F, 0.0F, -31.0F);
/* 135 */     this.Lclaw3.setTextureSize(64, 32);
/* 136 */     this.Lclaw3.mirror = true;
/* 137 */     setRotation(this.Lclaw3, 0.0F, -0.4537856F, 0.0F);
/* 138 */     this.Lclaw4 = new ModelRenderer(this, 0, 175);
/* 139 */     this.Lclaw4.addBox(2.0F, -3.0F, -32.0F, 11, 5, 12);
/* 140 */     this.Lclaw4.setRotationPoint(37.0F, 0.0F, -31.0F);
/* 141 */     this.Lclaw4.setTextureSize(64, 32);
/* 142 */     this.Lclaw4.mirror = true;
/* 143 */     setRotation(this.Lclaw4, 0.0F, -0.3490659F, 0.0F);
/* 144 */     this.Lclaw5 = new ModelRenderer(this, 0, 197);
/* 145 */     this.Lclaw5.addBox(-4.0F, -3.0F, -27.0F, 7, 5, 32);
/* 146 */     this.Lclaw5.setRotationPoint(36.0F, 0.0F, -31.0F);
/* 147 */     this.Lclaw5.setTextureSize(64, 32);
/* 148 */     this.Lclaw5.mirror = true;
/* 149 */     setRotation(this.Lclaw5, 0.0F, 0.3839724F, 0.0F);
/* 150 */     this.Rclaw1 = new ModelRenderer(this, 102, 78);
/* 151 */     this.Rclaw1.addBox(-4.0F, 0.0F, -14.0F, 8, 4, 18);
/* 152 */     this.Rclaw1.setRotationPoint(-31.0F, -2.0F, -8.0F);
/* 153 */     this.Rclaw1.setTextureSize(64, 32);
/* 154 */     this.Rclaw1.mirror = true;
/* 155 */     setRotation(this.Rclaw1, 0.0F, 0.4886922F, 0.0F);
/* 156 */     this.Rclaw2 = new ModelRenderer(this, 103, 106);
/* 157 */     this.Rclaw2.addBox(-10.0F, -3.0F, -12.0F, 17, 6, 16);
/* 158 */     this.Rclaw2.setRotationPoint(-37.0F, 0.0F, -20.0F);
/* 159 */     this.Rclaw2.setTextureSize(64, 32);
/* 160 */     this.Rclaw2.mirror = true;
/* 161 */     setRotation(this.Rclaw2, 0.0F, 0.1745329F, 0.0F);
/* 162 */     this.Rclaw3 = new ModelRenderer(this, 100, 131);
/* 163 */     this.Rclaw3.addBox(-17.0F, -5.0F, -25.0F, 17, 10, 30);
/* 164 */     this.Rclaw3.setRotationPoint(-37.0F, 0.0F, -31.0F);
/* 165 */     this.Rclaw3.setTextureSize(64, 32);
/* 166 */     this.Rclaw3.mirror = true;
/* 167 */     setRotation(this.Rclaw3, 0.0F, 0.4537856F, 0.0F);
/* 168 */     this.Rclaw4 = new ModelRenderer(this, 101, 175);
/* 169 */     this.Rclaw4.addBox(-13.0F, -3.0F, -32.0F, 11, 5, 12);
/* 170 */     this.Rclaw4.setRotationPoint(-37.0F, 0.0F, -31.0F);
/* 171 */     this.Rclaw4.setTextureSize(64, 32);
/* 172 */     this.Rclaw4.mirror = true;
/* 173 */     setRotation(this.Rclaw4, 0.0F, 0.3490659F, 0.0F);
/* 174 */     this.Rclaw5 = new ModelRenderer(this, 100, 197);
/* 175 */     this.Rclaw5.addBox(-4.0F, -3.0F, -27.0F, 7, 5, 32);
/* 176 */     this.Rclaw5.setRotationPoint(-36.0F, 0.0F, -31.0F);
/* 177 */     this.Rclaw5.setTextureSize(64, 32);
/* 178 */     this.Rclaw5.mirror = true;
/* 179 */     setRotation(this.Rclaw5, 0.0F, -0.3839724F, 0.0F);
/* 180 */     this.Rmouth = new ModelRenderer(this, 0, 28);
/* 181 */     this.Rmouth.addBox(0.0F, 0.0F, -0.5F, 6, 3, 1);
/* 182 */     this.Rmouth.setRotationPoint(-7.0F, 0.0F, -7.5F);
/* 183 */     this.Rmouth.setTextureSize(256, 512);
/* 184 */     this.Rmouth.mirror = true;
/* 185 */     setRotation(this.Rmouth, 0.0F, 0.3665191F, 0.0F);
/* 186 */     this.Lmouth = new ModelRenderer(this, 0, 19);
/* 187 */     this.Lmouth.addBox(-6.0F, 0.0F, -0.5F, 6, 3, 1);
/* 188 */     this.Lmouth.setRotationPoint(7.0F, 0.0F, -7.5F);
/* 189 */     this.Lmouth.setTextureSize(256, 512);
/* 190 */     this.Lmouth.mirror = true;
/* 191 */     setRotation(this.Lmouth, 0.0F, -0.3665191F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 196 */     Crab e = (Crab)entity;
/*     */     
/* 198 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 199 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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
/* 221 */     this.leg3.rotationPointX = 36.0F;
/* 222 */     this.leg3.rotationPointY = 3.0F;
/* 223 */     this.leg3.rotationPointZ = 0.0F;
/* 224 */     this.leg3.rotateAngleY = (float)(-1.5707963267948966D + (MathHelper.cos(f2 * 1.7F) * 3.1415927F * 0.15F * f1));
/* 225 */     this.leg1.render(f5);
/* 226 */     this.leg2.render(f5);
/* 227 */     this.leg3.render(f5);
/*     */     
/* 229 */     this.leg3.rotationPointZ = 10.0F;
/* 230 */     this.leg3.rotateAngleY = (float)(-1.5707963267948966D - (MathHelper.cos(f2 * 1.7F) * 3.1415927F * 0.15F * f1));
/* 231 */     this.leg1.render(f5);
/* 232 */     this.leg2.render(f5);
/* 233 */     this.leg3.render(f5);
/*     */     
/* 235 */     this.leg3.rotationPointZ = 20.0F;
/* 236 */     this.leg3.rotateAngleY = (float)(-1.5707963267948966D + (MathHelper.cos(f2 * 1.7F) * 3.1415927F * 0.15F * f1));
/* 237 */     this.leg1.render(f5);
/* 238 */     this.leg2.render(f5);
/* 239 */     this.leg3.render(f5);
/*     */     
/* 241 */     this.leg3.rotationPointZ = 30.0F;
/* 242 */     this.leg3.rotateAngleY = (float)(-1.5707963267948966D - (MathHelper.cos(f2 * 1.7F) * 3.1415927F * 0.15F * f1));
/* 243 */     this.leg1.render(f5);
/* 244 */     this.leg2.render(f5);
/* 245 */     this.leg3.render(f5);
/*     */     
/* 247 */     this.leg3.rotationPointX = -36.0F;
/* 248 */     this.leg3.rotationPointY = 3.0F;
/* 249 */     this.leg3.rotationPointZ = 0.0F;
/* 250 */     this.leg3.rotateAngleY = (float)-(-1.5707963267948966D + (MathHelper.cos(f2 * 1.7F) * 3.1415927F * 0.15F * f1));
/* 251 */     this.leg1.render(f5);
/* 252 */     this.leg2.render(f5);
/* 253 */     this.leg3.render(f5);
/*     */     
/* 255 */     this.leg3.rotationPointZ = 10.0F;
/* 256 */     this.leg3.rotateAngleY = (float)-(-1.5707963267948966D - (MathHelper.cos(f2 * 1.7F) * 3.1415927F * 0.15F * f1));
/* 257 */     this.leg1.render(f5);
/* 258 */     this.leg2.render(f5);
/* 259 */     this.leg3.render(f5);
/*     */     
/* 261 */     this.leg3.rotationPointZ = 20.0F;
/* 262 */     this.leg3.rotateAngleY = (float)-(-1.5707963267948966D + (MathHelper.cos(f2 * 1.7F) * 3.1415927F * 0.15F * f1));
/* 263 */     this.leg1.render(f5);
/* 264 */     this.leg2.render(f5);
/* 265 */     this.leg3.render(f5);
/*     */     
/* 267 */     this.leg3.rotationPointZ = 30.0F;
/* 268 */     this.leg3.rotateAngleY = (float)-(-1.5707963267948966D - (MathHelper.cos(f2 * 1.7F) * 3.1415927F * 0.15F * f1));
/* 269 */     this.leg1.render(f5);
/* 270 */     this.leg2.render(f5);
/* 271 */     this.leg3.render(f5);
/*     */     
/* 273 */     if (e.getAttacking() == 0) {
/* 274 */       this.Leye2.rotateAngleX = MathHelper.cos(f2 * 0.35F) * 3.1415927F * 0.05F;
/* 275 */       this.Leye2.rotateAngleZ = 0.54F + MathHelper.cos(f2 * 0.25F) * 3.1415927F * 0.05F;
/* 276 */       this.Reye2.rotateAngleX = MathHelper.cos(f2 * 0.3F) * 3.1415927F * 0.05F;
/* 277 */       this.Reye2.rotateAngleZ = -0.54F + MathHelper.cos(f2 * 0.45F) * 3.1415927F * 0.05F;
/* 278 */       this.Lmouth.rotateAngleY = -0.72F + MathHelper.cos(f2 * 0.25F) * 3.1415927F * 0.05F;
/* 279 */       this.Rmouth.rotateAngleY = 0.72F - MathHelper.cos(f2 * 0.25F) * 3.1415927F * 0.05F;
/* 280 */       float newangle = MathHelper.cos(f2 * 0.15F) * 3.1415927F * 0.03F;
/* 281 */       this.Lclaw3.rotateAngleY = -0.453F + newangle;
/* 282 */       this.Lclaw4.rotateAngleY = -0.349F + newangle;
/* 283 */       this.Lclaw5.rotateAngleY = 0.384F - newangle;
/* 284 */       newangle = MathHelper.cos(f2 * 0.13F) * 3.1415927F * 0.02F;
/* 285 */       this.Rclaw3.rotateAngleY = 0.453F + newangle;
/* 286 */       this.Rclaw4.rotateAngleY = 0.349F + newangle;
/* 287 */       this.Rclaw5.rotateAngleY = -0.384F - newangle;
/*     */     } else {
/* 289 */       this.Leye2.rotateAngleX = MathHelper.cos(f2 * 0.45F) * 3.1415927F * 0.1F;
/* 290 */       this.Leye2.rotateAngleZ = 0.54F + MathHelper.cos(f2 * 0.35F) * 3.1415927F * 0.1F;
/* 291 */       this.Reye2.rotateAngleX = MathHelper.cos(f2 * 0.4F) * 3.1415927F * 0.1F;
/* 292 */       this.Reye2.rotateAngleZ = -0.54F + MathHelper.cos(f2 * 0.55F) * 3.1415927F * 0.1F;
/* 293 */       this.Lmouth.rotateAngleY = -0.72F + MathHelper.cos(f2 * 0.45F) * 3.1415927F * 0.15F;
/* 294 */       this.Rmouth.rotateAngleY = 0.72F - MathHelper.cos(f2 * 0.45F) * 3.1415927F * 0.15F;
/* 295 */       float newangle = MathHelper.cos(f2 * 0.35F) * 3.1415927F * 0.13F;
/* 296 */       this.Lclaw3.rotateAngleY = -0.453F + newangle;
/* 297 */       this.Lclaw4.rotateAngleY = -0.349F + newangle;
/* 298 */       this.Lclaw5.rotateAngleY = 0.384F - newangle;
/* 299 */       newangle = MathHelper.cos(f2 * 0.43F) * 3.1415927F * 0.12F;
/* 300 */       this.Rclaw3.rotateAngleY = 0.453F + newangle;
/* 301 */       this.Rclaw4.rotateAngleY = 0.349F + newangle;
/* 302 */       this.Rclaw5.rotateAngleY = -0.384F - newangle;
/*     */     } 
/*     */ 
/*     */     
/* 306 */     this.body1.render(f5);
/* 307 */     this.body2.render(f5);
/*     */     
/* 309 */     this.body3.render(f5);
/* 310 */     this.body4.render(f5);
/* 311 */     this.leg2.render(f5);
/* 312 */     this.leg3.render(f5);
/* 313 */     this.body5.render(f5);
/* 314 */     this.body6.render(f5);
/* 315 */     this.Leye1.render(f5);
/* 316 */     this.Reye1.render(f5);
/* 317 */     this.Leye2.render(f5);
/* 318 */     this.Reye2.render(f5);
/* 319 */     this.Lclaw1.render(f5);
/* 320 */     this.Lclaw2.render(f5);
/* 321 */     this.Lclaw3.render(f5);
/* 322 */     this.Lclaw4.render(f5);
/* 323 */     this.Lclaw5.render(f5);
/* 324 */     this.Rclaw1.render(f5);
/* 325 */     this.Rclaw2.render(f5);
/* 326 */     this.Rclaw3.render(f5);
/* 327 */     this.Rclaw4.render(f5);
/* 328 */     this.Rclaw5.render(f5);
/* 329 */     this.Rmouth.render(f5);
/* 330 */     this.Lmouth.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 335 */     model.rotateAngleX = x;
/* 336 */     model.rotateAngleY = y;
/* 337 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 342 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelCrab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */