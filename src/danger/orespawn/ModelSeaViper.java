/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelSeaViper
/*     */   extends ModelBase
/*     */ {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer TailTip;
/*     */   
/*     */   ModelRenderer Neck;
/*     */   ModelRenderer tBase;
/*     */   ModelRenderer t2;
/*     */   ModelRenderer t3;
/*     */   ModelRenderer t4;
/*     */   ModelRenderer t5;
/*     */   ModelRenderer t6;
/*     */   ModelRenderer t7;
/*     */   ModelRenderer t8;
/*     */   ModelRenderer t9;
/*     */   ModelRenderer t10;
/*     */   ModelRenderer t12;
/*     */   ModelRenderer t11;
/*     */   ModelRenderer t13;
/*     */   ModelRenderer t14;
/*     */   ModelRenderer t15;
/*     */   ModelRenderer t16;
/*     */   ModelRenderer t17;
/*     */   ModelRenderer t18;
/*     */   ModelRenderer t19;
/*     */   ModelRenderer t20;
/*     */   ModelRenderer t21;
/*     */   ModelRenderer MouthBottom;
/*     */   ModelRenderer ToungBase;
/*     */   ModelRenderer MiddleTounge;
/*     */   ModelRenderer EyeRight;
/*     */   ModelRenderer EyeLeft;
/*     */   ModelRenderer MouthTop;
/*     */   ModelRenderer Head;
/*     */   ModelRenderer FangRight;
/*     */   ModelRenderer FangLeft;
/*     */   ModelRenderer ForkRight;
/*     */   ModelRenderer ForkLeft;
/*     */   
/*     */   public ModelSeaViper(float f1) {
/*  50 */     this.wingspeed = f1;
/*     */     
/*  52 */     this.textureWidth = 128;
/*  53 */     this.textureHeight = 128;
/*     */     
/*  55 */     this.TailTip = new ModelRenderer(this, 0, 90);
/*  56 */     this.TailTip.addBox(-1.0F, -1.0F, 0.0F, 2, 5, 10);
/*  57 */     this.TailTip.setRotationPoint(1.0F, 20.0F, 120.0F);
/*  58 */     this.TailTip.setTextureSize(128, 128);
/*  59 */     this.TailTip.mirror = true;
/*  60 */     setRotation(this.TailTip, 0.0F, -0.6981317F, 0.0F);
/*  61 */     this.Neck = new ModelRenderer(this, 60, 60);
/*  62 */     this.Neck.addBox(-4.0F, -4.0F, -10.0F, 8, 8, 10);
/*  63 */     this.Neck.setRotationPoint(0.0F, 4.5F, -33.0F);
/*  64 */     this.Neck.setTextureSize(128, 128);
/*  65 */     this.Neck.mirror = true;
/*  66 */     setRotation(this.Neck, -0.2617994F, 0.0F, 0.0F);
/*  67 */     this.tBase = new ModelRenderer(this, 0, 31);
/*  68 */     this.tBase.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10);
/*  69 */     this.tBase.setRotationPoint(0.0F, 4.0F, -34.0F);
/*  70 */     this.tBase.setTextureSize(128, 128);
/*  71 */     this.tBase.mirror = true;
/*  72 */     setRotation(this.tBase, -0.5235988F, 0.0F, 0.0F);
/*  73 */     this.t2 = new ModelRenderer(this, 0, 31);
/*  74 */     this.t2.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10);
/*  75 */     this.t2.setRotationPoint(0.0F, 7.0F, -27.0F);
/*  76 */     this.t2.setTextureSize(128, 128);
/*  77 */     this.t2.mirror = true;
/*  78 */     setRotation(this.t2, -1.047198F, 0.0F, 0.0F);
/*  79 */     this.t3 = new ModelRenderer(this, 0, 31);
/*  80 */     this.t3.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10);
/*  81 */     this.t3.setRotationPoint(0.0F, 14.0F, -24.0F);
/*  82 */     this.t3.setTextureSize(128, 128);
/*  83 */     this.t3.mirror = true;
/*  84 */     setRotation(this.t3, -0.5235988F, 0.0F, 0.0F);
/*  85 */     this.t4 = new ModelRenderer(this, 0, 31);
/*  86 */     this.t4.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10);
/*  87 */     this.t4.setRotationPoint(0.0F, 19.0F, -17.0F);
/*  88 */     this.t4.setTextureSize(128, 128);
/*  89 */     this.t4.mirror = true;
/*  90 */     setRotation(this.t4, -0.0872665F, 0.0F, 0.0F);
/*  91 */     this.t5 = new ModelRenderer(this, 0, 31);
/*  92 */     this.t5.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10);
/*  93 */     this.t5.setRotationPoint(0.0F, 20.0F, -9.0F);
/*  94 */     this.t5.setTextureSize(128, 128);
/*  95 */     this.t5.mirror = true;
/*  96 */     setRotation(this.t5, 0.0F, 0.0F, 0.0F);
/*  97 */     this.t6 = new ModelRenderer(this, 0, 31);
/*  98 */     this.t6.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10);
/*  99 */     this.t6.setRotationPoint(0.0F, 20.0F, -1.0F);
/* 100 */     this.t6.setTextureSize(128, 128);
/* 101 */     this.t6.mirror = true;
/* 102 */     setRotation(this.t6, 0.0F, 0.3490659F, 0.0F);
/* 103 */     this.t7 = new ModelRenderer(this, 0, 31);
/* 104 */     this.t7.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10);
/* 105 */     this.t7.setRotationPoint(2.0F, 20.0F, 6.0F);
/* 106 */     this.t7.setTextureSize(128, 128);
/* 107 */     this.t7.mirror = true;
/* 108 */     setRotation(this.t7, 0.0F, 0.6981317F, 0.0F);
/* 109 */     this.t8 = new ModelRenderer(this, 0, 31);
/* 110 */     this.t8.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10);
/* 111 */     this.t8.setRotationPoint(7.0F, 20.0F, 12.0F);
/* 112 */     this.t8.setTextureSize(128, 128);
/* 113 */     this.t8.mirror = true;
/* 114 */     setRotation(this.t8, 0.0F, 0.3490659F, 0.0F);
/* 115 */     this.t9 = new ModelRenderer(this, 0, 31);
/* 116 */     this.t9.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10);
/* 117 */     this.t9.setRotationPoint(10.0F, 20.0F, 20.0F);
/* 118 */     this.t9.setTextureSize(128, 128);
/* 119 */     this.t9.mirror = true;
/* 120 */     setRotation(this.t9, 0.0F, 0.0F, 0.0F);
/* 121 */     this.t10 = new ModelRenderer(this, 0, 31);
/* 122 */     this.t10.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10);
/* 123 */     this.t10.setRotationPoint(10.0F, 20.0F, 28.0F);
/* 124 */     this.t10.setTextureSize(128, 128);
/* 125 */     this.t10.mirror = true;
/* 126 */     setRotation(this.t10, 0.0F, -0.3490659F, 0.0F);
/* 127 */     this.t12 = new ModelRenderer(this, 0, 31);
/* 128 */     this.t12.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10);
/* 129 */     this.t12.setRotationPoint(2.0F, 20.0F, 42.0F);
/* 130 */     this.t12.setTextureSize(128, 128);
/* 131 */     this.t12.mirror = true;
/* 132 */     setRotation(this.t12, 0.0F, -0.6981317F, 0.0F);
/* 133 */     this.t11 = new ModelRenderer(this, 0, 31);
/* 134 */     this.t11.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10);
/* 135 */     this.t11.setRotationPoint(8.0F, 20.0F, 35.0F);
/* 136 */     this.t11.setTextureSize(128, 128);
/* 137 */     this.t11.mirror = true;
/* 138 */     setRotation(this.t11, 0.0F, -0.6981317F, 0.0F);
/* 139 */     this.t13 = new ModelRenderer(this, 0, 31);
/* 140 */     this.t13.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10);
/* 141 */     this.t13.setRotationPoint(-4.0F, 20.0F, 48.0F);
/* 142 */     this.t13.setTextureSize(128, 128);
/* 143 */     this.t13.mirror = true;
/* 144 */     setRotation(this.t13, 0.0F, -0.3490659F, 0.0F);
/* 145 */     this.t14 = new ModelRenderer(this, 0, 51);
/* 146 */     this.t14.addBox(-3.0F, -3.0F, 0.0F, 6, 7, 10);
/* 147 */     this.t14.setRotationPoint(-8.0F, 20.0F, 56.0F);
/* 148 */     this.t14.setTextureSize(128, 128);
/* 149 */     this.t14.mirror = true;
/* 150 */     setRotation(this.t14, 0.0F, 0.0F, 0.0F);
/* 151 */     this.t15 = new ModelRenderer(this, 0, 51);
/* 152 */     this.t15.addBox(-3.0F, -3.0F, 0.0F, 6, 7, 10);
/* 153 */     this.t15.setRotationPoint(-8.0F, 20.0F, 65.0F);
/* 154 */     this.t15.setTextureSize(128, 128);
/* 155 */     this.t15.mirror = true;
/* 156 */     setRotation(this.t15, 0.0F, 0.3490659F, 0.0F);
/* 157 */     this.t16 = new ModelRenderer(this, 0, 51);
/* 158 */     this.t16.addBox(-3.0F, -3.0F, 0.0F, 6, 7, 10);
/* 159 */     this.t16.setRotationPoint(-5.0F, 20.0F, 73.0F);
/* 160 */     this.t16.setTextureSize(128, 128);
/* 161 */     this.t16.mirror = true;
/* 162 */     setRotation(this.t16, 0.0F, 0.6981317F, 0.0F);
/* 163 */     this.t17 = new ModelRenderer(this, 0, 70);
/* 164 */     this.t17.addBox(-2.0F, -2.0F, 0.0F, 4, 6, 10);
/* 165 */     this.t17.setRotationPoint(1.0F, 20.0F, 80.0F);
/* 166 */     this.t17.setTextureSize(128, 128);
/* 167 */     this.t17.mirror = true;
/* 168 */     setRotation(this.t17, 0.0F, 0.6981317F, 0.0F);
/* 169 */     this.t18 = new ModelRenderer(this, 0, 70);
/* 170 */     this.t18.addBox(-2.0F, -2.0F, 0.0F, 4, 6, 10);
/* 171 */     this.t18.setRotationPoint(7.0F, 20.0F, 87.0F);
/* 172 */     this.t18.setTextureSize(128, 128);
/* 173 */     this.t18.mirror = true;
/* 174 */     setRotation(this.t18, 0.0F, 0.3490659F, 0.0F);
/* 175 */     this.t19 = new ModelRenderer(this, 0, 70);
/* 176 */     this.t19.addBox(-2.0F, -2.0F, 0.0F, 4, 6, 10);
/* 177 */     this.t19.setRotationPoint(10.0F, 20.0F, 95.0F);
/* 178 */     this.t19.setTextureSize(128, 128);
/* 179 */     this.t19.mirror = true;
/* 180 */     setRotation(this.t19, 0.0F, 0.0F, 0.0F);
/* 181 */     this.t20 = new ModelRenderer(this, 0, 90);
/* 182 */     this.t20.addBox(-1.0F, -1.0F, 0.0F, 2, 5, 10);
/* 183 */     this.t20.setRotationPoint(10.0F, 20.0F, 104.0F);
/* 184 */     this.t20.setTextureSize(128, 128);
/* 185 */     this.t20.mirror = true;
/* 186 */     setRotation(this.t20, 0.0F, -0.3490659F, 0.0F);
/* 187 */     this.t21 = new ModelRenderer(this, 0, 90);
/* 188 */     this.t21.addBox(-1.0F, -1.0F, 0.0F, 2, 5, 10);
/* 189 */     this.t21.setRotationPoint(7.0F, 20.0F, 113.0F);
/* 190 */     this.t21.setTextureSize(128, 128);
/* 191 */     this.t21.mirror = true;
/* 192 */     setRotation(this.t21, 0.0F, -0.6981317F, 0.0F);
/* 193 */     this.MouthBottom = new ModelRenderer(this, 58, 78);
/* 194 */     this.MouthBottom.addBox(-4.0F, 0.0F, -12.0F, 8, 2, 12);
/* 195 */     this.MouthBottom.setRotationPoint(0.0F, 4.0F, -42.0F);
/* 196 */     this.MouthBottom.setTextureSize(128, 128);
/* 197 */     this.MouthBottom.mirror = true;
/* 198 */     setRotation(this.MouthBottom, 0.5235988F, 0.0F, 0.0F);
/* 199 */     this.ToungBase = new ModelRenderer(this, 70, 17);
/* 200 */     this.ToungBase.addBox(-1.0F, -2.0F, -11.0F, 2, 1, 6);
/* 201 */     this.ToungBase.setRotationPoint(0.0F, 6.0F, -40.0F);
/* 202 */     this.ToungBase.setTextureSize(128, 128);
/* 203 */     this.ToungBase.mirror = true;
/* 204 */     setRotation(this.ToungBase, 0.2617994F, 0.0F, 0.0F);
/* 205 */     this.MiddleTounge = new ModelRenderer(this, 70, 10);
/* 206 */     this.MiddleTounge.addBox(-1.0F, -1.0F, -17.0F, 2, 1, 6);
/* 207 */     this.MiddleTounge.setRotationPoint(0.0F, 6.0F, -40.0F);
/* 208 */     this.MiddleTounge.setTextureSize(128, 128);
/* 209 */     this.MiddleTounge.mirror = true;
/* 210 */     setRotation(this.MiddleTounge, 0.1745329F, 0.0F, 0.0F);
/* 211 */     this.EyeRight = new ModelRenderer(this, 96, 60);
/* 212 */     this.EyeRight.addBox(-7.0F, -7.0F, -3.0F, 1, 3, 4);
/* 213 */     this.EyeRight.setRotationPoint(0.0F, 6.0F, -40.0F);
/* 214 */     this.EyeRight.setTextureSize(128, 128);
/* 215 */     this.EyeRight.mirror = true;
/* 216 */     setRotation(this.EyeRight, 0.3490659F, 0.0F, 0.0F);
/* 217 */     this.EyeLeft = new ModelRenderer(this, 50, 60);
/* 218 */     this.EyeLeft.addBox(6.0F, -7.0F, -3.0F, 1, 3, 4);
/* 219 */     this.EyeLeft.setRotationPoint(0.0F, 6.0F, -40.0F);
/* 220 */     this.EyeLeft.setTextureSize(128, 128);
/* 221 */     this.EyeLeft.mirror = true;
/* 222 */     setRotation(this.EyeLeft, 0.3490659F, 0.0F, 0.0F);
/* 223 */     this.MouthTop = new ModelRenderer(this, 52, 24);
/* 224 */     this.MouthTop.addBox(-5.0F, -6.0F, -16.0F, 10, 6, 16);
/* 225 */     this.MouthTop.setRotationPoint(0.0F, 6.0F, -40.0F);
/* 226 */     this.MouthTop.setTextureSize(128, 128);
/* 227 */     this.MouthTop.mirror = true;
/* 228 */     setRotation(this.MouthTop, 0.0F, 0.0F, 0.0F);
/* 229 */     this.Head = new ModelRenderer(this, 60, 46);
/* 230 */     this.Head.addBox(-6.0F, -8.0F, -6.0F, 12, 8, 6);
/* 231 */     this.Head.setRotationPoint(0.0F, 6.0F, -40.0F);
/* 232 */     this.Head.setTextureSize(128, 128);
/* 233 */     this.Head.mirror = true;
/* 234 */     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
/* 235 */     this.FangRight = new ModelRenderer(this, 92, 18);
/* 236 */     this.FangRight.addBox(-4.0F, -3.0F, -15.0F, 1, 5, 1);
/* 237 */     this.FangRight.setRotationPoint(0.0F, 6.0F, -40.0F);
/* 238 */     this.FangRight.setTextureSize(128, 128);
/* 239 */     this.FangRight.mirror = true;
/* 240 */     setRotation(this.FangRight, 0.1745329F, 0.0F, 0.0F);
/* 241 */     this.FangLeft = new ModelRenderer(this, 60, 18);
/* 242 */     this.FangLeft.addBox(3.0F, -3.0F, -15.0F, 1, 5, 1);
/* 243 */     this.FangLeft.setRotationPoint(0.0F, 6.0F, -40.0F);
/* 244 */     this.FangLeft.setTextureSize(128, 128);
/* 245 */     this.FangLeft.mirror = true;
/* 246 */     setRotation(this.FangLeft, 0.1745329F, 0.0F, 0.0F);
/* 247 */     this.ForkRight = new ModelRenderer(this, 60, 3);
/* 248 */     this.ForkRight.addBox(6.0F, 0.6F, -21.0F, 2, 1, 6);
/* 249 */     this.ForkRight.setRotationPoint(0.0F, 6.0F, -40.0F);
/* 250 */     this.ForkRight.setTextureSize(128, 128);
/* 251 */     this.ForkRight.mirror = true;
/* 252 */     setRotation(this.ForkRight, 0.0872665F, 0.4363323F, 0.0F);
/* 253 */     this.ForkLeft = new ModelRenderer(this, 80, 3);
/* 254 */     this.ForkLeft.addBox(-8.0F, 0.6F, -21.0F, 2, 1, 6);
/* 255 */     this.ForkLeft.setRotationPoint(0.0F, 6.0F, -40.0F);
/* 256 */     this.ForkLeft.setTextureSize(128, 128);
/* 257 */     this.ForkLeft.mirror = true;
/* 258 */     setRotation(this.ForkLeft, 0.0872665F, -0.4363323F, 0.0F);
/*     */ 
/*     */     
/* 261 */     this.TailTip.rotationPointZ += 32.0F;
/* 262 */     this.Neck.rotationPointZ += 32.0F;
/* 263 */     this.tBase.rotationPointZ += 32.0F;
/* 264 */     this.t2.rotationPointZ += 32.0F;
/* 265 */     this.t3.rotationPointZ += 32.0F;
/* 266 */     this.t4.rotationPointZ += 32.0F;
/* 267 */     this.t5.rotationPointZ += 32.0F;
/* 268 */     this.t6.rotationPointZ += 32.0F;
/* 269 */     this.t7.rotationPointZ += 32.0F;
/* 270 */     this.t8.rotationPointZ += 32.0F;
/* 271 */     this.t9.rotationPointZ += 32.0F;
/* 272 */     this.t10.rotationPointZ += 32.0F;
/* 273 */     this.t12.rotationPointZ += 32.0F;
/* 274 */     this.t11.rotationPointZ += 32.0F;
/* 275 */     this.t13.rotationPointZ += 32.0F;
/* 276 */     this.t14.rotationPointZ += 32.0F;
/* 277 */     this.t15.rotationPointZ += 32.0F;
/* 278 */     this.t16.rotationPointZ += 32.0F;
/* 279 */     this.t17.rotationPointZ += 32.0F;
/* 280 */     this.t18.rotationPointZ += 32.0F;
/* 281 */     this.t19.rotationPointZ += 32.0F;
/* 282 */     this.t20.rotationPointZ += 32.0F;
/* 283 */     this.t21.rotationPointZ += 32.0F;
/* 284 */     this.MouthBottom.rotationPointZ += 32.0F;
/* 285 */     this.ToungBase.rotationPointZ += 32.0F;
/* 286 */     this.MiddleTounge.rotationPointZ += 32.0F;
/* 287 */     this.EyeRight.rotationPointZ += 32.0F;
/* 288 */     this.EyeLeft.rotationPointZ += 32.0F;
/* 289 */     this.MouthTop.rotationPointZ += 32.0F;
/* 290 */     this.Head.rotationPointZ += 32.0F;
/* 291 */     this.FangRight.rotationPointZ += 32.0F;
/* 292 */     this.FangLeft.rotationPointZ += 32.0F;
/* 293 */     this.ForkRight.rotationPointZ += 32.0F;
/* 294 */     this.ForkLeft.rotationPointZ += 32.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 301 */     SeaViper e = (SeaViper)entity;
/* 302 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 303 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 304 */     float newangle = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 308 */     if (f1 < 0.0F) f1 = 0.0F;
/*     */     
/* 310 */     newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.1F * f1;
/*     */ 
/*     */     
/* 313 */     this.tBase.rotateAngleY = newangle;
/*     */     
/* 315 */     doseg(this.tBase, this.t2, 2.0F, f1, f2);
/* 316 */     doseg(this.t2, this.t3, 2.0F, f1, f2);
/* 317 */     doseg(this.t3, this.t4, 3.0F, f1, f2);
/* 318 */     doseg(this.t4, this.t5, 4.0F, f1, f2);
/* 319 */     doseg(this.t5, this.t6, 5.0F, f1, f2);
/* 320 */     doseg(this.t6, this.t7, 6.0F, f1, f2);
/* 321 */     doseg(this.t7, this.t8, 7.0F, f1, f2);
/* 322 */     doseg(this.t8, this.t9, 8.0F, f1, f2);
/* 323 */     doseg(this.t9, this.t10, 9.0F, f1, f2);
/* 324 */     doseg(this.t10, this.t11, 10.0F, f1, f2);
/* 325 */     doseg(this.t11, this.t12, 11.0F, f1, f2);
/* 326 */     doseg(this.t12, this.t13, 12.0F, f1, f2);
/* 327 */     doseg(this.t13, this.t14, 13.0F, f1, f2);
/* 328 */     doseg(this.t14, this.t15, 14.0F, f1, f2);
/* 329 */     doseg(this.t15, this.t16, 15.0F, f1, f2);
/* 330 */     doseg(this.t16, this.t17, 16.0F, f1, f2);
/* 331 */     doseg(this.t17, this.t18, 17.0F, f1, f2);
/* 332 */     doseg(this.t18, this.t19, 18.0F, f1, f2);
/* 333 */     doseg(this.t19, this.t20, 19.0F, f1, f2);
/* 334 */     doseg(this.t20, this.t21, 20.0F, f1, f2);
/* 335 */     doseg(this.t21, this.TailTip, 21.0F, f1, f2);
/*     */     
/* 337 */     if (e.getAttacking() != 0) {
/* 338 */       newangle = MathHelper.cos(f2 * 1.7F * this.wingspeed) * 3.1415927F * 0.17F;
/* 339 */       this.MouthBottom.rotateAngleX = 0.65F + newangle;
/* 340 */       newangle = MathHelper.cos(f2 * 4.7F * this.wingspeed) * 3.1415927F * 0.07F;
/* 341 */       this.ToungBase.rotateAngleX = 0.261F + newangle;
/* 342 */       this.MiddleTounge.rotateAngleX = 0.174F + newangle;
/* 343 */       this.ForkLeft.rotateAngleX = 0.087F + newangle;
/* 344 */       this.ForkRight.rotateAngleX = 0.087F + newangle;
/* 345 */       newangle = MathHelper.cos(f2 * 1.5F * this.wingspeed) * 3.1415927F * 0.05F;
/* 346 */       this.ForkRight.offsetZ = newangle;
/*     */     } else {
/* 348 */       newangle = MathHelper.cos(f2 * 0.2F * this.wingspeed) * 3.1415927F * 0.02F;
/* 349 */       this.MouthBottom.rotateAngleX = 0.45F + newangle;
/* 350 */       newangle = MathHelper.cos(f2 * 1.7F * this.wingspeed) * 3.1415927F * 0.03F;
/* 351 */       this.ToungBase.rotateAngleX = 0.261F + newangle;
/* 352 */       this.MiddleTounge.rotateAngleX = 0.174F + newangle;
/* 353 */       this.ForkLeft.rotateAngleX = 0.087F + newangle;
/* 354 */       this.ForkRight.rotateAngleX = 0.087F + newangle;
/* 355 */       newangle = MathHelper.cos(f2 * 0.5F * this.wingspeed) * 3.1415927F * 0.05F;
/* 356 */       this.ForkRight.offsetZ = newangle;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 361 */     newangle = (float)Math.toRadians(f3) * 0.5F;
/* 362 */     this.EyeRight.rotateAngleY = newangle;
/* 363 */     this.FangRight.rotateAngleY = newangle;
/*     */     
/* 365 */     this.MouthBottom.rotateAngleY = newangle;
/* 366 */     this.Head.rotationPointZ -= (float)Math.cos(this.Head.rotateAngleY) * 2.0F;
/* 367 */     this.Head.rotationPointX -= (float)Math.sin(this.Head.rotateAngleY) * 2.0F;
/*     */     
/* 369 */     this.ToungBase.rotateAngleY = newangle;
/* 370 */     this.MiddleTounge.rotateAngleY = newangle;
/* 371 */     this.ForkLeft.rotateAngleY = newangle - 0.436F;
/* 372 */     this.ForkRight.rotateAngleY = newangle + 0.436F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 377 */     this.TailTip.render(f5);
/* 378 */     this.Neck.render(f5);
/* 379 */     this.tBase.render(f5);
/* 380 */     this.t2.render(f5);
/* 381 */     this.t3.render(f5);
/* 382 */     this.t4.render(f5);
/* 383 */     this.t5.render(f5);
/* 384 */     this.t6.render(f5);
/* 385 */     this.t7.render(f5);
/* 386 */     this.t8.render(f5);
/* 387 */     this.t9.render(f5);
/* 388 */     this.t10.render(f5);
/* 389 */     this.t12.render(f5);
/* 390 */     this.t11.render(f5);
/* 391 */     this.t13.render(f5);
/* 392 */     this.t14.render(f5);
/* 393 */     this.t15.render(f5);
/* 394 */     this.t16.render(f5);
/* 395 */     this.t17.render(f5);
/* 396 */     this.t18.render(f5);
/* 397 */     this.t19.render(f5);
/* 398 */     this.t20.render(f5);
/* 399 */     this.t21.render(f5);
/* 400 */     this.MouthBottom.render(f5);
/* 401 */     this.ToungBase.render(f5);
/* 402 */     this.MiddleTounge.render(f5);
/* 403 */     this.EyeRight.render(f5);
/* 404 */     this.EyeLeft.render(f5);
/* 405 */     this.MouthTop.render(f5);
/* 406 */     this.Head.render(f5);
/* 407 */     this.FangRight.render(f5);
/* 408 */     this.FangLeft.render(f5);
/* 409 */     this.ForkRight.render(f5);
/* 410 */     this.ForkLeft.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void doseg(ModelRenderer inn, ModelRenderer notinn, float f, float f1, float f2) {
/* 416 */     float pi4 = 0.7853982F;
/* 417 */     float newangle = 0.0F;
/*     */     
/* 419 */     notinn.rotationPointZ = (float)(inn.rotationPointZ + (float)Math.cos(inn.rotateAngleY) * 9.0D * Math.abs(Math.cos(inn.rotateAngleX)));
/* 420 */     notinn.rotationPointX = (float)(inn.rotationPointX + ((float)Math.sin(inn.rotateAngleY) * 9.0F) * Math.abs(Math.cos(inn.rotateAngleX)));
/* 421 */     newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed - pi4 * f) * 3.1415927F * 0.2F * f1;
/* 422 */     float a = MathHelper.cos(-(pi4 * f));
/* 423 */     notinn.rotateAngleY = newangle + a - a * f1;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 428 */     model.rotateAngleX = x;
/* 429 */     model.rotateAngleY = y;
/* 430 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 435 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelSeaViper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */