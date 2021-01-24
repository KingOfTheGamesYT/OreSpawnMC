/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.Alien;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ public class ModelAlien
/*     */   extends ModelBase {
/*  11 */   private float wingspeed = 1.0F;
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
/*  71 */     this.wingspeed = f1;
/*     */     
/*  73 */     this.textureWidth = 256;
/*  74 */     this.textureHeight = 128;
/*     */     
/*  76 */     this.torso = new ModelRenderer(this, 0, 46);
/*  77 */     this.torso.addBox(-4.5F, -2.0F, 0.0F, 9, 8, 10);
/*  78 */     this.torso.setRotationPoint(0.0F, -2.5F, -8.0F);
/*  79 */     this.torso.setTextureSize(64, 32);
/*  80 */     this.torso.mirror = true;
/*  81 */     setRotation(this.torso, -0.1919862F, 0.0F, 0.0F);
/*  82 */     this.stomach = new ModelRenderer(this, 0, 27);
/*  83 */     this.stomach.addBox(-3.5F, -5.0F, 8.0F, 7, 6, 12);
/*  84 */     this.stomach.setRotationPoint(0.0F, -2.5F, -8.0F);
/*  85 */     this.stomach.setTextureSize(64, 32);
/*  86 */     this.stomach.mirror = true;
/*  87 */     setRotation(this.stomach, -0.5585054F, 0.0F, 0.0F);
/*  88 */     this.rThigh = new ModelRenderer(this, 59, 45);
/*  89 */     this.rThigh.addBox(-1.5F, -4.0F, -2.5F, 4, 14, 5);
/*  90 */     this.rThigh.setRotationPoint(-4.5F, 7.0F, 8.0F);
/*  91 */     this.rThigh.setTextureSize(64, 32);
/*  92 */     this.rThigh.mirror = true;
/*  93 */     setRotation(this.rThigh, -0.8028515F, 0.2443461F, 0.418879F);
/*  94 */     this.lThigh = new ModelRenderer(this, 40, 45);
/*  95 */     this.lThigh.addBox(-2.5F, -4.0F, -2.5F, 4, 14, 5);
/*  96 */     this.lThigh.setRotationPoint(4.5F, 7.0F, 8.0F);
/*  97 */     this.lThigh.setTextureSize(64, 32);
/*  98 */     this.lThigh.mirror = true;
/*  99 */     setRotation(this.lThigh, -0.8028515F, -0.2443461F, -0.418879F);
/* 100 */     this.lShin = new ModelRenderer(this, 79, 49);
/* 101 */     this.lShin.addBox(-2.0F, 8.0F, -5.5F, 3, 3, 12);
/* 102 */     this.lShin.setRotationPoint(4.5F, 7.0F, 8.0F);
/* 103 */     this.lShin.setTextureSize(64, 32);
/* 104 */     this.lShin.mirror = true;
/* 105 */     setRotation(this.lShin, -0.4014257F, -0.2443461F, -0.418879F);
/* 106 */     this.rShin = new ModelRenderer(this, 79, 33);
/* 107 */     this.rShin.addBox(-1.0F, 8.0F, -5.5F, 3, 3, 12);
/* 108 */     this.rShin.setRotationPoint(-4.5F, 7.0F, 8.0F);
/* 109 */     this.rShin.setTextureSize(64, 32);
/* 110 */     this.rShin.mirror = true;
/* 111 */     setRotation(this.rShin, -0.4014257F, 0.2443461F, 0.418879F);
/* 112 */     this.lShin1 = new ModelRenderer(this, 113, 40);
/* 113 */     this.lShin1.addBox(-1.5F, 5.5F, 9.0F, 2, 9, 2);
/* 114 */     this.lShin1.setRotationPoint(4.5F, 7.0F, 8.0F);
/* 115 */     this.lShin1.setTextureSize(64, 32);
/* 116 */     this.lShin1.mirror = true;
/* 117 */     setRotation(this.lShin1, -0.8028515F, -0.2443461F, -0.418879F);
/* 118 */     this.rShin1 = new ModelRenderer(this, 113, 53);
/* 119 */     this.rShin1.addBox(-0.5F, 5.5F, 9.0F, 2, 9, 2);
/* 120 */     this.rShin1.setRotationPoint(-4.5F, 7.0F, 8.0F);
/* 121 */     this.rShin1.setTextureSize(64, 32);
/* 122 */     this.rShin1.mirror = true;
/* 123 */     setRotation(this.rShin1, -0.8028515F, 0.2443461F, 0.418879F);
/* 124 */     this.lFoot = new ModelRenderer(this, 110, 24);
/* 125 */     this.lFoot.addBox(5.0F, 15.0F, -8.0F, 2, 2, 6);
/* 126 */     this.lFoot.setRotationPoint(4.5F, 7.0F, 8.0F);
/* 127 */     this.lFoot.setTextureSize(64, 32);
/* 128 */     this.lFoot.mirror = true;
/* 129 */     setRotation(this.lFoot, 0.0F, -0.2443461F, 0.0F);
/* 130 */     this.rFoot = new ModelRenderer(this, 95, 24);
/* 131 */     this.rFoot.addBox(-7.0F, 15.0F, -8.0F, 2, 2, 6);
/* 132 */     this.rFoot.setRotationPoint(-4.5F, 7.0F, 8.0F);
/* 133 */     this.rFoot.setTextureSize(64, 32);
/* 134 */     this.rFoot.mirror = true;
/* 135 */     setRotation(this.rFoot, 0.0F, 0.2443461F, 0.0F);
/* 136 */     this.neck = new ModelRenderer(this, 23, 86);
/* 137 */     this.neck.addBox(-2.0F, -2.0F, -4.0F, 4, 6, 5);
/* 138 */     this.neck.setRotationPoint(0.0F, -2.5F, -8.0F);
/* 139 */     this.neck.setTextureSize(64, 32);
/* 140 */     this.neck.mirror = true;
/* 141 */     setRotation(this.neck, -0.1919862F, 0.0F, 0.0F);
/* 142 */     this.fan = new ModelRenderer(this, 149, 10);
/* 143 */     this.fan.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 144 */     this.fan.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 145 */     this.fan.setTextureSize(64, 32);
/* 146 */     this.fan.mirror = true;
/* 147 */     setRotation(this.fan, 0.0F, 0.0F, 0.0F);
/* 148 */     this.tail2 = new ModelRenderer(this, 85, 66);
/* 149 */     this.tail2.addBox(-2.0F, -1.5F, 0.0F, 4, 4, 11);
/* 150 */     this.tail2.setRotationPoint(0.0F, 9.5F, 20.5F);
/* 151 */     this.tail2.setTextureSize(64, 32);
/* 152 */     this.tail2.mirror = true;
/* 153 */     setRotation(this.tail2, -0.3141593F, 0.0F, 0.0F);
/* 154 */     this.tail3 = new ModelRenderer(this, 118, 66);
/* 155 */     this.tail3.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 11);
/* 156 */     this.tail3.setRotationPoint(0.0F, 13.5F, 30.5F);
/* 157 */     this.tail3.setTextureSize(64, 32);
/* 158 */     this.tail3.mirror = true;
/* 159 */     setRotation(this.tail3, -0.2094395F, 0.0F, 0.0F);
/* 160 */     this.tail4 = new ModelRenderer(this, 149, 66);
/* 161 */     this.tail4.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 11);
/* 162 */     this.tail4.setRotationPoint(0.0F, 15.5F, 40.5F);
/* 163 */     this.tail4.setTextureSize(64, 32);
/* 164 */     this.tail4.mirror = true;
/* 165 */     setRotation(this.tail4, -0.1396263F, 0.0F, 0.0F);
/* 166 */     this.tail5 = new ModelRenderer(this, 178, 66);
/* 167 */     this.tail5.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 168 */     this.tail5.setRotationPoint(0.0F, 17.5F, 50.5F);
/* 169 */     this.tail5.setTextureSize(64, 32);
/* 170 */     this.tail5.mirror = true;
/* 171 */     setRotation(this.tail5, -0.0523599F, 0.0F, 0.0F);
/* 172 */     this.tail1 = new ModelRenderer(this, 50, 66);
/* 173 */     this.tail1.addBox(-2.0F, -2.5F, 0.0F, 4, 4, 11);
/* 174 */     this.tail1.setRotationPoint(0.0F, 6.5F, 10.5F);
/* 175 */     this.tail1.setTextureSize(64, 32);
/* 176 */     this.tail1.mirror = true;
/* 177 */     setRotation(this.tail1, -0.4014257F, 0.0F, 0.0F);
/* 178 */     this.fanl1 = new ModelRenderer(this, 130, 10);
/* 179 */     this.fanl1.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 180 */     this.fanl1.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 181 */     this.fanl1.setTextureSize(64, 32);
/* 182 */     this.fanl1.mirror = true;
/* 183 */     setRotation(this.fanl1, 0.0F, 0.0F, 0.2617994F);
/* 184 */     this.fanr1 = new ModelRenderer(this, 130, 10);
/* 185 */     this.fanr1.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 186 */     this.fanr1.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 187 */     this.fanr1.setTextureSize(64, 32);
/* 188 */     this.fanr1.mirror = true;
/* 189 */     setRotation(this.fanr1, 0.0F, 0.0F, -0.2617994F);
/* 190 */     this.fanl2 = new ModelRenderer(this, 130, 10);
/* 191 */     this.fanl2.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 192 */     this.fanl2.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 193 */     this.fanl2.setTextureSize(64, 32);
/* 194 */     this.fanl2.mirror = true;
/* 195 */     setRotation(this.fanl2, 0.0F, 0.0F, 0.5235988F);
/* 196 */     this.fanr2 = new ModelRenderer(this, 130, 10);
/* 197 */     this.fanr2.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 198 */     this.fanr2.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 199 */     this.fanr2.setTextureSize(64, 32);
/* 200 */     this.fanr2.mirror = true;
/* 201 */     setRotation(this.fanr2, 0.0F, 0.0F, -0.5235988F);
/* 202 */     this.fanl3 = new ModelRenderer(this, 130, 10);
/* 203 */     this.fanl3.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 204 */     this.fanl3.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 205 */     this.fanl3.setTextureSize(64, 32);
/* 206 */     this.fanl3.mirror = true;
/* 207 */     setRotation(this.fanl3, 0.0F, 0.0F, 0.7853982F);
/* 208 */     this.fanr3 = new ModelRenderer(this, 130, 10);
/* 209 */     this.fanr3.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 210 */     this.fanr3.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 211 */     this.fanr3.setTextureSize(64, 32);
/* 212 */     this.fanr3.mirror = true;
/* 213 */     setRotation(this.fanr3, 0.0F, 0.0F, -0.7853982F);
/* 214 */     this.fanl4 = new ModelRenderer(this, 130, 10);
/* 215 */     this.fanl4.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 216 */     this.fanl4.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 217 */     this.fanl4.setTextureSize(64, 32);
/* 218 */     this.fanl4.mirror = true;
/* 219 */     setRotation(this.fanl4, 0.0F, 0.0F, 1.047198F);
/* 220 */     this.fanr4 = new ModelRenderer(this, 130, 10);
/* 221 */     this.fanr4.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 222 */     this.fanr4.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 223 */     this.fanr4.setTextureSize(64, 32);
/* 224 */     this.fanr4.mirror = true;
/* 225 */     setRotation(this.fanr4, 0.0F, 0.0F, -1.047198F);
/* 226 */     this.fanl5 = new ModelRenderer(this, 130, 10);
/* 227 */     this.fanl5.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 228 */     this.fanl5.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 229 */     this.fanl5.setTextureSize(64, 32);
/* 230 */     this.fanl5.mirror = true;
/* 231 */     setRotation(this.fanl5, 0.0F, 0.0F, 1.308997F);
/* 232 */     this.fanr5 = new ModelRenderer(this, 130, 10);
/* 233 */     this.fanr5.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 234 */     this.fanr5.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 235 */     this.fanr5.setTextureSize(64, 32);
/* 236 */     this.fanr5.mirror = true;
/* 237 */     setRotation(this.fanr5, 0.0F, 0.0F, -1.308997F);
/* 238 */     this.fanl6 = new ModelRenderer(this, 130, 10);
/* 239 */     this.fanl6.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 240 */     this.fanl6.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 241 */     this.fanl6.setTextureSize(64, 32);
/* 242 */     this.fanl6.mirror = true;
/* 243 */     setRotation(this.fanl6, 0.0F, 0.0F, 1.570796F);
/* 244 */     this.fanr6 = new ModelRenderer(this, 130, 10);
/* 245 */     this.fanr6.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 246 */     this.fanr6.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 247 */     this.fanr6.setTextureSize(64, 32);
/* 248 */     this.fanr6.mirror = true;
/* 249 */     setRotation(this.fanr6, 0.0F, 0.0F, -1.570796F);
/* 250 */     this.spike4 = new ModelRenderer(this, 178, 66);
/* 251 */     this.spike4.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 252 */     this.spike4.setRotationPoint(0.0F, 16.0F, 41.0F);
/* 253 */     this.spike4.setTextureSize(64, 32);
/* 254 */     this.spike4.mirror = true;
/* 255 */     setRotation(this.spike4, -0.0523599F, 0.5235988F, 0.0F);
/* 256 */     this.spike5 = new ModelRenderer(this, 178, 66);
/* 257 */     this.spike5.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 258 */     this.spike5.setRotationPoint(0.0F, 16.0F, 41.0F);
/* 259 */     this.spike5.setTextureSize(64, 32);
/* 260 */     this.spike5.mirror = true;
/* 261 */     setRotation(this.spike5, -0.0523599F, -0.5759587F, 0.0F);
/* 262 */     this.spike3 = new ModelRenderer(this, 178, 66);
/* 263 */     this.spike3.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 264 */     this.spike3.setRotationPoint(0.0F, 13.5F, 30.5F);
/* 265 */     this.spike3.setTextureSize(64, 32);
/* 266 */     this.spike3.mirror = true;
/* 267 */     setRotation(this.spike3, 0.3141593F, 0.0F, 0.0F);
/* 268 */     this.fanl7 = new ModelRenderer(this, 130, 10);
/* 269 */     this.fanl7.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 270 */     this.fanl7.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 271 */     this.fanl7.setTextureSize(64, 32);
/* 272 */     this.fanl7.mirror = true;
/* 273 */     setRotation(this.fanl7, 0.0F, 0.0F, 1.832596F);
/* 274 */     this.fanr7 = new ModelRenderer(this, 130, 10);
/* 275 */     this.fanr7.addBox(-3.0F, -24.0F, 0.0F, 6, 24, 1);
/* 276 */     this.fanr7.setRotationPoint(0.0F, -7.0F, -10.0F);
/* 277 */     this.fanr7.setTextureSize(64, 32);
/* 278 */     this.fanr7.mirror = true;
/* 279 */     setRotation(this.fanr7, 0.0F, 0.0F, -1.832596F);
/* 280 */     this.head = new ModelRenderer(this, 200, 0);
/* 281 */     this.head.addBox(-3.0F, -4.0F, -7.0F, 6, 7, 8);
/* 282 */     this.head.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 283 */     this.head.setTextureSize(64, 32);
/* 284 */     this.head.mirror = true;
/* 285 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/* 286 */     this.head1 = new ModelRenderer(this, 200, 18);
/* 287 */     this.head1.addBox(-2.5F, -2.0F, -15.0F, 5, 2, 8);
/* 288 */     this.head1.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 289 */     this.head1.setTextureSize(64, 32);
/* 290 */     this.head1.mirror = true;
/* 291 */     setRotation(this.head1, 0.0F, 0.0F, 0.0F);
/* 292 */     this.jaw1 = new ModelRenderer(this, 200, 43);
/* 293 */     this.jaw1.addBox(-2.0F, -1.0F, -7.0F, 4, 2, 8);
/* 294 */     this.jaw1.setRotationPoint(0.0F, -2.0F, -19.0F);
/* 295 */     this.jaw1.setTextureSize(64, 32);
/* 296 */     this.jaw1.mirror = true;
/* 297 */     setRotation(this.jaw1, 0.0F, 0.0F, 0.0F);
/* 298 */     this.head2 = new ModelRenderer(this, 200, 31);
/* 299 */     this.head2.addBox(-2.0F, -2.0F, -22.0F, 4, 2, 7);
/* 300 */     this.head2.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 301 */     this.head2.setTextureSize(64, 32);
/* 302 */     this.head2.mirror = true;
/* 303 */     setRotation(this.head2, 0.0F, 0.0F, 0.0F);
/* 304 */     this.jaw2 = new ModelRenderer(this, 200, 56);
/* 305 */     this.jaw2.addBox(-1.5F, -1.0F, -13.0F, 3, 2, 6);
/* 306 */     this.jaw2.setRotationPoint(0.0F, -2.0F, -19.0F);
/* 307 */     this.jaw2.setTextureSize(64, 32);
/* 308 */     this.jaw2.mirror = true;
/* 309 */     setRotation(this.jaw2, 0.0F, 0.0F, 0.0F);
/* 310 */     this.fang1 = new ModelRenderer(this, 42, 0);
/* 311 */     this.fang1.addBox(1.0F, 0.0F, -20.0F, 1, 5, 1);
/* 312 */     this.fang1.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 313 */     this.fang1.setTextureSize(64, 32);
/* 314 */     this.fang1.mirror = true;
/* 315 */     setRotation(this.fang1, 0.0F, 0.0F, 0.0F);
/* 316 */     this.fang2 = new ModelRenderer(this, 50, 0);
/* 317 */     this.fang2.addBox(-2.0F, 0.0F, -20.0F, 1, 5, 1);
/* 318 */     this.fang2.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 319 */     this.fang2.setTextureSize(64, 32);
/* 320 */     this.fang2.mirror = true;
/* 321 */     setRotation(this.fang2, 0.0F, 0.0F, 0.0F);
/* 322 */     this.fang3 = new ModelRenderer(this, 60, 0);
/* 323 */     this.fang3.addBox(1.0F, 0.0F, -14.0F, 1, 3, 1);
/* 324 */     this.fang3.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 325 */     this.fang3.setTextureSize(64, 32);
/* 326 */     this.fang3.mirror = true;
/* 327 */     setRotation(this.fang3, 0.0F, 0.0F, 0.0F);
/* 328 */     this.fang4 = new ModelRenderer(this, 69, 0);
/* 329 */     this.fang4.addBox(-2.0F, 0.0F, -14.0F, 1, 3, 1);
/* 330 */     this.fang4.setRotationPoint(0.0F, -3.0F, -11.0F);
/* 331 */     this.fang4.setTextureSize(64, 32);
/* 332 */     this.fang4.mirror = true;
/* 333 */     setRotation(this.fang4, 0.0F, 0.0F, 0.0F);
/* 334 */     this.spike2 = new ModelRenderer(this, 178, 66);
/* 335 */     this.spike2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11);
/* 336 */     this.spike2.setRotationPoint(0.0F, 9.5F, 20.5F);
/* 337 */     this.spike2.setTextureSize(64, 32);
/* 338 */     this.spike2.mirror = true;
/* 339 */     setRotation(this.spike2, 0.3141593F, 0.0F, 0.0F);
/* 340 */     this.spike1 = new ModelRenderer(this, 178, 66);
/* 341 */     this.spike1.addBox(-0.5F, -1.5F, 0.0F, 1, 1, 11);
/* 342 */     this.spike1.setRotationPoint(0.0F, 6.5F, 10.5F);
/* 343 */     this.spike1.setTextureSize(64, 32);
/* 344 */     this.spike1.mirror = true;
/* 345 */     setRotation(this.spike1, 0.3141593F, 0.0F, 0.0F);
/* 346 */     this.arml1 = new ModelRenderer(this, 50, 98);
/* 347 */     this.arml1.addBox(0.0F, 0.0F, -2.0F, 11, 3, 4);
/* 348 */     this.arml1.setRotationPoint(2.0F, -1.0F, -6.0F);
/* 349 */     this.arml1.setTextureSize(64, 32);
/* 350 */     this.arml1.mirror = true;
/* 351 */     setRotation(this.arml1, 0.0F, -0.5235988F, 0.1745329F);
/* 352 */     this.armr1 = new ModelRenderer(this, 49, 88);
/* 353 */     this.armr1.addBox(0.0F, 0.0F, -2.0F, 11, 3, 4);
/* 354 */     this.armr1.setRotationPoint(-3.0F, -1.0F, -6.0F);
/* 355 */     this.armr1.setTextureSize(64, 32);
/* 356 */     this.armr1.mirror = true;
/* 357 */     setRotation(this.armr1, 0.0F, -2.617994F, -0.1745329F);
/* 358 */     this.arml2 = new ModelRenderer(this, 41, 107);
/* 359 */     this.arml2.addBox(0.0F, -1.0F, -1.0F, 15, 3, 3);
/* 360 */     this.arml2.setRotationPoint(11.0F, 2.0F, -1.0F);
/* 361 */     this.arml2.setTextureSize(64, 32);
/* 362 */     this.arml2.mirror = true;
/* 363 */     setRotation(this.arml2, 0.0F, 0.8552113F, 0.0F);
/* 364 */     this.armr2 = new ModelRenderer(this, 42, 115);
/* 365 */     this.armr2.addBox(0.0F, -1.0F, -2.0F, 15, 3, 3);
/* 366 */     this.armr2.setRotationPoint(-11.0F, 2.0F, -1.0F);
/* 367 */     this.armr2.setTextureSize(64, 32);
/* 368 */     this.armr2.mirror = true;
/* 369 */     setRotation(this.armr2, 0.0F, 2.268928F, 0.0F);
/* 370 */     this.clawr1 = new ModelRenderer(this, 100, 85);
/* 371 */     this.clawr1.addBox(-0.5F, -1.0F, -6.0F, 1, 1, 6);
/* 372 */     this.clawr1.setRotationPoint(-21.0F, 2.0F, -12.0F);
/* 373 */     this.clawr1.setTextureSize(64, 32);
/* 374 */     this.clawr1.mirror = true;
/* 375 */     setRotation(this.clawr1, -0.1745329F, 0.4363323F, 0.0F);
/* 376 */     this.clawr2 = new ModelRenderer(this, 100, 94);
/* 377 */     this.clawr2.addBox(0.0F, 0.0F, -10.0F, 1, 1, 10);
/* 378 */     this.clawr2.setRotationPoint(-21.0F, 2.0F, -12.0F);
/* 379 */     this.clawr2.setTextureSize(64, 32);
/* 380 */     this.clawr2.mirror = true;
/* 381 */     setRotation(this.clawr2, 0.0F, 0.8726646F, 0.0F);
/* 382 */     this.clawr3 = new ModelRenderer(this, 100, 107);
/* 383 */     this.clawr3.addBox(0.0F, 1.0F, -6.0F, 1, 1, 6);
/* 384 */     this.clawr3.setRotationPoint(-21.0F, 2.0F, -12.0F);
/* 385 */     this.clawr3.setTextureSize(64, 32);
/* 386 */     this.clawr3.mirror = true;
/* 387 */     setRotation(this.clawr3, 0.1745329F, 0.4363323F, 0.0F);
/* 388 */     this.clawl2 = new ModelRenderer(this, 130, 94);
/* 389 */     this.clawl2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 10);
/* 390 */     this.clawl2.setRotationPoint(21.0F, 2.0F, -12.0F);
/* 391 */     this.clawl2.setTextureSize(64, 32);
/* 392 */     this.clawl2.mirror = true;
/* 393 */     setRotation(this.clawl2, 0.0F, 2.268928F, 0.0F);
/* 394 */     this.clawl3 = new ModelRenderer(this, 130, 109);
/* 395 */     this.clawl3.addBox(0.0F, 1.0F, 0.0F, 1, 1, 6);
/* 396 */     this.clawl3.setRotationPoint(21.0F, 2.0F, -12.0F);
/* 397 */     this.clawl3.setTextureSize(64, 32);
/* 398 */     this.clawl3.mirror = true;
/* 399 */     setRotation(this.clawl3, -0.1745329F, 2.70526F, 0.0F);
/* 400 */     this.clawl1 = new ModelRenderer(this, 130, 83);
/* 401 */     this.clawl1.addBox(0.0F, -1.0F, 0.0F, 1, 1, 6);
/* 402 */     this.clawl1.setRotationPoint(21.0F, 2.0F, -12.0F);
/* 403 */     this.clawl1.setTextureSize(64, 32);
/* 404 */     this.clawl1.mirror = true;
/* 405 */     setRotation(this.clawl1, 0.1745329F, 2.70526F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 410 */     Alien e = (Alien)entity;
/*     */     
/* 412 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 413 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 414 */     float newangle = 0.0F, nextangle = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 418 */     newangle = MathHelper.cos(f2 * 4.0F * this.wingspeed) * 3.1415927F * 0.5F * f1;
/* 419 */     doLeftLeg(newangle);
/* 420 */     doRightLeg(-newangle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 499 */     this.neck.rotateAngleY = (float)Math.toRadians(f3) * 0.35F;
/*     */     
/* 501 */     this.head.rotateAngleY = (float)Math.toRadians(f3) * 0.75F;
/* 502 */     this.neck.rotationPointZ -= (float)Math.cos(this.neck.rotateAngleY) * 3.0F;
/* 503 */     this.neck.rotationPointX += (float)Math.sin(this.neck.rotateAngleY) * 3.0F;
/* 504 */     this.head1.rotateAngleY = this.head.rotateAngleY;
/* 505 */     this.head1.rotationPointZ = this.head.rotationPointZ;
/* 506 */     this.head1.rotationPointX = this.head.rotationPointX;
/* 507 */     this.head2.rotateAngleY = this.head.rotateAngleY;
/* 508 */     this.head2.rotationPointZ = this.head.rotationPointZ;
/* 509 */     this.head2.rotationPointX = this.head.rotationPointX;
/* 510 */     this.fang1.rotateAngleY = this.head.rotateAngleY;
/* 511 */     this.fang1.rotationPointZ = this.head.rotationPointZ;
/* 512 */     this.fang1.rotationPointX = this.head.rotationPointX;
/* 513 */     this.fang2.rotateAngleY = this.head.rotateAngleY;
/* 514 */     this.fang2.rotationPointZ = this.head.rotationPointZ;
/* 515 */     this.fang2.rotationPointX = this.head.rotationPointX;
/* 516 */     this.fang3.rotateAngleY = this.head.rotateAngleY;
/* 517 */     this.fang3.rotationPointZ = this.head.rotationPointZ;
/* 518 */     this.fang3.rotationPointX = this.head.rotationPointX;
/* 519 */     this.fang4.rotateAngleY = this.head.rotateAngleY;
/* 520 */     this.fang4.rotationPointZ = this.head.rotationPointZ;
/* 521 */     this.fang4.rotationPointX = this.head.rotationPointX;
/*     */     
/* 523 */     this.jaw1.rotateAngleY = this.head.rotateAngleY;
/* 524 */     this.head.rotationPointZ -= (float)Math.cos(this.head.rotateAngleY) * 8.0F;
/* 525 */     this.head.rotationPointX -= (float)Math.sin(this.head.rotateAngleY) * 8.0F;
/* 526 */     this.jaw2.rotateAngleY = this.jaw1.rotateAngleY;
/* 527 */     this.jaw2.rotationPointZ = this.jaw1.rotationPointZ;
/* 528 */     this.jaw2.rotationPointX = this.jaw1.rotationPointX;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 592 */     this.torso.render(f5);
/* 593 */     this.stomach.render(f5);
/* 594 */     this.rThigh.render(f5);
/* 595 */     this.lThigh.render(f5);
/* 596 */     this.lShin.render(f5);
/* 597 */     this.rShin.render(f5);
/* 598 */     this.lShin1.render(f5);
/* 599 */     this.rShin1.render(f5);
/* 600 */     this.lFoot.render(f5);
/* 601 */     this.rFoot.render(f5);
/* 602 */     this.neck.render(f5);
/* 603 */     this.tail2.render(f5);
/* 604 */     this.tail3.render(f5);
/* 605 */     this.tail4.render(f5);
/* 606 */     this.tail5.render(f5);
/* 607 */     this.tail1.render(f5);
/* 608 */     this.spike4.render(f5);
/* 609 */     this.spike5.render(f5);
/* 610 */     this.spike3.render(f5);
/* 611 */     this.head.render(f5);
/* 612 */     this.head1.render(f5);
/* 613 */     this.jaw1.render(f5);
/* 614 */     this.head2.render(f5);
/* 615 */     this.jaw2.render(f5);
/* 616 */     this.fang1.render(f5);
/* 617 */     this.fang2.render(f5);
/* 618 */     this.fang3.render(f5);
/* 619 */     this.fang4.render(f5);
/* 620 */     this.spike2.render(f5);
/* 621 */     this.spike1.render(f5);
/* 622 */     this.arml1.render(f5);
/* 623 */     this.armr1.render(f5);
/* 624 */     this.arml2.render(f5);
/* 625 */     this.armr2.render(f5);
/* 626 */     this.clawr1.render(f5);
/* 627 */     this.clawr2.render(f5);
/* 628 */     this.clawr3.render(f5);
/* 629 */     this.clawl2.render(f5);
/* 630 */     this.clawl3.render(f5);
/* 631 */     this.clawl1.render(f5);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 636 */     this.fan.render(f5);
/* 637 */     this.fanl1.render(f5);
/* 638 */     this.fanr1.render(f5);
/* 639 */     this.fanl2.render(f5);
/* 640 */     this.fanr2.render(f5);
/* 641 */     this.fanl3.render(f5);
/* 642 */     this.fanr3.render(f5);
/* 643 */     this.fanl4.render(f5);
/* 644 */     this.fanr4.render(f5);
/* 645 */     this.fanl5.render(f5);
/* 646 */     this.fanr5.render(f5);
/* 647 */     this.fanl6.render(f5);
/* 648 */     this.fanr6.render(f5);
/* 649 */     this.fanl7.render(f5);
/* 650 */     this.fanr7.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 660 */     model.rotateAngleX = x;
/* 661 */     model.rotateAngleY = y;
/* 662 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 668 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ 
/*     */   
/*     */   private void doLeftLeg(float angle) {
/* 673 */     this.lFoot.rotateAngleX = angle;
/* 674 */     this.lShin.rotateAngleX = angle - 0.4F;
/* 675 */     this.lShin1.rotateAngleX = angle - 0.8F;
/* 676 */     this.lThigh.rotateAngleX = angle - 0.8F;
/*     */   }
/*     */ 
/*     */   
/*     */   private void doRightLeg(float angle) {
/* 681 */     this.rFoot.rotateAngleX = angle;
/* 682 */     this.rShin.rotateAngleX = angle - 0.4F;
/* 683 */     this.rShin1.rotateAngleX = angle - 0.8F;
/* 684 */     this.rThigh.rotateAngleX = angle - 0.8F;
/*     */   }
/*     */ 
/*     */   
/*     */   private void doJaw(float angle) {
/* 689 */     this.jaw1.rotateAngleX = Math.abs(angle);
/* 690 */     this.jaw2.rotateAngleX = this.jaw1.rotateAngleX;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doTail(float angle) {
/* 699 */     this.tail1.rotateAngleY = angle * 0.25F;
/* 700 */     this.spike1.rotateAngleY = this.tail1.rotateAngleY;
/*     */     
/* 702 */     this.tail2.rotateAngleY = angle * 0.5F;
/* 703 */     this.tail1.rotationPointZ += (float)Math.cos(this.tail1.rotateAngleY) * 10.0F;
/* 704 */     this.tail1.rotationPointX += (float)Math.sin(this.tail1.rotateAngleY) * 10.0F;
/* 705 */     this.spike2.rotateAngleY = this.tail2.rotateAngleY;
/* 706 */     this.spike2.rotationPointZ = this.tail2.rotationPointZ;
/* 707 */     this.spike2.rotationPointX = this.tail2.rotationPointX;
/*     */     
/* 709 */     this.tail3.rotateAngleY = angle * 0.8F;
/* 710 */     this.tail2.rotationPointZ += (float)Math.cos(this.tail2.rotateAngleY) * 10.0F;
/* 711 */     this.tail2.rotationPointX += (float)Math.sin(this.tail2.rotateAngleY) * 10.0F;
/* 712 */     this.spike3.rotateAngleY = this.tail3.rotateAngleY;
/* 713 */     this.spike3.rotationPointZ = this.tail3.rotationPointZ;
/* 714 */     this.spike3.rotationPointX = this.tail3.rotationPointX;
/*     */     
/* 716 */     this.tail4.rotateAngleY = angle * 1.25F;
/* 717 */     this.tail3.rotationPointZ += (float)Math.cos(this.tail3.rotateAngleY) * 10.0F;
/* 718 */     this.tail3.rotationPointX += (float)Math.sin(this.tail3.rotateAngleY) * 10.0F;
/* 719 */     this.tail4.rotateAngleY += 0.52F;
/* 720 */     this.spike4.rotationPointZ = this.tail4.rotationPointZ;
/* 721 */     this.spike4.rotationPointX = this.tail4.rotationPointX;
/* 722 */     this.tail4.rotateAngleY -= 0.52F;
/* 723 */     this.spike5.rotationPointZ = this.tail4.rotationPointZ;
/* 724 */     this.spike5.rotationPointX = this.tail4.rotationPointX;
/*     */     
/* 726 */     this.tail5.rotateAngleY = angle * 1.5F;
/* 727 */     this.tail4.rotationPointZ += (float)Math.cos(this.tail4.rotateAngleY) * 10.0F;
/* 728 */     this.tail4.rotationPointX += (float)Math.sin(this.tail4.rotateAngleY) * 10.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doLeftClaw(float angle) {
/* 735 */     this.arml1.rotateAngleY = -0.52F + Math.abs(angle * 2.0F);
/* 736 */     this.arml1.rotationPointZ -= (float)Math.sin(this.arml1.rotateAngleY) * 9.0F;
/* 737 */     this.arml1.rotationPointX += (float)Math.cos(this.arml1.rotateAngleY) * 9.0F;
/* 738 */     this.arml2.rotateAngleY = 0.855F + Math.abs(angle);
/* 739 */     this.arml2.rotationPointZ -= (float)Math.sin(this.arml2.rotateAngleY) * 14.0F;
/* 740 */     this.arml2.rotationPointX += (float)Math.cos(this.arml2.rotateAngleY) * 14.0F;
/* 741 */     this.clawl1.rotateAngleY = 2.7F + Math.abs(angle * 4.0F);
/* 742 */     this.clawl2.rotationPointZ = this.clawl1.rotationPointZ;
/* 743 */     this.clawl2.rotationPointX = this.clawl1.rotationPointX;
/* 744 */     this.clawl2.rotateAngleY = 2.27F + Math.abs(angle * 4.0F);
/* 745 */     this.clawl3.rotationPointZ = this.clawl1.rotationPointZ;
/* 746 */     this.clawl3.rotationPointX = this.clawl1.rotationPointX;
/* 747 */     this.clawl3.rotateAngleY = 2.7F + Math.abs(angle * 4.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void doRightClaw(float angle) {
/* 753 */     this.armr1.rotateAngleY = -2.61F - Math.abs(angle * 2.0F);
/* 754 */     this.armr1.rotationPointZ -= (float)Math.sin(this.armr1.rotateAngleY) * 9.0F;
/* 755 */     this.armr1.rotationPointX += (float)Math.cos(this.armr1.rotateAngleY) * 9.0F;
/* 756 */     this.armr2.rotateAngleY = 2.27F - Math.abs(angle);
/* 757 */     this.armr2.rotationPointZ -= (float)Math.sin(this.armr2.rotateAngleY) * 14.0F;
/* 758 */     this.armr2.rotationPointX += (float)Math.cos(this.armr2.rotateAngleY) * 14.0F;
/* 759 */     this.clawr1.rotateAngleY = 0.436F - Math.abs(angle * 4.0F);
/* 760 */     this.clawr2.rotationPointZ = this.clawr1.rotationPointZ;
/* 761 */     this.clawr2.rotationPointX = this.clawr1.rotationPointX;
/* 762 */     this.clawr2.rotateAngleY = 0.87F - Math.abs(angle * 4.0F);
/* 763 */     this.clawr3.rotationPointZ = this.clawr1.rotationPointZ;
/* 764 */     this.clawr3.rotationPointX = this.clawr1.rotationPointX;
/* 765 */     this.clawr3.rotateAngleY = 0.436F - Math.abs(angle * 4.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\entity\model\ModelAlien.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */