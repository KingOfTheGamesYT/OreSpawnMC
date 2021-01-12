/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelAlien
/*     */   extends ModelBase
/*     */ {
/*  25 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer torso;
/*     */   
/*     */   ModelRenderer stomach;
/*     */   ModelRenderer rThigh;
/*     */   ModelRenderer lThigh;
/*     */   ModelRenderer lShin;
/*     */   ModelRenderer rShin;
/*     */   ModelRenderer lShin1;
/*     */   ModelRenderer rShin1;
/*     */   ModelRenderer lFoot;
/*     */   ModelRenderer rFoot;
/*     */   ModelRenderer neck;
/*     */   ModelRenderer fan;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer tail3;
/*     */   ModelRenderer tail4;
/*     */   ModelRenderer tail5;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer fanl1;
/*     */   ModelRenderer fanr1;
/*     */   ModelRenderer fanl2;
/*     */   ModelRenderer fanr2;
/*     */   ModelRenderer fanl3;
/*     */   ModelRenderer fanr3;
/*     */   ModelRenderer fanl4;
/*     */   ModelRenderer fanr4;
/*     */   ModelRenderer fanl5;
/*     */   ModelRenderer fanr5;
/*     */   ModelRenderer fanl6;
/*     */   ModelRenderer fanr6;
/*     */   ModelRenderer spike4;
/*     */   ModelRenderer spike5;
/*     */   ModelRenderer spike3;
/*     */   ModelRenderer fanl7;
/*     */   ModelRenderer fanr7;
/*     */   ModelRenderer head;
/*     */   ModelRenderer head1;
/*     */   ModelRenderer jaw1;
/*     */   ModelRenderer head2;
/*     */   ModelRenderer jaw2;
/*     */   ModelRenderer fang1;
/*     */   ModelRenderer fang2;
/*     */   ModelRenderer fang3;
/*     */   ModelRenderer fang4;
/*     */   ModelRenderer spike2;
/*     */   ModelRenderer spike1;
/*     */   ModelRenderer arml1;
/*     */   ModelRenderer armr1;
/*     */   ModelRenderer arml2;
/*     */   ModelRenderer armr2;
/*     */   ModelRenderer clawr1;
/*     */   ModelRenderer clawr2;
/*     */   ModelRenderer clawr3;
/*     */   ModelRenderer clawl2;
/*     */   ModelRenderer clawl3;
/*     */   ModelRenderer clawl1;
/*     */   
/*     */   public ModelAlien(float f1) {
/*  85 */     this.wingspeed = f1;
/*     */     
/*  87 */     this.textureWidth = 256;
/*  88 */     this.textureHeight = 128;
/*     */     
/*  90 */     this.torso = new ModelRenderer(this, 0, 46);
/*  91 */     this.torso.addBox(-4.5F, -2.0F, 0.0F, 9, 8, 10);
/*  92 */     this.torso.setRotationPoint(0.0F, -2.5F, -8.0F);
/*  93 */     this.torso.setTextureSize(64, 32);
/*  94 */     this.torso.mirror = true;
/*  95 */     setRotation(this.torso, -0.1919862F, 0.0F, 0.0F);
/*  96 */     this.stomach = new ModelRenderer(this, 0, 27);
/*  97 */     this.stomach.addBox(-3.5F, -5.0F, 8.0F, 7, 6, 12);
/*  98 */     this.stomach.setRotationPoint(0.0F, -2.5F, -8.0F);
/*  99 */     this.stomach.setTextureSize(64, 32);
/* 100 */     this.stomach.mirror = true;
/* 101 */     setRotation(this.stomach, -0.5585054F, 0.0F, 0.0F);
/* 102 */     this.rThigh = new ModelRenderer(this, 59, 45);
/* 103 */     this.rThigh.addBox(-1.5F, -4.0F, -2.5F, 4, 14, 5);
/* 104 */     this.rThigh.setRotationPoint(-4.5F, 7.0F, 8.0F);
/* 105 */     this.rThigh.setTextureSize(64, 32);
/* 106 */     this.rThigh.mirror = true;
/* 107 */     setRotation(this.rThigh, -0.8028515F, 0.2443461F, 0.418879F);
/* 108 */     this.lThigh = new ModelRenderer(this, 40, 45);
/* 109 */     this.lThigh.addBox(-2.5F, -4.0F, -2.5F, 4, 14, 5);
/* 110 */     this.lThigh.setRotationPoint(4.5F, 7.0F, 8.0F);
/* 111 */     this.lThigh.setTextureSize(64, 32);
/* 112 */     this.lThigh.mirror = true;
/* 113 */     setRotation(this.lThigh, -0.8028515F, -0.2443461F, -0.418879F);
/* 114 */     this.lShin = new ModelRenderer(this, 79, 49);
/* 115 */     this.lShin.addBox(-2.0F, 8.0F, -5.5F, 3, 3, 12);
/* 116 */     this.lShin.setRotationPoint(4.5F, 7.0F, 8.0F);
/* 117 */     this.lShin.setTextureSize(64, 32);
/* 118 */     this.lShin.mirror = true;
/* 119 */     setRotation(this.lShin, -0.4014257F, -0.2443461F, -0.418879F);
/* 120 */     this.rShin = new ModelRenderer(this, 79, 33);
/* 121 */     this.rShin.addBox(-1.0F, 8.0F, -5.5F, 3, 3, 12);
/* 122 */     this.rShin.setRotationPoint(-4.5F, 7.0F, 8.0F);
/* 123 */     this.rShin.setTextureSize(64, 32);
/* 124 */     this.rShin.mirror = true;
/* 125 */     setRotation(this.rShin, -0.4014257F, 0.2443461F, 0.418879F);
/* 126 */     this.lShin1 = new ModelRenderer(this, 113, 40);
/* 127 */     this.lShin1.addBox(-1.5F, 5.5F, 9.0F, 2, 9, 2);
/* 128 */     this.lShin1.setRotationPoint(4.5F, 7.0F, 8.0F);
/* 129 */     this.lShin1.setTextureSize(64, 32);
/* 130 */     this.lShin1.mirror = true;
/* 131 */     setRotation(this.lShin1, -0.8028515F, -0.2443461F, -0.418879F);
/* 132 */     this.rShin1 = new ModelRenderer(this, 113, 53);
/* 133 */     this.rShin1.addBox(-0.5F, 5.5F, 9.0F, 2, 9, 2);
/* 134 */     this.rShin1.setRotationPoint(-4.5F, 7.0F, 8.0F);
/* 135 */     this.rShin1.setTextureSize(64, 32);
/* 136 */     this.rShin1.mirror = true;
/* 137 */     setRotation(this.rShin1, -0.8028515F, 0.2443461F, 0.418879F);
/* 138 */     this.lFoot = new ModelRenderer(this, 110, 24);
/* 139 */     this.lFoot.addBox(5.0F, 15.0F, -8.0F, 2, 2, 6);
/* 140 */     this.lFoot.setRotationPoint(4.5F, 7.0F, 8.0F);
/* 141 */     this.lFoot.setTextureSize(64, 32);
/* 142 */     this.lFoot.mirror = true;
/* 143 */     setRotation(this.lFoot, 0.0F, -0.2443461F, 0.0F);
/* 144 */     this.rFoot = new ModelRenderer(this, 95, 24);
/* 145 */     this.rFoot.addBox(-7.0F, 15.0F, -8.0F, 2, 2, 6);
/* 146 */     this.rFoot.setRotationPoint(-4.5F, 7.0F, 8.0F);
/* 147 */     this.rFoot.setTextureSize(64, 32);
/* 148 */     this.rFoot.mirror = true;
/* 149 */     setRotation(this.rFoot, 0.0F, 0.2443461F, 0.0F);
/* 150 */     this.neck = new ModelRenderer(this, 23, 86);
/* 151 */     this.neck.addBox(-2.0F, -2.0F, -4.0F, 4, 6, 5);
/* 152 */     this.neck.setRotationPoint(0.0F, -2.5F, -8.0F);
/* 153 */     this.neck.setTextureSize(64, 32);
/* 154 */     this.neck.mirror = true;
/* 155 */     setRotation(this.neck, -0.1919862F, 0.0F, 0.0F);
/* 156 */     this.fan = new ModelRenderer(this, 149, 10);
/* 157 */     this.fan.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 158 */     this.fan.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 159 */     this.fan.setTextureSize(64, 32);
/* 160 */     this.fan.mirror = true;
/* 161 */     setRotation(this.fan, 0.0F, 0.0F, 0.0F);
/* 162 */     this.tail2 = new ModelRenderer(this, 85, 66);
/* 163 */     this.tail2.addBox(-2.0F, -1.5F, 0.0F, 4, 4, 11);
/* 164 */     this.tail2.setRotationPoint(0.0F, 9.5F, 20.5F);
/* 165 */     this.tail2.setTextureSize(64, 32);
/* 166 */     this.tail2.mirror = true;
/* 167 */     setRotation(this.tail2, -0.3141593F, 0.0F, 0.0F);
/* 168 */     this.tail3 = new ModelRenderer(this, 118, 66);
/* 169 */     this.tail3.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 11);
/* 170 */     this.tail3.setRotationPoint(0.0F, 13.5F, 30.5F);
/* 171 */     this.tail3.setTextureSize(64, 32);
/* 172 */     this.tail3.mirror = true;
/* 173 */     setRotation(this.tail3, -0.2094395F, 0.0F, 0.0F);
/* 174 */     this.tail4 = new ModelRenderer(this, 149, 66);
/* 175 */     this.tail4.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 11);
/* 176 */     this.tail4.setRotationPoint(0.0F, 15.5F, 40.5F);
/* 177 */     this.tail4.setTextureSize(64, 32);
/* 178 */     this.tail4.mirror = true;
/* 179 */     setRotation(this.tail4, -0.1396263F, 0.0F, 0.0F);
/* 180 */     this.tail5 = new ModelRenderer(this, 178, 66);
/* 181 */     this.tail5.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 182 */     this.tail5.setRotationPoint(0.0F, 17.5F, 50.5F);
/* 183 */     this.tail5.setTextureSize(64, 32);
/* 184 */     this.tail5.mirror = true;
/* 185 */     setRotation(this.tail5, -0.0523599F, 0.0F, 0.0F);
/* 186 */     this.tail1 = new ModelRenderer(this, 50, 66);
/* 187 */     this.tail1.addBox(-2.0F, -2.5F, 0.0F, 4, 4, 11);
/* 188 */     this.tail1.setRotationPoint(0.0F, 6.5F, 10.5F);
/* 189 */     this.tail1.setTextureSize(64, 32);
/* 190 */     this.tail1.mirror = true;
/* 191 */     setRotation(this.tail1, -0.4014257F, 0.0F, 0.0F);
/* 192 */     this.fanl1 = new ModelRenderer(this, 130, 10);
/* 193 */     this.fanl1.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 194 */     this.fanl1.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 195 */     this.fanl1.setTextureSize(64, 32);
/* 196 */     this.fanl1.mirror = true;
/* 197 */     setRotation(this.fanl1, 0.0F, 0.0F, 0.2617994F);
/* 198 */     this.fanr1 = new ModelRenderer(this, 130, 10);
/* 199 */     this.fanr1.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 200 */     this.fanr1.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 201 */     this.fanr1.setTextureSize(64, 32);
/* 202 */     this.fanr1.mirror = true;
/* 203 */     setRotation(this.fanr1, 0.0F, 0.0F, -0.2617994F);
/* 204 */     this.fanl2 = new ModelRenderer(this, 130, 10);
/* 205 */     this.fanl2.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 206 */     this.fanl2.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 207 */     this.fanl2.setTextureSize(64, 32);
/* 208 */     this.fanl2.mirror = true;
/* 209 */     setRotation(this.fanl2, 0.0F, 0.0F, 0.5235988F);
/* 210 */     this.fanr2 = new ModelRenderer(this, 130, 10);
/* 211 */     this.fanr2.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 212 */     this.fanr2.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 213 */     this.fanr2.setTextureSize(64, 32);
/* 214 */     this.fanr2.mirror = true;
/* 215 */     setRotation(this.fanr2, 0.0F, 0.0F, -0.5235988F);
/* 216 */     this.fanl3 = new ModelRenderer(this, 130, 10);
/* 217 */     this.fanl3.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 218 */     this.fanl3.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 219 */     this.fanl3.setTextureSize(64, 32);
/* 220 */     this.fanl3.mirror = true;
/* 221 */     setRotation(this.fanl3, 0.0F, 0.0F, 0.7853982F);
/* 222 */     this.fanr3 = new ModelRenderer(this, 130, 10);
/* 223 */     this.fanr3.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 224 */     this.fanr3.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 225 */     this.fanr3.setTextureSize(64, 32);
/* 226 */     this.fanr3.mirror = true;
/* 227 */     setRotation(this.fanr3, 0.0F, 0.0F, -0.7853982F);
/* 228 */     this.fanl4 = new ModelRenderer(this, 130, 10);
/* 229 */     this.fanl4.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 230 */     this.fanl4.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 231 */     this.fanl4.setTextureSize(64, 32);
/* 232 */     this.fanl4.mirror = true;
/* 233 */     setRotation(this.fanl4, 0.0F, 0.0F, 1.047198F);
/* 234 */     this.fanr4 = new ModelRenderer(this, 130, 10);
/* 235 */     this.fanr4.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 236 */     this.fanr4.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 237 */     this.fanr4.setTextureSize(64, 32);
/* 238 */     this.fanr4.mirror = true;
/* 239 */     setRotation(this.fanr4, 0.0F, 0.0F, -1.047198F);
/* 240 */     this.fanl5 = new ModelRenderer(this, 130, 10);
/* 241 */     this.fanl5.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 242 */     this.fanl5.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 243 */     this.fanl5.setTextureSize(64, 32);
/* 244 */     this.fanl5.mirror = true;
/* 245 */     setRotation(this.fanl5, 0.0F, 0.0F, 1.308997F);
/* 246 */     this.fanr5 = new ModelRenderer(this, 130, 10);
/* 247 */     this.fanr5.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 248 */     this.fanr5.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 249 */     this.fanr5.setTextureSize(64, 32);
/* 250 */     this.fanr5.mirror = true;
/* 251 */     setRotation(this.fanr5, 0.0F, 0.0F, -1.308997F);
/* 252 */     this.fanl6 = new ModelRenderer(this, 130, 10);
/* 253 */     this.fanl6.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 254 */     this.fanl6.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 255 */     this.fanl6.setTextureSize(64, 32);
/* 256 */     this.fanl6.mirror = true;
/* 257 */     setRotation(this.fanl6, 0.0F, 0.0F, 1.570796F);
/* 258 */     this.fanr6 = new ModelRenderer(this, 130, 10);
/* 259 */     this.fanr6.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 260 */     this.fanr6.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 261 */     this.fanr6.setTextureSize(64, 32);
/* 262 */     this.fanr6.mirror = true;
/* 263 */     setRotation(this.fanr6, 0.0F, 0.0F, -1.570796F);
/* 264 */     this.spike4 = new ModelRenderer(this, 178, 66);
/* 265 */     this.spike4.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 266 */     this.spike4.setRotationPoint(0.0F, 16.0F, 41.0F);
/* 267 */     this.spike4.setTextureSize(64, 32);
/* 268 */     this.spike4.mirror = true;
/* 269 */     setRotation(this.spike4, -0.0523599F, 0.5235988F, 0.0F);
/* 270 */     this.spike5 = new ModelRenderer(this, 178, 66);
/* 271 */     this.spike5.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 272 */     this.spike5.setRotationPoint(0.0F, 16.0F, 41.0F);
/* 273 */     this.spike5.setTextureSize(64, 32);
/* 274 */     this.spike5.mirror = true;
/* 275 */     setRotation(this.spike5, -0.0523599F, -0.5759587F, 0.0F);
/* 276 */     this.spike3 = new ModelRenderer(this, 178, 66);
/* 277 */     this.spike3.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 278 */     this.spike3.setRotationPoint(0.0F, 13.5F, 30.5F);
/* 279 */     this.spike3.setTextureSize(64, 32);
/* 280 */     this.spike3.mirror = true;
/* 281 */     setRotation(this.spike3, 0.3141593F, 0.0F, 0.0F);
/* 282 */     this.fanl7 = new ModelRenderer(this, 130, 10);
/* 283 */     this.fanl7.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 284 */     this.fanl7.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 285 */     this.fanl7.setTextureSize(64, 32);
/* 286 */     this.fanl7.mirror = true;
/* 287 */     setRotation(this.fanl7, 0.0F, 0.0F, 1.832596F);
/* 288 */     this.fanr7 = new ModelRenderer(this, 130, 10);
/* 289 */     this.fanr7.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 290 */     this.fanr7.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 291 */     this.fanr7.setTextureSize(64, 32);
/* 292 */     this.fanr7.mirror = true;
/* 293 */     setRotation(this.fanr7, 0.0F, 0.0F, -1.832596F);
/* 294 */     this.head = new ModelRenderer(this, 200, 0);
/* 295 */     this.head.addBox(-3.0F, -4.0F, -7.0F, 6, 7, 8);
/* 296 */     this.head.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 297 */     this.head.setTextureSize(64, 32);
/* 298 */     this.head.mirror = true;
/* 299 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/* 300 */     this.head1 = new ModelRenderer(this, 200, 18);
/* 301 */     this.head1.addBox(-2.5F, -2.0F, -15.0F, 5, 2, 8);
/* 302 */     this.head1.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 303 */     this.head1.setTextureSize(64, 32);
/* 304 */     this.head1.mirror = true;
/* 305 */     setRotation(this.head1, 0.0F, 0.0F, 0.0F);
/* 306 */     this.jaw1 = new ModelRenderer(this, 200, 43);
/* 307 */     this.jaw1.addBox(-2.0F, -1.0F, -7.0F, 4, 2, 8);
/* 308 */     this.jaw1.setRotationPoint(0.0F, -2.0F, -19.0F);
/* 309 */     this.jaw1.setTextureSize(64, 32);
/* 310 */     this.jaw1.mirror = true;
/* 311 */     setRotation(this.jaw1, 0.0F, 0.0F, 0.0F);
/* 312 */     this.head2 = new ModelRenderer(this, 200, 31);
/* 313 */     this.head2.addBox(-2.0F, -2.0F, -22.0F, 4, 2, 7);
/* 314 */     this.head2.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 315 */     this.head2.setTextureSize(64, 32);
/* 316 */     this.head2.mirror = true;
/* 317 */     setRotation(this.head2, 0.0F, 0.0F, 0.0F);
/* 318 */     this.jaw2 = new ModelRenderer(this, 200, 56);
/* 319 */     this.jaw2.addBox(-1.5F, -1.0F, -13.0F, 3, 2, 6);
/* 320 */     this.jaw2.setRotationPoint(0.0F, -2.0F, -19.0F);
/* 321 */     this.jaw2.setTextureSize(64, 32);
/* 322 */     this.jaw2.mirror = true;
/* 323 */     setRotation(this.jaw2, 0.0F, 0.0F, 0.0F);
/* 324 */     this.fang1 = new ModelRenderer(this, 42, 0);
/* 325 */     this.fang1.addBox(1.0F, 0.0F, -20.0F, 1, 5, 1);
/* 326 */     this.fang1.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 327 */     this.fang1.setTextureSize(64, 32);
/* 328 */     this.fang1.mirror = true;
/* 329 */     setRotation(this.fang1, 0.0F, 0.0F, 0.0F);
/* 330 */     this.fang2 = new ModelRenderer(this, 50, 0);
/* 331 */     this.fang2.addBox(-2.0F, 0.0F, -20.0F, 1, 5, 1);
/* 332 */     this.fang2.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 333 */     this.fang2.setTextureSize(64, 32);
/* 334 */     this.fang2.mirror = true;
/* 335 */     setRotation(this.fang2, 0.0F, 0.0F, 0.0F);
/* 336 */     this.fang3 = new ModelRenderer(this, 60, 0);
/* 337 */     this.fang3.addBox(1.0F, 0.0F, -14.0F, 1, 3, 1);
/* 338 */     this.fang3.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 339 */     this.fang3.setTextureSize(64, 32);
/* 340 */     this.fang3.mirror = true;
/* 341 */     setRotation(this.fang3, 0.0F, 0.0F, 0.0F);
/* 342 */     this.fang4 = new ModelRenderer(this, 69, 0);
/* 343 */     this.fang4.addBox(-2.0F, 0.0F, -14.0F, 1, 3, 1);
/* 344 */     this.fang4.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 345 */     this.fang4.setTextureSize(64, 32);
/* 346 */     this.fang4.mirror = true;
/* 347 */     setRotation(this.fang4, 0.0F, 0.0F, 0.0F);
/* 348 */     this.spike2 = new ModelRenderer(this, 178, 66);
/* 349 */     this.spike2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 350 */     this.spike2.setRotationPoint(0.0F, 9.5F, 20.5F);
/* 351 */     this.spike2.setTextureSize(64, 32);
/* 352 */     this.spike2.mirror = true;
/* 353 */     setRotation(this.spike2, 0.3141593F, 0.0F, 0.0F);
/* 354 */     this.spike1 = new ModelRenderer(this, 178, 66);
/* 355 */     this.spike1.addBox(-0.5F, -1.5F, 0.0F, 1, 1, 11);
/* 356 */     this.spike1.setRotationPoint(0.0F, 6.5F, 10.5F);
/* 357 */     this.spike1.setTextureSize(64, 32);
/* 358 */     this.spike1.mirror = true;
/* 359 */     setRotation(this.spike1, 0.3141593F, 0.0F, 0.0F);
/* 360 */     this.arml1 = new ModelRenderer(this, 50, 98);
/* 361 */     this.arml1.addBox(0.0F, 0.0F, -2.0F, 11, 3, 4);
/* 362 */     this.arml1.setRotationPoint(2.0F, -1.0F, -6.0F);
/* 363 */     this.arml1.setTextureSize(64, 32);
/* 364 */     this.arml1.mirror = true;
/* 365 */     setRotation(this.arml1, 0.0F, -0.5235988F, 0.1745329F);
/* 366 */     this.armr1 = new ModelRenderer(this, 49, 88);
/* 367 */     this.armr1.addBox(0.0F, 0.0F, -2.0F, 11, 3, 4);
/* 368 */     this.armr1.setRotationPoint(-3.0F, -1.0F, -6.0F);
/* 369 */     this.armr1.setTextureSize(64, 32);
/* 370 */     this.armr1.mirror = true;
/* 371 */     setRotation(this.armr1, 0.0F, -2.617994F, -0.1745329F);
/* 372 */     this.arml2 = new ModelRenderer(this, 41, 107);
/* 373 */     this.arml2.addBox(0.0F, -1.0F, -1.0F, 15, 3, 3);
/* 374 */     this.arml2.setRotationPoint(11.0F, 2.0F, -1.0F);
/* 375 */     this.arml2.setTextureSize(64, 32);
/* 376 */     this.arml2.mirror = true;
/* 377 */     setRotation(this.arml2, 0.0F, 0.8552113F, 0.0F);
/* 378 */     this.armr2 = new ModelRenderer(this, 42, 115);
/* 379 */     this.armr2.addBox(0.0F, -1.0F, -2.0F, 15, 3, 3);
/* 380 */     this.armr2.setRotationPoint(-11.0F, 2.0F, -1.0F);
/* 381 */     this.armr2.setTextureSize(64, 32);
/* 382 */     this.armr2.mirror = true;
/* 383 */     setRotation(this.armr2, 0.0F, 2.268928F, 0.0F);
/* 384 */     this.clawr1 = new ModelRenderer(this, 100, 85);
/* 385 */     this.clawr1.addBox(-0.5F, -1.0F, -6.0F, 1, 1, 6);
/* 386 */     this.clawr1.setRotationPoint(-21.0F, 2.0F, -12.0F);
/* 387 */     this.clawr1.setTextureSize(64, 32);
/* 388 */     this.clawr1.mirror = true;
/* 389 */     setRotation(this.clawr1, -0.1745329F, 0.4363323F, 0.0F);
/* 390 */     this.clawr2 = new ModelRenderer(this, 100, 94);
/* 391 */     this.clawr2.addBox(0.0F, 0.0F, -10.0F, 1, 1, 10);
/* 392 */     this.clawr2.setRotationPoint(-21.0F, 2.0F, -12.0F);
/* 393 */     this.clawr2.setTextureSize(64, 32);
/* 394 */     this.clawr2.mirror = true;
/* 395 */     setRotation(this.clawr2, 0.0F, 0.8726646F, 0.0F);
/* 396 */     this.clawr3 = new ModelRenderer(this, 100, 107);
/* 397 */     this.clawr3.addBox(0.0F, 1.0F, -6.0F, 1, 1, 6);
/* 398 */     this.clawr3.setRotationPoint(-21.0F, 2.0F, -12.0F);
/* 399 */     this.clawr3.setTextureSize(64, 32);
/* 400 */     this.clawr3.mirror = true;
/* 401 */     setRotation(this.clawr3, 0.1745329F, 0.4363323F, 0.0F);
/* 402 */     this.clawl2 = new ModelRenderer(this, 130, 94);
/* 403 */     this.clawl2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 10);
/* 404 */     this.clawl2.setRotationPoint(21.0F, 2.0F, -12.0F);
/* 405 */     this.clawl2.setTextureSize(64, 32);
/* 406 */     this.clawl2.mirror = true;
/* 407 */     setRotation(this.clawl2, 0.0F, 2.268928F, 0.0F);
/* 408 */     this.clawl3 = new ModelRenderer(this, 130, 109);
/* 409 */     this.clawl3.addBox(0.0F, 1.0F, 0.0F, 1, 1, 6);
/* 410 */     this.clawl3.setRotationPoint(21.0F, 2.0F, -12.0F);
/* 411 */     this.clawl3.setTextureSize(64, 32);
/* 412 */     this.clawl3.mirror = true;
/* 413 */     setRotation(this.clawl3, -0.1745329F, 2.70526F, 0.0F);
/* 414 */     this.clawl1 = new ModelRenderer(this, 130, 83);
/* 415 */     this.clawl1.addBox(0.0F, -1.0F, 0.0F, 1, 1, 6);
/* 416 */     this.clawl1.setRotationPoint(21.0F, 2.0F, -12.0F);
/* 417 */     this.clawl1.setTextureSize(64, 32);
/* 418 */     this.clawl1.mirror = true;
/* 419 */     setRotation(this.clawl1, 0.1745329F, 2.70526F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 424 */     Alien e = (Alien)entity;
/* 425 */     RenderInfo r = null;
/* 426 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 427 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 428 */     float newangle = 0.0F, nextangle = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 432 */     newangle = MathHelper.cos(f2 * 4.0F * this.wingspeed) * 3.1415927F * 0.5F * f1;
/* 433 */     doLeftLeg(newangle);
/* 434 */     doRightLeg(-newangle);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 439 */     if (e.getAttacking() == 0) {
/* 440 */       this.fan.rotateAngleZ = 0.0F;
/* 441 */       this.fanl1.rotateAngleZ = 0.0F;
/* 442 */       this.fanl2.rotateAngleZ = 0.0F;
/* 443 */       this.fanl3.rotateAngleZ = 0.0F;
/* 444 */       this.fanl4.rotateAngleZ = 0.0F;
/* 445 */       this.fanl5.rotateAngleZ = 0.0F;
/* 446 */       this.fanl6.rotateAngleZ = 0.0F;
/* 447 */       this.fanl7.rotateAngleZ = 0.0F;
/* 448 */       this.fanr1.rotateAngleZ = 0.0F;
/* 449 */       this.fanr2.rotateAngleZ = 0.0F;
/* 450 */       this.fanr3.rotateAngleZ = 0.0F;
/* 451 */       this.fanr4.rotateAngleZ = 0.0F;
/* 452 */       this.fanr5.rotateAngleZ = 0.0F;
/* 453 */       this.fanr6.rotateAngleZ = 0.0F;
/* 454 */       this.fanr7.rotateAngleZ = 0.0F;
/*     */       
/* 456 */       this.fan.rotateAngleX = -1.85F;
/* 457 */       this.fanl1.rotateAngleX = -1.85F;
/* 458 */       this.fanl2.rotateAngleX = -1.85F;
/* 459 */       this.fanl3.rotateAngleX = -1.85F;
/* 460 */       this.fanl4.rotateAngleX = -1.85F;
/* 461 */       this.fanl5.rotateAngleX = -1.85F;
/* 462 */       this.fanl6.rotateAngleX = -1.85F;
/* 463 */       this.fanl7.rotateAngleX = -1.85F;
/* 464 */       this.fanr1.rotateAngleX = -1.85F;
/* 465 */       this.fanr2.rotateAngleX = -1.85F;
/* 466 */       this.fanr3.rotateAngleX = -1.85F;
/* 467 */       this.fanr4.rotateAngleX = -1.85F;
/* 468 */       this.fanr5.rotateAngleX = -1.85F;
/* 469 */       this.fanr6.rotateAngleX = -1.85F;
/* 470 */       this.fanr7.rotateAngleX = -1.85F;
/*     */     } else {
/* 472 */       float pi6 = 0.5235988F;
/* 473 */       float fanspeed = 1.22F;
/* 474 */       float fanamp = 0.1F;
/*     */       
/* 476 */       this.fan.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed) * 3.1415927F * fanamp;
/* 477 */       this.fanl1.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 1.0F * pi6) * 3.1415927F * fanamp;
/* 478 */       this.fanl2.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 2.0F * pi6) * 3.1415927F * fanamp;
/* 479 */       this.fanl3.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 3.0F * pi6) * 3.1415927F * fanamp;
/* 480 */       this.fanl4.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 4.0F * pi6) * 3.1415927F * fanamp;
/* 481 */       this.fanl5.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 5.0F * pi6) * 3.1415927F * fanamp;
/* 482 */       this.fanl6.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 6.0F * pi6) * 3.1415927F * fanamp;
/* 483 */       this.fanl7.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 7.0F * pi6) * 3.1415927F * fanamp;
/* 484 */       this.fanr1.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 1.0F * pi6) * 3.1415927F * fanamp;
/* 485 */       this.fanr2.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 2.0F * pi6) * 3.1415927F * fanamp;
/* 486 */       this.fanr3.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 3.0F * pi6) * 3.1415927F * fanamp;
/* 487 */       this.fanr4.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 4.0F * pi6) * 3.1415927F * fanamp;
/* 488 */       this.fanr5.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 5.0F * pi6) * 3.1415927F * fanamp;
/* 489 */       this.fanr6.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 6.0F * pi6) * 3.1415927F * fanamp;
/* 490 */       this.fanr7.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 7.0F * pi6) * 3.1415927F * fanamp;
/*     */       
/* 492 */       this.fan.rotateAngleZ = 0.0F;
/* 493 */       this.fanl1.rotateAngleZ = 0.261F;
/* 494 */       this.fanl2.rotateAngleZ = 0.523F;
/* 495 */       this.fanl3.rotateAngleZ = 0.785F;
/* 496 */       this.fanl4.rotateAngleZ = 1.047F;
/* 497 */       this.fanl5.rotateAngleZ = 1.309F;
/* 498 */       this.fanl6.rotateAngleZ = 1.571F;
/* 499 */       this.fanl7.rotateAngleZ = 1.832F;
/*     */       
/* 501 */       this.fanr1.rotateAngleZ = -0.261F;
/* 502 */       this.fanr2.rotateAngleZ = -0.523F;
/* 503 */       this.fanr3.rotateAngleZ = -0.785F;
/* 504 */       this.fanr4.rotateAngleZ = -1.047F;
/* 505 */       this.fanr5.rotateAngleZ = -1.309F;
/* 506 */       this.fanr6.rotateAngleZ = -1.571F;
/* 507 */       this.fanr7.rotateAngleZ = -1.832F;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 512 */     this.neck.rotateAngleY = (float)Math.toRadians(f3) * 0.35F;
/*     */     
/* 514 */     this.head.rotateAngleY = (float)Math.toRadians(f3) * 0.75F;
/* 515 */     this.neck.rotationPointZ -= (float)Math.cos(this.neck.rotateAngleY) * 3.0F;
/* 516 */     this.neck.rotationPointX += (float)Math.sin(this.neck.rotateAngleY) * 3.0F;
/* 517 */     this.head1.rotateAngleY = this.head.rotateAngleY;
/* 518 */     this.head1.rotationPointZ = this.head.rotationPointZ;
/* 519 */     this.head1.rotationPointX = this.head.rotationPointX;
/* 520 */     this.head2.rotateAngleY = this.head.rotateAngleY;
/* 521 */     this.head2.rotationPointZ = this.head.rotationPointZ;
/* 522 */     this.head2.rotationPointX = this.head.rotationPointX;
/* 523 */     this.fang1.rotateAngleY = this.head.rotateAngleY;
/* 524 */     this.fang1.rotationPointZ = this.head.rotationPointZ;
/* 525 */     this.fang1.rotationPointX = this.head.rotationPointX;
/* 526 */     this.fang2.rotateAngleY = this.head.rotateAngleY;
/* 527 */     this.fang2.rotationPointZ = this.head.rotationPointZ;
/* 528 */     this.fang2.rotationPointX = this.head.rotationPointX;
/* 529 */     this.fang3.rotateAngleY = this.head.rotateAngleY;
/* 530 */     this.fang3.rotationPointZ = this.head.rotationPointZ;
/* 531 */     this.fang3.rotationPointX = this.head.rotationPointX;
/* 532 */     this.fang4.rotateAngleY = this.head.rotateAngleY;
/* 533 */     this.fang4.rotationPointZ = this.head.rotationPointZ;
/* 534 */     this.fang4.rotationPointX = this.head.rotationPointX;
/*     */     
/* 536 */     this.jaw1.rotateAngleY = this.head.rotateAngleY;
/* 537 */     this.head.rotationPointZ -= (float)Math.cos(this.head.rotateAngleY) * 8.0F;
/* 538 */     this.head.rotationPointX -= (float)Math.sin(this.head.rotateAngleY) * 8.0F;
/* 539 */     this.jaw2.rotateAngleY = this.jaw1.rotateAngleY;
/* 540 */     this.jaw2.rotationPointZ = this.jaw1.rotationPointZ;
/* 541 */     this.jaw2.rotationPointX = this.jaw1.rotationPointX;
/*     */ 
/*     */     
/* 544 */     r = e.getRenderInfo();
/*     */ 
/*     */     
/* 547 */     newangle = MathHelper.cos(f2 * 3.5F * this.wingspeed) * 3.1415927F * 0.5F;
/* 548 */     nextangle = MathHelper.cos((f2 + 0.2F) * 3.5F * this.wingspeed) * 3.1415927F * 0.5F;
/*     */     
/* 550 */     if (nextangle > 0.0F && newangle < 0.0F)
/*     */     {
/* 552 */       if (e.getAttacking() == 0) {
/* 553 */         r.ri1 = e.worldObj.rand.nextInt(15);
/* 554 */         r.ri2 = e.worldObj.rand.nextInt(15);
/* 555 */         r.ri3 = e.worldObj.rand.nextInt(15);
/*     */       } else {
/* 557 */         r.ri1 = e.worldObj.rand.nextInt(4);
/* 558 */         r.ri2 = e.worldObj.rand.nextInt(2);
/* 559 */         r.ri3 = 1;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 564 */     if (r.ri2 == 1) {
/* 565 */       doTail(newangle);
/*     */     } else {
/* 567 */       newangle = MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.05F;
/* 568 */       doTail(newangle);
/*     */     } 
/*     */ 
/*     */     
/* 572 */     if (r.ri3 == 1) {
/* 573 */       newangle = MathHelper.cos(f2 * 3.5F * this.wingspeed) * 3.1415927F * 0.35F;
/* 574 */       doJaw(newangle);
/*     */     } else {
/* 576 */       newangle = MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.02F;
/* 577 */       doJaw(newangle);
/*     */     } 
/*     */ 
/*     */     
/* 581 */     newangle = MathHelper.cos(f2 * this.wingspeed * 3.5F) * 3.1415927F * 0.2F;
/* 582 */     if (r.ri1 == 1 || r.ri1 == 3) {
/* 583 */       doLeftClaw(newangle);
/*     */     } else {
/* 585 */       newangle = MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.03F;
/* 586 */       doLeftClaw(newangle);
/*     */     } 
/* 588 */     if (r.ri1 == 2 || r.ri1 == 3) {
/* 589 */       doRightClaw(-newangle);
/*     */     } else {
/* 591 */       newangle = MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.03F;
/* 592 */       doRightClaw(-newangle);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 597 */     e.setRenderInfo(r);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 605 */     this.torso.render(f5);
/* 606 */     this.stomach.render(f5);
/* 607 */     this.rThigh.render(f5);
/* 608 */     this.lThigh.render(f5);
/* 609 */     this.lShin.render(f5);
/* 610 */     this.rShin.render(f5);
/* 611 */     this.lShin1.render(f5);
/* 612 */     this.rShin1.render(f5);
/* 613 */     this.lFoot.render(f5);
/* 614 */     this.rFoot.render(f5);
/* 615 */     this.neck.render(f5);
/* 616 */     this.tail2.render(f5);
/* 617 */     this.tail3.render(f5);
/* 618 */     this.tail4.render(f5);
/* 619 */     this.tail5.render(f5);
/* 620 */     this.tail1.render(f5);
/* 621 */     this.spike4.render(f5);
/* 622 */     this.spike5.render(f5);
/* 623 */     this.spike3.render(f5);
/* 624 */     this.head.render(f5);
/* 625 */     this.head1.render(f5);
/* 626 */     this.jaw1.render(f5);
/* 627 */     this.head2.render(f5);
/* 628 */     this.jaw2.render(f5);
/* 629 */     this.fang1.render(f5);
/* 630 */     this.fang2.render(f5);
/* 631 */     this.fang3.render(f5);
/* 632 */     this.fang4.render(f5);
/* 633 */     this.spike2.render(f5);
/* 634 */     this.spike1.render(f5);
/* 635 */     this.arml1.render(f5);
/* 636 */     this.armr1.render(f5);
/* 637 */     this.arml2.render(f5);
/* 638 */     this.armr2.render(f5);
/* 639 */     this.clawr1.render(f5);
/* 640 */     this.clawr2.render(f5);
/* 641 */     this.clawr3.render(f5);
/* 642 */     this.clawl2.render(f5);
/* 643 */     this.clawl3.render(f5);
/* 644 */     this.clawl1.render(f5);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 649 */     this.fan.render(f5);
/* 650 */     this.fanl1.render(f5);
/* 651 */     this.fanr1.render(f5);
/* 652 */     this.fanl2.render(f5);
/* 653 */     this.fanr2.render(f5);
/* 654 */     this.fanl3.render(f5);
/* 655 */     this.fanr3.render(f5);
/* 656 */     this.fanl4.render(f5);
/* 657 */     this.fanr4.render(f5);
/* 658 */     this.fanl5.render(f5);
/* 659 */     this.fanr5.render(f5);
/* 660 */     this.fanl6.render(f5);
/* 661 */     this.fanr6.render(f5);
/* 662 */     this.fanl7.render(f5);
/* 663 */     this.fanr7.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 673 */     model.rotateAngleX = x;
/* 674 */     model.rotateAngleY = y;
/* 675 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 681 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ 
/*     */   
/*     */   private void doLeftLeg(float angle) {
/* 686 */     this.lFoot.rotateAngleX = angle;
/* 687 */     this.lShin.rotateAngleX = angle - 0.4F;
/* 688 */     this.lShin1.rotateAngleX = angle - 0.8F;
/* 689 */     this.lThigh.rotateAngleX = angle - 0.8F;
/*     */   }
/*     */ 
/*     */   
/*     */   private void doRightLeg(float angle) {
/* 694 */     this.rFoot.rotateAngleX = angle;
/* 695 */     this.rShin.rotateAngleX = angle - 0.4F;
/* 696 */     this.rShin1.rotateAngleX = angle - 0.8F;
/* 697 */     this.rThigh.rotateAngleX = angle - 0.8F;
/*     */   }
/*     */ 
/*     */   
/*     */   private void doJaw(float angle) {
/* 702 */     this.jaw1.rotateAngleX = Math.abs(angle);
/* 703 */     this.jaw2.rotateAngleX = this.jaw1.rotateAngleX;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doTail(float angle) {
/* 712 */     this.tail1.rotateAngleY = angle * 0.25F;
/* 713 */     this.spike1.rotateAngleY = this.tail1.rotateAngleY;
/*     */     
/* 715 */     this.tail2.rotateAngleY = angle * 0.5F;
/* 716 */     this.tail1.rotationPointZ += (float)Math.cos(this.tail1.rotateAngleY) * 10.0F;
/* 717 */     this.tail1.rotationPointX += (float)Math.sin(this.tail1.rotateAngleY) * 10.0F;
/* 718 */     this.spike2.rotateAngleY = this.tail2.rotateAngleY;
/* 719 */     this.spike2.rotationPointZ = this.tail2.rotationPointZ;
/* 720 */     this.spike2.rotationPointX = this.tail2.rotationPointX;
/*     */     
/* 722 */     this.tail3.rotateAngleY = angle * 0.8F;
/* 723 */     this.tail2.rotationPointZ += (float)Math.cos(this.tail2.rotateAngleY) * 10.0F;
/* 724 */     this.tail2.rotationPointX += (float)Math.sin(this.tail2.rotateAngleY) * 10.0F;
/* 725 */     this.spike3.rotateAngleY = this.tail3.rotateAngleY;
/* 726 */     this.spike3.rotationPointZ = this.tail3.rotationPointZ;
/* 727 */     this.spike3.rotationPointX = this.tail3.rotationPointX;
/*     */     
/* 729 */     this.tail4.rotateAngleY = angle * 1.25F;
/* 730 */     this.tail3.rotationPointZ += (float)Math.cos(this.tail3.rotateAngleY) * 10.0F;
/* 731 */     this.tail3.rotationPointX += (float)Math.sin(this.tail3.rotateAngleY) * 10.0F;
/* 732 */     this.tail4.rotateAngleY += 0.52F;
/* 733 */     this.spike4.rotationPointZ = this.tail4.rotationPointZ;
/* 734 */     this.spike4.rotationPointX = this.tail4.rotationPointX;
/* 735 */     this.tail4.rotateAngleY -= 0.52F;
/* 736 */     this.spike5.rotationPointZ = this.tail4.rotationPointZ;
/* 737 */     this.spike5.rotationPointX = this.tail4.rotationPointX;
/*     */     
/* 739 */     this.tail5.rotateAngleY = angle * 1.5F;
/* 740 */     this.tail4.rotationPointZ += (float)Math.cos(this.tail4.rotateAngleY) * 10.0F;
/* 741 */     this.tail4.rotationPointX += (float)Math.sin(this.tail4.rotateAngleY) * 10.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doLeftClaw(float angle) {
/* 748 */     this.arml1.rotateAngleY = -0.52F + Math.abs(angle * 2.0F);
/* 749 */     this.arml1.rotationPointZ -= (float)Math.sin(this.arml1.rotateAngleY) * 9.0F;
/* 750 */     this.arml1.rotationPointX += (float)Math.cos(this.arml1.rotateAngleY) * 9.0F;
/* 751 */     this.arml2.rotateAngleY = 0.855F + Math.abs(angle);
/* 752 */     this.arml2.rotationPointZ -= (float)Math.sin(this.arml2.rotateAngleY) * 14.0F;
/* 753 */     this.arml2.rotationPointX += (float)Math.cos(this.arml2.rotateAngleY) * 14.0F;
/* 754 */     this.clawl1.rotateAngleY = 2.7F + Math.abs(angle * 4.0F);
/* 755 */     this.clawl2.rotationPointZ = this.clawl1.rotationPointZ;
/* 756 */     this.clawl2.rotationPointX = this.clawl1.rotationPointX;
/* 757 */     this.clawl2.rotateAngleY = 2.27F + Math.abs(angle * 4.0F);
/* 758 */     this.clawl3.rotationPointZ = this.clawl1.rotationPointZ;
/* 759 */     this.clawl3.rotationPointX = this.clawl1.rotationPointX;
/* 760 */     this.clawl3.rotateAngleY = 2.7F + Math.abs(angle * 4.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void doRightClaw(float angle) {
/* 766 */     this.armr1.rotateAngleY = -2.61F - Math.abs(angle * 2.0F);
/* 767 */     this.armr1.rotationPointZ -= (float)Math.sin(this.armr1.rotateAngleY) * 9.0F;
/* 768 */     this.armr1.rotationPointX += (float)Math.cos(this.armr1.rotateAngleY) * 9.0F;
/* 769 */     this.armr2.rotateAngleY = 2.27F - Math.abs(angle);
/* 770 */     this.armr2.rotationPointZ -= (float)Math.sin(this.armr2.rotateAngleY) * 14.0F;
/* 771 */     this.armr2.rotationPointX += (float)Math.cos(this.armr2.rotateAngleY) * 14.0F;
/* 772 */     this.clawr1.rotateAngleY = 0.436F - Math.abs(angle * 4.0F);
/* 773 */     this.clawr2.rotationPointZ = this.clawr1.rotationPointZ;
/* 774 */     this.clawr2.rotationPointX = this.clawr1.rotationPointX;
/* 775 */     this.clawr2.rotateAngleY = 0.87F - Math.abs(angle * 4.0F);
/* 776 */     this.clawr3.rotationPointZ = this.clawr1.rotationPointZ;
/* 777 */     this.clawr3.rotationPointX = this.clawr1.rotationPointX;
/* 778 */     this.clawr3.rotateAngleY = 0.436F - Math.abs(angle * 4.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelAlien.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */