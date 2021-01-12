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
/*     */ public class ModelLizard
/*     */   extends ModelBase
/*     */ {
/*  14 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer BodyBack;
/*     */   
/*     */   ModelRenderer TopBackLeftLeg;
/*     */   ModelRenderer TailTip;
/*     */   ModelRenderer BodyFront;
/*     */   ModelRenderer TailBase1;
/*     */   ModelRenderer Tail2;
/*     */   ModelRenderer Tail3;
/*     */   ModelRenderer Tail4;
/*     */   ModelRenderer Neck;
/*     */   ModelRenderer TopFrontLeftLeg;
/*     */   ModelRenderer TopBackRightLeg;
/*     */   ModelRenderer BottomBackRightLeg;
/*     */   ModelRenderer TopFrontRightLeg;
/*     */   ModelRenderer BottomBackLeftLeg;
/*     */   ModelRenderer BottomFrontRightLeg;
/*     */   ModelRenderer BottomFrontLeftLeg;
/*     */   ModelRenderer BodyCenter;
/*     */   ModelRenderer Toe7;
/*     */   ModelRenderer Toe6;
/*     */   ModelRenderer BackLeftFoot;
/*     */   ModelRenderer Toe4;
/*     */   ModelRenderer Toe5;
/*     */   ModelRenderer BackRightFoot;
/*     */   ModelRenderer Toe8;
/*     */   ModelRenderer Toe1;
/*     */   ModelRenderer FrontLeftFoot;
/*     */   ModelRenderer Toe3;
/*     */   ModelRenderer Toe2;
/*     */   ModelRenderer FrontRightFoot;
/*     */   ModelRenderer FinRidge7;
/*     */   ModelRenderer FinRidge6;
/*     */   ModelRenderer FinRidge5;
/*     */   ModelRenderer FinRidge4;
/*     */   ModelRenderer FinRidge3;
/*     */   ModelRenderer FinRidge2;
/*     */   ModelRenderer FinRidge1;
/*     */   ModelRenderer Fin10;
/*     */   ModelRenderer Fin9;
/*     */   ModelRenderer Fin8;
/*     */   ModelRenderer Fin7;
/*     */   ModelRenderer Fin6;
/*     */   ModelRenderer Fin5;
/*     */   ModelRenderer Fin3;
/*     */   ModelRenderer Fin2;
/*     */   ModelRenderer Tooth11;
/*     */   ModelRenderer Tooth10;
/*     */   ModelRenderer Tooth8;
/*     */   ModelRenderer Tooth7;
/*     */   ModelRenderer Tooth6;
/*     */   ModelRenderer Tooth5;
/*     */   ModelRenderer Tooth4;
/*     */   ModelRenderer Tooth3;
/*     */   ModelRenderer Tooth2;
/*     */   ModelRenderer CenterRightNose;
/*     */   ModelRenderer CenterLeftNose;
/*     */   ModelRenderer Tooth1;
/*     */   ModelRenderer BottomNose;
/*     */   ModelRenderer TopNose;
/*     */   ModelRenderer JawTop;
/*     */   ModelRenderer CenterMiddleNose;
/*     */   ModelRenderer RightEye;
/*     */   ModelRenderer LeftEye;
/*     */   ModelRenderer Tooth16;
/*     */   ModelRenderer Tooth15;
/*     */   ModelRenderer Tooth14;
/*     */   ModelRenderer Tooth13;
/*     */   ModelRenderer Tooth12;
/*     */   ModelRenderer Tooth9;
/*     */   ModelRenderer BottomJaw;
/*     */   ModelRenderer Hat1;
/*     */   ModelRenderer Hat2;
/*     */   
/*     */   public ModelLizard(float f1) {
/*  90 */     this.wingspeed = f1;
/*     */     
/*  92 */     this.textureWidth = 128;
/*  93 */     this.textureHeight = 128;
/*     */     
/*  95 */     this.BodyBack = new ModelRenderer(this, 92, 48);
/*  96 */     this.BodyBack.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 8);
/*  97 */     this.BodyBack.setRotationPoint(0.0F, 14.0F, 0.0F);
/*  98 */     this.BodyBack.setTextureSize(64, 32);
/*  99 */     this.BodyBack.mirror = true;
/* 100 */     setRotation(this.BodyBack, 0.0F, 0.0F, 0.0F);
/* 101 */     this.TopBackLeftLeg = new ModelRenderer(this, 54, 32);
/* 102 */     this.TopBackLeftLeg.addBox(0.0F, -2.0F, -2.0F, 8, 3, 3);
/* 103 */     this.TopBackLeftLeg.setRotationPoint(3.0F, 13.0F, 2.0F);
/* 104 */     this.TopBackLeftLeg.setTextureSize(64, 32);
/* 105 */     this.TopBackLeftLeg.mirror = true;
/* 106 */     setRotation(this.TopBackLeftLeg, 0.0F, 0.0F, 0.2617994F);
/* 107 */     this.TailTip = new ModelRenderer(this, 100, 118);
/* 108 */     this.TailTip.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 8);
/* 109 */     this.TailTip.setRotationPoint(0.0F, 23.0F, 41.0F);
/* 110 */     this.TailTip.setTextureSize(64, 32);
/* 111 */     this.TailTip.mirror = true;
/* 112 */     setRotation(this.TailTip, 0.0F, 0.0F, 0.0F);
/* 113 */     this.BodyFront = new ModelRenderer(this, 92, 16);
/* 114 */     this.BodyFront.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8);
/* 115 */     this.BodyFront.setRotationPoint(0.0F, 14.0F, -8.0F);
/* 116 */     this.BodyFront.setTextureSize(64, 32);
/* 117 */     this.BodyFront.mirror = true;
/* 118 */     setRotation(this.BodyFront, 0.0F, 0.0F, 0.0F);
/* 119 */     this.TailBase1 = new ModelRenderer(this, 88, 64);
/* 120 */     this.TailBase1.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 14);
/* 121 */     this.TailBase1.setRotationPoint(0.0F, 14.0F, 7.0F);
/* 122 */     this.TailBase1.setTextureSize(64, 32);
/* 123 */     this.TailBase1.mirror = true;
/* 124 */     setRotation(this.TailBase1, -0.2617994F, 0.0F, 0.0F);
/* 125 */     this.Tail2 = new ModelRenderer(this, 95, 84);
/* 126 */     this.Tail2.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 10);
/* 127 */     this.Tail2.setRotationPoint(0.0F, 17.0F, 19.0F);
/* 128 */     this.Tail2.setTextureSize(64, 32);
/* 129 */     this.Tail2.mirror = true;
/* 130 */     setRotation(this.Tail2, -0.5235988F, 0.0F, 0.0F);
/* 131 */     this.Tail3 = new ModelRenderer(this, 100, 98);
/* 132 */     this.Tail3.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 8);
/* 133 */     this.Tail3.setRotationPoint(0.0F, 21.0F, 26.0F);
/* 134 */     this.Tail3.setTextureSize(64, 32);
/* 135 */     this.Tail3.mirror = true;
/* 136 */     setRotation(this.Tail3, -0.2617994F, 0.0F, 0.0F);
/* 137 */     this.Tail4 = new ModelRenderer(this, 100, 108);
/* 138 */     this.Tail4.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 8);
/* 139 */     this.Tail4.setRotationPoint(0.0F, 23.0F, 33.0F);
/* 140 */     this.Tail4.setTextureSize(64, 32);
/* 141 */     this.Tail4.mirror = true;
/* 142 */     setRotation(this.Tail4, 0.0F, 0.0F, 0.0F);
/* 143 */     this.Neck = new ModelRenderer(this, 100, 9);
/* 144 */     this.Neck.addBox(-3.0F, -2.0F, -2.0F, 6, 5, 2);
/* 145 */     this.Neck.setRotationPoint(0.0F, 12.0F, -16.0F);
/* 146 */     this.Neck.setTextureSize(64, 32);
/* 147 */     this.Neck.mirror = true;
/* 148 */     setRotation(this.Neck, 0.0F, 0.0F, 0.0F);
/* 149 */     this.TopFrontLeftLeg = new ModelRenderer(this, 26, 12);
/* 150 */     this.TopFrontLeftLeg.addBox(0.0F, -2.0F, -2.0F, 8, 3, 3);
/* 151 */     this.TopFrontLeftLeg.setRotationPoint(3.0F, 13.0F, -12.0F);
/* 152 */     this.TopFrontLeftLeg.setTextureSize(64, 32);
/* 153 */     this.TopFrontLeftLeg.mirror = true;
/* 154 */     setRotation(this.TopFrontLeftLeg, 0.0F, 0.0F, 0.2617994F);
/* 155 */     this.TopBackRightLeg = new ModelRenderer(this, 26, 32);
/* 156 */     this.TopBackRightLeg.addBox(-8.0F, -2.0F, -2.0F, 8, 3, 3);
/* 157 */     this.TopBackRightLeg.setRotationPoint(-3.0F, 13.0F, 2.0F);
/* 158 */     this.TopBackRightLeg.setTextureSize(64, 32);
/* 159 */     this.TopBackRightLeg.mirror = true;
/* 160 */     setRotation(this.TopBackRightLeg, 0.0F, 0.0F, -0.2617994F);
/* 161 */     this.BottomBackRightLeg = new ModelRenderer(this, 25, 26);
/* 162 */     this.BottomBackRightLeg.addBox(-12.0F, -8.0F, -2.0F, 9, 3, 3);
/* 163 */     this.BottomBackRightLeg.setRotationPoint(-3.0F, 13.0F, 2.0F);
/* 164 */     this.BottomBackRightLeg.setTextureSize(64, 32);
/* 165 */     this.BottomBackRightLeg.mirror = true;
/* 166 */     setRotation(this.BottomBackRightLeg, 0.0F, 0.0F, -1.308997F);
/* 167 */     this.TopFrontRightLeg = new ModelRenderer(this, 54, 12);
/* 168 */     this.TopFrontRightLeg.addBox(-8.0F, -2.0F, -2.0F, 8, 3, 3);
/* 169 */     this.TopFrontRightLeg.setRotationPoint(-3.0F, 13.0F, -12.0F);
/* 170 */     this.TopFrontRightLeg.setTextureSize(64, 32);
/* 171 */     this.TopFrontRightLeg.mirror = true;
/* 172 */     setRotation(this.TopFrontRightLeg, 0.0F, 0.0F, -0.2617994F);
/* 173 */     this.BottomBackLeftLeg = new ModelRenderer(this, 53, 26);
/* 174 */     this.BottomBackLeftLeg.addBox(3.0F, -8.0F, -2.0F, 9, 3, 3);
/* 175 */     this.BottomBackLeftLeg.setRotationPoint(3.0F, 13.0F, 2.0F);
/* 176 */     this.BottomBackLeftLeg.setTextureSize(64, 32);
/* 177 */     this.BottomBackLeftLeg.mirror = true;
/* 178 */     setRotation(this.BottomBackLeftLeg, 0.0F, 0.0F, 1.308997F);
/* 179 */     this.BottomFrontRightLeg = new ModelRenderer(this, 53, 18);
/* 180 */     this.BottomFrontRightLeg.addBox(-12.0F, -8.0F, -2.0F, 9, 3, 3);
/* 181 */     this.BottomFrontRightLeg.setRotationPoint(-3.0F, 13.0F, -12.0F);
/* 182 */     this.BottomFrontRightLeg.setTextureSize(64, 32);
/* 183 */     this.BottomFrontRightLeg.mirror = true;
/* 184 */     setRotation(this.BottomFrontRightLeg, 0.0F, 0.0F, -1.308997F);
/* 185 */     this.BottomFrontLeftLeg = new ModelRenderer(this, 25, 18);
/* 186 */     this.BottomFrontLeftLeg.addBox(3.0F, -8.0F, -2.0F, 9, 3, 3);
/* 187 */     this.BottomFrontLeftLeg.setRotationPoint(3.0F, 13.0F, -12.0F);
/* 188 */     this.BottomFrontLeftLeg.setTextureSize(64, 32);
/* 189 */     this.BottomFrontLeftLeg.mirror = true;
/* 190 */     setRotation(this.BottomFrontLeftLeg, 0.0F, 0.0F, 1.308997F);
/* 191 */     this.BodyCenter = new ModelRenderer(this, 92, 32);
/* 192 */     this.BodyCenter.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
/* 193 */     this.BodyCenter.setRotationPoint(0.0F, 14.0F, -4.0F);
/* 194 */     this.BodyCenter.setTextureSize(64, 32);
/* 195 */     this.BodyCenter.mirror = true;
/* 196 */     setRotation(this.BodyCenter, 0.0F, 0.0F, 0.0F);
/* 197 */     this.Toe7 = new ModelRenderer(this, 104, 0);
/* 198 */     this.Toe7.addBox(10.0F, 10.0F, -5.0F, 1, 1, 1);
/* 199 */     this.Toe7.setRotationPoint(3.0F, 13.0F, 2.0F);
/* 200 */     this.Toe7.setTextureSize(64, 32);
/* 201 */     this.Toe7.mirror = true;
/* 202 */     setRotation(this.Toe7, 0.0F, 0.0F, 0.0F);
/* 203 */     this.Toe6 = new ModelRenderer(this, 108, 0);
/* 204 */     this.Toe6.addBox(8.0F, 10.0F, -5.0F, 1, 1, 1);
/* 205 */     this.Toe6.setRotationPoint(3.0F, 13.0F, 2.0F);
/* 206 */     this.Toe6.setTextureSize(64, 32);
/* 207 */     this.Toe6.mirror = true;
/* 208 */     setRotation(this.Toe6, 0.0F, 0.0F, 0.0F);
/* 209 */     this.BackLeftFoot = new ModelRenderer(this, 20, 0);
/* 210 */     this.BackLeftFoot.addBox(7.0F, 9.0F, -4.0F, 4, 2, 6);
/* 211 */     this.BackLeftFoot.setRotationPoint(3.0F, 13.0F, 2.0F);
/* 212 */     this.BackLeftFoot.setTextureSize(64, 32);
/* 213 */     this.BackLeftFoot.mirror = true;
/* 214 */     setRotation(this.BackLeftFoot, 0.0F, 0.0F, 0.0F);
/* 215 */     this.Toe4 = new ModelRenderer(this, 80, 0);
/* 216 */     this.Toe4.addBox(-11.0F, 10.0F, -5.0F, 1, 1, 1);
/* 217 */     this.Toe4.setRotationPoint(-3.0F, 13.0F, 2.0F);
/* 218 */     this.Toe4.setTextureSize(64, 32);
/* 219 */     this.Toe4.mirror = true;
/* 220 */     setRotation(this.Toe4, 0.0F, 0.0F, 0.0F);
/* 221 */     this.Toe5 = new ModelRenderer(this, 84, 0);
/* 222 */     this.Toe5.addBox(-9.0F, 10.0F, -5.0F, 1, 1, 1);
/* 223 */     this.Toe5.setRotationPoint(-3.0F, 13.0F, 2.0F);
/* 224 */     this.Toe5.setTextureSize(64, 32);
/* 225 */     this.Toe5.mirror = true;
/* 226 */     setRotation(this.Toe5, 0.0F, 0.0F, 0.0F);
/* 227 */     this.BackRightFoot = new ModelRenderer(this, 60, 0);
/* 228 */     this.BackRightFoot.addBox(-11.0F, 9.0F, -4.0F, 4, 2, 6);
/* 229 */     this.BackRightFoot.setRotationPoint(-3.0F, 13.0F, 2.0F);
/* 230 */     this.BackRightFoot.setTextureSize(64, 32);
/* 231 */     this.BackRightFoot.mirror = true;
/* 232 */     setRotation(this.BackRightFoot, 0.0F, 0.0F, 0.0F);
/* 233 */     this.Toe8 = new ModelRenderer(this, 100, 0);
/* 234 */     this.Toe8.addBox(10.0F, 10.0F, -5.0F, 1, 1, 1);
/* 235 */     this.Toe8.setRotationPoint(3.0F, 13.0F, -12.0F);
/* 236 */     this.Toe8.setTextureSize(64, 32);
/* 237 */     this.Toe8.mirror = true;
/* 238 */     setRotation(this.Toe8, 0.0F, 0.0F, 0.0F);
/* 239 */     this.Toe1 = new ModelRenderer(this, 96, 0);
/* 240 */     this.Toe1.addBox(8.0F, 10.0F, -5.0F, 1, 1, 1);
/* 241 */     this.Toe1.setRotationPoint(3.0F, 13.0F, -12.0F);
/* 242 */     this.Toe1.setTextureSize(64, 32);
/* 243 */     this.Toe1.mirror = true;
/* 244 */     setRotation(this.Toe1, 0.0F, 0.0F, 0.0F);
/* 245 */     this.FrontLeftFoot = new ModelRenderer(this, 40, 0);
/* 246 */     this.FrontLeftFoot.addBox(7.0F, 9.0F, -4.0F, 4, 2, 6);
/* 247 */     this.FrontLeftFoot.setRotationPoint(3.0F, 13.0F, -12.0F);
/* 248 */     this.FrontLeftFoot.setTextureSize(64, 32);
/* 249 */     this.FrontLeftFoot.mirror = true;
/* 250 */     setRotation(this.FrontLeftFoot, 0.0F, 0.0F, 0.0F);
/* 251 */     this.Toe3 = new ModelRenderer(this, 88, 0);
/* 252 */     this.Toe3.addBox(-11.0F, 10.0F, -5.0F, 1, 1, 1);
/* 253 */     this.Toe3.setRotationPoint(-3.0F, 13.0F, -12.0F);
/* 254 */     this.Toe3.setTextureSize(64, 32);
/* 255 */     this.Toe3.mirror = true;
/* 256 */     setRotation(this.Toe3, 0.0F, 0.0F, 0.0F);
/* 257 */     this.Toe2 = new ModelRenderer(this, 92, 0);
/* 258 */     this.Toe2.addBox(-9.0F, 10.0F, -5.0F, 1, 1, 1);
/* 259 */     this.Toe2.setRotationPoint(-3.0F, 13.0F, -12.0F);
/* 260 */     this.Toe2.setTextureSize(64, 32);
/* 261 */     this.Toe2.mirror = true;
/* 262 */     setRotation(this.Toe2, 0.0F, 0.0F, 0.0F);
/* 263 */     this.FrontRightFoot = new ModelRenderer(this, 0, 0);
/* 264 */     this.FrontRightFoot.addBox(-11.0F, 9.0F, -4.0F, 4, 2, 6);
/* 265 */     this.FrontRightFoot.setRotationPoint(-3.0F, 13.0F, -12.0F);
/* 266 */     this.FrontRightFoot.setTextureSize(64, 32);
/* 267 */     this.FrontRightFoot.mirror = true;
/* 268 */     setRotation(this.FrontRightFoot, 0.0F, 0.0F, 0.0F);
/* 269 */     this.FinRidge7 = new ModelRenderer(this, 0, 99);
/* 270 */     this.FinRidge7.addBox(0.0F, -13.0F, 0.0F, 2, 13, 1);
/* 271 */     this.FinRidge7.setRotationPoint(-1.0F, 10.0F, -4.5F);
/* 272 */     this.FinRidge7.setTextureSize(64, 32);
/* 273 */     this.FinRidge7.mirror = true;
/* 274 */     setRotation(this.FinRidge7, -0.9666439F, 0.0F, 0.0F);
/* 275 */     this.FinRidge6 = new ModelRenderer(this, 6, 98);
/* 276 */     this.FinRidge6.addBox(0.0F, -13.0F, 0.0F, 2, 13, 1);
/* 277 */     this.FinRidge6.setRotationPoint(-1.0F, 10.0F, -4.0F);
/* 278 */     this.FinRidge6.setTextureSize(64, 32);
/* 279 */     this.FinRidge6.mirror = true;
/* 280 */     setRotation(this.FinRidge6, -0.5205006F, 0.0F, 0.0F);
/* 281 */     this.FinRidge5 = new ModelRenderer(this, 12, 99);
/* 282 */     this.FinRidge5.addBox(0.0F, -13.0F, 0.0F, 2, 13, 1);
/* 283 */     this.FinRidge5.setRotationPoint(-1.0F, 10.0F, -4.0F);
/* 284 */     this.FinRidge5.setTextureSize(64, 32);
/* 285 */     this.FinRidge5.mirror = true;
/* 286 */     setRotation(this.FinRidge5, 0.0F, 0.0F, 0.0F);
/* 287 */     this.FinRidge4 = new ModelRenderer(this, 6, 114);
/* 288 */     this.FinRidge4.addBox(0.0F, -13.0F, 0.0F, 2, 13, 1);
/* 289 */     this.FinRidge4.setRotationPoint(-1.0F, 10.0F, -3.5F);
/* 290 */     this.FinRidge4.setTextureSize(64, 32);
/* 291 */     this.FinRidge4.mirror = true;
/* 292 */     setRotation(this.FinRidge4, 0.9666439F, 0.0F, 0.0F);
/* 293 */     this.FinRidge3 = new ModelRenderer(this, 12, 115);
/* 294 */     this.FinRidge3.addBox(0.0F, -13.0F, 0.0F, 2, 13, 1);
/* 295 */     this.FinRidge3.setRotationPoint(-1.0F, 10.0F, -4.0F);
/* 296 */     this.FinRidge3.setTextureSize(64, 32);
/* 297 */     this.FinRidge3.mirror = true;
/* 298 */     setRotation(this.FinRidge3, 0.5205006F, 0.0F, 0.0F);
/* 299 */     this.FinRidge2 = new ModelRenderer(this, 0, 84);
/* 300 */     this.FinRidge2.addBox(0.0F, -13.0F, 0.0F, 2, 13, 1);
/* 301 */     this.FinRidge2.setRotationPoint(-1.0F, 10.0F, -4.5F);
/* 302 */     this.FinRidge2.setTextureSize(64, 32);
/* 303 */     this.FinRidge2.mirror = true;
/* 304 */     setRotation(this.FinRidge2, -1.375609F, 0.0F, 0.0F);
/* 305 */     this.FinRidge1 = new ModelRenderer(this, 0, 114);
/* 306 */     this.FinRidge1.addBox(0.0F, -13.0F, 0.0F, 2, 13, 1);
/* 307 */     this.FinRidge1.setRotationPoint(-1.0F, 10.0F, -3.5F);
/* 308 */     this.FinRidge1.setTextureSize(64, 32);
/* 309 */     this.FinRidge1.mirror = true;
/* 310 */     setRotation(this.FinRidge1, 1.412787F, 0.0F, 0.0F);
/* 311 */     this.Fin10 = new ModelRenderer(this, 0, 58);
/* 312 */     this.Fin10.addBox(0.0F, -13.0F, -2.0F, 0, 11, 6);
/* 313 */     this.Fin10.setRotationPoint(0.0F, 10.5F, -5.0F);
/* 314 */     this.Fin10.setTextureSize(64, 32);
/* 315 */     this.Fin10.mirror = true;
/* 316 */     setRotation(this.Fin10, 0.2094395F, 0.0F, 0.0F);
/* 317 */     this.Fin9 = new ModelRenderer(this, 7, 84);
/* 318 */     this.Fin9.addBox(0.0F, -11.0F, 0.0F, 0, 11, 3);
/* 319 */     this.Fin9.setRotationPoint(0.0F, 10.0F, -5.0F);
/* 320 */     this.Fin9.setTextureSize(64, 32);
/* 321 */     this.Fin9.mirror = true;
/* 322 */     setRotation(this.Fin9, 1.570796F, 0.0F, 0.0F);
/* 323 */     this.Fin8 = new ModelRenderer(this, 12, 34);
/* 324 */     this.Fin8.addBox(0.0F, -7.0F, -4.0F, 0, 7, 4);
/* 325 */     this.Fin8.setRotationPoint(0.0F, 10.0F, 1.0F);
/* 326 */     this.Fin8.setTextureSize(64, 32);
/* 327 */     this.Fin8.mirror = true;
/* 328 */     setRotation(this.Fin8, -1.570796F, 0.0F, 0.0F);
/* 329 */     this.Fin7 = new ModelRenderer(this, 12, 46);
/* 330 */     this.Fin7.addBox(0.0F, -8.0F, -4.0F, 0, 8, 4);
/* 331 */     this.Fin7.setRotationPoint(0.0F, 10.0F, 1.0F);
/* 332 */     this.Fin7.setTextureSize(64, 32);
/* 333 */     this.Fin7.mirror = true;
/* 334 */     setRotation(this.Fin7, -1.033256F, 0.0F, 0.0F);
/* 335 */     this.Fin6 = new ModelRenderer(this, 0, 31);
/* 336 */     this.Fin6.addBox(0.0F, -10.0F, -4.0F, 0, 10, 4);
/* 337 */     this.Fin6.setRotationPoint(0.0F, 10.0F, -1.0F);
/* 338 */     this.Fin6.setTextureSize(64, 32);
/* 339 */     this.Fin6.mirror = true;
/* 340 */     setRotation(this.Fin6, -0.7267386F, 0.0F, 0.0F);
/* 341 */     this.Fin5 = new ModelRenderer(this, 30, 59);
/* 342 */     this.Fin5.addBox(0.0F, -12.0F, -5.0F, 0, 11, 6);
/* 343 */     this.Fin5.setRotationPoint(0.0F, 10.0F, -2.0F);
/* 344 */     this.Fin5.setTextureSize(64, 32);
/* 345 */     this.Fin5.mirror = true;
/* 346 */     setRotation(this.Fin5, -0.3003206F, 0.0F, 0.0F);
/* 347 */     this.Fin3 = new ModelRenderer(this, 14, 60);
/* 348 */     this.Fin3.addBox(0.0F, -12.0F, -3.0F, 0, 12, 6);
/* 349 */     this.Fin3.setRotationPoint(0.0F, 10.0F, -4.0F);
/* 350 */     this.Fin3.setTextureSize(64, 32);
/* 351 */     this.Fin3.mirror = true;
/* 352 */     setRotation(this.Fin3, 0.7073231F, 0.0F, 0.0F);
/* 353 */     this.Fin2 = new ModelRenderer(this, 14, 79);
/* 354 */     this.Fin2.addBox(0.0F, -12.0F, -4.0F, 0, 11, 6);
/* 355 */     this.Fin2.setRotationPoint(0.0F, 10.0F, -4.0F);
/* 356 */     this.Fin2.setTextureSize(64, 32);
/* 357 */     this.Fin2.mirror = true;
/* 358 */     setRotation(this.Fin2, 1.048747F, 0.0F, 0.0F);
/* 359 */     this.Tooth11 = new ModelRenderer(this, 24, 110);
/* 360 */     this.Tooth11.addBox(3.0F, 3.0F, -8.0F, 1, 1, 1);
/* 361 */     this.Tooth11.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 362 */     this.Tooth11.setTextureSize(64, 32);
/* 363 */     this.Tooth11.mirror = true;
/* 364 */     setRotation(this.Tooth11, 0.0F, 0.0F, 0.0F);
/* 365 */     this.Tooth10 = new ModelRenderer(this, 24, 106);
/* 366 */     this.Tooth10.addBox(3.0F, 3.0F, -10.0F, 1, 1, 1);
/* 367 */     this.Tooth10.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 368 */     this.Tooth10.setTextureSize(64, 32);
/* 369 */     this.Tooth10.mirror = true;
/* 370 */     setRotation(this.Tooth10, 0.0F, 0.0F, 0.0F);
/* 371 */     this.Tooth8 = new ModelRenderer(this, 28, 95);
/* 372 */     this.Tooth8.addBox(3.0F, 3.0F, -14.0F, 1, 1, 1);
/* 373 */     this.Tooth8.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 374 */     this.Tooth8.setTextureSize(64, 32);
/* 375 */     this.Tooth8.mirror = true;
/* 376 */     setRotation(this.Tooth8, 0.0F, 0.0F, 0.0F);
/* 377 */     this.Tooth7 = new ModelRenderer(this, 70, 106);
/* 378 */     this.Tooth7.addBox(-4.0F, 3.0F, -10.0F, 1, 1, 1);
/* 379 */     this.Tooth7.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 380 */     this.Tooth7.setTextureSize(64, 32);
/* 381 */     this.Tooth7.mirror = true;
/* 382 */     setRotation(this.Tooth7, 0.0F, 0.0F, 0.0F);
/* 383 */     this.Tooth6 = new ModelRenderer(this, 70, 102);
/* 384 */     this.Tooth6.addBox(-4.0F, 3.0F, -12.0F, 1, 1, 1);
/* 385 */     this.Tooth6.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 386 */     this.Tooth6.setTextureSize(64, 32);
/* 387 */     this.Tooth6.mirror = true;
/* 388 */     setRotation(this.Tooth6, 0.0F, 0.0F, 0.0F);
/* 389 */     this.Tooth5 = new ModelRenderer(this, 66, 95);
/* 390 */     this.Tooth5.addBox(-4.0F, 3.0F, -14.0F, 1, 1, 1);
/* 391 */     this.Tooth5.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 392 */     this.Tooth5.setTextureSize(64, 32);
/* 393 */     this.Tooth5.mirror = true;
/* 394 */     setRotation(this.Tooth5, 0.0F, 0.0F, 0.0F);
/* 395 */     this.Tooth4 = new ModelRenderer(this, 60, 95);
/* 396 */     this.Tooth4.addBox(1.0F, 3.0F, -14.0F, 1, 1, 1);
/* 397 */     this.Tooth4.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 398 */     this.Tooth4.setTextureSize(64, 32);
/* 399 */     this.Tooth4.mirror = true;
/* 400 */     setRotation(this.Tooth4, 0.0F, 0.0F, 0.0F);
/* 401 */     this.Tooth3 = new ModelRenderer(this, 34, 95);
/* 402 */     this.Tooth3.addBox(-2.0F, 3.0F, -14.0F, 1, 1, 1);
/* 403 */     this.Tooth3.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 404 */     this.Tooth3.setTextureSize(64, 32);
/* 405 */     this.Tooth3.mirror = true;
/* 406 */     setRotation(this.Tooth3, 0.0F, 0.0F, 0.0F);
/* 407 */     this.Tooth2 = new ModelRenderer(this, 70, 110);
/* 408 */     this.Tooth2.addBox(-4.0F, 3.0F, -8.0F, 1, 1, 1);
/* 409 */     this.Tooth2.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 410 */     this.Tooth2.setTextureSize(64, 32);
/* 411 */     this.Tooth2.mirror = true;
/* 412 */     setRotation(this.Tooth2, 0.0F, 0.0F, 0.0F);
/* 413 */     this.CenterRightNose = new ModelRenderer(this, 40, 88);
/* 414 */     this.CenterRightNose.addBox(-4.0F, 0.0F, -14.0F, 1, 1, 1);
/* 415 */     this.CenterRightNose.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 416 */     this.CenterRightNose.setTextureSize(64, 32);
/* 417 */     this.CenterRightNose.mirror = true;
/* 418 */     setRotation(this.CenterRightNose, 0.0F, 0.0F, 0.0F);
/* 419 */     this.CenterLeftNose = new ModelRenderer(this, 54, 88);
/* 420 */     this.CenterLeftNose.addBox(3.0F, 0.0F, -14.0F, 1, 1, 1);
/* 421 */     this.CenterLeftNose.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 422 */     this.CenterLeftNose.setTextureSize(64, 32);
/* 423 */     this.CenterLeftNose.mirror = true;
/* 424 */     setRotation(this.CenterLeftNose, 0.0F, 0.0F, 0.0F);
/* 425 */     this.Tooth1 = new ModelRenderer(this, 24, 102);
/* 426 */     this.Tooth1.addBox(3.0F, 3.0F, -12.0F, 1, 1, 1);
/* 427 */     this.Tooth1.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 428 */     this.Tooth1.setTextureSize(64, 32);
/* 429 */     this.Tooth1.mirror = true;
/* 430 */     setRotation(this.Tooth1, 0.0F, 0.0F, 0.0F);
/* 431 */     this.BottomNose = new ModelRenderer(this, 40, 90);
/* 432 */     this.BottomNose.addBox(-4.0F, 1.0F, -14.0F, 8, 2, 1);
/* 433 */     this.BottomNose.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 434 */     this.BottomNose.setTextureSize(64, 32);
/* 435 */     this.BottomNose.mirror = true;
/* 436 */     setRotation(this.BottomNose, 0.0F, 0.0F, 0.0F);
/* 437 */     this.TopNose = new ModelRenderer(this, 40, 84);
/* 438 */     this.TopNose.addBox(-4.0F, -3.0F, -14.0F, 8, 3, 1);
/* 439 */     this.TopNose.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 440 */     this.TopNose.setTextureSize(64, 32);
/* 441 */     this.TopNose.mirror = true;
/* 442 */     setRotation(this.TopNose, 0.0F, 0.0F, 0.0F);
/* 443 */     this.JawTop = new ModelRenderer(this, 28, 97);
/* 444 */     this.JawTop.addBox(-4.0F, -3.0F, -13.0F, 8, 6, 13);
/* 445 */     this.JawTop.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 446 */     this.JawTop.setTextureSize(64, 32);
/* 447 */     this.JawTop.mirror = true;
/* 448 */     setRotation(this.JawTop, 0.0F, 0.0F, 0.0F);
/* 449 */     this.CenterMiddleNose = new ModelRenderer(this, 46, 88);
/* 450 */     this.CenterMiddleNose.addBox(-1.0F, 0.0F, -14.0F, 2, 1, 1);
/* 451 */     this.CenterMiddleNose.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 452 */     this.CenterMiddleNose.setTextureSize(64, 32);
/* 453 */     this.CenterMiddleNose.mirror = true;
/* 454 */     setRotation(this.CenterMiddleNose, 0.0F, 0.0F, 0.0F);
/* 455 */     this.RightEye = new ModelRenderer(this, 116, 10);
/* 456 */     this.RightEye.addBox(-2.0F, -4.0F, -4.0F, 2, 2, 1);
/* 457 */     this.RightEye.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 458 */     this.RightEye.setTextureSize(64, 32);
/* 459 */     this.RightEye.mirror = true;
/* 460 */     setRotation(this.RightEye, 0.0F, 0.7853982F, 0.3490659F);
/* 461 */     this.LeftEye = new ModelRenderer(this, 94, 10);
/* 462 */     this.LeftEye.addBox(0.0F, -4.0F, -4.0F, 2, 2, 1);
/* 463 */     this.LeftEye.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 464 */     this.LeftEye.setTextureSize(64, 32);
/* 465 */     this.LeftEye.mirror = true;
/* 466 */     setRotation(this.LeftEye, 0.0F, -0.7853982F, -0.3490659F);
/* 467 */     this.Tooth16 = new ModelRenderer(this, 24, 97);
/* 468 */     this.Tooth16.addBox(3.0F, -1.0F, -10.0F, 1, 1, 1);
/* 469 */     this.Tooth16.setRotationPoint(0.0F, 14.0F, -19.0F);
/* 470 */     this.Tooth16.setTextureSize(64, 32);
/* 471 */     this.Tooth16.mirror = true;
/* 472 */     setRotation(this.Tooth16, 0.5235988F, 0.0F, 0.0F);
/* 473 */     this.Tooth15 = new ModelRenderer(this, 70, 97);
/* 474 */     this.Tooth15.addBox(-4.0F, -1.0F, -10.0F, 1, 1, 1);
/* 475 */     this.Tooth15.setRotationPoint(0.0F, 14.0F, -19.0F);
/* 476 */     this.Tooth15.setTextureSize(64, 32);
/* 477 */     this.Tooth15.mirror = true;
/* 478 */     setRotation(this.Tooth15, 0.5235988F, 0.0F, 0.0F);
/* 479 */     this.Tooth14 = new ModelRenderer(this, 42, 95);
/* 480 */     this.Tooth14.addBox(-2.0F, -1.0F, -10.0F, 1, 1, 1);
/* 481 */     this.Tooth14.setRotationPoint(0.0F, 14.0F, -19.0F);
/* 482 */     this.Tooth14.setTextureSize(64, 32);
/* 483 */     this.Tooth14.mirror = true;
/* 484 */     setRotation(this.Tooth14, 0.5235988F, 0.0F, 0.0F);
/* 485 */     this.Tooth13 = new ModelRenderer(this, 52, 95);
/* 486 */     this.Tooth13.addBox(1.0F, -1.0F, -10.0F, 1, 1, 1);
/* 487 */     this.Tooth13.setRotationPoint(0.0F, 14.0F, -19.0F);
/* 488 */     this.Tooth13.setTextureSize(64, 32);
/* 489 */     this.Tooth13.mirror = true;
/* 490 */     setRotation(this.Tooth13, 0.5235988F, 0.0F, 0.0F);
/* 491 */     this.Tooth12 = new ModelRenderer(this, 24, 114);
/* 492 */     this.Tooth12.addBox(3.0F, -1.0F, -7.0F, 1, 1, 1);
/* 493 */     this.Tooth12.setRotationPoint(0.0F, 14.0F, -19.0F);
/* 494 */     this.Tooth12.setTextureSize(64, 32);
/* 495 */     this.Tooth12.mirror = true;
/* 496 */     setRotation(this.Tooth12, 0.5235988F, 0.0F, 0.0F);
/* 497 */     this.Tooth9 = new ModelRenderer(this, 70, 114);
/* 498 */     this.Tooth9.addBox(-4.0F, -1.0F, -7.0F, 1, 1, 1);
/* 499 */     this.Tooth9.setRotationPoint(0.0F, 14.0F, -19.0F);
/* 500 */     this.Tooth9.setTextureSize(64, 32);
/* 501 */     this.Tooth9.mirror = true;
/* 502 */     setRotation(this.Tooth9, 0.5235988F, 0.0F, 0.0F);
/* 503 */     this.BottomJaw = new ModelRenderer(this, 31, 116);
/* 504 */     this.BottomJaw.addBox(-4.0F, 0.0F, -10.0F, 8, 2, 10);
/* 505 */     this.BottomJaw.setRotationPoint(0.0F, 14.0F, -19.0F);
/* 506 */     this.BottomJaw.setTextureSize(64, 32);
/* 507 */     this.BottomJaw.mirror = true;
/* 508 */     setRotation(this.BottomJaw, 0.5235988F, 0.0F, 0.0F);
/* 509 */     this.Hat1 = new ModelRenderer(this, 30, 40);
/* 510 */     this.Hat1.addBox(-2.0F, -4.0F, -6.0F, 4, 1, 6);
/* 511 */     this.Hat1.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 512 */     this.Hat1.setTextureSize(128, 128);
/* 513 */     this.Hat1.mirror = true;
/* 514 */     setRotation(this.Hat1, 0.0F, 0.0F, 0.0F);
/* 515 */     this.Hat2 = new ModelRenderer(this, 30, 40);
/* 516 */     this.Hat2.addBox(-1.5F, -6.0F, -4.0F, 3, 2, 4);
/* 517 */     this.Hat2.setRotationPoint(0.0F, 12.0F, -18.0F);
/* 518 */     this.Hat2.setTextureSize(128, 128);
/* 519 */     this.Hat2.mirror = true;
/* 520 */     setRotation(this.Hat2, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 526 */     Lizard e = (Lizard)entity;
/* 527 */     float newangle = 0.0F;
/* 528 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 529 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 531 */     if (f1 > 0.1D) {
/* 532 */       newangle = MathHelper.cos(f2 * 1.0F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 534 */       newangle = 0.0F;
/*     */     } 
/*     */ 
/*     */     
/* 538 */     this.TopFrontLeftLeg.rotateAngleY = newangle;
/* 539 */     this.BottomFrontLeftLeg.rotateAngleX = newangle;
/* 540 */     this.FrontLeftFoot.rotateAngleY = newangle;
/* 541 */     this.Toe8.rotateAngleY = newangle;
/* 542 */     this.Toe1.rotateAngleY = newangle;
/*     */     
/* 544 */     this.TopFrontRightLeg.rotateAngleY = newangle;
/* 545 */     this.BottomFrontRightLeg.rotateAngleX = -newangle;
/* 546 */     this.FrontRightFoot.rotateAngleY = newangle;
/* 547 */     this.Toe3.rotateAngleY = newangle;
/* 548 */     this.Toe2.rotateAngleY = newangle;
/*     */     
/* 550 */     this.TopBackLeftLeg.rotateAngleY = -newangle;
/* 551 */     this.BottomBackLeftLeg.rotateAngleX = -newangle;
/* 552 */     this.BackLeftFoot.rotateAngleY = -newangle;
/* 553 */     this.Toe7.rotateAngleY = -newangle;
/* 554 */     this.Toe6.rotateAngleY = -newangle;
/*     */     
/* 556 */     this.TopBackRightLeg.rotateAngleY = -newangle;
/* 557 */     this.BottomBackRightLeg.rotateAngleX = newangle;
/* 558 */     this.BackRightFoot.rotateAngleY = -newangle;
/* 559 */     this.Toe4.rotateAngleY = -newangle;
/* 560 */     this.Toe5.rotateAngleY = -newangle;
/*     */ 
/*     */ 
/*     */     
/* 564 */     if (e.getAttacking() != 0) {
/* 565 */       this.BottomJaw.rotateAngleX = 0.52F + MathHelper.cos(f2 * 0.45F) * 0.35F;
/*     */     } else {
/* 567 */       this.BottomJaw.rotateAngleX = 0.25F;
/*     */     } 
/* 569 */     this.Tooth9.rotateAngleX = this.BottomJaw.rotateAngleX;
/* 570 */     this.Tooth15.rotateAngleX = this.BottomJaw.rotateAngleX;
/* 571 */     this.Tooth14.rotateAngleX = this.BottomJaw.rotateAngleX;
/* 572 */     this.Tooth13.rotateAngleX = this.BottomJaw.rotateAngleX;
/* 573 */     this.Tooth16.rotateAngleX = this.BottomJaw.rotateAngleX;
/* 574 */     this.Tooth12.rotateAngleX = this.BottomJaw.rotateAngleX;
/*     */ 
/*     */     
/* 577 */     newangle = MathHelper.cos(f2 * 0.25F * this.wingspeed) * 3.1415927F * 0.05F;
/* 578 */     if (e.getAttacking() != 0) {
/* 579 */       newangle = MathHelper.cos(f2 * 1.25F * this.wingspeed) * 3.1415927F * 0.35F;
/*     */     }
/*     */     
/* 582 */     this.TailBase1.rotateAngleY = newangle * 0.25F;
/* 583 */     this.TailBase1.rotationPointZ += (float)Math.cos(this.TailBase1.rotateAngleY) * 12.0F;
/* 584 */     this.TailBase1.rotationPointX += (float)Math.sin(this.TailBase1.rotateAngleY) * 12.0F;
/* 585 */     this.Tail2.rotateAngleY = newangle * 0.5F;
/* 586 */     this.Tail2.rotationPointZ += (float)Math.cos(this.Tail2.rotateAngleY) * 9.0F;
/* 587 */     this.Tail2.rotationPointX += (float)Math.sin(this.Tail2.rotateAngleY) * 9.0F;
/* 588 */     this.Tail3.rotateAngleY = newangle * 0.75F;
/* 589 */     this.Tail3.rotationPointZ += (float)Math.cos(this.Tail3.rotateAngleY) * 7.0F;
/* 590 */     this.Tail3.rotationPointX += (float)Math.sin(this.Tail3.rotateAngleY) * 7.0F;
/* 591 */     this.Tail4.rotateAngleY = newangle * 1.0F;
/* 592 */     this.Tail4.rotationPointZ += (float)Math.cos(this.Tail4.rotateAngleY) * 7.0F;
/* 593 */     this.Tail4.rotationPointX += (float)Math.sin(this.Tail4.rotateAngleY) * 7.0F;
/* 594 */     this.TailTip.rotateAngleY = newangle * 1.25F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 600 */     this.Neck.rotateAngleY = (float)Math.toRadians(f3) * 0.25F;
/* 601 */     this.Neck.rotationPointZ -= (float)Math.cos(this.Neck.rotateAngleY) * 2.0F;
/* 602 */     this.Neck.rotationPointX -= (float)Math.sin(this.Neck.rotateAngleY) * 2.0F;
/* 603 */     this.JawTop.rotateAngleY = (float)Math.toRadians(f3) * 0.5F;
/* 604 */     this.TopNose.rotationPointZ = this.JawTop.rotationPointZ;
/* 605 */     this.TopNose.rotationPointX = this.JawTop.rotationPointX;
/* 606 */     this.TopNose.rotateAngleY = this.JawTop.rotateAngleY;
/* 607 */     this.BottomNose.rotationPointZ = this.JawTop.rotationPointZ;
/* 608 */     this.BottomNose.rotationPointX = this.JawTop.rotationPointX;
/* 609 */     this.BottomNose.rotateAngleY = this.JawTop.rotateAngleY;
/* 610 */     this.CenterRightNose.rotationPointZ = this.JawTop.rotationPointZ;
/* 611 */     this.CenterRightNose.rotationPointX = this.JawTop.rotationPointX;
/* 612 */     this.CenterRightNose.rotateAngleY = this.JawTop.rotateAngleY;
/* 613 */     this.CenterMiddleNose.rotationPointZ = this.JawTop.rotationPointZ;
/* 614 */     this.CenterMiddleNose.rotationPointX = this.JawTop.rotationPointX;
/* 615 */     this.CenterMiddleNose.rotateAngleY = this.JawTop.rotateAngleY;
/* 616 */     this.CenterLeftNose.rotationPointZ = this.JawTop.rotationPointZ;
/* 617 */     this.CenterLeftNose.rotationPointX = this.JawTop.rotationPointX;
/* 618 */     this.CenterLeftNose.rotateAngleY = this.JawTop.rotateAngleY;
/* 619 */     this.RightEye.rotationPointZ = this.JawTop.rotationPointZ;
/* 620 */     this.RightEye.rotationPointX = this.JawTop.rotationPointX;
/* 621 */     this.JawTop.rotateAngleY += 0.78F;
/* 622 */     this.LeftEye.rotationPointZ = this.JawTop.rotationPointZ;
/* 623 */     this.LeftEye.rotationPointX = this.JawTop.rotationPointX;
/* 624 */     this.JawTop.rotateAngleY -= 0.78F;
/* 625 */     this.Tooth11.rotationPointZ = this.JawTop.rotationPointZ;
/* 626 */     this.Tooth11.rotationPointX = this.JawTop.rotationPointX;
/* 627 */     this.Tooth11.rotateAngleY = this.JawTop.rotateAngleY;
/* 628 */     this.Tooth10.rotationPointZ = this.JawTop.rotationPointZ;
/* 629 */     this.Tooth10.rotationPointX = this.JawTop.rotationPointX;
/* 630 */     this.Tooth10.rotateAngleY = this.JawTop.rotateAngleY;
/* 631 */     this.Tooth1.rotationPointZ = this.JawTop.rotationPointZ;
/* 632 */     this.Tooth1.rotationPointX = this.JawTop.rotationPointX;
/* 633 */     this.Tooth1.rotateAngleY = this.JawTop.rotateAngleY;
/* 634 */     this.Tooth8.rotationPointZ = this.JawTop.rotationPointZ;
/* 635 */     this.Tooth8.rotationPointX = this.JawTop.rotationPointX;
/* 636 */     this.Tooth8.rotateAngleY = this.JawTop.rotateAngleY;
/* 637 */     this.Tooth4.rotationPointZ = this.JawTop.rotationPointZ;
/* 638 */     this.Tooth4.rotationPointX = this.JawTop.rotationPointX;
/* 639 */     this.Tooth4.rotateAngleY = this.JawTop.rotateAngleY;
/* 640 */     this.Tooth3.rotationPointZ = this.JawTop.rotationPointZ;
/* 641 */     this.Tooth3.rotationPointX = this.JawTop.rotationPointX;
/* 642 */     this.Tooth3.rotateAngleY = this.JawTop.rotateAngleY;
/* 643 */     this.Tooth5.rotationPointZ = this.JawTop.rotationPointZ;
/* 644 */     this.Tooth5.rotationPointX = this.JawTop.rotationPointX;
/* 645 */     this.Tooth5.rotateAngleY = this.JawTop.rotateAngleY;
/* 646 */     this.Tooth6.rotationPointZ = this.JawTop.rotationPointZ;
/* 647 */     this.Tooth6.rotationPointX = this.JawTop.rotationPointX;
/* 648 */     this.Tooth6.rotateAngleY = this.JawTop.rotateAngleY;
/* 649 */     this.Tooth7.rotationPointZ = this.JawTop.rotationPointZ;
/* 650 */     this.Tooth7.rotationPointX = this.JawTop.rotationPointX;
/* 651 */     this.Tooth7.rotateAngleY = this.JawTop.rotateAngleY;
/* 652 */     this.Tooth2.rotationPointZ = this.JawTop.rotationPointZ;
/* 653 */     this.Tooth2.rotationPointX = this.JawTop.rotationPointX;
/* 654 */     this.Tooth2.rotateAngleY = this.JawTop.rotateAngleY;
/*     */     
/* 656 */     this.Hat1.rotationPointZ = this.JawTop.rotationPointZ;
/* 657 */     this.Hat1.rotationPointX = this.JawTop.rotationPointX;
/* 658 */     this.Hat1.rotateAngleY = this.JawTop.rotateAngleY;
/* 659 */     this.Hat2.rotationPointZ = this.JawTop.rotationPointZ;
/* 660 */     this.Hat2.rotationPointX = this.JawTop.rotationPointX;
/* 661 */     this.Hat2.rotateAngleY = this.JawTop.rotateAngleY;
/*     */     
/* 663 */     this.Neck.rotationPointZ -= (float)Math.cos(this.Neck.rotateAngleY) * 3.0F;
/* 664 */     this.Neck.rotationPointX -= (float)Math.sin(this.Neck.rotateAngleY) * 3.0F;
/* 665 */     this.BottomJaw.rotateAngleY = (float)Math.toRadians(f3) * 0.5F;
/* 666 */     this.Tooth9.rotationPointZ = this.BottomJaw.rotationPointZ;
/* 667 */     this.Tooth9.rotationPointX = this.BottomJaw.rotationPointX;
/* 668 */     this.Tooth9.rotateAngleY = this.BottomJaw.rotateAngleY;
/* 669 */     this.Tooth16.rotationPointZ = this.BottomJaw.rotationPointZ;
/* 670 */     this.Tooth16.rotationPointX = this.BottomJaw.rotationPointX;
/* 671 */     this.Tooth16.rotateAngleY = this.BottomJaw.rotateAngleY;
/* 672 */     this.Tooth15.rotationPointZ = this.BottomJaw.rotationPointZ;
/* 673 */     this.Tooth15.rotationPointX = this.BottomJaw.rotationPointX;
/* 674 */     this.Tooth15.rotateAngleY = this.BottomJaw.rotateAngleY;
/* 675 */     this.Tooth14.rotationPointZ = this.BottomJaw.rotationPointZ;
/* 676 */     this.Tooth14.rotationPointX = this.BottomJaw.rotationPointX;
/* 677 */     this.Tooth14.rotateAngleY = this.BottomJaw.rotateAngleY;
/* 678 */     this.Tooth13.rotationPointZ = this.BottomJaw.rotationPointZ;
/* 679 */     this.Tooth13.rotationPointX = this.BottomJaw.rotationPointX;
/* 680 */     this.Tooth13.rotateAngleY = this.BottomJaw.rotateAngleY;
/* 681 */     this.Tooth12.rotationPointZ = this.BottomJaw.rotationPointZ;
/* 682 */     this.Tooth12.rotationPointX = this.BottomJaw.rotationPointX;
/* 683 */     this.Tooth12.rotateAngleY = this.BottomJaw.rotateAngleY;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 691 */     this.BodyBack.render(f5);
/* 692 */     this.TopBackLeftLeg.render(f5);
/* 693 */     this.TailTip.render(f5);
/* 694 */     this.BodyFront.render(f5);
/* 695 */     this.TailBase1.render(f5);
/* 696 */     this.Tail2.render(f5);
/* 697 */     this.Tail3.render(f5);
/* 698 */     this.Tail4.render(f5);
/* 699 */     this.Neck.render(f5);
/* 700 */     this.TopFrontLeftLeg.render(f5);
/* 701 */     this.TopBackRightLeg.render(f5);
/* 702 */     this.BottomBackRightLeg.render(f5);
/* 703 */     this.TopFrontRightLeg.render(f5);
/* 704 */     this.BottomBackLeftLeg.render(f5);
/* 705 */     this.BottomFrontRightLeg.render(f5);
/* 706 */     this.BottomFrontLeftLeg.render(f5);
/* 707 */     this.BodyCenter.render(f5);
/* 708 */     this.Toe7.render(f5);
/* 709 */     this.Toe6.render(f5);
/* 710 */     this.BackLeftFoot.render(f5);
/* 711 */     this.Toe4.render(f5);
/* 712 */     this.Toe5.render(f5);
/* 713 */     this.BackRightFoot.render(f5);
/* 714 */     this.Toe8.render(f5);
/* 715 */     this.Toe1.render(f5);
/* 716 */     this.FrontLeftFoot.render(f5);
/* 717 */     this.Toe3.render(f5);
/* 718 */     this.Toe2.render(f5);
/* 719 */     this.FrontRightFoot.render(f5);
/* 720 */     this.FinRidge7.render(f5);
/* 721 */     this.FinRidge6.render(f5);
/* 722 */     this.FinRidge5.render(f5);
/* 723 */     this.FinRidge4.render(f5);
/* 724 */     this.FinRidge3.render(f5);
/* 725 */     this.FinRidge2.render(f5);
/* 726 */     this.FinRidge1.render(f5);
/* 727 */     this.Tooth11.render(f5);
/* 728 */     this.Tooth10.render(f5);
/* 729 */     this.Tooth8.render(f5);
/* 730 */     this.Tooth7.render(f5);
/* 731 */     this.Tooth6.render(f5);
/* 732 */     this.Tooth5.render(f5);
/* 733 */     this.Tooth4.render(f5);
/* 734 */     this.Tooth3.render(f5);
/* 735 */     this.Tooth2.render(f5);
/* 736 */     this.CenterRightNose.render(f5);
/* 737 */     this.CenterLeftNose.render(f5);
/* 738 */     this.Tooth1.render(f5);
/* 739 */     this.BottomNose.render(f5);
/* 740 */     this.TopNose.render(f5);
/* 741 */     this.JawTop.render(f5);
/* 742 */     this.CenterMiddleNose.render(f5);
/* 743 */     this.RightEye.render(f5);
/* 744 */     this.LeftEye.render(f5);
/* 745 */     this.Tooth16.render(f5);
/* 746 */     this.Tooth15.render(f5);
/* 747 */     this.Tooth14.render(f5);
/* 748 */     this.Tooth13.render(f5);
/* 749 */     this.Tooth12.render(f5);
/* 750 */     this.Tooth9.render(f5);
/* 751 */     this.BottomJaw.render(f5);
/* 752 */     if (e instanceof EntityCannonFodder && 
/* 753 */       e.get_is_activated() != 0) {
/* 754 */       this.Hat1.render(f5);
/* 755 */       if (e.get_is_activated() > 1) {
/* 756 */         this.Hat2.render(f5);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 764 */     this.Fin10.render(f5);
/* 765 */     this.Fin9.render(f5);
/* 766 */     this.Fin8.render(f5);
/* 767 */     this.Fin7.render(f5);
/* 768 */     this.Fin6.render(f5);
/* 769 */     this.Fin5.render(f5);
/* 770 */     this.Fin3.render(f5);
/* 771 */     this.Fin2.render(f5);
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
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 783 */     model.rotateAngleX = x;
/* 784 */     model.rotateAngleY = y;
/* 785 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 790 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelLizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */