/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.Alien;
/*     */ import danger.orespawn.entity.RenderInfo;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ public class ModelAlien extends ModelBase {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer torso;
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
/*  70 */     this.wingspeed = f1;
/*     */     
/*  72 */     this.textureWidth = 256;
/*  73 */     this.textureHeight = 128;
/*     */     
/*  75 */     this.torso = new ModelRenderer(this, 0, 46);
/*  76 */     this.torso.addBox(-4.5F, -2.0F, 0.0F, 9, 8, 10);
/*  77 */     this.torso.setRotationPoint(0.0F, -2.5F, -8.0F);
/*  78 */     this.torso.setTextureSize(64, 32);
/*  79 */     this.torso.mirror = true;
/*  80 */     setRotation(this.torso, -0.1919862F, 0.0F, 0.0F);
/*  81 */     this.stomach = new ModelRenderer(this, 0, 27);
/*  82 */     this.stomach.addBox(-3.5F, -5.0F, 8.0F, 7, 6, 12);
/*  83 */     this.stomach.setRotationPoint(0.0F, -2.5F, -8.0F);
/*  84 */     this.stomach.setTextureSize(64, 32);
/*  85 */     this.stomach.mirror = true;
/*  86 */     setRotation(this.stomach, -0.5585054F, 0.0F, 0.0F);
/*  87 */     this.rThigh = new ModelRenderer(this, 59, 45);
/*  88 */     this.rThigh.addBox(-1.5F, -4.0F, -2.5F, 4, 14, 5);
/*  89 */     this.rThigh.setRotationPoint(-4.5F, 7.0F, 8.0F);
/*  90 */     this.rThigh.setTextureSize(64, 32);
/*  91 */     this.rThigh.mirror = true;
/*  92 */     setRotation(this.rThigh, -0.8028515F, 0.2443461F, 0.418879F);
/*  93 */     this.lThigh = new ModelRenderer(this, 40, 45);
/*  94 */     this.lThigh.addBox(-2.5F, -4.0F, -2.5F, 4, 14, 5);
/*  95 */     this.lThigh.setRotationPoint(4.5F, 7.0F, 8.0F);
/*  96 */     this.lThigh.setTextureSize(64, 32);
/*  97 */     this.lThigh.mirror = true;
/*  98 */     setRotation(this.lThigh, -0.8028515F, -0.2443461F, -0.418879F);
/*  99 */     this.lShin = new ModelRenderer(this, 79, 49);
/* 100 */     this.lShin.addBox(-2.0F, 8.0F, -5.5F, 3, 3, 12);
/* 101 */     this.lShin.setRotationPoint(4.5F, 7.0F, 8.0F);
/* 102 */     this.lShin.setTextureSize(64, 32);
/* 103 */     this.lShin.mirror = true;
/* 104 */     setRotation(this.lShin, -0.4014257F, -0.2443461F, -0.418879F);
/* 105 */     this.rShin = new ModelRenderer(this, 79, 33);
/* 106 */     this.rShin.addBox(-1.0F, 8.0F, -5.5F, 3, 3, 12);
/* 107 */     this.rShin.setRotationPoint(-4.5F, 7.0F, 8.0F);
/* 108 */     this.rShin.setTextureSize(64, 32);
/* 109 */     this.rShin.mirror = true;
/* 110 */     setRotation(this.rShin, -0.4014257F, 0.2443461F, 0.418879F);
/* 111 */     this.lShin1 = new ModelRenderer(this, 113, 40);
/* 112 */     this.lShin1.addBox(-1.5F, 5.5F, 9.0F, 2, 9, 2);
/* 113 */     this.lShin1.setRotationPoint(4.5F, 7.0F, 8.0F);
/* 114 */     this.lShin1.setTextureSize(64, 32);
/* 115 */     this.lShin1.mirror = true;
/* 116 */     setRotation(this.lShin1, -0.8028515F, -0.2443461F, -0.418879F);
/* 117 */     this.rShin1 = new ModelRenderer(this, 113, 53);
/* 118 */     this.rShin1.addBox(-0.5F, 5.5F, 9.0F, 2, 9, 2);
/* 119 */     this.rShin1.setRotationPoint(-4.5F, 7.0F, 8.0F);
/* 120 */     this.rShin1.setTextureSize(64, 32);
/* 121 */     this.rShin1.mirror = true;
/* 122 */     setRotation(this.rShin1, -0.8028515F, 0.2443461F, 0.418879F);
/* 123 */     this.lFoot = new ModelRenderer(this, 110, 24);
/* 124 */     this.lFoot.addBox(5.0F, 15.0F, -8.0F, 2, 2, 6);
/* 125 */     this.lFoot.setRotationPoint(4.5F, 7.0F, 8.0F);
/* 126 */     this.lFoot.setTextureSize(64, 32);
/* 127 */     this.lFoot.mirror = true;
/* 128 */     setRotation(this.lFoot, 0.0F, -0.2443461F, 0.0F);
/* 129 */     this.rFoot = new ModelRenderer(this, 95, 24);
/* 130 */     this.rFoot.addBox(-7.0F, 15.0F, -8.0F, 2, 2, 6);
/* 131 */     this.rFoot.setRotationPoint(-4.5F, 7.0F, 8.0F);
/* 132 */     this.rFoot.setTextureSize(64, 32);
/* 133 */     this.rFoot.mirror = true;
/* 134 */     setRotation(this.rFoot, 0.0F, 0.2443461F, 0.0F);
/* 135 */     this.neck = new ModelRenderer(this, 23, 86);
/* 136 */     this.neck.addBox(-2.0F, -2.0F, -4.0F, 4, 6, 5);
/* 137 */     this.neck.setRotationPoint(0.0F, -2.5F, -8.0F);
/* 138 */     this.neck.setTextureSize(64, 32);
/* 139 */     this.neck.mirror = true;
/* 140 */     setRotation(this.neck, -0.1919862F, 0.0F, 0.0F);
/* 141 */     this.fan = new ModelRenderer(this, 149, 10);
/* 142 */     this.fan.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 143 */     this.fan.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 144 */     this.fan.setTextureSize(64, 32);
/* 145 */     this.fan.mirror = true;
/* 146 */     setRotation(this.fan, 0.0F, 0.0F, 0.0F);
/* 147 */     this.tail2 = new ModelRenderer(this, 85, 66);
/* 148 */     this.tail2.addBox(-2.0F, -1.5F, 0.0F, 4, 4, 11);
/* 149 */     this.tail2.setRotationPoint(0.0F, 9.5F, 20.5F);
/* 150 */     this.tail2.setTextureSize(64, 32);
/* 151 */     this.tail2.mirror = true;
/* 152 */     setRotation(this.tail2, -0.3141593F, 0.0F, 0.0F);
/* 153 */     this.tail3 = new ModelRenderer(this, 118, 66);
/* 154 */     this.tail3.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 11);
/* 155 */     this.tail3.setRotationPoint(0.0F, 13.5F, 30.5F);
/* 156 */     this.tail3.setTextureSize(64, 32);
/* 157 */     this.tail3.mirror = true;
/* 158 */     setRotation(this.tail3, -0.2094395F, 0.0F, 0.0F);
/* 159 */     this.tail4 = new ModelRenderer(this, 149, 66);
/* 160 */     this.tail4.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 11);
/* 161 */     this.tail4.setRotationPoint(0.0F, 15.5F, 40.5F);
/* 162 */     this.tail4.setTextureSize(64, 32);
/* 163 */     this.tail4.mirror = true;
/* 164 */     setRotation(this.tail4, -0.1396263F, 0.0F, 0.0F);
/* 165 */     this.tail5 = new ModelRenderer(this, 178, 66);
/* 166 */     this.tail5.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 167 */     this.tail5.setRotationPoint(0.0F, 17.5F, 50.5F);
/* 168 */     this.tail5.setTextureSize(64, 32);
/* 169 */     this.tail5.mirror = true;
/* 170 */     setRotation(this.tail5, -0.0523599F, 0.0F, 0.0F);
/* 171 */     this.tail1 = new ModelRenderer(this, 50, 66);
/* 172 */     this.tail1.addBox(-2.0F, -2.5F, 0.0F, 4, 4, 11);
/* 173 */     this.tail1.setRotationPoint(0.0F, 6.5F, 10.5F);
/* 174 */     this.tail1.setTextureSize(64, 32);
/* 175 */     this.tail1.mirror = true;
/* 176 */     setRotation(this.tail1, -0.4014257F, 0.0F, 0.0F);
/* 177 */     this.fanl1 = new ModelRenderer(this, 130, 10);
/* 178 */     this.fanl1.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 179 */     this.fanl1.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 180 */     this.fanl1.setTextureSize(64, 32);
/* 181 */     this.fanl1.mirror = true;
/* 182 */     setRotation(this.fanl1, 0.0F, 0.0F, 0.2617994F);
/* 183 */     this.fanr1 = new ModelRenderer(this, 130, 10);
/* 184 */     this.fanr1.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 185 */     this.fanr1.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 186 */     this.fanr1.setTextureSize(64, 32);
/* 187 */     this.fanr1.mirror = true;
/* 188 */     setRotation(this.fanr1, 0.0F, 0.0F, -0.2617994F);
/* 189 */     this.fanl2 = new ModelRenderer(this, 130, 10);
/* 190 */     this.fanl2.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 191 */     this.fanl2.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 192 */     this.fanl2.setTextureSize(64, 32);
/* 193 */     this.fanl2.mirror = true;
/* 194 */     setRotation(this.fanl2, 0.0F, 0.0F, 0.5235988F);
/* 195 */     this.fanr2 = new ModelRenderer(this, 130, 10);
/* 196 */     this.fanr2.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 197 */     this.fanr2.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 198 */     this.fanr2.setTextureSize(64, 32);
/* 199 */     this.fanr2.mirror = true;
/* 200 */     setRotation(this.fanr2, 0.0F, 0.0F, -0.5235988F);
/* 201 */     this.fanl3 = new ModelRenderer(this, 130, 10);
/* 202 */     this.fanl3.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 203 */     this.fanl3.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 204 */     this.fanl3.setTextureSize(64, 32);
/* 205 */     this.fanl3.mirror = true;
/* 206 */     setRotation(this.fanl3, 0.0F, 0.0F, 0.7853982F);
/* 207 */     this.fanr3 = new ModelRenderer(this, 130, 10);
/* 208 */     this.fanr3.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 209 */     this.fanr3.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 210 */     this.fanr3.setTextureSize(64, 32);
/* 211 */     this.fanr3.mirror = true;
/* 212 */     setRotation(this.fanr3, 0.0F, 0.0F, -0.7853982F);
/* 213 */     this.fanl4 = new ModelRenderer(this, 130, 10);
/* 214 */     this.fanl4.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 215 */     this.fanl4.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 216 */     this.fanl4.setTextureSize(64, 32);
/* 217 */     this.fanl4.mirror = true;
/* 218 */     setRotation(this.fanl4, 0.0F, 0.0F, 1.047198F);
/* 219 */     this.fanr4 = new ModelRenderer(this, 130, 10);
/* 220 */     this.fanr4.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 221 */     this.fanr4.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 222 */     this.fanr4.setTextureSize(64, 32);
/* 223 */     this.fanr4.mirror = true;
/* 224 */     setRotation(this.fanr4, 0.0F, 0.0F, -1.047198F);
/* 225 */     this.fanl5 = new ModelRenderer(this, 130, 10);
/* 226 */     this.fanl5.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 227 */     this.fanl5.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 228 */     this.fanl5.setTextureSize(64, 32);
/* 229 */     this.fanl5.mirror = true;
/* 230 */     setRotation(this.fanl5, 0.0F, 0.0F, 1.308997F);
/* 231 */     this.fanr5 = new ModelRenderer(this, 130, 10);
/* 232 */     this.fanr5.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 233 */     this.fanr5.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 234 */     this.fanr5.setTextureSize(64, 32);
/* 235 */     this.fanr5.mirror = true;
/* 236 */     setRotation(this.fanr5, 0.0F, 0.0F, -1.308997F);
/* 237 */     this.fanl6 = new ModelRenderer(this, 130, 10);
/* 238 */     this.fanl6.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 239 */     this.fanl6.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 240 */     this.fanl6.setTextureSize(64, 32);
/* 241 */     this.fanl6.mirror = true;
/* 242 */     setRotation(this.fanl6, 0.0F, 0.0F, 1.570796F);
/* 243 */     this.fanr6 = new ModelRenderer(this, 130, 10);
/* 244 */     this.fanr6.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 245 */     this.fanr6.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 246 */     this.fanr6.setTextureSize(64, 32);
/* 247 */     this.fanr6.mirror = true;
/* 248 */     setRotation(this.fanr6, 0.0F, 0.0F, -1.570796F);
/* 249 */     this.spike4 = new ModelRenderer(this, 178, 66);
/* 250 */     this.spike4.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 251 */     this.spike4.setRotationPoint(0.0F, 16.0F, 41.0F);
/* 252 */     this.spike4.setTextureSize(64, 32);
/* 253 */     this.spike4.mirror = true;
/* 254 */     setRotation(this.spike4, -0.0523599F, 0.5235988F, 0.0F);
/* 255 */     this.spike5 = new ModelRenderer(this, 178, 66);
/* 256 */     this.spike5.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 257 */     this.spike5.setRotationPoint(0.0F, 16.0F, 41.0F);
/* 258 */     this.spike5.setTextureSize(64, 32);
/* 259 */     this.spike5.mirror = true;
/* 260 */     setRotation(this.spike5, -0.0523599F, -0.5759587F, 0.0F);
/* 261 */     this.spike3 = new ModelRenderer(this, 178, 66);
/* 262 */     this.spike3.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 263 */     this.spike3.setRotationPoint(0.0F, 13.5F, 30.5F);
/* 264 */     this.spike3.setTextureSize(64, 32);
/* 265 */     this.spike3.mirror = true;
/* 266 */     setRotation(this.spike3, 0.3141593F, 0.0F, 0.0F);
/* 267 */     this.fanl7 = new ModelRenderer(this, 130, 10);
/* 268 */     this.fanl7.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 269 */     this.fanl7.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 270 */     this.fanl7.setTextureSize(64, 32);
/* 271 */     this.fanl7.mirror = true;
/* 272 */     setRotation(this.fanl7, 0.0F, 0.0F, 1.832596F);
/* 273 */     this.fanr7 = new ModelRenderer(this, 130, 10);
/* 274 */     this.fanr7.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 275 */     this.fanr7.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 276 */     this.fanr7.setTextureSize(64, 32);
/* 277 */     this.fanr7.mirror = true;
/* 278 */     setRotation(this.fanr7, 0.0F, 0.0F, -1.832596F);
/* 279 */     this.head = new ModelRenderer(this, 200, 0);
/* 280 */     this.head.addBox(-3.0F, -4.0F, -7.0F, 6, 7, 8);
/* 281 */     this.head.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 282 */     this.head.setTextureSize(64, 32);
/* 283 */     this.head.mirror = true;
/* 284 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/* 285 */     this.head1 = new ModelRenderer(this, 200, 18);
/* 286 */     this.head1.addBox(-2.5F, -2.0F, -15.0F, 5, 2, 8);
/* 287 */     this.head1.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 288 */     this.head1.setTextureSize(64, 32);
/* 289 */     this.head1.mirror = true;
/* 290 */     setRotation(this.head1, 0.0F, 0.0F, 0.0F);
/* 291 */     this.jaw1 = new ModelRenderer(this, 200, 43);
/* 292 */     this.jaw1.addBox(-2.0F, -1.0F, -7.0F, 4, 2, 8);
/* 293 */     this.jaw1.setRotationPoint(0.0F, -2.0F, -19.0F);
/* 294 */     this.jaw1.setTextureSize(64, 32);
/* 295 */     this.jaw1.mirror = true;
/* 296 */     setRotation(this.jaw1, 0.0F, 0.0F, 0.0F);
/* 297 */     this.head2 = new ModelRenderer(this, 200, 31);
/* 298 */     this.head2.addBox(-2.0F, -2.0F, -22.0F, 4, 2, 7);
/* 299 */     this.head2.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 300 */     this.head2.setTextureSize(64, 32);
/* 301 */     this.head2.mirror = true;
/* 302 */     setRotation(this.head2, 0.0F, 0.0F, 0.0F);
/* 303 */     this.jaw2 = new ModelRenderer(this, 200, 56);
/* 304 */     this.jaw2.addBox(-1.5F, -1.0F, -13.0F, 3, 2, 6);
/* 305 */     this.jaw2.setRotationPoint(0.0F, -2.0F, -19.0F);
/* 306 */     this.jaw2.setTextureSize(64, 32);
/* 307 */     this.jaw2.mirror = true;
/* 308 */     setRotation(this.jaw2, 0.0F, 0.0F, 0.0F);
/* 309 */     this.fang1 = new ModelRenderer(this, 42, 0);
/* 310 */     this.fang1.addBox(1.0F, 0.0F, -20.0F, 1, 5, 1);
/* 311 */     this.fang1.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 312 */     this.fang1.setTextureSize(64, 32);
/* 313 */     this.fang1.mirror = true;
/* 314 */     setRotation(this.fang1, 0.0F, 0.0F, 0.0F);
/* 315 */     this.fang2 = new ModelRenderer(this, 50, 0);
/* 316 */     this.fang2.addBox(-2.0F, 0.0F, -20.0F, 1, 5, 1);
/* 317 */     this.fang2.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 318 */     this.fang2.setTextureSize(64, 32);
/* 319 */     this.fang2.mirror = true;
/* 320 */     setRotation(this.fang2, 0.0F, 0.0F, 0.0F);
/* 321 */     this.fang3 = new ModelRenderer(this, 60, 0);
/* 322 */     this.fang3.addBox(1.0F, 0.0F, -14.0F, 1, 3, 1);
/* 323 */     this.fang3.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 324 */     this.fang3.setTextureSize(64, 32);
/* 325 */     this.fang3.mirror = true;
/* 326 */     setRotation(this.fang3, 0.0F, 0.0F, 0.0F);
/* 327 */     this.fang4 = new ModelRenderer(this, 69, 0);
/* 328 */     this.fang4.addBox(-2.0F, 0.0F, -14.0F, 1, 3, 1);
/* 329 */     this.fang4.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 330 */     this.fang4.setTextureSize(64, 32);
/* 331 */     this.fang4.mirror = true;
/* 332 */     setRotation(this.fang4, 0.0F, 0.0F, 0.0F);
/* 333 */     this.spike2 = new ModelRenderer(this, 178, 66);
/* 334 */     this.spike2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 335 */     this.spike2.setRotationPoint(0.0F, 9.5F, 20.5F);
/* 336 */     this.spike2.setTextureSize(64, 32);
/* 337 */     this.spike2.mirror = true;
/* 338 */     setRotation(this.spike2, 0.3141593F, 0.0F, 0.0F);
/* 339 */     this.spike1 = new ModelRenderer(this, 178, 66);
/* 340 */     this.spike1.addBox(-0.5F, -1.5F, 0.0F, 1, 1, 11);
/* 341 */     this.spike1.setRotationPoint(0.0F, 6.5F, 10.5F);
/* 342 */     this.spike1.setTextureSize(64, 32);
/* 343 */     this.spike1.mirror = true;
/* 344 */     setRotation(this.spike1, 0.3141593F, 0.0F, 0.0F);
/* 345 */     this.arml1 = new ModelRenderer(this, 50, 98);
/* 346 */     this.arml1.addBox(0.0F, 0.0F, -2.0F, 11, 3, 4);
/* 347 */     this.arml1.setRotationPoint(2.0F, -1.0F, -6.0F);
/* 348 */     this.arml1.setTextureSize(64, 32);
/* 349 */     this.arml1.mirror = true;
/* 350 */     setRotation(this.arml1, 0.0F, -0.5235988F, 0.1745329F);
/* 351 */     this.armr1 = new ModelRenderer(this, 49, 88);
/* 352 */     this.armr1.addBox(0.0F, 0.0F, -2.0F, 11, 3, 4);
/* 353 */     this.armr1.setRotationPoint(-3.0F, -1.0F, -6.0F);
/* 354 */     this.armr1.setTextureSize(64, 32);
/* 355 */     this.armr1.mirror = true;
/* 356 */     setRotation(this.armr1, 0.0F, -2.617994F, -0.1745329F);
/* 357 */     this.arml2 = new ModelRenderer(this, 41, 107);
/* 358 */     this.arml2.addBox(0.0F, -1.0F, -1.0F, 15, 3, 3);
/* 359 */     this.arml2.setRotationPoint(11.0F, 2.0F, -1.0F);
/* 360 */     this.arml2.setTextureSize(64, 32);
/* 361 */     this.arml2.mirror = true;
/* 362 */     setRotation(this.arml2, 0.0F, 0.8552113F, 0.0F);
/* 363 */     this.armr2 = new ModelRenderer(this, 42, 115);
/* 364 */     this.armr2.addBox(0.0F, -1.0F, -2.0F, 15, 3, 3);
/* 365 */     this.armr2.setRotationPoint(-11.0F, 2.0F, -1.0F);
/* 366 */     this.armr2.setTextureSize(64, 32);
/* 367 */     this.armr2.mirror = true;
/* 368 */     setRotation(this.armr2, 0.0F, 2.268928F, 0.0F);
/* 369 */     this.clawr1 = new ModelRenderer(this, 100, 85);
/* 370 */     this.clawr1.addBox(-0.5F, -1.0F, -6.0F, 1, 1, 6);
/* 371 */     this.clawr1.setRotationPoint(-21.0F, 2.0F, -12.0F);
/* 372 */     this.clawr1.setTextureSize(64, 32);
/* 373 */     this.clawr1.mirror = true;
/* 374 */     setRotation(this.clawr1, -0.1745329F, 0.4363323F, 0.0F);
/* 375 */     this.clawr2 = new ModelRenderer(this, 100, 94);
/* 376 */     this.clawr2.addBox(0.0F, 0.0F, -10.0F, 1, 1, 10);
/* 377 */     this.clawr2.setRotationPoint(-21.0F, 2.0F, -12.0F);
/* 378 */     this.clawr2.setTextureSize(64, 32);
/* 379 */     this.clawr2.mirror = true;
/* 380 */     setRotation(this.clawr2, 0.0F, 0.8726646F, 0.0F);
/* 381 */     this.clawr3 = new ModelRenderer(this, 100, 107);
/* 382 */     this.clawr3.addBox(0.0F, 1.0F, -6.0F, 1, 1, 6);
/* 383 */     this.clawr3.setRotationPoint(-21.0F, 2.0F, -12.0F);
/* 384 */     this.clawr3.setTextureSize(64, 32);
/* 385 */     this.clawr3.mirror = true;
/* 386 */     setRotation(this.clawr3, 0.1745329F, 0.4363323F, 0.0F);
/* 387 */     this.clawl2 = new ModelRenderer(this, 130, 94);
/* 388 */     this.clawl2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 10);
/* 389 */     this.clawl2.setRotationPoint(21.0F, 2.0F, -12.0F);
/* 390 */     this.clawl2.setTextureSize(64, 32);
/* 391 */     this.clawl2.mirror = true;
/* 392 */     setRotation(this.clawl2, 0.0F, 2.268928F, 0.0F);
/* 393 */     this.clawl3 = new ModelRenderer(this, 130, 109);
/* 394 */     this.clawl3.addBox(0.0F, 1.0F, 0.0F, 1, 1, 6);
/* 395 */     this.clawl3.setRotationPoint(21.0F, 2.0F, -12.0F);
/* 396 */     this.clawl3.setTextureSize(64, 32);
/* 397 */     this.clawl3.mirror = true;
/* 398 */     setRotation(this.clawl3, -0.1745329F, 2.70526F, 0.0F);
/* 399 */     this.clawl1 = new ModelRenderer(this, 130, 83);
/* 400 */     this.clawl1.addBox(0.0F, -1.0F, 0.0F, 1, 1, 6);
/* 401 */     this.clawl1.setRotationPoint(21.0F, 2.0F, -12.0F);
/* 402 */     this.clawl1.setTextureSize(64, 32);
/* 403 */     this.clawl1.mirror = true;
/* 404 */     setRotation(this.clawl1, 0.1745329F, 2.70526F, 0.0F);
/*     */   }
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 408 */     Alien e = (Alien)entity;
/* 409 */     RenderInfo r = null;
/* 410 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 411 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 412 */     float newangle = 0.0F, nextangle = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 416 */     newangle = MathHelper.cos(f2 * 4.0F * this.wingspeed) * 3.1415927F * 0.5F * f1;
/* 417 */     doLeftLeg(newangle);
/* 418 */     doRightLeg(-newangle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 424 */     if (e.getAttacking() == 0) {
/* 425 */       this.fan.rotateAngleZ = 0.0F;
/* 426 */       this.fanl1.rotateAngleZ = 0.0F;
/* 427 */       this.fanl2.rotateAngleZ = 0.0F;
/* 428 */       this.fanl3.rotateAngleZ = 0.0F;
/* 429 */       this.fanl4.rotateAngleZ = 0.0F;
/* 430 */       this.fanl5.rotateAngleZ = 0.0F;
/* 431 */       this.fanl6.rotateAngleZ = 0.0F;
/* 432 */       this.fanl7.rotateAngleZ = 0.0F;
/* 433 */       this.fanr1.rotateAngleZ = 0.0F;
/* 434 */       this.fanr2.rotateAngleZ = 0.0F;
/* 435 */       this.fanr3.rotateAngleZ = 0.0F;
/* 436 */       this.fanr4.rotateAngleZ = 0.0F;
/* 437 */       this.fanr5.rotateAngleZ = 0.0F;
/* 438 */       this.fanr6.rotateAngleZ = 0.0F;
/* 439 */       this.fanr7.rotateAngleZ = 0.0F;
/*     */       
/* 441 */       this.fan.rotateAngleX = -1.85F;
/* 442 */       this.fanl1.rotateAngleX = -1.85F;
/* 443 */       this.fanl2.rotateAngleX = -1.85F;
/* 444 */       this.fanl3.rotateAngleX = -1.85F;
/* 445 */       this.fanl4.rotateAngleX = -1.85F;
/* 446 */       this.fanl5.rotateAngleX = -1.85F;
/* 447 */       this.fanl6.rotateAngleX = -1.85F;
/* 448 */       this.fanl7.rotateAngleX = -1.85F;
/* 449 */       this.fanr1.rotateAngleX = -1.85F;
/* 450 */       this.fanr2.rotateAngleX = -1.85F;
/* 451 */       this.fanr3.rotateAngleX = -1.85F;
/* 452 */       this.fanr4.rotateAngleX = -1.85F;
/* 453 */       this.fanr5.rotateAngleX = -1.85F;
/* 454 */       this.fanr6.rotateAngleX = -1.85F;
/* 455 */       this.fanr7.rotateAngleX = -1.85F;
/*     */     } else {
/* 457 */       float pi6 = 0.5235988F;
/* 458 */       float fanspeed = 1.22F;
/* 459 */       float fanamp = 0.1F;
/*     */       
/* 461 */       this.fan.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed) * 3.1415927F * fanamp;
/* 462 */       this.fanl1.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 1.0F * pi6) * 3.1415927F * fanamp;
/* 463 */       this.fanl2.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 2.0F * pi6) * 3.1415927F * fanamp;
/* 464 */       this.fanl3.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 3.0F * pi6) * 3.1415927F * fanamp;
/* 465 */       this.fanl4.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 4.0F * pi6) * 3.1415927F * fanamp;
/* 466 */       this.fanl5.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 5.0F * pi6) * 3.1415927F * fanamp;
/* 467 */       this.fanl6.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 6.0F * pi6) * 3.1415927F * fanamp;
/* 468 */       this.fanl7.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 7.0F * pi6) * 3.1415927F * fanamp;
/* 469 */       this.fanr1.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 1.0F * pi6) * 3.1415927F * fanamp;
/* 470 */       this.fanr2.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 2.0F * pi6) * 3.1415927F * fanamp;
/* 471 */       this.fanr3.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 3.0F * pi6) * 3.1415927F * fanamp;
/* 472 */       this.fanr4.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 4.0F * pi6) * 3.1415927F * fanamp;
/* 473 */       this.fanr5.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 5.0F * pi6) * 3.1415927F * fanamp;
/* 474 */       this.fanr6.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 6.0F * pi6) * 3.1415927F * fanamp;
/* 475 */       this.fanr7.rotateAngleX = MathHelper.cos(f2 * fanspeed * this.wingspeed - 7.0F * pi6) * 3.1415927F * fanamp;
/*     */       
/* 477 */       this.fan.rotateAngleZ = 0.0F;
/* 478 */       this.fanl1.rotateAngleZ = 0.261F;
/* 479 */       this.fanl2.rotateAngleZ = 0.523F;
/* 480 */       this.fanl3.rotateAngleZ = 0.785F;
/* 481 */       this.fanl4.rotateAngleZ = 1.047F;
/* 482 */       this.fanl5.rotateAngleZ = 1.309F;
/* 483 */       this.fanl6.rotateAngleZ = 1.571F;
/* 484 */       this.fanl7.rotateAngleZ = 1.832F;
/*     */       
/* 486 */       this.fanr1.rotateAngleZ = -0.261F;
/* 487 */       this.fanr2.rotateAngleZ = -0.523F;
/* 488 */       this.fanr3.rotateAngleZ = -0.785F;
/* 489 */       this.fanr4.rotateAngleZ = -1.047F;
/* 490 */       this.fanr5.rotateAngleZ = -1.309F;
/* 491 */       this.fanr6.rotateAngleZ = -1.571F;
/* 492 */       this.fanr7.rotateAngleZ = -1.832F;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 497 */     this.neck.rotateAngleY = (float)Math.toRadians(f3) * 0.35F;
/*     */     
/* 499 */     this.head.rotateAngleY = (float)Math.toRadians(f3) * 0.75F;
/* 500 */     this.neck.rotationPointZ -= (float)Math.cos(this.neck.rotateAngleY) * 3.0F;
/* 501 */     this.neck.rotationPointX += (float)Math.sin(this.neck.rotateAngleY) * 3.0F;
/* 502 */     this.head1.rotateAngleY = this.head.rotateAngleY;
/* 503 */     this.head1.rotationPointZ = this.head.rotationPointZ;
/* 504 */     this.head1.rotationPointX = this.head.rotationPointX;
/* 505 */     this.head2.rotateAngleY = this.head.rotateAngleY;
/* 506 */     this.head2.rotationPointZ = this.head.rotationPointZ;
/* 507 */     this.head2.rotationPointX = this.head.rotationPointX;
/* 508 */     this.fang1.rotateAngleY = this.head.rotateAngleY;
/* 509 */     this.fang1.rotationPointZ = this.head.rotationPointZ;
/* 510 */     this.fang1.rotationPointX = this.head.rotationPointX;
/* 511 */     this.fang2.rotateAngleY = this.head.rotateAngleY;
/* 512 */     this.fang2.rotationPointZ = this.head.rotationPointZ;
/* 513 */     this.fang2.rotationPointX = this.head.rotationPointX;
/* 514 */     this.fang3.rotateAngleY = this.head.rotateAngleY;
/* 515 */     this.fang3.rotationPointZ = this.head.rotationPointZ;
/* 516 */     this.fang3.rotationPointX = this.head.rotationPointX;
/* 517 */     this.fang4.rotateAngleY = this.head.rotateAngleY;
/* 518 */     this.fang4.rotationPointZ = this.head.rotationPointZ;
/* 519 */     this.fang4.rotationPointX = this.head.rotationPointX;
/*     */     
/* 521 */     this.jaw1.rotateAngleY = this.head.rotateAngleY;
/* 522 */     this.head.rotationPointZ -= (float)Math.cos(this.head.rotateAngleY) * 8.0F;
/* 523 */     this.head.rotationPointX -= (float)Math.sin(this.head.rotateAngleY) * 8.0F;
/* 524 */     this.jaw2.rotateAngleY = this.jaw1.rotateAngleY;
/* 525 */     this.jaw2.rotationPointZ = this.jaw1.rotationPointZ;
/* 526 */     this.jaw2.rotationPointX = this.jaw1.rotationPointX;
/*     */ 
/*     */     
/* 529 */     r = e.getRenderInfo();
/*     */ 
/*     */     
/* 532 */     newangle = MathHelper.cos(f2 * 3.5F * this.wingspeed) * 3.1415927F * 0.5F;
/* 533 */     nextangle = MathHelper.cos((f2 + 0.2F) * 3.5F * this.wingspeed) * 3.1415927F * 0.5F;
/*     */     
/* 535 */     if (nextangle > 0.0F && newangle < 0.0F)
/*     */     {
/* 537 */       if (e.getAttacking() == 0) {
/* 538 */         r.ri1 = e.world.rand.nextInt(15);
/* 539 */         r.ri2 = e.world.rand.nextInt(15);
/* 540 */         r.ri3 = e.world.rand.nextInt(15);
/*     */       } else {
/* 542 */         r.ri1 = e.world.rand.nextInt(4);
/* 543 */         r.ri2 = e.world.rand.nextInt(2);
/* 544 */         r.ri3 = 1;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 549 */     if (r.ri2 == 1) {
/* 550 */       doTail(newangle);
/*     */     } else {
/* 552 */       newangle = MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.05F;
/* 553 */       doTail(newangle);
/*     */     } 
/*     */ 
/*     */     
/* 557 */     if (r.ri3 == 1) {
/* 558 */       newangle = MathHelper.cos(f2 * 3.5F * this.wingspeed) * 3.1415927F * 0.35F;
/* 559 */       doJaw(newangle);
/*     */     } else {
/* 561 */       newangle = MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.02F;
/* 562 */       doJaw(newangle);
/*     */     } 
/*     */ 
/*     */     
/* 566 */     newangle = MathHelper.cos(f2 * this.wingspeed * 3.5F) * 3.1415927F * 0.2F;
/* 567 */     if (r.ri1 == 1 || r.ri1 == 3) {
/* 568 */       doLeftClaw(newangle);
/*     */     } else {
/* 570 */       newangle = MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.03F;
/* 571 */       doLeftClaw(newangle);
/*     */     } 
/* 573 */     if (r.ri1 == 2 || r.ri1 == 3) {
/* 574 */       doRightClaw(-newangle);
/*     */     } else {
/* 576 */       newangle = MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.03F;
/* 577 */       doRightClaw(-newangle);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 582 */     e.setRenderInfo(r);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 590 */     this.torso.render(f5);
/* 591 */     this.stomach.render(f5);
/* 592 */     this.rThigh.render(f5);
/* 593 */     this.lThigh.render(f5);
/* 594 */     this.lShin.render(f5);
/* 595 */     this.rShin.render(f5);
/* 596 */     this.lShin1.render(f5);
/* 597 */     this.rShin1.render(f5);
/* 598 */     this.lFoot.render(f5);
/* 599 */     this.rFoot.render(f5);
/* 600 */     this.neck.render(f5);
/* 601 */     this.tail2.render(f5);
/* 602 */     this.tail3.render(f5);
/* 603 */     this.tail4.render(f5);
/* 604 */     this.tail5.render(f5);
/* 605 */     this.tail1.render(f5);
/* 606 */     this.spike4.render(f5);
/* 607 */     this.spike5.render(f5);
/* 608 */     this.spike3.render(f5);
/* 609 */     this.head.render(f5);
/* 610 */     this.head1.render(f5);
/* 611 */     this.jaw1.render(f5);
/* 612 */     this.head2.render(f5);
/* 613 */     this.jaw2.render(f5);
/* 614 */     this.fang1.render(f5);
/* 615 */     this.fang2.render(f5);
/* 616 */     this.fang3.render(f5);
/* 617 */     this.fang4.render(f5);
/* 618 */     this.spike2.render(f5);
/* 619 */     this.spike1.render(f5);
/* 620 */     this.arml1.render(f5);
/* 621 */     this.armr1.render(f5);
/* 622 */     this.arml2.render(f5);
/* 623 */     this.armr2.render(f5);
/* 624 */     this.clawr1.render(f5);
/* 625 */     this.clawr2.render(f5);
/* 626 */     this.clawr3.render(f5);
/* 627 */     this.clawl2.render(f5);
/* 628 */     this.clawl3.render(f5);
/* 629 */     this.clawl1.render(f5);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 634 */     this.fan.render(f5);
/* 635 */     this.fanl1.render(f5);
/* 636 */     this.fanr1.render(f5);
/* 637 */     this.fanl2.render(f5);
/* 638 */     this.fanr2.render(f5);
/* 639 */     this.fanl3.render(f5);
/* 640 */     this.fanr3.render(f5);
/* 641 */     this.fanl4.render(f5);
/* 642 */     this.fanr4.render(f5);
/* 643 */     this.fanl5.render(f5);
/* 644 */     this.fanr5.render(f5);
/* 645 */     this.fanl6.render(f5);
/* 646 */     this.fanr6.render(f5);
/* 647 */     this.fanl7.render(f5);
/* 648 */     this.fanr7.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 657 */     model.rotateAngleX = x;
/* 658 */     model.rotateAngleY = y;
/* 659 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 664 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */   
/*     */   private void doLeftLeg(float angle) {
/* 668 */     this.lFoot.rotateAngleX = angle;
/* 669 */     this.lShin.rotateAngleX = angle - 0.4F;
/* 670 */     this.lShin1.rotateAngleX = angle - 0.8F;
/* 671 */     this.lThigh.rotateAngleX = angle - 0.8F;
/*     */   }
/*     */   
/*     */   private void doRightLeg(float angle) {
/* 675 */     this.rFoot.rotateAngleX = angle;
/* 676 */     this.rShin.rotateAngleX = angle - 0.4F;
/* 677 */     this.rShin1.rotateAngleX = angle - 0.8F;
/* 678 */     this.rThigh.rotateAngleX = angle - 0.8F;
/*     */   }
/*     */   
/*     */   private void doJaw(float angle) {
/* 682 */     this.jaw1.rotateAngleX = Math.abs(angle);
/* 683 */     this.jaw2.rotateAngleX = this.jaw1.rotateAngleX;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doTail(float angle) {
/* 691 */     this.tail1.rotateAngleY = angle * 0.25F;
/* 692 */     this.spike1.rotateAngleY = this.tail1.rotateAngleY;
/*     */     
/* 694 */     this.tail2.rotateAngleY = angle * 0.5F;
/* 695 */     this.tail1.rotationPointZ += (float)Math.cos(this.tail1.rotateAngleY) * 10.0F;
/* 696 */     this.tail1.rotationPointX += (float)Math.sin(this.tail1.rotateAngleY) * 10.0F;
/* 697 */     this.spike2.rotateAngleY = this.tail2.rotateAngleY;
/* 698 */     this.spike2.rotationPointZ = this.tail2.rotationPointZ;
/* 699 */     this.spike2.rotationPointX = this.tail2.rotationPointX;
/*     */     
/* 701 */     this.tail3.rotateAngleY = angle * 0.8F;
/* 702 */     this.tail2.rotationPointZ += (float)Math.cos(this.tail2.rotateAngleY) * 10.0F;
/* 703 */     this.tail2.rotationPointX += (float)Math.sin(this.tail2.rotateAngleY) * 10.0F;
/* 704 */     this.spike3.rotateAngleY = this.tail3.rotateAngleY;
/* 705 */     this.spike3.rotationPointZ = this.tail3.rotationPointZ;
/* 706 */     this.spike3.rotationPointX = this.tail3.rotationPointX;
/*     */     
/* 708 */     this.tail4.rotateAngleY = angle * 1.25F;
/* 709 */     this.tail3.rotationPointZ += (float)Math.cos(this.tail3.rotateAngleY) * 10.0F;
/* 710 */     this.tail3.rotationPointX += (float)Math.sin(this.tail3.rotateAngleY) * 10.0F;
/* 711 */     this.tail4.rotateAngleY += 0.52F;
/* 712 */     this.spike4.rotationPointZ = this.tail4.rotationPointZ;
/* 713 */     this.spike4.rotationPointX = this.tail4.rotationPointX;
/* 714 */     this.tail4.rotateAngleY -= 0.52F;
/* 715 */     this.spike5.rotationPointZ = this.tail4.rotationPointZ;
/* 716 */     this.spike5.rotationPointX = this.tail4.rotationPointX;
/*     */     
/* 718 */     this.tail5.rotateAngleY = angle * 1.5F;
/* 719 */     this.tail4.rotationPointZ += (float)Math.cos(this.tail4.rotateAngleY) * 10.0F;
/* 720 */     this.tail4.rotationPointX += (float)Math.sin(this.tail4.rotateAngleY) * 10.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void doLeftClaw(float angle) {
/* 726 */     this.arml1.rotateAngleY = -0.52F + Math.abs(angle * 2.0F);
/* 727 */     this.arml1.rotationPointZ -= (float)Math.sin(this.arml1.rotateAngleY) * 9.0F;
/* 728 */     this.arml1.rotationPointX += (float)Math.cos(this.arml1.rotateAngleY) * 9.0F;
/* 729 */     this.arml2.rotateAngleY = 0.855F + Math.abs(angle);
/* 730 */     this.arml2.rotationPointZ -= (float)Math.sin(this.arml2.rotateAngleY) * 14.0F;
/* 731 */     this.arml2.rotationPointX += (float)Math.cos(this.arml2.rotateAngleY) * 14.0F;
/* 732 */     this.clawl1.rotateAngleY = 2.7F + Math.abs(angle * 4.0F);
/* 733 */     this.clawl2.rotationPointZ = this.clawl1.rotationPointZ;
/* 734 */     this.clawl2.rotationPointX = this.clawl1.rotationPointX;
/* 735 */     this.clawl2.rotateAngleY = 2.27F + Math.abs(angle * 4.0F);
/* 736 */     this.clawl3.rotationPointZ = this.clawl1.rotationPointZ;
/* 737 */     this.clawl3.rotationPointX = this.clawl1.rotationPointX;
/* 738 */     this.clawl3.rotateAngleY = 2.7F + Math.abs(angle * 4.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private void doRightClaw(float angle) {
/* 743 */     this.armr1.rotateAngleY = -2.61F - Math.abs(angle * 2.0F);
/* 744 */     this.armr1.rotationPointZ -= (float)Math.sin(this.armr1.rotateAngleY) * 9.0F;
/* 745 */     this.armr1.rotationPointX += (float)Math.cos(this.armr1.rotateAngleY) * 9.0F;
/* 746 */     this.armr2.rotateAngleY = 2.27F - Math.abs(angle);
/* 747 */     this.armr2.rotationPointZ -= (float)Math.sin(this.armr2.rotateAngleY) * 14.0F;
/* 748 */     this.armr2.rotationPointX += (float)Math.cos(this.armr2.rotateAngleY) * 14.0F;
/* 749 */     this.clawr1.rotateAngleY = 0.436F - Math.abs(angle * 4.0F);
/* 750 */     this.clawr2.rotationPointZ = this.clawr1.rotationPointZ;
/* 751 */     this.clawr2.rotationPointX = this.clawr1.rotationPointX;
/* 752 */     this.clawr2.rotateAngleY = 0.87F - Math.abs(angle * 4.0F);
/* 753 */     this.clawr3.rotationPointZ = this.clawr1.rotationPointZ;
/* 754 */     this.clawr3.rotationPointX = this.clawr1.rotationPointX;
/* 755 */     this.clawr3.rotateAngleY = 0.436F - Math.abs(angle * 4.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\model\ModelAlien.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */