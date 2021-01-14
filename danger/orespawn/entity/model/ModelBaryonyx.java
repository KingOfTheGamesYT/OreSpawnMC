/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.Baryonyx;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class ModelBaryonyx
/*     */   extends ModelBase
/*     */ {
/*  14 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Shape27;
/*     */   ModelRenderer Shape28;
/*     */   ModelRenderer Shape29;
/*     */   ModelRenderer Shape30;
/*     */   ModelRenderer Shape31;
/*     */   ModelRenderer Shape32;
/*     */   ModelRenderer Shape33;
/*     */   ModelRenderer Shape34;
/*     */   ModelRenderer Shape35;
/*     */   ModelRenderer Shape36;
/*     */   ModelRenderer Shape37;
/*     */   ModelRenderer Shape38;
/*     */   ModelRenderer Shape39;
/*     */   ModelRenderer Shape40;
/*     */   ModelRenderer Shape41;
/*     */   ModelRenderer Shape42;
/*     */   ModelRenderer Shape43;
/*     */   ModelRenderer Shape44;
/*     */   ModelRenderer Shape45;
/*     */   ModelRenderer Shape46;
/*     */   ModelRenderer Shape47;
/*     */   ModelRenderer Shape48;
/*     */   ModelRenderer Shape49;
/*     */   ModelRenderer Shape50;
/*     */   ModelRenderer Shape51;
/*     */   ModelRenderer Shape1;
/*     */   ModelRenderer Shape2;
/*     */   ModelRenderer Shape3;
/*     */   ModelRenderer Shape4;
/*     */   ModelRenderer Shape5;
/*     */   ModelRenderer Shape6;
/*     */   ModelRenderer Shape7;
/*     */   ModelRenderer Shape8;
/*     */   ModelRenderer Shape9;
/*     */   ModelRenderer Shape10;
/*     */   ModelRenderer Shape11;
/*     */   ModelRenderer Shape12;
/*     */   ModelRenderer Shape13;
/*     */   ModelRenderer Shape14;
/*     */   ModelRenderer Shape15;
/*     */   ModelRenderer Shape16;
/*     */   ModelRenderer Shape17;
/*     */   ModelRenderer Shape18;
/*     */   ModelRenderer Shape19;
/*     */   ModelRenderer Shape20;
/*     */   ModelRenderer Shape21;
/*     */   ModelRenderer Shape22;
/*     */   ModelRenderer Shape23;
/*     */   ModelRenderer Shape24;
/*     */   ModelRenderer Shape25;
/*     */   ModelRenderer Shape26;
/*     */   ModelRenderer Shape52;
/*     */   
/*     */   public ModelBaryonyx(float f1) {
/*  70 */     this.wingspeed = f1;
/*     */     
/*  72 */     this.textureWidth = 128;
/*  73 */     this.textureHeight = 128;
/*     */     
/*  75 */     this.Shape27 = new ModelRenderer(this, 0, 0);
/*  76 */     this.Shape27.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/*  77 */     this.Shape27.setRotationPoint(0.0F, -17.0F, -10.0F);
/*  78 */     this.Shape27.setTextureSize(128, 128);
/*  79 */     this.Shape27.mirror = true;
/*  80 */     setRotation(this.Shape27, 0.0F, 0.0F, 0.0F);
/*  81 */     this.Shape28 = new ModelRenderer(this, 0, 0);
/*  82 */     this.Shape28.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/*  83 */     this.Shape28.setRotationPoint(0.0F, -17.0F, -7.0F);
/*  84 */     this.Shape28.setTextureSize(128, 128);
/*  85 */     this.Shape28.mirror = true;
/*  86 */     setRotation(this.Shape28, 0.0F, 0.0F, 0.0F);
/*  87 */     this.Shape29 = new ModelRenderer(this, 0, 0);
/*  88 */     this.Shape29.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/*  89 */     this.Shape29.setRotationPoint(0.0F, -17.0F, -4.0F);
/*  90 */     this.Shape29.setTextureSize(128, 128);
/*  91 */     this.Shape29.mirror = true;
/*  92 */     setRotation(this.Shape29, 0.0F, 0.0F, 0.0F);
/*  93 */     this.Shape30 = new ModelRenderer(this, 0, 0);
/*  94 */     this.Shape30.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/*  95 */     this.Shape30.setRotationPoint(0.0F, -17.0F, -1.0F);
/*  96 */     this.Shape30.setTextureSize(128, 128);
/*  97 */     this.Shape30.mirror = true;
/*  98 */     setRotation(this.Shape30, 0.0F, 0.0F, 0.0F);
/*  99 */     this.Shape31 = new ModelRenderer(this, 0, 0);
/* 100 */     this.Shape31.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 101 */     this.Shape31.setRotationPoint(0.0F, -17.0F, 2.0F);
/* 102 */     this.Shape31.setTextureSize(128, 128);
/* 103 */     this.Shape31.mirror = true;
/* 104 */     setRotation(this.Shape31, 0.0F, 0.0F, 0.0F);
/* 105 */     this.Shape32 = new ModelRenderer(this, 0, 0);
/* 106 */     this.Shape32.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 107 */     this.Shape32.setRotationPoint(0.0F, -17.0F, 5.0F);
/* 108 */     this.Shape32.setTextureSize(128, 128);
/* 109 */     this.Shape32.mirror = true;
/* 110 */     setRotation(this.Shape32, 0.0F, 0.0F, 0.0F);
/* 111 */     this.Shape33 = new ModelRenderer(this, 0, 0);
/* 112 */     this.Shape33.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 113 */     this.Shape33.setRotationPoint(0.0F, -17.0F, 8.0F);
/* 114 */     this.Shape33.setTextureSize(128, 128);
/* 115 */     this.Shape33.mirror = true;
/* 116 */     setRotation(this.Shape33, 0.0F, 0.0F, 0.0F);
/* 117 */     this.Shape34 = new ModelRenderer(this, 0, 0);
/* 118 */     this.Shape34.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 119 */     this.Shape34.setRotationPoint(0.0F, -17.0F, 11.0F);
/* 120 */     this.Shape34.setTextureSize(128, 128);
/* 121 */     this.Shape34.mirror = true;
/* 122 */     setRotation(this.Shape34, 0.0F, 0.0F, 0.0F);
/* 123 */     this.Shape35 = new ModelRenderer(this, 0, 0);
/* 124 */     this.Shape35.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 125 */     this.Shape35.setRotationPoint(0.0F, -17.0F, 14.0F);
/* 126 */     this.Shape35.setTextureSize(128, 128);
/* 127 */     this.Shape35.mirror = true;
/* 128 */     setRotation(this.Shape35, 0.0F, 0.0F, 0.0F);
/* 129 */     this.Shape36 = new ModelRenderer(this, 0, 0);
/* 130 */     this.Shape36.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 131 */     this.Shape36.setRotationPoint(0.0F, -17.0F, 17.0F);
/* 132 */     this.Shape36.setTextureSize(128, 128);
/* 133 */     this.Shape36.mirror = true;
/* 134 */     setRotation(this.Shape36, 0.0F, 0.0F, 0.0F);
/* 135 */     this.Shape37 = new ModelRenderer(this, 0, 0);
/* 136 */     this.Shape37.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 137 */     this.Shape37.setRotationPoint(0.0F, -17.0F, 20.0F);
/* 138 */     this.Shape37.setTextureSize(128, 128);
/* 139 */     this.Shape37.mirror = true;
/* 140 */     setRotation(this.Shape37, 0.0F, 0.0F, 0.0F);
/* 141 */     this.Shape38 = new ModelRenderer(this, 0, 0);
/* 142 */     this.Shape38.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 143 */     this.Shape38.setRotationPoint(0.0F, -17.0F, 23.0F);
/* 144 */     this.Shape38.setTextureSize(128, 128);
/* 145 */     this.Shape38.mirror = true;
/* 146 */     setRotation(this.Shape38, 0.0F, 0.0F, 0.0F);
/* 147 */     this.Shape39 = new ModelRenderer(this, 0, 0);
/* 148 */     this.Shape39.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 149 */     this.Shape39.setRotationPoint(0.0F, -17.0F, 26.0F);
/* 150 */     this.Shape39.setTextureSize(128, 128);
/* 151 */     this.Shape39.mirror = true;
/* 152 */     setRotation(this.Shape39, 0.0F, 0.0F, 0.0F);
/* 153 */     this.Shape40 = new ModelRenderer(this, 0, 0);
/* 154 */     this.Shape40.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 155 */     this.Shape40.setRotationPoint(0.0F, -17.0F, 29.0F);
/* 156 */     this.Shape40.setTextureSize(128, 128);
/* 157 */     this.Shape40.mirror = true;
/* 158 */     setRotation(this.Shape40, 0.0F, 0.0F, 0.0F);
/* 159 */     this.Shape41 = new ModelRenderer(this, 0, 0);
/* 160 */     this.Shape41.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 161 */     this.Shape41.setRotationPoint(0.0F, -17.0F, 32.0F);
/* 162 */     this.Shape41.setTextureSize(128, 128);
/* 163 */     this.Shape41.mirror = true;
/* 164 */     setRotation(this.Shape41, 0.0F, 0.0F, 0.0F);
/* 165 */     this.Shape42 = new ModelRenderer(this, 0, 0);
/* 166 */     this.Shape42.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 167 */     this.Shape42.setRotationPoint(0.0F, -17.0F, 35.0F);
/* 168 */     this.Shape42.setTextureSize(128, 128);
/* 169 */     this.Shape42.mirror = true;
/* 170 */     setRotation(this.Shape42, 0.0F, 0.0F, 0.0F);
/* 171 */     this.Shape43 = new ModelRenderer(this, 0, 0);
/* 172 */     this.Shape43.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 173 */     this.Shape43.setRotationPoint(0.0F, -17.0F, 38.0F);
/* 174 */     this.Shape43.setTextureSize(128, 128);
/* 175 */     this.Shape43.mirror = true;
/* 176 */     setRotation(this.Shape43, 0.0F, 0.0F, 0.0F);
/* 177 */     this.Shape44 = new ModelRenderer(this, 0, 0);
/* 178 */     this.Shape44.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 179 */     this.Shape44.setRotationPoint(0.0F, -17.0F, 41.0F);
/* 180 */     this.Shape44.setTextureSize(128, 128);
/* 181 */     this.Shape44.mirror = true;
/* 182 */     setRotation(this.Shape44, 0.0F, 0.0F, 0.0F);
/* 183 */     this.Shape45 = new ModelRenderer(this, 0, 0);
/* 184 */     this.Shape45.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 185 */     this.Shape45.setRotationPoint(0.0F, -17.0F, 44.0F);
/* 186 */     this.Shape45.setTextureSize(128, 128);
/* 187 */     this.Shape45.mirror = true;
/* 188 */     setRotation(this.Shape45, 0.0F, 0.0F, 0.0F);
/* 189 */     this.Shape46 = new ModelRenderer(this, 0, 0);
/* 190 */     this.Shape46.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 191 */     this.Shape46.setRotationPoint(0.0F, -12.0F, -11.0F);
/* 192 */     this.Shape46.setTextureSize(128, 128);
/* 193 */     this.Shape46.mirror = true;
/* 194 */     setRotation(this.Shape46, 0.0F, 0.0F, 0.0F);
/* 195 */     this.Shape47 = new ModelRenderer(this, 0, 0);
/* 196 */     this.Shape47.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 197 */     this.Shape47.setRotationPoint(0.0F, -13.0F, -13.0F);
/* 198 */     this.Shape47.setTextureSize(128, 128);
/* 199 */     this.Shape47.mirror = true;
/* 200 */     setRotation(this.Shape47, 0.0F, 0.0F, 0.0F);
/* 201 */     this.Shape48 = new ModelRenderer(this, 0, 0);
/* 202 */     this.Shape48.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 203 */     this.Shape48.setRotationPoint(0.0F, -15.0F, -15.0F);
/* 204 */     this.Shape48.setTextureSize(128, 128);
/* 205 */     this.Shape48.mirror = true;
/* 206 */     setRotation(this.Shape48, 0.0F, 0.0F, 0.0F);
/* 207 */     this.Shape49 = new ModelRenderer(this, 0, 0);
/* 208 */     this.Shape49.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1);
/* 209 */     this.Shape49.setRotationPoint(0.0F, -16.0F, -16.0F);
/* 210 */     this.Shape49.setTextureSize(128, 128);
/* 211 */     this.Shape49.mirror = true;
/* 212 */     setRotation(this.Shape49, 0.0F, 0.0F, 0.0F);
/* 213 */     this.Shape50 = new ModelRenderer(this, 0, 0);
/* 214 */     this.Shape50.addBox(0.0F, 0.0F, 0.0F, 0, 1, 1);
/* 215 */     this.Shape50.setRotationPoint(0.0F, -19.0F, -17.0F);
/* 216 */     this.Shape50.setTextureSize(128, 128);
/* 217 */     this.Shape50.mirror = true;
/* 218 */     setRotation(this.Shape50, 0.0F, 0.0F, 0.0F);
/* 219 */     this.Shape51 = new ModelRenderer(this, 0, 0);
/* 220 */     this.Shape51.addBox(0.0F, 0.0F, 0.0F, 0, 1, 1);
/* 221 */     this.Shape51.setRotationPoint(0.0F, -19.0F, -19.0F);
/* 222 */     this.Shape51.setTextureSize(128, 128);
/* 223 */     this.Shape51.mirror = true;
/* 224 */     setRotation(this.Shape51, 0.0F, 0.0F, 0.0F);
/* 225 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/* 226 */     this.Shape1.addBox(0.0F, 0.0F, 0.0F, 10, 17, 25);
/* 227 */     this.Shape1.setRotationPoint(-5.0F, -15.0F, -10.0F);
/* 228 */     this.Shape1.setTextureSize(128, 128);
/* 229 */     this.Shape1.mirror = true;
/* 230 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/* 231 */     this.Shape2 = new ModelRenderer(this, 0, 93);
/* 232 */     this.Shape2.addBox(-3.0F, 0.0F, -11.0F, 6, 10, 11);
/* 233 */     this.Shape2.setRotationPoint(0.0F, -10.0F, -6.0F);
/* 234 */     this.Shape2.setTextureSize(128, 128);
/* 235 */     this.Shape2.mirror = true;
/* 236 */     setRotation(this.Shape2, -0.1919862F, 0.0F, 0.0F);
/* 237 */     this.Shape3 = new ModelRenderer(this, 29, 110);
/* 238 */     this.Shape3.addBox(-2.0F, -9.0F, -8.0F, 4, 9, 8);
/* 239 */     this.Shape3.setRotationPoint(0.0F, -10.0F, -11.0F);
/* 240 */     this.Shape3.setTextureSize(128, 128);
/* 241 */     this.Shape3.mirror = true;
/* 242 */     setRotation(this.Shape3, 0.7504916F, 0.0F, 0.0F);
/* 243 */     this.Shape4 = new ModelRenderer(this, 54, 108);
/* 244 */     this.Shape4.addBox(0.0F, 0.0F, 0.0F, 6, 7, 12);
/* 245 */     this.Shape4.setRotationPoint(-3.0F, -18.0F, -28.0F);
/* 246 */     this.Shape4.setTextureSize(128, 128);
/* 247 */     this.Shape4.mirror = true;
/* 248 */     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
/* 249 */     this.Shape5 = new ModelRenderer(this, 54, 86);
/* 250 */     this.Shape5.addBox(0.0F, 0.0F, 0.0F, 3, 6, 15);
/* 251 */     this.Shape5.setRotationPoint(-1.5F, -17.5F, -43.0F);
/* 252 */     this.Shape5.setTextureSize(128, 128);
/* 253 */     this.Shape5.mirror = true;
/* 254 */     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
/* 255 */     this.Shape6 = new ModelRenderer(this, 0, 43);
/* 256 */     this.Shape6.addBox(0.0F, 0.0F, 0.0F, 8, 11, 8);
/* 257 */     this.Shape6.setRotationPoint(-4.0F, -15.0F, 15.0F);
/* 258 */     this.Shape6.setTextureSize(128, 128);
/* 259 */     this.Shape6.mirror = true;
/* 260 */     setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
/* 261 */     this.Shape7 = new ModelRenderer(this, 0, 63);
/* 262 */     this.Shape7.addBox(0.0F, 0.0F, 0.0F, 6, 6, 23);
/* 263 */     this.Shape7.setRotationPoint(-3.0F, -15.0F, 23.0F);
/* 264 */     this.Shape7.setTextureSize(128, 128);
/* 265 */     this.Shape7.mirror = true;
/* 266 */     setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
/* 267 */     this.Shape8 = new ModelRenderer(this, 47, 0);
/* 268 */     this.Shape8.addBox(0.0F, 0.0F, 0.0F, 2, 5, 3);
/* 269 */     this.Shape8.setRotationPoint(5.0F, 0.0F, -7.0F);
/* 270 */     this.Shape8.setTextureSize(128, 128);
/* 271 */     this.Shape8.mirror = true;
/* 272 */     setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
/* 273 */     this.Shape9 = new ModelRenderer(this, 49, 10);
/* 274 */     this.Shape9.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2);
/* 275 */     this.Shape9.setRotationPoint(5.1F, 3.0F, -6.0F);
/* 276 */     this.Shape9.setTextureSize(128, 128);
/* 277 */     this.Shape9.mirror = true;
/* 278 */     setRotation(this.Shape9, -0.3839724F, 0.0F, 0.0F);
/* 279 */     this.Shape10 = new ModelRenderer(this, 13, 17);
/* 280 */     this.Shape10.addBox(0.0F, 0.0F, 0.0F, 2, 4, 3);
/* 281 */     this.Shape10.setRotationPoint(5.0F, 7.0F, -8.0F);
/* 282 */     this.Shape10.setTextureSize(128, 128);
/* 283 */     this.Shape10.mirror = true;
/* 284 */     setRotation(this.Shape10, 0.0F, 0.0F, 0.0F);
/* 285 */     this.Shape11 = new ModelRenderer(this, 0, 17);
/* 286 */     this.Shape11.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2);
/* 287 */     this.Shape11.setRotationPoint(5.0F, 8.0F, -8.0F);
/* 288 */     this.Shape11.setTextureSize(128, 128);
/* 289 */     this.Shape11.mirror = true;
/* 290 */     setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
/* 291 */     this.Shape12 = new ModelRenderer(this, 0, 21);
/* 292 */     this.Shape12.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
/* 293 */     this.Shape12.setRotationPoint(5.0F, 9.0F, -11.0F);
/* 294 */     this.Shape12.setTextureSize(128, 128);
/* 295 */     this.Shape12.mirror = true;
/* 296 */     setRotation(this.Shape12, 0.0F, 0.0F, 0.0F);
/* 297 */     this.Shape13 = new ModelRenderer(this, 95, 36);
/* 298 */     this.Shape13.addBox(0.0F, 0.0F, 0.0F, 3, 21, 13);
/* 299 */     this.Shape13.setRotationPoint(5.0F, -15.0F, 2.0F);
/* 300 */     this.Shape13.setTextureSize(128, 128);
/* 301 */     this.Shape13.mirror = true;
/* 302 */     setRotation(this.Shape13, 0.0F, 0.0F, 0.0F);
/* 303 */     this.Shape14 = new ModelRenderer(this, 36, 94);
/* 304 */     this.Shape14.addBox(0.0F, 0.0F, -3.0F, 3, 5, 3);
/* 305 */     this.Shape14.setRotationPoint(-1.5F, -17.0F, -43.0F);
/* 306 */     this.Shape14.setTextureSize(128, 128);
/* 307 */     this.Shape14.mirror = true;
/* 308 */     setRotation(this.Shape14, 0.0F, 0.0F, 0.0F);
/* 309 */     this.Shape15 = new ModelRenderer(this, 113, 71);
/* 310 */     this.Shape15.addBox(0.0F, 18.0F, 8.0F, 3, 18, 4);
/* 311 */     this.Shape15.setRotationPoint(5.0F, -15.0F, 2.0F);
/* 312 */     this.Shape15.setTextureSize(128, 128);
/* 313 */     this.Shape15.mirror = true;
/* 314 */     setRotation(this.Shape15, -0.1745329F, 0.0F, 0.0F);
/* 315 */     this.Shape16 = new ModelRenderer(this, 13, 11);
/* 316 */     this.Shape16.addBox(-2.0F, 0.0F, 0.0F, 2, 1, 3);
/* 317 */     this.Shape16.setRotationPoint(5.0F, 10.0F, -8.0F);
/* 318 */     this.Shape16.setTextureSize(128, 128);
/* 319 */     this.Shape16.mirror = true;
/* 320 */     setRotation(this.Shape16, 0.0F, 0.0F, 0.0F);
/* 321 */     this.Shape17 = new ModelRenderer(this, 0, 74);
/* 322 */     this.Shape17.addBox(0.0F, 35.0F, -1.0F, 3, 3, 6);
/* 323 */     this.Shape17.setRotationPoint(5.0F, -15.0F, 2.0F);
/* 324 */     this.Shape17.setTextureSize(128, 128);
/* 325 */     this.Shape17.mirror = true;
/* 326 */     setRotation(this.Shape17, 0.0F, 0.0F, 0.0F);
/* 327 */     this.Shape18 = new ModelRenderer(this, 58, 0);
/* 328 */     this.Shape18.addBox(-2.0F, 0.0F, 0.0F, 2, 5, 3);
/* 329 */     this.Shape18.setRotationPoint(-5.0F, 0.0F, -7.0F);
/* 330 */     this.Shape18.setTextureSize(128, 128);
/* 331 */     this.Shape18.mirror = true;
/* 332 */     setRotation(this.Shape18, 0.0F, 0.0F, 0.0F);
/* 333 */     this.Shape19 = new ModelRenderer(this, 59, 10);
/* 334 */     this.Shape19.addBox(-2.0F, 0.0F, 0.0F, 2, 6, 2);
/* 335 */     this.Shape19.setRotationPoint(-5.1F, 3.0F, -6.0F);
/* 336 */     this.Shape19.setTextureSize(128, 128);
/* 337 */     this.Shape19.mirror = true;
/* 338 */     setRotation(this.Shape19, -0.3839724F, 0.0F, 0.0F);
/* 339 */     this.Shape20 = new ModelRenderer(this, 71, 5);
/* 340 */     this.Shape20.addBox(-2.0F, 0.0F, 0.0F, 2, 4, 3);
/* 341 */     this.Shape20.setRotationPoint(-5.0F, 7.0F, -8.0F);
/* 342 */     this.Shape20.setTextureSize(128, 128);
/* 343 */     this.Shape20.mirror = true;
/* 344 */     setRotation(this.Shape20, 0.0F, 0.0F, 0.0F);
/* 345 */     this.Shape21 = new ModelRenderer(this, 71, 0);
/* 346 */     this.Shape21.addBox(0.0F, 0.0F, 0.0F, 2, 1, 3);
/* 347 */     this.Shape21.setRotationPoint(-5.0F, 10.0F, -8.0F);
/* 348 */     this.Shape21.setTextureSize(128, 128);
/* 349 */     this.Shape21.mirror = true;
/* 350 */     setRotation(this.Shape21, 0.0F, 0.0F, 0.0F);
/* 351 */     this.Shape22 = new ModelRenderer(this, 0, 10);
/* 352 */     this.Shape22.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2);
/* 353 */     this.Shape22.setRotationPoint(-5.0F, 8.0F, -8.0F);
/* 354 */     this.Shape22.setTextureSize(128, 128);
/* 355 */     this.Shape22.mirror = true;
/* 356 */     setRotation(this.Shape22, 0.0F, 0.0F, 0.0F);
/* 357 */     this.Shape23 = new ModelRenderer(this, 0, 14);
/* 358 */     this.Shape23.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 1);
/* 359 */     this.Shape23.setRotationPoint(-5.0F, 9.0F, -11.0F);
/* 360 */     this.Shape23.setTextureSize(128, 128);
/* 361 */     this.Shape23.mirror = true;
/* 362 */     setRotation(this.Shape23, 0.0F, 0.0F, 0.0F);
/* 363 */     this.Shape24 = new ModelRenderer(this, 95, 0);
/* 364 */     this.Shape24.addBox(-3.0F, 0.0F, 0.0F, 3, 22, 13);
/* 365 */     this.Shape24.setRotationPoint(-5.0F, -15.0F, 2.0F);
/* 366 */     this.Shape24.setTextureSize(128, 128);
/* 367 */     this.Shape24.mirror = true;
/* 368 */     setRotation(this.Shape24, 0.0F, 0.0F, 0.0F);
/* 369 */     this.Shape25 = new ModelRenderer(this, 96, 71);
/* 370 */     this.Shape25.addBox(-3.0F, 18.0F, 8.0F, 3, 18, 4);
/* 371 */     this.Shape25.setRotationPoint(-5.0F, -15.0F, 2.0F);
/* 372 */     this.Shape25.setTextureSize(128, 128);
/* 373 */     this.Shape25.mirror = true;
/* 374 */     setRotation(this.Shape25, -0.1745329F, 0.0F, 0.0F);
/* 375 */     this.Shape26 = new ModelRenderer(this, 0, 64);
/* 376 */     this.Shape26.addBox(-3.0F, 35.0F, -1.0F, 3, 3, 6);
/* 377 */     this.Shape26.setRotationPoint(-5.0F, -15.0F, 2.0F);
/* 378 */     this.Shape26.setTextureSize(128, 128);
/* 379 */     this.Shape26.mirror = true;
/* 380 */     setRotation(this.Shape26, 0.0F, 0.0F, 0.0F);
/* 381 */     this.Shape52 = new ModelRenderer(this, 9, 0);
/* 382 */     this.Shape52.addBox(0.0F, 0.0F, 0.0F, 0, 2, 2);
/* 383 */     this.Shape52.setRotationPoint(0.0F, -19.0F, -30.0F);
/* 384 */     this.Shape52.setTextureSize(128, 128);
/* 385 */     this.Shape52.mirror = true;
/* 386 */     setRotation(this.Shape52, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 392 */     Baryonyx e = (Baryonyx)entity;
/* 393 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 394 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 396 */     float newangle = 0.0F;
/*     */     
/* 398 */     if (f1 > 0.1D) {
/* 399 */       newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.15F * f1;
/*     */     } else {
/* 401 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 404 */     this.Shape24.rotateAngleX = newangle;
/* 405 */     this.Shape25.rotateAngleX = -0.17F + newangle;
/* 406 */     this.Shape26.rotateAngleX = newangle;
/*     */     
/* 408 */     this.Shape13.rotateAngleX = -newangle;
/* 409 */     this.Shape15.rotateAngleX = -0.17F - newangle;
/* 410 */     this.Shape17.rotateAngleX = -newangle;
/*     */     
/* 412 */     newangle = MathHelper.cos(f2 * 0.7F * this.wingspeed) * 3.1415927F * 0.25F;
/* 413 */     this.Shape21.rotateAngleZ = newangle;
/* 414 */     this.Shape16.rotateAngleZ = -newangle;
/*     */     
/* 416 */     if (this.isChild) {
/* 417 */       GL11.glPushMatrix();
/*     */       
/* 419 */       GL11.glTranslatef(0.0F, 0.75F, 0.0F);
/*     */       
/* 421 */       GL11.glScalef(0.5F, 0.5F, 0.5F);
/*     */       
/* 423 */       this.Shape27.render(f5);
/* 424 */       this.Shape28.render(f5);
/* 425 */       this.Shape29.render(f5);
/* 426 */       this.Shape30.render(f5);
/* 427 */       this.Shape31.render(f5);
/* 428 */       this.Shape32.render(f5);
/* 429 */       this.Shape33.render(f5);
/* 430 */       this.Shape34.render(f5);
/* 431 */       this.Shape35.render(f5);
/* 432 */       this.Shape36.render(f5);
/* 433 */       this.Shape37.render(f5);
/* 434 */       this.Shape38.render(f5);
/* 435 */       this.Shape39.render(f5);
/* 436 */       this.Shape40.render(f5);
/* 437 */       this.Shape41.render(f5);
/* 438 */       this.Shape42.render(f5);
/* 439 */       this.Shape43.render(f5);
/* 440 */       this.Shape44.render(f5);
/* 441 */       this.Shape45.render(f5);
/* 442 */       this.Shape46.render(f5);
/* 443 */       this.Shape47.render(f5);
/* 444 */       this.Shape48.render(f5);
/* 445 */       this.Shape49.render(f5);
/* 446 */       this.Shape50.render(f5);
/* 447 */       this.Shape51.render(f5);
/* 448 */       this.Shape1.render(f5);
/* 449 */       this.Shape2.render(f5);
/* 450 */       this.Shape3.render(f5);
/* 451 */       this.Shape4.render(f5);
/* 452 */       this.Shape5.render(f5);
/* 453 */       this.Shape6.render(f5);
/* 454 */       this.Shape7.render(f5);
/* 455 */       this.Shape8.render(f5);
/* 456 */       this.Shape9.render(f5);
/* 457 */       this.Shape10.render(f5);
/* 458 */       this.Shape11.render(f5);
/* 459 */       this.Shape12.render(f5);
/* 460 */       this.Shape13.render(f5);
/* 461 */       this.Shape14.render(f5);
/* 462 */       this.Shape15.render(f5);
/* 463 */       this.Shape16.render(f5);
/* 464 */       this.Shape17.render(f5);
/* 465 */       this.Shape18.render(f5);
/* 466 */       this.Shape19.render(f5);
/* 467 */       this.Shape20.render(f5);
/* 468 */       this.Shape21.render(f5);
/* 469 */       this.Shape22.render(f5);
/* 470 */       this.Shape23.render(f5);
/* 471 */       this.Shape24.render(f5);
/* 472 */       this.Shape25.render(f5);
/* 473 */       this.Shape26.render(f5);
/* 474 */       this.Shape52.render(f5);
/*     */ 
/*     */ 
/*     */       
/* 478 */       GL11.glPopMatrix();
/*     */     } else {
/*     */       
/* 481 */       GL11.glPushMatrix();
/*     */       
/* 483 */       GL11.glTranslatef(0.0F, -0.1500001F, 0.0F);
/*     */       
/* 485 */       GL11.glScalef(1.1F, 1.1F, 1.1F);
/*     */       
/* 487 */       this.Shape27.render(f5);
/* 488 */       this.Shape28.render(f5);
/* 489 */       this.Shape29.render(f5);
/* 490 */       this.Shape30.render(f5);
/* 491 */       this.Shape31.render(f5);
/* 492 */       this.Shape32.render(f5);
/* 493 */       this.Shape33.render(f5);
/* 494 */       this.Shape34.render(f5);
/* 495 */       this.Shape35.render(f5);
/* 496 */       this.Shape36.render(f5);
/* 497 */       this.Shape37.render(f5);
/* 498 */       this.Shape38.render(f5);
/* 499 */       this.Shape39.render(f5);
/* 500 */       this.Shape40.render(f5);
/* 501 */       this.Shape41.render(f5);
/* 502 */       this.Shape42.render(f5);
/* 503 */       this.Shape43.render(f5);
/* 504 */       this.Shape44.render(f5);
/* 505 */       this.Shape45.render(f5);
/* 506 */       this.Shape46.render(f5);
/* 507 */       this.Shape47.render(f5);
/* 508 */       this.Shape48.render(f5);
/* 509 */       this.Shape49.render(f5);
/* 510 */       this.Shape50.render(f5);
/* 511 */       this.Shape51.render(f5);
/* 512 */       this.Shape1.render(f5);
/* 513 */       this.Shape2.render(f5);
/* 514 */       this.Shape3.render(f5);
/* 515 */       this.Shape4.render(f5);
/* 516 */       this.Shape5.render(f5);
/* 517 */       this.Shape6.render(f5);
/* 518 */       this.Shape7.render(f5);
/* 519 */       this.Shape8.render(f5);
/* 520 */       this.Shape9.render(f5);
/* 521 */       this.Shape10.render(f5);
/* 522 */       this.Shape11.render(f5);
/* 523 */       this.Shape12.render(f5);
/* 524 */       this.Shape13.render(f5);
/* 525 */       this.Shape14.render(f5);
/* 526 */       this.Shape15.render(f5);
/* 527 */       this.Shape16.render(f5);
/* 528 */       this.Shape17.render(f5);
/* 529 */       this.Shape18.render(f5);
/* 530 */       this.Shape19.render(f5);
/* 531 */       this.Shape20.render(f5);
/* 532 */       this.Shape21.render(f5);
/* 533 */       this.Shape22.render(f5);
/* 534 */       this.Shape23.render(f5);
/* 535 */       this.Shape24.render(f5);
/* 536 */       this.Shape25.render(f5);
/* 537 */       this.Shape26.render(f5);
/* 538 */       this.Shape52.render(f5);
/*     */       
/* 540 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 547 */     model.rotateAngleX = x;
/* 548 */     model.rotateAngleY = y;
/* 549 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 554 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3a-deobf.jar!\danger\orespawn\entity\model\ModelBaryonyx.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */