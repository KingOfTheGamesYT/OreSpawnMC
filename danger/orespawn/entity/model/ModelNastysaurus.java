/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelNastysaurus
/*     */   extends ModelBase
/*     */ {
/*  13 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer lclaw1;
/*     */   
/*     */   ModelRenderer body;
/*     */   
/*     */   ModelRenderer leftleg1;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer leftleg2;
/*     */   ModelRenderer body2;
/*     */   ModelRenderer leftleg3;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer tail3;
/*     */   ModelRenderer lclaw2;
/*     */   ModelRenderer lclaw3;
/*     */   ModelRenderer lclaw4;
/*     */   ModelRenderer lclaw5;
/*     */   ModelRenderer lclaw6;
/*     */   ModelRenderer lclaw7;
/*     */   ModelRenderer neck3;
/*     */   ModelRenderer head3;
/*     */   ModelRenderer jaw1;
/*     */   ModelRenderer tooth1;
/*     */   ModelRenderer tooth2;
/*     */   ModelRenderer tooth3;
/*     */   ModelRenderer tooth4;
/*     */   ModelRenderer tooth5;
/*     */   ModelRenderer jaw5;
/*     */   ModelRenderer head7;
/*     */   ModelRenderer tooth6;
/*     */   ModelRenderer tooth7;
/*     */   ModelRenderer tooth8;
/*     */   ModelRenderer tooth9;
/*     */   ModelRenderer tooth10;
/*     */   ModelRenderer tooth11;
/*     */   ModelRenderer tooth12;
/*     */   ModelRenderer tooth13;
/*     */   ModelRenderer rightleg1;
/*     */   ModelRenderer rightleg2;
/*     */   ModelRenderer tooth14;
/*     */   ModelRenderer tooth15;
/*     */   ModelRenderer tooth16;
/*     */   ModelRenderer tooth17;
/*     */   ModelRenderer tooth18;
/*     */   ModelRenderer tooth19;
/*     */   ModelRenderer tooth20;
/*     */   ModelRenderer tooth21;
/*     */   ModelRenderer tooth22;
/*     */   ModelRenderer tooth23;
/*     */   ModelRenderer rightleg3;
/*     */   ModelRenderer rclaw2;
/*     */   ModelRenderer rclaw4;
/*     */   ModelRenderer rclaw1;
/*     */   ModelRenderer rclaw5;
/*     */   ModelRenderer rclaw7;
/*     */   ModelRenderer rclaw3;
/*     */   ModelRenderer rclaw6;
/*     */   ModelRenderer neck1;
/*     */   ModelRenderer neck2;
/*     */   ModelRenderer tail4;
/*     */   ModelRenderer Spike1;
/*     */   ModelRenderer Spike2;
/*     */   ModelRenderer Spike3;
/*     */   
/*     */   public ModelNastysaurus(float f1) {
/*  78 */     this.wingspeed = f1;
/*     */     
/*  80 */     this.textureWidth = 512;
/*  81 */     this.textureHeight = 256;
/*     */     
/*  83 */     this.lclaw1 = new ModelRenderer(this, 300, 111);
/*  84 */     this.lclaw1.addBox(-3.0F, 0.0F, -3.0F, 2, 3, 6);
/*  85 */     this.lclaw1.setRotationPoint(7.0F, 21.0F, 11.0F);
/*  86 */     this.lclaw1.setTextureSize(512, 256);
/*  87 */     this.lclaw1.mirror = true;
/*  88 */     setRotation(this.lclaw1, 0.0F, 0.6632251F, 0.0F);
/*  89 */     this.body = new ModelRenderer(this, 407, 3);
/*  90 */     this.body.addBox(-6.0F, -12.0F, -9.0F, 12, 17, 9);
/*  91 */     this.body.setRotationPoint(0.0F, -2.0F, 9.0F);
/*  92 */     this.body.setTextureSize(512, 256);
/*  93 */     this.body.mirror = true;
/*  94 */     setRotation(this.body, -0.3141593F, 0.0F, 0.0F);
/*  95 */     this.leftleg1 = new ModelRenderer(this, 300, 0);
/*  96 */     this.leftleg1.addBox(-3.0F, -4.0F, -21.0F, 6, 11, 11);
/*  97 */     this.leftleg1.setRotationPoint(9.0F, 2.0F, 26.0F);
/*  98 */     this.leftleg1.setTextureSize(512, 256);
/*  99 */     this.leftleg1.mirror = true;
/* 100 */     setRotation(this.leftleg1, -0.5759587F, 0.0F, 0.0F);
/* 101 */     this.tail1 = new ModelRenderer(this, 400, 75);
/* 102 */     this.tail1.addBox(-6.0F, -6.0F, 0.0F, 10, 12, 14);
/* 103 */     this.tail1.setRotationPoint(1.0F, -5.0F, 22.0F);
/* 104 */     this.tail1.setTextureSize(512, 256);
/* 105 */     this.tail1.mirror = true;
/* 106 */     setRotation(this.tail1, -0.1745329F, 0.0F, 0.0F);
/* 107 */     this.leftleg2 = new ModelRenderer(this, 300, 23);
/* 108 */     this.leftleg2.addBox(-3.0F, -10.0F, -5.0F, 5, 13, 7);
/* 109 */     this.leftleg2.setRotationPoint(9.0F, 2.0F, 26.0F);
/* 110 */     this.leftleg2.setTextureSize(512, 256);
/* 111 */     this.leftleg2.mirror = true;
/* 112 */     setRotation(this.leftleg2, 0.9773844F, 0.0F, 0.0F);
/* 113 */     this.body2 = new ModelRenderer(this, 400, 39);
/* 114 */     this.body2.addBox(0.0F, -3.0F, -3.0F, 12, 18, 16);
/* 115 */     this.body2.setRotationPoint(-6.0F, -11.0F, 10.0F);
/* 116 */     this.body2.setTextureSize(512, 256);
/* 117 */     this.body2.mirror = true;
/* 118 */     setRotation(this.body2, -0.1047198F, 0.0F, 0.0F);
/* 119 */     this.leftleg3 = new ModelRenderer(this, 300, 51);
/* 120 */     this.leftleg3.addBox(-1.0F, -19.0F, 0.0F, 4, 18, 6);
/* 121 */     this.leftleg3.setRotationPoint(7.0F, 21.0F, 11.0F);
/* 122 */     this.leftleg3.setTextureSize(512, 256);
/* 123 */     this.leftleg3.mirror = true;
/* 124 */     setRotation(this.leftleg3, -0.5235988F, 0.0F, 0.0F);
/* 125 */     this.tail2 = new ModelRenderer(this, 400, 103);
/* 126 */     this.tail2.addBox(-4.0F, -4.0F, 0.0F, 8, 10, 12);
/* 127 */     this.tail2.setRotationPoint(0.0F, -4.0F, 35.0F);
/* 128 */     this.tail2.setTextureSize(512, 256);
/* 129 */     this.tail2.mirror = true;
/* 130 */     setRotation(this.tail2, -0.1396263F, 0.0F, 0.0F);
/* 131 */     this.tail3 = new ModelRenderer(this, 400, 127);
/* 132 */     this.tail3.addBox(-3.0F, -3.0F, 0.0F, 6, 8, 12);
/* 133 */     this.tail3.setRotationPoint(0.0F, -3.0F, 46.0F);
/* 134 */     this.tail3.setTextureSize(512, 256);
/* 135 */     this.tail3.mirror = true;
/* 136 */     setRotation(this.tail3, -0.1396263F, 0.0F, 0.0F);
/* 137 */     this.lclaw2 = new ModelRenderer(this, 300, 76);
/* 138 */     this.lclaw2.addBox(-1.0F, -1.0F, -6.0F, 4, 4, 13);
/* 139 */     this.lclaw2.setRotationPoint(7.0F, 21.0F, 11.0F);
/* 140 */     this.lclaw2.setTextureSize(512, 256);
/* 141 */     this.lclaw2.mirror = true;
/* 142 */     setRotation(this.lclaw2, 0.0F, 0.0F, 0.0F);
/* 143 */     this.lclaw3 = new ModelRenderer(this, 300, 95);
/* 144 */     this.lclaw3.addBox(2.0F, 0.0F, -6.0F, 2, 3, 10);
/* 145 */     this.lclaw3.setRotationPoint(7.0F, 21.0F, 11.0F);
/* 146 */     this.lclaw3.setTextureSize(512, 256);
/* 147 */     this.lclaw3.mirror = true;
/* 148 */     setRotation(this.lclaw3, 0.0F, -0.6632251F, 0.0F);
/* 149 */     this.lclaw4 = new ModelRenderer(this, 308, 123);
/* 150 */     this.lclaw4.addBox(0.0F, 0.0F, -10.0F, 2, 3, 4);
/* 151 */     this.lclaw4.setRotationPoint(7.0F, 21.0F, 11.0F);
/* 152 */     this.lclaw4.setTextureSize(512, 256);
/* 153 */     this.lclaw4.mirror = true;
/* 154 */     setRotation(this.lclaw4, 0.0F, 0.0F, 0.0F);
/* 155 */     this.lclaw5 = new ModelRenderer(this, 300, 123);
/* 156 */     this.lclaw5.addBox(-2.5F, 1.0F, -5.0F, 1, 2, 2);
/* 157 */     this.lclaw5.setRotationPoint(7.0F, 21.0F, 11.0F);
/* 158 */     this.lclaw5.setTextureSize(512, 256);
/* 159 */     this.lclaw5.mirror = true;
/* 160 */     setRotation(this.lclaw5, 0.0F, 0.6632251F, 0.0F);
/* 161 */     this.lclaw6 = new ModelRenderer(this, 322, 123);
/* 162 */     this.lclaw6.addBox(2.5F, 1.0F, -9.0F, 1, 2, 3);
/* 163 */     this.lclaw6.setRotationPoint(7.0F, 21.0F, 11.0F);
/* 164 */     this.lclaw6.setTextureSize(512, 256);
/* 165 */     this.lclaw6.mirror = true;
/* 166 */     setRotation(this.lclaw6, 0.0F, -0.6632251F, 0.0F);
/* 167 */     this.lclaw7 = new ModelRenderer(this, 333, 123);
/* 168 */     this.lclaw7.addBox(0.0F, 1.0F, 7.0F, 1, 2, 3);
/* 169 */     this.lclaw7.setRotationPoint(7.0F, 21.0F, 11.0F);
/* 170 */     this.lclaw7.setTextureSize(512, 256);
/* 171 */     this.lclaw7.mirror = true;
/* 172 */     setRotation(this.lclaw7, 0.0F, 0.0F, 0.0F);
/* 173 */     this.neck3 = new ModelRenderer(this, 375, 23);
/* 174 */     this.neck3.addBox(-3.0F, -3.0F, -6.0F, 6, 6, 8);
/* 175 */     this.neck3.setRotationPoint(0.0F, -24.0F, -9.0F);
/* 176 */     this.neck3.setTextureSize(512, 256);
/* 177 */     this.neck3.mirror = true;
/* 178 */     setRotation(this.neck3, -0.2443461F, 0.0F, 0.0F);
/* 179 */     this.head3 = new ModelRenderer(this, 130, 32);
/* 180 */     this.head3.addBox(-3.0F, -6.0F, -15.0F, 6, 6, 17);
/* 181 */     this.head3.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 182 */     this.head3.setTextureSize(512, 256);
/* 183 */     this.head3.mirror = true;
/* 184 */     setRotation(this.head3, -0.2443461F, 0.0F, 0.0F);
/* 185 */     this.jaw1 = new ModelRenderer(this, 143, 114);
/* 186 */     this.jaw1.addBox(-3.0F, 1.0F, -14.0F, 6, 3, 15);
/* 187 */     this.jaw1.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 188 */     this.jaw1.setTextureSize(512, 256);
/* 189 */     this.jaw1.mirror = true;
/* 190 */     setRotation(this.jaw1, 0.1919862F, 0.0F, 0.0F);
/* 191 */     this.tooth1 = new ModelRenderer(this, 0, 0);
/* 192 */     this.tooth1.addBox(-3.0F, 0.0F, -14.0F, 1, 3, 1);
/* 193 */     this.tooth1.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 194 */     this.tooth1.setTextureSize(512, 256);
/* 195 */     this.tooth1.mirror = true;
/* 196 */     setRotation(this.tooth1, -0.2443461F, 0.0F, 0.0F);
/* 197 */     this.tooth2 = new ModelRenderer(this, 0, 0);
/* 198 */     this.tooth2.addBox(-0.5F, 0.0F, -14.0F, 1, 2, 1);
/* 199 */     this.tooth2.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 200 */     this.tooth2.setTextureSize(512, 256);
/* 201 */     this.tooth2.mirror = true;
/* 202 */     setRotation(this.tooth2, -0.2443461F, 0.0F, 0.0F);
/* 203 */     this.tooth3 = new ModelRenderer(this, 0, 0);
/* 204 */     this.tooth3.addBox(2.0F, 0.0F, -14.0F, 1, 3, 1);
/* 205 */     this.tooth3.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 206 */     this.tooth3.setTextureSize(512, 256);
/* 207 */     this.tooth3.mirror = true;
/* 208 */     setRotation(this.tooth3, -0.2443461F, 0.0F, 0.0F);
/* 209 */     this.tooth4 = new ModelRenderer(this, 0, 0);
/* 210 */     this.tooth4.addBox(-2.0F, 0.0F, -12.0F, 1, 3, 1);
/* 211 */     this.tooth4.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 212 */     this.tooth4.setTextureSize(512, 256);
/* 213 */     this.tooth4.mirror = true;
/* 214 */     setRotation(this.tooth4, -0.2443461F, 0.0F, 0.0F);
/* 215 */     this.tooth5 = new ModelRenderer(this, 0, 0);
/* 216 */     this.tooth5.addBox(1.0F, 0.0F, -12.0F, 1, 3, 1);
/* 217 */     this.tooth5.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 218 */     this.tooth5.setTextureSize(512, 256);
/* 219 */     this.tooth5.mirror = true;
/* 220 */     setRotation(this.tooth5, -0.2443461F, 0.0F, 0.0F);
/* 221 */     this.jaw5 = new ModelRenderer(this, 151, 135);
/* 222 */     this.jaw5.addBox(-4.0F, 1.0F, -4.0F, 8, 4, 7);
/* 223 */     this.jaw5.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 224 */     this.jaw5.setTextureSize(512, 256);
/* 225 */     this.jaw5.mirror = true;
/* 226 */     setRotation(this.jaw5, 0.1919862F, 0.0F, 0.0F);
/* 227 */     this.head7 = new ModelRenderer(this, 185, 34);
/* 228 */     this.head7.addBox(-4.0F, -7.0F, -3.0F, 8, 7, 10);
/* 229 */     this.head7.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 230 */     this.head7.setTextureSize(512, 256);
/* 231 */     this.head7.mirror = true;
/* 232 */     setRotation(this.head7, -0.2443461F, 0.0F, 0.0F);
/* 233 */     this.tooth6 = new ModelRenderer(this, 0, 0);
/* 234 */     this.tooth6.addBox(-3.0F, 0.0F, -10.0F, 1, 2, 1);
/* 235 */     this.tooth6.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 236 */     this.tooth6.setTextureSize(512, 256);
/* 237 */     this.tooth6.mirror = true;
/* 238 */     setRotation(this.tooth6, -0.2443461F, 0.0F, 0.0F);
/* 239 */     this.tooth7 = new ModelRenderer(this, 0, 0);
/* 240 */     this.tooth7.addBox(2.0F, 0.0F, -10.0F, 1, 2, 1);
/* 241 */     this.tooth7.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 242 */     this.tooth7.setTextureSize(512, 256);
/* 243 */     this.tooth7.mirror = true;
/* 244 */     setRotation(this.tooth7, -0.2443461F, 0.0F, 0.0F);
/* 245 */     this.tooth8 = new ModelRenderer(this, 0, 0);
/* 246 */     this.tooth8.addBox(-2.0F, 0.0F, -8.0F, 1, 2, 1);
/* 247 */     this.tooth8.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 248 */     this.tooth8.setTextureSize(512, 256);
/* 249 */     this.tooth8.mirror = true;
/* 250 */     setRotation(this.tooth8, -0.2443461F, 0.0F, 0.0F);
/* 251 */     this.tooth9 = new ModelRenderer(this, 0, 0);
/* 252 */     this.tooth9.addBox(1.0F, 0.0F, -8.0F, 1, 2, 1);
/* 253 */     this.tooth9.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 254 */     this.tooth9.setTextureSize(512, 256);
/* 255 */     this.tooth9.mirror = true;
/* 256 */     setRotation(this.tooth9, -0.2443461F, 0.0F, 0.0F);
/* 257 */     this.tooth10 = new ModelRenderer(this, 0, 0);
/* 258 */     this.tooth10.addBox(-3.0F, 0.0F, -6.0F, 1, 2, 1);
/* 259 */     this.tooth10.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 260 */     this.tooth10.setTextureSize(512, 256);
/* 261 */     this.tooth10.mirror = true;
/* 262 */     setRotation(this.tooth10, -0.2443461F, 0.0F, 0.0F);
/* 263 */     this.tooth11 = new ModelRenderer(this, 0, 0);
/* 264 */     this.tooth11.addBox(2.0F, 0.0F, -6.0F, 1, 2, 1);
/* 265 */     this.tooth11.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 266 */     this.tooth11.setTextureSize(512, 256);
/* 267 */     this.tooth11.mirror = true;
/* 268 */     setRotation(this.tooth11, -0.2443461F, 0.0F, 0.0F);
/* 269 */     this.tooth12 = new ModelRenderer(this, 0, 0);
/* 270 */     this.tooth12.addBox(-2.0F, 0.0F, -4.0F, 1, 1, 1);
/* 271 */     this.tooth12.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 272 */     this.tooth12.setTextureSize(512, 256);
/* 273 */     this.tooth12.mirror = true;
/* 274 */     setRotation(this.tooth12, -0.2443461F, 0.0F, 0.0F);
/* 275 */     this.tooth13 = new ModelRenderer(this, -1, 0);
/* 276 */     this.tooth13.addBox(1.0F, 0.0F, -4.0F, 1, 1, 1);
/* 277 */     this.tooth13.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 278 */     this.tooth13.setTextureSize(512, 256);
/* 279 */     this.tooth13.mirror = true;
/* 280 */     setRotation(this.tooth13, -0.2443461F, 0.0F, 0.0F);
/* 281 */     this.rightleg1 = new ModelRenderer(this, 246, 0);
/* 282 */     this.rightleg1.addBox(-2.0F, -4.0F, -21.0F, 6, 11, 11);
/* 283 */     this.rightleg1.setRotationPoint(-10.0F, 2.0F, 26.0F);
/* 284 */     this.rightleg1.setTextureSize(512, 256);
/* 285 */     this.rightleg1.mirror = true;
/* 286 */     setRotation(this.rightleg1, -0.5934119F, 0.0F, 0.0F);
/* 287 */     this.rightleg2 = new ModelRenderer(this, 250, 24);
/* 288 */     this.rightleg2.addBox(-1.0F, -10.0F, -5.0F, 5, 13, 7);
/* 289 */     this.rightleg2.setRotationPoint(-10.0F, 2.0F, 26.0F);
/* 290 */     this.rightleg2.setTextureSize(512, 256);
/* 291 */     this.rightleg2.mirror = true;
/* 292 */     setRotation(this.rightleg2, 0.9773844F, 0.0F, 0.0F);
/* 293 */     this.tooth14 = new ModelRenderer(this, 0, 0);
/* 294 */     this.tooth14.addBox(0.5F, -2.0F, -14.0F, 1, 3, 1);
/* 295 */     this.tooth14.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 296 */     this.tooth14.setTextureSize(512, 256);
/* 297 */     this.tooth14.mirror = true;
/* 298 */     setRotation(this.tooth14, 0.1919862F, 0.0F, 0.0F);
/* 299 */     this.tooth15 = new ModelRenderer(this, 0, 0);
/* 300 */     this.tooth15.addBox(-1.5F, -2.0F, -14.0F, 1, 3, 1);
/* 301 */     this.tooth15.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 302 */     this.tooth15.setTextureSize(512, 256);
/* 303 */     this.tooth15.mirror = true;
/* 304 */     setRotation(this.tooth15, 0.1919862F, 0.0F, 0.0F);
/* 305 */     this.tooth16 = new ModelRenderer(this, 0, 0);
/* 306 */     this.tooth16.addBox(2.0F, -1.0F, -12.0F, 1, 2, 1);
/* 307 */     this.tooth16.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 308 */     this.tooth16.setTextureSize(512, 256);
/* 309 */     this.tooth16.mirror = true;
/* 310 */     setRotation(this.tooth16, 0.1919862F, 0.0F, 0.0F);
/* 311 */     this.tooth17 = new ModelRenderer(this, 0, 0);
/* 312 */     this.tooth17.addBox(-3.0F, -1.0F, -12.0F, 1, 2, 1);
/* 313 */     this.tooth17.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 314 */     this.tooth17.setTextureSize(512, 256);
/* 315 */     this.tooth17.mirror = true;
/* 316 */     setRotation(this.tooth17, 0.1919862F, 0.0F, 0.0F);
/* 317 */     this.tooth18 = new ModelRenderer(this, 0, 0);
/* 318 */     this.tooth18.addBox(1.0F, -1.0F, -10.0F, 1, 2, 1);
/* 319 */     this.tooth18.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 320 */     this.tooth18.setTextureSize(512, 256);
/* 321 */     this.tooth18.mirror = true;
/* 322 */     setRotation(this.tooth18, 0.1919862F, 0.0F, 0.0F);
/* 323 */     this.tooth19 = new ModelRenderer(this, 0, 0);
/* 324 */     this.tooth19.addBox(-2.0F, -1.0F, -10.0F, 1, 2, 1);
/* 325 */     this.tooth19.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 326 */     this.tooth19.setTextureSize(512, 256);
/* 327 */     this.tooth19.mirror = true;
/* 328 */     setRotation(this.tooth19, 0.1919862F, 0.0F, 0.0F);
/* 329 */     this.tooth20 = new ModelRenderer(this, 0, 0);
/* 330 */     this.tooth20.addBox(-3.0F, -1.0F, -8.0F, 1, 2, 1);
/* 331 */     this.tooth20.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 332 */     this.tooth20.setTextureSize(512, 256);
/* 333 */     this.tooth20.mirror = true;
/* 334 */     setRotation(this.tooth20, 0.1919862F, 0.0F, 0.0F);
/* 335 */     this.tooth21 = new ModelRenderer(this, 0, 0);
/* 336 */     this.tooth21.addBox(2.0F, -1.0F, -8.0F, 1, 2, 1);
/* 337 */     this.tooth21.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 338 */     this.tooth21.setTextureSize(512, 256);
/* 339 */     this.tooth21.mirror = true;
/* 340 */     setRotation(this.tooth21, 0.1919862F, 0.0F, 0.0F);
/* 341 */     this.tooth22 = new ModelRenderer(this, 0, 0);
/* 342 */     this.tooth22.addBox(1.0F, 0.0F, -6.0F, 1, 1, 1);
/* 343 */     this.tooth22.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 344 */     this.tooth22.setTextureSize(512, 256);
/* 345 */     this.tooth22.mirror = true;
/* 346 */     setRotation(this.tooth22, 0.1919862F, 0.0F, 0.0F);
/* 347 */     this.tooth23 = new ModelRenderer(this, 0, 0);
/* 348 */     this.tooth23.addBox(-2.0F, 0.0F, -6.0F, 1, 1, 1);
/* 349 */     this.tooth23.setRotationPoint(0.0F, -26.0F, -14.0F);
/* 350 */     this.tooth23.setTextureSize(512, 256);
/* 351 */     this.tooth23.mirror = true;
/* 352 */     setRotation(this.tooth23, 0.1919862F, 0.0F, 0.0F);
/* 353 */     this.rightleg3 = new ModelRenderer(this, 250, 47);
/* 354 */     this.rightleg3.addBox(-2.0F, -19.0F, 0.0F, 4, 18, 6);
/* 355 */     this.rightleg3.setRotationPoint(-8.0F, 21.0F, 11.0F);
/* 356 */     this.rightleg3.setTextureSize(512, 256);
/* 357 */     this.rightleg3.mirror = true;
/* 358 */     setRotation(this.rightleg3, -0.5235988F, 0.0F, 0.0F);
/* 359 */     this.rclaw2 = new ModelRenderer(this, 250, 76);
/* 360 */     this.rclaw2.addBox(-2.0F, -1.0F, -6.0F, 4, 4, 13);
/* 361 */     this.rclaw2.setRotationPoint(-8.0F, 21.0F, 11.0F);
/* 362 */     this.rclaw2.setTextureSize(512, 256);
/* 363 */     this.rclaw2.mirror = true;
/* 364 */     setRotation(this.rclaw2, 0.0F, 0.0F, 0.0F);
/* 365 */     this.rclaw4 = new ModelRenderer(this, 247, 123);
/* 366 */     this.rclaw4.addBox(-1.0F, 0.0F, -10.0F, 2, 3, 4);
/* 367 */     this.rclaw4.setRotationPoint(-8.0F, 21.0F, 11.0F);
/* 368 */     this.rclaw4.setTextureSize(512, 256);
/* 369 */     this.rclaw4.mirror = true;
/* 370 */     setRotation(this.rclaw4, 0.0F, 0.0F, 0.0F);
/* 371 */     this.rclaw1 = new ModelRenderer(this, 250, 111);
/* 372 */     this.rclaw1.addBox(2.0F, 0.0F, -3.0F, 2, 3, 6);
/* 373 */     this.rclaw1.setRotationPoint(-8.0F, 21.0F, 11.0F);
/* 374 */     this.rclaw1.setTextureSize(512, 256);
/* 375 */     this.rclaw1.mirror = true;
/* 376 */     setRotation(this.rclaw1, 0.0F, -0.6632251F, 0.0F);
/* 377 */     this.rclaw5 = new ModelRenderer(this, 261, 123);
/* 378 */     this.rclaw5.addBox(2.5F, 1.0F, -5.0F, 1, 2, 2);
/* 379 */     this.rclaw5.setRotationPoint(-8.0F, 21.0F, 11.0F);
/* 380 */     this.rclaw5.setTextureSize(512, 256);
/* 381 */     this.rclaw5.mirror = true;
/* 382 */     setRotation(this.rclaw5, 0.0F, -0.6632251F, 0.0F);
/* 383 */     this.rclaw7 = new ModelRenderer(this, 283, 123);
/* 384 */     this.rclaw7.addBox(0.0F, 1.0F, 7.0F, 1, 2, 3);
/* 385 */     this.rclaw7.setRotationPoint(-8.0F, 21.0F, 11.0F);
/* 386 */     this.rclaw7.setTextureSize(512, 256);
/* 387 */     this.rclaw7.mirror = true;
/* 388 */     setRotation(this.rclaw7, 0.0F, 0.0F, 0.0F);
/* 389 */     this.rclaw3 = new ModelRenderer(this, 250, 95);
/* 390 */     this.rclaw3.addBox(-3.0F, 0.0F, -6.0F, 2, 3, 10);
/* 391 */     this.rclaw3.setRotationPoint(-8.0F, 21.0F, 11.0F);
/* 392 */     this.rclaw3.setTextureSize(512, 256);
/* 393 */     this.rclaw3.mirror = true;
/* 394 */     setRotation(this.rclaw3, 0.0F, 0.6632251F, 0.0F);
/* 395 */     this.rclaw6 = new ModelRenderer(this, 270, 123);
/* 396 */     this.rclaw6.addBox(-2.5F, 1.0F, -9.0F, 1, 2, 3);
/* 397 */     this.rclaw6.setRotationPoint(-8.0F, 21.0F, 11.0F);
/* 398 */     this.rclaw6.setTextureSize(512, 256);
/* 399 */     this.rclaw6.mirror = true;
/* 400 */     setRotation(this.rclaw6, 0.0F, 0.6632251F, 0.0F);
/* 401 */     this.neck1 = new ModelRenderer(this, 45, 0);
/* 402 */     this.neck1.addBox(-5.0F, -6.0F, -14.0F, 10, 12, 15);
/* 403 */     this.neck1.setRotationPoint(0.0F, -9.0F, 5.0F);
/* 404 */     this.neck1.setTextureSize(512, 256);
/* 405 */     this.neck1.mirror = true;
/* 406 */     setRotation(this.neck1, -0.837758F, 0.0F, 0.0F);
/* 407 */     this.neck2 = new ModelRenderer(this, 48, 29);
/* 408 */     this.neck2.addBox(-4.5F, -4.0F, -10.0F, 9, 9, 10);
/* 409 */     this.neck2.setRotationPoint(0.0F, -19.0F, -2.0F);
/* 410 */     this.neck2.setTextureSize(512, 256);
/* 411 */     this.neck2.mirror = true;
/* 412 */     setRotation(this.neck2, -0.7853982F, 0.0F, 0.0F);
/* 413 */     this.tail4 = new ModelRenderer(this, 400, 150);
/* 414 */     this.tail4.addBox(-2.0F, -3.0F, 0.0F, 4, 6, 16);
/* 415 */     this.tail4.setRotationPoint(0.0F, -1.0F, 56.0F);
/* 416 */     this.tail4.setTextureSize(512, 256);
/* 417 */     this.tail4.mirror = true;
/* 418 */     setRotation(this.tail4, -0.1396263F, 0.0F, 0.0F);
/* 419 */     this.Spike1 = new ModelRenderer(this, 0, 100);
/* 420 */     this.Spike1.addBox(-2.0F, -16.0F, -1.0F, 4, 16, 18);
/* 421 */     this.Spike1.setRotationPoint(0.0F, -4.0F, 7.0F);
/* 422 */     this.Spike1.setTextureSize(512, 256);
/* 423 */     this.Spike1.mirror = true;
/* 424 */     setRotation(this.Spike1, 0.5061455F, 0.0F, 0.0F);
/* 425 */     this.Spike2 = new ModelRenderer(this, 0, 72);
/* 426 */     this.Spike2.addBox(-1.5F, -12.0F, 0.0F, 3, 12, 10);
/* 427 */     this.Spike2.setRotationPoint(0.0F, 0.0F, 29.0F);
/* 428 */     this.Spike2.setTextureSize(512, 256);
/* 429 */     this.Spike2.mirror = true;
/* 430 */     setRotation(this.Spike2, 0.4886922F, 0.0F, 0.0F);
/* 431 */     this.Spike3 = new ModelRenderer(this, 0, 44);
/* 432 */     this.Spike3.addBox(-1.0F, -7.0F, 0.0F, 2, 8, 7);
/* 433 */     this.Spike3.setRotationPoint(0.0F, -2.0F, 41.0F);
/* 434 */     this.Spike3.setTextureSize(512, 256);
/* 435 */     this.Spike3.mirror = true;
/* 436 */     setRotation(this.Spike3, 0.5934119F, 0.0F, 0.0F);
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: checkcast danger/orespawn/entity/Nastysaurus
/*     */     //   4: astore #8
/*     */     //   6: aconst_null
/*     */     //   7: astore #9
/*     */     //   9: aload_0
/*     */     //   10: aload_1
/*     */     //   11: fload_2
/*     */     //   12: fload_3
/*     */     //   13: fload #4
/*     */     //   15: fload #5
/*     */     //   17: fload #6
/*     */     //   19: fload #7
/*     */     //   21: invokespecial render : (Lnet/minecraft/entity/Entity;FFFFFF)V
/*     */     //   24: aload_0
/*     */     //   25: fload_2
/*     */     //   26: fload_3
/*     */     //   27: fload #4
/*     */     //   29: fload #5
/*     */     //   31: fload #6
/*     */     //   33: fload #7
/*     */     //   35: aload_1
/*     */     //   36: invokevirtual setRotationAngles : (FFFFFFLnet/minecraft/entity/Entity;)V
/*     */     //   39: fconst_0
/*     */     //   40: fstore #10
/*     */     //   42: fconst_2
/*     */     //   43: fstore #11
/*     */     //   45: fconst_0
/*     */     //   46: fstore #12
/*     */     //   48: fconst_0
/*     */     //   49: fstore #13
/*     */     //   51: ldc_w 15.0
/*     */     //   54: fstore #14
/*     */     //   56: ldc 21.0
/*     */     //   58: fstore #15
/*     */     //   60: ldc_w 5.0
/*     */     //   63: fload #11
/*     */     //   65: fmul
/*     */     //   66: fstore #16
/*     */     //   68: fconst_2
/*     */     //   69: fload #11
/*     */     //   71: fmul
/*     */     //   72: fstore #17
/*     */     //   74: ldc_w 0.7853982
/*     */     //   77: fstore #20
/*     */     //   79: aload #8
/*     */     //   81: invokevirtual getRenderInfo : ()Ldanger/orespawn/entity/RenderInfo;
/*     */     //   84: astore #9
/*     */     //   86: fload #5
/*     */     //   88: ldc_w 360.0
/*     */     //   91: frem
/*     */     //   92: fstore #5
/*     */     //   94: fload #5
/*     */     //   96: ldc_w 0.35
/*     */     //   99: fmul
/*     */     //   100: dup
/*     */     //   101: fstore #5
/*     */     //   103: fstore #5
/*     */     //   105: aload_0
/*     */     //   106: getfield neck2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   109: fload #5
/*     */     //   111: f2d
/*     */     //   112: invokestatic toRadians : (D)D
/*     */     //   115: d2f
/*     */     //   116: ldc 0.5
/*     */     //   118: fmul
/*     */     //   119: putfield rotateAngleY : F
/*     */     //   122: aload_0
/*     */     //   123: getfield head3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   126: fload #5
/*     */     //   128: f2d
/*     */     //   129: invokestatic toRadians : (D)D
/*     */     //   132: d2f
/*     */     //   133: putfield rotateAngleY : F
/*     */     //   136: aload_0
/*     */     //   137: getfield neck3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   140: aload_0
/*     */     //   141: getfield head7 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   144: aload_0
/*     */     //   145: getfield head3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   148: getfield rotateAngleY : F
/*     */     //   151: dup_x1
/*     */     //   152: putfield rotateAngleY : F
/*     */     //   155: putfield rotateAngleY : F
/*     */     //   158: aload_0
/*     */     //   159: getfield jaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   162: aload_0
/*     */     //   163: getfield jaw5 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   166: aload_0
/*     */     //   167: getfield head3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   170: getfield rotateAngleY : F
/*     */     //   173: dup_x1
/*     */     //   174: putfield rotateAngleY : F
/*     */     //   177: putfield rotateAngleY : F
/*     */     //   180: aload_0
/*     */     //   181: getfield tooth1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   184: aload_0
/*     */     //   185: getfield tooth2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   188: aload_0
/*     */     //   189: getfield tooth3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   192: aload_0
/*     */     //   193: getfield tooth4 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   196: aload_0
/*     */     //   197: getfield tooth5 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   200: aload_0
/*     */     //   201: getfield head3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   204: getfield rotateAngleY : F
/*     */     //   207: dup_x1
/*     */     //   208: putfield rotateAngleY : F
/*     */     //   211: dup_x1
/*     */     //   212: putfield rotateAngleY : F
/*     */     //   215: dup_x1
/*     */     //   216: putfield rotateAngleY : F
/*     */     //   219: dup_x1
/*     */     //   220: putfield rotateAngleY : F
/*     */     //   223: putfield rotateAngleY : F
/*     */     //   226: aload_0
/*     */     //   227: getfield tooth6 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   230: aload_0
/*     */     //   231: getfield tooth7 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   234: aload_0
/*     */     //   235: getfield tooth8 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   238: aload_0
/*     */     //   239: getfield tooth9 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   242: aload_0
/*     */     //   243: getfield tooth10 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   246: aload_0
/*     */     //   247: getfield head3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   250: getfield rotateAngleY : F
/*     */     //   253: dup_x1
/*     */     //   254: putfield rotateAngleY : F
/*     */     //   257: dup_x1
/*     */     //   258: putfield rotateAngleY : F
/*     */     //   261: dup_x1
/*     */     //   262: putfield rotateAngleY : F
/*     */     //   265: dup_x1
/*     */     //   266: putfield rotateAngleY : F
/*     */     //   269: putfield rotateAngleY : F
/*     */     //   272: aload_0
/*     */     //   273: getfield tooth11 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   276: aload_0
/*     */     //   277: getfield tooth12 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   280: aload_0
/*     */     //   281: getfield tooth13 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   284: aload_0
/*     */     //   285: getfield tooth14 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   288: aload_0
/*     */     //   289: getfield tooth15 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   292: aload_0
/*     */     //   293: getfield head3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   296: getfield rotateAngleY : F
/*     */     //   299: dup_x1
/*     */     //   300: putfield rotateAngleY : F
/*     */     //   303: dup_x1
/*     */     //   304: putfield rotateAngleY : F
/*     */     //   307: dup_x1
/*     */     //   308: putfield rotateAngleY : F
/*     */     //   311: dup_x1
/*     */     //   312: putfield rotateAngleY : F
/*     */     //   315: putfield rotateAngleY : F
/*     */     //   318: aload_0
/*     */     //   319: getfield tooth16 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   322: aload_0
/*     */     //   323: getfield tooth17 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   326: aload_0
/*     */     //   327: getfield tooth18 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   330: aload_0
/*     */     //   331: getfield tooth19 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   334: aload_0
/*     */     //   335: getfield tooth20 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   338: aload_0
/*     */     //   339: getfield head3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   342: getfield rotateAngleY : F
/*     */     //   345: dup_x1
/*     */     //   346: putfield rotateAngleY : F
/*     */     //   349: dup_x1
/*     */     //   350: putfield rotateAngleY : F
/*     */     //   353: dup_x1
/*     */     //   354: putfield rotateAngleY : F
/*     */     //   357: dup_x1
/*     */     //   358: putfield rotateAngleY : F
/*     */     //   361: putfield rotateAngleY : F
/*     */     //   364: aload_0
/*     */     //   365: getfield tooth21 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   368: aload_0
/*     */     //   369: getfield tooth22 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   372: aload_0
/*     */     //   373: getfield tooth23 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   376: aload_0
/*     */     //   377: getfield head3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   380: getfield rotateAngleY : F
/*     */     //   383: dup_x1
/*     */     //   384: putfield rotateAngleY : F
/*     */     //   387: dup_x1
/*     */     //   388: putfield rotateAngleY : F
/*     */     //   391: putfield rotateAngleY : F
/*     */     //   394: aload #8
/*     */     //   396: invokevirtual getAttacking : ()I
/*     */     //   399: ifeq -> 436
/*     */     //   402: fload #4
/*     */     //   404: ldc_w 0.85
/*     */     //   407: fmul
/*     */     //   408: aload_0
/*     */     //   409: getfield wingspeed : F
/*     */     //   412: fmul
/*     */     //   413: invokestatic cos : (F)F
/*     */     //   416: ldc_w 3.1415927
/*     */     //   419: fmul
/*     */     //   420: ldc_w 0.16
/*     */     //   423: fmul
/*     */     //   424: fstore #10
/*     */     //   426: fload #10
/*     */     //   428: ldc 0.5
/*     */     //   430: fadd
/*     */     //   431: fstore #10
/*     */     //   433: goto -> 562
/*     */     //   436: fload #4
/*     */     //   438: ldc_w 0.7
/*     */     //   441: fmul
/*     */     //   442: aload_0
/*     */     //   443: getfield wingspeed : F
/*     */     //   446: fmul
/*     */     //   447: ldc_w 6.2831855
/*     */     //   450: frem
/*     */     //   451: fstore #10
/*     */     //   453: fload #10
/*     */     //   455: invokestatic abs : (F)F
/*     */     //   458: fstore #10
/*     */     //   460: fload #10
/*     */     //   462: aload #9
/*     */     //   464: getfield rf1 : F
/*     */     //   467: fcmpg
/*     */     //   468: ifge -> 505
/*     */     //   471: aload #9
/*     */     //   473: iconst_0
/*     */     //   474: putfield ri1 : I
/*     */     //   477: aload #8
/*     */     //   479: getfield world : Lnet/minecraft/world/World;
/*     */     //   482: getfield rand : Ljava/util/Random;
/*     */     //   485: bipush #20
/*     */     //   487: invokevirtual nextInt : (I)I
/*     */     //   490: iconst_1
/*     */     //   491: if_icmpne -> 505
/*     */     //   494: aload #9
/*     */     //   496: dup
/*     */     //   497: getfield ri1 : I
/*     */     //   500: iconst_1
/*     */     //   501: ior
/*     */     //   502: putfield ri1 : I
/*     */     //   505: aload #9
/*     */     //   507: fload #10
/*     */     //   509: putfield rf1 : F
/*     */     //   512: aload #9
/*     */     //   514: getfield ri1 : I
/*     */     //   517: ifeq -> 554
/*     */     //   520: fload #4
/*     */     //   522: ldc_w 0.85
/*     */     //   525: fmul
/*     */     //   526: aload_0
/*     */     //   527: getfield wingspeed : F
/*     */     //   530: fmul
/*     */     //   531: invokestatic sin : (F)F
/*     */     //   534: ldc_w 3.1415927
/*     */     //   537: fmul
/*     */     //   538: ldc_w 0.16
/*     */     //   541: fmul
/*     */     //   542: fstore #10
/*     */     //   544: fload #10
/*     */     //   546: ldc 0.5
/*     */     //   548: fadd
/*     */     //   549: fstore #10
/*     */     //   551: goto -> 562
/*     */     //   554: fload #20
/*     */     //   556: ldc_w 4.0
/*     */     //   559: fdiv
/*     */     //   560: fstore #10
/*     */     //   562: aload_0
/*     */     //   563: getfield jaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   566: aload_0
/*     */     //   567: getfield jaw5 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   570: fload #10
/*     */     //   572: dup_x1
/*     */     //   573: putfield rotateAngleX : F
/*     */     //   576: putfield rotateAngleX : F
/*     */     //   579: aload_0
/*     */     //   580: getfield tooth14 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   583: aload_0
/*     */     //   584: getfield tooth15 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   587: fload #10
/*     */     //   589: dup_x1
/*     */     //   590: putfield rotateAngleX : F
/*     */     //   593: putfield rotateAngleX : F
/*     */     //   596: aload_0
/*     */     //   597: getfield tooth16 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   600: aload_0
/*     */     //   601: getfield tooth17 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   604: aload_0
/*     */     //   605: getfield tooth18 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   608: aload_0
/*     */     //   609: getfield tooth19 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   612: aload_0
/*     */     //   613: getfield tooth20 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   616: fload #10
/*     */     //   618: dup_x1
/*     */     //   619: putfield rotateAngleX : F
/*     */     //   622: dup_x1
/*     */     //   623: putfield rotateAngleX : F
/*     */     //   626: dup_x1
/*     */     //   627: putfield rotateAngleX : F
/*     */     //   630: dup_x1
/*     */     //   631: putfield rotateAngleX : F
/*     */     //   634: putfield rotateAngleX : F
/*     */     //   637: aload_0
/*     */     //   638: getfield tooth21 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   641: aload_0
/*     */     //   642: getfield tooth22 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   645: aload_0
/*     */     //   646: getfield tooth23 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   649: fload #10
/*     */     //   651: dup_x1
/*     */     //   652: putfield rotateAngleX : F
/*     */     //   655: dup_x1
/*     */     //   656: putfield rotateAngleX : F
/*     */     //   659: putfield rotateAngleX : F
/*     */     //   662: fconst_0
/*     */     //   663: fstore #18
/*     */     //   665: fconst_0
/*     */     //   666: fstore #19
/*     */     //   668: fload_3
/*     */     //   669: f2d
/*     */     //   670: ldc2_w 0.001
/*     */     //   673: dcmpl
/*     */     //   674: ifle -> 710
/*     */     //   677: fload #4
/*     */     //   679: aload_0
/*     */     //   680: getfield wingspeed : F
/*     */     //   683: fmul
/*     */     //   684: fload #11
/*     */     //   686: fdiv
/*     */     //   687: invokestatic cos : (F)F
/*     */     //   690: fstore #10
/*     */     //   692: fload #4
/*     */     //   694: aload_0
/*     */     //   695: getfield wingspeed : F
/*     */     //   698: fmul
/*     */     //   699: fload #11
/*     */     //   701: fdiv
/*     */     //   702: invokestatic sin : (F)F
/*     */     //   705: fstore #18
/*     */     //   707: goto -> 719
/*     */     //   710: fconst_0
/*     */     //   711: fstore #10
/*     */     //   713: fconst_0
/*     */     //   714: fstore #18
/*     */     //   716: fconst_0
/*     */     //   717: fstore #19
/*     */     //   719: fload #18
/*     */     //   721: fconst_0
/*     */     //   722: fcmpl
/*     */     //   723: ifle -> 750
/*     */     //   726: fload #18
/*     */     //   728: fload #17
/*     */     //   730: fmul
/*     */     //   731: fload_3
/*     */     //   732: fmul
/*     */     //   733: fstore #19
/*     */     //   735: aload_0
/*     */     //   736: getfield lclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   739: fload #15
/*     */     //   741: fload #19
/*     */     //   743: fsub
/*     */     //   744: putfield rotationPointY : F
/*     */     //   747: goto -> 759
/*     */     //   750: aload_0
/*     */     //   751: getfield lclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   754: fload #15
/*     */     //   756: putfield rotationPointY : F
/*     */     //   759: aload_0
/*     */     //   760: getfield lclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   763: fload #14
/*     */     //   765: fload #16
/*     */     //   767: fload #10
/*     */     //   769: fmul
/*     */     //   770: fload_3
/*     */     //   771: fmul
/*     */     //   772: fadd
/*     */     //   773: putfield rotationPointZ : F
/*     */     //   776: aload_0
/*     */     //   777: getfield lclaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   780: aload_0
/*     */     //   781: getfield lclaw3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   784: aload_0
/*     */     //   785: getfield lclaw4 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   788: aload_0
/*     */     //   789: getfield lclaw5 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   792: aload_0
/*     */     //   793: getfield lclaw6 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   796: aload_0
/*     */     //   797: getfield lclaw7 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   800: aload_0
/*     */     //   801: getfield lclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   804: getfield rotationPointZ : F
/*     */     //   807: dup_x1
/*     */     //   808: putfield rotationPointZ : F
/*     */     //   811: dup_x1
/*     */     //   812: putfield rotationPointZ : F
/*     */     //   815: dup_x1
/*     */     //   816: putfield rotationPointZ : F
/*     */     //   819: dup_x1
/*     */     //   820: putfield rotationPointZ : F
/*     */     //   823: dup_x1
/*     */     //   824: putfield rotationPointZ : F
/*     */     //   827: putfield rotationPointZ : F
/*     */     //   830: aload_0
/*     */     //   831: getfield lclaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   834: aload_0
/*     */     //   835: getfield lclaw3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   838: aload_0
/*     */     //   839: getfield lclaw4 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   842: aload_0
/*     */     //   843: getfield lclaw5 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   846: aload_0
/*     */     //   847: getfield lclaw6 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   850: aload_0
/*     */     //   851: getfield lclaw7 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   854: aload_0
/*     */     //   855: getfield lclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   858: getfield rotationPointY : F
/*     */     //   861: dup_x1
/*     */     //   862: putfield rotationPointY : F
/*     */     //   865: dup_x1
/*     */     //   866: putfield rotationPointY : F
/*     */     //   869: dup_x1
/*     */     //   870: putfield rotationPointY : F
/*     */     //   873: dup_x1
/*     */     //   874: putfield rotationPointY : F
/*     */     //   877: dup_x1
/*     */     //   878: putfield rotationPointY : F
/*     */     //   881: putfield rotationPointY : F
/*     */     //   884: aload_0
/*     */     //   885: getfield leftleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   888: aload_0
/*     */     //   889: getfield lclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   892: getfield rotationPointZ : F
/*     */     //   895: putfield rotationPointZ : F
/*     */     //   898: aload_0
/*     */     //   899: getfield leftleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   902: aload_0
/*     */     //   903: getfield lclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   906: getfield rotationPointY : F
/*     */     //   909: putfield rotationPointY : F
/*     */     //   912: aload_0
/*     */     //   913: getfield leftleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   916: ldc_w -0.523
/*     */     //   919: fload #10
/*     */     //   921: ldc_w 3.1415927
/*     */     //   924: fmul
/*     */     //   925: ldc_w 0.15
/*     */     //   928: fmul
/*     */     //   929: fload_3
/*     */     //   930: fmul
/*     */     //   931: fadd
/*     */     //   932: putfield rotateAngleX : F
/*     */     //   935: aload_0
/*     */     //   936: getfield leftleg1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   939: ldc_w -0.576
/*     */     //   942: fload #10
/*     */     //   944: ldc_w 3.1415927
/*     */     //   947: fmul
/*     */     //   948: ldc_w 0.06
/*     */     //   951: fmul
/*     */     //   952: fload_3
/*     */     //   953: fmul
/*     */     //   954: fadd
/*     */     //   955: putfield rotateAngleX : F
/*     */     //   958: aload_0
/*     */     //   959: getfield leftleg2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   962: ldc_w 0.977
/*     */     //   965: fload #10
/*     */     //   967: ldc_w 3.1415927
/*     */     //   970: fmul
/*     */     //   971: ldc_w 0.06
/*     */     //   974: fmul
/*     */     //   975: fload_3
/*     */     //   976: fmul
/*     */     //   977: fadd
/*     */     //   978: putfield rotateAngleX : F
/*     */     //   981: aload_0
/*     */     //   982: getfield leftleg1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   985: aload_0
/*     */     //   986: getfield leftleg2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   989: aload_0
/*     */     //   990: getfield leftleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   993: getfield rotationPointY : F
/*     */     //   996: aload_0
/*     */     //   997: getfield leftleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1000: getfield rotateAngleX : F
/*     */     //   1003: f2d
/*     */     //   1004: invokestatic cos : (D)D
/*     */     //   1007: d2f
/*     */     //   1008: ldc_w 17.0
/*     */     //   1011: fmul
/*     */     //   1012: fsub
/*     */     //   1013: dup_x1
/*     */     //   1014: putfield rotationPointY : F
/*     */     //   1017: putfield rotationPointY : F
/*     */     //   1020: aload_0
/*     */     //   1021: getfield leftleg1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1024: aload_0
/*     */     //   1025: getfield leftleg2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1028: aload_0
/*     */     //   1029: getfield leftleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1032: getfield rotationPointZ : F
/*     */     //   1035: aload_0
/*     */     //   1036: getfield leftleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1039: getfield rotateAngleX : F
/*     */     //   1042: f2d
/*     */     //   1043: invokestatic sin : (D)D
/*     */     //   1046: d2f
/*     */     //   1047: ldc_w 17.0
/*     */     //   1050: fmul
/*     */     //   1051: fsub
/*     */     //   1052: dup_x1
/*     */     //   1053: putfield rotationPointZ : F
/*     */     //   1056: putfield rotationPointZ : F
/*     */     //   1059: fconst_0
/*     */     //   1060: fstore #18
/*     */     //   1062: fconst_0
/*     */     //   1063: fstore #19
/*     */     //   1065: fload_3
/*     */     //   1066: f2d
/*     */     //   1067: ldc2_w 0.001
/*     */     //   1070: dcmpl
/*     */     //   1071: ifle -> 1121
/*     */     //   1074: fload #4
/*     */     //   1076: aload_0
/*     */     //   1077: getfield wingspeed : F
/*     */     //   1080: fmul
/*     */     //   1081: fload #11
/*     */     //   1083: fdiv
/*     */     //   1084: fload #20
/*     */     //   1086: ldc_w 4.0
/*     */     //   1089: fmul
/*     */     //   1090: fadd
/*     */     //   1091: invokestatic cos : (F)F
/*     */     //   1094: fstore #10
/*     */     //   1096: fload #4
/*     */     //   1098: aload_0
/*     */     //   1099: getfield wingspeed : F
/*     */     //   1102: fmul
/*     */     //   1103: fload #11
/*     */     //   1105: fdiv
/*     */     //   1106: fload #20
/*     */     //   1108: ldc_w 4.0
/*     */     //   1111: fmul
/*     */     //   1112: fadd
/*     */     //   1113: invokestatic sin : (F)F
/*     */     //   1116: fstore #18
/*     */     //   1118: goto -> 1130
/*     */     //   1121: fconst_0
/*     */     //   1122: fstore #10
/*     */     //   1124: fconst_0
/*     */     //   1125: fstore #18
/*     */     //   1127: fconst_0
/*     */     //   1128: fstore #19
/*     */     //   1130: fload #18
/*     */     //   1132: fconst_0
/*     */     //   1133: fcmpl
/*     */     //   1134: ifle -> 1161
/*     */     //   1137: fload #18
/*     */     //   1139: fload #17
/*     */     //   1141: fmul
/*     */     //   1142: fload_3
/*     */     //   1143: fmul
/*     */     //   1144: fstore #19
/*     */     //   1146: aload_0
/*     */     //   1147: getfield rclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1150: fload #15
/*     */     //   1152: fload #19
/*     */     //   1154: fsub
/*     */     //   1155: putfield rotationPointY : F
/*     */     //   1158: goto -> 1170
/*     */     //   1161: aload_0
/*     */     //   1162: getfield rclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1165: fload #15
/*     */     //   1167: putfield rotationPointY : F
/*     */     //   1170: aload_0
/*     */     //   1171: getfield rclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1174: fload #14
/*     */     //   1176: fload #16
/*     */     //   1178: fload #10
/*     */     //   1180: fmul
/*     */     //   1181: fload_3
/*     */     //   1182: fmul
/*     */     //   1183: fadd
/*     */     //   1184: putfield rotationPointZ : F
/*     */     //   1187: aload_0
/*     */     //   1188: getfield rclaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1191: aload_0
/*     */     //   1192: getfield rclaw3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1195: aload_0
/*     */     //   1196: getfield rclaw4 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1199: aload_0
/*     */     //   1200: getfield rclaw5 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1203: aload_0
/*     */     //   1204: getfield rclaw6 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1207: aload_0
/*     */     //   1208: getfield rclaw7 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1211: aload_0
/*     */     //   1212: getfield rclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1215: getfield rotationPointZ : F
/*     */     //   1218: dup_x1
/*     */     //   1219: putfield rotationPointZ : F
/*     */     //   1222: dup_x1
/*     */     //   1223: putfield rotationPointZ : F
/*     */     //   1226: dup_x1
/*     */     //   1227: putfield rotationPointZ : F
/*     */     //   1230: dup_x1
/*     */     //   1231: putfield rotationPointZ : F
/*     */     //   1234: dup_x1
/*     */     //   1235: putfield rotationPointZ : F
/*     */     //   1238: putfield rotationPointZ : F
/*     */     //   1241: aload_0
/*     */     //   1242: getfield rclaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1245: aload_0
/*     */     //   1246: getfield rclaw3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1249: aload_0
/*     */     //   1250: getfield rclaw4 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1253: aload_0
/*     */     //   1254: getfield rclaw5 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1257: aload_0
/*     */     //   1258: getfield rclaw6 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1261: aload_0
/*     */     //   1262: getfield rclaw7 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1265: aload_0
/*     */     //   1266: getfield rclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1269: getfield rotationPointY : F
/*     */     //   1272: dup_x1
/*     */     //   1273: putfield rotationPointY : F
/*     */     //   1276: dup_x1
/*     */     //   1277: putfield rotationPointY : F
/*     */     //   1280: dup_x1
/*     */     //   1281: putfield rotationPointY : F
/*     */     //   1284: dup_x1
/*     */     //   1285: putfield rotationPointY : F
/*     */     //   1288: dup_x1
/*     */     //   1289: putfield rotationPointY : F
/*     */     //   1292: putfield rotationPointY : F
/*     */     //   1295: aload_0
/*     */     //   1296: getfield rightleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1299: aload_0
/*     */     //   1300: getfield rclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1303: getfield rotationPointZ : F
/*     */     //   1306: putfield rotationPointZ : F
/*     */     //   1309: aload_0
/*     */     //   1310: getfield rightleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1313: aload_0
/*     */     //   1314: getfield rclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1317: getfield rotationPointY : F
/*     */     //   1320: putfield rotationPointY : F
/*     */     //   1323: aload_0
/*     */     //   1324: getfield rightleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1327: ldc_w -0.523
/*     */     //   1330: fload #10
/*     */     //   1332: ldc_w 3.1415927
/*     */     //   1335: fmul
/*     */     //   1336: ldc_w 0.15
/*     */     //   1339: fmul
/*     */     //   1340: fload_3
/*     */     //   1341: fmul
/*     */     //   1342: fadd
/*     */     //   1343: putfield rotateAngleX : F
/*     */     //   1346: aload_0
/*     */     //   1347: getfield rightleg1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1350: ldc_w -0.576
/*     */     //   1353: fload #10
/*     */     //   1355: ldc_w 3.1415927
/*     */     //   1358: fmul
/*     */     //   1359: ldc_w 0.06
/*     */     //   1362: fmul
/*     */     //   1363: fload_3
/*     */     //   1364: fmul
/*     */     //   1365: fadd
/*     */     //   1366: putfield rotateAngleX : F
/*     */     //   1369: aload_0
/*     */     //   1370: getfield rightleg2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1373: ldc_w 0.977
/*     */     //   1376: fload #10
/*     */     //   1378: ldc_w 3.1415927
/*     */     //   1381: fmul
/*     */     //   1382: ldc_w 0.06
/*     */     //   1385: fmul
/*     */     //   1386: fload_3
/*     */     //   1387: fmul
/*     */     //   1388: fadd
/*     */     //   1389: putfield rotateAngleX : F
/*     */     //   1392: aload_0
/*     */     //   1393: getfield rightleg1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1396: aload_0
/*     */     //   1397: getfield rightleg2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1400: aload_0
/*     */     //   1401: getfield rightleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1404: getfield rotationPointY : F
/*     */     //   1407: aload_0
/*     */     //   1408: getfield rightleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1411: getfield rotateAngleX : F
/*     */     //   1414: f2d
/*     */     //   1415: invokestatic cos : (D)D
/*     */     //   1418: d2f
/*     */     //   1419: ldc_w 17.0
/*     */     //   1422: fmul
/*     */     //   1423: fsub
/*     */     //   1424: dup_x1
/*     */     //   1425: putfield rotationPointY : F
/*     */     //   1428: putfield rotationPointY : F
/*     */     //   1431: aload_0
/*     */     //   1432: getfield rightleg1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1435: aload_0
/*     */     //   1436: getfield rightleg2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1439: aload_0
/*     */     //   1440: getfield rightleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1443: getfield rotationPointZ : F
/*     */     //   1446: aload_0
/*     */     //   1447: getfield rightleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1450: getfield rotateAngleX : F
/*     */     //   1453: f2d
/*     */     //   1454: invokestatic sin : (D)D
/*     */     //   1457: d2f
/*     */     //   1458: ldc_w 17.0
/*     */     //   1461: fmul
/*     */     //   1462: fsub
/*     */     //   1463: dup_x1
/*     */     //   1464: putfield rotationPointZ : F
/*     */     //   1467: putfield rotationPointZ : F
/*     */     //   1470: aload_0
/*     */     //   1471: getfield lclaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1474: aload_0
/*     */     //   1475: getfield lclaw3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1478: aload_0
/*     */     //   1479: getfield lclaw4 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1482: aload_0
/*     */     //   1483: getfield lclaw5 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1486: aload_0
/*     */     //   1487: getfield lclaw6 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1490: aload_0
/*     */     //   1491: getfield lclaw7 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1494: aload_0
/*     */     //   1495: getfield lclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1498: fconst_0
/*     */     //   1499: dup_x1
/*     */     //   1500: putfield rotateAngleX : F
/*     */     //   1503: dup_x1
/*     */     //   1504: putfield rotateAngleX : F
/*     */     //   1507: dup_x1
/*     */     //   1508: putfield rotateAngleX : F
/*     */     //   1511: dup_x1
/*     */     //   1512: putfield rotateAngleX : F
/*     */     //   1515: dup_x1
/*     */     //   1516: putfield rotateAngleX : F
/*     */     //   1519: dup_x1
/*     */     //   1520: putfield rotateAngleX : F
/*     */     //   1523: putfield rotateAngleX : F
/*     */     //   1526: aload_0
/*     */     //   1527: getfield rclaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1530: aload_0
/*     */     //   1531: getfield rclaw3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1534: aload_0
/*     */     //   1535: getfield rclaw4 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1538: aload_0
/*     */     //   1539: getfield rclaw5 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1542: aload_0
/*     */     //   1543: getfield rclaw6 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1546: aload_0
/*     */     //   1547: getfield rclaw7 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1550: aload_0
/*     */     //   1551: getfield rclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1554: fconst_0
/*     */     //   1555: dup_x1
/*     */     //   1556: putfield rotateAngleX : F
/*     */     //   1559: dup_x1
/*     */     //   1560: putfield rotateAngleX : F
/*     */     //   1563: dup_x1
/*     */     //   1564: putfield rotateAngleX : F
/*     */     //   1567: dup_x1
/*     */     //   1568: putfield rotateAngleX : F
/*     */     //   1571: dup_x1
/*     */     //   1572: putfield rotateAngleX : F
/*     */     //   1575: dup_x1
/*     */     //   1576: putfield rotateAngleX : F
/*     */     //   1579: putfield rotateAngleX : F
/*     */     //   1582: aload #8
/*     */     //   1584: invokevirtual getAttacking : ()I
/*     */     //   1587: ifeq -> 1603
/*     */     //   1590: ldc_w 0.76
/*     */     //   1593: fstore #12
/*     */     //   1595: ldc_w 0.25
/*     */     //   1598: fstore #13
/*     */     //   1600: goto -> 1613
/*     */     //   1603: ldc_w 0.26
/*     */     //   1606: fstore #12
/*     */     //   1608: ldc_w 0.08
/*     */     //   1611: fstore #13
/*     */     //   1613: aload_0
/*     */     //   1614: getfield tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1617: fload #4
/*     */     //   1619: fload #12
/*     */     //   1621: fmul
/*     */     //   1622: aload_0
/*     */     //   1623: getfield wingspeed : F
/*     */     //   1626: fmul
/*     */     //   1627: invokestatic cos : (F)F
/*     */     //   1630: ldc_w 3.1415927
/*     */     //   1633: fmul
/*     */     //   1634: fload #13
/*     */     //   1636: fmul
/*     */     //   1637: fconst_2
/*     */     //   1638: fdiv
/*     */     //   1639: putfield rotateAngleY : F
/*     */     //   1642: aload_0
/*     */     //   1643: getfield tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1646: aload_0
/*     */     //   1647: getfield tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1650: getfield rotationPointZ : F
/*     */     //   1653: aload_0
/*     */     //   1654: getfield tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1657: getfield rotateAngleY : F
/*     */     //   1660: f2d
/*     */     //   1661: invokestatic cos : (D)D
/*     */     //   1664: d2f
/*     */     //   1665: ldc 11.0
/*     */     //   1667: fmul
/*     */     //   1668: fadd
/*     */     //   1669: putfield rotationPointZ : F
/*     */     //   1672: aload_0
/*     */     //   1673: getfield tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1676: aload_0
/*     */     //   1677: getfield tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1680: getfield rotationPointX : F
/*     */     //   1683: aload_0
/*     */     //   1684: getfield tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1687: getfield rotateAngleY : F
/*     */     //   1690: f2d
/*     */     //   1691: invokestatic sin : (D)D
/*     */     //   1694: d2f
/*     */     //   1695: ldc 11.0
/*     */     //   1697: fmul
/*     */     //   1698: fadd
/*     */     //   1699: putfield rotationPointX : F
/*     */     //   1702: aload_0
/*     */     //   1703: getfield tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1706: fload #4
/*     */     //   1708: fload #12
/*     */     //   1710: fmul
/*     */     //   1711: aload_0
/*     */     //   1712: getfield wingspeed : F
/*     */     //   1715: fmul
/*     */     //   1716: invokestatic cos : (F)F
/*     */     //   1719: ldc_w 3.1415927
/*     */     //   1722: fmul
/*     */     //   1723: fload #13
/*     */     //   1725: fmul
/*     */     //   1726: putfield rotateAngleY : F
/*     */     //   1729: aload_0
/*     */     //   1730: getfield lclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1733: fload #7
/*     */     //   1735: invokevirtual render : (F)V
/*     */     //   1738: aload_0
/*     */     //   1739: getfield body : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1742: fload #7
/*     */     //   1744: invokevirtual render : (F)V
/*     */     //   1747: aload_0
/*     */     //   1748: getfield leftleg1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1751: fload #7
/*     */     //   1753: invokevirtual render : (F)V
/*     */     //   1756: aload_0
/*     */     //   1757: getfield tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1760: fload #7
/*     */     //   1762: invokevirtual render : (F)V
/*     */     //   1765: aload_0
/*     */     //   1766: getfield leftleg2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1769: fload #7
/*     */     //   1771: invokevirtual render : (F)V
/*     */     //   1774: aload_0
/*     */     //   1775: getfield body2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1778: fload #7
/*     */     //   1780: invokevirtual render : (F)V
/*     */     //   1783: aload_0
/*     */     //   1784: getfield leftleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1787: fload #7
/*     */     //   1789: invokevirtual render : (F)V
/*     */     //   1792: aload_0
/*     */     //   1793: getfield tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1796: fload #7
/*     */     //   1798: invokevirtual render : (F)V
/*     */     //   1801: aload_0
/*     */     //   1802: getfield tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1805: fload #7
/*     */     //   1807: invokevirtual render : (F)V
/*     */     //   1810: aload_0
/*     */     //   1811: getfield lclaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1814: fload #7
/*     */     //   1816: invokevirtual render : (F)V
/*     */     //   1819: aload_0
/*     */     //   1820: getfield lclaw3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1823: fload #7
/*     */     //   1825: invokevirtual render : (F)V
/*     */     //   1828: aload_0
/*     */     //   1829: getfield lclaw4 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1832: fload #7
/*     */     //   1834: invokevirtual render : (F)V
/*     */     //   1837: aload_0
/*     */     //   1838: getfield lclaw5 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1841: fload #7
/*     */     //   1843: invokevirtual render : (F)V
/*     */     //   1846: aload_0
/*     */     //   1847: getfield lclaw6 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1850: fload #7
/*     */     //   1852: invokevirtual render : (F)V
/*     */     //   1855: aload_0
/*     */     //   1856: getfield lclaw7 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1859: fload #7
/*     */     //   1861: invokevirtual render : (F)V
/*     */     //   1864: aload_0
/*     */     //   1865: getfield neck3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1868: fload #7
/*     */     //   1870: invokevirtual render : (F)V
/*     */     //   1873: aload_0
/*     */     //   1874: getfield head3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1877: fload #7
/*     */     //   1879: invokevirtual render : (F)V
/*     */     //   1882: aload_0
/*     */     //   1883: getfield jaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1886: fload #7
/*     */     //   1888: invokevirtual render : (F)V
/*     */     //   1891: aload_0
/*     */     //   1892: getfield tooth1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1895: fload #7
/*     */     //   1897: invokevirtual render : (F)V
/*     */     //   1900: aload_0
/*     */     //   1901: getfield tooth2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1904: fload #7
/*     */     //   1906: invokevirtual render : (F)V
/*     */     //   1909: aload_0
/*     */     //   1910: getfield tooth3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1913: fload #7
/*     */     //   1915: invokevirtual render : (F)V
/*     */     //   1918: aload_0
/*     */     //   1919: getfield tooth4 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1922: fload #7
/*     */     //   1924: invokevirtual render : (F)V
/*     */     //   1927: aload_0
/*     */     //   1928: getfield tooth5 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1931: fload #7
/*     */     //   1933: invokevirtual render : (F)V
/*     */     //   1936: aload_0
/*     */     //   1937: getfield jaw5 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1940: fload #7
/*     */     //   1942: invokevirtual render : (F)V
/*     */     //   1945: aload_0
/*     */     //   1946: getfield head7 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1949: fload #7
/*     */     //   1951: invokevirtual render : (F)V
/*     */     //   1954: aload_0
/*     */     //   1955: getfield tooth6 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1958: fload #7
/*     */     //   1960: invokevirtual render : (F)V
/*     */     //   1963: aload_0
/*     */     //   1964: getfield tooth7 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1967: fload #7
/*     */     //   1969: invokevirtual render : (F)V
/*     */     //   1972: aload_0
/*     */     //   1973: getfield tooth8 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1976: fload #7
/*     */     //   1978: invokevirtual render : (F)V
/*     */     //   1981: aload_0
/*     */     //   1982: getfield tooth9 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1985: fload #7
/*     */     //   1987: invokevirtual render : (F)V
/*     */     //   1990: aload_0
/*     */     //   1991: getfield tooth10 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   1994: fload #7
/*     */     //   1996: invokevirtual render : (F)V
/*     */     //   1999: aload_0
/*     */     //   2000: getfield tooth11 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2003: fload #7
/*     */     //   2005: invokevirtual render : (F)V
/*     */     //   2008: aload_0
/*     */     //   2009: getfield tooth12 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2012: fload #7
/*     */     //   2014: invokevirtual render : (F)V
/*     */     //   2017: aload_0
/*     */     //   2018: getfield tooth13 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2021: fload #7
/*     */     //   2023: invokevirtual render : (F)V
/*     */     //   2026: aload_0
/*     */     //   2027: getfield rightleg1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2030: fload #7
/*     */     //   2032: invokevirtual render : (F)V
/*     */     //   2035: aload_0
/*     */     //   2036: getfield rightleg2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2039: fload #7
/*     */     //   2041: invokevirtual render : (F)V
/*     */     //   2044: aload_0
/*     */     //   2045: getfield tooth14 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2048: fload #7
/*     */     //   2050: invokevirtual render : (F)V
/*     */     //   2053: aload_0
/*     */     //   2054: getfield tooth15 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2057: fload #7
/*     */     //   2059: invokevirtual render : (F)V
/*     */     //   2062: aload_0
/*     */     //   2063: getfield tooth16 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2066: fload #7
/*     */     //   2068: invokevirtual render : (F)V
/*     */     //   2071: aload_0
/*     */     //   2072: getfield tooth17 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2075: fload #7
/*     */     //   2077: invokevirtual render : (F)V
/*     */     //   2080: aload_0
/*     */     //   2081: getfield tooth18 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2084: fload #7
/*     */     //   2086: invokevirtual render : (F)V
/*     */     //   2089: aload_0
/*     */     //   2090: getfield tooth19 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2093: fload #7
/*     */     //   2095: invokevirtual render : (F)V
/*     */     //   2098: aload_0
/*     */     //   2099: getfield tooth20 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2102: fload #7
/*     */     //   2104: invokevirtual render : (F)V
/*     */     //   2107: aload_0
/*     */     //   2108: getfield tooth21 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2111: fload #7
/*     */     //   2113: invokevirtual render : (F)V
/*     */     //   2116: aload_0
/*     */     //   2117: getfield tooth22 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2120: fload #7
/*     */     //   2122: invokevirtual render : (F)V
/*     */     //   2125: aload_0
/*     */     //   2126: getfield tooth23 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2129: fload #7
/*     */     //   2131: invokevirtual render : (F)V
/*     */     //   2134: aload_0
/*     */     //   2135: getfield rightleg3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2138: fload #7
/*     */     //   2140: invokevirtual render : (F)V
/*     */     //   2143: aload_0
/*     */     //   2144: getfield rclaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2147: fload #7
/*     */     //   2149: invokevirtual render : (F)V
/*     */     //   2152: aload_0
/*     */     //   2153: getfield rclaw4 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2156: fload #7
/*     */     //   2158: invokevirtual render : (F)V
/*     */     //   2161: aload_0
/*     */     //   2162: getfield rclaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2165: fload #7
/*     */     //   2167: invokevirtual render : (F)V
/*     */     //   2170: aload_0
/*     */     //   2171: getfield rclaw5 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2174: fload #7
/*     */     //   2176: invokevirtual render : (F)V
/*     */     //   2179: aload_0
/*     */     //   2180: getfield rclaw7 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2183: fload #7
/*     */     //   2185: invokevirtual render : (F)V
/*     */     //   2188: aload_0
/*     */     //   2189: getfield rclaw3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2192: fload #7
/*     */     //   2194: invokevirtual render : (F)V
/*     */     //   2197: aload_0
/*     */     //   2198: getfield rclaw6 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2201: fload #7
/*     */     //   2203: invokevirtual render : (F)V
/*     */     //   2206: aload_0
/*     */     //   2207: getfield neck1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2210: fload #7
/*     */     //   2212: invokevirtual render : (F)V
/*     */     //   2215: aload_0
/*     */     //   2216: getfield neck2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2219: fload #7
/*     */     //   2221: invokevirtual render : (F)V
/*     */     //   2224: aload_0
/*     */     //   2225: getfield tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2228: fload #7
/*     */     //   2230: invokevirtual render : (F)V
/*     */     //   2233: aload_0
/*     */     //   2234: getfield Spike1 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2237: fload #7
/*     */     //   2239: invokevirtual render : (F)V
/*     */     //   2242: aload_0
/*     */     //   2243: getfield Spike2 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2246: fload #7
/*     */     //   2248: invokevirtual render : (F)V
/*     */     //   2251: aload_0
/*     */     //   2252: getfield Spike3 : Lnet/minecraft/client/model/ModelRenderer;
/*     */     //   2255: fload #7
/*     */     //   2257: invokevirtual render : (F)V
/*     */     //   2260: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #442	-> 0
/*     */     //   #443	-> 6
/*     */     //   #444	-> 9
/*     */     //   #445	-> 24
/*     */     //   #446	-> 39
/*     */     //   #447	-> 42
/*     */     //   #448	-> 45
/*     */     //   #450	-> 51
/*     */     //   #451	-> 56
/*     */     //   #452	-> 60
/*     */     //   #453	-> 68
/*     */     //   #455	-> 74
/*     */     //   #457	-> 79
/*     */     //   #462	-> 86
/*     */     //   #464	-> 94
/*     */     //   #466	-> 105
/*     */     //   #467	-> 122
/*     */     //   #468	-> 136
/*     */     //   #469	-> 158
/*     */     //   #470	-> 180
/*     */     //   #471	-> 226
/*     */     //   #472	-> 272
/*     */     //   #473	-> 318
/*     */     //   #474	-> 364
/*     */     //   #480	-> 394
/*     */     //   #481	-> 402
/*     */     //   #482	-> 426
/*     */     //   #484	-> 436
/*     */     //   #485	-> 453
/*     */     //   #487	-> 460
/*     */     //   #489	-> 471
/*     */     //   #490	-> 477
/*     */     //   #493	-> 505
/*     */     //   #495	-> 512
/*     */     //   #496	-> 520
/*     */     //   #497	-> 544
/*     */     //   #499	-> 554
/*     */     //   #503	-> 562
/*     */     //   #504	-> 579
/*     */     //   #505	-> 596
/*     */     //   #506	-> 637
/*     */     //   #514	-> 662
/*     */     //   #515	-> 665
/*     */     //   #517	-> 668
/*     */     //   #518	-> 677
/*     */     //   #519	-> 692
/*     */     //   #521	-> 710
/*     */     //   #522	-> 713
/*     */     //   #523	-> 716
/*     */     //   #525	-> 719
/*     */     //   #526	-> 726
/*     */     //   #527	-> 735
/*     */     //   #529	-> 750
/*     */     //   #532	-> 759
/*     */     //   #533	-> 776
/*     */     //   #534	-> 830
/*     */     //   #536	-> 884
/*     */     //   #537	-> 898
/*     */     //   #538	-> 912
/*     */     //   #541	-> 935
/*     */     //   #542	-> 958
/*     */     //   #543	-> 981
/*     */     //   #544	-> 1020
/*     */     //   #546	-> 1059
/*     */     //   #547	-> 1062
/*     */     //   #548	-> 1065
/*     */     //   #549	-> 1074
/*     */     //   #550	-> 1096
/*     */     //   #552	-> 1121
/*     */     //   #553	-> 1124
/*     */     //   #554	-> 1127
/*     */     //   #556	-> 1130
/*     */     //   #557	-> 1137
/*     */     //   #558	-> 1146
/*     */     //   #560	-> 1161
/*     */     //   #562	-> 1170
/*     */     //   #563	-> 1187
/*     */     //   #564	-> 1241
/*     */     //   #566	-> 1295
/*     */     //   #567	-> 1309
/*     */     //   #568	-> 1323
/*     */     //   #571	-> 1346
/*     */     //   #572	-> 1369
/*     */     //   #573	-> 1392
/*     */     //   #574	-> 1431
/*     */     //   #580	-> 1470
/*     */     //   #581	-> 1526
/*     */     //   #584	-> 1582
/*     */     //   #585	-> 1590
/*     */     //   #586	-> 1595
/*     */     //   #588	-> 1603
/*     */     //   #589	-> 1608
/*     */     //   #591	-> 1613
/*     */     //   #593	-> 1642
/*     */     //   #594	-> 1672
/*     */     //   #596	-> 1702
/*     */     //   #602	-> 1729
/*     */     //   #603	-> 1738
/*     */     //   #604	-> 1747
/*     */     //   #605	-> 1756
/*     */     //   #606	-> 1765
/*     */     //   #607	-> 1774
/*     */     //   #608	-> 1783
/*     */     //   #609	-> 1792
/*     */     //   #610	-> 1801
/*     */     //   #611	-> 1810
/*     */     //   #612	-> 1819
/*     */     //   #613	-> 1828
/*     */     //   #614	-> 1837
/*     */     //   #615	-> 1846
/*     */     //   #616	-> 1855
/*     */     //   #617	-> 1864
/*     */     //   #618	-> 1873
/*     */     //   #619	-> 1882
/*     */     //   #620	-> 1891
/*     */     //   #621	-> 1900
/*     */     //   #622	-> 1909
/*     */     //   #623	-> 1918
/*     */     //   #624	-> 1927
/*     */     //   #625	-> 1936
/*     */     //   #626	-> 1945
/*     */     //   #627	-> 1954
/*     */     //   #628	-> 1963
/*     */     //   #629	-> 1972
/*     */     //   #630	-> 1981
/*     */     //   #631	-> 1990
/*     */     //   #632	-> 1999
/*     */     //   #633	-> 2008
/*     */     //   #634	-> 2017
/*     */     //   #635	-> 2026
/*     */     //   #636	-> 2035
/*     */     //   #637	-> 2044
/*     */     //   #638	-> 2053
/*     */     //   #639	-> 2062
/*     */     //   #640	-> 2071
/*     */     //   #641	-> 2080
/*     */     //   #642	-> 2089
/*     */     //   #643	-> 2098
/*     */     //   #644	-> 2107
/*     */     //   #645	-> 2116
/*     */     //   #646	-> 2125
/*     */     //   #647	-> 2134
/*     */     //   #648	-> 2143
/*     */     //   #649	-> 2152
/*     */     //   #650	-> 2161
/*     */     //   #651	-> 2170
/*     */     //   #652	-> 2179
/*     */     //   #653	-> 2188
/*     */     //   #654	-> 2197
/*     */     //   #655	-> 2206
/*     */     //   #656	-> 2215
/*     */     //   #657	-> 2224
/*     */     //   #658	-> 2233
/*     */     //   #659	-> 2242
/*     */     //   #660	-> 2251
/*     */     //   #662	-> 2260
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	2261	0	this	Ldanger/orespawn/entity/model/ModelNastysaurus;
/*     */     //   0	2261	1	entity	Lnet/minecraft/entity/Entity;
/*     */     //   0	2261	2	f	F
/*     */     //   0	2261	3	f1	F
/*     */     //   0	2261	4	f2	F
/*     */     //   0	2261	5	f3	F
/*     */     //   0	2261	6	f4	F
/*     */     //   0	2261	7	f5	F
/*     */     //   6	2255	8	e	Ldanger/orespawn/entity/Nastysaurus;
/*     */     //   9	2252	9	r	Ldanger/orespawn/entity/RenderInfo;
/*     */     //   42	2219	10	newangle	F
/*     */     //   45	2216	11	pscale	F
/*     */     //   48	2213	12	tailspeed	F
/*     */     //   51	2210	13	tailamp	F
/*     */     //   56	2205	14	clawZ	F
/*     */     //   60	2201	15	clawY	F
/*     */     //   68	2193	16	clawZamp	F
/*     */     //   74	2187	17	clawYamp	F
/*     */     //   665	1596	18	t1	F
/*     */     //   668	1593	19	t2	F
/*     */     //   79	2182	20	pi4	F
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 666 */     model.rotateAngleX = x;
/* 667 */     model.rotateAngleY = y;
/* 668 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 673 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\model\ModelNastysaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */